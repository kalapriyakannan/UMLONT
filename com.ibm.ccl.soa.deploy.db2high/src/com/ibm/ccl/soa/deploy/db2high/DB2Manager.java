/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package com.ibm.ccl.soa.deploy.db2high;

import com.ibm.ccl.soa.deploy.core.Capability;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>DB2 Manager</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link com.ibm.ccl.soa.deploy.db2high.DB2Manager#getAgentPoolSize <em>Agent Pool Size</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.db2high.DB2Manager#getAgentPriority <em>Agent Priority</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.db2high.DB2Manager#getAgentStackSize <em>Agent Stack Size</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.db2high.DB2Manager#getApplicationSupportLayerHeapSize <em>Application Support Layer Heap Size</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.db2high.DB2Manager#getAuditBufferSize <em>Audit Buffer Size</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.db2high.DB2Manager#getAuthenticationType <em>Authentication Type</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.db2high.DB2Manager#getAuthenticationTypeForIncomingConnections <em>Authentication Type For Incoming Connections</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.db2high.DB2Manager#getBypassFederatedAuthentication <em>Bypass Federated Authentication</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.db2high.DB2Manager#getCatalogingAllowedWithoutAuthority <em>Cataloging Allowed Without Authority</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.db2high.DB2Manager#getClientIOBlockSize <em>Client IO Block Size</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.db2high.DB2Manager#getClientKerberosPlugin <em>Client Kerberos Plugin</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.db2high.DB2Manager#getClientUseridPasswordPlugin <em>Client Userid Password Plugin</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.db2high.DB2Manager#getCommunicationsBandwidth <em>Communications Bandwidth</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.db2high.DB2Manager#getConfigurationFileReleaseLevel <em>Configuration File Release Level</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.db2high.DB2Manager#getConnectionElapseTime <em>Connection Elapse Time</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.db2high.DB2Manager#getCPUSpeed <em>CPU Speed</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.db2high.DB2Manager#getDatabaseSystemMonitorHeapSize <em>Database System Monitor Heap Size</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.db2high.DB2Manager#getDefaultChargeBackAccount <em>Default Charge Back Account</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.db2high.DB2Manager#getDefaultDatabasePath <em>Default Database Path</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.db2high.DB2Manager#getDefaultDatabaseSystemMonitorSwitches <em>Default Database System Monitor Switches</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.db2high.DB2Manager#getDiagnosticDataDirectoryPath <em>Diagnostic Data Directory Path</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.db2high.DB2Manager#getDiagnosticErrorCaptureLevel <em>Diagnostic Error Capture Level</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.db2high.DB2Manager#getDirectoryCacheSupport <em>Directory Cache Support</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.db2high.DB2Manager#getDiscoverServerInstance <em>Discover Server Instance</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.db2high.DB2Manager#getDiscoveryMode <em>Discovery Mode</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.db2high.DB2Manager#getEnablePntrapartitionParallelism <em>Enable Pntrapartition Parallelism</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.db2high.DB2Manager#getFederatedDatabaseSystemSupport <em>Federated Database System Support</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.db2high.DB2Manager#getGroupPlugin <em>Group Plugin</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.db2high.DB2Manager#getHealthMonitoring <em>Health Monitoring</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.db2high.DB2Manager#getIndexRecreationTime <em>Index Recreation Time</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.db2high.DB2Manager#getInitialNumberOfAgentsInPool <em>Initial Number Of Agents In Pool</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.db2high.DB2Manager#getInitialNumberOfFencedProcesses <em>Initial Number Of Fenced Processes</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.db2high.DB2Manager#getInstanceImpactPolicy <em>Instance Impact Policy</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.db2high.DB2Manager#getInstanceMemory <em>Instance Memory</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.db2high.DB2Manager#getKeepFencedProcess <em>Keep Fenced Process</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.db2high.DB2Manager#getListOfGSSAPIPluginsForIncomingConnections <em>List Of GSSAPI Plugins For Incoming Connections</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.db2high.DB2Manager#getLocalGSSAPIPlugin <em>Local GSSAPI Plugin</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.db2high.DB2Manager#getMachineNodeType <em>Machine Node Type</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.db2high.DB2Manager#getMaximumAsynchronousTQsPerQuery <em>Maximum Asynchronous TQs Per Query</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.db2high.DB2Manager#getMaximumJavaInterpreterHeapSize <em>Maximum Java Interpreter Heap Size</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.db2high.DB2Manager#getMaximumNumberOfAgents <em>Maximum Number Of Agents</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.db2high.DB2Manager#getMaximumNumberOfClientConnections <em>Maximum Number Of Client Connections</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.db2high.DB2Manager#getMaximumNumberOfConcurrentAgents <em>Maximum Number Of Concurrent Agents</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.db2high.DB2Manager#getMaximumNumberOfConcurrentlyActiveDatabases <em>Maximum Number Of Concurrently Active Databases</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.db2high.DB2Manager#getMaximumNumberOfCoordinatingAgents <em>Maximum Number Of Coordinating Agents</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.db2high.DB2Manager#getMaximumNumberOfFencedProcesses <em>Maximum Number Of Fenced Processes</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.db2high.DB2Manager#getMaximumQueryDegreeOfParallelism <em>Maximum Query Degree Of Parallelism</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.db2high.DB2Manager#getMaximumTimeDifferenceAmongNodes <em>Maximum Time Difference Among Nodes</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.db2high.DB2Manager#getNodeConnectionRetries <em>Node Connection Retries</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.db2high.DB2Manager#getNotifyLevel <em>Notify Level</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.db2high.DB2Manager#getNumberOfFCMBuffers <em>Number Of FCM Buffers</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.db2high.DB2Manager#getNumberOfFCMChannels <em>Number Of FCM Channels</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.db2high.DB2Manager#getQueryHeapSize <em>Query Heap Size</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.db2high.DB2Manager#getServerPluginMode <em>Server Plugin Mode</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.db2high.DB2Manager#getSoftwareDevelopersKitForJavaInstallationPath <em>Software Developers Kit For Java Installation Path</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.db2high.DB2Manager#getSortHeapThreshold <em>Sort Heap Threshold</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.db2high.DB2Manager#getStartAndStopTimeout <em>Start And Stop Timeout</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.db2high.DB2Manager#getSyncPointManagerLogFilePath <em>Sync Point Manager Log File Path</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.db2high.DB2Manager#getSyncPointManagerLogFileSize <em>Sync Point Manager Log File Size</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.db2high.DB2Manager#getSyncPointManagerName <em>Sync Point Manager Name</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.db2high.DB2Manager#getSyncPointManagerResyncAgentLimit <em>Sync Point Manager Resync Agent Limit</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.db2high.DB2Manager#getSystemAdministrationAuthorityGroupName <em>System Administration Authority Group Name</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.db2high.DB2Manager#getSystemControlAuthorityGroupName <em>System Control Authority Group Name</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.db2high.DB2Manager#getSystemMaintenanceAuthorityGroupName <em>System Maintenance Authority Group Name</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.db2high.DB2Manager#getSystemMonitorAuthorityGroupName <em>System Monitor Authority Group Name</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.db2high.DB2Manager#getTCPIPServiceName <em>TCPIP Service Name</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.db2high.DB2Manager#getTransactionManagerDatabaseName <em>Transaction Manager Database Name</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.db2high.DB2Manager#getTransactionProcessorMonitorName <em>Transaction Processor Monitor Name</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.db2high.DB2Manager#getTransactionResyncInterval <em>Transaction Resync Interval</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.db2high.DB2Manager#getTrustAllClients <em>Trust All Clients</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.db2high.DB2Manager#getTrustedClientsAuthentication <em>Trusted Clients Authentication</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.db2high.DB2Manager#getUseridPasswordPlugIn <em>Userid Password Plug In</em>}</li>
 * </ul>
 * </p>
 *
 * @see com.ibm.ccl.soa.deploy.db2high.Db2highPackage#getDB2Manager()
 * @model extendedMetaData="name='DB2Manager' kind='elementOnly'"
 * @generated
 */
public interface DB2Manager extends Capability {
	/**
	 * Returns the value of the '<em><b>Agent Pool Size</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Agent Pool Size</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Agent Pool Size</em>' attribute.
	 * @see #setAgentPoolSize(String)
	 * @see com.ibm.ccl.soa.deploy.db2high.Db2highPackage#getDB2Manager_AgentPoolSize()
	 * @model dataType="org.eclipse.emf.ecore.xml.type.String"
	 *        extendedMetaData="kind='attribute' name='AgentPoolSize'"
	 * @generated
	 */
	String getAgentPoolSize();

	/**
	 * Sets the value of the '{@link com.ibm.ccl.soa.deploy.db2high.DB2Manager#getAgentPoolSize <em>Agent Pool Size</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Agent Pool Size</em>' attribute.
	 * @see #getAgentPoolSize()
	 * @generated
	 */
	void setAgentPoolSize(String value);

	/**
	 * Returns the value of the '<em><b>Agent Priority</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Agent Priority</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Agent Priority</em>' attribute.
	 * @see #setAgentPriority(String)
	 * @see com.ibm.ccl.soa.deploy.db2high.Db2highPackage#getDB2Manager_AgentPriority()
	 * @model dataType="org.eclipse.emf.ecore.xml.type.String"
	 *        extendedMetaData="kind='attribute' name='AgentPriority'"
	 * @generated
	 */
	String getAgentPriority();

	/**
	 * Sets the value of the '{@link com.ibm.ccl.soa.deploy.db2high.DB2Manager#getAgentPriority <em>Agent Priority</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Agent Priority</em>' attribute.
	 * @see #getAgentPriority()
	 * @generated
	 */
	void setAgentPriority(String value);

