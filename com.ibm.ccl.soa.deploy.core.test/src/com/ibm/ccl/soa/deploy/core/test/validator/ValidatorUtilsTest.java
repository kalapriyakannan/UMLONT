/*******************************************************************************
 * Copyright (c) 2003, 2007 IBM Corporation Licensed Material - Property of IBM. All rights reserved.
 *  
 * US Government Users Restricted Rights - Use, duplication or disclosure v1.0 restricted by GSA ADP
 * Schedule Contract with IBM Corp.
 * 
 * Contributors: IBM Corporation - initial API and implementation
 *******************************************************************************/

package com.ibm.ccl.soa.deploy.core.test.validator;

import junit.framework.TestSuite;

import com.ibm.ccl.soa.deploy.core.Capability;
import com.ibm.ccl.soa.deploy.core.CapabilityLinkTypes;
import com.ibm.ccl.soa.deploy.core.CoreFactory;
import com.ibm.ccl.soa.deploy.core.CorePackage;
import com.ibm.ccl.soa.deploy.core.HostingLink;
import com.ibm.ccl.soa.deploy.core.RealizationLink;
import com.ibm.ccl.soa.deploy.core.Requirement;
import com.ibm.ccl.soa.deploy.core.RequirementLinkTypes;
import com.ibm.ccl.soa.deploy.core.Topology;
import com.ibm.ccl.soa.deploy.core.Unit;
import com.ibm.ccl.soa.deploy.core.provider.discovery.TopologyDiscovererService;
import com.ibm.ccl.soa.deploy.core.test.TopologyTestCase;
import com.ibm.ccl.soa.deploy.core.util.RealizationLinkUtil;
import com.ibm.ccl.soa.deploy.core.util.TopologyUtil;
import com.ibm.ccl.soa.deploy.core.validator.ValidatorUtils;
import com.ibm.ccl.soa.deploy.core.validator.matcher.LinkFactory;

/**
 * Test class for {@link ValidatorUtils}
 */
public class ValidatorUtilsTest extends TopologyTestCase {

	public ValidatorUtilsTest() {
		super("ValidatorUtilsTest");
	}

	public ValidatorUtilsTest(String name) {
		super(name);
	}
	

	public static TestSuite suite() {
		TestSuite suite = new TestSuite();
//				suite.addTest(new ValidatorUtilsTest("testHostingMultiPathRealizationDisambiguationLinks"));
		suite.addTestSuite(ValidatorUtilsTest.class);
		return suite;
	}

	/**
	 * Tests realization link utility methods.
	 * 
	 * @see ValidatorUtils#getRealizationUnit(Unit)
	 * @see ValidatorUtils#getRealizationLink(Unit)
	 * @see ValidatorUtils#getSourceRealizationLinks(Unit)
	 * @see ValidatorUtils#getTargetRealizationLinks(Unit)
	 */
	public void testGetRealizationUnitLink() throws Exception {
		Topology top = createTopology("testGetRealizationUnitLink");

		Unit conceptualUnit = CoreFactory.eINSTANCE.createUnit();
		conceptualUnit.setName("conceptual");
		conceptualUnit.setConceptual(true);
		top.getUnits().add(conceptualUnit);

		assert ValidatorUtils.getRealizationLink(conceptualUnit) == null;
		assert ValidatorUtils.getRealizationUnit(conceptualUnit) == null;
		assert ValidatorUtils.getSourceRealizationLinks(conceptualUnit)
				.isEmpty();
		assert ValidatorUtils.getTargetRealizationLinks(conceptualUnit)
				.isEmpty();

		Unit unit = CoreFactory.eINSTANCE.createUnit();
		unit.setName("unit");
		top.getUnits().add(unit);

		assert ValidatorUtils.getRealizationLink(conceptualUnit) == null;
		assert ValidatorUtils.getRealizationUnit(conceptualUnit) == null;
		assert ValidatorUtils.getSourceRealizationLinks(conceptualUnit)
				.isEmpty();
		assert ValidatorUtils.getTargetRealizationLinks(conceptualUnit)
				.isEmpty();
		assert ValidatorUtils.getRealizationLink(unit) == null;
		assert ValidatorUtils.getRealizationUnit(unit) == null;
		assert ValidatorUtils.getSourceRealizationLinks(unit).isEmpty();
		assert ValidatorUtils.getTargetRealizationLinks(unit).isEmpty();

		RealizationLink link = CoreFactory.eINSTANCE.createRealizationLink();
		link.setName("link1");
		link.setSource(conceptualUnit);
		link.setTarget(unit);
		top.getRealizationLinks().add(link);

		assert ValidatorUtils.getRealizationLink(conceptualUnit) != null;
		assert ValidatorUtils.getRealizationUnit(conceptualUnit) == unit;
		assertSetEquals(ValidatorUtils
				.getSourceRealizationLinks(conceptualUnit),
				new Object[] { link });
		assert ValidatorUtils.getTargetRealizationLinks(conceptualUnit)
				.isEmpty();
		assert ValidatorUtils.getRealizationLink(unit) == null;
		assert ValidatorUtils.getRealizationUnit(unit) == null;
		assert ValidatorUtils.getSourceRealizationLinks(unit).isEmpty();
		assertSetEquals(ValidatorUtils.getTargetRealizationLinks(unit),
				new Object[] { link });
	}

