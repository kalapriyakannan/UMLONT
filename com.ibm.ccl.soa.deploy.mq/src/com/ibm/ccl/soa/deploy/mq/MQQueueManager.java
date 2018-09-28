/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package com.ibm.ccl.soa.deploy.mq;

import com.ibm.ccl.soa.deploy.core.Capability;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>MQ Queue Manager</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link com.ibm.ccl.soa.deploy.mq.MQQueueManager#getAccountingConnectionOverride <em>Accounting Connection Override</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.mq.MQQueueManager#getAccountingInterval <em>Accounting Interval</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.mq.MQQueueManager#getActivityRecording <em>Activity Recording</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.mq.MQQueueManager#getAdoptNewMCA <em>Adopt New MCA</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.mq.MQQueueManager#getAdoptNewMCACheck <em>Adopt New MCA Check</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.mq.MQQueueManager#getAdoptNewMCAType <em>Adopt New MCA Type</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.mq.MQQueueManager#getAuthorityEvent <em>Authority Event</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.mq.MQQueueManager#getAutomatic <em>Automatic</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.mq.MQQueueManager#getBridgeEvent <em>Bridge Event</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.mq.MQQueueManager#getBrokerMessageRetryCount <em>Broker Message Retry Count</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.mq.MQQueueManager#getBrokerOpenCacheExpiry <em>Broker Open Cache Expiry</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.mq.MQQueueManager#getBrokerOpenCacheSize <em>Broker Open Cache Size</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.mq.MQQueueManager#getBrokerPublicBatchInterval <em>Broker Public Batch Interval</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.mq.MQQueueManager#getBrokerPublishBatchSize <em>Broker Publish Batch Size</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.mq.MQQueueManager#getBrokerStreamsPerProcess <em>Broker Streams Per Process</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.mq.MQQueueManager#getChannelAutoDefinition <em>Channel Auto Definition</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.mq.MQQueueManager#getChannelAutoDefinitionEvent <em>Channel Auto Definition Event</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.mq.MQQueueManager#getChannelEvent <em>Channel Event</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.mq.MQQueueManager#getChannelInitiatorAdapters <em>Channel Initiator Adapters</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.mq.MQQueueManager#getChannelInitiatorControl <em>Channel Initiator Control</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.mq.MQQueueManager#getChannelInitiatorDispatchers <em>Channel Initiator Dispatchers</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.mq.MQQueueManager#getChannelInitiatorTraceAutoStart <em>Channel Initiator Trace Auto Start</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.mq.MQQueueManager#getChannelInitiatorTraceTableSize <em>Channel Initiator Trace Table Size</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.mq.MQQueueManager#getChannelMonitoring <em>Channel Monitoring</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.mq.MQQueueManager#getChannelStatistics <em>Channel Statistics</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.mq.MQQueueManager#getCheckpointActiveCount <em>Checkpoint Active Count</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.mq.MQQueueManager#getCheckpointMessageSize <em>Checkpoint Message Size</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.mq.MQQueueManager#getCheckpointRestartCount <em>Checkpoint Restart Count</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.mq.MQQueueManager#getClusterSenderMonitoring <em>Cluster Sender Monitoring</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.mq.MQQueueManager#getClusterSenderStatistics <em>Cluster Sender Statistics</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.mq.MQQueueManager#getClusterWorkLoadData <em>Cluster Work Load Data</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.mq.MQQueueManager#getClusterWorkLoadExit <em>Cluster Work Load Exit</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.mq.MQQueueManager#getClusterWorkLoadLength <em>Cluster Work Load Length</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.mq.MQQueueManager#getClusterWorkloadUseQ <em>Cluster Workload Use Q</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.mq.MQQueueManager#getCodedCharSetId <em>Coded Char Set Id</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.mq.MQQueueManager#getCommandEvent <em>Command Event</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.mq.MQQueueManager#getCommandLevel <em>Command Level</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.mq.MQQueueManager#getCommandScope <em>Command Scope</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.mq.MQQueueManager#getCommandServerControl <em>Command Server Control</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.mq.MQQueueManager#getConfigurationEvent <em>Configuration Event</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.mq.MQQueueManager#getConfirm <em>Confirm</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.mq.MQQueueManager#getDeadLetterQueue <em>Dead Letter Queue</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.mq.MQQueueManager#getDefaultBindType <em>Default Bind Type</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.mq.MQQueueManager#getDefaultTransmissionQueue <em>Default Transmission Queue</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.mq.MQQueueManager#getDescription1 <em>Description1</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.mq.MQQueueManager#getDNSGroup <em>DNS Group</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.mq.MQQueueManager#getDNSWLM <em>DNSWLM</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.mq.MQQueueManager#getErrorLogSize <em>Error Log Size</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.mq.MQQueueManager#getExcludedMessages <em>Excluded Messages</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.mq.MQQueueManager#getExitsDefaultPath <em>Exits Default Path</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.mq.MQQueueManager#getExpiryInterval <em>Expiry Interval</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.mq.MQQueueManager#getIGQPutAuthority <em>IGQ Put Authority</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.mq.MQQueueManager#getIGQUserId <em>IGQ User Id</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.mq.MQQueueManager#getInhibitEvent <em>Inhibit Event</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.mq.MQQueueManager#getInstallableServiceName <em>Installable Service Name</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.mq.MQQueueManager#getIntraGroupQueuing <em>Intra Group Queuing</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.mq.MQQueueManager#getIPAddressVersion <em>IP Address Version</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.mq.MQQueueManager#getListenerTimer <em>Listener Timer</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.mq.MQQueueManager#getLocalEvent <em>Local Event</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.mq.MQQueueManager#getLogBufferPages <em>Log Buffer Pages</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.mq.MQQueueManager#getLogFilePages <em>Log File Pages</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.mq.MQQueueManager#getLogPath <em>Log Path</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.mq.MQQueueManager#getLogPrimaryFiles <em>Log Primary Files</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.mq.MQQueueManager#getLogSecondaryFiles <em>Log Secondary Files</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.mq.MQQueueManager#getLogType <em>Log Type</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.mq.MQQueueManager#getLogWriteIntegrity <em>Log Write Integrity</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.mq.MQQueueManager#getLU62ARMSuffix <em>LU62ARM Suffix</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.mq.MQQueueManager#getLU62Channels <em>LU62 Channels</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.mq.MQQueueManager#getLUGroupName <em>LU Group Name</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.mq.MQQueueManager#getLULibrary1 <em>LU Library1</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.mq.MQQueueManager#getLULibrary2 <em>LU Library2</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.mq.MQQueueManager#getLULocalLU <em>LU Local LU</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.mq.MQQueueManager#getLUName <em>LU Name</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.mq.MQQueueManager#getLUTPName <em>LUTP Name</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.mq.MQQueueManager#getMaxActiveChannels <em>Max Active Channels</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.mq.MQQueueManager#getMaxChannels <em>Max Channels</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.mq.MQQueueManager#getMaximumCurrentChannels <em>Maximum Current Channels</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.mq.MQQueueManager#getMaximumHandles <em>Maximum Handles</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.mq.MQQueueManager#getMaximumMessageLength <em>Maximum Message Length</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.mq.MQQueueManager#getMaximumTCPChannels <em>Maximum TCP Channels</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.mq.MQQueueManager#getMaximumUncommittedMessages <em>Maximum Uncommitted Messages</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.mq.MQQueueManager#getMaxInitiators <em>Max Initiators</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.mq.MQQueueManager#getMQIAccounting <em>MQI Accounting</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.mq.MQQueueManager#getMQIBindType <em>MQI Bind Type</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.mq.MQQueueManager#getMQIStatistics <em>MQI Statistics</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.mq.MQQueueManager#getNetBiosAdaptorNumber <em>Net Bios Adaptor Number</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.mq.MQQueueManager#getNetBiosLibrary1 <em>Net Bios Library1</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.mq.MQQueueManager#getNetBiosLocalName <em>Net Bios Local Name</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.mq.MQQueueManager#getNetBiosNumberOfCommands <em>Net Bios Number Of Commands</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.mq.MQQueueManager#getNetBiosNumberOfNames <em>Net Bios Number Of Names</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.mq.MQQueueManager#getNetBiosNumberOfSessions <em>Net Bios Number Of Sessions</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.mq.MQQueueManager#getOutboundPortMax <em>Outbound Port Max</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.mq.MQQueueManager#getOutboundPortMin <em>Outbound Port Min</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.mq.MQQueueManager#getPerformanceEvent <em>Performance Event</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.mq.MQQueueManager#getPipeLineLength <em>Pipe Line Length</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.mq.MQQueueManager#getPlatform <em>Platform</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.mq.MQQueueManager#getQueueAccounting <em>Queue Accounting</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.mq.MQQueueManager#getQueueManagerName <em>Queue Manager Name</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.mq.MQQueueManager#getQueueManagerStatus <em>Queue Manager Status</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.mq.MQQueueManager#getQueueMonitoring <em>Queue Monitoring</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.mq.MQQueueManager#getQueueStatistics <em>Queue Statistics</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.mq.MQQueueManager#getReceiveTimeout <em>Receive Timeout</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.mq.MQQueueManager#getReceiveTimeoutMin <em>Receive Timeout Min</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.mq.MQQueueManager#getReceiveTimeoutType <em>Receive Timeout Type</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.mq.MQQueueManager#getRemoteEvent <em>Remote Event</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.mq.MQQueueManager#getRepositoryName <em>Repository Name</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.mq.MQQueueManager#getRepositoryNameList <em>Repository Name List</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.mq.MQQueueManager#getRoutingExitConnectType <em>Routing Exit Connect Type</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.mq.MQQueueManager#getRoutingExitPath <em>Routing Exit Path</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.mq.MQQueueManager#getSecurityPolicy <em>Security Policy</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.mq.MQQueueManager#getServiceEntryPoints <em>Service Entry Points</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.mq.MQQueueManager#getSharedQQmgrName <em>Shared QQmgr Name</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.mq.MQQueueManager#getSPXBoardNumber <em>SPX Board Number</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.mq.MQQueueManager#getSPXKeepAlive <em>SPX Keep Alive</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.mq.MQQueueManager#getSPXLibrary1 <em>SPX Library1</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.mq.MQQueueManager#getSPXLibrary2 <em>SPX Library2</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.mq.MQQueueManager#getSPXSocket <em>SPX Socket</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.mq.MQQueueManager#getSSLCRLNameList <em>SSLCRL Name List</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.mq.MQQueueManager#getSSLCrytoHardware <em>SSL Cryto Hardware</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.mq.MQQueueManager#getSSLEvent <em>SSL Event</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.mq.MQQueueManager#getSSLFips <em>SSL Fips</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.mq.MQQueueManager#getSSLKeyRepository <em>SSL Key Repository</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.mq.MQQueueManager#getSSLKeyResetCount <em>SSL Key Reset Count</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.mq.MQQueueManager#getSSLTasks <em>SSL Tasks</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.mq.MQQueueManager#getStartStopEvent <em>Start Stop Event</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.mq.MQQueueManager#getStatisticsInterval <em>Statistics Interval</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.mq.MQQueueManager#getSuppresedMessages <em>Suppresed Messages</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.mq.MQQueueManager#getSuppressedMessageInterval <em>Suppressed Message Interval</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.mq.MQQueueManager#getTCPKeepAlive <em>TCP Keep Alive</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.mq.MQQueueManager#getTCPLibrary1 <em>TCP Library1</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.mq.MQQueueManager#getTCPLibrary2 <em>TCP Library2</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.mq.MQQueueManager#getTCPListenerBacklog <em>TCP Listener Backlog</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.mq.MQQueueManager#getTCPName <em>TCP Name</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.mq.MQQueueManager#getTCPPort <em>TCP Port</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.mq.MQQueueManager#getTCPStackType <em>TCP Stack Type</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.mq.MQQueueManager#getTraceRouteRecording <em>Trace Route Recording</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.mq.MQQueueManager#getTriggerInterval <em>Trigger Interval</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.mq.MQQueueManager#getWhatIf <em>What If</em>}</li>
 * </ul>
 * </p>
 *
 * @see com.ibm.ccl.soa.deploy.mq.MqPackage#getMQQueueManager()
 * @model extendedMetaData="name='MQQueueManager' kind='elementOnly'"
 * @generated
 */
public interface MQQueueManager extends Capability {
	/**
	 * Returns the value of the '<em><b>Accounting Connection Override</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Accounting Connection Override</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Accounting Connection Override</em>' attribute.
	 * @see #setAccountingConnectionOverride(String)
	 * @see com.ibm.ccl.soa.deploy.mq.MqPackage#getMQQueueManager_AccountingConnectionOverride()
	 * @model dataType="org.eclipse.emf.ecore.xml.type.String"
	 *        extendedMetaData="kind='attribute' name='AccountingConnectionOverride'"
	 * @generated
	 */
	String getAccountingConnectionOverride();

	/**
	 * Sets the value of the '{@link com.ibm.ccl.soa.deploy.mq.MQQueueManager#getAccountingConnectionOverride <em>Accounting Connection Override</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Accounting Connection Override</em>' attribute.
	 * @see #getAccountingConnectionOverride()
	 * @generated
	 */
	void setAccountingConnectionOverride(String value);

	/**
	 * Returns the value of the '<em><b>Accounting Interval</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Accounting Interval</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Accounting Interval</em>' attribute.
	 * @see #setAccountingInterval(String)
	 * @see com.ibm.ccl.soa.deploy.mq.MqPackage#getMQQueueManager_AccountingInterval()
	 * @model dataType="org.eclipse.emf.ecore.xml.type.String"
	 *        extendedMetaData="kind='attribute' name='AccountingInterval'"
	 * @generated
	 */
	String getAccountingInterval();

	/**
	 * Sets the value of the '{@link com.ibm.ccl.soa.deploy.mq.MQQueueManager#getAccountingInterval <em>Accounting Interval</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Accounting Interval</em>' attribute.
	 * @see #getAccountingInterval()
	 * @generated
	 */
	void setAccountingInterval(String value);

	/**
	 * Returns the value of the '<em><b>Activity Recording</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Activity Recording</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Activity Recording</em>' attribute.
	 * @see #setActivityRecording(String)
	 * @see com.ibm.ccl.soa.deploy.mq.MqPackage#getMQQueueManager_ActivityRecording()
	 * @model dataType="org.eclipse.emf.ecore.xml.type.String"
	 *        extendedMetaData="kind='attribute' name='ActivityRecording'"
	 * @generated
	 */
	String getActivityRecording();

	/**
	 * Sets the value of the '{@link com.ibm.ccl.soa.deploy.mq.MQQueueManager#getActivityRecording <em>Activity Recording</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Activity Recording</em>' attribute.
	 * @see #getActivityRecording()
	 * @generated
	 */
	void setActivityRecording(String value);

	/**
	 * Returns the value of the '<em><b>Adopt New MCA</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Adopt New MCA</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Adopt New MCA</em>' attribute.
	 * @see #setAdoptNewMCA(String)
	 * @see com.ibm.ccl.soa.deploy.mq.MqPackage#getMQQueueManager_AdoptNewMCA()
	 * @model dataType="org.eclipse.emf.ecore.xml.type.String"
	 *        extendedMetaData="kind='attribute' name='AdoptNewMCA'"
	 * @generated
	 */
	String getAdoptNewMCA();

	/**
	 * Sets the value of the '{@link com.ibm.ccl.soa.deploy.mq.MQQueueManager#getAdoptNewMCA <em>Adopt New MCA</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Adopt New MCA</em>' attribute.
	 * @see #getAdoptNewMCA()
	 * @generated
	 */
	void setAdoptNewMCA(String value);

	/**
	 * Returns the value of the '<em><b>Adopt New MCA Check</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Adopt New MCA Check</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Adopt New MCA Check</em>' attribute.
	 * @see #setAdoptNewMCACheck(String)
	 * @see com.ibm.ccl.soa.deploy.mq.MqPackage#getMQQueueManager_AdoptNewMCACheck()
	 * @model dataType="org.eclipse.emf.ecore.xml.type.String"
	 *        extendedMetaData="kind='attribute' name='AdoptNewMCACheck'"
	 * @generated
	 */
	String getAdoptNewMCACheck();

