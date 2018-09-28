/*******************************************************************************
 * Copyright (c) 2003, 2007 IBM Corporation Licensed Material - Property of IBM. All rights reserved.
 *  
 * US Government Users Restricted Rights - Use, duplication or disclosure v1.0 restricted by GSA ADP
 * Schedule Contract with IBM Corp.
 * 
 * Contributors: IBM Corporation - initial API and implementation
 *******************************************************************************/
package com.ibm.ccl.soa.deploy.internal.core.extension;

import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.emf.ecore.resource.Resource;

import com.ibm.ccl.soa.deploy.core.Topology;
import com.ibm.ccl.soa.deploy.core.TopologyExporter;
import com.ibm.ccl.soa.deploy.core.export.ExportOptionConstants;
import com.ibm.ccl.soa.deploy.core.export.ExportOptionsMetaData;

/**
 * Provides a default implementation of {@link TopologyExporter} that can be returned when clients
 * provide unruly or errant extensions for <b>com.ibm.ccl.soa.core.deploy.topology/exporter</b>.
 * 
 * @since 1.0
 * @see TopologyExporter
 * 
 */
public class SkeletonTopologyExporter extends TopologyExporter {

	/**
	 * The singleton instance.
	 */
	public static final SkeletonTopologyExporter INSTANCE = new SkeletonTopologyExporter();

	private SkeletonTopologyExporter() {
	}

	public Resource[] export(Topology aTopology, ExportOptionsMetaData options) {
		return null;
	}

	public int[] getSupportedOutputOptions() {
		return new int[] { ExportOptionConstants.OUTPUT_AS_ZIP };
	}

	public IStatus validate(Topology aTopology) {
		// TODO Auto-generated method stub
		return Status.OK_STATUS;

	}

}
