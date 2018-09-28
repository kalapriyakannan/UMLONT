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

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.ConcurrentModificationException;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.core.runtime.jobs.Job;
import org.eclipse.osgi.util.NLS;

import com.ibm.ccl.soa.deploy.core.DeployCorePlugin;
import com.ibm.ccl.soa.deploy.core.IConstants;
import com.ibm.ccl.soa.deploy.core.Topology;
import com.ibm.ccl.soa.deploy.core.provider.discovery.TopologyDiscovererService;
import com.ibm.ccl.soa.deploy.core.util.DeployNLS;
import com.ibm.ccl.soa.deploy.core.validator.DeployValidatorService;
import com.ibm.ccl.soa.deploy.core.validator.IDomainValidator;
import com.ibm.ccl.soa.deploy.internal.core.DeployCoreMessages;

/**
 * Asynchronous validation of an in-memory topology.
 */
public class DeployValidatorJob extends Job {

	protected final Topology topology;

	protected final DeployValidatorService service;

	protected final IDeployOperationExecutor updateExecutor;

	/** True if the job is working on validation. */
	public boolean working = false;

	/** True if the job has been canceled. */
	public boolean canceled = false;

	/** True if the job has been scheduled for execution. */
	public boolean scheduled = false;

	/** Object used to synchronize access to the job state. */
	protected final Object jobStateLock = new Object();

	/** The time to start working. */
	protected long validationStartTime = 0;

	/**
	 * Construct a validation job.
	 * 
	 * @param topology
	 *           the topology to be validated.
	 * @param service
	 *           the deploy validator service that will be used.
	 * @param updateExecutor
	 *           the operation which updates the topology with the validation results (may be null).
	 */
	public DeployValidatorJob(Topology topology, DeployValidatorService service,
			IDeployOperationExecutor updateExecutor) {
		super(DeployNLS.bind(DeployCoreMessages.Deploy_topology_0_validation_job,
				new Object[] { topology }));
		if (topology == null) {
			throw new IllegalArgumentException();
		}
		this.topology = topology;
		this.service = service;
		this.updateExecutor = updateExecutor;
	}

	/**
	 * @return true if the job is working on validating the topology.
	 */
	public boolean isWorking() {
		return working;
	}

	/**
	 * @return true if the job has been canceled.
	 */
	public boolean isCanceled() {
		return canceled;
	}

	/**
	 * Note that a cancel request is going to be made.
	 * 
	 * @param isCanceled
	 *           true if a cancel request is going to be made.
	 */
	public void setCanceled(boolean isCanceled) {
		canceled = isCanceled;
	}

	/**
	 * @return true if the job has been scheduled for
	 */
	public boolean isScheduled() {
		return scheduled;
	}

	/**
	 * Note that the job is going to be scheduled.
	 * 
	 * @param isScheduled
	 *           true if the job is going to be scheduled.
	 */
	public void setScheduled(boolean isScheduled) {
		scheduled = isScheduled;
	}

	/**
	 * @return the object for synchronizing access to {@link #getJobState()}.
	 */
	public Object getJobStateLock() {
		return jobStateLock;
	}

	/**
	 * Sets the time to start validating.
	 * <p>
	 * A mechanism for delaying the execution of validation. If the start time has elapsed once the
	 * job runs, then it is not further delayed.
	 * 
	 * @param time
	 *           the absolute time in milliseconds to start validation.
	 * @see System#currentTimeMillis()
	 */
	public void setValidationStartTime(long time) {
		validationStartTime = time;
	}