	/**
	 * Test single hosting link path realization.
	 * 
	 * @see ValidatorUtils#getAllHosts(Unit)
	 * @see ValidatorUtils#getImmediateHosts(Unit)
	 * @see ValidatorUtils#getHosted(Unit)
	 * @see ValidatorUtils#getImmediateHosted(Unit)
	 * 
	 * @throws Exception
	 */
	public void testHostingSinglePathRealization1() throws Exception {
		// u1
		//
		// cu2 u2
		Topology top = createTopology("testHostingSinglePathRealization1");

		Unit u1 = addUnit(top, "u1");
		Unit cu2 = addUnit(top, "cu2");
		cu2.setConceptual(true);
		Unit u2 = addUnit(top, "u2");

		assertSetEquals(ValidatorUtils.getAllHosts(u1), null);
		assertSetEquals(ValidatorUtils.getImmediateHosts(u1), null);
		assertSetEquals(ValidatorUtils.getImmediateHosts(cu2), null);
		assertSetEquals(TopologyUtil.getImmediateHostingLinksIn(u1), null);
		assertSetEquals(TopologyUtil.getImmediateHostingLinksIn(cu2), null);

		assertSetEquals(ValidatorUtils.getHosted(cu2), null);
		assertSetEquals(ValidatorUtils.getImmediateHosted(cu2), null);
		assertSetEquals(TopologyUtil.getImmediateHostingLinksOut(cu2), null);
		assertSetEquals(ValidatorUtils.getHosted(u2), null);
		assertSetEquals(ValidatorUtils.getImmediateHosted(u2), null);
		assertSetEquals(TopologyUtil.getImmediateHostingLinksOut(u2), null);

		// u1
		// ^
		// |h
		// |
		// cu2 u2
		HostingLink hlink = LinkFactory.createHostingLink(cu2, u1);

		assertSetEquals(ValidatorUtils.getImmediateHosts(u1),
				new Object[] { cu2 });
		assertSetEquals(ValidatorUtils.getAllHosts(u1), new Object[] { cu2 });
		assertSetEquals(ValidatorUtils.getImmediateHosts(cu2), null);
		assertSetEquals(TopologyUtil.getImmediateHostingLinksIn(cu2), null);
		assertSetEquals(ValidatorUtils.getAllHosts(cu2), null);
		assertSetEquals(ValidatorUtils.getImmediateHosts(u2), null);
		assertSetEquals(TopologyUtil.getImmediateHostingLinksOut(u2), null);
		assertSetEquals(ValidatorUtils.getAllHosts(u2), null);

		assertSetEquals(ValidatorUtils.getHosted(cu2), new Object[] { u1 });
		assertSetEquals(ValidatorUtils.getImmediateHosted(cu2),
				new Object[] { u1 });
		assertSetEquals(TopologyUtil.getImmediateHostingLinksOut(cu2),
				new Object[] { hlink });
		assertSetEquals(ValidatorUtils.getHosted(u2), null);
		assertSetEquals(ValidatorUtils.getImmediateHosted(u2), null);
		assertSetEquals(TopologyUtil.getImmediateHostingLinksIn(u1),
				new Object[] { hlink });

		// u1
		// ^
		// |h
		// |
		// cu2 --r-> u2
		LinkFactory.createRealizationLink(cu2, u2);

		assertSetEquals(ValidatorUtils.getImmediateHosts(u1),
				new Object[] { cu2 });
		assertSetEquals(ValidatorUtils.getAllHosts(u1), new Object[] { u2 });
		assertSetEquals(ValidatorUtils.getImmediateHosts(cu2), null);
		assertSetEquals(ValidatorUtils.getAllHosts(cu2), null);
		assertSetEquals(ValidatorUtils.getImmediateHosts(u2), null);
		assertSetEquals(TopologyUtil.getImmediateHostingLinksIn(u2), null);
		assertSetEquals(ValidatorUtils.getAllHosts(u2), null);

		assertSetEquals(ValidatorUtils.getHosted(cu2), new Object[] { u1 });
		assertSetEquals(ValidatorUtils.getImmediateHosted(cu2),
				new Object[] { u1 });
		assertSetEquals(TopologyUtil.getImmediateHostingLinksOut(cu2),
				new Object[] { hlink });
		assertSetEquals(ValidatorUtils.getHosted(u2), new Object[] { u1 });
		assertSetEquals(ValidatorUtils.getImmediateHosted(u2), null);
		assertSetEquals(TopologyUtil.getImmediateHostingLinksOut(u2), null);
		assertSetEquals(TopologyUtil.getImmediateHostingLinksIn(u2), null);

		assertEquals(TopologyDiscovererService.INSTANCE.findHost(u1, top), u2);
		assertUnitDescriptorListContainsUnitValues(
				TopologyDiscovererService.INSTANCE.findHosted(u2, top),
				new Object[] { u1 });
	}

	/**
	 * Test single path hosting link realization.
	 * 
	 * @see ValidatorUtils#getAllHosts(Unit)
	 * @see ValidatorUtils#getImmediateHosts(Unit)
	 * @see ValidatorUtils#getHosted(Unit)
	 * @see ValidatorUtils#getImmediateHosted(Unit)
	 * 
	 * @throws Exception
	 */
	public void testHostingSinglePathRealization2() throws Exception {
		// cu1 u1
		//           
		// u2
		Topology top = createTopology("testHostingSinglePathRealization2");

		Unit u1 = addUnit(top, "u1");
		Unit cu1 = addUnit(top, "cu2");
		cu1.setConceptual(true);
		Unit u2 = addUnit(top, "u2");

		assertSetEquals(ValidatorUtils.getImmediateHosts(u1), null);
		assertSetEquals(ValidatorUtils.getAllHosts(u1), null);
		assertSetEquals(ValidatorUtils.getImmediateHosts(cu1), null);
		assertSetEquals(ValidatorUtils.getAllHosts(cu1), null);

		assertSetEquals(ValidatorUtils.getImmediateHosted(cu1), null);
		assertSetEquals(ValidatorUtils.getHosted(cu1), null);
		assertSetEquals(ValidatorUtils.getImmediateHosted(u2), null);
		assertSetEquals(ValidatorUtils.getHosted(u2), null);

		// cu1 u1
		// ^
		// |h
		// |
		// u2
		LinkFactory.createHostingLink(u2, cu1);

		assertSetEquals(ValidatorUtils.getImmediateHosts(u1), null);
		assertSetEquals(ValidatorUtils.getAllHosts(u1), null);
		assertSetEquals(ValidatorUtils.getImmediateHosts(u2), null);
		assertSetEquals(ValidatorUtils.getAllHosts(u2), null);
		assertSetEquals(ValidatorUtils.getImmediateHosts(cu1),
				new Object[] { u2 });
		assertSetEquals(ValidatorUtils.getAllHosts(cu1), new Object[] { u2 });

		assertSetEquals(ValidatorUtils.getHosted(u1), null);
		assertSetEquals(ValidatorUtils.getImmediateHosted(u1), null);
		assertSetEquals(ValidatorUtils.getHosted(u2), new Object[] { cu1 });
		assertSetEquals(ValidatorUtils.getImmediateHosted(u2),
				new Object[] { cu1 });
		assertSetEquals(ValidatorUtils.getHosted(cu1), null);
		assertSetEquals(ValidatorUtils.getImmediateHosted(cu1), null);

		// cu1 --r-> u1
		// ^
		// |
		// |
		// u2
		LinkFactory.createRealizationLink(cu1, u1);

		assertSetEquals(ValidatorUtils.getImmediateHosts(u1), null);
		assertSetEquals(ValidatorUtils.getAllHosts(u1), new Object[] { u2 });
		assertSetEquals(ValidatorUtils.getImmediateHosts(u2), null);
		assertSetEquals(ValidatorUtils.getAllHosts(u2), null);
		assertSetEquals(ValidatorUtils.getImmediateHosts(cu1),
				new Object[] { u2 });
		assertSetEquals(ValidatorUtils.getAllHosts(cu1), new Object[] { u2 });

		assertSetEquals(ValidatorUtils.getHosted(u1), null);
		assertSetEquals(ValidatorUtils.getImmediateHosted(u1), null);
		assertSetEquals(ValidatorUtils.getHosted(u2), new Object[] { u1 });
		assertSetEquals(ValidatorUtils.getImmediateHosted(u2),
				new Object[] { cu1 });
		assertSetEquals(ValidatorUtils.getHosted(cu1), null);
		assertSetEquals(ValidatorUtils.getImmediateHosted(cu1), null);

		assertEquals(TopologyDiscovererService.INSTANCE.findHost(u1, top), u2);
		assertUnitDescriptorListContainsUnitValues(
				TopologyDiscovererService.INSTANCE.findHosted(u2, top),
				new Object[] { u1 });
	}

