/***************************************************************************************************
 * Copyright (c) 2008 IBM Corporation. All rights reserved.
 * 
 * Contributors: IBM Corporation - initial API and implementation
 **************************************************************************************************/

package com.ibm.ccl.soa.deploy.core.validator.constraints;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.StringTokenizer;

import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.MultiStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.osgi.util.NLS;

import com.ibm.ccl.soa.deploy.core.Capability;
import com.ibm.ccl.soa.deploy.core.Constraint;
import com.ibm.ccl.soa.deploy.core.DeployCorePlugin;
import com.ibm.ccl.soa.deploy.core.DeployModelObject;
import com.ibm.ccl.soa.deploy.core.IRelationshipChecker;
import com.ibm.ccl.soa.deploy.core.Requirement;
import com.ibm.ccl.soa.deploy.core.RequirementLinkTypes;
import com.ibm.ccl.soa.deploy.core.Stereotype;
import com.ibm.ccl.soa.deploy.core.Topology;
import com.ibm.ccl.soa.deploy.core.Unit;
import com.ibm.ccl.soa.deploy.core.constraint.ConstraintPackage;
import com.ibm.ccl.soa.deploy.core.constraint.StereotypeConstraint;
import com.ibm.ccl.soa.deploy.core.util.ConstraintUtil;
import com.ibm.ccl.soa.deploy.core.util.DeployModelObjectUtil;
import com.ibm.ccl.soa.deploy.core.validator.status.DeployCoreStatusFactory;
import com.ibm.ccl.soa.deploy.core.validator.status.ICoreProblemType;
import com.ibm.ccl.soa.deploy.core.validator.status.IDeployStatus;
import com.ibm.ccl.soa.deploy.internal.core.DeployCoreMessages;
import com.ibm.ccl.soa.deploy.internal.core.validator.status.DeployStatus;

/**
 * The validator used to test for the inclusion and/or exclusion of stereotypes.
 * 
 * @see StereotypeConstraint
 * 
 */
public class StereotypeConstraintValidator extends ConstraintValidator {

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.ibm.ccl.soa.deploy.core.validator.constraints.ConstraintValidator#canValidateConstraint(com.ibm.ccl.soa.deploy.core.Constraint)
	 */
	@Override
	public boolean canValidateConstraint(Constraint constraint) {
		return ConstraintPackage.Literals.STEREOTYPE_CONSTRAINT == constraint.eClass();
	}

	@Override
	public String title(Constraint constraint) {
		String title = super.title(constraint);
		StereotypeConstraint sc = (StereotypeConstraint) constraint;
		String includesString = sc.getIncludes();
		if (includesString != null && includesString.length() > 0) {
			title = NLS.bind(DeployCoreMessages.StereotypeConstraintValidator_0_includes_1_,
					new Object[] { title, includesString });
		}
		return title;
	}

	/*
	 * In order for the NOT constraint to work we should only return an OK status if the stereotypes
	 * are actually included. Otherwise we need to return a problem status or cancel.
	 * 
	 * @see com.ibm.ccl.soa.deploy.core.validator.constraints.ConstraintValidator#validate(com.ibm.ccl.soa.deploy.core.Constraint,
	 *      com.ibm.ccl.soa.deploy.core.DeployModelObject, org.eclipse.core.runtime.IProgressMonitor)
	 */
	@SuppressWarnings("unchecked")
	@Override
	public IStatus validate(Constraint constraint, DeployModelObject context,
			IProgressMonitor monitor) {
		StereotypeConstraint stereotypeConstraint = (StereotypeConstraint) constraint;
		if (context == null) {
			return ConstraintUtil.createNullContextStatus(stereotypeConstraint);
		}
		String stereotypeString = stereotypeConstraint.getIncludes();
		if (stereotypeString == null || stereotypeString.length() == 0 || context == null) {
			//No stereotypes set to be constrainted.
			return Status.CANCEL_STATUS;
		}
		if (context instanceof Unit) {
			return validateUnitStereotypes((Unit) context, stereotypeString, constraint);
		} else if (context instanceof Requirement) {
			return validateRequirementTargetStereotypes((Requirement) context, stereotypeString,
					constraint);
		} else if (context instanceof Capability) {
			return validateCapabilityStereotypes((Capability) context, stereotypeString, constraint);
		}
		return Status.OK_STATUS;
	}

