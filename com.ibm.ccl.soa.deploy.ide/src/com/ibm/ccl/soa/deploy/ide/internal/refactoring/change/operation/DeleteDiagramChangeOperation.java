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
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.wst.common.frameworks.datamodel.IDataModel;

import com.ibm.ccl.soa.deploy.ide.internal.refactoring.change.IDeleteDiagramChangeProperties;
import com.ibm.ccl.soa.deploy.ide.refactoring.change.DeleteDiagramChange;
import com.ibm.ccl.soa.deploy.ide.refactoring.change.DeleteTopologyChange;
import com.ibm.ccl.soa.infrastructure.emf.EditModelException;
import com.ibm.ccl.soa.infrastructure.emf.IEditModelScribbler;

/**
 * 
 * Provides a type-specific implementation of the DeleteDiagramChange model.
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
public class DeleteDiagramChangeOperation extends DeployRefactoringChangeOperation implements
		IDeleteDiagramChangeProperties {

	private DeleteDiagramChange typesafeModel;

	/**
	 * Construct an operation pre-configured with the given data model.
	 * 
	 * @param dMdl
	 *           The datamodel to use when executing this operation.
	 * @generated (mde.utilities.datamodels)
	 */
	public DeleteDiagramChangeOperation(IDataModel dMdl) {
		super(dMdl);
		setTypeSafeModel(new DeleteDiagramChange(dMdl));
	}

	/**
	 * Construct an operation pre-configured with the given type-safe data model.
	 * 
	 * @param tsMdl
	 *           The type-safe datamodel to use when executing this operation.
	 * @generated (mde.utilities.datamodels)
	 */
	public DeleteDiagramChangeOperation(DeleteDiagramChange tsMdl) {
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

			IFile diagramFile = ResourcesPlugin.getWorkspace().getRoot().getFile(
					typesafeModel.getDiagram());

			IEditModelScribbler scribbler = getEditModelScribbler();
			scribbler.deleteResource(diagramFile, monitor);

		} catch (EditModelException ex) {
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
	private void setTypeSafeModel(DeleteDiagramChange mdl) {
		typesafeModel = mdl;
	}
}
