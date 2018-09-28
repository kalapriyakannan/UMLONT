/*******************************************************************************
 * Copyright (c) 2003, 2007 IBM Corporation Licensed Material - Property of IBM. All rights reserved.
 *  
 * US Government Users Restricted Rights - Use, duplication or disclosure v1.0 restricted by GSA ADP
 * Schedule Contract with IBM Corp.
 * 
 * Contributors: IBM Corporation - initial API and implementation
 *******************************************************************************/
package com.ibm.ccl.soa.deploy.db2;

import org.eclipse.osgi.util.NLS;

public class Messages extends NLS {
	private static final String BUNDLE_NAME = "com.ibm.ccl.soa.deploy.db2.Messages";//$NON-NLS-1$

	static {
		NLS.initializeMessages(BUNDLE_NAME, Messages.class);
	}

	public static String Resolution_create_database;
	public static String Resolution_create_database_instance;
	public static String Resolution_host_database_on_instance_0;
	public static String InsertNewDatabaseInstance_Exception_trying_to_resolve_marker_;
	public static String Resolution_suggest_path_0_to_1;
	public static String Resolution_propagate_userid_0_password_1_hostname_2;
	public static String Resolution_propagate_password_from_user_0;
	public static String Suggest_windows_install_dir_resolution_exception;
	public static String Userid_password_hostname_propagation_exception;
	public static String Password_propagation_exception;
	public static String WAS_DB2_classpath_invalid;
	public static String SuggestJdbcTypeGenerator_Set_JDBC_Type_to_;

}
