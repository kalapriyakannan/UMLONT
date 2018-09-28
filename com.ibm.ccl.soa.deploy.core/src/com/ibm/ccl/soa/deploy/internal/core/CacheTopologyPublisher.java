package com.ibm.ccl.soa.deploy.internal.core;

import java.util.Iterator;
import java.util.List;

import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;

import com.ibm.ccl.soa.deploy.core.HostingLink;
import com.ibm.ccl.soa.deploy.core.IDeployPublishContext;
import com.ibm.ccl.soa.deploy.core.Topology;
import com.ibm.ccl.soa.deploy.core.TopologyPublisher;
import com.ibm.ccl.soa.deploy.core.Unit;
import com.ibm.ccl.soa.deploy.core.validator.IDeployReporter;
import com.ibm.ccl.soa.deploy.core.validator.status.IDeployPublishStatus;

/**
 * An abstract topology publisher supporting a unit cache abstraction.
 * <p>
 * Each publisher has a topologyCache that is used to maintain the relationships between host and
 * hosted units. The functionality of this caching can be overridden by clients, but a default
 * implementation is provided via the {@link com.ibm.ccl.deploy.core.TopologyCache} class.
 */
public abstract class CacheTopologyPublisher extends TopologyPublisher {

	protected TopologyCache topologyCache;

	/*
	 * @see com.ibm.ccl.soa.deploy.core.TopologyPublisher#appliesTo(com.ibm.ccl.soa.deploy.core.Topology)
	 */
	public IStatus appliesTo(Topology top) {
		return Status.OK_STATUS;
	}

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

		// TODO may also need to pass in a handler here to communicate status along the way

		Topology aTopology = context.getTopology();
		IStatus status = validateTopology(aTopology);
		initializeCaches();
		status = loadPublisherCaches(aTopology);
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
	protected IStatus validateTopology(Topology aTopology) {
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
	protected IStatus loadPublisherCaches(Topology aTopology) {
		IStatus status = Status.OK_STATUS;
		Iterator units = aTopology.getUnits().iterator();

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
		List hostingLinks = hostUnit.getHostingLinks();
		if (!hostingLinks.isEmpty()) {
			for (Iterator it = hostingLinks.iterator(); it.hasNext();) {
				HostingLink link = (HostingLink) it.next();
				Unit hostedUnit = link.getHosted();
				topologyCache.addHostedUnit(hostUnit, hostedUnit);
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

	/**
	 * Add status markers to the topology from the cache
	 * 
	 * @param aTopology
	 * @param reporter
	 *           a deploy status reporter.
	 */
	protected void addStatusMarkers(Topology aTopology, IDeployReporter reporter) {
		// Add status to units
		Iterator units = topologyCache.getUnitsForStatus();
		while (units.hasNext()) {
			Unit unit = (Unit) units.next();
			Iterator markers = topologyCache.getStatusForUnit(unit).iterator();
			while (markers.hasNext()) {
				IDeployPublishStatus status = (IDeployPublishStatus) markers.next();
				reporter.addStatus(status);
			}
		}
	}
}
