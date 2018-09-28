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
 * type-safe API class {@link com.ibm.ccl.soa.deploy.ide.refactoring.change.CreateDiagramChange}.
 * The properties interface is required by the Smart Datamodels Framework (SDF).
 * 
 * @see com.ibm.ccl.soa.deploy.ide.refactoring.change.CreateDiagramChange
 * @generated (mde.utilities.datamodels)
 */
public interface ICreateDiagramChangeProperties extends IRefactoringDataModelChangeProperties {

	/**
	 * 
	 * {@code IPath} representing the name and location where the new {@code Diagram}
	 * {@code Resource} will be created.
	 * 
	 * <p>
	 * <b>[Required]</b>
	 * </p>
	 * 
	 * <p>
	 * Type = {@link org.eclipse.core.runtime.IPath}.
	 * </p>
	 * 
	 * @generated (mde.utilities.datamodels)
	 */
	String DIAGRAM = "ICreateDiagramChangeProperties.DIAGRAM"; //$NON-NLS-1$

	/**
	 * 
	 * {@code IPath} representing the location of the existing {@code Topology} model
	 * {@code Resource} that the new {@code Diagram} will represent.
	 * 
	 * <p>
	 * <b>[Required]</b>
	 * </p>
	 * 
	 * <p>
	 * Type = {@link org.eclipse.core.runtime.IPath}.
	 * </p>
	 * 
	 * @generated (mde.utilities.datamodels)
	 */
	String MODEL = "ICreateDiagramChangeProperties.MODEL"; //$NON-NLS-1$

}
