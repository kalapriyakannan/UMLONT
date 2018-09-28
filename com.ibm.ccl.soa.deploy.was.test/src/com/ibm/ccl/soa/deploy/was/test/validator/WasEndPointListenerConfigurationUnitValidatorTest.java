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

import com.ibm.ccl.soa.deploy.core.Topology;
import com.ibm.ccl.soa.deploy.core.test.TopologyTestCase;
import com.ibm.ccl.soa.deploy.core.test.validator.utils.ValidatorTestUtils;
import com.ibm.ccl.soa.deploy.core.validator.IDeployReporter;
import com.ibm.ccl.soa.deploy.core.validator.IDeployValidationContext;
import com.ibm.ccl.soa.deploy.core.validator.ValidatorUtils;
import com.ibm.ccl.soa.deploy.core.validator.resolution.ResolutionUtils;
import com.ibm.ccl.soa.deploy.was.IWasTemplateConstants;
import com.ibm.ccl.soa.deploy.was.WasEndpointListenerConfiguration;
import com.ibm.ccl.soa.deploy.was.WasEndpointListenerUnit;
import com.ibm.ccl.soa.deploy.was.WasPackage;
import com.ibm.ccl.soa.deploy.was.WebsphereAppServerUnit;
import com.ibm.ccl.soa.deploy.was.internal.validator.WasEndPointListenerConfigurationUnitValidator;

public class WasEndPointListenerConfigurationUnitValidatorTest extends
		TopologyTestCase {

	private static final String PROJECT_NAME = "WasEndPointListenerConfigurationUnitValidatorTest";
	private final String STANDARD_6_WASVERSION = "6.0.0.1";//$NON-NLS-1$	
	private Topology _top;
	private IDeployValidationContext _context;
	private IDeployReporter _reporter;

	/**
	 * 
	 */
	public WasEndPointListenerConfigurationUnitValidatorTest() {
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
	public void testWasEndPointListenerConfigurationUnitValidator()
			throws IOException, CoreException {

		_top = createTopology(PROJECT_NAME, true);
		_context = createValidationContext(_top);
		_reporter = createDeployReporter();

		WasEndpointListenerUnit endPointListenerUnit = (WasEndpointListenerUnit) ResolutionUtils
				.addFromTemplate(IWasTemplateConstants.WAS_ENDPOINT_LISTENER_UNIT, _top);
		endPointListenerUnit.getRequirements();

		endPointListenerUnit.getCapabilities();

		WasEndPointListenerConfigurationUnitValidator validator = new WasEndPointListenerConfigurationUnitValidator();

		ValidatorTestUtils.assertValidationErrorCount(1, _top,
				endPointListenerUnit, _context, _reporter, validator);

		WebsphereAppServerUnit serverUnit = (WebsphereAppServerUnit) ResolutionUtils
				.addFromTemplate(IWasTemplateConstants.WAS_6_APPLICATION_SERVER_UNIT, _top);

		ValidatorTestUtils.hosts(serverUnit, endPointListenerUnit);

		ValidatorTestUtils.assertValidationErrorCount(0, _top,
				endPointListenerUnit, _context, _reporter, validator);

		WasEndpointListenerConfiguration endpointListenerCap = (WasEndpointListenerConfiguration) ValidatorUtils
				.getCapability(endPointListenerUnit, WasPackage.eINSTANCE
						.getWasEndpointListenerConfiguration());

		endpointListenerCap.setUrlRoot("");
		endpointListenerCap.setWsdlUrlRoot("");

		ValidatorTestUtils.assertValidationErrorCount(4, _top,
				endPointListenerUnit, _context, _reporter, validator);

		endpointListenerCap.setUrlRoot("afa");
		endpointListenerCap.setWsdlUrlRoot("4324");

		ValidatorTestUtils.assertValidationErrorCount(2, _top,
				endPointListenerUnit, _context, _reporter, validator);

	}

}
