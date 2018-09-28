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

import com.ibm.ccl.soa.deploy.core.Unit;
import com.ibm.ccl.soa.deploy.core.validator.ValidatorUtils;
import com.ibm.ccl.soa.deploy.core.validator.resolution.DeployResolution;
import com.ibm.ccl.soa.deploy.core.validator.resolution.IDeployResolutionContext;
import com.ibm.ccl.soa.deploy.core.validator.resolution.IDeployResolutionGenerator;
import com.ibm.ccl.soa.deploy.core.validator.resolution.ResolutionUtils;
import com.ibm.ccl.soa.deploy.was.IWasTemplateConstants;
import com.ibm.ccl.soa.deploy.was.WasNode;
import com.ibm.ccl.soa.deploy.was.WasNodeUnit;
import com.ibm.ccl.soa.deploy.was.WasPackage;
import com.ibm.ccl.soa.deploy.was.WasProfileTypeEnum;
import com.ibm.ccl.soa.deploy.was.WasWebServerUnit;
import com.ibm.ccl.soa.deploy.was.internal.validator.WasDomainMessages;

/**
 * Change the hosting of a web server to a new node.
 */
public class HostWebServerOnNoneProfileNodeResolution extends DeployResolution {

	protected WasNodeUnit wasNodeUnit;

	protected WasWebServerUnit wasWebServerUnit;

	public HostWebServerOnNoneProfileNodeResolution(WasWebServerUnit wasWebServerUnit,
			WasNodeUnit wasNodeUnit, IDeployResolutionContext context,
			IDeployResolutionGenerator generator) {
		super(context, generator);
		description = WasDomainMessages.Resolution_host_web_server_on_new_node;
		this.wasNodeUnit = wasNodeUnit;
		this.wasWebServerUnit = wasWebServerUnit;
	}

	/*
	 * @see com.ibm.ccl.soa.deploy.core.validator.resolution.IDeployResolution#resolve(org.eclipse.core.runtime.IProgressMonitor)
	 */
	public IStatus resolve(IProgressMonitor monitor) {
		WasNode wasNode = (WasNode) ValidatorUtils.getFirstCapability(wasNodeUnit,
				WasPackage.Literals.WAS_NODE);
		// Find the WAS system hosting the WAS node
		Unit wasSystemUnit = ValidatorUtils.discoverHostAndAddToTopology(wasNodeUnit, monitor);

		// Find the Cell of the WAS node
		Unit wasNodeCellUnit = ValidatorUtils.discoverGroupAndAddToTopology(wasNodeUnit,
				WasPackage.Literals.WAS_CELL_UNIT, monitor);

		// Unhost the WebServerUnit from the profile node
		ResolutionUtils.unhost(wasNodeUnit, wasWebServerUnit);

		// TODO find if there is an existing NONE profile node

		// Create a new unmanaged node copying the profile information of the
		// previous node
		String templateId = wasNodeUnit.isConceptual() ? IWasTemplateConstants.WAS_WEB_SERVER_UNIT_CONCEPTUAL
				: IWasTemplateConstants.WAS_WEB_SERVER_UNIT;
		Unit webServerNodeUnit = (Unit) ResolutionUtils.addFromTemplate(templateId, wasNodeUnit
				.getTopology());
		WasNode webServerNode = (WasNode) ValidatorUtils.getFirstCapability(webServerNodeUnit,
				WasPackage.Literals.WAS_NODE);
		webServerNode.setProfileType(WasProfileTypeEnum.NONE_LITERAL);
		webServerNode.setProfileName(wasNode.getProfileName());
		webServerNode.setProfileLocation(wasNode.getProfileLocation());
		webServerNode.setIsDefaultProfile(false);
		webServerNode.setIsManaged(false);
		webServerNode.setWasVersion(wasNode.getWasVersion());
//		webServerNode.setNodeName("webservernode1");//$NON-NLS-1$

		// Host the WebServerNodeUnit on the WasSystemUnit
		ResolutionUtils.host(wasSystemUnit, webServerNodeUnit);

		// Host the WebServerUnit on the new WasNodeUnit
		ResolutionUtils.host(webServerNodeUnit, wasWebServerUnit);

		// Add to cell
		ResolutionUtils.addMember(context, wasNodeCellUnit, webServerNodeUnit);

		return Status.OK_STATUS;
	}
}
