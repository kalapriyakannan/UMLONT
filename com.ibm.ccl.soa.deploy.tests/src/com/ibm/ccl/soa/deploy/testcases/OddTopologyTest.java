/*******************************************************************************
 * Copyright (c) 2003, 2007 IBM Corporation Licensed Material - Property of IBM. All rights reserved.
 *  
 * US Government Users Restricted Rights - Use, duplication or disclosure v1.0 restricted by GSA ADP
 * Schedule Contract with IBM Corp.
 * 
 * Contributors: IBM Corporation - initial API and implementation
 *******************************************************************************/
package com.ibm.ccl.soa.deploy.testcases;

import org.eclipse.emf.ecore.resource.Resource;

import com.ibm.ccl.soa.deploy.core.Capability;
import com.ibm.ccl.soa.deploy.core.CoreFactory;
import com.ibm.ccl.soa.deploy.core.CorePackage;
import com.ibm.ccl.soa.deploy.core.HostingLink;
import com.ibm.ccl.soa.deploy.core.MemberLink;
import com.ibm.ccl.soa.deploy.core.Requirement;
import com.ibm.ccl.soa.deploy.core.RequirementLinkTypes;
import com.ibm.ccl.soa.deploy.core.Topology;
import com.ibm.ccl.soa.deploy.core.Unit;
import com.ibm.ccl.soa.deploy.core.test.TopologyTestCase;
import com.ibm.ccl.soa.deploy.core.test.validator.utils.ValidatorTestUtils;
import com.ibm.ccl.soa.deploy.core.util.UnitUtil;

/**
 * JUnit test case that generates topologies for interactive testing.
 * 
 * @author Ed Snible (updates)
 */
public class OddTopologyTest extends TopologyTestCase {

	/** Test case ctor */
	public OddTopologyTest() {
		super("OddTopologyTest");
	}

	/*
	 * Suppress deletion of generated topologies
	 */
	protected void tearDown() throws Exception {
	}

	protected Topology createTopology(String name) {
		Topology retVal = super.createTopology(name);
		retVal.setDisplayName(name);
		return retVal;
	}

// TODO
// A groups B, B groups A, both A and B are config units, A is hosted by C.
//
// A groups B, B groups A, A is a config unit, A is hosted by C.
//
// A groups B, B groups A, B is a config unit, A is hosted by C.
//
// A groups B, is a config node, and is hosted by B.
//
// A groups B, is a config node, and is hosted by B which is also a config unit.
//
// A is both hosted by and a member of B.
//
// A is a config unit and both hosted by and a member of B.
//
// A is hosted by B, and B contains A.
//
// A is hosted by B, and B contains A, and A is a config unit.
//
// A is hosted by B, and B contains A, and B is a config unit.

// TODO The Lost Topologies
// testAConfiguresBAndAAndBmembersofC
// testAHostedByB
// testAHostedByBAndAAndBbothMembersofC
// testAHostedByBAndAisaMemberofC
// testAHostedByBAndAisaMemberofCAndCisaMemberofD
// testAHostedByBAndAisaMemberofCAndD
// testAHostedByBAndAisaMemberofCAndDAndCisaMemberofEAndDisaMemberofF
// testAHostedByBAndBconfiguresC
// testAHostedByBAndBconfiguresCAndCconfiguresD
// testAHostedByBAndBconfiguresCAndChostedbyD
// testAHostedByBAndBisaMemberofC
// testAHostedByBAndBisaMemberofCAndCisaMemberofD
// testAHostedByBAndBisaMemberofCAndD
// testAHostedByBAndBisaMemberofCAndDAndCisaMemberofEAndDisaMemberofF
// testContainsItself
// testDirectHostingRecursion
// testDirectMemberRecursion
// testHostsItself
// testIndirectHostingRecursion
// testIndirectMemberRecursion

	/**
	 * A groups B, B groups A, both A and B are config units, A is hosted by C.
	 * 
	 * @throws Exception
	 */
	public void testAgroupsBandBgroupsAandBothAandBareconfigunitsAishostedbyC()
			throws Exception {

		Topology top = createTopology("A_groups_B,_B_groups_A,_both_A_and_B_are_config_units,_A_is_hosted_by_C");

		Unit a = createUnit(top, "A");
		a.setConfigurationUnit(true);
		Unit b = createUnit(top, "B");
		b.setConfigurationUnit(true);
		setGrouping(a, b);
		setGrouping(b, a);
		Unit c = createUnit(top, "C");
		setHosting(a, c);

// System.out.println(getTopologyAsString(top));

		Resource res = top.getEObject().eResource();
		res.save(null);
	}

