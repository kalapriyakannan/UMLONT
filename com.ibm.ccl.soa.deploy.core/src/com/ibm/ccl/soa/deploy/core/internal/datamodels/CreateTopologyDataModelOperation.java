/***************************************************************************************************
 * Copyright (c) 2006 IBM Corporation. Licensed Material - Property of IBM. All rights reserved. US
 * Government Users Restricted Rights - Use, duplication or disclosure restricted by GSA ADP
 * Schedule Contract with IBM Corp.
 * 
 * Contributors: IBM Corporation - initial API and implementation
 **************************************************************************************************/
package com.ibm.ccl.soa.deploy.core.internal.datamodels;

import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.resources.IContainer;
import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.OperationCanceledException;
import org.eclipse.core.runtime.Path;
import org.eclipse.core.runtime.Status;
import org.eclipse.core.runtime.SubProgressMonitor;
import org.eclipse.emf.workspace.AbstractEMFOperation;
import org.eclipse.osgi.util.NLS;
import org.eclipse.wst.common.frameworks.datamodel.AbstractDataModelOperation;
import org.eclipse.wst.common.frameworks.datamodel.IDataModel;

import com.ibm.ccl.soa.deploy.core.ChangeScope;
import com.ibm.ccl.soa.deploy.core.ContractProvider;
import com.ibm.ccl.soa.deploy.core.DeploymentTopologyDomain;
import com.ibm.ccl.soa.deploy.core.IConstants;
import com.ibm.ccl.soa.deploy.core.Topology;
import com.ibm.ccl.soa.deploy.core.IConstants.DecoratorSemanticConstants;
import com.ibm.ccl.soa.deploy.core.datamodels.AddToPaletteDataModel;
import com.ibm.ccl.soa.deploy.core.datamodels.CreateTopologyDataModel;
import com.ibm.ccl.soa.deploy.core.extension.ExtensionsCore;
import com.ibm.ccl.soa.deploy.core.extension.IDecoratorSemanticService;
import com.ibm.ccl.soa.deploy.core.namespace.NamespaceCore;
import com.ibm.ccl.soa.deploy.internal.core.DeployCoreMessages;
import com.ibm.ccl.soa.deploy.internal.core.extension.ContractProviderManager;
import com.ibm.ccl.soa.infrastructure.assertion.Assert;

/**
 * 
 * This data model is used to create a new Topology. This data model will allow you to set a project
 * location as well as the source folder and namespace for the new topology.
 * 
 * <p>
 * Clients should use {@link CreateTopologyDataModel#createConfiguredOperation()} to create an
 * instance of this operation, configured with the necessary model properties.
 * </p>
 * 
 * @see org.eclipse.wst.common.frameworks.datamodel.AbstractDataModelOperation
 * @see com.ibm.ccl.soa.deploy.core.datamodels.CreateTopologyDataModel
 * @generated (mde.utilities.datamodels)
 */
