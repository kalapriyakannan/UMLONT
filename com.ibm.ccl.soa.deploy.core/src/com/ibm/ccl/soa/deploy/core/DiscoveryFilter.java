/*******************************************************************************
 * Copyright (c) 2003, 2007 IBM Corporation Licensed Material - Property of IBM. All rights reserved.
 *  
 * US Government Users Restricted Rights - Use, duplication or disclosure v1.0 restricted by GSA ADP
 * Schedule Contract with IBM Corp.
 * 
 * Contributors: IBM Corporation - initial API and implementation
 *******************************************************************************/

package com.ibm.ccl.soa.deploy.core;

import java.util.Arrays;
import java.util.List;

import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.NullProgressMonitor;

/**
 * @since 1.0 This class provides the ability to set the various filter types for the discoverer.
 *        Based on the filters set in this object, the discovery service provider can filter the
 *        elements for return.
 */
public class DiscoveryFilter {
	/**
	 * initial install state(s) of the unit to be matched
	 */
	private List initInstallState;
	/**
	 * source unit to be used as a base for the discovery criteria scope the units that match the
	 * type of this unit.
	 */
	private Unit unit;
	/**
	 * source classes to be used as a base for the discovery criteria scope the units that match the
	 * type of the classes in this array.
	 */
	private Class[] unitTypes;
	/**
	 * list of capabilities to be used in the discovery criteria scope the units that match all of
	 * these capabilities in the list If this is set, then the capabilities of the source unit are
	 * ignored in discovery.
	 */
	private List capabilities;

	/**
	 * list of requirements to be used in the discovery criteria scope the units that match all of
	 * these requirments in the list. If this is set, then the requirements of the source unit are
	 * ignored in discovery.
	 */
	private List requirements;

	/**
	 * a choice whether discovery must consider only units that are direct hosting relationships
	 */
	private Boolean directHosting;

	/**
	 * flag indicating that an existing dependency link should be followed
	 */
	private Boolean followDependency;

	/**
	 * flag indicating that an existing member link should be followed
	 */
	private Boolean useExistingMemberLink;

// MK 8/18/2006 the following flag was added since I can't distinguish
// between the desire to find a host of a unit and the possible groups to
// which the unit might become a member.
	/**
	 * flag indicating that membership links should be investigated
	 */
	private Boolean membership;

	/**
	 * a choice whether discovery must consider units from current topology in use for discovery
	 */
	private Boolean addTopologyToScope;
	/**
	 * Current "target" topology for units once discovered. Typically the topology being editted; the
	 * "current" topology.
	 */
	private Topology topology;
	/**
	 * scope the discovery only to the units that are hosted by the hosts in this list; If this is
	 * set, then the host of the source unit are ignored in discovery.
	 */
	private List hosts;

	/**
	 * Monitor for discovery progress.
	 */
	private IProgressMonitor monitor;

	/**
	 * @return the list of capabilities used in the discovery criteria
	 */
	public List getCapabilities() {
		return capabilities;
	}

	/**
	 * @param capabilities
	 */
	public void setCapabilities(List capabilities) {
		this.capabilities = capabilities;
	}

	/**
	 * @return whether to use direct hosting in the discovery criteria or scope the criteria to dill
	 *         down
	 */
	public Boolean isDirectHosting() {
		return directHosting;
	}

	/**
	 * @param followDependency
	 */
	public void setFollowDependency(Boolean followDependency) {
		this.followDependency = followDependency;
	}

	/**
	 * @return the list of hosts used in the discovery criteria
	 */
	public List getHosts() {
		return hosts;
	}

	/**
	 * @param hosts
	 */
	public void setHosts(List hosts) {
		this.hosts = hosts;
	}

	/**
	 * @return scope the discovery based on the install state
	 */
	public List getInitInstallState() {
		return initInstallState;
	}

	/**
	 * @param initInstallState
	 */
	public void setInitInstallState(List initInstallState) {
		this.initInstallState = initInstallState;
	}

	/**
	 * @return the list of requirements used in the discovery criteria
	 */
	public List getRequirements() {
		return requirements;
	}

	/**
	 * @param requirements
	 */
	public void setRequirements(List requirements) {
		this.requirements = requirements;
	}

	/**
	 * @return the unit used to scope the discovery
	 */
	public Unit getUnit() {
		return unit;
	}

	/**
	 * @param unit
	 */
	public void setUnit(Unit unit) {
		this.unit = unit;
	}

	/**
	 * @return the types like EarModule.class, WebModule.class to scope the result
	 */
	public Class[] getUnitTypes() {
		return unitTypes;
	}

	/**
	 * @param unitTypes
	 *           specify the types like EarModule.class, WebModule.class to scope the result
	 */
	public void setUnitTypes(Class[] unitTypes) {
		this.unitTypes = unitTypes;
	}

	/**
	 * @return whether to use direct hosting in the discovery criteria or scope the criteria to dill
	 *         down
	 */
	public Boolean isDirectDependency() {
		return followDependency;
	}

	/**
	 * 
	 * @param directHosting
	 */
	public void setDirectHosting(Boolean directHosting) {
		this.directHosting = directHosting;
	}

	/**
	 * @return flag indicating whether or not search should follow existing member link
	 */
	public Boolean isExistingMemberLink() {
		return useExistingMemberLink;
	}

	/**
	 * Set flag indicating whether or not search should follow existing member link
	 * 
	 * @param useExistingMemberLink
	 *           flag
	 */
	public void setUseExistingMemberLink(Boolean useExistingMemberLink) {
		this.useExistingMemberLink = useExistingMemberLink;
	}

