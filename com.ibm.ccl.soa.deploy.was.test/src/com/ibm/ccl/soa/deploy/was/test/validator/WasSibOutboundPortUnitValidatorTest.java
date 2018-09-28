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
import com.ibm.ccl.soa.deploy.was.WasSibDestination;
import com.ibm.ccl.soa.deploy.was.WasSibDestinationTypeEnum;
import com.ibm.ccl.soa.deploy.was.WasSibDestinationUnit;
import com.ibm.ccl.soa.deploy.was.WasSibOutboundPort;
import com.ibm.ccl.soa.deploy.was.WasSibOutboundPortUnit;
import com.ibm.ccl.soa.deploy.was.WasSibOutboundService;
import com.ibm.ccl.soa.deploy.was.WasSibOutboundServiceUnit;
import com.ibm.ccl.soa.deploy.was.internal.validator.WasSibOutboundPortUnitValidator;

/**
 * @author lidb@cn.ibm.com
 */
public class WasSibOutboundPortUnitValidatorTest extends TopologyTestCase {
	private static final String PROJECT_NAME = "WasSibOutboundPortUnitValidatorTest";

	/**
	 * 
	 */
	public WasSibOutboundPortUnitValidatorTest() {
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
	public void testWasSibOutboundPortUnitValidator() throws IOException,
			CoreException {
		Topology top = createTopology(PROJECT_NAME, true);
		IDeployValidationContext context = createValidationContext(top);
		IDeployReporter reporter = createDeployReporter();
		WasSibOutboundPortUnitValidator validator = new WasSibOutboundPortUnitValidator();

		//
		// create wassib out bound port unit
		//
		WasSibOutboundPortUnit outboundPortUnit = WasFactory.eINSTANCE
				.createWasSibOutboundPortUnit();
		outboundPortUnit.setName("outboundPortUnit");//$NON-NLS-1$
		outboundPortUnit.setDisplayName("outboundPortUnit");//$NON-NLS-1$
		top.getUnits().add(outboundPortUnit);

		//
		// create out bound port capability
		//
		WasSibOutboundPort outboundPortCap = WasFactory.eINSTANCE
				.createWasSibOutboundPort();
		outboundPortCap.setName("provide_outboundPortCap");//$NON-NLS-1$
		outboundPortCap.setPortName("outboundPortCap");//$NON-NLS-1$
		outboundPortCap.setLinkType(CapabilityLinkTypes.ANY_LITERAL);
		outboundPortUnit.getCapabilities().add(outboundPortCap);

		//
		// create another portUnit for portName uniqueness checking
		//
		WasSibOutboundPortUnit outboundPortUnit_2 = WasFactory.eINSTANCE
				.createWasSibOutboundPortUnit();
		outboundPortUnit_2.setName("outboundPortUnit_2");//$NON-NLS-1$
		outboundPortUnit_2.setDisplayName("outboundPortUnit_2");//$NON-NLS-1$
		top.getUnits().add(outboundPortUnit_2);
		WasSibOutboundPort outboundPortCap_2 = WasFactory.eINSTANCE
				.createWasSibOutboundPort();
		outboundPortCap_2.setName("provide_outboundPortCap_2");//$NON-NLS-1$
		outboundPortCap_2.setPortName("outboundPortCap_2");//$NON-NLS-1$
		outboundPortCap_2.setLinkType(CapabilityLinkTypes.ANY_LITERAL);
		outboundPortUnit_2.getCapabilities().add(outboundPortCap_2);
		Requirement requiredWasSIBOutboundservice_2 = ValidatorTestUtils
				.createHostingRequirement(
						WasPackage.Literals.WAS_SIB_OUTBOUND_SERVICE,
						"requiredWasSIBOutboundservice_2");//$NON-NLS-1$
		outboundPortUnit_2.getRequirements().add(
				requiredWasSIBOutboundservice_2);

		//
		// add wasSibOutboudservice hosting requirement
		//
		Requirement requiredWasSIBOutboundservice = ValidatorTestUtils
				.createHostingRequirement(
						WasPackage.Literals.WAS_SIB_OUTBOUND_SERVICE,
						"requiredWasSIBOutboundservice");//$NON-NLS-1$
		outboundPortUnit.getRequirements().add(requiredWasSIBOutboundservice);
		// create wasSibOutboudservice unit
		WasSibOutboundServiceUnit wasSisbOutboundServiceUnit = WasFactory.eINSTANCE
				.createWasSibOutboundServiceUnit();
		wasSisbOutboundServiceUnit.setName("wasSisbOutboundServiceUnit");//$NON-NLS-1$
		wasSisbOutboundServiceUnit.setDisplayName("wasSisbOutboundServiceUnit");//$NON-NLS-1$
		top.getUnits().add(wasSisbOutboundServiceUnit);
		// add outbound service cap
		WasSibOutboundService wasSibOutboundService = WasFactory.eINSTANCE
				.createWasSibOutboundService();
		wasSibOutboundService.setServiceName("wasSibOutboundService");//$NON-NLS-1$
		wasSibOutboundService.setName("Provide_wasSibOutboundService");//$NON-NLS-1$
		wasSibOutboundService.setDisplayName("wasSibOutboundService");//$NON-NLS-1$
		wasSibOutboundService.setWsdlLocation("test.wsdl");//$NON-NLS-1$
		wasSibOutboundService.setLinkType(CapabilityLinkTypes.ANY_LITERAL);
		wasSisbOutboundServiceUnit.getHostingOrAnyCapabilities().add(
				wasSibOutboundService);
		ValidatorTestUtils.hosts(wasSisbOutboundServiceUnit, outboundPortUnit);
		ValidatorTestUtils
				.hosts(wasSisbOutboundServiceUnit, outboundPortUnit_2);

		//
		// add WasSIBDestination requirement
		//
		Requirement requireSIBDestination = ValidatorTestUtils
				.createDependencyRequirement(
						WasPackage.Literals.WAS_SIB_DESTINATION,
						"requireDestinaition");//$NON-NLS-1$
		outboundPortUnit.getRequirements().add(requireSIBDestination);
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

		// Link between portUnit and destinationUnit
		DependencyLink wasSIBOutboundPortToWasSIBDestinationDependencyLink = CoreFactory.eINSTANCE
				.createDependencyLink();
		wasSIBOutboundPortToWasSIBDestinationDependencyLink
				.setTarget(destinationCap);
		requireSIBDestination
				.setLink(wasSIBOutboundPortToWasSIBDestinationDependencyLink);
		ValidatorTestUtils
				.createLinkName(wasSIBOutboundPortToWasSIBDestinationDependencyLink);

		// /////////////////
		Resource res = top.getEObject().eResource();
		res.save(null);
		// /////////////////

		validator.validate(outboundPortUnit, context, reporter);
		System.out.println("In " + this.getClass());
		dumpMarkers(top);
		ValidatorTestUtils.assertValidationErrorCount(0, top, outboundPortUnit,
				context, reporter, validator);

		//
		// port name not empty
		//
		String savedPortName = outboundPortCap.getPortName();
		outboundPortCap.setPortName("");//$NON-NLS-1$
		ValidatorTestUtils.assertValidationErrorCount(1, top, outboundPortUnit,
				context, reporter, validator);
		outboundPortCap.setPortName(savedPortName);
		ValidatorTestUtils.assertValidationErrorCount(0, top, outboundPortUnit,
				context, reporter, validator);

		//
		// portname unique in outboundserviceUnit
		//
		outboundPortCap_2.setPortName(savedPortName);
		ValidatorTestUtils.assertValidationErrorCount(1, top, outboundPortUnit,
				context, reporter, validator);
		outboundPortCap_2.setPortName("");
		ValidatorTestUtils.assertValidationErrorCount(0, top, outboundPortUnit,
				context, reporter, validator);

	}
}
