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
import com.ibm.ccl.soa.deploy.was.WasSibDestinationUnit;
import com.ibm.ccl.soa.deploy.was.internal.validator.WasSibDestinationUnitValidator;

/**
 * @author lidb@cn.ibm.com
 * 
 */
public class WasSibDestinationUnitValidatorTest extends TopologyTestCase {
	private static final String PROJECT_NAME = "WasSibDestinationUnitValidatorTest"; //$NON-NLS-1$

	/**
	 */
	public WasSibDestinationUnitValidatorTest() {
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
	public void testWasSibDestinationUnitValidator() throws IOException,
			CoreException {
		Topology top = createTopology(PROJECT_NAME, true);
		IDeployValidationContext context = createValidationContext(top);
		IDeployReporter reporter = createDeployReporter();
		WasSibDestinationUnitValidator validator = new WasSibDestinationUnitValidator();

		//
		// create WasSibDestinationUnit unit
		//
		WasSibDestinationUnit wasSibDestinationUnit = WasFactory.eINSTANCE
				.createWasSibDestinationUnit();
		wasSibDestinationUnit.setName("wasSibDestinationUnit");//$NON-NLS-1$
		wasSibDestinationUnit.setDisplayName("wasSibDestinationUnit");//$NON-NLS-1$
		top.getUnits().add(wasSibDestinationUnit);

		//
		// add sib destination cap
		//
		WasSibDestination sibDestinationCap = WasFactory.eINSTANCE
				.createWasSibDestination();
		sibDestinationCap.setName("Provide_wasSibOutboundService");//$NON-NLS-1$
		sibDestinationCap.setDisplayName("wasSibOutboundService");//$NON-NLS-1$
		sibDestinationCap.setDestinationName("test_destination");//$NON-NLS-1$
		sibDestinationCap.setLinkType(CapabilityLinkTypes.ANY_LITERAL);
		wasSibDestinationUnit.getCapabilities().add(sibDestinationCap);

		//
		// create another sib destination for checking destination name unique
		//
		WasSibDestinationUnit wasSibDestinationUnit_2 = WasFactory.eINSTANCE
				.createWasSibDestinationUnit();
		wasSibDestinationUnit_2.setName("wasSibDestinationUnit_2");//$NON-NLS-1$
		wasSibDestinationUnit_2.setDisplayName("wasSibDestinationUnit_2");//$NON-NLS-1$
		top.getUnits().add(wasSibDestinationUnit_2);
		WasSibDestination sibDestinationCap_2 = WasFactory.eINSTANCE
				.createWasSibDestination();
		sibDestinationCap_2.setName("sibDestinationCap_2");//$NON-NLS-1$
		sibDestinationCap_2.setDisplayName("sibDestinationCap_2");//$NON-NLS-1$
		sibDestinationCap_2.setDestinationName("test_destination_2");//$NON-NLS-1$
		sibDestinationCap_2.setLinkType(CapabilityLinkTypes.ANY_LITERAL);
		wasSibDestinationUnit_2.getCapabilities().add(sibDestinationCap_2);
		Requirement requiredWasSIBus_2 = ValidatorTestUtils
				.createHostingRequirement(WasPackage.Literals.WAS_SI_BUS,
						"requiredWasSIBus_2");//$NON-NLS-1$
		wasSibDestinationUnit_2.getRequirements().add(requiredWasSIBus_2);

		//
		// hosting to sibus unit
		//
		Requirement requiredWasSIBus = ValidatorTestUtils
				.createHostingRequirement(WasPackage.Literals.WAS_SI_BUS,
						"requiredWasSIBus");//$NON-NLS-1$
		wasSibDestinationUnit.getRequirements().add(requiredWasSIBus);
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
		ValidatorTestUtils.hosts(sibusUnit, wasSibDestinationUnit);

		// host the other destinationunit
		ValidatorTestUtils.hosts(sibusUnit, wasSibDestinationUnit_2);

		// /////////////////
		Resource res = top.getEObject().eResource();
		res.save(null);
		// /////////////////

		validator.validate(wasSibDestinationUnit, context, reporter);
		System.out.println("In " + this.getClass());
		dumpMarkers(top);
		ValidatorTestUtils.assertValidationErrorCount(0, top,
				wasSibDestinationUnit, context, reporter, validator);

		// destination not empty
		String savedDestinationName = sibDestinationCap.getDestinationName();
		sibDestinationCap.setDestinationName("");//$NON-NLS-1$
		ValidatorTestUtils.assertValidationErrorCount(1, top,
				wasSibDestinationUnit, context, reporter, validator);
		sibDestinationCap.setDestinationName(savedDestinationName);
		ValidatorTestUtils.assertValidationErrorCount(0, top,
				wasSibDestinationUnit, context, reporter, validator);

		// destinationName unique in sibus
		sibDestinationCap_2.setDestinationName(savedDestinationName);
		ValidatorTestUtils.assertValidationErrorCount(1, top,
				wasSibDestinationUnit, context, reporter, validator);
		sibDestinationCap_2.setDestinationName("test_destination_2");//$NON-NLS-1$
		ValidatorTestUtils.assertValidationErrorCount(0, top,
				wasSibDestinationUnit, context, reporter, validator);
	}

}
