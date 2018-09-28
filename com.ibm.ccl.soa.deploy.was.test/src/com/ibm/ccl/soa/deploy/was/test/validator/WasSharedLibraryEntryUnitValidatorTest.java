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
import com.ibm.ccl.soa.deploy.was.SharedLibraryEntry;
import com.ibm.ccl.soa.deploy.was.WasCellUnit;
import com.ibm.ccl.soa.deploy.was.WasFactory;
import com.ibm.ccl.soa.deploy.was.WasPackage;
import com.ibm.ccl.soa.deploy.was.WasSharedLibContainer;
import com.ibm.ccl.soa.deploy.was.WasSharedLibraryEntryUnit;
import com.ibm.ccl.soa.deploy.was.internal.validator.WasSharedLibraryEntryUnitValidator;

/**
 * Tests {@link WasSharedLibraryEntryUnitValidator}
 * 
 * @since 3.2
 * 
 */
public class WasSharedLibraryEntryUnitValidatorTest extends TopologyTestCase {
	private static final String PROJECT_NAME = "WasSharedLibraryEntryUnitValidatorTest";

	/**
	 * 
	 * 
	 */
	public WasSharedLibraryEntryUnitValidatorTest() {
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
	public void testWasSubstitutionVariableUnitValidator() throws IOException,
			CoreException {
		Topology top = createTopology("WasSharedLibraryEntryUnitValidator",
				true);

		IDeployValidationContext context = createValidationContext(top);
		IDeployReporter reporter = createDeployReporter();
		WasSharedLibraryEntryUnitValidator validator = new WasSharedLibraryEntryUnitValidator();

		// sharedLibEntryUnit
		SharedLibraryEntry sharedLibEntry = WasFactory.eINSTANCE
				.createSharedLibraryEntry();
		sharedLibEntry.setName("sharedLibEntry");//$NON-NLS-1$
		sharedLibEntry.setDisplayName("sharedLibEntry");//$NON-NLS-1$
		sharedLibEntry.setSharedLibraryEntryName("sharedLibEntry");//$NON-NLS-1$
		sharedLibEntry.setLinkType(CapabilityLinkTypes.ANY_LITERAL);
		WasSharedLibraryEntryUnit sharedLibEntryUnit = WasFactory.eINSTANCE
				.createWasSharedLibraryEntryUnit();
		sharedLibEntryUnit.setName("sharedLibEntryUnit");//$NON-NLS-1$
		sharedLibEntryUnit.getCapabilities().add(sharedLibEntry);
		top.getUnits().add(sharedLibEntryUnit);

		//
		// Require SharedLibContainer
		//
		Requirement requiredWasSharedLibContainer;
		requiredWasSharedLibContainer = ValidatorTestUtils
				.createHostingRequirement(WasPackage.eINSTANCE
						.getWasSharedLibContainer(),
						"requiredWasSharedLibContainer");//$NON-NLS-1$
		sharedLibEntryUnit.getRequirements().add(requiredWasSharedLibContainer);

		WasCellUnit wasCellUnit = WasFactory.eINSTANCE.createWasCellUnit();
		wasCellUnit.setName("wasCellUnit");//$NON-NLS-1$
		wasCellUnit.setDisplayName("wasCellUnit");//$NON-NLS-1$
		top.getUnits().add(wasCellUnit);

		WasSharedLibContainer provideWasSharedLibContainer = WasFactory.eINSTANCE
				.createWasSharedLibContainer();
		provideWasSharedLibContainer
				.setDisplayName("provideWasSharedLibContainer");//$NON-NLS-1$
		provideWasSharedLibContainer.setName("provideWasSharedLibContainer");//$NON-NLS-1$
		wasCellUnit.getHostingOrAnyCapabilities().add(
				provideWasSharedLibContainer);

		ValidatorTestUtils.hosts(wasCellUnit, sharedLibEntryUnit);

		// /////////////////
		Resource res = top.getEObject().eResource();
		res.save(null);
		// /////////////////

		validator.validate(sharedLibEntryUnit, context, reporter);
		System.out.println("In " + this.getClass()); //$NON-NLS-1$
		dumpMarkers(top);

		ValidatorTestUtils.assertValidationErrorCount(0, top,
				sharedLibEntryUnit, context, reporter, validator);

		String savedSharedLibEntryName = sharedLibEntry
				.getSharedLibraryEntryName();
		sharedLibEntry.setSharedLibraryEntryName("");//$NON-NLS-1$
		ValidatorTestUtils.assertValidationErrorCount(1, top,
				sharedLibEntryUnit, context, reporter, validator);
		sharedLibEntry.setSharedLibraryEntryName(savedSharedLibEntryName);
		ValidatorTestUtils.assertValidationErrorCount(0, top,
				sharedLibEntryUnit, context, reporter, validator);
	}

}
