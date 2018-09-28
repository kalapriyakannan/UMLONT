package com.ibm.ccl.soa.deploy.core.validator.constraints;

import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;

import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.MultiStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.core.runtime.SubMonitor;
import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EDataType;
import org.eclipse.osgi.util.NLS;

import com.ibm.ccl.soa.deploy.core.Capability;
import com.ibm.ccl.soa.deploy.core.Constraint;
import com.ibm.ccl.soa.deploy.core.ConstraintLink;
import com.ibm.ccl.soa.deploy.core.ConvertedValue;
import com.ibm.ccl.soa.deploy.core.DeployCorePlugin;
import com.ibm.ccl.soa.deploy.core.DeployModelObject;
import com.ibm.ccl.soa.deploy.core.HostingLink;
import com.ibm.ccl.soa.deploy.core.IConstants;
import com.ibm.ccl.soa.deploy.core.IRelationshipChecker;
import com.ibm.ccl.soa.deploy.core.Topology;
import com.ibm.ccl.soa.deploy.core.Unit;
import com.ibm.ccl.soa.deploy.core.constraint.AttributeCapacityConstraint;
import com.ibm.ccl.soa.deploy.core.constraint.CapacityConstraint;
import com.ibm.ccl.soa.deploy.core.constraint.ConstraintPackage;
import com.ibm.ccl.soa.deploy.core.util.RealizationLinkUtil;
import com.ibm.ccl.soa.deploy.core.validator.ValidatorUtils;
import com.ibm.ccl.soa.deploy.core.validator.status.ICoreProblemType;
import com.ibm.ccl.soa.deploy.core.validator.status.IDeployAttributeValueStatus;
import com.ibm.ccl.soa.deploy.core.validator.status.IDeployStatus;
import com.ibm.ccl.soa.deploy.internal.core.DeployCoreMessages;
import com.ibm.ccl.soa.deploy.internal.core.validator.InternalConstraintValidator;
import com.ibm.ccl.soa.deploy.internal.core.validator.status.DeployAttributeCapacityStatus;
import com.ibm.ccl.soa.deploy.internal.core.validator.status.DeployAttributeStatus;
import com.ibm.ccl.soa.deploy.internal.core.validator.status.DeployAttributeValueStatus;

/**
 * The following validator works by applying an INFO status indicating that the target is
 * constrainted by some Unit in its hosting stack. Each INFO status knows if the Capacity
 * Restriction is exclusive or shared and what the restriction value is. Then in a second pass, the
 * INFO statuses are cycled through, adding up the values, and if the restriction isn't met, then a
 * WARNING status is added.
 * 
 * @since 7.0
 * 
 */
