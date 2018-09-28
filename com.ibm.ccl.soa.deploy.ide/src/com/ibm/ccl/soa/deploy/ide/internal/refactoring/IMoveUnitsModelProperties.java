  
/*******************************************************************************
 * Copyright (c) 2006 IBM Corporation.
 * Licensed Material - Property of IBM. All rights reserved.
 * US Government Users Restricted Rights - Use, duplication or disclosure
 * restricted by GSA ADP Schedule Contract with IBM Corp.
 *
 * Contributors:
 *     IBM Corporation - initial API and implementation
 *******************************************************************************/
package com.ibm.ccl.soa.deploy.ide.internal.refactoring;

/**
 * Clients should not use the Properties interface directly, but instead should refer 
 * to the type-safe API class {@link com.ibm.ccl.soa.deploy.core.datamodels.MoveUnitsRefactoringDataModel}.
 * The properties interface is required by the Smart Datamodels Framework (SDF). 
 * 
 * @see com.ibm.ccl.soa.deploy.core.datamodels.MoveUnitsRefactoringDataModel
 * @generated (mde.utilities.datamodels)
 */
public interface IMoveUnitsModelProperties {

	/** 
   * 
   * Indicates if the destination topology model of the move refactoring is an existing topology.
   *
   * <p><b>[Required]</b></p>
   *
   * <p>Type = {@link Boolean}. </p>
   * @generated (mde.utilities.datamodels)
   */
	String USE_EXISTING_TOPOLOGY = "IMoveUnitsModelProperties.USE_EXISTING_TOPOLOGY"; //$NON-NLS-1$

	/** 
   * 
   * Indicates how links to the units that will be moved in this refactoring will be preserved, if any links to the units exist.
   *
   * <p><b>[Required]</b></p>
   *
   * <p>Type = {@link String}. </p>
   * @generated (mde.utilities.datamodels)
   */
	String PRESERVE_LINKS = "IMoveUnitsModelProperties.PRESERVE_LINKS"; //$NON-NLS-1$

	/** 
   * 
   * Path of the existing topology file.
   *
   * <p><b>[Required]</b></p>
   *
   * <p>Type = {@link String}. </p>
   * @generated (mde.utilities.datamodels)
   */
	String EXISTING_TOPOLOGY_FILE = "IMoveUnitsModelProperties.EXISTING_TOPOLOGY_FILE"; //$NON-NLS-1$	

	/** 
   * 
   * The purpose of this property is to restrict the preserveLinks property to a
   * specific value and prevent it from changing.  The preserveLinks property
   * will remain set to the value it was set to when this property is set to true.
   *
   * <p><b>[Required]</b></p>
   *
   * <p>Type = {@link Boolean}. </p>
   * @generated (mde.utilities.datamodels)
   */
	String PRESERVE_LINKS_RESTRICTED = "IMoveUnitsModelProperties.PRESERVE_LINKS_RESTRICTED"; //$NON-NLS-1$

	/** 
   * 
   * Used when the destination of this move refactoring is a new topology model.
   *
   * <p><b>[Required]</b></p>
   * 
   * <p>Type = {@link org.eclipse.wst.common.frameworks.datamodel.IDataModel}. </p> 
   * @generated (mde.utilities.datamodels)
   */
	String TOPOLOGY_CREATION_DATA_MODEL = "IMoveUnitsModelProperties.TOPOLOGY_CREATION_DATA_MODEL"; //$NON-NLS-1$	

	/** 
   * 
   * The set of units to be moved.
   *
   * <p><b>[Required]</b></p>
   * 
   * <p>Type = {@link Unit[]}. </p>
   * 
   * @generated (mde.utilities.datamodels)
   */
	String UNITS = "IMoveUnitsModelProperties.UNITS"; //$NON-NLS-1$	

	/**
	 * @generated NOT
	 */
	String PRESERVE_LINKS_IN_SOURCE = "SOURCE"; //$NON-NLS-1$

	/**
	 * @generated NOT
	 */
	String PRESERVE_LINKS_IN_DESTINATION = "DESTINATION"; //$NON-NLS-1$

	/**
	 * @generated NOT
	 */
	String PRESERVE_LINKS_IN_NEITHER = "NEITHER"; //$NON-NLS-1$
}
