/***************************************************************************************************
 * Copyright (c) 2003, 2007 IBM Corporation Licensed Material - Property of IBM. All rights
 * reserved.
 * 
 * US Government Users Restricted Rights - Use, duplication or disclosure v1.0 restricted by GSA ADP
 * Schedule Contract with IBM Corp.
 * 
 * Contributors: IBM Corporation - initial API and implementation
 **************************************************************************************************/
package com.ibm.ccl.soa.deploy.core.internal.datamodels;

import java.io.OutputStream;

import org.eclipse.core.resources.IFile;

import com.ibm.ccl.soa.deploy.core.TopologyExporter;
import com.ibm.ccl.soa.deploy.core.export.DeployExportLogger;

/**
 * Clients should not use the Properties interface directly, but instead should refer to the
 * type-safe API class {@link com.ibm.ccl.soa.deploy.core.datamodels.DeployTopologyExportDataModel}.
 * The properties interface is required by the Smart Datamodels Framework (SDF).
 * 
 * @see com.ibm.ccl.soa.deploy.core.datamodels.DeployTopologyExportDataModel
 * @generated (mde.utilities.datamodels)
 */
public interface IDeployTopologyExportDataModelProperties {

	/**
	 * 
	 * The destination location for the topology. This can be a folder location or a zip file, based
	 * on the export type supported by the exporter.
	 * 
	 * <p>
	 * <b>[Required]</b>
	 * </p>
	 * 
	 * <p>
	 * Type = {@link String}.
	 * </p>
	 * 
	 * @generated (mde.utilities.datamodels)
	 */
	String ARCHIVE_DESTINATION = "IDeployTopologyExportDataModelProperties.ARCHIVE_DESTINATION"; //$NON-NLS-1$

	/**
	 * 
	 * This boolean property drives if the existing archive file should be overwritten or not.
	 * 
	 * <p>
	 * <b>[Required]</b>
	 * </p>
	 * 
	 * <p>
	 * Type = {@link Boolean}.
	 * </p>
	 * 
	 * @generated (mde.utilities.datamodels)
	 */
	String OVERWRITE_EXISTING = "IDeployTopologyExportDataModelProperties.OVERWRITE_EXISTING"; //$NON-NLS-1$

	/**
	 * 
	 * This property drives the export of the source files along with the binary files.
	 * 
	 * <p>
	 * <b>[Required]</b>
	 * </p>
	 * 
	 * <p>
	 * Type = {@link Boolean}.
	 * </p>
	 * 
	 * @generated (mde.utilities.datamodels)
	 */
	String EXPORT_SOURCE_FILES = "IDeployTopologyExportDataModelProperties.EXPORT_SOURCE_FILES"; //$NON-NLS-1$

	/**
	 * 
	 * This property allows to continue the export process even if there are validation errors.
	 * 
	 * <p>
	 * <b>[Required]</b>
	 * </p>
	 * 
	 * <p>
	 * Type = {@link Boolean}.
	 * </p>
	 * 
	 * @generated (mde.utilities.datamodels)
	 */
	String EXPORT_WITH_ERROR = "IDeployTopologyExportDataModelProperties.EXPORT_WITH_ERROR"; //$NON-NLS-1$

	/**
	 * 
	 * This property is used to indicate if the topology being exported contains any validation
	 * error.
	 * 
	 * <p>
	 * <b>[Required]</b>
	 * </p>
	 * 
	 * <p>
	 * Type = {@link Boolean}.
	 * </p>
	 * 
	 * @generated (mde.utilities.datamodels)
	 */
	String TOPOLOGY_HAS_ERROR = "IDeployTopologyExportDataModelProperties.TOPOLOGY_HAS_ERROR"; //$NON-NLS-1$

	/**
	 * 
	 * The topology file to be exported. This property must be set as an IFile.
	 * 
	 * <p>
	 * <b>[Required]</b>
	 * </p>
	 * 
	 * <p>
	 * Type = {@link IFile}.
	 * </p>
	 * 
	 * @generated (mde.utilities.datamodels)
	 */
	String TOPOLOGY_FILE = "IDeployTopologyExportDataModelProperties.TOPOLOGY_FILE"; //$NON-NLS-1$	

	/**
	 * 
	 * The property provides the exporter class that is to be used for the topology export.
	 * 
	 * <p>
	 * <b>[Required]</b>
	 * </p>
	 * 
	 * <p>
	 * Type = {@link TopologyExporter}.
	 * </p>
	 * 
	 * @generated (mde.utilities.datamodels)
	 */
	String EXPORTER = "IDeployTopologyExportDataModelProperties.EXPORTER"; //$NON-NLS-1$	

