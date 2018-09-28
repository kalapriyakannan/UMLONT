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

import com.ibm.ccl.soa.deploy.ide.internal.refactoring.change.IUpdateDiagramElementsChangeProperties;
import com.ibm.ccl.soa.deploy.ide.internal.refactoring.change.UpdateDiagramElementsChangeProvider;
import com.ibm.ccl.soa.deploy.ide.internal.refactoring.change.operation.UpdateDiagramElementsChangeOperation;

/**
 * 
 * Provides a type-specific implementation of the UpdateDiagramElementsChange model.
 * 
 * <p>
 * The following properties are <b>required</b>. If not provided, then the model is not in a valid
 * state, and the operation will not be able to execute successfully.
 * </p>
 * <ul>
 * <li><b>diagram</b>: The Diagram property. </li>
 * <li><b>source</b>: The Source property. </li>
 * <li><b>destination</b>: The Destination property. </li>
 * </ul>
 * 
 */
public class UpdateDiagramElementsChange extends DeployRefactoringChange {

	/**
	 * Creates and returns an instance of the type-safe API datamodel.
	 * 
	 * @return An instance of the type-safe API datamodel.
	 * @generated (mde.utilities.datamodels)
	 */
	public static UpdateDiagramElementsChange createModel() {
		IDataModel model = DataModelFactory.createDataModel(createDatamodelProvider());
		return new UpdateDiagramElementsChange(model);
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
		return new UpdateDiagramElementsChangeProvider();
	}

	/**
	 * Create a type-safe facade for the given datamodel.
	 * 
	 * @param mdl
	 *           The datamodel to provide a facade for.
	 * @generated (mde.utilities.datamodels)
	 */
	public UpdateDiagramElementsChange(IDataModel mdl) {
		super(mdl);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.ltk.core.refactoring.Change#getModifiedElement()
	 */
	@Override
	public Object getModifiedElement() {
		return ResourcesPlugin.getWorkspace().getRoot().getFile(getDiagram());
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.ltk.core.refactoring.Change#getName()
	 */
	@Override
	public String getName() {
		return "update element references to '" + getSource() + "'"; //$NON-NLS-1$ //$NON-NLS-2$
	}

	/**
	 * 
	 * 
	 * <p>
	 * <b>[Required]</b>
	 * </p>
	 * 
	 * @param newDiagram
	 *           The new value of the Diagram property.
	 * @generated (mde.utilities.datamodels)
	 */
	public void setDiagram(org.eclipse.core.runtime.IPath newDiagram) {
		getUnderlyingDataModel().setProperty(IUpdateDiagramElementsChangeProperties.DIAGRAM,
				newDiagram);
	}

	/**
	 * 
	 * 
	 * @return The value of the Diagram property.
	 * @generated (mde.utilities.datamodels)
	 */
	public org.eclipse.core.runtime.IPath getDiagram() {
		return (org.eclipse.core.runtime.IPath) getUnderlyingDataModel().getProperty(
				IUpdateDiagramElementsChangeProperties.DIAGRAM);
	}

	/**
	 * Determine if the Diagram property meets all constraints required of it.
	 * 
	 * @return A status object indicating error or warning messages, if any, or OK if the Diagram
	 *         property is valid.
	 * @see #getDiagram()
	 * @see #setDiagram(org.eclipse.core.runtime.IPath)
	 * @generated (mde.utilities.datamodels)
	 */
	public IStatus validateDiagram() {
		return getUnderlyingDataModel().validateProperty(
				IUpdateDiagramElementsChangeProperties.DIAGRAM);
	}

	/**
	 * Determine the default value of the Diagram property.
	 * 
	 * @return The default value of the Diagram property.
	 * @see #getDiagram()
	 * @see #setDiagram(org.eclipse.core.runtime.IPath)
	 * @generated (mde.utilities.datamodels)
	 */
	public org.eclipse.core.runtime.IPath getDefaultDiagram() {
		return (org.eclipse.core.runtime.IPath) getUnderlyingDataModel().getDefaultProperty(
				IUpdateDiagramElementsChangeProperties.DIAGRAM);
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
	public void setSource(org.eclipse.core.runtime.IPath newSource) {
		getUnderlyingDataModel()
				.setProperty(IUpdateDiagramElementsChangeProperties.SOURCE, newSource);
	}

	/**
	 * 
	 * 
	 * @return The value of the Source property.
	 * @generated (mde.utilities.datamodels)
	 */
	public org.eclipse.core.runtime.IPath getSource() {
		return (org.eclipse.core.runtime.IPath) getUnderlyingDataModel().getProperty(
				IUpdateDiagramElementsChangeProperties.SOURCE);
	}

	/**
	 * Determine if the Source property meets all constraints required of it.
	 * 
	 * @return A status object indicating error or warning messages, if any, or OK if the Source
	 *         property is valid.
	 * @see #getSource()
	 * @see #setSource(org.eclipse.core.runtime.IPath)
	 * @generated (mde.utilities.datamodels)
	 */
	public IStatus validateSource() {
		return getUnderlyingDataModel().validateProperty(
				IUpdateDiagramElementsChangeProperties.SOURCE);
	}

	/**
	 * Determine the default value of the Source property.
	 * 
	 * @return The default value of the Source property.
	 * @see #getSource()
	 * @see #setSource(org.eclipse.core.runtime.IPath)
	 * @generated (mde.utilities.datamodels)
	 */
	public org.eclipse.core.runtime.IPath getDefaultSource() {
		return (org.eclipse.core.runtime.IPath) getUnderlyingDataModel().getDefaultProperty(
				IUpdateDiagramElementsChangeProperties.SOURCE);
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
	public void setDestination(org.eclipse.core.runtime.IPath newDestination) {
		getUnderlyingDataModel().setProperty(IUpdateDiagramElementsChangeProperties.DESTINATION,
				newDestination);
	}

	/**
	 * 
	 * 
	 * @return The value of the Destination property.
	 * @generated (mde.utilities.datamodels)
	 */
	public org.eclipse.core.runtime.IPath getDestination() {
		return (org.eclipse.core.runtime.IPath) getUnderlyingDataModel().getProperty(
				IUpdateDiagramElementsChangeProperties.DESTINATION);
	}

	/**
	 * Determine if the Destination property meets all constraints required of it.
	 * 
	 * @return A status object indicating error or warning messages, if any, or OK if the Destination
	 *         property is valid.
	 * @see #getDestination()
	 * @see #setDestination(org.eclipse.core.runtime.IPath)
	 * @generated (mde.utilities.datamodels)
	 */
	public IStatus validateDestination() {
		return getUnderlyingDataModel().validateProperty(
				IUpdateDiagramElementsChangeProperties.DESTINATION);
	}

	/**
	 * Determine the default value of the Destination property.
	 * 
	 * @return The default value of the Destination property.
	 * @see #getDestination()
	 * @see #setDestination(org.eclipse.core.runtime.IPath)
	 * @generated (mde.utilities.datamodels)
	 */
	public org.eclipse.core.runtime.IPath getDefaultDestination() {
		return (org.eclipse.core.runtime.IPath) getUnderlyingDataModel().getDefaultProperty(
				IUpdateDiagramElementsChangeProperties.DESTINATION);
	}

	/**
	 * Create and return an operation that is configured with the values from this datamodel.
	 * 
	 * @return A ready-to-run operation prepared with this model to carry out the operation.
	 * @generated (mde.utilities.datamodels)
	 */
	public IDataModelOperation createConfiguredOperation() {
		UpdateDiagramElementsChangeOperation operation = new UpdateDiagramElementsChangeOperation(
				this);
		return operation;
	}
}
