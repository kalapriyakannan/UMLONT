/*******************************************************************************
 * Copyright (c) 2003, 2007 IBM Corporation Licensed Material - Property of IBM. All rights reserved.
 *  
 * US Government Users Restricted Rights - Use, duplication or disclosure v1.0 restricted by GSA ADP
 * Schedule Contract with IBM Corp.
 * 
 * Contributors: IBM Corporation - initial API and implementation
 *******************************************************************************/
package com.ibm.ccl.soa.deploy.core.test;

import java.util.Iterator;

import com.ibm.ccl.soa.deploy.core.Capability;
import com.ibm.ccl.soa.deploy.core.CoreFactory;
import com.ibm.ccl.soa.deploy.core.CorePackage;
import com.ibm.ccl.soa.deploy.core.DependencyLink;
import com.ibm.ccl.soa.deploy.core.MemberLink;
import com.ibm.ccl.soa.deploy.core.Requirement;
import com.ibm.ccl.soa.deploy.core.RequirementExpression;
import com.ibm.ccl.soa.deploy.core.RequirementLinkTypes;
import com.ibm.ccl.soa.deploy.core.Topology;
import com.ibm.ccl.soa.deploy.core.Unit;
import com.ibm.ccl.soa.deploy.core.util.RequirementLinkTypeFilter;

public class RequirementTest extends TopologyTestCase {

	public RequirementTest() {
		super("RequirementTest");
	}

	public void testRequirements() throws Exception {
		Topology top = createTopology("testRequirements");

		Unit u1 = CoreFactory.eINSTANCE.createUnit();
		u1.setName("u1");
		top.getUnits().add(u1);

		assert u1.getRequirements().size() == 0;
		assert u1.getOnlyAnyRequirements().size() == 0;
		assert u1.getOnlyDependencyRequirements().size() == 0;
		assert u1.getOnlyHostingRequirements().size() == 0;
		assert u1.getOnlyMemberRequirements().size() == 0;
		assert u1.getDependencyOrAnyRequirements().size() == 0;
		assert u1.getHostingOrAnyRequirements().size() == 0;
		assert u1.getMemberOrAnyRequirements().size() == 0;

		// Create DEPENDENCY requirement
		Requirement req = CoreFactory.eINSTANCE.createRequirement();
		req.setName("r1");
		req.setLinkType(RequirementLinkTypes.DEPENDENCY_LITERAL);
		req.setDmoEType(CorePackage.eINSTANCE.getCapability());
		RequirementExpression e1 = CoreFactory.eINSTANCE
				.createRequirementExpression();
		e1.setName("origin");
		e1.setInterpreter("EQUALS");
		e1.setValue("test");

		u1.getRequirements().add(req);

		assertSetEquals(u1.getRequirements(), new Object[] { req });
		assert u1.getOnlyAnyRequirements().size() == 0;
		assert u1.getOnlyHostingRequirements().size() == 0;
		assertSetEquals(u1.getOnlyDependencyRequirements(),
				new Object[] { req });
		assert u1.getOnlyMemberRequirements().size() == 0;
		assert u1.getHostingOrAnyRequirements().size() == 0;
		assertSetEquals(u1.getDependencyOrAnyRequirements(),
				new Object[] { req });
		assert u1.getMemberOrAnyRequirements().size() == 0;

		assert req.getParent() == u1;

		assertSetEquals(top.findAllDeployModelObjects(),
				new Object[] { u1, req });

		// create DEPENDENCY capability

		Unit u2 = CoreFactory.eINSTANCE.createUnit();
		u2.setName("u2");
		top.getUnits().add(u2);

		Capability cap = CoreFactory.eINSTANCE.createCapability();
		cap.setName("provided");
		cap.setOrigin("test");
		u2.getOnlyDependencyCapabilities().add(cap);

		DependencyLink link = CoreFactory.eINSTANCE.createDependencyLink();
		link.setName("link");
		link.setTarget(cap);
		req.setLink(link);
		assert req.getLink() == link;
		assert link.getParent() == req;
		assert link.getSource() == req;
		assert link.getTarget() == cap;
		assertSetEquals(top.findAllDependencyLinks(), new Object[] { link });

		//
		// Serialization
		// 
		top = reload(top, true);
		u1 = (Unit) top.resolve("u1");
		u2 = (Unit) top.resolve("u2");
		assert u1.getRequirements().size() == 1;
		assert u2.getCapabilities().size() == 1;

		req = (Requirement) u1.getRequirements().get(0);
		cap = (Capability) u2.getCapabilities().get(0);
		assert cap != null;
		assert req != null;

		link = req.getLink();
		assert link != null;
		assert link.getParent() == req;
		assert link.getSource() == req;
		assert link.getTarget() == cap;
	}

