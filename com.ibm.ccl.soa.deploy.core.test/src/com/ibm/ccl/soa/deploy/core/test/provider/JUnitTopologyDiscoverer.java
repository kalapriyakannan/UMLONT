/*******************************************************************************
 * Copyright (c) 2003, 2007 IBM Corporation Licensed Material - Property of IBM. All rights reserved.
 *  
 * US Government Users Restricted Rights - Use, duplication or disclosure v1.0 restricted by GSA ADP
 * Schedule Contract with IBM Corp.
 * 
 * Contributors: IBM Corporation - initial API and implementation
 *******************************************************************************/
package com.ibm.ccl.soa.deploy.core.test.provider;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

import com.ibm.ccl.soa.deploy.core.DeployModelObject;
import com.ibm.ccl.soa.deploy.core.DiscoveryFilter;
import com.ibm.ccl.soa.deploy.core.Topology;
import com.ibm.ccl.soa.deploy.core.TopologyDiscoverer;
import com.ibm.ccl.soa.deploy.core.Unit;
import com.ibm.ccl.soa.deploy.core.UnitDescriptor;
import com.ibm.ccl.soa.deploy.core.provider.discovery.CurrentTopologyDiscoverer;
import com.ibm.ccl.soa.deploy.core.provider.discovery.TopologyDiscovererService;
import com.ibm.ccl.soa.deploy.core.test.TopologyTestCase;
import com.ibm.ccl.soa.deploy.core.validator.ValidatorUtils;

/**
 * Discoverer for unit-testing purposes.
 */
public class JUnitTopologyDiscoverer extends TopologyDiscoverer {

	protected CurrentTopologyDiscoverer discoverer;
	protected JUnitTopologyProvider provider;

	/**
	 * Singleton instance of the discoverer in the discoverer service.
	 */
	private static JUnitTopologyDiscoverer instance;

	/**
	 * @return the stared instance of the unit-test topology discoverer.
	 * 
	 * @see TopologyDiscovererService#getDiscoverers()
	 */
	public static JUnitTopologyDiscoverer getInstance() {
		synchronized (TopologyTestCase.class) {
			if (instance == null) {
				TopologyDiscoverer[] discoverers = TopologyDiscovererService.INSTANCE
						.getDiscoverers();
				if (discoverers == null) {
					throw new RuntimeException("No topology discoverers found");
				}
				for (int i = 0; i < discoverers.length; i++) {
					if (discoverers[i] instanceof JUnitTopologyDiscoverer) {
						if (instance != null) {
							throw new RuntimeException(
									"Multiple test discoverers found!");
						}
						instance = (JUnitTopologyDiscoverer) discoverers[i];
					}
				}
			}
		}
		if (instance == null) {
			throw new RuntimeException(
					"No unit test discoverer found: verify that discoverer extension point for type "
							+ JUnitTopologyDiscoverer.class.getName()
							+ " exists");
		}
		return instance;
	}

	public JUnitTopologyDiscoverer() {
		this.provider = JUnitTopologyProvider.getInstance();
		discoverer = new CurrentTopologyDiscoverer();
	}

	public void setTopology(Topology topology) {
		discoverer.setTopology(topology);
	}

	public Topology getTopology() {
		return discoverer.getTopology();
	}

	protected List copyDeployModelObjectList(List source) {
		List result = new ArrayList(source.size());
		for (Iterator iter = source.iterator(); iter.hasNext();) {
			DeployModelObject obj = (DeployModelObject) iter.next();
			DeployModelObject original = provider.lookupOriginal(obj);
			if (original != null) {
				assert original != obj;
				result.add(original);
			}
		}
		return result;
	}

	protected DiscoveryFilter createFilter(DiscoveryFilter filter) {
		DiscoveryFilter result = new DiscoveryFilter();
		List list = filter.getCapabilities();
		if (list != null) {
			result.setCapabilities(copyDeployModelObjectList(list));
		}
		list = filter.getHosts();
		if (list != null) {
			result.setHosts(copyDeployModelObjectList(list));
		}
		list = filter.getRequirements();
		if (list != null) {
			result.setRequirements(copyDeployModelObjectList(list));
		}
		result.setTopology(getTopology());
		Unit unit = filter.getUnit();
		if (unit != null) {
			result.setUnit((Unit) provider.lookupOriginal(unit));
		}
		result.setUnitTypes(filter.getUnitTypes());
		result.setUnitTypes(filter.getUnitTypes());
		result.setDirectHosting(filter.isDirectHosting());
		result.setFollowDependency(filter.isDirectDependency());
		result.setMembership(filter.isMembership());
		result.setUseExistingMemberLink(filter.isExistingMemberLink());
		result.setInitInstallState(filter.getInitInstallState());
		result.setAddTopologyToScope(filter.isAddTopologyToScope());

		return result;
	}

	public boolean canDiscover(DiscoveryFilter filter) {
		if (getTopology() == null) {
			return false;
		}
		return discoverer.canDiscover(createFilter(filter));
	}

	public List findAll(DiscoveryFilter filter) {
		if (getTopology() == null) {
			return Collections.EMPTY_LIST;
		}
		List<UnitDescriptor> udList = discoverer.findAll(createFilter(filter));
		if ((udList == null) || (udList.size() == 0)) {
			return Collections.EMPTY_LIST;
		}
		List<UnitDescriptor> result = new ArrayList<UnitDescriptor>(udList
				.size());
		for (Iterator<UnitDescriptor> iter = udList.iterator(); iter.hasNext();) {
			UnitDescriptor ud = iter.next();
			Unit unit = ud.getUnitValue();
			result.add(new JUnitUnitDescriptor(unit, provider));
		}
		return result;
	}

	public boolean isDiscoveredUnitSame(Unit unit1, Unit unit2) {
		String path1 = provider.getAnnotationPath(unit1);
		String path2 = provider.getAnnotationPath(unit2);
		return ValidatorUtils.equals(path1, path2);
	}
}
