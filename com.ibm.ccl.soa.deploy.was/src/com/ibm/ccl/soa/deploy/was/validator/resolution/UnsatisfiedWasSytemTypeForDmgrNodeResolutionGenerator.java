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

import java.util.Iterator;

import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;

import com.ibm.ccl.soa.deploy.core.DeployModelObject;
import com.ibm.ccl.soa.deploy.core.HostingLink;
import com.ibm.ccl.soa.deploy.core.InstallState;
import com.ibm.ccl.soa.deploy.core.Unit;
import com.ibm.ccl.soa.deploy.core.util.DeployModelObjectUtil;
import com.ibm.ccl.soa.deploy.core.util.DeployNLS;
import com.ibm.ccl.soa.deploy.core.validator.ValidatorUtils;
import com.ibm.ccl.soa.deploy.core.validator.resolution.DeployResolution;
import com.ibm.ccl.soa.deploy.core.validator.resolution.DeployResolutionGenerator;
import com.ibm.ccl.soa.deploy.core.validator.resolution.IDeployResolution;
import com.ibm.ccl.soa.deploy.core.validator.resolution.IDeployResolutionContext;
import com.ibm.ccl.soa.deploy.core.validator.resolution.IDeployResolutionGenerator;
import com.ibm.ccl.soa.deploy.was.WasEditionEnum;
import com.ibm.ccl.soa.deploy.was.WasNode;
import com.ibm.ccl.soa.deploy.was.WasNodeUnit;
import com.ibm.ccl.soa.deploy.was.WasPackage;
import com.ibm.ccl.soa.deploy.was.WasProfileTypeEnum;
import com.ibm.ccl.soa.deploy.was.WasSystem;
import com.ibm.ccl.soa.deploy.was.WasSystemUnit;
import com.ibm.ccl.soa.deploy.was.internal.validator.WasDomainMessages;

public class UnsatisfiedWasSytemTypeForDmgrNodeResolutionGenerator extends
		DeployResolutionGenerator {

	public IDeployResolution[] getResolutions(IDeployResolutionContext context) {
		DeployModelObject dmo = context.getDeployStatus().getDeployObject();
		assert dmo instanceof HostingLink;
		HostingLink link = (HostingLink) dmo;
		Unit hostUnit = link.getHost();
		Unit hostedUnit = link.getHosted();
		assert hostUnit != null;
		assert hostedUnit != null;

		if (!(hostUnit instanceof WasSystemUnit)) {
			return new IDeployResolution[0];
		}
		if (!(hostedUnit instanceof WasNodeUnit)) {
			return new IDeployResolution[0];
		}

		WasNode nodeCap = (WasNode) ValidatorUtils.getCapability(hostedUnit, WasPackage.eINSTANCE
				.getWasNode());
		if (nodeCap == null) {
			return new IDeployResolution[0];
		}
		if (!WasProfileTypeEnum.DMGR_LITERAL.equals(nodeCap.getProfileType())) {
			return new IDeployResolution[0];
		}
		WasSystem systemCap = (WasSystem) ValidatorUtils.getCapability(link.getHost(),
				WasPackage.eINSTANCE.getWasSystem());
		if (systemCap == null) {
			return new IDeployResolution[0];
		}
		if (!WasEditionEnum.NETWORK_DEPLOYMENT_LITERAL.equals(systemCap.getWasEdition())) {
			if (InstallState.INSTALLED_LITERAL.equals(hostUnit.getInitInstallState())) {
				return new IDeployResolution[] { new UnlinkWasNodeUnitWithWasSystemUnitResolution(
						context, this, hostUnit, hostedUnit) };
			}

			return new IDeployResolution[] { new setWasSystem2NDEditionResolution(context, this,
					systemCap) };
		}
		return new IDeployResolution[0];
	}

	public boolean hasResolutions(IDeployResolutionContext context) {
		DeployModelObject dmo = context.getDeployStatus().getDeployObject();
		assert dmo instanceof HostingLink;
		HostingLink link = (HostingLink) dmo;
		assert link.getHost() != null;
		assert link.getHosted() != null;

		Unit host = link.getHost();

		if (!(link.getHosted() instanceof WasNodeUnit)) {
			return false;
		}
		if (!(link.getHost() instanceof WasSystemUnit)) {
			return false;
		}

		WasNode nodeCap = (WasNode) ValidatorUtils.getCapability(link.getHosted(),
				WasPackage.eINSTANCE.getWasNode());
		if (nodeCap == null) {
			return false;
		}
		if (!WasProfileTypeEnum.DMGR_LITERAL.equals(nodeCap.getProfileType())) {
			return false;
		}
		WasSystem systemCap = (WasSystem) ValidatorUtils.getCapability(link.getHost(),
				WasPackage.eINSTANCE.getWasSystem());
		if (systemCap == null) {
			return false;
		}

		if (!WasEditionEnum.NETWORK_DEPLOYMENT_LITERAL.equals(systemCap.getWasEdition())) {
			// check that we have permission to make the planned changes
			if (InstallState.INSTALLED_LITERAL.equals(host)) {
				// was system is installed; we will try to break the link
				// link must be in the current edit topology
				if (link.getTopology() != link.getEditTopology()) {
					return false;
				}
			} else {
				// was system is not installed; we will try to set the edition
				if (!DeployModelObjectUtil.isSettable(host, WasPackage.Literals.WAS_SYSTEM__WAS_EDITION
						.getName())) {
					return false;
				}
			}

			// we will be able to make the necessary changes
			return true;
		}

		if (!WasEditionEnum.NETWORK_DEPLOYMENT_LITERAL.equals(systemCap.getWasEdition())) {
			return true;
		}
		return false;
	}

	/**
	 * remove the link
	 * 
	 */
	private static class UnlinkWasNodeUnitWithWasSystemUnitResolution extends DeployResolution {
		private final Unit _host;
		private final Unit _hosted;

		public UnlinkWasNodeUnitWithWasSystemUnitResolution(IDeployResolutionContext context,
				IDeployResolutionGenerator generator, Unit hostUnit, Unit hostedUnit) {
			super(context, generator, DeployNLS.bind(
					WasDomainMessages.Resolution_unlink_Unit_0_with_Unit_1, hostedUnit, hostUnit));
			_host = hostUnit;
			_hosted = hostedUnit;
		}

		public IStatus resolve(IProgressMonitor monitor) {
			Iterator linkIt = _host.getHostingLinks().iterator();
			while (linkIt.hasNext()) {
				HostingLink link = (HostingLink) linkIt.next();
				if (link.getTarget().equals(_hosted)) {
					_host.getHostingLinks().remove(link);
					break;
				}
			}
			return Status.OK_STATUS;
		}

	}

	private static class setWasSystem2NDEditionResolution extends DeployResolution {
		private final WasSystem _systemCap;

		public setWasSystem2NDEditionResolution(IDeployResolutionContext context,
				IDeployResolutionGenerator generator, WasSystem systemCap) {
			super(context, generator, DeployNLS.bind(
					WasDomainMessages.Resolution_set_wasSystem_0_ND_Edition, systemCap));
			_systemCap = systemCap;
		}

		public IStatus resolve(IProgressMonitor monitor) {
			_systemCap.setWasEdition(WasEditionEnum.NETWORK_DEPLOYMENT_LITERAL);
			return Status.OK_STATUS;
		}

	}

}
