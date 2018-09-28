/*******************************************************************************
 * Copyright (c) 2003, 2007 IBM Corporation Licensed Material - Property of IBM. All rights reserved.
 *  
 * US Government Users Restricted Rights - Use, duplication or disclosure v1.0 restricted by GSA ADP
 * Schedule Contract with IBM Corp.
 * 
 * Contributors: IBM Corporation - initial API and implementation
 *******************************************************************************/
package com.ibm.ccl.soa.deploy.internal.core.validator.resolution.param;

import com.ibm.ccl.soa.deploy.core.validator.resolution.param.IDeployParameterizedResolution;

/**
 * Clients should not use the Properties interface directly, but instead should refer to the
 * type-safe API class
 * {@link com.ibm.ccl.soa.deploy.core.validator.resolution.datamodel.ResolutionDataModel}. The
 * properties interface is required by the Smart Datamodels Framework (SDF).
 * 
 * @see com.ibm.ccl.soa.deploy.core.validator.resolution.datamodel.ResolutionDataModel
 * @generated (mde.utilities.datamodels)
 */
public interface IResolutionDataModelProperties {

	/**
	 * 
	 * idenitifier
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
	String NAME = "IResolutionDataModelProperties.NAME"; //$NON-NLS-1$

	/**
	 * 
	 * The Description property.
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
	String DESCRIPTION = "IResolutionDataModelProperties.DESCRIPTION"; //$NON-NLS-1$

	/**
	 * 
	 * The ValueSet property.
	 * 
	 * <p>
	 * <b>[Required]</b>
	 * </p>
	 * 
	 * <p>
	 * Type = {@link boolean}.
	 * </p>
	 * 
	 * @generated (mde.utilities.datamodels)
	 */
	String VALUE_SET = "IResolutionDataModelProperties.VALUE_SET"; //$NON-NLS-1$

	/**
	 * 
	 * The ValidValueListExclusive property.
	 * 
	 * <p>
	 * <b>[Required]</b>
	 * </p>
	 * 
	 * <p>
	 * Type = {@link boolean}.
	 * </p>
	 * 
	 * @generated (mde.utilities.datamodels)
	 */
	String VALID_VALUE_LIST_EXCLUSIVE = "IResolutionDataModelProperties.VALID_VALUE_LIST_EXCLUSIVE"; //$NON-NLS-1$

	/**
	 * 
	 * parent resolution adding children datamodels
	 * 
	 * <p>
	 * <b>[Required]</b>
	 * </p>
	 * 
	 * <p>
	 * Type = {@link IDeployParameterizedResolution}.
	 * </p>
	 * 
	 * @generated (mde.utilities.datamodels)
	 */
	String RESOLUTION = "IResolutionDataModelProperties.RESOLUTION"; //$NON-NLS-1$	

	/**
	 * 
	 * The ValidValues property.
	 * 
	 * <p>
	 * <b>[Required]</b>
	 * </p>
	 * 
	 * <p>
	 * Type = {@link List&lt;IDeployResolutionParameterValueDescriptor&gt;}.
	 * </p>
	 * 
	 * @generated (mde.utilities.datamodels)
	 */
	String VALID_VALUES = "IResolutionDataModelProperties.VALID_VALUES"; //$NON-NLS-1$	

	/**
	 * 
	 * type of data
	 * 
	 * <p>
	 * <b>[Required]</b>
	 * </p>
	 * 
	 * <p>
	 * Type = {@link Class}.
	 * </p>
	 * 
	 * @generated (mde.utilities.datamodels)
	 */
	String TYPE = "IResolutionDataModelProperties.TYPE"; //$NON-NLS-1$	

	/**
	 * 
	 * The Value property.
	 * 
	 * <p>
	 * <b>[Required]</b>
	 * </p>
	 * 
	 * <p>
	 * Type = {@link Object}.
	 * </p>
	 * 
	 * @generated (mde.utilities.datamodels)
	 */
	String VALUE = "IResolutionDataModelProperties.VALUE"; //$NON-NLS-1$	

	/**
	 * 
	 * The DefaultValue property.
	 * 
	 * <p>
	 * <b>[Required]</b>
	 * </p>
	 * 
	 * <p>
	 * Type = {@link Object}.
	 * </p>
	 * 
	 * @generated (mde.utilities.datamodels)
	 */
	String DEFAULT_VALUE = "IResolutionDataModelProperties.DEFAULT_VALUE"; //$NON-NLS-1$	

}
