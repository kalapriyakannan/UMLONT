/*******************************************************************************
 * Copyright (c) 2003, 2007 IBM Corporation Licensed Material - Property of IBM. All rights reserved.
 *  
 * US Government Users Restricted Rights - Use, duplication or disclosure v1.0 restricted by GSA ADP
 * Schedule Contract with IBM Corp.
 * 
 * Contributors: IBM Corporation - initial API and implementation
 *******************************************************************************/
package com.ibm.ccl.soa.deploy.waswebplugin.internal.resolution;

import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;

import com.ibm.ccl.soa.deploy.core.DependencyLink;
import com.ibm.ccl.soa.deploy.core.DeployModelObject;
import com.ibm.ccl.soa.deploy.core.Unit;
import com.ibm.ccl.soa.deploy.core.validator.ValidatorUtils;
import com.ibm.ccl.soa.deploy.core.validator.resolution.DeployResolution;
import com.ibm.ccl.soa.deploy.core.validator.resolution.IDeployResolutionContext;
import com.ibm.ccl.soa.deploy.core.validator.resolution.IDeployResolutionGenerator;
import com.ibm.ccl.soa.deploy.ihs.IhsDomainMessages;
import com.ibm.ccl.soa.deploy.waswebplugin.IhsWasPluginUnit;
import com.ibm.ccl.soa.deploy.waswebplugin.validator.IWasWebPluginProblemTypes;
import com.ibm.ccl.soa.deploy.waswebplugin.validator.IhsWasPluginConfigurationActivePattern;

/**
 * Resolves {@link IWasWebPluginProblemTypes#IHS_WAS_PLUGIN_MODULE_CONFIGURATION_ERROR}
 */
public class IhsWasPluginConfigurationResolution extends DeployResolution {

	/**
	 * Construct an {@link IhsWasPluginUnit} configuration resolver.
	 * 
	 * @param context
	 *           the resolution context.
	 * @param generator
	 *           the resolution generator.
	 */
	public IhsWasPluginConfigurationResolution(IDeployResolutionContext context,
			IDeployResolutionGenerator generator) {
		super(context, generator);
		setDescription(IhsDomainMessages.Resolution_configure_ihs_server_for_was_plugin);
	}

	/*
	 * @see com.ibm.ccl.soa.deploy.core.validator.resolution.IDeployResolution#resolve(org.eclipse.core.runtime.IProgressMonitor)
	 */
	public IStatus resolve(IProgressMonitor monitor) {
		DeployModelObject object = context.getDeployStatus().getDeployObject();
		if (!(object instanceof DependencyLink)) {
			return Status.CANCEL_STATUS;
		}
		DependencyLink link = (DependencyLink) object;

		Unit wasPluginUnit = ValidatorUtils.getSourceUnit(link);
		if (!(wasPluginUnit instanceof IhsWasPluginUnit)) {
			return Status.CANCEL_STATUS;
		}
		IhsWasPluginConfigurationActivePattern pattern = new IhsWasPluginConfigurationActivePattern(
				(IhsWasPluginUnit) wasPluginUnit);
		return pattern.find(true, monitor);
	}
}