	/**
	 * Returns the value of the '<em><b>Agent Stack Size</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Agent Stack Size</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Agent Stack Size</em>' attribute.
	 * @see #setAgentStackSize(String)
	 * @see com.ibm.ccl.soa.deploy.db2high.Db2highPackage#getDB2Manager_AgentStackSize()
	 * @model dataType="org.eclipse.emf.ecore.xml.type.String"
	 *        extendedMetaData="kind='attribute' name='AgentStackSize'"
	 * @generated
	 */
	String getAgentStackSize();

	/**
	 * Sets the value of the '{@link com.ibm.ccl.soa.deploy.db2high.DB2Manager#getAgentStackSize <em>Agent Stack Size</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Agent Stack Size</em>' attribute.
	 * @see #getAgentStackSize()
	 * @generated
	 */
	void setAgentStackSize(String value);

	/**
	 * Returns the value of the '<em><b>Application Support Layer Heap Size</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Application Support Layer Heap Size</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Application Support Layer Heap Size</em>' attribute.
	 * @see #setApplicationSupportLayerHeapSize(String)
	 * @see com.ibm.ccl.soa.deploy.db2high.Db2highPackage#getDB2Manager_ApplicationSupportLayerHeapSize()
	 * @model dataType="org.eclipse.emf.ecore.xml.type.String"
	 *        extendedMetaData="kind='attribute' name='ApplicationSupportLayerHeapSize'"
	 * @generated
	 */
	String getApplicationSupportLayerHeapSize();

	/**
	 * Sets the value of the '{@link com.ibm.ccl.soa.deploy.db2high.DB2Manager#getApplicationSupportLayerHeapSize <em>Application Support Layer Heap Size</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Application Support Layer Heap Size</em>' attribute.
	 * @see #getApplicationSupportLayerHeapSize()
	 * @generated
	 */
	void setApplicationSupportLayerHeapSize(String value);

	/**
	 * Returns the value of the '<em><b>Audit Buffer Size</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Audit Buffer Size</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Audit Buffer Size</em>' attribute.
	 * @see #setAuditBufferSize(String)
	 * @see com.ibm.ccl.soa.deploy.db2high.Db2highPackage#getDB2Manager_AuditBufferSize()
	 * @model dataType="org.eclipse.emf.ecore.xml.type.String"
	 *        extendedMetaData="kind='attribute' name='AuditBufferSize'"
	 * @generated
	 */
	String getAuditBufferSize();

	/**
	 * Sets the value of the '{@link com.ibm.ccl.soa.deploy.db2high.DB2Manager#getAuditBufferSize <em>Audit Buffer Size</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Audit Buffer Size</em>' attribute.
	 * @see #getAuditBufferSize()
	 * @generated
	 */
	void setAuditBufferSize(String value);

	/**
	 * Returns the value of the '<em><b>Authentication Type</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Authentication Type</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Authentication Type</em>' attribute.
	 * @see #setAuthenticationType(String)
	 * @see com.ibm.ccl.soa.deploy.db2high.Db2highPackage#getDB2Manager_AuthenticationType()
	 * @model dataType="org.eclipse.emf.ecore.xml.type.String"
	 *        extendedMetaData="kind='attribute' name='AuthenticationType'"
	 * @generated
	 */
	String getAuthenticationType();

	/**
	 * Sets the value of the '{@link com.ibm.ccl.soa.deploy.db2high.DB2Manager#getAuthenticationType <em>Authentication Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Authentication Type</em>' attribute.
	 * @see #getAuthenticationType()
	 * @generated
	 */
	void setAuthenticationType(String value);

	/**
	 * Returns the value of the '<em><b>Authentication Type For Incoming Connections</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Authentication Type For Incoming Connections</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Authentication Type For Incoming Connections</em>' attribute.
	 * @see #setAuthenticationTypeForIncomingConnections(String)
	 * @see com.ibm.ccl.soa.deploy.db2high.Db2highPackage#getDB2Manager_AuthenticationTypeForIncomingConnections()
	 * @model dataType="org.eclipse.emf.ecore.xml.type.String"
	 *        extendedMetaData="kind='attribute' name='AuthenticationTypeForIncomingConnections'"
	 * @generated
	 */
	String getAuthenticationTypeForIncomingConnections();

	/**
	 * Sets the value of the '{@link com.ibm.ccl.soa.deploy.db2high.DB2Manager#getAuthenticationTypeForIncomingConnections <em>Authentication Type For Incoming Connections</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Authentication Type For Incoming Connections</em>' attribute.
	 * @see #getAuthenticationTypeForIncomingConnections()
	 * @generated
	 */
	void setAuthenticationTypeForIncomingConnections(String value);

	/**
	 * Returns the value of the '<em><b>Bypass Federated Authentication</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Bypass Federated Authentication</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Bypass Federated Authentication</em>' attribute.
	 * @see #setBypassFederatedAuthentication(String)
	 * @see com.ibm.ccl.soa.deploy.db2high.Db2highPackage#getDB2Manager_BypassFederatedAuthentication()
	 * @model dataType="org.eclipse.emf.ecore.xml.type.String"
	 *        extendedMetaData="kind='attribute' name='BypassFederatedAuthentication'"
	 * @generated
	 */
	String getBypassFederatedAuthentication();

	/**
	 * Sets the value of the '{@link com.ibm.ccl.soa.deploy.db2high.DB2Manager#getBypassFederatedAuthentication <em>Bypass Federated Authentication</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Bypass Federated Authentication</em>' attribute.
	 * @see #getBypassFederatedAuthentication()
	 * @generated
	 */
	void setBypassFederatedAuthentication(String value);

	/**
	 * Returns the value of the '<em><b>Cataloging Allowed Without Authority</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Cataloging Allowed Without Authority</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Cataloging Allowed Without Authority</em>' attribute.
	 * @see #setCatalogingAllowedWithoutAuthority(String)
	 * @see com.ibm.ccl.soa.deploy.db2high.Db2highPackage#getDB2Manager_CatalogingAllowedWithoutAuthority()
	 * @model dataType="org.eclipse.emf.ecore.xml.type.String"
	 *        extendedMetaData="kind='attribute' name='CatalogingAllowedWithoutAuthority'"
	 * @generated
	 */
	String getCatalogingAllowedWithoutAuthority();

	/**
	 * Sets the value of the '{@link com.ibm.ccl.soa.deploy.db2high.DB2Manager#getCatalogingAllowedWithoutAuthority <em>Cataloging Allowed Without Authority</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Cataloging Allowed Without Authority</em>' attribute.
	 * @see #getCatalogingAllowedWithoutAuthority()
	 * @generated
	 */
	void setCatalogingAllowedWithoutAuthority(String value);

	/**
	 * Returns the value of the '<em><b>Client IO Block Size</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Client IO Block Size</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Client IO Block Size</em>' attribute.
	 * @see #setClientIOBlockSize(String)
	 * @see com.ibm.ccl.soa.deploy.db2high.Db2highPackage#getDB2Manager_ClientIOBlockSize()
	 * @model dataType="org.eclipse.emf.ecore.xml.type.String"
	 *        extendedMetaData="kind='attribute' name='ClientIOBlockSize'"
	 * @generated
	 */
	String getClientIOBlockSize();

	/**
	 * Sets the value of the '{@link com.ibm.ccl.soa.deploy.db2high.DB2Manager#getClientIOBlockSize <em>Client IO Block Size</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Client IO Block Size</em>' attribute.
	 * @see #getClientIOBlockSize()
	 * @generated
	 */
	void setClientIOBlockSize(String value);

	/**
	 * Returns the value of the '<em><b>Client Kerberos Plugin</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Client Kerberos Plugin</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Client Kerberos Plugin</em>' attribute.
	 * @see #setClientKerberosPlugin(String)
	 * @see com.ibm.ccl.soa.deploy.db2high.Db2highPackage#getDB2Manager_ClientKerberosPlugin()
	 * @model dataType="org.eclipse.emf.ecore.xml.type.String"
	 *        extendedMetaData="kind='attribute' name='ClientKerberosPlugin'"
	 * @generated
	 */
	String getClientKerberosPlugin();

	/**
	 * Sets the value of the '{@link com.ibm.ccl.soa.deploy.db2high.DB2Manager#getClientKerberosPlugin <em>Client Kerberos Plugin</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Client Kerberos Plugin</em>' attribute.
	 * @see #getClientKerberosPlugin()
	 * @generated
	 */
	void setClientKerberosPlugin(String value);

	/**
	 * Returns the value of the '<em><b>Client Userid Password Plugin</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Client Userid Password Plugin</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Client Userid Password Plugin</em>' attribute.
	 * @see #setClientUseridPasswordPlugin(String)
	 * @see com.ibm.ccl.soa.deploy.db2high.Db2highPackage#getDB2Manager_ClientUseridPasswordPlugin()
	 * @model dataType="org.eclipse.emf.ecore.xml.type.String"
	 *        extendedMetaData="kind='attribute' name='ClientUseridPasswordPlugin'"
	 * @generated
	 */
	String getClientUseridPasswordPlugin();

	/**
	 * Sets the value of the '{@link com.ibm.ccl.soa.deploy.db2high.DB2Manager#getClientUseridPasswordPlugin <em>Client Userid Password Plugin</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Client Userid Password Plugin</em>' attribute.
	 * @see #getClientUseridPasswordPlugin()
	 * @generated
	 */
	void setClientUseridPasswordPlugin(String value);