	/**
	 * Test single path hosting link realization.
	 * 
	 * @see ValidatorUtils#getAllHosts(Unit)
	 * @see ValidatorUtils#getImmediateHosts(Unit)
	 * @see ValidatorUtils#getHosted(Unit)
	 * @see ValidatorUtils#getImmediateHosted(Unit)
	 * 
	 * @throws Exception
	 */
	public void testHostingSinglePathRealization3() throws Exception {
		Topology top = createTopology("testHostingSinglePathRealization3");
		// u1 <--r- cu1
		// ^
		// |
		// |
		// u2
		Unit u1 = addUnit(top, "u1");
		Unit cu1 = addUnit(top, "cu2");
		cu1.setConceptual(true);
		Unit u2 = addUnit(top, "u2");

		LinkFactory.createHostingLink(u2, u1);
		LinkFactory.createRealizationLink(cu1, u1);

		assertSetEquals(ValidatorUtils.getImmediateHosts(u1),
				new Object[] { u2 });
		assertSetEquals(ValidatorUtils.getAllHosts(u1), new Object[] { u2 });
		assertSetEquals(ValidatorUtils.getImmediateHosts(u2), null);
		assertSetEquals(ValidatorUtils.getAllHosts(u2), null);
		assertSetEquals(ValidatorUtils.getImmediateHosts(cu1), null);
		assertSetEquals(ValidatorUtils.getAllHosts(cu1), new Object[] { u2 });

		assertSetEquals(ValidatorUtils.getImmediateHosted(u1), null);
		assertSetEquals(ValidatorUtils.getHosted(u1), null);
		assertSetEquals(ValidatorUtils.getImmediateHosted(u2),
				new Object[] { u1 });
		assertSetEquals(ValidatorUtils.getHosted(u2), new Object[] { u1 });
		assertSetEquals(ValidatorUtils.getImmediateHosted(cu1), null);
		assertSetEquals(ValidatorUtils.getHosted(cu1), null);

		assertEquals(TopologyDiscovererService.INSTANCE.findHost(u1, top), u2);
		assertUnitDescriptorListContainsUnitValues(
				TopologyDiscovererService.INSTANCE.findHosted(u2, top),
				new Object[] { u1 });
	}

	/**
	 * Test single path hosting link realization.
	 * 
	 * @see ValidatorUtils#getAllHosts(Unit)
	 * @see ValidatorUtils#getImmediateHosts(Unit)
	 * @see ValidatorUtils#getHosted(Unit)
	 * @see ValidatorUtils#getImmediateHosted(Unit)
	 * 
	 * @throws Exception
	 */
	public void testHostingSinglePathRealization4() throws Exception {
		Topology top = createTopology("testHostingSinglePathRealization4");
		// u1 <--r- cu1
		// ^ ^
		// | |
		// | |
		// u2 <--r- cu2
		Unit u1 = addUnit(top, "u1");
		Unit cu1 = addUnit(top, "cu1");
		cu1.setConceptual(true);
		Unit cu2 = addUnit(top, "cu2");
		cu2.setConceptual(true);
		Unit u2 = addUnit(top, "u2");

		LinkFactory.createHostingLink(u2, u1);
		LinkFactory.createHostingLink(cu2, cu1);
		LinkFactory.createRealizationLink(cu1, u1);
		LinkFactory.createRealizationLink(cu2, u2);

		assertSetEquals(ValidatorUtils.getImmediateHosts(u1),
				new Object[] { u2 });
		assertSetEquals(ValidatorUtils.getAllHosts(u1), new Object[] { u2 });
		assertSetEquals(ValidatorUtils.getImmediateHosts(u2), null);
		assertSetEquals(ValidatorUtils.getAllHosts(u2), null);
		assertSetEquals(ValidatorUtils.getImmediateHosts(cu1),
				new Object[] { cu2 });
		assertSetEquals(ValidatorUtils.getAllHosts(cu1), new Object[] { u2 });
		assertSetEquals(ValidatorUtils.getImmediateHosts(cu2), null);
		assertSetEquals(ValidatorUtils.getAllHosts(cu2), null);

		assertSetEquals(ValidatorUtils.getImmediateHosted(u1), null);
		assertSetEquals(ValidatorUtils.getHosted(u1), null);
		assertSetEquals(ValidatorUtils.getImmediateHosted(u2),
				new Object[] { u1 });
		assertSetEquals(ValidatorUtils.getHosted(u2), new Object[] { u1 });
		assertSetEquals(ValidatorUtils.getImmediateHosted(cu1), null);
		assertSetEquals(ValidatorUtils.getHosted(cu1), null);
		assertSetEquals(ValidatorUtils.getImmediateHosted(cu2),
				new Object[] { cu1 });
		assertSetEquals(ValidatorUtils.getHosted(cu2), new Object[] { u1 });

		assertEquals(TopologyDiscovererService.INSTANCE.findHost(u1, top), u2);
		assertUnitDescriptorListContainsUnitValues(
				TopologyDiscovererService.INSTANCE.findHosted(u2, top),
				new Object[] { u1 });
	}

