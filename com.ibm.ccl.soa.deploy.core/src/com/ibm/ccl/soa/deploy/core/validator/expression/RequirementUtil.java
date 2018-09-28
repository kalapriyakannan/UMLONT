/***************************************************************************************************
 * Copyright (c) 2003, 2007 IBM Corporation Licensed Material - Property of IBM. All rights
 * reserved.
 * 
 * US Government Users Restricted Rights - Use, duplication or disclosure v1.0 restricted by GSA ADP
 * Schedule Contract with IBM Corp.
 * 
 * Contributors: IBM Corporation - initial API and implementation
 **************************************************************************************************/
package com.ibm.ccl.soa.deploy.core.validator.expression;

import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.List;

import org.eclipse.core.runtime.ISafeRunnable;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.MultiStatus;
import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.core.runtime.SafeRunner;
import org.eclipse.core.runtime.Status;
import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecore.util.ExtendedMetaData;

import com.ibm.ccl.soa.deploy.core.Capability;
import com.ibm.ccl.soa.deploy.core.CapabilityLinkTypes;
import com.ibm.ccl.soa.deploy.core.Constraint;
import com.ibm.ccl.soa.deploy.core.CoreFactory;
import com.ibm.ccl.soa.deploy.core.CorePackage;
import com.ibm.ccl.soa.deploy.core.DependencyLink;
import com.ibm.ccl.soa.deploy.core.DeployCorePlugin;
import com.ibm.ccl.soa.deploy.core.DeployCoreRoot;
import com.ibm.ccl.soa.deploy.core.DeployModelObject;
import com.ibm.ccl.soa.deploy.core.ExtendedAttribute;
import com.ibm.ccl.soa.deploy.core.Interface;
import com.ibm.ccl.soa.deploy.core.Reference;
import com.ibm.ccl.soa.deploy.core.Requirement;
import com.ibm.ccl.soa.deploy.core.RequirementExpression;
import com.ibm.ccl.soa.deploy.core.RequirementLinkTypes;
import com.ibm.ccl.soa.deploy.core.RequirementUsage;
import com.ibm.ccl.soa.deploy.core.Service;
import com.ibm.ccl.soa.deploy.core.constraint.ConstraintPackage;
import com.ibm.ccl.soa.deploy.core.constraint.EqualsConstraint;
import com.ibm.ccl.soa.deploy.core.constraint.OrConstraint;
import com.ibm.ccl.soa.deploy.core.constraint.TypeConstraint;
import com.ibm.ccl.soa.deploy.core.util.ConstraintUtil;
import com.ibm.ccl.soa.deploy.core.util.DeployNLS;
import com.ibm.ccl.soa.deploy.core.util.UnitUtil;
import com.ibm.ccl.soa.deploy.core.validator.ConstraintService;
import com.ibm.ccl.soa.deploy.core.validator.status.DeployCoreStatusFactory;
import com.ibm.ccl.soa.deploy.core.validator.status.ICoreProblemType;
import com.ibm.ccl.soa.deploy.core.validator.status.IDeployCoreValidators;
import com.ibm.ccl.soa.deploy.core.validator.status.IDeployStatus;
import com.ibm.ccl.soa.deploy.internal.core.DeployCoreMessages;

/**
 * Static factory methods for requirements.
 * <p>
 * TODO move to core.util
 */
public final class RequirementUtil {

	private RequirementUtil() {
		// static methods only.
	}

	/**
	 * Creates a requirement with {@link Equals} expressions for all the non-null values of the
	 * capability.
	 * <p>
	 * A <em>shalow</em> copy is performed. Links are not duplicated.
	 * 
	 * @param cap
	 *           a capability whose non-null values will be used in the requirement.
	 * @return the created requirement.
	 */
	public static Requirement createRequirement(Capability cap) {
		assert cap != null;
		Requirement req = CoreFactory.eINSTANCE.createRequirement();

		// Copy deploy model object attributes
		req.setDescription(cap.getDescription());
		req.setDisplayName(cap.getCaptionProvider().title(cap));
		req.setMutable(cap.isMutable());
		req.setName(cap.getName());

		// Set requirement type (isHosting will be set below)
		req.setDmoEType(cap.getEObject().eClass());

		// Set all attribute types declared in the Capability subtype.
		for (Iterator iter = cap.getEObject().eClass().getEAllAttributes().iterator(); iter.hasNext();) {
			EAttribute attr = (EAttribute) iter.next();
			if (CorePackage.eINSTANCE.getCapability().isSuperTypeOf(attr.getEContainingClass())) {
				if (attr == CorePackage.eINSTANCE.getCapability_LinkType()) {
					// Hosting handled explicitely
					if (cap.getLinkType().equals(CapabilityLinkTypes.HOSTING_LITERAL)
							|| cap.getLinkType().equals(CapabilityLinkTypes.ANY_LITERAL)) {
						req.setLinkType(RequirementLinkTypes.HOSTING_LITERAL);
					} else {
						req.setLinkType(RequirementLinkTypes.DEPENDENCY_LITERAL);
					}
				} //TODO AVK cleanup
				else {
					// All other attributes converted to an Equals expression.
					Object value = cap.eGet(attr);
					if (value != null) {
						RequirementExpression expr = CoreFactory.eINSTANCE.createRequirementExpression();
						expr = Equals.createExpression(attr, value);
						expr.setName(attr.getName());
						req.getExpressions().add(expr);
					}
				}
			}
		}

		return req;
	}

