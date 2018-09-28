/*******************************************************************************
 * Copyright (c) 2003, 2007 IBM Corporation Licensed Material - Property of IBM. All rights reserved.
 *  
 * US Government Users Restricted Rights - Use, duplication or disclosure v1.0 restricted by GSA ADP
 * Schedule Contract with IBM Corp.
 * 
 * Contributors: IBM Corporation - initial API and implementation
 *******************************************************************************/
package com.ibm.ccl.soa.deploy.waswebplugin.internal.resolution;

import com.ibm.ccl.soa.deploy.core.validator.resolution.DeployResolutionGenerator;
import com.ibm.ccl.soa.deploy.core.validator.resolution.IDeployResolution;
import com.ibm.ccl.soa.deploy.core.validator.resolution.IDeployResolutionContext;
import com.ibm.ccl.soa.deploy.core.validator.resolution.pattern.HostTemplateDeployResolution;
import com.ibm.ccl.soa.deploy.ihs.IhsPackage;
import com.ibm.ccl.soa.deploy.waswebplugin.validator.IWasWebPluginProblemTypes;

/**
 * Resolves {@link IWasWebPluginProblemTypes.IHS_WAS_PLUGIN_ADMIN_MODULE_HAS_NO_USER}.
 */
public class MissingIhsUserResolutionGenerator extends DeployResolutionGenerator {

	/*
	 * @see com.ibm.ccl.soa.deploy.core.validator.resolution.IDeployResolutionGenerator#getResolutions(com.ibm.ccl.soa.deploy.core.validator.resolution.IDeployResolutionContext)
	 */
	public IDeployResolution[] getResolutions(IDeployResolutionContext context) {
		return new IDeployResolution[] { new HostTemplateDeployResolution(context, this,
				"ihsUserUnitTool.spec", //$NON-NLS-1$)
				IhsPackage.eINSTANCE.getIhsUser().getName()) };
	}

	/*
	 * @see com.ibm.ccl.soa.deploy.core.validator.resolution.IDeployResolutionGenerator#hasResolutions(com.ibm.ccl.soa.deploy.core.validator.resolution.IDeployResolutionContext)
	 */
	public boolean hasResolutions(IDeployResolutionContext context) {
		return IWasWebPluginProblemTypes.IHS_WAS_PLUGIN_ADMIN_MODULE_HAS_NO_USER.equals(context
				.getDeployStatus().getProblemType());
	}
}