	/**
	 * Returns the value of the '<em><b>Communications Bandwidth</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Communications Bandwidth</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Communications Bandwidth</em>' attribute.
	 * @see #setCommunicationsBandwidth(String)
	 * @see com.ibm.ccl.soa.deploy.db2high.Db2highPackage#getDB2Manager_CommunicationsBandwidth()
	 * @model dataType="org.eclipse.emf.ecore.xml.type.String"
	 *        extendedMetaData="kind='attribute' name='CommunicationsBandwidth'"
	 * @generated
	 */
	String getCommunicationsBandwidth();

	/**
	 * Sets the value of the '{@link com.ibm.ccl.soa.deploy.db2high.DB2Manager#getCommunicationsBandwidth <em>Communications Bandwidth</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Communications Bandwidth</em>' attribute.
	 * @see #getCommunicationsBandwidth()
	 * @generated
	 */
	void setCommunicationsBandwidth(String value);

	/**
	 * Returns the value of the '<em><b>Configuration File Release Level</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Configuration File Release Level</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Configuration File Release Level</em>' attribute.
	 * @see #setConfigurationFileReleaseLevel(String)
	 * @see com.ibm.ccl.soa.deploy.db2high.Db2highPackage#getDB2Manager_ConfigurationFileReleaseLevel()
	 * @model dataType="org.eclipse.emf.ecore.xml.type.String"
	 *        extendedMetaData="kind='attribute' name='ConfigurationFileReleaseLevel'"
	 * @generated
	 */
	String getConfigurationFileReleaseLevel();

	/**
	 * Sets the value of the '{@link com.ibm.ccl.soa.deploy.db2high.DB2Manager#getConfigurationFileReleaseLevel <em>Configuration File Release Level</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Configuration File Release Level</em>' attribute.
	 * @see #getConfigurationFileReleaseLevel()
	 * @generated
	 */
	void setConfigurationFileReleaseLevel(String value);

	/**
	 * Returns the value of the '<em><b>Connection Elapse Time</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Connection Elapse Time</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Connection Elapse Time</em>' attribute.
	 * @see #setConnectionElapseTime(String)
	 * @see com.ibm.ccl.soa.deploy.db2high.Db2highPackage#getDB2Manager_ConnectionElapseTime()
	 * @model dataType="org.eclipse.emf.ecore.xml.type.String"
	 *        extendedMetaData="kind='attribute' name='ConnectionElapseTime'"
	 * @generated
	 */
	String getConnectionElapseTime();

	/**
	 * Sets the value of the '{@link com.ibm.ccl.soa.deploy.db2high.DB2Manager#getConnectionElapseTime <em>Connection Elapse Time</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Connection Elapse Time</em>' attribute.
	 * @see #getConnectionElapseTime()
	 * @generated
	 */
	void setConnectionElapseTime(String value);

	/**
	 * Returns the value of the '<em><b>CPU Speed</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>CPU Speed</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>CPU Speed</em>' attribute.
	 * @see #setCPUSpeed(String)
	 * @see com.ibm.ccl.soa.deploy.db2high.Db2highPackage#getDB2Manager_CPUSpeed()
	 * @model dataType="org.eclipse.emf.ecore.xml.type.String"
	 *        extendedMetaData="kind='attribute' name='CPUSpeed'"
	 * @generated
	 */
	String getCPUSpeed();

	/**
	 * Sets the value of the '{@link com.ibm.ccl.soa.deploy.db2high.DB2Manager#getCPUSpeed <em>CPU Speed</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>CPU Speed</em>' attribute.
	 * @see #getCPUSpeed()
	 * @generated
	 */
	void setCPUSpeed(String value);

	/**
	 * Returns the value of the '<em><b>Database System Monitor Heap Size</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Database System Monitor Heap Size</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Database System Monitor Heap Size</em>' attribute.
	 * @see #setDatabaseSystemMonitorHeapSize(String)
	 * @see com.ibm.ccl.soa.deploy.db2high.Db2highPackage#getDB2Manager_DatabaseSystemMonitorHeapSize()
	 * @model dataType="org.eclipse.emf.ecore.xml.type.String"
	 *        extendedMetaData="kind='attribute' name='DatabaseSystemMonitorHeapSize'"
	 * @generated
	 */
	String getDatabaseSystemMonitorHeapSize();

	/**
	 * Sets the value of the '{@link com.ibm.ccl.soa.deploy.db2high.DB2Manager#getDatabaseSystemMonitorHeapSize <em>Database System Monitor Heap Size</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Database System Monitor Heap Size</em>' attribute.
	 * @see #getDatabaseSystemMonitorHeapSize()
	 * @generated
	 */
	void setDatabaseSystemMonitorHeapSize(String value);

	/**
	 * Returns the value of the '<em><b>Default Charge Back Account</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Default Charge Back Account</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Default Charge Back Account</em>' attribute.
	 * @see #setDefaultChargeBackAccount(String)
	 * @see com.ibm.ccl.soa.deploy.db2high.Db2highPackage#getDB2Manager_DefaultChargeBackAccount()
	 * @model dataType="org.eclipse.emf.ecore.xml.type.String"
	 *        extendedMetaData="kind='attribute' name='DefaultChargeBackAccount'"
	 * @generated
	 */
	String getDefaultChargeBackAccount();

	/**
	 * Sets the value of the '{@link com.ibm.ccl.soa.deploy.db2high.DB2Manager#getDefaultChargeBackAccount <em>Default Charge Back Account</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Default Charge Back Account</em>' attribute.
	 * @see #getDefaultChargeBackAccount()
	 * @generated
	 */
	void setDefaultChargeBackAccount(String value);

	/**
	 * Returns the value of the '<em><b>Default Database Path</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Default Database Path</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Default Database Path</em>' attribute.
	 * @see #setDefaultDatabasePath(String)
	 * @see com.ibm.ccl.soa.deploy.db2high.Db2highPackage#getDB2Manager_DefaultDatabasePath()
	 * @model dataType="org.eclipse.emf.ecore.xml.type.String"
	 *        extendedMetaData="kind='attribute' name='DefaultDatabasePath'"
	 * @generated
	 */
	String getDefaultDatabasePath();

	/**
	 * Sets the value of the '{@link com.ibm.ccl.soa.deploy.db2high.DB2Manager#getDefaultDatabasePath <em>Default Database Path</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Default Database Path</em>' attribute.
	 * @see #getDefaultDatabasePath()
	 * @generated
	 */
	void setDefaultDatabasePath(String value);

	/**
	 * Returns the value of the '<em><b>Default Database System Monitor Switches</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Default Database System Monitor Switches</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Default Database System Monitor Switches</em>' attribute.
	 * @see #setDefaultDatabaseSystemMonitorSwitches(String)
	 * @see com.ibm.ccl.soa.deploy.db2high.Db2highPackage#getDB2Manager_DefaultDatabaseSystemMonitorSwitches()
	 * @model dataType="org.eclipse.emf.ecore.xml.type.String"
	 *        extendedMetaData="kind='attribute' name='DefaultDatabaseSystemMonitorSwitches'"
	 * @generated
	 */
	String getDefaultDatabaseSystemMonitorSwitches();

	/**
	 * Sets the value of the '{@link com.ibm.ccl.soa.deploy.db2high.DB2Manager#getDefaultDatabaseSystemMonitorSwitches <em>Default Database System Monitor Switches</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Default Database System Monitor Switches</em>' attribute.
	 * @see #getDefaultDatabaseSystemMonitorSwitches()
	 * @generated
	 */
	void setDefaultDatabaseSystemMonitorSwitches(String value);

	/**
	 * Returns the value of the '<em><b>Diagnostic Data Directory Path</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Diagnostic Data Directory Path</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Diagnostic Data Directory Path</em>' attribute.
	 * @see #setDiagnosticDataDirectoryPath(String)
	 * @see com.ibm.ccl.soa.deploy.db2high.Db2highPackage#getDB2Manager_DiagnosticDataDirectoryPath()
	 * @model dataType="org.eclipse.emf.ecore.xml.type.String"
	 *        extendedMetaData="kind='attribute' name='DiagnosticDataDirectoryPath'"
	 * @generated
	 */
	String getDiagnosticDataDirectoryPath();

	/**
	 * Sets the value of the '{@link com.ibm.ccl.soa.deploy.db2high.DB2Manager#getDiagnosticDataDirectoryPath <em>Diagnostic Data Directory Path</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Diagnostic Data Directory Path</em>' attribute.
	 * @see #getDiagnosticDataDirectoryPath()
	 * @generated
	 */
	void setDiagnosticDataDirectoryPath(String value);

	/**
	 * Returns the value of the '<em><b>Diagnostic Error Capture Level</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Diagnostic Error Capture Level</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Diagnostic Error Capture Level</em>' attribute.
	 * @see #setDiagnosticErrorCaptureLevel(String)
	 * @see com.ibm.ccl.soa.deploy.db2high.Db2highPackage#getDB2Manager_DiagnosticErrorCaptureLevel()
	 * @model dataType="org.eclipse.emf.ecore.xml.type.String"
	 *        extendedMetaData="kind='attribute' name='DiagnosticErrorCaptureLevel'"
	 * @generated
	 */
	String getDiagnosticErrorCaptureLevel();

	/**
	 * Sets the value of the '{@link com.ibm.ccl.soa.deploy.db2high.DB2Manager#getDiagnosticErrorCaptureLevel <em>Diagnostic Error Capture Level</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Diagnostic Error Capture Level</em>' attribute.
	 * @see #getDiagnosticErrorCaptureLevel()
	 * @generated
	 */
	void setDiagnosticErrorCaptureLevel(String value);

	/**
	 * Returns the value of the '<em><b>Directory Cache Support</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Directory Cache Support</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Directory Cache Support</em>' attribute.
	 * @see #setDirectoryCacheSupport(String)
	 * @see com.ibm.ccl.soa.deploy.db2high.Db2highPackage#getDB2Manager_DirectoryCacheSupport()
	 * @model dataType="org.eclipse.emf.ecore.xml.type.String"
	 *        extendedMetaData="kind='attribute' name='DirectoryCacheSupport'"
	 * @generated
	 */
	String getDirectoryCacheSupport();

