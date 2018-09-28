/***************************************************************************************************
 * Copyright (c) 2003, 2007 IBM Corporation Licensed Material - Property of IBM. All rights
 * reserved.
 * 
 * US Government Users Restricted Rights - Use, duplication or disclosure v1.0 restricted by GSA ADP
 * Schedule Contract with IBM Corp.
 * 
 * Contributors: IBM Corporation - initial API and implementation
 **************************************************************************************************/
package com.ibm.ccl.soa.deploy.core.validator.constraints.communication;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.emf.ecore.EClass;

import com.ibm.ccl.soa.deploy.core.Constraint;
import com.ibm.ccl.soa.deploy.core.ConstraintLink;
import com.ibm.ccl.soa.deploy.core.CorePackage;
import com.ibm.ccl.soa.deploy.core.DependencyLink;
import com.ibm.ccl.soa.deploy.core.DeployLink;
import com.ibm.ccl.soa.deploy.core.DeployModelObject;
import com.ibm.ccl.soa.deploy.core.Requirement;
import com.ibm.ccl.soa.deploy.core.Unit;
import com.ibm.ccl.soa.deploy.core.UnitLink;
import com.ibm.ccl.soa.deploy.core.constraint.ApplicationCommunicationConstraint;
import com.ibm.ccl.soa.deploy.core.constraint.CommunicationChildConstraint;
import com.ibm.ccl.soa.deploy.core.constraint.ConstraintPackage;
import com.ibm.ccl.soa.deploy.core.constraint.NetworkCommunicationConstraint;
import com.ibm.ccl.soa.deploy.core.util.ConstraintUtil;
import com.ibm.ccl.soa.deploy.core.validator.ConstraintService;
import com.ibm.ccl.soa.deploy.core.validator.ValidatorUtils;
import com.ibm.ccl.soa.deploy.core.validator.constraints.ConstraintValidator;
import com.ibm.ccl.soa.deploy.core.validator.status.ICoreProblemType;
import com.ibm.ccl.soa.deploy.core.validator.status.IDeployCoreValidators;
import com.ibm.ccl.soa.deploy.internal.core.DeployCoreMessages;

/**
 * Validator for instances of {@link ApplicationCommunicationConstraint}. Validation checks that
 * there is a compatible {@link NetworkCommunicationConstraint} between other units (as determined
 * by extensions of this abstract class).
 */
public abstract class ApplicationCommunicationConstraintValidator extends ConstraintValidator {

	@Override
	public boolean canValidateConstraint(Constraint constraint) {
		return null != constraint
				&& ConstraintPackage.Literals.APPLICATION_COMMUNICATION_CONSTRAINT
						.isSuperTypeOf(constraint.getEObject().eClass());
	}

	@Override
	public IStatus validate(Constraint constraint, DeployModelObject context,
			IProgressMonitor monitor) {

		if (!canValidateConstraint(constraint)) {
			return Status.CANCEL_STATUS;
		}

		DeployModelObject parent = ConstraintUtil.getExpectedContext(constraint);
		EClass parentType = parent.getEObject().eClass();
		if (!CorePackage.Literals.CONSTRAINT_LINK.isSuperTypeOf(parentType)
				&& !CorePackage.Literals.DEPENDENCY_LINK.isSuperTypeOf(parentType)) {
			return Status.CANCEL_STATUS;
		}

		DeployLink parentLink = (DeployLink) parent;

		// validation continues if there is an expected source unit in the source stack
		Unit sourceUnit = getLinkSourceUnit(parentLink);
		List<Unit> sourceStack = discoverStack(sourceUnit, monitor);
		Unit expectedSourceUnit = getExpectedUnit(sourceStack, getExpectedSourceUnitType());
		if (null == expectedSourceUnit) {
			// do not need to continue
			return Status.OK_STATUS;
		}

		// validation continues if there is an expected target unit in the target stack
		Unit targetUnit = getLinkTargetUnit(parentLink);
		List<Unit> targetStack = discoverStack(targetUnit, monitor);
		Unit expectedTargetUnit = getExpectedUnit(targetStack, getExpectedTargetUnitType());
		if (null == expectedTargetUnit) {
			// do not need to continue
			return Status.OK_STATUS;
		}

		if (expectedSourceUnit == expectedTargetUnit) {
			// The source and target are on the same checked host.
			return Status.OK_STATUS;
		}
		// get all NetworkCommunicationConstraints between the two hosting stacks
		List<Constraint> candidateNCCs = getCandidateNetworkCommunicationConstraints(sourceStack,
				targetStack);
		candidateNCCs = filterByDirection(candidateNCCs,
				((ApplicationCommunicationConstraint) constraint).isRespectLinkDirection());

		// if none, then error
		if (0 == candidateNCCs.size()) {
			// ERROR: NCC required
			return new DeployCommunicationConstraintStatus(IStatus.ERROR,
					IDeployCoreValidators.ACC_MATCHING_001, ICoreProblemType.CANNOT_MATCH_ACC_TO_NCC,
					DeployCoreMessages.Validator_acc_cannot_be_matched_between_0,
					new Object[] { getNccContextDescription() }, constraint, expectedSourceUnit,
					expectedTargetUnit, null, null, getNccContextDescription());
		}

		// check that at least one of the NCC satisfies the input ACC (constraint)
		return validateAccAgainstCandidateNccs((ApplicationCommunicationConstraint) constraint,
				sourceUnit, targetUnit, candidateNCCs, monitor);
	}

