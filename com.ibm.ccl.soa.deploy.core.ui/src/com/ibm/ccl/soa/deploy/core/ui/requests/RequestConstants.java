/*******************************************************************************
 * Copyright (c) 2003, 2007 IBM Corporation Licensed Material - Property of IBM. All rights reserved.
 *  
 * US Government Users Restricted Rights - Use, duplication or disclosure v1.0 restricted by GSA ADP
 * Schedule Contract with IBM Corp.
 * 
 * Contributors: IBM Corporation - initial API and implementation
 *******************************************************************************/
package com.ibm.ccl.soa.deploy.core.ui.requests;

import org.eclipse.gef.Request;

/**
 * The set of constants used to identify <code>Requests</code> by their {@link Request#getType()
 * type}. Applications can extend this set of constants with their own.
 */
public interface RequestConstants {

	/**
	 * Indicates the display of quick fix when the user clicks on the error or warning
	 */
	public static final String REQ_SHOW_QUICK_FIX = "show quickfix";//$NON-NLS-1$

	/**
	 * Indicates the display of service/reference popup when the user clicks on the nub
	 */
	public static final String REQ_SHOW_NUB_EDIT = "show nub edit";//$NON-NLS-1$

//	/**
//	 * Indicates a custom filter being applied
//	 */
//	public static final String REQ_CUSTOM_FILTER  = "custom_filter";//$NON-NLS-1$
//	
//	/**
//	 * Indicates any custom filter being removed
//	 */
//	public static final String REQ_NO_CUSTOM_FILTER  = "no_custom_filter";//$NON-NLS-1$

	public static final String REQ_HOVER = "hover"; //$NON-NLS-1$

	public static final String REQ_SELECTED = "selected"; //$NON-NLS-1$

	public static final String REQ_TARGET = "target"; //$NON-NLS-1$

	public static final String REQ_TARGET_HOVER = "target_hover"; //$NON-NLS-1$

	public static final String REQ_NONE = "none"; //$NON-NLS-1$

	public static final String STATE_LINK_SELECTED = "link_selected"; //$NON-NLS-1$

	public static final String STATE_LINK_UNSELECTED = "link_unselected"; //$NON-NLS-1$
}