	/**
	 * Sets the value of the '{@link com.ibm.ccl.soa.deploy.db2high.DB2Manager#getDirectoryCacheSupport <em>Directory Cache Support</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Directory Cache Support</em>' attribute.
	 * @see #getDirectoryCacheSupport()
	 * @generated
	 */
	void setDirectoryCacheSupport(String value);

	/**
	 * Returns the value of the '<em><b>Discover Server Instance</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Discover Server Instance</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Discover Server Instance</em>' attribute.
	 * @see #setDiscoverServerInstance(String)
	 * @see com.ibm.ccl.soa.deploy.db2high.Db2highPackage#getDB2Manager_DiscoverServerInstance()
	 * @model dataType="org.eclipse.emf.ecore.xml.type.String"
	 *        extendedMetaData="kind='attribute' name='DiscoverServerInstance'"
	 * @generated
	 */
	String getDiscoverServerInstance();

	/**
	 * Sets the value of the '{@link com.ibm.ccl.soa.deploy.db2high.DB2Manager#getDiscoverServerInstance <em>Discover Server Instance</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Discover Server Instance</em>' attribute.
	 * @see #getDiscoverServerInstance()
	 * @generated
	 */
	void setDiscoverServerInstance(String value);

	/**
	 * Returns the value of the '<em><b>Discovery Mode</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Discovery Mode</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Discovery Mode</em>' attribute.
	 * @see #setDiscoveryMode(String)
	 * @see com.ibm.ccl.soa.deploy.db2high.Db2highPackage#getDB2Manager_DiscoveryMode()
	 * @model dataType="org.eclipse.emf.ecore.xml.type.String"
	 *        extendedMetaData="kind='attribute' name='DiscoveryMode'"
	 * @generated
	 */
	String getDiscoveryMode();

	/**
	 * Sets the value of the '{@link com.ibm.ccl.soa.deploy.db2high.DB2Manager#getDiscoveryMode <em>Discovery Mode</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Discovery Mode</em>' attribute.
	 * @see #getDiscoveryMode()
	 * @generated
	 */
	void setDiscoveryMode(String value);

	/**
	 * Returns the value of the '<em><b>Enable Pntrapartition Parallelism</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Enable Pntrapartition Parallelism</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Enable Pntrapartition Parallelism</em>' attribute.
	 * @see #setEnablePntrapartitionParallelism(String)
	 * @see com.ibm.ccl.soa.deploy.db2high.Db2highPackage#getDB2Manager_EnablePntrapartitionParallelism()
	 * @model dataType="org.eclipse.emf.ecore.xml.type.String"
	 *        extendedMetaData="kind='attribute' name='EnablePntrapartitionParallelism'"
	 * @generated
	 */
	String getEnablePntrapartitionParallelism();

	/**
	 * Sets the value of the '{@link com.ibm.ccl.soa.deploy.db2high.DB2Manager#getEnablePntrapartitionParallelism <em>Enable Pntrapartition Parallelism</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Enable Pntrapartition Parallelism</em>' attribute.
	 * @see #getEnablePntrapartitionParallelism()
	 * @generated
	 */
	void setEnablePntrapartitionParallelism(String value);

	/**
	 * Returns the value of the '<em><b>Federated Database System Support</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Federated Database System Support</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Federated Database System Support</em>' attribute.
	 * @see #setFederatedDatabaseSystemSupport(String)
	 * @see com.ibm.ccl.soa.deploy.db2high.Db2highPackage#getDB2Manager_FederatedDatabaseSystemSupport()
	 * @model dataType="org.eclipse.emf.ecore.xml.type.String"
	 *        extendedMetaData="kind='attribute' name='FederatedDatabaseSystemSupport'"
	 * @generated
	 */
	String getFederatedDatabaseSystemSupport();

	/**
	 * Sets the value of the '{@link com.ibm.ccl.soa.deploy.db2high.DB2Manager#getFederatedDatabaseSystemSupport <em>Federated Database System Support</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Federated Database System Support</em>' attribute.
	 * @see #getFederatedDatabaseSystemSupport()
	 * @generated
	 */
	void setFederatedDatabaseSystemSupport(String value);

	/**
	 * Returns the value of the '<em><b>Group Plugin</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Group Plugin</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Group Plugin</em>' attribute.
	 * @see #setGroupPlugin(String)
	 * @see com.ibm.ccl.soa.deploy.db2high.Db2highPackage#getDB2Manager_GroupPlugin()
	 * @model dataType="org.eclipse.emf.ecore.xml.type.String"
	 *        extendedMetaData="kind='attribute' name='GroupPlugin'"
	 * @generated
	 */
	String getGroupPlugin();

	/**
	 * Sets the value of the '{@link com.ibm.ccl.soa.deploy.db2high.DB2Manager#getGroupPlugin <em>Group Plugin</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Group Plugin</em>' attribute.
	 * @see #getGroupPlugin()
	 * @generated
	 */
	void setGroupPlugin(String value);

	/**
	 * Returns the value of the '<em><b>Health Monitoring</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Health Monitoring</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Health Monitoring</em>' attribute.
	 * @see #setHealthMonitoring(String)
	 * @see com.ibm.ccl.soa.deploy.db2high.Db2highPackage#getDB2Manager_HealthMonitoring()
	 * @model dataType="org.eclipse.emf.ecore.xml.type.String"
	 *        extendedMetaData="kind='attribute' name='HealthMonitoring'"
	 * @generated
	 */
	String getHealthMonitoring();

	/**
	 * Sets the value of the '{@link com.ibm.ccl.soa.deploy.db2high.DB2Manager#getHealthMonitoring <em>Health Monitoring</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Health Monitoring</em>' attribute.
	 * @see #getHealthMonitoring()
	 * @generated
	 */
	void setHealthMonitoring(String value);

	/**
	 * Returns the value of the '<em><b>Index Recreation Time</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Index Recreation Time</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Index Recreation Time</em>' attribute.
	 * @see #setIndexRecreationTime(String)
	 * @see com.ibm.ccl.soa.deploy.db2high.Db2highPackage#getDB2Manager_IndexRecreationTime()
	 * @model dataType="org.eclipse.emf.ecore.xml.type.String"
	 *        extendedMetaData="kind='attribute' name='IndexRecreationTime'"
	 * @generated
	 */
	String getIndexRecreationTime();

	/**
	 * Sets the value of the '{@link com.ibm.ccl.soa.deploy.db2high.DB2Manager#getIndexRecreationTime <em>Index Recreation Time</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Index Recreation Time</em>' attribute.
	 * @see #getIndexRecreationTime()
	 * @generated
	 */
	void setIndexRecreationTime(String value);

	/**
	 * Returns the value of the '<em><b>Initial Number Of Agents In Pool</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Initial Number Of Agents In Pool</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Initial Number Of Agents In Pool</em>' attribute.
	 * @see #setInitialNumberOfAgentsInPool(String)
	 * @see com.ibm.ccl.soa.deploy.db2high.Db2highPackage#getDB2Manager_InitialNumberOfAgentsInPool()
	 * @model dataType="org.eclipse.emf.ecore.xml.type.String"
	 *        extendedMetaData="kind='attribute' name='InitialNumberOfAgentsInPool'"
	 * @generated
	 */
	String getInitialNumberOfAgentsInPool();

	/**
	 * Sets the value of the '{@link com.ibm.ccl.soa.deploy.db2high.DB2Manager#getInitialNumberOfAgentsInPool <em>Initial Number Of Agents In Pool</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Initial Number Of Agents In Pool</em>' attribute.
	 * @see #getInitialNumberOfAgentsInPool()
	 * @generated
	 */
	void setInitialNumberOfAgentsInPool(String value);

	/**
	 * Returns the value of the '<em><b>Initial Number Of Fenced Processes</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Initial Number Of Fenced Processes</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Initial Number Of Fenced Processes</em>' attribute.
	 * @see #setInitialNumberOfFencedProcesses(String)
	 * @see com.ibm.ccl.soa.deploy.db2high.Db2highPackage#getDB2Manager_InitialNumberOfFencedProcesses()
	 * @model dataType="org.eclipse.emf.ecore.xml.type.String"
	 *        extendedMetaData="kind='attribute' name='InitialNumberOfFencedProcesses'"
	 * @generated
	 */
	String getInitialNumberOfFencedProcesses();

	/**
	 * Sets the value of the '{@link com.ibm.ccl.soa.deploy.db2high.DB2Manager#getInitialNumberOfFencedProcesses <em>Initial Number Of Fenced Processes</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Initial Number Of Fenced Processes</em>' attribute.
	 * @see #getInitialNumberOfFencedProcesses()
	 * @generated
	 */
	void setInitialNumberOfFencedProcesses(String value);

	/**
	 * Returns the value of the '<em><b>Instance Impact Policy</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Instance Impact Policy</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Instance Impact Policy</em>' attribute.
	 * @see #setInstanceImpactPolicy(String)
	 * @see com.ibm.ccl.soa.deploy.db2high.Db2highPackage#getDB2Manager_InstanceImpactPolicy()
	 * @model dataType="org.eclipse.emf.ecore.xml.type.String"
	 *        extendedMetaData="kind='attribute' name='InstanceImpactPolicy'"
	 * @generated
	 */
	String getInstanceImpactPolicy();

	/**
	 * Sets the value of the '{@link com.ibm.ccl.soa.deploy.db2high.DB2Manager#getInstanceImpactPolicy <em>Instance Impact Policy</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Instance Impact Policy</em>' attribute.
	 * @see #getInstanceImpactPolicy()
	 * @generated
	 */
	void setInstanceImpactPolicy(String value);