	/**
	 * Sets or adds the value of the attribute in an expression of the requirement.
	 * 
	 * @param req
	 *           the requirement in which the expression will be updated or added.
	 * @param attr
	 *           the attribute whose value is set.
	 * @param value
	 *           the attribute value.
	 * @return the requirement expression modified or added.
	 */
	public static RequirementExpression setAttribute(Requirement req, EAttribute attr, Object value) {
		assert req != null;
		assert attr != null;
		if (req.getDmoEType() != null && !req.getDmoEType().isSuperTypeOf(attr.getEContainingClass())) {
			throw new IllegalArgumentException(attr.getName() + " : " + req.getDmoEType().getName());//$NON-NLS-1$
		}
		if (value != null && !attr.getEAttributeType().isInstance(value)) {
			throw new IllegalArgumentException(value.toString() + " : " + value.getClass().getName());//$NON-NLS-1$
		}

		RequirementExpression expr = (RequirementExpression) req.getConstraint(attr.getName());
		if (expr == null) {
			expr = CoreFactory.eINSTANCE.createRequirementExpression();
			expr.setName(attr.getName());
			req.getExpressions().add(expr);
			UnitUtil.assignUniqueName(req);
		}
		Equals.setAttribute(expr, attr, value);
		return expr;
	}

	/**
	 * Validates the requirement against the capability.
	 * 
	 * @param req
	 *           a requirement expressing constraints on a capability.
	 * @param context
	 *           a capability object.
	 * @return the status of validation.
	 */
	public static IStatus validate(Requirement req, ReqEvaluationContext context) {
		return validate(req, context, true);
	}

	/**
	 * Validates the requirement against the capability.
	 * <p>
	 * Returns the status of validation. Use {@link IStatus#getSeverity()} to determine validity. If
	 * more than one requirement expressions fail, then the status will be a multi-status ({@link IStatus#isMultiStatus()}),
	 * and users should invoke {@link IStatus#getChildren()} to obtain the expression-level
	 * validation failures.
	 * 
	 * 
	 * @param req
	 *           a requirement expressing constraints on a capability.
	 * @param context
	 *           a capability object.
	 * @param relaxedRules
	 *           if true: relaxed validation rules are used for dependency and hosting links for
	 *           conceptual targets: (a) context DMO Type should be either subtype or supertype of
	 *           req. DMO type (b) validation of requirement expressions where the atribute was not
	 *           found is suppressed.
	 * @return the status of validation.
	 */
	public static IStatus validate(Requirement req, ReqEvaluationContext context,
			boolean relaxedRules) {
		assert req != null;
		assert context != null;

		// Check that the DMO type matches the context for all link types
		// <em>except</em> MEMBER where the context is the unit container of
		// the requirement.
		EClass dmoType = req.getDmoEType();
		if (dmoType != null && req.getLinkType() != RequirementLinkTypes.MEMBER_LITERAL) {

			EClass contextDmoType = context.getDmoEType();

			boolean typeMismatch = false;
			if (relaxedRules) {
				// AT 4/10/07 relaxed rules for hosting and dependency links for conceptual units
				typeMismatch = !(dmoType.isSuperTypeOf(contextDmoType) || context.isConceptual()
						&& contextDmoType.isSuperTypeOf(dmoType));
			} else {
				// regular rules
				typeMismatch = !dmoType.isSuperTypeOf(contextDmoType);
			}

			// relaxed rules for hosting and dependency links for conceptual units
			if (typeMismatch) {
				IDeployStatus status = DeployCoreStatusFactory.INSTANCE.createDeployStatus(
						IStatus.ERROR, IDeployCoreValidators.REQUIREMENT_UTIL_001,
						ICoreProblemType.REQUIREMENT_TYPE_MISMATCH,
						DeployCoreMessages.Validator_requirement_0_for_type_1_does_not_match_2,
						new Object[] { req, dmoType, contextDmoType }, req);
				return status;
			}
		}

		if (linkTypeCantMatchContext(req.getLinkType(), context)) {
			// TODO generalize error to any DMO (not just Capability)
			IDeployStatus status = DeployCoreStatusFactory.INSTANCE.createDeployStatus(
					IStatus.ERROR,
					// AT not sure ... IDeployCoreValidators.REQUIREMENT_UTIL_005,
					IDeployCoreValidators.REQUIREMENT_UTIL_005,
					ICoreProblemType.REQUIREMENT_LINK_TYPE_MISMATCH,
					DeployCoreMessages.Validator_requirement_0_type_mismatch_with_capability_1,
					new Object[] { req, context }, req);
			return status;
		}

		IStatus result = null;
		for (Constraint c : (List<Constraint>) req.getConstraints()) {

			IStatus status = null;
			if (c instanceof RequirementExpression) {
				// validate RE differently (in legacy code)
				status = validateRequirementExpression((RequirementExpression) c, context, relaxedRules);
			} else if (!ConstraintUtil.containsNonBooleanConstraintEnabledForContext(c, req)) {
				// validate constraint only if it is "Requirement-relevant"
				DeployModelObject cv = context.getValue();
				// If passed Capability for context and TypeConstraint and hosting req, convert context
				if (c instanceof TypeConstraint && cv instanceof Capability
						&& req.getLinkType().equals(RequirementLinkTypes.HOSTING_LITERAL)) {
					cv = cv.getParent();
				}
				status = ConstraintService.INSTANCE.validate(c, cv, new NullProgressMonitor());
			}

			if (status != null && status.getSeverity() != IStatus.OK) {
				if (result == null) {
					result = status;
				} else if (result instanceof MultiStatus) {
					((MultiStatus) result).add(status);
				} else {
					result = new MultiStatus(DeployCorePlugin.PLUGIN_ID, 0, new IStatus[] { result,
							status }, DeployCoreMessages.Model_consistency_status_message, null);
				}
			}
		}

		if (result == null) {
			//If the type is an extension to Requirement then delegate validation to the extended type.
			//In this case we only support Reference as an extension.
			//Will need to open up later if there is a need.
			if (req instanceof Reference) {
				result = validateReferenceExtensions((Reference) req, context);
			}
		}

		if (result == null) {
			result = Status.OK_STATUS;
		}
		return result;
	}

