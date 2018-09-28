/*******************************************************************************
 * Copyright (c) 2003, 2007 IBM Corporation Licensed Material - Property of IBM. All rights reserved.
 *  
 * US Government Users Restricted Rights - Use, duplication or disclosure v1.0 restricted by GSA ADP
 * Schedule Contract with IBM Corp.
 * 
 * Contributors: IBM Corporation - initial API and implementation
 *******************************************************************************/
package com.ibm.ccl.soa.deploy.core.test.validator.matcher;

import java.io.IOException;
import java.math.BigInteger;
import java.util.HashMap;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.ecore.xmi.XMLResource;

import com.ibm.ccl.soa.deploy.core.Capability;
import com.ibm.ccl.soa.deploy.core.CapabilityLinkTypes;
import com.ibm.ccl.soa.deploy.core.CommunicationCapability;
import com.ibm.ccl.soa.deploy.core.CoreFactory;
import com.ibm.ccl.soa.deploy.core.CorePackage;
import com.ibm.ccl.soa.deploy.core.DeployCoreRoot;
import com.ibm.ccl.soa.deploy.core.InstallState;
import com.ibm.ccl.soa.deploy.core.Requirement;
import com.ibm.ccl.soa.deploy.core.RequirementExpression;
import com.ibm.ccl.soa.deploy.core.RequirementExpressionUsage;
import com.ibm.ccl.soa.deploy.core.RequirementLinkTypes;
import com.ibm.ccl.soa.deploy.core.RequirementUsage;
import com.ibm.ccl.soa.deploy.core.Topology;
import com.ibm.ccl.soa.deploy.core.Unit;
import com.ibm.ccl.soa.deploy.core.test.TopologyTestCase;
import com.ibm.ccl.soa.deploy.core.validator.expression.Equals;
import com.ibm.ccl.soa.deploy.core.validator.matcher.CoreDomainMatcher;
import com.ibm.ccl.soa.deploy.core.validator.matcher.LinkDescriptor;
import com.ibm.ccl.soa.deploy.core.validator.matcher.LinkType;

/**
 * @author Ed Snible <snible@us.ibm.com> based on Michael's example
 */
public class MatcherTest extends TopologyTestCase {

	private static final String PROJECT_NAME = "MatcherTest";

	/** Shared validator instance. */
	private CoreDomainMatcher matcher;

	public MatcherTest() {
		super(PROJECT_NAME);
	}

	public MatcherTest(String name) {
		super(name);
	}

	/*
	 * @see junit.framework.TestCase#setUp()
	 */
	protected void setUp() throws Exception {
		super.setUp();
		matcher = new CoreDomainMatcher();
	}

	// Generate unitGroup.template to stdout using model
	public void testWhatUnitGroupShouldLookLike() throws IOException {
		Topology top = createTopology("topology1");
		Unit unit2 = CoreFactory.eINSTANCE.createUnit();
		unit2.setName("UnitGroup");
		unit2.setDisplayName("UnitGroup");
		Requirement req = CoreFactory.eINSTANCE.createRequirement();
		req.setDisplayName("GroupMembership");
		req.setName("GroupMembership");
		req.setLinkType(RequirementLinkTypes.MEMBER_LITERAL);
		req.setUse(RequirementUsage.OPTIONAL_LITERAL);
		req.setDmoEType(CorePackage.eINSTANCE.getUnit());
		unit2.getRequirements().add(req);
		RequirementExpression re = CoreFactory.eINSTANCE
				.createRequirementExpression();
		re.setInterpreter("hasMember");
		re.setUse(RequirementExpressionUsage.REQUIRED_LITERAL);
		re.setValue("*");
		req.getExpressions().add(re);
		top.getUnits().add(unit2);

		ResourceSet rs = new ResourceSetImpl();
		Resource resource = rs.createResource(URI
				.createURI("resource.extension"));
		DeployCoreRoot root = CoreFactory.eINSTANCE.createDeployCoreRoot();
		root.setTopology(top);
		resource.getContents().add(root);

		HashMap options = new HashMap();
		options.put(XMLResource.OPTION_EXTENDED_META_DATA, Boolean.TRUE);
		resource.save(System.out, options);
	}

