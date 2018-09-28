/*******************************************************************************
 * Copyright (c) 2003, 2007 IBM Corporation Licensed Material - Property of IBM. All rights reserved.
 *  
 * US Government Users Restricted Rights - Use, duplication or disclosure v1.0 restricted by GSA ADP
 * Schedule Contract with IBM Corp.
 * 
 * Contributors: IBM Corporation - initial API and implementation
 *******************************************************************************/

package com.ibm.ccl.soa.deploy.core.test.provider.discovery;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.NullProgressMonitor;

import com.ibm.ccl.soa.deploy.core.Capability;
import com.ibm.ccl.soa.deploy.core.CapabilityLinkTypes;
import com.ibm.ccl.soa.deploy.core.Constraint;
import com.ibm.ccl.soa.deploy.core.CorePackage;
import com.ibm.ccl.soa.deploy.core.DependencyLink;
import com.ibm.ccl.soa.deploy.core.DiscoveryFilter;
import com.ibm.ccl.soa.deploy.core.HostingLink;
import com.ibm.ccl.soa.deploy.core.InstallState;
import com.ibm.ccl.soa.deploy.core.MemberLink;
import com.ibm.ccl.soa.deploy.core.Requirement;
import com.ibm.ccl.soa.deploy.core.RequirementExpression;
import com.ibm.ccl.soa.deploy.core.RequirementLinkTypes;
import com.ibm.ccl.soa.deploy.core.Topology;
import com.ibm.ccl.soa.deploy.core.Unit;
import com.ibm.ccl.soa.deploy.core.UnitDescriptor;
import com.ibm.ccl.soa.deploy.core.provider.discovery.DiscoveryFilterFactory;
import com.ibm.ccl.soa.deploy.core.provider.discovery.TopologyDiscovererService;
import com.ibm.ccl.soa.deploy.core.provider.discovery.TopologyTopologyDiscoverer;
import com.ibm.ccl.soa.deploy.core.test.TopologyTestCase;
import com.ibm.ccl.soa.deploy.core.test.provider.JUnitTopologyDiscoverer;
import com.ibm.ccl.soa.deploy.core.validator.expression.Equals;
import com.ibm.ccl.soa.deploy.core.validator.matcher.LinkFactory;

/**
 * Tests discovery using {@link JUnitTopologyDiscoverer}.
 */
public class DiscoveryTest extends TopologyTestCase {

	public DiscoveryTest() {
		super("DiscoveryTest");
	}

	/**
	 * Tests hosting discovery using the model-based test infrastructure.
	 * 
	 * @see #setInfrastructureTopology(Topology)
	 */
	public void testHostDiscovery() throws Exception {
		Topology infraTop = createTopology("testHostDiscovery-Infra");

		// Host

		Unit host = addUnit(infraTop, "host");
		host.setInitInstallState(InstallState.INSTALLED_LITERAL);
		Capability cap = addCapability(host, "hostingCap",
				CapabilityLinkTypes.HOSTING_LITERAL);
		cap.setDescription("test");

		// Hostee

		Unit hostee = addUnit(infraTop, "hostee");
		hostee.setInitInstallState(InstallState.INSTALLED_LITERAL);
		Requirement req = addRequirement(hostee, "hostingReq",
				CorePackage.Literals.CAPABILITY,
				RequirementLinkTypes.HOSTING_LITERAL);
		RequirementExpression reqExpr = Equals.createExpression(
				CorePackage.Literals.DEPLOY_MODEL_OBJECT__DESCRIPTION, "test");
		req.getExpressions().add(reqExpr);

		host.setMutable(false);
		cap.setMutable(false);
		hostee.setMutable(false);
		req.setMutable(false);
		reqExpr.setMutable(false);

		// Hosting link

		LinkFactory.createHostingLink(host, hostee);
		save(infraTop);

		validate(infraTop);
		assertHasNoErrorStatus(infraTop);

		//
		// Provide the hostee
		//
		try {
			Topology editTop = createTopology("testHostDiscovery-Edit1");
			setInfrastructureTopology(infraTop);
			Unit providedHostee = addTestInfrastructureUnit(hostee, editTop);
			assert providedHostee != null;
			assert providedHostee.getTopology() == editTop;
			assert !editTop.findAllHostingLinks().hasNext();
			save(editTop);

			validate(editTop);
			assertHasNoErrorStatus(infraTop);

			// Discover host and add to topology
			UnitDescriptor hostUD = TopologyDiscovererService.INSTANCE
					.findHostUD(providedHostee, editTop);
			assert hostUD != null;
			Unit foundHost = hostUD.getUnitValue();
			assertEquals(0, foundHost.getHostingLinks().size());
			Unit providedHost = hostUD.getUnitValueAndAddToTopology(editTop);
			assert providedHost != null;
			assert providedHost.getTopology() == editTop;

			// Check that the hosting link was added
			assert editTop.findAllHostingLinks().hasNext();
		} finally {
			setInfrastructureTopology(null);
		}

		//
		// Provide the host
		//
		try {
			Topology editTop = createTopology("testHostDiscovery-Edit2");
			setInfrastructureTopology(infraTop);
			Unit providedHost = addTestInfrastructureUnit(host, editTop);
			assert providedHost != null;
			assert providedHost.getTopology() == editTop;
			assert !editTop.findAllHostingLinks().hasNext();
			save(editTop);

			validate(editTop);
			assertHasNoErrorStatus(infraTop);

			// Discover host and add to topology
			List<UnitDescriptor> udList = TopologyDiscovererService.INSTANCE
					.findHosted(providedHost, editTop);
			assertEquals(udList.size(), 1);
			Unit providedHostee = udList.get(0).getUnitValueAndAddToTopology(
					editTop);
			assert providedHostee != null;
			assert providedHostee.getTopology() == editTop;

			// Check that the hosting link was added
			assert editTop.findAllHostingLinks().hasNext();
		} finally {
			setInfrastructureTopology(null);
		}
	}

