/*******************************************************************************
 * Copyright (c) 2003, 2007 IBM Corporation Licensed Material - Property of IBM. All rights reserved.
 *  
 * US Government Users Restricted Rights - Use, duplication or disclosure v1.0 restricted by GSA ADP
 * Schedule Contract with IBM Corp.
 * 
 * Contributors: IBM Corporation - initial API and implementation
 *******************************************************************************/
package com.ibm.ccl.soa.deploy.core;

import org.eclipse.core.runtime.IStatus;
import org.eclipse.emf.ecore.resource.Resource;

import com.ibm.ccl.soa.deploy.core.export.ExportOptionsMetaData;

/**
 * Provides the interface for client extensions to provide an exporter for a topology. Clients who
 * extend <b>com.ibm.ccl.soa.deploy.core.topology/exporter</b> must extend this class.
 * 
 * @since 1.0
 * 
 */
public abstract class TopologyExporter {

	/**
	 * Export the topology.
	 * 
	 * @param aTopology
	 *           A topology selected by the user.
	 * @param options
	 *           options for export
	 * @return A status indicate success or failure. The message should be translated in case it is
	 *         displayed to the user.
	 */
	public abstract Resource[] export(Topology aTopology, ExportOptionsMetaData options);

	/**
	 * The output options for this exporter like OUTPUT_AS_ZIP, OUTPUT_AS_FOLDER etc.
	 * 
	 * @return the enabled output options for this exporter
	 */
	public abstract int[] getSupportedOutputOptions();

	/**
	 * Give a chance to the exporter to validate the topology. If there are errors that can happen
	 * during export, push a deploy status to the unit for that.
	 * 
	 * @param aTopology
	 *           a topology object to be validated
	 * @return the status
	 */
	public abstract IStatus validate(Topology aTopology);
}
