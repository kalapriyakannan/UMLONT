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

import com.ibm.ccl.soa.deploy.ide.internal.refactoring.change.CreateDiagramChangeProvider;
import com.ibm.ccl.soa.deploy.ide.internal.refactoring.change.ICreateDiagramChangeProperties;
import com.ibm.ccl.soa.deploy.ide.internal.refactoring.change.operation.CreateDiagramChangeOperation;

/**
 * 
 * Provides a type-specific implementation of the CreateDiagramChange model.
 * 
 * <p>
 * The following properties are <b>required</b>. If not provided, then the model is not in a valid
 * state, and the operation will not be able to execute successfully.
 * </p>
 * <ul>
 * <li><b>diagram</b>: The Diagram property. </li>
 * <li><b>model</b>: The Model property. </li>
 * </ul>
 * 
 */
public class CreateDiagramChange extends DeployRefactoringChange {

	/**
	 * Creates and returns an instance of the type-safe API datamodel.
	 * 
	 * @return An instance of the type-safe API datamodel.
	 * @generated (mde.utilities.datamodels)
	 */
	public static CreateDiagramChange createModel() {
		IDataModel model = DataModelFactory.createDataModel(createDatamodelProvider());
		return new CreateDiagramChange(model);
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
		return new CreateDiagramChangeProvider();
	}

	/**
	 * Create a type-safe facade for the given datamodel.
	 * 
	 * @param mdl
	 *           The datamodel to provide a facade for.
	 * 
	 */
	public CreateDiagramChange(IDataModel mdl) {
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
		return "create '" + getDiagram() + "'"; //$NON-NLS-1$ //$NON-NLS-2$
	}

	/**
	 * {@code IPath} representing the name and location where the new {@code Diagram}
	 * {@code Resource} will be created.
	 * 
	 * <p>
	 * <b>[Required]</b>
	 * </p>
	 * 
	 * @param newDiagram
	 *           The new value of the Diagram property.
	 * 
	 */
	public void setDiagram(org.eclipse.core.runtime.IPath newDiagram) {
		getUnderlyingDataModel().setProperty(ICreateDiagramChangeProperties.DIAGRAM, newDiagram);
	}

	/**
	 * {@code IPath} representing the name and location where the new {@code Diagram}
	 * {@code Resource} will be created.
	 * 
	 * @return The value of the Diagram property.
	 * 
	 */
	public org.eclipse.core.runtime.IPath getDiagram() {
		return (org.eclipse.core.runtime.IPath) getUnderlyingDataModel().getProperty(
				ICreateDiagramChangeProperties.DIAGRAM);
	}

	/**
	 * Determine if the Diagram property meets all constraints required of it.
	 * 
	 * @return A status object indicating error or warning messages, if any, or OK if the Diagram
	 *         property is valid.
	 * @see #getDiagram()
	 * @see #setDiagram(org.eclipse.core.runtime.IPath)
	 * 
	 */
	public IStatus validateDiagram() {
		return getUnderlyingDataModel().validateProperty(ICreateDiagramChangeProperties.DIAGRAM);
	}

	/**
	 * Determine the default value of the Diagram property.
	 * 
	 * @return The default value of the Diagram property.
	 * @see #getDiagram()
	 * @see #setDiagram(org.eclipse.core.runtime.IPath)
	 * 
	 */
	public org.eclipse.core.runtime.IPath getDefaultDiagram() {
		return (org.eclipse.core.runtime.IPath) getUnderlyingDataModel().getDefaultProperty(
				ICreateDiagramChangeProperties.DIAGRAM);
	}

	/**
	 * {@code IPath} representing the location of the existing {@code Topology} model
	 * {@code Resource} that the new {@code Diagram} will represent.
	 * 
	 * <p>
	 * <b>[Required]</b>
	 * </p>
	 * 
	 * @param newModel
	 *           The new value of the Model property.
	 * 
	 */
	public void setModel(org.eclipse.core.runtime.IPath newModel) {
		getUnderlyingDataModel().setProperty(ICreateDiagramChangeProperties.MODEL, newModel);
	}

	/**
	 * {@code IPath} representing the location of the existing {@code Topology} model
	 * {@code Resource} that the new {@code Diagram} will represent.
	 * 
	 * @return The value of the Model property.
	 * 
	 */
	public org.eclipse.core.runtime.IPath getModel() {
		return (org.eclipse.core.runtime.IPath) getUnderlyingDataModel().getProperty(
				ICreateDiagramChangeProperties.MODEL);
	}

	/**
	 * Determine if the Model property meets all constraints required of it.
	 * 
	 * @return A status object indicating error or warning messages, if any, or OK if the Model
	 *         property is valid.
	 * @see #getModel()
	 * @see #setModel(org.eclipse.core.runtime.IPath)
	 * 
	 */
	public IStatus validateModel() {
		return getUnderlyingDataModel().validateProperty(ICreateDiagramChangeProperties.MODEL);
	}

	/**
	 * Determine the default value of the Model property.
	 * 
	 * @return The default value of the Model property.
	 * @see #getModel()
	 * @see #setModel(org.eclipse.core.runtime.IPath)
	 * 
	 */
	public org.eclipse.core.runtime.IPath getDefaultModel() {
		return (org.eclipse.core.runtime.IPath) getUnderlyingDataModel().getDefaultProperty(
				ICreateDiagramChangeProperties.MODEL);
	}

	/**
	 * Create and return an operation that is configured with the values from this datamodel.
	 * 
	 * @return A ready-to-run operation prepared with this model to carry out the operation.
	 * 
	 */
	public IDataModelOperation createConfiguredOperation() {
		CreateDiagramChangeOperation operation = new CreateDiagramChangeOperation(this);
		return operation;
	}

}
