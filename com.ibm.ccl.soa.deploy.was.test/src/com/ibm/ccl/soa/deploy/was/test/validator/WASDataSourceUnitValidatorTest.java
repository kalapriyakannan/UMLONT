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
import com.ibm.ccl.soa.deploy.core.RequirementUsage;
import com.ibm.ccl.soa.deploy.core.Topology;
import com.ibm.ccl.soa.deploy.core.test.TopologyTestCase;
import com.ibm.ccl.soa.deploy.core.test.validator.utils.ValidatorTestUtils;
import com.ibm.ccl.soa.deploy.core.validator.IDeployReporter;
import com.ibm.ccl.soa.deploy.core.validator.IDeployValidationContext;
import com.ibm.ccl.soa.deploy.db2.DB2CatalogUnit;
import com.ibm.ccl.soa.deploy.db2.DB2Database;
import com.ibm.ccl.soa.deploy.db2.Db2Factory;
import com.ibm.ccl.soa.deploy.db2.Db2Package;
import com.ibm.ccl.soa.deploy.java.JdbcTypeType;
import com.ibm.ccl.soa.deploy.was.DB2JdbcProvider;
import com.ibm.ccl.soa.deploy.was.DB2JdbcProviderUnit;
import com.ibm.ccl.soa.deploy.was.WASJ2CAuthenticationDataEntry;
import com.ibm.ccl.soa.deploy.was.WASJ2CAuthenticationUnit;
import com.ibm.ccl.soa.deploy.was.WasDatasourceUnit;
import com.ibm.ccl.soa.deploy.was.WasFactory;
import com.ibm.ccl.soa.deploy.was.WasPackage;
import com.ibm.ccl.soa.deploy.was.WasServer;
import com.ibm.ccl.soa.deploy.was.WasV5Datasource;
import com.ibm.ccl.soa.deploy.was.WebsphereAppServerUnit;
import com.ibm.ccl.soa.deploy.was.internal.validator.WasDatasourceUnitValidator;

/**
 * Tests {@link WasDataSourceUnit}.
 */
/**
 * @author barnold
 * 
 */

public class WASDataSourceUnitValidatorTest extends TopologyTestCase {

	private static final String PROJECT_NAME = "WASDataSourceUnitValidatorTest";

