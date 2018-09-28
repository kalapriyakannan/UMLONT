/*******************************************************************************
 * Copyright (c) 2003, 2007 IBM Corporation Licensed Material - Property of IBM. All rights reserved.
 *  
 * US Government Users Restricted Rights - Use, duplication or disclosure v1.0 restricted by GSA ADP
 * Schedule Contract with IBM Corp.
 * 
 * Contributors: IBM Corporation - initial API and implementation
 *******************************************************************************/
package com.ibm.ccl.soa.deploy.http.validator.capability;

import com.ibm.ccl.soa.deploy.core.validator.status.ICoreProblemType;
import com.ibm.ccl.soa.deploy.core.validator.status.IDeployAttributeStatus;
import com.ibm.ccl.soa.deploy.core.validator.status.IDeployStatus;
import com.ibm.ccl.soa.deploy.http.HttpDeployPlugin;
import com.ibm.ccl.soa.deploy.http.HttpUser;

/**
 * Validators IDs for the IBM HTTP domain.
 * 
 * @see IhsPackage
 * @see IDeployStatus#getValidatorID()
 */
public interface IHttpDomainValidators {

	/**
	 * <ul>
	 * <li>ID ={@value}
	 * <li>Status = {@link IDeployAttributeStatus}
	 * <li>Problem = {@link ICoreProblemType#OBJECT_ATTRIBUTE_UNDEFINED}
	 * <li>Description = {@link HttpUser#getUserId()} is required.
	 * </ul>
	 */
	public final static String HTTP_USER_USER_ID_001 = HttpDeployPlugin.PLUGIN_ID
			+ ".HTTP_USER_USER_ID_001"; //$NON-NLS-1$

	/**
	 * <ul>
	 * <li>ID ={@value}
	 * <li>Status = {@link IDeployAttributeStatus}
	 * <li>Problem = {@link ICoreProblemType#OBJECT_ATTRIBUTE_UNDEFINED}
	 * <li>Description = {@link HttpUser#getUserPassword()} is required.
	 * </ul>
	 */
	public final static String HTTP_USER_USER_PASSWORD_001 = HttpDeployPlugin.PLUGIN_ID
			+ ".HTTP_USER_USER_PASSWORD_001"; //$NON-NLS-1$
}
