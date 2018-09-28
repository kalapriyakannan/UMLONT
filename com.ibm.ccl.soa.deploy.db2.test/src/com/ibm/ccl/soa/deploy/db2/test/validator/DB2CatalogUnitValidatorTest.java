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

import org.eclipse.core.runtime.CoreException;
import org.eclipse.emf.ecore.resource.Resource;

import com.ibm.ccl.soa.deploy.core.Capability;
import com.ibm.ccl.soa.deploy.core.CapabilityLinkTypes;
import com.ibm.ccl.soa.deploy.core.CoreFactory;
import com.ibm.ccl.soa.deploy.core.DependencyLink;
import com.ibm.ccl.soa.deploy.core.Requirement;
import com.ibm.ccl.soa.deploy.core.RequirementLinkTypes;
import com.ibm.ccl.soa.deploy.core.Topology;
import com.ibm.ccl.soa.deploy.core.constraint.ConstraintFactory;
import com.ibm.ccl.soa.deploy.core.constraint.EqualsConstraint;
import com.ibm.ccl.soa.deploy.core.test.TopologyTestCase;
import com.ibm.ccl.soa.deploy.core.test.validator.utils.ValidatorTestUtils;
import com.ibm.ccl.soa.deploy.core.validator.IDeployReporter;
import com.ibm.ccl.soa.deploy.core.validator.IDeployValidationContext;
import com.ibm.ccl.soa.deploy.db2.DB2CatalogUnit;
import com.ibm.ccl.soa.deploy.db2.DB2CatalogedNode;
import com.ibm.ccl.soa.deploy.db2.DB2Client;
import com.ibm.ccl.soa.deploy.db2.DB2ClientInstance;
import com.ibm.ccl.soa.deploy.db2.DB2ClientInstanceUnit;
import com.ibm.ccl.soa.deploy.db2.DB2Database;
import com.ibm.ccl.soa.deploy.db2.DB2DatabaseUnit;
import com.ibm.ccl.soa.deploy.db2.DB2Instance;
import com.ibm.ccl.soa.deploy.db2.DB2InstanceUnit;
import com.ibm.ccl.soa.deploy.db2.DB2NodeCatalogUnit;
import com.ibm.ccl.soa.deploy.db2.DB2RuntimeClientUnit;
import com.ibm.ccl.soa.deploy.db2.Db2Factory;
import com.ibm.ccl.soa.deploy.db2.Db2Package;
import com.ibm.ccl.soa.deploy.db2.internal.validator.DB2CatalogUnitValidator;

/**
 * Tests {@link DB2CatalogUnit}.
 * 
 * @author barnold
 */
public class DB2CatalogUnitValidatorTest extends TopologyTestCase {

	private static final String PROJECT_NAME = "DB2CatalogUnitValidatorTest";
	private DB2RuntimeClientUnit db2RuntimeClientUnit;
	private DB2ClientInstanceUnit db2ClientInstanceUnit;

