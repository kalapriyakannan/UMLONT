/*******************************************************************************
 * Copyright (c) 2003, 2007 IBM Corporation Licensed Material - Property of IBM. All rights reserved.
 *  
 * US Government Users Restricted Rights - Use, duplication or disclosure v1.0 restricted by GSA ADP
 * Schedule Contract with IBM Corp.
 * 
 * Contributors: IBM Corporation - initial API and implementation
 *******************************************************************************/
package com.ibm.ccl.soa.deploy.was.validator.resolution;

import java.util.Iterator;

import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;

import com.ibm.ccl.soa.deploy.core.HostingLink;
import com.ibm.ccl.soa.deploy.core.Topology;
import com.ibm.ccl.soa.deploy.core.Unit;
import com.ibm.ccl.soa.deploy.core.util.DeployNLS;
import com.ibm.ccl.soa.deploy.core.validator.ValidatorUtils;
import com.ibm.ccl.soa.deploy.core.validator.resolution.DeployResolution;
import com.ibm.ccl.soa.deploy.core.validator.resolution.DeployResolutionGenerator;
import com.ibm.ccl.soa.deploy.core.validator.resolution.IDeployResolution;
import com.ibm.ccl.soa.deploy.core.validator.resolution.IDeployResolutionContext;
import com.ibm.ccl.soa.deploy.core.validator.resolution.IDeployResolutionGenerator;
import com.ibm.ccl.soa.deploy.was.WasCluster;
import com.ibm.ccl.soa.deploy.was.WebsphereAppServerUnit;
import com.ibm.ccl.soa.deploy.was.internal.validator.WasDomainMessages;
import com.ibm.ccl.soa.deploy.was.util.WasUtil;
import com.ibm.ccl.soa.deploy.was.validator.IWASProblemType;

/**
 * move applicationUnits hosting on server to cluster
 * 
 * @author lidb@cn.ibm.com
 * 
 */
public class MoveApplicationHostingOnServerToClusterResolutionGenerator extends
		DeployResolutionGenerator {

	public IDeployResolution[] getResolutions(IDeployResolutionContext context) {
		Unit applicationUnit = (Unit) context.getDeployStatus().getDeployObject();
		Topology top = applicationUnit.getTopology();

		Unit serverUnit = ValidatorUtils.getHost(applicationUnit);
		if ((serverUnit == null) || !(serverUnit instanceof WebsphereAppServerUnit))
			return null;

		WasCluster clusterCap = WasUtil.getWasClusterCap((WebsphereAppServerUnit) serverUnit, top);
		if (clusterCap == null)
			return null;

		return new IDeployResolution[] { new CreateMoveApplicationFromServerToClusterResolution(
				context, this, applicationUnit, serverUnit, (Unit) clusterCap.getParent()) };
	}

	public boolean hasResolutions(IDeployResolutionContext context) {
		if (IWASProblemType.APPLICATION_HOSTINGON_WASSERVER_WHO_IS_CLUSTER_MEMEBER.equals(context
				.getDeployStatus().getProblemType()))
			return true;

		return false;
	}

	private static class CreateMoveApplicationFromServerToClusterResolution extends DeployResolution {
		private Unit _applicationUnit;
		private Unit _serverUnit;
		private Unit _clusterUnit;

		public CreateMoveApplicationFromServerToClusterResolution(IDeployResolutionContext context,
				IDeployResolutionGenerator generator, Unit applicationUnit, Unit serverUnit,
				Unit clusterUnit) {
			super(
					context,
					generator,
					DeployNLS
							.bind(
									WasDomainMessages.Resolution_move_ApplicationUnit_0_from_ServerUnit_1_to_ClusterUnit_2,
									new Object[] { applicationUnit, serverUnit, clusterUnit }));
			_applicationUnit = applicationUnit;
			_serverUnit = serverUnit;
			_clusterUnit = clusterUnit;
		}

		public IStatus resolve(IProgressMonitor monitor) {
			if ((_serverUnit == null) || (_applicationUnit == null) || (_clusterUnit == null))
				return null;

			Iterator linksIt = _serverUnit.getHostingLinks().iterator();
			while (linksIt.hasNext()) {
				HostingLink link = (HostingLink) linksIt.next();
				if (link.getTarget().equals(_applicationUnit)) {
					_serverUnit.getHostingLinks().remove(link);
					WasUtil.hosts(_clusterUnit, _applicationUnit);
					break;
				}
			}
			return Status.OK_STATUS;
		}

	}

}