	// TODO Uncomment once unitGroup.template loads properly
// public void testUnitGroupMemberLinkMatching() throws IOException {
// String templateURIString =
// "platform:/plugin/com.ibm.ccl.soa.deploy.core/templates/unitGroup.template";
// URI templateURI = URI.createURI(templateURIString );
// Resource resource =
// JEMUtilPlugin.getPluginResourceSet().getResource(templateURI, true);
// DeployCoreRoot root = (DeployCoreRoot) resource.getContents().get(0);
// Topology template = root.getTopology();
//		
// Topology top = createTopology("testUnitGroupMemberLinkMatching");
// Unit unit1 = (Unit) template.getUnits().get(0);
// top.getUnits().add(unit1);
//		
// Unit unit2 = CoreFactory.eINSTANCE.createUnit();
// unit2.setName("unit2");
// top.getUnits().add(unit2);
//		
// // Match two units, the source with member AND non-member requirement
// LinkDescriptor[] d;
// d = matcher.getPossibleLinks(unit1, unit2, LinkType.MEMBER_SET);
// assert d.length == 1;
// }

	public void testMemberLinkMatching() throws IOException {
		LinkDescriptor[] d;

		// Null input doesn't trigger NPE, it returns no possible links
		d = matcher.getPossibleLinks(null, null, LinkType.MEMBER_SET);
		assert d.length == 0 : printLinkDescriptors(d);

		assert !matcher.canBeLinkSource(null, LinkType.MEMBER_SET).isOK();
		assert !matcher.canBeLinkEndpoint(null, LinkType.MEMBER_SET).isOK();

		Topology top = createTopology("testMemberLinkMatching");

		Unit unit1 = CoreFactory.eINSTANCE.createUnit();
		unit1.setName("unit1");
		top.getUnits().add(unit1);
		assert !matcher.canBeLinkSource(unit1, LinkType.MEMBER_SET).isOK();
		d = matcher.getPossibleLinks(null, unit1, LinkType.MEMBER_SET);
		assert d.length == 0 : printLinkDescriptors(d);
		d = matcher.getPossibleLinks(unit1, null, LinkType.MEMBER_SET);
		assert d.length == 0 : printLinkDescriptors(d);

		Unit unit2 = CoreFactory.eINSTANCE.createUnit();
		unit2.setName("unit2");
		top.getUnits().add(unit2);

		// Match two units, neither with capabilities
		d = matcher.getPossibleLinks(unit1, unit2, LinkType.MEMBER_SET);
		assert d.length == 0 : printLinkDescriptors(d);

		Capability pCap2 = CoreFactory.eINSTANCE.createCapability();
		pCap2.setName("pCap2");
		unit2.getCapabilities().add(pCap2);

		// Match two units, the target with capabilities
		d = matcher.getPossibleLinks(unit1, unit2, LinkType.MEMBER_SET);
		assert d.length == 0 : printLinkDescriptors(d);

		Requirement cReq1 = CoreFactory.eINSTANCE.createRequirement();
		cReq1.setName("cReq1");
		cReq1.setDmoEType(CorePackage.Literals.CAPABILITY);
		unit1.getOnlyDependencyRequirements().add(cReq1);

		// Match two units, the source with non-member requirement
		d = matcher.getPossibleLinks(unit1, unit2, LinkType.MEMBER_SET);
		assert d.length == 0 : printLinkDescriptors(d);

		Requirement cReqMember = CoreFactory.eINSTANCE.createRequirement();
		cReqMember.setName("cReqMember");
// cReqMember.setDmoEType(CorePackage.Literals.CAPABILITY);
		cReqMember.setDmoEType(CorePackage.Literals.UNIT);
		cReqMember.setLinkType(RequirementLinkTypes.MEMBER_LITERAL);
		unit1.getRequirements().add(cReqMember);

// System.out.println("unit2 has " + unit2.getCapabilities().size() + "
// capabilities");

		// Match two units, the source with member AND non-member requirement
		d = matcher.getPossibleLinks(unit1, unit2, LinkType.MEMBER_SET);
		assert d.length == 1 : printLinkDescriptors(d);

		unit1.getRequirements().remove(cReq1);

// for (Iterator it = unit1.getRequirements().iterator(); it.hasNext(); ) {
// Requirement req = (Requirement) it.next();
// System.out.println(req.getLinkType());
// }

		// Match two units, the source with only member requirement
		d = matcher.getPossibleLinks(unit1, unit2, LinkType.MEMBER_SET);
		assert d.length == 1 : printLinkDescriptors(d);

		// Can the descriptions actually be realized?
		assert unit1.getUnitLinks().size() == 0;
		d[0].create();
		assert unit1.getUnitLinks().size() == 1;
	}

