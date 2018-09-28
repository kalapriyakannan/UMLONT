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
import com.ibm.ccl.soa.deploy.core.Requirement;
import com.ibm.ccl.soa.deploy.core.RequirementLinkTypes;
import com.ibm.ccl.soa.deploy.core.Topology;
import com.ibm.ccl.soa.deploy.core.test.TopologyTestCase;
import com.ibm.ccl.soa.deploy.core.test.validator.utils.ValidatorTestUtils;
import com.ibm.ccl.soa.deploy.core.validator.IDeployReporter;
import com.ibm.ccl.soa.deploy.core.validator.IDeployValidationContext;
import com.ibm.ccl.soa.deploy.os.OperatingSystem;
import com.ibm.ccl.soa.deploy.os.OperatingSystemType;
import com.ibm.ccl.soa.deploy.os.OperatingSystemUnit;
import com.ibm.ccl.soa.deploy.os.OsFactory;
import com.ibm.ccl.soa.deploy.os.OsPackage;
import com.ibm.ccl.soa.deploy.was.WasEditionEnum;
import com.ibm.ccl.soa.deploy.was.WasFactory;
import com.ibm.ccl.soa.deploy.was.WasSystem;
import com.ibm.ccl.soa.deploy.was.WasSystemUnit;
import com.ibm.ccl.soa.deploy.was.internal.validator.WasSystemUnitValidator;

/**
 * Tests {@link WasSystemUnitValidator}
 * 
 * @since 3.2
 * 
 */
public class WasSystemUnitValidatorTest extends TopologyTestCase {
	private static final String PROJECT_NAME = "WasSystemUnitValidatorTest"; //$NON-NLS-1$

