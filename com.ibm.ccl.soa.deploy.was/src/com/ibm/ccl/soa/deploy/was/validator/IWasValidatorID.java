/***************************************************************************************************
 * Copyright (c) 2003, 2007 IBM Corporation Licensed Material - Property of IBM. All rights
 * reserved.
 * 
 * US Government Users Restricted Rights - Use, duplication or disclosure v1.0 restricted by GSA ADP
 * Schedule Contract with IBM Corp.
 * 
 * Contributors: IBM Corporation - initial API and implementation
 **************************************************************************************************/
package com.ibm.ccl.soa.deploy.was.validator;

import com.ibm.ccl.soa.deploy.core.validator.status.ICoreProblemType;
import com.ibm.ccl.soa.deploy.core.validator.status.IDeployAttributeStatus;
import com.ibm.ccl.soa.deploy.core.validator.status.IDeployAttributeValueSourceStatus;
import com.ibm.ccl.soa.deploy.core.validator.status.IDeployAttributeValueStatus;
import com.ibm.ccl.soa.deploy.core.validator.status.IDeployStatus;
import com.ibm.ccl.soa.deploy.database.Database;
import com.ibm.ccl.soa.deploy.db2.DB2Database;
import com.ibm.ccl.soa.deploy.db2.DB2JdbcDriver;
import com.ibm.ccl.soa.deploy.j2ee.J2CAuthenticationDataEntry;
import com.ibm.ccl.soa.deploy.j2ee.J2EEDatasource;
import com.ibm.ccl.soa.deploy.java.JdbcProvider;
import com.ibm.ccl.soa.deploy.os.OperatingSystemUnit;
import com.ibm.ccl.soa.deploy.os.User;
import com.ibm.ccl.soa.deploy.os.WindowsOperatingSystem;
import com.ibm.ccl.soa.deploy.was.DB2JdbcProvider;
import com.ibm.ccl.soa.deploy.was.DB2JdbcProviderUnit;
import com.ibm.ccl.soa.deploy.was.SharedLibraryEntry;
import com.ibm.ccl.soa.deploy.was.WASJ2CAuthenticationDataEntry;
import com.ibm.ccl.soa.deploy.was.WASJ2CAuthenticationUnit;
import com.ibm.ccl.soa.deploy.was.WasCell;
import com.ibm.ccl.soa.deploy.was.WasCellUnit;
import com.ibm.ccl.soa.deploy.was.WasCluster;
import com.ibm.ccl.soa.deploy.was.WasClusterUnit;
import com.ibm.ccl.soa.deploy.was.WasDatasource;
import com.ibm.ccl.soa.deploy.was.WasDatasourceUnit;
import com.ibm.ccl.soa.deploy.was.WasDefaultMessagingQueueDestinationUnit;
import com.ibm.ccl.soa.deploy.was.WasDefaultMessagingTopicDestinationUnit;
import com.ibm.ccl.soa.deploy.was.WasDeployPlugin;
import com.ibm.ccl.soa.deploy.was.WasDeploymentManagerUnit;
import com.ibm.ccl.soa.deploy.was.WasEarClassloaderPolicyConstraint;
import com.ibm.ccl.soa.deploy.was.WasEndpointListenerConfiguration;
import com.ibm.ccl.soa.deploy.was.WasEndpointListenerUnit;
import com.ibm.ccl.soa.deploy.was.WasJMSActivationSpecificationUnit;
import com.ibm.ccl.soa.deploy.was.WasMessagingEngineUnit;
import com.ibm.ccl.soa.deploy.was.WasModuleStartWeightConstraint;
import com.ibm.ccl.soa.deploy.was.WasNode;
import com.ibm.ccl.soa.deploy.was.WasNodeGroup;
import com.ibm.ccl.soa.deploy.was.WasNodeGroupUnit;
import com.ibm.ccl.soa.deploy.was.WasNodeUnit;
import com.ibm.ccl.soa.deploy.was.WasNodeWindowsServiceUnit;
import com.ibm.ccl.soa.deploy.was.WasPackage;
import com.ibm.ccl.soa.deploy.was.WasSIBus;
import com.ibm.ccl.soa.deploy.was.WasSIBusUnit;
import com.ibm.ccl.soa.deploy.was.WasSecurity;
import com.ibm.ccl.soa.deploy.was.WasSecuritySubjectConstraint;
import com.ibm.ccl.soa.deploy.was.WasServer;
import com.ibm.ccl.soa.deploy.was.WasSharedLibraryEntryUnit;
import com.ibm.ccl.soa.deploy.was.WasSibDestination;
import com.ibm.ccl.soa.deploy.was.WasSibInboundPort;
import com.ibm.ccl.soa.deploy.was.WasSibInboundPortUnit;
import com.ibm.ccl.soa.deploy.was.WasSibInboundService;
import com.ibm.ccl.soa.deploy.was.WasSibInboundServiceUnit;
import com.ibm.ccl.soa.deploy.was.WasSibMediation;
import com.ibm.ccl.soa.deploy.was.WasSibMediationUnit;
import com.ibm.ccl.soa.deploy.was.WasSibOutboundPort;
import com.ibm.ccl.soa.deploy.was.WasSibOutboundPortUnit;
import com.ibm.ccl.soa.deploy.was.WasSibOutboundService;
import com.ibm.ccl.soa.deploy.was.WasSibOutboundServiceUnit;
import com.ibm.ccl.soa.deploy.was.WasSystem;
import com.ibm.ccl.soa.deploy.was.WasSystemUnit;
import com.ibm.ccl.soa.deploy.was.WasV5Datasource;
import com.ibm.ccl.soa.deploy.was.WasWarClassloaderPolicyConstraint;
import com.ibm.ccl.soa.deploy.was.WebsphereAppServerUnit;

/**
 * Validator identifiers for the {@link WasPackage} deploy domain.
 */
public interface IWasValidatorID {

	/**
	 * <ul>
	 * <li>ID ={@value}
	 * <li>Status = {@link IDeployAttributeValueSourceStatus}
	 * <li>Problem = {@link ICoreProblemType#OBJECT_ATTRIBUTE_INVALID}
	 * <li>Description = The {@link WASJ2CAuthenticationDataEntry} of a
	 * {@link WASJ2CAuthenticationUnit} does not have a correctly propagated
	 * {@link WASJ2CAuthenticationDataEntry#getUserId()} from the {@link User#getUserId()} on the
	 * {@link User} it references.
	 * </ul>
	 */
	public final static String WAS_J2C_AUTH_UNIT_UNIT_USER_ID_FROM_USER_001 = WasDeployPlugin.pluginID
			+ ".WAS_J2C_AUTH_UNIT_UNIT_USER_ID_FROM_USER_001"; //$NON-NLS-1$	

	/**
	 * <ul>
	 * <li>ID ={@value}
	 * <li>Status = {@link IDeployAttributeValueSourceStatus}
	 * <li>Problem = {@link ICoreProblemType#OBJECT_ATTRIBUTE_INVALID}
	 * <li>Description = The {@link WASJ2CAuthenticationDataEntry} of a
	 * {@link WASJ2CAuthenticationUnit} does not have a correctly propagated
	 * {@link WASJ2CAuthenticationDataEntry#getPassword()} from the {@link User#getUserPassword()} on
	 * the {@link User} it references.
	 * </ul>
	 */
	public final static String WAS_J2C_AUTH_UNIT_UNIT_USER_PASSWORD_FROM_USER_001 = WasDeployPlugin.pluginID
			+ ".WAS_J2C_AUTH_UNIT_UNIT_USER_PASSWORD_FROM_USER_001"; //$NON-NLS-1$		

	/**
	 * <ul>
	 * <li>ID ={@value}
	 * <li>Status = {@link IDeployStatus}
	 * <li>Problem = {@link ICoreProblemType#DEPENDENCY_LINK_TARGET_HOSTING_INVALID}
	 * <li>Description = The dependency link to {@link WASJ2CAuthenticationDataEntry} from
	 * {@link WasDatasourceUnit} is between two different WAS cells.
	 * </ul>
	 */
	public final static String WAS_J2C_AUTHENTICATION_DATA_ENTRY_LINK_NON_LOCAL_001 = WasDeployPlugin.pluginID
			+ ".WAS_J2C_AUTHENTICATION_DATA_ENTRY_LINK_NON_LOCAL_001"; //$NON-NLS-1$	

	/**
	 * <ul>
	 * <li>ID ={@value}
	 * <li>Status = {@link IDeployAttributeValueSourceStatus}
	 * <li>Problem = {@link ICoreProblemType#OBJECT_ATTRIBUTE_INVALID}
	 * <li>Description = The {@link WASJ2CAuthenticationDataEntry} of a
	 * {@link WASJ2CAuthenticationUnit} does not have a unique alias relative to other entries on the
	 * same host.
	 * </ul>
	 */
	public final static String WAS_J2C_AUTH_UNIT_UNIT_ALIAS_UNIQUE_001 = WasDeployPlugin.pluginID
			+ ".WAS_J2C_AUTH_UNIT_UNIT_ALIAS_UNIQUE_001"; //$NON-NLS-1$		

	/**
	 * <ul>
	 * <li>ID ={@value}
	 * <li>Status = {@link IDeployStatus}
	 * <li>Problem = {@link ICoreProblemType#DEPENDENCY_LINK_TARGET_HOSTING_INVALID}
	 * <li>Description = The dependency link to {@link DB2JdbcProvider} from
	 * {@link WasDatasourceUnit} is between two different hosting stacks at the WAS server level
	 * </ul>
	 */
	public final static String WAS_DATASOURCE_JDBCPROVIDER_LINK_NON_LOCAL_001 = WasDeployPlugin.pluginID
			+ ".WAS_DATASOURCE_JDBCPROVIDER_LINK_NON_LOCAL_001"; //$NON-NLS-1$	

	/**
	 * <ul>
	 * <li>ID ={@value}
	 * <li>Status = {@link IDeployStatus}
	 * <li>Problem = {@link ICoreProblemType#DEPENDENCY_LINK_TARGET_HOSTING_INVALID}
	 * <li>Description = The dependency link to {@link Database} from {@link WasDatasourceUnit} is
	 * between two different hosting stacks at the WAS server level
	 * </ul>
	 */
	public final static String WAS_DATASOURCE_TYPE_2_DATABASE_LINK_NON_LOCAL_001 = WasDeployPlugin.pluginID
			+ ".WAS_DATASOURCE_TYPE_2_DATABASE_LINK_NON_LOCAL_001"; //$NON-NLS-1$		

	/**
	 * <ul>
	 * <li>ID ={@value}
	 * <li>Status = {@link IDeployAttributeStatus}
	 * <li>Problem = {@link ICoreProblemType#OBJECT_ATTRIBUTE_NOT_UNIQUE}
	 * <li>Description = The {@link WasDatasource} of a {@link WasDatasourceUnit} does not have a
	 * unique {@link J2EEDatasource#getJndiName()} in the context of the hosting
	 * {@link WebsphereAppServerUnit}.
	 * </ul>
	 */
	public final static String WAS_DATASOURCE_UNIT_JNDI_NAME_UNIQUENESS_001 = WasDeployPlugin.pluginID
			+ ".WAS_DATASOURCE_UNIT_JNDI_NAME_UNIQUENESS_001"; //$NON-NLS-1$	

	/**
	 * <ul>
	 * <li>ID ={@value}
	 * <li>Status = {@link IDeployStatus}
	 * <li>Problem = {@link ICoreProblemType#OBJECT_ATTRIBUTE_INVALID}
	 * <li>Description = The {@link WasV5Datasource} of a {@link WasV5DatasourceUnit} does not have
	 * a valid {@link WasV5Datasource#getDataSourceHelperClassName()}; the acceptable values are
	 * limited by the hosting {@link JdbcProvider}
	 * </ul>
	 */
	public final static String WAS_DATASOURCE_DATA_STORE_HELPER_CLASS_NAME_INVALID = WasDeployPlugin.pluginID
			+ ".WAS_DATASOURCE_DATA_STORE_HELPER_CLASS_NAME_INVALID"; //$NON-NLS-1$	

	/**
	 * <ul>
	 * <li>ID ={@value}
	 * <li>Status = {@link IDeployStatus}
	 * <li>Problem = {@link ICoreProblemType#DEPENDENCY_LINK_TARGET_INVALID}
	 * <li>Description = The dependency link to {@link Database} from {@link WasDatasourceUnit}
	 * should be to a DB2 database
	 * </ul>
	 */
	public final static String WAS_V5_DB2DATASOURCE_WITH_REQUIREMENT_FOR_NON_DB2_DATABASE_001 = WasDeployPlugin.pluginID
			+ ".WAS_V5_DB2DATASOURCE_WITH_REQUIREMENT_FOR_NON_DB2_DATABASE_001"; //$NON-NLS-1$	

	/**
	 * <ul>
	 * <li>ID ={@value}
	 * <li>Status = {@link IDeployAttributeValueSourceStatus}
	 * <li>Problem = {@link ICoreProblemType#OBJECT_ATTRIBUTE_INVALID}
	 * <li>Description = The {@link DB2JdbcProvider} of a {@link DB2JdbcProviderUnit} does not have
	 * a correctly propagated {@link DB2JdbcProvider#getJdbcType()} from the
	 * {@link DB2JdbcDriver#getJdbcType()} on the {@link DB2JdbcDriver} it references.
	 * </ul>
	 */
	public final static String DB2_JDBC_PROVIDER_JDBC_TYPE_FROM_DB2_JDBC_DRIVER_JDBC_TYPE = WasDeployPlugin.pluginID
			+ ".DB2_JDBC_PROVIDER_JDBC_TYPE_FROM_DB2_JDBC_DRIVER_JDBC_TYPE"; //$NON-NLS-1$	

