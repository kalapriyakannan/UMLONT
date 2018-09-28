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
import java.util.List;
import java.util.Set;

import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;

import com.ibm.ccl.soa.deploy.core.Constraint;
import com.ibm.ccl.soa.deploy.core.DeployLink;
import com.ibm.ccl.soa.deploy.core.DeployModelObject;
import com.ibm.ccl.soa.deploy.core.Requirement;
import com.ibm.ccl.soa.deploy.core.Topology;
import com.ibm.ccl.soa.deploy.core.Unit;
import com.ibm.ccl.soa.deploy.core.UnitDescriptor;
import com.ibm.ccl.soa.deploy.core.constraint.DeferredHostingConstraint;
import com.ibm.ccl.soa.deploy.core.constraint.ShortConstraintDescriptor;
import com.ibm.ccl.soa.deploy.core.provider.discovery.TopologyDiscovererService;
import com.ibm.ccl.soa.deploy.core.util.ConstraintUtil;
import com.ibm.ccl.soa.deploy.core.util.RealizationLinkUtil;
import com.ibm.ccl.soa.deploy.core.validator.ValidatorUtils;
import com.ibm.ccl.soa.deploy.core.validator.status.DeployCoreStatusFactory;
import com.ibm.ccl.soa.deploy.core.validator.status.ICoreProblemType;
import com.ibm.ccl.soa.deploy.internal.core.DeployCoreMessages;

/**
 * Validates {@link DeferredHostingConstraint}.
 * <p>
 * The deferred hosting constrained may be contained in a {@link DeployLink} or a
 * {@link Requirement}.
 */
public class DeferredHostingConstraintValidator extends ConstraintValidator {

	/**
	 * Static instance
	 */
	public static final DeferredHostingConstraintValidator INSTANCE = new DeferredHostingConstraintValidator();

	/**
	 * Validates the possibility/correctness of placemenet of this constraint type on the given DMO.
	 * 
	 * @param dmo
	 *           DeployModelObject containing constraint
	 * @return true of the constraint of this type can be put on
	 */
	public boolean isPlacementValidOnDMO(DeployModelObject dmo) {
		return dmo instanceof DeployLink || dmo instanceof Requirement;
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

		// sourceUnit and targetUnit should be different units
		if (RealizationLinkUtil.getFinalRealization(sourceUnit).equals(
				RealizationLinkUtil.getFinalRealization(targetUnit))) {
			return DeployCoreStatusFactory.INSTANCE.createDeployStatus(IStatus.ERROR, constraint
					.eClass().getName(), ICoreProblemType.CONSTRAINT_CONTEXT_INVALID,
					DeployCoreMessages.Deferred_hosting_constraint_0_different_units,
					new Object[] { title(constraint) }, constraint);
		}

		// Treat source as hostee
		Set<Unit> visitSet = new HashSet<Unit>();
		Unit currentUnit = sourceUnit;

		// need final realization of the targetUnit
		Unit targetUnitFinalRealization = (Unit) RealizationLinkUtil.getFinalRealization(targetUnit);

		while (currentUnit != null) {
			if (monitor.isCanceled()) {
				return Status.CANCEL_STATUS;
			}
			if (visitSet.contains(currentUnit)) {
				// hosting cycle found
				// TODO report error?
				// report error
				// don't have link here: will create status with the source unit as context
				return ConstraintUtil.createInvalidContextStatus(constraint, sourceUnit);
			}
			visitSet.add(currentUnit);

			if (currentUnit.equals(targetUnit) || currentUnit.equals(targetUnitFinalRealization)) {
				return Status.OK_STATUS;
			}

			String[] errorMessage = new String[1];
			Unit host = findHost(currentUnit, currentUnit.getTopology(), monitor, errorMessage);
			if (errorMessage[0] != null) {
				// return ERROR with this error message
				return DeployCoreStatusFactory.INSTANCE.createDeployStatus(IStatus.ERROR, constraint
						.eClass().getName(), ICoreProblemType.CONSTRAINT_CONTEXT_INVALID,
						errorMessage[0], new Object[] { title(constraint) }, constraint);
			}
			if (host == null) {
				break;
			}
			currentUnit = host;
		}

		// check do we have hosting requirement or not
		Unit bottomHost = (Unit) RealizationLinkUtil.getFinalRealization(currentUnit);
		if (targetUnitFinalRealization.isConceptual() || bottomHost.isConceptual()
				|| bottomHost.getHostingOrAnyRequirements().size() > 0) {
			// either of units is conceptual and may eventually be realized so that everything's OK, 
			// or the hosting stack of the hostee is incomplete
			return DeployCoreStatusFactory.INSTANCE.createDeployStatus(IStatus.INFO, constraint
					.eClass().getName(), ICoreProblemType.CONSTRAINT_NOT_ENOUGH_INFO_TO_VALIDATE,
					DeployCoreMessages.Deferred_hosting_constraint_0_hosting_stack_incomplete,
					new Object[] { title(constraint) }, constraint);
		}

		// hosting stack is complete
		return DeployCoreStatusFactory.INSTANCE.createDeployStatus(IStatus.ERROR, constraint.eClass()
				.getName(), ICoreProblemType.CONSTRAINT_UNSATISFIED,
				DeployCoreMessages.Deferred_hosting_constraint_0_is_violated,
				new Object[] { title(constraint) }, constraint);

	}

	public IStatus validate(Constraint constraint, DeployModelObject context,
			IProgressMonitor monitor) {
		if (!canValidateConstraint(constraint)) {
			return CANCEL_STATUS;
		}

		if (context == null) {
			return ConstraintUtil.createNullContextStatus(constraint);
		}
		if (context instanceof DeployLink) {
			return validateInLink((DeferredHostingConstraint) constraint, (DeployLink) context,
					monitor);
		}
		if (context instanceof Requirement) {
			// TODO implement evaluation in a Requirement context.
			return CANCEL_STATUS;
		}
		return ConstraintUtil.createInvalidContextStatus(constraint, context);
	}

	/**
	 * Validates the deferred hosting constraint contained on a link.
	 * <p>
	 * The deferred hosting constrained may be contained in a {@link DeployLink} or a
	 * {@link Requirement}.
	 * 
	 * @param constraint
	 *           the deferred hosting constraint.
	 * @param link
	 *           the deploy link in whose context the constraint is validated.
	 * @param monitor
	 *           a progress monitor used to report progress and detect cancellation.
	 * @return the validation status
	 */
	public IStatus validateInLink(DeferredHostingConstraint constraint, DeployLink link,
			IProgressMonitor monitor) {
		if (link.getSourceURI() == null || link.getTargetURI() == null) {
			return ConstraintUtil.createInvalidContextStatus(constraint, link);
		}
		Unit sourceUnit = ValidatorUtils.getUnit(link.resolve(link.getSourceURI()));
		Unit targetUnit = ValidatorUtils.getUnit(link.resolve(link.getTargetURI()));

		if (sourceUnit == null || targetUnit == null) {
			return ConstraintUtil.createInvalidContextStatus(constraint, link);
		}
		return validate(constraint, sourceUnit, targetUnit, monitor);
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
		if (constraint instanceof DeferredHostingConstraint) {
			return true;
		}
		return false;
	}

	public DeployModelObject getContextForChildConstraints(Constraint constraint) {
		// don't allow child constraints
		return null;
	}

	protected String computeTypeName(Constraint constraint) {
		if (constraint instanceof DeferredHostingConstraint) {
			return "Deferred Hosting"; //$NON-NLS-1$
		}
		return super.computeTypeName(constraint);
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
