/***************************************************************************************************
 * Copyright (c) 2003, 2007 IBM Corporation Licensed Material - Property of IBM. All rights
 * reserved.
 * 
 * US Government Users Restricted Rights - Use, duplication or disclosure v1.0 restricted by GSA ADP
 * Schedule Contract with IBM Corp.
 * 
 * Contributors: IBM Corporation - initial API and implementation
 **************************************************************************************************/
package com.ibm.ccl.soa.deploy.db2.internal.validator;

import com.ibm.ccl.soa.deploy.core.DependencyLink;
import com.ibm.ccl.soa.deploy.core.validator.status.ICoreProblemType;
import com.ibm.ccl.soa.deploy.core.validator.status.IDeployAttributeStatus;
import com.ibm.ccl.soa.deploy.core.validator.status.IDeployAttributeValueSourceStatus;
import com.ibm.ccl.soa.deploy.core.validator.status.IDeployAttributeValueStatus;
import com.ibm.ccl.soa.deploy.core.validator.status.IDeployStatus;
import com.ibm.ccl.soa.deploy.database.SQLModule;
import com.ibm.ccl.soa.deploy.database.SQLUser;
import com.ibm.ccl.soa.deploy.db2.DB2CatalogUnit;
import com.ibm.ccl.soa.deploy.db2.DB2CatalogedNode;
import com.ibm.ccl.soa.deploy.db2.DB2Client;
import com.ibm.ccl.soa.deploy.db2.DB2Database;
import com.ibm.ccl.soa.deploy.db2.DB2DatabaseUnit;
import com.ibm.ccl.soa.deploy.db2.DB2DeployPlugin;
import com.ibm.ccl.soa.deploy.db2.DB2Instance;
import com.ibm.ccl.soa.deploy.db2.DB2InstanceUnit;
import com.ibm.ccl.soa.deploy.db2.DB2JdbcDriver;
import com.ibm.ccl.soa.deploy.db2.DB2NodeCatalogUnit;
import com.ibm.ccl.soa.deploy.db2.DB2System;
import com.ibm.ccl.soa.deploy.db2.DB2SystemUnit;
import com.ibm.ccl.soa.deploy.db2.Db2Package;
import com.ibm.ccl.soa.deploy.db2.UnixDB2AdminServer;
import com.ibm.ccl.soa.deploy.db2.UnixDB2Instance;
import com.ibm.ccl.soa.deploy.db2.WindowsDB2AdminServer;
import com.ibm.ccl.soa.deploy.os.OperatingSystem;
import com.ibm.ccl.soa.deploy.os.OperatingSystemUnit;
import com.ibm.ccl.soa.deploy.os.Port;
import com.ibm.ccl.soa.deploy.os.PortConfigUnit;
import com.ibm.ccl.soa.deploy.os.User;

/**
 * Validator identifiers for the {@link Db2Package} deploy domain.
 */
public interface IDB2ValidatorID {
	/**
	 * <ul>
	 * <li>ID ={@value}
	 * <li>Status = {@link IDeployAttributeStatus}
	 * <li>Problem = {@link ICoreProblemType#OBJECT_ATTRIBUTE_INVALID}
	 * <li>Description = The {@link DB2JdbcDriver#getJdbcType()} is not type 2 or 4.
	 * </ul>
	 */
	public final static String DB2_JDBC_DRIVER_JDBC_TYPE_001 = DB2DeployPlugin.PLUGIN_ID
			+ ".DB2_JDBC_DRIVER_JDBC_TYPE_001"; //$NON-NLS-1$

	/**
	 * <ul>
	 * <li>ID ={@value}
	 * <li>Status = {@link IDeployAttributeStatus}
	 * <li>Problem = {@link ICoreProblemType#OBJECT_ATTRIBUTE_UNDEFINED} or
	 * {@link ICoreProblemType#OBJECT_ATTRIBUTE_INVALID}
	 * <li>Description = The {@link DB2JdbcDriver#getClassname()} must be a set and be a valid Java
	 * classname.
	 * </ul>
	 */
	public final static String DB2_JDBC_DRIVER_002 = DB2DeployPlugin.PLUGIN_ID
			+ ".DB2_JDBC_DRIVER_002"; //$NON-NLS-1$

