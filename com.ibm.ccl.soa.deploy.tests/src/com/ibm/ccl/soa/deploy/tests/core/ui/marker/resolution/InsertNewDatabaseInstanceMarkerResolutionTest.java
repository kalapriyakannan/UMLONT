/*******************************************************************************
 * Copyright (c) 2003, 2007 IBM Corporation Licensed Material - Property of IBM. All rights reserved.
 *  
 * US Government Users Restricted Rights - Use, duplication or disclosure v1.0 restricted by GSA ADP
 * Schedule Contract with IBM Corp.
 * 
 * Contributors: IBM Corporation - initial API and implementation
 *******************************************************************************/
package com.ibm.ccl.soa.deploy.tests.core.ui.marker.resolution;

import java.io.IOException;

import org.eclipse.core.resources.IMarker;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.MultiStatus;

import com.ibm.ccl.soa.deploy.core.DeployModelObject;
import com.ibm.ccl.soa.deploy.core.HostingLink;
import com.ibm.ccl.soa.deploy.core.Requirement;
import com.ibm.ccl.soa.deploy.core.Topology;
import com.ibm.ccl.soa.deploy.core.test.TopologyTestCase;
import com.ibm.ccl.soa.deploy.core.test.validator.utils.ValidatorTestUtils;
import com.ibm.ccl.soa.deploy.core.validator.DomainValidator;
import com.ibm.ccl.soa.deploy.core.validator.IDeployReporter;
import com.ibm.ccl.soa.deploy.core.validator.IDeployValidationContext;
import com.ibm.ccl.soa.deploy.core.validator.matcher.LinkDescriptor;
import com.ibm.ccl.soa.deploy.core.validator.matcher.LinkType;
import com.ibm.ccl.soa.deploy.core.validator.status.IDeployStatus;
import com.ibm.ccl.soa.deploy.db2.DB2Database;
import com.ibm.ccl.soa.deploy.db2.DB2DatabaseUnit;
import com.ibm.ccl.soa.deploy.db2.DB2JdbcDriver;
import com.ibm.ccl.soa.deploy.db2.DB2System;
import com.ibm.ccl.soa.deploy.db2.DB2SystemUnit;
import com.ibm.ccl.soa.deploy.db2.Db2Factory;
import com.ibm.ccl.soa.deploy.db2.Db2Package;
import com.ibm.ccl.soa.deploy.db2.internal.validator.DB2DomainValidator;
import com.ibm.ccl.soa.deploy.internal.core.validator.DeployMarker;
import com.ibm.ccl.soa.deploy.java.JdbcTypeType;
import com.ibm.ccl.soa.deploy.os.OperatingSystem;
import com.ibm.ccl.soa.deploy.os.OperatingSystemUnit;
import com.ibm.ccl.soa.deploy.os.OsFactory;
import com.ibm.ccl.soa.deploy.os.OsPackage;

/**
 * Tests {@link DeployObjectAttributeValueMarkerResolution}.
 */
