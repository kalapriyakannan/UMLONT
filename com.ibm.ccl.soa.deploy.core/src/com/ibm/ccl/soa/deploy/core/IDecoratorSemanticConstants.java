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
 * Interface defines constants for decorator semantic ids
 * 
 * @since 1.0
 */

public interface IDecoratorSemanticConstants {

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
}
