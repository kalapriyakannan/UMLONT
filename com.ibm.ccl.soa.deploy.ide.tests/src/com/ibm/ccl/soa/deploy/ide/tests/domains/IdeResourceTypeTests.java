/*******************************************************************************
 * Copyright (c) 2003, 2007 IBM Corporation Licensed Material - Property of IBM. All rights reserved.
 *  
 * US Government Users Restricted Rights - Use, duplication or disclosure v1.0 restricted by GSA ADP
 * Schedule Contract with IBM Corp.
 * 
 * Contributors: IBM Corporation - initial API and implementation
 *******************************************************************************/
package com.ibm.ccl.soa.deploy.ide.tests.domains;

import com.ibm.ccl.soa.deploy.internal.core.extension.DomainManager;
import com.ibm.ccl.soa.deploy.internal.core.extension.ResourceTypeBindingDescriptor;
import com.ibm.ccl.soa.deploy.tests.domains.DomainTestCase;

public class IdeResourceTypeTests extends DomainTestCase {
	
	private static final String WTP_CONTEXT = "wtp";
	private static final String PROJECT_NAME = "IdeResourceTypeTests";
	
	/**
	 * Create the test.
	 * 
	 * @param name
	 */
	public IdeResourceTypeTests() {
		super(PROJECT_NAME);
	}
	
	/**
	 * Verify that a test extension can be consumed correctly.
	 * 
	 * @throws Exception
	 *             When bad things happen.
	 */
	public void testResourceTypeBindingExtension() throws Exception {

		ResourceTypeBindingDescriptor[] rsDescs = DomainManager.getInstance()
				.getAllResourceTypeBindings(WTP_CONTEXT);
		assert rsDescs.length > 0;
		assert rsDescs[0].getContext().equals(WTP_CONTEXT);

		rsDescs = DomainManager.getInstance().getAllResourceTypeBindings(
				"DUMMY");
		assert rsDescs == null;
	}

}
