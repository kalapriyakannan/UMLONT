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
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.resources.IWorkspace;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.Assert;
import org.eclipse.core.runtime.IPath;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Path;
import org.eclipse.core.runtime.Status;
import org.eclipse.wst.common.frameworks.datamodel.AbstractDataModelProvider;
import org.eclipse.wst.common.frameworks.datamodel.IDataModel;
import org.eclipse.wst.common.frameworks.datamodel.IDataModelOperation;

import com.ibm.ccl.soa.deploy.core.DeployCorePlugin;
import com.ibm.ccl.soa.deploy.core.DeploymentTopologyDomain;
import com.ibm.ccl.soa.deploy.core.TopologyExporter;
import com.ibm.ccl.soa.deploy.core.datamodels.DeployTopologyExportDataModel;
import com.ibm.ccl.soa.deploy.core.export.DeployExportLogger;
import com.ibm.ccl.soa.deploy.internal.core.DeployCoreMessages;
import com.ibm.ccl.soa.deploy.internal.core.extension.TopologyExporterDescriptor;
import com.ibm.ccl.soa.deploy.internal.core.extension.TopologyManager;
import com.ibm.ccl.soa.infrastructure.emf.datamodels.ScribblerDefinitionDatamodel;

/**
 * Clients should not use the provider directly, but instead should refer to the type-safe API class
 * {@link com.ibm.ccl.soa.deploy.core.datamodels.DeployTopologyExportDataModel}. The provider is
 * required by the Smart Datamodels Framework (SDF).
 * 
 * @see com.ibm.ccl.soa.deploy.core.datamodels.DeployTopologyExportDataModel
 * @generated (mde.utilities.datamodels)
 */
