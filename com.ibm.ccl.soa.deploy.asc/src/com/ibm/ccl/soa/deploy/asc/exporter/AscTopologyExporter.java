/*******************************************************************************
 * Copyright (c) 2003, 2007 IBM Corporation Licensed Material - Property of IBM. All rights reserved.
 *  
 * US Government Users Restricted Rights - Use, duplication or disclosure v1.0 restricted by GSA ADP
 * Schedule Contract with IBM Corp.
 * 
 * Contributors: IBM Corporation - initial API and implementation
 *******************************************************************************/
package com.ibm.ccl.soa.deploy.asc.exporter;

import java.io.OutputStream;
import java.util.zip.ZipOutputStream;

import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.emf.ecore.resource.Resource;

import com.ibm.ccl.soa.deploy.asc.ASCUtil;
import com.ibm.ccl.soa.deploy.asc.exception.ASCException;
import com.ibm.ccl.soa.deploy.asc.exception.ExporterLogger;
import com.ibm.ccl.soa.deploy.core.Topology;
import com.ibm.ccl.soa.deploy.core.TopologyExporter;
import com.ibm.ccl.soa.deploy.core.Unit;
import com.ibm.ccl.soa.deploy.core.export.ExportOptionConstants;
import com.ibm.ccl.soa.deploy.core.export.ExportOptionsMetaData;

/**
 * ASC Topology Exporter to export a topology to a set of ASC tasks and an excutable package.
 * 
 * @since 1.0
 * @author WangXue
 * @author ZhaoYong
 * @author Lin Feng
 */
public class AscTopologyExporter extends TopologyExporter {

	/**
	 * Export the topology.Will be invoked from the UI export wizard.
	 * 
	 * @param aTopology
	 *           A topology selected by the user.
	 * @param options
	 *           options for export
	 * @return A status indicate success or failure. The message should be translated in case it is
	 *         displayed to the user.
	 */
	public Resource[] export(Topology aTopology, ExportOptionsMetaData options) {
		OutputStream outputStream = null;
		if (options.getOutputAs() == ExportOptionConstants.OUTPUT_AS_ZIP)
			outputStream = (OutputStream) options.getOutput();

		ASCBuilder builder = ASCBuilderFactory.instance.createASCBuilder();
		ExporterLogger logger = ExporterLogger.INSTANCE;
		try {
			Unit[] units = ASCUtil.getSequenceUnits(aTopology);
			builder.addUnitArray(units);
			builder.buildZip((ZipOutputStream) outputStream);
		} catch (ASCException e) {
			logger.logException(e);
			e.printStackTrace();
			throw new RuntimeException(e);
		} finally {
			// refine code to make ExportLogger can return IStatus list
			options.getExportLog().addStatus(logger.getStatusList());
			System.out.print(logger.getLogContent());
			logger.clean();
		}

		return new Resource[] { aTopology.eResource() };
	}

	/**
	 * @see TopologyExporter#getSupportedOutputOptions() support ExportOptionConstants#OUTPUT_AS_ZIP
	 */
	public int[] getSupportedOutputOptions() {
		return new int[] { ExportOptionConstants.OUTPUT_AS_ZIP };
	}

	/**
	 * @see TopologyExporter#validate(Topology aTopology)
	 */
	public IStatus validate(Topology aTopology) {
		// TODO LIN -- Add the validation for the topology
		// as an example if there is no provider defined for ASC export for a
		// unit, push an error.
		/*
		 * return new Status( IStatus.ERROR, DeployCoreUIPlugin.PLUGIN_ID, 0,
		 * Messages.DEPLOYMENTTOPOLOGYEXPORT_TOPOLOGY_HAS_VALIDATION_ERRORS, null);
		 */
		return Status.OK_STATUS;
	}

}
