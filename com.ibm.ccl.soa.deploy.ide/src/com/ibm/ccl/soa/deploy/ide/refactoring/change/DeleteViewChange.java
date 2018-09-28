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
import org.eclipse.core.runtime.Path;
import org.eclipse.wst.common.frameworks.datamodel.DataModelFactory;
import org.eclipse.wst.common.frameworks.datamodel.IDataModel;
import org.eclipse.wst.common.frameworks.datamodel.IDataModelOperation;
import org.eclipse.wst.common.frameworks.datamodel.IDataModelProvider;

import com.ibm.ccl.soa.deploy.ide.internal.refactoring.change.DeleteViewChangeProvider;
import com.ibm.ccl.soa.deploy.ide.internal.refactoring.change.IDeleteViewChangeProperties;
import com.ibm.ccl.soa.deploy.ide.internal.refactoring.change.operation.DeleteViewChangeOperation;

/**
 * 
 * Provides a type-specific implementation of the DeleteViewChange model.
 * 
 * <p>
 * The following properties are <b>required</b>. If not provided, then the model is not in a valid
 * state, and the operation will not be able to execute successfully.
 * </p>
 * <ul>
 * <li><b>view</b>: The View property. </li>
 * </ul>
 * 
 */
public class DeleteViewChange extends DeployRefactoringChange {

	/**
	 * Creates and returns an instance of the type-safe API datamodel.
	 * 
	 * @return An instance of the type-safe API datamodel.
	 * @generated (mde.utilities.datamodels)
	 */
	public static DeleteViewChange createModel() {
		IDataModel model = DataModelFactory.createDataModel(createDatamodelProvider());
		return new DeleteViewChange(model);
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
		return new DeleteViewChangeProvider();
	}

	/**
	 * Create a type-safe facade for the given datamodel.
	 * 
	 * @param mdl
	 *           The datamodel to provide a facade for.
	 * @generated (mde.utilities.datamodels)
	 */
	public DeleteViewChange(IDataModel mdl) {
		super(mdl);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.ltk.core.refactoring.Change#getModifiedElement()
	 */
	@Override
	public Object getModifiedElement() {
		return ResourcesPlugin.getWorkspace().getRoot().getFile(
				new Path(getView().toPlatformString(true)));
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.ltk.core.refactoring.Change#getName()
	 */
	@Override
	public String getName() {
		return "delete view '" + getView().fragment() + "'"; //$NON-NLS-1$ //$NON-NLS-2$
	}

	/**
	 * 
	 * 
	 * <p>
	 * <b>[Required]</b>
	 * </p>
	 * 
	 * @param newView
	 *           The new value of the View property.
	 * @generated (mde.utilities.datamodels)
	 */
	public void setView(org.eclipse.emf.common.util.URI newView) {
		getUnderlyingDataModel().setProperty(IDeleteViewChangeProperties.VIEW, newView);
	}

	/**
	 * 
	 * 
	 * @return The value of the View property.
	 * @generated (mde.utilities.datamodels)
	 */
	public org.eclipse.emf.common.util.URI getView() {
		return (org.eclipse.emf.common.util.URI) getUnderlyingDataModel().getProperty(
				IDeleteViewChangeProperties.VIEW);
	}

	/**
	 * Determine if the View property meets all constraints required of it.
	 * 
	 * @return A status object indicating error or warning messages, if any, or OK if the View
	 *         property is valid.
	 * @see #getView()
	 * @see #setView(org.eclipse.emf.common.util.URI)
	 * @generated (mde.utilities.datamodels)
	 */
	public IStatus validateView() {
		return getUnderlyingDataModel().validateProperty(IDeleteViewChangeProperties.VIEW);
	}

	/**
	 * Determine the default value of the View property.
	 * 
	 * @return The default value of the View property.
	 * @see #getView()
	 * @see #setView(org.eclipse.emf.common.util.URI)
	 * @generated (mde.utilities.datamodels)
	 */
	public org.eclipse.emf.common.util.URI getDefaultView() {
		return (org.eclipse.emf.common.util.URI) getUnderlyingDataModel().getDefaultProperty(
				IDeleteViewChangeProperties.VIEW);
	}

	/**
	 * Create and return an operation that is configured with the values from this datamodel.
	 * 
	 * @return A ready-to-run operation prepared with this model to carry out the operation.
	 * @generated (mde.utilities.datamodels)
	 */
	public IDataModelOperation createConfiguredOperation() {
		DeleteViewChangeOperation operation = new DeleteViewChangeOperation(this);
		return operation;
	}

}
