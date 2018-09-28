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
import java.util.Set;

import junit.framework.TestSuite;

import org.eclipse.emf.ecore.EClass;

import com.ibm.ccl.soa.deploy.core.Capability;
import com.ibm.ccl.soa.deploy.core.CapabilityLinkTypes;
import com.ibm.ccl.soa.deploy.core.CoreFactory;
import com.ibm.ccl.soa.deploy.core.CorePackage;
import com.ibm.ccl.soa.deploy.core.DeployModelObject;
import com.ibm.ccl.soa.deploy.core.RealizationLink;
import com.ibm.ccl.soa.deploy.core.Requirement;
import com.ibm.ccl.soa.deploy.core.RequirementLinkTypes;
import com.ibm.ccl.soa.deploy.core.Topology;
import com.ibm.ccl.soa.deploy.core.Unit;
import com.ibm.ccl.soa.deploy.core.test.TopologyTestCase;
import com.ibm.ccl.soa.deploy.core.util.RealizationLinkUtil;
import com.ibm.ccl.soa.deploy.core.validator.ValidatorUtils;
import com.ibm.ccl.soa.deploy.core.validator.matcher.LinkDescriptor;
import com.ibm.ccl.soa.deploy.core.validator.matcher.LinkFactory;
import com.ibm.ccl.soa.deploy.core.validator.matcher.LinkType;

public class RealizationUtilTest extends TopologyTestCase {

	private static final String PROJECT_NAME = "RealizationUtilTest";

	EClass CAPABILITY = CorePackage.Literals.CAPABILITY;
	EClass REQUIREMENT = CorePackage.Literals.REQUIREMENT;

	public RealizationUtilTest() {
		super(PROJECT_NAME);
	}

	public RealizationUtilTest(String name) {
		super(name);
	}

	public static TestSuite suite() {
		TestSuite suite = new TestSuite();
		//suite.addTest(new RealizationUtilTest("testHostsR"));
		suite.addTestSuite(RealizationUtilTest.class);
		return suite;
	}

