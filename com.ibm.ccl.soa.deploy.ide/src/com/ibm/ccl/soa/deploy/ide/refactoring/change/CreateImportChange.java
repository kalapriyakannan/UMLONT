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

import com.ibm.ccl.soa.deploy.ide.internal.refactoring.change.CreateImportChangeProvider;
import com.ibm.ccl.soa.deploy.ide.internal.refactoring.change.ICreateImportChangeProperties;
import com.ibm.ccl.soa.deploy.ide.internal.refactoring.change.operation.CreateImportChangeOperation;

/**
 * 
 * Provides a type-specific implementation of the CreateImportChange model.
 * 
 * <p>
 * The following properties are <b>required</b>. If not provided, then the model is not in a valid
 * state, and the operation will not be able to execute successfully.
 * </p>
 * <ul>
 * <li><b>imports</b>: The Imports property. </li>
 * <li><b>imported</b>: The Imported property. </li>
 * </ul>
 * 
 */
public class CreateImportChange extends DeployRefactoringChange {

	/**
	 * Creates and returns an instance of the type-safe API datamodel.
	 * 
	 * @return An instance of the type-safe API datamodel.
	 * @generated (mde.utilities.datamodels)
	 */
	public static CreateImportChange createModel() {
		IDataModel model = DataModelFactory.createDataModel(createDatamodelProvider());
		return new CreateImportChange(model);
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
		return new CreateImportChangeProvider();
	}

	/**
	 * Create a type-safe facade for the given datamodel.
	 * 
	 * @param mdl
	 *           The datamodel to provide a facade for.
	 * @generated (mde.utilities.datamodels)
	 */
	public CreateImportChange(IDataModel mdl) {
		super(mdl);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.ltk.core.refactoring.Change#getModifiedElement()
	 */
	@Override
	public Object getModifiedElement() {
		return ResourcesPlugin.getWorkspace().getRoot().getFile(getImports());
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.ltk.core.refactoring.Change#getName()
	 */
	@Override
	public String getName() {
		return "create import of '" + getImported() + "'"; //$NON-NLS-1$ //$NON-NLS-2$
	}

	/**
	 * 
	 * 
	 * <p>
	 * <b>[Required]</b>
	 * </p>
	 * 
	 * @param newImports
	 *           The new value of the Imports property.
	 * @generated (mde.utilities.datamodels)
	 */
	public void setImports(org.eclipse.core.runtime.IPath newImports) {
		getUnderlyingDataModel().setProperty(ICreateImportChangeProperties.IMPORTS, newImports);
	}

	/**
	 * 
	 * 
	 * @return The value of the Imports property.
	 * @generated (mde.utilities.datamodels)
	 */
	public org.eclipse.core.runtime.IPath getImports() {
		return (org.eclipse.core.runtime.IPath) getUnderlyingDataModel().getProperty(
				ICreateImportChangeProperties.IMPORTS);
	}

	/**
	 * Determine if the Imports property meets all constraints required of it.
	 * 
	 * @return A status object indicating error or warning messages, if any, or OK if the Imports
	 *         property is valid.
	 * @see #getImports()
	 * @see #setImports(org.eclipse.core.runtime.IPath)
	 * @generated (mde.utilities.datamodels)
	 */
	public IStatus validateImports() {
		return getUnderlyingDataModel().validateProperty(ICreateImportChangeProperties.IMPORTS);
	}

	/**
	 * Determine the default value of the Imports property.
	 * 
	 * @return The default value of the Imports property.
	 * @see #getImports()
	 * @see #setImports(org.eclipse.core.runtime.IPath)
	 * @generated (mde.utilities.datamodels)
	 */
	public org.eclipse.core.runtime.IPath getDefaultImports() {
		return (org.eclipse.core.runtime.IPath) getUnderlyingDataModel().getDefaultProperty(
				ICreateImportChangeProperties.IMPORTS);
	}

	/**
	 * 
	 * 
	 * <p>
	 * <b>[Required]</b>
	 * </p>
	 * 
	 * @param newImported
	 *           The new value of the Imported property.
	 * @generated (mde.utilities.datamodels)
	 */
	public void setImported(org.eclipse.core.runtime.IPath newImported) {
		getUnderlyingDataModel().setProperty(ICreateImportChangeProperties.IMPORTED, newImported);
	}

	/**
	 * 
	 * 
	 * @return The value of the Imported property.
	 * @generated (mde.utilities.datamodels)
	 */
	public org.eclipse.core.runtime.IPath getImported() {
		return (org.eclipse.core.runtime.IPath) getUnderlyingDataModel().getProperty(
				ICreateImportChangeProperties.IMPORTED);
	}

	/**
	 * Determine if the Imported property meets all constraints required of it.
	 * 
	 * @return A status object indicating error or warning messages, if any, or OK if the Imported
	 *         property is valid.
	 * @see #getImported()
	 * @see #setImported(org.eclipse.core.runtime.IPath)
	 * @generated (mde.utilities.datamodels)
	 */
	public IStatus validateImported() {
		return getUnderlyingDataModel().validateProperty(ICreateImportChangeProperties.IMPORTED);
	}

	/**
	 * Determine the default value of the Imported property.
	 * 
	 * @return The default value of the Imported property.
	 * @see #getImported()
	 * @see #setImported(org.eclipse.core.runtime.IPath)
	 * @generated (mde.utilities.datamodels)
	 */
	public org.eclipse.core.runtime.IPath getDefaultImported() {
		return (org.eclipse.core.runtime.IPath) getUnderlyingDataModel().getDefaultProperty(
				ICreateImportChangeProperties.IMPORTED);
	}

	/**
	 * Create and return an operation that is configured with the values from this datamodel.
	 * 
	 * @return A ready-to-run operation prepared with this model to carry out the operation.
	 * @generated (mde.utilities.datamodels)
	 */
	public IDataModelOperation createConfiguredOperation() {
		CreateImportChangeOperation operation = new CreateImportChangeOperation(this);
		return operation;
	}
}
