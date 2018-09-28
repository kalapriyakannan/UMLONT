/***************************************************************************************************
 * Copyright (c) 2003, 2007 IBM Corporation Licensed Material - Property of IBM. All rights
 * reserved.
 * 
 * US Government Users Restricted Rights - Use, duplication or disclosure v1.0 restricted by GSA ADP
 * Schedule Contract with IBM Corp.
 * 
 * Contributors: IBM Corporation - initial API and implementation
 **************************************************************************************************/

package com.ibm.ccl.soa.deploy.asc;

import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Set;

import com.ibm.ccl.soa.deploy.core.Capability;
import com.ibm.ccl.soa.deploy.core.CorePackage;
import com.ibm.ccl.soa.deploy.core.DependencyLink;
import com.ibm.ccl.soa.deploy.core.HostingLink;
import com.ibm.ccl.soa.deploy.core.InstallState;
import com.ibm.ccl.soa.deploy.core.MemberLink;
import com.ibm.ccl.soa.deploy.core.Requirement;
import com.ibm.ccl.soa.deploy.core.Topology;
import com.ibm.ccl.soa.deploy.core.Unit;
import com.ibm.ccl.soa.deploy.core.provider.discovery.TopologyDiscovererService;
import com.ibm.ccl.soa.deploy.core.util.CapabilityUtil;

public class SequenceUtil {
	/**
	 * Get the sequenced units to be expoted.
	 * 
	 * @param top :
	 *           the topology to be exported
	 * @return units array sequenced
	 */
	public static Unit[] getSequenceUnits(Topology top) {

		LinkedHashSet sequenced = new LinkedHashSet();
		HashSet nonsequenced = new HashSet();
		LinkedHashSet candidates = new LinkedHashSet();
		divideTopology(top, sequenced, nonsequenced);
		candidates.addAll(sequenced);
		sequence(sequenced, nonsequenced, candidates);
		if (nonsequenced.size() > 0) {
			// loop exist.
			sequenced.addAll(nonsequenced);
		}
		Unit[] result = new Unit[sequenced.size()];
		result = (Unit[]) sequenced.toArray(result);
		return result;
	}

	/*
	 * divide topology into two part, installed and non hosted, and others non genericGroup.
	 */
	private static void divideTopology(Topology top, Set sequenced, Set nonsequenced) {
		for (Iterator it = top.getUnits().iterator(); it.hasNext();) {
			Unit unit = (Unit) it.next();
			System.out.println();
			if (isNonRequirement(unit, sequenced)) {
				sequenced.add(unit);
			} else if (!isGenericGroup(unit)) {
				nonsequenced.add(unit);
			}
		}
	}

	private static boolean isNonRequirement(Unit unit, Set sequenced) {

		if (unit.getInitInstallState().equals(InstallState.INSTALLED_LITERAL)) {
			return true;
		}
		if (isHostOK(unit, sequenced) && isGroupOK(unit, sequenced)
				&& isDependencyOK(unit, sequenced)) {
			return true;
		}

		return false;
	}

	private static boolean isGenericGroup(Unit unit) {
		Requirement firstReq = CapabilityUtil.findRequirementOfType(unit, CorePackage.eINSTANCE
				.getUnit());
		return unit.isGroup() && firstReq == null;
	}

	private static void sequence(Set sequenced, Set nonsequenced, Set candidates) {
		Set newCandidates = new HashSet();
		while (candidates.size() > 0) {
			Iterator it = candidates.iterator();
			while (it.hasNext()) {
				Unit unit = (Unit) it.next();
				// for every member
				for (Iterator mIt = unit.getMemberLinks().iterator(); mIt.hasNext();) {
					MemberLink link = (MemberLink) mIt.next();
					Unit member = link.getTarget();
					// still not sequenced
					if (nonsequenced.contains(member)) {
						// can sequence
						if (isHostOK(member, sequenced) && isGroupOK(member, sequenced)
								&& isDependencyOK(member, sequenced)) {
							newCandidates.add(member);
							nonsequenced.remove(member);
							sequenced.add(member);
						}
					}
				}
				// for every hostee
				for (Iterator hIt = unit.getHostingLinks().iterator(); hIt.hasNext();) {
					HostingLink link = (HostingLink) hIt.next();
					Unit hostee = link.getTarget();

					// still not sequenced
					if (nonsequenced.contains(hostee)) {
						// can sequence
						if (isGroupOK(hostee, sequenced) && isDependencyOK(hostee, sequenced)) {
							newCandidates.add(hostee);
							nonsequenced.remove(hostee);
							sequenced.add(hostee);
						}
					}

				}
				// for every dependency
				for (Iterator dIt = unit.getDependencyLinks().iterator(); dIt.hasNext();) {
					DependencyLink dLink = (DependencyLink) dIt.next();
					Capability depCap = dLink.getTarget();
					Unit depUnit = (Unit) depCap.getParent();
					if (nonsequenced.contains(depUnit)) {
						// can sequence
						if (isHostOK(depUnit, sequenced) && isGroupOK(depUnit, sequenced)
								&& isDependencyOK(depUnit, sequenced)) {
							newCandidates.add(depUnit);
							nonsequenced.remove(depUnit);
							sequenced.add(depUnit);
						}
					}
				}

			}
			candidates.clear();
			if (newCandidates.size() > 0) {
				candidates.addAll(newCandidates);
				newCandidates.clear();
			} else {
				ereaseLoop(sequenced, nonsequenced, candidates);
			}
		}
	}