	/**
	 * Test the handling of a realization cycle of length 1.
	 * @throws IOException
	 */
	public void testRealizationTrivialCycle() throws IOException {
		Topology top = createTopology("testRealizationTrivialCycle");
		Unit u1 = addUnit(top, "u1");
		u1.setConceptual(true);
		Capability c1 = addCapability(u1, "c1", CapabilityLinkTypes.ANY_LITERAL);
		Requirement r1 = addRequirement(u1, "r1",
				RequirementLinkTypes.ANY_LITERAL);

		// Add unit self realization loop link
		RealizationLink uLink = LinkFactory.createRealizationLink(u1, u1);
		Unit[] unitRealizations = RealizationLinkUtil.getRealizations(u1);
		assertEquals(1, unitRealizations.length);
		assertEquals(u1, unitRealizations[0]);
		assertEquals(u1, RealizationLinkUtil.getRealizations(u1)[0]);
		assertEquals(0, RealizationLinkUtil.getRealizations(c1).length);
		assertEquals(0, RealizationLinkUtil.getRealizations(r1).length);

		assertSetEquals(RealizationLinkUtil.getRealizes(u1),
				new Object[] { u1 });
		assertSetEquals(RealizationLinkUtil.getRealizes(c1), null);
		assertSetEquals(RealizationLinkUtil.getRealizes(r1), null);

		assertEquals(u1, RealizationLinkUtil.getFinalRealization(u1));
		assertEquals(c1, RealizationLinkUtil.getFinalRealization(c1));
		assertEquals(r1, RealizationLinkUtil.getFinalRealization(r1));

		assertEquals(u1, RealizationLinkUtil.getFinalRealization(u1));
		assertEquals(c1, RealizationLinkUtil.getFinalRealization(c1));
		assertEquals(r1, RealizationLinkUtil.getFinalRealization(r1));

		assertSetEquals(RealizationLinkUtil.getAllRealizationLinkedObjects(u1),
				new Object[] { u1 });
		assertSetEquals(RealizationLinkUtil.getAllRealizationLinkedObjects(c1),
				new Object[] { c1 });
		assertSetEquals(RealizationLinkUtil.getAllRealizationLinkedObjects(r1),
				new Object[] { r1 });

		// Add capability realization self-loop link
		RealizationLink cLink = LinkFactory.createRealizationLink(c1, c1);

		unitRealizations = RealizationLinkUtil.getRealizations(u1);
		Capability[] capRealizations = RealizationLinkUtil.getRealizations(c1);
		assertEquals(1, unitRealizations.length);
		assertEquals(u1, unitRealizations[0]);
		assertEquals(1, capRealizations.length);
		assertEquals(c1, capRealizations[0]);
		assertEquals(0, RealizationLinkUtil.getRealizations(r1).length);

		assertSetEquals(RealizationLinkUtil.getRealizes(u1),
				new Object[] { u1 });
		assertSetEquals(RealizationLinkUtil.getRealizes(c1),
				new Object[] { c1 });
		assertSetEquals(RealizationLinkUtil.getRealizes(r1), null);

		assertEquals(u1, RealizationLinkUtil.getFinalRealization(u1));
		assertEquals(c1, RealizationLinkUtil.getFinalRealization(c1));
		assertEquals(r1, RealizationLinkUtil.getFinalRealization(r1));

		assertEquals(u1, RealizationLinkUtil.getFinalRealization(u1));
		assertEquals(c1, RealizationLinkUtil.getFinalRealization(c1));
		assertEquals(r1, RealizationLinkUtil.getFinalRealization(r1));

		assertSetEquals(RealizationLinkUtil.getAllRealizationLinkedObjects(u1),
				new Object[] { u1 });
		assertSetEquals(RealizationLinkUtil.getAllRealizationLinkedObjects(c1),
				new Object[] { c1 });
		assertSetEquals(RealizationLinkUtil.getAllRealizationLinkedObjects(r1),
				new Object[] { r1 });

		// Add requirement realization self-loop link
		RealizationLink rLink = LinkFactory.createRealizationLink(r1, r1);
		
		unitRealizations = RealizationLinkUtil.getRealizations(u1);
		capRealizations = RealizationLinkUtil.getRealizations(c1);
		Requirement[] reqRealizations = RealizationLinkUtil.getRealizations(r1);

		assertEquals(1, unitRealizations.length);
		assertEquals(1, capRealizations.length);
		assertEquals(1, reqRealizations.length);
		assertEquals(u1, unitRealizations[0]);
		assertEquals(c1, capRealizations[0]);
		assertEquals(r1, reqRealizations[0]);

		assertSetEquals(RealizationLinkUtil.getRealizes(u1),
				new Object[] { u1 });
		assertSetEquals(RealizationLinkUtil.getRealizes(c1),
				new Object[] { c1 });
		assertSetEquals(RealizationLinkUtil.getRealizes(r1),
				new Object[] { r1 });

		assertEquals(u1, RealizationLinkUtil.getFinalRealization(u1));
		assertEquals(c1, RealizationLinkUtil.getFinalRealization(c1));
		assertEquals(r1, RealizationLinkUtil.getFinalRealization(r1));

		assertEquals(u1, RealizationLinkUtil.getFinalRealization(u1));
		assertEquals(c1, RealizationLinkUtil.getFinalRealization(c1));
		assertEquals(r1, RealizationLinkUtil.getFinalRealization(r1));

		assertSetEquals(RealizationLinkUtil.getAllRealizationLinkedObjects(u1),
				new Object[] { u1 });
		assertSetEquals(RealizationLinkUtil.getAllRealizationLinkedObjects(c1),
				new Object[] { c1 });
		assertSetEquals(RealizationLinkUtil.getAllRealizationLinkedObjects(r1),
				new Object[] { r1 });

	}