	public void testDependencyLinkMatchingRequirements() throws IOException {
		Topology top = createTopology("testDependencyLinkMatchingReq");

		// test from source requirement on source unit ...
		Unit unit1 = CoreFactory.eINSTANCE.createUnit();
		unit1.setName("unit1");
		top.getUnits().add(unit1);

		// test from source requirement on source unit to target capability on
		// target unit
		Requirement cReq1 = CoreFactory.eINSTANCE.createRequirement();
		cReq1.setName("cReq1");
		cReq1.setDmoEType(CorePackage.Literals.CAPABILITY);
		unit1.getOnlyDependencyRequirements().add(cReq1);

		System.out.println("============== case 1 ===============");
		toVariousEndpoints(unit1);

// // test from source requirement on a configuration unit hosted on source unit
// unit1.getOnlyDependencyRequirements().remove(cReq1);
//		
// Unit cUnit1_1 = createConfigurationUnit();
// cUnit1_1.setName("cUnit1_1");
// top.getUnits().add(cUnit1_1);
//
// LinkDescriptor hLinkD = new LinkDescriptor(LinkType.HOSTING,
// unit1, cUnit1_1);
// DeployModelObject hLink = hLinkD.create();
//
// Requirement cReq1_1 = CoreFactory.eINSTANCE.createRequirement();
// cReq1_1.setName("cReq1_1");
// cUnit1_1.getOnlyDependencyRequirements().add(cReq1_1);
// cReq1_1.setDmoEType(CorePackage.Literals.CAPABILITY);
//
// System.out.println("============== case 2 ===============");
// toVariousEndpoints (unit1);
//
// // test from source requirement on a member unit of the source unit
// unit1.getHostingLinks().remove(hLink);
//		
// Unit mUnit1_1 = CoreFactory.eINSTANCE.createUnit();
// mUnit1_1.setName("mUnit1_1");
// top.getUnits().add(mUnit1_1);
//		
// LinkDescriptor gLinkD = new LinkDescriptor(LinkType.MEMBER,
// unit1, mUnit1_1);
// gLinkD.create();
//		
// mUnit1_1.getOnlyDependencyRequirements().add(cReq1);
//		
// System.out.println("============== case 3 ===============");
// toVariousEndpoints(unit1);
//		
// // test from source requirement on a configuration unit hosted on a
// // member unit of the source unit
// mUnit1_1.getOnlyDependencyRequirements().remove(cReq1);
//
// hLinkD = new LinkDescriptor(LinkType.HOSTING,
// mUnit1_1, cUnit1_1);
// hLink = hLinkD.create();
//		
// System.out.println("============== case 4 ===============");
// toVariousEndpoints (unit1);
	}

	public void testHostingLinkMatching() throws IOException {
		Topology top = createTopology("testHostingLinkMatching");

		// test from source requirement on source unit ...
		Unit unit1 = CoreFactory.eINSTANCE.createUnit();
		unit1.setName("unit1");
		top.getUnits().add(unit1);

		// test from source requirement on source unit to target capability on
		// target unit
		Requirement cReq1 = CoreFactory.eINSTANCE.createRequirement();
		cReq1.setName("cReq1");
		cReq1.setDmoEType(CorePackage.Literals.CAPABILITY);
		unit1.getHostingOrAnyRequirements().add(cReq1);

		System.out.println("============== case 1 ===============");
		toVariousEndpointsHosting(unit1);

// // test from source requirement on a configuration unit hosted on source unit
// unit1.getHostingOrAnyRequirements().remove(cReq1);
//		
// Unit cUnit1_1 = createConfigurationUnit();
// cUnit1_1.setName("cUnit1_1");
// top.getUnits().add(cUnit1_1);
//
// LinkDescriptor hLinkD = new LinkDescriptor(LinkType.HOSTING,
// unit1, cUnit1_1);
// DeployModelObject hLink = hLinkD.create();
//
// Requirement cReq1_1 = CoreFactory.eINSTANCE.createRequirement();
// cReq1_1.setName("cReq1_1");
// cReq1_1.setDmoEType(CorePackage.Literals.CAPABILITY);
// cUnit1_1.getHostingOrAnyRequirements().add(cReq1_1);
//
// // System.out.println("============== case 2 ===============");
// // toVariousEndpointsHosting (unit1);
//
// // test from source requirement on a member unit of the source unit
// unit1.getHostingLinks().remove(hLink);
//		
// Unit mUnit1_1 = CoreFactory.eINSTANCE.createUnit();
// mUnit1_1.setName("mUnit1_1");
// top.getUnits().add(mUnit1_1);
//		
// LinkDescriptor gLinkD = new LinkDescriptor(LinkType.MEMBER,
// unit1, mUnit1_1);
// gLinkD.create();
//		
// mUnit1_1.getHostingOrAnyRequirements().add(cReq1);
//		
// System.out.println("============== case 3 ===============");
// toVariousEndpointsHosting(unit1);
//		
// // test from source requirement on a configuration unit hosted on a
// // member unit of the source unit
// mUnit1_1.getHostingOrAnyRequirements().remove(cReq1);
//
// hLinkD = new LinkDescriptor(LinkType.HOSTING,
// mUnit1_1, cUnit1_1);
// hLink = hLinkD.create();
//		
// // System.out.println("============== case 4 ===============");
// // toVariousEndpointsHosting (unit1);
	}

