/*******************************************************************************
 * Copyright (c) 2003, 2007 IBM Corporation Licensed Material - Property of IBM. All rights reserved.
 *  
 * US Government Users Restricted Rights - Use, duplication or disclosure v1.0 restricted by GSA ADP
 * Schedule Contract with IBM Corp.
 * 
 * Contributors: IBM Corporation - initial API and implementation
 *******************************************************************************/
package com.ibm.ccl.soa.deploy.core;

/**
 * Interface defines common constants used for annotation lookup.
 * 
 * @since 1.0
 */

public interface IAnnotationConstants {

	/**
	 * Constant defines development time context
	 */

	public static final String ENVIRONMENT_WTP = "environment_wtp"; //$NON-NLS-1$

	/**
	 * Constant defines development time AST context
	 */

	public static final String ENVIRONMENT_AST = "environment_ast"; //$NON-NLS-1$

	/**
	 * Constant defines dynamic resource type context
	 */

	public static final String DYNAMIC_RESOURCE_TYPE = "dynamic_resource_type"; //$NON-NLS-1$

	/**
	 * &lt;core:annotation&gt; context used in Topology .template files to name a 'root' Unit
	 */
	public static final String TOPOLOGY_ROOT = "topology_root"; //$NON-NLS-1$

	/**
	 * Constant defines project name
	 */

	public static final String PROJECT_NAME = "project_name"; //$NON-NLS-1$

	/**
	 * Constant defines an archive uri
	 */
	public static final String ARCHIVE_URI = "archive_uri"; //$NON-NLS-1$

	/**
	 * Constant defines the name of an archive that was contained in other archive
	 */
	public static final String CONTAINED_ARCHIVE_URI = "contained_archive_uri"; //$NON-NLS-1$

	/**
	 * Constant defines a module type, i.e jst.web, jst.ejb
	 */
	public static final String MODULE_TYPE = "module_type"; //$NON-NLS-1$

	/**
	 * Constant defines a key used to lookup runtime types
	 */
	public static final String RUNTIME_TYPE = "runtime_type"; //$NON-NLS-1$

	/**
	 * Constant defines a key used to lookup runtime instances
	 */
	public static final String RUNTIME_ID = "runtime_id"; //$NON-NLS-1$

}
