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
import org.eclipse.core.runtime.IPath;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.wst.common.frameworks.datamodel.IDataModel;

import com.ibm.ccl.soa.deploy.core.IConstants;
import com.ibm.ccl.soa.deploy.core.Topology;
import com.ibm.ccl.soa.deploy.core.namespace.INamespaceElement;
import com.ibm.ccl.soa.deploy.core.namespace.INamespaceFragmentRoot;
import com.ibm.ccl.soa.deploy.core.namespace.NamespaceCore;
import com.ibm.ccl.soa.deploy.core.util.TopologyNamespaceUtil;
import com.ibm.ccl.soa.deploy.ide.internal.refactoring.change.IRenameTopologyChangeProperties;
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
public class RenameTopologyChangeOperation extends DeployRefactoringChangeOperation implements
		IRenameTopologyChangeProperties {

	private RenameTopologyChange typesafeModel;

	/**
	 * Construct an operation pre-configured with the given data model.
	 * 
	 * @param dMdl
	 *           The datamodel to use when executing this operation.
	 * @generated (mde.utilities.datamodels)
	 */
	public RenameTopologyChangeOperation(IDataModel dMdl) {
		super(dMdl);
		setTypeSafeModel(new RenameTopologyChange(dMdl));
	}

	/**
	 * Construct an operation pre-configured with the given type-safe data model.
	 * 
	 * @param tsMdl
	 *           The type-safe datamodel to use when executing this operation.
	 * @generated (mde.utilities.datamodels)
	 */
	public RenameTopologyChangeOperation(RenameTopologyChange tsMdl) {
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

			IFile oldTopologyFile = ResourcesPlugin.getWorkspace().getRoot().getFile(
					typesafeModel.getSource());
			IFile newTopologyFile = ResourcesPlugin.getWorkspace().getRoot().getFile(
					typesafeModel.getDestination());

			INamespaceFragmentRoot namespaceRoot = NamespaceCore.getRoot(newTopologyFile.getParent());

			IPath relativePath = newTopologyFile.getFullPath();
			IPath expectedContainerPath = null;
			if (namespaceRoot != null) {
				expectedContainerPath = namespaceRoot.getCorrespondingResource().getFullPath();
			}

			String namespace = INamespaceElement.DEFAULT_NAMESPACE;
			String name = relativePath.removeFileExtension().lastSegment();

			if (expectedContainerPath != null
					&& relativePath.matchingFirstSegments(expectedContainerPath) == expectedContainerPath
							.segmentCount()) {
				relativePath = newTopologyFile.getFullPath().removeFirstSegments(
						namespaceRoot.getCorrespondingResource().getFullPath().segmentCount());
				namespace = TopologyNamespaceUtil.concatWith(relativePath.removeLastSegments(1)
						.segments(), IConstants.DOT_SEPARATOR);
			} else {
				expectedContainerPath = relativePath.removeLastSegments(1);
			}

			URI oldTopologyURI = URI.createPlatformResourceURI(oldTopologyFile.getFullPath()
					.toString());
			URI newTopologyURI = URI.createPlatformResourceURI(newTopologyFile.getFullPath()
					.toString());

			IEditModelScribbler scribbler = getEditModelScribbler();
			for (int i = 0; i < scribbler.getSortedResources().length; i++) {
				Resource resource = scribbler.getSortedResources()[i];
				if (null != resource) {
					if (resource.getURI().equals(oldTopologyURI)) {
						resource.setURI(newTopologyURI);
					}
				}
			}

			Topology topology = getTopology(newTopologyFile);
			topology.setName(name);
			topology.setNamespace(namespace);
			topology.setDisplayName(name);

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
	private void setTypeSafeModel(RenameTopologyChange mdl) {
		typesafeModel = mdl;
	}
}