	public DB2CatalogUnitValidatorTest() {
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
	public void testDB2CatalogUnitValidator() throws IOException, CoreException {

		Topology top = createTopology("DB2CatalogUnitValidator", true);

		IDeployValidationContext context = createValidationContext(top);
		IDeployReporter reporter = createDeployReporter();
		DB2CatalogUnitValidator validator = new DB2CatalogUnitValidator();

		//
		// DB2 database service (cataloged)
		//
		DB2Database providedDb2CDatabase = Db2Factory.eINSTANCE
				.createDB2Database();
		providedDb2CDatabase.setName("providedDb2CDatabase");
		providedDb2CDatabase.setDbName("PLANTSBY");
		providedDb2CDatabase.setDbAlias("PLANTSBY");
		providedDb2CDatabase.setDbDrive("C:/DB2");

		//
		// Required DB2 cataloged node service
		//
		Requirement requiredDb2CatalogedNode = CoreFactory.eINSTANCE
				.createRequirement();
		requiredDb2CatalogedNode.setName("requiredDb2CatalogedNode");
		requiredDb2CatalogedNode
				.setLinkType(RequirementLinkTypes.HOSTING_LITERAL);
		requiredDb2CatalogedNode.setDmoEType(Db2Package.eINSTANCE
				.getDB2CatalogedNode());

		//
		// Required DB2 database service (remote one that is aliased)
		//
		Requirement requiredDb2DatabasePlantsBy = CoreFactory.eINSTANCE
				.createRequirement();
		requiredDb2DatabasePlantsBy.setName("requiredDb2DatabasePlantsBy");
		requiredDb2DatabasePlantsBy
				.setLinkType(RequirementLinkTypes.DEPENDENCY_LITERAL);
		requiredDb2DatabasePlantsBy.setDmoEType(Db2Package.eINSTANCE
				.getDB2Database());

		//
		// Requires DB2 client (hosting)
		//
// Requirement requiredDb2ClientForCatalog =
// ValidatorTestUtils.createHostingRequirement(Db2Package.Literals.DB2_CLIENT,
// "requiredDb2ClientForCatalog");

		//
		// DB2 catalog unit
		// - provides DB2 database (local)
		// - consumes node catalog, DB2 database (remote)
		//
		DB2CatalogUnit db2CatalogUnit = Db2Factory.eINSTANCE
				.createDB2CatalogUnit();
		db2CatalogUnit.setName("db2CatalogUnit");
		top.getUnits().add(db2CatalogUnit);

		db2CatalogUnit.getOnlyDependencyCapabilities()
				.add(providedDb2CDatabase);
		db2CatalogUnit.getRequirements().add(requiredDb2CatalogedNode);
		db2CatalogUnit.getRequirements().add(requiredDb2DatabasePlantsBy);
// db2CatalogUnit.getRequirements().add(requiredDb2ClientForCatalog);

		// Second catalog unit for alias uniqueness test.
		//
		// DB2 database service (cataloged)
		//
		DB2Database providedDb2CDatabase2 = Db2Factory.eINSTANCE
				.createDB2Database();
		providedDb2CDatabase2.setName("providedDb2CDatabase2");
		providedDb2CDatabase2.setDbName("PLANTSBY");
		providedDb2CDatabase2.setDbAlias("PLANTSBX");
		providedDb2CDatabase2.setDbDrive("C:/DB2");

		//
		// Required DB2 cataloged node service, second
		//
		Requirement requiredDb2CatalogedNode2 = CoreFactory.eINSTANCE
				.createRequirement();
		requiredDb2CatalogedNode2.setName("requiredDb2CatalogedNode2");
		requiredDb2CatalogedNode2
				.setLinkType(RequirementLinkTypes.HOSTING_LITERAL);
		requiredDb2CatalogedNode2.setDmoEType(Db2Package.eINSTANCE
				.getDB2CatalogedNode());

		//
		// Required DB2 database service (remote one that is aliased)
		//
		Requirement requiredDb2DatabasePlantsBy2 = CoreFactory.eINSTANCE
				.createRequirement();
		requiredDb2DatabasePlantsBy2.setName("requiredDb2DatabasePlantsBy2");
		requiredDb2DatabasePlantsBy2
				.setLinkType(RequirementLinkTypes.DEPENDENCY_LITERAL);
		requiredDb2DatabasePlantsBy2.setDmoEType(Db2Package.eINSTANCE
				.getDB2Database());
		EqualsConstraint ec1 = ConstraintFactory.eINSTANCE.createEqualsConstraint();
		ec1.setName("ec1");
		ec1.setValue("PLANTSBY");
		ec1.setAttributeName(Db2Package.eINSTANCE.getDB2Database_DbName().getName());
		requiredDb2DatabasePlantsBy2.getConstraints().add(ec1);

		//
		// DB2 catalog unit
		// - provides DB2 database (local)
		// - consumes node catalog, DB2 database (remote)
		//
		DB2CatalogUnit db2CatalogUnit2 = Db2Factory.eINSTANCE
				.createDB2CatalogUnit();
		db2CatalogUnit2.setName("db2CatalogUnit");
		top.getUnits().add(db2CatalogUnit2);

		db2CatalogUnit2.getOnlyDependencyCapabilities().add(
				providedDb2CDatabase2);
		db2CatalogUnit2.getRequirements().add(requiredDb2CatalogedNode2);
		db2CatalogUnit2.getRequirements().add(requiredDb2DatabasePlantsBy2);

		//
		// Provided DB2 node catalog service
		//
		DB2CatalogedNode providedDb2CatalogedNode = Db2Factory.eINSTANCE
				.createDB2CatalogedNode();
		// providedDb2CatalogedNode
		providedDb2CatalogedNode.setName("providedDb2CatalogedNode");
		providedDb2CatalogedNode.setDasLevel("8.1.0.36");
		providedDb2CatalogedNode.setNodeName("PlantsDBNode");
		providedDb2CatalogedNode.setNodeType("TCPIP");
		providedDb2CatalogedNode.setPort(BigInteger.valueOf(50000));
		providedDb2CatalogedNode.setHostname("rf12.watson.ibm.com");
		providedDb2CatalogedNode.setLinkType(CapabilityLinkTypes.ANY_LITERAL);

		//
		// DB2 node unit
		// - provides DB2 catalog node service
		// - consumes DB2 client service, DB2 instance service
		//
		DB2NodeCatalogUnit db2NodeCatalogUnit = Db2Factory.eINSTANCE
				.createDB2NodeCatalogUnit();
		db2NodeCatalogUnit.setName("db2NodeCatalogUnit");
		top.getUnits().add(db2NodeCatalogUnit);

		db2NodeCatalogUnit.getCapabilities().add(providedDb2CatalogedNode);

		//
		// Link from required to provided DB2 catalog service
		//
// DependencyLink db2CatalogedNodeServiceLink =
// CoreFactory.eINSTANCE.createDependencyLink();
// db2CatalogedNodeServiceLink.setTarget(providedDb2CatalogedNode);
// requiredDb2CatalogedNode.setLink(db2CatalogedNodeServiceLink);
// ValidatorTestUtils.createLinkName(db2CatalogedNodeServiceLink);

// DependencyLink db2CatalogedNodeServiceLink2 =
// CoreFactory.eINSTANCE.createDependencyLink();
// db2CatalogedNodeServiceLink2.setTarget(providedDb2CatalogedNode);
// requiredDb2CatalogedNode2.setLink(db2CatalogedNodeServiceLink2);
// ValidatorTestUtils.createLinkName(db2CatalogedNodeServiceLink2);

		// PlantsBy stack
		DB2Database providedDb2DatabasePlantsBy = Db2Factory.eINSTANCE
				.createDB2Database();
		providedDb2DatabasePlantsBy.setName("providedDb2DatabasePlantsBy");
		providedDb2DatabasePlantsBy.setDbAlias("PLANTSBY");
		providedDb2DatabasePlantsBy.setDbDrive("C:/DB2"); // ????
		providedDb2DatabasePlantsBy.setDbName("PLANTSBY");

		DB2DatabaseUnit db2DatabaseUnitPlantsBy = Db2Factory.eINSTANCE
				.createDB2DatabaseUnit();
		db2DatabaseUnitPlantsBy.setName("db2DatabaseUnitPlantsBy");
		db2DatabaseUnitPlantsBy.setDisplayName("db2DatabaseUnitPlantsBy");
		db2DatabaseUnitPlantsBy.getOnlyDependencyCapabilities().add(
				providedDb2DatabasePlantsBy);
		top.getUnits().add(db2DatabaseUnitPlantsBy);

		DB2Instance providedInstance = Db2Factory.eINSTANCE.createDB2Instance();
		providedInstance.setName("providedInstance");
		providedInstance.setDb2InstanceName("DB2INST1");
		providedInstance.setHostname("test.ibm.com");
		providedInstance.setUsername("db2admin");
		providedInstance.setPassword("db2admin");
		providedInstance.setPort(BigInteger.valueOf(50000));
		providedInstance.setDb2Version("8.1.0.36");

		DB2InstanceUnit instanceUnit = Db2Factory.eINSTANCE
				.createDB2InstanceUnit();
		instanceUnit.setName("instanceUnit");
		instanceUnit.getHostingOrAnyCapabilities().add(providedInstance);
		top.getUnits().add(instanceUnit);
		ValidatorTestUtils.hosts(instanceUnit, db2DatabaseUnitPlantsBy);

		//
		// dependency link of the catalaged database to the remote database
		//
		DependencyLink plantsDatabaseServiceLink = CoreFactory.eINSTANCE
				.createDependencyLink();
		plantsDatabaseServiceLink.setTarget(providedDb2DatabasePlantsBy);
		requiredDb2DatabasePlantsBy.setLink(plantsDatabaseServiceLink);
		ValidatorTestUtils.createLinkName(plantsDatabaseServiceLink);

		//
		// Provided DB2 client service
		//
		DB2Client providedDb2Client = Db2Factory.eINSTANCE.createDB2Client();
		providedDb2Client.setName("providedDb2Client");
		providedDb2Client.setDb2ClientVersion("8.1.0.36");
		providedDb2Client.setInstallDir("C:\\IBM\\SQLLIB");

		db2RuntimeClientUnit = Db2Factory.eINSTANCE
				.createDB2RuntimeClientUnit();
		db2RuntimeClientUnit.setName("db2ClientUnit");
		top.getUnits().add(db2RuntimeClientUnit);

		db2RuntimeClientUnit.getHostingOrAnyCapabilities().add(
				providedDb2Client);

		//
		// Provided DB2 client service
		//

		DB2ClientInstance providedDb2ClientInstance = Db2Factory.eINSTANCE
				.createDB2ClientInstance();
		providedDb2ClientInstance.setName("providedDb2ClientInstance");
		providedDb2ClientInstance.setDb2Version("8.1.0.36");
		providedDb2ClientInstance.setDb2InstanceName("CLINST");

		db2ClientInstanceUnit = Db2Factory.eINSTANCE
				.createDB2ClientInstanceUnit();
		db2ClientInstanceUnit.setName("db2InstanceUnitClient");
		top.getUnits().add(db2ClientInstanceUnit);

		db2ClientInstanceUnit.getHostingOrAnyCapabilities().add(
				providedDb2Client);
		ValidatorTestUtils.hosts(db2NodeCatalogUnit, db2CatalogUnit);
		ValidatorTestUtils.hosts(db2NodeCatalogUnit, db2CatalogUnit2);
		ValidatorTestUtils.hosts(db2ClientInstanceUnit, db2NodeCatalogUnit);

		ValidatorTestUtils.hosts(db2RuntimeClientUnit, db2ClientInstanceUnit);

		// /////////
		Resource res = top.getEObject().eResource();
		res.save(null);
		// /////////

		ValidatorTestUtils.assertValidationErrorCount(0, top, db2CatalogUnit,
				context, reporter, validator);
		// assert instanceUnit.getStatus().getSeverity() != IStatus.OK;
		System.out.println("In " + this.getClass());
		dumpMarkers(top);

		// The following tests should test the type of the marker, but don't
		// due to impending changes in the validation framework.
		// Similar to DB2DatabaseValidatorTest, which also provides a
		// DB2Database service.

		// DbName checks
		String goodCDDbName = providedDb2CDatabase.getDbName();
		String goodPBDbName = providedDb2DatabasePlantsBy.getDbName();
		// Empty dbname
		providedDb2CDatabase.setDbName("");
		providedDb2DatabasePlantsBy.setDbName("");
		ValidatorTestUtils.assertValidationErrorCount(1, top, db2CatalogUnit,
				context, reporter, validator);

		// dbname with invalid characters
		providedDb2CDatabase.setDbName("___");
		providedDb2DatabasePlantsBy.setDbName("___");
		ValidatorTestUtils.assertValidationErrorCount(1, top, db2CatalogUnit,
				context, reporter, validator);

		// dbname too long
		providedDb2CDatabase.setDbName("AAAABBBBCCCCDDDD");
		providedDb2DatabasePlantsBy.setDbName("AAAABBBBCCCCDDDD");
		ValidatorTestUtils.assertValidationErrorCount(1, top, db2CatalogUnit,
				context, reporter, validator);

		// Cleanup
		providedDb2CDatabase.setDbName(goodCDDbName);
		providedDb2DatabasePlantsBy.setDbName(goodPBDbName);
		// verify cleanup successful
		ValidatorTestUtils.assertValidationErrorCount(0, top, db2CatalogUnit,
				context, reporter, validator);

		// DbAlias checks
		String goodCDDbAlias = providedDb2CDatabase.getDbAlias();
		String goodPBDbAlias = providedDb2DatabasePlantsBy.getDbAlias();
		// Empty dbAlias is allowed

		// dbAlias with invalid characters
		providedDb2CDatabase.setDbAlias("___");
		providedDb2DatabasePlantsBy.setDbAlias("___");
		ValidatorTestUtils.assertValidationErrorCount(1, top, db2CatalogUnit,
				context, reporter, validator);

		// dbAlias too long
		providedDb2CDatabase.setDbAlias("AAAABBBBCCCCDDDD");
		providedDb2DatabasePlantsBy.setDbAlias("AAAABBBBCCCCDDDD");
		ValidatorTestUtils.assertValidationErrorCount(1, top, db2CatalogUnit,
				context, reporter, validator);

		// Cleanup
		providedDb2CDatabase.setDbAlias(goodCDDbAlias);
		providedDb2DatabasePlantsBy.setDbAlias(goodPBDbAlias);
		// verify cleanup successful
		ValidatorTestUtils.assertValidationErrorCount(0, top, db2CatalogUnit,
				context, reporter, validator);

		// DBName propagator
// providedDb2DatabasePlantsBy.setDbName("DUMMY");
// ValidatorTestUtils.assertValidationErrorCountRange(1, 2, top, db2CatalogUnit,
// context, reporter, validator);

		// Cleanup
		providedDb2DatabasePlantsBy.setDbName(goodPBDbName);
		// verify cleanup successful
		ValidatorTestUtils.assertValidationErrorCount(0, top, db2CatalogUnit,
				context, reporter, validator);

		// Test for check for providedDbAlias uniqueness among the database
		// aliases on the databases provided by DB2Catalogs linked by the
		// CatalogedNode.
		String goodCDDbAlias2 = providedDb2CDatabase2.getDbAlias();
		providedDb2CDatabase2.setDbAlias(providedDb2CDatabase.getDbAlias());
		ValidatorTestUtils.assertValidationErrorCount(1, top, db2CatalogUnit,
				context, reporter, validator);

		// Cleanup
		providedDb2CDatabase2.setDbAlias(goodCDDbAlias2);
		// verify cleanup successful
		ValidatorTestUtils.assertValidationErrorCount(0, top, db2CatalogUnit,
				context, reporter, validator);

		Capability savedTarget = plantsDatabaseServiceLink.getTarget();
		plantsDatabaseServiceLink.setTarget(providedDb2CDatabase);
		ValidatorTestUtils.assertValidationErrorCount(1, top, db2CatalogUnit,
				context, reporter, validator);
		plantsDatabaseServiceLink.setTarget(savedTarget);
		ValidatorTestUtils.assertValidationErrorCount(0, top, db2CatalogUnit,
				context, reporter, validator);
	}
}
