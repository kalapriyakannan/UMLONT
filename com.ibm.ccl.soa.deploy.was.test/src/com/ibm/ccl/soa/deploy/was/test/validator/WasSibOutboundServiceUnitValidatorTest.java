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
import com.ibm.ccl.soa.deploy.was.WasFactory;
import com.ibm.ccl.soa.deploy.was.WasPackage;
import com.ibm.ccl.soa.deploy.was.WasSIBus;
import com.ibm.ccl.soa.deploy.was.WasSIBusUnit;
import com.ibm.ccl.soa.deploy.was.WasSibDestination;
import com.ibm.ccl.soa.deploy.was.WasSibDestinationTypeEnum;
import com.ibm.ccl.soa.deploy.was.WasSibDestinationUnit;
import com.ibm.ccl.soa.deploy.was.WasSibOutboundService;
import com.ibm.ccl.soa.deploy.was.WasSibOutboundServiceUnit;
import com.ibm.ccl.soa.deploy.was.internal.validator.WasSibOutboundServiceUnitValidator;

/**
 * @author lidb@cn.ibm.com
 * 
 */
public class WasSibOutboundServiceUnitValidatorTest extends TopologyTestCase {
	private static final String PROJECT_NAME = "WasSibOutboundServiceUnitValidatorTest"; //$NON-NLS-1$

	/**
	 * 
	 */
	public WasSibOutboundServiceUnitValidatorTest() {
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
	public void testWasSibOutboundServiceUnitValidtor() throws IOException,
			CoreException {
		Topology top = createTopology(PROJECT_NAME, true);
		IDeployValidationContext context = createValidationContext(top);
		IDeployReporter reporter = createDeployReporter();
		WasSibOutboundServiceUnitValidator validator = new WasSibOutboundServiceUnitValidator();

		//
		// create wasSibOutboudservice unit
		//
		WasSibOutboundServiceUnit wasSisbOutboundServiceUnit = WasFactory.eINSTANCE
				.createWasSibOutboundServiceUnit();
		wasSisbOutboundServiceUnit.setName("wasSisbOutboundServiceUnit");//$NON-NLS-1$
		wasSisbOutboundServiceUnit.setDisplayName("wasSisbOutboundServiceUnit");//$NON-NLS-1$
		top.getUnits().add(wasSisbOutboundServiceUnit);

		//
		// add outbound service cap
		//
		WasSibOutboundService wasSibOutboundService = WasFactory.eINSTANCE
				.createWasSibOutboundService();
		wasSibOutboundService.setServiceName("wasSibOutboundService");//$NON-NLS-1$
		wasSibOutboundService.setName("Provide_wasSibOutboundService");//$NON-NLS-1$
		wasSibOutboundService.setDisplayName("wasSibOutboundService");//$NON-NLS-1$
		wasSibOutboundService.setWsdlLocation("test.wsdl");//$NON-NLS-1$
		wasSibOutboundService.setLinkType(CapabilityLinkTypes.ANY_LITERAL);
		wasSisbOutboundServiceUnit.getCapabilities().add(wasSibOutboundService);

		//
		// add WasSIBus hosting requirement
		//
		Requirement requiredWasSIBus = ValidatorTestUtils
				.createHostingRequirement(WasPackage.Literals.WAS_SI_BUS,
						"requiredWasSIBus");//$NON-NLS-1$
		wasSisbOutboundServiceUnit.getRequirements().add(requiredWasSIBus);
		// create wasSIBusUnit
		WasSIBusUnit sibusUnit = WasFactory.eINSTANCE.createWasSIBusUnit();
		sibusUnit.setName("sibusUnit"); //$NON-NLS-1$
		sibusUnit.setDisplayName("sibusUnit"); //$NON-NLS-1$		
		top.getUnits().add(sibusUnit);
		// add wasSIBus cap
		WasSIBus wasSIBus = WasFactory.eINSTANCE.createWasSIBus();
		wasSIBus.setName("wasSIBus"); //$NON-NLS-1$
		wasSIBus.setDisplayName("wasSIBus"); //$NON-NLS-1$
		wasSIBus.setBusName("wasSIBus");//$NON-NLS-1$
		wasSIBus.setLinkType(CapabilityLinkTypes.ANY_LITERAL);
		sibusUnit.getHostingOrAnyCapabilities().add(wasSIBus);
		ValidatorTestUtils.hosts(sibusUnit, wasSisbOutboundServiceUnit);

		//
		// add WasSIBDestination requirement
		//
		Requirement requireSIBDestination = ValidatorTestUtils
				.createDependencyRequirement(
						WasPackage.Literals.WAS_SIB_DESTINATION,
						"requireDestinaition");//$NON-NLS-1$
		wasSisbOutboundServiceUnit.getRequirements().add(requireSIBDestination);
		// create sibDestination unit
		WasSibDestinationUnit destinationUnit = WasFactory.eINSTANCE
				.createWasSibDestinationUnit();
		destinationUnit.setName("destinationUnit");//$NON-NLS-1$
		destinationUnit.setDisplayName("destinationUnit");//$NON-NLS-1$
		top.getUnits().add(destinationUnit);
		// add sibDestination cap
		WasSibDestination destinationCap = WasFactory.eINSTANCE
				.createWasSibDestination();
		destinationCap.setName("destinationCap");//$NON-NLS-1$
		destinationCap.setType(WasSibDestinationTypeEnum.WEB_SERVICE_LITERAL);
		destinationCap.setLinkType(CapabilityLinkTypes.ANY_LITERAL);
		destinationUnit.getCapabilities().add(destinationCap);

		// Link between sibOutboundserviceUnit and destinationUnit
		DependencyLink wasSIBOutboundServiceToWasSIBDestinationDependencyLink = CoreFactory.eINSTANCE
				.createDependencyLink();
		wasSIBOutboundServiceToWasSIBDestinationDependencyLink
				.setTarget(destinationCap);
		requireSIBDestination
				.setLink(wasSIBOutboundServiceToWasSIBDestinationDependencyLink);
		ValidatorTestUtils
				.createLinkName(wasSIBOutboundServiceToWasSIBDestinationDependencyLink);

		// /////////////////
		Resource res = top.getEObject().eResource();
		res.save(null);
		// /////////////////

		validator.validate(wasSisbOutboundServiceUnit, context, reporter);
		System.out.println("In " + this.getClass());
		dumpMarkers(top);
		ValidatorTestUtils.assertValidationErrorCount(0, top,
				wasSisbOutboundServiceUnit, context, reporter, validator);

		// wsdlLocation not empty
		String savedWsdlName = wasSibOutboundService.getWsdlLocation();
		wasSibOutboundService.setWsdlLocation("");//$NON-NLS-1$
		ValidatorTestUtils.assertValidationErrorCount(2, top,
				wasSisbOutboundServiceUnit, context, reporter, validator);
		wasSibOutboundService.setWsdlLocation(savedWsdlName);
		ValidatorTestUtils.assertValidationErrorCount(0, top,
				wasSisbOutboundServiceUnit, context, reporter, validator);

		// wsdlLocation end with '.wsdl'
		wasSibOutboundService.setWsdlLocation("test_not_endwith_valid_string");//$NON-NLS-1$
		ValidatorTestUtils.assertValidationErrorCount(1, top,
				wasSisbOutboundServiceUnit, context, reporter, validator);
		wasSibOutboundService.setWsdlLocation(savedWsdlName);
		ValidatorTestUtils.assertValidationErrorCount(0, top,
				wasSisbOutboundServiceUnit, context, reporter, validator);

	}

}