	/**
	 * <ul>
	 * <li>ID ={@value}
	 * <li>Status = {@link IDeployAttributeStatus}
	 * <li>Problem = {@link ICoreProblemType#OBJECT_ATTRIBUTE_INVALID}
	 * <li>Description = The {@link DB2JdbcDriver#getClasspath()} must be a valid Java classpath.
	 * </ul>
	 */
	public final static String DB2_JDBC_DRIVER_003 = DB2DeployPlugin.PLUGIN_ID
			+ ".DB2_JDBC_DRIVER_003"; //$NON-NLS-1$	

	/**
	 * <ul>
	 * <li>ID ={@value}
	 * <li>Status = {@link IDeployAttributeStatus}
	 * <li>Problem = {@link ICoreProblemType#OBJECT_ATTRIBUTE_INVALID}
	 * <li>Description = The {@link DB2JdbcDriver#getClasspath()} must be non-null and a non-empty
	 * string.
	 * </ul>
	 */
	public final static String DB2_JDBC_DRIVER_004 = DB2DeployPlugin.PLUGIN_ID
			+ ".DB2_JDBC_DRIVER_004"; //$NON-NLS-1$		

	/**
	 * <ul>
	 * <li>ID ={@value}
	 * <li>Status = {@link IDeployAttributeStatus}
	 * <li>Problem = {@link ICoreProblemType#OBJECT_ATTRIBUTE_UNDEFINED}
	 * <li>Description = The {@link WindowsDB2AdminServer#getDasDomain()} must be non-null.
	 * </ul>
	 */
	public final static String WINDOWS_DB2_ADMIN_SERVER_DAS_DOMAIN_001 = DB2DeployPlugin.PLUGIN_ID
			+ ".WINDOWS_DB2_ADMIN_SERVER_DAS_DOMAIN_001"; //$NON-NLS-1$

	/**
	 * <ul>
	 * <li>ID ={@value}
	 * <li>Status = {@link IDeployAttributeStatus}
	 * <li>Problem = {@link ICoreProblemType#OBJECT_ATTRIBUTE_UNDEFINED}
	 * <li>Description = The {@link WindowsDB2AdminServer#getDasUserName()} must be non-null.
	 * </ul>
	 */
	public final static String WINDOWS_DB2_ADMIN_SERVER_DAS_USER_NAME_001 = DB2DeployPlugin.PLUGIN_ID
			+ ".WINDOWS_DB2_ADMIN_SERVER_DAS_USER_NAME_001"; //$NON-NLS-1$

	/**
	 * <ul>
	 * <li>ID ={@value}
	 * <li>Status = {@link IDeployAttributeStatus}
	 * <li>Problem = {@link ICoreProblemType#OBJECT_ATTRIBUTE_UNDEFINED}
	 * <li>Description = The {@link WindowsDB2AdminServer#getDasUserPassword()} must be non-null.
	 * </ul>
	 */
	public final static String WINDOWS_DB2_ADMIN_SERVER_DAS_USER_PASSWORD_001 = DB2DeployPlugin.PLUGIN_ID
			+ ".WINDOWS_DB2_ADMIN_SERVER_DAS_USER_PASSWORD_001"; //$NON-NLS-1$

	/**
	 * <ul>
	 * <li>ID ={@value}
	 * <li>Status = {@link IDeployAttributeStatus}
	 * <li>Problem = {@link ICoreProblemType#OBJECT_ATTRIBUTE_UNDEFINED}
	 * <li>Description = The {@link UnixDB2AdminServer#getDasGID()} must be non-null.
	 * </ul>
	 */
	public final static String UNIX_DB2_ADMIN_SERVER_DAS_GID_001 = DB2DeployPlugin.PLUGIN_ID
			+ ".UNIX_DB2_ADMIN_SERVER_DAS_GID_001"; //$NON-NLS-1$

	/**
	 * <ul>
	 * <li>ID ={@value}
	 * <li>Status = {@link IDeployAttributeStatus}
	 * <li>Problem = {@link ICoreProblemType#OBJECT_ATTRIBUTE_UNDEFINED}
	 * <li>Description = The {@link UnixDB2AdminServer#getDasGroupName()} must be non-null.
	 * </ul>
	 */
	public final static String UNIX_DB2_ADMIN_SERVER_DAS_GROUP_NAME_001 = DB2DeployPlugin.PLUGIN_ID
			+ ".UNIX_DB2_ADMIN_SERVER_DAS_GROUP_NAME_001"; //$NON-NLS-1$

