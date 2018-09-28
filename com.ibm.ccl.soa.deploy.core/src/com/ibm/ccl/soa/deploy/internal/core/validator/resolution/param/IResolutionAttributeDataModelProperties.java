  
/*******************************************************************************
 * Copyright (c) 2003, 2007 IBM Corporation Licensed Material - Property of IBM. All rights reserved.
 *  
 * US Government Users Restricted Rights - Use, duplication or disclosure v1.0 restricted by GSA ADP
 * Schedule Contract with IBM Corp.
 * 
 * Contributors: IBM Corporation - initial API and implementation
 *******************************************************************************/
package com.ibm.ccl.soa.deploy.internal.core.validator.resolution.param;

import org.eclipse.emf.ecore.EAttribute;

import com.ibm.ccl.soa.deploy.core.DeployModelObject;

/**
 * Clients should not use the Properties interface directly, but instead should refer 
 * to the type-safe API class {@link com.ibm.ccl.soa.deploy.core.validator.resolution.datamodel.ResolutionAttributeDataModel}.
 * The properties interface is required by the Smart Datamodels Framework (SDF). 
 * 
 * @see com.ibm.ccl.soa.deploy.core.validator.resolution.datamodel.ResolutionAttributeDataModel
 * @generated (mde.utilities.datamodels)
 */
public interface IResolutionAttributeDataModelProperties {

	/** 
	 * 
	 * The AttributeName property.
	 *
	 * <p><b>[Required]</b></p>
	 *
	 * <p>Type = {@link String}. </p>
	 * @generated (mde.utilities.datamodels)
	 */
	String ATTRIBUTE_NAME = "IResolutionAttributeDataModelProperties.ATTRIBUTE_NAME"; //$NON-NLS-1$
	
	/** 
	 * 
	 * The DeployModelObject property.
	 *
	 * <p><b>[Required]</b></p>
	 * 
	 * <p>Type = {@link DeployModelObject}. </p>
	 * 
	 * @generated (mde.utilities.datamodels)
	 */
	String DEPLOY_MODEL_OBJECT = "IResolutionAttributeDataModelProperties.DEPLOY_MODEL_OBJECT"; //$NON-NLS-1$	
	
	/** 
	 * 
	 * The Attribute property.
	 *
	 * <p><b>[Required]</b></p>
	 * 
	 * <p>Type = {@link EAttribute}. </p>
	 * 
	 * @generated (mde.utilities.datamodels)
	 */
	String ATTRIBUTE = "IResolutionAttributeDataModelProperties.ATTRIBUTE"; //$NON-NLS-1$	
	
	/** 
	 * 
	 * DataModel sets up core arguments for part of a unit of work initated from a resolution
	 *
	 * <p><b>[Required]</b></p>
	 * 
	 * <p>Type = {@link org.eclipse.wst.common.frameworks.datamodel.IDataModel}. </p> 
	 * @generated (mde.utilities.datamodels)
	 */
	String RESOLUTION_DATA_MODEL = "IResolutionAttributeDataModelProperties.RESOLUTION_DATA_MODEL"; //$NON-NLS-1$	
	

	
		
}
