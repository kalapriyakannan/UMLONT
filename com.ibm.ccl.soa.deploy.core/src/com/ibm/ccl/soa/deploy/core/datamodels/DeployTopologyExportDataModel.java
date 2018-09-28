/***************************************************************************************************
 * Copyright (c) 2003, 2007 IBM Corporation Licensed Material - Property of IBM. All rights
 * reserved.
 * 
 * US Government Users Restricted Rights - Use, duplication or disclosure v1.0 restricted by GSA ADP
 * Schedule Contract with IBM Corp.
 * 
 * Contributors: IBM Corporation - initial API and implementation
 **************************************************************************************************/
package com.ibm.ccl.soa.deploy.core.datamodels;

import java.io.OutputStream;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.wst.common.frameworks.datamodel.DataModelFactory;
import org.eclipse.wst.common.frameworks.datamodel.IDataModel;
import org.eclipse.wst.common.frameworks.datamodel.IDataModelOperation;
import org.eclipse.wst.common.frameworks.datamodel.IDataModelProvider;

import com.ibm.ccl.soa.deploy.core.TopologyExporter;
import com.ibm.ccl.soa.deploy.core.export.DeployExportLogger;
import com.ibm.ccl.soa.deploy.core.internal.datamodels.DeployTopologyExportDataModelOperation;
import com.ibm.ccl.soa.deploy.core.internal.datamodels.DeployTopologyExportDataModelProvider;
import com.ibm.ccl.soa.deploy.core.internal.datamodels.IDeployTopologyExportDataModelProperties;
import com.ibm.ccl.soa.infrastructure.emf.datamodels.ScribblerDefinitionDatamodel;

/**
 * 
 * This datamodel is used with the export of the topology.
 * 
 * <p>
 * The following properties are <b>required</b>. If not provided, then the model is not in a valid
 * state, and the operation will not be able to execute successfully.
 * </p>
 * <ul>
 * <li><b>topologyFile</b>: The topology file to be exported. This property must be set as an
 * IFile. </li>
 * <li><b>exporter</b>: The property provides the exporter class that is to be used for the
 * topology export. </li>
 * <li><b>exportLogger</b>: This property provides the logger that is to be used to log the export
 * errors. </li>
 * <li><b>exportOutput</b>: The property provides for the export output to be used for exporting
 * the contents to. </li>
 * <li><b>archiveDestination</b>: The destination location for the topology. This can be a folder
 * location or a zip file, based on the export type supported by the exporter. </li>
 * <li><b>overwriteExisting</b>: This boolean property drives if the existing archive file should
 * be overwritten or not. </li>
 * <li><b>exportSourceFiles</b>: This property drives the export of the source files along with
 * the binary files. </li>
 * <li><b>exportWithError</b>: This property allows to continue the export process even if there
 * are validation errors. </li>
 * <li><b>topologyHasError</b>: This property is used to indicate if the topology being exported
 * contains any validation error. </li>
 * <li><b>importedTopologyInUse</b>: This indicates when the exporter is exporting the imported
 * topology contents. </li>
 * <li><b>createLocationBinding</b>: This indicates whether to extract the location binding file
 * for the topology. </li>
 * <li><b>exportProjectName</b>: This is the exported project name. </li>
 * <li><b>createExportProject</b>: This specifies whether to create the export project. </li>
 * <li><b>exportDiagramResourceIfPresent</b>: This specifies whether to export the topology
 * diagram file. </li>
 * </ul>
 * 
 * <p>
 * The following <b>nested models</b> are used by this datamodel. Nested datamodels are used to
 * supplement the information collected by an enclosing datamodel or to execute nested operations
 * directly. The type-safe facade provides generates type-safe facades for each of the nested
 * datamodels, and provides the appropriate accessors and mutators.
 * </p>
 * <p>
 * Accessors (methods that begin with "get") will first check the facaded datamodel for an instance
 * of the nested datamodel, and if found, wrap it in a type-safe facade. Otherwise, the appropriate
 * datamodel will be created, wrapped, and returned.
 * </p>
 * <p>
 * Clients are not required to supply their own instances of nested models (as they are created when
 * accessors ("get") methods are called, but may access the
 * {@link #getUnderlyingDataModel() underlying datamodel} directly if they require advanced
 * customization.
 * </p>
 * <ul>
 * <li><b>scribblerDefinition</b> (Type:
 * {@link com.ibm.ccl.soa.infrastructure.emf.datamodels.ScribblerDefinitionDatamodel} ) : Defines
 * the Scribbler that should be used when executing the operation for the current Datamodel. </li>
 * </ul>
 * 
 * @generated (mde.utilities.datamodels)
 */
