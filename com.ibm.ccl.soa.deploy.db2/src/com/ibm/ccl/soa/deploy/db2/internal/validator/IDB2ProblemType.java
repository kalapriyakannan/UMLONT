/*******************************************************************************
 * Copyright (c) 2003, 2007 IBM Corporation Licensed Material - Property of IBM. All rights reserved.
 *  
 * US Government Users Restricted Rights - Use, duplication or disclosure v1.0 restricted by GSA ADP
 * Schedule Contract with IBM Corp.
 * 
 * Contributors: IBM Corporation - initial API and implementation
 *******************************************************************************/
package com.ibm.ccl.soa.deploy.db2.internal.validator;

import com.ibm.ccl.soa.deploy.core.validator.status.IDeployStatus;
import com.ibm.ccl.soa.deploy.db2.DB2DeployPlugin;
import com.ibm.ccl.soa.deploy.db2.Db2Package;

/**
 * Defines the deploy status problem types for the DB2 domain.
 * 
 * @see Db2Package
 * @see IDeployStatus#getProblemType()
 * 
 * This interface declares constants only; it is not intended to be implemented.
 */
public interface IDB2ProblemType {

	/**
	 * Instance missing link to instance admin user
	 * <p>
	 * Value = {@value}
	 */
	public static final String INSTANCE_MISSING_LINK_TO_INSTANCE_ADMIN_USER = DB2DeployPlugin.PLUGIN_ID
			+ ".instanceMissingLinkToInstanceAdminUser"; //$NON-NLS-1$	

	/**
	 * Instance missing link to missing instance admin user
	 * <p>
	 * Value = {@value}
	 */
	public static final String INSTANCE_MISSING_LINK_TO_MISSING_INSTANCE_ADMIN_USER = DB2DeployPlugin.PLUGIN_ID
			+ ".instanceMissingLinkToMissingInstanceAdminUser"; //$NON-NLS-1$

	/**
	 * Database is hosted directly on system; instance is missing
	 * <p>
	 * Value = {@value}
	 */
	public static final String DB2_INSTANCE_UNIT_MISSING = DB2DeployPlugin.PLUGIN_ID
			+ ".Db2InstanceUnitMissing"; //$NON-NLS-1$

	/**
	 * System unit has invalid installDir for hosting Windows operating system.
	 * <p>
	 * Value = {@value}
	 */
	public static final String DB2_INSTALL_DIR_INVALID_ON_WINDOWS_OPERATING_SYSTEM = DB2DeployPlugin.PLUGIN_ID
			+ ".Db2InstallDirInvalidOnWindowsOperatingSystem"; //$NON-NLS-1$	

	/**
	 * System unit has invalid installDir for hosting AIX or Solaris operating system.
	 * <p>
	 * Value = {@value}
	 */
	public static final String DB2_INSTALL_DIR_INVALID_ON_AIX_OR_SOLARIS_OPERATING_SYSTEM = DB2DeployPlugin.PLUGIN_ID
			+ ".Db2InstallDirInvalidOnAIXOrSolarisOperatingSystem"; //$NON-NLS-1$	

	/**
	 * Generic attribute not unique among units hosted by host of unit
	 * <p>
	 * Value = {@value}
	 */
	public static final String ATTRIBUTE_NOT_UNIQUE_AMONG_UNITS_HOSTED_BY_HOST_OF_UNIT = DB2DeployPlugin.PLUGIN_ID
			+ ".AttributeNotUniqueAmongUnitsHostedByHostOfUnit"; //$NON-NLS-1$
}
