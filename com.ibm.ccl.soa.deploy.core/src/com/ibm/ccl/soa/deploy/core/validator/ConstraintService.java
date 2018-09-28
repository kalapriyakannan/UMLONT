/***************************************************************************************************
 * Copyright (c) 2003, 2007 IBM Corporation Licensed Material - Property of IBM. All rights
 * reserved.
 * 
 * US Government Users Restricted Rights - Use, duplication or disclosure v1.0 restricted by GSA ADP
 * Schedule Contract with IBM Corp.
 * 
 * Contributors: IBM Corporation - initial API and implementation
 **************************************************************************************************/
package com.ibm.ccl.soa.deploy.core.validator;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.ISafeRunnable;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.MultiStatus;
import org.eclipse.core.runtime.SafeRunner;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.util.ExtendedMetaData;

import com.ibm.ccl.soa.deploy.core.Constraint;
import com.ibm.ccl.soa.deploy.core.ConstraintLink;
import com.ibm.ccl.soa.deploy.core.CoreFactory;
import com.ibm.ccl.soa.deploy.core.DeployCorePlugin;
import com.ibm.ccl.soa.deploy.core.DeployModelObject;
import com.ibm.ccl.soa.deploy.core.Requirement;
import com.ibm.ccl.soa.deploy.core.constraint.ShortConstraintDescriptor;
import com.ibm.ccl.soa.deploy.core.util.ConstraintUtil;
import com.ibm.ccl.soa.deploy.core.validator.constraints.ConstraintValidator;
import com.ibm.ccl.soa.deploy.core.validator.matcher.LinkMatcher;
import com.ibm.ccl.soa.deploy.core.validator.status.DeployCoreStatusFactory;
import com.ibm.ccl.soa.deploy.core.validator.status.ICoreProblemType;
import com.ibm.ccl.soa.deploy.internal.core.DeployCoreMessages;
import com.ibm.ccl.soa.deploy.internal.core.extension.ConstraintDescriptor;
import com.ibm.ccl.soa.deploy.internal.core.extension.ConstraintManager;
import com.ibm.ccl.soa.deploy.internal.core.extension.ConstraintManager.ConstraintInstanceKey;

/**
 * Constraint Service that manages the objects defined in the 'constraints' extension point.
 * Provided methods to validate a constraint and other constraint-related methods.
 * 
 * Implementation assumes that ConstraintManager loads all constraint extension declarations at
 * start-up.
 */
public class ConstraintService {

	/**
	 * Maps constraint EClass to the list of validators defined for this constraint type.
	 */
	private final Map<EClass, List<ConstraintValidator>> constraintEClassToValidatorListMap = new ConcurrentHashMap<EClass, List<ConstraintValidator>>();

	/**
	 * Maps constraint EClass to the list of validators defined for this constraint type and its
	 * supertype, the validators in the list are ordered from constraint supertypes to subtypes.
	 */
	private final Map<EClass, List<ConstraintValidator>> constraintEClassToValidatorListWithSupertypesMap = new ConcurrentHashMap<EClass, List<ConstraintValidator>>();

	/**
	 * Maps Java class name of a constraint validator to a ConstraintDescriptor of the validator.
	 */
	private final Map<String, ConstraintDescriptor> constraintValidatorNameToConstraintDescriptorMap = new ConcurrentHashMap<String, ConstraintDescriptor>();

	private List<LinkMatcher> cachedLinkMatchers;

	/**
	 * Shared instance of the Constraint Service.
	 */
	public static final ConstraintService INSTANCE = new ConstraintService();

	/**
	 * Public constructor.
	 */
	public ConstraintService() {
	}

