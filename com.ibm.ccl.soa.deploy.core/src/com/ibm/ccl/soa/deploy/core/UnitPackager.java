/*******************************************************************************
 * Copyright (c) 2003, 2007 IBM Corporation Licensed Material - Property of IBM. All rights reserved.
 *  
 * US Government Users Restricted Rights - Use, duplication or disclosure v1.0 restricted by GSA ADP
 * Schedule Contract with IBM Corp.
 * 
 * Contributors: IBM Corporation - initial API and implementation
 *******************************************************************************/
package com.ibm.ccl.soa.deploy.core;

import java.io.InputStream;

/**
 * @since 3.2
 * 
 */
public abstract class UnitPackager {

	/**
	 * Create an input stream for the given unit that will serialize a valid export format.
	 * 
	 * @param unit
	 *           DeploymentPlan
	 * @return list of ExportMetaData
	 * @throws Exception
	 */
	public abstract InputStream createPackage(Unit unit) throws Exception;

	/**
	 * @return
	 */
	// public String getArchiveName();
	// TODO complete this interface
}