	/**
	 * Validates the requirement expression against the capability.
	 * <p>
	 * Returns the status of validation. Use {@link IStatus#getSeverity()} to determine validity. If
	 * more than one requirement expressions fail, then the status will be a multi-status ({@link IStatus#isMultiStatus()}),
	 * and users should invoke {@link IStatus#getChildren()} to obtain the expression-level
	 * validation failures.
	 * 
	 * @param expr
	 *           a requirement expression expressing a constraint on a capability.
	 * @param context
	 *           an evaluation context: a capability/unit object.
	 * @return the status of validation.
	 */
	public static IStatus validateRequirementExpression(RequirementExpression expr,
			ReqEvaluationContext context) {
		return validateRequirementExpression(expr, context, false);
	}

	/**
	 * Validates the requirement expression against the capability.
	 * <p>
	 * Returns the status of validation. Use {@link IStatus#getSeverity()} to determine validity. If
	 * more than one requirement expressions fail, then the status will be a multi-status ({@link IStatus#isMultiStatus()}),
	 * and users should invoke {@link IStatus#getChildren()} to obtain the expression-level
	 * validation failures.
	 * 
	 * 
	 * @param expr
	 *           a requirement expression expressing a constraint on a capability.
	 * @param context
	 *           an evaluation context: a capability/unit object.
	 * @param relaxedRules
	 *           if true: relaxed validation rules are used for for conceptual targets: (b) if
	 *           atribute in the target context was not found, the error is suppressed.
	 * @return the status of validation.
	 */
	public static IStatus validateRequirementExpression(final RequirementExpression expr,
			final ReqEvaluationContext context, boolean relaxedRules) {
		String interp = expr.getInterpreter();
		if (interp == null || interp.trim().length() == 0) {
			return DeployCoreStatusFactory.INSTANCE.createAttributeStatus(IStatus.ERROR,
					IDeployCoreValidators.REQUIREMENT_UTIL_002,
					ICoreProblemType.OBJECT_ATTRIBUTE_UNDEFINED,
					DeployCoreMessages.Validator_deploy_model_object_0_attribute_1_undefined,
					new Object[] { expr,
							CorePackage.Literals.REQUIREMENT_EXPRESSION__INTERPRETER.getName() }, expr,
					CorePackage.Literals.REQUIREMENT_EXPRESSION__INTERPRETER);
		}

		final IRequirementExpressionInterpreter interpreter = RequirementExpressionService.INSTANCE
				.getExpressionInterpreter(interp);

		// AT 4/20/07: Jazz defect 985 and relate issues
		AttributeStatusInternal attStatus = getAttributeStatus(expr, context);
		if (attStatus == AttributeStatusInternal.ATTRIBUTE_ERROR) {
			IStatus error = DeployCoreStatusFactory.INSTANCE.createDeployStatus(
					IStatus.ERROR,
					IDeployCoreValidators.REQUIREMENT_UTIL_004, // Not sure what this is supposed to be
					ICoreProblemType.REQUIREMENT_EXPRESSION_INVALID_ATTRIBUTE,
					DeployCoreMessages.Requirement_expression_0_attribute_1_not_found_on_object_2,
					new Object[] { expr, expr.getAttributeName(), null }, expr);

			return error;
		}

		// if the context is conceptual and it concerns an attribute, need to skip RE validation in certain cases
		if (context.isConceptual() && attStatus != AttributeStatusInternal.ATTRIBUTE_NOT_REFERRED) {
			if (relaxedRules && attStatus == AttributeStatusInternal.ATTRIBUTE_NOT_PRESENT) {
				return DeployCoreStatusFactory.INSTANCE.getOKStatus();
			}
			if (attStatus == AttributeStatusInternal.ATTRIBUTE_PRESENT_BUT_NOT_SET) {
				return DeployCoreStatusFactory.INSTANCE.getOKStatus();
			}
		}

		final IStatus[] errorRef = new IStatus[1];

		SafeRunner.run(new ISafeRunnable() {
			public void run() throws Exception {
				try {
					errorRef[0] = interpreter.validate(expr, context);
				} catch (AssertionError e) {
					handleException(e);
				}
			}

			public void handleException(Throwable e) {
				String message = DeployNLS
						.bind(
								DeployCoreMessages.Validator_requirement_expression_0_interpreter_1_evaluation_error_2,
								new Object[] { expr, expr.getInterpreter(),
										e.getClass().getName() + ": " + e.getMessage() }); //$NON-NLS-1$
				errorRef[0] = DeployCoreStatusFactory.INSTANCE.createAttributeStatus(IStatus.WARNING,
						IDeployCoreValidators.REQUIREMENT_UTIL_004,
						ICoreProblemType.OBJECT_ATTRIBUTE_INVALID, message, null, expr,
						CorePackage.Literals.REQUIREMENT_EXPRESSION__VALUE);
				if (!(e instanceof ConcurrentModificationException)) {
					DeployCorePlugin.log(IStatus.ERROR, 9, message, e);
				}
			}
		});
		return errorRef[0];
	}

