/*******************************************************************************
 * Copyright (c) 2003, 2007 IBM Corporation Licensed Material - Property of IBM. All rights reserved.
 *  
 * US Government Users Restricted Rights - Use, duplication or disclosure v1.0 restricted by GSA ADP
 * Schedule Contract with IBM Corp.
 * 
 * Contributors: IBM Corporation - initial API and implementation
 *******************************************************************************/
package com.ibm.ccl.soa.deploy.core.test.validator.constraints;

import java.util.Collection;

import org.eclipse.core.runtime.IStatus;

import com.ibm.ccl.soa.deploy.core.Capability;
import com.ibm.ccl.soa.deploy.core.CapabilityLinkTypes;
import com.ibm.ccl.soa.deploy.core.ConstraintLink;
import com.ibm.ccl.soa.deploy.core.CorePackage;
import com.ibm.ccl.soa.deploy.core.DependencyLink;
import com.ibm.ccl.soa.deploy.core.DeployModelObject;
import com.ibm.ccl.soa.deploy.core.HostingLink;
import com.ibm.ccl.soa.deploy.core.InstallState;
import com.ibm.ccl.soa.deploy.core.MemberLink;
import com.ibm.ccl.soa.deploy.core.Requirement;
import com.ibm.ccl.soa.deploy.core.RequirementLinkTypes;
import com.ibm.ccl.soa.deploy.core.Topology;
import com.ibm.ccl.soa.deploy.core.Unit;
import com.ibm.ccl.soa.deploy.core.constraint.AttributePropagationConstraint;
import com.ibm.ccl.soa.deploy.core.constraint.ConstraintFactory;
import com.ibm.ccl.soa.deploy.core.test.TopologyTestCase;
import com.ibm.ccl.soa.deploy.core.validator.ValidatorUtils;
import com.ibm.ccl.soa.deploy.core.validator.matcher.LinkFactory;
import com.ibm.ccl.soa.deploy.core.validator.status.DeployStatusIterator;
import com.ibm.ccl.soa.deploy.core.validator.status.ICoreProblemType;
import com.ibm.ccl.soa.deploy.core.validator.status.IDeployAttributeValueStatus;
import com.ibm.ccl.soa.deploy.core.validator.status.IDeployStatus;

/**
 * Tests for {@link AttributePropagationConstraint}
 */
public class AttributePropagationConstraintTest extends TopologyTestCase {

	public AttributePropagationConstraintTest() {
		super("AttributePropagationConstraintTest");
	}

	public void testOverCapability() {
		//
		// {c1}u1
		//
		Topology top = createTopology("testOverCapability");
		Unit u1 = addUnit(top, "u1");
		Capability c1 = super.addCapability(u1, "c1",
				CapabilityLinkTypes.ANY_LITERAL);
		AttributePropagationConstraint apc = createDescriptionToDisplayNameConstraint();

		// Default c1 -> c1
		checkDescriptionToDisplayNamePropagation(apc, c1, c1, c1, top);
	}

	public void testOverConstraintLink() {
		//
		// {c1}u1 --cl--> {c2}u2
		//
		Topology top = createTopology("testOverConstraintLink");
		Unit u1 = addUnit(top, "u1");
		Capability c1 = super.addCapability(u1, "c1",
				CapabilityLinkTypes.ANY_LITERAL);
		Unit u2 = addUnit(top, "u2");
		Capability c2 = super.addCapability(u2, "c2",
				CapabilityLinkTypes.ANY_LITERAL);
		ConstraintLink link = LinkFactory.createConstraintLink(u1, u2);

		AttributePropagationConstraint apc = createDescriptionToDisplayNameConstraint();

		// Default u1 -> u2
		checkDescriptionToDisplayNamePropagation(apc, link, u1, u2, top);

		// Try u1 -> c2
		apc.setSourceObjectURI(null);
		apc.setTargetObjectURI(c2.getName());
		checkDescriptionToDisplayNamePropagation(apc, link, u1, c2, top);

		// Try c1 -> u2
		apc.setSourceObjectURI(c1.getName());
		apc.setTargetObjectURI(null);
		checkDescriptionToDisplayNamePropagation(apc, link, c1, u2, top);

		// Try c1 -> c2
		apc.setSourceObjectURI(c1.getName());
		apc.setTargetObjectURI(c2.getName());
		checkDescriptionToDisplayNamePropagation(apc, link, c1, c2, top);
	}