	public void testRealization() throws IOException {
		Topology top = createTopology("testRealization");
		// RealizationContext context = new RealizationContext (top);

		Unit[] c1 = createChainRealizedUnits(top, "1unit", 1);
		// dumpUnits(c1, "c1"); 
		assertEquals(0, RealizationLinkUtil.getRealizations(c1[0]).length); // ,
																	// context));
		assert (c1[0] == RealizationLinkUtil.getFinalRealization(c1[0])); // ,
																			// context));
// dumpAllRealizations(context);

		Capability cap1_0 = ValidatorUtils
				.getFirstCapability(c1[0], CAPABILITY);
		assertEquals(0, RealizationLinkUtil.getRealizations(cap1_0).length); // ,
																		// context));
		assert (cap1_0 == RealizationLinkUtil.getFinalRealization(cap1_0)); // ,
																			// context));

		Requirement req1_0 = ValidatorUtils.getFirstRequirement(c1[0],
				CAPABILITY);
		assertEquals(0, RealizationLinkUtil.getRealizations(req1_0).length); // ,
																		// context));
		assert (req1_0 == RealizationLinkUtil.getFinalRealization(req1_0)); // ,
																			// context));

		assertSetEquals(RealizationLinkUtil.getRealizes(c1[0]), new Object[] {});
		assertSetEquals(RealizationLinkUtil.getRealizes(cap1_0),
				new Object[] {});
		assertSetEquals(RealizationLinkUtil.getRealizes(req1_0),
				new Object[] {});

		assertSetEquals(RealizationLinkUtil
				.getAllRealizationLinkedObjects(c1[0]), c1);

		createAndCheckForCycleBehavior(c1, false);

		Unit[] c2 = createChainRealizedUnits(top, "2unit", 2);
		// dumpUnits(c2, "c2");
		Unit[] realizations = RealizationLinkUtil.getRealizations(c2[0]);
		assert (c2[1] == realizations[0]); // ,
																		// context));
		assert (c2[1] == RealizationLinkUtil.getFinalRealization(c2[0])); // ,
																			// context));
		assertEquals(0, RealizationLinkUtil.getRealizations(c2[1]).length); // ,
																	// context));
		assert (c2[1] == RealizationLinkUtil.getFinalRealization(c2[1])); // ,
																			// context));
// dumpAllRealizations(context);

		Capability cap2_0 = ValidatorUtils
				.getFirstCapability(c2[0], CAPABILITY);
		Capability cap2_1 = ValidatorUtils
				.getFirstCapability(c2[1], CAPABILITY);
		assert (cap2_1 == RealizationLinkUtil.getRealizations(cap2_0)[0]); // ,
																		// context));
		assert (cap2_1 == RealizationLinkUtil.getFinalRealization(cap2_0)); // ,
																			// context));
		assert (0 == RealizationLinkUtil.getRealizations(cap2_1).length); // ,
																		// context));
		assert (cap2_1 == RealizationLinkUtil.getFinalRealization(cap2_1)); // ,
																			// context));

		Requirement req2_0 = ValidatorUtils.getFirstRequirement(c2[0],
				CAPABILITY);
		Requirement req2_1 = ValidatorUtils.getFirstRequirement(c2[1],
				CAPABILITY);
		assert (req2_1 == RealizationLinkUtil.getRealizations(req2_0)[0]); // ,
																		// context));
		assert (req2_1 == RealizationLinkUtil.getFinalRealization(req2_0)); // ,
																			// context));
		assert (0 == RealizationLinkUtil.getRealizations(req2_1).length); // ,
																		// context));
		assert (req2_1 == RealizationLinkUtil.getFinalRealization(req2_1)); // ,
																			// context));

		assertSetEquals(RealizationLinkUtil.getRealizes(c2[1]),
				new Object[] { c2[0] });
		assertSetEquals(RealizationLinkUtil.getRealizes(cap2_1),
				new Object[] { cap2_0 });
		assertSetEquals(RealizationLinkUtil.getRealizes(req2_1),
				new Object[] { req2_0 });

		assertSetEquals(RealizationLinkUtil
				.getAllRealizationLinkedObjects(c2[0]), c2);
		assertSetEquals(RealizationLinkUtil
				.getAllRealizationLinkedObjects(c2[1]), c2);

		createAndCheckForCycleBehavior(c2, false);

		Unit[] c3 = createChainRealizedUnits(top, "3unit", 3);
		// dumpUnits(c3, "c3");
		assert (c3[1] == RealizationLinkUtil.getRealizations(c3[0])[0]); // ,
																		// context));
		assert (c3[2] == RealizationLinkUtil.getFinalRealization(c3[0])); // ,
																			// context));
		assert (c3[2] == RealizationLinkUtil.getRealizations(c3[1])[0]); // ,
																		// context));
		assert (c3[2] == RealizationLinkUtil.getFinalRealization(c3[1])); // ,
																			// context));
		assert (0 == RealizationLinkUtil.getRealizations(c3[2]).length); // ,
																	// context));
		assert (c3[2] == RealizationLinkUtil.getFinalRealization(c3[2])); // ,
																			// context));
// dumpAllRealizations(context);

		Capability cap3_0 = ValidatorUtils
				.getFirstCapability(c3[0], CAPABILITY);
		Capability cap3_1 = ValidatorUtils
				.getFirstCapability(c3[1], CAPABILITY);
		Capability cap3_2 = ValidatorUtils
				.getFirstCapability(c3[2], CAPABILITY);
		assert (cap3_1 == RealizationLinkUtil.getRealizations(cap3_0)[0]); // ,
																		// context));
		assert (cap3_2 == RealizationLinkUtil.getFinalRealization(cap3_0)); // ,
																			// context));
		assert (cap3_2 == RealizationLinkUtil.getRealizations(cap3_1)[0]); // ,
																		// context));
		assert (cap3_2 == RealizationLinkUtil.getFinalRealization(cap3_1)); // ,
																			// context));
		assert (0 == RealizationLinkUtil.getRealizations(cap3_2).length); // ,
																		// context));
		assert (cap3_2 == RealizationLinkUtil.getFinalRealization(cap3_2)); // ,
																			// context));

		Requirement req3_0 = ValidatorUtils.getFirstRequirement(c3[0],
				CAPABILITY);
		Requirement req3_1 = ValidatorUtils.getFirstRequirement(c3[1],
				CAPABILITY);
		Requirement req3_2 = ValidatorUtils.getFirstRequirement(c3[2],
				CAPABILITY);
		assert (req3_1 == RealizationLinkUtil.getRealizations(req3_0)[0]); // ,
																		// context));
		assert (req3_2 == RealizationLinkUtil.getFinalRealization(req3_0)); // ,
																			// context));
		assert (req3_2 == RealizationLinkUtil.getRealizations(req3_1)[0]); // ,
																		// context));
		assert (req3_2 == RealizationLinkUtil.getFinalRealization(req3_1)); // ,
																			// context));
		assert (0 == RealizationLinkUtil.getRealizations(req3_2).length); // ,
																		// context));
		assert (req3_2 == RealizationLinkUtil.getFinalRealization(req3_2)); // ,
																			// context));

		assertSetEquals(RealizationLinkUtil.getRealizes(c3[1]),
				new Object[] { c3[0] });
		assertSetEquals(RealizationLinkUtil.getRealizes(c3[2]),
				new Object[] { c3[1] });
		assertSetEquals(RealizationLinkUtil.getRealizes(cap3_1),
				new Object[] { cap3_0 });
		assertSetEquals(RealizationLinkUtil.getRealizes(cap3_2),
				new Object[] { cap3_1 });
		assertSetEquals(RealizationLinkUtil.getRealizes(req3_2),
				new Object[] { req3_1 });

		assertSetEquals(RealizationLinkUtil.getRealizes(c3[1]),
				new Object[] { c3[0] });
		assertSetEquals(RealizationLinkUtil.getRealizes(c3[2]),
				new Object[] { c3[1] });
		assertSetEquals(RealizationLinkUtil.getRealizes(cap3_1),
				new Object[] { cap3_0 });
		assertSetEquals(RealizationLinkUtil.getRealizes(cap3_2),
				new Object[] { cap3_1 });
		assertSetEquals(RealizationLinkUtil.getRealizes(req3_1),
				new Object[] { req3_0 });
		assertSetEquals(RealizationLinkUtil.getRealizes(req3_2),
				new Object[] { req3_1 });

		assertSetEquals(RealizationLinkUtil
				.getAllRealizationLinkedObjects(c3[0]), c3);
		assertSetEquals(RealizationLinkUtil
				.getAllRealizationLinkedObjects(c3[1]), c3);
		assertSetEquals(RealizationLinkUtil
				.getAllRealizationLinkedObjects(c3[2]), c3);

		createAndCheckForCycleBehavior(c3, false);
	}

