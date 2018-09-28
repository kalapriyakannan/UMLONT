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
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import junit.framework.TestCase;
import junit.framework.TestSuite;

import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.core.runtime.Status;
import org.eclipse.emf.common.notify.Notification;

import com.ibm.ccl.soa.deploy.core.Capability;
import com.ibm.ccl.soa.deploy.core.ChangeScope;
import com.ibm.ccl.soa.deploy.core.CommunicationCapability;
import com.ibm.ccl.soa.deploy.core.ConfigurationContract;
import com.ibm.ccl.soa.deploy.core.CoreFactory;
import com.ibm.ccl.soa.deploy.core.CorePackage;
import com.ibm.ccl.soa.deploy.core.ExplicitContract;
import com.ibm.ccl.soa.deploy.core.Import;
import com.ibm.ccl.soa.deploy.core.InstanceConfiguration;
import com.ibm.ccl.soa.deploy.core.Property;
import com.ibm.ccl.soa.deploy.core.RealizationLink;
import com.ibm.ccl.soa.deploy.core.Requirement;
import com.ibm.ccl.soa.deploy.core.RequirementExpression;
import com.ibm.ccl.soa.deploy.core.Topology;
import com.ibm.ccl.soa.deploy.core.Unit;
import com.ibm.ccl.soa.deploy.core.Visibility;
import com.ibm.ccl.soa.deploy.core.test.EObjectEventLogger;
import com.ibm.ccl.soa.deploy.core.test.ModelChange;
import com.ibm.ccl.soa.deploy.core.test.SimpleChangeScope;
import com.ibm.ccl.soa.deploy.core.test.TestSetup;
import com.ibm.ccl.soa.deploy.core.validator.expression.InCardinality;

public class GlobalPropertyTests extends TestCase {

	private static final String ATTR_ORIGIN = "origin";
	private static final String AUGMENTED_CAPABILITY = "AugmentedCapability";
	private static final String AUGMENTED_REQUIREMENT = "AugmentedRequirement";
	private static final String CAPABILITY1 = "Capability1";
	private static final String CAPABILITY2 = "Capability2";
	private static final String CAPABILITY3 = "Capability3";

	private static final String CAPABILITY4 = "Capability4";

	private static final String COMMUNICATION_CAPABILITY1 = "CommunicationCapability1";
	private static final String CONCEPTUAL_UNIT = "HostedUnit4";
	private static final String EDITED = "Edited";
	protected static final String EXPECTED_INCARDINALITY = "1";
	private static final String EXPLICIT_PUBLIC_EDITABLE_UNIT = "HostedUnit2";

	private static final String EXPLICIT_PUBLIC_UNIT = "HostedUnit1";
	public static final CoreFactory FACTORY = CoreFactory.eINSTANCE;

	private static final String HOSTING_CAPABILITY1 = "HostingCapability1";
	private static final String HOSTING_CAPABILITY2 = "HostingCapability2";

	private static final String HOSTING_REQUIREMENT1 = "HostingRequirement1";
	private static final String HOSTING_REQUIREMENT2 = "HostingRequirement2";

	private static final String HOSTING_UNIT1 = "HostingUnit1";
	private static final String HOSTING_UNIT2 = "HostingUnit2";
	protected static final String HOSTNAME_PROPERTY = "hostname";

	private static final String HOSTNAME_VALUE = "www.acme.org";
	protected static final String HOSTNAME_IMPORTED_VALUE = "www.newacme.org";

	private static final BigInteger HTTP_PORT = BigInteger.valueOf(8080);

	private static final String HTTP_PROTOCOL = "http";
	private static final String IMPLICIT_PUBLIC_UNIT = "HostedUnit3";
	private static final String IMPORTED = "Imported";
	private static final String NAMESPACE_FRAGMENT = "com.acme";

	protected static final String NEW_HOSTING_INCARDINALITY = "2";
	private static final int NUM_PUBLIC_EDITABLE_UNITS = 1;

	private static final int NUM_PUBLIC_UNITS = 4;
	private static final int NUM_TOTAL_UNITS_IN_IMPORT = 7;

	protected static final String PORT_PROPERTY = "port";
	private static final String PORT_VALUE = "8080";

