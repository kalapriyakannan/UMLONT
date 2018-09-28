/*******************************************************************************
 * Copyright (c) 2003, 2007 IBM Corporation Licensed Material - Property of IBM. All rights reserved.
 *  
 * US Government Users Restricted Rights - Use, duplication or disclosure v1.0 restricted by GSA ADP
 * Schedule Contract with IBM Corp.
 * 
 * Contributors: IBM Corporation - initial API and implementation
 *******************************************************************************/
package com.ibm.ccl.soa.deploy.core.test.imports;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.ibm.ccl.soa.deploy.core.Artifact;
import com.ibm.ccl.soa.deploy.core.Capability;
import com.ibm.ccl.soa.deploy.core.CapabilityLinkTypes;
import com.ibm.ccl.soa.deploy.core.Constraint;
import com.ibm.ccl.soa.deploy.core.ConstraintLink;
import com.ibm.ccl.soa.deploy.core.CoreFactory;
import com.ibm.ccl.soa.deploy.core.CorePackage;
import com.ibm.ccl.soa.deploy.core.DependencyLink;
import com.ibm.ccl.soa.deploy.core.DeployModelObject;
import com.ibm.ccl.soa.deploy.core.FileArtifact;
import com.ibm.ccl.soa.deploy.core.HostingLink;
import com.ibm.ccl.soa.deploy.core.Import;
import com.ibm.ccl.soa.deploy.core.MemberLink;
import com.ibm.ccl.soa.deploy.core.RealizationLink;
import com.ibm.ccl.soa.deploy.core.Requirement;
import com.ibm.ccl.soa.deploy.core.RequirementLinkTypes;
import com.ibm.ccl.soa.deploy.core.Topology;
import com.ibm.ccl.soa.deploy.core.Unit;
import com.ibm.ccl.soa.deploy.core.constraint.ConstraintFactory;
import com.ibm.ccl.soa.deploy.core.constraint.EqualsConstraint;
import com.ibm.ccl.soa.deploy.core.test.TopologyTestCase;
import com.ibm.ccl.soa.deploy.core.util.TopologyUtil;

/**
 * Tests the {@link Topology} findAll*() methods to check if they return objects
 * from imported topologies.
 */
public class TopologyImportFindAllTests extends TopologyTestCase {

	public TopologyImportFindAllTests() {
		super("TopologyImportFindAllTests");
	}