	/**
	 * Tests dependency discovery using the model-based test infrastructure.
	 * 
	 * @see #setInfrastructureTopology(Topology)
	 */
	public void testDependencyDiscovery() throws Exception {
		Topology infraTop = createTopology("testDependencyDiscovery-Infra");

		// Target

		Unit target = addUnit(infraTop, "target");
		target.setInitInstallState(InstallState.INSTALLED_LITERAL);
		Capability cap = addCapability(target, "dependencyCap",
				CapabilityLinkTypes.DEPENDENCY_LITERAL);
		cap.setDescription("test");

		// Source

		Unit source = addUnit(infraTop, "source");
		source.setInitInstallState(InstallState.INSTALLED_LITERAL);
		Requirement req = addRequirement(source, "dependencyReq",
				CorePackage.Literals.CAPABILITY,
				RequirementLinkTypes.DEPENDENCY_LITERAL);
		RequirementExpression reqExpr = Equals.createExpression(
				CorePackage.Literals.DEPLOY_MODEL_OBJECT__DESCRIPTION, "test");
		req.getExpressions().add(reqExpr);

		target.setMutable(false);
		source.setMutable(false);
		cap.setMutable(false);
		req.setMutable(false);
		reqExpr.setMutable(false);

		// Dependency link

		LinkFactory.createDependencyLink(req, cap);
		save(infraTop);

		validate(infraTop);
		assertHasNoErrorStatus(infraTop);

		//
		// Provide the source
		//
		try {
			Topology editTop = createTopology("testDependencyDiscovery-Edit1");
			setInfrastructureTopology(infraTop);
			Unit providedSource = addTestInfrastructureUnit(source, editTop);
			assert providedSource != null;
			assert providedSource.getTopology() == editTop;
			assert !editTop.findAllDependencyLinks().hasNext();
			Requirement providedReq = (Requirement) providedSource
					.getRequirements().get(0);
			assertEquals(null, providedReq.getLink());
			save(editTop);

			validate(editTop);
			assertHasNoErrorStatus(infraTop);

			// Discover target and add to topology
			UnitDescriptor targetUD = TopologyDiscovererService.INSTANCE
					.findTarget(providedSource, providedReq, editTop);
			assert targetUD != null;
			Unit foundTarget = targetUD.getUnitValue();
			assert foundTarget != null;
			assertEquals(null, providedReq.getLink());
			Unit providedTarget = targetUD
					.getUnitValueAndAddToTopology(editTop);
			assert providedTarget != null;
			assert providedTarget.getTopology() == editTop;

			// Check that the dependency link was added
			assert editTop.findAllDependencyLinks().hasNext();
			assert providedReq.getLink() != null;
		} finally {
			setInfrastructureTopology(null);
		}

		//
		// Provide the target
		//
		try {
			Topology editTop = createTopology("testDependencyDiscovery-Edit2");
			setInfrastructureTopology(infraTop);
			Unit providedTarget = addTestInfrastructureUnit(target, editTop);
			assert providedTarget != null;
			assert providedTarget.getTopology() == editTop;
			assert !editTop.findAllDependencyLinks().hasNext();
			Capability providedCap = (Capability) providedTarget
					.getCapabilities().get(0);
			save(editTop);

			validate(editTop);
			assertHasNoErrorStatus(infraTop);

			// Discover source and add to topology
			List<UnitDescriptor> udList = TopologyDiscovererService.INSTANCE
					.findSources(providedTarget, providedCap, editTop);
			assertEquals(udList.size(), 1);
			Unit providedSource = udList.get(0).getUnitValueAndAddToTopology(
					editTop);
			assert providedSource != null;
			assert providedSource.getTopology() == editTop;
			Requirement providedReq = (Requirement) providedSource
					.getRequirements().get(0);

			// Check that the dependency link was added
			assert editTop.findAllDependencyLinks().hasNext();
			assert providedReq.getLink() != null;
		} finally {
			setInfrastructureTopology(null);
		}
	}