public class InsertNewDatabaseInstanceMarkerResolutionTest extends
		TopologyTestCase {
	public static final String PROJECT_NAME = "InsertNewDatabaseInstanceMarkerResolutionTest";

	/**
	 * 
	 */
	public InsertNewDatabaseInstanceMarkerResolutionTest() {
		super(PROJECT_NAME);
	}

	/**
	 * @throws Exception
	 */
	public void testInsertDatabaseInstanceResolution() throws Exception {
		// Create model
		Topology top = createTopology("testInsertDatabaseInstanceResolution",
				true);

		IDeployValidationContext context = createValidationContext(top);
		IDeployReporter reporter = createDeployReporter();
		DB2DomainValidator validator = new DB2DomainValidator();

		createTopology(top, validator);

		// validate (create markers)
		top.getEObject().eResource().save(null);
		DeployMarker.deleteInstances(top);
		validator.validate(context, reporter);
		dumpMarkers(top);

		// find specific marker we are interstested in
// DB2DatabaseUnit systemUnit = (DB2DatabaseUnit)
// top.resolveUnit("/databaseUnit", true);
		Requirement requiredInstance = (Requirement) top
				.resolve("/databaseUnit/requiredInstance");
// IMarker marker = getMarker(systemUnit);
		IMarker marker = getMarker(requiredInstance);

		assert null != marker;

		// Resolve marker
		// TODO fix
// InsertNewDatabaseInstance resolution = new InsertNewDatabaseInstance
// (context, new InsertNewDatabaseInstanceGenerator());
// resolution.run(marker, top, new NullProgressMonitor());

		// validate (create markers)
		top.getEObject().eResource().save(null);
		DeployMarker.deleteInstances(top);
		validator.validate(context, reporter);
		dumpMarkers(top);

	}

	protected void createTopology(Topology top, DomainValidator validator)
			throws IOException {

		IDeployValidationContext context = createValidationContext(top);
		IDeployReporter reporter = createDeployReporter();

		// provided DB2Database service
		DB2Database providedDb = Db2Factory.eINSTANCE.createDB2Database();
		providedDb.setName("providedDb");
		providedDb.setDbDrive("C:");
		providedDb.setDbName("PLANTS");

		// requires DB2Instance service
		Requirement requiredInstance = ValidatorTestUtils
				.createHostingRequirement(Db2Package.Literals.DB2_INSTANCE,
						"requiredInstance");

		// DB2DatabaseUnit
		// provides DB2Database service (providedDb)
		// consumes DB2 instance service (consumedInstance)
		DB2DatabaseUnit databaseUnit = Db2Factory.eINSTANCE
				.createDB2DatabaseUnit();
		databaseUnit.setName("databaseUnit");
		top.getUnits().add(databaseUnit);
		databaseUnit.getRequirements().add(requiredInstance);
		databaseUnit.getHostingOrAnyCapabilities().add(providedDb);

		// provided DB2System
		DB2System providedSystem = Db2Factory.eINSTANCE.createDB2System();
		providedSystem.setName("providedSystem");
		providedSystem.setInstallDir("C:\\IBM\\SQLLIB");
		providedSystem.setDb2Version("8.1.0.36");

		// provided JdbcDriver
		DB2JdbcDriver providedJdbc = Db2Factory.eINSTANCE.createDB2JdbcDriver();
		providedJdbc.setName("providedJdbc");
		providedJdbc.setJdbcType(JdbcTypeType._2_LITERAL);

		// requires OperatingSystem
		Requirement requiredOs = ValidatorTestUtils.createHostingRequirement(
				OsPackage.Literals.OPERATING_SYSTEM, "requiredOs");

		// DB2SystemUnit
		// provides DB2System service (providedSystem)
		// requires OS service (requiredOs)
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

// assert
// (validator.getDomainMatcher().canCreateLink(databaseUnit,systemUnit,LinkType.ALL_LINK_TYPES).isOK());
		assert (validator.getDomainMatcher().canCreateLink(systemUnit,
				databaseUnit, LinkType.ALL_LINK_TYPES).isOK());

		LinkDescriptor[] hld = validator.getDomainMatcher().getPossibleLinks(
				systemUnit, databaseUnit, LinkType.ALL_LINK_TYPES);
		System.out.println("HLD:  link = " + hld[0].getSourceUnit().getName()
				+ " -> " + hld[0].getTargetUnit().getName());
		HostingLink link = (HostingLink) hld[0].create();
		link.setName("SystemHostsDatabase");

	}

	protected IMarker getMarker(DeployModelObject o) {
		IStatus status = o.getStatus();

		if (status instanceof IDeployStatus) {
			IDeployStatus deployStatus = (IDeployStatus) status;
			IMarker marker = deployStatus.getMarker();
			return marker;
		} else if (status instanceof MultiStatus) {
			MultiStatus multi = (MultiStatus) status;
			IStatus[] childStatus = multi.getChildren();
			for (int x = 0; x < childStatus.length; ++x) {
				if (childStatus[x] instanceof IDeployStatus) {
					IDeployStatus deployStatus = (IDeployStatus) childStatus[x];
					IMarker marker = deployStatus.getMarker();
					return marker;
				}
			}
		}
		return null;
	}
}