	public void testOverDependencyLinkAndRequirement() {
		//
		// {c1}u1{r1}--dl-->{c2}u2
		//
		Topology top = createTopology("testOverDependencyLinkAndRequirement");
		Unit u1 = addUnit(top, "u1");
		Capability c1 = addCapability(u1, "c1", CapabilityLinkTypes.ANY_LITERAL);
		Requirement r1 = addRequirement(u1, "r1",
				RequirementLinkTypes.DEPENDENCY_LITERAL);
		Unit u2 = addUnit(top, "u2");
		Capability c2 = addCapability(u2, "c2", CapabilityLinkTypes.ANY_LITERAL);
		DependencyLink link = LinkFactory.createDependencyLink(r1, c2);

		AttributePropagationConstraint apc = createDescriptionToDisplayNameConstraint();

		// on link u1 -> c2
		checkDescriptionToDisplayNamePropagation(apc, link, u1, c2, top);

		// on link c1 -> c2
		apc.setSourceObjectURI(c1.getName());
		apc.setTargetObjectURI(null);
		checkDescriptionToDisplayNamePropagation(apc, link, c1, c2, top);

		// on requirement u1 -> c2
		apc.setSourceObjectURI(null);
		apc.setTargetObjectURI(null);
		checkDescriptionToDisplayNamePropagation(apc, r1, u1, c2, top);

		// on requirement c1 -> c2
		apc.setSourceObjectURI(c1.getName());
		apc.setTargetObjectURI(null);
		checkDescriptionToDisplayNamePropagation(apc, r1, c1, c2, top);
	}

	public void testOverHostingLinkRequirement() {
		//
		// {hostedC}hosted{hostedR}<--hl--{hostC}host
		//
		Topology top = createTopology("testOverHostingLinkRequirement");
		Unit hosted = addUnit(top, "hosted");
		Capability hostedC = addCapability(hosted, "hostedC",
				CapabilityLinkTypes.ANY_LITERAL);
		Requirement hostedR = addRequirement(hosted, "hostedR",
				RequirementLinkTypes.HOSTING_LITERAL);
		Unit host = addUnit(top, "host");
		Capability hostC = addCapability(host, "hostedC",
				CapabilityLinkTypes.ANY_LITERAL);
		HostingLink link = LinkFactory.createHostingLink(host, hosted);

		AttributePropagationConstraint apc = createDescriptionToDisplayNameConstraint();

		// on link host -> hosted
		checkDescriptionToDisplayNamePropagation(apc, link, host, hosted, top);

		// on link host.c -> hosted
		apc.setSourceObjectURI(hostC.getName());
		apc.setTargetObjectURI(null);
		checkDescriptionToDisplayNamePropagation(apc, link, hostC, hosted, top);

		// on link host.c -> hosted.c
		apc.setSourceObjectURI(hostC.getName());
		apc.setTargetObjectURI(hostedC.getName());
		checkDescriptionToDisplayNamePropagation(apc, link, hostC, hostedC, top);

		// on requirement hosted -> host
		apc.setSourceObjectURI(null);
		apc.setTargetObjectURI(null);
		checkDescriptionToDisplayNamePropagation(apc, hostedR, hosted, host,
				top);

		// on requirement hosted.C -> host.C
		apc.setSourceObjectURI(hostedC.getName());
		apc.setTargetObjectURI(hostC.getName());
		checkDescriptionToDisplayNamePropagation(apc, hostedR, hostedC, hostC,
				top);
	}

