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
import org.eclipse.wst.common.frameworks.datamodel.IDataModel;

import com.ibm.ccl.soa.deploy.core.CorePackage;
import com.ibm.ccl.soa.deploy.core.DeployLink;
import com.ibm.ccl.soa.deploy.core.Topology;
import com.ibm.ccl.soa.deploy.ide.internal.refactoring.change.IUpdateLinkChangeProperties;
import com.ibm.ccl.soa.deploy.ide.refactoring.change.UpdateLinkChange;

/**
 * 
 * Provides a type-specific implementation of the UpdateLinkChange model.
 * 
 * <p>
 * Clients should use {@link UpdateLinkChange#createConfiguredOperation()} to create an instance of
 * this operation, configured with the necessary model properties.
 * </p>
 * 
 * @see com.ibm.ccl.soa.deploy.ide.internal.refactoring.change.operation.DeployRefactoringChangeOperation
 * @see com.ibm.ccl.soa.deploy.ide.refactoring.change.UpdateLinkChange
 * @generated (mde.utilities.datamodels)
 */
public class UpdateLinkChangeOperation extends DeployRefactoringChangeOperation implements
		IUpdateLinkChangeProperties {

	private UpdateLinkChange typesafeModel;

	/**
	 * Construct an operation pre-configured with the given data model.
	 * 
	 * @param dMdl
	 *           The datamodel to use when executing this operation.
	 * @generated (mde.utilities.datamodels)
	 */
	public UpdateLinkChangeOperation(IDataModel dMdl) {
		super(dMdl);
		setTypeSafeModel(new UpdateLinkChange(dMdl));
	}

	/**
	 * Construct an operation pre-configured with the given type-safe data model.
	 * 
	 * @param tsMdl
	 *           The type-safe datamodel to use when executing this operation.
	 * @generated (mde.utilities.datamodels)
	 */
	public UpdateLinkChangeOperation(UpdateLinkChange tsMdl) {
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

			URI linkURI = typesafeModel.getLink();
			IFile topologyFile = ResourcesPlugin.getWorkspace().getRoot().getFile(
					new Path(linkURI.toPlatformString(true)));

			Topology topology = getTopology(topologyFile);
			DeployLink link = (DeployLink) topology.resolve(linkURI.fragment());
			if (UpdateLinkChange.TARGET.equals(typesafeModel.getEndpoint())) {
				link.eSet(CorePackage.eINSTANCE.getDeployLink_TargetURI(), typesafeModel
						.getDestination());
			} else if (UpdateLinkChange.SOURCE.equals(typesafeModel.getEndpoint())) {
				link.eSet(CorePackage.eINSTANCE.getDeployLink_SourceURI(), typesafeModel
						.getDestination());
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
	private void setTypeSafeModel(UpdateLinkChange mdl) {
		typesafeModel = mdl;
	}
}
