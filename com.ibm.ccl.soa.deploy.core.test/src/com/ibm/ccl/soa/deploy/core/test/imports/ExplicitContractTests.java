/*******************************************************************************
 * Copyright (c) 2003, 2007 IBM Corporation Licensed Material - Property of IBM. All rights reserved.
 *  
 * US Government Users Restricted Rights - Use, duplication or disclosure v1.0 restricted by GSA ADP
 * Schedule Contract with IBM Corp.
 * 
 * Contributors: IBM Corporation - initial API and implementation
 *******************************************************************************/
package com.ibm.ccl.soa.deploy.core.test.imports;

import java.lang.reflect.Method;
import java.math.BigInteger;
import java.text.NumberFormat;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

import junit.framework.TestSuite;

import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.commands.operations.IUndoableOperation;
import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.core.runtime.Status;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.EStructuralFeatureImpl.ContainmentUpdatingFeatureMapEntry;
import org.eclipse.emf.workspace.AbstractEMFOperation;

import com.ibm.ccl.soa.deploy.core.Artifact;
import com.ibm.ccl.soa.deploy.core.Augmentation;
import com.ibm.ccl.soa.deploy.core.Capability;
import com.ibm.ccl.soa.deploy.core.ChangeScope;
import com.ibm.ccl.soa.deploy.core.CommunicationCapability;
import com.ibm.ccl.soa.deploy.core.ConfigurationContract;
import com.ibm.ccl.soa.deploy.core.Constraint;
import com.ibm.ccl.soa.deploy.core.ContractProvider;
import com.ibm.ccl.soa.deploy.core.CoreFactory;
import com.ibm.ccl.soa.deploy.core.CorePackage;
import com.ibm.ccl.soa.deploy.core.DeployModelObject;
import com.ibm.ccl.soa.deploy.core.DeploymentTopologyDomain;
import com.ibm.ccl.soa.deploy.core.ExplicitContract;
import com.ibm.ccl.soa.deploy.core.ExtendedAttribute;
import com.ibm.ccl.soa.deploy.core.HostingLink;
import com.ibm.ccl.soa.deploy.core.IConstants;
import com.ibm.ccl.soa.deploy.core.Import;
import com.ibm.ccl.soa.deploy.core.InstanceConfiguration;
import com.ibm.ccl.soa.deploy.core.Instantiation;
import com.ibm.ccl.soa.deploy.core.RealizationLink;
import com.ibm.ccl.soa.deploy.core.Requirement;
import com.ibm.ccl.soa.deploy.core.RequirementExpression;
import com.ibm.ccl.soa.deploy.core.Topology;
import com.ibm.ccl.soa.deploy.core.Unit;
import com.ibm.ccl.soa.deploy.core.Visibility;
import com.ibm.ccl.soa.deploy.core.constraint.AndConstraint;
import com.ibm.ccl.soa.deploy.core.constraint.ConstraintFactory;
import com.ibm.ccl.soa.deploy.core.constraint.ConstraintPackage;
import com.ibm.ccl.soa.deploy.core.constraint.DeferredHostingConstraint;
import com.ibm.ccl.soa.deploy.core.constraint.OrConstraint;
import com.ibm.ccl.soa.deploy.core.constraint.RangeConstraint;
import com.ibm.ccl.soa.deploy.core.constraint.VersionConstraint;
import com.ibm.ccl.soa.deploy.core.operation.DeleteModelObjectOperation;
import com.ibm.ccl.soa.deploy.core.test.EObjectEventLogger;
import com.ibm.ccl.soa.deploy.core.test.ModelChange;
import com.ibm.ccl.soa.deploy.core.test.SimpleChangeScope;
import com.ibm.ccl.soa.deploy.core.test.TestSetup;
import com.ibm.ccl.soa.deploy.core.test.TopologyTestCase;
import com.ibm.ccl.soa.deploy.core.util.TopologyUtil;
import com.ibm.ccl.soa.deploy.core.validator.expression.InCardinality;
import com.ibm.ccl.soa.deploy.internal.core.extension.ContractProviderManager;

public class ExplicitContractTests extends TopologyTestCase {

	private static final String EDITED_DESCRIPTION_VALUE = "EDITED DESCRIPTION VALUE";
	protected static final String NESTED_DESCRIPTION_VALUE = "NESTED DESCRIPTION VALUE";
	
	public static final Boolean DEFAULT_BOOLEAN_ATTR_VALUE = Boolean.TRUE;
	public static final Integer DEFAULT_INTEGER_ATTR_VALUE = new Integer(7);
	public static final String DEFAULT_STRING_ATTR_VALUE = "Hello, World!";
	public static final String BOOLEAN_ATTRIBUTE = "booleanAttribute";
	public static final String INTEGER_ATTRIBUTE = "integerAttribute";
	public static final String STRING_ATTRIBUTE = "stringAttribute";

	private static final String ATTR_ORIGIN = "origin";
	private static final String ATTR_LINKTYPE = "linkType";
	private static final int NUM_TOTAL_UNITS_IN_IMPORT = 7;
	private static final int NUM_PUBLIC_EDITABLE_UNITS = 1;
	private static final int NUM_PUBLIC_UNITS = 4;

	public static final CoreFactory FACTORY = CoreFactory.eINSTANCE;

	private static final String EXPLICIT_PUBLIC_UNIT = "HostedUnit1";
	private static final String EXPLICIT_PUBLIC_EDITABLE_UNIT = "HostedUnit2";
	private static final String IMPLICIT_PUBLIC_UNIT = "HostedUnit3";
	private static final String CONCEPTUAL_UNIT = "HostedUnit4";
	private static final String REALIZED_UNIT = "HostedUnit5";

	private static final String UNIT1 = "Unit1";
	private static final String UNIT2 = "Unit2";

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

	private static final String IMPORT_NAME = "importedImport";

	private static final String PROJECT_NAME = "ExplicitContractTests";
	private static final String NAMESPACE_FRAGMENT = "com.acme";

	private static final String IMPORTED = "Imported";
	private static final String EDITED = "Edited";
	private static final String NESTED = "Nested";

	private static final BigInteger HTTP_PORT = BigInteger.valueOf(8080);
	private static final String HTTP_PROTOCOL = "http";
	protected static final String EXPECTED_INCARDINALITY = "1";
	protected static final String NEW_HOSTING_INCARDINALITY = "2";

	private SimpleChangeScope importedTopologyScope;
	private SimpleChangeScope referencingTopologyScope;
	private SimpleChangeScope nestedImportingTopologyScope;
	private TestSetup testSetup;

	public ExplicitContractTests(String name) {
		super(name);
	}

	public static TestSuite suite() {
		TestSuite suite = new TestSuite();
//		suite.addTest(new ExplicitContractTests("testReExportPublic"));
		suite.addTestSuite(ExplicitContractTests.class);
		return suite;
	}

