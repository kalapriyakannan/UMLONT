/*******************************************************************************
 * Copyright (c) 2003, 2007 IBM Corporation Licensed Material - Property of IBM. All rights reserved.
 *  
 * US Government Users Restricted Rights - Use, duplication or disclosure v1.0 restricted by GSA ADP
 * Schedule Contract with IBM Corp.
 * 
 * Contributors: IBM Corporation - initial API and implementation
 *******************************************************************************/
package com.ibm.ccl.soa.deploy.core.test.provider.discovery;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.ibm.ccl.soa.deploy.core.Capability;
import com.ibm.ccl.soa.deploy.core.CapabilityLinkTypes;
import com.ibm.ccl.soa.deploy.core.CoreFactory;
import com.ibm.ccl.soa.deploy.core.CorePackage;
import com.ibm.ccl.soa.deploy.core.DependencyLink;
import com.ibm.ccl.soa.deploy.core.DiscoveryFilter;
import com.ibm.ccl.soa.deploy.core.Requirement;
import com.ibm.ccl.soa.deploy.core.Topology;
import com.ibm.ccl.soa.deploy.core.TopologyDiscoverer;
import com.ibm.ccl.soa.deploy.core.Unit;
import com.ibm.ccl.soa.deploy.core.UnitDescriptor;
import com.ibm.ccl.soa.deploy.core.provider.discovery.CurrentTopologyDiscoverer;
import com.ibm.ccl.soa.deploy.core.provider.discovery.DiscoveryFilterFactory;
import com.ibm.ccl.soa.deploy.core.test.TopologyTestCase;
import com.ibm.ccl.soa.deploy.core.validator.DeployValidatorService;
import com.ibm.ccl.soa.deploy.core.validator.ValidatorUtils;
import com.ibm.ccl.soa.deploy.core.validator.matcher.LinkFactory;
import com.ibm.ccl.soa.deploy.core.validator.matcher.LinkType;

/**
 * @author Michael Kalantar
 */
public class CurrentTopologyDiscovererTest extends TopologyTestCase {

	private static final String PROJECT_NAME = "CurrentTopologyDiscovererTest";

	/** Shared validator instance. */
	private TopologyDiscoverer discoverer;
	private Unit u1;
	private Unit u2;
	private Unit u3;
	private Unit u4;
	private Unit g1;
	private Unit g2;

	public CurrentTopologyDiscovererTest() {
		super(PROJECT_NAME);
	}

	public CurrentTopologyDiscovererTest(String name) {
		super(name);
	}

	/*
	 * @see junit.framework.TestCase#setUp()
	 */
	protected void setUp() throws Exception {
		super.setUp();
		discoverer = new CurrentTopologyDiscoverer();
	}

	public void testDiscoverer() throws IOException {

		Topology t = createTestTopology();

		getHostTest(t);
		getHostedTest(t);
		getTargetTest(t);
		getSourcesTest(t);
		getMembersTest(t);
		getGroupsTest(t);

		getPossibleHostsTest(t);
		getPossibleHostedTest(t);
		getPossibleTargetsTest(t);
		getPossibleSourcesTest(t);
		getPossibleMembersTest(t);
		getPossibleGroupsTest(t);
	}

	private void getHostTest(Topology t) {
		final String thisMethod = "getHostTest";
		int call = 1;
		DiscoveryFilter filter;
		List uL;

		filter = DiscoveryFilterFactory.createFindHostFilter(u1, t);
		assert !DiscoveryFilterFactory.isFindGroupsFilter(filter);
		assert !DiscoveryFilterFactory.isFindHostedFilter(filter);
		assert DiscoveryFilterFactory.isFindHostFilter(filter);
		assert !DiscoveryFilterFactory.isFindMembersFilter(filter);
		assert !DiscoveryFilterFactory.isFindPossibleGroupsFilter(filter);
		assert !DiscoveryFilterFactory.isFindPossibleHostsFilter(filter);
		assert !DiscoveryFilterFactory.isFindPossibleHostedFilter(filter);
		assert !DiscoveryFilterFactory.isFindPossibleMembersFilter(filter);
		assert !DiscoveryFilterFactory.isFindPossibleTargetsFilter(filter);
		assert !DiscoveryFilterFactory.isFollowDependencyFilter(filter);
		uL = toUnitList(discoverer.findAll(filter));
		dumpUL(thisMethod + "." + call++, uL);
		assert 0 == uL.size() : uL.size();

		filter = DiscoveryFilterFactory.createFindHostFilter(u2, t);
		assert !DiscoveryFilterFactory.isFindGroupsFilter(filter);
		assert !DiscoveryFilterFactory.isFindHostedFilter(filter);
		assert DiscoveryFilterFactory.isFindHostFilter(filter);
		assert !DiscoveryFilterFactory.isFindMembersFilter(filter);
		assert !DiscoveryFilterFactory.isFindPossibleGroupsFilter(filter);
		assert !DiscoveryFilterFactory.isFindPossibleHostsFilter(filter);
		assert !DiscoveryFilterFactory.isFindPossibleHostedFilter(filter);
		assert !DiscoveryFilterFactory.isFindPossibleMembersFilter(filter);
		assert !DiscoveryFilterFactory.isFindPossibleTargetsFilter(filter);
		assert !DiscoveryFilterFactory.isFollowDependencyFilter(filter);
		assert 0 == uL.size() : uL.size();
		uL = toUnitList(discoverer.findAll(filter));
		dumpUL(thisMethod + "." + call++, uL);
		assert 1 == uL.size() : uL.size();
		assert uL.contains(u1) : "u1 not found as host for u2";

		filter = DiscoveryFilterFactory.createFindHostFilter(u3, t);
		assert !DiscoveryFilterFactory.isFindGroupsFilter(filter);
		assert !DiscoveryFilterFactory.isFindHostedFilter(filter);
		assert DiscoveryFilterFactory.isFindHostFilter(filter);
		assert !DiscoveryFilterFactory.isFindMembersFilter(filter);
		assert !DiscoveryFilterFactory.isFindPossibleGroupsFilter(filter);
		assert !DiscoveryFilterFactory.isFindPossibleHostsFilter(filter);
		assert !DiscoveryFilterFactory.isFindPossibleHostedFilter(filter);
		assert !DiscoveryFilterFactory.isFindPossibleMembersFilter(filter);
		assert !DiscoveryFilterFactory.isFindPossibleTargetsFilter(filter);
		assert !DiscoveryFilterFactory.isFollowDependencyFilter(filter);
		uL = toUnitList(discoverer.findAll(filter));
		dumpUL(thisMethod + "." + call++, uL);
		assert 1 == uL.size() : uL.size();
		assert uL.contains(u1) : "u1 not found as host for u3";

		filter = DiscoveryFilterFactory.createFindHostFilter(u4, t);
		assert !DiscoveryFilterFactory.isFindGroupsFilter(filter);
		assert !DiscoveryFilterFactory.isFindHostedFilter(filter);
		assert DiscoveryFilterFactory.isFindHostFilter(filter);
		assert !DiscoveryFilterFactory.isFindMembersFilter(filter);
		assert !DiscoveryFilterFactory.isFindPossibleGroupsFilter(filter);
		assert !DiscoveryFilterFactory.isFindPossibleHostsFilter(filter);
		assert !DiscoveryFilterFactory.isFindPossibleHostedFilter(filter);
		assert !DiscoveryFilterFactory.isFindPossibleMembersFilter(filter);
		assert !DiscoveryFilterFactory.isFindPossibleTargetsFilter(filter);
		assert !DiscoveryFilterFactory.isFollowDependencyFilter(filter);
		uL = toUnitList(discoverer.findAll(filter));
		dumpUL(thisMethod + "." + call++, uL);
		assert 0 == uL.size() : uL.size();

		filter = DiscoveryFilterFactory.createFindHostFilter(g1, t);
		assert !DiscoveryFilterFactory.isFindGroupsFilter(filter);
		assert !DiscoveryFilterFactory.isFindHostedFilter(filter);
		assert DiscoveryFilterFactory.isFindHostFilter(filter);
		assert !DiscoveryFilterFactory.isFindMembersFilter(filter);
		assert !DiscoveryFilterFactory.isFindPossibleGroupsFilter(filter);
		assert !DiscoveryFilterFactory.isFindPossibleHostsFilter(filter);
		assert !DiscoveryFilterFactory.isFindPossibleHostedFilter(filter);
		assert !DiscoveryFilterFactory.isFindPossibleMembersFilter(filter);
		assert !DiscoveryFilterFactory.isFindPossibleTargetsFilter(filter);
		assert !DiscoveryFilterFactory.isFollowDependencyFilter(filter);
		uL = toUnitList(discoverer.findAll(filter));
		dumpUL(thisMethod + "." + call++, uL);
		assert 0 == uL.size() : uL.size();

		filter = DiscoveryFilterFactory.createFindHostFilter(g2, t);
		assert !DiscoveryFilterFactory.isFindGroupsFilter(filter);
		assert !DiscoveryFilterFactory.isFindHostedFilter(filter);
		assert DiscoveryFilterFactory.isFindHostFilter(filter);
		assert !DiscoveryFilterFactory.isFindMembersFilter(filter);
		assert !DiscoveryFilterFactory.isFindPossibleGroupsFilter(filter);
		assert !DiscoveryFilterFactory.isFindPossibleHostsFilter(filter);
		assert !DiscoveryFilterFactory.isFindPossibleHostedFilter(filter);
		assert !DiscoveryFilterFactory.isFindPossibleMembersFilter(filter);
		assert !DiscoveryFilterFactory.isFindPossibleTargetsFilter(filter);
		assert !DiscoveryFilterFactory.isFollowDependencyFilter(filter);
		uL = toUnitList(discoverer.findAll(filter));
		dumpUL(thisMethod + "." + call++, uL);
		assert 0 == uL.size() : uL.size();
	}

