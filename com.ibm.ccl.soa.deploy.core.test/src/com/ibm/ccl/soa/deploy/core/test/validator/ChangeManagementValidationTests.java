/*******************************************************************************
 * Copyright (c) 2003, 2007 IBM Corporation Licensed Material - Property of IBM. All rights reserved.
 *  
 * US Government Users Restricted Rights - Use, duplication or disclosure v1.0 restricted by GSA ADP
 * Schedule Contract with IBM Corp.
 * 
 * Contributors: IBM Corporation - initial API and implementation
 *******************************************************************************/

package com.ibm.ccl.soa.deploy.core.test.validator;

import org.eclipse.core.runtime.IStatus;

import com.ibm.ccl.soa.deploy.core.Capability;
import com.ibm.ccl.soa.deploy.core.CapabilityLinkTypes;
import com.ibm.ccl.soa.deploy.core.DependencyLink;
import com.ibm.ccl.soa.deploy.core.HostingLink;
import com.ibm.ccl.soa.deploy.core.InstallState;
import com.ibm.ccl.soa.deploy.core.MemberLink;
import com.ibm.ccl.soa.deploy.core.Requirement;
import com.ibm.ccl.soa.deploy.core.RequirementLinkTypes;
import com.ibm.ccl.soa.deploy.core.Topology;
import com.ibm.ccl.soa.deploy.core.Unit;
import com.ibm.ccl.soa.deploy.core.test.TopologyTestCase;
import com.ibm.ccl.soa.deploy.core.validator.ValidatorUtils;
import com.ibm.ccl.soa.deploy.core.validator.matcher.LinkFactory;
import com.ibm.ccl.soa.deploy.core.validator.status.ICoreProblemType;

/**
 * Unit-tests of the change management.
 * 
 */
public class ChangeManagementValidationTests extends TopologyTestCase {

	public ChangeManagementValidationTests() {
		super("ChangeManagementValidationTests");
	}

