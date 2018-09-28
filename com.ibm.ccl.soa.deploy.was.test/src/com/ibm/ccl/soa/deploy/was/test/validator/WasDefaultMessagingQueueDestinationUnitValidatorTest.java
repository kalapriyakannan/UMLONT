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
import com.ibm.ccl.soa.deploy.was.WasCellUnit;
import com.ibm.ccl.soa.deploy.was.WasConfigurationContainer;
import com.ibm.ccl.soa.deploy.was.WasDefaultMessagingQueueDestination;
import com.ibm.ccl.soa.deploy.was.WasDefaultMessagingQueueDestinationUnit;
import com.ibm.ccl.soa.deploy.was.WasFactory;
import com.ibm.ccl.soa.deploy.was.WasPackage;
import com.ibm.ccl.soa.deploy.was.WasSibDestination;
import com.ibm.ccl.soa.deploy.was.WasSibDestinationTypeEnum;
import com.ibm.ccl.soa.deploy.was.WasSibDestinationUnit;
import com.ibm.ccl.soa.deploy.was.internal.validator.WasDefaultMessagingQueueDestinationValidator;

/**
 * @author lidb@cn.ibm.com
 * 
 */
public class WasDefaultMessagingQueueDestinationUnitValidatorTest extends
		TopologyTestCase {

	private static final String PROJECT_NAME = "WasDefaultMessagingQueueDestinationUnitValidatorTest"; //$NON-NLS-1$

	/**
	 * @author lidb@cn.ibm.com
	 * 
	 */
	public WasDefaultMessagingQueueDestinationUnitValidatorTest() {
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
	public void testWasDefaultMessagingQueueDestinationUnitValidator()
			throws IOException, CoreException {
		Topology top = createTopology(PROJECT_NAME, true);
		IDeployValidationContext context = createValidationContext(top);
		IDeployReporter reporter = createDeployReporter();
		WasDefaultMessagingQueueDestinationValidator validator = new WasDefaultMessagingQueueDestinationValidator();

		//
		// create WasDefaultMessagingQueueDestinationUnit
		//
		WasDefaultMessagingQueueDestinationUnit defaultMQDUnit = WasFactory.eINSTANCE
				.createWasDefaultMessagingQueueDestinationUnit();
		defaultMQDUnit.setName("defaultMQDUnit");//$NON-NLS-1$
		defaultMQDUnit.setDisplayName("defaultMQDUnit");//$NON-NLS-1$
		top.getUnits().add(defaultMQDUnit);

		//
		// add capability was:WasDefaultMessagingQueueDestination, linkType:
		// any;
		//
		WasDefaultMessagingQueueDestination wasDefaultMessagingQueueDestinationCap = WasFactory.eINSTANCE
				.createWasDefaultMessagingQueueDestination();
		wasDefaultMessagingQueueDestinationCap
				.setName("Provide_wasDefaultMessagingQueueDestinationCap");//$NON-NLS-1$
		wasDefaultMessagingQueueDestinationCap
				.setDisplayName("wasDefaultMessagingQueueDestination");//$NON-NLS-1$
		wasDefaultMessagingQueueDestinationCap
				.setDestinationName("test_destination");//$NON-NLS-1$
		wasDefaultMessagingQueueDestinationCap.setJndiName("test_jndiname_1");//$NON-NLS-1$
		wasDefaultMessagingQueueDestinationCap
				.setLinkType(CapabilityLinkTypes.ANY_LITERAL);
		defaultMQDUnit.getCapabilities().add(
				wasDefaultMessagingQueueDestinationCap);

		//
		// create another WasDefaultMessagingQueueDestinationUnit for test
		// attributes uniquness
		//
		WasDefaultMessagingQueueDestinationUnit wasDefaultMessagingQueueDestinationUnit_2 = WasFactory.eINSTANCE
				.createWasDefaultMessagingQueueDestinationUnit();
		wasDefaultMessagingQueueDestinationUnit_2
				.setName("wasDefaultMessagingQueueDestinationUnit_2");//$NON-NLS-1$
		wasDefaultMessagingQueueDestinationUnit_2
				.setDisplayName("wasDefaultMessagingQueueDestinationUnit_2");//$NON-NLS-1$
		top.getUnits().add(wasDefaultMessagingQueueDestinationUnit_2);
		WasDefaultMessagingQueueDestination wasDefaultMessagingQueueDestination_2 = WasFactory.eINSTANCE
				.createWasDefaultMessagingQueueDestination();
		wasDefaultMessagingQueueDestination_2
				.setName("wasDefaultMessagingQueueDestination_2");//$NON-NLS-1$
		wasDefaultMessagingQueueDestination_2
				.setDisplayName("wasDefaultMessagingQueueDestination_2");//$NON-NLS-1$
		wasDefaultMessagingQueueDestination_2
				.setDestinationName("test_destination_2");//$NON-NLS-1$
		wasDefaultMessagingQueueDestination_2.setJndiName("test_jndiname_2");//$NON-NLS-1$
		wasDefaultMessagingQueueDestination_2
				.setLinkType(CapabilityLinkTypes.ANY_LITERAL);
		wasDefaultMessagingQueueDestinationUnit_2.getCapabilities().add(
				wasDefaultMessagingQueueDestination_2);
		Requirement requiredWasConfigurationContainer_2 = ValidatorTestUtils
				.createHostingRequirement(
						WasPackage.Literals.WAS_CONFIGURATION_CONTAINER,
						"requiredWasConfigurationContainer_2");//$NON-NLS-1$
		wasDefaultMessagingQueueDestinationUnit_2.getRequirements().add(
				requiredWasConfigurationContainer_2);

		//
		// hosting to was:WasConfigurationContainer unit
		//
		Requirement requiredWasConfigurationContainer = ValidatorTestUtils
				.createHostingRequirement(
						WasPackage.Literals.WAS_CONFIGURATION_CONTAINER,
						"requiredWasConfigurationContainer");//$NON-NLS-1$
		defaultMQDUnit.getRequirements().add(requiredWasConfigurationContainer);
		// create wasCellUnit
		WasCellUnit cellUnit = WasFactory.eINSTANCE.createWasCellUnit();
		cellUnit.setName("cellUnit"); //$NON-NLS-1$
		cellUnit.setDisplayName("cellUnit"); //$NON-NLS-1$		
		top.getUnits().add(cellUnit);
		// add wasConfigurationContainer cap
		WasConfigurationContainer configurationContainer = WasFactory.eINSTANCE
				.createWasConfigurationContainer();
		configurationContainer.setName("configurationContainer"); //$NON-NLS-1$
		configurationContainer.setDisplayName("configurationContainer"); //$NON-NLS-1$
		configurationContainer.setLinkType(CapabilityLinkTypes.ANY_LITERAL);
		cellUnit.getHostingOrAnyCapabilities().add(configurationContainer);
		ValidatorTestUtils.hosts(cellUnit, defaultMQDUnit);
		ValidatorTestUtils.hosts(cellUnit,
				wasDefaultMessagingQueueDestinationUnit_2);

		//
		// add WasSIBDestination requirement
		//
		Requirement requireSIBDestination = ValidatorTestUtils
				.createDependencyRequirement(
						WasPackage.Literals.WAS_SIB_DESTINATION,
						"requireDestinaition");//$NON-NLS-1$
		defaultMQDUnit.getRequirements().add(requireSIBDestination);
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

		validator.validate(defaultMQDUnit, context, reporter);
		System.out.println("In " + this.getClass());
		dumpMarkers(top);
		ValidatorTestUtils.assertValidationErrorCount(0, top, defaultMQDUnit,
				context, reporter, validator);

		// destination not empty
		String savedDestinationName = wasDefaultMessagingQueueDestinationCap
				.getDestinationName();
		wasDefaultMessagingQueueDestinationCap.setDestinationName("");//$NON-NLS-1$
		ValidatorTestUtils.assertValidationErrorCount(1, top, defaultMQDUnit,
				context, reporter, validator);
		wasDefaultMessagingQueueDestinationCap
				.setDestinationName(savedDestinationName);
		ValidatorTestUtils.assertValidationErrorCount(0, top, defaultMQDUnit,
				context, reporter, validator);

		// unique on host
		wasDefaultMessagingQueueDestination_2
				.setDestinationName(savedDestinationName);
		ValidatorTestUtils.assertValidationErrorCount(1, top, defaultMQDUnit,
				context, reporter, validator);
		wasDefaultMessagingQueueDestination_2
				.setDestinationName(savedDestinationName.concat("_2"));//$NON-NLS-1$
		ValidatorTestUtils.assertValidationErrorCount(0, top, defaultMQDUnit,
				context, reporter, validator);

		// jndiname not empty && unique on host
		String savedJndiName = wasDefaultMessagingQueueDestinationCap
				.getJndiName();
		wasDefaultMessagingQueueDestinationCap.setJndiName("");//$NON-NLS-1$
		ValidatorTestUtils.assertValidationErrorCount(1, top, defaultMQDUnit,
				context, reporter, validator);
		wasDefaultMessagingQueueDestinationCap.setJndiName(savedJndiName);
		ValidatorTestUtils.assertValidationErrorCount(0, top, defaultMQDUnit,
				context, reporter, validator);
		wasDefaultMessagingQueueDestination_2.setJndiName(savedJndiName);
		ValidatorTestUtils.assertValidationErrorCount(1, top, defaultMQDUnit,
				context, reporter, validator);
		wasDefaultMessagingQueueDestination_2.setJndiName(savedJndiName
				.concat("_2"));//$NON-NLS-1$
		ValidatorTestUtils.assertValidationErrorCount(0, top, defaultMQDUnit,
				context, reporter, validator);

	}

}
