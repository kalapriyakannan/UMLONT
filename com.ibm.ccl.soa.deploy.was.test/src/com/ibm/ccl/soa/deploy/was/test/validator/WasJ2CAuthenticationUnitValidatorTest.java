/*******************************************************************************
 * Copyright (c) 2003, 2007 IBM Corporation Licensed Material - Property of IBM. All rights reserved.
 *  
 * US Government Users Restricted Rights - Use, duplication or disclosure v1.0 restricted by GSA ADP
 * Schedule Contract with IBM Corp.
 * 
 * Contributors: IBM Corporation - initial API and implementation
 *******************************************************************************/
package com.ibm.ccl.soa.deploy.was.test.validator;

import java.io.IOException;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.emf.ecore.resource.Resource;

import com.ibm.ccl.soa.deploy.core.CapabilityLinkTypes;
import com.ibm.ccl.soa.deploy.core.CoreFactory;
import com.ibm.ccl.soa.deploy.core.DependencyLink;
import com.ibm.ccl.soa.deploy.core.Requirement;
import com.ibm.ccl.soa.deploy.core.Topology;
import com.ibm.ccl.soa.deploy.core.test.TopologyTestCase;
import com.ibm.ccl.soa.deploy.core.test.validator.utils.ValidatorTestUtils;
import com.ibm.ccl.soa.deploy.core.validator.IDeployReporter;
import com.ibm.ccl.soa.deploy.core.validator.IDeployValidationContext;
import com.ibm.ccl.soa.deploy.db2.DB2CatalogUnit;
import com.ibm.ccl.soa.deploy.os.OsFactory;
import com.ibm.ccl.soa.deploy.os.OsPackage;
import com.ibm.ccl.soa.deploy.os.User;
import com.ibm.ccl.soa.deploy.os.UserUnit;
import com.ibm.ccl.soa.deploy.was.WASJ2CAuthenticationDataEntry;
import com.ibm.ccl.soa.deploy.was.WASJ2CAuthenticationUnit;
import com.ibm.ccl.soa.deploy.was.WasCell;
import com.ibm.ccl.soa.deploy.was.WasCellUnit;
import com.ibm.ccl.soa.deploy.was.WasFactory;
import com.ibm.ccl.soa.deploy.was.WasPackage;
import com.ibm.ccl.soa.deploy.was.internal.validator.WasJ2CAuthenticationUnitValidator;

/**
 * Tests {@link DB2CatalogUnit}.
 * 
 * @author barnold
 */
public class WasJ2CAuthenticationUnitValidatorTest extends TopologyTestCase {

	private static final String PROJECT_NAME = "WasJ2CAuthUnitValidatorTest"; //$NON-NLS-1$

	/**
	 * 
	 */
	public WasJ2CAuthenticationUnitValidatorTest() {
		super(PROJECT_NAME);
	}

	/*
	 * @see junit.framework.TestCase#tearDown() Uncomment to stop deletion of
	 *      plants topology after test run.
	 */
	protected void tearDown() throws Exception {
	}

