/*******************************************************************************
 * Copyright (c) 2003, 2007 IBM Corporation Licensed Material - Property of IBM. All rights reserved.
 *  
 * US Government Users Restricted Rights - Use, duplication or disclosure v1.0 restricted by GSA ADP
 * Schedule Contract with IBM Corp.
 * 
 * Contributors: IBM Corporation - initial API and implementation
 *******************************************************************************/
package com.ibm.ccl.soa.deploy.db2.test.validator;

/**
 * Test for DB2 database unit validations.
 * 
 * @version
 * @author Bill Arnold (barnold@us.ibm.com)
 */

import java.io.IOException;

import org.eclipse.core.runtime.CoreException;

import com.ibm.ccl.soa.deploy.core.CapabilityLinkTypes;
import com.ibm.ccl.soa.deploy.core.CoreFactory;
import com.ibm.ccl.soa.deploy.core.HostingLink;
import com.ibm.ccl.soa.deploy.core.Requirement;
import com.ibm.ccl.soa.deploy.core.RequirementLinkTypes;
import com.ibm.ccl.soa.deploy.core.Topology;
import com.ibm.ccl.soa.deploy.core.test.TopologyTestCase;
import com.ibm.ccl.soa.deploy.core.test.validator.utils.ValidatorTestUtils;
import com.ibm.ccl.soa.deploy.core.validator.IDeployReporter;
import com.ibm.ccl.soa.deploy.core.validator.IDeployValidationContext;
import com.ibm.ccl.soa.deploy.core.validator.matcher.DeployMatcherStatus;
import com.ibm.ccl.soa.deploy.core.validator.matcher.LinkDescriptor;
import com.ibm.ccl.soa.deploy.core.validator.matcher.LinkType;
import com.ibm.ccl.soa.deploy.db2.DB2Database;
import com.ibm.ccl.soa.deploy.db2.DB2DatabaseUnit;
import com.ibm.ccl.soa.deploy.db2.DB2JdbcDriver;
import com.ibm.ccl.soa.deploy.db2.DB2System;
import com.ibm.ccl.soa.deploy.db2.DB2SystemUnit;
import com.ibm.ccl.soa.deploy.db2.Db2Factory;
import com.ibm.ccl.soa.deploy.db2.Db2Package;
import com.ibm.ccl.soa.deploy.db2.internal.validator.DB2DomainValidator;
import com.ibm.ccl.soa.deploy.db2.internal.validator.matcher.DB2DomainMatcher;
import com.ibm.ccl.soa.deploy.internal.core.validator.DeployMarker;
import com.ibm.ccl.soa.deploy.java.JdbcTypeType;
import com.ibm.ccl.soa.deploy.os.OperatingSystem;
import com.ibm.ccl.soa.deploy.os.OperatingSystemUnit;
import com.ibm.ccl.soa.deploy.os.OsFactory;
import com.ibm.ccl.soa.deploy.os.OsPackage;

/**
 * Tests {@link DB2DomainMatcher}.
 */
public class DB2DomainMatcherTest extends TopologyTestCase {

	private static final String PROJECT_NAME = "DB2DomainMatcherTest";

	public DB2DomainMatcherTest() {
		super(PROJECT_NAME);
	}

	protected void tearDown() throws Exception {
		super.tearDown();
// project.delete(true, true, null);
	}

