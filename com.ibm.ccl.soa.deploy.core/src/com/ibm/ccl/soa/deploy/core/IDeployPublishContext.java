/***************************************************************************************************
 * Copyright (c) 2003, 2007 IBM Corporation Licensed Material - Property of IBM. All rights
 * reserved.
 * 
 * US Government Users Restricted Rights - Use, duplication or disclosure v1.0 restricted by GSA ADP
 * Schedule Contract with IBM Corp.
 * 
 * Contributors: IBM Corporation - initial API and implementation
 **************************************************************************************************/
package com.ibm.ccl.soa.deploy.core;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.runtime.IProgressMonitor;

import com.ibm.ccl.soa.deploy.core.validator.IDeployReporter;

/**
 * Interface used to pass evaluation context to a {@link TopologyPublisher}.
 */
public interface IDeployPublishContext {

	/**
	 * Represents the state of publishing before
	 * {@link TopologyPublisher#publish(IDeployPublishContext)} has been invoked.
	 * 
	 * @see #getPublishState()
	 */
	public static final int STATE_NOT_STARTED = 0;

	/**
	 * Represents the state of publishing when the topology is being validated.
	 * 
	 * @see #getPublishState()
	 */
	public static final int STATE_RUNNING_VALIDATION = 1;

	/**
	 * Represents the state of publishing when the topology publishing actions are being planned.
	 * 
	 * @see #getPublishState()
	 */
	public static final int STATE_RUNNING_PLANNING = 2;

	/**
	 * Represents the state of publishing when the topology is being published.
	 * 
	 * @see #getPublishState()
	 */
	public static final int STATE_RUNNING_PUBLISHING = 3;

	/**
	 * Represents the state of publishing when the topology has been successfully published and the
	 * resulting state is being verified.
	 * 
	 * @see #getPublishState()
	 */
	public static final int STATE_RUNNING_PUBLISH_VERIFICATION = 4;

	/**
	 * Represents the state of publishing when the topology publishing is being scheduled for a
	 * future time.
	 * 
	 * @see #getPublishState()
	 */
	public static final int STATE_RUNNING_SCHEDULING = 5;

	/**
	 * Represents the state of publishing when the topology publishing has failed due to validation
	 * errors, prior to any actions being undertaken.
	 * 
	 * @see #getPublishState()
	 */
	public static final int STATE_FAILED_VALIDATION = 6;

	/**
	 * Represents the state of publishing when the topology publishing has failed due to a planning
	 * failure, prior to any actions being undertaken.
	 * 
	 * @see #getPublishState()
	 */
	public static final int STATE_FAILED_PLANNING = 7;

	/**
	 * Represents the state of publishing when the topology publishing has failed during publishing.
	 * 
	 * @see #getPublishState()
	 */
	public static final int STATE_FAILED_PUBLISHING = 8;

	/**
	 * Represents the state of publishing when the scheduling of the topology publishing has failed.
	 * 
	 * @see #getPublishState()
	 */
	public static final int STATE_FAILED_SCHEDULING = 9;

	/**
	 * Represents the state of publishing when the scheduling of the topology has been successfully
	 * published, but verification of the results has failed.
	 * <p>
	 * Failure in verification does not necessitate a failure in publishing, although it may indicate
	 * such a failure.
	 * 
	 * @see #getPublishState()
	 */
	public static final int STATE_FAILED_VERIFICATION = 10;

	/**
	 * Represents the state of publishing when the topology publishing has been scheduled.
	 * 
	 * @see #getPublishState()
	 */
	public static final int STATE_SUCCESS_SCHEDULED = 11;

	/**
	 * Represents the state of publishing when the topology publishing has completed successfully.
	 * 
	 * @see #getPublishState()
	 */
	public static final int STATE_SUCCESS_PUBLISHED = 12;

	/**
	 * Represents the state of publishing when the topology publishing has completed successfully,
	 * and the results have been verified.
	 * 
	 * @see #getPublishState()
	 */
	public static final int STATE_SUCCESS_PUBLISHED_AND_VERIFIED = 13;

	/**
	 * Returns the topology to be published.
	 * 
	 * @return the topology to be published.
	 */
	Topology getTopology();

	/**
	 * Returns true if the topology has been validated prior to publishing.
	 * <p>
	 * If true, then the {@link DeployModelObject#getStatus()} will have been set with the results of
	 * the latest validation. If false, the publisher is responsible to run validation, if deemed
	 * necessary.
	 * 
	 * @return true if the topology has been validated prior to publishing.
	 */
	boolean isTopologyValidated();

	/**
	 * Returns a reporter used to report publish validation and execution errors.
	 * <p>
	 * The reporter is a transactional reporter, allowing publishers to commit statuses part-way
	 * through their execution.
	 * 
	 * @return the status reporter used to associate publish errors, warnings and information
	 *         messages with topology units.
	 */
	IDeployReporter getReporter();

	/**
	 * Returns a progress monitor for publish execution.
	 * 
	 * @return the progress monitor that should be used to check for publish cancel request.
	 */
	IProgressMonitor getMonitor();

	/**
	 * Returns the state of publishing a topology.
	 * <p>
	 * The normal state transitions are shown below. Note that not all publishers will support all
	 * states.
	 * <ol>
	 * <li> {@link #STATE_NOT_STARTED}
	 * <li> {@link #STATE_RUNNING_VALIDATION}
	 * <li> {@link #STATE_RUNNING_PLANNING}
	 * <li> {@link #STATE_RUNNING_PUBLISHING} or {@link #STATE_RUNNING_SCHEDULING} -&gt;
	 * {@link #STATE_SUCCESS_SCHEDULED}
	 * <li> {@link #STATE_RUNNING_PUBLISH_VERIFICATION} or {@link #STATE_SUCCESS_PUBLISHED}
	 * <li> {@link #STATE_SUCCESS_PUBLISHED_AND_VERIFIED}
	 * </ol>
	 * 
	 * For each state, there is a corresponding failure state if publish terminated with an error
	 * during that state:
	 * <ol>
	 * <li> {@link #STATE_FAILED_VALIDATION}
	 * <li> {@link #STATE_FAILED_PLANNING}
	 * <li> {@link #STATE_FAILED_SCHEDULING}
	 * <li> {@link #STATE_FAILED_PUBLISHING}
	 * <li> {@link #STATE_FAILED_VERIFICATION}
	 * </ol>
	 * 
	 * @return the state of publishing the topology.
	 */
	int getPublishState();

	/**
	 * Used to update the current state of the publisher
	 * <p>
	 * The publish states and transitions are documented in {@link #getPublishState()}
	 * 
	 * @param state
	 *           the publish state.
	 */
	void setPublishState(int state);

	/**
	 * Returns a result object that is publisher-specific.
	 * <p>
	 * The result may be a {@link Topology} or a {@link IFile} reference to a topology referring with
	 * the state of the topology updated with the publish results (install states and provider
	 * annotations). Alternatively, the result may refer to a job ID for a scheduled publish action.
	 * 
	 * @return the result reported by the publisher (may be null).
	 */
	Object getPublishResult();

	/**
	 * Optionally used by the publisher to provide an object that is the result of publishing.
	 * 
	 * @param object
	 *           a publisher-specific result object.
	 * @see #getPublishResult() for more information.
	 */
	void setPublishResult(Object object);
}
