/***************************************************************************************************
 * Copyright (c) 2003, 2007 IBM Corporation Licensed Material - Property of IBM. All rights
 * reserved.
 * 
 * US Government Users Restricted Rights - Use, duplication or disclosure v1.0 restricted by GSA ADP
 * Schedule Contract with IBM Corp.
 * 
 * Contributors: IBM Corporation - initial API and implementation
 **************************************************************************************************/
package com.ibm.ccl.soa.deploy.was.validator.resolution;

import java.util.List;

import org.eclipse.emf.ecore.EClass;

import com.ibm.ccl.soa.deploy.core.HostingLink;
import com.ibm.ccl.soa.deploy.core.MemberLink;
import com.ibm.ccl.soa.deploy.core.Requirement;
import com.ibm.ccl.soa.deploy.core.Unit;
import com.ibm.ccl.soa.deploy.was.internal.j2ee.validator.WasJ2eeValidatorUtils;

/**
 * Utility methods for determining if given actions are possible in a resolution.
 */
public class WasResolutionUtils {

	/**
	 * Determine if a hosting link can be removed from a topology. That is, if the link itself is in
	 * the edit topology.
	 * 
	 * @param host
	 *           the host
	 * @param hostee
	 *           the hostee
	 * @return true if the hosting link can be found and is in the edit topology, false otherwise
	 */
	public static boolean canRemoveHostingLink(Unit host, Unit hostee) {
		List<HostingLink> links = host.getHostingLinks();
		for (HostingLink link : links) {
			if (link.getTarget() == hostee) {
				// found hostinglink link
				if (link.getTopology() == link.getEditTopology()) {
					return true;
				}
				break;
			}
		}
		return false;
	}

	/**
	 * Determine if a member link can be removed from a topology. That is, if the link itself is in
	 * the edit topology.
	 * 
	 * @param host
	 *           the group
	 * @param hostee
	 *           the member
	 * @return true if the member link can be found and is in the edit topology, false otherwise
	 */
	public static boolean canRemoveMemberLink(Unit group, Unit member) {
		List<MemberLink> links = group.getMemberLinks();
		for (MemberLink link : links) {
			if (link.getTarget() == member) {
				// found membership link
				if (link.getTopology() == link.getEditTopology()) {
					return true;
				}
				break;
			}
		}
		return false;
	}

	/**
	 * Determine if a unit has a public requirement that can be used as a dependency link source
	 * 
	 * @param unit
	 *           the source unit
	 * @param reqType
	 *           the requirement type
	 * @param create
	 *           boolean flag used to determine whether or not to check for ability to create a
	 *           needed requirement
	 * @return true if the unit has a public requirement of the desired type or if one can be created
	 *         (the unit is public)
	 */
	public static boolean canBeDependencyLinkSource(Unit unit, EClass reqType, boolean create) {
		Requirement req = WasJ2eeValidatorUtils.getAvailableRequirement(unit, reqType);
		if (req == null) {
			// can add a requirement to the object?
			return create ? unit.isPublic() : false;
		}
		// otherwise, available requirement already exists
		return true;
	}

}
