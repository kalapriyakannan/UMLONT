package com.ibm.ccl.soa.deploy.os.test.validator;

/*******************************************************************************
 * Copyright (c) 2003, 2007 IBM Corporation Licensed Material - Property of IBM. All rights reserved.
 *  
 * US Government Users Restricted Rights - Use, duplication or disclosure v1.0 restricted by GSA ADP
 * Schedule Contract with IBM Corp.
 * 
 * Contributors: IBM Corporation - initial API and implementation
 *******************************************************************************/

import java.io.IOException;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.emf.ecore.resource.Resource;

import com.ibm.ccl.soa.deploy.core.CapabilityLinkTypes;
import com.ibm.ccl.soa.deploy.core.CoreFactory;
import com.ibm.ccl.soa.deploy.core.MemberLink;
import com.ibm.ccl.soa.deploy.core.Requirement;
import com.ibm.ccl.soa.deploy.core.Topology;
import com.ibm.ccl.soa.deploy.core.Unit;
import com.ibm.ccl.soa.deploy.core.constraint.ConstraintFactory;
import com.ibm.ccl.soa.deploy.core.constraint.MemberCardinalityConstraint;
import com.ibm.ccl.soa.deploy.core.test.TopologyTestCase;
import com.ibm.ccl.soa.deploy.core.test.validator.utils.ValidatorTestUtils;
import com.ibm.ccl.soa.deploy.core.validator.IDeployReporter;
import com.ibm.ccl.soa.deploy.core.validator.IDeployValidationContext;
import com.ibm.ccl.soa.deploy.core.validator.matcher.LinkFactory;
import com.ibm.ccl.soa.deploy.core.validator.pattern.UnitValidator;
import com.ibm.ccl.soa.deploy.internal.core.validator.DeployMarker;
import com.ibm.ccl.soa.deploy.os.OperatingSystem;
import com.ibm.ccl.soa.deploy.os.OperatingSystemUnit;
import com.ibm.ccl.soa.deploy.os.OsFactory;
import com.ibm.ccl.soa.deploy.os.OsPackage;
import com.ibm.ccl.soa.deploy.os.User;
import com.ibm.ccl.soa.deploy.os.UserGroup;
import com.ibm.ccl.soa.deploy.os.UserGroupUnit;
import com.ibm.ccl.soa.deploy.os.UserUnit;
import com.ibm.ccl.soa.deploy.os.internal.validator.UserGroupUnitValidator;

/**
 * Tests {@link UserGroupUnitValidator}.
 */
public class UserGroupUnitValidatorTest extends TopologyTestCase {

	private static final String PROJECT_NAME = "UserGroupUnitValidatorTest";

	protected OperatingSystem consumedUserGroupOs;

	private UserGroupUnit userGroupUnit;

	private UserUnit userUnit;

	private UserGroupUnit userGroupUnit2;

	public UserGroupUnitValidatorTest() {
		super(PROJECT_NAME);
	}

	/*
	 * @see junit.framework.TestCase#tearDown() Uncomment to stop deletion of
	 *      plants topology after test run.
	 */
	protected void tearDown() throws Exception {
	}