	//
	/**
	 * <ul>
	 * <li>ID ={@value}
	 * <li>Status = {@link IDeployStatus}
	 * <li>Problem = {@link ICoreProblemType#DEPENDENCY_LINK_TARGET_HOSTING_INVALID}
	 * <li>Description = The dependency link to {@link DB2JdbcDriver} from
	 * {@link DB2JdbcProviderUnit} is between two different hosting stacks at the WAS server level
	 * </ul>
	 */
	public final static String WAS_DB2JDBCPROVIDER_DB2JDBCDRIVER_LINK_NON_LOCAL_001 = WasDeployPlugin.pluginID
			+ ".WAS_DB2JDBCPROVIDER_DB2JDBCDRIVER_LINK_NON_LOCAL_001"; //$NON-NLS-1$		

	/**
	 * <ul>
	 * <li>ID ={@value}
	 * <li>Status = {@link IDeployAttributeStatus}
	 * <li>Problem = {@link ICoreProblemType#OBJECT_ATTRIBUTE_NOT_UNIQUE}
	 * <li>Description = The {@link WasSystem} of a {@link WasSystemUnit} does not have a unique
	 * {@link WasSystem#getWasHome()} in the context of the hosting {@link OperatingSystemUnit}.
	 * </ul>
	 */
	public final static String WAS_SYSTEM_WAS_HOME_UNIQUENESS_001 = WasDeployPlugin.pluginID
			+ ".WAS_SYSTEM_WAS_HOME_UNIQUENESS_001"; //$NON-NLS-1$		

	/**
	 * <ul>
	 * <li>ID ={@value}
	 * <li>Status = {@link IDeployStatus}
	 * <li>Problem = {@link IWASProblemType#WAS_BASE_MUST_HAVE_EXACTLY_ONE_PROFILE}
	 * <li>Description = A {@link WasSystem} with {@link WasSystem#getWasEdition()} base, hosts more
	 * than one profiles.
	 * </ul>
	 */
	public final static String WAS_SYSTEM_BASE_PROFILE_CARDINALITY_001 = WasDeployPlugin.pluginID
			+ ".WAS_SYSTEM_BASE_PROFILE_CARDINALITY_001"; //$NON-NLS-1$		

	/**
	 * <ul>
	 * <li>ID ={@value}
	 * <li>Status = {@link IDeployStatus}
	 * <li>Problem = {@link IWASProblemType#WAS_BASE_MAY_ONLY_HAVE_ONE_WEBSERVER_NODE}
	 * <li>Description = A {@link WasSystem} with {@link WasSystem#getWasEdition()} base, hosts more
	 * than one none profile type nodes.
	 * </ul>
	 */
	public final static String WAS_SYSTEM_BASE_PROFILE_CARDINALITY_002 = WasDeployPlugin.pluginID
			+ ".WAS_SYSTEM_BASE_PROFILE_CARDINALITY_002"; //$NON-NLS-1$		

	/**
	 * <ul>
	 * <li>ID ={@value}
	 * <li>Status = {@link IDeployAttributeStatus}
	 * <li>Problem = {@link ICoreProblemType#OBJECT_ATTRIBUTE_NOT_UNIQUE}
	 * <li>Description = The {@link WasServer} of a {@link WebsphereAppServerUnit} does not have a
	 * unique {@link WasServer#getServerName()} in the context of the hosting
	 * {@link OperatingSystemUnit}.
	 * </ul>
	 */
	public final static String WAS_APP_SERVER_SERVER_NAME_UNIQUENESS_001 = WasDeployPlugin.pluginID
			+ ".WAS_APP_SERVER_SERVER_NAME_UNIQUENESS_001"; //$NON-NLS-1$	

	/**
	 * <ul>
	 * <li>ID ={@value}
	 * <li>Status = {@link IDeployAttributeStatus}
	 * <li>Problem = {@link ICoreProblemType#OBJECT_ATTRIBUTE_UNDEFINED}
	 * <li>Description = The {@link WasServer} of a {@link WebsphereAppServerUnit} has an unset or
	 * empty {@link WasServer#getServerName()} value
	 * </ul>
	 */
	public final static String WAS_APP_SERVER_SERVER_NAME_EMPTY_001 = WasDeployPlugin.pluginID
			+ ".WAS_APP_SERVER_SERVER_NAME_EMPTY_001"; //$NON-NLS-1$		

	/**
	 * <ul>
	 * <li>ID ={@value}
	 * <li>Status = {@link IDeployAttributeStatus}
	 * <li>Problem = {@link ICoreProblemType#OBJECT_ATTRIBUTE_UNDEFINED}
	 * <li>Description = The {@link WasServer} of a {@link WebsphereAppServerUnit} has an unset or
	 * empty {@link WasServer#getWasVersion()} value
	 * </ul>
	 */
	public final static String WAS_APP_SERVER_WAS_VERSION_EMPTY_001 = WasDeployPlugin.pluginID
			+ ".WAS_APP_SERVER_WAS_VERSION_EMPTY_001"; //$NON-NLS-1$	

	/**
	 * <ul>
	 * <li>ID ={@value}
	 * <li>Status = {@link IDeployAttributeStatus}
	 * <li>Problem = {@link ICoreProblemType#OBJECT_ATTRIBUTE_UNDEFINED}
	 * <li>Description = The {@link WasSystem} of a {@link WasSystemUnit} has an unset or empty
	 * {@link WasSystem#getWasVersion()} value
	 * </ul>
	 */
	public final static String WAS_SYSTEM_WAS_VERSION_EMPTY_001 = WasDeployPlugin.pluginID
			+ ".WAS_SYSTEM_WAS_VERSION_EMPTY_001"; //$NON-NLS-1$	

	/**
	 * <ul>
	 * <li>ID ={@value}
	 * <li>Status = {@link IDeployAttributeStatus}
	 * <li>Problem = {@link ICoreProblemType#OBJECT_ATTRIBUTE_UNDEFINED}
	 * <li>Description = The {@link WasSystem} of a {@link WasSystemUnit} has an unset or empty
	 * {@link WasSystem#getWasHome()} value
	 * </ul>
	 */
	public final static String WAS_SYSTEM_WAS_HOME_EMPTY_001 = WasDeployPlugin.pluginID
			+ ".WAS_SYSTEM_WAS_HOME_EMPTY_001"; //$NON-NLS-1$		

	/**
	 * <ul>
	 * <li>ID ={@value}
	 * <li>Status = {@link IDeployAttributeStatus}
	 * <li>Problem = {@link ICoreProblemType#OBJECT_ATTRIBUTE_UNDEFINED}
	 * <li>Description = The {@link WasSystem} of a {@link WasSystemUnit} has an unset or empty
	 * {@link WasSystem#getInstallerDir()} value
	 * </ul>
	 */
	public final static String WAS_SYSTEM_INSTALLER_DIR_EMPTY_001 = WasDeployPlugin.pluginID
			+ ".WAS_SYSTEM_INSTALLER_DIR_EMPTY_001"; //$NON-NLS-1$		

	/**
	 * <ul>
	 * <li>ID ={@value}
	 * <li>Status = {@link IDeployAttributeStatus}
	 * <li>Problem = {@link ICoreProblemType#OBJECT_ATTRIBUTE_UNDEFINED}
	 * <li>Description = The {@link DB2JdbcProvider} of a {@link DB2JdbcProviderUnit} has an unset
	 * or empty {@link DB2JdbcProvider#getProviderType()} value
	 * </ul>
	 */
	public final static String DB2_JDBC_PROVIDER_PROVIDER_TYPE_001 = WasDeployPlugin.pluginID
			+ ".DB2_JDBC_PROVIDER_PROVIDER_TYPE_001"; //$NON-NLS-1$	

	/**
	 * <ul>
	 * <li>ID ={@value}
	 * <li>Status = {@link IDeployAttributeStatus}
	 * <li>Problem = {@link ICoreProblemType#OBJECT_ATTRIBUTE_UNDEFINED}
	 * <li>Description = The {@link DB2JdbcProvider} of a {@link DB2JdbcProviderUnit} has an unset
	 * or empty {@link DB2JdbcProvider#getProviderName()} value
	 * </ul>
	 */
	public final static String DB2_JDBC_PROVIDER_PROVIDER_NAME_001 = WasDeployPlugin.pluginID
			+ ".DB2_JDBC_PROVIDER_PROVIDER_NAME_001"; //$NON-NLS-1$		

	/**
	 * <ul>
	 * <li>ID ={@value}
	 * <li>Status = {@link IDeployAttributeStatus}
	 * <li>Problem = {@link ICoreProblemType#OBJECT_ATTRIBUTE_UNDEFINED}
	 * <li>Description = The {@link DB2JdbcProvider} of a {@link DB2JdbcProviderUnit} has an unset
	 * or empty {@link JdbcProvider#getClasspath()} value
	 * </ul>
	 */
	public final static String DB2_JDBC_PROVIDER_CLASSPATH_001 = WasDeployPlugin.pluginID
			+ ".DB2_JDBC_PROVIDER_CLASSPATH_001"; //$NON-NLS-1$		

	/**
	 * <ul>
	 * <li>ID ={@value}
	 * <li>Status = {@link IDeployAttributeValueSourceStatus}
	 * <li>Problem = {@link ICoreProblemType#OBJECT_ATTRIBUTE_INVALID}
	 * <li>Description = The {@link J2EEDatasource} of a {@link WasDatasourceUnit} does not have a
	 * correctly propagated {@link J2EEDatasource#getDbName()} from the
	 * {@link DB2Database#getDbName()}
	 * </ul>
	 */
	public final static String J2EE_DATASOURCE_FROM_DB2_DATABASE_DB_NAME = WasDeployPlugin.pluginID
			+ ".J2EE_DATASOURCE_FROM_DB2_DATABASE_DB_NAME"; //$NON-NLS-1$		

	/**
	 * <ul>
	 * <li>ID ={@value}
	 * <li>Status = {@link IDeployAttributeValueSourceStatus}
	 * <li>Problem = {@link ICoreProblemType#OBJECT_ATTRIBUTE_INVALID}
	 * <li>Description = The {@link WasV5Datasource} of a {@link WasDatasourceUnit} does not have a
	 * correctly propagated {@link WasV5Datasource#getJ2cAuthAlias()} from the
	 * {@link J2CAuthenticationDataEntry#getAlias()}
	 * </ul>
	 */
	public final static String WAS_V5_DATASOURCE_J2C_AUTH_ALIAS_FROM_J2C_AUTHENTICATION_DATA_ENTRY_ALIAS = WasDeployPlugin.pluginID
			+ ".WAS_V5_DATASOURCE_J2C_AUTH_ALIAS_FROM_J2C_AUTHENTICATION_DATA_ENTRY_ALIAS"; //$NON-NLS-1$		

	/**
	 * <ul>
	 * <li>ID ={@value}
	 * <li>Status = {@link IDeployAttributeStatus}
	 * <li>Problem = {@link ICoreProblemType#OBJECT_ATTRIBUTE_UNDEFINED}
	 * <li>Description = The {@link WasV5Datasource} of a {@link WasDatasourceUnit} has an unset or
	 * empty {@link WasV5Datasource#getJ2cAuthAlias()} value
	 * </ul>
	 */
	public final static String WAS_V5_DATASOURCE_J2C_AUTH_ALIAS_EMPTY = WasDeployPlugin.pluginID
			+ ".WAS_V5_DATASOURCE_J2C_AUTH_ALIAS_EMPTY"; //$NON-NLS-1$		

	/**
	 * <ul>
	 * <li>ID ={@value}
	 * <li>Status = {@link IDeployAttributeStatus}
	 * <li>Problem = {@link ICoreProblemType#OBJECT_ATTRIBUTE_UNDEFINED}
	 * <li>Description = The {@link WasNode} of a {@link WasNodeUnit} has an unset or empty
	 * {@link WasNode#getProfileType()} value
	 * </ul>
	 */
	public final static String WAS_DMGR_NODE_INSTALLED_ON_NUN_ND_WAS_SYSTEM = WasDeployPlugin.pluginID
			+ ".WAS_DMGR_NODE_INSTALLED_ON_NUN_ND_WAS_SYSTEM"; //$NON-NLS-1$	

	/**
	 * <ul>
	 * <li>ID ={@value}
	 * <li>Status = {@link IDeployAttributeStatus}
	 * <li>Problem = {@link ICoreProblemType#OBJECT_ATTRIBUTE_INVALID}
	 * <li>Description = The {@link WasNode} of a {@link WasNodeUnit} in a standalone cell has an
	 * invalid {@link WasNode#getProfileType()} value (not equals to default)
	 * </ul>
	 */
	public final static String WAS_NODE_PROFILETYPE_001 = WasDeployPlugin.pluginID
			+ ".WAS_NODE_PROFILETYPE_001"; //$NON-NLS-1$	

	/**
	 * <ul>
	 * <li>ID ={@value}
	 * <li>Status = {@link IDeployAttributeStatus}
	 * <li>Problem = {@link ICoreProblemType#OBJECT_ATTRIBUTE_UNDEFINED}
	 * <li>Description = The {@link WasNode} of a {@link WasNodeUnit} has an unset or empty
	 * {@link WasNode#getProfileName()} value
	 * </ul>
	 */
	public final static String WAS_NODE_UNIT_PROFILE_NAME_EMPTY_001 = WasDeployPlugin.pluginID
			+ ".WAS_NODE_UNIT_PROFILE_NAME_EMPTY_001"; //$NON-NLS-1$	

	/**
	 * <ul>
	 * <li>ID ={@value}
	 * <li>Status = {@link IDeployAttributeStatus}
	 * <li>Problem = {@link ICoreProblemType#OBJECT_ATTRIBUTE_UNDEFINED}
	 * <li>Description = The {@link WasNode} of a {@link WasNodeUnit} has an unset or empty
	 * {@link WasNode#getNodeName()} value
	 * </ul>
	 */
	public final static String WAS_NODE_UNIT_NODE_NAME_EMPTY_001 = WasDeployPlugin.pluginID
			+ ".WAS_NODE_UNIT_NODE_NAME_EMPTY_001"; //$NON-NLS-1$	

