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
import java.util.Iterator;

import org.eclipse.emf.ecore.EClass;

import com.ibm.ccl.soa.deploy.core.Capability;
import com.ibm.ccl.soa.deploy.core.CoreFactory;
import com.ibm.ccl.soa.deploy.core.CorePackage;
import com.ibm.ccl.soa.deploy.core.Requirement;
import com.ibm.ccl.soa.deploy.core.RequirementExpression;
import com.ibm.ccl.soa.deploy.core.RequirementLinkTypes;
import com.ibm.ccl.soa.deploy.core.Topology;
import com.ibm.ccl.soa.deploy.core.Unit;
import com.ibm.ccl.soa.deploy.core.test.TopologyTestCase;
import com.ibm.ccl.soa.deploy.core.util.UnitUtil;
import com.ibm.ccl.soa.deploy.core.validator.DeployValidatorService;
import com.ibm.ccl.soa.deploy.core.validator.expression.InCardinality;
import com.ibm.ccl.soa.deploy.core.validator.expression.OutCardinality;
import com.ibm.ccl.soa.deploy.core.validator.matcher.CoreDomainMatcher;
import com.ibm.ccl.soa.deploy.core.validator.matcher.LinkDescriptor;
import com.ibm.ccl.soa.deploy.core.validator.matcher.LinkType;

/**
 * @author Michael Kalantar
 */
public class InternalMatcherTest extends TopologyTestCase {

	private static final String PROJECT_NAME = "InternalMatcherTest";

	/** Shared validator instance. */
	private CoreDomainMatcher matcher;

	public InternalMatcherTest() {
		super(PROJECT_NAME);
	}

	public InternalMatcherTest(String name) {
		super(name);
	}

	/*
	 * @see junit.framework.TestCase#setUp()
	 */
	protected void setUp() throws Exception {
		super.setUp();
		matcher = new CoreDomainMatcher();
	}

	public void testMemberLinkMatching() throws IOException {
		LinkDescriptor[] d;

		// Null input doesn't trigger NPE, it returns no possible links
		d = matcher.getPossibleLinks(null, null, LinkType.MEMBER_SET);
		assert d.length == 0;

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

		// Match two units, neither with requirements
		d = matcher.getPossibleLinks(unit1, unit2, LinkType.MEMBER_SET);
		assert d.length == 0 : printLinkDescriptors(d);

		Capability pCap2 = CoreFactory.eINSTANCE.createCapability();
		pCap2.setName("pCap2");
		unit2.getCapabilities().add(pCap2);

		// Match two units, the target with capabilities (but no requirements)
		d = matcher.getPossibleLinks(unit1, unit2, LinkType.MEMBER_SET);
		assert d.length == 0 : printLinkDescriptors(d);

		addMultiplicityOutboundConstraint(unit1, CorePackage.Literals.UNIT, 0,
				-1);

		// Match two units, the source with member requirements
		d = matcher.getPossibleLinks(unit1, unit2, LinkType.MEMBER_SET);
		assert d.length == 1 : printLinkDescriptors(d);

		// System.out.println("============== member case 1 ===============");
		toVariousEndpointsMember(unit1);

// // Can the descriptions actually be realized?
// assert unit1.getUnitLinks().size() == 0;
// d[0].create();
// assert unit1.getUnitLinks().size() == 1;
	}