	public void testOverMemberLinkAndRequirement() {
		Topology top = createTopology("testOverMemberLinkRequirement");
		// {c1}u1{r1}--ml-->{c2}u2
		Unit group = addGroupUnit(top, "group");
		Requirement r1 = (Requirement) group.getRequirements().get(0);
		Capability groupCap1 = addCapability(group, "groupC1",
				CapabilityLinkTypes.ANY_LITERAL);
		assertTrue(group.isGroup());
		Unit member = addMemberUnit(top, "member");
		Capability memberCap1 = addCapability(member, "memberC1",
				CapabilityLinkTypes.ANY_LITERAL);
		assertFalse(member.isGroup());

		MemberLink link = LinkFactory.createMemberLink(group, member);

		AttributePropagationConstraint apc = createDescriptionToDisplayNameConstraint();

		// on link: group -> member
		checkDescriptionToDisplayNamePropagation(apc, link, group, member, top);

		// on link: group.C -> member
		apc.setSourceObjectURI(groupCap1.getName());
		apc.setTargetObjectURI(null);
		checkDescriptionToDisplayNamePropagation(apc, link, groupCap1, member,
				top);

		// on link: group -> member.C
		apc.setSourceObjectURI(null);
		apc.setTargetObjectURI(memberCap1.getName());
		checkDescriptionToDisplayNamePropagation(apc, link, group, memberCap1,
				top);

		// on link: group.C -> member.C
		apc.setSourceObjectURI(groupCap1.getName());
		apc.setTargetObjectURI(memberCap1.getName());
		checkDescriptionToDisplayNamePropagation(apc, link, groupCap1,
				memberCap1, top);

		// on requirement: group -> member
		apc.setSourceObjectURI(null);
		apc.setTargetObjectURI(null);
		checkDescriptionToDisplayNamePropagation(apc, r1, group, member, top);

		// on requirement: group.C -> member
		apc.setSourceObjectURI(groupCap1.getName());
		apc.setTargetObjectURI(null);
		checkDescriptionToDisplayNamePropagation(apc, r1, groupCap1, member,
				top);

		// on requirement: group -> member.C
		apc.setSourceObjectURI(null);
		apc.setTargetObjectURI(memberCap1.getName());
		checkDescriptionToDisplayNamePropagation(apc, r1, group, memberCap1,
				top);

		// on requirement: group.C -> member.C
		apc.setSourceObjectURI(groupCap1.getName());
		apc.setTargetObjectURI(memberCap1.getName());
		checkDescriptionToDisplayNamePropagation(apc, r1, groupCap1,
				memberCap1, top);
	}

	/**
	 * Adds an attribute propagation constraint to the parent object and checks
	 * that it propagates over the source and target object.
	 * <p>
	 * The caller is responsible to pass correct source and target objects in
	 * respect to the constraint parent.
	 * 
	 * @param c
	 *            an attribute propagation constraint from
	 *            {@link DeployModelObject#getDescription()} to
	 *            {@link DeployModelObject#getDisplayName()} (can be created
	 *            using {@link #createDescriptionToDisplayNameConstraint()}).
	 * @param constraintParent
	 *            the object where the constraint is added.
	 * @param source
	 *            the source of the propagation.
	 * @param target
	 *            the target of the propagation.
	 * @param top
	 *            the topology.
	 */
	protected void checkDescriptionToDisplayNamePropagation(
			AttributePropagationConstraint c,
			DeployModelObject constraintParent, DeployModelObject source,
			DeployModelObject target, Topology top) {

		// Add constraint to parent and checkpoint the attributes used to
		// propagate.
		assertEquals(CorePackage.eINSTANCE.getDeployModelObject_Description()
				.getName(), c.getSourceAttributeName());
		assertEquals(CorePackage.eINSTANCE.getDeployModelObject_DisplayName()
				.getName(), c.getTargetAttributeName());
		String sourceDescription = source.getDescription();
		String targetDescription = target.getDescription();
		String sourceDisplayName = source.getDisplayName();
		String targetDisplayName = target.getDisplayName();
		assertTrue(!constraintParent.getConstraints().contains(c));
		constraintParent.getConstraints().add(c);
		try {
			source.setDescription(null);
			target.setDisplayName(null);
			c.setRespectLinkDirection(true);

			getValidatorService().validate(top);
			assertHasNoErrorStatus(top);

			// Make the values inconsistent and check propagation in the
			// direction of the link.
			source.setDescription("value");
			getValidatorService().validate(top);
			dumpStatus(top);
			if ((constraintParent instanceof Requirement)
					&& (((Requirement) constraintParent).getLinkType() == RequirementLinkTypes.HOSTING_LITERAL)) {
				Collection<HostingLink> links = constraintParent
						.getEditTopology().getRelationships().getHostLinks(
								ValidatorUtils.getUnit(constraintParent));
				assertEquals(1, links.size());
				assertHasDeployAttributeStatus(target,
						ICoreProblemType.OBJECT_ATTRIBUTE_INVALID,
						IStatus.ERROR, CorePackage.eINSTANCE
								.getDeployModelObject_DisplayName());
			} else {
				assertHasDeployAttributeStatus(target,
						ICoreProblemType.OBJECT_ATTRIBUTE_INVALID,
						IStatus.ERROR, CorePackage.eINSTANCE
								.getDeployModelObject_DisplayName());
			}

			// Change the direction of the propagation
			// Now 'target' object will be the source of the value,
			// and 'source' object will be the target.
			c.setRespectLinkDirection(false);
			// swap 'targetObjectURI' and 'sourceObjectURI' attributes on the
			// constraint
			String s = c.getSourceObjectURI();
			c.setSourceObjectURI(c.getTargetObjectURI());
			c.setTargetObjectURI(s);

			target.setDescription("value");
			source.setDisplayName(null);
			getValidatorService().validate(top);
			if ((constraintParent instanceof Requirement)
					&& (((Requirement) constraintParent).getLinkType() == RequirementLinkTypes.HOSTING_LITERAL)) {
				Collection<HostingLink> links = constraintParent
						.getEditTopology().getRelationships().getHostLinks(
								ValidatorUtils.getUnit(constraintParent));
				assertEquals(1, links.size());
				assertHasDeployAttributeStatus(source,
						ICoreProblemType.OBJECT_ATTRIBUTE_INVALID,
						IStatus.ERROR, CorePackage.eINSTANCE
								.getDeployModelObject_DisplayName());
			} else {
				assertHasDeployAttributeStatus(source,
						ICoreProblemType.OBJECT_ATTRIBUTE_INVALID,
						IStatus.ERROR, CorePackage.eINSTANCE
								.getDeployModelObject_DisplayName());
			}

			// Make the values consistent
			source.setDisplayName(target.getDescription());
			getValidatorService().validate(top);
			assertHasNoErrorStatus(top);
		} finally {
			// Undo changes to model
			constraintParent.getConstraints().remove(c);
			source.setDescription(sourceDescription);
			source.setDisplayName(sourceDisplayName);
			target.setDescription(targetDescription);
			target.setDisplayName(targetDisplayName);
		}

	}

