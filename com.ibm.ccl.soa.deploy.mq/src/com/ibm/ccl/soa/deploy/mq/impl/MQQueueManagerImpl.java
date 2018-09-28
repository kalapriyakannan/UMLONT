/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package com.ibm.ccl.soa.deploy.mq.impl;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.impl.ENotificationImpl;

import com.ibm.ccl.soa.deploy.core.impl.CapabilityImpl;
import com.ibm.ccl.soa.deploy.mq.MQQueueManager;
import com.ibm.ccl.soa.deploy.mq.MqPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>MQ Queue Manager</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link com.ibm.ccl.soa.deploy.mq.impl.MQQueueManagerImpl#getAccountingConnectionOverride <em>Accounting Connection Override</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.mq.impl.MQQueueManagerImpl#getAccountingInterval <em>Accounting Interval</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.mq.impl.MQQueueManagerImpl#getActivityRecording <em>Activity Recording</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.mq.impl.MQQueueManagerImpl#getAdoptNewMCA <em>Adopt New MCA</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.mq.impl.MQQueueManagerImpl#getAdoptNewMCACheck <em>Adopt New MCA Check</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.mq.impl.MQQueueManagerImpl#getAdoptNewMCAType <em>Adopt New MCA Type</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.mq.impl.MQQueueManagerImpl#getAuthorityEvent <em>Authority Event</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.mq.impl.MQQueueManagerImpl#getAutomatic <em>Automatic</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.mq.impl.MQQueueManagerImpl#getBridgeEvent <em>Bridge Event</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.mq.impl.MQQueueManagerImpl#getBrokerMessageRetryCount <em>Broker Message Retry Count</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.mq.impl.MQQueueManagerImpl#getBrokerOpenCacheExpiry <em>Broker Open Cache Expiry</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.mq.impl.MQQueueManagerImpl#getBrokerOpenCacheSize <em>Broker Open Cache Size</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.mq.impl.MQQueueManagerImpl#getBrokerPublicBatchInterval <em>Broker Public Batch Interval</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.mq.impl.MQQueueManagerImpl#getBrokerPublishBatchSize <em>Broker Publish Batch Size</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.mq.impl.MQQueueManagerImpl#getBrokerStreamsPerProcess <em>Broker Streams Per Process</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.mq.impl.MQQueueManagerImpl#getChannelAutoDefinition <em>Channel Auto Definition</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.mq.impl.MQQueueManagerImpl#getChannelAutoDefinitionEvent <em>Channel Auto Definition Event</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.mq.impl.MQQueueManagerImpl#getChannelEvent <em>Channel Event</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.mq.impl.MQQueueManagerImpl#getChannelInitiatorAdapters <em>Channel Initiator Adapters</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.mq.impl.MQQueueManagerImpl#getChannelInitiatorControl <em>Channel Initiator Control</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.mq.impl.MQQueueManagerImpl#getChannelInitiatorDispatchers <em>Channel Initiator Dispatchers</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.mq.impl.MQQueueManagerImpl#getChannelInitiatorTraceAutoStart <em>Channel Initiator Trace Auto Start</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.mq.impl.MQQueueManagerImpl#getChannelInitiatorTraceTableSize <em>Channel Initiator Trace Table Size</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.mq.impl.MQQueueManagerImpl#getChannelMonitoring <em>Channel Monitoring</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.mq.impl.MQQueueManagerImpl#getChannelStatistics <em>Channel Statistics</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.mq.impl.MQQueueManagerImpl#getCheckpointActiveCount <em>Checkpoint Active Count</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.mq.impl.MQQueueManagerImpl#getCheckpointMessageSize <em>Checkpoint Message Size</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.mq.impl.MQQueueManagerImpl#getCheckpointRestartCount <em>Checkpoint Restart Count</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.mq.impl.MQQueueManagerImpl#getClusterSenderMonitoring <em>Cluster Sender Monitoring</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.mq.impl.MQQueueManagerImpl#getClusterSenderStatistics <em>Cluster Sender Statistics</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.mq.impl.MQQueueManagerImpl#getClusterWorkLoadData <em>Cluster Work Load Data</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.mq.impl.MQQueueManagerImpl#getClusterWorkLoadExit <em>Cluster Work Load Exit</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.mq.impl.MQQueueManagerImpl#getClusterWorkLoadLength <em>Cluster Work Load Length</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.mq.impl.MQQueueManagerImpl#getClusterWorkloadUseQ <em>Cluster Workload Use Q</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.mq.impl.MQQueueManagerImpl#getCodedCharSetId <em>Coded Char Set Id</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.mq.impl.MQQueueManagerImpl#getCommandEvent <em>Command Event</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.mq.impl.MQQueueManagerImpl#getCommandLevel <em>Command Level</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.mq.impl.MQQueueManagerImpl#getCommandScope <em>Command Scope</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.mq.impl.MQQueueManagerImpl#getCommandServerControl <em>Command Server Control</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.mq.impl.MQQueueManagerImpl#getConfigurationEvent <em>Configuration Event</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.mq.impl.MQQueueManagerImpl#getConfirm <em>Confirm</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.mq.impl.MQQueueManagerImpl#getDeadLetterQueue <em>Dead Letter Queue</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.mq.impl.MQQueueManagerImpl#getDefaultBindType <em>Default Bind Type</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.mq.impl.MQQueueManagerImpl#getDefaultTransmissionQueue <em>Default Transmission Queue</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.mq.impl.MQQueueManagerImpl#getDescription1 <em>Description1</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.mq.impl.MQQueueManagerImpl#getDNSGroup <em>DNS Group</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.mq.impl.MQQueueManagerImpl#getDNSWLM <em>DNSWLM</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.mq.impl.MQQueueManagerImpl#getErrorLogSize <em>Error Log Size</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.mq.impl.MQQueueManagerImpl#getExcludedMessages <em>Excluded Messages</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.mq.impl.MQQueueManagerImpl#getExitsDefaultPath <em>Exits Default Path</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.mq.impl.MQQueueManagerImpl#getExpiryInterval <em>Expiry Interval</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.mq.impl.MQQueueManagerImpl#getIGQPutAuthority <em>IGQ Put Authority</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.mq.impl.MQQueueManagerImpl#getIGQUserId <em>IGQ User Id</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.mq.impl.MQQueueManagerImpl#getInhibitEvent <em>Inhibit Event</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.mq.impl.MQQueueManagerImpl#getInstallableServiceName <em>Installable Service Name</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.mq.impl.MQQueueManagerImpl#getIntraGroupQueuing <em>Intra Group Queuing</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.mq.impl.MQQueueManagerImpl#getIPAddressVersion <em>IP Address Version</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.mq.impl.MQQueueManagerImpl#getListenerTimer <em>Listener Timer</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.mq.impl.MQQueueManagerImpl#getLocalEvent <em>Local Event</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.mq.impl.MQQueueManagerImpl#getLogBufferPages <em>Log Buffer Pages</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.mq.impl.MQQueueManagerImpl#getLogFilePages <em>Log File Pages</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.mq.impl.MQQueueManagerImpl#getLogPath <em>Log Path</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.mq.impl.MQQueueManagerImpl#getLogPrimaryFiles <em>Log Primary Files</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.mq.impl.MQQueueManagerImpl#getLogSecondaryFiles <em>Log Secondary Files</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.mq.impl.MQQueueManagerImpl#getLogType <em>Log Type</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.mq.impl.MQQueueManagerImpl#getLogWriteIntegrity <em>Log Write Integrity</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.mq.impl.MQQueueManagerImpl#getLU62ARMSuffix <em>LU62ARM Suffix</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.mq.impl.MQQueueManagerImpl#getLU62Channels <em>LU62 Channels</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.mq.impl.MQQueueManagerImpl#getLUGroupName <em>LU Group Name</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.mq.impl.MQQueueManagerImpl#getLULibrary1 <em>LU Library1</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.mq.impl.MQQueueManagerImpl#getLULibrary2 <em>LU Library2</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.mq.impl.MQQueueManagerImpl#getLULocalLU <em>LU Local LU</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.mq.impl.MQQueueManagerImpl#getLUName <em>LU Name</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.mq.impl.MQQueueManagerImpl#getLUTPName <em>LUTP Name</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.mq.impl.MQQueueManagerImpl#getMaxActiveChannels <em>Max Active Channels</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.mq.impl.MQQueueManagerImpl#getMaxChannels <em>Max Channels</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.mq.impl.MQQueueManagerImpl#getMaximumCurrentChannels <em>Maximum Current Channels</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.mq.impl.MQQueueManagerImpl#getMaximumHandles <em>Maximum Handles</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.mq.impl.MQQueueManagerImpl#getMaximumMessageLength <em>Maximum Message Length</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.mq.impl.MQQueueManagerImpl#getMaximumTCPChannels <em>Maximum TCP Channels</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.mq.impl.MQQueueManagerImpl#getMaximumUncommittedMessages <em>Maximum Uncommitted Messages</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.mq.impl.MQQueueManagerImpl#getMaxInitiators <em>Max Initiators</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.mq.impl.MQQueueManagerImpl#getMQIAccounting <em>MQI Accounting</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.mq.impl.MQQueueManagerImpl#getMQIBindType <em>MQI Bind Type</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.mq.impl.MQQueueManagerImpl#getMQIStatistics <em>MQI Statistics</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.mq.impl.MQQueueManagerImpl#getNetBiosAdaptorNumber <em>Net Bios Adaptor Number</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.mq.impl.MQQueueManagerImpl#getNetBiosLibrary1 <em>Net Bios Library1</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.mq.impl.MQQueueManagerImpl#getNetBiosLocalName <em>Net Bios Local Name</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.mq.impl.MQQueueManagerImpl#getNetBiosNumberOfCommands <em>Net Bios Number Of Commands</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.mq.impl.MQQueueManagerImpl#getNetBiosNumberOfNames <em>Net Bios Number Of Names</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.mq.impl.MQQueueManagerImpl#getNetBiosNumberOfSessions <em>Net Bios Number Of Sessions</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.mq.impl.MQQueueManagerImpl#getOutboundPortMax <em>Outbound Port Max</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.mq.impl.MQQueueManagerImpl#getOutboundPortMin <em>Outbound Port Min</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.mq.impl.MQQueueManagerImpl#getPerformanceEvent <em>Performance Event</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.mq.impl.MQQueueManagerImpl#getPipeLineLength <em>Pipe Line Length</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.mq.impl.MQQueueManagerImpl#getPlatform <em>Platform</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.mq.impl.MQQueueManagerImpl#getQueueAccounting <em>Queue Accounting</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.mq.impl.MQQueueManagerImpl#getQueueManagerName <em>Queue Manager Name</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.mq.impl.MQQueueManagerImpl#getQueueManagerStatus <em>Queue Manager Status</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.mq.impl.MQQueueManagerImpl#getQueueMonitoring <em>Queue Monitoring</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.mq.impl.MQQueueManagerImpl#getQueueStatistics <em>Queue Statistics</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.mq.impl.MQQueueManagerImpl#getReceiveTimeout <em>Receive Timeout</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.mq.impl.MQQueueManagerImpl#getReceiveTimeoutMin <em>Receive Timeout Min</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.mq.impl.MQQueueManagerImpl#getReceiveTimeoutType <em>Receive Timeout Type</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.mq.impl.MQQueueManagerImpl#getRemoteEvent <em>Remote Event</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.mq.impl.MQQueueManagerImpl#getRepositoryName <em>Repository Name</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.mq.impl.MQQueueManagerImpl#getRepositoryNameList <em>Repository Name List</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.mq.impl.MQQueueManagerImpl#getRoutingExitConnectType <em>Routing Exit Connect Type</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.mq.impl.MQQueueManagerImpl#getRoutingExitPath <em>Routing Exit Path</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.mq.impl.MQQueueManagerImpl#getSecurityPolicy <em>Security Policy</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.mq.impl.MQQueueManagerImpl#getServiceEntryPoints <em>Service Entry Points</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.mq.impl.MQQueueManagerImpl#getSharedQQmgrName <em>Shared QQmgr Name</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.mq.impl.MQQueueManagerImpl#getSPXBoardNumber <em>SPX Board Number</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.mq.impl.MQQueueManagerImpl#getSPXKeepAlive <em>SPX Keep Alive</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.mq.impl.MQQueueManagerImpl#getSPXLibrary1 <em>SPX Library1</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.mq.impl.MQQueueManagerImpl#getSPXLibrary2 <em>SPX Library2</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.mq.impl.MQQueueManagerImpl#getSPXSocket <em>SPX Socket</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.mq.impl.MQQueueManagerImpl#getSSLCRLNameList <em>SSLCRL Name List</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.mq.impl.MQQueueManagerImpl#getSSLCrytoHardware <em>SSL Cryto Hardware</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.mq.impl.MQQueueManagerImpl#getSSLEvent <em>SSL Event</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.mq.impl.MQQueueManagerImpl#getSSLFips <em>SSL Fips</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.mq.impl.MQQueueManagerImpl#getSSLKeyRepository <em>SSL Key Repository</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.mq.impl.MQQueueManagerImpl#getSSLKeyResetCount <em>SSL Key Reset Count</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.mq.impl.MQQueueManagerImpl#getSSLTasks <em>SSL Tasks</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.mq.impl.MQQueueManagerImpl#getStartStopEvent <em>Start Stop Event</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.mq.impl.MQQueueManagerImpl#getStatisticsInterval <em>Statistics Interval</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.mq.impl.MQQueueManagerImpl#getSuppresedMessages <em>Suppresed Messages</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.mq.impl.MQQueueManagerImpl#getSuppressedMessageInterval <em>Suppressed Message Interval</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.mq.impl.MQQueueManagerImpl#getTCPKeepAlive <em>TCP Keep Alive</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.mq.impl.MQQueueManagerImpl#getTCPLibrary1 <em>TCP Library1</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.mq.impl.MQQueueManagerImpl#getTCPLibrary2 <em>TCP Library2</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.mq.impl.MQQueueManagerImpl#getTCPListenerBacklog <em>TCP Listener Backlog</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.mq.impl.MQQueueManagerImpl#getTCPName <em>TCP Name</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.mq.impl.MQQueueManagerImpl#getTCPPort <em>TCP Port</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.mq.impl.MQQueueManagerImpl#getTCPStackType <em>TCP Stack Type</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.mq.impl.MQQueueManagerImpl#getTraceRouteRecording <em>Trace Route Recording</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.mq.impl.MQQueueManagerImpl#getTriggerInterval <em>Trigger Interval</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.mq.impl.MQQueueManagerImpl#getWhatIf <em>What If</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class MQQueueManagerImpl extends CapabilityImpl implements MQQueueManager {
	/**
	 * The default value of the '{@link #getAccountingConnectionOverride() <em>Accounting Connection Override</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getAccountingConnectionOverride()
	 * @generated
	 * @ordered
	 */
	protected static final String ACCOUNTING_CONNECTION_OVERRIDE_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getAccountingConnectionOverride() <em>Accounting Connection Override</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getAccountingConnectionOverride()
	 * @generated
	 * @ordered
	 */
	protected String accountingConnectionOverride = ACCOUNTING_CONNECTION_OVERRIDE_EDEFAULT;

	/**
	 * The default value of the '{@link #getAccountingInterval() <em>Accounting Interval</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getAccountingInterval()
	 * @generated
	 * @ordered
	 */
	protected static final String ACCOUNTING_INTERVAL_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getAccountingInterval() <em>Accounting Interval</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getAccountingInterval()
	 * @generated
	 * @ordered
	 */
	protected String accountingInterval = ACCOUNTING_INTERVAL_EDEFAULT;

	/**
	 * The default value of the '{@link #getActivityRecording() <em>Activity Recording</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getActivityRecording()
	 * @generated
	 * @ordered
	 */
	protected static final String ACTIVITY_RECORDING_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getActivityRecording() <em>Activity Recording</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getActivityRecording()
	 * @generated
	 * @ordered
	 */
	protected String activityRecording = ACTIVITY_RECORDING_EDEFAULT;

	/**
	 * The default value of the '{@link #getAdoptNewMCA() <em>Adopt New MCA</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getAdoptNewMCA()
	 * @generated
	 * @ordered
	 */
	protected static final String ADOPT_NEW_MCA_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getAdoptNewMCA() <em>Adopt New MCA</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getAdoptNewMCA()
	 * @generated
	 * @ordered
	 */
	protected String adoptNewMCA = ADOPT_NEW_MCA_EDEFAULT;

	/**
	 * The default value of the '{@link #getAdoptNewMCACheck() <em>Adopt New MCA Check</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getAdoptNewMCACheck()
	 * @generated
	 * @ordered
	 */
	protected static final String ADOPT_NEW_MCA_CHECK_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getAdoptNewMCACheck() <em>Adopt New MCA Check</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getAdoptNewMCACheck()
	 * @generated
	 * @ordered
	 */
	protected String adoptNewMCACheck = ADOPT_NEW_MCA_CHECK_EDEFAULT;

	/**
	 * The default value of the '{@link #getAdoptNewMCAType() <em>Adopt New MCA Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getAdoptNewMCAType()
	 * @generated
	 * @ordered
	 */
	protected static final String ADOPT_NEW_MCA_TYPE_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getAdoptNewMCAType() <em>Adopt New MCA Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getAdoptNewMCAType()
	 * @generated
	 * @ordered
	 */
	protected String adoptNewMCAType = ADOPT_NEW_MCA_TYPE_EDEFAULT;

	/**
	 * The default value of the '{@link #getAuthorityEvent() <em>Authority Event</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getAuthorityEvent()
	 * @generated
	 * @ordered
	 */
	protected static final String AUTHORITY_EVENT_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getAuthorityEvent() <em>Authority Event</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getAuthorityEvent()
	 * @generated
	 * @ordered
	 */
	protected String authorityEvent = AUTHORITY_EVENT_EDEFAULT;

	/**
	 * The default value of the '{@link #getAutomatic() <em>Automatic</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getAutomatic()
	 * @generated
	 * @ordered
	 */
	protected static final String AUTOMATIC_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getAutomatic() <em>Automatic</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getAutomatic()
	 * @generated
	 * @ordered
	 */
	protected String automatic = AUTOMATIC_EDEFAULT;

	/**
	 * The default value of the '{@link #getBridgeEvent() <em>Bridge Event</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getBridgeEvent()
	 * @generated
	 * @ordered
	 */
	protected static final String BRIDGE_EVENT_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getBridgeEvent() <em>Bridge Event</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getBridgeEvent()
	 * @generated
	 * @ordered
	 */
	protected String bridgeEvent = BRIDGE_EVENT_EDEFAULT;

	/**
	 * The default value of the '{@link #getBrokerMessageRetryCount() <em>Broker Message Retry Count</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getBrokerMessageRetryCount()
	 * @generated
	 * @ordered
	 */
	protected static final String BROKER_MESSAGE_RETRY_COUNT_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getBrokerMessageRetryCount() <em>Broker Message Retry Count</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getBrokerMessageRetryCount()
	 * @generated
	 * @ordered
	 */
	protected String brokerMessageRetryCount = BROKER_MESSAGE_RETRY_COUNT_EDEFAULT;

	/**
	 * The default value of the '{@link #getBrokerOpenCacheExpiry() <em>Broker Open Cache Expiry</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getBrokerOpenCacheExpiry()
	 * @generated
	 * @ordered
	 */
	protected static final String BROKER_OPEN_CACHE_EXPIRY_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getBrokerOpenCacheExpiry() <em>Broker Open Cache Expiry</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getBrokerOpenCacheExpiry()
	 * @generated
	 * @ordered
	 */
	protected String brokerOpenCacheExpiry = BROKER_OPEN_CACHE_EXPIRY_EDEFAULT;

	/**
	 * The default value of the '{@link #getBrokerOpenCacheSize() <em>Broker Open Cache Size</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getBrokerOpenCacheSize()
	 * @generated
	 * @ordered
	 */
	protected static final String BROKER_OPEN_CACHE_SIZE_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getBrokerOpenCacheSize() <em>Broker Open Cache Size</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getBrokerOpenCacheSize()
	 * @generated
	 * @ordered
	 */
	protected String brokerOpenCacheSize = BROKER_OPEN_CACHE_SIZE_EDEFAULT;

	/**
	 * The default value of the '{@link #getBrokerPublicBatchInterval() <em>Broker Public Batch Interval</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getBrokerPublicBatchInterval()
	 * @generated
	 * @ordered
	 */
	protected static final String BROKER_PUBLIC_BATCH_INTERVAL_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getBrokerPublicBatchInterval() <em>Broker Public Batch Interval</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getBrokerPublicBatchInterval()
	 * @generated
	 * @ordered
	 */
	protected String brokerPublicBatchInterval = BROKER_PUBLIC_BATCH_INTERVAL_EDEFAULT;

	/**
	 * The default value of the '{@link #getBrokerPublishBatchSize() <em>Broker Publish Batch Size</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getBrokerPublishBatchSize()
	 * @generated
	 * @ordered
	 */
	protected static final String BROKER_PUBLISH_BATCH_SIZE_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getBrokerPublishBatchSize() <em>Broker Publish Batch Size</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getBrokerPublishBatchSize()
	 * @generated
	 * @ordered
	 */
	protected String brokerPublishBatchSize = BROKER_PUBLISH_BATCH_SIZE_EDEFAULT;

	/**
	 * The default value of the '{@link #getBrokerStreamsPerProcess() <em>Broker Streams Per Process</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getBrokerStreamsPerProcess()
	 * @generated
	 * @ordered
	 */
	protected static final String BROKER_STREAMS_PER_PROCESS_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getBrokerStreamsPerProcess() <em>Broker Streams Per Process</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getBrokerStreamsPerProcess()
	 * @generated
	 * @ordered
	 */
	protected String brokerStreamsPerProcess = BROKER_STREAMS_PER_PROCESS_EDEFAULT;

	/**
	 * The default value of the '{@link #getChannelAutoDefinition() <em>Channel Auto Definition</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getChannelAutoDefinition()
	 * @generated
	 * @ordered
	 */
	protected static final String CHANNEL_AUTO_DEFINITION_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getChannelAutoDefinition() <em>Channel Auto Definition</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getChannelAutoDefinition()
	 * @generated
	 * @ordered
	 */
	protected String channelAutoDefinition = CHANNEL_AUTO_DEFINITION_EDEFAULT;

	/**
	 * The default value of the '{@link #getChannelAutoDefinitionEvent() <em>Channel Auto Definition Event</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getChannelAutoDefinitionEvent()
	 * @generated
	 * @ordered
	 */
	protected static final String CHANNEL_AUTO_DEFINITION_EVENT_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getChannelAutoDefinitionEvent() <em>Channel Auto Definition Event</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getChannelAutoDefinitionEvent()
	 * @generated
	 * @ordered
	 */
	protected String channelAutoDefinitionEvent = CHANNEL_AUTO_DEFINITION_EVENT_EDEFAULT;

	/**
	 * The default value of the '{@link #getChannelEvent() <em>Channel Event</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getChannelEvent()
	 * @generated
	 * @ordered
	 */
	protected static final String CHANNEL_EVENT_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getChannelEvent() <em>Channel Event</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getChannelEvent()
	 * @generated
	 * @ordered
	 */
	protected String channelEvent = CHANNEL_EVENT_EDEFAULT;

	/**
	 * The default value of the '{@link #getChannelInitiatorAdapters() <em>Channel Initiator Adapters</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getChannelInitiatorAdapters()
	 * @generated
	 * @ordered
	 */
	protected static final String CHANNEL_INITIATOR_ADAPTERS_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getChannelInitiatorAdapters() <em>Channel Initiator Adapters</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getChannelInitiatorAdapters()
	 * @generated
	 * @ordered
	 */
	protected String channelInitiatorAdapters = CHANNEL_INITIATOR_ADAPTERS_EDEFAULT;

	/**
	 * The default value of the '{@link #getChannelInitiatorControl() <em>Channel Initiator Control</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getChannelInitiatorControl()
	 * @generated
	 * @ordered
	 */
	protected static final String CHANNEL_INITIATOR_CONTROL_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getChannelInitiatorControl() <em>Channel Initiator Control</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getChannelInitiatorControl()
	 * @generated
	 * @ordered
	 */
	protected String channelInitiatorControl = CHANNEL_INITIATOR_CONTROL_EDEFAULT;

	/**
	 * The default value of the '{@link #getChannelInitiatorDispatchers() <em>Channel Initiator Dispatchers</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getChannelInitiatorDispatchers()
	 * @generated
	 * @ordered
	 */
	protected static final String CHANNEL_INITIATOR_DISPATCHERS_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getChannelInitiatorDispatchers() <em>Channel Initiator Dispatchers</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getChannelInitiatorDispatchers()
	 * @generated
	 * @ordered
	 */
	protected String channelInitiatorDispatchers = CHANNEL_INITIATOR_DISPATCHERS_EDEFAULT;

	/**
	 * The default value of the '{@link #getChannelInitiatorTraceAutoStart() <em>Channel Initiator Trace Auto Start</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getChannelInitiatorTraceAutoStart()
	 * @generated
	 * @ordered
	 */
	protected static final String CHANNEL_INITIATOR_TRACE_AUTO_START_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getChannelInitiatorTraceAutoStart() <em>Channel Initiator Trace Auto Start</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getChannelInitiatorTraceAutoStart()
	 * @generated
	 * @ordered
	 */
	protected String channelInitiatorTraceAutoStart = CHANNEL_INITIATOR_TRACE_AUTO_START_EDEFAULT;

	/**
	 * The default value of the '{@link #getChannelInitiatorTraceTableSize() <em>Channel Initiator Trace Table Size</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getChannelInitiatorTraceTableSize()
	 * @generated
	 * @ordered
	 */
	protected static final String CHANNEL_INITIATOR_TRACE_TABLE_SIZE_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getChannelInitiatorTraceTableSize() <em>Channel Initiator Trace Table Size</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getChannelInitiatorTraceTableSize()
	 * @generated
	 * @ordered
	 */
	protected String channelInitiatorTraceTableSize = CHANNEL_INITIATOR_TRACE_TABLE_SIZE_EDEFAULT;

	/**
	 * The default value of the '{@link #getChannelMonitoring() <em>Channel Monitoring</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getChannelMonitoring()
	 * @generated
	 * @ordered
	 */
	protected static final String CHANNEL_MONITORING_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getChannelMonitoring() <em>Channel Monitoring</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getChannelMonitoring()
	 * @generated
	 * @ordered
	 */
	protected String channelMonitoring = CHANNEL_MONITORING_EDEFAULT;

	/**
	 * The default value of the '{@link #getChannelStatistics() <em>Channel Statistics</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getChannelStatistics()
	 * @generated
	 * @ordered
	 */
	protected static final String CHANNEL_STATISTICS_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getChannelStatistics() <em>Channel Statistics</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getChannelStatistics()
	 * @generated
	 * @ordered
	 */
	protected String channelStatistics = CHANNEL_STATISTICS_EDEFAULT;

	/**
	 * The default value of the '{@link #getCheckpointActiveCount() <em>Checkpoint Active Count</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getCheckpointActiveCount()
	 * @generated
	 * @ordered
	 */
	protected static final String CHECKPOINT_ACTIVE_COUNT_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getCheckpointActiveCount() <em>Checkpoint Active Count</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getCheckpointActiveCount()
	 * @generated
	 * @ordered
	 */
	protected String checkpointActiveCount = CHECKPOINT_ACTIVE_COUNT_EDEFAULT;

	/**
	 * The default value of the '{@link #getCheckpointMessageSize() <em>Checkpoint Message Size</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getCheckpointMessageSize()
	 * @generated
	 * @ordered
	 */
	protected static final String CHECKPOINT_MESSAGE_SIZE_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getCheckpointMessageSize() <em>Checkpoint Message Size</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getCheckpointMessageSize()
	 * @generated
	 * @ordered
	 */
	protected String checkpointMessageSize = CHECKPOINT_MESSAGE_SIZE_EDEFAULT;

	/**
	 * The default value of the '{@link #getCheckpointRestartCount() <em>Checkpoint Restart Count</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getCheckpointRestartCount()
	 * @generated
	 * @ordered
	 */
	protected static final String CHECKPOINT_RESTART_COUNT_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getCheckpointRestartCount() <em>Checkpoint Restart Count</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getCheckpointRestartCount()
	 * @generated
	 * @ordered
	 */
	protected String checkpointRestartCount = CHECKPOINT_RESTART_COUNT_EDEFAULT;

	/**
	 * The default value of the '{@link #getClusterSenderMonitoring() <em>Cluster Sender Monitoring</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getClusterSenderMonitoring()
	 * @generated
	 * @ordered
	 */
	protected static final String CLUSTER_SENDER_MONITORING_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getClusterSenderMonitoring() <em>Cluster Sender Monitoring</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getClusterSenderMonitoring()
	 * @generated
	 * @ordered
	 */
	protected String clusterSenderMonitoring = CLUSTER_SENDER_MONITORING_EDEFAULT;

	/**
	 * The default value of the '{@link #getClusterSenderStatistics() <em>Cluster Sender Statistics</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getClusterSenderStatistics()
	 * @generated
	 * @ordered
	 */
	protected static final String CLUSTER_SENDER_STATISTICS_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getClusterSenderStatistics() <em>Cluster Sender Statistics</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getClusterSenderStatistics()
	 * @generated
	 * @ordered
	 */
	protected String clusterSenderStatistics = CLUSTER_SENDER_STATISTICS_EDEFAULT;

	/**
	 * The default value of the '{@link #getClusterWorkLoadData() <em>Cluster Work Load Data</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getClusterWorkLoadData()
	 * @generated
	 * @ordered
	 */
	protected static final String CLUSTER_WORK_LOAD_DATA_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getClusterWorkLoadData() <em>Cluster Work Load Data</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getClusterWorkLoadData()
	 * @generated
	 * @ordered
	 */
	protected String clusterWorkLoadData = CLUSTER_WORK_LOAD_DATA_EDEFAULT;

	/**
	 * The default value of the '{@link #getClusterWorkLoadExit() <em>Cluster Work Load Exit</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getClusterWorkLoadExit()
	 * @generated
	 * @ordered
	 */
	protected static final String CLUSTER_WORK_LOAD_EXIT_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getClusterWorkLoadExit() <em>Cluster Work Load Exit</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getClusterWorkLoadExit()
	 * @generated
	 * @ordered
	 */
	protected String clusterWorkLoadExit = CLUSTER_WORK_LOAD_EXIT_EDEFAULT;

	/**
	 * The default value of the '{@link #getClusterWorkLoadLength() <em>Cluster Work Load Length</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getClusterWorkLoadLength()
	 * @generated
	 * @ordered
	 */
	protected static final String CLUSTER_WORK_LOAD_LENGTH_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getClusterWorkLoadLength() <em>Cluster Work Load Length</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getClusterWorkLoadLength()
	 * @generated
	 * @ordered
	 */
	protected String clusterWorkLoadLength = CLUSTER_WORK_LOAD_LENGTH_EDEFAULT;

	/**
	 * The default value of the '{@link #getClusterWorkloadUseQ() <em>Cluster Workload Use Q</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getClusterWorkloadUseQ()
	 * @generated
	 * @ordered
	 */
	protected static final String CLUSTER_WORKLOAD_USE_Q_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getClusterWorkloadUseQ() <em>Cluster Workload Use Q</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getClusterWorkloadUseQ()
	 * @generated
	 * @ordered
	 */
	protected String clusterWorkloadUseQ = CLUSTER_WORKLOAD_USE_Q_EDEFAULT;

	/**
	 * The default value of the '{@link #getCodedCharSetId() <em>Coded Char Set Id</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getCodedCharSetId()
	 * @generated
	 * @ordered
	 */
	protected static final String CODED_CHAR_SET_ID_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getCodedCharSetId() <em>Coded Char Set Id</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getCodedCharSetId()
	 * @generated
	 * @ordered
	 */
	protected String codedCharSetId = CODED_CHAR_SET_ID_EDEFAULT;

	/**
	 * The default value of the '{@link #getCommandEvent() <em>Command Event</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getCommandEvent()
	 * @generated
	 * @ordered
	 */
	protected static final String COMMAND_EVENT_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getCommandEvent() <em>Command Event</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getCommandEvent()
	 * @generated
	 * @ordered
	 */
	protected String commandEvent = COMMAND_EVENT_EDEFAULT;

	/**
	 * The default value of the '{@link #getCommandLevel() <em>Command Level</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getCommandLevel()
	 * @generated
	 * @ordered
	 */
	protected static final String COMMAND_LEVEL_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getCommandLevel() <em>Command Level</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getCommandLevel()
	 * @generated
	 * @ordered
	 */
	protected String commandLevel = COMMAND_LEVEL_EDEFAULT;

	/**
	 * The default value of the '{@link #getCommandScope() <em>Command Scope</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getCommandScope()
	 * @generated
	 * @ordered
	 */
	protected static final String COMMAND_SCOPE_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getCommandScope() <em>Command Scope</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getCommandScope()
	 * @generated
	 * @ordered
	 */
	protected String commandScope = COMMAND_SCOPE_EDEFAULT;

	/**
	 * The default value of the '{@link #getCommandServerControl() <em>Command Server Control</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getCommandServerControl()
	 * @generated
	 * @ordered
	 */
	protected static final String COMMAND_SERVER_CONTROL_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getCommandServerControl() <em>Command Server Control</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getCommandServerControl()
	 * @generated
	 * @ordered
	 */
	protected String commandServerControl = COMMAND_SERVER_CONTROL_EDEFAULT;

	/**
	 * The default value of the '{@link #getConfigurationEvent() <em>Configuration Event</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getConfigurationEvent()
	 * @generated
	 * @ordered
	 */
	protected static final String CONFIGURATION_EVENT_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getConfigurationEvent() <em>Configuration Event</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getConfigurationEvent()
	 * @generated
	 * @ordered
	 */
	protected String configurationEvent = CONFIGURATION_EVENT_EDEFAULT;

	/**
	 * The default value of the '{@link #getConfirm() <em>Confirm</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getConfirm()
	 * @generated
	 * @ordered
	 */
	protected static final String CONFIRM_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getConfirm() <em>Confirm</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getConfirm()
	 * @generated
	 * @ordered
	 */
	protected String confirm = CONFIRM_EDEFAULT;

	/**
	 * The default value of the '{@link #getDeadLetterQueue() <em>Dead Letter Queue</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDeadLetterQueue()
	 * @generated
	 * @ordered
	 */
	protected static final String DEAD_LETTER_QUEUE_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getDeadLetterQueue() <em>Dead Letter Queue</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDeadLetterQueue()
	 * @generated
	 * @ordered
	 */
	protected String deadLetterQueue = DEAD_LETTER_QUEUE_EDEFAULT;

	/**
	 * The default value of the '{@link #getDefaultBindType() <em>Default Bind Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDefaultBindType()
	 * @generated
	 * @ordered
	 */
	protected static final String DEFAULT_BIND_TYPE_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getDefaultBindType() <em>Default Bind Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDefaultBindType()
	 * @generated
	 * @ordered
	 */
	protected String defaultBindType = DEFAULT_BIND_TYPE_EDEFAULT;

	/**
	 * The default value of the '{@link #getDefaultTransmissionQueue() <em>Default Transmission Queue</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDefaultTransmissionQueue()
	 * @generated
	 * @ordered
	 */
	protected static final String DEFAULT_TRANSMISSION_QUEUE_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getDefaultTransmissionQueue() <em>Default Transmission Queue</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDefaultTransmissionQueue()
	 * @generated
	 * @ordered
	 */
	protected String defaultTransmissionQueue = DEFAULT_TRANSMISSION_QUEUE_EDEFAULT;

	/**
	 * The default value of the '{@link #getDescription1() <em>Description1</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDescription1()
	 * @generated
	 * @ordered
	 */
	protected static final String DESCRIPTION1_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getDescription1() <em>Description1</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDescription1()
	 * @generated
	 * @ordered
	 */
	protected String description1 = DESCRIPTION1_EDEFAULT;

	/**
	 * The default value of the '{@link #getDNSGroup() <em>DNS Group</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDNSGroup()
	 * @generated
	 * @ordered
	 */
	protected static final String DNS_GROUP_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getDNSGroup() <em>DNS Group</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDNSGroup()
	 * @generated
	 * @ordered
	 */
	protected String dNSGroup = DNS_GROUP_EDEFAULT;

	/**
	 * The default value of the '{@link #getDNSWLM() <em>DNSWLM</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDNSWLM()
	 * @generated
	 * @ordered
	 */
	protected static final String DNSWLM_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getDNSWLM() <em>DNSWLM</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDNSWLM()
	 * @generated
	 * @ordered
	 */
	protected String dNSWLM = DNSWLM_EDEFAULT;

	/**
	 * The default value of the '{@link #getErrorLogSize() <em>Error Log Size</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getErrorLogSize()
	 * @generated
	 * @ordered
	 */
	protected static final String ERROR_LOG_SIZE_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getErrorLogSize() <em>Error Log Size</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getErrorLogSize()
	 * @generated
	 * @ordered
	 */
	protected String errorLogSize = ERROR_LOG_SIZE_EDEFAULT;

	/**
	 * The default value of the '{@link #getExcludedMessages() <em>Excluded Messages</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getExcludedMessages()
	 * @generated
	 * @ordered
	 */
	protected static final String EXCLUDED_MESSAGES_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getExcludedMessages() <em>Excluded Messages</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getExcludedMessages()
	 * @generated
	 * @ordered
	 */
	protected String excludedMessages = EXCLUDED_MESSAGES_EDEFAULT;

	/**
	 * The default value of the '{@link #getExitsDefaultPath() <em>Exits Default Path</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getExitsDefaultPath()
	 * @generated
	 * @ordered
	 */
	protected static final String EXITS_DEFAULT_PATH_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getExitsDefaultPath() <em>Exits Default Path</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getExitsDefaultPath()
	 * @generated
	 * @ordered
	 */
	protected String exitsDefaultPath = EXITS_DEFAULT_PATH_EDEFAULT;

	/**
	 * The default value of the '{@link #getExpiryInterval() <em>Expiry Interval</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getExpiryInterval()
	 * @generated
	 * @ordered
	 */
	protected static final String EXPIRY_INTERVAL_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getExpiryInterval() <em>Expiry Interval</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getExpiryInterval()
	 * @generated
	 * @ordered
	 */
	protected String expiryInterval = EXPIRY_INTERVAL_EDEFAULT;

	/**
	 * The default value of the '{@link #getIGQPutAuthority() <em>IGQ Put Authority</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getIGQPutAuthority()
	 * @generated
	 * @ordered
	 */
	protected static final String IGQ_PUT_AUTHORITY_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getIGQPutAuthority() <em>IGQ Put Authority</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getIGQPutAuthority()
	 * @generated
	 * @ordered
	 */
	protected String iGQPutAuthority = IGQ_PUT_AUTHORITY_EDEFAULT;

	/**
	 * The default value of the '{@link #getIGQUserId() <em>IGQ User Id</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getIGQUserId()
	 * @generated
	 * @ordered
	 */
	protected static final String IGQ_USER_ID_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getIGQUserId() <em>IGQ User Id</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getIGQUserId()
	 * @generated
	 * @ordered
	 */
	protected String iGQUserId = IGQ_USER_ID_EDEFAULT;

	/**
	 * The default value of the '{@link #getInhibitEvent() <em>Inhibit Event</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getInhibitEvent()
	 * @generated
	 * @ordered
	 */
	protected static final String INHIBIT_EVENT_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getInhibitEvent() <em>Inhibit Event</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getInhibitEvent()
	 * @generated
	 * @ordered
	 */
	protected String inhibitEvent = INHIBIT_EVENT_EDEFAULT;

	/**
	 * The default value of the '{@link #getInstallableServiceName() <em>Installable Service Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getInstallableServiceName()
	 * @generated
	 * @ordered
	 */
	protected static final String INSTALLABLE_SERVICE_NAME_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getInstallableServiceName() <em>Installable Service Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getInstallableServiceName()
	 * @generated
	 * @ordered
	 */
	protected String installableServiceName = INSTALLABLE_SERVICE_NAME_EDEFAULT;

	/**
	 * The default value of the '{@link #getIntraGroupQueuing() <em>Intra Group Queuing</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getIntraGroupQueuing()
	 * @generated
	 * @ordered
	 */
	protected static final String INTRA_GROUP_QUEUING_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getIntraGroupQueuing() <em>Intra Group Queuing</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getIntraGroupQueuing()
	 * @generated
	 * @ordered
	 */
	protected String intraGroupQueuing = INTRA_GROUP_QUEUING_EDEFAULT;

	/**
	 * The default value of the '{@link #getIPAddressVersion() <em>IP Address Version</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getIPAddressVersion()
	 * @generated
	 * @ordered
	 */
	protected static final String IP_ADDRESS_VERSION_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getIPAddressVersion() <em>IP Address Version</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getIPAddressVersion()
	 * @generated
	 * @ordered
	 */
	protected String iPAddressVersion = IP_ADDRESS_VERSION_EDEFAULT;

	/**
	 * The default value of the '{@link #getListenerTimer() <em>Listener Timer</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getListenerTimer()
	 * @generated
	 * @ordered
	 */
	protected static final String LISTENER_TIMER_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getListenerTimer() <em>Listener Timer</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getListenerTimer()
	 * @generated
	 * @ordered
	 */
	protected String listenerTimer = LISTENER_TIMER_EDEFAULT;

	/**
	 * The default value of the '{@link #getLocalEvent() <em>Local Event</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getLocalEvent()
	 * @generated
	 * @ordered
	 */
	protected static final String LOCAL_EVENT_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getLocalEvent() <em>Local Event</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getLocalEvent()
	 * @generated
	 * @ordered
	 */
	protected String localEvent = LOCAL_EVENT_EDEFAULT;

	/**
	 * The default value of the '{@link #getLogBufferPages() <em>Log Buffer Pages</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getLogBufferPages()
	 * @generated
	 * @ordered
	 */
	protected static final String LOG_BUFFER_PAGES_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getLogBufferPages() <em>Log Buffer Pages</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getLogBufferPages()
	 * @generated
	 * @ordered
	 */
	protected String logBufferPages = LOG_BUFFER_PAGES_EDEFAULT;

	/**
	 * The default value of the '{@link #getLogFilePages() <em>Log File Pages</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getLogFilePages()
	 * @generated
	 * @ordered
	 */
	protected static final String LOG_FILE_PAGES_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getLogFilePages() <em>Log File Pages</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getLogFilePages()
	 * @generated
	 * @ordered
	 */
	protected String logFilePages = LOG_FILE_PAGES_EDEFAULT;

	/**
	 * The default value of the '{@link #getLogPath() <em>Log Path</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getLogPath()
	 * @generated
	 * @ordered
	 */
	protected static final String LOG_PATH_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getLogPath() <em>Log Path</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getLogPath()
	 * @generated
	 * @ordered
	 */
	protected String logPath = LOG_PATH_EDEFAULT;

	/**
	 * The default value of the '{@link #getLogPrimaryFiles() <em>Log Primary Files</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getLogPrimaryFiles()
	 * @generated
	 * @ordered
	 */
	protected static final String LOG_PRIMARY_FILES_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getLogPrimaryFiles() <em>Log Primary Files</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getLogPrimaryFiles()
	 * @generated
	 * @ordered
	 */
	protected String logPrimaryFiles = LOG_PRIMARY_FILES_EDEFAULT;

	/**
	 * The default value of the '{@link #getLogSecondaryFiles() <em>Log Secondary Files</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getLogSecondaryFiles()
	 * @generated
	 * @ordered
	 */
	protected static final String LOG_SECONDARY_FILES_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getLogSecondaryFiles() <em>Log Secondary Files</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getLogSecondaryFiles()
	 * @generated
	 * @ordered
	 */
	protected String logSecondaryFiles = LOG_SECONDARY_FILES_EDEFAULT;

	/**
	 * The default value of the '{@link #getLogType() <em>Log Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getLogType()
	 * @generated
	 * @ordered
	 */
	protected static final String LOG_TYPE_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getLogType() <em>Log Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getLogType()
	 * @generated
	 * @ordered
	 */
	protected String logType = LOG_TYPE_EDEFAULT;

	/**
	 * The default value of the '{@link #getLogWriteIntegrity() <em>Log Write Integrity</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getLogWriteIntegrity()
	 * @generated
	 * @ordered
	 */
	protected static final String LOG_WRITE_INTEGRITY_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getLogWriteIntegrity() <em>Log Write Integrity</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getLogWriteIntegrity()
	 * @generated
	 * @ordered
	 */
	protected String logWriteIntegrity = LOG_WRITE_INTEGRITY_EDEFAULT;

	/**
	 * The default value of the '{@link #getLU62ARMSuffix() <em>LU62ARM Suffix</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getLU62ARMSuffix()
	 * @generated
	 * @ordered
	 */
	protected static final String LU62ARM_SUFFIX_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getLU62ARMSuffix() <em>LU62ARM Suffix</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getLU62ARMSuffix()
	 * @generated
	 * @ordered
	 */
	protected String lU62ARMSuffix = LU62ARM_SUFFIX_EDEFAULT;

	/**
	 * The default value of the '{@link #getLU62Channels() <em>LU62 Channels</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getLU62Channels()
	 * @generated
	 * @ordered
	 */
	protected static final String LU62_CHANNELS_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getLU62Channels() <em>LU62 Channels</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getLU62Channels()
	 * @generated
	 * @ordered
	 */
	protected String lU62Channels = LU62_CHANNELS_EDEFAULT;

	/**
	 * The default value of the '{@link #getLUGroupName() <em>LU Group Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getLUGroupName()
	 * @generated
	 * @ordered
	 */
	protected static final String LU_GROUP_NAME_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getLUGroupName() <em>LU Group Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getLUGroupName()
	 * @generated
	 * @ordered
	 */
	protected String lUGroupName = LU_GROUP_NAME_EDEFAULT;

	/**
	 * The default value of the '{@link #getLULibrary1() <em>LU Library1</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getLULibrary1()
	 * @generated
	 * @ordered
	 */
	protected static final String LU_LIBRARY1_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getLULibrary1() <em>LU Library1</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getLULibrary1()
	 * @generated
	 * @ordered
	 */
	protected String lULibrary1 = LU_LIBRARY1_EDEFAULT;

	/**
	 * The default value of the '{@link #getLULibrary2() <em>LU Library2</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getLULibrary2()
	 * @generated
	 * @ordered
	 */
	protected static final String LU_LIBRARY2_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getLULibrary2() <em>LU Library2</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getLULibrary2()
	 * @generated
	 * @ordered
	 */
	protected String lULibrary2 = LU_LIBRARY2_EDEFAULT;

	/**
	 * The default value of the '{@link #getLULocalLU() <em>LU Local LU</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getLULocalLU()
	 * @generated
	 * @ordered
	 */
	protected static final String LU_LOCAL_LU_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getLULocalLU() <em>LU Local LU</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getLULocalLU()
	 * @generated
	 * @ordered
	 */
	protected String lULocalLU = LU_LOCAL_LU_EDEFAULT;

	/**
	 * The default value of the '{@link #getLUName() <em>LU Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getLUName()
	 * @generated
	 * @ordered
	 */
	protected static final String LU_NAME_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getLUName() <em>LU Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getLUName()
	 * @generated
	 * @ordered
	 */
	protected String lUName = LU_NAME_EDEFAULT;

	/**
	 * The default value of the '{@link #getLUTPName() <em>LUTP Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getLUTPName()
	 * @generated
	 * @ordered
	 */
	protected static final String LUTP_NAME_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getLUTPName() <em>LUTP Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getLUTPName()
	 * @generated
	 * @ordered
	 */
	protected String lUTPName = LUTP_NAME_EDEFAULT;

	/**
	 * The default value of the '{@link #getMaxActiveChannels() <em>Max Active Channels</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getMaxActiveChannels()
	 * @generated
	 * @ordered
	 */
	protected static final String MAX_ACTIVE_CHANNELS_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getMaxActiveChannels() <em>Max Active Channels</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getMaxActiveChannels()
	 * @generated
	 * @ordered
	 */
	protected String maxActiveChannels = MAX_ACTIVE_CHANNELS_EDEFAULT;

	/**
	 * The default value of the '{@link #getMaxChannels() <em>Max Channels</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getMaxChannels()
	 * @generated
	 * @ordered
	 */
	protected static final String MAX_CHANNELS_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getMaxChannels() <em>Max Channels</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getMaxChannels()
	 * @generated
	 * @ordered
	 */
	protected String maxChannels = MAX_CHANNELS_EDEFAULT;

	/**
	 * The default value of the '{@link #getMaximumCurrentChannels() <em>Maximum Current Channels</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getMaximumCurrentChannels()
	 * @generated
	 * @ordered
	 */
	protected static final String MAXIMUM_CURRENT_CHANNELS_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getMaximumCurrentChannels() <em>Maximum Current Channels</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getMaximumCurrentChannels()
	 * @generated
	 * @ordered
	 */
	protected String maximumCurrentChannels = MAXIMUM_CURRENT_CHANNELS_EDEFAULT;

	/**
	 * The default value of the '{@link #getMaximumHandles() <em>Maximum Handles</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getMaximumHandles()
	 * @generated
	 * @ordered
	 */
	protected static final String MAXIMUM_HANDLES_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getMaximumHandles() <em>Maximum Handles</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getMaximumHandles()
	 * @generated
	 * @ordered
	 */
	protected String maximumHandles = MAXIMUM_HANDLES_EDEFAULT;

	/**
	 * The default value of the '{@link #getMaximumMessageLength() <em>Maximum Message Length</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getMaximumMessageLength()
	 * @generated
	 * @ordered
	 */
	protected static final String MAXIMUM_MESSAGE_LENGTH_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getMaximumMessageLength() <em>Maximum Message Length</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getMaximumMessageLength()
	 * @generated
	 * @ordered
	 */
	protected String maximumMessageLength = MAXIMUM_MESSAGE_LENGTH_EDEFAULT;

	/**
	 * The default value of the '{@link #getMaximumTCPChannels() <em>Maximum TCP Channels</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getMaximumTCPChannels()
	 * @generated
	 * @ordered
	 */
	protected static final String MAXIMUM_TCP_CHANNELS_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getMaximumTCPChannels() <em>Maximum TCP Channels</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getMaximumTCPChannels()
	 * @generated
	 * @ordered
	 */
	protected String maximumTCPChannels = MAXIMUM_TCP_CHANNELS_EDEFAULT;

	/**
	 * The default value of the '{@link #getMaximumUncommittedMessages() <em>Maximum Uncommitted Messages</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getMaximumUncommittedMessages()
	 * @generated
	 * @ordered
	 */
	protected static final String MAXIMUM_UNCOMMITTED_MESSAGES_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getMaximumUncommittedMessages() <em>Maximum Uncommitted Messages</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getMaximumUncommittedMessages()
	 * @generated
	 * @ordered
	 */
	protected String maximumUncommittedMessages = MAXIMUM_UNCOMMITTED_MESSAGES_EDEFAULT;

	/**
	 * The default value of the '{@link #getMaxInitiators() <em>Max Initiators</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getMaxInitiators()
	 * @generated
	 * @ordered
	 */
	protected static final String MAX_INITIATORS_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getMaxInitiators() <em>Max Initiators</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getMaxInitiators()
	 * @generated
	 * @ordered
	 */
	protected String maxInitiators = MAX_INITIATORS_EDEFAULT;

	/**
	 * The default value of the '{@link #getMQIAccounting() <em>MQI Accounting</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getMQIAccounting()
	 * @generated
	 * @ordered
	 */
	protected static final String MQI_ACCOUNTING_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getMQIAccounting() <em>MQI Accounting</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getMQIAccounting()
	 * @generated
	 * @ordered
	 */
	protected String mQIAccounting = MQI_ACCOUNTING_EDEFAULT;

	/**
	 * The default value of the '{@link #getMQIBindType() <em>MQI Bind Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getMQIBindType()
	 * @generated
	 * @ordered
	 */
	protected static final String MQI_BIND_TYPE_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getMQIBindType() <em>MQI Bind Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getMQIBindType()
	 * @generated
	 * @ordered
	 */
	protected String mQIBindType = MQI_BIND_TYPE_EDEFAULT;

	/**
	 * The default value of the '{@link #getMQIStatistics() <em>MQI Statistics</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getMQIStatistics()
	 * @generated
	 * @ordered
	 */
	protected static final String MQI_STATISTICS_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getMQIStatistics() <em>MQI Statistics</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getMQIStatistics()
	 * @generated
	 * @ordered
	 */
	protected String mQIStatistics = MQI_STATISTICS_EDEFAULT;

	/**
	 * The default value of the '{@link #getNetBiosAdaptorNumber() <em>Net Bios Adaptor Number</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getNetBiosAdaptorNumber()
	 * @generated
	 * @ordered
	 */
	protected static final String NET_BIOS_ADAPTOR_NUMBER_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getNetBiosAdaptorNumber() <em>Net Bios Adaptor Number</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getNetBiosAdaptorNumber()
	 * @generated
	 * @ordered
	 */
	protected String netBiosAdaptorNumber = NET_BIOS_ADAPTOR_NUMBER_EDEFAULT;

	/**
	 * The default value of the '{@link #getNetBiosLibrary1() <em>Net Bios Library1</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getNetBiosLibrary1()
	 * @generated
	 * @ordered
	 */
	protected static final String NET_BIOS_LIBRARY1_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getNetBiosLibrary1() <em>Net Bios Library1</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getNetBiosLibrary1()
	 * @generated
	 * @ordered
	 */
	protected String netBiosLibrary1 = NET_BIOS_LIBRARY1_EDEFAULT;

	/**
	 * The default value of the '{@link #getNetBiosLocalName() <em>Net Bios Local Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getNetBiosLocalName()
	 * @generated
	 * @ordered
	 */
	protected static final String NET_BIOS_LOCAL_NAME_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getNetBiosLocalName() <em>Net Bios Local Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getNetBiosLocalName()
	 * @generated
	 * @ordered
	 */
	protected String netBiosLocalName = NET_BIOS_LOCAL_NAME_EDEFAULT;

	/**
	 * The default value of the '{@link #getNetBiosNumberOfCommands() <em>Net Bios Number Of Commands</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getNetBiosNumberOfCommands()
	 * @generated
	 * @ordered
	 */
	protected static final String NET_BIOS_NUMBER_OF_COMMANDS_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getNetBiosNumberOfCommands() <em>Net Bios Number Of Commands</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getNetBiosNumberOfCommands()
	 * @generated
	 * @ordered
	 */
	protected String netBiosNumberOfCommands = NET_BIOS_NUMBER_OF_COMMANDS_EDEFAULT;

	/**
	 * The default value of the '{@link #getNetBiosNumberOfNames() <em>Net Bios Number Of Names</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getNetBiosNumberOfNames()
	 * @generated
	 * @ordered
	 */
	protected static final String NET_BIOS_NUMBER_OF_NAMES_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getNetBiosNumberOfNames() <em>Net Bios Number Of Names</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getNetBiosNumberOfNames()
	 * @generated
	 * @ordered
	 */
	protected String netBiosNumberOfNames = NET_BIOS_NUMBER_OF_NAMES_EDEFAULT;

	/**
	 * The default value of the '{@link #getNetBiosNumberOfSessions() <em>Net Bios Number Of Sessions</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getNetBiosNumberOfSessions()
	 * @generated
	 * @ordered
	 */
	protected static final String NET_BIOS_NUMBER_OF_SESSIONS_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getNetBiosNumberOfSessions() <em>Net Bios Number Of Sessions</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getNetBiosNumberOfSessions()
	 * @generated
	 * @ordered
	 */
	protected String netBiosNumberOfSessions = NET_BIOS_NUMBER_OF_SESSIONS_EDEFAULT;

	/**
	 * The default value of the '{@link #getOutboundPortMax() <em>Outbound Port Max</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getOutboundPortMax()
	 * @generated
	 * @ordered
	 */
	protected static final String OUTBOUND_PORT_MAX_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getOutboundPortMax() <em>Outbound Port Max</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getOutboundPortMax()
	 * @generated
	 * @ordered
	 */
	protected String outboundPortMax = OUTBOUND_PORT_MAX_EDEFAULT;

	/**
	 * The default value of the '{@link #getOutboundPortMin() <em>Outbound Port Min</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getOutboundPortMin()
	 * @generated
	 * @ordered
	 */
	protected static final String OUTBOUND_PORT_MIN_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getOutboundPortMin() <em>Outbound Port Min</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getOutboundPortMin()
	 * @generated
	 * @ordered
	 */
	protected String outboundPortMin = OUTBOUND_PORT_MIN_EDEFAULT;

	/**
	 * The default value of the '{@link #getPerformanceEvent() <em>Performance Event</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getPerformanceEvent()
	 * @generated
	 * @ordered
	 */
	protected static final String PERFORMANCE_EVENT_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getPerformanceEvent() <em>Performance Event</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getPerformanceEvent()
	 * @generated
	 * @ordered
	 */
	protected String performanceEvent = PERFORMANCE_EVENT_EDEFAULT;

	/**
	 * The default value of the '{@link #getPipeLineLength() <em>Pipe Line Length</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getPipeLineLength()
	 * @generated
	 * @ordered
	 */
	protected static final String PIPE_LINE_LENGTH_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getPipeLineLength() <em>Pipe Line Length</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getPipeLineLength()
	 * @generated
	 * @ordered
	 */
	protected String pipeLineLength = PIPE_LINE_LENGTH_EDEFAULT;

	/**
	 * The default value of the '{@link #getPlatform() <em>Platform</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getPlatform()
	 * @generated
	 * @ordered
	 */
	protected static final String PLATFORM_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getPlatform() <em>Platform</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getPlatform()
	 * @generated
	 * @ordered
	 */
	protected String platform = PLATFORM_EDEFAULT;

	/**
	 * The default value of the '{@link #getQueueAccounting() <em>Queue Accounting</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getQueueAccounting()
	 * @generated
	 * @ordered
	 */
	protected static final String QUEUE_ACCOUNTING_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getQueueAccounting() <em>Queue Accounting</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getQueueAccounting()
	 * @generated
	 * @ordered
	 */
	protected String queueAccounting = QUEUE_ACCOUNTING_EDEFAULT;

	/**
	 * The default value of the '{@link #getQueueManagerName() <em>Queue Manager Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getQueueManagerName()
	 * @generated
	 * @ordered
	 */
	protected static final String QUEUE_MANAGER_NAME_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getQueueManagerName() <em>Queue Manager Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getQueueManagerName()
	 * @generated
	 * @ordered
	 */
	protected String queueManagerName = QUEUE_MANAGER_NAME_EDEFAULT;

	/**
	 * The default value of the '{@link #getQueueManagerStatus() <em>Queue Manager Status</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getQueueManagerStatus()
	 * @generated
	 * @ordered
	 */
	protected static final String QUEUE_MANAGER_STATUS_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getQueueManagerStatus() <em>Queue Manager Status</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getQueueManagerStatus()
	 * @generated
	 * @ordered
	 */
	protected String queueManagerStatus = QUEUE_MANAGER_STATUS_EDEFAULT;

	/**
	 * The default value of the '{@link #getQueueMonitoring() <em>Queue Monitoring</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getQueueMonitoring()
	 * @generated
	 * @ordered
	 */
	protected static final String QUEUE_MONITORING_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getQueueMonitoring() <em>Queue Monitoring</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getQueueMonitoring()
	 * @generated
	 * @ordered
	 */
	protected String queueMonitoring = QUEUE_MONITORING_EDEFAULT;

	/**
	 * The default value of the '{@link #getQueueStatistics() <em>Queue Statistics</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getQueueStatistics()
	 * @generated
	 * @ordered
	 */
	protected static final String QUEUE_STATISTICS_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getQueueStatistics() <em>Queue Statistics</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getQueueStatistics()
	 * @generated
	 * @ordered
	 */
	protected String queueStatistics = QUEUE_STATISTICS_EDEFAULT;

	/**
	 * The default value of the '{@link #getReceiveTimeout() <em>Receive Timeout</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getReceiveTimeout()
	 * @generated
	 * @ordered
	 */
	protected static final String RECEIVE_TIMEOUT_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getReceiveTimeout() <em>Receive Timeout</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getReceiveTimeout()
	 * @generated
	 * @ordered
	 */
	protected String receiveTimeout = RECEIVE_TIMEOUT_EDEFAULT;

	/**
	 * The default value of the '{@link #getReceiveTimeoutMin() <em>Receive Timeout Min</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getReceiveTimeoutMin()
	 * @generated
	 * @ordered
	 */
	protected static final String RECEIVE_TIMEOUT_MIN_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getReceiveTimeoutMin() <em>Receive Timeout Min</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getReceiveTimeoutMin()
	 * @generated
	 * @ordered
	 */
	protected String receiveTimeoutMin = RECEIVE_TIMEOUT_MIN_EDEFAULT;

	/**
	 * The default value of the '{@link #getReceiveTimeoutType() <em>Receive Timeout Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getReceiveTimeoutType()
	 * @generated
	 * @ordered
	 */
	protected static final String RECEIVE_TIMEOUT_TYPE_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getReceiveTimeoutType() <em>Receive Timeout Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getReceiveTimeoutType()
	 * @generated
	 * @ordered
	 */
	protected String receiveTimeoutType = RECEIVE_TIMEOUT_TYPE_EDEFAULT;

	/**
	 * The default value of the '{@link #getRemoteEvent() <em>Remote Event</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getRemoteEvent()
	 * @generated
	 * @ordered
	 */
	protected static final String REMOTE_EVENT_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getRemoteEvent() <em>Remote Event</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getRemoteEvent()
	 * @generated
	 * @ordered
	 */
	protected String remoteEvent = REMOTE_EVENT_EDEFAULT;

	/**
	 * The default value of the '{@link #getRepositoryName() <em>Repository Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getRepositoryName()
	 * @generated
	 * @ordered
	 */
	protected static final String REPOSITORY_NAME_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getRepositoryName() <em>Repository Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getRepositoryName()
	 * @generated
	 * @ordered
	 */
	protected String repositoryName = REPOSITORY_NAME_EDEFAULT;

	/**
	 * The default value of the '{@link #getRepositoryNameList() <em>Repository Name List</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getRepositoryNameList()
	 * @generated
	 * @ordered
	 */
	protected static final String REPOSITORY_NAME_LIST_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getRepositoryNameList() <em>Repository Name List</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getRepositoryNameList()
	 * @generated
	 * @ordered
	 */
	protected String repositoryNameList = REPOSITORY_NAME_LIST_EDEFAULT;

	/**
	 * The default value of the '{@link #getRoutingExitConnectType() <em>Routing Exit Connect Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getRoutingExitConnectType()
	 * @generated
	 * @ordered
	 */
	protected static final String ROUTING_EXIT_CONNECT_TYPE_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getRoutingExitConnectType() <em>Routing Exit Connect Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getRoutingExitConnectType()
	 * @generated
	 * @ordered
	 */
	protected String routingExitConnectType = ROUTING_EXIT_CONNECT_TYPE_EDEFAULT;

	/**
	 * The default value of the '{@link #getRoutingExitPath() <em>Routing Exit Path</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getRoutingExitPath()
	 * @generated
	 * @ordered
	 */
	protected static final String ROUTING_EXIT_PATH_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getRoutingExitPath() <em>Routing Exit Path</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getRoutingExitPath()
	 * @generated
	 * @ordered
	 */
	protected String routingExitPath = ROUTING_EXIT_PATH_EDEFAULT;

	/**
	 * The default value of the '{@link #getSecurityPolicy() <em>Security Policy</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSecurityPolicy()
	 * @generated
	 * @ordered
	 */
	protected static final String SECURITY_POLICY_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getSecurityPolicy() <em>Security Policy</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSecurityPolicy()
	 * @generated
	 * @ordered
	 */
	protected String securityPolicy = SECURITY_POLICY_EDEFAULT;

	/**
	 * The default value of the '{@link #getServiceEntryPoints() <em>Service Entry Points</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getServiceEntryPoints()
	 * @generated
	 * @ordered
	 */
	protected static final String SERVICE_ENTRY_POINTS_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getServiceEntryPoints() <em>Service Entry Points</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getServiceEntryPoints()
	 * @generated
	 * @ordered
	 */
	protected String serviceEntryPoints = SERVICE_ENTRY_POINTS_EDEFAULT;

	/**
	 * The default value of the '{@link #getSharedQQmgrName() <em>Shared QQmgr Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSharedQQmgrName()
	 * @generated
	 * @ordered
	 */
	protected static final String SHARED_QQMGR_NAME_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getSharedQQmgrName() <em>Shared QQmgr Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSharedQQmgrName()
	 * @generated
	 * @ordered
	 */
	protected String sharedQQmgrName = SHARED_QQMGR_NAME_EDEFAULT;

	/**
	 * The default value of the '{@link #getSPXBoardNumber() <em>SPX Board Number</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSPXBoardNumber()
	 * @generated
	 * @ordered
	 */
	protected static final String SPX_BOARD_NUMBER_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getSPXBoardNumber() <em>SPX Board Number</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSPXBoardNumber()
	 * @generated
	 * @ordered
	 */
	protected String sPXBoardNumber = SPX_BOARD_NUMBER_EDEFAULT;

	/**
	 * The default value of the '{@link #getSPXKeepAlive() <em>SPX Keep Alive</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSPXKeepAlive()
	 * @generated
	 * @ordered
	 */
	protected static final String SPX_KEEP_ALIVE_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getSPXKeepAlive() <em>SPX Keep Alive</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSPXKeepAlive()
	 * @generated
	 * @ordered
	 */
	protected String sPXKeepAlive = SPX_KEEP_ALIVE_EDEFAULT;

	/**
	 * The default value of the '{@link #getSPXLibrary1() <em>SPX Library1</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSPXLibrary1()
	 * @generated
	 * @ordered
	 */
	protected static final String SPX_LIBRARY1_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getSPXLibrary1() <em>SPX Library1</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSPXLibrary1()
	 * @generated
	 * @ordered
	 */
	protected String sPXLibrary1 = SPX_LIBRARY1_EDEFAULT;

	/**
	 * The default value of the '{@link #getSPXLibrary2() <em>SPX Library2</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSPXLibrary2()
	 * @generated
	 * @ordered
	 */
	protected static final String SPX_LIBRARY2_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getSPXLibrary2() <em>SPX Library2</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSPXLibrary2()
	 * @generated
	 * @ordered
	 */
	protected String sPXLibrary2 = SPX_LIBRARY2_EDEFAULT;

	/**
	 * The default value of the '{@link #getSPXSocket() <em>SPX Socket</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSPXSocket()
	 * @generated
	 * @ordered
	 */
	protected static final String SPX_SOCKET_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getSPXSocket() <em>SPX Socket</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSPXSocket()
	 * @generated
	 * @ordered
	 */
	protected String sPXSocket = SPX_SOCKET_EDEFAULT;

	/**
	 * The default value of the '{@link #getSSLCRLNameList() <em>SSLCRL Name List</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSSLCRLNameList()
	 * @generated
	 * @ordered
	 */
	protected static final String SSLCRL_NAME_LIST_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getSSLCRLNameList() <em>SSLCRL Name List</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSSLCRLNameList()
	 * @generated
	 * @ordered
	 */
	protected String sSLCRLNameList = SSLCRL_NAME_LIST_EDEFAULT;

	/**
	 * The default value of the '{@link #getSSLCrytoHardware() <em>SSL Cryto Hardware</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSSLCrytoHardware()
	 * @generated
	 * @ordered
	 */
	protected static final String SSL_CRYTO_HARDWARE_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getSSLCrytoHardware() <em>SSL Cryto Hardware</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSSLCrytoHardware()
	 * @generated
	 * @ordered
	 */
	protected String sSLCrytoHardware = SSL_CRYTO_HARDWARE_EDEFAULT;

	/**
	 * The default value of the '{@link #getSSLEvent() <em>SSL Event</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSSLEvent()
	 * @generated
	 * @ordered
	 */
	protected static final String SSL_EVENT_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getSSLEvent() <em>SSL Event</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSSLEvent()
	 * @generated
	 * @ordered
	 */
	protected String sSLEvent = SSL_EVENT_EDEFAULT;

	/**
	 * The default value of the '{@link #getSSLFips() <em>SSL Fips</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSSLFips()
	 * @generated
	 * @ordered
	 */
	protected static final String SSL_FIPS_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getSSLFips() <em>SSL Fips</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSSLFips()
	 * @generated
	 * @ordered
	 */
	protected String sSLFips = SSL_FIPS_EDEFAULT;

	/**
	 * The default value of the '{@link #getSSLKeyRepository() <em>SSL Key Repository</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSSLKeyRepository()
	 * @generated
	 * @ordered
	 */
	protected static final String SSL_KEY_REPOSITORY_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getSSLKeyRepository() <em>SSL Key Repository</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSSLKeyRepository()
	 * @generated
	 * @ordered
	 */
	protected String sSLKeyRepository = SSL_KEY_REPOSITORY_EDEFAULT;

	/**
	 * The default value of the '{@link #getSSLKeyResetCount() <em>SSL Key Reset Count</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSSLKeyResetCount()
	 * @generated
	 * @ordered
	 */
	protected static final String SSL_KEY_RESET_COUNT_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getSSLKeyResetCount() <em>SSL Key Reset Count</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSSLKeyResetCount()
	 * @generated
	 * @ordered
	 */
	protected String sSLKeyResetCount = SSL_KEY_RESET_COUNT_EDEFAULT;

	/**
	 * The default value of the '{@link #getSSLTasks() <em>SSL Tasks</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSSLTasks()
	 * @generated
	 * @ordered
	 */
	protected static final String SSL_TASKS_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getSSLTasks() <em>SSL Tasks</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSSLTasks()
	 * @generated
	 * @ordered
	 */
	protected String sSLTasks = SSL_TASKS_EDEFAULT;

	/**
	 * The default value of the '{@link #getStartStopEvent() <em>Start Stop Event</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getStartStopEvent()
	 * @generated
	 * @ordered
	 */
	protected static final String START_STOP_EVENT_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getStartStopEvent() <em>Start Stop Event</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getStartStopEvent()
	 * @generated
	 * @ordered
	 */
	protected String startStopEvent = START_STOP_EVENT_EDEFAULT;

	/**
	 * The default value of the '{@link #getStatisticsInterval() <em>Statistics Interval</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getStatisticsInterval()
	 * @generated
	 * @ordered
	 */
	protected static final String STATISTICS_INTERVAL_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getStatisticsInterval() <em>Statistics Interval</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getStatisticsInterval()
	 * @generated
	 * @ordered
	 */
	protected String statisticsInterval = STATISTICS_INTERVAL_EDEFAULT;

	/**
	 * The default value of the '{@link #getSuppresedMessages() <em>Suppresed Messages</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSuppresedMessages()
	 * @generated
	 * @ordered
	 */
	protected static final String SUPPRESED_MESSAGES_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getSuppresedMessages() <em>Suppresed Messages</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSuppresedMessages()
	 * @generated
	 * @ordered
	 */
	protected String suppresedMessages = SUPPRESED_MESSAGES_EDEFAULT;

	/**
	 * The default value of the '{@link #getSuppressedMessageInterval() <em>Suppressed Message Interval</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSuppressedMessageInterval()
	 * @generated
	 * @ordered
	 */
	protected static final String SUPPRESSED_MESSAGE_INTERVAL_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getSuppressedMessageInterval() <em>Suppressed Message Interval</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSuppressedMessageInterval()
	 * @generated
	 * @ordered
	 */
	protected String suppressedMessageInterval = SUPPRESSED_MESSAGE_INTERVAL_EDEFAULT;

	/**
	 * The default value of the '{@link #getTCPKeepAlive() <em>TCP Keep Alive</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTCPKeepAlive()
	 * @generated
	 * @ordered
	 */
	protected static final String TCP_KEEP_ALIVE_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getTCPKeepAlive() <em>TCP Keep Alive</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTCPKeepAlive()
	 * @generated
	 * @ordered
	 */
	protected String tCPKeepAlive = TCP_KEEP_ALIVE_EDEFAULT;

	/**
	 * The default value of the '{@link #getTCPLibrary1() <em>TCP Library1</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTCPLibrary1()
	 * @generated
	 * @ordered
	 */
	protected static final String TCP_LIBRARY1_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getTCPLibrary1() <em>TCP Library1</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTCPLibrary1()
	 * @generated
	 * @ordered
	 */
	protected String tCPLibrary1 = TCP_LIBRARY1_EDEFAULT;

	/**
	 * The default value of the '{@link #getTCPLibrary2() <em>TCP Library2</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTCPLibrary2()
	 * @generated
	 * @ordered
	 */
	protected static final String TCP_LIBRARY2_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getTCPLibrary2() <em>TCP Library2</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTCPLibrary2()
	 * @generated
	 * @ordered
	 */
	protected String tCPLibrary2 = TCP_LIBRARY2_EDEFAULT;

	/**
	 * The default value of the '{@link #getTCPListenerBacklog() <em>TCP Listener Backlog</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTCPListenerBacklog()
	 * @generated
	 * @ordered
	 */
	protected static final String TCP_LISTENER_BACKLOG_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getTCPListenerBacklog() <em>TCP Listener Backlog</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTCPListenerBacklog()
	 * @generated
	 * @ordered
	 */
	protected String tCPListenerBacklog = TCP_LISTENER_BACKLOG_EDEFAULT;

	/**
	 * The default value of the '{@link #getTCPName() <em>TCP Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTCPName()
	 * @generated
	 * @ordered
	 */
	protected static final String TCP_NAME_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getTCPName() <em>TCP Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTCPName()
	 * @generated
	 * @ordered
	 */
	protected String tCPName = TCP_NAME_EDEFAULT;

	/**
	 * The default value of the '{@link #getTCPPort() <em>TCP Port</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTCPPort()
	 * @generated
	 * @ordered
	 */
	protected static final String TCP_PORT_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getTCPPort() <em>TCP Port</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTCPPort()
	 * @generated
	 * @ordered
	 */
	protected String tCPPort = TCP_PORT_EDEFAULT;

	/**
	 * The default value of the '{@link #getTCPStackType() <em>TCP Stack Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTCPStackType()
	 * @generated
	 * @ordered
	 */
	protected static final String TCP_STACK_TYPE_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getTCPStackType() <em>TCP Stack Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTCPStackType()
	 * @generated
	 * @ordered
	 */
	protected String tCPStackType = TCP_STACK_TYPE_EDEFAULT;

	/**
	 * The default value of the '{@link #getTraceRouteRecording() <em>Trace Route Recording</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTraceRouteRecording()
	 * @generated
	 * @ordered
	 */
	protected static final String TRACE_ROUTE_RECORDING_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getTraceRouteRecording() <em>Trace Route Recording</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTraceRouteRecording()
	 * @generated
	 * @ordered
	 */
	protected String traceRouteRecording = TRACE_ROUTE_RECORDING_EDEFAULT;

	/**
	 * The default value of the '{@link #getTriggerInterval() <em>Trigger Interval</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTriggerInterval()
	 * @generated
	 * @ordered
	 */
	protected static final String TRIGGER_INTERVAL_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getTriggerInterval() <em>Trigger Interval</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTriggerInterval()
	 * @generated
	 * @ordered
	 */
	protected String triggerInterval = TRIGGER_INTERVAL_EDEFAULT;

	/**
	 * The default value of the '{@link #getWhatIf() <em>What If</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getWhatIf()
	 * @generated
	 * @ordered
	 */
	protected static final String WHAT_IF_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getWhatIf() <em>What If</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getWhatIf()
	 * @generated
	 * @ordered
	 */
	protected String whatIf = WHAT_IF_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected MQQueueManagerImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected EClass eStaticClass() {
		return MqPackage.Literals.MQ_QUEUE_MANAGER;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getAccountingConnectionOverride() {
		return accountingConnectionOverride;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setAccountingConnectionOverride(String newAccountingConnectionOverride) {
		String oldAccountingConnectionOverride = accountingConnectionOverride;
		accountingConnectionOverride = newAccountingConnectionOverride;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, MqPackage.MQ_QUEUE_MANAGER__ACCOUNTING_CONNECTION_OVERRIDE, oldAccountingConnectionOverride, accountingConnectionOverride));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getAccountingInterval() {
		return accountingInterval;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setAccountingInterval(String newAccountingInterval) {
		String oldAccountingInterval = accountingInterval;
		accountingInterval = newAccountingInterval;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, MqPackage.MQ_QUEUE_MANAGER__ACCOUNTING_INTERVAL, oldAccountingInterval, accountingInterval));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getActivityRecording() {
		return activityRecording;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setActivityRecording(String newActivityRecording) {
		String oldActivityRecording = activityRecording;
		activityRecording = newActivityRecording;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, MqPackage.MQ_QUEUE_MANAGER__ACTIVITY_RECORDING, oldActivityRecording, activityRecording));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getAdoptNewMCA() {
		return adoptNewMCA;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setAdoptNewMCA(String newAdoptNewMCA) {
		String oldAdoptNewMCA = adoptNewMCA;
		adoptNewMCA = newAdoptNewMCA;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, MqPackage.MQ_QUEUE_MANAGER__ADOPT_NEW_MCA, oldAdoptNewMCA, adoptNewMCA));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getAdoptNewMCACheck() {
		return adoptNewMCACheck;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setAdoptNewMCACheck(String newAdoptNewMCACheck) {
		String oldAdoptNewMCACheck = adoptNewMCACheck;
		adoptNewMCACheck = newAdoptNewMCACheck;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, MqPackage.MQ_QUEUE_MANAGER__ADOPT_NEW_MCA_CHECK, oldAdoptNewMCACheck, adoptNewMCACheck));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getAdoptNewMCAType() {
		return adoptNewMCAType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setAdoptNewMCAType(String newAdoptNewMCAType) {
		String oldAdoptNewMCAType = adoptNewMCAType;
		adoptNewMCAType = newAdoptNewMCAType;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, MqPackage.MQ_QUEUE_MANAGER__ADOPT_NEW_MCA_TYPE, oldAdoptNewMCAType, adoptNewMCAType));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getAuthorityEvent() {
		return authorityEvent;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setAuthorityEvent(String newAuthorityEvent) {
		String oldAuthorityEvent = authorityEvent;
		authorityEvent = newAuthorityEvent;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, MqPackage.MQ_QUEUE_MANAGER__AUTHORITY_EVENT, oldAuthorityEvent, authorityEvent));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getAutomatic() {
		return automatic;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setAutomatic(String newAutomatic) {
		String oldAutomatic = automatic;
		automatic = newAutomatic;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, MqPackage.MQ_QUEUE_MANAGER__AUTOMATIC, oldAutomatic, automatic));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getBridgeEvent() {
		return bridgeEvent;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setBridgeEvent(String newBridgeEvent) {
		String oldBridgeEvent = bridgeEvent;
		bridgeEvent = newBridgeEvent;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, MqPackage.MQ_QUEUE_MANAGER__BRIDGE_EVENT, oldBridgeEvent, bridgeEvent));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getBrokerMessageRetryCount() {
		return brokerMessageRetryCount;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setBrokerMessageRetryCount(String newBrokerMessageRetryCount) {
		String oldBrokerMessageRetryCount = brokerMessageRetryCount;
		brokerMessageRetryCount = newBrokerMessageRetryCount;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, MqPackage.MQ_QUEUE_MANAGER__BROKER_MESSAGE_RETRY_COUNT, oldBrokerMessageRetryCount, brokerMessageRetryCount));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getBrokerOpenCacheExpiry() {
		return brokerOpenCacheExpiry;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setBrokerOpenCacheExpiry(String newBrokerOpenCacheExpiry) {
		String oldBrokerOpenCacheExpiry = brokerOpenCacheExpiry;
		brokerOpenCacheExpiry = newBrokerOpenCacheExpiry;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, MqPackage.MQ_QUEUE_MANAGER__BROKER_OPEN_CACHE_EXPIRY, oldBrokerOpenCacheExpiry, brokerOpenCacheExpiry));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getBrokerOpenCacheSize() {
		return brokerOpenCacheSize;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setBrokerOpenCacheSize(String newBrokerOpenCacheSize) {
		String oldBrokerOpenCacheSize = brokerOpenCacheSize;
		brokerOpenCacheSize = newBrokerOpenCacheSize;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, MqPackage.MQ_QUEUE_MANAGER__BROKER_OPEN_CACHE_SIZE, oldBrokerOpenCacheSize, brokerOpenCacheSize));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getBrokerPublicBatchInterval() {
		return brokerPublicBatchInterval;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setBrokerPublicBatchInterval(String newBrokerPublicBatchInterval) {
		String oldBrokerPublicBatchInterval = brokerPublicBatchInterval;
		brokerPublicBatchInterval = newBrokerPublicBatchInterval;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, MqPackage.MQ_QUEUE_MANAGER__BROKER_PUBLIC_BATCH_INTERVAL, oldBrokerPublicBatchInterval, brokerPublicBatchInterval));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getBrokerPublishBatchSize() {
		return brokerPublishBatchSize;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setBrokerPublishBatchSize(String newBrokerPublishBatchSize) {
		String oldBrokerPublishBatchSize = brokerPublishBatchSize;
		brokerPublishBatchSize = newBrokerPublishBatchSize;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, MqPackage.MQ_QUEUE_MANAGER__BROKER_PUBLISH_BATCH_SIZE, oldBrokerPublishBatchSize, brokerPublishBatchSize));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getBrokerStreamsPerProcess() {
		return brokerStreamsPerProcess;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setBrokerStreamsPerProcess(String newBrokerStreamsPerProcess) {
		String oldBrokerStreamsPerProcess = brokerStreamsPerProcess;
		brokerStreamsPerProcess = newBrokerStreamsPerProcess;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, MqPackage.MQ_QUEUE_MANAGER__BROKER_STREAMS_PER_PROCESS, oldBrokerStreamsPerProcess, brokerStreamsPerProcess));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getChannelAutoDefinition() {
		return channelAutoDefinition;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setChannelAutoDefinition(String newChannelAutoDefinition) {
		String oldChannelAutoDefinition = channelAutoDefinition;
		channelAutoDefinition = newChannelAutoDefinition;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, MqPackage.MQ_QUEUE_MANAGER__CHANNEL_AUTO_DEFINITION, oldChannelAutoDefinition, channelAutoDefinition));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getChannelAutoDefinitionEvent() {
		return channelAutoDefinitionEvent;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setChannelAutoDefinitionEvent(String newChannelAutoDefinitionEvent) {
		String oldChannelAutoDefinitionEvent = channelAutoDefinitionEvent;
		channelAutoDefinitionEvent = newChannelAutoDefinitionEvent;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, MqPackage.MQ_QUEUE_MANAGER__CHANNEL_AUTO_DEFINITION_EVENT, oldChannelAutoDefinitionEvent, channelAutoDefinitionEvent));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getChannelEvent() {
		return channelEvent;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setChannelEvent(String newChannelEvent) {
		String oldChannelEvent = channelEvent;
		channelEvent = newChannelEvent;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, MqPackage.MQ_QUEUE_MANAGER__CHANNEL_EVENT, oldChannelEvent, channelEvent));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getChannelInitiatorAdapters() {
		return channelInitiatorAdapters;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setChannelInitiatorAdapters(String newChannelInitiatorAdapters) {
		String oldChannelInitiatorAdapters = channelInitiatorAdapters;
		channelInitiatorAdapters = newChannelInitiatorAdapters;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, MqPackage.MQ_QUEUE_MANAGER__CHANNEL_INITIATOR_ADAPTERS, oldChannelInitiatorAdapters, channelInitiatorAdapters));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getChannelInitiatorControl() {
		return channelInitiatorControl;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setChannelInitiatorControl(String newChannelInitiatorControl) {
		String oldChannelInitiatorControl = channelInitiatorControl;
		channelInitiatorControl = newChannelInitiatorControl;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, MqPackage.MQ_QUEUE_MANAGER__CHANNEL_INITIATOR_CONTROL, oldChannelInitiatorControl, channelInitiatorControl));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getChannelInitiatorDispatchers() {
		return channelInitiatorDispatchers;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setChannelInitiatorDispatchers(String newChannelInitiatorDispatchers) {
		String oldChannelInitiatorDispatchers = channelInitiatorDispatchers;
		channelInitiatorDispatchers = newChannelInitiatorDispatchers;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, MqPackage.MQ_QUEUE_MANAGER__CHANNEL_INITIATOR_DISPATCHERS, oldChannelInitiatorDispatchers, channelInitiatorDispatchers));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getChannelInitiatorTraceAutoStart() {
		return channelInitiatorTraceAutoStart;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setChannelInitiatorTraceAutoStart(String newChannelInitiatorTraceAutoStart) {
		String oldChannelInitiatorTraceAutoStart = channelInitiatorTraceAutoStart;
		channelInitiatorTraceAutoStart = newChannelInitiatorTraceAutoStart;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, MqPackage.MQ_QUEUE_MANAGER__CHANNEL_INITIATOR_TRACE_AUTO_START, oldChannelInitiatorTraceAutoStart, channelInitiatorTraceAutoStart));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getChannelInitiatorTraceTableSize() {
		return channelInitiatorTraceTableSize;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setChannelInitiatorTraceTableSize(String newChannelInitiatorTraceTableSize) {
		String oldChannelInitiatorTraceTableSize = channelInitiatorTraceTableSize;
		channelInitiatorTraceTableSize = newChannelInitiatorTraceTableSize;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, MqPackage.MQ_QUEUE_MANAGER__CHANNEL_INITIATOR_TRACE_TABLE_SIZE, oldChannelInitiatorTraceTableSize, channelInitiatorTraceTableSize));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getChannelMonitoring() {
		return channelMonitoring;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setChannelMonitoring(String newChannelMonitoring) {
		String oldChannelMonitoring = channelMonitoring;
		channelMonitoring = newChannelMonitoring;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, MqPackage.MQ_QUEUE_MANAGER__CHANNEL_MONITORING, oldChannelMonitoring, channelMonitoring));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getChannelStatistics() {
		return channelStatistics;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setChannelStatistics(String newChannelStatistics) {
		String oldChannelStatistics = channelStatistics;
		channelStatistics = newChannelStatistics;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, MqPackage.MQ_QUEUE_MANAGER__CHANNEL_STATISTICS, oldChannelStatistics, channelStatistics));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getCheckpointActiveCount() {
		return checkpointActiveCount;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setCheckpointActiveCount(String newCheckpointActiveCount) {
		String oldCheckpointActiveCount = checkpointActiveCount;
		checkpointActiveCount = newCheckpointActiveCount;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, MqPackage.MQ_QUEUE_MANAGER__CHECKPOINT_ACTIVE_COUNT, oldCheckpointActiveCount, checkpointActiveCount));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getCheckpointMessageSize() {
		return checkpointMessageSize;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setCheckpointMessageSize(String newCheckpointMessageSize) {
		String oldCheckpointMessageSize = checkpointMessageSize;
		checkpointMessageSize = newCheckpointMessageSize;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, MqPackage.MQ_QUEUE_MANAGER__CHECKPOINT_MESSAGE_SIZE, oldCheckpointMessageSize, checkpointMessageSize));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getCheckpointRestartCount() {
		return checkpointRestartCount;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setCheckpointRestartCount(String newCheckpointRestartCount) {
		String oldCheckpointRestartCount = checkpointRestartCount;
		checkpointRestartCount = newCheckpointRestartCount;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, MqPackage.MQ_QUEUE_MANAGER__CHECKPOINT_RESTART_COUNT, oldCheckpointRestartCount, checkpointRestartCount));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getClusterSenderMonitoring() {
		return clusterSenderMonitoring;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setClusterSenderMonitoring(String newClusterSenderMonitoring) {
		String oldClusterSenderMonitoring = clusterSenderMonitoring;
		clusterSenderMonitoring = newClusterSenderMonitoring;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, MqPackage.MQ_QUEUE_MANAGER__CLUSTER_SENDER_MONITORING, oldClusterSenderMonitoring, clusterSenderMonitoring));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getClusterSenderStatistics() {
		return clusterSenderStatistics;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setClusterSenderStatistics(String newClusterSenderStatistics) {
		String oldClusterSenderStatistics = clusterSenderStatistics;
		clusterSenderStatistics = newClusterSenderStatistics;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, MqPackage.MQ_QUEUE_MANAGER__CLUSTER_SENDER_STATISTICS, oldClusterSenderStatistics, clusterSenderStatistics));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getClusterWorkLoadData() {
		return clusterWorkLoadData;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setClusterWorkLoadData(String newClusterWorkLoadData) {
		String oldClusterWorkLoadData = clusterWorkLoadData;
		clusterWorkLoadData = newClusterWorkLoadData;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, MqPackage.MQ_QUEUE_MANAGER__CLUSTER_WORK_LOAD_DATA, oldClusterWorkLoadData, clusterWorkLoadData));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getClusterWorkLoadExit() {
		return clusterWorkLoadExit;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setClusterWorkLoadExit(String newClusterWorkLoadExit) {
		String oldClusterWorkLoadExit = clusterWorkLoadExit;
		clusterWorkLoadExit = newClusterWorkLoadExit;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, MqPackage.MQ_QUEUE_MANAGER__CLUSTER_WORK_LOAD_EXIT, oldClusterWorkLoadExit, clusterWorkLoadExit));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getClusterWorkLoadLength() {
		return clusterWorkLoadLength;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setClusterWorkLoadLength(String newClusterWorkLoadLength) {
		String oldClusterWorkLoadLength = clusterWorkLoadLength;
		clusterWorkLoadLength = newClusterWorkLoadLength;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, MqPackage.MQ_QUEUE_MANAGER__CLUSTER_WORK_LOAD_LENGTH, oldClusterWorkLoadLength, clusterWorkLoadLength));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getClusterWorkloadUseQ() {
		return clusterWorkloadUseQ;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setClusterWorkloadUseQ(String newClusterWorkloadUseQ) {
		String oldClusterWorkloadUseQ = clusterWorkloadUseQ;
		clusterWorkloadUseQ = newClusterWorkloadUseQ;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, MqPackage.MQ_QUEUE_MANAGER__CLUSTER_WORKLOAD_USE_Q, oldClusterWorkloadUseQ, clusterWorkloadUseQ));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getCodedCharSetId() {
		return codedCharSetId;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setCodedCharSetId(String newCodedCharSetId) {
		String oldCodedCharSetId = codedCharSetId;
		codedCharSetId = newCodedCharSetId;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, MqPackage.MQ_QUEUE_MANAGER__CODED_CHAR_SET_ID, oldCodedCharSetId, codedCharSetId));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getCommandEvent() {
		return commandEvent;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setCommandEvent(String newCommandEvent) {
		String oldCommandEvent = commandEvent;
		commandEvent = newCommandEvent;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, MqPackage.MQ_QUEUE_MANAGER__COMMAND_EVENT, oldCommandEvent, commandEvent));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getCommandLevel() {
		return commandLevel;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setCommandLevel(String newCommandLevel) {
		String oldCommandLevel = commandLevel;
		commandLevel = newCommandLevel;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, MqPackage.MQ_QUEUE_MANAGER__COMMAND_LEVEL, oldCommandLevel, commandLevel));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getCommandScope() {
		return commandScope;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setCommandScope(String newCommandScope) {
		String oldCommandScope = commandScope;
		commandScope = newCommandScope;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, MqPackage.MQ_QUEUE_MANAGER__COMMAND_SCOPE, oldCommandScope, commandScope));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getCommandServerControl() {
		return commandServerControl;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setCommandServerControl(String newCommandServerControl) {
		String oldCommandServerControl = commandServerControl;
		commandServerControl = newCommandServerControl;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, MqPackage.MQ_QUEUE_MANAGER__COMMAND_SERVER_CONTROL, oldCommandServerControl, commandServerControl));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getConfigurationEvent() {
		return configurationEvent;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setConfigurationEvent(String newConfigurationEvent) {
		String oldConfigurationEvent = configurationEvent;
		configurationEvent = newConfigurationEvent;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, MqPackage.MQ_QUEUE_MANAGER__CONFIGURATION_EVENT, oldConfigurationEvent, configurationEvent));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getConfirm() {
		return confirm;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setConfirm(String newConfirm) {
		String oldConfirm = confirm;
		confirm = newConfirm;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, MqPackage.MQ_QUEUE_MANAGER__CONFIRM, oldConfirm, confirm));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getDeadLetterQueue() {
		return deadLetterQueue;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setDeadLetterQueue(String newDeadLetterQueue) {
		String oldDeadLetterQueue = deadLetterQueue;
		deadLetterQueue = newDeadLetterQueue;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, MqPackage.MQ_QUEUE_MANAGER__DEAD_LETTER_QUEUE, oldDeadLetterQueue, deadLetterQueue));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getDefaultBindType() {
		return defaultBindType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setDefaultBindType(String newDefaultBindType) {
		String oldDefaultBindType = defaultBindType;
		defaultBindType = newDefaultBindType;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, MqPackage.MQ_QUEUE_MANAGER__DEFAULT_BIND_TYPE, oldDefaultBindType, defaultBindType));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getDefaultTransmissionQueue() {
		return defaultTransmissionQueue;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setDefaultTransmissionQueue(String newDefaultTransmissionQueue) {
		String oldDefaultTransmissionQueue = defaultTransmissionQueue;
		defaultTransmissionQueue = newDefaultTransmissionQueue;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, MqPackage.MQ_QUEUE_MANAGER__DEFAULT_TRANSMISSION_QUEUE, oldDefaultTransmissionQueue, defaultTransmissionQueue));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getDescription1() {
		return description1;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setDescription1(String newDescription1) {
		String oldDescription1 = description1;
		description1 = newDescription1;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, MqPackage.MQ_QUEUE_MANAGER__DESCRIPTION1, oldDescription1, description1));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getDNSGroup() {
		return dNSGroup;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setDNSGroup(String newDNSGroup) {
		String oldDNSGroup = dNSGroup;
		dNSGroup = newDNSGroup;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, MqPackage.MQ_QUEUE_MANAGER__DNS_GROUP, oldDNSGroup, dNSGroup));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getDNSWLM() {
		return dNSWLM;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setDNSWLM(String newDNSWLM) {
		String oldDNSWLM = dNSWLM;
		dNSWLM = newDNSWLM;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, MqPackage.MQ_QUEUE_MANAGER__DNSWLM, oldDNSWLM, dNSWLM));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getErrorLogSize() {
		return errorLogSize;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setErrorLogSize(String newErrorLogSize) {
		String oldErrorLogSize = errorLogSize;
		errorLogSize = newErrorLogSize;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, MqPackage.MQ_QUEUE_MANAGER__ERROR_LOG_SIZE, oldErrorLogSize, errorLogSize));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getExcludedMessages() {
		return excludedMessages;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setExcludedMessages(String newExcludedMessages) {
		String oldExcludedMessages = excludedMessages;
		excludedMessages = newExcludedMessages;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, MqPackage.MQ_QUEUE_MANAGER__EXCLUDED_MESSAGES, oldExcludedMessages, excludedMessages));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getExitsDefaultPath() {
		return exitsDefaultPath;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setExitsDefaultPath(String newExitsDefaultPath) {
		String oldExitsDefaultPath = exitsDefaultPath;
		exitsDefaultPath = newExitsDefaultPath;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, MqPackage.MQ_QUEUE_MANAGER__EXITS_DEFAULT_PATH, oldExitsDefaultPath, exitsDefaultPath));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getExpiryInterval() {
		return expiryInterval;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setExpiryInterval(String newExpiryInterval) {
		String oldExpiryInterval = expiryInterval;
		expiryInterval = newExpiryInterval;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, MqPackage.MQ_QUEUE_MANAGER__EXPIRY_INTERVAL, oldExpiryInterval, expiryInterval));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getIGQPutAuthority() {
		return iGQPutAuthority;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setIGQPutAuthority(String newIGQPutAuthority) {
		String oldIGQPutAuthority = iGQPutAuthority;
		iGQPutAuthority = newIGQPutAuthority;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, MqPackage.MQ_QUEUE_MANAGER__IGQ_PUT_AUTHORITY, oldIGQPutAuthority, iGQPutAuthority));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getIGQUserId() {
		return iGQUserId;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setIGQUserId(String newIGQUserId) {
		String oldIGQUserId = iGQUserId;
		iGQUserId = newIGQUserId;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, MqPackage.MQ_QUEUE_MANAGER__IGQ_USER_ID, oldIGQUserId, iGQUserId));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getInhibitEvent() {
		return inhibitEvent;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setInhibitEvent(String newInhibitEvent) {
		String oldInhibitEvent = inhibitEvent;
		inhibitEvent = newInhibitEvent;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, MqPackage.MQ_QUEUE_MANAGER__INHIBIT_EVENT, oldInhibitEvent, inhibitEvent));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getInstallableServiceName() {
		return installableServiceName;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setInstallableServiceName(String newInstallableServiceName) {
		String oldInstallableServiceName = installableServiceName;
		installableServiceName = newInstallableServiceName;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, MqPackage.MQ_QUEUE_MANAGER__INSTALLABLE_SERVICE_NAME, oldInstallableServiceName, installableServiceName));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getIntraGroupQueuing() {
		return intraGroupQueuing;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setIntraGroupQueuing(String newIntraGroupQueuing) {
		String oldIntraGroupQueuing = intraGroupQueuing;
		intraGroupQueuing = newIntraGroupQueuing;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, MqPackage.MQ_QUEUE_MANAGER__INTRA_GROUP_QUEUING, oldIntraGroupQueuing, intraGroupQueuing));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getIPAddressVersion() {
		return iPAddressVersion;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setIPAddressVersion(String newIPAddressVersion) {
		String oldIPAddressVersion = iPAddressVersion;
		iPAddressVersion = newIPAddressVersion;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, MqPackage.MQ_QUEUE_MANAGER__IP_ADDRESS_VERSION, oldIPAddressVersion, iPAddressVersion));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getListenerTimer() {
		return listenerTimer;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setListenerTimer(String newListenerTimer) {
		String oldListenerTimer = listenerTimer;
		listenerTimer = newListenerTimer;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, MqPackage.MQ_QUEUE_MANAGER__LISTENER_TIMER, oldListenerTimer, listenerTimer));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getLocalEvent() {
		return localEvent;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setLocalEvent(String newLocalEvent) {
		String oldLocalEvent = localEvent;
		localEvent = newLocalEvent;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, MqPackage.MQ_QUEUE_MANAGER__LOCAL_EVENT, oldLocalEvent, localEvent));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getLogBufferPages() {
		return logBufferPages;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setLogBufferPages(String newLogBufferPages) {
		String oldLogBufferPages = logBufferPages;
		logBufferPages = newLogBufferPages;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, MqPackage.MQ_QUEUE_MANAGER__LOG_BUFFER_PAGES, oldLogBufferPages, logBufferPages));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getLogFilePages() {
		return logFilePages;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setLogFilePages(String newLogFilePages) {
		String oldLogFilePages = logFilePages;
		logFilePages = newLogFilePages;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, MqPackage.MQ_QUEUE_MANAGER__LOG_FILE_PAGES, oldLogFilePages, logFilePages));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getLogPath() {
		return logPath;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setLogPath(String newLogPath) {
		String oldLogPath = logPath;
		logPath = newLogPath;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, MqPackage.MQ_QUEUE_MANAGER__LOG_PATH, oldLogPath, logPath));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getLogPrimaryFiles() {
		return logPrimaryFiles;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setLogPrimaryFiles(String newLogPrimaryFiles) {
		String oldLogPrimaryFiles = logPrimaryFiles;
		logPrimaryFiles = newLogPrimaryFiles;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, MqPackage.MQ_QUEUE_MANAGER__LOG_PRIMARY_FILES, oldLogPrimaryFiles, logPrimaryFiles));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getLogSecondaryFiles() {
		return logSecondaryFiles;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setLogSecondaryFiles(String newLogSecondaryFiles) {
		String oldLogSecondaryFiles = logSecondaryFiles;
		logSecondaryFiles = newLogSecondaryFiles;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, MqPackage.MQ_QUEUE_MANAGER__LOG_SECONDARY_FILES, oldLogSecondaryFiles, logSecondaryFiles));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getLogType() {
		return logType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setLogType(String newLogType) {
		String oldLogType = logType;
		logType = newLogType;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, MqPackage.MQ_QUEUE_MANAGER__LOG_TYPE, oldLogType, logType));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getLogWriteIntegrity() {
		return logWriteIntegrity;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setLogWriteIntegrity(String newLogWriteIntegrity) {
		String oldLogWriteIntegrity = logWriteIntegrity;
		logWriteIntegrity = newLogWriteIntegrity;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, MqPackage.MQ_QUEUE_MANAGER__LOG_WRITE_INTEGRITY, oldLogWriteIntegrity, logWriteIntegrity));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getLU62ARMSuffix() {
		return lU62ARMSuffix;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setLU62ARMSuffix(String newLU62ARMSuffix) {
		String oldLU62ARMSuffix = lU62ARMSuffix;
		lU62ARMSuffix = newLU62ARMSuffix;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, MqPackage.MQ_QUEUE_MANAGER__LU62ARM_SUFFIX, oldLU62ARMSuffix, lU62ARMSuffix));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getLU62Channels() {
		return lU62Channels;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setLU62Channels(String newLU62Channels) {
		String oldLU62Channels = lU62Channels;
		lU62Channels = newLU62Channels;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, MqPackage.MQ_QUEUE_MANAGER__LU62_CHANNELS, oldLU62Channels, lU62Channels));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getLUGroupName() {
		return lUGroupName;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setLUGroupName(String newLUGroupName) {
		String oldLUGroupName = lUGroupName;
		lUGroupName = newLUGroupName;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, MqPackage.MQ_QUEUE_MANAGER__LU_GROUP_NAME, oldLUGroupName, lUGroupName));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getLULibrary1() {
		return lULibrary1;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setLULibrary1(String newLULibrary1) {
		String oldLULibrary1 = lULibrary1;
		lULibrary1 = newLULibrary1;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, MqPackage.MQ_QUEUE_MANAGER__LU_LIBRARY1, oldLULibrary1, lULibrary1));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getLULibrary2() {
		return lULibrary2;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setLULibrary2(String newLULibrary2) {
		String oldLULibrary2 = lULibrary2;
		lULibrary2 = newLULibrary2;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, MqPackage.MQ_QUEUE_MANAGER__LU_LIBRARY2, oldLULibrary2, lULibrary2));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getLULocalLU() {
		return lULocalLU;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setLULocalLU(String newLULocalLU) {
		String oldLULocalLU = lULocalLU;
		lULocalLU = newLULocalLU;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, MqPackage.MQ_QUEUE_MANAGER__LU_LOCAL_LU, oldLULocalLU, lULocalLU));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getLUName() {
		return lUName;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setLUName(String newLUName) {
		String oldLUName = lUName;
		lUName = newLUName;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, MqPackage.MQ_QUEUE_MANAGER__LU_NAME, oldLUName, lUName));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getLUTPName() {
		return lUTPName;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setLUTPName(String newLUTPName) {
		String oldLUTPName = lUTPName;
		lUTPName = newLUTPName;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, MqPackage.MQ_QUEUE_MANAGER__LUTP_NAME, oldLUTPName, lUTPName));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getMaxActiveChannels() {
		return maxActiveChannels;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setMaxActiveChannels(String newMaxActiveChannels) {
		String oldMaxActiveChannels = maxActiveChannels;
		maxActiveChannels = newMaxActiveChannels;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, MqPackage.MQ_QUEUE_MANAGER__MAX_ACTIVE_CHANNELS, oldMaxActiveChannels, maxActiveChannels));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getMaxChannels() {
		return maxChannels;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setMaxChannels(String newMaxChannels) {
		String oldMaxChannels = maxChannels;
		maxChannels = newMaxChannels;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, MqPackage.MQ_QUEUE_MANAGER__MAX_CHANNELS, oldMaxChannels, maxChannels));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getMaximumCurrentChannels() {
		return maximumCurrentChannels;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setMaximumCurrentChannels(String newMaximumCurrentChannels) {
		String oldMaximumCurrentChannels = maximumCurrentChannels;
		maximumCurrentChannels = newMaximumCurrentChannels;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, MqPackage.MQ_QUEUE_MANAGER__MAXIMUM_CURRENT_CHANNELS, oldMaximumCurrentChannels, maximumCurrentChannels));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getMaximumHandles() {
		return maximumHandles;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setMaximumHandles(String newMaximumHandles) {
		String oldMaximumHandles = maximumHandles;
		maximumHandles = newMaximumHandles;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, MqPackage.MQ_QUEUE_MANAGER__MAXIMUM_HANDLES, oldMaximumHandles, maximumHandles));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getMaximumMessageLength() {
		return maximumMessageLength;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setMaximumMessageLength(String newMaximumMessageLength) {
		String oldMaximumMessageLength = maximumMessageLength;
		maximumMessageLength = newMaximumMessageLength;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, MqPackage.MQ_QUEUE_MANAGER__MAXIMUM_MESSAGE_LENGTH, oldMaximumMessageLength, maximumMessageLength));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getMaximumTCPChannels() {
		return maximumTCPChannels;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setMaximumTCPChannels(String newMaximumTCPChannels) {
		String oldMaximumTCPChannels = maximumTCPChannels;
		maximumTCPChannels = newMaximumTCPChannels;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, MqPackage.MQ_QUEUE_MANAGER__MAXIMUM_TCP_CHANNELS, oldMaximumTCPChannels, maximumTCPChannels));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getMaximumUncommittedMessages() {
		return maximumUncommittedMessages;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setMaximumUncommittedMessages(String newMaximumUncommittedMessages) {
		String oldMaximumUncommittedMessages = maximumUncommittedMessages;
		maximumUncommittedMessages = newMaximumUncommittedMessages;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, MqPackage.MQ_QUEUE_MANAGER__MAXIMUM_UNCOMMITTED_MESSAGES, oldMaximumUncommittedMessages, maximumUncommittedMessages));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getMaxInitiators() {
		return maxInitiators;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setMaxInitiators(String newMaxInitiators) {
		String oldMaxInitiators = maxInitiators;
		maxInitiators = newMaxInitiators;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, MqPackage.MQ_QUEUE_MANAGER__MAX_INITIATORS, oldMaxInitiators, maxInitiators));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getMQIAccounting() {
		return mQIAccounting;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setMQIAccounting(String newMQIAccounting) {
		String oldMQIAccounting = mQIAccounting;
		mQIAccounting = newMQIAccounting;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, MqPackage.MQ_QUEUE_MANAGER__MQI_ACCOUNTING, oldMQIAccounting, mQIAccounting));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getMQIBindType() {
		return mQIBindType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setMQIBindType(String newMQIBindType) {
		String oldMQIBindType = mQIBindType;
		mQIBindType = newMQIBindType;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, MqPackage.MQ_QUEUE_MANAGER__MQI_BIND_TYPE, oldMQIBindType, mQIBindType));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getMQIStatistics() {
		return mQIStatistics;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setMQIStatistics(String newMQIStatistics) {
		String oldMQIStatistics = mQIStatistics;
		mQIStatistics = newMQIStatistics;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, MqPackage.MQ_QUEUE_MANAGER__MQI_STATISTICS, oldMQIStatistics, mQIStatistics));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getNetBiosAdaptorNumber() {
		return netBiosAdaptorNumber;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setNetBiosAdaptorNumber(String newNetBiosAdaptorNumber) {
		String oldNetBiosAdaptorNumber = netBiosAdaptorNumber;
		netBiosAdaptorNumber = newNetBiosAdaptorNumber;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, MqPackage.MQ_QUEUE_MANAGER__NET_BIOS_ADAPTOR_NUMBER, oldNetBiosAdaptorNumber, netBiosAdaptorNumber));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getNetBiosLibrary1() {
		return netBiosLibrary1;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setNetBiosLibrary1(String newNetBiosLibrary1) {
		String oldNetBiosLibrary1 = netBiosLibrary1;
		netBiosLibrary1 = newNetBiosLibrary1;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, MqPackage.MQ_QUEUE_MANAGER__NET_BIOS_LIBRARY1, oldNetBiosLibrary1, netBiosLibrary1));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getNetBiosLocalName() {
		return netBiosLocalName;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setNetBiosLocalName(String newNetBiosLocalName) {
		String oldNetBiosLocalName = netBiosLocalName;
		netBiosLocalName = newNetBiosLocalName;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, MqPackage.MQ_QUEUE_MANAGER__NET_BIOS_LOCAL_NAME, oldNetBiosLocalName, netBiosLocalName));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getNetBiosNumberOfCommands() {
		return netBiosNumberOfCommands;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setNetBiosNumberOfCommands(String newNetBiosNumberOfCommands) {
		String oldNetBiosNumberOfCommands = netBiosNumberOfCommands;
		netBiosNumberOfCommands = newNetBiosNumberOfCommands;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, MqPackage.MQ_QUEUE_MANAGER__NET_BIOS_NUMBER_OF_COMMANDS, oldNetBiosNumberOfCommands, netBiosNumberOfCommands));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getNetBiosNumberOfNames() {
		return netBiosNumberOfNames;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setNetBiosNumberOfNames(String newNetBiosNumberOfNames) {
		String oldNetBiosNumberOfNames = netBiosNumberOfNames;
		netBiosNumberOfNames = newNetBiosNumberOfNames;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, MqPackage.MQ_QUEUE_MANAGER__NET_BIOS_NUMBER_OF_NAMES, oldNetBiosNumberOfNames, netBiosNumberOfNames));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getNetBiosNumberOfSessions() {
		return netBiosNumberOfSessions;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setNetBiosNumberOfSessions(String newNetBiosNumberOfSessions) {
		String oldNetBiosNumberOfSessions = netBiosNumberOfSessions;
		netBiosNumberOfSessions = newNetBiosNumberOfSessions;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, MqPackage.MQ_QUEUE_MANAGER__NET_BIOS_NUMBER_OF_SESSIONS, oldNetBiosNumberOfSessions, netBiosNumberOfSessions));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getOutboundPortMax() {
		return outboundPortMax;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setOutboundPortMax(String newOutboundPortMax) {
		String oldOutboundPortMax = outboundPortMax;
		outboundPortMax = newOutboundPortMax;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, MqPackage.MQ_QUEUE_MANAGER__OUTBOUND_PORT_MAX, oldOutboundPortMax, outboundPortMax));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getOutboundPortMin() {
		return outboundPortMin;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setOutboundPortMin(String newOutboundPortMin) {
		String oldOutboundPortMin = outboundPortMin;
		outboundPortMin = newOutboundPortMin;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, MqPackage.MQ_QUEUE_MANAGER__OUTBOUND_PORT_MIN, oldOutboundPortMin, outboundPortMin));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getPerformanceEvent() {
		return performanceEvent;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setPerformanceEvent(String newPerformanceEvent) {
		String oldPerformanceEvent = performanceEvent;
		performanceEvent = newPerformanceEvent;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, MqPackage.MQ_QUEUE_MANAGER__PERFORMANCE_EVENT, oldPerformanceEvent, performanceEvent));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getPipeLineLength() {
		return pipeLineLength;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setPipeLineLength(String newPipeLineLength) {
		String oldPipeLineLength = pipeLineLength;
		pipeLineLength = newPipeLineLength;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, MqPackage.MQ_QUEUE_MANAGER__PIPE_LINE_LENGTH, oldPipeLineLength, pipeLineLength));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getPlatform() {
		return platform;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setPlatform(String newPlatform) {
		String oldPlatform = platform;
		platform = newPlatform;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, MqPackage.MQ_QUEUE_MANAGER__PLATFORM, oldPlatform, platform));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getQueueAccounting() {
		return queueAccounting;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setQueueAccounting(String newQueueAccounting) {
		String oldQueueAccounting = queueAccounting;
		queueAccounting = newQueueAccounting;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, MqPackage.MQ_QUEUE_MANAGER__QUEUE_ACCOUNTING, oldQueueAccounting, queueAccounting));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getQueueManagerName() {
		return queueManagerName;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setQueueManagerName(String newQueueManagerName) {
		String oldQueueManagerName = queueManagerName;
		queueManagerName = newQueueManagerName;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, MqPackage.MQ_QUEUE_MANAGER__QUEUE_MANAGER_NAME, oldQueueManagerName, queueManagerName));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getQueueManagerStatus() {
		return queueManagerStatus;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setQueueManagerStatus(String newQueueManagerStatus) {
		String oldQueueManagerStatus = queueManagerStatus;
		queueManagerStatus = newQueueManagerStatus;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, MqPackage.MQ_QUEUE_MANAGER__QUEUE_MANAGER_STATUS, oldQueueManagerStatus, queueManagerStatus));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getQueueMonitoring() {
		return queueMonitoring;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setQueueMonitoring(String newQueueMonitoring) {
		String oldQueueMonitoring = queueMonitoring;
		queueMonitoring = newQueueMonitoring;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, MqPackage.MQ_QUEUE_MANAGER__QUEUE_MONITORING, oldQueueMonitoring, queueMonitoring));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getQueueStatistics() {
		return queueStatistics;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setQueueStatistics(String newQueueStatistics) {
		String oldQueueStatistics = queueStatistics;
		queueStatistics = newQueueStatistics;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, MqPackage.MQ_QUEUE_MANAGER__QUEUE_STATISTICS, oldQueueStatistics, queueStatistics));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getReceiveTimeout() {
		return receiveTimeout;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setReceiveTimeout(String newReceiveTimeout) {
		String oldReceiveTimeout = receiveTimeout;
		receiveTimeout = newReceiveTimeout;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, MqPackage.MQ_QUEUE_MANAGER__RECEIVE_TIMEOUT, oldReceiveTimeout, receiveTimeout));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getReceiveTimeoutMin() {
		return receiveTimeoutMin;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setReceiveTimeoutMin(String newReceiveTimeoutMin) {
		String oldReceiveTimeoutMin = receiveTimeoutMin;
		receiveTimeoutMin = newReceiveTimeoutMin;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, MqPackage.MQ_QUEUE_MANAGER__RECEIVE_TIMEOUT_MIN, oldReceiveTimeoutMin, receiveTimeoutMin));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getReceiveTimeoutType() {
		return receiveTimeoutType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setReceiveTimeoutType(String newReceiveTimeoutType) {
		String oldReceiveTimeoutType = receiveTimeoutType;
		receiveTimeoutType = newReceiveTimeoutType;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, MqPackage.MQ_QUEUE_MANAGER__RECEIVE_TIMEOUT_TYPE, oldReceiveTimeoutType, receiveTimeoutType));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getRemoteEvent() {
		return remoteEvent;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setRemoteEvent(String newRemoteEvent) {
		String oldRemoteEvent = remoteEvent;
		remoteEvent = newRemoteEvent;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, MqPackage.MQ_QUEUE_MANAGER__REMOTE_EVENT, oldRemoteEvent, remoteEvent));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getRepositoryName() {
		return repositoryName;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setRepositoryName(String newRepositoryName) {
		String oldRepositoryName = repositoryName;
		repositoryName = newRepositoryName;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, MqPackage.MQ_QUEUE_MANAGER__REPOSITORY_NAME, oldRepositoryName, repositoryName));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getRepositoryNameList() {
		return repositoryNameList;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setRepositoryNameList(String newRepositoryNameList) {
		String oldRepositoryNameList = repositoryNameList;
		repositoryNameList = newRepositoryNameList;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, MqPackage.MQ_QUEUE_MANAGER__REPOSITORY_NAME_LIST, oldRepositoryNameList, repositoryNameList));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getRoutingExitConnectType() {
		return routingExitConnectType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setRoutingExitConnectType(String newRoutingExitConnectType) {
		String oldRoutingExitConnectType = routingExitConnectType;
		routingExitConnectType = newRoutingExitConnectType;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, MqPackage.MQ_QUEUE_MANAGER__ROUTING_EXIT_CONNECT_TYPE, oldRoutingExitConnectType, routingExitConnectType));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getRoutingExitPath() {
		return routingExitPath;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setRoutingExitPath(String newRoutingExitPath) {
		String oldRoutingExitPath = routingExitPath;
		routingExitPath = newRoutingExitPath;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, MqPackage.MQ_QUEUE_MANAGER__ROUTING_EXIT_PATH, oldRoutingExitPath, routingExitPath));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getSecurityPolicy() {
		return securityPolicy;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setSecurityPolicy(String newSecurityPolicy) {
		String oldSecurityPolicy = securityPolicy;
		securityPolicy = newSecurityPolicy;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, MqPackage.MQ_QUEUE_MANAGER__SECURITY_POLICY, oldSecurityPolicy, securityPolicy));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getServiceEntryPoints() {
		return serviceEntryPoints;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setServiceEntryPoints(String newServiceEntryPoints) {
		String oldServiceEntryPoints = serviceEntryPoints;
		serviceEntryPoints = newServiceEntryPoints;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, MqPackage.MQ_QUEUE_MANAGER__SERVICE_ENTRY_POINTS, oldServiceEntryPoints, serviceEntryPoints));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getSharedQQmgrName() {
		return sharedQQmgrName;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setSharedQQmgrName(String newSharedQQmgrName) {
		String oldSharedQQmgrName = sharedQQmgrName;
		sharedQQmgrName = newSharedQQmgrName;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, MqPackage.MQ_QUEUE_MANAGER__SHARED_QQMGR_NAME, oldSharedQQmgrName, sharedQQmgrName));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getSPXBoardNumber() {
		return sPXBoardNumber;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setSPXBoardNumber(String newSPXBoardNumber) {
		String oldSPXBoardNumber = sPXBoardNumber;
		sPXBoardNumber = newSPXBoardNumber;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, MqPackage.MQ_QUEUE_MANAGER__SPX_BOARD_NUMBER, oldSPXBoardNumber, sPXBoardNumber));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getSPXKeepAlive() {
		return sPXKeepAlive;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setSPXKeepAlive(String newSPXKeepAlive) {
		String oldSPXKeepAlive = sPXKeepAlive;
		sPXKeepAlive = newSPXKeepAlive;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, MqPackage.MQ_QUEUE_MANAGER__SPX_KEEP_ALIVE, oldSPXKeepAlive, sPXKeepAlive));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getSPXLibrary1() {
		return sPXLibrary1;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setSPXLibrary1(String newSPXLibrary1) {
		String oldSPXLibrary1 = sPXLibrary1;
		sPXLibrary1 = newSPXLibrary1;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, MqPackage.MQ_QUEUE_MANAGER__SPX_LIBRARY1, oldSPXLibrary1, sPXLibrary1));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getSPXLibrary2() {
		return sPXLibrary2;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setSPXLibrary2(String newSPXLibrary2) {
		String oldSPXLibrary2 = sPXLibrary2;
		sPXLibrary2 = newSPXLibrary2;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, MqPackage.MQ_QUEUE_MANAGER__SPX_LIBRARY2, oldSPXLibrary2, sPXLibrary2));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getSPXSocket() {
		return sPXSocket;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setSPXSocket(String newSPXSocket) {
		String oldSPXSocket = sPXSocket;
		sPXSocket = newSPXSocket;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, MqPackage.MQ_QUEUE_MANAGER__SPX_SOCKET, oldSPXSocket, sPXSocket));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getSSLCRLNameList() {
		return sSLCRLNameList;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setSSLCRLNameList(String newSSLCRLNameList) {
		String oldSSLCRLNameList = sSLCRLNameList;
		sSLCRLNameList = newSSLCRLNameList;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, MqPackage.MQ_QUEUE_MANAGER__SSLCRL_NAME_LIST, oldSSLCRLNameList, sSLCRLNameList));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getSSLCrytoHardware() {
		return sSLCrytoHardware;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setSSLCrytoHardware(String newSSLCrytoHardware) {
		String oldSSLCrytoHardware = sSLCrytoHardware;
		sSLCrytoHardware = newSSLCrytoHardware;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, MqPackage.MQ_QUEUE_MANAGER__SSL_CRYTO_HARDWARE, oldSSLCrytoHardware, sSLCrytoHardware));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getSSLEvent() {
		return sSLEvent;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setSSLEvent(String newSSLEvent) {
		String oldSSLEvent = sSLEvent;
		sSLEvent = newSSLEvent;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, MqPackage.MQ_QUEUE_MANAGER__SSL_EVENT, oldSSLEvent, sSLEvent));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getSSLFips() {
		return sSLFips;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setSSLFips(String newSSLFips) {
		String oldSSLFips = sSLFips;
		sSLFips = newSSLFips;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, MqPackage.MQ_QUEUE_MANAGER__SSL_FIPS, oldSSLFips, sSLFips));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getSSLKeyRepository() {
		return sSLKeyRepository;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setSSLKeyRepository(String newSSLKeyRepository) {
		String oldSSLKeyRepository = sSLKeyRepository;
		sSLKeyRepository = newSSLKeyRepository;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, MqPackage.MQ_QUEUE_MANAGER__SSL_KEY_REPOSITORY, oldSSLKeyRepository, sSLKeyRepository));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getSSLKeyResetCount() {
		return sSLKeyResetCount;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setSSLKeyResetCount(String newSSLKeyResetCount) {
		String oldSSLKeyResetCount = sSLKeyResetCount;
		sSLKeyResetCount = newSSLKeyResetCount;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, MqPackage.MQ_QUEUE_MANAGER__SSL_KEY_RESET_COUNT, oldSSLKeyResetCount, sSLKeyResetCount));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getSSLTasks() {
		return sSLTasks;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setSSLTasks(String newSSLTasks) {
		String oldSSLTasks = sSLTasks;
		sSLTasks = newSSLTasks;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, MqPackage.MQ_QUEUE_MANAGER__SSL_TASKS, oldSSLTasks, sSLTasks));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getStartStopEvent() {
		return startStopEvent;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setStartStopEvent(String newStartStopEvent) {
		String oldStartStopEvent = startStopEvent;
		startStopEvent = newStartStopEvent;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, MqPackage.MQ_QUEUE_MANAGER__START_STOP_EVENT, oldStartStopEvent, startStopEvent));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getStatisticsInterval() {
		return statisticsInterval;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setStatisticsInterval(String newStatisticsInterval) {
		String oldStatisticsInterval = statisticsInterval;
		statisticsInterval = newStatisticsInterval;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, MqPackage.MQ_QUEUE_MANAGER__STATISTICS_INTERVAL, oldStatisticsInterval, statisticsInterval));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getSuppresedMessages() {
		return suppresedMessages;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setSuppresedMessages(String newSuppresedMessages) {
		String oldSuppresedMessages = suppresedMessages;
		suppresedMessages = newSuppresedMessages;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, MqPackage.MQ_QUEUE_MANAGER__SUPPRESED_MESSAGES, oldSuppresedMessages, suppresedMessages));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getSuppressedMessageInterval() {
		return suppressedMessageInterval;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setSuppressedMessageInterval(String newSuppressedMessageInterval) {
		String oldSuppressedMessageInterval = suppressedMessageInterval;
		suppressedMessageInterval = newSuppressedMessageInterval;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, MqPackage.MQ_QUEUE_MANAGER__SUPPRESSED_MESSAGE_INTERVAL, oldSuppressedMessageInterval, suppressedMessageInterval));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getTCPKeepAlive() {
		return tCPKeepAlive;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setTCPKeepAlive(String newTCPKeepAlive) {
		String oldTCPKeepAlive = tCPKeepAlive;
		tCPKeepAlive = newTCPKeepAlive;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, MqPackage.MQ_QUEUE_MANAGER__TCP_KEEP_ALIVE, oldTCPKeepAlive, tCPKeepAlive));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getTCPLibrary1() {
		return tCPLibrary1;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setTCPLibrary1(String newTCPLibrary1) {
		String oldTCPLibrary1 = tCPLibrary1;
		tCPLibrary1 = newTCPLibrary1;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, MqPackage.MQ_QUEUE_MANAGER__TCP_LIBRARY1, oldTCPLibrary1, tCPLibrary1));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getTCPLibrary2() {
		return tCPLibrary2;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setTCPLibrary2(String newTCPLibrary2) {
		String oldTCPLibrary2 = tCPLibrary2;
		tCPLibrary2 = newTCPLibrary2;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, MqPackage.MQ_QUEUE_MANAGER__TCP_LIBRARY2, oldTCPLibrary2, tCPLibrary2));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getTCPListenerBacklog() {
		return tCPListenerBacklog;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setTCPListenerBacklog(String newTCPListenerBacklog) {
		String oldTCPListenerBacklog = tCPListenerBacklog;
		tCPListenerBacklog = newTCPListenerBacklog;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, MqPackage.MQ_QUEUE_MANAGER__TCP_LISTENER_BACKLOG, oldTCPListenerBacklog, tCPListenerBacklog));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getTCPName() {
		return tCPName;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setTCPName(String newTCPName) {
		String oldTCPName = tCPName;
		tCPName = newTCPName;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, MqPackage.MQ_QUEUE_MANAGER__TCP_NAME, oldTCPName, tCPName));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getTCPPort() {
		return tCPPort;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setTCPPort(String newTCPPort) {
		String oldTCPPort = tCPPort;
		tCPPort = newTCPPort;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, MqPackage.MQ_QUEUE_MANAGER__TCP_PORT, oldTCPPort, tCPPort));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getTCPStackType() {
		return tCPStackType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setTCPStackType(String newTCPStackType) {
		String oldTCPStackType = tCPStackType;
		tCPStackType = newTCPStackType;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, MqPackage.MQ_QUEUE_MANAGER__TCP_STACK_TYPE, oldTCPStackType, tCPStackType));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getTraceRouteRecording() {
		return traceRouteRecording;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setTraceRouteRecording(String newTraceRouteRecording) {
		String oldTraceRouteRecording = traceRouteRecording;
		traceRouteRecording = newTraceRouteRecording;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, MqPackage.MQ_QUEUE_MANAGER__TRACE_ROUTE_RECORDING, oldTraceRouteRecording, traceRouteRecording));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getTriggerInterval() {
		return triggerInterval;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setTriggerInterval(String newTriggerInterval) {
		String oldTriggerInterval = triggerInterval;
		triggerInterval = newTriggerInterval;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, MqPackage.MQ_QUEUE_MANAGER__TRIGGER_INTERVAL, oldTriggerInterval, triggerInterval));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getWhatIf() {
		return whatIf;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setWhatIf(String newWhatIf) {
		String oldWhatIf = whatIf;
		whatIf = newWhatIf;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, MqPackage.MQ_QUEUE_MANAGER__WHAT_IF, oldWhatIf, whatIf));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case MqPackage.MQ_QUEUE_MANAGER__ACCOUNTING_CONNECTION_OVERRIDE:
				return getAccountingConnectionOverride();
			case MqPackage.MQ_QUEUE_MANAGER__ACCOUNTING_INTERVAL:
				return getAccountingInterval();
			case MqPackage.MQ_QUEUE_MANAGER__ACTIVITY_RECORDING:
				return getActivityRecording();
			case MqPackage.MQ_QUEUE_MANAGER__ADOPT_NEW_MCA:
				return getAdoptNewMCA();
			case MqPackage.MQ_QUEUE_MANAGER__ADOPT_NEW_MCA_CHECK:
				return getAdoptNewMCACheck();
			case MqPackage.MQ_QUEUE_MANAGER__ADOPT_NEW_MCA_TYPE:
				return getAdoptNewMCAType();
			case MqPackage.MQ_QUEUE_MANAGER__AUTHORITY_EVENT:
				return getAuthorityEvent();
			case MqPackage.MQ_QUEUE_MANAGER__AUTOMATIC:
				return getAutomatic();
			case MqPackage.MQ_QUEUE_MANAGER__BRIDGE_EVENT:
				return getBridgeEvent();
			case MqPackage.MQ_QUEUE_MANAGER__BROKER_MESSAGE_RETRY_COUNT:
				return getBrokerMessageRetryCount();
			case MqPackage.MQ_QUEUE_MANAGER__BROKER_OPEN_CACHE_EXPIRY:
				return getBrokerOpenCacheExpiry();
			case MqPackage.MQ_QUEUE_MANAGER__BROKER_OPEN_CACHE_SIZE:
				return getBrokerOpenCacheSize();
			case MqPackage.MQ_QUEUE_MANAGER__BROKER_PUBLIC_BATCH_INTERVAL:
				return getBrokerPublicBatchInterval();
			case MqPackage.MQ_QUEUE_MANAGER__BROKER_PUBLISH_BATCH_SIZE:
				return getBrokerPublishBatchSize();
			case MqPackage.MQ_QUEUE_MANAGER__BROKER_STREAMS_PER_PROCESS:
				return getBrokerStreamsPerProcess();
			case MqPackage.MQ_QUEUE_MANAGER__CHANNEL_AUTO_DEFINITION:
				return getChannelAutoDefinition();
			case MqPackage.MQ_QUEUE_MANAGER__CHANNEL_AUTO_DEFINITION_EVENT:
				return getChannelAutoDefinitionEvent();
			case MqPackage.MQ_QUEUE_MANAGER__CHANNEL_EVENT:
				return getChannelEvent();
			case MqPackage.MQ_QUEUE_MANAGER__CHANNEL_INITIATOR_ADAPTERS:
				return getChannelInitiatorAdapters();
			case MqPackage.MQ_QUEUE_MANAGER__CHANNEL_INITIATOR_CONTROL:
				return getChannelInitiatorControl();
			case MqPackage.MQ_QUEUE_MANAGER__CHANNEL_INITIATOR_DISPATCHERS:
				return getChannelInitiatorDispatchers();
			case MqPackage.MQ_QUEUE_MANAGER__CHANNEL_INITIATOR_TRACE_AUTO_START:
				return getChannelInitiatorTraceAutoStart();
			case MqPackage.MQ_QUEUE_MANAGER__CHANNEL_INITIATOR_TRACE_TABLE_SIZE:
				return getChannelInitiatorTraceTableSize();
			case MqPackage.MQ_QUEUE_MANAGER__CHANNEL_MONITORING:
				return getChannelMonitoring();
			case MqPackage.MQ_QUEUE_MANAGER__CHANNEL_STATISTICS:
				return getChannelStatistics();
			case MqPackage.MQ_QUEUE_MANAGER__CHECKPOINT_ACTIVE_COUNT:
				return getCheckpointActiveCount();
			case MqPackage.MQ_QUEUE_MANAGER__CHECKPOINT_MESSAGE_SIZE:
				return getCheckpointMessageSize();
			case MqPackage.MQ_QUEUE_MANAGER__CHECKPOINT_RESTART_COUNT:
				return getCheckpointRestartCount();
			case MqPackage.MQ_QUEUE_MANAGER__CLUSTER_SENDER_MONITORING:
				return getClusterSenderMonitoring();
			case MqPackage.MQ_QUEUE_MANAGER__CLUSTER_SENDER_STATISTICS:
				return getClusterSenderStatistics();
			case MqPackage.MQ_QUEUE_MANAGER__CLUSTER_WORK_LOAD_DATA:
				return getClusterWorkLoadData();
			case MqPackage.MQ_QUEUE_MANAGER__CLUSTER_WORK_LOAD_EXIT:
				return getClusterWorkLoadExit();
			case MqPackage.MQ_QUEUE_MANAGER__CLUSTER_WORK_LOAD_LENGTH:
				return getClusterWorkLoadLength();
			case MqPackage.MQ_QUEUE_MANAGER__CLUSTER_WORKLOAD_USE_Q:
				return getClusterWorkloadUseQ();
			case MqPackage.MQ_QUEUE_MANAGER__CODED_CHAR_SET_ID:
				return getCodedCharSetId();
			case MqPackage.MQ_QUEUE_MANAGER__COMMAND_EVENT:
				return getCommandEvent();
			case MqPackage.MQ_QUEUE_MANAGER__COMMAND_LEVEL:
				return getCommandLevel();
			case MqPackage.MQ_QUEUE_MANAGER__COMMAND_SCOPE:
				return getCommandScope();
			case MqPackage.MQ_QUEUE_MANAGER__COMMAND_SERVER_CONTROL:
				return getCommandServerControl();
			case MqPackage.MQ_QUEUE_MANAGER__CONFIGURATION_EVENT:
				return getConfigurationEvent();
			case MqPackage.MQ_QUEUE_MANAGER__CONFIRM:
				return getConfirm();
			case MqPackage.MQ_QUEUE_MANAGER__DEAD_LETTER_QUEUE:
				return getDeadLetterQueue();
			case MqPackage.MQ_QUEUE_MANAGER__DEFAULT_BIND_TYPE:
				return getDefaultBindType();
			case MqPackage.MQ_QUEUE_MANAGER__DEFAULT_TRANSMISSION_QUEUE:
				return getDefaultTransmissionQueue();
			case MqPackage.MQ_QUEUE_MANAGER__DESCRIPTION1:
				return getDescription1();
			case MqPackage.MQ_QUEUE_MANAGER__DNS_GROUP:
				return getDNSGroup();
			case MqPackage.MQ_QUEUE_MANAGER__DNSWLM:
				return getDNSWLM();
			case MqPackage.MQ_QUEUE_MANAGER__ERROR_LOG_SIZE:
				return getErrorLogSize();
			case MqPackage.MQ_QUEUE_MANAGER__EXCLUDED_MESSAGES:
				return getExcludedMessages();
			case MqPackage.MQ_QUEUE_MANAGER__EXITS_DEFAULT_PATH:
				return getExitsDefaultPath();
			case MqPackage.MQ_QUEUE_MANAGER__EXPIRY_INTERVAL:
				return getExpiryInterval();
			case MqPackage.MQ_QUEUE_MANAGER__IGQ_PUT_AUTHORITY:
				return getIGQPutAuthority();
			case MqPackage.MQ_QUEUE_MANAGER__IGQ_USER_ID:
				return getIGQUserId();
			case MqPackage.MQ_QUEUE_MANAGER__INHIBIT_EVENT:
				return getInhibitEvent();
			case MqPackage.MQ_QUEUE_MANAGER__INSTALLABLE_SERVICE_NAME:
				return getInstallableServiceName();
			case MqPackage.MQ_QUEUE_MANAGER__INTRA_GROUP_QUEUING:
				return getIntraGroupQueuing();
			case MqPackage.MQ_QUEUE_MANAGER__IP_ADDRESS_VERSION:
				return getIPAddressVersion();
			case MqPackage.MQ_QUEUE_MANAGER__LISTENER_TIMER:
				return getListenerTimer();
			case MqPackage.MQ_QUEUE_MANAGER__LOCAL_EVENT:
				return getLocalEvent();
			case MqPackage.MQ_QUEUE_MANAGER__LOG_BUFFER_PAGES:
				return getLogBufferPages();
			case MqPackage.MQ_QUEUE_MANAGER__LOG_FILE_PAGES:
				return getLogFilePages();
			case MqPackage.MQ_QUEUE_MANAGER__LOG_PATH:
				return getLogPath();
			case MqPackage.MQ_QUEUE_MANAGER__LOG_PRIMARY_FILES:
				return getLogPrimaryFiles();
			case MqPackage.MQ_QUEUE_MANAGER__LOG_SECONDARY_FILES:
				return getLogSecondaryFiles();
			case MqPackage.MQ_QUEUE_MANAGER__LOG_TYPE:
				return getLogType();
			case MqPackage.MQ_QUEUE_MANAGER__LOG_WRITE_INTEGRITY:
				return getLogWriteIntegrity();
			case MqPackage.MQ_QUEUE_MANAGER__LU62ARM_SUFFIX:
				return getLU62ARMSuffix();
			case MqPackage.MQ_QUEUE_MANAGER__LU62_CHANNELS:
				return getLU62Channels();
			case MqPackage.MQ_QUEUE_MANAGER__LU_GROUP_NAME:
				return getLUGroupName();
			case MqPackage.MQ_QUEUE_MANAGER__LU_LIBRARY1:
				return getLULibrary1();
			case MqPackage.MQ_QUEUE_MANAGER__LU_LIBRARY2:
				return getLULibrary2();
			case MqPackage.MQ_QUEUE_MANAGER__LU_LOCAL_LU:
				return getLULocalLU();
			case MqPackage.MQ_QUEUE_MANAGER__LU_NAME:
				return getLUName();
			case MqPackage.MQ_QUEUE_MANAGER__LUTP_NAME:
				return getLUTPName();
			case MqPackage.MQ_QUEUE_MANAGER__MAX_ACTIVE_CHANNELS:
				return getMaxActiveChannels();
			case MqPackage.MQ_QUEUE_MANAGER__MAX_CHANNELS:
				return getMaxChannels();
			case MqPackage.MQ_QUEUE_MANAGER__MAXIMUM_CURRENT_CHANNELS:
				return getMaximumCurrentChannels();
			case MqPackage.MQ_QUEUE_MANAGER__MAXIMUM_HANDLES:
				return getMaximumHandles();
			case MqPackage.MQ_QUEUE_MANAGER__MAXIMUM_MESSAGE_LENGTH:
				return getMaximumMessageLength();
			case MqPackage.MQ_QUEUE_MANAGER__MAXIMUM_TCP_CHANNELS:
				return getMaximumTCPChannels();
			case MqPackage.MQ_QUEUE_MANAGER__MAXIMUM_UNCOMMITTED_MESSAGES:
				return getMaximumUncommittedMessages();
			case MqPackage.MQ_QUEUE_MANAGER__MAX_INITIATORS:
				return getMaxInitiators();
			case MqPackage.MQ_QUEUE_MANAGER__MQI_ACCOUNTING:
				return getMQIAccounting();
			case MqPackage.MQ_QUEUE_MANAGER__MQI_BIND_TYPE:
				return getMQIBindType();
			case MqPackage.MQ_QUEUE_MANAGER__MQI_STATISTICS:
				return getMQIStatistics();
			case MqPackage.MQ_QUEUE_MANAGER__NET_BIOS_ADAPTOR_NUMBER:
				return getNetBiosAdaptorNumber();
			case MqPackage.MQ_QUEUE_MANAGER__NET_BIOS_LIBRARY1:
				return getNetBiosLibrary1();
			case MqPackage.MQ_QUEUE_MANAGER__NET_BIOS_LOCAL_NAME:
				return getNetBiosLocalName();
			case MqPackage.MQ_QUEUE_MANAGER__NET_BIOS_NUMBER_OF_COMMANDS:
				return getNetBiosNumberOfCommands();
			case MqPackage.MQ_QUEUE_MANAGER__NET_BIOS_NUMBER_OF_NAMES:
				return getNetBiosNumberOfNames();
			case MqPackage.MQ_QUEUE_MANAGER__NET_BIOS_NUMBER_OF_SESSIONS:
				return getNetBiosNumberOfSessions();
			case MqPackage.MQ_QUEUE_MANAGER__OUTBOUND_PORT_MAX:
				return getOutboundPortMax();
			case MqPackage.MQ_QUEUE_MANAGER__OUTBOUND_PORT_MIN:
				return getOutboundPortMin();
			case MqPackage.MQ_QUEUE_MANAGER__PERFORMANCE_EVENT:
				return getPerformanceEvent();
			case MqPackage.MQ_QUEUE_MANAGER__PIPE_LINE_LENGTH:
				return getPipeLineLength();
			case MqPackage.MQ_QUEUE_MANAGER__PLATFORM:
				return getPlatform();
			case MqPackage.MQ_QUEUE_MANAGER__QUEUE_ACCOUNTING:
				return getQueueAccounting();
			case MqPackage.MQ_QUEUE_MANAGER__QUEUE_MANAGER_NAME:
				return getQueueManagerName();
			case MqPackage.MQ_QUEUE_MANAGER__QUEUE_MANAGER_STATUS:
				return getQueueManagerStatus();
			case MqPackage.MQ_QUEUE_MANAGER__QUEUE_MONITORING:
				return getQueueMonitoring();
			case MqPackage.MQ_QUEUE_MANAGER__QUEUE_STATISTICS:
				return getQueueStatistics();
			case MqPackage.MQ_QUEUE_MANAGER__RECEIVE_TIMEOUT:
				return getReceiveTimeout();
			case MqPackage.MQ_QUEUE_MANAGER__RECEIVE_TIMEOUT_MIN:
				return getReceiveTimeoutMin();
			case MqPackage.MQ_QUEUE_MANAGER__RECEIVE_TIMEOUT_TYPE:
				return getReceiveTimeoutType();
			case MqPackage.MQ_QUEUE_MANAGER__REMOTE_EVENT:
				return getRemoteEvent();
			case MqPackage.MQ_QUEUE_MANAGER__REPOSITORY_NAME:
				return getRepositoryName();
			case MqPackage.MQ_QUEUE_MANAGER__REPOSITORY_NAME_LIST:
				return getRepositoryNameList();
			case MqPackage.MQ_QUEUE_MANAGER__ROUTING_EXIT_CONNECT_TYPE:
				return getRoutingExitConnectType();
			case MqPackage.MQ_QUEUE_MANAGER__ROUTING_EXIT_PATH:
				return getRoutingExitPath();
			case MqPackage.MQ_QUEUE_MANAGER__SECURITY_POLICY:
				return getSecurityPolicy();
			case MqPackage.MQ_QUEUE_MANAGER__SERVICE_ENTRY_POINTS:
				return getServiceEntryPoints();
			case MqPackage.MQ_QUEUE_MANAGER__SHARED_QQMGR_NAME:
				return getSharedQQmgrName();
			case MqPackage.MQ_QUEUE_MANAGER__SPX_BOARD_NUMBER:
				return getSPXBoardNumber();
			case MqPackage.MQ_QUEUE_MANAGER__SPX_KEEP_ALIVE:
				return getSPXKeepAlive();
			case MqPackage.MQ_QUEUE_MANAGER__SPX_LIBRARY1:
				return getSPXLibrary1();
			case MqPackage.MQ_QUEUE_MANAGER__SPX_LIBRARY2:
				return getSPXLibrary2();
			case MqPackage.MQ_QUEUE_MANAGER__SPX_SOCKET:
				return getSPXSocket();
			case MqPackage.MQ_QUEUE_MANAGER__SSLCRL_NAME_LIST:
				return getSSLCRLNameList();
			case MqPackage.MQ_QUEUE_MANAGER__SSL_CRYTO_HARDWARE:
				return getSSLCrytoHardware();
			case MqPackage.MQ_QUEUE_MANAGER__SSL_EVENT:
				return getSSLEvent();
			case MqPackage.MQ_QUEUE_MANAGER__SSL_FIPS:
				return getSSLFips();
			case MqPackage.MQ_QUEUE_MANAGER__SSL_KEY_REPOSITORY:
				return getSSLKeyRepository();
			case MqPackage.MQ_QUEUE_MANAGER__SSL_KEY_RESET_COUNT:
				return getSSLKeyResetCount();
			case MqPackage.MQ_QUEUE_MANAGER__SSL_TASKS:
				return getSSLTasks();
			case MqPackage.MQ_QUEUE_MANAGER__START_STOP_EVENT:
				return getStartStopEvent();
			case MqPackage.MQ_QUEUE_MANAGER__STATISTICS_INTERVAL:
				return getStatisticsInterval();
			case MqPackage.MQ_QUEUE_MANAGER__SUPPRESED_MESSAGES:
				return getSuppresedMessages();
			case MqPackage.MQ_QUEUE_MANAGER__SUPPRESSED_MESSAGE_INTERVAL:
				return getSuppressedMessageInterval();
			case MqPackage.MQ_QUEUE_MANAGER__TCP_KEEP_ALIVE:
				return getTCPKeepAlive();
			case MqPackage.MQ_QUEUE_MANAGER__TCP_LIBRARY1:
				return getTCPLibrary1();
			case MqPackage.MQ_QUEUE_MANAGER__TCP_LIBRARY2:
				return getTCPLibrary2();
			case MqPackage.MQ_QUEUE_MANAGER__TCP_LISTENER_BACKLOG:
				return getTCPListenerBacklog();
			case MqPackage.MQ_QUEUE_MANAGER__TCP_NAME:
				return getTCPName();
			case MqPackage.MQ_QUEUE_MANAGER__TCP_PORT:
				return getTCPPort();
			case MqPackage.MQ_QUEUE_MANAGER__TCP_STACK_TYPE:
				return getTCPStackType();
			case MqPackage.MQ_QUEUE_MANAGER__TRACE_ROUTE_RECORDING:
				return getTraceRouteRecording();
			case MqPackage.MQ_QUEUE_MANAGER__TRIGGER_INTERVAL:
				return getTriggerInterval();
			case MqPackage.MQ_QUEUE_MANAGER__WHAT_IF:
				return getWhatIf();
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
			case MqPackage.MQ_QUEUE_MANAGER__ACCOUNTING_CONNECTION_OVERRIDE:
				setAccountingConnectionOverride((String)newValue);
				return;
			case MqPackage.MQ_QUEUE_MANAGER__ACCOUNTING_INTERVAL:
				setAccountingInterval((String)newValue);
				return;
			case MqPackage.MQ_QUEUE_MANAGER__ACTIVITY_RECORDING:
				setActivityRecording((String)newValue);
				return;
			case MqPackage.MQ_QUEUE_MANAGER__ADOPT_NEW_MCA:
				setAdoptNewMCA((String)newValue);
				return;
			case MqPackage.MQ_QUEUE_MANAGER__ADOPT_NEW_MCA_CHECK:
				setAdoptNewMCACheck((String)newValue);
				return;
			case MqPackage.MQ_QUEUE_MANAGER__ADOPT_NEW_MCA_TYPE:
				setAdoptNewMCAType((String)newValue);
				return;
			case MqPackage.MQ_QUEUE_MANAGER__AUTHORITY_EVENT:
				setAuthorityEvent((String)newValue);
				return;
			case MqPackage.MQ_QUEUE_MANAGER__AUTOMATIC:
				setAutomatic((String)newValue);
				return;
			case MqPackage.MQ_QUEUE_MANAGER__BRIDGE_EVENT:
				setBridgeEvent((String)newValue);
				return;
			case MqPackage.MQ_QUEUE_MANAGER__BROKER_MESSAGE_RETRY_COUNT:
				setBrokerMessageRetryCount((String)newValue);
				return;
			case MqPackage.MQ_QUEUE_MANAGER__BROKER_OPEN_CACHE_EXPIRY:
				setBrokerOpenCacheExpiry((String)newValue);
				return;
			case MqPackage.MQ_QUEUE_MANAGER__BROKER_OPEN_CACHE_SIZE:
				setBrokerOpenCacheSize((String)newValue);
				return;
			case MqPackage.MQ_QUEUE_MANAGER__BROKER_PUBLIC_BATCH_INTERVAL:
				setBrokerPublicBatchInterval((String)newValue);
				return;
			case MqPackage.MQ_QUEUE_MANAGER__BROKER_PUBLISH_BATCH_SIZE:
				setBrokerPublishBatchSize((String)newValue);
				return;
			case MqPackage.MQ_QUEUE_MANAGER__BROKER_STREAMS_PER_PROCESS:
				setBrokerStreamsPerProcess((String)newValue);
				return;
			case MqPackage.MQ_QUEUE_MANAGER__CHANNEL_AUTO_DEFINITION:
				setChannelAutoDefinition((String)newValue);
				return;
			case MqPackage.MQ_QUEUE_MANAGER__CHANNEL_AUTO_DEFINITION_EVENT:
				setChannelAutoDefinitionEvent((String)newValue);
				return;
			case MqPackage.MQ_QUEUE_MANAGER__CHANNEL_EVENT:
				setChannelEvent((String)newValue);
				return;
			case MqPackage.MQ_QUEUE_MANAGER__CHANNEL_INITIATOR_ADAPTERS:
				setChannelInitiatorAdapters((String)newValue);
				return;
			case MqPackage.MQ_QUEUE_MANAGER__CHANNEL_INITIATOR_CONTROL:
				setChannelInitiatorControl((String)newValue);
				return;
			case MqPackage.MQ_QUEUE_MANAGER__CHANNEL_INITIATOR_DISPATCHERS:
				setChannelInitiatorDispatchers((String)newValue);
				return;
			case MqPackage.MQ_QUEUE_MANAGER__CHANNEL_INITIATOR_TRACE_AUTO_START:
				setChannelInitiatorTraceAutoStart((String)newValue);
				return;
			case MqPackage.MQ_QUEUE_MANAGER__CHANNEL_INITIATOR_TRACE_TABLE_SIZE:
				setChannelInitiatorTraceTableSize((String)newValue);
				return;
			case MqPackage.MQ_QUEUE_MANAGER__CHANNEL_MONITORING:
				setChannelMonitoring((String)newValue);
				return;
			case MqPackage.MQ_QUEUE_MANAGER__CHANNEL_STATISTICS:
				setChannelStatistics((String)newValue);
				return;
			case MqPackage.MQ_QUEUE_MANAGER__CHECKPOINT_ACTIVE_COUNT:
				setCheckpointActiveCount((String)newValue);
				return;
			case MqPackage.MQ_QUEUE_MANAGER__CHECKPOINT_MESSAGE_SIZE:
				setCheckpointMessageSize((String)newValue);
				return;
			case MqPackage.MQ_QUEUE_MANAGER__CHECKPOINT_RESTART_COUNT:
				setCheckpointRestartCount((String)newValue);
				return;
			case MqPackage.MQ_QUEUE_MANAGER__CLUSTER_SENDER_MONITORING:
				setClusterSenderMonitoring((String)newValue);
				return;
			case MqPackage.MQ_QUEUE_MANAGER__CLUSTER_SENDER_STATISTICS:
				setClusterSenderStatistics((String)newValue);
				return;
			case MqPackage.MQ_QUEUE_MANAGER__CLUSTER_WORK_LOAD_DATA:
				setClusterWorkLoadData((String)newValue);
				return;
			case MqPackage.MQ_QUEUE_MANAGER__CLUSTER_WORK_LOAD_EXIT:
				setClusterWorkLoadExit((String)newValue);
				return;
			case MqPackage.MQ_QUEUE_MANAGER__CLUSTER_WORK_LOAD_LENGTH:
				setClusterWorkLoadLength((String)newValue);
				return;
			case MqPackage.MQ_QUEUE_MANAGER__CLUSTER_WORKLOAD_USE_Q:
				setClusterWorkloadUseQ((String)newValue);
				return;
			case MqPackage.MQ_QUEUE_MANAGER__CODED_CHAR_SET_ID:
				setCodedCharSetId((String)newValue);
				return;
			case MqPackage.MQ_QUEUE_MANAGER__COMMAND_EVENT:
				setCommandEvent((String)newValue);
				return;
			case MqPackage.MQ_QUEUE_MANAGER__COMMAND_LEVEL:
				setCommandLevel((String)newValue);
				return;
			case MqPackage.MQ_QUEUE_MANAGER__COMMAND_SCOPE:
				setCommandScope((String)newValue);
				return;
			case MqPackage.MQ_QUEUE_MANAGER__COMMAND_SERVER_CONTROL:
				setCommandServerControl((String)newValue);
				return;
			case MqPackage.MQ_QUEUE_MANAGER__CONFIGURATION_EVENT:
				setConfigurationEvent((String)newValue);
				return;
			case MqPackage.MQ_QUEUE_MANAGER__CONFIRM:
				setConfirm((String)newValue);
				return;
			case MqPackage.MQ_QUEUE_MANAGER__DEAD_LETTER_QUEUE:
				setDeadLetterQueue((String)newValue);
				return;
			case MqPackage.MQ_QUEUE_MANAGER__DEFAULT_BIND_TYPE:
				setDefaultBindType((String)newValue);
				return;
			case MqPackage.MQ_QUEUE_MANAGER__DEFAULT_TRANSMISSION_QUEUE:
				setDefaultTransmissionQueue((String)newValue);
				return;
			case MqPackage.MQ_QUEUE_MANAGER__DESCRIPTION1:
				setDescription1((String)newValue);
				return;
			case MqPackage.MQ_QUEUE_MANAGER__DNS_GROUP:
				setDNSGroup((String)newValue);
				return;
			case MqPackage.MQ_QUEUE_MANAGER__DNSWLM:
				setDNSWLM((String)newValue);
				return;
			case MqPackage.MQ_QUEUE_MANAGER__ERROR_LOG_SIZE:
				setErrorLogSize((String)newValue);
				return;
			case MqPackage.MQ_QUEUE_MANAGER__EXCLUDED_MESSAGES:
				setExcludedMessages((String)newValue);
				return;
			case MqPackage.MQ_QUEUE_MANAGER__EXITS_DEFAULT_PATH:
				setExitsDefaultPath((String)newValue);
				return;
			case MqPackage.MQ_QUEUE_MANAGER__EXPIRY_INTERVAL:
				setExpiryInterval((String)newValue);
				return;
			case MqPackage.MQ_QUEUE_MANAGER__IGQ_PUT_AUTHORITY:
				setIGQPutAuthority((String)newValue);
				return;
			case MqPackage.MQ_QUEUE_MANAGER__IGQ_USER_ID:
				setIGQUserId((String)newValue);
				return;
			case MqPackage.MQ_QUEUE_MANAGER__INHIBIT_EVENT:
				setInhibitEvent((String)newValue);
				return;
			case MqPackage.MQ_QUEUE_MANAGER__INSTALLABLE_SERVICE_NAME:
				setInstallableServiceName((String)newValue);
				return;
			case MqPackage.MQ_QUEUE_MANAGER__INTRA_GROUP_QUEUING:
				setIntraGroupQueuing((String)newValue);
				return;
			case MqPackage.MQ_QUEUE_MANAGER__IP_ADDRESS_VERSION:
				setIPAddressVersion((String)newValue);
				return;
			case MqPackage.MQ_QUEUE_MANAGER__LISTENER_TIMER:
				setListenerTimer((String)newValue);
				return;
			case MqPackage.MQ_QUEUE_MANAGER__LOCAL_EVENT:
				setLocalEvent((String)newValue);
				return;
			case MqPackage.MQ_QUEUE_MANAGER__LOG_BUFFER_PAGES:
				setLogBufferPages((String)newValue);
				return;
			case MqPackage.MQ_QUEUE_MANAGER__LOG_FILE_PAGES:
				setLogFilePages((String)newValue);
				return;
			case MqPackage.MQ_QUEUE_MANAGER__LOG_PATH:
				setLogPath((String)newValue);
				return;
			case MqPackage.MQ_QUEUE_MANAGER__LOG_PRIMARY_FILES:
				setLogPrimaryFiles((String)newValue);
				return;
			case MqPackage.MQ_QUEUE_MANAGER__LOG_SECONDARY_FILES:
				setLogSecondaryFiles((String)newValue);
				return;
			case MqPackage.MQ_QUEUE_MANAGER__LOG_TYPE:
				setLogType((String)newValue);
				return;
			case MqPackage.MQ_QUEUE_MANAGER__LOG_WRITE_INTEGRITY:
				setLogWriteIntegrity((String)newValue);
				return;
			case MqPackage.MQ_QUEUE_MANAGER__LU62ARM_SUFFIX:
				setLU62ARMSuffix((String)newValue);
				return;
			case MqPackage.MQ_QUEUE_MANAGER__LU62_CHANNELS:
				setLU62Channels((String)newValue);
				return;
			case MqPackage.MQ_QUEUE_MANAGER__LU_GROUP_NAME:
				setLUGroupName((String)newValue);
				return;
			case MqPackage.MQ_QUEUE_MANAGER__LU_LIBRARY1:
				setLULibrary1((String)newValue);
				return;
			case MqPackage.MQ_QUEUE_MANAGER__LU_LIBRARY2:
				setLULibrary2((String)newValue);
				return;
			case MqPackage.MQ_QUEUE_MANAGER__LU_LOCAL_LU:
				setLULocalLU((String)newValue);
				return;
			case MqPackage.MQ_QUEUE_MANAGER__LU_NAME:
				setLUName((String)newValue);
				return;
			case MqPackage.MQ_QUEUE_MANAGER__LUTP_NAME:
				setLUTPName((String)newValue);
				return;
			case MqPackage.MQ_QUEUE_MANAGER__MAX_ACTIVE_CHANNELS:
				setMaxActiveChannels((String)newValue);
				return;
			case MqPackage.MQ_QUEUE_MANAGER__MAX_CHANNELS:
				setMaxChannels((String)newValue);
				return;
			case MqPackage.MQ_QUEUE_MANAGER__MAXIMUM_CURRENT_CHANNELS:
				setMaximumCurrentChannels((String)newValue);
				return;
			case MqPackage.MQ_QUEUE_MANAGER__MAXIMUM_HANDLES:
				setMaximumHandles((String)newValue);
				return;
			case MqPackage.MQ_QUEUE_MANAGER__MAXIMUM_MESSAGE_LENGTH:
				setMaximumMessageLength((String)newValue);
				return;
			case MqPackage.MQ_QUEUE_MANAGER__MAXIMUM_TCP_CHANNELS:
				setMaximumTCPChannels((String)newValue);
				return;
			case MqPackage.MQ_QUEUE_MANAGER__MAXIMUM_UNCOMMITTED_MESSAGES:
				setMaximumUncommittedMessages((String)newValue);
				return;
			case MqPackage.MQ_QUEUE_MANAGER__MAX_INITIATORS:
				setMaxInitiators((String)newValue);
				return;
			case MqPackage.MQ_QUEUE_MANAGER__MQI_ACCOUNTING:
				setMQIAccounting((String)newValue);
				return;
			case MqPackage.MQ_QUEUE_MANAGER__MQI_BIND_TYPE:
				setMQIBindType((String)newValue);
				return;
			case MqPackage.MQ_QUEUE_MANAGER__MQI_STATISTICS:
				setMQIStatistics((String)newValue);
				return;
			case MqPackage.MQ_QUEUE_MANAGER__NET_BIOS_ADAPTOR_NUMBER:
				setNetBiosAdaptorNumber((String)newValue);
				return;
			case MqPackage.MQ_QUEUE_MANAGER__NET_BIOS_LIBRARY1:
				setNetBiosLibrary1((String)newValue);
				return;
			case MqPackage.MQ_QUEUE_MANAGER__NET_BIOS_LOCAL_NAME:
				setNetBiosLocalName((String)newValue);
				return;
			case MqPackage.MQ_QUEUE_MANAGER__NET_BIOS_NUMBER_OF_COMMANDS:
				setNetBiosNumberOfCommands((String)newValue);
				return;
			case MqPackage.MQ_QUEUE_MANAGER__NET_BIOS_NUMBER_OF_NAMES:
				setNetBiosNumberOfNames((String)newValue);
				return;
			case MqPackage.MQ_QUEUE_MANAGER__NET_BIOS_NUMBER_OF_SESSIONS:
				setNetBiosNumberOfSessions((String)newValue);
				return;
			case MqPackage.MQ_QUEUE_MANAGER__OUTBOUND_PORT_MAX:
				setOutboundPortMax((String)newValue);
				return;
			case MqPackage.MQ_QUEUE_MANAGER__OUTBOUND_PORT_MIN:
				setOutboundPortMin((String)newValue);
				return;
			case MqPackage.MQ_QUEUE_MANAGER__PERFORMANCE_EVENT:
				setPerformanceEvent((String)newValue);
				return;
			case MqPackage.MQ_QUEUE_MANAGER__PIPE_LINE_LENGTH:
				setPipeLineLength((String)newValue);
				return;
			case MqPackage.MQ_QUEUE_MANAGER__PLATFORM:
				setPlatform((String)newValue);
				return;
			case MqPackage.MQ_QUEUE_MANAGER__QUEUE_ACCOUNTING:
				setQueueAccounting((String)newValue);
				return;
			case MqPackage.MQ_QUEUE_MANAGER__QUEUE_MANAGER_NAME:
				setQueueManagerName((String)newValue);
				return;
			case MqPackage.MQ_QUEUE_MANAGER__QUEUE_MANAGER_STATUS:
				setQueueManagerStatus((String)newValue);
				return;
			case MqPackage.MQ_QUEUE_MANAGER__QUEUE_MONITORING:
				setQueueMonitoring((String)newValue);
				return;
			case MqPackage.MQ_QUEUE_MANAGER__QUEUE_STATISTICS:
				setQueueStatistics((String)newValue);
				return;
			case MqPackage.MQ_QUEUE_MANAGER__RECEIVE_TIMEOUT:
				setReceiveTimeout((String)newValue);
				return;
			case MqPackage.MQ_QUEUE_MANAGER__RECEIVE_TIMEOUT_MIN:
				setReceiveTimeoutMin((String)newValue);
				return;
			case MqPackage.MQ_QUEUE_MANAGER__RECEIVE_TIMEOUT_TYPE:
				setReceiveTimeoutType((String)newValue);
				return;
			case MqPackage.MQ_QUEUE_MANAGER__REMOTE_EVENT:
				setRemoteEvent((String)newValue);
				return;
			case MqPackage.MQ_QUEUE_MANAGER__REPOSITORY_NAME:
				setRepositoryName((String)newValue);
				return;
			case MqPackage.MQ_QUEUE_MANAGER__REPOSITORY_NAME_LIST:
				setRepositoryNameList((String)newValue);
				return;
			case MqPackage.MQ_QUEUE_MANAGER__ROUTING_EXIT_CONNECT_TYPE:
				setRoutingExitConnectType((String)newValue);
				return;
			case MqPackage.MQ_QUEUE_MANAGER__ROUTING_EXIT_PATH:
				setRoutingExitPath((String)newValue);
				return;
			case MqPackage.MQ_QUEUE_MANAGER__SECURITY_POLICY:
				setSecurityPolicy((String)newValue);
				return;
			case MqPackage.MQ_QUEUE_MANAGER__SERVICE_ENTRY_POINTS:
				setServiceEntryPoints((String)newValue);
				return;
			case MqPackage.MQ_QUEUE_MANAGER__SHARED_QQMGR_NAME:
				setSharedQQmgrName((String)newValue);
				return;
			case MqPackage.MQ_QUEUE_MANAGER__SPX_BOARD_NUMBER:
				setSPXBoardNumber((String)newValue);
				return;
			case MqPackage.MQ_QUEUE_MANAGER__SPX_KEEP_ALIVE:
				setSPXKeepAlive((String)newValue);
				return;
			case MqPackage.MQ_QUEUE_MANAGER__SPX_LIBRARY1:
				setSPXLibrary1((String)newValue);
				return;
			case MqPackage.MQ_QUEUE_MANAGER__SPX_LIBRARY2:
				setSPXLibrary2((String)newValue);
				return;
			case MqPackage.MQ_QUEUE_MANAGER__SPX_SOCKET:
				setSPXSocket((String)newValue);
				return;
			case MqPackage.MQ_QUEUE_MANAGER__SSLCRL_NAME_LIST:
				setSSLCRLNameList((String)newValue);
				return;
			case MqPackage.MQ_QUEUE_MANAGER__SSL_CRYTO_HARDWARE:
				setSSLCrytoHardware((String)newValue);
				return;
			case MqPackage.MQ_QUEUE_MANAGER__SSL_EVENT:
				setSSLEvent((String)newValue);
				return;
			case MqPackage.MQ_QUEUE_MANAGER__SSL_FIPS:
				setSSLFips((String)newValue);
				return;
			case MqPackage.MQ_QUEUE_MANAGER__SSL_KEY_REPOSITORY:
				setSSLKeyRepository((String)newValue);
				return;
			case MqPackage.MQ_QUEUE_MANAGER__SSL_KEY_RESET_COUNT:
				setSSLKeyResetCount((String)newValue);
				return;
			case MqPackage.MQ_QUEUE_MANAGER__SSL_TASKS:
				setSSLTasks((String)newValue);
				return;
			case MqPackage.MQ_QUEUE_MANAGER__START_STOP_EVENT:
				setStartStopEvent((String)newValue);
				return;
			case MqPackage.MQ_QUEUE_MANAGER__STATISTICS_INTERVAL:
				setStatisticsInterval((String)newValue);
				return;
			case MqPackage.MQ_QUEUE_MANAGER__SUPPRESED_MESSAGES:
				setSuppresedMessages((String)newValue);
				return;
			case MqPackage.MQ_QUEUE_MANAGER__SUPPRESSED_MESSAGE_INTERVAL:
				setSuppressedMessageInterval((String)newValue);
				return;
			case MqPackage.MQ_QUEUE_MANAGER__TCP_KEEP_ALIVE:
				setTCPKeepAlive((String)newValue);
				return;
			case MqPackage.MQ_QUEUE_MANAGER__TCP_LIBRARY1:
				setTCPLibrary1((String)newValue);
				return;
			case MqPackage.MQ_QUEUE_MANAGER__TCP_LIBRARY2:
				setTCPLibrary2((String)newValue);
				return;
			case MqPackage.MQ_QUEUE_MANAGER__TCP_LISTENER_BACKLOG:
				setTCPListenerBacklog((String)newValue);
				return;
			case MqPackage.MQ_QUEUE_MANAGER__TCP_NAME:
				setTCPName((String)newValue);
				return;
			case MqPackage.MQ_QUEUE_MANAGER__TCP_PORT:
				setTCPPort((String)newValue);
				return;
			case MqPackage.MQ_QUEUE_MANAGER__TCP_STACK_TYPE:
				setTCPStackType((String)newValue);
				return;
			case MqPackage.MQ_QUEUE_MANAGER__TRACE_ROUTE_RECORDING:
				setTraceRouteRecording((String)newValue);
				return;
			case MqPackage.MQ_QUEUE_MANAGER__TRIGGER_INTERVAL:
				setTriggerInterval((String)newValue);
				return;
			case MqPackage.MQ_QUEUE_MANAGER__WHAT_IF:
				setWhatIf((String)newValue);
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
			case MqPackage.MQ_QUEUE_MANAGER__ACCOUNTING_CONNECTION_OVERRIDE:
				setAccountingConnectionOverride(ACCOUNTING_CONNECTION_OVERRIDE_EDEFAULT);
				return;
			case MqPackage.MQ_QUEUE_MANAGER__ACCOUNTING_INTERVAL:
				setAccountingInterval(ACCOUNTING_INTERVAL_EDEFAULT);
				return;
			case MqPackage.MQ_QUEUE_MANAGER__ACTIVITY_RECORDING:
				setActivityRecording(ACTIVITY_RECORDING_EDEFAULT);
				return;
			case MqPackage.MQ_QUEUE_MANAGER__ADOPT_NEW_MCA:
				setAdoptNewMCA(ADOPT_NEW_MCA_EDEFAULT);
				return;
			case MqPackage.MQ_QUEUE_MANAGER__ADOPT_NEW_MCA_CHECK:
				setAdoptNewMCACheck(ADOPT_NEW_MCA_CHECK_EDEFAULT);
				return;
			case MqPackage.MQ_QUEUE_MANAGER__ADOPT_NEW_MCA_TYPE:
				setAdoptNewMCAType(ADOPT_NEW_MCA_TYPE_EDEFAULT);
				return;
			case MqPackage.MQ_QUEUE_MANAGER__AUTHORITY_EVENT:
				setAuthorityEvent(AUTHORITY_EVENT_EDEFAULT);
				return;
			case MqPackage.MQ_QUEUE_MANAGER__AUTOMATIC:
				setAutomatic(AUTOMATIC_EDEFAULT);
				return;
			case MqPackage.MQ_QUEUE_MANAGER__BRIDGE_EVENT:
				setBridgeEvent(BRIDGE_EVENT_EDEFAULT);
				return;
			case MqPackage.MQ_QUEUE_MANAGER__BROKER_MESSAGE_RETRY_COUNT:
				setBrokerMessageRetryCount(BROKER_MESSAGE_RETRY_COUNT_EDEFAULT);
				return;
			case MqPackage.MQ_QUEUE_MANAGER__BROKER_OPEN_CACHE_EXPIRY:
				setBrokerOpenCacheExpiry(BROKER_OPEN_CACHE_EXPIRY_EDEFAULT);
				return;
			case MqPackage.MQ_QUEUE_MANAGER__BROKER_OPEN_CACHE_SIZE:
				setBrokerOpenCacheSize(BROKER_OPEN_CACHE_SIZE_EDEFAULT);
				return;
			case MqPackage.MQ_QUEUE_MANAGER__BROKER_PUBLIC_BATCH_INTERVAL:
				setBrokerPublicBatchInterval(BROKER_PUBLIC_BATCH_INTERVAL_EDEFAULT);
				return;
			case MqPackage.MQ_QUEUE_MANAGER__BROKER_PUBLISH_BATCH_SIZE:
				setBrokerPublishBatchSize(BROKER_PUBLISH_BATCH_SIZE_EDEFAULT);
				return;
			case MqPackage.MQ_QUEUE_MANAGER__BROKER_STREAMS_PER_PROCESS:
				setBrokerStreamsPerProcess(BROKER_STREAMS_PER_PROCESS_EDEFAULT);
				return;
			case MqPackage.MQ_QUEUE_MANAGER__CHANNEL_AUTO_DEFINITION:
				setChannelAutoDefinition(CHANNEL_AUTO_DEFINITION_EDEFAULT);
				return;
			case MqPackage.MQ_QUEUE_MANAGER__CHANNEL_AUTO_DEFINITION_EVENT:
				setChannelAutoDefinitionEvent(CHANNEL_AUTO_DEFINITION_EVENT_EDEFAULT);
				return;
			case MqPackage.MQ_QUEUE_MANAGER__CHANNEL_EVENT:
				setChannelEvent(CHANNEL_EVENT_EDEFAULT);
				return;
			case MqPackage.MQ_QUEUE_MANAGER__CHANNEL_INITIATOR_ADAPTERS:
				setChannelInitiatorAdapters(CHANNEL_INITIATOR_ADAPTERS_EDEFAULT);
				return;
			case MqPackage.MQ_QUEUE_MANAGER__CHANNEL_INITIATOR_CONTROL:
				setChannelInitiatorControl(CHANNEL_INITIATOR_CONTROL_EDEFAULT);
				return;
			case MqPackage.MQ_QUEUE_MANAGER__CHANNEL_INITIATOR_DISPATCHERS:
				setChannelInitiatorDispatchers(CHANNEL_INITIATOR_DISPATCHERS_EDEFAULT);
				return;
			case MqPackage.MQ_QUEUE_MANAGER__CHANNEL_INITIATOR_TRACE_AUTO_START:
				setChannelInitiatorTraceAutoStart(CHANNEL_INITIATOR_TRACE_AUTO_START_EDEFAULT);
				return;
			case MqPackage.MQ_QUEUE_MANAGER__CHANNEL_INITIATOR_TRACE_TABLE_SIZE:
				setChannelInitiatorTraceTableSize(CHANNEL_INITIATOR_TRACE_TABLE_SIZE_EDEFAULT);
				return;
			case MqPackage.MQ_QUEUE_MANAGER__CHANNEL_MONITORING:
				setChannelMonitoring(CHANNEL_MONITORING_EDEFAULT);
				return;
			case MqPackage.MQ_QUEUE_MANAGER__CHANNEL_STATISTICS:
				setChannelStatistics(CHANNEL_STATISTICS_EDEFAULT);
				return;
			case MqPackage.MQ_QUEUE_MANAGER__CHECKPOINT_ACTIVE_COUNT:
				setCheckpointActiveCount(CHECKPOINT_ACTIVE_COUNT_EDEFAULT);
				return;
			case MqPackage.MQ_QUEUE_MANAGER__CHECKPOINT_MESSAGE_SIZE:
				setCheckpointMessageSize(CHECKPOINT_MESSAGE_SIZE_EDEFAULT);
				return;
			case MqPackage.MQ_QUEUE_MANAGER__CHECKPOINT_RESTART_COUNT:
				setCheckpointRestartCount(CHECKPOINT_RESTART_COUNT_EDEFAULT);
				return;
			case MqPackage.MQ_QUEUE_MANAGER__CLUSTER_SENDER_MONITORING:
				setClusterSenderMonitoring(CLUSTER_SENDER_MONITORING_EDEFAULT);
				return;
			case MqPackage.MQ_QUEUE_MANAGER__CLUSTER_SENDER_STATISTICS:
				setClusterSenderStatistics(CLUSTER_SENDER_STATISTICS_EDEFAULT);
				return;
			case MqPackage.MQ_QUEUE_MANAGER__CLUSTER_WORK_LOAD_DATA:
				setClusterWorkLoadData(CLUSTER_WORK_LOAD_DATA_EDEFAULT);
				return;
			case MqPackage.MQ_QUEUE_MANAGER__CLUSTER_WORK_LOAD_EXIT:
				setClusterWorkLoadExit(CLUSTER_WORK_LOAD_EXIT_EDEFAULT);
				return;
			case MqPackage.MQ_QUEUE_MANAGER__CLUSTER_WORK_LOAD_LENGTH:
				setClusterWorkLoadLength(CLUSTER_WORK_LOAD_LENGTH_EDEFAULT);
				return;
			case MqPackage.MQ_QUEUE_MANAGER__CLUSTER_WORKLOAD_USE_Q:
				setClusterWorkloadUseQ(CLUSTER_WORKLOAD_USE_Q_EDEFAULT);
				return;
			case MqPackage.MQ_QUEUE_MANAGER__CODED_CHAR_SET_ID:
				setCodedCharSetId(CODED_CHAR_SET_ID_EDEFAULT);
				return;
			case MqPackage.MQ_QUEUE_MANAGER__COMMAND_EVENT:
				setCommandEvent(COMMAND_EVENT_EDEFAULT);
				return;
			case MqPackage.MQ_QUEUE_MANAGER__COMMAND_LEVEL:
				setCommandLevel(COMMAND_LEVEL_EDEFAULT);
				return;
			case MqPackage.MQ_QUEUE_MANAGER__COMMAND_SCOPE:
				setCommandScope(COMMAND_SCOPE_EDEFAULT);
				return;
			case MqPackage.MQ_QUEUE_MANAGER__COMMAND_SERVER_CONTROL:
				setCommandServerControl(COMMAND_SERVER_CONTROL_EDEFAULT);
				return;
			case MqPackage.MQ_QUEUE_MANAGER__CONFIGURATION_EVENT:
				setConfigurationEvent(CONFIGURATION_EVENT_EDEFAULT);
				return;
			case MqPackage.MQ_QUEUE_MANAGER__CONFIRM:
				setConfirm(CONFIRM_EDEFAULT);
				return;
			case MqPackage.MQ_QUEUE_MANAGER__DEAD_LETTER_QUEUE:
				setDeadLetterQueue(DEAD_LETTER_QUEUE_EDEFAULT);
				return;
			case MqPackage.MQ_QUEUE_MANAGER__DEFAULT_BIND_TYPE:
				setDefaultBindType(DEFAULT_BIND_TYPE_EDEFAULT);
				return;
			case MqPackage.MQ_QUEUE_MANAGER__DEFAULT_TRANSMISSION_QUEUE:
				setDefaultTransmissionQueue(DEFAULT_TRANSMISSION_QUEUE_EDEFAULT);
				return;
			case MqPackage.MQ_QUEUE_MANAGER__DESCRIPTION1:
				setDescription1(DESCRIPTION1_EDEFAULT);
				return;
			case MqPackage.MQ_QUEUE_MANAGER__DNS_GROUP:
				setDNSGroup(DNS_GROUP_EDEFAULT);
				return;
			case MqPackage.MQ_QUEUE_MANAGER__DNSWLM:
				setDNSWLM(DNSWLM_EDEFAULT);
				return;
			case MqPackage.MQ_QUEUE_MANAGER__ERROR_LOG_SIZE:
				setErrorLogSize(ERROR_LOG_SIZE_EDEFAULT);
				return;
			case MqPackage.MQ_QUEUE_MANAGER__EXCLUDED_MESSAGES:
				setExcludedMessages(EXCLUDED_MESSAGES_EDEFAULT);
				return;
			case MqPackage.MQ_QUEUE_MANAGER__EXITS_DEFAULT_PATH:
				setExitsDefaultPath(EXITS_DEFAULT_PATH_EDEFAULT);
				return;
			case MqPackage.MQ_QUEUE_MANAGER__EXPIRY_INTERVAL:
				setExpiryInterval(EXPIRY_INTERVAL_EDEFAULT);
				return;
			case MqPackage.MQ_QUEUE_MANAGER__IGQ_PUT_AUTHORITY:
				setIGQPutAuthority(IGQ_PUT_AUTHORITY_EDEFAULT);
				return;
			case MqPackage.MQ_QUEUE_MANAGER__IGQ_USER_ID:
				setIGQUserId(IGQ_USER_ID_EDEFAULT);
				return;
			case MqPackage.MQ_QUEUE_MANAGER__INHIBIT_EVENT:
				setInhibitEvent(INHIBIT_EVENT_EDEFAULT);
				return;
			case MqPackage.MQ_QUEUE_MANAGER__INSTALLABLE_SERVICE_NAME:
				setInstallableServiceName(INSTALLABLE_SERVICE_NAME_EDEFAULT);
				return;
			case MqPackage.MQ_QUEUE_MANAGER__INTRA_GROUP_QUEUING:
				setIntraGroupQueuing(INTRA_GROUP_QUEUING_EDEFAULT);
				return;
			case MqPackage.MQ_QUEUE_MANAGER__IP_ADDRESS_VERSION:
				setIPAddressVersion(IP_ADDRESS_VERSION_EDEFAULT);
				return;
			case MqPackage.MQ_QUEUE_MANAGER__LISTENER_TIMER:
				setListenerTimer(LISTENER_TIMER_EDEFAULT);
				return;
			case MqPackage.MQ_QUEUE_MANAGER__LOCAL_EVENT:
				setLocalEvent(LOCAL_EVENT_EDEFAULT);
				return;
			case MqPackage.MQ_QUEUE_MANAGER__LOG_BUFFER_PAGES:
				setLogBufferPages(LOG_BUFFER_PAGES_EDEFAULT);
				return;
			case MqPackage.MQ_QUEUE_MANAGER__LOG_FILE_PAGES:
				setLogFilePages(LOG_FILE_PAGES_EDEFAULT);
				return;
			case MqPackage.MQ_QUEUE_MANAGER__LOG_PATH:
				setLogPath(LOG_PATH_EDEFAULT);
				return;
			case MqPackage.MQ_QUEUE_MANAGER__LOG_PRIMARY_FILES:
				setLogPrimaryFiles(LOG_PRIMARY_FILES_EDEFAULT);
				return;
			case MqPackage.MQ_QUEUE_MANAGER__LOG_SECONDARY_FILES:
				setLogSecondaryFiles(LOG_SECONDARY_FILES_EDEFAULT);
				return;
			case MqPackage.MQ_QUEUE_MANAGER__LOG_TYPE:
				setLogType(LOG_TYPE_EDEFAULT);
				return;
			case MqPackage.MQ_QUEUE_MANAGER__LOG_WRITE_INTEGRITY:
				setLogWriteIntegrity(LOG_WRITE_INTEGRITY_EDEFAULT);
				return;
			case MqPackage.MQ_QUEUE_MANAGER__LU62ARM_SUFFIX:
				setLU62ARMSuffix(LU62ARM_SUFFIX_EDEFAULT);
				return;
			case MqPackage.MQ_QUEUE_MANAGER__LU62_CHANNELS:
				setLU62Channels(LU62_CHANNELS_EDEFAULT);
				return;
			case MqPackage.MQ_QUEUE_MANAGER__LU_GROUP_NAME:
				setLUGroupName(LU_GROUP_NAME_EDEFAULT);
				return;
			case MqPackage.MQ_QUEUE_MANAGER__LU_LIBRARY1:
				setLULibrary1(LU_LIBRARY1_EDEFAULT);
				return;
			case MqPackage.MQ_QUEUE_MANAGER__LU_LIBRARY2:
				setLULibrary2(LU_LIBRARY2_EDEFAULT);
				return;
			case MqPackage.MQ_QUEUE_MANAGER__LU_LOCAL_LU:
				setLULocalLU(LU_LOCAL_LU_EDEFAULT);
				return;
			case MqPackage.MQ_QUEUE_MANAGER__LU_NAME:
				setLUName(LU_NAME_EDEFAULT);
				return;
			case MqPackage.MQ_QUEUE_MANAGER__LUTP_NAME:
				setLUTPName(LUTP_NAME_EDEFAULT);
				return;
			case MqPackage.MQ_QUEUE_MANAGER__MAX_ACTIVE_CHANNELS:
				setMaxActiveChannels(MAX_ACTIVE_CHANNELS_EDEFAULT);
				return;
			case MqPackage.MQ_QUEUE_MANAGER__MAX_CHANNELS:
				setMaxChannels(MAX_CHANNELS_EDEFAULT);
				return;
			case MqPackage.MQ_QUEUE_MANAGER__MAXIMUM_CURRENT_CHANNELS:
				setMaximumCurrentChannels(MAXIMUM_CURRENT_CHANNELS_EDEFAULT);
				return;
			case MqPackage.MQ_QUEUE_MANAGER__MAXIMUM_HANDLES:
				setMaximumHandles(MAXIMUM_HANDLES_EDEFAULT);
				return;
			case MqPackage.MQ_QUEUE_MANAGER__MAXIMUM_MESSAGE_LENGTH:
				setMaximumMessageLength(MAXIMUM_MESSAGE_LENGTH_EDEFAULT);
				return;
			case MqPackage.MQ_QUEUE_MANAGER__MAXIMUM_TCP_CHANNELS:
				setMaximumTCPChannels(MAXIMUM_TCP_CHANNELS_EDEFAULT);
				return;
			case MqPackage.MQ_QUEUE_MANAGER__MAXIMUM_UNCOMMITTED_MESSAGES:
				setMaximumUncommittedMessages(MAXIMUM_UNCOMMITTED_MESSAGES_EDEFAULT);
				return;
			case MqPackage.MQ_QUEUE_MANAGER__MAX_INITIATORS:
				setMaxInitiators(MAX_INITIATORS_EDEFAULT);
				return;
			case MqPackage.MQ_QUEUE_MANAGER__MQI_ACCOUNTING:
				setMQIAccounting(MQI_ACCOUNTING_EDEFAULT);
				return;
			case MqPackage.MQ_QUEUE_MANAGER__MQI_BIND_TYPE:
				setMQIBindType(MQI_BIND_TYPE_EDEFAULT);
				return;
			case MqPackage.MQ_QUEUE_MANAGER__MQI_STATISTICS:
				setMQIStatistics(MQI_STATISTICS_EDEFAULT);
				return;
			case MqPackage.MQ_QUEUE_MANAGER__NET_BIOS_ADAPTOR_NUMBER:
				setNetBiosAdaptorNumber(NET_BIOS_ADAPTOR_NUMBER_EDEFAULT);
				return;
			case MqPackage.MQ_QUEUE_MANAGER__NET_BIOS_LIBRARY1:
				setNetBiosLibrary1(NET_BIOS_LIBRARY1_EDEFAULT);
				return;
			case MqPackage.MQ_QUEUE_MANAGER__NET_BIOS_LOCAL_NAME:
				setNetBiosLocalName(NET_BIOS_LOCAL_NAME_EDEFAULT);
				return;
			case MqPackage.MQ_QUEUE_MANAGER__NET_BIOS_NUMBER_OF_COMMANDS:
				setNetBiosNumberOfCommands(NET_BIOS_NUMBER_OF_COMMANDS_EDEFAULT);
				return;
			case MqPackage.MQ_QUEUE_MANAGER__NET_BIOS_NUMBER_OF_NAMES:
				setNetBiosNumberOfNames(NET_BIOS_NUMBER_OF_NAMES_EDEFAULT);
				return;
			case MqPackage.MQ_QUEUE_MANAGER__NET_BIOS_NUMBER_OF_SESSIONS:
				setNetBiosNumberOfSessions(NET_BIOS_NUMBER_OF_SESSIONS_EDEFAULT);
				return;
			case MqPackage.MQ_QUEUE_MANAGER__OUTBOUND_PORT_MAX:
				setOutboundPortMax(OUTBOUND_PORT_MAX_EDEFAULT);
				return;
			case MqPackage.MQ_QUEUE_MANAGER__OUTBOUND_PORT_MIN:
				setOutboundPortMin(OUTBOUND_PORT_MIN_EDEFAULT);
				return;
			case MqPackage.MQ_QUEUE_MANAGER__PERFORMANCE_EVENT:
				setPerformanceEvent(PERFORMANCE_EVENT_EDEFAULT);
				return;
			case MqPackage.MQ_QUEUE_MANAGER__PIPE_LINE_LENGTH:
				setPipeLineLength(PIPE_LINE_LENGTH_EDEFAULT);
				return;
			case MqPackage.MQ_QUEUE_MANAGER__PLATFORM:
				setPlatform(PLATFORM_EDEFAULT);
				return;
			case MqPackage.MQ_QUEUE_MANAGER__QUEUE_ACCOUNTING:
				setQueueAccounting(QUEUE_ACCOUNTING_EDEFAULT);
				return;
			case MqPackage.MQ_QUEUE_MANAGER__QUEUE_MANAGER_NAME:
				setQueueManagerName(QUEUE_MANAGER_NAME_EDEFAULT);
				return;
			case MqPackage.MQ_QUEUE_MANAGER__QUEUE_MANAGER_STATUS:
				setQueueManagerStatus(QUEUE_MANAGER_STATUS_EDEFAULT);
				return;
			case MqPackage.MQ_QUEUE_MANAGER__QUEUE_MONITORING:
				setQueueMonitoring(QUEUE_MONITORING_EDEFAULT);
				return;
			case MqPackage.MQ_QUEUE_MANAGER__QUEUE_STATISTICS:
				setQueueStatistics(QUEUE_STATISTICS_EDEFAULT);
				return;
			case MqPackage.MQ_QUEUE_MANAGER__RECEIVE_TIMEOUT:
				setReceiveTimeout(RECEIVE_TIMEOUT_EDEFAULT);
				return;
			case MqPackage.MQ_QUEUE_MANAGER__RECEIVE_TIMEOUT_MIN:
				setReceiveTimeoutMin(RECEIVE_TIMEOUT_MIN_EDEFAULT);
				return;
			case MqPackage.MQ_QUEUE_MANAGER__RECEIVE_TIMEOUT_TYPE:
				setReceiveTimeoutType(RECEIVE_TIMEOUT_TYPE_EDEFAULT);
				return;
			case MqPackage.MQ_QUEUE_MANAGER__REMOTE_EVENT:
				setRemoteEvent(REMOTE_EVENT_EDEFAULT);
				return;
			case MqPackage.MQ_QUEUE_MANAGER__REPOSITORY_NAME:
				setRepositoryName(REPOSITORY_NAME_EDEFAULT);
				return;
			case MqPackage.MQ_QUEUE_MANAGER__REPOSITORY_NAME_LIST:
				setRepositoryNameList(REPOSITORY_NAME_LIST_EDEFAULT);
				return;
			case MqPackage.MQ_QUEUE_MANAGER__ROUTING_EXIT_CONNECT_TYPE:
				setRoutingExitConnectType(ROUTING_EXIT_CONNECT_TYPE_EDEFAULT);
				return;
			case MqPackage.MQ_QUEUE_MANAGER__ROUTING_EXIT_PATH:
				setRoutingExitPath(ROUTING_EXIT_PATH_EDEFAULT);
				return;
			case MqPackage.MQ_QUEUE_MANAGER__SECURITY_POLICY:
				setSecurityPolicy(SECURITY_POLICY_EDEFAULT);
				return;
			case MqPackage.MQ_QUEUE_MANAGER__SERVICE_ENTRY_POINTS:
				setServiceEntryPoints(SERVICE_ENTRY_POINTS_EDEFAULT);
				return;
			case MqPackage.MQ_QUEUE_MANAGER__SHARED_QQMGR_NAME:
				setSharedQQmgrName(SHARED_QQMGR_NAME_EDEFAULT);
				return;
			case MqPackage.MQ_QUEUE_MANAGER__SPX_BOARD_NUMBER:
				setSPXBoardNumber(SPX_BOARD_NUMBER_EDEFAULT);
				return;
			case MqPackage.MQ_QUEUE_MANAGER__SPX_KEEP_ALIVE:
				setSPXKeepAlive(SPX_KEEP_ALIVE_EDEFAULT);
				return;
			case MqPackage.MQ_QUEUE_MANAGER__SPX_LIBRARY1:
				setSPXLibrary1(SPX_LIBRARY1_EDEFAULT);
				return;
			case MqPackage.MQ_QUEUE_MANAGER__SPX_LIBRARY2:
				setSPXLibrary2(SPX_LIBRARY2_EDEFAULT);
				return;
			case MqPackage.MQ_QUEUE_MANAGER__SPX_SOCKET:
				setSPXSocket(SPX_SOCKET_EDEFAULT);
				return;
			case MqPackage.MQ_QUEUE_MANAGER__SSLCRL_NAME_LIST:
				setSSLCRLNameList(SSLCRL_NAME_LIST_EDEFAULT);
				return;
			case MqPackage.MQ_QUEUE_MANAGER__SSL_CRYTO_HARDWARE:
				setSSLCrytoHardware(SSL_CRYTO_HARDWARE_EDEFAULT);
				return;
			case MqPackage.MQ_QUEUE_MANAGER__SSL_EVENT:
				setSSLEvent(SSL_EVENT_EDEFAULT);
				return;
			case MqPackage.MQ_QUEUE_MANAGER__SSL_FIPS:
				setSSLFips(SSL_FIPS_EDEFAULT);
				return;
			case MqPackage.MQ_QUEUE_MANAGER__SSL_KEY_REPOSITORY:
				setSSLKeyRepository(SSL_KEY_REPOSITORY_EDEFAULT);
				return;
			case MqPackage.MQ_QUEUE_MANAGER__SSL_KEY_RESET_COUNT:
				setSSLKeyResetCount(SSL_KEY_RESET_COUNT_EDEFAULT);
				return;
			case MqPackage.MQ_QUEUE_MANAGER__SSL_TASKS:
				setSSLTasks(SSL_TASKS_EDEFAULT);
				return;
			case MqPackage.MQ_QUEUE_MANAGER__START_STOP_EVENT:
				setStartStopEvent(START_STOP_EVENT_EDEFAULT);
				return;
			case MqPackage.MQ_QUEUE_MANAGER__STATISTICS_INTERVAL:
				setStatisticsInterval(STATISTICS_INTERVAL_EDEFAULT);
				return;
			case MqPackage.MQ_QUEUE_MANAGER__SUPPRESED_MESSAGES:
				setSuppresedMessages(SUPPRESED_MESSAGES_EDEFAULT);
				return;
			case MqPackage.MQ_QUEUE_MANAGER__SUPPRESSED_MESSAGE_INTERVAL:
				setSuppressedMessageInterval(SUPPRESSED_MESSAGE_INTERVAL_EDEFAULT);
				return;
			case MqPackage.MQ_QUEUE_MANAGER__TCP_KEEP_ALIVE:
				setTCPKeepAlive(TCP_KEEP_ALIVE_EDEFAULT);
				return;
			case MqPackage.MQ_QUEUE_MANAGER__TCP_LIBRARY1:
				setTCPLibrary1(TCP_LIBRARY1_EDEFAULT);
				return;
			case MqPackage.MQ_QUEUE_MANAGER__TCP_LIBRARY2:
				setTCPLibrary2(TCP_LIBRARY2_EDEFAULT);
				return;
			case MqPackage.MQ_QUEUE_MANAGER__TCP_LISTENER_BACKLOG:
				setTCPListenerBacklog(TCP_LISTENER_BACKLOG_EDEFAULT);
				return;
			case MqPackage.MQ_QUEUE_MANAGER__TCP_NAME:
				setTCPName(TCP_NAME_EDEFAULT);
				return;
			case MqPackage.MQ_QUEUE_MANAGER__TCP_PORT:
				setTCPPort(TCP_PORT_EDEFAULT);
				return;
			case MqPackage.MQ_QUEUE_MANAGER__TCP_STACK_TYPE:
				setTCPStackType(TCP_STACK_TYPE_EDEFAULT);
				return;
			case MqPackage.MQ_QUEUE_MANAGER__TRACE_ROUTE_RECORDING:
				setTraceRouteRecording(TRACE_ROUTE_RECORDING_EDEFAULT);
				return;
			case MqPackage.MQ_QUEUE_MANAGER__TRIGGER_INTERVAL:
				setTriggerInterval(TRIGGER_INTERVAL_EDEFAULT);
				return;
			case MqPackage.MQ_QUEUE_MANAGER__WHAT_IF:
				setWhatIf(WHAT_IF_EDEFAULT);
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
			case MqPackage.MQ_QUEUE_MANAGER__ACCOUNTING_CONNECTION_OVERRIDE:
				return ACCOUNTING_CONNECTION_OVERRIDE_EDEFAULT == null ? accountingConnectionOverride != null : !ACCOUNTING_CONNECTION_OVERRIDE_EDEFAULT.equals(accountingConnectionOverride);
			case MqPackage.MQ_QUEUE_MANAGER__ACCOUNTING_INTERVAL:
				return ACCOUNTING_INTERVAL_EDEFAULT == null ? accountingInterval != null : !ACCOUNTING_INTERVAL_EDEFAULT.equals(accountingInterval);
			case MqPackage.MQ_QUEUE_MANAGER__ACTIVITY_RECORDING:
				return ACTIVITY_RECORDING_EDEFAULT == null ? activityRecording != null : !ACTIVITY_RECORDING_EDEFAULT.equals(activityRecording);
			case MqPackage.MQ_QUEUE_MANAGER__ADOPT_NEW_MCA:
				return ADOPT_NEW_MCA_EDEFAULT == null ? adoptNewMCA != null : !ADOPT_NEW_MCA_EDEFAULT.equals(adoptNewMCA);
			case MqPackage.MQ_QUEUE_MANAGER__ADOPT_NEW_MCA_CHECK:
				return ADOPT_NEW_MCA_CHECK_EDEFAULT == null ? adoptNewMCACheck != null : !ADOPT_NEW_MCA_CHECK_EDEFAULT.equals(adoptNewMCACheck);
			case MqPackage.MQ_QUEUE_MANAGER__ADOPT_NEW_MCA_TYPE:
				return ADOPT_NEW_MCA_TYPE_EDEFAULT == null ? adoptNewMCAType != null : !ADOPT_NEW_MCA_TYPE_EDEFAULT.equals(adoptNewMCAType);
			case MqPackage.MQ_QUEUE_MANAGER__AUTHORITY_EVENT:
				return AUTHORITY_EVENT_EDEFAULT == null ? authorityEvent != null : !AUTHORITY_EVENT_EDEFAULT.equals(authorityEvent);
			case MqPackage.MQ_QUEUE_MANAGER__AUTOMATIC:
				return AUTOMATIC_EDEFAULT == null ? automatic != null : !AUTOMATIC_EDEFAULT.equals(automatic);
			case MqPackage.MQ_QUEUE_MANAGER__BRIDGE_EVENT:
				return BRIDGE_EVENT_EDEFAULT == null ? bridgeEvent != null : !BRIDGE_EVENT_EDEFAULT.equals(bridgeEvent);
			case MqPackage.MQ_QUEUE_MANAGER__BROKER_MESSAGE_RETRY_COUNT:
				return BROKER_MESSAGE_RETRY_COUNT_EDEFAULT == null ? brokerMessageRetryCount != null : !BROKER_MESSAGE_RETRY_COUNT_EDEFAULT.equals(brokerMessageRetryCount);
			case MqPackage.MQ_QUEUE_MANAGER__BROKER_OPEN_CACHE_EXPIRY:
				return BROKER_OPEN_CACHE_EXPIRY_EDEFAULT == null ? brokerOpenCacheExpiry != null : !BROKER_OPEN_CACHE_EXPIRY_EDEFAULT.equals(brokerOpenCacheExpiry);
			case MqPackage.MQ_QUEUE_MANAGER__BROKER_OPEN_CACHE_SIZE:
				return BROKER_OPEN_CACHE_SIZE_EDEFAULT == null ? brokerOpenCacheSize != null : !BROKER_OPEN_CACHE_SIZE_EDEFAULT.equals(brokerOpenCacheSize);
			case MqPackage.MQ_QUEUE_MANAGER__BROKER_PUBLIC_BATCH_INTERVAL:
				return BROKER_PUBLIC_BATCH_INTERVAL_EDEFAULT == null ? brokerPublicBatchInterval != null : !BROKER_PUBLIC_BATCH_INTERVAL_EDEFAULT.equals(brokerPublicBatchInterval);
			case MqPackage.MQ_QUEUE_MANAGER__BROKER_PUBLISH_BATCH_SIZE:
				return BROKER_PUBLISH_BATCH_SIZE_EDEFAULT == null ? brokerPublishBatchSize != null : !BROKER_PUBLISH_BATCH_SIZE_EDEFAULT.equals(brokerPublishBatchSize);
			case MqPackage.MQ_QUEUE_MANAGER__BROKER_STREAMS_PER_PROCESS:
				return BROKER_STREAMS_PER_PROCESS_EDEFAULT == null ? brokerStreamsPerProcess != null : !BROKER_STREAMS_PER_PROCESS_EDEFAULT.equals(brokerStreamsPerProcess);
			case MqPackage.MQ_QUEUE_MANAGER__CHANNEL_AUTO_DEFINITION:
				return CHANNEL_AUTO_DEFINITION_EDEFAULT == null ? channelAutoDefinition != null : !CHANNEL_AUTO_DEFINITION_EDEFAULT.equals(channelAutoDefinition);
			case MqPackage.MQ_QUEUE_MANAGER__CHANNEL_AUTO_DEFINITION_EVENT:
				return CHANNEL_AUTO_DEFINITION_EVENT_EDEFAULT == null ? channelAutoDefinitionEvent != null : !CHANNEL_AUTO_DEFINITION_EVENT_EDEFAULT.equals(channelAutoDefinitionEvent);
			case MqPackage.MQ_QUEUE_MANAGER__CHANNEL_EVENT:
				return CHANNEL_EVENT_EDEFAULT == null ? channelEvent != null : !CHANNEL_EVENT_EDEFAULT.equals(channelEvent);
			case MqPackage.MQ_QUEUE_MANAGER__CHANNEL_INITIATOR_ADAPTERS:
				return CHANNEL_INITIATOR_ADAPTERS_EDEFAULT == null ? channelInitiatorAdapters != null : !CHANNEL_INITIATOR_ADAPTERS_EDEFAULT.equals(channelInitiatorAdapters);
			case MqPackage.MQ_QUEUE_MANAGER__CHANNEL_INITIATOR_CONTROL:
				return CHANNEL_INITIATOR_CONTROL_EDEFAULT == null ? channelInitiatorControl != null : !CHANNEL_INITIATOR_CONTROL_EDEFAULT.equals(channelInitiatorControl);
			case MqPackage.MQ_QUEUE_MANAGER__CHANNEL_INITIATOR_DISPATCHERS:
				return CHANNEL_INITIATOR_DISPATCHERS_EDEFAULT == null ? channelInitiatorDispatchers != null : !CHANNEL_INITIATOR_DISPATCHERS_EDEFAULT.equals(channelInitiatorDispatchers);
			case MqPackage.MQ_QUEUE_MANAGER__CHANNEL_INITIATOR_TRACE_AUTO_START:
				return CHANNEL_INITIATOR_TRACE_AUTO_START_EDEFAULT == null ? channelInitiatorTraceAutoStart != null : !CHANNEL_INITIATOR_TRACE_AUTO_START_EDEFAULT.equals(channelInitiatorTraceAutoStart);
			case MqPackage.MQ_QUEUE_MANAGER__CHANNEL_INITIATOR_TRACE_TABLE_SIZE:
				return CHANNEL_INITIATOR_TRACE_TABLE_SIZE_EDEFAULT == null ? channelInitiatorTraceTableSize != null : !CHANNEL_INITIATOR_TRACE_TABLE_SIZE_EDEFAULT.equals(channelInitiatorTraceTableSize);
			case MqPackage.MQ_QUEUE_MANAGER__CHANNEL_MONITORING:
				return CHANNEL_MONITORING_EDEFAULT == null ? channelMonitoring != null : !CHANNEL_MONITORING_EDEFAULT.equals(channelMonitoring);
			case MqPackage.MQ_QUEUE_MANAGER__CHANNEL_STATISTICS:
				return CHANNEL_STATISTICS_EDEFAULT == null ? channelStatistics != null : !CHANNEL_STATISTICS_EDEFAULT.equals(channelStatistics);
			case MqPackage.MQ_QUEUE_MANAGER__CHECKPOINT_ACTIVE_COUNT:
				return CHECKPOINT_ACTIVE_COUNT_EDEFAULT == null ? checkpointActiveCount != null : !CHECKPOINT_ACTIVE_COUNT_EDEFAULT.equals(checkpointActiveCount);
			case MqPackage.MQ_QUEUE_MANAGER__CHECKPOINT_MESSAGE_SIZE:
				return CHECKPOINT_MESSAGE_SIZE_EDEFAULT == null ? checkpointMessageSize != null : !CHECKPOINT_MESSAGE_SIZE_EDEFAULT.equals(checkpointMessageSize);
			case MqPackage.MQ_QUEUE_MANAGER__CHECKPOINT_RESTART_COUNT:
				return CHECKPOINT_RESTART_COUNT_EDEFAULT == null ? checkpointRestartCount != null : !CHECKPOINT_RESTART_COUNT_EDEFAULT.equals(checkpointRestartCount);
			case MqPackage.MQ_QUEUE_MANAGER__CLUSTER_SENDER_MONITORING:
				return CLUSTER_SENDER_MONITORING_EDEFAULT == null ? clusterSenderMonitoring != null : !CLUSTER_SENDER_MONITORING_EDEFAULT.equals(clusterSenderMonitoring);
			case MqPackage.MQ_QUEUE_MANAGER__CLUSTER_SENDER_STATISTICS:
				return CLUSTER_SENDER_STATISTICS_EDEFAULT == null ? clusterSenderStatistics != null : !CLUSTER_SENDER_STATISTICS_EDEFAULT.equals(clusterSenderStatistics);
			case MqPackage.MQ_QUEUE_MANAGER__CLUSTER_WORK_LOAD_DATA:
				return CLUSTER_WORK_LOAD_DATA_EDEFAULT == null ? clusterWorkLoadData != null : !CLUSTER_WORK_LOAD_DATA_EDEFAULT.equals(clusterWorkLoadData);
			case MqPackage.MQ_QUEUE_MANAGER__CLUSTER_WORK_LOAD_EXIT:
				return CLUSTER_WORK_LOAD_EXIT_EDEFAULT == null ? clusterWorkLoadExit != null : !CLUSTER_WORK_LOAD_EXIT_EDEFAULT.equals(clusterWorkLoadExit);
			case MqPackage.MQ_QUEUE_MANAGER__CLUSTER_WORK_LOAD_LENGTH:
				return CLUSTER_WORK_LOAD_LENGTH_EDEFAULT == null ? clusterWorkLoadLength != null : !CLUSTER_WORK_LOAD_LENGTH_EDEFAULT.equals(clusterWorkLoadLength);
			case MqPackage.MQ_QUEUE_MANAGER__CLUSTER_WORKLOAD_USE_Q:
				return CLUSTER_WORKLOAD_USE_Q_EDEFAULT == null ? clusterWorkloadUseQ != null : !CLUSTER_WORKLOAD_USE_Q_EDEFAULT.equals(clusterWorkloadUseQ);
			case MqPackage.MQ_QUEUE_MANAGER__CODED_CHAR_SET_ID:
				return CODED_CHAR_SET_ID_EDEFAULT == null ? codedCharSetId != null : !CODED_CHAR_SET_ID_EDEFAULT.equals(codedCharSetId);
			case MqPackage.MQ_QUEUE_MANAGER__COMMAND_EVENT:
				return COMMAND_EVENT_EDEFAULT == null ? commandEvent != null : !COMMAND_EVENT_EDEFAULT.equals(commandEvent);
			case MqPackage.MQ_QUEUE_MANAGER__COMMAND_LEVEL:
				return COMMAND_LEVEL_EDEFAULT == null ? commandLevel != null : !COMMAND_LEVEL_EDEFAULT.equals(commandLevel);
			case MqPackage.MQ_QUEUE_MANAGER__COMMAND_SCOPE:
				return COMMAND_SCOPE_EDEFAULT == null ? commandScope != null : !COMMAND_SCOPE_EDEFAULT.equals(commandScope);
			case MqPackage.MQ_QUEUE_MANAGER__COMMAND_SERVER_CONTROL:
				return COMMAND_SERVER_CONTROL_EDEFAULT == null ? commandServerControl != null : !COMMAND_SERVER_CONTROL_EDEFAULT.equals(commandServerControl);
			case MqPackage.MQ_QUEUE_MANAGER__CONFIGURATION_EVENT:
				return CONFIGURATION_EVENT_EDEFAULT == null ? configurationEvent != null : !CONFIGURATION_EVENT_EDEFAULT.equals(configurationEvent);
			case MqPackage.MQ_QUEUE_MANAGER__CONFIRM:
				return CONFIRM_EDEFAULT == null ? confirm != null : !CONFIRM_EDEFAULT.equals(confirm);
			case MqPackage.MQ_QUEUE_MANAGER__DEAD_LETTER_QUEUE:
				return DEAD_LETTER_QUEUE_EDEFAULT == null ? deadLetterQueue != null : !DEAD_LETTER_QUEUE_EDEFAULT.equals(deadLetterQueue);
			case MqPackage.MQ_QUEUE_MANAGER__DEFAULT_BIND_TYPE:
				return DEFAULT_BIND_TYPE_EDEFAULT == null ? defaultBindType != null : !DEFAULT_BIND_TYPE_EDEFAULT.equals(defaultBindType);
			case MqPackage.MQ_QUEUE_MANAGER__DEFAULT_TRANSMISSION_QUEUE:
				return DEFAULT_TRANSMISSION_QUEUE_EDEFAULT == null ? defaultTransmissionQueue != null : !DEFAULT_TRANSMISSION_QUEUE_EDEFAULT.equals(defaultTransmissionQueue);
			case MqPackage.MQ_QUEUE_MANAGER__DESCRIPTION1:
				return DESCRIPTION1_EDEFAULT == null ? description1 != null : !DESCRIPTION1_EDEFAULT.equals(description1);
			case MqPackage.MQ_QUEUE_MANAGER__DNS_GROUP:
				return DNS_GROUP_EDEFAULT == null ? dNSGroup != null : !DNS_GROUP_EDEFAULT.equals(dNSGroup);
			case MqPackage.MQ_QUEUE_MANAGER__DNSWLM:
				return DNSWLM_EDEFAULT == null ? dNSWLM != null : !DNSWLM_EDEFAULT.equals(dNSWLM);
			case MqPackage.MQ_QUEUE_MANAGER__ERROR_LOG_SIZE:
				return ERROR_LOG_SIZE_EDEFAULT == null ? errorLogSize != null : !ERROR_LOG_SIZE_EDEFAULT.equals(errorLogSize);
			case MqPackage.MQ_QUEUE_MANAGER__EXCLUDED_MESSAGES:
				return EXCLUDED_MESSAGES_EDEFAULT == null ? excludedMessages != null : !EXCLUDED_MESSAGES_EDEFAULT.equals(excludedMessages);
			case MqPackage.MQ_QUEUE_MANAGER__EXITS_DEFAULT_PATH:
				return EXITS_DEFAULT_PATH_EDEFAULT == null ? exitsDefaultPath != null : !EXITS_DEFAULT_PATH_EDEFAULT.equals(exitsDefaultPath);
			case MqPackage.MQ_QUEUE_MANAGER__EXPIRY_INTERVAL:
				return EXPIRY_INTERVAL_EDEFAULT == null ? expiryInterval != null : !EXPIRY_INTERVAL_EDEFAULT.equals(expiryInterval);
			case MqPackage.MQ_QUEUE_MANAGER__IGQ_PUT_AUTHORITY:
				return IGQ_PUT_AUTHORITY_EDEFAULT == null ? iGQPutAuthority != null : !IGQ_PUT_AUTHORITY_EDEFAULT.equals(iGQPutAuthority);
			case MqPackage.MQ_QUEUE_MANAGER__IGQ_USER_ID:
				return IGQ_USER_ID_EDEFAULT == null ? iGQUserId != null : !IGQ_USER_ID_EDEFAULT.equals(iGQUserId);
			case MqPackage.MQ_QUEUE_MANAGER__INHIBIT_EVENT:
				return INHIBIT_EVENT_EDEFAULT == null ? inhibitEvent != null : !INHIBIT_EVENT_EDEFAULT.equals(inhibitEvent);
			case MqPackage.MQ_QUEUE_MANAGER__INSTALLABLE_SERVICE_NAME:
				return INSTALLABLE_SERVICE_NAME_EDEFAULT == null ? installableServiceName != null : !INSTALLABLE_SERVICE_NAME_EDEFAULT.equals(installableServiceName);
			case MqPackage.MQ_QUEUE_MANAGER__INTRA_GROUP_QUEUING:
				return INTRA_GROUP_QUEUING_EDEFAULT == null ? intraGroupQueuing != null : !INTRA_GROUP_QUEUING_EDEFAULT.equals(intraGroupQueuing);
			case MqPackage.MQ_QUEUE_MANAGER__IP_ADDRESS_VERSION:
				return IP_ADDRESS_VERSION_EDEFAULT == null ? iPAddressVersion != null : !IP_ADDRESS_VERSION_EDEFAULT.equals(iPAddressVersion);
			case MqPackage.MQ_QUEUE_MANAGER__LISTENER_TIMER:
				return LISTENER_TIMER_EDEFAULT == null ? listenerTimer != null : !LISTENER_TIMER_EDEFAULT.equals(listenerTimer);
			case MqPackage.MQ_QUEUE_MANAGER__LOCAL_EVENT:
				return LOCAL_EVENT_EDEFAULT == null ? localEvent != null : !LOCAL_EVENT_EDEFAULT.equals(localEvent);
			case MqPackage.MQ_QUEUE_MANAGER__LOG_BUFFER_PAGES:
				return LOG_BUFFER_PAGES_EDEFAULT == null ? logBufferPages != null : !LOG_BUFFER_PAGES_EDEFAULT.equals(logBufferPages);
			case MqPackage.MQ_QUEUE_MANAGER__LOG_FILE_PAGES:
				return LOG_FILE_PAGES_EDEFAULT == null ? logFilePages != null : !LOG_FILE_PAGES_EDEFAULT.equals(logFilePages);
			case MqPackage.MQ_QUEUE_MANAGER__LOG_PATH:
				return LOG_PATH_EDEFAULT == null ? logPath != null : !LOG_PATH_EDEFAULT.equals(logPath);
			case MqPackage.MQ_QUEUE_MANAGER__LOG_PRIMARY_FILES:
				return LOG_PRIMARY_FILES_EDEFAULT == null ? logPrimaryFiles != null : !LOG_PRIMARY_FILES_EDEFAULT.equals(logPrimaryFiles);
			case MqPackage.MQ_QUEUE_MANAGER__LOG_SECONDARY_FILES:
				return LOG_SECONDARY_FILES_EDEFAULT == null ? logSecondaryFiles != null : !LOG_SECONDARY_FILES_EDEFAULT.equals(logSecondaryFiles);
			case MqPackage.MQ_QUEUE_MANAGER__LOG_TYPE:
				return LOG_TYPE_EDEFAULT == null ? logType != null : !LOG_TYPE_EDEFAULT.equals(logType);
			case MqPackage.MQ_QUEUE_MANAGER__LOG_WRITE_INTEGRITY:
				return LOG_WRITE_INTEGRITY_EDEFAULT == null ? logWriteIntegrity != null : !LOG_WRITE_INTEGRITY_EDEFAULT.equals(logWriteIntegrity);
			case MqPackage.MQ_QUEUE_MANAGER__LU62ARM_SUFFIX:
				return LU62ARM_SUFFIX_EDEFAULT == null ? lU62ARMSuffix != null : !LU62ARM_SUFFIX_EDEFAULT.equals(lU62ARMSuffix);
			case MqPackage.MQ_QUEUE_MANAGER__LU62_CHANNELS:
				return LU62_CHANNELS_EDEFAULT == null ? lU62Channels != null : !LU62_CHANNELS_EDEFAULT.equals(lU62Channels);
			case MqPackage.MQ_QUEUE_MANAGER__LU_GROUP_NAME:
				return LU_GROUP_NAME_EDEFAULT == null ? lUGroupName != null : !LU_GROUP_NAME_EDEFAULT.equals(lUGroupName);
			case MqPackage.MQ_QUEUE_MANAGER__LU_LIBRARY1:
				return LU_LIBRARY1_EDEFAULT == null ? lULibrary1 != null : !LU_LIBRARY1_EDEFAULT.equals(lULibrary1);
			case MqPackage.MQ_QUEUE_MANAGER__LU_LIBRARY2:
				return LU_LIBRARY2_EDEFAULT == null ? lULibrary2 != null : !LU_LIBRARY2_EDEFAULT.equals(lULibrary2);
			case MqPackage.MQ_QUEUE_MANAGER__LU_LOCAL_LU:
				return LU_LOCAL_LU_EDEFAULT == null ? lULocalLU != null : !LU_LOCAL_LU_EDEFAULT.equals(lULocalLU);
			case MqPackage.MQ_QUEUE_MANAGER__LU_NAME:
				return LU_NAME_EDEFAULT == null ? lUName != null : !LU_NAME_EDEFAULT.equals(lUName);
			case MqPackage.MQ_QUEUE_MANAGER__LUTP_NAME:
				return LUTP_NAME_EDEFAULT == null ? lUTPName != null : !LUTP_NAME_EDEFAULT.equals(lUTPName);
			case MqPackage.MQ_QUEUE_MANAGER__MAX_ACTIVE_CHANNELS:
				return MAX_ACTIVE_CHANNELS_EDEFAULT == null ? maxActiveChannels != null : !MAX_ACTIVE_CHANNELS_EDEFAULT.equals(maxActiveChannels);
			case MqPackage.MQ_QUEUE_MANAGER__MAX_CHANNELS:
				return MAX_CHANNELS_EDEFAULT == null ? maxChannels != null : !MAX_CHANNELS_EDEFAULT.equals(maxChannels);
			case MqPackage.MQ_QUEUE_MANAGER__MAXIMUM_CURRENT_CHANNELS:
				return MAXIMUM_CURRENT_CHANNELS_EDEFAULT == null ? maximumCurrentChannels != null : !MAXIMUM_CURRENT_CHANNELS_EDEFAULT.equals(maximumCurrentChannels);
			case MqPackage.MQ_QUEUE_MANAGER__MAXIMUM_HANDLES:
				return MAXIMUM_HANDLES_EDEFAULT == null ? maximumHandles != null : !MAXIMUM_HANDLES_EDEFAULT.equals(maximumHandles);
			case MqPackage.MQ_QUEUE_MANAGER__MAXIMUM_MESSAGE_LENGTH:
				return MAXIMUM_MESSAGE_LENGTH_EDEFAULT == null ? maximumMessageLength != null : !MAXIMUM_MESSAGE_LENGTH_EDEFAULT.equals(maximumMessageLength);
			case MqPackage.MQ_QUEUE_MANAGER__MAXIMUM_TCP_CHANNELS:
				return MAXIMUM_TCP_CHANNELS_EDEFAULT == null ? maximumTCPChannels != null : !MAXIMUM_TCP_CHANNELS_EDEFAULT.equals(maximumTCPChannels);
			case MqPackage.MQ_QUEUE_MANAGER__MAXIMUM_UNCOMMITTED_MESSAGES:
				return MAXIMUM_UNCOMMITTED_MESSAGES_EDEFAULT == null ? maximumUncommittedMessages != null : !MAXIMUM_UNCOMMITTED_MESSAGES_EDEFAULT.equals(maximumUncommittedMessages);
			case MqPackage.MQ_QUEUE_MANAGER__MAX_INITIATORS:
				return MAX_INITIATORS_EDEFAULT == null ? maxInitiators != null : !MAX_INITIATORS_EDEFAULT.equals(maxInitiators);
			case MqPackage.MQ_QUEUE_MANAGER__MQI_ACCOUNTING:
				return MQI_ACCOUNTING_EDEFAULT == null ? mQIAccounting != null : !MQI_ACCOUNTING_EDEFAULT.equals(mQIAccounting);
			case MqPackage.MQ_QUEUE_MANAGER__MQI_BIND_TYPE:
				return MQI_BIND_TYPE_EDEFAULT == null ? mQIBindType != null : !MQI_BIND_TYPE_EDEFAULT.equals(mQIBindType);
			case MqPackage.MQ_QUEUE_MANAGER__MQI_STATISTICS:
				return MQI_STATISTICS_EDEFAULT == null ? mQIStatistics != null : !MQI_STATISTICS_EDEFAULT.equals(mQIStatistics);
			case MqPackage.MQ_QUEUE_MANAGER__NET_BIOS_ADAPTOR_NUMBER:
				return NET_BIOS_ADAPTOR_NUMBER_EDEFAULT == null ? netBiosAdaptorNumber != null : !NET_BIOS_ADAPTOR_NUMBER_EDEFAULT.equals(netBiosAdaptorNumber);
			case MqPackage.MQ_QUEUE_MANAGER__NET_BIOS_LIBRARY1:
				return NET_BIOS_LIBRARY1_EDEFAULT == null ? netBiosLibrary1 != null : !NET_BIOS_LIBRARY1_EDEFAULT.equals(netBiosLibrary1);
			case MqPackage.MQ_QUEUE_MANAGER__NET_BIOS_LOCAL_NAME:
				return NET_BIOS_LOCAL_NAME_EDEFAULT == null ? netBiosLocalName != null : !NET_BIOS_LOCAL_NAME_EDEFAULT.equals(netBiosLocalName);
			case MqPackage.MQ_QUEUE_MANAGER__NET_BIOS_NUMBER_OF_COMMANDS:
				return NET_BIOS_NUMBER_OF_COMMANDS_EDEFAULT == null ? netBiosNumberOfCommands != null : !NET_BIOS_NUMBER_OF_COMMANDS_EDEFAULT.equals(netBiosNumberOfCommands);
			case MqPackage.MQ_QUEUE_MANAGER__NET_BIOS_NUMBER_OF_NAMES:
				return NET_BIOS_NUMBER_OF_NAMES_EDEFAULT == null ? netBiosNumberOfNames != null : !NET_BIOS_NUMBER_OF_NAMES_EDEFAULT.equals(netBiosNumberOfNames);
			case MqPackage.MQ_QUEUE_MANAGER__NET_BIOS_NUMBER_OF_SESSIONS:
				return NET_BIOS_NUMBER_OF_SESSIONS_EDEFAULT == null ? netBiosNumberOfSessions != null : !NET_BIOS_NUMBER_OF_SESSIONS_EDEFAULT.equals(netBiosNumberOfSessions);
			case MqPackage.MQ_QUEUE_MANAGER__OUTBOUND_PORT_MAX:
				return OUTBOUND_PORT_MAX_EDEFAULT == null ? outboundPortMax != null : !OUTBOUND_PORT_MAX_EDEFAULT.equals(outboundPortMax);
			case MqPackage.MQ_QUEUE_MANAGER__OUTBOUND_PORT_MIN:
				return OUTBOUND_PORT_MIN_EDEFAULT == null ? outboundPortMin != null : !OUTBOUND_PORT_MIN_EDEFAULT.equals(outboundPortMin);
			case MqPackage.MQ_QUEUE_MANAGER__PERFORMANCE_EVENT:
				return PERFORMANCE_EVENT_EDEFAULT == null ? performanceEvent != null : !PERFORMANCE_EVENT_EDEFAULT.equals(performanceEvent);
			case MqPackage.MQ_QUEUE_MANAGER__PIPE_LINE_LENGTH:
				return PIPE_LINE_LENGTH_EDEFAULT == null ? pipeLineLength != null : !PIPE_LINE_LENGTH_EDEFAULT.equals(pipeLineLength);
			case MqPackage.MQ_QUEUE_MANAGER__PLATFORM:
				return PLATFORM_EDEFAULT == null ? platform != null : !PLATFORM_EDEFAULT.equals(platform);
			case MqPackage.MQ_QUEUE_MANAGER__QUEUE_ACCOUNTING:
				return QUEUE_ACCOUNTING_EDEFAULT == null ? queueAccounting != null : !QUEUE_ACCOUNTING_EDEFAULT.equals(queueAccounting);
			case MqPackage.MQ_QUEUE_MANAGER__QUEUE_MANAGER_NAME:
				return QUEUE_MANAGER_NAME_EDEFAULT == null ? queueManagerName != null : !QUEUE_MANAGER_NAME_EDEFAULT.equals(queueManagerName);
			case MqPackage.MQ_QUEUE_MANAGER__QUEUE_MANAGER_STATUS:
				return QUEUE_MANAGER_STATUS_EDEFAULT == null ? queueManagerStatus != null : !QUEUE_MANAGER_STATUS_EDEFAULT.equals(queueManagerStatus);
			case MqPackage.MQ_QUEUE_MANAGER__QUEUE_MONITORING:
				return QUEUE_MONITORING_EDEFAULT == null ? queueMonitoring != null : !QUEUE_MONITORING_EDEFAULT.equals(queueMonitoring);
			case MqPackage.MQ_QUEUE_MANAGER__QUEUE_STATISTICS:
				return QUEUE_STATISTICS_EDEFAULT == null ? queueStatistics != null : !QUEUE_STATISTICS_EDEFAULT.equals(queueStatistics);
			case MqPackage.MQ_QUEUE_MANAGER__RECEIVE_TIMEOUT:
				return RECEIVE_TIMEOUT_EDEFAULT == null ? receiveTimeout != null : !RECEIVE_TIMEOUT_EDEFAULT.equals(receiveTimeout);
			case MqPackage.MQ_QUEUE_MANAGER__RECEIVE_TIMEOUT_MIN:
				return RECEIVE_TIMEOUT_MIN_EDEFAULT == null ? receiveTimeoutMin != null : !RECEIVE_TIMEOUT_MIN_EDEFAULT.equals(receiveTimeoutMin);
			case MqPackage.MQ_QUEUE_MANAGER__RECEIVE_TIMEOUT_TYPE:
				return RECEIVE_TIMEOUT_TYPE_EDEFAULT == null ? receiveTimeoutType != null : !RECEIVE_TIMEOUT_TYPE_EDEFAULT.equals(receiveTimeoutType);
			case MqPackage.MQ_QUEUE_MANAGER__REMOTE_EVENT:
				return REMOTE_EVENT_EDEFAULT == null ? remoteEvent != null : !REMOTE_EVENT_EDEFAULT.equals(remoteEvent);
			case MqPackage.MQ_QUEUE_MANAGER__REPOSITORY_NAME:
				return REPOSITORY_NAME_EDEFAULT == null ? repositoryName != null : !REPOSITORY_NAME_EDEFAULT.equals(repositoryName);
			case MqPackage.MQ_QUEUE_MANAGER__REPOSITORY_NAME_LIST:
				return REPOSITORY_NAME_LIST_EDEFAULT == null ? repositoryNameList != null : !REPOSITORY_NAME_LIST_EDEFAULT.equals(repositoryNameList);
			case MqPackage.MQ_QUEUE_MANAGER__ROUTING_EXIT_CONNECT_TYPE:
				return ROUTING_EXIT_CONNECT_TYPE_EDEFAULT == null ? routingExitConnectType != null : !ROUTING_EXIT_CONNECT_TYPE_EDEFAULT.equals(routingExitConnectType);
			case MqPackage.MQ_QUEUE_MANAGER__ROUTING_EXIT_PATH:
				return ROUTING_EXIT_PATH_EDEFAULT == null ? routingExitPath != null : !ROUTING_EXIT_PATH_EDEFAULT.equals(routingExitPath);
			case MqPackage.MQ_QUEUE_MANAGER__SECURITY_POLICY:
				return SECURITY_POLICY_EDEFAULT == null ? securityPolicy != null : !SECURITY_POLICY_EDEFAULT.equals(securityPolicy);
			case MqPackage.MQ_QUEUE_MANAGER__SERVICE_ENTRY_POINTS:
				return SERVICE_ENTRY_POINTS_EDEFAULT == null ? serviceEntryPoints != null : !SERVICE_ENTRY_POINTS_EDEFAULT.equals(serviceEntryPoints);
			case MqPackage.MQ_QUEUE_MANAGER__SHARED_QQMGR_NAME:
				return SHARED_QQMGR_NAME_EDEFAULT == null ? sharedQQmgrName != null : !SHARED_QQMGR_NAME_EDEFAULT.equals(sharedQQmgrName);
			case MqPackage.MQ_QUEUE_MANAGER__SPX_BOARD_NUMBER:
				return SPX_BOARD_NUMBER_EDEFAULT == null ? sPXBoardNumber != null : !SPX_BOARD_NUMBER_EDEFAULT.equals(sPXBoardNumber);
			case MqPackage.MQ_QUEUE_MANAGER__SPX_KEEP_ALIVE:
				return SPX_KEEP_ALIVE_EDEFAULT == null ? sPXKeepAlive != null : !SPX_KEEP_ALIVE_EDEFAULT.equals(sPXKeepAlive);
			case MqPackage.MQ_QUEUE_MANAGER__SPX_LIBRARY1:
				return SPX_LIBRARY1_EDEFAULT == null ? sPXLibrary1 != null : !SPX_LIBRARY1_EDEFAULT.equals(sPXLibrary1);
			case MqPackage.MQ_QUEUE_MANAGER__SPX_LIBRARY2:
				return SPX_LIBRARY2_EDEFAULT == null ? sPXLibrary2 != null : !SPX_LIBRARY2_EDEFAULT.equals(sPXLibrary2);
			case MqPackage.MQ_QUEUE_MANAGER__SPX_SOCKET:
				return SPX_SOCKET_EDEFAULT == null ? sPXSocket != null : !SPX_SOCKET_EDEFAULT.equals(sPXSocket);
			case MqPackage.MQ_QUEUE_MANAGER__SSLCRL_NAME_LIST:
				return SSLCRL_NAME_LIST_EDEFAULT == null ? sSLCRLNameList != null : !SSLCRL_NAME_LIST_EDEFAULT.equals(sSLCRLNameList);
			case MqPackage.MQ_QUEUE_MANAGER__SSL_CRYTO_HARDWARE:
				return SSL_CRYTO_HARDWARE_EDEFAULT == null ? sSLCrytoHardware != null : !SSL_CRYTO_HARDWARE_EDEFAULT.equals(sSLCrytoHardware);
			case MqPackage.MQ_QUEUE_MANAGER__SSL_EVENT:
				return SSL_EVENT_EDEFAULT == null ? sSLEvent != null : !SSL_EVENT_EDEFAULT.equals(sSLEvent);
			case MqPackage.MQ_QUEUE_MANAGER__SSL_FIPS:
				return SSL_FIPS_EDEFAULT == null ? sSLFips != null : !SSL_FIPS_EDEFAULT.equals(sSLFips);
			case MqPackage.MQ_QUEUE_MANAGER__SSL_KEY_REPOSITORY:
				return SSL_KEY_REPOSITORY_EDEFAULT == null ? sSLKeyRepository != null : !SSL_KEY_REPOSITORY_EDEFAULT.equals(sSLKeyRepository);
			case MqPackage.MQ_QUEUE_MANAGER__SSL_KEY_RESET_COUNT:
				return SSL_KEY_RESET_COUNT_EDEFAULT == null ? sSLKeyResetCount != null : !SSL_KEY_RESET_COUNT_EDEFAULT.equals(sSLKeyResetCount);
			case MqPackage.MQ_QUEUE_MANAGER__SSL_TASKS:
				return SSL_TASKS_EDEFAULT == null ? sSLTasks != null : !SSL_TASKS_EDEFAULT.equals(sSLTasks);
			case MqPackage.MQ_QUEUE_MANAGER__START_STOP_EVENT:
				return START_STOP_EVENT_EDEFAULT == null ? startStopEvent != null : !START_STOP_EVENT_EDEFAULT.equals(startStopEvent);
			case MqPackage.MQ_QUEUE_MANAGER__STATISTICS_INTERVAL:
				return STATISTICS_INTERVAL_EDEFAULT == null ? statisticsInterval != null : !STATISTICS_INTERVAL_EDEFAULT.equals(statisticsInterval);
			case MqPackage.MQ_QUEUE_MANAGER__SUPPRESED_MESSAGES:
				return SUPPRESED_MESSAGES_EDEFAULT == null ? suppresedMessages != null : !SUPPRESED_MESSAGES_EDEFAULT.equals(suppresedMessages);
			case MqPackage.MQ_QUEUE_MANAGER__SUPPRESSED_MESSAGE_INTERVAL:
				return SUPPRESSED_MESSAGE_INTERVAL_EDEFAULT == null ? suppressedMessageInterval != null : !SUPPRESSED_MESSAGE_INTERVAL_EDEFAULT.equals(suppressedMessageInterval);
			case MqPackage.MQ_QUEUE_MANAGER__TCP_KEEP_ALIVE:
				return TCP_KEEP_ALIVE_EDEFAULT == null ? tCPKeepAlive != null : !TCP_KEEP_ALIVE_EDEFAULT.equals(tCPKeepAlive);
			case MqPackage.MQ_QUEUE_MANAGER__TCP_LIBRARY1:
				return TCP_LIBRARY1_EDEFAULT == null ? tCPLibrary1 != null : !TCP_LIBRARY1_EDEFAULT.equals(tCPLibrary1);
			case MqPackage.MQ_QUEUE_MANAGER__TCP_LIBRARY2:
				return TCP_LIBRARY2_EDEFAULT == null ? tCPLibrary2 != null : !TCP_LIBRARY2_EDEFAULT.equals(tCPLibrary2);
			case MqPackage.MQ_QUEUE_MANAGER__TCP_LISTENER_BACKLOG:
				return TCP_LISTENER_BACKLOG_EDEFAULT == null ? tCPListenerBacklog != null : !TCP_LISTENER_BACKLOG_EDEFAULT.equals(tCPListenerBacklog);
			case MqPackage.MQ_QUEUE_MANAGER__TCP_NAME:
				return TCP_NAME_EDEFAULT == null ? tCPName != null : !TCP_NAME_EDEFAULT.equals(tCPName);
			case MqPackage.MQ_QUEUE_MANAGER__TCP_PORT:
				return TCP_PORT_EDEFAULT == null ? tCPPort != null : !TCP_PORT_EDEFAULT.equals(tCPPort);
			case MqPackage.MQ_QUEUE_MANAGER__TCP_STACK_TYPE:
				return TCP_STACK_TYPE_EDEFAULT == null ? tCPStackType != null : !TCP_STACK_TYPE_EDEFAULT.equals(tCPStackType);
			case MqPackage.MQ_QUEUE_MANAGER__TRACE_ROUTE_RECORDING:
				return TRACE_ROUTE_RECORDING_EDEFAULT == null ? traceRouteRecording != null : !TRACE_ROUTE_RECORDING_EDEFAULT.equals(traceRouteRecording);
			case MqPackage.MQ_QUEUE_MANAGER__TRIGGER_INTERVAL:
				return TRIGGER_INTERVAL_EDEFAULT == null ? triggerInterval != null : !TRIGGER_INTERVAL_EDEFAULT.equals(triggerInterval);
			case MqPackage.MQ_QUEUE_MANAGER__WHAT_IF:
				return WHAT_IF_EDEFAULT == null ? whatIf != null : !WHAT_IF_EDEFAULT.equals(whatIf);
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
		result.append(" (accountingConnectionOverride: "); //$NON-NLS-1$
		result.append(accountingConnectionOverride);
		result.append(", accountingInterval: "); //$NON-NLS-1$
		result.append(accountingInterval);
		result.append(", activityRecording: "); //$NON-NLS-1$
		result.append(activityRecording);
		result.append(", adoptNewMCA: "); //$NON-NLS-1$
		result.append(adoptNewMCA);
		result.append(", adoptNewMCACheck: "); //$NON-NLS-1$
		result.append(adoptNewMCACheck);
		result.append(", adoptNewMCAType: "); //$NON-NLS-1$
		result.append(adoptNewMCAType);
		result.append(", authorityEvent: "); //$NON-NLS-1$
		result.append(authorityEvent);
		result.append(", automatic: "); //$NON-NLS-1$
		result.append(automatic);
		result.append(", bridgeEvent: "); //$NON-NLS-1$
		result.append(bridgeEvent);
		result.append(", brokerMessageRetryCount: "); //$NON-NLS-1$
		result.append(brokerMessageRetryCount);
		result.append(", brokerOpenCacheExpiry: "); //$NON-NLS-1$
		result.append(brokerOpenCacheExpiry);
		result.append(", brokerOpenCacheSize: "); //$NON-NLS-1$
		result.append(brokerOpenCacheSize);
		result.append(", brokerPublicBatchInterval: "); //$NON-NLS-1$
		result.append(brokerPublicBatchInterval);
		result.append(", brokerPublishBatchSize: "); //$NON-NLS-1$
		result.append(brokerPublishBatchSize);
		result.append(", brokerStreamsPerProcess: "); //$NON-NLS-1$
		result.append(brokerStreamsPerProcess);
		result.append(", channelAutoDefinition: "); //$NON-NLS-1$
		result.append(channelAutoDefinition);
		result.append(", channelAutoDefinitionEvent: "); //$NON-NLS-1$
		result.append(channelAutoDefinitionEvent);
		result.append(", channelEvent: "); //$NON-NLS-1$
		result.append(channelEvent);
		result.append(", channelInitiatorAdapters: "); //$NON-NLS-1$
		result.append(channelInitiatorAdapters);
		result.append(", channelInitiatorControl: "); //$NON-NLS-1$
		result.append(channelInitiatorControl);
		result.append(", channelInitiatorDispatchers: "); //$NON-NLS-1$
		result.append(channelInitiatorDispatchers);
		result.append(", channelInitiatorTraceAutoStart: "); //$NON-NLS-1$
		result.append(channelInitiatorTraceAutoStart);
		result.append(", channelInitiatorTraceTableSize: "); //$NON-NLS-1$
		result.append(channelInitiatorTraceTableSize);
		result.append(", channelMonitoring: "); //$NON-NLS-1$
		result.append(channelMonitoring);
		result.append(", channelStatistics: "); //$NON-NLS-1$
		result.append(channelStatistics);
		result.append(", checkpointActiveCount: "); //$NON-NLS-1$
		result.append(checkpointActiveCount);
		result.append(", checkpointMessageSize: "); //$NON-NLS-1$
		result.append(checkpointMessageSize);
		result.append(", checkpointRestartCount: "); //$NON-NLS-1$
		result.append(checkpointRestartCount);
		result.append(", clusterSenderMonitoring: "); //$NON-NLS-1$
		result.append(clusterSenderMonitoring);
		result.append(", clusterSenderStatistics: "); //$NON-NLS-1$
		result.append(clusterSenderStatistics);
		result.append(", clusterWorkLoadData: "); //$NON-NLS-1$
		result.append(clusterWorkLoadData);
		result.append(", clusterWorkLoadExit: "); //$NON-NLS-1$
		result.append(clusterWorkLoadExit);
		result.append(", clusterWorkLoadLength: "); //$NON-NLS-1$
		result.append(clusterWorkLoadLength);
		result.append(", clusterWorkloadUseQ: "); //$NON-NLS-1$
		result.append(clusterWorkloadUseQ);
		result.append(", codedCharSetId: "); //$NON-NLS-1$
		result.append(codedCharSetId);
		result.append(", commandEvent: "); //$NON-NLS-1$
		result.append(commandEvent);
		result.append(", commandLevel: "); //$NON-NLS-1$
		result.append(commandLevel);
		result.append(", commandScope: "); //$NON-NLS-1$
		result.append(commandScope);
		result.append(", commandServerControl: "); //$NON-NLS-1$
		result.append(commandServerControl);
		result.append(", configurationEvent: "); //$NON-NLS-1$
		result.append(configurationEvent);
		result.append(", confirm: "); //$NON-NLS-1$
		result.append(confirm);
		result.append(", deadLetterQueue: "); //$NON-NLS-1$
		result.append(deadLetterQueue);
		result.append(", defaultBindType: "); //$NON-NLS-1$
		result.append(defaultBindType);
		result.append(", defaultTransmissionQueue: "); //$NON-NLS-1$
		result.append(defaultTransmissionQueue);
		result.append(", description1: "); //$NON-NLS-1$
		result.append(description1);
		result.append(", dNSGroup: "); //$NON-NLS-1$
		result.append(dNSGroup);
		result.append(", dNSWLM: "); //$NON-NLS-1$
		result.append(dNSWLM);
		result.append(", errorLogSize: "); //$NON-NLS-1$
		result.append(errorLogSize);
		result.append(", excludedMessages: "); //$NON-NLS-1$
		result.append(excludedMessages);
		result.append(", exitsDefaultPath: "); //$NON-NLS-1$
		result.append(exitsDefaultPath);
		result.append(", expiryInterval: "); //$NON-NLS-1$
		result.append(expiryInterval);
		result.append(", iGQPutAuthority: "); //$NON-NLS-1$
		result.append(iGQPutAuthority);
		result.append(", iGQUserId: "); //$NON-NLS-1$
		result.append(iGQUserId);
		result.append(", inhibitEvent: "); //$NON-NLS-1$
		result.append(inhibitEvent);
		result.append(", installableServiceName: "); //$NON-NLS-1$
		result.append(installableServiceName);
		result.append(", intraGroupQueuing: "); //$NON-NLS-1$
		result.append(intraGroupQueuing);
		result.append(", iPAddressVersion: "); //$NON-NLS-1$
		result.append(iPAddressVersion);
		result.append(", listenerTimer: "); //$NON-NLS-1$
		result.append(listenerTimer);
		result.append(", localEvent: "); //$NON-NLS-1$
		result.append(localEvent);
		result.append(", logBufferPages: "); //$NON-NLS-1$
		result.append(logBufferPages);
		result.append(", logFilePages: "); //$NON-NLS-1$
		result.append(logFilePages);
		result.append(", logPath: "); //$NON-NLS-1$
		result.append(logPath);
		result.append(", logPrimaryFiles: "); //$NON-NLS-1$
		result.append(logPrimaryFiles);
		result.append(", logSecondaryFiles: "); //$NON-NLS-1$
		result.append(logSecondaryFiles);
		result.append(", logType: "); //$NON-NLS-1$
		result.append(logType);
		result.append(", logWriteIntegrity: "); //$NON-NLS-1$
		result.append(logWriteIntegrity);
		result.append(", lU62ARMSuffix: "); //$NON-NLS-1$
		result.append(lU62ARMSuffix);
		result.append(", lU62Channels: "); //$NON-NLS-1$
		result.append(lU62Channels);
		result.append(", lUGroupName: "); //$NON-NLS-1$
		result.append(lUGroupName);
		result.append(", lULibrary1: "); //$NON-NLS-1$
		result.append(lULibrary1);
		result.append(", lULibrary2: "); //$NON-NLS-1$
		result.append(lULibrary2);
		result.append(", lULocalLU: "); //$NON-NLS-1$
		result.append(lULocalLU);
		result.append(", lUName: "); //$NON-NLS-1$
		result.append(lUName);
		result.append(", lUTPName: "); //$NON-NLS-1$
		result.append(lUTPName);
		result.append(", maxActiveChannels: "); //$NON-NLS-1$
		result.append(maxActiveChannels);
		result.append(", maxChannels: "); //$NON-NLS-1$
		result.append(maxChannels);
		result.append(", maximumCurrentChannels: "); //$NON-NLS-1$
		result.append(maximumCurrentChannels);
		result.append(", maximumHandles: "); //$NON-NLS-1$
		result.append(maximumHandles);
		result.append(", maximumMessageLength: "); //$NON-NLS-1$
		result.append(maximumMessageLength);
		result.append(", maximumTCPChannels: "); //$NON-NLS-1$
		result.append(maximumTCPChannels);
		result.append(", maximumUncommittedMessages: "); //$NON-NLS-1$
		result.append(maximumUncommittedMessages);
		result.append(", maxInitiators: "); //$NON-NLS-1$
		result.append(maxInitiators);
		result.append(", mQIAccounting: "); //$NON-NLS-1$
		result.append(mQIAccounting);
		result.append(", mQIBindType: "); //$NON-NLS-1$
		result.append(mQIBindType);
		result.append(", mQIStatistics: "); //$NON-NLS-1$
		result.append(mQIStatistics);
		result.append(", netBiosAdaptorNumber: "); //$NON-NLS-1$
		result.append(netBiosAdaptorNumber);
		result.append(", netBiosLibrary1: "); //$NON-NLS-1$
		result.append(netBiosLibrary1);
		result.append(", netBiosLocalName: "); //$NON-NLS-1$
		result.append(netBiosLocalName);
		result.append(", netBiosNumberOfCommands: "); //$NON-NLS-1$
		result.append(netBiosNumberOfCommands);
		result.append(", netBiosNumberOfNames: "); //$NON-NLS-1$
		result.append(netBiosNumberOfNames);
		result.append(", netBiosNumberOfSessions: "); //$NON-NLS-1$
		result.append(netBiosNumberOfSessions);
		result.append(", outboundPortMax: "); //$NON-NLS-1$
		result.append(outboundPortMax);
		result.append(", outboundPortMin: "); //$NON-NLS-1$
		result.append(outboundPortMin);
		result.append(", performanceEvent: "); //$NON-NLS-1$
		result.append(performanceEvent);
		result.append(", pipeLineLength: "); //$NON-NLS-1$
		result.append(pipeLineLength);
		result.append(", platform: "); //$NON-NLS-1$
		result.append(platform);
		result.append(", queueAccounting: "); //$NON-NLS-1$
		result.append(queueAccounting);
		result.append(", queueManagerName: "); //$NON-NLS-1$
		result.append(queueManagerName);
		result.append(", queueManagerStatus: "); //$NON-NLS-1$
		result.append(queueManagerStatus);
		result.append(", queueMonitoring: "); //$NON-NLS-1$
		result.append(queueMonitoring);
		result.append(", queueStatistics: "); //$NON-NLS-1$
		result.append(queueStatistics);
		result.append(", receiveTimeout: "); //$NON-NLS-1$
		result.append(receiveTimeout);
		result.append(", receiveTimeoutMin: "); //$NON-NLS-1$
		result.append(receiveTimeoutMin);
		result.append(", receiveTimeoutType: "); //$NON-NLS-1$
		result.append(receiveTimeoutType);
		result.append(", remoteEvent: "); //$NON-NLS-1$
		result.append(remoteEvent);
		result.append(", repositoryName: "); //$NON-NLS-1$
		result.append(repositoryName);
		result.append(", repositoryNameList: "); //$NON-NLS-1$
		result.append(repositoryNameList);
		result.append(", routingExitConnectType: "); //$NON-NLS-1$
		result.append(routingExitConnectType);
		result.append(", routingExitPath: "); //$NON-NLS-1$
		result.append(routingExitPath);
		result.append(", securityPolicy: "); //$NON-NLS-1$
		result.append(securityPolicy);
		result.append(", serviceEntryPoints: "); //$NON-NLS-1$
		result.append(serviceEntryPoints);
		result.append(", sharedQQmgrName: "); //$NON-NLS-1$
		result.append(sharedQQmgrName);
		result.append(", sPXBoardNumber: "); //$NON-NLS-1$
		result.append(sPXBoardNumber);
		result.append(", sPXKeepAlive: "); //$NON-NLS-1$
		result.append(sPXKeepAlive);
		result.append(", sPXLibrary1: "); //$NON-NLS-1$
		result.append(sPXLibrary1);
		result.append(", sPXLibrary2: "); //$NON-NLS-1$
		result.append(sPXLibrary2);
		result.append(", sPXSocket: "); //$NON-NLS-1$
		result.append(sPXSocket);
		result.append(", sSLCRLNameList: "); //$NON-NLS-1$
		result.append(sSLCRLNameList);
		result.append(", sSLCrytoHardware: "); //$NON-NLS-1$
		result.append(sSLCrytoHardware);
		result.append(", sSLEvent: "); //$NON-NLS-1$
		result.append(sSLEvent);
		result.append(", sSLFips: "); //$NON-NLS-1$
		result.append(sSLFips);
		result.append(", sSLKeyRepository: "); //$NON-NLS-1$
		result.append(sSLKeyRepository);
		result.append(", sSLKeyResetCount: "); //$NON-NLS-1$
		result.append(sSLKeyResetCount);
		result.append(", sSLTasks: "); //$NON-NLS-1$
		result.append(sSLTasks);
		result.append(", startStopEvent: "); //$NON-NLS-1$
		result.append(startStopEvent);
		result.append(", statisticsInterval: "); //$NON-NLS-1$
		result.append(statisticsInterval);
		result.append(", suppresedMessages: "); //$NON-NLS-1$
		result.append(suppresedMessages);
		result.append(", suppressedMessageInterval: "); //$NON-NLS-1$
		result.append(suppressedMessageInterval);
		result.append(", tCPKeepAlive: "); //$NON-NLS-1$
		result.append(tCPKeepAlive);
		result.append(", tCPLibrary1: "); //$NON-NLS-1$
		result.append(tCPLibrary1);
		result.append(", tCPLibrary2: "); //$NON-NLS-1$
		result.append(tCPLibrary2);
		result.append(", tCPListenerBacklog: "); //$NON-NLS-1$
		result.append(tCPListenerBacklog);
		result.append(", tCPName: "); //$NON-NLS-1$
		result.append(tCPName);
		result.append(", tCPPort: "); //$NON-NLS-1$
		result.append(tCPPort);
		result.append(", tCPStackType: "); //$NON-NLS-1$
		result.append(tCPStackType);
		result.append(", traceRouteRecording: "); //$NON-NLS-1$
		result.append(traceRouteRecording);
		result.append(", triggerInterval: "); //$NON-NLS-1$
		result.append(triggerInterval);
		result.append(", whatIf: "); //$NON-NLS-1$
		result.append(whatIf);
		result.append(')');
		return result.toString();
	}

} //MQQueueManagerImpl
