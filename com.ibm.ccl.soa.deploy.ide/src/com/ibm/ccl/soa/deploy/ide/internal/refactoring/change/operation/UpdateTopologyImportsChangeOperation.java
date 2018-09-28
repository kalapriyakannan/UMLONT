/***************************************************************************************************
 * Copyright (c) 2006 IBM Corporation. Licensed Material - Property of IBM. All rights reserved. US
 * Government Users Restricted Rights - Use, duplication or disclosure restricted by GSA ADP
 * Schedule Contract with IBM Corp.
 * 
 * Contributors: IBM Corporation - initial API and implementation
 **************************************************************************************************/
package com.ibm.ccl.soa.deploy.ide.internal.refactoring.change.operation;

import java.util.Iterator;

import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.wst.common.frameworks.datamodel.IDataModel;

import com.ibm.ccl.soa.deploy.core.CorePackage;
import com.ibm.ccl.soa.deploy.core.DeployLink;
import com.ibm.ccl.soa.deploy.core.IConstants;
import com.ibm.ccl.soa.deploy.core.Import;
import com.ibm.ccl.soa.deploy.core.Topology;
import com.ibm.ccl.soa.deploy.ide.internal.refactoring.change.IUpdateTopologyImportsChangeProperties;
import com.ibm.ccl.soa.deploy.ide.refactoring.change.UpdateTopologyImportsChange;

/**
 * 
 * Provides a type-specific implementation of the UpdateTopologyImportsChange model.
 * 
 * <p>
 * Clients should use {@link UpdateTopologyImportsChange#createConfiguredOperation()} to create an
 * instance of this operation, configured with the necessary model properties.
 * </p>
 * 
 * @see com.ibm.ccl.soa.deploy.ide.internal.refactoring.change.operation.DeployRefactoringChangeOperation
 * @see com.ibm.ccl.soa.deploy.ide.refactoring.change.UpdateTopologyImportsChange
 * @generated (mde.utilities.datamodels)
 */
public class UpdateTopologyImportsChangeOperation extends DeployRefactoringChangeOperation
		implements IUpdateTopologyImportsChangeProperties {

	private UpdateTopologyImportsChange typesafeModel;

	/**
	 * Construct an operation pre-configured with the given data model.
	 * 
	 * @param dMdl
	 *           The datamodel to use when executing this operation.
	 * @generated (mde.utilities.datamodels)
	 */
	public UpdateTopologyImportsChangeOperation(IDataModel dMdl) {
		super(dMdl);
		setTypeSafeModel(new UpdateTopologyImportsChange(dMdl));
	}

	/**
	 * Construct an operation pre-configured with the given type-safe data model.
	 * 
	 * @param tsMdl
	 *           The type-safe datamodel to use when executing this operation.
	 * @generated (mde.utilities.datamodels)
	 */
	public UpdateTopologyImportsChangeOperation(UpdateTopologyImportsChange tsMdl) {
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

			IFile topologyFile = ResourcesPlugin.getWorkspace().getRoot().getFile(
					typesafeModel.getModel());
			String oldNamespace = typesafeModel.getSource().indexOf(IConstants.DOT_SEPARATOR) > 0 ? typesafeModel
					.getSource().substring(0,
							typesafeModel.getSource().lastIndexOf(IConstants.DOT_SEPARATOR))
					: new String();
			String oldName = typesafeModel.getSource().indexOf(IConstants.DOT_SEPARATOR) > 0 ? typesafeModel
					.getSource().substring(oldNamespace.length() + 1)
					: typesafeModel.getSource();
			String newNamespace = typesafeModel.getDestination().indexOf(IConstants.DOT_SEPARATOR) > 0 ? typesafeModel
					.getDestination().substring(0,
							typesafeModel.getDestination().lastIndexOf(IConstants.DOT_SEPARATOR))
					: new String();
			String newName = typesafeModel.getDestination().indexOf(IConstants.DOT_SEPARATOR) > 0 ? typesafeModel
					.getDestination().substring(newNamespace.length() + 1)
					: typesafeModel.getDestination();

			Topology topology = getTopology(topologyFile);
			Import anImport = topology.getImport(oldNamespace, oldName);
			if (anImport != null) {
				anImport.setNamespace(newNamespace);
				anImport.setPattern(newName);
				anImport.setName(newName);
				anImport.setDisplayName(newName);
			}

			// update deploy links that utilize the import node
			for (Iterator<DeployLink> iter = topology.findAllDeployLinks(); iter.hasNext();) {
				DeployLink link = iter.next();
				if (link.getSourceURI().contains(
						typesafeModel.getSource() + IConstants.TOPOLOGY_SEPARATOR
								+ IConstants.PATH_SEPARATOR)) {
					link.eSet(CorePackage.eINSTANCE.getDeployLink_SourceURI(), typesafeModel
							.getDestination()
							+ link.getSourceURI().substring(
									link.getSourceURI().indexOf(IConstants.TOPOLOGY_SEPARATOR)));
				}
				if (link.getTargetURI().contains(
						typesafeModel.getSource() + IConstants.TOPOLOGY_SEPARATOR
								+ IConstants.PATH_SEPARATOR)) {
					link.eSet(CorePackage.eINSTANCE.getDeployLink_TargetURI(), typesafeModel
							.getDestination()
							+ link.getTargetURI().substring(
									link.getTargetURI().indexOf(IConstants.TOPOLOGY_SEPARATOR)));
				}
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
	private void setTypeSafeModel(UpdateTopologyImportsChange mdl) {
		typesafeModel = mdl;
	}
}