	/**
	 * Validates the constraint.
	 * 
	 * 1. Compute the set of validators for which all 4 conditions hold: (a) the validator is
	 * registered for this constraint type or its supertype; (b)
	 * validator.canValidateConstraint(constraint) == true; (c) parent DMO is valid; (d) the context
	 * is valid.
	 * 
	 * 2. If the set of applicable validators is emty -> report an error; else validate the
	 * constraint with all validators in the set (in the order of validators for supertypes -->
	 * validators for subtypes), each consecutive validator takes as input IStatus produced by the
	 * previous validator; it's up to the validator to return it (i.e., by adding to a Multistatus)
	 * or not.
	 * 
	 * @param constraint
	 *           constraint to validate.
	 * @param context
	 *           the context in which the constraint should be validated.
	 * @param monitor
	 *           progress monitor
	 * @return the validation status, instance of {@link MultiStatus} if maltiple statuses.
	 */
	public IStatus validate(final Constraint constraint, final DeployModelObject context,
			final IProgressMonitor monitor) {

		DeployModelObject parentDmo = constraint.getParent();

		// compute the set of validators that will be used to validate this constraint
		ArrayList<ConstraintValidator> applicableValidators = new ArrayList<ConstraintValidator>();
		boolean parentInvalid = false;
		boolean contextInvalid = false;

		for (ConstraintValidator cv : getValidatorsForTypeAndSupertypes(constraint.eClass())) {
			if (cv.canValidateConstraint(constraint)) {

				String validatorName = cv.getClass().getName();
				ConstraintDescriptor cd = constraintValidatorNameToConstraintDescriptorMap
						.get(validatorName);
				if (cd == null) {
					// there is no constraint descriptor for this validator instance
					// strange, should have never happened... continue
					continue;
				}

				// validate that the parentDmo is legal
				if (!cd.isParentLegal(parentDmo)) {
					// for at least one validator the parent is invalid 
					parentInvalid = true;
					continue;
				}

				// validate that the validation context is legal
				if (!cd.isContextLegal(context)) {
					// for at least one validator the context is invalid 
					contextInvalid = true;
				}

				// this validator can validate the constraint
				applicableValidators.add(cv);
			}
		}

		if (applicableValidators.size() == 0) {
			// have no validators that can validate this constraint
			if (parentInvalid) {
				// if there was at least one invalid placement - report it
				return ConstraintUtil.createInvalidConstraintPlacementStatus(constraint, parentDmo);
			}
			if (contextInvalid) {
				// if there was at least one invalid context - report it
				return ConstraintUtil.createInvalidContextStatus(constraint, context);
			}

			// we do not have validators at all ...
			return DeployCoreStatusFactory.INSTANCE.createDeployStatus(IStatus.WARNING,
					ConstraintService.class.getSimpleName(), ICoreProblemType.CONSTRAINT_NO_VALIDATOR,
					DeployCoreMessages.Constraint_type_0_has_no_validator, new Object[] { constraint
							.eClass().getInstanceClassName() }, constraint);
		}

		// now validate the constraint by all the validators
		final IStatus[] statusRef = new IStatus[1];
		for (final ConstraintValidator cv : applicableValidators) {
			SafeRunner.run(new ISafeRunnable() {
				public void run() throws Exception {
					try {
						statusRef[0] = cv.validate(constraint, context, monitor, statusRef[0]);
					} catch (AssertionError e) {
						handleException(e);
					}
				}

				public void handleException(Throwable e) {
					statusRef[0] = DeployCorePlugin.createErrorStatus(0, e.getMessage(), e);
				}
			});
		}
		return statusRef[0];
	}