	public void testImplicitUnitRealization() throws IOException {
		internalTestImplicitRealization(REALIZE_UNIT);
	}

	public void testImplicitCapabilityRealization() throws IOException {
		internalTestImplicitRealization(REALIZE_CAPABILITY);
	}

	public void testImplicitRequirementRealization() throws IOException {
		internalTestImplicitRealization(REALIZE_REQUIREMENT);
	}

	/**
	 * Test implicit realization.
	 * 
	 * @param mask
	 *            the realization mask {@link #REALIZE_UNIT},
	 *            {@link #REALIZE_CAPABILITY}, {@link #REALIZE_REQUIREMENT}
	 */
	public void internalTestImplicitRealization(int mask) throws IOException {
		Topology top = createTopology("testImplicitRealization-" + mask);
		// RealizationContext context = new RealizationContext (top);

		Unit[] c1 = createChainRealizedUnits(top, "1unit", 1, mask);
		// dumpUnits(c1, "c1");
		assert (RealizationLinkUtil.getImplicitRealizations(c1[0]).length == 0); // ,
																			// context));
		assert (c1[0] == RealizationLinkUtil.getImplicitFinalRealization(c1[0])); // ,
																					// context));
// dumpAllRealizations(context);

		Capability cap1_0 = ValidatorUtils
				.getFirstCapability(c1[0], CAPABILITY);
		assert (RealizationLinkUtil.getImplicitRealizations(cap1_0).length == 0); // ,
																				// context));
		assert (cap1_0 == RealizationLinkUtil
				.getImplicitFinalRealization(cap1_0)); // , context));

		Requirement req1_0 = ValidatorUtils.getFirstRequirement(c1[0],
				CAPABILITY);
		assert (RealizationLinkUtil.getImplicitRealizations(req1_0).length == 0); // ,
																				// context));
		assert (req1_0 == RealizationLinkUtil
				.getImplicitFinalRealization(req1_0)); // , context));

		assertSetEquals(RealizationLinkUtil.getImplicitRealizes(c1[0]),
				new Object[] {});
		assertSetEquals(RealizationLinkUtil.getImplicitRealizes(cap1_0),
				new Object[] {});
		assertSetEquals(RealizationLinkUtil.getImplicitRealizes(req1_0),
				new Object[] {});

		assertSetEquals(RealizationLinkUtil
				.getAllImplicitRealizationLinkedObjects(c1[0]), c1);

		createAndCheckForCycleBehavior(c1, true);

		Unit[] c2 = createChainRealizedUnits(top, "2unit", 2, mask);
		assert (c2[1] == RealizationLinkUtil.getImplicitRealizations(c2[0])[0]);
		assert (c2[1] == RealizationLinkUtil.getImplicitFinalRealization(c2[0]));
		assert (0 == RealizationLinkUtil.getImplicitRealizations(c2[1]).length);
		assert (c2[1] == RealizationLinkUtil.getImplicitFinalRealization(c2[1]));

		Capability cap2_0 = ValidatorUtils
				.getFirstCapability(c2[0], CAPABILITY);
		Capability cap2_1 = ValidatorUtils
				.getFirstCapability(c2[1], CAPABILITY);
		assertEquals(cap2_1, RealizationLinkUtil.getImplicitRealizations(cap2_0)[0]);
		assert (cap2_1 == RealizationLinkUtil
				.getImplicitFinalRealization(cap2_0));
		assert (0 == RealizationLinkUtil.getImplicitRealizations(cap2_1).length);
		assert (cap2_1 == RealizationLinkUtil
				.getImplicitFinalRealization(cap2_1));

		Requirement req2_0 = ValidatorUtils.getFirstRequirement(c2[0],
				CAPABILITY);
		Requirement req2_1 = ValidatorUtils.getFirstRequirement(c2[1],
				CAPABILITY);
		assert (req2_1 == RealizationLinkUtil.getImplicitRealizations(req2_0)[0]);
		assert (req2_1 == RealizationLinkUtil
				.getImplicitFinalRealization(req2_0));
		assert (0 == RealizationLinkUtil.getImplicitRealizations(req2_1).length);
		assert (req2_1 == RealizationLinkUtil
				.getImplicitFinalRealization(req2_1));

		assertSetEquals(RealizationLinkUtil.getImplicitRealizes(c2[1]),
				new Object[] { c2[0] });
		assertSetEquals(RealizationLinkUtil.getImplicitRealizes(cap2_1),
				new Object[] { cap2_0 });
		assertSetEquals(RealizationLinkUtil.getImplicitRealizes(req2_1),
				new Object[] { req2_0 });

		assertSetEquals(RealizationLinkUtil
				.getAllImplicitRealizationLinkedObjects(c2[0]), c2);
		assertSetEquals(RealizationLinkUtil
				.getAllImplicitRealizationLinkedObjects(c2[1]), c2);

		createAndCheckForCycleBehavior(c2, true);

		Unit[] c3 = createChainRealizedUnits(top, "3unit", 3, mask);
		assert (c3[1] == RealizationLinkUtil.getImplicitRealizations(c3[0])[0]);
		assert (c3[2] == RealizationLinkUtil.getImplicitFinalRealization(c3[0]));
		assert (c3[2] == RealizationLinkUtil.getImplicitRealizations(c3[1])[0]);
		assert (c3[2] == RealizationLinkUtil.getImplicitFinalRealization(c3[1]));
		assert (0 == RealizationLinkUtil.getImplicitRealizations(c3[2]).length);
		assert (c3[2] == RealizationLinkUtil.getImplicitFinalRealization(c3[2]));

		Capability cap3_0 = ValidatorUtils
				.getFirstCapability(c3[0], CAPABILITY);
		Capability cap3_1 = ValidatorUtils
				.getFirstCapability(c3[1], CAPABILITY);
		Capability cap3_2 = ValidatorUtils
				.getFirstCapability(c3[2], CAPABILITY);
		assert (cap3_1 == RealizationLinkUtil.getImplicitRealizations(cap3_0)[0]);
		assert (cap3_2 == RealizationLinkUtil
				.getImplicitFinalRealization(cap3_0));
		assert (cap3_2 == RealizationLinkUtil.getImplicitRealizations(cap3_1)[0]);
		assert (cap3_2 == RealizationLinkUtil
				.getImplicitFinalRealization(cap3_1));
		assert (0 == RealizationLinkUtil.getImplicitRealizations(cap3_2).length);
		assert (cap3_2 == RealizationLinkUtil
				.getImplicitFinalRealization(cap3_2));

		Requirement req3_0 = ValidatorUtils.getFirstRequirement(c3[0],
				CAPABILITY);
		Requirement req3_1 = ValidatorUtils.getFirstRequirement(c3[1],
				CAPABILITY);
		Requirement req3_2 = ValidatorUtils.getFirstRequirement(c3[2],
				CAPABILITY);
		assert (req3_1 == RealizationLinkUtil.getImplicitRealizations(req3_0)[0]);
		assert (req3_2 == RealizationLinkUtil
				.getImplicitFinalRealization(req3_0));
		assert (req3_2 == RealizationLinkUtil.getImplicitRealizations(req3_1)[0]);
		assert (req3_2 == RealizationLinkUtil
				.getImplicitFinalRealization(req3_1));
		assert (0 == RealizationLinkUtil.getImplicitRealizations(req3_2).length);
		assert (req3_2 == RealizationLinkUtil
				.getImplicitFinalRealization(req3_2));

		assertSetEquals(RealizationLinkUtil.getImplicitRealizes(c3[1]),
				new Object[] { c3[0] });
		assertSetEquals(RealizationLinkUtil.getImplicitRealizes(c3[2]),
				new Object[] { c3[1] });
		assertSetEquals(RealizationLinkUtil.getImplicitRealizes(cap3_1),
				new Object[] { cap3_0 });
		assertSetEquals(RealizationLinkUtil.getImplicitRealizes(cap3_2),
				new Object[] { cap3_1 });
		assertSetEquals(RealizationLinkUtil.getImplicitRealizes(req3_2),
				new Object[] { req3_1 });

		assertSetEquals(RealizationLinkUtil.getImplicitRealizes(c3[1]),
				new Object[] { c3[0] });
		assertSetEquals(RealizationLinkUtil.getImplicitRealizes(c3[2]),
				new Object[] { c3[1] });
		assertSetEquals(RealizationLinkUtil.getImplicitRealizes(cap3_1),
				new Object[] { cap3_0 });
		assertSetEquals(RealizationLinkUtil.getImplicitRealizes(cap3_2),
				new Object[] { cap3_1 });
		assertSetEquals(RealizationLinkUtil.getImplicitRealizes(req3_1),
				new Object[] { req3_0 });
		assertSetEquals(RealizationLinkUtil.getImplicitRealizes(req3_2),
				new Object[] { req3_1 });

		assertSetEquals(RealizationLinkUtil
				.getAllImplicitRealizationLinkedObjects(c3[0]), c3);
		assertSetEquals(RealizationLinkUtil
				.getAllImplicitRealizationLinkedObjects(c3[1]), c3);
		assertSetEquals(RealizationLinkUtil
				.getAllImplicitRealizationLinkedObjects(c3[2]), c3);

		createAndCheckForCycleBehavior(c3, true);
	}

