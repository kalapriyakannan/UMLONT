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

import org.eclipse.core.runtime.CoreException;
import org.eclipse.emf.ecore.resource.Resource;

import com.ibm.ccl.soa.deploy.core.CapabilityLinkTypes;
import com.ibm.ccl.soa.deploy.core.CoreFactory;
import com.ibm.ccl.soa.deploy.core.Requirement;
import com.ibm.ccl.soa.deploy.core.RequirementLinkTypes;
import com.ibm.ccl.soa.deploy.core.Topology;
import com.ibm.ccl.soa.deploy.core.constraint.ConstraintFactory;
import com.ibm.ccl.soa.deploy.core.constraint.EqualsConstraint;
import com.ibm.ccl.soa.deploy.core.test.TopologyTestCase;
import com.ibm.ccl.soa.deploy.core.test.validator.utils.ValidatorTestUtils;
import com.ibm.ccl.soa.deploy.core.validator.IDeployReporter;
import com.ibm.ccl.soa.deploy.core.validator.IDeployValidationContext;
import com.ibm.ccl.soa.deploy.core.validator.expression.Equals;
import com.ibm.ccl.soa.deploy.db2.DB2Client;
import com.ibm.ccl.soa.deploy.db2.DB2JdbcDriver;
import com.ibm.ccl.soa.deploy.db2.DB2RuntimeClientUnit;
import com.ibm.ccl.soa.deploy.db2.Db2Factory;
import com.ibm.ccl.soa.deploy.db2.Db2Package;
import com.ibm.ccl.soa.deploy.db2.internal.validator.DB2RuntimeClientUnitValidator;
import com.ibm.ccl.soa.deploy.internal.core.validator.DeployMarker;
import com.ibm.ccl.soa.deploy.java.JdbcTypeType;
import com.ibm.ccl.soa.deploy.os.OperatingSystem;
import com.ibm.ccl.soa.deploy.os.OperatingSystemType;
import com.ibm.ccl.soa.deploy.os.OperatingSystemUnit;
import com.ibm.ccl.soa.deploy.os.OsFactory;
import com.ibm.ccl.soa.deploy.os.OsPackage;

/**
 * Tests {@link DB2RuntimeClientUnit}.
 * 
 * @author barnold
 * 
 */

public class DB2RuntimeClientUnitValidatorTest extends TopologyTestCase {

	private static final String PROJECT_NAME = "DB2RuntimeClientUnitValidatorTest";

	public DB2RuntimeClientUnitValidatorTest() {
		super(PROJECT_NAME);
	}

	/*
	 * @see junit.framework.TestCase#tearDown() Uncomment to stop deletion of
	 *      plants topology after test run.
	 */
	protected void tearDown() throws Exception {
	}

