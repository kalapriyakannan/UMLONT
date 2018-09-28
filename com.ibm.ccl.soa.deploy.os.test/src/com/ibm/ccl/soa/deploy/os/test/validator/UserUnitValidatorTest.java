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
import com.ibm.ccl.soa.deploy.core.Requirement;
import com.ibm.ccl.soa.deploy.core.Topology;
import com.ibm.ccl.soa.deploy.core.Unit;
import com.ibm.ccl.soa.deploy.core.constraint.ConstraintFactory;
import com.ibm.ccl.soa.deploy.core.constraint.GroupCardinalityConstraint;
import com.ibm.ccl.soa.deploy.core.test.TopologyTestCase;
import com.ibm.ccl.soa.deploy.core.test.validator.utils.ValidatorTestUtils;
import com.ibm.ccl.soa.deploy.core.validator.IDeployReporter;
import com.ibm.ccl.soa.deploy.core.validator.IDeployValidationContext;
import com.ibm.ccl.soa.deploy.core.validator.pattern.UnitValidator;
import com.ibm.ccl.soa.deploy.internal.core.validator.DeployMarker;
import com.ibm.ccl.soa.deploy.os.OperatingSystem;
import com.ibm.ccl.soa.deploy.os.OperatingSystemUnit;
import com.ibm.ccl.soa.deploy.os.OsFactory;
import com.ibm.ccl.soa.deploy.os.OsPackage;
import com.ibm.ccl.soa.deploy.os.User;
import com.ibm.ccl.soa.deploy.os.UserUnit;
import com.ibm.ccl.soa.deploy.os.internal.validator.UserUnitValidator;

/**
 * Tests {@link UserUnitValidator}.
 */
public class UserUnitValidatorTest extends TopologyTestCase {

	private static final String PROJECT_NAME = "UserUnitValidatorTest";

	protected OperatingSystem consumedUserOs;

	private UserUnit userUnit;

	public UserUnitValidatorTest() {
		super(PROJECT_NAME);
	}

	/*
	 * @see junit.framework.TestCase#tearDown() Uncomment to stop deletion of
	 *      plants topology after test run.
	 */
	protected void tearDown() throws Exception {
	}

	public void testUserUnitValidator() throws IOException, CoreException {
		Topology top = createTopology("UserUnitValidator", true);

		IDeployValidationContext context = createValidationContext(top);
		IDeployReporter reporter = createDeployReporter();
		UserUnitValidator validator = new UserUnitValidator();

		// Provided User service
		User providedUser = OsFactory.eINSTANCE.createUser();
		providedUser.setName("providedUser");
		providedUser.setLinkType(CapabilityLinkTypes.DEPENDENCY_LITERAL);
		providedUser.setUserId("db2admin");
		providedUser.setUserPassword("db2admin");

		Requirement requiredOs = ValidatorTestUtils.createHostingRequirement(
				OsPackage.Literals.OPERATING_SYSTEM, "requiredOs");
		Requirement memberReqUserGroup = ValidatorTestUtils
				.createMemberRequirement(OsPackage.Literals.USER_GROUP_UNIT,
						"memberReqUserGroup");
		
		GroupCardinalityConstraint gcc = ConstraintFactory.eINSTANCE.createGroupCardinalityConstraint();
		gcc.setName("gcc");
		gcc.setMinValue("0");
		gcc.setMaxValue(Integer.valueOf(Integer.MAX_VALUE).toString());
		memberReqUserGroup.getConstraints().add(gcc);

		userUnit = OsFactory.eINSTANCE.createUserUnit();
		userUnit.setName("userUnit");
		top.getUnits().add(userUnit);
		userUnit.getCapabilities().add(providedUser);
		userUnit.getRequirements().add(requiredOs);
		userUnit.getRequirements().add(memberReqUserGroup);

		OperatingSystem operatingSystem = OsFactory.eINSTANCE
				.createOperatingSystem();
		operatingSystem.setName("operatingSystem");
		operatingSystem.setLinkType(CapabilityLinkTypes.ANY_LITERAL);
		OperatingSystemUnit operatingSystemUnit = OsFactory.eINSTANCE
				.createOperatingSystemUnit();
		top.getUnits().add(operatingSystemUnit);
		operatingSystemUnit.getCapabilities().add(operatingSystem);
		ValidatorTestUtils.hosts(operatingSystemUnit, userUnit);

		Resource res = top.getEObject().eResource();
		res.save(null);

		// no markers
		IStatus status = runValidation(top, validator, userUnit, context,
				reporter);
		ValidatorTestUtils.assertValidationErrorCount(0, top, userUnit,
				context, reporter, validator);
		assert status.getSeverity() == IStatus.OK;

		String goodUserId = providedUser.getUserId();
		providedUser.setUserId("");
		ValidatorTestUtils.assertValidationErrorCount(1, top, userUnit,
				context, reporter, validator);
		providedUser.setUserId(null);
		ValidatorTestUtils.assertValidationErrorCount(1, top, userUnit,
				context, reporter, validator);
		providedUser.setUserId(goodUserId);
		ValidatorTestUtils.assertValidationErrorCount(0, top, userUnit,
				context, reporter, validator);

		String goodUserPassword = providedUser.getUserPassword();
		providedUser.setUserPassword("");
		ValidatorTestUtils.assertValidationErrorCount(1, top, userUnit,
				context, reporter, validator);
		providedUser.setUserPassword(null);
		ValidatorTestUtils.assertValidationErrorCount(1, top, userUnit,
				context, reporter, validator);		providedUser.setUserPassword(goodUserPassword);
		ValidatorTestUtils.assertValidationErrorCount(0, top, userUnit,
				context, reporter, validator);
		

		// If we were to require that a user be a member of a group, this test could be adapted. 
		String gccMinValue = gcc.getMinValue();
		gcc.setMinValue("1");
		ValidatorTestUtils.assertValidationErrorCount(1, top, userUnit,
				context, reporter, validator);
		gcc.setMinValue(gccMinValue);
		ValidatorTestUtils.assertValidationErrorCount(0, top, userUnit,
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
