/***************************************************************************************************
 * Copyright (c) 2006 IBM Corporation. Licensed Material - Property of IBM. All rights reserved. US
 * Government Users Restricted Rights - Use, duplication or disclosure restricted by GSA ADP
 * Schedule Contract with IBM Corp.
 * 
 * Contributors: IBM Corporation - initial API and implementation
 **************************************************************************************************/
package com.ibm.ccl.soa.deploy.core.internal.datamodels;

import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.resources.IContainer;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.wst.common.frameworks.datamodel.AbstractDataModelOperation;
import org.eclipse.wst.common.frameworks.datamodel.IDataModel;

import com.ibm.ccl.soa.deploy.core.DeployCorePlugin;
import com.ibm.ccl.soa.deploy.core.datamodels.CreateNamespaceDataModel;
import com.ibm.ccl.soa.deploy.core.namespace.INamespaceFragment;
import com.ibm.ccl.soa.deploy.core.namespace.NamespaceCore;

/**
 * 
 * This data model is used to create a new namespace within a project in the workspace.
 * 
 * <p>
 * Clients should use {@link CreateNamespaceDataModel#createConfiguredOperation()} to create an
 * instance of this operation, configured with the necessary model properties.
 * </p>
 * 
 * @see org.eclipse.wst.common.frameworks.datamodel.AbstractDataModelOperation
 * @see com.ibm.ccl.soa.deploy.core.datamodels.CreateNamespaceDataModel
 * @generated (mde.utilities.datamodels)
 */
public class CreateNamespaceDataModelOperation extends AbstractDataModelOperation implements
		ICreateNamespaceDataModelProperties {

	private CreateNamespaceDataModel typesafeModel;

	/**
	 * Construct an operation pre-configured with the given data model.
	 * 
	 * @param dMdl
	 *           The datamodel to use when executing this operation.
	 * @generated (mde.utilities.datamodels)
	 */
	public CreateNamespaceDataModelOperation(IDataModel dMdl) {
		super(dMdl);
		setTypeSafeModel(new CreateNamespaceDataModel(dMdl));
	}

	/**
	 * Construct an operation pre-configured with the given type-safe data model.
	 * 
	 * @param tsMdl
	 *           The type-safe datamodel to use when executing this operation.
	 * @generated (mde.utilities.datamodels)
	 */
	public CreateNamespaceDataModelOperation(CreateNamespaceDataModel tsMdl) {
		super(tsMdl.getUnderlyingDataModel());
		setTypeSafeModel(tsMdl);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.core.commands.operations.IUndoableOperation#execute(IProgressMonitor,
	 *      IAdaptable)
	 */
	public IStatus execute(IProgressMonitor monitor, IAdaptable info) throws ExecutionException {

		IContainer src = typesafeModel.getSourceContainer();
		IContainer container = typesafeModel.getNamespaceContainer();

		try {
			NamespaceCore.createRoot(src, monitor);
			INamespaceFragment fragment = (INamespaceFragment) NamespaceCore.create(container);
			fragment.create(monitor);
		} catch (CoreException ex) {
			return new Status(IStatus.ERROR, DeployCorePlugin.PLUGIN_ID, ex.toString(), ex);
		}

		return Status.OK_STATUS;
	}

	/**
	 * This operation can accept a typesafe model that provides a more usable interface to the
	 * {@link org.eclipse.wst.common.frameworks.datamodel.IDataModel}.
	 * 
	 * @param mdl
	 *           The typesafe model that will drive this operation.
	 * @generated (mde.utilities.datamodels)
	 */
	private void setTypeSafeModel(CreateNamespaceDataModel mdl) {
		typesafeModel = mdl;
	}
}
