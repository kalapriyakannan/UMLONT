/***************************************************************************************************
 * Copyright (c) 2003, 2007 IBM Corporation Licensed Material - Property of IBM. All rights
 * reserved.
 * 
 * US Government Users Restricted Rights - Use, duplication or disclosure v1.0 restricted by GSA ADP
 * Schedule Contract with IBM Corp.
 * 
 * Contributors: IBM Corporation - initial API and implementation
 **************************************************************************************************/
package com.ibm.ccl.soa.deploy.internal.core.validator;

import java.util.Iterator;
import java.util.List;

import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.MultiStatus;
import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.core.runtime.Status;
import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.Notifier;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.util.EContentAdapter;

import com.ibm.ccl.soa.deploy.core.CorePackage;
import com.ibm.ccl.soa.deploy.core.DeployCorePlugin;
import com.ibm.ccl.soa.deploy.core.DeployModelObject;
import com.ibm.ccl.soa.deploy.core.Import;
import com.ibm.ccl.soa.deploy.core.Topology;
import com.ibm.ccl.soa.deploy.core.validator.DeployValidatorService;
import com.ibm.ccl.soa.deploy.core.validator.status.IDeployPublishStatus;
import com.ibm.ccl.soa.deploy.core.validator.status.IDeployStatus;

/**
 * Crawls the topology and schedules a validation job whenever it is changed.
 * <p>
 * Validation is not triggered for changes in {@link EObject#eAdapters()} and
 * {@link DeployModelObject#getStatus()}.
 */
public class DeployValidatorAdapter extends EContentAdapter implements Adapter, Adapter.Internal {

	protected final Topology topology;

	protected final DeployValidatorService service;

	protected final IDeployOperationExecutor updateExecutor;

	protected final long delay;

	protected boolean blocking = false;

	protected DeployValidatorJob job = null;

	/** Adapter used to subscribe for events on imported topologies. * */
	protected final Adapter importedTopologyAdapter;

	/**
	 * Create a topology validation triggering EMF crawler.
	 * 
	 * @param topology
	 *           the topology that this adapter monitors.
	 * @param service
	 *           the validation service.
	 * @param updateExecutor
	 *           the operation which updates the topology with the validation results (may be null).
	 * @param delay
	 *           the delay in milliseconds for triggering validation.
	 */
	public DeployValidatorAdapter(Topology topology, DeployValidatorService service,
			IDeployOperationExecutor updateExecutor, long delay) {
		assert topology != null;
		assert service != null;
		assert delay >= 0 : delay;
		this.topology = topology;
		this.service = service;
		this.delay = delay;
		this.updateExecutor = updateExecutor;
		final DeployValidatorAdapter thisAdapter = this;

		importedTopologyAdapter = new Adapter() {
			Notifier target = null;

			public Notifier getTarget() {
				return target;
			}

			public boolean isAdapterForType(Object type) {
				return true;
			}

			public void notifyChanged(Notification notification) {
				thisAdapter.notifyChanged(notification);
			}

			public void setTarget(Notifier newTarget) {
				target = newTarget;
			}

		};
		job = new DeployValidatorJob(topology, service, updateExecutor);

		// Adapt imported topologies
		refreshImportAdapters();

		// Schedule immediate validation
		scheduleValidation();
	}

	/**
	 * @return the topology which this adapter monitors.
	 */
	public Topology getTopology() {
		return topology;
	}

	/**
	 * @return the validator service used to validate the topology.
	 */
	public DeployValidatorService getValidatorService() {
		return service;
	}

	/**
	 * @return the validation delay in milliseconds.
	 */
	public long getDelay() {
		return delay;
	}

	/**
	 * @return the executor of the validation results update process (may be null).
	 */
	public IDeployOperationExecutor getUpdateExecutor() {
		return updateExecutor;
	}

	/**
	 * @return true if the adapter invokes blocking validation.
	 */
	public boolean isBlocking() {
		return blocking;
	}

	/**
	 * @return the the validation job associated with this adapter (may be null)
	 */
	public DeployValidatorJob getJob() {
		return job;
	}

	/**
	 * Controls if the adapter will block on the the notification thread for the validation to
	 * complete.
	 * 
	 * @param blocking
	 *           true if validation should be synchronous to the notification, false if asynchronous.
	 */
	public void setBlocking(boolean blocking) {
		this.blocking = blocking;
		if (blocking) {
			try {
				job.join();
			} catch (InterruptedException e) {
				DeployCorePlugin.log(IStatus.ERROR, 0, "" + e.getMessage(), e); //$NON-NLS-1$
			}
		}
	}

