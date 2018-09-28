/*******************************************************************************
 * Copyright (c) 2003, 2007 IBM Corporation Licensed Material - Property of IBM. All rights reserved.
 *  
 * US Government Users Restricted Rights - Use, duplication or disclosure v1.0 restricted by GSA ADP
 * Schedule Contract with IBM Corp.
 * 
 * Contributors: IBM Corporation - initial API and implementation
 *******************************************************************************/

package com.ibm.ccl.soa.deploy.core.impl;

import java.util.Iterator;

import com.ibm.ccl.soa.deploy.core.Topology;
import com.ibm.ccl.soa.deploy.core.util.SecondOrderIterator;
import com.ibm.ccl.soa.deploy.core.util.TopologyUtil;

/**
 * An iterator over topology types over a topology's edit topology and all its imported topologies.
 * <p>
 * Example:
 * <ul>
 * <li> editTopology
 * <ul>
 * <li> importTopology1
 * <li> importTopology2
 * <ul>
 * <li> importTopology3
 * </ul>
 * </ul>
 * </ul>
 * 
 * The iterator invoked ot topology1 would iterate over the edit topology as well as all its
 * imports: importTopology1, importTopology2, and importTopology3 (indirect/recursive).
 */
public class ImportTopologyFilterIterator extends SecondOrderIterator {
	protected final int filterType;

	/**
	 * Constructs an iterator over all instances of the specified type contained directly, or
	 * indirectly in the topology.
	 * 
	 * @param topology
	 *           the topology to be recursively iterated over.
	 * @param type
	 *           one of {@link #DEPLOY_MODEL_OBJECT}, {@link #UNIT}, {@link #CAPABILITY},
	 *           {@link #REQUIREMENT}, {@link #UNIT_LINK}, {@link #DEPENDENCY_LINK},
	 *           {@link #CONSTRAINT_LINK}, {@link REQUIREMENT_EXPRESSION}, {@link ARTIFACT},
	 *           {@link REALIZATION_LINK}.
	 */
	public ImportTopologyFilterIterator(Topology topology, int type) {
		super(TopologyUtil.getAllImportedTopologies(topology.getEditTopology()).iterator());
		this.filterType = type;
	}

	/*
	 * @see com.ibm.ccl.soa.deploy.core.util.SecondOrderIterator#getValues(java.lang.Object)
	 */
	public Iterator getValues(Object object) {
		return new TopologyFilterIterator((Topology) object, filterType);
	}
}
