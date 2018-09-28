/*******************************************************************************
 * Copyright (c) 2003, 2007 IBM Corporation Licensed Material - Property of IBM. All rights reserved.
 *  
 * US Government Users Restricted Rights - Use, duplication or disclosure v1.0 restricted by GSA ADP
 * Schedule Contract with IBM Corp.
 * 
 * Contributors: IBM Corporation - initial API and implementation
 *******************************************************************************/
package com.ibm.ccl.soa.deploy.os.validator.pattern.attribute;

import com.ibm.ccl.soa.deploy.os.OsDeployPlugin;
import com.ibm.ccl.soa.deploy.os.OsPackage;
import com.ibm.ccl.soa.deploy.os.Port;

/**
 * Defines the deploy model marker problem types for the os domain.
 * 
 * @see OsPackage
 * 
 * This interface declares constants only; it is not intended to be implemented.
 */
public interface IOsProblemType {
	/**
	 * Invalid path for hosting Windows operating system.
	 * <p>
	 * Value = {@value}
	 */
	public static final String PATH_INVALID_ON_WINDOWS_OPERATING_SYSTEM = OsDeployPlugin.PLUGIN_ID
			+ ".PathInvalidOnWindowsOperatingSystem"; //$NON-NLS-1$	

	/**
	 * Invalid path for hosting AIX or Solarix operating system
	 * 
	 * <p>
	 * Value = {@value}
	 */
	public static final String PATH_INVALID_ON_AIX_OR_SOLARIS_OPERATING_SYSTEM = OsDeployPlugin.PLUGIN_ID
			+ ".PathInvalidOnAIXOrSolarisOperatingSystem"; //$NON-NLS-1$	

	/**
	 * Invalid path for hosting Linux operating system
	 * 
	 * <p>
	 * Value = {@value}
	 */
	public static final String PATH_INVALID_ON_LINUX_OPERATING_SYSTEM = OsDeployPlugin.PLUGIN_ID
			+ ".PathInvalidOnLinuxOperatingSystem"; //$NON-NLS-1$		

	/**
	 * A unit is not hosting a configuration unit with a {@link Port} capability.
	 * <p>
	 * Value = {@value}
	 */
	public static final String PORT_CONFIG_MISSING = OsDeployPlugin.PLUGIN_ID + ".PortConfigMissing"; //$NON-NLS-1$		

	/**
	 * A unit hosting too many configuration unit with a {@link Port} capability.
	 * <p>
	 * Value = {@value}
	 */
	public static final String PORT_CONFIG_COUNT_EXCEEDED = OsDeployPlugin.PLUGIN_ID
			+ ".PortConfigCountExceeded"; //$NON-NLS-1$		
}