	/**
	 * <ul>
	 * <li>ID ={@value}
	 * <li>Status = {@link IDeployAttributeStatus}
	 * <li>Problem = {@link ICoreProblemType#OBJECT_ATTRIBUTE_UNDEFINED}
	 * <li>Description = The {@link WasNode} of a {@link WasNodeUnit} has an unset or empty
	 * {@link WasNode#getProfileName()} value
	 * </ul>
	 */
	public final static String WAS_NODE_UNIT_PROFILE_NAME_001 = WasDeployPlugin.pluginID
			+ ".WAS_NODE_UNIT_PROFILE_NAME_001"; //$NON-NLS-1$	

	/**
	 * <ul>
	 * <li>ID ={@value}
	 * <li>Status = {@link IDeployAttributeStatus}
	 * <li>Problem = {@link ICoreProblemType#OBJECT_ATTRIBUTE_UNDEFINED}
	 * <li>Description = The {@link WasNode} of a {@link WasNodeUnit} has an unset or empty
	 * {@link WasNode#getProfileLocation()} value
	 * </ul>
	 */
	public final static String WAS_NODE_UNIT_PROFILE_LOCATION_001 = WasDeployPlugin.pluginID
			+ ".WAS_NODE_UNIT_PROFILE_LOCATION_001"; //$NON-NLS-1$	

	/**
	 * <ul>
	 * <li>ID ={@value}
	 * <li>Status = {@link IDeployAttributeStatus}
	 * <li>Problem = {@link ICoreProblemType#OBJECT_ATTRIBUTE_UNDEFINED}
	 * <li>Description = The {@link WasNode} of a {@link WasNodeUnit}
	 * {@link WasNode#getProfileLocation()} unique
	 * </ul>
	 */
	public final static String WAS_NODE_UNIT_PROFILE_LOCATION_002 = WasDeployPlugin.pluginID
			+ ".WAS_NODE_UNIT_PROFILE_LOCATION_002"; //$NON-NLS-1$	

	/**
	 * <ul>
	 * <li>ID ={@value}
	 * <li>Status = {@link IDeployAttributeStatus}
	 * <li>Problem = {@link ICoreProblemType#OBJECT_ATTRIBUTE_UNDEFINED}
	 * <li>Description = The {@link WasNode} of a {@link WasNodeUnit} has an unset or empty
	 * {@link WasNode#getWasVersion()} value
	 * </ul>
	 */
	public final static String WAS_NODE_UNIT_WAS_VERSION_EMPTY_001 = WasDeployPlugin.pluginID
			+ ".WAS_NODE_UNIT_WAS_VERSION_EMPTY_001"; //$NON-NLS-1$	

	/**
	 * <ul>
	 * <li>ID ={@value}
	 * <li>Status = {@link IDeployAttributeStatus}
	 * <li>Problem = {@link ICoreProblemType#OBJECT_ATTRIBUTE_UNDEFINED}
	 * <li>Description = The {@link WasNode} of a {@link WasNodeUnit} has a
	 * {@link WasNode#getWasVersion()} value bigger than its {@link WasCell#getWasVersion()}
	 * </ul>
	 */
	public final static String WAS_NODE_UNIT_WAS_VERSION_INVALID_001 = WasDeployPlugin.pluginID
			+ ".WAS_NODE_UNIT_WAS_VERSION_INVALID_001"; //$NON-NLS-1$	

	/**
	 * <ul>
	 * <li>ID ={@value}
	 * <li>Status = {@link IDeployAttributeStatus}
	 * <li>Problem = {@link ICoreProblemType#OBJECT_ATTRIBUTE_UNDEFINED}
	 * <li>Description = The {@link SharedLibraryEntry} of a {@link WasSharedLibraryEntryUnit} has
	 * an unset or empty {@link SharedLibraryEntry#getSharedLibraryEntryName()} value
	 * </ul>
	 */
	public final static String WAS_SHAREDLIB_UNIT_SHAREDLIBENTRY_NAME_EMPTY_001 = WasDeployPlugin.pluginID
			+ ".WAS_SHAREDLIB_UNIT_SHAREDLIBENTRY_NAME_EMPTY_001"; //$NON-NLS-1$	
	/**
	 * <ul>
	 * <li>ID ={@value}
	 * <li>Status = {@link IDeployAttributeStatus}
	 * <li>Problem = {@link ICoreProblemType#OBJECT_ATTRIBUTE_UNDEFINED}
	 * <li>Description = The {@link SharedLibraryEntry} of a {@link WasSharedLibraryEntryUnit} has
	 * an unset or empty {@link SharedLibraryEntry#getClassPath()} value
	 * </ul>
	 */
	public final static String WAS_SHAREDLIB_UNIT_CLASSPATH_EMPTY_001 = WasDeployPlugin.pluginID
			+ ".WAS_SHAREDLIB_UNIT_CLASSPATH_EMPTY_001"; //$NON-NLS-1$	

	/**
	 * <ul>
	 * <li>ID ={@value}
	 * <li>Status = {@link IDeployAttributeStatus}
	 * <li>Problem = {@link ICoreProblemType#OBJECT_ATTRIBUTE_UNDEFINED}
	 * <li>Description = The {@link WasNode} of a {@link WasNodeUnit} has an unset or empty
	 * {@link WebsphereAppServerUnit} member
	 * </ul>
	 */
	public final static String WAS_DEFAULT_NODE_UNIT_IN_WAS_STANDALONE_CELL_WITHOUT_WAS_SERVER = WasDeployPlugin.pluginID
			+ ".WAS_DEFAULT_NODE_UNIT_IN_WAS_STANDALONE_CELL_WITHOUT_WAS_SERVER"; //$NON-NLS-1$	

	/**
	 * <ul>
	 * <li>ID ={@value}
	 * <li>Status = {@link IDeployAttributeStatus}
	 * <li>Problem = {@link ICoreProblemType#OBJECT_ATTRIBUTE_UNDEFINED}
	 * <li>Description = The {@link WasNode} of a {@link WasNodeUnit} has more than one
	 * {@link WebsphereAppServerUnit} members
	 * </ul>
	 */
	public final static String WAS_DEFAULT_NODE_UNIT_IN_WAS_STANDALONE_CELL_WITH_MORE_THAN_ONE_WAS_SERVER = WasDeployPlugin.pluginID
			+ ".WAS_DEFAULT_NODE_UNIT_IN_WAS_STANDALONE_CELL_WITH_MORE_THAN_ONE_WAS_SERVER"; //$NON-NLS-1$	

	/**
	 * <ul>
	 * <li>ID ={@value}
	 * <li>Status = {@link IDeployAttributeStatus}
	 * <li>Problem = {@link ICoreProblemType#OBJECT_ATTRIBUTE_UNDEFINED}
	 * <li>Description = The {@link WasNode} of a {@link WasNodeUnit} has an unset or empty
	 * {@link WasNode#getProfileLocation()} value
	 * </ul>
	 */
	public final static String WAS_NODE_UNIT_PROFILE_LOCATION_INVALID_001 = WasDeployPlugin.pluginID
			+ ".WAS_NODE_UNIT_PROFILE_LOCATION_INVALID_001"; //$NON-NLS-1$	

	/**
	 * <ul>
	 * <li>ID ={@value}
	 * <li>Status = {@link IDeployAttributeStatus}
	 * <li>Problem = {@link ICoreProblemType#OBJECT_ATTRIBUTE_UNDEFINED}
	 * <li>Description = The {@link WasNode} of a {@link WasNodeUnit} {@link WasNode#getNodeName()}
	 * should be unique in {@link WasCellUnit} group
	 * </ul>
	 */
	public final static String WAS_NODE_NODE_NAME_UNIQUE_001 = WasDeployPlugin.pluginID
			+ ".WAS_NODE_NODE_NAME_UNIQUE_001"; //$NON-NLS-1$	

	/**
	 * <ul>
	 * <li>ID ={@value}
	 * <li>Status = {@link IDeployAttributeStatus}
	 * <li>Problem = {@link ICoreProblemType#OBJECT_ATTRIBUTE_INVALID}
	 * <li>Description = The {@link WasNode} with NONE profile must be unmanaged.
	 * </ul>
	 */
	public final static String WAS_NODE_NOT_MANAGED_IF_NOT_A_PROFILE = WasDeployPlugin.pluginID
			+ ".WAS_NODE_NOT_MANAGED_IF_NOT_A_PROFILE"; //$NON-NLS-1$	

	/**
	 * <ul>
	 * <li>ID ={@value}
	 * <li>Status = {@link IDeployAttributeStatus}
	 * <li>Problem = {@link ICoreProblemType#OBJECT_ATTRIBUTE_INVALID}
	 * <li>Description = A {@link WasNode} with profile type NONE has a profile name that does not
	 * match an existing profile on the WAS system.
	 * </ul>
	 */
	public final static String WAS_NODE_PROFILE_NAME_MATCH_001 = WasDeployPlugin.pluginID
			+ ".WAS_NODE_PROFILE_NAME_MATCH_001"; //$NON-NLS-1$	

	/**
	 * <ul>
	 * <li>ID ={@value}
	 * <li>Status = {@link IDeployAttributeValueStatus}
	 * <li>Problem = {@link ICoreProblemType#OBJECT_ATTRIBUTE_INVALID}
	 * <li>Description = The {@link WasNode#getProfileLocation()} must be equal to the
	 * {@link WasSystem#getWasHome()} plus the {@link WasNode#getProfileName()}.
	 * </ul>
	 */
	public final static String WAS_NODE_UNIT_PROFILE_LOCATION_003 = WasDeployPlugin.pluginID
			+ ".WAS_NODE_UNIT_PROFILE_LOCATION_003"; //$NON-NLS-1$	

	/**
	 * <ul>
	 * <li>ID ={@value}
	 * <li>Status = {@link IDeployAttributeStatus}
	 * <li>Problem = {@link ICoreProblemType#OBJECT_ATTRIBUTE_INVALID}
	 * <li>Description = A {@link WasNode} with profile type NONE has a profile location that does
	 * not match an existing profile on the WAS system.
	 * </ul>
	 */
	public final static String WAS_NODE_PROFILE_LOCATION_MATCH_001 = WasDeployPlugin.pluginID
			+ ".WAS_NODE_PROFILE_LOCATION_MATCH_001"; //$NON-NLS-1$	

	/**
	 * <ul>
	 * <li>ID ={@value}
	 * <li>Status = {@link IDeployAttributeStatus}
	 * <li>Problem = {@link ICoreProblemType#OBJECT_ATTRIBUTE_UNDEFINED}
	 * <li>Description = The {@link WasNodeGroup} of a {@link WasNodeGroupUnit}
	 * {@link WasNodeGroup#getNodeGroupName()} should be unique in {@link WasCellUnit} group
	 * </ul>
	 */
	public final static String WAS_NODEGROUP_NODEGROUP_NAME_UNIQUE_001 = WasDeployPlugin.pluginID
			+ ".WAS_NODEGROUP_NODEGROUP_NAME_UNIQUE_001"; //$NON-NLS-1$	

	/**
	 * <ul>
	 * <li>ID ={@value}
	 * <li>Status = {@link IDeployAttributeStatus}
	 * <li>Problem = {@link ICoreProblemType#OBJECT_ATTRIBUTE_UNDEFINED}
	 * <li>Description = The {@link WasCluster} of a {@link WasClusterUnit}
	 * {@link WasCluster#getClusterName()} should be unique in {@link WasCellUnit} group
	 * </ul>
	 */
	public final static String WAS_CLUSTER_CLUSTER_NAME_UNIQUE_001 = WasDeployPlugin.pluginID
			+ ".WAS_CLUSTER_CLUSTER_NAME_UNIQUE_001"; //$NON-NLS-1$	

	/**
	 * <ul>
	 * <li>ID ={@value}
	 * <li>Status = {@link IDeployAttributeStatus}
	 * <li>Problem = {@link ICoreProblemType#OBJECT_ATTRIBUTE_UNDEFINED}
	 * <li>Description = The {@link WasSystem} of a {@link WasSystemUnit} has an unset or empty
	 * {@link WasSystem#getInstallerDir()} value
	 * </ul>
	 */
	public final static String WAS_SYSTEM_UNIT_INSTALLER_DIR_INVALID_001 = WasDeployPlugin.pluginID
			+ ".WAS_SYSTEM_UNIT_INSTALLER_DIR_INVALID_001"; //$NON-NLS-1$	

	/**
	 * <ul>
	 * <li>ID ={@value}
	 * <li>Status = {@link IDeployAttributeStatus}
	 * <li>Problem = {@link ICoreProblemType#OBJECT_ATTRIBUTE_UNDEFINED}
	 * <li>Description = The {@link WasSystem} of a {@link WasSystemUnit} has an unset or empty
	 * {@link WasSystem#getWasHome()} value
	 * </ul>
	 */
	public final static String WAS_SYSTEM_UNIT_WAS_HOME_INVALID_001 = WasDeployPlugin.pluginID
			+ ".WAS_SYSTEM_UNIT_WAS_HOME_INVALID_001"; //$NON-NLS-1$	

	/**
	 * <ul>
	 * <li>ID ={@value}
	 * <li>Status = {@link IDeployAttributeStatus}
	 * <li>Problem = {@link ICoreProblemType#OBJECT_ATTRIBUTE_UNDEFINED}
	 * <li>Description = The {@link WasNodeGroup} of a {@link WasNodeGroupUnit} has an unset or
	 * empty {@link WasNodeGroup#getNodeGroupName()} value
	 * </ul>
	 */
	public final static String WAS_NODEGROUP_UNIT_NODEGROUP_NAME_EMPTY_001 = WasDeployPlugin.pluginID
			+ ".WAS_NODEGROUP_UNIT_NODEGROUP_NAME_EMPTY_001"; //$NON-NLS-1$	

	/**
	 * <ul>
	 * <li>ID ={@value}
	 * <li>Status = {@link IDeployAttributeStatus}
	 * <li>Problem = {@link ICoreProblemType#OBJECT_ATTRIBUTE_UNDEFINED}
	 * <li>Description = The {@link WasCluster} of a {@link WasClusterUnit} has an unset or empty
	 * {@link WasCluster#getClusterName()} value
	 * </ul>
	 */
	public final static String WAS_CLUSTER_UNIT_CLUSTER_NAME_EMPTY_001 = WasDeployPlugin.pluginID
			+ ".WAS_CLUSTER_UNIT_CLUSTER_NAME_EMPTY_001"; //$NON-NLS-1$	