	/**
	 * Sets the value of the '{@link com.ibm.ccl.soa.deploy.mq.MQQueueManager#getAdoptNewMCACheck <em>Adopt New MCA Check</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Adopt New MCA Check</em>' attribute.
	 * @see #getAdoptNewMCACheck()
	 * @generated
	 */
	void setAdoptNewMCACheck(String value);

	/**
	 * Returns the value of the '<em><b>Adopt New MCA Type</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Adopt New MCA Type</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Adopt New MCA Type</em>' attribute.
	 * @see #setAdoptNewMCAType(String)
	 * @see com.ibm.ccl.soa.deploy.mq.MqPackage#getMQQueueManager_AdoptNewMCAType()
	 * @model dataType="org.eclipse.emf.ecore.xml.type.String"
	 *        extendedMetaData="kind='attribute' name='AdoptNewMCAType'"
	 * @generated
	 */
	String getAdoptNewMCAType();

	/**
	 * Sets the value of the '{@link com.ibm.ccl.soa.deploy.mq.MQQueueManager#getAdoptNewMCAType <em>Adopt New MCA Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Adopt New MCA Type</em>' attribute.
	 * @see #getAdoptNewMCAType()
	 * @generated
	 */
	void setAdoptNewMCAType(String value);

	/**
	 * Returns the value of the '<em><b>Authority Event</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Authority Event</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Authority Event</em>' attribute.
	 * @see #setAuthorityEvent(String)
	 * @see com.ibm.ccl.soa.deploy.mq.MqPackage#getMQQueueManager_AuthorityEvent()
	 * @model dataType="org.eclipse.emf.ecore.xml.type.String"
	 *        extendedMetaData="kind='attribute' name='AuthorityEvent'"
	 * @generated
	 */
	String getAuthorityEvent();

	/**
	 * Sets the value of the '{@link com.ibm.ccl.soa.deploy.mq.MQQueueManager#getAuthorityEvent <em>Authority Event</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Authority Event</em>' attribute.
	 * @see #getAuthorityEvent()
	 * @generated
	 */
	void setAuthorityEvent(String value);

	/**
	 * Returns the value of the '<em><b>Automatic</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Automatic</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Automatic</em>' attribute.
	 * @see #setAutomatic(String)
	 * @see com.ibm.ccl.soa.deploy.mq.MqPackage#getMQQueueManager_Automatic()
	 * @model dataType="org.eclipse.emf.ecore.xml.type.String"
	 *        extendedMetaData="kind='attribute' name='Automatic'"
	 * @generated
	 */
	String getAutomatic();

	/**
	 * Sets the value of the '{@link com.ibm.ccl.soa.deploy.mq.MQQueueManager#getAutomatic <em>Automatic</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Automatic</em>' attribute.
	 * @see #getAutomatic()
	 * @generated
	 */
	void setAutomatic(String value);

	/**
	 * Returns the value of the '<em><b>Bridge Event</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Bridge Event</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Bridge Event</em>' attribute.
	 * @see #setBridgeEvent(String)
	 * @see com.ibm.ccl.soa.deploy.mq.MqPackage#getMQQueueManager_BridgeEvent()
	 * @model dataType="org.eclipse.emf.ecore.xml.type.String"
	 *        extendedMetaData="kind='attribute' name='BridgeEvent'"
	 * @generated
	 */
	String getBridgeEvent();

	/**
	 * Sets the value of the '{@link com.ibm.ccl.soa.deploy.mq.MQQueueManager#getBridgeEvent <em>Bridge Event</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Bridge Event</em>' attribute.
	 * @see #getBridgeEvent()
	 * @generated
	 */
	void setBridgeEvent(String value);

	/**
	 * Returns the value of the '<em><b>Broker Message Retry Count</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Broker Message Retry Count</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Broker Message Retry Count</em>' attribute.
	 * @see #setBrokerMessageRetryCount(String)
	 * @see com.ibm.ccl.soa.deploy.mq.MqPackage#getMQQueueManager_BrokerMessageRetryCount()
	 * @model dataType="org.eclipse.emf.ecore.xml.type.String"
	 *        extendedMetaData="kind='attribute' name='BrokerMessageRetryCount'"
	 * @generated
	 */
	String getBrokerMessageRetryCount();

	/**
	 * Sets the value of the '{@link com.ibm.ccl.soa.deploy.mq.MQQueueManager#getBrokerMessageRetryCount <em>Broker Message Retry Count</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Broker Message Retry Count</em>' attribute.
	 * @see #getBrokerMessageRetryCount()
	 * @generated
	 */
	void setBrokerMessageRetryCount(String value);

	/**
	 * Returns the value of the '<em><b>Broker Open Cache Expiry</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Broker Open Cache Expiry</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Broker Open Cache Expiry</em>' attribute.
	 * @see #setBrokerOpenCacheExpiry(String)
	 * @see com.ibm.ccl.soa.deploy.mq.MqPackage#getMQQueueManager_BrokerOpenCacheExpiry()
	 * @model dataType="org.eclipse.emf.ecore.xml.type.String"
	 *        extendedMetaData="kind='attribute' name='BrokerOpenCacheExpiry'"
	 * @generated
	 */
	String getBrokerOpenCacheExpiry();

	/**
	 * Sets the value of the '{@link com.ibm.ccl.soa.deploy.mq.MQQueueManager#getBrokerOpenCacheExpiry <em>Broker Open Cache Expiry</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Broker Open Cache Expiry</em>' attribute.
	 * @see #getBrokerOpenCacheExpiry()
	 * @generated
	 */
	void setBrokerOpenCacheExpiry(String value);

	/**
	 * Returns the value of the '<em><b>Broker Open Cache Size</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Broker Open Cache Size</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Broker Open Cache Size</em>' attribute.
	 * @see #setBrokerOpenCacheSize(String)
	 * @see com.ibm.ccl.soa.deploy.mq.MqPackage#getMQQueueManager_BrokerOpenCacheSize()
	 * @model dataType="org.eclipse.emf.ecore.xml.type.String"
	 *        extendedMetaData="kind='attribute' name='BrokerOpenCacheSize'"
	 * @generated
	 */
	String getBrokerOpenCacheSize();

	/**
	 * Sets the value of the '{@link com.ibm.ccl.soa.deploy.mq.MQQueueManager#getBrokerOpenCacheSize <em>Broker Open Cache Size</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Broker Open Cache Size</em>' attribute.
	 * @see #getBrokerOpenCacheSize()
	 * @generated
	 */
	void setBrokerOpenCacheSize(String value);

	/**
	 * Returns the value of the '<em><b>Broker Public Batch Interval</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Broker Public Batch Interval</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Broker Public Batch Interval</em>' attribute.
	 * @see #setBrokerPublicBatchInterval(String)
	 * @see com.ibm.ccl.soa.deploy.mq.MqPackage#getMQQueueManager_BrokerPublicBatchInterval()
	 * @model dataType="org.eclipse.emf.ecore.xml.type.String"
	 *        extendedMetaData="kind='attribute' name='BrokerPublicBatchInterval'"
	 * @generated
	 */
	String getBrokerPublicBatchInterval();

	/**
	 * Sets the value of the '{@link com.ibm.ccl.soa.deploy.mq.MQQueueManager#getBrokerPublicBatchInterval <em>Broker Public Batch Interval</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Broker Public Batch Interval</em>' attribute.
	 * @see #getBrokerPublicBatchInterval()
	 * @generated
	 */
	void setBrokerPublicBatchInterval(String value);

	/**
	 * Returns the value of the '<em><b>Broker Publish Batch Size</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Broker Publish Batch Size</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Broker Publish Batch Size</em>' attribute.
	 * @see #setBrokerPublishBatchSize(String)
	 * @see com.ibm.ccl.soa.deploy.mq.MqPackage#getMQQueueManager_BrokerPublishBatchSize()
	 * @model dataType="org.eclipse.emf.ecore.xml.type.String"
	 *        extendedMetaData="kind='attribute' name='BrokerPublishBatchSize'"
	 * @generated
	 */
	String getBrokerPublishBatchSize();

	/**
	 * Sets the value of the '{@link com.ibm.ccl.soa.deploy.mq.MQQueueManager#getBrokerPublishBatchSize <em>Broker Publish Batch Size</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Broker Publish Batch Size</em>' attribute.
	 * @see #getBrokerPublishBatchSize()
	 * @generated
	 */
	void setBrokerPublishBatchSize(String value);

	/**
	 * Returns the value of the '<em><b>Broker Streams Per Process</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Broker Streams Per Process</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Broker Streams Per Process</em>' attribute.
	 * @see #setBrokerStreamsPerProcess(String)
	 * @see com.ibm.ccl.soa.deploy.mq.MqPackage#getMQQueueManager_BrokerStreamsPerProcess()
	 * @model dataType="org.eclipse.emf.ecore.xml.type.String"
	 *        extendedMetaData="kind='attribute' name='BrokerStreamsPerProcess'"
	 * @generated
	 */
	String getBrokerStreamsPerProcess();

	/**
	 * Sets the value of the '{@link com.ibm.ccl.soa.deploy.mq.MQQueueManager#getBrokerStreamsPerProcess <em>Broker Streams Per Process</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Broker Streams Per Process</em>' attribute.
	 * @see #getBrokerStreamsPerProcess()
	 * @generated
	 */
	void setBrokerStreamsPerProcess(String value);

	/**
	 * Returns the value of the '<em><b>Channel Auto Definition</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Channel Auto Definition</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Channel Auto Definition</em>' attribute.
	 * @see #setChannelAutoDefinition(String)
	 * @see com.ibm.ccl.soa.deploy.mq.MqPackage#getMQQueueManager_ChannelAutoDefinition()
	 * @model dataType="org.eclipse.emf.ecore.xml.type.String"
	 *        extendedMetaData="kind='attribute' name='ChannelAutoDefinition'"
	 * @generated
	 */
	String getChannelAutoDefinition();

	/**
	 * Sets the value of the '{@link com.ibm.ccl.soa.deploy.mq.MQQueueManager#getChannelAutoDefinition <em>Channel Auto Definition</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Channel Auto Definition</em>' attribute.
	 * @see #getChannelAutoDefinition()
	 * @generated
	 */
	void setChannelAutoDefinition(String value);

	/**
	 * Returns the value of the '<em><b>Channel Auto Definition Event</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Channel Auto Definition Event</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Channel Auto Definition Event</em>' attribute.
	 * @see #setChannelAutoDefinitionEvent(String)
	 * @see com.ibm.ccl.soa.deploy.mq.MqPackage#getMQQueueManager_ChannelAutoDefinitionEvent()
	 * @model dataType="org.eclipse.emf.ecore.xml.type.String"
	 *        extendedMetaData="kind='attribute' name='ChannelAutoDefinitionEvent'"
	 * @generated
	 */
	String getChannelAutoDefinitionEvent();

	/**
	 * Sets the value of the '{@link com.ibm.ccl.soa.deploy.mq.MQQueueManager#getChannelAutoDefinitionEvent <em>Channel Auto Definition Event</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Channel Auto Definition Event</em>' attribute.
	 * @see #getChannelAutoDefinitionEvent()
	 * @generated
	 */
	void setChannelAutoDefinitionEvent(String value);

	/**
	 * Returns the value of the '<em><b>Channel Event</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Channel Event</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Channel Event</em>' attribute.
	 * @see #setChannelEvent(String)
	 * @see com.ibm.ccl.soa.deploy.mq.MqPackage#getMQQueueManager_ChannelEvent()
	 * @model dataType="org.eclipse.emf.ecore.xml.type.String"
	 *        extendedMetaData="kind='attribute' name='ChannelEvent'"
	 * @generated
	 */
	String getChannelEvent();

	/**
	 * Sets the value of the '{@link com.ibm.ccl.soa.deploy.mq.MQQueueManager#getChannelEvent <em>Channel Event</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Channel Event</em>' attribute.
	 * @see #getChannelEvent()
	 * @generated
	 */
	void setChannelEvent(String value);

	/**
	 * Returns the value of the '<em><b>Channel Initiator Adapters</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Channel Initiator Adapters</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Channel Initiator Adapters</em>' attribute.
	 * @see #setChannelInitiatorAdapters(String)
	 * @see com.ibm.ccl.soa.deploy.mq.MqPackage#getMQQueueManager_ChannelInitiatorAdapters()
	 * @model dataType="org.eclipse.emf.ecore.xml.type.String"
	 *        extendedMetaData="kind='attribute' name='ChannelInitiatorAdapters'"
	 * @generated
	 */
	String getChannelInitiatorAdapters();

	/**
	 * Sets the value of the '{@link com.ibm.ccl.soa.deploy.mq.MQQueueManager#getChannelInitiatorAdapters <em>Channel Initiator Adapters</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Channel Initiator Adapters</em>' attribute.
	 * @see #getChannelInitiatorAdapters()
	 * @generated
	 */
	void setChannelInitiatorAdapters(String value);

	/**
	 * Returns the value of the '<em><b>Channel Initiator Control</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Channel Initiator Control</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Channel Initiator Control</em>' attribute.
	 * @see #setChannelInitiatorControl(String)
	 * @see com.ibm.ccl.soa.deploy.mq.MqPackage#getMQQueueManager_ChannelInitiatorControl()
	 * @model dataType="org.eclipse.emf.ecore.xml.type.String"
	 *        extendedMetaData="kind='attribute' name='ChannelInitiatorControl'"
	 * @generated
	 */
	String getChannelInitiatorControl();

	/**
	 * Sets the value of the '{@link com.ibm.ccl.soa.deploy.mq.MQQueueManager#getChannelInitiatorControl <em>Channel Initiator Control</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Channel Initiator Control</em>' attribute.
	 * @see #getChannelInitiatorControl()
	 * @generated
	 */
	void setChannelInitiatorControl(String value);

	/**
	 * Returns the value of the '<em><b>Channel Initiator Dispatchers</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Channel Initiator Dispatchers</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Channel Initiator Dispatchers</em>' attribute.
	 * @see #setChannelInitiatorDispatchers(String)
	 * @see com.ibm.ccl.soa.deploy.mq.MqPackage#getMQQueueManager_ChannelInitiatorDispatchers()
	 * @model dataType="org.eclipse.emf.ecore.xml.type.String"
	 *        extendedMetaData="kind='attribute' name='ChannelInitiatorDispatchers'"
	 * @generated
	 */
	String getChannelInitiatorDispatchers();

	/**
	 * Sets the value of the '{@link com.ibm.ccl.soa.deploy.mq.MQQueueManager#getChannelInitiatorDispatchers <em>Channel Initiator Dispatchers</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Channel Initiator Dispatchers</em>' attribute.
	 * @see #getChannelInitiatorDispatchers()
	 * @generated
	 */
	void setChannelInitiatorDispatchers(String value);

	/**
	 * Returns the value of the '<em><b>Channel Initiator Trace Auto Start</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Channel Initiator Trace Auto Start</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Channel Initiator Trace Auto Start</em>' attribute.
	 * @see #setChannelInitiatorTraceAutoStart(String)
	 * @see com.ibm.ccl.soa.deploy.mq.MqPackage#getMQQueueManager_ChannelInitiatorTraceAutoStart()
	 * @model dataType="org.eclipse.emf.ecore.xml.type.String"
	 *        extendedMetaData="kind='attribute' name='ChannelInitiatorTraceAutoStart'"
	 * @generated
	 */
	String getChannelInitiatorTraceAutoStart();

	/**
	 * Sets the value of the '{@link com.ibm.ccl.soa.deploy.mq.MQQueueManager#getChannelInitiatorTraceAutoStart <em>Channel Initiator Trace Auto Start</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Channel Initiator Trace Auto Start</em>' attribute.
	 * @see #getChannelInitiatorTraceAutoStart()
	 * @generated
	 */
	void setChannelInitiatorTraceAutoStart(String value);

