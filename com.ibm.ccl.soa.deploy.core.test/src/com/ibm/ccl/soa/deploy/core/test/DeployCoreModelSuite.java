/*******************************************************************************
 * Copyright (c) 2003, 2007 IBM Corporation Licensed Material - Property of IBM. All rights reserved.
 *  
 * US Government Users Restricted Rights - Use, duplication or disclosure v1.0 restricted by GSA ADP
 * Schedule Contract with IBM Corp.
 * 
 * Contributors: IBM Corporation - initial API and implementation
 *******************************************************************************/
package com.ibm.ccl.soa.deploy.core.test;

import junit.framework.Test;
import junit.framework.TestSuite;

import com.ibm.ccl.soa.deploy.core.datamodels.tests.CreateTopologyDataModelTests;
import com.ibm.ccl.soa.deploy.core.datamodels.tests.DeployTopologyExportDataModelTests;
import com.ibm.ccl.soa.deploy.core.datamodels.tests.ImplementationDatamodelTests;
import com.ibm.ccl.soa.deploy.core.datamodels.tests.ImportToTopologyDatamodelTests;
import com.ibm.ccl.soa.deploy.core.test.extension.ResolutionManagerTest;
import com.ibm.ccl.soa.deploy.core.test.imports.ChangeScopeTests;
import com.ibm.ccl.soa.deploy.core.test.imports.ExplicitContractTests;
import com.ibm.ccl.soa.deploy.core.test.imports.GlobalPropertyTests;
import com.ibm.ccl.soa.deploy.core.test.imports.ModelProxyResolutionTests;
import com.ibm.ccl.soa.deploy.core.test.imports.NullContractTests;
import com.ibm.ccl.soa.deploy.core.test.imports.ProxyResolutionTests;
import com.ibm.ccl.soa.deploy.core.test.imports.TopologyImportValidationTest;
import com.ibm.ccl.soa.deploy.core.test.provider.discovery.CurrentTopologyDiscovererTest;
import com.ibm.ccl.soa.deploy.core.test.provider.discovery.DiscoveryTest;
import com.ibm.ccl.soa.deploy.core.test.topologyimport.RealizationLinkApiTest;
import com.ibm.ccl.soa.deploy.core.test.validator.ChangeManagementValidationTests;
import com.ibm.ccl.soa.deploy.core.test.validator.ContractsSeverityOverrideTest;
import com.ibm.ccl.soa.deploy.core.test.validator.CoreDomainValidatorTest;
import com.ibm.ccl.soa.deploy.core.test.validator.DeployAttributeValidatorTest;
import com.ibm.ccl.soa.deploy.core.test.validator.DeployCoreMessageFactoryTest;
import com.ibm.ccl.soa.deploy.core.test.validator.DeployCoreValidatorMarkerTest;
import com.ibm.ccl.soa.deploy.core.test.validator.DeployPublishStatusTest;
import com.ibm.ccl.soa.deploy.core.test.validator.DeployStatusTest;
import com.ibm.ccl.soa.deploy.core.test.validator.DomainValidatorServiceTest;
import com.ibm.ccl.soa.deploy.core.test.validator.FilteredListTest;
import com.ibm.ccl.soa.deploy.core.test.validator.ICoreProblemTypeTest;
import com.ibm.ccl.soa.deploy.core.test.validator.InstanceConfigurationValidatorTest;
import com.ibm.ccl.soa.deploy.core.test.validator.RealizationValidationTest;
import com.ibm.ccl.soa.deploy.core.test.validator.StatusIteratorTest;
import com.ibm.ccl.soa.deploy.core.test.validator.UnitValidatorTest;
import com.ibm.ccl.soa.deploy.core.test.validator.ValidatorUtilsTest;
import com.ibm.ccl.soa.deploy.core.test.validator.WormholeFarmTest;
import com.ibm.ccl.soa.deploy.core.test.validator.WormholeTest;
import com.ibm.ccl.soa.deploy.core.test.validator.constraints.AttributeConstraintSolverServiceTest;
import com.ibm.ccl.soa.deploy.core.test.validator.constraints.AttributeConstraintTest;
import com.ibm.ccl.soa.deploy.core.test.validator.constraints.AttributePropagationConstraintTest;
import com.ibm.ccl.soa.deploy.core.test.validator.constraints.BooleanConstraintTest;
import com.ibm.ccl.soa.deploy.core.test.validator.constraints.ConstraintServiceTest;
import com.ibm.ccl.soa.deploy.core.test.validator.constraints.ConstraintsOnRequirementsTest;
import com.ibm.ccl.soa.deploy.core.test.validator.constraints.EnumerationConstraintTest;
import com.ibm.ccl.soa.deploy.core.test.validator.constraints.EqualsConstraintTest;
import com.ibm.ccl.soa.deploy.core.test.validator.constraints.ExclusionConstraintTest;
import com.ibm.ccl.soa.deploy.core.test.validator.constraints.LinkConstraintTest;
import com.ibm.ccl.soa.deploy.core.test.validator.constraints.MemberGroupCardinalityTest;
import com.ibm.ccl.soa.deploy.core.test.validator.constraints.RangeConstraintTest;
import com.ibm.ccl.soa.deploy.core.test.validator.constraints.VersionConstraintTest;
import com.ibm.ccl.soa.deploy.core.test.validator.expression.EqualsTest;
import com.ibm.ccl.soa.deploy.core.test.validator.expression.RequirementUtilTest;
import com.ibm.ccl.soa.deploy.core.test.validator.expression.VersionTest;
import com.ibm.ccl.soa.deploy.core.test.validator.matcher.ConstraintsOnRequirementsMatcherTest;
import com.ibm.ccl.soa.deploy.core.test.validator.matcher.CoreMatcherServiceTest;
import com.ibm.ccl.soa.deploy.core.test.validator.matcher.ImplicitLinksTest;
import com.ibm.ccl.soa.deploy.core.test.validator.matcher.InternalMatcherTest;
import com.ibm.ccl.soa.deploy.core.test.validator.matcher.LinkDescriptorTest;
import com.ibm.ccl.soa.deploy.core.test.validator.matcher.MatcherTest;
import com.ibm.ccl.soa.deploy.core.test.validator.matcher.MatcherUtilsTest;
import com.ibm.ccl.soa.deploy.core.test.validator.matcher.RealizationMatcherExtTest;
import com.ibm.ccl.soa.deploy.core.test.validator.matcher.RealizationMatcherTest;
import com.ibm.ccl.soa.deploy.core.test.validator.matcher.RealizationUtilTest;
import com.ibm.ccl.soa.deploy.core.test.validator.pattern.ProvidedToProvidedAttributeValidatorTest;
import com.ibm.ccl.soa.deploy.core.test.validator.resolution.DeployObjectPropertyTesterTest;
import com.ibm.ccl.soa.deploy.core.test.validator.resolution.DeployStatusPropertyTesterTest;
import com.ibm.ccl.soa.deploy.core.test.validator.resolution.RandomNameResolutionGeneratorTest;
import com.ibm.ccl.soa.deploy.core.test.validator.resolution.param.DeployParameterizedResolutionTest;

