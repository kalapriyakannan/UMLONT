/***************************************************************************************************
 * Copyright (c) 2003, 2007 IBM Corporation Licensed Material - Property of IBM. All rights
 * reserved.
 * 
 * US Government Users Restricted Rights - Use, duplication or disclosure v1.0 restricted by GSA ADP
 * Schedule Contract with IBM Corp.
 * 
 * Contributors: IBM Corporation - initial API and implementation
 **************************************************************************************************/
package com.ibm.ccl.soa.deploy.core.validator.constraints;

import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.emf.ecore.EClass;

import com.ibm.ccl.soa.deploy.core.Capability;
import com.ibm.ccl.soa.deploy.core.Constraint;
import com.ibm.ccl.soa.deploy.core.CorePackage;
import com.ibm.ccl.soa.deploy.core.DeployLink;
import com.ibm.ccl.soa.deploy.core.DeployModelObject;
import com.ibm.ccl.soa.deploy.core.Topology;
import com.ibm.ccl.soa.deploy.core.Unit;
import com.ibm.ccl.soa.deploy.core.UnitDescriptor;
import com.ibm.ccl.soa.deploy.core.constraint.CollocationConstraint;
import com.ibm.ccl.soa.deploy.core.constraint.CollocationConstraintTypes;
import com.ibm.ccl.soa.deploy.core.constraint.ShortConstraintDescriptor;
import com.ibm.ccl.soa.deploy.core.provider.discovery.TopologyDiscovererService;
import com.ibm.ccl.soa.deploy.core.util.ConstraintUtil;
import com.ibm.ccl.soa.deploy.core.util.RealizationLinkUtil;
import com.ibm.ccl.soa.deploy.core.validator.ValidatorUtils;
import com.ibm.ccl.soa.deploy.core.validator.status.DeployCoreStatusFactory;
import com.ibm.ccl.soa.deploy.core.validator.status.ICoreProblemType;
import com.ibm.ccl.soa.deploy.core.validator.status.IDeployStatus;
import com.ibm.ccl.soa.deploy.internal.core.DeployCoreMessages;

/**
 * Validator to validate 'CollocationConstraint' constrait type.
 */
public class CollocationConstraintValidator extends ConstraintValidator {

	/**
	 * Static instance
	 */
	public static final CollocationConstraintValidator INSTANCE = new CollocationConstraintValidator();

	@Override
	protected String computeTypeName(Constraint constraint) {
		if (constraint instanceof CollocationConstraint) {
			CollocationConstraint cc = (CollocationConstraint) constraint;
			if (cc.getType().getValue() == CollocationConstraintTypes.COLLOCATION) {
				return "Collocation"; //$NON-NLS-1$
			} else {
				return "Anti-Collocation"; //$NON-NLS-1$
			}
		}
		return super.computeTypeName(constraint);
	}

