/*******************************************************************************
 * Copyright (c) 2003, 2007 IBM Corporation Licensed Material - Property of IBM. All rights reserved.
 *  
 * US Government Users Restricted Rights - Use, duplication or disclosure v1.0 restricted by GSA ADP
 * Schedule Contract with IBM Corp.
 * 
 * Contributors: IBM Corporation - initial API and implementation
 *******************************************************************************/
package com.ibm.ccl.soa.deploy.was.test;

import junit.framework.Test;
import junit.framework.TestSuite;

import com.ibm.ccl.soa.deploy.was.test.j2ee.validator.WasJNDIBindingConstraintValidatorTest;
import com.ibm.ccl.soa.deploy.was.test.j2ee.validator.WasJmsRealizationTest;
import com.ibm.ccl.soa.deploy.was.test.j2ee.validator.WasSecuritySubjectConstraintValidatorTest;
import com.ibm.ccl.soa.deploy.was.test.validator.DB2JdbcProviderUnitValidatorTest;
import com.ibm.ccl.soa.deploy.was.test.validator.WASDataSourceUnitValidatorTest;
import com.ibm.ccl.soa.deploy.was.test.validator.WasCellUnitValidatorTest;
import com.ibm.ccl.soa.deploy.was.test.validator.WasClusterUnitValidatorTest;
import com.ibm.ccl.soa.deploy.was.test.validator.WasDefaultMessagingQueueConnectionFactoryUnitValidatorTest;
import com.ibm.ccl.soa.deploy.was.test.validator.WasDefaultMessagingQueueDestinationUnitValidatorTest;
import com.ibm.ccl.soa.deploy.was.test.validator.WasDefaultMessagingTopicConnectionFactoryUnitValidatorTest;
import com.ibm.ccl.soa.deploy.was.test.validator.WasDefaultMessagingTopicDestinationUnitValidatorTest;
import com.ibm.ccl.soa.deploy.was.test.validator.WasDeploymentManagerUnitValidatorTest;
import com.ibm.ccl.soa.deploy.was.test.validator.WasEndPointListenerConfigurationUnitValidatorTest;
import com.ibm.ccl.soa.deploy.was.test.validator.WasJ2CAuthenticationUnitValidatorTest;
import com.ibm.ccl.soa.deploy.was.test.validator.WasJMSActivationSpecificationUnitValidatorTest;
import com.ibm.ccl.soa.deploy.was.test.validator.WasNodeGroupUnitValidatorTest;
import com.ibm.ccl.soa.deploy.was.test.validator.WasNodeUnitValidatorTest;
import com.ibm.ccl.soa.deploy.was.test.validator.WasSharedLibraryEntryUnitValidatorTest;
import com.ibm.ccl.soa.deploy.was.test.validator.WasSiBusUnitValidatorTest;
import com.ibm.ccl.soa.deploy.was.test.validator.WasSibDestinationUnitValidatorTest;
import com.ibm.ccl.soa.deploy.was.test.validator.WasSibInboundPortUnitValidatorTest;
import com.ibm.ccl.soa.deploy.was.test.validator.WasSibInboundServiceUnitValidatorTest;
import com.ibm.ccl.soa.deploy.was.test.validator.WasSibMediationValidatorTest;
import com.ibm.ccl.soa.deploy.was.test.validator.WasSibOutboundPortUnitValidatorTest;
import com.ibm.ccl.soa.deploy.was.test.validator.WasSibOutboundServiceUnitValidatorTest;
import com.ibm.ccl.soa.deploy.was.test.validator.WasSystemUnitValidatorTest;
import com.ibm.ccl.soa.deploy.was.test.validator.WebsphereAppServerUnitValidatorTest;

/**
 * @since 3.2 To be in the build add junit classes to this testsuite
 */
public class WebsphereTestSuite extends TestSuite {

	/**
	 * name of suite
	 * 
	 * @param name
	 */
	public WebsphereTestSuite(String name) {
		super(name);
	}

	/**
	 * defined junits
	 * 
	 * @return Test representing suite
	 */
	public static Test suite() {
		TestSuite suite = new WebsphereTestSuite(
				"Websphere deploy modeling tests");
		suite.addTestSuite(WasConstantsTest.class);
		suite.addTestSuite(PlantsByWebsphereTest.class);
		suite.addTestSuite(LinkEndpointValidationTest.class);
		suite.addTestSuite(WasJ2CAuthenticationUnitValidatorTest.class);
		suite.addTestSuite(DB2JdbcProviderUnitValidatorTest.class);
		suite.addTestSuite(WASDataSourceUnitValidatorTest.class);
		suite.addTestSuite(WebsphereAppServerUnitValidatorTest.class);
		suite.addTestSuite(WasSystemUnitValidatorTest.class);
		suite.addTestSuite(WasDeploymentManagerUnitValidatorTest.class);
		suite.addTestSuite(WasNodeUnitValidatorTest.class);
		suite.addTestSuite(WasCellUnitValidatorTest.class);
		suite.addTestSuite(WasNodeGroupUnitValidatorTest.class);
		suite.addTestSuite(WasClusterUnitValidatorTest.class);
		// suite.addTestSuite(WasSubstitutionVariableUnitValidatorTest.class);
		suite.addTestSuite(WasSharedLibraryEntryUnitValidatorTest.class);
		suite.addTestSuite(WasSibOutboundServiceUnitValidatorTest.class);
		suite.addTestSuite(WasSibInboundServiceUnitValidatorTest.class);
		suite.addTestSuite(WasSibDestinationUnitValidatorTest.class);
		suite.addTestSuite(WasSiBusUnitValidatorTest.class);
		suite.addTestSuite(WasSibMediationValidatorTest.class);
		suite.addTestSuite(WasSibOutboundPortUnitValidatorTest.class);
		suite.addTestSuite(WasSibInboundPortUnitValidatorTest.class);
		suite
				.addTestSuite(WasDefaultMessagingQueueDestinationUnitValidatorTest.class);
		suite
				.addTestSuite(WasDefaultMessagingTopicDestinationUnitValidatorTest.class);
		suite
				.addTestSuite(WasDefaultMessagingTopicConnectionFactoryUnitValidatorTest.class);
		suite
				.addTestSuite(WasDefaultMessagingQueueConnectionFactoryUnitValidatorTest.class);
		suite
				.addTestSuite(WasJMSActivationSpecificationUnitValidatorTest.class);
		suite
				.addTestSuite(WasEndPointListenerConfigurationUnitValidatorTest.class);
		suite.addTestSuite(WasSecuritySubjectConstraintValidatorTest.class);
		suite.addTestSuite(WasJNDIBindingConstraintValidatorTest.class);
		suite.addTestSuite(WasJmsRealizationTest.class);

		return suite;
	}
}
