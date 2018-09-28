/*******************************************************************************
 * Copyright (c) 2003, 2007 IBM Corporation Licensed Material - Property of IBM. All rights reserved.
 *  
 * US Government Users Restricted Rights - Use, duplication or disclosure v1.0 restricted by GSA ADP
 * Schedule Contract with IBM Corp.
 * 
 * Contributors: IBM Corporation - initial API and implementation
 *******************************************************************************/
package com.ibm.ccl.soa.deploy.ldap.test.validator;

import java.io.IOException;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IStatus;

import com.ibm.ccl.soa.deploy.core.CoreFactory;
import com.ibm.ccl.soa.deploy.core.Requirement;
import com.ibm.ccl.soa.deploy.core.RequirementLinkTypes;
import com.ibm.ccl.soa.deploy.core.Topology;
import com.ibm.ccl.soa.deploy.core.test.TopologyTestCase;
import com.ibm.ccl.soa.deploy.core.test.validator.utils.ValidatorTestUtils;
import com.ibm.ccl.soa.deploy.core.validator.IDeployReporter;
import com.ibm.ccl.soa.deploy.core.validator.IDeployValidationContext;
import com.ibm.ccl.soa.deploy.db2.DB2DDLArtifact;
import com.ibm.ccl.soa.deploy.db2.DB2Database;
import com.ibm.ccl.soa.deploy.db2.Db2Factory;
import com.ibm.ccl.soa.deploy.ldap.LdapServer;
import com.ibm.ccl.soa.deploy.ldap.LdapFactory;
import com.ibm.ccl.soa.deploy.ldap.LdapPackage;
import com.ibm.ccl.soa.deploy.ldap.LdapSuffix;
import com.ibm.ccl.soa.deploy.ldap.LdapSuffixUnit;
import com.ibm.ccl.soa.deploy.ldap.LdapServerUnit;
import com.ibm.ccl.soa.deploy.ldap.internal.validator.LdapSuffixUnitValidator;
import com.ibm.ccl.soa.deploy.ldap.internal.validator.LdapServerUnitValidator;
import com.ibm.ccl.soa.deploy.os.OperatingSystem;

/**
 * Tests {@link LdapServerUnitValidator}.
 */
public class LdapSuffixUnitValidatorTest extends TopologyTestCase {

	private static final String PROJECT_NAME = "LdapSuffixUnitValidatorTest"; //$NON-NLS-1$

	protected DB2Database consumedLdapDb2Database;

	protected DB2Database providedDb2DatabaseLdap;

	protected OperatingSystem consumedLdapOs;

	private LdapServerUnit ldapServerUnit;

	public LdapSuffixUnitValidatorTest() {
		super(PROJECT_NAME);
	}

	public void testLdapUnitValidator() throws IOException, CoreException {
		Topology top = createTopology("LdapSuffixUnitValidator", true); //$NON-NLS-1$

		IDeployValidationContext context = createValidationContext(top);
		IDeployReporter reporter = createDeployReporter();
		LdapSuffixUnitValidator validator = new LdapSuffixUnitValidator();

		//
		// build test topology
		//

		// Provided LDAP service
		LdapServer providedLdap = LdapFactory.eINSTANCE.createLdapServer();
		providedLdap.setName("providedLdap"); //$NON-NLS-1$
		providedLdap.setAdministratorDN("cn=root"); //$NON-NLS-1$
		providedLdap.setAdministratorPassword("ldap1"); //$NON-NLS-1$
//		providedLdap.setHostname("rf12.watson.ibm.com"); //$NON-NLS-1$
//		providedLdap.setPort("389"); //$NON-NLS-1$
		// TODO Should this be changed to match other ports?
		// providedLdap.setPort(BigInteger.valueOf(389));

		// LDAP unit
		// - produces LDAP service (providedLdap)
		// - consumes DB2 database service (consumedLdapDb2Database)
		// - consumes OS service (consumedLdapOs)
		/* LdapServerUnit */ldapServerUnit = LdapFactory.eINSTANCE.createLdapServerUnit();
		ldapServerUnit.setName("ldapServerUnit"); //$NON-NLS-1$
		top.getUnits().add(ldapServerUnit);
		ldapServerUnit.getHostingOrAnyCapabilities().add(providedLdap);

		// Provided ldapSuffix
		LdapSuffix providedSuffix1 = LdapFactory.eINSTANCE.createLdapSuffix();
		providedSuffix1.setName("providedSuffix1"); //$NON-NLS-1$
		providedSuffix1.setSuffixDN("cn=root"); //$NON-NLS-1$

		// Required ldap
		Requirement requiredLdap1 = CoreFactory.eINSTANCE.createRequirement();
		requiredLdap1.setDmoEType(LdapPackage.eINSTANCE.getLdapServer());
		requiredLdap1.setLinkType(RequirementLinkTypes.HOSTING_LITERAL);
		requiredLdap1.setName("requiredLdap1"); //$NON-NLS-1$

		DB2DDLArtifact db2ddla = Db2Factory.eINSTANCE.createDB2DDLArtifact();
		db2ddla.setName("db2ddla"); //$NON-NLS-1$
		db2ddla.getFileURIs().add("plantsby.ddl"); //$NON-NLS-1$

		// LdapSuffix
		// - provides ldap suffix service (providedSuffix1)
		// - requires ldap service (requiredeLdap1)
		LdapSuffixUnit suffixUnit1 = LdapFactory.eINSTANCE
				.createLdapSuffixUnit();
		suffixUnit1.setName("suffixUnit1"); //$NON-NLS-1$
		top.getUnits().add(suffixUnit1);
		suffixUnit1.getCapabilities().add(providedSuffix1);
		suffixUnit1.getRequirements().add(requiredLdap1);
		suffixUnit1.getArtifacts().add(db2ddla);

		// connect suffix unit to ldap unit
		ValidatorTestUtils.hosts(ldapServerUnit, suffixUnit1);

		// no markers
		IStatus status = validateUnit(top, validator, suffixUnit1, context,
				reporter);
		validator.validate(suffixUnit1, context, reporter);
		dumpMarkers(top);
		ValidatorTestUtils.assertValidationErrorCount(0, top, suffixUnit1,
				context, reporter, validator);
		assert status.getSeverity() == IStatus.OK;

		suffixUnit1.getArtifacts().clear();
		ValidatorTestUtils.assertValidationErrorCount(0, top, suffixUnit1,
				context, reporter, validator);
		suffixUnit1.getArtifacts().add(db2ddla);
		ValidatorTestUtils.assertValidationErrorCount(0, top, suffixUnit1,
				context, reporter, validator);

		String goodSuffixDN = providedSuffix1.getSuffixDN();
		providedSuffix1.setSuffixDN(null);
		ValidatorTestUtils.assertValidationErrorCount(1, top, suffixUnit1,
				context, reporter, validator);
		providedSuffix1.setSuffixDN(""); //$NON-NLS-1$
		ValidatorTestUtils.assertValidationErrorCount(1, top, suffixUnit1,
				context, reporter, validator);
		providedSuffix1.setSuffixDN("foo"); //$NON-NLS-1$
		ValidatorTestUtils.assertValidationErrorCount(1, top, suffixUnit1,
				context, reporter, validator);
		providedSuffix1.setSuffixDN(goodSuffixDN);
		ValidatorTestUtils.assertValidationErrorCount(0, top, suffixUnit1,
				context, reporter, validator);
	}
}