	/**
	 * Returns the value of the '<em><b>Channel Initiator Trace Table Size</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Channel Initiator Trace Table Size</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Channel Initiator Trace Table Size</em>' attribute.
	 * @see #setChannelInitiatorTraceTableSize(String)
	 * @see com.ibm.ccl.soa.deploy.mq.MqPackage#getMQQueueManager_ChannelInitiatorTraceTableSize()
	 * @model dataType="org.eclipse.emf.ecore.xml.type.String"
	 *        extendedMetaData="kind='attribute' name='ChannelInitiatorTraceTableSize'"
	 * @generated
	 */
	String getChannelInitiatorTraceTableSize();

	/**
	 * Sets the value of the '{@link com.ibm.ccl.soa.deploy.mq.MQQueueManager#getChannelInitiatorTraceTableSize <em>Channel Initiator Trace Table Size</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Channel Initiator Trace Table Size</em>' attribute.
	 * @see #getChannelInitiatorTraceTableSize()
	 * @generated
	 */
	void setChannelInitiatorTraceTableSize(String value);

	/**
	 * Returns the value of the '<em><b>Channel Monitoring</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Channel Monitoring</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Channel Monitoring</em>' attribute.
	 * @see #setChannelMonitoring(String)
	 * @see com.ibm.ccl.soa.deploy.mq.MqPackage#getMQQueueManager_ChannelMonitoring()
	 * @model dataType="org.eclipse.emf.ecore.xml.type.String"
	 *        extendedMetaData="kind='attribute' name='ChannelMonitoring'"
	 * @generated
	 */
	String getChannelMonitoring();

	/**
	 * Sets the value of the '{@link com.ibm.ccl.soa.deploy.mq.MQQueueManager#getChannelMonitoring <em>Channel Monitoring</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Channel Monitoring</em>' attribute.
	 * @see #getChannelMonitoring()
	 * @generated
	 */
	void setChannelMonitoring(String value);

	/**
	 * Returns the value of the '<em><b>Channel Statistics</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Channel Statistics</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Channel Statistics</em>' attribute.
	 * @see #setChannelStatistics(String)
	 * @see com.ibm.ccl.soa.deploy.mq.MqPackage#getMQQueueManager_ChannelStatistics()
	 * @model dataType="org.eclipse.emf.ecore.xml.type.String"
	 *        extendedMetaData="kind='attribute' name='ChannelStatistics'"
	 * @generated
	 */
	String getChannelStatistics();

	/**
	 * Sets the value of the '{@link com.ibm.ccl.soa.deploy.mq.MQQueueManager#getChannelStatistics <em>Channel Statistics</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Channel Statistics</em>' attribute.
	 * @see #getChannelStatistics()
	 * @generated
	 */
	void setChannelStatistics(String value);

	/**
	 * Returns the value of the '<em><b>Checkpoint Active Count</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Checkpoint Active Count</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Checkpoint Active Count</em>' attribute.
	 * @see #setCheckpointActiveCount(String)
	 * @see com.ibm.ccl.soa.deploy.mq.MqPackage#getMQQueueManager_CheckpointActiveCount()
	 * @model dataType="org.eclipse.emf.ecore.xml.type.String"
	 *        extendedMetaData="kind='attribute' name='CheckpointActiveCount'"
	 * @generated
	 */
	String getCheckpointActiveCount();

	/**
	 * Sets the value of the '{@link com.ibm.ccl.soa.deploy.mq.MQQueueManager#getCheckpointActiveCount <em>Checkpoint Active Count</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Checkpoint Active Count</em>' attribute.
	 * @see #getCheckpointActiveCount()
	 * @generated
	 */
	void setCheckpointActiveCount(String value);

	/**
	 * Returns the value of the '<em><b>Checkpoint Message Size</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Checkpoint Message Size</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Checkpoint Message Size</em>' attribute.
	 * @see #setCheckpointMessageSize(String)
	 * @see com.ibm.ccl.soa.deploy.mq.MqPackage#getMQQueueManager_CheckpointMessageSize()
	 * @model dataType="org.eclipse.emf.ecore.xml.type.String"
	 *        extendedMetaData="kind='attribute' name='CheckpointMessageSize'"
	 * @generated
	 */
	String getCheckpointMessageSize();

	/**
	 * Sets the value of the '{@link com.ibm.ccl.soa.deploy.mq.MQQueueManager#getCheckpointMessageSize <em>Checkpoint Message Size</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Checkpoint Message Size</em>' attribute.
	 * @see #getCheckpointMessageSize()
	 * @generated
	 */
	void setCheckpointMessageSize(String value);

	/**
	 * Returns the value of the '<em><b>Checkpoint Restart Count</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Checkpoint Restart Count</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Checkpoint Restart Count</em>' attribute.
	 * @see #setCheckpointRestartCount(String)
	 * @see com.ibm.ccl.soa.deploy.mq.MqPackage#getMQQueueManager_CheckpointRestartCount()
	 * @model dataType="org.eclipse.emf.ecore.xml.type.String"
	 *        extendedMetaData="kind='attribute' name='CheckpointRestartCount'"
	 * @generated
	 */
	String getCheckpointRestartCount();

	/**
	 * Sets the value of the '{@link com.ibm.ccl.soa.deploy.mq.MQQueueManager#getCheckpointRestartCount <em>Checkpoint Restart Count</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Checkpoint Restart Count</em>' attribute.
	 * @see #getCheckpointRestartCount()
	 * @generated
	 */
	void setCheckpointRestartCount(String value);

	/**
	 * Returns the value of the '<em><b>Cluster Sender Monitoring</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Cluster Sender Monitoring</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Cluster Sender Monitoring</em>' attribute.
	 * @see #setClusterSenderMonitoring(String)
	 * @see com.ibm.ccl.soa.deploy.mq.MqPackage#getMQQueueManager_ClusterSenderMonitoring()
	 * @model dataType="org.eclipse.emf.ecore.xml.type.String"
	 *        extendedMetaData="kind='attribute' name='ClusterSenderMonitoring'"
	 * @generated
	 */
	String getClusterSenderMonitoring();

	/**
	 * Sets the value of the '{@link com.ibm.ccl.soa.deploy.mq.MQQueueManager#getClusterSenderMonitoring <em>Cluster Sender Monitoring</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Cluster Sender Monitoring</em>' attribute.
	 * @see #getClusterSenderMonitoring()
	 * @generated
	 */
	void setClusterSenderMonitoring(String value);

	/**
	 * Returns the value of the '<em><b>Cluster Sender Statistics</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Cluster Sender Statistics</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Cluster Sender Statistics</em>' attribute.
	 * @see #setClusterSenderStatistics(String)
	 * @see com.ibm.ccl.soa.deploy.mq.MqPackage#getMQQueueManager_ClusterSenderStatistics()
	 * @model dataType="org.eclipse.emf.ecore.xml.type.String"
	 *        extendedMetaData="kind='attribute' name='ClusterSenderStatistics'"
	 * @generated
	 */
	String getClusterSenderStatistics();

	/**
	 * Sets the value of the '{@link com.ibm.ccl.soa.deploy.mq.MQQueueManager#getClusterSenderStatistics <em>Cluster Sender Statistics</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Cluster Sender Statistics</em>' attribute.
	 * @see #getClusterSenderStatistics()
	 * @generated
	 */
	void setClusterSenderStatistics(String value);

	/**
	 * Returns the value of the '<em><b>Cluster Work Load Data</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Cluster Work Load Data</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Cluster Work Load Data</em>' attribute.
	 * @see #setClusterWorkLoadData(String)
	 * @see com.ibm.ccl.soa.deploy.mq.MqPackage#getMQQueueManager_ClusterWorkLoadData()
	 * @model dataType="org.eclipse.emf.ecore.xml.type.String"
	 *        extendedMetaData="kind='attribute' name='ClusterWorkLoadData'"
	 * @generated
	 */
	String getClusterWorkLoadData();

	/**
	 * Sets the value of the '{@link com.ibm.ccl.soa.deploy.mq.MQQueueManager#getClusterWorkLoadData <em>Cluster Work Load Data</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Cluster Work Load Data</em>' attribute.
	 * @see #getClusterWorkLoadData()
	 * @generated
	 */
	void setClusterWorkLoadData(String value);

	/**
	 * Returns the value of the '<em><b>Cluster Work Load Exit</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Cluster Work Load Exit</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Cluster Work Load Exit</em>' attribute.
	 * @see #setClusterWorkLoadExit(String)
	 * @see com.ibm.ccl.soa.deploy.mq.MqPackage#getMQQueueManager_ClusterWorkLoadExit()
	 * @model dataType="org.eclipse.emf.ecore.xml.type.String"
	 *        extendedMetaData="kind='attribute' name='ClusterWorkLoadExit'"
	 * @generated
	 */
	String getClusterWorkLoadExit();

	/**
	 * Sets the value of the '{@link com.ibm.ccl.soa.deploy.mq.MQQueueManager#getClusterWorkLoadExit <em>Cluster Work Load Exit</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Cluster Work Load Exit</em>' attribute.
	 * @see #getClusterWorkLoadExit()
	 * @generated
	 */
	void setClusterWorkLoadExit(String value);

	/**
	 * Returns the value of the '<em><b>Cluster Work Load Length</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Cluster Work Load Length</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Cluster Work Load Length</em>' attribute.
	 * @see #setClusterWorkLoadLength(String)
	 * @see com.ibm.ccl.soa.deploy.mq.MqPackage#getMQQueueManager_ClusterWorkLoadLength()
	 * @model dataType="org.eclipse.emf.ecore.xml.type.String"
	 *        extendedMetaData="kind='attribute' name='ClusterWorkLoadLength'"
	 * @generated
	 */
	String getClusterWorkLoadLength();

	/**
	 * Sets the value of the '{@link com.ibm.ccl.soa.deploy.mq.MQQueueManager#getClusterWorkLoadLength <em>Cluster Work Load Length</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Cluster Work Load Length</em>' attribute.
	 * @see #getClusterWorkLoadLength()
	 * @generated
	 */
	void setClusterWorkLoadLength(String value);

	/**
	 * Returns the value of the '<em><b>Cluster Workload Use Q</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Cluster Workload Use Q</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Cluster Workload Use Q</em>' attribute.
	 * @see #setClusterWorkloadUseQ(String)
	 * @see com.ibm.ccl.soa.deploy.mq.MqPackage#getMQQueueManager_ClusterWorkloadUseQ()
	 * @model dataType="org.eclipse.emf.ecore.xml.type.String"
	 *        extendedMetaData="kind='attribute' name='ClusterWorkloadUseQ'"
	 * @generated
	 */
	String getClusterWorkloadUseQ();

	/**
	 * Sets the value of the '{@link com.ibm.ccl.soa.deploy.mq.MQQueueManager#getClusterWorkloadUseQ <em>Cluster Workload Use Q</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Cluster Workload Use Q</em>' attribute.
	 * @see #getClusterWorkloadUseQ()
	 * @generated
	 */
	void setClusterWorkloadUseQ(String value);

	/**
	 * Returns the value of the '<em><b>Coded Char Set Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Coded Char Set Id</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Coded Char Set Id</em>' attribute.
	 * @see #setCodedCharSetId(String)
	 * @see com.ibm.ccl.soa.deploy.mq.MqPackage#getMQQueueManager_CodedCharSetId()
	 * @model dataType="org.eclipse.emf.ecore.xml.type.String"
	 *        extendedMetaData="kind='attribute' name='CodedCharSetId'"
	 * @generated
	 */
	String getCodedCharSetId();

	/**
	 * Sets the value of the '{@link com.ibm.ccl.soa.deploy.mq.MQQueueManager#getCodedCharSetId <em>Coded Char Set Id</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Coded Char Set Id</em>' attribute.
	 * @see #getCodedCharSetId()
	 * @generated
	 */
	void setCodedCharSetId(String value);

	/**
	 * Returns the value of the '<em><b>Command Event</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Command Event</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Command Event</em>' attribute.
	 * @see #setCommandEvent(String)
	 * @see com.ibm.ccl.soa.deploy.mq.MqPackage#getMQQueueManager_CommandEvent()
	 * @model dataType="org.eclipse.emf.ecore.xml.type.String"
	 *        extendedMetaData="kind='attribute' name='CommandEvent'"
	 * @generated
	 */
	String getCommandEvent();

	/**
	 * Sets the value of the '{@link com.ibm.ccl.soa.deploy.mq.MQQueueManager#getCommandEvent <em>Command Event</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Command Event</em>' attribute.
	 * @see #getCommandEvent()
	 * @generated
	 */
	void setCommandEvent(String value);

	/**
	 * Returns the value of the '<em><b>Command Level</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Command Level</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Command Level</em>' attribute.
	 * @see #setCommandLevel(String)
	 * @see com.ibm.ccl.soa.deploy.mq.MqPackage#getMQQueueManager_CommandLevel()
	 * @model dataType="org.eclipse.emf.ecore.xml.type.String"
	 *        extendedMetaData="kind='attribute' name='CommandLevel'"
	 * @generated
	 */
	String getCommandLevel();

	/**
	 * Sets the value of the '{@link com.ibm.ccl.soa.deploy.mq.MQQueueManager#getCommandLevel <em>Command Level</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Command Level</em>' attribute.
	 * @see #getCommandLevel()
	 * @generated
	 */
	void setCommandLevel(String value);

	/**
	 * Returns the value of the '<em><b>Command Scope</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Command Scope</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Command Scope</em>' attribute.
	 * @see #setCommandScope(String)
	 * @see com.ibm.ccl.soa.deploy.mq.MqPackage#getMQQueueManager_CommandScope()
	 * @model dataType="org.eclipse.emf.ecore.xml.type.String"
	 *        extendedMetaData="kind='attribute' name='CommandScope'"
	 * @generated
	 */
	String getCommandScope();

	/**
	 * Sets the value of the '{@link com.ibm.ccl.soa.deploy.mq.MQQueueManager#getCommandScope <em>Command Scope</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Command Scope</em>' attribute.
	 * @see #getCommandScope()
	 * @generated
	 */
	void setCommandScope(String value);

	/**
	 * Returns the value of the '<em><b>Command Server Control</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Command Server Control</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Command Server Control</em>' attribute.
	 * @see #setCommandServerControl(String)
	 * @see com.ibm.ccl.soa.deploy.mq.MqPackage#getMQQueueManager_CommandServerControl()
	 * @model dataType="org.eclipse.emf.ecore.xml.type.String"
	 *        extendedMetaData="kind='attribute' name='CommandServerControl'"
	 * @generated
	 */
	String getCommandServerControl();

	/**
	 * Sets the value of the '{@link com.ibm.ccl.soa.deploy.mq.MQQueueManager#getCommandServerControl <em>Command Server Control</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Command Server Control</em>' attribute.
	 * @see #getCommandServerControl()
	 * @generated
	 */
	void setCommandServerControl(String value);

	/**
	 * Returns the value of the '<em><b>Configuration Event</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Configuration Event</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Configuration Event</em>' attribute.
	 * @see #setConfigurationEvent(String)
	 * @see com.ibm.ccl.soa.deploy.mq.MqPackage#getMQQueueManager_ConfigurationEvent()
	 * @model dataType="org.eclipse.emf.ecore.xml.type.String"
	 *        extendedMetaData="kind='attribute' name='ConfigurationEvent'"
	 * @generated
	 */
	String getConfigurationEvent();

	/**
	 * Sets the value of the '{@link com.ibm.ccl.soa.deploy.mq.MQQueueManager#getConfigurationEvent <em>Configuration Event</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Configuration Event</em>' attribute.
	 * @see #getConfigurationEvent()
	 * @generated
	 */
	void setConfigurationEvent(String value);

	/**
	 * Returns the value of the '<em><b>Confirm</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Confirm</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Confirm</em>' attribute.
	 * @see #setConfirm(String)
	 * @see com.ibm.ccl.soa.deploy.mq.MqPackage#getMQQueueManager_Confirm()
	 * @model dataType="org.eclipse.emf.ecore.xml.type.String"
	 *        extendedMetaData="kind='attribute' name='Confirm'"
	 * @generated
	 */
	String getConfirm();

	/**
	 * Sets the value of the '{@link com.ibm.ccl.soa.deploy.mq.MQQueueManager#getConfirm <em>Confirm</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Confirm</em>' attribute.
	 * @see #getConfirm()
	 * @generated
	 */
	void setConfirm(String value);