	private void getHostedTest(Topology t) {
		final String thisMethod = "getHostedTest";
		int call = 1;
		DiscoveryFilter filter;
		List uL;

		filter = DiscoveryFilterFactory.createFindHostedFilter(u1, t);
		uL = toUnitList(discoverer.findAll(filter));
		dumpUL(thisMethod + "." + call++, uL);
		assert 2 == uL.size() : uL.size();
		assert uL.contains(u2) : "u2 not found as hosted on u1";
		assert uL.contains(u3) : "u3 not found as hosted on u1";

		filter = DiscoveryFilterFactory.createFindHostedFilter(u2, t);
		uL = toUnitList(discoverer.findAll(filter));
		dumpUL(thisMethod + "." + call++, uL);
		assert 0 == uL.size() : uL.size();

		filter = DiscoveryFilterFactory.createFindHostedFilter(u3, t);
		uL = toUnitList(discoverer.findAll(filter));
		dumpUL(thisMethod + "." + call++, uL);
		assert 0 == uL.size() : uL.size();

		filter = DiscoveryFilterFactory.createFindHostedFilter(u4, t);
		uL = toUnitList(discoverer.findAll(filter));
		dumpUL(thisMethod + "." + call++, uL);
		assert 0 == uL.size() : uL.size();

		filter = DiscoveryFilterFactory.createFindHostedFilter(g1, t);
		uL = toUnitList(discoverer.findAll(filter));
		dumpUL(thisMethod + "." + call++, uL);
		assert 0 == uL.size() : uL.size();

		filter = DiscoveryFilterFactory.createFindHostedFilter(g2, t);
		uL = toUnitList(discoverer.findAll(filter));
		dumpUL(thisMethod + "." + call++, uL);
		assert 0 == uL.size() : uL.size();
	}

	private void getTargetTest(Topology t) {
		final String thisMethod = "getTargetTest";
		int call = 1;
		DiscoveryFilter filter;
		List uL;

		filter = DiscoveryFilterFactory.createFindTargetFilter(u1, null, t);
		uL = toUnitList(discoverer.findAll(filter));
		dumpUL(thisMethod + "." + call++, uL);
		assert 0 == uL.size() : uL.size();

		Requirement u2r1 = (Requirement) t.resolve("/u2/dR1");
		filter = DiscoveryFilterFactory.createFindTargetFilter(u2, u2r1, t);
		uL = toUnitList(discoverer.findAll(filter));
		dumpUL(thisMethod + "." + call++, uL);
		assert 1 == uL.size() : uL.size();
		assert uL.contains(u4) : "u4 not found as target of u2.dR1";

		filter = DiscoveryFilterFactory.createFindTargetFilter(u3,
				(Requirement) t.resolve("/u3/dR1"), t);
		uL = toUnitList(discoverer.findAll(filter));
		dumpUL(thisMethod + "." + call++, uL);
		assert 1 == uL.size() : uL.size();
		assert uL.contains(u4) : "u4 not found as target of u3.dR1";

		filter = DiscoveryFilterFactory.createFindTargetFilter(u4,
				(Requirement) t.resolve("/u2/hR1"), t);
		uL = toUnitList(discoverer.findAll(filter));
		dumpUL(thisMethod + "." + call++, uL);
		assert 0 == uL.size() : uL.size();

		filter = DiscoveryFilterFactory.createFindTargetFilter(g1,
				(Requirement) t.resolve("/u2/dR1"), t);
		uL = toUnitList(discoverer.findAll(filter));
		dumpUL(thisMethod + "." + call++, uL);
		assert 0 == uL.size() : uL.size();

		filter = DiscoveryFilterFactory.createFindTargetFilter(g2,
				(Requirement) t.resolve("/u2/mR1"), t);
		uL = toUnitList(discoverer.findAll(filter));
		dumpUL(thisMethod + "." + call++, uL);
		assert 0 == uL.size() : uL.size();
	}

	private void getSourcesTest(Topology t) {
		final String thisMethod = "getSourcesTest";
		int call = 1;
		DiscoveryFilter filter;
		List uL;

		filter = DiscoveryFilterFactory.createFindSourcesFilter(u1,
				(Capability) t.resolve("/u1/c1"), t);
		uL = toUnitList(discoverer.findAll(filter));
		dumpUL(thisMethod + "." + call++, uL);
		assert 0 == uL.size() : uL.size();

		filter = DiscoveryFilterFactory.createFindSourcesFilter(u2,
				(Capability) t.resolve("/u2/c1"), t);
		uL = toUnitList(discoverer.findAll(filter));
		dumpUL(thisMethod + "." + call++, uL);
		assert 0 == uL.size() : uL.size();

		filter = DiscoveryFilterFactory.createFindSourcesFilter(u3,
				(Capability) t.resolve("/u3/c1"), t);
		uL = toUnitList(discoverer.findAll(filter));
		dumpUL(thisMethod + "." + call++, uL);
		assert 0 == uL.size() : uL.size();

		filter = DiscoveryFilterFactory.createFindSourcesFilter(u4,
				(Capability) t.resolve("/u4/c1"), t);
		uL = toUnitList(discoverer.findAll(filter));
		dumpUL(thisMethod + "." + call++, uL);
		assert 2 == uL.size() : uL.size();
		assert uL.contains(u2) : "u2 not found as source of u4.c1";
		assert uL.contains(u3) : "u3 not found as target of u4.c1";

		filter = DiscoveryFilterFactory.createFindSourcesFilter(g1,
				(Capability) t.resolve("/g1/c1"), t);
		uL = toUnitList(discoverer.findAll(filter));
		dumpUL(thisMethod + "." + call++, uL);
		assert 0 == uL.size() : uL.size();

		filter = DiscoveryFilterFactory.createFindSourcesFilter(g2,
				(Capability) t.resolve("/g2/c1"), t);
		uL = toUnitList(discoverer.findAll(filter));
		dumpUL(thisMethod + "." + call++, uL);
		assert 0 == uL.size() : uL.size();
	}

	private void getMembersTest(Topology t) {
		final String thisMethod = "getMembersTest";
		int call = 1;
		DiscoveryFilter filter;
		List uL;

		filter = DiscoveryFilterFactory.createFindMembersFilter(u1, null, t);
		uL = toUnitList(discoverer.findAll(filter));
		dumpUL(thisMethod + "." + call++, uL);
		assert 0 == uL.size() : uL.size();

		filter = DiscoveryFilterFactory.createFindMembersFilter(u2,
				(Requirement) t.resolve("/u2/dR1"), t);
		uL = toUnitList(discoverer.findAll(filter));
		dumpUL(thisMethod + "." + call++, uL);
		assert 0 == uL.size() : uL.size();

		filter = DiscoveryFilterFactory.createFindMembersFilter(u3,
				(Requirement) t.resolve("/u3/dR1"), t);
		uL = toUnitList(discoverer.findAll(filter));
		dumpUL(thisMethod + "." + call++, uL);
		assert 0 == uL.size() : uL.size();

		filter = DiscoveryFilterFactory.createFindMembersFilter(u4,
				(Requirement) t.resolve("/u4/hR1"), t);
		uL = toUnitList(discoverer.findAll(filter));
		dumpUL(thisMethod + "." + call++, uL);
		assert 0 == uL.size() : uL.size();

		filter = DiscoveryFilterFactory.createFindMembersFilter(g1,
				(Requirement) t.resolve("/g1/mR1"), t);
		uL = toUnitList(discoverer.findAll(filter));
		dumpUL(thisMethod + "." + call++, uL);
		assert 2 == uL.size() : uL.size();
		assert uL.contains(u2) : "u2 not found as member of group g1.mR1";
		assert uL.contains(u3) : "u3 not found as member of group g1.mR1";

		filter = DiscoveryFilterFactory.createFindMembersFilter(g2,
				(Requirement) t.resolve("/g2/mR1"), t);
		uL = toUnitList(discoverer.findAll(filter));
		dumpUL(thisMethod + "." + call++, uL);
		assert 2 == uL.size() : uL.size();
		assert uL.contains(u3) : "u3 not found as member of group g2.mR1";
		assert uL.contains(u4) : "u4 not found as member of group g2.mR1";
	}

