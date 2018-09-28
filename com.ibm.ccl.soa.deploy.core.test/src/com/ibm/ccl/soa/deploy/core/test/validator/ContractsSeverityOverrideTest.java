/*******************************************************************************
 * Copyright (c) 2003, 2007 IBM Corporation Licensed Material - Property of IBM. All rights reserved.
 *  
 * US Government Users Restricted Rights - Use, duplication or disclosure v1.0 restricted by GSA ADP
 * Schedule Contract with IBM Corp.
 * 
 * Contributors: IBM Corporation - initial API and implementation
 *******************************************************************************/
package com.ibm.ccl.soa.deploy.core.test.validator;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

import org.eclipse.core.runtime.IStatus;

import com.ibm.ccl.soa.deploy.core.Capability;
import com.ibm.ccl.soa.deploy.core.CapabilityLinkTypes;
import com.ibm.ccl.soa.deploy.core.CoreFactory;
import com.ibm.ccl.soa.deploy.core.ExplicitContract;
import com.ibm.ccl.soa.deploy.core.Import;
import com.ibm.ccl.soa.deploy.core.Requirement;
import com.ibm.ccl.soa.deploy.core.RequirementLinkTypes;
import com.ibm.ccl.soa.deploy.core.Topology;
import com.ibm.ccl.soa.deploy.core.Unit;
import com.ibm.ccl.soa.deploy.core.test.TopologyTestCase;
import com.ibm.ccl.soa.deploy.core.test.validator.utils.ValidatorTestUtils;
import com.ibm.ccl.soa.deploy.core.util.TopologyUtil;
import com.ibm.ccl.soa.deploy.core.validator.DeployValidatorService;
import com.ibm.ccl.soa.deploy.core.validator.matcher.LinkFactory;
import com.ibm.ccl.soa.deploy.core.validator.status.IDeployCoreValidators;
import com.ibm.ccl.soa.deploy.internal.core.extension.ContractProviderManager;
import com.ibm.ccl.soa.deploy.internal.core.topologyimport.IdentityContractProvider;

/**
 * JUnit test case for status severity override by topology contract See also
 * ContractsValidationTests in com.ibm.ccl.soa.deploy.tests, which is more
 * complete.
 * 
 * <p>
 * 
 * @author Bill Arnold
 */
public class ContractsSeverityOverrideTest extends TopologyTestCase {

	// Use instance variables for now
	/** Topology used for the middleware units. */
	private Import importTopImported;

	private Topology editTopImported;

	boolean verbose = true;

	private Unit unit1;

	private Unit unit2;

	private Unit unit3;

	private Requirement unit1HostingReq;

	private Capability unit2HostingCap;

	private Capability unit3DependencyCap;

	private Requirement unit3DependencyReq;

