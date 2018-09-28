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

import com.ibm.ccl.soa.deploy.core.Topology;
import com.ibm.ccl.soa.deploy.core.Unit;
import com.ibm.ccl.soa.deploy.ide.internal.refactoring.change.IMoveUnitChangeProperties;
import com.ibm.ccl.soa.deploy.ide.refactoring.change.MoveUnitChange;

/**
 * 
 * Provides a type-specific implementation of the MoveUnitChange model.
 * 
 * <p>
 * Clients should use {@link MoveUnitChange#createConfiguredOperation()} to create an instance of
 * this operation, configured with the necessary model properties.
 * </p>
 * 
 * @see com.ibm.ccl.soa.deploy.ide.internal.refactoring.change.operation.MoveDMOChangeOperation
 * @see com.ibm.ccl.soa.deploy.ide.refactoring.change.MoveUnitChange
 * @generated (mde.utilities.datamodels)
 */
public class MoveUnitChangeOperation extends MoveDMOChangeOperation implements
		IMoveUnitChangeProperties {

	private MoveUnitChange typesafeModel;

	/**
	 * Construct an operation pre-configured with the given data model.
	 * 
	 * @param dMdl
	 *           The datamodel to use when executing this operation.
	 * @generated (mde.utilities.datamodels)
	 */
	public MoveUnitChangeOperation(IDataModel dMdl) {
		super(dMdl);
		setTypeSafeModel(new MoveUnitChange(dMdl));
	}

	/**
	 * Construct an operation pre-configured with the given type-safe data model.
	 * 
	 * @param tsMdl
	 *           The type-safe datamodel to use when executing this operation.
	 * @generated (mde.utilities.datamodels)
	 */
	public MoveUnitChangeOperation(MoveUnitChange tsMdl) {
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
			Unit srcUnit = (Unit) srcTopology.resolve(source.fragment());
			srcTopology.getUnits().remove(srcUnit);
			srcUnit.setName(destination.fragment().substring(1));
			destTopology.getUnits().add(srcUnit);
			srcUnit.getFullPath();

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
	private void setTypeSafeModel(MoveUnitChange mdl) {
		typesafeModel = mdl;
	}
}