	/**
	 * Validates the constraint by having only endpoint units.
	 * 
	 * @param constraint
	 *           the constraint
	 * @param sourceUnit
	 *           the source unit
	 * @param targetUnit
	 *           the target unit
	 * @param monitor
	 *           the progress monitor
	 * @return the status of the validation
	 */
	public IStatus validate(Constraint constraint, Unit sourceUnit, Unit targetUnit,
			IProgressMonitor monitor) {

		if (!canValidateConstraint(constraint)) {
			return CANCEL_STATUS;
		}
		CollocationConstraint theConstraint = (CollocationConstraint) constraint;

		// sourceUnit and targetUnit should be different units
		if (RealizationLinkUtil.getFinalRealization(sourceUnit).equals(
				RealizationLinkUtil.getFinalRealization(targetUnit))) {
			String message = null;
			if (theConstraint.getType() == CollocationConstraintTypes.COLLOCATION_LITERAL) {
				message = DeployCoreMessages.Collocation_constraint_0_different_units;
			} else {
				message = DeployCoreMessages.Anti_collocation_constraint_0_different_units;
			}
			return DeployCoreStatusFactory.INSTANCE.createDeployStatus(IStatus.ERROR, constraint
					.eClass().getName(), ICoreProblemType.CONSTRAINT_CONTEXT_INVALID, message,
					new Object[] { title(constraint) }, constraint);
		}

		EClass capType = theConstraint.getCapabilityEType();

		if (theConstraint.getCapabilityType() != null && capType == null) {
			return DeployCoreStatusFactory.INSTANCE.createDeployStatus(IStatus.ERROR, constraint
					.eClass().getName(), ICoreProblemType.CONSTRAINT_MALFORMED,
					DeployCoreMessages.Constraint_0_attribute_1_malformed, new Object[] {
							title(constraint), "capabilityType" }, constraint); //$NON-NLS-1$
		}
		if (capType == null) {
			capType = CorePackage.Literals.CAPABILITY;
		}

		Unit sourcePotentialHost = null;
		Unit targetPotentialHost = null;

		if (theConstraint.getType() == CollocationConstraintTypes.COLLOCATION_LITERAL) {
			// COLLOCATION

			String[] errorMessage = new String[1];
			sourcePotentialHost = searchTopmostHostByCapabilityType(sourceUnit, capType, monitor,
					errorMessage);
			if (errorMessage[0] != null) {
				// return ERROR with this error message
				return DeployCoreStatusFactory.INSTANCE.createDeployStatus(IStatus.ERROR, constraint
						.eClass().getName(), ICoreProblemType.CONSTRAINT_CONTEXT_INVALID,
						errorMessage[0], new Object[] { title(constraint) }, constraint);
			}
			targetPotentialHost = searchTopmostHostByCapabilityType(targetUnit, capType, monitor,
					errorMessage);
			if (errorMessage[0] != null) {
				// return ERROR with this error message
				return DeployCoreStatusFactory.INSTANCE.createDeployStatus(IStatus.ERROR, constraint
						.eClass().getName(), ICoreProblemType.CONSTRAINT_CONTEXT_INVALID,
						errorMessage[0], new Object[] { title(constraint) }, constraint);
			}
			if (monitor.isCanceled()) {
				return Status.CANCEL_STATUS;
			}

			if (sourcePotentialHost != sourceUnit && hasCapabilityType(sourcePotentialHost, capType)
					&& targetPotentialHost != targetUnit
					&& hasCapabilityType(targetPotentialHost, capType)) {

				// the capability is found on both sides
				if (sourcePotentialHost.equals(targetPotentialHost)) {
					return DeployCoreStatusFactory.INSTANCE.getOKStatus();
				}
				return createCollocationConstraintViolatedStatus(constraint);
			}

			if (sourcePotentialHost != sourceUnit && hasCapabilityType(sourcePotentialHost, capType)) {
				// capability is found on the source side, but not on the target side
				if (targetPotentialHost.getHostingOrAnyRequirements().isEmpty()) {
					return createCollocationConstraintViolatedStatus(constraint);
				}
				return createCanNotDecideStatus(constraint,
						DeployCoreMessages.Collocation_constraint_0_hosting_stack_incomplete);
			}

			if (targetPotentialHost != targetUnit && hasCapabilityType(targetPotentialHost, capType)) {
				// capability is found on the target side, but not on the source side
				if (sourcePotentialHost.getHostingOrAnyRequirements().isEmpty()) {
					return createCollocationConstraintViolatedStatus(constraint);
				}
				return createCanNotDecideStatus(constraint,
						DeployCoreMessages.Collocation_constraint_0_hosting_stack_incomplete);
			}

			// capability is not present on both sides

			if (!sourcePotentialHost.isConceptual()
					&& sourcePotentialHost.getHostingOrAnyRequirements().isEmpty()
					|| !targetPotentialHost.isConceptual()
					&& targetPotentialHost.getHostingOrAnyRequirements().isEmpty()) {
				return createCollocationConstraintViolatedStatus(constraint);
			}
			// both stacks are incomplete
			return createCanNotDecideStatus(constraint,
					DeployCoreMessages.Collocation_constraint_0_hosting_stack_incomplete);
		}

		// ANTI-COLLOCATION
		Unit[] sourceUnitHostingStackBottom = new Unit[1];
		Unit[] targetUnitHostingStackBottom = new Unit[1];
		String[] errorMessage = new String[1];
		sourcePotentialHost = searchBottommostHostByCapabilityType(sourceUnit, capType,
				sourceUnitHostingStackBottom, monitor, errorMessage);
		if (errorMessage[0] != null) {
			// return ERROR with this error message
			return DeployCoreStatusFactory.INSTANCE.createDeployStatus(IStatus.ERROR, constraint
					.eClass().getName(), ICoreProblemType.CONSTRAINT_CONTEXT_INVALID, errorMessage[0],
					new Object[] { title(constraint) }, constraint);
		}
		targetPotentialHost = searchBottommostHostByCapabilityType(targetUnit, capType,
				targetUnitHostingStackBottom, monitor, errorMessage);
		if (errorMessage[0] != null) {
			// return warning with this error message
			return DeployCoreStatusFactory.INSTANCE.createDeployStatus(IStatus.ERROR, constraint
					.eClass().getName(), ICoreProblemType.CONSTRAINT_CONTEXT_INVALID, errorMessage[0],
					new Object[] { title(constraint) }, constraint);
		}
		if (monitor.isCanceled()) {
			return Status.CANCEL_STATUS;
		}

		if (sourcePotentialHost != null && targetPotentialHost != null
				&& sourcePotentialHost.equals(targetPotentialHost)) {
			// the capability is found on both sides and the units are the same
			return createAntiCollocationConstraintViolatedStatus(constraint);
		}

		if (sourcePotentialHost == null && !sourceUnitHostingStackBottom[0].isConceptual()
				&& sourceUnitHostingStackBottom[0].getHostingOrAnyRequirements().isEmpty()) {
			// the capability is not found on the 'source unit' side, 
			// and the hosting stack of the source unit is complete 
			return DeployCoreStatusFactory.INSTANCE.getOKStatus();
		}

		if (targetPotentialHost == null && !targetUnitHostingStackBottom[0].isConceptual()
				&& targetUnitHostingStackBottom[0].getHostingOrAnyRequirements().isEmpty()) {
			// the capability is not found on the 'target unit' side, 
			// and the hosting stack of the target unit is complete 
			return DeployCoreStatusFactory.INSTANCE.getOKStatus();
		}

		if (!sourceUnitHostingStackBottom[0].isConceptual()
				&& sourceUnitHostingStackBottom[0].getHostingOrAnyRequirements().isEmpty()
				&& !targetUnitHostingStackBottom[0].isConceptual()
				&& targetUnitHostingStackBottom[0].getHostingOrAnyRequirements().isEmpty()) {
			return DeployCoreStatusFactory.INSTANCE.getOKStatus();
		}

		// one of the hosting stacks is incomplete
		return createCanNotDecideStatus(constraint,
				DeployCoreMessages.Anti_collocation_constraint_0_hosting_stack_incomplete);
	}

