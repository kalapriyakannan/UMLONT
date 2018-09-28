/*******************************************************************************
 * Copyright (c) 2003, 2007 IBM Corporation Licensed Material - Property of IBM. All rights reserved.
 *  
 * US Government Users Restricted Rights - Use, duplication or disclosure v1.0 restricted by GSA ADP
 * Schedule Contract with IBM Corp.
 * 
 * Contributors: IBM Corporation - initial API and implementation
 *******************************************************************************/
package com.ibm.ccl.soa.deploy.ihs.validator;

import com.ibm.ccl.soa.deploy.core.validator.status.IDeployStatus;
import com.ibm.ccl.soa.deploy.ihs.IhsDeployPlugin;
import com.ibm.ccl.soa.deploy.ihs.IhsPackage;
import com.ibm.ccl.soa.deploy.ihs.IhsSystemUnit;
import com.ibm.ccl.soa.deploy.ihs.IhsWasAdminModule;
import com.ibm.ccl.soa.deploy.ihs.IhsWasModule;

/**
 * Defines the problem types for the IBM HTTP Server (IHS) domain.
 * 
 * @see IhsPackage
 * @see IDeployStatus#getProblemType()
 * 
 * This interface declares constants only; it is not intended to be implemented.
 */
public interface IIhsProblemTypes {

	/**
	 * An {@link IhsWasPluginUnit} dependends on an {@link IhsSystemUnit} which has not been
	 * configured with the {@link IhsWasModule} and {@link IhsWasAdminModule}.
	 */
	public static final String IHS_WAS_PLUGIN_MODULE_CONFIGURATION_ERROR = IhsDeployPlugin.PLUGIN_ID
			+ ".ihsWasPluginModuleConfigurationError"; //$NON-NLS-1$

}