	public void toVariousEndpoints(Unit unit1) throws IOException {
		LinkDescriptor[] d;

		Topology top = unit1.getTopology();

		Unit unit2 = CoreFactory.eINSTANCE.createUnit();
		unit2.setName("unit2");
		top.getUnits().add(unit2);

		// Should be impossible to make a link to a unit with no Capabilities
		d = matcher.getPossibleLinks(unit1, unit2, LinkType.ALL_LINK_TYPES);
// System.out.println(printLinkDescriptors(d));
		assert d.length == 0;

		// ... to target capability on target unit
		Capability pCap2 = CoreFactory.eINSTANCE.createCapability();
		pCap2.setName("pCap2");
		unit2.getOnlyDependencyCapabilities().add(pCap2);

		d = matcher.getPossibleLinks(unit1, unit2, LinkType.ALL_LINK_TYPES);
// System.out.println(printLinkDescriptors(d));
//		assert d.length == 1 : printLinkDescriptors(d);
		assert d.length == 2 : printLinkDescriptors(d);

		Unit cUnit2_1 = createConfigurationUnit();
		cUnit2_1.setName("cUnit2_1");
		top.getUnits().add(cUnit2_1);

		// ... to target capability on configurtion unit hosted on the target
		// unit
		LinkDescriptor hLink = new LinkDescriptor(LinkType.HOSTING, unit2,
				cUnit2_1);
		hLink.create();

		Capability pCap2_1 = CoreFactory.eINSTANCE.createCapability();
		pCap2_1.setName("pCap2_1");
		cUnit2_1.getOnlyDependencyCapabilities().add(pCap2_1);

		d = matcher.getPossibleLinks(unit1, unit2, LinkType.ALL_LINK_TYPES);
// System.out.println(printLinkDescriptors(d));
// assert d.length == 2;
//		assert d.length == 1 : printLinkDescriptors(d);
		assert d.length == 2 : printLinkDescriptors(d);

		d = matcher.getPossibleLinks(unit1, cUnit2_1, LinkType.ALL_LINK_TYPES);
// System.out.println(printLinkDescriptors(d));
//		assert d.length == 1 : printLinkDescriptors(d);
		assert d.length == 2 : printLinkDescriptors(d);

		// ... to a target capability on member unit of the target unit

		Unit mUnit2_2 = CoreFactory.eINSTANCE.createUnit();
		mUnit2_2.setName("mUnit2_2");
		top.getUnits().add(mUnit2_2);

		LinkDescriptor gLink = new LinkDescriptor(LinkType.MEMBER, unit2,
				mUnit2_2);
		gLink.create();

		Capability pCap2_2 = CoreFactory.eINSTANCE.createCapability();
		pCap2_2.setName("pCap2_2");
		mUnit2_2.getOnlyDependencyCapabilities().add(pCap2_2);

		d = matcher.getPossibleLinks(unit1, unit2, LinkType.ALL_LINK_TYPES);
// assert d.length == 3;
//		assert d.length == 1 : printLinkDescriptors(d);
		assert d.length == 2 : printLinkDescriptors(d);

		d = matcher.getPossibleLinks(unit1, mUnit2_2, LinkType.ALL_LINK_TYPES);
// System.out.println(printLinkDescriptors(d));
//		assert d.length == 1 : printLinkDescriptors(d);
		assert d.length == 2 : printLinkDescriptors(d);

		// ... to a target capabiliby on a configuraiton unit hosted on a member
		// unit of the target unit

		Unit cUnit2_2_1 = createConfigurationUnit();
		cUnit2_2_1.setName("cUnit2_2_1");
		top.getUnits().add(cUnit2_2_1);

		Capability pCap2_2_1 = CoreFactory.eINSTANCE.createCapability();
		pCap2_2_1.setName("pCap2_2_1");
		cUnit2_2_1.getOnlyDependencyCapabilities().add(pCap2_2_1);

		hLink = new LinkDescriptor(LinkType.HOSTING, mUnit2_2, cUnit2_2_1);
		hLink.create();

		d = matcher.getPossibleLinks(unit1, unit2, LinkType.ALL_LINK_TYPES);
// System.out.println(printLinkDescriptors(d));
// assert d.length == 4;
//		assert d.length == 1 : printLinkDescriptors(d);
		assert d.length == 2 : printLinkDescriptors(d);

		d = matcher.getPossibleLinks(unit1, mUnit2_2, LinkType.ALL_LINK_TYPES);
// System.out.println(printLinkDescriptors(d));
// assert d.length == 2;
//		assert d.length == 1 : printLinkDescriptors(d);
		assert d.length == 2 : printLinkDescriptors(d);

		d = matcher
				.getPossibleLinks(unit1, cUnit2_2_1, LinkType.ALL_LINK_TYPES);
// System.out.println(printLinkDescriptors(d));
//		assert d.length == 1 : printLinkDescriptors(d);
		assert d.length == 2 : printLinkDescriptors(d);
	}

