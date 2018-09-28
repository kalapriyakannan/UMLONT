/*******************************************************************************
 * Copyright (c) 2003, 2007 IBM Corporation Licensed Material - Property of IBM. All rights reserved.
 *  
 * US Government Users Restricted Rights - Use, duplication or disclosure v1.0 restricted by GSA ADP
 * Schedule Contract with IBM Corp.
 * 
 * Contributors: IBM Corporation - initial API and implementation
 *******************************************************************************/
package com.ibm.ccl.soa.deploy.core.internal.datamodels;

/**
 * Clients should not use the Properties interface directly, but instead should refer to the
 * type-safe API class {@link com.ibm.ccl.soa.deploy.core.datamodels.LinkDiscoveryDataModel}. The
 * properties interface is required by the Smart Datamodels Framework (SDF).
 * 
 * @see com.ibm.ccl.soa.deploy.core.datamodels.LinkDiscoveryDataModel
 * @generated (mde.utilities.datamodels)
 */
public interface ILinkDiscoveryDataModelProperties {

	/**
	 * 
	 * The Unit property.
	 * 
	 * <p>
	 * <b>[Required]</b>
	 * </p>
	 * 
	 * <p>
	 * Type = {@link Unit}.
	 * </p>
	 * 
	 * @generated (mde.utilities.datamodels)
	 */
	String UNIT = "ILinkDiscoveryDataModelProperties.UNIT"; //$NON-NLS-1$	

	/**
	 * 
	 * Sets hosting link as the relationship type used for discovery.
	 * 
	 * <p>
	 * <b>[Required]</b>
	 * </p>
	 * 
	 * <p>
	 * Type = {@link Boolean}.
	 * </p>
	 * 
	 * @generated (mde.utilities.datamodels)
	 */
	String IS_HOSTING = "ILinkDiscoveryDataModelProperties.IS_HOSTING"; //$NON-NLS-1$	

	/**
	 * 
	 * Sets logical link as the relationship type used for discovery.
	 * 
	 * <p>
	 * <b>[Required]</b>
	 * </p>
	 * 
	 * <p>
	 * Type = {@link Boolean}.
	 * </p>
	 * 
	 * @generated (mde.utilities.datamodels)
	 */
	String IS_LOGICAL = "ILinkDiscoveryDataModelProperties.IS_LOGICAL"; //$NON-NLS-1$	

	/**
	 * 
	 * Sets group as the relationship type used for discovery.
	 * 
	 * <p>
	 * <b>[Required]</b>
	 * </p>
	 * 
	 * <p>
	 * Type = {@link Boolean}.
	 * </p>
	 * 
	 * @generated (mde.utilities.datamodels)
	 */
	String IS_DEPENDENCY = "ILinkDiscoveryDataModelProperties.IS_DEPENDENCY"; //$NON-NLS-1$	

	/**
	 * 
	 * Sets group as the relationship type used for discovery.
	 * 
	 * <p>
	 * <b>[Required]</b>
	 * </p>
	 * 
	 * <p>
	 * Type = {@link Boolean}.
	 * </p>
	 * 
	 * @generated (mde.utilities.datamodels)
	 */
	String IS_GROUP = "ILinkDiscoveryDataModelProperties.IS_GROUP"; //$NON-NLS-1$	

	/**
	 * 
	 * The DeploymentObjectModel property.
	 * 
	 * <p>
	 * <b>[Required]</b>
	 * </p>
	 * 
	 * <p>
	 * Type = {@link DeployModelObject}.
	 * </p>
	 * 
	 * @generated (mde.utilities.datamodels)
	 */
	String REQUIREMENT = "ILinkDiscoveryDataModelProperties.REQUIREMENT"; //$NON-NLS-1$	

	/**
	 * 
	 * The Descriptors property.
	 * 
	 * <p>
	 * <b>[Required]</b>
	 * </p>
	 * 
	 * <p>
	 * Type = {@link List}.
	 * </p>
	 * 
	 * @generated (mde.utilities.datamodels)
	 */
	String DESCRIPTORS = "ILinkDiscoveryDataModelProperties.DESCRIPTORS"; //$NON-NLS-1$	

	String SHOULD_SHOW_SELCTION_PAGE = "ILinkDiscoveryDataModelProperties.SELECTION_PAGE"; //$NON-NLS-1$	

}
