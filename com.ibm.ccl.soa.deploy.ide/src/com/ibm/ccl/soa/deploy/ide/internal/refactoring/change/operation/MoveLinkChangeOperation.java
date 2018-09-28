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
import com.ibm.ccl.soa.deploy.ide.internal.refactoring.change.IMoveLinkChangeProperties;
import com.ibm.ccl.soa.deploy.ide.refactoring.change.MoveLinkChange;

/**
 * 
 * Provides a type-specific implementation of the MoveLinkChange model.
 * 
 * <p>
 * Clients should use {@link MoveLinkChange#createConfiguredOperation()} to create an instance of
 * this operation, configured with the necessary model properties.
 * </p>
 * 
 * @see com.ibm.ccl.soa.deploy.ide.internal.refactoring.change.operation.MoveDMOChangeOperation
 * @see com.ibm.ccl.soa.deploy.ide.refactoring.change.MoveLinkChange
 * @generated (mde.utilities.datamodels)
 */
public class MoveLinkChangeOperation extends MoveDMOChangeOperation implements
		IMoveLinkChangeProperties {

	private MoveLinkChange typesafeModel;

	/**
	 * Construct an operation pre-configured with the given data model.
	 * 
	 * @param dMdl
	 *           The datamodel to use when executing this operation.
	 * @generated (mde.utilities.datamodels)
	 */
	public MoveLinkChangeOperation(IDataModel dMdl) {
		super(dMdl);
		setTypeSafeModel(new MoveLinkChange(dMdl));
	}

	/**
	 * Construct an operation pre-configured with the given type-safe data model.
	 * 
	 * @param tsMdl
	 *           The type-safe datamodel to use when executing this operation.
	 * @generated (mde.utilities.datamodels)
	 */
	public MoveLinkChangeOperation(MoveLinkChange tsMdl) {
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

			URI source = typesafeModel.getSource();
			URI destination = typesafeModel.getDestination();

			IFile sourceTopologyFile = ResourcesPlugin.getWorkspace().getRoot().getFile(
					new Path(source.toPlatformString(true)));
			IFile destinationTopologyFile = ResourcesPlugin.getWorkspace().getRoot().getFile(
					new Path(destination.toPlatformString(true)));

			Topology srcTopology = getTopology(sourceTopologyFile);
			Topology destTopology = getTopology(destinationTopologyFile);
			DeployLink link = (DeployLink) srcTopology.resolve(typesafeModel.getSource().fragment());
			link.setName(destination.fragment());

			if (CorePackage.eINSTANCE.getDependencyLink().isSuperTypeOf(link.getEObject().eClass())) {
				srcTopology.getDependencyLinks().remove(link);
				destTopology.getDependencyLinks().add(link);
			} else if (CorePackage.eINSTANCE.getConstraintLink().isSuperTypeOf(
					link.getEObject().eClass())) {
				srcTopology.getConstraintLinks().remove(link);
				destTopology.getConstraintLinks().add(link);
			} else if (CorePackage.eINSTANCE.getHostingLink()
					.isSuperTypeOf(link.getEObject().eClass())) {
				srcTopology.getHostingLinks().remove(link);
				destTopology.getHostingLinks().add(link);
			} else if (CorePackage.eINSTANCE.getMemberLink().isSuperTypeOf(link.getEObject().eClass())) {
				srcTopology.getMemberLinks().remove(link);
				destTopology.getMemberLinks().add(link);
			} else if (CorePackage.eINSTANCE.getRealizationLink().isSuperTypeOf(
					link.getEObject().eClass())) {
				srcTopology.getRealizationLinks().remove(link);
				destTopology.getRealizationLinks().add(link);
			} else if (CorePackage.eINSTANCE.getUnitLink().isSuperTypeOf(link.getEObject().eClass())) {
				srcTopology.getUnitLinks().remove(link);
				destTopology.getUnitLinks().add(link);
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
	private void setTypeSafeModel(MoveLinkChange mdl) {
		typesafeModel = mdl;
	}
}
