/*******************************************************************************
 * Copyright (c) 2003, 2007 IBM Corporation Licensed Material - Property of IBM. All rights reserved.
 *  
 * US Government Users Restricted Rights - Use, duplication or disclosure v1.0 restricted by GSA ADP
 * Schedule Contract with IBM Corp.
 * 
 * Contributors: IBM Corporation - initial API and implementation
 *******************************************************************************/

package com.ibm.ccl.soa.deploy.asc;

import java.util.HashMap;

/**
 * This is a Constants about all the asc terms and tasks.
 * 
 * @author <a href="mailto:fenglin@cn.ibm.com">Ella Feng</a>
 * @author <a href="mailto:zhaoyong@cn.ibm.com">ZhaoYong (John) </a>
 */
public class ASCConstants {

	/**
	 * WebSphere Application Server 6 Common ASC Task Pacakge Name
	 */
	public static final String PACKAGE_NAME_WAS_6 = "was_6"; //$NON-NLS-1$
	/**
	 * WebSphere Application Server Network Deployment ASC Task Package Name
	 */
	public static final String PACKAGE_NAME_WAS_ND6 = "wasnd_6"; //$NON-NLS-1$
	/**
	 * Currently suipported WebSphere Application Server Version is 6.0.
	 */
	public static final String WAS_VERSION_6 = "6.0"; //$NON-NLS-1$

	//tasks for WAS base domain-------------------------------------------------------
	/**
	 * Create Profile ASC Task Name.
	 */
	public static final String TASK_CREATE_PROFILE = "createProfile"; //$NON-NLS-1$
	/**
	 * Set DB2 Data Source Version 5 ASC Task Name.
	 */
	public static final String TASK_SET_DB2DATASOURCE_V5 = "setDB2DataSourceV5";//$NON-NLS-1$
	/**
	 * Start WebSphere Application Server Task Name.
	 */
	public static final String TASK_START_APP_SERVER = "startAppServer";//$NON-NLS-1$
	/**
	 * Install WebSphere Application Server V6.0 Task Name.
	 */
	public static final String TASK_INSTALL_WAS_V6 = "installWASV6";//$NON-NLS-1$
	/**
	 * Set DB2 JDBC Provider Task Name.
	 */
	public static final String TASK_SET_DB2JDBCPROVIDER = "setDB2JdbcProvider";//$NON-NLS-1$
	/**
	 * Set SharedLibarary Task Name.
	 */
	public static final String TASK_SET_SHARED_LIBRARY = "setSharedLibrary";//$NON-NLS-1$
	/**
	 * Set Variable Substituiton Task Name.
	 */
	public static final String TASK_SET_VAR_SUB = "setVarSub";//$NON-NLS-1$
	/**
	 * Create J2C Authentication Task Name.
	 */
	public static final String TASK_CREATE_J2CAUTHENTICATION = "createJ2CAuthentication";//$NON-NLS-1$

	//tasks for J2EE domain-----------------------------------------------------
	/**
	 * Start Application Deployed on Application Server Task Name.
	 */
	public static final String TASK_START_APPLICATION = "startApp"; //$NON-NLS-1$	
	/**
	 * Install EAR on Application Server Task Name.
	 */
	public static final String TASK_INSTALL_EAR = "installEAR"; //$NON-NLS-1$	
	/**
	 * Install JAR on Application Server Task Name.
	 */
	public static final String TASK_INSTALL_JAR = "installJAR"; //$NON-NLS-1$	
	/**
	 * Install WAR on Application Server Task Name.
	 */
	public static final String TASK_INSTALL_WAR = "installWAR"; //$NON-NLS-1$	
	/**
	 * Install and Set ResourceAdapter Task Name.
	 */
	public static final String TASK_SET_RESOURCE_ADAPTER = "setResourceAdapter"; //$NON-NLS-1$

	//Task forND and cluster---------------------------------------------------

