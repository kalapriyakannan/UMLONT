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

/*import com.ibm.ccl.soa.deploy.core.CoreFactory;
 import com.ibm.ccl.soa.deploy.core.DependencyLink;*/
import com.ibm.ccl.soa.deploy.core.Requirement;
import com.ibm.ccl.soa.deploy.core.Topology;
import com.ibm.ccl.soa.deploy.core.test.TopologyTestCase;
import com.ibm.ccl.soa.deploy.core.test.validator.utils.ValidatorTestUtils;
import com.ibm.ccl.soa.deploy.core.validator.IDeployReporter;
import com.ibm.ccl.soa.deploy.core.validator.IDeployValidationContext;
import com.ibm.ccl.soa.deploy.core.validator.ValidatorUtils;
import com.ibm.ccl.soa.deploy.core.validator.resolution.ResolutionUtils;
import com.ibm.ccl.soa.deploy.was.IWasTemplateConstants;
import com.ibm.ccl.soa.deploy.was.WasDefaultMessagingTopicDestination;
import com.ibm.ccl.soa.deploy.was.WasDefaultMessagingTopicDestinationUnit;
import com.ibm.ccl.soa.deploy.was.WasNodeUnit;
import com.ibm.ccl.soa.deploy.was.WasPackage;
import com.ibm.ccl.soa.deploy.was.WasSibDestination;
import com.ibm.ccl.soa.deploy.was.WasSibDestinationTypeEnum;
import com.ibm.ccl.soa.deploy.was.WasSibDestinationUnit;
import com.ibm.ccl.soa.deploy.was.internal.validator.WasDefaultMessagingTopicDestinationValidator;

public class WasDefaultMessagingTopicDestinationUnitValidatorTest extends
		TopologyTestCase {

	private static final String PROJECT_NAME = "WasDefaultMessagingTopicDestinationUnitValidator";
	private final String STANDARD_6_WASVERSION = "6.0.0.1";//$NON-NLS-1$	
	private Topology _top;
	private IDeployValidationContext _context;
	private IDeployReporter _reporter;

	/**
	 * 
	 */
	public WasDefaultMessagingTopicDestinationUnitValidatorTest() {
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
	public void testWasDefaultMessagingTopicDestinationUnitValidator()
			throws IOException, CoreException {

		_top = createTopology(PROJECT_NAME, true);
		_context = createValidationContext(_top);
		_reporter = createDeployReporter();

		WasDefaultMessagingTopicDestinationUnit destUnit = (WasDefaultMessagingTopicDestinationUnit) ResolutionUtils
				.addFromTemplate(IWasTemplateConstants.WAS_DEFAULT_MESSAGING_TOPIC_DESTINATION_UNIT,
						_top);
		destUnit.getRequirements();

		destUnit.getCapabilities();

		WasDefaultMessagingTopicDestinationValidator validator = new WasDefaultMessagingTopicDestinationValidator();

		ValidatorTestUtils.assertValidationErrorCount(4, _top, destUnit,
				_context, _reporter, validator);

		WasDefaultMessagingTopicDestination destcap = (WasDefaultMessagingTopicDestination) ValidatorUtils
				.getCapability(destUnit, WasPackage.eINSTANCE
						.getWasDefaultMessagingTopicDestination());

		destcap.setJndiName("jms/topicdest");
		destcap.setDestinationName("topicDest");

		ValidatorTestUtils.assertValidationErrorCount(2, _top, destUnit,
				_context, _reporter, validator);

		WasNodeUnit nodeUnit = (WasNodeUnit) ResolutionUtils.addFromTemplate(IWasTemplateConstants.WAS_6_NODE_UNIT, _top);

		ValidatorTestUtils.hosts(nodeUnit, destUnit);

		ValidatorTestUtils.assertValidationErrorCount(1, _top, destUnit,
				_context, _reporter, validator);

		WasSibDestinationUnit sibDestUnit = (WasSibDestinationUnit) ResolutionUtils
				.addFromTemplate(IWasTemplateConstants.WAS_SIBUS_DESTINATION_UNIG, _top);
		WasSibDestination sibDestCap = (WasSibDestination) ValidatorUtils
				.getCapability(sibDestUnit, WasPackage.eINSTANCE
						.getWasSibDestination());
		sibDestCap.setType(WasSibDestinationTypeEnum.TOPIC_SPACE_LITERAL);
		Requirement requiredWasSibdest = (Requirement) ValidatorUtils
				.getRequirements(destUnit,
						WasPackage.eINSTANCE.getWasSibDestination()).get(0);

		ValidatorTestUtils.depends(sibDestUnit, sibDestCap, destUnit,
				requiredWasSibdest);
		/*
		 * DependencyLink dependlink =
		 * CoreFactory.eINSTANCE.createDependencyLink(); dependlink.setTarget(
		 * sibDestCap ); requiredWasSibdest.setLink(dependlink);
		 * ValidatorTestUtils.createLinkName(dependlink);
		 */
		ValidatorTestUtils.assertValidationErrorCount(0, _top, destUnit,
				_context, _reporter, validator);
	}

}
