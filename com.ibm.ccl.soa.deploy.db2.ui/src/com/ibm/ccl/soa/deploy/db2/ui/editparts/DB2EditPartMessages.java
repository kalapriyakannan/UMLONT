/*******************************************************************************
 * Copyright (c) 2003, 2007 IBM Corporation Licensed Material - Property of IBM. All rights reserved.
 *  
 * US Government Users Restricted Rights - Use, duplication or disclosure v1.0 restricted by GSA ADP
 * Schedule Contract with IBM Corp.
 * 
 * Contributors: IBM Corporation - initial API and implementation
 *******************************************************************************/
package com.ibm.ccl.soa.deploy.db2.ui.editparts;

import org.eclipse.osgi.util.NLS;

public class DB2EditPartMessages extends NLS {
	private static final String BUNDLE_NAME = "com.ibm.ccl.soa.deploy.db2.ui.editparts.messages"; //$NON-NLS-1$

	public static String DB2_Admin_Client;

	public static String DB2_Admin_Server;

	public static String DB2_App_Dev_Client;

	public static String DB2_Database_Catalog;

	public static String DB2_Node_Catalog;

	public static String DB2_0_Instance;

	public static String DB2_Client_0_Instance;

	public static String DB2_0_System;

	public static String DB2_0_Runtime_Client;

	public static String DB2_0_Client;

	public static String DB2_0_Database;

	static {
		// initialize resource bundle
		NLS.initializeMessages(BUNDLE_NAME, DB2EditPartMessages.class);
	}

	private DB2EditPartMessages() {
	}
}