	public static final String TASK_INSTALL_ND_6 = "install_nd_6"; //$NON-NLS-1$
	/**
	 * Task Name of creating Cluster for WebSphere Application Server ND.
	 */
	public static final String TASK_CREATE_CLUSTER = "createCluster"; //$NON-NLS-1$
	/**
	 * Task Name of starting Cluster for WebSphere Application Server ND.
	 */
	public static final String TASK_START_CLUSTER = "startCluster"; //$NON-NLS-1$
	/**
	 * Task Name of Federating a Node into WebSphere Application ND.
	 */
	public static final String TASK_FEDERATE_NODE = "federateNode"; //$NON-NLS-1$
	/**
	 * Task Name of Start nodeagent.
	 */
	public static final String TASK_START_NODE = "startNode"; //$NON-NLS-1$
	/**
	 * Task Name of ceate a Node Group in WebSphere Application ND.
	 */
	public static final String TASK_CREATE_NODEGROUP = "createNodeGroup"; //$NON-NLS-1$
	/**
	 * Task Name of add a Node to node Group in WebSphere Application ND.
	 */
	public static final String TASK_ADD_NODE_TO_NODEGROUP = "addNode2NodeGroup"; //$NON-NLS-1$
	/**
	 * Task Name of create an Application Server for Node in WebSphere Application ND.
	 */
	public static final String TASK_CREATE_APPSVR = "createAppServer"; //$NON-NLS-1$
	/**
	 * Task Name of start an Application Server or a dmgr server in WebSphere Application ND.
	 */
	public static final String TASK_START_WAS = "startWas"; //$NON-NLS-1$
	/**
	 * Create Applicaton Server as a member of Cluster task name .
	 */
	public static final String TASK_CREATE_CLUSTER_MEMBER = "createClusterMember"; //$NON-NLS-1$

	//Task for SIBUS-----------------------------------------------------------------------------
	/**
	 * Create SIBus Task Name.
	 */
	public static final String TASK_CREATE_SIBUS = "createSIBus"; //$NON-NLS-1$
	/**
	 * Add an Application Server to a SIBus Task Name.
	 */
	public static final String TASK_ADD_APPSERVER_TOSIBU = "addAppServerToSIBus"; //$NON-NLS-1$
	/**
	 * Add a Cluster to a SIBus Task Name.
	 */
	public static final String TASK_ADD_CLUSTER_TOSIBU = "addClusterToSIBus"; //$NON-NLS-1$
	/**
	 * Set EndpointListener Task Name.
	 */
	public static final String TASK_SET_ENDPOINTLISTENER = "setEndpointListener"; //$NON-NLS-1$
	/**
	 * Set SIBus Destination Task Name.
	 */
	public static final String TASK_SET_SIBDESTINATION = "setSibDestination"; //$NON-NLS-1$
	/**
	 * Set SIBus Mediation Task Name
	 */
	public static final String TASK_SET_SIBMEDIATION = "setSibMediation"; //$NON-NLS-1$
	/**
	 * Set Inbound Port in SIBus Task Name.
	 */
	public static final String TASK_SET_INBOUNDPORT = "setInboundPort"; //$NON-NLS-1$
	/**
	 * Set Inbound Service in SIBus Task Name.
	 */
	public static final String TASK_SET_INBOUNDSERVICE = "setInboundService"; //$NON-NLS-1$
	/**
	 * Set Outbound Service in SIBus Task Name.
	 */
	public static final String TASK_SET_OUTBOUNDSERVICE = "setOutboundService"; //$NON-NLS-1$
	/**
	 * Set Outbound Port in SIBus Task Name.
	 */
	public static final String TASK_SET_OUTBOUNDPORT = "setOutboundPort"; //$NON-NLS-1$

