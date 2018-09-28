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
import java.util.Iterator;
import java.util.List;

import org.eclipse.emf.ecore.EClass;

import com.ibm.ccl.soa.deploy.core.Topology;
import com.ibm.ccl.soa.deploy.core.Unit;
import com.ibm.ccl.soa.deploy.core.UnitDescriptor;
import com.ibm.ccl.soa.deploy.core.provider.discovery.TopologyDiscovererService;
import com.ibm.ccl.soa.deploy.was.db2.ui.discoverer.IDiscoveryResultFilter;

/**
 * Filter to be used on results from a discoverer to ensure that the unit has a particular host of a
 * given type
 */
public class ExpectedHostFilter implements IDiscoveryResultFilter {

	/** the expected host */
	protected Unit commonHost;

	/** the {@link EClass} of the expected host */
	protected EClass hostType;

	/** the target topology */
	protected Topology topology;

	/**
	 * Constuctor.
	 * 
	 * @param host
	 *           the expected host (need not be in the target topology)
	 * @param topology
	 *           target topology
	 */
	public ExpectedHostFilter(Unit host, Topology topology) {
		this.commonHost = host;
		this.hostType = host.getEObject().eClass();
		this.topology = topology;
	}

	public List select(List units) {
		List filtered = new ArrayList();
		for (Iterator uIt = units.iterator(); uIt.hasNext();) {
			boolean candidateUnitValid = true;
			UnitDescriptor ud = (UnitDescriptor) uIt.next();
			Unit candidateUnit = (Unit) ud.getUnitValue();

			// check that the host matches
			Unit host = TopologyDiscovererService.INSTANCE.findHost(candidateUnit, hostType, topology);
			if ((host == null) || (commonHost == null)) {
				if ((host == null) && (commonHost == null)) {
					// ok
				} else {
					candidateUnitValid = false;
					continue;
				}
			} else {
				if (!host.getName().equals(commonHost.getName())) {
					candidateUnitValid = false;
					continue;
				}
			}

			if (candidateUnitValid)
				filtered.add(ud);
		}

		return filtered;
	}
}
