/*******************************************************************************
 * Copyright (c) 2003, 2006 IBM Corporation Licensed Material - Property of IBM. All rights reserved.
 *  
 * US Government Users Restricted Rights - Use, duplication or disclosure v1.0 restricted by GSA ADP
 * Schedule Contract with IBM Corp.
 * 
 * Contributors: IBM Corporation - initial API and implementation
 *******************************************************************************/
package com.ibm.ccl.soa.deploy.core.test.validator.expression;

import org.eclipse.core.runtime.IStatus;

import com.ibm.ccl.soa.deploy.core.Capability;
import com.ibm.ccl.soa.deploy.core.CoreFactory;
import com.ibm.ccl.soa.deploy.core.CorePackage;
import com.ibm.ccl.soa.deploy.core.Requirement;
import com.ibm.ccl.soa.deploy.core.RequirementExpression;
import com.ibm.ccl.soa.deploy.core.Topology;
import com.ibm.ccl.soa.deploy.core.Unit;
import com.ibm.ccl.soa.deploy.core.test.TopologyTestCase;
import com.ibm.ccl.soa.deploy.core.validator.expression.Equals;
import com.ibm.ccl.soa.deploy.core.validator.expression.ReqEvaluationContext;
import com.ibm.ccl.soa.deploy.core.validator.status.IDeployAttributeValueStatus;

public class EqualsTest extends TopologyTestCase {

	public EqualsTest() {
		super("EqualsTest");
	}

	public void testEquals() throws Exception {
		Topology top = createTopology("testEquals", true);

		Unit unit1 = CoreFactory.eINSTANCE.createUnit();
		unit1.setName("unit1");
		top.getUnits().add(unit1);

		Requirement req = CoreFactory.eINSTANCE.createRequirement();
		req.setName("req");
		RequirementExpression expr = Equals.createExpression(
				CorePackage.eINSTANCE.getCapability_Origin(), "origin");
		req.getExpressions().add(expr);

		unit1.getRequirements().add(req);

		Unit unit2 = CoreFactory.eINSTANCE.createUnit();
		unit2.setName("unit2");
		top.getUnits().add(unit2);

		Capability cap = CoreFactory.eINSTANCE.createCapability();
		cap.setName("cap");
		cap.setOrigin("origin");
		unit2.getCapabilities().add(cap);

		ReqEvaluationContext ctx = new ReqEvaluationContext(cap);
		assert Equals.getInstance().validate(expr, ctx).getSeverity() == IStatus.OK;

		cap.setOrigin("other");

		IDeployAttributeValueStatus status = (IDeployAttributeValueStatus) Equals
				.getInstance().validate(expr, ctx);
		assert status.getSeverity() != IStatus.OK;
		assert status.getDeployObject() == cap;
		assert status.getAttributeType().getName().equals("origin");
		assert status.getAttributeExpectedValue(
				CorePackage.eINSTANCE.getCapability_Origin()
						.getEAttributeType(), top).equals("origin");
	}
}