	//Task for JMS-----------------------------------------------------------------------------
	/**
	 * Task Name of create a Default Messaging Connection Factory.
	 */
	public static final String TASK_CREATE_DMCF = "createDefaultMessagingConnectionFactory"; //$NON-NLS-1$
	/**
	 * Task Name of create a Default Messaging Queue Connection Factory.
	 */
	public static final String TASK_CREATE_DMQD = "createDefaultMessagingQueueDestination"; //$NON-NLS-1$
	/**
	 * Task Name of create a Default Messaging Topic Connection Factory.
	 */
	public static final String TASK_CREATE_DMTD = "createDefaultMessagingTopicDestination"; //$NON-NLS-1$
	/**
	 * Task Name of create a Default Messaging Activation Specification.
	 */
	public static final String TASK_CREATE_DMAS = "createDefaultMessagingActivationSpecification"; //$NON-NLS-1$

	//attributes of was tasks--------------------------------------------------------------------
	public static final String WAS_HOME = "washome"; //$NON-NLS-1$
	public static final String WAS_PROFILE_NAME = "profilename"; //$NON-NLS-1$
	public static final String WAS_NODE_PROFILE_NAME = "nodeprofilename"; //$NON-NLS-1$
	public static final String WAS_NODE_NAME = "node"; //$NON-NLS-1$
	public static final String WAS_NODE_NAME2 = "nodeName"; //$NON-NLS-1$
	public static final String WAS_SERVER_NAME = "server"; //$NON-NLS-1$
	public static final String WAS_SERVER_NAME2 = "serverName"; //$NON-NLS-1$
	public static final String WAS_CLUSTER_NAME = "cluster"; //$NON-NLS-1$
	public static final String WAS_CLUSTER_NAME2 = "clusterName"; //$NON-NLS-1$
	public static final String WAS_SIBUS_NAME = "busName"; //$NON-NLS-1$

	public static final String WAS_CELL_NAME = "cell"; //$NON-NLS-1$
	public static final String WAS_CELL_NAME2 = "cellName"; //$NON-NLS-1$
	public static final String WAS_PROFILE_HOME = "profilehome"; //$NON-NLS-1$
	public static final String WAS_INSTALL_DIR = "installerdir";//$NON-NLS-1$
	public static final String WAS_SERVER_FAILONERROR = "failonerror"; //$NON-NLS-1$
	public static final String WAS_USE_EXISTING_SERVER = "useExistingServer"; //$NON-NLS-1$
	//attribute for was ND

	public static final String WAS_NODEGROUP_NAME = "nodeGroupName"; //$NON-NLS-1$

	//atttibutes of j2EE tasks
	public static final String J2EE_EAR_FILE = "earfile"; //$NON-NLS-1$
	public static final String J2EE_APPLICATION_NAME = "appname"; //$NON-NLS-1$

	public static final String J2EE_JAR_FILE = "jarfile"; //$NON-NLS-1$

	public static final String J2EE_RAR_FILE = "rarfile"; //$NON-NLS-1$
	public static final String J2EE_ADAPTOR_NAME = "name"; //$NON-NLS-1$

	public static final String J2EE_WAR_FILE = "warfile"; //$NON-NLS-1$
	public static final String J2EE_CONTEXT_ROOT = "contextroot"; //$NON-NLS-1$

	public static final String WAS_SCOPE = "scope"; //$NON-NLS-1$
	public static final String WAS_SCOPE_CELL = "Cell"; //$NON-NLS-1$
	public static final String WAS_SCOPE_NODE = "Node"; //$NON-NLS-1$
	public static final String WAS_SCOPE_SERVER = "Server"; //$NON-NLS-1$
	public static final String WAS_SCOPE_CLUSTER = "Cluster"; //$NON-NLS-1$

	//for test use
	public static final String WAS_SCOPE_NOSCOPE = ""; //$NON-NLS-1$

	//common attributes in was task
	public static final String WAS_JNDI_NAME = "jndiname"; //$NON-NLS-1$

