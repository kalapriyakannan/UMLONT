/***************************************************************************************************
 * Copyright (c) 2003, 2007 IBM Corporation Licensed Material - Property of IBM. All rights
 * reserved.
 * 
 * US Government Users Restricted Rights - Use, duplication or disclosure v1.0 restricted by GSA ADP
 * Schedule Contract with IBM Corp.
 * 
 * Contributors: IBM Corporation - initial API and implementation
 **************************************************************************************************/
package com.ibm.ccl.soa.deploy.was.validator.resolution;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;

import com.ibm.ccl.soa.deploy.core.DeployModelObject;
import com.ibm.ccl.soa.deploy.core.MemberLink;
import com.ibm.ccl.soa.deploy.core.Unit;
import com.ibm.ccl.soa.deploy.core.util.DeployNLS;
import com.ibm.ccl.soa.deploy.core.validator.resolution.DeployResolution;
import com.ibm.ccl.soa.deploy.core.validator.resolution.DeployResolutionGenerator;
import com.ibm.ccl.soa.deploy.core.validator.resolution.IDeployResolution;
import com.ibm.ccl.soa.deploy.core.validator.resolution.IDeployResolutionContext;
import com.ibm.ccl.soa.deploy.core.validator.resolution.IDeployResolutionGenerator;
import com.ibm.ccl.soa.deploy.was.WasCellUnit;
import com.ibm.ccl.soa.deploy.was.WasNodeGroupUnit;
import com.ibm.ccl.soa.deploy.was.WasPackage;
import com.ibm.ccl.soa.deploy.was.internal.validator.WasDeployStatus;
import com.ibm.ccl.soa.deploy.was.internal.validator.WasDomainMessages;
import com.ibm.ccl.soa.deploy.was.internal.validator.util.IWasDeployStatusAttributeNames;
import com.ibm.ccl.soa.deploy.was.validator.IWASProblemType;
import com.ibm.ccl.soa.deploy.was.validator.IWasValidatorID;

public class FixDuplicateGroupingMemberUnitResolutionGenerator extends DeployResolutionGenerator {

	public IDeployResolution[] getResolutions(IDeployResolutionContext context) {
		WasDeployStatus status = (WasDeployStatus) context.getDeployStatus();
		DeployModelObject dmo = status.getDeployObject();

		if (!IWasValidatorID.VALIDAT_WAS_NODEGROUP_UNIT_S_GROUPING_WASCELLUNITS.equals(status
				.getValidatorID())) {
			return new IDeployResolution[0];
		}

		if (!(dmo instanceof WasNodeGroupUnit)) {
			return null;
		}

		Object obj = status.getAttribute(IWasDeployStatusAttributeNames.CELL_LIST);

		if (!(obj instanceof List)) {
			return new IDeployResolution[0];
		}

		List<Object> cellList = (List<Object>) obj;
		if (cellList == null || cellList.size() < 2) {
			return new IDeployResolution[0];
		}

		List<IDeployResolution> resolutions = new ArrayList<IDeployResolution>();
		for (int i = 0; i < cellList.size(); i++) {
			WasCellUnit cellUnit = (WasCellUnit) cellList.get(i);
			if (canRemoveMemberFromGroups(cellUnit, (Unit) dmo, cellList)) {
				resolutions.add(new CreateGetRidOfRedundantGroupUnitsResolution(context, this,
						(WasNodeGroupUnit) dmo, cellUnit, cellList));
			}
		}
		return resolutions.toArray(new IDeployResolution[resolutions.size()]);
	}

	public boolean hasResolutions(IDeployResolutionContext context) {
		if (!(context.getDeployStatus() instanceof WasDeployStatus)) {
			return false;
		}
		WasDeployStatus status = (WasDeployStatus) context.getDeployStatus();

		// check problem type
		if (!IWASProblemType.DUPLICATED_GROUPING_UNIT.equals(status.getProblemType())) {
			return false;
		}

		// also check validator
		if (!IWasValidatorID.VALIDAT_WAS_NODEGROUP_UNIT_S_GROUPING_WASCELLUNITS.equals(status
				.getValidatorID())) {
			return false;
		}

		// check input parameters:
		// (a) status is on node group unit
		// (b) CELL_LIST parameter is a list of more than 1 was cell units
		DeployModelObject dmo = status.getDeployObject();
		if (!WasPackage.Literals.WAS_NODE_GROUP_UNIT.isSuperTypeOf(dmo.getEObject().eClass())) {
			return false;
		}
		WasNodeGroupUnit ng = (WasNodeGroupUnit) dmo;

		Object obj = status.getAttribute(IWasDeployStatusAttributeNames.CELL_LIST);
		if (!(obj instanceof List)) {
			return false;
		}
		List l = (List) obj;
		// check that list length is greater than 1
		if (l.size() < 2) {
			return false;
		}
		// check that all members are WasCellUnit members
		for (Object entry : l) {
			if (!(entry instanceof WasCellUnit)) {
				return false;
			}
		}

		// check that resolution will be able to complete for at least one member in the list:
		// remove node group membership from all cells except one 
		for (Object entry : l) {
			if (canRemoveMemberFromGroups((Unit) entry, ng, l)) {
				return true;
			}
		}

		return false;
	}

	private boolean canRemoveMemberFromGroups(Unit groupToStayIn, Unit member,
			List<Object> groupsToRemoveFrom) {
		boolean groupOK = true;
		for (Object g : groupsToRemoveFrom) {
			if (g == groupToStayIn) {
				continue;
			}
			if (!WasResolutionUtils.canRemoveMemberLink(groupToStayIn, member)) {
				groupOK = false;
				break;
			}
		}

		if (groupOK) {
			return true;
		}

		return false;
	}

	/**
	 * leave memberUnit just in one group Unit
	 */
	private static class CreateGetRidOfRedundantGroupUnitsResolution extends DeployResolution {
		private final Unit _memberUnit;
		private final Unit _groupUnit;
		private final List _groupList;

		public CreateGetRidOfRedundantGroupUnitsResolution(IDeployResolutionContext context,
				IDeployResolutionGenerator generator, Unit memberUnit, Unit groupUnit, List groupUDList) {
			super(
					context,
					generator,
					DeployNLS
							.bind(
									WasDomainMessages.Resolution_departFrom_Redundant_GroupingUnit_Other_Than_GroupUnit_0_for_MemberUnit_1,
									groupUnit, memberUnit));
			_memberUnit = memberUnit;
			_groupUnit = groupUnit;
			_groupList = groupUDList;
		}

		public IStatus resolve(IProgressMonitor monitor) {
			for (Iterator<Unit> groupIt = _groupList.iterator(); groupIt.hasNext();) {
				Unit removingGroupUnit = groupIt.next();
				if (!removingGroupUnit.equals(_groupUnit)) {
					List<MemberLink> memberLinks = removingGroupUnit.getMemberLinks();
					if (memberLinks != null) {
						Iterator<MemberLink> tempIt = memberLinks.iterator();
						while (tempIt.hasNext()) {
							MemberLink memberLink = tempIt.next();
							if (memberLink.getTarget().equals(_memberUnit)) {
								removingGroupUnit.getMemberLinks().remove(memberLink);
							}
						}
					}
				}
			}

			return Status.OK_STATUS;
		}

	}

}
