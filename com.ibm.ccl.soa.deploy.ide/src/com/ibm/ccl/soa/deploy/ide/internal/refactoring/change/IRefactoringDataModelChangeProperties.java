/***************************************************************************************************
 * Copyright (c) 2006 IBM Corporation. Licensed Material - Property of IBM. All rights reserved. US
 * Government Users Restricted Rights - Use, duplication or disclosure restricted by GSA ADP
 * Schedule Contract with IBM Corp.
 * 
 * Contributors: IBM Corporation - initial API and implementation
 **************************************************************************************************/
package com.ibm.ccl.soa.deploy.ide.internal.refactoring.change;

import com.ibm.ccl.soa.infrastructure.operations.IAbstractScribblerDataModelProperties;

/**
 * Clients should not use the Properties interface directly, but instead should refer to the
 * type-safe API class
 * {@link com.ibm.ccl.soa.deploy.ide.refactoring.change.DeployRefactoringChange}. The properties
 * interface is required by the Smart Datamodels Framework (SDF).
 * 
 * @see com.ibm.ccl.soa.deploy.ide.refactoring.change.DeployRefactoringChange
 * @generated (mde.utilities.datamodels)
 */
public interface IRefactoringDataModelChangeProperties extends
		IAbstractScribblerDataModelProperties {

	/**
	 * 
	 * The name of the change
	 * 
	 * <p>
	 * <b>[Required]</b>
	 * </p>
	 * 
	 * <p>
	 * Type = {@link String}.
	 * </p>
	 * 
	 * @generated (mde.utilities.datamodels)
	 */
	String NAME = "IRefactoringDataModelChangeProperties.NAME"; //$NON-NLS-1$

	/**
	 * 
	 * Used by {@code DeployRefactoringChange} classes that need to modify EMF models.
	 * 
	 * <p>
	 * <b>[Optional]</b>
	 * </p>
	 * 
	 * <p>
	 * Type = {@link org.eclipse.wst.common.frameworks.datamodel.IDataModel}.
	 * </p>
	 * 
	 * @generated (mde.utilities.datamodels)
	 */
	String SCRIBBLER_DEFINITION = "IRefactoringDataModelChangeProperties.SCRIBBLER_DEFINITION"; //$NON-NLS-1$	

}
