/*******************************************************************************
 * Copyright (c) 2003, 2007 IBM Corporation Licensed Material - Property of IBM. All rights reserved.
 *  
 * US Government Users Restricted Rights - Use, duplication or disclosure v1.0 restricted by GSA ADP
 * Schedule Contract with IBM Corp.
 * 
 * Contributors: IBM Corporation - initial API and implementation
 *******************************************************************************/
package com.ibm.ccl.soa.deploy.core.test.validator.expression;

import java.io.IOException;

import junit.framework.Assert;

import org.eclipse.core.runtime.IStatus;
import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.util.EcoreUtil;

import com.ibm.ccl.soa.deploy.core.Capability;
import com.ibm.ccl.soa.deploy.core.CapabilityLinkTypes;
import com.ibm.ccl.soa.deploy.core.CoreFactory;
import com.ibm.ccl.soa.deploy.core.CorePackage;
import com.ibm.ccl.soa.deploy.core.Requirement;
import com.ibm.ccl.soa.deploy.core.RequirementExpression;
import com.ibm.ccl.soa.deploy.core.Topology;
import com.ibm.ccl.soa.deploy.core.Unit;
import com.ibm.ccl.soa.deploy.core.test.TopologyTestCase;
import com.ibm.ccl.soa.deploy.core.validator.expression.GreaterThan;
import com.ibm.ccl.soa.deploy.core.validator.expression.GreaterThanEquals;
import com.ibm.ccl.soa.deploy.core.validator.expression.LessThan;
import com.ibm.ccl.soa.deploy.core.validator.expression.LessThanEquals;
import com.ibm.ccl.soa.deploy.core.validator.expression.ReqEvaluationContext;
import com.ibm.ccl.soa.deploy.core.validator.expression.RequirementExpressionInterpreter2;
import com.ibm.ccl.soa.deploy.core.validator.expression.RequirementUtil;
import com.ibm.ccl.soa.deploy.core.validator.status.IDeployStatus;

/**
 * Test operators other than Equal
 * 
 * @author Ed Snible
 * 
 * @see LessThan
 * @see LessThanEquals
 * @see GreaterThan
 * @see GreaterThanEquals
 * 
 * TODO Add this to master test
 */
public class OperatorTest extends TopologyTestCase {

	public OperatorTest() {
		super("OperatorTest");
	}

	public void testReqUtilStringComparison() throws Exception {
		checkValidRU(GreaterThanEquals.INTERPRETER_ID, CorePackage.eINSTANCE
				.getCapability_Origin(), null, null);
		checkInvalidRU(GreaterThanEquals.INTERPRETER_ID, CorePackage.eINSTANCE
				.getCapability_Origin(), null, "3");
		checkInvalidRU(GreaterThanEquals.INTERPRETER_ID, CorePackage.eINSTANCE
				.getCapability_Origin(), "3", null);
		checkValidRU(GreaterThanEquals.INTERPRETER_ID, CorePackage.eINSTANCE
				.getCapability_Origin(), "3", "3");
		checkValidRU(GreaterThanEquals.INTERPRETER_ID, CorePackage.eINSTANCE
				.getCapability_Origin(), "Apple", "Apple");
		checkValidRU(GreaterThanEquals.INTERPRETER_ID, CorePackage.eINSTANCE
				.getCapability_Origin(), "Banana", "Apple");
		checkInvalidRU(GreaterThanEquals.INTERPRETER_ID, CorePackage.eINSTANCE
				.getCapability_Origin(), "Apple", "Banana");

		// TODO GT, LTE, LT, NOT
	}

