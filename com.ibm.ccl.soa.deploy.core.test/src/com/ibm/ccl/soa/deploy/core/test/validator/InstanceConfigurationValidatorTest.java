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
import java.util.List;
import java.util.Set;

import org.eclipse.core.runtime.IStatus;

import com.ibm.ccl.soa.deploy.core.Capability;
import com.ibm.ccl.soa.deploy.core.CapabilityLinkTypes;
import com.ibm.ccl.soa.deploy.core.CoreFactory;
import com.ibm.ccl.soa.deploy.core.DeployModelObject;
import com.ibm.ccl.soa.deploy.core.ExplicitContract;
import com.ibm.ccl.soa.deploy.core.Import;
import com.ibm.ccl.soa.deploy.core.InstanceConfiguration;
import com.ibm.ccl.soa.deploy.core.Instantiation;
import com.ibm.ccl.soa.deploy.core.Requirement;
import com.ibm.ccl.soa.deploy.core.RequirementLinkTypes;
import com.ibm.ccl.soa.deploy.core.Topology;
import com.ibm.ccl.soa.deploy.core.Unit;
import com.ibm.ccl.soa.deploy.core.test.TopologyTestCase;
import com.ibm.ccl.soa.deploy.core.test.validator.utils.ValidatorTestUtils;
import com.ibm.ccl.soa.deploy.core.util.TopologyUtil;
import com.ibm.ccl.soa.deploy.core.validator.DeployValidatorService;
import com.ibm.ccl.soa.deploy.core.validator.status.IDeployCoreValidators;

/**
 * JUnit test case for InstanceConfiguration validation
 * 
 * <p>
 * 
 * @author Bill Arnold
 */
public class InstanceConfigurationValidatorTest extends TopologyTestCase {

	// Use instance variables for now
	/** Topology used for the middleware units. */
	private Import importTopImported;

	private Topology editTopImported;

	boolean verbose = true;

	private Unit unit1;

	private Unit unit2;

	private Requirement unit1HostingReq;

	private Capability unit2HostingCap;

