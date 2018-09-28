/*******************************************************************************
 * Copyright (c) 2003, 2007 IBM Corporation Licensed Material - Property of IBM. All rights reserved.
 *  
 * US Government Users Restricted Rights - Use, duplication or disclosure v1.0 restricted by GSA ADP
 * Schedule Contract with IBM Corp.
 * 
 * Contributors: IBM Corporation - initial API and implementation
 *******************************************************************************/
package com.ibm.ccl.soa.deploy.db2.test;

import junit.framework.Test;
import junit.framework.TestSuite;

import com.ibm.ccl.soa.deploy.db2.test.validator.DB2AdminServerUnitValidatorTest;
import com.ibm.ccl.soa.deploy.db2.test.validator.DB2CatalogUnitValidatorTest;
import com.ibm.ccl.soa.deploy.db2.test.validator.DB2DatabaseUnitValidatorTest;
import com.ibm.ccl.soa.deploy.db2.test.validator.DB2DomainValidatorTest;
import com.ibm.ccl.soa.deploy.db2.test.validator.DB2InstanceUnitValidatorTest;
import com.ibm.ccl.soa.deploy.db2.test.validator.DB2NodeCatalogUnitValidatorTest;
import com.ibm.ccl.soa.deploy.db2.test.validator.DB2RuntimeClientUnitValidatorTest;
import com.ibm.ccl.soa.deploy.db2.test.validator.DB2SystemUnitValidatorTest;

public class DB2ModelSuite extends TestSuite {

	public DB2ModelSuite() {
		super();
	}

	/**
	 * @param name
	 */
	public DB2ModelSuite(String name) {
		super(name);
	}

	/**
	 * @return
	 */
	public static Test suite() {
		TestSuite suite = new DB2ModelSuite("SOA Deploy DB2 Model test suite."); //$NON-NLS-1$

		suite.addTestSuite(DB2ConstantsTest.class);

		suite.addTestSuite(DB2DatabaseUnitValidatorTest.class);
		suite.addTestSuite(DB2InstanceUnitValidatorTest.class);
		suite.addTestSuite(DB2SystemUnitValidatorTest.class);
		suite.addTestSuite(DB2CatalogUnitValidatorTest.class);
		suite.addTestSuite(DB2NodeCatalogUnitValidatorTest.class);
		suite.addTestSuite(DB2RuntimeClientUnitValidatorTest.class);
		suite.addTestSuite(DB2DomainValidatorTest.class);
		suite.addTestSuite(DB2AdminServerUnitValidatorTest.class);

		return suite;
	}

}