public class DeployTopologyExportDataModel {

	private final IDataModel model;
	private ScribblerDefinitionDatamodel scribblerDefinition;

	/**
	 * Creates and returns an instance of the type-safe API datamodel.
	 * 
	 * @return An instance of the type-safe API datamodel.
	 * @generated (mde.utilities.datamodels)
	 */
	public static DeployTopologyExportDataModel createModel() {
		IDataModel model = DataModelFactory.createDataModel(createDatamodelProvider());
		return new DeployTopologyExportDataModel(model);
	}

	/**
	 * Creates and returns an instance of the underlying provider for this facade.
	 * 
	 * <p>
	 * A provider implements the actual logic of a data model. All validation logic, calculation of
	 * default values, and management of property dependencies is handled by the provider.
	 * </p>
	 * 
	 * @return An instance of the underlying provider for this facade.
	 * @generated (mde.utilities.datamodels)
	 */
	public static IDataModelProvider createDatamodelProvider() {
		return new DeployTopologyExportDataModelProvider();
	}

	/**
	 * Create a type-safe facade for the given datamodel.
	 * 
	 * @param mdl
	 *           The datamodel to provide a facade for.
	 * @generated (mde.utilities.datamodels)
	 */
	public DeployTopologyExportDataModel(IDataModel mdl) {
		model = mdl;
	}

	/**
	 * The destination location for the topology. This can be a folder location or a zip file, based
	 * on the export type supported by the exporter.
	 * 
	 * <p>
	 * <b>[Required]</b>
	 * </p>
	 * 
	 * @param newArchiveDestination
	 *           The new value of the ArchiveDestination property.
	 * @generated (mde.utilities.datamodels)
	 */
	public void setArchiveDestination(String newArchiveDestination) {
		model.setProperty(IDeployTopologyExportDataModelProperties.ARCHIVE_DESTINATION,
				newArchiveDestination);
	}

	/**
	 * The destination location for the topology. This can be a folder location or a zip file, based
	 * on the export type supported by the exporter.
	 * 
	 * @return The value of the ArchiveDestination property.
	 * @generated (mde.utilities.datamodels)
	 */
	public String getArchiveDestination() {
		return (String) model
				.getProperty(IDeployTopologyExportDataModelProperties.ARCHIVE_DESTINATION);
	}

	/**
	 * Determine if the ArchiveDestination property meets all constraints required of it.
	 * 
	 * @return A status object indicating error or warning messages, if any, or OK if the
	 *         ArchiveDestination property is valid.
	 * @see #getArchiveDestination()
	 * @see #setArchiveDestination(String)
	 * @generated (mde.utilities.datamodels)
	 */
	public IStatus validateArchiveDestination() {
		return model.validateProperty(IDeployTopologyExportDataModelProperties.ARCHIVE_DESTINATION);
	}

	/**
	 * Determine the default value of the ArchiveDestination property.
	 * 
	 * @return The default value of the ArchiveDestination property.
	 * @see #getArchiveDestination()
	 * @see #setArchiveDestination(String)
	 * @generated (mde.utilities.datamodels)
	 */
	public String getDefaultArchiveDestination() {
		return (String) model
				.getDefaultProperty(IDeployTopologyExportDataModelProperties.ARCHIVE_DESTINATION);
	}

	/**
	 * This boolean property drives if the existing archive file should be overwritten or not.
	 * 
	 * <p>
	 * <b>[Required]</b>
	 * </p>
	 * 
	 * @param newOverwriteExisting
	 *           The new value of the OverwriteExisting property.
	 * @generated (mde.utilities.datamodels)
	 */
	public void setOverwriteExisting(Boolean newOverwriteExisting) {
		model.setProperty(IDeployTopologyExportDataModelProperties.OVERWRITE_EXISTING,
				newOverwriteExisting);
	}

	/**
	 * This boolean property drives if the existing archive file should be overwritten or not.
	 * 
	 * @return The value of the OverwriteExisting property.
	 * @generated (mde.utilities.datamodels)
	 */
	public Boolean getOverwriteExisting() {
		return (Boolean) model
				.getProperty(IDeployTopologyExportDataModelProperties.OVERWRITE_EXISTING);
	}

	/**
	 * Determine if the OverwriteExisting property meets all constraints required of it.
	 * 
	 * @return A status object indicating error or warning messages, if any, or OK if the
	 *         OverwriteExisting property is valid.
	 * @see #getOverwriteExisting()
	 * @see #setOverwriteExisting(Boolean)
	 * @generated (mde.utilities.datamodels)
	 */
	public IStatus validateOverwriteExisting() {
		return model.validateProperty(IDeployTopologyExportDataModelProperties.OVERWRITE_EXISTING);
	}