	/**
	 * Returns the value of the '<em><b>Instance Memory</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Instance Memory</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Instance Memory</em>' attribute.
	 * @see #setInstanceMemory(String)
	 * @see com.ibm.ccl.soa.deploy.db2high.Db2highPackage#getDB2Manager_InstanceMemory()
	 * @model dataType="org.eclipse.emf.ecore.xml.type.String"
	 *        extendedMetaData="kind='attribute' name='InstanceMemory'"
	 * @generated
	 */
	String getInstanceMemory();

	/**
	 * Sets the value of the '{@link com.ibm.ccl.soa.deploy.db2high.DB2Manager#getInstanceMemory <em>Instance Memory</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Instance Memory</em>' attribute.
	 * @see #getInstanceMemory()
	 * @generated
	 */
	void setInstanceMemory(String value);

	/**
	 * Returns the value of the '<em><b>Keep Fenced Process</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Keep Fenced Process</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Keep Fenced Process</em>' attribute.
	 * @see #setKeepFencedProcess(String)
	 * @see com.ibm.ccl.soa.deploy.db2high.Db2highPackage#getDB2Manager_KeepFencedProcess()
	 * @model dataType="org.eclipse.emf.ecore.xml.type.String"
	 *        extendedMetaData="kind='attribute' name='KeepFencedProcess'"
	 * @generated
	 */
	String getKeepFencedProcess();

	/**
	 * Sets the value of the '{@link com.ibm.ccl.soa.deploy.db2high.DB2Manager#getKeepFencedProcess <em>Keep Fenced Process</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Keep Fenced Process</em>' attribute.
	 * @see #getKeepFencedProcess()
	 * @generated
	 */
	void setKeepFencedProcess(String value);

	/**
	 * Returns the value of the '<em><b>List Of GSSAPI Plugins For Incoming Connections</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>List Of GSSAPI Plugins For Incoming Connections</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>List Of GSSAPI Plugins For Incoming Connections</em>' attribute.
	 * @see #setListOfGSSAPIPluginsForIncomingConnections(String)
	 * @see com.ibm.ccl.soa.deploy.db2high.Db2highPackage#getDB2Manager_ListOfGSSAPIPluginsForIncomingConnections()
	 * @model dataType="org.eclipse.emf.ecore.xml.type.String"
	 *        extendedMetaData="kind='attribute' name='ListOfGSSAPIPluginsForIncomingConnections'"
	 * @generated
	 */
	String getListOfGSSAPIPluginsForIncomingConnections();

	/**
	 * Sets the value of the '{@link com.ibm.ccl.soa.deploy.db2high.DB2Manager#getListOfGSSAPIPluginsForIncomingConnections <em>List Of GSSAPI Plugins For Incoming Connections</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>List Of GSSAPI Plugins For Incoming Connections</em>' attribute.
	 * @see #getListOfGSSAPIPluginsForIncomingConnections()
	 * @generated
	 */
	void setListOfGSSAPIPluginsForIncomingConnections(String value);

	/**
	 * Returns the value of the '<em><b>Local GSSAPI Plugin</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Local GSSAPI Plugin</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Local GSSAPI Plugin</em>' attribute.
	 * @see #setLocalGSSAPIPlugin(String)
	 * @see com.ibm.ccl.soa.deploy.db2high.Db2highPackage#getDB2Manager_LocalGSSAPIPlugin()
	 * @model dataType="org.eclipse.emf.ecore.xml.type.String"
	 *        extendedMetaData="kind='attribute' name='LocalGSSAPIPlugin'"
	 * @generated
	 */
	String getLocalGSSAPIPlugin();

	/**
	 * Sets the value of the '{@link com.ibm.ccl.soa.deploy.db2high.DB2Manager#getLocalGSSAPIPlugin <em>Local GSSAPI Plugin</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Local GSSAPI Plugin</em>' attribute.
	 * @see #getLocalGSSAPIPlugin()
	 * @generated
	 */
	void setLocalGSSAPIPlugin(String value);

	/**
	 * Returns the value of the '<em><b>Machine Node Type</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Machine Node Type</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Machine Node Type</em>' attribute.
	 * @see #setMachineNodeType(String)
	 * @see com.ibm.ccl.soa.deploy.db2high.Db2highPackage#getDB2Manager_MachineNodeType()
	 * @model dataType="org.eclipse.emf.ecore.xml.type.String"
	 *        extendedMetaData="kind='attribute' name='MachineNodeType'"
	 * @generated
	 */
	String getMachineNodeType();

	/**
	 * Sets the value of the '{@link com.ibm.ccl.soa.deploy.db2high.DB2Manager#getMachineNodeType <em>Machine Node Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Machine Node Type</em>' attribute.
	 * @see #getMachineNodeType()
	 * @generated
	 */
	void setMachineNodeType(String value);

	/**
	 * Returns the value of the '<em><b>Maximum Asynchronous TQs Per Query</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Maximum Asynchronous TQs Per Query</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Maximum Asynchronous TQs Per Query</em>' attribute.
	 * @see #setMaximumAsynchronousTQsPerQuery(String)
	 * @see com.ibm.ccl.soa.deploy.db2high.Db2highPackage#getDB2Manager_MaximumAsynchronousTQsPerQuery()
	 * @model dataType="org.eclipse.emf.ecore.xml.type.String"
	 *        extendedMetaData="kind='attribute' name='MaximumAsynchronousTQsPerQuery'"
	 * @generated
	 */
	String getMaximumAsynchronousTQsPerQuery();

	/**
	 * Sets the value of the '{@link com.ibm.ccl.soa.deploy.db2high.DB2Manager#getMaximumAsynchronousTQsPerQuery <em>Maximum Asynchronous TQs Per Query</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Maximum Asynchronous TQs Per Query</em>' attribute.
	 * @see #getMaximumAsynchronousTQsPerQuery()
	 * @generated
	 */
	void setMaximumAsynchronousTQsPerQuery(String value);

	/**
	 * Returns the value of the '<em><b>Maximum Java Interpreter Heap Size</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Maximum Java Interpreter Heap Size</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Maximum Java Interpreter Heap Size</em>' attribute.
	 * @see #setMaximumJavaInterpreterHeapSize(String)
	 * @see com.ibm.ccl.soa.deploy.db2high.Db2highPackage#getDB2Manager_MaximumJavaInterpreterHeapSize()
	 * @model dataType="org.eclipse.emf.ecore.xml.type.String"
	 *        extendedMetaData="kind='attribute' name='MaximumJavaInterpreterHeapSize'"
	 * @generated
	 */
	String getMaximumJavaInterpreterHeapSize();

	/**
	 * Sets the value of the '{@link com.ibm.ccl.soa.deploy.db2high.DB2Manager#getMaximumJavaInterpreterHeapSize <em>Maximum Java Interpreter Heap Size</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Maximum Java Interpreter Heap Size</em>' attribute.
	 * @see #getMaximumJavaInterpreterHeapSize()
	 * @generated
	 */
	void setMaximumJavaInterpreterHeapSize(String value);

	/**
	 * Returns the value of the '<em><b>Maximum Number Of Agents</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Maximum Number Of Agents</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Maximum Number Of Agents</em>' attribute.
	 * @see #setMaximumNumberOfAgents(String)
	 * @see com.ibm.ccl.soa.deploy.db2high.Db2highPackage#getDB2Manager_MaximumNumberOfAgents()
	 * @model dataType="org.eclipse.emf.ecore.xml.type.String"
	 *        extendedMetaData="kind='attribute' name='MaximumNumberOfAgents'"
	 * @generated
	 */
	String getMaximumNumberOfAgents();

	/**
	 * Sets the value of the '{@link com.ibm.ccl.soa.deploy.db2high.DB2Manager#getMaximumNumberOfAgents <em>Maximum Number Of Agents</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Maximum Number Of Agents</em>' attribute.
	 * @see #getMaximumNumberOfAgents()
	 * @generated
	 */
	void setMaximumNumberOfAgents(String value);

	/**
	 * Returns the value of the '<em><b>Maximum Number Of Client Connections</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Maximum Number Of Client Connections</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Maximum Number Of Client Connections</em>' attribute.
	 * @see #setMaximumNumberOfClientConnections(String)
	 * @see com.ibm.ccl.soa.deploy.db2high.Db2highPackage#getDB2Manager_MaximumNumberOfClientConnections()
	 * @model dataType="org.eclipse.emf.ecore.xml.type.String"
	 *        extendedMetaData="kind='attribute' name='MaximumNumberOfClientConnections'"
	 * @generated
	 */
	String getMaximumNumberOfClientConnections();

	/**
	 * Sets the value of the '{@link com.ibm.ccl.soa.deploy.db2high.DB2Manager#getMaximumNumberOfClientConnections <em>Maximum Number Of Client Connections</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Maximum Number Of Client Connections</em>' attribute.
	 * @see #getMaximumNumberOfClientConnections()
	 * @generated
	 */
	void setMaximumNumberOfClientConnections(String value);

	/**
	 * Returns the value of the '<em><b>Maximum Number Of Concurrent Agents</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Maximum Number Of Concurrent Agents</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Maximum Number Of Concurrent Agents</em>' attribute.
	 * @see #setMaximumNumberOfConcurrentAgents(String)
	 * @see com.ibm.ccl.soa.deploy.db2high.Db2highPackage#getDB2Manager_MaximumNumberOfConcurrentAgents()
	 * @model dataType="org.eclipse.emf.ecore.xml.type.String"
	 *        extendedMetaData="kind='attribute' name='MaximumNumberOfConcurrentAgents'"
	 * @generated
	 */
	String getMaximumNumberOfConcurrentAgents();

