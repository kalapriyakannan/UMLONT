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
import com.ibm.ccl.soa.deploy.mq.MQQueue;
import com.ibm.ccl.soa.deploy.mq.MqPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>MQ Queue</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link com.ibm.ccl.soa.deploy.mq.impl.MQQueueImpl#getBackoutRequeueQueue <em>Backout Requeue Queue</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.mq.impl.MQQueueImpl#getBackoutThreshold <em>Backout Threshold</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.mq.impl.MQQueueImpl#getBaseQueue <em>Base Queue</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.mq.impl.MQQueueImpl#getBaseQueueName <em>Base Queue Name</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.mq.impl.MQQueueImpl#getCLWLQueuePriority <em>CLWL Queue Priority</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.mq.impl.MQQueueImpl#getCLWLQueueRank <em>CLWL Queue Rank</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.mq.impl.MQQueueImpl#getCLWLUQueue <em>CLWLU Queue</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.mq.impl.MQQueueImpl#getCouplingFacilityName <em>Coupling Facility Name</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.mq.impl.MQQueueImpl#getDefaultBindType <em>Default Bind Type</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.mq.impl.MQQueueImpl#getDefaultInputOpenOption <em>Default Input Open Option</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.mq.impl.MQQueueImpl#getDefaultPriority <em>Default Priority</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.mq.impl.MQQueueImpl#getDefinitionType <em>Definition Type</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.mq.impl.MQQueueImpl#getDescription1 <em>Description1</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.mq.impl.MQQueueImpl#getDistributionList <em>Distribution List</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.mq.impl.MQQueueImpl#getDistributionLists <em>Distribution Lists</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.mq.impl.MQQueueImpl#getGetMessages <em>Get Messages</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.mq.impl.MQQueueImpl#getHardenGetBackout <em>Harden Get Backout</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.mq.impl.MQQueueImpl#getInitiationQueue <em>Initiation Queue</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.mq.impl.MQQueueImpl#getMaxMessageLength <em>Max Message Length</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.mq.impl.MQQueueImpl#getMaxQueueDepth <em>Max Queue Depth</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.mq.impl.MQQueueImpl#getMessageDeliverySequence <em>Message Delivery Sequence</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.mq.impl.MQQueueImpl#getNotSharedInCluster <em>Not Shared In Cluster</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.mq.impl.MQQueueImpl#getNPMClass <em>NPM Class</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.mq.impl.MQQueueImpl#getPersistence <em>Persistence</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.mq.impl.MQQueueImpl#getProcessName <em>Process Name</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.mq.impl.MQQueueImpl#getPutMessage <em>Put Message</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.mq.impl.MQQueueImpl#getPutMessages <em>Put Messages</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.mq.impl.MQQueueImpl#getQSGDisposition <em>QSG Disposition</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.mq.impl.MQQueueImpl#getQueueAccounting <em>Queue Accounting</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.mq.impl.MQQueueImpl#getQueueDepthHighEvents <em>Queue Depth High Events</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.mq.impl.MQQueueImpl#getQueueDepthHighLimit <em>Queue Depth High Limit</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.mq.impl.MQQueueImpl#getQueueDepthLowEvents <em>Queue Depth Low Events</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.mq.impl.MQQueueImpl#getQueueDepthLowLimit <em>Queue Depth Low Limit</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.mq.impl.MQQueueImpl#getQueueDepthMaxEvents <em>Queue Depth Max Events</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.mq.impl.MQQueueImpl#getQueueMonitoring <em>Queue Monitoring</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.mq.impl.MQQueueImpl#getQueueName <em>Queue Name</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.mq.impl.MQQueueImpl#getQueueServiceInterval <em>Queue Service Interval</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.mq.impl.MQQueueImpl#getQueueServiceIntervalEvents <em>Queue Service Interval Events</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.mq.impl.MQQueueImpl#getQueueType <em>Queue Type</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.mq.impl.MQQueueImpl#getRemoteQueue <em>Remote Queue</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.mq.impl.MQQueueImpl#getRemoteQueueManager <em>Remote Queue Manager</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.mq.impl.MQQueueImpl#getRetentionInterval <em>Retention Interval</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.mq.impl.MQQueueImpl#getScope <em>Scope</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.mq.impl.MQQueueImpl#getShareability <em>Shareability</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.mq.impl.MQQueueImpl#getSharedInAListOfClusters <em>Shared In AList Of Clusters</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.mq.impl.MQQueueImpl#getSharedInCluster <em>Shared In Cluster</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.mq.impl.MQQueueImpl#getStatAlterationDate <em>Stat Alteration Date</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.mq.impl.MQQueueImpl#getStatAlterationTime <em>Stat Alteration Time</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.mq.impl.MQQueueImpl#getStatCreationDate <em>Stat Creation Date</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.mq.impl.MQQueueImpl#getStatCreationTime <em>Stat Creation Time</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.mq.impl.MQQueueImpl#getStatCurrentQueueDepth <em>Stat Current Queue Depth</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.mq.impl.MQQueueImpl#getStatOpenInputCount <em>Stat Open Input Count</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.mq.impl.MQQueueImpl#getStatOpenOutputCount <em>Stat Open Output Count</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.mq.impl.MQQueueImpl#getStatQueueMonitoring <em>Stat Queue Monitoring</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.mq.impl.MQQueueImpl#getStatQueueStatistics <em>Stat Queue Statistics</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.mq.impl.MQQueueImpl#getStorageClassName <em>Storage Class Name</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.mq.impl.MQQueueImpl#getTransmissionQueue <em>Transmission Queue</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.mq.impl.MQQueueImpl#getTriggerControl <em>Trigger Control</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.mq.impl.MQQueueImpl#getTriggerData <em>Trigger Data</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.mq.impl.MQQueueImpl#getTriggerDepth <em>Trigger Depth</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.mq.impl.MQQueueImpl#getTriggerMessagePriority <em>Trigger Message Priority</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.mq.impl.MQQueueImpl#getTriggerType <em>Trigger Type</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.mq.impl.MQQueueImpl#getUsage <em>Usage</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.mq.impl.MQQueueImpl#getUsage1 <em>Usage1</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class MQQueueImpl extends CapabilityImpl implements MQQueue {
	/**
	 * The default value of the '{@link #getBackoutRequeueQueue() <em>Backout Requeue Queue</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getBackoutRequeueQueue()
	 * @generated
	 * @ordered
	 */
	protected static final String BACKOUT_REQUEUE_QUEUE_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getBackoutRequeueQueue() <em>Backout Requeue Queue</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getBackoutRequeueQueue()
	 * @generated
	 * @ordered
	 */
	protected String backoutRequeueQueue = BACKOUT_REQUEUE_QUEUE_EDEFAULT;

	/**
	 * The default value of the '{@link #getBackoutThreshold() <em>Backout Threshold</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getBackoutThreshold()
	 * @generated
	 * @ordered
	 */
	protected static final String BACKOUT_THRESHOLD_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getBackoutThreshold() <em>Backout Threshold</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getBackoutThreshold()
	 * @generated
	 * @ordered
	 */
	protected String backoutThreshold = BACKOUT_THRESHOLD_EDEFAULT;

	/**
	 * The default value of the '{@link #getBaseQueue() <em>Base Queue</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getBaseQueue()
	 * @generated
	 * @ordered
	 */
	protected static final String BASE_QUEUE_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getBaseQueue() <em>Base Queue</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getBaseQueue()
	 * @generated
	 * @ordered
	 */
	protected String baseQueue = BASE_QUEUE_EDEFAULT;

	/**
	 * The default value of the '{@link #getBaseQueueName() <em>Base Queue Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getBaseQueueName()
	 * @generated
	 * @ordered
	 */
	protected static final String BASE_QUEUE_NAME_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getBaseQueueName() <em>Base Queue Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getBaseQueueName()
	 * @generated
	 * @ordered
	 */
	protected String baseQueueName = BASE_QUEUE_NAME_EDEFAULT;

	/**
	 * The default value of the '{@link #getCLWLQueuePriority() <em>CLWL Queue Priority</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getCLWLQueuePriority()
	 * @generated
	 * @ordered
	 */
	protected static final String CLWL_QUEUE_PRIORITY_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getCLWLQueuePriority() <em>CLWL Queue Priority</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getCLWLQueuePriority()
	 * @generated
	 * @ordered
	 */
	protected String cLWLQueuePriority = CLWL_QUEUE_PRIORITY_EDEFAULT;

	/**
	 * The default value of the '{@link #getCLWLQueueRank() <em>CLWL Queue Rank</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getCLWLQueueRank()
	 * @generated
	 * @ordered
	 */
	protected static final String CLWL_QUEUE_RANK_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getCLWLQueueRank() <em>CLWL Queue Rank</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getCLWLQueueRank()
	 * @generated
	 * @ordered
	 */
	protected String cLWLQueueRank = CLWL_QUEUE_RANK_EDEFAULT;

	/**
	 * The default value of the '{@link #getCLWLUQueue() <em>CLWLU Queue</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getCLWLUQueue()
	 * @generated
	 * @ordered
	 */
	protected static final String CLWLU_QUEUE_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getCLWLUQueue() <em>CLWLU Queue</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getCLWLUQueue()
	 * @generated
	 * @ordered
	 */
	protected String cLWLUQueue = CLWLU_QUEUE_EDEFAULT;

	/**
	 * The default value of the '{@link #getCouplingFacilityName() <em>Coupling Facility Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getCouplingFacilityName()
	 * @generated
	 * @ordered
	 */
	protected static final String COUPLING_FACILITY_NAME_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getCouplingFacilityName() <em>Coupling Facility Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getCouplingFacilityName()
	 * @generated
	 * @ordered
	 */
	protected String couplingFacilityName = COUPLING_FACILITY_NAME_EDEFAULT;

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
	 * The default value of the '{@link #getDefaultInputOpenOption() <em>Default Input Open Option</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDefaultInputOpenOption()
	 * @generated
	 * @ordered
	 */
	protected static final String DEFAULT_INPUT_OPEN_OPTION_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getDefaultInputOpenOption() <em>Default Input Open Option</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDefaultInputOpenOption()
	 * @generated
	 * @ordered
	 */
	protected String defaultInputOpenOption = DEFAULT_INPUT_OPEN_OPTION_EDEFAULT;

	/**
	 * The default value of the '{@link #getDefaultPriority() <em>Default Priority</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDefaultPriority()
	 * @generated
	 * @ordered
	 */
	protected static final String DEFAULT_PRIORITY_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getDefaultPriority() <em>Default Priority</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDefaultPriority()
	 * @generated
	 * @ordered
	 */
	protected String defaultPriority = DEFAULT_PRIORITY_EDEFAULT;

	/**
	 * The default value of the '{@link #getDefinitionType() <em>Definition Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDefinitionType()
	 * @generated
	 * @ordered
	 */
	protected static final String DEFINITION_TYPE_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getDefinitionType() <em>Definition Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDefinitionType()
	 * @generated
	 * @ordered
	 */
	protected String definitionType = DEFINITION_TYPE_EDEFAULT;

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
	 * The default value of the '{@link #getDistributionList() <em>Distribution List</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDistributionList()
	 * @generated
	 * @ordered
	 */
	protected static final String DISTRIBUTION_LIST_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getDistributionList() <em>Distribution List</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDistributionList()
	 * @generated
	 * @ordered
	 */
	protected String distributionList = DISTRIBUTION_LIST_EDEFAULT;

	/**
	 * The default value of the '{@link #getDistributionLists() <em>Distribution Lists</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDistributionLists()
	 * @generated
	 * @ordered
	 */
	protected static final String DISTRIBUTION_LISTS_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getDistributionLists() <em>Distribution Lists</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDistributionLists()
	 * @generated
	 * @ordered
	 */
	protected String distributionLists = DISTRIBUTION_LISTS_EDEFAULT;

	/**
	 * The default value of the '{@link #getGetMessages() <em>Get Messages</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getGetMessages()
	 * @generated
	 * @ordered
	 */
	protected static final String GET_MESSAGES_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getGetMessages() <em>Get Messages</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getGetMessages()
	 * @generated
	 * @ordered
	 */
	protected String getMessages = GET_MESSAGES_EDEFAULT;

	/**
	 * The default value of the '{@link #getHardenGetBackout() <em>Harden Get Backout</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getHardenGetBackout()
	 * @generated
	 * @ordered
	 */
	protected static final String HARDEN_GET_BACKOUT_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getHardenGetBackout() <em>Harden Get Backout</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getHardenGetBackout()
	 * @generated
	 * @ordered
	 */
	protected String hardenGetBackout = HARDEN_GET_BACKOUT_EDEFAULT;

	/**
	 * The default value of the '{@link #getInitiationQueue() <em>Initiation Queue</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getInitiationQueue()
	 * @generated
	 * @ordered
	 */
	protected static final String INITIATION_QUEUE_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getInitiationQueue() <em>Initiation Queue</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getInitiationQueue()
	 * @generated
	 * @ordered
	 */
	protected String initiationQueue = INITIATION_QUEUE_EDEFAULT;

	/**
	 * The default value of the '{@link #getMaxMessageLength() <em>Max Message Length</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getMaxMessageLength()
	 * @generated
	 * @ordered
	 */
	protected static final String MAX_MESSAGE_LENGTH_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getMaxMessageLength() <em>Max Message Length</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getMaxMessageLength()
	 * @generated
	 * @ordered
	 */
	protected String maxMessageLength = MAX_MESSAGE_LENGTH_EDEFAULT;

	/**
	 * The default value of the '{@link #getMaxQueueDepth() <em>Max Queue Depth</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getMaxQueueDepth()
	 * @generated
	 * @ordered
	 */
	protected static final String MAX_QUEUE_DEPTH_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getMaxQueueDepth() <em>Max Queue Depth</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getMaxQueueDepth()
	 * @generated
	 * @ordered
	 */
	protected String maxQueueDepth = MAX_QUEUE_DEPTH_EDEFAULT;

	/**
	 * The default value of the '{@link #getMessageDeliverySequence() <em>Message Delivery Sequence</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getMessageDeliverySequence()
	 * @generated
	 * @ordered
	 */
	protected static final String MESSAGE_DELIVERY_SEQUENCE_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getMessageDeliverySequence() <em>Message Delivery Sequence</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getMessageDeliverySequence()
	 * @generated
	 * @ordered
	 */
	protected String messageDeliverySequence = MESSAGE_DELIVERY_SEQUENCE_EDEFAULT;

	/**
	 * The default value of the '{@link #getNotSharedInCluster() <em>Not Shared In Cluster</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getNotSharedInCluster()
	 * @generated
	 * @ordered
	 */
	protected static final String NOT_SHARED_IN_CLUSTER_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getNotSharedInCluster() <em>Not Shared In Cluster</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getNotSharedInCluster()
	 * @generated
	 * @ordered
	 */
	protected String notSharedInCluster = NOT_SHARED_IN_CLUSTER_EDEFAULT;

	/**
	 * The default value of the '{@link #getNPMClass() <em>NPM Class</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getNPMClass()
	 * @generated
	 * @ordered
	 */
	protected static final String NPM_CLASS_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getNPMClass() <em>NPM Class</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getNPMClass()
	 * @generated
	 * @ordered
	 */
	protected String nPMClass = NPM_CLASS_EDEFAULT;

	/**
	 * The default value of the '{@link #getPersistence() <em>Persistence</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getPersistence()
	 * @generated
	 * @ordered
	 */
	protected static final String PERSISTENCE_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getPersistence() <em>Persistence</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getPersistence()
	 * @generated
	 * @ordered
	 */
	protected String persistence = PERSISTENCE_EDEFAULT;

	/**
	 * The default value of the '{@link #getProcessName() <em>Process Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getProcessName()
	 * @generated
	 * @ordered
	 */
	protected static final String PROCESS_NAME_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getProcessName() <em>Process Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getProcessName()
	 * @generated
	 * @ordered
	 */
	protected String processName = PROCESS_NAME_EDEFAULT;

	/**
	 * The default value of the '{@link #getPutMessage() <em>Put Message</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getPutMessage()
	 * @generated
	 * @ordered
	 */
	protected static final String PUT_MESSAGE_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getPutMessage() <em>Put Message</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getPutMessage()
	 * @generated
	 * @ordered
	 */
	protected String putMessage = PUT_MESSAGE_EDEFAULT;

	/**
	 * The default value of the '{@link #getPutMessages() <em>Put Messages</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getPutMessages()
	 * @generated
	 * @ordered
	 */
	protected static final String PUT_MESSAGES_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getPutMessages() <em>Put Messages</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getPutMessages()
	 * @generated
	 * @ordered
	 */
	protected String putMessages = PUT_MESSAGES_EDEFAULT;

	/**
	 * The default value of the '{@link #getQSGDisposition() <em>QSG Disposition</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getQSGDisposition()
	 * @generated
	 * @ordered
	 */
	protected static final String QSG_DISPOSITION_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getQSGDisposition() <em>QSG Disposition</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getQSGDisposition()
	 * @generated
	 * @ordered
	 */
	protected String qSGDisposition = QSG_DISPOSITION_EDEFAULT;

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
	 * The default value of the '{@link #getQueueDepthHighEvents() <em>Queue Depth High Events</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getQueueDepthHighEvents()
	 * @generated
	 * @ordered
	 */
	protected static final String QUEUE_DEPTH_HIGH_EVENTS_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getQueueDepthHighEvents() <em>Queue Depth High Events</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getQueueDepthHighEvents()
	 * @generated
	 * @ordered
	 */
	protected String queueDepthHighEvents = QUEUE_DEPTH_HIGH_EVENTS_EDEFAULT;

	/**
	 * The default value of the '{@link #getQueueDepthHighLimit() <em>Queue Depth High Limit</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getQueueDepthHighLimit()
	 * @generated
	 * @ordered
	 */
	protected static final String QUEUE_DEPTH_HIGH_LIMIT_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getQueueDepthHighLimit() <em>Queue Depth High Limit</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getQueueDepthHighLimit()
	 * @generated
	 * @ordered
	 */
	protected String queueDepthHighLimit = QUEUE_DEPTH_HIGH_LIMIT_EDEFAULT;

	/**
	 * The default value of the '{@link #getQueueDepthLowEvents() <em>Queue Depth Low Events</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getQueueDepthLowEvents()
	 * @generated
	 * @ordered
	 */
	protected static final String QUEUE_DEPTH_LOW_EVENTS_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getQueueDepthLowEvents() <em>Queue Depth Low Events</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getQueueDepthLowEvents()
	 * @generated
	 * @ordered
	 */
	protected String queueDepthLowEvents = QUEUE_DEPTH_LOW_EVENTS_EDEFAULT;

	/**
	 * The default value of the '{@link #getQueueDepthLowLimit() <em>Queue Depth Low Limit</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getQueueDepthLowLimit()
	 * @generated
	 * @ordered
	 */
	protected static final String QUEUE_DEPTH_LOW_LIMIT_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getQueueDepthLowLimit() <em>Queue Depth Low Limit</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getQueueDepthLowLimit()
	 * @generated
	 * @ordered
	 */
	protected String queueDepthLowLimit = QUEUE_DEPTH_LOW_LIMIT_EDEFAULT;

	/**
	 * The default value of the '{@link #getQueueDepthMaxEvents() <em>Queue Depth Max Events</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getQueueDepthMaxEvents()
	 * @generated
	 * @ordered
	 */
	protected static final String QUEUE_DEPTH_MAX_EVENTS_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getQueueDepthMaxEvents() <em>Queue Depth Max Events</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getQueueDepthMaxEvents()
	 * @generated
	 * @ordered
	 */
	protected String queueDepthMaxEvents = QUEUE_DEPTH_MAX_EVENTS_EDEFAULT;

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
	 * The default value of the '{@link #getQueueName() <em>Queue Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getQueueName()
	 * @generated
	 * @ordered
	 */
	protected static final String QUEUE_NAME_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getQueueName() <em>Queue Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getQueueName()
	 * @generated
	 * @ordered
	 */
	protected String queueName = QUEUE_NAME_EDEFAULT;

	/**
	 * The default value of the '{@link #getQueueServiceInterval() <em>Queue Service Interval</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getQueueServiceInterval()
	 * @generated
	 * @ordered
	 */
	protected static final String QUEUE_SERVICE_INTERVAL_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getQueueServiceInterval() <em>Queue Service Interval</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getQueueServiceInterval()
	 * @generated
	 * @ordered
	 */
	protected String queueServiceInterval = QUEUE_SERVICE_INTERVAL_EDEFAULT;

	/**
	 * The default value of the '{@link #getQueueServiceIntervalEvents() <em>Queue Service Interval Events</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getQueueServiceIntervalEvents()
	 * @generated
	 * @ordered
	 */
	protected static final String QUEUE_SERVICE_INTERVAL_EVENTS_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getQueueServiceIntervalEvents() <em>Queue Service Interval Events</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getQueueServiceIntervalEvents()
	 * @generated
	 * @ordered
	 */
	protected String queueServiceIntervalEvents = QUEUE_SERVICE_INTERVAL_EVENTS_EDEFAULT;

	/**
	 * The default value of the '{@link #getQueueType() <em>Queue Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getQueueType()
	 * @generated
	 * @ordered
	 */
	protected static final String QUEUE_TYPE_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getQueueType() <em>Queue Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getQueueType()
	 * @generated
	 * @ordered
	 */
	protected String queueType = QUEUE_TYPE_EDEFAULT;

	/**
	 * The default value of the '{@link #getRemoteQueue() <em>Remote Queue</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getRemoteQueue()
	 * @generated
	 * @ordered
	 */
	protected static final String REMOTE_QUEUE_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getRemoteQueue() <em>Remote Queue</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getRemoteQueue()
	 * @generated
	 * @ordered
	 */
	protected String remoteQueue = REMOTE_QUEUE_EDEFAULT;

	/**
	 * The default value of the '{@link #getRemoteQueueManager() <em>Remote Queue Manager</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getRemoteQueueManager()
	 * @generated
	 * @ordered
	 */
	protected static final String REMOTE_QUEUE_MANAGER_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getRemoteQueueManager() <em>Remote Queue Manager</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getRemoteQueueManager()
	 * @generated
	 * @ordered
	 */
	protected String remoteQueueManager = REMOTE_QUEUE_MANAGER_EDEFAULT;

	/**
	 * The default value of the '{@link #getRetentionInterval() <em>Retention Interval</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getRetentionInterval()
	 * @generated
	 * @ordered
	 */
	protected static final String RETENTION_INTERVAL_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getRetentionInterval() <em>Retention Interval</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getRetentionInterval()
	 * @generated
	 * @ordered
	 */
	protected String retentionInterval = RETENTION_INTERVAL_EDEFAULT;

	/**
	 * The default value of the '{@link #getScope() <em>Scope</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getScope()
	 * @generated
	 * @ordered
	 */
	protected static final String SCOPE_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getScope() <em>Scope</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getScope()
	 * @generated
	 * @ordered
	 */
	protected String scope = SCOPE_EDEFAULT;

	/**
	 * The default value of the '{@link #getShareability() <em>Shareability</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getShareability()
	 * @generated
	 * @ordered
	 */
	protected static final String SHAREABILITY_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getShareability() <em>Shareability</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getShareability()
	 * @generated
	 * @ordered
	 */
	protected String shareability = SHAREABILITY_EDEFAULT;

	/**
	 * The default value of the '{@link #getSharedInAListOfClusters() <em>Shared In AList Of Clusters</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSharedInAListOfClusters()
	 * @generated
	 * @ordered
	 */
	protected static final String SHARED_IN_ALIST_OF_CLUSTERS_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getSharedInAListOfClusters() <em>Shared In AList Of Clusters</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSharedInAListOfClusters()
	 * @generated
	 * @ordered
	 */
	protected String sharedInAListOfClusters = SHARED_IN_ALIST_OF_CLUSTERS_EDEFAULT;

	/**
	 * The default value of the '{@link #getSharedInCluster() <em>Shared In Cluster</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSharedInCluster()
	 * @generated
	 * @ordered
	 */
	protected static final String SHARED_IN_CLUSTER_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getSharedInCluster() <em>Shared In Cluster</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSharedInCluster()
	 * @generated
	 * @ordered
	 */
	protected String sharedInCluster = SHARED_IN_CLUSTER_EDEFAULT;

	/**
	 * The default value of the '{@link #getStatAlterationDate() <em>Stat Alteration Date</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getStatAlterationDate()
	 * @generated
	 * @ordered
	 */
	protected static final String STAT_ALTERATION_DATE_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getStatAlterationDate() <em>Stat Alteration Date</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getStatAlterationDate()
	 * @generated
	 * @ordered
	 */
	protected String statAlterationDate = STAT_ALTERATION_DATE_EDEFAULT;

	/**
	 * The default value of the '{@link #getStatAlterationTime() <em>Stat Alteration Time</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getStatAlterationTime()
	 * @generated
	 * @ordered
	 */
	protected static final String STAT_ALTERATION_TIME_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getStatAlterationTime() <em>Stat Alteration Time</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getStatAlterationTime()
	 * @generated
	 * @ordered
	 */
	protected String statAlterationTime = STAT_ALTERATION_TIME_EDEFAULT;

	/**
	 * The default value of the '{@link #getStatCreationDate() <em>Stat Creation Date</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getStatCreationDate()
	 * @generated
	 * @ordered
	 */
	protected static final String STAT_CREATION_DATE_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getStatCreationDate() <em>Stat Creation Date</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getStatCreationDate()
	 * @generated
	 * @ordered
	 */
	protected String statCreationDate = STAT_CREATION_DATE_EDEFAULT;

	/**
	 * The default value of the '{@link #getStatCreationTime() <em>Stat Creation Time</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getStatCreationTime()
	 * @generated
	 * @ordered
	 */
	protected static final String STAT_CREATION_TIME_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getStatCreationTime() <em>Stat Creation Time</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getStatCreationTime()
	 * @generated
	 * @ordered
	 */
	protected String statCreationTime = STAT_CREATION_TIME_EDEFAULT;

	/**
	 * The default value of the '{@link #getStatCurrentQueueDepth() <em>Stat Current Queue Depth</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getStatCurrentQueueDepth()
	 * @generated
	 * @ordered
	 */
	protected static final String STAT_CURRENT_QUEUE_DEPTH_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getStatCurrentQueueDepth() <em>Stat Current Queue Depth</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getStatCurrentQueueDepth()
	 * @generated
	 * @ordered
	 */
	protected String statCurrentQueueDepth = STAT_CURRENT_QUEUE_DEPTH_EDEFAULT;

	/**
	 * The default value of the '{@link #getStatOpenInputCount() <em>Stat Open Input Count</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getStatOpenInputCount()
	 * @generated
	 * @ordered
	 */
	protected static final String STAT_OPEN_INPUT_COUNT_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getStatOpenInputCount() <em>Stat Open Input Count</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getStatOpenInputCount()
	 * @generated
	 * @ordered
	 */
	protected String statOpenInputCount = STAT_OPEN_INPUT_COUNT_EDEFAULT;

	/**
	 * The default value of the '{@link #getStatOpenOutputCount() <em>Stat Open Output Count</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getStatOpenOutputCount()
	 * @generated
	 * @ordered
	 */
	protected static final String STAT_OPEN_OUTPUT_COUNT_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getStatOpenOutputCount() <em>Stat Open Output Count</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getStatOpenOutputCount()
	 * @generated
	 * @ordered
	 */
	protected String statOpenOutputCount = STAT_OPEN_OUTPUT_COUNT_EDEFAULT;

	/**
	 * The default value of the '{@link #getStatQueueMonitoring() <em>Stat Queue Monitoring</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getStatQueueMonitoring()
	 * @generated
	 * @ordered
	 */
	protected static final String STAT_QUEUE_MONITORING_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getStatQueueMonitoring() <em>Stat Queue Monitoring</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getStatQueueMonitoring()
	 * @generated
	 * @ordered
	 */
	protected String statQueueMonitoring = STAT_QUEUE_MONITORING_EDEFAULT;

	/**
	 * The default value of the '{@link #getStatQueueStatistics() <em>Stat Queue Statistics</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getStatQueueStatistics()
	 * @generated
	 * @ordered
	 */
	protected static final String STAT_QUEUE_STATISTICS_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getStatQueueStatistics() <em>Stat Queue Statistics</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getStatQueueStatistics()
	 * @generated
	 * @ordered
	 */
	protected String statQueueStatistics = STAT_QUEUE_STATISTICS_EDEFAULT;

	/**
	 * The default value of the '{@link #getStorageClassName() <em>Storage Class Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getStorageClassName()
	 * @generated
	 * @ordered
	 */
	protected static final String STORAGE_CLASS_NAME_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getStorageClassName() <em>Storage Class Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getStorageClassName()
	 * @generated
	 * @ordered
	 */
	protected String storageClassName = STORAGE_CLASS_NAME_EDEFAULT;

	/**
	 * The default value of the '{@link #getTransmissionQueue() <em>Transmission Queue</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTransmissionQueue()
	 * @generated
	 * @ordered
	 */
	protected static final String TRANSMISSION_QUEUE_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getTransmissionQueue() <em>Transmission Queue</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTransmissionQueue()
	 * @generated
	 * @ordered
	 */
	protected String transmissionQueue = TRANSMISSION_QUEUE_EDEFAULT;

	/**
	 * The default value of the '{@link #getTriggerControl() <em>Trigger Control</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTriggerControl()
	 * @generated
	 * @ordered
	 */
	protected static final String TRIGGER_CONTROL_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getTriggerControl() <em>Trigger Control</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTriggerControl()
	 * @generated
	 * @ordered
	 */
	protected String triggerControl = TRIGGER_CONTROL_EDEFAULT;

	/**
	 * The default value of the '{@link #getTriggerData() <em>Trigger Data</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTriggerData()
	 * @generated
	 * @ordered
	 */
	protected static final String TRIGGER_DATA_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getTriggerData() <em>Trigger Data</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTriggerData()
	 * @generated
	 * @ordered
	 */
	protected String triggerData = TRIGGER_DATA_EDEFAULT;

	/**
	 * The default value of the '{@link #getTriggerDepth() <em>Trigger Depth</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTriggerDepth()
	 * @generated
	 * @ordered
	 */
	protected static final String TRIGGER_DEPTH_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getTriggerDepth() <em>Trigger Depth</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTriggerDepth()
	 * @generated
	 * @ordered
	 */
	protected String triggerDepth = TRIGGER_DEPTH_EDEFAULT;

	/**
	 * The default value of the '{@link #getTriggerMessagePriority() <em>Trigger Message Priority</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTriggerMessagePriority()
	 * @generated
	 * @ordered
	 */
	protected static final String TRIGGER_MESSAGE_PRIORITY_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getTriggerMessagePriority() <em>Trigger Message Priority</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTriggerMessagePriority()
	 * @generated
	 * @ordered
	 */
	protected String triggerMessagePriority = TRIGGER_MESSAGE_PRIORITY_EDEFAULT;

	/**
	 * The default value of the '{@link #getTriggerType() <em>Trigger Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTriggerType()
	 * @generated
	 * @ordered
	 */
	protected static final String TRIGGER_TYPE_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getTriggerType() <em>Trigger Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTriggerType()
	 * @generated
	 * @ordered
	 */
	protected String triggerType = TRIGGER_TYPE_EDEFAULT;

	/**
	 * The default value of the '{@link #getUsage() <em>Usage</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getUsage()
	 * @generated
	 * @ordered
	 */
	protected static final String USAGE_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getUsage() <em>Usage</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getUsage()
	 * @generated
	 * @ordered
	 */
	protected String usage = USAGE_EDEFAULT;

	/**
	 * The default value of the '{@link #getUsage1() <em>Usage1</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getUsage1()
	 * @generated
	 * @ordered
	 */
	protected static final String USAGE1_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getUsage1() <em>Usage1</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getUsage1()
	 * @generated
	 * @ordered
	 */
	protected String usage1 = USAGE1_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected MQQueueImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected EClass eStaticClass() {
		return MqPackage.Literals.MQ_QUEUE;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getBackoutRequeueQueue() {
		return backoutRequeueQueue;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setBackoutRequeueQueue(String newBackoutRequeueQueue) {
		String oldBackoutRequeueQueue = backoutRequeueQueue;
		backoutRequeueQueue = newBackoutRequeueQueue;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, MqPackage.MQ_QUEUE__BACKOUT_REQUEUE_QUEUE, oldBackoutRequeueQueue, backoutRequeueQueue));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getBackoutThreshold() {
		return backoutThreshold;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setBackoutThreshold(String newBackoutThreshold) {
		String oldBackoutThreshold = backoutThreshold;
		backoutThreshold = newBackoutThreshold;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, MqPackage.MQ_QUEUE__BACKOUT_THRESHOLD, oldBackoutThreshold, backoutThreshold));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getBaseQueue() {
		return baseQueue;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setBaseQueue(String newBaseQueue) {
		String oldBaseQueue = baseQueue;
		baseQueue = newBaseQueue;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, MqPackage.MQ_QUEUE__BASE_QUEUE, oldBaseQueue, baseQueue));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getBaseQueueName() {
		return baseQueueName;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setBaseQueueName(String newBaseQueueName) {
		String oldBaseQueueName = baseQueueName;
		baseQueueName = newBaseQueueName;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, MqPackage.MQ_QUEUE__BASE_QUEUE_NAME, oldBaseQueueName, baseQueueName));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getCLWLQueuePriority() {
		return cLWLQueuePriority;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setCLWLQueuePriority(String newCLWLQueuePriority) {
		String oldCLWLQueuePriority = cLWLQueuePriority;
		cLWLQueuePriority = newCLWLQueuePriority;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, MqPackage.MQ_QUEUE__CLWL_QUEUE_PRIORITY, oldCLWLQueuePriority, cLWLQueuePriority));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getCLWLQueueRank() {
		return cLWLQueueRank;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setCLWLQueueRank(String newCLWLQueueRank) {
		String oldCLWLQueueRank = cLWLQueueRank;
		cLWLQueueRank = newCLWLQueueRank;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, MqPackage.MQ_QUEUE__CLWL_QUEUE_RANK, oldCLWLQueueRank, cLWLQueueRank));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getCLWLUQueue() {
		return cLWLUQueue;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setCLWLUQueue(String newCLWLUQueue) {
		String oldCLWLUQueue = cLWLUQueue;
		cLWLUQueue = newCLWLUQueue;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, MqPackage.MQ_QUEUE__CLWLU_QUEUE, oldCLWLUQueue, cLWLUQueue));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getCouplingFacilityName() {
		return couplingFacilityName;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setCouplingFacilityName(String newCouplingFacilityName) {
		String oldCouplingFacilityName = couplingFacilityName;
		couplingFacilityName = newCouplingFacilityName;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, MqPackage.MQ_QUEUE__COUPLING_FACILITY_NAME, oldCouplingFacilityName, couplingFacilityName));
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
			eNotify(new ENotificationImpl(this, Notification.SET, MqPackage.MQ_QUEUE__DEFAULT_BIND_TYPE, oldDefaultBindType, defaultBindType));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getDefaultInputOpenOption() {
		return defaultInputOpenOption;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setDefaultInputOpenOption(String newDefaultInputOpenOption) {
		String oldDefaultInputOpenOption = defaultInputOpenOption;
		defaultInputOpenOption = newDefaultInputOpenOption;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, MqPackage.MQ_QUEUE__DEFAULT_INPUT_OPEN_OPTION, oldDefaultInputOpenOption, defaultInputOpenOption));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getDefaultPriority() {
		return defaultPriority;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setDefaultPriority(String newDefaultPriority) {
		String oldDefaultPriority = defaultPriority;
		defaultPriority = newDefaultPriority;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, MqPackage.MQ_QUEUE__DEFAULT_PRIORITY, oldDefaultPriority, defaultPriority));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getDefinitionType() {
		return definitionType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setDefinitionType(String newDefinitionType) {
		String oldDefinitionType = definitionType;
		definitionType = newDefinitionType;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, MqPackage.MQ_QUEUE__DEFINITION_TYPE, oldDefinitionType, definitionType));
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
			eNotify(new ENotificationImpl(this, Notification.SET, MqPackage.MQ_QUEUE__DESCRIPTION1, oldDescription1, description1));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getDistributionList() {
		return distributionList;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setDistributionList(String newDistributionList) {
		String oldDistributionList = distributionList;
		distributionList = newDistributionList;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, MqPackage.MQ_QUEUE__DISTRIBUTION_LIST, oldDistributionList, distributionList));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getDistributionLists() {
		return distributionLists;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setDistributionLists(String newDistributionLists) {
		String oldDistributionLists = distributionLists;
		distributionLists = newDistributionLists;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, MqPackage.MQ_QUEUE__DISTRIBUTION_LISTS, oldDistributionLists, distributionLists));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getGetMessages() {
		return getMessages;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setGetMessages(String newGetMessages) {
		String oldGetMessages = getMessages;
		getMessages = newGetMessages;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, MqPackage.MQ_QUEUE__GET_MESSAGES, oldGetMessages, getMessages));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getHardenGetBackout() {
		return hardenGetBackout;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setHardenGetBackout(String newHardenGetBackout) {
		String oldHardenGetBackout = hardenGetBackout;
		hardenGetBackout = newHardenGetBackout;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, MqPackage.MQ_QUEUE__HARDEN_GET_BACKOUT, oldHardenGetBackout, hardenGetBackout));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getInitiationQueue() {
		return initiationQueue;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setInitiationQueue(String newInitiationQueue) {
		String oldInitiationQueue = initiationQueue;
		initiationQueue = newInitiationQueue;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, MqPackage.MQ_QUEUE__INITIATION_QUEUE, oldInitiationQueue, initiationQueue));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getMaxMessageLength() {
		return maxMessageLength;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setMaxMessageLength(String newMaxMessageLength) {
		String oldMaxMessageLength = maxMessageLength;
		maxMessageLength = newMaxMessageLength;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, MqPackage.MQ_QUEUE__MAX_MESSAGE_LENGTH, oldMaxMessageLength, maxMessageLength));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getMaxQueueDepth() {
		return maxQueueDepth;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setMaxQueueDepth(String newMaxQueueDepth) {
		String oldMaxQueueDepth = maxQueueDepth;
		maxQueueDepth = newMaxQueueDepth;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, MqPackage.MQ_QUEUE__MAX_QUEUE_DEPTH, oldMaxQueueDepth, maxQueueDepth));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getMessageDeliverySequence() {
		return messageDeliverySequence;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setMessageDeliverySequence(String newMessageDeliverySequence) {
		String oldMessageDeliverySequence = messageDeliverySequence;
		messageDeliverySequence = newMessageDeliverySequence;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, MqPackage.MQ_QUEUE__MESSAGE_DELIVERY_SEQUENCE, oldMessageDeliverySequence, messageDeliverySequence));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getNotSharedInCluster() {
		return notSharedInCluster;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setNotSharedInCluster(String newNotSharedInCluster) {
		String oldNotSharedInCluster = notSharedInCluster;
		notSharedInCluster = newNotSharedInCluster;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, MqPackage.MQ_QUEUE__NOT_SHARED_IN_CLUSTER, oldNotSharedInCluster, notSharedInCluster));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getNPMClass() {
		return nPMClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setNPMClass(String newNPMClass) {
		String oldNPMClass = nPMClass;
		nPMClass = newNPMClass;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, MqPackage.MQ_QUEUE__NPM_CLASS, oldNPMClass, nPMClass));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getPersistence() {
		return persistence;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setPersistence(String newPersistence) {
		String oldPersistence = persistence;
		persistence = newPersistence;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, MqPackage.MQ_QUEUE__PERSISTENCE, oldPersistence, persistence));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getProcessName() {
		return processName;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setProcessName(String newProcessName) {
		String oldProcessName = processName;
		processName = newProcessName;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, MqPackage.MQ_QUEUE__PROCESS_NAME, oldProcessName, processName));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getPutMessage() {
		return putMessage;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setPutMessage(String newPutMessage) {
		String oldPutMessage = putMessage;
		putMessage = newPutMessage;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, MqPackage.MQ_QUEUE__PUT_MESSAGE, oldPutMessage, putMessage));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getPutMessages() {
		return putMessages;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setPutMessages(String newPutMessages) {
		String oldPutMessages = putMessages;
		putMessages = newPutMessages;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, MqPackage.MQ_QUEUE__PUT_MESSAGES, oldPutMessages, putMessages));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getQSGDisposition() {
		return qSGDisposition;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setQSGDisposition(String newQSGDisposition) {
		String oldQSGDisposition = qSGDisposition;
		qSGDisposition = newQSGDisposition;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, MqPackage.MQ_QUEUE__QSG_DISPOSITION, oldQSGDisposition, qSGDisposition));
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
			eNotify(new ENotificationImpl(this, Notification.SET, MqPackage.MQ_QUEUE__QUEUE_ACCOUNTING, oldQueueAccounting, queueAccounting));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getQueueDepthHighEvents() {
		return queueDepthHighEvents;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setQueueDepthHighEvents(String newQueueDepthHighEvents) {
		String oldQueueDepthHighEvents = queueDepthHighEvents;
		queueDepthHighEvents = newQueueDepthHighEvents;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, MqPackage.MQ_QUEUE__QUEUE_DEPTH_HIGH_EVENTS, oldQueueDepthHighEvents, queueDepthHighEvents));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getQueueDepthHighLimit() {
		return queueDepthHighLimit;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setQueueDepthHighLimit(String newQueueDepthHighLimit) {
		String oldQueueDepthHighLimit = queueDepthHighLimit;
		queueDepthHighLimit = newQueueDepthHighLimit;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, MqPackage.MQ_QUEUE__QUEUE_DEPTH_HIGH_LIMIT, oldQueueDepthHighLimit, queueDepthHighLimit));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getQueueDepthLowEvents() {
		return queueDepthLowEvents;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setQueueDepthLowEvents(String newQueueDepthLowEvents) {
		String oldQueueDepthLowEvents = queueDepthLowEvents;
		queueDepthLowEvents = newQueueDepthLowEvents;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, MqPackage.MQ_QUEUE__QUEUE_DEPTH_LOW_EVENTS, oldQueueDepthLowEvents, queueDepthLowEvents));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getQueueDepthLowLimit() {
		return queueDepthLowLimit;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setQueueDepthLowLimit(String newQueueDepthLowLimit) {
		String oldQueueDepthLowLimit = queueDepthLowLimit;
		queueDepthLowLimit = newQueueDepthLowLimit;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, MqPackage.MQ_QUEUE__QUEUE_DEPTH_LOW_LIMIT, oldQueueDepthLowLimit, queueDepthLowLimit));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getQueueDepthMaxEvents() {
		return queueDepthMaxEvents;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setQueueDepthMaxEvents(String newQueueDepthMaxEvents) {
		String oldQueueDepthMaxEvents = queueDepthMaxEvents;
		queueDepthMaxEvents = newQueueDepthMaxEvents;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, MqPackage.MQ_QUEUE__QUEUE_DEPTH_MAX_EVENTS, oldQueueDepthMaxEvents, queueDepthMaxEvents));
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
			eNotify(new ENotificationImpl(this, Notification.SET, MqPackage.MQ_QUEUE__QUEUE_MONITORING, oldQueueMonitoring, queueMonitoring));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getQueueName() {
		return queueName;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setQueueName(String newQueueName) {
		String oldQueueName = queueName;
		queueName = newQueueName;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, MqPackage.MQ_QUEUE__QUEUE_NAME, oldQueueName, queueName));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getQueueServiceInterval() {
		return queueServiceInterval;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setQueueServiceInterval(String newQueueServiceInterval) {
		String oldQueueServiceInterval = queueServiceInterval;
		queueServiceInterval = newQueueServiceInterval;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, MqPackage.MQ_QUEUE__QUEUE_SERVICE_INTERVAL, oldQueueServiceInterval, queueServiceInterval));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getQueueServiceIntervalEvents() {
		return queueServiceIntervalEvents;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setQueueServiceIntervalEvents(String newQueueServiceIntervalEvents) {
		String oldQueueServiceIntervalEvents = queueServiceIntervalEvents;
		queueServiceIntervalEvents = newQueueServiceIntervalEvents;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, MqPackage.MQ_QUEUE__QUEUE_SERVICE_INTERVAL_EVENTS, oldQueueServiceIntervalEvents, queueServiceIntervalEvents));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getQueueType() {
		return queueType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setQueueType(String newQueueType) {
		String oldQueueType = queueType;
		queueType = newQueueType;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, MqPackage.MQ_QUEUE__QUEUE_TYPE, oldQueueType, queueType));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getRemoteQueue() {
		return remoteQueue;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setRemoteQueue(String newRemoteQueue) {
		String oldRemoteQueue = remoteQueue;
		remoteQueue = newRemoteQueue;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, MqPackage.MQ_QUEUE__REMOTE_QUEUE, oldRemoteQueue, remoteQueue));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getRemoteQueueManager() {
		return remoteQueueManager;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setRemoteQueueManager(String newRemoteQueueManager) {
		String oldRemoteQueueManager = remoteQueueManager;
		remoteQueueManager = newRemoteQueueManager;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, MqPackage.MQ_QUEUE__REMOTE_QUEUE_MANAGER, oldRemoteQueueManager, remoteQueueManager));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getRetentionInterval() {
		return retentionInterval;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setRetentionInterval(String newRetentionInterval) {
		String oldRetentionInterval = retentionInterval;
		retentionInterval = newRetentionInterval;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, MqPackage.MQ_QUEUE__RETENTION_INTERVAL, oldRetentionInterval, retentionInterval));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getScope() {
		return scope;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setScope(String newScope) {
		String oldScope = scope;
		scope = newScope;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, MqPackage.MQ_QUEUE__SCOPE, oldScope, scope));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getShareability() {
		return shareability;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setShareability(String newShareability) {
		String oldShareability = shareability;
		shareability = newShareability;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, MqPackage.MQ_QUEUE__SHAREABILITY, oldShareability, shareability));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getSharedInAListOfClusters() {
		return sharedInAListOfClusters;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setSharedInAListOfClusters(String newSharedInAListOfClusters) {
		String oldSharedInAListOfClusters = sharedInAListOfClusters;
		sharedInAListOfClusters = newSharedInAListOfClusters;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, MqPackage.MQ_QUEUE__SHARED_IN_ALIST_OF_CLUSTERS, oldSharedInAListOfClusters, sharedInAListOfClusters));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getSharedInCluster() {
		return sharedInCluster;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setSharedInCluster(String newSharedInCluster) {
		String oldSharedInCluster = sharedInCluster;
		sharedInCluster = newSharedInCluster;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, MqPackage.MQ_QUEUE__SHARED_IN_CLUSTER, oldSharedInCluster, sharedInCluster));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getStatAlterationDate() {
		return statAlterationDate;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setStatAlterationDate(String newStatAlterationDate) {
		String oldStatAlterationDate = statAlterationDate;
		statAlterationDate = newStatAlterationDate;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, MqPackage.MQ_QUEUE__STAT_ALTERATION_DATE, oldStatAlterationDate, statAlterationDate));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getStatAlterationTime() {
		return statAlterationTime;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setStatAlterationTime(String newStatAlterationTime) {
		String oldStatAlterationTime = statAlterationTime;
		statAlterationTime = newStatAlterationTime;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, MqPackage.MQ_QUEUE__STAT_ALTERATION_TIME, oldStatAlterationTime, statAlterationTime));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getStatCreationDate() {
		return statCreationDate;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setStatCreationDate(String newStatCreationDate) {
		String oldStatCreationDate = statCreationDate;
		statCreationDate = newStatCreationDate;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, MqPackage.MQ_QUEUE__STAT_CREATION_DATE, oldStatCreationDate, statCreationDate));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getStatCreationTime() {
		return statCreationTime;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setStatCreationTime(String newStatCreationTime) {
		String oldStatCreationTime = statCreationTime;
		statCreationTime = newStatCreationTime;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, MqPackage.MQ_QUEUE__STAT_CREATION_TIME, oldStatCreationTime, statCreationTime));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getStatCurrentQueueDepth() {
		return statCurrentQueueDepth;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setStatCurrentQueueDepth(String newStatCurrentQueueDepth) {
		String oldStatCurrentQueueDepth = statCurrentQueueDepth;
		statCurrentQueueDepth = newStatCurrentQueueDepth;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, MqPackage.MQ_QUEUE__STAT_CURRENT_QUEUE_DEPTH, oldStatCurrentQueueDepth, statCurrentQueueDepth));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getStatOpenInputCount() {
		return statOpenInputCount;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setStatOpenInputCount(String newStatOpenInputCount) {
		String oldStatOpenInputCount = statOpenInputCount;
		statOpenInputCount = newStatOpenInputCount;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, MqPackage.MQ_QUEUE__STAT_OPEN_INPUT_COUNT, oldStatOpenInputCount, statOpenInputCount));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getStatOpenOutputCount() {
		return statOpenOutputCount;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setStatOpenOutputCount(String newStatOpenOutputCount) {
		String oldStatOpenOutputCount = statOpenOutputCount;
		statOpenOutputCount = newStatOpenOutputCount;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, MqPackage.MQ_QUEUE__STAT_OPEN_OUTPUT_COUNT, oldStatOpenOutputCount, statOpenOutputCount));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getStatQueueMonitoring() {
		return statQueueMonitoring;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setStatQueueMonitoring(String newStatQueueMonitoring) {
		String oldStatQueueMonitoring = statQueueMonitoring;
		statQueueMonitoring = newStatQueueMonitoring;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, MqPackage.MQ_QUEUE__STAT_QUEUE_MONITORING, oldStatQueueMonitoring, statQueueMonitoring));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getStatQueueStatistics() {
		return statQueueStatistics;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setStatQueueStatistics(String newStatQueueStatistics) {
		String oldStatQueueStatistics = statQueueStatistics;
		statQueueStatistics = newStatQueueStatistics;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, MqPackage.MQ_QUEUE__STAT_QUEUE_STATISTICS, oldStatQueueStatistics, statQueueStatistics));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getStorageClassName() {
		return storageClassName;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setStorageClassName(String newStorageClassName) {
		String oldStorageClassName = storageClassName;
		storageClassName = newStorageClassName;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, MqPackage.MQ_QUEUE__STORAGE_CLASS_NAME, oldStorageClassName, storageClassName));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getTransmissionQueue() {
		return transmissionQueue;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setTransmissionQueue(String newTransmissionQueue) {
		String oldTransmissionQueue = transmissionQueue;
		transmissionQueue = newTransmissionQueue;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, MqPackage.MQ_QUEUE__TRANSMISSION_QUEUE, oldTransmissionQueue, transmissionQueue));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getTriggerControl() {
		return triggerControl;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setTriggerControl(String newTriggerControl) {
		String oldTriggerControl = triggerControl;
		triggerControl = newTriggerControl;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, MqPackage.MQ_QUEUE__TRIGGER_CONTROL, oldTriggerControl, triggerControl));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getTriggerData() {
		return triggerData;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setTriggerData(String newTriggerData) {
		String oldTriggerData = triggerData;
		triggerData = newTriggerData;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, MqPackage.MQ_QUEUE__TRIGGER_DATA, oldTriggerData, triggerData));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getTriggerDepth() {
		return triggerDepth;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setTriggerDepth(String newTriggerDepth) {
		String oldTriggerDepth = triggerDepth;
		triggerDepth = newTriggerDepth;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, MqPackage.MQ_QUEUE__TRIGGER_DEPTH, oldTriggerDepth, triggerDepth));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getTriggerMessagePriority() {
		return triggerMessagePriority;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setTriggerMessagePriority(String newTriggerMessagePriority) {
		String oldTriggerMessagePriority = triggerMessagePriority;
		triggerMessagePriority = newTriggerMessagePriority;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, MqPackage.MQ_QUEUE__TRIGGER_MESSAGE_PRIORITY, oldTriggerMessagePriority, triggerMessagePriority));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getTriggerType() {
		return triggerType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setTriggerType(String newTriggerType) {
		String oldTriggerType = triggerType;
		triggerType = newTriggerType;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, MqPackage.MQ_QUEUE__TRIGGER_TYPE, oldTriggerType, triggerType));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getUsage() {
		return usage;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setUsage(String newUsage) {
		String oldUsage = usage;
		usage = newUsage;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, MqPackage.MQ_QUEUE__USAGE, oldUsage, usage));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getUsage1() {
		return usage1;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setUsage1(String newUsage1) {
		String oldUsage1 = usage1;
		usage1 = newUsage1;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, MqPackage.MQ_QUEUE__USAGE1, oldUsage1, usage1));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case MqPackage.MQ_QUEUE__BACKOUT_REQUEUE_QUEUE:
				return getBackoutRequeueQueue();
			case MqPackage.MQ_QUEUE__BACKOUT_THRESHOLD:
				return getBackoutThreshold();
			case MqPackage.MQ_QUEUE__BASE_QUEUE:
				return getBaseQueue();
			case MqPackage.MQ_QUEUE__BASE_QUEUE_NAME:
				return getBaseQueueName();
			case MqPackage.MQ_QUEUE__CLWL_QUEUE_PRIORITY:
				return getCLWLQueuePriority();
			case MqPackage.MQ_QUEUE__CLWL_QUEUE_RANK:
				return getCLWLQueueRank();
			case MqPackage.MQ_QUEUE__CLWLU_QUEUE:
				return getCLWLUQueue();
			case MqPackage.MQ_QUEUE__COUPLING_FACILITY_NAME:
				return getCouplingFacilityName();
			case MqPackage.MQ_QUEUE__DEFAULT_BIND_TYPE:
				return getDefaultBindType();
			case MqPackage.MQ_QUEUE__DEFAULT_INPUT_OPEN_OPTION:
				return getDefaultInputOpenOption();
			case MqPackage.MQ_QUEUE__DEFAULT_PRIORITY:
				return getDefaultPriority();
			case MqPackage.MQ_QUEUE__DEFINITION_TYPE:
				return getDefinitionType();
			case MqPackage.MQ_QUEUE__DESCRIPTION1:
				return getDescription1();
			case MqPackage.MQ_QUEUE__DISTRIBUTION_LIST:
				return getDistributionList();
			case MqPackage.MQ_QUEUE__DISTRIBUTION_LISTS:
				return getDistributionLists();
			case MqPackage.MQ_QUEUE__GET_MESSAGES:
				return getGetMessages();
			case MqPackage.MQ_QUEUE__HARDEN_GET_BACKOUT:
				return getHardenGetBackout();
			case MqPackage.MQ_QUEUE__INITIATION_QUEUE:
				return getInitiationQueue();
			case MqPackage.MQ_QUEUE__MAX_MESSAGE_LENGTH:
				return getMaxMessageLength();
			case MqPackage.MQ_QUEUE__MAX_QUEUE_DEPTH:
				return getMaxQueueDepth();
			case MqPackage.MQ_QUEUE__MESSAGE_DELIVERY_SEQUENCE:
				return getMessageDeliverySequence();
			case MqPackage.MQ_QUEUE__NOT_SHARED_IN_CLUSTER:
				return getNotSharedInCluster();
			case MqPackage.MQ_QUEUE__NPM_CLASS:
				return getNPMClass();
			case MqPackage.MQ_QUEUE__PERSISTENCE:
				return getPersistence();
			case MqPackage.MQ_QUEUE__PROCESS_NAME:
				return getProcessName();
			case MqPackage.MQ_QUEUE__PUT_MESSAGE:
				return getPutMessage();
			case MqPackage.MQ_QUEUE__PUT_MESSAGES:
				return getPutMessages();
			case MqPackage.MQ_QUEUE__QSG_DISPOSITION:
				return getQSGDisposition();
			case MqPackage.MQ_QUEUE__QUEUE_ACCOUNTING:
				return getQueueAccounting();
			case MqPackage.MQ_QUEUE__QUEUE_DEPTH_HIGH_EVENTS:
				return getQueueDepthHighEvents();
			case MqPackage.MQ_QUEUE__QUEUE_DEPTH_HIGH_LIMIT:
				return getQueueDepthHighLimit();
			case MqPackage.MQ_QUEUE__QUEUE_DEPTH_LOW_EVENTS:
				return getQueueDepthLowEvents();
			case MqPackage.MQ_QUEUE__QUEUE_DEPTH_LOW_LIMIT:
				return getQueueDepthLowLimit();
			case MqPackage.MQ_QUEUE__QUEUE_DEPTH_MAX_EVENTS:
				return getQueueDepthMaxEvents();
			case MqPackage.MQ_QUEUE__QUEUE_MONITORING:
				return getQueueMonitoring();
			case MqPackage.MQ_QUEUE__QUEUE_NAME:
				return getQueueName();
			case MqPackage.MQ_QUEUE__QUEUE_SERVICE_INTERVAL:
				return getQueueServiceInterval();
			case MqPackage.MQ_QUEUE__QUEUE_SERVICE_INTERVAL_EVENTS:
				return getQueueServiceIntervalEvents();
			case MqPackage.MQ_QUEUE__QUEUE_TYPE:
				return getQueueType();
			case MqPackage.MQ_QUEUE__REMOTE_QUEUE:
				return getRemoteQueue();
			case MqPackage.MQ_QUEUE__REMOTE_QUEUE_MANAGER:
				return getRemoteQueueManager();
			case MqPackage.MQ_QUEUE__RETENTION_INTERVAL:
				return getRetentionInterval();
			case MqPackage.MQ_QUEUE__SCOPE:
				return getScope();
			case MqPackage.MQ_QUEUE__SHAREABILITY:
				return getShareability();
			case MqPackage.MQ_QUEUE__SHARED_IN_ALIST_OF_CLUSTERS:
				return getSharedInAListOfClusters();
			case MqPackage.MQ_QUEUE__SHARED_IN_CLUSTER:
				return getSharedInCluster();
			case MqPackage.MQ_QUEUE__STAT_ALTERATION_DATE:
				return getStatAlterationDate();
			case MqPackage.MQ_QUEUE__STAT_ALTERATION_TIME:
				return getStatAlterationTime();
			case MqPackage.MQ_QUEUE__STAT_CREATION_DATE:
				return getStatCreationDate();
			case MqPackage.MQ_QUEUE__STAT_CREATION_TIME:
				return getStatCreationTime();
			case MqPackage.MQ_QUEUE__STAT_CURRENT_QUEUE_DEPTH:
				return getStatCurrentQueueDepth();
			case MqPackage.MQ_QUEUE__STAT_OPEN_INPUT_COUNT:
				return getStatOpenInputCount();
			case MqPackage.MQ_QUEUE__STAT_OPEN_OUTPUT_COUNT:
				return getStatOpenOutputCount();
			case MqPackage.MQ_QUEUE__STAT_QUEUE_MONITORING:
				return getStatQueueMonitoring();
			case MqPackage.MQ_QUEUE__STAT_QUEUE_STATISTICS:
				return getStatQueueStatistics();
			case MqPackage.MQ_QUEUE__STORAGE_CLASS_NAME:
				return getStorageClassName();
			case MqPackage.MQ_QUEUE__TRANSMISSION_QUEUE:
				return getTransmissionQueue();
			case MqPackage.MQ_QUEUE__TRIGGER_CONTROL:
				return getTriggerControl();
			case MqPackage.MQ_QUEUE__TRIGGER_DATA:
				return getTriggerData();
			case MqPackage.MQ_QUEUE__TRIGGER_DEPTH:
				return getTriggerDepth();
			case MqPackage.MQ_QUEUE__TRIGGER_MESSAGE_PRIORITY:
				return getTriggerMessagePriority();
			case MqPackage.MQ_QUEUE__TRIGGER_TYPE:
				return getTriggerType();
			case MqPackage.MQ_QUEUE__USAGE:
				return getUsage();
			case MqPackage.MQ_QUEUE__USAGE1:
				return getUsage1();
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
			case MqPackage.MQ_QUEUE__BACKOUT_REQUEUE_QUEUE:
				setBackoutRequeueQueue((String)newValue);
				return;
			case MqPackage.MQ_QUEUE__BACKOUT_THRESHOLD:
				setBackoutThreshold((String)newValue);
				return;
			case MqPackage.MQ_QUEUE__BASE_QUEUE:
				setBaseQueue((String)newValue);
				return;
			case MqPackage.MQ_QUEUE__BASE_QUEUE_NAME:
				setBaseQueueName((String)newValue);
				return;
			case MqPackage.MQ_QUEUE__CLWL_QUEUE_PRIORITY:
				setCLWLQueuePriority((String)newValue);
				return;
			case MqPackage.MQ_QUEUE__CLWL_QUEUE_RANK:
				setCLWLQueueRank((String)newValue);
				return;
			case MqPackage.MQ_QUEUE__CLWLU_QUEUE:
				setCLWLUQueue((String)newValue);
				return;
			case MqPackage.MQ_QUEUE__COUPLING_FACILITY_NAME:
				setCouplingFacilityName((String)newValue);
				return;
			case MqPackage.MQ_QUEUE__DEFAULT_BIND_TYPE:
				setDefaultBindType((String)newValue);
				return;
			case MqPackage.MQ_QUEUE__DEFAULT_INPUT_OPEN_OPTION:
				setDefaultInputOpenOption((String)newValue);
				return;
			case MqPackage.MQ_QUEUE__DEFAULT_PRIORITY:
				setDefaultPriority((String)newValue);
				return;
			case MqPackage.MQ_QUEUE__DEFINITION_TYPE:
				setDefinitionType((String)newValue);
				return;
			case MqPackage.MQ_QUEUE__DESCRIPTION1:
				setDescription1((String)newValue);
				return;
			case MqPackage.MQ_QUEUE__DISTRIBUTION_LIST:
				setDistributionList((String)newValue);
				return;
			case MqPackage.MQ_QUEUE__DISTRIBUTION_LISTS:
				setDistributionLists((String)newValue);
				return;
			case MqPackage.MQ_QUEUE__GET_MESSAGES:
				setGetMessages((String)newValue);
				return;
			case MqPackage.MQ_QUEUE__HARDEN_GET_BACKOUT:
				setHardenGetBackout((String)newValue);
				return;
			case MqPackage.MQ_QUEUE__INITIATION_QUEUE:
				setInitiationQueue((String)newValue);
				return;
			case MqPackage.MQ_QUEUE__MAX_MESSAGE_LENGTH:
				setMaxMessageLength((String)newValue);
				return;
			case MqPackage.MQ_QUEUE__MAX_QUEUE_DEPTH:
				setMaxQueueDepth((String)newValue);
				return;
			case MqPackage.MQ_QUEUE__MESSAGE_DELIVERY_SEQUENCE:
				setMessageDeliverySequence((String)newValue);
				return;
			case MqPackage.MQ_QUEUE__NOT_SHARED_IN_CLUSTER:
				setNotSharedInCluster((String)newValue);
				return;
			case MqPackage.MQ_QUEUE__NPM_CLASS:
				setNPMClass((String)newValue);
				return;
			case MqPackage.MQ_QUEUE__PERSISTENCE:
				setPersistence((String)newValue);
				return;
			case MqPackage.MQ_QUEUE__PROCESS_NAME:
				setProcessName((String)newValue);
				return;
			case MqPackage.MQ_QUEUE__PUT_MESSAGE:
				setPutMessage((String)newValue);
				return;
			case MqPackage.MQ_QUEUE__PUT_MESSAGES:
				setPutMessages((String)newValue);
				return;
			case MqPackage.MQ_QUEUE__QSG_DISPOSITION:
				setQSGDisposition((String)newValue);
				return;
			case MqPackage.MQ_QUEUE__QUEUE_ACCOUNTING:
				setQueueAccounting((String)newValue);
				return;
			case MqPackage.MQ_QUEUE__QUEUE_DEPTH_HIGH_EVENTS:
				setQueueDepthHighEvents((String)newValue);
				return;
			case MqPackage.MQ_QUEUE__QUEUE_DEPTH_HIGH_LIMIT:
				setQueueDepthHighLimit((String)newValue);
				return;
			case MqPackage.MQ_QUEUE__QUEUE_DEPTH_LOW_EVENTS:
				setQueueDepthLowEvents((String)newValue);
				return;
			case MqPackage.MQ_QUEUE__QUEUE_DEPTH_LOW_LIMIT:
				setQueueDepthLowLimit((String)newValue);
				return;
			case MqPackage.MQ_QUEUE__QUEUE_DEPTH_MAX_EVENTS:
				setQueueDepthMaxEvents((String)newValue);
				return;
			case MqPackage.MQ_QUEUE__QUEUE_MONITORING:
				setQueueMonitoring((String)newValue);
				return;
			case MqPackage.MQ_QUEUE__QUEUE_NAME:
				setQueueName((String)newValue);
				return;
			case MqPackage.MQ_QUEUE__QUEUE_SERVICE_INTERVAL:
				setQueueServiceInterval((String)newValue);
				return;
			case MqPackage.MQ_QUEUE__QUEUE_SERVICE_INTERVAL_EVENTS:
				setQueueServiceIntervalEvents((String)newValue);
				return;
			case MqPackage.MQ_QUEUE__QUEUE_TYPE:
				setQueueType((String)newValue);
				return;
			case MqPackage.MQ_QUEUE__REMOTE_QUEUE:
				setRemoteQueue((String)newValue);
				return;
			case MqPackage.MQ_QUEUE__REMOTE_QUEUE_MANAGER:
				setRemoteQueueManager((String)newValue);
				return;
			case MqPackage.MQ_QUEUE__RETENTION_INTERVAL:
				setRetentionInterval((String)newValue);
				return;
			case MqPackage.MQ_QUEUE__SCOPE:
				setScope((String)newValue);
				return;
			case MqPackage.MQ_QUEUE__SHAREABILITY:
				setShareability((String)newValue);
				return;
			case MqPackage.MQ_QUEUE__SHARED_IN_ALIST_OF_CLUSTERS:
				setSharedInAListOfClusters((String)newValue);
				return;
			case MqPackage.MQ_QUEUE__SHARED_IN_CLUSTER:
				setSharedInCluster((String)newValue);
				return;
			case MqPackage.MQ_QUEUE__STAT_ALTERATION_DATE:
				setStatAlterationDate((String)newValue);
				return;
			case MqPackage.MQ_QUEUE__STAT_ALTERATION_TIME:
				setStatAlterationTime((String)newValue);
				return;
			case MqPackage.MQ_QUEUE__STAT_CREATION_DATE:
				setStatCreationDate((String)newValue);
				return;
			case MqPackage.MQ_QUEUE__STAT_CREATION_TIME:
				setStatCreationTime((String)newValue);
				return;
			case MqPackage.MQ_QUEUE__STAT_CURRENT_QUEUE_DEPTH:
				setStatCurrentQueueDepth((String)newValue);
				return;
			case MqPackage.MQ_QUEUE__STAT_OPEN_INPUT_COUNT:
				setStatOpenInputCount((String)newValue);
				return;
			case MqPackage.MQ_QUEUE__STAT_OPEN_OUTPUT_COUNT:
				setStatOpenOutputCount((String)newValue);
				return;
			case MqPackage.MQ_QUEUE__STAT_QUEUE_MONITORING:
				setStatQueueMonitoring((String)newValue);
				return;
			case MqPackage.MQ_QUEUE__STAT_QUEUE_STATISTICS:
				setStatQueueStatistics((String)newValue);
				return;
			case MqPackage.MQ_QUEUE__STORAGE_CLASS_NAME:
				setStorageClassName((String)newValue);
				return;
			case MqPackage.MQ_QUEUE__TRANSMISSION_QUEUE:
				setTransmissionQueue((String)newValue);
				return;
			case MqPackage.MQ_QUEUE__TRIGGER_CONTROL:
				setTriggerControl((String)newValue);
				return;
			case MqPackage.MQ_QUEUE__TRIGGER_DATA:
				setTriggerData((String)newValue);
				return;
			case MqPackage.MQ_QUEUE__TRIGGER_DEPTH:
				setTriggerDepth((String)newValue);
				return;
			case MqPackage.MQ_QUEUE__TRIGGER_MESSAGE_PRIORITY:
				setTriggerMessagePriority((String)newValue);
				return;
			case MqPackage.MQ_QUEUE__TRIGGER_TYPE:
				setTriggerType((String)newValue);
				return;
			case MqPackage.MQ_QUEUE__USAGE:
				setUsage((String)newValue);
				return;
			case MqPackage.MQ_QUEUE__USAGE1:
				setUsage1((String)newValue);
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
			case MqPackage.MQ_QUEUE__BACKOUT_REQUEUE_QUEUE:
				setBackoutRequeueQueue(BACKOUT_REQUEUE_QUEUE_EDEFAULT);
				return;
			case MqPackage.MQ_QUEUE__BACKOUT_THRESHOLD:
				setBackoutThreshold(BACKOUT_THRESHOLD_EDEFAULT);
				return;
			case MqPackage.MQ_QUEUE__BASE_QUEUE:
				setBaseQueue(BASE_QUEUE_EDEFAULT);
				return;
			case MqPackage.MQ_QUEUE__BASE_QUEUE_NAME:
				setBaseQueueName(BASE_QUEUE_NAME_EDEFAULT);
				return;
			case MqPackage.MQ_QUEUE__CLWL_QUEUE_PRIORITY:
				setCLWLQueuePriority(CLWL_QUEUE_PRIORITY_EDEFAULT);
				return;
			case MqPackage.MQ_QUEUE__CLWL_QUEUE_RANK:
				setCLWLQueueRank(CLWL_QUEUE_RANK_EDEFAULT);
				return;
			case MqPackage.MQ_QUEUE__CLWLU_QUEUE:
				setCLWLUQueue(CLWLU_QUEUE_EDEFAULT);
				return;
			case MqPackage.MQ_QUEUE__COUPLING_FACILITY_NAME:
				setCouplingFacilityName(COUPLING_FACILITY_NAME_EDEFAULT);
				return;
			case MqPackage.MQ_QUEUE__DEFAULT_BIND_TYPE:
				setDefaultBindType(DEFAULT_BIND_TYPE_EDEFAULT);
				return;
			case MqPackage.MQ_QUEUE__DEFAULT_INPUT_OPEN_OPTION:
				setDefaultInputOpenOption(DEFAULT_INPUT_OPEN_OPTION_EDEFAULT);
				return;
			case MqPackage.MQ_QUEUE__DEFAULT_PRIORITY:
				setDefaultPriority(DEFAULT_PRIORITY_EDEFAULT);
				return;
			case MqPackage.MQ_QUEUE__DEFINITION_TYPE:
				setDefinitionType(DEFINITION_TYPE_EDEFAULT);
				return;
			case MqPackage.MQ_QUEUE__DESCRIPTION1:
				setDescription1(DESCRIPTION1_EDEFAULT);
				return;
			case MqPackage.MQ_QUEUE__DISTRIBUTION_LIST:
				setDistributionList(DISTRIBUTION_LIST_EDEFAULT);
				return;
			case MqPackage.MQ_QUEUE__DISTRIBUTION_LISTS:
				setDistributionLists(DISTRIBUTION_LISTS_EDEFAULT);
				return;
			case MqPackage.MQ_QUEUE__GET_MESSAGES:
				setGetMessages(GET_MESSAGES_EDEFAULT);
				return;
			case MqPackage.MQ_QUEUE__HARDEN_GET_BACKOUT:
				setHardenGetBackout(HARDEN_GET_BACKOUT_EDEFAULT);
				return;
			case MqPackage.MQ_QUEUE__INITIATION_QUEUE:
				setInitiationQueue(INITIATION_QUEUE_EDEFAULT);
				return;
			case MqPackage.MQ_QUEUE__MAX_MESSAGE_LENGTH:
				setMaxMessageLength(MAX_MESSAGE_LENGTH_EDEFAULT);
				return;
			case MqPackage.MQ_QUEUE__MAX_QUEUE_DEPTH:
				setMaxQueueDepth(MAX_QUEUE_DEPTH_EDEFAULT);
				return;
			case MqPackage.MQ_QUEUE__MESSAGE_DELIVERY_SEQUENCE:
				setMessageDeliverySequence(MESSAGE_DELIVERY_SEQUENCE_EDEFAULT);
				return;
			case MqPackage.MQ_QUEUE__NOT_SHARED_IN_CLUSTER:
				setNotSharedInCluster(NOT_SHARED_IN_CLUSTER_EDEFAULT);
				return;
			case MqPackage.MQ_QUEUE__NPM_CLASS:
				setNPMClass(NPM_CLASS_EDEFAULT);
				return;
			case MqPackage.MQ_QUEUE__PERSISTENCE:
				setPersistence(PERSISTENCE_EDEFAULT);
				return;
			case MqPackage.MQ_QUEUE__PROCESS_NAME:
				setProcessName(PROCESS_NAME_EDEFAULT);
				return;
			case MqPackage.MQ_QUEUE__PUT_MESSAGE:
				setPutMessage(PUT_MESSAGE_EDEFAULT);
				return;
			case MqPackage.MQ_QUEUE__PUT_MESSAGES:
				setPutMessages(PUT_MESSAGES_EDEFAULT);
				return;
			case MqPackage.MQ_QUEUE__QSG_DISPOSITION:
				setQSGDisposition(QSG_DISPOSITION_EDEFAULT);
				return;
			case MqPackage.MQ_QUEUE__QUEUE_ACCOUNTING:
				setQueueAccounting(QUEUE_ACCOUNTING_EDEFAULT);
				return;
			case MqPackage.MQ_QUEUE__QUEUE_DEPTH_HIGH_EVENTS:
				setQueueDepthHighEvents(QUEUE_DEPTH_HIGH_EVENTS_EDEFAULT);
				return;
			case MqPackage.MQ_QUEUE__QUEUE_DEPTH_HIGH_LIMIT:
				setQueueDepthHighLimit(QUEUE_DEPTH_HIGH_LIMIT_EDEFAULT);
				return;
			case MqPackage.MQ_QUEUE__QUEUE_DEPTH_LOW_EVENTS:
				setQueueDepthLowEvents(QUEUE_DEPTH_LOW_EVENTS_EDEFAULT);
				return;
			case MqPackage.MQ_QUEUE__QUEUE_DEPTH_LOW_LIMIT:
				setQueueDepthLowLimit(QUEUE_DEPTH_LOW_LIMIT_EDEFAULT);
				return;
			case MqPackage.MQ_QUEUE__QUEUE_DEPTH_MAX_EVENTS:
				setQueueDepthMaxEvents(QUEUE_DEPTH_MAX_EVENTS_EDEFAULT);
				return;
			case MqPackage.MQ_QUEUE__QUEUE_MONITORING:
				setQueueMonitoring(QUEUE_MONITORING_EDEFAULT);
				return;
			case MqPackage.MQ_QUEUE__QUEUE_NAME:
				setQueueName(QUEUE_NAME_EDEFAULT);
				return;
			case MqPackage.MQ_QUEUE__QUEUE_SERVICE_INTERVAL:
				setQueueServiceInterval(QUEUE_SERVICE_INTERVAL_EDEFAULT);
				return;
			case MqPackage.MQ_QUEUE__QUEUE_SERVICE_INTERVAL_EVENTS:
				setQueueServiceIntervalEvents(QUEUE_SERVICE_INTERVAL_EVENTS_EDEFAULT);
				return;
			case MqPackage.MQ_QUEUE__QUEUE_TYPE:
				setQueueType(QUEUE_TYPE_EDEFAULT);
				return;
			case MqPackage.MQ_QUEUE__REMOTE_QUEUE:
				setRemoteQueue(REMOTE_QUEUE_EDEFAULT);
				return;
			case MqPackage.MQ_QUEUE__REMOTE_QUEUE_MANAGER:
				setRemoteQueueManager(REMOTE_QUEUE_MANAGER_EDEFAULT);
				return;
			case MqPackage.MQ_QUEUE__RETENTION_INTERVAL:
				setRetentionInterval(RETENTION_INTERVAL_EDEFAULT);
				return;
			case MqPackage.MQ_QUEUE__SCOPE:
				setScope(SCOPE_EDEFAULT);
				return;
			case MqPackage.MQ_QUEUE__SHAREABILITY:
				setShareability(SHAREABILITY_EDEFAULT);
				return;
			case MqPackage.MQ_QUEUE__SHARED_IN_ALIST_OF_CLUSTERS:
				setSharedInAListOfClusters(SHARED_IN_ALIST_OF_CLUSTERS_EDEFAULT);
				return;
			case MqPackage.MQ_QUEUE__SHARED_IN_CLUSTER:
				setSharedInCluster(SHARED_IN_CLUSTER_EDEFAULT);
				return;
			case MqPackage.MQ_QUEUE__STAT_ALTERATION_DATE:
				setStatAlterationDate(STAT_ALTERATION_DATE_EDEFAULT);
				return;
			case MqPackage.MQ_QUEUE__STAT_ALTERATION_TIME:
				setStatAlterationTime(STAT_ALTERATION_TIME_EDEFAULT);
				return;
			case MqPackage.MQ_QUEUE__STAT_CREATION_DATE:
				setStatCreationDate(STAT_CREATION_DATE_EDEFAULT);
				return;
			case MqPackage.MQ_QUEUE__STAT_CREATION_TIME:
				setStatCreationTime(STAT_CREATION_TIME_EDEFAULT);
				return;
			case MqPackage.MQ_QUEUE__STAT_CURRENT_QUEUE_DEPTH:
				setStatCurrentQueueDepth(STAT_CURRENT_QUEUE_DEPTH_EDEFAULT);
				return;
			case MqPackage.MQ_QUEUE__STAT_OPEN_INPUT_COUNT:
				setStatOpenInputCount(STAT_OPEN_INPUT_COUNT_EDEFAULT);
				return;
			case MqPackage.MQ_QUEUE__STAT_OPEN_OUTPUT_COUNT:
				setStatOpenOutputCount(STAT_OPEN_OUTPUT_COUNT_EDEFAULT);
				return;
			case MqPackage.MQ_QUEUE__STAT_QUEUE_MONITORING:
				setStatQueueMonitoring(STAT_QUEUE_MONITORING_EDEFAULT);
				return;
			case MqPackage.MQ_QUEUE__STAT_QUEUE_STATISTICS:
				setStatQueueStatistics(STAT_QUEUE_STATISTICS_EDEFAULT);
				return;
			case MqPackage.MQ_QUEUE__STORAGE_CLASS_NAME:
				setStorageClassName(STORAGE_CLASS_NAME_EDEFAULT);
				return;
			case MqPackage.MQ_QUEUE__TRANSMISSION_QUEUE:
				setTransmissionQueue(TRANSMISSION_QUEUE_EDEFAULT);
				return;
			case MqPackage.MQ_QUEUE__TRIGGER_CONTROL:
				setTriggerControl(TRIGGER_CONTROL_EDEFAULT);
				return;
			case MqPackage.MQ_QUEUE__TRIGGER_DATA:
				setTriggerData(TRIGGER_DATA_EDEFAULT);
				return;
			case MqPackage.MQ_QUEUE__TRIGGER_DEPTH:
				setTriggerDepth(TRIGGER_DEPTH_EDEFAULT);
				return;
			case MqPackage.MQ_QUEUE__TRIGGER_MESSAGE_PRIORITY:
				setTriggerMessagePriority(TRIGGER_MESSAGE_PRIORITY_EDEFAULT);
				return;
			case MqPackage.MQ_QUEUE__TRIGGER_TYPE:
				setTriggerType(TRIGGER_TYPE_EDEFAULT);
				return;
			case MqPackage.MQ_QUEUE__USAGE:
				setUsage(USAGE_EDEFAULT);
				return;
			case MqPackage.MQ_QUEUE__USAGE1:
				setUsage1(USAGE1_EDEFAULT);
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
			case MqPackage.MQ_QUEUE__BACKOUT_REQUEUE_QUEUE:
				return BACKOUT_REQUEUE_QUEUE_EDEFAULT == null ? backoutRequeueQueue != null : !BACKOUT_REQUEUE_QUEUE_EDEFAULT.equals(backoutRequeueQueue);
			case MqPackage.MQ_QUEUE__BACKOUT_THRESHOLD:
				return BACKOUT_THRESHOLD_EDEFAULT == null ? backoutThreshold != null : !BACKOUT_THRESHOLD_EDEFAULT.equals(backoutThreshold);
			case MqPackage.MQ_QUEUE__BASE_QUEUE:
				return BASE_QUEUE_EDEFAULT == null ? baseQueue != null : !BASE_QUEUE_EDEFAULT.equals(baseQueue);
			case MqPackage.MQ_QUEUE__BASE_QUEUE_NAME:
				return BASE_QUEUE_NAME_EDEFAULT == null ? baseQueueName != null : !BASE_QUEUE_NAME_EDEFAULT.equals(baseQueueName);
			case MqPackage.MQ_QUEUE__CLWL_QUEUE_PRIORITY:
				return CLWL_QUEUE_PRIORITY_EDEFAULT == null ? cLWLQueuePriority != null : !CLWL_QUEUE_PRIORITY_EDEFAULT.equals(cLWLQueuePriority);
			case MqPackage.MQ_QUEUE__CLWL_QUEUE_RANK:
				return CLWL_QUEUE_RANK_EDEFAULT == null ? cLWLQueueRank != null : !CLWL_QUEUE_RANK_EDEFAULT.equals(cLWLQueueRank);
			case MqPackage.MQ_QUEUE__CLWLU_QUEUE:
				return CLWLU_QUEUE_EDEFAULT == null ? cLWLUQueue != null : !CLWLU_QUEUE_EDEFAULT.equals(cLWLUQueue);
			case MqPackage.MQ_QUEUE__COUPLING_FACILITY_NAME:
				return COUPLING_FACILITY_NAME_EDEFAULT == null ? couplingFacilityName != null : !COUPLING_FACILITY_NAME_EDEFAULT.equals(couplingFacilityName);
			case MqPackage.MQ_QUEUE__DEFAULT_BIND_TYPE:
				return DEFAULT_BIND_TYPE_EDEFAULT == null ? defaultBindType != null : !DEFAULT_BIND_TYPE_EDEFAULT.equals(defaultBindType);
			case MqPackage.MQ_QUEUE__DEFAULT_INPUT_OPEN_OPTION:
				return DEFAULT_INPUT_OPEN_OPTION_EDEFAULT == null ? defaultInputOpenOption != null : !DEFAULT_INPUT_OPEN_OPTION_EDEFAULT.equals(defaultInputOpenOption);
			case MqPackage.MQ_QUEUE__DEFAULT_PRIORITY:
				return DEFAULT_PRIORITY_EDEFAULT == null ? defaultPriority != null : !DEFAULT_PRIORITY_EDEFAULT.equals(defaultPriority);
			case MqPackage.MQ_QUEUE__DEFINITION_TYPE:
				return DEFINITION_TYPE_EDEFAULT == null ? definitionType != null : !DEFINITION_TYPE_EDEFAULT.equals(definitionType);
			case MqPackage.MQ_QUEUE__DESCRIPTION1:
				return DESCRIPTION1_EDEFAULT == null ? description1 != null : !DESCRIPTION1_EDEFAULT.equals(description1);
			case MqPackage.MQ_QUEUE__DISTRIBUTION_LIST:
				return DISTRIBUTION_LIST_EDEFAULT == null ? distributionList != null : !DISTRIBUTION_LIST_EDEFAULT.equals(distributionList);
			case MqPackage.MQ_QUEUE__DISTRIBUTION_LISTS:
				return DISTRIBUTION_LISTS_EDEFAULT == null ? distributionLists != null : !DISTRIBUTION_LISTS_EDEFAULT.equals(distributionLists);
			case MqPackage.MQ_QUEUE__GET_MESSAGES:
				return GET_MESSAGES_EDEFAULT == null ? getMessages != null : !GET_MESSAGES_EDEFAULT.equals(getMessages);
			case MqPackage.MQ_QUEUE__HARDEN_GET_BACKOUT:
				return HARDEN_GET_BACKOUT_EDEFAULT == null ? hardenGetBackout != null : !HARDEN_GET_BACKOUT_EDEFAULT.equals(hardenGetBackout);
			case MqPackage.MQ_QUEUE__INITIATION_QUEUE:
				return INITIATION_QUEUE_EDEFAULT == null ? initiationQueue != null : !INITIATION_QUEUE_EDEFAULT.equals(initiationQueue);
			case MqPackage.MQ_QUEUE__MAX_MESSAGE_LENGTH:
				return MAX_MESSAGE_LENGTH_EDEFAULT == null ? maxMessageLength != null : !MAX_MESSAGE_LENGTH_EDEFAULT.equals(maxMessageLength);
			case MqPackage.MQ_QUEUE__MAX_QUEUE_DEPTH:
				return MAX_QUEUE_DEPTH_EDEFAULT == null ? maxQueueDepth != null : !MAX_QUEUE_DEPTH_EDEFAULT.equals(maxQueueDepth);
			case MqPackage.MQ_QUEUE__MESSAGE_DELIVERY_SEQUENCE:
				return MESSAGE_DELIVERY_SEQUENCE_EDEFAULT == null ? messageDeliverySequence != null : !MESSAGE_DELIVERY_SEQUENCE_EDEFAULT.equals(messageDeliverySequence);
			case MqPackage.MQ_QUEUE__NOT_SHARED_IN_CLUSTER:
				return NOT_SHARED_IN_CLUSTER_EDEFAULT == null ? notSharedInCluster != null : !NOT_SHARED_IN_CLUSTER_EDEFAULT.equals(notSharedInCluster);
			case MqPackage.MQ_QUEUE__NPM_CLASS:
				return NPM_CLASS_EDEFAULT == null ? nPMClass != null : !NPM_CLASS_EDEFAULT.equals(nPMClass);
			case MqPackage.MQ_QUEUE__PERSISTENCE:
				return PERSISTENCE_EDEFAULT == null ? persistence != null : !PERSISTENCE_EDEFAULT.equals(persistence);
			case MqPackage.MQ_QUEUE__PROCESS_NAME:
				return PROCESS_NAME_EDEFAULT == null ? processName != null : !PROCESS_NAME_EDEFAULT.equals(processName);
			case MqPackage.MQ_QUEUE__PUT_MESSAGE:
				return PUT_MESSAGE_EDEFAULT == null ? putMessage != null : !PUT_MESSAGE_EDEFAULT.equals(putMessage);
			case MqPackage.MQ_QUEUE__PUT_MESSAGES:
				return PUT_MESSAGES_EDEFAULT == null ? putMessages != null : !PUT_MESSAGES_EDEFAULT.equals(putMessages);
			case MqPackage.MQ_QUEUE__QSG_DISPOSITION:
				return QSG_DISPOSITION_EDEFAULT == null ? qSGDisposition != null : !QSG_DISPOSITION_EDEFAULT.equals(qSGDisposition);
			case MqPackage.MQ_QUEUE__QUEUE_ACCOUNTING:
				return QUEUE_ACCOUNTING_EDEFAULT == null ? queueAccounting != null : !QUEUE_ACCOUNTING_EDEFAULT.equals(queueAccounting);
			case MqPackage.MQ_QUEUE__QUEUE_DEPTH_HIGH_EVENTS:
				return QUEUE_DEPTH_HIGH_EVENTS_EDEFAULT == null ? queueDepthHighEvents != null : !QUEUE_DEPTH_HIGH_EVENTS_EDEFAULT.equals(queueDepthHighEvents);
			case MqPackage.MQ_QUEUE__QUEUE_DEPTH_HIGH_LIMIT:
				return QUEUE_DEPTH_HIGH_LIMIT_EDEFAULT == null ? queueDepthHighLimit != null : !QUEUE_DEPTH_HIGH_LIMIT_EDEFAULT.equals(queueDepthHighLimit);
			case MqPackage.MQ_QUEUE__QUEUE_DEPTH_LOW_EVENTS:
				return QUEUE_DEPTH_LOW_EVENTS_EDEFAULT == null ? queueDepthLowEvents != null : !QUEUE_DEPTH_LOW_EVENTS_EDEFAULT.equals(queueDepthLowEvents);
			case MqPackage.MQ_QUEUE__QUEUE_DEPTH_LOW_LIMIT:
				return QUEUE_DEPTH_LOW_LIMIT_EDEFAULT == null ? queueDepthLowLimit != null : !QUEUE_DEPTH_LOW_LIMIT_EDEFAULT.equals(queueDepthLowLimit);
			case MqPackage.MQ_QUEUE__QUEUE_DEPTH_MAX_EVENTS:
				return QUEUE_DEPTH_MAX_EVENTS_EDEFAULT == null ? queueDepthMaxEvents != null : !QUEUE_DEPTH_MAX_EVENTS_EDEFAULT.equals(queueDepthMaxEvents);
			case MqPackage.MQ_QUEUE__QUEUE_MONITORING:
				return QUEUE_MONITORING_EDEFAULT == null ? queueMonitoring != null : !QUEUE_MONITORING_EDEFAULT.equals(queueMonitoring);
			case MqPackage.MQ_QUEUE__QUEUE_NAME:
				return QUEUE_NAME_EDEFAULT == null ? queueName != null : !QUEUE_NAME_EDEFAULT.equals(queueName);
			case MqPackage.MQ_QUEUE__QUEUE_SERVICE_INTERVAL:
				return QUEUE_SERVICE_INTERVAL_EDEFAULT == null ? queueServiceInterval != null : !QUEUE_SERVICE_INTERVAL_EDEFAULT.equals(queueServiceInterval);
			case MqPackage.MQ_QUEUE__QUEUE_SERVICE_INTERVAL_EVENTS:
				return QUEUE_SERVICE_INTERVAL_EVENTS_EDEFAULT == null ? queueServiceIntervalEvents != null : !QUEUE_SERVICE_INTERVAL_EVENTS_EDEFAULT.equals(queueServiceIntervalEvents);
			case MqPackage.MQ_QUEUE__QUEUE_TYPE:
				return QUEUE_TYPE_EDEFAULT == null ? queueType != null : !QUEUE_TYPE_EDEFAULT.equals(queueType);
			case MqPackage.MQ_QUEUE__REMOTE_QUEUE:
				return REMOTE_QUEUE_EDEFAULT == null ? remoteQueue != null : !REMOTE_QUEUE_EDEFAULT.equals(remoteQueue);
			case MqPackage.MQ_QUEUE__REMOTE_QUEUE_MANAGER:
				return REMOTE_QUEUE_MANAGER_EDEFAULT == null ? remoteQueueManager != null : !REMOTE_QUEUE_MANAGER_EDEFAULT.equals(remoteQueueManager);
			case MqPackage.MQ_QUEUE__RETENTION_INTERVAL:
				return RETENTION_INTERVAL_EDEFAULT == null ? retentionInterval != null : !RETENTION_INTERVAL_EDEFAULT.equals(retentionInterval);
			case MqPackage.MQ_QUEUE__SCOPE:
				return SCOPE_EDEFAULT == null ? scope != null : !SCOPE_EDEFAULT.equals(scope);
			case MqPackage.MQ_QUEUE__SHAREABILITY:
				return SHAREABILITY_EDEFAULT == null ? shareability != null : !SHAREABILITY_EDEFAULT.equals(shareability);
			case MqPackage.MQ_QUEUE__SHARED_IN_ALIST_OF_CLUSTERS:
				return SHARED_IN_ALIST_OF_CLUSTERS_EDEFAULT == null ? sharedInAListOfClusters != null : !SHARED_IN_ALIST_OF_CLUSTERS_EDEFAULT.equals(sharedInAListOfClusters);
			case MqPackage.MQ_QUEUE__SHARED_IN_CLUSTER:
				return SHARED_IN_CLUSTER_EDEFAULT == null ? sharedInCluster != null : !SHARED_IN_CLUSTER_EDEFAULT.equals(sharedInCluster);
			case MqPackage.MQ_QUEUE__STAT_ALTERATION_DATE:
				return STAT_ALTERATION_DATE_EDEFAULT == null ? statAlterationDate != null : !STAT_ALTERATION_DATE_EDEFAULT.equals(statAlterationDate);
			case MqPackage.MQ_QUEUE__STAT_ALTERATION_TIME:
				return STAT_ALTERATION_TIME_EDEFAULT == null ? statAlterationTime != null : !STAT_ALTERATION_TIME_EDEFAULT.equals(statAlterationTime);
			case MqPackage.MQ_QUEUE__STAT_CREATION_DATE:
				return STAT_CREATION_DATE_EDEFAULT == null ? statCreationDate != null : !STAT_CREATION_DATE_EDEFAULT.equals(statCreationDate);
			case MqPackage.MQ_QUEUE__STAT_CREATION_TIME:
				return STAT_CREATION_TIME_EDEFAULT == null ? statCreationTime != null : !STAT_CREATION_TIME_EDEFAULT.equals(statCreationTime);
			case MqPackage.MQ_QUEUE__STAT_CURRENT_QUEUE_DEPTH:
				return STAT_CURRENT_QUEUE_DEPTH_EDEFAULT == null ? statCurrentQueueDepth != null : !STAT_CURRENT_QUEUE_DEPTH_EDEFAULT.equals(statCurrentQueueDepth);
			case MqPackage.MQ_QUEUE__STAT_OPEN_INPUT_COUNT:
				return STAT_OPEN_INPUT_COUNT_EDEFAULT == null ? statOpenInputCount != null : !STAT_OPEN_INPUT_COUNT_EDEFAULT.equals(statOpenInputCount);
			case MqPackage.MQ_QUEUE__STAT_OPEN_OUTPUT_COUNT:
				return STAT_OPEN_OUTPUT_COUNT_EDEFAULT == null ? statOpenOutputCount != null : !STAT_OPEN_OUTPUT_COUNT_EDEFAULT.equals(statOpenOutputCount);
			case MqPackage.MQ_QUEUE__STAT_QUEUE_MONITORING:
				return STAT_QUEUE_MONITORING_EDEFAULT == null ? statQueueMonitoring != null : !STAT_QUEUE_MONITORING_EDEFAULT.equals(statQueueMonitoring);
			case MqPackage.MQ_QUEUE__STAT_QUEUE_STATISTICS:
				return STAT_QUEUE_STATISTICS_EDEFAULT == null ? statQueueStatistics != null : !STAT_QUEUE_STATISTICS_EDEFAULT.equals(statQueueStatistics);
			case MqPackage.MQ_QUEUE__STORAGE_CLASS_NAME:
				return STORAGE_CLASS_NAME_EDEFAULT == null ? storageClassName != null : !STORAGE_CLASS_NAME_EDEFAULT.equals(storageClassName);
			case MqPackage.MQ_QUEUE__TRANSMISSION_QUEUE:
				return TRANSMISSION_QUEUE_EDEFAULT == null ? transmissionQueue != null : !TRANSMISSION_QUEUE_EDEFAULT.equals(transmissionQueue);
			case MqPackage.MQ_QUEUE__TRIGGER_CONTROL:
				return TRIGGER_CONTROL_EDEFAULT == null ? triggerControl != null : !TRIGGER_CONTROL_EDEFAULT.equals(triggerControl);
			case MqPackage.MQ_QUEUE__TRIGGER_DATA:
				return TRIGGER_DATA_EDEFAULT == null ? triggerData != null : !TRIGGER_DATA_EDEFAULT.equals(triggerData);
			case MqPackage.MQ_QUEUE__TRIGGER_DEPTH:
				return TRIGGER_DEPTH_EDEFAULT == null ? triggerDepth != null : !TRIGGER_DEPTH_EDEFAULT.equals(triggerDepth);
			case MqPackage.MQ_QUEUE__TRIGGER_MESSAGE_PRIORITY:
				return TRIGGER_MESSAGE_PRIORITY_EDEFAULT == null ? triggerMessagePriority != null : !TRIGGER_MESSAGE_PRIORITY_EDEFAULT.equals(triggerMessagePriority);
			case MqPackage.MQ_QUEUE__TRIGGER_TYPE:
				return TRIGGER_TYPE_EDEFAULT == null ? triggerType != null : !TRIGGER_TYPE_EDEFAULT.equals(triggerType);
			case MqPackage.MQ_QUEUE__USAGE:
				return USAGE_EDEFAULT == null ? usage != null : !USAGE_EDEFAULT.equals(usage);
			case MqPackage.MQ_QUEUE__USAGE1:
				return USAGE1_EDEFAULT == null ? usage1 != null : !USAGE1_EDEFAULT.equals(usage1);
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
		result.append(" (backoutRequeueQueue: "); //$NON-NLS-1$
		result.append(backoutRequeueQueue);
		result.append(", backoutThreshold: "); //$NON-NLS-1$
		result.append(backoutThreshold);
		result.append(", baseQueue: "); //$NON-NLS-1$
		result.append(baseQueue);
		result.append(", baseQueueName: "); //$NON-NLS-1$
		result.append(baseQueueName);
		result.append(", cLWLQueuePriority: "); //$NON-NLS-1$
		result.append(cLWLQueuePriority);
		result.append(", cLWLQueueRank: "); //$NON-NLS-1$
		result.append(cLWLQueueRank);
		result.append(", cLWLUQueue: "); //$NON-NLS-1$
		result.append(cLWLUQueue);
		result.append(", couplingFacilityName: "); //$NON-NLS-1$
		result.append(couplingFacilityName);
		result.append(", defaultBindType: "); //$NON-NLS-1$
		result.append(defaultBindType);
		result.append(", defaultInputOpenOption: "); //$NON-NLS-1$
		result.append(defaultInputOpenOption);
		result.append(", defaultPriority: "); //$NON-NLS-1$
		result.append(defaultPriority);
		result.append(", definitionType: "); //$NON-NLS-1$
		result.append(definitionType);
		result.append(", description1: "); //$NON-NLS-1$
		result.append(description1);
		result.append(", distributionList: "); //$NON-NLS-1$
		result.append(distributionList);
		result.append(", distributionLists: "); //$NON-NLS-1$
		result.append(distributionLists);
		result.append(", getMessages: "); //$NON-NLS-1$
		result.append(getMessages);
		result.append(", hardenGetBackout: "); //$NON-NLS-1$
		result.append(hardenGetBackout);
		result.append(", initiationQueue: "); //$NON-NLS-1$
		result.append(initiationQueue);
		result.append(", maxMessageLength: "); //$NON-NLS-1$
		result.append(maxMessageLength);
		result.append(", maxQueueDepth: "); //$NON-NLS-1$
		result.append(maxQueueDepth);
		result.append(", messageDeliverySequence: "); //$NON-NLS-1$
		result.append(messageDeliverySequence);
		result.append(", notSharedInCluster: "); //$NON-NLS-1$
		result.append(notSharedInCluster);
		result.append(", nPMClass: "); //$NON-NLS-1$
		result.append(nPMClass);
		result.append(", persistence: "); //$NON-NLS-1$
		result.append(persistence);
		result.append(", processName: "); //$NON-NLS-1$
		result.append(processName);
		result.append(", putMessage: "); //$NON-NLS-1$
		result.append(putMessage);
		result.append(", putMessages: "); //$NON-NLS-1$
		result.append(putMessages);
		result.append(", qSGDisposition: "); //$NON-NLS-1$
		result.append(qSGDisposition);
		result.append(", queueAccounting: "); //$NON-NLS-1$
		result.append(queueAccounting);
		result.append(", queueDepthHighEvents: "); //$NON-NLS-1$
		result.append(queueDepthHighEvents);
		result.append(", queueDepthHighLimit: "); //$NON-NLS-1$
		result.append(queueDepthHighLimit);
		result.append(", queueDepthLowEvents: "); //$NON-NLS-1$
		result.append(queueDepthLowEvents);
		result.append(", queueDepthLowLimit: "); //$NON-NLS-1$
		result.append(queueDepthLowLimit);
		result.append(", queueDepthMaxEvents: "); //$NON-NLS-1$
		result.append(queueDepthMaxEvents);
		result.append(", queueMonitoring: "); //$NON-NLS-1$
		result.append(queueMonitoring);
		result.append(", queueName: "); //$NON-NLS-1$
		result.append(queueName);
		result.append(", queueServiceInterval: "); //$NON-NLS-1$
		result.append(queueServiceInterval);
		result.append(", queueServiceIntervalEvents: "); //$NON-NLS-1$
		result.append(queueServiceIntervalEvents);
		result.append(", queueType: "); //$NON-NLS-1$
		result.append(queueType);
		result.append(", remoteQueue: "); //$NON-NLS-1$
		result.append(remoteQueue);
		result.append(", remoteQueueManager: "); //$NON-NLS-1$
		result.append(remoteQueueManager);
		result.append(", retentionInterval: "); //$NON-NLS-1$
		result.append(retentionInterval);
		result.append(", scope: "); //$NON-NLS-1$
		result.append(scope);
		result.append(", shareability: "); //$NON-NLS-1$
		result.append(shareability);
		result.append(", sharedInAListOfClusters: "); //$NON-NLS-1$
		result.append(sharedInAListOfClusters);
		result.append(", sharedInCluster: "); //$NON-NLS-1$
		result.append(sharedInCluster);
		result.append(", statAlterationDate: "); //$NON-NLS-1$
		result.append(statAlterationDate);
		result.append(", statAlterationTime: "); //$NON-NLS-1$
		result.append(statAlterationTime);
		result.append(", statCreationDate: "); //$NON-NLS-1$
		result.append(statCreationDate);
		result.append(", statCreationTime: "); //$NON-NLS-1$
		result.append(statCreationTime);
		result.append(", statCurrentQueueDepth: "); //$NON-NLS-1$
		result.append(statCurrentQueueDepth);
		result.append(", statOpenInputCount: "); //$NON-NLS-1$
		result.append(statOpenInputCount);
		result.append(", statOpenOutputCount: "); //$NON-NLS-1$
		result.append(statOpenOutputCount);
		result.append(", statQueueMonitoring: "); //$NON-NLS-1$
		result.append(statQueueMonitoring);
		result.append(", statQueueStatistics: "); //$NON-NLS-1$
		result.append(statQueueStatistics);
		result.append(", storageClassName: "); //$NON-NLS-1$
		result.append(storageClassName);
		result.append(", transmissionQueue: "); //$NON-NLS-1$
		result.append(transmissionQueue);
		result.append(", triggerControl: "); //$NON-NLS-1$
		result.append(triggerControl);
		result.append(", triggerData: "); //$NON-NLS-1$
		result.append(triggerData);
		result.append(", triggerDepth: "); //$NON-NLS-1$
		result.append(triggerDepth);
		result.append(", triggerMessagePriority: "); //$NON-NLS-1$
		result.append(triggerMessagePriority);
		result.append(", triggerType: "); //$NON-NLS-1$
		result.append(triggerType);
		result.append(", usage: "); //$NON-NLS-1$
		result.append(usage);
		result.append(", usage1: "); //$NON-NLS-1$
		result.append(usage1);
		result.append(')');
		return result.toString();
	}

} //MQQueueImpl
