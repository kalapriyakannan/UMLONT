package com.ibm.ccl.soa.deploy.os.test.validator;

/*******************************************************************************
 * Copyright (c) 2003, 2007 IBM Corporation Licensed Material - Property of IBM. All rights reserved.
 *  
 * US Government Users Restricted Rights - Use, duplication or disclosure v1.0 restricted by GSA ADP
 * Schedule Contract with IBM Corp.
 * 
 * Contributors: IBM Corporation - initial API and implementation
 *******************************************************************************/

import com.ibm.ccl.soa.deploy.core.Topology;
import com.ibm.ccl.soa.deploy.core.test.TopologyTestCase;
import com.ibm.ccl.soa.deploy.core.validator.DeployValidatorService;
import com.ibm.ccl.soa.deploy.core.validator.DomainValidator;
import com.ibm.ccl.soa.deploy.internal.core.validator.RegisteredConstraintLinkValidator;
import com.ibm.ccl.soa.deploy.os.OperatingSystemUnit;
import com.ibm.ccl.soa.deploy.os.OsFactory;
import com.ibm.ccl.soa.deploy.os.internal.validator.OsDomainValidator;

public class OsDomainValidatorTest extends TopologyTestCase {
	public static final String PROJECT = "OsDomainValidatorTest"; //$NON-NLS-1$

	public OsDomainValidatorTest() {
		super(PROJECT);
	}

	/*
	 * @see junit.framework.TestCase#tearDown() Uncomment to stop deletion of
	 *      plants topology after test run.
	 */
	protected void tearDown() throws Exception {
	}

	public void testDomainRegistration() {
		DeployValidatorService service = new DeployValidatorService();
		Topology top = createTopology("testDomainRegistration"); //$NON-NLS-1$

		assertHasNoDomainValidator(top, OsDomainValidator.class);

		OperatingSystemUnit unit = OsFactory.eINSTANCE
				.createOperatingSystemUnit();
		unit.setName("unit"); //$NON-NLS-1$
		top.getUnits().add(unit);

		assertHasDomainValidator(top, OsDomainValidator.class);
	}
}
