/***************************************************************************************************
 * Copyright (c) 2003, 2007 IBM Corporation Licensed Material - Property of IBM. All rights
 * reserved.
 * 
 * US Government Users Restricted Rights - Use, duplication or disclosure v1.0 restricted by GSA ADP
 * Schedule Contract with IBM Corp.
 * 
 * Contributors: IBM Corporation - initial API and implementation
 **************************************************************************************************/
package com.ibm.ccl.soa.deploy.was.internal.validator.action;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.emf.ecore.EClass;

import com.ibm.ccl.soa.deploy.core.CorePackage;
import com.ibm.ccl.soa.deploy.core.DeployModelObject;
import com.ibm.ccl.soa.deploy.core.Requirement;
import com.ibm.ccl.soa.deploy.core.util.DeployNLS;
import com.ibm.ccl.soa.deploy.core.validator.resolution.DeployResolution;
import com.ibm.ccl.soa.deploy.core.validator.resolution.DeployResolutionGenerator;
import com.ibm.ccl.soa.deploy.core.validator.resolution.IDeployResolution;
import com.ibm.ccl.soa.deploy.core.validator.resolution.IDeployResolutionContext;
import com.ibm.ccl.soa.deploy.core.validator.status.DeployStatusIterator;
import com.ibm.ccl.soa.deploy.core.validator.status.ICoreProblemType;
import com.ibm.ccl.soa.deploy.core.validator.status.IDeployStatus;
import com.ibm.ccl.soa.deploy.internal.core.validator.status.DeployActionStatus;
import com.ibm.ccl.soa.deploy.was.WasCellUnit;
import com.ibm.ccl.soa.deploy.was.WasNodeGroupUnit;
import com.ibm.ccl.soa.deploy.was.WasPackage;
import com.ibm.ccl.soa.deploy.was.internal.validator.WasDomainMessages;
import com.ibm.ccl.soa.deploy.was.validator.IWasValidatorID;

/**
 * Resolution generator to generate resolutions to host a cluster on a distributed websphere cell
 * and associate it with a node group defined in that cell.
 */
public class HostClusterOnCellWithNodeGroupResolutionGenerator extends DeployResolutionGenerator {

	// some helpful short cuts
	private static EClass clusterType = WasPackage.Literals.WAS_CLUSTER_UNIT;
	private static EClass reqType = CorePackage.Literals.REQUIREMENT;
	private static EClass nodeGroupType = WasPackage.Literals.WAS_NODE_GROUP_UNIT;
	private static String UNIT_NOT_HOSTED = ICoreProblemType.UNIT_NOT_HOSTED;
	private static String DEPENDENCY_REQUIREMENT_UNMATCHED = ICoreProblemType.UNIT_DEPENDENCY_REQUIREMENT_UNMATCHED;
	private static IDeployResolution[] noResolutions = new IDeployResolution[0];

	public IDeployResolution[] getResolutions(IDeployResolutionContext context) {
		IDeployStatus status = context.getDeployStatus();

		String problem = status.getProblemType();

		DeployModelObject dmo = status.getDeployObject();
		if (null == dmo) {
			return noResolutions;
		}

		EClass dmoType = dmo.getEObject().eClass();

		// if problem is UNIT_NOT_HOSTED && dmoType is clusterType OR
		//    problem is DEPENDENCY_REQUIREMENT_UNMATCHED && dmoType is Req && dmo.getParent is cluster
		// then we are good; else fail

		if (UNIT_NOT_HOSTED.equals(problem)) {
			if (!clusterType.isSuperTypeOf(dmoType)) {
				return noResolutions;
			}
		} else if (DEPENDENCY_REQUIREMENT_UNMATCHED.equals(problem)) {
			if (reqType.isSuperTypeOf(dmoType)) {
				if (nodeGroupType.isSuperTypeOf(((Requirement) dmo).getDmoEType())) {
					DeployModelObject dmoParent = dmo.getParent();
					if (null == dmoParent) {
						return noResolutions;
					}
					if (!clusterType.isSuperTypeOf(dmoParent.getEObject().eClass())) {
						return noResolutions;
					}
					dmo = dmoParent;
				}
			}
		} else {
			return noResolutions;
		}

		List<IDeployResolution> actions = new ArrayList<IDeployResolution>();
		for (DeployStatusIterator sIt = new DeployStatusIterator(dmo); sIt.hasNext();) {
			IDeployStatus s = sIt.next();
			if (s instanceof DeployActionStatus
					&& IWasValidatorID.WAS_HOST_CLUSTER_ON_CELL_WITH_NODE_GROUP.equals(s
							.getProblemType())) {
				List<DeployModelObject> parameters = ((DeployActionStatus) s).getParameters();
				WasCellUnit cell = (WasCellUnit) parameters.get(1);
				WasNodeGroupUnit nodeGroup = (WasNodeGroupUnit) parameters.get(2);
				String message = DeployNLS.bind(
						WasDomainMessages.Action_Host_Cluster_On_Cell_With_Node_Group_0, cell
								.getCaptionProvider().title(cell), nodeGroup.getCaptionProvider().title(
								nodeGroup));
				DeployResolution action = new HostClusterOnCellWithNodeGroupAction(context, this,
						message, parameters);
				actions.add(action);
			}
		}

		// convert to array
		IDeployResolution[] resolutions = new IDeployResolution[actions.size()];
		for (int i = 0; i < actions.size(); i++) {
			resolutions[i] = actions.get(i);
		}

		return resolutions;
	}

	public boolean hasResolutions(IDeployResolutionContext context) {
		IDeployStatus status = context.getDeployStatus();

		String problem = status.getProblemType();

		DeployModelObject dmo = status.getDeployObject();
		if (null == dmo) {
			return false;
		}

		EClass dmoType = dmo.getEObject().eClass();

		// if problem is UNIT_NOT_HOSTED && dmoType is clusterType OR
		//    problem is DEPENDENCY_REQUIREMENT_UNMATCHED && dmoType is Req && dmo.getParent is cluster
		// then we are good; else fail

		if (UNIT_NOT_HOSTED.equals(problem)) {
			if (!clusterType.isSuperTypeOf(dmoType)) {
				return false;
			}
		} else if (DEPENDENCY_REQUIREMENT_UNMATCHED.equals(problem)) {
			if (reqType.isSuperTypeOf(dmoType)) {
				DeployModelObject dmoParent = dmo.getParent();
				if (null == dmoParent) {
					return false;
				}
				if (!clusterType.isSuperTypeOf(dmoParent.getEObject().eClass())) {
					return false;
				}
				dmo = dmoParent;
			}
		} else {
			return false;
		}

		// look for status generated by HostClusterOnCellWithNodeGroupActionTest
		for (DeployStatusIterator sIt = new DeployStatusIterator(dmo); sIt.hasNext();) {
			IDeployStatus s = sIt.next();
			if (IWasValidatorID.WAS_HOST_CLUSTER_ON_CELL_WITH_NODE_GROUP.equals(s.getProblemType())) {
				return true;
			}
		}

		return false;
	}
}