	/**
	 * Determine the default value of the OverwriteExisting property.
	 * 
	 * @return The default value of the OverwriteExisting property.
	 * @see #getOverwriteExisting()
	 * @see #setOverwriteExisting(Boolean)
	 * @generated (mde.utilities.datamodels)
	 */
	public Boolean getDefaultOverwriteExisting() {
		return (Boolean) model
				.getDefaultProperty(IDeployTopologyExportDataModelProperties.OVERWRITE_EXISTING);
	}

	/**
	 * This property drives the export of the source files along with the binary files.
	 * 
	 * <p>
	 * <b>[Required]</b>
	 * </p>
	 * 
	 * @param newExportSourceFiles
	 *           The new value of the ExportSourceFiles property.
	 * @generated (mde.utilities.datamodels)
	 */
	public void setExportSourceFiles(Boolean newExportSourceFiles) {
		model.setProperty(IDeployTopologyExportDataModelProperties.EXPORT_SOURCE_FILES,
				newExportSourceFiles);
	}

	/**
	 * This property drives the export of the source files along with the binary files.
	 * 
	 * @return The value of the ExportSourceFiles property.
	 * @generated (mde.utilities.datamodels)
	 */
	public Boolean getExportSourceFiles() {
		return (Boolean) model
				.getProperty(IDeployTopologyExportDataModelProperties.EXPORT_SOURCE_FILES);
	}

	/**
	 * Determine if the ExportSourceFiles property meets all constraints required of it.
	 * 
	 * @return A status object indicating error or warning messages, if any, or OK if the
	 *         ExportSourceFiles property is valid.
	 * @see #getExportSourceFiles()
	 * @see #setExportSourceFiles(Boolean)
	 * @generated (mde.utilities.datamodels)
	 */
	public IStatus validateExportSourceFiles() {
		return model.validateProperty(IDeployTopologyExportDataModelProperties.EXPORT_SOURCE_FILES);
	}

	/**
	 * Determine the default value of the ExportSourceFiles property.
	 * 
	 * @return The default value of the ExportSourceFiles property.
	 * @see #getExportSourceFiles()
	 * @see #setExportSourceFiles(Boolean)
	 * @generated (mde.utilities.datamodels)
	 */
	public Boolean getDefaultExportSourceFiles() {
		return (Boolean) model
				.getDefaultProperty(IDeployTopologyExportDataModelProperties.EXPORT_SOURCE_FILES);
	}

	/**
	 * This property allows to continue the export process even if there are validation errors.
	 * 
	 * <p>
	 * <b>[Required]</b>
	 * </p>
	 * 
	 * @param newExportWithError
	 *           The new value of the ExportWithError property.
	 * @generated (mde.utilities.datamodels)
	 */
	public void setExportWithError(Boolean newExportWithError) {
		model.setProperty(IDeployTopologyExportDataModelProperties.EXPORT_WITH_ERROR,
				newExportWithError);
	}

	/**
	 * This indicates when the exporter is exporting the imported topology contents.
	 * 
	 * <p>
	 * <b>[Required]</b>
	 * </p>
	 * 
	 * @param newImportedTopologyInUse
	 *           The new value of the ImportedTopologyInUse property.
	 * @generated (mde.utilities.datamodels)
	 */
	public void setImportedTopologyInUse(Boolean newImportedTopologyInUse) {
		model.setProperty(IDeployTopologyExportDataModelProperties.IMPORTED_TOPOLOGY_IN_USE,
				newImportedTopologyInUse);
	}

	/**
	 * This indicates when the exporter is exporting the imported topology contents.
	 * 
	 * @return The value of the ImportedTopologyInUse property.
	 * @generated (mde.utilities.datamodels)
	 */
	public Boolean getImportedTopologyInUse() {
		return (Boolean) model
				.getProperty(IDeployTopologyExportDataModelProperties.IMPORTED_TOPOLOGY_IN_USE);
	}

	/**
	 * This property allows to continue the export process even if there are validation errors.
	 * 
	 * @return The value of the ExportWithError property.
	 * @generated (mde.utilities.datamodels)
	 */
	public Boolean getExportWithError() {
		return (Boolean) model
				.getProperty(IDeployTopologyExportDataModelProperties.EXPORT_WITH_ERROR);
	}

	/**
	 * Determine if the ExportWithError property meets all constraints required of it.
	 * 
	 * @return A status object indicating error or warning messages, if any, or OK if the
	 *         ExportWithError property is valid.
	 * @see #getExportWithError()
	 * @see #setExportWithError(Boolean)
	 * @generated (mde.utilities.datamodels)
	 */
	public IStatus validateExportWithError() {
		return model.validateProperty(IDeployTopologyExportDataModelProperties.EXPORT_WITH_ERROR);
	}