	/**
	 * <ul>
	 * <li>ID ={@value}
	 * <li>Status = {@link IDeployAttributeStatus}
	 * <li>Problem = {@link ICoreProblemType#OBJECT_ATTRIBUTE_UNDEFINED}
	 * <li>Description = The {@link UnixDB2AdminServer#getDasUID()} must be non-null.
	 * </ul>
	 */
	public final static String UNIX_DB2_ADMIN_SERVER_DAS_UID_001 = DB2DeployPlugin.PLUGIN_ID
			+ ".UNIX_DB2_ADMIN_SERVER_DAS_UID_001"; //$NON-NLS-1$

	/**
	 * <ul>
	 * <li>ID ={@value}
	 * <li>Status = {@link IDeployAttributeStatus}
	 * <li>Problem = {@link ICoreProblemType#OBJECT_ATTRIBUTE_UNDEFINED}
	 * <li>Description = The {@link UnixDB2AdminServer#getDasUserName()} must be non-null.
	 * </ul>
	 */
	public final static String UNIX_DB2_ADMIN_SERVER_DAS_USER_NAME_001 = DB2DeployPlugin.PLUGIN_ID
			+ ".UNIX_DB2_ADMIN_SERVER_DAS_USER_NAME_001"; //$NON-NLS-1$

	/**
	 * <ul>
	 * <li>ID ={@value}
	 * <li>Status = {@link IDeployAttributeStatus}
	 * <li>Problem = {@link ICoreProblemType#OBJECT_ATTRIBUTE_UNDEFINED}
	 * <li>Description = The {@link UnixDB2AdminServer#getDasUserPassword()} must be non-null.
	 * </ul>
	 */
	public final static String UNIX_DB2_ADMIN_SERVER_DAS_USER_PASSWORD_001 = DB2DeployPlugin.PLUGIN_ID
			+ ".UNIX_DB2_ADMIN_SERVER_DAS_USER_PASSWORD_001"; //$NON-NLS-1$	

	/**
	 * <ul>
	 * <li>ID ={@value}
	 * <li>Status = {@link IDeployAttributeStatus}
	 * <li>Problem = {@link ICoreProblemType#OBJECT_ATTRIBUTE_UNDEFINED}
	 * <li>Description = The {@link DB2Database#getDbName()} is null or empty.
	 * </ul>
	 */
	public final static String DB2_CATALOG_UNIT_DB_NAME_001 = DB2DeployPlugin.PLUGIN_ID
			+ ".DB2_CATALOG_UNIT_DB_NAME_001"; //$NON-NLS-1$

	/**
	 * <ul>
	 * <li>ID ={@value}
	 * <li>Status = {@link IDeployAttributeStatus}
	 * <li>Problem = {@link ICoreProblemType#OBJECT_ATTRIBUTE_INVALID}
	 * <li>Description = The {@link DB2Database} of a {@link DB2CatalogUnit} does not have a
	 * correctly propagated {@link DB2Database#getDbName()} from the {@link DB2Database} it
	 * catalogues.
	 * </ul>
	 */
	public final static String DB2_CATALOG_UNIT_DB_NAME_002 = DB2DeployPlugin.PLUGIN_ID
			+ ".DB2_CATALOG_UNIT_DB_NAME_002"; //$NON-NLS-1$

	/**
	 * <ul>
	 * <li>ID ={@value}
	 * <li>Status = {@link IDeployAttributeStatus}
	 * <li>Problem = {@link ICoreProblemType#OBJECT_ATTRIBUTE_UNDEFINED}
	 * <li>Description = The {@link DB2Database#getDbAlias()} is null or empty.
	 * </ul>
	 */
	public final static String DB2_CATALOG_UNIT_DB_ALIAS_001 = DB2DeployPlugin.PLUGIN_ID
			+ ".DB2_CATALOG_UNIT_DB_ALIAS_001"; //$NON-NLS-1$

	/**
	 * <ul>
	 * <li>ID ={@value}
	 * <li>Status = {@link IDeployAttributeStatus}
	 * <li>Problem = {@link ICoreProblemType#OBJECT_ATTRIBUTE_NOT_UNIQUE}
	 * <li>Description = The {@link DB2Database} of a {@link DB2CatalogUnit} does not have a unique
	 * {@link DB2Database#getDbAlias()} in the context of the {@link DB2NodeCatalogUnit} providing
	 * the {@link DB2Instance}.
	 * </ul>
	 */
	public final static String DB2_CATALOG_UNIT_DB_ALIAS_002 = DB2DeployPlugin.PLUGIN_ID
			+ ".DB2_CATALOG_UNIT_DB_ALIAS_002"; //$NON-NLS-1$