	/**
	 * @throws IOException
	 * @throws CoreException
	 */
	public void testWasJ2CAuthenticationUnitValidator() throws IOException,
			CoreException {

		Topology top = createTopology("WasJ2CAuthenticationUnitValidator", true); //$NON-NLS-1$

		IDeployValidationContext context = createValidationContext(top);
		IDeployReporter reporter = createDeployReporter();
		WasJ2CAuthenticationUnitValidator validator = new WasJ2CAuthenticationUnitValidator();

		//
		// J2C Authentication unit
		//
		WASJ2CAuthenticationUnit wasJ2cAuthenticationUnit = WasFactory.eINSTANCE
				.createWASJ2CAuthenticationUnit();
		wasJ2cAuthenticationUnit.setName("wasJ2cAuthenticationUnit"); //$NON-NLS-1$
		top.getUnits().add(wasJ2cAuthenticationUnit);

		// provide a j2cauth service
		WASJ2CAuthenticationDataEntry j2cAuthUnitDataEntry = WasFactory.eINSTANCE
				.createWASJ2CAuthenticationDataEntry();
		j2cAuthUnitDataEntry.setName("PlantsJ2CProvidedAuthService"); //$NON-NLS-1$
		j2cAuthUnitDataEntry
				.setDisplayName("WebSphere plants J2C provided authentication service"); //$NON-NLS-1$
		j2cAuthUnitDataEntry.setAlias("PbwAuth"); //$NON-NLS-1$
		j2cAuthUnitDataEntry.setUserId("db2admin"); //$NON-NLS-1$
		j2cAuthUnitDataEntry.setPassword("db2admin"); //$NON-NLS-1$
		wasJ2cAuthenticationUnit.getOnlyDependencyCapabilities().add(
				j2cAuthUnitDataEntry);

		// Require a j2ee server service
		Requirement j2cAuthRequiredWasCell = ValidatorTestUtils
				.createHostingRequirement(WasPackage.Literals.WAS_CELL,
						"j2cAuthRequiredWasCell",
						"Required WAS Cell capability J2c auth unit");

		wasJ2cAuthenticationUnit.getRequirements().add(j2cAuthRequiredWasCell);

		// Require a user
		Requirement requiredRemoteUser = ValidatorTestUtils
				.createDependencyRequirement(OsPackage.Literals.USER, "user",
						"Required user for J2c auth unit");
		wasJ2cAuthenticationUnit.getRequirements().add(requiredRemoteUser);

		WasCell wasCell = WasFactory.eINSTANCE.createWasCell();
		wasCell.setName("wasCell");
		wasCell.setDisplayName("wasCell");
		wasCell.setLinkType(CapabilityLinkTypes.ANY_LITERAL);
		wasCell.setWasVersion("6.0");

		WasCellUnit wasCellUnit = WasFactory.eINSTANCE.createWasCellUnit();
		wasCellUnit.setName("wasCellUnit");
		top.getUnits().add(wasCellUnit);
		ValidatorTestUtils.hosts(wasCellUnit, wasJ2cAuthenticationUnit);

		UserUnit userUnit = OsFactory.eINSTANCE.createUserUnit();
		top.getUnits().add(userUnit);
		// Require a user
		User providedUser = OsFactory.eINSTANCE.createUser();
		providedUser.setName("user"); //$NON-NLS-1$
		providedUser
				.setDisplayName("provided user to link to from J2c auth unit"); //$NON-NLS-1$
		providedUser.setUserId("db2admin");
		providedUser.setUserPassword("db2admin");
		userUnit.getOnlyDependencyCapabilities().add(providedUser);

		// dependency link between j2c authentication unit user requirement and
		// user on remote system
		DependencyLink remoteUserLink = CoreFactory.eINSTANCE
				.createDependencyLink();
		remoteUserLink.setTarget(providedUser);
		requiredRemoteUser.setLink(remoteUserLink);
		ValidatorTestUtils.createLinkName(remoteUserLink);

		// /////////////////
		Resource res = top.getEObject().eResource();
		res.save(null);
		// /////////////////

		validator.validate(wasJ2cAuthenticationUnit, context, reporter);
		System.out.println("In " + this.getClass()); //$NON-NLS-1$
		dumpMarkers(top);

		ValidatorTestUtils.assertValidationErrorCount(0, top,
				wasJ2cAuthenticationUnit, context, reporter, validator);

		String goodAlias = j2cAuthUnitDataEntry.getAlias();
		j2cAuthUnitDataEntry.setAlias(null);
		// alias is undefined, and alias can be propagated from a good value
		ValidatorTestUtils.assertValidationErrorCount(2, top,
				wasJ2cAuthenticationUnit, context, reporter, validator);
		j2cAuthUnitDataEntry.setAlias(goodAlias);
		ValidatorTestUtils.assertValidationErrorCount(0, top,
				wasJ2cAuthenticationUnit, context, reporter, validator);

		String goodUserId = j2cAuthUnitDataEntry.getUserId();
		j2cAuthUnitDataEntry.setUserId(providedUser.getUserId() + "x");
		ValidatorTestUtils.assertValidationErrorCount(1, top,
				wasJ2cAuthenticationUnit, context, reporter, validator);
		j2cAuthUnitDataEntry.setUserId(goodUserId);
		ValidatorTestUtils.assertValidationErrorCount(0, top,
				wasJ2cAuthenticationUnit, context, reporter, validator);

		String goodPassword = j2cAuthUnitDataEntry.getPassword();
		j2cAuthUnitDataEntry.setPassword(providedUser.getUserPassword() + "x");
		ValidatorTestUtils.assertValidationErrorCount(1, top,
				wasJ2cAuthenticationUnit, context, reporter, validator);
		j2cAuthUnitDataEntry.setPassword(goodPassword);
		ValidatorTestUtils.assertValidationErrorCount(0, top,
				wasJ2cAuthenticationUnit, context, reporter, validator);
		// assert instanceUnit.getStatus().getSeverity() != IStatus.OK;
	}
}