	private void getGroupsTest(Topology t) {
		final String thisMethod = "getGroupsTest";
		int call = 1;
		DiscoveryFilter filter;
		List uL;

		filter = DiscoveryFilterFactory.createFindGroupsFilter(u1, null, t);
		assert DiscoveryFilterFactory.isFindGroupsFilter(filter);
		assert !DiscoveryFilterFactory.isFindHostedFilter(filter);
		assert !DiscoveryFilterFactory.isFindHostFilter(filter);
		assert !DiscoveryFilterFactory.isFindMembersFilter(filter);
		assert !DiscoveryFilterFactory.isFindPossibleGroupsFilter(filter);
		assert !DiscoveryFilterFactory.isFindPossibleHostsFilter(filter);
		assert !DiscoveryFilterFactory.isFindPossibleHostedFilter(filter);
		assert !DiscoveryFilterFactory.isFindPossibleMembersFilter(filter);
		assert !DiscoveryFilterFactory.isFindPossibleTargetsFilter(filter);
		assert !DiscoveryFilterFactory.isFollowDependencyFilter(filter);
		uL = toUnitList(discoverer.findAll(filter));
		dumpUL(thisMethod + "." + call++, uL);
		assert 0 == uL.size() : uL.size();

		filter = DiscoveryFilterFactory.createFindGroupsFilter(u2, null, t);
		assert DiscoveryFilterFactory.isFindGroupsFilter(filter);
		assert !DiscoveryFilterFactory.isFindHostedFilter(filter);
		assert !DiscoveryFilterFactory.isFindHostFilter(filter);
		assert !DiscoveryFilterFactory.isFindMembersFilter(filter);
		assert !DiscoveryFilterFactory.isFindPossibleGroupsFilter(filter);
		assert !DiscoveryFilterFactory.isFindPossibleHostsFilter(filter);
		assert !DiscoveryFilterFactory.isFindPossibleHostedFilter(filter);
		assert !DiscoveryFilterFactory.isFindPossibleMembersFilter(filter);
		assert !DiscoveryFilterFactory.isFindPossibleTargetsFilter(filter);
		assert !DiscoveryFilterFactory.isFollowDependencyFilter(filter);
		uL = toUnitList(discoverer.findAll(filter));
		dumpUL(thisMethod + "." + call++, uL);
		assert 1 == uL.size() : uL.size();
		assert uL.contains(g1) : "g1 not found as group containing u2";

		filter = DiscoveryFilterFactory.createFindGroupsFilter(u3, null, t);
		assert DiscoveryFilterFactory.isFindGroupsFilter(filter);
		assert !DiscoveryFilterFactory.isFindHostedFilter(filter);
		assert !DiscoveryFilterFactory.isFindHostFilter(filter);
		assert !DiscoveryFilterFactory.isFindMembersFilter(filter);
		assert !DiscoveryFilterFactory.isFindPossibleGroupsFilter(filter);
		assert !DiscoveryFilterFactory.isFindPossibleHostsFilter(filter);
		assert !DiscoveryFilterFactory.isFindPossibleHostedFilter(filter);
		assert !DiscoveryFilterFactory.isFindPossibleMembersFilter(filter);
		assert !DiscoveryFilterFactory.isFindPossibleTargetsFilter(filter);
		assert !DiscoveryFilterFactory.isFollowDependencyFilter(filter);
		uL = toUnitList(discoverer.findAll(filter));
		dumpUL(thisMethod + "." + call++, uL);
		assert 2 == uL.size() : uL.size();
		assert uL.contains(g1) : "g1 not found as group containing u3";
		assert uL.contains(g2) : "g2 not found as group containing u3";

		filter = DiscoveryFilterFactory.createFindGroupsFilter(u4, null, t);
		assert DiscoveryFilterFactory.isFindGroupsFilter(filter);
		assert !DiscoveryFilterFactory.isFindHostedFilter(filter);
		assert !DiscoveryFilterFactory.isFindHostFilter(filter);
		assert !DiscoveryFilterFactory.isFindMembersFilter(filter);
		assert !DiscoveryFilterFactory.isFindPossibleGroupsFilter(filter);
		assert !DiscoveryFilterFactory.isFindPossibleHostsFilter(filter);
		assert !DiscoveryFilterFactory.isFindPossibleHostedFilter(filter);
		assert !DiscoveryFilterFactory.isFindPossibleMembersFilter(filter);
		assert !DiscoveryFilterFactory.isFindPossibleTargetsFilter(filter);
		assert !DiscoveryFilterFactory.isFollowDependencyFilter(filter);
		uL = toUnitList(discoverer.findAll(filter));
		dumpUL(thisMethod + "." + call++, uL);
		assert 1 == uL.size() : uL.size();
		assert uL.contains(g2) : "g1 not found as group containing u4";

		filter = DiscoveryFilterFactory.createFindGroupsFilter(g1,
				(Requirement) t.resolve("/g1/mR1"), t);
		assert !DiscoveryFilterFactory.isFindGroupsFilter(filter);
		assert !DiscoveryFilterFactory.isFindHostedFilter(filter);
		assert !DiscoveryFilterFactory.isFindHostFilter(filter);
// FIXME
// assert !DiscoveryFilterFactory.isFindMembersFilter(filter);
		assert !DiscoveryFilterFactory.isFindPossibleGroupsFilter(filter);
		assert !DiscoveryFilterFactory.isFindPossibleHostsFilter(filter);
		assert !DiscoveryFilterFactory.isFindPossibleHostedFilter(filter);
		assert !DiscoveryFilterFactory.isFindPossibleMembersFilter(filter);
		assert !DiscoveryFilterFactory.isFindPossibleTargetsFilter(filter);
		assert !DiscoveryFilterFactory.isFollowDependencyFilter(filter);
		uL = toUnitList(discoverer.findAll(filter));
		dumpUL(thisMethod + "." + call++, uL);
// FIXME
// assert 0 == uL.size() : uL.size();

		filter = DiscoveryFilterFactory.createFindGroupsFilter(g2,
				(Requirement) t.resolve("/g2/mR1"), t);
		assert !DiscoveryFilterFactory.isFindGroupsFilter(filter);
		assert !DiscoveryFilterFactory.isFindHostedFilter(filter);
		assert !DiscoveryFilterFactory.isFindHostFilter(filter);
// FIXME
// assert !DiscoveryFilterFactory.isFindMembersFilter(filter);
		assert !DiscoveryFilterFactory.isFindPossibleGroupsFilter(filter);
		assert !DiscoveryFilterFactory.isFindPossibleHostsFilter(filter);
		assert !DiscoveryFilterFactory.isFindPossibleHostedFilter(filter);
		assert !DiscoveryFilterFactory.isFindPossibleMembersFilter(filter);
		assert !DiscoveryFilterFactory.isFindPossibleTargetsFilter(filter);
		assert !DiscoveryFilterFactory.isFollowDependencyFilter(filter);
		uL = toUnitList(discoverer.findAll(filter));
		dumpUL(thisMethod + "." + call++, uL);
// FIXME
// assert 0 == uL.size() : uL.size();
	}

