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
import java.util.Set;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.emf.ecore.resource.Resource;

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
import com.ibm.ccl.soa.deploy.core.validator.expression.Equals;
import com.ibm.ccl.soa.deploy.core.validator.status.ICoreProblemType;
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
import com.ibm.ccl.soa.deploy.db2.internal.validator.DB2NodeCatalogUnitValidator;
import com.ibm.ccl.soa.deploy.db2.internal.validator.IDB2ValidatorID;
import com.ibm.ccl.soa.deploy.internal.core.validator.DeployMarker;

/**
 * Tests {@link DB2CatalogUnit}.
 * 
 * @author barnold
 * 
 */
public class DB2NodeCatalogUnitValidatorTest extends TopologyTestCase {

	private static final String PROJECT_NAME = "DB2NodeCatalogUnitValidatorTest";

	public DB2NodeCatalogUnitValidatorTest() {
		super(PROJECT_NAME);
	}

	/*
	 * @see junit.framework.TestCase#tearDown() Uncomment to stop deletion of
	 *      plants topology after test run.
	 */
	protected void tearDown() throws Exception {
	}

	public void testDB2NodeCatalogUnitValidator() throws IOException,
			CoreException {

		Topology top = createTopology("DB2NodeCatalogUnitValidator", true);

		IDeployValidationContext context = createValidationContext(top);
		IDeployReporter reporter = createDeployReporter();
		DB2NodeCatalogUnitValidator validator = new DB2NodeCatalogUnitValidator();

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
				.setLinkType(RequirementLinkTypes.DEPENDENCY_LITERAL);
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
		EqualsConstraint ec1 = ConstraintFactory.eINSTANCE.createEqualsConstraint();
		ec1.setName("ec1");
		ec1.setValue("PLANTSBY");
		ec1.setAttributeName(Db2Package.eINSTANCE
				.getDB2Database_DbName().getName());
		requiredDb2DatabasePlantsBy.getConstraints().add(ec1);

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

		//
		// Provided DB2 node catalog service
		//
		DB2CatalogedNode providedDb2CatalogedNode1 = Db2Factory.eINSTANCE
				.createDB2CatalogedNode();
		providedDb2CatalogedNode1.setName("providedDb2CatalogedNode1");
		providedDb2CatalogedNode1.setDasLevel("8.1.0.36");
		providedDb2CatalogedNode1.setNodeName("DB2PB");
		providedDb2CatalogedNode1.setNodeType("TCPIP");
		providedDb2CatalogedNode1.setPort(BigInteger.valueOf(50000));
		providedDb2CatalogedNode1.setHostname("rf12.watson.ibm.com");
		providedDb2CatalogedNode1.setLinkType(CapabilityLinkTypes.ANY_LITERAL);

		//
		// Required DB2 client
		//
		Requirement requiredDb2ClientInstance1 = CoreFactory.eINSTANCE
				.createRequirement();
		requiredDb2ClientInstance1.setName("requiredDb2ClientInstance1");
		requiredDb2ClientInstance1
				.setLinkType(RequirementLinkTypes.HOSTING_LITERAL);
		requiredDb2ClientInstance1.setDmoEType(Db2Package.eINSTANCE
				.getDB2ClientInstance());

		//
		// Required DB2 instance (remote)
		//
		Requirement requiredDb2Instance = CoreFactory.eINSTANCE
				.createRequirement();
		requiredDb2Instance.setName("requiredDb2InstancePlants");
		requiredDb2Instance
				.setLinkType(RequirementLinkTypes.DEPENDENCY_LITERAL);
		requiredDb2Instance.setDmoEType(Db2Package.eINSTANCE.getDB2Instance());
		EqualsConstraint ec2 = ConstraintFactory.eINSTANCE.createEqualsConstraint();
		ec2.setName("ec2");
		ec2.setValue("rf12.watson.ibm.com");
		ec2.setAttributeName(Db2Package.eINSTANCE
				.getDB2Instance_Hostname().getName());
		requiredDb2Instance.getConstraints().add(ec2);
		EqualsConstraint ec3 = ConstraintFactory.eINSTANCE.createEqualsConstraint();
		ec3.setName("ec3");
		ec3.setValue(BigInteger.valueOf(50000).toString());
		ec3.setAttributeName(Db2Package.eINSTANCE
				.getDB2Instance_Port().getName());
		requiredDb2Instance.getConstraints().add(ec3);

		//
		// DB2 node unit
		// - provides DB2 catalog node service
		// - consumes DB2 client service, DB2 instance service
		//
		DB2NodeCatalogUnit db2NodeCatalogUnit1 = Db2Factory.eINSTANCE
				.createDB2NodeCatalogUnit();
		db2NodeCatalogUnit1.setName("db2NodeCatalogUnit1");
		top.getUnits().add(db2NodeCatalogUnit1);

		db2NodeCatalogUnit1.getCapabilities().add(providedDb2CatalogedNode1);
		db2NodeCatalogUnit1.getRequirements().add(requiredDb2Instance);
		db2NodeCatalogUnit1.getRequirements().add(requiredDb2ClientInstance1);

		DB2ClientInstanceUnit db2ClientInstanceClient = Db2Factory.eINSTANCE
				.createDB2ClientInstanceUnit();
		db2ClientInstanceClient.setName("db2ClientInstanceClient");
		db2ClientInstanceClient.setDisplayName("db2ClientInstanceClient");
		top.getUnits().add(db2ClientInstanceClient);

		DB2ClientInstance providedDb2ClientInstance = Db2Factory.eINSTANCE
				.createDB2ClientInstance();
		providedDb2ClientInstance.setName("providedDb2ClientInstance");
		providedDb2ClientInstance.setDisplayName("providedDb2ClientInstance");
		providedDb2ClientInstance.setLinkType(CapabilityLinkTypes.ANY_LITERAL);
		providedDb2ClientInstance.setDb2InstanceName("DB2");
		db2ClientInstanceClient.getCapabilities()
				.add(providedDb2ClientInstance);

		Requirement requiredDB2ClientInst = ValidatorTestUtils
				.createHostingRequirement(Db2Package.eINSTANCE.getDB2Client(),
						"requiredDB2ClientInst");
		db2ClientInstanceClient.getRequirements().add(requiredDB2ClientInst);
		ValidatorTestUtils.hosts(db2ClientInstanceClient, db2NodeCatalogUnit1);

		DB2Client providedDB2Client = Db2Factory.eINSTANCE.createDB2Client();
		providedDB2Client.setName("providedDB2ClientHosting");
		providedDB2Client.setInstallDir("C:\\IBM\\SQLLIB");
		providedDB2Client.setDb2ClientVersion("8.1.0.36");

		DB2RuntimeClientUnit runtimeClientUnit = Db2Factory.eINSTANCE
				.createDB2RuntimeClientUnit();
		runtimeClientUnit.setName("runtimeClientUnit");
		runtimeClientUnit.getOnlyDependencyCapabilities()
				.add(providedDB2Client);
		top.getUnits().add(runtimeClientUnit);
		ValidatorTestUtils.hosts(runtimeClientUnit, db2ClientInstanceClient);

		// ----- For validation testing
		DB2CatalogedNode providedDb2CatalogedNode2 = Db2Factory.eINSTANCE
				.createDB2CatalogedNode();
		// providedDb2CatalogedNode1
		providedDb2CatalogedNode2.setName("providedDb2CatalogedNode2");
		providedDb2CatalogedNode2.setDasLevel("8.1.0.36");
		providedDb2CatalogedNode2.setNodeName("DB2PB2");
		providedDb2CatalogedNode2.setNodeType("TCPIP");
		providedDb2CatalogedNode2.setPort(BigInteger.valueOf(50000));
		providedDb2CatalogedNode2.setHostname("rf12.watson.ibm.com");
		providedDb2CatalogedNode2.setLinkType(CapabilityLinkTypes.ANY_LITERAL);

		Requirement requiredDb2Client2 = CoreFactory.eINSTANCE
				.createRequirement();
		requiredDb2Client2.setName("requiredDb2Client2");
		requiredDb2Client2.setLinkType(RequirementLinkTypes.HOSTING_LITERAL);
		requiredDb2Client2.setDmoEType(Db2Package.eINSTANCE.getDB2Client());

		DB2NodeCatalogUnit db2NodeCatalogUnit2 = Db2Factory.eINSTANCE
				.createDB2NodeCatalogUnit();
		db2NodeCatalogUnit2.setName("db2NodeCatalogUnit2");
		top.getUnits().add(db2NodeCatalogUnit2);
		db2NodeCatalogUnit2.getCapabilities().add(providedDb2CatalogedNode2);
		db2NodeCatalogUnit2.getRequirements().add(requiredDb2Client2);

		ValidatorTestUtils.hosts(db2ClientInstanceClient, db2NodeCatalogUnit2);

		// -----

		DB2Instance providedDb2Instance = Db2Factory.eINSTANCE
				.createDB2Instance();
		providedDb2Instance.setName("providedDb2InstancePlantsBy");
		providedDb2Instance.setDb2InstanceName("DB2PB");
		providedDb2Instance.setHostname("rf12.watson.ibm.com");
		providedDb2Instance.setUsername("db2admin");
		providedDb2Instance.setPassword("db2admin");
		providedDb2Instance.setPort(BigInteger.valueOf(50000));
		providedDb2Instance.setDb2Version("8.1.0.36");

		DB2InstanceUnit db2InstanceUnit = Db2Factory.eINSTANCE
				.createDB2InstanceUnit();
		db2InstanceUnit.setName("db2InstanceUnit");
// providedDb2Instance.setLinkType(CapabilityLinkTypes.ANY_LITERAL);
		providedDb2Instance.setLinkType(CapabilityLinkTypes.DEPENDENCY_LITERAL);
		db2InstanceUnit.getCapabilities().add(providedDb2Instance);
		top.getUnits().add(db2InstanceUnit);

		//
		// dependency link between local node catalog to the remote database
		// instance
		//
		DependencyLink plantsDbInstanceCommLink = CoreFactory.eINSTANCE
				.createDependencyLink();
		plantsDbInstanceCommLink.setTarget(providedDb2Instance);
		requiredDb2Instance.setLink(plantsDbInstanceCommLink);
		ValidatorTestUtils.createLinkName(plantsDbInstanceCommLink);

		//
		// Link from consumed to provided DB2 catalog service
		//
		DependencyLink db2CatalogedNodeServiceLink = CoreFactory.eINSTANCE
				.createDependencyLink();
		db2CatalogedNodeServiceLink.setTarget(providedDb2CatalogedNode1);
		requiredDb2CatalogedNode.setLink(db2CatalogedNodeServiceLink);
		ValidatorTestUtils.createLinkName(db2CatalogedNodeServiceLink);

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

		//
		// dependency link of the catalaged database to the remote database
		//
		DependencyLink plantsDatabaseServiceLink = CoreFactory.eINSTANCE
				.createDependencyLink();
		plantsDatabaseServiceLink.setTarget(providedDb2DatabasePlantsBy);
		requiredDb2DatabasePlantsBy.setLink(plantsDatabaseServiceLink);
		ValidatorTestUtils.createLinkName(plantsDatabaseServiceLink);

		// /////////
		Resource res = top.getEObject().eResource();
		res.save(null);
		// /////////

		validator.validate(db2NodeCatalogUnit1, context, reporter);
		// assert instanceUnit.getStatus().getSeverity() != IStatus.OK;
		System.out.println("In " + this.getClass());
		dumpMarkers(top);
//		assert (DeployMarker.getInstances(top).length == 0) : DeployMarker
//				.getInstances(top).length;
		ValidatorTestUtils.assertValidationErrorCount(0, top,
				db2NodeCatalogUnit1, context, reporter, validator);

// String goodHostname = providedDb2CatalogedNode1.getHostname();
// providedDb2CatalogedNode1.setHostname(goodHostname+"X");
// ValidatorTestUtils.assertValidationErrorCount(1, top, db2NodeCatalogUnit1,
// context, reporter, validator);
// providedDb2CatalogedNode1.setHostname(goodHostname);
//		
// BigInteger goodPort = providedDb2CatalogedNode1.getPort();
// providedDb2CatalogedNode1.setPort(goodPort.add(BigInteger.valueOf(1)));
// ValidatorTestUtils.assertValidationErrorCount(1, top, db2NodeCatalogUnit1,
// context, reporter, validator);
// providedDb2CatalogedNode1.setPort(goodPort);
//		
// String goodDb2InstanceName = providedDb2Instance.getDb2InstanceName();
// providedDb2Instance.setDb2InstanceName(goodDb2InstanceName+"X");
// ValidatorTestUtils.assertValidationErrorCount(1, top, db2NodeCatalogUnit1,
// context, reporter, validator);
// providedDb2Instance.setDb2InstanceName(goodDb2InstanceName);

		String goodNodeName2 = providedDb2CatalogedNode2.getNodeName();
		providedDb2CatalogedNode2.setNodeName(providedDb2CatalogedNode1
				.getNodeName());
		ValidatorTestUtils.assertValidationErrorCount(1, top,
				db2NodeCatalogUnit1, context, reporter, validator);
		providedDb2CatalogedNode2.setNodeName(goodNodeName2);
		ValidatorTestUtils.assertValidationErrorCount(0, top,
				db2NodeCatalogUnit1, context, reporter, validator);

		Set<String> expectedVids = new HashSet<String>();
		Set<String> expectedPTs = new HashSet<String>();
		expectedVids.add(IDB2ValidatorID.DB2_NODE_CATALOG_UNIT_NODENAME_EMPTY_001);
		expectedPTs.add(ICoreProblemType.OBJECT_ATTRIBUTE_INVALID);
		expectedPTs.add(ICoreProblemType.OBJECT_ATTRIBUTE_UNDEFINED);
		String goodNodeName1 = providedDb2CatalogedNode1.getNodeName();
		providedDb2CatalogedNode1.setNodeName("");
		ValidatorTestUtils.assertValidationErrorCount(2, top,
				db2NodeCatalogUnit1, context, reporter, validator);
		ValidatorTestUtils.topologyValidatorIDsInSet(top, expectedVids);
		ValidatorTestUtils.topologyProblemTypesInSet(top, expectedPTs);
		// 9 characters invalid
		providedDb2CatalogedNode1.setNodeName("ABCDEFGHI");
		expectedPTs.clear();
		expectedPTs.add(ICoreProblemType.OBJECT_ATTRIBUTE_INVALID);
		ValidatorTestUtils.assertValidationErrorCount(1, top,
				db2NodeCatalogUnit1, context, reporter, validator);
		ValidatorTestUtils.topologyValidatorIDsInSet(top, expectedVids);
		providedDb2CatalogedNode1.setNodeName(goodNodeName1);
		ValidatorTestUtils.assertValidationErrorCount(0, top,
				db2NodeCatalogUnit1, context, reporter, validator);

		//
		String goodInstanceName = providedDb2ClientInstance
				.getDb2InstanceName();
		String goodNodeName = providedDb2CatalogedNode1.getNodeName();
		providedDb2CatalogedNode1.setNodeName(goodInstanceName);
		ValidatorTestUtils.assertValidationErrorCount(1, top,
				db2NodeCatalogUnit1, context, reporter, validator);
		HashSet set = new HashSet();
		set
				.add(IDB2ValidatorID.DB2_NODE_CATALOG_UNIT_NODENAME_CONFLICTS_WITH_CLIENT_INSTANCE_NAME_001);
		ValidatorTestUtils.topologyValidatorIDsInSet(top, set);
		providedDb2CatalogedNode1.setNodeName(goodNodeName);
		ValidatorTestUtils.assertValidationErrorCount(0, top,
				db2NodeCatalogUnit1, context, reporter, validator);
	}
}