	/**
	 * Retrieve the {@link EClass} of the expected unit which should serve as a source of the
	 * {@link NetworkCommunicationConstraint} being sought.
	 * 
	 * @return the type of the expected unit
	 */
	protected abstract EClass getExpectedSourceUnitType();

	/**
	 * Retrieve the {@link EClass} of the expected unit which should serve as a target of the
	 * {@link NetworkCommunicationConstraint} being sought.
	 * 
	 * @return the type of the expected unit
	 */
	protected abstract EClass getExpectedTargetUnitType();

	/**
	 * Search a list of units for one of a particular type.
	 * 
	 * @param stack
	 *           the list of units to be searched
	 * @param type
	 *           the type sought
	 * @return the first unit found with the desired type or null if none can be found
	 */
	private Unit getExpectedUnit(List<Unit> stack, EClass type) {
		for (Unit u : stack) {
			if (type.isSuperTypeOf(u.getEObject().eClass())) {
				return u;
			}
		}
		return null;
	}

	/**
	 * Discover the stack of units, typically via hosting between an endpoint of an
	 * {@link ApplicationCommunicationConstraint} and the endpoint of the expected
	 * {@link NetworkCommunicationConstraint}.
	 * 
	 * @param unit
	 *           the endpoint of the link containing the {@link AppliationCommunicationConstraint}
	 * @param monitor
	 *           a progress monitor
	 * @return the expected endpoint of a link containing a {@link NetworkCommunicationConstraint}
	 */
	protected abstract List<Unit> discoverStack(Unit unit, IProgressMonitor monitor);

