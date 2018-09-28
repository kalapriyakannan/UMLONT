/***************************************************************************************************
 * Copyright (c) 2003, 2007 IBM Corporation Licensed Material - Property of IBM. All rights
 * reserved.
 * 
 * US Government Users Restricted Rights - Use, duplication or disclosure v1.0 restricted by GSA ADP
 * Schedule Contract with IBM Corp.
 * 
 * Contributors: IBM Corporation - initial API and implementation
 **************************************************************************************************/
package com.ibm.ccl.soa.deploy.ihs.validator;

import com.ibm.ccl.soa.deploy.core.validator.status.ICoreProblemType;
import com.ibm.ccl.soa.deploy.core.validator.status.IDeployAttributeStatus;
import com.ibm.ccl.soa.deploy.core.validator.status.IDeployAttributeValueSourceStatus;
import com.ibm.ccl.soa.deploy.core.validator.status.IDeployStatus;
import com.ibm.ccl.soa.deploy.ihs.IhsDeployPlugin;
import com.ibm.ccl.soa.deploy.ihs.IhsPackage;
import com.ibm.ccl.soa.deploy.ihs.IhsServerUnit;
import com.ibm.ccl.soa.deploy.ihs.IhsSystem;
import com.ibm.ccl.soa.deploy.ihs.IhsUser;
import com.ibm.ccl.soa.deploy.os.User;
import com.ibm.ccl.soa.deploy.os.WindowsLocalService;

/**
 * Validators IDs for the IBM HTTP Server (IHS) domain.
 * 
 * @see IhsPackage
 * @see IDeployStatus#getValidatorID()
 */
public interface IIhsDomainValidators {

	/**
	 * <ul>
	 * <li>ID ={@value}
	 * <li>Status = {@link IDeployAttributeStatus}
	 * <li>Problem = {@link ICoreProblemType#OBJECT_ATTRIBUTE_INVALID}
	 * <li>Description = the {@link IhsSystem#getInstallLocation()} is required and must be a valid
	 * path in the hosting operating system.
	 * </ul>
	 */
	public final static String IHS_SYSTEM_INSTALL_LOCATION_001 = IhsDeployPlugin.PLUGIN_ID
			+ ".IHS_SYSTEM_INSTALL_LOCATION_001"; //$NON-NLS-1$

	/**
	 * <ul>
	 * <li>ID ={@value}
	 * <li>Status = {@link IDeployAttributeStatus}
	 * <li>Problem = {@link ICoreProblemType#OBJECT_ATTRIBUTE_UNDEFINED} or
	 * {@link ICoreProblemType#OBJECT_ATTRIBUTE_INVALID}
	 * <li>Description = the {@link IhsSystem#getInstallLocation()} is required and must be a valid
	 * path in the hosting operating system.
	 * </ul>
	 */
	public final static String IHS_SYSTEM_CONFIG_FILE_001 = IhsDeployPlugin.PLUGIN_ID
			+ ".IHS_SYSTEM_CONFIG_FILE_001"; //$NON-NLS-1$

	/**
	 * <ul>
	 * <li>ID ={@value}
	 * <li>Status = {@link IDeployAttributeStatus}
	 * <li>Problem = {@link ICoreProblemType#OBJECT_ATTRIBUTE_INVALID}
	 * <li>Description = the {@link IhsUser#getUserId()} attribute should be unique in its module
	 * host.
	 * </ul>
	 */
	public static final String IHS_USER_ID_UNIQUE = IhsDeployPlugin.PLUGIN_ID
			+ ".IHS_USER_ID_UNIQUE"; //$NON-NLS-1$

	/**
	 * <ul>
	 * <li>ID ={@value}
	 * <li>Status = {@link IDeployAttributeValueSourceStatus}
	 * <li>Problem = {@link ICoreProblemType#OBJECT_ATTRIBUTE_INVALID}
	 * <li>Description = The {@link WindowsLocalService} of a {@link IhsServerUnit} does not have a
	 * correctly propagated {@link WindowsLocalService#getServiceAccount()} from the
	 * {@link User#getUserId()} on the {@link User} it references.
	 * </ul>
	 */
	public final static String IHS_SERVER_WINDOWS_SERVICE_SERVICE_ACCOUNT_FROM_USER_001 = IhsDeployPlugin.PLUGIN_ID
			+ ".IHS_SERVER_WINDOWS_SERVICE_SERVICE_ACCOUNT_FROM_USER_001"; //$NON-NLS-1$	

	/**
	 * <ul>
	 * <li>ID ={@value}
	 * <li>Status = {@link IDeployAttributeValueSourceStatus}
	 * <li>Problem = {@link ICoreProblemType#OBJECT_ATTRIBUTE_INVALID}
	 * <li>Description = The {@link WindowsLocalService} of a {@link IhsServerUnit} does not have a
	 * correctly propagated {@link WindowsLocalService#getServiceAccountPassword()} from the
	 * {@link User#getUserPassword()} on the {@link User} it references.
	 * </ul>
	 */
	public final static String IHS_SERVER_WINDOWS_SERVICE_SERVICE_ACCOUNT_PASSWORD_FROM_USER_001 = IhsDeployPlugin.PLUGIN_ID
			+ ".IHS_SERVER_WINDOWS_SERVICE_SERVICE_ACCOUNT_FROM_USER_001"; //$NON-NLS-1$	

}