	public void toVariousEndpointsHosting(Unit unit1) throws IOException {
		LinkDescriptor[] d;

		Topology top = unit1.getTopology();

		Unit unit2 = CoreFactory.eINSTANCE.createUnit();
		unit2.setName("unit2");
		top.getUnits().add(unit2);

		d = matcher.getPossibleLinks(unit2, unit1, LinkType.ALL_LINK_TYPES);
// System.out.println(printLinkDescriptors(d));
		assert d.length == 0 : printLinkDescriptors(d);

		// ... to target capability on target unit
		Capability pCap2 = CoreFactory.eINSTANCE.createCapability();
		pCap2.setName("pCap2");
		unit2.getHostingOrAnyCapabilities().add(pCap2);

		d = matcher.getPossibleLinks(unit2, unit1, LinkType.ALL_LINK_TYPES);
// System.out.println(printLinkDescriptors(d));
//		assert d.length == 1 : printLinkDescriptors(d);
		assert d.length == 2 : printLinkDescriptors(d);

		// test impact of initial install state (for testing purposes, unknown
		// and non-installed are equivalent
		// previous test was:
		// unit1.initInstallState == unknown, unit2.initInstallState == unknown
		// now test:
		// unit1.initInstallState == installed, unit2.initInstallState ==
		// unknown
		unit1.setInitInstallState(InstallState.INSTALLED_LITERAL);
		d = matcher.getPossibleLinks(unit2, unit1, LinkType.ALL_LINK_TYPES);
		// MK 6/18/2007 Defect 1876; do not consider init install state in decisions
		// assert d.length == 0 : printLinkDescriptors(d);
//		assert d.length == 1 : printLinkDescriptors(d);
		assert d.length == 2 : printLinkDescriptors(d);
		// unit1.initInstallState == installed, unit2.initInstallState ==
		// installed
		unit2.setInitInstallState(InstallState.INSTALLED_LITERAL);
		d = matcher.getPossibleLinks(unit2, unit1, LinkType.ALL_LINK_TYPES);
		// MK 6/18/2007 Defect 1876; do not consider init install state in decisions
		// assert d.length == 0 : printLinkDescriptors(d);
//		assert d.length == 1 : printLinkDescriptors(d);
		assert d.length == 2 : printLinkDescriptors(d);
		// unit1.initInstallState == unknown, unit2.initInstallState ==
		// installed
		unit1.setInitInstallState(InstallState.UNKNOWN_LITERAL);
		d = matcher.getPossibleLinks(unit2, unit1, LinkType.ALL_LINK_TYPES);
//		assert d.length == 1 : printLinkDescriptors(d);
		assert d.length == 2 : printLinkDescriptors(d);

		Unit cUnit2_1 = createConfigurationUnit();
		cUnit2_1.setName("cUnit2_1");
		top.getUnits().add(cUnit2_1);

		// ... to target capability on configurtion unit hosted on the target
		// unit
		LinkDescriptor hLink = new LinkDescriptor(LinkType.HOSTING, unit2,
				cUnit2_1);
		hLink.create();

		Capability pCap2_1 = CoreFactory.eINSTANCE.createCapability();
		pCap2_1.setName("pCap2_1");
		cUnit2_1.getHostingOrAnyCapabilities().add(pCap2_1);

		d = matcher.getPossibleLinks(unit2, unit1, LinkType.ALL_LINK_TYPES);
// System.out.println(printLinkDescriptors(d));
// assert d.length == 2;
//		assert d.length == 1 : printLinkDescriptors(d);
		assert d.length == 2 : printLinkDescriptors(d);

		d = matcher.getPossibleLinks(cUnit2_1, unit1, LinkType.ALL_LINK_TYPES);
// System.out.println(printLinkDescriptors(d));
//		assert d.length == 1 : printLinkDescriptors(d);
		assert d.length == 2 : printLinkDescriptors(d);

		// ... to a target capability on member unit of the target unit

		Unit mUnit2_2 = CoreFactory.eINSTANCE.createUnit();
		mUnit2_2.setName("mUnit2_2");
		top.getUnits().add(mUnit2_2);

		LinkDescriptor gLink = new LinkDescriptor(LinkType.MEMBER, unit2,
				mUnit2_2);
		gLink.create();

		Capability pCap2_2 = CoreFactory.eINSTANCE.createCapability();
		pCap2_2.setName("pCap2_2");
		mUnit2_2.getHostingOrAnyCapabilities().add(pCap2_2);

		d = matcher.getPossibleLinks(unit2, unit1, LinkType.ALL_LINK_TYPES);
// assert d.length == 3;
//		assert d.length == 1 : printLinkDescriptors(d);
		assert d.length == 2 : printLinkDescriptors(d);

		d = matcher.getPossibleLinks(mUnit2_2, unit1, LinkType.ALL_LINK_TYPES);
// System.out.println(printLinkDescriptors(d));
//		assert d.length == 1 : printLinkDescriptors(d);
		assert d.length == 2 : printLinkDescriptors(d);

		// ... to a target capabiliby on a configuraiton unit hosted on a member
		// unit of the target unit

		Unit cUnit2_2_1 = createConfigurationUnit();
		cUnit2_2_1.setName("cUnit2_2_1");
		top.getUnits().add(cUnit2_2_1);

		Capability pCap2_2_1 = CoreFactory.eINSTANCE.createCapability();
		pCap2_2_1.setName("pCap2_2_1");
		cUnit2_2_1.getHostingOrAnyCapabilities().add(pCap2_2_1);

		hLink = new LinkDescriptor(LinkType.HOSTING, mUnit2_2, cUnit2_2_1);
		hLink.create();

		d = matcher.getPossibleLinks(unit2, unit1, LinkType.ALL_LINK_TYPES);
// System.out.println(printLinkDescriptors(d));
// assert d.length == 4;
//		assert d.length == 1 : printLinkDescriptors(d);
		assert d.length == 2 : printLinkDescriptors(d);

		d = matcher.getPossibleLinks(mUnit2_2, unit1, LinkType.ALL_LINK_TYPES);
// System.out.println(printLinkDescriptors(d));
// assert d.length == 2;
//		assert d.length == 1 : printLinkDescriptors(d);
		assert d.length == 2 : printLinkDescriptors(d);

		d = matcher
				.getPossibleLinks(cUnit2_2_1, unit1, LinkType.ALL_LINK_TYPES);
		// d = matcher.getPossibleLinks(unit1, cUnit2_2_1);
// System.out.println(printLinkDescriptors(d));
//		assert d.length == 1 : printLinkDescriptors(d);
		assert d.length == 2 : printLinkDescriptors(d);
	}