	/**
	 * Returns the value of the '<em><b>Dead Letter Queue</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Dead Letter Queue</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Dead Letter Queue</em>' attribute.
	 * @see #setDeadLetterQueue(String)
	 * @see com.ibm.ccl.soa.deploy.mq.MqPackage#getMQQueueManager_DeadLetterQueue()
	 * @model dataType="org.eclipse.emf.ecore.xml.type.String"
	 *        extendedMetaData="kind='attribute' name='DeadLetterQueue'"
	 * @generated
	 */
	String getDeadLetterQueue();

	/**
	 * Sets the value of the '{@link com.ibm.ccl.soa.deploy.mq.MQQueueManager#getDeadLetterQueue <em>Dead Letter Queue</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Dead Letter Queue</em>' attribute.
	 * @see #getDeadLetterQueue()
	 * @generated
	 */
	void setDeadLetterQueue(String value);

	/**
	 * Returns the value of the '<em><b>Default Bind Type</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Default Bind Type</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Default Bind Type</em>' attribute.
	 * @see #setDefaultBindType(String)
	 * @see com.ibm.ccl.soa.deploy.mq.MqPackage#getMQQueueManager_DefaultBindType()
	 * @model dataType="org.eclipse.emf.ecore.xml.type.String"
	 *        extendedMetaData="kind='attribute' name='DefaultBindType'"
	 * @generated
	 */
	String getDefaultBindType();

	/**
	 * Sets the value of the '{@link com.ibm.ccl.soa.deploy.mq.MQQueueManager#getDefaultBindType <em>Default Bind Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Default Bind Type</em>' attribute.
	 * @see #getDefaultBindType()
	 * @generated
	 */
	void setDefaultBindType(String value);

	/**
	 * Returns the value of the '<em><b>Default Transmission Queue</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Default Transmission Queue</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Default Transmission Queue</em>' attribute.
	 * @see #setDefaultTransmissionQueue(String)
	 * @see com.ibm.ccl.soa.deploy.mq.MqPackage#getMQQueueManager_DefaultTransmissionQueue()
	 * @model dataType="org.eclipse.emf.ecore.xml.type.String"
	 *        extendedMetaData="kind='attribute' name='DefaultTransmissionQueue'"
	 * @generated
	 */
	String getDefaultTransmissionQueue();

	/**
	 * Sets the value of the '{@link com.ibm.ccl.soa.deploy.mq.MQQueueManager#getDefaultTransmissionQueue <em>Default Transmission Queue</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Default Transmission Queue</em>' attribute.
	 * @see #getDefaultTransmissionQueue()
	 * @generated
	 */
	void setDefaultTransmissionQueue(String value);

	/**
	 * Returns the value of the '<em><b>Description1</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Description1</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Description1</em>' attribute.
	 * @see #setDescription1(String)
	 * @see com.ibm.ccl.soa.deploy.mq.MqPackage#getMQQueueManager_Description1()
	 * @model dataType="org.eclipse.emf.ecore.xml.type.String"
	 *        extendedMetaData="kind='attribute' name='Description'"
	 * @generated
	 */
	String getDescription1();

	/**
	 * Sets the value of the '{@link com.ibm.ccl.soa.deploy.mq.MQQueueManager#getDescription1 <em>Description1</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Description1</em>' attribute.
	 * @see #getDescription1()
	 * @generated
	 */
	void setDescription1(String value);

	/**
	 * Returns the value of the '<em><b>DNS Group</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>DNS Group</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>DNS Group</em>' attribute.
	 * @see #setDNSGroup(String)
	 * @see com.ibm.ccl.soa.deploy.mq.MqPackage#getMQQueueManager_DNSGroup()
	 * @model dataType="org.eclipse.emf.ecore.xml.type.String"
	 *        extendedMetaData="kind='attribute' name='DNSGroup'"
	 * @generated
	 */
	String getDNSGroup();

	/**
	 * Sets the value of the '{@link com.ibm.ccl.soa.deploy.mq.MQQueueManager#getDNSGroup <em>DNS Group</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>DNS Group</em>' attribute.
	 * @see #getDNSGroup()
	 * @generated
	 */
	void setDNSGroup(String value);

	/**
	 * Returns the value of the '<em><b>DNSWLM</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>DNSWLM</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>DNSWLM</em>' attribute.
	 * @see #setDNSWLM(String)
	 * @see com.ibm.ccl.soa.deploy.mq.MqPackage#getMQQueueManager_DNSWLM()
	 * @model dataType="org.eclipse.emf.ecore.xml.type.String"
	 *        extendedMetaData="kind='attribute' name='DNSWLM'"
	 * @generated
	 */
	String getDNSWLM();

	/**
	 * Sets the value of the '{@link com.ibm.ccl.soa.deploy.mq.MQQueueManager#getDNSWLM <em>DNSWLM</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>DNSWLM</em>' attribute.
	 * @see #getDNSWLM()
	 * @generated
	 */
	void setDNSWLM(String value);

	/**
	 * Returns the value of the '<em><b>Error Log Size</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Error Log Size</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Error Log Size</em>' attribute.
	 * @see #setErrorLogSize(String)
	 * @see com.ibm.ccl.soa.deploy.mq.MqPackage#getMQQueueManager_ErrorLogSize()
	 * @model dataType="org.eclipse.emf.ecore.xml.type.String"
	 *        extendedMetaData="kind='attribute' name='ErrorLogSize'"
	 * @generated
	 */
	String getErrorLogSize();

	/**
	 * Sets the value of the '{@link com.ibm.ccl.soa.deploy.mq.MQQueueManager#getErrorLogSize <em>Error Log Size</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Error Log Size</em>' attribute.
	 * @see #getErrorLogSize()
	 * @generated
	 */
	void setErrorLogSize(String value);

	/**
	 * Returns the value of the '<em><b>Excluded Messages</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Excluded Messages</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Excluded Messages</em>' attribute.
	 * @see #setExcludedMessages(String)
	 * @see com.ibm.ccl.soa.deploy.mq.MqPackage#getMQQueueManager_ExcludedMessages()
	 * @model dataType="org.eclipse.emf.ecore.xml.type.String"
	 *        extendedMetaData="kind='attribute' name='ExcludedMessages'"
	 * @generated
	 */
	String getExcludedMessages();

	/**
	 * Sets the value of the '{@link com.ibm.ccl.soa.deploy.mq.MQQueueManager#getExcludedMessages <em>Excluded Messages</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Excluded Messages</em>' attribute.
	 * @see #getExcludedMessages()
	 * @generated
	 */
	void setExcludedMessages(String value);

	/**
	 * Returns the value of the '<em><b>Exits Default Path</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Exits Default Path</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Exits Default Path</em>' attribute.
	 * @see #setExitsDefaultPath(String)
	 * @see com.ibm.ccl.soa.deploy.mq.MqPackage#getMQQueueManager_ExitsDefaultPath()
	 * @model dataType="org.eclipse.emf.ecore.xml.type.String"
	 *        extendedMetaData="kind='attribute' name='ExitsDefaultPath'"
	 * @generated
	 */
	String getExitsDefaultPath();

	/**
	 * Sets the value of the '{@link com.ibm.ccl.soa.deploy.mq.MQQueueManager#getExitsDefaultPath <em>Exits Default Path</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Exits Default Path</em>' attribute.
	 * @see #getExitsDefaultPath()
	 * @generated
	 */
	void setExitsDefaultPath(String value);

	/**
	 * Returns the value of the '<em><b>Expiry Interval</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Expiry Interval</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Expiry Interval</em>' attribute.
	 * @see #setExpiryInterval(String)
	 * @see com.ibm.ccl.soa.deploy.mq.MqPackage#getMQQueueManager_ExpiryInterval()
	 * @model dataType="org.eclipse.emf.ecore.xml.type.String"
	 *        extendedMetaData="kind='attribute' name='ExpiryInterval'"
	 * @generated
	 */
	String getExpiryInterval();

	/**
	 * Sets the value of the '{@link com.ibm.ccl.soa.deploy.mq.MQQueueManager#getExpiryInterval <em>Expiry Interval</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Expiry Interval</em>' attribute.
	 * @see #getExpiryInterval()
	 * @generated
	 */
	void setExpiryInterval(String value);

	/**
	 * Returns the value of the '<em><b>IGQ Put Authority</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>IGQ Put Authority</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>IGQ Put Authority</em>' attribute.
	 * @see #setIGQPutAuthority(String)
	 * @see com.ibm.ccl.soa.deploy.mq.MqPackage#getMQQueueManager_IGQPutAuthority()
	 * @model dataType="org.eclipse.emf.ecore.xml.type.String"
	 *        extendedMetaData="kind='attribute' name='IGQPutAuthority'"
	 * @generated
	 */
	String getIGQPutAuthority();

	/**
	 * Sets the value of the '{@link com.ibm.ccl.soa.deploy.mq.MQQueueManager#getIGQPutAuthority <em>IGQ Put Authority</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>IGQ Put Authority</em>' attribute.
	 * @see #getIGQPutAuthority()
	 * @generated
	 */
	void setIGQPutAuthority(String value);

	/**
	 * Returns the value of the '<em><b>IGQ User Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>IGQ User Id</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>IGQ User Id</em>' attribute.
	 * @see #setIGQUserId(String)
	 * @see com.ibm.ccl.soa.deploy.mq.MqPackage#getMQQueueManager_IGQUserId()
	 * @model dataType="org.eclipse.emf.ecore.xml.type.String"
	 *        extendedMetaData="kind='attribute' name='IGQUserId'"
	 * @generated
	 */
	String getIGQUserId();

	/**
	 * Sets the value of the '{@link com.ibm.ccl.soa.deploy.mq.MQQueueManager#getIGQUserId <em>IGQ User Id</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>IGQ User Id</em>' attribute.
	 * @see #getIGQUserId()
	 * @generated
	 */
	void setIGQUserId(String value);

	/**
	 * Returns the value of the '<em><b>Inhibit Event</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Inhibit Event</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Inhibit Event</em>' attribute.
	 * @see #setInhibitEvent(String)
	 * @see com.ibm.ccl.soa.deploy.mq.MqPackage#getMQQueueManager_InhibitEvent()
	 * @model dataType="org.eclipse.emf.ecore.xml.type.String"
	 *        extendedMetaData="kind='attribute' name='InhibitEvent'"
	 * @generated
	 */
	String getInhibitEvent();

	/**
	 * Sets the value of the '{@link com.ibm.ccl.soa.deploy.mq.MQQueueManager#getInhibitEvent <em>Inhibit Event</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Inhibit Event</em>' attribute.
	 * @see #getInhibitEvent()
	 * @generated
	 */
	void setInhibitEvent(String value);

	/**
	 * Returns the value of the '<em><b>Installable Service Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Installable Service Name</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Installable Service Name</em>' attribute.
	 * @see #setInstallableServiceName(String)
	 * @see com.ibm.ccl.soa.deploy.mq.MqPackage#getMQQueueManager_InstallableServiceName()
	 * @model dataType="org.eclipse.emf.ecore.xml.type.String"
	 *        extendedMetaData="kind='attribute' name='InstallableServiceName'"
	 * @generated
	 */
	String getInstallableServiceName();

	/**
	 * Sets the value of the '{@link com.ibm.ccl.soa.deploy.mq.MQQueueManager#getInstallableServiceName <em>Installable Service Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Installable Service Name</em>' attribute.
	 * @see #getInstallableServiceName()
	 * @generated
	 */
	void setInstallableServiceName(String value);

	/**
	 * Returns the value of the '<em><b>Intra Group Queuing</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Intra Group Queuing</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Intra Group Queuing</em>' attribute.
	 * @see #setIntraGroupQueuing(String)
	 * @see com.ibm.ccl.soa.deploy.mq.MqPackage#getMQQueueManager_IntraGroupQueuing()
	 * @model dataType="org.eclipse.emf.ecore.xml.type.String"
	 *        extendedMetaData="kind='attribute' name='IntraGroupQueuing'"
	 * @generated
	 */
	String getIntraGroupQueuing();

	/**
	 * Sets the value of the '{@link com.ibm.ccl.soa.deploy.mq.MQQueueManager#getIntraGroupQueuing <em>Intra Group Queuing</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Intra Group Queuing</em>' attribute.
	 * @see #getIntraGroupQueuing()
	 * @generated
	 */
	void setIntraGroupQueuing(String value);

	/**
	 * Returns the value of the '<em><b>IP Address Version</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>IP Address Version</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>IP Address Version</em>' attribute.
	 * @see #setIPAddressVersion(String)
	 * @see com.ibm.ccl.soa.deploy.mq.MqPackage#getMQQueueManager_IPAddressVersion()
	 * @model dataType="org.eclipse.emf.ecore.xml.type.String"
	 *        extendedMetaData="kind='attribute' name='IPAddressVersion'"
	 * @generated
	 */
	String getIPAddressVersion();

	/**
	 * Sets the value of the '{@link com.ibm.ccl.soa.deploy.mq.MQQueueManager#getIPAddressVersion <em>IP Address Version</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>IP Address Version</em>' attribute.
	 * @see #getIPAddressVersion()
	 * @generated
	 */
	void setIPAddressVersion(String value);

	/**
	 * Returns the value of the '<em><b>Listener Timer</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Listener Timer</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Listener Timer</em>' attribute.
	 * @see #setListenerTimer(String)
	 * @see com.ibm.ccl.soa.deploy.mq.MqPackage#getMQQueueManager_ListenerTimer()
	 * @model dataType="org.eclipse.emf.ecore.xml.type.String"
	 *        extendedMetaData="kind='attribute' name='ListenerTimer'"
	 * @generated
	 */
	String getListenerTimer();

	/**
	 * Sets the value of the '{@link com.ibm.ccl.soa.deploy.mq.MQQueueManager#getListenerTimer <em>Listener Timer</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Listener Timer</em>' attribute.
	 * @see #getListenerTimer()
	 * @generated
	 */
	void setListenerTimer(String value);

	/**
	 * Returns the value of the '<em><b>Local Event</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Local Event</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Local Event</em>' attribute.
	 * @see #setLocalEvent(String)
	 * @see com.ibm.ccl.soa.deploy.mq.MqPackage#getMQQueueManager_LocalEvent()
	 * @model dataType="org.eclipse.emf.ecore.xml.type.String"
	 *        extendedMetaData="kind='attribute' name='LocalEvent'"
	 * @generated
	 */
	String getLocalEvent();

	/**
	 * Sets the value of the '{@link com.ibm.ccl.soa.deploy.mq.MQQueueManager#getLocalEvent <em>Local Event</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Local Event</em>' attribute.
	 * @see #getLocalEvent()
	 * @generated
	 */
	void setLocalEvent(String value);

	/**
	 * Returns the value of the '<em><b>Log Buffer Pages</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Log Buffer Pages</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Log Buffer Pages</em>' attribute.
	 * @see #setLogBufferPages(String)
	 * @see com.ibm.ccl.soa.deploy.mq.MqPackage#getMQQueueManager_LogBufferPages()
	 * @model dataType="org.eclipse.emf.ecore.xml.type.String"
	 *        extendedMetaData="kind='attribute' name='LogBufferPages'"
	 * @generated
	 */
	String getLogBufferPages();

	/**
	 * Sets the value of the '{@link com.ibm.ccl.soa.deploy.mq.MQQueueManager#getLogBufferPages <em>Log Buffer Pages</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Log Buffer Pages</em>' attribute.
	 * @see #getLogBufferPages()
	 * @generated
	 */
	void setLogBufferPages(String value);

	/**
	 * Returns the value of the '<em><b>Log File Pages</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Log File Pages</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Log File Pages</em>' attribute.
	 * @see #setLogFilePages(String)
	 * @see com.ibm.ccl.soa.deploy.mq.MqPackage#getMQQueueManager_LogFilePages()
	 * @model dataType="org.eclipse.emf.ecore.xml.type.String"
	 *        extendedMetaData="kind='attribute' name='LogFilePages'"
	 * @generated
	 */
	String getLogFilePages();

