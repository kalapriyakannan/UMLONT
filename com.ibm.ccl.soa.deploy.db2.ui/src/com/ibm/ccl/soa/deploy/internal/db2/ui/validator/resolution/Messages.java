/*******************************************************************************
 * Copyright (c) 2003, 2007 IBM Corporation Licensed Material - Property of IBM. All rights reserved.
 *  
 * US Government Users Restricted Rights - Use, duplication or disclosure v1.0 restricted by GSA ADP
 * Schedule Contract with IBM Corp.
 * 
 * Contributors: IBM Corporation - initial API and implementation
 *******************************************************************************/
package com.ibm.ccl.soa.deploy.internal.db2.ui.validator.resolution;

import org.eclipse.osgi.util.NLS;

public class Messages extends NLS {
	private static final String BUNDLE_NAME = "com.ibm.ccl.soa.deploy.internal.db2.ui.validator.resolution.messages"; //$NON-NLS-1$

	public static String DB2InstanceAdminPassword;

	public static String DB2InstanceAdminUserID;

	public static String CreateDB2InstanceAdminUser;

	public static String SelectSQLUserID_resolution_exception;

	public static String Select_SQL_User_Dialog;

	public static String SQLUserID;

	public static String UserPropertiesSetDialog_0;

	public static String UserPropertiesSetDialog_PasswordsDontMatch;

	public static String UserPropertiesSetDialog_SetPassword;

	static {
		// initialize resource bundle
		NLS.initializeMessages(BUNDLE_NAME, Messages.class);
	}
}
