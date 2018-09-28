/*******************************************************************************
 * Copyright (c) 2003, 2007 IBM Corporation Licensed Material - Property of IBM. All rights reserved.
 *  
 * US Government Users Restricted Rights - Use, duplication or disclosure v1.0 restricted by GSA ADP
 * Schedule Contract with IBM Corp.
 * 
 * Contributors: IBM Corporation - initial API and implementation
 *******************************************************************************/
package com.ibm.ccl.soa.deploy.tests.core.validator.matcher;

import com.ibm.ccl.soa.deploy.core.AttributeMetaData;
import com.ibm.ccl.soa.deploy.core.CapabilityLinkTypes;
import com.ibm.ccl.soa.deploy.core.CoreFactory;
import com.ibm.ccl.soa.deploy.core.Requirement;
import com.ibm.ccl.soa.deploy.core.RequirementExpression;
import com.ibm.ccl.soa.deploy.core.RequirementLinkTypes;
import com.ibm.ccl.soa.deploy.core.Topology;
import com.ibm.ccl.soa.deploy.core.test.TopologyTestCase;
import com.ibm.ccl.soa.deploy.core.test.validator.utils.ValidatorTestUtils;
import com.ibm.ccl.soa.deploy.core.validator.DeployValidatorService;
import com.ibm.ccl.soa.deploy.core.validator.DomainValidator;
import com.ibm.ccl.soa.deploy.core.validator.expression.Equals;
import com.ibm.ccl.soa.deploy.core.validator.matcher.LinkType;
import com.ibm.ccl.soa.deploy.internal.core.validator.CoreDomainValidator;
import com.ibm.ccl.soa.deploy.was.WasFactory;
import com.ibm.ccl.soa.deploy.was.WasNode;
import com.ibm.ccl.soa.deploy.was.WasNodeUnit;
import com.ibm.ccl.soa.deploy.was.WasPackage;
import com.ibm.ccl.soa.deploy.was.WasProfileTypeEnum;
import com.ibm.ccl.soa.deploy.was.WasSystem;
import com.ibm.ccl.soa.deploy.was.WasSystemUnit;

public class HostingLinkTest extends TopologyTestCase {

	public static final String PROJECT_NAME = HostingLinkTest.class.getName();

	private static final DeployValidatorService dvs = DeployValidatorService.getDefaultValidatorService();
	DomainValidator validator = new CoreDomainValidator();

	public HostingLinkTest() {
		super(PROJECT_NAME);
	}