	protected void setUp() throws Exception {
		super.setUp();

		testSetup = new TestSetup(PROJECT_NAME, NAMESPACE_FRAGMENT);
		importedTopologyScope = testSetup.createTopologyScope(IMPORTED, ChangeScope.OPTION_FORCE_SAVE, new ModelChange(
				"Configure Imported Topology") {

			public IStatus execute(IProgressMonitor monitor, ChangeScope scope) throws ExecutionException {

				Topology topology = scope.openTopology();

				Unit hostedUnit = FACTORY.createUnit();
				hostedUnit.setName(EXPLICIT_PUBLIC_UNIT);
				topology.getUnits().add(hostedUnit);

				TestSetup.createCapability(hostedUnit, CAPABILITY1);
				TestSetup.createCapability(hostedUnit, CAPABILITY2);
				TestSetup.createCommunicationCapability(hostedUnit, COMMUNICATION_CAPABILITY1);
				Requirement req = TestSetup.createHostingRequirement(hostedUnit, HOSTING_REQUIREMENT1);
				// we set this to a value so we can test setting
				// it to a different value later
				req.setDmoEType(CorePackage.eINSTANCE.getArtifact());

				RequirementExpression expr = FACTORY.createRequirementExpression();
				expr.setInterpreter(InCardinality.INTERPRETER_ID);
				expr.setValue(EXPECTED_INCARDINALITY);
				req.getExpressions().add(expr);

				req.getConstraints().add(ConstraintFactory.eINSTANCE.createAndConstraint());

				Unit hostedUnit2 = FACTORY.createUnit();
				hostedUnit2.setName(EXPLICIT_PUBLIC_EDITABLE_UNIT);
				topology.getUnits().add(hostedUnit2);

				TestSetup.createCapability(hostedUnit2, CAPABILITY3);

				Unit hostedUnit3 = FACTORY.createUnit();
				hostedUnit3.setName(IMPLICIT_PUBLIC_UNIT);
				topology.getUnits().add(hostedUnit3);

				TestSetup.createCapability(hostedUnit3, CAPABILITY4);
				TestSetup.createHostingRequirement(hostedUnit3, HOSTING_REQUIREMENT2);

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

		referencingTopologyScope = testSetup.createTopologyScope(EDITED, ChangeScope.OPTION_FORCE_SAVE,
				new ModelChange("Configure Edited Topology") {

					public IStatus execute(IProgressMonitor monitor, ChangeScope scope) throws ExecutionException {

						Topology topology = scope.openTopology();

						Unit hostingUnit = CoreFactory.eINSTANCE.createUnit();
						hostingUnit.setName(HOSTING_UNIT1);
						topology.getUnits().add(hostingUnit);

						TestSetup.createCapability(hostingUnit, HOSTING_CAPABILITY1);

						Unit hostingUnit2 = CoreFactory.eINSTANCE.createUnit();
						hostingUnit2.setName(HOSTING_UNIT2);
						topology.getUnits().add(hostingUnit2);

						return Status.OK_STATUS;
					}
				});
		

		nestedImportingTopologyScope = testSetup.createTopologyScope(NESTED, ChangeScope.OPTION_FORCE_SAVE,
				new ModelChange("Configure Nested Edited Topology") {

					public IStatus execute(IProgressMonitor monitor, ChangeScope scope) throws ExecutionException {

						Topology topology = scope.openTopology();
 
						

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
		nestedImportingTopologyScope.close(new NullProgressMonitor());
		testSetup.dispose();
	}

	private void setupImport() throws ExecutionException {
		IStatus status;
		status = referencingTopologyScope.execute(new ModelChange("Configure Imported Topology") {

			public IStatus execute(IProgressMonitor monitor, ChangeScope scope) throws ExecutionException {

				Topology topology = scope.openTopology();

				// setup import
				Import imported = FACTORY.createImport();
				imported.setNamespace(NAMESPACE_FRAGMENT);
				imported.setPattern(IMPORTED);
				InstanceConfiguration configuration = FACTORY.createInstanceConfiguration();
				imported.setInstanceConfiguration(configuration);

				topology.getImports().add(imported);

				return Status.OK_STATUS;
			}
		}, new NullProgressMonitor());

		referencingTopologyScope.saveChanges(true, null);

		assertTrue(status.isOK());
		status = nestedImportingTopologyScope.execute(new ModelChange("Configure Imported Topology") {

			public IStatus execute(IProgressMonitor monitor, ChangeScope scope) throws ExecutionException {

				Topology topology = scope.openTopology();

				// setup import
				Import imported = FACTORY.createImport();
				imported.setNamespace(NAMESPACE_FRAGMENT);
				imported.setPattern(EDITED);
				imported.setName(IMPORT_NAME);
				InstanceConfiguration configuration = FACTORY.createInstanceConfiguration();
				imported.setInstanceConfiguration(configuration);

				topology.getImports().add(imported);

				return Status.OK_STATUS;
			}
		}, new NullProgressMonitor());

		referencingTopologyScope.saveChanges(true, null);

		assertTrue(status.isOK());

	}

	private void setupContract() throws ExecutionException {
		setupContract(Visibility.PRIVATE_LITERAL, Visibility.PUBLIC_LITERAL);
	}

	private void setupContract(final Visibility defaultPolicy, final Visibility defaultConceptualPolicy)
			throws ExecutionException {
		IStatus status = importedTopologyScope.execute(new ModelChange("Configure Imported Topology") {

			public IStatus execute(IProgressMonitor monitor, ChangeScope scope) throws ExecutionException {

				Topology topology = scope.openTopology();
				
				ExplicitContract explicitContract = FACTORY.createExplicitContract();
				explicitContract.setDefaultPolicy(defaultPolicy);
				explicitContract.setDefaultConceptualPolicy(defaultConceptualPolicy);

				topology.setConfigurationContract(explicitContract);
				
				Unit explicitPublicUnit = (Unit) topology.resolve(EXPLICIT_PUBLIC_UNIT);
				CommunicationCapability communicationCapability1 = (CommunicationCapability) explicitPublicUnit
						.resolve(COMMUNICATION_CAPABILITY1);
				Requirement hostingRequirement1 = (Requirement) explicitPublicUnit.resolve(HOSTING_REQUIREMENT1);

				Unit explicitPublicEditableUnit = (Unit) topology.resolve(EXPLICIT_PUBLIC_EDITABLE_UNIT);

				Unit implicitPublicUnit = (Unit) topology.resolve(IMPLICIT_PUBLIC_UNIT);
				Capability capbility4 = (Capability) implicitPublicUnit.resolve(CAPABILITY4);


				explicitContract.export(explicitPublicUnit, false);
				explicitContract.export(communicationCapability1, true);
				explicitContract.export(hostingRequirement1, true);

				// we will not explicitly export its capability (CAPABILITY3)
				explicitContract.export(explicitPublicEditableUnit, true);

				// we will not explicitly export the container
				// (implicitPublicUnit)
				explicitContract.export(capbility4, true);


				return Status.OK_STATUS;
			}
		}, new NullProgressMonitor());

		assertTrue(status.isOK());

		importedTopologyScope.saveChanges(true, null);
		

		status = referencingTopologyScope.execute(new ModelChange("Configure Imported Topology") {

			public IStatus execute(IProgressMonitor monitor, ChangeScope scope) throws ExecutionException {

				Topology topology = scope.openTopology();
				
				ExplicitContract explicitContract = FACTORY.createExplicitContract();
				explicitContract.setDefaultPolicy(defaultPolicy);
				explicitContract.setDefaultConceptualPolicy(defaultConceptualPolicy);

				topology.setConfigurationContract(explicitContract);
				
				return Status.OK_STATUS;
			}
		}, new NullProgressMonitor());

		assertTrue(status.isOK());

		referencingTopologyScope.saveChanges(true, null);
	}

	private void verifyContract() {
		Topology importedTopology = importedTopologyScope.openTopology();

		Unit hostedUnit = (Unit) importedTopology.resolve(EXPLICIT_PUBLIC_UNIT);
		CommunicationCapability communicationCapability1 = (CommunicationCapability) hostedUnit
				.resolve(COMMUNICATION_CAPABILITY1);
		Requirement hostingRequirement1 = (Requirement) hostedUnit.resolve(HOSTING_REQUIREMENT1);

		ConfigurationContract contract = importedTopology.getConfigurationContract();

		assertTrue(contract.isPublic(hostedUnit));
		assertTrue(!contract.isPublicEditable(hostedUnit));

		assertTrue(contract.isPublic(communicationCapability1));
		assertTrue(contract.isPublicEditable(communicationCapability1));

		assertTrue(contract.isPublic(hostingRequirement1));
		assertTrue(contract.isPublicEditable(hostingRequirement1));

		assertEquals(NUM_TOTAL_UNITS_IN_IMPORT, importedTopology.getUnits().size());
		assertEquals(NUM_PUBLIC_UNITS, contract.getVisibleUnits().size());
	}

	private void verifyImport() {

		Topology referencingTopology = referencingTopologyScope.openTopology();
		Import imported = referencingTopology.getImport(NAMESPACE_FRAGMENT, IMPORTED);

		InstanceConfiguration instanceConfiguration = imported.getInstanceConfiguration();
		List publicUnits = instanceConfiguration.getVisibleUnits();
		assertEquals(NUM_PUBLIC_UNITS, publicUnits.size());

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
		assertFalse(instanceConfiguration.isPublicEditable(configuredPublicUnit));
		assertTrue(configuredPublicUnit.isPublic());
		assertFalse(configuredPublicUnit.isPublicEditable());

		assertNotNull(configuredPublicEditableUnit);
		assertTrue(instanceConfiguration.isPublic(configuredPublicEditableUnit));
		assertTrue(instanceConfiguration.isPublicEditable(configuredPublicEditableUnit));
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

		assertTrue(instanceConfiguration.isPublicEditable(publicEditableCapability));

		final Capability inheritingCapability = (Capability) configuredPublicEditableUnit.resolve(CAPABILITY3);

		assertNotNull(inheritingCapability);

		assertTrue(instanceConfiguration.isPublicEditable(inheritingCapability));
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

	public void testDeConfigurable() throws Exception {
		setupContract();
		verifyContract();

		Topology importedTopology = importedTopologyScope.openTopology();

		final Unit hostedUnit = (Unit) importedTopology.resolve(EXPLICIT_PUBLIC_UNIT);
		final CommunicationCapability communicationCapability1 = (CommunicationCapability) hostedUnit
				.resolve(COMMUNICATION_CAPABILITY1);
		final Requirement hostingRequirement1 = (Requirement) hostedUnit.resolve(HOSTING_REQUIREMENT1);

		final ConfigurationContract contract = importedTopology.getConfigurationContract();

		importedTopologyScope.execute(new ModelChange("Reexport the capability as not configurable") {

			@Override
			public IStatus execute(IProgressMonitor monitor, ChangeScope scope) throws ExecutionException {

				// toggle the configurability
				contract.export(communicationCapability1, false);

				return Status.OK_STATUS;
			}

		}, null);

		assertTrue(contract.isPublic(communicationCapability1));
		assertFalse(contract.isPublicEditable(communicationCapability1));

		importedTopologyScope.execute(new ModelChange("Reexport the requirement as not configurable") {

			@Override
			public IStatus execute(IProgressMonitor monitor, ChangeScope scope) throws ExecutionException {

				// toggle the configurability
				contract.export(communicationCapability1, true);

				return Status.OK_STATUS;
			}

		}, null);

		assertTrue(contract.isPublic(communicationCapability1));
		assertTrue(contract.isPublicEditable(communicationCapability1));

		importedTopologyScope.execute(new ModelChange("Reexport the requirement as not configurable") {

			@Override
			public IStatus execute(IProgressMonitor monitor, ChangeScope scope) throws ExecutionException {

				// toggle the configurability
				contract.export(hostingRequirement1, false);

				return Status.OK_STATUS;
			}

		}, null);

		assertTrue(contract.isPublic(hostingRequirement1));
		assertFalse(contract.isPublicEditable(hostingRequirement1));

		importedTopologyScope.execute(new ModelChange("Reexport the requirement as not configurable") {

			@Override
			public IStatus execute(IProgressMonitor monitor, ChangeScope scope) throws ExecutionException {

				// toggle the configurability
				contract.export(hostingRequirement1, true);

				return Status.OK_STATUS;
			}

		}, null);

		assertTrue(contract.isPublic(hostingRequirement1));
		assertTrue(contract.isPublicEditable(hostingRequirement1));

		importedTopologyScope.execute(new ModelChange("Reexport the requirement as not configurable") {

			@Override
			public IStatus execute(IProgressMonitor monitor, ChangeScope scope) throws ExecutionException {

				// unexport the capability
				contract.unexport(communicationCapability1);

				return Status.OK_STATUS;
			}

		}, null);

		assertFalse(contract.isPublic(communicationCapability1));
		assertFalse(contract.isPublicEditable(communicationCapability1));

		importedTopologyScope.execute(new ModelChange("Reexport the requirement as not configurable") {

			@Override
			public IStatus execute(IProgressMonitor monitor, ChangeScope scope) throws ExecutionException {

				// unexport the capability
				contract.unexport(hostedUnit);

				return Status.OK_STATUS;
			}

		}, null);
		// as the parent is no longer exported as publiceditable,
		// the children should only have their explicit settings
		assertFalse(contract.isPublic(communicationCapability1));
		assertFalse(contract.isPublicEditable(communicationCapability1));

		assertTrue(contract.isPublic(hostingRequirement1));
		assertTrue(contract.isPublicEditable(hostingRequirement1));

		importedTopologyScope.execute(new ModelChange("Reexport the requirement as not configurable") {

			@Override
			public IStatus execute(IProgressMonitor monitor, ChangeScope scope) throws ExecutionException {

				// unexport the requirement
				contract.unexport(hostingRequirement1);

				return Status.OK_STATUS;
			}

		}, null);

		assertFalse(contract.isPublic(hostingRequirement1));
		assertFalse(contract.isPublicEditable(hostingRequirement1));
	}

	public void testDeConfig2() throws Throwable {
		setupContract();
		verifyContract();

		final Topology importedTopology = importedTopologyScope.openTopology();
		final Unit hostedUnit = (Unit) importedTopology.resolve(EXPLICIT_PUBLIC_UNIT);
		final Requirement hostingRequirement1 = (Requirement) hostedUnit.resolve(HOSTING_REQUIREMENT1);

		final RequirementExpression re = CoreFactory.eINSTANCE.createRequirementExpression();
		re.setName("bobdole");

		IStatus stat = importedTopologyScope.execute(new ModelChange("Reexport the capability as not configurable") {

			@Override
			public IStatus execute(IProgressMonitor monitor, ChangeScope scope) throws ExecutionException {

				hostingRequirement1.getExpressions().add(re);
				importedTopology.getConfigurationContract().unexport(re);
				importedTopology.getConfigurationContract().export(re, false);

				return Status.OK_STATUS;
			}

		}, null);

		if (!stat.isOK() && stat.getException() != null) {
			throw stat.getException();
		}
	}

	public void testUndoAttributeChange() throws Exception {
		setupContract();
		setupImport();

		// Get the edit proxy for 'baseUnit'
		Topology referencingTopology = referencingTopologyScope.openTopology();
		Unit proxyUnit = (Unit) referencingTopology.resolve(NAMESPACE_FRAGMENT + IConstants.DOT_SEPARATOR + IMPORTED
				+ IConstants.TOPOLOGY_SEPARATOR + IConstants.PATH_SEPARATOR + EXPLICIT_PUBLIC_EDITABLE_UNIT);
		assert proxyUnit != null;

		// Verify that the first Capability has no DMO Description
		final Capability proxyCap = (Capability) proxyUnit.getCapabilities().get(0);
		assert proxyCap != null;
		assert proxyCap.getDescription() == null;

		// Assign a DMO description
		SimpleChangeScope simpleScope = new SimpleChangeScope(referencingTopologyScope.getTopologyFile());
		IStatus status = simpleScope.execute(new ModelChange("set dmo descr") {

			@Override
			public IStatus execute(IProgressMonitor monitor, ChangeScope scope) throws ExecutionException {
				proxyCap.setDescription("Dummy Description");
				return Status.OK_STATUS;
			}
		}, new NullProgressMonitor());
		assert status.isOK();

		// Verify the DMO Description assignment worked
		assert proxyCap.getDescription().equals("Dummy Description");

		// Undo the assignment
		simpleScope.getScribbler().undoLast(new NullProgressMonitor(), null);

		// Verify there is no longer a DMO Description
		assert proxyCap.getDescription() == null;
	}

	public void deprecatedtestUndoCreateNewArtifact() throws Exception {
		setupContract();
		setupImport();

		// Get the edit proxy for 'baseUnit'
		final Topology referencingTopology = referencingTopologyScope.openTopology();
		final Unit proxyUnit = (Unit) referencingTopology.resolve(NAMESPACE_FRAGMENT + IConstants.DOT_SEPARATOR
				+ IMPORTED + IConstants.TOPOLOGY_SEPARATOR + IConstants.PATH_SEPARATOR + EXPLICIT_PUBLIC_EDITABLE_UNIT);
		assert proxyUnit != null;

		// Verify that Unit has no artifacts
		assert proxyUnit.getArtifacts().size() == 0;
		assert proxyUnit.getDescription() == null;
		assert referencingTopology.getDisplayName() == null;

		// Add an artifact
		ChangeScope simpleScope = ChangeScope.createChangeScopeForWrite(referencingTopologyScope.getTopologyFile());
		AbstractEMFOperation undoable = new AbstractEMFOperation(simpleScope.getTransactionalEditingDomain(),
				"add artifact") {

			@Override
			public IStatus doExecute(IProgressMonitor monitor, IAdaptable info) throws ExecutionException {
				Artifact artifact = CoreFactory.eINSTANCE.createFileArtifact();
				artifact.setName("art");
				proxyUnit.getArtifacts().add(artifact);
				proxyUnit.setDescription("A proxy unit");
				referencingTopology.setDisplayName("Bob Dole");
				return Status.OK_STATUS;
			}
		};
		IStatus status = simpleScope.execute(undoable, new NullProgressMonitor());
		assert status.isOK();

		// Verify the artifact was added
		assert proxyUnit.getArtifacts().size() == 1;

		Artifact artifacto = (Artifact) proxyUnit.getArtifacts().get(0);
		assert "art".equals(artifacto.getName());

		assert proxyUnit.getDescription() != null;
		assert referencingTopology.getDisplayName() != null;

		Import imported = referencingTopology.getImport(NAMESPACE_FRAGMENT, IMPORTED);
		InstanceConfiguration configuration = imported.getInstanceConfiguration();
		Instantiation instantiation = configuration.getInstantiation(IConstants.PATH_SEPARATOR
				+ EXPLICIT_PUBLIC_EDITABLE_UNIT);

		assert instantiation != null;

		Augmentation augmentation = instantiation.getAugmentation("artifacts");

		assert augmentation != null;

		assert augmentation.getAdditions().size() == 1;

		// Undo the addition
		simpleScope.undo(undoable, new NullProgressMonitor());

		assert referencingTopology.getDisplayName() == null;
		assert proxyUnit.getDescription() == null;
		assert artifacto.getName() == null;
		assert augmentation.getAdditions().size() == 0;
		assert proxyUnit.getArtifacts().size() == 0;
	}

	public void testCreateNewArtifact() throws Exception {
		setupContract();
		setupImport();

		Topology importedTopology = importedTopologyScope.openTopology();
		Unit hostedUnit = (Unit) importedTopology.resolve(EXPLICIT_PUBLIC_EDITABLE_UNIT);

		Topology referencingTopology = referencingTopologyScope.openTopology();
		final Unit proxyHostedUnit = (Unit) referencingTopology.resolve(NAMESPACE_FRAGMENT + IConstants.DOT_SEPARATOR
				+ IMPORTED + IConstants.TOPOLOGY_SEPARATOR + IConstants.PATH_SEPARATOR + EXPLICIT_PUBLIC_EDITABLE_UNIT);

		// Add an Artifact to the proxy
		Artifact art = CoreFactory.eINSTANCE.createFileArtifact();
		proxyHostedUnit.getArtifacts().add(art);

		// Verify the original has no artifacts
		assert hostedUnit.getArtifacts().size() == 0;

		// Verify the proxy has an artifact
		assert proxyHostedUnit.getArtifacts().size() == 1;
		Object art2 = proxyHostedUnit.getArtifacts().get(0);
		assert art2 instanceof Artifact;

		Iterator it = proxyHostedUnit.getArtifacts().iterator();
		assert it.hasNext(); // this is failing; size is 1 so it shouldn't be

		Object[] aart = proxyHostedUnit.getArtifacts().toArray();
		assert aart.length == 1;
		assert aart[0] instanceof Artifact; // this is what is failing

		Artifact[] typeSafeaart = (Artifact[]) proxyHostedUnit.getArtifacts().toArray(new Artifact[1]);
		assert typeSafeaart.length == 1;
		assert typeSafeaart[0] instanceof Artifact; // this is what is failing

		Artifact removed = (Artifact) proxyHostedUnit.getArtifacts().remove(0);
		assert removed != null;

		assert proxyHostedUnit.getArtifacts().size() == 0;

		// Add it again
		proxyHostedUnit.getArtifacts().add(art);
		assert proxyHostedUnit.getArtifacts().size() == 1;

		// Remove it by Object, not by index
		proxyHostedUnit.getArtifacts().remove(art);
		assert proxyHostedUnit.getArtifacts().size() == 0;

		// Add it again
		proxyHostedUnit.getArtifacts().add(art);
		assert proxyHostedUnit.getArtifacts().size() == 1;

		// Remove it by Object, not by index
		proxyHostedUnit.getArtifacts().removeAll(Collections.singleton(art));
		assert proxyHostedUnit.getArtifacts().size() == 0;
	}

	public void testCreateNewCapability() throws Exception {
		setupContract();
		setupImport();

		Topology referencingTopology = referencingTopologyScope.openTopology();
		final Unit publicEditableUnit = (Unit) referencingTopology.resolve(NAMESPACE_FRAGMENT
				+ IConstants.DOT_SEPARATOR + IMPORTED + IConstants.TOPOLOGY_SEPARATOR + IConstants.PATH_SEPARATOR
				+ EXPLICIT_PUBLIC_EDITABLE_UNIT);

		int originalSize = publicEditableUnit.getCapabilities().size();

		EObjectEventLogger logger = new EObjectEventLogger();

		publicEditableUnit.eAdapters().add(logger);

		Capability createdHostingCapability = TestSetup.createCapability(publicEditableUnit, AUGMENTED_CAPABILITY);

		assertTrue(logger.getNotifications().size() == 2);
		Notification notification1 = (Notification) logger.getNotifications().get(0);
		Notification notification2 = (Notification) logger.getNotifications().get(1);
		EObjectEventLogger.assertNotification(notification1, Notification.SET, publicEditableUnit,
				CorePackage.Literals.DEPLOY_CORE_ROOT__CAPABILITY, null, createdHostingCapability);

		ContainmentUpdatingFeatureMapEntry entry = new ContainmentUpdatingFeatureMapEntry(
				(EStructuralFeature.Internal) CorePackage.Literals.DEPLOY_CORE_ROOT__CAPABILITY,
				(InternalEObject) createdHostingCapability);
		EObjectEventLogger.assertNotification(notification2, Notification.ADD, publicEditableUnit,
				CorePackage.Literals.UNIT__CAPABILITY_GROUP, null, entry);

		publicEditableUnit.eAdapters().remove(logger);

		assertEquals(originalSize + 1, publicEditableUnit.getCapabilities().size());

		Capability augmentedCapability = null;
		for (Iterator caps = publicEditableUnit.getCapabilities().iterator(); caps.hasNext();) {
			Capability cap = (Capability) caps.next();
			assertTrue(augmentedCapability == null || !AUGMENTED_CAPABILITY.equals(cap.getName()));
			if (AUGMENTED_CAPABILITY.equals(cap.getName()))
				augmentedCapability = cap;
		}
		assertNotNull(augmentedCapability);

		// assertTrue(
		// augmentedCapability.getFullPath().startsWith(configurableUnit.getFullPath())
		// );

		Capability resolved = (Capability) referencingTopology.resolve(augmentedCapability.getFullPath());
		assertNotNull(resolved);
		assertEquals(augmentedCapability, resolved);

	}

	public void testCreateNewRequirement() throws Exception {
		setupContract();
		setupImport();

		Topology referencingTopology = referencingTopologyScope.openTopology();
		final Unit publicEditableUnit = (Unit) referencingTopology.resolve(NAMESPACE_FRAGMENT
				+ IConstants.DOT_SEPARATOR + IMPORTED + IConstants.TOPOLOGY_SEPARATOR + IConstants.PATH_SEPARATOR
				+ EXPLICIT_PUBLIC_EDITABLE_UNIT);

		int originalSize = publicEditableUnit.getRequirements().size();

		EObjectEventLogger logger = new EObjectEventLogger();

		publicEditableUnit.eAdapters().add(logger);

		Requirement createdHostingRequirement = TestSetup.createHostingRequirement(publicEditableUnit,
				AUGMENTED_REQUIREMENT);

		assertTrue(logger.getNotifications().size() == 2);
		Notification notification1 = (Notification) logger.getNotifications().get(0);
		Notification notification2 = (Notification) logger.getNotifications().get(1);
		EObjectEventLogger.assertNotification(notification1, Notification.SET, publicEditableUnit,
				CorePackage.Literals.DEPLOY_CORE_ROOT__REQUIREMENT, null, createdHostingRequirement);
		ContainmentUpdatingFeatureMapEntry entry = new ContainmentUpdatingFeatureMapEntry(
				(EStructuralFeature.Internal) CorePackage.Literals.DEPLOY_CORE_ROOT__REQUIREMENT,
				(InternalEObject) createdHostingRequirement);
		EObjectEventLogger.assertNotification(notification2, Notification.ADD, publicEditableUnit,
				CorePackage.Literals.UNIT__REQUIREMENT_GROUP, null, entry);

		publicEditableUnit.eAdapters().remove(logger);

		assertEquals(originalSize + 1, publicEditableUnit.getRequirements().size());

		Requirement augmentedRequirement = null;
		for (Iterator reqs = publicEditableUnit.getRequirements().iterator(); reqs.hasNext()
				&& augmentedRequirement == null;) {
			Requirement req = (Requirement) reqs.next();
			assertTrue(augmentedRequirement == null || !AUGMENTED_REQUIREMENT.equals(req.getName()));
			if (AUGMENTED_REQUIREMENT.equals(req.getName()))
				augmentedRequirement = req;
		}
		assertNotNull(augmentedRequirement);

		// assertTrue(
		// augmentedRequirement.getFullPath().startsWith(configurableUnit.getFullPath())
		// );

		Requirement resolved = (Requirement) referencingTopology.resolve(augmentedRequirement.getFullPath());
		assertNotNull(resolved);
		assertEquals(augmentedRequirement, resolved);

	}

	public void testCreateNewRequirementAllowed() throws Exception {
		setupContract();
		setupImport();

		Topology referencingTopology = referencingTopologyScope.openTopology();
		final Unit publicUnit = (Unit) referencingTopology.resolve(NAMESPACE_FRAGMENT + IConstants.DOT_SEPARATOR
				+ IMPORTED + IConstants.TOPOLOGY_SEPARATOR + IConstants.PATH_SEPARATOR + EXPLICIT_PUBLIC_UNIT);

		TestSetup.createHostingRequirement(publicUnit, AUGMENTED_REQUIREMENT);

		Requirement augmentedRequirement = null;
		for (Iterator reqs = publicUnit.getRequirements().iterator(); reqs.hasNext() && augmentedRequirement == null;) {
			Requirement req = (Requirement) reqs.next();
			assertTrue(augmentedRequirement == null || !AUGMENTED_REQUIREMENT.equals(req.getName()));
			if (AUGMENTED_REQUIREMENT.equals(req.getName()))
				augmentedRequirement = req;
		}
		assertNotNull(augmentedRequirement);
		Requirement resolved = (Requirement) referencingTopology.resolve(augmentedRequirement.getFullPath());
		assertNotNull(resolved);
		assertEquals(augmentedRequirement, resolved);

	}

	public void testCreateNewCapabilityNotAllowed() throws Exception {
		setupContract();
		setupImport();

		Topology referencingTopology = referencingTopologyScope.openTopology();
		final Unit publicUnit = (Unit) referencingTopology.resolve(NAMESPACE_FRAGMENT + IConstants.DOT_SEPARATOR
				+ IMPORTED + IConstants.TOPOLOGY_SEPARATOR + IConstants.PATH_SEPARATOR + EXPLICIT_PUBLIC_UNIT);

		try {
			TestSetup.createCapability(publicUnit, AUGMENTED_CAPABILITY);

		} catch (UnsupportedOperationException e) {
			return;
		}
		assertTrue(false);

	}

	public void testCreateNewRequirementAllowedOnConceptualUnit() throws Exception {
		setupContract();
		setupImport();

		Topology referencingTopology = referencingTopologyScope.openTopology();
		final Unit conceptualUnit = (Unit) referencingTopology.resolve(NAMESPACE_FRAGMENT + IConstants.DOT_SEPARATOR
				+ IMPORTED + IConstants.TOPOLOGY_SEPARATOR + IConstants.PATH_SEPARATOR + CONCEPTUAL_UNIT);

		TestSetup.createHostingRequirement(conceptualUnit, AUGMENTED_REQUIREMENT);

		Requirement augmentedRequirement = null;
		for (Iterator reqs = conceptualUnit.getRequirements().iterator(); reqs.hasNext()
				&& augmentedRequirement == null;) {
			Requirement req = (Requirement) reqs.next();
			assertTrue(augmentedRequirement == null || !AUGMENTED_REQUIREMENT.equals(req.getName()));
			if (AUGMENTED_REQUIREMENT.equals(req.getName()))
				augmentedRequirement = req;
		}
		assertNotNull(augmentedRequirement);
		Requirement resolved = (Requirement) referencingTopology.resolve(augmentedRequirement.getFullPath());
		assertNotNull(resolved);
		assertEquals(augmentedRequirement, resolved);

	}

	public void testCreateNewCapabilityNotAllowedOnConceptualUnit() throws Exception {
		setupContract();
		setupImport();

		Topology referencingTopology = referencingTopologyScope.openTopology();
		final Unit publicUnit = (Unit) referencingTopology.resolve(NAMESPACE_FRAGMENT + IConstants.DOT_SEPARATOR
				+ IMPORTED + IConstants.TOPOLOGY_SEPARATOR + IConstants.PATH_SEPARATOR + CONCEPTUAL_UNIT);

		try {
			TestSetup.createCapability(publicUnit, AUGMENTED_CAPABILITY);

		} catch (UnsupportedOperationException e) {
			return;
		}
		assertTrue(false);

	}

	public void testRefreshOnExport() throws Exception {
		setupContract();
		setupImport();

		Topology referencingTopology = referencingTopologyScope.openTopology();
		Import imported = referencingTopology.getImport(NAMESPACE_FRAGMENT, IMPORTED);

		int originalPublicUnitSize = imported.getInstanceConfiguration().getPublicUnits().size();
		int originalPublicEditableUnitSize = imported.getInstanceConfiguration().getPublicEditableUnits().size();

		EObjectEventLogger logger = new EObjectEventLogger();
		imported.getInstanceConfiguration().getEObject().eAdapters().add(logger);

		importedTopologyScope.execute(new ModelChange("Add a Public Unit") {

			@Override
			public IStatus execute(IProgressMonitor monitor, ChangeScope scope) throws ExecutionException {
				Topology topology = scope.openTopology();
				Unit unit1 = FACTORY.createUnit();
				unit1.setName(UNIT1);
				topology.getUnits().add(unit1);

				ConfigurationContract contract = topology.getConfigurationContract();
				contract.export(unit1, false);
				return Status.OK_STATUS;
			}

		}, ChangeScope.OPTION_FORCE_SAVE, new NullProgressMonitor());

		List notifications = logger.getNotifications();

		assertEquals(3, notifications.size());

		Notification notfication1 = (Notification) logger.getNotifications().get(0);
		// assertEquals(CorePackage.eINSTANCE
		// .getINCommunicationCapability_ApplicationLayerProtocol(),
		// notfication1.getFeature());
		assertEquals(imported.getInstanceConfiguration(), notfication1.getNotifier());
		assertEquals(originalPublicUnitSize, ((List) notfication1.getOldValue()).size());
		assertEquals(originalPublicUnitSize + 1, ((List) notfication1.getNewValue()).size());

		Notification notfication2 = (Notification) logger.getNotifications().get(1);
		// assertEquals(CorePackage.eINSTANCE
		// .getINCommunicationCapability_ApplicationLayerProtocol(),
		// notfication1.getFeature());
		assertEquals(imported.getInstanceConfiguration(), notfication2.getNotifier());

	}

	public void testRefreshOnNewConceptualNode() throws Exception {
		setupContract();
		setupImport();

		Topology referencingTopology = referencingTopologyScope.openTopology();
		Import imported = referencingTopology.getImport(NAMESPACE_FRAGMENT, IMPORTED);

		int originalPublicUnitSize = imported.getInstanceConfiguration().getPublicUnits().size();
		int originalPublicEditableUnitSize = imported.getInstanceConfiguration().getPublicEditableUnits().size();

		EObjectEventLogger logger = new EObjectEventLogger();
		imported.getInstanceConfiguration().getEObject().eAdapters().add(logger);

		importedTopologyScope.execute(new ModelChange("Add a Conceptual Unit") {

			@Override
			public IStatus execute(IProgressMonitor monitor, ChangeScope scope) throws ExecutionException {
				Topology topology = scope.openTopology();
				Unit unit1 = FACTORY.createUnit();
				unit1.setName(UNIT1);
				unit1.setConceptual(true);
				topology.getUnits().add(unit1);

				return Status.OK_STATUS;
			}

		}, ChangeScope.OPTION_FORCE_SAVE, new NullProgressMonitor());

		List notifications = logger.getNotifications();

		assertEquals(3, notifications.size());

		Notification notfication1 = (Notification) logger.getNotifications().get(0);
		// assertEquals(CorePackage.eINSTANCE
		// .getINCommunicationCapability_ApplicationLayerProtocol(),
		// notfication1.getFeature());
		assertEquals(imported.getInstanceConfiguration(), notfication1.getNotifier());
		assertEquals(originalPublicUnitSize, ((List) notfication1.getOldValue()).size());
		assertEquals(originalPublicUnitSize + 1, ((List) notfication1.getNewValue()).size());

		Notification notfication2 = (Notification) logger.getNotifications().get(1);
		// assertEquals(CorePackage.eINSTANCE
		// .getINCommunicationCapability_ApplicationLayerProtocol(),
		// notfication1.getFeature());
		assertEquals(imported.getInstanceConfiguration(), notfication2.getNotifier());

	}

	public void testRefreshOnNewConceptualNodeWithLink() throws Exception {
		setupContract();
		setupImport();

		Topology referencingTopology = referencingTopologyScope.openTopology();
		Import imported = referencingTopology.getImport(NAMESPACE_FRAGMENT, IMPORTED);

		int originalPublicUnitSize = imported.getInstanceConfiguration().getPublicUnits().size();
		int originalPublicEditableUnitSize = imported.getInstanceConfiguration().getPublicEditableUnits().size();

		EObjectEventLogger logger = new EObjectEventLogger();
		imported.getInstanceConfiguration().getEObject().eAdapters().add(logger);

		importedTopologyScope.execute(new ModelChange("Add a Conceptual Unit") {

			@Override
			public IStatus execute(IProgressMonitor monitor, ChangeScope scope) throws ExecutionException {
				Topology topology = scope.openTopology();
				Unit unit1 = FACTORY.createUnit();
				unit1.setName(UNIT1);
				unit1.setConceptual(true);
				topology.getUnits().add(unit1);

				Unit unit2 = FACTORY.createUnit();
				unit2.setName(UNIT2);
				topology.getUnits().add(unit2);

				RealizationLink link = CoreFactory.eINSTANCE.createRealizationLink();
				link.setSource(unit1);
				link.setTarget(unit2);

				unit1.getRealizationLinks().add(link);

				return Status.OK_STATUS;
			}

		}, ChangeScope.OPTION_FORCE_SAVE, new NullProgressMonitor());

		List notifications = logger.getNotifications();

		assertEquals(3, notifications.size());

		Notification notfication1 = (Notification) logger.getNotifications().get(0);
		// assertEquals(CorePackage.eINSTANCE
		// .getINCommunicationCapability_ApplicationLayerProtocol(),
		// notfication1.getFeature());
		assertEquals(imported.getInstanceConfiguration(), notfication1.getNotifier());
		assertEquals(originalPublicUnitSize, ((List) notfication1.getOldValue()).size());
		assertEquals(originalPublicUnitSize, ((List) notfication1.getNewValue()).size());

		Notification notfication2 = (Notification) logger.getNotifications().get(1);
		// assertEquals(CorePackage.eINSTANCE
		// .getINCommunicationCapability_ApplicationLayerProtocol(),
		// notfication1.getFeature());
		assertEquals(imported.getInstanceConfiguration(), notfication2.getNotifier());

	}

	public void testCreateHostingLink() throws Exception {
		setupContract();
		setupImport();

		Topology referencingTopology = referencingTopologyScope.openTopology();

		final Unit hostedUnit = (Unit) referencingTopology.resolve(EXPLICIT_PUBLIC_UNIT);
		final Unit hostingUnit1 = (Unit) referencingTopology.resolve(HOSTING_UNIT1);

		referencingTopologyScope.execute(new ModelChange("Create hosting link from imported unit") {

			public IStatus execute(IProgressMonitor monitor, ChangeScope scope) throws ExecutionException {

				HostingLink hLink = FACTORY.createHostingLink();
				hLink.setSource(hostingUnit1);
				hLink.setTarget(hostedUnit);

				hostingUnit1.getHostingLinks().add(hLink);

				return Status.OK_STATUS;
			}

		}, new NullProgressMonitor());

		assertEquals(1, hostingUnit1.getHostingLinks().size());
		HostingLink hLink = (HostingLink) hostingUnit1.getHostingLinks().get(0);
		assertEquals(hostingUnit1, hLink.getSource());
		assertEquals(hostedUnit, hLink.getTarget());

	}

	public void testGenerateSetEvents() throws Exception {
		setupContract();
		setupImport();

		Topology referencingTopology = referencingTopologyScope.openTopology();
		Import imported = referencingTopology.getImport(NAMESPACE_FRAGMENT, IMPORTED);

		Unit publicUnit = (Unit) referencingTopology.resolve(NAMESPACE_FRAGMENT + IConstants.DOT_SEPARATOR + IMPORTED
				+ IConstants.TOPOLOGY_SEPARATOR + IConstants.PATH_SEPARATOR + EXPLICIT_PUBLIC_UNIT);

		final CommunicationCapability publicEditableCapability = (CommunicationCapability) publicUnit
				.resolve(COMMUNICATION_CAPABILITY1);

		EObjectEventLogger logger = new EObjectEventLogger();
		publicEditableCapability.eAdapters().add(logger);

		referencingTopologyScope.execute(new ModelChange("Create hosting link from imported unit") {

			public IStatus execute(IProgressMonitor monitor, ChangeScope scope) throws ExecutionException {

				publicEditableCapability.setApplicationLayerProtocol(HTTP_PROTOCOL);
				publicEditableCapability.setPort(HTTP_PORT);

				return Status.OK_STATUS;
			}

		}, new NullProgressMonitor());

		Topology verifyTopology = referencingTopologyScope.openTopology();
		Unit verifyUnit = (Unit) verifyTopology.resolve(NAMESPACE_FRAGMENT + IConstants.DOT_SEPARATOR + IMPORTED
				+ IConstants.TOPOLOGY_SEPARATOR + IConstants.PATH_SEPARATOR + EXPLICIT_PUBLIC_UNIT);

		final CommunicationCapability verifyCapability = (CommunicationCapability) verifyUnit
				.resolve(COMMUNICATION_CAPABILITY1);

		List notifications = logger.getNotifications();
		assertEquals(2, notifications.size());

		Notification notfication1 = (Notification) logger.getNotifications().get(0);

		EObjectEventLogger.assertNotification(notfication1, Notification.SET, publicEditableCapability,
				CorePackage.eINSTANCE.getCommunicationCapability_ApplicationLayerProtocol(), null, HTTP_PROTOCOL);

		assertEquals(HTTP_PROTOCOL, verifyCapability.getApplicationLayerProtocol());

		Notification notfication2 = (Notification) logger.getNotifications().get(1);

		EObjectEventLogger.assertNotification(notfication2, Notification.SET, publicEditableCapability,
				CorePackage.eINSTANCE.getCommunicationCapability_Port(), null, HTTP_PORT);

		assertEquals(HTTP_PORT, verifyCapability.getPort());

	}

	public void testGenerateESetEvents() throws Exception {
		setupContract();
		setupImport();

		Topology referencingTopology = referencingTopologyScope.openTopology();
		Import imported = referencingTopology.getImport(NAMESPACE_FRAGMENT, IMPORTED);

		Unit publicUnit = (Unit) referencingTopology.resolve(NAMESPACE_FRAGMENT + IConstants.DOT_SEPARATOR + IMPORTED
				+ IConstants.TOPOLOGY_SEPARATOR + IConstants.PATH_SEPARATOR + EXPLICIT_PUBLIC_UNIT);

		final CommunicationCapability publicEditableCapability = (CommunicationCapability) publicUnit
				.resolve(COMMUNICATION_CAPABILITY1);

		EObjectEventLogger logger = new EObjectEventLogger();
		publicEditableCapability.eAdapters().add(logger);

		referencingTopologyScope.execute(new ModelChange("Create hosting link from imported unit") {

			public IStatus execute(IProgressMonitor monitor, ChangeScope scope) throws ExecutionException {

				publicEditableCapability.eSet(CorePackage.eINSTANCE
						.getCommunicationCapability_ApplicationLayerProtocol(), HTTP_PROTOCOL);
				publicEditableCapability.eSet(CorePackage.eINSTANCE.getCommunicationCapability_Port(), HTTP_PORT);

				return Status.OK_STATUS;
			}

		}, new NullProgressMonitor());

		referencingTopologyScope.saveChangesAndClose(true, new NullProgressMonitor());

		Topology verifyTopology = referencingTopologyScope.openTopology();
		Unit verifyUnit = (Unit) verifyTopology.resolve(NAMESPACE_FRAGMENT + IConstants.DOT_SEPARATOR + IMPORTED
				+ IConstants.TOPOLOGY_SEPARATOR + IConstants.PATH_SEPARATOR + EXPLICIT_PUBLIC_UNIT);

		final CommunicationCapability verifyCapability = (CommunicationCapability) verifyUnit
				.resolve(COMMUNICATION_CAPABILITY1);

		List notifications = logger.getNotifications();
		assertEquals(2, notifications.size());

		Notification notfication1 = (Notification) logger.getNotifications().get(0);

		EObjectEventLogger.assertNotification(notfication1, Notification.SET, publicEditableCapability,
				CorePackage.eINSTANCE.getCommunicationCapability_ApplicationLayerProtocol(), null, HTTP_PROTOCOL);

		assertEquals(HTTP_PROTOCOL, verifyCapability.eGet(CorePackage.eINSTANCE
				.getCommunicationCapability_ApplicationLayerProtocol()));

		Notification notfication2 = (Notification) logger.getNotifications().get(1);

		EObjectEventLogger.assertNotification(notfication2, Notification.SET, publicEditableCapability,
				CorePackage.eINSTANCE.getCommunicationCapability_Port(), null, HTTP_PORT);

		assertEquals(HTTP_PORT, verifyCapability.eGet(CorePackage.eINSTANCE.getCommunicationCapability_Port()));

	}

	public void testGenerateVisibilityEvents_Unexport() throws Exception {
		setupContract();
		setupImport();

		Topology importedTopology = importedTopologyScope.openTopology();
		final ConfigurationContract contract = importedTopology.getConfigurationContract();

		final Unit publicUnit = (Unit) importedTopology.resolve(IConstants.PATH_SEPARATOR + EXPLICIT_PUBLIC_UNIT);

		assertEquals(true, contract.isPublic(publicUnit));

		EObjectEventLogger logger = new EObjectEventLogger();
		publicUnit.eAdapters().add(logger);

		importedTopologyScope.execute(new ModelChange("Unexport Unit") {

			public IStatus execute(IProgressMonitor monitor, ChangeScope scope) throws ExecutionException {

				contract.unexport(publicUnit);
				return Status.OK_STATUS;
			}

		}, new NullProgressMonitor());

		List notifications = logger.getNotifications();
		assertEquals(1, notifications.size());

		Notification notfication1 = (Notification) logger.getNotifications().get(0);
		EObjectEventLogger.assertNotification(notfication1, Notification.SET, publicUnit, CorePackage.eINSTANCE
				.getDeployModelObject_Visibility(), Visibility.PUBLIC_LITERAL, Visibility.PRIVATE_LITERAL);
	}

	public void testGenerateVisibilityEvents_ExportPublic() throws Exception {
		setupContract();
		setupImport();

		Topology importedTopology = importedTopologyScope.openTopology();
		final ConfigurationContract contract = importedTopology.getConfigurationContract();

		final Unit unit = FACTORY.createUnit();
		unit.setName(UNIT1);

		importedTopologyScope.execute(new ModelChange("Export Unit") {

			public IStatus execute(IProgressMonitor monitor, ChangeScope scope) throws ExecutionException {

				scope.openTopology().getUnits().add(unit);
				return Status.OK_STATUS;
			}

		}, new NullProgressMonitor());

		EObjectEventLogger logger = new EObjectEventLogger();
		unit.eAdapters().add(logger);

		importedTopologyScope.execute(new ModelChange("Export Unit") {

			public IStatus execute(IProgressMonitor monitor, ChangeScope scope) throws ExecutionException {

				contract.export(unit, false);
				return Status.OK_STATUS;
			}

		}, new NullProgressMonitor());

		List notifications = logger.getNotifications();
		assertEquals(1, notifications.size());

		Notification notfication1 = (Notification) logger.getNotifications().get(0);
		EObjectEventLogger.assertNotification(notfication1, Notification.SET, unit, CorePackage.eINSTANCE
				.getDeployModelObject_Visibility(), Visibility.PRIVATE_LITERAL, Visibility.PUBLIC_LITERAL);
		assertEquals(true, contract.isPublic(unit));
		assertEquals(false, contract.isPublicEditable(unit));
	}

	public void testGenerateVisibilityEvents_ExportPublicEditable() throws Exception {
		setupContract();
		setupImport();

		Topology importedTopology = importedTopologyScope.openTopology();
		final ConfigurationContract contract = importedTopology.getConfigurationContract();

		final Unit unit = FACTORY.createUnit();
		unit.setName(UNIT1);

		importedTopologyScope.execute(new ModelChange("Export Unit") {

			public IStatus execute(IProgressMonitor monitor, ChangeScope scope) throws ExecutionException {

				scope.openTopology().getUnits().add(unit);
				return Status.OK_STATUS;
			}

		}, new NullProgressMonitor());

		EObjectEventLogger logger = new EObjectEventLogger();
		unit.eAdapters().add(logger);

		importedTopologyScope.execute(new ModelChange("Export Unit") {

			public IStatus execute(IProgressMonitor monitor, ChangeScope scope) throws ExecutionException {

				contract.export(unit, true);
				return Status.OK_STATUS;
			}

		}, new NullProgressMonitor());

		List notifications = logger.getNotifications();
		assertEquals(1, notifications.size());

		Notification notfication1 = (Notification) logger.getNotifications().get(0);
		EObjectEventLogger.assertNotification(notfication1, Notification.SET, unit, CorePackage.eINSTANCE
				.getDeployModelObject_Visibility(), Visibility.PRIVATE_LITERAL, Visibility.PUBLIC_EDITABLE_LITERAL);
		assertEquals(true, contract.isPublic(unit));
		assertEquals(true, contract.isPublicEditable(unit));
	}

	public void testGenerateVisibilityEvents_ExportedProperties() throws Exception {
		setupContract();
		setupImport();

		Topology importedTopology = importedTopologyScope.openTopology();
		final ConfigurationContract contract = importedTopology.getConfigurationContract();

		final Unit publicUnit = (Unit) importedTopology.resolve(IConstants.PATH_SEPARATOR + EXPLICIT_PUBLIC_UNIT);

		final CommunicationCapability publicEditableCapability = (CommunicationCapability) publicUnit
				.resolve(COMMUNICATION_CAPABILITY1);

		EObjectEventLogger logger = new EObjectEventLogger();
		publicUnit.eAdapters().add(logger);
		publicEditableCapability.eAdapters().add(logger);

		{ // export
			IStatus status = referencingTopologyScope.execute(
					new ModelChange("Create hosting link from imported unit") {

						public IStatus execute(IProgressMonitor monitor, ChangeScope scope) throws ExecutionException {

							contract.export(publicUnit, "description");
							contract.export(publicUnit, CorePackage.eINSTANCE.getUnit_Origin());

							contract.export(publicEditableCapability, "applicationLayerProtocol");
							contract.export(publicEditableCapability, CorePackage.eINSTANCE
									.getCommunicationCapability_Port());

							return Status.OK_STATUS;
						}

					}, new NullProgressMonitor());

			assertNull(status.getException());
			assertTrue(status.isOK());

			assertTrue(contract.isPublicEditable(publicUnit, "description"));
			assertTrue(contract.isPublicEditable(publicUnit, ATTR_ORIGIN));

			assertTrue(contract.isPublicEditable(publicEditableCapability, "applicationLayerProtocol"));
			assertTrue(contract.isPublicEditable(publicEditableCapability, "port"));

			List notifications = logger.getNotifications();
			assertEquals(4, notifications.size());

			Notification notfication1 = (Notification) logger.getNotifications().get(0);
			Notification notfication2 = (Notification) logger.getNotifications().get(1);
			Notification notfication3 = (Notification) logger.getNotifications().get(2);
			Notification notfication4 = (Notification) logger.getNotifications().get(3);

			EObjectEventLogger.assertNotification(notfication1, Notification.ADD, publicUnit, CorePackage.eINSTANCE
					.getDeployModelObject_ExportedProperties(), null, CorePackage.eINSTANCE
					.getDeployModelObject_Description().getName());
			EObjectEventLogger.assertNotification(notfication2, Notification.ADD, publicUnit, CorePackage.eINSTANCE
					.getDeployModelObject_ExportedProperties(), null, CorePackage.eINSTANCE.getUnit_Origin().getName());
			EObjectEventLogger.assertNotification(notfication3, Notification.ADD, publicEditableCapability,
					CorePackage.eINSTANCE.getDeployModelObject_ExportedProperties(), null, CorePackage.eINSTANCE
							.getCommunicationCapability_ApplicationLayerProtocol().getName());
			EObjectEventLogger.assertNotification(notfication4, Notification.ADD, publicEditableCapability,
					CorePackage.eINSTANCE.getDeployModelObject_ExportedProperties(), null, CorePackage.eINSTANCE
							.getCommunicationCapability_Port().getName());

		}

		logger.getNotifications().clear();

		{ // unexport

			IStatus status = referencingTopologyScope.execute(
					new ModelChange("Create hosting link from imported unit") {

						public IStatus execute(IProgressMonitor monitor, ChangeScope scope) throws ExecutionException {

							contract.unexport(publicUnit, "description");
							contract.unexport(publicUnit, CorePackage.eINSTANCE.getUnit_Origin());

							contract.unexport(publicEditableCapability, "applicationLayerProtocol");
							contract.unexport(publicEditableCapability, CorePackage.eINSTANCE
									.getCommunicationCapability_Port());

							return Status.OK_STATUS;
						}

					}, new NullProgressMonitor());

			assertNull(status.getException());
			assertTrue(status.isOK());

			assertFalse(contract.isPublicEditable(publicUnit, "description"));
			assertFalse(contract.isPublicEditable(publicUnit, ATTR_ORIGIN));

			// assertFalse(contract.isPublicEditable(publicEditableCapability,
			// "applicationLayerProtocol"));
			// assertFalse(contract.isPublicEditable(publicEditableCapability,
			// "port"));

			List notifications = logger.getNotifications();
			assertEquals(4, notifications.size());

			Notification notfication1 = (Notification) logger.getNotifications().get(0);
			Notification notfication2 = (Notification) logger.getNotifications().get(1);
			Notification notfication3 = (Notification) logger.getNotifications().get(2);
			Notification notfication4 = (Notification) logger.getNotifications().get(3);

			EObjectEventLogger.assertNotification(notfication1, Notification.REMOVE, publicUnit, CorePackage.eINSTANCE
					.getDeployModelObject_ExportedProperties(), CorePackage.eINSTANCE
					.getDeployModelObject_Description().getName(), null);
			EObjectEventLogger.assertNotification(notfication2, Notification.REMOVE, publicUnit, CorePackage.eINSTANCE
					.getDeployModelObject_ExportedProperties(), CorePackage.eINSTANCE.getUnit_Origin().getName(), null);
			EObjectEventLogger.assertNotification(notfication3, Notification.REMOVE, publicEditableCapability,
					CorePackage.eINSTANCE.getDeployModelObject_ExportedProperties(), CorePackage.eINSTANCE
							.getCommunicationCapability_ApplicationLayerProtocol().getName(), null);
			EObjectEventLogger.assertNotification(notfication4, Notification.REMOVE, publicEditableCapability,
					CorePackage.eINSTANCE.getDeployModelObject_ExportedProperties(), CorePackage.eINSTANCE
							.getCommunicationCapability_Port().getName(), null);
		}

	}

	public void testDeployModelObjectHelperMethods() throws Exception {

		setupContract();
		setupImport();

		Topology referencingTopology = referencingTopologyScope.openTopology();
		Import imported = referencingTopology.getImport(NAMESPACE_FRAGMENT, IMPORTED);

		Unit publicUnit = (Unit) referencingTopology.resolve(NAMESPACE_FRAGMENT + IConstants.DOT_SEPARATOR + IMPORTED
				+ IConstants.TOPOLOGY_SEPARATOR + IConstants.PATH_SEPARATOR + EXPLICIT_PUBLIC_UNIT);

		CommunicationCapability communicationCapability1 = (CommunicationCapability) publicUnit
				.resolve(COMMUNICATION_CAPABILITY1);
		Requirement hostingRequirement1 = (Requirement) publicUnit.resolve(HOSTING_REQUIREMENT1);

		assertTrue(publicUnit.isPublic());
		assertFalse(publicUnit.isPublicEditable());
		assertFalse(publicUnit.isPublicEditable("displayName"));

		assertTrue(communicationCapability1.isPublic());
		assertTrue(communicationCapability1.isPublicEditable());
		// TODO assertTrue(
		// communicationCapability1.isPublicEditable("displayName") );

		assertTrue(hostingRequirement1.isPublic());
		assertTrue(hostingRequirement1.isPublicEditable());
		// TODO assertTrue( hostingRequirement1.isPublicEditable("displayName")
		// );

		Unit publicEditableUnit = (Unit) referencingTopology.resolve(NAMESPACE_FRAGMENT + IConstants.DOT_SEPARATOR
				+ IMPORTED + IConstants.TOPOLOGY_SEPARATOR + IConstants.PATH_SEPARATOR + EXPLICIT_PUBLIC_EDITABLE_UNIT);

		assertTrue(publicEditableUnit.isPublic());
		assertTrue(publicEditableUnit.isPublicEditable());
		assertTrue(publicEditableUnit.isPublicEditable("displayName"));

		Unit implicitPublicUnit = (Unit) referencingTopology.resolve(NAMESPACE_FRAGMENT + IConstants.DOT_SEPARATOR
				+ IMPORTED + IConstants.TOPOLOGY_SEPARATOR + IConstants.PATH_SEPARATOR + IMPLICIT_PUBLIC_UNIT);

		Capability capbility4 = (Capability) implicitPublicUnit.resolve(CAPABILITY4);

		assertFalse(implicitPublicUnit.isPublic());
		assertFalse(implicitPublicUnit.isPublicEditable());
		assertFalse(implicitPublicUnit.isPublicEditable("displayName"));

		assertTrue(capbility4.isPublic());
		assertTrue(capbility4.isPublicEditable());
		// TODO assertTrue( capbility4.isPublicEditable("displayName") );

	}

	public void testExplicitContractProvider() throws Exception {

		ContractProvider provider = ContractProviderManager.getInstance().createProvider(
				ExplicitContract.class.getCanonicalName());
		Topology topology = FACTORY.createTopology();
		provider.installContract(topology);
		assertTrue(topology.getConfigurationContract() instanceof ExplicitContract);
		assertNotNull(topology.getConfigurationContract().getName());
		assertNotNull(topology.getConfigurationContract().getDisplayName());
	}

	public void testIdentityContractProvider() throws Exception {

		ContractProvider provider = ContractProviderManager.getInstance().createProvider(
				ExplicitContract.class.getCanonicalName());
		Topology topology = FACTORY.createTopology();
		provider.installContract(topology);
		assertTrue(topology.getConfigurationContract() instanceof ExplicitContract);
		assertNotNull(topology.getConfigurationContract().getName());
		assertNotNull(topology.getConfigurationContract().getDisplayName());
	}

	public void testNullContractProvider() throws Exception {

		ContractProvider provider = ContractProviderManager.getInstance().createProvider(
				ExplicitContract.class.getCanonicalName());
		Topology topology = FACTORY.createTopology();
		provider.installContract(topology);
		assertTrue(topology.getConfigurationContract() instanceof ExplicitContract);
		assertNotNull(topology.getConfigurationContract().getName());
		assertNotNull(topology.getConfigurationContract().getDisplayName());
	}

	public void testSetContract() throws Exception {
		Topology topology = FACTORY.createTopology();

		ExplicitContract explicit = FACTORY.createExplicitContract();

		ExplicitContract identity = FACTORY.createExplicitContract();

		ExplicitContract nu11 = FACTORY.createExplicitContract();

		assertNull(topology.getConfigurationContract());

		topology.setConfigurationContract(identity);
		assertEquals(identity, topology.getConfigurationContract());

		topology.setConfigurationContract(explicit);
		assertEquals(explicit, topology.getConfigurationContract());

		topology.setConfigurationContract(null);
		assertNull(topology.getConfigurationContract());

		topology.setConfigurationContract(nu11);
		assertEquals(nu11, topology.getConfigurationContract());
	}

	public void testSetProperty() throws Exception {

		setupContract();
		setupImport();
		{
			Topology referencingTopology = referencingTopologyScope.openTopology();
			Import imported = referencingTopology.getImport(NAMESPACE_FRAGMENT, IMPORTED);

			Unit publicUnit = (Unit) referencingTopology.resolve(NAMESPACE_FRAGMENT + IConstants.DOT_SEPARATOR
					+ IMPORTED + IConstants.TOPOLOGY_SEPARATOR + IConstants.PATH_SEPARATOR + EXPLICIT_PUBLIC_UNIT);

			final CommunicationCapability publicEditableCapability = (CommunicationCapability) publicUnit
					.resolve(COMMUNICATION_CAPABILITY1);

			final Requirement hostingRequirement1 = (Requirement) publicUnit.resolve(HOSTING_REQUIREMENT1);

			IStatus status = referencingTopologyScope.execute(
					new ModelChange("Create New capability on Imported Unit") {

						public IStatus execute(IProgressMonitor monitor, ChangeScope scope) throws ExecutionException {

							publicEditableCapability.setApplicationLayerProtocol(HTTP_PROTOCOL);
							publicEditableCapability.setPort(HTTP_PORT);

							RequirementExpression expr = (RequirementExpression) hostingRequirement1.getExpressions()
									.get(0);
							expr.setValue(NEW_HOSTING_INCARDINALITY);

							return Status.OK_STATUS;
						}

					}, new NullProgressMonitor());

			assertTrue(status.isOK());

			referencingTopologyScope.saveChanges(true, null);
			referencingTopologyScope.close(null);

		}

		SimpleChangeScope verficationChangeScope = new SimpleChangeScope(referencingTopologyScope.getTopologyFile());

		Topology verificationTopology = verficationChangeScope.openTopology();

		Unit verificationUnit = (Unit) verificationTopology.resolve(NAMESPACE_FRAGMENT + IConstants.DOT_SEPARATOR
				+ IMPORTED + IConstants.TOPOLOGY_SEPARATOR + IConstants.PATH_SEPARATOR + EXPLICIT_PUBLIC_UNIT);

		final CommunicationCapability verificationCapability = (CommunicationCapability) verificationUnit
				.resolve(COMMUNICATION_CAPABILITY1);

		final Requirement verificationRequirement1 = (Requirement) verificationUnit.resolve(HOSTING_REQUIREMENT1);

		assertEquals(HTTP_PROTOCOL, verificationCapability.getApplicationLayerProtocol());
		assertEquals(HTTP_PORT, verificationCapability.getPort());

		RequirementExpression verificationExpr = (RequirementExpression) verificationRequirement1.getExpressions().get(
				0);
		assertEquals(InCardinality.INTERPRETER_ID, verificationExpr.getInterpreter());
		assertEquals(NEW_HOSTING_INCARDINALITY, verificationExpr.getValue());

	}

	public void testAugmentConstraints() throws Exception {

		setupContract();
		setupImport();
		{
			Topology referencingTopology = referencingTopologyScope.openTopology();
			Import imported = referencingTopology.getImport(NAMESPACE_FRAGMENT, IMPORTED);

			Unit publicUnit = (Unit) referencingTopology.resolve(NAMESPACE_FRAGMENT + IConstants.DOT_SEPARATOR
					+ IMPORTED + IConstants.TOPOLOGY_SEPARATOR + IConstants.PATH_SEPARATOR + EXPLICIT_PUBLIC_UNIT);

			final Requirement hostingRequirement1 = (Requirement) publicUnit.resolve(HOSTING_REQUIREMENT1);

			EObjectEventLogger logger = new EObjectEventLogger();
			hostingRequirement1.eAdapters().add(logger);

			assertEquals(2, hostingRequirement1.getConstraints().size());

			IStatus status = referencingTopologyScope.execute(
					new ModelChange("Create New capability on Imported Unit") {

						public IStatus execute(IProgressMonitor monitor, ChangeScope scope) throws ExecutionException {

							List constraints = hostingRequirement1.getConstraints();

							DeferredHostingConstraint deferredHosting = ConstraintFactory.eINSTANCE
									.createDeferredHostingConstraint();

							VersionConstraint versionConstraint1 = ConstraintFactory.eINSTANCE
									.createVersionConstraint();
							versionConstraint1.setValue("1.0");

							VersionConstraint versionConstraint2 = ConstraintFactory.eINSTANCE
									.createVersionConstraint();
							versionConstraint2.setValue("2.1");

							OrConstraint orConstraint = ConstraintFactory.eINSTANCE.createOrConstraint();
							orConstraint.getConstraints().add(versionConstraint1);
							orConstraint.getConstraints().add(versionConstraint2);

							constraints.add(deferredHosting);
							constraints.add(orConstraint);

							return Status.OK_STATUS;
						}

					}, new NullProgressMonitor());

			assertTrue(status.isOK());

			// make sure the same instance of the list is returned
			assertTrue(hostingRequirement1.getConstraints() == hostingRequirement1.getConstraints());

			// TODO Decide if we should institute the group notifications as
			// well

			assertEquals(4, logger.getNotifications().size());

			List notifications = logger.getNotifications();
			Notification defferedHostingNotificationSet = (Notification) notifications.get(0);
			EObjectEventLogger.assertNotification(defferedHostingNotificationSet, Notification.SET,
					hostingRequirement1, ConstraintPackage.Literals.CONSTRAINT_ROOT__CONSTRAINT_DEFERRED_HOSTING, null,
					hostingRequirement1.getConstraints().get(0));

			Notification defferedHostingNotificationAdd = (Notification) notifications.get(1);
			EObjectEventLogger.assertNotification(defferedHostingNotificationAdd, Notification.ADD,
					hostingRequirement1, CorePackage.Literals.DEPLOY_MODEL_OBJECT__CONSTRAINTS, null,
					hostingRequirement1.getConstraints().get(0));

			Notification orNotificationSet = (Notification) notifications.get(2);
			EObjectEventLogger.assertNotification(orNotificationSet, Notification.SET, hostingRequirement1,
					ConstraintPackage.Literals.CONSTRAINT_ROOT__CONSTRAINT_OR, null, hostingRequirement1
							.getConstraints().get(1));

			Notification orNotificationAdd = (Notification) notifications.get(3);
			EObjectEventLogger.assertNotification(orNotificationAdd, Notification.ADD, hostingRequirement1,
					CorePackage.Literals.DEPLOY_MODEL_OBJECT__CONSTRAINTS, null, hostingRequirement1.getConstraints()
							.get(1));

			// Instantiation instantiation = ((InstanceConfigurationImpl)
			// imported.getInstanceConfiguration()).getInstantiation(hostingRequirement1.getFullPath()
			// );
			// Augmentation augmentation = instantiation.getAugmentation(
			// CorePackage.Literals.DEPLOY_MODEL_OBJECT__CONSTRAINTS.getName());
			//			
			// assertEquals(2, augmentation.eAdapters().size());

			referencingTopologyScope.saveChanges(true, null);
			referencingTopologyScope.close(null);

			hostingRequirement1.eAdapters().remove(logger);

			// forcibly unload the resource
			// referencingTopology.eResource().unload();
			// assertTrue(referencingTopology.eIsProxy());
		}
		{ // verification scope
			SimpleChangeScope verficationChangeScope = new SimpleChangeScope(referencingTopologyScope.getTopologyFile());

			Topology verificationTopology = verficationChangeScope.openTopology();

			Unit verificationUnit = (Unit) verificationTopology.resolve(NAMESPACE_FRAGMENT + IConstants.DOT_SEPARATOR
					+ IMPORTED + IConstants.TOPOLOGY_SEPARATOR + IConstants.PATH_SEPARATOR + EXPLICIT_PUBLIC_UNIT);

			final Requirement verificationRequirement1 = (Requirement) verificationUnit.resolve(HOSTING_REQUIREMENT1);

			List constraints = verificationRequirement1.getConstraints();
			assertEquals(4, constraints.size());

			Constraint deferredHostingConstraint = (Constraint) constraints.get(0);
			Constraint orConstraint = (Constraint) constraints.get(1);
			RequirementExpression expression = (RequirementExpression) constraints.get(2);
			Constraint andConstraint = (Constraint) constraints.get(3);

			assertNotNull(deferredHostingConstraint);
			assertNotNull(orConstraint);
			assertNotNull(expression);
			assertNotNull(andConstraint);

			assertTrue(andConstraint instanceof AndConstraint);
			assertTrue(deferredHostingConstraint instanceof DeferredHostingConstraint);
			assertTrue(orConstraint instanceof OrConstraint);

			assertEquals(2, orConstraint.getConstraints().size());

			List orredConstraints = orConstraint.getConstraints();

			VersionConstraint verifiedVersionConstraint1 = (VersionConstraint) orredConstraints.get(0);
			VersionConstraint verifiedVersionConstraint2 = (VersionConstraint) orredConstraints.get(1);

			assertNotNull(verifiedVersionConstraint1);
			assertNotNull(verifiedVersionConstraint2);

			for (Iterator iterator = verificationRequirement1.getConstraints().iterator(); iterator.hasNext();) {
				assertTrue(iterator.next() instanceof Constraint);
			}
		}

		{ // follow up test scope
			Topology referencingTopology = referencingTopologyScope.openTopology();
			Import imported = referencingTopology.getImport(NAMESPACE_FRAGMENT, IMPORTED);

			Unit publicUnit = (Unit) referencingTopology.resolve(NAMESPACE_FRAGMENT + IConstants.DOT_SEPARATOR
					+ IMPORTED + IConstants.TOPOLOGY_SEPARATOR + IConstants.PATH_SEPARATOR + EXPLICIT_PUBLIC_UNIT);

			final Requirement hostingRequirement1 = (Requirement) publicUnit.resolve(HOSTING_REQUIREMENT1);

			EObjectEventLogger logger = new EObjectEventLogger();

			assertEquals(4, hostingRequirement1.getConstraints().size());
			final Constraint[] formerConstraints = new Constraint[2];

			logger.getNotifications().clear();
			hostingRequirement1.eAdapters().add(logger);

			IStatus status = referencingTopologyScope.execute(
					new ModelChange("Create New capability on Imported Unit") {

						public IStatus execute(IProgressMonitor monitor, ChangeScope scope) throws ExecutionException {

							formerConstraints[0] = (Constraint) hostingRequirement1.getConstraints().remove(0);
							formerConstraints[1] = (Constraint) hostingRequirement1.getConstraints().remove(0);

							return Status.OK_STATUS;
						}

					}, new NullProgressMonitor());

			assertTrue(status.isOK());

			// Instantiation instantiation = ((InstanceConfigurationImpl)
			// imported.getInstanceConfiguration()).getInstantiation(hostingRequirement1.getFullPath()
			// );
			// Augmentation augmentation = instantiation.getAugmentation(
			// CorePackage.Literals.DEPLOY_MODEL_OBJECT__CONSTRAINTS.getName());
			//			
			// assertEquals(2, augmentation.eAdapters().size());

			assertEquals(4, logger.getNotifications().size());

			List notifications = logger.getNotifications();
			Notification defferedHostingNotificationSet = (Notification) notifications.get(0);
			EObjectEventLogger.assertNotification(defferedHostingNotificationSet, Notification.SET,
					hostingRequirement1, ConstraintPackage.Literals.CONSTRAINT_ROOT__CONSTRAINT_DEFERRED_HOSTING,
					formerConstraints[0], null);

			Notification defferedHostingNotificationRemove = (Notification) notifications.get(1);
			EObjectEventLogger.assertNotification(defferedHostingNotificationRemove, Notification.REMOVE,
					hostingRequirement1, CorePackage.Literals.DEPLOY_MODEL_OBJECT__CONSTRAINTS, formerConstraints[0],
					null);

			Notification orNotificationSet = (Notification) notifications.get(2);
			EObjectEventLogger.assertNotification(orNotificationSet, Notification.SET, hostingRequirement1,
					ConstraintPackage.Literals.CONSTRAINT_ROOT__CONSTRAINT_OR, formerConstraints[1], null);

			Notification orNotificationRemove = (Notification) notifications.get(3);
			EObjectEventLogger.assertNotification(orNotificationRemove, Notification.REMOVE, hostingRequirement1,
					CorePackage.Literals.DEPLOY_MODEL_OBJECT__CONSTRAINTS, formerConstraints[1], null);

			referencingTopologyScope.saveChanges(true, null);
			referencingTopologyScope.close(null);

			// forcibly unload the resource
			// referencingTopology.eResource().unload();
			// assertTrue(referencingTopology.eIsProxy());
		}

	}

	public void testAugmentConstraints2() throws Exception {

		// Add a constraint *before importing*
		final Topology importedTopology = importedTopologyScope.openTopology();
		final Unit baseUnit = (Unit) importedTopology.resolve(EXPLICIT_PUBLIC_EDITABLE_UNIT);

		importedTopologyScope.execute(new ModelChange("Add Constraint") {

			public IStatus execute(IProgressMonitor monitor, ChangeScope scope) throws ExecutionException {

				RangeConstraint constraint = ConstraintFactory.eINSTANCE.createRangeConstraint();
				constraint.setName("c0");
				baseUnit.getConstraints().add(constraint);

				return Status.OK_STATUS;
			}

		}, new NullProgressMonitor());

		// Set up importing
		setupContract();
		setupImport();

		Topology referencingTopology = referencingTopologyScope.openTopology();
		Import imported = referencingTopology.getImport(NAMESPACE_FRAGMENT, IMPORTED);

		Unit publicUnit = (Unit) referencingTopology.resolve(NAMESPACE_FRAGMENT + IConstants.DOT_SEPARATOR + IMPORTED
				+ IConstants.TOPOLOGY_SEPARATOR + IConstants.PATH_SEPARATOR + EXPLICIT_PUBLIC_EDITABLE_UNIT);
		// System.out.println("@@@size=" + publicUnit.getConstraints().size());

		assertEquals(baseUnit.getConstraints().size(), 1);
		assertEquals(baseUnit.getConstraints().size(), publicUnit.getConstraints().size());

		// Now remove the Constraint

		// The following code would fail
		// publicUnit.getConstraints().remove(0);

		// This code, however, succeeds.
		Constraint proxyConstraint = (Constraint) publicUnit.getConstraints().get(0);
		IUndoableOperation op = DeleteModelObjectOperation.createDeleteModelObjectOperation(Collections
				.singletonList(proxyConstraint), "delete constraint");

		final ChangeScope<DeployModelObject, DeploymentTopologyDomain> scope = ChangeScope
				.createChangeScopeForWrite((DeployModelObject) publicUnit);

		IStatus status = Status.OK_STATUS;
		try {
			status = scope.execute(op, new NullProgressMonitor());
		} finally {
			if (scope != null) {
				scope.close(new NullProgressMonitor());
			}
		}

		assertFalse("Removal of imported constrainted should be prohibited", status.isOK());

		// At this point, the proxy thinks it has 0 constraints, but the
		// original has 1 constraint!

		// System.out.println("@@@size=" + publicUnit.getConstraints().size());
		// System.out.println("@@@size=" + baseUnit.getConstraints().size());

		assertEquals(baseUnit.getConstraints().size(), 1);
		assertEquals(baseUnit.getConstraints().size(), publicUnit.getConstraints().size());
	}

	public void testSetDmoEType() throws Exception {

		setupContract();
		setupImport();

		Topology referencingTopology = referencingTopologyScope.openTopology();
		Import imported = referencingTopology.getImport(NAMESPACE_FRAGMENT, IMPORTED);

		Unit publicUnit = (Unit) referencingTopology.resolve(NAMESPACE_FRAGMENT + IConstants.DOT_SEPARATOR + IMPORTED
				+ IConstants.TOPOLOGY_SEPARATOR + IConstants.PATH_SEPARATOR + EXPLICIT_PUBLIC_UNIT);

		final Requirement hostingRequirement1 = (Requirement) publicUnit.resolve(HOSTING_REQUIREMENT1);

		assertEquals(CorePackage.eINSTANCE.getArtifact(), hostingRequirement1.getDmoEType());

		IStatus status = referencingTopologyScope.execute(new ModelChange("Create New capability on Imported Unit") {

			public IStatus execute(IProgressMonitor monitor, ChangeScope scope) throws ExecutionException {

				hostingRequirement1.setDmoEType(CorePackage.eINSTANCE.getCommunicationCapability());

				return Status.OK_STATUS;
			}

		}, new NullProgressMonitor());

		assertTrue(status.isOK());

		referencingTopologyScope.saveChanges(true, null);
		referencingTopologyScope.close(null);

		SimpleChangeScope verficationChangeScope = new SimpleChangeScope(referencingTopologyScope.getTopologyFile());

		Topology verificationTopology = verficationChangeScope.openTopology();

		Unit verificationUnit = (Unit) verificationTopology.resolve(NAMESPACE_FRAGMENT + IConstants.DOT_SEPARATOR
				+ IMPORTED + IConstants.TOPOLOGY_SEPARATOR + IConstants.PATH_SEPARATOR + EXPLICIT_PUBLIC_UNIT);

		final Requirement verificationRequirement1 = (Requirement) verificationUnit.resolve(HOSTING_REQUIREMENT1);

		assertEquals(CorePackage.eINSTANCE.getCommunicationCapability(), verificationRequirement1.getDmoEType());

	}

	public void testGetParentOfRequirement() throws Exception {
		setupContract();
		setupImport();

		Topology referencingTopology = referencingTopologyScope.openTopology();
		final Unit publicEditableUnit = (Unit) referencingTopology.resolve(NAMESPACE_FRAGMENT
				+ IConstants.DOT_SEPARATOR + IMPORTED + IConstants.TOPOLOGY_SEPARATOR + IConstants.PATH_SEPARATOR
				+ EXPLICIT_PUBLIC_EDITABLE_UNIT);

		int originalSize = publicEditableUnit.getRequirements().size();

		TestSetup.createHostingRequirement(publicEditableUnit, AUGMENTED_REQUIREMENT);

		assertEquals(originalSize + 1, publicEditableUnit.getRequirements().size());

		Requirement augmentedRequirement = null;
		for (Iterator reqs = publicEditableUnit.getRequirements().iterator(); reqs.hasNext()
				&& augmentedRequirement == null;) {
			Requirement req = (Requirement) reqs.next();
			assertTrue(augmentedRequirement == null || !AUGMENTED_REQUIREMENT.equals(req.getName()));
			if (AUGMENTED_REQUIREMENT.equals(req.getName()))
				augmentedRequirement = req;
			assertEquals(publicEditableUnit.getFullPath() + IConstants.PATH_SEPARATOR + req.getName(), req
					.getFullPath());
			assertTrue(publicEditableUnit == (Unit) req.getParent());
		}

		Constraint constraint = ConstraintFactory.eINSTANCE.createOrConstraint();
		augmentedRequirement.getConstraints().add(constraint);

		assertTrue(augmentedRequirement == constraint.getParent());

	}

	public void testGetParentOfCapability() throws Exception {
		setupContract();
		setupImport();

		Topology referencingTopology = referencingTopologyScope.openTopology();
		final Unit publicEditableUnit = (Unit) referencingTopology.resolve(NAMESPACE_FRAGMENT
				+ IConstants.DOT_SEPARATOR + IMPORTED + IConstants.TOPOLOGY_SEPARATOR + IConstants.PATH_SEPARATOR
				+ EXPLICIT_PUBLIC_EDITABLE_UNIT);

		int originalSize = publicEditableUnit.getCapabilities().size();

		referencingTopologyScope.execute(new ModelChange("Create Augmented Capability") {
			@Override
			public IStatus execute(IProgressMonitor monitor, ChangeScope scope) throws ExecutionException {

				TestSetup.createCapability(publicEditableUnit, AUGMENTED_CAPABILITY);
				return Status.OK_STATUS;
			}
		}, null);

		assertEquals(originalSize + 1, publicEditableUnit.getCapabilities().size());

		Capability augmentedCapability = null;
		for (Iterator caps = publicEditableUnit.getCapabilities().iterator(); caps.hasNext();) {
			Capability cap = (Capability) caps.next();
			assertTrue(augmentedCapability == null || !AUGMENTED_CAPABILITY.equals(cap.getName()));
			if (AUGMENTED_CAPABILITY.equals(cap.getName()))
				augmentedCapability = cap;
			assertTrue(publicEditableUnit == (Unit) cap.getParent());
		}
	}

	public void testExportUnitAttributeAsPublicEditable_WithPublicPublicPolicy() throws Exception {
		setupContract(Visibility.PUBLIC_LITERAL, Visibility.PUBLIC_LITERAL);
		setupImport();

		Topology importedTopology = importedTopologyScope.openTopology();
		final ConfigurationContract contract = importedTopology.getConfigurationContract();

		final Unit unit = FACTORY.createUnit();
		unit.setName(UNIT1);

		importedTopologyScope.execute(new ModelChange("Export Unit") {

			public IStatus execute(IProgressMonitor monitor, ChangeScope scope) throws ExecutionException {
				contract.export(unit, ATTR_ORIGIN);

				return Status.OK_STATUS;
			}

		}, new NullProgressMonitor());

		assertTrue(contract.isPublicEditable(unit, ATTR_ORIGIN));

		// ensure the unit is public as the default policy is public
		assertTrue(contract.isPublic(unit));
		assertFalse(contract.isPublicEditable(unit));

	}

	public void testUnexportCapabilityAttribute_FromPublicEditableUnit() throws Exception {
		setupContract(Visibility.PUBLIC_LITERAL, Visibility.PUBLIC_LITERAL);
		setupImport();

		final Topology importedTopology = importedTopologyScope.openTopology();
		final ConfigurationContract contract = importedTopology.getConfigurationContract();

		final Unit unit = FACTORY.createUnit();
		unit.setName(UNIT1);
		final Capability cap = FACTORY.createCommunicationCapability();
		cap.setName(CAPABILITY1);
		unit.getCapabilities().add(cap);

		importedTopologyScope.execute(new ModelChange("Export Unit") {

			public IStatus execute(IProgressMonitor monitor, ChangeScope scope) throws ExecutionException {
				importedTopology.getUnits().add(unit);
				contract.export(unit, true);
				contract.unexport(cap, CorePackage.Literals.COMMUNICATION_CAPABILITY__PORT);

				return Status.OK_STATUS;
			}

		}, new NullProgressMonitor());

		// ensure the unit is public
		assertTrue(contract.isPublicEditable(unit));
		// but the attribute is private
		assertFalse(contract.isPublicEditable(cap, CorePackage.Literals.COMMUNICATION_CAPABILITY__PORT.getName()));
	}

	public void testUnexportUnit_WithPublicPublicPolicy() throws Exception {
		setupContract(Visibility.PUBLIC_LITERAL, Visibility.PUBLIC_LITERAL);
		setupImport();

		Topology importedTopology = importedTopologyScope.openTopology();
		final ConfigurationContract contract = importedTopology.getConfigurationContract();

		final Unit unit = FACTORY.createUnit();
		unit.setName(UNIT1);

		importedTopologyScope.execute(new ModelChange("Export Unit") {

			public IStatus execute(IProgressMonitor monitor, ChangeScope scope) throws ExecutionException {
				contract.unexport(unit);

				return Status.OK_STATUS;
			}

		}, new NullProgressMonitor());

		// ensure the unit is public as the default policy is public
		assertFalse(contract.isPublic(unit));
		assertFalse(contract.isPublicEditable(unit));

	}

	public void testExportUnitAttributeAsPublicEditable_WithPublicEditablePublicPolicy() throws Exception {
		setupContract(Visibility.PUBLIC_EDITABLE_LITERAL, Visibility.PUBLIC_LITERAL);
		setupImport();

		Topology importedTopology = importedTopologyScope.openTopology();
		final ConfigurationContract contract = importedTopology.getConfigurationContract();

		importedTopologyScope.execute(new ModelChange("Export Unit") {

			public IStatus execute(IProgressMonitor monitor, ChangeScope scope) throws ExecutionException {

				final Unit unit = FACTORY.createUnit();
				unit.setName(UNIT1);
				scope.openTopology().getUnits().add(unit);
				// when the policy is public editable, exporting an attribute
				// will hide it
				contract.export(unit, ATTR_ORIGIN);

				return Status.OK_STATUS;
			}

		}, new NullProgressMonitor());

		Unit unit = (Unit) importedTopology.resolve(UNIT1);

		assertTrue(contract.isPublicEditable(unit, ATTR_ORIGIN));

		// ensure the unit is public as the default policy is public
		assertTrue(contract.isPublic(unit));
		assertTrue(contract.isPublicEditable(unit));

	}

	public void testExportExtendedAttributeAsPublicEditable_WithPublicPublicPolicy() throws Exception {
		setupContract(Visibility.PUBLIC_LITERAL, Visibility.PUBLIC_LITERAL);
		setupImport();

		Topology importedTopology = importedTopologyScope.openTopology();
		final ConfigurationContract contract = importedTopology.getConfigurationContract();

		importedTopologyScope.execute(new ModelChange("Export Unit") {

			public IStatus execute(IProgressMonitor monitor, ChangeScope scope) throws ExecutionException {

				Unit unit = FACTORY.createUnit();
				unit.setName(UNIT1);

				// create 3 extended attributes for unit1; the first two will be
				// exported.

				ExtendedAttribute ea1 = CoreFactory.eINSTANCE.createExtendedAttribute();
				ea1.setName(STRING_ATTRIBUTE);
				ea1.setValue(DEFAULT_STRING_ATTR_VALUE);
				// ea1.setInstanceType(XMLTypePackage.Literals.STRING);
				unit.getExtendedAttributes().add(ea1);

				ExtendedAttribute ea2 = CoreFactory.eINSTANCE.createExtendedAttribute();
				ea2.setName(INTEGER_ATTRIBUTE);
				ea2.setValue(DEFAULT_INTEGER_ATTR_VALUE);
				// ea2.setInstanceType(XMLTypePackage.Literals.INT);
				unit.getExtendedAttributes().add(ea2);

				ExtendedAttribute ea3 = CoreFactory.eINSTANCE.createExtendedAttribute();
				ea3.setName(BOOLEAN_ATTRIBUTE);
				ea3.setValue(DEFAULT_BOOLEAN_ATTR_VALUE);
				// ea3.setInstanceType(XMLTypePackage.Literals.BOOLEAN);
				unit.getExtendedAttributes().add(ea3);

				// create a private unit with one public extended attribute

				Unit unit2 = FACTORY.createUnit();
				unit2.setName(UNIT2);

				ExtendedAttribute ea4 = CoreFactory.eINSTANCE.createExtendedAttribute();
				ea4.setName(STRING_ATTRIBUTE);
				ea4.setValue(DEFAULT_STRING_ATTR_VALUE);
				// ea4.setInstanceType(XMLTypePackage.Literals.STRING);
				unit2.getExtendedAttributes().add(ea4);

				scope.openTopology().getUnits().add(unit);
				scope.openTopology().getUnits().add(unit2);

				contract.export(unit, ea1.getName());
				contract.export(unit, ea2.getName());
				// we don't export ea3
				contract.unexport(unit2);
				contract.export(unit2, ea4.getName());

				return Status.OK_STATUS;
			}

		}, new NullProgressMonitor());

		importedTopologyScope.saveChanges(true, null);

		{
			Unit unit1 = (Unit) importedTopology.resolve(UNIT1);
			Unit unit2 = (Unit) importedTopology.resolve(UNIT2);

			// ensure the unit is public as the default policy is public
			assertTrue(contract.isPublic(unit1));
			assertFalse(contract.isPublicEditable(unit1));

			assertFalse(contract.isPublic(unit2));
			assertFalse(contract.isPublicEditable(unit2));

			assertTrue(contract.isPublicEditable(unit1, STRING_ATTRIBUTE));
			assertTrue(contract.isPublicEditable(unit1, INTEGER_ATTRIBUTE));
			assertFalse(contract.isPublicEditable(unit1, BOOLEAN_ATTRIBUTE));

			assertTrue(contract.isPublicEditable(unit2, STRING_ATTRIBUTE));
		}

		{

			Topology referencingTopology = referencingTopologyScope.openTopology();
			Unit unit1 = (Unit) referencingTopology.resolve(NAMESPACE_FRAGMENT + IConstants.DOT_SEPARATOR + IMPORTED
					+ IConstants.TOPOLOGY_SEPARATOR + IConstants.PATH_SEPARATOR + UNIT1);
			Unit unit2 = (Unit) referencingTopology.resolve(NAMESPACE_FRAGMENT + IConstants.DOT_SEPARATOR + IMPORTED
					+ IConstants.TOPOLOGY_SEPARATOR + IConstants.PATH_SEPARATOR + UNIT2);

			assertTrue(unit1.isPublic());
			assertFalse(unit1.isPublicEditable());

			assertFalse(unit2.isPublic());
			assertFalse(unit2.isPublicEditable());

			assertTrue(unit1.isPublicEditable(STRING_ATTRIBUTE));
			assertTrue(unit1.isPublicEditable(INTEGER_ATTRIBUTE));
			assertFalse(unit1.isPublicEditable(BOOLEAN_ATTRIBUTE));

			assertTrue(unit2.isPublicEditable(STRING_ATTRIBUTE));

			final ExtendedAttribute unit1StringAttr = unit1.getExtendedAttribute(STRING_ATTRIBUTE);
			final ExtendedAttribute unit1IntAttr = unit1.getExtendedAttribute(INTEGER_ATTRIBUTE);
			final ExtendedAttribute unit1BooleanAttr = unit1.getExtendedAttribute(BOOLEAN_ATTRIBUTE);

			assertEquals(DEFAULT_STRING_ATTR_VALUE, unit1StringAttr.getValue());
			assertEquals(DEFAULT_INTEGER_ATTR_VALUE, unit1IntAttr.getValue());
			assertEquals(DEFAULT_BOOLEAN_ATTR_VALUE, unit1BooleanAttr.getValue());

			final ExtendedAttribute unit2StringAttr = unit2.getExtendedAttribute(STRING_ATTRIBUTE);
			assertEquals(DEFAULT_STRING_ATTR_VALUE, unit2StringAttr.getValue());

			referencingTopologyScope.execute(new ModelChange("Override values") {

				@Override
				public IStatus execute(IProgressMonitor monitor, ChangeScope scope) {

					unit1StringAttr.setValue("Overridden value");
					assertEquals("Overridden value", unit1StringAttr.getValue());

					unit1IntAttr.setValue(new Integer(-7));
					assertEquals(new Integer(-7), unit1IntAttr.getValue());

					unit2StringAttr.setValue("Overridden Second value");
					assertEquals("Overridden Second value", unit2StringAttr.getValue());

					return Status.OK_STATUS;
				}

			}, null);

			referencingTopologyScope.saveChanges(true, null);
		}

		// verify original topology left in tact
		{
			Unit unit1 = (Unit) importedTopology.resolve(UNIT1);
			Unit unit2 = (Unit) importedTopology.resolve(UNIT2);

			// ensure the unit is public as the default policy is public
			assertTrue(contract.isPublic(unit1));
			assertFalse(contract.isPublicEditable(unit1));

			assertFalse(contract.isPublic(unit2));
			assertFalse(contract.isPublicEditable(unit2));

			assertTrue(contract.isPublicEditable(unit1, STRING_ATTRIBUTE));
			assertTrue(contract.isPublicEditable(unit1, INTEGER_ATTRIBUTE));
			assertFalse(contract.isPublicEditable(unit1, BOOLEAN_ATTRIBUTE));

			assertTrue(contract.isPublicEditable(unit2, STRING_ATTRIBUTE));
		}

	}

	public void testExportExtendedAttributeEAttributesAsPublicEditable_WithPublicPublicPolicy() throws Exception {
		setupContract(Visibility.PUBLIC_LITERAL, Visibility.PUBLIC_LITERAL);
		setupImport();

		Topology importedTopology = importedTopologyScope.openTopology();
		final ConfigurationContract contract = importedTopology.getConfigurationContract();

		importedTopologyScope.execute(new ModelChange("Export Unit") {

			public IStatus execute(IProgressMonitor monitor, ChangeScope scope) throws ExecutionException {

				Unit unit = FACTORY.createUnit();
				unit.setName(UNIT1);

				// create 3 extended attributes for unit1; the first two will be
				// exported.

				ExtendedAttribute ea1 = CoreFactory.eINSTANCE.createExtendedAttribute();
				ea1.setName(STRING_ATTRIBUTE);
				//ea1.setValue(DEFAULT_STRING_ATTR_VALUE);
				// ea1.setInstanceType(XMLTypePackage.Literals.STRING);
				unit.getExtendedAttributes().add(ea1);
				unit.eSet(ea1, DEFAULT_STRING_ATTR_VALUE);

				ExtendedAttribute ea2 = CoreFactory.eINSTANCE.createExtendedAttribute();
				ea2.setName(INTEGER_ATTRIBUTE);
				//ea2.setValue(DEFAULT_INTEGER_ATTR_VALUE);
				//ea2.setInstanceType(XMLTypePackage.Literals.INT_OBJECT);
				unit.getExtendedAttributes().add(ea2);
				unit.eSet(ea2, DEFAULT_INTEGER_ATTR_VALUE);

				ExtendedAttribute ea3 = CoreFactory.eINSTANCE.createExtendedAttribute();
				ea3.setName(BOOLEAN_ATTRIBUTE);
				//ea3.setValue(DEFAULT_BOOLEAN_ATTR_VALUE);
				//ea3.setInstanceType(XMLTypePackage.Literals.BOOLEAN);
				unit.getExtendedAttributes().add(ea3);
				unit.eSet(ea3, DEFAULT_BOOLEAN_ATTR_VALUE);

				// create a private unit with one public extended attribute

				Unit unit2 = FACTORY.createUnit();
				unit2.setName(UNIT2);

				ExtendedAttribute ea4 = CoreFactory.eINSTANCE.createExtendedAttribute();
				ea4.setName(STRING_ATTRIBUTE);
				//ea4.setValue(DEFAULT_STRING_ATTR_VALUE);
				// ea4.setInstanceType(XMLTypePackage.Literals.STRING);
				unit2.getExtendedAttributes().add(ea4);
				unit2.eSet(ea4, DEFAULT_STRING_ATTR_VALUE);

				scope.openTopology().getUnits().add(unit);
				scope.openTopology().getUnits().add(unit2);

				contract.export(unit, ea1.getName());
				contract.export(unit, ea2.getName());
				// we don't export ea3
				contract.unexport(unit2);
				contract.export(unit2, ea4.getName());

				return Status.OK_STATUS;
			}

		}, new NullProgressMonitor());

		importedTopologyScope.saveChanges(true, null);

		{
			Unit unit1 = (Unit) importedTopology.resolve(UNIT1);
			Unit unit2 = (Unit) importedTopology.resolve(UNIT2);

			// ensure the unit is public as the default policy is public
			assertTrue(contract.isPublic(unit1));
			assertFalse(contract.isPublicEditable(unit1));

			assertFalse(contract.isPublic(unit2));
			assertFalse(contract.isPublicEditable(unit2));

			assertTrue(contract.isPublicEditable(unit1, STRING_ATTRIBUTE));
			assertTrue(contract.isPublicEditable(unit1, INTEGER_ATTRIBUTE));
			assertFalse(contract.isPublicEditable(unit1, BOOLEAN_ATTRIBUTE));

			assertTrue(contract.isPublicEditable(unit2, STRING_ATTRIBUTE));
		}

		{

			Topology referencingTopology = referencingTopologyScope.openTopology();
			Unit unit1 = (Unit) referencingTopology.resolve(NAMESPACE_FRAGMENT + IConstants.DOT_SEPARATOR + IMPORTED
					+ IConstants.TOPOLOGY_SEPARATOR + IConstants.PATH_SEPARATOR + UNIT1);
			Unit unit2 = (Unit) referencingTopology.resolve(NAMESPACE_FRAGMENT + IConstants.DOT_SEPARATOR + IMPORTED
					+ IConstants.TOPOLOGY_SEPARATOR + IConstants.PATH_SEPARATOR + UNIT2);

			assertTrue(unit1.isPublic());
			assertFalse(unit1.isPublicEditable());

			assertFalse(unit2.isPublic());
			assertFalse(unit2.isPublicEditable());

			assertTrue(unit1.isPublicEditable(STRING_ATTRIBUTE));
			assertTrue(unit1.isPublicEditable(INTEGER_ATTRIBUTE));
			assertFalse(unit1.isPublicEditable(BOOLEAN_ATTRIBUTE));

			assertTrue(unit2.isPublicEditable(STRING_ATTRIBUTE));

			final ExtendedAttribute unit1StringAttr = unit1.getExtendedAttribute(STRING_ATTRIBUTE);
			final ExtendedAttribute unit1IntAttr = unit1.getExtendedAttribute(INTEGER_ATTRIBUTE);
			final ExtendedAttribute unit1BooleanAttr = unit1.getExtendedAttribute(BOOLEAN_ATTRIBUTE);
			
			final Unit resolvedUnit1 = unit1;
			final Unit resolvedUnit2 = unit2;

			assertEquals(DEFAULT_STRING_ATTR_VALUE, resolvedUnit1.eGet(unit1StringAttr));
			assertEquals(DEFAULT_INTEGER_ATTR_VALUE, resolvedUnit1.eGet(unit1IntAttr));
			assertEquals(DEFAULT_BOOLEAN_ATTR_VALUE, resolvedUnit1.eGet(unit1BooleanAttr));

			final ExtendedAttribute unit2StringAttr = unit2.getExtendedAttribute(STRING_ATTRIBUTE);
			assertEquals(DEFAULT_STRING_ATTR_VALUE, resolvedUnit2.eGet(unit2StringAttr));

			referencingTopologyScope.execute(new ModelChange("Override values") {

				@Override
				public IStatus execute(IProgressMonitor monitor, ChangeScope scope) {

					//unit1StringAttr.setValue("Overridden value");
					resolvedUnit1.eSet(unit1StringAttr, "Overridden value");
					assertEquals("Overridden value", resolvedUnit1.eGet(unit1StringAttr));

					resolvedUnit1.eSet(unit1IntAttr, new Integer(-7));
					assertEquals(new Integer(-7), resolvedUnit1.eGet(unit1IntAttr));

					resolvedUnit2.eSet(unit2StringAttr, "Overridden Second value");
					assertEquals("Overridden Second value", resolvedUnit2.eGet(unit2StringAttr));

					return Status.OK_STATUS;
				}

			}, null);

			referencingTopologyScope.saveChanges(true, null);
		}

		// verify original topology left in tact
		{
			Unit unit1 = (Unit) importedTopology.resolve(UNIT1);
			Unit unit2 = (Unit) importedTopology.resolve(UNIT2);

			// ensure the unit is public as the default policy is public
			assertTrue(contract.isPublic(unit1));
			assertFalse(contract.isPublicEditable(unit1));

			assertFalse(contract.isPublic(unit2));
			assertFalse(contract.isPublicEditable(unit2));

			assertTrue(contract.isPublicEditable(unit1, STRING_ATTRIBUTE));
			assertTrue(contract.isPublicEditable(unit1, INTEGER_ATTRIBUTE));
			assertFalse(contract.isPublicEditable(unit1, BOOLEAN_ATTRIBUTE));

			assertTrue(contract.isPublicEditable(unit2, STRING_ATTRIBUTE));
		}

	}

	public void testExportUnitAttributeAsPublicEditable_WithPrivatePrivatePolicy() throws Exception {
		setupContract(Visibility.PRIVATE_LITERAL, Visibility.PRIVATE_LITERAL);
		setupImport();

		Topology importedTopology = importedTopologyScope.openTopology();
		final ConfigurationContract contract = importedTopology.getConfigurationContract();

		importedTopologyScope.execute(new ModelChange("Export Unit") {

			public IStatus execute(IProgressMonitor monitor, ChangeScope scope) throws ExecutionException {

				Unit unit = FACTORY.createUnit();
				unit.setName(UNIT1);
				scope.openTopology().getUnits().add(unit);

				Capability capability = TestSetup.createCapability(unit, CAPABILITY1);
				unit.getCapabilities().add(capability);

				contract.export(unit, ATTR_ORIGIN);
				contract.export(capability, ATTR_LINKTYPE);

				return Status.OK_STATUS;
			}

		}, new NullProgressMonitor());

		Unit unit = (Unit) importedTopology.resolve(UNIT1);

		Capability capabiliy = (Capability) unit.resolve(CAPABILITY1);

		assertTrue(contract.isVisible(unit));
		assertFalse(contract.isPublic(unit));
		assertFalse(contract.isPublicEditable(unit));

		assertTrue(contract.isVisible(capabiliy));
		assertFalse(contract.isPublic(capabiliy));
		assertFalse(contract.isPublicEditable(capabiliy));

	}

	public void testExportUnitCapabilityAsPublicEditable_WithPublicPublicPolicy() throws Exception {
		setupContract(Visibility.PUBLIC_LITERAL, Visibility.PUBLIC_LITERAL);
		setupImport();

		Topology importedTopology = importedTopologyScope.openTopology();
		final ConfigurationContract contract = importedTopology.getConfigurationContract();

		importedTopologyScope.execute(new ModelChange("Export Unit") {

			public IStatus execute(IProgressMonitor monitor, ChangeScope scope) throws ExecutionException {

				final Unit unit = FACTORY.createUnit();
				unit.setName(UNIT1);

				final Capability capability = TestSetup.createCapability(unit, "CC1");

				scope.openTopology().getUnits().add(unit);
				contract.export(capability, true);

				return Status.OK_STATUS;
			}

		}, new NullProgressMonitor());

		final Unit unit = (Unit) importedTopology.resolve(UNIT1);
		final Capability capability = (Capability) unit.resolve("CC1");

		assertTrue(contract.isPublicEditable(capability));

		// ensure the unit is public as the default policy is public
		assertTrue(contract.isPublic(unit));
		assertFalse(contract.isPublicEditable(unit));

	}

	public void testExportUnitCapabilityAsPublicEditable_WithPublicEditablePublicPolicy() throws Exception {
		setupContract(Visibility.PUBLIC_EDITABLE_LITERAL, Visibility.PUBLIC_LITERAL);
		setupImport();

		Topology importedTopology = importedTopologyScope.openTopology();
		final ConfigurationContract contract = importedTopology.getConfigurationContract();

		final Unit unit = FACTORY.createUnit();
		unit.setName(UNIT1);

		final Capability capability = TestSetup.createCapability(unit, "CC1");

		importedTopologyScope.execute(new ModelChange("Export Unit") {

			public IStatus execute(IProgressMonitor monitor, ChangeScope scope) throws ExecutionException {
				// when the policy is public editable, exporting an attribute
				// will hide it
				contract.export(capability, false);

				return Status.OK_STATUS;
			}

		}, new NullProgressMonitor());

		assertFalse(contract.isPublicEditable(capability));
		assertTrue(contract.isPublic(capability));

		// ensure the unit is public as the default policy is public
		assertTrue(contract.isPublic(unit));
		assertTrue(contract.isPublicEditable(unit));

	}

	public void testPrivatePrivateAttributeNesting() throws Exception {
		setupContract();
		setupImport();

		Topology importedTopology = importedTopologyScope.openTopology();
		final ConfigurationContract contract = importedTopology.getConfigurationContract();

		final Unit privateUnit = FACTORY.createUnit();
		privateUnit.setName(UNIT1);

		importedTopologyScope.execute(new ModelChange("Add unit") {

			@Override
			public IStatus execute(IProgressMonitor monitor, ChangeScope scope) throws ExecutionException {
				scope.openTopology().getUnits().add(privateUnit);

				TestSetup.createCapability(privateUnit, CAPABILITY1);
				return Status.OK_STATUS;
			}

		}, null);

		assertEquals(1, privateUnit.getCapabilities().size());

		final Capability privateCapability = (Capability) privateUnit.resolve(CAPABILITY1);

		assertTrue(!contract.isPublic(privateUnit));

		assertTrue(!contract.isPublic(privateCapability));

		importedTopologyScope.execute(new ModelChange("Add unit") {

			@Override
			public IStatus execute(IProgressMonitor monitor, ChangeScope scope) throws ExecutionException {

				contract.export(privateCapability, CorePackage.eINSTANCE.getCapability_Origin());

				return Status.OK_STATUS;
			}

		}, null);

		assertFalse(contract.isPublic(privateUnit));

		importedTopologyScope.saveChanges(true, null);

		Topology referencingTopology = referencingTopologyScope.openTopology();

		final Unit importedPrivateUnit = (Unit) referencingTopology.resolve(NAMESPACE_FRAGMENT
				+ IConstants.DOT_SEPARATOR + IMPORTED + IConstants.TOPOLOGY_SEPARATOR + IConstants.PATH_SEPARATOR
				+ UNIT1);

		assertFalse(importedPrivateUnit.isPublic());

	}

	public void deprecatedtestTimings() throws Exception {

		setupContract();
		setupImport();

		final Class[] NO_PARAMS = new Class[0];
		final Object[] NO_ARGS = new Object[0];

		Topology referencingTopology = referencingTopologyScope.openTopology();
		final Unit publicEditableUnit = (Unit) referencingTopology.resolve(NAMESPACE_FRAGMENT
				+ IConstants.DOT_SEPARATOR + IMPORTED + IConstants.TOPOLOGY_SEPARATOR + IConstants.PATH_SEPARATOR
				+ EXPLICIT_PUBLIC_EDITABLE_UNIT);

		final Unit publicUnit = (Unit) referencingTopology.resolve(NAMESPACE_FRAGMENT + IConstants.DOT_SEPARATOR
				+ IMPORTED + IConstants.TOPOLOGY_SEPARATOR + IConstants.PATH_SEPARATOR + EXPLICIT_PUBLIC_UNIT);

		testTimings(Unit.class.getMethod("getCapabilities", NO_PARAMS), publicEditableUnit, NO_ARGS);
		testTimings(Unit.class.getMethod("getRequirements", NO_PARAMS), publicEditableUnit, NO_ARGS);
		testTimings(Unit.class.getMethod("getHostingLinks", NO_PARAMS), publicEditableUnit, NO_ARGS);

		testTimings(Unit.class.getMethod("getCapabilities", NO_PARAMS), publicUnit, NO_ARGS);
		testTimings(Unit.class.getMethod("getRequirements", NO_PARAMS), publicUnit, NO_ARGS);
		testTimings(Unit.class.getMethod("getHostingLinks", NO_PARAMS), publicUnit, NO_ARGS);

	}

	public void testTimings(Method method, Object instance, Object[] arguments) throws Exception {

		final int SPINS = 100000;

		long start = System.nanoTime();

		for (int i = 0; i < SPINS; i++)
			method.invoke(instance, arguments);

		long end = System.nanoTime();

		long len = end - start;
		NumberFormat nf = NumberFormat.getInstance();

		nf.setMaximumFractionDigits(6);

		System.out.println(method.getName() + "\t" + nf.format(len) + " ns" + "\t" + nf.format((len / SPINS))
				+ " ns per call ");
	}
	
	/**
	 * Tests the behavior of a set operation on a non-editable attribute.
	 * 
	 * @throws Exception
	 */
	public void testSetBehavior() throws Exception {
		String descr1 = "host";
		String descr2 = "badhost";

		//
		// Create a topology top1 with a public unit
		//
		Topology top1 = createTopology("testSetBehavior-Import");
		Unit unit = addUnit(top1, "unit");
		unit.setDescription(descr1);

		ExplicitContract explicitContract = CoreFactory.eINSTANCE
				.createExplicitContract();
		top1.setConfigurationContract(explicitContract);
		explicitContract.getVisibleUnits().add(unit);
		save(top1);

		//
		// Create topology top2 importing top1
		//
		Topology top2 = createTopology("testSetBehavior-Edit");
		Import top1Import = TopologyUtil.importTopology(top1, top2);
		Topology importTop1 = TopologyUtil.resolve(top1Import);
		assertNotNull(importTop1);

		ConfigurationContract importContract = importTop1
				.getConfigurationContract();
		Unit importUnit = (Unit) importTop1.resolve(getGlobalPath(unit));
		assertNotNull(importUnit);
		assertNotSame(unit, importUnit);

		// Verify that the description of the unit is not editable
		assertFalse(importContract.isPublicEditable(importUnit,
				CorePackage.eINSTANCE.getDeployModelObject_Description()
						.getName()));

		// Try to change the description
		try {
			importUnit.setDescription(descr2);
			
			
			// Error: no exception thrown 
			// MDE We cannot throw an error -- must resort to the log
//			assertTrue(false);
		} catch (RuntimeException e) {
			// OK: verify that the description remains unaltered
			assertEquals(descr1, importUnit.getDescription());
		}
	}
	

	public void testReExportPublic() throws Exception {
		setupContract();
		setupImport();

		Topology importedTopology =  importedTopologyScope.openTopology();
		final ConfigurationContract importedContract = importedTopology.getConfigurationContract();
		assertNotNull(importedContract);
		
		Topology referencingTopology =  referencingTopologyScope.openTopology();
		final ConfigurationContract referencingContract = referencingTopology.getConfigurationContract();	
		assertNotNull(referencingContract);	

		Topology nestedTopology =  nestedImportingTopologyScope.openTopology(); 
		 
		String importedPublicUnitPath = NAMESPACE_FRAGMENT + IConstants.DOT_SEPARATOR + IMPORTED + IConstants.TOPOLOGY_SEPARATOR + IConstants.PATH_SEPARATOR
		+ EXPLICIT_PUBLIC_UNIT;
		
		String importedPublicEditableUnitPath = NAMESPACE_FRAGMENT + IConstants.DOT_SEPARATOR + IMPORTED + IConstants.TOPOLOGY_SEPARATOR + IConstants.PATH_SEPARATOR
		+ EXPLICIT_PUBLIC_EDITABLE_UNIT;

		final Unit importedPublicUnit = (Unit) referencingTopology.resolve(importedPublicUnitPath);
		final Import importedImport =  referencingTopology.getImport(NAMESPACE_FRAGMENT, IMPORTED);
		
		referencingTopologyScope.execute(new ModelChange("Export Unit") {

			@Override
			public IStatus execute(IProgressMonitor monitor, ChangeScope scope) throws ExecutionException {

				referencingContract.export(importedImport, false);

				return Status.OK_STATUS;
			}

		}, ChangeScope.OPTION_FORCE_SAVE, null); 
		
		assertTrue(referencingContract.isPublic(importedImport));
		assertTrue(referencingContract.isPublic(importedPublicUnit));
		
		DeployModelObject resolvedPublic = referencingTopology.resolve(importedPublicUnitPath);
		assertNotNull(resolvedPublic);		

		assertTrue(resolvedPublic.isVisible()); 
		assertTrue(resolvedPublic.isPublic()); 
		assertFalse(resolvedPublic.isPublicEditable());
		
		final DeployModelObject resolvedPublicEditable = referencingTopology.resolve(importedPublicEditableUnitPath);
		assertNotNull(resolvedPublicEditable);		

		assertTrue(resolvedPublicEditable.isVisible()); 
		assertTrue(resolvedPublicEditable.isPublic()); 
		assertTrue(resolvedPublicEditable.isPublicEditable());

		Unit nestedPublicUnit = (Unit) nestedTopology.resolve(importedPublicUnitPath);
		
		assertNotNull(nestedPublicUnit); 		
		assertTrue(nestedPublicUnit.isVisible()); 
		assertTrue(nestedPublicUnit.isPublic()); 
		assertFalse(nestedPublicUnit.isPublicEditable()); 
		
		final Unit nestedPublicEditableUnit = (Unit) nestedTopology.resolve(importedPublicEditableUnitPath);
		
		assertNotNull(nestedPublicEditableUnit); 		
		assertTrue(nestedPublicEditableUnit.isVisible()); 
		assertTrue(nestedPublicEditableUnit.isPublic()); 
		assertTrue(nestedPublicEditableUnit.isPublicEditable()); 
		
		Import nestingImport = nestedTopology.getImport(NAMESPACE_FRAGMENT + IConstants.DOT_SEPARATOR + EDITED);
		List<Unit> visibleUnits = nestingImport.getInstanceConfiguration().getVisibleUnits();
		
		boolean[] found = new boolean[] { false, false };
		for (Iterator<Unit> iterator = visibleUnits.iterator(); iterator.hasNext() && !(found[0] && found[1]);) {
			Unit unit = iterator.next();
			if(unit.getFullPath().equals(nestedPublicUnit.getFullPath()) ) {
				found[0] = true;
			} 
			if(unit.getFullPath().equals(nestedPublicEditableUnit.getFullPath()) ) {
				found[1] = true;
			} 
		}
		assertTrue(found[0] && found[1]); 
		

		referencingTopologyScope.execute(new ModelChange("Export Unit") {

			@Override
			public IStatus execute(IProgressMonitor monitor, ChangeScope scope) throws ExecutionException {

				resolvedPublicEditable.setDescription(EDITED_DESCRIPTION_VALUE);

				return Status.OK_STATUS;
			}

		}, ChangeScope.OPTION_FORCE_SAVE, null);
		
		assertEquals(EDITED_DESCRIPTION_VALUE, resolvedPublicEditable.getDescription());
		assertEquals(EDITED_DESCRIPTION_VALUE, nestedPublicEditableUnit.getDescription());

		nestedImportingTopologyScope.execute(new ModelChange("Export Unit") {

			@Override
			public IStatus execute(IProgressMonitor monitor, ChangeScope scope) throws ExecutionException {

				nestedPublicEditableUnit.setDescription(NESTED_DESCRIPTION_VALUE);

				return Status.OK_STATUS;
			}

		}, ChangeScope.OPTION_FORCE_SAVE, null);
		
		assertEquals(EDITED_DESCRIPTION_VALUE, resolvedPublicEditable.getDescription());
		assertEquals(NESTED_DESCRIPTION_VALUE, nestedPublicEditableUnit.getDescription());
		
		referencingTopologyScope.execute(new ModelChange("Export Unit") {

			@Override
			public IStatus execute(IProgressMonitor monitor, ChangeScope scope) throws ExecutionException {

				referencingContract.unexport(importedImport);

				return Status.OK_STATUS;
			}

		}, ChangeScope.OPTION_FORCE_SAVE, null);

		assertFalse(nestedPublicUnit.isVisible()); 
		assertFalse(nestedPublicUnit.isPublic()); 
		assertFalse(nestedPublicUnit.isPublicEditable()); 
		
		assertFalse(nestedPublicEditableUnit.isVisible()); 
		assertFalse(nestedPublicEditableUnit.isPublic()); 
		assertFalse(nestedPublicEditableUnit.isPublicEditable()); 
		 

	}

}
