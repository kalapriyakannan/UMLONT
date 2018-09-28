/*******************************************************************************
 * Copyright (c) 2003, 2007 IBM Corporation Licensed Material - Property of IBM. All rights reserved.
 *  
 * US Government Users Restricted Rights - Use, duplication or disclosure v1.0 restricted by GSA ADP
 * Schedule Contract with IBM Corp.
 * 
 * Contributors: IBM Corporation - initial API and implementation
 *******************************************************************************/

package com.ibm.ccl.soa.deploy.core.test.validator.constraints;

import com.ibm.ccl.soa.deploy.core.BundleCapability;
import com.ibm.ccl.soa.deploy.core.Capability;
import com.ibm.ccl.soa.deploy.core.CapabilityLinkTypes;
import com.ibm.ccl.soa.deploy.core.CorePackage;
import com.ibm.ccl.soa.deploy.core.ConstraintLink;
import com.ibm.ccl.soa.deploy.core.Requirement;
import com.ibm.ccl.soa.deploy.core.RequirementLinkTypes;
import com.ibm.ccl.soa.deploy.core.Topology;
import com.ibm.ccl.soa.deploy.core.Unit;
import com.ibm.ccl.soa.deploy.core.constraint.CollocationConstraint;
import com.ibm.ccl.soa.deploy.core.constraint.CollocationConstraintTypes;
import com.ibm.ccl.soa.deploy.core.constraint.ConstraintFactory;
import com.ibm.ccl.soa.deploy.core.constraint.DeferredHostingConstraint;
import com.ibm.ccl.soa.deploy.core.test.TopologyTestCase;
import com.ibm.ccl.soa.deploy.core.validator.matcher.LinkFactory;

/**
 * Tests {@link CollocationConstraint}.
 */
public class LinkConstraintTest extends TopologyTestCase {

	public LinkConstraintTest() {
		super(LinkConstraintTest.class.getSimpleName());
	}

	/**
	 * Creates a topology with two hostees.
	 * <p>
	 * The final hosts provide {@link BundleCapability}
	 * <p>
	 * Example:
	 * 
	 * <pre>
	 * hostee1-1    hostee2
	 *    |          |
	 * middle1-1    middle2-2
	 *    |          |
	 * final1     middle2-2
	 *               |
	 *            final2
	 * </pre>
	 * 
	 * @param topologyName
	 *            the name of the generated topology.
	 * @param collocated
	 *            true if the hostees will be collocated at their final host.
	 * @param stack1Height
	 *            number of hosts between the final host and the hostee on one
	 *            stack
	 * @param stack2Height
	 *            number of hosts between the final host and the hostee on the
	 *            other stack
	 * @return the created topology with its units and hosting links.
	 */
	protected Topology createTopologyWithTwoHosteeUnits(String topologyName,
			boolean collocated, int stack1Height, int stack2Height) {
		Topology top = createTopology(topologyName);
		Unit hostee1 = addUnit(top, "hostee1");
		Requirement reqHostee1 = addRequirement(hostee1, "reqHostee1",
				RequirementLinkTypes.HOSTING_LITERAL);

		Unit hostee2 = addUnit(top, "hostee2");
		Requirement reqHostee2 = addRequirement(hostee2, "reqHostee2",
				RequirementLinkTypes.HOSTING_LITERAL);

		Unit finalHost1 = addUnit(top, "final1");
		Capability capHost1 = addCapability(finalHost1, "capHost1",
				CorePackage.Literals.BUNDLE_CAPABILITY,
				CapabilityLinkTypes.ANY_LITERAL);
		Unit finalHost2;
		if (collocated) {
			finalHost2 = finalHost1;
		} else {
			finalHost2 = addUnit(top, "final2");
			Capability capHost2 = addCapability(finalHost2, "capHost2",
					CorePackage.Literals.BUNDLE_CAPABILITY,
					CapabilityLinkTypes.ANY_LITERAL);
		}

		Unit lastUnit1 = hostee1;
		for (int i = 0; i < stack1Height; i++) {
			Unit unit = addUnit(top, "middle1Unit" + i);
			Capability capHost = addCapability(unit, "capHost1Middle" + i,
					CapabilityLinkTypes.ANY_LITERAL);
			Requirement reqHost = addRequirement(unit, "reqHost1Middle" + i,
					RequirementLinkTypes.HOSTING_LITERAL);
			LinkFactory.createHostingLink(unit, lastUnit1);
			lastUnit1 = unit;
		}
		LinkFactory.createHostingLink(finalHost1, lastUnit1);

		Unit lastUnit2 = hostee2;
		for (int i = 0; i < stack2Height; i++) {
			Unit unit = addUnit(top, "middle2-" + i);
			Capability capHost = addCapability(unit, "capHost2Middle" + i,
					CapabilityLinkTypes.ANY_LITERAL);
			Requirement reqHost = addRequirement(unit, "reqHost2Middle" + i,
					RequirementLinkTypes.HOSTING_LITERAL);
			LinkFactory.createHostingLink(unit, lastUnit2);
			lastUnit2 = unit;
		}
		LinkFactory.createHostingLink(finalHost2, lastUnit2);

		return top;
	}

