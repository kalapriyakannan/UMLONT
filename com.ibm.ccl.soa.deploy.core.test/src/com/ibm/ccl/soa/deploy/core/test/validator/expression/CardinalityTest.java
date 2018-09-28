/*******************************************************************************
 * Copyright (c) 2003, 2007 IBM Corporation Licensed Material - Property of IBM. All rights reserved.
 *  
 * US Government Users Restricted Rights - Use, duplication or disclosure v1.0 restricted by GSA ADP
 * Schedule Contract with IBM Corp.
 * 
 * Contributors: IBM Corporation - initial API and implementation
 *******************************************************************************/
package com.ibm.ccl.soa.deploy.core.test.validator.expression;

import org.eclipse.emf.ecore.EClass;

import com.ibm.ccl.soa.deploy.core.CoreFactory;
import com.ibm.ccl.soa.deploy.core.CorePackage;
import com.ibm.ccl.soa.deploy.core.MemberLink;
import com.ibm.ccl.soa.deploy.core.Requirement;
import com.ibm.ccl.soa.deploy.core.RequirementExpression;
import com.ibm.ccl.soa.deploy.core.RequirementLinkTypes;
import com.ibm.ccl.soa.deploy.core.RequirementUsage;
import com.ibm.ccl.soa.deploy.core.Topology;
import com.ibm.ccl.soa.deploy.core.Unit;
import com.ibm.ccl.soa.deploy.core.test.TopologyTestCase;
import com.ibm.ccl.soa.deploy.core.validator.expression.InCardinality;
import com.ibm.ccl.soa.deploy.core.validator.expression.OutCardinality;

/**
 * Tests the {@link RequirementExpression#getInterpreter()} for
 * {@link InCardinality} and {@link OutCardinality}.
 */
public class CardinalityTest extends TopologyTestCase {

	public CardinalityTest() {
		super("CardinalityTest");
	}

	public static Unit createGroup(EClass memberType, int outMinCardinality,
			int outMaxCardinality) {
		Unit unit = CoreFactory.eINSTANCE.createUnit();
		unit.setName("group");

		Requirement req = CoreFactory.eINSTANCE.createRequirement();
		req.setName("memberRequirement");
		req.setLinkType(RequirementLinkTypes.MEMBER_LITERAL);
		req.setDmoEType(memberType);
		req.setUse(RequirementUsage.REQUIRED_LITERAL);
		unit.getRequirements().add(req);

		RequirementExpression expr = OutCardinality.createExpression(
				outMinCardinality, outMaxCardinality);
		req.getExpressions().add(expr);

		return unit;
	}

	public static Unit createMember(EClass groupType, int inMinCardinality,
			int intMaxCardinality) {
		Unit unit = CoreFactory.eINSTANCE.createUnit();

		Requirement req = CoreFactory.eINSTANCE.createRequirement();
		req.setName("memberRequirement");
		req.setDmoEType(groupType);
		unit.getRequirements().add(req);

		RequirementExpression expr = InCardinality.createExpression(
				inMinCardinality, intMaxCardinality);
		req.getExpressions().add(expr);

		return unit;
	}

	public void testCardinality() throws Exception {
		Topology top = createTopology("testCardinality");

		// Create group and member but no link
		Unit group = createGroup(CorePackage.eINSTANCE.getUnit(), 0, -1);
		group.setName("group");
		Requirement groupReq = (Requirement) group.getRequirements().get(0);
		RequirementExpression groupReqExpr = (RequirementExpression) groupReq
				.getExpressions().get(0);
		top.getUnits().add(group);

		// Validate: 0 is a valid member cardinality
		validate(top);
		assertHasNoErrorStatus(top);

		// Change constraints
		InCardinality.setCardinality(groupReqExpr, 1, -1);
		validate(top);
		assertHasErrorStatus(top);
		dumpStatus(top);

		// Add member and member link
		Unit member = CoreFactory.eINSTANCE.createUnit();
		member.setName("member");
		top.getUnits().add(member);

		MemberLink link = CoreFactory.eINSTANCE.createMemberLink();
		link.setName("memberLink");
		link.setSource(group);
		link.setTarget(member);
		group.getMemberLinks().add(link);

		// Validate: OK
		validate(top);
		assertHasNoErrorStatus(top);
	}
}
