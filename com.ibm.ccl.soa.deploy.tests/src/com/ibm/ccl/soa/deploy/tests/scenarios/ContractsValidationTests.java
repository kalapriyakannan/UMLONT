/*******************************************************************************
 * Copyright (c) 2003, 2007 IBM Corporation Licensed Material - Property of IBM. All rights reserved.
 *  
 * US Government Users Restricted Rights - Use, duplication or disclosure v1.0 restricted by GSA ADP
 * Schedule Contract with IBM Corp.
 * 
 * Contributors: IBM Corporation - initial API and implementation
 *******************************************************************************/
package com.ibm.ccl.soa.deploy.tests.scenarios;

import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.eclipse.core.runtime.IStatus;

import com.ibm.ccl.soa.deploy.core.ConfigurationContract;
import com.ibm.ccl.soa.deploy.core.ContractProvider;
import com.ibm.ccl.soa.deploy.core.CoreFactory;
import com.ibm.ccl.soa.deploy.core.DeployModelObject;
import com.ibm.ccl.soa.deploy.core.ExplicitContract;
import com.ibm.ccl.soa.deploy.core.IConstants;
import com.ibm.ccl.soa.deploy.core.Import;
import com.ibm.ccl.soa.deploy.core.InstanceConfiguration;
import com.ibm.ccl.soa.deploy.core.Instantiation;
import com.ibm.ccl.soa.deploy.core.Topology;
import com.ibm.ccl.soa.deploy.core.Unit;
import com.ibm.ccl.soa.deploy.core.Visibility;
import com.ibm.ccl.soa.deploy.core.test.TopologyTestCase;
import com.ibm.ccl.soa.deploy.core.test.validator.utils.ValidatorTestUtils;
import com.ibm.ccl.soa.deploy.core.util.TopologyUtil;
import com.ibm.ccl.soa.deploy.core.validator.DeployValidatorService;
import com.ibm.ccl.soa.deploy.core.validator.ValidatorUtils;
import com.ibm.ccl.soa.deploy.core.validator.resolution.ResolutionUtils;
import com.ibm.ccl.soa.deploy.core.validator.status.IDeployCoreValidators;
import com.ibm.ccl.soa.deploy.internal.core.extension.ContractProviderManager;
import com.ibm.ccl.soa.deploy.internal.core.topologyimport.IdentityContractProvider;
import com.ibm.ccl.soa.deploy.was.IWasTemplateConstants;
import com.ibm.ccl.soa.deploy.was.WasNode;
import com.ibm.ccl.soa.deploy.was.WasNodeUnit;
import com.ibm.ccl.soa.deploy.was.WasPackage;
import com.ibm.ccl.soa.deploy.was.WasServer;
import com.ibm.ccl.soa.deploy.was.WasSystem;
import com.ibm.ccl.soa.deploy.was.WebsphereAppServerUnit;
import com.ibm.ccl.soa.deploy.was.validator.IWasValidatorID;

/**
 * JUnit test case for contracts validation severity overrides
 * 
 * <p>
 * 
 * @author Bill Arnold
 */
public class ContractsValidationTests extends TopologyTestCase {

	// Use instance variables for now
	/** Topology used for the middleware units. */
	private Import importTopInfra;

	private Topology editTopInfra;

	boolean verbose = true;

	private Unit wasSystemUnit;

	private WebsphereAppServerUnit websphereAppServerUnit;

	private WasServer wasServer;

	private Topology infraTop;

	private Unit ru1FromTemplate;

	private WasNodeUnit wasNodeUnit;

	private WasSystem wasSystem;

	private WasNode wasNode;

	ConfigurationContract identityContractTop;

	ConfigurationContract identityContractInfra;

	/** Test case ctor */
	public ContractsValidationTests() {
		super("ContractsValidationTests");
		this.setDeleteProjectOnTearDown(false);
	}

	/**
	 * @throws Exception
	 *             Note 2007/04/04 main test case won't run without this dummy
	 *             test run first.
	 */
	public void testDummy() throws Exception {
		createTopology("dummy");
	}