	/**
	 * <ul>
	 * <li>ID ={@value}
	 * <li>Status = {@link IDeployAttributeStatus}
	 * <li>Problem = {@link ICoreProblemType#OBJECT_ATTRIBUTE_UNDEFINED}
	 * <li>Description = The {@link WasCluster} of a {@link WasClusterUnit} has an unset or empty
	 * {@link WasCluster#getWasVersion()} value
	 * </ul>
	 */
	public final static String WAS_CLUSTER_UNIT_WAS_VERSION_EMPTY_001 = WasDeployPlugin.pluginID
			+ ".WAS_CLUSTER_UNIT_WAS_VERSION_EMPTY_001"; //$NON-NLS-1$	

	/**
	 * <ul>
	 * <li>ID ={@value}
	 * <li>Status = {@link IDeployAttributeStatus}
	 * <li>Problem = {@link ICoreProblemType#OBJECT_ATTRIBUTE_UNDEFINED}
	 * <li>Description = The {@link WasCell} of a {@link WasCellUnit} has an unset or empty
	 * {@link WasCell#getCellName()} value
	 * </ul>
	 */
	public final static String WAS_CELL_CELLNAME_EMPTY_001 = WasDeployPlugin.pluginID
			+ ".WAS_CELL_CELLNAME_EMPTY_001"; //$NON-NLS-1$	

	/**
	 * <ul>
	 * <li>ID ={@value}
	 * <li>Status = {@link IDeployAttributeStatus}
	 * <li>Problem = {@link ICoreProblemType#OBJECT_ATTRIBUTE_UNDEFINED}
	 * <li>Description = The {@link WasCell} of a {@link WasCellUnit} has an unset or empty
	 * {@link WasCell#getWasVersion()} value
	 * </ul>
	 */
	public final static String WAS_CELL_WASVERSION_EMPTY_001 = WasDeployPlugin.pluginID
			+ ".WAS_CELL_WASVERSION_EMPTY_001"; //$NON-NLS-1$	

	/**
	 * <ul>
	 * <li>ID ={@value}
	 * <li>Status = {@link IDeployAttributeStatus}
	 * <li>Problem = {@link ICoreProblemType#OBJECT_ATTRIBUTE_UNDEFINED}
	 * <li>Description = The {@link WasCell} of a {@link WasCellUnit} has an invalid
	 * {@link WasCell#getWasVersion()} value, bigger than 7 or less than 5
	 */
	public final static String WAS_CELL_WASVERSION_INVALID_001 = WasDeployPlugin.pluginID
			+ ".WAS_CELL_WASVERSION_INVALID_001"; //$NON-NLS-1$	

	/**
	 * <ul>
	 * <li>ID ={@value}
	 * <li>Status = {@link IDeployStatus}
	 * <li>Problem =
	 * {@link IWASProblemType#MISSING_DEFAULT_TYPE_WAS_NODE_UNIT_IN_WAS_STANDALONE_CELL}
	 * <li>Description = The {@link WasCell} of a {@link WasCellUnit} has an Invalid cardinality of
	 * memebers to be a {@link WasCellUnit} member
	 * </ul>
	 */
	public final static String VALIDAT_WAS_STANDALONE_CELL_NODE_MEMBER_CARDINALITY_001 = WasDeployPlugin.pluginID
			+ ".VALIDAT_WAS_STANDALONE_CELL_NODE_MEMBER_CARDINALITY_001"; //$NON-NLS-1$	

	/**
	 * <ul>
	 * <li>ID ={@value}
	 * <li>Status = {@link IDeployStatus}
	 * <li>Problem = {@link IWASProblemType#WAS_INVALID_MEMBERUNIT_IN_GROUPUNIT}
	 * <li>Description = The {@link WasCell} of a {@link WasCellUnit} has an Invalid cardinality of
	 * memebers to be a {@link WasCellUnit} member
	 * </ul>
	 */
	public final static String VALIDAT_WAS_STANDALONE_CELL_NODE_MEMBER_CARDINALITY_002 = WasDeployPlugin.pluginID
			+ ".VALIDAT_WAS_STANDALONE_CELL_NODE_MEMBER_CARDINALITY_002"; //$NON-NLS-1$

	/**
	 * <ul>
	 * <li>ID ={@value}
	 * <li>Status = {@link IDeployStatus}
	 * <li>Problem = {@link IWASProblemType#MISSING_WAS_DMGR_NODE_UNIT_IN_WAS_DISTIRBUTED_CELL}
	 * <li>Description = The {@link WasCell} of a {@link WasCellUnit} has an Invalid cardinality of
	 * memebers to be a {@link WasCellUnit} member
	 * </ul>
	 */
	public final static String VALIDAT_WAS_DISTRIBUTED_CELL_DMGR_NODE_MEMBER_CARDINALITY_001 = WasDeployPlugin.pluginID
			+ ".VALIDAT_WAS_DISTRIBUTED_CELL_DMGR_NODE_MEMBER_CARDINALITY_001"; //$NON-NLS-1$

	/**
	 * <ul>
	 * <li>ID ={@value}
	 * <li>Status = {@link IDeployStatus}
	 * <li>Problem = {@link IWASProblemType#WAS_INVALID_MEMBERUNIT_LIST_IN_GROUPUNIT}
	 * <li>Description = The {@link WasCell} of a {@link WasCellUnit} has an Invalid cardinality of
	 * memebers to be a {@link WasCellUnit} member
	 * </ul>
	 */
	public final static String VALIDAT_WAS_DISTRIBUTED_CELL_DMGR_NODE_MEMBER_CARDINALITY_002 = WasDeployPlugin.pluginID
			+ ".VALIDAT_WAS_DISTRIBUTED_CELL_DMGR_NODE_MEMBER_CARDINALITY_002"; //$NON-NLS-1$	

	/**
	 * <ul>
	 * <li>ID ={@value}
	 * <li>Status = {@link IDeployStatus}
	 * <li>Problem = {@link IWASProblemType}
	 * <li>Description = The {@link WasCell} of a {@link WasCellUnit} has an Invalid cardinality of
	 * memebers to be a {@link WasCellUnit} member
	 * </ul>
	 */
	public final static String VALIDAT_WAS_STANDALONE_CELL_NODEGROUP_MEMBER_CARDINALITY_001 = WasDeployPlugin.pluginID
			+ ".VALIDAT_WAS_STANDALONE_CELL_NODEGROUP_MEMBER_CARDINALITY_001"; //$NON-NLS-1$

	/**
	 * <ul>
	 * <li>ID ={@value}
	 * <li>Status = {@link IDeployStatus}
	 * <li>Problem = {@link IWASProblemType}
	 * <li>Description = The {@link WasCell} of a {@link WasCellUnit} has an Invalid cardinality of
	 * default {@link WasNodeGroupUnit} as its members
	 * </ul>
	 */
	public final static String VALIDAT_WAS_6_DISTRIBUTED_CELL_NODEGROUP_MEMBER_CARDINALITY_001 = WasDeployPlugin.pluginID
			+ ".VALIDAT_WAS_6_DISTRIBUTED_CELL_NODEGROUP_MEMBER_CARDINALITY_001"; //$NON-NLS-1$

	/**
	 * <ul>
	 * <li>ID ={@value}
	 * <li>Status = {@link IDeployStatus}
	 * <li>Problem = {@link ICoreProblemType#OBJECT_ATTRIBUTE_INVALID}
	 * <li>Description = The {@link WasCell} of a {@link WasCellUnit} has an Invalid cardinality of
	 * default {@link WasNodeGroupUnit} as its members
	 * </ul>
	 */
	public final static String VALIDATE_WAS_6_CELL_UNIT_NODEGROUPUNIT_MEMBER_CARDINALITY_002 = WasDeployPlugin.pluginID
			+ ".VALIDATE_WAS_6_CELL_UNIT_NODEGROUPUNIT_MEMBER_CARDINALITY_002"; //$NON-NLS-1$

	/**
	 * <ul>
	 * <li>ID ={@value}
	 * <li>Status = {@link IDeployAttributeStatus}
	 * <li>Problem = {@link ICoreProblemType#OBJECT_ATTRIBUTE_INVALID}
	 * <li>Description = The {@link WasCell} of a {@link WasCellUnit} has an Invalid
	 * {@link WasNode#getWasVersion()} to be a member of {@link WasCellUnit} version 5
	 * </ul>
	 */
	public final static String VALIDAT_WAS_5_DISTRIBUTED_CELL_NON_DMGR_NODE_MEMBERS_VERSION = WasDeployPlugin.pluginID
			+ ".VALIDAT_WAS_5_DISTRIBUTED_CELL_NON_DMGR_NODE_MEMBERS_VERSION"; //$NON-NLS-1$

	/**
	 * <ul>
	 * <li>ID ={@value}
	 * <li>Status = {@link IDeployAttributeStatus}
	 * <li>Problem = {@link IWASProblemType}
	 * <li>Description = The {@link WasCell} of a {@link WasCellUnit} does not equals to
	 * {@link WasNode#getWasVersion()} on which its wasVersion is extract
	 * <li> if the wasCell is a standalone cell, the version should equals to the only one wasNode's
	 * version
	 * <li> if the wasCell is a distributed cell, the version should equals to the dmgr wasNode's
	 * version
	 * </ul>
	 */
	public final static String VALIDAT_WAS_CELL_WASVERSION_001 = WasDeployPlugin.pluginID
			+ ".VALIDAT_WAS_CELL_WASVERSION_001"; //$NON-NLS-1$

	/**
	 * <ul>
	 * <li>ID ={@value}
	 * <li>Status = {@link IDeployAttributeStatus}
	 * <li>Problem = {@link IWASProblemType}
	 * <li>Description = The {@link WasCell} of a {@link WasCellUnit} has an Invalid number of
	 * wasNodeGroupUnit memebers as default NodeGroup
	 * </ul>
	 */
	public final static String VALIDAT_WAS_6_DISTRIBUTED_CELL_DEFAULT_WAS_NODEGROUP_CARDINALITY_001 = WasDeployPlugin.pluginID
			+ ".VALIDAT_WAS_6_DISTRIBUTED_CELL_DEFAULT_WAS_NODEGROUP_CARDINALITY_001"; //$NON-NLS-1$

	/**
	 * <ul>
	 * <li>ID ={@value}
	 * <li>Status = {@link IDeployStatus}
	 * <li>Problem = {@link IWASProblemType}
	 * <li>Description = The {@link WasNode} of a {@link WasNodeUnit} has an Invalid
	 * {@link WasNode#getWasVersion()} to be a member of {@link WasCellUnit} version 6
	 * </ul>
	 */
	public final static String VALIDAT_WAS_6_DISTRIBUTED_CELL_NON_DMGR_NODE_MEMBERS_VERSION = WasDeployPlugin.pluginID
			+ ".VALIDAT_WAS_6_DISTRIBUTED_CELL_NON_DMGR_NODE_MEMBERS_VERSION"; //$NON-NLS-1$

	/**
	 * <ul>
	 * <li>ID ={@value}
	 * <li>Status = {@link IDeployStatus}
	 * <li>Problem = {@link IWASProblemType#MISSING_WAS_DMGR_NODE_UNIT_IN_WAS_DISTIRBUTED_CELL}
	 * <li>Description = The {@link WasNode} of a {@link WasNodeUnit} has an Invalid type for
	 * grouping a {@link WasDeploymentManagerUnit} member
	 * </ul>
	 */
	public final static String VALIDAT_WAS_DMGR_S_CONTAINER_NODE_S_PROFILETYPE = WasDeployPlugin.pluginID
			+ ".VALIDAT_WAS_DMGR_S_CONTAINER_NODE_S_PROFILETYPE"; //$NON-NLS-1$

	/**
	 * <ul>
	 * <li>ID ={@value}
	 * <li>Status = {@link IDeployStatus}
	 * <li>Problem = {@link IWASProblemType#WAS_CLUSTER_IN_STANDALONE_WAS_CELL_UNIT}
	 * <li>Description = The {@link WasClusterUnit} is an Invalid member of standalone
	 * {@link WasCellUnit}
	 * </ul>
	 */
	public final static String VALIDAT_WAS_CLUSTER_UNIT_S_CELLTYPE = WasDeployPlugin.pluginID
			+ ".VALIDAT_WAS_CLUSTER_UNIT_S_CELLTYPE"; //$NON-NLS-1$

	/**
	 * <ul>
	 * <li>ID ={@value}
	 * <li>Status = {@link IDeployStatus}
	 * <li>Problem = {@link IWASProblemType#WAS_INVALID_MEMBERUNIT_IN_GROUPUNIT}
	 * <li>Description = The {@link WasClusterUnit} is an Invalid version member of distributed
	 * {@link WasCellUnit}
	 */
	public final static String VALIDAT_WAS_CLUSTER_UNIT_VERSION_WITH_WASCELL_VERSION = WasDeployPlugin.pluginID
			+ ".VALIDAT_WAS_CLUSTER_UNIT_VERSION_WITH_WASCELL_VERSION";//$NON-NLS-1$

	/**
	 * <ul>
	 * <li>ID ={@value}
	 * <li>Status = {@link IDeployStatus}
	 * <li>Problem = {@link IWASProblemType}
	 * <li>Description = The {@link WasNodeGroupUnit} should only inside one cellunit
	 */
	public final static String VALIDAT_WAS_NODEGROUP_UNIT_S_GROUPING_WASCELLUNITS = WasDeployPlugin.pluginID
			+ ".VALIDAT_WAS_NODEGROUP_UNIT_S_GROUPING_WASCELLUNITS"; //$NON-NLS-1$