	public void testHostsR() throws IOException {
		Topology t = createTopology("testRealizationUtilHostR");
// RealizationContext context = new RealizationContext (t);
		Unit[] hostees = createChainRealizedUnits(t, "hostee", 3);
// dumpRealizations(hostees[0], context);
// dumpRealizations(hostees[2], context);
		for (int i = 0; i < hostees.length; i++) {
			Unit[] hosts = createChainRealizedUnits(t, "host" + i + "_", i + 1);
			LinkFactory.createHostingLink(hosts[0], hostees[i]);
// dumpAllRealizations(context);
// Set hostR = RealizationLinkUtil.getHostR(hostees[0], context);
// dumpSet (hostR);
// System.out.println (RealizationLinkUtil.getHostR(hostees[0],
// context).size());
			assert i + 1 == ValidatorUtils.getAllHosts(hostees[0]).size(); // ,
																			// context).size();
		}
	}

	public void testTargetR() throws IOException {
		Topology t = createTopology("testRealizationUtilTargetR");
// RealizationContext context = new RealizationContext (t);
		Unit[] sources = createChainRealizedUnits(t, "source", 3);
		for (int i = 0; i < sources.length; i++) {
			Unit[] targets = createChainRealizedUnits(t, "target" + i + "_",
					i + 1);
// dumpUnits(sources, "sources");
// System.out.println ("sources[i] = " + sources[i].getName());
// System.out.println ("sources[i].req = " +
// ValidatorUtils.getFirstRequirement(sources[i], CAPABILITY).getName());
// System.out.println ("targets[0] = " + targets[i].getName());
// System.out.println ("targets[0].cap = " +
// ValidatorUtils.getFirstCapability(targets[0], CAPABILITY).getName());
			LinkFactory.createDependencyLink(sources[i], ValidatorUtils
					.getFirstRequirement(sources[i], CAPABILITY), targets[0],
					ValidatorUtils.getFirstCapability(targets[0], CAPABILITY));
// Set targetsR =
// RealizationLinkUtil.getTargetR(ValidatorUtils.getFirstRequirement(sources[0],
// CAPABILITY), context);
// dumpSet (targetsR);
// System.out.println
// (RealizationLinkUtil.getTargetR(ValidatorUtils.getFirstRequirement(sources[0],
// CAPABILITY), context).size());
			assert i + 1 == ValidatorUtils.getDependencyLinkTargets(
					ValidatorUtils.getFirstRequirement(sources[0], CAPABILITY))
					.size(); // , context).size();
		}
	}

