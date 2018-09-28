package com.ibm.ccl.soa.deploy.core.extension;

import com.ibm.ccl.soa.deploy.core.TopologyPublisher;

/**
 * Descriptor for elements with the name "publisher" that are defined as part of a
 * <b>com.ibm.ccl.soa.deploy.core.topology</b> extension point.
 */
public interface ITopologyPublisherDescriptor {

	/**
	 * The exporter created by this method will not be cached. Clients of this method are required to
	 * manage the lifecycle of the new object.
	 * 
	 * @return An instance of the {@link TopologyPublisher} defined by the extension or a no-op
	 *         singleton if a problem occurs.
	 */
	public TopologyPublisher createTopologyPublisher();

	/**
	 * The name of the publisher as defined in the extension
	 * 
	 * @return the name of the publisher
	 */
	public String getName();

	/**
	 * The description of the publisher as defined in the extension
	 * 
	 * @return the description of the publisher
	 */
	public String getDescription();

}
