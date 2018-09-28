package com.ibm.ccl.soa.deploy.core.internal.datamodels;

import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.resources.IFile;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.wst.common.frameworks.datamodel.IDataModel;

import com.ibm.ccl.soa.deploy.core.DeployCoreRoot;
import com.ibm.ccl.soa.deploy.core.DeploymentTopologyDomain;
import com.ibm.ccl.soa.deploy.core.Topology;
import com.ibm.ccl.soa.deploy.core.TopologyExporter;
import com.ibm.ccl.soa.deploy.core.datamodels.DeployTopologyExportDataModel;
import com.ibm.ccl.soa.deploy.core.export.DeployExportLogger;
import com.ibm.ccl.soa.deploy.core.export.DeployTopologyExportService;
import com.ibm.ccl.soa.deploy.internal.core.DeployCoreMessages;
import com.ibm.ccl.soa.infrastructure.operations.AbstractEMFScribblerOperation;

/**
 * 	 
 * This datamodel is used with the export of the topology.
 * 
 * <p>
 * Clients should use {@link DeployTopologyExportDataModel#createConfiguredOperation()} to create
 * an instance of this operation, configured with the necessary model properties.
 * </p>
 *
 * @see com.ibm.ccl.soa.infrastructure.operations.AbstractEMFScribblerOperation
 * @see com.ibm.ccl.soa.deploy.core.datamodels.DeployTopologyExportDataModel
 * @generated (mde.utilities.datamodels)
 */
public class DeployTopologyExportDataModelOperation extends AbstractEMFScribblerOperation implements
		IDeployTopologyExportDataModelProperties {

	private DeployTopologyExportDataModel typesafeModel;

	/**
   * Construct an operation pre-configured with the given data model.
   * 
   * @param dMdl The datamodel to use when executing this operation. 
   * @generated (mde.utilities.datamodels)
   */
	public DeployTopologyExportDataModelOperation(IDataModel dMdl) {
    super(dMdl); 
    setTypeSafeModel(new DeployTopologyExportDataModel(dMdl));
  }

	/**
   * Construct an operation pre-configured with the given type-safe data model.
   * 
   * @param tsMdl The type-safe datamodel to use when executing this operation. 
   * @generated (mde.utilities.datamodels)
   */
	public DeployTopologyExportDataModelOperation(DeployTopologyExportDataModel tsMdl) {
    super(tsMdl.getUnderlyingDataModel());
    setTypeSafeModel(tsMdl);
  }

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.core.commands.operations.IUndoableOperation#execute(IProgressMonitor,
	 *      IAdaptable)
	 */
	protected IStatus doExecute(IProgressMonitor monitor) throws ExecutionException {
		// TODO Use the "typesafeModel" field to execute the tasks of this operation
		IFile topologyFile = typesafeModel.getTopologyFile();
		String projectName = typesafeModel.getScribblerDefinition().getProjectName();
		if (topologyFile == null || projectName == null) {
			return Status.CANCEL_STATUS;
		}
		Topology topology = getDeploymentTopology();
		if (topology != null) {
			try {
				exportDeploymentTopology(topology);
			} catch (Exception e) {
				throw new ExecutionException(
						DeployCoreMessages.EXPORT_DEPLOYMENT_TOPOLOGY_FAILED_ERROR, e);
			}
		}

		return Status.OK_STATUS;
	}

	/**
   * This operation can accept a typesafe model that provides a more usable
   * interface to the {@link org.eclipse.wst.common.frameworks.datamodel.IDataModel}.
   * 
   * @param mdl The typesafe model that will drive this operation.
   * @generated (mde.utilities.datamodels)
   */
	private void setTypeSafeModel(DeployTopologyExportDataModel mdl) {
    typesafeModel = mdl;
  }

	private Topology getDeploymentTopology() {
		Topology topology = null;
		// Load DP Resource
		Resource dpResource = getEditModelScribbler().getResource(
				getDeploymentTopologyDomain().getTopologyResource());
		DeployCoreRoot documentRoot = (DeployCoreRoot) dpResource.getContents().get(0);
		topology = documentRoot.getTopology();
		return topology;
	}

	/**
	 * Traversal logic for publishing the deployable modules to the server
	 * 
	 * @param monitor
	 * @param jobListener
	 */
	protected void exportDeploymentTopology(Topology topology) throws Exception {
		//TODO isImportedTopology, getExportOptions
		Boolean importedTopologyInUse = typesafeModel.getImportedTopologyInUse();
		boolean exportWithErrors = typesafeModel.getExportWithError().booleanValue();
		boolean createLocationBinding = typesafeModel.getCreateLocationBinding().booleanValue();
		boolean exportDiagramResourceIfPresent = typesafeModel.getExportDiagramResourceIfPresent()
				.booleanValue();
		boolean exportModules = typesafeModel.getExportModules().booleanValue();
		boolean createExportProject = typesafeModel.getCreateExportProject().booleanValue();
		if (importedTopologyInUse != null && importedTopologyInUse.booleanValue()) {
			String exportProjectName = typesafeModel.getExportProjectName();
			TopologyExporter exportType = typesafeModel.getExporter();
			DeployTopologyExportService exportService = new DeployTopologyExportService(exportType,
					exportWithErrors, createLocationBinding, exportProjectName, createExportProject,
					exportDiagramResourceIfPresent, exportModules);
			exportService.exportDeploymentTopology(topology, typesafeModel.getExportOutput());
		} else {
			String exportProjectName = topology.getName(); //use the default topology name
			String zipFileName = typesafeModel.getArchiveDestination();
			TopologyExporter exportType = typesafeModel.getExporter();
			DeployTopologyExportService exportService = new DeployTopologyExportService(exportType,
					exportWithErrors, createLocationBinding, exportProjectName, createExportProject,
					exportDiagramResourceIfPresent, exportModules);
			exportService.exportDeploymentTopology(topology, zipFileName);
			DeployExportLogger exportLog = exportService.getExportOptions().getExportLog();
			if (exportLog != null) {
				typesafeModel.setExportLogger(exportLog);
			}
		}
	}

	private DeploymentTopologyDomain getDeploymentTopologyDomain() {
		return (DeploymentTopologyDomain) typesafeModel.getScribblerDefinition()
				.getScribblerDomains().get(0);
	}

}