	/**
	 * Tests matching for dependency links, for conceptual units, taking into
	 * account new relaxed dependency link matching rules.
	 * 
	 * @throws Exception
	 */
	public void testDependencyLinkMatchingConceptualUnits() throws Exception {
		Topology top = createTopology("testValidateRequirement", true);
		LinkDescriptor[] d = null;

		// ---- test 1 ------
		Unit unit1 = addUnit(top, "unit1");
		Requirement req_unit1 = addRequirement(unit1, "req_unit1",
				CorePackage.eINSTANCE.getCommunicationCapability(),
				RequirementLinkTypes.DEPENDENCY_LITERAL);
		RequirementExpression expr1 = CoreFactory.eINSTANCE
				.createRequirementExpression();
		expr1.setName("re0");
		expr1.setUse(RequirementExpressionUsage.REQUIRED_LITERAL);
		expr1.setInterpreter(Equals.INTERPRETER_ID);
		expr1.setAttributeName("port");
		expr1.setValue("100");
		req_unit1.getExpressions().add(expr1);

		Unit unit2 = addUnit(top, "unit2");
		Capability cap1_unit2 = addCapability(unit2, "cap1_unit2",
				CorePackage.eINSTANCE.getBundleCapability(),
				CapabilityLinkTypes.DEPENDENCY_LITERAL);

		d = matcher.getPossibleLinks(unit1, unit2, LinkType.DEPENDENCY_SET);
		assert d.length == 0 : printLinkDescriptors(d);

		// ---- test 2 ------
		unit2.setConceptual(true);
		d = matcher.getPossibleLinks(unit1, unit2, LinkType.DEPENDENCY_SET);
		assert d.length == 0 : printLinkDescriptors(d);

		// ---- test 3 ------
		unit2.setConceptual(false);
		unit2.getCapabilities().clear(); // remove old capability
		cap1_unit2 = addCapability(unit2, "cap1_unit2", CorePackage.eINSTANCE
				.getCapability(), CapabilityLinkTypes.DEPENDENCY_LITERAL);
		d = matcher.getPossibleLinks(unit1, unit2, LinkType.DEPENDENCY_SET);
		assert d.length == 0 : printLinkDescriptors(d);

		// ---- test 4 ------
		unit2.setConceptual(true);
		d = matcher.getPossibleLinks(unit1, unit2, LinkType.DEPENDENCY_SET);
//		assert d.length == 1 : printLinkDescriptors(d);
		assert d.length == 2 : printLinkDescriptors(d);

		// ---- test 5 ------
		unit2.setConceptual(false);
		unit2.getCapabilities().clear(); // remove old capability
		CommunicationCapability cap2_unit2 = (CommunicationCapability) addCapability(
				unit2, "cap2_unit2", CorePackage.eINSTANCE
						.getCommunicationCapability(),
				CapabilityLinkTypes.DEPENDENCY_LITERAL);
		cap2_unit2.setPort(new BigInteger("80"));
		d = matcher.getPossibleLinks(unit1, unit2, LinkType.DEPENDENCY_SET);
//		assert d.length == 1 : printLinkDescriptors(d);
		assert d.length == 2 : printLinkDescriptors(d);

		// ---- test 6 ------
		unit2.setConceptual(true);
		d = matcher.getPossibleLinks(unit1, unit2, LinkType.DEPENDENCY_SET);
//		assert d.length == 1 : printLinkDescriptors(d);
		assert d.length == 2 : printLinkDescriptors(d);

		// ---- test 7 ------
		cap2_unit2.setPort(new BigInteger("100"));
		d = matcher.getPossibleLinks(unit1, unit2, LinkType.DEPENDENCY_SET);
//		assert d.length == 1 : printLinkDescriptors(d);
		assert d.length == 2 : printLinkDescriptors(d);

		// ---- test 8 ------
		unit2.setConceptual(true);
		d = matcher.getPossibleLinks(unit1, unit2, LinkType.DEPENDENCY_SET);
//		assert d.length == 1 : printLinkDescriptors(d);
		assert d.length == 2 : printLinkDescriptors(d);
	}