	@SuppressWarnings("unchecked")
	private IStatus validateCapabilityStereotypes(Capability context, String stereotypeString,
			Constraint constraint) {
		String statusMessage = validateIncludedStereotypes(context.getStereotypes(), stereotypeString);
		if (statusMessage == null) {
			return Status.OK_STATUS;
		}
		//Set the status type based on the owning Unit.
		Unit parent = (Unit) context.getParent();
		int statusType = parent.isConceptual() ? IStatus.WARNING : IStatus.ERROR;
		return createMissingStereotypeStatus(statusType, constraint, statusMessage, context);
	}

	@Override
	public IStatus validateForPotentialMatch(Constraint constraint, DeployModelObject context) {
		StereotypeConstraint stereotypeConstraint = (StereotypeConstraint) constraint;
		if (context == null) {
			return ConstraintUtil.createNullContextStatus(stereotypeConstraint);
		}
		String stereotypeString = stereotypeConstraint.getIncludes();
		if (stereotypeString == null || stereotypeString.length() == 0 || context == null) {
			//No stereotypes set to be constrainted.
			return Status.OK_STATUS;
		}
		if (context instanceof Requirement) {
			Requirement req = (Requirement) context;
			Topology topology = context.getEditTopology();
			if (topology == null) {
				return Status.CANCEL_STATUS;
			}
			//IRelationshipChecker relChecker = topology.getRelationships();
			RequirementLinkTypes linkType = req.getLinkType();
			if (linkType == null) {
				return Status.CANCEL_STATUS;
			}
			switch (linkType.getValue())
			{
			case RequirementLinkTypes.MEMBER:

				break;
			case RequirementLinkTypes.HOSTING:

				break;
			}
		}
		return Status.OK_STATUS;
	}

	/*
	 * This should only be necessary to test membership requirements since the hosting and dependency
	 * link targets will be validated using context switching.
	 */
	private IStatus validateRequirementTargetStereotypes(Requirement context,
			String stereotypeString, Constraint constraint) {
		Topology topology = context.getEditTopology();
		if (topology == null) {
			return Status.CANCEL_STATUS;
		}
		IRelationshipChecker relChecker = topology.getRelationships();
		RequirementLinkTypes linkType = context.getLinkType();
		if (linkType == null) {
			return Status.CANCEL_STATUS;
		}
		switch (linkType.getValue())
		{
		case RequirementLinkTypes.MEMBER:
			Collection<Unit> memberUnits = relChecker.getMembers((Unit) context.getParent());
			if (memberUnits == null || memberUnits.isEmpty()) {
				return Status.CANCEL_STATUS;
			}
			return validateMemberStereotypes(memberUnits, stereotypeString, constraint);
		}
		return Status.CANCEL_STATUS;
	}

	@SuppressWarnings("unchecked")
	private IStatus validateMemberStereotypes(Collection<Unit> units, String stereotypeString,
			Constraint constraint) {
		IStatus status = null;
		for (Iterator<Unit> it = units.iterator(); it.hasNext();) {
			Unit unit = it.next();
			List<Stereotype> stereotypes = unit.getStereotypes();
			String missingStereotypeMessage = validateIncludedStereotypes(stereotypes,
					stereotypeString);
			if (missingStereotypeMessage != null) {
				status = compoundStatuses(status, createMissingStereotypeStatus(IStatus.ERROR,
						constraint, missingStereotypeMessage, unit));
			}
		}
		if (status == null) {
			status = Status.OK_STATUS;
		}
		return status;
	}

	private IStatus compoundStatuses(IStatus status, IStatus newStatus) {
		if (status == null) {
			return newStatus;
		}
		MultiStatus multiStatus = null;
		if (status.isMultiStatus()) {
			multiStatus = (MultiStatus) status;
		} else {
			multiStatus = new MultiStatus(DeployCorePlugin.PLUGIN_ID, 0, null, null);
			multiStatus.add(status);
		}
		multiStatus.add(newStatus);
		return multiStatus;
	}