	public void testDB2DomainMatcher() throws IOException, CoreException {

		Topology top = createTopology("DB2DatabaseUnitValidator", true);

		IDeployValidationContext context = createValidationContext(top);
		IDeployReporter reporter = createDeployReporter();
		DB2DomainValidator validator = new DB2DomainValidator();

		// provided DB2Database service
		DB2Database providedDb = Db2Factory.eINSTANCE.createDB2Database();
		providedDb.setName("providedDb");
		providedDb.setDbDrive("C:");
		providedDb.setDbName("PLANTS");

		// required DB2Instance service
		Requirement requiredInstance = CoreFactory.eINSTANCE
				.createRequirement();
		requiredInstance.setName("requiredInstance");
		requiredInstance.setDmoEType(Db2Package.Literals.DB2_INSTANCE);
		requiredInstance.setLinkType(RequirementLinkTypes.HOSTING_LITERAL);

		// DB2DatabaseUnit
		// provides DB2Database service (providedDb)
		// consumes DB2 instance service (consumedInstance)
		DB2DatabaseUnit databaseUnit = Db2Factory.eINSTANCE
				.createDB2DatabaseUnit();
		databaseUnit.setName("databaseUnit");
		top.getUnits().add(databaseUnit);
		databaseUnit.getRequirements().add(requiredInstance);
		providedDb.setLinkType(CapabilityLinkTypes.ANY_LITERAL);
		databaseUnit.getCapabilities().add(providedDb);

		// provided DB2System
		DB2System providedSystem = Db2Factory.eINSTANCE.createDB2System();
		providedSystem.setName("providedSystem");
		providedSystem.setInstallDir("C:\\IBM\\SQLLIB");
		providedSystem.setDb2Version("8.1.0.36");

		// provided JdbcDriver
		DB2JdbcDriver providedJdbc = Db2Factory.eINSTANCE.createDB2JdbcDriver();
		providedJdbc.setName("providedJdbc");
		providedJdbc.setJdbcType(JdbcTypeType._2_LITERAL);

		// consumed OperatingSystem service
		Requirement requiredOs = CoreFactory.eINSTANCE.createRequirement();
		requiredOs.setDmoEType(OsPackage.Literals.OPERATING_SYSTEM);
		requiredOs.setLinkType(RequirementLinkTypes.HOSTING_LITERAL);
		requiredOs.setName("requiredOs");

		// DB2SystemUnit
		// provides DB2System service (providedSystem)
		// consumes OS service (consumedOs)
		DB2SystemUnit systemUnit = Db2Factory.eINSTANCE.createDB2SystemUnit();
		systemUnit.setName("systemUnit");
		systemUnit.getHostingOrAnyCapabilities().add(providedSystem);
		systemUnit.getOnlyDependencyCapabilities().add(providedJdbc);
		systemUnit.getRequirements().add(requiredOs);
		top.getUnits().add(systemUnit);

		// provided operating system
		OperatingSystem providedOs = OsFactory.eINSTANCE
				.createOperatingSystem();
		providedOs.setName("providedOs");

		// OperatingSystemUnit
		// provides operating system (providedOs)
		OperatingSystemUnit osUnit = OsFactory.eINSTANCE
				.createOperatingSystemUnit();
		osUnit.setName("os");
		osUnit.getHostingOrAnyCapabilities().add(providedOs);
		top.getUnits().add(osUnit);

		ValidatorTestUtils.hosts(osUnit, systemUnit);

		top.getEObject().eResource().save(null);
		DeployMarker.deleteInstances(top);
		validator.validate(context, reporter);
		dumpMarkers(top);
		assert (DeployMarker.getInstances(top).length == 1);

		assert (validator.getDomainMatcher().canCreateLink(databaseUnit,
				systemUnit, LinkType.ALL_LINK_TYPES).isOK());
		assert (validator.getDomainMatcher().canCreateLink(systemUnit,
				databaseUnit, LinkType.ALL_LINK_TYPES).isOK());

		LinkDescriptor[] hld = validator.getDomainMatcher().getPossibleLinks(
				databaseUnit, systemUnit, LinkType.ALL_LINK_TYPES);
		System.out.println("HLD:  link = " + hld[0].getSourceUnit().getName()
				+ " -> " + hld[0].getTargetUnit().getName());
		HostingLink link = (HostingLink) hld[0].create();
		link.setName("SystemHostsDatabase");

		top.getEObject().eResource().save(null);
		DeployMarker.deleteInstances(top);
		validator.validate(context, reporter);
		dumpMarkers(top);
		assert (DeployMarker.getInstances(top).length == 1);
	}
}
