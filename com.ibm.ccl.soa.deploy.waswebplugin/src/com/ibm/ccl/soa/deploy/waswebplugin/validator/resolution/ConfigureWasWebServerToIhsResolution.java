/*******************************************************************************
 * Copyright (c) 2003, 2007 IBM Corporation Licensed Material - Property of IBM. All rights reserved.
 *  
 * US Government Users Restricted Rights - Use, duplication or disclosure v1.0 restricted by GSA ADP
 * Schedule Contract with IBM Corp.
 * 
 * Contributors: IBM Corporation - initial API and implementation
 *******************************************************************************/
package com.ibm.ccl.soa.deploy.waswebplugin.validator.resolution;

import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;

import com.ibm.ccl.soa.deploy.core.validator.resolution.DeployResolution;
import com.ibm.ccl.soa.deploy.core.validator.resolution.IDeployResolutionContext;
import com.ibm.ccl.soa.deploy.core.validator.resolution.IDeployResolutionGenerator;
import com.ibm.ccl.soa.deploy.core.validator.resolution.ResolutionUtils;
import com.ibm.ccl.soa.deploy.was.WasWebServerUnit;
import com.ibm.ccl.soa.deploy.waswebplugin.IhsWasPluginUnit;
import com.ibm.ccl.soa.deploy.waswebplugin.validator.WasWebServerConfigurationActivePattern;

/**
 * Resolution to add a WAS security subject binding
 */
public class ConfigureWasWebServerToIhsResolution extends DeployResolution {

	private final WasWebServerUnit _server;
	private final IhsWasPluginUnit _plugin;

	/**
	 * Constructor for resolution
	 * 
	 * @param context
	 *           the resolution context
	 * @param generator
	 *           the resolution generator that created the resolution
	 * @param description
	 *           a description of the resolution
	 * @param server
	 *           the {@link WasWebServerUnit}
	 * @param plugin
	 *           the {@link IhsWasPluginUnit}
	 */
	public ConfigureWasWebServerToIhsResolution(IDeployResolutionContext context,
			IDeployResolutionGenerator generator, String description, WasWebServerUnit server,
			IhsWasPluginUnit plugin) {
		super(context, generator, description);
		_server = server;
		_plugin = plugin;
	}

	public IStatus resolve(IProgressMonitor monitor) {

		WasWebServerConfigurationActivePattern pattern = new WasWebServerConfigurationActivePattern(
				_server, _plugin);
		IStatus status = pattern.find(true, context.getProgressMonitor());
		if (!status.isOK()) {
			return status;
		}
		status = ResolutionUtils.setAllAttributesReported(_plugin, context
				.getDeployValidatorService(), null);

		return status;
	}

}