	public void testMemberRequirements() throws Exception {
		Topology top = createTopology("testRequirements");

		Unit u1 = CoreFactory.eINSTANCE.createUnit();
		u1.setName("u1");
		top.getUnits().add(u1);

		assert u1.getRequirements().size() == 0;
		assert u1.getOnlyAnyRequirements().size() == 0;
		assert u1.getOnlyDependencyRequirements().size() == 0;
		assert u1.getOnlyHostingRequirements().size() == 0;
		assert u1.getOnlyMemberRequirements().size() == 0;
		assert u1.getDependencyOrAnyRequirements().size() == 0;
		assert u1.getHostingOrAnyRequirements().size() == 0;
		assert u1.getMemberOrAnyRequirements().size() == 0;
		assert !u1.isGroup();

		// Create MEMBER requirement
		Requirement req = CoreFactory.eINSTANCE.createRequirement();
		req.setName("r1");
		req.setLinkType(RequirementLinkTypes.MEMBER_LITERAL);
		req.setDmoEType(CorePackage.eINSTANCE.getCapability());

		u1.getRequirements().add(req);

		assertSetEquals(u1.getRequirements(), new Object[] { req });
		assert u1.getOnlyAnyRequirements().size() == 0;
		assert u1.getOnlyHostingRequirements().size() == 0;
		assert u1.getOnlyDependencyRequirements().size() == 0;
		assertSetEquals(u1.getOnlyMemberRequirements(), new Object[] { req });
		assert u1.getHostingOrAnyRequirements().size() == 0;
		assert u1.getDependencyOrAnyRequirements().size() == 0;
		assertSetEquals(u1.getMemberOrAnyRequirements(), new Object[] { req });
		assert u1.isGroup();

		// Create member link

		Unit u2 = CoreFactory.eINSTANCE.createUnit();
		u2.setName("u2");
		top.getUnits().add(u2);

		MemberLink link = CoreFactory.eINSTANCE.createMemberLink();
		link.setName("link");
		link.setSource(u1);
		link.setTarget(u2);
		u1.getMemberLinks().add(link);

		assert u1.isGroup();

		//
		// Serialization
		// 
		top = reload(top, true);
		u1 = (Unit) top.resolve("u1");
		u2 = (Unit) top.resolve("u2");
		assert u1.getRequirements().size() == 1;
		assert u2.getCapabilities().size() == 0;

		req = (Requirement) u1.getRequirements().get(0);
		assert req != null;

		assert u1.getMemberLinks().size() == 1;
		link = (MemberLink) u1.getMemberLinks().get(0);
		assert link != null;
		assert link.getParent() == u1;
		assert link.getSource() == u1;
		assert link.getTarget() == u2;

		assertSetEquals(u1.getRequirements(), new Object[] { req });
		assert u1.getOnlyAnyRequirements().size() == 0;
		assert u1.getOnlyHostingRequirements().size() == 0;
		assert u1.getOnlyDependencyRequirements().size() == 0;
		assertSetEquals(u1.getOnlyMemberRequirements(), new Object[] { req });
		assert u1.getHostingOrAnyRequirements().size() == 0;
		assert u1.getDependencyOrAnyRequirements().size() == 0;
		assertSetEquals(u1.getMemberOrAnyRequirements(), new Object[] { req });
		assert u1.isGroup();
	}