	/**
	 * Test hosting links multipath realization.
	 * 
	 * @see ValidatorUtils#getAllHosts(Unit)
	 * @see ValidatorUtils#getImmediateHosts(Unit)
	 * @see ValidatorUtils#getHosted(Unit)
	 * @see ValidatorUtils#getImmediateHosted(Unit)
	 */
	public void testHostingMultipathRealization() throws Exception {
		// u1
		//
		// cu2a cu2b u2
		Topology top = createTopology("testHostingMultipathRealization");

		Unit u1 = addUnit(top, "u1");
		Unit cu2a = addUnit(top, "cu2a");
		cu2a.setConceptual(true);
		Unit cu2b = addUnit(top, "cu2b");
		cu2b.setConceptual(true);
		Unit u2 = addUnit(top, "u2");

		assertSetEquals(ValidatorUtils.getImmediateHosts(u1), null);
		assertSetEquals(ValidatorUtils.getAllHosts(u1), null);
		assertSetEquals(ValidatorUtils.getImmediateHosts(cu2a), null);
		assertSetEquals(ValidatorUtils.findHosts(cu2a), null);

		assertSetEquals(ValidatorUtils.getImmediateHosted(cu2a), null);
		assertSetEquals(ValidatorUtils.getHosted(cu2a), null);
		assertSetEquals(ValidatorUtils.getImmediateHosted(cu2b), null);
		assertSetEquals(ValidatorUtils.getHosted(cu2b), null);
		assertSetEquals(ValidatorUtils.getImmediateHosted(u2), null);
		assertSetEquals(ValidatorUtils.getHosted(u2), null);

		// u1
		// ^
		// |h
		// |
		// cu2a cu2b u2
		LinkFactory.createHostingLink(cu2a, u1);

		assertSetEquals(ValidatorUtils.getImmediateHosts(u1),
				new Object[] { cu2a });
		assertSetEquals(ValidatorUtils.getAllHosts(u1), new Object[] { cu2a });
		assertSetEquals(ValidatorUtils.getImmediateHosts(cu2a), null);
		assertSetEquals(ValidatorUtils.getAllHosts(cu2a), null);
		assertSetEquals(ValidatorUtils.getImmediateHosts(u2), null);
		assertSetEquals(ValidatorUtils.getAllHosts(u2), null);

		assertSetEquals(ValidatorUtils.getImmediateHosted(cu2a),
				new Object[] { u1 });
		assertSetEquals(ValidatorUtils.getHosted(cu2a), new Object[] { u1 });
		assertSetEquals(ValidatorUtils.getImmediateHosted(cu2b), null);
		assertSetEquals(ValidatorUtils.getHosted(cu2b), null);
		assertSetEquals(ValidatorUtils.getImmediateHosted(u2), null);
		assertSetEquals(ValidatorUtils.getHosted(u2), null);

		// u1
		// ^
		// |h
		// |
		// cu2a -r-> cu2b u2
		LinkFactory.createRealizationLink(cu2a, cu2b);

		assertSetEquals(ValidatorUtils.getImmediateHosts(u1),
				new Object[] { cu2a });
		assertSetEquals(ValidatorUtils.getAllHosts(u1), new Object[] { cu2b });
		assertSetEquals(ValidatorUtils.getImmediateHosts(cu2a), null);
		assertSetEquals(ValidatorUtils.getAllHosts(cu2a), null);
		assertSetEquals(ValidatorUtils.getImmediateHosts(u2), null);
		assertSetEquals(ValidatorUtils.getAllHosts(u2), null);

		assertSetEquals(ValidatorUtils.getImmediateHosted(cu2a),
				new Object[] { u1 });
		assertSetEquals(ValidatorUtils.getHosted(cu2a), new Object[] { u1 });
		assertSetEquals(ValidatorUtils.getImmediateHosted(cu2b), null);
		assertSetEquals(ValidatorUtils.getHosted(cu2b), new Object[] { u1 });
		assertSetEquals(ValidatorUtils.getImmediateHosted(u2), null);
		assertSetEquals(ValidatorUtils.getHosted(u2), null);

		// u1
		// ^
		// |h
		// |
		// cu2a -r-> cu2b -r-> u2
		LinkFactory.createRealizationLink(cu2b, u2);

		assertSetEquals(ValidatorUtils.getImmediateHosts(u1),
				new Object[] { cu2a });
		assertSetEquals(ValidatorUtils.getAllHosts(u1), new Object[] { u2 });
		assertSetEquals(ValidatorUtils.getImmediateHosts(cu2a), null);
		assertSetEquals(ValidatorUtils.getAllHosts(cu2a), null);
		assertSetEquals(ValidatorUtils.getImmediateHosts(cu2b), null);
		assertSetEquals(ValidatorUtils.getAllHosts(cu2b), null);
		assertSetEquals(ValidatorUtils.getImmediateHosts(u2), null);
		assertSetEquals(ValidatorUtils.getAllHosts(u2), null);

		assertSetEquals(ValidatorUtils.getImmediateHosted(cu2a),
				new Object[] { u1 });
		assertSetEquals(ValidatorUtils.getHosted(cu2a), new Object[] { u1 });
		assertSetEquals(ValidatorUtils.getImmediateHosted(cu2b), null);
		assertSetEquals(ValidatorUtils.getHosted(cu2b), new Object[] { u1 });
		assertSetEquals(ValidatorUtils.getImmediateHosted(u2), null);
		assertSetEquals(ValidatorUtils.getHosted(u2), new Object[] { u1 });

		// u1
		// ^
		// |h +------r2------+
		// | / v
		// cu2a -r-> cu2b -r-> u2

		LinkFactory.createRealizationLink(cu2b, u2);	// bug was cu2a --> u2
		assertSetEquals(ValidatorUtils.getImmediateHosts(u1),
				new Object[] { cu2a });
		assertSetEquals(ValidatorUtils.getAllHosts(u1), new Object[] { u2 });
		assertSetEquals(ValidatorUtils.getImmediateHosts(cu2a), null);
		assertSetEquals(ValidatorUtils.getAllHosts(cu2a), null);
		assertSetEquals(ValidatorUtils.getImmediateHosts(u2), null);
		assertSetEquals(ValidatorUtils.getAllHosts(u2), null);

		assertSetEquals(ValidatorUtils.getImmediateHosted(cu2a),
				new Object[] { u1 });
		assertSetEquals(ValidatorUtils.getHosted(cu2a), new Object[] { u1 });
		assertSetEquals(ValidatorUtils.getImmediateHosted(cu2b), null);
		assertSetEquals(ValidatorUtils.getHosted(cu2b), new Object[] { u1 });
		assertSetEquals(ValidatorUtils.getImmediateHosted(u2), null);
		assertSetEquals(ValidatorUtils.getHosted(u2), new Object[] { u1 });

		// u1
		// ^
		// |h +------r2------+
		// | / v
		// cu2a -r-> cu2b -r-> u2
		// ^
		// |
		// u3
		Unit u3 = addUnit(top, "u3");
		LinkFactory.createHostingLink(u3, cu2b);
		assertSetEquals(ValidatorUtils.getImmediateHosts(u1),
				new Object[] { cu2a });
		assertSetEquals(ValidatorUtils.getAllHosts(u1), new Object[] { u2 });
		assertSetEquals(ValidatorUtils.getImmediateHosts(cu2a), null);
		assertSetEquals(ValidatorUtils.getAllHosts(cu2a), new Object[] { u3 });
		assertSetEquals(ValidatorUtils.getImmediateHosts(cu2b),
				new Object[] { u3 });
		assertSetEquals(ValidatorUtils.getAllHosts(cu2b), new Object[] { u3 });
		assertSetEquals(ValidatorUtils.getImmediateHosts(u2), null);
		assertSetEquals(ValidatorUtils.getAllHosts(u2), new Object[] { u3 });

		assertSetEquals(ValidatorUtils.getImmediateHosted(cu2a),
				new Object[] { u1 });
		assertSetEquals(ValidatorUtils.getHosted(cu2a), new Object[] { u1 });
		assertSetEquals(ValidatorUtils.getImmediateHosted(cu2b), null);
		assertSetEquals(ValidatorUtils.getHosted(cu2b), new Object[] { u1 });
		assertSetEquals(ValidatorUtils.getImmediateHosted(u2), null);
		assertSetEquals(ValidatorUtils.getHosted(u2), new Object[] { u1 });
		assertSetEquals(ValidatorUtils.getImmediateHosted(u3),
				new Object[] { cu2b });
		assertSetEquals(ValidatorUtils.getHosted(u3), new Object[] { u2 });
	}

