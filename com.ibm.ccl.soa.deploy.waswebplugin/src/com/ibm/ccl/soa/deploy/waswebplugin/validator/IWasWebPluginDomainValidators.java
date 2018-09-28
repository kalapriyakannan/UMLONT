/*******************************************************************************
 * Copyright (c) 2003, 2007 IBM Corporation Licensed Material - Property of IBM. All rights reserved.
 *  
 * US Government Users Restricted Rights - Use, duplication or disclosure v1.0 restricted by GSA ADP
 * Schedule Contract with IBM Corp.
 * 
 * Contributors: IBM Corporation - initial API and implementation
 *******************************************************************************/
package com.ibm.ccl.soa.deploy.waswebplugin.validator;

import com.ibm.ccl.soa.deploy.core.DeployCorePlugin;
import com.ibm.ccl.soa.deploy.core.validator.status.ICoreProblemType;
import com.ibm.ccl.soa.deploy.core.validator.status.IDeployAttributeStatus;
import com.ibm.ccl.soa.deploy.core.validator.status.IDeployStatus;
import com.ibm.ccl.soa.deploy.ihs.IhsPackage;
import com.ibm.ccl.soa.deploy.waswebplugin.IhsWasPlugin;

/**
 * Validators IDs for the IBM HTTP Server (IHS) domain.
 * 
 * @see IhsPackage
 * @see IDeployStatus#getValidatorID()
 */
public interface IWasWebPluginDomainValidators {
	/**
	 * @deprecated use problem specific validator ID.
	 */
	public final static String UNDEFINED = DeployCorePlugin.PLUGIN_ID + ".UNDEFINED"; //$NON-NLS-1$

	/**
	 * <ul>
	 * <li>ID ={@value}
	 * <li>Status = {@link IDeployAttributeStatus}
	 * <li>Problem = {@link ICoreProblemType#OBJECT_ATTRIBUTE_INVALID}
	 * <li>Description = the {@link IhsWasPlugin#getInstallLocation()} is required and must be a
	 * valid path in the hosting operating system.
	 * </ul>
	 */
	public final static String IHS_WAS_PLUGIN_INSTALL_LOCATION_001 = DeployCorePlugin.PLUGIN_ID
			+ ".IHS_WAS_PLUGIN_INSTALL_LOCATION_001"; //$NON-NLS-1$

	/**
	 * <ul>
	 * <li>ID ={@value}
	 * <li>Status = {@link IDeployStatus}
	 * <li>Problem = {@link ICoreProblemType#XXX}
	 * <li>Description = TODO
	 * </ul>
	 */
	public final static String IHS_WAS_PLUGIN_CONFIGURED_001 = DeployCorePlugin.PLUGIN_ID
			+ ".IHS_WAS_PLUGIN_CONFIGURED_001"; //$NON-NLS-1$

	/**
	 * <ul>
	 * <li>ID ={@value}
	 * <li>Status = {@link IDeployStatus}
	 * <li>Problem = {@link ICoreProblemType#XXX}
	 * <li>Description = TODO
	 * </ul>
	 */
	public final static String IHS_WAS_PLUGIN_CONFIGURED_002 = DeployCorePlugin.PLUGIN_ID
			+ ".IHS_WAS_PLUGIN_CONFIGURED_002"; //$NON-NLS-1$
}