	/**
	 * Returns a summary of non-optional requirements in the passed list of requirements. Useful in
	 * status descriptions and resolution descriptions. Defers to "description" or "displayName" if
	 * they are present, otherwise it assembles a list of DMO types. Includes a summary of top-level
	 * type constraints (implied AND).
	 * 
	 * @param reqList
	 * @return summary of non-optional requirements in the passed list of requirements
	 */
	public static String requirementsSummaryDescription(List<Requirement> reqList) {
		// TODO consider using or merging with PropertyUtils#getName().
		String retVal = ""; //$NON-NLS-1$
		for (Requirement req : reqList) {
			if (!req.getUse().equals(RequirementUsage.REQUIRED_LITERAL)) {
				continue;
			}
			if (retVal.length() > 0) {
				retVal += ", "; //$NON-NLS-1$
			}
			// If description is set, use it, else if display name is set, use it.
			if (req.getDescription() != null && req.getDescription().length() > 0) {
				retVal += req.getDescription();
				continue;
			} else if (req.getDisplayName() != null && req.getDisplayName().length() > 0) {
				retVal += req.getDisplayName();
				continue;
			} else if (req.getConstraints().size() == 0) {
				if (req.getDmoEType() != null) {
					retVal += req.getDmoEType().getName();
				} else {
					// promiscuous requirement
					retVal += "*"; //$NON-NLS-1$
				}
				continue;
			} else if (req.getDmoEType() != null
					&& !req.getDmoEType().isSuperTypeOf(CorePackage.eINSTANCE.getDeployModelObject())) {
				// There are constraints. Describe top-level type constraints. 
				// (Implied "and" constraints)
				// If requirement DMO type is a specific type, report it.
				retVal += req.getDmoEType().getName();
				continue;
			} else {
				// MK 7/5/2007 replaced use of iterator with explicit loop after finding problem with 
				// call to hasNext() after DeployModelObject.getConstraints(); cf. Jazz Defect 2521
				List<Constraint> constraints = req.getConstraints();
				for (int i = 0; i < constraints.size(); i++) {
					Constraint c = constraints.get(i);
//				for (Iterator<Constraint> constraintsIter = req.getConstraints().iterator(); constraintsIter
//						.hasNext();) {
//					Constraint c = constraintsIter.next();
					if (c instanceof TypeConstraint) {
						if (retVal.length() > 0 && !retVal.endsWith(", ")) { //$NON-NLS-1$
							retVal += ", "; //$NON-NLS-1$
						}
						if (c.getDescription() != null && c.getDescription().length() > 0) {
							retVal += c.getDescription();
						} else if (c.getDisplayName() != null && c.getDisplayName().length() > 0) {
							retVal += c.getDisplayName();
						} else if (((TypeConstraint) c).getDmoEType() != null) {
							retVal += ((TypeConstraint) c).getDmoEType().getName();
						} else {
							retVal += c.getName();
						}
					}
				}
			}
		}
		return retVal;
	}