	/**
	 * <ul>
	 * <li>ID ={@value}
	 * <li>Status = {@link IDeployAttributeStatus}
	 * <li>Problem = {@link ICoreProblemType#OBJECT_ATTRIBUTE_INVALID}
	 * <li>Description = If set, the {@link DB2Database#getDbName()} must conform to the DB2
	 * database naming conventions in
	 * {@link "http://publib.boulder.ibm.com/infocenter/db2luw/v8/index.jsp?topic=/com.ibm.db2.udb.doc/core/c0008278.htm"}
	 * </ul>
	 */
	public final static String DB2_DATABASE_DB_NAME_001 = DB2DeployPlugin.PLUGIN_ID
			+ ".DB2_DATABASE_DB_NAME_001"; //$NON-NLS-1$

	/**
	 * <ul>
	 * <li>ID ={@value}
	 * <li>Status = {@link IDeployAttributeStatus}
	 * <li>Problem = {@link ICoreProblemType#OBJECT_ATTRIBUTE_INVALID}
	 * <li>Description = If set, nhe {@link DB2Database#getDbAlias()} must conform to the DB2
	 * database naming conventions in
	 * {@link "http://publib.boulder.ibm.com/infocenter/db2luw/v8/index.jsp?topic=/com.ibm.db2.udb.doc/core/c0008278.htm"}
	 * </ul>
	 */
	public final static String DB2_DATABASE_DB_ALIAS_001 = DB2DeployPlugin.PLUGIN_ID
			+ ".DB2_DATABASE_DB_ALIAS_001"; //$NON-NLS-1$

	/**
	 * <ul>
	 * <li>ID ={@value}
	 * <li>Status = {@link IDeployAttributeStatus}
	 * <li>Problem = {@link ICoreProblemType#OBJECT_ATTRIBUTE_UNDEFINED}
	 * <li>Description = The {@link DB2Database#getDbName()} is null or empty.
	 * </ul>
	 */
	public final static String DB2_DATABASE_UNIT_DB_NAME_001 = DB2DeployPlugin.PLUGIN_ID
			+ ".DB2_DATABASE_UNIT_DB_NAME_001"; //$NON-NLS-1$

	/**
	 * <ul>
	 * <li>ID ={@value}
	 * <li>Status = {@link IDeployAttributeStatus}
	 * <li>Problem = {@link ICoreProblemType#OBJECT_ATTRIBUTE_NOT_UNIQUE}
	 * <li>Description = The {@link DB2Database} of a {@link DB2DatabaseUnit} does not have a unique
	 * {@link DB2Database#getDbName()} in the context of the hosting {@link DB2InstanceUnit}.
	 * </ul>
	 */
	public final static String DB2_DATABASE_UNIT_DB_NAME_002 = DB2DeployPlugin.PLUGIN_ID
			+ ".DB2_DATABASE_UNIT_DB_NAME_002"; //$NON-NLS-1$

	/**
	 * <ul>
	 * <li>ID ={@value}
	 * <li>Status = {@link IDeployStatus}
	 * <li>Problem = {@link ICoreProblemType#DEPENDENCY_LINK_TARGET_HOSTING_INVALID}
	 * <li>Description = The dependency link to {@link User} from {@link DB2InstanceUnit} is between
	 * two different hosting stacks at the operating system level
	 * </ul>
	 */
	public final static String DB2_INSTANCE_USER_LINK_NON_LOCAL_001 = DB2DeployPlugin.PLUGIN_ID
			+ ".DB2_INSTANCE_USER_LINK_NON_LOCAL_001"; //$NON-NLS-1$	

	/**
	 * <ul>
	 * <li>ID ={@value}
	 * <li>Status = {@link IDeployAttributeStatus}
	 * <li>Problem = {@link ICoreProblemType#OBJECT_ATTRIBUTE_NOT_UNIQUE}
	 * <li>Description = The {@link DB2Instance} of a {@link DB2InstanceUnit} does not have a unique
	 * {@link DB2Instance#getDb2InstanceName()} in the context of the hosting {@link DB2SystemUnit}.
	 * </ul>
	 */
	public final static String DB2_INSTANCE_UNIT_INSTANCE_NAME_001 = DB2DeployPlugin.PLUGIN_ID
			+ ".DB2_INSTANCE_UNIT_INSTANCE_NAME_001"; //$NON-NLS-1$	

