package com.ibm.ccl.soa.deploy.ide.refactoring.participant;

import org.eclipse.core.resources.IContainer;
import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.IPath;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Path;
import org.eclipse.wst.common.frameworks.datamodel.DataModelFactory;
import org.eclipse.wst.common.frameworks.datamodel.IDataModel;
import org.eclipse.wst.common.frameworks.datamodel.IDataModelOperation;
import org.eclipse.wst.common.frameworks.datamodel.IDataModelProvider;

import com.ibm.ccl.soa.deploy.core.Topology;
import com.ibm.ccl.soa.deploy.core.index.ROTopologyModelManager;
import com.ibm.ccl.soa.deploy.core.index.ROTopologyModelManager.Listener;
import com.ibm.ccl.soa.deploy.core.internal.datamodels.ICreateTopologyDataModelProperties;
import com.ibm.ccl.soa.deploy.ide.internal.refactoring.participant.DeleteNamespaceModelProvider;
import com.ibm.ccl.soa.deploy.ide.internal.refactoring.participant.IDeleteNamespaceModelProperties;
import com.ibm.ccl.soa.deploy.ide.internal.refactoring.participant.operation.DeleteNamespaceOperation;

public class DeleteNamespaceDescriptor {

	private ROTopologyModelManager modelManager = null;
	private final IDataModel model;

	/**
	 * Creates and returns an instance of the type-safe API datamodel.
	 * 
	 * @return An instance of the type-safe API datamodel.
	 * @generated (mde.utilities.datamodels)
	 */
	public static DeleteNamespaceDescriptor createModel() {
		IDataModel model = DataModelFactory.createDataModel(createDatamodelProvider());
		return new DeleteNamespaceDescriptor(model);
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
		return new DeleteNamespaceModelProvider();
	}

	/**
	 * Create a type-safe facade for the given datamodel.
	 * 
	 * @param mdl
	 *           The datamodel to provide a facade for.
	 * @generated (mde.utilities.datamodels)
	 */
	public DeleteNamespaceDescriptor(IDataModel mdl) {
		model = mdl;
	}

	public void setSourcePath(String path) {
		model.setProperty(IDeleteNamespaceModelProperties.SOURCE_PATH, path);
	}

	public String getSourcePath() {
		return (String) model.getProperty(IDeleteNamespaceModelProperties.SOURCE_PATH);
	}

	public IStatus validateSourcePath() {
		return model.validateProperty(IDeleteNamespaceModelProperties.SOURCE_PATH);
	}

	public String getDefaultSourcePath() {
		return (String) model.getDefaultProperty(IDeleteNamespaceModelProperties.SOURCE_PATH);
	}

	public void setNamespacePath(String path) {
		model.setProperty(IDeleteNamespaceModelProperties.NAMESPACE_PATH, path);
	}

	public String getNamespacePath() {
		return (String) model.getProperty(IDeleteNamespaceModelProperties.NAMESPACE_PATH);
	}

	public IStatus validateNamespacePath() {
		return model.validateProperty(IDeleteNamespaceModelProperties.NAMESPACE_PATH);
	}

	public String getDefaultNamespacePath() {
		return (String) model.getDefaultProperty(IDeleteNamespaceModelProperties.NAMESPACE_PATH);
	}

	/**
	 * Create and return an operation that is configured with the values from this datamodel.
	 * 
	 * @return A ready-to-run operation prepared with this model to carry out the operation.
	 * @generated (mde.utilities.datamodels)
	 */
	public IDataModelOperation createConfiguredOperation() {
		DeleteNamespaceOperation operation = new DeleteNamespaceOperation(this);
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
	 * @return An {@link IContainer} defined for the
	 *         {@link ICreateTopologyDataModelProperties#SOURCE_PATH} property.
	 */
	public IContainer getSourceContainer() {
		String sourcePath = getSourcePath();
		if (sourcePath != null) {
			return DeleteNamespaceModelProvider.getWorkspaceRelativeContainer(new Path(sourcePath));
		}
		return null;
	}

	public IContainer getNamespaceContainer() {
		String namepsacePath = model
				.getStringProperty(IDeleteNamespaceModelProperties.NAMESPACE_PATH);
		return DeleteNamespaceModelProvider.computeContainerFromNamespace(getSourceContainer(),
				namepsacePath);
	}

	private ROTopologyModelManager getModelManager() {
		if (modelManager == null) {
			modelManager = ROTopologyModelManager.create();
		}

		return modelManager;
	}

	public Topology getTopology(IPath path) {
		return getTopology(ResourcesPlugin.getWorkspace().getRoot().getFile(path));
	}

	public Topology getTopology(IFile file) {
		return getModelManager().openModel(file, new Listener() {

			public void onUnload(IFile unloadedResource) {
				// TODO Auto-generated method stub

			}

		});
	}

	public void dispose() {
		if (modelManager != null) {
			modelManager.dispose();
			modelManager = null;
		}
	}
}