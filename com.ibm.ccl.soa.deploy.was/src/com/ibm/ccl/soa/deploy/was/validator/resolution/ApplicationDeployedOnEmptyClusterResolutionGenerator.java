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
import com.ibm.ccl.soa.deploy.core.InstallState;
import com.ibm.ccl.soa.deploy.core.Topology;
import com.ibm.ccl.soa.deploy.core.util.DeployNLS;
import com.ibm.ccl.soa.deploy.core.validator.ValidatorUtils;
import com.ibm.ccl.soa.deploy.core.validator.matcher.LinkFactory;
import com.ibm.ccl.soa.deploy.core.validator.resolution.DeployResolution;
import com.ibm.ccl.soa.deploy.core.validator.resolution.DeployResolutionGenerator;
import com.ibm.ccl.soa.deploy.core.validator.resolution.IDeployResolution;
import com.ibm.ccl.soa.deploy.core.validator.resolution.IDeployResolutionContext;
import com.ibm.ccl.soa.deploy.core.validator.resolution.IDeployResolutionGenerator;
import com.ibm.ccl.soa.deploy.core.validator.resolution.ResolutionUtils;
import com.ibm.ccl.soa.deploy.was.IWasTemplateConstants;
import com.ibm.ccl.soa.deploy.was.WasCell;
import com.ibm.ccl.soa.deploy.was.WasCellUnit;
import com.ibm.ccl.soa.deploy.was.WasCluster;
import com.ibm.ccl.soa.deploy.was.WasClusterUnit;
import com.ibm.ccl.soa.deploy.was.WasNode;
import com.ibm.ccl.soa.deploy.was.WasNodeUnit;
import com.ibm.ccl.soa.deploy.was.WasPackage;
import com.ibm.ccl.soa.deploy.was.WasProfileTypeEnum;
import com.ibm.ccl.soa.deploy.was.WasServer;
import com.ibm.ccl.soa.deploy.was.WebsphereAppServerUnit;
import com.ibm.ccl.soa.deploy.was.internal.validator.WasDomainMessages;
import com.ibm.ccl.soa.deploy.was.util.WasUtil;

public class ApplicationDeployedOnEmptyClusterResolutionGenerator extends DeployResolutionGenerator {

	public IDeployResolution[] getResolutions(IDeployResolutionContext context) {
		DeployModelObject dmo = context.getDeployStatus().getDeployObject();
		assert dmo instanceof WasClusterUnit;
		Topology top = dmo.getTopology();
		if (top == null) {
			return new IDeployResolution[0];
		}

		WasClusterUnit clusterUnit = (WasClusterUnit) dmo;
		WasCell wasCell = WasUtil.getWasCellCap(clusterUnit, top);
		List nodeCaps = WasUtil.getWasNodeCapsFromCellUnit((WasCellUnit) wasCell.getParent(), top);

		if (wasCell == null || nodeCaps == null || nodeCaps.size() <= 0) {
			return new IDeployResolution[] { new CreateNewServerToTheClusterResolution(context, this,
					clusterUnit) };
		}

		if (nodeCaps.size() == 1
				&& ((WasNode) nodeCaps.get(0)).getProfileType().equals(WasProfileTypeEnum.DMGR_LITERAL)) {
			return new IDeployResolution[] { new CreateNewServerToTheClusterResolution(context, this,
					clusterUnit) };
		}

		if (!clusterUnit.getInitInstallState().equals(InstallState.INSTALLED_LITERAL)) {
			List serverList = collectExistingServer(nodeCaps, top);
			if (serverList != null && serverList.size() > 0) {
				int size = serverList.size();
				IDeployResolution[] resolutions = new IDeployResolution[size];
				for (int i = 0; i < size; i++) {
					resolutions[i] = new AddExistServerFromNodeToTheClusterResolution(context, this,
							clusterUnit, (WebsphereAppServerUnit) serverList.get(i));
				}
				return resolutions;
			}
		}

		int size = nodeCaps.size();
		IDeployResolution[] resolutions = new IDeployResolution[size];
		for (int i = 0; i < size; i++) {
			WasNode node = (WasNode) nodeCaps.get(i);
			if (node.getProfileType().equals(WasProfileTypeEnum.DMGR_LITERAL)) {
				resolutions[i] = new CreateNewServerToTheClusterResolution(context, this, clusterUnit);
			} else {
				resolutions[i] = new CreateNewServerToTheClusterAndCertainNodeResolution(context, this,
						clusterUnit, (WasNodeUnit) node.getParent());
			}
		}
		return resolutions;
	}

	private List collectExistingServer(List nodeCaps, Topology top) {
		List serverList = new ArrayList();
		Iterator nodeCapIt = nodeCaps.iterator();
		while (nodeCapIt.hasNext()) {
			WasNode node = (WasNode) nodeCapIt.next();
			serverList.addAll(WasUtil.getWasAppServerUnitMemberList((WasNodeUnit) node.getParent(),
					top));
		}
		return serverList;
	}