	/**
	 * This method is an alternative version of validation that is used when the constraint
	 * participates in some external matching process (e.g., hosting link matching). For example,
	 * Requirement Expression is validated differently during the proper validation process and
	 * during the validation that participates in the hosting/dependency link matching.
	 * 
	 * Implementation is identical to the validate() method, except that it invokes
	 * {@link ConstraintValidator#validateForPotentialMatch(Constraint, DeployModelObject)} on
	 * validators.
	 * 
	 * @param constraint
	 *           constraint to validate.
	 * @param context
	 *           the context in which the constraint should be validated.
	 * @return validation status.
	 * 
	 */
	public IStatus validateForPotentialMatch(Constraint constraint, DeployModelObject context) {

		DeployModelObject parentDmo = constraint.getParent();

		// compute the set of validators that will be used to validate this constraint
		ArrayList<ConstraintValidator> applicableValidators = new ArrayList<ConstraintValidator>();
		boolean parentInvalid = false;
		boolean contextInvalid = false;

		for (ConstraintValidator cv : getValidatorsForTypeAndSupertypes(constraint.eClass())) {
			if (cv.canValidateConstraint(constraint)) {

				String validatorName = cv.getClass().getName();
				ConstraintDescriptor cd = constraintValidatorNameToConstraintDescriptorMap
						.get(validatorName);
				if (cd == null) {
					// there is no constraint descriptor for this validator instance
					// strange, should have never happened... continue
					continue;
				}

				// validate that the parentDmo is legal
				if (!cd.isParentLegal(parentDmo)) {
					// for at least one validator the parent is invalid 
					parentInvalid = true;
					continue;
				}

				// validate that the validation context is legal
				if (!cd.isContextLegal(context)) {
					// for at least one validator the context is invalid 
					contextInvalid = true;
				}

				// this validator can validate the constraint
				applicableValidators.add(cv);
			}
		}

		if (applicableValidators.size() == 0) {
			// have no validators that can validate this constraint
			if (parentInvalid) {
				// if there was at least one invalid placement - report it
				return ConstraintUtil.createInvalidConstraintPlacementStatus(constraint, parentDmo);
			}
			if (contextInvalid) {
				// if there was at least one invalid context - report it
				return ConstraintUtil.createInvalidContextStatus(constraint, context);
			}

			// we do not have validators at all ...
			return DeployCoreStatusFactory.INSTANCE.createDeployStatus(IStatus.WARNING,
					ConstraintService.class.getSimpleName(), ICoreProblemType.CONSTRAINT_NO_VALIDATOR,
					DeployCoreMessages.Constraint_type_0_has_no_validator, new Object[] { constraint
							.eClass().getInstanceClassName() }, constraint);
		}

		// now validate the constraint
		IStatus status = null;
		for (ConstraintValidator cv : applicableValidators) {
			status = cv.validateForPotentialMatch(constraint, context, status);
		}

		return status;
	}

	/**
	 * Produces the list of applicable (legal) child constraints for the given DMO.
	 * 
	 * @param parentDmo
	 *           the parent constraint
	 * @return list of applicable (legal) child constraints. May be an empty list, but never NULL.
	 */
	public List<ShortConstraintDescriptor> applicableConstraints(DeployModelObject parentDmo) {

		List<ShortConstraintDescriptor> applicableConstraints = new ArrayList<ShortConstraintDescriptor>();
		if (parentDmo == null) {
			return applicableConstraints;
		}

		boolean parentIsConstraint = parentDmo instanceof Constraint;

		List<ConstraintDescriptor> allConstraints = ConstraintManager.INSTANCE
				.getAllConstraintDescriptors();
		Set<ConstraintManager.ConstraintInstanceKey> addedConstraintInstanceKeys = new HashSet<ConstraintInstanceKey>();

		for (ConstraintDescriptor cd : allConstraints) {

			// AT 12/16/2007: Milestone V8M5: temporary disablement of RE appearing in the list of applicable constraints
			// in V8M6 RequirementExpressions will be removed
			if (cd.getId().equals("com.ibm.ccl.soa.deploy.core.RequirementExpression")) { //$NON-NLS-1$
				continue;
			}

			// check the validity of parent
			if (!cd.isParentLegal(parentDmo)) {
				continue;
			}

			DeployModelObject nonConstraintParent = ConstraintUtil.getNonConstraintParent(parentDmo);

			if (nonConstraintParent instanceof Requirement) {
				// Special case: non-constraint parent DMO is Requirement
				// We don't really have to do anything: if Requirement is a legal parent, <contextEnablement/> 
				// tells what should be the validation context: parent Requirement or target Capaibility
			} else {
				// check the validity of the validation context
				DeployModelObject validationContext;
				if (parentIsConstraint) {
					validationContext = ConstraintService.INSTANCE
							.getContextForChildConstraints((Constraint) parentDmo);
				} else {
					validationContext = parentDmo;
				}
				if (validationContext == null || !cd.isContextLegal(validationContext)) {
					continue;
				}
			}

			// both parent and validation context are legal
			// check that we don't have the descriptor that would create the same constraint instance 
			// already in the list of applicable constraints
			ConstraintManager.ConstraintInstanceKey key = new ConstraintManager.ConstraintInstanceKey(
					cd);
			if (!addedConstraintInstanceKeys.contains(key)) {
				applicableConstraints.add(new ShortConstraintDescriptorImpl(cd));
				addedConstraintInstanceKeys.add(key);
			}
		}
		if (parentIsConstraint) {
			// let the validators for the parent constraint filter further the list of applicable child constraints 
			for (ConstraintValidator cv : getValidators(parentDmo.eClass())) {
				if (cv.canValidateConstraint((Constraint) parentDmo)) {
					applicableConstraints = cv.applicableConstraints((Constraint) parentDmo,
							applicableConstraints);
				}
			}
		}
		Collections.sort(applicableConstraints);
		return applicableConstraints;
	}

