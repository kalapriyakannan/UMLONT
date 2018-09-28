/*******************************************************************************
 * Copyright (c) 2003, 2007 IBM Corporation Licensed Material - Property of IBM. All rights reserved.
 *  
 * US Government Users Restricted Rights - Use, duplication or disclosure v1.0 restricted by GSA ADP
 * Schedule Contract with IBM Corp.
 * 
 * Contributors: IBM Corporation - initial API and implementation
 *******************************************************************************/
package com.ibm.ccl.soa.deploy.internal.core.validator.status;

import com.ibm.ccl.soa.deploy.internal.core.DeployCoreMessages;

public interface IDeployStatusGroupType {
	/**
	 * Group status types.
	 */

	public static final String REALIZE_CONCEPTUAL_UNITS = DeployCoreMessages.IDeployStatusGroupType_Realize_Concptual_Unit_;

	public static final String PERFORM_CUSTOM_ACTIONS = DeployCoreMessages.IDeployStatusGroupType_Perform_Custom_Action_;

	public static final String HOST_UNITS = DeployCoreMessages.IDeployStatusGroupType_Host_Unit_;

	public static final String RESOLVE_MISSING_DEPENDENCIES = DeployCoreMessages.IDeployStatusGroupType_Resolve_Missing_Dependencie_;

	public static final String FIX_MISMATCHED_ATTRIBUTES = DeployCoreMessages.IDeployStatusGroupType_Fix_Mismatched_Attribute_;

	public static final String SET_MISSING_ATTRIBUTES = DeployCoreMessages.IDeployStatusGroupType_Set_Missing_Attribute_;

	public static final String OTHER = DeployCoreMessages.IDeployStatusGroupType_OTHE_;

	public static final String GLOBAL = "GLOBAL"; //$NON-NLS-1$

}
