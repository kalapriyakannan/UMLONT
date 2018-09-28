/*******************************************************************************
 * Copyright (c) 2003, 2007 IBM Corporation Licensed Material - Property of IBM. All rights reserved.
 *  
 * US Government Users Restricted Rights - Use, duplication or disclosure v1.0 restricted by GSA ADP
 * Schedule Contract with IBM Corp.
 * 
 * Contributors: IBM Corporation - initial API and implementation
 *******************************************************************************/
package com.ibm.ccl.soa.deploy.waswebplugin.validator.resolution;

import org.eclipse.emf.ecore.EClass;

import com.ibm.ccl.soa.deploy.core.DeployModelObject;
import com.ibm.ccl.soa.deploy.core.validator.resolution.DeployResolutionGenerator;
import com.ibm.ccl.soa.deploy.core.validator.resolution.IDeployResolution;
import com.ibm.ccl.soa.deploy.core.validator.resolution.IDeployResolutionContext;
import com.ibm.ccl.soa.deploy.core.validator.status.IDeployStatus;
import com.ibm.ccl.soa.deploy.was.WasWebServerUnit;
import com.ibm.ccl.soa.deploy.waswebplugin.IhsWasPluginUnit;
import com.ibm.ccl.soa.deploy.waswebplugin.WasWebPluginDomainMessages;
import com.ibm.ccl.soa.deploy.waswebplugin.WaswebpluginPackage;
import com.ibm.ccl.soa.deploy.waswebplugin.validator.IWasWebPluginProblemTypes;
import com.ibm.ccl.soa.deploy.waswebplugin.validator.status.WasWebServerToIhsStatus;

/**
 * Generator for resolution to configure access via a datasource reference to a database.
 */
public class ConfigureWasWebServerToIhsResolutionGenerator extends DeployResolutionGenerator {

	public IDeployResolution[] getResolutions(IDeployResolutionContext context) {
		// sanity check
		if (!hasResolutions(context)) {
			return new IDeployResolution[0];
		}

		String description = WasWebPluginDomainMessages.Resolution_configure_ihs_server_for_was_plugin;

		WasWebServerToIhsStatus status = (WasWebServerToIhsStatus) context.getDeployStatus();

		WasWebServerUnit server = status.getWasWebServer();
		IhsWasPluginUnit plugin = status.getIhsPlugin();

		return new IDeployResolution[] { new ConfigureWasWebServerToIhsResolution(context, this,
				description, server, plugin) };
	}

	public boolean hasResolutions(IDeployResolutionContext context) {
		IDeployStatus status = context.getDeployStatus();

		if (!(status instanceof WasWebServerToIhsStatus)) {
			return false;
		}

		if (!IWasWebPluginProblemTypes.WAS_WEB_SERVER_TO_IHS_CONSTRAINT_FAILS.equals(status
				.getProblemType())) {
			return false;
		}

		// this resolution works on DatasourceSatisfactionConstraint
		DeployModelObject object = status.getDeployObject();
		EClass objectType = object.getEObject().eClass();
		if (!WaswebpluginPackage.Literals.WAS_WEB_SERVER_TO_IHS_CONSTRAINT.isSuperTypeOf(objectType)) {
			return false;
		}

		// source and target are not null
		WasWebServerUnit server = ((WasWebServerToIhsStatus) status).getWasWebServer();
		if (null == server) {
			return false;
		}

		IhsWasPluginUnit plugin = ((WasWebServerToIhsStatus) status).getIhsPlugin();
		if (null == plugin) {
			return false;
		}

		//TODO verify can do what want to do:
		//   what gets done?

		return true;
	}

}
