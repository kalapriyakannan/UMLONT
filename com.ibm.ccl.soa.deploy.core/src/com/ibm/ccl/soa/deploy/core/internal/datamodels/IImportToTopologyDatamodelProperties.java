  
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

import org.eclipse.core.resources.IFile;

/**
 * Clients should not use the Properties interface directly, but instead should refer 
 * to the type-safe API class {@link com.ibm.ccl.soa.deploy.core.datamodels.ImportToTopologyDatamodel}.
 * The properties interface is required by the Smart Datamodels Framework (SDF). 
 * 
 * @see com.ibm.ccl.soa.deploy.core.datamodels.ImportToTopologyDatamodel
 * @generated (mde.utilities.datamodels)
 */
public interface IImportToTopologyDatamodelProperties {

	/** 
   * 
   * The Topology File that will contain the imported unit. The
   * Topology File must exist and must contain a valid Topology.
   *
   * <p><b>[Required]</b></p>
   * 
   * <p>Type = {@link IFile}. </p>
   * 
   * @generated (mde.utilities.datamodels)
   */
	String TOPOLOGY_FILE = "IImportToTopologyDatamodelProperties.TOPOLOGY_FILE"; //$NON-NLS-1$	
	
	/** 
   * 
   * The Resources property.
   *
   * <p><b>[Required]</b></p>
   * 
   * <p>Type = {@link IResource[]}. </p>
   * 
   * @generated (mde.utilities.datamodels)
   */
	String RESOURCES = "IImportToTopologyDatamodelProperties.RESOURCES"; //$NON-NLS-1$	
	

	
		
}