	public void toVariousEndpointsMember(Unit unit1) throws IOException {
		LinkDescriptor[] d;
		LinkType[] linkTypesToCreate = LinkType.MEMBER_SET;

		Topology top = unit1.getTopology();

		Unit unit2 = createUnit(top, false, false, "");

		// A unit without any InCardinality requirements can be in a group
		d = matcher.getPossibleLinks(unit1, unit2, linkTypesToCreate);
		assert d.length == 1 : printLinkDescriptors(d);

		addMultiplicityInboundConstraint(unit2, CorePackage.Literals.UNIT, 0,
				-1);

		// with InCardinality can still be in group
		d = matcher.getPossibleLinks(unit1, unit2, linkTypesToCreate);
		assert d.length == 1 : printLinkDescriptors(d);

		Unit cUnit2_1 = createHostedConfigurationUnit(unit2, "");

		// for member links only expect unit1 to be linked
		d = matcher.getPossibleLinks(unit1, unit2, linkTypesToCreate);
// assert d.length == 2 : printLinkDescriptors(d);
		assert d.length == 1 : printLinkDescriptors(d);

		d = matcher.getPossibleLinks(unit1, cUnit2_1, linkTypesToCreate);
		assert d.length == 1 : printLinkDescriptors(d);

		// ... to a target capability on member unit of the target unit

		// add member mUnit2_2 to group unit2
		Unit mUnit2_2 = createUnit(top, DEPENDENCY);

		LinkDescriptor gLink = new LinkDescriptor(LinkType.MEMBER, unit2,
				mUnit2_2);
		gLink.create();

		d = matcher.getPossibleLinks(unit1, unit2, linkTypesToCreate);
// assert d.length == 3 : printLinkDescriptors(d);
		assert d.length == 1 : printLinkDescriptors(d);

		d = matcher.getPossibleLinks(unit1, mUnit2_2, linkTypesToCreate);
		assert d.length == 1 : printLinkDescriptors(d);

		// ... to a target capabiliby on a configuraiton unit hosted on a member
		// unit of the target unit

		Unit cUnit2_2_1 = createHostedConfigurationUnit(mUnit2_2, "");

		d = matcher.getPossibleLinks(unit1, unit2, linkTypesToCreate);
// assert d.length == 4 : printLinkDescriptors(d);
		assert d.length == 1 : printLinkDescriptors(d);

		d = matcher.getPossibleLinks(unit1, mUnit2_2, linkTypesToCreate);
// assert d.length == 2 : printLinkDescriptors(d);
		assert d.length == 1 : printLinkDescriptors(d);

		d = matcher.getPossibleLinks(unit1, cUnit2_2_1, linkTypesToCreate);
		assert d.length == 1 : printLinkDescriptors(d);
	}

	public void testDependencyLinkMatchingRequirements() throws IOException {
		Topology top = createTopology("testDependencyLinkMatchingReq");

		// test from source requirement on source unit ...
		Unit unit1 = createUnit(top, false, false, "");

		// test from source requirement on source unit to target capability on
		// target unit
		Requirement cReq1 = CoreFactory.eINSTANCE.createRequirement();
		cReq1.setName("cReq1");
		cReq1.setDmoEType(CorePackage.Literals.CAPABILITY);
		unit1.getOnlyDependencyRequirements().add(cReq1);

		toVariousEndpointsDependency(unit1);
	}