	public void testFindAll() throws IOException {
		//
		// Create topology 1 that will be imported
		//
		Topology top1 = createTopology("testStatusSeparation1");
		List<DeployModelObject> top1Objects = new ArrayList<DeployModelObject>();

		// Unit
		Unit unit1 = addUnit(top1, "u1");
		top1Objects.add(unit1);

		// Capability
		Capability cap1 = addCapability(unit1, "u1",
				CapabilityLinkTypes.ANY_LITERAL);
		top1Objects.add(cap1);

		// Requirement
		Requirement req1 = addRequirement(unit1, "r1",
				RequirementLinkTypes.HOSTING_LITERAL);
		top1Objects.add(req1);

		// Artifact
		FileArtifact artifact1 = CoreFactory.eINSTANCE.createFileArtifact();
		artifact1.setName("a1");
		unit1.getArtifacts().add(artifact1);
		top1Objects.add(artifact1);

		// Constraint
		EqualsConstraint const1 = ConstraintFactory.eINSTANCE
				.createEqualsConstraint();
		const1.setName("c1");
		const1.setAttributeName(CorePackage.eINSTANCE
				.getDeployModelObject_Name().getName());
		const1.setValue(unit1.getName());
		unit1.getConstraints().add(const1);
		top1Objects.add(const1);

		//
		// Links (local and topology-level containment)
		//

		// Dependency Link
		DependencyLink dlink1 = CoreFactory.eINSTANCE.createDependencyLink();
		dlink1.setName("dlink1");
		req1.setLink(dlink1);
		top1Objects.add(dlink1);

		DependencyLink dlink2 = CoreFactory.eINSTANCE.createDependencyLink();
		dlink2.setName("dlink2");
		top1.getDependencyLinks().add(dlink2);
		top1Objects.add(dlink2);

		// Hosting Link
		HostingLink hlink1 = CoreFactory.eINSTANCE.createHostingLink();
		hlink1.setName("hlink1");
		unit1.getHostingLinks().add(hlink1);
		top1Objects.add(hlink1);

		HostingLink hlink2 = CoreFactory.eINSTANCE.createHostingLink();
		hlink2.setName("hlink2");
		top1.getHostingLinks().add(hlink2);
		top1Objects.add(hlink2);

		// Member Link
		MemberLink mlink1 = CoreFactory.eINSTANCE.createMemberLink();
		mlink1.setName("mlink1");
		unit1.getMemberLinks().add(mlink1);
		top1Objects.add(mlink1);

		MemberLink mlink2 = CoreFactory.eINSTANCE.createMemberLink();
		mlink2.setName("mlink2");
		top1.getMemberLinks().add(mlink2);
		top1Objects.add(mlink2);

		// Constraint Link
		ConstraintLink clink1 = CoreFactory.eINSTANCE.createConstraintLink();
		clink1.setName("clink1");
		unit1.getConstraintLinks().add(clink1);
		top1Objects.add(clink1);

		ConstraintLink clink2 = CoreFactory.eINSTANCE.createConstraintLink();
		clink2.setName("clink2");
		top1.getConstraintLinks().add(clink2);
		top1Objects.add(clink2);

		// Realization Link
		RealizationLink rlink1 = CoreFactory.eINSTANCE.createRealizationLink();
		rlink1.setName("rlink1");
		unit1.getRealizationLinks().add(rlink1);
		top1Objects.add(rlink1);

		RealizationLink rlink2 = CoreFactory.eINSTANCE.createRealizationLink();
		rlink2.setName("rlink2");
		top1.getRealizationLinks().add(rlink2);
		top1Objects.add(rlink2);

		// Verify that the set of all objects matches what is returned by
		// findAllDeployModelObjects
		assertSetEquals(top1.findAllDeployModelObjects(), top1Objects.toArray());

		// Need to save in order to import
		save(top1);

		//
		// Create topology 2 and import topology 1
		//
		Topology top2 = createTopology("testStatusSeparation2");
		Import top1Import = TopologyUtil.importTopology(top1, top2);
		save(top2);

		// Look up all the proxy objects for each top1 object
		List<DeployModelObject> top2AllObjects = new ArrayList<DeployModelObject>();
		top2AllObjects.add(top1Import);
		top2AllObjects.add(top1Import.getInstanceConfiguration());
		for (DeployModelObject obj : top1Objects) {
			DeployModelObject obji = top2.resolve(getGlobalPath(obj));
			assertNotNull("Import view did not include " + obj.getName(), obji);
			top2AllObjects.add(obji);
		}
		Unit unit1i = getImportedObject(top2, unit1);
		Capability cap1i = getImportedObject(top2, cap1);
		Requirement req1i = getImportedObject(top2, req1);
		Artifact artifact1i = getImportedObject(top2, artifact1);
		Constraint const1i = getImportedObject(top2, const1);
		DependencyLink dlink1i = getImportedObject(top2, dlink1);
		DependencyLink dlink2i = getImportedObject(top2, dlink2);
		HostingLink hlink1i = getImportedObject(top2, hlink1);
		HostingLink hlink2i = getImportedObject(top2, hlink2);
		MemberLink mlink1i = getImportedObject(top2, mlink1);
		MemberLink mlink2i = getImportedObject(top2, mlink2);
		ConstraintLink clink1i = getImportedObject(top2, clink1);
		ConstraintLink clink2i = getImportedObject(top2, clink2);
		RealizationLink rlink1i = getImportedObject(top2, rlink1);
		RealizationLink rlink2i = getImportedObject(top2, rlink2);

		// Check that top1.findAllDeployModelObjects() returns proxies for all
		// objects of top1
		assertSetEquals(top2.findAllDeployModelObjects(), top2AllObjects
				.toArray());

		assertSetEquals(top2.findAllArtifacts(), new Object[] { artifact1i });
		assertSetEquals(top2.findAllCapabilities(), new Object[] { cap1i });
		assertSetEquals(top2.findAllConfigurationUnits(), new Object[] {});
		assertSetEquals(top2.findAllConstraintLinks(), new Object[] { clink1i,
				clink2i });
		assertSetEquals(top2.findAllDependencyLinks(), new Object[] { dlink1i,
				dlink2i });
		assertSetEquals(top2.findAllDeployLinks(), new Object[] { dlink1i,
				dlink2i, hlink1i, hlink2i, mlink1i, mlink2i, clink1i, clink2i,
				rlink1i, rlink2i });
		assertSetEquals(top2.findAllHostingCapabilities(),
				new Object[] { cap1i });
		assertSetEquals(top2.findAllHostingLinks(), new Object[] { hlink1i,
				hlink2i });
		assertSetEquals(top2.findAllHostingRequirements(),
				new Object[] { req1i });
		assertSetEquals(top2.findAllMemberLinks(), new Object[] { mlink1i,
				mlink2i });
		assertSetEquals(top2.findAllNonHostingCapabilities(), new Object[] {});
		assertSetEquals(top2.findAllNonHostingRequirements(), new Object[] {});
		assertSetEquals(top2.findAllPublicUnits(), new Object[] {});
		assertSetEquals(top2.findAllRealizationLinks(), new Object[] { rlink1i,
				rlink2i });
		assertSetEquals(top2.findAllRequirements(), new Object[] { req1i });
		assertSetEquals(top2.findAllUnitLinks(), new Object[] { hlink1i,
				hlink2i, mlink1i, mlink2i });
		assertSetEquals(top2.findAllUnits(), new Object[] { unit1i });
	}
}