	/**
	 * Tests member discovery using the model-based test infrastructure.
	 * 
	 * @see #setInfrastructureTopology(Topology)
	 */
	public void testMemberDiscovery() throws Exception {
		Topology infraTop = createTopology("testMemberDiscovery-Infra");

		// Group

		Unit group = addGroupUnit(infraTop, "group");
		group.setInitInstallState(InstallState.INSTALLED_LITERAL);

		// Member

		Unit member = addUnit(infraTop, "member");
		member.setInitInstallState(InstallState.INSTALLED_LITERAL);
		Capability memberCap = addCapability(member, "memberCap",
				CapabilityLinkTypes.ANY_LITERAL);

		group.setMutable(false);
		((Requirement) group.getRequirements().get(0)).setMutable(false);
		((Constraint) ((Requirement) group.getRequirements().get(0))
				.getConstraints().get(0)).setMutable(false);
		member.setMutable(false);
		memberCap.setMutable(false);

		// Member link

		LinkFactory.createMemberLink(group, member);
		save(infraTop);

		validate(infraTop);
		assertHasNoErrorStatus(infraTop);

		//
		// Provide the member
		//
		try {
			Topology editTop = createTopology("testMemberDiscovery-Edit1");
			setInfrastructureTopology(infraTop);
			Unit providedMember = addTestInfrastructureUnit(member, editTop);
			assert providedMember != null;
			assert providedMember.getTopology() == editTop;
			assert !editTop.findAllMemberLinks().hasNext();
			save(editTop);

			validate(editTop);
			assertHasNoErrorStatus(infraTop);

			// Discover group and add to topology
			List<UnitDescriptor> groupList = TopologyDiscovererService.INSTANCE
					.getGroups(providedMember, null, editTop);
			assertEquals(1, groupList.size());
			Unit foundGroup = groupList.get(0).getUnitValue();
			assertEquals(0, foundGroup.getMemberLinks().size());
			Unit providedGroup = groupList.get(0).getUnitValueAndAddToTopology(
					editTop);
			assert providedGroup != null;
			assert providedGroup.getTopology() == editTop;

			// Check that the member link was added
			assert editTop.findAllMemberLinks().hasNext();
		} finally {
			setInfrastructureTopology(null);
		}

		//
		// Provide the group
		//
		try {
			Topology editTop = createTopology("testMemberDiscovery-Edit2");
			setInfrastructureTopology(infraTop);
			Unit providedGroup = addTestInfrastructureUnit(group, editTop);
			assert providedGroup != null;
			assert providedGroup.getTopology() == editTop;
			assert !editTop.findAllMemberLinks().hasNext();
			save(editTop);
			assertEquals(1, providedGroup.getRequirements().size());
			Requirement providedGroupReq = (Requirement) providedGroup
					.getRequirements().get(0);
			assert providedGroup != null;

			validate(editTop);
			assertHasNoErrorStatus(infraTop);

			// Discover member and add to topology
			List<UnitDescriptor> memberUdList = TopologyDiscovererService.INSTANCE
					.getMembers(providedGroup, providedGroupReq, editTop);
			assertEquals(memberUdList.size(), 1);
			Unit providedMember = memberUdList.get(0)
					.getUnitValueAndAddToTopology(editTop);
			assert providedMember != null;
			assert providedMember.getTopology() == editTop;

			// Check that the member link was added
			assert editTop.findAllMemberLinks().hasNext();
		} finally {
			setInfrastructureTopology(null);
		}
	}
	