	/**
	 * Test creating, saving, and validating in one topology.
	 * 
	 * @throws Exception
	 */
	public void testContractsValidationFromTemplate() throws Exception {

		ContractProvider provider = ContractProviderManager.getInstance().createProvider(IdentityContractProvider.ID);

		Topology top = createTopology("testContractsValidationFromTemplate");
		provider.installContract(top);
		identityContractTop = top.getConfigurationContract();

		String infraTID1 = IWasTemplateConstants.WAS_6_STANDALONE_BUNDLE;

		editTopInfra = createTopology("Infra", true);
		importTopInfra = TopologyUtil.importTopology(editTopInfra, top);
		infraTop = TopologyUtil.resolve(importTopInfra);

		ru1FromTemplate = (Unit) ResolutionUtils.addFromTemplate(infraTID1, editTopInfra);
		save(editTopInfra);
		assert (editTopInfra.getUnits().size() > 1);

		Iterator i = ValidatorUtils.findAllInstances(editTopInfra, WasPackage.eINSTANCE.getWasSystemUnit());
		if (i.hasNext()) {
			wasSystemUnit = (Unit) i.next();
		}
		assert (wasSystemUnit != null);

		i = ValidatorUtils.findAllInstances(editTopInfra, WasPackage.eINSTANCE.getWasNodeUnit());
		if (i.hasNext()) {
			wasNodeUnit = (WasNodeUnit) i.next();
		}
		assert (wasNodeUnit != null);
		wasNode = (WasNode) ValidatorUtils.getFirstCapability(wasNodeUnit, WasPackage.eINSTANCE.getWasNode());
		assert (wasNode != null);

		i = ValidatorUtils.findAllInstances(editTopInfra, WasPackage.eINSTANCE.getWebsphereAppServerUnit());
		if (i.hasNext()) {
			websphereAppServerUnit = (WebsphereAppServerUnit) i.next();
		}
		wasServer = (WasServer) ValidatorUtils.getFirstCapability(websphereAppServerUnit, WasPackage.eINSTANCE
				.getWasServer());
		assert (wasServer != null);

		wasSystem = (WasSystem) ValidatorUtils.getCapability(wasSystemUnit, WasPackage.eINSTANCE.getWasSystem());
		assert (wasSystem != null);

		// Force attribute not set errors
		wasServer.setServerName(null);
		wasNode.setProfileName(null);
		wasSystem.setWasHome(null);

		provider.installContract(editTopInfra);
		identityContractInfra = editTopInfra.getConfigurationContract();
		save(editTopInfra);
		save(top);

		// dumpTopology(top);

		// Raw error validator ids are:
		// IWasValidatorID.WAS_NODE_UNIT_PROFILE_NAME_EMPTY_001;
		// IWasValidatorID.WAS_APP_SERVER_SERVER_NAME_EMPTY_001;
		// IDeployCoreValidators.HOSTING_001;
		// IWasValidatorID.WAS_SYSTEM_WAS_HOME_EMPTY_001;

		{
			// ------------------------------------------------------
			// First test with identity contract
			HashSet<String> expectedErrorValidatorIDs = new HashSet<String>();
			expectedErrorValidatorIDs.add(IWasValidatorID.WAS_NODE_UNIT_PROFILE_NAME_EMPTY_001);
			expectedErrorValidatorIDs.add(IWasValidatorID.WAS_APP_SERVER_SERVER_NAME_EMPTY_001);
			expectedErrorValidatorIDs.add(IWasValidatorID.WAS_SYSTEM_WAS_HOME_EMPTY_001);

			HashSet<String> expectedWarningValidatorIDs = new HashSet<String>();
			expectedWarningValidatorIDs.add(IDeployCoreValidators.HOSTING_001);

			// "editTopInfra" has identity contract. Hosting link errors should
			// be warnings
			validationTests(editTopInfra, expectedErrorValidatorIDs, expectedWarningValidatorIDs);

			// "top" has identity contract. All severities should remain the
			// same
			validationTests(top, expectedErrorValidatorIDs, expectedWarningValidatorIDs);
		}

		{
			// ------------------------------------------------------
			// Test with explicit contract on infra, null contract on topology
			// importing infra
			// Contract summary:
			// wasSystemUnit: unit, linkable true, configurable false
			// wasServerUnit: unit, linkable true, configurable true
			// wasNode: capability, linkable true, configurable true
			// 
			addExplicitContractDefaultPublicPlusExports(editTopInfra);
			save(editTopInfra);
			ExplicitContract ec = CoreFactory.eINSTANCE.createExplicitContract();
			ec.setName("ec");
			ec.setDefaultConceptualPolicy(Visibility.PRIVATE_LITERAL);
			ec.setDefaultPolicy(Visibility.PRIVATE_LITERAL);
			top.setConfigurationContract(ec);
			save(top);

			HashSet<String> expectedErrorValidatorIDs = new HashSet<String>();
			expectedErrorValidatorIDs.add(IWasValidatorID.WAS_SYSTEM_WAS_HOME_EMPTY_001);

			HashSet<String> expectedWarningValidatorIDs = new HashSet<String>();
			expectedWarningValidatorIDs.add(IWasValidatorID.WAS_APP_SERVER_SERVER_NAME_EMPTY_001);
			expectedWarningValidatorIDs.add(IWasValidatorID.WAS_NODE_UNIT_PROFILE_NAME_EMPTY_001);
			expectedWarningValidatorIDs.add(IDeployCoreValidators.HOSTING_001);

			// "editTopInfra" has identity contract. Hosting link errors should
			// be warnings
			validationTests(editTopInfra, expectedErrorValidatorIDs, expectedWarningValidatorIDs);

			expectedWarningValidatorIDs.clear();
			expectedErrorValidatorIDs.add(IWasValidatorID.WAS_APP_SERVER_SERVER_NAME_EMPTY_001);
			expectedErrorValidatorIDs.add(IWasValidatorID.WAS_NODE_UNIT_PROFILE_NAME_EMPTY_001);
			expectedErrorValidatorIDs.add(IDeployCoreValidators.HOSTING_001);

			// "top" has null contract. No severities should be overridden.
			validationTests(top, expectedErrorValidatorIDs, expectedWarningValidatorIDs);
		}
		{
			// ------------------------------------------------------
			// Test with explicit contract on infra, empty explicit contract on
			// topology importing infra
			// Contract summary:
			// wasSystemUnit: unit, linkable true, configurable false
			// wasServerUnit: unit, linkable true, configurable true
			// wasNode: capability, linkable true, configurable true
			// 
			addExplicitContractDefaultPublicPlusExports(editTopInfra);
			save(editTopInfra);
			ExplicitContract explicitContract = CoreFactory.eINSTANCE.createExplicitContract();
			explicitContract.setName("explicitContract");
			top.setConfigurationContract(explicitContract);
			save(top);

			HashSet<String> expectedErrorValidatorIDs = new HashSet<String>();
			expectedErrorValidatorIDs.add(IWasValidatorID.WAS_SYSTEM_WAS_HOME_EMPTY_001);

			HashSet<String> expectedWarningValidatorIDs = new HashSet<String>();
			expectedWarningValidatorIDs.add(IWasValidatorID.WAS_APP_SERVER_SERVER_NAME_EMPTY_001);
			expectedWarningValidatorIDs.add(IDeployCoreValidators.HOSTING_001);
			expectedWarningValidatorIDs.add(IWasValidatorID.WAS_NODE_UNIT_PROFILE_NAME_EMPTY_001);

			// "editTopInfra" has identity contract. Hosting link errors should
			// be warnings
			validationTests(editTopInfra, expectedErrorValidatorIDs, expectedWarningValidatorIDs);

			expectedWarningValidatorIDs.clear();
			expectedErrorValidatorIDs.add(IWasValidatorID.WAS_APP_SERVER_SERVER_NAME_EMPTY_001);
			expectedErrorValidatorIDs.add(IWasValidatorID.WAS_NODE_UNIT_PROFILE_NAME_EMPTY_001);
			expectedErrorValidatorIDs.add(IDeployCoreValidators.HOSTING_001);

			// "top" has null contract. No severities should be overridden.
			validationTests(top, expectedErrorValidatorIDs, expectedWarningValidatorIDs);
		}

		// Instance configuration on import
		{
			addExplicitContractDefaultPublicPlusExports(editTopInfra);
			save(editTopInfra);
			ExplicitContract explicitContract = CoreFactory.eINSTANCE.createExplicitContract();
			explicitContract.setName("explicitContract");
			top.setConfigurationContract(explicitContract);
			save(top);

			int savedVisibleUnitsInfraSize = -1;
			{
				InstanceConfiguration icImportTopInfra = importTopInfra.getInstanceConfiguration();
				List<Unit> visibleUnitsInfra = icImportTopInfra.getVisibleUnits();
				List<Unit> infraUnits = editTopInfra.getConfigurationContract().getVisibleUnits();

				assert infraUnits.size() == visibleUnitsInfra.size();
				assert infraUnits.size() > 0;
				savedVisibleUnitsInfraSize = visibleUnitsInfra.size();
				assert (icImportTopInfra.isPublic(websphereAppServerUnit));
				assert (icImportTopInfra.isPublicEditable(websphereAppServerUnit));
				Instantiation instantiation = icImportTopInfra.getInstantiation(websphereAppServerUnit.getName());
				assert (instantiation == null);
				String path = "." + importTopInfra.getPattern() + ":/" + websphereAppServerUnit.getName();
				DeployModelObject resolvedDMO = editTopInfra.resolve(path);
				assert (resolvedDMO != null);
				String namespace = importTopInfra.getNamespace();
				if (namespace != null) {
					path = namespace + path;
				}
				// What is this for?
				DeployModelObject resolvedDMO2 = importTopInfra.resolve(namespace + "/" +
						websphereAppServerUnit.getName());

				DeployModelObject editTopReferencedDMO = top.getEditTopology().resolve(path);

				assert (editTopReferencedDMO != null);
				List<Unit> units = infraTop.getUnits();
				for (Iterator<Unit> unitsIter = units.iterator(); unitsIter.hasNext();) {
					Unit u = unitsIter.next();
					System.out.println(u.getFullPath());
				}
			}

			assert (editTopInfra.getUnits().remove(websphereAppServerUnit));
			save(editTopInfra);

			{
				InstanceConfiguration icImportTopInfra = importTopInfra.getInstanceConfiguration();
				List<Unit> visibleUnitsInfra = icImportTopInfra.getVisibleUnits();
				List<Unit> infraUnits = editTopInfra.getConfigurationContract().getVisibleUnits();

				assert infraUnits.size() == visibleUnitsInfra.size();
				assert infraUnits.size() > 0;
				assert (savedVisibleUnitsInfraSize > visibleUnitsInfra.size());

				assert (icImportTopInfra.isPublic(websphereAppServerUnit));

				Instantiation instantiation = icImportTopInfra.getInstantiation(websphereAppServerUnit.getName());
				assert (instantiation == null);
				String namespace = importTopInfra.getNamespace();
				String path = importTopInfra.getPattern() + ":/" + websphereAppServerUnit.getName();
				if (namespace != null) {
					path = namespace + IConstants.DOT_SEPARATOR + path;
				}

				assert path.length() > 0;
				DeployModelObject dmo = importTopInfra.resolve(path);
				// has been removed
				assert (dmo == null);
			}
		}
	}