	/**
	 * <ul>
	 * <li>ID ={@value}
	 * <li>Status = {@link IDeployStatus}
	 * <li>Problem =
	 * {@link IWASProblemType#WAS_CLUSTER_DEPENDING_ON_WAS_NODEGROUP_NOT_IN_SAME_WAS_CELL}
	 * <li>Description = The {@link WasClusterUnit} is depending on a {@link WasNodeGroupUnit} in
	 * different {@link WasCellUnit}
	 */
	public final static String VALIDAT_WAS_CLUSTER_UNIT_DEPENDING_ON_WAS_NODEGROUP_UNIT_IN_DIFFERENT_CELL = WasDeployPlugin.pluginID
			+ ".VALIDAT_WAS_CLUSTER_UNIT_DEPENDING_ON_WAS_NODEGROUP_UNIT_IN_DIFFERENT_CELL";//$NON-NLS-1$

	/**
	 * <ul>
	 * <li>ID ={@value}
	 * <li>Status = {@link IDeployStatus}
	 * <li>Problem = {@link IWASProblemType#WAS_INVALID_MEMBERUNIT_IN_GROUPUNIT}
	 * <li>Description = The {@link WasClusterUnit}'s member {@link WebsphereAppServerUnit} in
	 * {@link WasNodeUnit} who is in different {@link WasCellUnit}
	 */
	public final static String VALIDAT_WAS_CLUSTER_UNIT_MEMEBER_S_NODECONTAINER_IN_SAME_CELL = WasDeployPlugin.pluginID
			+ ".VALIDAT_WAS_CLUSTER_UNIT_MEMEBER_S_NODECONTAINER_IN_SAME_CELL";//$NON-NLS-1$

	/**
	 * <ul>
	 * <li>ID ={@value}
	 * <li>Status = {@link IDeployStatus}
	 * <li>Problem = {@link IWASProblemType#WAS_CLUSTER_UNIT_DEPENDINGLINK_UNSATISFIED}
	 * <li>Description = The {@link WasNodeUnit} not in the {@link WasNodeGroupUnit} on which the
	 * cluster is depending
	 */
	public final static String VALIDAT_WAS_CLUSTER_NODEUNIT_IN_DEPENDING_NODEGROUP = WasDeployPlugin.pluginID
			+ ".VALIDAT_WAS_CLUSTER_NODEUNIT_IN_DEPENDING_NODEGROUP";//$NON-NLS-1$

	/**
	 * <ul>
	 * <li>ID ={@value}
	 * <li>Status = {@link IDeployAttributeStatus}
	 * <li>Description = The Dmgr {@link WasNode} is unmanged
	 */
	public final static String VALIDAT_WAS_DMGRNODE_ISMANAGED_FALSE = WasDeployPlugin.pluginID
			+ ".VALIDAT_WAS_DMGRNODE_ISMANAGED_FALSE"; //$NON-NLS-1$

	/**
	 * <ul>
	 * <li>ID ={@value}
	 * <li>Status = {@link IDeployStatus}
	 * <li>Description = {@link WasNodeUnit} version 6 and above should be inside a
	 * {@link WasNodeGroupUnit}
	 */
	public final static String VALIDAT_WAS_NODE_IN_NODEGROUP_MEMBER_LINK = WasDeployPlugin.pluginID
			+ ".VALIDAT_WAS_NODE_IN_NODEGROUP_MEMBER_LINK"; //$NON-NLS-1$

	/**
	 * <ul>
	 * <li>ID ={@value}
	 * <li>Status = {@link IDeployStatus}
	 * <li>Description = Application who had deployed onto WAS, missing its required DataSource
	 */
	public final static String VALIDAT_WAS_APP_S_MISSING_DATASOURCE_REQ = WasDeployPlugin.pluginID
			+ ".VALIDAT_WAS_APP_S_MISSING_DATASOURCE_REQ"; //$NON-NLS-1$

	/**
	 * <ul>
	 * <li>ID ={@value}
	 * <li>Status = {@link IDeployStatus}
	 * <li>Description = Application who had deployed onto WAS, missing its required J2CAUTHEN
	 */
	public final static String VALIDAT_WAS_APP_S_MISSING_J2CAUTHEN_REQ = WasDeployPlugin.pluginID
			+ ".VALIDAT_WAS_APP_S_MISSING_J2CAUTHEN_REQ"; //$NON-NLS-1$

	/**
	 * <ul>
	 * <li>ID ={@value}
	 * <li>Status = {@link IDeployStatus}
	 * <li>Description = Application who had deployed onto WAS Server which is a member of cluster
	 */
	public final static String VALIDAT_APPLICATION_HOSTINGON_CLUSTER_MEMBER = WasDeployPlugin.pluginID
			+ ".VALIDAT_APPLICATION_HOSTINGON_CLUSTER_MEMBER"; //$NON-NLS-1$

	/**
	 * <ul>
	 * <li>ID ={@value}
	 * <li>Status = {@link IDeployAttributeValueSourceStatus}
	 * <li>Problem = {@link ICoreProblemType#OBJECT_ATTRIBUTE_INVALID}
	 * <li>Description = Checks that the value of {@link WasNode#getWasVersion()} is equal to the
	 * {@link WasSystem#getWasVersion()} that hosts it.
	 * </ul>
	 */
	public final static String WAS_NODE_UNIT__WAS_VERSION_EQUALS_SYSTEM = WasDeployPlugin.pluginID
			+ ".WAS_NODE_UNIT__WAS_VERSION_EQUALS_SYSTEM"; //$NON-NLS-1$

	/**
	 * <ul>
	 * <li>ID ={@value}
	 * <li>Status = {@link IDeployAttributeValueSourceStatus}
	 * <li>Problem = {@link ICoreProblemType#OBJECT_ATTRIBUTE_INVALID}
	 * <li>Description = Checks that the value of {@link WasNode#isIsManaged()} should be true when
	 * it is in a distributed cell
	 * 
	 * </ul>
	 */
	public final static String WAS_NON_DMGR_NODE_IS_MANAGED_001 = WasDeployPlugin.pluginID
			+ ".WAS_NON_DMGR_NODE_IS_MANAGED_001"; //$NON-NLS-1$

	/**
	 * <ul>
	 * <li>ID ={@value}
	 * <li>Status = {@link IDeployAttributeValueSourceStatus}
	 * <li>Problem = {@link ICoreProblemType#OBJECT_ATTRIBUTE_INVALID}
	 * <li>Description = Checks that the value of {@link WasNode#isIsManaged()} should be false when
	 * it is in a standalone cell
	 * 
	 * </ul>
	 */
	public final static String WAS_NON_DMGR_NODE_IS_MANAGED_002 = WasDeployPlugin.pluginID
			+ ".WAS_NON_DMGR_NODE_IS_MANAGED_002"; //$NON-NLS-1$

	/**
	 * <ul>
	 * <li>ID ={@value}
	 * <li>Status = {@link IDeployAttributeValueSourceStatus}
	 * <li>Problem = {@link ICoreProblemType#OBJECT_ATTRIBUTE_INVALID}
	 * <li>Description = Checks that the value of {@link WasNodeUnit}'s default server
	 * {@link WasServer#getServerName()} should be 'server1'
	 */
	public final static String WAS_NODE_UNIT_DEFAULT_WASSERVER_SERVERNAME_001 = WasDeployPlugin.pluginID
			+ ".WAS_NODE_UNIT_DEFAULT_WASSERVER_SERVERNAME_001"; //$NON-NLS-1$

	/**
	 * <ul>
	 * <li>ID ={@value}
	 * <li>Status = {@link IDeployStatus}
	 * <li>Problem = {@link IWASProblemType#DB2_DATASOURCEUNIT_MISSING_LOCAL_CATALOG}
	 * <li>Description = Datasource Unit without local db2 runtime client
	 */
	public final static String WAS_VALIDAT_DB2_DATASOURCEUNIT_LOCAL_CATALOG_001 = WasDeployPlugin.pluginID
			+ ".WAS_VALIDAT_DB2_DATASOURCEUNIT_LOCAL_CATALOG_001"; //$NON-NLS-1$

	/**
	 * <ul>
	 * <li>ID ={@value}
	 * <li>Status = {@link IDeployStatus}
	 * <li>Problem = {@link IWASProblemType#DB2_DATASOURCEUNIT_MISSING_LOCAL_CATALOG}
	 * <li>Description = Datasource Unit without local db2 client instance
	 */
	public final static String WAS_VALIDAT_DB2_DATASOURCEUNIT_LOCAL_CATALOG_002 = WasDeployPlugin.pluginID
			+ ".WAS_VALIDAT_DB2_DATASOURCEUNIT_LOCAL_CATALOG_002"; //$NON-NLS-1$

	/**
	 * <ul>
	 * <li>ID ={@value}
	 * <li>Status = {@link IDeployStatus}
	 * <li>Problem = {@link IWASProblemType#DB2_DATASOURCEUNIT_MISSING_LOCAL_CATALOG}
	 * <li>Description = Datasource Unit without local db2 Node Calatolog
	 */
	public final static String WAS_VALIDAT_DB2_DATASOURCEUNIT_LOCAL_CATALOG_003 = WasDeployPlugin.pluginID
			+ ".WAS_VALIDAT_DB2_DATASOURCEUNIT_LOCAL_CATALOG_003"; //$NON-NLS-1$

	/**
	 * <ul>
	 * <li>ID ={@value}
	 * <li>Status = {@link IDeployStatus}
	 * <li>Problem = {@link IWASProblemType#DB2_DATASOURCEUNIT_MISSING_LOCAL_CATALOG}
	 * <li>Description = Datasource Unit have local db2 Node Calatologs, but no satisfied catalog,
	 * and no empty DBName catalogs
	 */
	public final static String WAS_VALIDAT_DB2_DATASOURCEUNIT_LOCAL_CATALOG_004 = WasDeployPlugin.pluginID
			+ ".WAS_VALIDAT_DB2_DATASOURCEUNIT_LOCAL_CATALOG_004"; //$NON-NLS-1$

	/**
	 * <ul>
	 * <li>ID ={@value}
	 * <li>Status = {@link IDeployStatus}
	 * <li>Problem = {@link IWASProblemType#DB2_DATASOURCEUNIT_MISSING_LOCAL_CATALOG}
	 * <li>Description = Datasource Unit have local db2 Node Calatologs with empty DbName
	 */
	public final static String WAS_VALIDAT_DB2_DATASOURCEUNIT_LOCAL_CATALOG_005 = WasDeployPlugin.pluginID
			+ ".WAS_VALIDAT_DB2_DATASOURCEUNIT_LOCAL_CATALOG_005"; //$NON-NLS-1$

	/**
	 * <ul>
	 * <li>ID ={@value}
	 * <li>Status = {@link IDeployStatus}
	 * <li>Problem = {@link IWASProblemType#DB2_DATASOURCEUNIT_MISSING_LOCAL_CATALOG}
	 * <li>Description = Datasource Unit unsatisfied for cluster
	 */
	public final static String WAS_VALIDAT_DB2_DATASOURCEUNIT_LOCAL_CATALOG_006 = WasDeployPlugin.pluginID
			+ ".WAS_VALIDAT_DB2_DATASOURCEUNIT_LOCAL_CATALOG_006"; //$NON-NLS-1$

	/**
	 * <ul>
	 * <li>ID ={@value}
	 * <li>Status = {@link IDeployStatus}
	 * <li>Problem = {@link IWASProblemType}
	 * <li>Description = Application deployed onto a cluster without any server
	 */
	public final static String VALIDAT_APPLICATION_HOSTINGON_ON_EMPTY_CLUSTER = WasDeployPlugin.pluginID
			+ ".VALIDAT_APPLICATION_HOSTINGON_ON_EMPTY_CLUSTER"; //$NON-NLS-1$

	/**
	 * <ul>
	 * <li>ID ={@value}
	 * <li>Status = {@link IDeployStatus}
	 * <li>Problem = {@link IWASProblemType#WAS_INVALID_MEMBERUNIT_IN_GROUPUNIT}
	 * <li>Description = was node and was nodegroup should in same cell
	 */
	public final static String WAS_VALIDAT_NODE_NODEGROUP_IN_SAME_CELL = WasDeployPlugin.pluginID
			+ ".WAS_VALIDAT_NODE_NODEGROUP_IN_SAME_CELL"; //$NON-NLS-1$

	/**
	 * <ul>
	 * <li>ID ={@value}
	 * <li>Status = {@link IDeployAttributeStatus}
	 * <li>Problem = {@link IWASProblemType#WAS_INVALID_MEMBERUNIT_IN_GROUPUNIT}
	 * <li>Description = missing default profile node on wassystem
	 */
	public final static String WAS_VALIDAT_EXACT_ONE_DEFAULTPROFILE_ON_WASSYSTEM_001 = WasDeployPlugin.pluginID
			+ ".WAS_VALIDAT_EXACT_ONE_DEFAULTPROFILE_ON_WASSYSTEM_001"; //$NON-NLS-1$

	/**
	 * <ul>
	 * <li>ID ={@value}
	 * <li>Status = {@link IDeployAttributeStatus}
	 * <li>Problem = {@link IWASProblemType#WAS_INVALID_MEMBERUNIT_IN_GROUPUNIT}
	 * <li>Description = more than one default profile nodes on wassystem
	 */
	public final static String WAS_VALIDAT_EXACT_ONE_DEFAULTPROFILE_ON_WASSYSTEM_002 = WasDeployPlugin.pluginID
			+ ".WAS_VALIDAT_EXACT_ONE_DEFAULTPROFILE_ON_WASSYSTEM_002"; //$NON-NLS-1$

	/**
	 * <ul>
	 * <li>ID ={@value}
	 * <li>Status = {@link IDeployAttributeStatus}
	 * <li>Problem = {@link ICoreProblemType#OBJECT_ATTRIBUTE_UNDEFINED}
	 * <li>Description = The {@link WasSIBus} of a {@link WasSIBusUnit} has an unset or empty
	 * {@link WasSIBus#getBusName()} value
	 * </ul>
	 */
	public final static String WAS_SIBUS_CAPBILITY_BUS_NAME_EMPTY_001 = WasDeployPlugin.pluginID
			+ ".WAS_SIBUS_CAPBILITY_BUS_NAME_EMPTY_001"; //$NON-NLS-1$	

