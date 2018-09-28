/*******************************************************************************
 * Copyright (c) 2003, 2007 IBM Corporation Licensed Material - Property of IBM. All rights reserved.
 *  
 * US Government Users Restricted Rights - Use, duplication or disclosure v1.0 restricted by GSA ADP
 * Schedule Contract with IBM Corp.
 * 
 * Contributors: IBM Corporation - initial API and implementation
 *******************************************************************************/
package com.ibm.ccl.soa.deploy.ide.internal.scheme;

import java.util.List;

import com.ibm.ccl.soa.deploy.core.Topology;
import com.ibm.ccl.soa.deploy.core.Unit;
import com.ibm.ccl.soa.deploy.core.validator.resolution.ResolutionUtils;
import com.ibm.ccl.soa.deploy.ide.IdeMessages;

/**
 * @author nmakin
 * 
 */
/**
 * This scheme groups all the first level hostee in one group and the host in another group. TBD -
 * The same rule is followed with second level units
 */
public class SimpleTopologyCreationScheme extends TopologyCreationScheme {

//	TODO move this to descriptor if needed as extension point
	public String getName() {
		return ITopologyCreationSchemeConstants.SIMPLE_TOPOLOGY_CREATION_SCHEME;
	}

	public String getDescription() {
		return IdeMessages.SIMPLE_SCHEME_DESCRIPTION;
	}

	public boolean applyScheme(Topology aTopology) {
		return applyScheme(aTopology.getUnits());
	}

	public boolean applyScheme(List aUnitList) {
		Topology topology = null;
		Unit deployableGroup = null;
		Unit serversGroup = null;
		for (int i = 0; aUnitList != null && i < aUnitList.size(); i++) {
			Unit unit = (Unit) aUnitList.get(i);
			if (unit.isConfigurationUnit())
				continue;
			//find if unit is a group
			if (unit.isGroup())
				continue;
			if (topology == null) {
				topology = unit.getTopology();
			}
			if (unit.getHostingOrAnyCapabilities().size() == 0) {
				if (deployableGroup == null) {
					deployableGroup = getOrCreateDeployableGroup(topology);
				}
				if (unit != deployableGroup && unit != serversGroup) {
					addUnitToGroup(unit, deployableGroup);
				}
			} else {
				if (serversGroup == null) {
					serversGroup = getOrCreateServersGroup(topology);
				}
				addUnitToGroup(unit, serversGroup);
			}
		}
		return true;
	}

	private void addUnitToGroup(Unit member, Unit group) {
		ResolutionUtils.addMember(null, group, member);
	}

	private Unit getOrCreateServersGroup(Topology topology) {
		// TODO Auto-generated method stub
		//TODO?????
		Unit group = createAndAddGroupUnit(topology);
		group.setName("Servers"); //$NON-NLS-1$
		group.setDisplayName("Servers Group"); //$NON-NLS-1$
		return group;
	}

	private Unit getOrCreateDeployableGroup(Topology topology) {
		// TODO Auto-generated method stub
		//TODO?????
		Unit group = createAndAddGroupUnit(topology);
		group.setName("Deployables"); //$NON-NLS-1$
		group.setDisplayName("Deployables Group"); //$NON-NLS-1$
		return group;
	}

	private Unit createAndAddGroupUnit(Topology topology) {
		Unit createdUnit = (Unit) ResolutionUtils.addFromTemplate("deploy.unitGroup", topology); //$NON-NLS-1$
		return createdUnit;
	}

}
