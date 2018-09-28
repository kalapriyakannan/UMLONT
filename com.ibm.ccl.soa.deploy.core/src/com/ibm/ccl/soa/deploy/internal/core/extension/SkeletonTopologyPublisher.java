/***************************************************************************************************
 * Copyright (c) 2003, 2007 IBM Corporation Licensed Material - Property of IBM. All rights
 * reserved.
 * 
 * US Government Users Restricted Rights - Use, duplication or disclosure v1.0 restricted by GSA ADP
 * Schedule Contract with IBM Corp.
 * 
 * Contributors: IBM Corporation - initial API and implementation
 **************************************************************************************************/
package com.ibm.ccl.soa.deploy.internal.core.extension;

import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;

import com.ibm.ccl.soa.deploy.core.DeployCorePlugin;
import com.ibm.ccl.soa.deploy.core.IDeployPublishContext;
import com.ibm.ccl.soa.deploy.core.Topology;
import com.ibm.ccl.soa.deploy.core.TopologyPublisher;

/**
 * Provides a default implementation of {@link TopologyPublisher} that can be returned when clients
 * provide unruly or errant extensions for <b>com.ibm.ccl.soa.core.deploy.topology/publisher</b>.
 * 
 * @since 1.0
 * @see TopologyPublisher
 */
public class SkeletonTopologyPublisher extends TopologyPublisher {

	/** Error used to indicate that the publisher does not succeed. */
	protected final IStatus SKELETON_ERROR_STATUS = new Status(IStatus.ERROR,
			DeployCorePlugin.PLUGIN_ID, 0, SkeletonTopologyPublisher.class.getSimpleName(), null);

	/**
	 * The singleton instance.
	 */
	public static final SkeletonTopologyPublisher INSTANCE = new SkeletonTopologyPublisher();

	private SkeletonTopologyPublisher() {
		// prevent instantiation
	}

	@Override
	public IStatus appliesTo(Topology topology) {
		return SKELETON_ERROR_STATUS;
	}

	@Override
	public IStatus publish(IDeployPublishContext context) {
		return SKELETON_ERROR_STATUS;
	}
}
