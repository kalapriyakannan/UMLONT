/*******************************************************************************
 * Copyright (c) 2003, 2007 IBM Corporation Licensed Material - Property of IBM. All rights reserved.
 *  
 * US Government Users Restricted Rights - Use, duplication or disclosure v1.0 restricted by GSA ADP
 * Schedule Contract with IBM Corp.
 * 
 * Contributors: IBM Corporation - initial API and implementation
 *******************************************************************************/
package com.ibm.ccl.soa.deploy.generic.test.validator;

import com.ibm.ccl.soa.deploy.core.CoreFactory;
import com.ibm.ccl.soa.deploy.core.Topology;
import com.ibm.ccl.soa.deploy.core.Unit;
import com.ibm.ccl.soa.deploy.core.test.TopologyTestCase;
import com.ibm.ccl.soa.deploy.core.validator.DeployValidatorService;
import com.ibm.ccl.soa.deploy.generic.validator.GenericDomainValidator;

/**
 * @author barnold
 * 
 */
public class GenericDomainValidatorTest extends TopologyTestCase {
	public static final String PROJECT = "GenericDomainValidatorTest";

	public GenericDomainValidatorTest() {
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
		Topology top = createTopology("testDomainRegistration");

		//assertHasNoDomainValidator(top, GenericDomainValidator.class);
		
		// This has nothing to do with the generic domain now
		Unit unit = CoreFactory.eINSTANCE.createUnit();
		unit.setName("unit");
		top.getUnits().add(unit);

		//assertHasDomainValidator(top, GenericDomainValidator.class);		
	}
}
