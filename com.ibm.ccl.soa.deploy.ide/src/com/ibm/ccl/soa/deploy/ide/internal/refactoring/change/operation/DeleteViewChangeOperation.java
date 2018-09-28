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
import org.eclipse.core.runtime.Path;
import org.eclipse.core.runtime.Status;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.gmf.runtime.diagram.core.util.ViewUtil;
import org.eclipse.gmf.runtime.notation.NotationPackage;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.osgi.util.NLS;
import org.eclipse.wst.common.frameworks.datamodel.IDataModel;

import com.ibm.ccl.soa.deploy.ide.IDEPlugin;
import com.ibm.ccl.soa.deploy.ide.internal.refactoring.Messages;
import com.ibm.ccl.soa.deploy.ide.internal.refactoring.change.IDeleteViewChangeProperties;
import com.ibm.ccl.soa.deploy.ide.refactoring.change.DeleteViewChange;

/**
 * 
 * Provides a type-specific implementation of the DeleteViewChange model.
 * 
 * <p>
 * Clients should use {@link DeleteViewChange#createConfiguredOperation()} to create an instance of
 * this operation, configured with the necessary model properties.
 * </p>
 * 
 * @see com.ibm.ccl.soa.deploy.ide.internal.refactoring.change.operation.DeployRefactoringChangeOperation
 * @see com.ibm.ccl.soa.deploy.ide.refactoring.change.DeleteViewChange
 * @generated (mde.utilities.datamodels)
 */
public class DeleteViewChangeOperation extends DeployRefactoringChangeOperation implements
		IDeleteViewChangeProperties {

	private DeleteViewChange typesafeModel;

	/**
	 * Construct an operation pre-configured with the given data model.
	 * 
	 * @param dMdl
	 *           The datamodel to use when executing this operation.
	 * @generated (mde.utilities.datamodels)
	 */
	public DeleteViewChangeOperation(IDataModel dMdl) {
		super(dMdl);
		setTypeSafeModel(new DeleteViewChange(dMdl));
	}

	/**
	 * Construct an operation pre-configured with the given type-safe data model.
	 * 
	 * @param tsMdl
	 *           The type-safe datamodel to use when executing this operation.
	 * @generated (mde.utilities.datamodels)
	 */
	public DeleteViewChangeOperation(DeleteViewChange tsMdl) {
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

			URI uri = typesafeModel.getView();
			IFile diagramFile = ResourcesPlugin.getWorkspace().getRoot().getFile(
					new Path(uri.toPlatformString(true)));
			Resource resource = getResource(diagramFile);
			EObject eObject = resource.getEObject(uri.fragment());
			if (null != eObject) {
				if (!NotationPackage.Literals.VIEW.isSuperTypeOf(eObject.eClass())) {
					throw new CoreException(new Status(IStatus.ERROR, IDEPlugin.PLUGIN_ID, NLS.bind(
							Messages.DeleteViewChange_The_uri_did_not_point_to_an_object_, new Object[] {
									View.class.getCanonicalName(), diagramFile.getFullPath(),
									uri.toPlatformString(false) }, null)));
				}

				View view = (View) eObject;
				ViewUtil.destroy(view);
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
	private void setTypeSafeModel(DeleteViewChange mdl) {
		typesafeModel = mdl;
	}
}
