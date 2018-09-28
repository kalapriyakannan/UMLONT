/***************************************************************************************************
 * Copyright (c) 2003, 2007 IBM Corporation Licensed Material - Property of IBM. All rights
 * reserved.
 * 
 * US Government Users Restricted Rights - Use, duplication or disclosure v1.0 restricted by GSA ADP
 * Schedule Contract with IBM Corp.
 * 
 * Contributors: IBM Corporation - initial API and implementation
 **************************************************************************************************/
package com.ibm.ccl.soa.deploy.ide.publisher;

import java.util.Iterator;

import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.osgi.util.NLS;
import org.eclipse.ui.PartInitException;
import org.eclipse.ui.PlatformUI;

import com.ibm.ccl.soa.deploy.core.DeployCorePlugin;
import com.ibm.ccl.soa.deploy.core.Topology;
import com.ibm.ccl.soa.deploy.core.Unit;
import com.ibm.ccl.soa.deploy.core.validator.status.IDeployPublishStatus;
import com.ibm.ccl.soa.deploy.ide.extension.DeployIdeMessages;
import com.ibm.ccl.soa.deploy.ide.extension.IUnitPublisherService;
import com.ibm.ccl.soa.deploy.ide.extension.UnitPublisherServiceFactory;
import com.ibm.ccl.soa.deploy.internal.core.RealizedTopologyPublisher;

/**
 * A &lt;publisher&gt; on the <code>com.ibm.ccl.soa.deploy.core.topology</code> extension point.
 * 
 * @see UnitPublisherServiceFactory
 */
public class IdeTopologyPublisher extends RealizedTopologyPublisher {

	protected IUnitPublisherService unitPublisherService;

	/**
	 * Initialize the unitPublisherService and the topology cache
	 */
	protected void initializeCaches() {
		unitPublisherService = UnitPublisherServiceFactory.createPublisherService();
		topologyCache = unitPublisherService.getTopologyCache();
	}

	/**
	 * Invoke the unitpublishsers to drive the actual publishing of the units
	 * 
	 * @param aTopology
	 *           The topology to publish
	 * @return an IStatus
	 */
	protected IStatus doPublish(Topology aTopology) {
		IStatus status = null;
		// Invoke the publishers
		Iterator publishers = unitPublisherService.getHostPublishers();
		while (publishers.hasNext()) {
			UnitPublisher publisher = (UnitPublisher) publishers.next();
			status = publisher.publish(aTopology, unitPublisherService);
			if (status != Status.OK_STATUS) {
				// TODO handle publish error
			}
		}
		try {
			PlatformUI.getWorkbench().getActiveWorkbenchWindow().getActivePage().showView(
					"com.ibm.ccl.soa.deploy.core.ui.views.publish.report");//$NON-NLS-1$
		} catch (PartInitException e) {
			e.printStackTrace();
		}
		PublishFamilyManager.instance().notifyListeners();
		/* IStatus familyStatus = */
		PublishFamilyManager.instance().scheduleFamily(
				IPublisherConstants.DEPLOY_TOOLS_PUBLISH_FAMILY_NAME, true);
		PublishFamilyManager.instance().reset();

		return Status.OK_STATUS;
	}

	/**
	 * Load the topology cache from the parent class, and the unitPublisher cache
	 * 
	 * @param hostUnit
	 * @return an IStatus
	 */
	protected IStatus loadCaches(Unit hostUnit) {
		super.loadCaches(hostUnit);
		if (topologyCache.isHosting(hostUnit)) {
			// Do not load hosts for configuration units that are hosting
			if (!hostUnit.isConfigurationUnit()) {
				return loadUnitPublisherCaches(hostUnit);
			}
		}
		return null; //nothing to publish for this unit
	}

	/**
	 * Load the unit publisher cache. This associates a unit publisher with both a target host unit
	 * and a runtime indstance id. <BR>
	 * <BR>
	 * Error conditions result if the same instance id is processed twice, or a unit publisher cannot
	 * be found for the specified host unit.
	 * 
	 * @param hostUnit
	 *           The host unit to publish
	 * @return an IStatus
	 */
	protected IStatus loadUnitPublisherCaches(Unit hostUnit) {
		UnitPublisher unitPublisher = getUnitPublisher(hostUnit);
		if (unitPublisher != null) {
			unitPublisherService.addHostPublisherCacheEntry(hostUnit, unitPublisher);
			String runtimeInstanceId = unitPublisher.getRuntimeInstanceId(hostUnit);
			if (!unitPublisherService.hostIdExistsInCache(runtimeInstanceId)) {
				unitPublisherService.addHostIdPublisherCacheEntry(runtimeInstanceId, unitPublisher);
			} else {
				String errMsg = NLS.bind(
						DeployIdeMessages.IDEUnitPublisher_Duplicate_host_instance_identifier,
						new Object[] { unitPublisher.getRuntimeInstanceId(hostUnit) });
				DeployCorePlugin.logError(0, errMsg, null);
				// TODO return some bad status

				// create a marker
				IDeployPublishStatus status = PublisherValidationUtils.createPublisherStatus(getName(),
						errMsg, null, hostUnit);
				// cache the marker
				unitPublisherService.getTopologyCache().addUnitStatus(status, hostUnit);

			}
		} else {
			if (hostUnit.isSetInitInstallState()) {
				return Status.OK_STATUS;
			}
			String errMsg = NLS.bind(
					DeployIdeMessages.IDEUnitPublisher_No_unit_publisher_found_for_unit,
					new Object[] { hostUnit.getName() });
			DeployCorePlugin.logError(0, errMsg, null);
			// TODO return some bad status

			// create a marker
			IDeployPublishStatus status = PublisherValidationUtils.createPublisherStatus(getName(),
					errMsg, null, hostUnit);
			// cache the marker
			unitPublisherService.getTopologyCache().addUnitStatus(status, hostUnit);
		}

		return Status.OK_STATUS;
	}

	/**
	 * Find a unit publisher for the specified host unit. Returns null if a unit publisher is not
	 * found.
	 * 
	 * @param hostUnit
	 * @return the unit publisher, null if one is not found
	 */
	protected UnitPublisher getUnitPublisher(Unit hostUnit) {
		UnitPublisher[] publishers = unitPublisherService.getUnitPublishers(hostUnit);
		UnitPublisher unitPublisher = null;
		for (int i = 0; i < publishers.length; i++) {
			UnitPublisher potentialUnitPublisher = publishers[i];
			if (potentialUnitPublisher.canPublish(hostUnit)) {
				unitPublisher = potentialUnitPublisher;
				return unitPublisher;
			}
		}
		return null;
	}
}