	public void testGroupsR() throws IOException {
		Topology t = createTopology("testRealizationUtilGroupsR");
// RealizationContext context = new RealizationContext (t);
		Unit[] members = createChainRealizedUnits(t, "member", 3);
		for (int i = 0; i < members.length; i++) {
			Unit[] groups = createChainRealizedUnits(t, "group" + i + "_",
					i + 1);
			LinkFactory.createMemberLink(groups[0], members[i]);
// Set groupsR = RealizationLinkUtil.getGroupsR(members[0], context);
// dumpSet (groupsR);
			assert i + 1 == ValidatorUtils.getGroups(members[0]).size(); // ,
																			// context).size();
		}
	}

	public void testMembersR() throws IOException {
		Topology t = createTopology("testRealizationUtilMembersR");
// RealizationContext context = new RealizationContext (t);
		Unit[] groups = createChainRealizedUnits(t, "group", 3);
		for (int i = 0; i < groups.length; i++) {
			Unit[] members = createChainRealizedUnits(t, "member" + i + "_",
					i + 1);
			LinkFactory.createMemberLink(groups[i], members[0]);
// Set membersR = RealizationLinkUtil.getMembersR(groups[0], context);
// dumpSet (membersR);
			assert i + 1 == ValidatorUtils.getMembers(groups[0]).size(); // ,
																			// context).size();
		}
	}