	private void getPossibleHostsTest(Topology t) {
		final String thisMethod = "getPossibleHostsTest";
		int call = 1;
		DiscoveryFilter filter;
		List uL;

		filter = DiscoveryFilterFactory.createFindPossibleHostsFilter(u1, t);
		assert (null == filter); // no hosting requirements
		assert !DiscoveryFilterFactory.isFindGroupsFilter(filter);
		assert !DiscoveryFilterFactory.isFindHostedFilter(filter);
		assert !DiscoveryFilterFactory.isFindHostFilter(filter);
		assert !DiscoveryFilterFactory.isFindMembersFilter(filter);
		assert !DiscoveryFilterFactory.isFindPossibleGroupsFilter(filter);
		assert !DiscoveryFilterFactory.isFindPossibleHostsFilter(filter);
		assert !DiscoveryFilterFactory.isFindPossibleHostedFilter(filter);
		assert !DiscoveryFilterFactory.isFindPossibleMembersFilter(filter);
		assert !DiscoveryFilterFactory.isFindPossibleTargetsFilter(filter);
		assert !DiscoveryFilterFactory.isFollowDependencyFilter(filter);
		uL = toUnitList(discoverer.findAll(filter));
		dumpUL(thisMethod + "." + call++, uL);
		assert 0 == uL.size() : uL.size();

		filter = DiscoveryFilterFactory.createFindPossibleHostsFilter(u2, t);
		assert !DiscoveryFilterFactory.isFindGroupsFilter(filter);
		assert !DiscoveryFilterFactory.isFindHostedFilter(filter);
		assert !DiscoveryFilterFactory.isFindHostFilter(filter);
		assert !DiscoveryFilterFactory.isFindMembersFilter(filter);
		assert !DiscoveryFilterFactory.isFindPossibleGroupsFilter(filter);
		assert DiscoveryFilterFactory.isFindPossibleHostsFilter(filter);
		assert !DiscoveryFilterFactory.isFindPossibleHostedFilter(filter);
		assert !DiscoveryFilterFactory.isFindPossibleMembersFilter(filter);
		assert !DiscoveryFilterFactory.isFollowDependencyFilter(filter);
		uL = toUnitList(discoverer.findAll(filter));
		dumpUL(thisMethod + "." + call++, uL);
		assert 0 == uL.size() : uL.size();

		filter = DiscoveryFilterFactory.createFindPossibleHostsFilter(u3, t);
		assert !DiscoveryFilterFactory.isFindGroupsFilter(filter);
		assert !DiscoveryFilterFactory.isFindHostedFilter(filter);
		assert !DiscoveryFilterFactory.isFindHostFilter(filter);
		assert !DiscoveryFilterFactory.isFindMembersFilter(filter);
		assert !DiscoveryFilterFactory.isFindPossibleGroupsFilter(filter);
		assert DiscoveryFilterFactory.isFindPossibleHostsFilter(filter);
		assert !DiscoveryFilterFactory.isFindPossibleHostedFilter(filter);
		assert !DiscoveryFilterFactory.isFindPossibleMembersFilter(filter);
		assert !DiscoveryFilterFactory.isFollowDependencyFilter(filter);
		uL = toUnitList(discoverer.findAll(filter));
		dumpUL(thisMethod + "." + call++, uL);
		assert 0 == uL.size() : uL.size();

		filter = DiscoveryFilterFactory.createFindPossibleHostsFilter(u4, t);
		assert !DiscoveryFilterFactory.isFindGroupsFilter(filter);
		assert !DiscoveryFilterFactory.isFindHostedFilter(filter);
		assert !DiscoveryFilterFactory.isFindHostFilter(filter);
		assert !DiscoveryFilterFactory.isFindMembersFilter(filter);
		assert !DiscoveryFilterFactory.isFindPossibleGroupsFilter(filter);
		assert DiscoveryFilterFactory.isFindPossibleHostsFilter(filter);
		assert !DiscoveryFilterFactory.isFindPossibleHostedFilter(filter);
		assert !DiscoveryFilterFactory.isFindPossibleMembersFilter(filter);
		assert !DiscoveryFilterFactory.isFollowDependencyFilter(filter);
		uL = toUnitList(discoverer.findAll(filter));
		dumpUL(thisMethod + "." + call++, uL);
		assert 1 == uL.size() : uL.size();
		assert uL.contains(u1) : "u1 not found as possible host for u4";

		filter = DiscoveryFilterFactory.createFindPossibleHostsFilter(g1, t);
		assert (null == filter); // no hosting requirements
		assert !DiscoveryFilterFactory.isFindGroupsFilter(filter);
		assert !DiscoveryFilterFactory.isFindHostedFilter(filter);
		assert !DiscoveryFilterFactory.isFindHostFilter(filter);
		assert !DiscoveryFilterFactory.isFindMembersFilter(filter);
		assert !DiscoveryFilterFactory.isFindPossibleGroupsFilter(filter);
		assert !DiscoveryFilterFactory.isFindPossibleHostsFilter(filter);
		assert !DiscoveryFilterFactory.isFindPossibleHostedFilter(filter);
		assert !DiscoveryFilterFactory.isFindPossibleMembersFilter(filter);
		assert !DiscoveryFilterFactory.isFollowDependencyFilter(filter);
		uL = toUnitList(discoverer.findAll(filter));
		dumpUL(thisMethod + "." + call++, uL);
		assert 0 == uL.size() : uL.size();

		filter = DiscoveryFilterFactory.createFindPossibleHostsFilter(g2, t);
		assert !DiscoveryFilterFactory.isFindGroupsFilter(filter);
		assert !DiscoveryFilterFactory.isFindHostedFilter(filter);
		assert !DiscoveryFilterFactory.isFindHostFilter(filter);
		assert !DiscoveryFilterFactory.isFindMembersFilter(filter);
		assert !DiscoveryFilterFactory.isFindPossibleGroupsFilter(filter);
		assert DiscoveryFilterFactory.isFindPossibleHostsFilter(filter);
		assert !DiscoveryFilterFactory.isFindPossibleHostedFilter(filter);
		assert !DiscoveryFilterFactory.isFindPossibleMembersFilter(filter);
		assert !DiscoveryFilterFactory.isFindPossibleTargetsFilter(filter);
		assert !DiscoveryFilterFactory.isFollowDependencyFilter(filter);
		uL = toUnitList(discoverer.findAll(filter));
		dumpUL(thisMethod + "." + call++, uL);
		assert 2 == uL.size() : uL.size();
		assert uL.contains(u1) : "u1 not found as possible host for g2";
		assert uL.contains(u4) : "u4 not found as possible host for g2";
	}

	private void getPossibleHostedTest(Topology t) {
		final String thisMethod = "getPossibleHostedTest";
		int call = 1;
		DiscoveryFilter filter;
		List uL;

		filter = DiscoveryFilterFactory.createFindPossibleHostedFilter(u1, t);
		assert !DiscoveryFilterFactory.isFindGroupsFilter(filter);
		assert !DiscoveryFilterFactory.isFindHostedFilter(filter);
		assert !DiscoveryFilterFactory.isFindHostFilter(filter);
		assert !DiscoveryFilterFactory.isFindMembersFilter(filter);
		assert !DiscoveryFilterFactory.isFindPossibleGroupsFilter(filter);
		assert !DiscoveryFilterFactory.isFindPossibleHostsFilter(filter);
		assert DiscoveryFilterFactory.isFindPossibleHostedFilter(filter);
		assert !DiscoveryFilterFactory.isFindPossibleMembersFilter(filter);
		assert !DiscoveryFilterFactory.isFindPossibleTargetsFilter(filter);
		assert !DiscoveryFilterFactory.isFollowDependencyFilter(filter);
		uL = toUnitList(discoverer.findAll(filter));
		dumpUL(thisMethod + "." + call++, uL);
		assert 2 == uL.size() : uL.size();
		assert uL.contains(u4) : "u4 not found as possible hostee of u1";
		assert uL.contains(g2) : "u2 not found as possible hostee of u1";

		filter = DiscoveryFilterFactory.createFindPossibleHostedFilter(u2, t);
		assert (null == filter); // no capabilities
		assert !DiscoveryFilterFactory.isFindGroupsFilter(filter);
		assert !DiscoveryFilterFactory.isFindHostedFilter(filter);
		assert !DiscoveryFilterFactory.isFindHostFilter(filter);
		assert !DiscoveryFilterFactory.isFindMembersFilter(filter);
		assert !DiscoveryFilterFactory.isFindPossibleGroupsFilter(filter);
		assert !DiscoveryFilterFactory.isFindPossibleHostsFilter(filter);
		assert !DiscoveryFilterFactory.isFindPossibleHostedFilter(filter);
		assert !DiscoveryFilterFactory.isFindPossibleMembersFilter(filter);
		assert !DiscoveryFilterFactory.isFindPossibleTargetsFilter(filter);
		assert !DiscoveryFilterFactory.isFollowDependencyFilter(filter);
		uL = toUnitList(discoverer.findAll(filter));
		dumpUL(thisMethod + "." + call++, uL);
		assert 0 == uL.size() : uL.size();

		filter = DiscoveryFilterFactory.createFindPossibleHostedFilter(u3, t);
		assert (null == filter); // no capabilities
		assert !DiscoveryFilterFactory.isFindGroupsFilter(filter);
		assert !DiscoveryFilterFactory.isFindHostedFilter(filter);
		assert !DiscoveryFilterFactory.isFindHostFilter(filter);
		assert !DiscoveryFilterFactory.isFindMembersFilter(filter);
		assert !DiscoveryFilterFactory.isFindPossibleGroupsFilter(filter);
		assert !DiscoveryFilterFactory.isFindPossibleHostsFilter(filter);
		assert !DiscoveryFilterFactory.isFindPossibleMembersFilter(filter);
		assert !DiscoveryFilterFactory.isFindPossibleTargetsFilter(filter);
		assert !DiscoveryFilterFactory.isFollowDependencyFilter(filter);
		uL = toUnitList(discoverer.findAll(filter));
		dumpUL(thisMethod + "." + call++, uL);
		assert 0 == uL.size() : uL.size();

		filter = DiscoveryFilterFactory.createFindPossibleHostedFilter(u4, t);
		assert !DiscoveryFilterFactory.isFindGroupsFilter(filter);
		assert !DiscoveryFilterFactory.isFindHostedFilter(filter);
		assert !DiscoveryFilterFactory.isFindHostFilter(filter);
		assert !DiscoveryFilterFactory.isFindMembersFilter(filter);
		assert !DiscoveryFilterFactory.isFindPossibleGroupsFilter(filter);
		assert !DiscoveryFilterFactory.isFindPossibleHostsFilter(filter);
		assert DiscoveryFilterFactory.isFindPossibleHostedFilter(filter);
		assert !DiscoveryFilterFactory.isFindPossibleMembersFilter(filter);
		assert !DiscoveryFilterFactory.isFindPossibleTargetsFilter(filter);
		assert !DiscoveryFilterFactory.isFollowDependencyFilter(filter);
		uL = toUnitList(discoverer.findAll(filter));
		dumpUL(thisMethod + "." + call++, uL);
		assert 1 == uL.size() : uL.size();
		assert uL.contains(g2) : "g2 not found as possible hostee of u4";

		filter = DiscoveryFilterFactory.createFindPossibleHostedFilter(g1, t);
		assert (null == filter); // no capabilities
		assert !DiscoveryFilterFactory.isFindGroupsFilter(filter);
		assert !DiscoveryFilterFactory.isFindHostedFilter(filter);
		assert !DiscoveryFilterFactory.isFindHostFilter(filter);
		assert !DiscoveryFilterFactory.isFindMembersFilter(filter);
		assert !DiscoveryFilterFactory.isFindPossibleGroupsFilter(filter);
		assert !DiscoveryFilterFactory.isFindPossibleHostsFilter(filter);
		assert !DiscoveryFilterFactory.isFindPossibleHostedFilter(filter);
		assert !DiscoveryFilterFactory.isFindPossibleMembersFilter(filter);
		assert !DiscoveryFilterFactory.isFindPossibleTargetsFilter(filter);
		assert !DiscoveryFilterFactory.isFollowDependencyFilter(filter);
		uL = toUnitList(discoverer.findAll(filter));
		dumpUL(thisMethod + "." + call++, uL);
		assert 0 == uL.size() : uL.size();

		filter = DiscoveryFilterFactory.createFindPossibleHostedFilter(g2, t);
		assert (null == filter); // no capabilities
		assert !DiscoveryFilterFactory.isFindGroupsFilter(filter);
		assert !DiscoveryFilterFactory.isFindHostedFilter(filter);
		assert !DiscoveryFilterFactory.isFindHostFilter(filter);
		assert !DiscoveryFilterFactory.isFindMembersFilter(filter);
		assert !DiscoveryFilterFactory.isFindPossibleGroupsFilter(filter);
		assert !DiscoveryFilterFactory.isFindPossibleHostsFilter(filter);
		assert !DiscoveryFilterFactory.isFindPossibleHostedFilter(filter);
		assert !DiscoveryFilterFactory.isFindPossibleMembersFilter(filter);
		assert !DiscoveryFilterFactory.isFindPossibleTargetsFilter(filter);
		assert !DiscoveryFilterFactory.isFollowDependencyFilter(filter);
		uL = toUnitList(discoverer.findAll(filter));
		dumpUL(thisMethod + "." + call++, uL);
		assert 0 == uL.size() : uL.size();
	}