	/**
	 * Test the permutation of init and goal states.
	 */
	public void testInstallStateValidation() throws Exception {
		Topology top = createTopology("testInstallStateValidation");
		Unit hosted = addUnit(top, "hosted");
		addRequirement(hosted, "hostedReq",
				RequirementLinkTypes.HOSTING_LITERAL);
		Unit host = addUnit(top, "host");
		addCapability(host, "hostCap", CapabilityLinkTypes.HOSTING_LITERAL);
		LinkFactory.createHostingLink(host, hosted);

		/**
		 * Array of
		 * <ol>
		 * <li> Hosted unit {@link Unit#getInitInstallState()}
		 * <li> Host unit {@link Unit#getInitInstallState()}
		 * <li> Topology validation status
		 * </ol>
		 */
		int[][] hostedHostInitInstallStateSeverityTable = new int[][] {
				{ InstallState.INSTALLED, InstallState.INSTALLED, IStatus.OK },
				{ InstallState.INSTALLED, InstallState.NOT_INSTALLED,
						IStatus.ERROR },
				{ InstallState.INSTALLED, InstallState.UNKNOWN, IStatus.ERROR },
				{ InstallState.NOT_INSTALLED, InstallState.INSTALLED,
						IStatus.OK },
				{ InstallState.NOT_INSTALLED, InstallState.NOT_INSTALLED,
						IStatus.OK },
				{ InstallState.NOT_INSTALLED, InstallState.UNKNOWN, IStatus.OK },
				{ InstallState.UNKNOWN, InstallState.INSTALLED, IStatus.OK },
				{ InstallState.UNKNOWN, InstallState.NOT_INSTALLED, IStatus.OK },
				{ InstallState.UNKNOWN, InstallState.UNKNOWN, IStatus.OK }, };

		for (int i = 0; i < hostedHostInitInstallStateSeverityTable.length; i++) {
			int[] row = hostedHostInitInstallStateSeverityTable[i];
			hosted.setInitInstallState(InstallState.get(row[0]));
			host.setInitInstallState(InstallState.get(row[1]));
			validate(top);
			// System.out.println(hosted.getInitInstallState() + "->" +
			// hosted.getGoalInstallState() + " hosted on " +
			// host.getInitInstallState() + "->" + host.getGoalInstallState());
			if (row[2] == IStatus.OK) {
				assertHasNoErrorStatus(top);
			} else {
				assertHasErrorStatus(top,
						ICoreProblemType.UNIT_HOST_NOT_INSTALLED);
			}
		}

		// reset
		hosted.setInitInstallState(InstallState.INSTALLED_LITERAL);
		host.setInitInstallState(InstallState.INSTALLED_LITERAL);

		/**
		 * Array of
		 * <ol>
		 * <li> Hosted unit {@link Unit#getGoalInstallState()}
		 * <li> Host unit {@link Unit#getGoalInstallState()}
		 * <li> Topology validation status
		 * </ol>
		 */
		int[][] hostedHostGoalInstallStateSeverityTable = new int[][] {
				{ InstallState.INSTALLED, InstallState.INSTALLED, IStatus.OK },
				{ InstallState.INSTALLED, InstallState.NOT_INSTALLED,
						IStatus.ERROR },
				{ InstallState.INSTALLED, InstallState.UNKNOWN, IStatus.OK },
				{ InstallState.NOT_INSTALLED, InstallState.INSTALLED,
						IStatus.OK },
				{ InstallState.NOT_INSTALLED, InstallState.NOT_INSTALLED,
						IStatus.OK },
				{ InstallState.NOT_INSTALLED, InstallState.UNKNOWN, IStatus.OK },
				{ InstallState.UNKNOWN, InstallState.INSTALLED, IStatus.OK },
				{ InstallState.UNKNOWN, InstallState.NOT_INSTALLED,
						IStatus.ERROR }, // Treat UNKNOWN as INSTALLED
				{ InstallState.UNKNOWN, InstallState.UNKNOWN, IStatus.OK }, };

		for (int i = 0; i < hostedHostGoalInstallStateSeverityTable.length; i++) {
			int[] row = hostedHostGoalInstallStateSeverityTable[i];
			hosted.setGoalInstallState(InstallState.get(row[0]));
			host.setGoalInstallState(InstallState.get(row[1]));
			validate(top);
			// System.out.println(hosted.getInitInstallState() + "->" +
			// hosted.getGoalInstallState() + " hosted on " +
			// host.getInitInstallState() + "->" + host.getGoalInstallState());
			// dumpStatus(top);
			if (row[2] == IStatus.OK) {
				assertHasNoErrorStatus(top);
			} else {
				assertHasErrorStatus(top,
						ICoreProblemType.UNIT_HOST_TO_BE_UNINSTALLED);
			}
		}

		// reset
		hosted.setGoalInstallState(InstallState.UNKNOWN_LITERAL);
		host.setGoalInstallState(InstallState.UNKNOWN_LITERAL);
	}

	/**
	 * Test that setting either endpoint of a dependency link to
	 * goalInstallState = NOT_INSTALLED makes the link appear as if it does not
	 * exist.
	 */
	public void testUninstallUnitDependencyLink() throws Exception {
		Topology top = createTopology("testUninstallUnitDependencyLink");
		Unit u1 = addUnit(top, "u1");
		Requirement req = addRequirement(u1, "u1Req",
				RequirementLinkTypes.DEPENDENCY_LITERAL);
		Unit u2 = addUnit(top, "u2");
		Capability cap = addCapability(u2, "u2Cap",
				CapabilityLinkTypes.DEPENDENCY_LITERAL);
		DependencyLink link = LinkFactory.createDependencyLink(req, cap);
		save(top);

		// Discovery can find the link and cross it
		assertSetEquals(
				ValidatorUtils.discoverDependencyLinkSources(cap, null),
				new Object[] { req });
		assertEquals(ValidatorUtils.discoverDependencyLinkTarget(req, null),
				cap);

		// No validation errors
		validate(top);
		assertHasNoErrorStatus(top);

		//
		// Mark U2 for uninstall
		//
		u2.setGoalInstallState(InstallState.NOT_INSTALLED_LITERAL);

		// Discovery does not "see" the link any more
		assertSetEquals(
				ValidatorUtils.discoverDependencyLinkSources(cap, null), null);
		assertEquals(ValidatorUtils.discoverDependencyLinkTarget(req, null),
				null);

		// Validation errors due to missing dependency link
		validate(top);
		assertHasErrorStatus(top);

		//
		// Mark U1 for uninstall (switch U2 back to install)
		//
		u1.setGoalInstallState(InstallState.NOT_INSTALLED_LITERAL);
		u2.setGoalInstallState(InstallState.UNKNOWN_LITERAL);

		// Discovery does not "see" the link any more
		assertSetEquals(
				ValidatorUtils.discoverDependencyLinkSources(cap, null), null);
		assertEquals(ValidatorUtils.discoverDependencyLinkTarget(req, null),
				null);
	}

