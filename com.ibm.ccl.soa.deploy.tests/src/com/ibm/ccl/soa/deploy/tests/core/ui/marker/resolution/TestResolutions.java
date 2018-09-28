/*******************************************************************************
 * Copyright (c) 2003, 2007 IBM Corporation Licensed Material - Property of IBM. All rights reserved.
 *  
 * US Government Users Restricted Rights - Use, duplication or disclosure v1.0 restricted by GSA ADP
 * Schedule Contract with IBM Corp.
 * 
 * Contributors: IBM Corporation - initial API and implementation
 *******************************************************************************/
package com.ibm.ccl.soa.deploy.tests.core.ui.marker.resolution;

public class TestResolutions {

	public static final String PROPERTY = "com.ibm.ccl.soa.deploy.tests.core.ui.marker.resolution.enable";

	/**
	 * @return true if test resolutions should be provided.
	 */
	public static boolean isTesting() {
		return System.getProperty(PROPERTY) != null;
	}
}