	/**
	 * <ul>
	 * <li>ID ={@value}
	 * <li>Status = {@link IDeployAttributeStatus}
	 * <li>Problem = {@link ICoreProblemType#OBJECT_ATTRIBUTE_NOT_UNIQUE}
	 * <li>Description = The {@link WasSIBus} of a {@link WasSIBusUnit} does not have a unique
	 * {@link WasSIBus#getBusName()} in the context of the container {@link WasCellUnit}.
	 * </ul>
	 */
	public final static String WAS_SIBUS_BUS_NAME_UNIQUENESS_001 = WasDeployPlugin.pluginID
			+ ".WAS_SIBUS_BUS_NAME_UNIQUENESS_001"; //$NON-NLS-1$		

	/**
	 * <ul>
	 * <li>ID ={@value}
	 * <li>Status = {@link IDeployAttributeStatus}
	 * <li>Problem = {@link ICoreProblemType#OBJECT_ATTRIBUTE_INVALID}
	 * </ul>
	 */
	public final static String DB2_JDBC_DRIVER_JDBC_TYPE_001 = WasDeployPlugin.pluginID
			+ ".DB2_JDBC_DRIVER_JDBC_TYPE_001"; //$NON-NLS-1$

	/**
	 * <ul>
	 * <li>ID ={@value}
	 * <li>Status = {@link IDeployAttributeStatus}
	 * <li>Problem = {@link ICoreProblemType#OBJECT_ATTRIBUTE_UNDEFINED}
	 * <li>Description = The {@link WasSibMediation} of a {@link WasSibMediationUnit} has an unset
	 * or empty {@link WasSibMediation#getMediationName()} value
	 * </ul>
	 */
	public final static String WAS_MEIDATION_CAPBILITY_MEDIATION_NAME_EMPTY_001 = WasDeployPlugin.pluginID
			+ ".WAS_MEIDATION_CAPBILITY_MEDIATION_NAME_EMPTY_001"; //$NON-NLS-1$	

	/**
	 * <ul>
	 * <li>ID ={@value}
	 * <li>Status = {@link IDeployAttributeStatus}
	 * <li>Problem = {@link ICoreProblemType#OBJECT_ATTRIBUTE_NOT_UNIQUE}
	 * <li>Description = The {@link WasSibMediation} of a {@link WasSibMediationUnit} does not have
	 * a unique {@link WasSibMediation#getMediationName()} in the context of the hosting
	 * {@link WasCellUnit}.
	 * </ul>
	 */
	public final static String WAS_MEIDATION_MEIDATION_NAME_UNIQUENESS_001 = WasDeployPlugin.pluginID
			+ ".WAS_MEIDATION_MEIDATION_NAME_UNIQUENESS_001"; //$NON-NLS-1$		

	/**
	 * <ul>
	 * <li>ID ={@value}
	 * <li>Status = {@link IDeployAttributeStatus}
	 * <li>Problem = {@link ICoreProblemType#OBJECT_ATTRIBUTE_UNDEFINED}
	 * <li>Description = The {@link WasSibMediation} of a {@link WasSibMediationUnit} has an unset
	 * or empty {@link WasSibMediation#getHandlerListName()} value
	 * </ul>
	 */
	public final static String WAS_MEIDATION_CAPBILITY_HANDLERLIST_NAME_EMPTY_001 = WasDeployPlugin.pluginID
			+ ".WAS_MEIDATION_CAPBILITY_HANDLERLIST_NAME_EMPTY_001"; //$NON-NLS-1$	

	/**
	 * <ul>
	 * <li>ID ={@value}
	 * <li>Status = {@link IDeployAttributeStatus}
	 * <li>Problem = {@link ICoreProblemType#OBJECT_ATTRIBUTE_UNDEFINED}
	 * <li>Description = The {@link WasSibOutboundPort} of a {@link WasSibOutboundPortUnit} has an
	 * unset or empty {@link WasSibOutboundPort#getPortName()} value
	 * </ul>
	 */
	public final static String WAS_SIBOUTBOUNDPORT_CAPBILITY_PORT_NAME_EMPTY_001 = WasDeployPlugin.pluginID
			+ ".WAS_SIBOUTBOUNDPORT_CAPBILITY_PORT_NAME_EMPTY_001"; //$NON-NLS-1$	

	/**
	 * <ul>
	 * <li>ID ={@value}
	 * <li>Status = {@link IDeployAttributeStatus}
	 * <li>Problem = {@link ICoreProblemType#OBJECT_ATTRIBUTE_NOT_UNIQUE}
	 * <li>Description = The {@link WasSibOutboundPort} of a {@link WasSibOutboundPortUnit} does not
	 * have a unique {@link WasSibOutboundPort#getPortName()} in the context of the hosting
	 * {@link WasCellUnit}.
	 * </ul>
	 */
	public final static String WAS_SIBOUTBOUNDPORT_PORT_NAME_UNIQUENESS_001 = WasDeployPlugin.pluginID
			+ ".WAS_SIBOUTBOUNDPORT_PORT_NAME_UNIQUENESS_001"; //$NON-NLS-1$		

	/**
	 * <ul>
	 * <li>ID ={@value}
	 * <li>Status = {@link IDeployAttributeStatus}
	 * <li>Problem = {@link ICoreProblemType#OBJECT_ATTRIBUTE_UNDEFINED}
	 * <li>Description = The {@link WasSibInboundPort} of a {@link WasSibInboundPortUnit} has an
	 * unset or empty {@link WasSibInboundPort#getPortName()} value
	 * </ul>
	 */
	public final static String WAS_SIBINBOUNDPORT_CAPBILITY_PORT_NAME_EMPTY_001 = WasDeployPlugin.pluginID
			+ ".WAS_SIBINBOUNDPORT_CAPBILITY_PORT_NAME_EMPTY_001"; //$NON-NLS-1$	

	/**
	 * <ul>
	 * <li>ID ={@value}
	 * <li>Status = {@link IDeployAttributeStatus}
	 * <li>Problem = {@link ICoreProblemType#OBJECT_ATTRIBUTE_NOT_UNIQUE}
	 * <li>Description = The {@link WasSibInboundPort} of a {@link WasSibInboundPortUnit} does not
	 * have a unique {@link WasSibInboundPort#getPortName()} in the context of the hosting
	 * {@link WasCellUnit}.
	 * </ul>
	 */
	public final static String WAS_SIBINBOUNDPORT_PORT_NAME_UNIQUENESS_001 = WasDeployPlugin.pluginID
			+ ".WAS_SIBINBOUNDPORT_PORT_NAME_UNIQUENESS_001"; //$NON-NLS-1$		

	/**
	 * <ul>
	 * <li>ID ={@value}
	 * <li>Status = {@link IDeployStatus}
	 * <li>Problem = {@link ICoreProblemType#HOSTING_LINK_TARGET_INVALID}
	 * <li>Description = The {@link WasNodeWindowsServiceUnit} is hosting on a {@link WasNodeUnit},
	 * who is not hosting on a {@link WindowsOperatingSystem}
	 */
	public final static String WAS_WINDOWSSERVICE_HOSTINGSTACK_001 = WasDeployPlugin.pluginID
			+ ".WAS_WINDOWSSERVICE_HOSTINGSTACK_001"; //$NON-NLS-1$		

	/**
	 * <ul>
	 * <li>ID ={@value}
	 * <li>Status = {@link IDeployAttributeStatus}
	 * <li>Problem = {@link ICoreProblemType#OBJECT_ATTRIBUTE_UNDEFINED}
	 * <li>Description = The {@link WasSibOutboundService} of a {@link WasSibOutboundServiceUnit}
	 * has an unset or empty {@link WasSibOutboundService#getWsdlLocation()} value
	 * </ul>
	 */
	public final static String VALIDAT_WAS_SIB_OUTBOUNDSERVICE_WSDLLOCATION_002 = WasDeployPlugin.pluginID
			+ ".VALIDAT_WAS_SIB_OUTBOUNDSERVICE_WSDLLOCATION_002"; //$NON-NLS-1$	

	/**
	 * <ul>
	 * <li>ID ={@value}
	 * <li>Status = {@link IDeployAttributeStatus}
	 * <li>Problem = {@link ICoreProblemType#OBJECT_ATTRIBUTE_UNDEFINED}
	 * <li>Description = The {@link WasSibDestination} has an unset or empty
	 * {@link WasSibDestination#getDestinationName()} value
	 * </ul>
	 */
	public final static String VALIDAT_WAS_SIB_DESTINATION_DESTINATIONNAME_001 = WasDeployPlugin.pluginID
			+ ".VALIDAT_WAS_SIB_DESTINATION_DESTINATIONNAME_001"; //$NON-NLS-1$	

	/**
	 * <ul>
	 * <li>ID ={@value}
	 * <li>Status = {@link IDeployAttributeStatus}
	 * <li>Problem = {@link ICoreProblemType#OBJECT_ATTRIBUTE_UNDEFINED}
	 * <li>Description = The {@link WasSibDestination}
	 * {@link WasSibDestination#getDestinationName()} value not unique on host {@link WasSIBusUnit}
	 * </ul>
	 */
	public final static String VALIDAT_WAS_SIB_DESTINATION_DESTINATIONNAME_002 = WasDeployPlugin.pluginID
			+ ".VALIDAT_WAS_SIB_DESTINATION_DESTINATIONNAME_002"; //$NON-NLS-1$	

	/**
	 * <ul>
	 * <li>ID ={@value}
	 * <li>Status = {@link IDeployStatus}
	 * <li>Problem = {@link ICoreProblemType#OBJECT_ATTRIBUTE_UNDEFINED}
	 * <li>Description = The {@link WasSibOutboundService#getWsdlLocation()} attribute is not end
	 * with "wsdl"
	 * </ul>
	 */
	public final static String VALIDAT_WAS_SIB_OUTBOUNDSERVICE_WSDLLOCATION_001 = WasDeployPlugin.pluginID
			+ ".VALIDAT_WAS_SIB_OUTBOUNDSERVICE_WSDLLOCATION_001"; //$NON-NLS-1$	 

	/**
	 * <ul>
	 * <li>ID ={@value}
	 * <li>Status = {@link IDeployAttributeStatus}
	 * <li>Problem = {@link ICoreProblemType#OBJECT_ATTRIBUTE_UNDEFINED}
	 * <li>Description = The {@link WasSibInboundService} of a {@link WasSibInboundServiceUnit} has
	 * an unset or empty {@link WasSibInboundService#getWsdlLocation()} value
	 * </ul>
	 */
	public final static String VALIDAT_WAS_SIB_INBOUNDSERVICE_WSDLLOCATION_001 = WasDeployPlugin.pluginID
			+ ".VALIDAT_WAS_SIB_INBOUNDSERVICE_WSDLLOCATION_001"; //$NON-NLS-1$	

	/**
	 * <ul>
	 * <li>ID ={@value}
	 * <li>Status = {@link IDeployAttributeStatus}
	 * <li>Problem = {@link ICoreProblemType#OBJECT_ATTRIBUTE_UNDEFINED}
	 * <li>Description = The {@link WasSibInboundService} of a {@link WasSibInboundServiceUnit} has
	 * an invalid {@link WasSibInboundService#getWsdlLocation()} value
	 * </ul>
	 */
	public final static String VALIDAT_WAS_SIB_INBOUNDSERVICE_WSDLLOCATION_002 = WasDeployPlugin.pluginID
			+ ".VALIDAT_WAS_SIB_INBOUNDSERVICE_WSDLLOCATION_002"; //$NON-NLS-1$	

	/**
	 * <ul>
	 * <li>ID ={@value}
	 * <li>Status = {@link IDeployStatus}
	 * <li>Problem = {@link ICoreProblemType#HOSTING_LINK_TARGET_INVALID}
	 * <li>Description = The {@link WasCellUnit} is hosting on a {@link WasNodeUnit}, who is not a
	 * member of this cell
	 * </ul>
	 */
	public final static String WAS_CELL_UNIT_HOSTINGLINK_INVILID_001 = WasDeployPlugin.pluginID
			+ ".WAS_CELL_UNIT_HOSTINGLINK_INVILID_001"; //$NON-NLS-1$	

	/**
	 * <ul>
	 * <li>ID ={@value}
	 * <li>Status = {@link IDeployStatus}
	 * <li>Problem = {@link ICoreProblemType#DEPENDENCY_LINK_TARGET_INVALID}
	 * <li>Description = The {@link WasCluster} is depending on a {@link WasNodeGroup} in a cell
	 * that is not grouping the cluster unit
	 * </ul>
	 */
	public final static String WAS_CLUSTER_DEPENDENCYLINK_INVALID_001 = WasDeployPlugin.pluginID
			+ ".WAS_CLUSTER_DEPENDENCYLINK_INVALID_001"; //$NON-NLS-1$

	/**
	 * <ul>
	 * <li>ID ={@value}
	 * <li>Status = {@link IDeployStatus}
	 * <li>Problem = {@link ICoreProblemType#DEPENDENCY_LINK_TARGET_UNDEFINED}
	 * <li>Description = The {@link WasJMSActivationSpecificationUnit} must depend on one of
	 * defaultMessagingDestination between {@link WasDefaultMessagingTopicDestinationUnit} and
	 * {@link WasDefaultMessagingQueueDestinationUnit}}.
	 * </ul>
	 */
	public final static String WAS_JMSACTIVATIONSPEC_MUST_DEPENDON_ONE_DEFAULTMESSAGINGDESTINATION_001 = WasDeployPlugin.pluginID
			+ ".WAS_JMSACTIVATIONSPEC_MUST_DEPENDON_ONE_DEFAULTMESSAGINGDESTINATION_001"; //$NON-NLS-1$

	/**
	 * <ul>
	 * <li>ID ={@value}
	 * <li>Status = {@link IDeployAttributeStatus}
	 * <li>Problem = {@link ICoreProblemType#OBJECT_ATTRIBUTE_UNDEFINED}
	 * <li>Description = The {@link WasEndpointListenerUnit} of a
	 * {@link WasEndpointListenerConfiguration} has an invalid
	 * {@link WasEndpointListenerConfiguration#getUrlRoot()} value
	 * </ul>
	 */
	public final static String WAS_ENDPOINT_LISTENER_URLROOT_ATTR_INVALID_001 = WasDeployPlugin.pluginID
			+ ".WAS_ENDPOINT_LISTENER_URLROOT_ATTR_INVALID_001"; //$NON-NLS-1$