public class DeployTopologyExportDataModelProvider extends AbstractDataModelProvider implements
		IDeployTopologyExportDataModelProperties {

	/*
	 * (non-Javadoc)
	 * 
	 * @see IDeployTopologyExportDataModelProperties#ARCHIVE_DESTINATION
	 */
	public IStatus validateArchiveDestination() {
		Assert
				.isTrue(model.getProperty(IDeployTopologyExportDataModelProperties.ARCHIVE_DESTINATION) instanceof String);
		String archiveDestinationProperty = (String) model
				.getProperty(IDeployTopologyExportDataModelProperties.ARCHIVE_DESTINATION);
		boolean isValid = archiveDestinationProperty != null
				&& archiveDestinationProperty.length() > 0 ? true : false;
		if (isValid) {
			isValid = archiveDestinationProperty.charAt(0) == ':' ? false : true;
		}
		if (isValid) {
			IPath path = new Path(archiveDestinationProperty);
			String fileName = path.segment(path.segmentCount() - 1);
			IWorkspace workspace = ResourcesPlugin.getWorkspace();
			IStatus result = workspace.validateName(fileName, IResource.FILE);
			if (!result.isOK()) {
				return new Status(IStatus.ERROR, DeployCorePlugin.PLUGIN_ID, 0, result.getMessage(),
						null);
			}
			/*
			 * if (path.segmentCount() > 1) { IPath newPath = path.removeLastSegments(1);
			 * newPath.setDevice(""); //$NON-NLS-1$ result =
			 * workspace.validatePath(newPath.toOSString(), IResource.FOLDER); if (!result.isOK()) {
			 * return new Status(IStatus.ERROR, DeployCorePlugin.PLUGIN_ID, 0, result.getMessage(),
			 * null); } }
			 */
		}
		if (!isValid) {
			return new Status(IStatus.ERROR, DeployCorePlugin.PLUGIN_ID, 0,
					DeployCoreMessages.DEPLOYMENTTOPOLOGYEXPORT_DESTINATION_INVALID, null);
		}
		return Status.OK_STATUS;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see IDeployTopologyExportDataModelProperties#ARCHIVE_DESTINATION
	 */
	protected String getDefaultArchiveDestination() {
		IFile topologyFile = (IFile) model
				.getProperty(IDeployTopologyExportDataModelProperties.TOPOLOGY_FILE);
		if (topologyFile != null) {
			String topologyName = DeploymentTopologyDomain.getTopologyName(topologyFile);
			return topologyName + ".zip"; //$NON-NLS-1$
		}
		return null;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see IDeployTopologyExportDataModelProperties#OVERWRITE_EXISTING
	 */
	public IStatus validateOverwriteExisting() {
		Assert
				.isTrue(model.getProperty(IDeployTopologyExportDataModelProperties.OVERWRITE_EXISTING) instanceof Boolean);
		//Boolean overwriteExistingProperty = (Boolean)  model.getProperty(IDeployTopologyExportDataModelProperties.OVERWRITE_EXISTING);

		// TODO Validate the OverwriteExisting property.
		return Status.OK_STATUS;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see IDeployTopologyExportDataModelProperties#OVERWRITE_EXISTING
	 */
	protected Boolean getDefaultOverwriteExisting() {
		// TODO Return the default value of the OverwriteExisting property.
		return new Boolean(false);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see IDeployTopologyExportDataModelProperties#EXPORT_SOURCE_FILES
	 */
	public IStatus validateExportSourceFiles() {
		Assert
				.isTrue(model.getProperty(IDeployTopologyExportDataModelProperties.EXPORT_SOURCE_FILES) instanceof Boolean);
		//Boolean exportSourceFilesProperty = (Boolean)  model.getProperty(IDeployTopologyExportDataModelProperties.EXPORT_SOURCE_FILES);

		// TODO Validate the ExportSourceFiles property.
		return Status.OK_STATUS;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see IDeployTopologyExportDataModelProperties#EXPORT_SOURCE_FILES
	 */
	protected Boolean getDefaultExportSourceFiles() {
		// TODO Return the default value of the ExportSourceFiles property.
		return new Boolean(false);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see IDeployTopologyExportDataModelProperties#IMPORTED_TOPOLOGY_IN_USE
	 */
	public IStatus validateImportedTopologyInUse() {
		Assert
				.isTrue(model
						.getProperty(IDeployTopologyExportDataModelProperties.IMPORTED_TOPOLOGY_IN_USE) instanceof Boolean);
		// TODO Validate the ImportedTopologyInUse property.
		return Status.OK_STATUS;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see IDeployTopologyExportDataModelProperties#IMPORTED_TOPOLOGY_IN_USE
	 */
	protected Boolean getDefaultImportedTopologyInUse() {
		// TODO Return the default value of the ImportTopologyInUse property.
		return new Boolean(false);
	}

	/**
	 * 
	 * @return A status of OK or an error status indicating some underlying problem with the data.
	 * @see IDeployTopologyExportDataModelProperties#CREATE_LOCATION_BINDING
	 * @generated (mde.utilities.datamodels)
	 */
	public IStatus validateCreateLocationBinding() {
		// TODO Remove the @generated tag above and validate the property.

		Assert
				.isTrue(model
						.getProperty(IDeployTopologyExportDataModelProperties.CREATE_LOCATION_BINDING) instanceof Boolean);
		//Boolean createLocationBindingProperty = (Boolean)  model.getProperty(IDeployTopologyExportDataModelProperties.CREATE_LOCATION_BINDING);		

		return Status.OK_STATUS;
	}

	/**
	 * 
	 * @return The default value of the CreateLocationBinding property.
	 * @see IDeployTopologyExportDataModelProperties#CREATE_LOCATION_BINDING
	 * @see DeployTopologyExportDataModel#getCreateLocationBinding()
	 */
	protected Boolean getDefaultCreateLocationBinding() {
		return new Boolean(true);
	}

	/**
	 * 
	 * @return A status of OK or an error status indicating some underlying problem with the data.
	 * @see IDeployTopologyExportDataModelProperties#EXPORT_PROJECT_NAME
	 * @generated (mde.utilities.datamodels)
	 */
	public IStatus validateExportProjectName() {
		// TODO Remove the @generated tag above and validate the property.

		Assert
				.isTrue(model.getProperty(IDeployTopologyExportDataModelProperties.EXPORT_PROJECT_NAME) instanceof String);
		//String exportProjectNameProperty = (String)  model.getProperty(IDeployTopologyExportDataModelProperties.EXPORT_PROJECT_NAME);		

		return Status.OK_STATUS;
	}

	/**
	 * 
	 * @return A status of OK or an error status indicating some underlying problem with the data.
	 * @see IDeployTopologyExportDataModelProperties#EXPORT_MODULES
	 * @generated (mde.utilities.datamodels)
	 */
	public IStatus validateExportModules() {
		// TODO Remove the @generated tag above and validate the property.

		Assert
				.isTrue(model.getProperty(IDeployTopologyExportDataModelProperties.EXPORT_MODULES) instanceof Boolean);
		//Boolean exportModulesProperty = (String)  model.getProperty(IDeployTopologyExportDataModelProperties.EXPORT_MODULES);		

		return Status.OK_STATUS;
	}

	/**
	 * 
	 * @return The default value of the ExportProjectName property.
	 * @see IDeployTopologyExportDataModelProperties#EXPORT_PROJECT_NAME
	 * @see DeployTopologyExportDataModel#getExportProjectName()
	 * @generated (mde.utilities.datamodels)
	 */
	protected String getDefaultExportProjectName() {
		return "Export"; //$NON-NLS-1$ 
	}

	/**
	 * 
	 * @return A status of OK or an error status indicating some underlying problem with the data.
	 * @see IDeployTopologyExportDataModelProperties#CREATE_EXPORT_PROJECT
	 * @generated (mde.utilities.datamodels)
	 */
	public IStatus validateCreateExportProject() {
		// TODO Remove the @generated tag above and validate the property.

		Assert
				.isTrue(model
						.getProperty(IDeployTopologyExportDataModelProperties.CREATE_EXPORT_PROJECT) instanceof Boolean);
		//Boolean createExportProjectProperty = (Boolean)  model.getProperty(IDeployTopologyExportDataModelProperties.CREATE_EXPORT_PROJECT);		

		return Status.OK_STATUS;
	}

	/**
	 * 
	 * @return The default value of the CreateExportProject property.
	 * @see IDeployTopologyExportDataModelProperties#CREATE_EXPORT_PROJECT
	 * @see DeployTopologyExportDataModel#getCreateExportProject()
	 */
	protected Boolean getDefaultCreateExportProject() {
		return new Boolean(false);
	}

	/**
	 * 
	 * @return A status of OK or an error status indicating some underlying problem with the data.
	 * @see IDeployTopologyExportDataModelProperties#EXPORT_DIAGRAM_RESOURCE_IF_PRESENT
	 * @generated (mde.utilities.datamodels)
	 */
	public IStatus validateExportDiagramResourceIfPresent() {
		// TODO Remove the @generated tag above and validate the property.

		Assert
				.isTrue(model
						.getProperty(IDeployTopologyExportDataModelProperties.EXPORT_DIAGRAM_RESOURCE_IF_PRESENT) instanceof Boolean);
		//Boolean exportDiagramResourceIfPresentProperty = (Boolean)  model.getProperty(IDeployTopologyExportDataModelProperties.EXPORT_DIAGRAM_RESOURCE_IF_PRESENT);		

		return Status.OK_STATUS;
	}

	/**
	 * 
	 * @return The default value of the ExportDiagramResourceIfPresent property.
	 * @see IDeployTopologyExportDataModelProperties#EXPORT_DIAGRAM_RESOURCE_IF_PRESENT
	 * @see DeployTopologyExportDataModel#getExportDiagramResourceIfPresent()
	 */
	protected Boolean getDefaultExportDiagramResourceIfPresent() {
		return new Boolean(true);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see IDeployTopologyExportDataModelProperties#EXPORT_WITH_ERROR
	 */
	public IStatus validateExportWithError() {
		Assert
				.isTrue(model.getProperty(IDeployTopologyExportDataModelProperties.EXPORT_WITH_ERROR) instanceof Boolean);
		boolean exportWithErrors = model
				.getBooleanProperty(IDeployTopologyExportDataModelProperties.EXPORT_WITH_ERROR);
		if (!exportWithErrors) {
			IFile topologyFile = (IFile) model.getProperty(TOPOLOGY_FILE);
			if (topologyFile != null) {
				/*
				 * Topology top = TopologyUIUtil.getTopology(topologyFile); // validate the topology
				 * if(model.getProperty(IDeployTopologyExportDataModelProperties.TOPOLOGY_HAS_ERROR)==null){
				 * DeployValidatorService validator = DeployValidatorService
				 * .getOrCreateValidatorService(DeployCoreEditor.VALIDATOR_SERVICE);
				 * validator.validate(top);
				 * model.setBooleanProperty(IDeployTopologyExportDataModelProperties.TOPOLOGY_HAS_ERROR,
				 * TopologyUIUtil.hasError(top)); } if
				 * (model.getBooleanProperty(IDeployTopologyExportDataModelProperties.TOPOLOGY_HAS_ERROR)) {
				 * return new Status( IStatus.ERROR, DeployCorePlugin.PLUGIN_ID, 0,
				 * DeployCoreMessages.DEPLOYMENTTOPOLOGYEXPORT_TOPOLOGY_HAS_VALIDATION_ERRORS, null); } //
				 * delegate validation to exporter TopologyExporter exporter = (TopologyExporter)
				 * getDataModel() .getProperty( IDeployTopologyExportDataModelProperties.EXPORTER);
				 * IStatus status = exporter.validate(top); if(status != null && !status.isOK()){ return
				 * status; }
				 */

			}
		}
		return Status.OK_STATUS;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see IDeployTopologyExportDataModelProperties#EXPORT_WITH_ERROR
	 */
	protected Boolean getDefaultExportWithError() {
		// TODO Return the default value of the ExportWithError property.
		return new Boolean(false);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see IDeployTopologyExportDataModelProperties#TOPOLOGY_HAS_ERROR
	 */
	public IStatus validateTopologyHasError() {
		Assert
				.isTrue(model.getProperty(IDeployTopologyExportDataModelProperties.TOPOLOGY_HAS_ERROR) instanceof Boolean);
		//Boolean topologyHasErrorProperty = (Boolean)  model.getProperty(IDeployTopologyExportDataModelProperties.TOPOLOGY_HAS_ERROR);

		// TODO Validate the TopologyHasError property.
		return Status.OK_STATUS;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see IDeployTopologyExportDataModelProperties#TOPOLOGY_HAS_ERROR
	 */
	protected Boolean getDefaultTopologyHasError() {
		// TODO Return the default value of the TopologyHasError property.
		return new Boolean(false);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see IDeployTopologyExportDataModelProperties#EXPORT_MODULES
	 */
	protected Boolean getDefaultExportModules() {
		// TODO Return the default value of the ExportModules property.
		return new Boolean(true);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see IDeployTopologyExportDataModelProperties#TOPOLOGY_FILE
	 */
	public IStatus validateTopologyFile() {
		Assert
				.isTrue(model.getProperty(IDeployTopologyExportDataModelProperties.TOPOLOGY_FILE) instanceof IFile);

		IFile topologyFileProperty = (IFile) model
				.getProperty(IDeployTopologyExportDataModelProperties.TOPOLOGY_FILE);

		if (topologyFileProperty == null) {
			return new Status(IStatus.ERROR, DeployCorePlugin.PLUGIN_ID, 0,
					DeployCoreMessages.DEPLOYMENTTOPOLOGYEXPORT_TOPOLOGY_UNDEFINED, null);
		}
		return Status.OK_STATUS;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see IDeployTopologyExportDataModelProperties#TOPOLOGY_FILE
	 */
	protected IFile getDefaultTopologyFile() {
		// TODO Return the default value of the TopologyFile property.
		return null;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see IDeployTopologyExportDataModelProperties#EXPORTER
	 */
	public IStatus validateExporter() {
		Assert
				.isTrue(model.getProperty(IDeployTopologyExportDataModelProperties.EXPORTER) == null
						|| model.getProperty(IDeployTopologyExportDataModelProperties.EXPORTER) instanceof TopologyExporter);

		TopologyExporter exporterProperty = (TopologyExporter) model
				.getProperty(IDeployTopologyExportDataModelProperties.EXPORTER);

		if (exporterProperty == null) {
			return new Status(IStatus.ERROR, DeployCorePlugin.PLUGIN_ID, 0,
					DeployCoreMessages.DEPLOYMENTTOPOLOGYEXPORT_EXPORTER_UNDEFINED, null);
		}
		return Status.OK_STATUS;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see IDeployTopologyExportDataModelProperties#EXPORTER
	 */
	protected TopologyExporter getDefaultExporter() {
		TopologyExporterDescriptor[] exporters = TopologyManager.getInstance()
				.findAvailableExporters(null);
		if (exporters.length > 0) {
			return exporters[0].createTopologyExporter();
		}
		return null;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see IDeployTopologyExportDataModelProperties#EXPORTER
	 */
	public IStatus validateExportOutput() {
		/*
		 * Assert.isTrue(model.getProperty(IDeployTopologyExportDataModelProperties.EXPORT_OUTPUT)
		 * instanceof OutputStream);
		 * 
		 * TopologyExporter exporterProperty = (TopologyExporter)
		 * model.getProperty(IDeployTopologyExportDataModelProperties.EXPORT_OUTPUT);
		 * 
		 * if (exporterProperty == null) { return new Status(IStatus.ERROR,DeployCorePlugin.PLUGIN_ID,
		 * 0, DeployCoreMessages.DEPLOYMENTTOPOLOGYEXPORT_EXPORTER_UNDEFINED,null); }
		 */
		return Status.OK_STATUS;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see IDeployTopologyExportDataModelProperties#EXPORT_OUTPUT
	 */
	protected OutputStream getDefaultExportOutput() {

		return null;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see IDeployTopologyExportDataModelProperties#EXPORT_LOGGER
	 */
	public IStatus validateExportLogger() {
		//Assert.isTrue(model.getProperty(IDeployTopologyExportDataModelProperties.EXPORT_LOGGER) instanceof DeployExportLogger);		

		//DeployExportLogger exportLoggerProperty = (DeployExportLogger)  model.getProperty(IDeployTopologyExportDataModelProperties.EXPORT_LOGGER);

		// TODO Validate the ExportLogger property.
		return Status.OK_STATUS;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see IDeployTopologyExportDataModelProperties#EXPORT_LOGGER
	 */
	protected DeployExportLogger getDefaultExportLogger() {
		// TODO Return the default value of the ExportLogger property.
		return null;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see IDeployTopologyExportDataModelProperties#SCRIBBLER_DEFINITION
	 */
	public IStatus validateScribblerDefinition() {
		if (getDataModel().isNestedModel(
				IDeployTopologyExportDataModelProperties.SCRIBBLER_DEFINITION_MODEL)) {
			IDataModel model = getDataModel().getNestedModel(
					IDeployTopologyExportDataModelProperties.SCRIBBLER_DEFINITION_MODEL);
			return model.validate();
		}
		return Status.OK_STATUS;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see IDeployTopologyExportDataModelProperties#SCRIBBLER_DEFINITION
	 */
	protected IDataModel getDefaultScribblerDefinition() {
		// IDataModel model = getDataModel().getNestedModel(IDeployTopologyExportDataModelProperties.SCRIBBLER_DEFINITION);		
		// ScribblerDefinitionDatamodel scribblerDefinition = new ScribblerDefinitionDatamodel(model);
		/*
		 * ScribblerDefinitionDatamodel scribblerDefinition =
		 * ScribblerDefinitionDatamodel.createModel(); DeployTopologyExportDataModel myExportDataModel =
		 * new DeployTopologyExportDataModel(getDataModel()); IFile topologyFile =
		 * myExportDataModel.getTopologyFile();
		 * scribblerDefinition.setEditModelLabel(DeploymentTopologyDomain.generateEditModelLabel(topologyFile));
		 * scribblerDefinition.setProjectName(topologyFile.getProject().getName()); List domain = new
		 * ArrayList(); domain.add(new DeploymentTopologyDomain (topologyFile));
		 * scribblerDefinition.setScribblerDomains(domain); return
		 * scribblerDefinition.getUnderlyingDataModel();
		 */
		DeployTopologyExportDataModel myExportDataModel = new DeployTopologyExportDataModel(
				getDataModel());
		ScribblerDefinitionDatamodel scribblerDefinition = myExportDataModel.getScribblerDefinition();
		IFile topologyFile = myExportDataModel.getTopologyFile();
		scribblerDefinition.setEditModelLabel(DeploymentTopologyDomain
				.generateEditModelLabel(topologyFile));
		scribblerDefinition.setProjectName(topologyFile.getProject().getName());
		List domain = new ArrayList();
		domain.add(new DeploymentTopologyDomain(topologyFile));
		scribblerDefinition.setScribblerDomains(domain);
		return scribblerDefinition.getUnderlyingDataModel();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.wst.common.frameworks.datamodel.IDataModelProvider#validate(String)
	 *      @generated (mde.utilities.datamodels)
	 */
	public IStatus validate(String property) {
		if (IDeployTopologyExportDataModelProperties.SCRIBBLER_DEFINITION_MODEL.equals(property)) {
			return validateScribblerDefinition();
		} else if (IDeployTopologyExportDataModelProperties.EXPORT_SOURCE_FILES.equals(property)) {
			return validateExportSourceFiles();
		} else if (IDeployTopologyExportDataModelProperties.OVERWRITE_EXISTING.equals(property)) {
			return validateOverwriteExisting();
		} else if (IDeployTopologyExportDataModelProperties.TOPOLOGY_FILE.equals(property)) {
			return validateTopologyFile();
		} else if (IDeployTopologyExportDataModelProperties.EXPORT_LOGGER.equals(property)) {
			return validateExportLogger();
		} else if (IDeployTopologyExportDataModelProperties.EXPORT_WITH_ERROR.equals(property)) {
			return validateExportWithError();
		} else if (IDeployTopologyExportDataModelProperties.TOPOLOGY_HAS_ERROR.equals(property)) {
			return validateTopologyHasError();
		} else if (IDeployTopologyExportDataModelProperties.ARCHIVE_DESTINATION.equals(property)) {
			return validateArchiveDestination();
		} else if (IDeployTopologyExportDataModelProperties.EXPORTER.equals(property)) {
			return validateExporter();
		} else if (IDeployTopologyExportDataModelProperties.IMPORTED_TOPOLOGY_IN_USE.equals(property)) {
			return validateImportedTopologyInUse();
		} else if (IDeployTopologyExportDataModelProperties.EXPORT_OUTPUT.equals(property)) {
			return validateExportOutput();
		} else if (IDeployTopologyExportDataModelProperties.CREATE_LOCATION_BINDING.equals(property)) {
			return validateCreateLocationBinding();
		} else if (IDeployTopologyExportDataModelProperties.CREATE_EXPORT_PROJECT.equals(property)) {
			return validateCreateExportProject();
		} else if (IDeployTopologyExportDataModelProperties.EXPORT_DIAGRAM_RESOURCE_IF_PRESENT
				.equals(property)) {
			return validateExportDiagramResourceIfPresent();
		} else if (IDeployTopologyExportDataModelProperties.EXPORT_PROJECT_NAME.equals(property)) {
			return validateExportProjectName();
		} else if (IDeployTopologyExportDataModelProperties.EXPORT_MODULES.equals(property)) {
			return validateExportModules();
		} else {
			return Status.OK_STATUS;
		}

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.wst.common.frameworks.datamodel.IDataModelProvider#getDefaultProperty(String)
	 *      @generated (mde.utilities.datamodels)
	 */
	public Object getDefaultProperty(String property) {
		if (IDeployTopologyExportDataModelProperties.SCRIBBLER_DEFINITION_MODEL.equals(property)) {
			return getDefaultScribblerDefinition();
		} else if (IDeployTopologyExportDataModelProperties.EXPORT_SOURCE_FILES.equals(property)) {
			return getDefaultExportSourceFiles();
		} else if (IDeployTopologyExportDataModelProperties.OVERWRITE_EXISTING.equals(property)) {
			return getDefaultOverwriteExisting();
		} else if (IDeployTopologyExportDataModelProperties.TOPOLOGY_FILE.equals(property)) {
			return getDefaultTopologyFile();
		} else if (IDeployTopologyExportDataModelProperties.EXPORT_LOGGER.equals(property)) {
			return getDefaultExportLogger();
		} else if (IDeployTopologyExportDataModelProperties.EXPORT_WITH_ERROR.equals(property)) {
			return getDefaultExportWithError();
		} else if (IDeployTopologyExportDataModelProperties.TOPOLOGY_HAS_ERROR.equals(property)) {
			return getDefaultTopologyHasError();
		} else if (IDeployTopologyExportDataModelProperties.ARCHIVE_DESTINATION.equals(property)) {
			return getDefaultArchiveDestination();
		} else if (IDeployTopologyExportDataModelProperties.EXPORTER.equals(property)) {
			return getDefaultExporter();
		} else if (IDeployTopologyExportDataModelProperties.IMPORTED_TOPOLOGY_IN_USE.equals(property)) {
			return getDefaultImportedTopologyInUse();
		} else if (IDeployTopologyExportDataModelProperties.EXPORT_OUTPUT.equals(property)) {
			return getDefaultExportOutput();
		} else if (IDeployTopologyExportDataModelProperties.CREATE_LOCATION_BINDING.equals(property)) {
			return getDefaultCreateLocationBinding();
		} else if (IDeployTopologyExportDataModelProperties.CREATE_EXPORT_PROJECT.equals(property)) {
			return getDefaultCreateExportProject();
		} else if (IDeployTopologyExportDataModelProperties.EXPORT_DIAGRAM_RESOURCE_IF_PRESENT
				.equals(property)) {
			return getDefaultExportDiagramResourceIfPresent();
		} else if (IDeployTopologyExportDataModelProperties.EXPORT_PROJECT_NAME.equals(property)) {
			return getDefaultExportProjectName();
		} else if (IDeployTopologyExportDataModelProperties.EXPORT_MODULES.equals(property)) {
			return getDefaultExportModules();
		} else {
			return null;
		}

	}

	/*
	 * Override this method to handle dependencies between different properties. That is, if changing
	 * a name property updates the default values of other properties, this is where you respond to
	 * these changes.
	 * 
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.wst.common.frameworks.datamodel.IDataModelProvider#propertySet(String,
	 *      Object)
	 */
	public boolean propertySet(String propertyName, Object propertyValue) {
		if (IDeployTopologyExportDataModelProperties.TOPOLOGY_FILE.equals(propertyName)) {

			ScribblerDefinitionDatamodel scribblerDefinition = ScribblerDefinitionDatamodel
					.createModel();
			IFile topologyFile = (IFile) propertyValue;
			scribblerDefinition.setEditModelLabel(DeploymentTopologyDomain
					.generateEditModelLabel(topologyFile));
			scribblerDefinition.setProjectName(topologyFile.getProject().getName());
			List domain = new ArrayList();
			domain.add(new DeploymentTopologyDomain(topologyFile));
			scribblerDefinition.setScribblerDomains(domain);

			if (model
					.isNestedModel(IDeployTopologyExportDataModelProperties.SCRIBBLER_DEFINITION_MODEL)) {
				model
						.removeNestedModel(IDeployTopologyExportDataModelProperties.SCRIBBLER_DEFINITION_MODEL);
			}
			model.addNestedModel(IDeployTopologyExportDataModelProperties.SCRIBBLER_DEFINITION_MODEL,
					scribblerDefinition.getUnderlyingDataModel());
		}
		return super.propertySet(propertyName, propertyValue);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.wst.common.frameworks.datamodel.IDataModelProvider#getPropertyNames()
	 *      @generated (mde.utilities.datamodels)
	 */
	public Set getPropertyNames() {
		Set propertyNames = super.getPropertyNames();
		propertyNames.add(IDeployTopologyExportDataModelProperties.SCRIBBLER_DEFINITION_MODEL);
		propertyNames.add(IDeployTopologyExportDataModelProperties.EXPORT_SOURCE_FILES);
		propertyNames.add(IDeployTopologyExportDataModelProperties.OVERWRITE_EXISTING);
		propertyNames.add(IDeployTopologyExportDataModelProperties.TOPOLOGY_FILE);
		propertyNames.add(IDeployTopologyExportDataModelProperties.EXPORT_LOGGER);
		propertyNames.add(IDeployTopologyExportDataModelProperties.EXPORT_WITH_ERROR);
		propertyNames.add(IDeployTopologyExportDataModelProperties.TOPOLOGY_HAS_ERROR);
		propertyNames.add(IDeployTopologyExportDataModelProperties.ARCHIVE_DESTINATION);
		propertyNames.add(IDeployTopologyExportDataModelProperties.EXPORTER);
		propertyNames.add(IDeployTopologyExportDataModelProperties.IMPORTED_TOPOLOGY_IN_USE);
		propertyNames.add(IDeployTopologyExportDataModelProperties.EXPORT_OUTPUT);
		propertyNames.add(IDeployTopologyExportDataModelProperties.CREATE_LOCATION_BINDING);
		propertyNames.add(IDeployTopologyExportDataModelProperties.CREATE_EXPORT_PROJECT);
		propertyNames
				.add(IDeployTopologyExportDataModelProperties.EXPORT_DIAGRAM_RESOURCE_IF_PRESENT);
		propertyNames.add(IDeployTopologyExportDataModelProperties.EXPORT_PROJECT_NAME);
		propertyNames.add(IDeployTopologyExportDataModelProperties.EXPORT_MODULES);
		return propertyNames;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.wst.common.frameworks.datamodel.IDataModelProvider#getDefaultOperation()
	 *      @generated (mde.utilities.datamodels)
	 */
	public IDataModelOperation getDefaultOperation() {
		return new DeployTopologyExportDataModelOperation(model);
	}

}
