/***************************************************************************************************
 * Copyright (c) 2006 IBM Corporation. Licensed Material - Property of IBM. All rights reserved. US
 * Government Users Restricted Rights - Use, duplication or disclosure restricted by GSA ADP
 * Schedule Contract with IBM Corp.
 * 
 * Contributors: IBM Corporation - initial API and implementation
 **************************************************************************************************/
package com.ibm.ccl.soa.deploy.core.internal.datamodels;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Path;
import org.eclipse.core.runtime.Status;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.workspace.AbstractEMFOperation;
import org.eclipse.emf.workspace.util.WorkspaceSynchronizer;
import org.eclipse.wst.common.frameworks.datamodel.AbstractDataModelOperation;
import org.eclipse.wst.common.frameworks.datamodel.IDataModel;

import com.ibm.ccl.soa.deploy.core.ChangeScope;
import com.ibm.ccl.soa.deploy.core.DeployCorePlugin;
import com.ibm.ccl.soa.deploy.core.DeploymentTopologyDomain;
import com.ibm.ccl.soa.deploy.core.IConstants;
import com.ibm.ccl.soa.deploy.core.Topology;
import com.ibm.ccl.soa.deploy.core.Unit;
import com.ibm.ccl.soa.deploy.core.constraint.ConstraintFactory;
import com.ibm.ccl.soa.deploy.core.constraint.PaletteConstraint;
import com.ibm.ccl.soa.deploy.core.datamodels.AddToPaletteDataModel;
import com.ibm.ccl.soa.deploy.core.datamodels.CreateTopologyDataModel;
import com.ibm.ccl.soa.deploy.core.extension.ExtensionsCore;
import com.ibm.ccl.soa.deploy.core.extension.IResourceTypeService;
import com.ibm.ccl.soa.deploy.internal.core.DeployFileModificationApprover.DeployValidateEditHelper;
import com.ibm.ccl.soa.deploy.internal.core.extension.ResourceTypeService;
import com.ibm.ccl.soa.infrastructure.assertion.Assert;
import com.ibm.ccl.soa.infrastructure.emf.WorkbenchResourceHelper;

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
public class AddToPaletteDataModelOperation extends AbstractDataModelOperation implements
		IAddToPaletteDataModelProperties {

	private AddToPaletteDataModel typesafeModel;

	/**
	 * Construct an operation pre-configured with the given data model.
	 * 
	 * @param dMdl
	 *           The datamodel to use when executing this operation.
	 * @generated (mde.utilities.datamodels)
	 */
	public AddToPaletteDataModelOperation(IDataModel dMdl) {
		super(dMdl);
		setTypeSafeModel(new AddToPaletteDataModel(dMdl));
	}

	public boolean canExecute() {
		return typesafeModel != null && typesafeModel.getAddToPalette();
	}

	/**
	 * Construct an operation pre-configured with the given type-safe data model.
	 * 
	 * @param tsMdl
	 *           The type-safe datamodel to use when executing this operation.
	 * @generated (mde.utilities.datamodels)
	 */
	public AddToPaletteDataModelOperation(AddToPaletteDataModel tsMdl) {
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
		status = approveExecuteProcessing();
		if (!status.isOK()) {
			return status;
		}
		return doExecute(monitor, info);
	}

	private IStatus approveExecuteProcessing() {
		List<IFile> files = getAffectedFiles();
		if (!files.isEmpty()) {
			IFile[] fileArray = files.toArray(new IFile[files.size()]);
			DeployValidateEditHelper helper = DeployCorePlugin.getDefault()
					.getDeployValidateEditHelper();
			return ResourcesPlugin.getWorkspace().validateEdit(fileArray,
					helper != null ? helper.getUIContext() : null);
		}
		return Status.OK_STATUS;
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
		String uri = typesafeModel.getTopology().eResource().getURI().toString();
		uri = uri.replace("%20", " "); //$NON-NLS-1$ //$NON-NLS-2$
		IResourceTypeService rts = ExtensionsCore.createResourceTypeService();
		typesafeModel.setLabel(typesafeModel.getLabel());
		if (typesafeModel.getUnits().length == 0) {
			if (typesafeModel.getProjectName() == null
					|| typesafeModel.getProjectName().equals(typesafeModel.getDefaultProjectName())) {
				deriveProjectName();
			}

			// we don't forcibly set the diagram URI -- let it default if not alreday specified.
			rts.addDynamicResourceType(typesafeModel.getLabel(), typesafeModel.getPath(),
					typesafeModel.getLabel(), typesafeModel.getDescription(), typesafeModel.getIcon(),
					typesafeModel.getIcon(), new Unit[0], typesafeModel.getProjectName(), uri,
					typesafeModel.getTopologyVUri());

		} else {
			rts.addDynamicResourceType(typesafeModel.getLabel(), typesafeModel.getPath(),
					typesafeModel.getLabel(), typesafeModel.getDescription(), typesafeModel.getIcon(),
					typesafeModel.getIcon(), typesafeModel.getUnits(), typesafeModel.getProjectName(),
					null, typesafeModel.getTopologyVUri());
			typesafeModel.setTopology(rts.getCurrentTopology());
		}

		addPaletteConstraint(monitor);

		return OK_STATUS;
	}

	private void deriveProjectName() {
		Topology topology = typesafeModel.getTopology();
		if (topology == null) {
			return;
		}
		Resource resource = topology.eResource();
		if (resource == null) {
			return;
		}
		IFile file = WorkbenchResourceHelper.getFile(resource);
		if (file == null || file.getProject() == null) {
			return;
		}
		typesafeModel.setProjectName(file.getProject().getName());

	}

	private IFile getDefaultDiagramFile(IFile file) {
		Path diagramPath = (Path) new Path(file.getName()).removeFileExtension();
		// add .topologyv extenion, then get file from same parent as .topology file (same folder)
		return file.getParent().getFile(diagramPath.addFileExtension(IConstants.TOPOLOGYV_EXTENSION));
	}

	private void addPaletteConstraint(IProgressMonitor monitor) {
		Topology topology = typesafeModel.getTopology();
		ChangeScope<Topology, DeploymentTopologyDomain> scope = ChangeScope
				.createChangeScopeForWrite(topology);
		AbstractEMFOperation op = new AbstractEMFOperation(scope.getTransactionalEditingDomain(), "") { //$NON-NLS-1$

			@SuppressWarnings("unchecked")
			@Override
			protected IStatus doExecute(IProgressMonitor monitor, IAdaptable info)
					throws ExecutionException {
				ChangeScope<Topology, DeploymentTopologyDomain> scope = ChangeScope
						.findChangeScope(info);
				Topology topology = scope.getTarget();
				PaletteConstraint palConstraint = ConstraintFactory.eINSTANCE.createPaletteConstraint();
				palConstraint.setName("paletteID"); //$NON-NLS-1$
				String typeId = typesafeModel.getLabel();
				palConstraint.setResourceTypeId(typeId);
				palConstraint.setDisplayName(typeId);
				topology.getConstraints().add(palConstraint);
				topology.setMutabilityConfigurable(true);
				return Status.OK_STATUS;
			}

		};

		try {
			scope.execute(op, ChangeScope.OPTION_FORCE_SAVE, monitor);

		} finally {
			scope.close(null);
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
	private void setTypeSafeModel(AddToPaletteDataModel mdl) {
		typesafeModel = mdl;
	}

	public List<IFile> getAffectedFiles() {
		//Add topology file
		Topology top = typesafeModel.getTopology();
		List<IFile> files = new ArrayList<IFile>(2);
		if (top != null) {
			Resource resource = top.eResource();

			if (resource != null) {
				IFile file = WorkspaceSynchronizer.getFile(resource);
				if (file != null && file.exists()) {
					files.add(file);
				}
			}
			//Add dynamic types file.
			IFile dynamicTypeFile = ResourceTypeService.getInstance().computeDynamicResourceTypesFile(
					typesafeModel.getProjectName());
			if (dynamicTypeFile != null && dynamicTypeFile.exists()) {
				files.add(dynamicTypeFile);
			}
		}
		return files;
	}
}
