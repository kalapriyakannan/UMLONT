/***************************************************************************************************
 * Copyright (c) 2003, 2007 IBM Corporation Licensed Material - Property of IBM. All rights
 * reserved.
 * 
 * US Government Users Restricted Rights - Use, duplication or disclosure v1.0 restricted by GSA ADP
 * Schedule Contract with IBM Corp.
 * 
 * Contributors: IBM Corporation - initial API and implementation
 **************************************************************************************************/
package com.ibm.ccl.soa.deploy.was.db2.validator;

import com.ibm.ccl.soa.deploy.core.validator.IDeployMarker;
import com.ibm.ccl.soa.deploy.was.db2.WasDB2Plugin;

/**
 * Defines the deploy model marker problem types for logical links.
 * 
 * @see IDeployMarker#PROBLEM_TYPE
 * 
 * This interface declares constants only; it is not intended to be implemented.
 */
public interface IWasDb2ProblemType {
	/**
	 * The logical link is not yet implemented.
	 */
	public static final String EARTODB_LOGICAL_LINK_NOT_IMPLEMENTED = WasDB2Plugin.PLUGIN_ID
			+ ".earToDbLogicalLinkNotImplemented"; //$NON-NLS-1$

	/**
	 * The Ear/Ejb/Web Module is not hosted (down to an OS).
	 */
	public static final String EAR2DBLL_EAR_NOT_HOSTED = WasDB2Plugin.PLUGIN_ID
			+ ".ear2DbLLEARNotHosted"; //$NON-NLS-1$

	/**
	 * It was not possible to identify the operating system; an intermediate component is marked as
	 * "installed" and no further information is available.
	 */
	public static final String DS_SAT_CANNOT_DETERMINE_OPERATING_SYSTEM = WasDB2Plugin.PLUGIN_ID
			+ ".datasourceSatisfactionConstraint_CannotDetermineOs"; //$NON-NLS-1$

	/**
	 * It was not possible to identify the WAS cell. It will not be possible to configure or validate
	 * authentication information.
	 */
	public static final String DS_SAT_CANNOT_DETERMINE_WAS_CELL = WasDB2Plugin.PLUGIN_ID
			+ ".datasourceSatisfactionConstraint_CannotDetermineWasCell"; //$NON-NLS-1$

	/**
	 * The SQL module (link target) is not hosted (on a DB2 database).
	 */
	public static final String EARTODDL_LL_SQL_MODULE_NOT_HOSTED = WasDB2Plugin.PLUGIN_ID
			+ ".EARTODDL_LL_SQL_MODULE_NOT_HOSTED"; //$NON-NLS-1$

	/**
	 * The DatabaseComponent (link target) is not hosted (on a DB2 database).
	 */
	public static final String TO_COMPONENT_LL_DATABASE_COMPONENT_NOT_HOSTED = WasDB2Plugin.PLUGIN_ID
			+ ".TO_COMPONENT_LL_DATABASE_COMPONENT_NOT_HOSTED"; //$NON-NLS-1$

	/**
	 * The DB2 database is not hosted (down to an OS).
	 */
	public static final String EAR2DBLL_DB_NOT_HOSTED = WasDB2Plugin.PLUGIN_ID
			+ ".ear2DbLLDbNotHosted"; //$NON-NLS-1$

	/**
	 * The DB2 instance is missing (may be missing if database is logically hosted.
	 */
	public static final String EAR2DBLL_DB_INSTANCE_ABSENT = WasDB2Plugin.PLUGIN_ID
			+ ".ear2DbLLDbInstanceAbsent"; //$NON-NLS-1$

	/**
	 * The DB2 instance hostname is not specified.
	 */
	public static final String DS_CONSTRAINT_DB_INSTANCE_HOSTNAME_UNSPECIFIED = WasDB2Plugin.PLUGIN_ID
			+ "DSConstraintInstanceHostnameUnspecified"; //$NON-NLS-1$

	/**
	 * A user with access to the database is not present.
	 */
	public static final String EAR2DBLL_DB_USERS_ABSENT = WasDB2Plugin.PLUGIN_ID
			+ ".ear2DbLLDbUsersAbsent"; //$NON-NLS-1$

	/**
	 * The logical link not yet (but can be).
	 */
	public static final String EARTODB_LOGICAL_LINK_NOT_IMPLEMENTED_BUT_CAN = WasDB2Plugin.PLUGIN_ID
			+ ".earToDbLogicalLinkNotImplementedButCan"; //$NON-NLS-1$
}