	/**
	 * Tests matching for hosting links, for conceptual units, taking into
	 * account new relaxed hosting link matching rules.
	 * 
	 * @throws Exception
	 */
	public void testHostingLinkMatchingConceptualUnits() throws Exception {
		Topology top = createTopology("testValidateRequirement", true);
		LinkDescriptor[] d = null;

		// ---- test 1 ------
		// create unit unit1
		Unit unit1 = addUnit(top, "unit1");
		Requirement req_unit1 = addRequirement(unit1, "req_unit1",
				CorePackage.eINSTANCE.getCommunicationCapability(),
				RequirementLinkTypes.HOSTING_LITERAL);

		// create unit unit2
		Unit unit2 = addUnit(top, "unit2");
		Capability cap1_unit2 = addCapability(unit2, "cap_unit2",
				CorePackage.eINSTANCE.getBundleCapability(),
				CapabilityLinkTypes.HOSTING_LITERAL);

		d = matcher.getPossibleLinks(unit2, unit1, LinkType.HOSTING_SET);
		assert d.length == 0 : printLinkDescriptors(d);

		// ---- test 2 ------
		unit2.setConceptual(true);
		d = matcher.getPossibleLinks(unit2, unit1, LinkType.HOSTING_SET);
		assert d.length == 0 : printLinkDescriptors(d);

		// ---- test 3 ------
		unit2.setConceptual(false);
		unit2.getCapabilities().clear(); // get rid of BundleCapability
		cap1_unit2 = addCapability(unit2, "cap1_unit2", CorePackage.eINSTANCE
				.getCapability(), CapabilityLinkTypes.HOSTING_LITERAL);
		d = matcher.getPossibleLinks(unit2, unit1, LinkType.HOSTING_SET);
		assert d.length == 0 : printLinkDescriptors(d);

		// ---- test 4 ------
		unit2.setConceptual(true);
		d = matcher.getPossibleLinks(unit2, unit1, LinkType.HOSTING_SET);
//		assert d.length == 1 : printLinkDescriptors(d);
		assert d.length == 2 : printLinkDescriptors(d);

		// ---- test 5 ------
		unit2.setConceptual(false);
		unit2.getCapabilities().clear(); // get rid of Capability
		CommunicationCapability cap2_unit2 = (CommunicationCapability) addCapability(
				unit2, "cap2_unit2", CorePackage.eINSTANCE
						.getCommunicationCapability(),
				CapabilityLinkTypes.HOSTING_LITERAL);
		cap2_unit2.setPort(new BigInteger("80"));
		d = matcher.getPossibleLinks(unit2, unit1, LinkType.HOSTING_SET);
//		assert d.length == 1 : printLinkDescriptors(d);
		assert d.length == 2 : printLinkDescriptors(d);

		// ---- test 6 ------
		unit2.setConceptual(true);
		d = matcher.getPossibleLinks(unit2, unit1, LinkType.HOSTING_SET);
//		assert d.length == 1 : printLinkDescriptors(d);
		assert d.length == 2 : printLinkDescriptors(d);

		// ---- test 7 ------
		unit2.setConceptual(false);
		RequirementExpression expr = CoreFactory.eINSTANCE
				.createRequirementExpression();
		expr.setName("re0");
		expr.setUse(RequirementExpressionUsage.REQUIRED_LITERAL);
		expr.setInterpreter(Equals.INTERPRETER_ID);
		expr.setAttributeName("port");
		expr.setValue("100");
		req_unit1.getExpressions().add(expr);

		d = matcher.getPossibleLinks(unit2, unit1, LinkType.HOSTING_SET);
//		assert d.length == 1 : printLinkDescriptors(d);
		assert d.length == 2 : printLinkDescriptors(d);

		// ---- test 8 ------
		unit2.setConceptual(true);
		d = matcher.getPossibleLinks(unit2, unit1, LinkType.HOSTING_SET);
//		assert d.length == 1 : printLinkDescriptors(d);
		assert d.length == 2 : printLinkDescriptors(d);

		// ---- test 9 ------
		expr.setValue("80");
		unit2.setConceptual(false);
		d = matcher.getPossibleLinks(unit2, unit1, LinkType.HOSTING_SET);
//		assert d.length == 1 : printLinkDescriptors(d);
		assert d.length == 2 : printLinkDescriptors(d);

		// ---- test 10 ------
		unit2.setConceptual(true);
		d = matcher.getPossibleLinks(unit2, unit1, LinkType.HOSTING_SET);
//		assert d.length == 1 : printLinkDescriptors(d);
		assert d.length == 2 : printLinkDescriptors(d);
	}