	/**
	 * <ul>
	 * <li>ID ={@value}
	 * <li>Status = {@link IDeployAttributeStatus}
	 * <li>Problem = {@link ICoreProblemType#OBJECT_ATTRIBUTE_NOT_UNIQUE}
	 * <li>Description = The {@link DB2System} of a {@link DB2SystemUnit} does not have a unique
	 * {@link DB2System#getInstallDir()} in the context of the hosting {@link OperatingSystemUnit}.
	 * </ul>
	 */
	public final static String DB2_SYSTEM_UNIT_INSTALL_DIR_001 = DB2DeployPlugin.PLUGIN_ID
			+ ".DB2_SYSTEM_UNIT_INSTALL_DIR_001"; //$NON-NLS-1$		

	/**
	 * <ul>
	 * <li>ID ={@value}
	 * <li>Status = {@link IDeployAttributeStatus}
	 * <li>Problem = {@link ICoreProblemType#OBJECT_ATTRIBUTE_INVALID}
	 * <li>Description = The {@link DB2System} of a {@link DB2SystemUnit} does not have a valid
	 * {@link DB2System#getInstallDir()} for the type of the hosting {@link OperatingSystemUnit}.
	 * </ul>
	 */
	public final static String DB2_SYSTEM_UNIT_INSTALL_DIR_INVALID_001 = DB2DeployPlugin.PLUGIN_ID
			+ ".DB2_SYSTEM_UNIT_INSTALL_DIR_INVALID_001"; //$NON-NLS-1$		

	/**
	 * <ul>
	 * <li>ID ={@value}
	 * <li>Status = {@link IDeployAttributeStatus}
	 * <li>Problem = {@link ICoreProblemType#OBJECT_ATTRIBUTE_INVALID}
	 * <li>Description = The {@link DB2Client} does not have a valid
	 * {@link DB2Client#getInstallDir()} for the type of the hosting {@link OperatingSystemUnit}.
	 * </ul>
	 */
	public final static String DB2_CLIENT_UNIT_CLIENT_INSTALL_DIR_INVALID_001 = DB2DeployPlugin.PLUGIN_ID
			+ ".DB2_CLIENT_UNIT_CLIENT_INSTALL_DIR_INVALID_001"; //$NON-NLS-1$		

	/**
	 * <ul>
	 * <li>ID ={@value}
	 * <li>Status = {@link IDeployAttributeStatus}
	 * <li>Problem = {@link ICoreProblemType#OBJECT_ATTRIBUTE_INVALID}
	 * <li>Description = The {@link DB2Client} of a {@link DB2SystemUnit} does not have a valid
	 * {@link DB2Client#getInstallDir()} for the type of the hosting {@link OperatingSystemUnit}.
	 * </ul>
	 */
	public final static String DB2_SYSTEM_UNIT_CLIENT_INSTALL_DIR_INVALID_001 = DB2DeployPlugin.PLUGIN_ID
			+ ".DB2_SYSTEM_UNIT_CLIENT_INSTALL_DIR_INVALID_001"; //$NON-NLS-1$		

	/**
	 * <ul>
	 * <li>ID ={@value}
	 * <li>Status = {@link IDeployAttributeValueStatus}
	 * <li>Problem = {@link ICoreProblemType#OBJECT_ATTRIBUTE_NOT_UNIQUE}
	 * <li>Description = The {@link DB2Instance} of a {@link DB2InstanceUnit} does not have a unique
	 * {@link DB2Instance#getPort()} in the context of the hosting {@link DB2SystemUnit}.
	 * </ul>
	 */
	public final static String DB2_INSTANCE_UNIT_PORT_001 = DB2DeployPlugin.PLUGIN_ID
			+ ".DB2_INSTANCE_UNIT_PORT_001"; //$NON-NLS-1$

	/**
	 * <ul>
	 * <li>ID ={@value}
	 * <li>Status = {@link IDeployAttributeStatus}
	 * <li>Problem = {@link ICoreProblemType#OBJECT_ATTRIBUTE_INVALID}
	 * <li>Description = The {@link Port} of a {@link PortConfigUnit} does not have a valid
	 * {@link Port#getPortName()} in the context of the hosting {@link DB2InstanceUnit}.
	 * </ul>
	 */
	public final static String DB2_INSTANCE_PORT_CONFIG_PORT_NAME_001 = DB2DeployPlugin.PLUGIN_ID
			+ ".DB2_INSTANCE_PORT_CONFIG_PORT_NAME_001"; //$NON-NLS-1$	

