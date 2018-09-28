package com.ibm.ccl.soa.deploy.core.extension;

import com.ibm.ccl.soa.deploy.core.TopologyExporter;

/**
 * Descriptor for elements with the name "exporter" that are defined as part of a
 * <b>com.ibm.ccl.soa.deploy.core.topology</b> extension point.
 */
public interface ITopologyExporterDescriptor {

	/**
	 * The exporter created by this method will not be cached. Clients of this method are required to
	 * manage the lifecycle of the new object.
	 * 
	 * @return An instance of the {@link TopologyExporter} defined by the extension or a no-op
	 *         singleton if a problem occurs.
	 */
	public TopologyExporter createTopologyExporter();

	/**
	 * The name of the exporter as defined in the extension
	 * 
	 * @return the name of the exporter
	 */
	public String getName();

	/**
	 * The description of the exporter as defined in the extension
	 * 
	 * @return the description of the exporter
	 */
	public String getDescription();
}