	/**
	 * All Requirement level validations have already taken place. We only need to validate the
	 * interfaces at this point.
	 * 
	 * @param reference
	 *           reference
	 * @param context
	 *           context
	 * @return status
	 */
	public static IStatus validateReferenceExtensions(Reference reference,
			ReqEvaluationContext context) {
		IStatus status = Status.OK_STATUS;
		if (reference.getLinkType() != RequirementLinkTypes.DEPENDENCY_LITERAL) {
			// link type should be 'dependency'
			status = DeployCoreStatusFactory.INSTANCE.createDeployStatus(IStatus.ERROR,
					DeployCorePlugin.PLUGIN_ID, ICoreProblemType.REFERENCE_LINK_TYPE_INVALID,
					DeployCoreMessages.REFERENCE_LINK_TYPE_INVALID, new Object[] {}, reference);
			return status;
		}
		Interface sourceInterface = reference.getInterface();
		//Previous validations already checked DMO types.

		// MK 03-03-2008 - defect 5547 & 5576: 
		// This method may be called from the matcher (in which case the link has not been
		// created).  Moved this check to above the if statement so that it applies to all
		// clauses instead of just one.
		DeployModelObject o = reference.getLink();
		if (o == null) {
			o = reference;
		}

		Interface targetInterface = context.getCapability() instanceof Service ? ((Service) context
				.getCapability()).getInterface() : null;

		if (sourceInterface == null && targetInterface != null) {
			status = DeployCoreStatusFactory.INSTANCE.createDeployStatus(IStatus.ERROR,
					IDeployCoreValidators.REFERENCE_INTERFACE_002,
					ICoreProblemType.REFERENCE_LINKED_INTERFACE_MISMATCH,
					DeployCoreMessages.REFERENCE_LINKED_INTERFACE_MISMATCH, new Object[] {
							"", targetInterface.getDisplayString() }, o); //$NON-NLS-1$
		} else if (targetInterface == null && sourceInterface != null) {
			status = DeployCoreStatusFactory.INSTANCE.createDeployStatus(IStatus.ERROR,
					IDeployCoreValidators.REFERENCE_INTERFACE_003,
					ICoreProblemType.REFERENCE_LINKED_INTERFACE_MISMATCH,
					DeployCoreMessages.REFERENCE_LINKED_INTERFACE_MISMATCH, new Object[] {
							sourceInterface.getDisplayString(), "" }, o); //$NON-NLS-1$
		} else if (sourceInterface != null && !sourceInterface.isEquivalent(targetInterface)) {
			status = DeployCoreStatusFactory.INSTANCE.createDeployStatus(IStatus.ERROR,
					IDeployCoreValidators.REFERENCE_INTERFACE_001,
					ICoreProblemType.REFERENCE_LINKED_INTERFACE_MISMATCH,
					DeployCoreMessages.REFERENCE_LINKED_INTERFACE_MISMATCH, new Object[] {
							sourceInterface.getDisplayString(), targetInterface.getDisplayString() }, o);
		}
		return status;
	}

	private static boolean linkTypeCantMatchContext(RequirementLinkTypes linkType,
			ReqEvaluationContext context) {
		// If no link type, then we match automatically
		if (linkType == null) {
			// TODO This seems wrong...  Shouldn't we fail automatically?
			return false;
		}

		switch (linkType.getValue())
		{
		case RequirementLinkTypes.ANY:
			return context.getCapability().getLinkType() == null;
		case RequirementLinkTypes.HOSTING:
			return context.getCapability().getLinkType() != CapabilityLinkTypes.HOSTING_LITERAL
					&& context.getCapability().getLinkType() != CapabilityLinkTypes.ANY_LITERAL;
		case RequirementLinkTypes.DEPENDENCY:
			return context.getCapability().getLinkType() != CapabilityLinkTypes.DEPENDENCY_LITERAL
					&& context.getCapability().getLinkType() != CapabilityLinkTypes.ANY_LITERAL;
		case RequirementLinkTypes.MEMBER:
			return context.getUnit() == null;
		}

		// Unknown requirement types cannot match
		return true;
	}

	private static EClass getRequirementTypeFilter(Requirement req) {
		// TODO Handle refactoring into base and Capability requirement
		if (req.getDmoEType() != null) {
			return req.getDmoEType();
		}

		// Bind against any DeployModelObject if null
		return CorePackage.eINSTANCE.getDeployModelObject();
	}