	/**
	 * <ul>
	 * <li>ID ={@value}
	 * <li>Status = {@link IDeployAttributeValueSourceStatus}
	 * <li>Problem = {@link ICoreProblemType#OBJECT_ATTRIBUTE_INVALID}
	 * <li>Description = The {@link DB2Instance} of a {@link DB2InstanceUnit} does not have a
	 * correctly propagated {@link DB2Instance#getPassword()} from the {@link User#getUserPassword()}
	 * on the {@link User} it references.
	 * </ul>
	 */
	public final static String DB2_INSTANCE_UNIT_USER_PASSWORD_FROM_USER_001 = DB2DeployPlugin.PLUGIN_ID
			+ ".DB2_INSTANCE_UNIT_USER_PASSWORD_FROM_USER_001"; //$NON-NLS-1$	

	/**
	 * <ul>
	 * <li>ID ={@value}
	 * <li>Status = {@link IDeployAttributeValueSourceStatus}
	 * <li>Problem = {@link ICoreProblemType#OBJECT_ATTRIBUTE_INVALID}
	 * <li>Description = The {@link SQLUser} of a {@link SQLModule} does not have a
	 * {@link SQLUser#getUserPassword()} matching the password of the user with the same userid on
	 * the hosting operating system.
	 * </ul>
	 */
	public final static String SQL_MODULE_USER_PASSWORD_FROM_USER_001 = DB2DeployPlugin.PLUGIN_ID
			+ ".SQL_MODULE_USER_PASSWORD_FROM_USER_001"; //$NON-NLS-1$		

	/**
	 * <ul>
	 * <li>ID ={@value}
	 * <li>Status = {@link IDeployAttributeValueStatus}
	 * <li>Problem = {@link ICoreProblemType#OBJECT_ATTRIBUTE_INVALID}
	 * <li>Description = The {@link SQLUser} of a {@link SQLModule} does not have a
	 * {@link SQLUser#getUserId()} matching the userid a user on the hosting operating system.
	 * </ul>
	 */
	public final static String SQL_MODULE_USER_NOT_FOUND_ON_OS_001 = DB2DeployPlugin.PLUGIN_ID
			+ ".SQL_MODULE_USER_NOT_FOUND_ON_OS_001"; //$NON-NLS-1$		

	/**
	 * <ul>
	 * <li>ID ={@value}
	 * <li>Status = {@link IDeployAttributeValueSourceStatus}
	 * <li>Problem = {@link ICoreProblemType#OBJECT_ATTRIBUTE_INVALID}
	 * <li>Description = The {@link DB2Instance} of a {@link DB2InstanceUnit} does not have a
	 * correctly propagated {@link DB2Instance#getUsername()} from the {@link User#getUserId()} on
	 * the {@link User} it references.
	 * </ul>
	 */
	public final static String DB2_INSTANCE_UNIT_USER_NAME_FROM_USER_001 = DB2DeployPlugin.PLUGIN_ID
			+ ".DB2_INSTANCE_UNIT_USER_NAME_FROM_USER_001"; //$NON-NLS-1$	

	/**
	 * <ul>
	 * <li>ID ={@value}
	 * <li>Status = {@link IDeployAttributeStatus}
	 * <li>Problem = {@link ICoreProblemType#OBJECT_ATTRIBUTE_UNDEFINED}
	 * <li>Description = The {@link DB2Instance#getPort()} is null or empty.
	 * </ul>
	 */
	public final static String DB2_INSTANCE_UNIT_PORT_EMPTY_001 = DB2DeployPlugin.PLUGIN_ID
			+ ".DB2_INSTANCE_UNIT_PORT_EMPTY_001"; //$NON-NLS-1$

	/**
	 * <ul>
	 * <li>ID ={@value}
	 * <li>Status = {@link IDeployAttributeStatus}
	 * <li>Problem = {@link ICoreProblemType#OBJECT_ATTRIBUTE_UNDEFINED}
	 * <li>Description = The {@link DB2Instance#getHostname()} is null or empty.
	 * </ul>
	 */
	public final static String DB2_INSTANCE_UNIT_HOSTNAME_EMPTY_001 = DB2DeployPlugin.PLUGIN_ID
			+ ".DB2_INSTANCE_UNIT_HOSTNAME_EMPTY_001"; //$NON-NLS-1$
	/**
	 * <ul>
	 * <li>ID ={@value}
	 * <li>Status = {@link IDeployAttributeStatus}
	 * <li>Problem = {@link ICoreProblemType#OBJECT_ATTRIBUTE_UNDEFINED}
	 * <li>Description = The {@link UnixDB2Instance#getFencedUserPassword()} is null or empty.
	 * </ul>
	 */
	public final static String UNIX_DB2_INSTANCE_UNIT_FENCED_USER_PASSWORD_EMPTY_001 = DB2DeployPlugin.PLUGIN_ID
			+ ".UNIX_DB2_INSTANCE_UNIT_FENCED_USER_PASSWORD_EMPTY_001"; //$NON-NLS-1$

