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

import com.ibm.ccl.soa.deploy.internal.core.DeployCoreMessages;

/**
 * Deploy core constants.
 */
public interface IConstants {

	/**
	 * The separator character used by link URIs.
	 */
	static final char PATH_SEPARATOR = '/';

	/**
	 * The separator character used to identify elements in a URI based on index and not name. This
	 * is used when the name is not available.
	 */
	static final char INDEX_SEPARATOR = '@';

	/**
	 * The separator character used to separate the {@link DeployModelObject#getFullPath()} from the
	 * name of an attribute.
	 * <p>
	 * Example: <code>/Unit1/Capability2<b>#</b>userName</code>
	 */
	static final char ATTRIBUTE_SEPARATOR = '#';

	/**
	 * Path separator for fully-qualified or import-relative Topology
	 * 
	 * <p>
	 * Example: <code>com.acme.TopologyX<b>:</b>/Unit1/Capability2#userName</code>
	 */
	static final char TOPOLOGY_SEPARATOR = ':';

	/**
	 * Path separator for namespace fragments and Topology names.
	 * 
	 * <p>
	 * Example: <code>com<b>.</b>acme<b>.</b>TopologyX:/Unit1/Capability2#userName</code>
	 */
	static final char DOT_SEPARATOR = '.';

	/**
	 * Constant representing the absence of any status code.
	 */
	static final int S_DEFAULT = 0;

	/**
	 * Constant representing that the status code represents a failed attempt to resolve an element
	 * in the model.
	 */
	static final int S_FAILED_RESOLUTION = 1 << 1;
	/**
	 * 
	 */
	static final String MODULE_TYPE_DDL = "ddl";//$NON-NLS-1$

	/**
	 * File extension for diagram file.
	 */
	static final String TOPOLOGYV_EXTENSION = "topologyv"; //$NON-NLS-1$

	/**
	 * File extension for model file.
	 */
	static final String TOPOLOGY_EXTENSION = "topology"; //$NON-NLS-1$

	/**
	 * File extension for location file.
	 */
	static final String LOCBINDING_EXTENSION = "tloc"; //$NON-NLS-1$

	/**
	 * File name for location file.
	 */
	static final String DYNAMIC_TYPES_FILE = "dynamictypes.xml"; //$NON-NLS-1$

	/**
	 * Empty String
	 */
	static final String EMPTY_STRING = ""; //$NON-NLS-1$

	/**
	 * The name of the default group to which domain validators are assigned.
	 */
	static final String DEFAULT_VALIDATOR_GROUP_ID = "Default"; //$NON-NLS-1$

	public interface DecoratorSemanticConstants {

		/**
		 * Constant defines Business Application Decorator Semantic id
		 */
		public static final String BusinessApplicationDS_ID = "com.ibm.ccl.soa.deploy.core.bads"; //$NON-NLS-1$
		/**
		 * Constant defines Deployment Decorator Semantic id
		 */
		public static final String DeploymentDS_ID = "com.ibm.ccl.soa.deploy.core.dds"; //$NON-NLS-1$
		/**
		 * Constant defines Infrastructure Decorator Semantic id
		 */
		public static final String InfrastructureDS_ID = "com.ibm.ccl.soa.deploy.core.ids"; //$NON-NLS-1$
		/**
		 * Constant defines Template Design Decorator Semantic id
		 */
		public static final String TemplateDesignDS_ID = "com.ibm.ccl.soa.deploy.core.tdds"; //$NON-NLS-1$

		/**
		 * Constant for the blank decorator semantic
		 */
		public static final String BLANK_SEMANTIC = DeployCoreMessages.IConstants_Non_;

	}

	public interface LocationBindingConstants {

		/**
		 * Constant for the relative context for the location binding
		 */
		public static final String LOC_CTX_RELATIVE = "relative"; //$NON-NLS-1$
		/**
		 * Constant for the absolute context for the location binding
		 */
		public static final String LOC_CTX_ABSOLUTE = "absolute"; //$NON-NLS-1$

	}

	public static final String COMMUNICATION_VALDIATOR_ID = "COMMUNICATION VALIDATION_ID"; //$NON-NLS-1$

	public static final String PALETTE_VALDIATOR_ID = "PALETTE VALIDATION_ID"; //$NON-NLS-1$

}