	/**
	 * Sets the value of the '{@link com.ibm.ccl.soa.deploy.db2high.DB2Manager#getMaximumNumberOfConcurrentAgents <em>Maximum Number Of Concurrent Agents</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Maximum Number Of Concurrent Agents</em>' attribute.
	 * @see #getMaximumNumberOfConcurrentAgents()
	 * @generated
	 */
	void setMaximumNumberOfConcurrentAgents(String value);

	/**
	 * Returns the value of the '<em><b>Maximum Number Of Concurrently Active Databases</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Maximum Number Of Concurrently Active Databases</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Maximum Number Of Concurrently Active Databases</em>' attribute.
	 * @see #setMaximumNumberOfConcurrentlyActiveDatabases(String)
	 * @see com.ibm.ccl.soa.deploy.db2high.Db2highPackage#getDB2Manager_MaximumNumberOfConcurrentlyActiveDatabases()
	 * @model dataType="org.eclipse.emf.ecore.xml.type.String"
	 *        extendedMetaData="kind='attribute' name='MaximumNumberOfConcurrentlyActiveDatabases'"
	 * @generated
	 */
	String getMaximumNumberOfConcurrentlyActiveDatabases();

	/**
	 * Sets the value of the '{@link com.ibm.ccl.soa.deploy.db2high.DB2Manager#getMaximumNumberOfConcurrentlyActiveDatabases <em>Maximum Number Of Concurrently Active Databases</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Maximum Number Of Concurrently Active Databases</em>' attribute.
	 * @see #getMaximumNumberOfConcurrentlyActiveDatabases()
	 * @generated
	 */
	void setMaximumNumberOfConcurrentlyActiveDatabases(String value);

	/**
	 * Returns the value of the '<em><b>Maximum Number Of Coordinating Agents</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Maximum Number Of Coordinating Agents</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Maximum Number Of Coordinating Agents</em>' attribute.
	 * @see #setMaximumNumberOfCoordinatingAgents(String)
	 * @see com.ibm.ccl.soa.deploy.db2high.Db2highPackage#getDB2Manager_MaximumNumberOfCoordinatingAgents()
	 * @model dataType="org.eclipse.emf.ecore.xml.type.String"
	 *        extendedMetaData="kind='attribute' name='MaximumNumberOfCoordinatingAgents'"
	 * @generated
	 */
	String getMaximumNumberOfCoordinatingAgents();

	/**
	 * Sets the value of the '{@link com.ibm.ccl.soa.deploy.db2high.DB2Manager#getMaximumNumberOfCoordinatingAgents <em>Maximum Number Of Coordinating Agents</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Maximum Number Of Coordinating Agents</em>' attribute.
	 * @see #getMaximumNumberOfCoordinatingAgents()
	 * @generated
	 */
	void setMaximumNumberOfCoordinatingAgents(String value);

	/**
	 * Returns the value of the '<em><b>Maximum Number Of Fenced Processes</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Maximum Number Of Fenced Processes</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Maximum Number Of Fenced Processes</em>' attribute.
	 * @see #setMaximumNumberOfFencedProcesses(String)
	 * @see com.ibm.ccl.soa.deploy.db2high.Db2highPackage#getDB2Manager_MaximumNumberOfFencedProcesses()
	 * @model dataType="org.eclipse.emf.ecore.xml.type.String"
	 *        extendedMetaData="kind='attribute' name='MaximumNumberOfFencedProcesses'"
	 * @generated
	 */
	String getMaximumNumberOfFencedProcesses();

	/**
	 * Sets the value of the '{@link com.ibm.ccl.soa.deploy.db2high.DB2Manager#getMaximumNumberOfFencedProcesses <em>Maximum Number Of Fenced Processes</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Maximum Number Of Fenced Processes</em>' attribute.
	 * @see #getMaximumNumberOfFencedProcesses()
	 * @generated
	 */
	void setMaximumNumberOfFencedProcesses(String value);

	/**
	 * Returns the value of the '<em><b>Maximum Query Degree Of Parallelism</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Maximum Query Degree Of Parallelism</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Maximum Query Degree Of Parallelism</em>' attribute.
	 * @see #setMaximumQueryDegreeOfParallelism(String)
	 * @see com.ibm.ccl.soa.deploy.db2high.Db2highPackage#getDB2Manager_MaximumQueryDegreeOfParallelism()
	 * @model dataType="org.eclipse.emf.ecore.xml.type.String"
	 *        extendedMetaData="kind='attribute' name='MaximumQueryDegreeOfParallelism'"
	 * @generated
	 */
	String getMaximumQueryDegreeOfParallelism();

	/**
	 * Sets the value of the '{@link com.ibm.ccl.soa.deploy.db2high.DB2Manager#getMaximumQueryDegreeOfParallelism <em>Maximum Query Degree Of Parallelism</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Maximum Query Degree Of Parallelism</em>' attribute.
	 * @see #getMaximumQueryDegreeOfParallelism()
	 * @generated
	 */
	void setMaximumQueryDegreeOfParallelism(String value);

	/**
	 * Returns the value of the '<em><b>Maximum Time Difference Among Nodes</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Maximum Time Difference Among Nodes</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Maximum Time Difference Among Nodes</em>' attribute.
	 * @see #setMaximumTimeDifferenceAmongNodes(String)
	 * @see com.ibm.ccl.soa.deploy.db2high.Db2highPackage#getDB2Manager_MaximumTimeDifferenceAmongNodes()
	 * @model dataType="org.eclipse.emf.ecore.xml.type.String"
	 *        extendedMetaData="kind='attribute' name='MaximumTimeDifferenceAmongNodes'"
	 * @generated
	 */
	String getMaximumTimeDifferenceAmongNodes();

	/**
	 * Sets the value of the '{@link com.ibm.ccl.soa.deploy.db2high.DB2Manager#getMaximumTimeDifferenceAmongNodes <em>Maximum Time Difference Among Nodes</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Maximum Time Difference Among Nodes</em>' attribute.
	 * @see #getMaximumTimeDifferenceAmongNodes()
	 * @generated
	 */
	void setMaximumTimeDifferenceAmongNodes(String value);

	/**
	 * Returns the value of the '<em><b>Node Connection Retries</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Node Connection Retries</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Node Connection Retries</em>' attribute.
	 * @see #setNodeConnectionRetries(String)
	 * @see com.ibm.ccl.soa.deploy.db2high.Db2highPackage#getDB2Manager_NodeConnectionRetries()
	 * @model dataType="org.eclipse.emf.ecore.xml.type.String"
	 *        extendedMetaData="kind='attribute' name='NodeConnectionRetries'"
	 * @generated
	 */
	String getNodeConnectionRetries();

	/**
	 * Sets the value of the '{@link com.ibm.ccl.soa.deploy.db2high.DB2Manager#getNodeConnectionRetries <em>Node Connection Retries</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Node Connection Retries</em>' attribute.
	 * @see #getNodeConnectionRetries()
	 * @generated
	 */
	void setNodeConnectionRetries(String value);

	/**
	 * Returns the value of the '<em><b>Notify Level</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Notify Level</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Notify Level</em>' attribute.
	 * @see #setNotifyLevel(String)
	 * @see com.ibm.ccl.soa.deploy.db2high.Db2highPackage#getDB2Manager_NotifyLevel()
	 * @model dataType="org.eclipse.emf.ecore.xml.type.String"
	 *        extendedMetaData="kind='attribute' name='NotifyLevel'"
	 * @generated
	 */
	String getNotifyLevel();

	/**
	 * Sets the value of the '{@link com.ibm.ccl.soa.deploy.db2high.DB2Manager#getNotifyLevel <em>Notify Level</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Notify Level</em>' attribute.
	 * @see #getNotifyLevel()
	 * @generated
	 */
	void setNotifyLevel(String value);

	/**
	 * Returns the value of the '<em><b>Number Of FCM Buffers</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Number Of FCM Buffers</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Number Of FCM Buffers</em>' attribute.
	 * @see #setNumberOfFCMBuffers(String)
	 * @see com.ibm.ccl.soa.deploy.db2high.Db2highPackage#getDB2Manager_NumberOfFCMBuffers()
	 * @model dataType="org.eclipse.emf.ecore.xml.type.String"
	 *        extendedMetaData="kind='attribute' name='NumberOfFCMBuffers'"
	 * @generated
	 */
	String getNumberOfFCMBuffers();

	/**
	 * Sets the value of the '{@link com.ibm.ccl.soa.deploy.db2high.DB2Manager#getNumberOfFCMBuffers <em>Number Of FCM Buffers</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Number Of FCM Buffers</em>' attribute.
	 * @see #getNumberOfFCMBuffers()
	 * @generated
	 */
	void setNumberOfFCMBuffers(String value);

	/**
	 * Returns the value of the '<em><b>Number Of FCM Channels</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Number Of FCM Channels</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Number Of FCM Channels</em>' attribute.
	 * @see #setNumberOfFCMChannels(String)
	 * @see com.ibm.ccl.soa.deploy.db2high.Db2highPackage#getDB2Manager_NumberOfFCMChannels()
	 * @model dataType="org.eclipse.emf.ecore.xml.type.String"
	 *        extendedMetaData="kind='attribute' name='NumberOfFCMChannels'"
	 * @generated
	 */
	String getNumberOfFCMChannels();

	/**
	 * Sets the value of the '{@link com.ibm.ccl.soa.deploy.db2high.DB2Manager#getNumberOfFCMChannels <em>Number Of FCM Channels</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Number Of FCM Channels</em>' attribute.
	 * @see #getNumberOfFCMChannels()
	 * @generated
	 */
	void setNumberOfFCMChannels(String value);

