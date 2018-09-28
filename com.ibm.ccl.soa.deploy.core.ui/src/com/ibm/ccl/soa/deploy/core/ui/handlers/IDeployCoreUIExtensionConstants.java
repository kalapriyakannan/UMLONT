/*******************************************************************************
 * Copyright (c) 2003, 2007 IBM Corporation Licensed Material - Property of IBM. All rights reserved.
 *  
 * US Government Users Restricted Rights - Use, duplication or disclosure v1.0 restricted by GSA ADP
 * Schedule Contract with IBM Corp.
 * 
 * Contributors: IBM Corporation - initial API and implementation
 *******************************************************************************/
package com.ibm.ccl.soa.deploy.core.ui.handlers;

/**
 * Provides standard constants for the parsing of extension points for the
 * <b>com.ibm.ccl.soa.deploy.core.ui</b>
 * 
 */
public interface IDeployCoreUIExtensionConstants {
	/** The string {@value #COMPOSITE_FACTORIES_EXT_POINT_ID }. */
	public static final String COMPOSITE_FACTORIES_EXT_POINT_ID = "compositeFactories"; //$NON-NLS-1$

	/** The string {@value #TAG_COMPOSITE_FACTORY }. */
	public static final String TAG_COMPOSITE_FACTORY = "compositeFactory";//$NON-NLS-1$

	/** The string {@value #ATTR_NAME }. */
	public static final String ATTR_NAME = "name";//$NON-NLS-1$

	/** The string {@value #ATTR_DESCRIPTION }. */
	public static final String ATTR_DESCRIPTION = "description";//$NON-NLS-1$

	/** The string {@value #ATTR_CLASS }. */
	public static final String ATTR_CLASS = "class";//$NON-NLS-1$		
}