	protected static final String PRIVATE_UNIT1 = "PRIVATE_UNIT1";
	protected static final String PRIVATE_UNIT2 = "PRIVATE_UNIT2";
	private static final String PROJECT_NAME = "ExplicitContractTests";
	private static final String REALIZED_UNIT = "HostedUnit5";

	private static final String UNIT1 = "Unit1";
	private static final String UNIT2 = "Unit2";

	public static TestSuite suite() {
		TestSuite suite = new TestSuite();
		// suite.addTest(new
		// GlobalPropertyTests("testGenerateInstanceConfigurationEvents_GlobalProperties"));
		suite.addTestSuite(GlobalPropertyTests.class);
		return suite;
	}

	private SimpleChangeScope importedTopologyScope;
	private SimpleChangeScope referencingTopologyScope;

	private TestSetup testSetup;

	public GlobalPropertyTests(String name) {
		super(name);
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
						Requirement req = TestSetup.createHostingRequirement(
								hostedUnit, HOSTING_REQUIREMENT1);
						// we set this to a value so we can test setting
						// it to a different value later
						req.setDmoEType(CorePackage.eINSTANCE.getArtifact());

						RequirementExpression expr = FACTORY
								.createRequirementExpression();
						expr.setInterpreter(InCardinality.INTERPRETER_ID);
						expr.setValue(EXPECTED_INCARDINALITY);
						req.getExpressions().add(expr);

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

	private void setupContract() throws ExecutionException {
		setupContract(Visibility.PRIVATE_LITERAL, Visibility.PUBLIC_LITERAL);
	}

	private void setupContract(final Visibility defaultPolicy,
			final Visibility defaultConceptualPolicy) throws ExecutionException {
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

				ExplicitContract explicitContract = FACTORY
						.createExplicitContract();
				explicitContract.setDefaultPolicy(defaultPolicy);
				explicitContract
						.setDefaultConceptualPolicy(defaultConceptualPolicy);

				explicitContract.export(explicitPublicUnit, false);
				explicitContract.export(communicationCapability1, true);
				explicitContract.export(hostingRequirement1, true);

				// we will not explicitly export its capability (CAPABILITY3)
				explicitContract.export(explicitPublicEditableUnit, true);

				// we will not explicitly export the container
				// (implicitPublicUnit)
				explicitContract.export(capbility4, true);

				topology.setConfigurationContract(explicitContract);

				return Status.OK_STATUS;
			}
		}, new NullProgressMonitor());

		assertTrue(status.isOK());

		importedTopologyScope.saveChanges(true, null);
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

	@Override
	protected void tearDown() throws Exception {
		importedTopologyScope.close(new NullProgressMonitor());
		referencingTopologyScope.close(new NullProgressMonitor());
		testSetup.dispose();
	}

	public void testContractDefinition() throws Exception {

		setupContract();
		verifyContract();
	}

	public void testCreateGlobalProperty() throws Exception {
		setupContract();
		setupImport();
		{

			importedTopologyScope.execute(new ModelChange(
					"Create hosting link from imported unit") {

				public IStatus execute(IProgressMonitor monitor,
						ChangeScope scope) throws ExecutionException {
					Topology topology = scope.openTopology();
					ConfigurationContract contract = topology
							.getConfigurationContract();

					assertNotNull(contract.exportProperty(PORT_PROPERTY));

					Property p = contract.exportProperty(HOSTNAME_PROPERTY);
					assertNotNull(p);
					assertEquals(p, contract.exportProperty(HOSTNAME_PROPERTY));

					p.setValue(HOSTNAME_VALUE);

					return Status.OK_STATUS;
				}

			}, new NullProgressMonitor());

			importedTopologyScope.saveChangesAndClose(true,
					new NullProgressMonitor());

			Topology topology = importedTopologyScope.openTopology();
			ConfigurationContract contract = topology
					.getConfigurationContract();

			assertTrue(contract.getGlobalProperties().size() == 2);

			Property hostnameProperty = contract.getProperty(HOSTNAME_PROPERTY);
			Property portProperty = contract.getProperty(PORT_PROPERTY);

			assertNotNull(hostnameProperty);
			assertNotNull(portProperty);

			// default value case
			assertEquals(HOSTNAME_VALUE, hostnameProperty.getValue());

			assertTrue(portProperty.getValue() == null
					|| portProperty.getValue().length() == 0);
		}
		// scope the verification
		{
			Topology importedTopology = importedTopologyScope.openTopology();

			Topology referencingTopology = referencingTopologyScope
					.openTopology();
			Import imported = referencingTopology.getImport(NAMESPACE_FRAGMENT,
					IMPORTED);
			Property verifyHostnameProperty = imported
					.getInstanceConfiguration().getProperty(HOSTNAME_PROPERTY);
			final Property verifyPortProperty = imported.getInstanceConfiguration()
					.getProperty(PORT_PROPERTY);

			assertNotNull(verifyHostnameProperty);
			assertNotNull(verifyPortProperty);

			// default value case
			assertEquals(HOSTNAME_VALUE, verifyHostnameProperty.getValue());

			assertEquals(0, verifyPortProperty.getValue().length());

			referencingTopologyScope.execute(new ModelChange(
					"Create hosting link from imported unit") {

				public IStatus execute(IProgressMonitor monitor,
						ChangeScope scope) throws ExecutionException { 

					verifyPortProperty.setValue(PORT_VALUE);

					return Status.OK_STATUS;
				}

			}, new NullProgressMonitor());


			Property importedPortProperty = importedTopology
					.getConfigurationContract().getProperty(PORT_PROPERTY);

			// default value case
			assertNull(importedPortProperty.getValue());

			assertEquals(PORT_VALUE, verifyPortProperty.getValue());

		}

	}

	public void testGenerateContractEvents_GlobalProperties() throws Exception {
		setupContract();
		setupImport();

		final Property EXPECTED_PROPERTY = FACTORY.createProperty();
		EXPECTED_PROPERTY.setName(HOSTNAME_PROPERTY);

		Topology importedTopology = importedTopologyScope.openTopology();
		final ConfigurationContract contract = importedTopology
				.getConfigurationContract();

		EObjectEventLogger logger = new EObjectEventLogger();
		importedTopology.eAdapters().add(logger);

		{ // export
			IStatus status = referencingTopologyScope.execute(new ModelChange(
					"Create hosting link from imported unit") {

				public IStatus execute(IProgressMonitor monitor,
						ChangeScope scope) throws ExecutionException {

					contract.exportProperty(HOSTNAME_PROPERTY);

					return Status.OK_STATUS;
				}

			}, new NullProgressMonitor());

			assertNull(status.getException());
			assertTrue(status.isOK());

			List notifications = logger.getNotifications();
			assertEquals(1, notifications.size());

			Notification notfication1 = (Notification) logger
					.getNotifications().get(0);

			EObjectEventLogger.assertNotification(notfication1,
					Notification.ADD, importedTopology, CorePackage.eINSTANCE
							.getTopology_GlobalProperties(), null,
					EXPECTED_PROPERTY);

		}

		logger.getNotifications().clear();

		{ // unexport

			IStatus status = referencingTopologyScope.execute(new ModelChange(
					"Create hosting link from imported unit") {

				public IStatus execute(IProgressMonitor monitor,
						ChangeScope scope) throws ExecutionException {

					contract.unexportProperty(HOSTNAME_PROPERTY);

					return Status.OK_STATUS;
				}

			}, new NullProgressMonitor());

			assertNull(status.getException());
			assertTrue(status.isOK());

			List notifications = logger.getNotifications();
			assertEquals(1, notifications.size());

			Notification notfication1 = (Notification) logger
					.getNotifications().get(0);

			EObjectEventLogger.assertNotification(notfication1,
					Notification.REMOVE, importedTopology,
					CorePackage.eINSTANCE.getTopology_GlobalProperties(),
					EXPECTED_PROPERTY, null);

		}
	}

	public void testGenerateInstanceConfigurationEvents_GlobalProperties()
			throws Exception {
		setupContract();
		setupImport();

		final Property EXPECTED_HOSTNAME_PROPERTY = FACTORY.createProperty();
		EXPECTED_HOSTNAME_PROPERTY.setName(HOSTNAME_PROPERTY);
		final Property EXPECTED_PORT_PROPERTY = FACTORY.createProperty();
		EXPECTED_PORT_PROPERTY.setName(PORT_PROPERTY);

		final List<Property> EXPECTED_LIST = new ArrayList<Property>();
		EXPECTED_LIST.add(EXPECTED_HOSTNAME_PROPERTY);
		EXPECTED_LIST.add(EXPECTED_PORT_PROPERTY);

		EObjectEventLogger logger = new EObjectEventLogger();

		{ // export

			Topology referencedTopology = referencingTopologyScope
					.openTopology();
			Import imported = referencedTopology.getImport(NAMESPACE_FRAGMENT,
					IMPORTED);
			imported.getInstanceConfiguration().eAdapters().add(logger);

			IStatus status = importedTopologyScope.execute(new ModelChange(
					"Create hosting link from imported unit") {

				public IStatus execute(IProgressMonitor monitor,
						ChangeScope scope) throws ExecutionException {
					Topology topology = scope.openTopology();
					ConfigurationContract contract = topology
							.getConfigurationContract();

					Property hostname = contract
							.exportProperty(HOSTNAME_PROPERTY);
					hostname.setValue(HOSTNAME_VALUE);

					Property port = contract.exportProperty(PORT_PROPERTY);
					port.setValue(PORT_VALUE);

					return Status.OK_STATUS;
				}

			}, new NullProgressMonitor());

			importedTopologyScope.saveChangesAndClose(true,
					new NullProgressMonitor());

			assertNull(status.getException());
			assertTrue(status.isOK());

			List notifications = logger.getNotifications();
			assertEquals(3, notifications.size());

			Notification notfication1 = (Notification) logger
					.getNotifications().get(2);

			EObjectEventLogger.assertNotification(notfication1,
					Notification.SET, imported.getInstanceConfiguration(),
					CorePackage.eINSTANCE
							.getInstanceConfiguration_GlobalProperties(), null,
					EXPECTED_LIST);

		}

		logger.getNotifications().clear();
		{ // configure

			Topology referencedTopology = referencingTopologyScope
					.openTopology();
			Import imported = referencedTopology.getImport(NAMESPACE_FRAGMENT,
					IMPORTED);
			imported.getInstanceConfiguration().eAdapters().add(logger);

			Property hostnameProperty = imported.getInstanceConfiguration()
					.getProperty(HOSTNAME_PROPERTY);
			Property portProperty = imported.getInstanceConfiguration()
					.getProperty(PORT_PROPERTY);
			Property invalidProperty = imported.getInstanceConfiguration()
					.getProperty("Invalid");

			assertNotNull(hostnameProperty);
			assertNotNull(portProperty);
			assertNull(invalidProperty);

			hostnameProperty.eAdapters().add(logger);

			IStatus status = referencingTopologyScope.execute(new ModelChange(
					"Create hosting link from imported unit") {

				public IStatus execute(IProgressMonitor monitor,
						ChangeScope scope) throws ExecutionException {

					Topology referencedTopology = referencingTopologyScope
							.openTopology();
					Import imported = referencedTopology.getImport(
							NAMESPACE_FRAGMENT, IMPORTED);

					Property property = imported.getInstanceConfiguration()
							.getProperty(HOSTNAME_PROPERTY);

					property.setValue(HOSTNAME_IMPORTED_VALUE);

					return Status.OK_STATUS;
				}

			}, new NullProgressMonitor());

			assertNull(status.getException());
			assertTrue(status.isOK());

			List notifications = logger.getNotifications();
			assertEquals(3, notifications.size());

			Notification notfication1 = (Notification) logger
					.getNotifications().get(2);

			EObjectEventLogger.assertNotification(notfication1,
					Notification.SET, hostnameProperty, CorePackage.eINSTANCE
							.getProperty_Value(), HOSTNAME_VALUE,
					HOSTNAME_IMPORTED_VALUE);

			referencingTopologyScope.saveChangesAndClose(true,
					new NullProgressMonitor());

			referencedTopology.eResource().unload();

			assertTrue(referencedTopology.eIsProxy());

		}

		{ // verify

			Topology referencedTopology = referencingTopologyScope
					.openTopology();
			Import imported = referencedTopology.getImport(NAMESPACE_FRAGMENT,
					IMPORTED);

			Property hostnameProperty = imported.getInstanceConfiguration()
					.getProperty(HOSTNAME_PROPERTY);
			assertNotNull(hostnameProperty);
			assertEquals(HOSTNAME_IMPORTED_VALUE, hostnameProperty.getValue());

			Property portProperty = imported.getInstanceConfiguration()
					.getProperty(PORT_PROPERTY);
			assertNotNull(portProperty);
			assertEquals(PORT_VALUE, portProperty.getValue());

		}

		logger.getNotifications().clear();

		{ // revert

			Topology referencedTopology = referencingTopologyScope
					.openTopology();
			Import imported = referencedTopology.getImport(NAMESPACE_FRAGMENT,
					IMPORTED);
			imported.getInstanceConfiguration().eAdapters().add(logger);

			Property hostnameProperty = imported.getInstanceConfiguration()
					.getProperty(HOSTNAME_PROPERTY);

			hostnameProperty.eAdapters().add(logger);

			IStatus status = referencingTopologyScope.execute(new ModelChange(
					"Create hosting link from imported unit") {

				public IStatus execute(IProgressMonitor monitor,
						ChangeScope scope) throws ExecutionException {

					Topology referencedTopology = referencingTopologyScope
							.openTopology();
					Import imported = referencedTopology.getImport(
							NAMESPACE_FRAGMENT, IMPORTED);

					Property property = imported.getInstanceConfiguration()
							.getProperty(HOSTNAME_PROPERTY);

					property.setValue(null);

					return Status.OK_STATUS;
				}

			}, new NullProgressMonitor());

			assertNull(status.getException());
			assertTrue(status.isOK());

			List notifications = logger.getNotifications();
			assertEquals(1, notifications.size());

			Notification notfication1 = (Notification) logger
					.getNotifications().get(0);

			EObjectEventLogger.assertNotification(notfication1,
					Notification.SET, hostnameProperty, CorePackage.eINSTANCE
							.getProperty_Value(), HOSTNAME_IMPORTED_VALUE,
					HOSTNAME_VALUE);

			referencingTopologyScope.saveChangesAndClose(true,
					new NullProgressMonitor());

			referencedTopology.eResource().unload();

			assertTrue(referencedTopology.eIsProxy());

		}

		{ // verify reversion

			Topology referencedTopology = referencingTopologyScope
					.openTopology();
			Import imported = referencedTopology.getImport(NAMESPACE_FRAGMENT,
					IMPORTED);

			Property hostnameProperty = imported.getInstanceConfiguration()
					.getProperty(HOSTNAME_PROPERTY);
			assertNotNull(hostnameProperty);
			assertEquals(HOSTNAME_VALUE, hostnameProperty.getValue());

		}

	}

	public void testRemoveGlobalProperty() throws Exception {
		setupContract();
		setupImport();
		{

			importedTopologyScope.execute(new ModelChange(
					"Create hosting link from imported unit") {

				public IStatus execute(IProgressMonitor monitor,
						ChangeScope scope) throws ExecutionException {
					Topology topology = scope.openTopology();
					ConfigurationContract contract = topology
							.getConfigurationContract();

					assertNotNull(contract.exportProperty(PORT_PROPERTY));

					Property p = contract.exportProperty(HOSTNAME_PROPERTY);
					assertNotNull(p);
					assertEquals(p, contract.exportProperty(HOSTNAME_PROPERTY));

					p.setValue(HOSTNAME_VALUE);

					return Status.OK_STATUS;
				}

			}, new NullProgressMonitor());

			importedTopologyScope.saveChangesAndClose(true,
					new NullProgressMonitor());

			Topology topology = importedTopologyScope.openTopology();
			ConfigurationContract contract = topology
					.getConfigurationContract();

			assertTrue(contract.getGlobalProperties().size() == 2);

			Property hostnameProperty = contract.getProperty(HOSTNAME_PROPERTY);
			Property portProperty = contract.getProperty(PORT_PROPERTY);

			assertNotNull(hostnameProperty);
			assertNotNull(portProperty);

			importedTopologyScope.execute(new ModelChange(
					"Create hosting link from imported unit") {

				public IStatus execute(IProgressMonitor monitor,
						ChangeScope scope) throws ExecutionException {
					Topology topology = scope.openTopology();
					ConfigurationContract contract = topology
							.getConfigurationContract();

					contract.unexportProperty(HOSTNAME_PROPERTY);

					return Status.OK_STATUS;
				}

			}, new NullProgressMonitor());

		}
		// scope the verification
		{

			Topology topology = importedTopologyScope.openTopology();
			ConfigurationContract contract = topology
					.getConfigurationContract();

			assertTrue(contract.getGlobalProperties().size() == 1);

			Property hostnameProperty = contract.getProperty(HOSTNAME_PROPERTY);
			Property portProperty = contract.getProperty(PORT_PROPERTY);

			assertNull(hostnameProperty);
			assertNotNull(portProperty);

		}

	}

	public void testSetupImport() throws Exception {

		setupContract();
		setupImport();
		verifyImport();
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

		assertTrue(contract.isPublic(hostedUnit));
		assertTrue(!contract.isPublicEditable(hostedUnit));

		assertTrue(contract.isPublic(communicationCapability1));
		assertTrue(contract.isPublicEditable(communicationCapability1));

		assertTrue(contract.isPublic(hostingRequirement1));
		assertTrue(contract.isPublicEditable(hostingRequirement1));

		assertEquals(NUM_TOTAL_UNITS_IN_IMPORT, importedTopology.getUnits()
				.size());
		assertEquals(NUM_PUBLIC_UNITS, contract.getPublicUnits().size());
		assertEquals(NUM_PUBLIC_EDITABLE_UNITS, contract
				.getPublicEditableUnits().size());
	}

	private void verifyImport() {

		Topology referencingTopology = referencingTopologyScope.openTopology();
		Import imported = referencingTopology.getImport(NAMESPACE_FRAGMENT,
				IMPORTED);

		InstanceConfiguration instanceConfiguration = imported
				.getInstanceConfiguration();
		List publicUnits = instanceConfiguration.getPublicUnits();
		assertEquals(NUM_PUBLIC_UNITS, publicUnits.size());

		List publicEditableUnits = instanceConfiguration
				.getPublicEditableUnits();

		Unit configuredPublicUnit = null;
		Unit configuredPublicEditableUnit = null;
		Unit conceptualUnit = null;
		for (Iterator iterator = publicUnits.iterator(); iterator.hasNext();) {
			Unit unit = (Unit) iterator.next();
			if (EXPLICIT_PUBLIC_UNIT.equals(unit.getName()))
				configuredPublicUnit = unit;
			if (EXPLICIT_PUBLIC_EDITABLE_UNIT.equals(unit.getName()))
				configuredPublicEditableUnit = unit;
			if (CONCEPTUAL_UNIT.equals(unit.getName()))
				conceptualUnit = unit;
		}

		assertNotNull(configuredPublicUnit);
		assertTrue(instanceConfiguration.isPublic(configuredPublicUnit));
		assertFalse(instanceConfiguration
				.isPublicEditable(configuredPublicUnit));
		assertTrue(configuredPublicUnit.isPublic());
		assertFalse(configuredPublicUnit.isPublicEditable());

		assertNotNull(configuredPublicEditableUnit);
		assertTrue(instanceConfiguration.isPublic(configuredPublicEditableUnit));
		assertTrue(instanceConfiguration
				.isPublicEditable(configuredPublicEditableUnit));
		assertTrue(configuredPublicEditableUnit.isPublic());
		assertTrue(configuredPublicEditableUnit.isPublicEditable());

		assertNotNull(conceptualUnit);
		assertTrue(instanceConfiguration.isPublic(conceptualUnit));
		assertFalse(instanceConfiguration.isPublicEditable(conceptualUnit));
		assertTrue(conceptualUnit.isPublic());
		assertFalse(conceptualUnit.isPublicEditable());

		final CommunicationCapability publicEditableCapability = (CommunicationCapability) configuredPublicUnit
				.resolve(COMMUNICATION_CAPABILITY1);

		assertNotNull(publicEditableCapability);

		assertTrue(instanceConfiguration
				.isPublicEditable(publicEditableCapability));

		final Capability inheritingCapability = (Capability) configuredPublicEditableUnit
				.resolve(CAPABILITY3);

		assertNotNull(inheritingCapability);

		assertTrue(instanceConfiguration.isPublicEditable(inheritingCapability));
	}

}