	public IStatus validate(Constraint constraint, DeployModelObject context,
			IProgressMonitor monitor) {
		if (!canValidateConstraint(constraint)) {
			return CANCEL_STATUS;
		}

		CollocationConstraint theConstraint = (CollocationConstraint) constraint;

		if (context == null) {
			return ConstraintUtil.createNullContextStatus(constraint);
		}

		if (!(context instanceof DeployLink)) {
			return ConstraintUtil.createInvalidContextStatus(constraint, context);
		}

		DeployLink link = (DeployLink) context;
		DeployModelObject source = link.resolve(link.getSourceURI());
		DeployModelObject target = link.resolve(link.getTargetURI());
		if (source == null) {
			return DeployCoreStatusFactory.INSTANCE.createDeployStatus(IStatus.WARNING, constraint
					.eClass().getName(), ICoreProblemType.LINK_SOURCE_UNDEFINED,
					DeployCoreMessages.Structural_constraint_0_link_source_undefined,
					new Object[] { title(constraint) }, constraint);
		}

		if (target == null) {
			return DeployCoreStatusFactory.INSTANCE.createDeployStatus(IStatus.WARNING, constraint
					.eClass().getName(), ICoreProblemType.LINK_TARGET_UNDEFINED,
					DeployCoreMessages.Structural_constraint_0_link_target_undefined,
					new Object[] { title(constraint) }, constraint);
		}

		Unit sourceUnit = ValidatorUtils.getUnit(source);
		Unit targetUnit = ValidatorUtils.getUnit(target);

		return validate(theConstraint, sourceUnit, targetUnit, monitor);
	}

