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
import com.ibm.ccl.soa.deploy.was.WasSibMediation;
import com.ibm.ccl.soa.deploy.was.WasSibMediationUnit;
import com.ibm.ccl.soa.deploy.was.internal.validator.WasSibMediationValidator;

/**
 * @author lidb@cn.ibm.com
 * 
 */
public class WasSibMediationValidatorTest extends TopologyTestCase {
	private static final String PROJECT_NAME = "WasSibMediationValidatorTest"; //$NON-NLS-1$

	/**
	 * 
	 */
	public WasSibMediationValidatorTest() {
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
	public void testWasSibMediationValidator() throws IOException,
			CoreException {
		Topology top = createTopology(PROJECT_NAME, true);
		IDeployValidationContext context = createValidationContext(top);
		IDeployReporter reporter = createDeployReporter();
		WasSibMediationValidator validator = new WasSibMediationValidator();

		//
		// create WasSibMediation unit
		//
		WasSibMediationUnit wasSibMediationUnit = WasFactory.eINSTANCE
				.createWasSibMediationUnit();
		wasSibMediationUnit.setName("wasSibMediationUnit");//$NON-NLS-1$
		wasSibMediationUnit.setDisplayName("wasSibMediationUnit");//$NON-NLS-1$
		top.getUnits().add(wasSibMediationUnit);

		//
		// create wasSibMediation cap
		//
		WasSibMediation wasSIBMediationCap = WasFactory.eINSTANCE
				.createWasSibMediation();
		wasSIBMediationCap.setMediationName("wasSIBMediation_1");//$NON-NLS-1$
		wasSIBMediationCap.setName("Provide_wasSIBMediationCap");//$NON-NLS-1$
		wasSIBMediationCap.setDisplayName("wasSIBMediationCap");//$NON-NLS-1$
		wasSIBMediationCap.setHandlerListName("handlerList");//$NON-NLS-1$
		wasSIBMediationCap.setLinkType(CapabilityLinkTypes.ANY_LITERAL);
		wasSibMediationUnit.getCapabilities().add(wasSIBMediationCap);

		//
		// create another mediation for checking mediation name unique
		//
		WasSibMediationUnit wasSibMediationUnit_2 = WasFactory.eINSTANCE
				.createWasSibMediationUnit();
		wasSibMediationUnit_2.setName("wasSibMediationUnit_2");//$NON-NLS-1$
		wasSibMediationUnit_2.setDisplayName("wasSibMediationUnit_2");//$NON-NLS-1$
		top.getUnits().add(wasSibMediationUnit_2);
		WasSibMediation wasSIBMediationCap_2 = WasFactory.eINSTANCE
				.createWasSibMediation();
		wasSIBMediationCap_2.setMediationName("wasSIBMediationCap_2");//$NON-NLS-1$
		wasSIBMediationCap_2.setName("Provide_wasSIBMediationCap_2");//$NON-NLS-1$
		wasSIBMediationCap_2.setDisplayName("wasSIBMediationCap_2");//$NON-NLS-1$
		wasSIBMediationCap_2.setHandlerListName("handlerList");//$NON-NLS-1$
		wasSIBMediationCap_2.setLinkType(CapabilityLinkTypes.ANY_LITERAL);
		wasSibMediationUnit_2.getCapabilities().add(wasSIBMediationCap_2);
		Requirement requiredWasSIBus_2 = ValidatorTestUtils
				.createHostingRequirement(WasPackage.Literals.WAS_SI_BUS,
						"requiredWasSIBus_2");//$NON-NLS-1$
		wasSibMediationUnit_2.getRequirements().add(requiredWasSIBus_2);

		//
		// requiring host Sibus
		//
		Requirement requiredWasSIBus = ValidatorTestUtils
				.createHostingRequirement(WasPackage.Literals.WAS_SI_BUS,
						"requiredWasSIBus");//$NON-NLS-1$
		wasSibMediationUnit.getRequirements().add(requiredWasSIBus);
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
		ValidatorTestUtils.hosts(sibusUnit, wasSibMediationUnit);
		ValidatorTestUtils.hosts(sibusUnit, wasSibMediationUnit_2);

		// /////////////////
		Resource res = top.getEObject().eResource();
		res.save(null);
		// /////////////////

		validator.validate(wasSibMediationUnit, context, reporter);
		System.out.println("In " + this.getClass());
		dumpMarkers(top);
		ValidatorTestUtils.assertValidationErrorCount(0, top,
				wasSibMediationUnit, context, reporter, validator);

		// mediation name not empty
		String savedMediationName = wasSIBMediationCap.getMediationName();
		wasSIBMediationCap.setMediationName("");//$NON-NLS-1$
		ValidatorTestUtils.assertValidationErrorCount(1, top,
				wasSibMediationUnit, context, reporter, validator);
		wasSIBMediationCap.setMediationName(savedMediationName);
		ValidatorTestUtils.assertValidationErrorCount(0, top,
				wasSibMediationUnit, context, reporter, validator);

		// mediation Name unique in sibus
		wasSIBMediationCap_2.setMediationName(savedMediationName);
		ValidatorTestUtils.assertValidationErrorCount(1, top,
				wasSibMediationUnit, context, reporter, validator);
		wasSIBMediationCap_2.setMediationName("test_mediation_2");//$NON-NLS-1$
		ValidatorTestUtils.assertValidationErrorCount(0, top,
				wasSibMediationUnit, context, reporter, validator);

		// handlerlist name not empty
		String savedHandlerlistName = wasSIBMediationCap.getHandlerListName();
		wasSIBMediationCap.setHandlerListName("");//$NON-NLS-1$
		ValidatorTestUtils.assertValidationErrorCount(1, top,
				wasSibMediationUnit, context, reporter, validator);
		wasSIBMediationCap.setHandlerListName(savedHandlerlistName);
		ValidatorTestUtils.assertValidationErrorCount(0, top,
				wasSibMediationUnit, context, reporter, validator);

	}

}
