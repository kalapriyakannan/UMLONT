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
import com.ibm.ccl.soa.deploy.os.WindowsLocalService;
import com.ibm.ccl.soa.deploy.os.WindowsServiceStartupType;
import com.ibm.ccl.soa.deploy.was.WasFactory;
import com.ibm.ccl.soa.deploy.was.WasNode;
import com.ibm.ccl.soa.deploy.was.WasNodeUnit;
import com.ibm.ccl.soa.deploy.was.WasNodeWindowsServiceUnit;
import com.ibm.ccl.soa.deploy.was.WasPackage;
import com.ibm.ccl.soa.deploy.was.WasSystem;
import com.ibm.ccl.soa.deploy.was.WasSystemUnit;
import com.ibm.ccl.soa.deploy.was.internal.validator.WasGenericClusterUnitValidator;
import com.ibm.ccl.soa.deploy.was.internal.validator.WasNodeWindowsServiceUnitValidator;

/**
 * Tests {@link WasNodeWindowsServiceUnitValidator}
 * 
 * @since 3.2
 * 
 */
public class WasNodeWindowsServiceUnitValidatorTest extends TopologyTestCase {
	private static final String PROJECT_NAME = "WasNodeWindowsServiceUnitValidatorTest"; //$NON-NLS-1$

	/**
	 * 
	 * 
	 */
	public WasNodeWindowsServiceUnitValidatorTest() {
		super(PROJECT_NAME);
	}

	/*
	 * @see junit.framework.TestCase#tearDown() Uncomment to stop deletion of
	 *      plants topology after test run.
	 */
	protected void tearDown() throws Exception {
	}

	/**
	 * 
	 * @throws IOException
	 * @throws CoreException
	 */
	public void testWasNodeWindowsServiceUnitValidator() throws IOException,
			CoreException {
		Topology top = createTopology(
				"WasNodeWindowsServiceUnitValidatorTest", true); //$NON-NLS-1$
		IDeployValidationContext context = createValidationContext(top);
		IDeployReporter reporter = createDeployReporter();
		WasGenericClusterUnitValidator validator = new WasGenericClusterUnitValidator();

		//
		// add wasNodeWindowsServiceUnit
		//
		WasNodeWindowsServiceUnit wasNodeWindowsServiceUnit = WasFactory.eINSTANCE
				.createWasNodeWindowsServiceUnit();
		wasNodeWindowsServiceUnit.setName("wasNodeWindowsServiceUnit"); //$NON-NLS-1$
		wasNodeWindowsServiceUnit.setDisplayName("wasNodeWindowsServiceUnit"); //$NON-NLS-1$		
		top.getUnits().add(wasNodeWindowsServiceUnit);

		// provide a wasNodeWindowsService service
		WindowsLocalService windowsService = OsFactory.eINSTANCE
				.createWindowsLocalService();
		windowsService.setName("runASwindowsService"); //$NON-NLS-1$
		windowsService.setDisplayName("runASwindowsService"); //$NON-NLS-1$
		windowsService.setStartupType(WindowsServiceStartupType.MANUAL_LITERAL);
		windowsService.setLinkType(CapabilityLinkTypes.ANY_LITERAL);
		wasNodeWindowsServiceUnit.getCapabilities().add(windowsService);

		//
		// hostingLink between cell and Node
		//
		Requirement requiredWasNode = CoreFactory.eINSTANCE.createRequirement();
		requiredWasNode.setName("requiredWasNode"); //$NON-NLS-1$
		requiredWasNode.setLinkType(RequirementLinkTypes.HOSTING_LITERAL);
		requiredWasNode.setDmoEType(WasPackage.eINSTANCE.getWasNode());
		wasNodeWindowsServiceUnit.getRequirements().add(requiredWasNode);
		// create wasNodeUnit
		WasNodeUnit wasNodeUnit = WasFactory.eINSTANCE.createWasNodeUnit();
		wasNodeUnit.setName("wasNodeUnit"); //$NON-NLS-1$
		wasNodeUnit.setDisplayName("wasNodeUnit"); //$NON-NLS-1$		
		top.getUnits().add(wasNodeUnit);
		// add wasNodeService
		WasNode provideWasNode = WasFactory.eINSTANCE.createWasNode();
		provideWasNode.setName("wasNode"); //$NON-NLS-1$
		provideWasNode.setDisplayName("wasNode"); //$NON-NLS-1$
		provideWasNode.setNodeName("Node1");//$NON-NLS-1$
		provideWasNode.setWasVersion("6.0.0.1");//$NON-NLS-1$
		provideWasNode.setLinkType(CapabilityLinkTypes.ANY_LITERAL);

		wasNodeWindowsServiceUnit.getHostingOrAnyCapabilities().add(
				provideWasNode);
		ValidatorTestUtils.hosts(wasNodeUnit, wasNodeWindowsServiceUnit);

		//
		// WasNodeUnit Require wasSystem to hosting on
		//
		Requirement requiredWasSystem = CoreFactory.eINSTANCE
				.createRequirement();
		requiredWasSystem.setName("requiredWasSystem"); //$NON-NLS-1$
		requiredWasSystem.setLinkType(RequirementLinkTypes.HOSTING_LITERAL);
		requiredWasSystem.setDmoEType(WasPackage.eINSTANCE.getWasSystem());
		wasNodeUnit.getRequirements().add(requiredWasSystem);

		WasSystemUnit wasSystemUnit = WasFactory.eINSTANCE
				.createWasSystemUnit();
		wasSystemUnit.setName("wasSystemUnit"); //$NON-NLS-1$
		top.getUnits().add(wasSystemUnit);

		WasSystem providedWasSystem = WasFactory.eINSTANCE.createWasSystem();
		providedWasSystem.setName("providedWasSystem"); //$NON-NLS-1$
		providedWasSystem.setDisplayName("ProvidedWasSystem");//$NON-NLS-1$

		wasSystemUnit.getHostingOrAnyCapabilities().add(providedWasSystem);
		ValidatorTestUtils.hosts(wasSystemUnit, wasNodeUnit);

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

		// /////////////////
		Resource res = top.getEObject().eResource();
		res.save(null);
		// /////////////////

		validator.validate(wasNodeWindowsServiceUnit, context, reporter);
		System.out.println("In " + this.getClass()); //$NON-NLS-1$
		dumpMarkers(top);

		ValidatorTestUtils.assertValidationErrorCount(0, top,
				wasNodeWindowsServiceUnit, context, reporter, validator);

		windowsService.setStartupType(WindowsServiceStartupType.BOOT_LITERAL);
		ValidatorTestUtils.assertValidationErrorCount(1, top,
				wasNodeWindowsServiceUnit, context, reporter, validator);
		windowsService
				.setStartupType(WindowsServiceStartupType.AUTOMATIC_LITERAL);
		ValidatorTestUtils.assertValidationErrorCount(0, top,
				wasNodeWindowsServiceUnit, context, reporter, validator);
		windowsService.setStartupType(WindowsServiceStartupType.SYSTEM_LITERAL);
		ValidatorTestUtils.assertValidationErrorCount(1, top,
				wasNodeWindowsServiceUnit, context, reporter, validator);
		windowsService
				.setStartupType(WindowsServiceStartupType.DISABLED_LITERAL);
		ValidatorTestUtils.assertValidationErrorCount(0, top,
				wasNodeWindowsServiceUnit, context, reporter, validator);

		// OperatingSystem provideOtherOS =
		// OsFactory.eINSTANCE.createOperatingSystem(); //there are no other OS
		// provided now, add codes for that after there are
	}

}