	public List<ShortConstraintDescriptor> applicableConstraints(Constraint parentConstraint,
			List<ShortConstraintDescriptor> potentialConstraints) {
		// return new FilterList(potentialConstraints, new IObjectFilter() {
		//	public boolean accept(Object value) {
		// so far, don't want to restrict potential child constraints
		//		return true;
		//	}
		//});

		// don't allow child constraints
		return EMPTY_CONSTRAINT_LIST;
	}

	public boolean canValidateConstraint(Constraint constraint) {
		if (constraint instanceof CollocationConstraint) {
			return true;
		}
		return false;
	}

	/**
	 * Returns the first (top-most) host in the hosting stack of the unit that contains the given
	 * capability type. Returns the bottom unit of the hosting stack, even if it does not contain
	 * this capability. Returns NULL, if the the progress monitor is cancelled.
	 * 
	 * @param unit
	 * @param capType
	 * @param monitor
	 *           progress monitor
	 * @return potential host
	 */
	protected Unit searchTopmostHostByCapabilityType(Unit unit, EClass capType,
			IProgressMonitor monitor, String[] errorMessage) {
		Unit lastUnit = null;
		do {
			if (monitor.isCanceled()) {
				return null;
			}
			lastUnit = unit;
			unit = findHost(unit, unit.getTopology(), monitor, errorMessage);
			if (errorMessage[0] != null) {
				// return the error message
				return null;
			}
			if (unit != null && hasCapabilityType(unit, capType)) {
				return unit;
			}
		} while (unit != null);
		return lastUnit;
	}

	/**
	 * Returns the bottom-most unit in the hosting stack of the unit that contains the given
	 * capability type. Returns NULL if no such unit is present in the hosting stack. So returned
	 * unit ALWAYS contains the capability of the given type. Returns NULL, if the the progress
	 * monitor is cancelled.
	 * 
	 * hostingStackBottom[0] is the pointer to the bottom unit of the hosting stack, so it is never
	 * NULL.
	 * 
	 * @param unit
	 * @param capType
	 * @param hostingStackBottom
	 * @param monitor
	 *           progress monitor
	 * @param errorMessage
	 *           status[0] is a status (warning or error) that indicates that hosting stack has some
	 *           error(s), and the status needs to be returned immediately
	 * @return potential host
	 */
	protected Unit searchBottommostHostByCapabilityType(Unit unit, EClass capType,
			Unit[] hostingStackBottom, IProgressMonitor monitor, String[] errorMessage) {
		assert hostingStackBottom.length > 0;
		assert errorMessage.length > 0;
		if (unit == null) {
			return null;
		}
		Unit lastHostFound = null;
		Unit currHost = unit;
		if (hasCapabilityType(currHost, capType)) {
			lastHostFound = currHost;
		}
		do {
			if (monitor.isCanceled()) {
				return null;
			}
			currHost = findHost(unit, unit.getTopology(), monitor, errorMessage);
			if (errorMessage[0] != null) {
				// return the error message
				return null;
			}
			if (currHost == null) {
				hostingStackBottom[0] = (Unit) RealizationLinkUtil.getFinalRealization(unit);
			} else if (hasCapabilityType(currHost, capType)) {
				lastHostFound = currHost;
			}
			unit = currHost;
		} while (unit != null);
		return (Unit) RealizationLinkUtil.getFinalRealization(lastHostFound);
	}