	/**
	 * 
	 * This property provides the logger that is to be used to log the export errors.
	 * 
	 * <p>
	 * <b>[Required]</b>
	 * </p>
	 * 
	 * <p>
	 * Type = {@link DeployExportLogger}.
	 * </p>
	 * 
	 * @generated (mde.utilities.datamodels)
	 */
	String EXPORT_LOGGER = "IDeployTopologyExportDataModelProperties.EXPORT_LOGGER"; //$NON-NLS-1$	

	/**
	 * 
	 * Defines the Scribbler that should be used when executing the operation for the current
	 * Datamodel.
	 * 
	 * <p>
	 * <b>[Required]</b>
	 * </p>
	 * 
	 * <p>
	 * Type = {@link org.eclipse.wst.common.frameworks.datamodel.IDataModel}.
	 * </p>
	 * 
	 * @generated (mde.utilities.datamodels)
	 */
	String SCRIBBLER_DEFINITION_MODEL = "SCRIBBLER_DEFINITION_MODEL"; //$NON-NLS-1$	

	/**
	 * 
	 * This indicates when the exporter is exporting the imported topology contents.
	 * 
	 * <p>
	 * <b>[Required]</b>
	 * </p>
	 * 
	 * <p>
	 * Type = {@link Boolean}.
	 * </p>
	 * 
	 * @generated (mde.utilities.datamodels)
	 */
	String IMPORTED_TOPOLOGY_IN_USE = "IDeployTopologyExportDataModelProperties.IMPORTED_TOPOLOGY_IN_USE"; //$NON-NLS-1$	

	/**
	 * 
	 * This indicates whether to extract the location binding file for the topology.
	 * 
	 * <p>
	 * <b>[Required]</b>
	 * </p>
	 * 
	 * <p>
	 * Type = {@link Boolean}.
	 * </p>
	 * 
	 * @generated (mde.utilities.datamodels)
	 */
	String CREATE_LOCATION_BINDING = "IDeployTopologyExportDataModelProperties.CREATE_LOCATION_BINDING"; //$NON-NLS-1$

	/**
	 * 
	 * This is the exported project name.
	 * 
	 * <p>
	 * <b>[Required]</b>
	 * </p>
	 * 
	 * <p>
	 * Type = {@link String}.
	 * </p>
	 * 
	 * @generated (mde.utilities.datamodels)
	 */
	String EXPORT_PROJECT_NAME = "IDeployTopologyExportDataModelProperties.EXPORT_PROJECT_NAME"; //$NON-NLS-1$

	/**
	 * 
	 * This specifies whether to create the export project.
	 * 
	 * <p>
	 * <b>[Required]</b>
	 * </p>
	 * 
	 * <p>
	 * Type = {@link Boolean}.
	 * </p>
	 * 
	 * @generated (mde.utilities.datamodels)
	 */
	String CREATE_EXPORT_PROJECT = "IDeployTopologyExportDataModelProperties.CREATE_EXPORT_PROJECT"; //$NON-NLS-1$

	/**
	 * 
	 * This specifies whether to export the topology diagram file.
	 * 
	 * <p>
	 * <b>[Required]</b>
	 * </p>
	 * 
	 * <p>
	 * Type = {@link Boolean}.
	 * </p>
	 * 
	 * @generated (mde.utilities.datamodels)
	 */
	String EXPORT_DIAGRAM_RESOURCE_IF_PRESENT = "IDeployTopologyExportDataModelProperties.EXPORT_DIAGRAM_RESOURCE_IF_PRESENT"; //$NON-NLS-1$

	/**
	 * 
	 * The property provides for the export output to be used for exporting the contents to.
	 * 
	 * <p>
	 * <b>[Required]</b>
	 * </p>
	 * 
	 * <p>
	 * Type = {@link OutputStream}.
	 * </p>
	 * 
	 * @generated (mde.utilities.datamodels)
	 */
	String EXPORT_OUTPUT = "IDeployTopologyExportDataModelProperties.EXPORT_OUTPUT"; //$NON-NLS-1$	

	/**
	 * 
	 * The property provides for the export option to export the modules.
	 * 
	 * <p>
	 * <b>[Optional]</b>
	 * </p>
	 * 
	 * <p>
	 * Type = {@link Boolean}.
	 * </p>
	 */
	String EXPORT_MODULES = "IDeployTopologyExportDataModelProperties.EXPORT_MODULES"; //$NON-NLS-1$	
}