	/**
	 * Produces the list of applicable (legal) child constraints that can be put on a constraint link
	 * connecting two given DMOs.
	 * 
	 * @param parent1
	 * @param parent2
	 * 
	 * @return list of applicable (legal) child constraints. May be an empty list, but never NULL.
	 */
	public List<ShortConstraintDescriptor> applicableConstraints(DeployModelObject parent1,
			DeployModelObject parent2) {
		ConstraintLink link = CoreFactory.eINSTANCE.createConstraintLink();
		link.setName("Orphan LL"); //$NON-NLS-1$
		link.setSource(parent1);
		link.setTarget(parent2);

		List<ShortConstraintDescriptor> listToReturn = applicableConstraints(link);
		link.setSource(null);
		link.setTarget(null);

		Collections.sort(listToReturn);
		return listToReturn;
	}

	/**
	 * Returns the validation context DMO that the constraint will use to evaluate its child
	 * constraints. Returns NULL, if no such context can be determined (e.g., if there are no
	 * validators associated with the constraint), or if no child constraints are allowed on the
	 * given constraint.
	 * 
	 * Implementation gets the first Constraint Validator that can validate the constraint and
	 * invokes {@link ConstraintValidator#getContextForChildConstraints(Constraint)} on it.
	 * 
	 * @param constraint
	 *           the constraint that that is being asked
	 * 
	 * @return Returns the validation context DMO that the constraint will use to evaluate its child
	 *         constraints. Returns NULL, if no such context can be determined, or if no child
	 *         constraints are allowed on the given constraint.
	 */
	public DeployModelObject getContextForChildConstraints(Constraint constraint) {

		for (ConstraintValidator cv : getValidators(constraint.eClass())) {
			if (cv.canValidateConstraint(constraint)) {
				return cv.getContextForChildConstraints(constraint);
			}
		}
		return null;
	}

	/**
	 * Returns the title of the specified constraint. Does not contextualize the constraint
	 * description with the title of its child constraints.
	 * 
	 * Implementation gets the first Constraint Validator that can validate the constraint and
	 * invokes {@link ConstraintValidator#title(Constraint)} on it.
	 * 
	 * @param constraint
	 *           the constraint whose title should be returned.
	 * @return the constraint title.
	 * 
	 * @see #titleWithContext(Constraint)
	 * 
	 */
	public String title(Constraint constraint) {
		for (ConstraintValidator cv : getValidators(constraint.eClass())) {
			if (cv.canValidateConstraint(constraint)) {
				return cv.title(constraint);
			}
		}
		return null;
	}

	/**
	 * Returns the title of the specified constraint in the context of its constraint children.
	 * Example: "hostname = 'foo'" + " " + " or " + "hostname = 'bar'"
	 * 
	 * Implementation gets the first Constraint Validator that can validate the constraint and
	 * invokes {@link ConstraintValidator#title(Constraint)} on it.
	 * 
	 * @param constraint
	 *           the constraint whose contextual title should be returned.
	 * @return the constraint title in the context of its children.
	 * 
	 * @see #title(Constraint)
	 */
	public String titleWithContext(Constraint constraint) {
		for (ConstraintValidator cv : getValidators(constraint.eClass())) {
			if (cv.canValidateConstraint(constraint)) {
				return cv.titleWithContext(constraint);
			}
		}
		return null;
	}

	/**
	 * Returns the list of instances of Link Matchers defined in the <linkMatcher/> element of the
	 * 'constraints' extension point. If no matchers registered, returns empty list.
	 * 
	 * @return list of LinkMatchers
	 */
	public synchronized List<LinkMatcher> getAllConstraintLinkMatchers() {
		if (cachedLinkMatchers != null) {
			return cachedLinkMatchers;
		}

		List<ConstraintDescriptor> cdList = ConstraintManager.INSTANCE.getAllConstraintDescriptors();
		List<LinkMatcher> matcherList = new ArrayList<LinkMatcher>();
		for (ConstraintDescriptor cd : cdList) {
			if (cd.hasLinkMatcherDefined()) {
				LinkMatcher matcher = cd.createLinkMatcher();
				if (matcher != null) {
					matcherList.add(matcher);
				}
			}
		}
		cachedLinkMatchers = Collections.unmodifiableList(matcherList);
		return cachedLinkMatchers;
	}

