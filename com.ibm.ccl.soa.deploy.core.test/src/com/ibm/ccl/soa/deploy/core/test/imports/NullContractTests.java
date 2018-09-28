/*******************************************************************************
 * Copyright (c) 2003, 2007 IBM Corporation Licensed Material - Property of IBM. All rights reserved.
 *  
 * US Government Users Restricted Rights - Use, duplication or disclosure v1.0 restricted by GSA ADP
 * Schedule Contract with IBM Corp.
 * 
 * Contributors: IBM Corporation - initial API and implementation
 *******************************************************************************/
package com.ibm.ccl.soa.deploy.core.test.imports;

import java.math.BigInteger;
import java.util.List;

import junit.framework.TestCase;
import junit.framework.TestSuite;

import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.core.runtime.Status;

import com.ibm.ccl.soa.deploy.core.Capability;
import com.ibm.ccl.soa.deploy.core.ChangeScope;
import com.ibm.ccl.soa.deploy.core.CommunicationCapability;
import com.ibm.ccl.soa.deploy.core.ConfigurationContract;
import com.ibm.ccl.soa.deploy.core.CoreFactory;
import com.ibm.ccl.soa.deploy.core.ExplicitContract;
import com.ibm.ccl.soa.deploy.core.IConstants;
import com.ibm.ccl.soa.deploy.core.Import;
import com.ibm.ccl.soa.deploy.core.InstanceConfiguration;
import com.ibm.ccl.soa.deploy.core.RealizationLink;
import com.ibm.ccl.soa.deploy.core.Requirement;
import com.ibm.ccl.soa.deploy.core.Topology;
import com.ibm.ccl.soa.deploy.core.Unit;
import com.ibm.ccl.soa.deploy.core.Visibility;
import com.ibm.ccl.soa.deploy.core.test.ModelChange;
import com.ibm.ccl.soa.deploy.core.test.SimpleChangeScope;
import com.ibm.ccl.soa.deploy.core.test.TestSetup;

public class NullContractTests extends TestCase {

	private static final int NUM_TOTAL_UNITS_IN_IMPORT = 7;
	private static final int NUM_PUBLIC_UNITS = 0;
	private static final int NUM_PUBLIC_EDITABLE_UNITS = 0;

	public static final CoreFactory FACTORY = CoreFactory.eINSTANCE;

	private static final String EXPLICIT_PUBLIC_UNIT = "HostedUnit1";
	private static final String EXPLICIT_PUBLIC_EDITABLE_UNIT = "HostedUnit2";
	private static final String IMPLICIT_PUBLIC_UNIT = "HostedUnit3";
	private static final String CONCEPTUAL_UNIT = "HostedUnit4";
	private static final String REALIZED_UNIT = "HostedUnit5";

	private static final String UNIT1 = "Unit1";
	private static final String UNIT2 = "Unit1";

	private static final String HOSTING_UNIT1 = "HostingUnit1";
	private static final String HOSTING_UNIT2 = "HostingUnit2";

	protected static final String PRIVATE_UNIT1 = "PRIVATE_UNIT1";
	protected static final String PRIVATE_UNIT2 = "PRIVATE_UNIT2";

	private static final String COMMUNICATION_CAPABILITY1 = "CommunicationCapability1";
	private static final String HOSTING_REQUIREMENT1 = "HostingRequirement1";
	private static final String HOSTING_REQUIREMENT2 = "HostingRequirement2";

	private static final String HOSTING_CAPABILITY1 = "HostingCapability1";
	private static final String HOSTING_CAPABILITY2 = "HostingCapability2";

	private static final String CAPABILITY1 = "Capability1";
	private static final String CAPABILITY2 = "Capability2";
	private static final String CAPABILITY3 = "Capability3";
	private static final String CAPABILITY4 = "Capability4";

	private static final String AUGMENTED_CAPABILITY = "AugmentedCapability";
	private static final String AUGMENTED_REQUIREMENT = "AugmentedRequirement";

