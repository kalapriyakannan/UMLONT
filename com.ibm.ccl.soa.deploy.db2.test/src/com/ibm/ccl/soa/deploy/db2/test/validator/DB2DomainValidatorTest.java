/*******************************************************************************
 * Copyright (c) 2003, 2007 IBM Corporation Licensed Material - Property of IBM. All rights reserved.
 *  
 * US Government Users Restricted Rights - Use, duplication or disclosure v1.0 restricted by GSA ADP
 * Schedule Contract with IBM Corp.
 * 
 * Contributors: IBM Corporation - initial API and implementation
 *******************************************************************************/
package com.ibm.ccl.soa.deploy.db2.test.validator;

import com.ibm.ccl.soa.deploy.core.Topology;
import com.ibm.ccl.soa.deploy.core.test.TopologyTestCase;
import com.ibm.ccl.soa.deploy.core.validator.DeployValidatorService;
import com.ibm.ccl.soa.deploy.core.validator.DomainValidator;
import com.ibm.ccl.soa.deploy.db2.DB2DatabaseUnit;
import com.ibm.ccl.soa.deploy.db2.Db2Factory;
import com.ibm.ccl.soa.deploy.db2.internal.validator.DB2DomainValidator;

/**
 * @author barnold
 * 
 */
public class DB2DomainValidatorTest extends TopologyTestCase {
	public static final String PROJECT = "Db2DomainValidatorTest";

	public DB2DomainValidatorTest() {
		super(PROJECT);
	}

	/*
	 * @see junit.framework.TestCase#tearDown() Uncomment to stop deletion of
	 *      plants topology after test run.
	 */
	protected void tearDown() throws Exception {
	}

	/**
	 * 
	 */
	public void testDomainRegistration() {
		DeployValidatorService service = new DeployValidatorService();
		Topology top = createTopology("testDomainRegistration"); //$NON-NLS-1$

		assertHasNoDomainValidator(top, DB2DomainValidator.class);

		DB2DatabaseUnit unit = Db2Factory.eINSTANCE.createDB2DatabaseUnit();
		unit.setName("unit"); //$NON-NLS-1$
		top.getUnits().add(unit);

		assertHasDomainValidator(top, DB2DomainValidator.class);
	}
}