	public void testMemberAndGroupDiscoveryFilterTest() throws Exception {
		Topology top = createTopology("testMemberAndGroupDiscoveryFilterTest");

		// Group

		Unit group = addGroupUnit(top, "group");

		// Member
		Unit member = addMemberUnit(top, "member");
		Capability memberCap = addCapability(member, "memberCap",
				CapabilityLinkTypes.ANY_LITERAL);

		// Member link
		LinkFactory.createMemberLink(group, member);
		
		assertEquals(1, group.getMemberLinks().size());
		
		//Test Discovery filters
		DiscoveryFilter groupFilter = DiscoveryFilterFactory.createFindGroupsFilter(group, null,
				top, null);
		
		assertTrue(DiscoveryFilterFactory.isFindGroupsFilter(groupFilter));
		assertFalse(DiscoveryFilterFactory.isFindMembersFilter(groupFilter));
	}
	
	/**
	 * Tests the host discovery caching function over the current topology.
	 * 
	 * @see TopologyTopologyDiscoverer
	 * @see TopologyDiscovererService#findHosted(Unit, Topology,
	 *      IProgressMonitor)
	 * @see TopologyDiscovererService#findAllHosts(Unit, Topology,
	 *      IProgressMonitor)
	 * @throws Exception
	 */
	public void testHostLinkDiscoveryCache() throws Exception {
		Topology top = createTopology("testHostLinkDiscoveryCache", true);
		IProgressMonitor monitor = new NullProgressMonitor();

		TopologyDiscovererService.INSTANCE.leaveDefaultDiscoveryCache();
		TopologyDiscovererService.INSTANCE.enterDefaultDiscoveryCache();

		try {
			Unit host = addUnit(top, "host");
			addCapability(host, "hostCap", CapabilityLinkTypes.HOSTING_LITERAL);
			assertEquals(0, TopologyDiscovererService.INSTANCE.findHosted(host,
					top, monitor).size());

			Unit hostee = addUnit(top, "hostee");
			addRequirement(hostee, "hosting",
					RequirementLinkTypes.HOSTING_LITERAL);
			assertEquals(0, TopologyDiscovererService.INSTANCE.findAllHosts(
					hostee, top, monitor).size());

			HostingLink hLink = LinkFactory.createHostingLink(host, hostee);

			assertSetEquals(getUnits(TopologyDiscovererService.INSTANCE
					.findHosted(host, top, monitor)), new Object[] { hostee });
			assertSetEquals(getUnits(TopologyDiscovererService.INSTANCE
					.findAllHosts(hostee, top, monitor)), new Object[] { host });

			((Unit) hLink.getParent()).getHostingLinks().remove(hLink);

			assertEquals(0, TopologyDiscovererService.INSTANCE.findHosted(host,
					top, monitor).size());
			assertEquals(0, TopologyDiscovererService.INSTANCE.findAllHosts(
					hostee, top, monitor).size());
		} finally {
			TopologyDiscovererService.INSTANCE.leaveDefaultDiscoveryCache();
		}
	}