	public static final int REALIZE_UNIT = 2;
	public static final int REALIZE_REQUIREMENT = 4;
	public static final int REALIZE_CAPABILITY = 6;

	private Unit[] createChainRealizedUnits(Topology t, String prefix,
			int numUnits) {
		return createChainRealizedUnits(t, prefix, numUnits, REALIZE_UNIT
				| REALIZE_REQUIREMENT | REALIZE_CAPABILITY);
	}

	/**
	 * 
	 * @param t
	 * @param prefix
	 * @param numUnits
	 * @param mask
	 *            the realization mask {@link #REALIZE_UNIT},
	 *            {@link #REALIZE_CAPABILITY}, {@link #REALIZE_REQUIREMENT}
	 * @return
	 */
	private Unit[] createChainRealizedUnits(Topology t, String prefix,
			int numUnits, int mask) {
		assert numUnits > 0;
		assert t != null;

		Unit[] units = new Unit[numUnits];
		Capability prevCap = null;
		Requirement prevReq = null;
		for (int i = 0; i < numUnits; i++) {
			units[i] = CoreFactory.eINSTANCE.createUnit();
			units[i].setConceptual(i < numUnits - 1);
			units[i].setName(prefix + i);
			t.getUnits().add(units[i]);
			Capability c = CoreFactory.eINSTANCE.createCapability();
			c.setName(prefix + "_cap_" + i);
			units[i].getCapabilities().add(c);
			Requirement r = CoreFactory.eINSTANCE.createRequirement();
			r.setName(prefix + "_req_" + i);
			r.setDmoEType(CAPABILITY);
			units[i].getRequirements().add(r);
			if (i > 0) {
				if ((mask & REALIZE_CAPABILITY) != 0) {
					LinkFactory.createRealizationLink(prevCap, c);// , t);
				}
				if ((mask & REALIZE_REQUIREMENT) != 0) {
					LinkFactory.createRealizationLink(prevReq, r);
				}
				if ((mask & REALIZE_UNIT) != 0) {
					LinkFactory.createRealizationLink(units[i - 1], units[i]);
				}
			}
			prevCap = c;
			prevReq = r;
		}
		return units;
	}