public class DeployCoreModelSuite extends TestSuite {

	public DeployCoreModelSuite() {
		super();
	}

	public DeployCoreModelSuite(String name) {
		super(name);
	}

	public static Test suite() {
		TestSuite suite = new DeployCoreModelSuite(
				"SOA Deploy Core Model test suite.");
		suite.addTestSuite(AttributeMetadataTest.class);
		suite.addTestSuite(ContainedObjectTest.class);
		suite.addTestSuite(DeployCoreModelTest.class);
		suite.addTestSuite(DeployCoreConstantsTest.class);
		suite.addTestSuite(DeployModelObjectUtilTest.class);
		suite.addTestSuite(DmoPathTest.class);
		suite.addTestSuite(RequirementTest.class);
		suite.addTestSuite(DeployManualOperationsTest.class);
		suite.addTestSuite(TopologyNamespaceTest.class);
		suite.addTestSuite(StereotypeTest.class);

		// Discoverer tests
		suite.addTestSuite(CurrentTopologyDiscovererTest.class);
		suite.addTestSuite(DiscoveryTest.class);

		// Matcher tests
		suite.addTestSuite(CoreMatcherServiceTest.class);
		suite.addTestSuite(LinkDescriptorTest.class);
		suite.addTestSuite(MatcherUtilsTest.class);
		suite.addTestSuite(MatcherTest.class); // Added ECS 7/17/06
		suite.addTestSuite(InternalMatcherTest.class);
		suite.addTestSuite(RealizationMatcherTest.class);
		suite.addTestSuite(RealizationMatcherExtTest.class);
		suite.addTestSuite(RealizationUtilTest.class);
		suite.addTestSuite(RealizationLinkApiTest.class);
		suite.addTestSuite(ConstraintsOnRequirementsMatcherTest.class);
		suite.addTestSuite(ImplicitLinksTest.class);

		// Validation tests
		suite.addTestSuite(ChangeManagementValidationTests.class);
		suite.addTestSuite(CoreDomainValidatorTest.class);
		suite.addTestSuite(ContractsSeverityOverrideTest.class);
		suite.addTestSuite(DeployCoreMessageFactoryTest.class);
		suite.addTestSuite(DeployCoreValidatorMarkerTest.class);
		suite.addTestSuite(DeployPublishStatusTest.class);
		suite.addTestSuite(DeployStatusTest.class);
		suite.addTestSuite(DomainValidatorServiceTest.class);
		suite.addTestSuite(FilteredListTest.class);
		suite.addTestSuite(ICoreProblemTypeTest.class);
		suite.addTestSuite(StatusIteratorTest.class);
		suite.addTestSuite(UnitValidatorTest.class);
		suite.addTestSuite(ValidatorUtilsTest.class);
		suite.addTestSuite(WormholeTest.class);
		suite.addTestSuite(WormholeFarmTest.class);
		suite.addTestSuite(RealizationValidationTest.class);
		suite.addTestSuite(InstanceConfigurationValidatorTest.class);

		// Parameterized resolutions
		suite.addTestSuite(DeployParameterizedResolutionTest.class);

		// Validation pattern tests
		suite.addTestSuite(DeployAttributeValidatorTest.class);
		suite.addTestSuite(ProvidedToProvidedAttributeValidatorTest.class);

		// Validation expression tests
		suite.addTestSuite(EqualsTest.class);
		suite.addTestSuite(RequirementUtilTest.class);
		suite.addTestSuite(VersionTest.class);

		// Validation resolution tests
		suite.addTestSuite(DeployObjectPropertyTesterTest.class);
		suite.addTestSuite(DeployStatusPropertyTesterTest.class);
		suite.addTestSuite(ResolutionManagerTest.class);
		suite.addTestSuite(RandomNameResolutionGeneratorTest.class);

		// datamodel tests
		// suite.addTestSuite(CommunicationConstraintDataModelTests.class);
		suite.addTestSuite(CreateTopologyDataModelTests.class);
		suite.addTestSuite(DeployTopologyExportDataModelTests.class);
		suite.addTestSuite(ImplementationDatamodelTests.class);
		suite.addTestSuite(ImportToTopologyDatamodelTests.class);

		// Proxy tests
		suite.addTest(ProxyResolutionTests.suite());
		suite.addTest(ModelProxyResolutionTests.suite());
		suite.addTestSuite(TopologyImportValidationTest.class);

		// Contract tests
		suite.addTestSuite(ChangeScopeTests.class);
		suite.addTestSuite(ExplicitContractTests.class);
		suite.addTestSuite(GlobalPropertyTests.class);
		suite.addTestSuite(NullContractTests.class);

		// Constraint tests
		suite.addTestSuite(AttributeConstraintSolverServiceTest.class);
		suite.addTestSuite(AttributeConstraintTest.class);
		suite.addTestSuite(AttributePropagationConstraintTest.class);
		suite.addTestSuite(BooleanConstraintTest.class);
		suite.addTestSuite(EnumerationConstraintTest.class);
		suite.addTestSuite(ExclusionConstraintTest.class);
		suite.addTestSuite(LinkConstraintTest.class);
		suite.addTestSuite(RangeConstraintTest.class);
		suite.addTestSuite(VersionConstraintTest.class);
		suite.addTestSuite(EqualsConstraintTest.class);
		suite.addTestSuite(MemberGroupCardinalityTest.class);
		suite.addTestSuite(ConstraintServiceTest.class);
		suite.addTestSuite(ConstraintsOnRequirementsTest.class);
		
		
		return suite;
	}

}
