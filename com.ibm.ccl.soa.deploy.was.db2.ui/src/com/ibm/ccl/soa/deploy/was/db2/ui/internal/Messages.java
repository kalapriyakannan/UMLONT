/***************************************************************************************************
 * Copyright (c) 2003, 2007 IBM Corporation Licensed Material - Property of IBM. All rights
 * reserved.
 * 
 * US Government Users Restricted Rights - Use, duplication or disclosure v1.0 restricted by GSA ADP
 * Schedule Contract with IBM Corp.
 * 
 * Contributors: IBM Corporation - initial API and implementation
 **************************************************************************************************/
package com.ibm.ccl.soa.deploy.was.db2.ui.internal;

import org.eclipse.osgi.util.NLS;

/**
 * The externalized strings for the Logical Link Support.
 */
public class Messages extends NLS {

	private static final String BUNDLE_NAME = "com.ibm.ccl.soa.deploy.was.db2.ui.internal.messages"; //$NON-NLS-1$

	/**
	 * Validator_Ear2DbLL_Can_Implement
	 */
	public static String Validator_Ear2DbLL_Can_Implement;

	/**
	 * InsertNewDatabaseInstance_Exception_trying_to_resolve_marker
	 */
	public static String InsertNewDatabaseInstance_Exception_trying_to_resolve_marker_;

	/**
	 * Select_User_Dialog
	 */
	public static String Select_User_Dialog;

	/**
	 * DB2UserID
	 */
	public static String DB2UserID;

	/**
	 * Unknown_provider
	 */
	public static String Unknown_provider;

	/**
	 * Resolution_Configure_Database_Access
	 */
	public static String Resolution_Configure_Database_Access;

	public static String SelectUserDialog_EnterUser;
	public static String SelectUserDialog_Username;
	public static String SelectUserDialog_UserPassword;
	public static String SelectUserDialog_ConfirmUserPassword;
	public static String SelectUserDialog_PasswordMismatch;
	public static String SelectUserDialog_SelectionInstruction;
	public static String SelectUserDialog_SelectionInstruction2;

	static {
		NLS.initializeMessages(BUNDLE_NAME, Messages.class);
	}

}
