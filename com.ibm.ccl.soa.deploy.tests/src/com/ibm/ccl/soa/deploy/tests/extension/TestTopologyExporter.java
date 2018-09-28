/*******************************************************************************
 * Copyright (c) 2003, 2007 IBM Corporation Licensed Material - Property of IBM. All rights reserved.
 *  
 * US Government Users Restricted Rights - Use, duplication or disclosure v1.0 restricted by GSA ADP
 * Schedule Contract with IBM Corp.
 * 
 * Contributors: IBM Corporation - initial API and implementation
 *******************************************************************************/
package com.ibm.ccl.soa.deploy.tests.extension;

import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.emf.ecore.resource.Resource;

import com.ibm.ccl.soa.deploy.core.Topology;
import com.ibm.ccl.soa.deploy.core.TopologyExporter;
import com.ibm.ccl.soa.deploy.core.export.ExportOptionConstants;
import com.ibm.ccl.soa.deploy.core.export.ExportOptionsMetaData;

/**
 * Test implementation of TopologyExporter.
 * 
 * @since 1.0
 * 
 */
public class TestTopologyExporter extends TopologyExporter {

	public Resource[] export(Topology aTopology, ExportOptionsMetaData options) {
		return new Resource[] { aTopology.eResource() };
	}

	public int[] getSupportedOutputOptions() {
		return new int[] { ExportOptionConstants.OUTPUT_AS_ZIP };
	}

	public IStatus validate(Topology aTopology) {
		// TODO Auto-generated method stub
		return Status.OK_STATUS;

	}
}
