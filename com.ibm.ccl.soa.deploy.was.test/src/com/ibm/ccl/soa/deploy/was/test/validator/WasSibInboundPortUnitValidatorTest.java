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
import com.ibm.ccl.soa.deploy.was.WasEndpointListenerConfiguration;
import com.ibm.ccl.soa.deploy.was.WasEndpointListenerUnit;
import com.ibm.ccl.soa.deploy.was.WasFactory;
import com.ibm.ccl.soa.deploy.was.WasPackage;
import com.ibm.ccl.soa.deploy.was.WasSibInboundPort;
import com.ibm.ccl.soa.deploy.was.WasSibInboundPortUnit;
import com.ibm.ccl.soa.deploy.was.WasSibInboundService;
import com.ibm.ccl.soa.deploy.was.WasSibInboundServiceUnit;
import com.ibm.ccl.soa.deploy.was.internal.validator.WasSibInboundPortUnitValidator;

/**
 * @author lidb@cn.ibm.com
 */
public class WasSibInboundPortUnitValidatorTest extends TopologyTestCase {

	private static final String PROJECT_NAME = "WasSibIntboundPortUnitValidatorTest";

	/**
	 * @author lidb@cn.ibm.com
	 */
	public WasSibInboundPortUnitValidatorTest() {
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
	public void testWasSibInboundPortUnitValidator() throws IOException,
			CoreException {
		Topology top = createTopology(PROJECT_NAME, true);
		IDeployValidationContext context = createValidationContext(top);
		IDeployReporter reporter = createDeployReporter();
		WasSibInboundPortUnitValidator validator = new WasSibInboundPortUnitValidator();

		//
		// create wassib inbound port unit
		//
		WasSibInboundPortUnit inboundPortUnit = WasFactory.eINSTANCE
				.createWasSibInboundPortUnit();
		inboundPortUnit.setName("inboundPortUnit");//$NON-NLS-1$
		inboundPortUnit.setDisplayName("inboundPortUnit");//$NON-NLS-1$
		top.getUnits().add(inboundPortUnit);

		//
		// create inbound port capability
		//
		WasSibInboundPort inboundPortCap = WasFactory.eINSTANCE
				.createWasSibInboundPort();
		inboundPortCap.setName("provide_inboundPortCap");//$NON-NLS-1$
		inboundPortCap.setPortName("inboundPortCap");//$NON-NLS-1$
		inboundPortCap.setLinkType(CapabilityLinkTypes.ANY_LITERAL);
		inboundPortUnit.getCapabilities().add(inboundPortCap);

		//
		// create another portUnit for portName uniqueness checking
		//
		WasSibInboundPortUnit inboundPortUnit_2 = WasFactory.eINSTANCE
				.createWasSibInboundPortUnit();
		inboundPortUnit_2.setName("inboundPortUnit_2");//$NON-NLS-1$
		inboundPortUnit_2.setDisplayName("inboundPortUnit_2");//$NON-NLS-1$
		top.getUnits().add(inboundPortUnit_2);
		WasSibInboundPort inboundPortCap_2 = WasFactory.eINSTANCE
				.createWasSibInboundPort();
		inboundPortCap_2.setName("provide_inboundPortCap_2");//$NON-NLS-1$
		inboundPortCap_2.setPortName("inboundPortCap_2");//$NON-NLS-1$
		inboundPortCap_2.setLinkType(CapabilityLinkTypes.ANY_LITERAL);
		inboundPortUnit_2.getCapabilities().add(inboundPortCap_2);

		Requirement requiredWasSIBInboundservice_2 = ValidatorTestUtils
				.createHostingRequirement(
						WasPackage.Literals.WAS_SIB_INBOUND_SERVICE,
						"requiredWasSIBInboundservice_2");//$NON-NLS-1$
		inboundPortUnit_2.getRequirements().add(requiredWasSIBInboundservice_2);

		//
		// add wasSibInboudservice hosting requirement
		//
		Requirement requiredWasSIBInboundservice = ValidatorTestUtils
				.createHostingRequirement(
						WasPackage.Literals.WAS_SIB_INBOUND_SERVICE,
						"requiredWasSIBInboundservice");//$NON-NLS-1$
		inboundPortUnit.getRequirements().add(requiredWasSIBInboundservice);
		// create wasSibInboudservice unit
		WasSibInboundServiceUnit wasSibInboundServiceUnit = WasFactory.eINSTANCE
				.createWasSibInboundServiceUnit();
		wasSibInboundServiceUnit.setName("wasSibInboundServiceUnit");//$NON-NLS-1$
		wasSibInboundServiceUnit.setDisplayName("wasSibInboundServiceUnit");//$NON-NLS-1$
		top.getUnits().add(wasSibInboundServiceUnit);
		// add outbound service cap
		WasSibInboundService wasSibinboundService = WasFactory.eINSTANCE
				.createWasSibInboundService();
		wasSibinboundService.setServiceName("wasSibinboundService");//$NON-NLS-1$
		wasSibinboundService.setName("Provide_wasSibInboundService");//$NON-NLS-1$
		wasSibinboundService.setDisplayName("wasSibinboundService");//$NON-NLS-1$
		wasSibinboundService.setWsdlLocation("test.wsdl");//$NON-NLS-1$
		wasSibinboundService.setLinkType(CapabilityLinkTypes.ANY_LITERAL);
		wasSibInboundServiceUnit.getHostingOrAnyCapabilities().add(
				wasSibinboundService);
		ValidatorTestUtils.hosts(wasSibInboundServiceUnit, inboundPortUnit);
		ValidatorTestUtils.hosts(wasSibInboundServiceUnit, inboundPortUnit_2);

		//
		// add EnderpointLisenter requirement
		//
		Requirement requireSIBEndpointLinsenter = ValidatorTestUtils
				.createDependencyRequirement(
						WasPackage.Literals.WAS_ENDPOINT_LISTENER_CONFIGURATION,
						"requireSIBEndpointLinsenter");//$NON-NLS-1$
		inboundPortUnit.getRequirements().add(requireSIBEndpointLinsenter);
		// create EndpointLinsenter unit
		WasEndpointListenerUnit endpointLUnit = WasFactory.eINSTANCE
				.createWasEndpointListenerUnit();
		endpointLUnit.setName("endpointLUnit");//$NON-NLS-1$
		endpointLUnit.setDisplayName("endpointLUnit");//$NON-NLS-1$
		top.getUnits().add(endpointLUnit);
		// add endpoint cap
		WasEndpointListenerConfiguration endpoint = WasFactory.eINSTANCE
				.createWasEndpointListenerConfiguration();
		endpoint.setName("endpoint");//$NON-NLS-1$
		endpoint.setLinkType(CapabilityLinkTypes.ANY_LITERAL);
		endpointLUnit.getCapabilities().add(endpoint);

		// Link between portUnit and endpoint
		DependencyLink port2endpointDependencyLink = CoreFactory.eINSTANCE
				.createDependencyLink();
		port2endpointDependencyLink.setTarget(endpoint);
		requireSIBEndpointLinsenter.setLink(port2endpointDependencyLink);
		ValidatorTestUtils.createLinkName(port2endpointDependencyLink);

		// /////////////////
		Resource res = top.getEObject().eResource();
		res.save(null);
		// /////////////////

		validator.validate(inboundPortUnit, context, reporter);
		System.out.println("In " + this.getClass());
		dumpMarkers(top);
		ValidatorTestUtils.assertValidationErrorCount(0, top, inboundPortUnit,
				context, reporter, validator);

		//
		// port name not empty
		//
		String savedPortName = inboundPortCap.getPortName();
		inboundPortCap.setPortName("");//$NON-NLS-1$
		ValidatorTestUtils.assertValidationErrorCount(1, top, inboundPortUnit,
				context, reporter, validator);
		inboundPortCap.setPortName(savedPortName);
		ValidatorTestUtils.assertValidationErrorCount(0, top, inboundPortUnit,
				context, reporter, validator);

		//
		// portname unique in outboundserviceUnit
		//
		inboundPortCap_2.setPortName(savedPortName);
		ValidatorTestUtils.assertValidationErrorCount(1, top, inboundPortUnit,
				context, reporter, validator);
		inboundPortCap_2.setPortName("");
		ValidatorTestUtils.assertValidationErrorCount(0, top, inboundPortUnit,
				context, reporter, validator);

	}
}