	/**
	 * Determine if the ImportedTopologyInUse property meets all constraints required of it.
	 * 
	 * @return A status object indicating error or warning messages, if any, or OK if the
	 *         ImportedTopologyInUse property is valid.
	 * @see #getImportedTopologyInUse()
	 * @see #setImportedTopologyInUse(Boolean)
	 * @generated (mde.utilities.datamodels)
	 */
	public IStatus validateImportedTopologyInUse() {
		return model
				.validateProperty(IDeployTopologyExportDataModelProperties.IMPORTED_TOPOLOGY_IN_USE);
	}

	/**
	 * Determine the default value of the ImportedTopologyInUse property.
	 * 
	 * @return The default value of the ImportedTopologyInUse property.
	 * @see #getImportedTopologyInUse()
	 * @see #setImportedTopologyInUse(Boolean)
	 * @generated (mde.utilities.datamodels)
	 */
	public Boolean getDefaultImportedTopologyInUse() {
		return (Boolean) model
				.getDefaultProperty(IDeployTopologyExportDataModelProperties.IMPORTED_TOPOLOGY_IN_USE);
	}

	/**
	 * This indicates whether to extract the location binding file for the topology.
	 * 
	 * <p>
	 * <b>[Required]</b>
	 * </p>
	 * 
	 * @param newCreateLocationBinding
	 *           The new value of the CreateLocationBinding property.
	 * @generated (mde.utilities.datamodels)
	 */
	public void setCreateLocationBinding(Boolean newCreateLocationBinding) {
		model.setProperty(IDeployTopologyExportDataModelProperties.CREATE_LOCATION_BINDING,
				newCreateLocationBinding);
	}

	/**
	 * This indicates whether to extract the location binding file for the topology.
	 * 
	 * @return The value of the CreateLocationBinding property.
	 * @generated (mde.utilities.datamodels)
	 */
	public Boolean getCreateLocationBinding() {
		return (Boolean) model
				.getProperty(IDeployTopologyExportDataModelProperties.CREATE_LOCATION_BINDING);
	}

	/**
	 * Determine if the CreateLocationBinding property meets all constraints required of it.
	 * 
	 * @return A status object indicating error or warning messages, if any, or OK if the
	 *         CreateLocationBinding property is valid.
	 * @see #getCreateLocationBinding()
	 * @see #setCreateLocationBinding(Boolean)
	 * @generated (mde.utilities.datamodels)
	 */
	public IStatus validateCreateLocationBinding() {
		return model
				.validateProperty(IDeployTopologyExportDataModelProperties.CREATE_LOCATION_BINDING);
	}

	/**
	 * Determine the default value of the CreateLocationBinding property.
	 * 
	 * @return The default value of the CreateLocationBinding property.
	 * @see #getCreateLocationBinding()
	 * @see #setCreateLocationBinding(Boolean)
	 * @generated (mde.utilities.datamodels)
	 */
	public Boolean getDefaultCreateLocationBinding() {
		return (Boolean) model
				.getDefaultProperty(IDeployTopologyExportDataModelProperties.CREATE_LOCATION_BINDING);
	}

	/**
	 * This is the exported project name.
	 * 
	 * <p>
	 * <b>[Required]</b>
	 * </p>
	 * 
	 * @param newExportProjectName
	 *           The new value of the ExportProjectName property.
	 * @generated (mde.utilities.datamodels)
	 */
	public void setExportProjectName(String newExportProjectName) {
		model.setProperty(IDeployTopologyExportDataModelProperties.EXPORT_PROJECT_NAME,
				newExportProjectName);
	}

	/**
	 * This is the exported project name.
	 * 
	 * @return The value of the ExportProjectName property.
	 * @generated (mde.utilities.datamodels)
	 */
	public String getExportProjectName() {
		return (String) model
				.getProperty(IDeployTopologyExportDataModelProperties.EXPORT_PROJECT_NAME);
	}

	/**
	 * Determine if the ExportProjectName property meets all constraints required of it.
	 * 
	 * @return A status object indicating error or warning messages, if any, or OK if the
	 *         ExportProjectName property is valid.
	 * @see #getExportProjectName()
	 * @see #setExportProjectName(String)
	 * @generated (mde.utilities.datamodels)
	 */
	public IStatus validateExportProjectName() {
		return model.validateProperty(IDeployTopologyExportDataModelProperties.EXPORT_PROJECT_NAME);
	}