	public void toVariousEndpointsDependency(Unit unit1) throws IOException {
		LinkDescriptor[] d;
		LinkType[] linkTypesToCreate = LinkType.DEPENDENCY_SET;

		Topology top = unit1.getTopology();

		Unit unit2 = createUnit(top, false, false, "");

		// no links since target has no capability
		d = matcher.getPossibleLinks(unit1, unit2, linkTypesToCreate,
				DeployValidatorService.MATCHER_DEPTH_ALL);
		assert d.length == 0 : printLinkDescriptors(d);

		addDependencyCapability(unit2);

		// now match with capability added to target unit2
		d = matcher.getPossibleLinks(unit1, unit2, linkTypesToCreate,
				DeployValidatorService.MATCHER_DEPTH_ALL);
//		assert d.length == 1 : printLinkDescriptors(d);
		assert d.length == 2 : printLinkDescriptors(d);

		// add hosted configuration unit to target
		Unit cUnit2_1 = createHostedConfigurationUnit(unit2, DEPENDENCY);

		// 2 matches: target and its hosted config unit
		d = matcher.getPossibleLinks(unit1, unit2, linkTypesToCreate,
				DeployValidatorService.MATCHER_DEPTH_ALL);
//		assert d.length == 2 : printLinkDescriptors(d);
		assert d.length == 4 : printLinkDescriptors(d);
		d = matcher.getPossibleLinks(unit1, unit2, linkTypesToCreate,
				DeployValidatorService.MATCHER_DEPTH_NONE);
//		assert d.length == 1 : printLinkDescriptors(d);
		assert d.length == 2 : printLinkDescriptors(d);

		d = matcher.getPossibleLinks(unit1, cUnit2_1, linkTypesToCreate,
				DeployValidatorService.MATCHER_DEPTH_ALL);
//		assert d.length == 1 : printLinkDescriptors(d);
		assert d.length == 2 : printLinkDescriptors(d);

		// add memeber unit to target
		Unit mUnit2_2 = createUnit(top, DEPENDENCY);
		(new LinkDescriptor(LinkType.MEMBER, unit2, mUnit2_2)).create();

		// 3 matches: target, its hosted config unit, its member unit
		d = matcher.getPossibleLinks(unit1, unit2, linkTypesToCreate,
				DeployValidatorService.MATCHER_DEPTH_ALL);
//		assert d.length == 3 : printLinkDescriptors(d);
		assert d.length == 6 : printLinkDescriptors(d);
		d = matcher.getPossibleLinks(unit1, unit2, linkTypesToCreate,
				DeployValidatorService.MATCHER_DEPTH_NONE);
//		assert d.length == 1 : printLinkDescriptors(d);
		assert d.length == 2 : printLinkDescriptors(d);

		d = matcher.getPossibleLinks(unit1, mUnit2_2, linkTypesToCreate,
				DeployValidatorService.MATCHER_DEPTH_ALL);
//		assert d.length == 1 : printLinkDescriptors(d);
		assert d.length == 2 : printLinkDescriptors(d);

		// host configuration unit on member unit
		Unit cUnit2_2_1 = createHostedConfigurationUnit(mUnit2_2, DEPENDENCY);

		// 4 matches: target, hosted config, member, member's hosted config
		d = matcher.getPossibleLinks(unit1, unit2, linkTypesToCreate,
				DeployValidatorService.MATCHER_DEPTH_ALL);
//		assert d.length == 4 : printLinkDescriptors(d);
		assert d.length == 8 : printLinkDescriptors(d);
		d = matcher.getPossibleLinks(unit1, unit2, linkTypesToCreate,
				DeployValidatorService.MATCHER_DEPTH_NONE);
//		assert d.length == 1 : printLinkDescriptors(d);
		assert d.length == 2 : printLinkDescriptors(d);
		d = matcher.getPossibleLinks(unit1, unit2, linkTypesToCreate, 1);
//		assert d.length == 3 : printLinkDescriptors(d);
		assert d.length == 6 : printLinkDescriptors(d);

		d = matcher.getPossibleLinks(unit1, mUnit2_2, linkTypesToCreate,
				DeployValidatorService.MATCHER_DEPTH_ALL);
//		assert d.length == 2 : printLinkDescriptors(d);
		assert d.length == 4 : printLinkDescriptors(d);

		d = matcher.getPossibleLinks(unit1, cUnit2_2_1, linkTypesToCreate,
				DeployValidatorService.MATCHER_DEPTH_ALL);
//		assert d.length == 1 : printLinkDescriptors(d);
		assert d.length == 2 : printLinkDescriptors(d);
	}

	public void testHostingLinkMatching() throws IOException {
		Topology top = createTopology("testHostingLinkMatching");

		// test from source requirement on source unit ...
		Unit unit1 = createUnit(top, false, false, "");

		// test from source requirement on source unit to target capability on
		// target unit
		Requirement cReq1 = CoreFactory.eINSTANCE.createRequirement();
		cReq1.setName("cReq1");
		cReq1.setDmoEType(CorePackage.Literals.CAPABILITY);
		unit1.getHostingOrAnyRequirements().add(cReq1);

		// System.out.println("============== hosting case 1 ===============");
		toVariousEndpointsHosting(unit1);
	}

