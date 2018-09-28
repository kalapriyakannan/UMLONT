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

import org.eclipse.core.runtime.IProgressMonitor;

import com.ibm.ccl.soa.deploy.core.IDeployPublishContext;
import com.ibm.ccl.soa.deploy.core.Topology;
import com.ibm.ccl.soa.deploy.core.validator.IDeployReporter;

/**
 * Default implementation of the {@link IDeployPublishContext}.
 */
public class DeployPublishContext implements IDeployPublishContext {

	protected IProgressMonitor monitor;
	protected int publishState = STATE_NOT_STARTED;
	protected IDeployReporter reporter;
	protected Object result;
	protected Topology topology;
	protected boolean topologyValidated;

	/**
	 * Construct a new deploy publish context.
	 * 
	 * @param topology
	 *           a deploy topology to be published (non-null)
	 * @param validated
	 *           true if the topology has been validated.
	 * @param reporter
	 *           a reporter used to report publish validation and execution errors.
	 * @param monitor
	 *           a publish progress monitor.
	 */
	public DeployPublishContext(Topology topology, boolean validated, IDeployReporter reporter,
			IProgressMonitor monitor) {
		if (topology == null || reporter == null || monitor == null) {
			throw new IllegalArgumentException();
		}
		this.topology = topology;
		topologyValidated = validated;
		this.reporter = reporter;
		this.monitor = monitor;

	}

	/*
	 * @see com.ibm.ccl.soa.deploy.core.IDeployPublishContext#getMonitor()
	 */
	public IProgressMonitor getMonitor() {
		return monitor;
	}

	/*
	 * @see com.ibm.ccl.soa.deploy.core.IDeployPublishContext#getPublishResult()
	 */
	public Object getPublishResult() {
		return result;
	}

	/*
	 * @see com.ibm.ccl.soa.deploy.core.IDeployPublishContext#getPublishState()
	 */
	public int getPublishState() {
		return publishState;
	}

	/*
	 * @see com.ibm.ccl.soa.deploy.core.IDeployPublishContext#getReporter()
	 */
	public IDeployReporter getReporter() {
		return reporter;
	}

	/*
	 * @see com.ibm.ccl.soa.deploy.core.IDeployPublishContext#getTopology()
	 */
	public Topology getTopology() {
		return topology;
	}

	/*
	 * @see com.ibm.ccl.soa.deploy.core.IDeployPublishContext#isTopologyValidated()
	 */
	public boolean isTopologyValidated() {
		return topologyValidated;
	}

	/*
	 * @see com.ibm.ccl.soa.deploy.core.IDeployPublishContext#setPublishResult(java.lang.Object)
	 */
	public void setPublishResult(Object object) {
		result = object;
	}

	/*
	 * @see com.ibm.ccl.soa.deploy.core.IDeployPublishContext#setPublishState(int)
	 */
	public void setPublishState(int state) {
		publishState = state;
	}
}