	/**
	 * 
	 */
	public WASDataSourceUnitValidatorTest() {
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
	public void testWASDataSourceUnitValidator() throws IOException,
			CoreException {

		Topology top = createTopology("WASDatasourceUnitValidator", true);

		IDeployValidationContext context = createValidationContext(top);
		IDeployReporter reporter = createDeployReporter();
		WasDatasourceUnitValidator validator = new WasDatasourceUnitValidator(
				WasPackage.Literals.WAS_DATASOURCE_UNIT);

		// TODO do incremental testing to force each validation message

		// Jdbc provider/driver
		WasV5Datasource providedWasV5Datasource = WasFactory.eINSTANCE
				.createWasV5Datasource();
		providedWasV5Datasource.setName("providedWasDatasource");
		providedWasV5Datasource
				.setLinkType(CapabilityLinkTypes.DEPENDENCY_LITERAL);
		providedWasV5Datasource.setJndiName("SomeJNDIName");
		providedWasV5Datasource.setDatasourceName("SomeName");
		providedWasV5Datasource.setDbName("Foo");
		providedWasV5Datasource.setJ2cAuthAlias("alias");

		WasDatasourceUnit wasDatasourceUnit;
		wasDatasourceUnit = WasFactory.eINSTANCE.createWasDatasourceUnit();
		wasDatasourceUnit.setName("wasDatasourceUnit");
		wasDatasourceUnit.getOnlyDependencyCapabilities().add(
				providedWasV5Datasource);
		top.getUnits().add(wasDatasourceUnit);

		Requirement requiredDb2JdbcProvider;
		requiredDb2JdbcProvider = ValidatorTestUtils.createHostingRequirement(
				WasPackage.Literals.DB2_JDBC_PROVIDER,
				"requiredHostingDb2JdbcProvider");
// ValidatorTestUtils.addEqualsExpression(requiredDb2JdbcProvider,
// Db2Package.Literals.DB2_JDBC_DRIVER__JDBC_TYPE,
// JdbcTypeType._2_LITERAL);
		wasDatasourceUnit.getRequirements().add(requiredDb2JdbcProvider);

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

		//
// DB2SystemUnit db2SystemUnit = Db2Factory.eINSTANCE.createDB2SystemUnit();
// db2SystemUnit.setName("db2SystemUnit");
// top.getUnits().add( db2SystemUnit );

		DB2JdbcProviderUnit db2JdbcProviderUnit = WasFactory.eINSTANCE
				.createDB2JdbcProviderUnit();
		db2JdbcProviderUnit.setName("db2JdbcProviderUnit");
		db2JdbcProviderUnit.setDisplayName("db2JdbcProviderUnit");
		top.getUnits().add(db2JdbcProviderUnit);

		DB2JdbcProvider providedDb2JdbcProvider = WasFactory.eINSTANCE
				.createDB2JdbcProvider();
		providedDb2JdbcProvider.setName("providedDb2JdbcProvider");
		providedDb2JdbcProvider.setJdbcType(JdbcTypeType._2_LITERAL);
		providedDb2JdbcProvider
				.setLinkType(CapabilityLinkTypes.DEPENDENCY_LITERAL);
		// db2SystemUnit.getCapabilities().add(providedDb2JdbcProvider);
		db2JdbcProviderUnit.getCapabilities().add(providedDb2JdbcProvider);

		WASJ2CAuthenticationDataEntry providedWASJ2CAuthenticationDataEntry = WasFactory.eINSTANCE
				.createWASJ2CAuthenticationDataEntry();
		providedWASJ2CAuthenticationDataEntry
				.setName("providedWASJ2CAuthenticationDataEntry");
		providedWASJ2CAuthenticationDataEntry.setAlias("alias");
		providedWASJ2CAuthenticationDataEntry
				.setLinkType(CapabilityLinkTypes.DEPENDENCY_LITERAL);

		WASJ2CAuthenticationUnit wasJ2CAuthenticationUnit = WasFactory.eINSTANCE
				.createWASJ2CAuthenticationUnit();
		wasJ2CAuthenticationUnit.setName("wasJ2CAuthenticationUnit");
		top.getUnits().add(wasJ2CAuthenticationUnit);
		wasJ2CAuthenticationUnit.getCapabilities().add(
				providedWASJ2CAuthenticationDataEntry);

		Requirement wasDatasourceDB2DatabaseReq = ValidatorTestUtils
				.createDependencyRequirement(Db2Package.eINSTANCE
						.getDB2Database(), "wasDatasourceDB2DatabaseReq");

		// Link between WAS datasource and was j2c authentication data entry
		DependencyLink wasJ2CAuthenticationLink = CoreFactory.eINSTANCE
				.createDependencyLink();
		wasJ2CAuthenticationLink
				.setTarget(providedWASJ2CAuthenticationDataEntry);
		Requirement wasJ2CAuthenticationReq = ValidatorTestUtils
				.createDependencyRequirement(WasPackage.eINSTANCE
						.getWASJ2CAuthenticationDataEntry(),
						"WASJ2CAuthenticationDataEntry",
						"getWASJ2CAuthenticationDataEntry");
		wasJ2CAuthenticationReq.setLink(wasJ2CAuthenticationLink);
		ValidatorTestUtils.createLinkName(wasJ2CAuthenticationLink);
		wasDatasourceUnit.getRequirements().add(wasJ2CAuthenticationReq);

		DB2CatalogUnit db2CatalogUnit = Db2Factory.eINSTANCE
				.createDB2CatalogUnit();
		db2CatalogUnit.setName("db2CatalogUnit");
		db2CatalogUnit.setDisplayName("db2CatalogUnit");
		top.getUnits().add(db2CatalogUnit);

		DB2Database db2DatabaseCap = Db2Factory.eINSTANCE.createDB2Database();
		db2DatabaseCap.setName("db2DatabaseCap");
		db2DatabaseCap.setDisplayName("db2DatabaseCap");
		db2DatabaseCap.setLinkType(CapabilityLinkTypes.DEPENDENCY_LITERAL);
		db2CatalogUnit.getCapabilities().add(db2DatabaseCap);

// ValidatorTestUtils.createLinkName(db2JdbcProviderServiceLink);

		// Hosting link between jdbc provider and WAS datasource
		ValidatorTestUtils.hosts(db2JdbcProviderUnit, wasDatasourceUnit);
		ValidatorTestUtils.hosts(was51ServerUnit, db2JdbcProviderUnit);

		// Link between datasource and db2 database (on db2 catalog)
		DependencyLink WasDatasourceToDB2DatabaseDependencyLink = CoreFactory.eINSTANCE
				.createDependencyLink();
		WasDatasourceToDB2DatabaseDependencyLink.setTarget(db2DatabaseCap);
		wasDatasourceDB2DatabaseReq
				.setLink(WasDatasourceToDB2DatabaseDependencyLink);
		ValidatorTestUtils
				.createLinkName(WasDatasourceToDB2DatabaseDependencyLink);

		// /////////////////
		Resource res = top.getEObject().eResource();
		res.save(null);
		// /////////////////

		validator.validate(wasDatasourceUnit, context, reporter);
// assert instanceUnit.getStatus().getSeverity() != IStatus.OK;
		System.out.println("In " + this.getClass());
		dumpMarkers(top);
		ValidatorTestUtils.assertValidationErrorCount(0, top,
				wasDatasourceUnit, context, reporter, validator);

		String savedAlias = providedWasV5Datasource.getJ2cAuthAlias();
		providedWasV5Datasource
				.setJ2cAuthAlias(providedWASJ2CAuthenticationDataEntry
						.getAlias()
						+ "x");
		ValidatorTestUtils.assertValidationErrorCount(1, top,
				wasDatasourceUnit, context, reporter, validator);
		providedWasV5Datasource.setJ2cAuthAlias(null);
		// j2cAuthAlias is invalid, and it can be propagated from a valid value
		ValidatorTestUtils.assertValidationErrorCount(2, top,
				wasDatasourceUnit, context, reporter, validator);
		providedWasV5Datasource.setJ2cAuthAlias(savedAlias);
		ValidatorTestUtils.assertValidationErrorCount(0, top,
				wasDatasourceUnit, context, reporter, validator);

		providedWasV5Datasource.setJ2cAuthAlias("");
		RequirementUsage savedRequirementUsage = wasJ2CAuthenticationReq
				.getUse();
		wasJ2CAuthenticationReq.setUse(RequirementUsage.OPTIONAL_LITERAL);
		DependencyLink savedDL = wasJ2CAuthenticationReq.getLink();
		wasJ2CAuthenticationReq.setLink(null);
		ValidatorTestUtils.assertValidationErrorCount(0, top,
				wasDatasourceUnit, context, reporter, validator);
		wasJ2CAuthenticationReq.setUse(savedRequirementUsage);
		wasJ2CAuthenticationReq.setLink(savedDL);
		// j2cAuthAlias is invalid (empty string), and it can be propagated from
		// a valid value
		ValidatorTestUtils.assertValidationErrorCount(2, top,
				wasDatasourceUnit, context, reporter, validator);
		providedWasV5Datasource.setJ2cAuthAlias(savedAlias);
		ValidatorTestUtils.assertValidationErrorCount(0, top,
				wasDatasourceUnit, context, reporter, validator);

		// TODO fill in test cases.
	}
}
