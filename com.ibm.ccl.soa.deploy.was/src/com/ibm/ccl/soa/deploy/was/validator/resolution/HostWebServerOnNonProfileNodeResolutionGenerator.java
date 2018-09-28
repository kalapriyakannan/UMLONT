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

import java.util.List;

import org.eclipse.core.runtime.IProgressMonitor;

import com.ibm.ccl.soa.deploy.core.HostingLink;
import com.ibm.ccl.soa.deploy.core.InstallState;
import com.ibm.ccl.soa.deploy.core.Unit;
import com.ibm.ccl.soa.deploy.core.validator.ValidatorUtils;
import com.ibm.ccl.soa.deploy.core.validator.resolution.DeployResolutionGenerator;
import com.ibm.ccl.soa.deploy.core.validator.resolution.IDeployResolution;
import com.ibm.ccl.soa.deploy.core.validator.resolution.IDeployResolutionContext;
import com.ibm.ccl.soa.deploy.was.WasNode;
import com.ibm.ccl.soa.deploy.was.WasNodeUnit;
import com.ibm.ccl.soa.deploy.was.WasPackage;
import com.ibm.ccl.soa.deploy.was.WasProfileTypeEnum;
import com.ibm.ccl.soa.deploy.was.WasWebServer;
import com.ibm.ccl.soa.deploy.was.WasWebServerUnit;

/**
 * Resolves the hosting of a {@link WasWebServer} on a {@link WasNode} whose profile type is
 * <em>not</em> {@link WasProfileTypeEnum#NONE}.
 */
public class HostWebServerOnNonProfileNodeResolutionGenerator extends DeployResolutionGenerator {

	/*
	 * @see com.ibm.ccl.soa.deploy.core.validator.resolution.IDeployResolutionGenerator#getResolutions(com.ibm.ccl.soa.deploy.core.validator.resolution.IDeployResolutionContext)
	 */
	public IDeployResolution[] getResolutions(IDeployResolutionContext context) {
		if (!hasResolutions(context)) {
			return new IDeployResolution[0];
		}

		HostingLink link = (HostingLink) context.getDeployStatus().getDeployObject();
		WasNodeUnit wasNodeUnit = (WasNodeUnit) link.getSource();
		WasWebServerUnit wasWebServerUnit = (WasWebServerUnit) link.getTarget();
		return new IDeployResolution[] { new HostWebServerOnNoneProfileNodeResolution(
				wasWebServerUnit, wasNodeUnit, context, this) };
	}

	/*
	 * @see com.ibm.ccl.soa.deploy.core.validator.resolution.IDeployResolutionGenerator#hasResolutions(com.ibm.ccl.soa.deploy.core.validator.resolution.IDeployResolutionContext)
	 */
	public boolean hasResolutions(IDeployResolutionContext context) {
		if (!(context.getDeployStatus().getDeployObject() instanceof HostingLink)) {
			return false;
		}
		HostingLink link = (HostingLink) context.getDeployStatus().getDeployObject();
		if (!(link.getSource() instanceof WasNodeUnit)
				|| !(link.getTarget() instanceof WasWebServerUnit)) {
			return false;
		}
		if (link.getTarget().getInitInstallState() == InstallState.INSTALLED_LITERAL) {
			return false;
		}
		WasNodeUnit wasNodeUnit = (WasNodeUnit) link.getSource();
		WasNode wasNode = (WasNode) ValidatorUtils.getFirstCapability(wasNodeUnit,
				WasPackage.Literals.WAS_NODE);
		if (wasNode != null && wasNode.getProfileType() != WasProfileTypeEnum.NONE_LITERAL) {
			// check that resolution has permission to do what it needs to:
			// (a) Unhost the WebServerUnit from the profile node
			// (b) Create a new unmanaged node copying the profile information of the previous node
			// (c) Host the new WasNodeUnit on the WasSystemUnit
			// (d) Host the WebServerUnit on the new WasNodeUnit
			// (e) Add the new WasNodeUnit to cell

			IProgressMonitor monitor = context.getProgressMonitor();

			// (a) Unhost the WebServerUnit from the profile node
			// The hosting link must be in the edit topology
			Unit systemUnit = ValidatorUtils.discoverHost(wasNodeUnit, monitor);
			List<HostingLink> links = systemUnit.getHostingLinks();
			for (HostingLink hLink : links) {
				if (hLink.getTarget() == wasNodeUnit) {
					if (hLink.getTopology() != hLink.getEditTopology()) {
						return false;
					}
				}
			}

			// (b) Create a new unmanaged node copying the profile information of the previous node
			// can always create the node

			// (c) Host the new WasNodeUnit on the WasSystemUnit
			// WasSystemUnit must be public
			if (!systemUnit.isPublic()) {
				return false;
			}

			// (d) Host the WebServerUnit on the new WasNodeUnit
			// WasServerUnit must be public
			if (!link.getTarget().isPublic()) {
				return false;
			}

			// (e) Add the new WasNodeUnit to cell
			// cell is public
			Unit cellUnit = ValidatorUtils.discoverGroupByUnitType(wasNodeUnit,
					WasPackage.Literals.WAS_CELL_UNIT, monitor);
			if (cellUnit != null) {
				if (!cellUnit.isPublic()) {
					return false;
				}
			}

			return true;
		}

		return false;
	}
}