	private static final String PROJECT_NAME = "ExplicitContractTests";
	private static final String NAMESPACE_FRAGMENT = "com.acme";

	private static final String IMPORTED = "Imported";
	private static final String EDITED = "Edited";

	private static final BigInteger HTTP_PORT = BigInteger.valueOf(8080);
	private static final String HTTP_PROTOCOL = "http";

	private SimpleChangeScope importedTopologyScope;
	private SimpleChangeScope referencingTopologyScope;
	private TestSetup testSetup;

	public NullContractTests(String name) {
		super(name);
	}

	public static TestSuite suite() {
		return new TestSuite(NullContractTests.class);
// TestSuite suite = new TestSuite();
// suite.addTest(new
// ExplicitContractTests("testDeConfigurable"));
// return suite;
	}

	protected void setUp() throws Exception {
		super.setUp();

		testSetup = new TestSetup(PROJECT_NAME, NAMESPACE_FRAGMENT);
		importedTopologyScope = testSetup.createTopologyScope(IMPORTED,
				ChangeScope.OPTION_FORCE_SAVE, new ModelChange(
						"Configure Imported Topology") {

					public IStatus execute(IProgressMonitor monitor,
							ChangeScope scope) throws ExecutionException {

						Topology topology = scope.openTopology();

						Unit hostedUnit = FACTORY.createUnit();
						hostedUnit.setName(EXPLICIT_PUBLIC_UNIT);
						topology.getUnits().add(hostedUnit);

						TestSetup.createCapability(hostedUnit, CAPABILITY1);
						TestSetup.createCapability(hostedUnit, CAPABILITY2);
						TestSetup.createCommunicationCapability(hostedUnit,
								COMMUNICATION_CAPABILITY1);
						TestSetup.createHostingRequirement(hostedUnit,
								HOSTING_REQUIREMENT1);

						Unit hostedUnit2 = FACTORY.createUnit();
						hostedUnit2.setName(EXPLICIT_PUBLIC_EDITABLE_UNIT);
						topology.getUnits().add(hostedUnit2);

						TestSetup.createCapability(hostedUnit2, CAPABILITY3);

						Unit hostedUnit3 = FACTORY.createUnit();
						hostedUnit3.setName(IMPLICIT_PUBLIC_UNIT);
						topology.getUnits().add(hostedUnit3);

						TestSetup.createCapability(hostedUnit3, CAPABILITY4);
						TestSetup.createHostingRequirement(hostedUnit3,
								HOSTING_REQUIREMENT2);

						Unit privateUnit1 = FACTORY.createUnit();
						privateUnit1.setName(PRIVATE_UNIT1);
						topology.getUnits().add(privateUnit1);

						Unit privateUnit2 = FACTORY.createUnit();
						privateUnit2.setName(PRIVATE_UNIT2);
						topology.getUnits().add(privateUnit2);

						Unit conceptualUnit = FACTORY.createUnit();
						conceptualUnit.setName(CONCEPTUAL_UNIT);
						conceptualUnit.setConceptual(true);
						topology.getUnits().add(conceptualUnit);

						Unit realizedUnit = FACTORY.createUnit();
						realizedUnit.setName(REALIZED_UNIT);
						conceptualUnit.setConceptual(true);
						topology.getUnits().add(realizedUnit);

						RealizationLink link = FACTORY.createRealizationLink();
						link.setSource(realizedUnit);
						link.setTarget(privateUnit2);
						realizedUnit.getRealizationLinks().add(link);

						return Status.OK_STATUS;
					}
				});

		referencingTopologyScope = testSetup.createTopologyScope(EDITED,
				ChangeScope.OPTION_FORCE_SAVE, new ModelChange(
						"Configure Edited Topology") {

					public IStatus execute(IProgressMonitor monitor,
							ChangeScope scope) throws ExecutionException {

						Topology topology = scope.openTopology();

						Unit hostingUnit = CoreFactory.eINSTANCE.createUnit();
						hostingUnit.setName(HOSTING_UNIT1);
						topology.getUnits().add(hostingUnit);

						TestSetup.createCapability(hostingUnit,
								HOSTING_CAPABILITY1);

						Unit hostingUnit2 = CoreFactory.eINSTANCE.createUnit();
						hostingUnit2.setName(HOSTING_UNIT2);
						topology.getUnits().add(hostingUnit2);

						return Status.OK_STATUS;
					}
				});

		// Must be setup by this method.
		assertNotNull(importedTopologyScope);
	}

