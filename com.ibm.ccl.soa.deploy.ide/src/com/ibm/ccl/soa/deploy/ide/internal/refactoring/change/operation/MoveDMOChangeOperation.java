/***************************************************************************************************
 * Copyright (c) 2006 IBM Corporation. Licensed Material - Property of IBM. All rights reserved. US
 * Government Users Restricted Rights - Use, duplication or disclosure restricted by GSA ADP
 * Schedule Contract with IBM Corp.
 * 
 * Contributors: IBM Corporation - initial API and implementation
 **************************************************************************************************/
package com.ibm.ccl.soa.deploy.ide.internal.refactoring.change.operation;

import org.eclipse.wst.common.frameworks.datamodel.IDataModel;

import com.ibm.ccl.soa.deploy.ide.internal.refactoring.change.IMoveDMOChangeProperties;
import com.ibm.ccl.soa.deploy.ide.refactoring.change.MoveDMOChange;

/**
 * 
 * Provides a type-specific implementation of the MoveDMOChange model.
 * 
 * <p>
 * Clients should use {@link MoveDMOChange#createConfiguredOperation()} to create an instance of
 * this operation, configured with the necessary model properties.
 * </p>
 * 
 * @see com.ibm.ccl.soa.deploy.ide.internal.refactoring.change.operation.DeployRefactoringChangeOperation
 * @see com.ibm.ccl.soa.deploy.ide.refactoring.change.MoveDMOChange
 * @generated (mde.utilities.datamodels)
 */
public abstract class MoveDMOChangeOperation extends DeployRefactoringChangeOperation implements
		IMoveDMOChangeProperties {

	private MoveDMOChange typesafeModel;

	/**
	 * Construct an operation pre-configured with the given data model.
	 * 
	 * @param dMdl
	 *           The datamodel to use when executing this operation.
	 * @generated (mde.utilities.datamodels)
	 */
	public MoveDMOChangeOperation(IDataModel dMdl) {
		super(dMdl);
	}

	/**
	 * Construct an operation pre-configured with the given type-safe data model.
	 * 
	 * @param tsMdl
	 *           The type-safe datamodel to use when executing this operation.
	 * @generated (mde.utilities.datamodels)
	 */
	public MoveDMOChangeOperation(MoveDMOChange tsMdl) {
		super(tsMdl);
		setTypeSafeModel(tsMdl);
	}

	/**
	 * This operation can accept a typesafe model that provides a more usable interface to the
	 * {@link org.eclipse.wst.common.frameworks.datamodel.IDataModel}.
	 * 
	 * @param mdl
	 *           The typesafe model that will drive this operation.
	 * @generated (mde.utilities.datamodels)
	 */
	private void setTypeSafeModel(MoveDMOChange mdl) {
		typesafeModel = mdl;
	}
}
