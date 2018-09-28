/*******************************************************************************
 * Copyright (c) 2003, 2007 IBM Corporation Licensed Material - Property of IBM. All rights reserved.
 *  
 * US Government Users Restricted Rights - Use, duplication or disclosure v1.0 restricted by GSA ADP
 * Schedule Contract with IBM Corp.
 * 
 * Contributors: IBM Corporation - initial API and implementation
 *******************************************************************************/

package com.ibm.ccl.soa.deploy.os.validator.pattern.attribute;

import com.ibm.ccl.soa.deploy.core.validator.status.ICoreProblemType;
import com.ibm.ccl.soa.deploy.core.validator.status.IDeployAttributeStatus;
import com.ibm.ccl.soa.deploy.core.validator.status.IDeployStatus;
import com.ibm.ccl.soa.deploy.os.OperatingSystem;
import com.ibm.ccl.soa.deploy.os.OperatingSystemUnit;
import com.ibm.ccl.soa.deploy.os.OsDeployPlugin;
import com.ibm.ccl.soa.deploy.os.OsPackage;
import com.ibm.ccl.soa.deploy.os.Port;
import com.ibm.ccl.soa.deploy.os.PortConsumer;
import com.ibm.ccl.soa.deploy.os.User;
import com.ibm.ccl.soa.deploy.os.UserGroup;
import com.ibm.ccl.soa.deploy.os.WindowsDirectory;
import com.ibm.ccl.soa.deploy.os.WindowsLocalService;

/**
 * {@link IDeployStatus#getValidatorID()} declarations for the {@link OsPackage} deploy domain.
 */
public interface IOsDomainValidators {

	/**
	 * <ul>
	 * <li>ID ={@value}
	 * <li>Status = {@link IDeployAttributeStatus}
	 * <li>Problem = {@link ICoreProblemType#OBJECT_ATTRIBUTE_UNDEFINED}
	 * <li>Description = The {@link OperatingSystem#getHostname()} must not be null or empty.
	 * </ul>
	 */
	public final static String OPERATING_SYSTEM_UNIT_OS_HOSTNAME_001 = OsDeployPlugin.PLUGIN_ID
			+ ".OPERATING_SYSTEM_UNIT_OS_HOSTNAME_001"; //$NON-NLS-1$

	/**
	 * <ul>
	 * <li>ID ={@value}
	 * <li>Status = {@link IDeployAttributeStatus}
	 * <li>Problem = {@link ICoreProblemType#OBJECT_ATTRIBUTE_NOT_UNIQUE}
	 * <li>Description = The {@link OperatingSystem#getHostname()} is not unique in the topology.
	 * </ul>
	 */
	public final static String OPERATING_SYSTEM_UNIT_OS_HOSTNAME_002 = OsDeployPlugin.PLUGIN_ID
			+ ".OPERATING_SYSTEM_UNIT_OS_HOSTNAME_002"; //$NON-NLS-1$

	/**
	 * <ul>
	 * <li>ID ={@value}
	 * <li>Status = {@link IDeployAttributeStatus}
	 * <li>Problem = {@link ICoreProblemType#OBJECT_ATTRIBUTE_INVALID}
	 * <li>Description = The {@link Port} conflicts with another {@link Port } on the hosting
	 * operating system.
	 * </ul>
	 */
	public final static String PORT_CONFIG_PORT_CONFLICT_001 = OsDeployPlugin.PLUGIN_ID
			+ ".PORT_CONFIG_PORT_CONFLICT_001"; //$NON-NLS-1$	

	/**
	 * <ul>
	 * <li>ID ={@value}
	 * <li>Status = {@link IDeployAttributeStatus}
	 * <li>Problem = {@link ICoreProblemType#OBJECT_ATTRIBUTE_INVALID}
	 * <li>Description = The {@link OperatingSystem#getOsType()} is invalid for a
	 * WindowsOperatingSystem capability.
	 * </ul>
	 */
	public final static String OS_TYPE_INVALID_FOR_WINDOWS_OPERATING_SYSTEM_001 = OsDeployPlugin.PLUGIN_ID
			+ ".OS_TYPE_INVALID_FOR_WINDOWS_OPERATING_SYSTEM_001"; //$NON-NLS-1$	

