/*******************************************************************************
 * Copyright (c) 2003, 2007 IBM Corporation Licensed Material - Property of IBM. All rights reserved.
 *  
 * US Government Users Restricted Rights - Use, duplication or disclosure v1.0 restricted by GSA ADP
 * Schedule Contract with IBM Corp.
 * 
 * Contributors: IBM Corporation - initial API and implementation
 *******************************************************************************/
package com.ibm.ccl.soa.deploy.internal.core.validator.resolution.param;

import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.wst.common.frameworks.datamodel.AbstractDataModelOperation;
import org.eclipse.wst.common.frameworks.datamodel.IDataModel;

import com.ibm.ccl.soa.deploy.core.validator.resolution.datamodel.ResolutionDataModel;

/**
 * 	 
 * DataModel sets up core arguments for part of a unit of work initated from a resolution
 * 
 * <p>
 * Clients should use {@link ResolutionDataModel#createConfiguredOperation()} to create
 * an instance of this operation, configured with the necessary model properties.
 * </p>
 *
 * @see org.eclipse.wst.common.frameworks.datamodel.AbstractDataModelOperation
 * @see com.ibm.ccl.soa.deploy.core.validator.resolution.datamodel.ResolutionDataModel
 * @generated (mde.utilities.datamodels)
 */
public class ResolutionDataModelOperation extends AbstractDataModelOperation implements IResolutionDataModelProperties {

	private ResolutionDataModel typesafeModel;
		
	/**
	 * Construct an operation pre-configured with the given data model.
	 * 
	 * @param dMdl The datamodel to use when executing this operation. 
	 * @generated (mde.utilities.datamodels)
	 */		
	public ResolutionDataModelOperation(IDataModel dMdl) {
		super(dMdl); 
		setTypeSafeModel(new ResolutionDataModel(dMdl));
	}
	
	/**
	 * Construct an operation pre-configured with the given type-safe data model.
	 * 
	 * @param tsMdl The type-safe datamodel to use when executing this operation. 
	 * @generated (mde.utilities.datamodels)
	 */
	public ResolutionDataModelOperation(ResolutionDataModel tsMdl) {
		super(tsMdl.getUnderlyingDataModel());
		setTypeSafeModel(tsMdl);
	}
	
	/*
	 * (non-Javadoc)
	 *
	 * @see org.eclipse.core.commands.operations.IUndoableOperation#execute(IProgressMonitor, IAdaptable)
	 */
	public IStatus execute(IProgressMonitor monitor, IAdaptable info)
			throws ExecutionException {
		// TODO Use the "typesafeModel" field to execute the tasks of this operation

		// Called to avoid error for non-reference of field. Remove when implementing this method
		System.out.println("ResolutionDataModelOperation not yet implemented, but received the following data:\n" + typesafeModel.toString()); //$NON-NLS-1$
		
		return Status.OK_STATUS;
	}
	
	/**
	 * This operation can accept a typesafe model that provides a more usable
	 * interface to the {@link org.eclipse.wst.common.frameworks.datamodel.IDataModel}.
	 * 
	 * @param mdl The typesafe model that will drive this operation.
	 * @generated (mde.utilities.datamodels)
	 */
	private void setTypeSafeModel(ResolutionDataModel mdl) {
		typesafeModel = mdl;
	}
}