	@SuppressWarnings("unchecked")
	private IStatus validateUnitStereotypes(Unit context, String stereotypeString,
			Constraint constraint) {
		String statusMessage = validateIncludedStereotypes(context.getStereotypes(), stereotypeString);
		if (statusMessage == null) {
			return Status.OK_STATUS;
		}
		int statusType = context.isConceptual() ? IStatus.WARNING : IStatus.ERROR;
		return createMissingStereotypeStatus(statusType, constraint, statusMessage, context);
	}

	private IStatus createMissingStereotypeStatus(int statusType, Constraint stereotypeConstraint,
			String missingStereotypes, DeployModelObject context) {
		String typeString = null;
		if (context instanceof Unit) {
			typeString = NLS.bind(DeployCoreMessages.StereotypeConstraintValidator_Unit_0_,
					((Unit) context).getCaptionProvider().title((Unit) context));
		} else {
			typeString = NLS.bind(DeployCoreMessages.StereotypeConstraintValidator_Capability_0_,
					((Capability) context).getCaptionProvider().title((Capability) context));
		}
		String constraintLabel = super.title(stereotypeConstraint);
		DeployModelObject dmo = getNonConstraintParent(stereotypeConstraint);
		String dmoTitle = DeployModelObjectUtil.getTitle(dmo);
		IDeployStatus status = DeployCoreStatusFactory.INSTANCE.createDeployStatus(statusType,
				stereotypeConstraint.eClass().getName(), ICoreProblemType.STEREOTYPE_INCLUSION_FAILURE,
				DeployCoreMessages.StereotypeConstraintValidator_0_constraint_on_1_failed_2_,
				new String[] { constraintLabel, dmoTitle, typeString, missingStereotypes }, context);
		((DeployStatus) status).setConstraints(Collections.singletonList(stereotypeConstraint));
		return status;
	}

	private DeployModelObject getNonConstraintParent(DeployModelObject object) {
		while (object != null && object instanceof Constraint) {
			object = object.getParent();
		}
		return object;
	}

	/**
	 * A utility method to compute a list of missing stereotype keys.
	 * 
	 * @param constraint
	 *           The {@link StereotypeConstraint} that describes the set of stereotypes to be
	 *           included.
	 * @param contextStereotypes
	 *           The list of {@link Stereotype}s from a {@link Unit} or {@link Capability} to check
	 *           for missing keys.
	 * @return A {@link List} of Strings representing missing stereotype keys.
	 */
	public static List<String> computeMissingStereotypes(StereotypeConstraint constraint,
			List<Stereotype> contextStereotypes) {
		return computeMissingStereotypes(constraint.getIncludes(), contextStereotypes);
	}

	private static List<String> computeMissingStereotypes(String stereotypeString,
			List<Stereotype> contextStereotypes) {
		StringTokenizer tokenizer = new StringTokenizer(stereotypeString, ","); //$NON-NLS-1$
		List<String> missingStereotypes = null;
		while (tokenizer.hasMoreTokens()) {
			String checkStereotype = tokenizer.nextToken();
			if (!containsStereotypeKey(checkStereotype, contextStereotypes)) {
				if (missingStereotypes == null) {
					missingStereotypes = new ArrayList<String>();
				}
				missingStereotypes.add(checkStereotype);
			}
		}
		return missingStereotypes;
	}

	private String validateIncludedStereotypes(List<Stereotype> contextStereotypes,
			String stereotypeString) {
		List<String> missingStereotypes = computeMissingStereotypes(stereotypeString,
				contextStereotypes);

		String missingStereotypeString = null;
		if (missingStereotypes != null) {
			Iterator<String> it = missingStereotypes.iterator();
			while (it.hasNext()) {
				if (missingStereotypeString == null) {
					missingStereotypeString = it.next();
				} else {
					missingStereotypeString += it.next();
				}
				if (it.hasNext()) {
					missingStereotypeString += ", "; //$NON-NLS-1$
				}
			}
		}
		return missingStereotypeString;
	}

	private static boolean containsStereotypeKey(String checkStereotype,
			List<Stereotype> contextStereotypes) {
		for (Iterator<Stereotype> it = contextStereotypes.iterator(); it.hasNext();) {
			Stereotype stereotype = it.next();
			if (checkStereotype.equalsIgnoreCase(stereotype.getKeyword())) {
				return true;
			}
		}
		return false;
	}

}