	/**
	 * Tests the setting of requirement link types and their effect on set
	 * membership.
	 * 
	 * @see DeployCoreModelTest#testCapabilityLinkTypes()
	 */
	public void testRequirementLinkTypes() throws Exception {
		Topology top = createTopology("testRequirementLinkTypes");

		Unit unit = CoreFactory.eINSTANCE.createUnit();
		unit.setName("u1");
		top.getUnits().add(unit);

		Requirement req = CoreFactory.eINSTANCE.createRequirement();
		req.setName("req");
		unit.getRequirements().add(req);

		req.setLinkType(RequirementLinkTypes.DEPENDENCY_LITERAL);
		assertSetEquals(unit.getRequirements(), new Object[] { req });
		assertSetEquals(unit.getOnlyAnyRequirements(), null);
		assertSetEquals(unit.getOnlyHostingRequirements(), null);
		assertSetEquals(unit.getHostingOrAnyRequirements(), null);
		assertSetEquals(unit.getOnlyDependencyRequirements(),
				new Object[] { req });
		assertSetEquals(unit.getDependencyOrAnyRequirements(),
				new Object[] { req });
		assertSetEquals(unit.getRequirements(
				RequirementLinkTypeFilter.ANY_OR_DEPENDENCY_FILTER, null),
				new Object[] { req });

		req.setLinkType(RequirementLinkTypes.ANY_LITERAL);
		assertSetEquals(unit.getRequirements(), new Object[] { req });
		assertSetEquals(unit.getOnlyAnyRequirements(), new Object[] { req });
		assertSetEquals(unit.getOnlyHostingRequirements(), null);
		assertSetEquals(unit.getHostingOrAnyRequirements(),
				new Object[] { req });
		assertSetEquals(unit.getOnlyDependencyRequirements(), null);
		assertSetEquals(unit.getDependencyOrAnyRequirements(),
				new Object[] { req });

		req.setLinkType(RequirementLinkTypes.HOSTING_LITERAL);
		assertSetEquals(unit.getRequirements(), new Object[] { req });
		assertSetEquals(unit.getOnlyAnyRequirements(), null);
		assertSetEquals(unit.getOnlyHostingRequirements(), new Object[] { req });
		assertSetEquals(unit.getHostingOrAnyRequirements(),
				new Object[] { req });
		assertSetEquals(unit.getOnlyDependencyRequirements(), null);
		assertSetEquals(unit.getDependencyOrAnyRequirements(), null);

		// Check adaptation of requirement

		unit.getRequirements().remove(req);
		req.setLinkType(RequirementLinkTypes.DEPENDENCY_LITERAL);
		unit.getOnlyAnyRequirements().add(req);
		assert req.getLinkType() == RequirementLinkTypes.ANY_LITERAL;

		unit.getRequirements().remove(req);
		req.setLinkType(RequirementLinkTypes.DEPENDENCY_LITERAL);
		unit.getOnlyHostingRequirements().add(req);
		assert req.getLinkType() == RequirementLinkTypes.HOSTING_LITERAL;

		unit.getRequirements().remove(req);
		req.setLinkType(RequirementLinkTypes.HOSTING_LITERAL);
		unit.getOnlyDependencyRequirements().add(req);
		assert req.getLinkType() == RequirementLinkTypes.DEPENDENCY_LITERAL;

		unit.getRequirements().remove(req);
		req.setLinkType(RequirementLinkTypes.HOSTING_LITERAL);
		unit.getDependencyOrAnyRequirements().add(req);
		assert req.getLinkType() == RequirementLinkTypes.ANY_LITERAL;

		unit.getRequirements().remove(req);
		req.setLinkType(RequirementLinkTypes.DEPENDENCY_LITERAL);
		unit.getHostingOrAnyRequirements().add(req);
		assert req.getLinkType() == RequirementLinkTypes.ANY_LITERAL;
	}

// public void testRequirementsAddedAsCapabilities() throws Exception {
// Topology top = createTopology("testRequirementsAddedAsCapabilities");
//
// Unit u1 = CoreFactory.eINSTANCE.createUnit();
// u1.setName("u1");
// top.getUnits().add(u1);
//
// Capability providedCapability = CoreFactory.eINSTANCE
// .createCapability();
// providedCapability.setName("provided");
// providedCapability.setOrigin("test");
// u1.getOnlyDependencyCapabilities().add(providedCapability);
//
// Unit u2 = CoreFactory.eINSTANCE.createUnit();
// u2.setName("u2");
// top.getUnits().add(u2);
//
// assert u2.getRequirements().size() == 0;
//
// //
// // Create consumed capability
// //
// Capability consumedCapability = CoreFactory.eINSTANCE
// .createCapability();
// consumedCapability.setName("consumed");
// consumedCapability.setOrigin("test");
// // Set an extended attribute
// ExtendedAttribute extAttr = CoreFactory.eINSTANCE
// .createExtendedAttribute();
// String extAttrName = "extTest";
// EDataType extAttrType = XMLTypePackage.Literals.INT;
// Integer extAttrValue = new Integer(1);
// extAttr.setName(extAttrName);
// extAttr.setInstanceType(extAttrType);
// extAttr.setValue(extAttrValue);
// consumedCapability.getExtendedAttributes().add(extAttr);
// u2.getConsumedNonHostingCapabilities().add(consumedCapability);
//
// assertSetEquals(u2.getConsumedNonHostingCapabilities(),
// new Object[] { consumedCapability });
//
// //
// // Retrieve adapted requirement
// //
// assert u2.getRequirements().size() == 1;
// Requirement req = (Requirement) u2.getRequirements().get(0);
// assert req.getDmoEType().equals(
// consumedCapability.getEObject().eClass());
// RequirementExpression expr = getExpressionByName(req, "origin");
// assert expr != null : toString(req);
// assert expr.getValue().equals(consumedCapability.getOrigin());
//
// assert req.getExtendedAttributes().size() == 1;
// assert req.getExtendedAttribute(extAttrName) == req
// .getExtendedAttributes().get(0);
// assert req.getExtendedAttribute(extAttrName).getName().equals(
// extAttrName);
// assert req.getExtendedAttribute(extAttrName).getInstanceType().equals(
// extAttrType);
// assert req.getExtendedAttribute(extAttrName).getValue().equals(
// extAttrValue);
//
// // Test auto-updating of "view"
// consumedCapability.setOrigin("test2");
// assert expr.getValue().equals(consumedCapability.getOrigin());
//
// assert !consumedCapability.isHosting();
// assert !req.isHosting();
// consumedCapability.setHosting(true);
// assert req.isHosting();
// consumedCapability.setHosting(false);
// assert !req.isHosting();
//
// // New expression not created (test reuse)
// RequirementExpression expr2 = getExpressionByName(req, "origin");
// assert expr == expr2;
//
// u2.getConsumedNonHostingCapabilities().remove(consumedCapability);
// assert u2.getRequirements().size() == 0;
//
// u2.getConsumedNonHostingCapabilities().add(consumedCapability);
// assert u2.getRequirements().size() == 1;
//
// req = (Requirement) u2.getRequirements().get(0);
// assert req.getDmoEType().equals(
// CorePackage.eINSTANCE.getCapability());
// expr = getExpressionByName(req, "origin");
// assert expr != null : toString(req);
// assert expr.getValue().equals(consumedCapability.getOrigin());
//
// assert u2.getRequirements().remove(req);
// assert u2.getConsumedNonHostingCapabilities().size() == 0;
// assert u2.getRequirements().size() == 0;
//
// u2.getConsumedNonHostingCapabilities().add(consumedCapability);
// req = (Requirement) u2.getRequirements().get(0);
//
// //
// // Test link
// //
// assert req.getLink() == null;
// DependencyLink link = CoreFactory.eINSTANCE.createDependencyLink();
// link.setName("link");
// link.setTarget(providedCapability);
// consumedCapability.setLink(link);
//
// assert consumedCapability.getLink() == link;
// DependencyLink reqLink = (DependencyLink) req.getLink();
// assert reqLink != null;
// assert reqLink.getSource() == req;
// assert reqLink.getCapabilitySource() == consumedCapability;
// assert reqLink.getTarget() == providedCapability;
// assert reqLink.getParent() == consumedCapability;
// assertSetEquals(top.findAllDependencyLinks(), new Object[] { link });
//
// //
// // Serialization (prevent duplication of "mirrored" capabilities).
// //
//
// top = reload(top, true);
// // dumpResource(top);
//
// u2 = top.resolveUnit("u2", false);
// assert u2 != null;
// assert u2.getRequirements().size() == 1;
// req = (Requirement) u2.getRequirements().get(0);
//
// // Check that we're adapting ...
// assert ServicesSetRequirementAdapter.getAdapter(u2) != null;
//
// consumedCapability = u2.resolveConsumedOrProvidedCapability("consumed",
// false);
// assert consumedCapability != null;
// assert CapabilityRequirementAdapter.getAdapter(consumedCapability)
// .getRequirement() == req;
// assert RequirementCapabilityAdapter.getAdapter(req).getCapability() ==
// consumedCapability;
//
// Capability consumedCapability2 = CoreFactory.eINSTANCE
// .createCapability();
// consumedCapability2.setName("consumed2");
// consumedCapability2.setOrigin("test2");
// u2.getConsumedNonHostingCapabilities().add(consumedCapability2);
//
// assertSetEquals(u2.getConsumedNonHostingCapabilities(), new Object[] {
// consumedCapability, consumedCapability2 });
// assert u2.getRequirements().size() == 2 : u2.getRequirements().size();
//
// assert CapabilityRequirementAdapter.getAdapter(consumedCapability) != null;
// assert CapabilityRequirementAdapter.getAdapter(consumedCapability2) != null;
//
// // TODO (will fail now): req.getLink().getParent() == req
// }

