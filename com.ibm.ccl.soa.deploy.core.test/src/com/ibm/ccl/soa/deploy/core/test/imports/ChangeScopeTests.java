/*******************************************************************************
 * Copyright (c) 2003, 2007 IBM Corporation Licensed Material - Property of IBM. All rights reserved.
 *  
 * US Government Users Restricted Rights - Use, duplication or disclosure v1.0 restricted by GSA ADP
 * Schedule Contract with IBM Corp.
 * 
 * Contributors: IBM Corporation - initial API and implementation
 *******************************************************************************/
package com.ibm.ccl.soa.deploy.core.test.imports;

import junit.framework.TestCase;
import junit.framework.TestSuite;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.core.runtime.Status;

import com.ibm.ccl.soa.deploy.core.Capability;
import com.ibm.ccl.soa.deploy.core.CapabilityLinkTypes;
import com.ibm.ccl.soa.deploy.core.ChangeScope;
import com.ibm.ccl.soa.deploy.core.CoreFactory;
import com.ibm.ccl.soa.deploy.core.CorePackage;
import com.ibm.ccl.soa.deploy.core.DeployCoreRoot;
import com.ibm.ccl.soa.deploy.core.DeploymentTopologyDomain;
import com.ibm.ccl.soa.deploy.core.InitializeModelOperation;
import com.ibm.ccl.soa.deploy.core.Requirement;
import com.ibm.ccl.soa.deploy.core.RequirementLinkTypes;
import com.ibm.ccl.soa.deploy.core.Topology;
import com.ibm.ccl.soa.deploy.core.Unit;
import com.ibm.ccl.soa.deploy.core.test.TestSetup;

public class ChangeScopeTests extends TestCase {

	private static final String UNIT1 = "Unit1";

	public static final CoreFactory FACTORY = CoreFactory.eINSTANCE;

	private static final String PROJECT_NAME = "ChangeScopeTests";
	private static final String NAMESPACE_FRAGMENT = "com.acme";
	private static final String TOPOLOGY1 = "TOPOLOGY1";
	private static final String EXISTING_TOPOLOGY1 = "EXISTING_TOPOLOGY1";

	private TestSetup testSetup;

	private IFile existingTopology;

	public ChangeScopeTests(String name) {
		super(name);
	}

	public static TestSuite suite() {
		return new TestSuite(ChangeScopeTests.class);
		// TestSuite suite = new TestSuite();
		// suite.addTest(new
		// ModelProxyResolutionTests("testFindDependencyLink"));
		// return suite;
	}

	protected void setUp() throws Exception {
		super.setUp();

		testSetup = new TestSetup(PROJECT_NAME, NAMESPACE_FRAGMENT);

	}

	@Override
	protected void tearDown() throws Exception {
		testSetup.dispose();
	}

	public void testScopeOpenModel() throws Exception {

		existingTopology = testSetup.getFragment().getTopology(
				EXISTING_TOPOLOGY1);
		ChangeScope<Topology, DeploymentTopologyDomain> existingScope = ChangeScope
				.createChangeScopeForWrite(existingTopology);

		try {
			// should create the topology
			Topology expectedTopology = existingScope.createTopology(
					NAMESPACE_FRAGMENT, EXISTING_TOPOLOGY1,
					new NullProgressMonitor());

			ChangeScope<Topology, DeploymentTopologyDomain> testScope = ChangeScope
					.createChangeScopeForWrite(existingTopology);

			DeployCoreRoot testRoot = testScope.openModel(existingTopology,
					CorePackage.eINSTANCE.getDeployCoreRoot());
			Topology actualTopology = testRoot.getTopology();

			assertEquals(expectedTopology.getName(), actualTopology.getName());
			assertEquals(expectedTopology.getNamespace(), actualTopology
					.getNamespace());

		} finally {
			if (existingScope != null)
				existingScope.close(new NullProgressMonitor());
		}

	}

	public void testScopeCreateModel() throws Exception {

		IFile topology1 = testSetup.getFragment().getTopology(TOPOLOGY1);

		ChangeScope<Topology, DeploymentTopologyDomain> testScope = ChangeScope
				.createChangeScopeForWrite(topology1);

		try {
			InitializeModelOperation<DeployCoreRoot> initOp = new InitializeModelOperation<DeployCoreRoot>(
					testScope.getTransactionalEditingDomain(),
					"Initialize Model for " + topology1.getName()) {

				@Override
				protected IStatus initialize(
						ChangeScope<DeployCoreRoot, ?> scope) {
					DeployCoreRoot root = scope.getTarget();
					Topology topology = CoreFactory.eINSTANCE.createTopology();
					topology.setName(TOPOLOGY1);
					topology.setNamespace(NAMESPACE_FRAGMENT);
					root.setTopology(topology);

					return Status.OK_STATUS;

					// root was already added to the resource before this
					// operation was executed.
				}

			};

			DeployCoreRoot root = testScope.createModel(topology1,
					CorePackage.eINSTANCE.getDeployCoreRoot(), initOp);
			Topology topology = root.getTopology();

			assertEquals(TOPOLOGY1, topology.getName());
			assertEquals(NAMESPACE_FRAGMENT, topology.getNamespace());

			/*
			 * It happens that we have used the createModel() to create the
			 * topology that would have otherwise been created by the above
			 * ChangeScope's createTopology() method.
			 * 
			 * Therefore, we should be able to open the topology and they should
			 * be the same. If we had created a different model (with a
			 * different document root), then this would not be true.
			 */
			assertEquals(topology, testScope.openTopology());

		} finally {
			if (testScope != null)
				testScope.close(new NullProgressMonitor());
		}

	}

	private void createHostingRequirement(Unit hostedUnit, String name) {
		Requirement hostingRequirement1 = CoreFactory.eINSTANCE
				.createRequirement();
		hostingRequirement1.setName(name);
		hostingRequirement1.setDmoEType(CorePackage.Literals.CAPABILITY);
		hostingRequirement1.setLinkType(RequirementLinkTypes.HOSTING_LITERAL);
		hostedUnit.getRequirements().add(hostingRequirement1);
	}

	private void createHostingCapability(Unit hostedUnit, String name) {
		Capability hostingCapability1 = CoreFactory.eINSTANCE
				.createCapability();
		hostingCapability1.setName(name);
		hostingCapability1.setLinkType(CapabilityLinkTypes.HOSTING_LITERAL);
		hostedUnit.getCapabilities().add(hostingCapability1);
	}

	private void createCapability(Unit hostedUnit, String name) {
		Capability capability1 = CoreFactory.eINSTANCE.createCapability();
		capability1.setName(name);
		capability1.setLinkType(CapabilityLinkTypes.DEPENDENCY_LITERAL);
		hostedUnit.getCapabilities().add(capability1);
	}
}
