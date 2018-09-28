/*******************************************************************************
 * Copyright (c) 2003, 2007 IBM Corporation Licensed Material - Property of IBM. All rights reserved.
 *  
 * US Government Users Restricted Rights - Use, duplication or disclosure v1.0 restricted by GSA ADP
 * Schedule Contract with IBM Corp.
 * 
 * Contributors: IBM Corporation - initial API and implementation
 *******************************************************************************/
package com.ibm.ccl.soa.deploy.core.test.synchronization;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

import junit.framework.TestCase;

import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.ltk.core.refactoring.CreateChangeOperation;
import org.eclipse.ltk.core.refactoring.PerformChangeOperation;
import org.eclipse.ltk.core.refactoring.RefactoringStatus;

import com.ibm.ccl.soa.deploy.core.CapabilityProvider;
import com.ibm.ccl.soa.deploy.core.ChangeScope;
import com.ibm.ccl.soa.deploy.core.Topology;
import com.ibm.ccl.soa.deploy.core.TopologyUnitStub;
import com.ibm.ccl.soa.deploy.core.Unit;
import com.ibm.ccl.soa.deploy.core.UnitProvider;
import com.ibm.ccl.soa.deploy.core.datamodels.SynchronizationDatamodel;
import com.ibm.ccl.soa.deploy.core.extension.ExtensionsCore;
import com.ibm.ccl.soa.deploy.core.extension.ICapabilityProviderService;
import com.ibm.ccl.soa.deploy.core.extension.IUnitProviderService;
import com.ibm.ccl.soa.deploy.core.impl.UnitImpl;
import com.ibm.ccl.soa.deploy.core.internal.synchronization.ImportRefactoringProcessor;
import com.ibm.ccl.soa.deploy.core.internal.synchronization.SynchronizationRefactoring;
import com.ibm.ccl.soa.deploy.core.test.ModelChange;
import com.ibm.ccl.soa.deploy.core.test.SimpleChangeScope;
import com.ibm.ccl.soa.deploy.core.test.TestSetup;
import com.ibm.ccl.soa.deploy.internal.core.extension.SynchronizationParticipantManager;

public class SynchronizationTests extends TestCase {

	private static final String SYNCHRONIZE_TESTS_PROJECT = SynchronizationTests.class
			.getSimpleName();
	private static final String NAMESPACE_FRAGMENT = SynchronizationTests.class
			.getPackage().getName();
	private static final String TOPOLOGY1 = null;

	private TestSetup<SynchronizeTestsWorkspace> testSetup;
	private SimpleChangeScope synchronizeScope;
	private IUnitProviderService unitProviderService;

	public class TestUnit extends UnitImpl {
	}

	protected void setUp() throws Exception {

		unitProviderService = ExtensionsCore
				.createProviderService();

		testSetup = new TestSetup<SynchronizeTestsWorkspace>(
				SYNCHRONIZE_TESTS_PROJECT, NAMESPACE_FRAGMENT,
				new SynchronizeTestsWorkspace());

		synchronizeScope = testSetup.createTopologyScope(TOPOLOGY1,
				ChangeScope.OPTION_FORCE_SAVE, new ModelChange(
						"Create Base Topology") {

					@Override
					public IStatus execute(IProgressMonitor monitor,
							ChangeScope scope) throws ExecutionException {

						return Status.OK_STATUS;
					}

				});
	}

	protected void tearDown() throws Exception {
		testSetup.dispose();
		unitProviderService = null;
	}

	public void testReadParticipantRegistry() {
		// verify the test participant can be located
		TestUnit tUnit = new TestUnit();
		SynchronizationParticipantManager manager = SynchronizationParticipantManager
				.getInstance();
		Set descriptors = manager
				.findDescriptorsEnabledFor(new Unit[] { tUnit });
		assertEquals(1, descriptors.size());
	}

	public void testReadProviderRegistrations() {
		// verify that all of the Unit/Capability providers can be located
		TestUnit tUnit = new TestUnit();
		ICapabilityProviderService capabilityProviderService = ExtensionsCore
				.createCapabilityProviderService();
		CapabilityProvider[] providers = capabilityProviderService
				.findEnabledCapabilityProvidersByOutputOnly(tUnit);
		assertEquals(1, providers.length);
	}

	public void testImportRefactoringForJ2EE() throws Exception {

		Object synchronizeTarget = testSetup.getWorkspace().getMinibankEAR();

		String decoratorSemantic = synchronizeScope.openTopology()
				.getDecoratorSemantic();
		UnitProvider[] unitProviders = unitProviderService
				.findEnabledProvidersByInputOnly(synchronizeTarget,
						decoratorSemantic);

		Set<TopologyUnitStub> cache = new HashSet<TopologyUnitStub>();
		for (int i = 0; i < unitProviders.length; ++i) {
			TopologyUnitStub[] topologyUnitStubs = unitProviders[i]
					.resolveStubs(synchronizeTarget);

			if (topologyUnitStubs != null) {
				for (int y = 0; y < topologyUnitStubs.length; ++y) {
					topologyUnitStubs[y].setTopology(synchronizeScope
							.openTopology());
					topologyUnitStubs[y].setSource(unitProviders[i]);
				}
				cache.addAll(Arrays.asList(topologyUnitStubs));
			}
		}

		SynchronizationDatamodel datamodel = SynchronizationDatamodel
				.createModel();
		datamodel.setStubs(cache.toArray(new TopologyUnitStub[cache.size()]));
		datamodel.setTopology(synchronizeScope.openTopology());
		SynchronizationRefactoring refactor = new SynchronizationRefactoring(
				new ImportRefactoringProcessor(datamodel));

		RefactoringStatus checkInitialConditions = refactor
				.checkInitialConditions(null);
		assertTrue(checkInitialConditions.isOK());

		RefactoringStatus checkFinalConditions = refactor
				.checkFinalConditions(null);

		assertTrue(checkFinalConditions.isOK());
		final PerformChangeOperation makeChanges = new PerformChangeOperation(
				new CreateChangeOperation(refactor));

		synchronizeScope.execute(new ModelChange("Execute Changes en masse") {

			@Override
			public IStatus execute(IProgressMonitor monitor, ChangeScope scope)
					throws ExecutionException {
				try {
					makeChanges.run(null);
				} catch (CoreException e) {
					throw new ExecutionException(e.getMessage(), e);
				}
				return Status.OK_STATUS;
			}

		}, null);

		Topology topology = synchronizeScope.openTopology();

		// just ensure the units are added to the topology.
		// There should be three units from the IDE J2EE provider
		assertEquals(3, topology.getUnits().size());

	}

}
