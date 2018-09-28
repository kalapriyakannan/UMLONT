/***************************************************************************************************
 * Copyright (c) 2003, 2007 IBM Corporation Licensed Material - Property of IBM. All rights
 * reserved.
 * 
 * US Government Users Restricted Rights - Use, duplication or disclosure v1.0 restricted by GSA ADP
 * Schedule Contract with IBM Corp.
 * 
 * Contributors: IBM Corporation - initial API and implementation
 **************************************************************************************************/
package com.ibm.ccl.soa.deploy.cmdb.ui.preferences;

/**
 * Defines preference constants for presentation plugin.
 * 
 * @author jswanke
 * 
 */
public interface IDeployCmdbPreferences {
	
	/**
	 * cmdb hostname or ip address
	 */
	public static final String CMDB_HOSTNAME = "CmdbPreference.hostname"; //$NON-NLS-1$

	/**
	 * cmdb userid to use
	 */
	public static final String CMDB_USERID = "CmdbPreference.userid"; //$NON-NLS-1$

	/**
	 * cmdb password to use
	 */
	public static final String CMDB_USERPASSWORD = "CmdbPreference.userpassword"; //$NON-NLS-1$


	/**
	 * filter generics (no specialized provider) from view
	 */
	public static final String CMDB_FILTER_GENERICS = "CmdbExplorerPreference.cmdb_filter_generics"; //$NON-NLS-1$
	
	/**
	 * use only the generic unit provider, not the translations to specific types. 
	 */
	public static final String CMDB_DISABLE_CUSTOM_UNIT_PROVIDER = "CmdbExplorerPreference.cmdb_use_only_generic_unit_provider"; //$NON-NLS-1$
	
	/**
	 * enable speculative cache prefetch for ccmdb navigator 
	 */
	public static final String CMDB_ENABLE_NAVIGATOR_PREFETCHER = "CmdbExplorerPreference.cmdb_enable_navigator_prefetch"; //$NON-NLS-1$
}