	/**
	 * <ul>
	 * <li>ID ={@value}
	 * <li>Status = {@link IDeployAttributeStatus}
	 * <li>Problem = {@link ICoreProblemType#OBJECT_ATTRIBUTE_UNDEFINED}
	 * <li>Description = The {@link User#getUserId()} must not be null or empty.
	 * </ul>
	 */
	public final static String USER_UNIT_USER_ID_001 = OsDeployPlugin.PLUGIN_ID
			+ ".USER_UNIT_USER_ID_001"; //$NON-NLS-1$

	/**
	 * <ul>
	 * <li>ID ={@value}
	 * <li>Status = {@link IDeployAttributeStatus}
	 * <li>Problem = {@link ICoreProblemType#OBJECT_ATTRIBUTE_NOT_UNIQUE}
	 * <li>Description = The {@link User#getUserId()} must be unique in its {@link OperatingSystem}
	 * host.
	 * </ul>
	 */
	public final static String USER_UNIT_USER_ID_002 = OsDeployPlugin.PLUGIN_ID
			+ ".USER_UNIT_USER_ID_002"; //$NON-NLS-1$

	/**
	 * <ul>
	 * <li>ID ={@value}
	 * <li>Status = {@link IDeployAttributeStatus}
	 * <li>Problem = {@link ICoreProblemType#OBJECT_ATTRIBUTE_NOT_UNIQUE}
	 * <li>Description = The {@link UserGroup#getGroupName()} must be unique in its
	 * {@link OperatingSystem} host.
	 * </ul>
	 */
	public final static String USER_GROUP_UNIT_GROUP_NAME_ID_001 = OsDeployPlugin.PLUGIN_ID
			+ ".USER_GROUP_UNIT_GROUP_NAME_ID_001"; //$NON-NLS-1$	

	/**
	 * <ul>
	 * <li>ID ={@value}
	 * <li>Status = {@link IDeployAttributeStatus}
	 * <li>Problem = {@link ICoreProblemType#OBJECT_ATTRIBUTE_UNDEFINED}
	 * <li>Description = The {@link User#getUserPassword()} must not be null or empty.
	 * </ul>
	 */
	public final static String USER_UNIT_USER_PASSWORD_001 = OsDeployPlugin.PLUGIN_ID
			+ ".USER_UNIT_USER_PASSWORD_001"; //$NON-NLS-1$

	/**
	 * <ul>
	 * <li>ID ={@value}
	 * <li>Status = {@link IDeployAttributeStatus}
	 * <li>Problem = {@link ICoreProblemType#OBJECT_ATTRIBUTE_UNDEFINED}
	 * <li>Description = The {@link UserGroup#getGroupName()} must not be null or empty.
	 * </ul>
	 */
	public final static String USER_GROUP_UNIT_GROUP_NAME_001 = OsDeployPlugin.PLUGIN_ID
			+ ".USER_GROUP_UNIT_GROUP_NAME_001"; //$NON-NLS-1$	

	/**
	 * <ul>
	 * <li>ID ={@value}
	 * <li>Status = {@link IDeployAttributeStatus}
	 * <li>Problem = {@link ICoreProblemType#OBJECT_ATTRIBUTE_UNDEFINED}
	 * <li>Description = The {@link Port#getPortName()} must not be null or empty.
	 * </ul>
	 */
	public final static String PORT_CONFIG_UNIT_PORT_NAME_NOT_EMPTY_001 = OsDeployPlugin.PLUGIN_ID
			+ ".PORT_CONFIG_UNIT_PORT_NAME_NOT_EMPTY_001"; //$NON-NLS-1$