	/**
	 * Create a logical link between "hostee1" and "hostee2" with a collocation
	 * constraint.
	 * <p>
	 * The collocation is at the {@link BundleCapability} level (final host).
	 * 
	 * @param top
	 *            a topology created by
	 *            {@link #createTopologyWithTwoHosteeUnits(String, boolean, int, int)}.
	 * @return the collocation constraint created.
	 */
	protected CollocationConstraint createHosteeBundleCollocationConstraint(
			Topology top) {
		// Create collocation constraint
		Unit hostee1 = (Unit) top.resolve("hostee1");
		Unit hostee2 = (Unit) top.resolve("hostee2");
		assertNotNull(hostee1);
		assertNotNull(hostee2);

		ConstraintLink link = LinkFactory.createConstraintLink(hostee1, hostee2);
		CollocationConstraint c = ConstraintFactory.eINSTANCE
				.createCollocationConstraint();
		c.setName("Collocation");
		c.setType(CollocationConstraintTypes.COLLOCATION_LITERAL);
		c.setCapabilityEType(CorePackage.Literals.BUNDLE_CAPABILITY);
		link.getConstraints().add(c);

		return c;
	}

	/**
	 * Create a logical link between "hostee1" and "hostee2" with a deferred
	 * hosting constraint.
	 * 
	 * @param top
	 *            a topology created by
	 *            {@link #createTopologyWithTwoHosteeUnits(String, boolean, int, int)}.
	 * @return the deferred hoshting constraint created.
	 */
	protected DeferredHostingConstraint createHosteeBundleDeferredHostingConstraint(
			Topology top, String source, String target) {
		Unit sourceUnit = (Unit) top.resolve(source);
		Unit targetUnit = (Unit) top.resolve(target);
		assertNotNull(sourceUnit);
		assertNotNull(targetUnit);

		ConstraintLink link = LinkFactory
				.createConstraintLink(sourceUnit, targetUnit);
		DeferredHostingConstraint c = ConstraintFactory.eINSTANCE
				.createDeferredHostingConstraint();
		c.setName("DeferredHosting");
		link.getConstraints().add(c);

		return c;
	}

	/**
	 * Tests collocation constraits on immediatelly collocated units (depth 0)
	 * 
	 * @throws Exception
	 */
	public void testCollocatedUnits1() throws Exception {
		Topology top = createTopologyWithTwoHosteeUnits("testCollocatedUnits1",
				true, 0, 0);
		validate(top);
		assertHasNoErrorStatus(top);

		// Test collocation (should be OK)
		CollocationConstraint c = createHosteeBundleCollocationConstraint(top);
		validate(top);
		assertHasNoErrorStatus(top);

		// Test anti-collocation (should produce error)
		c.setType(CollocationConstraintTypes.ANTICOLLOCATION_LITERAL);
		validate(top);
		assertHasErrorStatus(top);
	}

	/**
	 * Tests collocation constraits on indirectly collocated units (depth 2)
	 * 
	 * @throws Exception
	 */
	public void testCollocatedUnits2() throws Exception {
		Topology top = createTopologyWithTwoHosteeUnits("testCollocatedUnits2",
				true, 2, 2);
		validate(top);
		assertHasNoErrorStatus(top);

		// Test collocation (should be OK)
		CollocationConstraint c = createHosteeBundleCollocationConstraint(top);
		validate(top);
		assertHasNoErrorStatus(top);

		// Test anti-collocation (should produce error)
		c.setType(CollocationConstraintTypes.ANTICOLLOCATION_LITERAL);
		validate(top);
		assertHasErrorStatus(top);
	}

	/**
	 * Tests collocation constraits on asymetrically collocated units (depth 1,
	 * 2)
	 * 
	 * @throws Exception
	 */
	public void testCollocatedUnits3() throws Exception {
		Topology top = createTopologyWithTwoHosteeUnits("testCollocatedUnits2",
				true, 1, 2);
		validate(top);
		assertHasNoErrorStatus(top);

		// Test collocation (should produce OK)
		CollocationConstraint c = createHosteeBundleCollocationConstraint(top);
		validate(top);
		assertHasNoErrorStatus(top);

		// Test anti-collocation (should produce error)
		c.setType(CollocationConstraintTypes.ANTICOLLOCATION_LITERAL);
		validate(top);
		assertHasErrorStatus(top);
	}

	/**
	 * Tests collocation constraits on immediatelly non-collocated units (depth
	 * 0)
	 * 
	 * @throws Exception
	 */
	public void testNonCollocatedUnits1() throws Exception {
		Topology top = createTopologyWithTwoHosteeUnits(
				"testNonCollocatedUnits1", false, 0, 0);
		validate(top);
		assertHasNoErrorStatus(top);

		// Test collocation (should produce error)
		CollocationConstraint c = createHosteeBundleCollocationConstraint(top);
		validate(top);
		assertHasErrorStatus(top);

		// Test anti-collocation (should be OK)
		c.setType(CollocationConstraintTypes.ANTICOLLOCATION_LITERAL);
		validate(top);
		assertHasNoErrorStatus(top);
	}