	private void getPossibleTargetsTest(Topology t) {
		final String thisMethod = "getPossibleTargetsTest";
		int call = 1;
		DiscoveryFilter filter;
		List uL;

		filter = DiscoveryFilterFactory.createFindPossibleTargetsFilter(u1,
				null, t);
		assert (null == filter);
		call++;

		filter = DiscoveryFilterFactory.createFindPossibleTargetsFilter(u2,
				(Requirement) t.resolve("u2/dR1"), t);
		assert !DiscoveryFilterFactory.isFindGroupsFilter(filter);
		assert !DiscoveryFilterFactory.isFindHostedFilter(filter);
		assert !DiscoveryFilterFactory.isFindHostFilter(filter);
		assert !DiscoveryFilterFactory.isFindMembersFilter(filter);
		assert !DiscoveryFilterFactory.isFindPossibleGroupsFilter(filter);
		assert !DiscoveryFilterFactory.isFindPossibleHostsFilter(filter);
		assert !DiscoveryFilterFactory.isFindPossibleHostedFilter(filter);
		assert !DiscoveryFilterFactory.isFindPossibleMembersFilter(filter);
		assert DiscoveryFilterFactory.isFindPossibleTargetsFilter(filter);
		assert !DiscoveryFilterFactory.isFollowDependencyFilter(filter);
		uL = toUnitList(discoverer.findAll(filter));
		dumpUL(thisMethod + "." + call++, uL);
		assert 0 == uL.size() : uL.size(); // unit u2 is already linked

		filter = DiscoveryFilterFactory.createFindPossibleTargetsFilter(u3,
				(Requirement) t.resolve("u3/dR1"), t);
		assert !DiscoveryFilterFactory.isFindGroupsFilter(filter);
		assert !DiscoveryFilterFactory.isFindHostedFilter(filter);
		assert !DiscoveryFilterFactory.isFindHostFilter(filter);
		assert !DiscoveryFilterFactory.isFindMembersFilter(filter);
		assert !DiscoveryFilterFactory.isFindPossibleGroupsFilter(filter);
		assert !DiscoveryFilterFactory.isFindPossibleHostsFilter(filter);
		assert !DiscoveryFilterFactory.isFindPossibleHostedFilter(filter);
		assert !DiscoveryFilterFactory.isFindPossibleMembersFilter(filter);
		assert DiscoveryFilterFactory.isFindPossibleTargetsFilter(filter);
		assert !DiscoveryFilterFactory.isFollowDependencyFilter(filter);
		uL = toUnitList(discoverer.findAll(filter));
		dumpUL(thisMethod + "." + call++, uL);
		assert 0 == uL.size() : uL.size(); // unit u3 is already linked

		filter = DiscoveryFilterFactory.createFindPossibleTargetsFilter(u4,
				(Requirement) t.resolve("u4/hR1"), t);
		assert (null == filter);
		call++;

		filter = DiscoveryFilterFactory.createFindPossibleTargetsFilter(g1,
				(Requirement) t.resolve("g1/dR1"), t);
		assert !DiscoveryFilterFactory.isFindGroupsFilter(filter);
		assert !DiscoveryFilterFactory.isFindHostedFilter(filter);
		assert !DiscoveryFilterFactory.isFindHostFilter(filter);
		assert !DiscoveryFilterFactory.isFindMembersFilter(filter);
		assert !DiscoveryFilterFactory.isFindPossibleGroupsFilter(filter);
		assert !DiscoveryFilterFactory.isFindPossibleHostsFilter(filter);
		assert !DiscoveryFilterFactory.isFindPossibleHostedFilter(filter);
		assert !DiscoveryFilterFactory.isFindPossibleMembersFilter(filter);
		assert DiscoveryFilterFactory.isFindPossibleTargetsFilter(filter);
		assert !DiscoveryFilterFactory.isFollowDependencyFilter(filter);
		uL = toUnitList(discoverer.findAll(filter));
		dumpUL(thisMethod + "." + call++, uL);
		assert 2 == uL.size() : uL.size();
		assert uL.contains(u1) : "u1 not possible target for g1.dR1";
		assert uL.contains(u4) : "u4 not possible target for g1.dR1";

		filter = DiscoveryFilterFactory.createFindPossibleTargetsFilter(g2,
				(Requirement) t.resolve("g2/mR1"), t);
		assert (null == filter);
	}

	private void getPossibleSourcesTest(Topology t) {
		final String thisMethod = "getPossibleSourcesTest";
		int call = 1;
		DiscoveryFilter filter;
		List uL;

	}