	/**
	 * Sets the value of the '{@link com.ibm.ccl.soa.deploy.mq.MQQueueManager#getLogFilePages <em>Log File Pages</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Log File Pages</em>' attribute.
	 * @see #getLogFilePages()
	 * @generated
	 */
	void setLogFilePages(String value);

	/**
	 * Returns the value of the '<em><b>Log Path</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Log Path</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Log Path</em>' attribute.
	 * @see #setLogPath(String)
	 * @see com.ibm.ccl.soa.deploy.mq.MqPackage#getMQQueueManager_LogPath()
	 * @model dataType="org.eclipse.emf.ecore.xml.type.String"
	 *        extendedMetaData="kind='attribute' name='LogPath'"
	 * @generated
	 */
	String getLogPath();

	/**
	 * Sets the value of the '{@link com.ibm.ccl.soa.deploy.mq.MQQueueManager#getLogPath <em>Log Path</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Log Path</em>' attribute.
	 * @see #getLogPath()
	 * @generated
	 */
	void setLogPath(String value);

	/**
	 * Returns the value of the '<em><b>Log Primary Files</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Log Primary Files</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Log Primary Files</em>' attribute.
	 * @see #setLogPrimaryFiles(String)
	 * @see com.ibm.ccl.soa.deploy.mq.MqPackage#getMQQueueManager_LogPrimaryFiles()
	 * @model dataType="org.eclipse.emf.ecore.xml.type.String"
	 *        extendedMetaData="kind='attribute' name='LogPrimaryFiles'"
	 * @generated
	 */
	String getLogPrimaryFiles();

	/**
	 * Sets the value of the '{@link com.ibm.ccl.soa.deploy.mq.MQQueueManager#getLogPrimaryFiles <em>Log Primary Files</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Log Primary Files</em>' attribute.
	 * @see #getLogPrimaryFiles()
	 * @generated
	 */
	void setLogPrimaryFiles(String value);

	/**
	 * Returns the value of the '<em><b>Log Secondary Files</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Log Secondary Files</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Log Secondary Files</em>' attribute.
	 * @see #setLogSecondaryFiles(String)
	 * @see com.ibm.ccl.soa.deploy.mq.MqPackage#getMQQueueManager_LogSecondaryFiles()
	 * @model dataType="org.eclipse.emf.ecore.xml.type.String"
	 *        extendedMetaData="kind='attribute' name='LogSecondaryFiles'"
	 * @generated
	 */
	String getLogSecondaryFiles();

	/**
	 * Sets the value of the '{@link com.ibm.ccl.soa.deploy.mq.MQQueueManager#getLogSecondaryFiles <em>Log Secondary Files</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Log Secondary Files</em>' attribute.
	 * @see #getLogSecondaryFiles()
	 * @generated
	 */
	void setLogSecondaryFiles(String value);

	/**
	 * Returns the value of the '<em><b>Log Type</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Log Type</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Log Type</em>' attribute.
	 * @see #setLogType(String)
	 * @see com.ibm.ccl.soa.deploy.mq.MqPackage#getMQQueueManager_LogType()
	 * @model dataType="org.eclipse.emf.ecore.xml.type.String"
	 *        extendedMetaData="kind='attribute' name='LogType'"
	 * @generated
	 */
	String getLogType();

	/**
	 * Sets the value of the '{@link com.ibm.ccl.soa.deploy.mq.MQQueueManager#getLogType <em>Log Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Log Type</em>' attribute.
	 * @see #getLogType()
	 * @generated
	 */
	void setLogType(String value);

	/**
	 * Returns the value of the '<em><b>Log Write Integrity</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Log Write Integrity</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Log Write Integrity</em>' attribute.
	 * @see #setLogWriteIntegrity(String)
	 * @see com.ibm.ccl.soa.deploy.mq.MqPackage#getMQQueueManager_LogWriteIntegrity()
	 * @model dataType="org.eclipse.emf.ecore.xml.type.String"
	 *        extendedMetaData="kind='attribute' name='LogWriteIntegrity'"
	 * @generated
	 */
	String getLogWriteIntegrity();

	/**
	 * Sets the value of the '{@link com.ibm.ccl.soa.deploy.mq.MQQueueManager#getLogWriteIntegrity <em>Log Write Integrity</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Log Write Integrity</em>' attribute.
	 * @see #getLogWriteIntegrity()
	 * @generated
	 */
	void setLogWriteIntegrity(String value);

	/**
	 * Returns the value of the '<em><b>LU62ARM Suffix</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>LU62ARM Suffix</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>LU62ARM Suffix</em>' attribute.
	 * @see #setLU62ARMSuffix(String)
	 * @see com.ibm.ccl.soa.deploy.mq.MqPackage#getMQQueueManager_LU62ARMSuffix()
	 * @model dataType="org.eclipse.emf.ecore.xml.type.String"
	 *        extendedMetaData="kind='attribute' name='LU62ARMSuffix'"
	 * @generated
	 */
	String getLU62ARMSuffix();

	/**
	 * Sets the value of the '{@link com.ibm.ccl.soa.deploy.mq.MQQueueManager#getLU62ARMSuffix <em>LU62ARM Suffix</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>LU62ARM Suffix</em>' attribute.
	 * @see #getLU62ARMSuffix()
	 * @generated
	 */
	void setLU62ARMSuffix(String value);

	/**
	 * Returns the value of the '<em><b>LU62 Channels</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>LU62 Channels</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>LU62 Channels</em>' attribute.
	 * @see #setLU62Channels(String)
	 * @see com.ibm.ccl.soa.deploy.mq.MqPackage#getMQQueueManager_LU62Channels()
	 * @model dataType="org.eclipse.emf.ecore.xml.type.String"
	 *        extendedMetaData="kind='attribute' name='LU62Channels'"
	 * @generated
	 */
	String getLU62Channels();

	/**
	 * Sets the value of the '{@link com.ibm.ccl.soa.deploy.mq.MQQueueManager#getLU62Channels <em>LU62 Channels</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>LU62 Channels</em>' attribute.
	 * @see #getLU62Channels()
	 * @generated
	 */
	void setLU62Channels(String value);

	/**
	 * Returns the value of the '<em><b>LU Group Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>LU Group Name</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>LU Group Name</em>' attribute.
	 * @see #setLUGroupName(String)
	 * @see com.ibm.ccl.soa.deploy.mq.MqPackage#getMQQueueManager_LUGroupName()
	 * @model dataType="org.eclipse.emf.ecore.xml.type.String"
	 *        extendedMetaData="kind='attribute' name='LUGroupName'"
	 * @generated
	 */
	String getLUGroupName();

	/**
	 * Sets the value of the '{@link com.ibm.ccl.soa.deploy.mq.MQQueueManager#getLUGroupName <em>LU Group Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>LU Group Name</em>' attribute.
	 * @see #getLUGroupName()
	 * @generated
	 */
	void setLUGroupName(String value);

	/**
	 * Returns the value of the '<em><b>LU Library1</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>LU Library1</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>LU Library1</em>' attribute.
	 * @see #setLULibrary1(String)
	 * @see com.ibm.ccl.soa.deploy.mq.MqPackage#getMQQueueManager_LULibrary1()
	 * @model dataType="org.eclipse.emf.ecore.xml.type.String"
	 *        extendedMetaData="kind='attribute' name='LULibrary1'"
	 * @generated
	 */
	String getLULibrary1();

	/**
	 * Sets the value of the '{@link com.ibm.ccl.soa.deploy.mq.MQQueueManager#getLULibrary1 <em>LU Library1</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>LU Library1</em>' attribute.
	 * @see #getLULibrary1()
	 * @generated
	 */
	void setLULibrary1(String value);

	/**
	 * Returns the value of the '<em><b>LU Library2</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>LU Library2</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>LU Library2</em>' attribute.
	 * @see #setLULibrary2(String)
	 * @see com.ibm.ccl.soa.deploy.mq.MqPackage#getMQQueueManager_LULibrary2()
	 * @model dataType="org.eclipse.emf.ecore.xml.type.String"
	 *        extendedMetaData="kind='attribute' name='LULibrary2'"
	 * @generated
	 */
	String getLULibrary2();

	/**
	 * Sets the value of the '{@link com.ibm.ccl.soa.deploy.mq.MQQueueManager#getLULibrary2 <em>LU Library2</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>LU Library2</em>' attribute.
	 * @see #getLULibrary2()
	 * @generated
	 */
	void setLULibrary2(String value);

	/**
	 * Returns the value of the '<em><b>LU Local LU</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>LU Local LU</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>LU Local LU</em>' attribute.
	 * @see #setLULocalLU(String)
	 * @see com.ibm.ccl.soa.deploy.mq.MqPackage#getMQQueueManager_LULocalLU()
	 * @model dataType="org.eclipse.emf.ecore.xml.type.String"
	 *        extendedMetaData="kind='attribute' name='LULocalLU'"
	 * @generated
	 */
	String getLULocalLU();

	/**
	 * Sets the value of the '{@link com.ibm.ccl.soa.deploy.mq.MQQueueManager#getLULocalLU <em>LU Local LU</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>LU Local LU</em>' attribute.
	 * @see #getLULocalLU()
	 * @generated
	 */
	void setLULocalLU(String value);

	/**
	 * Returns the value of the '<em><b>LU Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>LU Name</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>LU Name</em>' attribute.
	 * @see #setLUName(String)
	 * @see com.ibm.ccl.soa.deploy.mq.MqPackage#getMQQueueManager_LUName()
	 * @model dataType="org.eclipse.emf.ecore.xml.type.String"
	 *        extendedMetaData="kind='attribute' name='LUName'"
	 * @generated
	 */
	String getLUName();

	/**
	 * Sets the value of the '{@link com.ibm.ccl.soa.deploy.mq.MQQueueManager#getLUName <em>LU Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>LU Name</em>' attribute.
	 * @see #getLUName()
	 * @generated
	 */
	void setLUName(String value);

	/**
	 * Returns the value of the '<em><b>LUTP Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>LUTP Name</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>LUTP Name</em>' attribute.
	 * @see #setLUTPName(String)
	 * @see com.ibm.ccl.soa.deploy.mq.MqPackage#getMQQueueManager_LUTPName()
	 * @model dataType="org.eclipse.emf.ecore.xml.type.String"
	 *        extendedMetaData="kind='attribute' name='LUTPName'"
	 * @generated
	 */
	String getLUTPName();

	/**
	 * Sets the value of the '{@link com.ibm.ccl.soa.deploy.mq.MQQueueManager#getLUTPName <em>LUTP Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>LUTP Name</em>' attribute.
	 * @see #getLUTPName()
	 * @generated
	 */
	void setLUTPName(String value);

	/**
	 * Returns the value of the '<em><b>Max Active Channels</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Max Active Channels</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Max Active Channels</em>' attribute.
	 * @see #setMaxActiveChannels(String)
	 * @see com.ibm.ccl.soa.deploy.mq.MqPackage#getMQQueueManager_MaxActiveChannels()
	 * @model dataType="org.eclipse.emf.ecore.xml.type.String"
	 *        extendedMetaData="kind='attribute' name='MaxActiveChannels'"
	 * @generated
	 */
	String getMaxActiveChannels();

	/**
	 * Sets the value of the '{@link com.ibm.ccl.soa.deploy.mq.MQQueueManager#getMaxActiveChannels <em>Max Active Channels</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Max Active Channels</em>' attribute.
	 * @see #getMaxActiveChannels()
	 * @generated
	 */
	void setMaxActiveChannels(String value);

	/**
	 * Returns the value of the '<em><b>Max Channels</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Max Channels</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Max Channels</em>' attribute.
	 * @see #setMaxChannels(String)
	 * @see com.ibm.ccl.soa.deploy.mq.MqPackage#getMQQueueManager_MaxChannels()
	 * @model dataType="org.eclipse.emf.ecore.xml.type.String"
	 *        extendedMetaData="kind='attribute' name='MaxChannels'"
	 * @generated
	 */
	String getMaxChannels();

	/**
	 * Sets the value of the '{@link com.ibm.ccl.soa.deploy.mq.MQQueueManager#getMaxChannels <em>Max Channels</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Max Channels</em>' attribute.
	 * @see #getMaxChannels()
	 * @generated
	 */
	void setMaxChannels(String value);

	/**
	 * Returns the value of the '<em><b>Maximum Current Channels</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Maximum Current Channels</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Maximum Current Channels</em>' attribute.
	 * @see #setMaximumCurrentChannels(String)
	 * @see com.ibm.ccl.soa.deploy.mq.MqPackage#getMQQueueManager_MaximumCurrentChannels()
	 * @model dataType="org.eclipse.emf.ecore.xml.type.String"
	 *        extendedMetaData="kind='attribute' name='MaximumCurrentChannels'"
	 * @generated
	 */
	String getMaximumCurrentChannels();

	/**
	 * Sets the value of the '{@link com.ibm.ccl.soa.deploy.mq.MQQueueManager#getMaximumCurrentChannels <em>Maximum Current Channels</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Maximum Current Channels</em>' attribute.
	 * @see #getMaximumCurrentChannels()
	 * @generated
	 */
	void setMaximumCurrentChannels(String value);

	/**
	 * Returns the value of the '<em><b>Maximum Handles</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Maximum Handles</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Maximum Handles</em>' attribute.
	 * @see #setMaximumHandles(String)
	 * @see com.ibm.ccl.soa.deploy.mq.MqPackage#getMQQueueManager_MaximumHandles()
	 * @model dataType="org.eclipse.emf.ecore.xml.type.String"
	 *        extendedMetaData="kind='attribute' name='MaximumHandles'"
	 * @generated
	 */
	String getMaximumHandles();

	/**
	 * Sets the value of the '{@link com.ibm.ccl.soa.deploy.mq.MQQueueManager#getMaximumHandles <em>Maximum Handles</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Maximum Handles</em>' attribute.
	 * @see #getMaximumHandles()
	 * @generated
	 */
	void setMaximumHandles(String value);

	/**
	 * Returns the value of the '<em><b>Maximum Message Length</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Maximum Message Length</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Maximum Message Length</em>' attribute.
	 * @see #setMaximumMessageLength(String)
	 * @see com.ibm.ccl.soa.deploy.mq.MqPackage#getMQQueueManager_MaximumMessageLength()
	 * @model dataType="org.eclipse.emf.ecore.xml.type.String"
	 *        extendedMetaData="kind='attribute' name='MaximumMessageLength'"
	 * @generated
	 */
	String getMaximumMessageLength();

	/**
	 * Sets the value of the '{@link com.ibm.ccl.soa.deploy.mq.MQQueueManager#getMaximumMessageLength <em>Maximum Message Length</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Maximum Message Length</em>' attribute.
	 * @see #getMaximumMessageLength()
	 * @generated
	 */
	void setMaximumMessageLength(String value);

	/**
	 * Returns the value of the '<em><b>Maximum TCP Channels</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Maximum TCP Channels</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Maximum TCP Channels</em>' attribute.
	 * @see #setMaximumTCPChannels(String)
	 * @see com.ibm.ccl.soa.deploy.mq.MqPackage#getMQQueueManager_MaximumTCPChannels()
	 * @model dataType="org.eclipse.emf.ecore.xml.type.String"
	 *        extendedMetaData="kind='attribute' name='MaximumTCPChannels'"
	 * @generated
	 */
	String getMaximumTCPChannels();

	/**
	 * Sets the value of the '{@link com.ibm.ccl.soa.deploy.mq.MQQueueManager#getMaximumTCPChannels <em>Maximum TCP Channels</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Maximum TCP Channels</em>' attribute.
	 * @see #getMaximumTCPChannels()
	 * @generated
	 */
	void setMaximumTCPChannels(String value);

	/**
	 * Returns the value of the '<em><b>Maximum Uncommitted Messages</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Maximum Uncommitted Messages</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Maximum Uncommitted Messages</em>' attribute.
	 * @see #setMaximumUncommittedMessages(String)
	 * @see com.ibm.ccl.soa.deploy.mq.MqPackage#getMQQueueManager_MaximumUncommittedMessages()
	 * @model dataType="org.eclipse.emf.ecore.xml.type.String"
	 *        extendedMetaData="kind='attribute' name='MaximumUncommittedMessages'"
	 * @generated
	 */
	String getMaximumUncommittedMessages();