	/**
	 * Check if the Requirement Expression constraints an attribute and whether this attribute is
	 * present in the context and is set.
	 * 
	 * @param expr
	 *           RequirementExpression
	 * @param context
	 *           context
	 * @return status of
	 * 
	 */
	private static AttributeStatusInternal getAttributeStatus(RequirementExpression expr,
			ReqEvaluationContext context) {
		assert expr != null;
		assert context != null;

		if (expr.getAttributeName() == null) {
			// the RE does not refer to attribute
			return AttributeStatusInternal.ATTRIBUTE_NOT_REFERRED;
		}

		if (context.getCapability() != null) {
			// context is a capability
			EStructuralFeature esf = context.getCapability().eClass().getEStructuralFeature(
					expr.getAttributeName());
			if (esf instanceof EAttribute) {
				if (context.getCapability().eIsSet(esf)) {
					return AttributeStatusInternal.ATTRIBUTE_PRESENT_AND_SET;
				}
				return AttributeStatusInternal.ATTRIBUTE_PRESENT_BUT_NOT_SET;
			}

			// try extended atribute
			ExtendedAttribute ea = context.getCapability().getExtendedAttribute(
					expr.getAttributeName());
			if (ea != null) {
				if (ea.getValue() == null) {
					return AttributeStatusInternal.ATTRIBUTE_PRESENT_BUT_NOT_SET;
				}
				return AttributeStatusInternal.ATTRIBUTE_PRESENT_AND_SET;
			}
			return AttributeStatusInternal.ATTRIBUTE_NOT_PRESENT; // did not find this attribute

		} else if (context.getUnit() != null) {
			// context is a unit

			EAttribute attribute = (EAttribute) context.getUnit().eClass().getEStructuralFeature(
					expr.getAttributeName());
			if (attribute != null) {
				if (context.getUnit().eIsSet(attribute)) {
					return AttributeStatusInternal.ATTRIBUTE_PRESENT_AND_SET;
				}
				return AttributeStatusInternal.ATTRIBUTE_PRESENT_BUT_NOT_SET;
			}

			// try extended attribute
			ExtendedAttribute ea = context.getUnit().getExtendedAttribute(expr.getAttributeName());
			if (ea != null) {
				if (ea.getValue() == null) {
					return AttributeStatusInternal.ATTRIBUTE_PRESENT_BUT_NOT_SET;
				}
				return AttributeStatusInternal.ATTRIBUTE_PRESENT_AND_SET;
			}
			return AttributeStatusInternal.ATTRIBUTE_NOT_PRESENT; // did not find this attribute

		} else {
			// context is empty, which is wrong
			return AttributeStatusInternal.ATTRIBUTE_ERROR;
		}
	}

	/**
	 * Determines if type of requirement equals that of a capability.
	 * 
	 * @param req
	 *           a requirement expressing constraints on a capability.
	 * @param cap
	 *           a capability object.
	 * @return true if types equal; false if not set or unequal
	 */
	public static boolean isTypeEqual(Requirement req, Capability cap) {
		assert req != null;
		assert cap != null;

		if (req.getDmoEType() == null) {
			return false;
		}

		return req.getDmoEType().equals(cap.getEObject().eClass());
	}

	/**
	 * Returns true if the capability type of the requirement is a subtype of the EMF type.
	 * 
	 * @param req
	 *           the requirement whose {@link Requirement#getDmoEType()} is checked.
	 * @param type
	 *           the type to which it is compared.
	 * @return true if a subtype, false if null or not a subtype.
	 */
	public static boolean isCapabilityTypeSubtypeOf(Requirement req, EClass type) {
		assert req != null;
		assert type != null;
		assert CorePackage.eINSTANCE.getCapability().isSuperTypeOf(type);
		if (req.getDmoEType() == null) {
			return false;
		}
		return type.isSuperTypeOf(req.getDmoEType());
	}

	/**
	 * Returns a string representation of the requirement.
	 * 
	 * @param req
	 *           a requirement.
	 * @return a string representation of the requirement.
	 */
	public static String toString(Requirement req) {
		StringBuffer buffer = new StringBuffer();

		buffer.append("Requirement[name=");//$NON-NLS-1$
		buffer.append(req.getName());
		if (req.getExpressions().size() == 0) {
			buffer.append("] { }");//$NON-NLS-1$
		} else {
			buffer.append("] {");//$NON-NLS-1$

			for (Iterator iter = req.getExpressions().iterator(); iter.hasNext();) {
				RequirementExpression expr = (RequirementExpression) iter.next();
				buffer.append("\n\t");//$NON-NLS-1$
				buffer.append(expr.getAttributeName());
				buffer.append(' ');
				buffer.append(expr.getInterpreter());
				buffer.append(' ');
				buffer.append(expr.getValue());
			}
			buffer.append("\n}");//$NON-NLS-1$
		}
		return buffer.toString();
	}

	/**
	 * Returns the serialized QName of the EClass to be stored in
	 * {@link Requirement#setCapabilityType(Object)}.
	 * 
	 * @param type
	 *           a subtype of Capability.
	 * @param root
	 *           an instance of {@link DeployCoreRoot} which is the root of the XML document
	 * @return the serialized representation of the capability type.
	 * 
	 * @see #deserializeCapabilityType(Object)
	 */
	public static Object getQualifiedName(EClass type) {
		assert type != null;
		String prefix = type.getEPackage().getNsPrefix();
		StringBuffer qNameLiteral = new StringBuffer(prefix);
		qNameLiteral.append(':');
		qNameLiteral.append(ExtendedMetaData.INSTANCE.getName(type));
		return qNameLiteral.toString();
	}