	// Test of deprecated capability-requirement adaptation.
// public void testLinksOnRequirementsAddedAsCapabilities() throws Exception {
// Topology top = createTopology("testLinksOnRequirementsAddedAsCapabilities");
//
// Unit u1 = CoreFactory.eINSTANCE.createUnit();
// u1.setName("u1");
// top.getUnits().add(u1);
//
// Capability providedCapability = CoreFactory.eINSTANCE
// .createCapability();
// providedCapability.setName("provided");
// providedCapability.setOrigin("test");
// u1.getOnlyDependencyCapabilities().add(providedCapability);
//
// Unit u2 = CoreFactory.eINSTANCE.createUnit();
// u2.setName("u2");
// top.getUnits().add(u2);
//
// assert u2.getRequirements().size() == 0;
//
// Capability consumedCapability = CoreFactory.eINSTANCE
// .createCapability();
// consumedCapability.setName("consumed");
// consumedCapability.setHosting(true);
// u2.getConsumedNonHostingCapabilities().add(consumedCapability);
//
// Requirement req = (Requirement) u2.getRequirements().get(0);
//
// //
// // Test on requirement link
// //
// DependencyLink link = CoreFactory.eINSTANCE.createDependencyLink();
// link.setName("link");
// link.setTarget(providedCapability);
// req.setLink(link);
// assert link.getSource() == req;
// assert link.getCapabilitySource() == consumedCapability;
// assertSetEquals(top.findAllDependencyLinks(), new Object[] { link });
//
// assert req.getLink() == link;
// assert consumedCapability.getLink() == link;
//
// //
// // Serialization (prevent duplication of "mirrored" capabilities).
// //
//
// top = reload(top, true);
// // dumpResource(top);
// }