	/*
	 * @see org.eclipse.core.runtime.jobs.Job#run(org.eclipse.core.runtime.IProgressMonitor)
	 */
	protected IStatus run(IProgressMonitor monitor) {
		// After scheduling, additional events may have required more wait time
		long delay = validationStartTime - System.currentTimeMillis();
		while (delay > 0) {
			try {
				Thread.sleep(delay);
			} catch (InterruptedException e) {
				// ignore
			}
			// Process any additional delay requests while we were sleeping
			delay = validationStartTime - System.currentTimeMillis();
		}
		// No more delays: lets start working
		try {
			synchronized (jobStateLock) {
				// Started working
				working = true;
				// No longer scheduled
				scheduled = false;
				// Cancel status
				canceled = monitor.isCanceled();
			}
			TopologyDiscovererService.INSTANCE.enterDefaultDiscoveryCache();

			//
			// Collect applicable validators by validator group
			//
			Collection<IDomainValidator> validators = service.getDomainValidators(topology);
			String validationTaskName = NLS.bind(DeployCoreMessages.Deploy_topology_0_validation_job,
					new String[] { DeployNLS.getName(topology) });
			monitor.beginTask(validationTaskName, validators.size());

			/** Maps group IDs to a list of validators (order preserving). */
			Map<String, List<IDomainValidator>> groupValidatorMap = new LinkedHashMap<String, List<IDomainValidator>>();
			// Force evaluation of default first
			groupValidatorMap.put(IConstants.DEFAULT_VALIDATOR_GROUP_ID,
					new ArrayList<IDomainValidator>());
			for (IDomainValidator validator : validators) {
				if (validator != null) {
					String validatorGID = validator.getGroupID();
					if (validatorGID == null) {
						validatorGID = IConstants.DEFAULT_VALIDATOR_GROUP_ID;
					}
					List<IDomainValidator> list = groupValidatorMap.get(validatorGID);
					if (list == null) {
						list = new ArrayList<IDomainValidator>();
						groupValidatorMap.put(validatorGID, list);
					}
					list.add(validator);
				}
			}

			//
			// Start one child job for each job group
			//
			List<Job> childJobList;
			final DeployValidationContext context = new StatefulDeployValidationContext(topology,
					service, monitor);
			if (groupValidatorMap.isEmpty()) {
				childJobList = Collections.emptyList();
			} else {
				childJobList = new ArrayList<Job>(groupValidatorMap.size());
				for (Map.Entry<String, List<IDomainValidator>> entry : groupValidatorMap.entrySet()) {
					String groupID = entry.getKey();
					final List<IDomainValidator> list = entry.getValue();

					final DeployTransactionReporter reporter = new DeployTransactionReporter();
					reporter.setTopologyUpdateExecutor(updateExecutor);
					reporter.setGroupID(groupID);
					Job childJob = new Job(list.get(0).getGroupDescription()) {
						@Override
						protected IStatus run(IProgressMonitor monitor) {
							try {
								return service.validate(context, reporter, list);
							} catch (Throwable e) {
								if (e instanceof ConcurrentModificationException || monitor.isCanceled()
										|| topology.eIsProxy()) {
									return new Status(IStatus.CANCEL, DeployCorePlugin.PLUGIN_ID, 0,
											DeployCoreMessages.Deploy_validation_cancelled, null);
								}
								IStatus errorStatus = new Status(IStatus.ERROR, DeployCorePlugin.PLUGIN_ID,
										0, DeployCoreMessages.Deploy_validation_failed, e);
								DeployCorePlugin.log(errorStatus);
								// Issue: if we return an error status, the user will be presented
								// with an error dialog. If there is a systemic validation error,
								// that means that it will appear after every topology operation.
								// Avoiding for now.
								return Status.CANCEL_STATUS;
							}
						}
					};
					childJob.setSystem(true);
					childJob.schedule();
					childJobList.add(childJob);
				}
			}

			// Join our children
			for (Job childJob : childJobList) {
				try {
					monitor.subTask(NLS.bind(DeployCoreMessages.Waiting_for_0, childJob.getName()));
					childJob.join();
				} catch (InterruptedException e) {
					IStatus errorStatus = new Status(IStatus.ERROR, DeployCorePlugin.PLUGIN_ID, 0,
							DeployCoreMessages.Deploy_validation_failed, e);
					DeployCorePlugin.log(errorStatus);
				}
			}
		} finally {
			try {
				TopologyDiscovererService.INSTANCE.leaveDefaultDiscoveryCache();
			} finally {
				synchronized (jobStateLock) {
					working = false;
					canceled = false;
				}
			}
		}

		if (monitor.isCanceled()) {
			return Status.CANCEL_STATUS;
		}
		return Status.OK_STATUS;
	}
}