	//attributes of was task setDB2DataSourceV5
	public static final String WAS_DATASOURCE_NAME = "datasourcename"; //$NON-NLS-1$
	public static final String WAS_DATABASE_NAME = "databasename"; //$NON-NLS-1$
	public static final String WAS_DATASOURCE_AUTHALIAS = "authenticationalias"; //$NON-NLS-1$
	public static final String WAS_DBSERVER_NAME = "dbservername"; //$NON-NLS-1$	

	//attribute of setDB2JdbcProvider
	public static final String WAS_JDBCPROVIDER_NAME = "providername"; //$NON-NLS-1$
	public static final String WAS_JDBCPROVIDER_TYPE = "providertype"; //$NON-NLS-1$
	public static final String WAS_JDBCPROVIDER_RRS = "RRS"; //$NON-NLS-1$
	public static final String WAS_JDBCPROVIDER_LEGACY = "Legacy"; //$NON-NLS-1$
	public static final String WAS_JDBCPROVIDER_UNIVERSAL = "Universal"; //$NON-NLS-1$
	public static final String WAS_JDBCPROVIDER_TOOLBOX = "Toolbox"; //$NON-NLS-1$
	public static final String WAS_JDBCPROVIDER_NATIVE = "Native"; //$NON-NLS-1$
	//value of boolean attribute
	public static final String TRUE = "true"; //$NON-NLS-1$
	public static final String FALSE = "false"; //$NON-NLS-1$

	//attribute of setSharedLibrary
	public static final String WAS_LIB_NAME = "name"; //$NON-NLS-1$
	public static final String WAS_LIB_CLASS_PATH = "classpath"; //$NON-NLS-1$

	//attribute of setVarSub
	public static final String WAS_VAR_NAME = "varname"; //$NON-NLS-1$
	public static final String WAS_VAR_VALUE = "varvalue"; //$NON-NLS-1$

	//attribute of createJ2CAuthentication
	public static final String WAS_J2CA_ALIAS = "alias"; //$NON-NLS-1$
	public static final String WAS_J2CA_USERID = "userid"; //$NON-NLS-1$
	public static final String WAS_J2CA_PWD = "password"; //$NON-NLS-1$

	public static final String OS_HOSTNAME = "hostname"; //$NON-NLS-1$

	//enum of profile type
	public static final String PROFILE_TYPE_DEFAULT = "appserver"; //$NON-NLS-1$
	public static final String PROFILE_TYPE_MANAGED = "custom"; //$NON-NLS-1$
	public static final String PROFILE_TYPE_DMGR = "dmgr"; //$NON-NLS-1$
	public static final String PROFILE_TYPE = "type"; //$NON-NLS-1$

	//   \ --> /
	public static final String ASC_SPLITER = "/"; //$NON-NLS-1$
	public static final String ASC_CLASS_PATH_SPLITER = ";"; //$NON-NLS-1$

	public static final String WAS_JDBCPROVIDER_IMPLEMENTATION_TYPE = "implementationType"; //$NON-NLS-1$
	public static final String SOAP_CONNECTOR_ADDRESS = "soap_connector_address"; //$NON-NLS-1$
	public static final String ASC_SOAP_CONNECTOR_ADDRESS = "dmgrSoapConnectorPort"; //$NON-NLS-1$
	public static final String ASC_DMGR_HOSTNAME = "dMgrHostName"; //$NON-NLS-1$
	public static final String TASK_MEDIATE_SIBDESTINATION = "mediateSIBDestination"; //$NON-NLS-1$

