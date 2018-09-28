/*******************************************************************************
 * Copyright (c) 2003, 2007 IBM Corporation Licensed Material - Property of IBM. All rights reserved.
 *  
 * US Government Users Restricted Rights - Use, duplication or disclosure v1.0 restricted by GSA ADP
 * Schedule Contract with IBM Corp.
 * 
 * Contributors: IBM Corporation - initial API and implementation
 *******************************************************************************/
package com.ibm.ccl.soa.deploy.internal.core.extension;

import java.io.InputStream;

import com.ibm.ccl.soa.deploy.core.DomainPackager;
import com.ibm.ccl.soa.deploy.core.Unit;

/**
 * Provides a default implementation of {@link DomainPackager} that can be returned when clients
 * provide unruly or errant extensions for <b>com.ibm.ccl.soa.core.deploy.domains</b>.
 * 
 * @since 1.0
 * @see DomainPackager
 * 
 */
public class SkeletonDomainPackager extends DomainPackager {

	/**
	 * The singleton instance.
	 */
	public static final SkeletonDomainPackager INSTANCE = new SkeletonDomainPackager();

	private SkeletonDomainPackager() {
	}

	public InputStream export(Unit unit) {
		// TODO Auto-generated method stub
		return null;
	}

	public String getExtension(Unit unit) {
		// TODO Auto-generated method stub
		return null;
	}

}