	public void testDB2RuntimeClientUnitValidator() throws IOException,
			CoreException {

		Topology top = createTopology("DB2DatabaseUnitValidator", true);

		IDeployValidationContext context = createValidationContext(top);
		IDeployReporter reporter = createDeployReporter();
		DB2RuntimeClientUnitValidator validator = new DB2RuntimeClientUnitValidator();

		//
		// Provided DB2 JDBC driver service
		//
		DB2JdbcDriver providedDb2JdbcDriver;
		providedDb2JdbcDriver = Db2Factory.eINSTANCE.createDB2JdbcDriver();
		providedDb2JdbcDriver.setName("providedDb2JdbcDriver");
		providedDb2JdbcDriver.setJdbcType(JdbcTypeType._2_LITERAL);
		providedDb2JdbcDriver.setClasspath("C:/IBM/SQLLIB/java/db2java.zip");
		providedDb2JdbcDriver.setClassname("com.ibm.DB2CPoolDS");

		DB2Client providedDB2Client = Db2Factory.eINSTANCE.createDB2Client();
		providedDB2Client.setName("providedDB2Client");
		providedDB2Client.setInstallDir("C:\\IBM\\SQLLIB");
		providedDB2Client.setDb2ClientVersion("8.1.0.36");
		providedDB2Client.setLinkType(CapabilityLinkTypes.ANY_LITERAL);

		DB2RuntimeClientUnit runtimeClientUnit = Db2Factory.eINSTANCE
				.createDB2RuntimeClientUnit();
		runtimeClientUnit.setName("runtimeClientUnit");
		runtimeClientUnit.getCapabilities().add(providedDB2Client);
		runtimeClientUnit.getOnlyDependencyCapabilities().add(
				providedDb2JdbcDriver);
		top.getUnits().add(runtimeClientUnit);

		OperatingSystemUnit operatingSystemUnit = OsFactory.eINSTANCE
				.createOperatingSystemUnit();
		operatingSystemUnit.setName("operatingSystemUnit");
		top.getUnits().add(operatingSystemUnit);

		Requirement requiredOperatingSystem = CoreFactory.eINSTANCE
				.createRequirement();
		requiredOperatingSystem.setName("requiredOperatingSystem");
		requiredOperatingSystem.setDmoEType(OsPackage.eINSTANCE
				.getOperatingSystem());
		EqualsConstraint ec1 = ConstraintFactory.eINSTANCE.createEqualsConstraint();
		ec1.setName("ec1");
		ec1.setValue(OperatingSystemType.WINDOWS_LITERAL.getLiteral());
		ec1.setAttributeName(OsPackage.eINSTANCE
				.getOperatingSystem_OsType().getName());
		requiredOperatingSystem.getConstraints().add(ec1);
		requiredOperatingSystem
				.setLinkType(RequirementLinkTypes.HOSTING_LITERAL);
		runtimeClientUnit.getRequirements().add(requiredOperatingSystem);

		OperatingSystem providedWindowsOperatingSystem = OsFactory.eINSTANCE
				.createWindowsOperatingSystem();
		providedWindowsOperatingSystem
				.setName("providedWindowsOperatingSystem");
		providedWindowsOperatingSystem
				.setOsType(OperatingSystemType.WINDOWS_LITERAL.getLiteral());
		providedWindowsOperatingSystem.setOsVersion("Win2K");
		operatingSystemUnit.getHostingOrAnyCapabilities().add(
				providedWindowsOperatingSystem);

		ValidatorTestUtils.hosts(operatingSystemUnit, runtimeClientUnit);

		// /////////
		Resource res = top.getEObject().eResource();
		res.save(null);
		// /////////

		validator.validate(runtimeClientUnit, context, reporter);
// assert instanceUnit.getStatus().getSeverity() != IStatus.OK;
		System.out.println("In " + this.getClass());
		dumpMarkers(top);
		assert (DeployMarker.getInstances(top).length == 0);

		// jdbcType not 2 or 4
		JdbcTypeType goodJdbcType = providedDb2JdbcDriver.getJdbcType();
		providedDb2JdbcDriver.setJdbcType(JdbcTypeType._1_LITERAL);
		ValidatorTestUtils.assertValidationErrorCount(1, top,
				runtimeClientUnit, context, reporter, validator);
		providedDb2JdbcDriver.setJdbcType(goodJdbcType);

		// installDir not valid for windows hosting OS
		String goodInstallDir = providedDB2Client.getInstallDir();
		providedDB2Client.setInstallDir("/opt");
		ValidatorTestUtils.assertValidationErrorCount(1, top,
				runtimeClientUnit, context, reporter, validator);
		providedDB2Client.setInstallDir("C:/IBM/SQLLIB");
		ValidatorTestUtils.assertValidationErrorCount(1, top,
				runtimeClientUnit, context, reporter, validator);
		providedDB2Client.setInstallDir("C:\\IBM\\SQL:LIB");
		ValidatorTestUtils.assertValidationErrorCount(1, top,
				runtimeClientUnit, context, reporter, validator);
		providedDB2Client.setInstallDir("C:\\IBM\\SQL?LIB");
		ValidatorTestUtils.assertValidationErrorCount(1, top,
				runtimeClientUnit, context, reporter, validator);
		providedDB2Client.setInstallDir("C:\\IBM\\SQL<LIB");
		ValidatorTestUtils.assertValidationErrorCount(1, top,
				runtimeClientUnit, context, reporter, validator);
		providedDB2Client.setInstallDir("C:\\IBM\\SQL>LIB");
		ValidatorTestUtils.assertValidationErrorCount(1, top,
				runtimeClientUnit, context, reporter, validator);
		providedDB2Client.setInstallDir("C:\\IBM\\SQL*LIB");
		ValidatorTestUtils.assertValidationErrorCount(1, top,
				runtimeClientUnit, context, reporter, validator);
		providedDB2Client.setInstallDir("C:\\IBM\\SQL|LIB");
		ValidatorTestUtils.assertValidationErrorCount(1, top,
				runtimeClientUnit, context, reporter, validator);
		providedDB2Client.setInstallDir("C:\\IBM\\SQL\"LIB");
		ValidatorTestUtils.assertValidationErrorCount(1, top,
				runtimeClientUnit, context, reporter, validator);
		providedDB2Client.setInstallDir("C:\\IBM\\SQL" + (char) 0x1a + "LIB");
		ValidatorTestUtils.assertValidationErrorCount(1, top,
				runtimeClientUnit, context, reporter, validator);
		providedDB2Client.setInstallDir(goodInstallDir);
		ValidatorTestUtils.assertValidationErrorCount(0, top,
				runtimeClientUnit, context, reporter, validator);

		String goodClassname = providedDb2JdbcDriver.getClassname();
		providedDb2JdbcDriver.setClassname("a-b-c");
		ValidatorTestUtils.assertValidationErrorCount(1, top,
				runtimeClientUnit, context, reporter, validator);
		providedDb2JdbcDriver.setClassname(goodClassname);
		ValidatorTestUtils.assertValidationErrorCount(0, top,
				runtimeClientUnit, context, reporter, validator);
	}
}