	/**
	 * <ul>
	 * <li>ID ={@value}
	 * <li>Status = {@link IDeployAttributeStatus}
	 * <li>Problem = {@link ICoreProblemType#OBJECT_ATTRIBUTE_UNDEFINED}
	 * <li>Description = The {@link UnixDB2Instance#getFencedUserName()} is null or empty.
	 * </ul>
	 */
	public final static String UNIX_DB2_INSTANCE_UNIT_FENCED_USER_NAME_EMPTY_001 = DB2DeployPlugin.PLUGIN_ID
			+ ".UNIX_DB2_INSTANCE_UNIT_FENCED_USER_NAME_EMPTY_001"; //$NON-NLS-1$

	/**
	 * <ul>
	 * <li>ID ={@value}
	 * <li>Status = {@link IDeployAttributeValueSourceStatus}
	 * <li>Problem = {@link ICoreProblemType#OBJECT_ATTRIBUTE_INVALID}
	 * <li>Description = The {@link DB2Instance} of a {@link DB2InstanceUnit} does not have a
	 * correctly propagated {@link DB2Instance#getHostname()} from the
	 * {@link OperatingSystem#getHostname()} on the {@link OperatingSystemUnit} in the hosting stack.
	 * </ul>
	 */
	public final static String DB2_INSTANCE_UNIT_HOSTNAME_NAME_HOSTING_OS_USER_001 = DB2DeployPlugin.PLUGIN_ID
			+ ".DB2_INSTANCE_UNIT_HOSTNAME_NAME_HOSTING_OS_USER_001"; //$NON-NLS-1$	

	/**
	 * <ul>
	 * <li>ID ={@value}
	 * <li>Status = {@link IDeployAttributeValueSourceStatus}
	 * <li>Problem = {@link ICoreProblemType#OBJECT_ATTRIBUTE_INVALID}
	 * <li>Description = The {@link DB2CatalogedNode} of a {@link DB2NodeCatalogUnit} does not have
	 * a correctly propagated {@link DB2CatalogedNode#getHostname()} from the
	 * {@link DB2Instance#getHostname()} on the {@link DB2Instance} it catalogs.
	 * </ul>
	 */
	public final static String DB2_NODE_CATALOG_UNIT_HOSTNAME_001 = DB2DeployPlugin.PLUGIN_ID
			+ ".DB2_NODE_CATALOG_UNIT_HOSTNAME_001"; //$NON-NLS-1$	

	/**
	 * <ul>
	 * <li>ID ={@value}
	 * <li>Status = {@link IDeployAttributeValueSourceStatus}
	 * <li>Problem = {@link ICoreProblemType#OBJECT_ATTRIBUTE_INVALID}
	 * <li>Description = The {@link DB2CatalogedNode} of a {@link DB2NodeCatalogUnit} does not have
	 * a correctly propagated {@link DB2CatalogedNode#getPort()} from the
	 * {@link DB2Instance#getPort()} on the {@link DB2Instance} it catalogs.
	 * </ul>
	 */
	public final static String DB2_NODE_CATALOG_UNIT_PORT_001 = DB2DeployPlugin.PLUGIN_ID
			+ ".DB2_NODE_CATALOG_UNIT_PORT_001"; //$NON-NLS-1$	

	/**
	 * <ul>
	 * <li>ID ={@value}
	 * <li>Status = {@link IDeployAttributeValueSourceStatus}
	 * <li>Problem = {@link ICoreProblemType#OBJECT_ATTRIBUTE_INVALID}
	 * <li>Description = The {@link DB2CatalogedNode} of a {@link DB2NodeCatalogUnit} has an empty
	 * {@link DB2CatalogedNode#getNodeName()}
	 * </ul>
	 */
	public final static String DB2_NODE_CATALOG_UNIT_NODENAME_EMPTY_001 = DB2DeployPlugin.PLUGIN_ID
			+ ".DB2_NODE_CATALOG_UNIT_NODENAME_EMPTY_001"; //$NON-NLS-1$		

