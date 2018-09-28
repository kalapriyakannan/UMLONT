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
import java.util.List;

import org.eclipse.emf.ecore.EClass;

import com.ibm.ccl.soa.deploy.core.DeployModelObject;
import com.ibm.ccl.soa.deploy.core.Unit;
import com.ibm.ccl.soa.deploy.core.validator.ValidatorUtils;
import com.ibm.ccl.soa.deploy.core.validator.resolution.DeployResolutionGenerator;
import com.ibm.ccl.soa.deploy.core.validator.resolution.IDeployResolution;
import com.ibm.ccl.soa.deploy.core.validator.resolution.IDeployResolutionContext;
import com.ibm.ccl.soa.deploy.core.validator.status.IDeployStatus;
import com.ibm.ccl.soa.deploy.was.WasCellUnit;
import com.ibm.ccl.soa.deploy.was.WasNode;
import com.ibm.ccl.soa.deploy.was.WasNodeUnit;
import com.ibm.ccl.soa.deploy.was.WasPackage;
import com.ibm.ccl.soa.deploy.was.internal.validator.WasDeployStatus;
import com.ibm.ccl.soa.deploy.was.internal.validator.util.IWasDeployStatusAttributeNames;
import com.ibm.ccl.soa.deploy.was.validator.IWASProblemType;

/**
 * Move a WasNode, whose wasVersion is invalidated to the wasCell, out of the Cell.
 * 
 * Remove the memberLink between wasCell and wasNode, if there are also memberLinks between wasNode
 * and wasNodeGroup in this wasCell, also remove them.
 * 
 * @since 3.2
 * 
 */
public class MoveInvalidWasMemberUnitListOutOfWasGroupUnitGenerator extends
		DeployResolutionGenerator {

	public boolean hasResolutions(IDeployResolutionContext context) {
		IDeployStatus status = context.getDeployStatus();
		if (!(status instanceof WasDeployStatus)) {
			return false;
		}

		// verify expected problem type
		if (!IWASProblemType.WAS_INVALID_MEMBERUNIT_LIST_IN_GROUPUNIT.equals(status.getProblemType())) {
			return false;
		}

		// verify parameters
		// status object is a was "group" ie, a cell
		// the resolution does not seem to process node groups
		// the resolution does process "nodes" with "server" members but this was discontinued a long time ago
		DeployModelObject dmo = status.getDeployObject();
		EClass dmoType = dmo.getEObject().eClass();
		if (!WasPackage.Literals.WAS_CELL_UNIT.isSuperTypeOf(dmoType)) {
			return false;
		}
		WasCellUnit cellUnit = (WasCellUnit) dmo;
		Unit cellHost = ValidatorUtils.discoverHost(cellUnit, context.getProgressMonitor());

		// expect list of WasNode capabilities
		Object obj = ((WasDeployStatus) status)
				.getAttribute(IWasDeployStatusAttributeNames.CAPABILITY_LIST);
		if (!(obj instanceof List)) {
			return false;
		}
		List<Object> objList = (List<Object>) obj;
		for (Object o : objList) {
			if (!(o instanceof WasNode)) {
				return false;
			}
		}

		// check that the generated resolutions will have the permissions to complete successfully:
		// when dmoType is WasCellUnit:
		// MoveWasNodeUnitOutOfWasCellUnitResolution (for each node in cell)
		// At least one resolution must succeed; getResolutions needs to also validate conditions
		for (Object o : objList) {
			WasNode nodeCap = (WasNode) o;
			WasNodeUnit nodeUnit = (WasNodeUnit) nodeCap.getParent();
			if (cellHost == nodeUnit) {
				// no resolution generated in this case
				continue;
			}
			if (WasResolutionUtils.canRemoveMemberLink(cellUnit, nodeUnit)) {
				return true;
			}
		}

		return false;
	}

	public IDeployResolution[] getResolutions(IDeployResolutionContext context) {
		IDeployStatus status = context.getDeployStatus();
		DeployModelObject dmo = status.getDeployObject();
		Object o = ((WasDeployStatus) status)
				.getAttribute(IWasDeployStatusAttributeNames.CAPABILITY_LIST);
		if (o == null || !(o instanceof List)) {
			return new IDeployResolution[0];
		}

		List memberCapList = (List) o;

		if (memberCapList.size() < 2) {
			return new IDeployResolution[0];
		}

		if (dmo instanceof WasCellUnit) {
			WasCellUnit cellUnit = (WasCellUnit) dmo;
			if (memberCapList.get(0) instanceof WasNode) {
				WasNodeUnit hostUnit = (WasNodeUnit) ValidatorUtils.discoverHost(cellUnit, context
						.getProgressMonitor());

				List<IDeployResolution> resolutions = new ArrayList<IDeployResolution>();
				for (int i = 0; i < memberCapList.size(); i++) {
					WasNodeUnit toBeRemovedUnit = (WasNodeUnit) ((WasNode) memberCapList.get(i))
							.getParent();
					if (!toBeRemovedUnit.equals(hostUnit)) {
						if (WasResolutionUtils.canRemoveMemberLink(cellUnit, toBeRemovedUnit)) {
							resolutions.add(new MoveWasNodeUnitOutOfWasCellUnitResolution(context, this,
									toBeRemovedUnit));
						}
					}
				}
				return resolutions.toArray(new IDeployResolution[resolutions.size()]);
			}
		}

		// MK 8/23/2007: removed because servers are not members of node
//			if (IWasValidatorID.WAS_DEFAULT_NODE_UNIT_IN_WAS_STANDALONE_CELL_WITH_MORE_THAN_ONE_WAS_SERVER
//					.equals(status.getValidatorID())
//					&& dmo instanceof WasNodeUnit) {
//				WasNodeUnit nodeUnit = (WasNodeUnit) dmo;
//				if (memberCapList.get(0) instanceof WasServer) {
//					resolutions = new IDeployResolution[resolutionLength];
//					for (int i = 0; i < resolutionLength; i++) {
//						WasServer serverCap = (WasServer) memberCapList.get(i);
//						resolutions[i] = new CreateMoveInvalidMemberOutOfGroupResolution(context, this,
//								(Unit) serverCap.getParent(), nodeUnit);
//					}
//					return resolutions;
//				}
//			}

		return new IDeployResolution[0];
	}

}