	private void getPossibleMembersTest(Topology t) {
		final String thisMethod = "getPossibleMembersTest";
		int call = 1;
		DiscoveryFilter filter;
		List uL;

		filter = DiscoveryFilterFactory.createFindPossibleMembersFilter(u1,
				null, t);
		assert !DiscoveryFilterFactory.isFindGroupsFilter(filter);
		assert !DiscoveryFilterFactory.isFindHostedFilter(filter);
		assert !DiscoveryFilterFactory.isFindHostFilter(filter);
		assert !DiscoveryFilterFactory.isFindMembersFilter(filter);
		assert !DiscoveryFilterFactory.isFindPossibleGroupsFilter(filter);
		assert !DiscoveryFilterFactory.isFindPossibleHostsFilter(filter);
		assert !DiscoveryFilterFactory.isFindPossibleHostedFilter(filter);
		assert !DiscoveryFilterFactory.isFindPossibleMembersFilter(filter);
		assert !DiscoveryFilterFactory.isFindPossibleTargetsFilter(filter);
		assert !DiscoveryFilterFactory.isFollowDependencyFilter(filter);
		uL = toUnitList(discoverer.findAll(filter));
		dumpUL(thisMethod + "." + call++, uL);
		assert 0 == uL.size() : uL.size();

		filter = DiscoveryFilterFactory.createFindPossibleMembersFilter(u2,
				(Requirement) t.resolve("/u2/dR1"), t);
		assert !DiscoveryFilterFactory.isFindGroupsFilter(filter);
		assert !DiscoveryFilterFactory.isFindHostedFilter(filter);
		assert !DiscoveryFilterFactory.isFindHostFilter(filter);
		assert !DiscoveryFilterFactory.isFindMembersFilter(filter);
		assert !DiscoveryFilterFactory.isFindPossibleGroupsFilter(filter);
		assert !DiscoveryFilterFactory.isFindPossibleHostsFilter(filter);
		assert !DiscoveryFilterFactory.isFindPossibleHostedFilter(filter);
		assert !DiscoveryFilterFactory.isFindPossibleMembersFilter(filter);
		assert !DiscoveryFilterFactory.isFindPossibleTargetsFilter(filter);
		assert !DiscoveryFilterFactory.isFollowDependencyFilter(filter);
		uL = toUnitList(discoverer.findAll(filter));
		dumpUL(thisMethod + "." + call++, uL);
		assert 0 == uL.size() : uL.size();

		filter = DiscoveryFilterFactory.createFindPossibleMembersFilter(u3,
				(Requirement) t.resolve("/u3/dR1"), t);
		assert !DiscoveryFilterFactory.isFindGroupsFilter(filter);
		assert !DiscoveryFilterFactory.isFindHostedFilter(filter);
		assert !DiscoveryFilterFactory.isFindHostFilter(filter);
		assert !DiscoveryFilterFactory.isFindMembersFilter(filter);
		assert !DiscoveryFilterFactory.isFindPossibleGroupsFilter(filter);
		assert !DiscoveryFilterFactory.isFindPossibleHostsFilter(filter);
		assert !DiscoveryFilterFactory.isFindPossibleHostedFilter(filter);
		assert !DiscoveryFilterFactory.isFindPossibleMembersFilter(filter);
		assert !DiscoveryFilterFactory.isFindPossibleTargetsFilter(filter);
		assert !DiscoveryFilterFactory.isFollowDependencyFilter(filter);
		uL = toUnitList(discoverer.findAll(filter));
		dumpUL(thisMethod + "." + call++, uL);
		assert 0 == uL.size() : uL.size();

		filter = DiscoveryFilterFactory.createFindPossibleMembersFilter(u4,
				(Requirement) t.resolve("/u2/hR1"), t);
		assert !DiscoveryFilterFactory.isFindGroupsFilter(filter);
		assert !DiscoveryFilterFactory.isFindHostedFilter(filter);
		assert !DiscoveryFilterFactory.isFindHostFilter(filter);
		assert !DiscoveryFilterFactory.isFindMembersFilter(filter);
		assert !DiscoveryFilterFactory.isFindPossibleGroupsFilter(filter);
		assert !DiscoveryFilterFactory.isFindPossibleHostsFilter(filter);
		assert !DiscoveryFilterFactory.isFindPossibleHostedFilter(filter);
		assert !DiscoveryFilterFactory.isFindPossibleMembersFilter(filter);
		assert !DiscoveryFilterFactory.isFollowDependencyFilter(filter);
		uL = toUnitList(discoverer.findAll(filter));
		dumpUL(thisMethod + "." + call++, uL);
		assert 0 == uL.size() : uL.size();

		filter = DiscoveryFilterFactory.createFindPossibleMembersFilter(g1,
				(Requirement) t.resolve("/g1/mR1"), t);
		assert !DiscoveryFilterFactory.isFindGroupsFilter(filter);
		assert !DiscoveryFilterFactory.isFindHostedFilter(filter);
		assert !DiscoveryFilterFactory.isFindHostFilter(filter);
		assert !DiscoveryFilterFactory.isFindMembersFilter(filter);
		assert !DiscoveryFilterFactory.isFindPossibleGroupsFilter(filter);
		assert !DiscoveryFilterFactory.isFindPossibleHostsFilter(filter);
		assert !DiscoveryFilterFactory.isFindPossibleHostedFilter(filter);
		assert DiscoveryFilterFactory.isFindPossibleMembersFilter(filter);
		assert !DiscoveryFilterFactory.isFindPossibleTargetsFilter(filter);
		assert !DiscoveryFilterFactory.isFollowDependencyFilter(filter);
		uL = toUnitList(discoverer.findAll(filter));
		dumpUL(thisMethod + "." + call++, uL);
		assert 3 == uL.size() : uL.size();
		assert uL.contains(u1) : "u1 not found as possible member of group g1";
		assert uL.contains(u4) : "u4 not found as possible member of group g1";
		assert uL.contains(g2) : "g2 not found as possible member of group g1";

		filter = DiscoveryFilterFactory.createFindPossibleMembersFilter(g2,
				(Requirement) t.resolve("/g2/mR1"), t);
		assert !DiscoveryFilterFactory.isFindGroupsFilter(filter);
		assert !DiscoveryFilterFactory.isFindHostedFilter(filter);
		assert !DiscoveryFilterFactory.isFindHostFilter(filter);
		assert !DiscoveryFilterFactory.isFindMembersFilter(filter);
		assert !DiscoveryFilterFactory.isFindPossibleGroupsFilter(filter);
		assert !DiscoveryFilterFactory.isFindPossibleHostsFilter(filter);
		assert !DiscoveryFilterFactory.isFindPossibleHostedFilter(filter);
		assert DiscoveryFilterFactory.isFindPossibleMembersFilter(filter);
		assert !DiscoveryFilterFactory.isFindPossibleTargetsFilter(filter);
		assert !DiscoveryFilterFactory.isFollowDependencyFilter(filter);
		uL = toUnitList(discoverer.findAll(filter));
		dumpUL(thisMethod + "." + call++, uL);
		assert 3 == uL.size() : uL.size();
		assert uL.contains(u1) : "u1 not found as possible member of group g2";
		assert uL.contains(u2) : "u2 not found as possible member of group g2";
		assert uL.contains(g1) : "g1 not found as possible member of group g2";
	}

