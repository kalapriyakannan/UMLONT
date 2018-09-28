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
 * Provides a standard base class for extenders of the <b>com.ibm.ccl.soa.deploy.core.domains</b>
 * extension point who provide a <b>&lt;packager /&gt;</b> element.
 * 
 * @since 1.0
 * 
 */
public abstract class DomainPackager {

	/**
	 * Subclasses should override to supply an input stream for the unit.
	 * 
	 * @param unit
	 * @return an InputStream
	 */
	public abstract InputStream export(Unit unit);

	/**
	 * Subclasses should override to supply an extension for the packaged unit.
	 * 
	 * @param unit
	 * @return an String
	 */
	public abstract String getExtension(Unit unit);

}
