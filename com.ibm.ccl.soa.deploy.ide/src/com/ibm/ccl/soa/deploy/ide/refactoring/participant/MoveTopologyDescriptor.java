/***************************************************************************************************
 * Copyright (c) 2006 IBM Corporation. Licensed Material - Property of IBM. All rights reserved. US
 * Government Users Restricted Rights - Use, duplication or disclosure restricted by GSA ADP
 * Schedule Contract with IBM Corp.
 * 
 * Contributors: IBM Corporation - initial API and implementation
 **************************************************************************************************/
package com.ibm.ccl.soa.deploy.ide.refactoring.participant;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IResource;
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
import com.ibm.ccl.soa.deploy.ide.internal.refactoring.participant.IMoveTopologyModelProperties;
import com.ibm.ccl.soa.deploy.ide.internal.refactoring.participant.MoveTopologyModelProvider;
import com.ibm.ccl.soa.deploy.ide.internal.refactoring.participant.operation.MoveTopologyOperation;

/**
 * 
 * 
 * 
 * <p>
 * The following properties are <b>required</b>. If not provided, then the model is not in a valid
 * state, and the operation will not be able to execute successfully.
 * </p>
 * <ul>
 * <li><b>topologies</b>:
 * 
 * </li>
 * <li><b>container</b>:
 * 
 * </li>
 * </ul>
 * 
 * @generated (mde.utilities.datamodels)
 */
public class MoveTopologyDescriptor {

	private ROTopologyModelManager modelManager = null;
	private final IDataModel model;

	/**
	 * Creates and returns an instance of the type-safe API datamodel.
	 * 
	 * @return An instance of the type-safe API datamodel.
	 * @generated (mde.utilities.datamodels)
	 */
	public static MoveTopologyDescriptor createModel() {
		IDataModel model = DataModelFactory.createDataModel(createDatamodelProvider());
		return new MoveTopologyDescriptor(model);
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
		return new MoveTopologyModelProvider();
	}

	/**
	 * Create a type-safe facade for the given datamodel.
	 * 
	 * @param mdl
	 *           The datamodel to provide a facade for.
	 * @generated (mde.utilities.datamodels)
	 */
	public MoveTopologyDescriptor(IDataModel mdl) {
		model = mdl;
	}

	/**
	 * 
	 * 
	 * <p>
	 * <b>[Required]</b>
	 * </p>
	 * 
	 * @param newContainer
	 *           The new value of the Container property.
	 * @generated (mde.utilities.datamodels)
	 */
	public void setContainer(String newContainer) {
		model.setProperty(IMoveTopologyModelProperties.CONTAINER, newContainer);
	}

	/**
	 * 
	 * 
	 * @return The value of the Container property.
	 * @generated (mde.utilities.datamodels)
	 */
	public String getContainer() {
		return (String) model.getProperty(IMoveTopologyModelProperties.CONTAINER);
	}

	/**
	 * Determine if the Container property meets all constraints required of it.
	 * 
	 * @return A status object indicating error or warning messages, if any, or OK if the Container
	 *         property is valid.
	 * @see #getContainer()
	 * @see #setContainer(String)
	 * @generated (mde.utilities.datamodels)
	 */
	public IStatus validateContainer() {
		return model.validateProperty(IMoveTopologyModelProperties.CONTAINER);
	}

	/**
	 * Determine the default value of the Container property.
	 * 
	 * @return The default value of the Container property.
	 * @see #getContainer()
	 * @see #setContainer(String)
	 * @generated (mde.utilities.datamodels)
	 */
	public String getDefaultContainer() {
		return (String) model
				.getDefaultProperty(IMoveTopologyModelProperties.CONTAINER);
	}

	/**
	 * Return the value of Topologies field.
	 * 
	 * @return The value of Topologies field.
	 * @generated (mde.utilities.datamodels)
	 */
	public IResource[] getTopologies() {
		return (IResource[]) model
				.getProperty(IMoveTopologyModelProperties.TOPOLOGIES);
	}

	/**
	 * 
	 * 
	 * <p>
	 * <b>[Required]</b>
	 * </p>
	 * 
	 * @param newTopologies
	 *           The new value for the reference.
	 * @generated (mde.utilities.datamodels)
	 */
	public void setTopologies(IResource[] newTopologies) {
		model.setProperty(IMoveTopologyModelProperties.TOPOLOGIES, newTopologies);
	}

	/**
	 * Determine if the Topologies property meets all constraints required of it.
	 * 
	 * @return A status object indicating error or warning messages, if any, or OK if the Topologies
	 *         property is valid.
	 * @see #getTopologies()
	 * @see #setTopologies(IResource[])
	 * @generated (mde.utilities.datamodels)
	 */
	public IStatus validateTopologies() {
		return model.validateProperty(IMoveTopologyModelProperties.TOPOLOGIES);

	}

	/**
	 * Determine the default value of the Topologies property.
	 * 
	 * @return The default value of the Topologies property.
	 * @see #getTopologies()
	 * @see #setTopologies(IResource[])
	 * @generated (mde.utilities.datamodels)
	 */
	protected IResource[] getDefaultTopologies() {
		return (IResource[]) model
				.getDefaultProperty(IMoveTopologyModelProperties.TOPOLOGIES);
	}

	/**
	 * Create and return an operation that is configured with the values from this datamodel.
	 * 
	 * @return A ready-to-run operation prepared with this model to carry out the operation.
	 * @generated (mde.utilities.datamodels)
	 */
	public IDataModelOperation createConfiguredOperation() {
		MoveTopologyOperation operation = new MoveTopologyOperation(
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