	@Override
	protected void tearDown() throws Exception {
		importedTopologyScope.close(new NullProgressMonitor());
		referencingTopologyScope.close(new NullProgressMonitor());
		testSetup.dispose();
	}

	private void setupImport() throws ExecutionException {
		IStatus status;
		status = referencingTopologyScope.execute(new ModelChange(
				"Configure Imported Topology") {

			public IStatus execute(IProgressMonitor monitor, ChangeScope scope)
					throws ExecutionException {

				Topology topology = scope.openTopology();

				// setup import
				Import imported = FACTORY.createImport();
				imported.setNamespace(NAMESPACE_FRAGMENT);
				imported.setPattern(IMPORTED);
				InstanceConfiguration configuration = FACTORY
						.createInstanceConfiguration();
				imported.setInstanceConfiguration(configuration);

				topology.getImports().add(imported);

				return Status.OK_STATUS;
			}
		}, new NullProgressMonitor());

		referencingTopologyScope.saveChanges(true, null);

		assertTrue(status.isOK());

	}

	private void setupContract() throws ExecutionException {
		IStatus status = importedTopologyScope.execute(new ModelChange(
				"Configure Imported Topology") {

			public IStatus execute(IProgressMonitor monitor, ChangeScope scope)
					throws ExecutionException {

				Topology topology = scope.openTopology();
				Unit explicitPublicUnit = (Unit) topology
						.resolve(EXPLICIT_PUBLIC_UNIT);
				CommunicationCapability communicationCapability1 = (CommunicationCapability) explicitPublicUnit
						.resolve(COMMUNICATION_CAPABILITY1);
				Requirement hostingRequirement1 = (Requirement) explicitPublicUnit
						.resolve(HOSTING_REQUIREMENT1);

				Unit explicitPublicEditableUnit = (Unit) topology
						.resolve(EXPLICIT_PUBLIC_EDITABLE_UNIT);

				Unit implicitPublicUnit = (Unit) topology
						.resolve(IMPLICIT_PUBLIC_UNIT);
				Capability capbility4 = (Capability) implicitPublicUnit
						.resolve(CAPABILITY4);

				ExplicitContract contract = FACTORY.createExplicitContract();
				contract.setDefaultConceptualPolicy(Visibility.PRIVATE_LITERAL);
				contract.setDefaultPolicy(Visibility.PRIVATE_LITERAL);
				topology.setConfigurationContract(contract);

				return Status.OK_STATUS;
			}
		}, new NullProgressMonitor());

		assertTrue(status.isOK());

		importedTopologyScope.saveChanges(true, null);
	}

	private void verifyContract() {
		Topology importedTopology = importedTopologyScope.openTopology();

		Unit hostedUnit = (Unit) importedTopology.resolve(EXPLICIT_PUBLIC_UNIT);
		CommunicationCapability communicationCapability1 = (CommunicationCapability) hostedUnit
				.resolve(COMMUNICATION_CAPABILITY1);
		Requirement hostingRequirement1 = (Requirement) hostedUnit
				.resolve(HOSTING_REQUIREMENT1);

		ConfigurationContract contract = importedTopology
				.getConfigurationContract();

		assertFalse(contract.isPublic(hostedUnit));
		assertFalse(contract.isPublicEditable(hostedUnit));

		assertFalse(contract.isPublic(communicationCapability1));
		assertFalse(contract.isPublicEditable(communicationCapability1));

		assertFalse(contract.isPublic(hostingRequirement1));
		assertFalse(contract.isPublicEditable(hostingRequirement1));

		assertEquals(NUM_TOTAL_UNITS_IN_IMPORT, importedTopology.getUnits()
				.size());
		assertEquals(NUM_PUBLIC_UNITS, contract.getVisibleUnits().size()); 
	}