public class CapacityConstraintValidator extends TypeConstraintValidator implements
		InternalConstraintValidator {

	private static final String VALIDATOR_ID = CapacityConstraintValidator.class.getName();

	private static final String EXCEEDED_GROUP_ID = IConstants.DEFAULT_VALIDATOR_GROUP_ID; // VALIDATOR_ID + ".exceeded"; 

	private final AttributeCapacityConstraintValidator restrictionValidator = new AttributeCapacityConstraintValidator();

	public boolean canValidateConstraint(Constraint constraint) {
		// we test for strict instance rather than instanceof so we don't overlap with TypeConstraint
		return ConstraintPackage.Literals.CAPACITY_CONSTRAINT == constraint.getEObject().eClass();
	}

	@Override
	public String title(Constraint constraint) {
		CapacityConstraint tc = (CapacityConstraint) constraint;
		StringBuffer sb = new StringBuffer();
		sb.append(NLS.bind(
				DeployCoreMessages.CapacityConstraintValidator_Capacity_constraints_for_0_,
				getDisplayEType(tc.getDmoEType(), "*"))); //$NON-NLS-1$
		return sb.toString();
	}

	@Override
	public IStatus validate(Constraint constraint, DeployModelObject context,
			IProgressMonitor monitor) {
		if (canValidateConstraint(constraint)) {
			MultiStatus retval = new MultiStatus(DeployCorePlugin.PLUGIN_ID, 0, Status.OK_STATUS
					.getMessage(), null);
			SubMonitor submonitor = SubMonitor.convert(monitor);

			Unit unitContext = null;

			if (context instanceof ConstraintLink) {
				if (((ConstraintLink) context).getTarget() instanceof Unit) {
					unitContext = (Unit) ((ConstraintLink) context).getTarget();
				}
			} else if (context instanceof HostingLink) {
				unitContext = ((HostingLink) context).getTarget(); // hostee

			} else if (context instanceof Unit) {
				unitContext = (Unit) context;
			}

			Collection<DeployAttributeStatus> results = null;
			if (unitContext != null) {

				Topology editTopology = context.getEditTopology();
				IRelationshipChecker relationships = editTopology.getRelationships();

				// validate and return any Capacity Restrictions; later in the postProcess() 
				// step we will calculate Capacity Excesses
				results = validateEntryPointCapacity((CapacityConstraint) constraint, unitContext,
						relationships, retval, submonitor);
			}

			for (DeployAttributeStatus status : results) {
				retval.add(status);
			}
			return retval;
		}
		return Status.OK_STATUS;

	}

	public boolean postProcess(List<IDeployStatus> proposedStatuses) {

		Collection<IDeployStatus> excesses = computeExceededCapacityStatus(proposedStatuses);
		proposedStatuses.addAll(excesses);

		return !excesses.isEmpty() /* || duplicates.isEmpty() */;
	}

	private List<DeployAttributeStatus> validateTotalCapacity(CapacityConstraint constraint,
			Unit unitContext, IRelationshipChecker relationships, Collection<Unit> hostRoute,
			MultiStatus retval, SubMonitor monitor) {

		// Note: the following method traverses hosting stacks and deferred hosting stacks.
		// It will continue until it reaches the end of all hosting stacks down all possible 
		// hosting paths, alternating between hosting links and deferred hosting links.

		List<DeployAttributeStatus> results = new ArrayList<DeployAttributeStatus>();

		// we validate the realization of any source along the path to the final 
		// host, EXCEPT the realization of the original constrained source 
		// start with validateEntryPoint, which avoids checking realizations

		Collection<Unit> hosts = ValidatorUtils.getAllHosts(unitContext);
		if (!hosts.isEmpty()) {
			// there could be multiple hosting paths; we will validate each path
			for (Unit host : hosts) {
				if (monitor.isCanceled()) {
					return Collections.emptyList();
				}
				validateRoute(constraint, relationships, hostRoute, retval, monitor, results, host);
			}
		}
		return results;
	}

	private List<DeployAttributeStatus> validateEntryPointCapacity(CapacityConstraint constraint,
			Unit unitContext, IRelationshipChecker relationships, /* Unit suggestedOrigin, */
			MultiStatus retval, SubMonitor monitor) {

		// Note: the following method traverses hosting stacks and deferred hosting stacks.
		// It will continue until it reaches the end of all hosting stacks down all possible 
		// hosting paths, alternating between hosting links and deferred hosting links.

		List<DeployAttributeStatus> results = new ArrayList<DeployAttributeStatus>();

		// we don't validate realization links first, because the Validation system
		// will invoke this validator on the realized target of any constrainted source.

		Collection<Unit> realizations = ValidatorUtils.getFinalRealizations(unitContext);
		if (!realizations.isEmpty()) {
			// there could be multiple hosting paths; we will validate each path
			for (Unit realization : realizations) {
				if (monitor.isCanceled()) {
					return Collections.emptyList();
				}
				Collection<Unit> hostRoute = new ArrayList<Unit>();
				hostRoute.add(realization);
				validateRoute(constraint, relationships, hostRoute, retval, monitor, results,
						realization);
			}
		}
		return results;
	}

	private void validateRoute(CapacityConstraint constraint, IRelationshipChecker relationships,
			Collection<Unit> hostRoute, MultiStatus retval, SubMonitor monitor,
			List<DeployAttributeStatus> results, Unit host) {
		Collection<DeployAttributeStatus> restrictions = validateRestriction(constraint, host,
				monitor);
		// within each path, we have multiple Units in the hosting stack -- 
		if (restrictions.isEmpty()) {

			hostRoute.add(host);
			// continue down this stack 
			results.addAll(validateTotalCapacity(constraint, host, relationships, hostRoute, retval,
					monitor));
		} else {
			// copy the host route until this point
			for (DeployAttributeStatus result : restrictions) {
				if (result instanceof DeployAttributeCapacityStatus) {
					((DeployAttributeCapacityStatus) result).setHostRoute(hostRoute
							.toArray(new Unit[hostRoute.size()]));
				}
				results.addAll(restrictions);
			}
		}
	}

	/**
	 * Returns true if the given host matches the constraint EType of the given constraint.
	 * 
	 * @param constraint
	 * @param target
	 * @return The Statuses that apply to the target for the constraint.
	 */
	protected Collection<DeployAttributeStatus> validateRestriction(CapacityConstraint constraint,
			Unit target, SubMonitor monitor) {

		Collection<DeployAttributeStatus> results = new ArrayList<DeployAttributeStatus>(2);
		DeployModelObject scope = findScope(constraint, target);

		List<Constraint> restrictions = constraint.getConstraints();
		AttributeCapacityConstraint restriction = null;
		IStatus status = null;
		for (Constraint childConstraint : restrictions) {

			if (monitor.isCanceled()) {
				return Collections.emptyList();
			}
			if (childConstraint instanceof AttributeCapacityConstraint) {
				restriction = (AttributeCapacityConstraint) childConstraint;
				if (scope != null) {
					status = restrictionValidator.validate(restriction, scope, monitor);
					if (status.getSeverity() == IStatus.CANCEL) {
						return Collections.emptyList();
					} else if (!status.isOK() && status instanceof DeployAttributeCapacityStatus) {
						results.add((DeployAttributeCapacityStatus) status);
					}
				}

				// traverse the realization links
				DeployModelObject[] realizations = RealizationLinkUtil.getFinalRealizations(target);
				DeployModelObject realizationScope = null;
				for (DeployModelObject realization : realizations) {
					if (realization != target
							&& (realizationScope = findScope(constraint, realization)) != null) {
						status = restrictionValidator.validate(restriction, realizationScope, monitor);
						if (status.getSeverity() == IStatus.CANCEL) {
							return Collections.emptyList();
						} else if (!status.isOK() && status instanceof DeployAttributeCapacityStatus) {
							results.add((DeployAttributeCapacityStatus) status);
						}
					}
				}
			}
		}
		return results;
	}

	protected Collection<IDeployStatus> computeExceededCapacityStatus(
			Collection<IDeployStatus> appliedRestrictions) {

		CapacityTable capacityTable = new CapacityTable();

		Collection<IDeployStatus> capacityStatuses = new ArrayList<IDeployStatus>();
		Collection<DeployAttributeCapacityStatus> matchingStatuses = new HashSet<DeployAttributeCapacityStatus>();

		for (IDeployStatus status : appliedRestrictions) {

			if (!(status instanceof DeployAttributeCapacityStatus)) {
				continue;
			}
			final DeployModelObject deployObject = status.getDeployObject();

			DeployAttributeCapacityStatus restriction = (DeployAttributeCapacityStatus) status;

			matchingStatuses = findMatchingStatuses(ICoreProblemType.CAPACITY_RESTRICTION,
					appliedRestrictions, restriction.getAttributeType());

			if (deployObject.eIsSet(restriction.getAttributeType())) {
				capacityTable.add(deployObject, restriction);
			}

			for (DeployAttributeCapacityStatus matching : matchingStatuses) {
				capacityTable.add(matching.getDeployObject(), matching);
			}

			for (DeployModelObject target : capacityTable.keys()) {
				for (EAttribute attribute : capacityTable.attributes(target)) {
					if (target.eIsSet(attribute)) {

						Number value = convertValue(target.eGet(attribute), attribute.getEAttributeType());
						double total = capacityTable.total(target, attribute);
						if (value.doubleValue() < total) {
							addCapacityExceededStatus(capacityTable, capacityStatuses, target, attribute,
									total);
						}
					}
				}
			}
		}

		return capacityStatuses;

	}

	private void addCapacityExceededStatus(CapacityTable capacityTable,
			Collection<IDeployStatus> capacityStatuses, final DeployModelObject deployObject,
			EAttribute attribute, double totalDoubleValue) {

		Object value = ConvertedValue.parse(String.valueOf(totalDoubleValue),
				attribute.getEAttributeType()).convert();
		capacityStatuses.add(createExceededStatus(capacityTable, deployObject, attribute, value));
	}

	protected static double accumulateTotal(DeployAttributeCapacityStatus restriction,
			final DeployModelObject target, Collection<IDeployStatus> proposed) {
		Number expectedNumericalValue = convertValue(restriction.getAttributeExpectedValue(),
				restriction.getAttributeDataType());

		if (expectedNumericalValue != null) {
			Collection<DeployAttributeCapacityStatus> matchingStatuses = new ArrayList<DeployAttributeCapacityStatus>();

			matchingStatuses = findMatchingStatuses(ICoreProblemType.CAPACITY_RESTRICTION, proposed,
					restriction.getAttributeType());

			double exclusiveDoubleValue = restriction.isExclusive() ? expectedNumericalValue
					.doubleValue() : 0.0;
			double sharedDoubleValue = restriction.isExclusive() ? 0.0 : expectedNumericalValue
					.doubleValue();

			if (!matchingStatuses.isEmpty()) {

				Number matchingValue = null;
				for (DeployAttributeCapacityStatus match : matchingStatuses) {
					// compare by identity
					if (!match.equals(restriction)) {
						matchingValue = convertValue(match.getAttributeExpectedValue(), restriction
								.getAttributeDataType());
						if (match.isExclusive()) {
							exclusiveDoubleValue += matchingValue.doubleValue();
						} else if (sharedDoubleValue < matchingValue.doubleValue()) {
							sharedDoubleValue = matchingValue.doubleValue();
						}
					}
				}
			}

			double totalDoubleValue = exclusiveDoubleValue + sharedDoubleValue;
			return totalDoubleValue;
		}
		return 0.0;
	}

	protected static Collection<DeployAttributeCapacityStatus> findMatchingStatuses(
			String problemType, Collection<IDeployStatus> existingStatus, EAttribute attribute) {

		List<DeployAttributeCapacityStatus> results = null;
		if (existingStatus != null && !existingStatus.isEmpty()) {
			for (IStatus status : existingStatus) {
				if (status instanceof DeployAttributeCapacityStatus) {
					DeployAttributeCapacityStatus match = (DeployAttributeCapacityStatus) status;
					if (match.getAttributeType() == attribute
							&& problemType.equals(match.getProblemType())) {
						if (results == null) {
							results = new ArrayList<DeployAttributeCapacityStatus>(2);
						}
						results.add(match);
					}
				}
			}
		}
		if (results == null) {
			return Collections.emptyList();
		}
		return results;
	}

	/**
	 * Convert the given expected value to the given data type.
	 * 
	 * @param expectedValue
	 * @param dataType
	 * @return A Number object that encodes the expected value.
	 * @see ConvertedValue
	 */
	public static Number convertValue(Object expectedValue, EDataType dataType) {

		if (expectedValue == null) {
			return null;
		}

		Number expectedNumericalValue = null;
		if (expectedValue instanceof Number) {
			expectedNumericalValue = (Number) expectedValue;
		} else if (expectedValue instanceof String) {
			try {
				expectedNumericalValue = ConvertedValue.parse((String) expectedValue, dataType)
						.deconvert();
			} catch (NumberFormatException e) {
				expectedNumericalValue = null;
			}
		}
		return expectedNumericalValue;
	}

	@Override
	public IStatus validateForPotentialMatch(Constraint constraint, DeployModelObject context) {
		return Status.OK_STATUS;
	}

	protected DeployModelObject findScope(CapacityConstraint constraint, DeployModelObject target) {
		DeployModelObject scope = null;
		EClass dmoEType = constraint.getDmoEType();
		if (dmoEType.isInstance(target)) {
			scope = target;
		} else if (target instanceof Unit) {
			List<Capability> capabilities = ((Unit) target).getCapabilities();
			for (Capability c : capabilities) {
				if (dmoEType.isInstance(c)) {
					scope = c;
					break;
				}
			}
		}
		return scope;
	}

	protected static IStatus createRestrictionStatus(Unit source, DeployModelObject target,
			AttributeCapacityConstraint restriction, EAttribute attribute) {
		String unitCaption = source.getCaptionProvider().title(source);

		String unboundMessage = null;
		if (restriction.isExclusive()) {
			unboundMessage = DeployCoreMessages.CapacityConstraintValidator_Exclusive_capacity_restriction_leve_;
		} else {
			unboundMessage = DeployCoreMessages.CapacityConstraintValidator_Shared_capacity_restriction_leverag_;
		}

		DeployAttributeCapacityStatus status = new DeployAttributeCapacityStatus(IStatus.INFO,
				VALIDATOR_ID, ICoreProblemType.CAPACITY_RESTRICTION, unboundMessage, new String[] {
						restriction.getAttributeName(), restriction.getValue(), unitCaption }, target,
				attribute);

		status.setExclusive(restriction.isExclusive());
		status.setAttributeExpectedValue(restriction.getValue());
		status.setRestriction(restriction);
		status.setValidatorGroupID(EXCEEDED_GROUP_ID);

		// we add the constraints to the status so that the Structural Domain Validator 
		// can remove them when stale (e.g. the constraint was removed from the model)
		List<Constraint> constraints = new ArrayList<Constraint>();
		constraints.add(restriction);
		if (restriction.eContainer() instanceof CapacityConstraint) {
			constraints.add((Constraint) restriction.eContainer());
		}
		status.setConstraints(constraints);

		return status;
	}

	protected static DeployAttributeValueStatus createExceededStatus(CapacityTable capacityTable,
			DeployModelObject target, EAttribute attribute, Object value) {

		String unboundMessage = DeployCoreMessages.CapacityConstraintValidator_Capacity_restrictions_exceeded_for_;

		DeployAttributeValueStatus status = new DeployAttributeValueStatus(IStatus.WARNING,
				VALIDATOR_ID, ICoreProblemType.CAPACITY_EXCEEDED, unboundMessage, new String[] {
						attribute.getName(), NumberFormat.getInstance().format(value) }, target,
				attribute) {
			/*
			 * (non-Javadoc)
			 * 
			 * @seecom.ibm.ccl.soa.deploy.internal.core.validator.status.DeployAttributeValueStatus#
			 * equivalentValue
			 * (com.ibm.ccl.soa.deploy.core.validator.status.IDeployAttributeValueStatus)
			 */
			protected boolean equivalentValue(IDeployAttributeValueStatus as) {
				return true;
			}
		};

		status.setAttributeExpectedValue(value);
		status.setValidatorGroupID(EXCEEDED_GROUP_ID);

		// we add the constraints to the status so that the Structural Domain Validator 
		// can remove them when stale (e.g. the constraint was removed from the model)
		List<Constraint> constraints = new ArrayList<Constraint>();
		Collection<DeployAttributeCapacityStatus> observed = capacityTable.getObserved(attribute);
		for (DeployAttributeCapacityStatus cStatus : observed) {
			constraints.add(cStatus.getRestriction());
		}
		status.setConstraints(constraints);

		return status;
	}

}