	/**
	 * Returns the list of (different) constraint validators for this constraint type. Will load all
	 * plug-ins that declare a constraint definition with the specified constraint type.
	 * 
	 * @param constraintEClass
	 *           EClass of the constraint
	 * @return list of constraint validator instances; the list may be empty, but never null
	 */
	public List<ConstraintValidator> getValidators(EClass constraintEClass) {

		if (constraintEClassToValidatorListMap.containsKey(constraintEClass)) {
			return constraintEClassToValidatorListMap.get(constraintEClass);
		}

		List<ConstraintValidator> validatorList = new ArrayList<ConstraintValidator>();
		String constraintNS = ExtendedMetaData.INSTANCE.getNamespace(constraintEClass);
		String constraintType = constraintEClass.getName();
		List<ConstraintDescriptor> descrList = ConstraintManager.INSTANCE
				.getConstraintDescriptorListForType(constraintNS, constraintType);

		// need to keep track of validators put, to filter out duplicate validators
		Set<String> seenValidatorNames = new HashSet<String>();
		for (ConstraintDescriptor cd : descrList) {
			ConstraintValidator validator = cd.createValidator();
			String validatorName = validator.getClass().getName();
			if (!seenValidatorNames.contains(validatorName)) {
				// add validator name to the list of seen names
				seenValidatorNames.add(validatorName);
				// add validators to the list
				validatorList.add(validator);
				// add ConstraintDescriptor to the map
				constraintValidatorNameToConstraintDescriptorMap.put(validatorName, cd);
			}
		}

		constraintEClassToValidatorListMap.put(constraintEClass, validatorList);
		return validatorList;
	}

	/**
	 * Returns the list of (different) constraint validators for this constraint type and its
	 * supertypes. Will load all plug-ins that declare a constraint definition (extension) with the
	 * specified constraint type or its supertypes. The order of validators in the list is from
	 * supertypes to subtypes.
	 * 
	 * @param constraintEClass
	 *           EClass of the constraint
	 * @return list of constraint validator instances; the list may be empty, but never null; the
	 *         order of validators in the list is from supertypes to subtypes.
	 */
	public List<ConstraintValidator> getValidatorsForTypeAndSupertypes(EClass constraintEClass) {

		if (constraintEClassToValidatorListWithSupertypesMap.containsKey(constraintEClass)) {
			return constraintEClassToValidatorListWithSupertypesMap.get(constraintEClass);
		}

		// the list of validators to return
		List<ConstraintValidator> validatorList = new ArrayList<ConstraintValidator>();

		List<EClass> superTypes = constraintEClass.getEAllSuperTypes();
		List<EClass> sortedTypes = new LinkedList<EClass>();

		// sort the list of supertypes from supertypes to subtypes
		for (EClass eclass : superTypes) {
			int i = 0;
			for (i = 0; i < sortedTypes.size(); i++) {
				if (eclass.isSuperTypeOf(sortedTypes.get(i))) {
					break;
				}
			}
			sortedTypes.add(i, eclass);
		}
		// add the constraint EClass itself
		sortedTypes.add(constraintEClass);

		Set<String> seenValidatorNames = new HashSet<String>();
		for (EClass eclass : sortedTypes) {

			String constraintNS = ExtendedMetaData.INSTANCE.getNamespace(eclass);
			String constraintType = eclass.getName();

			List<ConstraintDescriptor> descrList = ConstraintManager.INSTANCE
					.getConstraintDescriptorListForType(constraintNS, constraintType);

			// need to keep track of validators, to filter out duplicate validators
			for (ConstraintDescriptor cd : descrList) {
				ConstraintValidator validator = cd.createValidator();
				String validatorName = validator.getClass().getName();
				if (!seenValidatorNames.contains(validatorName)) {
					// add validator name to the list of seen names
					seenValidatorNames.add(validatorName);
					// add validators to the list
					validatorList.add(validator);
					// add ConstraintDescriptor to the map
					constraintValidatorNameToConstraintDescriptorMap.put(validatorName, cd);
				}
			}
		}

		constraintEClassToValidatorListWithSupertypesMap.put(constraintEClass, validatorList);
		return validatorList;
	}

