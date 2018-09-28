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

import com.ibm.ccl.soa.deploy.core.CorePackage;
import com.ibm.ccl.soa.deploy.core.HostingLink;
import com.ibm.ccl.soa.deploy.core.Unit;
import com.ibm.ccl.soa.deploy.core.util.DeployNLS;
import com.ibm.ccl.soa.deploy.core.validator.ValidatorUtils;
import com.ibm.ccl.soa.deploy.core.validator.resolution.DeployResolution;
import com.ibm.ccl.soa.deploy.core.validator.resolution.DeployResolutionGenerator;
import com.ibm.ccl.soa.deploy.core.validator.resolution.IDeployResolution;
import com.ibm.ccl.soa.deploy.core.validator.resolution.IDeployResolutionContext;
import com.ibm.ccl.soa.deploy.core.validator.resolution.IDeployResolutionGenerator;
import com.ibm.ccl.soa.deploy.core.validator.status.IDeployStatus;
import com.ibm.ccl.soa.deploy.os.OperatingSystem;
import com.ibm.ccl.soa.deploy.os.OsPackage;
import com.ibm.ccl.soa.deploy.os.WindowsOperatingSystem;
import com.ibm.ccl.soa.deploy.was.WasNodeWindowsServiceUnit;
import com.ibm.ccl.soa.deploy.was.internal.validator.WasDomainMessages;
import com.ibm.ccl.soa.deploy.was.validator.IWasValidatorID;

public class UnLinkWindowsServiceUnitFromNunOSWasNodeUnitResolutionGenerator extends
		DeployResolutionGenerator {

	public IDeployResolution[] getResolutions(IDeployResolutionContext context) {
		assert context.getDeployStatus().getDeployObject() instanceof WasNodeWindowsServiceUnit;
		WasNodeWindowsServiceUnit windowsServiceUnit = (WasNodeWindowsServiceUnit) context
				.getDeployStatus().getDeployObject();
		Unit nodeUnit = ValidatorUtils.getHost(windowsServiceUnit);
		if (nodeUnit == null) {
			return new IDeployResolution[0];
		}
		Unit wasSystemUnit = ValidatorUtils.getHost(nodeUnit);
		if (wasSystemUnit == null) {
			return new IDeployResolution[0];
		}
		Unit osUnit = ValidatorUtils.getHost(wasSystemUnit);
		if (osUnit == null) {
			return new IDeployResolution[0];
		}
		OperatingSystem wsCap = (OperatingSystem) ValidatorUtils.getCapability(osUnit,
				OsPackage.eINSTANCE.getOperatingSystem());
		if (wsCap == null) {
			return new IDeployResolution[0];
		}
		assert !(wsCap instanceof WindowsOperatingSystem);

		return new IDeployResolution[] { new UnlinkWindowsServiceWithNunWindowsWasNodeResolution(
				context, this, windowsServiceUnit, nodeUnit) };
	}

	public boolean hasResolutions(IDeployResolutionContext context) {

		IDeployStatus status = context.getDeployStatus();
		if (null == status) {
			return false;
		}

		if (!status.getValidatorID().equals(IWasValidatorID.WAS_WINDOWSSERVICE_HOSTINGSTACK_001)) {
			return false;
		}

		// check that we have permission to complete the resolution
		// to remove a link, it must be in the current edit topology
		// find the link and check that it can be deleted
		if (!CorePackage.Literals.UNIT.isSuperTypeOf(status.getDeployObject().getEObject().eClass())) {
			return false;
		}
		Unit unit = (Unit) status.getDeployObject();
		Unit node = ValidatorUtils.getHost(unit);
		if (null == node) {
			return false;
		}
		for (Iterator<HostingLink> linkIt = node.getHostingLinks().iterator(); linkIt.hasNext();) {
			HostingLink link = linkIt.next();
			if (link.getTarget().equals(unit)) {
				if (link.getTopology() != link.getEditTopology()) {
					return false;
				}
				return true;
			}
		}
		// no link was found
		return false;
	}

	private static class UnlinkWindowsServiceWithNunWindowsWasNodeResolution extends
			DeployResolution {
		private final Unit _windowsServiceUnit;
		private final Unit _wasNodeUnit;

		public UnlinkWindowsServiceWithNunWindowsWasNodeResolution(IDeployResolutionContext context,
				IDeployResolutionGenerator generator, Unit windowsServiceUnit, Unit wasNodeUnit) {
			super(context, generator, DeployNLS.bind(
					WasDomainMessages.Resolution_unlink_Unit_0_with_Unit_1, windowsServiceUnit,
					wasNodeUnit));
			_windowsServiceUnit = windowsServiceUnit;
			_wasNodeUnit = wasNodeUnit;
		}

		public IStatus resolve(IProgressMonitor monitor) {
			Iterator linkIt = _wasNodeUnit.getHostingLinks().iterator();
			while (linkIt.hasNext()) {
				HostingLink link = (HostingLink) linkIt.next();
				if (link.getTarget().equals(_windowsServiceUnit)) {
					_wasNodeUnit.getHostingLinks().remove(link);
					break;
				}
			}
			return Status.OK_STATUS;
		}

	}

}
