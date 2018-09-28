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
import org.eclipse.core.runtime.IStatus;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.xmi.impl.XMLResourceImpl;

import com.ibm.ccl.soa.deploy.core.CapabilityLinkTypes;
import com.ibm.ccl.soa.deploy.core.CoreFactory;
import com.ibm.ccl.soa.deploy.core.DeployCoreRoot;
import com.ibm.ccl.soa.deploy.core.Requirement;
import com.ibm.ccl.soa.deploy.core.Topology;
import com.ibm.ccl.soa.deploy.core.Unit;
import com.ibm.ccl.soa.deploy.core.test.TopologyTestCase;
import com.ibm.ccl.soa.deploy.core.test.validator.utils.ValidatorTestUtils;
import com.ibm.ccl.soa.deploy.core.validator.DeployValidatorService;
import com.ibm.ccl.soa.deploy.core.validator.ValidatorUtils;
import com.ibm.ccl.soa.deploy.core.validator.expression.RequirementUtil;
import com.ibm.ccl.soa.deploy.db2.DB2AdminServer;
import com.ibm.ccl.soa.deploy.db2.DB2AdminServerUnit;
import com.ibm.ccl.soa.deploy.db2.DB2System;
import com.ibm.ccl.soa.deploy.db2.DB2SystemUnit;
import com.ibm.ccl.soa.deploy.db2.Db2Factory;
import com.ibm.ccl.soa.deploy.db2.Db2Package;
import com.ibm.ccl.soa.deploy.db2.WindowsDB2AdminServer;
import com.ibm.ccl.soa.deploy.db2.internal.validator.DB2AdminServerUnitValidator;
import com.ibm.ccl.soa.deploy.os.OperatingSystem;
import com.ibm.ccl.soa.deploy.os.OperatingSystemUnit;
import com.ibm.ccl.soa.deploy.os.OsFactory;

/**
 * Tests {@link DB2AdminServerUnitValidator}.
 * 
 * @author Ed Snible <snible@us.ibm.com>
 */
public class DB2AdminServerUnitValidatorTest extends TopologyTestCase {

	private static final String PROJECT_NAME = "DB2AdminServerUnitValidatorTest";