	/**
	 * <ul>
	 * <li>ID ={@value}
	 * <li>Status = {@link IDeployAttributeStatus}
	 * <li>Problem = {@link ICoreProblemType#OBJECT_ATTRIBUTE_UNDEFINED}
	 * <li>Description = The {@link WasEndpointListenerUnit} of a
	 * {@link WasEndpointListenerConfiguration} has an invalid
	 * {@link WasEndpointListenerConfiguration#getWsdlUrlRoot()} value
	 * </ul>
	 */
	public final static String WAS_ENDPOINT_LISTENER_WSDLURLROOT_ATTR_INVALID_001 = WasDeployPlugin.pluginID
			+ ".WAS_ENDPOINT_LISTENER_WSDLURLROOT_ATTR_INVALID_001"; //$NON-NLS-1$

	/**
	 * <ul>
	 * <li>ID ={@value}
	 * <li>Status = {@link IDeployAttributeStatus}
	 * <li>Problem = {@link ICoreProblemType#OBJECT_ATTRIBUTE_UNDEFINED}
	 * <li>Description = The {@link WasEndpointListenerConfiguration} of a
	 * {@link WasEndpointListenerUnit} has an unset or empty
	 * {@link WasEndpointListenerConfiguration#getUrlRoot()} value
	 * </ul>
	 */
	public final static String WAS_ENDPOINT_LISTENER_URLROOT_EMPTY_001 = WasDeployPlugin.pluginID
			+ ".WAS_ENDPOINT_LISTENER_URLROOT_EMPTY_001"; //$NON-NLS-1$		
	/**
	 * <ul>
	 * <li>ID ={@value}
	 * <li>Status = {@link IDeployAttributeStatus}
	 * <li>Problem = {@link ICoreProblemType#OBJECT_ATTRIBUTE_UNDEFINED}
	 * <li>Description = The {@link WasEndpointListenerConfiguration} of a
	 * {@link WasEndpointListenerUnit} has an unset or empty
	 * {@link WasEndpointListenerConfiguration#getWsdlUrlRoot()} value
	 * </ul>
	 */
	public final static String WAS_ENDPOINT_LISTENER_WSDLURLROOT_EMPTY_001 = WasDeployPlugin.pluginID
			+ ".WAS_ENDPOINT_LISTENER_WSDLURLROOT_EMPTY_001"; //$NON-NLS-1$		

	/**
	 * <ul>
	 * <li>ID ={@value}
	 * <li>Status = {@link IDeployAttributeStatus}
	 * <li>Problem = {@link ICoreProblemType#OBJECT_ATTRIBUTE_INVALID}
	 * <li>Description = The path value of the attribute is not end with '.jar'
	 * </ul>
	 */
	public final static String WAS_INVALID_CLASSPATH_VALUE_001 = WasDeployPlugin.pluginID
			+ ".WAS_INVALID_CLASSPATH_VALUE_001"; //$NON-NLS-1$		

	/**
	 * <ul>
	 * <li>ID ={@value}
	 * <li>Status = {@link IDeployAttributeStatus}
	 * <li>Problem = {@link ICoreProblemType#OBJECT_ATTRIBUTE_INVALID}
	 * <li>Description = The variable used by the attribute is undefined
	 * </ul>
	 */
	public final static String WAS_INVALID_CLASSPATH_VALUE_002 = WasDeployPlugin.pluginID
			+ ".WAS_INVALID_CLASSPATH_VALUE_002"; //$NON-NLS-1$		

	/**
	 * <ul>
	 * <li>ID ={@value}
	 * <li>Status = {@link IDeployAttributeStatus}
	 * <li>Problem = {@link ICoreProblemType#OBJECT_ATTRIBUTE_INVALID}
	 * <li>Description = Missing default nodeGroup
	 * </ul>
	 */
	public final static String WAS_NODEGROUP_ISDEFAULTTYPE_001 = WasDeployPlugin.pluginID
			+ ".WAS_NODEGROUP_ISDEFAULTTYPE_001"; //$NON-NLS-1$

	/**
	 * <ul>
	 * <li>ID ={@value}
	 * <li>Status = {@link IDeployAttributeStatus}
	 * <li>Problem = {@link ICoreProblemType#OBJECT_ATTRIBUTE_INVALID}
	 * <li>Description = windoesservice starttype could not equals to system and boot
	 * </ul>
	 */
	public final static String WAS_NODE_WINDOWSSERVICE_STARTTYPE_001 = WasDeployPlugin.pluginID
			+ ".WAS_NODE_WINDOWSSERVICE_STARTTYPE_001"; //$NON-NLS-1$

	/**
	 * <ul>
	 * <li>ID ={@value}
	 * <li>Status = {@link IDeployStatus}
	 * <li>Problem = {@link IWASProblemType#MISSING_SHARED_LIBARY}
	 * <li>Description = Required shared library has not been configured
	 * </ul>
	 */
	public final static String WAS_WEB_MISSING_SHARED_LIBARY_001 = WasDeployPlugin.pluginID
			+ ".WAS_WEB_MISSING_SHARED_LIBARY_001"; //$NON-NLS-1$

	/**
	 * <ul>
	 * <li>ID ={@value}
	 * <li>Status = {@link IDeployStatus}
	 * <li>Problem = {@link IWASProblemType#CONFLICTING_SHARED_LIBARIES}
	 * <li>Description = A shared library is configured both at the application and at the
	 * application server level.
	 * </ul>
	 */
	public final static String WAS_WEB_CONFLICTING_SHARED_LIBRARIES_001 = WasDeployPlugin.pluginID
			+ ".WAS_WEB_CONFLICTING_SHARED_LIBRARIES_001"; //$NON-NLS-1$

	/**
	 * <ul>
	 * <li>ID ={@value}
	 * <li>Status = {@link IDeployStatus}
	 * <li>Problem = {@link IWASProblemType#CREATE_SHARED_LIBRARY}
	 * <li>Description = A shared library is configured both at the application and at the
	 * application server level.
	 * </ul>
	 */
	public final static String WAS_JAR_CREATE_SHARED_LIBRARY_001 = WasDeployPlugin.pluginID
			+ ".WAS_JAR_CREATE_SHARED_LIBRARY_001"; //$NON-NLS-1$

	/**
	 * <ul>
	 * <li>ID ={@value}
	 * <li>Status = {@link IDeployStatus}
	 * <li>Problem = {@link IWASProblemType#ADD_TO_SHARED_LIBRARY}
	 * <li>Description = A shared library is configured both at the application and at the
	 * application server level.
	 * </ul>
	 */
	public final static String WAS_JAR_ADD_TO_SHARED_LIBRARY_001 = WasDeployPlugin.pluginID
			+ ".WAS_JAR_ADD_TO_SHARED_LIBRARY_001"; //$NON-NLS-1$

	/**
	 * <ul>
	 * <li>ID ={@value}
	 * <li>Status = {@link IDeployStatus}
	 * <li>Problem =
	 * 
	 * <li>Description = Precondition test to determine if a node can be federated into a cell.
	 * </ul>
	 */
	public final static String WAS_FEDERATE_NODE_TEST_001 = WasDeployPlugin.pluginID
			+ ".WAS_FEDERATE_NODE_TEST_001"; //$NON-NLS-1$

	/**
	 * <ul>
	 * <li>ID ={@value}
	 * <li>Status = {@link IDeployStatus}
	 * <li>Problem =
	 * 
	 * <li>Description = Precondition test to determine if a SharedLibrary reference can be created
	 * for given Utility component
	 * </ul>
	 */
	public final static String WAS_CREATE_SHARED_LIBRARY_FOR_APPLICATION = WasDeployPlugin.pluginID
			+ ".WAS_CREATE_SHARED_LIBRARY_FOR_APPLICATION"; //$NON-NLS-1$

	/**
	 * <ul>
	 * <li>ID ={@value}
	 * <li>Status = {@link IDeployStatus}
	 * <li>Problem =
	 * 
	 * <li>Description = Precondition test to determine if a Server can be promoted into an existing
	 * cluster
	 * </ul>
	 */
	public final static String WAS_PROMOTE_SERVER_TO_EXISTING_CLUSTER = WasDeployPlugin.pluginID
			+ ".WAS_PROMOTE_SERVER_TO_EXISTING_CLUSTER"; //$NON-NLS-1$

	/**
	 * <ul>
	 * <li>ID ={@value}
	 * <li>Status = {@link IDeployStatus}
	 * <li>Problem =
	 * 
	 * <li>Description = Precondition test to determine if a Server can be promoted into a new
	 * cluster
	 * </ul>
	 */
	public final static String WAS_PROMOTE_SERVER_TO_NEW_CLUSTER = WasDeployPlugin.pluginID
			+ ".WAS_PROMOTE_SERVER_TO_NEW_CLUSTER"; //$NON-NLS-1$

	/**
	 * <ul>
	 * <li>ID ={@value}
	 * <li>Status = {@link IDeployStatus}
	 * <li>Problem =
	 * 
	 * <li>Description = Precondition test to determine if a new server can be created on a node and
	 * added to a cluster
	 * </ul>
	 */
	public final static String WAS_CREATE_NEW_SERVER_IN_CLUSTER = WasDeployPlugin.pluginID
			+ ".WAS_CREATE_NEW_SERVER_IN_CLUSTER"; //$NON-NLS-1$

	/**
	 * <ul>
	 * <li>ID ={@value}
	 * <li>Status = {@link IDeployStatus}
	 * <li>Problem =
	 * 
	 * <li>Description = Precondition test to determine if a Cluster can be hosted on a cell and
	 * associated with the contained node group *
	 * </ul>
	 */
	public final static String WAS_HOST_CLUSTER_ON_CELL_WITH_NODE_GROUP = WasDeployPlugin.pluginID
			+ ".WAS_HOST_CLUSTER_ON_CELL_WITH_NODE_GROUP"; //$NON-NLS-1$

	/**
	 * <ul>
	 * <li>ID ={@value}
	 * <li>Status = {@link IDeployStatus}
	 * <li>Problem =
	 * 
	 * <li>Description = Precondition test to determine if a substitution variable can be promoted
	 * to a higher level
	 * </ul>
	 */
	public final static String WAS_PROMOTE_SUBSTITUTION_VARIABLE = WasDeployPlugin.pluginID
			+ ".WAS_PROMOTE_SUBSTITUTION_VARIABLE"; //$NON-NLS-1$

	/**
	 * <ul>
	 * <li>ID ={@value}
	 * <li>Status = {@link IDeployStatus}
	 * <li>Problem =
	 * 
	 * <li>Description = Precondition test to determine an underlying Was Base System can be
	 * refactored in a Network Deployment
	 * </ul>
	 */
	public final static String WAS_REFACTOR_WAS_BASE_SYSTEM_TO_ND = WasDeployPlugin.pluginID
			+ ".WAS_REFACTOR_WAS_BASE_SYSTEM_TO_ND"; //$NON-NLS-1$

	/**
	 * <ul>
	 * <li>ID ={@value}
	 * <li>Status = {@link IDeployStatus}
	 * <li>Problem = {@link ICoreProblemType#OBJECT_ATTRIBUTE_INVALID}
	 * <li>Description = The {@link WasCell} hosted on a Base System has an Invalid cardinality of
	 * {@link WasNodeGroupUnit} as its members
	 * </ul>
	 */
	public final static String VALIDATE_WAS_CELL_UNIT_ON_BASE_SYSTEM_NODEEGROUPUNIT_MEMBER_CARDINALITY = WasDeployPlugin.pluginID
			+ ".VALIDATE_WAS_CELL_UNIT_ON_BASE_SYSTEM_NODEEGROUPUNIT_MEMBER_CARDINALITY"; //$NON-NLS-1$

	/**
	 * <ul>
	 * <li>ID ={@value}
	 * <li>Status = {@link IDeployStatus}
	 * <li>Problem = {@link ICoreProblemType#OBJECT_ATTRIBUTE_INVALID}
	 * <li>Description = The {@link WasCell} hosted has an Invalid cardinality of Dmgr Nodes as its
	 * members
	 * </ul>
	 */
	public final static String VALIDATE_WAS_CELL_UNIT_ON_BASE_SYSTEM_DMGRNODEUNIT_MEMBER_CARDINALITY = WasDeployPlugin.pluginID
			+ ".VALIDATE_WAS_CELL_UNIT_ON_BASE_SYSTEM_DMGRNODEUNIT_MEMBER_CARDINALITY"; //$NON-NLS-1$

	/**
	 * <ul>
	 * <li>ID ={@value}
	 * <li>Status = {@link IDeployStatus}
	 * <li>Problem = {@link ICoreProblemType#OBJECT_ATTRIBUTE_INVALID}
	 * <li>Description = A distributed {@link WasCellUnit} is hosted on a Base System
	 * </ul>
	 */
	public final static String VALIDATE_DISTRIBUTED_WAS_CELL_UNIT_HOSTED_ON_BASE_SYSTEM = WasDeployPlugin.pluginID
			+ ".VALIDATE_DISTRIBUTED_WAS_CELL_UNIT_HOSTED_ON_BASE_SYSTEM"; //$NON-NLS-1$

	/**
	 * <ul>
	 * <li>ID ={@value}
	 * <li>Status = {@link IDeployStatus}
	 * <li>Problem = {@link IWASProblemType#INVALID_NUMBER_DEPLOYMENTMANAGERUNIT_ON_DMGR}
	 * <li>Description = More than one {@link WasDeploymentManagerUnit} are hosted on a Dmgr node
	 * </ul>
	 */
	public final static String WAS_VALIDAT_EXACT_ONE_DEPLOYMENTMANAGERUNIT_ON_DMGR = WasDeployPlugin.pluginID
			+ ".WAS_VALIDAT_EXACT_ONE_DEPLOYMENTMANAGERUNIT_ON_DMGR"; //$NON-NLS-1$

