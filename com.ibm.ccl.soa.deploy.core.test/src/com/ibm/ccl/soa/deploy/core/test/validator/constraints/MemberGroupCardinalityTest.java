/*******************************************************************************
 * Copyright (c) 2003, 2007 IBM Corporation Licensed Material - Property of IBM. All rights reserved.
 *  
 * US Government Users Restricted Rights - Use, duplication or disclosure v1.0 restricted by GSA ADP
 * Schedule Contract with IBM Corp.
 * 
 * Contributors: IBM Corporation - initial API and implementation
 *******************************************************************************/
package com.ibm.ccl.soa.deploy.core.test.validator.constraints;

import org.eclipse.emf.ecore.EClass;

import com.ibm.ccl.soa.deploy.core.CoreFactory;
import com.ibm.ccl.soa.deploy.core.CorePackage;
import com.ibm.ccl.soa.deploy.core.MemberLink;
import com.ibm.ccl.soa.deploy.core.Requirement;
import com.ibm.ccl.soa.deploy.core.RequirementLinkTypes;
import com.ibm.ccl.soa.deploy.core.RequirementUsage;
import com.ibm.ccl.soa.deploy.core.Topology;
import com.ibm.ccl.soa.deploy.core.Unit;
import com.ibm.ccl.soa.deploy.core.constraint.ConstraintFactory;
import com.ibm.ccl.soa.deploy.core.constraint.GroupCardinalityConstraint;
import com.ibm.ccl.soa.deploy.core.constraint.MemberCardinalityConstraint;
import com.ibm.ccl.soa.deploy.core.test.TopologyTestCase;
import com.ibm.ccl.soa.deploy.core.util.UnitUtil;
import com.ibm.ccl.soa.deploy.core.validator.status.ICoreProblemType;

/**
 * Tests the {@link MemberCardinalityConstraint} and {@link GroupCardinalityConstraint}.
 */
public class MemberGroupCardinalityTest extends TopologyTestCase {

	public MemberGroupCardinalityTest() {
		super("MemberGroupCardinalityTest");
	}

	public static Unit createGroup(Topology top, EClass memberType, String minMemberCardinality,
			String maxMemberCardinality) {
		Unit unit = CoreFactory.eINSTANCE.createUnit();
		unit.setName(UnitUtil.generateUniqueName(top, "group"));

		Requirement req = CoreFactory.eINSTANCE.createRequirement();
		req.setName("MemberRequirement");
		req.setDmoEType(memberType);
		req.setLinkType(RequirementLinkTypes.MEMBER_LITERAL);
		req.setUse(RequirementUsage.REQUIRED_LITERAL);
		unit.getRequirements().add(req);
		
		MemberCardinalityConstraint cnstr = ConstraintFactory.eINSTANCE.createMemberCardinalityConstraint();
		cnstr.setName("c0");
		cnstr.setMinValue(minMemberCardinality);
		cnstr.setMaxValue(maxMemberCardinality);
		req.getConstraints().add(cnstr);

		top.getUnits().add(unit);
		return unit;
	}

	public static Unit createMember(Topology top, EClass groupType, String minGroupCardinality,
			String maxGroupCardinality) {
		Unit unit = CoreFactory.eINSTANCE.createUnit();
		unit.setName(UnitUtil.generateUniqueName(top, "member"));

		Requirement req = CoreFactory.eINSTANCE.createRequirement();
		req.setName("MemberRequirement");
		req.setDmoEType(groupType);
		req.setLinkType(RequirementLinkTypes.MEMBER_LITERAL);
		req.setUse(RequirementUsage.REQUIRED_LITERAL);
		unit.getRequirements().add(req);

		GroupCardinalityConstraint cnstr = ConstraintFactory.eINSTANCE.createGroupCardinalityConstraint();
		cnstr.setName("c0");
		cnstr.setMinValue(minGroupCardinality);
		cnstr.setMaxValue(maxGroupCardinality);
		req.getConstraints().add(cnstr);

		top.getUnits().add(unit);
		return unit;
	}