	/**
	 * Tests collocation constraits on indirectly non-collocated units (depth 2)
	 * 
	 * @throws Exception
	 */
	public void testNonCollocatedUnits2() throws Exception {
		Topology top = createTopologyWithTwoHosteeUnits(
				"testNonCollocatedUnits2", false, 2, 2);
		validate(top);
		assertHasNoErrorStatus(top);

		// Test collocation (should be error)
		CollocationConstraint c = createHosteeBundleCollocationConstraint(top);
		validate(top);
		assertHasErrorStatus(top);

		// Test anti-collocation (should be OK)
		c.setType(CollocationConstraintTypes.ANTICOLLOCATION_LITERAL);
		validate(top);
		assertHasNoErrorStatus(top);
	}

	/**
	 * Tests collocation constraits on asymetrically non-collocated units (depth
	 * 1, 2)
	 * 
	 * @throws Exception
	 */
	public void testNonCollocatedUnits3() throws Exception {
		Topology top = createTopologyWithTwoHosteeUnits(
				"testNonCollocatedUnits2", false, 1, 2);
		validate(top);
		assertHasNoErrorStatus(top);

		// Test collocation (should produce error)
		CollocationConstraint c = createHosteeBundleCollocationConstraint(top);
		validate(top);
		assertHasErrorStatus(top);

		// Test anti-collocation (should be OK)
		c.setType(CollocationConstraintTypes.ANTICOLLOCATION_LITERAL);
		validate(top);
		assertHasNoErrorStatus(top);
	}

	/**
	 * Test serialization and deserialization of
	 * {@link CollocationConstraint#getCapabilityType()}
	 * 
	 * @throws Exception
	 */
	public void testCollocationConstraintSerialization() throws Exception {
		Topology top = createTopologyWithTwoHosteeUnits(
				"testCollocationConstraintSerialization", true, 2, 2);
		CollocationConstraint c = createHosteeBundleCollocationConstraint(top);
		assertEquals(CorePackage.Literals.BUNDLE_CAPABILITY, c
				.getCapabilityEType());
		validate(top);
		assertHasNoErrorStatus(top);

		// Serialize & deserialize
		top = reload(top, true);
		c = (CollocationConstraint) top.resolve(c.getFullPath());
		assertEquals(CorePackage.Literals.BUNDLE_CAPABILITY, c
				.getCapabilityEType());

		validate(top);
		assertHasNoErrorStatus(top);
	}

	/**
	 * Tests deferred hosting on immediatelly collocated units (depth 0)
	 * 
	 * @throws Exception
	 */
	public void testDeferredHosting1() throws Exception {
		Topology top = createTopologyWithTwoHosteeUnits("testDeferredHosting1",
				false, 0, 0);
		validate(top);
		assertHasNoErrorStatus(top);

		// Test deferred hosting between hostee1 and final1 (should be OK)
		DeferredHostingConstraint c = createHosteeBundleDeferredHostingConstraint(
				top, "hostee1", "final1");
		validate(top);
		assertHasNoErrorStatus(top);

		// Test deferred hosting between hostee2 and final2 (should be error)
		DeferredHostingConstraint c2 = createHosteeBundleDeferredHostingConstraint(
				top, "hostee1", "final2");
		validate(top);
		assertHasErrorStatus(top);
	}

	/**
	 * Tests deferred hosting on indirectly collocated units (depth 2)
	 * 
	 * @throws Exception
	 */
	public void testDeferredHosting2() throws Exception {
		Topology top = createTopologyWithTwoHosteeUnits("testDeferredHosting2",
				false, 2, 2);
		validate(top);
		assertHasNoErrorStatus(top);

		// Test deferred hosting between hostee1 and final1 (should be OK)
		DeferredHostingConstraint c = createHosteeBundleDeferredHostingConstraint(
				top, "hostee1", "final1");
		validate(top);
		assertHasNoErrorStatus(top);

		// Test deferred hosting between hostee2 and final2 (should be error)
		DeferredHostingConstraint c2 = createHosteeBundleDeferredHostingConstraint(
				top, "hostee1", "final2");
		validate(top);
		assertHasErrorStatus(top);
	}

	/**
	 * Tests deferred hosting on asymetrically collocated units (depth 1, 2)
	 * 
	 * @throws Exception
	 */
	public void testDeferredHosting3() throws Exception {
		Topology top = createTopologyWithTwoHosteeUnits("testDeferredHosting3",
				false, 1, 2);
		validate(top);
		assertHasNoErrorStatus(top);

		// Test deferred hosting between hostee1 and final1 (should be OK)
		DeferredHostingConstraint c = createHosteeBundleDeferredHostingConstraint(
				top, "hostee1", "final1");
		validate(top);
		assertHasNoErrorStatus(top);

		// Test deferred hosting between hostee2 and final2 (should be error)
		DeferredHostingConstraint c2 = createHosteeBundleDeferredHostingConstraint(
				top, "hostee1", "final2");
		validate(top);
		assertHasErrorStatus(top);
	}

}
