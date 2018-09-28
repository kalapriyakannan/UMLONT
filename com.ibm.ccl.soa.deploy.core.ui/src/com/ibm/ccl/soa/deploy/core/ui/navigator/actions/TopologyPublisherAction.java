/***************************************************************************************************
 * Copyright (c) 2003, 2007 IBM Corporation Licensed Material - Property of IBM. All rights
 * reserved.
 * 
 * US Government Users Restricted Rights - Use, duplication or disclosure v1.0 restricted by GSA ADP
 * Schedule Contract with IBM Corp.
 * 
 * Contributors: IBM Corporation - initial API and implementation
 **************************************************************************************************/
package com.ibm.ccl.soa.deploy.core.ui.navigator.actions;

import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.jface.action.Action;
import org.eclipse.swt.widgets.MessageBox;
import org.eclipse.swt.widgets.Shell;

import com.ibm.ccl.soa.deploy.core.IDeployPublishContext;
import com.ibm.ccl.soa.deploy.core.Topology;
import com.ibm.ccl.soa.deploy.core.extension.ITopologyPublisherDescriptor;
import com.ibm.ccl.soa.deploy.internal.core.DeployPublishContext;
import com.ibm.ccl.soa.deploy.internal.core.validator.ListLogDeployReporter;

/**
 * TopologyPublisherAction creates publisher actions based on the TopologyPublisherDescriptor.
 * 
 */
public class TopologyPublisherAction extends Action {

	private final ITopologyPublisherDescriptor topologyPublisherDescriptor;
	private Topology topology;
	private final Shell shell;

	/**
	 * @param shell
	 * @param topologyPublisher
	 * @param topology
	 * 
	 * Creates TopologyPublisherAction based on the TopologyPublisherDescriptor
	 */
	public TopologyPublisherAction(Shell shell,
			ITopologyPublisherDescriptor topologyPublisherDescriptor, Topology topology) {
		super(topologyPublisherDescriptor.getName());
		this.shell = shell;
		setId(ActionIds.PUBLISH_TOPOLOGY_ACTION + topologyPublisherDescriptor.getName());
		this.topologyPublisherDescriptor = topologyPublisherDescriptor;
		this.topology = topology;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.jface.action.Action#isEnabled()
	 */
	public boolean isEnabled() {
		return true;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.jface.action.Action#run()
	 * 
	 * creates the TopologyPublisher for a given Topology and publishes the topology. In case of any
	 * error, the status is displayed as a messagebox.
	 */
	public void run() {
		try {
			ListLogDeployReporter reporter = new ListLogDeployReporter();
			NullProgressMonitor monitor = new NullProgressMonitor();
			IDeployPublishContext context = new DeployPublishContext(topology, true, reporter, monitor);
			IStatus status = topologyPublisherDescriptor.createTopologyPublisher().publish(context);
			reporter.addReportedInEditTransaction(topology, monitor);
			if (status != null && status.getSeverity() == IStatus.ERROR) {
				MessageBox messageBox = new MessageBox(shell);
				messageBox.setMessage(status.getMessage());
				messageBox.open();
			}

		} catch (Exception ex) {
			ex.printStackTrace();
		}

	}

	public void setTopology(Topology topology) {
		this.topology = topology;
	}

}
