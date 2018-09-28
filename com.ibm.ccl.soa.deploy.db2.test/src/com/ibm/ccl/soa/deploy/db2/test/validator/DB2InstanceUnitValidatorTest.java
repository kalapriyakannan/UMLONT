/*******************************************************************************
 * Copyright (c) 2003, 2007 IBM Corporation Licensed Material - Property of IBM. All rights reserved.
 *  
 * US Government Users Restricted Rights - Use, duplication or disclosure v1.0 restricted by GSA ADP
 * Schedule Contract with IBM Corp.
 * 
 * Contributors: IBM Corporation - initial API and implementation
 *******************************************************************************/
package com.ibm.ccl.soa.deploy.db2.test.validator;

import java.io.IOException;
import java.math.BigInteger;
import java.util.HashSet;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IStatus;

import com.ibm.ccl.soa.deploy.core.CapabilityLinkTypes;
import com.ibm.ccl.soa.deploy.core.CoreFactory;
import com.ibm.ccl.soa.deploy.core.DependencyLink;
import com.ibm.ccl.soa.deploy.core.FileArtifact;
import com.ibm.ccl.soa.deploy.core.HostingLink;
import com.ibm.ccl.soa.deploy.core.MemberLink;
import com.ibm.ccl.soa.deploy.core.Requirement;
import com.ibm.ccl.soa.deploy.core.RequirementLinkTypes;
import com.ibm.ccl.soa.deploy.core.RequirementUsage;
import com.ibm.ccl.soa.deploy.core.Topology;
import com.ibm.ccl.soa.deploy.core.constraint.ConstraintFactory;
import com.ibm.ccl.soa.deploy.core.constraint.EqualsConstraint;
import com.ibm.ccl.soa.deploy.core.constraint.GroupCardinalityConstraint;
import com.ibm.ccl.soa.deploy.core.constraint.MemberCardinalityConstraint;
import com.ibm.ccl.soa.deploy.core.test.TopologyTestCase;
import com.ibm.ccl.soa.deploy.core.test.validator.utils.ValidatorTestUtils;
import com.ibm.ccl.soa.deploy.core.validator.IDeployReporter;
import com.ibm.ccl.soa.deploy.core.validator.IDeployValidationContext;
import com.ibm.ccl.soa.deploy.core.validator.ValidatorUtils;
import com.ibm.ccl.soa.deploy.core.validator.status.ICoreProblemType;
import com.ibm.ccl.soa.deploy.db2.DB2Database;
import com.ibm.ccl.soa.deploy.db2.DB2DatabaseUnit;
import com.ibm.ccl.soa.deploy.db2.DB2Instance;
import com.ibm.ccl.soa.deploy.db2.DB2InstanceUnit;
import com.ibm.ccl.soa.deploy.db2.DB2System;
import com.ibm.ccl.soa.deploy.db2.DB2SystemUnit;
import com.ibm.ccl.soa.deploy.db2.Db2Factory;
import com.ibm.ccl.soa.deploy.db2.Db2Package;
import com.ibm.ccl.soa.deploy.db2.internal.validator.DB2InstanceUnitValidator;
import com.ibm.ccl.soa.deploy.db2.internal.validator.IDB2ProblemType;
import com.ibm.ccl.soa.deploy.internal.core.validator.DeployMarker;
import com.ibm.ccl.soa.deploy.os.OperatingSystem;
import com.ibm.ccl.soa.deploy.os.OperatingSystemType;
import com.ibm.ccl.soa.deploy.os.OperatingSystemUnit;
import com.ibm.ccl.soa.deploy.os.OsFactory;
import com.ibm.ccl.soa.deploy.os.OsPackage;
import com.ibm.ccl.soa.deploy.os.Port;
import com.ibm.ccl.soa.deploy.os.PortConfigUnit;
import com.ibm.ccl.soa.deploy.os.PortConsumer;
import com.ibm.ccl.soa.deploy.os.TransportLayerProtocolType;
import com.ibm.ccl.soa.deploy.os.User;
import com.ibm.ccl.soa.deploy.os.UserGroup;
import com.ibm.ccl.soa.deploy.os.UserGroupUnit;
import com.ibm.ccl.soa.deploy.os.UserUnit;