	/**
	 * Maps the capability link type to the equivalent requirement link type.
	 * 
	 * @param linkType
	 *           a capability link type (may be null).
	 * @return the equivalent requirement link type (may be null).
	 */
	public static RequirementLinkTypes getRequirementLinkType(CapabilityLinkTypes linkType) {
		if (linkType == null) {
			return null;
		}
		switch (linkType.getValue())
		{
		case CapabilityLinkTypes.DEPENDENCY:
			return RequirementLinkTypes.DEPENDENCY_LITERAL;
		case CapabilityLinkTypes.HOSTING:
			return RequirementLinkTypes.HOSTING_LITERAL;
		case CapabilityLinkTypes.ANY:
			return RequirementLinkTypes.ANY_LITERAL;
		default:
			throw new RuntimeException(linkType.toString());
		}
	}

	/**
	 * Return the interpreter for a RequirementExpression.
	 * 
	 * @param expr
	 * @return the interpreter, or null
	 * @deprecated
	 */
	public static IRequirementExpressionInterpreter getInterpreter(RequirementExpression expr) {
		return RequirementExpressionService.INSTANCE.getExpressionInterpreter(expr);
	}

	/**
	 * No need to convert to discoverer service - only used after creating a dependency link in the
	 * topology being edited
	 * 
	 * Copies the value of an attribute on an EqualsConstraint to the capability.
	 * 
	 * @param link
	 *           a dependency link between a requirement and a capability.
	 * @param attribute
	 *           the capability attribute to be copied.
	 * @return true if the value was copied, false otherwise.
	 */
	public static boolean copyAttributeFromConstraintToCapability(DependencyLink link,
			EAttribute attribute) {
		assert link != null;
		assert attribute != null;
		if (link.getSource() == null) {
			return false;
		}
		if (link.getTarget() == null) {
			return false;
		}
		if (!attribute.getEContainingClass().isSuperTypeOf(link.getTarget().getEObject().eClass())) {
			throw new IllegalArgumentException(DeployNLS.getName(link.getTarget()));
		}

		EqualsConstraint ec = findEqualsConstraint(link.getSource(), attribute.getName());
//		RequirementExpression expr = getRequirementExpression(link.getSource(), attribute.getName());
		if (ec == null) {
			return false;
		}

		if (ec.getValue() == null) {
			link.getTarget().getEObject().eSet(attribute, null);
			return true;
		}

		try {
			Object value = EcoreUtil.createFromString(attribute.getEAttributeType(), ec.getValue());
			link.getTarget().getEObject().eSet(attribute, value);
			return true;
		} catch (Throwable e) {
			String message = DeployNLS.bind(DeployCoreMessages.ExceptionSettingAttribute_0,
					new Object[] { attribute.getName() });
			DeployCorePlugin.log(IStatus.ERROR, 0, message, e);
			return false;
		}
	}

	/**
	 * Find a {@see EqualsConstraint} on a DMO with a particular attribute name
	 * 
	 * @param dmo
	 *           the object
	 * @param attributeName
	 *           the desired attribute name
	 * @return the {@see EqualsConstraint} or null if none can be found
	 */
	public static EqualsConstraint findEqualsConstraint(DeployModelObject dmo, String attributeName) {
		for (Constraint c : ConstraintUtil.getConstraints(dmo,
				ConstraintPackage.Literals.EQUALS_CONSTRAINT)) {
			EqualsConstraint ec = (EqualsConstraint) c;
			if (attributeName.equals(ec.getAttributeName())) {
				return ec;
			}
		}
		return null;
	}

	private static class AttributeStatusInternal {

		private final int _status;

		private AttributeStatusInternal(int i) {
			_status = i;
		}

		private static AttributeStatusInternal ATTRIBUTE_ERROR = new AttributeStatusInternal(1);
		private static AttributeStatusInternal ATTRIBUTE_NOT_REFERRED = new AttributeStatusInternal(2);
		private static AttributeStatusInternal ATTRIBUTE_NOT_PRESENT = new AttributeStatusInternal(3);
		private static AttributeStatusInternal ATTRIBUTE_PRESENT_BUT_NOT_SET = new AttributeStatusInternal(
				4);
		private static AttributeStatusInternal ATTRIBUTE_PRESENT_AND_SET = new AttributeStatusInternal(
				5);
	}