	private void verifyImport() {

		Topology referencingTopology = referencingTopologyScope.openTopology();
		Import imported = referencingTopology.getImport(NAMESPACE_FRAGMENT,
				IMPORTED);

		InstanceConfiguration instanceConfiguration = imported
				.getInstanceConfiguration();
		List publicUnits = instanceConfiguration.getVisibleUnits();
		assertEquals(NUM_PUBLIC_UNITS, publicUnits.size());
 

	}

	public void testContractDefinition() throws Exception {

		setupContract();
		verifyContract();
	}

	public void testSetupImport() throws Exception {

		setupContract();
		setupImport();
		verifyImport();
	}

	public void testCreateNewRequirementNotAllowed() throws Exception {
		setupContract();
		setupImport();

		Topology referencingTopology = referencingTopologyScope.openTopology();
		final Unit publicUnit = (Unit) referencingTopology
				.resolve(NAMESPACE_FRAGMENT + IConstants.DOT_SEPARATOR
						+ IMPORTED + IConstants.TOPOLOGY_SEPARATOR
						+ IConstants.PATH_SEPARATOR + EXPLICIT_PUBLIC_UNIT);

		try {
			TestSetup.createHostingRequirement(publicUnit,
					AUGMENTED_REQUIREMENT);

		} catch (UnsupportedOperationException e) {
			return;
		}
		assertTrue(false);

	}

	public void testCreateNewCapabilityNotAllowed() throws Exception {
		setupContract();
		setupImport();

		Topology referencingTopology = referencingTopologyScope.openTopology();
		final Unit publicUnit = (Unit) referencingTopology
				.resolve(NAMESPACE_FRAGMENT + IConstants.DOT_SEPARATOR
						+ IMPORTED + IConstants.TOPOLOGY_SEPARATOR
						+ IConstants.PATH_SEPARATOR + EXPLICIT_PUBLIC_UNIT);

		try {
			TestSetup.createCapability(publicUnit, AUGMENTED_CAPABILITY);

		} catch (UnsupportedOperationException e) {
			return;
		}
		assertTrue(false);

	}

	public void testCreateNewRequirementNotAllowedOnConceptualUnit()
			throws Exception {
		setupContract();
		setupImport();

		Topology referencingTopology = referencingTopologyScope.openTopology();
		final Unit publicUnit = (Unit) referencingTopology
				.resolve(NAMESPACE_FRAGMENT + IConstants.DOT_SEPARATOR
						+ IMPORTED + IConstants.TOPOLOGY_SEPARATOR
						+ IConstants.PATH_SEPARATOR + CONCEPTUAL_UNIT);

		try {
			TestSetup.createHostingRequirement(publicUnit,
					AUGMENTED_REQUIREMENT);

		} catch (UnsupportedOperationException e) {
			return;
		}
		assertTrue(false);

	}

	public void testCreateNewCapabilityNotAllowedOnConceptualUnit()
			throws Exception {
		setupContract();
		setupImport();

		Topology referencingTopology = referencingTopologyScope.openTopology();
		final Unit publicUnit = (Unit) referencingTopology
				.resolve(NAMESPACE_FRAGMENT + IConstants.DOT_SEPARATOR
						+ IMPORTED + IConstants.TOPOLOGY_SEPARATOR
						+ IConstants.PATH_SEPARATOR + CONCEPTUAL_UNIT);

		try {
			TestSetup.createCapability(publicUnit, AUGMENTED_CAPABILITY);

		} catch (UnsupportedOperationException e) {
			return;
		}
		assertTrue(false);

	}

}
