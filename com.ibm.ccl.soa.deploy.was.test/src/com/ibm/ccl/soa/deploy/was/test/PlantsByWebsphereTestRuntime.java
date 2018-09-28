/*******************************************************************************
 * Copyright (c) 2003, 2007 IBM Corporation Licensed Material - Property of IBM. All rights reserved.
 *  
 * US Government Users Restricted Rights - Use, duplication or disclosure v1.0 restricted by GSA ADP
 * Schedule Contract with IBM Corp.
 * 
 * Contributors: IBM Corporation - initial API and implementation
 *******************************************************************************/
package com.ibm.ccl.soa.deploy.was.test;

import junit.framework.TestCase;

import com.ibm.ccl.soa.deploy.was.test.workspace.WebsphereTestWorkspace;

/**
 * IN PROGRESS
 * 
 */
public class PlantsByWebsphereTestRuntime extends TestCase {

	protected void setUp() throws Exception {
		WebsphereTestWorkspace.init();
	}

	/**
	 * 
	 */
	public void testWorkspace() {
		System.out.println("test begin");
		System.out.println("test end");

	}

}