	/** Test case ctor */
	public InstanceConfigurationValidatorTest() {
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
	public void testInstanceConfiguration() throws Exception {
		ExplicitContract identityContractImporting = CoreFactory.eINSTANCE
				.createExplicitContract();
		identityContractImporting.setName("identityContractImporting");

		ExplicitContract identityContractImported = CoreFactory.eINSTANCE
				.createExplicitContract();
		identityContractImported.setName("identityContractImported");

		Topology importingTop = createTopology("importingTop");
		importingTop.setConfigurationContract(identityContractImporting);

		editTopImported = createTopology("Imported", true);
		importTopImported = TopologyUtil.importTopology(editTopImported,
				importingTop);
		Topology importedTop = TopologyUtil.resolve(importTopImported);

		unit1 = addUnit(editTopImported, "unit1");
		unit2 = addUnit(editTopImported, "unit2");

		unit1HostingReq = addRequirement(unit1, "unit1HostingReq",
				RequirementLinkTypes.HOSTING_LITERAL);
		unit2HostingCap = addCapability(unit2, "unit2HostingCap",
				CapabilityLinkTypes.HOSTING_LITERAL);

		unit1.setDisplayName("unit1");
		unit2.setDisplayName("unit2");
		unit1HostingReq.setDisplayName("unit1HostingReq");
		unit2HostingCap.setDisplayName("unit2HostingCap");

// LinkFactory.createHostingLink(unit2, unit1);

		save(editTopImported);
		assert (editTopImported.getUnits().size() > 1);

		editTopImported.setConfigurationContract(identityContractImported);
		save(editTopImported);
		save(importingTop);

// dumpTopology(importingTop);

		{
			// ------------------------------------------------------
			// Test with explicit contract on Imported, null contract on
			// topology
			// importing Imported
			// Contract summary:
			// unit1: unit, linkable true, configurable false
			// unit2: unit, linkable true, configurable true
			//
			addExplicitContract(editTopImported);
			save(editTopImported);
			importingTop.setConfigurationContract(null);
			save(importingTop);

			HashSet<String> expectedErrorValidatorIDs = new HashSet<String>();
			expectedErrorValidatorIDs.add(IDeployCoreValidators.HOSTING_001);

			HashSet<String> expectedWarningValidatorIDs = new HashSet<String>();

			// Baseline validation results on importing top
			// "importingTop" has null contract. No severities should be
			// overridden.
			validationTests(importingTop, expectedErrorValidatorIDs,
					expectedWarningValidatorIDs);

			int savedVisibleUnitsImportedSize;
			DeployModelObject unit2Imported;

			InstanceConfiguration icImportTopImported = importTopImported
					.getInstanceConfiguration();

			{
				List<Unit> visibleUnitsImported = icImportTopImported
						.getPublicUnits();
				List<Unit> visibleConfigurableUnitsImported = icImportTopImported
						.getPublicEditableUnits();
				List<Unit> infraUnits = editTopImported
						.getConfigurationContract().getPublicUnits();
				List<Unit> infraConfigurableUnits = editTopImported
						.getConfigurationContract().getPublicEditableUnits();

				assert infraUnits.size() == visibleUnitsImported.size(); 
				assert infraUnits.size() > 0; 
				savedVisibleUnitsImportedSize = visibleUnitsImported.size();

				assert (icImportTopImported.isPublic(unit1));
				assert (icImportTopImported.isPublicEditable(unit2));
				Instantiation instantiation = icImportTopImported
						.getInstantiation(unit2.getName());
				// there are no modifications/augmentations for unit2, 
				// so it shouldn't have an instantiation record
				assert (instantiation == null); 
				String namespace = importTopImported.getNamespace();
				String path = importTopImported.getPattern() + ":/"
						+ unit2.getName();
				if (namespace != null) {
					path = namespace + "." + path;
				}
				
				DeployModelObject editTopReferencedDMO = importingTop
						.getEditTopology().resolve(path);
				assert (editTopReferencedDMO != null);
				unit2Imported = editTopReferencedDMO;
			}

			unit2Imported.setDescription("xyz");
			assert (editTopImported.getUnits().remove(unit2));
			save(editTopImported);

			// The instantation will be present, but now unresolvable.
			{
				List<Unit> visibleUnitsImported = icImportTopImported
						.getPublicUnits();
				List<Unit> visibleConfigurableUnitsImported = icImportTopImported
						.getPublicEditableUnits();
				List<Unit> infraUnits = editTopImported
						.getConfigurationContract().getPublicUnits();
				List<Unit> infraConfigurableUnits = editTopImported
						.getConfigurationContract().getPublicEditableUnits();

				assert infraUnits.size() == visibleUnitsImported.size(); 
				assert infraUnits.size() > 0; 
				assert (savedVisibleUnitsImportedSize > visibleUnitsImported
						.size());

				assert (icImportTopImported.isPublic(unit1));
				assert (icImportTopImported.isPublicEditable(unit2));
				Instantiation instantiation = icImportTopImported
						.getInstantiation(unit2.getName());
				assert (instantiation == null); 
				String namespace = importTopImported.getNamespace();
				String path = importTopImported.getPattern() + ":/"
						+ unit2.getName();
				if (namespace != null) {
					path = namespace + "." + path;
				}
				DeployModelObject editTopReferencedDMO = importingTop
						.getEditTopology().resolve(path);
				assert (editTopReferencedDMO == null);
			}

			expectedErrorValidatorIDs
					.add(IDeployCoreValidators.TOPOLOGY_IMPORT_003);
			validationTests(importingTop, expectedErrorValidatorIDs,
					expectedWarningValidatorIDs);
		}
	}

	private void addExplicitContract(Topology top) {

		ExplicitContract explicitContract = CoreFactory.eINSTANCE
				.createExplicitContract();

		// unit1: unit, linkable true, configurable false
		// unit2: unit, linkable true, configurable true
		explicitContract.setName("explicitContract");
		explicitContract.export(unit1, false);
		explicitContract.export(unit2, true);
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
	}

	private void validationTests(Topology top,
			Set<String> expectedErrorValidatorIDs,
			Set<String> expectedWarningValidatorIDs) {
		DeployValidatorService deployValidatorService = new DeployValidatorService();

		deployValidatorService.validate(top);
		String ed = ValidatorTestUtils.getTopologyErrorDescription(top);
		System.out.println("Error description ----\n" + ed
				+ "End error description ----");
		String wd = ValidatorTestUtils.getTopologyWarningDescription(top);
		System.out.println("Warning description ----\n" + wd
				+ "End warning description ----");
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