	/**
	 * Returns true of the unit has the given capability type.
	 * 
	 * @param unit
	 * @param capType
	 * @return true of the unit containt capability of given type EClass false otherwise and if the
	 *         unit is null
	 */
	protected boolean hasCapabilityType(Unit unit, EClass capType) {
		if (unit == null) {
			return false;
		}
		for (Iterator<Capability> iter = unit.getCapabilities().iterator(); iter.hasNext();) {
			Capability cap = iter.next();
			if (capType.isSuperTypeOf(cap.eClass())) {
				return true;
			}
		}
		return false;
	}

	/**
	 * Create status reporing that collocation constraint is violated.
	 * 
	 * @param constraint
	 * @return IDeployStatus that the constraint is violated.
	 */
	protected IDeployStatus createCollocationConstraintViolatedStatus(Constraint constraint) {
		return DeployCoreStatusFactory.INSTANCE.createDeployStatus(IStatus.ERROR, constraint.eClass()
				.getName(), ICoreProblemType.CONSTRAINT_UNSATISFIED,
				DeployCoreMessages.Collocation_constraint_0_is_violated,
				new Object[] { title(constraint) }, constraint);
	}

	/**
	 * Create status reporing that anti-collocation constraint is violated.
	 * 
	 * @param constraint
	 * @return IDeployStatus that the constraint is violated.
	 */
	protected IDeployStatus createAntiCollocationConstraintViolatedStatus(Constraint constraint) {
		return DeployCoreStatusFactory.INSTANCE.createDeployStatus(IStatus.ERROR, constraint.eClass()
				.getName(), ICoreProblemType.CONSTRAINT_UNSATISFIED,
				DeployCoreMessages.Anti_collocation_constraint_0_is_violated,
				new Object[] { title(constraint) }, constraint);
	}

	protected IDeployStatus createCanNotDecideStatus(Constraint constraint, String unboundMsg) {
		return DeployCoreStatusFactory.INSTANCE.createDeployStatus(IStatus.INFO, constraint.eClass()
				.getName(), ICoreProblemType.CONSTRAINT_NOT_ENOUGH_INFO_TO_VALIDATE, unboundMsg,
				new Object[] { title(constraint) }, constraint);
	}

	public DeployModelObject getContextForChildConstraints(Constraint constraint) {
		// don't allow child constraints
		return null;
	}

	/**
	 * Need this method because semantics of the TopologyDiscovererService.findHost(...) method does
	 * not really help here.
	 * 
	 * Discovers all hosts of a unit. If there is only one physical (concrete) among them - return
	 * it. If there are more that one physical host - return an errorMessage. If there is an
	 * immediate (conceptual) host - return it, otherwise return an arbitrary (conceptual) host.
	 * 
	 * @param unit
	 * @param topology
	 * @param monitor
	 * @param errorMessage
	 *           errorMessage[0] is a status message (warning or error) that indicates that hosting
	 *           stack has some error(s), and the status needs to be returned immediately
	 * 
	 * @return host of the unit
	 */
	private Unit findHost(Unit unit, Topology topology, IProgressMonitor monitor,
			String[] errorMessage) {
		assert errorMessage.length > 0;
		List<UnitDescriptor> hostsUDs = TopologyDiscovererService.INSTANCE.findAllHosts(unit,
				topology, monitor);
		if (hostsUDs.size() == 0) {
			return null;
		}
		Set<Unit> hosts = new HashSet<Unit>();
		for (UnitDescriptor ud : hostsUDs) {
			hosts.add(ud.getUnitValue());
		}
		Unit physicalHost = null;
		for (Unit host : hosts) {
			if (!host.isConceptual()) {
				// host is physical
				if (physicalHost != null) {
					// already have one physical host
					errorMessage[0] = DeployCoreMessages.Hosting_constraint_0_stack_malformed;
					return null;
				}
				physicalHost = host;
			}
		}
		if (physicalHost != null) {
			return physicalHost;
		}
		// we have only conceptual hosts, try to return immediate host
		Unit immediateHost = ValidatorUtils.getImmediateHost(unit);
		if (immediateHost != null) {
			return immediateHost;
		}
		// no immediate host, but some conceptual host(s) through realization - return arbitrary one
		return hosts.iterator().next();
	}
}