	public void testRequirementExpressionEvaluation() throws Exception {
		Topology top = createTopology("testRequirementExpressionEvaluation");

		// test 1) was node unit with was system requirement can be hosted on
		// was system unit ith was system capability
		WasNodeUnit nodeUnit = WasFactory.eINSTANCE.createWasNodeUnit();
		nodeUnit.setName("wasNodeUnit");
		top.getUnits().add(nodeUnit);
		Requirement wasSystemReq = addRequirement(nodeUnit, "wasSystem",
				WasPackage.Literals.WAS_SYSTEM,
				RequirementLinkTypes.HOSTING_LITERAL);
		// the rest of these are just to reduce the errors in the model
		WasNode node = (WasNode) addCapability(nodeUnit, "wasNode",
				WasPackage.Literals.WAS_NODE, CapabilityLinkTypes.ANY_LITERAL);
		node.setNodeName("node01");
		node.setProfileType(WasProfileTypeEnum.DEFAULT_LITERAL);
		node.setProfileLocation("C:/profile");
		node.setProfileName("profile01");
		node.setWasVersion("6.0");
		addCapability(nodeUnit, "wasSubst",
				WasPackage.Literals.WAS_SUBSTITUTION_VARIABLE,
				CapabilityLinkTypes.ANY_LITERAL);
		addCapability(nodeUnit, "wasConfig",
				WasPackage.Literals.WAS_CONFIGURATION_CONTAINER,
				CapabilityLinkTypes.ANY_LITERAL);
		addCapability(nodeUnit, "wasSL",
				WasPackage.Literals.WAS_SHARED_LIB_CONTAINER,
				CapabilityLinkTypes.ANY_LITERAL);

		WasSystemUnit systemUnit = WasFactory.eINSTANCE.createWasSystemUnit();
		systemUnit.setName("wasSystemUnit");
		WasSystem system = (WasSystem) addCapability(systemUnit,
				"wasSystemCapability", WasPackage.Literals.WAS_SYSTEM,
				CapabilityLinkTypes.ANY_LITERAL);
		system.setWasVersion("6.1");

		assert dvs.canCreateLink(systemUnit, nodeUnit, LinkType.HOSTING_SET)
				.isOK();
		dvs.validate(top);
		dumpStatus(top);
		// there should be two errors left
		assert 2 == ValidatorTestUtils.getTopologyErrorCount(top);

		// test 2) we add a requirement expression that wasVersion must be 6.0
		// test 2a) target wasVersion matches
		setRequirementExpression(wasSystemReq, Equals.INTERPRETER_ID,
				WasPackage.Literals.WAS_SYSTEM__WAS_VERSION.getName(), "6.1");

		assert dvs.canCreateLink(systemUnit, nodeUnit, LinkType.HOSTING_SET)
				.isOK();
		dvs.validate(top);
		dumpStatus(top);
		assert 2 == ValidatorTestUtils.getTopologyErrorCount(top);

		// test 2b) target wasVerseion does not match and all target is mutable
		setRequirementExpression(wasSystemReq, Equals.INTERPRETER_ID,
				WasPackage.Literals.WAS_SYSTEM__WAS_VERSION.getName(), "6.0");
		systemUnit.setMutable(true);

		assert dvs.canCreateLink(systemUnit, nodeUnit, LinkType.HOSTING_SET)
				.isOK();
		dvs.validate(top);
		dumpStatus(top);
		assert 2 == ValidatorTestUtils.getTopologyErrorCount(top);

		// test 2c) target wasVersion does not match and target capability is
		// immutable
		setRequirementExpression(wasSystemReq, Equals.INTERPRETER_ID,
				WasPackage.Literals.WAS_SYSTEM__WAS_VERSION.getName(), "6.0");
		systemUnit.setMutable(true);
		system.setMutable(false);

		assert !dvs.canCreateLink(systemUnit, nodeUnit, LinkType.HOSTING_SET)
				.isOK();
		dvs.validate(top);
		dumpStatus(top);
		assert 2 == ValidatorTestUtils.getTopologyErrorCount(top);

		// test 2d) target wasVersion does not match and target attribute is
		// immutable
		setRequirementExpression(wasSystemReq, Equals.INTERPRETER_ID,
				WasPackage.Literals.WAS_SYSTEM__WAS_VERSION.getName(), "6.0");
		systemUnit.setMutable(true);
		system.setMutable(true);
		AttributeMetaData md = CoreFactory.eINSTANCE.createAttributeMetaData();
		md.setAttributeName(WasPackage.Literals.WAS_SYSTEM__WAS_VERSION
				.getName());
		md.setMutable(false);
		system.getAttributeMetaData().add(md);

		assert !dvs.canCreateLink(systemUnit, nodeUnit, LinkType.HOSTING_SET)
				.isOK();
		dvs.validate(top);
		dumpStatus(top);
		assert 2 == ValidatorTestUtils.getTopologyErrorCount(top);

		// test 2e) target wasVersion does not match and target attribute is
		// mutable
		setRequirementExpression(wasSystemReq, Equals.INTERPRETER_ID,
				WasPackage.Literals.WAS_SYSTEM__WAS_VERSION.getName(), "6.0");
		systemUnit.setMutable(true);
		system.setMutable(true);
		md.setMutable(true);

		assert dvs.canCreateLink(systemUnit, nodeUnit, LinkType.HOSTING_SET)
				.isOK();
		dvs.validate(top);
		dumpStatus(top);
		assert 2 == ValidatorTestUtils.getTopologyErrorCount(top);

		// test 2f) target wasVersion does match and target attribute is
		// immutable
		setRequirementExpression(wasSystemReq, Equals.INTERPRETER_ID,
				WasPackage.Literals.WAS_SYSTEM__WAS_VERSION.getName(), "6.1");
		systemUnit.setMutable(true);
		system.setMutable(true);
		md.setMutable(false);

		assert dvs.canCreateLink(systemUnit, nodeUnit, LinkType.HOSTING_SET)
				.isOK();
		dvs.validate(top);
		dumpStatus(top);
		assert 2 == ValidatorTestUtils.getTopologyErrorCount(top);
	}

	private void setRequirementExpression(Requirement req, String interpreter,
			String attributeName, String value) {
		req.getExpressions().clear();
		RequirementExpression expr = CoreFactory.eINSTANCE
				.createRequirementExpression();
		expr.setName("reqExpr");
		expr.setInterpreter(interpreter);
		expr.setAttributeName(attributeName);
		expr.setValue(value);
		req.getExpressions().add(expr);
		System.out.println(attributeName + " ::: " + interpreter + " ::: "
				+ value);
	}
}
