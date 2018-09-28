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

import com.ibm.ccl.soa.deploy.core.TopologyExporter;
import com.ibm.ccl.soa.deploy.core.extension.ITopologyExporterDescriptor;
import com.ibm.ccl.soa.deploy.core.extension.ITopologyExporterService;

/**
 * Provides a concrete implementation of ITopologyExporterService.
 * 
 * @since 1.0
 * 
 */
public class TopologyExporterService implements ITopologyExporterService {

	private static final TopologyExporterDescriptor[] NO_EXPORTERS = new TopologyExporterDescriptor[0];

	/**
	 * Find all the available topology exporter that are contributed via extensions.
	 * 
	 * @return an array of {@link ITopologyExporterDescriptor}
	 */
	public ITopologyExporterDescriptor[] findAvailableTopologyExporters() {
		TopologyExporterDescriptor[] descriptors = TopologyManager.INSTANCE
				.findAvailableExporters(null);
		if (descriptors.length == 0) {
			return NO_EXPORTERS;
		}
		return descriptors;
	}

	/**
	 * Create an instance of the topology exporter using the descriptor
	 * 
	 * @param aDescriptor
	 *           the topology descriptor to be used to create the instance of the exporter
	 * @return the instance of the exporter
	 */
	public TopologyExporter createTopologyExporter(ITopologyExporterDescriptor aDescriptor) {
		return aDescriptor.createTopologyExporter();

	}

}