	/**
	 * Returns the value of the '<em><b>Query Heap Size</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Query Heap Size</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Query Heap Size</em>' attribute.
	 * @see #setQueryHeapSize(String)
	 * @see com.ibm.ccl.soa.deploy.db2high.Db2highPackage#getDB2Manager_QueryHeapSize()
	 * @model dataType="org.eclipse.emf.ecore.xml.type.String"
	 *        extendedMetaData="kind='attribute' name='QueryHeapSize'"
	 * @generated
	 */
	String getQueryHeapSize();

	/**
	 * Sets the value of the '{@link com.ibm.ccl.soa.deploy.db2high.DB2Manager#getQueryHeapSize <em>Query Heap Size</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Query Heap Size</em>' attribute.
	 * @see #getQueryHeapSize()
	 * @generated
	 */
	void setQueryHeapSize(String value);

	/**
	 * Returns the value of the '<em><b>Server Plugin Mode</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Server Plugin Mode</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Server Plugin Mode</em>' attribute.
	 * @see #setServerPluginMode(String)
	 * @see com.ibm.ccl.soa.deploy.db2high.Db2highPackage#getDB2Manager_ServerPluginMode()
	 * @model dataType="org.eclipse.emf.ecore.xml.type.String"
	 *        extendedMetaData="kind='attribute' name='ServerPluginMode'"
	 * @generated
	 */
	String getServerPluginMode();

	/**
	 * Sets the value of the '{@link com.ibm.ccl.soa.deploy.db2high.DB2Manager#getServerPluginMode <em>Server Plugin Mode</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Server Plugin Mode</em>' attribute.
	 * @see #getServerPluginMode()
	 * @generated
	 */
	void setServerPluginMode(String value);

	/**
	 * Returns the value of the '<em><b>Software Developers Kit For Java Installation Path</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Software Developers Kit For Java Installation Path</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Software Developers Kit For Java Installation Path</em>' attribute.
	 * @see #setSoftwareDevelopersKitForJavaInstallationPath(String)
	 * @see com.ibm.ccl.soa.deploy.db2high.Db2highPackage#getDB2Manager_SoftwareDevelopersKitForJavaInstallationPath()
	 * @model dataType="org.eclipse.emf.ecore.xml.type.String"
	 *        extendedMetaData="kind='attribute' name='SoftwareDevelopersKitForJavaInstallationPath'"
	 * @generated
	 */
	String getSoftwareDevelopersKitForJavaInstallationPath();

	/**
	 * Sets the value of the '{@link com.ibm.ccl.soa.deploy.db2high.DB2Manager#getSoftwareDevelopersKitForJavaInstallationPath <em>Software Developers Kit For Java Installation Path</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Software Developers Kit For Java Installation Path</em>' attribute.
	 * @see #getSoftwareDevelopersKitForJavaInstallationPath()
	 * @generated
	 */
	void setSoftwareDevelopersKitForJavaInstallationPath(String value);

	/**
	 * Returns the value of the '<em><b>Sort Heap Threshold</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Sort Heap Threshold</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Sort Heap Threshold</em>' attribute.
	 * @see #setSortHeapThreshold(String)
	 * @see com.ibm.ccl.soa.deploy.db2high.Db2highPackage#getDB2Manager_SortHeapThreshold()
	 * @model dataType="org.eclipse.emf.ecore.xml.type.String"
	 *        extendedMetaData="kind='attribute' name='SortHeapThreshold'"
	 * @generated
	 */
	String getSortHeapThreshold();

	/**
	 * Sets the value of the '{@link com.ibm.ccl.soa.deploy.db2high.DB2Manager#getSortHeapThreshold <em>Sort Heap Threshold</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Sort Heap Threshold</em>' attribute.
	 * @see #getSortHeapThreshold()
	 * @generated
	 */
	void setSortHeapThreshold(String value);

	/**
	 * Returns the value of the '<em><b>Start And Stop Timeout</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Start And Stop Timeout</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Start And Stop Timeout</em>' attribute.
	 * @see #setStartAndStopTimeout(String)
	 * @see com.ibm.ccl.soa.deploy.db2high.Db2highPackage#getDB2Manager_StartAndStopTimeout()
	 * @model dataType="org.eclipse.emf.ecore.xml.type.String"
	 *        extendedMetaData="kind='attribute' name='StartAndStopTimeout'"
	 * @generated
	 */
	String getStartAndStopTimeout();

	/**
	 * Sets the value of the '{@link com.ibm.ccl.soa.deploy.db2high.DB2Manager#getStartAndStopTimeout <em>Start And Stop Timeout</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Start And Stop Timeout</em>' attribute.
	 * @see #getStartAndStopTimeout()
	 * @generated
	 */
	void setStartAndStopTimeout(String value);

	/**
	 * Returns the value of the '<em><b>Sync Point Manager Log File Path</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Sync Point Manager Log File Path</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Sync Point Manager Log File Path</em>' attribute.
	 * @see #setSyncPointManagerLogFilePath(String)
	 * @see com.ibm.ccl.soa.deploy.db2high.Db2highPackage#getDB2Manager_SyncPointManagerLogFilePath()
	 * @model dataType="org.eclipse.emf.ecore.xml.type.String"
	 *        extendedMetaData="kind='attribute' name='SyncPointManagerLogFilePath'"
	 * @generated
	 */
	String getSyncPointManagerLogFilePath();

	/**
	 * Sets the value of the '{@link com.ibm.ccl.soa.deploy.db2high.DB2Manager#getSyncPointManagerLogFilePath <em>Sync Point Manager Log File Path</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Sync Point Manager Log File Path</em>' attribute.
	 * @see #getSyncPointManagerLogFilePath()
	 * @generated
	 */
	void setSyncPointManagerLogFilePath(String value);

	/**
	 * Returns the value of the '<em><b>Sync Point Manager Log File Size</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Sync Point Manager Log File Size</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Sync Point Manager Log File Size</em>' attribute.
	 * @see #setSyncPointManagerLogFileSize(String)
	 * @see com.ibm.ccl.soa.deploy.db2high.Db2highPackage#getDB2Manager_SyncPointManagerLogFileSize()
	 * @model dataType="org.eclipse.emf.ecore.xml.type.String"
	 *        extendedMetaData="kind='attribute' name='SyncPointManagerLogFileSize'"
	 * @generated
	 */
	String getSyncPointManagerLogFileSize();

	/**
	 * Sets the value of the '{@link com.ibm.ccl.soa.deploy.db2high.DB2Manager#getSyncPointManagerLogFileSize <em>Sync Point Manager Log File Size</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Sync Point Manager Log File Size</em>' attribute.
	 * @see #getSyncPointManagerLogFileSize()
	 * @generated
	 */
	void setSyncPointManagerLogFileSize(String value);

	/**
	 * Returns the value of the '<em><b>Sync Point Manager Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Sync Point Manager Name</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Sync Point Manager Name</em>' attribute.
	 * @see #setSyncPointManagerName(String)
	 * @see com.ibm.ccl.soa.deploy.db2high.Db2highPackage#getDB2Manager_SyncPointManagerName()
	 * @model dataType="org.eclipse.emf.ecore.xml.type.String"
	 *        extendedMetaData="kind='attribute' name='SyncPointManagerName'"
	 * @generated
	 */
	String getSyncPointManagerName();

	/**
	 * Sets the value of the '{@link com.ibm.ccl.soa.deploy.db2high.DB2Manager#getSyncPointManagerName <em>Sync Point Manager Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Sync Point Manager Name</em>' attribute.
	 * @see #getSyncPointManagerName()
	 * @generated
	 */
	void setSyncPointManagerName(String value);

	/**
	 * Returns the value of the '<em><b>Sync Point Manager Resync Agent Limit</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Sync Point Manager Resync Agent Limit</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Sync Point Manager Resync Agent Limit</em>' attribute.
	 * @see #setSyncPointManagerResyncAgentLimit(String)
	 * @see com.ibm.ccl.soa.deploy.db2high.Db2highPackage#getDB2Manager_SyncPointManagerResyncAgentLimit()
	 * @model dataType="org.eclipse.emf.ecore.xml.type.String"
	 *        extendedMetaData="kind='attribute' name='SyncPointManagerResyncAgentLimit'"
	 * @generated
	 */
	String getSyncPointManagerResyncAgentLimit();

	/**
	 * Sets the value of the '{@link com.ibm.ccl.soa.deploy.db2high.DB2Manager#getSyncPointManagerResyncAgentLimit <em>Sync Point Manager Resync Agent Limit</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Sync Point Manager Resync Agent Limit</em>' attribute.
	 * @see #getSyncPointManagerResyncAgentLimit()
	 * @generated
	 */
	void setSyncPointManagerResyncAgentLimit(String value);

	/**
	 * Returns the value of the '<em><b>System Administration Authority Group Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>System Administration Authority Group Name</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>System Administration Authority Group Name</em>' attribute.
	 * @see #setSystemAdministrationAuthorityGroupName(String)
	 * @see com.ibm.ccl.soa.deploy.db2high.Db2highPackage#getDB2Manager_SystemAdministrationAuthorityGroupName()
	 * @model dataType="org.eclipse.emf.ecore.xml.type.String"
	 *        extendedMetaData="kind='attribute' name='SystemAdministrationAuthorityGroupName'"
	 * @generated
	 */
	String getSystemAdministrationAuthorityGroupName();

	/**
	 * Sets the value of the '{@link com.ibm.ccl.soa.deploy.db2high.DB2Manager#getSystemAdministrationAuthorityGroupName <em>System Administration Authority Group Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>System Administration Authority Group Name</em>' attribute.
	 * @see #getSystemAdministrationAuthorityGroupName()
	 * @generated
	 */
	void setSystemAdministrationAuthorityGroupName(String value);