	/**
	 * Determine the default value of the ExportProjectName property.
	 * 
	 * @return The default value of the ExportProjectName property.
	 * @see #getExportProjectName()
	 * @see #setExportProjectName(String)
	 * @generated (mde.utilities.datamodels)
	 */
	public String getDefaultExportProjectName() {
		return (String) model
				.getDefaultProperty(IDeployTopologyExportDataModelProperties.EXPORT_PROJECT_NAME);
	}

	/**
	 * This specifies whether to create the export project.
	 * 
	 * <p>
	 * <b>[Required]</b>
	 * </p>
	 * 
	 * @param newCreateExportProject
	 *           The new value of the CreateExportProject property.
	 * @generated (mde.utilities.datamodels)
	 */
	public void setCreateExportProject(Boolean newCreateExportProject) {
		model.setProperty(IDeployTopologyExportDataModelProperties.CREATE_EXPORT_PROJECT,
				newCreateExportProject);
	}

	/**
	 * This specifies whether to create the export project.
	 * 
	 * @return The value of the CreateExportProject property.
	 * @generated (mde.utilities.datamodels)
	 */
	public Boolean getCreateExportProject() {
		return (Boolean) model
				.getProperty(IDeployTopologyExportDataModelProperties.CREATE_EXPORT_PROJECT);
	}

	/**
	 * Determine if the CreateExportProject property meets all constraints required of it.
	 * 
	 * @return A status object indicating error or warning messages, if any, or OK if the
	 *         CreateExportProject property is valid.
	 * @see #getCreateExportProject()
	 * @see #setCreateExportProject(Boolean)
	 * @generated (mde.utilities.datamodels)
	 */
	public IStatus validateCreateExportProject() {
		return model.validateProperty(IDeployTopologyExportDataModelProperties.CREATE_EXPORT_PROJECT);
	}

	/**
	 * Determine the default value of the CreateExportProject property.
	 * 
	 * @return The default value of the CreateExportProject property.
	 * @see #getCreateExportProject()
	 * @see #setCreateExportProject(Boolean)
	 * @generated (mde.utilities.datamodels)
	 */
	public Boolean getDefaultCreateExportProject() {
		return (Boolean) model
				.getDefaultProperty(IDeployTopologyExportDataModelProperties.CREATE_EXPORT_PROJECT);
	}

	/**
	 * This specifies whether to export the topology diagram file.
	 * 
	 * <p>
	 * <b>[Required]</b>
	 * </p>
	 * 
	 * @param newExportDiagramResourceIfPresent
	 *           The new value of the ExportDiagramResourceIfPresent property.
	 * @generated (mde.utilities.datamodels)
	 */
	public void setExportDiagramResourceIfPresent(Boolean newExportDiagramResourceIfPresent) {
		model.setProperty(
				IDeployTopologyExportDataModelProperties.EXPORT_DIAGRAM_RESOURCE_IF_PRESENT,
				newExportDiagramResourceIfPresent);
	}

	/**
	 * This specifies whether to export the topology diagram file.
	 * 
	 * @return The value of the ExportDiagramResourceIfPresent property.
	 * @generated (mde.utilities.datamodels)
	 */
	public Boolean getExportDiagramResourceIfPresent() {
		return (Boolean) model
				.getProperty(IDeployTopologyExportDataModelProperties.EXPORT_DIAGRAM_RESOURCE_IF_PRESENT);
	}

	/**
	 * Determine if the ExportDiagramResourceIfPresent property meets all constraints required of it.
	 * 
	 * @return A status object indicating error or warning messages, if any, or OK if the
	 *         ExportDiagramResourceIfPresent property is valid.
	 * @see #getExportDiagramResourceIfPresent()
	 * @see #setExportDiagramResourceIfPresent(Boolean)
	 * @generated (mde.utilities.datamodels)
	 */
	public IStatus validateExportDiagramResourceIfPresent() {
		return model
				.validateProperty(IDeployTopologyExportDataModelProperties.EXPORT_DIAGRAM_RESOURCE_IF_PRESENT);
	}

	/**
	 * Determine the default value of the ExportDiagramResourceIfPresent property.
	 * 
	 * @return The default value of the ExportDiagramResourceIfPresent property.
	 * @see #getExportDiagramResourceIfPresent()
	 * @see #setExportDiagramResourceIfPresent(Boolean)
	 * @generated (mde.utilities.datamodels)
	 */
	public Boolean getDefaultExportDiagramResourceIfPresent() {
		return (Boolean) model
				.getDefaultProperty(IDeployTopologyExportDataModelProperties.EXPORT_DIAGRAM_RESOURCE_IF_PRESENT);
	}