	public void testUserGroupUnitValidator() throws IOException, CoreException {
		Topology top = createTopology("UserGroupUnitValidator", true);

		IDeployValidationContext context = createValidationContext(top);
		IDeployReporter reporter = createDeployReporter();
		UserGroupUnitValidator validator = new UserGroupUnitValidator();

		// Provided UserGroup capability
		UserGroup providedUserGroup = OsFactory.eINSTANCE.createUserGroup();
		providedUserGroup.setName("providedUserGroup");
		providedUserGroup.setDisplayName("providedUserGroup");
		providedUserGroup.setLinkType(CapabilityLinkTypes.DEPENDENCY_LITERAL);
		providedUserGroup.setGroupName("Administrators");

		Requirement requiredOsUserGroup = ValidatorTestUtils
				.createHostingRequirement(OsPackage.Literals.OPERATING_SYSTEM,
						"requiredOsUserGroup2");

		Requirement memberReqUser = ValidatorTestUtils.createMemberRequirement(
				OsPackage.Literals.USER_UNIT, "memberReqUser");
		MemberCardinalityConstraint mcc = ConstraintFactory.eINSTANCE.createMemberCardinalityConstraint();
		mcc.setName("mcc");
		mcc.setMinValue("0");
		mcc.setMaxValue(Integer.valueOf(Integer.MAX_VALUE).toString());
		memberReqUser.getConstraints().add(mcc);

		userGroupUnit = OsFactory.eINSTANCE.createUserGroupUnit();
		userGroupUnit.setName("userGroupUnit");
		userGroupUnit.setDisplayName("userGroupUnit");
		userGroupUnit.setConfigurationUnit(true);

		top.getUnits().add(userGroupUnit);
		userGroupUnit.getCapabilities().add(providedUserGroup);
		userGroupUnit.getRequirements().add(requiredOsUserGroup);
		userGroupUnit.getRequirements().add(memberReqUser);

		// Provided UserGroup capability2
		UserGroup providedUserGroup2 = OsFactory.eINSTANCE.createUserGroup();
		providedUserGroup2.setName("providedUserGroup2");
		providedUserGroup2.setDisplayName("providedUserGroup2");
		providedUserGroup2.setLinkType(CapabilityLinkTypes.DEPENDENCY_LITERAL);
		providedUserGroup.setGroupName("Users");

		Requirement requiredOsUserGroup2 = ValidatorTestUtils
				.createHostingRequirement(OsPackage.Literals.OPERATING_SYSTEM,
						"requiredOsUserGroup2");

		userGroupUnit2 = OsFactory.eINSTANCE.createUserGroupUnit();
		userGroupUnit2.setName("userGroupUnit2");
		userGroupUnit2.setDisplayName("userGroupUnit2");
		userGroupUnit2.setConfigurationUnit(true);

		top.getUnits().add(userGroupUnit2);
		userGroupUnit2.getCapabilities().add(providedUserGroup2);
		userGroupUnit2.getRequirements().add(requiredOsUserGroup2);

		// Provided User service
		User providedUser = OsFactory.eINSTANCE.createUser();
		providedUser.setName("providedUser");
		providedUser.setDisplayName("providedUser");
		providedUser.setLinkType(CapabilityLinkTypes.DEPENDENCY_LITERAL);
		providedUser.setUserId("db2admin");
		providedUser.setUserPassword("db2admin");

		Requirement requiredOsUser = ValidatorTestUtils
				.createHostingRequirement(OsPackage.Literals.OPERATING_SYSTEM,
						"requiredUser");

		userUnit = OsFactory.eINSTANCE.createUserUnit();
		userUnit.setName("userUnit");
		userUnit.setDisplayName("userUnit");
		userUnit.setConfigurationUnit(true);

		top.getUnits().add(userUnit);
		userUnit.getCapabilities().add(providedUser);
		userUnit.getRequirements().add(requiredOsUser);

		LinkFactory.createMemberLink(userGroupUnit, userUnit);

		OperatingSystem operatingSystem = OsFactory.eINSTANCE
				.createOperatingSystem();
		operatingSystem.setName("operatingSystem");
		operatingSystem.setDisplayName("operatingSystem");
		operatingSystem.setLinkType(CapabilityLinkTypes.ANY_LITERAL);

		OperatingSystemUnit operatingSystemUnit = OsFactory.eINSTANCE
				.createOperatingSystemUnit();
		operatingSystemUnit.setName("operatingSystemUnit");
		operatingSystemUnit.setDisplayName("operatingSystemUnit");
		top.getUnits().add(operatingSystemUnit);
		operatingSystemUnit.getCapabilities().add(operatingSystem);
		ValidatorTestUtils.hosts(operatingSystemUnit, userGroupUnit);
		ValidatorTestUtils.hosts(operatingSystemUnit, userGroupUnit2);
		ValidatorTestUtils.hosts(operatingSystemUnit, userUnit);

		Resource res = top.getEObject().eResource();
		res.save(null);

		// no markers
		IStatus status = runValidation(top, validator, userGroupUnit, context,
				reporter);
		ValidatorTestUtils.assertValidationErrorCount(0, top, userGroupUnit,
				context, reporter, validator);
		assert status.getSeverity() == IStatus.OK;

		// Group name must be set and non-empty
		String goodGroupName = providedUserGroup.getGroupName();
		providedUserGroup.setGroupName("");
		ValidatorTestUtils.assertValidationErrorCount(1, top, userGroupUnit,
				context, reporter, validator);
		providedUserGroup.setGroupName(null);
		ValidatorTestUtils.assertValidationErrorCount(1, top, userGroupUnit,
				context, reporter, validator);
		providedUserGroup.setGroupName(goodGroupName);
		ValidatorTestUtils.assertValidationErrorCount(0, top, userGroupUnit,
				context, reporter, validator);

		// Uniqueness of group name
		String goodGroupName2 = providedUserGroup2.getGroupName();
		providedUserGroup2.setGroupName(providedUserGroup.getGroupName());
		ValidatorTestUtils.assertValidationErrorCount(1, top, userGroupUnit,
				context, reporter, validator);
		providedUserGroup2.setGroupName(goodGroupName2);
		ValidatorTestUtils.assertValidationErrorCount(0, top, userGroupUnit,
				context, reporter, validator);
	}

	private IStatus runValidation(Topology top, UnitValidator validator,
			Unit unit, IDeployValidationContext context,
			IDeployReporter reporter) throws IOException, CoreException {
		top.getEObject().eResource().save(null);
		DeployMarker.deleteInstances(top);
		assert unit.getStatus().getSeverity() == IStatus.OK;
		validator.validate(unit, context, reporter);
		IStatus status = unit.getStatus();
		dumpMarkers(top);
		return status;
	}
}
