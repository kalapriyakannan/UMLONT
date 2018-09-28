/***************************************************************************************************
 * Copyright (c) 2003, 2007 IBM Corporation Licensed Material - Property of IBM. All rights
 * reserved.
 * 
 * US Government Users Restricted Rights - Use, duplication or disclosure v1.0 restricted by GSA ADP
 * Schedule Contract with IBM Corp.
 * 
 * Contributors: IBM Corporation - initial API and implementation
 **************************************************************************************************/
package com.ibm.ccl.soa.deploy.core.provider.discovery;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.eclipse.core.runtime.NullProgressMonitor;

import com.ibm.ccl.soa.deploy.core.Topology;
import com.ibm.ccl.soa.deploy.core.TopologyUnitStub;
import com.ibm.ccl.soa.deploy.core.Unit;
import com.ibm.ccl.soa.deploy.core.UnitDescriptor;
import com.ibm.ccl.soa.deploy.core.UnitProvider;
import com.ibm.ccl.soa.deploy.core.util.TopologyUtil;
import com.ibm.ccl.soa.deploy.core.validator.resolution.ResolutionUtils;

/**
 * UnitDescriptor for a unit discovered in a topology.
 */
public class TopologyUnitDescriptor extends UnitDescriptor {

	/** unit provider */
	private final UnitProvider provider; // = new UnitUnitProvider();

	/**
	 * Map of topologies from which units have been imported; used to cache imported units
	 */
	private static Map topologyMap = new HashMap();

	private final Topology top;

	/**
	 * Constructor; creates UnitDescriptor but first makes sure that the unit that is being described
	 * is in the topology. If it isn't a number of strategies are applied to find it there.
	 * 
	 * @param unit
	 *           the unit to be described
	 * @param topology
	 *           the topology with respect to which the unit is discovered
	 * @param provider
	 *           the provider that is used to create units
	 */
	public TopologyUnitDescriptor(Unit unit, Topology topology, UnitProvider provider) {
		this.provider = provider;
		top = topology;

//		Topology unitTopology = unit.getTopology();
//		Topology unitEditTopology = unit.getEditTopology();
//		if (unitTopology == topology || unitEditTopology == topology) {
//			System.out.println("good news"); //$NON-NLS-1$
//		}
//
		// check if unit is in the topology in which case we can just use it
		if (unit.getTopology() == topology || unit.getEditTopology() == topology) {
			setUnitValue(unit);
			return;
		}

		// check if the unit was imported into the topology in the past
		Unit unitInTopology = TopologyUtil.getUnitInTopology(unit, topology);
		if (null != unitInTopology) {
			setUnitValue(unitInTopology);
			return;
		}

		// else unit is not in the specified topology; must "import" it from its
		// source topology

		// check if we have it cached
		Map unitMapper = (Map) topologyMap.get(unit.getTopology());
		if (null == unitMapper) {
			unitMapper = new HashMap();
			topologyMap.put(unit.getTopology(), unitMapper);
		}
		Unit mappedUnit = (Unit) unitMapper.get(unit);
		if (null != mappedUnit) {
			setUnitValue(mappedUnit);
			return;
		}

		// else unit not cached
		if (null == provider) {

//			Topology editTopology = top.getEditTopology();
//			System.out.println("-----------> " + top.getName()); //$NON-NLS-1$
//			for (Iterator<Unit> it = editTopology.findAllUnits(); it.hasNext();) {
//				Unit u = it.next();
//				String uName = u.getName();
//				String uTopName = u.getTopology().getName();
//				String uETopName = u.getEditTopology().getName();
//				System.out.println(uName + " : " + uTopName + " : " + uETopName); //$NON-NLS-1$ //$NON-NLS-2$
//			}
//
			// MK 7/19/2007 cf. defect 2640; set value null instead of exception
			// also updated all callers to make sure they can deal with this
			setUnitValue(null);
			return;
			// throw new RuntimeException("Invalid Provider"); //$NON-NLS-1$
		}
		TopologyUnitStub[] stubs = new TopologyUnitStub[] { new TopologyUnitStub(null, null, null,
				unit) };
		stubs[0].setTopology(topology);
		Object[] objects = provider.resolveUnit(stubs[0], true, new NullProgressMonitor());
		if (objects.length != 1 || !(objects[0] instanceof Unit)) {
			// FIXME NLS enable this error message
			throw new RuntimeException("Unexpected unit provided."); //$NON-NLS-1$
		}
		mappedUnit = (Unit) objects[0];
		setUnitValue(mappedUnit);
		unitMapper.put(unit, mappedUnit);
	}

	protected String createDescriptorName() {
		return getUnitValue().getFullPath();
	}

	protected String createDisplayName() {
		return getUnitValue().getDisplayName();
	}

	protected Unit getUnit() {
		// MK 8/15/2007 Avoid infinite loop by breaking out when unit is null.
		// In TopologyUnitDescriptor, if unit is null there is no way to recover it (an error occured)
		// In other discoverers the unit might be obtainable from the provider
		return unit == null ? null : getUnitValue();
	}

	protected Unit getUnitAndAddToTopology(Topology topology) {
		Unit unit = getUnitValue();

		if (unit.getTopology() == topology || unit.getEditTopology() == topology) {
			return unit;
		}

		// else copy it to the topology and return it
		// add to topology
		if (null == provider) {
			throw new RuntimeException("Invalid Provider"); //$NON-NLS-1$
		}
		Collection retVal = ResolutionUtils.intelligentDeepCopy(Arrays.asList(new Unit[] { unit }),
				topology);
		List retValAsList = new ArrayList();
		// I would like this in intelligentDeepCopy
		for (Iterator it = retVal.iterator(); it.hasNext();) {
			topology.getUnits().add(it.next());
			retValAsList.addAll(retVal);
		}
		provider.resolveLinks(retValAsList, new NullProgressMonitor());
		assert retValAsList.size() == 1;

		// need to replace existing unit with new unit and mark as in topology
		this.setUnitValue((Unit) retValAsList.get(0));
		/*
		 * no longer necessary when method deprecated this.setAddedToTopology(true);
		 */
		return getUnitValue();
	}

	public boolean referencesUnit(Unit unit) {
		if (null == unit) {
			return false;
		}

		Unit descriptorUnit = getUnitValue();
		Topology sourceTopology = descriptorUnit.getTopology();

		// descriptorUnit and unit might be in the current topology
		// or they might both be in the source topology
		if (unit == descriptorUnit) {
			return true;
		}

		// convert to sourceTopology; if we know about them it is in the source
		// topology
		Unit unitInSourceTopology = TopologyUtil.getUnitInTopology(unit, sourceTopology);
		Unit descriptorUnitInSourceTopology = TopologyUtil.getUnitInTopology(descriptorUnit,
				sourceTopology);

		// if we didn't know how to convert the units to the source topology
		if (null == unitInSourceTopology || null == descriptorUnitInSourceTopology) {
			return false;
		}

		// finally we have two units in a common topology; test
		return unitInSourceTopology == descriptorUnitInSourceTopology;
	}

	public boolean referencesUnit(UnitDescriptor descriptor) {
		return referencesUnit(descriptor.getUnitValue());
	}

	/*
	 * @see java.lang.Object#toString()
	 */
	public String toString() {
		return "TopologyUnitDescriptor[" + getDescriporName() + ']';//$NON-NLS-1$
	}
}