	/**
	 * Determine the default value of the ExportWithError property.
	 * 
	 * @return The default value of the ExportWithError property.
	 * @see #getExportWithError()
	 * @see #setExportWithError(Boolean)
	 * @generated (mde.utilities.datamodels)
	 */
	public Boolean getDefaultExportWithError() {
		return (Boolean) model
				.getDefaultProperty(IDeployTopologyExportDataModelProperties.EXPORT_WITH_ERROR);
	}

	/**
	 * This property is used to indicate if the topology being exported contains any validation
	 * error.
	 * 
	 * <p>
	 * <b>[Required]</b>
	 * </p>
	 * 
	 * @param newTopologyHasError
	 *           The new value of the TopologyHasError property.
	 * @generated (mde.utilities.datamodels)
	 */
	public void setTopologyHasError(Boolean newTopologyHasError) {
		model.setProperty(IDeployTopologyExportDataModelProperties.TOPOLOGY_HAS_ERROR,
				newTopologyHasError);
	}

	/**
	 * This property is used to indicate if the topology being exported contains any validation
	 * error.
	 * 
	 * @return The value of the TopologyHasError property.
	 * @generated (mde.utilities.datamodels)
	 */
	public Boolean getTopologyHasError() {
		return (Boolean) model
				.getProperty(IDeployTopologyExportDataModelProperties.TOPOLOGY_HAS_ERROR);
	}

	/**
	 * Determine if the TopologyHasError property meets all constraints required of it.
	 * 
	 * @return A status object indicating error or warning messages, if any, or OK if the
	 *         TopologyHasError property is valid.
	 * @see #getTopologyHasError()
	 * @see #setTopologyHasError(Boolean)
	 * @generated (mde.utilities.datamodels)
	 */
	public IStatus validateTopologyHasError() {
		return model.validateProperty(IDeployTopologyExportDataModelProperties.TOPOLOGY_HAS_ERROR);
	}

	/**
	 * Determine if the ExportModules property meets all constraints required of it.
	 * 
	 * @return The option to export the modules of the topology.
	 * @see #getExportModules()
	 * @see #setExportModules(Boolean)
	 * @generated (mde.utilities.datamodels)
	 */
	public IStatus validateExportModules() {
		return model.validateProperty(IDeployTopologyExportDataModelProperties.EXPORT_MODULES);
	}

	/**
	 * Determine the default value of the TopologyHasError property.
	 * 
	 * @return The default value of the TopologyHasError property.
	 * @see #getTopologyHasError()
	 * @see #setTopologyHasError(Boolean)
	 * @generated (mde.utilities.datamodels)
	 */
	public Boolean getDefaultTopologyHasError() {
		return (Boolean) model
				.getDefaultProperty(IDeployTopologyExportDataModelProperties.TOPOLOGY_HAS_ERROR);
	}

	/**
	 * Determine the default value of the ExportModules property.
	 * 
	 * @return The default value of the ExportModules property.
	 * @see #getExportModules()
	 * @see #setExportModules(Boolean)
	 * @generated (mde.utilities.datamodels)
	 */
	public Boolean getDefaultExportModules() {
		return (Boolean) model
				.getDefaultProperty(IDeployTopologyExportDataModelProperties.EXPORT_MODULES);
	}

	/**
	 * Return the value of TopologyFile field.
	 * 
	 * @return The value of TopologyFile field.
	 * @generated (mde.utilities.datamodels)
	 */
	public IFile getTopologyFile() {
		return (IFile) model.getProperty(IDeployTopologyExportDataModelProperties.TOPOLOGY_FILE);
	}

	/**
	 * The topology file to be exported. This property must be set as an IFile.
	 * 
	 * <p>
	 * <b>[Required]</b>
	 * </p>
	 * 
	 * @param newTopologyFile
	 *           The new value for the reference.
	 * @generated (mde.utilities.datamodels)
	 */
	public void setTopologyFile(IFile newTopologyFile) {
		model.setProperty(IDeployTopologyExportDataModelProperties.TOPOLOGY_FILE, newTopologyFile);
	}

	/**
	 * Determine if the TopologyFile property meets all constraints required of it.
	 * 
	 * @return A status object indicating error or warning messages, if any, or OK if the
	 *         TopologyFile property is valid.
	 * @see #getTopologyFile()
	 * @see #setTopologyFile(IFile)
	 * @generated (mde.utilities.datamodels)
	 */
	public IStatus validateTopologyFile() {
		return model.validateProperty(IDeployTopologyExportDataModelProperties.TOPOLOGY_FILE);

	}

	/**
	 * Determine the default value of the TopologyFile property.
	 * 
	 * @return The default value of the TopologyFile property.
	 * @see #getTopologyFile()
	 * @see #setTopologyFile(IFile)
	 * @generated (mde.utilities.datamodels)
	 */
	protected IFile getDefaultTopologyFile() {
		return (IFile) model
				.getDefaultProperty(IDeployTopologyExportDataModelProperties.TOPOLOGY_FILE);
	}