	public void toVariousEndpointsHosting(Unit unit1) throws IOException {
		LinkDescriptor[] d;
		LinkType[] linkTypesToCreate = LinkType.HOSTING_SET;

		Topology top = unit1.getTopology();

		Unit unit2 = createUnit(top, false, false, "");

		// no links since target has no capability
		d = matcher.getPossibleLinks(unit2, unit1, linkTypesToCreate,
				DeployValidatorService.MATCHER_DEPTH_ALL);
		assert d.length == 0 : printLinkDescriptors(d);

		addHostingCapability(unit2);

		// now match with capability added to target unit2
		d = matcher.getPossibleLinks(unit2, unit1, linkTypesToCreate,
				DeployValidatorService.MATCHER_DEPTH_ALL);
		// MK: 5/22/2008: Change to matchers allow them to call multiple 
		// matchers to get domain specific (multiple) matchers; there are two
		// Changed multiple times below
//		assert d.length == 1 : printLinkDescriptors(d);
		assert d.length == 2 : printLinkDescriptors(d);

		// add hosted configuration unit to target
		Unit cUnit2_1 = createHostedConfigurationUnit(unit2, HOSTING);

		// 2 matches: target and its hosted config unit
		d = matcher.getPossibleLinks(unit2, unit1, linkTypesToCreate,
				DeployValidatorService.MATCHER_DEPTH_ALL);
//		assert d.length == 2 : printLinkDescriptors(d);
		assert d.length == 4 : printLinkDescriptors(d);
		d = matcher.getPossibleLinks(unit2, unit1, linkTypesToCreate,
				DeployValidatorService.MATCHER_DEPTH_NONE);
//		assert d.length == 1 : printLinkDescriptors(d);
		assert d.length == 2 : printLinkDescriptors(d);

		d = matcher.getPossibleLinks(cUnit2_1, unit1, linkTypesToCreate,
				DeployValidatorService.MATCHER_DEPTH_ALL);
//		assert d.length == 1 : printLinkDescriptors(d);
		assert d.length == 2 : printLinkDescriptors(d);

		// add memeber unit to target
		Unit mUnit2_2 = createUnit(top, HOSTING);
		(new LinkDescriptor(LinkType.MEMBER, unit2, mUnit2_2)).create();

		// 3 matches: target, its hosted config unit, its member unit
		d = matcher.getPossibleLinks(unit2, unit1, linkTypesToCreate,
				DeployValidatorService.MATCHER_DEPTH_ALL);
//		assert d.length == 3 : printLinkDescriptors(d);
		assert d.length == 6 : printLinkDescriptors(d);
		d = matcher.getPossibleLinks(unit2, unit1, linkTypesToCreate,
				DeployValidatorService.MATCHER_DEPTH_NONE);
//		assert d.length == 1 : printLinkDescriptors(d);
		assert d.length == 2 : printLinkDescriptors(d);

		d = matcher.getPossibleLinks(mUnit2_2, unit1, linkTypesToCreate,
				DeployValidatorService.MATCHER_DEPTH_ALL);
//		assert d.length == 1 : printLinkDescriptors(d);
		assert d.length == 2 : printLinkDescriptors(d);

		// host configuration unit on member unit
		Unit cUnit2_2_1 = createHostedConfigurationUnit(mUnit2_2, HOSTING);

		// 4 matches: target, hosted config, member, member's hosted config
		d = matcher.getPossibleLinks(unit2, unit1, linkTypesToCreate,
				DeployValidatorService.MATCHER_DEPTH_ALL);
//		assert d.length == 4 : printLinkDescriptors(d);
		assert d.length == 8 : printLinkDescriptors(d);
		d = matcher.getPossibleLinks(unit2, unit1, linkTypesToCreate,
				DeployValidatorService.MATCHER_DEPTH_NONE);
//		assert d.length == 1 : printLinkDescriptors(d);
		assert d.length == 2 : printLinkDescriptors(d);
		d = matcher.getPossibleLinks(unit2, unit1, linkTypesToCreate, 1);
//		assert d.length == 3 : printLinkDescriptors(d);
		assert d.length == 6 : printLinkDescriptors(d);

		d = matcher.getPossibleLinks(mUnit2_2, unit1, linkTypesToCreate,
				DeployValidatorService.MATCHER_DEPTH_ALL);
//		assert d.length == 2 : printLinkDescriptors(d);
		assert d.length == 4 : printLinkDescriptors(d);

		d = matcher.getPossibleLinks(cUnit2_2_1, unit1, linkTypesToCreate,
				DeployValidatorService.MATCHER_DEPTH_ALL);
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

	private static final String DEPENDENCY = "DEPENDENCY";
	private static final String HOSTING = "HOSTING";

	private Unit createUnit(Topology top, String capabilityType) {
		return createUnit(top, false, true, capabilityType);
	}

	private Unit createUnit(Topology top, boolean configUnit,
			boolean createCapability, String capabilityType) {
		Unit unit = CoreFactory.eINSTANCE.createUnit();
		unit.setName(UnitUtil.generateUniqueName(unit, "unit"));
		unit.setConfigurationUnit(configUnit);

		if (createCapability) {
			if (capabilityType.equals(DEPENDENCY)) {
				addDependencyCapability(unit);
			} else if (capabilityType.equals(HOSTING)) {
				addHostingCapability(unit);
			}
		}

		top.getUnits().add(unit);
		return unit;
	}

	private Unit createHostedConfigurationUnit(Unit container,
			String capabilityType) {
		Unit cUnit = createUnit(container.getTopology(), capabilityType);
		cUnit.setConfigurationUnit(true);
		cUnit.setName(UnitUtil.generateUniqueName(cUnit, "config"));

		container.getTopology().getUnits().add(cUnit);

		// ... to target capability on configurtion unit hosted on the target
		// unit
		LinkDescriptor hLink = new LinkDescriptor(LinkType.HOSTING, container,
				cUnit);
		hLink.create();

		return cUnit;
	}

	private void addDependencyCapability(Unit container) {
		// ... to target capability on target unit
		Capability cap = CoreFactory.eINSTANCE.createCapability();
		cap.setName(UnitUtil.generateUniqueName(cap, "cap"));
		container.getOnlyDependencyCapabilities().add(cap);
	}

	private void addHostingCapability(Unit container) {
		// ... to target capability on target unit
		Capability cap = CoreFactory.eINSTANCE.createCapability();
		cap.setName(UnitUtil.generateUniqueName(cap, "cap"));
		container.getOnlyHostingCapabilities().add(cap);
	}

	private void addMultiplicityOutboundConstraint(Unit container, EClass ec,
			int min, int max) {
		Requirement req = CoreFactory.eINSTANCE.createRequirement();
		req.setName(UnitUtil.generateUniqueName(container, "rom")); //$NON-NLS-1$
		req.setDmoEType(ec);
		req.setLinkType(RequirementLinkTypes.MEMBER_LITERAL);
		RequirementExpression outMultiplicity = OutCardinality
				.createExpression(min, max);
		req.getExpressions().add(outMultiplicity);
		container.getRequirements().add(req);
	}

	private void addMultiplicityInboundConstraint(Unit inside, EClass ec,
			int min, int max) {
		Requirement req = CoreFactory.eINSTANCE.createRequirement();
		req.setName(UnitUtil.generateUniqueName(inside, "rim")); //$NON-NLS-1$
		req.setDmoEType(ec);
		req.setLinkType(RequirementLinkTypes.MEMBER_LITERAL);
		RequirementExpression inMultiplicity = InCardinality.createExpression(
				min, max);
		req.getExpressions().add(inMultiplicity);
		inside.getRequirements().add(req);
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

	private static void dumpTopology(Topology t, String title) {
		System.out.println("Topology " + title);
		for (Iterator it = t.getUnits().iterator(); it.hasNext();) {
			Unit u = (Unit) it.next();
			System.out.println("   unit: " + u.getName());
			for (Iterator cIt = u.getCapabilities().iterator(); cIt.hasNext();) {
				Capability c = (Capability) cIt.next();
				System.out.println("       cap: " + c.getName() + " ("
						+ c.getEObject().eClass().getName() + ")");
			}
			for (Iterator rIt = u.getRequirements().iterator(); rIt.hasNext();) {
				Requirement r = (Requirement) rIt.next();
				System.out.println("       req: " + r.getName() + " ("
						+ r.getDmoEType().getName() + ")");
			}
		}
	}

}