	private List<Constraint> getCandidateNetworkCommunicationConstraints(List<Unit> sourceStack,
			List<Unit> targetStack) {
		List<Constraint> candidateConstraints = new ArrayList<Constraint>();

		// look for NetworkCommunicationConstraints on any ConstraintLinks
		for (Unit candidateSourceUnit : sourceStack) {
			List<ConstraintLink> candidateConstraintLinks = candidateSourceUnit.getConstraintLinks();
			for (ConstraintLink candidateLink : candidateConstraintLinks) {
				Unit targetUnit = getLinkTargetUnit(candidateLink);
				if (targetStack.contains(targetUnit)) {
					// look on candidateLink
					candidateConstraints.addAll(getConstraints(candidateLink,
							ConstraintPackage.Literals.NETWORK_COMMUNICATION_CONSTRAINT));
				}
			}

			// look for NetworkCommunicationConstraints on DependencyLinks
			List<Requirement> requirements = candidateSourceUnit.getDependencyOrAnyRequirements();
			for (Requirement req : requirements) {
				// links are not discovered; hence any constraints on them are not known
//				Unit targetUnit = ValidatorUtils.discoverDependencyLinkTargetUnit(req, monitor);
				DependencyLink candidateLink = req.getLink();
				if (null == candidateLink) {
					continue;
				}
				Unit targetUnit = getLinkTargetUnit(candidateLink);
				if (targetStack.contains(targetUnit)) {
					// look on candidateLink
					candidateConstraints.addAll(getConstraints(candidateLink,
							ConstraintPackage.Literals.NETWORK_COMMUNICATION_CONSTRAINT));
				}
			}
		}

		// look for links in the reverse direction as well -- if the app comm constraint
		// is bi-directional (assumed for now)
		// we use names use source/target to match the stack; not the source/target of the link
		for (Unit candidateTargetUnit : targetStack) {
			List<ConstraintLink> candidateConstraintLinks = candidateTargetUnit.getConstraintLinks();
			for (ConstraintLink candidateLink : candidateConstraintLinks) {
				Unit sourceUnit = getLinkTargetUnit(candidateLink);
				if (sourceStack.contains(sourceUnit)) {
					// look on candidateLink
					candidateConstraints.addAll(getConstraints(candidateLink,
							ConstraintPackage.Literals.NETWORK_COMMUNICATION_CONSTRAINT));
				}
			}

			// look for NetworkCommunicationConstraints on DependencyLinks
			List<Requirement> requirements = candidateTargetUnit.getDependencyOrAnyRequirements();
			for (Requirement req : requirements) {
				// links are not discovered; hence any constraints on them are not known
//				Unit targetUnit = ValidatorUtils.discoverDependencyLinkTargetUnit(req, monitor);
				DependencyLink candidateLink = req.getLink();
				if (null == candidateLink) {
					continue;
				}
				Unit sourceUnit = getLinkTargetUnit(candidateLink);
				if (sourceStack.contains(sourceUnit)) {
					// look on candidateLink
					candidateConstraints.addAll(getConstraints(candidateLink,
							ConstraintPackage.Literals.NETWORK_COMMUNICATION_CONSTRAINT));
				}
			}
		}

		return candidateConstraints;
	}

	private IStatus validateAccAgainstCandidateNccs(ApplicationCommunicationConstraint acc,
			Unit sourceUnit, Unit targetUnit, List<Constraint> candidateConstraints,
			IProgressMonitor monitor) {

		StatusMap statusMap = validateApplicationCommunicationConstraintChildren(acc,
				candidateConstraints, monitor);
		return statusMap.getStatuses();
	}

	private List<Constraint> filterByDirection(List<Constraint> candidates,
			boolean respectLinkDirection) {
		if (null == candidates) {
			return Collections.emptyList();
		}
		List<Constraint> result = new ArrayList<Constraint>();
		for (Constraint ncc : candidates) {
			if (!ConstraintPackage.Literals.NETWORK_COMMUNICATION_CONSTRAINT.isSuperTypeOf(ncc
					.getEObject().eClass())) {
				continue;
			}
			if (((NetworkCommunicationConstraint) ncc).isRespectLinkDirection() != respectLinkDirection) {
				continue;
			}
			result.add(ncc);
		}
		return result;
	}