	/**
	 * @return flag indicating whether or not search should focus on member links
	 */
	public Boolean isMembership() {
		return membership;
	}

	/**
	 * Set flag indicating whether or not search should focus on members links.
	 * 
	 * @param membership
	 *           flag
	 */
	public void setMembership(Boolean membership) {
		this.membership = membership;
	}

	/**
	 * whether the topology units needs to be added to scope
	 * 
	 * @return Returns the addTopologyToScope
	 */
	public Boolean isAddTopologyToScope() {
		return addTopologyToScope;
	}

	/**
	 * @param addTopologyToScope
	 *           The addTopologyToScope to set.
	 */
	public void setAddTopologyToScope(Boolean addTopologyToScope) {
		this.addTopologyToScope = addTopologyToScope;
	}

	/**
	 * @return Returns the topology.
	 */
	public Topology getTopology() {
		return topology;
	}

	/**
	 * @param topology
	 *           The topology to set.
	 */
	public void setTopology(Topology topology) {
		if (topology != null) {
			this.topology = topology.getEditTopology();
		} else {
			this.topology = null;
		}
	}

	/**
	 * Sets the progress monitor used to track discovery progress and cancellation.
	 * <p>
	 * If the monitor is set to null, then the next call to {@link #getProgressMonitor()} will create
	 * a {@link NullProgressMonitor}.
	 * 
	 * @param monitor
	 *           the progress monitor (may be null).
	 */
	public void setProgressMonitor(IProgressMonitor monitor) {
		this.monitor = monitor;
	}

	/**
	 * @return the progress monitor used to cancel long-running discovery queries (never null).
	 */
	public IProgressMonitor getProgressMonitor() {
		if (monitor == null) {
			monitor = new NullProgressMonitor();
		}
		return monitor;
	}

	/**
	 * Returns a hash code value for the array
	 * 
	 * @param array
	 *           the array to create a hash code value for
	 * @return a hash code value for the array
	 */
	private static int hashCode(Object[] array) {
		final int PRIME = 31;
		if (array == null) {
			return 0;
		}
		int result = 1;
		for (int index = 0; index < array.length; index++) {
			result = PRIME * result + (array[index] == null ? 0 : array[index].hashCode());
		}
		return result;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#hashCode()
	 */
	public int hashCode() {
		final int PRIME = 31;
		int result = 1;
		result = PRIME * result + (addTopologyToScope == null ? 0 : addTopologyToScope.hashCode());
		result = PRIME * result + (capabilities == null ? 0 : capabilities.hashCode());
		result = PRIME * result + (directHosting == null ? 0 : directHosting.hashCode());
		result = PRIME * result + (followDependency == null ? 0 : followDependency.hashCode());
		result = PRIME * result + (hosts == null ? 0 : hosts.hashCode());
		result = PRIME * result + (initInstallState == null ? 0 : initInstallState.hashCode());
		result = PRIME * result + (membership == null ? 0 : membership.hashCode());
		result = PRIME * result + (requirements == null ? 0 : requirements.hashCode());
		result = PRIME * result + (topology == null ? 0 : topology.hashCode());
		result = PRIME * result + (unit == null ? 0 : unit.hashCode());
		result = PRIME * result + DiscoveryFilter.hashCode(unitTypes);
		result = PRIME * result
				+ (useExistingMemberLink == null ? 0 : useExistingMemberLink.hashCode());
		return result;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj == null) {
			return false;
		}
		if (getClass() != obj.getClass()) {
			return false;
		}
		final DiscoveryFilter other = (DiscoveryFilter) obj;
		if (addTopologyToScope == null) {
			if (other.addTopologyToScope != null) {
				return false;
			}
		} else if (!addTopologyToScope.equals(other.addTopologyToScope)) {
			return false;
		}
		if (capabilities == null) {
			if (other.capabilities != null) {
				return false;
			}
		} else if (!capabilities.equals(other.capabilities)) {
			return false;
		}
		if (directHosting == null) {
			if (other.directHosting != null) {
				return false;
			}
		} else if (!directHosting.equals(other.directHosting)) {
			return false;
		}
		if (followDependency == null) {
			if (other.followDependency != null) {
				return false;
			}
		} else if (!followDependency.equals(other.followDependency)) {
			return false;
		}
		if (hosts == null) {
			if (other.hosts != null) {
				return false;
			}
		} else if (!hosts.equals(other.hosts)) {
			return false;
		}
		if (initInstallState == null) {
			if (other.initInstallState != null) {
				return false;
			}
		} else if (!initInstallState.equals(other.initInstallState)) {
			return false;
		}
		if (membership == null) {
			if (other.membership != null) {
				return false;
			}
		} else if (!membership.equals(other.membership)) {
			return false;
		}
		if (requirements == null) {
			if (other.requirements != null) {
				return false;
			}
		} else if (!requirements.equals(other.requirements)) {
			return false;
		}
		if (topology == null) {
			if (other.topology != null) {
				return false;
			}
		} else if (!topology.equals(other.topology)) {
			return false;
		}
		if (unit == null) {
			if (other.unit != null) {
				return false;
			}
		} else if (!unit.equals(other.unit)) {
			return false;
		}
		if (!Arrays.equals(unitTypes, other.unitTypes)) {
			return false;
		}
		if (useExistingMemberLink == null) {
			if (other.useExistingMemberLink != null) {
				return false;
			}
		} else if (!useExistingMemberLink.equals(other.useExistingMemberLink)) {
			return false;
		}
		return true;
	}

}