	public DB2AdminServerUnitValidatorTest() {
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
	public void testDB2AdminServerUnitValidator() throws Exception {

		Topology top = createTopology("DB2AdminServerUnitValidator", true);

// IDeployValidationContext context = createValidationContext(top);
// IDeployReporter reporter = createDeployReporter();
//
		DB2AdminServerUnit unitDb2AdminServer = Db2Factory.eINSTANCE
				.createDB2AdminServerUnit();
		top.getUnits().add(unitDb2AdminServer);

		DeployValidatorService dvs = new DeployValidatorService();

		dvs.validate(top);
		// Should have multi with at least two errors -- 1) no name and 2) no
		// caps
		assert unitDb2AdminServer.getStatus().getSeverity() == IStatus.ERROR;

		unitDb2AdminServer.setName("foo");
// DB2AdminServer capDb2AdminServer =
// Db2Factory.eINSTANCE.createDB2AdminServer();
		WindowsDB2AdminServer capDb2AdminServer = Db2Factory.eINSTANCE
				.createWindowsDB2AdminServer();
		capDb2AdminServer.setName("capDb2AdminServer");
		capDb2AdminServer.setDasDomain("Test");
// capDb2AdminServer.setDasUserName("Administrator");
// capDb2AdminServer.setDasUserPassword("passwd");
		unitDb2AdminServer.getCapabilities().add(capDb2AdminServer);

		dvs.validate(top);
		// Should have multi with at least three errors -- 1) no DB2Client cap,
		// 2) no DB2JdbcDriver cap and 3) no OperatingSystem req
		assert unitDb2AdminServer.getStatus().getSeverity() == IStatus.ERROR;

		OperatingSystem capWinOs = OsFactory.eINSTANCE
				.createWindowsOperatingSystem();
// capOs.setHosting(true);
		capWinOs.setName("capOs");
		capWinOs.setHostname("x.y.com");
		capWinOs.setLinkType(CapabilityLinkTypes.HOSTING_LITERAL);
		capWinOs.setOsType("Windows"); // This triggers Windows-specific
										// validations on pathnames
		Requirement req = RequirementUtil.createRequirement(capWinOs);
		unitDb2AdminServer.getRequirements().add(req);

		dvs.validate(top);
		// Should have "Unit "foo" must be hosted"
		assert unitDb2AdminServer.getStatus().getSeverity() == IStatus.ERROR;

		OperatingSystemUnit unitOs = OsFactory.eINSTANCE
				.createOperatingSystemUnit();
		unitOs.setName("unitOs");
		unitOs.getCapabilities().add(capWinOs);
		top.getUnits().add(unitOs);
		ValidatorTestUtils.hosts(unitOs, unitDb2AdminServer);

		DB2AdminServer db2AdminServer = (DB2AdminServer) ValidatorUtils
				.getCapability(unitDb2AdminServer, Db2Package.eINSTANCE
						.getDB2AdminServer());
		assert db2AdminServer.getStatus().getSeverity() != IStatus.ERROR;
	}

	/**
	 * Test by trying different breaks
	 */
	public void testDump() throws Exception {
		Unit unitDb2AdminServer = createValidAdminServer();
		Resource res = unitDb2AdminServer.getTopology().getEObject()
				.eResource();
		res.save(null);

		res = new XMLResourceImpl();
		DeployCoreRoot root = CoreFactory.eINSTANCE.createDeployCoreRoot();
		res.getContents().add(root);
		root.setTopology(unitDb2AdminServer.getTopology());
		res.save(System.out, null);
	}

	/**
	 * Test by trying different breaks
	 */
	public void testDB2AdminServerUnitValidator2() throws Exception {
		Unit unitDb2AdminServer = createValidAdminServer();

// DB2Client db2ClientCap = (DB2Client)
// ValidatorUtils.getCapability(unitDb2AdminServer,
// Db2Package.eINSTANCE.getDB2Client());
// DB2JdbcDriver db2JdbcDriverCap = (DB2JdbcDriver)
// ValidatorUtils.getCapability(unitDb2AdminServer,
// Db2Package.eINSTANCE.getDB2JdbcDriver());
		DB2AdminServer db2AdminServer = (DB2AdminServer) ValidatorUtils
				.getCapability(unitDb2AdminServer, Db2Package.eINSTANCE
						.getDB2AdminServer());

		DeployValidatorService dvs = new DeployValidatorService();
		dvs.validate(unitDb2AdminServer.getTopology());

		// Validate that there is no initial error
		dumpMarkers(unitDb2AdminServer.getTopology());
		int severity = unitDb2AdminServer.getStatus().getSeverity();
		assert unitDb2AdminServer.getStatus().getSeverity() == IStatus.OK;
// assert db2ClientCap.getStatus().getSeverity() == IStatus.OK;
// assert db2JdbcDriverCap.getStatus().getSeverity() == IStatus.OK;
		assert db2AdminServer.getStatus().getSeverity() == IStatus.OK;

		// Illegal classname
// db2JdbcDriverCap.setClassname(".Object");
// dvs.validate(unitDb2AdminServer.getTopology());
// assert db2JdbcDriverCap.getStatus().getSeverity() == IStatus.ERROR;

		// Illegal classname
// db2JdbcDriverCap.setClassname("Object.");
// dvs.validate(unitDb2AdminServer.getTopology());
// assert db2JdbcDriverCap.getStatus().getSeverity() == IStatus.ERROR;

		// Illegal classname
// db2JdbcDriverCap.setClassname("^");
// dvs.validate(unitDb2AdminServer.getTopology());
// assert db2JdbcDriverCap.getStatus().getSeverity() == IStatus.ERROR;

		// Illegal classname
// db2JdbcDriverCap.setClassname("java..Object");
// dvs.validate(unitDb2AdminServer.getTopology());
// assert db2JdbcDriverCap.getStatus().getSeverity() == IStatus.ERROR;

		// Legal classname
// db2JdbcDriverCap.setClassname("java.lang.Object");
// dvs.validate(unitDb2AdminServer.getTopology());
// assert db2JdbcDriverCap.getStatus().getSeverity() == IStatus.OK;
//		
		// Illegal install dir
// db2ClientCap.setInstallDir(">");
// dvs.validate(unitDb2AdminServer.getTopology());
// assert db2ClientCap.getStatus().getSeverity() == IStatus.ERROR;

		// Legal install dir
// db2ClientCap.setInstallDir("c:/temp");
// dvs.validate(unitDb2AdminServer.getTopology());
// assert db2JdbcDriverCap.getStatus().getSeverity() == IStatus.OK;

		if (db2AdminServer instanceof WindowsDB2AdminServer) {
			WindowsDB2AdminServer wdas = (WindowsDB2AdminServer) db2AdminServer;

			// Illegal Windows user name
// wdas.setDasUserName("");
// dvs.validate(unitDb2AdminServer.getTopology());
// assert db2AdminServer.getStatus().getSeverity() == IStatus.ERROR;
//			
// wdas.setDasUserName("Fred");
// dvs.validate(unitDb2AdminServer.getTopology());
// assert db2AdminServer.getStatus().getSeverity() == IStatus.OK;

			wdas.setDasDomain("");
			dvs.validate(unitDb2AdminServer.getTopology());
			assert db2AdminServer.getStatus().getSeverity() == IStatus.ERROR;

			wdas.setDasDomain("Wilma");
			dvs.validate(unitDb2AdminServer.getTopology());
			assert db2AdminServer.getStatus().getSeverity() == IStatus.OK;
		}
	}

	private DB2AdminServerUnit createValidAdminServer() throws IOException {
		Topology top = createTopology("DB2AdminServerUnitValidator", true);

		Unit unitDb2AdminServer = Db2Factory.eINSTANCE
				.createDB2AdminServerUnit();
		top.getUnits().add(unitDb2AdminServer);

		unitDb2AdminServer.setName("foo");
		DB2AdminServer capDb2AdminServer = Db2Factory.eINSTANCE
				.createDB2AdminServer();
		capDb2AdminServer.setName("capDb2AdminServer");
		capDb2AdminServer.setLinkType(CapabilityLinkTypes.DEPENDENCY_LITERAL);
		unitDb2AdminServer.getCapabilities().add(capDb2AdminServer);

		DB2System capDB2System = Db2Factory.eINSTANCE.createDB2System();
		capDB2System.setName("capDB2System");
		capDB2System.setLinkType(CapabilityLinkTypes.HOSTING_LITERAL);
		Requirement req = RequirementUtil.createRequirement(capDB2System);
		unitDb2AdminServer.getRequirements().add(req);

		DB2SystemUnit unitDB2System = Db2Factory.eINSTANCE
				.createDB2SystemUnit();
		unitDB2System.setName("unitDB2System");
		unitDB2System.getCapabilities().add(capDB2System);
		top.getUnits().add(unitDB2System);
		ValidatorTestUtils.hosts(unitDB2System, unitDb2AdminServer);

		return (DB2AdminServerUnit) unitDb2AdminServer;
	}

}