public class CreateTopologyDataModelOperation extends AbstractDataModelOperation implements
		ICreateTopologyDataModelProperties {

	private CreateTopologyDataModel typesafeModel;

	/**
	 * Construct an operation pre-configured with the given data model.
	 * 
	 * @param dMdl
	 *           The datamodel to use when executing this operation.
	 * @generated (mde.utilities.datamodels)
	 */
	public CreateTopologyDataModelOperation(IDataModel dMdl) {
		super(dMdl);
		setTypeSafeModel(new CreateTopologyDataModel(dMdl));
	}

	/**
	 * Construct an operation pre-configured with the given type-safe data model.
	 * 
	 * @param tsMdl
	 *           The type-safe datamodel to use when executing this operation.
	 * @generated (mde.utilities.datamodels)
	 */
	public CreateTopologyDataModelOperation(CreateTopologyDataModel tsMdl) {
		super(tsMdl.getUnderlyingDataModel());
		setTypeSafeModel(tsMdl);
	}

	public IStatus execute(IProgressMonitor monitor, IAdaptable info) throws ExecutionException {
		Assert.isNotNull(getDataModel());

		IStatus status = getDataModel().validate();

		//Continue if the status is OK or a WARNING.
		if (status.getSeverity() == IStatus.ERROR) {
			return status;
		}
		return doExecute(monitor, info);
	}

	@Override
	public boolean canUndo() {
		return false;
	}

	@Override
	public boolean canRedo() {
		return false;
	}

	private IStatus doExecute(IProgressMonitor monitor, IAdaptable info) throws ExecutionException {

		if (monitor.isCanceled()) {
			throw new OperationCanceledException();
		}
		try {
			createNamespaceRoot();
		} catch (CoreException e) {
			throw new ExecutionException(
					NLS
							.bind(
									DeployCoreMessages.CreateTopologyDataModelOperation_Failed_to_create_0_source_folde_,
									typesafeModel.getSourcePath()), e);
		}
		monitor.beginTask(DeployCoreMessages.CreateTopologyDataModelOperation_Create_Topolog_, 4);
		String topologyName = typesafeModel.getTopologyName();
		// Set the name so the default computation doesn't change it later.
		typesafeModel.setTopologyName(topologyName);

		ChangeScope<Topology, DeploymentTopologyDomain> changeScope = ChangeScope
				.createChangeScopeForWrite(typesafeModel.getTopologyFile());
		try {
			// we're already executing within an IUndoable operation, so
			// executing the following with scope.execute() will make it 
			// appear like an independent operation. 
			IStatus status = new AbstractEMFOperation(changeScope.getTransactionalEditingDomain(),
					getLabel()) {

				@Override
				protected IStatus doExecute(IProgressMonitor monitor, IAdaptable info)
						throws ExecutionException {

					ChangeScope<Topology, DeploymentTopologyDomain> scope = ChangeScope
							.findChangeScope(info);

					Topology topology = scope.createTopology(typesafeModel.getNamespacePath(),
							typesafeModel.getTopologyName(), new SubProgressMonitor(monitor, 1));

					// create a new topology and set its name/description
					topology.setDisplayName(typesafeModel.getTopologyName());
					topology.setDescription(typesafeModel.getTopologyDescription());

					monitor
							.subTask(DeployCoreMessages.CreateTopologyDataModelOperation_Configuring_Decorator_Semanti_);

					String decoratorSemantic = typesafeModel.getDecoratorSemantic();
					if (!DecoratorSemanticConstants.BLANK_SEMANTIC.equals(decoratorSemantic)) {
						IDecoratorSemanticService dsService = ExtensionsCore
								.createDecoratorSemanticService();
						String decoratorSemanticID = dsService.getDecoratorSemanticId(decoratorSemantic);
						if (decoratorSemanticID != null && decoratorSemanticID.length() > 0) {
							topology.setDecoratorSemantic(decoratorSemanticID);
						}
					}
					monitor.worked(1);

					monitor
							.subTask(DeployCoreMessages.CreateTopologyDataModelOperation_Configuring_Configuration_Contrac_);
					String contractType = typesafeModel.getContractType();
					ContractProvider contractProvider = ContractProviderManager.getInstance()
							.createProvider(contractType);
					contractProvider.installContract(topology);
					executeAddToPaletteOperation(topology, monitor);
					monitor.worked(1);

					return Status.OK_STATUS;
				}

				private void executeAddToPaletteOperation(Topology topology, IProgressMonitor monitor) {
					if (!typesafeModel.getUnderlyingDataModel().isProperty(
							IAddToPaletteDataModelProperties.ADD_TO_PALETTE)) {
						return;
					}

					IDataModel dataModel = typesafeModel.getUnderlyingDataModel().getNestedModel(
							IAddToPaletteDataModelProperties.DATAMODEL);
					if (dataModel == null) {
						return;
					}
					AddToPaletteDataModel paletteDataModel = new AddToPaletteDataModel(dataModel);
					paletteDataModel.setTopology(topology);
//					IFile file = WorkbenchResourceHelper.getFile(topology);
//					IFile topologyVFile = getDefaultDiagramFile(file);
//					paletteDataModel.setTopologyVUri(topologyVFile.getProjectRelativePath().toString());
					AddToPaletteDataModelOperation addOp = new AddToPaletteDataModelOperation(
							paletteDataModel);
					if (addOp.canExecute()) {
						try {
							addOp.execute(monitor, null);
						} catch (ExecutionException e) {
							e.printStackTrace();
						}
					}
				}

			}.execute(new SubProgressMonitor(monitor, 2,
					SubProgressMonitor.PREPEND_MAIN_LABEL_TO_SUBTASK), changeScope);

			if (!status.isOK()) {
				return status;
			}

		} finally {
			if (monitor.isCanceled()) {
				changeScope.close(new SubProgressMonitor(monitor, 1));
				throw new OperationCanceledException();
			}
			IStatus status = changeScope.saveChangesAndClose(true, new SubProgressMonitor(monitor, 1));
			if (!status.isOK()) {
				return status;
			}

			monitor.done();
		}
		return OK_STATUS;
	}

	private void createNamespaceRoot() throws CoreException {
		IContainer sourceContainer = typesafeModel.getSourceContainer();
		if (sourceContainer != null) {
			if (sourceContainer.getType() != IResource.PROJECT) {
				NamespaceCore.createRoot(sourceContainer, null);
			}
		}
	}

	/**
	 * This operation can accept a typesafe model that provides a more usable interface to the
	 * {@link org.eclipse.wst.common.frameworks.datamodel.IDataModel}.
	 * 
	 * @param mdl
	 *           The typesafe model that will drive this operation.
	 * @generated (mde.utilities.datamodels)
	 */
	private void setTypeSafeModel(CreateTopologyDataModel mdl) {
		typesafeModel = mdl;
	}

	private IFile getDefaultDiagramFile(IFile file) {
		Path diagramPath = (Path) new Path(file.getName()).removeFileExtension();
		// add .topologyv extension, then get file from same parent as .topology file (same folder)
		return file.getParent().getFile(diagramPath.addFileExtension(IConstants.TOPOLOGYV_EXTENSION));
	}
}
