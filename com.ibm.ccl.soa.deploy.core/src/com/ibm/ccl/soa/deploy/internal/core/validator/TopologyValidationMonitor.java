/*******************************************************************************
 * Copyright (c) 2003, 2007 IBM Corporation Licensed Material - Property of IBM. All rights reserved.
 *  
 * US Government Users Restricted Rights - Use, duplication or disclosure v1.0 restricted by GSA ADP
 * Schedule Contract with IBM Corp.
 * 
 * Contributors: IBM Corporation - initial API and implementation
 *******************************************************************************/
package com.ibm.ccl.soa.deploy.internal.core.validator;

import java.util.Iterator;

import org.eclipse.core.runtime.jobs.Job;
import org.eclipse.emf.common.notify.Adapter;

import com.ibm.ccl.soa.deploy.core.Topology;
import com.ibm.ccl.soa.deploy.core.validator.DeployValidatorService;

/**
 * Static methods for monitoring a topology for change.
 */
public final class TopologyValidationMonitor {

	/**
	 * Default delay in milliseconds for triggering validation after a model change.
	 */
	public static final long DEFAULT_MONITOR_DELAY = 1000;

	private TopologyValidationMonitor() {
		// static methods only
	}

	/**
	 * Monitors the topology for changes, triggering automatic scheduling of validators.
	 * 
	 * @param topology
	 *           the topology to be monitored.
	 * @param validator
	 *           the validator service used to schedule validation.
	 * @param updateExecutor
	 *           used to run the status topology status update at the end of validation.
	 * @param delay
	 *           the time in milliseconds before the job is scheduled on a validation change (see
	 *           {@link Job#schedule(long)}).
	 */
	public static void monitor(Topology topology, DeployValidatorService validator,
			IDeployOperationExecutor updateExecutor, long delay) {
		assert topology != null;
		for (Iterator iter = topology.getEObject().eAdapters().iterator(); iter.hasNext();) {
			Adapter adapter = (Adapter) iter.next();
			if (adapter instanceof DeployValidatorAdapter) {
				// TODO what if the parameters are conflicting?
				return;
			}
		}
		DeployValidatorAdapter adapter = new DeployValidatorAdapter(topology, validator,
				updateExecutor, delay);
		topology.getEObject().eAdapters().add(adapter);
	}

	/**
	 * Removes the monitoring adapter from the topology.
	 * 
	 * @param topology
	 *           the topology which should no longer be monitored.
	 * @param validator
	 *           the validator service used to schedule validation.
	 */
	public static void unmonitor(Topology topology, DeployValidatorService validator) {
		assert topology != null;
		for (Iterator iter = topology.getEObject().eAdapters().iterator(); iter.hasNext();) {
			Adapter adapter = (Adapter) iter.next();
			if (adapter instanceof DeployValidatorAdapter) {
				DeployValidatorAdapter vAdapter = (DeployValidatorAdapter) adapter;
				if (vAdapter.getTopology() == topology && vAdapter.getValidatorService() == validator) {
					iter.remove();
				}
			}
		}
	}
}