	/**
	 * A groups B, B groups A, A is a config unit, A is hosted by C.
	 * 
	 * @throws Exception
	 */
	public void test_A_groups_B_B_groups_A_A_is_a_config_unit_A_is_hosted_by_C()
			throws Exception {

		Topology top = createTopology("A_groups_B,_B_groups_A,_A_is_a_config_unit,_A_is_hosted_by_C");

		Unit a = createUnit(top, "A");
		a.setConfigurationUnit(true);
		Unit b = createUnit(top, "B");
		setGrouping(a, b);
		setGrouping(b, a);
		Unit c = createUnit(top, "C");
		setHosting(a, c);

		Resource res = top.getEObject().eResource();
		res.save(null);
	}

	/**
	 * A is a group, is a config node, and is hosted by B.
	 * 
	 * @throws Exception
	 */
	public void testAIsaGroupIsaConfigAndishostedbyB() throws Exception {

		Topology top = createTopology("A_isa_group,_A_isa_config_unit,_A_is_hosted_by_B");

		Unit a = createUnit(top, "A");
		a.setConfigurationUnit(true);
		makeGroup(a);
		Unit b = createUnit(top, "B");
		setHosting(a, b);

		Resource res = top.getEObject().eResource();
		res.save(null);
	}

	private void makeGroup(Unit container) {
		// Create a requirement on the container
		Requirement req = CoreFactory.eINSTANCE.createRequirement();
		req.setLinkType(RequirementLinkTypes.MEMBER_LITERAL);
		req.setName(UnitUtil.generateUniqueName(container, "r"));
		req.setDmoEType(CorePackage.eINSTANCE.getUnit());
		container.getRequirements().add(req);
	}

	/**
	 * A_groups_itself,_is_a_config_node,_and_is_hosted_by_B
	 * 
	 * @throws Exception
	 */
	public void testAgroupsItselfIsAConfigNodeAndIsHostedByB() throws Exception {

		Topology top = createTopology("A_groups_itself,_is_a_config_node,_and_is_hosted_by_B");

		Unit a = createUnit(top, "A");
		a.setConfigurationUnit(true);
		Unit b = createUnit(top, "B");
		setGrouping(a, a);
		setHosting(a, b);

		Resource res = top.getEObject().eResource();
		res.save(null);
	}

	private void setGrouping(Unit container, Unit contents) {
		// Create a requirement on the container
		Requirement req = CoreFactory.eINSTANCE.createRequirement();
		req.setLinkType(RequirementLinkTypes.MEMBER_LITERAL);
		req.setName(UnitUtil.generateUniqueName(container, "r"));
		req.setDmoEType(contents.eClass());
		container.getRequirements().add(req);

		MemberLink ml = CoreFactory.eINSTANCE.createMemberLink();
		ml.setName(UnitUtil.generateUniqueName(container, "mlink"));
		ml.setTarget(contents);
		container.getUnitLinks().add(ml);
	}

	/**
	 * @param hostee
	 * @param hoster
	 * @see ValidatorTestUtils#hosts(Unit, Unit)
	 */
	private void setHosting(Unit hostee, Unit hoster) {
		// Create a requirement on the hostee
		Requirement req = CoreFactory.eINSTANCE.createRequirement();
		req.setLinkType(RequirementLinkTypes.HOSTING_LITERAL);
		req.setName(UnitUtil.generateUniqueName(hostee, "r"));
		Capability capHoster = (Capability) hoster.getCapabilities().get(0);
		req.setDmoEType(capHoster.eClass());
		hostee.getRequirements().add(req);

		HostingLink hl = CoreFactory.eINSTANCE.createHostingLink();
		hl.setName(UnitUtil.generateUniqueName(hoster, "hlink"));
		hl.setTarget(hostee);
		hoster.getUnitLinks().add(hl);
	}

	private Unit createUnit(Topology top, String displayName) {
		Unit retVal = CoreFactory.eINSTANCE.createUnit();
		//Unit retVal = GenericFactory.eINSTANCE.createGenericUnit();
		//Generic cap = GenericFactory.eINSTANCE.createGeneric();
		Capability cap = CoreFactory.eINSTANCE.createCapability();
		cap.setName(UnitUtil.generateUniqueName(retVal, "cap"));
		retVal.getCapabilities().add(cap);
		retVal.setName(UnitUtil.generateUniqueName(top, "u"));
		retVal.setDisplayName(displayName);

		top.getUnits().add(retVal);

		return retVal;
	}

	/**
	 * @param link
	 */
	public static void createLinkName(HostingLink link) {
		String name;
		name = "hosted" + link.getHost().getName() + "In"
				+ link.getHosted().getName();
		link.setName(name);
	}

} // end class OddTopologyTest
