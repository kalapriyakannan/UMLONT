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
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.wst.common.frameworks.datamodel.IDataModel;

import com.ibm.ccl.soa.deploy.core.Import;
import com.ibm.ccl.soa.deploy.core.Topology;
import com.ibm.ccl.soa.deploy.ide.internal.refactoring.change.IDeleteImportChangeProperties;
import com.ibm.ccl.soa.deploy.ide.refactoring.change.DeleteImportChange;
import com.ibm.ccl.soa.deploy.ide.refactoring.change.DeleteTopologyChange;

/**
 * 
 * Provides a type-specific implementation of the DeleteImportChange model.
 * 
 * <p>
 * Clients should use {@link DeleteTopologyChange#createConfiguredOperation()} to create an instance
 * of this operation, configured with the necessary model properties.
 * </p>
 * 
 * @see com.ibm.ccl.soa.deploy.ide.internal.refactoring.change.operation.DeployRefactoringChangeOperation
 * @see com.ibm.ccl.soa.deploy.ide.refactoring.change.DeleteTopologyChange
 * @generated (mde.utilities.datamodels)
 */
public class DeleteImportChangeOperation extends DeployRefactoringChangeOperation implements
		IDeleteImportChangeProperties {

	private DeleteImportChange typesafeModel;

	/**
	 * Construct an operation pre-configured with the given data model.
	 * 
	 * @param dMdl
	 *           The datamodel to use when executing this operation.
	 * @generated (mde.utilities.datamodels)
	 */
	public DeleteImportChangeOperation(IDataModel dMdl) {
		super(dMdl);
		setTypeSafeModel(new DeleteImportChange(dMdl));
	}

	/**
	 * Construct an operation pre-configured with the given type-safe data model.
	 * 
	 * @param tsMdl
	 *           The type-safe datamodel to use when executing this operation.
	 * @generated (mde.utilities.datamodels)
	 */
	public DeleteImportChangeOperation(DeleteImportChange tsMdl) {
		super(tsMdl);
		setTypeSafeModel(tsMdl);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.core.commands.operations.IUndoableOperation#execute(IProgressMonitor,
	 *      IAdaptable)
	 */
	protected IStatus doExecute(IProgressMonitor monitor) throws ExecutionException {

		try {

			IFile topologyFile = typesafeModel.getTopology();

			if (topologyFile.isAccessible()) {
				Topology topology = getTopology(topologyFile);
				Topology importedTopology = getTopology(typesafeModel.getImportedTopology());
				Import anImport = topology.getImport(importedTopology.getNamespace(), importedTopology
						.getName());
				topology.getImports().remove(anImport);
			}

		} catch (CoreException ex) {
			throw new ExecutionException(ex.toString(), ex);
		} finally {
			if (typesafeModel != null) {
				typesafeModel.dispose();
			}
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
	private void setTypeSafeModel(DeleteImportChange mdl) {
		typesafeModel = mdl;
	}
}
