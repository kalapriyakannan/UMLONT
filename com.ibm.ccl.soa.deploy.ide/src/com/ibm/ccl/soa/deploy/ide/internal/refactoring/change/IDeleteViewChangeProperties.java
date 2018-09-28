/***************************************************************************************************
 * Copyright (c) 2006 IBM Corporation. Licensed Material - Property of IBM. All rights reserved. US
 * Government Users Restricted Rights - Use, duplication or disclosure restricted by GSA ADP
 * Schedule Contract with IBM Corp.
 * 
 * Contributors: IBM Corporation - initial API and implementation
 **************************************************************************************************/
package com.ibm.ccl.soa.deploy.ide.internal.refactoring.change;

/**
 * Clients should not use the Properties interface directly, but instead should refer to the
 * type-safe API class {@link com.ibm.ccl.soa.deploy.ide.refactoring.change.DeleteViewChange}. The
 * properties interface is required by the Smart Datamodels Framework (SDF).
 * 
 * @see com.ibm.ccl.soa.deploy.ide.refactoring.change.DeleteViewChange
 * @generated (mde.utilities.datamodels)
 */
public interface IDeleteViewChangeProperties extends IRefactoringDataModelChangeProperties {

	/**
	 * 
	 * 
	 * 
	 * <p>
	 * <b>[Required]</b>
	 * </p>
	 * 
	 * <p>
	 * Type = {@link org.eclipse.emf.common.util.URI}.
	 * </p>
	 * 
	 * @generated (mde.utilities.datamodels)
	 */
	String VIEW = "IDeleteViewChangeProperties.VIEW"; //$NON-NLS-1$
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
	String SCRIBBLER_DEFINITION = "IDeleteViewChangeProperties.SCRIBBLER_DEFINITION"; //$NON-NLS-1$	

}