/**
 * Tests {@link DB2InstanceUnit}.
 * 
 * @author barnold
 * 
 */
public class DB2InstanceUnitValidatorTest extends TopologyTestCase {

	private static final String PROJECT_NAME = "DB2InstanceUnitValidatorTest";

	private DB2SystemUnit systemUnit;

	public DB2InstanceUnitValidatorTest() {
		super(PROJECT_NAME);
	}

	/*
	 * @see junit.framework.TestCase#tearDown() Uncomment to stop deletion of
	 *      plants topology after test run.
	 */
	protected void tearDown() throws Exception {
	}

	public void testDB2InstanceUnitValidator() throws IOException,
			CoreException {

		Topology top = createTopology("DB2InstanceUnitValidatorTest", true);

		IDeployValidationContext context = createValidationContext(top);
		IDeployReporter reporter = createDeployReporter();
		DB2InstanceUnitValidator validator = new DB2InstanceUnitValidator();

		//
		// Database unit
		//
		DB2Database providedDatabase = Db2Factory.eINSTANCE.createDB2Database();
		providedDatabase.setName("providedDatabase");
		providedDatabase.setDbAlias("DATABASE");
		providedDatabase.setDbDrive("C:/DB2");
		providedDatabase.setDbName("DATABASE");

		DB2DatabaseUnit databaseUnit = Db2Factory.eINSTANCE
				.createDB2DatabaseUnit();
		databaseUnit.setName("databaseUnit");
		top.getUnits().add(databaseUnit);

		Requirement requiredDb2Instance;
		requiredDb2Instance = CoreFactory.eINSTANCE.createRequirement();
		requiredDb2Instance.setName("requiredDb2Instance");
		requiredDb2Instance.setDmoEType(Db2Package.eINSTANCE.getDB2Instance());
		requiredDb2Instance.setLinkType(RequirementLinkTypes.HOSTING_LITERAL);
		databaseUnit.getRequirements().add(requiredDb2Instance);

		databaseUnit.getOnlyDependencyCapabilities().add(providedDatabase);
		databaseUnit.getRequirements().add(requiredDb2Instance);

		FileArtifact ddlArtPlantsBy = CoreFactory.eINSTANCE
				.createFileArtifact();
		ddlArtPlantsBy.setName("demoDDL");
		ddlArtPlantsBy.getFileURIs().add("demo.ddl");
		databaseUnit.getArtifacts().add(ddlArtPlantsBy);

		DeployMarker.deleteInstances(top);

		assert databaseUnit.getStatus().getSeverity() == IStatus.OK;
		//
		// Instance unit
		//

		DB2Instance providedInstance = Db2Factory.eINSTANCE.createDB2Instance();
		providedInstance.setName("providedInstance");
		providedInstance.setDb2InstanceName("DB2INST1");
		providedInstance.setHostname("test.ibm.com");
		providedInstance.setUsername("db2admin");
		providedInstance.setPassword("db2admin");
		providedInstance.setPort(BigInteger.valueOf(50000));
		providedInstance.setAutoStart(false);
		providedInstance.setDb2Version("8.1.0.36");

		DB2Instance providedInstance2 = Db2Factory.eINSTANCE
				.createDB2Instance();
		providedInstance2.setName("providedInstance2");
		providedInstance2.setDb2InstanceName("DB2INST2");
		providedInstance2.setHostname("test.ibm.com");
		providedInstance2.setUsername("db2admin");
		providedInstance2.setPassword("db2admin");
		providedInstance2.setPort(BigInteger.valueOf(50001));
		providedInstance2.setDb2Version("8.1.0.36");

		DB2Instance providedInstance3 = Db2Factory.eINSTANCE
				.createDB2Instance();
		providedInstance3.setName("providedInstance3");
		providedInstance3.setDb2InstanceName("DB2INST3");
		providedInstance3.setHostname("test.ibm.com");
		providedInstance3.setUsername("db2admin");
		providedInstance3.setPassword("db2admin");
		providedInstance3.setPort(BigInteger.valueOf(50002));
		providedInstance3.setDb2Version("8.1.0.36");
		providedInstance3.setAutoStart(false);

		UserGroup userGroupTest = OsFactory.eINSTANCE.createUserGroup();
		userGroupTest.setName("userGroupTest");

		// Provide a PortConsumer capability
		PortConsumer portConsumer = OsFactory.eINSTANCE.createPortConsumer();
		portConsumer.setName("portConsumer");
		portConsumer.setDisplayName("portConsumer");
		portConsumer.setLinkType(CapabilityLinkTypes.ANY_LITERAL);

		DB2InstanceUnit instanceUnit = Db2Factory.eINSTANCE
				.createDB2InstanceUnit();
		instanceUnit.setName("instanceUnit");
		instanceUnit.getHostingOrAnyCapabilities().add(providedInstance);
		instanceUnit.getCapabilities().add(portConsumer);
		top.getUnits().add(instanceUnit);
		ValidatorTestUtils.hosts(instanceUnit, databaseUnit);

		DB2InstanceUnit instanceUnit2 = Db2Factory.eINSTANCE
				.createDB2InstanceUnit();
		instanceUnit2.setName("instanceUnit2");
		instanceUnit2.getHostingOrAnyCapabilities().add(providedInstance2);
		top.getUnits().add(instanceUnit2);

		Requirement requiredDb2System;
		requiredDb2System = CoreFactory.eINSTANCE.createRequirement();
		requiredDb2System.setName("requiredDb2System");
		requiredDb2System.setDmoEType(Db2Package.eINSTANCE.getDB2System());
		requiredDb2System.setLinkType(RequirementLinkTypes.HOSTING_LITERAL);

		Requirement requiredDb2System2;
		requiredDb2System2 = CoreFactory.eINSTANCE.createRequirement();
		requiredDb2System2.setName("requiredDb2System2");
		requiredDb2System2.setDmoEType(Db2Package.eINSTANCE.getDB2System());
		requiredDb2System2.setLinkType(RequirementLinkTypes.HOSTING_LITERAL);

		instanceUnit2.getRequirements().add(requiredDb2System2);

		Requirement requiredDb2System3;
		requiredDb2System3 = CoreFactory.eINSTANCE.createRequirement();
		requiredDb2System3.setName("requiredDb2System3");
		requiredDb2System3.setDmoEType(Db2Package.eINSTANCE.getDB2System());
		requiredDb2System3.setLinkType(RequirementLinkTypes.HOSTING_LITERAL);

		Requirement dummyRequiredDb2ClientTest;
		dummyRequiredDb2ClientTest = CoreFactory.eINSTANCE.createRequirement();
		dummyRequiredDb2ClientTest.setName("dummyRequiredDb2ClientTest");
		dummyRequiredDb2ClientTest.setDmoEType(Db2Package.eINSTANCE
				.getDB2Client());
		dummyRequiredDb2ClientTest
				.setLinkType(RequirementLinkTypes.HOSTING_LITERAL);

		Requirement requiredDb2AdminUser;
		requiredDb2AdminUser = CoreFactory.eINSTANCE.createRequirement();
		requiredDb2AdminUser.setName("requiredDb2AdminUser");
		requiredDb2AdminUser.setDmoEType(OsPackage.eINSTANCE.getUser());
// requiredDb2AdminUser.getExpressions().add(Equals.createExpression(OsPackage.eINSTANCE.getUser_UserId(),
// "db2admin"));
// requiredDb2AdminUser.getExpressions().add(Equals.createExpression(OsPackage.eINSTANCE.getUser_UserPassword(),
// "db2admin"));
		requiredDb2AdminUser
				.setLinkType(RequirementLinkTypes.DEPENDENCY_LITERAL);

		instanceUnit.getRequirements().add(requiredDb2AdminUser);
		instanceUnit.getRequirements().add(requiredDb2System);

// TODO add following metadata as well?
// <core:attributeMetaData xsi:type="core:AttributeMetaData"
// attributeName="portName" mutable="false"/>
		Port instanceConnectionPort = OsFactory.eINSTANCE.createPort();
		instanceConnectionPort.setName("instanceConnectionPort");
		instanceConnectionPort.setDisplayName("instanceConnectionPort");
		instanceConnectionPort
				.setLinkType(CapabilityLinkTypes.DEPENDENCY_LITERAL);
		instanceConnectionPort
				.setTransportLayerProtocol(TransportLayerProtocolType.TCP_LITERAL);
		instanceConnectionPort.setPortName("instanceConnectionPort");
		instanceConnectionPort.setPort(BigInteger.valueOf(50000));

// TODO add following metadata as well?
// <core:attributeMetaData xsi:type="core:AttributeMetaData"
// attributeName="portName" mutable="false"/>
		Port instanceInterruptPort = OsFactory.eINSTANCE.createPort();
		instanceInterruptPort.setName("instanceInterruptPort");
		instanceInterruptPort.setDisplayName("instanceInterruptPort");
		instanceInterruptPort
				.setLinkType(CapabilityLinkTypes.DEPENDENCY_LITERAL);
		instanceInterruptPort
				.setTransportLayerProtocol(TransportLayerProtocolType.TCP_LITERAL);
		instanceInterruptPort.setPortName("instanceInterruptPort");
		instanceInterruptPort.setPort(BigInteger.valueOf(50001));

		Requirement portConsumerReq = ValidatorTestUtils
				.createHostingRequirement(
						OsPackage.eINSTANCE.getPortConsumer(),
						"portConsumerReq");

		PortConfigUnit portConfigUnit = OsFactory.eINSTANCE
				.createPortConfigUnit();
		portConfigUnit.setName("portConfigUnit");
		portConfigUnit.setDisplayName("portConfigUnit");
		portConfigUnit.getCapabilities().add(instanceConnectionPort);
		portConfigUnit.getCapabilities().add(instanceInterruptPort);
		portConfigUnit.getRequirements().add(portConsumerReq);
		top.getUnits().add(portConfigUnit);

		ValidatorTestUtils.hosts(instanceUnit, portConfigUnit);

		UserUnit userUnit = OsFactory.eINSTANCE.createUserUnit();
		userUnit.setName("userUnit");
		top.getUnits().add(userUnit);

		User providedUser;
		providedUser = OsFactory.eINSTANCE.createUser();
		providedUser.setName("providedUser");
		providedUser.setUserId("db2admin");
		providedUser.setUserPassword("db2admin");
		providedUser.setLinkType(CapabilityLinkTypes.DEPENDENCY_LITERAL);

		DependencyLink db2AdminUserServiceLink = CoreFactory.eINSTANCE
				.createDependencyLink();
		db2AdminUserServiceLink.setTarget(providedUser);
		requiredDb2AdminUser.setLink(db2AdminUserServiceLink);
		ValidatorTestUtils.createLinkName(db2AdminUserServiceLink);

		Requirement requiredOSForUser = ValidatorTestUtils
				.createHostingRequirement(OsPackage.eINSTANCE
						.getOperatingSystem(), "requiredOSForUser");

		userUnit.getCapabilities().add(providedUser);
		userUnit.getRequirements().add(requiredOSForUser);

		//
		// System unit
		//

		DB2System providedSystem = Db2Factory.eINSTANCE.createDB2System();
		providedSystem.setName("providedSystem");
		providedSystem.setInstallDir("C:\\IBM\\SQLLIB");
		providedSystem.setDb2Version("8.1.0.36");

		Requirement requiredOs;
		requiredOs = CoreFactory.eINSTANCE.createRequirement();
		requiredOs.setDmoEType(OsPackage.eINSTANCE.getOperatingSystem());
		requiredOs.setName("requiredOs");
		EqualsConstraint ec1 = ConstraintFactory.eINSTANCE.createEqualsConstraint();
		ec1.setName("ec1");
		ec1.setValue(OperatingSystemType.WINDOWS_LITERAL.getLiteral());
		ec1.setAttributeName(OsPackage.eINSTANCE
				.getOperatingSystem_OsType().getName());
		EqualsConstraint ec2 = ConstraintFactory.eINSTANCE.createEqualsConstraint();
		ec2.setName("ec2");
		ec2.setValue("Win2k");
		ec2.setAttributeName(OsPackage.eINSTANCE
				.getOperatingSystem_OsVersion().getName());
		requiredOs.getConstraints().add(ec1);
		requiredOs.getConstraints().add(ec2);
		requiredOs.setLinkType(RequirementLinkTypes.HOSTING_LITERAL);

		systemUnit = Db2Factory.eINSTANCE.createDB2SystemUnit();
		systemUnit.setName("systemUnit");
		systemUnit.getHostingOrAnyCapabilities().add(providedSystem);
		systemUnit.getRequirements().add(requiredOs);
		top.getUnits().add(systemUnit);
		ValidatorTestUtils.hosts(systemUnit, instanceUnit);
		ValidatorTestUtils.hosts(systemUnit, instanceUnit2);

		OperatingSystem providedWinOs = OsFactory.eINSTANCE
				.createWindowsOperatingSystem();
		providedWinOs.setName("providedWinOs");
		providedWinOs.setOsType(OperatingSystemType.WINDOWS_LITERAL
				.getLiteral());
		providedWinOs.setHostname("test.ibm.com");

		OperatingSystemUnit osUnit = OsFactory.eINSTANCE
				.createOperatingSystemUnit();
		osUnit.setName("osUnit");
		osUnit.getHostingOrAnyCapabilities().add(providedWinOs);
		top.getUnits().add(osUnit);
		ValidatorTestUtils.hosts(osUnit, systemUnit);
		ValidatorTestUtils.hosts(osUnit, userUnit);

		// /////////
		top.getEObject().eResource().save(null);

		// /////////
		validator.validate(instanceUnit, context, reporter);
// assert instanceUnit.getStatus().getSeverity() != IStatus.OK;
		System.out.println("In " + this.getClass());
		dumpMarkers(top);
		assert (DeployMarker.getInstances(top).length == 0) : dumpMarkers(top);

		// Hostname not set
		String goodInstanceHostname = providedInstance.getHostname();
		String goodOsHostname = providedInstance.getHostname();
		providedInstance.setHostname(null);
		providedWinOs.setHostname(null);
		ValidatorTestUtils.assertValidationErrorCount(1, top, instanceUnit,
				context, reporter, validator);

		// Hostname length 0
		providedInstance.setHostname("");
		ValidatorTestUtils.assertValidationErrorCount(1, top, instanceUnit,
				context, reporter, validator);

		// Cleanup
		providedInstance.setHostname(goodInstanceHostname);
		providedWinOs.setHostname(goodOsHostname);
		ValidatorTestUtils.assertValidationErrorCount(0, top, instanceUnit,
				context, reporter, validator);

		// Hostname not same as OS hostname
		providedInstance.setHostname(goodInstanceHostname + ".foo");
		ValidatorTestUtils.assertValidationErrorCount(1, top, instanceUnit,
				context, reporter, validator);

		// Cleanup
		providedInstance.setHostname(goodInstanceHostname);
		ValidatorTestUtils.assertValidationErrorCount(0, top, instanceUnit,
				context, reporter, validator);

		// Instance name not set
		String goodInstanceName = providedInstance.getDb2InstanceName();
		providedInstance.setDb2InstanceName(null);
		ValidatorTestUtils.assertValidationErrorCount(1, top, instanceUnit,
				context, reporter, validator);

		// Instance name length 0
		providedInstance.setDb2InstanceName("");
		ValidatorTestUtils.assertValidationErrorCount(1, top, instanceUnit,
				context, reporter, validator);

		// Instance name invalid characters
		providedInstance.setDb2InstanceName("__&#");
		ValidatorTestUtils.assertValidationErrorCount(1, top, instanceUnit,
				context, reporter, validator);

		// Instance name too long
		providedInstance.setDb2InstanceName("AAAABBBBCCCCDDDD");
		ValidatorTestUtils.assertValidationErrorCount(1, top, instanceUnit,
				context, reporter, validator);

		// Instance name restricted prefix
		providedInstance.setDb2InstanceName("SYSAAAA");
		ValidatorTestUtils.assertValidationErrorCount(1, top, instanceUnit,
				context, reporter, validator);

		// Instance name restricted name
		providedInstance.setDb2InstanceName("ADMINS");
		ValidatorTestUtils.assertValidationErrorCount(1, top, instanceUnit,
				context, reporter, validator);

		// Cleanup
		providedInstance.setDb2InstanceName(goodInstanceName);
		ValidatorTestUtils.assertValidationErrorCount(0, top, instanceUnit,
				context, reporter, validator);

		// provided username vs OS userid
		String goodUserUserId = providedUser.getUserId();
		providedUser.setUserId(providedUser.getUserId() + "x");
// DeployMarker.deleteInstances(top);
// validator.validate(instanceUnit, context, reporter);
// dumpMarkers(top);
		ValidatorTestUtils.assertValidationErrorCountRange(1, 2, top,
				instanceUnit, context, reporter, validator);

		// Cleanup
		providedUser.setUserId(goodUserUserId);
		ValidatorTestUtils.assertValidationErrorCount(0, top, instanceUnit,
				context, reporter, validator);

		// provided password vs OS userpassword
		String goodUserUserPassword = providedUser.getUserPassword();
		providedUser.setUserPassword(providedUser.getUserPassword() + "x");
		ValidatorTestUtils.assertValidationErrorCountRange(1, 2, top,
				instanceUnit, context, reporter, validator);

		// Cleanup
		providedUser.setUserPassword(goodUserUserPassword);
		ValidatorTestUtils.assertValidationErrorCount(0, top, instanceUnit,
				context, reporter, validator);

		// Test adding extra capability of allowed type.
		instanceUnit.getHostingOrAnyCapabilities().add(providedInstance3);
		// port propagation from port config error as well
		ValidatorTestUtils.assertValidationErrorCount(2, top, instanceUnit,
				context, reporter, validator);
		instanceUnit.getCapabilities().remove(providedInstance3);
		ValidatorTestUtils.assertValidationErrorCount(0, top, instanceUnit,
				context, reporter, validator);

		// Test adding extra capability of disallowed type.
		// No longer valid test 2007/07/02
//		instanceUnit.getHostingOrAnyCapabilities().add(userGroupTest);
//		ValidatorTestUtils.assertValidationErrorCount(1, top, instanceUnit,
//				context, reporter, validator);
//		instanceUnit.getCapabilities().remove(userGroupTest);
//		ValidatorTestUtils.assertValidationErrorCount(0, top, instanceUnit,
//				context, reporter, validator);

		// Test adding extra requirement of allowed type.
		instanceUnit.getRequirements().add(requiredDb2System3);
		ValidatorTestUtils.assertValidationErrorCount(1, top, instanceUnit,
				context, reporter, validator);
		instanceUnit.getRequirements().remove(requiredDb2System3);
		ValidatorTestUtils.assertValidationErrorCount(0, top, instanceUnit,
				context, reporter, validator);

		// Test adding extra requirement of disallowed type.
		// No longer valid test 2007/07/02
//		instanceUnit.getRequirements().add(dummyRequiredDb2ClientTest);
//// validator.validate(instanceUnit, context, reporter);
//// dumpMarkers(top);
//		ValidatorTestUtils.assertValidationErrorCount(1, top, instanceUnit,
//				context, reporter, validator);
//		instanceUnit.getRequirements().remove(dummyRequiredDb2ClientTest);
//		ValidatorTestUtils.assertValidationErrorCount(0, top, instanceUnit,
//				context, reporter, validator);

		// Put both instances using same port
		BigInteger savedPort = providedInstance.getPort();
		providedInstance.setPort(providedInstance2.getPort());
		// instance->port not unique, instance->port does not match PortConfig
		ValidatorTestUtils.assertValidationErrorCount(2, top, instanceUnit,
				context, reporter, validator);
		providedInstance.setPort(savedPort);
		ValidatorTestUtils.assertValidationErrorCount(0, top, instanceUnit,
				context, reporter, validator);

		// PortNames on port config units not correct
		String goodPortName = instanceConnectionPort.getPortName();
		instanceConnectionPort.setPortName(goodPortName + goodPortName);
		ValidatorTestUtils.assertValidationErrorCount(1, top, instanceUnit,
				context, reporter, validator);
		instanceConnectionPort.setPortName(goodPortName);
		ValidatorTestUtils.assertValidationErrorCount(0, top, instanceUnit,
				context, reporter, validator);

		// "port" to null
		BigInteger goodPort = providedInstance.getPort();
		providedInstance.setPort(null);
		// DB2_INSTANCE_PORT_EMPTY_001 && DB2_INSTANCE_PORT_VALUE_001
		ValidatorTestUtils.assertValidationErrorCount(2, top, instanceUnit,
				context, reporter, validator);
		providedInstance.setPort(goodPort);
		ValidatorTestUtils.assertValidationErrorCount(0, top, instanceUnit,
				context, reporter, validator);

		HashSet set = new HashSet();

		// Missing link to user that qualifies as instance admin user.
		DependencyLink savedLink = requiredDb2AdminUser.getLink();
		requiredDb2AdminUser.setLink(null);
		ValidatorTestUtils.assertValidationErrorCount(2, top, instanceUnit,
				context, reporter, validator);
		set.add(IDB2ProblemType.INSTANCE_MISSING_LINK_TO_INSTANCE_ADMIN_USER);
		set.add(ICoreProblemType.UNIT_DEPENDENCY_REQUIREMENT_UNMATCHED);
		;
		assert (ValidatorTestUtils.topologyProblemTypesInSet(top, set));
		requiredDb2AdminUser.setLink(savedLink);
		ValidatorTestUtils.assertValidationErrorCount(0, top, instanceUnit,
				context, reporter, validator);

		// Missing link to user that qualifies as instance admin user - no such
		// user on hosting operating system
		// TODO fix
// savedLink = requiredDb2AdminUser.getLink();
// requiredDb2AdminUser.setLink(null);
// HostingLink hl = ValidatorUtils.getHostingLink(userUnit);
// osUnit.getHostingLinks().remove(hl);
// ValidatorTestUtils.assertValidationErrorCount(2, top, instanceUnit, context,
// reporter, validator);
// set.clear();
// set.add(IDB2ProblemType.INSTANCE_MISSING_LINK_TO_MISSING_INSTANCE_ADMIN_USER);
// set.add(ICoreProblemType.UNIT_DEPENDENCY_REQUIREMENT_UNMATCHED);;
// assert(ValidatorTestUtils.topologyProblemTypesInSet(top, set));
// requiredDb2AdminUser.setLink(savedLink);
// ValidatorTestUtils.hosts(osUnit, userUnit);
// ValidatorTestUtils.assertValidationErrorCount(0, top, instanceUnit, context,
// reporter, validator);

		// Add usergroup to the mix
		UserGroupUnit userGroupUnit = OsFactory.eINSTANCE
				.createWindowsLocalGroupUnit();
		userGroupUnit.setName("userGroupUnit");
		top.getUnits().add(userGroupUnit);
		UserGroup userGroup = OsFactory.eINSTANCE.createWindowsLocalGroup();
		userGroup.setName("userGroup");
		userGroup.setDisplayName("userGroup");
		userGroup.setGroupName("Administrators");
		userGroup.setLinkType(CapabilityLinkTypes.DEPENDENCY_LITERAL);
		userGroupUnit.getCapabilities().add(userGroup);
		Requirement requiredOSforUserGroup = ValidatorTestUtils
				.createHostingRequirement(OsPackage.eINSTANCE
						.getOperatingSystem(), "requiredOSforUserGroup");
		userGroupUnit.getRequirements().add(requiredOSforUserGroup);
		ValidatorTestUtils.hosts(osUnit, userGroupUnit);

		Requirement memberReqOut = CoreFactory.eINSTANCE.createRequirement();
		memberReqOut.setName("memberRequirementOut");
		memberReqOut.setLinkType(RequirementLinkTypes.MEMBER_LITERAL);
		memberReqOut.setDmoEType(OsPackage.eINSTANCE.getUserUnit());
		memberReqOut.setUse(RequirementUsage.REQUIRED_LITERAL);
		userGroupUnit.getRequirements().add(memberReqOut);

		MemberCardinalityConstraint mcc = ConstraintFactory.eINSTANCE.createMemberCardinalityConstraint();
		mcc.setName("mcc");
		memberReqOut.getConstraints().add(mcc);

		Requirement memberReqIn = CoreFactory.eINSTANCE.createRequirement();
		memberReqIn.setName("memberRequirementIn");
		memberReqIn.setLinkType(RequirementLinkTypes.MEMBER_LITERAL);
		memberReqIn.setDmoEType(OsPackage.eINSTANCE.getUserGroupUnit());
		memberReqIn.setUse(RequirementUsage.REQUIRED_LITERAL);
		userUnit.getRequirements().add(memberReqIn);
		
		GroupCardinalityConstraint gcc = ConstraintFactory.eINSTANCE.createGroupCardinalityConstraint();
		gcc.setName("gcc");
		memberReqIn.getConstraints().add(gcc);

		ValidatorTestUtils.member(userGroupUnit, userUnit);

		// Missing link to user that qualifies as instance admin user - no such
		// user on hosting operating system
		savedLink = requiredDb2AdminUser.getLink();
		requiredDb2AdminUser.setLink(null);
		save(top);
		ValidatorTestUtils.assertValidationErrorCount(2, top, instanceUnit,
				context, reporter, validator);
		set.clear();
		set.add(IDB2ProblemType.INSTANCE_MISSING_LINK_TO_INSTANCE_ADMIN_USER);
		set.add(ICoreProblemType.UNIT_DEPENDENCY_REQUIREMENT_UNMATCHED);
		System.out.println(ValidatorTestUtils.getTopologyErrorDescription(top));
		assert (ValidatorTestUtils.topologyProblemTypesInSet(top, set));

		String savedUserGroupName = userGroup.getGroupName();
		userGroup.setGroupName("X" + savedUserGroupName);
		ValidatorTestUtils.assertValidationErrorCount(2, top, instanceUnit,
				context, reporter, validator);
		set.clear();
		set
				.add(IDB2ProblemType.INSTANCE_MISSING_LINK_TO_MISSING_INSTANCE_ADMIN_USER);
		set.add(ICoreProblemType.UNIT_DEPENDENCY_REQUIREMENT_UNMATCHED);
		assert (ValidatorTestUtils.topologyProblemTypesInSet(top, set));

		userGroup.setGroupName(null);
		ValidatorTestUtils.assertValidationErrorCount(2, top, instanceUnit,
				context, reporter, validator);

		userGroup.setGroupName(savedUserGroupName);
		requiredDb2AdminUser.setLink(savedLink);
		ValidatorTestUtils.assertValidationErrorCount(0, top, instanceUnit,
				context, reporter, validator);
		// TODO tests for WindowsDB2Instance, UnixDB2Instance

	}
}
