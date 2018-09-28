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

import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;

import com.ibm.ccl.soa.deploy.core.DeployModelObject;
import com.ibm.ccl.soa.deploy.core.Topology;
import com.ibm.ccl.soa.deploy.core.util.DeployNLS;
import com.ibm.ccl.soa.deploy.core.validator.ValidatorUtils;
import com.ibm.ccl.soa.deploy.core.validator.resolution.DeployResolution;
import com.ibm.ccl.soa.deploy.core.validator.resolution.DeployResolutionGenerator;
import com.ibm.ccl.soa.deploy.core.validator.resolution.IDeployResolution;
import com.ibm.ccl.soa.deploy.core.validator.resolution.IDeployResolutionContext;
import com.ibm.ccl.soa.deploy.core.validator.resolution.IDeployResolutionGenerator;
import com.ibm.ccl.soa.deploy.core.validator.resolution.ResolutionUtils;
import com.ibm.ccl.soa.deploy.core.validator.status.IDeployStatus;
import com.ibm.ccl.soa.deploy.was.IWasTemplateConstants;
import com.ibm.ccl.soa.deploy.was.WasNode;
import com.ibm.ccl.soa.deploy.was.WasNodeUnit;
import com.ibm.ccl.soa.deploy.was.WasPackage;
import com.ibm.ccl.soa.deploy.was.WasProfileTypeEnum;
import com.ibm.ccl.soa.deploy.was.WasServer;
import com.ibm.ccl.soa.deploy.was.WebsphereAppServerUnit;
import com.ibm.ccl.soa.deploy.was.internal.validator.WasDomainMessages;
import com.ibm.ccl.soa.deploy.was.util.WasUtil;
import com.ibm.ccl.soa.deploy.was.validator.IWASProblemType;

/**
 * insert server1 for defaultType Node resolution generator
 * 
 * @author lidb@cn.ibm.com
 * 
 */
public class InsertServer1ForEmptyDefaultNodeGenerator extends DeployResolutionGenerator {

	public boolean hasResolutions(IDeployResolutionContext context) {
		IDeployStatus status = context.getDeployStatus();
		if (null == status) {
			return false;
		}

		// check problem type
		if (!IWASProblemType.EMPTY_DEFAULT_WAS_NODE_IN_A_STANDALONE_WAS_CELL.equals(context
				.getDeployStatus().getProblemType())) {
			return false;
		}

		// check input parameters
		DeployModelObject obj = status.getDeployObject();
		if (!WasPackage.Literals.WAS_NODE_UNIT.isSuperTypeOf(obj.getEObject().eClass())) {
			return false;
		}

		// check that resolution will have permission needed to complete
		//    (a) create a new server
		//    (b) host the new server on the node

		// (a) create a server
		// can always do this in the edit topology

		// (b) host the new server on the node
		// the node must be public
		if (!obj.isPublic()) {
			return false;
		}

		return true;
	}

	public IDeployResolution[] getResolutions(IDeployResolutionContext context) {
		IDeployStatus status = context.getDeployStatus();
		WasNodeUnit nodeUnit = (WasNodeUnit) status.getDeployObject();
		return new IDeployResolution[] { new InsertServer1ForEmptyDefaultNodeResolution(context,
				this, nodeUnit) };
	}

	private static class InsertServer1ForEmptyDefaultNodeResolution extends DeployResolution {
		private WasNodeUnit _nodeUnit = null;
		private Topology _top;

		public InsertServer1ForEmptyDefaultNodeResolution(IDeployResolutionContext context,
				IDeployResolutionGenerator generator, WasNodeUnit nodeUnit) {
			super(context, generator);
			_nodeUnit = nodeUnit;
			setDescription(DeployNLS
					.bind(
							WasDomainMessages.Resolution_create_Default_Was_Server1_Unit_for_Empty_Default_NodeUnit_0,
							_nodeUnit));
		}

		public IStatus resolve(IProgressMonitor monitor) {
			WasNode nodeCap = (WasNode) ValidatorUtils.getCapability(_nodeUnit, WasPackage.eINSTANCE
					.getWasNode());
			if (nodeCap == null) {
				return Status.CANCEL_STATUS;
			} else if (!nodeCap.getProfileType().equals(WasProfileTypeEnum.DEFAULT_LITERAL)) {
				return null;
			}

			_top = nodeCap.getEditTopology();
			String nodeVersion = nodeCap.getWasVersion();

			String serverTemplate = null;
			if (nodeVersion != null) {
				if (WasUtil.compare2VersionString(nodeVersion, WasUtil.WAS_6_MAIN_VERSION) >= 0) {
					serverTemplate = _nodeUnit.isConceptual() ? IWasTemplateConstants.WAS_6_APPLICATION_SERVER_UNIT_CONCEPTUAL
							: IWasTemplateConstants.WAS_6_APPLICATION_SERVER_UNIT;
				} else if (WasUtil.compare2VersionString(nodeVersion, WasUtil.WAS_5_MAIN_VERSION) < 0) {
					return Status.CANCEL_STATUS;
				} else {
					serverTemplate = _nodeUnit.isConceptual() ? IWasTemplateConstants.WAS_5_APPLICATION_SERVER_UNIT_CONCEPTUAL
							: IWasTemplateConstants.WAS_5_APPLICATION_SERVER_UNIT;
				}
			}
			WebsphereAppServerUnit server1Unit = (WebsphereAppServerUnit) ResolutionUtils
					.addFromTemplate(serverTemplate, _top);
			if (null == server1Unit) {
				return Status.CANCEL_STATUS;
			}

			server1Unit.setDescription(WasDomainMessages.Resolution_create_server_description);
			ResolutionUtils.hosts(context, _nodeUnit, server1Unit);
			WasServer serverCap = (WasServer) ValidatorUtils.getCapability(server1Unit,
					WasPackage.eINSTANCE.getWasServer());
			if (serverCap != null) {
				serverCap.setServerName("server1"); //$NON-NLS-1$
				serverCap.setWasVersion(nodeVersion);
			}

			return Status.OK_STATUS;

		}
	}

}