	public void testStringComparison() throws Exception {

		// Check >= String comparison
		checkValid(GreaterThanEquals.getInstance(), CorePackage.eINSTANCE
				.getCapability_Origin(), null, null);
		checkInvalid(GreaterThanEquals.getInstance(), CorePackage.eINSTANCE
				.getCapability_Origin(), null, "3");
		checkInvalid(GreaterThanEquals.getInstance(), CorePackage.eINSTANCE
				.getCapability_Origin(), "3", null);
		checkValid(GreaterThanEquals.getInstance(), CorePackage.eINSTANCE
				.getCapability_Origin(), "3", "3");
		checkValid(GreaterThanEquals.getInstance(), CorePackage.eINSTANCE
				.getCapability_Origin(), "Apple", "Apple");
		checkValid(GreaterThanEquals.getInstance(), CorePackage.eINSTANCE
				.getCapability_Origin(), "Banana", "Apple");
		checkInvalid(GreaterThanEquals.getInstance(), CorePackage.eINSTANCE
				.getCapability_Origin(), "Apple", "Banana");

		// Check <= String comparison
		checkValid(LessThanEquals.getInstance(), CorePackage.eINSTANCE
				.getCapability_Origin(), null, null);
		checkInvalid(LessThanEquals.getInstance(), CorePackage.eINSTANCE
				.getCapability_Origin(), null, "3");
		checkInvalid(LessThanEquals.getInstance(), CorePackage.eINSTANCE
				.getCapability_Origin(), "3", null);
		checkValid(LessThanEquals.getInstance(), CorePackage.eINSTANCE
				.getCapability_Origin(), "3", "3");
		checkValid(LessThanEquals.getInstance(), CorePackage.eINSTANCE
				.getCapability_Origin(), "Apple", "Apple");
		checkInvalid(LessThanEquals.getInstance(), CorePackage.eINSTANCE
				.getCapability_Origin(), "Banana", "Apple");
		checkValid(LessThanEquals.getInstance(), CorePackage.eINSTANCE
				.getCapability_Origin(), "Apple", "Banana");

		// Check > String comparison
		checkInvalid(GreaterThan.getInstance(), CorePackage.eINSTANCE
				.getCapability_Origin(), null, null);
		checkInvalid(GreaterThan.getInstance(), CorePackage.eINSTANCE
				.getCapability_Origin(), null, "3");
		checkInvalid(GreaterThan.getInstance(), CorePackage.eINSTANCE
				.getCapability_Origin(), "3", null);
		checkInvalid(GreaterThan.getInstance(), CorePackage.eINSTANCE
				.getCapability_Origin(), "3", "3");
		checkInvalid(GreaterThan.getInstance(), CorePackage.eINSTANCE
				.getCapability_Origin(), "Apple", "Apple");
		checkValid(GreaterThan.getInstance(), CorePackage.eINSTANCE
				.getCapability_Origin(), "Banana", "Apple");
		checkInvalid(GreaterThan.getInstance(), CorePackage.eINSTANCE
				.getCapability_Origin(), "Apple", "Banana");

		// Check < String comparison
		checkInvalid(LessThan.getInstance(), CorePackage.eINSTANCE
				.getCapability_Origin(), null, null);
		checkInvalid(LessThan.getInstance(), CorePackage.eINSTANCE
				.getCapability_Origin(), null, "3");
		checkInvalid(LessThan.getInstance(), CorePackage.eINSTANCE
				.getCapability_Origin(), "3", null);
		checkInvalid(LessThan.getInstance(), CorePackage.eINSTANCE
				.getCapability_Origin(), "3", "3");
		checkInvalid(LessThan.getInstance(), CorePackage.eINSTANCE
				.getCapability_Origin(), "Apple", "Apple");
		checkInvalid(LessThan.getInstance(), CorePackage.eINSTANCE
				.getCapability_Origin(), "Banana", "Apple");
		checkValid(LessThan.getInstance(), CorePackage.eINSTANCE
				.getCapability_Origin(), "Apple", "Banana");

		// TODO GT, LT, NE
	}

// public void testBigIntegerComparison() throws Exception {
// // TODO We can't test integer requirement expressions in core.test because
// // no capabilities in core expose integer-type properties!!!
//		
// checkValid(GreaterThanEquals.getInstance(),
// ServerPackage.eINSTANCE.getServer_CpuCount(), null, null);
// checkInvalid(GreaterThanEquals.getInstance(),
// ServerPackage.eINSTANCE.getServer_CpuCount(), null, new BigInteger("3"));
// checkInvalid(GreaterThanEquals.getInstance(),
// ServerPackage.eINSTANCE.getServer_CpuCount(), new BigInteger("3"), null);
// checkValid(GreaterThanEquals.getInstance(),
// ServerPackage.eINSTANCE.getServer_CpuCount(), new BigInteger("3"), new
// BigInteger("3"));
// checkValid(GreaterThanEquals.getInstance(),
// ServerPackage.eINSTANCE.getServer_CpuCount(), new BigInteger("-3"), new
// BigInteger("-3"));
// checkValid(GreaterThanEquals.getInstance(),
// ServerPackage.eINSTANCE.getServer_CpuCount(), new BigInteger("03"), new
// BigInteger("3"));
// checkValid(GreaterThanEquals.getInstance(),
// ServerPackage.eINSTANCE.getServer_CpuCount(), new BigInteger("3"), new
// BigInteger("03"));
//		
// // TODO GT, LTE, LT, NE
// }

	public void testEnumeratorComparison() throws Exception {
		// We can't test null OP null, null OP constant, or constant OP null
		// because
		// the generated EMF setters will not allow setting the value to null --
		// they
		// set to a default value. So we can't reliably get null into the
		// capability.
		checkValid(GreaterThanEquals.getInstance(), CorePackage.eINSTANCE
				.getCapability_LinkType(), CapabilityLinkTypes.HOSTING_LITERAL,
				CapabilityLinkTypes.HOSTING_LITERAL);

		checkValid(LessThanEquals.getInstance(), CorePackage.eINSTANCE
				.getCapability_LinkType(), CapabilityLinkTypes.HOSTING_LITERAL,
				CapabilityLinkTypes.HOSTING_LITERAL);

		checkInvalid(GreaterThan.getInstance(), CorePackage.eINSTANCE
				.getCapability_LinkType(), CapabilityLinkTypes.HOSTING_LITERAL,
				CapabilityLinkTypes.HOSTING_LITERAL);

		checkInvalid(LessThan.getInstance(), CorePackage.eINSTANCE
				.getCapability_LinkType(), CapabilityLinkTypes.HOSTING_LITERAL,
				CapabilityLinkTypes.HOSTING_LITERAL);
	}