	/**
	 * Tests the dependency discovery caching function over the current
	 * topology.
	 * 
	 * @see TopologyTopologyDiscoverer
	 * @see TopologyDiscovererService#findSources(Unit, Capability, Topology,
	 *      IProgressMonitor)
	 * @see TopologyDiscovererService#findTarget(Unit, Requirement, Topology,
	 *      IProgressMonitor)
	 * @throws Exception
	 */
	public void testDependencyLinkDiscoveryCache() throws Exception {
		Topology top = createTopology("testDependencyLinkDiscoveryCache", true);
		IProgressMonitor monitor = new NullProgressMonitor();

		TopologyDiscovererService.INSTANCE.leaveDefaultDiscoveryCache();
		TopologyDiscovererService.INSTANCE.enterDefaultDiscoveryCache();

		try {
			Unit sourceU = addUnit(top, "sourceU");
			Requirement sourceR = addRequirement(sourceU, "dependency",
					RequirementLinkTypes.DEPENDENCY_LITERAL);
			assertNull(TopologyDiscovererService.INSTANCE.findTarget(sourceU,
					sourceR, top, monitor));

			Unit targetU = addUnit(top, "targetU");
			Capability targetC = addCapability(targetU, "targetC",
					CapabilityLinkTypes.DEPENDENCY_LITERAL);
			assertEquals(0, TopologyDiscovererService.INSTANCE.findSources(
					targetU, targetC, top, monitor).size());

			DependencyLink dLink = LinkFactory.createDependencyLink(sourceR,
					targetC);

			UnitDescriptor ud = TopologyDiscovererService.INSTANCE.findTarget(sourceU, sourceR, top, monitor);
			assert null != ud;
			assertEquals(targetU, ud.getUnitValue());
//			assertEquals(targetC, TopologyDiscovererService.INSTANCE
//					.findTarget(sourceU, sourceR, top, monitor));
			assertSetEquals(getUnits(TopologyDiscovererService.INSTANCE
					.findSources(targetU, targetC, top, monitor)),
					new Object[] { sourceU });

			sourceR.setLink(null);

			assertNull(TopologyDiscovererService.INSTANCE.findTarget(sourceU,
					sourceR, top, monitor));
			assertEquals(0, TopologyDiscovererService.INSTANCE.findSources(
					targetU, targetC, top, monitor).size());
		} finally {
			TopologyDiscovererService.INSTANCE.leaveDefaultDiscoveryCache();
		}
	}

	/**
	 * Tests the member discovery caching function over the current topology.
	 * 
	 * @see TopologyTopologyDiscoverer
	 * @see TopologyDiscovererService#getGroups(Unit, Requirement, Topology,
	 *      IProgressMonitor)
	 * @see TopologyDiscovererService#getMembers(Unit, Requirement, Topology,
	 *      IProgressMonitor)
	 * @throws Exception
	 */
	public void testMemberLinkDiscoveryCache() throws Exception {
		Topology top = createTopology("testMemberLinkDiscoveryCache", true);
		IProgressMonitor monitor = new NullProgressMonitor();

		TopologyDiscovererService.INSTANCE.leaveDefaultDiscoveryCache();
		TopologyDiscovererService.INSTANCE.enterDefaultDiscoveryCache();

		try {
			Unit group = addGroupUnit(top, "group");
			assertEquals(0, TopologyDiscovererService.INSTANCE.getMembers(
					group, null, top, monitor).size());

			Unit member = addMemberUnit(top, "group");
			assertEquals(0, TopologyDiscovererService.INSTANCE.getGroups(
					member, null, top, monitor).size());

			MemberLink mLink = LinkFactory.createMemberLink(group, member);

			assertSetEquals(getUnits(TopologyDiscovererService.INSTANCE
					.getMembers(group, null, top, monitor)),
					new Object[] { member });
			assertSetEquals(getUnits(TopologyDiscovererService.INSTANCE
					.getGroups(member, null, top, monitor)),
					new Object[] { group });

			((Unit) mLink.getParent()).getMemberLinks().remove(mLink);

			assertEquals(0, TopologyDiscovererService.INSTANCE.getMembers(
					group, null, top, monitor).size());
			assertEquals(0, TopologyDiscovererService.INSTANCE.getGroups(
					member, null, top, monitor).size());
		} finally {
			TopologyDiscovererService.INSTANCE.leaveDefaultDiscoveryCache();
		}
	}

	/**
	 * Converts a list of unit descriptors to a list of units.
	 * 
	 * @param descriptors
	 *            a list of unit descriptors.
	 * @return the units returned by the descriptors.
	 */
	protected List<Unit> getUnits(List<UnitDescriptor> descriptors) {
		if (descriptors == null) {
			return Collections.emptyList();
		}
		ArrayList<Unit> result = new ArrayList<Unit>(descriptors.size());
		for (UnitDescriptor d : descriptors) {
			result.add(d.getUnitValue());
		}

		return result;
	}
}
