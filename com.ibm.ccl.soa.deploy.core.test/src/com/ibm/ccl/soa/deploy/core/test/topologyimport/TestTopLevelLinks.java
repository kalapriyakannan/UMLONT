/*******************************************************************************
 * Copyright (c) 2003, 2007 IBM Corporation Licensed Material - Property of IBM. All rights reserved.
 *  
 * US Government Users Restricted Rights - Use, duplication or disclosure v1.0 restricted by GSA ADP
 * Schedule Contract with IBM Corp.
 * 
 * Contributors: IBM Corporation - initial API and implementation
 *******************************************************************************/
package com.ibm.ccl.soa.deploy.core.test.topologyimport;

import java.io.IOException;

import com.ibm.ccl.soa.deploy.core.Capability;
import com.ibm.ccl.soa.deploy.core.CoreFactory;
import com.ibm.ccl.soa.deploy.core.DependencyLink;
import com.ibm.ccl.soa.deploy.core.HostingLink;
import com.ibm.ccl.soa.deploy.core.Import;
import com.ibm.ccl.soa.deploy.core.ConstraintLink;
import com.ibm.ccl.soa.deploy.core.MemberLink;
import com.ibm.ccl.soa.deploy.core.Requirement;
import com.ibm.ccl.soa.deploy.core.Topology;
import com.ibm.ccl.soa.deploy.core.Unit;
import com.ibm.ccl.soa.deploy.core.test.TopologyTestCase;

public class TestTopLevelLinks extends TopologyTestCase {

	private static final String PROJECT_NAME = "TopLevelLinksTest";
	private static final String TOP_NAMESPACE = "com.ibm.test.namespace";

	public TestTopLevelLinks() {
		super(PROJECT_NAME);
	}

	public TestTopLevelLinks(String name) {
		super(name);
		setDeleteProjectOnTearDown(false);
	}

	public void testTopLevelLinks() throws IOException {

		// //////////////////////////////////
		// Test import-related model content
		// //////////////////////////////////
		Topology top = createTopology("topLevelLinks", true);

		// namespace attribute
		top.setNamespace(TOP_NAMESPACE);
		assert top.getNamespace().equals(TOP_NAMESPACE);

		// Create top-level hosting link
		Unit unit1 = CoreFactory.eINSTANCE.createUnit();
		unit1.setName("unit1");
		top.getUnits().add(unit1);
		Unit unit2 = CoreFactory.eINSTANCE.createUnit();
		unit2.setName("unit2");
		top.getUnits().add(unit2);
		createTopLevelHostingLink(top, "link1", unit1, unit2);
		assert top.getUnitLinks().size() == 1;
		assert top.getHostingLinks().size() == 1;
		assert ((HostingLink) top.getHostingLinks().get(0)).getTarget() == unit2;
		assert ((HostingLink) top.getHostingLinks().get(0)).getSource() == unit1;

		// Create top-level member link
		Unit groupUnit = CoreFactory.eINSTANCE.createUnit();
		groupUnit.setName("group1");
		top.getUnits().add(groupUnit);
		Unit memberUnit = CoreFactory.eINSTANCE.createUnit();
		memberUnit.setName("member1");
		top.getUnits().add(memberUnit);
		createTopLevelMemberLink(top, "link2", memberUnit, groupUnit);
		assert top.getUnitLinks().size() == 2;
		assert top.getMemberLinks().size() == 1;
		assert ((MemberLink) top.getMemberLinks().get(0)).getTarget() == groupUnit;
		assert ((MemberLink) top.getMemberLinks().get(0)).getSource() == memberUnit;

		// Create top-level logical link
		Unit logunit1 = CoreFactory.eINSTANCE.createUnit();
		logunit1.setName("logunit1");
		top.getUnits().add(logunit1);
		Unit logunit2 = CoreFactory.eINSTANCE.createUnit();
		logunit2.setName("logunit2");
		top.getUnits().add(logunit2);
		createTopLevelConstraintLink(top, "link2", logunit1, logunit2);
		assert top.getConstraintLinks().size() == 1;
		assert ((ConstraintLink) top.getConstraintLinks().get(0)).getTarget() == logunit2;
		assert ((ConstraintLink) top.getConstraintLinks().get(0)).getSource() == logunit1;

		// create top-level dependency link
		Unit unit3 = CoreFactory.eINSTANCE.createUnit();
		unit3.setName("unit3");
		Requirement req = CoreFactory.eINSTANCE.createRequirement();
		req.setName("req1");
		unit3.getRequirements().add(req);
		top.getUnits().add(unit3);
		Unit unit4 = CoreFactory.eINSTANCE.createUnit();
		unit4.setName("unit4");
		top.getUnits().add(unit4);
		Capability cap = CoreFactory.eINSTANCE.createCapability();
		cap.setName("cap");
		unit4.getCapabilities().add(cap);
		createTopLevelDependencyLink(top, "deplink1", req, cap);
		assert top.getDependencyLinks().size() == 1;
		assert ((DependencyLink) top.getDependencyLinks().get(0)).getTarget() == cap;
		assert ((DependencyLink) top.getDependencyLinks().get(0)).getSource() == req;

		// Create another topology, add some units
		Topology top2 = createTopology("topologyImport2", true);
		top2.setNamespace(TOP_NAMESPACE);
		Unit unit12 = CoreFactory.eINSTANCE.createUnit();
		unit12.setName("unit12");
		top2.getUnits().add(unit12);
		Unit unit22 = CoreFactory.eINSTANCE.createUnit();
		unit22.setName("unit22");
		top2.getUnits().add(unit22);

		// Import top2 into top
		Import topimport = CoreFactory.eINSTANCE.createImport();
		topimport.setNamespace(TOP_NAMESPACE + "." + top2.getName());
		top.getImports().add(topimport);

		// Create a cross-topology link - does not work yet.
		createTopLevelHostingLink(top, "link11", unit1, unit12);

		// //////////////////////////////////
		// Test serialization
		// //////////////////////////////////
		top = reload(top, true);
		assert top.getNamespace().equals(TOP_NAMESPACE);
		top2 = reload(top2, true);
		assert top2.getNamespace().equals(TOP_NAMESPACE);
	}

	private void createTopLevelHostingLink(Topology top, String name,
			Unit source, Unit target) {
		HostingLink link = CoreFactory.eINSTANCE.createHostingLink();
		link.setName(name);
		link.setSource(source);
		link.setTarget(target);
		top.getHostingLinks().add(link);
	}

	private void createTopLevelMemberLink(Topology top, String name,
			Unit source, Unit target) {
		MemberLink link = CoreFactory.eINSTANCE.createMemberLink();
		link.setName(name);
		link.setSource(source);
		link.setTarget(target);
		top.getMemberLinks().add(link);
	}

	private void createTopLevelDependencyLink(Topology top, String name,
			Requirement source, Capability target) {
		DependencyLink link = CoreFactory.eINSTANCE.createDependencyLink();
		link.setName(name);
		link.setSource(source);
		link.setTarget(target);
		top.getDependencyLinks().add(link);
	}

	private void createTopLevelConstraintLink(Topology top, String name,
			Unit source, Unit target) {
		ConstraintLink link = CoreFactory.eINSTANCE.createConstraintLink();
		link.setName(name);
		link.setSource(source);
		link.setTarget(target);
		top.getConstraintLinks().add(link);
	}

}