	private Capability buildCap(Topology top, EAttribute attrib, Object lvalue) {

		Unit unit2 = CoreFactory.eINSTANCE.createUnit();
		unit2.setName("unit2");
		top.getUnits().add(unit2);

// Capability cap = CoreFactory.eINSTANCE.createCapability();
		EClass ecCap = attrib.getEContainingClass();
		Capability cap = (Capability) ecCap.getEPackage().getEFactoryInstance()
				.create(ecCap);
		cap.setName("cap");
		cap.eSet(attrib, lvalue);
		unit2.getCapabilities().add(cap);

		return cap;
	}

	private RequirementExpression buildExpression(Topology top,
			EAttribute attrib, String interp, String rvalue) {
		Unit unit1 = CoreFactory.eINSTANCE.createUnit();
		unit1.setName("unit1");
		top.getUnits().add(unit1);

		// Origin is a String
		Requirement req = CoreFactory.eINSTANCE.createRequirement();
		req.setName("req");
		RequirementExpression re = CoreFactory.eINSTANCE
				.createRequirementExpression();
		re.setAttributeName(attrib.getName());
		re.setValue(rvalue);
		re.setInterpreter(interp);
		req.getExpressions().add(re);

		unit1.getRequirements().add(req);
		return re;
	}

	private void checkValid(RequirementExpressionInterpreter2 op,
			EAttribute attrib, Object lvalue, Object rvalue) throws IOException {
		Topology top = createTopology("testOperators", true);
		ReqEvaluationContext ctx = buildContext(top, attrib, lvalue);
		String strRValue = EcoreUtil.convertToString(
				attrib.getEAttributeType(), rvalue);
		RequirementExpression expr = buildExpression(top, attrib, op
				.getInterpreterName(), strRValue);
		IDeployStatus ids = op.validate(expr, ctx);
		Assert.assertTrue(ids.getSeverity() == IStatus.OK);
	}

	private void checkInvalid(RequirementExpressionInterpreter2 op,
			EAttribute attrib, Object lvalue, Object rvalue) throws IOException {
		Topology top = createTopology("testOperators", true);
		ReqEvaluationContext ctx = buildContext(top, attrib, lvalue);
		String strRValue = EcoreUtil.convertToString(
				attrib.getEAttributeType(), rvalue);
		RequirementExpression expr = buildExpression(top, attrib, op
				.getInterpreterName(), strRValue);
		IDeployStatus ids = op.validate(expr, ctx);
		Assert.assertTrue(ids.getSeverity() != IStatus.OK);
	}

	// Like checkValue, but uses RequirementUtil to identify interpreter
	private void checkValidRU(String interpreter_id, EAttribute attrib,
			Object lvalue, Object rvalue) throws IOException {
		Topology top = createTopology("testOperators", true);
		ReqEvaluationContext ctx = buildContext(top, attrib, lvalue);
		String strRValue = EcoreUtil.convertToString(
				attrib.getEAttributeType(), rvalue);
		RequirementExpression expr = buildExpression(top, attrib,
				interpreter_id, strRValue);
		Requirement req = wrapExpression(expr);
		IStatus stat = RequirementUtil.validate(req, ctx);
		Assert.assertTrue(stat.getSeverity() == IStatus.OK);
	}

	private ReqEvaluationContext buildContext(Topology top, EAttribute attrib,
			Object lvalue) {
		Capability cap = buildCap(top, attrib, lvalue);
		return new ReqEvaluationContext(cap);
	}

	// Like checkValue, but uses RequirementUtil to identify interpreter
	private void checkInvalidRU(String interpreter_id, EAttribute attrib,
			Object lvalue, Object rvalue) throws IOException {
		Topology top = createTopology("testOperators", true);
		ReqEvaluationContext ctx = buildContext(top, attrib, lvalue);
		String strRValue = EcoreUtil.convertToString(
				attrib.getEAttributeType(), rvalue);
		RequirementExpression expr = buildExpression(top, attrib,
				interpreter_id, strRValue);
		Requirement req = wrapExpression(expr);
		IStatus stat = RequirementUtil.validate(req, ctx);
		Assert.assertTrue(stat.getSeverity() != IStatus.OK);
	}

	private Requirement wrapExpression(RequirementExpression expr) {
		Requirement retVal = CoreFactory.eINSTANCE.createRequirement();
		retVal.getExpressions().add(expr);
		return retVal;
	}

} // end JUnit test case OperatorTest
