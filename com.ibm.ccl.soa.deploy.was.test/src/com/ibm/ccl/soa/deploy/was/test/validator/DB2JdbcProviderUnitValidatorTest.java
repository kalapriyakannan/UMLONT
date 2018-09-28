/*******************************************************************************
 * Copyright (c) 2003, 2007 IBM Corporation Licensed Material - Property of IBM. All rights reserved.
 *  
 * US Government Users Restricted Rights - Use, duplication or disclosure v1.0 restricted by GSA ADP
 * Schedule Contract with IBM Corp.
 * 
 * Contributors: IBM Corporation - initial API and implementation
 *******************************************************************************/
package com.ibm.ccl.soa.deploy.was.test.validator;

import java.io.IOException;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.emf.ecore.resource.Resource;

import com.ibm.ccl.soa.deploy.core.CapabilityLinkTypes;
import com.ibm.ccl.soa.deploy.core.CoreFactory;
import com.ibm.ccl.soa.deploy.core.DependencyLink;
import com.ibm.ccl.soa.deploy.core.Requirement;
import com.ibm.ccl.soa.deploy.core.Topology;
import com.ibm.ccl.soa.deploy.core.test.TopologyTestCase;
import com.ibm.ccl.soa.deploy.core.test.validator.utils.ValidatorTestUtils;
import com.ibm.ccl.soa.deploy.core.validator.IDeployReporter;
import com.ibm.ccl.soa.deploy.core.validator.IDeployValidationContext;
import com.ibm.ccl.soa.deploy.db2.DB2JdbcDriver;
import com.ibm.ccl.soa.deploy.db2.DB2SystemUnit;
import com.ibm.ccl.soa.deploy.db2.Db2Factory;
import com.ibm.ccl.soa.deploy.db2.Db2Package;
import com.ibm.ccl.soa.deploy.java.JdbcTypeType;
import com.ibm.ccl.soa.deploy.was.DB2JdbcProvider;
import com.ibm.ccl.soa.deploy.was.DB2JdbcProviderType;
import com.ibm.ccl.soa.deploy.was.DB2JdbcProviderUnit;
import com.ibm.ccl.soa.deploy.was.WasConfigurationContainer;
import com.ibm.ccl.soa.deploy.was.WasFactory;
import com.ibm.ccl.soa.deploy.was.WasPackage;
import com.ibm.ccl.soa.deploy.was.WasServer;
import com.ibm.ccl.soa.deploy.was.WebsphereAppServerUnit;
import com.ibm.ccl.soa.deploy.was.internal.validator.DB2JdbcProviderUnitValidator;

/**
 * Tests {@link DB2JdbcProviderUnit}.
 */
/**
 * @author barnold
 * 
 */

public class DB2JdbcProviderUnitValidatorTest extends TopologyTestCase {

	private static final String PROJECT_NAME = "DB2JdbcProviderUnitValidatorTest";

	/**
	 * 
	 */
	public DB2JdbcProviderUnitValidatorTest() {
		super(PROJECT_NAME);
	}

	/*
	 * @see junit.framework.TestCase#tearDown() Uncomment to stop deletion of
	 *      plants topology after test run.
	 */
	protected void tearDown() throws Exception {
	}

