/*******************************************************************************
 * Copyright (c) 2003, 2007 IBM Corporation Licensed Material - Property of IBM. All rights reserved.
 *  
 * US Government Users Restricted Rights - Use, duplication or disclosure v1.0 restricted by GSA ADP
 * Schedule Contract with IBM Corp.
 * 
 * Contributors: IBM Corporation - initial API and implementation
 *******************************************************************************/
package com.ibm.ccl.soa.deploy.ldap.test.validator;

import com.ibm.ccl.soa.deploy.core.Topology;
import com.ibm.ccl.soa.deploy.core.test.TopologyTestCase;
import com.ibm.ccl.soa.deploy.core.validator.DeployValidatorService;
import com.ibm.ccl.soa.deploy.core.validator.DomainValidator;
import com.ibm.ccl.soa.deploy.ldap.LdapFactory;
import com.ibm.ccl.soa.deploy.ldap.LdapServerUnit;
import com.ibm.ccl.soa.deploy.ldap.internal.validator.LdapDomainValidator;

public class LdapDomainValidatorTest extends TopologyTestCase {
	public static final String PROJECT = "LdapDomainValidatorTest"; //$NON-NLS-1$

	public LdapDomainValidatorTest() {
		super(PROJECT);
	}

	public void testDomainRegistration() {
		DeployValidatorService service = new DeployValidatorService();
		Topology top = createTopology("testDomainRegistration"); //$NON-NLS-1$

		assertHasNoDomainValidator(top, LdapDomainValidator.class);

		LdapServerUnit unit = LdapFactory.eINSTANCE.createLdapServerUnit();
		unit.setName("unit"); //$NON-NLS-1$
		top.getUnits().add(unit);

		assertHasDomainValidator(top, LdapDomainValidator.class);
	}
}