	/**
	 * Return the value of Exporter field.
	 * 
	 * @return The value of Exporter field.
	 * @generated (mde.utilities.datamodels)
	 */
	public TopologyExporter getExporter() {
		return (TopologyExporter) model
				.getProperty(IDeployTopologyExportDataModelProperties.EXPORTER);
	}

	/**
	 * The property provides the exporter class that is to be used for the topology export.
	 * 
	 * <p>
	 * <b>[Required]</b>
	 * </p>
	 * 
	 * @param newExporter
	 *           The new value for the reference.
	 * @generated (mde.utilities.datamodels)
	 */
	public void setExporter(TopologyExporter newExporter) {
		model.setProperty(IDeployTopologyExportDataModelProperties.EXPORTER, newExporter);
	}

	/**
	 * Determine if the Exporter property meets all constraints required of it.
	 * 
	 * @return A status object indicating error or warning messages, if any, or OK if the Exporter
	 *         property is valid.
	 * @see #getExporter()
	 * @see #setExporter(TopologyExporter)
	 * @generated (mde.utilities.datamodels)
	 */
	public IStatus validateExporter() {
		return model.validateProperty(IDeployTopologyExportDataModelProperties.EXPORTER);

	}

	/**
	 * Determine if the ExportOutput property meets all constraints required of it.
	 * 
	 * @return A status object indicating error or warning messages, if any, or OK if the
	 *         ExportOutput property is valid.
	 * @see #getExportOutput()
	 * @see #setExportOutput(OutputStream)
	 * @generated (mde.utilities.datamodels)
	 */
	public IStatus validateExportOutput() {
		return model.validateProperty(IDeployTopologyExportDataModelProperties.EXPORT_OUTPUT);

	}

	/**
	 * Determine the default value of the ExportOutput property.
	 * 
	 * @return The default value of the ExportOutput property.
	 * @see #getExportOutput()
	 * @see #setExportOutput(OutputStream)
	 * @generated (mde.utilities.datamodels)
	 */
	protected OutputStream getDefaultExportOutput() {
		return (OutputStream) model
				.getDefaultProperty(IDeployTopologyExportDataModelProperties.EXPORT_OUTPUT);
	}

	/**
	 * Determine the default value of the Exporter property.
	 * 
	 * @return The default value of the Exporter property.
	 * @see #getExporter()
	 * @see #setExporter(TopologyExporter)
	 * @generated (mde.utilities.datamodels)
	 */
	protected TopologyExporter getDefaultExporter() {
		return (TopologyExporter) model
				.getDefaultProperty(IDeployTopologyExportDataModelProperties.EXPORTER);
	}

	/**
	 * Return the value of ExportLogger field.
	 * 
	 * @return The value of ExportLogger field.
	 * @generated (mde.utilities.datamodels)
	 */
	public DeployExportLogger getExportLogger() {
		return (DeployExportLogger) model
				.getProperty(IDeployTopologyExportDataModelProperties.EXPORT_LOGGER);
	}

	/**
	 * Return the value of ExportOutput field.
	 * 
	 * @return The value of ExportOutput field.
	 * @generated (mde.utilities.datamodels)
	 */
	public OutputStream getExportOutput() {
		return (OutputStream) model
				.getProperty(IDeployTopologyExportDataModelProperties.EXPORT_OUTPUT);
	}

	/**
	 * This property provides the logger that is to be used to log the export errors.
	 * 
	 * <p>
	 * <b>[Required]</b>
	 * </p>
	 * 
	 * @param newExportLogger
	 *           The new value for the reference.
	 * @generated (mde.utilities.datamodels)
	 */
	public void setExportLogger(DeployExportLogger newExportLogger) {
		model.setProperty(IDeployTopologyExportDataModelProperties.EXPORT_LOGGER, newExportLogger);
	}

	/**
	 * The property provides for the export output to be used for exporting the contents to.
	 * 
	 * <p>
	 * <b>[Required]</b>
	 * </p>
	 * 
	 * @param newExportOutput
	 *           The new value for the reference.
	 * @generated (mde.utilities.datamodels)
	 */
	public void setExportOutput(OutputStream newExportOutput) {
		model.setProperty(IDeployTopologyExportDataModelProperties.EXPORT_OUTPUT, newExportOutput);
	}

