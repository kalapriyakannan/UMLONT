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

import java.util.Collection;
import java.util.Iterator;

import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;

import com.ibm.ccl.soa.deploy.core.IDeployPublishContext;
import com.ibm.ccl.soa.deploy.core.Topology;
import com.ibm.ccl.soa.deploy.core.Unit;

/**
 * Provides the interface for client extensions to provide a publisher for a topology. Clients who
 * extend <b>com.ibm.ccl.soa.deploy.core.topology/publisher</b> must extend this class. <BR>
 * <BR>
 * Each publisher has a topologyCache that is used to maintain the relationships between host and
 * hosted units. The functionality of this caching can be overridden by clients, but a default
 * implementation is provided via the {@link com.ibm.ccl.deploy.core.TopologyCache} class.
 * 
 * @since 1.0
 * 
 */
public abstract class RealizedTopologyPublisher extends CacheTopologyPublisher {

	RealizedTopology realizedTopology = null;

	/**
	 * Publish the topology. This method can be overridden by clients.
	 * 
	 * Provides the initial flow of the publish process for the publish action. The entire method, or
	 * individual sections can be overridden.
	 * 
	 * @param aTopology
	 *           A topology selected by the user.
	 * @return A status indicate success or failure. The message should be translated in case it is
	 *         displayed to the user.
	 */
	public IStatus publish(IDeployPublishContext context) {

		// TODO may also need to pass in a handler here to communicate status
		// along the way

		Topology aTopology = context.getTopology();
		realizedTopology = new RealizedTopology(aTopology);
		IStatus status = validateTopology(realizedTopology);
		initializeCaches();
		status = loadPublisherCaches(realizedTopology);
		doPublish(aTopology);
		addStatusMarkers(aTopology, context.getReporter());
		return status;
	}

	/**
	 * Invoke the specific publishing tasks after validating and caching the topology.
	 * 
	 * @param aTopology
	 *           The topology to publish
	 * @return A status indicate success or failure. The message should be translated in case it is
	 *         displayed to the user.
	 */
	protected abstract IStatus doPublish(Topology aTopology);

	/**
	 * Validate the topology to be published.
	 * 
	 * @param aTopology
	 *           A topology selected by the user.
	 * @return The IStatus as reported by validation.
	 * 
	 */
	protected IStatus validateTopology(RealizedTopology aTopology) {
		// hook into status
		assert aTopology != null;
		// TODO validate
		return Status.OK_STATUS;
	}

	/**
	 * Drive the caching mechanism for publishing. This method cannot be overridden by clients, as it
	 * provides the basic model traversal functional. Clients can override the implementation of the
	 * unit caching via the loadCaches(Unit) API
	 * 
	 * @param aTopology
	 *           The topology to be published
	 * @return an IStatus
	 */
	protected final IStatus loadPublisherCaches(RealizedTopology aTopology) {
		IStatus status = Status.OK_STATUS;
		Iterator units = aTopology.getRealizedUnits().iterator();

		while (units.hasNext()) {
			Unit hostUnit = (Unit) units.next();
			if (hostUnit != null) {
				status = loadCaches(hostUnit);
			}
		}
		return status;
	}

	/**
	 * Default implementation of unit caching, which gathers the hosted units to be published on a
	 * specific host, via the hosting links. <BR>
	 * <BR>
	 * This method can be overridden by clients if an additional caching mechanism is used to drive
	 * the publish tasks.
	 * 
	 * @param hostUnit
	 *           The host unit for which to load hosted units.
	 * @return an IStatus
	 */
	protected IStatus loadCaches(Unit hostUnit) {
		// TODO check all hosting links go to the same target?
		IStatus status = Status.OK_STATUS;

		if (realizedTopology.getHosts().contains(hostUnit)) {
			Collection units = realizedTopology.getHostees(hostUnit, true);
			for (Iterator iter = units.iterator(); iter.hasNext();) {
				Unit unit = (Unit) iter.next();
				topologyCache.addHostedUnit(hostUnit, unit);
			}

		}
		return status;
	}

	/**
	 * Initialize the topology caching mechanism. The method can be overridden by clients if
	 * additional caching functionality is used to drive the publish tasks.
	 * 
	 */
	protected void initializeCaches() {
		topologyCache = TopologyCacheFactory.createTopologyCache();
	}

	/**
	 * Return the name of this publisher
	 * 
	 * @return the name of the publisher
	 */
	public String getName() {
		// TODO
		return ""; //$NON-NLS-1$
	}
}