	private void getPossibleGroupsTest(Topology t) {
		final String thisMethod = "getPossibleGroupsTest";
		int call = 1;
		DiscoveryFilter filter;
		List uL;

		filter = DiscoveryFilterFactory.createFindPossibleGroupsFilter(u1,
				null, t);
		assert !DiscoveryFilterFactory.isFindGroupsFilter(filter);
		assert !DiscoveryFilterFactory.isFindHostedFilter(filter);
		assert !DiscoveryFilterFactory.isFindHostFilter(filter);
		assert !DiscoveryFilterFactory.isFindMembersFilter(filter);
		assert DiscoveryFilterFactory.isFindPossibleGroupsFilter(filter);
		assert !DiscoveryFilterFactory.isFindPossibleHostsFilter(filter);
		assert !DiscoveryFilterFactory.isFindPossibleHostedFilter(filter);
		assert !DiscoveryFilterFactory.isFindPossibleMembersFilter(filter);
		assert !DiscoveryFilterFactory.isFindPossibleTargetsFilter(filter);
		assert !DiscoveryFilterFactory.isFollowDependencyFilter(filter);
		uL = toUnitList(discoverer.findAll(filter));
		dumpUL(thisMethod + "." + call++, uL);
		assert 2 == uL.size() : uL.size();
		assert uL.contains(g1) : "g1 not found as possible group for u1";
		assert uL.contains(g2) : "g2 not found as possible group for u1";

		filter = DiscoveryFilterFactory.createFindPossibleGroupsFilter(u2,
				null, t);
		assert !DiscoveryFilterFactory.isFindGroupsFilter(filter);
		assert !DiscoveryFilterFactory.isFindHostedFilter(filter);
		assert !DiscoveryFilterFactory.isFindHostFilter(filter);
		assert !DiscoveryFilterFactory.isFindMembersFilter(filter);
		assert DiscoveryFilterFactory.isFindPossibleGroupsFilter(filter);
		assert !DiscoveryFilterFactory.isFindPossibleHostsFilter(filter);
		assert !DiscoveryFilterFactory.isFindPossibleHostedFilter(filter);
		assert !DiscoveryFilterFactory.isFindPossibleMembersFilter(filter);
		assert !DiscoveryFilterFactory.isFindPossibleTargetsFilter(filter);
		assert !DiscoveryFilterFactory.isFollowDependencyFilter(filter);
		uL = toUnitList(discoverer.findAll(filter));
		dumpUL(thisMethod + "." + call++, uL);
		assert 1 == uL.size() : uL.size();
		assert uL.contains(g2) : "g2 not found as possible group for u2";

		filter = DiscoveryFilterFactory.createFindPossibleGroupsFilter(u3,
				null, t);
		assert !DiscoveryFilterFactory.isFindGroupsFilter(filter);
		assert !DiscoveryFilterFactory.isFindHostedFilter(filter);
		assert !DiscoveryFilterFactory.isFindHostFilter(filter);
		assert !DiscoveryFilterFactory.isFindMembersFilter(filter);
		assert DiscoveryFilterFactory.isFindPossibleGroupsFilter(filter);
		assert !DiscoveryFilterFactory.isFindPossibleHostsFilter(filter);
		assert !DiscoveryFilterFactory.isFindPossibleHostedFilter(filter);
		assert !DiscoveryFilterFactory.isFindPossibleMembersFilter(filter);
		assert !DiscoveryFilterFactory.isFindPossibleTargetsFilter(filter);
		assert !DiscoveryFilterFactory.isFollowDependencyFilter(filter);
		uL = toUnitList(discoverer.findAll(filter));
		dumpUL(thisMethod + "." + call++, uL);
		assert 0 == uL.size() : uL.size();

		filter = DiscoveryFilterFactory.createFindPossibleGroupsFilter(u4,
				null, t);
		assert !DiscoveryFilterFactory.isFindGroupsFilter(filter);
		assert !DiscoveryFilterFactory.isFindHostedFilter(filter);
		assert !DiscoveryFilterFactory.isFindHostFilter(filter);
		assert !DiscoveryFilterFactory.isFindMembersFilter(filter);
		assert DiscoveryFilterFactory.isFindPossibleGroupsFilter(filter);
		assert !DiscoveryFilterFactory.isFindPossibleHostsFilter(filter);
		assert !DiscoveryFilterFactory.isFindPossibleHostedFilter(filter);
		assert !DiscoveryFilterFactory.isFindPossibleMembersFilter(filter);
		assert !DiscoveryFilterFactory.isFindPossibleTargetsFilter(filter);
		assert !DiscoveryFilterFactory.isFollowDependencyFilter(filter);
		uL = toUnitList(discoverer.findAll(filter));
		dumpUL(thisMethod + "." + call++, uL);
		assert 1 == uL.size() : uL.size();
		assert uL.contains(g1) : "g1 not found as possible group for u4";

		filter = DiscoveryFilterFactory.createFindPossibleGroupsFilter(g1,
				null, t);
		assert !DiscoveryFilterFactory.isFindGroupsFilter(filter);
		assert !DiscoveryFilterFactory.isFindHostedFilter(filter);
		assert !DiscoveryFilterFactory.isFindHostFilter(filter);
		assert !DiscoveryFilterFactory.isFindMembersFilter(filter);
		assert DiscoveryFilterFactory.isFindPossibleGroupsFilter(filter);
		assert !DiscoveryFilterFactory.isFindPossibleHostsFilter(filter);
		assert !DiscoveryFilterFactory.isFindPossibleHostedFilter(filter);
		assert !DiscoveryFilterFactory.isFindPossibleMembersFilter(filter);
		assert !DiscoveryFilterFactory.isFindPossibleTargetsFilter(filter);
		assert !DiscoveryFilterFactory.isFollowDependencyFilter(filter);
		uL = toUnitList(discoverer.findAll(filter));
		dumpUL(thisMethod + "." + call++, uL);
// FIXME
		assert 1 == uL.size() : uL.size();
		assert uL.contains(g2) : "g2 not found as possible group for g1";

		filter = DiscoveryFilterFactory.createFindPossibleGroupsFilter(g2,
				(Requirement) t.resolve("/g2/mR1"), t);
		assert !DiscoveryFilterFactory.isFindGroupsFilter(filter);
		assert !DiscoveryFilterFactory.isFindHostedFilter(filter);
		assert !DiscoveryFilterFactory.isFindHostFilter(filter);
		assert !DiscoveryFilterFactory.isFindMembersFilter(filter);
		assert !DiscoveryFilterFactory.isFindPossibleGroupsFilter(filter); // requirement
																			// is
																			// for
																			// group;
																			// not
																			// member
		assert !DiscoveryFilterFactory.isFindPossibleHostsFilter(filter);
		assert !DiscoveryFilterFactory.isFindPossibleHostedFilter(filter);
		assert !DiscoveryFilterFactory.isFindPossibleMembersFilter(filter);
		assert !DiscoveryFilterFactory.isFindPossibleTargetsFilter(filter);
		assert !DiscoveryFilterFactory.isFollowDependencyFilter(filter);
		uL = toUnitList(discoverer.findAll(filter));
		dumpUL(thisMethod + "." + call++, uL);
		assert (0 == uL.size());

	}