	private static String printLinkDescriptors(LinkDescriptor[] descriptors) {
		String str = "Link Descriptors\n----------------";
		for (int i = 0; i < descriptors.length; i++) {
			str += "\n   " + printLinkDescriptor(descriptors[i]);
		}
		return str;
	}

	private static Unit createConfigurationUnit() {
		Unit unit = CoreFactory.eINSTANCE.createUnit();
		unit.setConfigurationUnit(true);
		return unit;
	}

	private static String printLinkDescriptor(LinkDescriptor d) {
		String str;
		if (d.getType().equals(LinkType.DEPENDENCY)) {
			str = "Dependency link: " + d.getSourceUnit().getName() + "."
					+ d.getSource().getName() + "->"
					+ d.getTargetUnit().getName() + "."
					+ d.getTarget().getName();
		} else if (d.getType().equals(LinkType.HOSTING)) {
			str = "Hosting link: " + d.getSourceUnit().getName() + "->"
					+ d.getTargetUnit().getName();
		} else if (d.getType().equals(LinkType.CONSTRAINT)) {
			str = "Logical link: " + d.getSourceUnit().getName();
			if (null != d.getSource())
				str += "." + d.getSource().getName();
			str += "->" + d.getTargetUnit().getName();
			if (null != d.getTarget())
				str += "." + d.getTarget().getName();
		} else if (d.getType().equals(LinkType.MEMBER)) {
			str = "Member link: " + d.getSourceUnit().getName() + "->"
					+ d.getTargetUnit().getName();
		} else {
			str = "Unknown link type";
		}
		return str;
	}

}
