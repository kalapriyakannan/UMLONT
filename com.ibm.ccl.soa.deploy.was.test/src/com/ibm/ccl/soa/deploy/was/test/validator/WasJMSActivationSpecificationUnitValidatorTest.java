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

import com.ibm.ccl.soa.deploy.core.Requirement;
import com.ibm.ccl.soa.deploy.core.Topology;
import com.ibm.ccl.soa.deploy.core.test.TopologyTestCase;
import com.ibm.ccl.soa.deploy.core.test.validator.utils.ValidatorTestUtils;
import com.ibm.ccl.soa.deploy.core.validator.IDeployReporter;
import com.ibm.ccl.soa.deploy.core.validator.IDeployValidationContext;
import com.ibm.ccl.soa.deploy.core.validator.ValidatorUtils;
import com.ibm.ccl.soa.deploy.core.validator.resolution.ResolutionUtils;
import com.ibm.ccl.soa.deploy.j2ee.jms.JmsPackage;
import com.ibm.ccl.soa.deploy.was.IWasTemplateConstants;
import com.ibm.ccl.soa.deploy.was.WasDefaultMessagingQueueDestination;
import com.ibm.ccl.soa.deploy.was.WasDefaultMessagingQueueDestinationUnit;
import com.ibm.ccl.soa.deploy.was.WasJMSActivationSpecification;
import com.ibm.ccl.soa.deploy.was.WasJMSActivationSpecificationUnit;
import com.ibm.ccl.soa.deploy.was.WasNodeUnit;
import com.ibm.ccl.soa.deploy.was.WasPackage;
import com.ibm.ccl.soa.deploy.was.internal.validator.WasJMSActivationSpecificationUnitValidator;

/**
 * Test case
 */
public class WasJMSActivationSpecificationUnitValidatorTest extends
		TopologyTestCase {

	private static final String PROJECT_NAME = "WasJMSActivationSpecificationUnitValidatorTest";
	// private final String STANDARD_6_WASVERSION = "6.0.0.1";//$NON-NLS-1$
	private Topology _top;
	private IDeployValidationContext _context;
	private IDeployReporter _reporter;

	/**
	 * 
	 */
	public WasJMSActivationSpecificationUnitValidatorTest() {
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
	public void testWasJMSActivationSpecificationUnitValidator()
			throws IOException, CoreException {

		_top = createTopology(PROJECT_NAME, true);
		_context = createValidationContext(_top);
		_reporter = createDeployReporter();

		WasJMSActivationSpecificationUnit asUnit = (WasJMSActivationSpecificationUnit) ResolutionUtils
				.addFromTemplate(
						IWasTemplateConstants.WAS_JMS_ACTIVATION_SPECIFICATION_UNIT,
						_top);
		asUnit.getRequirements();

		asUnit.getCapabilities();

		WasJMSActivationSpecificationUnitValidator validator = new WasJMSActivationSpecificationUnitValidator();

		ValidatorTestUtils.assertValidationErrorCount(4, _top, asUnit,
				_context, _reporter, validator);

		WasJMSActivationSpecification asCap = (WasJMSActivationSpecification) ValidatorUtils
				.getCapability(asUnit,
						WasPackage.Literals.WAS_JMS_ACTIVATION_SPECIFICATION);

		asCap.setJndiName("jms/as1");
		asCap.setSpecificationName("as1");

		ValidatorTestUtils.assertValidationErrorCount(2, _top, asUnit,
				_context, _reporter, validator);

		WasNodeUnit nodeUnit = (WasNodeUnit) ResolutionUtils.addFromTemplate(
				IWasTemplateConstants.WAS_6_NODE_UNIT, _top);

		ValidatorTestUtils.hosts(nodeUnit, asUnit);

		ValidatorTestUtils.assertValidationErrorCount(1, _top, asUnit,
				_context, _reporter, validator);

		WasDefaultMessagingQueueDestinationUnit qDestUnit = (WasDefaultMessagingQueueDestinationUnit) ResolutionUtils
				.addFromTemplate(
						IWasTemplateConstants.WAS_DEFAULT_MESSAGING_QUEUE_DESTINATION_UNIT,
						_top);

		WasDefaultMessagingQueueDestination qDestCap = (WasDefaultMessagingQueueDestination) ValidatorUtils
				.getCapability(
						qDestUnit,
						WasPackage.Literals.WAS_DEFAULT_MESSAGING_QUEUE_DESTINATION);

		Requirement requiredQDest = ValidatorUtils.getRequirements(asUnit,
				JmsPackage.Literals.JMS_DESTINATION).get(0);

		ValidatorTestUtils.depends(qDestUnit, qDestCap, asUnit, requiredQDest);
		ValidatorTestUtils.assertValidationErrorCount(0, _top, asUnit,
				_context, _reporter, validator);
	}

}
