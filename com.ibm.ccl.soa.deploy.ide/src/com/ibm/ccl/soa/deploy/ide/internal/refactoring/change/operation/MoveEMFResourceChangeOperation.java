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
import org.eclipse.core.runtime.Path;
import org.eclipse.core.runtime.Status;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.gmf.runtime.notation.Diagram;
import org.eclipse.wst.common.frameworks.datamodel.IDataModel;

import com.ibm.ccl.soa.deploy.core.IConstants;
import com.ibm.ccl.soa.deploy.ide.internal.refactoring.change.IMoveEMFResourceChangeProperties;
import com.ibm.ccl.soa.deploy.ide.refactoring.change.MoveEMFResourceChange;
import com.ibm.ccl.soa.deploy.ide.refactoring.change.RenameTopologyChange;
import com.ibm.ccl.soa.infrastructure.emf.IEditModelScribbler;

/**
 * 
 * Provides a type-specific implementation of the RenameTopologyChange model.
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
public class MoveEMFResourceChangeOperation extends DeployRefactoringChangeOperation implements
		IMoveEMFResourceChangeProperties {

	private MoveEMFResourceChange typesafeModel;

	/**
	 * Construct an operation pre-configured with the given data model.
	 * 
	 * @param dMdl
	 *           The datamodel to use when executing this operation.
	 * @generated (mde.utilities.datamodels)
	 */
	public MoveEMFResourceChangeOperation(IDataModel dMdl) {
		super(dMdl);
		setTypeSafeModel(new MoveEMFResourceChange(dMdl));
	}

	/**
	 * Construct an operation pre-configured with the given type-safe data model.
	 * 
	 * @param tsMdl
	 *           The type-safe datamodel to use when executing this operation.
	 * @generated (mde.utilities.datamodels)
	 */
	public MoveEMFResourceChangeOperation(MoveEMFResourceChange tsMdl) {
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

		IFile newLocation = ResourcesPlugin.getWorkspace().getRoot().getFile(
				typesafeModel.getDestination());
		IFile oldLocation = ResourcesPlugin.getWorkspace().getRoot().getFile(
				typesafeModel.getSource());

		URI oldURI = URI.createPlatformResourceURI(oldLocation.getFullPath().toString());
		URI newURI = URI.createPlatformResourceURI(newLocation.getFullPath().toString());

		// we need to change the uri of the in-memory resource
		IEditModelScribbler scribbler = getEditModelScribbler();
		Resource resource = scribbler.getResource(oldURI, IEditModelScribbler.OPTION_NONE);

		if (null == resource || null == resource.getContents() || 0 == resource.getContents().size()) {
			// this means that the resource is not being indexed in the edit model under the old uri
			// let's force the load under the new uri
			resource = scribbler.getResource(newURI);
		} else {
			// resource is indexed in the edit model under the old uri, we need to update it
			resource.setURI(newURI);

			// now lets make sure it's been stored under the new uri
//			resource = scribbler.getResource(newURI);
		}

		// Defect 5984 - If we are renaming a diagram we need to make sure we set the name to the new IFile's name
		if (IConstants.TOPOLOGYV_EXTENSION.equalsIgnoreCase(newLocation.getFileExtension())) {
			if (null != resource.getContents() && resource.getContents().size() > 0) {
				Diagram diagram = (Diagram) resource.getContents().get(0);
				if (null != diagram) {
					String name = new Path(newLocation.getName()).removeFileExtension().toString();
					diagram.setName(name);
				}
			} else {
				throw new ExecutionException(
						"Diagram resource at ''" + oldLocation + "'' is not a valid deployment diagram."); //$NON-NLS-1$//$NON-NLS-2$ 
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
	private void setTypeSafeModel(MoveEMFResourceChange mdl) {
		typesafeModel = mdl;
	}
}