	/**
	 * Returns the value of the '<em><b>System Control Authority Group Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>System Control Authority Group Name</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>System Control Authority Group Name</em>' attribute.
	 * @see #setSystemControlAuthorityGroupName(String)
	 * @see com.ibm.ccl.soa.deploy.db2high.Db2highPackage#getDB2Manager_SystemControlAuthorityGroupName()
	 * @model dataType="org.eclipse.emf.ecore.xml.type.String"
	 *        extendedMetaData="kind='attribute' name='SystemControlAuthorityGroupName'"
	 * @generated
	 */
	String getSystemControlAuthorityGroupName();

	/**
	 * Sets the value of the '{@link com.ibm.ccl.soa.deploy.db2high.DB2Manager#getSystemControlAuthorityGroupName <em>System Control Authority Group Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>System Control Authority Group Name</em>' attribute.
	 * @see #getSystemControlAuthorityGroupName()
	 * @generated
	 */
	void setSystemControlAuthorityGroupName(String value);

	/**
	 * Returns the value of the '<em><b>System Maintenance Authority Group Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>System Maintenance Authority Group Name</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>System Maintenance Authority Group Name</em>' attribute.
	 * @see #setSystemMaintenanceAuthorityGroupName(String)
	 * @see com.ibm.ccl.soa.deploy.db2high.Db2highPackage#getDB2Manager_SystemMaintenanceAuthorityGroupName()
	 * @model dataType="org.eclipse.emf.ecore.xml.type.String"
	 *        extendedMetaData="kind='attribute' name='SystemMaintenanceAuthorityGroupName'"
	 * @generated
	 */
	String getSystemMaintenanceAuthorityGroupName();

	/**
	 * Sets the value of the '{@link com.ibm.ccl.soa.deploy.db2high.DB2Manager#getSystemMaintenanceAuthorityGroupName <em>System Maintenance Authority Group Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>System Maintenance Authority Group Name</em>' attribute.
	 * @see #getSystemMaintenanceAuthorityGroupName()
	 * @generated
	 */
	void setSystemMaintenanceAuthorityGroupName(String value);

	/**
	 * Returns the value of the '<em><b>System Monitor Authority Group Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>System Monitor Authority Group Name</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>System Monitor Authority Group Name</em>' attribute.
	 * @see #setSystemMonitorAuthorityGroupName(String)
	 * @see com.ibm.ccl.soa.deploy.db2high.Db2highPackage#getDB2Manager_SystemMonitorAuthorityGroupName()
	 * @model dataType="org.eclipse.emf.ecore.xml.type.String"
	 *        extendedMetaData="kind='attribute' name='SystemMonitorAuthorityGroupName'"
	 * @generated
	 */
	String getSystemMonitorAuthorityGroupName();

	/**
	 * Sets the value of the '{@link com.ibm.ccl.soa.deploy.db2high.DB2Manager#getSystemMonitorAuthorityGroupName <em>System Monitor Authority Group Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>System Monitor Authority Group Name</em>' attribute.
	 * @see #getSystemMonitorAuthorityGroupName()
	 * @generated
	 */
	void setSystemMonitorAuthorityGroupName(String value);

	/**
	 * Returns the value of the '<em><b>TCPIP Service Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>TCPIP Service Name</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>TCPIP Service Name</em>' attribute.
	 * @see #setTCPIPServiceName(String)
	 * @see com.ibm.ccl.soa.deploy.db2high.Db2highPackage#getDB2Manager_TCPIPServiceName()
	 * @model dataType="org.eclipse.emf.ecore.xml.type.String"
	 *        extendedMetaData="kind='attribute' name='TCPIPServiceName'"
	 * @generated
	 */
	String getTCPIPServiceName();

	/**
	 * Sets the value of the '{@link com.ibm.ccl.soa.deploy.db2high.DB2Manager#getTCPIPServiceName <em>TCPIP Service Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>TCPIP Service Name</em>' attribute.
	 * @see #getTCPIPServiceName()
	 * @generated
	 */
	void setTCPIPServiceName(String value);

	/**
	 * Returns the value of the '<em><b>Transaction Manager Database Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Transaction Manager Database Name</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Transaction Manager Database Name</em>' attribute.
	 * @see #setTransactionManagerDatabaseName(String)
	 * @see com.ibm.ccl.soa.deploy.db2high.Db2highPackage#getDB2Manager_TransactionManagerDatabaseName()
	 * @model dataType="org.eclipse.emf.ecore.xml.type.String"
	 *        extendedMetaData="kind='attribute' name='TransactionManagerDatabaseName'"
	 * @generated
	 */
	String getTransactionManagerDatabaseName();

	/**
	 * Sets the value of the '{@link com.ibm.ccl.soa.deploy.db2high.DB2Manager#getTransactionManagerDatabaseName <em>Transaction Manager Database Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Transaction Manager Database Name</em>' attribute.
	 * @see #getTransactionManagerDatabaseName()
	 * @generated
	 */
	void setTransactionManagerDatabaseName(String value);

	/**
	 * Returns the value of the '<em><b>Transaction Processor Monitor Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Transaction Processor Monitor Name</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Transaction Processor Monitor Name</em>' attribute.
	 * @see #setTransactionProcessorMonitorName(String)
	 * @see com.ibm.ccl.soa.deploy.db2high.Db2highPackage#getDB2Manager_TransactionProcessorMonitorName()
	 * @model dataType="org.eclipse.emf.ecore.xml.type.String"
	 *        extendedMetaData="kind='attribute' name='TransactionProcessorMonitorName'"
	 * @generated
	 */
	String getTransactionProcessorMonitorName();

	/**
	 * Sets the value of the '{@link com.ibm.ccl.soa.deploy.db2high.DB2Manager#getTransactionProcessorMonitorName <em>Transaction Processor Monitor Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Transaction Processor Monitor Name</em>' attribute.
	 * @see #getTransactionProcessorMonitorName()
	 * @generated
	 */
	void setTransactionProcessorMonitorName(String value);

	/**
	 * Returns the value of the '<em><b>Transaction Resync Interval</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Transaction Resync Interval</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Transaction Resync Interval</em>' attribute.
	 * @see #setTransactionResyncInterval(String)
	 * @see com.ibm.ccl.soa.deploy.db2high.Db2highPackage#getDB2Manager_TransactionResyncInterval()
	 * @model dataType="org.eclipse.emf.ecore.xml.type.String"
	 *        extendedMetaData="kind='attribute' name='TransactionResyncInterval'"
	 * @generated
	 */
	String getTransactionResyncInterval();

	/**
	 * Sets the value of the '{@link com.ibm.ccl.soa.deploy.db2high.DB2Manager#getTransactionResyncInterval <em>Transaction Resync Interval</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Transaction Resync Interval</em>' attribute.
	 * @see #getTransactionResyncInterval()
	 * @generated
	 */
	void setTransactionResyncInterval(String value);

	/**
	 * Returns the value of the '<em><b>Trust All Clients</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Trust All Clients</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Trust All Clients</em>' attribute.
	 * @see #setTrustAllClients(String)
	 * @see com.ibm.ccl.soa.deploy.db2high.Db2highPackage#getDB2Manager_TrustAllClients()
	 * @model dataType="org.eclipse.emf.ecore.xml.type.String"
	 *        extendedMetaData="kind='attribute' name='TrustAllClients'"
	 * @generated
	 */
	String getTrustAllClients();

	/**
	 * Sets the value of the '{@link com.ibm.ccl.soa.deploy.db2high.DB2Manager#getTrustAllClients <em>Trust All Clients</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Trust All Clients</em>' attribute.
	 * @see #getTrustAllClients()
	 * @generated
	 */
	void setTrustAllClients(String value);

	/**
	 * Returns the value of the '<em><b>Trusted Clients Authentication</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Trusted Clients Authentication</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Trusted Clients Authentication</em>' attribute.
	 * @see #setTrustedClientsAuthentication(String)
	 * @see com.ibm.ccl.soa.deploy.db2high.Db2highPackage#getDB2Manager_TrustedClientsAuthentication()
	 * @model dataType="org.eclipse.emf.ecore.xml.type.String"
	 *        extendedMetaData="kind='attribute' name='TrustedClientsAuthentication'"
	 * @generated
	 */
	String getTrustedClientsAuthentication();

	/**
	 * Sets the value of the '{@link com.ibm.ccl.soa.deploy.db2high.DB2Manager#getTrustedClientsAuthentication <em>Trusted Clients Authentication</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Trusted Clients Authentication</em>' attribute.
	 * @see #getTrustedClientsAuthentication()
	 * @generated
	 */
	void setTrustedClientsAuthentication(String value);

	/**
	 * Returns the value of the '<em><b>Userid Password Plug In</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Userid Password Plug In</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Userid Password Plug In</em>' attribute.
	 * @see #setUseridPasswordPlugIn(String)
	 * @see com.ibm.ccl.soa.deploy.db2high.Db2highPackage#getDB2Manager_UseridPasswordPlugIn()
	 * @model dataType="org.eclipse.emf.ecore.xml.type.String"
	 *        extendedMetaData="kind='attribute' name='UseridPasswordPlugIn'"
	 * @generated
	 */
	String getUseridPasswordPlugIn();

	/**
	 * Sets the value of the '{@link com.ibm.ccl.soa.deploy.db2high.DB2Manager#getUseridPasswordPlugIn <em>Userid Password Plug In</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Userid Password Plug In</em>' attribute.
	 * @see #getUseridPasswordPlugIn()
	 * @generated
	 */
	void setUseridPasswordPlugIn(String value);

} // DB2Manager
