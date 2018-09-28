/***************************************************************************************************
 * Copyright (c) 2006 IBM Corporation. Licensed Material - Property of IBM. All rights reserved. US
 * Government Users Restricted Rights - Use, duplication or disclosure restricted by GSA ADP
 * Schedule Contract with IBM Corp.
 * 
 * Contributors: IBM Corporation - initial API and implementation
 **************************************************************************************************/
package com.ibm.ccl.soa.deploy.ide.refactoring.change;

import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.wst.common.frameworks.datamodel.DataModelFactory;
import org.eclipse.wst.common.frameworks.datamodel.IDataModel;
import org.eclipse.wst.common.frameworks.datamodel.IDataModelOperation;
import org.eclipse.wst.common.frameworks.datamodel.IDataModelProvider;

import com.ibm.ccl.soa.deploy.ide.internal.refactoring.change.IUpdateTopologyImportsChangeProperties;
import com.ibm.ccl.soa.deploy.ide.internal.refactoring.change.UpdateTopologyImportsChangeProvider;
import com.ibm.ccl.soa.deploy.ide.internal.refactoring.change.operation.UpdateTopologyImportsChangeOperation;

/**
 * 
 * Provides a type-specific implementation of the UpdateTopologyImportsChange model.
 * 
 * <p>
 * The following properties are <b>required</b>. If not provided, then the model is not in a valid
 * state, and the operation will not be able to execute successfully.
 * </p>
 * <ul>
 * <li><b>model</b>: The Model property. </li>
 * <li><b>source</b>: The Source property. </li>
 * <li><b>destination</b>: The Destination property. </li>
 * </ul>
 * 
 */
public class UpdateTopologyImportsChange extends DeployRefactoringChange {

	/**
	 * Creates and returns an instance of the type-safe API datamodel.
	 * 
	 * @return An instance of the type-safe API datamodel.
	 * @generated (mde.utilities.datamodels)
	 */
	public static UpdateTopologyImportsChange createModel() {
		IDataModel model = DataModelFactory.createDataModel(createDatamodelProvider());
		return new UpdateTopologyImportsChange(model);
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
		return new UpdateTopologyImportsChangeProvider();
	}

