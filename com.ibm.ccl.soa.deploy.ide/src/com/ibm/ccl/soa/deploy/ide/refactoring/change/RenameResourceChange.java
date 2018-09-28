/***************************************************************************************************
 * Copyright (c) 2006 IBM Corporation. Licensed Material - Property of IBM. All rights reserved. US
 * Government Users Restricted Rights - Use, duplication or disclosure restricted by GSA ADP
 * Schedule Contract with IBM Corp.
 * 
 * Contributors: IBM Corporation - initial API and implementation
 **************************************************************************************************/
package com.ibm.ccl.soa.deploy.ide.refactoring.change;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.wst.common.frameworks.datamodel.DataModelFactory;
import org.eclipse.wst.common.frameworks.datamodel.IDataModel;
import org.eclipse.wst.common.frameworks.datamodel.IDataModelOperation;
import org.eclipse.wst.common.frameworks.datamodel.IDataModelProvider;

import com.ibm.ccl.soa.deploy.ide.internal.refactoring.change.IRenameResourceChangeProperties;
import com.ibm.ccl.soa.deploy.ide.internal.refactoring.change.RenameResourceChangeProvider;
import com.ibm.ccl.soa.deploy.ide.internal.refactoring.change.operation.MoveResourcesDataModelOperation;

/**
 * 
 * Provides a type-specific implementation of the RenameResourceChange model.
 * 
 * <p>
 * The following properties are <b>required</b>. If not provided, then the model is not in a valid
 * state, and the operation will not be able to execute successfully.
 * </p>
 * <ul>
 * <li><b>source</b>: The Source property. </li>
 * <li><b>destination</b>: The Destination property. </li>
 * </ul>
 * 
 */
public class RenameResourceChange extends DeployRefactoringChange {

	/**
	 * Creates and returns an instance of the type-safe API datamodel.
	 * 
	 * @return An instance of the type-safe API datamodel.
	 * @generated (mde.utilities.datamodels)
	 */
	public static RenameResourceChange createModel() {
		IDataModel model = DataModelFactory.createDataModel(createDatamodelProvider());
		return new RenameResourceChange(model);
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
		return new RenameResourceChangeProvider();
	}

	/**
	 * Create a type-safe facade for the given datamodel.
	 * 
	 * @param mdl
	 *           The datamodel to provide a facade for.
	 * @generated (mde.utilities.datamodels)
	 */
	public RenameResourceChange(IDataModel mdl) {
		super(mdl);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.ibm.ccl.soa.deploy.ide.refactoring.change.DeployRefactoringChange#getAffectedObjects()
	 */
	@Override
	public Object[] getAffectedObjects() {
		return new Object[] { getModifiedElement(),
				ResourcesPlugin.getWorkspace().getRoot().getFile(getDestination()) };
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.ltk.core.refactoring.Change#getModifiedElement()
	 */
	@Override
	public Object getModifiedElement() {
		return ResourcesPlugin.getWorkspace().getRoot().getFile(getSource());
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.ltk.core.refactoring.Change#getName()
	 */
	@Override
	public String getName() {
		return "rename to '" + getDestination().lastSegment() + "'"; //$NON-NLS-1$ //$NON-NLS-2$
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
		getUnderlyingDataModel().setProperty(IRenameResourceChangeProperties.SOURCE, newSource);
	}

	/**
	 * 
	 * 
	 * @return The value of the Source property.
	 * @generated (mde.utilities.datamodels)
	 */
	public org.eclipse.core.runtime.IPath getSource() {
		return (org.eclipse.core.runtime.IPath) getUnderlyingDataModel().getProperty(
				IRenameResourceChangeProperties.SOURCE);
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
		return getUnderlyingDataModel().validateProperty(IRenameResourceChangeProperties.SOURCE);
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
				IRenameResourceChangeProperties.SOURCE);
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
		getUnderlyingDataModel().setProperty(IRenameResourceChangeProperties.DESTINATION,
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
				IRenameResourceChangeProperties.DESTINATION);
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
		return getUnderlyingDataModel().validateProperty(IRenameResourceChangeProperties.DESTINATION);
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
				IRenameResourceChangeProperties.DESTINATION);
	}

	/**
	 * Create and return an operation that is configured with the values from this datamodel.
	 * 
	 * @return A ready-to-run operation prepared with this model to carry out the operation.
	 * @generated (mde.utilities.datamodels)
	 */
	public IDataModelOperation createConfiguredOperation() {
		IFile source = ResourcesPlugin.getWorkspace().getRoot().getFile(getSource());
		IFile destination = ResourcesPlugin.getWorkspace().getRoot().getFile(getDestination());
		MoveResourcesDataModelOperation operation = new MoveResourcesDataModelOperation(super
				.getUnderlyingDataModel(), source, destination.getFullPath(), getName());
		return operation;
	}
}
