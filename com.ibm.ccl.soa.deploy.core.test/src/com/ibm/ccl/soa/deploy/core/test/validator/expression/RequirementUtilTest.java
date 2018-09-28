/*******************************************************************************
 * Copyright (c) 2003, 2007 IBM Corporation Licensed Material - Property of IBM. All rights reserved.
 *  
 * US Government Users Restricted Rights - Use, duplication or disclosure v1.0 restricted by GSA ADP
 * Schedule Contract with IBM Corp.
 * 
 * Contributors: IBM Corporation - initial API and implementation
 *******************************************************************************/
package com.ibm.ccl.soa.deploy.core.test.validator.expression;

import java.math.BigInteger;

import org.eclipse.core.runtime.IStatus;

import com.ibm.ccl.soa.deploy.core.Capability;
import com.ibm.ccl.soa.deploy.core.CapabilityLinkTypes;
import com.ibm.ccl.soa.deploy.core.CommunicationCapability;
import com.ibm.ccl.soa.deploy.core.CoreFactory;
import com.ibm.ccl.soa.deploy.core.CorePackage;
import com.ibm.ccl.soa.deploy.core.Requirement;
import com.ibm.ccl.soa.deploy.core.RequirementExpression;
import com.ibm.ccl.soa.deploy.core.RequirementExpressionUsage;
import com.ibm.ccl.soa.deploy.core.RequirementLinkTypes;
import com.ibm.ccl.soa.deploy.core.Topology;
import com.ibm.ccl.soa.deploy.core.Unit;
import com.ibm.ccl.soa.deploy.core.test.TopologyTestCase;
import com.ibm.ccl.soa.deploy.core.validator.expression.Equals;
import com.ibm.ccl.soa.deploy.core.validator.expression.ReqEvaluationContext;
import com.ibm.ccl.soa.deploy.core.validator.expression.RequirementUtil;

public class RequirementUtilTest extends TopologyTestCase {

	public RequirementUtilTest() {
		super("RequirementUtilTest");
	}

	public void testCreateRequirement() throws Exception {
		Topology top = createTopology("testCreateRequirement", true);

		Unit u1 = CoreFactory.eINSTANCE.createUnit();
		u1.setName("u1");
		top.getUnits().add(u1);

		Capability cap = CoreFactory.eINSTANCE.createCapability();
		cap.setName("cap");
		cap.setLinkType(CapabilityLinkTypes.ANY_LITERAL);
		cap.setOrigin("test");
		u1.getCapabilities().add(cap);

		Requirement req = RequirementUtil.createRequirement(cap);
		assert req.getLinkType().equals(RequirementLinkTypes.HOSTING_LITERAL);
		assert req.getName().equals(cap.getName());
		assert ((RequirementExpression)req.getConstraint("origin")).getValue().equals(cap.getOrigin());
		assert req.getExpressions().size() == 1 : RequirementUtil.toString(req);
	}

	public void testValidate() throws Exception {
		Topology top = createTopology("testValidate", true);

		Unit u1 = CoreFactory.eINSTANCE.createUnit();
		u1.setName("u1");
		top.getUnits().add(u1);

		Capability cap = CoreFactory.eINSTANCE.createCapability();
		cap.setName("cap");
		cap.setLinkType(CapabilityLinkTypes.ANY_LITERAL);
		cap.setOrigin("test");
		u1.getCapabilities().add(cap);

		Requirement req = RequirementUtil.createRequirement(cap);
		ReqEvaluationContext ctx = new ReqEvaluationContext(cap);
		assert Equals.getInstance().validate(((RequirementExpression)req.getConstraint("origin")), ctx)
				.getSeverity() == IStatus.OK;

		IStatus status = RequirementUtil.validate(req, ctx);
		assert status.getSeverity() == IStatus.OK : status.getMessage();

		cap.setOrigin("test2");
		status = RequirementUtil.validate(req, ctx);
		assert status.getSeverity() == IStatus.ERROR : status.getMessage();

		cap.setOrigin("test");
		status = RequirementUtil.validate(req, ctx);
		assert status.getSeverity() == IStatus.OK : status.getMessage();

// TODO this test is broken atm.
// req.setHosting(!cap.isHosting());
// status = RequirementUtil.validate(req, cap);
// assert status.getSeverity() == IStatus.ERROR : status.getMessage();

		// This test is now pointless.
		if (cap.getLinkType().equals(CapabilityLinkTypes.HOSTING_LITERAL)
				|| cap.getLinkType().equals(CapabilityLinkTypes.ANY_LITERAL)) {
			req.setLinkType(RequirementLinkTypes.HOSTING_LITERAL);
		} else {
			req.setLinkType(RequirementLinkTypes.DEPENDENCY_LITERAL);
		}

		status = RequirementUtil.validate(req, ctx);
		assert status.getSeverity() == IStatus.OK : status.getMessage();
	}