	private void addExplicitContractDefaultPublicPlusExports(Topology top) {

		ExplicitContract explicitContract = addExplicitContractDefaultPublic(top);

		// wasSystemUnit: unit, linkable true, configurable false
		// wasServerUnit: unit, linkable true, configurable true
		// wasNode: capability, linkable true, configurable true
		explicitContract.export(wasSystemUnit, false);
		explicitContract.export(websphereAppServerUnit, true);
		explicitContract.export(wasNode, true);
		{ // This should NOT be necessary - parent should inherit linkability
			// from child
			explicitContract.export(wasNodeUnit, false);
		}
		top.setConfigurationContract(explicitContract);

		assert (top.getConfigurationContract().isPublic(websphereAppServerUnit));
		assert (top.getConfigurationContract().isPublicEditable(websphereAppServerUnit));

		// WasSystemUnit should reflect unit contract
		assert (top.getConfigurationContract().isPublic(wasSystemUnit));
		assert (!top.getConfigurationContract().isPublicEditable(wasSystemUnit));

		// WasNodeUnit should inherit linkability from child capability
		assert (top.getConfigurationContract().isPublic(wasNodeUnit));
		assert (!top.getConfigurationContract().isPublicEditable(wasNodeUnit));

		// WasServer should inherit linkability and configurability from parent
		// unit
		assert (top.getConfigurationContract().isPublic(wasServer));
		assert (top.getConfigurationContract().isPublicEditable(wasServer));

		// Inherit from parent
		assert (top.getConfigurationContract().isPublic(wasSystem));
		assert (!top.getConfigurationContract().isPublicEditable(wasSystem));
	}