	/**
	 * Test that setting either endpoint of a hosting link to goalInstallState =
	 * NOT_INSTALLED makes the link appear as if it does not exist.
	 */
	public void testUninstallUnitHostingLink() throws Exception {
		Topology top = createTopology("testUninstallUnitHostingLink");
		Unit hostee = addUnit(top, "hostee");
		Requirement req = addRequirement(hostee, "u1Req",
				RequirementLinkTypes.HOSTING_LITERAL);
		Unit host = addUnit(top, "host");
		Capability cap = addCapability(host, "u2Cap",
				CapabilityLinkTypes.HOSTING_LITERAL);
		HostingLink link = LinkFactory.createHostingLink(host, hostee);
		save(top);

		// Discovery can find the link and cross it
		assertEquals(ValidatorUtils.discoverHost(hostee, null), host);
		assertSetEquals(ValidatorUtils.discoverHosted(host, null),
				new Object[] { hostee });

		// No validation errors
		validate(top);
		assertHasNoErrorStatus(top);

		//
		// Mark host for uninstall
		//
		host.setGoalInstallState(InstallState.NOT_INSTALLED_LITERAL);

		// Discovery does not "see" the link any more
		assertEquals(ValidatorUtils.discoverHost(hostee, null), null);
		assertSetEquals(ValidatorUtils.discoverHosted(host, null), null);

		// Validation errors due to missing hosting link
		validate(top);
		assertHasErrorStatus(top);

		//
		// Mark hostee for uninstall (switch U2 back to install)
		//
		hostee.setGoalInstallState(InstallState.NOT_INSTALLED_LITERAL);
		host.setGoalInstallState(InstallState.UNKNOWN_LITERAL);

		// Discovery does not "see" the link any more
		assertEquals(ValidatorUtils.discoverHost(hostee, null), null);
		assertSetEquals(ValidatorUtils.discoverHosted(host, null), null);
	}

	/**
	 * Test that setting either endpoint of a member link to goalInstallState =
	 * NOT_INSTALLED makes the link appear as if it does not exist.
	 */
	public void testUninstallUnitMemberLink() throws Exception {
		Topology top = createTopology("testUninstallUnitMemberLink");
		Unit member = addMemberUnit(top, "member", 1, 1);
		Capability memberCap = addCapability(member, "memberCap",
				CapabilityLinkTypes.ANY_LITERAL);
		Unit group = addGroupUnit(top, "group", 1, 1);
		MemberLink link = LinkFactory.createMemberLink(group, member);
		save(top);

		// Discovery can find the link and cross it
		assertSetEquals(ValidatorUtils.discoverGroups(member, null),
				new Object[] { group });
		assertSetEquals(ValidatorUtils.discoverMembers(group, null),
				new Object[] { member });

		// No validation errors
		validate(top);
		assertHasNoErrorStatus(top);

		//
		// Mark group for uninstall
		//
		group.setGoalInstallState(InstallState.NOT_INSTALLED_LITERAL);

		// Discovery does not "see" the link any more
		assertSetEquals(ValidatorUtils.discoverGroups(member, null), null);
		assertSetEquals(ValidatorUtils.discoverMembers(group, null), null);

		// Validation errors due to missing member link
		validate(top);
		assertHasErrorStatus(top);

		//
		// Mark member for uninstall (switch group back to install)
		//
		member.setGoalInstallState(InstallState.NOT_INSTALLED_LITERAL);
		group.setGoalInstallState(InstallState.UNKNOWN_LITERAL);

		// Discovery does not "see" the link any more
		assertSetEquals(ValidatorUtils.discoverGroups(member, null), null);
		assertSetEquals(ValidatorUtils.discoverMembers(group, null), null);

		// Validation errors due to missing member link
		validate(top);
		assertHasErrorStatus(top);
	}
}