	/*
	 * @see org.eclipse.emf.ecore.util.EContentAdapter#notifyChanged(org.eclipse.emf.common.notify.Notification)
	 */
	public void notifyChanged(Notification notification) {
		super.notifyChanged(notification);

		// Don't trigger validation on adapter removal
		if (notification.getEventType() == Notification.REMOVING_ADAPTER) {
			// If adapter removed from topology then remove import adapters
			if (notification.getNotifier() == topology) {
				removeImportAdapters();
			}
			return;
		}

		//Ignore touches.
		if (notification.isTouch()) {
			return;
		}

		Object feature = notification.getFeature();

		// Ignore notifications on {@link DeployModelObject#getStatus()}
		if (feature == CorePackage.Literals.DEPLOY_MODEL_OBJECT__STATUS) {
			return;
		}

		// Changes to the Topology#getImports() or to Import should refresh the import adapters.
		if (feature == CorePackage.Literals.TOPOLOGY__IMPORTS
				|| feature == CorePackage.Literals.IMPORT__NAMESPACE
				|| feature == CorePackage.Literals.IMPORT__PATTERN) {
			refreshImportAdapters();
		}

		if (blocking) {
			// Validate in current thread if blocking
			DeployTransactionReporter reporter = new DeployTransactionReporter();
			reporter.setTopologyUpdateExecutor(updateExecutor);
			DeployValidationContext context = new DeployValidationContext(topology, service,
					new NullProgressMonitor());
			service.validate(context, reporter);
		} else {
			scheduleValidation();
		}
	}

	/**
	 * Refreshes the registration of listeners on topology adapters.
	 */
	protected void refreshImportAdapters() {
		for (Import i : (List<Import>) topology.getImports()) {
			Topology t = i.getTopology();
			t.addTopologyListener(importedTopologyAdapter, Topology.WILDCARD_LISTENER);
		}
	}

	/**
	 * Removes the adapters from the imported topologies.
	 */
	protected void removeImportAdapters() {
		for (Import i : (List<Import>) topology.getImports()) {
			Topology t = i.getTopology();
			t.removeTopologyListener(importedTopologyAdapter, Topology.WILDCARD_LISTENER);
		}
	}

	/**
	 * Schedules in-memory validation as an asynchronous Eclipse job.
	 * <p>
	 * Cancels the current validation job and schedules a new one to start after the delay specified
	 * in the constructor.
	 * 
	 * @see #getJob()
	 */
	protected void scheduleValidation() {
		// Job states
		boolean cancel = false;
		boolean schedule = false;
		synchronized (job.getJobStateLock()) {
			if (job.isWorking()) {
				if (job.isCanceled()) {
					// already canceled
					if (!job.isScheduled()) {
						schedule = true;
					}
				} else {
					cancel = true;
					schedule = true;
				}
			} else if (job.isScheduled()) {
				// waiting to run, so extend its validation start time.
				job.setValidationStartTime(System.currentTimeMillis() + delay);
			} else {
				// Not working or scheduled = done; schedule
				schedule = true;
			}
			if (cancel) {
				job.setCanceled(true);
			}
			if (schedule) {
				job.setScheduled(true);
			}
		}
		try {
			if (cancel) {
				job.cancel();
			}
		} finally {
			if (schedule) {
				job.schedule(delay);
			}
		}
	}

	/**
	 * Clears {@link IDeployStatus} instances from all topology {@link DeployModelObject} instances,
	 * which are not instances of {@link IDeployPublishStatus}.
	 * 
	 * @param topology
	 *           the topology whose deploy message status should be cleared.
	 * @deprecated
	 */
	public static void clearDeployNonPublisherStatus(Topology topology) {
		// TODO use the crawler's collection of targets
		for (Iterator iter = topology.findAllDeployModelObjects(); iter.hasNext();) {
			DeployModelObject object = (DeployModelObject) iter.next();
			IStatus status = object.getStatus();
			if (status == Status.OK_STATUS) {
				// ignore
			} else if (status instanceof IDeployStatus) {
				if (!(status instanceof IDeployPublishStatus)) {
					object.clearStatus();
				}
			} else if (status instanceof MultiStatus) {
				MultiStatus multiStatus = (MultiStatus) status;
				IStatus[] children = multiStatus.getChildren();
				int nonDeployMessageStatusCount = 0;
				int lastNonDeployMessageStatusIndex = -1;
				for (int i = 0; i < children.length; i++) {
					if (!(children[i] instanceof IDeployStatus)
							|| children[i] instanceof IDeployPublishStatus) {
						nonDeployMessageStatusCount++;
						lastNonDeployMessageStatusIndex = i;
					}
				}
				// System.err.println(nonDeployMessageStatusCount);
				if (nonDeployMessageStatusCount == 0) {
					object.clearStatus();
				} else if (nonDeployMessageStatusCount == 1) {
					object.clearStatus();
					object.addStatus(children[lastNonDeployMessageStatusIndex]);
				} else {
					IStatus[] newChildren = new IStatus[nonDeployMessageStatusCount];
					int newIndex = 0;
					for (int i = 0; i < children.length; i++) {
						if (!(children[i] instanceof IDeployStatus)) {
							newChildren[newIndex++] = children[i];
						}
					}
					MultiStatus newStatus = new MultiStatus(multiStatus.getPlugin(), multiStatus
							.getCode(), newChildren, multiStatus.getMessage(), null);
					object.clearStatus();
					object.addStatus(newStatus);
				}
			}
		}
	}
}