	private StatusMap validateApplicationCommunicationConstraintChildren(
			ApplicationCommunicationConstraint acc, List<Constraint> candidateConstraints,
			IProgressMonitor monitor) {
		StatusMap statusMap = new StatusMap();
		for (Constraint childConstraint : (List<Constraint>) acc.getConstraints()) {
			StatusMap childStatusMap = new StatusMap();
			for (Constraint ncc : candidateConstraints) {
				CVC cvc = new AccNccContext(acc, (NetworkCommunicationConstraint) ncc);
				IStatus childStatus = null;
				if (childConstraint instanceof CommunicationChildConstraint) {
					List<ConstraintValidator> validators = ConstraintService.INSTANCE
							.getValidators(childConstraint.getEObject().eClass());
					for (ConstraintValidator v : validators) {
						childStatus = ((CommunicationConstraintChildValidator) v).validateWithContext(
								childConstraint, cvc, monitor);
					}
//				if (childConstraint instanceof ApplicationCommunicationProtocolConstraint) {
//					ApplicationCommunicationProtocolConstraintValidator acpcv = new ApplicationCommunicationProtocolConstraintValidator();
//					childStatus = acpcv.validatewithContext(childConstraint, cvc, monitor);
				} else {
					childStatus = ConstraintService.INSTANCE.validate(childConstraint, ncc, monitor);
				}
				childStatusMap.put(ncc, childStatus);
			}
			IStatus status = null;
			if (childStatusMap.anyOK()) {
				status = Status.OK_STATUS;
			} else {
				status = new DeployCommunicationConstraintStatus(IStatus.ERROR,
						IDeployCoreValidators.ACC_MATCHING_001,
						ICoreProblemType.CANNOT_MATCH_ACC_CHILD_TO_NCC_CHILD,
						DeployCoreMessages.Validator_acc_child_constraint_cannot_be_matched_0,
						new Object[] { getNccContextDescription() }, childConstraint, null, null,
						candidateConstraints, childStatusMap, getNccContextDescription());

			}
			statusMap.put(childConstraint, status);
		}
		return statusMap;
	}

	protected abstract String getNccContextDescription();

	private boolean isAccSatisfied(Map statusMap) {
		for (Iterator<Constraint> it = statusMap.keySet().iterator(); it.hasNext();) {
			Constraint c = it.next();
			IStatus status = (IStatus) statusMap.get(c);
			if (status.isOK()) {
				continue;
			}
			// is there a NCC on which the child is satisfied
			StatusMap childStatusMap = ((IDeployCommunicationConstraintStatus) status).getStatusMap();
			for (Iterator<IStatus> sIt = childStatusMap.values().iterator(); sIt.hasNext();) {
				IStatus s = sIt.next();
				if (null == s || s.isOK()) {
					continue;
				}
			}
			// no NCC found on which the child is satisfied
			return false;
		}
		return true;
	}

	//Consider refactoring the next four (4) methods to DeployLinkUtils
	// why doesn't DeployLink have a getSource() and getTarget() method?
	private DeployModelObject getLinkSource(DeployLink link) {
		if (link instanceof DependencyLink) {
			return ((DependencyLink) link).getSource();
		} else if (link instanceof UnitLink) {
			return ((UnitLink) link).getSource();
		} else if (link instanceof ConstraintLink) {
			return ((ConstraintLink) link).getSource();
		} else {
			return null;
		}
	}

	private Unit getLinkSourceUnit(DeployLink link) {
		DeployModelObject dmo = getLinkSource(link);
		return ValidatorUtils.getUnit(dmo);
	}

	private DeployModelObject getLinkTarget(DeployLink link) {
		if (link instanceof DependencyLink) {
			return ((DependencyLink) link).getTarget();
		} else if (link instanceof UnitLink) {
			return ((UnitLink) link).getTarget();
		} else if (link instanceof ConstraintLink) {
			return ((ConstraintLink) link).getTarget();
		} else {
			return null;
		}
	}

	private Unit getLinkTargetUnit(DeployLink link) {
		DeployModelObject dmo = getLinkTarget(link);
		return ValidatorUtils.getUnit(dmo);
	}

	/**
	 * Retrieve a set of constraints on a dmo of a given class type. This implementation assumes that
	 * the constraints of interest are immediate children of the given dmo (AND).
	 * 
	 * @param dmo
	 *           the {@link DeployModelObject} to be searched for constraints
	 * @param type
	 *           the {@link EClass} of the constraint to be sought. If this is null, all constraints
	 *           are returned.
	 * @return a list of top level constraints
	 */
	//TODO refactor to: ??
	private List<Constraint> getConstraints(DeployModelObject dmo, EClass type) {
		if (null == dmo) {
			return Collections.emptyList();
		}
		// initially assume that the constraint must be at the root level (AND only)
		ArrayList<Constraint> results = new ArrayList<Constraint>();
		List<Constraint> constraints = dmo.getConstraints();
		for (Constraint c : constraints) {
			if (null == type || type.isSuperTypeOf(c.getEObject().eClass())) {
				results.add(c);
			}
		}
		return results;
	}

}