	/**
	 * <ul>
	 * <li>ID ={@value}
	 * <li>Status = {@link IDeployAttributeStatus}
	 * <li>Problem = {@link ICoreProblemType#OBJECT_ATTRIBUTE_NOT_UNIQUE}
	 * <li>Description = The {@link User#getUserId()} must be unique in its {@link OperatingSystem}
	 * host.
	 * </ul>
	 */
	public final static String PORT_CONFIG_UNIT_PORT_NAME_UNIQUE_IN_HOST_001 = OsDeployPlugin.PLUGIN_ID
			+ ".PORT_CONFIG_UNIT_PORT_NAME_UNIQUE_IN_HOST_001"; //$NON-NLS-1$

	/**
	 * <ul>
	 * <li>ID ={@value}
	 * <li>Status = {@link IDeployStatus}
	 * <li>Problem = {@link ICoreProblemType#HOSTING_LINK_TARGET_INVALID}
	 * <li>Description = The {@link OperatingSystemUnit} must be the only OS unit hosted by its host
	 * </ul>
	 */
	public final static String OPERATING_SYSTEM_0_NOT_SINGLE_HOSTED_BY_HOST = OsDeployPlugin.PLUGIN_ID
			+ ".OPERATING_SYSTEM_0_NOT_SINGLE_HOSTED_BY_HOST"; //$NON-NLS-1$	

	/**
	 * <ul>
	 * <li>ID ={@value}
	 * <li>Status = {@link IDeployStatus}
	 * <li>Problem = {@link IOsProblemType#PORT_CONFIG_MISSING}
	 * <li>Description = A unit with {@link PortConsumer} capability is not hosting a sufficient
	 * number of configuration units with {@link Port} capability.
	 * </ul>
	 */
	public final static String PORT_CONSUMER_001 = OsDeployPlugin.PLUGIN_ID + ".PORT_CONSUMER_001"; //$NON-NLS-1$

	/**
	 * <ul>
	 * <li>ID ={@value}
	 * <li>Status = {@link IDeployStatus}
	 * <li>Problem = {@link IOsProblemType#PORT_CONFIG_COUNT_EXCEEDED}
	 * <li>Description = A unit with {@link PortConsumer} capability is hosting too many
	 * configuration units with {@link Port} capability.
	 * </ul>
	 */
	public final static String PORT_CONSUMER_002 = OsDeployPlugin.PLUGIN_ID + ".PORT_CONSUMER_002"; //$NON-NLS-1$

	/**
	 * <ul>
	 * <li>ID ={@value}
	 * <li>Status = {@link IDeployAttributeStatus}
	 * <li>Problem = {@link ICoreProblemType#OBJECT_ATTRIBUTE_INVALID}
	 * <li>Description = The {@link WindowsLocalService} user ID and password must match those of a
	 * user on the local Windows installation.
	 * </ul>
	 */
	public final static String WINDOWS_LOCAL_SERVICE_USER_AND_PASSWORD_LOCAL_001 = OsDeployPlugin.PLUGIN_ID
			+ ".WINDOWS_LOCAL_SERVICE_USER_AND_PASSWORD_LOCAL_001"; //$NON-NLS-1$;

	/**
	 * <ul>
	 * <li>ID ={@value}
	 * <li>Status = {@link IDeployAttributeStatus}
	 * <li>Problem = {@link ICoreProblemType#OBJECT_ATTRIBUTE_UNDEFINED}
	 * <li>Description = The {@link WindowsLocalService} service name must be defined.
	 * </ul>
	 */
	public final static String WINDOWS_LOCAL_SERVICE_NAME_001 = OsDeployPlugin.PLUGIN_ID
			+ ".WINDOWS_LOCAL_SERVICE_NAME_001"; //$NON-NLS-1$;

	/**
	 * <ul>
	 * <li>ID ={@value}
	 * <li>Status = {@link IDeployAttributeStatus}
	 * <li>Problem = {@link ICoreProblemType#OBJECT_ATTRIBUTE_UNDEFINED}
	 * <li>Description = The {@link WindowsDirectory} path must be a valid Windows path.
	 * </ul>
	 */
	public final static String WINDOWS_DIRECTORY_PATH_001 = OsDeployPlugin.PLUGIN_ID
			+ ".WINDOWS_DIRECTORY_PATH_001"; //$NON-NLS-1$;

}
