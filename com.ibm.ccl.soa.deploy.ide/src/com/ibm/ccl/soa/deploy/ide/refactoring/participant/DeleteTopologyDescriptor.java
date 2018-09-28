package com.ibm.ccl.soa.deploy.ide.refactoring.participant;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.IPath;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.wst.common.frameworks.datamodel.DataModelFactory;
import org.eclipse.wst.common.frameworks.datamodel.IDataModel;
import org.eclipse.wst.common.frameworks.datamodel.IDataModelOperation;
import org.eclipse.wst.common.frameworks.datamodel.IDataModelProvider;

import com.ibm.ccl.soa.deploy.core.Topology;
import com.ibm.ccl.soa.deploy.core.index.ROTopologyModelManager;
import com.ibm.ccl.soa.deploy.core.index.ROTopologyModelManager.Listener;
import com.ibm.ccl.soa.deploy.ide.internal.refactoring.participant.DeleteTopologyModelProvider;
import com.ibm.ccl.soa.deploy.ide.internal.refactoring.participant.IDeleteTopologyModelProperties;
import com.ibm.ccl.soa.deploy.ide.internal.refactoring.participant.operation.DeleteTopologyOperation;

/**
 * 
 * 
 * 
 * <p>
 * The following properties are <b>required</b>. If not provided, then the model is not in a valid
 * state, and the operation will not be able to execute successfully.
 * </p>
 * <ul>
 * <li><b>topology</b>:
 * 
 * </li>
 * <li><b>name</b>:
 * 
 * </li>
 * </ul>
 * 
 * @generated (mde.utilities.datamodels)
 */
public class DeleteTopologyDescriptor {

	private ROTopologyModelManager modelManager = null;
	private final IDataModel model;

	/**
	 * Creates and returns an instance of the type-safe API datamodel.
	 * 
	 * @return An instance of the type-safe API datamodel.
	 * @generated (mde.utilities.datamodels)
	 */
	public static DeleteTopologyDescriptor createModel() {
		IDataModel model = DataModelFactory.createDataModel(createDatamodelProvider());
		return new DeleteTopologyDescriptor(model);
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
		return new DeleteTopologyModelProvider();
	}

	/**
	 * Create a type-safe facade for the given datamodel.
	 * 
	 * @param mdl
	 *           The datamodel to provide a facade for.
	 * @generated (mde.utilities.datamodels)
	 */
	public DeleteTopologyDescriptor(IDataModel mdl) {
		model = mdl;
	}

	/**
	 * 
	 * 
	 * <p>
	 * <b>[Required]</b>
	 * </p>
	 * 
	 * @param newTopology
	 *           The new value of the Topology property.
	 * @generated (mde.utilities.datamodels)
	 */
	public void setTopology(String newTopology) {
		model.setProperty(IDeleteTopologyModelProperties.TOPOLOGY, newTopology);
	}

	/**
	 * 
	 * 
	 * @return The value of the Topology property.
	 * @generated (mde.utilities.datamodels)
	 */
	public String getTopology() {
		return (String) model.getProperty(IDeleteTopologyModelProperties.TOPOLOGY);
	}

	/**
	 * Determine if the Topology property meets all constraints required of it.
	 * 
	 * @return A status object indicating error or warning messages, if any, or OK if the Topology
	 *         property is valid.
	 * @see #getTopology()
	 * @see #setTopology(String)
	 * @generated (mde.utilities.datamodels)
	 */
	public IStatus validateTopology() {
		return model.validateProperty(IDeleteTopologyModelProperties.TOPOLOGY);
	}

	/**
	 * Determine the default value of the Topology property.
	 * 
	 * @return The default value of the Topology property.
	 * @see #getTopology()
	 * @see #setTopology(String)
	 * @generated (mde.utilities.datamodels)
	 */
	public String getDefaultTopology() {
		return (String) model.getDefaultProperty(IDeleteTopologyModelProperties.TOPOLOGY);
	}

	/**
	 * Create and return an operation that is configured with the values from this datamodel.
	 * 
	 * @return A ready-to-run operation prepared with this model to carry out the operation.
	 * @generated (mde.utilities.datamodels)
	 */
	public IDataModelOperation createConfiguredOperation() {
		DeleteTopologyOperation operation = new DeleteTopologyOperation(this);
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
