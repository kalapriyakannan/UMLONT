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
import org.eclipse.gmf.runtime.notation.Diagram;
import org.eclipse.wst.common.frameworks.datamodel.IDataModel;

import com.ibm.ccl.soa.deploy.ide.internal.refactoring.change.IRenameDiagramChangeProperties;
import com.ibm.ccl.soa.deploy.ide.refactoring.change.RenameDiagramChange;
import com.ibm.ccl.soa.deploy.ide.refactoring.change.RenameTopologyChange;

/**
 * 
 * Provides a type-specific implementation of the RenameDiagramChange model.
 * 
 * <p>
 * Clients should use {@link RenameTopologyChange#createConfiguredOperation()} to create an instance
 * of this operation, configured with the necessary model properties.
 * </p>
 * 
 * @see com.ibm.ccl.soa.deploy.ide.internal.refactoring.change.operation.DeployRefactoringChangeOperation
 * @see com.ibm.ccl.soa.deploy.ide.refactoring.change.RenameTopologyChange
 * @generated (mde.utilities.datamodels)
 */
public class RenameDiagramChangeOperation extends DeployRefactoringChangeOperation implements
		IRenameDiagramChangeProperties {

	private RenameDiagramChange typesafeModel;

	/**
	 * Construct an operation pre-configured with the given data model.
	 * 
	 * @param dMdl
	 *           The datamodel to use when executing this operation.
	 * @generated (mde.utilities.datamodels)
	 */
	public RenameDiagramChangeOperation(IDataModel dMdl) {
		super(dMdl);
		setTypeSafeModel(new RenameDiagramChange(dMdl));
	}

	/**
	 * Construct an operation pre-configured with the given type-safe data model.
	 * 
	 * @param tsMdl
	 *           The type-safe datamodel to use when executing this operation.
	 * @generated (mde.utilities.datamodels)
	 */
	public RenameDiagramChangeOperation(RenameDiagramChange tsMdl) {
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

			IFile oldDiagramFile = ResourcesPlugin.getWorkspace().getRoot().getFile(
					typesafeModel.getSource());
			IFile newDiagramFile = ResourcesPlugin.getWorkspace().getRoot().getFile(
					typesafeModel.getDestination());

			Diagram diagram = null;

			if (oldDiagramFile.isAccessible()) {
				diagram = getDiagram(oldDiagramFile);
			} else if (newDiagramFile.isAccessible()) {
				diagram = getDiagram(newDiagramFile);
			}

			if (null != diagram) {
				String name = newDiagramFile.getProjectRelativePath().removeFileExtension()
						.lastSegment();
				diagram.setName(name);
			}

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
	private void setTypeSafeModel(RenameDiagramChange mdl) {
		typesafeModel = mdl;
	}

}
