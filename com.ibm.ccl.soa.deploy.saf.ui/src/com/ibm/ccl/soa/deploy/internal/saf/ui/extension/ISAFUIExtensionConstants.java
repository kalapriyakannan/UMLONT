/***************************************************************************************************
 * Copyright (c) 2003, 2007 IBM Corporation Licensed Material - Property of IBM. All rights
 * reserved.
 * 
 * US Government Users Restricted Rights - Use, duplication or disclosure v1.0 restricted by GSA ADP
 * Schedule Contract with IBM Corp.
 * 
 * Contributors: IBM Corporation - initial API and implementation
 **************************************************************************************************/
package com.ibm.ccl.soa.deploy.internal.saf.ui.extension;

/**
 * @since 1.0
 * 
 */
public interface ISAFUIExtensionConstants {
	// Extension point identifier, which needs to be kept in synch with plugin.xml.
	/** The string {@value #HANDLERS_EXT_POINT_ID }. */
	public static final String UIHANDLERS_EXT_POINT_ID = "uihandlers"; //$NON-NLS-1$

	/** The string {@value #TAG_ENABLEMENT }. */
	String TAG_ENABLEMENT = "enablement"; //$NON-NLS-1$

	// Values used by the component implemenation handler extension point schema;
	// therefore, they need to be kept in synch with handler.exsd.

	/** The string {@value #TAG_INTERFACE_HANDLER }. */
	public static final String TAG_INTERFACE_UIHANDLER = "interfaceUIHandler";//$NON-NLS-1$

	/** The string {@value #TAG_ARTIFACT_HANDLER }. */
	public static final String TAG_ARTIFACT_UIHANDLER = "artifactUIHandler";//$NON-NLS-1$

	/** The string {@value #ATTR_KIND }. */
	public static final String ATTR_KIND = "kind";//$NON-NLS-1$

	/** The string {@value #ATTR_NAME }. */
	public static final String ATTR_NAME = "name";//$NON-NLS-1$

	/** The string {@value #ATTRDESCRIPTION }. */
	public static final String ATTR_DESCRIPTION = "description";//$NON-NLS-1$

	/** The string {@value #ATTR_CLASS }. */
	public static final String ATTR_CLASS = "class";//$NON-NLS-1$		
}