	/**
	 * Tests requirement expression validation.
	 * {@link RequirementUtil#validateRequirementExpression (RequirementExpression, ReqEvaluationContext, boolean)}.
	 */
	public void testRequirementExpressionValidation() throws Exception {
		Topology top = createTopology("testRequirementExpressionValidation",
				true);

		RequirementExpression expr = CoreFactory.eINSTANCE
				.createRequirementExpression();
		expr.setName("re0");
		expr.setUse(RequirementExpressionUsage.REQUIRED_LITERAL);
		expr.setInterpreter(Equals.INTERPRETER_ID);
		expr.setAttributeName("port");
		expr.setValue("100");

		Unit unit = addUnit(top, "unit");

		// ---- test 1 ------
		CommunicationCapability cap1 = (CommunicationCapability) addCapability(
				unit, "cap1", CorePackage.eINSTANCE
						.getCommunicationCapability(),
				CapabilityLinkTypes.DEPENDENCY_LITERAL);
		ReqEvaluationContext context = new ReqEvaluationContext(cap1);
		unit.setConceptual(true);
		assert RequirementUtil.validateRequirementExpression(expr, context,
				true).getSeverity() == IStatus.OK;
		assert RequirementUtil.validateRequirementExpression(expr, context,
				false).getSeverity() == IStatus.OK;

		// ---- test 2 ------
		unit.setConceptual(false);
		assert RequirementUtil.validateRequirementExpression(expr, context,
				true).getSeverity() == IStatus.ERROR;
		assert RequirementUtil.validateRequirementExpression(expr, context,
				false).getSeverity() == IStatus.ERROR;

		// ---- test 3 ------
		cap1.setPort(new BigInteger("80"));
		unit.setConceptual(true);
		assert RequirementUtil.validateRequirementExpression(expr, context,
				true).getSeverity() == IStatus.ERROR;
		assert RequirementUtil.validateRequirementExpression(expr, context,
				false).getSeverity() == IStatus.ERROR;

		// ---- test 4 ------
		unit.setConceptual(false);
		assert RequirementUtil.validateRequirementExpression(expr, context,
				true).getSeverity() == IStatus.ERROR;
		assert RequirementUtil.validateRequirementExpression(expr, context,
				false).getSeverity() == IStatus.ERROR;

		// ---- test 5 ------
		cap1.setPort(new BigInteger("100"));
		unit.setConceptual(true);
		assert RequirementUtil.validateRequirementExpression(expr, context,
				true).getSeverity() == IStatus.OK;
		assert RequirementUtil.validateRequirementExpression(expr, context,
				false).getSeverity() == IStatus.OK;

		// ---- test 6 ------
		cap1.setPort(new BigInteger("100"));
		unit.setConceptual(false);
		assert RequirementUtil.validateRequirementExpression(expr, context,
				true).getSeverity() == IStatus.OK;
		assert RequirementUtil.validateRequirementExpression(expr, context,
				false).getSeverity() == IStatus.OK;

		// ---- test 7 ------
		Capability cap2 = addCapability(unit, "cap2", CorePackage.eINSTANCE
				.getCapability(), CapabilityLinkTypes.DEPENDENCY_LITERAL);
		context = new ReqEvaluationContext(cap2);
		unit.setConceptual(true);
		assert RequirementUtil.validateRequirementExpression(expr, context,
				true).getSeverity() == IStatus.OK;
		assert RequirementUtil.validateRequirementExpression(expr, context,
				false).getSeverity() == IStatus.ERROR;

		// ---- test 8 ------
		unit.setConceptual(false);
		assert RequirementUtil.validateRequirementExpression(expr, context,
				true).getSeverity() == IStatus.ERROR;
		assert RequirementUtil.validateRequirementExpression(expr, context,
				false).getSeverity() == IStatus.ERROR;
	}
}
