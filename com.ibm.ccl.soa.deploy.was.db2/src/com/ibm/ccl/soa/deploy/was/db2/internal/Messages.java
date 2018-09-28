/***************************************************************************************************
 * Copyright (c) 2003, 2007 IBM Corporation Licensed Material - Property of IBM. All rights
 * reserved.
 * 
 * US Government Users Restricted Rights - Use, duplication or disclosure v1.0 restricted by GSA ADP
 * Schedule Contract with IBM Corp.
 * 
 * Contributors: IBM Corporation - initial API and implementation
 **************************************************************************************************/
package com.ibm.ccl.soa.deploy.was.db2.internal;

import org.eclipse.osgi.util.NLS;

/**
 * The externalized strings for the Logical Link Support.
 */
public class Messages extends NLS {

	private static final String BUNDLE_NAME = "com.ibm.ccl.soa.deploy.was.db2.internal.messages"; //$NON-NLS-1$

	/**
	 * Validator_Ear2DbLL_EAR_Not_Hosted
	 */
	public static String Validator_Ear2DbLL_EAR_Not_Hosted;

	/**
	 * Validator_Ear2DbLL_DB_Not_Hosted
	 */
	public static String Validator_Ear2DbLL_DB_Not_Hosted;

	/**
	 * Validator_EAR2DbLL_DB_Instance_Absent
	 */
	public static String Validator_EAR2DbLL_DB_Instance_Absent;

	/**
	 * Validator_Ds_Constraint_Hostname_Unspecified
	 */
	public static String Validator_Ds_Constraint_Hostname_Unspecified;

	/**
	 * Validator_EAR2DbLL_DB_Users_Absent
	 */
	public static String Validator_EAR2DbLL_DB_Users_Absent;

	/**
	 * Validator_Ear2DbLL_Can_Implement
	 */
	public static String Validator_Ear2DbLL_Can_Implement;

	/**
	 * Validator_Cannot_Determine_WAS_Cell
	 */
	public static String Validator_Cannot_Determine_WAS_Cell;

	/**
	 * Validator_Cannot_Determine_Hosting_Cardinality
	 */
	public static String Validator_Cannot_Determine_Hosting_Cardinality;

	/**
	 * Validator_Exception_Executing_Preconditions
	 */
	public static String Validator_Exception_Executing_Preconditions;

	/**
	 * Select_User_Dialog
	 */
	public static String Select_User_Dialog;

	/**
	 * DB2UserID
	 */
	public static String DB2UserID;

	/**
	 * DatasourceSatisfactionConstraint_validation_failure
	 */
	public static String DatasourceSatisfactionConstraint_validation_failure;

	static {
		NLS.initializeMessages(BUNDLE_NAME, Messages.class);
	}

}
