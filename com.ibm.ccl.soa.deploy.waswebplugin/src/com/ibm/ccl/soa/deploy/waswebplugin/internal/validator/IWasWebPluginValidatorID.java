/*******************************************************************************
 * Copyright (c) 2003, 2007 IBM Corporation Licensed Material - Property of IBM. All rights reserved.
 *  
 * US Government Users Restricted Rights - Use, duplication or disclosure v1.0 restricted by GSA ADP
 * Schedule Contract with IBM Corp.
 * 
 * Contributors: IBM Corporation - initial API and implementation
 *******************************************************************************/
package com.ibm.ccl.soa.deploy.waswebplugin.internal.validator;

import com.ibm.ccl.soa.deploy.was.WasPackage;
import com.ibm.ccl.soa.deploy.was.WasWebServerUnit;
import com.ibm.ccl.soa.deploy.waswebplugin.IhsWasPluginUnit;
import com.ibm.ccl.soa.deploy.waswebplugin.WasWebPluginDeployPlugin;
import com.ibm.ccl.soa.deploy.waswebplugin.validator.IWasWebPluginProblemTypes;
import com.ibm.ccl.soa.deploy.waswebplugin.validator.status.WasWebServerToIhsStatus;

/**
 * Validator identifiers for the {@link WasPackage} deploy domain.
 */
public interface IWasWebPluginValidatorID {

	/**
	 * <ul>
	 * <li>ID ={@value}
	 * <li>Status = {@link WasWebServerToIhsStatus}
	 * <li>Problem = {@link IWasWebPluginProblemTypes#WAS_WEB_SERVER_TO_IHS_CONSTRAINT_FAILS}
	 * <li>Description = Validates the constraint on a link from an {@link WasWebServerUnit} to a
	 * {@link IhsWasPluginUnit}.
	 * </ul>
	 */
	public final static String WAS_WEB_SERVER_TO_IHS_CONSTRAINT_VALIDATION = WasWebPluginDeployPlugin.PLUGIN_ID
			+ ".WAS_WEB_SERVER_TO_IHS_CONSTRAINT_VALIDATION"; //$NON-NLS-1$	

}
