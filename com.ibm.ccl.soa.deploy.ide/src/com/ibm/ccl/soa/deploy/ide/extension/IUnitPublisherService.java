/*******************************************************************************
 * Copyright (c) 2003, 2007 IBM Corporation Licensed Material - Property of IBM. All rights reserved.
 *  
 * US Government Users Restricted Rights - Use, duplication or disclosure v1.0 restricted by GSA ADP
 * Schedule Contract with IBM Corp.
 * 
 * Contributors: IBM Corporation - initial API and implementation
 *******************************************************************************/
package com.ibm.ccl.soa.deploy.ide.extension;

import java.util.Iterator;
import java.util.List;

import com.ibm.ccl.soa.deploy.core.TopologyUnitStub;
import com.ibm.ccl.soa.deploy.core.Unit;
import com.ibm.ccl.soa.deploy.ide.publisher.IdeTopologyPublisher;
import com.ibm.ccl.soa.deploy.ide.publisher.UnitPublisher;
import com.ibm.ccl.soa.deploy.internal.core.ApplicationTopologyCache;

/**
 * Provides a management layer for <b>com.ibm.ccl.soa.deploy.core.unitLifecycle/unitPublisherer</b>
 * extensions.
 * 
 * <p>
 * This service is specific to {@link IdeTopologyPublisher}, not generic for all Unit publishing.
 * 
 * @since 1.0
 * @see UnitPublisherServer
 */
public interface IUnitPublisherService {

	/**
	 * Return an array of publishers that can potentially publish the specified hosting unit
	 * 
	 * @param hostingUnit
	 *           The hosting unit for which to find publishers.
	 * @return An array of unit publishers that can potentially provide {@link TopologyUnitStub}s
	 *         for the given input element.
	 */
	UnitPublisher[] getUnitPublishers(Unit hostingUnit);

	/**
	 * Return an enumration for the publishers in the hostPublisherCache
	 * 
	 * @return the enumeration for the publishers
	 */
	Iterator getHostPublishers();

	/**
	 * Add an entry into the hostToPublisherCache
	 * 
	 * @param hostUnit
	 * @param publisher
	 */
	void addHostPublisherCacheEntry(Unit hostUnit, UnitPublisher publisher);

	/**
	 * Add an entry into the hostIdToPublisherCache
	 * 
	 * @param instanceId
	 * @param publisher
	 */
	void addHostIdPublisherCacheEntry(String instanceId, UnitPublisher publisher);

	/**
	 * Return true if instance id already exists in cache
	 * 
	 * @param instanceId
	 *           to check
	 * @return true if the id exists in the cache
	 */
	boolean hostIdExistsInCache(String instanceId);

	/**
	 * Returns hosts for a given publisher
	 * 
	 * @param publisher
	 * @return list of hosts to be published by the specified publisher
	 */
	List getHostsForPublisher(UnitPublisher publisher);

	/**
	 * Returns the topology caching mechanism for this service
	 * 
	 * @return the topology caching mechanism
	 */
	ApplicationTopologyCache getTopologyCache();

}