	public void testCardinality() throws Exception {
		Topology top = createTopology("testCardinality");
		
		// test malformed MemberCardinality Constraint
		Unit group = createGroup(top, CorePackage.eINSTANCE.getUnit(), "0", "4");
		validate(top);
		assertHasNoErrorStatus (top);
		
		top.getUnits().clear();
		group = createGroup(top, CorePackage.eINSTANCE.getUnit(), "0", "unbounded");
		validate(top);
		assertHasNoErrorStatus (top);

		top.getUnits().clear();
		group = createGroup(top, CorePackage.eINSTANCE.getUnit(), "", "unbounded");
		validate(top);
		assertHasNoErrorStatus (top);

		top.getUnits().clear();
		group = createGroup(top, CorePackage.eINSTANCE.getUnit(), "0", "");
		validate(top);
		assertHasNoErrorStatus (top);

		top.getUnits().clear();
		group = createGroup(top, CorePackage.eINSTANCE.getUnit(), "0", "chicken");
		validate(top);
		assertHasErrorStatus(top, ICoreProblemType.CONSTRAINT_MALFORMED);
		
		top.getUnits().clear();
		group = createGroup(top, CorePackage.eINSTANCE.getUnit(), "rabbit", "5");
		validate(top);
		assertHasErrorStatus(top, ICoreProblemType.CONSTRAINT_MALFORMED);

		top.getUnits().clear();
		group = createGroup(top, CorePackage.eINSTANCE.getUnit(), "-1", "5");
		validate(top);
		assertHasErrorStatus(top, ICoreProblemType.CONSTRAINT_MALFORMED);

		top.getUnits().clear();
		group = createGroup(top, CorePackage.eINSTANCE.getUnit(), "0", "-5");
		validate(top);
		assertHasErrorStatus(top, ICoreProblemType.CONSTRAINT_MALFORMED);

		// test malformed GroupCardinality Constraint
		top.getUnits().clear();
		Unit member = createMember(top, CorePackage.eINSTANCE.getUnit(), "0", "4");
		validate(top);
		assertHasNoErrorStatus (top);
		
		member = createMember(top, CorePackage.eINSTANCE.getUnit(), "0", "unbounded");
		validate(top);
		assertHasNoErrorStatus (top);

		top.getUnits().clear();
		member = createMember(top, CorePackage.eINSTANCE.getUnit(), "", "unbounded");
		validate(top);
		assertHasNoErrorStatus (top);

		top.getUnits().clear();
		member = createMember(top, CorePackage.eINSTANCE.getUnit(), "0", "");
		validate(top);
		assertHasNoErrorStatus (top);

		top.getUnits().clear();
		member = createMember(top, CorePackage.eINSTANCE.getUnit(), "0", "chicken");
		validate(top);
		assertHasErrorStatus(top, ICoreProblemType.CONSTRAINT_MALFORMED);
		
		top.getUnits().clear();
		member = createMember(top, CorePackage.eINSTANCE.getUnit(), "rabbit", "5");
		validate(top);
		assertHasErrorStatus(top, ICoreProblemType.CONSTRAINT_MALFORMED);

		top.getUnits().clear();
		member = createMember(top, CorePackage.eINSTANCE.getUnit(), "-1", "5");
		validate(top);
		assertHasErrorStatus(top, ICoreProblemType.CONSTRAINT_MALFORMED);

		top.getUnits().clear();
		member = createMember(top, CorePackage.eINSTANCE.getUnit(), "0", "-5");
		validate(top);
		assertHasErrorStatus(top, ICoreProblemType.CONSTRAINT_MALFORMED);

		// Create group
		top.getUnits().clear();
		group = createGroup(top, CorePackage.eINSTANCE.getUnit(), "1", "unbounded");
		Requirement groupReq = (Requirement) group.getRequirements().get(0);
		MemberCardinalityConstraint memberCardConstraint = (MemberCardinalityConstraint) groupReq
				.getConstraints().get(0);
		validate(top);
		assertHasErrorStatus(top, ICoreProblemType.GROUP_OUT_CARDINALITY_INVALID);

		// Add future member
		member = createMember(top, CorePackage.eINSTANCE.getUnit(), "2", "unbounded");
		validate(top);
		assertHasErrorStatus(top, ICoreProblemType.GROUP_IN_CARDINALITY_INVALID);

		// create member link group --> member
		MemberLink link = CoreFactory.eINSTANCE.createMemberLink();
		link.setName("memberLink");
		link.setSource(group);
		link.setTarget(member);
		group.getMemberLinks().add(link);

		// Validate: groups does not have error, member has error
		validate(top);
		assertHasNoErrorStatus(top, ICoreProblemType.GROUP_OUT_CARDINALITY_INVALID);
		assertHasErrorStatus(top, ICoreProblemType.GROUP_IN_CARDINALITY_INVALID);
		
		Unit group2 = createGroup(top, CorePackage.eINSTANCE.getUnit(), "0", "1");
		// create member link group2 --> member
		link = CoreFactory.eINSTANCE.createMemberLink();
		link.setName("memberLink");
		link.setSource(group2);
		link.setTarget(member);
		group2.getMemberLinks().add(link);
		
		// topology should have no errors
		validate(top);
		assertHasNoErrorStatus(top);
	}
}