	/**
	 * @throws IOException
	 * @throws CoreException
	 */
	public void testDB2JdbcProviderUnitValidator() throws IOException,
			CoreException {

		Topology top = createTopology("DB2DatabaseUnitValidator", true);

		IDeployValidationContext context = createValidationContext(top);
		IDeployReporter reporter = createDeployReporter();
		DB2JdbcProviderUnitValidator validator = new DB2JdbcProviderUnitValidator();

		// TODO do incremental testing to force each validation message

		// Jdbc provider/driver
		DB2JdbcProvider providedDb2JdbcProvider = WasFactory.eINSTANCE
				.createDB2JdbcProvider();
		providedDb2JdbcProvider.setName("providedDb2JdbcProvider");
		providedDb2JdbcProvider.setDisplayName("providedDb2JdbcProvider");
		providedDb2JdbcProvider.setJdbcType(JdbcTypeType._2_LITERAL);
		providedDb2JdbcProvider.setLinkType(CapabilityLinkTypes.ANY_LITERAL);
		providedDb2JdbcProvider
				.setProviderType(DB2JdbcProviderType.DB2_LEGACY_CLI_BASED_TYPE2_JDBC_DRIVER_LITERAL
						.toString());
		providedDb2JdbcProvider
				.setProviderName(DB2JdbcProviderType.DB2_LEGACY_CLI_BASED_TYPE2_JDBC_DRIVER_LITERAL
						.toString());
		providedDb2JdbcProvider.setClasspath("C:/IBM/SQLLIB/java/db2java.zip");

		DB2JdbcProviderUnit db2JdbcProviderUnit;
		db2JdbcProviderUnit = WasFactory.eINSTANCE.createDB2JdbcProviderUnit();
		db2JdbcProviderUnit.setName("Db2JdbcProviderUnit");
		db2JdbcProviderUnit.setDisplayName("Db2JdbcProviderUnit");
		db2JdbcProviderUnit.getCapabilities().add(providedDb2JdbcProvider);
		top.getUnits().add(db2JdbcProviderUnit);

		Requirement requiredDb2JdbcDriver;
		requiredDb2JdbcDriver = ValidatorTestUtils.createDependencyRequirement(
				Db2Package.Literals.DB2_JDBC_DRIVER, "requiredDb2JdbcDriver");
		ValidatorTestUtils.addEqualsExpression(requiredDb2JdbcDriver,
				Db2Package.Literals.DB2_JDBC_DRIVER__JDBC_TYPE,
				JdbcTypeType._2_LITERAL);
		db2JdbcProviderUnit.getRequirements().add(requiredDb2JdbcDriver);

		Requirement requiredHostingWasConfigurationContainer = ValidatorTestUtils
				.createHostingRequirement(WasPackage.eINSTANCE
						.getWasConfigurationContainer(),
						"requiredHostingWasConfigurationContainer");
		db2JdbcProviderUnit.getRequirements().add(
				requiredHostingWasConfigurationContainer);

		WasConfigurationContainer wasConfigurationContainer = WasFactory.eINSTANCE
				.createWasConfigurationContainer();
		wasConfigurationContainer.setName("wasConfigurationContainer");
		wasConfigurationContainer.setDisplayName("wasConfigurationContainer");
		wasConfigurationContainer.setLinkType(CapabilityLinkTypes.ANY_LITERAL);

		// Was v5.1 server unit
		WebsphereAppServerUnit was51ServerUnit;
		was51ServerUnit = WasFactory.eINSTANCE.createWebsphereAppServerUnit();
		was51ServerUnit.setDisplayName("WebSphsere51AppServerUnit");
		was51ServerUnit.setName("Was51ServerUnit");
		top.getUnits().add(was51ServerUnit);

		// Provide was 51 server service
		WasServer wasProvided51ServerService;
		wasProvided51ServerService = WasFactory.eINSTANCE.createWasServer();
		wasProvided51ServerService.setName("ProvidedWas51ServerService");
		wasProvided51ServerService
				.setDisplayName("Provided Was51 Server Capability");
		wasProvided51ServerService.setWasVersion("5.1");
		was51ServerUnit.getHostingOrAnyCapabilities().add(
				wasProvided51ServerService);
		was51ServerUnit.getCapabilities().add(wasConfigurationContainer);

		ValidatorTestUtils.hosts(was51ServerUnit, db2JdbcProviderUnit);

		//
		DB2SystemUnit db2SystemUnit = Db2Factory.eINSTANCE
				.createDB2SystemUnit();
		db2SystemUnit.setName("db2SystemUnit");
		top.getUnits().add(db2SystemUnit);

		DB2JdbcDriver providedDb2JdbcDriver = Db2Factory.eINSTANCE
				.createDB2JdbcDriver();
		providedDb2JdbcDriver.setName("providedDb2JdbcDriver");
		providedDb2JdbcDriver.setJdbcType(JdbcTypeType._2_LITERAL);
		db2SystemUnit.getOnlyDependencyCapabilities()
				.add(providedDb2JdbcDriver);

		// Link between jdbc provider and WAS
		DependencyLink db2JdbcDriverServiceLink = CoreFactory.eINSTANCE
				.createDependencyLink();
		db2JdbcDriverServiceLink.setTarget(providedDb2JdbcDriver);
		requiredDb2JdbcDriver.setLink(db2JdbcDriverServiceLink);
		ValidatorTestUtils.createLinkName(db2JdbcDriverServiceLink);

		// /////////
		Resource res = top.getEObject().eResource();
		res.save(null);
		// /////////

		validator.validate(db2JdbcProviderUnit, context, reporter);
// assert instanceUnit.getStatus().getSeverity() != IStatus.OK;
		System.out.println("In " + this.getClass());
		dumpMarkers(top);

		providedDb2JdbcProvider.setNativepath("a/Program Files/IBM/SQLLIB/lib");
		ValidatorTestUtils.assertValidationErrorCount(1, top,
				db2JdbcProviderUnit, context, reporter, validator);
		providedDb2JdbcProvider
				.setNativepath("c:/Program Files/IBM/SQLLIB/lib");
		ValidatorTestUtils.assertValidationErrorCount(0, top,
				db2JdbcProviderUnit, context, reporter, validator);

		String savedClasspath = providedDb2JdbcProvider.getClasspath();
		providedDb2JdbcProvider
				.setClasspath("D:/IBM/SQLLIB/java/db2jcc_license_cu.jar;D:/IBM/SQLLIB/java/db2java.zip;D:/IBM/SQLLIB/java/db2jcc.jar;D:/IBM/SQLLIB/java/db2jcc_javax.jar");
		ValidatorTestUtils.assertValidationErrorCount(0, top,
				db2JdbcProviderUnit, context, reporter, validator);
		providedDb2JdbcProvider
				.setClasspath("D:/IBM/SQLLIB/java/db2jcc_license_cu.jar;D:/IBM/SQLLIB/java/db2java.zoo;D:/IBM/SQLLIB/java/db2jcc.jar;D:/IBM/SQLLIB/java/db2jcc_javax.jar");
		ValidatorTestUtils.assertValidationErrorCount(1, top,
				db2JdbcProviderUnit, context, reporter, validator);
		providedDb2JdbcProvider
				.setClasspath("D:/IBM/SQLLIB/java/db2jcc_license_cu.jar;D:/IBM/SQLLIB/java/db2java.zip;D:/IBM/SQLLIB/java/db2jcc.jar;D:/IBM/SQLLIB/java/db2jcc_javax.jam");
		ValidatorTestUtils.assertValidationErrorCount(1, top,
				db2JdbcProviderUnit, context, reporter, validator);
		providedDb2JdbcProvider
				.setClasspath("foo;D:/IBM/SQLLIB/java/db2jcc_license_cu.jar;D:/IBM/SQLLIB/java/db2java.zip;D:/IBM/SQLLIB/java/db2jcc.jar;D:/IBM/SQLLIB/java/db2jcc_javax.jar");
		ValidatorTestUtils.assertValidationErrorCount(1, top,
				db2JdbcProviderUnit, context, reporter, validator);
		providedDb2JdbcProvider
				.setClasspath("foo.jar;D:/IBM/SQLLIB/java/db2jcc_license_cu.jar;D:/IBM/SQLLIB/java/db2java.zip;D:/IBM/SQLLIB/java/db2jcc.jar;D:/IBM/SQLLIB/java/db2jcc_javax.jar");
		ValidatorTestUtils.assertValidationErrorCount(1, top,
				db2JdbcProviderUnit, context, reporter, validator);
		providedDb2JdbcProvider
				.setClasspath("D:\\IBM\\SQLLIB\\java\\db2jcc_license_cu.jar;D:\\IBM\\SQLLIB\\java\\db2java.zip;D:\\IBM\\SQLLIB\\java\\db2jcc.jar;D:\\IBM\\SQLLIB\\java\\db2jcc_javax.jar");
		ValidatorTestUtils.assertValidationErrorCount(0, top,
				db2JdbcProviderUnit, context, reporter, validator);

		providedDb2JdbcProvider.setClasspath(savedClasspath);
		ValidatorTestUtils.assertValidationErrorCount(0, top,
				db2JdbcProviderUnit, context, reporter, validator);

		// TODO test remote DB2JDBCDriver error check.
	}
}
