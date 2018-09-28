  
/*******************************************************************************
 * Copyright (c) 2006 IBM Corporation.
 * Licensed Material - Property of IBM. All rights reserved.
 * US Government Users Restricted Rights - Use, duplication or disclosure
 * restricted by GSA ADP Schedule Contract with IBM Corp.
 *
 * Contributors:
 *     IBM Corporation - initial API and implementation
 *******************************************************************************/
package com.ibm.ccl.soa.deploy.ide.internal.refactoring.participant;

/**
 * Clients should not use the Properties interface directly, but instead should refer 
 * to the type-safe API class {@link com.ibm.ccl.soa.deploy.core.datamodels.MoveTopologyDescriptor}.
 * The properties interface is required by the Smart Datamodels Framework (SDF). 
 * 
 * @see com.ibm.ccl.soa.deploy.core.datamodels.MoveTopologyDescriptor
 * @generated (mde.utilities.datamodels)
 */
public interface IMoveTopologyModelProperties {

	/** 
	 * 
	 *  
	 *
	 * <p><b>[Required]</b></p>
	 *
	 * <p>Type = {@link String}. </p>
	 * @generated (mde.utilities.datamodels)
	 */
	String CONTAINER = "IMoveTopologyModelProperties.CONTAINER"; //$NON-NLS-1$
	
	/** 
	 * 
	 *  
	 *
	 * <p><b>[Required]</b></p>
	 * 
	 * <p>Type = {@link IResource[]}. </p>
	 * 
	 * @generated (mde.utilities.datamodels)
	 */
	String TOPOLOGIES = "IMoveTopologyModelProperties.TOPOLOGIES"; //$NON-NLS-1$	
	

	
		
}