	/**
	 * Return true if the "type" parameter is a supertype of (a) the Requirement's dmoEType if
	 * non-null (b) the dmoEType of all top level TypeConstraints (c) at least one TypeConstraint
	 * child of a top-level OR constraint with >= 1 TypeConstraint children.
	 * 
	 * @param req
	 *           Requirement to be tested
	 * @param type
	 *           type of requirement to be compared against. if null, method will return true.
	 * @return true if requirement matches type
	 */
	public static boolean isRequirementOfType(Requirement req, EClass type) {
		// TODO generalize to an arbitrary boolean tree of type constraints. 
		// TODO semantics of dmoType == null?
		if (type == null) {
			return true;
		}
		if (req.getDmoEType() != null && !type.isSuperTypeOf(req.getDmoEType())) {
			return false;
		}
		for (Constraint c : (List<Constraint>) req.getConstraints()) {
			if (c instanceof TypeConstraint) {
				if (((TypeConstraint) c).getDmoEType() != null
						&& !type.isSuperTypeOf(((TypeConstraint) c).getDmoEType())) {
					return false;
				}
			}
			if (c instanceof OrConstraint) {
				int typeConstraintCount = 0;
				boolean oredConstraintMatched = false;
				for (Constraint c2 : (List<Constraint>) c.getConstraints()) {
					if (c2 instanceof TypeConstraint) {
						++typeConstraintCount;
						if (((TypeConstraint) c2).getDmoEType() != null
								&& type.isSuperTypeOf(((TypeConstraint) c2).getDmoEType())) {
							oredConstraintMatched = true;
							break;
						}
					}
				}
				if (typeConstraintCount > 0 && !oredConstraintMatched) {
					return false;
				}
			}
		}

		return true;
	}

	/**
	 * Return true if the "type" parameter is a supertype of (a) the Requirement's dmoEType if
	 * non-null, and (b1) the dmoEType of at least one top level TypeConstraints or (b2) at least one
	 * TypeConstraint child of a top-level OR constraint with >= 1 TypeConstraint children.
	 * 
	 * @param req
	 *           Requirement to be tested
	 * @param type
	 *           type of requirement to be compared against. if null, method will return true.
	 * @return true if requirement matches type
	 */
	public static boolean includesConstraintOfType(Requirement req, EClass type) {
		// TODO generalize to an arbitrary boolean tree of type constraints. 
		// TODO semantics of dmoType == null?
		if (type == null) {
			return true;
		}
		if (req.getDmoEType() != null && !type.isSuperTypeOf(req.getDmoEType())) {
			return false;
		}
		int typeConstraintCount = 0;
		for (Constraint c : (List<Constraint>) req.getConstraints()) {
			if (c instanceof TypeConstraint) {
				++typeConstraintCount;
				if (((TypeConstraint) c).getDmoEType() != null) {
					if (type.isSuperTypeOf(((TypeConstraint) c).getDmoEType())) {
						return true;
					}
				}
			}
			if (c instanceof OrConstraint) {
				for (Constraint c2 : (List<Constraint>) c.getConstraints()) {
					if (c2 instanceof TypeConstraint) {
						++typeConstraintCount;
						if (((TypeConstraint) c2).getDmoEType() != null
								&& !type.isSuperTypeOf(((TypeConstraint) c2).getDmoEType())) {
							return true;
						}
					}
				}
			}
		}

		// If there were type constraints present and none matched, then false
		return typeConstraintCount > 0 ? false : true;
	}

	/**
	 * Return true if the "type" parameter is a supertype of (a) the Requirement's dmoEType if
	 * non-null (b) the dmoEType of all top level TypeConstraints (c) at least one TypeConstraint
	 * child of a top-level OR constraint with >= 1 TypeConstraint children.
	 * 
	 * @param req
	 *           Requirement to be tested
	 * @param type
	 *           type of requirement to be compared against. if null, method will return true.
	 * @return true if requirement matches type
	 */
	public static boolean doesRequirementSatisfyTypeOf(Requirement req, EClass type) {
		// TODO generalize to an arbitrary boolean tree of type constraints. 
		// TODO semantics of dmoType == null?
		if (type == null) {
			return true;
		}
		if (req.getDmoEType() != null && !req.getDmoEType().isSuperTypeOf(type)) {
			return false;
		}
		for (Constraint c : (List<Constraint>) req.getConstraints()) {
			if (c instanceof TypeConstraint) {
				if (((TypeConstraint) c).getDmoEType() != null
						&& !((TypeConstraint) c).getDmoEType().isSuperTypeOf(type)) {
					return false;
				}
			}
			if (c instanceof OrConstraint) {
				int typeConstraintCount = 0;
				boolean oredConstraintMatched = false;
				for (Constraint c2 : (List<Constraint>) c.getConstraints()) {
					if (c2 instanceof TypeConstraint) {
						++typeConstraintCount;
						if (((TypeConstraint) c2).getDmoEType() != null
								&& !((TypeConstraint) c2).getDmoEType().isSuperTypeOf(type)) {
							oredConstraintMatched = true;
							break;
						}
					}
				}
				if (typeConstraintCount > 0 && !oredConstraintMatched) {
					return false;
				}
			}
		}

		return true;
	}
}