	/**
	 * Sets the value of the '{@link com.ibm.ccl.soa.deploy.mq.MQQueueManager#getMaximumUncommittedMessages <em>Maximum Uncommitted Messages</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Maximum Uncommitted Messages</em>' attribute.
	 * @see #getMaximumUncommittedMessages()
	 * @generated
	 */
	void setMaximumUncommittedMessages(String value);

	/**
	 * Returns the value of the '<em><b>Max Initiators</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Max Initiators</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Max Initiators</em>' attribute.
	 * @see #setMaxInitiators(String)
	 * @see com.ibm.ccl.soa.deploy.mq.MqPackage#getMQQueueManager_MaxInitiators()
	 * @model dataType="org.eclipse.emf.ecore.xml.type.String"
	 *        extendedMetaData="kind='attribute' name='MaxInitiators'"
	 * @generated
	 */
	String getMaxInitiators();

	/**
	 * Sets the value of the '{@link com.ibm.ccl.soa.deploy.mq.MQQueueManager#getMaxInitiators <em>Max Initiators</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Max Initiators</em>' attribute.
	 * @see #getMaxInitiators()
	 * @generated
	 */
	void setMaxInitiators(String value);

	/**
	 * Returns the value of the '<em><b>MQI Accounting</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>MQI Accounting</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>MQI Accounting</em>' attribute.
	 * @see #setMQIAccounting(String)
	 * @see com.ibm.ccl.soa.deploy.mq.MqPackage#getMQQueueManager_MQIAccounting()
	 * @model dataType="org.eclipse.emf.ecore.xml.type.String"
	 *        extendedMetaData="kind='attribute' name='MQIAccounting'"
	 * @generated
	 */
	String getMQIAccounting();

	/**
	 * Sets the value of the '{@link com.ibm.ccl.soa.deploy.mq.MQQueueManager#getMQIAccounting <em>MQI Accounting</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>MQI Accounting</em>' attribute.
	 * @see #getMQIAccounting()
	 * @generated
	 */
	void setMQIAccounting(String value);

	/**
	 * Returns the value of the '<em><b>MQI Bind Type</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>MQI Bind Type</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>MQI Bind Type</em>' attribute.
	 * @see #setMQIBindType(String)
	 * @see com.ibm.ccl.soa.deploy.mq.MqPackage#getMQQueueManager_MQIBindType()
	 * @model dataType="org.eclipse.emf.ecore.xml.type.String"
	 *        extendedMetaData="kind='attribute' name='MQIBindType'"
	 * @generated
	 */
	String getMQIBindType();

	/**
	 * Sets the value of the '{@link com.ibm.ccl.soa.deploy.mq.MQQueueManager#getMQIBindType <em>MQI Bind Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>MQI Bind Type</em>' attribute.
	 * @see #getMQIBindType()
	 * @generated
	 */
	void setMQIBindType(String value);

	/**
	 * Returns the value of the '<em><b>MQI Statistics</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>MQI Statistics</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>MQI Statistics</em>' attribute.
	 * @see #setMQIStatistics(String)
	 * @see com.ibm.ccl.soa.deploy.mq.MqPackage#getMQQueueManager_MQIStatistics()
	 * @model dataType="org.eclipse.emf.ecore.xml.type.String"
	 *        extendedMetaData="kind='attribute' name='MQIStatistics'"
	 * @generated
	 */
	String getMQIStatistics();

	/**
	 * Sets the value of the '{@link com.ibm.ccl.soa.deploy.mq.MQQueueManager#getMQIStatistics <em>MQI Statistics</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>MQI Statistics</em>' attribute.
	 * @see #getMQIStatistics()
	 * @generated
	 */
	void setMQIStatistics(String value);

	/**
	 * Returns the value of the '<em><b>Net Bios Adaptor Number</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Net Bios Adaptor Number</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Net Bios Adaptor Number</em>' attribute.
	 * @see #setNetBiosAdaptorNumber(String)
	 * @see com.ibm.ccl.soa.deploy.mq.MqPackage#getMQQueueManager_NetBiosAdaptorNumber()
	 * @model dataType="org.eclipse.emf.ecore.xml.type.String"
	 *        extendedMetaData="kind='attribute' name='NetBiosAdaptorNumber'"
	 * @generated
	 */
	String getNetBiosAdaptorNumber();

	/**
	 * Sets the value of the '{@link com.ibm.ccl.soa.deploy.mq.MQQueueManager#getNetBiosAdaptorNumber <em>Net Bios Adaptor Number</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Net Bios Adaptor Number</em>' attribute.
	 * @see #getNetBiosAdaptorNumber()
	 * @generated
	 */
	void setNetBiosAdaptorNumber(String value);

	/**
	 * Returns the value of the '<em><b>Net Bios Library1</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Net Bios Library1</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Net Bios Library1</em>' attribute.
	 * @see #setNetBiosLibrary1(String)
	 * @see com.ibm.ccl.soa.deploy.mq.MqPackage#getMQQueueManager_NetBiosLibrary1()
	 * @model dataType="org.eclipse.emf.ecore.xml.type.String"
	 *        extendedMetaData="kind='attribute' name='NetBiosLibrary1'"
	 * @generated
	 */
	String getNetBiosLibrary1();

	/**
	 * Sets the value of the '{@link com.ibm.ccl.soa.deploy.mq.MQQueueManager#getNetBiosLibrary1 <em>Net Bios Library1</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Net Bios Library1</em>' attribute.
	 * @see #getNetBiosLibrary1()
	 * @generated
	 */
	void setNetBiosLibrary1(String value);

	/**
	 * Returns the value of the '<em><b>Net Bios Local Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Net Bios Local Name</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Net Bios Local Name</em>' attribute.
	 * @see #setNetBiosLocalName(String)
	 * @see com.ibm.ccl.soa.deploy.mq.MqPackage#getMQQueueManager_NetBiosLocalName()
	 * @model dataType="org.eclipse.emf.ecore.xml.type.String"
	 *        extendedMetaData="kind='attribute' name='NetBiosLocalName'"
	 * @generated
	 */
	String getNetBiosLocalName();

	/**
	 * Sets the value of the '{@link com.ibm.ccl.soa.deploy.mq.MQQueueManager#getNetBiosLocalName <em>Net Bios Local Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Net Bios Local Name</em>' attribute.
	 * @see #getNetBiosLocalName()
	 * @generated
	 */
	void setNetBiosLocalName(String value);

	/**
	 * Returns the value of the '<em><b>Net Bios Number Of Commands</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Net Bios Number Of Commands</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Net Bios Number Of Commands</em>' attribute.
	 * @see #setNetBiosNumberOfCommands(String)
	 * @see com.ibm.ccl.soa.deploy.mq.MqPackage#getMQQueueManager_NetBiosNumberOfCommands()
	 * @model dataType="org.eclipse.emf.ecore.xml.type.String"
	 *        extendedMetaData="kind='attribute' name='NetBiosNumberOfCommands'"
	 * @generated
	 */
	String getNetBiosNumberOfCommands();

	/**
	 * Sets the value of the '{@link com.ibm.ccl.soa.deploy.mq.MQQueueManager#getNetBiosNumberOfCommands <em>Net Bios Number Of Commands</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Net Bios Number Of Commands</em>' attribute.
	 * @see #getNetBiosNumberOfCommands()
	 * @generated
	 */
	void setNetBiosNumberOfCommands(String value);

	/**
	 * Returns the value of the '<em><b>Net Bios Number Of Names</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Net Bios Number Of Names</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Net Bios Number Of Names</em>' attribute.
	 * @see #setNetBiosNumberOfNames(String)
	 * @see com.ibm.ccl.soa.deploy.mq.MqPackage#getMQQueueManager_NetBiosNumberOfNames()
	 * @model dataType="org.eclipse.emf.ecore.xml.type.String"
	 *        extendedMetaData="kind='attribute' name='NetBiosNumberOfNames'"
	 * @generated
	 */
	String getNetBiosNumberOfNames();

	/**
	 * Sets the value of the '{@link com.ibm.ccl.soa.deploy.mq.MQQueueManager#getNetBiosNumberOfNames <em>Net Bios Number Of Names</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Net Bios Number Of Names</em>' attribute.
	 * @see #getNetBiosNumberOfNames()
	 * @generated
	 */
	void setNetBiosNumberOfNames(String value);

	/**
	 * Returns the value of the '<em><b>Net Bios Number Of Sessions</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Net Bios Number Of Sessions</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Net Bios Number Of Sessions</em>' attribute.
	 * @see #setNetBiosNumberOfSessions(String)
	 * @see com.ibm.ccl.soa.deploy.mq.MqPackage#getMQQueueManager_NetBiosNumberOfSessions()
	 * @model dataType="org.eclipse.emf.ecore.xml.type.String"
	 *        extendedMetaData="kind='attribute' name='NetBiosNumberOfSessions'"
	 * @generated
	 */
	String getNetBiosNumberOfSessions();

	/**
	 * Sets the value of the '{@link com.ibm.ccl.soa.deploy.mq.MQQueueManager#getNetBiosNumberOfSessions <em>Net Bios Number Of Sessions</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Net Bios Number Of Sessions</em>' attribute.
	 * @see #getNetBiosNumberOfSessions()
	 * @generated
	 */
	void setNetBiosNumberOfSessions(String value);

	/**
	 * Returns the value of the '<em><b>Outbound Port Max</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Outbound Port Max</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Outbound Port Max</em>' attribute.
	 * @see #setOutboundPortMax(String)
	 * @see com.ibm.ccl.soa.deploy.mq.MqPackage#getMQQueueManager_OutboundPortMax()
	 * @model dataType="org.eclipse.emf.ecore.xml.type.String"
	 *        extendedMetaData="kind='attribute' name='OutboundPortMax'"
	 * @generated
	 */
	String getOutboundPortMax();

	/**
	 * Sets the value of the '{@link com.ibm.ccl.soa.deploy.mq.MQQueueManager#getOutboundPortMax <em>Outbound Port Max</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Outbound Port Max</em>' attribute.
	 * @see #getOutboundPortMax()
	 * @generated
	 */
	void setOutboundPortMax(String value);

	/**
	 * Returns the value of the '<em><b>Outbound Port Min</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Outbound Port Min</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Outbound Port Min</em>' attribute.
	 * @see #setOutboundPortMin(String)
	 * @see com.ibm.ccl.soa.deploy.mq.MqPackage#getMQQueueManager_OutboundPortMin()
	 * @model dataType="org.eclipse.emf.ecore.xml.type.String"
	 *        extendedMetaData="kind='attribute' name='OutboundPortMin'"
	 * @generated
	 */
	String getOutboundPortMin();

	/**
	 * Sets the value of the '{@link com.ibm.ccl.soa.deploy.mq.MQQueueManager#getOutboundPortMin <em>Outbound Port Min</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Outbound Port Min</em>' attribute.
	 * @see #getOutboundPortMin()
	 * @generated
	 */
	void setOutboundPortMin(String value);

	/**
	 * Returns the value of the '<em><b>Performance Event</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Performance Event</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Performance Event</em>' attribute.
	 * @see #setPerformanceEvent(String)
	 * @see com.ibm.ccl.soa.deploy.mq.MqPackage#getMQQueueManager_PerformanceEvent()
	 * @model dataType="org.eclipse.emf.ecore.xml.type.String"
	 *        extendedMetaData="kind='attribute' name='PerformanceEvent'"
	 * @generated
	 */
	String getPerformanceEvent();

	/**
	 * Sets the value of the '{@link com.ibm.ccl.soa.deploy.mq.MQQueueManager#getPerformanceEvent <em>Performance Event</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Performance Event</em>' attribute.
	 * @see #getPerformanceEvent()
	 * @generated
	 */
	void setPerformanceEvent(String value);

	/**
	 * Returns the value of the '<em><b>Pipe Line Length</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Pipe Line Length</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Pipe Line Length</em>' attribute.
	 * @see #setPipeLineLength(String)
	 * @see com.ibm.ccl.soa.deploy.mq.MqPackage#getMQQueueManager_PipeLineLength()
	 * @model dataType="org.eclipse.emf.ecore.xml.type.String"
	 *        extendedMetaData="kind='attribute' name='PipeLineLength'"
	 * @generated
	 */
	String getPipeLineLength();

	/**
	 * Sets the value of the '{@link com.ibm.ccl.soa.deploy.mq.MQQueueManager#getPipeLineLength <em>Pipe Line Length</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Pipe Line Length</em>' attribute.
	 * @see #getPipeLineLength()
	 * @generated
	 */
	void setPipeLineLength(String value);

	/**
	 * Returns the value of the '<em><b>Platform</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Platform</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Platform</em>' attribute.
	 * @see #setPlatform(String)
	 * @see com.ibm.ccl.soa.deploy.mq.MqPackage#getMQQueueManager_Platform()
	 * @model dataType="org.eclipse.emf.ecore.xml.type.String"
	 *        extendedMetaData="kind='attribute' name='Platform'"
	 * @generated
	 */
	String getPlatform();

	/**
	 * Sets the value of the '{@link com.ibm.ccl.soa.deploy.mq.MQQueueManager#getPlatform <em>Platform</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Platform</em>' attribute.
	 * @see #getPlatform()
	 * @generated
	 */
	void setPlatform(String value);

	/**
	 * Returns the value of the '<em><b>Queue Accounting</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Queue Accounting</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Queue Accounting</em>' attribute.
	 * @see #setQueueAccounting(String)
	 * @see com.ibm.ccl.soa.deploy.mq.MqPackage#getMQQueueManager_QueueAccounting()
	 * @model dataType="org.eclipse.emf.ecore.xml.type.String"
	 *        extendedMetaData="kind='attribute' name='QueueAccounting'"
	 * @generated
	 */
	String getQueueAccounting();

	/**
	 * Sets the value of the '{@link com.ibm.ccl.soa.deploy.mq.MQQueueManager#getQueueAccounting <em>Queue Accounting</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Queue Accounting</em>' attribute.
	 * @see #getQueueAccounting()
	 * @generated
	 */
	void setQueueAccounting(String value);

	/**
	 * Returns the value of the '<em><b>Queue Manager Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Queue Manager Name</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Queue Manager Name</em>' attribute.
	 * @see #setQueueManagerName(String)
	 * @see com.ibm.ccl.soa.deploy.mq.MqPackage#getMQQueueManager_QueueManagerName()
	 * @model dataType="org.eclipse.emf.ecore.xml.type.String"
	 *        extendedMetaData="kind='attribute' name='QueueManagerName'"
	 * @generated
	 */
	String getQueueManagerName();

	/**
	 * Sets the value of the '{@link com.ibm.ccl.soa.deploy.mq.MQQueueManager#getQueueManagerName <em>Queue Manager Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Queue Manager Name</em>' attribute.
	 * @see #getQueueManagerName()
	 * @generated
	 */
	void setQueueManagerName(String value);

	/**
	 * Returns the value of the '<em><b>Queue Manager Status</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Queue Manager Status</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Queue Manager Status</em>' attribute.
	 * @see #setQueueManagerStatus(String)
	 * @see com.ibm.ccl.soa.deploy.mq.MqPackage#getMQQueueManager_QueueManagerStatus()
	 * @model dataType="org.eclipse.emf.ecore.xml.type.String"
	 *        extendedMetaData="kind='attribute' name='QueueManagerStatus'"
	 * @generated
	 */
	String getQueueManagerStatus();

	/**
	 * Sets the value of the '{@link com.ibm.ccl.soa.deploy.mq.MQQueueManager#getQueueManagerStatus <em>Queue Manager Status</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Queue Manager Status</em>' attribute.
	 * @see #getQueueManagerStatus()
	 * @generated
	 */
	void setQueueManagerStatus(String value);

