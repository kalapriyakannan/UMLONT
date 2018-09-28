/*******************************************************************************
 * Copyright (c) 2003, 2007 IBM Corporation Licensed Material - Property of IBM. All rights reserved.
 *  
 * US Government Users Restricted Rights - Use, duplication or disclosure v1.0 restricted by GSA ADP
 * Schedule Contract with IBM Corp.
 * 
 * Contributors: IBM Corporation - initial API and implementation
 *******************************************************************************/
package com.ibm.ccl.soa.deploy.was.db2.ui.eartodb.filters;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import com.ibm.ccl.soa.deploy.core.Topology;
import com.ibm.ccl.soa.deploy.core.Unit;
import com.ibm.ccl.soa.deploy.core.provider.discovery.TopologyDiscovererService;
import com.ibm.ccl.soa.deploy.was.db2.ui.discoverer.IDiscoveryResultFilter;
import com.ibm.ccl.soa.deploy.was.db2.ui.discoverer.IDiscoveryResultFilterTest;
import com.ibm.ccl.soa.deploy.was.db2.ui.discoverer.UnifiedDiscoveryResultFilter;

/**
 * Filter to be used on results from a discoverer to ensure that the candidate unit is hosted on an
 * expected host.
 */
public class HostedOnFilter extends UnifiedDiscoveryResultFilter implements IDiscoveryResultFilter {

	/**
	 * Constructor that stores the topology and a module's requirement for a datasource
	 * 
	 * @param topology
	 *           the topology
	 * @param expectedHost
	 *           the expected host of the data source
	 * @param direct
	 *           flag indicating whether or not the host should be a direct host
	 */
	public HostedOnFilter(Topology topology, Unit expectedHost, boolean direct) {
		super(new IDiscoveryResultFilterTest[] { new HostedOnTest(expectedHost, topology, direct) });
	}

	private static class HostedOnTest implements IDiscoveryResultFilterTest {

		// desired host
		private Unit expectedHost;

		// the current topology
		private Topology topology;

		// flag indicating whether or not the host should be a direct host
		private boolean directHost;

		/**
		 * Constructor for hosting test.
		 * 
		 * @param expectedHost
		 *           the desired host
		 * @param topology
		 *           the current topology
		 * @param direct
		 *           boolean flag indicating whether or not the host should be the direct host
		 */
		public HostedOnTest(Unit expectedHost, Topology topology, boolean direct) {
			this.expectedHost = expectedHost;
			this.topology = topology;
			this.directHost = direct;
		}

		public boolean isUnitOK(Unit unit) {
			if (directHost) {
				Unit host = discoverHost(unit, this.topology);
				return (host == this.expectedHost);
			}

			List hosts = discoverHostsRecursive(unit, this.topology);
			for (int i = 0; i < hosts.size(); i++) {
				Unit host = (Unit) hosts.get(i);
				if (host == this.expectedHost)
					return true;
			}
			return false;
		}

		public static List discoverHostsRecursive(Unit unit, Topology topology) {
			if (unit == null) {
				return Collections.EMPTY_LIST;
			}
			Unit cur = discoverHost(unit, topology);
			List list = null;
			while (cur != null) {
				if (list == null) {
					list = new ArrayList();
				}
				list.add(cur);
				cur = discoverHost(cur, topology);
			}
			if (list == null) {
				return Collections.EMPTY_LIST;
			}
			return list;
		}

		public static Unit discoverHost(Unit unit, Topology topology) {
			if (unit == null) {
				return null;
			}
			return TopologyDiscovererService.INSTANCE.findHost(unit, topology);
		}

	}

}