	/**
	 * Test multiple hosting link path realization.
	 * 
	 * @see ValidatorUtils#getAllHosts(Unit)
	 * @see ValidatorUtils#getImmediateHosts(Unit)
	 * @see ValidatorUtils#getHosted(Unit)
	 * @see ValidatorUtils#getImmediateHosted(Unit)
	 * 
	 * @throws Exceptiony
	 */
	public void testHostingMultiPathRealization2() throws Exception {
		// cu1 --r-> u1
		// ^
		// |h
		// |
		// cu2 --r-> u2
		Topology top = createTopology("testHostingMultiPathRealization2");

		Unit u1 = addUnit(top, "u1");
		Unit cu1 = addUnit(top, "cu1");
		cu1.setConceptual(true);
		Unit cu2 = addUnit(top, "cu2");
		cu2.setConceptual(true);
		Unit u2 = addUnit(top, "u2");

		LinkFactory.createRealizationLink(cu1, u1);
		LinkFactory.createHostingLink(cu2, cu1);
		LinkFactory.createRealizationLink(cu2, u2);

		assertSetEquals(ValidatorUtils.getImmediateHosts(u1), null);
		assertSetEquals(ValidatorUtils.getAllHosts(u1), new Object[] { u2 });
		assertSetEquals(ValidatorUtils.getImmediateHosts(cu1),
				new Object[] { cu2 });
		assertSetEquals(ValidatorUtils.getAllHosts(cu1), new Object[] { u2 });
		assertSetEquals(ValidatorUtils.getImmediateHosts(cu2), null);
		assertSetEquals(ValidatorUtils.getAllHosts(cu2), null);
		assertSetEquals(ValidatorUtils.getImmediateHosts(u2), null);
		assertSetEquals(ValidatorUtils.getAllHosts(u2), null);

		assertSetEquals(ValidatorUtils.getHosted(cu1), null);
		assertSetEquals(ValidatorUtils.getImmediateHosted(cu1), null);
		assertSetEquals(ValidatorUtils.getHosted(cu2), new Object[] { u1 });
		assertSetEquals(ValidatorUtils.getImmediateHosted(cu2),
				new Object[] { cu1 });
		assertSetEquals(ValidatorUtils.getHosted(u2), new Object[] { u1 });
		assertSetEquals(ValidatorUtils.getImmediateHosted(u2), null);

		assertEquals(TopologyDiscovererService.INSTANCE.findHost(u1, top), u2);
		assertUnitDescriptorListContainsUnitValues(
				TopologyDiscovererService.INSTANCE.findHosted(u2, top),
				new Object[] { u1 });
	}
	

	/**
	 * Test multiple hosting link path realization with a 1..* disambiguation links.
	 * 
	 * <b>Use case 1.</b>
	 * 
	 * @see ValidatorUtils#getAllHosts(Unit)
	 * @see ValidatorUtils#getImmediateHosts(Unit)
	 * @see ValidatorUtils#getHosted(Unit)
	 * @see ValidatorUtils#getImmediateHosted(Unit)
	 * 
	 * @throws Exceptiony
	 */
	public void testHostingMultiPathRealizationDisambiguationLinks() throws Exception {
		//  cu1 
		//  ^   ^
		//  |h    \h 
		//  |      \
		// cu2 -r-> u2
		//    \
		//     \-r-> u3
		Topology top = createTopology("testHostingMultiPathRealization2");
 
		Unit cu1 = addUnit(top, "cu1");
		cu1.setConceptual(true);
		Unit cu2 = addUnit(top, "cu2");
		cu2.setConceptual(true);
		Unit u2 = addUnit(top, "u2");
		Unit u3 = addUnit(top, "u3");
 
		LinkFactory.createHostingLink(cu2, cu1);
		LinkFactory.createHostingLink(u2, cu1);
		LinkFactory.createRealizationLink(cu2, u2);
		LinkFactory.createRealizationLink(cu2, u3);
 
		assertSetEquals(ValidatorUtils.getImmediateHosts(cu1),
				new Object[] { cu2, u2 });
		assertSetEquals(ValidatorUtils.getAllHosts(cu1), new Object[] { u2, u3 });
		assertSetEquals(ValidatorUtils.getImmediateHosts(cu2), null);
		assertSetEquals(ValidatorUtils.getAllHosts(cu2), null);
		assertSetEquals(ValidatorUtils.getImmediateHosts(u2), null);
		assertSetEquals(ValidatorUtils.getAllHosts(u2), null);
		assertSetEquals(ValidatorUtils.getImmediateHosts(u3), null);
		assertSetEquals(ValidatorUtils.getAllHosts(u3), null);
		
		assertSetEquals(ValidatorUtils.getHosted(cu1), null);
		assertSetEquals(ValidatorUtils.getImmediateHosted(cu1), null);
		assertSetEquals(ValidatorUtils.getHosted(cu2), new Object[] { cu1 });
		assertSetEquals(ValidatorUtils.getImmediateHosted(cu2),
				new Object[] { cu1 });
		assertSetEquals(ValidatorUtils.getHosted(u2), new Object[] { cu1 });
		assertSetEquals(ValidatorUtils.getImmediateHosted(u2), new Object[] { cu1 });

		assertSetEquals(ValidatorUtils.getHosted(u3), new Object[] { cu1 });
		assertSetEquals(ValidatorUtils.getImmediateHosted(u3), null);

		assertEquals(TopologyDiscovererService.INSTANCE.findHost(cu1, top), null);
		assertUnitDescriptorListContainsUnitValues(
				TopologyDiscovererService.INSTANCE.findHosted(u2, top),
				new Object[] { cu1 });
	}
	
	/**
	 * Test multiple hosting link path realization with a 1..* disambiguation links.
	 * 
	 * <b>Use case 2b.</b>
	 * 
	 * @see ValidatorUtils#getAllHosts(Unit)
	 * @see ValidatorUtils#getImmediateHosts(Unit)
	 * @see ValidatorUtils#getHosted(Unit)
	 * @see ValidatorUtils#getImmediateHosted(Unit)
	 * 
	 * @throws Exceptiony
	 */
	public void testHostingMultiPathRealizationPlusMultiHosting() throws Exception {
		
	}

	/**
	 * Test single path dependency realization.
	 * 
	 * @see ValidatorUtils#getAllHosts(Unit)
	 * @see ValidatorUtils#getImmediateHosts(Unit)
	 * @see ValidatorUtils#getHosted(Unit)
	 * @see ValidatorUtils#getImmediateHosted(Unit)
	 * 
	 * @throws Exception
	 */
	public void testDependencySinglePathRealization1() throws Exception {
		// u1(r1)
		// |
		// +----r---->cu1(cr1) --d--> u3(c3)

		Topology top = createTopology("testDependencySinglePathRealization1");

		// cu1(cr1)
		// 
		// u1(r1) u2(c2)
		Unit cu1 = addUnit(top, "cu1");
		cu1.setConceptual(true);
		Requirement cr1 = addRequirement(cu1, "cr1",
				RequirementLinkTypes.DEPENDENCY_LITERAL);
		Unit u1 = addUnit(top, "u1");
		Requirement r1 = addRequirement(u1, "r1",
				RequirementLinkTypes.DEPENDENCY_LITERAL);
		Unit u2 = addUnit(top, "u2");
		Capability c2 = addCapability(u2, "c2",
				CapabilityLinkTypes.DEPENDENCY_LITERAL);

		assertSetEquals(ValidatorUtils.getImmediateDependencyLinkTargets(cr1),
				null);
		assertSetEquals(ValidatorUtils.getImmediateDependencyLinkTargets(r1),
				null);
		assertSetEquals(ValidatorUtils.getImmediateDependencyLinkSources(c2),
				null);
		assertSetEquals(ValidatorUtils.getDependencyLinkTargets(cr1), null);
		assertSetEquals(ValidatorUtils.getDependencyLinkTargets(r1), null);
		assertSetEquals(ValidatorUtils.getDependencyLinkSources(c2), null);

		// cu1(r1)
		// 
		// u1(r1) --d--> u2(c2)
		LinkFactory.createDependencyLink(r1, c2);

		assertSetEquals(ValidatorUtils.getImmediateDependencyLinkTargets(cr1),
				null);
		assertSetEquals(ValidatorUtils.getImmediateDependencyLinkTargets(r1),
				new Object[] { c2 });
		assertSetEquals(ValidatorUtils.getImmediateDependencyLinkSources(c2),
				new Object[] { r1 });
		assertSetEquals(ValidatorUtils.getDependencyLinkTargets(cr1), null);
		assertSetEquals(ValidatorUtils.getDependencyLinkTargets(r1),
				new Object[] { c2 });
		assertSetEquals(ValidatorUtils.getDependencyLinkSources(c2),
				new Object[] { r1 });

		// cu1(cr1)
		// |
		// +----r---->u1(r1) --d--> u2(c2)
		LinkFactory.createRealizationLink(cu1, u1);

		assertSetEquals(ValidatorUtils.getImmediateDependencyLinkTargets(cr1),
				null);
		assertSetEquals(ValidatorUtils.getImmediateDependencyLinkTargets(r1),
				new Object[] { c2 });
		assertSetEquals(ValidatorUtils.getImmediateDependencyLinkSources(c2),
				new Object[] { r1 });
		assertSetEquals(ValidatorUtils.getDependencyLinkTargets(cr1),
				new Object[] { c2 });
		assertSetEquals(ValidatorUtils.getDependencyLinkTargets(r1),
				new Object[] { c2 });
		assertSetEquals(ValidatorUtils.getDependencyLinkSources(c2),
				new Object[] { r1 });

		assertEquals(TopologyDiscovererService.INSTANCE.findTarget(cu1, cr1,
				top).getUnitValue(), u2);
		assertUnitDescriptorListContainsUnitValues(
				TopologyDiscovererService.INSTANCE.findSources(u2, c2, top),
				new Object[] { u1 });
	}

