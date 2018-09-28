/*******************************************************************************
 * Copyright (c) 2003, 2007 IBM Corporation Licensed Material - Property of IBM. All rights reserved.
 *  
 * US Government Users Restricted Rights - Use, duplication or disclosure v1.0 restricted by GSA ADP
 * Schedule Contract with IBM Corp.
 * 
 * Contributors: IBM Corporation - initial API and implementation
 *******************************************************************************/
package com.ibm.ccl.soa.deploy.core.impl;

import java.lang.reflect.Proxy;
import java.util.Iterator;

import com.ibm.ccl.soa.deploy.core.Topology;
import com.ibm.ccl.soa.deploy.core.util.IObjectFilter;
import com.ibm.ccl.soa.deploy.core.util.SecondOrderIterator;
import com.ibm.ccl.soa.deploy.core.util.TopologyUtil;

/**
 * An abstract iterator over values of a topology and all its imported topologies (recursive).
 * <p>
 * The types of values of the topology that are iterated over are determined by the
 * {@link #getTopologyValues(Topology)} abstract method implementation.
 */
public abstract class AllImportedTopologyValueIterator extends SecondOrderIterator {

	/**
	 * Accepts objects that are proxies.
	 * 
	 * @see Proxy#getProxyClass(ClassLoader, Class[])
	 */
	public static final IObjectFilter PROXY_FILTER = new IObjectFilter() {
		public boolean accept(Object value) {
			if (value != null) {
				return Proxy.isProxyClass(value.getClass());
			}
			return false;
		}
	};

	/**
	 * Construct an iterator over the edit topology and all its imported topologies (recursive).
	 * 
	 * @param top
	 *           a topology whose {@link Topology#getEditTopology()} will be iterated over.
	 */
	public AllImportedTopologyValueIterator(Topology top) {
		super(TopologyUtil.getAllImportedTopologies(top, true).iterator());
	}

	/*
	 * @see com.ibm.ccl.soa.deploy.core.util.SecondOrderIterator#getValues(java.lang.Object)
	 */
	public Iterator getValues(Object object) {
		/*
		 * 
		 * Topology top = (Topology) object; if (top.getEditTopology() != top) { return new
		 * FilterIterator(getTopologyValues((Topology) object), PROXY_FILTER); }
		 */
		return getTopologyValues((Topology) object);
	}

	/**
	 * Return an iterator over the topology value selected.
	 * 
	 * @param top
	 *           a deploy topology.
	 * @return Iterator over values.
	 */
	public abstract Iterator getTopologyValues(Topology top);
}