	/**
	 * <ul>
	 * <li>ID ={@value}
	 * <li>Status = {@link IDeployAttributeValueSourceStatus}
	 * <li>Problem = {@link ICoreProblemType#OBJECT_ATTRIBUTE_INVALID}
	 * <li>Description = The {@link DB2CatalogedNode} of a {@link DB2NodeCatalogUnit} has a
	 * {@link DB2CatalogedNode#getNodeName() that conflicts with the instance name of the hosting 
	 * DB2 instance}
	 * </ul>
	 */
	public final static String DB2_NODE_CATALOG_UNIT_NODENAME_CONFLICTS_WITH_CLIENT_INSTANCE_NAME_001 = DB2DeployPlugin.PLUGIN_ID
			+ ".DB2_NODE_CATALOG_UNIT_NODENAME_CONFLICTS_WITH_CLIENT_INSTANCE_NAME_001"; //$NON-NLS-1$	

	/**
	 * <ul>
	 * <li>ID ={@value}
	 * <li>Status = {@link IDeployAttributeValueSourceStatus}
	 * <li>Problem = {@link ICoreProblemType#OBJECT_ATTRIBUTE_INVALID}
	 * <li>Description = The {@link DB2CatalogedNode} of a {@link DB2NodeCatalogUnit} does not have
	 * a correctly propagated {@link DB2CatalogedNode#getNodeName()} from the
	 * {@link DB2Instance#getDb2InstanceName()} on the {@link DB2Instance} it catalogs.
	 * </ul>
	 */
	public final static String DB2_NODE_CATALOG_UNIT_NODE_NAME_001 = DB2DeployPlugin.PLUGIN_ID
			+ ".DB2_NODE_CATALOG_UNIT_NODE_NAME_001"; //$NON-NLS-1$		

	/**
	 * <ul>
	 * <li>ID ={@value}
	 * <li>Status = {@link IDeployAttributeValueSourceStatus}
	 * <li>Problem = {@link ICoreProblemType#OBJECT_ATTRIBUTE_INVALID}
	 * <li>Description = The {@link DB2CatalogedNode} of a {@link DB2NodeCatalogUnit} has a node
	 * name {@link DB2CatalogedNode#getNodeName()}that is not unique in its host
	 * </ul>
	 */
	public final static String DB2_NODE_CATALOG_UNIT_NODE_NAME_UNIQUE_IN_HOST_001 = DB2DeployPlugin.PLUGIN_ID
			+ ".DB2_NODE_CATALOG_UNIT_NODE_NAME_UNIQUE_IN_HOST_001"; //$NON-NLS-1$	

	/**
	 * <ul>
	 * <li>ID ={@value}
	 * <li>Status = {@link IDeployAttributeValueStatus}
	 * <li>Problem = {@link ICoreProblemType#OBJECT_ATTRIBUTE_INVALID}
	 * <li>Description = The {@link DB2Instance} of a {@link DB2InstanceUnit} does not have a
	 * correctly propagated {@link Port#getPort()}
	 * </ul>
	 */
	public final static String DB2_INSTANCE_PORT_VALUE_001 = DB2DeployPlugin.PLUGIN_ID
			+ ".DB2_INSTANCE_PORT_VALUE_001"; //$NON-NLS-1$	

	/**
	 * <ul>
	 * <li>ID ={@value}
	 * <li>Status = {@link IDeployStatus}
	 * <li>Problem = {@link ICoreProblemType#DEPENDENCY_LINK_TARGET_INVALID}
	 * <li>Description = The {@link DependencyLink} of a dependency requirement on a
	 * {@link DB2CatalogUnit} targets a database capability on a {@link DB2CatalogUnit}
	 * </ul>
	 */
	public final static String DB2_CATALOG_CATALOGS_CATALOG_001 = DB2DeployPlugin.PLUGIN_ID
			+ ".DB2_CATALOG_CATALOGS_CATALOG_001"; //$NON-NLS-1$		

	/**
	 * <ul>
	 * <li>ID ={@value}
	 * <li>Status = {@link IDeployStatus}
	 * <li>Problem = {@link IDB2ProblemType#INSTANCE_MISSING_LINK_TO_INSTANCE_ADMIN_USER}
	 * <li>Description = The {@link DB2Instance} is missing a dependency link link to a {@link User}
	 * that is an acceptable db2 instance administration user, and furthermore an acceptable user is
	 * not present on the hosting operating system.
	 * </ul>
	 */
	public final static String DB2_INSTANCE_MISSING_LINK_TO_MISSING_INSTANCE_ADMIN_USER = DB2DeployPlugin.PLUGIN_ID
			+ ".DB2_INSTANCE_MISSING_LINK_TO_MISSING_INSTANCE_ADMIN_USER"; //$NON-NLS-1$

}
