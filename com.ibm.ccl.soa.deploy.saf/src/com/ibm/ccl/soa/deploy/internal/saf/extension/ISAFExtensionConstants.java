/*******************************************************************************
 * Copyright (c) 2003, 2007 IBM Corporation Licensed Material - Property of IBM. All rights reserved.
 *  
 * US Government Users Restricted Rights - Use, duplication or disclosure v1.0 restricted by GSA ADP
 * Schedule Contract with IBM Corp.
 * 
 * Contributors: IBM Corporation - initial API and implementation
 *******************************************************************************/
package com.ibm.ccl.soa.deploy.internal.saf.extension;

/**
 * @since 1.0
 * 
 */
public interface ISAFExtensionConstants {
	// Extension point identifier, which needs to be kept in synch with plugin.xml.
	/** The string {@value #HANDLERS_EXT_POINT_ID }. */
	public static final String HANDLERS_EXT_POINT_ID = "handlers"; //$NON-NLS-1$

	/** The string {@value #CONTEXT_EXT_POINT_ID }. */
	public static final String CONTEXT_EXT_POINT_ID = "context"; //$NON-NLS-1$

	/** The string {@value #CONTEXTEXTENSION_EXT_POINT_ID }. */
	public static final String CONTEXTEXTENSION_EXT_POINT_ID = "contextExtension"; //$NON-NLS-1$

	/** The string {@value #TAG_ENABLEMENT }. */
	String TAG_ENABLEMENT = "enablement"; //$NON-NLS-1$

	/** The string {@value #TAG_INTERFACE_HANDLER }. */
	public static final String TAG_INTERFACE_HANDLER = "interfaceHandler";//$NON-NLS-1$

	/** The string {@value #TAG_CONTEXT }. */
	public static final String TAG_CONTEXT = "context";//$NON-NLS-1$

	/** The string {@value #TAG_CONTEXT_EXTENSION }. */
	public static final String TAG_CONTEXT_EXTENSION = "contextExtension";//$NON-NLS-1$

	/** The string {@value #TAG_CONTEXT_KEY }. */
	public static final String TAG_CONTEXT_KEY = "contextKey";//$NON-NLS-1$

	/** The string {@value #TAG_IMPLEMENTATION_KIND_CONSTRAINT }. */
	public static final String TAG_IMPLEMENTATION_KIND_CONSTRAINT = "implementationKindConstraint";//$NON-NLS-1$

	/** The string {@value #TAG_INTERFACE }. */
	public static final String TAG_INTERFACE = "interface";//$NON-NLS-1$

	/** The string {@value #TAG_SERVICE }. */
	public static final String TAG_SERVICE = "service";//$NON-NLS-1$

	/** The string {@value #TAG_SERVICE_TYPE }. */
	public static final String TAG_SERVICE_TYPE = "serviceType";//$NON-NLS-1$

	/** The string {@value #TAG_HANDLER_BINDING }. */
	public static final String TAG_HANDLER_BINDING = "handlerBinding";//$NON-NLS-1$

	/** The string {@value #ATTR_KIND }. */
	public static final String ATTR_KIND = "kind";//$NON-NLS-1$

	/** The string {@value #ATTR_DESC_KIND_NAME }. */
	public static final String ATTR_DESC_KIND_NAME = "descriptiveKindName";//$NON-NLS-1$

	/** The string {@value #ATTR_NAME }. */
	public static final String ATTR_NAME = "name";//$NON-NLS-1$

	/** The string {@value #ATTRDESCRIPTION }. */
	public static final String ATTR_DESCRIPTION = "description";//$NON-NLS-1$

	/** The string {@value #ATTR_SMALL_ICON }. */
	public static final String ATTR_SMALL_ICON = "smallIcon";//$NON-NLS-1$

	/** The string {@value #ATTR_LARGE_ICON }. */
	public static final String ATTR_LARGE_ICON = "largeIcon";//$NON-NLS-1$

	/** The string {@value #ATTR_CLASS }. */
	public static final String ATTR_CLASS = "class";//$NON-NLS-1$

	// Values used by the context filter extension point schema;
	// therefore, they need to be kept in synch with context.exsd.
	/** The string {@value #ATTR_EXTENSIBLE }. */
	public static final String ATTR_EXTENSIBLE = "extensible";//$NON-NLS-1$

	/** The string {@value #ATTR_KINDS }. */
	public static final String ATTR_KINDS = "kinds";//$NON-NLS-1$

	/** The string {@value #ATTR_INCLUDE_KINDS }. */
	public static final String ATTR_INCLUDE_KINDS = "includeKinds";//$NON-NLS-1$

	/** The string {@value #ATTR_NAMESPACE }. */
	public static final String ATTR_NAMESPACE = "namespace";//$NON-NLS-1$

	/** The string {@value #ATTR_ROOT_TYPE }. */
	public static final String ATTR_ROOT_TYPE = "rootType";//$NON-NLS-1$

	/** The string {@value #ATTR_SUB_TYPE }. */
	public static final String ATTR_SUB_TYPE = "subType";//$NON-NLS-1$

	/** The string {@value #ATTR_TYPE}. */
	public static final String ATTR_TYPE = "type";//$NON-NLS-1$

	/** The string {@value #ATTR_PACKAGE}. */
	public static final String ATTR_PACKAGE = "package";//$NON-NLS-1$

	/** The string {@value #ATTR_ETYPE}. */
	public static final String ATTR_ETYPE = "etype";//$NON-NLS-1$
}
