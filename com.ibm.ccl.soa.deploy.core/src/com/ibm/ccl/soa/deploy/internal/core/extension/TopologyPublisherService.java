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

import java.util.Arrays;

import com.ibm.ccl.soa.deploy.core.TopologyPublisher;
import com.ibm.ccl.soa.deploy.core.extension.ITopologyPublisherDescriptor;
import com.ibm.ccl.soa.deploy.core.extension.ITopologyPublisherService;

/**
 * Provides a concrete implementation of ITopologyPublisherService.
 * 
 * @since 1.0
 * 
 */
public class TopologyPublisherService implements ITopologyPublisherService {

	private static final TopologyPublisherDescriptor[] NO_PUBLISHERS = new TopologyPublisherDescriptor[0];

	/**
	 * Find all the available topology publisher that are contributed via extensions.
	 * 
	 * @return an array of {@link ITopologyPublisherDescriptor}
	 */
	public ITopologyPublisherDescriptor[] findAvailableTopologyPublishers() {
		TopologyPublisherDescriptor[] descriptors = TopologyManager.INSTANCE
				.findAvailablePublishers(null);
		if (descriptors.length == 0) {
			return NO_PUBLISHERS;
		}
		Arrays.sort(descriptors, TopologyPublisherDescriptor.NAME_COMPARATOR);
		return descriptors;
	}

	/**
	 * Create an instance of the topology publisher using the descriptor
	 * 
	 * @param aDescriptor
	 *           the topology descriptor to be used to create the instance of the publisher
	 * @return the instance of the publisher
	 */
	public TopologyPublisher createTopologyPublisher(ITopologyPublisherDescriptor aDescriptor) {
		return aDescriptor.createTopologyPublisher();

	}

}