	/** Test case ctor */
	public ContractsSeverityOverrideTest() {
		super("ContractsSeverityOverrideTest");
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
	public void testContractsSeverityOverride() throws Exception {
		
 

		Topology importingTop = createTopology("importingTop");

		ContractProviderManager.INSTANCE.installContract(IdentityContractProvider.ID, importingTop); 

		editTopImported = createTopology("Imported", true);
		importTopImported = TopologyUtil.importTopology(editTopImported,
				importingTop);
		// add to force re-export of edited Topology
		importTopImported.setReexported(true);
		Topology importedTop = TopologyUtil.resolve(importTopImported);

		unit1 = this.addUnit(editTopImported, "unit1");
		unit2 = this.addUnit(editTopImported, "unit2");
		unit3 = this.addUnit(editTopImported, "unit3");

		unit1HostingReq = addRequirement(unit1, "unit1HostingReq",
				RequirementLinkTypes.HOSTING_LITERAL);
		unit2HostingCap = addCapability(unit2, "unit2HostingCap",
				CapabilityLinkTypes.HOSTING_LITERAL);
		unit3DependencyCap = addCapability(unit3, "unit3DependencyCap",
				CapabilityLinkTypes.DEPENDENCY_LITERAL);
		unit3DependencyReq = addRequirement(unit3, "unit3DependencyReq",
				RequirementLinkTypes.DEPENDENCY_LITERAL);

		unit1.setDisplayName("unit1");
		unit2.setDisplayName("unit2");
		unit3.setDisplayName("unit3");
		unit1HostingReq.setDisplayName("unit1HostingReq");
		unit2HostingCap.setDisplayName("unit2HostingCap");
		unit3DependencyCap.setDisplayName("unit3DependencyCap");

		LinkFactory.createHostingLink(unit1, unit2);

		save(editTopImported);
		assert (editTopImported.getUnits().size() > 1);
 
		ContractProviderManager.INSTANCE.installContract(IdentityContractProvider.ID, editTopImported);
		save(editTopImported);
		save(importingTop);

// dumpTopology(importingTop);

		// Raw error validator ids are:
		// IDeployCoreValidators.HOSTING_LINK_006
		// IDeployCoreValidators.HOSTING_001;
		// IDeployCoreValidators.DEPENDENCY_LINK_003

		{
			// ------------------------------------------------------
			// First test with identity contract
			HashSet<String> expectedErrorValidatorIDs = new HashSet<String>();
			expectedErrorValidatorIDs
					.add(IDeployCoreValidators.HOSTING_LINK_006);

			HashSet<String> expectedWarningValidatorIDs = new HashSet<String>();
			expectedWarningValidatorIDs.add(IDeployCoreValidators.HOSTING_001);
			expectedWarningValidatorIDs
					.add(IDeployCoreValidators.DEPENDENCY_LINK_003);

			// "editTopImported" has identity contract. Hosting link errors
			// should
			// be warnings
			validationTests(editTopImported, expectedErrorValidatorIDs,
					expectedWarningValidatorIDs);

			// "importingTop" has identity contract. All severities should
			// remain the
			// same
			validationTests(importingTop, expectedErrorValidatorIDs,
					expectedWarningValidatorIDs);
		}

		{
			// ------------------------------------------------------
			// Test with explicit contract on Imported, null contract on
			// topology
			// importing Imported
			// Contract summary:
			// unit1: unit, linkable true, configurable false
			// unit2: unit, linkable true, configurable true
			// unit3DependencyCap: capability, linkable true, configurable
			// true);
			//
			addExplicitContract(editTopImported);
			save(editTopImported);
			importingTop.setConfigurationContract(null);
			save(importingTop);

			HashSet<String> expectedErrorValidatorIDs = new HashSet<String>();
			expectedErrorValidatorIDs
					.add(IDeployCoreValidators.HOSTING_LINK_006);

			HashSet<String> expectedWarningValidatorIDs = new HashSet<String>();
			expectedWarningValidatorIDs.add(IDeployCoreValidators.HOSTING_001);
			expectedWarningValidatorIDs
					.add(IDeployCoreValidators.DEPENDENCY_LINK_003);

			// "editTopImported" has identity contract. Hosting link errors
			// should
			// be warnings
			validationTests(editTopImported, expectedErrorValidatorIDs,
					expectedWarningValidatorIDs);

			expectedWarningValidatorIDs.clear();
			expectedErrorValidatorIDs.add(IDeployCoreValidators.HOSTING_001);
			expectedErrorValidatorIDs
					.add(IDeployCoreValidators.DEPENDENCY_LINK_003);

			// "top" has null contract. No severities should be overridden.
			validationTests(importingTop, expectedErrorValidatorIDs,
					expectedWarningValidatorIDs);
		}
		{
			// ------------------------------------------------------
			// Test with explicit contract on Imported, empty explicit contract
			// on importing topology
			// importing Imported
			// Contract summary:
			// unit1: unit, linkable true, configurable false
			// unit2: unit, linkable true, configurable true
			// unit3DependencyCap: capability, linkable true, configurable
			// true);

			addExplicitContract(editTopImported);
			save(editTopImported);
			ExplicitContract importingTopContract = CoreFactory.eINSTANCE
					.createExplicitContract();
			importingTopContract.setName("importingTopContract");
			
			Import imported = importingTop.getImport(editTopImported.getNamespace(), editTopImported.getName());
			imported.setReexported(false);
			importingTop.setConfigurationContract(importingTopContract);
			save(importingTop);

			HashSet<String> expectedErrorValidatorIDs = new HashSet<String>();
			expectedErrorValidatorIDs
					.add(IDeployCoreValidators.HOSTING_LINK_006);

			HashSet<String> expectedWarningValidatorIDs = new HashSet<String>();
			expectedWarningValidatorIDs.add(IDeployCoreValidators.HOSTING_001);
			expectedWarningValidatorIDs
					.add(IDeployCoreValidators.DEPENDENCY_LINK_003);

			// "editTopImported" has identity contract. Hosting link errors
			// should
			// be warnings
			validationTests(editTopImported, expectedErrorValidatorIDs,
					expectedWarningValidatorIDs);

			expectedWarningValidatorIDs.clear();
			expectedErrorValidatorIDs.add(IDeployCoreValidators.HOSTING_001);
			expectedErrorValidatorIDs
					.add(IDeployCoreValidators.DEPENDENCY_LINK_003);

			// "top" has empty explicit contract. No severities should be
			// overridden.
			validationTests(importingTop, expectedErrorValidatorIDs,
					expectedWarningValidatorIDs);
		}
	}

	private void addExplicitContract(Topology top) {

		ExplicitContract explicitContract = CoreFactory.eINSTANCE
				.createExplicitContract();

		// wasSystemUnit: unit, linkable true, configurable false
		// wasServerUnit: unit, linkable true, configurable true
		// wasNode: capability, linkable true, configurable true
		explicitContract.setName("explicitContract");
		explicitContract.export(unit1, false);
		explicitContract.export(unit2, true);
		explicitContract.export(unit3DependencyCap, true);
		{ // This should NOT be necessary!!! Unit should inherit linkability
			// from children.
			explicitContract.export(unit3, false);
		}
		top.setConfigurationContract(explicitContract);
		assert (top.getConfigurationContract().isPublic(unit1));
		assert (!top.getConfigurationContract().isPublicEditable(unit1));
		// Inherit from parent
		assert (top.getConfigurationContract().isPublic(unit1HostingReq));
		assert (!top.getConfigurationContract().isPublicEditable(
				unit1HostingReq));

		assert (top.getConfigurationContract().isPublic(unit2));
		assert (top.getConfigurationContract().isPublicEditable(unit2));
		// Inherit from parent
		assert (top.getConfigurationContract().isPublic(unit2HostingCap));
		assert (top.getConfigurationContract()
				.isPublicEditable(unit2HostingCap));

		// inherit from child capability
		assert (top.getConfigurationContract().isPublic(unit3));
		assert (!top.getConfigurationContract().isPublicEditable(unit3));

		assert (top.getConfigurationContract().isPublic(unit3DependencyCap));
		assert (top.getConfigurationContract()
				.isPublicEditable(unit3DependencyCap));

	}

	private void validationTests(Topology top,
			Set<String> expectedErrorValidatorIDs,
			Set<String> expectedWarningValidatorIDs) {
		DeployValidatorService deployValidatorService = new DeployValidatorService();

		deployValidatorService.validate(top);
// String ed = ValidatorTestUtils.getTopologyErrorDescription(top);
// System.out.println("Error description ----\n" + ed + "End error description
// ----");
// String wd = ValidatorTestUtils.getTopologyWarningDescription(top);
// System.out.println("Warning description ----\n" + wd + "End warning
// description ----");
		assert ValidatorTestUtils.topologyValidatorIDsInSet(top,
				expectedErrorValidatorIDs, IStatus.ERROR);
		assert ValidatorTestUtils.topologyValidatorIDSetCover(top,
				expectedErrorValidatorIDs, IStatus.ERROR);
		assert ValidatorTestUtils.topologyValidatorIDsInSet(top,
				expectedWarningValidatorIDs, IStatus.WARNING);
		assert ValidatorTestUtils.topologyValidatorIDSetCover(top,
				expectedWarningValidatorIDs, IStatus.WARNING);
	}

	private void dumpTopology(Topology top) {
		System.out.println("Topology " + top.getName());
		for (Iterator unitIter = top.findAllUnits(); unitIter.hasNext();) {
			Unit u = (Unit) unitIter.next();
			System.out.println("(conceptual=" + u.isConceptual() + ") "
					+ u.getCaptionProvider().titleWithContext(u));
		}
	}

	private int topDirectAndIndirectUnitCount(Topology top) {
		int cnt = 0;
		for (Iterator unitIter = top.findAllUnits(); unitIter.hasNext();) {
			++cnt;
		}
		return cnt;
	}
}