	/**
	 * Returns the value of the '<em><b>Queue Monitoring</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Queue Monitoring</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Queue Monitoring</em>' attribute.
	 * @see #setQueueMonitoring(String)
	 * @see com.ibm.ccl.soa.deploy.mq.MqPackage#getMQQueueManager_QueueMonitoring()
	 * @model dataType="org.eclipse.emf.ecore.xml.type.String"
	 *        extendedMetaData="kind='attribute' name='QueueMonitoring'"
	 * @generated
	 */
	String getQueueMonitoring();

	/**
	 * Sets the value of the '{@link com.ibm.ccl.soa.deploy.mq.MQQueueManager#getQueueMonitoring <em>Queue Monitoring</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Queue Monitoring</em>' attribute.
	 * @see #getQueueMonitoring()
	 * @generated
	 */
	void setQueueMonitoring(String value);

	/**
	 * Returns the value of the '<em><b>Queue Statistics</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Queue Statistics</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Queue Statistics</em>' attribute.
	 * @see #setQueueStatistics(String)
	 * @see com.ibm.ccl.soa.deploy.mq.MqPackage#getMQQueueManager_QueueStatistics()
	 * @model dataType="org.eclipse.emf.ecore.xml.type.String"
	 *        extendedMetaData="kind='attribute' name='QueueStatistics'"
	 * @generated
	 */
	String getQueueStatistics();

	/**
	 * Sets the value of the '{@link com.ibm.ccl.soa.deploy.mq.MQQueueManager#getQueueStatistics <em>Queue Statistics</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Queue Statistics</em>' attribute.
	 * @see #getQueueStatistics()
	 * @generated
	 */
	void setQueueStatistics(String value);

	/**
	 * Returns the value of the '<em><b>Receive Timeout</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Receive Timeout</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Receive Timeout</em>' attribute.
	 * @see #setReceiveTimeout(String)
	 * @see com.ibm.ccl.soa.deploy.mq.MqPackage#getMQQueueManager_ReceiveTimeout()
	 * @model dataType="org.eclipse.emf.ecore.xml.type.String"
	 *        extendedMetaData="kind='attribute' name='ReceiveTimeout'"
	 * @generated
	 */
	String getReceiveTimeout();

	/**
	 * Sets the value of the '{@link com.ibm.ccl.soa.deploy.mq.MQQueueManager#getReceiveTimeout <em>Receive Timeout</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Receive Timeout</em>' attribute.
	 * @see #getReceiveTimeout()
	 * @generated
	 */
	void setReceiveTimeout(String value);

	/**
	 * Returns the value of the '<em><b>Receive Timeout Min</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Receive Timeout Min</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Receive Timeout Min</em>' attribute.
	 * @see #setReceiveTimeoutMin(String)
	 * @see com.ibm.ccl.soa.deploy.mq.MqPackage#getMQQueueManager_ReceiveTimeoutMin()
	 * @model dataType="org.eclipse.emf.ecore.xml.type.String"
	 *        extendedMetaData="kind='attribute' name='ReceiveTimeoutMin'"
	 * @generated
	 */
	String getReceiveTimeoutMin();

	/**
	 * Sets the value of the '{@link com.ibm.ccl.soa.deploy.mq.MQQueueManager#getReceiveTimeoutMin <em>Receive Timeout Min</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Receive Timeout Min</em>' attribute.
	 * @see #getReceiveTimeoutMin()
	 * @generated
	 */
	void setReceiveTimeoutMin(String value);

	/**
	 * Returns the value of the '<em><b>Receive Timeout Type</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Receive Timeout Type</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Receive Timeout Type</em>' attribute.
	 * @see #setReceiveTimeoutType(String)
	 * @see com.ibm.ccl.soa.deploy.mq.MqPackage#getMQQueueManager_ReceiveTimeoutType()
	 * @model dataType="org.eclipse.emf.ecore.xml.type.String"
	 *        extendedMetaData="kind='attribute' name='ReceiveTimeoutType'"
	 * @generated
	 */
	String getReceiveTimeoutType();

	/**
	 * Sets the value of the '{@link com.ibm.ccl.soa.deploy.mq.MQQueueManager#getReceiveTimeoutType <em>Receive Timeout Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Receive Timeout Type</em>' attribute.
	 * @see #getReceiveTimeoutType()
	 * @generated
	 */
	void setReceiveTimeoutType(String value);

	/**
	 * Returns the value of the '<em><b>Remote Event</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Remote Event</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Remote Event</em>' attribute.
	 * @see #setRemoteEvent(String)
	 * @see com.ibm.ccl.soa.deploy.mq.MqPackage#getMQQueueManager_RemoteEvent()
	 * @model dataType="org.eclipse.emf.ecore.xml.type.String"
	 *        extendedMetaData="kind='attribute' name='RemoteEvent'"
	 * @generated
	 */
	String getRemoteEvent();

	/**
	 * Sets the value of the '{@link com.ibm.ccl.soa.deploy.mq.MQQueueManager#getRemoteEvent <em>Remote Event</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Remote Event</em>' attribute.
	 * @see #getRemoteEvent()
	 * @generated
	 */
	void setRemoteEvent(String value);

	/**
	 * Returns the value of the '<em><b>Repository Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Repository Name</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Repository Name</em>' attribute.
	 * @see #setRepositoryName(String)
	 * @see com.ibm.ccl.soa.deploy.mq.MqPackage#getMQQueueManager_RepositoryName()
	 * @model dataType="org.eclipse.emf.ecore.xml.type.String"
	 *        extendedMetaData="kind='attribute' name='RepositoryName'"
	 * @generated
	 */
	String getRepositoryName();

	/**
	 * Sets the value of the '{@link com.ibm.ccl.soa.deploy.mq.MQQueueManager#getRepositoryName <em>Repository Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Repository Name</em>' attribute.
	 * @see #getRepositoryName()
	 * @generated
	 */
	void setRepositoryName(String value);

	/**
	 * Returns the value of the '<em><b>Repository Name List</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Repository Name List</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Repository Name List</em>' attribute.
	 * @see #setRepositoryNameList(String)
	 * @see com.ibm.ccl.soa.deploy.mq.MqPackage#getMQQueueManager_RepositoryNameList()
	 * @model dataType="org.eclipse.emf.ecore.xml.type.String"
	 *        extendedMetaData="kind='attribute' name='RepositoryNameList'"
	 * @generated
	 */
	String getRepositoryNameList();

	/**
	 * Sets the value of the '{@link com.ibm.ccl.soa.deploy.mq.MQQueueManager#getRepositoryNameList <em>Repository Name List</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Repository Name List</em>' attribute.
	 * @see #getRepositoryNameList()
	 * @generated
	 */
	void setRepositoryNameList(String value);

	/**
	 * Returns the value of the '<em><b>Routing Exit Connect Type</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Routing Exit Connect Type</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Routing Exit Connect Type</em>' attribute.
	 * @see #setRoutingExitConnectType(String)
	 * @see com.ibm.ccl.soa.deploy.mq.MqPackage#getMQQueueManager_RoutingExitConnectType()
	 * @model dataType="org.eclipse.emf.ecore.xml.type.String"
	 *        extendedMetaData="kind='attribute' name='RoutingExitConnectType'"
	 * @generated
	 */
	String getRoutingExitConnectType();

	/**
	 * Sets the value of the '{@link com.ibm.ccl.soa.deploy.mq.MQQueueManager#getRoutingExitConnectType <em>Routing Exit Connect Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Routing Exit Connect Type</em>' attribute.
	 * @see #getRoutingExitConnectType()
	 * @generated
	 */
	void setRoutingExitConnectType(String value);

	/**
	 * Returns the value of the '<em><b>Routing Exit Path</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Routing Exit Path</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Routing Exit Path</em>' attribute.
	 * @see #setRoutingExitPath(String)
	 * @see com.ibm.ccl.soa.deploy.mq.MqPackage#getMQQueueManager_RoutingExitPath()
	 * @model dataType="org.eclipse.emf.ecore.xml.type.String"
	 *        extendedMetaData="kind='attribute' name='RoutingExitPath'"
	 * @generated
	 */
	String getRoutingExitPath();

	/**
	 * Sets the value of the '{@link com.ibm.ccl.soa.deploy.mq.MQQueueManager#getRoutingExitPath <em>Routing Exit Path</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Routing Exit Path</em>' attribute.
	 * @see #getRoutingExitPath()
	 * @generated
	 */
	void setRoutingExitPath(String value);

	/**
	 * Returns the value of the '<em><b>Security Policy</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Security Policy</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Security Policy</em>' attribute.
	 * @see #setSecurityPolicy(String)
	 * @see com.ibm.ccl.soa.deploy.mq.MqPackage#getMQQueueManager_SecurityPolicy()
	 * @model dataType="org.eclipse.emf.ecore.xml.type.String"
	 *        extendedMetaData="kind='attribute' name='SecurityPolicy'"
	 * @generated
	 */
	String getSecurityPolicy();

	/**
	 * Sets the value of the '{@link com.ibm.ccl.soa.deploy.mq.MQQueueManager#getSecurityPolicy <em>Security Policy</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Security Policy</em>' attribute.
	 * @see #getSecurityPolicy()
	 * @generated
	 */
	void setSecurityPolicy(String value);

	/**
	 * Returns the value of the '<em><b>Service Entry Points</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Service Entry Points</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Service Entry Points</em>' attribute.
	 * @see #setServiceEntryPoints(String)
	 * @see com.ibm.ccl.soa.deploy.mq.MqPackage#getMQQueueManager_ServiceEntryPoints()
	 * @model dataType="org.eclipse.emf.ecore.xml.type.String"
	 *        extendedMetaData="kind='attribute' name='ServiceEntryPoints'"
	 * @generated
	 */
	String getServiceEntryPoints();

	/**
	 * Sets the value of the '{@link com.ibm.ccl.soa.deploy.mq.MQQueueManager#getServiceEntryPoints <em>Service Entry Points</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Service Entry Points</em>' attribute.
	 * @see #getServiceEntryPoints()
	 * @generated
	 */
	void setServiceEntryPoints(String value);

	/**
	 * Returns the value of the '<em><b>Shared QQmgr Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Shared QQmgr Name</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Shared QQmgr Name</em>' attribute.
	 * @see #setSharedQQmgrName(String)
	 * @see com.ibm.ccl.soa.deploy.mq.MqPackage#getMQQueueManager_SharedQQmgrName()
	 * @model dataType="org.eclipse.emf.ecore.xml.type.String"
	 *        extendedMetaData="kind='attribute' name='sharedQQmgrName'"
	 * @generated
	 */
	String getSharedQQmgrName();

	/**
	 * Sets the value of the '{@link com.ibm.ccl.soa.deploy.mq.MQQueueManager#getSharedQQmgrName <em>Shared QQmgr Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Shared QQmgr Name</em>' attribute.
	 * @see #getSharedQQmgrName()
	 * @generated
	 */
	void setSharedQQmgrName(String value);

	/**
	 * Returns the value of the '<em><b>SPX Board Number</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>SPX Board Number</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>SPX Board Number</em>' attribute.
	 * @see #setSPXBoardNumber(String)
	 * @see com.ibm.ccl.soa.deploy.mq.MqPackage#getMQQueueManager_SPXBoardNumber()
	 * @model dataType="org.eclipse.emf.ecore.xml.type.String"
	 *        extendedMetaData="kind='attribute' name='SPXBoardNumber'"
	 * @generated
	 */
	String getSPXBoardNumber();

	/**
	 * Sets the value of the '{@link com.ibm.ccl.soa.deploy.mq.MQQueueManager#getSPXBoardNumber <em>SPX Board Number</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>SPX Board Number</em>' attribute.
	 * @see #getSPXBoardNumber()
	 * @generated
	 */
	void setSPXBoardNumber(String value);

	/**
	 * Returns the value of the '<em><b>SPX Keep Alive</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>SPX Keep Alive</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>SPX Keep Alive</em>' attribute.
	 * @see #setSPXKeepAlive(String)
	 * @see com.ibm.ccl.soa.deploy.mq.MqPackage#getMQQueueManager_SPXKeepAlive()
	 * @model dataType="org.eclipse.emf.ecore.xml.type.String"
	 *        extendedMetaData="kind='attribute' name='SPXKeepAlive'"
	 * @generated
	 */
	String getSPXKeepAlive();

	/**
	 * Sets the value of the '{@link com.ibm.ccl.soa.deploy.mq.MQQueueManager#getSPXKeepAlive <em>SPX Keep Alive</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>SPX Keep Alive</em>' attribute.
	 * @see #getSPXKeepAlive()
	 * @generated
	 */
	void setSPXKeepAlive(String value);

	/**
	 * Returns the value of the '<em><b>SPX Library1</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>SPX Library1</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>SPX Library1</em>' attribute.
	 * @see #setSPXLibrary1(String)
	 * @see com.ibm.ccl.soa.deploy.mq.MqPackage#getMQQueueManager_SPXLibrary1()
	 * @model dataType="org.eclipse.emf.ecore.xml.type.String"
	 *        extendedMetaData="kind='attribute' name='SPXLibrary1'"
	 * @generated
	 */
	String getSPXLibrary1();

	/**
	 * Sets the value of the '{@link com.ibm.ccl.soa.deploy.mq.MQQueueManager#getSPXLibrary1 <em>SPX Library1</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>SPX Library1</em>' attribute.
	 * @see #getSPXLibrary1()
	 * @generated
	 */
	void setSPXLibrary1(String value);

	/**
	 * Returns the value of the '<em><b>SPX Library2</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>SPX Library2</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>SPX Library2</em>' attribute.
	 * @see #setSPXLibrary2(String)
	 * @see com.ibm.ccl.soa.deploy.mq.MqPackage#getMQQueueManager_SPXLibrary2()
	 * @model dataType="org.eclipse.emf.ecore.xml.type.String"
	 *        extendedMetaData="kind='attribute' name='SPXLibrary2'"
	 * @generated
	 */
	String getSPXLibrary2();

	/**
	 * Sets the value of the '{@link com.ibm.ccl.soa.deploy.mq.MQQueueManager#getSPXLibrary2 <em>SPX Library2</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>SPX Library2</em>' attribute.
	 * @see #getSPXLibrary2()
	 * @generated
	 */
	void setSPXLibrary2(String value);

	/**
	 * Returns the value of the '<em><b>SPX Socket</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>SPX Socket</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>SPX Socket</em>' attribute.
	 * @see #setSPXSocket(String)
	 * @see com.ibm.ccl.soa.deploy.mq.MqPackage#getMQQueueManager_SPXSocket()
	 * @model dataType="org.eclipse.emf.ecore.xml.type.String"
	 *        extendedMetaData="kind='attribute' name='SPXSocket'"
	 * @generated
	 */
	String getSPXSocket();

	/**
	 * Sets the value of the '{@link com.ibm.ccl.soa.deploy.mq.MQQueueManager#getSPXSocket <em>SPX Socket</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>SPX Socket</em>' attribute.
	 * @see #getSPXSocket()
	 * @generated
	 */
	void setSPXSocket(String value);

	/**
	 * Returns the value of the '<em><b>SSLCRL Name List</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>SSLCRL Name List</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>SSLCRL Name List</em>' attribute.
	 * @see #setSSLCRLNameList(String)
	 * @see com.ibm.ccl.soa.deploy.mq.MqPackage#getMQQueueManager_SSLCRLNameList()
	 * @model dataType="org.eclipse.emf.ecore.xml.type.String"
	 *        extendedMetaData="kind='attribute' name='SSLCRLNameList'"
	 * @generated
	 */
	String getSSLCRLNameList();

	/**
	 * Sets the value of the '{@link com.ibm.ccl.soa.deploy.mq.MQQueueManager#getSSLCRLNameList <em>SSLCRL Name List</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>SSLCRL Name List</em>' attribute.
	 * @see #getSSLCRLNameList()
	 * @generated
	 */
	void setSSLCRLNameList(String value);

	/**
	 * Returns the value of the '<em><b>SSL Cryto Hardware</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>SSL Cryto Hardware</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>SSL Cryto Hardware</em>' attribute.
	 * @see #setSSLCrytoHardware(String)
	 * @see com.ibm.ccl.soa.deploy.mq.MqPackage#getMQQueueManager_SSLCrytoHardware()
	 * @model dataType="org.eclipse.emf.ecore.xml.type.String"
	 *        extendedMetaData="kind='attribute' name='SSLCrytoHardware'"
	 * @generated
	 */
	String getSSLCrytoHardware();

