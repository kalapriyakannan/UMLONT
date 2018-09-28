/*******************************************************************************
 * Copyright (c) 2003, 2007 IBM Corporation Licensed Material - Property of IBM. All rights reserved.
 *  
 * US Government Users Restricted Rights - Use, duplication or disclosure v1.0 restricted by GSA ADP
 * Schedule Contract with IBM Corp.
 * 
 * Contributors: IBM Corporation - initial API and implementation
 *******************************************************************************/
package com.ibm.ccl.soa.deploy.ide.extension;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import com.ibm.ccl.soa.deploy.core.Unit;
import com.ibm.ccl.soa.deploy.ide.publisher.UnitPublisher;
import com.ibm.ccl.soa.deploy.internal.core.ApplicationTopologyCache;
import com.ibm.ccl.soa.deploy.internal.core.ApplicationTopologyCacheFactory;

/**
 * @see UnitPublisherServiceFactory
 */
public class UnitPublisherService implements IUnitPublisherService

{
	private final Map publisherHostCache = new HashMap();
	private final Map hostIdToPublisherCache = new HashMap();
	private final Map cachedPublishers = new HashMap();

	private final ApplicationTopologyCache topologyCache;

	private static final UnitPublisher[] NO_PUBLISHERS = new UnitPublisher[0];

	/**
	 * Default constructor that sets the topologyCache mechanism
	 */
	public UnitPublisherService() {
		topologyCache = ApplicationTopologyCacheFactory.createApplicationTopologyCache();
	}

	/**
	 * Return the list of unit publihsers
	 */
	public UnitPublisher[] getUnitPublishers(Unit hostingUnit) {

		UnitPublisherDescriptor[] descriptors = UnitPublisherManager.getInstance()
				.findEnabledUnitPublishers(hostingUnit);

		if (descriptors.length == 0)
			return NO_PUBLISHERS;

		UnitPublisher[] publishers = new UnitPublisher[descriptors.length];
		for (int i = 0; i < descriptors.length; i++) {
			publishers[i] = getPublisher(descriptors[i]);
		}
		return publishers;
	}

	/**
	 * Add an entry into the publisherHostCache
	 */
	public void addHostPublisherCacheEntry(Unit hostUnit, UnitPublisher publisher) {
		List hosts = (List) publisherHostCache.get(publisher);
		if (hosts == null)
			hosts = new ArrayList();
		hosts.add(hostUnit);
		publisherHostCache.put(publisher, hosts);
	}

	/**
	 * Add an entry into the hostIdToPublisherCache
	 */
	public void addHostIdPublisherCacheEntry(String instanceId, UnitPublisher publisher) {
		hostIdToPublisherCache.put(instanceId, publisher);
		// TODO if id already exists, this is an error
	}

	/**
	 * Return true if instance id already exists in cache
	 */
	public boolean hostIdExistsInCache(String instanceId) {
		return null != hostIdToPublisherCache.get(instanceId);
	}

	/**
	 * Return an enumration for the publishers in the hostPublisherCache
	 * 
	 * @return the enumeration for the publishers
	 */
	public Iterator getHostPublishers() {
		return publisherHostCache.keySet().iterator();
	}

	/**
	 * Return the list of hosts for the specified unitPublisher
	 * 
	 * @param hostUnit
	 * @return
	 */
	public List getHostsForPublisher(UnitPublisher publisher) {
		return (List) publisherHostCache.get(publisher);
	}

	private UnitPublisher getPublisher(UnitPublisherDescriptor aDescriptor) {
		UnitPublisher publisher = (UnitPublisher) cachedPublishers.get(aDescriptor);
		if (publisher != null)
			return publisher;
		synchronized (cachedPublishers) {
			publisher = (UnitPublisher) cachedPublishers.get(aDescriptor);
			if (publisher == null)
				cachedPublishers.put(aDescriptor, publisher = aDescriptor.createUnitPublisher());
		}
		return publisher;

	}

	/**
	 * Returns the topology caching mechanism
	 * 
	 * @return
	 */
	public ApplicationTopologyCache getTopologyCache() {
		return topologyCache;
	}

}
