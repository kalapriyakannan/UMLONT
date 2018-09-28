/*******************************************************************************
 * Copyright (c) 2003, 2007 IBM Corporation Licensed Material - Property of IBM. All rights reserved.
 *  
 * US Government Users Restricted Rights - Use, duplication or disclosure v1.0 restricted by GSA ADP
 * Schedule Contract with IBM Corp.
 * 
 * Contributors: IBM Corporation - initial API and implementation
 *******************************************************************************/
package com.ibm.ccl.soa.deploy.core.test.validator.expression;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.util.EcoreUtil;

import com.ibm.ccl.soa.deploy.core.Capability;
import com.ibm.ccl.soa.deploy.core.CoreFactory;
import com.ibm.ccl.soa.deploy.core.CorePackage;
import com.ibm.ccl.soa.deploy.core.Requirement;
import com.ibm.ccl.soa.deploy.core.RequirementExpression;
import com.ibm.ccl.soa.deploy.core.RequirementExpressionUsage;
import com.ibm.ccl.soa.deploy.core.Topology;
import com.ibm.ccl.soa.deploy.core.Unit;
import com.ibm.ccl.soa.deploy.core.test.TopologyTestCase;
import com.ibm.ccl.soa.deploy.core.validator.expression.Equals;
import com.ibm.ccl.soa.deploy.core.validator.expression.ReqEvaluationContext;
import com.ibm.ccl.soa.deploy.core.validator.expression.Version;

public class VersionTest extends TopologyTestCase {

	public VersionTest() {
		super("VersionTest");
	}

	public void testVersion() {
		assertMatch("1", "1");
		assertMatch("1.x", "1");
		assertFail("1.x", "2");
		assertMatch("1.x", "1.1");
		assertMatch("1.x", "1.1b");
		assertMatch("1.x", "1.9");
		assertMatch("1.x", "1.9.1");
		assertMatch("1.x", "1.1.0");
		assertMatch("1.1+", "1.1.0");
		assertMatch("1.1+", "1.2");
		assertFail("1.1+", "1.0");
		assertMatch("1.x", "1.0b");
		assertFail("1.1+", "1.0.12");
		assertMatch("1.1.2.x", "1.1.2");
		assertMatch("1.1.2.x", "1.1.2.1");
		assertMatch("1.100+", "1.101");
		assertFail("1.100+", "1.2");
		assertFail("1.100+", "1.2c");
		assertMatch("1.1+", "1.1");
		assertMatch("1.1+", "2.0");
		assertMatch("1.1+", "3.14b");
		assertFail("2.1+", "1");

		assertFail("2.1.3", "");
		assertFail("2.1.3", "2");
		assertFail("2.1.3", "2.1");
		assertFail("2.1.3", "2.1.");
		assertFail("2.1.", "2");
		assertMatch("2.1.", "2.1");
		assertMatch("2.1.", "2.1.");
		assertFail("2+", "");
		assertFail("2.1+", "2");
		assertFail("2.1+", "2.");
		assertMatch("6.0", "6.0.0.1");
	}

	private void assertFail(String pattern, String version) {
		Version v = new Version();
		assert !v.interpString(pattern, version);
	}

	private void assertMatch(String pattern, String version) {
		Version v = new Version();
		assert v.interpString(pattern, version);
	}

	public void testFullPath() throws Exception {
		Topology top = createTopology("testVersion", true);

		Unit unit1 = CoreFactory.eINSTANCE.createUnit();
		unit1.setName("unit1");
		top.getUnits().add(unit1);

		Requirement req = CoreFactory.eINSTANCE.createRequirement();
		req.setName("req");
		RequirementExpression expr = createExpression(CorePackage.eINSTANCE
				.getCapability_BuildVersion(), "1.1+");
		req.getExpressions().add(expr);

		unit1.getRequirements().add(req);

		Unit unit2 = CoreFactory.eINSTANCE.createUnit();
		unit2.setName("unit2");
		top.getUnits().add(unit2);

		Capability cap = CoreFactory.eINSTANCE.createCapability();
		cap.setName("cap");
		cap.setBuildVersion("1.1");
		unit2.getCapabilities().add(cap);

		ReqEvaluationContext ctx = new ReqEvaluationContext(cap);
		assert Version.getInstance().validate(expr, ctx).isOK();

		cap.setBuildVersion("1.0");
		assert !Version.getInstance().validate(expr, ctx).isOK();
	}

	/**
	 * Creates an equality requirement expression.
	 * 
	 * @param attr
	 *            the attribute on the capability that must be equal.
	 * @param value
	 *            the required value of the attribute.
	 * @return the created requirement expression (invokers must add it to a
	 *         {@link Requirement}).
	 */
	public static RequirementExpression createExpression(EAttribute attr,
			Object value) {
		RequirementExpression expr = CoreFactory.eINSTANCE
				.createRequirementExpression();
		expr.setUse(RequirementExpressionUsage.REQUIRED_LITERAL);
		expr.setInterpreter(Equals.INTERPRETER_ID);
		setAttribute(expr, attr, value);
		return expr;
	}

	public static void setAttribute(RequirementExpression expr,
			EAttribute attr, Object value) {
		assert expr != null;
		assert attr != null;
		assert CorePackage.eINSTANCE.getDeployModelObject().isSuperTypeOf(
				attr.getEContainingClass()) : attr.getEContainingClass();
		assert (value == null) || (attr.getEAttributeType().isInstance(value)) : attr
				.getName()
				+ ' '
				+ value
				+ " instance of " + value.getClass() + " not instance of " //$NON-NLS-1$ //$NON-NLS-2$ 
				+ attr.getEAttributeType();
		if (!Version.INTERPRETER_ID.equals(expr.getInterpreter())) {
			expr.setInterpreter(Version.INTERPRETER_ID);
		}

		expr.setName(attr.getName());
		expr.setAttributeName(attr.getName());

		if (value == null) {
			expr.setValue(null);
		} else {
			expr.setValue(EcoreUtil.convertToString(attr.getEAttributeType(),
					value));
		}
	}
}