	/**
	 * Sets the value of the '{@link com.ibm.ccl.soa.deploy.mq.MQQueueManager#getSSLCrytoHardware <em>SSL Cryto Hardware</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>SSL Cryto Hardware</em>' attribute.
	 * @see #getSSLCrytoHardware()
	 * @generated
	 */
	void setSSLCrytoHardware(String value);

	/**
	 * Returns the value of the '<em><b>SSL Event</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>SSL Event</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>SSL Event</em>' attribute.
	 * @see #setSSLEvent(String)
	 * @see com.ibm.ccl.soa.deploy.mq.MqPackage#getMQQueueManager_SSLEvent()
	 * @model dataType="org.eclipse.emf.ecore.xml.type.String"
	 *        extendedMetaData="kind='attribute' name='SSLEvent'"
	 * @generated
	 */
	String getSSLEvent();

	/**
	 * Sets the value of the '{@link com.ibm.ccl.soa.deploy.mq.MQQueueManager#getSSLEvent <em>SSL Event</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>SSL Event</em>' attribute.
	 * @see #getSSLEvent()
	 * @generated
	 */
	void setSSLEvent(String value);

	/**
	 * Returns the value of the '<em><b>SSL Fips</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>SSL Fips</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>SSL Fips</em>' attribute.
	 * @see #setSSLFips(String)
	 * @see com.ibm.ccl.soa.deploy.mq.MqPackage#getMQQueueManager_SSLFips()
	 * @model dataType="org.eclipse.emf.ecore.xml.type.String"
	 *        extendedMetaData="kind='attribute' name='SSLFips'"
	 * @generated
	 */
	String getSSLFips();

	/**
	 * Sets the value of the '{@link com.ibm.ccl.soa.deploy.mq.MQQueueManager#getSSLFips <em>SSL Fips</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>SSL Fips</em>' attribute.
	 * @see #getSSLFips()
	 * @generated
	 */
	void setSSLFips(String value);

	/**
	 * Returns the value of the '<em><b>SSL Key Repository</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>SSL Key Repository</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>SSL Key Repository</em>' attribute.
	 * @see #setSSLKeyRepository(String)
	 * @see com.ibm.ccl.soa.deploy.mq.MqPackage#getMQQueueManager_SSLKeyRepository()
	 * @model dataType="org.eclipse.emf.ecore.xml.type.String"
	 *        extendedMetaData="kind='attribute' name='SSLKeyRepository'"
	 * @generated
	 */
	String getSSLKeyRepository();

	/**
	 * Sets the value of the '{@link com.ibm.ccl.soa.deploy.mq.MQQueueManager#getSSLKeyRepository <em>SSL Key Repository</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>SSL Key Repository</em>' attribute.
	 * @see #getSSLKeyRepository()
	 * @generated
	 */
	void setSSLKeyRepository(String value);

	/**
	 * Returns the value of the '<em><b>SSL Key Reset Count</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>SSL Key Reset Count</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>SSL Key Reset Count</em>' attribute.
	 * @see #setSSLKeyResetCount(String)
	 * @see com.ibm.ccl.soa.deploy.mq.MqPackage#getMQQueueManager_SSLKeyResetCount()
	 * @model dataType="org.eclipse.emf.ecore.xml.type.String"
	 *        extendedMetaData="kind='attribute' name='SSLKeyResetCount'"
	 * @generated
	 */
	String getSSLKeyResetCount();

	/**
	 * Sets the value of the '{@link com.ibm.ccl.soa.deploy.mq.MQQueueManager#getSSLKeyResetCount <em>SSL Key Reset Count</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>SSL Key Reset Count</em>' attribute.
	 * @see #getSSLKeyResetCount()
	 * @generated
	 */
	void setSSLKeyResetCount(String value);

	/**
	 * Returns the value of the '<em><b>SSL Tasks</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>SSL Tasks</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>SSL Tasks</em>' attribute.
	 * @see #setSSLTasks(String)
	 * @see com.ibm.ccl.soa.deploy.mq.MqPackage#getMQQueueManager_SSLTasks()
	 * @model dataType="org.eclipse.emf.ecore.xml.type.String"
	 *        extendedMetaData="kind='attribute' name='SSLTasks'"
	 * @generated
	 */
	String getSSLTasks();

	/**
	 * Sets the value of the '{@link com.ibm.ccl.soa.deploy.mq.MQQueueManager#getSSLTasks <em>SSL Tasks</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>SSL Tasks</em>' attribute.
	 * @see #getSSLTasks()
	 * @generated
	 */
	void setSSLTasks(String value);

	/**
	 * Returns the value of the '<em><b>Start Stop Event</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Start Stop Event</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Start Stop Event</em>' attribute.
	 * @see #setStartStopEvent(String)
	 * @see com.ibm.ccl.soa.deploy.mq.MqPackage#getMQQueueManager_StartStopEvent()
	 * @model dataType="org.eclipse.emf.ecore.xml.type.String"
	 *        extendedMetaData="kind='attribute' name='StartStopEvent'"
	 * @generated
	 */
	String getStartStopEvent();

	/**
	 * Sets the value of the '{@link com.ibm.ccl.soa.deploy.mq.MQQueueManager#getStartStopEvent <em>Start Stop Event</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Start Stop Event</em>' attribute.
	 * @see #getStartStopEvent()
	 * @generated
	 */
	void setStartStopEvent(String value);

	/**
	 * Returns the value of the '<em><b>Statistics Interval</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Statistics Interval</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Statistics Interval</em>' attribute.
	 * @see #setStatisticsInterval(String)
	 * @see com.ibm.ccl.soa.deploy.mq.MqPackage#getMQQueueManager_StatisticsInterval()
	 * @model dataType="org.eclipse.emf.ecore.xml.type.String"
	 *        extendedMetaData="kind='attribute' name='StatisticsInterval'"
	 * @generated
	 */
	String getStatisticsInterval();

	/**
	 * Sets the value of the '{@link com.ibm.ccl.soa.deploy.mq.MQQueueManager#getStatisticsInterval <em>Statistics Interval</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Statistics Interval</em>' attribute.
	 * @see #getStatisticsInterval()
	 * @generated
	 */
	void setStatisticsInterval(String value);

	/**
	 * Returns the value of the '<em><b>Suppresed Messages</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Suppresed Messages</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Suppresed Messages</em>' attribute.
	 * @see #setSuppresedMessages(String)
	 * @see com.ibm.ccl.soa.deploy.mq.MqPackage#getMQQueueManager_SuppresedMessages()
	 * @model dataType="org.eclipse.emf.ecore.xml.type.String"
	 *        extendedMetaData="kind='attribute' name='SuppresedMessages'"
	 * @generated
	 */
	String getSuppresedMessages();

	/**
	 * Sets the value of the '{@link com.ibm.ccl.soa.deploy.mq.MQQueueManager#getSuppresedMessages <em>Suppresed Messages</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Suppresed Messages</em>' attribute.
	 * @see #getSuppresedMessages()
	 * @generated
	 */
	void setSuppresedMessages(String value);

	/**
	 * Returns the value of the '<em><b>Suppressed Message Interval</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Suppressed Message Interval</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Suppressed Message Interval</em>' attribute.
	 * @see #setSuppressedMessageInterval(String)
	 * @see com.ibm.ccl.soa.deploy.mq.MqPackage#getMQQueueManager_SuppressedMessageInterval()
	 * @model dataType="org.eclipse.emf.ecore.xml.type.String"
	 *        extendedMetaData="kind='attribute' name='SuppressedMessageInterval'"
	 * @generated
	 */
	String getSuppressedMessageInterval();

	/**
	 * Sets the value of the '{@link com.ibm.ccl.soa.deploy.mq.MQQueueManager#getSuppressedMessageInterval <em>Suppressed Message Interval</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Suppressed Message Interval</em>' attribute.
	 * @see #getSuppressedMessageInterval()
	 * @generated
	 */
	void setSuppressedMessageInterval(String value);

	/**
	 * Returns the value of the '<em><b>TCP Keep Alive</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>TCP Keep Alive</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>TCP Keep Alive</em>' attribute.
	 * @see #setTCPKeepAlive(String)
	 * @see com.ibm.ccl.soa.deploy.mq.MqPackage#getMQQueueManager_TCPKeepAlive()
	 * @model dataType="org.eclipse.emf.ecore.xml.type.String"
	 *        extendedMetaData="kind='attribute' name='TCPKeepAlive'"
	 * @generated
	 */
	String getTCPKeepAlive();

	/**
	 * Sets the value of the '{@link com.ibm.ccl.soa.deploy.mq.MQQueueManager#getTCPKeepAlive <em>TCP Keep Alive</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>TCP Keep Alive</em>' attribute.
	 * @see #getTCPKeepAlive()
	 * @generated
	 */
	void setTCPKeepAlive(String value);

	/**
	 * Returns the value of the '<em><b>TCP Library1</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>TCP Library1</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>TCP Library1</em>' attribute.
	 * @see #setTCPLibrary1(String)
	 * @see com.ibm.ccl.soa.deploy.mq.MqPackage#getMQQueueManager_TCPLibrary1()
	 * @model dataType="org.eclipse.emf.ecore.xml.type.String"
	 *        extendedMetaData="kind='attribute' name='TCPLibrary1'"
	 * @generated
	 */
	String getTCPLibrary1();

	/**
	 * Sets the value of the '{@link com.ibm.ccl.soa.deploy.mq.MQQueueManager#getTCPLibrary1 <em>TCP Library1</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>TCP Library1</em>' attribute.
	 * @see #getTCPLibrary1()
	 * @generated
	 */
	void setTCPLibrary1(String value);

	/**
	 * Returns the value of the '<em><b>TCP Library2</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>TCP Library2</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>TCP Library2</em>' attribute.
	 * @see #setTCPLibrary2(String)
	 * @see com.ibm.ccl.soa.deploy.mq.MqPackage#getMQQueueManager_TCPLibrary2()
	 * @model dataType="org.eclipse.emf.ecore.xml.type.String"
	 *        extendedMetaData="kind='attribute' name='TCPLibrary2'"
	 * @generated
	 */
	String getTCPLibrary2();

	/**
	 * Sets the value of the '{@link com.ibm.ccl.soa.deploy.mq.MQQueueManager#getTCPLibrary2 <em>TCP Library2</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>TCP Library2</em>' attribute.
	 * @see #getTCPLibrary2()
	 * @generated
	 */
	void setTCPLibrary2(String value);

	/**
	 * Returns the value of the '<em><b>TCP Listener Backlog</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>TCP Listener Backlog</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>TCP Listener Backlog</em>' attribute.
	 * @see #setTCPListenerBacklog(String)
	 * @see com.ibm.ccl.soa.deploy.mq.MqPackage#getMQQueueManager_TCPListenerBacklog()
	 * @model dataType="org.eclipse.emf.ecore.xml.type.String"
	 *        extendedMetaData="kind='attribute' name='TCPListenerBacklog'"
	 * @generated
	 */
	String getTCPListenerBacklog();

	/**
	 * Sets the value of the '{@link com.ibm.ccl.soa.deploy.mq.MQQueueManager#getTCPListenerBacklog <em>TCP Listener Backlog</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>TCP Listener Backlog</em>' attribute.
	 * @see #getTCPListenerBacklog()
	 * @generated
	 */
	void setTCPListenerBacklog(String value);

	/**
	 * Returns the value of the '<em><b>TCP Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>TCP Name</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>TCP Name</em>' attribute.
	 * @see #setTCPName(String)
	 * @see com.ibm.ccl.soa.deploy.mq.MqPackage#getMQQueueManager_TCPName()
	 * @model dataType="org.eclipse.emf.ecore.xml.type.String"
	 *        extendedMetaData="kind='attribute' name='TCPName'"
	 * @generated
	 */
	String getTCPName();

	/**
	 * Sets the value of the '{@link com.ibm.ccl.soa.deploy.mq.MQQueueManager#getTCPName <em>TCP Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>TCP Name</em>' attribute.
	 * @see #getTCPName()
	 * @generated
	 */
	void setTCPName(String value);

	/**
	 * Returns the value of the '<em><b>TCP Port</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>TCP Port</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>TCP Port</em>' attribute.
	 * @see #setTCPPort(String)
	 * @see com.ibm.ccl.soa.deploy.mq.MqPackage#getMQQueueManager_TCPPort()
	 * @model dataType="org.eclipse.emf.ecore.xml.type.String"
	 *        extendedMetaData="kind='attribute' name='TCPPort'"
	 * @generated
	 */
	String getTCPPort();

	/**
	 * Sets the value of the '{@link com.ibm.ccl.soa.deploy.mq.MQQueueManager#getTCPPort <em>TCP Port</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>TCP Port</em>' attribute.
	 * @see #getTCPPort()
	 * @generated
	 */
	void setTCPPort(String value);

	/**
	 * Returns the value of the '<em><b>TCP Stack Type</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>TCP Stack Type</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>TCP Stack Type</em>' attribute.
	 * @see #setTCPStackType(String)
	 * @see com.ibm.ccl.soa.deploy.mq.MqPackage#getMQQueueManager_TCPStackType()
	 * @model dataType="org.eclipse.emf.ecore.xml.type.String"
	 *        extendedMetaData="kind='attribute' name='TCPStackType'"
	 * @generated
	 */
	String getTCPStackType();

	/**
	 * Sets the value of the '{@link com.ibm.ccl.soa.deploy.mq.MQQueueManager#getTCPStackType <em>TCP Stack Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>TCP Stack Type</em>' attribute.
	 * @see #getTCPStackType()
	 * @generated
	 */
	void setTCPStackType(String value);

	/**
	 * Returns the value of the '<em><b>Trace Route Recording</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Trace Route Recording</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Trace Route Recording</em>' attribute.
	 * @see #setTraceRouteRecording(String)
	 * @see com.ibm.ccl.soa.deploy.mq.MqPackage#getMQQueueManager_TraceRouteRecording()
	 * @model dataType="org.eclipse.emf.ecore.xml.type.String"
	 *        extendedMetaData="kind='attribute' name='TraceRouteRecording'"
	 * @generated
	 */
	String getTraceRouteRecording();

	/**
	 * Sets the value of the '{@link com.ibm.ccl.soa.deploy.mq.MQQueueManager#getTraceRouteRecording <em>Trace Route Recording</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Trace Route Recording</em>' attribute.
	 * @see #getTraceRouteRecording()
	 * @generated
	 */
	void setTraceRouteRecording(String value);

	/**
	 * Returns the value of the '<em><b>Trigger Interval</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Trigger Interval</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Trigger Interval</em>' attribute.
	 * @see #setTriggerInterval(String)
	 * @see com.ibm.ccl.soa.deploy.mq.MqPackage#getMQQueueManager_TriggerInterval()
	 * @model dataType="org.eclipse.emf.ecore.xml.type.String"
	 *        extendedMetaData="kind='attribute' name='TriggerInterval'"
	 * @generated
	 */
	String getTriggerInterval();

	/**
	 * Sets the value of the '{@link com.ibm.ccl.soa.deploy.mq.MQQueueManager#getTriggerInterval <em>Trigger Interval</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Trigger Interval</em>' attribute.
	 * @see #getTriggerInterval()
	 * @generated
	 */
	void setTriggerInterval(String value);

	/**
	 * Returns the value of the '<em><b>What If</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>What If</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>What If</em>' attribute.
	 * @see #setWhatIf(String)
	 * @see com.ibm.ccl.soa.deploy.mq.MqPackage#getMQQueueManager_WhatIf()
	 * @model dataType="org.eclipse.emf.ecore.xml.type.String"
	 *        extendedMetaData="kind='attribute' name='WhatIf'"
	 * @generated
	 */
	String getWhatIf();

	/**
	 * Sets the value of the '{@link com.ibm.ccl.soa.deploy.mq.MQQueueManager#getWhatIf <em>What If</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>What If</em>' attribute.
	 * @see #getWhatIf()
	 * @generated
	 */
	void setWhatIf(String value);

} // MQQueueManager