	/**
	 * Create a type-safe facade for the given datamodel.
	 * 
	 * @param mdl
	 *           The datamodel to provide a facade for.
	 * @generated (mde.utilities.datamodels)
	 */
	public UpdateTopologyImportsChange(IDataModel mdl) {
		super(mdl);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.ltk.core.refactoring.Change#getModifiedElement()
	 */
	@Override
	public Object getModifiedElement() {
		return ResourcesPlugin.getWorkspace().getRoot().getFile(getModel());
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.ltk.core.refactoring.Change#getName()
	 */
	@Override
	public String getName() {
		return "update imports of '" + getSource() + "' to '" + getDestination() + "'"; //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
	}

	/**
	 * 
	 * 
	 * <p>
	 * <b>[Required]</b>
	 * </p>
	 * 
	 * @param newModel
	 *           The new value of the Model property.
	 * @generated (mde.utilities.datamodels)
	 */
	public void setModel(org.eclipse.core.runtime.IPath newModel) {
		getUnderlyingDataModel().setProperty(IUpdateTopologyImportsChangeProperties.MODEL, newModel);
	}

	/**
	 * 
	 * 
	 * @return The value of the Model property.
	 * @generated (mde.utilities.datamodels)
	 */
	public org.eclipse.core.runtime.IPath getModel() {
		return (org.eclipse.core.runtime.IPath) getUnderlyingDataModel().getProperty(
				IUpdateTopologyImportsChangeProperties.MODEL);
	}

	/**
	 * Determine if the Model property meets all constraints required of it.
	 * 
	 * @return A status object indicating error or warning messages, if any, or OK if the Model
	 *         property is valid.
	 * @see #getModel()
	 * @see #setModel(org.eclipse.core.runtime.IPath)
	 * @generated (mde.utilities.datamodels)
	 */
	public IStatus validateModel() {
		return getUnderlyingDataModel()
				.validateProperty(IUpdateTopologyImportsChangeProperties.MODEL);
	}

	/**
	 * Determine the default value of the Model property.
	 * 
	 * @return The default value of the Model property.
	 * @see #getModel()
	 * @see #setModel(org.eclipse.core.runtime.IPath)
	 * @generated (mde.utilities.datamodels)
	 */
	public org.eclipse.core.runtime.IPath getDefaultModel() {
		return (org.eclipse.core.runtime.IPath) getUnderlyingDataModel().getDefaultProperty(
				IUpdateTopologyImportsChangeProperties.MODEL);
	}

	/**
	 * 
	 * 
	 * <p>
	 * <b>[Required]</b>
	 * </p>
	 * 
	 * @param newSource
	 *           The new value of the Source property.
	 * @generated (mde.utilities.datamodels)
	 */
	public void setSource(String newSource) {
		getUnderlyingDataModel()
				.setProperty(IUpdateTopologyImportsChangeProperties.SOURCE, newSource);
	}

	/**
	 * 
	 * 
	 * @return The value of the Source property.
	 * @generated (mde.utilities.datamodels)
	 */
	public String getSource() {
		return (String) getUnderlyingDataModel().getProperty(
				IUpdateTopologyImportsChangeProperties.SOURCE);
	}

	/**
	 * Determine if the Source property meets all constraints required of it.
	 * 
	 * @return A status object indicating error or warning messages, if any, or OK if the Source
	 *         property is valid.
	 * @see #getSource()
	 * @see #setSource(String)
	 * @generated (mde.utilities.datamodels)
	 */
	public IStatus validateSource() {
		return getUnderlyingDataModel().validateProperty(
				IUpdateTopologyImportsChangeProperties.SOURCE);
	}

	/**
	 * Determine the default value of the Source property.
	 * 
	 * @return The default value of the Source property.
	 * @see #getSource()
	 * @see #setSource(String)
	 * @generated (mde.utilities.datamodels)
	 */
	public String getDefaultSource() {
		return (String) getUnderlyingDataModel().getDefaultProperty(
				IUpdateTopologyImportsChangeProperties.SOURCE);
	}

	/**
	 * 
	 * 
	 * <p>
	 * <b>[Required]</b>
	 * </p>
	 * 
	 * @param newDestination
	 *           The new value of the Destination property.
	 * @generated (mde.utilities.datamodels)
	 */
	public void setDestination(String newDestination) {
		getUnderlyingDataModel().setProperty(IUpdateTopologyImportsChangeProperties.DESTINATION,
				newDestination);
	}

	/**
	 * 
	 * 
	 * @return The value of the Destination property.
	 * @generated (mde.utilities.datamodels)
	 */
	public String getDestination() {
		return (String) getUnderlyingDataModel().getProperty(
				IUpdateTopologyImportsChangeProperties.DESTINATION);
	}

	/**
	 * Determine if the Destination property meets all constraints required of it.
	 * 
	 * @return A status object indicating error or warning messages, if any, or OK if the Destination
	 *         property is valid.
	 * @see #getDestination()
	 * @see #setDestination(String)
	 * @generated (mde.utilities.datamodels)
	 */
	public IStatus validateDestination() {
		return getUnderlyingDataModel().validateProperty(
				IUpdateTopologyImportsChangeProperties.DESTINATION);
	}

	/**
	 * Determine the default value of the Destination property.
	 * 
	 * @return The default value of the Destination property.
	 * @see #getDestination()
	 * @see #setDestination(String)
	 * @generated (mde.utilities.datamodels)
	 */
	public String getDefaultDestination() {
		return (String) getUnderlyingDataModel().getDefaultProperty(
				IUpdateTopologyImportsChangeProperties.DESTINATION);
	}

	/**
	 * Create and return an operation that is configured with the values from this datamodel.
	 * 
	 * @return A ready-to-run operation prepared with this model to carry out the operation.
	 * @generated (mde.utilities.datamodels)
	 */
	public IDataModelOperation createConfiguredOperation() {
		UpdateTopologyImportsChangeOperation operation = new UpdateTopologyImportsChangeOperation(
				this);
		return operation;
	}
}
