/*******************************************************************************
 * Copyright (c) 2003, 2007 IBM Corporation Licensed Material - Property of IBM. All rights reserved.
 *  
 * US Government Users Restricted Rights - Use, duplication or disclosure v1.0 restricted by GSA ADP
 * Schedule Contract with IBM Corp.
 * 
 * Contributors: IBM Corporation - initial API and implementation
 *******************************************************************************/
package com.ibm.ccl.soa.deploy.database.ui;

import org.eclipse.osgi.util.NLS;

public class Messages extends NLS {
	private static final String BUNDLE_NAME = "com.ibm.ccl.soa.deploy.database.ui.Messages";//$NON-NLS-1$

	public static String DDLInterface_Title;
	public static String DDLService_Title;
	public static String SchemaUri_Label;
	public static String OpenSchema_Label;
	public static String SCHEMA_NOT_SET;
	public static String Edit_DDL_interface;
	public static String DisplayName;
	public static String Description;
	public static String Service;
	public static String Interface;
	public static String Database_Unit;

	public static String SqlModuleEditPart_SQL_DDL_File;

	public static String DatabaseComponentEditPart_Database_Component;

	static {
		NLS.initializeMessages(BUNDLE_NAME, Messages.class);
	}
}
