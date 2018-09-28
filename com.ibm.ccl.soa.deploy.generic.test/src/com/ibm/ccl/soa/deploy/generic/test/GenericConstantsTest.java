/*******************************************************************************
 * Copyright (c) 2003, 2007 IBM Corporation Licensed Material - Property of IBM. All rights reserved.
 *  
 * US Government Users Restricted Rights - Use, duplication or disclosure v1.0 restricted by GSA ADP
 * Schedule Contract with IBM Corp.
 * 
 * Contributors: IBM Corporation - initial API and implementation
 *******************************************************************************/
package com.ibm.ccl.soa.deploy.generic.test;

import junit.framework.TestCase;

import com.ibm.ccl.soa.deploy.core.test.NLSTestUtils;
import com.ibm.ccl.soa.deploy.generic.GenericDomainMessages;
import com.ibm.ccl.soa.deploy.generic.GenericPackage;

/**
 * Tests the constants associated with the {@link GenericPackage} deploy domain.
 */
public class GenericConstantsTest extends TestCase {

	/**
	 * Tests the consistency between {@link GenericDomainMessages} and the
	 * messages.properties file.
	 */
	public void testMessages() {
		NLSTestUtils.checkNLS(GenericDomainMessages.class,
				"com.ibm.ccl.soa.deploy.generic.internal.messages"); //$NON-NLS-1$
	}
}