	/**
	 * Creates a realization cycle from the last unit to the first, and tests
	 * that the methods terminate.
	 * 
	 * @param units
	 *            an array of units generated by
	 *            {@link #createChainRealizedUnits(Topology, String, int)}.
	 */
	private void createAndCheckForCycleBehavior(Unit[] units, boolean implicit) {
		assert units != null;
		assert units.length > 0;

		Unit source = units[units.length - 1];
		Unit target = units[0];
		Capability sourceCap = (Capability) source.getCapabilities().get(0);
		Capability targetCap = (Capability) target.getCapabilities().get(0);
		Requirement sourceReq = (Requirement) source.getRequirements().get(0);
		Requirement targetReq = (Requirement) target.getRequirements().get(0);

		unsafeCreateRealizationLink(sourceCap, targetCap);
		unsafeCreateRealizationLink(sourceReq, targetReq);
		unsafeCreateRealizationLink(source, target);

		if (implicit) {
			assertEquals(RealizationLinkUtil.getImplicitRealizations(source)[0],
					target);
			assertEquals(RealizationLinkUtil.getImplicitRealizations(sourceCap)[0],
					targetCap);
			assertEquals(RealizationLinkUtil.getImplicitRealizations(sourceReq)[0],
					targetReq);
		} else {
			assertEquals(RealizationLinkUtil.getRealizations(source)[0], target);
			assertEquals(RealizationLinkUtil.getRealizations(sourceCap)[0],
					targetCap);
			assertEquals(RealizationLinkUtil.getRealizations(sourceReq)[0],
					targetReq);
		}

		if (units.length > 1) {
			if (implicit) {
				assertSetEquals(
						RealizationLinkUtil.getImplicitRealizes(target),
						new Object[] { source });
				assertSetEquals(RealizationLinkUtil
						.getImplicitRealizes(targetCap),
						new Object[] { sourceCap });
				assertSetEquals(RealizationLinkUtil
						.getImplicitRealizes(targetReq),
						new Object[] { sourceReq });
			} else {
				assertSetEquals(RealizationLinkUtil.getRealizes(target),
						new Object[] { source });
				assertSetEquals(RealizationLinkUtil.getRealizes(targetCap),
						new Object[] { sourceCap });
				assertSetEquals(RealizationLinkUtil.getRealizes(targetReq),
						new Object[] { sourceReq });
			}
		}

		if (implicit) {
			assertEquals(RealizationLinkUtil
					.getImplicitFinalRealization(target), source);
			assertEquals(RealizationLinkUtil
					.getImplicitFinalRealization(targetCap), sourceCap);
			assertEquals(RealizationLinkUtil
					.getImplicitFinalRealization(targetReq), sourceReq);
		} else {
			assertEquals(RealizationLinkUtil.getFinalRealization(target),
					source);
			assertEquals(RealizationLinkUtil.getFinalRealization(targetCap),
					sourceCap);
			assertEquals(RealizationLinkUtil.getFinalRealization(targetReq),
					sourceReq);
		}
		for (int i = 0; i < units.length; i++) {
			if (implicit) {
				assertSetEquals(RealizationLinkUtil
						.getAllImplicitRealizationLinkedObjects(units[i]),
						units);
			} else {
				assertSetEquals(RealizationLinkUtil
						.getAllRealizationLinkedObjects(units[i]), units);
			}
		}
	}

	/**
	 * Creates a realization link without checking its endpoints.
	 * <p>
	 * Use for testing only!
	 * 
	 * @param source
	 *            realization source.
	 * @param target
	 *            realization target.
	 * @return the created link (already added to topology).
	 */
	public static RealizationLink unsafeCreateRealizationLink(
			DeployModelObject source, DeployModelObject target) {
		assert null != source;
		assert null != target;
		LinkDescriptor d = new LinkDescriptor(LinkType.REALIZATION, source,
				target);
		return (RealizationLink) d.create();
	}

	private void dumpUnits(Unit[] units, String comment) {
		System.out.println("UNIT LIST: " + comment);
		for (int i = 0; i < units.length; i++) {
			String unit = units[i].getName();
			unit += " [caps=(";
			for (Iterator caps = units[i].getCapabilities().iterator(); caps
					.hasNext();) {
				unit += ((Capability) caps.next()).getName() + " ";
			}
			unit += "), reqs=(";
			for (Iterator reqs = units[i].getRequirements().iterator(); reqs
					.hasNext();) {
				unit += ((Requirement) reqs.next()).getName() + " ";
			}
			unit += ")]";
			System.out.println(unit);
		}
	}

	private void dumpAllRealizations(DeployModelObject o) { // RealizationContext
															// context) {
		System.out.println("==== ALL REALIZATIONS ====");
// List links = RealizationLinkUtil.getAllRealizationLinks(context);
// for (int i = 0; i < links.size(); i++) {
		for (Iterator links = o.getEditTopology().findAllRealizationLinks(); links
				.hasNext();) {
			RealizationLink link = (RealizationLink) links.next(); // get(i);
			System.out.println(link.getName() + ": " + link.getSourceURI()
					+ " -> " + link.getTargetURI());
		}
	}
	
	private void dumpRealizations(DeployModelObject source) { // ,
		// RealizationContext
		// context) {
		if (null == source) {
			return;
		}
		System.out.println("================= realizations(" + source.getName()
				+ ")===============");

		dumpRealizations(source, 1);
	}
	
	private void dumpRealizations(DeployModelObject source, int depth) { // ,
																// RealizationContext
																// context) {
		DeployModelObject realization = source;
		DeployModelObject[] nextRealization = new DeployModelObject[0];
		while (nextRealization.length > 1) {
			nextRealization = RealizationLinkUtil.getRealizations(realization); // ,
																				// context);
			for( int i=0; i < nextRealization.length; i++) {
				for(int j=0; j < depth; j++) {
					System.out.print("\t");
				}
				System.out.println("r(" + realization.getName() + ") = " + nextRealization[i].getName());	
				dumpRealizations(nextRealization[i], depth+1);
			}			
		}
	}
	
	

	private void dumpSet(Set objects) {
		for (Iterator objs = objects.iterator(); objs.hasNext();) {
			System.out.println("   obj: "
					+ ((DeployModelObject) objs.next()).getName());
		}
	}

}