	/**
	 * Determine if the ExportLogger property meets all constraints required of it.
	 * 
	 * @return A status object indicating error or warning messages, if any, or OK if the
	 *         ExportLogger property is valid.
	 * @see #getExportLogger()
	 * @see #setExportLogger(DeployExportLogger)
	 * @generated (mde.utilities.datamodels)
	 */
	public IStatus validateExportLogger() {
		return model.validateProperty(IDeployTopologyExportDataModelProperties.EXPORT_LOGGER);

	}

	/**
	 * Determine the default value of the ExportLogger property.
	 * 
	 * @return The default value of the ExportLogger property.
	 * @see #getExportLogger()
	 * @see #setExportLogger(DeployExportLogger)
	 * @generated (mde.utilities.datamodels)
	 */
	protected DeployExportLogger getDefaultExportLogger() {
		return (DeployExportLogger) model
				.getDefaultProperty(IDeployTopologyExportDataModelProperties.EXPORT_LOGGER);
	}

	/**
	 * Defines the Scribbler that should be used when executing the operation for the current
	 * Datamodel.
	 * 
	 * <p>
	 * Return the type-safe model for the nested ScribblerDefinition data model.
	 * </p>
	 * 
	 * <p>
	 * <b>[Required]</b>
	 * </p>
	 * 
	 * @return The type-safe model for the nested ScribblerDefinition data model.
	 * @generated (mde.utilities.datamodels)
	 */
	public ScribblerDefinitionDatamodel getScribblerDefinition() {
		if (scribblerDefinition == null) {
			if (model
					.isNestedModel(IDeployTopologyExportDataModelProperties.SCRIBBLER_DEFINITION_MODEL)) {
				IDataModel nestedModel = model
						.getNestedModel(IDeployTopologyExportDataModelProperties.SCRIBBLER_DEFINITION_MODEL);
				scribblerDefinition = new ScribblerDefinitionDatamodel(nestedModel);
			} else {
				scribblerDefinition = ScribblerDefinitionDatamodel.createModel();
				model.addNestedModel(
						IDeployTopologyExportDataModelProperties.SCRIBBLER_DEFINITION_MODEL,
						scribblerDefinition.getUnderlyingDataModel());
			}
		}
		return scribblerDefinition;

	}

	/**
	 * Determine if the ScribblerDefinition property meets all constraints required of it.
	 * 
	 * @return A status object indicating error or warning messages, if any, or OK if the
	 *         ScribblerDefinition property is valid.
	 * @see #getScribblerDefinition()
	 * 
	 * @generated (mde.utilities.datamodels)
	 */
	public IStatus validateScribblerDefinition() {
		return getScribblerDefinition().validate();

	}

	/**
	 * Determine the default value of the ScribblerDefinition property.
	 * 
	 * @return The default value of the ScribblerDefinition property.
	 * @see #getScribblerDefinition()
	 * 
	 * @generated (mde.utilities.datamodels)
	 */
	protected ScribblerDefinitionDatamodel getDefaultScribblerDefinition() {
		return (ScribblerDefinitionDatamodel) model
				.getDefaultProperty(IDeployTopologyExportDataModelProperties.SCRIBBLER_DEFINITION_MODEL);
	}

	/**
	 * Create and return an operation that is configured with the values from this datamodel.
	 * 
	 * @return A ready-to-run operation prepared with this model to carry out the operation.
	 * @generated (mde.utilities.datamodels)
	 */
	public IDataModelOperation createConfiguredOperation() {
		DeployTopologyExportDataModelOperation operation = new DeployTopologyExportDataModelOperation(
				this);
		return operation;
	}

	/**
	 * The underlying datamodel that backs this facade.
	 * 
	 * @return The underlying datamodel that backs this facade.
	 */
	public final IDataModel getUnderlyingDataModel() {
		return model;
	}

	/**
	 * Validates all properties associated with this type-safe data model.
	 * 
	 * @return The collective status of all properties associated with the underlying datamodel.
	 * @see org.eclipse.wst.common.frameworks.datamodel.IDataModelProvider#validate(String)
	 * @generated (mde.utilities.datamodels)
	 */
	public IStatus validate() {
		return model.validate(false);
	}

	/**
	 * The property provides for the export option to export the modules.
	 * 
	 * @return The property provides for the export option to export the modules.
	 * @generated (mde.utilities.datamodels)
	 */
	public Boolean getExportModules() {
		return (Boolean) model.getProperty(IDeployTopologyExportDataModelProperties.EXPORT_MODULES);
	}

	/**
	 * The property provides for the export option to export the modules.
	 * 
	 * @return The property provides for the export option to export the modules.
	 * @generated (mde.utilities.datamodels)
	 */
	public void setExportModules(boolean exportModules) {
		model.setProperty(IDeployTopologyExportDataModelProperties.EXPORT_MODULES, exportModules);
	}
}
