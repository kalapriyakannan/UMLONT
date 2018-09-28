  
/*******************************************************************************
 * Copyright (c) 2006 IBM Corporation.
 * Licensed Material - Property of IBM. All rights reserved.
 * US Government Users Restricted Rights - Use, duplication or disclosure
 * restricted by GSA ADP Schedule Contract with IBM Corp.
 *
 * Contributors:
 *     IBM Corporation - initial API and implementation
 *******************************************************************************/
package com.ibm.ccl.soa.deploy.core.internal.datamodels;

import com.ibm.ccl.soa.deploy.core.Topology;

/**
 * Clients should not use the Properties interface directly, but instead should refer 
 * to the type-safe API class {@link com.ibm.ccl.soa.deploy.core.datamodels.SynchronizationDatamodel}.
 * The properties interface is required by the Smart Datamodels Framework (SDF). 
 * 
 * @see com.ibm.ccl.soa.deploy.core.datamodels.SynchronizationDatamodel
 * @generated (mde.utilities.datamodels)
 */
public interface ISynchronizationDatamodelProperties {

	/** 
   * 
   * The topology that is the target 
   * of the implementation operation.
   *
   * <p><b>[Required]</b></p>
   * 
   * <p>Type = {@link Topology}. </p>
   * 
   * @generated (mde.utilities.datamodels)
   */
	String TOPOLOGY = "ISynchronizationDatamodelProperties.TOPOLOGY"; //$NON-NLS-1$	

	/** 
   * 
   * The set of components from the associated
   * topology that should be implemented or
   * reflected. This field will be empty if creating an 
   * Import Change.
   *
   * <p><b>[Required]</b></p>
   * 
   * <p>Type = {@link Unit[]}. </p>
   * 
   * @generated (mde.utilities.datamodels)
   */
	String COMPONENTS = "ISynchronizationDatamodelProperties.COMPONENTS"; //$NON-NLS-1$	

	/** 
   * 
   * The set of stubs from some external selection
   * that should be imported. This field will be empty 
   * if creating an Implementation or Reflection Change.
   *
   * <p><b>[Required]</b></p>
   * 
   * <p>Type = {@link TopologyUnitStub[]}. </p>
   * 
   * @generated (mde.utilities.datamodels)
   */
	String STUBS = "ISynchronizationDatamodelProperties.STUBS"; //$NON-NLS-1$	

}
