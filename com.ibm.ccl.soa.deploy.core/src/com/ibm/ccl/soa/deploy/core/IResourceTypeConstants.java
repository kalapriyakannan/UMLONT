/***************************************************************************************************
 * Copyright (c) 2003, 2007 IBM Corporation Licensed Material - Property of IBM. All rights
 * reserved.
 * 
 * US Government Users Restricted Rights - Use, duplication or disclosure v1.0 restricted by GSA ADP
 * Schedule Contract with IBM Corp.
 * 
 * Contributors: IBM Corporation - initial API and implementation
 **************************************************************************************************/
package com.ibm.ccl.soa.deploy.core;

/**
 * Interface defines common constants used for resource type binding.
 * 
 * @since 1.0
 */

public interface IResourceTypeConstants {

	/**
	 * Constant defines development time WTP context
	 */

	public static final String CONTEXT_WTP = "wtp"; //$NON-NLS-1$

	/**
	 * Constant defines development time AST context
	 */

	public static final String CONTEXT_AST = "ast"; //$NON-NLS-1$

	/**
	 * Resource type for conceptual node
	 */
	public static final String DATABASE_COMPONENT_RESOURCE_ID = "database.databaseComponent"; //$NON-NLS-1$
}
