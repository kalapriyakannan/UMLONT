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

import com.ibm.ccl.soa.deploy.core.util.UnitUtil;
import com.ibm.ccl.soa.deploy.core.validator.resolution.DeployResolution;
import com.ibm.ccl.soa.deploy.core.validator.resolution.IDeployResolutionContext;
import com.ibm.ccl.soa.deploy.core.validator.resolution.IDeployResolutionGenerator;
import com.ibm.ccl.soa.deploy.was.WasFactory;
import com.ibm.ccl.soa.deploy.was.WasSecurity;
import com.ibm.ccl.soa.deploy.was.WasUserRegistryTypes;
import com.ibm.ccl.soa.deploy.was.WebsphereAppServerUnit;
import com.ibm.ccl.soa.deploy.was.internal.validator.WasDomainMessages;

/**
 * Resolution to add a {@link WasSecurity} capbility to a {@link WebsphereAppServerUnit}
 */
public class ConfigureWasSecurityResolution extends DeployResolution {

	private final WebsphereAppServerUnit _server;
	private final boolean _security;
	private final WasUserRegistryTypes _registryType;

	/**
	 * Constructor for resolution
	 * 
	 * @param context
	 *           the resolution context
	 * @param generator
	 *           the resolution generator creating this resolution
	 * @param message
	 *           the resolution message
	 * @param server
	 *           Websphere application server where was security settings should be defined
	 * @param globalSecurity
	 *           flag indicating whether or not global security should be enabled
	 * @param registryType
	 *           user registry type
	 */
	public ConfigureWasSecurityResolution(IDeployResolutionContext context,
			IDeployResolutionGenerator generator, String message, WebsphereAppServerUnit server,
			boolean globalSecurity, WasUserRegistryTypes registryType) {
		super(context, generator, message);
		_server = server;
		_security = globalSecurity;
		_registryType = registryType;
	}

	public IStatus resolve(IProgressMonitor monitor) {

		WasSecurity security = WasFactory.eINSTANCE.createWasSecurity();
		security.setName(UnitUtil.assignUniqueName(_server));
		security.setDisplayName(WasDomainMessages.Resolution_configure_global_security_display_name);
		security.setGlobalSecurityEnabled(_security);
		if (_registryType != null) {
			security.setActiveUserRegistry(_registryType);
		}

		_server.getCapabilities().add(security);

		return Status.OK_STATUS;
	}

}