	private void validationTests(Topology top, Set<String> expectedErrorValidatorIDs,
			Set<String> expectedWarningValidatorIDs) {

		DeployValidatorService deployValidatorService = new DeployValidatorService();

		deployValidatorService.validate(top);
		// String ed = ValidatorTestUtils.getTopologyErrorDescription(top);
		// System.out.println("Error description ----\n" + ed + "End error
		// description ----");
		// String wd = ValidatorTestUtils.getTopologyWarningDescription(top);
		// System.out.println("Warning description ----\n" + wd + "End warning
		// description ----");
		assert ValidatorTestUtils.topologyValidatorIDsInSet(top, expectedErrorValidatorIDs, IStatus.ERROR);
		assert ValidatorTestUtils.topologyValidatorIDSetCover(top, expectedErrorValidatorIDs, IStatus.ERROR);
		assert ValidatorTestUtils.topologyValidatorIDsInSet(top, expectedWarningValidatorIDs, IStatus.WARNING);
		assert ValidatorTestUtils.topologyValidatorIDSetCover(top, expectedWarningValidatorIDs, IStatus.WARNING);
	}

	private void dumpTopology(Topology top) {
		System.out.println("Topology " + top.getName());
		for (Iterator unitIter = top.findAllUnits(); unitIter.hasNext();) {
			Unit u = (Unit) unitIter.next();
			System.out.println("(conceptual=" + u.isConceptual() + ") " + u.getCaptionProvider().titleWithContext(u));
		}
	}
}
