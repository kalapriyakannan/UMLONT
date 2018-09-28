/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package com.ibm.ccl.soa.deploy.db2high.impl;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.impl.ENotificationImpl;

import com.ibm.ccl.soa.deploy.core.impl.CapabilityImpl;
import com.ibm.ccl.soa.deploy.db2high.DB2Manager;
import com.ibm.ccl.soa.deploy.db2high.Db2highPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>DB2 Manager</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link com.ibm.ccl.soa.deploy.db2high.impl.DB2ManagerImpl#getAgentPoolSize <em>Agent Pool Size</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.db2high.impl.DB2ManagerImpl#getAgentPriority <em>Agent Priority</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.db2high.impl.DB2ManagerImpl#getAgentStackSize <em>Agent Stack Size</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.db2high.impl.DB2ManagerImpl#getApplicationSupportLayerHeapSize <em>Application Support Layer Heap Size</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.db2high.impl.DB2ManagerImpl#getAuditBufferSize <em>Audit Buffer Size</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.db2high.impl.DB2ManagerImpl#getAuthenticationType <em>Authentication Type</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.db2high.impl.DB2ManagerImpl#getAuthenticationTypeForIncomingConnections <em>Authentication Type For Incoming Connections</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.db2high.impl.DB2ManagerImpl#getBypassFederatedAuthentication <em>Bypass Federated Authentication</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.db2high.impl.DB2ManagerImpl#getCatalogingAllowedWithoutAuthority <em>Cataloging Allowed Without Authority</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.db2high.impl.DB2ManagerImpl#getClientIOBlockSize <em>Client IO Block Size</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.db2high.impl.DB2ManagerImpl#getClientKerberosPlugin <em>Client Kerberos Plugin</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.db2high.impl.DB2ManagerImpl#getClientUseridPasswordPlugin <em>Client Userid Password Plugin</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.db2high.impl.DB2ManagerImpl#getCommunicationsBandwidth <em>Communications Bandwidth</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.db2high.impl.DB2ManagerImpl#getConfigurationFileReleaseLevel <em>Configuration File Release Level</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.db2high.impl.DB2ManagerImpl#getConnectionElapseTime <em>Connection Elapse Time</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.db2high.impl.DB2ManagerImpl#getCPUSpeed <em>CPU Speed</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.db2high.impl.DB2ManagerImpl#getDatabaseSystemMonitorHeapSize <em>Database System Monitor Heap Size</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.db2high.impl.DB2ManagerImpl#getDefaultChargeBackAccount <em>Default Charge Back Account</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.db2high.impl.DB2ManagerImpl#getDefaultDatabasePath <em>Default Database Path</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.db2high.impl.DB2ManagerImpl#getDefaultDatabaseSystemMonitorSwitches <em>Default Database System Monitor Switches</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.db2high.impl.DB2ManagerImpl#getDiagnosticDataDirectoryPath <em>Diagnostic Data Directory Path</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.db2high.impl.DB2ManagerImpl#getDiagnosticErrorCaptureLevel <em>Diagnostic Error Capture Level</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.db2high.impl.DB2ManagerImpl#getDirectoryCacheSupport <em>Directory Cache Support</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.db2high.impl.DB2ManagerImpl#getDiscoverServerInstance <em>Discover Server Instance</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.db2high.impl.DB2ManagerImpl#getDiscoveryMode <em>Discovery Mode</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.db2high.impl.DB2ManagerImpl#getEnablePntrapartitionParallelism <em>Enable Pntrapartition Parallelism</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.db2high.impl.DB2ManagerImpl#getFederatedDatabaseSystemSupport <em>Federated Database System Support</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.db2high.impl.DB2ManagerImpl#getGroupPlugin <em>Group Plugin</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.db2high.impl.DB2ManagerImpl#getHealthMonitoring <em>Health Monitoring</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.db2high.impl.DB2ManagerImpl#getIndexRecreationTime <em>Index Recreation Time</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.db2high.impl.DB2ManagerImpl#getInitialNumberOfAgentsInPool <em>Initial Number Of Agents In Pool</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.db2high.impl.DB2ManagerImpl#getInitialNumberOfFencedProcesses <em>Initial Number Of Fenced Processes</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.db2high.impl.DB2ManagerImpl#getInstanceImpactPolicy <em>Instance Impact Policy</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.db2high.impl.DB2ManagerImpl#getInstanceMemory <em>Instance Memory</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.db2high.impl.DB2ManagerImpl#getKeepFencedProcess <em>Keep Fenced Process</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.db2high.impl.DB2ManagerImpl#getListOfGSSAPIPluginsForIncomingConnections <em>List Of GSSAPI Plugins For Incoming Connections</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.db2high.impl.DB2ManagerImpl#getLocalGSSAPIPlugin <em>Local GSSAPI Plugin</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.db2high.impl.DB2ManagerImpl#getMachineNodeType <em>Machine Node Type</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.db2high.impl.DB2ManagerImpl#getMaximumAsynchronousTQsPerQuery <em>Maximum Asynchronous TQs Per Query</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.db2high.impl.DB2ManagerImpl#getMaximumJavaInterpreterHeapSize <em>Maximum Java Interpreter Heap Size</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.db2high.impl.DB2ManagerImpl#getMaximumNumberOfAgents <em>Maximum Number Of Agents</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.db2high.impl.DB2ManagerImpl#getMaximumNumberOfClientConnections <em>Maximum Number Of Client Connections</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.db2high.impl.DB2ManagerImpl#getMaximumNumberOfConcurrentAgents <em>Maximum Number Of Concurrent Agents</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.db2high.impl.DB2ManagerImpl#getMaximumNumberOfConcurrentlyActiveDatabases <em>Maximum Number Of Concurrently Active Databases</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.db2high.impl.DB2ManagerImpl#getMaximumNumberOfCoordinatingAgents <em>Maximum Number Of Coordinating Agents</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.db2high.impl.DB2ManagerImpl#getMaximumNumberOfFencedProcesses <em>Maximum Number Of Fenced Processes</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.db2high.impl.DB2ManagerImpl#getMaximumQueryDegreeOfParallelism <em>Maximum Query Degree Of Parallelism</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.db2high.impl.DB2ManagerImpl#getMaximumTimeDifferenceAmongNodes <em>Maximum Time Difference Among Nodes</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.db2high.impl.DB2ManagerImpl#getNodeConnectionRetries <em>Node Connection Retries</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.db2high.impl.DB2ManagerImpl#getNotifyLevel <em>Notify Level</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.db2high.impl.DB2ManagerImpl#getNumberOfFCMBuffers <em>Number Of FCM Buffers</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.db2high.impl.DB2ManagerImpl#getNumberOfFCMChannels <em>Number Of FCM Channels</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.db2high.impl.DB2ManagerImpl#getQueryHeapSize <em>Query Heap Size</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.db2high.impl.DB2ManagerImpl#getServerPluginMode <em>Server Plugin Mode</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.db2high.impl.DB2ManagerImpl#getSoftwareDevelopersKitForJavaInstallationPath <em>Software Developers Kit For Java Installation Path</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.db2high.impl.DB2ManagerImpl#getSortHeapThreshold <em>Sort Heap Threshold</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.db2high.impl.DB2ManagerImpl#getStartAndStopTimeout <em>Start And Stop Timeout</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.db2high.impl.DB2ManagerImpl#getSyncPointManagerLogFilePath <em>Sync Point Manager Log File Path</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.db2high.impl.DB2ManagerImpl#getSyncPointManagerLogFileSize <em>Sync Point Manager Log File Size</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.db2high.impl.DB2ManagerImpl#getSyncPointManagerName <em>Sync Point Manager Name</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.db2high.impl.DB2ManagerImpl#getSyncPointManagerResyncAgentLimit <em>Sync Point Manager Resync Agent Limit</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.db2high.impl.DB2ManagerImpl#getSystemAdministrationAuthorityGroupName <em>System Administration Authority Group Name</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.db2high.impl.DB2ManagerImpl#getSystemControlAuthorityGroupName <em>System Control Authority Group Name</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.db2high.impl.DB2ManagerImpl#getSystemMaintenanceAuthorityGroupName <em>System Maintenance Authority Group Name</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.db2high.impl.DB2ManagerImpl#getSystemMonitorAuthorityGroupName <em>System Monitor Authority Group Name</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.db2high.impl.DB2ManagerImpl#getTCPIPServiceName <em>TCPIP Service Name</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.db2high.impl.DB2ManagerImpl#getTransactionManagerDatabaseName <em>Transaction Manager Database Name</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.db2high.impl.DB2ManagerImpl#getTransactionProcessorMonitorName <em>Transaction Processor Monitor Name</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.db2high.impl.DB2ManagerImpl#getTransactionResyncInterval <em>Transaction Resync Interval</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.db2high.impl.DB2ManagerImpl#getTrustAllClients <em>Trust All Clients</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.db2high.impl.DB2ManagerImpl#getTrustedClientsAuthentication <em>Trusted Clients Authentication</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.db2high.impl.DB2ManagerImpl#getUseridPasswordPlugIn <em>Userid Password Plug In</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class DB2ManagerImpl extends CapabilityImpl implements DB2Manager {
	/**
	 * The default value of the '{@link #getAgentPoolSize() <em>Agent Pool Size</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getAgentPoolSize()
	 * @generated
	 * @ordered
	 */
	protected static final String AGENT_POOL_SIZE_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getAgentPoolSize() <em>Agent Pool Size</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getAgentPoolSize()
	 * @generated
	 * @ordered
	 */
	protected String agentPoolSize = AGENT_POOL_SIZE_EDEFAULT;

	/**
	 * The default value of the '{@link #getAgentPriority() <em>Agent Priority</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getAgentPriority()
	 * @generated
	 * @ordered
	 */
	protected static final String AGENT_PRIORITY_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getAgentPriority() <em>Agent Priority</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getAgentPriority()
	 * @generated
	 * @ordered
	 */
	protected String agentPriority = AGENT_PRIORITY_EDEFAULT;

	/**
	 * The default value of the '{@link #getAgentStackSize() <em>Agent Stack Size</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getAgentStackSize()
	 * @generated
	 * @ordered
	 */
	protected static final String AGENT_STACK_SIZE_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getAgentStackSize() <em>Agent Stack Size</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getAgentStackSize()
	 * @generated
	 * @ordered
	 */
	protected String agentStackSize = AGENT_STACK_SIZE_EDEFAULT;

	/**
	 * The default value of the '{@link #getApplicationSupportLayerHeapSize() <em>Application Support Layer Heap Size</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getApplicationSupportLayerHeapSize()
	 * @generated
	 * @ordered
	 */
	protected static final String APPLICATION_SUPPORT_LAYER_HEAP_SIZE_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getApplicationSupportLayerHeapSize() <em>Application Support Layer Heap Size</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getApplicationSupportLayerHeapSize()
	 * @generated
	 * @ordered
	 */
	protected String applicationSupportLayerHeapSize = APPLICATION_SUPPORT_LAYER_HEAP_SIZE_EDEFAULT;

	/**
	 * The default value of the '{@link #getAuditBufferSize() <em>Audit Buffer Size</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getAuditBufferSize()
	 * @generated
	 * @ordered
	 */
	protected static final String AUDIT_BUFFER_SIZE_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getAuditBufferSize() <em>Audit Buffer Size</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getAuditBufferSize()
	 * @generated
	 * @ordered
	 */
	protected String auditBufferSize = AUDIT_BUFFER_SIZE_EDEFAULT;

	/**
	 * The default value of the '{@link #getAuthenticationType() <em>Authentication Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getAuthenticationType()
	 * @generated
	 * @ordered
	 */
	protected static final String AUTHENTICATION_TYPE_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getAuthenticationType() <em>Authentication Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getAuthenticationType()
	 * @generated
	 * @ordered
	 */
	protected String authenticationType = AUTHENTICATION_TYPE_EDEFAULT;

	/**
	 * The default value of the '{@link #getAuthenticationTypeForIncomingConnections() <em>Authentication Type For Incoming Connections</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getAuthenticationTypeForIncomingConnections()
	 * @generated
	 * @ordered
	 */
	protected static final String AUTHENTICATION_TYPE_FOR_INCOMING_CONNECTIONS_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getAuthenticationTypeForIncomingConnections() <em>Authentication Type For Incoming Connections</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getAuthenticationTypeForIncomingConnections()
	 * @generated
	 * @ordered
	 */
	protected String authenticationTypeForIncomingConnections = AUTHENTICATION_TYPE_FOR_INCOMING_CONNECTIONS_EDEFAULT;

	/**
	 * The default value of the '{@link #getBypassFederatedAuthentication() <em>Bypass Federated Authentication</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getBypassFederatedAuthentication()
	 * @generated
	 * @ordered
	 */
	protected static final String BYPASS_FEDERATED_AUTHENTICATION_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getBypassFederatedAuthentication() <em>Bypass Federated Authentication</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getBypassFederatedAuthentication()
	 * @generated
	 * @ordered
	 */
	protected String bypassFederatedAuthentication = BYPASS_FEDERATED_AUTHENTICATION_EDEFAULT;

	/**
	 * The default value of the '{@link #getCatalogingAllowedWithoutAuthority() <em>Cataloging Allowed Without Authority</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getCatalogingAllowedWithoutAuthority()
	 * @generated
	 * @ordered
	 */
	protected static final String CATALOGING_ALLOWED_WITHOUT_AUTHORITY_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getCatalogingAllowedWithoutAuthority() <em>Cataloging Allowed Without Authority</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getCatalogingAllowedWithoutAuthority()
	 * @generated
	 * @ordered
	 */
	protected String catalogingAllowedWithoutAuthority = CATALOGING_ALLOWED_WITHOUT_AUTHORITY_EDEFAULT;

	/**
	 * The default value of the '{@link #getClientIOBlockSize() <em>Client IO Block Size</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getClientIOBlockSize()
	 * @generated
	 * @ordered
	 */
	protected static final String CLIENT_IO_BLOCK_SIZE_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getClientIOBlockSize() <em>Client IO Block Size</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getClientIOBlockSize()
	 * @generated
	 * @ordered
	 */
	protected String clientIOBlockSize = CLIENT_IO_BLOCK_SIZE_EDEFAULT;

	/**
	 * The default value of the '{@link #getClientKerberosPlugin() <em>Client Kerberos Plugin</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getClientKerberosPlugin()
	 * @generated
	 * @ordered
	 */
	protected static final String CLIENT_KERBEROS_PLUGIN_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getClientKerberosPlugin() <em>Client Kerberos Plugin</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getClientKerberosPlugin()
	 * @generated
	 * @ordered
	 */
	protected String clientKerberosPlugin = CLIENT_KERBEROS_PLUGIN_EDEFAULT;

	/**
	 * The default value of the '{@link #getClientUseridPasswordPlugin() <em>Client Userid Password Plugin</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getClientUseridPasswordPlugin()
	 * @generated
	 * @ordered
	 */
	protected static final String CLIENT_USERID_PASSWORD_PLUGIN_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getClientUseridPasswordPlugin() <em>Client Userid Password Plugin</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getClientUseridPasswordPlugin()
	 * @generated
	 * @ordered
	 */
	protected String clientUseridPasswordPlugin = CLIENT_USERID_PASSWORD_PLUGIN_EDEFAULT;

	/**
	 * The default value of the '{@link #getCommunicationsBandwidth() <em>Communications Bandwidth</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getCommunicationsBandwidth()
	 * @generated
	 * @ordered
	 */
	protected static final String COMMUNICATIONS_BANDWIDTH_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getCommunicationsBandwidth() <em>Communications Bandwidth</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getCommunicationsBandwidth()
	 * @generated
	 * @ordered
	 */
	protected String communicationsBandwidth = COMMUNICATIONS_BANDWIDTH_EDEFAULT;

	/**
	 * The default value of the '{@link #getConfigurationFileReleaseLevel() <em>Configuration File Release Level</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getConfigurationFileReleaseLevel()
	 * @generated
	 * @ordered
	 */
	protected static final String CONFIGURATION_FILE_RELEASE_LEVEL_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getConfigurationFileReleaseLevel() <em>Configuration File Release Level</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getConfigurationFileReleaseLevel()
	 * @generated
	 * @ordered
	 */
	protected String configurationFileReleaseLevel = CONFIGURATION_FILE_RELEASE_LEVEL_EDEFAULT;

	/**
	 * The default value of the '{@link #getConnectionElapseTime() <em>Connection Elapse Time</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getConnectionElapseTime()
	 * @generated
	 * @ordered
	 */
	protected static final String CONNECTION_ELAPSE_TIME_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getConnectionElapseTime() <em>Connection Elapse Time</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getConnectionElapseTime()
	 * @generated
	 * @ordered
	 */
	protected String connectionElapseTime = CONNECTION_ELAPSE_TIME_EDEFAULT;

	/**
	 * The default value of the '{@link #getCPUSpeed() <em>CPU Speed</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getCPUSpeed()
	 * @generated
	 * @ordered
	 */
	protected static final String CPU_SPEED_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getCPUSpeed() <em>CPU Speed</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getCPUSpeed()
	 * @generated
	 * @ordered
	 */
	protected String cPUSpeed = CPU_SPEED_EDEFAULT;

	/**
	 * The default value of the '{@link #getDatabaseSystemMonitorHeapSize() <em>Database System Monitor Heap Size</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDatabaseSystemMonitorHeapSize()
	 * @generated
	 * @ordered
	 */
	protected static final String DATABASE_SYSTEM_MONITOR_HEAP_SIZE_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getDatabaseSystemMonitorHeapSize() <em>Database System Monitor Heap Size</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDatabaseSystemMonitorHeapSize()
	 * @generated
	 * @ordered
	 */
	protected String databaseSystemMonitorHeapSize = DATABASE_SYSTEM_MONITOR_HEAP_SIZE_EDEFAULT;

	/**
	 * The default value of the '{@link #getDefaultChargeBackAccount() <em>Default Charge Back Account</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDefaultChargeBackAccount()
	 * @generated
	 * @ordered
	 */
	protected static final String DEFAULT_CHARGE_BACK_ACCOUNT_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getDefaultChargeBackAccount() <em>Default Charge Back Account</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDefaultChargeBackAccount()
	 * @generated
	 * @ordered
	 */
	protected String defaultChargeBackAccount = DEFAULT_CHARGE_BACK_ACCOUNT_EDEFAULT;

	/**
	 * The default value of the '{@link #getDefaultDatabasePath() <em>Default Database Path</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDefaultDatabasePath()
	 * @generated
	 * @ordered
	 */
	protected static final String DEFAULT_DATABASE_PATH_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getDefaultDatabasePath() <em>Default Database Path</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDefaultDatabasePath()
	 * @generated
	 * @ordered
	 */
	protected String defaultDatabasePath = DEFAULT_DATABASE_PATH_EDEFAULT;

	/**
	 * The default value of the '{@link #getDefaultDatabaseSystemMonitorSwitches() <em>Default Database System Monitor Switches</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDefaultDatabaseSystemMonitorSwitches()
	 * @generated
	 * @ordered
	 */
	protected static final String DEFAULT_DATABASE_SYSTEM_MONITOR_SWITCHES_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getDefaultDatabaseSystemMonitorSwitches() <em>Default Database System Monitor Switches</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDefaultDatabaseSystemMonitorSwitches()
	 * @generated
	 * @ordered
	 */
	protected String defaultDatabaseSystemMonitorSwitches = DEFAULT_DATABASE_SYSTEM_MONITOR_SWITCHES_EDEFAULT;

	/**
	 * The default value of the '{@link #getDiagnosticDataDirectoryPath() <em>Diagnostic Data Directory Path</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDiagnosticDataDirectoryPath()
	 * @generated
	 * @ordered
	 */
	protected static final String DIAGNOSTIC_DATA_DIRECTORY_PATH_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getDiagnosticDataDirectoryPath() <em>Diagnostic Data Directory Path</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDiagnosticDataDirectoryPath()
	 * @generated
	 * @ordered
	 */
	protected String diagnosticDataDirectoryPath = DIAGNOSTIC_DATA_DIRECTORY_PATH_EDEFAULT;

	/**
	 * The default value of the '{@link #getDiagnosticErrorCaptureLevel() <em>Diagnostic Error Capture Level</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDiagnosticErrorCaptureLevel()
	 * @generated
	 * @ordered
	 */
	protected static final String DIAGNOSTIC_ERROR_CAPTURE_LEVEL_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getDiagnosticErrorCaptureLevel() <em>Diagnostic Error Capture Level</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDiagnosticErrorCaptureLevel()
	 * @generated
	 * @ordered
	 */
	protected String diagnosticErrorCaptureLevel = DIAGNOSTIC_ERROR_CAPTURE_LEVEL_EDEFAULT;

	/**
	 * The default value of the '{@link #getDirectoryCacheSupport() <em>Directory Cache Support</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDirectoryCacheSupport()
	 * @generated
	 * @ordered
	 */
	protected static final String DIRECTORY_CACHE_SUPPORT_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getDirectoryCacheSupport() <em>Directory Cache Support</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDirectoryCacheSupport()
	 * @generated
	 * @ordered
	 */
	protected String directoryCacheSupport = DIRECTORY_CACHE_SUPPORT_EDEFAULT;

	/**
	 * The default value of the '{@link #getDiscoverServerInstance() <em>Discover Server Instance</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDiscoverServerInstance()
	 * @generated
	 * @ordered
	 */
	protected static final String DISCOVER_SERVER_INSTANCE_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getDiscoverServerInstance() <em>Discover Server Instance</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDiscoverServerInstance()
	 * @generated
	 * @ordered
	 */
	protected String discoverServerInstance = DISCOVER_SERVER_INSTANCE_EDEFAULT;

	/**
	 * The default value of the '{@link #getDiscoveryMode() <em>Discovery Mode</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDiscoveryMode()
	 * @generated
	 * @ordered
	 */
	protected static final String DISCOVERY_MODE_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getDiscoveryMode() <em>Discovery Mode</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDiscoveryMode()
	 * @generated
	 * @ordered
	 */
	protected String discoveryMode = DISCOVERY_MODE_EDEFAULT;

	/**
	 * The default value of the '{@link #getEnablePntrapartitionParallelism() <em>Enable Pntrapartition Parallelism</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getEnablePntrapartitionParallelism()
	 * @generated
	 * @ordered
	 */
	protected static final String ENABLE_PNTRAPARTITION_PARALLELISM_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getEnablePntrapartitionParallelism() <em>Enable Pntrapartition Parallelism</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getEnablePntrapartitionParallelism()
	 * @generated
	 * @ordered
	 */
	protected String enablePntrapartitionParallelism = ENABLE_PNTRAPARTITION_PARALLELISM_EDEFAULT;

	/**
	 * The default value of the '{@link #getFederatedDatabaseSystemSupport() <em>Federated Database System Support</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getFederatedDatabaseSystemSupport()
	 * @generated
	 * @ordered
	 */
	protected static final String FEDERATED_DATABASE_SYSTEM_SUPPORT_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getFederatedDatabaseSystemSupport() <em>Federated Database System Support</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getFederatedDatabaseSystemSupport()
	 * @generated
	 * @ordered
	 */
	protected String federatedDatabaseSystemSupport = FEDERATED_DATABASE_SYSTEM_SUPPORT_EDEFAULT;

	/**
	 * The default value of the '{@link #getGroupPlugin() <em>Group Plugin</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getGroupPlugin()
	 * @generated
	 * @ordered
	 */
	protected static final String GROUP_PLUGIN_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getGroupPlugin() <em>Group Plugin</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getGroupPlugin()
	 * @generated
	 * @ordered
	 */
	protected String groupPlugin = GROUP_PLUGIN_EDEFAULT;

	/**
	 * The default value of the '{@link #getHealthMonitoring() <em>Health Monitoring</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getHealthMonitoring()
	 * @generated
	 * @ordered
	 */
	protected static final String HEALTH_MONITORING_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getHealthMonitoring() <em>Health Monitoring</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getHealthMonitoring()
	 * @generated
	 * @ordered
	 */
	protected String healthMonitoring = HEALTH_MONITORING_EDEFAULT;

	/**
	 * The default value of the '{@link #getIndexRecreationTime() <em>Index Recreation Time</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getIndexRecreationTime()
	 * @generated
	 * @ordered
	 */
	protected static final String INDEX_RECREATION_TIME_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getIndexRecreationTime() <em>Index Recreation Time</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getIndexRecreationTime()
	 * @generated
	 * @ordered
	 */
	protected String indexRecreationTime = INDEX_RECREATION_TIME_EDEFAULT;

	/**
	 * The default value of the '{@link #getInitialNumberOfAgentsInPool() <em>Initial Number Of Agents In Pool</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getInitialNumberOfAgentsInPool()
	 * @generated
	 * @ordered
	 */
	protected static final String INITIAL_NUMBER_OF_AGENTS_IN_POOL_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getInitialNumberOfAgentsInPool() <em>Initial Number Of Agents In Pool</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getInitialNumberOfAgentsInPool()
	 * @generated
	 * @ordered
	 */
	protected String initialNumberOfAgentsInPool = INITIAL_NUMBER_OF_AGENTS_IN_POOL_EDEFAULT;

	/**
	 * The default value of the '{@link #getInitialNumberOfFencedProcesses() <em>Initial Number Of Fenced Processes</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getInitialNumberOfFencedProcesses()
	 * @generated
	 * @ordered
	 */
	protected static final String INITIAL_NUMBER_OF_FENCED_PROCESSES_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getInitialNumberOfFencedProcesses() <em>Initial Number Of Fenced Processes</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getInitialNumberOfFencedProcesses()
	 * @generated
	 * @ordered
	 */
	protected String initialNumberOfFencedProcesses = INITIAL_NUMBER_OF_FENCED_PROCESSES_EDEFAULT;

	/**
	 * The default value of the '{@link #getInstanceImpactPolicy() <em>Instance Impact Policy</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getInstanceImpactPolicy()
	 * @generated
	 * @ordered
	 */
	protected static final String INSTANCE_IMPACT_POLICY_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getInstanceImpactPolicy() <em>Instance Impact Policy</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getInstanceImpactPolicy()
	 * @generated
	 * @ordered
	 */
	protected String instanceImpactPolicy = INSTANCE_IMPACT_POLICY_EDEFAULT;

	/**
	 * The default value of the '{@link #getInstanceMemory() <em>Instance Memory</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getInstanceMemory()
	 * @generated
	 * @ordered
	 */
	protected static final String INSTANCE_MEMORY_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getInstanceMemory() <em>Instance Memory</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getInstanceMemory()
	 * @generated
	 * @ordered
	 */
	protected String instanceMemory = INSTANCE_MEMORY_EDEFAULT;

	/**
	 * The default value of the '{@link #getKeepFencedProcess() <em>Keep Fenced Process</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getKeepFencedProcess()
	 * @generated
	 * @ordered
	 */
	protected static final String KEEP_FENCED_PROCESS_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getKeepFencedProcess() <em>Keep Fenced Process</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getKeepFencedProcess()
	 * @generated
	 * @ordered
	 */
	protected String keepFencedProcess = KEEP_FENCED_PROCESS_EDEFAULT;

	/**
	 * The default value of the '{@link #getListOfGSSAPIPluginsForIncomingConnections() <em>List Of GSSAPI Plugins For Incoming Connections</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getListOfGSSAPIPluginsForIncomingConnections()
	 * @generated
	 * @ordered
	 */
	protected static final String LIST_OF_GSSAPI_PLUGINS_FOR_INCOMING_CONNECTIONS_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getListOfGSSAPIPluginsForIncomingConnections() <em>List Of GSSAPI Plugins For Incoming Connections</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getListOfGSSAPIPluginsForIncomingConnections()
	 * @generated
	 * @ordered
	 */
	protected String listOfGSSAPIPluginsForIncomingConnections = LIST_OF_GSSAPI_PLUGINS_FOR_INCOMING_CONNECTIONS_EDEFAULT;

	/**
	 * The default value of the '{@link #getLocalGSSAPIPlugin() <em>Local GSSAPI Plugin</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getLocalGSSAPIPlugin()
	 * @generated
	 * @ordered
	 */
	protected static final String LOCAL_GSSAPI_PLUGIN_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getLocalGSSAPIPlugin() <em>Local GSSAPI Plugin</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getLocalGSSAPIPlugin()
	 * @generated
	 * @ordered
	 */
	protected String localGSSAPIPlugin = LOCAL_GSSAPI_PLUGIN_EDEFAULT;

	/**
	 * The default value of the '{@link #getMachineNodeType() <em>Machine Node Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getMachineNodeType()
	 * @generated
	 * @ordered
	 */
	protected static final String MACHINE_NODE_TYPE_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getMachineNodeType() <em>Machine Node Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getMachineNodeType()
	 * @generated
	 * @ordered
	 */
	protected String machineNodeType = MACHINE_NODE_TYPE_EDEFAULT;

	/**
	 * The default value of the '{@link #getMaximumAsynchronousTQsPerQuery() <em>Maximum Asynchronous TQs Per Query</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getMaximumAsynchronousTQsPerQuery()
	 * @generated
	 * @ordered
	 */
	protected static final String MAXIMUM_ASYNCHRONOUS_TQS_PER_QUERY_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getMaximumAsynchronousTQsPerQuery() <em>Maximum Asynchronous TQs Per Query</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getMaximumAsynchronousTQsPerQuery()
	 * @generated
	 * @ordered
	 */
	protected String maximumAsynchronousTQsPerQuery = MAXIMUM_ASYNCHRONOUS_TQS_PER_QUERY_EDEFAULT;

	/**
	 * The default value of the '{@link #getMaximumJavaInterpreterHeapSize() <em>Maximum Java Interpreter Heap Size</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getMaximumJavaInterpreterHeapSize()
	 * @generated
	 * @ordered
	 */
	protected static final String MAXIMUM_JAVA_INTERPRETER_HEAP_SIZE_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getMaximumJavaInterpreterHeapSize() <em>Maximum Java Interpreter Heap Size</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getMaximumJavaInterpreterHeapSize()
	 * @generated
	 * @ordered
	 */
	protected String maximumJavaInterpreterHeapSize = MAXIMUM_JAVA_INTERPRETER_HEAP_SIZE_EDEFAULT;

	/**
	 * The default value of the '{@link #getMaximumNumberOfAgents() <em>Maximum Number Of Agents</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getMaximumNumberOfAgents()
	 * @generated
	 * @ordered
	 */
	protected static final String MAXIMUM_NUMBER_OF_AGENTS_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getMaximumNumberOfAgents() <em>Maximum Number Of Agents</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getMaximumNumberOfAgents()
	 * @generated
	 * @ordered
	 */
	protected String maximumNumberOfAgents = MAXIMUM_NUMBER_OF_AGENTS_EDEFAULT;

	/**
	 * The default value of the '{@link #getMaximumNumberOfClientConnections() <em>Maximum Number Of Client Connections</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getMaximumNumberOfClientConnections()
	 * @generated
	 * @ordered
	 */
	protected static final String MAXIMUM_NUMBER_OF_CLIENT_CONNECTIONS_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getMaximumNumberOfClientConnections() <em>Maximum Number Of Client Connections</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getMaximumNumberOfClientConnections()
	 * @generated
	 * @ordered
	 */
	protected String maximumNumberOfClientConnections = MAXIMUM_NUMBER_OF_CLIENT_CONNECTIONS_EDEFAULT;

	/**
	 * The default value of the '{@link #getMaximumNumberOfConcurrentAgents() <em>Maximum Number Of Concurrent Agents</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getMaximumNumberOfConcurrentAgents()
	 * @generated
	 * @ordered
	 */
	protected static final String MAXIMUM_NUMBER_OF_CONCURRENT_AGENTS_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getMaximumNumberOfConcurrentAgents() <em>Maximum Number Of Concurrent Agents</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getMaximumNumberOfConcurrentAgents()
	 * @generated
	 * @ordered
	 */
	protected String maximumNumberOfConcurrentAgents = MAXIMUM_NUMBER_OF_CONCURRENT_AGENTS_EDEFAULT;

	/**
	 * The default value of the '{@link #getMaximumNumberOfConcurrentlyActiveDatabases() <em>Maximum Number Of Concurrently Active Databases</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getMaximumNumberOfConcurrentlyActiveDatabases()
	 * @generated
	 * @ordered
	 */
	protected static final String MAXIMUM_NUMBER_OF_CONCURRENTLY_ACTIVE_DATABASES_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getMaximumNumberOfConcurrentlyActiveDatabases() <em>Maximum Number Of Concurrently Active Databases</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getMaximumNumberOfConcurrentlyActiveDatabases()
	 * @generated
	 * @ordered
	 */
	protected String maximumNumberOfConcurrentlyActiveDatabases = MAXIMUM_NUMBER_OF_CONCURRENTLY_ACTIVE_DATABASES_EDEFAULT;

	/**
	 * The default value of the '{@link #getMaximumNumberOfCoordinatingAgents() <em>Maximum Number Of Coordinating Agents</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getMaximumNumberOfCoordinatingAgents()
	 * @generated
	 * @ordered
	 */
	protected static final String MAXIMUM_NUMBER_OF_COORDINATING_AGENTS_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getMaximumNumberOfCoordinatingAgents() <em>Maximum Number Of Coordinating Agents</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getMaximumNumberOfCoordinatingAgents()
	 * @generated
	 * @ordered
	 */
	protected String maximumNumberOfCoordinatingAgents = MAXIMUM_NUMBER_OF_COORDINATING_AGENTS_EDEFAULT;

	/**
	 * The default value of the '{@link #getMaximumNumberOfFencedProcesses() <em>Maximum Number Of Fenced Processes</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getMaximumNumberOfFencedProcesses()
	 * @generated
	 * @ordered
	 */
	protected static final String MAXIMUM_NUMBER_OF_FENCED_PROCESSES_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getMaximumNumberOfFencedProcesses() <em>Maximum Number Of Fenced Processes</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getMaximumNumberOfFencedProcesses()
	 * @generated
	 * @ordered
	 */
	protected String maximumNumberOfFencedProcesses = MAXIMUM_NUMBER_OF_FENCED_PROCESSES_EDEFAULT;

	/**
	 * The default value of the '{@link #getMaximumQueryDegreeOfParallelism() <em>Maximum Query Degree Of Parallelism</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getMaximumQueryDegreeOfParallelism()
	 * @generated
	 * @ordered
	 */
	protected static final String MAXIMUM_QUERY_DEGREE_OF_PARALLELISM_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getMaximumQueryDegreeOfParallelism() <em>Maximum Query Degree Of Parallelism</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getMaximumQueryDegreeOfParallelism()
	 * @generated
	 * @ordered
	 */
	protected String maximumQueryDegreeOfParallelism = MAXIMUM_QUERY_DEGREE_OF_PARALLELISM_EDEFAULT;

	/**
	 * The default value of the '{@link #getMaximumTimeDifferenceAmongNodes() <em>Maximum Time Difference Among Nodes</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getMaximumTimeDifferenceAmongNodes()
	 * @generated
	 * @ordered
	 */
	protected static final String MAXIMUM_TIME_DIFFERENCE_AMONG_NODES_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getMaximumTimeDifferenceAmongNodes() <em>Maximum Time Difference Among Nodes</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getMaximumTimeDifferenceAmongNodes()
	 * @generated
	 * @ordered
	 */
	protected String maximumTimeDifferenceAmongNodes = MAXIMUM_TIME_DIFFERENCE_AMONG_NODES_EDEFAULT;

	/**
	 * The default value of the '{@link #getNodeConnectionRetries() <em>Node Connection Retries</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getNodeConnectionRetries()
	 * @generated
	 * @ordered
	 */
	protected static final String NODE_CONNECTION_RETRIES_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getNodeConnectionRetries() <em>Node Connection Retries</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getNodeConnectionRetries()
	 * @generated
	 * @ordered
	 */
	protected String nodeConnectionRetries = NODE_CONNECTION_RETRIES_EDEFAULT;

	/**
	 * The default value of the '{@link #getNotifyLevel() <em>Notify Level</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getNotifyLevel()
	 * @generated
	 * @ordered
	 */
	protected static final String NOTIFY_LEVEL_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getNotifyLevel() <em>Notify Level</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getNotifyLevel()
	 * @generated
	 * @ordered
	 */
	protected String notifyLevel = NOTIFY_LEVEL_EDEFAULT;

	/**
	 * The default value of the '{@link #getNumberOfFCMBuffers() <em>Number Of FCM Buffers</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getNumberOfFCMBuffers()
	 * @generated
	 * @ordered
	 */
	protected static final String NUMBER_OF_FCM_BUFFERS_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getNumberOfFCMBuffers() <em>Number Of FCM Buffers</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getNumberOfFCMBuffers()
	 * @generated
	 * @ordered
	 */
	protected String numberOfFCMBuffers = NUMBER_OF_FCM_BUFFERS_EDEFAULT;

	/**
	 * The default value of the '{@link #getNumberOfFCMChannels() <em>Number Of FCM Channels</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getNumberOfFCMChannels()
	 * @generated
	 * @ordered
	 */
	protected static final String NUMBER_OF_FCM_CHANNELS_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getNumberOfFCMChannels() <em>Number Of FCM Channels</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getNumberOfFCMChannels()
	 * @generated
	 * @ordered
	 */
	protected String numberOfFCMChannels = NUMBER_OF_FCM_CHANNELS_EDEFAULT;

	/**
	 * The default value of the '{@link #getQueryHeapSize() <em>Query Heap Size</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getQueryHeapSize()
	 * @generated
	 * @ordered
	 */
	protected static final String QUERY_HEAP_SIZE_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getQueryHeapSize() <em>Query Heap Size</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getQueryHeapSize()
	 * @generated
	 * @ordered
	 */
	protected String queryHeapSize = QUERY_HEAP_SIZE_EDEFAULT;

	/**
	 * The default value of the '{@link #getServerPluginMode() <em>Server Plugin Mode</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getServerPluginMode()
	 * @generated
	 * @ordered
	 */
	protected static final String SERVER_PLUGIN_MODE_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getServerPluginMode() <em>Server Plugin Mode</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getServerPluginMode()
	 * @generated
	 * @ordered
	 */
	protected String serverPluginMode = SERVER_PLUGIN_MODE_EDEFAULT;

	/**
	 * The default value of the '{@link #getSoftwareDevelopersKitForJavaInstallationPath() <em>Software Developers Kit For Java Installation Path</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSoftwareDevelopersKitForJavaInstallationPath()
	 * @generated
	 * @ordered
	 */
	protected static final String SOFTWARE_DEVELOPERS_KIT_FOR_JAVA_INSTALLATION_PATH_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getSoftwareDevelopersKitForJavaInstallationPath() <em>Software Developers Kit For Java Installation Path</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSoftwareDevelopersKitForJavaInstallationPath()
	 * @generated
	 * @ordered
	 */
	protected String softwareDevelopersKitForJavaInstallationPath = SOFTWARE_DEVELOPERS_KIT_FOR_JAVA_INSTALLATION_PATH_EDEFAULT;

	/**
	 * The default value of the '{@link #getSortHeapThreshold() <em>Sort Heap Threshold</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSortHeapThreshold()
	 * @generated
	 * @ordered
	 */
	protected static final String SORT_HEAP_THRESHOLD_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getSortHeapThreshold() <em>Sort Heap Threshold</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSortHeapThreshold()
	 * @generated
	 * @ordered
	 */
	protected String sortHeapThreshold = SORT_HEAP_THRESHOLD_EDEFAULT;

	/**
	 * The default value of the '{@link #getStartAndStopTimeout() <em>Start And Stop Timeout</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getStartAndStopTimeout()
	 * @generated
	 * @ordered
	 */
	protected static final String START_AND_STOP_TIMEOUT_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getStartAndStopTimeout() <em>Start And Stop Timeout</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getStartAndStopTimeout()
	 * @generated
	 * @ordered
	 */
	protected String startAndStopTimeout = START_AND_STOP_TIMEOUT_EDEFAULT;

	/**
	 * The default value of the '{@link #getSyncPointManagerLogFilePath() <em>Sync Point Manager Log File Path</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSyncPointManagerLogFilePath()
	 * @generated
	 * @ordered
	 */
	protected static final String SYNC_POINT_MANAGER_LOG_FILE_PATH_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getSyncPointManagerLogFilePath() <em>Sync Point Manager Log File Path</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSyncPointManagerLogFilePath()
	 * @generated
	 * @ordered
	 */
	protected String syncPointManagerLogFilePath = SYNC_POINT_MANAGER_LOG_FILE_PATH_EDEFAULT;

	/**
	 * The default value of the '{@link #getSyncPointManagerLogFileSize() <em>Sync Point Manager Log File Size</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSyncPointManagerLogFileSize()
	 * @generated
	 * @ordered
	 */
	protected static final String SYNC_POINT_MANAGER_LOG_FILE_SIZE_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getSyncPointManagerLogFileSize() <em>Sync Point Manager Log File Size</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSyncPointManagerLogFileSize()
	 * @generated
	 * @ordered
	 */
	protected String syncPointManagerLogFileSize = SYNC_POINT_MANAGER_LOG_FILE_SIZE_EDEFAULT;

	/**
	 * The default value of the '{@link #getSyncPointManagerName() <em>Sync Point Manager Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSyncPointManagerName()
	 * @generated
	 * @ordered
	 */
	protected static final String SYNC_POINT_MANAGER_NAME_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getSyncPointManagerName() <em>Sync Point Manager Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSyncPointManagerName()
	 * @generated
	 * @ordered
	 */
	protected String syncPointManagerName = SYNC_POINT_MANAGER_NAME_EDEFAULT;

	/**
	 * The default value of the '{@link #getSyncPointManagerResyncAgentLimit() <em>Sync Point Manager Resync Agent Limit</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSyncPointManagerResyncAgentLimit()
	 * @generated
	 * @ordered
	 */
	protected static final String SYNC_POINT_MANAGER_RESYNC_AGENT_LIMIT_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getSyncPointManagerResyncAgentLimit() <em>Sync Point Manager Resync Agent Limit</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSyncPointManagerResyncAgentLimit()
	 * @generated
	 * @ordered
	 */
	protected String syncPointManagerResyncAgentLimit = SYNC_POINT_MANAGER_RESYNC_AGENT_LIMIT_EDEFAULT;

	/**
	 * The default value of the '{@link #getSystemAdministrationAuthorityGroupName() <em>System Administration Authority Group Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSystemAdministrationAuthorityGroupName()
	 * @generated
	 * @ordered
	 */
	protected static final String SYSTEM_ADMINISTRATION_AUTHORITY_GROUP_NAME_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getSystemAdministrationAuthorityGroupName() <em>System Administration Authority Group Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSystemAdministrationAuthorityGroupName()
	 * @generated
	 * @ordered
	 */
	protected String systemAdministrationAuthorityGroupName = SYSTEM_ADMINISTRATION_AUTHORITY_GROUP_NAME_EDEFAULT;

	/**
	 * The default value of the '{@link #getSystemControlAuthorityGroupName() <em>System Control Authority Group Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSystemControlAuthorityGroupName()
	 * @generated
	 * @ordered
	 */
	protected static final String SYSTEM_CONTROL_AUTHORITY_GROUP_NAME_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getSystemControlAuthorityGroupName() <em>System Control Authority Group Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSystemControlAuthorityGroupName()
	 * @generated
	 * @ordered
	 */
	protected String systemControlAuthorityGroupName = SYSTEM_CONTROL_AUTHORITY_GROUP_NAME_EDEFAULT;

	/**
	 * The default value of the '{@link #getSystemMaintenanceAuthorityGroupName() <em>System Maintenance Authority Group Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSystemMaintenanceAuthorityGroupName()
	 * @generated
	 * @ordered
	 */
	protected static final String SYSTEM_MAINTENANCE_AUTHORITY_GROUP_NAME_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getSystemMaintenanceAuthorityGroupName() <em>System Maintenance Authority Group Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSystemMaintenanceAuthorityGroupName()
	 * @generated
	 * @ordered
	 */
	protected String systemMaintenanceAuthorityGroupName = SYSTEM_MAINTENANCE_AUTHORITY_GROUP_NAME_EDEFAULT;

	/**
	 * The default value of the '{@link #getSystemMonitorAuthorityGroupName() <em>System Monitor Authority Group Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSystemMonitorAuthorityGroupName()
	 * @generated
	 * @ordered
	 */
	protected static final String SYSTEM_MONITOR_AUTHORITY_GROUP_NAME_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getSystemMonitorAuthorityGroupName() <em>System Monitor Authority Group Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSystemMonitorAuthorityGroupName()
	 * @generated
	 * @ordered
	 */
	protected String systemMonitorAuthorityGroupName = SYSTEM_MONITOR_AUTHORITY_GROUP_NAME_EDEFAULT;

	/**
	 * The default value of the '{@link #getTCPIPServiceName() <em>TCPIP Service Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTCPIPServiceName()
	 * @generated
	 * @ordered
	 */
	protected static final String TCPIP_SERVICE_NAME_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getTCPIPServiceName() <em>TCPIP Service Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTCPIPServiceName()
	 * @generated
	 * @ordered
	 */
	protected String tCPIPServiceName = TCPIP_SERVICE_NAME_EDEFAULT;

	/**
	 * The default value of the '{@link #getTransactionManagerDatabaseName() <em>Transaction Manager Database Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTransactionManagerDatabaseName()
	 * @generated
	 * @ordered
	 */
	protected static final String TRANSACTION_MANAGER_DATABASE_NAME_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getTransactionManagerDatabaseName() <em>Transaction Manager Database Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTransactionManagerDatabaseName()
	 * @generated
	 * @ordered
	 */
	protected String transactionManagerDatabaseName = TRANSACTION_MANAGER_DATABASE_NAME_EDEFAULT;

	/**
	 * The default value of the '{@link #getTransactionProcessorMonitorName() <em>Transaction Processor Monitor Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTransactionProcessorMonitorName()
	 * @generated
	 * @ordered
	 */
	protected static final String TRANSACTION_PROCESSOR_MONITOR_NAME_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getTransactionProcessorMonitorName() <em>Transaction Processor Monitor Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTransactionProcessorMonitorName()
	 * @generated
	 * @ordered
	 */
	protected String transactionProcessorMonitorName = TRANSACTION_PROCESSOR_MONITOR_NAME_EDEFAULT;

	/**
	 * The default value of the '{@link #getTransactionResyncInterval() <em>Transaction Resync Interval</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTransactionResyncInterval()
	 * @generated
	 * @ordered
	 */
	protected static final String TRANSACTION_RESYNC_INTERVAL_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getTransactionResyncInterval() <em>Transaction Resync Interval</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTransactionResyncInterval()
	 * @generated
	 * @ordered
	 */
	protected String transactionResyncInterval = TRANSACTION_RESYNC_INTERVAL_EDEFAULT;

	/**
	 * The default value of the '{@link #getTrustAllClients() <em>Trust All Clients</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTrustAllClients()
	 * @generated
	 * @ordered
	 */
	protected static final String TRUST_ALL_CLIENTS_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getTrustAllClients() <em>Trust All Clients</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTrustAllClients()
	 * @generated
	 * @ordered
	 */
	protected String trustAllClients = TRUST_ALL_CLIENTS_EDEFAULT;

	/**
	 * The default value of the '{@link #getTrustedClientsAuthentication() <em>Trusted Clients Authentication</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTrustedClientsAuthentication()
	 * @generated
	 * @ordered
	 */
	protected static final String TRUSTED_CLIENTS_AUTHENTICATION_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getTrustedClientsAuthentication() <em>Trusted Clients Authentication</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTrustedClientsAuthentication()
	 * @generated
	 * @ordered
	 */
	protected String trustedClientsAuthentication = TRUSTED_CLIENTS_AUTHENTICATION_EDEFAULT;

	/**
	 * The default value of the '{@link #getUseridPasswordPlugIn() <em>Userid Password Plug In</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getUseridPasswordPlugIn()
	 * @generated
	 * @ordered
	 */
	protected static final String USERID_PASSWORD_PLUG_IN_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getUseridPasswordPlugIn() <em>Userid Password Plug In</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getUseridPasswordPlugIn()
	 * @generated
	 * @ordered
	 */
	protected String useridPasswordPlugIn = USERID_PASSWORD_PLUG_IN_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected DB2ManagerImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected EClass eStaticClass() {
		return Db2highPackage.Literals.DB2_MANAGER;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getAgentPoolSize() {
		return agentPoolSize;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setAgentPoolSize(String newAgentPoolSize) {
		String oldAgentPoolSize = agentPoolSize;
		agentPoolSize = newAgentPoolSize;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, Db2highPackage.DB2_MANAGER__AGENT_POOL_SIZE, oldAgentPoolSize, agentPoolSize));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getAgentPriority() {
		return agentPriority;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setAgentPriority(String newAgentPriority) {
		String oldAgentPriority = agentPriority;
		agentPriority = newAgentPriority;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, Db2highPackage.DB2_MANAGER__AGENT_PRIORITY, oldAgentPriority, agentPriority));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getAgentStackSize() {
		return agentStackSize;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setAgentStackSize(String newAgentStackSize) {
		String oldAgentStackSize = agentStackSize;
		agentStackSize = newAgentStackSize;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, Db2highPackage.DB2_MANAGER__AGENT_STACK_SIZE, oldAgentStackSize, agentStackSize));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getApplicationSupportLayerHeapSize() {
		return applicationSupportLayerHeapSize;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setApplicationSupportLayerHeapSize(String newApplicationSupportLayerHeapSize) {
		String oldApplicationSupportLayerHeapSize = applicationSupportLayerHeapSize;
		applicationSupportLayerHeapSize = newApplicationSupportLayerHeapSize;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, Db2highPackage.DB2_MANAGER__APPLICATION_SUPPORT_LAYER_HEAP_SIZE, oldApplicationSupportLayerHeapSize, applicationSupportLayerHeapSize));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getAuditBufferSize() {
		return auditBufferSize;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setAuditBufferSize(String newAuditBufferSize) {
		String oldAuditBufferSize = auditBufferSize;
		auditBufferSize = newAuditBufferSize;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, Db2highPackage.DB2_MANAGER__AUDIT_BUFFER_SIZE, oldAuditBufferSize, auditBufferSize));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getAuthenticationType() {
		return authenticationType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setAuthenticationType(String newAuthenticationType) {
		String oldAuthenticationType = authenticationType;
		authenticationType = newAuthenticationType;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, Db2highPackage.DB2_MANAGER__AUTHENTICATION_TYPE, oldAuthenticationType, authenticationType));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getAuthenticationTypeForIncomingConnections() {
		return authenticationTypeForIncomingConnections;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setAuthenticationTypeForIncomingConnections(String newAuthenticationTypeForIncomingConnections) {
		String oldAuthenticationTypeForIncomingConnections = authenticationTypeForIncomingConnections;
		authenticationTypeForIncomingConnections = newAuthenticationTypeForIncomingConnections;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, Db2highPackage.DB2_MANAGER__AUTHENTICATION_TYPE_FOR_INCOMING_CONNECTIONS, oldAuthenticationTypeForIncomingConnections, authenticationTypeForIncomingConnections));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getBypassFederatedAuthentication() {
		return bypassFederatedAuthentication;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setBypassFederatedAuthentication(String newBypassFederatedAuthentication) {
		String oldBypassFederatedAuthentication = bypassFederatedAuthentication;
		bypassFederatedAuthentication = newBypassFederatedAuthentication;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, Db2highPackage.DB2_MANAGER__BYPASS_FEDERATED_AUTHENTICATION, oldBypassFederatedAuthentication, bypassFederatedAuthentication));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getCatalogingAllowedWithoutAuthority() {
		return catalogingAllowedWithoutAuthority;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setCatalogingAllowedWithoutAuthority(String newCatalogingAllowedWithoutAuthority) {
		String oldCatalogingAllowedWithoutAuthority = catalogingAllowedWithoutAuthority;
		catalogingAllowedWithoutAuthority = newCatalogingAllowedWithoutAuthority;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, Db2highPackage.DB2_MANAGER__CATALOGING_ALLOWED_WITHOUT_AUTHORITY, oldCatalogingAllowedWithoutAuthority, catalogingAllowedWithoutAuthority));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getClientIOBlockSize() {
		return clientIOBlockSize;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setClientIOBlockSize(String newClientIOBlockSize) {
		String oldClientIOBlockSize = clientIOBlockSize;
		clientIOBlockSize = newClientIOBlockSize;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, Db2highPackage.DB2_MANAGER__CLIENT_IO_BLOCK_SIZE, oldClientIOBlockSize, clientIOBlockSize));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getClientKerberosPlugin() {
		return clientKerberosPlugin;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setClientKerberosPlugin(String newClientKerberosPlugin) {
		String oldClientKerberosPlugin = clientKerberosPlugin;
		clientKerberosPlugin = newClientKerberosPlugin;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, Db2highPackage.DB2_MANAGER__CLIENT_KERBEROS_PLUGIN, oldClientKerberosPlugin, clientKerberosPlugin));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getClientUseridPasswordPlugin() {
		return clientUseridPasswordPlugin;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setClientUseridPasswordPlugin(String newClientUseridPasswordPlugin) {
		String oldClientUseridPasswordPlugin = clientUseridPasswordPlugin;
		clientUseridPasswordPlugin = newClientUseridPasswordPlugin;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, Db2highPackage.DB2_MANAGER__CLIENT_USERID_PASSWORD_PLUGIN, oldClientUseridPasswordPlugin, clientUseridPasswordPlugin));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getCommunicationsBandwidth() {
		return communicationsBandwidth;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setCommunicationsBandwidth(String newCommunicationsBandwidth) {
		String oldCommunicationsBandwidth = communicationsBandwidth;
		communicationsBandwidth = newCommunicationsBandwidth;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, Db2highPackage.DB2_MANAGER__COMMUNICATIONS_BANDWIDTH, oldCommunicationsBandwidth, communicationsBandwidth));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getConfigurationFileReleaseLevel() {
		return configurationFileReleaseLevel;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setConfigurationFileReleaseLevel(String newConfigurationFileReleaseLevel) {
		String oldConfigurationFileReleaseLevel = configurationFileReleaseLevel;
		configurationFileReleaseLevel = newConfigurationFileReleaseLevel;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, Db2highPackage.DB2_MANAGER__CONFIGURATION_FILE_RELEASE_LEVEL, oldConfigurationFileReleaseLevel, configurationFileReleaseLevel));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getConnectionElapseTime() {
		return connectionElapseTime;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setConnectionElapseTime(String newConnectionElapseTime) {
		String oldConnectionElapseTime = connectionElapseTime;
		connectionElapseTime = newConnectionElapseTime;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, Db2highPackage.DB2_MANAGER__CONNECTION_ELAPSE_TIME, oldConnectionElapseTime, connectionElapseTime));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getCPUSpeed() {
		return cPUSpeed;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setCPUSpeed(String newCPUSpeed) {
		String oldCPUSpeed = cPUSpeed;
		cPUSpeed = newCPUSpeed;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, Db2highPackage.DB2_MANAGER__CPU_SPEED, oldCPUSpeed, cPUSpeed));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getDatabaseSystemMonitorHeapSize() {
		return databaseSystemMonitorHeapSize;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setDatabaseSystemMonitorHeapSize(String newDatabaseSystemMonitorHeapSize) {
		String oldDatabaseSystemMonitorHeapSize = databaseSystemMonitorHeapSize;
		databaseSystemMonitorHeapSize = newDatabaseSystemMonitorHeapSize;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, Db2highPackage.DB2_MANAGER__DATABASE_SYSTEM_MONITOR_HEAP_SIZE, oldDatabaseSystemMonitorHeapSize, databaseSystemMonitorHeapSize));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getDefaultChargeBackAccount() {
		return defaultChargeBackAccount;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setDefaultChargeBackAccount(String newDefaultChargeBackAccount) {
		String oldDefaultChargeBackAccount = defaultChargeBackAccount;
		defaultChargeBackAccount = newDefaultChargeBackAccount;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, Db2highPackage.DB2_MANAGER__DEFAULT_CHARGE_BACK_ACCOUNT, oldDefaultChargeBackAccount, defaultChargeBackAccount));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getDefaultDatabasePath() {
		return defaultDatabasePath;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setDefaultDatabasePath(String newDefaultDatabasePath) {
		String oldDefaultDatabasePath = defaultDatabasePath;
		defaultDatabasePath = newDefaultDatabasePath;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, Db2highPackage.DB2_MANAGER__DEFAULT_DATABASE_PATH, oldDefaultDatabasePath, defaultDatabasePath));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getDefaultDatabaseSystemMonitorSwitches() {
		return defaultDatabaseSystemMonitorSwitches;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setDefaultDatabaseSystemMonitorSwitches(String newDefaultDatabaseSystemMonitorSwitches) {
		String oldDefaultDatabaseSystemMonitorSwitches = defaultDatabaseSystemMonitorSwitches;
		defaultDatabaseSystemMonitorSwitches = newDefaultDatabaseSystemMonitorSwitches;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, Db2highPackage.DB2_MANAGER__DEFAULT_DATABASE_SYSTEM_MONITOR_SWITCHES, oldDefaultDatabaseSystemMonitorSwitches, defaultDatabaseSystemMonitorSwitches));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getDiagnosticDataDirectoryPath() {
		return diagnosticDataDirectoryPath;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setDiagnosticDataDirectoryPath(String newDiagnosticDataDirectoryPath) {
		String oldDiagnosticDataDirectoryPath = diagnosticDataDirectoryPath;
		diagnosticDataDirectoryPath = newDiagnosticDataDirectoryPath;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, Db2highPackage.DB2_MANAGER__DIAGNOSTIC_DATA_DIRECTORY_PATH, oldDiagnosticDataDirectoryPath, diagnosticDataDirectoryPath));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getDiagnosticErrorCaptureLevel() {
		return diagnosticErrorCaptureLevel;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setDiagnosticErrorCaptureLevel(String newDiagnosticErrorCaptureLevel) {
		String oldDiagnosticErrorCaptureLevel = diagnosticErrorCaptureLevel;
		diagnosticErrorCaptureLevel = newDiagnosticErrorCaptureLevel;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, Db2highPackage.DB2_MANAGER__DIAGNOSTIC_ERROR_CAPTURE_LEVEL, oldDiagnosticErrorCaptureLevel, diagnosticErrorCaptureLevel));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getDirectoryCacheSupport() {
		return directoryCacheSupport;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setDirectoryCacheSupport(String newDirectoryCacheSupport) {
		String oldDirectoryCacheSupport = directoryCacheSupport;
		directoryCacheSupport = newDirectoryCacheSupport;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, Db2highPackage.DB2_MANAGER__DIRECTORY_CACHE_SUPPORT, oldDirectoryCacheSupport, directoryCacheSupport));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getDiscoverServerInstance() {
		return discoverServerInstance;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setDiscoverServerInstance(String newDiscoverServerInstance) {
		String oldDiscoverServerInstance = discoverServerInstance;
		discoverServerInstance = newDiscoverServerInstance;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, Db2highPackage.DB2_MANAGER__DISCOVER_SERVER_INSTANCE, oldDiscoverServerInstance, discoverServerInstance));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getDiscoveryMode() {
		return discoveryMode;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setDiscoveryMode(String newDiscoveryMode) {
		String oldDiscoveryMode = discoveryMode;
		discoveryMode = newDiscoveryMode;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, Db2highPackage.DB2_MANAGER__DISCOVERY_MODE, oldDiscoveryMode, discoveryMode));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getEnablePntrapartitionParallelism() {
		return enablePntrapartitionParallelism;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setEnablePntrapartitionParallelism(String newEnablePntrapartitionParallelism) {
		String oldEnablePntrapartitionParallelism = enablePntrapartitionParallelism;
		enablePntrapartitionParallelism = newEnablePntrapartitionParallelism;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, Db2highPackage.DB2_MANAGER__ENABLE_PNTRAPARTITION_PARALLELISM, oldEnablePntrapartitionParallelism, enablePntrapartitionParallelism));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getFederatedDatabaseSystemSupport() {
		return federatedDatabaseSystemSupport;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setFederatedDatabaseSystemSupport(String newFederatedDatabaseSystemSupport) {
		String oldFederatedDatabaseSystemSupport = federatedDatabaseSystemSupport;
		federatedDatabaseSystemSupport = newFederatedDatabaseSystemSupport;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, Db2highPackage.DB2_MANAGER__FEDERATED_DATABASE_SYSTEM_SUPPORT, oldFederatedDatabaseSystemSupport, federatedDatabaseSystemSupport));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getGroupPlugin() {
		return groupPlugin;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setGroupPlugin(String newGroupPlugin) {
		String oldGroupPlugin = groupPlugin;
		groupPlugin = newGroupPlugin;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, Db2highPackage.DB2_MANAGER__GROUP_PLUGIN, oldGroupPlugin, groupPlugin));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getHealthMonitoring() {
		return healthMonitoring;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setHealthMonitoring(String newHealthMonitoring) {
		String oldHealthMonitoring = healthMonitoring;
		healthMonitoring = newHealthMonitoring;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, Db2highPackage.DB2_MANAGER__HEALTH_MONITORING, oldHealthMonitoring, healthMonitoring));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getIndexRecreationTime() {
		return indexRecreationTime;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setIndexRecreationTime(String newIndexRecreationTime) {
		String oldIndexRecreationTime = indexRecreationTime;
		indexRecreationTime = newIndexRecreationTime;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, Db2highPackage.DB2_MANAGER__INDEX_RECREATION_TIME, oldIndexRecreationTime, indexRecreationTime));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getInitialNumberOfAgentsInPool() {
		return initialNumberOfAgentsInPool;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setInitialNumberOfAgentsInPool(String newInitialNumberOfAgentsInPool) {
		String oldInitialNumberOfAgentsInPool = initialNumberOfAgentsInPool;
		initialNumberOfAgentsInPool = newInitialNumberOfAgentsInPool;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, Db2highPackage.DB2_MANAGER__INITIAL_NUMBER_OF_AGENTS_IN_POOL, oldInitialNumberOfAgentsInPool, initialNumberOfAgentsInPool));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getInitialNumberOfFencedProcesses() {
		return initialNumberOfFencedProcesses;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setInitialNumberOfFencedProcesses(String newInitialNumberOfFencedProcesses) {
		String oldInitialNumberOfFencedProcesses = initialNumberOfFencedProcesses;
		initialNumberOfFencedProcesses = newInitialNumberOfFencedProcesses;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, Db2highPackage.DB2_MANAGER__INITIAL_NUMBER_OF_FENCED_PROCESSES, oldInitialNumberOfFencedProcesses, initialNumberOfFencedProcesses));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getInstanceImpactPolicy() {
		return instanceImpactPolicy;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setInstanceImpactPolicy(String newInstanceImpactPolicy) {
		String oldInstanceImpactPolicy = instanceImpactPolicy;
		instanceImpactPolicy = newInstanceImpactPolicy;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, Db2highPackage.DB2_MANAGER__INSTANCE_IMPACT_POLICY, oldInstanceImpactPolicy, instanceImpactPolicy));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getInstanceMemory() {
		return instanceMemory;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setInstanceMemory(String newInstanceMemory) {
		String oldInstanceMemory = instanceMemory;
		instanceMemory = newInstanceMemory;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, Db2highPackage.DB2_MANAGER__INSTANCE_MEMORY, oldInstanceMemory, instanceMemory));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getKeepFencedProcess() {
		return keepFencedProcess;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setKeepFencedProcess(String newKeepFencedProcess) {
		String oldKeepFencedProcess = keepFencedProcess;
		keepFencedProcess = newKeepFencedProcess;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, Db2highPackage.DB2_MANAGER__KEEP_FENCED_PROCESS, oldKeepFencedProcess, keepFencedProcess));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getListOfGSSAPIPluginsForIncomingConnections() {
		return listOfGSSAPIPluginsForIncomingConnections;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setListOfGSSAPIPluginsForIncomingConnections(String newListOfGSSAPIPluginsForIncomingConnections) {
		String oldListOfGSSAPIPluginsForIncomingConnections = listOfGSSAPIPluginsForIncomingConnections;
		listOfGSSAPIPluginsForIncomingConnections = newListOfGSSAPIPluginsForIncomingConnections;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, Db2highPackage.DB2_MANAGER__LIST_OF_GSSAPI_PLUGINS_FOR_INCOMING_CONNECTIONS, oldListOfGSSAPIPluginsForIncomingConnections, listOfGSSAPIPluginsForIncomingConnections));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getLocalGSSAPIPlugin() {
		return localGSSAPIPlugin;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setLocalGSSAPIPlugin(String newLocalGSSAPIPlugin) {
		String oldLocalGSSAPIPlugin = localGSSAPIPlugin;
		localGSSAPIPlugin = newLocalGSSAPIPlugin;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, Db2highPackage.DB2_MANAGER__LOCAL_GSSAPI_PLUGIN, oldLocalGSSAPIPlugin, localGSSAPIPlugin));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getMachineNodeType() {
		return machineNodeType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setMachineNodeType(String newMachineNodeType) {
		String oldMachineNodeType = machineNodeType;
		machineNodeType = newMachineNodeType;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, Db2highPackage.DB2_MANAGER__MACHINE_NODE_TYPE, oldMachineNodeType, machineNodeType));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getMaximumAsynchronousTQsPerQuery() {
		return maximumAsynchronousTQsPerQuery;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setMaximumAsynchronousTQsPerQuery(String newMaximumAsynchronousTQsPerQuery) {
		String oldMaximumAsynchronousTQsPerQuery = maximumAsynchronousTQsPerQuery;
		maximumAsynchronousTQsPerQuery = newMaximumAsynchronousTQsPerQuery;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, Db2highPackage.DB2_MANAGER__MAXIMUM_ASYNCHRONOUS_TQS_PER_QUERY, oldMaximumAsynchronousTQsPerQuery, maximumAsynchronousTQsPerQuery));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getMaximumJavaInterpreterHeapSize() {
		return maximumJavaInterpreterHeapSize;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setMaximumJavaInterpreterHeapSize(String newMaximumJavaInterpreterHeapSize) {
		String oldMaximumJavaInterpreterHeapSize = maximumJavaInterpreterHeapSize;
		maximumJavaInterpreterHeapSize = newMaximumJavaInterpreterHeapSize;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, Db2highPackage.DB2_MANAGER__MAXIMUM_JAVA_INTERPRETER_HEAP_SIZE, oldMaximumJavaInterpreterHeapSize, maximumJavaInterpreterHeapSize));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getMaximumNumberOfAgents() {
		return maximumNumberOfAgents;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setMaximumNumberOfAgents(String newMaximumNumberOfAgents) {
		String oldMaximumNumberOfAgents = maximumNumberOfAgents;
		maximumNumberOfAgents = newMaximumNumberOfAgents;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, Db2highPackage.DB2_MANAGER__MAXIMUM_NUMBER_OF_AGENTS, oldMaximumNumberOfAgents, maximumNumberOfAgents));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getMaximumNumberOfClientConnections() {
		return maximumNumberOfClientConnections;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setMaximumNumberOfClientConnections(String newMaximumNumberOfClientConnections) {
		String oldMaximumNumberOfClientConnections = maximumNumberOfClientConnections;
		maximumNumberOfClientConnections = newMaximumNumberOfClientConnections;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, Db2highPackage.DB2_MANAGER__MAXIMUM_NUMBER_OF_CLIENT_CONNECTIONS, oldMaximumNumberOfClientConnections, maximumNumberOfClientConnections));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getMaximumNumberOfConcurrentAgents() {
		return maximumNumberOfConcurrentAgents;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setMaximumNumberOfConcurrentAgents(String newMaximumNumberOfConcurrentAgents) {
		String oldMaximumNumberOfConcurrentAgents = maximumNumberOfConcurrentAgents;
		maximumNumberOfConcurrentAgents = newMaximumNumberOfConcurrentAgents;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, Db2highPackage.DB2_MANAGER__MAXIMUM_NUMBER_OF_CONCURRENT_AGENTS, oldMaximumNumberOfConcurrentAgents, maximumNumberOfConcurrentAgents));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getMaximumNumberOfConcurrentlyActiveDatabases() {
		return maximumNumberOfConcurrentlyActiveDatabases;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setMaximumNumberOfConcurrentlyActiveDatabases(String newMaximumNumberOfConcurrentlyActiveDatabases) {
		String oldMaximumNumberOfConcurrentlyActiveDatabases = maximumNumberOfConcurrentlyActiveDatabases;
		maximumNumberOfConcurrentlyActiveDatabases = newMaximumNumberOfConcurrentlyActiveDatabases;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, Db2highPackage.DB2_MANAGER__MAXIMUM_NUMBER_OF_CONCURRENTLY_ACTIVE_DATABASES, oldMaximumNumberOfConcurrentlyActiveDatabases, maximumNumberOfConcurrentlyActiveDatabases));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getMaximumNumberOfCoordinatingAgents() {
		return maximumNumberOfCoordinatingAgents;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setMaximumNumberOfCoordinatingAgents(String newMaximumNumberOfCoordinatingAgents) {
		String oldMaximumNumberOfCoordinatingAgents = maximumNumberOfCoordinatingAgents;
		maximumNumberOfCoordinatingAgents = newMaximumNumberOfCoordinatingAgents;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, Db2highPackage.DB2_MANAGER__MAXIMUM_NUMBER_OF_COORDINATING_AGENTS, oldMaximumNumberOfCoordinatingAgents, maximumNumberOfCoordinatingAgents));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getMaximumNumberOfFencedProcesses() {
		return maximumNumberOfFencedProcesses;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setMaximumNumberOfFencedProcesses(String newMaximumNumberOfFencedProcesses) {
		String oldMaximumNumberOfFencedProcesses = maximumNumberOfFencedProcesses;
		maximumNumberOfFencedProcesses = newMaximumNumberOfFencedProcesses;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, Db2highPackage.DB2_MANAGER__MAXIMUM_NUMBER_OF_FENCED_PROCESSES, oldMaximumNumberOfFencedProcesses, maximumNumberOfFencedProcesses));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getMaximumQueryDegreeOfParallelism() {
		return maximumQueryDegreeOfParallelism;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setMaximumQueryDegreeOfParallelism(String newMaximumQueryDegreeOfParallelism) {
		String oldMaximumQueryDegreeOfParallelism = maximumQueryDegreeOfParallelism;
		maximumQueryDegreeOfParallelism = newMaximumQueryDegreeOfParallelism;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, Db2highPackage.DB2_MANAGER__MAXIMUM_QUERY_DEGREE_OF_PARALLELISM, oldMaximumQueryDegreeOfParallelism, maximumQueryDegreeOfParallelism));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getMaximumTimeDifferenceAmongNodes() {
		return maximumTimeDifferenceAmongNodes;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setMaximumTimeDifferenceAmongNodes(String newMaximumTimeDifferenceAmongNodes) {
		String oldMaximumTimeDifferenceAmongNodes = maximumTimeDifferenceAmongNodes;
		maximumTimeDifferenceAmongNodes = newMaximumTimeDifferenceAmongNodes;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, Db2highPackage.DB2_MANAGER__MAXIMUM_TIME_DIFFERENCE_AMONG_NODES, oldMaximumTimeDifferenceAmongNodes, maximumTimeDifferenceAmongNodes));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getNodeConnectionRetries() {
		return nodeConnectionRetries;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setNodeConnectionRetries(String newNodeConnectionRetries) {
		String oldNodeConnectionRetries = nodeConnectionRetries;
		nodeConnectionRetries = newNodeConnectionRetries;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, Db2highPackage.DB2_MANAGER__NODE_CONNECTION_RETRIES, oldNodeConnectionRetries, nodeConnectionRetries));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getNotifyLevel() {
		return notifyLevel;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setNotifyLevel(String newNotifyLevel) {
		String oldNotifyLevel = notifyLevel;
		notifyLevel = newNotifyLevel;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, Db2highPackage.DB2_MANAGER__NOTIFY_LEVEL, oldNotifyLevel, notifyLevel));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getNumberOfFCMBuffers() {
		return numberOfFCMBuffers;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setNumberOfFCMBuffers(String newNumberOfFCMBuffers) {
		String oldNumberOfFCMBuffers = numberOfFCMBuffers;
		numberOfFCMBuffers = newNumberOfFCMBuffers;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, Db2highPackage.DB2_MANAGER__NUMBER_OF_FCM_BUFFERS, oldNumberOfFCMBuffers, numberOfFCMBuffers));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getNumberOfFCMChannels() {
		return numberOfFCMChannels;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setNumberOfFCMChannels(String newNumberOfFCMChannels) {
		String oldNumberOfFCMChannels = numberOfFCMChannels;
		numberOfFCMChannels = newNumberOfFCMChannels;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, Db2highPackage.DB2_MANAGER__NUMBER_OF_FCM_CHANNELS, oldNumberOfFCMChannels, numberOfFCMChannels));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getQueryHeapSize() {
		return queryHeapSize;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setQueryHeapSize(String newQueryHeapSize) {
		String oldQueryHeapSize = queryHeapSize;
		queryHeapSize = newQueryHeapSize;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, Db2highPackage.DB2_MANAGER__QUERY_HEAP_SIZE, oldQueryHeapSize, queryHeapSize));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getServerPluginMode() {
		return serverPluginMode;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setServerPluginMode(String newServerPluginMode) {
		String oldServerPluginMode = serverPluginMode;
		serverPluginMode = newServerPluginMode;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, Db2highPackage.DB2_MANAGER__SERVER_PLUGIN_MODE, oldServerPluginMode, serverPluginMode));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getSoftwareDevelopersKitForJavaInstallationPath() {
		return softwareDevelopersKitForJavaInstallationPath;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setSoftwareDevelopersKitForJavaInstallationPath(String newSoftwareDevelopersKitForJavaInstallationPath) {
		String oldSoftwareDevelopersKitForJavaInstallationPath = softwareDevelopersKitForJavaInstallationPath;
		softwareDevelopersKitForJavaInstallationPath = newSoftwareDevelopersKitForJavaInstallationPath;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, Db2highPackage.DB2_MANAGER__SOFTWARE_DEVELOPERS_KIT_FOR_JAVA_INSTALLATION_PATH, oldSoftwareDevelopersKitForJavaInstallationPath, softwareDevelopersKitForJavaInstallationPath));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getSortHeapThreshold() {
		return sortHeapThreshold;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setSortHeapThreshold(String newSortHeapThreshold) {
		String oldSortHeapThreshold = sortHeapThreshold;
		sortHeapThreshold = newSortHeapThreshold;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, Db2highPackage.DB2_MANAGER__SORT_HEAP_THRESHOLD, oldSortHeapThreshold, sortHeapThreshold));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getStartAndStopTimeout() {
		return startAndStopTimeout;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setStartAndStopTimeout(String newStartAndStopTimeout) {
		String oldStartAndStopTimeout = startAndStopTimeout;
		startAndStopTimeout = newStartAndStopTimeout;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, Db2highPackage.DB2_MANAGER__START_AND_STOP_TIMEOUT, oldStartAndStopTimeout, startAndStopTimeout));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getSyncPointManagerLogFilePath() {
		return syncPointManagerLogFilePath;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setSyncPointManagerLogFilePath(String newSyncPointManagerLogFilePath) {
		String oldSyncPointManagerLogFilePath = syncPointManagerLogFilePath;
		syncPointManagerLogFilePath = newSyncPointManagerLogFilePath;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, Db2highPackage.DB2_MANAGER__SYNC_POINT_MANAGER_LOG_FILE_PATH, oldSyncPointManagerLogFilePath, syncPointManagerLogFilePath));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getSyncPointManagerLogFileSize() {
		return syncPointManagerLogFileSize;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setSyncPointManagerLogFileSize(String newSyncPointManagerLogFileSize) {
		String oldSyncPointManagerLogFileSize = syncPointManagerLogFileSize;
		syncPointManagerLogFileSize = newSyncPointManagerLogFileSize;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, Db2highPackage.DB2_MANAGER__SYNC_POINT_MANAGER_LOG_FILE_SIZE, oldSyncPointManagerLogFileSize, syncPointManagerLogFileSize));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getSyncPointManagerName() {
		return syncPointManagerName;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setSyncPointManagerName(String newSyncPointManagerName) {
		String oldSyncPointManagerName = syncPointManagerName;
		syncPointManagerName = newSyncPointManagerName;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, Db2highPackage.DB2_MANAGER__SYNC_POINT_MANAGER_NAME, oldSyncPointManagerName, syncPointManagerName));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getSyncPointManagerResyncAgentLimit() {
		return syncPointManagerResyncAgentLimit;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setSyncPointManagerResyncAgentLimit(String newSyncPointManagerResyncAgentLimit) {
		String oldSyncPointManagerResyncAgentLimit = syncPointManagerResyncAgentLimit;
		syncPointManagerResyncAgentLimit = newSyncPointManagerResyncAgentLimit;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, Db2highPackage.DB2_MANAGER__SYNC_POINT_MANAGER_RESYNC_AGENT_LIMIT, oldSyncPointManagerResyncAgentLimit, syncPointManagerResyncAgentLimit));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getSystemAdministrationAuthorityGroupName() {
		return systemAdministrationAuthorityGroupName;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setSystemAdministrationAuthorityGroupName(String newSystemAdministrationAuthorityGroupName) {
		String oldSystemAdministrationAuthorityGroupName = systemAdministrationAuthorityGroupName;
		systemAdministrationAuthorityGroupName = newSystemAdministrationAuthorityGroupName;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, Db2highPackage.DB2_MANAGER__SYSTEM_ADMINISTRATION_AUTHORITY_GROUP_NAME, oldSystemAdministrationAuthorityGroupName, systemAdministrationAuthorityGroupName));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getSystemControlAuthorityGroupName() {
		return systemControlAuthorityGroupName;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setSystemControlAuthorityGroupName(String newSystemControlAuthorityGroupName) {
		String oldSystemControlAuthorityGroupName = systemControlAuthorityGroupName;
		systemControlAuthorityGroupName = newSystemControlAuthorityGroupName;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, Db2highPackage.DB2_MANAGER__SYSTEM_CONTROL_AUTHORITY_GROUP_NAME, oldSystemControlAuthorityGroupName, systemControlAuthorityGroupName));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getSystemMaintenanceAuthorityGroupName() {
		return systemMaintenanceAuthorityGroupName;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setSystemMaintenanceAuthorityGroupName(String newSystemMaintenanceAuthorityGroupName) {
		String oldSystemMaintenanceAuthorityGroupName = systemMaintenanceAuthorityGroupName;
		systemMaintenanceAuthorityGroupName = newSystemMaintenanceAuthorityGroupName;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, Db2highPackage.DB2_MANAGER__SYSTEM_MAINTENANCE_AUTHORITY_GROUP_NAME, oldSystemMaintenanceAuthorityGroupName, systemMaintenanceAuthorityGroupName));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getSystemMonitorAuthorityGroupName() {
		return systemMonitorAuthorityGroupName;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setSystemMonitorAuthorityGroupName(String newSystemMonitorAuthorityGroupName) {
		String oldSystemMonitorAuthorityGroupName = systemMonitorAuthorityGroupName;
		systemMonitorAuthorityGroupName = newSystemMonitorAuthorityGroupName;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, Db2highPackage.DB2_MANAGER__SYSTEM_MONITOR_AUTHORITY_GROUP_NAME, oldSystemMonitorAuthorityGroupName, systemMonitorAuthorityGroupName));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getTCPIPServiceName() {
		return tCPIPServiceName;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setTCPIPServiceName(String newTCPIPServiceName) {
		String oldTCPIPServiceName = tCPIPServiceName;
		tCPIPServiceName = newTCPIPServiceName;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, Db2highPackage.DB2_MANAGER__TCPIP_SERVICE_NAME, oldTCPIPServiceName, tCPIPServiceName));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getTransactionManagerDatabaseName() {
		return transactionManagerDatabaseName;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setTransactionManagerDatabaseName(String newTransactionManagerDatabaseName) {
		String oldTransactionManagerDatabaseName = transactionManagerDatabaseName;
		transactionManagerDatabaseName = newTransactionManagerDatabaseName;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, Db2highPackage.DB2_MANAGER__TRANSACTION_MANAGER_DATABASE_NAME, oldTransactionManagerDatabaseName, transactionManagerDatabaseName));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getTransactionProcessorMonitorName() {
		return transactionProcessorMonitorName;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setTransactionProcessorMonitorName(String newTransactionProcessorMonitorName) {
		String oldTransactionProcessorMonitorName = transactionProcessorMonitorName;
		transactionProcessorMonitorName = newTransactionProcessorMonitorName;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, Db2highPackage.DB2_MANAGER__TRANSACTION_PROCESSOR_MONITOR_NAME, oldTransactionProcessorMonitorName, transactionProcessorMonitorName));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getTransactionResyncInterval() {
		return transactionResyncInterval;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setTransactionResyncInterval(String newTransactionResyncInterval) {
		String oldTransactionResyncInterval = transactionResyncInterval;
		transactionResyncInterval = newTransactionResyncInterval;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, Db2highPackage.DB2_MANAGER__TRANSACTION_RESYNC_INTERVAL, oldTransactionResyncInterval, transactionResyncInterval));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getTrustAllClients() {
		return trustAllClients;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setTrustAllClients(String newTrustAllClients) {
		String oldTrustAllClients = trustAllClients;
		trustAllClients = newTrustAllClients;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, Db2highPackage.DB2_MANAGER__TRUST_ALL_CLIENTS, oldTrustAllClients, trustAllClients));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getTrustedClientsAuthentication() {
		return trustedClientsAuthentication;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setTrustedClientsAuthentication(String newTrustedClientsAuthentication) {
		String oldTrustedClientsAuthentication = trustedClientsAuthentication;
		trustedClientsAuthentication = newTrustedClientsAuthentication;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, Db2highPackage.DB2_MANAGER__TRUSTED_CLIENTS_AUTHENTICATION, oldTrustedClientsAuthentication, trustedClientsAuthentication));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getUseridPasswordPlugIn() {
		return useridPasswordPlugIn;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setUseridPasswordPlugIn(String newUseridPasswordPlugIn) {
		String oldUseridPasswordPlugIn = useridPasswordPlugIn;
		useridPasswordPlugIn = newUseridPasswordPlugIn;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, Db2highPackage.DB2_MANAGER__USERID_PASSWORD_PLUG_IN, oldUseridPasswordPlugIn, useridPasswordPlugIn));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case Db2highPackage.DB2_MANAGER__AGENT_POOL_SIZE:
				return getAgentPoolSize();
			case Db2highPackage.DB2_MANAGER__AGENT_PRIORITY:
				return getAgentPriority();
			case Db2highPackage.DB2_MANAGER__AGENT_STACK_SIZE:
				return getAgentStackSize();
			case Db2highPackage.DB2_MANAGER__APPLICATION_SUPPORT_LAYER_HEAP_SIZE:
				return getApplicationSupportLayerHeapSize();
			case Db2highPackage.DB2_MANAGER__AUDIT_BUFFER_SIZE:
				return getAuditBufferSize();
			case Db2highPackage.DB2_MANAGER__AUTHENTICATION_TYPE:
				return getAuthenticationType();
			case Db2highPackage.DB2_MANAGER__AUTHENTICATION_TYPE_FOR_INCOMING_CONNECTIONS:
				return getAuthenticationTypeForIncomingConnections();
			case Db2highPackage.DB2_MANAGER__BYPASS_FEDERATED_AUTHENTICATION:
				return getBypassFederatedAuthentication();
			case Db2highPackage.DB2_MANAGER__CATALOGING_ALLOWED_WITHOUT_AUTHORITY:
				return getCatalogingAllowedWithoutAuthority();
			case Db2highPackage.DB2_MANAGER__CLIENT_IO_BLOCK_SIZE:
				return getClientIOBlockSize();
			case Db2highPackage.DB2_MANAGER__CLIENT_KERBEROS_PLUGIN:
				return getClientKerberosPlugin();
			case Db2highPackage.DB2_MANAGER__CLIENT_USERID_PASSWORD_PLUGIN:
				return getClientUseridPasswordPlugin();
			case Db2highPackage.DB2_MANAGER__COMMUNICATIONS_BANDWIDTH:
				return getCommunicationsBandwidth();
			case Db2highPackage.DB2_MANAGER__CONFIGURATION_FILE_RELEASE_LEVEL:
				return getConfigurationFileReleaseLevel();
			case Db2highPackage.DB2_MANAGER__CONNECTION_ELAPSE_TIME:
				return getConnectionElapseTime();
			case Db2highPackage.DB2_MANAGER__CPU_SPEED:
				return getCPUSpeed();
			case Db2highPackage.DB2_MANAGER__DATABASE_SYSTEM_MONITOR_HEAP_SIZE:
				return getDatabaseSystemMonitorHeapSize();
			case Db2highPackage.DB2_MANAGER__DEFAULT_CHARGE_BACK_ACCOUNT:
				return getDefaultChargeBackAccount();
			case Db2highPackage.DB2_MANAGER__DEFAULT_DATABASE_PATH:
				return getDefaultDatabasePath();
			case Db2highPackage.DB2_MANAGER__DEFAULT_DATABASE_SYSTEM_MONITOR_SWITCHES:
				return getDefaultDatabaseSystemMonitorSwitches();
			case Db2highPackage.DB2_MANAGER__DIAGNOSTIC_DATA_DIRECTORY_PATH:
				return getDiagnosticDataDirectoryPath();
			case Db2highPackage.DB2_MANAGER__DIAGNOSTIC_ERROR_CAPTURE_LEVEL:
				return getDiagnosticErrorCaptureLevel();
			case Db2highPackage.DB2_MANAGER__DIRECTORY_CACHE_SUPPORT:
				return getDirectoryCacheSupport();
			case Db2highPackage.DB2_MANAGER__DISCOVER_SERVER_INSTANCE:
				return getDiscoverServerInstance();
			case Db2highPackage.DB2_MANAGER__DISCOVERY_MODE:
				return getDiscoveryMode();
			case Db2highPackage.DB2_MANAGER__ENABLE_PNTRAPARTITION_PARALLELISM:
				return getEnablePntrapartitionParallelism();
			case Db2highPackage.DB2_MANAGER__FEDERATED_DATABASE_SYSTEM_SUPPORT:
				return getFederatedDatabaseSystemSupport();
			case Db2highPackage.DB2_MANAGER__GROUP_PLUGIN:
				return getGroupPlugin();
			case Db2highPackage.DB2_MANAGER__HEALTH_MONITORING:
				return getHealthMonitoring();
			case Db2highPackage.DB2_MANAGER__INDEX_RECREATION_TIME:
				return getIndexRecreationTime();
			case Db2highPackage.DB2_MANAGER__INITIAL_NUMBER_OF_AGENTS_IN_POOL:
				return getInitialNumberOfAgentsInPool();
			case Db2highPackage.DB2_MANAGER__INITIAL_NUMBER_OF_FENCED_PROCESSES:
				return getInitialNumberOfFencedProcesses();
			case Db2highPackage.DB2_MANAGER__INSTANCE_IMPACT_POLICY:
				return getInstanceImpactPolicy();
			case Db2highPackage.DB2_MANAGER__INSTANCE_MEMORY:
				return getInstanceMemory();
			case Db2highPackage.DB2_MANAGER__KEEP_FENCED_PROCESS:
				return getKeepFencedProcess();
			case Db2highPackage.DB2_MANAGER__LIST_OF_GSSAPI_PLUGINS_FOR_INCOMING_CONNECTIONS:
				return getListOfGSSAPIPluginsForIncomingConnections();
			case Db2highPackage.DB2_MANAGER__LOCAL_GSSAPI_PLUGIN:
				return getLocalGSSAPIPlugin();
			case Db2highPackage.DB2_MANAGER__MACHINE_NODE_TYPE:
				return getMachineNodeType();
			case Db2highPackage.DB2_MANAGER__MAXIMUM_ASYNCHRONOUS_TQS_PER_QUERY:
				return getMaximumAsynchronousTQsPerQuery();
			case Db2highPackage.DB2_MANAGER__MAXIMUM_JAVA_INTERPRETER_HEAP_SIZE:
				return getMaximumJavaInterpreterHeapSize();
			case Db2highPackage.DB2_MANAGER__MAXIMUM_NUMBER_OF_AGENTS:
				return getMaximumNumberOfAgents();
			case Db2highPackage.DB2_MANAGER__MAXIMUM_NUMBER_OF_CLIENT_CONNECTIONS:
				return getMaximumNumberOfClientConnections();
			case Db2highPackage.DB2_MANAGER__MAXIMUM_NUMBER_OF_CONCURRENT_AGENTS:
				return getMaximumNumberOfConcurrentAgents();
			case Db2highPackage.DB2_MANAGER__MAXIMUM_NUMBER_OF_CONCURRENTLY_ACTIVE_DATABASES:
				return getMaximumNumberOfConcurrentlyActiveDatabases();
			case Db2highPackage.DB2_MANAGER__MAXIMUM_NUMBER_OF_COORDINATING_AGENTS:
				return getMaximumNumberOfCoordinatingAgents();
			case Db2highPackage.DB2_MANAGER__MAXIMUM_NUMBER_OF_FENCED_PROCESSES:
				return getMaximumNumberOfFencedProcesses();
			case Db2highPackage.DB2_MANAGER__MAXIMUM_QUERY_DEGREE_OF_PARALLELISM:
				return getMaximumQueryDegreeOfParallelism();
			case Db2highPackage.DB2_MANAGER__MAXIMUM_TIME_DIFFERENCE_AMONG_NODES:
				return getMaximumTimeDifferenceAmongNodes();
			case Db2highPackage.DB2_MANAGER__NODE_CONNECTION_RETRIES:
				return getNodeConnectionRetries();
			case Db2highPackage.DB2_MANAGER__NOTIFY_LEVEL:
				return getNotifyLevel();
			case Db2highPackage.DB2_MANAGER__NUMBER_OF_FCM_BUFFERS:
				return getNumberOfFCMBuffers();
			case Db2highPackage.DB2_MANAGER__NUMBER_OF_FCM_CHANNELS:
				return getNumberOfFCMChannels();
			case Db2highPackage.DB2_MANAGER__QUERY_HEAP_SIZE:
				return getQueryHeapSize();
			case Db2highPackage.DB2_MANAGER__SERVER_PLUGIN_MODE:
				return getServerPluginMode();
			case Db2highPackage.DB2_MANAGER__SOFTWARE_DEVELOPERS_KIT_FOR_JAVA_INSTALLATION_PATH:
				return getSoftwareDevelopersKitForJavaInstallationPath();
			case Db2highPackage.DB2_MANAGER__SORT_HEAP_THRESHOLD:
				return getSortHeapThreshold();
			case Db2highPackage.DB2_MANAGER__START_AND_STOP_TIMEOUT:
				return getStartAndStopTimeout();
			case Db2highPackage.DB2_MANAGER__SYNC_POINT_MANAGER_LOG_FILE_PATH:
				return getSyncPointManagerLogFilePath();
			case Db2highPackage.DB2_MANAGER__SYNC_POINT_MANAGER_LOG_FILE_SIZE:
				return getSyncPointManagerLogFileSize();
			case Db2highPackage.DB2_MANAGER__SYNC_POINT_MANAGER_NAME:
				return getSyncPointManagerName();
			case Db2highPackage.DB2_MANAGER__SYNC_POINT_MANAGER_RESYNC_AGENT_LIMIT:
				return getSyncPointManagerResyncAgentLimit();
			case Db2highPackage.DB2_MANAGER__SYSTEM_ADMINISTRATION_AUTHORITY_GROUP_NAME:
				return getSystemAdministrationAuthorityGroupName();
			case Db2highPackage.DB2_MANAGER__SYSTEM_CONTROL_AUTHORITY_GROUP_NAME:
				return getSystemControlAuthorityGroupName();
			case Db2highPackage.DB2_MANAGER__SYSTEM_MAINTENANCE_AUTHORITY_GROUP_NAME:
				return getSystemMaintenanceAuthorityGroupName();
			case Db2highPackage.DB2_MANAGER__SYSTEM_MONITOR_AUTHORITY_GROUP_NAME:
				return getSystemMonitorAuthorityGroupName();
			case Db2highPackage.DB2_MANAGER__TCPIP_SERVICE_NAME:
				return getTCPIPServiceName();
			case Db2highPackage.DB2_MANAGER__TRANSACTION_MANAGER_DATABASE_NAME:
				return getTransactionManagerDatabaseName();
			case Db2highPackage.DB2_MANAGER__TRANSACTION_PROCESSOR_MONITOR_NAME:
				return getTransactionProcessorMonitorName();
			case Db2highPackage.DB2_MANAGER__TRANSACTION_RESYNC_INTERVAL:
				return getTransactionResyncInterval();
			case Db2highPackage.DB2_MANAGER__TRUST_ALL_CLIENTS:
				return getTrustAllClients();
			case Db2highPackage.DB2_MANAGER__TRUSTED_CLIENTS_AUTHENTICATION:
				return getTrustedClientsAuthentication();
			case Db2highPackage.DB2_MANAGER__USERID_PASSWORD_PLUG_IN:
				return getUseridPasswordPlugIn();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
			case Db2highPackage.DB2_MANAGER__AGENT_POOL_SIZE:
				setAgentPoolSize((String)newValue);
				return;
			case Db2highPackage.DB2_MANAGER__AGENT_PRIORITY:
				setAgentPriority((String)newValue);
				return;
			case Db2highPackage.DB2_MANAGER__AGENT_STACK_SIZE:
				setAgentStackSize((String)newValue);
				return;
			case Db2highPackage.DB2_MANAGER__APPLICATION_SUPPORT_LAYER_HEAP_SIZE:
				setApplicationSupportLayerHeapSize((String)newValue);
				return;
			case Db2highPackage.DB2_MANAGER__AUDIT_BUFFER_SIZE:
				setAuditBufferSize((String)newValue);
				return;
			case Db2highPackage.DB2_MANAGER__AUTHENTICATION_TYPE:
				setAuthenticationType((String)newValue);
				return;
			case Db2highPackage.DB2_MANAGER__AUTHENTICATION_TYPE_FOR_INCOMING_CONNECTIONS:
				setAuthenticationTypeForIncomingConnections((String)newValue);
				return;
			case Db2highPackage.DB2_MANAGER__BYPASS_FEDERATED_AUTHENTICATION:
				setBypassFederatedAuthentication((String)newValue);
				return;
			case Db2highPackage.DB2_MANAGER__CATALOGING_ALLOWED_WITHOUT_AUTHORITY:
				setCatalogingAllowedWithoutAuthority((String)newValue);
				return;
			case Db2highPackage.DB2_MANAGER__CLIENT_IO_BLOCK_SIZE:
				setClientIOBlockSize((String)newValue);
				return;
			case Db2highPackage.DB2_MANAGER__CLIENT_KERBEROS_PLUGIN:
				setClientKerberosPlugin((String)newValue);
				return;
			case Db2highPackage.DB2_MANAGER__CLIENT_USERID_PASSWORD_PLUGIN:
				setClientUseridPasswordPlugin((String)newValue);
				return;
			case Db2highPackage.DB2_MANAGER__COMMUNICATIONS_BANDWIDTH:
				setCommunicationsBandwidth((String)newValue);
				return;
			case Db2highPackage.DB2_MANAGER__CONFIGURATION_FILE_RELEASE_LEVEL:
				setConfigurationFileReleaseLevel((String)newValue);
				return;
			case Db2highPackage.DB2_MANAGER__CONNECTION_ELAPSE_TIME:
				setConnectionElapseTime((String)newValue);
				return;
			case Db2highPackage.DB2_MANAGER__CPU_SPEED:
				setCPUSpeed((String)newValue);
				return;
			case Db2highPackage.DB2_MANAGER__DATABASE_SYSTEM_MONITOR_HEAP_SIZE:
				setDatabaseSystemMonitorHeapSize((String)newValue);
				return;
			case Db2highPackage.DB2_MANAGER__DEFAULT_CHARGE_BACK_ACCOUNT:
				setDefaultChargeBackAccount((String)newValue);
				return;
			case Db2highPackage.DB2_MANAGER__DEFAULT_DATABASE_PATH:
				setDefaultDatabasePath((String)newValue);
				return;
			case Db2highPackage.DB2_MANAGER__DEFAULT_DATABASE_SYSTEM_MONITOR_SWITCHES:
				setDefaultDatabaseSystemMonitorSwitches((String)newValue);
				return;
			case Db2highPackage.DB2_MANAGER__DIAGNOSTIC_DATA_DIRECTORY_PATH:
				setDiagnosticDataDirectoryPath((String)newValue);
				return;
			case Db2highPackage.DB2_MANAGER__DIAGNOSTIC_ERROR_CAPTURE_LEVEL:
				setDiagnosticErrorCaptureLevel((String)newValue);
				return;
			case Db2highPackage.DB2_MANAGER__DIRECTORY_CACHE_SUPPORT:
				setDirectoryCacheSupport((String)newValue);
				return;
			case Db2highPackage.DB2_MANAGER__DISCOVER_SERVER_INSTANCE:
				setDiscoverServerInstance((String)newValue);
				return;
			case Db2highPackage.DB2_MANAGER__DISCOVERY_MODE:
				setDiscoveryMode((String)newValue);
				return;
			case Db2highPackage.DB2_MANAGER__ENABLE_PNTRAPARTITION_PARALLELISM:
				setEnablePntrapartitionParallelism((String)newValue);
				return;
			case Db2highPackage.DB2_MANAGER__FEDERATED_DATABASE_SYSTEM_SUPPORT:
				setFederatedDatabaseSystemSupport((String)newValue);
				return;
			case Db2highPackage.DB2_MANAGER__GROUP_PLUGIN:
				setGroupPlugin((String)newValue);
				return;
			case Db2highPackage.DB2_MANAGER__HEALTH_MONITORING:
				setHealthMonitoring((String)newValue);
				return;
			case Db2highPackage.DB2_MANAGER__INDEX_RECREATION_TIME:
				setIndexRecreationTime((String)newValue);
				return;
			case Db2highPackage.DB2_MANAGER__INITIAL_NUMBER_OF_AGENTS_IN_POOL:
				setInitialNumberOfAgentsInPool((String)newValue);
				return;
			case Db2highPackage.DB2_MANAGER__INITIAL_NUMBER_OF_FENCED_PROCESSES:
				setInitialNumberOfFencedProcesses((String)newValue);
				return;
			case Db2highPackage.DB2_MANAGER__INSTANCE_IMPACT_POLICY:
				setInstanceImpactPolicy((String)newValue);
				return;
			case Db2highPackage.DB2_MANAGER__INSTANCE_MEMORY:
				setInstanceMemory((String)newValue);
				return;
			case Db2highPackage.DB2_MANAGER__KEEP_FENCED_PROCESS:
				setKeepFencedProcess((String)newValue);
				return;
			case Db2highPackage.DB2_MANAGER__LIST_OF_GSSAPI_PLUGINS_FOR_INCOMING_CONNECTIONS:
				setListOfGSSAPIPluginsForIncomingConnections((String)newValue);
				return;
			case Db2highPackage.DB2_MANAGER__LOCAL_GSSAPI_PLUGIN:
				setLocalGSSAPIPlugin((String)newValue);
				return;
			case Db2highPackage.DB2_MANAGER__MACHINE_NODE_TYPE:
				setMachineNodeType((String)newValue);
				return;
			case Db2highPackage.DB2_MANAGER__MAXIMUM_ASYNCHRONOUS_TQS_PER_QUERY:
				setMaximumAsynchronousTQsPerQuery((String)newValue);
				return;
			case Db2highPackage.DB2_MANAGER__MAXIMUM_JAVA_INTERPRETER_HEAP_SIZE:
				setMaximumJavaInterpreterHeapSize((String)newValue);
				return;
			case Db2highPackage.DB2_MANAGER__MAXIMUM_NUMBER_OF_AGENTS:
				setMaximumNumberOfAgents((String)newValue);
				return;
			case Db2highPackage.DB2_MANAGER__MAXIMUM_NUMBER_OF_CLIENT_CONNECTIONS:
				setMaximumNumberOfClientConnections((String)newValue);
				return;
			case Db2highPackage.DB2_MANAGER__MAXIMUM_NUMBER_OF_CONCURRENT_AGENTS:
				setMaximumNumberOfConcurrentAgents((String)newValue);
				return;
			case Db2highPackage.DB2_MANAGER__MAXIMUM_NUMBER_OF_CONCURRENTLY_ACTIVE_DATABASES:
				setMaximumNumberOfConcurrentlyActiveDatabases((String)newValue);
				return;
			case Db2highPackage.DB2_MANAGER__MAXIMUM_NUMBER_OF_COORDINATING_AGENTS:
				setMaximumNumberOfCoordinatingAgents((String)newValue);
				return;
			case Db2highPackage.DB2_MANAGER__MAXIMUM_NUMBER_OF_FENCED_PROCESSES:
				setMaximumNumberOfFencedProcesses((String)newValue);
				return;
			case Db2highPackage.DB2_MANAGER__MAXIMUM_QUERY_DEGREE_OF_PARALLELISM:
				setMaximumQueryDegreeOfParallelism((String)newValue);
				return;
			case Db2highPackage.DB2_MANAGER__MAXIMUM_TIME_DIFFERENCE_AMONG_NODES:
				setMaximumTimeDifferenceAmongNodes((String)newValue);
				return;
			case Db2highPackage.DB2_MANAGER__NODE_CONNECTION_RETRIES:
				setNodeConnectionRetries((String)newValue);
				return;
			case Db2highPackage.DB2_MANAGER__NOTIFY_LEVEL:
				setNotifyLevel((String)newValue);
				return;
			case Db2highPackage.DB2_MANAGER__NUMBER_OF_FCM_BUFFERS:
				setNumberOfFCMBuffers((String)newValue);
				return;
			case Db2highPackage.DB2_MANAGER__NUMBER_OF_FCM_CHANNELS:
				setNumberOfFCMChannels((String)newValue);
				return;
			case Db2highPackage.DB2_MANAGER__QUERY_HEAP_SIZE:
				setQueryHeapSize((String)newValue);
				return;
			case Db2highPackage.DB2_MANAGER__SERVER_PLUGIN_MODE:
				setServerPluginMode((String)newValue);
				return;
			case Db2highPackage.DB2_MANAGER__SOFTWARE_DEVELOPERS_KIT_FOR_JAVA_INSTALLATION_PATH:
				setSoftwareDevelopersKitForJavaInstallationPath((String)newValue);
				return;
			case Db2highPackage.DB2_MANAGER__SORT_HEAP_THRESHOLD:
				setSortHeapThreshold((String)newValue);
				return;
			case Db2highPackage.DB2_MANAGER__START_AND_STOP_TIMEOUT:
				setStartAndStopTimeout((String)newValue);
				return;
			case Db2highPackage.DB2_MANAGER__SYNC_POINT_MANAGER_LOG_FILE_PATH:
				setSyncPointManagerLogFilePath((String)newValue);
				return;
			case Db2highPackage.DB2_MANAGER__SYNC_POINT_MANAGER_LOG_FILE_SIZE:
				setSyncPointManagerLogFileSize((String)newValue);
				return;
			case Db2highPackage.DB2_MANAGER__SYNC_POINT_MANAGER_NAME:
				setSyncPointManagerName((String)newValue);
				return;
			case Db2highPackage.DB2_MANAGER__SYNC_POINT_MANAGER_RESYNC_AGENT_LIMIT:
				setSyncPointManagerResyncAgentLimit((String)newValue);
				return;
			case Db2highPackage.DB2_MANAGER__SYSTEM_ADMINISTRATION_AUTHORITY_GROUP_NAME:
				setSystemAdministrationAuthorityGroupName((String)newValue);
				return;
			case Db2highPackage.DB2_MANAGER__SYSTEM_CONTROL_AUTHORITY_GROUP_NAME:
				setSystemControlAuthorityGroupName((String)newValue);
				return;
			case Db2highPackage.DB2_MANAGER__SYSTEM_MAINTENANCE_AUTHORITY_GROUP_NAME:
				setSystemMaintenanceAuthorityGroupName((String)newValue);
				return;
			case Db2highPackage.DB2_MANAGER__SYSTEM_MONITOR_AUTHORITY_GROUP_NAME:
				setSystemMonitorAuthorityGroupName((String)newValue);
				return;
			case Db2highPackage.DB2_MANAGER__TCPIP_SERVICE_NAME:
				setTCPIPServiceName((String)newValue);
				return;
			case Db2highPackage.DB2_MANAGER__TRANSACTION_MANAGER_DATABASE_NAME:
				setTransactionManagerDatabaseName((String)newValue);
				return;
			case Db2highPackage.DB2_MANAGER__TRANSACTION_PROCESSOR_MONITOR_NAME:
				setTransactionProcessorMonitorName((String)newValue);
				return;
			case Db2highPackage.DB2_MANAGER__TRANSACTION_RESYNC_INTERVAL:
				setTransactionResyncInterval((String)newValue);
				return;
			case Db2highPackage.DB2_MANAGER__TRUST_ALL_CLIENTS:
				setTrustAllClients((String)newValue);
				return;
			case Db2highPackage.DB2_MANAGER__TRUSTED_CLIENTS_AUTHENTICATION:
				setTrustedClientsAuthentication((String)newValue);
				return;
			case Db2highPackage.DB2_MANAGER__USERID_PASSWORD_PLUG_IN:
				setUseridPasswordPlugIn((String)newValue);
				return;
		}
		super.eSet(featureID, newValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void eUnset(int featureID) {
		switch (featureID) {
			case Db2highPackage.DB2_MANAGER__AGENT_POOL_SIZE:
				setAgentPoolSize(AGENT_POOL_SIZE_EDEFAULT);
				return;
			case Db2highPackage.DB2_MANAGER__AGENT_PRIORITY:
				setAgentPriority(AGENT_PRIORITY_EDEFAULT);
				return;
			case Db2highPackage.DB2_MANAGER__AGENT_STACK_SIZE:
				setAgentStackSize(AGENT_STACK_SIZE_EDEFAULT);
				return;
			case Db2highPackage.DB2_MANAGER__APPLICATION_SUPPORT_LAYER_HEAP_SIZE:
				setApplicationSupportLayerHeapSize(APPLICATION_SUPPORT_LAYER_HEAP_SIZE_EDEFAULT);
				return;
			case Db2highPackage.DB2_MANAGER__AUDIT_BUFFER_SIZE:
				setAuditBufferSize(AUDIT_BUFFER_SIZE_EDEFAULT);
				return;
			case Db2highPackage.DB2_MANAGER__AUTHENTICATION_TYPE:
				setAuthenticationType(AUTHENTICATION_TYPE_EDEFAULT);
				return;
			case Db2highPackage.DB2_MANAGER__AUTHENTICATION_TYPE_FOR_INCOMING_CONNECTIONS:
				setAuthenticationTypeForIncomingConnections(AUTHENTICATION_TYPE_FOR_INCOMING_CONNECTIONS_EDEFAULT);
				return;
			case Db2highPackage.DB2_MANAGER__BYPASS_FEDERATED_AUTHENTICATION:
				setBypassFederatedAuthentication(BYPASS_FEDERATED_AUTHENTICATION_EDEFAULT);
				return;
			case Db2highPackage.DB2_MANAGER__CATALOGING_ALLOWED_WITHOUT_AUTHORITY:
				setCatalogingAllowedWithoutAuthority(CATALOGING_ALLOWED_WITHOUT_AUTHORITY_EDEFAULT);
				return;
			case Db2highPackage.DB2_MANAGER__CLIENT_IO_BLOCK_SIZE:
				setClientIOBlockSize(CLIENT_IO_BLOCK_SIZE_EDEFAULT);
				return;
			case Db2highPackage.DB2_MANAGER__CLIENT_KERBEROS_PLUGIN:
				setClientKerberosPlugin(CLIENT_KERBEROS_PLUGIN_EDEFAULT);
				return;
			case Db2highPackage.DB2_MANAGER__CLIENT_USERID_PASSWORD_PLUGIN:
				setClientUseridPasswordPlugin(CLIENT_USERID_PASSWORD_PLUGIN_EDEFAULT);
				return;
			case Db2highPackage.DB2_MANAGER__COMMUNICATIONS_BANDWIDTH:
				setCommunicationsBandwidth(COMMUNICATIONS_BANDWIDTH_EDEFAULT);
				return;
			case Db2highPackage.DB2_MANAGER__CONFIGURATION_FILE_RELEASE_LEVEL:
				setConfigurationFileReleaseLevel(CONFIGURATION_FILE_RELEASE_LEVEL_EDEFAULT);
				return;
			case Db2highPackage.DB2_MANAGER__CONNECTION_ELAPSE_TIME:
				setConnectionElapseTime(CONNECTION_ELAPSE_TIME_EDEFAULT);
				return;
			case Db2highPackage.DB2_MANAGER__CPU_SPEED:
				setCPUSpeed(CPU_SPEED_EDEFAULT);
				return;
			case Db2highPackage.DB2_MANAGER__DATABASE_SYSTEM_MONITOR_HEAP_SIZE:
				setDatabaseSystemMonitorHeapSize(DATABASE_SYSTEM_MONITOR_HEAP_SIZE_EDEFAULT);
				return;
			case Db2highPackage.DB2_MANAGER__DEFAULT_CHARGE_BACK_ACCOUNT:
				setDefaultChargeBackAccount(DEFAULT_CHARGE_BACK_ACCOUNT_EDEFAULT);
				return;
			case Db2highPackage.DB2_MANAGER__DEFAULT_DATABASE_PATH:
				setDefaultDatabasePath(DEFAULT_DATABASE_PATH_EDEFAULT);
				return;
			case Db2highPackage.DB2_MANAGER__DEFAULT_DATABASE_SYSTEM_MONITOR_SWITCHES:
				setDefaultDatabaseSystemMonitorSwitches(DEFAULT_DATABASE_SYSTEM_MONITOR_SWITCHES_EDEFAULT);
				return;
			case Db2highPackage.DB2_MANAGER__DIAGNOSTIC_DATA_DIRECTORY_PATH:
				setDiagnosticDataDirectoryPath(DIAGNOSTIC_DATA_DIRECTORY_PATH_EDEFAULT);
				return;
			case Db2highPackage.DB2_MANAGER__DIAGNOSTIC_ERROR_CAPTURE_LEVEL:
				setDiagnosticErrorCaptureLevel(DIAGNOSTIC_ERROR_CAPTURE_LEVEL_EDEFAULT);
				return;
			case Db2highPackage.DB2_MANAGER__DIRECTORY_CACHE_SUPPORT:
				setDirectoryCacheSupport(DIRECTORY_CACHE_SUPPORT_EDEFAULT);
				return;
			case Db2highPackage.DB2_MANAGER__DISCOVER_SERVER_INSTANCE:
				setDiscoverServerInstance(DISCOVER_SERVER_INSTANCE_EDEFAULT);
				return;
			case Db2highPackage.DB2_MANAGER__DISCOVERY_MODE:
				setDiscoveryMode(DISCOVERY_MODE_EDEFAULT);
				return;
			case Db2highPackage.DB2_MANAGER__ENABLE_PNTRAPARTITION_PARALLELISM:
				setEnablePntrapartitionParallelism(ENABLE_PNTRAPARTITION_PARALLELISM_EDEFAULT);
				return;
			case Db2highPackage.DB2_MANAGER__FEDERATED_DATABASE_SYSTEM_SUPPORT:
				setFederatedDatabaseSystemSupport(FEDERATED_DATABASE_SYSTEM_SUPPORT_EDEFAULT);
				return;
			case Db2highPackage.DB2_MANAGER__GROUP_PLUGIN:
				setGroupPlugin(GROUP_PLUGIN_EDEFAULT);
				return;
			case Db2highPackage.DB2_MANAGER__HEALTH_MONITORING:
				setHealthMonitoring(HEALTH_MONITORING_EDEFAULT);
				return;
			case Db2highPackage.DB2_MANAGER__INDEX_RECREATION_TIME:
				setIndexRecreationTime(INDEX_RECREATION_TIME_EDEFAULT);
				return;
			case Db2highPackage.DB2_MANAGER__INITIAL_NUMBER_OF_AGENTS_IN_POOL:
				setInitialNumberOfAgentsInPool(INITIAL_NUMBER_OF_AGENTS_IN_POOL_EDEFAULT);
				return;
			case Db2highPackage.DB2_MANAGER__INITIAL_NUMBER_OF_FENCED_PROCESSES:
				setInitialNumberOfFencedProcesses(INITIAL_NUMBER_OF_FENCED_PROCESSES_EDEFAULT);
				return;
			case Db2highPackage.DB2_MANAGER__INSTANCE_IMPACT_POLICY:
				setInstanceImpactPolicy(INSTANCE_IMPACT_POLICY_EDEFAULT);
				return;
			case Db2highPackage.DB2_MANAGER__INSTANCE_MEMORY:
				setInstanceMemory(INSTANCE_MEMORY_EDEFAULT);
				return;
			case Db2highPackage.DB2_MANAGER__KEEP_FENCED_PROCESS:
				setKeepFencedProcess(KEEP_FENCED_PROCESS_EDEFAULT);
				return;
			case Db2highPackage.DB2_MANAGER__LIST_OF_GSSAPI_PLUGINS_FOR_INCOMING_CONNECTIONS:
				setListOfGSSAPIPluginsForIncomingConnections(LIST_OF_GSSAPI_PLUGINS_FOR_INCOMING_CONNECTIONS_EDEFAULT);
				return;
			case Db2highPackage.DB2_MANAGER__LOCAL_GSSAPI_PLUGIN:
				setLocalGSSAPIPlugin(LOCAL_GSSAPI_PLUGIN_EDEFAULT);
				return;
			case Db2highPackage.DB2_MANAGER__MACHINE_NODE_TYPE:
				setMachineNodeType(MACHINE_NODE_TYPE_EDEFAULT);
				return;
			case Db2highPackage.DB2_MANAGER__MAXIMUM_ASYNCHRONOUS_TQS_PER_QUERY:
				setMaximumAsynchronousTQsPerQuery(MAXIMUM_ASYNCHRONOUS_TQS_PER_QUERY_EDEFAULT);
				return;
			case Db2highPackage.DB2_MANAGER__MAXIMUM_JAVA_INTERPRETER_HEAP_SIZE:
				setMaximumJavaInterpreterHeapSize(MAXIMUM_JAVA_INTERPRETER_HEAP_SIZE_EDEFAULT);
				return;
			case Db2highPackage.DB2_MANAGER__MAXIMUM_NUMBER_OF_AGENTS:
				setMaximumNumberOfAgents(MAXIMUM_NUMBER_OF_AGENTS_EDEFAULT);
				return;
			case Db2highPackage.DB2_MANAGER__MAXIMUM_NUMBER_OF_CLIENT_CONNECTIONS:
				setMaximumNumberOfClientConnections(MAXIMUM_NUMBER_OF_CLIENT_CONNECTIONS_EDEFAULT);
				return;
			case Db2highPackage.DB2_MANAGER__MAXIMUM_NUMBER_OF_CONCURRENT_AGENTS:
				setMaximumNumberOfConcurrentAgents(MAXIMUM_NUMBER_OF_CONCURRENT_AGENTS_EDEFAULT);
				return;
			case Db2highPackage.DB2_MANAGER__MAXIMUM_NUMBER_OF_CONCURRENTLY_ACTIVE_DATABASES:
				setMaximumNumberOfConcurrentlyActiveDatabases(MAXIMUM_NUMBER_OF_CONCURRENTLY_ACTIVE_DATABASES_EDEFAULT);
				return;
			case Db2highPackage.DB2_MANAGER__MAXIMUM_NUMBER_OF_COORDINATING_AGENTS:
				setMaximumNumberOfCoordinatingAgents(MAXIMUM_NUMBER_OF_COORDINATING_AGENTS_EDEFAULT);
				return;
			case Db2highPackage.DB2_MANAGER__MAXIMUM_NUMBER_OF_FENCED_PROCESSES:
				setMaximumNumberOfFencedProcesses(MAXIMUM_NUMBER_OF_FENCED_PROCESSES_EDEFAULT);
				return;
			case Db2highPackage.DB2_MANAGER__MAXIMUM_QUERY_DEGREE_OF_PARALLELISM:
				setMaximumQueryDegreeOfParallelism(MAXIMUM_QUERY_DEGREE_OF_PARALLELISM_EDEFAULT);
				return;
			case Db2highPackage.DB2_MANAGER__MAXIMUM_TIME_DIFFERENCE_AMONG_NODES:
				setMaximumTimeDifferenceAmongNodes(MAXIMUM_TIME_DIFFERENCE_AMONG_NODES_EDEFAULT);
				return;
			case Db2highPackage.DB2_MANAGER__NODE_CONNECTION_RETRIES:
				setNodeConnectionRetries(NODE_CONNECTION_RETRIES_EDEFAULT);
				return;
			case Db2highPackage.DB2_MANAGER__NOTIFY_LEVEL:
				setNotifyLevel(NOTIFY_LEVEL_EDEFAULT);
				return;
			case Db2highPackage.DB2_MANAGER__NUMBER_OF_FCM_BUFFERS:
				setNumberOfFCMBuffers(NUMBER_OF_FCM_BUFFERS_EDEFAULT);
				return;
			case Db2highPackage.DB2_MANAGER__NUMBER_OF_FCM_CHANNELS:
				setNumberOfFCMChannels(NUMBER_OF_FCM_CHANNELS_EDEFAULT);
				return;
			case Db2highPackage.DB2_MANAGER__QUERY_HEAP_SIZE:
				setQueryHeapSize(QUERY_HEAP_SIZE_EDEFAULT);
				return;
			case Db2highPackage.DB2_MANAGER__SERVER_PLUGIN_MODE:
				setServerPluginMode(SERVER_PLUGIN_MODE_EDEFAULT);
				return;
			case Db2highPackage.DB2_MANAGER__SOFTWARE_DEVELOPERS_KIT_FOR_JAVA_INSTALLATION_PATH:
				setSoftwareDevelopersKitForJavaInstallationPath(SOFTWARE_DEVELOPERS_KIT_FOR_JAVA_INSTALLATION_PATH_EDEFAULT);
				return;
			case Db2highPackage.DB2_MANAGER__SORT_HEAP_THRESHOLD:
				setSortHeapThreshold(SORT_HEAP_THRESHOLD_EDEFAULT);
				return;
			case Db2highPackage.DB2_MANAGER__START_AND_STOP_TIMEOUT:
				setStartAndStopTimeout(START_AND_STOP_TIMEOUT_EDEFAULT);
				return;
			case Db2highPackage.DB2_MANAGER__SYNC_POINT_MANAGER_LOG_FILE_PATH:
				setSyncPointManagerLogFilePath(SYNC_POINT_MANAGER_LOG_FILE_PATH_EDEFAULT);
				return;
			case Db2highPackage.DB2_MANAGER__SYNC_POINT_MANAGER_LOG_FILE_SIZE:
				setSyncPointManagerLogFileSize(SYNC_POINT_MANAGER_LOG_FILE_SIZE_EDEFAULT);
				return;
			case Db2highPackage.DB2_MANAGER__SYNC_POINT_MANAGER_NAME:
				setSyncPointManagerName(SYNC_POINT_MANAGER_NAME_EDEFAULT);
				return;
			case Db2highPackage.DB2_MANAGER__SYNC_POINT_MANAGER_RESYNC_AGENT_LIMIT:
				setSyncPointManagerResyncAgentLimit(SYNC_POINT_MANAGER_RESYNC_AGENT_LIMIT_EDEFAULT);
				return;
			case Db2highPackage.DB2_MANAGER__SYSTEM_ADMINISTRATION_AUTHORITY_GROUP_NAME:
				setSystemAdministrationAuthorityGroupName(SYSTEM_ADMINISTRATION_AUTHORITY_GROUP_NAME_EDEFAULT);
				return;
			case Db2highPackage.DB2_MANAGER__SYSTEM_CONTROL_AUTHORITY_GROUP_NAME:
				setSystemControlAuthorityGroupName(SYSTEM_CONTROL_AUTHORITY_GROUP_NAME_EDEFAULT);
				return;
			case Db2highPackage.DB2_MANAGER__SYSTEM_MAINTENANCE_AUTHORITY_GROUP_NAME:
				setSystemMaintenanceAuthorityGroupName(SYSTEM_MAINTENANCE_AUTHORITY_GROUP_NAME_EDEFAULT);
				return;
			case Db2highPackage.DB2_MANAGER__SYSTEM_MONITOR_AUTHORITY_GROUP_NAME:
				setSystemMonitorAuthorityGroupName(SYSTEM_MONITOR_AUTHORITY_GROUP_NAME_EDEFAULT);
				return;
			case Db2highPackage.DB2_MANAGER__TCPIP_SERVICE_NAME:
				setTCPIPServiceName(TCPIP_SERVICE_NAME_EDEFAULT);
				return;
			case Db2highPackage.DB2_MANAGER__TRANSACTION_MANAGER_DATABASE_NAME:
				setTransactionManagerDatabaseName(TRANSACTION_MANAGER_DATABASE_NAME_EDEFAULT);
				return;
			case Db2highPackage.DB2_MANAGER__TRANSACTION_PROCESSOR_MONITOR_NAME:
				setTransactionProcessorMonitorName(TRANSACTION_PROCESSOR_MONITOR_NAME_EDEFAULT);
				return;
			case Db2highPackage.DB2_MANAGER__TRANSACTION_RESYNC_INTERVAL:
				setTransactionResyncInterval(TRANSACTION_RESYNC_INTERVAL_EDEFAULT);
				return;
			case Db2highPackage.DB2_MANAGER__TRUST_ALL_CLIENTS:
				setTrustAllClients(TRUST_ALL_CLIENTS_EDEFAULT);
				return;
			case Db2highPackage.DB2_MANAGER__TRUSTED_CLIENTS_AUTHENTICATION:
				setTrustedClientsAuthentication(TRUSTED_CLIENTS_AUTHENTICATION_EDEFAULT);
				return;
			case Db2highPackage.DB2_MANAGER__USERID_PASSWORD_PLUG_IN:
				setUseridPasswordPlugIn(USERID_PASSWORD_PLUG_IN_EDEFAULT);
				return;
		}
		super.eUnset(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean eIsSet(int featureID) {
		switch (featureID) {
			case Db2highPackage.DB2_MANAGER__AGENT_POOL_SIZE:
				return AGENT_POOL_SIZE_EDEFAULT == null ? agentPoolSize != null : !AGENT_POOL_SIZE_EDEFAULT.equals(agentPoolSize);
			case Db2highPackage.DB2_MANAGER__AGENT_PRIORITY:
				return AGENT_PRIORITY_EDEFAULT == null ? agentPriority != null : !AGENT_PRIORITY_EDEFAULT.equals(agentPriority);
			case Db2highPackage.DB2_MANAGER__AGENT_STACK_SIZE:
				return AGENT_STACK_SIZE_EDEFAULT == null ? agentStackSize != null : !AGENT_STACK_SIZE_EDEFAULT.equals(agentStackSize);
			case Db2highPackage.DB2_MANAGER__APPLICATION_SUPPORT_LAYER_HEAP_SIZE:
				return APPLICATION_SUPPORT_LAYER_HEAP_SIZE_EDEFAULT == null ? applicationSupportLayerHeapSize != null : !APPLICATION_SUPPORT_LAYER_HEAP_SIZE_EDEFAULT.equals(applicationSupportLayerHeapSize);
			case Db2highPackage.DB2_MANAGER__AUDIT_BUFFER_SIZE:
				return AUDIT_BUFFER_SIZE_EDEFAULT == null ? auditBufferSize != null : !AUDIT_BUFFER_SIZE_EDEFAULT.equals(auditBufferSize);
			case Db2highPackage.DB2_MANAGER__AUTHENTICATION_TYPE:
				return AUTHENTICATION_TYPE_EDEFAULT == null ? authenticationType != null : !AUTHENTICATION_TYPE_EDEFAULT.equals(authenticationType);
			case Db2highPackage.DB2_MANAGER__AUTHENTICATION_TYPE_FOR_INCOMING_CONNECTIONS:
				return AUTHENTICATION_TYPE_FOR_INCOMING_CONNECTIONS_EDEFAULT == null ? authenticationTypeForIncomingConnections != null : !AUTHENTICATION_TYPE_FOR_INCOMING_CONNECTIONS_EDEFAULT.equals(authenticationTypeForIncomingConnections);
			case Db2highPackage.DB2_MANAGER__BYPASS_FEDERATED_AUTHENTICATION:
				return BYPASS_FEDERATED_AUTHENTICATION_EDEFAULT == null ? bypassFederatedAuthentication != null : !BYPASS_FEDERATED_AUTHENTICATION_EDEFAULT.equals(bypassFederatedAuthentication);
			case Db2highPackage.DB2_MANAGER__CATALOGING_ALLOWED_WITHOUT_AUTHORITY:
				return CATALOGING_ALLOWED_WITHOUT_AUTHORITY_EDEFAULT == null ? catalogingAllowedWithoutAuthority != null : !CATALOGING_ALLOWED_WITHOUT_AUTHORITY_EDEFAULT.equals(catalogingAllowedWithoutAuthority);
			case Db2highPackage.DB2_MANAGER__CLIENT_IO_BLOCK_SIZE:
				return CLIENT_IO_BLOCK_SIZE_EDEFAULT == null ? clientIOBlockSize != null : !CLIENT_IO_BLOCK_SIZE_EDEFAULT.equals(clientIOBlockSize);
			case Db2highPackage.DB2_MANAGER__CLIENT_KERBEROS_PLUGIN:
				return CLIENT_KERBEROS_PLUGIN_EDEFAULT == null ? clientKerberosPlugin != null : !CLIENT_KERBEROS_PLUGIN_EDEFAULT.equals(clientKerberosPlugin);
			case Db2highPackage.DB2_MANAGER__CLIENT_USERID_PASSWORD_PLUGIN:
				return CLIENT_USERID_PASSWORD_PLUGIN_EDEFAULT == null ? clientUseridPasswordPlugin != null : !CLIENT_USERID_PASSWORD_PLUGIN_EDEFAULT.equals(clientUseridPasswordPlugin);
			case Db2highPackage.DB2_MANAGER__COMMUNICATIONS_BANDWIDTH:
				return COMMUNICATIONS_BANDWIDTH_EDEFAULT == null ? communicationsBandwidth != null : !COMMUNICATIONS_BANDWIDTH_EDEFAULT.equals(communicationsBandwidth);
			case Db2highPackage.DB2_MANAGER__CONFIGURATION_FILE_RELEASE_LEVEL:
				return CONFIGURATION_FILE_RELEASE_LEVEL_EDEFAULT == null ? configurationFileReleaseLevel != null : !CONFIGURATION_FILE_RELEASE_LEVEL_EDEFAULT.equals(configurationFileReleaseLevel);
			case Db2highPackage.DB2_MANAGER__CONNECTION_ELAPSE_TIME:
				return CONNECTION_ELAPSE_TIME_EDEFAULT == null ? connectionElapseTime != null : !CONNECTION_ELAPSE_TIME_EDEFAULT.equals(connectionElapseTime);
			case Db2highPackage.DB2_MANAGER__CPU_SPEED:
				return CPU_SPEED_EDEFAULT == null ? cPUSpeed != null : !CPU_SPEED_EDEFAULT.equals(cPUSpeed);
			case Db2highPackage.DB2_MANAGER__DATABASE_SYSTEM_MONITOR_HEAP_SIZE:
				return DATABASE_SYSTEM_MONITOR_HEAP_SIZE_EDEFAULT == null ? databaseSystemMonitorHeapSize != null : !DATABASE_SYSTEM_MONITOR_HEAP_SIZE_EDEFAULT.equals(databaseSystemMonitorHeapSize);
			case Db2highPackage.DB2_MANAGER__DEFAULT_CHARGE_BACK_ACCOUNT:
				return DEFAULT_CHARGE_BACK_ACCOUNT_EDEFAULT == null ? defaultChargeBackAccount != null : !DEFAULT_CHARGE_BACK_ACCOUNT_EDEFAULT.equals(defaultChargeBackAccount);
			case Db2highPackage.DB2_MANAGER__DEFAULT_DATABASE_PATH:
				return DEFAULT_DATABASE_PATH_EDEFAULT == null ? defaultDatabasePath != null : !DEFAULT_DATABASE_PATH_EDEFAULT.equals(defaultDatabasePath);
			case Db2highPackage.DB2_MANAGER__DEFAULT_DATABASE_SYSTEM_MONITOR_SWITCHES:
				return DEFAULT_DATABASE_SYSTEM_MONITOR_SWITCHES_EDEFAULT == null ? defaultDatabaseSystemMonitorSwitches != null : !DEFAULT_DATABASE_SYSTEM_MONITOR_SWITCHES_EDEFAULT.equals(defaultDatabaseSystemMonitorSwitches);
			case Db2highPackage.DB2_MANAGER__DIAGNOSTIC_DATA_DIRECTORY_PATH:
				return DIAGNOSTIC_DATA_DIRECTORY_PATH_EDEFAULT == null ? diagnosticDataDirectoryPath != null : !DIAGNOSTIC_DATA_DIRECTORY_PATH_EDEFAULT.equals(diagnosticDataDirectoryPath);
			case Db2highPackage.DB2_MANAGER__DIAGNOSTIC_ERROR_CAPTURE_LEVEL:
				return DIAGNOSTIC_ERROR_CAPTURE_LEVEL_EDEFAULT == null ? diagnosticErrorCaptureLevel != null : !DIAGNOSTIC_ERROR_CAPTURE_LEVEL_EDEFAULT.equals(diagnosticErrorCaptureLevel);
			case Db2highPackage.DB2_MANAGER__DIRECTORY_CACHE_SUPPORT:
				return DIRECTORY_CACHE_SUPPORT_EDEFAULT == null ? directoryCacheSupport != null : !DIRECTORY_CACHE_SUPPORT_EDEFAULT.equals(directoryCacheSupport);
			case Db2highPackage.DB2_MANAGER__DISCOVER_SERVER_INSTANCE:
				return DISCOVER_SERVER_INSTANCE_EDEFAULT == null ? discoverServerInstance != null : !DISCOVER_SERVER_INSTANCE_EDEFAULT.equals(discoverServerInstance);
			case Db2highPackage.DB2_MANAGER__DISCOVERY_MODE:
				return DISCOVERY_MODE_EDEFAULT == null ? discoveryMode != null : !DISCOVERY_MODE_EDEFAULT.equals(discoveryMode);
			case Db2highPackage.DB2_MANAGER__ENABLE_PNTRAPARTITION_PARALLELISM:
				return ENABLE_PNTRAPARTITION_PARALLELISM_EDEFAULT == null ? enablePntrapartitionParallelism != null : !ENABLE_PNTRAPARTITION_PARALLELISM_EDEFAULT.equals(enablePntrapartitionParallelism);
			case Db2highPackage.DB2_MANAGER__FEDERATED_DATABASE_SYSTEM_SUPPORT:
				return FEDERATED_DATABASE_SYSTEM_SUPPORT_EDEFAULT == null ? federatedDatabaseSystemSupport != null : !FEDERATED_DATABASE_SYSTEM_SUPPORT_EDEFAULT.equals(federatedDatabaseSystemSupport);
			case Db2highPackage.DB2_MANAGER__GROUP_PLUGIN:
				return GROUP_PLUGIN_EDEFAULT == null ? groupPlugin != null : !GROUP_PLUGIN_EDEFAULT.equals(groupPlugin);
			case Db2highPackage.DB2_MANAGER__HEALTH_MONITORING:
				return HEALTH_MONITORING_EDEFAULT == null ? healthMonitoring != null : !HEALTH_MONITORING_EDEFAULT.equals(healthMonitoring);
			case Db2highPackage.DB2_MANAGER__INDEX_RECREATION_TIME:
				return INDEX_RECREATION_TIME_EDEFAULT == null ? indexRecreationTime != null : !INDEX_RECREATION_TIME_EDEFAULT.equals(indexRecreationTime);
			case Db2highPackage.DB2_MANAGER__INITIAL_NUMBER_OF_AGENTS_IN_POOL:
				return INITIAL_NUMBER_OF_AGENTS_IN_POOL_EDEFAULT == null ? initialNumberOfAgentsInPool != null : !INITIAL_NUMBER_OF_AGENTS_IN_POOL_EDEFAULT.equals(initialNumberOfAgentsInPool);
			case Db2highPackage.DB2_MANAGER__INITIAL_NUMBER_OF_FENCED_PROCESSES:
				return INITIAL_NUMBER_OF_FENCED_PROCESSES_EDEFAULT == null ? initialNumberOfFencedProcesses != null : !INITIAL_NUMBER_OF_FENCED_PROCESSES_EDEFAULT.equals(initialNumberOfFencedProcesses);
			case Db2highPackage.DB2_MANAGER__INSTANCE_IMPACT_POLICY:
				return INSTANCE_IMPACT_POLICY_EDEFAULT == null ? instanceImpactPolicy != null : !INSTANCE_IMPACT_POLICY_EDEFAULT.equals(instanceImpactPolicy);
			case Db2highPackage.DB2_MANAGER__INSTANCE_MEMORY:
				return INSTANCE_MEMORY_EDEFAULT == null ? instanceMemory != null : !INSTANCE_MEMORY_EDEFAULT.equals(instanceMemory);
			case Db2highPackage.DB2_MANAGER__KEEP_FENCED_PROCESS:
				return KEEP_FENCED_PROCESS_EDEFAULT == null ? keepFencedProcess != null : !KEEP_FENCED_PROCESS_EDEFAULT.equals(keepFencedProcess);
			case Db2highPackage.DB2_MANAGER__LIST_OF_GSSAPI_PLUGINS_FOR_INCOMING_CONNECTIONS:
				return LIST_OF_GSSAPI_PLUGINS_FOR_INCOMING_CONNECTIONS_EDEFAULT == null ? listOfGSSAPIPluginsForIncomingConnections != null : !LIST_OF_GSSAPI_PLUGINS_FOR_INCOMING_CONNECTIONS_EDEFAULT.equals(listOfGSSAPIPluginsForIncomingConnections);
			case Db2highPackage.DB2_MANAGER__LOCAL_GSSAPI_PLUGIN:
				return LOCAL_GSSAPI_PLUGIN_EDEFAULT == null ? localGSSAPIPlugin != null : !LOCAL_GSSAPI_PLUGIN_EDEFAULT.equals(localGSSAPIPlugin);
			case Db2highPackage.DB2_MANAGER__MACHINE_NODE_TYPE:
				return MACHINE_NODE_TYPE_EDEFAULT == null ? machineNodeType != null : !MACHINE_NODE_TYPE_EDEFAULT.equals(machineNodeType);
			case Db2highPackage.DB2_MANAGER__MAXIMUM_ASYNCHRONOUS_TQS_PER_QUERY:
				return MAXIMUM_ASYNCHRONOUS_TQS_PER_QUERY_EDEFAULT == null ? maximumAsynchronousTQsPerQuery != null : !MAXIMUM_ASYNCHRONOUS_TQS_PER_QUERY_EDEFAULT.equals(maximumAsynchronousTQsPerQuery);
			case Db2highPackage.DB2_MANAGER__MAXIMUM_JAVA_INTERPRETER_HEAP_SIZE:
				return MAXIMUM_JAVA_INTERPRETER_HEAP_SIZE_EDEFAULT == null ? maximumJavaInterpreterHeapSize != null : !MAXIMUM_JAVA_INTERPRETER_HEAP_SIZE_EDEFAULT.equals(maximumJavaInterpreterHeapSize);
			case Db2highPackage.DB2_MANAGER__MAXIMUM_NUMBER_OF_AGENTS:
				return MAXIMUM_NUMBER_OF_AGENTS_EDEFAULT == null ? maximumNumberOfAgents != null : !MAXIMUM_NUMBER_OF_AGENTS_EDEFAULT.equals(maximumNumberOfAgents);
			case Db2highPackage.DB2_MANAGER__MAXIMUM_NUMBER_OF_CLIENT_CONNECTIONS:
				return MAXIMUM_NUMBER_OF_CLIENT_CONNECTIONS_EDEFAULT == null ? maximumNumberOfClientConnections != null : !MAXIMUM_NUMBER_OF_CLIENT_CONNECTIONS_EDEFAULT.equals(maximumNumberOfClientConnections);
			case Db2highPackage.DB2_MANAGER__MAXIMUM_NUMBER_OF_CONCURRENT_AGENTS:
				return MAXIMUM_NUMBER_OF_CONCURRENT_AGENTS_EDEFAULT == null ? maximumNumberOfConcurrentAgents != null : !MAXIMUM_NUMBER_OF_CONCURRENT_AGENTS_EDEFAULT.equals(maximumNumberOfConcurrentAgents);
			case Db2highPackage.DB2_MANAGER__MAXIMUM_NUMBER_OF_CONCURRENTLY_ACTIVE_DATABASES:
				return MAXIMUM_NUMBER_OF_CONCURRENTLY_ACTIVE_DATABASES_EDEFAULT == null ? maximumNumberOfConcurrentlyActiveDatabases != null : !MAXIMUM_NUMBER_OF_CONCURRENTLY_ACTIVE_DATABASES_EDEFAULT.equals(maximumNumberOfConcurrentlyActiveDatabases);
			case Db2highPackage.DB2_MANAGER__MAXIMUM_NUMBER_OF_COORDINATING_AGENTS:
				return MAXIMUM_NUMBER_OF_COORDINATING_AGENTS_EDEFAULT == null ? maximumNumberOfCoordinatingAgents != null : !MAXIMUM_NUMBER_OF_COORDINATING_AGENTS_EDEFAULT.equals(maximumNumberOfCoordinatingAgents);
			case Db2highPackage.DB2_MANAGER__MAXIMUM_NUMBER_OF_FENCED_PROCESSES:
				return MAXIMUM_NUMBER_OF_FENCED_PROCESSES_EDEFAULT == null ? maximumNumberOfFencedProcesses != null : !MAXIMUM_NUMBER_OF_FENCED_PROCESSES_EDEFAULT.equals(maximumNumberOfFencedProcesses);
			case Db2highPackage.DB2_MANAGER__MAXIMUM_QUERY_DEGREE_OF_PARALLELISM:
				return MAXIMUM_QUERY_DEGREE_OF_PARALLELISM_EDEFAULT == null ? maximumQueryDegreeOfParallelism != null : !MAXIMUM_QUERY_DEGREE_OF_PARALLELISM_EDEFAULT.equals(maximumQueryDegreeOfParallelism);
			case Db2highPackage.DB2_MANAGER__MAXIMUM_TIME_DIFFERENCE_AMONG_NODES:
				return MAXIMUM_TIME_DIFFERENCE_AMONG_NODES_EDEFAULT == null ? maximumTimeDifferenceAmongNodes != null : !MAXIMUM_TIME_DIFFERENCE_AMONG_NODES_EDEFAULT.equals(maximumTimeDifferenceAmongNodes);
			case Db2highPackage.DB2_MANAGER__NODE_CONNECTION_RETRIES:
				return NODE_CONNECTION_RETRIES_EDEFAULT == null ? nodeConnectionRetries != null : !NODE_CONNECTION_RETRIES_EDEFAULT.equals(nodeConnectionRetries);
			case Db2highPackage.DB2_MANAGER__NOTIFY_LEVEL:
				return NOTIFY_LEVEL_EDEFAULT == null ? notifyLevel != null : !NOTIFY_LEVEL_EDEFAULT.equals(notifyLevel);
			case Db2highPackage.DB2_MANAGER__NUMBER_OF_FCM_BUFFERS:
				return NUMBER_OF_FCM_BUFFERS_EDEFAULT == null ? numberOfFCMBuffers != null : !NUMBER_OF_FCM_BUFFERS_EDEFAULT.equals(numberOfFCMBuffers);
			case Db2highPackage.DB2_MANAGER__NUMBER_OF_FCM_CHANNELS:
				return NUMBER_OF_FCM_CHANNELS_EDEFAULT == null ? numberOfFCMChannels != null : !NUMBER_OF_FCM_CHANNELS_EDEFAULT.equals(numberOfFCMChannels);
			case Db2highPackage.DB2_MANAGER__QUERY_HEAP_SIZE:
				return QUERY_HEAP_SIZE_EDEFAULT == null ? queryHeapSize != null : !QUERY_HEAP_SIZE_EDEFAULT.equals(queryHeapSize);
			case Db2highPackage.DB2_MANAGER__SERVER_PLUGIN_MODE:
				return SERVER_PLUGIN_MODE_EDEFAULT == null ? serverPluginMode != null : !SERVER_PLUGIN_MODE_EDEFAULT.equals(serverPluginMode);
			case Db2highPackage.DB2_MANAGER__SOFTWARE_DEVELOPERS_KIT_FOR_JAVA_INSTALLATION_PATH:
				return SOFTWARE_DEVELOPERS_KIT_FOR_JAVA_INSTALLATION_PATH_EDEFAULT == null ? softwareDevelopersKitForJavaInstallationPath != null : !SOFTWARE_DEVELOPERS_KIT_FOR_JAVA_INSTALLATION_PATH_EDEFAULT.equals(softwareDevelopersKitForJavaInstallationPath);
			case Db2highPackage.DB2_MANAGER__SORT_HEAP_THRESHOLD:
				return SORT_HEAP_THRESHOLD_EDEFAULT == null ? sortHeapThreshold != null : !SORT_HEAP_THRESHOLD_EDEFAULT.equals(sortHeapThreshold);
			case Db2highPackage.DB2_MANAGER__START_AND_STOP_TIMEOUT:
				return START_AND_STOP_TIMEOUT_EDEFAULT == null ? startAndStopTimeout != null : !START_AND_STOP_TIMEOUT_EDEFAULT.equals(startAndStopTimeout);
			case Db2highPackage.DB2_MANAGER__SYNC_POINT_MANAGER_LOG_FILE_PATH:
				return SYNC_POINT_MANAGER_LOG_FILE_PATH_EDEFAULT == null ? syncPointManagerLogFilePath != null : !SYNC_POINT_MANAGER_LOG_FILE_PATH_EDEFAULT.equals(syncPointManagerLogFilePath);
			case Db2highPackage.DB2_MANAGER__SYNC_POINT_MANAGER_LOG_FILE_SIZE:
				return SYNC_POINT_MANAGER_LOG_FILE_SIZE_EDEFAULT == null ? syncPointManagerLogFileSize != null : !SYNC_POINT_MANAGER_LOG_FILE_SIZE_EDEFAULT.equals(syncPointManagerLogFileSize);
			case Db2highPackage.DB2_MANAGER__SYNC_POINT_MANAGER_NAME:
				return SYNC_POINT_MANAGER_NAME_EDEFAULT == null ? syncPointManagerName != null : !SYNC_POINT_MANAGER_NAME_EDEFAULT.equals(syncPointManagerName);
			case Db2highPackage.DB2_MANAGER__SYNC_POINT_MANAGER_RESYNC_AGENT_LIMIT:
				return SYNC_POINT_MANAGER_RESYNC_AGENT_LIMIT_EDEFAULT == null ? syncPointManagerResyncAgentLimit != null : !SYNC_POINT_MANAGER_RESYNC_AGENT_LIMIT_EDEFAULT.equals(syncPointManagerResyncAgentLimit);
			case Db2highPackage.DB2_MANAGER__SYSTEM_ADMINISTRATION_AUTHORITY_GROUP_NAME:
				return SYSTEM_ADMINISTRATION_AUTHORITY_GROUP_NAME_EDEFAULT == null ? systemAdministrationAuthorityGroupName != null : !SYSTEM_ADMINISTRATION_AUTHORITY_GROUP_NAME_EDEFAULT.equals(systemAdministrationAuthorityGroupName);
			case Db2highPackage.DB2_MANAGER__SYSTEM_CONTROL_AUTHORITY_GROUP_NAME:
				return SYSTEM_CONTROL_AUTHORITY_GROUP_NAME_EDEFAULT == null ? systemControlAuthorityGroupName != null : !SYSTEM_CONTROL_AUTHORITY_GROUP_NAME_EDEFAULT.equals(systemControlAuthorityGroupName);
			case Db2highPackage.DB2_MANAGER__SYSTEM_MAINTENANCE_AUTHORITY_GROUP_NAME:
				return SYSTEM_MAINTENANCE_AUTHORITY_GROUP_NAME_EDEFAULT == null ? systemMaintenanceAuthorityGroupName != null : !SYSTEM_MAINTENANCE_AUTHORITY_GROUP_NAME_EDEFAULT.equals(systemMaintenanceAuthorityGroupName);
			case Db2highPackage.DB2_MANAGER__SYSTEM_MONITOR_AUTHORITY_GROUP_NAME:
				return SYSTEM_MONITOR_AUTHORITY_GROUP_NAME_EDEFAULT == null ? systemMonitorAuthorityGroupName != null : !SYSTEM_MONITOR_AUTHORITY_GROUP_NAME_EDEFAULT.equals(systemMonitorAuthorityGroupName);
			case Db2highPackage.DB2_MANAGER__TCPIP_SERVICE_NAME:
				return TCPIP_SERVICE_NAME_EDEFAULT == null ? tCPIPServiceName != null : !TCPIP_SERVICE_NAME_EDEFAULT.equals(tCPIPServiceName);
			case Db2highPackage.DB2_MANAGER__TRANSACTION_MANAGER_DATABASE_NAME:
				return TRANSACTION_MANAGER_DATABASE_NAME_EDEFAULT == null ? transactionManagerDatabaseName != null : !TRANSACTION_MANAGER_DATABASE_NAME_EDEFAULT.equals(transactionManagerDatabaseName);
			case Db2highPackage.DB2_MANAGER__TRANSACTION_PROCESSOR_MONITOR_NAME:
				return TRANSACTION_PROCESSOR_MONITOR_NAME_EDEFAULT == null ? transactionProcessorMonitorName != null : !TRANSACTION_PROCESSOR_MONITOR_NAME_EDEFAULT.equals(transactionProcessorMonitorName);
			case Db2highPackage.DB2_MANAGER__TRANSACTION_RESYNC_INTERVAL:
				return TRANSACTION_RESYNC_INTERVAL_EDEFAULT == null ? transactionResyncInterval != null : !TRANSACTION_RESYNC_INTERVAL_EDEFAULT.equals(transactionResyncInterval);
			case Db2highPackage.DB2_MANAGER__TRUST_ALL_CLIENTS:
				return TRUST_ALL_CLIENTS_EDEFAULT == null ? trustAllClients != null : !TRUST_ALL_CLIENTS_EDEFAULT.equals(trustAllClients);
			case Db2highPackage.DB2_MANAGER__TRUSTED_CLIENTS_AUTHENTICATION:
				return TRUSTED_CLIENTS_AUTHENTICATION_EDEFAULT == null ? trustedClientsAuthentication != null : !TRUSTED_CLIENTS_AUTHENTICATION_EDEFAULT.equals(trustedClientsAuthentication);
			case Db2highPackage.DB2_MANAGER__USERID_PASSWORD_PLUG_IN:
				return USERID_PASSWORD_PLUG_IN_EDEFAULT == null ? useridPasswordPlugIn != null : !USERID_PASSWORD_PLUG_IN_EDEFAULT.equals(useridPasswordPlugIn);
		}
		return super.eIsSet(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String toString() {
		if (eIsProxy()) return super.toString();

		StringBuffer result = new StringBuffer(super.toString());
		result.append(" (agentPoolSize: "); //$NON-NLS-1$
		result.append(agentPoolSize);
		result.append(", agentPriority: "); //$NON-NLS-1$
		result.append(agentPriority);
		result.append(", agentStackSize: "); //$NON-NLS-1$
		result.append(agentStackSize);
		result.append(", applicationSupportLayerHeapSize: "); //$NON-NLS-1$
		result.append(applicationSupportLayerHeapSize);
		result.append(", auditBufferSize: "); //$NON-NLS-1$
		result.append(auditBufferSize);
		result.append(", authenticationType: "); //$NON-NLS-1$
		result.append(authenticationType);
		result.append(", authenticationTypeForIncomingConnections: "); //$NON-NLS-1$
		result.append(authenticationTypeForIncomingConnections);
		result.append(", bypassFederatedAuthentication: "); //$NON-NLS-1$
		result.append(bypassFederatedAuthentication);
		result.append(", catalogingAllowedWithoutAuthority: "); //$NON-NLS-1$
		result.append(catalogingAllowedWithoutAuthority);
		result.append(", clientIOBlockSize: "); //$NON-NLS-1$
		result.append(clientIOBlockSize);
		result.append(", clientKerberosPlugin: "); //$NON-NLS-1$
		result.append(clientKerberosPlugin);
		result.append(", clientUseridPasswordPlugin: "); //$NON-NLS-1$
		result.append(clientUseridPasswordPlugin);
		result.append(", communicationsBandwidth: "); //$NON-NLS-1$
		result.append(communicationsBandwidth);
		result.append(", configurationFileReleaseLevel: "); //$NON-NLS-1$
		result.append(configurationFileReleaseLevel);
		result.append(", connectionElapseTime: "); //$NON-NLS-1$
		result.append(connectionElapseTime);
		result.append(", cPUSpeed: "); //$NON-NLS-1$
		result.append(cPUSpeed);
		result.append(", databaseSystemMonitorHeapSize: "); //$NON-NLS-1$
		result.append(databaseSystemMonitorHeapSize);
		result.append(", defaultChargeBackAccount: "); //$NON-NLS-1$
		result.append(defaultChargeBackAccount);
		result.append(", defaultDatabasePath: "); //$NON-NLS-1$
		result.append(defaultDatabasePath);
		result.append(", defaultDatabaseSystemMonitorSwitches: "); //$NON-NLS-1$
		result.append(defaultDatabaseSystemMonitorSwitches);
		result.append(", diagnosticDataDirectoryPath: "); //$NON-NLS-1$
		result.append(diagnosticDataDirectoryPath);
		result.append(", diagnosticErrorCaptureLevel: "); //$NON-NLS-1$
		result.append(diagnosticErrorCaptureLevel);
		result.append(", directoryCacheSupport: "); //$NON-NLS-1$
		result.append(directoryCacheSupport);
		result.append(", discoverServerInstance: "); //$NON-NLS-1$
		result.append(discoverServerInstance);
		result.append(", discoveryMode: "); //$NON-NLS-1$
		result.append(discoveryMode);
		result.append(", enablePntrapartitionParallelism: "); //$NON-NLS-1$
		result.append(enablePntrapartitionParallelism);
		result.append(", federatedDatabaseSystemSupport: "); //$NON-NLS-1$
		result.append(federatedDatabaseSystemSupport);
		result.append(", groupPlugin: "); //$NON-NLS-1$
		result.append(groupPlugin);
		result.append(", healthMonitoring: "); //$NON-NLS-1$
		result.append(healthMonitoring);
		result.append(", indexRecreationTime: "); //$NON-NLS-1$
		result.append(indexRecreationTime);
		result.append(", initialNumberOfAgentsInPool: "); //$NON-NLS-1$
		result.append(initialNumberOfAgentsInPool);
		result.append(", initialNumberOfFencedProcesses: "); //$NON-NLS-1$
		result.append(initialNumberOfFencedProcesses);
		result.append(", instanceImpactPolicy: "); //$NON-NLS-1$
		result.append(instanceImpactPolicy);
		result.append(", instanceMemory: "); //$NON-NLS-1$
		result.append(instanceMemory);
		result.append(", keepFencedProcess: "); //$NON-NLS-1$
		result.append(keepFencedProcess);
		result.append(", listOfGSSAPIPluginsForIncomingConnections: "); //$NON-NLS-1$
		result.append(listOfGSSAPIPluginsForIncomingConnections);
		result.append(", localGSSAPIPlugin: "); //$NON-NLS-1$
		result.append(localGSSAPIPlugin);
		result.append(", machineNodeType: "); //$NON-NLS-1$
		result.append(machineNodeType);
		result.append(", maximumAsynchronousTQsPerQuery: "); //$NON-NLS-1$
		result.append(maximumAsynchronousTQsPerQuery);
		result.append(", maximumJavaInterpreterHeapSize: "); //$NON-NLS-1$
		result.append(maximumJavaInterpreterHeapSize);
		result.append(", maximumNumberOfAgents: "); //$NON-NLS-1$
		result.append(maximumNumberOfAgents);
		result.append(", maximumNumberOfClientConnections: "); //$NON-NLS-1$
		result.append(maximumNumberOfClientConnections);
		result.append(", maximumNumberOfConcurrentAgents: "); //$NON-NLS-1$
		result.append(maximumNumberOfConcurrentAgents);
		result.append(", maximumNumberOfConcurrentlyActiveDatabases: "); //$NON-NLS-1$
		result.append(maximumNumberOfConcurrentlyActiveDatabases);
		result.append(", maximumNumberOfCoordinatingAgents: "); //$NON-NLS-1$
		result.append(maximumNumberOfCoordinatingAgents);
		result.append(", maximumNumberOfFencedProcesses: "); //$NON-NLS-1$
		result.append(maximumNumberOfFencedProcesses);
		result.append(", maximumQueryDegreeOfParallelism: "); //$NON-NLS-1$
		result.append(maximumQueryDegreeOfParallelism);
		result.append(", maximumTimeDifferenceAmongNodes: "); //$NON-NLS-1$
		result.append(maximumTimeDifferenceAmongNodes);
		result.append(", nodeConnectionRetries: "); //$NON-NLS-1$
		result.append(nodeConnectionRetries);
		result.append(", notifyLevel: "); //$NON-NLS-1$
		result.append(notifyLevel);
		result.append(", numberOfFCMBuffers: "); //$NON-NLS-1$
		result.append(numberOfFCMBuffers);
		result.append(", numberOfFCMChannels: "); //$NON-NLS-1$
		result.append(numberOfFCMChannels);
		result.append(", queryHeapSize: "); //$NON-NLS-1$
		result.append(queryHeapSize);
		result.append(", serverPluginMode: "); //$NON-NLS-1$
		result.append(serverPluginMode);
		result.append(", softwareDevelopersKitForJavaInstallationPath: "); //$NON-NLS-1$
		result.append(softwareDevelopersKitForJavaInstallationPath);
		result.append(", sortHeapThreshold: "); //$NON-NLS-1$
		result.append(sortHeapThreshold);
		result.append(", startAndStopTimeout: "); //$NON-NLS-1$
		result.append(startAndStopTimeout);
		result.append(", syncPointManagerLogFilePath: "); //$NON-NLS-1$
		result.append(syncPointManagerLogFilePath);
		result.append(", syncPointManagerLogFileSize: "); //$NON-NLS-1$
		result.append(syncPointManagerLogFileSize);
		result.append(", syncPointManagerName: "); //$NON-NLS-1$
		result.append(syncPointManagerName);
		result.append(", syncPointManagerResyncAgentLimit: "); //$NON-NLS-1$
		result.append(syncPointManagerResyncAgentLimit);
		result.append(", systemAdministrationAuthorityGroupName: "); //$NON-NLS-1$
		result.append(systemAdministrationAuthorityGroupName);
		result.append(", systemControlAuthorityGroupName: "); //$NON-NLS-1$
		result.append(systemControlAuthorityGroupName);
		result.append(", systemMaintenanceAuthorityGroupName: "); //$NON-NLS-1$
		result.append(systemMaintenanceAuthorityGroupName);
		result.append(", systemMonitorAuthorityGroupName: "); //$NON-NLS-1$
		result.append(systemMonitorAuthorityGroupName);
		result.append(", tCPIPServiceName: "); //$NON-NLS-1$
		result.append(tCPIPServiceName);
		result.append(", transactionManagerDatabaseName: "); //$NON-NLS-1$
		result.append(transactionManagerDatabaseName);
		result.append(", transactionProcessorMonitorName: "); //$NON-NLS-1$
		result.append(transactionProcessorMonitorName);
		result.append(", transactionResyncInterval: "); //$NON-NLS-1$
		result.append(transactionResyncInterval);
		result.append(", trustAllClients: "); //$NON-NLS-1$
		result.append(trustAllClients);
		result.append(", trustedClientsAuthentication: "); //$NON-NLS-1$
		result.append(trustedClientsAuthentication);
		result.append(", useridPasswordPlugIn: "); //$NON-NLS-1$
		result.append(useridPasswordPlugIn);
		result.append(')');
		return result.toString();
	}

} //DB2ManagerImpl
