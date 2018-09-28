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

import org.eclipse.core.runtime.IStatus;

/**
 * Provides the interface for client extensions to provide a publisher for a topology. Clients who
 * extend <b>com.ibm.ccl.soa.deploy.core.topology/publisher</b> must extend this class. <BR>
 */
public abstract class TopologyPublisher {

	/**
	 * Returns a non-error status if the publisher is applicable to the publish context.
	 * <p>
	 * This method can be invoked from a user interface thread, and must therefore return quickly.
	 * Extensive topology publish validation should be performed in
	 * {@link #publish(IDeployPublishContext)}.
	 * 
	 * @param topology
	 *           a topology that is to be published.
	 * @return a status with severity not equal to {@link IStatus#ERROR} if the publisher applies,
	 *         ERROR otherwise.
	 */
	public abstract IStatus appliesTo(Topology topology);

	/**
	 * Publishes the desired state represented by a topology over the modeled resources.
	 * <p>
	 * A topology contains {@link Unit} objects representing units of deployment. A {@link Unit} is
	 * associated with a {@link Unit# getInitInstallState()} and a {@link Unit#
	 * getGoalInstallState()}. Publishing may involve:
	 * <ul>
	 * <li> Unit install: init=UNINSTALLED, goal= INSTALLED.
	 * <li> Unit uninstall: init=INSTALLED, goal= UNINSTALLED.
	 * <li> Unit configure: init=INSTALLED, goal= INSTALLED, where some attributes or links have been
	 * changed.
	 * </ul>
	 * <p>
	 * The publish operation may return prior to the actual completion of the provisioning of the
	 * desired state.
	 * <p>
	 * Publishers should not directly change the state of the topology objects. Any statuses
	 * generated in the process of publishing should be reported using the deploy reporter stored in
	 * the context.
	 * <p>
	 * While publishers are free to follow their own workflow, a typical publisher workflow may look
	 * like:
	 * 
	 * <ol>
	 * <li> Validate the topology from the publishing perspective:
	 * <ul>
	 * <li> If the topology has not been validated, as indicated by the context, run topology
	 * validation and check what statuses are created. While some publishers may support publishing
	 * of topologies with errors, others may report that all validation errors should be resolved
	 * prior to publishing.
	 * <li> Check that the types of units included in the topology are supported, and that they were
	 * provided by a unit-provider that is supported .
	 * </ul>
	 * <li> Collect information from the user.
	 * <ul>
	 * <li> Examples can include missing parameters (such as passwords and target hosts) , publishing
	 * windows (schedules), and so on.
	 * </ul>
	 * <li> Determine the publishing workflow:
	 * <ul>
	 * <li> What operations to run, with what parameters and in what order.
	 * <li> Report an error if such a workflow cannot be generated due to missing operations,
	 * parameters, or dependency cycles. Note that a publisher may interact with the user to resolve
	 * these issues and avoid the failure condition.
	 * </ul>
	 * <li> Execute the workflow in the publish job (thread)
	 * <ul>
	 * <li> As each operation is executed, any errors can be even associated with the specific unit
	 * whose publish failed.
	 * </ul>
	 * <li> Alternatively: export the workflow to some other execution engine and/or schedule.
	 * <ul>
	 * <li> In such a case, the publish operation will return when the publish workflow has been
	 * scheduled, but before it has been executed.
	 * </ul>
	 * 
	 * @param context
	 *           the publishing context from which the publisher can obtain the topology, status
	 *           reporter, the and progress monitor. The context can be used
	 * @return the status of the publishing process. This is used for errors that cannot be
	 *         associated with a topology object using the reporter provided by the context object.
	 */
	public abstract IStatus publish(IDeployPublishContext context);
}