	/**
	 * 
	 */
	public WasSystemUnitValidatorTest() {
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
	public void testWasSystemUnitValidator() throws IOException, CoreException {
		Topology top = createTopology(PROJECT_NAME, true);

		IDeployValidationContext context = createValidationContext(top);
		IDeployReporter reporter = createDeployReporter();
		WasSystemUnitValidator validator = new WasSystemUnitValidator();

		//
		// create wasSystemUnit
		//
		WasSystemUnit wasSystemUnit = WasFactory.eINSTANCE
				.createWasSystemUnit();
		wasSystemUnit.setName("wasSystemUnit"); //$NON-NLS-1$
		wasSystemUnit.setDisplayName("wasSystemUnit"); //$NON-NLS-1$		
		top.getUnits().add(wasSystemUnit);

		//
		// create wasSystem service
		//
		WasSystem wasSystem = WasFactory.eINSTANCE.createWasSystem();
		wasSystem.setName("wasSystem"); //$NON-NLS-1$
		wasSystem.setDisplayName("wasSystem"); //$NON-NLS-1$
		wasSystem.setInstallerDir("C:\\Tools\\WAS\\");//$NON-NLS-1$
		wasSystem.setWasEdition(WasEditionEnum.NETWORK_DEPLOYMENT_LITERAL);
		wasSystem.setWasHome("C:\\Program Files\\IBM\\WebSphere\\"); //$NON-NLS-1$
		wasSystem.setWasVersion("6.0.0.1");//$NON-NLS-1$
		wasSystem.setLinkType(CapabilityLinkTypes.ANY_LITERAL);
		wasSystemUnit.getCapabilities().add(wasSystem);

		//
		// another wasSystemUnit
		//
		WasSystemUnit wasSystemUnit_2 = WasFactory.eINSTANCE
				.createWasSystemUnit();
		wasSystemUnit.setName("wasSystemUnit_2"); //$NON-NLS-1$
		wasSystemUnit.setDisplayName("wasSystemUnit_2"); //$NON-NLS-1$		
		top.getUnits().add(wasSystemUnit_2);
		WasSystem wasSystem_2 = WasFactory.eINSTANCE.createWasSystem();
		wasSystem.setName("wasSystem_2"); //$NON-NLS-1$
		wasSystem_2.setDisplayName("wasSystem_2"); //$NON-NLS-1$
		wasSystem_2.setInstallerDir("C:\\Tools\\WAS\\");//$NON-NLS-1$
		wasSystem_2.setWasEdition(WasEditionEnum.NETWORK_DEPLOYMENT_LITERAL);
		wasSystem_2.setWasHome("C:\\Program Files\\IBM\\WebSphere_2\\"); //$NON-NLS-1$
		wasSystem_2.setWasVersion("6.0.0.1");//$NON-NLS-1$
		wasSystem_2.setLinkType(CapabilityLinkTypes.ANY_LITERAL);
		wasSystemUnit_2.getCapabilities().add(wasSystem_2);

		//
		// requirment for OS
		//
		OperatingSystemUnit operatingSystemUnit = OsFactory.eINSTANCE
				.createOperatingSystemUnit();
		operatingSystemUnit.setName("operatingSystemUnit"); //$NON-NLS-1$
		top.getUnits().add(operatingSystemUnit);

		Requirement requiredOperatingSystem = CoreFactory.eINSTANCE
				.createRequirement();
		requiredOperatingSystem.setName("requiredOperatingSystem"); //$NON-NLS-1$
		requiredOperatingSystem
				.setLinkType(RequirementLinkTypes.HOSTING_LITERAL);
		requiredOperatingSystem.setDmoEType(OsPackage.eINSTANCE
				.getOperatingSystem());
		wasSystemUnit.getRequirements().add(requiredOperatingSystem);

		OperatingSystem providedWindowsOperatingSystem = OsFactory.eINSTANCE
				.createWindowsOperatingSystem();
		providedWindowsOperatingSystem
				.setName("providedWindowsOperatingSystem"); //$NON-NLS-1$
		providedWindowsOperatingSystem
				.setOsType(OperatingSystemType.WINDOWS_LITERAL.getLiteral()); //$NON-NLS-1$
		providedWindowsOperatingSystem.setOsVersion("Win2K"); //$NON-NLS-1$
		operatingSystemUnit.getHostingOrAnyCapabilities().add(
				providedWindowsOperatingSystem);

		ValidatorTestUtils.hosts(operatingSystemUnit, wasSystemUnit);
		ValidatorTestUtils.hosts(operatingSystemUnit, wasSystemUnit_2);

		// /////////////////
		Resource res = top.getEObject().eResource();
		res.save(null);
		// /////////////////

		validator.validate(wasSystemUnit, context, reporter);
		System.out.println("In " + this.getClass()); //$NON-NLS-1$
		dumpMarkers(top);
		ValidatorTestUtils.assertValidationErrorCount(0, top, wasSystemUnit,
				context, reporter, validator);

		// Syntactically invalid version string
		String savedWasVersion = wasSystem.getWasVersion();
		wasSystem.setWasVersion("yyfdjkl"); //$NON-NLS-1$
		// One for invalid syntax, one for wasVersion not equals
		ValidatorTestUtils.assertValidationErrorCount(1, top, wasSystemUnit,
				context, reporter, validator);
		wasSystem.setWasVersion(""); //$NON-NLS-1$
		ValidatorTestUtils.assertValidationErrorCount(2, top, wasSystemUnit,
				context, reporter, validator);
		wasSystem.setWasVersion(savedWasVersion);
		ValidatorTestUtils.assertValidationErrorCount(0, top, wasSystemUnit,
				context, reporter, validator);

		String savedInstallDir = wasSystem.getInstallerDir();
		wasSystem.setInstallerDir("/opt"); //$NON-NLS-1$
		ValidatorTestUtils.assertValidationErrorCount(1, top, wasSystemUnit,
				context, reporter, validator);
		wasSystem.setInstallerDir(savedInstallDir);
		ValidatorTestUtils.assertValidationErrorCount(0, top, wasSystemUnit,
				context, reporter, validator);

		String savedWasHome = wasSystem.getWasHome();
		wasSystem.setWasHome("/opt"); //$NON-NLS-1$
		ValidatorTestUtils.assertValidationErrorCount(1, top, wasSystemUnit,
				context, reporter, validator);
		wasSystem.setWasHome(savedWasHome);
		ValidatorTestUtils.assertValidationErrorCount(0, top, wasSystemUnit,
				context, reporter, validator);

		// Uniqueness of installdir for system
		wasSystem.setWasHome(wasSystem_2.getWasHome());
		ValidatorTestUtils.assertValidationErrorCount(1, top, wasSystemUnit,
				context, reporter, validator);
		wasSystem.setWasHome(savedWasHome);
		ValidatorTestUtils.assertValidationErrorCount(0, top, wasSystemUnit,
				context, reporter, validator);
	}

}