	/**
	 * Creates an attribute propagation constraint from
	 * {@link DeployModelObject#getDescription()} to
	 * {@link DeployModelObject#getDisplayName()}
	 * 
	 * @return the created constraint
	 */
	protected AttributePropagationConstraint createDescriptionToDisplayNameConstraint() {
		AttributePropagationConstraint c = ConstraintFactory.eINSTANCE
				.createAttributePropagationConstraint();
		c.setName("apc");
		c.setSourceObjectURI(null);
		c.setSourceAttributeName("description");
		c.setTargetObjectURI(null);
		c.setTargetAttributeName("displayName");
		c.setRespectLinkDirection(true);
		return c;
	}

	public void testNonStringToStringPropagation() {
		//
		// {c1}u1
		//
		Topology top = createTopology("testNonStringToStringPropagation");
		Unit u1 = addUnit(top, "u1");
		Capability c1 = super.addCapability(u1, "c1",
				CapabilityLinkTypes.ANY_LITERAL);

		//
		// Propagate from an enumeration type to String
		// 
		AttributePropagationConstraint c = ConstraintFactory.eINSTANCE
				.createAttributePropagationConstraint();
		c.setName("apc");
		c.setSourceObjectURI(null);
		c.setSourceAttributeName(CorePackage.eINSTANCE
				.getUnit_InitInstallState().getName());
		c.setTargetObjectURI(null);
		c.setTargetAttributeName(CorePackage.eINSTANCE
				.getDeployModelObject_Description().getName());
		c.setRespectLinkDirection(true);
		u1.getConstraints().add(c);

		u1.setInitInstallState(InstallState.INSTALLED_LITERAL);
		u1.setDescription(InstallState.INSTALLED_LITERAL.toString());
		
		// Verify that validation converts the literal to a string and succeeds
		validate(top);
		assertHasNoErrorStatus(top);
		
		u1.setDescription(null);
		validate(top);
		assertHasErrorStatus(top);

		// Verify that the attribute propagation constraint performed the
		// conversion from enumeration to string using Object#toString()
		IDeployAttributeValueStatus aStatus = null;
		for (DeployStatusIterator iter = new DeployStatusIterator(u1
				.getStatus()); iter.hasNext();) {
			IDeployStatus status = iter.next();
			if (status instanceof IDeployAttributeValueStatus) {
				aStatus = (IDeployAttributeValueStatus) status;
			}
		}
		assertNotNull(aStatus);

		// Expected value should be INSTALLED_LITERAL.toString() NOT INSTALLED_LITERAL
		assert (aStatus.getAttributeExpectedValue()
				.equals(InstallState.INSTALLED_LITERAL.toString()));

	}

}
