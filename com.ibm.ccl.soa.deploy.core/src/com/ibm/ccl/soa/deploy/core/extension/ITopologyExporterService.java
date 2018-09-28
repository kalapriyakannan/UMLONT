/***************************************************************************************************
 * Copyright (c) 2003, 2007 IBM Corporation Licensed Material - Property of IBM. All rights
 * reserved.
 * 
 * US Government Users Restricted Rights - Use, duplication or disclosure v1.0 restricted by GSA ADP
 * Schedule Contract with IBM Corp.
 * 
 * Contributors: IBM Corporation - initial API and implementation
 **************************************************************************************************/
package com.ibm.ccl.soa.deploy.core.extension;

import com.ibm.ccl.soa.deploy.core.TopologyExporter;

/**
 * Provides a management layer for <b>com.ibm.ccl.soa.deploy.core.topology/exporter</b> extensions.
 * 
 * <p>
 * This interface is not intended to be implemented by clients.
 * </p>
 */
public interface ITopologyExporterService {

	/**
	 * Return an array of available topology exporter descriptors
	 * 
	 * @return an array of available topology exporter descriptors (@link TopologyExporterDescriptor)
	 */
	public ITopologyExporterDescriptor[] findAvailableTopologyExporters();

	/**
	 * Create an instance of the topology exporter using the descriptor
	 * 
	 * @param aDescriptor
	 *           the topology descriptor to be used to create the instance of the exporter
	 * @return the instance of the exporter
	 */
	public TopologyExporter createTopologyExporter(ITopologyExporterDescriptor aDescriptor);
}
