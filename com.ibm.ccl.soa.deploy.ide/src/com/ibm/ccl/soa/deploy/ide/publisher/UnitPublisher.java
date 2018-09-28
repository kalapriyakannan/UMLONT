/*******************************************************************************
 * Copyright (c) 2003, 2007 IBM Corporation Licensed Material - Property of IBM. All rights reserved.
 *  
 * US Government Users Restricted Rights - Use, duplication or disclosure v1.0 restricted by GSA ADP
 * Schedule Contract with IBM Corp.
 * 
 * Contributors: IBM Corporation - initial API and implementation
 *******************************************************************************/
package com.ibm.ccl.soa.deploy.ide.publisher;

import org.eclipse.core.runtime.IStatus;

import com.ibm.ccl.soa.deploy.core.Topology;
import com.ibm.ccl.soa.deploy.core.Unit;
import com.ibm.ccl.soa.deploy.core.validator.status.IDeployPublishStatus;
import com.ibm.ccl.soa.deploy.ide.extension.IUnitPublisherService;

public abstract class UnitPublisher {

	/**
	 * The unit publisher service to hold onto
	 */
	private IUnitPublisherService unitPublisherService;

	/**
	 * Provides the interface for unit publishers to check environment conditions i.e an environment
	 * condintion could be Rational product, Eclipse product, Tivoli product </b> must extend this
	 * class.
	 * 
	 * @since 1.0
	 * @return boolean indicating if publisher in context of environment
	 */
	abstract public boolean canPublish(Unit hostUnit);

	/**
	 * Provides the interface to publish a topolgy the scope of the topology is narrowed by cached
	 * data on the unit service </b> must extend this class.
	 * 
	 * @since 1.0
	 * @return boolean indicating publish was successful
	 * 
	 */

	abstract public IStatus publish(Topology topology, IUnitPublisherService unitService);

	/**
	 * Return the type of the runtime instance associated with this hostUnit
	 * 
	 * @param the
	 *           host unit
	 * @return the runtime type id of the host unit, null if it does not exist
	 */
	abstract public String getRuntimeTypeId(Unit hostUnit);

	/**
	 * Return the id of the runtime instance associated with this hostUnit
	 * 
	 * @param the
	 *           host unit
	 * @return the runtime instance id of the host unit, null if it does not exist
	 */
	abstract public String getRuntimeInstanceId(Unit hostUnit);

	/**
	 * Gets an environment identifier i.e. "wtp" or "ast". Context used to filter same typed unit
	 * publishers.
	 * 
	 * @see canPublish().
	 * 
	 * @return String
	 */
	abstract public String getEnvironment();

	/**
	 * Collector of errors during publish process. Final status will be returned to client.
	 * 
	 * @since 1.0
	 * @return IStatus, could contain many IStatus collected during the publish process
	 */

	protected IStatus reportErrorStatus(Unit unit, String message, Exception ex) {

		// Create a status and add to TopologyCache cache
		IDeployPublishStatus status = PublisherValidationUtils.createPublisherStatus(getName(),
				message, ex, unit);
		getUnitPublisherService().getTopologyCache().addUnitStatus(status, unit);

		return status;
	}

	/**
	 * Return the name of this unit publisher
	 */
	protected String getName() {
		//TODO look up from service
		return ""; //$NON-NLS-1$
	}

	/**
	 * 
	 * @return
	 */
	public IUnitPublisherService getUnitPublisherService() {
		return unitPublisherService;
	}

	/**
	 * 
	 * @param unitPublisherService
	 */
	public void setUnitPublisherService(IUnitPublisherService unitPublisherService) {
		this.unitPublisherService = unitPublisherService;
	}
}