	/**
	 * Test single path dependency realization.
	 * 
	 * @see ValidatorUtils#getAllHosts(Unit)
	 * @see ValidatorUtils#getImmediateHosts(Unit)
	 * @see ValidatorUtils#getHosted(Unit)
	 * @see ValidatorUtils#getImmediateHosted(Unit)
	 * 
	 * @throws Exception
	 */
	public void testDependencySinglePathRealization2() throws Exception {
		Topology top = createTopology("testDependencySinglePathRealization2");

		// cu1(cr1) u1(r1)
		// 
		// u2(c2)r
		Unit cu1 = addUnit(top, "cu1");
		cu1.setConceptual(true);
		Requirement cr1 = addRequirement(cu1, "cr1",
				RequirementLinkTypes.DEPENDENCY_LITERAL);
		Unit u1 = addUnit(top, "u1");
		Requirement r1 = addRequirement(u1, "r1",
				RequirementLinkTypes.DEPENDENCY_LITERAL);
		Unit u2 = addUnit(top, "u2");
		Capability c2 = addCapability(u2, "c2",
				CapabilityLinkTypes.DEPENDENCY_LITERAL);

		assertSetEquals(ValidatorUtils.getImmediateDependencyLinkTargets(cr1),
				null);
		assertSetEquals(ValidatorUtils.getImmediateDependencyLinkTargets(r1),
				null);
		assertSetEquals(ValidatorUtils.getImmediateDependencyLinkSources(c2),
				null);
		assertSetEquals(ValidatorUtils.getDependencyLinkTargets(cr1), null);
		assertSetEquals(ValidatorUtils.getDependencyLinkTargets(r1), null);
		assertSetEquals(ValidatorUtils.getDependencyLinkSources(c2), null);

		// cu1(cr1) u1(r1)
		// |
		// +------d-->u2(c2)
		LinkFactory.createDependencyLink(cr1, c2);

		assertSetEquals(ValidatorUtils.getImmediateDependencyLinkTargets(cr1),
				new Object[] { c2 });
		assertSetEquals(ValidatorUtils.getDependencyLinkTargets(cr1),
				new Object[] { c2 });
		assertSetEquals(ValidatorUtils.getImmediateDependencyLinkTargets(r1),
				null);
		assertSetEquals(ValidatorUtils.getDependencyLinkTargets(r1), null);
		assertSetEquals(ValidatorUtils.getImmediateDependencyLinkSources(c2),
				new Object[] { cr1 });
		assertSetEquals(ValidatorUtils.getDependencyLinkSources(c2),
				new Object[] { cr1 });

		// cu1(cr1) --r--> u1(r1)
		// |
		// +------d-->u2(c2)
		LinkFactory.createRealizationLink(cu1, u1);

		assertEquals(RealizationLinkUtil.getImplicitFinalRealization(cr1), r1);
		assertSetEquals(ValidatorUtils.getImmediateDependencyLinkTargets(cr1),
				new Object[] { c2 });
		assertSetEquals(ValidatorUtils.getDependencyLinkTargets(cr1),
				new Object[] { c2 });
		assertSetEquals(ValidatorUtils.getImmediateDependencyLinkTargets(r1),
				null);
		assertSetEquals(ValidatorUtils.getDependencyLinkTargets(r1),
				new Object[] { c2 });
		assertSetEquals(ValidatorUtils.getImmediateDependencyLinkSources(c2),
				new Object[] { cr1 });
		assertSetEquals(ValidatorUtils.getDependencyLinkSources(c2),
				new Object[] { r1 });

		assertEquals(TopologyDiscovererService.INSTANCE.findTarget(cu1, cr1,
				top).getUnitValue(), u2);
		assertUnitDescriptorListContainsUnitValues(
				TopologyDiscovererService.INSTANCE.findSources(u2, c2, top),
				new Object[] { u1 });
	}

