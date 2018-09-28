/*******************************************************************************
 * Copyright (c) 2003, 2007 IBM Corporation Licensed Material - Property of IBM. All rights reserved.
 *  
 * US Government Users Restricted Rights - Use, duplication or disclosure v1.0 restricted by GSA ADP
 * Schedule Contract with IBM Corp.
 * 
 * Contributors: IBM Corporation - initial API and implementation
 *******************************************************************************/
package com.ibm.ccl.soa.deploy.waswebplugin.validator;

import com.ibm.ccl.soa.deploy.core.validator.status.IDeployStatus;
import com.ibm.ccl.soa.deploy.ihs.IhsPackage;
import com.ibm.ccl.soa.deploy.ihs.IhsSystemUnit;
import com.ibm.ccl.soa.deploy.ihs.IhsUser;
import com.ibm.ccl.soa.deploy.ihs.IhsWasAdminModule;
import com.ibm.ccl.soa.deploy.ihs.IhsWasModule;
import com.ibm.ccl.soa.deploy.waswebplugin.IhsWasPluginUnit;
import com.ibm.ccl.soa.deploy.waswebplugin.WasWebPluginDeployPlugin;
import com.ibm.ccl.soa.deploy.waswebplugin.WasWebServerToIhsConstraint;

/**
 * Defines the problem types for the IBM HTTP Server (IHS) domain.
 * 
 * @see IhsPackage
 * @see IDeployStatus#getProblemType()
 * 
 * This interface declares constants only; it is not intended to be implemented.
 */
public interface IWasWebPluginProblemTypes {

	/**
	 * An {@link IhsWasPluginUnit} dependends on an {@link IhsSystemUnit} which has not been
	 * configured with the {@link IhsWasModule} and {@link IhsWasAdminModule}.
	 */
	public static final String IHS_WAS_PLUGIN_MODULE_CONFIGURATION_ERROR = WasWebPluginDeployPlugin.PLUGIN_ID
			+ ".ihsWasPluginModuleConfigurationError"; //$NON-NLS-1$

	/**
	 * An {@link IhsWasPluginAdminModule} does not host an {@link IhsUser}.
	 */
	public static final String IHS_WAS_PLUGIN_ADMIN_MODULE_HAS_NO_USER = WasWebPluginDeployPlugin.PLUGIN_ID
			+ ".ihsWasPluginAdminModuleHasNoUser"; //$NON-NLS-1$

	/**
	 * A {@link WasWebServerToIhsConstraint} does not hold.
	 */
	public static final String WAS_WEB_SERVER_TO_IHS_CONSTRAINT_FAILS = WasWebPluginDeployPlugin.PLUGIN_ID
			+ ".wasWebServerToIhsConstraintFails"; //$NON-NLS-1$

	/**
	 * An expected {@link IhsWasPluginUnit} was not found.
	 */
	public static final String IHS_WAS_PLUGIN_UNIT_NOT_FOUND = WasWebPluginDeployPlugin.PLUGIN_ID
			+ ".ihsWasPluginUnitNotFound"; //$NON-NLS-1$
}