	/**
	 * <ul>
	 * <li>ID ={@value}
	 * <li>Status = {@link IDeployStatus}
	 * <li>Problem = {@link IWASProblemType#WAS_SECURITY_SUBJECT_CONSTRAINT_INVALID_CONTEXT}
	 * 
	 * <li>Description = {@link WasSecuritySubjectConstraint} cannot be defined in this context.
	 * </ul>
	 */
	public final static String WAS_SECURITY_SUBJECT_CONSTRAINT_INVALID_CONTEXT_VALIDATOR_001 = WasDeployPlugin.pluginID
			+ ".WAS_SECURITY_SUBJECT_CONSTRAINT_INVALID_CONTEXT_VALIDATOR_001"; //$NON-NLS-1$

	/**
	 * <ul>
	 * <li>ID ={@value}
	 * <li>Status = {@link IDeployStatus}
	 * <li>Problem = {@link IWASProblemType#WAS_SECURITY_SUBJECT_CONSTRAINT_J2EE_SECURITY_ROLL_NULL}
	 * 
	 * <li>Description = {@link WasSecuritySubjectConstraint#getJ2eeSecurityRole()} is null.
	 * </ul>
	 */
	public final static String WAS_SECURITY_SUBJECT_CONSTRAINT_J2EE_SECURITY_ROLL_NULL_VALIDATOR_001 = WasDeployPlugin.pluginID
			+ ".WAS_SECURITY_SUBJECT_CONSTRAINT_J2EE_SECURITY_ROLL_NULL_VALIDATOR_001"; //$NON-NLS-1$

	/**
	 * <ul>
	 * <li>ID ={@value}
	 * <li>Status = {@link IDeployStatus}
	 * <li>Problem =
	 * {@link IWASProblemType#WAS_SECURITY_SUBJECT_CONSTRAINT_WAS_SECURITY_SUBJECT_NULL}
	 * 
	 * <li>Description = {@link WasSecuritySubjectConstraint#getWasSecuritySubject()} is null.
	 * </ul>
	 */
	public final static String WAS_SECURITY_SUBJECT_CONSTRAINT_WAS_SECURITY_SUBJECT_NULL_VALIDATOR_001 = WasDeployPlugin.pluginID
			+ ".WAS_SECURITY_SUBJECT_CONSTRAINT_WAS_SECURITY_SUBJECT_NULL_VALIDATOR_001"; //$NON-NLS-1$

	/**
	 * <ul>
	 * <li>ID ={@value}
	 * <li>Status = {@link IDeployStatus}
	 * <li>Problem =
	 * {@link IWASProblemType#WAS_SECURITY_SUBJECT_CONSTRAINT_J2EE_SECURITY_ROLL_NOT_FOUND}
	 * 
	 * <li>Description = {@link WasSecuritySubjectConstraint#getJ2eeSecurityRole()} cannot be found
	 * on hostee
	 * </ul>
	 */
	public final static String WAS_SECURITY_SUBJECT_CONSTRAINT_J2EE_SECURITY_ROLL_NOT_FOUND_VALIDATOR_001 = WasDeployPlugin.pluginID
			+ ".WAS_SECURITY_SUBJECT_CONSTRAINT_J2EE_SECURITY_ROLL_NOT_FOUND_VALIDATOR_001"; //$NON-NLS-1$

	/**
	 * <ul>
	 * <li>ID ={@value}
	 * <li>Status = {@link IDeployStatus}
	 * <li>Problem =
	 * {@link IWASProblemType#WAS_SECURITY_SUBJECT_CONSTRAINT_WAS_SECURITY_SUBJECT_NOT_FOUND}
	 * 
	 * <li>Description = {@link WasSecuritySubjectConstraint#getWasSecuritySubject()} cannot be
	 * found on host
	 * </ul>
	 */
	public final static String WAS_SECURITY_SUBJECT_CONSTRAINT_WAS_SECURITY_SUBJECT_NOT_FOUND_VALIDATOR_001 = WasDeployPlugin.pluginID
			+ ".WAS_SECURITY_SUBJECT_CONSTRAINT_WAS_SECURITY_SUBJECT_NOT_FOUND_VALIDATOR_001"; //$NON-NLS-1$

	/**
	 * <ul>
	 * <li>ID ={@value}
	 * <li>Status = {@link IDeployStatus}
	 * <li>Problem = {@link IWASProblemType#WAS_SECURITY_SUBJECT_CONSTRAINT_WAS_SECURITY_UNDEFINED}
	 * 
	 * <li>Description = {@link WasSecurity} capability not found on {@link WebsphereAppServerUnit}
	 * </ul>
	 */
	public final static String WAS_SECURITY_SUBJECT_CONSTRAINT_WAS_SECURITY_UNDEFINED_VALIDATOR_001 = WasDeployPlugin.pluginID
			+ ".WAS_SECURITY_SUBJECT_CONSTRAINT_WAS_SECURITY_UNDEFINED_VALIDATOR_001"; //$NON-NLS-1$

	/**
	 * <ul>
	 * <li>ID ={@value}
	 * <li>Status = {@link IDeployStatus}
	 * <li>Problem =
	 * {@link IWASProblemType#WAS_SECURITY_SUBJECT_CONSTRAINT_WAS_SECURITY_INCONSISTENT}
	 * 
	 * <li>Description = {@link WasSecurity} capability not found on all servers in cluster
	 * {@link WebsphereAppServerUnit}
	 * </ul>
	 */
	public final static String WAS_SECURITY_SUBJECT_CONSTRAINT_WAS_SECURITY_INCONSISTENT_VALIDATOR_001 = WasDeployPlugin.pluginID
			+ ".WAS_SECURITY_SUBJECT_CONSTRAINT_WAS_SECURITY_INCONSISTENT_VALIDATOR_001"; //$NON-NLS-1$

	/**
	 * <ul>
	 * <li>ID ={@value}
	 * <li>Status = {@link IDeployStatus}
	 * <li>Problem = {@link IWASProblemType#WAS_WAR_CLASSLOADER_POLICY_CONSTRAINT_INVALID_CONTEXT}
	 * 
	 * <li>Description = {@link WasWarClassloaderPolicyConstraint} cannot be defined in this
	 * context.
	 * </ul>
	 */
	public final static String WAS_WAR_CLASSLOADER_POLICY_CONSTRAINT_INVALID_CONTEXT_VALIDATOR_001 = WasDeployPlugin.pluginID
			+ ".WAS_WAR_CLASSLOADER_POLICY_CONSTRAINT_INVALID_CONTEXT_VALIDATOR_001"; //$NON-NLS-1$

	/**
	 * <ul>
	 * <li>ID ={@value}
	 * <li>Status = {@link IDeployStatus}
	 * <li>Problem = {@link IWASProblemType#WAS_EAR_CLASSLOADER_POLICY_CONSTRAINT_INVALID_CONTEXT}
	 * 
	 * <li>Description = {@link WasEarClassloaderPolicyConstraint} cannot be defined in this
	 * context.
	 * </ul>
	 */
	public final static String WAS_EAR_CLASSLOADER_POLICY_CONSTRAINT_INVALID_CONTEXT_VALIDATOR_001 = WasDeployPlugin.pluginID
			+ ".WAS_EAR_CLASSLOADER_POLICY_CONSTRAINT_INVALID_CONTEXT_VALIDATOR_001"; //$NON-NLS-1$

	/**
	 * <ul>
	 * <li>ID ={@value}
	 * <li>Status = {@link IDeployStatus}
	 * <li>Problem = {@link IWASProblemType#WAS_MODULE_START_WEIGHT_CONSTRAINT_INVALID_CONTEXT}
	 * 
	 * <li>Description = {@link WasWarClassloaderPolicyConstraint} cannot be defined in this
	 * context.
	 * </ul>
	 */
	public final static String WAS_MODULE_START_WEIGHT_CONSTRAINT_INVALID_CONTEXT_VALIDATOR_001 = WasDeployPlugin.pluginID
			+ ".WAS_MODULE_START_WEIGHT_CONSTRAINT_INVALID_CONTEXT_VALIDATOR_001"; //$NON-NLS-1$

	/**
	 * <ul>
	 * <li>ID ={@value}
	 * <li>Status = {@link IDeployStatus}
	 * <li>Problem = {@link IWASProblemType#WAS_MODULE_START_WEIGHT_CONSTRAINT_INVALID_CONTEXT}
	 * 
	 * <li>Description = {@link WasWarClassloaderPolicyConstraint} cannot be defined in this
	 * context.
	 * </ul>
	 */
	public final static String WAS_JNDI_BINDING_CONSTRAINT_INVALID_CONTEXT_VALIDATOR_001 = WasDeployPlugin.pluginID
			+ ".WAS_JNDI_BINDING_CONSTRAINT_INVALID_CONTEXT_VALIDATOR_001"; //$NON-NLS-1$

	/**
	 * <ul>
	 * <li>ID ={@value}
	 * <li>Status = {@link IDeployStatus}
	 * <li>Problem =
	 * {@link IWASProblemType#WAS_JNDI_BINDING_CONSTRAINT_JNDI_NAME_OF_CAPABILITY_DOES_NOT_MATCH_VALIDATOR_001}
	 * 
	 * <li>Description = {@link WasWarClassloaderPolicyConstraint} cannot be defined in this
	 * context.
	 * </ul>
	 */
	public final static String WAS_JNDI_BINDING_CONSTRAINT_JNDI_NAME_OF_CAPABILITY_DOES_NOT_MATCH_VALIDATOR_001 = WasDeployPlugin.pluginID
			+ ".WAS_JNDI_BINDING_CONSTRAINT_JNDI_NAME_OF_CAPABILITY_DOES_NOT_MATCH_VALIDATOR_001"; //$NON-NLS-1$

	/**
	 * <ul>
	 * <li>ID ={@value}
	 * <li>Status = {@link IDeployStatus}
	 * <li>Problem = {@link IWASProblemType#OPTIONAL_CONSTRAINT_NOT_PRESENT}
	 * 
	 * <li>Description = Optional {@link WasEarClassloaderPolicyConstraint} not present in context.
	 * </ul>
	 */
	public final static String WAS_J2EE_EAR_CLASSLOADER_POLICY_CONSTRAINT_MISSING_001 = WasDeployPlugin.pluginID
			+ ".WAS_J2EE_EAR_CLASSLOADER_POLICY_CONSTRAINT_MISSING_001"; //$NON-NLS-1$

	/**
	 * <ul>
	 * <li>ID ={@value}
	 * <li>Status = {@link IDeployStatus}
	 * <li>Problem = {@link IWASProblemType#OPTIONAL_CONSTRAINT_NOT_PRESENT}
	 * 
	 * <li>Description = Optional {@link WasWarClassloaderPolicyConstraint} not present in context.
	 * </ul>
	 */
	public final static String WAS_J2EE_WAR_CLASSLOADER_POLICY_CONSTRAINT_MISSING_001 = WasDeployPlugin.pluginID
			+ ".WAS_J2EE_WAR_CLASSLOADER_POLICY_CONSTRAINT_MISSING_001"; //$NON-NLS-1$

	/**
	 * <ul>
	 * <li>ID ={@value}
	 * <li>Status = {@link IDeployStatus}
	 * <li>Problem = {@link IWASProblemType#OPTIONAL_CONSTRAINT_NOT_PRESENT}
	 * 
	 * <li>Description = Optional {@link WasModuleStartWeightConstraint} not present in context.
	 * </ul>
	 */
	public final static String WAS_J2EE_MODULE_START_WEIGHT_CONSTRAINT_MISSING_001 = WasDeployPlugin.pluginID
			+ ".WAS_J2EE_MODULE_START_WEIGHT_CONSTRAINT_MISSING_001"; //$NON-NLS-1$

	/**
	 * <ul>
	 * <li>ID ={@value}
	 * <li>Status = {@link IDeployStatus}
	 * <li>Problem = {@link IWASProblemType#OPTIONAL_CONSTRAINT_NOT_PRESENT}
	 * 
	 * <li>Description = Optional {@link WasSecuritySubjectConstraint} not present in context.
	 * </ul>
	 */
	public final static String WAS_J2EE_SECURITY_SUBJECT_CONSTRAINT_MISSING_001 = WasDeployPlugin.pluginID
			+ ".WAS_J2EE_SECURITY_SUBJECT_CONSTRAINT_MISSING_001"; //$NON-NLS-1$

	/**
	 * <ul>
	 * <li>ID ={@value}
	 * <li>Status = {@link IDeployStatus}
	 * <li>Problem = {@link IWASProblemType#OPTIONAL_CONSTRAINT_NOT_PRESENT}
	 * 
	 * <li>Description = Optional {@link WasSecuritySubjectConstraint} not present in context.
	 * </ul>
	 */
	public final static String WAS_JNDI_BINDING_CONSTRAINT_MISSING_001 = WasDeployPlugin.pluginID
			+ ".WAS_JNDI_BINDING_CONSTRAINT_MISSING_001"; //$NON-NLS-1$

	/**
	 * <ul>
	 * <li>ID ={@value}
	 * <li>Status = {@link IDeployStatus}
	 * <li>Problem = {@link IWASProblemType#MESSAGING_ENGINE_NOT_UNIQUE_ON_SERVER}
	 * 
	 * <li>Description = There is more than one {@link WasMessagingEngineUnit} hosted on a
	 * {@link WebsphereAppServerUnit}.
	 * </ul>
	 */
	public final static String MESSAGING_ENGINE_001 = WasDeployPlugin.pluginID
			+ ".MESSAGING_ENGINE_001"; //$NON-NLS-1$

	/**
	 * <ul>
	 * <li>ID ={@value}
	 * <li>Status = {@link IDeployStatus}
	 * <li>Problem = {@link IWASProblemType#WAS_DATASOURCE_MATCHING_DB_NOT_IDENTIFIED}
	 * 
	 * <li>Description = There is no clear matching database for a datasource.
	 * </ul>
	 */
	public final static String WAS_DATASOURCE_MATCHING_DB_IDENTIFICATION_001 = WasDeployPlugin.pluginID
			+ ".WAS_DATASOURCE_MATCHING_DB_IDENTIFICATION_001"; //$NON-NLS-1$
}
