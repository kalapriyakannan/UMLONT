/*******************************************************************************
 * Copyright (c) 2003, 2006 IBM Corporation Licensed Material - Property of IBM. All rights reserved.
 *  
 * US Government Users Restricted Rights - Use, duplication or disclosure v1.0 restricted by GSA ADP
 * Schedule Contract with IBM Corp.
 * 
 * Contributors: IBM Corporation - initial API and implementation
 *******************************************************************************/
package com.ibm.ccl.soa.deploy.os.test.validator;

import com.ibm.ccl.soa.deploy.core.CapabilityLinkTypes;
import com.ibm.ccl.soa.deploy.core.CoreFactory;
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
import com.ibm.ccl.soa.deploy.core.validator.status.ICoreProblemType;
import com.ibm.ccl.soa.deploy.os.OsFactory;
import com.ibm.ccl.soa.deploy.os.OsPackage;
import com.ibm.ccl.soa.deploy.os.User;
import com.ibm.ccl.soa.deploy.os.UserGroup;
import com.ibm.ccl.soa.deploy.os.UserGroupUnit;
import com.ibm.ccl.soa.deploy.os.UserUnit;

/**
 * Tests grouping cardinality constraints
 */
public class OsGroupCardinalityTest extends TopologyTestCase {

	public OsGroupCardinalityTest() {
		super("OsGroupCardinalityTest");
		this.setDeleteProjectOnTearDown(false);
	}

	public static Unit createUserGroup(int outMinCardinality,
			int outMaxCardinality) {
		UserGroupUnit unit = OsFactory.eINSTANCE.createUserGroupUnit();
		unit.setName("group");

		Requirement memberReq = CoreFactory.eINSTANCE.createRequirement();
		memberReq.setName("memberRequirement");
		memberReq.setLinkType(RequirementLinkTypes.MEMBER_LITERAL);
		memberReq.setDmoEType(OsPackage.eINSTANCE.getUserUnit());
		memberReq.setUse(RequirementUsage.REQUIRED_LITERAL);
		unit.getRequirements().add(memberReq);

		MemberCardinalityConstraint mcc = ConstraintFactory.eINSTANCE.createMemberCardinalityConstraint();
		mcc.setName("mcc");
		memberReq.getConstraints().add(mcc);
		mcc.setMinValue(Integer.valueOf(outMinCardinality).toString());
		mcc.setMaxValue(Integer.valueOf(outMaxCardinality).toString());

		Requirement osReq = CoreFactory.eINSTANCE.createRequirement();
		osReq.setName("osReq");
		osReq.setLinkType(RequirementLinkTypes.HOSTING_LITERAL);
		osReq.setDmoEType(OsPackage.eINSTANCE.getOperatingSystem());
		osReq.setUse(RequirementUsage.OPTIONAL_LITERAL);
		unit.getRequirements().add(osReq);

		UserGroup groupCap = OsFactory.eINSTANCE.createUserGroup();
		groupCap.setName("groupCap");
		groupCap.setGroupName("testGroup");
		unit.getCapabilities().add(groupCap);

		return unit;
	}

	public static Unit createUser(int inMinCardinality, int inMaxCardinality) {
		UserUnit userUnit = OsFactory.eINSTANCE.createUserUnit();
		userUnit.setName("userUnit");

		User user = OsFactory.eINSTANCE.createUser();
		user.setName("providedUser");
		user.setLinkType(CapabilityLinkTypes.DEPENDENCY_LITERAL);
		user.setUserId("db2admin");
		user.setUserPassword("db2admin");
		userUnit.getCapabilities().add(user);

		Requirement osReq = CoreFactory.eINSTANCE.createRequirement();
		osReq.setName("osReq");
		osReq.setLinkType(RequirementLinkTypes.HOSTING_LITERAL);
		osReq.setDmoEType(OsPackage.eINSTANCE.getOperatingSystem());
		osReq.setUse(RequirementUsage.OPTIONAL_LITERAL);
		userUnit.getRequirements().add(osReq);

		Requirement memberReq = CoreFactory.eINSTANCE.createRequirement();
		memberReq.setName("membershipRequirement");
		memberReq.setLinkType(RequirementLinkTypes.MEMBER_LITERAL);
		memberReq.setDmoEType(OsPackage.eINSTANCE.getUserGroupUnit());
		memberReq.setUse(RequirementUsage.REQUIRED_LITERAL);
		userUnit.getRequirements().add(memberReq);

		GroupCardinalityConstraint gcc = ConstraintFactory.eINSTANCE.createGroupCardinalityConstraint();
		gcc.setName("gcc");
		gcc.setMinValue(Integer.valueOf(inMinCardinality).toString());
		gcc.setMaxValue(Integer.valueOf(inMaxCardinality).toString());
		memberReq.getConstraints().add(gcc);

		return userUnit;
	}

	public void testCardinality() throws Exception {
		Topology top = createTopology("testCardinality");

		// Create group and member but no link
		Unit group = createUserGroup(0, Integer.MAX_VALUE);
		group.setName("group");

		Requirement groupReq = (Requirement) group.getRequirements().get(0);
		assert(groupReq.getConstraints().size() == 1);
		MemberCardinalityConstraint mcc = (MemberCardinalityConstraint)groupReq.getConstraints().get(0);

		top.getUnits().add(group);

		// Validate: 0 is a valid member cardinality
		validate(top);
		assertHasNoErrorStatus(top);

		// Change constraints
		mcc.setMinValue("1");
		mcc.setMaxValue(Integer.valueOf(Integer.MAX_VALUE).toString());
		save(top);
		validate(top);
		assertHasErrorStatus(top,
				ICoreProblemType.GROUP_OUT_CARDINALITY_INVALID);

		// Add invalid member and member link
		Unit member = CoreFactory.eINSTANCE.createUnit();
		member.setName("member");
		top.getUnits().add(member);

		MemberLink link = CoreFactory.eINSTANCE.createMemberLink();
		link.setName("memberLink");
		link.setSource(group);
		link.setTarget(member);
		group.getMemberLinks().add(link);

		// Validate: error: invalid member type
		validate(top);
		assertHasErrorStatus(top, ICoreProblemType.MEMBER_LINK_TARGET_INVALID);

		// Replace member
		top.getUnits().remove(member);
		link.setTarget(null);
		member = createUser(1, Integer.MAX_VALUE);
		top.getUnits().add(member);
		link.setTarget(member);

		// Validate: OK
		validate(top);
		assertHasNoErrorStatus(top);

		// Remove group and link
		link.setTarget(null);
		top.getUnits().remove(group);
		save(top);

		// Validate: error: user needs group
		validate(top);
		assertHasErrorStatus(top, ICoreProblemType.GROUP_IN_CARDINALITY_INVALID);
	}
}
