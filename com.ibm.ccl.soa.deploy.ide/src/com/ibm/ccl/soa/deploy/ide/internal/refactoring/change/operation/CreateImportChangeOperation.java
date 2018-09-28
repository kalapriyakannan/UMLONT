/***************************************************************************************************
 * Copyright (c) 2006 IBM Corporation. Licensed Material - Property of IBM. All rights reserved. US
 * Government Users Restricted Rights - Use, duplication or disclosure restricted by GSA ADP
 * Schedule Contract with IBM Corp.
 * 
 * Contributors: IBM Corporation - initial API and implementation
 **************************************************************************************************/
package com.ibm.ccl.soa.deploy.ide.internal.refactoring.change.operation;

import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.wst.common.frameworks.datamodel.IDataModel;

import com.ibm.ccl.soa.deploy.core.Topology;
import com.ibm.ccl.soa.deploy.core.util.TopologyUtil;
import com.ibm.ccl.soa.deploy.ide.internal.refactoring.change.ICreateImportChangeProperties;
import com.ibm.ccl.soa.deploy.ide.refactoring.change.CreateImportChange;

/**
 * 
 * Provides a type-specific implementation of the CreateImportChange model.
 * 
 * <p>
 * Clients should use {@link CreateImportChange#createConfiguredOperation()} to create an instance
 * of this operation, configured with the necessary model properties.
 * </p>
 * 
 * @see com.ibm.ccl.soa.deploy.ide.internal.refactoring.change.operation.DeployRefactoringChangeOperation
 * @see com.ibm.ccl.soa.deploy.ide.refactoring.change.CreateImportChange
 * @generated (mde.utilities.datamodels)
 */
public class CreateImportChangeOperation extends DeployRefactoringChangeOperation implements
		ICreateImportChangeProperties {

	private CreateImportChange typesafeModel;

	/**
	 * Construct an operation pre-configured with the given data model.
	 * 
	 * @param dMdl
	 *           The datamodel to use when executing this operation.
	 * @generated (mde.utilities.datamodels)
	 */
	public CreateImportChangeOperation(IDataModel dMdl) {
		super(dMdl);
		setTypeSafeModel(new CreateImportChange(dMdl));
	}

	/**
	 * Construct an operation pre-configured with the given type-safe data model.
	 * 
	 * @param tsMdl
	 *           The type-safe datamodel to use when executing this operation.
	 * @generated (mde.utilities.datamodels)
	 */
	public CreateImportChangeOperation(CreateImportChange tsMdl) {
		super(tsMdl);
		setTypeSafeModel(tsMdl);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.ibm.ccl.soa.infrastructure.operations.AbstractEMFScribblerOperation#doExecute(IProgressMonitor)
	 */
	protected IStatus doExecute(IProgressMonitor monitor) throws ExecutionException {

		try {

			IFile importTopologyFile = ResourcesPlugin.getWorkspace().getRoot().getFile(
					typesafeModel.getImported());
			IFile targetTopologyFile = ResourcesPlugin.getWorkspace().getRoot().getFile(
					typesafeModel.getImports());
			Topology importTopology = getTopology(importTopologyFile);
			Topology targetTopology = getTopology(targetTopologyFile);
			TopologyUtil.importTopology(importTopology, targetTopology);

		} catch (CoreException ex) {
			throw new ExecutionException(ex.toString(), ex);
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
	private void setTypeSafeModel(CreateImportChange mdl) {
		typesafeModel = mdl;
	}
}