	private Topology createTestTopology() {
		Topology t = createTopology("testDiscoverer");

		t.getUnits().add(
				createUnit("u1", new String[] { "c1" }, new String[] {},
						new String[] {}, new String[] {}));
		t.getUnits().add(
				createUnit("u2", new String[] {}, new String[] { "dR1" },
						new String[] { "hR1" }, new String[] {}));
		t.getUnits().add(
				createUnit("u3", new String[] {}, new String[] { "dR1" },
						new String[] { "hR1" }, new String[] {}));
		t.getUnits().add(
				createUnit("u4", new String[] { "c1" }, new String[] {},
						new String[] { "hR1" }, new String[] {}));
		t.getUnits().add(
				createUnit("g1", new String[] {}, new String[] { "dR1" },
						new String[] {}, new String[] { "mR1" }));
		t.getUnits().add(
				createUnit("g2", new String[] {}, new String[] {},
						new String[] { "hR1" }, new String[] { "mR1" }));

		u1 = (Unit) t.resolve("u1");
		u2 = (Unit) t.resolve("/u2");
		u3 = (Unit) t.resolve("/u3");
		u4 = (Unit) t.resolve("/u4");
		g1 = (Unit) t.resolve("/g1");
		g2 = (Unit) t.resolve("/g2");

		Capability u4c1 = (Capability) t.resolve("/u4/c1");
		assert ValidatorUtils.getOwningUnit(u4c1) == u4;
		Requirement u2r1 = (Requirement) t.resolve("/u2/dR1");
		assert ValidatorUtils.getOwningUnit(u2r1) == u2;
		Requirement u3r1 = (Requirement) t.resolve("/u3/dR1");
		assert ValidatorUtils.getOwningUnit(u3r1) == u3;

		LinkFactory.createHostingLink(u1, u2);
		LinkFactory.createHostingLink(u1, u3);

		LinkFactory.createDependencyLink(u2, u2r1, u4, u4c1);
		LinkFactory.createDependencyLink(u3, u3r1, u4, u4c1);

		DeployValidatorService dvs = DeployValidatorService.getDefaultValidatorService();

		assert !u1.isGroup() : " u1 is a group!";
		assert !u2.isGroup() : " u2 is a group!";
		assert !u3.isGroup() : " u3 is a group!";
		assert !u4.isGroup() : " u4 is a group!";
		assert g1.isGroup() : " g1 is not a group!";
		assert g2.isGroup() : " g2 is not a group!";

		assert dvs.canCreateLink(g1, u1, new LinkType[] { LinkType.MEMBER })
				.isOK();
		assert dvs.canCreateLink(g1, u2, new LinkType[] { LinkType.MEMBER })
				.isOK();
		assert dvs.canCreateLink(g1, u3, new LinkType[] { LinkType.MEMBER })
				.isOK();
		assert dvs.canCreateLink(g1, u4, new LinkType[] { LinkType.MEMBER })
				.isOK();
		assert !dvs.canCreateLink(g1, g1, new LinkType[] { LinkType.MEMBER })
				.isOK();
		assert dvs.canCreateLink(g1, g2, new LinkType[] { LinkType.MEMBER })
				.isOK();

		assert dvs.canCreateLink(g2, u1, new LinkType[] { LinkType.MEMBER })
				.isOK();
		assert dvs.canCreateLink(g2, u2, new LinkType[] { LinkType.MEMBER })
				.isOK();
		assert dvs.canCreateLink(g2, u3, new LinkType[] { LinkType.MEMBER })
				.isOK();
		assert dvs.canCreateLink(g2, u4, new LinkType[] { LinkType.MEMBER })
				.isOK();
		assert dvs.canCreateLink(g2, g1, new LinkType[] { LinkType.MEMBER })
				.isOK();
		assert !dvs.canCreateLink(g2, g2, new LinkType[] { LinkType.MEMBER })
				.isOK();

		assert !dvs.canCreateLink(u1, u1, new LinkType[] { LinkType.MEMBER })
				.isOK();
		assert !dvs.canCreateLink(u1, u2, new LinkType[] { LinkType.MEMBER })
				.isOK();
		assert !dvs.canCreateLink(u1, u3, new LinkType[] { LinkType.MEMBER })
				.isOK();
		assert !dvs.canCreateLink(u1, u4, new LinkType[] { LinkType.MEMBER })
				.isOK();
		assert !dvs.canCreateLink(u1, g1, new LinkType[] { LinkType.MEMBER })
				.isOK();
		assert !dvs.canCreateLink(u1, g2, new LinkType[] { LinkType.MEMBER })
				.isOK();

		assert !dvs.canCreateLink(u2, u1, new LinkType[] { LinkType.MEMBER })
				.isOK();
		assert !dvs.canCreateLink(u2, u2, new LinkType[] { LinkType.MEMBER })
				.isOK();
		assert !dvs.canCreateLink(u2, u3, new LinkType[] { LinkType.MEMBER })
				.isOK();
		assert !dvs.canCreateLink(u2, u4, new LinkType[] { LinkType.MEMBER })
				.isOK();
		assert !dvs.canCreateLink(u2, g1, new LinkType[] { LinkType.MEMBER })
				.isOK();
		assert !dvs.canCreateLink(u2, g2, new LinkType[] { LinkType.MEMBER })
				.isOK();

		assert !dvs.canCreateLink(u3, u1, new LinkType[] { LinkType.MEMBER })
				.isOK();
		assert !dvs.canCreateLink(u3, u2, new LinkType[] { LinkType.MEMBER })
				.isOK();
		assert !dvs.canCreateLink(u3, u3, new LinkType[] { LinkType.MEMBER })
				.isOK();
		assert !dvs.canCreateLink(u3, u4, new LinkType[] { LinkType.MEMBER })
				.isOK();
		assert !dvs.canCreateLink(u3, g1, new LinkType[] { LinkType.MEMBER })
				.isOK();
		assert !dvs.canCreateLink(u3, g2, new LinkType[] { LinkType.MEMBER })
				.isOK();

		assert !dvs.canCreateLink(u4, u1, new LinkType[] { LinkType.MEMBER })
				.isOK();
		assert !dvs.canCreateLink(u4, u2, new LinkType[] { LinkType.MEMBER })
				.isOK();
		assert !dvs.canCreateLink(u4, u3, new LinkType[] { LinkType.MEMBER })
				.isOK();
		assert !dvs.canCreateLink(u4, u4, new LinkType[] { LinkType.MEMBER })
				.isOK();
		assert !dvs.canCreateLink(u4, g1, new LinkType[] { LinkType.MEMBER })
				.isOK();
		assert !dvs.canCreateLink(u4, g2, new LinkType[] { LinkType.MEMBER })
				.isOK();

		LinkFactory.createMemberLink(g1, u2);
		LinkFactory.createMemberLink(g1, u3);
		LinkFactory.createMemberLink(g2, u3);
		LinkFactory.createMemberLink(g2, u4);

		// check the model

		assert u1.getCapabilities().size() == 1 : u1.getCapabilities().size();
		assert u1.getOnlyDependencyRequirements().size() == 0 : u1
				.getOnlyDependencyRequirements().size();
		assert u1.getOnlyHostingRequirements().size() == 0 : u1
				.getOnlyHostingRequirements().size();
		assert u1.getOnlyMemberRequirements().size() == 0 : u1
				.getOnlyMemberRequirements().size();
		assert u1.getRequirements().size() == 0 : u1.getRequirements().size();
		u2 = (Unit) t.resolve("/u2");
		assert u2.getCapabilities().size() == 0 : u2.getCapabilities().size();
		assert u2.getOnlyDependencyRequirements().size() == 1 : u2
				.getOnlyDependencyRequirements().size();
		assert u2.getOnlyHostingRequirements().size() == 1 : u2
				.getOnlyHostingRequirements().size();
		assert u2.getOnlyMemberRequirements().size() == 0 : u2
				.getOnlyMemberRequirements().size();
		assert u2.getRequirements().size() == 2 : u2.getRequirements().size();
		u3 = (Unit) t.resolve("/u3");
		assert u3.getCapabilities().size() == 0 : u3.getCapabilities().size();
		assert u3.getOnlyDependencyRequirements().size() == 1 : u3
				.getOnlyDependencyRequirements().size();
		assert u3.getOnlyHostingRequirements().size() == 1 : u3
				.getOnlyHostingRequirements().size();
		assert u3.getOnlyMemberRequirements().size() == 0 : u3
				.getOnlyMemberRequirements().size();
		assert u3.getRequirements().size() == 2 : u3.getRequirements().size();
		u4 = (Unit) t.resolve("/u4");
		assert u4.getCapabilities().size() == 1 : u4.getCapabilities().size();
		assert u4.getOnlyDependencyRequirements().size() == 0 : u4
				.getOnlyDependencyRequirements().size();
		assert u4.getOnlyHostingRequirements().size() == 1 : u4
				.getOnlyHostingRequirements().size();
		assert u4.getOnlyMemberRequirements().size() == 0 : u4
				.getOnlyMemberRequirements().size();
		assert u4.getRequirements().size() == 1 : u4.getRequirements().size();
		g1 = (Unit) t.resolve("/g1");
		assert g1.getCapabilities().size() == 0 : g1.getCapabilities().size();
		assert g1.getOnlyDependencyRequirements().size() == 1 : g1
				.getOnlyDependencyRequirements().size();
		assert g1.getOnlyHostingRequirements().size() == 0 : g1
				.getOnlyHostingRequirements().size();
		assert g1.getOnlyMemberRequirements().size() == 1 : g1
				.getOnlyMemberRequirements().size();
		assert g1.getRequirements().size() == 2 : g1.getRequirements().size();
		g2 = (Unit) t.resolve("/g2");
		assert g2.getCapabilities().size() == 0 : g2.getCapabilities().size();
		assert g2.getOnlyDependencyRequirements().size() == 0 : g2
				.getOnlyDependencyRequirements().size();
		assert g2.getOnlyHostingRequirements().size() == 1 : g2
				.getOnlyHostingRequirements().size();
		assert g2.getOnlyMemberRequirements().size() == 1 : g2
				.getOnlyMemberRequirements().size();
		assert g2.getRequirements().size() == 2 : g2.getRequirements().size();

		assert u1.getHostingLinks().size() == 2;

		DependencyLink link = u2r1.getLink();
		assert null != link;
		assert ValidatorUtils.getOwningUnit(link.getSource()) == u2 : ValidatorUtils
				.getOwningUnit(link.getSource()).getName();
		assert ValidatorUtils.getOwningUnit(link.getTarget()) == u4 : ValidatorUtils
				.getOwningUnit(link.getTarget()).getName();

		link = u3r1.getLink();
		assert null != link;
		assert ValidatorUtils.getOwningUnit(link.getSource()) == u3 : ValidatorUtils
				.getOwningUnit(link.getSource()).getName();
		assert ValidatorUtils.getOwningUnit(link.getTarget()) == u4 : ValidatorUtils
				.getOwningUnit(link.getTarget()).getName();

		assert g1.getMemberLinks().size() == 2;
		assert g2.getMemberLinks().size() == 2;

		return t;
	}

	private Unit createUnit(String name, String[] cNames, String[] rdNames,
			String[] rhNames, String[] rmNames) {
		Unit u = CoreFactory.eINSTANCE.createUnit();
		u.setName(name);

		for (int i = 0; i < cNames.length; i++) {
			Capability c = CoreFactory.eINSTANCE.createCapability();
			c.setName(cNames[i]);
			c.setLinkType(CapabilityLinkTypes.ANY_LITERAL);
			u.getCapabilities().add(c);
		}

		for (int i = 0; i < rdNames.length; i++) {
			Requirement r = CoreFactory.eINSTANCE.createRequirement();
			r.setName(rdNames[i]);
			r.setDmoEType(CorePackage.Literals.CAPABILITY);
			u.getOnlyDependencyRequirements().add(r);
		}

		for (int i = 0; i < rhNames.length; i++) {
			Requirement r = CoreFactory.eINSTANCE.createRequirement();
			r.setName(rhNames[i]);
			r.setDmoEType(CorePackage.Literals.CAPABILITY);
			u.getOnlyHostingRequirements().add(r);
		}

		for (int i = 0; i < rmNames.length; i++) {
			Requirement r = CoreFactory.eINSTANCE.createRequirement();
			r.setName(rmNames[i]);
			r.setDmoEType(CorePackage.Literals.UNIT);
			u.getOnlyMemberRequirements().add(r);
		}

// System.out.println ("created unit: " + u);
// System.out.println (" capabilities = " + u.getCapabilities().size());
// System.out.println (" requirements = " + u.getRequirements().size());
		return u;
	}

	private List toUnitList(List unitDescriptorList) {
		ArrayList uList = new ArrayList();
		for (int i = 0; i < unitDescriptorList.size(); i++) {
			uList.add(((UnitDescriptor) unitDescriptorList.get(i))
					.getUnitValue());
		}
		return uList;
	}

	private void dumpUL(String location, List unitList) {
		System.out.println(unitList.size() + " items at " + location);
		for (int i = 0; i < unitList.size(); i++) {
			System.out.println("  " + ((Unit) unitList.get(i)).getName());
		}
	}
}