	protected String toString(Requirement req) {
		StringBuffer buffer = new StringBuffer();
		buffer.append("Requirement name=" + req.getName() + "\n");
		for (Iterator iter = req.getExpressions().iterator(); iter.hasNext();) {
			RequirementExpression expr = (RequirementExpression) iter.next();
			buffer.append("\n");
			buffer.append("Expression name=" + expr.getAttributeName());
			buffer.append(", interpreter=" + expr.getInterpreter());
			buffer.append(", value=" + expr.getValue());
			buffer.append("\n");
		}
		return buffer.toString();
	}

	protected RequirementExpression getExpressionByName(Requirement req,
			String name) {
		for (Iterator iter = req.getExpressions().iterator(); iter.hasNext();) {
			RequirementExpression expr = (RequirementExpression) iter.next();
			if (name.equals(expr.getName())) {
				return expr;
			}
		}
		return null;
	}

	public void testRequirementDmoETypeSerialization() throws Exception {
		Topology top = createTopology("testRequirementDmoETypeSerialization",
				true);

		Unit unit = CoreFactory.eINSTANCE.createUnit();
		unit.setName("unit");
		top.getUnits().add(unit);

		Requirement req = CoreFactory.eINSTANCE.createRequirement();
		req.setName("req");
		req.setDmoEType(CorePackage.eINSTANCE.getCapability());
		unit.getRequirements().add(req);

		assert req.getDmoEType().equals(CorePackage.eINSTANCE.getCapability());
		top.getEObject().eResource().save(null);
		// dumpResource(top);

		// Reload the topology
		top = reload(top, true);
		unit = (Unit) top.getUnits().get(0);
		assert unit != null;
		req = (Requirement) unit.getRequirements().get(0);
		assert req != null;
		assert req.getDmoEType() != null;
		assert req.getDmoEType().equals(CorePackage.eINSTANCE.getCapability());
	}