	/**
	 * Test single member link path realization.
	 * 
	 * @see ValidatorUtils#getGroups(Unit)
	 * @see ValidatorUtils#getImmediateGroups(Unit)
	 * @see ValidatorUtils#getMembers(Unit)
	 * @see ValidatorUtils#getImmediateMembers(Unit)
	 * 
	 * @throws Exception
	 */
	public void testMemberSinglePathRealization1() throws Exception {
		// member
		// 
		// cgroup group
		Topology top = createTopology("testMemberSinglePathRealization1");

		Unit member = addUnit(top, "member");
		Unit cgroup = addGroupUnit(top, "cgroup");
		cgroup.setConceptual(true);
		Unit group = addGroupUnit(top, "group");

		assertSetEquals(ValidatorUtils.getGroups(member), null);
		assertSetEquals(ValidatorUtils.getImmediateGroups(member), null);
		assertSetEquals(ValidatorUtils.getImmediateGroups(cgroup), null);

		assertSetEquals(ValidatorUtils.getMembers(cgroup), null);
		assertSetEquals(ValidatorUtils.getImmediateMembers(cgroup), null);
		assertSetEquals(ValidatorUtils.getMembers(group), null);
		assertSetEquals(ValidatorUtils.getImmediateMembers(group), null);

		// member
		// ^
		// |m
		// |
		// cgroup group
		LinkFactory.createMemberLink(cgroup, member);

		assertSetEquals(ValidatorUtils.getImmediateGroups(member),
				new Object[] { cgroup });
		assertSetEquals(ValidatorUtils.getGroups(member),
				new Object[] { cgroup });
		assertSetEquals(ValidatorUtils.getImmediateGroups(cgroup), null);
		assertSetEquals(ValidatorUtils.getGroups(cgroup), null);
		assertSetEquals(ValidatorUtils.getImmediateGroups(group), null);
		assertSetEquals(ValidatorUtils.getGroups(group), null);

		assertSetEquals(ValidatorUtils.getMembers(cgroup),
				new Object[] { member });
		assertSetEquals(ValidatorUtils.getImmediateMembers(cgroup),
				new Object[] { member });
		assertSetEquals(ValidatorUtils.getMembers(group), null);
		assertSetEquals(ValidatorUtils.getImmediateMembers(group), null);

		// member
		// ^
		// |m
		// |
		// cgroup --r-> group
		LinkFactory.createRealizationLink(cgroup, group);

		assertSetEquals(ValidatorUtils.getImmediateGroups(member),
				new Object[] { cgroup });
		assertSetEquals(ValidatorUtils.getGroups(member),
				new Object[] { group });
		assertSetEquals(ValidatorUtils.getImmediateGroups(cgroup), null);
		assertSetEquals(ValidatorUtils.getGroups(cgroup), null);
		assertSetEquals(ValidatorUtils.getImmediateGroups(group), null);
		assertSetEquals(ValidatorUtils.getGroups(group), null);

		assertSetEquals(ValidatorUtils.getMembers(cgroup),
				new Object[] { member });
		assertSetEquals(ValidatorUtils.getImmediateMembers(cgroup),
				new Object[] { member });
		assertSetEquals(ValidatorUtils.getMembers(group),
				new Object[] { member });
		assertSetEquals(ValidatorUtils.getImmediateMembers(group), null);

		assertUnitDescriptorListContainsUnitValues(
				TopologyDiscovererService.INSTANCE.getGroups(member, null, top),
				new Object[] { group });
		assertUnitDescriptorListContainsUnitValues(
				TopologyDiscovererService.INSTANCE.getMembers(group, null, top),
				new Object[] { member });
	}

	/**
	 * Test single member path group link realization.
	 * 
	 * @see ValidatorUtils#getGroups(Unit)
	 * @see ValidatorUtils#getImmediateGroups(Unit)
	 * @see ValidatorUtils#getMembers(Unit)
	 * @see ValidatorUtils#getImmediateMembers(Unit)
	 * 
	 * @throws Exception
	 */
	public void testMemberSinglePathRealization2() throws Exception {
		// cu1 u1
		//           
		// u2
		Topology top = createTopology("testMemberSinglePathRealization2");

		Unit member = addUnit(top, "member");
		Unit cmember = addUnit(top, "cmember");
		cmember.setConceptual(true);
		Unit group = addGroupUnit(top, "group");

		assertSetEquals(ValidatorUtils.getImmediateGroups(member), null);
		assertSetEquals(ValidatorUtils.getGroups(member), null);
		assertSetEquals(ValidatorUtils.getImmediateGroups(cmember), null);
		assertSetEquals(ValidatorUtils.getGroups(cmember), null);

		assertSetEquals(ValidatorUtils.getImmediateMembers(cmember), null);
		assertSetEquals(ValidatorUtils.getHosted(cmember), null);
		assertSetEquals(ValidatorUtils.getImmediateMembers(group), null);
		assertSetEquals(ValidatorUtils.getMembers(group), null);

		// cu1 u1
		// ^
		// |h
		// |
		// u2
		LinkFactory.createMemberLink(group, cmember);

		assertSetEquals(ValidatorUtils.getImmediateGroups(member), null);
		assertSetEquals(ValidatorUtils.getGroups(member), null);
		assertSetEquals(ValidatorUtils.getImmediateGroups(group), null);
		assertSetEquals(ValidatorUtils.getGroups(group), null);
		assertSetEquals(ValidatorUtils.getImmediateGroups(cmember),
				new Object[] { group });
		assertSetEquals(ValidatorUtils.getGroups(cmember),
				new Object[] { group });

		assertSetEquals(ValidatorUtils.getMembers(member), null);
		assertSetEquals(ValidatorUtils.getImmediateMembers(member), null);
		assertSetEquals(ValidatorUtils.getMembers(group),
				new Object[] { cmember });
		assertSetEquals(ValidatorUtils.getImmediateMembers(group),
				new Object[] { cmember });
		assertSetEquals(ValidatorUtils.getMembers(cmember), null);
		assertSetEquals(ValidatorUtils.getImmediateMembers(cmember), null);

		// cmember --r-> member
		// ^
		// |
		// |
		// group
		LinkFactory.createRealizationLink(cmember, member);

		assertSetEquals(ValidatorUtils.getImmediateGroups(member), null);
		assertSetEquals(ValidatorUtils.getGroups(member),
				new Object[] { group });
		assertSetEquals(ValidatorUtils.getImmediateGroups(group), null);
		assertSetEquals(ValidatorUtils.getGroups(group), null);
		assertSetEquals(ValidatorUtils.getImmediateGroups(cmember),
				new Object[] { group });
		assertSetEquals(ValidatorUtils.getGroups(cmember),
				new Object[] { group });

		assertSetEquals(ValidatorUtils.getMembers(member), null);
		assertSetEquals(ValidatorUtils.getImmediateMembers(member), null);
		assertSetEquals(ValidatorUtils.getMembers(group),
				new Object[] { member });
		assertSetEquals(ValidatorUtils.getImmediateMembers(group),
				new Object[] { cmember });
		assertSetEquals(ValidatorUtils.getMembers(cmember), null);
		assertSetEquals(ValidatorUtils.getImmediateMembers(cmember), null);

		assertUnitDescriptorListContainsUnitValues(
				TopologyDiscovererService.INSTANCE.getGroups(member, null, top),
				new Object[] { group });
		assertUnitDescriptorListContainsUnitValues(
				TopologyDiscovererService.INSTANCE.getMembers(group, null, top),
				new Object[] { member });
	}

	/**
	 * Test implicit realization of capabilities.
	 * 
	 * @see RealizationLinkUtil#getAllImplicitRealizationLinkedObjects(com.ibm.ccl.soa.deploy.core.DeployModelObject)
	 * 
	 * @throws Exception
	 */
	public void testImplicitRealizationLinkedObjects() throws Exception {
		// cu1(cr1,cc1) --> u1(r1,c1)
		Topology top = createTopology("testImplicitRealizationLinkedObjects");

		Unit u1 = addUnit(top, "u1");
		Requirement r1 = addRequirement(u1, "r1",
				RequirementLinkTypes.DEPENDENCY_LITERAL);
		Capability c1 = addCapability(u1, "c1",
				CapabilityLinkTypes.DEPENDENCY_LITERAL);
		Unit cu1 = addUnit(top, "cu1");
		cu1.setConceptual(true);
		Requirement cr1 = addRequirement(cu1, "cr1",
				RequirementLinkTypes.DEPENDENCY_LITERAL);
		Capability cc1 = addCapability(cu1, "cc1",
				CapabilityLinkTypes.DEPENDENCY_LITERAL);
		LinkFactory.createRealizationLink(cu1, u1);

		assertSetEquals(RealizationLinkUtil
				.getAllImplicitRealizationLinkedObjects(u1), new Object[] { u1,
				cu1 });
		assertSetEquals(RealizationLinkUtil
				.getAllImplicitRealizationLinkedObjects(cu1), new Object[] {
				u1, cu1 });
		assertSetEquals(RealizationLinkUtil
				.getAllImplicitRealizationLinkedObjects(c1), new Object[] { c1,
				cc1 });
		assertSetEquals(RealizationLinkUtil
				.getAllImplicitRealizationLinkedObjects(cc1), new Object[] {
				c1, cc1 });
		assertSetEquals(RealizationLinkUtil
				.getAllImplicitRealizationLinkedObjects(r1), new Object[] { r1,
				cr1 });
		assertSetEquals(RealizationLinkUtil
				.getAllImplicitRealizationLinkedObjects(cr1), new Object[] {
				r1, cr1 });
	}
	

