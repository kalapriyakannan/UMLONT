/***************************************************************************************************
 * Copyright (c) 2003, 2007 IBM Corporation Licensed Material - Property of IBM. All rights
 * reserved.
 * 
 * US Government Users Restricted Rights - Use, duplication or disclosure v1.0 restricted by GSA ADP
 * Schedule Contract with IBM Corp.
 * 
 * Contributors: IBM Corporation - initial API and implementation
 **************************************************************************************************/
package com.ibm.ccl.soa.deploy.cmdb.ui;

import org.eclipse.osgi.util.NLS;

/**
 * @author barnold
 *
 */
public class Messages extends NLS {
	private static final String BUNDLE_NAME = "com.ibm.ccl.soa.deploy.cmdb.ui.Messages";//$NON-NLS-1$

	public static String CMDB_EXPLORER_SETTINGS_LABEL;

	public static String CmdbExplorerPreferencePage_2;

	public static String CmdbExplorerPreferencePage_3;
	
	public static String CmdbExplorerPreferencePage_EnableNavigatorPrefetcher;

	public static String CmdbExplorerPreferencePage_CmdbHostname;
	
	public static String CmdbExplorerPreferencePage_CmdbUserId;
	
	public static String CmdbExplorerPreferencePage_CmdbUserPassword;
	
	public static String CmdbRoot_CCMDBProductName;

	public static String RootTypesSelectionDialog_AddNewCDMType;

	public static String RootTypesSelectionDialog_FindNewCDMTypes;

	public static String RootTypesSelectionDialog_SelectRootTypesForExplorer;
	
	public static String Discover;
	public static String Discover_host;
	public static String Discover_hosted;
	public static String Discover_groups;
	public static String Discover_members;
	public static String Discover_dependency_targets;
	public static String Discover_dependency_sources;

	static {
		NLS.initializeMessages(BUNDLE_NAME, Messages.class);
	}
}