	//belows are for prot use-------------------------------------------------
//	Port for was node
	public static final String PORT_WC_DEFAULTHOST = "wc_defaulthost"; //$NON-NLS-1$
	public static final String PORT_WC_DEFAULTHOST_SECURE = "wc_defaulthost_secure"; //$NON-NLS-1$
	public static final String PORT_BOOTSTRAP_ADDRESS = "bootstrap_address"; //$NON-NLS-1$
	public static final String PORT_SOAP_CONNECTOR_ADDRESS = "soap_connector_address"; //$NON-NLS-1$
	public static final String PORT_SAS_SSL_SERVERAUTH_LISTENER_ADDRESS = "sas_ssl_serverauth_listener_address"; //$NON-NLS-1$
	public static final String PORT_CSIV2_SSL_SERVERAUTH_LISTENER_ADDRESS = "csiv2_ssl_serverauth_listener_address"; //$NON-NLS-1$
	public static final String PORT_CSIV2_SSL_MUTUALAUTH_LISTENER_ADDRESS = "csiv2_ssl_mutualauth_listener_address"; //$NON-NLS-1$
	public static final String PORT_ORB_LISTENER_ADDRESS = "orb_listener_address"; //$NON-NLS-1$
	public static final String PORT_DCS_UNICAST_ADDRESS = "dcs_unicast_address"; //$NON-NLS-1$
	public static final String PORT_SIB_ENDPOINT_ADDRESS = "sib_endpoint_address"; //$NON-NLS-1$
	public static final String PORT_SIB_ENDPOINT_SECURE_ADDRESS = "sib_endpoint_secure_address"; //$NON-NLS-1$
	public static final String PORT_SIB_MQ_ENDPOINT_ADDRESS = "sib_mq_endpoint_address"; //$NON-NLS-1$
	public static final String PORT_SIB_MQ_ENDPOINT_SECURE_ADDRESS = "sib_mq_endpoint_secure_address"; //$NON-NLS-1$
	public static final String DESCRIPTION = "description"; //$NON-NLS-1$

	public static HashMap WAS_PORTMAP = new HashMap();
	static {
		WAS_PORTMAP.put("sib_endpoint_secure_address", "sibmqendpointsaddress"); //$NON-NLS-1$ //$NON-NLS-2$
		WAS_PORTMAP.put("sib_mq_endpoint_address", "sibendpointsaddress"); //$NON-NLS-1$ //$NON-NLS-2$
		WAS_PORTMAP.put("wc_defaulthost", "wcdefaulthost"); //$NON-NLS-1$//$NON-NLS-2$
		WAS_PORTMAP.put("sib_endpoint_address", "sibendpointaddress"); //$NON-NLS-1$ //$NON-NLS-2$
		WAS_PORTMAP.put("sas_ssl_serverAuth_listener_address", "sasssauthlisteneraddress"); //$NON-NLS-1$ //$NON-NLS-2$
		WAS_PORTMAP.put("dcs_unicast_address", "dcsunicastaddress"); //$NON-NLS-1$//$NON-NLS-2$
		WAS_PORTMAP.put("soap_connector_address", "soapconnectoraddress"); //$NON-NLS-1$ //$NON-NLS-2$
		WAS_PORTMAP.put("sib_mq_endpoint_secure_address", "sibmqendpointaddress"); //$NON-NLS-1$ //$NON-NLS-2$
		WAS_PORTMAP.put("wc_adminhost_secure", "wcahsecure"); //$NON-NLS-1$//$NON-NLS-2$

		WAS_PORTMAP.put("csiv2_ssl_mutualauth_listener_address", "csiv2smauthlisteneraddress"); //$NON-NLS-1$ //$NON-NLS-2$
		WAS_PORTMAP.put("wc_defaulthost_secure", "wcdhsecure"); //$NON-NLS-1$//$NON-NLS-2$
		WAS_PORTMAP.put("bootstrap_address", "bootstrapaddress"); //$NON-NLS-1$ //$NON-NLS-2$
		WAS_PORTMAP.put("wc_adminhost", "wcadminhost"); //$NON-NLS-1$//$NON-NLS-2$
		WAS_PORTMAP.put("csiv2_ssl_serverAuth_listener_address", "csiv2ssauthlisteneraddress"); //$NON-NLS-1$ //$NON-NLS-2$
		WAS_PORTMAP.put("orb_listener_address", "orblisteneraddress"); //$NON-NLS-1$//$NON-NLS-2$

	}

}
