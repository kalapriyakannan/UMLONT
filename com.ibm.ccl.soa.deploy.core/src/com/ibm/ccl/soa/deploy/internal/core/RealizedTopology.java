/***************************************************************************************************
 * Copyright (c) 2003, 2007 IBM Corporation Licensed Material - Property of IBM. All rights
 * reserved.
 * 
 * US Government Users Restricted Rights - Use, duplication or disclosure v1.0 restricted by GSA ADP
 * Schedule Contract with IBM Corp.
 * 
 * Contributors: IBM Corporation - initial API and implementation
 **************************************************************************************************/
package com.ibm.ccl.soa.deploy.internal.core;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.eclipse.core.runtime.IStatus;

import com.ibm.ccl.soa.deploy.core.HostingLink;
import com.ibm.ccl.soa.deploy.core.Topology;
import com.ibm.ccl.soa.deploy.core.Unit;

// /////////////in progress///////////////////////////
// //////////////////////////////////////////////////

public class RealizedTopology {
	private Topology topology = null;

	private final Map unitLegend = new HashMap();

	private final List noOpList = new ArrayList();

	// nodes that are not in a host/hostee relationship
	private List isolated = new ArrayList();

	private final IStatus multiStatus = null;

	public RealizedTopology(Topology aTopology) {
		topology = aTopology;
		loadHostUnits();
	}

	// /API
	public Collection getRealizedUnits() {
		Set keys = unitLegend.keySet();
		return union(keys, getUnitValues());
	}

	public Collection getHostees(Unit host, boolean includeChildHost) {
		if (includeChildHost) {
			return getFlattenHosteeHostList(host);
		}
		return (Collection) unitLegend.get(host);
	}

	public Set getHosts() {
		Set hosts = new HashSet();
		Collection keys = unitLegend.keySet();
		for (Iterator iter = keys.iterator(); iter.hasNext();) {
			Object element = iter.next();
			if (!isolated.contains(element)) {
				hosts.add(element);
			}
		}

		return hosts;
	}

	public List getLeafHosts() {
		Collection leaves = symmetricDifference(getHosts(), getUnitValues());
		leaves = minusSet(unitLegend.keySet(), leaves);
		return (List) leaves;
	}

	private void loadHostUnits() {
		if (topology.findAllUnits() == null) {
			return;
		}
		Iterator unitIterator = topology.findAllUnits();
		for (Iterator iter = unitIterator; iter.hasNext();) {
			Unit unit = (Unit) iter.next();
			if (isHosting(unit) && !noOpList.contains(unit) && !unitLegend.keySet().contains(unit)) {
				loadHostToHostee(unit);
			} else {
				isolated.add(unit);
			}
		}

		filterLoners();
	}

	private void filterLoners() {
		Collection units = getRealizedUnits();
		ArrayList filteredLoners = new ArrayList();
		for (Iterator iter = isolated.iterator(); iter.hasNext();) {
			Object element = iter.next();
			if (!units.contains(element)) {
				unitLegend.put(element, new ArrayList());
				filteredLoners.add(element);
			}
		}
		isolated = filteredLoners;
	}

	private void loadHostToHostee(Unit unit) {
		if (unit.isConceptual()) {
			Unit conceptualHost = unit;
			unit = getRealizedUnit(unit);
			if (unit == null) {
				reportProblem(unit, DeployCoreMessages.RealizedTopology_cant_be_realize_);
				return;
			}
			Collection hostees = aggregateConceptualList(unit, conceptualHost);
			unitLegend.put(unit, hostees);
		} else {
			Collection hostees = getInternalHostees(unit);
			unitLegend.put(unit, hostees);
		}
	}

	private Collection aggregateConceptualList(Unit unit, Unit conceptualHost) {
		List conceptualHostees = getInternalHostees(conceptualHost);
		Collection hostees = getInternalHostees(unit);
		hostees = union(conceptualHostees, hostees);
		return hostees;
	}

	private List getInternalHostees(Unit host) {
		ArrayList hostees = new ArrayList();
		List links = host.getHostingLinks();
		for (Iterator iter = links.iterator(); iter.hasNext();) {
			HostingLink hLink = (HostingLink) iter.next();
			Unit hostee = hLink.getTarget();
			if (hostee == null) {
				reportProblem(host,
						DeployCoreMessages.RealizedTopology_missing_target_from_hosting_lin_);
			} else {
				if (hostee.isConceptual()) {
					hostee = getRealizedUnit(hostee);
				}
				if (hostee != null) {
					hostees.add(hostee);
				} else {
					reportProblem(hostee, DeployCoreMessages.RealizedTopology_cant_be_realize_);
				}
			}
		}
		return hostees;
	}

	private Unit getRealizedUnit(Unit unit) {
		// this is temp api - realization - import in flux
//		RealizationContext context = new RealizationContext(topology);
		// TODO Update for multiple realization
//		DeployModelObject dmo = RealizationLinkUtil.getRealizations(unit); //, context);
//		if (dmo == null)
//			reportProblem(unit, DeployCoreMessages.RealizedTopology_cant_be_realize_);
//		else if (dmo instanceof Unit)
//			return (Unit) dmo;
//		else if (dmo instanceof Capability) {
//			Capability capability = (Capability) dmo;
//			if (capability.getParent() instanceof Unit)
//				return (Unit) capability.getParent();
//			reportProblem(unit, DeployCoreMessages.RealizedTopology_Cant_derive_unit_from_realization_);
//		}
		return null;
	}

	private void reportProblem(Unit unit, String string) {
		noOpList.add(unit);
		// TODO create status
		// throw partial realized topology exception after full traversal.

	}

	private boolean isHosting(Unit unit) {
		if (unit.getHostingLinks() == null) {
			return false;
		}
		return unit.getHostingLinks().size() > 0;
	}

	private Collection getFlattenHosteeHostList(Unit host) {
		Collection flattenList = new ArrayList();
		if (host == null) {
			return flattenList;
		}
		Collection units = (Collection) unitLegend.get(host);
		// Assumes order by hosting link - to be revisted with an order map
		for (Iterator iter = units.iterator(); iter.hasNext();) {
			Unit unit = (Unit) iter.next();
			if (getHosts().contains(unit)) {
				flattenList.addAll(getFlattenHosteeHostList(unit));
			}
			flattenList.add(unit);
		}
		return flattenList;

	}

	private Collection union(Collection keys, Collection values) {
		Set units = new HashSet();
		units.addAll(values);
		units.addAll(keys);
		return units;
	}

	private Collection symmetricDifference(Set keys, Collection values) {
		Set symmetricDif = new HashSet(keys);
		symmetricDif.addAll(values);
		Set temp = new HashSet(keys);
		temp.retainAll(values);
		symmetricDif.removeAll(temp);
		return symmetricDif;
	}

	private List minusSet(Set keys, Collection targetValues) {
		ArrayList minusSet = new ArrayList();
		for (Iterator iter = keys.iterator(); iter.hasNext();) {
			Object element = iter.next();
			if (targetValues.contains(element)) {
				minusSet.add(element);
			}
		}

		return minusSet;
	}

	private Collection getUnitValues() {
		List mapValues = new ArrayList(unitLegend.values());
		ArrayList allValues = new ArrayList();
		for (Iterator iter = mapValues.iterator(); iter.hasNext();) {
			Collection collection = (Collection) iter.next();
			allValues.addAll(collection);

		}
		return allValues;
	}

}
