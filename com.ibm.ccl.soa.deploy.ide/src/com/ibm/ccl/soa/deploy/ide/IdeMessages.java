/***************************************************************************************************
 * Copyright (c) 2003, 2007 IBM Corporation Licensed Material - Property of IBM. All rights
 * reserved.
 * 
 * US Government Users Restricted Rights - Use, duplication or disclosure v1.0 restricted by GSA ADP
 * Schedule Contract with IBM Corp.
 * 
 * Contributors: IBM Corporation - initial API and implementation
 **************************************************************************************************/
package com.ibm.ccl.soa.deploy.ide;

import org.eclipse.osgi.util.NLS;

/**
 * The externalized strings for DeployCore.
 * 
 * @since 1.0
 * 
 */
public class IdeMessages extends NLS {

	private static final String BUNDLE_NAME = "com.ibm.ccl.soa.deploy.ide.messages"; //$NON-NLS-1$

	public static String NO_SCHEME_DESCRIPTION;
	public static String SIMPLE_SCHEME_DESCRIPTION;
	public static String SerializeDDLInterface_Error;

	public static String DatabasePublisherJob_Executing_Sql_statements_;

	public static String DatabasePublisherJob_Executing_sql_statemet_0_;

	public static String DataToolUnitPublisher_Execute_Sql_jo_;

	public static String Resolve_datasource_resolution_exception;
	public static String Resolve_datasource_resolution_description;

	///////////////////////////////////////////////////////////////////////////////////////

	static {
		NLS.initializeMessages(BUNDLE_NAME, IdeMessages.class);
	}

}