	/**
	 * Returns one or several sets of child (or leaf) constraints on the given constraint that
	 * satisfy the overall constraint. The validation that is performed in the context may be
	 * relaxed, as if the validation has been performed for matching. The default implementation
	 * returns empty set, but constraint validators may override this method.
	 * 
	 * @param <T>
	 *           specific constraint type
	 * @param constraint
	 *           given constraint
	 * @param context
	 *           validation context
	 * @return the list of lists of child (or leaf) constraints, if not empty; empty list otherwise,
	 *         never null.
	 */
	public <T extends Constraint> List<List<T>> getSatisfyingChildConstraintsForMatch(
			Constraint constraint, DeployModelObject context) {
		for (ConstraintValidator cv : getValidators(constraint.eClass())) {
			if (cv.canValidateConstraint(constraint)) {
				return cv.getSatisfyingChildConstraintsForMatch(constraint, context);
			}
		}
		return Collections.emptyList();
	}

	///// ----------------------- inner classes ------------------------- ///////

	/**
	 * Implementation of the ShortConstraintDescriptor interface.
	 */
	private class ShortConstraintDescriptorImpl implements ShortConstraintDescriptor {

		private final ConstraintDescriptor descriptor;

		private ShortConstraintDescriptorImpl(ConstraintDescriptor aDescriptor) {
			descriptor = aDescriptor;
		}

		public String getId() {
			return descriptor.getId();
		}

		public String getNamespace() {
			return descriptor.getNamespace();
		}

		public String getType() {
			return descriptor.getType();
		}

		public String getTitle() {
			return descriptor.getDisplayName();
		}

		public Constraint createConstraint(DeployModelObject parent) {
			return descriptor.createConstraint(parent);
		}

		public String toString() {
			return getTitle();
		}

		public int hashCode() {
			if (descriptor == null) {
				return 0;
			}
			if (descriptor.getId() != null) {
				return descriptor.getId().hashCode();
			}
			if (descriptor.getType() != null) {
				return descriptor.getType().hashCode();
			}
			return 0;
		}

		public boolean equals(Object obj) {
			if (obj == null || !(obj instanceof ShortConstraintDescriptor)) {
				return false;
			}
			ShortConstraintDescriptor d1 = this;
			ShortConstraintDescriptor d2 = (ShortConstraintDescriptor) obj;
			return ValidatorUtils.equals(d1.getId(), d2.getId())
					&& ValidatorUtils.equals(d1.getNamespace(), d2.getNamespace())
					&& ValidatorUtils.equals(d1.getTitle(), d2.getTitle())
					&& ValidatorUtils.equals(d1.getType(), d2.getType());
		}

		public int compareTo(Object o) {
			ShortConstraintDescriptor d2 = (ShortConstraintDescriptor) o;
			String id1 = getTitle();
			if (id1 == null) {
				id1 = ""; //$NON-NLS-1$
			}
			String id2 = d2.getTitle();
			if (id2 == null) {
				id2 = ""; //$NON-NLS-1$
			}
			return id1.compareToIgnoreCase(id2);
		}
	}

	/**
	 * For the given constraint check the context enablements to determine if it is enablemed for the
	 * passed context.
	 * 
	 * @param constraint
	 *           A {@link Constraint} to test for context enablement.
	 * @param context
	 *           A {@link DeployModelObject} to test against context enablement conditions.
	 * @return True if the constraint is enabled for the context.
	 */
	public boolean isEnabledForContext(Constraint constraint, DeployModelObject context) {
		if (constraint == null || context == null) {
			return false;
		}
		EClass eclazz = constraint.getEObject().eClass();
		EPackage pack = eclazz.getEPackage();
		List<ConstraintDescriptor> descriptors = ConstraintManager.INSTANCE
				.getConstraintDescriptorListForType(pack.getNsURI(), eclazz.getName());
		for (ConstraintDescriptor constraintDescriptor : descriptors) {
			if (constraintDescriptor.isContextLegal(context)) {
				return true;
			}
		}
		return false;
	}
}
