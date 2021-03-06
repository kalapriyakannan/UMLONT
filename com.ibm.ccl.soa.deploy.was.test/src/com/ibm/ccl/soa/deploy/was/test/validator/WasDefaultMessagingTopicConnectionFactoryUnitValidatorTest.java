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
import com.ibm.ccl.soa.deploy.was.IWasTemplateConstants;
import com.ibm.ccl.soa.deploy.was.WasDefaultMessagingTopicConnectionFactoryConfiguration;
import com.ibm.ccl.soa.deploy.was.WasDefaultMessagingTopicConnectionFactoryUnit;
import com.ibm.ccl.soa.deploy.was.WasNodeUnit;
import com.ibm.ccl.soa.deploy.was.WasPackage;
import com.ibm.ccl.soa.deploy.was.WasSIBus;
import com.ibm.ccl.soa.deploy.was.WasSIBusUnit;
import com.ibm.ccl.soa.deploy.was.internal.validator.WasDefaultMessagingTopicConnetionFactoryValidator;

public class WasDefaultMessagingTopicConnectionFactoryUnitValidatorTest extends
		TopologyTestCase {

	private static final String PROJECT_NAME = "WasDefaultMessagingTopicConnectionFactoryUnitValidatorTest";
	private final String STANDARD_6_WASVERSION = "6.0.0.1";//$NON-NLS-1$	
	private Topology _top;
	private IDeployValidationContext _context;
	private IDeployReporter _reporter;

	/**
	 * 
	 */
	public WasDefaultMessagingTopicConnectionFactoryUnitValidatorTest() {
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
	public void testWasDefaultMessagingTopicConnectionFactoryUnitValidator()
			throws IOException, CoreException {

		_top = createTopology(PROJECT_NAME, true);
		_context = createValidationContext(_top);
		_reporter = createDeployReporter();

		WasDefaultMessagingTopicConnectionFactoryUnit cfUnit = (WasDefaultMessagingTopicConnectionFactoryUnit) ResolutionUtils
				.addFromTemplate(IWasTemplateConstants.WAS_DEFAULT_MESSAGING_TOPIC_CONNECTION_FACTORY_UNIT,
						_top);
		cfUnit.getRequirements();

		cfUnit.getCapabilities();

		WasDefaultMessagingTopicConnetionFactoryValidator validator = new WasDefaultMessagingTopicConnetionFactoryValidator();

		ValidatorTestUtils.assertValidationErrorCount(4, _top, cfUnit,
				_context, _reporter, validator);

		WasDefaultMessagingTopicConnectionFactoryConfiguration cfCap = (WasDefaultMessagingTopicConnectionFactoryConfiguration) ValidatorUtils
				.getCapability(
						cfUnit,
						WasPackage.eINSTANCE
								.getWasDefaultMessagingTopicConnectionFactoryConfiguration());

		cfCap.setJndiName("jms/cf1");
		cfCap.setFactoryName("cf1");

		ValidatorTestUtils.assertValidationErrorCount(2, _top, cfUnit,
				_context, _reporter, validator);

		WasNodeUnit nodeUnit = (WasNodeUnit) ResolutionUtils.addFromTemplate(IWasTemplateConstants.WAS_6_NODE_UNIT, _top);

		ValidatorTestUtils.hosts(nodeUnit, cfUnit);

		ValidatorTestUtils.assertValidationErrorCount(1, _top, cfUnit,
				_context, _reporter, validator);

		WasSIBusUnit sibusUnit = (WasSIBusUnit) ResolutionUtils
				.addFromTemplate(IWasTemplateConstants.WAS_SIBUS_UNIT, _top);

		WasSIBus sibustCap = (WasSIBus) ValidatorUtils.getCapability(sibusUnit,
				WasPackage.eINSTANCE.getWasSIBus());

		Requirement requiredWasSibus = (Requirement) ValidatorUtils
				.getRequirements(cfUnit, WasPackage.eINSTANCE.getWasSIBus())
				.get(0);

		ValidatorTestUtils.depends(sibusUnit, sibustCap, cfUnit,
				requiredWasSibus);
		ValidatorTestUtils.assertValidationErrorCount(0, _top, cfUnit,
				_context, _reporter, validator);
	}
}