	public boolean hasResolutions(IDeployResolutionContext context) {
		// MK 8/23/2007 disabled resolution generation until generator is contract aware
//		if (IWasValidatorID.VALIDAT_APPLICATION_HOSTINGON_ON_EMPTY_CLUSTER.equals(context
//				.getDeployStatus().getValidatorID())) {
//			return true;
//		}
		return false;
	}

	private static class CreateNewServerToTheClusterResolution extends DeployResolution {
		private final WasClusterUnit _wasClusterUnit;

		public CreateNewServerToTheClusterResolution(IDeployResolutionContext context,
				IDeployResolutionGenerator generator, WasClusterUnit wasClusterUnit) {
			super(context, generator, WasDomainMessages.Resolution_create_new_cluster_member);
			_wasClusterUnit = wasClusterUnit;
		}

		public IStatus resolve(IProgressMonitor monitor) {
			WasCluster wasClusterCap = (WasCluster) ValidatorUtils.getCapability(_wasClusterUnit,
					WasPackage.eINSTANCE.getWasCluster());
			assert wasClusterCap != null;
			assert wasClusterCap.getWasVersion() != null;
			createServerToCluster(wasClusterCap);

			return Status.OK_STATUS;
		}

	}

	public static WebsphereAppServerUnit createServerToCluster(WasCluster wasClusterCap) {
		WebsphereAppServerUnit server1Unit = null;
		if (wasClusterCap.getWasVersion().startsWith(WasUtil.WAS_5_MAIN_VERSION)) {
			server1Unit = (WebsphereAppServerUnit) ResolutionUtils.addFromTemplate(
					IWasTemplateConstants.WAS_5_APPLICATION_SERVER_UNIT, wasClusterCap.getTopology());
		} else {
			server1Unit = (WebsphereAppServerUnit) ResolutionUtils.addFromTemplate(
					IWasTemplateConstants.WAS_6_APPLICATION_SERVER_UNIT, wasClusterCap.getTopology());
		}

		if (server1Unit != null) {
			server1Unit.setDescription(WasDomainMessages.Resolution_create_server_description);
			WasClusterUnit clusterUnit = (WasClusterUnit) wasClusterCap.getParent();
			LinkFactory.createMemberLink(clusterUnit, server1Unit);
			WasServer serverCap = (WasServer) ValidatorUtils.getCapability(server1Unit,
					WasPackage.eINSTANCE.getWasServer());
			if (serverCap != null) {
//				serverCap.setServerName("clusterMember_1"); //$NON-NLS-1$
				serverCap.setWasVersion(wasClusterCap.getWasVersion());
			}
		}
		return server1Unit;
	}

	private static class CreateNewServerToTheClusterAndCertainNodeResolution extends
			DeployResolution {
		private final WasClusterUnit _wasClusterUnit;
		private final WasNodeUnit _nodeUnit;

		public CreateNewServerToTheClusterAndCertainNodeResolution(IDeployResolutionContext context,
				IDeployResolutionGenerator generator, WasClusterUnit clusterUnit, WasNodeUnit nodeUnit) {
			super(context, generator, DeployNLS.bind(
					WasDomainMessages.Resolution_create_server_in_WasNodeUnit_0_as_clusterUnit_1_member,
					nodeUnit, clusterUnit));
			_wasClusterUnit = clusterUnit;
			_nodeUnit = nodeUnit;
		}

		public IStatus resolve(IProgressMonitor monitor) {
			WasCluster wasClusterCap = (WasCluster) ValidatorUtils.getCapability(_wasClusterUnit,
					WasPackage.eINSTANCE.getWasCluster());
			assert wasClusterCap != null;
			assert wasClusterCap.getWasVersion() != null;
			WebsphereAppServerUnit server1Unit = createServerToCluster(wasClusterCap);
			if (server1Unit != null) {
				ResolutionUtils.hosts(context, _nodeUnit, server1Unit);
			}
			return Status.OK_STATUS;
		}

	}

	private static class AddExistServerFromNodeToTheClusterResolution extends DeployResolution {
		private final WasClusterUnit _wasClusterUnit;
		private final WebsphereAppServerUnit _serverUnit;

		public AddExistServerFromNodeToTheClusterResolution(IDeployResolutionContext context,
				IDeployResolutionGenerator generator, WasClusterUnit clusterUnit,
				WebsphereAppServerUnit serverUnit) {
			super(context, generator, DeployNLS.bind(
					WasDomainMessages.Resolution_add_server_0_as_clusterUnit_1_member, serverUnit,
					clusterUnit));

			_wasClusterUnit = clusterUnit;
			_serverUnit = serverUnit;
		}

		public IStatus resolve(IProgressMonitor monitor) {
			LinkFactory.createMemberLink(_wasClusterUnit, _serverUnit);
			WasServer serverCap = (WasServer) ValidatorUtils.getCapability(_serverUnit,
					WasPackage.eINSTANCE.getWasServer());
			if (serverCap != null) {
//				serverCap.setServerName("clusterMember_1"); //$NON-NLS-1$
			}
			return Status.OK_STATUS;
		}

	}
}