	/**
	 * Tests that a change in the consumed capability link results in an event
	 * on the adapted requirement.
	 * 
	 * Adapted capabilities deprecated.
	 */
// public void testLinksEventsOnAdaptedCapabilities() throws Exception {
// Topology top = createTopology("testLinksEventsOnAdaptedCapabilities");
//
// Unit u1 = CoreFactory.eINSTANCE.createUnit();
// u1.setName("u1");
// top.getUnits().add(u1);
//
// Capability providedCapability = CoreFactory.eINSTANCE
// .createCapability();
// providedCapability.setName("provided");
// providedCapability.setOrigin("test");
// u1.getOnlyDependencyCapabilities().add(providedCapability);
//
// Unit u2 = CoreFactory.eINSTANCE.createUnit();
// u2.setName("u2");
// top.getUnits().add(u2);
//
// assert u2.getRequirements().size() == 0;
//
// Capability consumedCapability = CoreFactory.eINSTANCE
// .createCapability();
// consumedCapability.setName("consumed");
// consumedCapability.setHosting(true);
// u2.getConsumedNonHostingCapabilities().add(consumedCapability);
//
// Requirement req = (Requirement) u2.getRequirements().get(0);
// assert req != null;
//
// DependencyLink link = CoreFactory.eINSTANCE.createDependencyLink();
// link.setName("link");
// link.setTarget(providedCapability);
//
// final List eventList = new ArrayList();
// Adapter eventMonitor = new Adapter() {
// protected Notifier target;
//
// public Notifier getTarget() {
// return target;
// }
//
// public boolean isAdapterForType(Object arg0) {
// return arg0 instanceof DeployModelObject;
// }
//
// public void notifyChanged(Notification arg0) {
// // System.out.println(" " + arg0);
// eventList.add(arg0);
// }
//
// public void setTarget(Notifier arg0) {
// this.target = arg0;
// }
// };
// req.getEObject().eAdapters().add(eventMonitor);
// consumedCapability.setLink(link);
// assert eventList.size() == 1;
// }
	public void testRequirementExpressionFind() throws Exception {
		Topology top = createTopology("testRequirementExpressionFind");
		Unit unit = CoreFactory.eINSTANCE.createUnit();
		unit.setName("unit");
		top.getUnits().add(unit);

		Requirement req = CoreFactory.eINSTANCE.createRequirement();
		req.setName("req");
		unit.getRequirements().add(req);

		RequirementExpression expr = CoreFactory.eINSTANCE
				.createRequirementExpression();
		expr.setName("expr");
		req.getExpressions().add(expr);

		assertSetEquals(top.findAllDeployModelObjects(), new Object[] { unit,
				req, expr });
		assertSetEquals(top.findAllRequirements(), new Object[] { req });
		assertSetEquals(top.findAllRequirementExpressions(),
				new Object[] { expr });
	}

}