	private static boolean isHostOK(Unit unit, Set sequenced) {
		Unit[] hosts = unit.getTopology().findHosts(unit);
		if (hosts == null || hosts.length == 0) {
			return true;
		}
		Unit host = hosts[0];
		if (sequenced.contains(host)) {
			return true;
		}
		return false;
	}

	private static boolean isGroupOK(Unit unit, Set sequenced) {
		// host >memberof>mandentory dependency>optional dependency
		Unit[] groups = unit.getTopology().findMemberOf(unit);
		for (int i = 0; i < groups.length; i++) {
			Unit group = groups[i];
			if (isGenericGroup(group)) {
				continue;
			}
			if (sequenced.contains(group)) {
				continue;
			}
			// group host on unit, unit prio group.
			if (isHostee(group, unit)) {
				continue;
			}
			return false;
		}
		return true;
	}

	private static boolean isDependencyOK(Unit unit, Set sequenced) {
		Iterator reqIt = unit.getRequirements().iterator();
		while (reqIt.hasNext()) {
			Requirement req = (Requirement) reqIt.next();
			DependencyLink dLink = req.getLink();
			if (dLink != null) {
				Capability targetCap = dLink.getTarget();
				Unit targetUnit = (Unit) targetCap.getParent();
				if (sequenced.contains(targetUnit)) {
					continue;
				}
				Requirement temp = getRequirement(targetUnit, unit);
				if (temp == null) {
					return false;
				}
			}
		}
		return true;
	}

	private static Requirement getRequirement(Unit A, Unit B) {
		Iterator reqIt = A.getRequirements().iterator();
		while (reqIt.hasNext()) {
			Requirement req = (Requirement) reqIt.next();
			DependencyLink dLink = req.getLink();
			if (dLink != null) {
				Capability targetCap = dLink.getTarget();
				Unit targetUnit = (Unit) targetCap.getParent();
				if (targetUnit.equals(B)) {
					return req;
				}
			}
		}
		return null;
	}

	private static boolean isHostee(Unit hostee, Unit host) {
		if (host == null) {
			return false;
		}
		Unit myHost = findHost(hostee);
		while (!host.equals(myHost)) {
			if (myHost == null) {
				return false;
			}
			myHost = findHost(myHost);

		}
		return true;
	}

	private static Unit findHost(Unit unit) {
		Unit hostee = unit;
		Unit host = TopologyDiscovererService.INSTANCE.findHost(hostee, hostee.getTopology());
		if (host == null) {
			Iterator it = ASCUtil.getGroups(unit, null).iterator();
			while (it.hasNext()) {
				host = findHost((Unit) it.next());
				if (host != null) {
					break;
				}
			}
		}
		return host;
	}

	private static void ereaseLoop(Set sequenced, Set nonsequenced, Set candidates) {
		Set temp = new LinkedHashSet();
		Iterator it = nonsequenced.iterator();

		while (it.hasNext()) {
			Unit unit = (Unit) it.next();
			if (isNonHost(unit)) {
				if (isGroupOK(unit, sequenced)) {
					temp.add(unit);
				}
			} else if (isHostOK(unit, sequenced)) {
				temp.add(unit);

			}
		}
		nonsequenced.removeAll(temp);
		sequenced.addAll(temp);
		candidates.addAll(temp);
	}

	private static boolean isNonHost(Unit unit) {
		Unit[] hosts = unit.getTopology().findHosts(unit);
		if (hosts == null || hosts.length == 0) {
			return true;
		}
		return false;
	}

}