	/**
	 * Test implicit realization of capabilities.
	 * 
	 * @see RealizationLinkUtil#getAllImplicitRealizationLinkedObjects(com.ibm.ccl.soa.deploy.core.DeployModelObject)
	 * 
	 * @throws Exception
	 */
	public void testExplicitlyHostedRealizationLinkedObjects() throws Exception {
		// cu1(cr1,cc1) --> u1(r1,c1)
		Topology top = createTopology("testImplicitRealizationLinkedObjects");

//		Unit u1 = addUnit(top, "u1");
//		Requirement r1 = addRequirement(u1, "r1",
//				RequirementLinkTypes.DEPENDENCY_LITERAL);
//		Capability c1 = addCapability(u1, "c1",
//				CapabilityLinkTypes.DEPENDENCY_LITERAL);
//		Unit cu1 = addUnit(top, "cu1");
//		cu1.setConceptual(true);
//		Requirement cr1 = addRequirement(cu1, "cr1",
//				RequirementLinkTypes.DEPENDENCY_LITERAL);
//		Capability cc1 = addCapability(cu1, "cc1",
//				CapabilityLinkTypes.DEPENDENCY_LITERAL);
//		LinkFactory.createRealizationLink(cu1, u1);

//		  u1 -r-> u2
//		  |        
//		  |h       
//		  v        
//		  h1 -r-> h2

		Unit u1 = addUnit(top, "u1");
		Requirement u1r1 = addRequirement(u1, "r1", CorePackage.Literals.CAPABILITY, RequirementLinkTypes.HOSTING_LITERAL);
		u1.setConceptual(true);
		Unit u2 = addUnit(top, "u2");
		Requirement u2r1 = addRequirement(u2, "r1", CorePackage.Literals.CAPABILITY, RequirementLinkTypes.HOSTING_LITERAL);
		u2.setConceptual(false);
		Unit h1 = addUnit(top, "h1");
		h1.setConceptual(true);
		Capability h1c1 = addCapability(h1, "c1", CapabilityLinkTypes.HOSTING_LITERAL);
		Unit h2 = addUnit(top, "h2");
		h2.setConceptual(false);
		Capability h2c1 = addCapability(h2, "c1", CapabilityLinkTypes.HOSTING_LITERAL);
		
		LinkFactory.createRealizationLink(u1, u2);
		LinkFactory.createRealizationLink(h1, h2);
		LinkFactory.createHostingLink(h1, u1);
		
		// assert immediate host(u1) == h1
		// assert final host(u1) == h2
		// assert immediate host(u2) == null
		// assert final host(u2) = h2
		
		assertSetEquals(ValidatorUtils.getImmediateHosts(u1), new Object[] { h1 });
		assertEquals(ValidatorUtils.getHost(u1), h2);
		assertSetEquals(ValidatorUtils.getImmediateHosts(u2), new Object[] {  });
		assertEquals(ValidatorUtils.getHost(u2), h2 );

//		  u1 -r-> u2
//		  |       |
//		  |h      |h
//		  v       v
//		  h1 -r-> h2
		

		LinkFactory.createHostingLink(h2, u2);

		assertSetEquals(ValidatorUtils.getImmediateHosts(u1), new Object[] { h1 });
		assertEquals(ValidatorUtils.getHost(u1), h2);
		assertSetEquals(ValidatorUtils.getImmediateHosts(u2), new Object[] { h2 });
		assertEquals(ValidatorUtils.getHost(u2), h2 );
		 

//				 u1 -r-> u2
//			      |       |
//			      |h      |h
//			   	  v       v
//		  h3 <-r- h1 -r-> h2 

		Unit h3 = addUnit(top, "h3");
		Capability h3c1 = addCapability(h1, "c1", CapabilityLinkTypes.HOSTING_LITERAL);
		h3.setConceptual(false);
		LinkFactory.createRealizationLink(h1, h3);

		assertSetEquals(ValidatorUtils.getImmediateHosts(u1), new Object[] { h1 });
		assertEquals(ValidatorUtils.getHost(u1), null);
		assertSetEquals(ValidatorUtils.getImmediateHosts(u2), new Object[] { h2 });
		assertEquals(ValidatorUtils.getHost(u2), h2 );
		

		// u3 <-r- u1 -r-> u2
		//	       |       |
		//	       |h      |h
		//	   	   v       v
		// h3 <-r- h1 -r-> h2 
		
		Unit u3 = addUnit(top, "u3");
		Requirement u3r1 = addRequirement(u2, "r1", CorePackage.Literals.CAPABILITY, RequirementLinkTypes.HOSTING_LITERAL); 
		u3.setConceptual(false);
		LinkFactory.createRealizationLink(u1, u3);
		
		assertSetEquals(ValidatorUtils.getImmediateHosts(u1), new Object[] { h1 });
		assertEquals(ValidatorUtils.getHost(u1), null);
		assertSetEquals(ValidatorUtils.getAllHosts(u1), new Object[] { h2, h3 } );
		
		assertSetEquals(ValidatorUtils.getImmediateHosts(u2), new Object[] { h2 });
		assertEquals(ValidatorUtils.getHost(u2), h2 );
		assertSetEquals(ValidatorUtils.getAllHosts(u2), new Object[] { h2 } );
		
		assertSetEquals(ValidatorUtils.getImmediateHosts(u3), new Object[] {  });
		assertEquals(ValidatorUtils.getHost(u3), null );
		assertSetEquals(ValidatorUtils.getAllHosts(u3), new Object[] { h2, h3 } );
		

		// u3 <-r- u1 -r-> u2
		// |	    |       |
		// |h       |h      |h
		// v	    v       v
		// h3 <-r- h1 -r-> h2 

		LinkFactory.createHostingLink(h3, u3);
		
		assertSetEquals(ValidatorUtils.getImmediateHosts(u1), new Object[] { h1 });
		assertEquals(ValidatorUtils.getHost(u1), null);
		assertSetEquals(ValidatorUtils.getAllHosts(u1), new Object[] { h2, h3 } );
		
		assertSetEquals(ValidatorUtils.getImmediateHosts(u2), new Object[] { h2 });
		assertEquals(ValidatorUtils.getHost(u2), h2 );
		assertSetEquals(ValidatorUtils.getAllHosts(u2), new Object[] { h2 } );
		
		assertSetEquals(ValidatorUtils.getImmediateHosts(u3), new Object[] { h3 });
		assertEquals(ValidatorUtils.getHost(u3), h3 );
		assertSetEquals(ValidatorUtils.getAllHosts(u3), new Object[] { h3 } );
	}
}
