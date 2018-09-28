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
 * A representation of the model object '<em><b>MQ Queue</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link com.ibm.ccl.soa.deploy.mq.MQQueue#getBackoutRequeueQueue <em>Backout Requeue Queue</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.mq.MQQueue#getBackoutThreshold <em>Backout Threshold</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.mq.MQQueue#getBaseQueue <em>Base Queue</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.mq.MQQueue#getBaseQueueName <em>Base Queue Name</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.mq.MQQueue#getCLWLQueuePriority <em>CLWL Queue Priority</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.mq.MQQueue#getCLWLQueueRank <em>CLWL Queue Rank</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.mq.MQQueue#getCLWLUQueue <em>CLWLU Queue</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.mq.MQQueue#getCouplingFacilityName <em>Coupling Facility Name</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.mq.MQQueue#getDefaultBindType <em>Default Bind Type</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.mq.MQQueue#getDefaultInputOpenOption <em>Default Input Open Option</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.mq.MQQueue#getDefaultPriority <em>Default Priority</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.mq.MQQueue#getDefinitionType <em>Definition Type</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.mq.MQQueue#getDescription1 <em>Description1</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.mq.MQQueue#getDistributionList <em>Distribution List</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.mq.MQQueue#getDistributionLists <em>Distribution Lists</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.mq.MQQueue#getGetMessages <em>Get Messages</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.mq.MQQueue#getHardenGetBackout <em>Harden Get Backout</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.mq.MQQueue#getInitiationQueue <em>Initiation Queue</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.mq.MQQueue#getMaxMessageLength <em>Max Message Length</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.mq.MQQueue#getMaxQueueDepth <em>Max Queue Depth</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.mq.MQQueue#getMessageDeliverySequence <em>Message Delivery Sequence</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.mq.MQQueue#getNotSharedInCluster <em>Not Shared In Cluster</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.mq.MQQueue#getNPMClass <em>NPM Class</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.mq.MQQueue#getPersistence <em>Persistence</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.mq.MQQueue#getProcessName <em>Process Name</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.mq.MQQueue#getPutMessage <em>Put Message</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.mq.MQQueue#getPutMessages <em>Put Messages</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.mq.MQQueue#getQSGDisposition <em>QSG Disposition</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.mq.MQQueue#getQueueAccounting <em>Queue Accounting</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.mq.MQQueue#getQueueDepthHighEvents <em>Queue Depth High Events</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.mq.MQQueue#getQueueDepthHighLimit <em>Queue Depth High Limit</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.mq.MQQueue#getQueueDepthLowEvents <em>Queue Depth Low Events</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.mq.MQQueue#getQueueDepthLowLimit <em>Queue Depth Low Limit</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.mq.MQQueue#getQueueDepthMaxEvents <em>Queue Depth Max Events</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.mq.MQQueue#getQueueMonitoring <em>Queue Monitoring</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.mq.MQQueue#getQueueName <em>Queue Name</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.mq.MQQueue#getQueueServiceInterval <em>Queue Service Interval</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.mq.MQQueue#getQueueServiceIntervalEvents <em>Queue Service Interval Events</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.mq.MQQueue#getQueueType <em>Queue Type</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.mq.MQQueue#getRemoteQueue <em>Remote Queue</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.mq.MQQueue#getRemoteQueueManager <em>Remote Queue Manager</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.mq.MQQueue#getRetentionInterval <em>Retention Interval</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.mq.MQQueue#getScope <em>Scope</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.mq.MQQueue#getShareability <em>Shareability</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.mq.MQQueue#getSharedInAListOfClusters <em>Shared In AList Of Clusters</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.mq.MQQueue#getSharedInCluster <em>Shared In Cluster</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.mq.MQQueue#getStatAlterationDate <em>Stat Alteration Date</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.mq.MQQueue#getStatAlterationTime <em>Stat Alteration Time</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.mq.MQQueue#getStatCreationDate <em>Stat Creation Date</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.mq.MQQueue#getStatCreationTime <em>Stat Creation Time</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.mq.MQQueue#getStatCurrentQueueDepth <em>Stat Current Queue Depth</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.mq.MQQueue#getStatOpenInputCount <em>Stat Open Input Count</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.mq.MQQueue#getStatOpenOutputCount <em>Stat Open Output Count</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.mq.MQQueue#getStatQueueMonitoring <em>Stat Queue Monitoring</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.mq.MQQueue#getStatQueueStatistics <em>Stat Queue Statistics</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.mq.MQQueue#getStorageClassName <em>Storage Class Name</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.mq.MQQueue#getTransmissionQueue <em>Transmission Queue</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.mq.MQQueue#getTriggerControl <em>Trigger Control</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.mq.MQQueue#getTriggerData <em>Trigger Data</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.mq.MQQueue#getTriggerDepth <em>Trigger Depth</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.mq.MQQueue#getTriggerMessagePriority <em>Trigger Message Priority</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.mq.MQQueue#getTriggerType <em>Trigger Type</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.mq.MQQueue#getUsage <em>Usage</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.mq.MQQueue#getUsage1 <em>Usage1</em>}</li>
 * </ul>
 * </p>
 *
 * @see com.ibm.ccl.soa.deploy.mq.MqPackage#getMQQueue()
 * @model extendedMetaData="name='MQQueue' kind='elementOnly'"
 * @generated
 */
public interface MQQueue extends Capability {
	/**
	 * Returns the value of the '<em><b>Backout Requeue Queue</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Backout Requeue Queue</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Backout Requeue Queue</em>' attribute.
	 * @see #setBackoutRequeueQueue(String)
	 * @see com.ibm.ccl.soa.deploy.mq.MqPackage#getMQQueue_BackoutRequeueQueue()
	 * @model dataType="org.eclipse.emf.ecore.xml.type.String"
	 *        extendedMetaData="kind='attribute' name='BackoutRequeueQueue'"
	 * @generated
	 */
	String getBackoutRequeueQueue();

	/**
	 * Sets the value of the '{@link com.ibm.ccl.soa.deploy.mq.MQQueue#getBackoutRequeueQueue <em>Backout Requeue Queue</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Backout Requeue Queue</em>' attribute.
	 * @see #getBackoutRequeueQueue()
	 * @generated
	 */
	void setBackoutRequeueQueue(String value);

	/**
	 * Returns the value of the '<em><b>Backout Threshold</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Backout Threshold</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Backout Threshold</em>' attribute.
	 * @see #setBackoutThreshold(String)
	 * @see com.ibm.ccl.soa.deploy.mq.MqPackage#getMQQueue_BackoutThreshold()
	 * @model dataType="org.eclipse.emf.ecore.xml.type.String"
	 *        extendedMetaData="kind='attribute' name='BackoutThreshold'"
	 * @generated
	 */
	String getBackoutThreshold();

	/**
	 * Sets the value of the '{@link com.ibm.ccl.soa.deploy.mq.MQQueue#getBackoutThreshold <em>Backout Threshold</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Backout Threshold</em>' attribute.
	 * @see #getBackoutThreshold()
	 * @generated
	 */
	void setBackoutThreshold(String value);

	/**
	 * Returns the value of the '<em><b>Base Queue</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Base Queue</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Base Queue</em>' attribute.
	 * @see #setBaseQueue(String)
	 * @see com.ibm.ccl.soa.deploy.mq.MqPackage#getMQQueue_BaseQueue()
	 * @model dataType="org.eclipse.emf.ecore.xml.type.String"
	 *        extendedMetaData="kind='attribute' name='BaseQueue'"
	 * @generated
	 */
	String getBaseQueue();

	/**
	 * Sets the value of the '{@link com.ibm.ccl.soa.deploy.mq.MQQueue#getBaseQueue <em>Base Queue</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Base Queue</em>' attribute.
	 * @see #getBaseQueue()
	 * @generated
	 */
	void setBaseQueue(String value);

	/**
	 * Returns the value of the '<em><b>Base Queue Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Base Queue Name</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Base Queue Name</em>' attribute.
	 * @see #setBaseQueueName(String)
	 * @see com.ibm.ccl.soa.deploy.mq.MqPackage#getMQQueue_BaseQueueName()
	 * @model dataType="org.eclipse.emf.ecore.xml.type.String"
	 *        extendedMetaData="kind='attribute' name='BaseQueueName'"
	 * @generated
	 */
	String getBaseQueueName();

	/**
	 * Sets the value of the '{@link com.ibm.ccl.soa.deploy.mq.MQQueue#getBaseQueueName <em>Base Queue Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Base Queue Name</em>' attribute.
	 * @see #getBaseQueueName()
	 * @generated
	 */
	void setBaseQueueName(String value);

	/**
	 * Returns the value of the '<em><b>CLWL Queue Priority</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>CLWL Queue Priority</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>CLWL Queue Priority</em>' attribute.
	 * @see #setCLWLQueuePriority(String)
	 * @see com.ibm.ccl.soa.deploy.mq.MqPackage#getMQQueue_CLWLQueuePriority()
	 * @model dataType="org.eclipse.emf.ecore.xml.type.String"
	 *        extendedMetaData="kind='attribute' name='CLWLQueuePriority'"
	 * @generated
	 */
	String getCLWLQueuePriority();

	/**
	 * Sets the value of the '{@link com.ibm.ccl.soa.deploy.mq.MQQueue#getCLWLQueuePriority <em>CLWL Queue Priority</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>CLWL Queue Priority</em>' attribute.
	 * @see #getCLWLQueuePriority()
	 * @generated
	 */
	void setCLWLQueuePriority(String value);

	/**
	 * Returns the value of the '<em><b>CLWL Queue Rank</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>CLWL Queue Rank</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>CLWL Queue Rank</em>' attribute.
	 * @see #setCLWLQueueRank(String)
	 * @see com.ibm.ccl.soa.deploy.mq.MqPackage#getMQQueue_CLWLQueueRank()
	 * @model dataType="org.eclipse.emf.ecore.xml.type.String"
	 *        extendedMetaData="kind='attribute' name='CLWLQueueRank'"
	 * @generated
	 */
	String getCLWLQueueRank();

	/**
	 * Sets the value of the '{@link com.ibm.ccl.soa.deploy.mq.MQQueue#getCLWLQueueRank <em>CLWL Queue Rank</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>CLWL Queue Rank</em>' attribute.
	 * @see #getCLWLQueueRank()
	 * @generated
	 */
	void setCLWLQueueRank(String value);

	/**
	 * Returns the value of the '<em><b>CLWLU Queue</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>CLWLU Queue</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>CLWLU Queue</em>' attribute.
	 * @see #setCLWLUQueue(String)
	 * @see com.ibm.ccl.soa.deploy.mq.MqPackage#getMQQueue_CLWLUQueue()
	 * @model dataType="org.eclipse.emf.ecore.xml.type.String"
	 *        extendedMetaData="kind='attribute' name='CLWLUQueue'"
	 * @generated
	 */
	String getCLWLUQueue();

	/**
	 * Sets the value of the '{@link com.ibm.ccl.soa.deploy.mq.MQQueue#getCLWLUQueue <em>CLWLU Queue</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>CLWLU Queue</em>' attribute.
	 * @see #getCLWLUQueue()
	 * @generated
	 */
	void setCLWLUQueue(String value);

	/**
	 * Returns the value of the '<em><b>Coupling Facility Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Coupling Facility Name</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Coupling Facility Name</em>' attribute.
	 * @see #setCouplingFacilityName(String)
	 * @see com.ibm.ccl.soa.deploy.mq.MqPackage#getMQQueue_CouplingFacilityName()
	 * @model dataType="org.eclipse.emf.ecore.xml.type.String"
	 *        extendedMetaData="kind='attribute' name='CouplingFacilityName'"
	 * @generated
	 */
	String getCouplingFacilityName();

	/**
	 * Sets the value of the '{@link com.ibm.ccl.soa.deploy.mq.MQQueue#getCouplingFacilityName <em>Coupling Facility Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Coupling Facility Name</em>' attribute.
	 * @see #getCouplingFacilityName()
	 * @generated
	 */
	void setCouplingFacilityName(String value);

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
	 * @see com.ibm.ccl.soa.deploy.mq.MqPackage#getMQQueue_DefaultBindType()
	 * @model dataType="org.eclipse.emf.ecore.xml.type.String"
	 *        extendedMetaData="kind='attribute' name='DefaultBindType'"
	 * @generated
	 */
	String getDefaultBindType();

	/**
	 * Sets the value of the '{@link com.ibm.ccl.soa.deploy.mq.MQQueue#getDefaultBindType <em>Default Bind Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Default Bind Type</em>' attribute.
	 * @see #getDefaultBindType()
	 * @generated
	 */
	void setDefaultBindType(String value);

	/**
	 * Returns the value of the '<em><b>Default Input Open Option</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Default Input Open Option</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Default Input Open Option</em>' attribute.
	 * @see #setDefaultInputOpenOption(String)
	 * @see com.ibm.ccl.soa.deploy.mq.MqPackage#getMQQueue_DefaultInputOpenOption()
	 * @model dataType="org.eclipse.emf.ecore.xml.type.String"
	 *        extendedMetaData="kind='attribute' name='DefaultInputOpenOption'"
	 * @generated
	 */
	String getDefaultInputOpenOption();

	/**
	 * Sets the value of the '{@link com.ibm.ccl.soa.deploy.mq.MQQueue#getDefaultInputOpenOption <em>Default Input Open Option</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Default Input Open Option</em>' attribute.
	 * @see #getDefaultInputOpenOption()
	 * @generated
	 */
	void setDefaultInputOpenOption(String value);

	/**
	 * Returns the value of the '<em><b>Default Priority</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Default Priority</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Default Priority</em>' attribute.
	 * @see #setDefaultPriority(String)
	 * @see com.ibm.ccl.soa.deploy.mq.MqPackage#getMQQueue_DefaultPriority()
	 * @model dataType="org.eclipse.emf.ecore.xml.type.String"
	 *        extendedMetaData="kind='attribute' name='DefaultPriority'"
	 * @generated
	 */
	String getDefaultPriority();

	/**
	 * Sets the value of the '{@link com.ibm.ccl.soa.deploy.mq.MQQueue#getDefaultPriority <em>Default Priority</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Default Priority</em>' attribute.
	 * @see #getDefaultPriority()
	 * @generated
	 */
	void setDefaultPriority(String value);

	/**
	 * Returns the value of the '<em><b>Definition Type</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Definition Type</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Definition Type</em>' attribute.
	 * @see #setDefinitionType(String)
	 * @see com.ibm.ccl.soa.deploy.mq.MqPackage#getMQQueue_DefinitionType()
	 * @model dataType="org.eclipse.emf.ecore.xml.type.String"
	 *        extendedMetaData="kind='attribute' name='DefinitionType'"
	 * @generated
	 */
	String getDefinitionType();

	/**
	 * Sets the value of the '{@link com.ibm.ccl.soa.deploy.mq.MQQueue#getDefinitionType <em>Definition Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Definition Type</em>' attribute.
	 * @see #getDefinitionType()
	 * @generated
	 */
	void setDefinitionType(String value);

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
	 * @see com.ibm.ccl.soa.deploy.mq.MqPackage#getMQQueue_Description1()
	 * @model dataType="org.eclipse.emf.ecore.xml.type.String"
	 *        extendedMetaData="kind='attribute' name='Description'"
	 * @generated
	 */
	String getDescription1();

	/**
	 * Sets the value of the '{@link com.ibm.ccl.soa.deploy.mq.MQQueue#getDescription1 <em>Description1</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Description1</em>' attribute.
	 * @see #getDescription1()
	 * @generated
	 */
	void setDescription1(String value);

	/**
	 * Returns the value of the '<em><b>Distribution List</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Distribution List</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Distribution List</em>' attribute.
	 * @see #setDistributionList(String)
	 * @see com.ibm.ccl.soa.deploy.mq.MqPackage#getMQQueue_DistributionList()
	 * @model dataType="org.eclipse.emf.ecore.xml.type.String"
	 *        extendedMetaData="kind='attribute' name='DistributionList'"
	 * @generated
	 */
	String getDistributionList();

	/**
	 * Sets the value of the '{@link com.ibm.ccl.soa.deploy.mq.MQQueue#getDistributionList <em>Distribution List</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Distribution List</em>' attribute.
	 * @see #getDistributionList()
	 * @generated
	 */
	void setDistributionList(String value);

	/**
	 * Returns the value of the '<em><b>Distribution Lists</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Distribution Lists</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Distribution Lists</em>' attribute.
	 * @see #setDistributionLists(String)
	 * @see com.ibm.ccl.soa.deploy.mq.MqPackage#getMQQueue_DistributionLists()
	 * @model dataType="org.eclipse.emf.ecore.xml.type.String"
	 *        extendedMetaData="kind='attribute' name='DistributionLists'"
	 * @generated
	 */
	String getDistributionLists();

	/**
	 * Sets the value of the '{@link com.ibm.ccl.soa.deploy.mq.MQQueue#getDistributionLists <em>Distribution Lists</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Distribution Lists</em>' attribute.
	 * @see #getDistributionLists()
	 * @generated
	 */
	void setDistributionLists(String value);

	/**
	 * Returns the value of the '<em><b>Get Messages</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Get Messages</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Get Messages</em>' attribute.
	 * @see #setGetMessages(String)
	 * @see com.ibm.ccl.soa.deploy.mq.MqPackage#getMQQueue_GetMessages()
	 * @model dataType="org.eclipse.emf.ecore.xml.type.String"
	 *        extendedMetaData="kind='attribute' name='GetMessages'"
	 * @generated
	 */
	String getGetMessages();

	/**
	 * Sets the value of the '{@link com.ibm.ccl.soa.deploy.mq.MQQueue#getGetMessages <em>Get Messages</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Get Messages</em>' attribute.
	 * @see #getGetMessages()
	 * @generated
	 */
	void setGetMessages(String value);

	/**
	 * Returns the value of the '<em><b>Harden Get Backout</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Harden Get Backout</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Harden Get Backout</em>' attribute.
	 * @see #setHardenGetBackout(String)
	 * @see com.ibm.ccl.soa.deploy.mq.MqPackage#getMQQueue_HardenGetBackout()
	 * @model dataType="org.eclipse.emf.ecore.xml.type.String"
	 *        extendedMetaData="kind='attribute' name='HardenGetBackout'"
	 * @generated
	 */
	String getHardenGetBackout();

	/**
	 * Sets the value of the '{@link com.ibm.ccl.soa.deploy.mq.MQQueue#getHardenGetBackout <em>Harden Get Backout</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Harden Get Backout</em>' attribute.
	 * @see #getHardenGetBackout()
	 * @generated
	 */
	void setHardenGetBackout(String value);

	/**
	 * Returns the value of the '<em><b>Initiation Queue</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Initiation Queue</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Initiation Queue</em>' attribute.
	 * @see #setInitiationQueue(String)
	 * @see com.ibm.ccl.soa.deploy.mq.MqPackage#getMQQueue_InitiationQueue()
	 * @model dataType="org.eclipse.emf.ecore.xml.type.String"
	 *        extendedMetaData="kind='attribute' name='InitiationQueue'"
	 * @generated
	 */
	String getInitiationQueue();

	/**
	 * Sets the value of the '{@link com.ibm.ccl.soa.deploy.mq.MQQueue#getInitiationQueue <em>Initiation Queue</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Initiation Queue</em>' attribute.
	 * @see #getInitiationQueue()
	 * @generated
	 */
	void setInitiationQueue(String value);

	/**
	 * Returns the value of the '<em><b>Max Message Length</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Max Message Length</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Max Message Length</em>' attribute.
	 * @see #setMaxMessageLength(String)
	 * @see com.ibm.ccl.soa.deploy.mq.MqPackage#getMQQueue_MaxMessageLength()
	 * @model dataType="org.eclipse.emf.ecore.xml.type.String"
	 *        extendedMetaData="kind='attribute' name='MaxMessageLength'"
	 * @generated
	 */
	String getMaxMessageLength();

	/**
	 * Sets the value of the '{@link com.ibm.ccl.soa.deploy.mq.MQQueue#getMaxMessageLength <em>Max Message Length</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Max Message Length</em>' attribute.
	 * @see #getMaxMessageLength()
	 * @generated
	 */
	void setMaxMessageLength(String value);

	/**
	 * Returns the value of the '<em><b>Max Queue Depth</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Max Queue Depth</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Max Queue Depth</em>' attribute.
	 * @see #setMaxQueueDepth(String)
	 * @see com.ibm.ccl.soa.deploy.mq.MqPackage#getMQQueue_MaxQueueDepth()
	 * @model dataType="org.eclipse.emf.ecore.xml.type.String"
	 *        extendedMetaData="kind='attribute' name='MaxQueueDepth'"
	 * @generated
	 */
	String getMaxQueueDepth();

	/**
	 * Sets the value of the '{@link com.ibm.ccl.soa.deploy.mq.MQQueue#getMaxQueueDepth <em>Max Queue Depth</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Max Queue Depth</em>' attribute.
	 * @see #getMaxQueueDepth()
	 * @generated
	 */
	void setMaxQueueDepth(String value);

	/**
	 * Returns the value of the '<em><b>Message Delivery Sequence</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Message Delivery Sequence</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Message Delivery Sequence</em>' attribute.
	 * @see #setMessageDeliverySequence(String)
	 * @see com.ibm.ccl.soa.deploy.mq.MqPackage#getMQQueue_MessageDeliverySequence()
	 * @model dataType="org.eclipse.emf.ecore.xml.type.String"
	 *        extendedMetaData="kind='attribute' name='MessageDeliverySequence'"
	 * @generated
	 */
	String getMessageDeliverySequence();

	/**
	 * Sets the value of the '{@link com.ibm.ccl.soa.deploy.mq.MQQueue#getMessageDeliverySequence <em>Message Delivery Sequence</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Message Delivery Sequence</em>' attribute.
	 * @see #getMessageDeliverySequence()
	 * @generated
	 */
	void setMessageDeliverySequence(String value);

	/**
	 * Returns the value of the '<em><b>Not Shared In Cluster</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Not Shared In Cluster</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Not Shared In Cluster</em>' attribute.
	 * @see #setNotSharedInCluster(String)
	 * @see com.ibm.ccl.soa.deploy.mq.MqPackage#getMQQueue_NotSharedInCluster()
	 * @model dataType="org.eclipse.emf.ecore.xml.type.String"
	 *        extendedMetaData="kind='attribute' name='NotSharedInCluster'"
	 * @generated
	 */
	String getNotSharedInCluster();

	/**
	 * Sets the value of the '{@link com.ibm.ccl.soa.deploy.mq.MQQueue#getNotSharedInCluster <em>Not Shared In Cluster</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Not Shared In Cluster</em>' attribute.
	 * @see #getNotSharedInCluster()
	 * @generated
	 */
	void setNotSharedInCluster(String value);

	/**
	 * Returns the value of the '<em><b>NPM Class</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>NPM Class</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>NPM Class</em>' attribute.
	 * @see #setNPMClass(String)
	 * @see com.ibm.ccl.soa.deploy.mq.MqPackage#getMQQueue_NPMClass()
	 * @model dataType="org.eclipse.emf.ecore.xml.type.String"
	 *        extendedMetaData="kind='attribute' name='NPMClass'"
	 * @generated
	 */
	String getNPMClass();

	/**
	 * Sets the value of the '{@link com.ibm.ccl.soa.deploy.mq.MQQueue#getNPMClass <em>NPM Class</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>NPM Class</em>' attribute.
	 * @see #getNPMClass()
	 * @generated
	 */
	void setNPMClass(String value);

	/**
	 * Returns the value of the '<em><b>Persistence</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Persistence</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Persistence</em>' attribute.
	 * @see #setPersistence(String)
	 * @see com.ibm.ccl.soa.deploy.mq.MqPackage#getMQQueue_Persistence()
	 * @model dataType="org.eclipse.emf.ecore.xml.type.String"
	 *        extendedMetaData="kind='attribute' name='Persistence'"
	 * @generated
	 */
	String getPersistence();

	/**
	 * Sets the value of the '{@link com.ibm.ccl.soa.deploy.mq.MQQueue#getPersistence <em>Persistence</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Persistence</em>' attribute.
	 * @see #getPersistence()
	 * @generated
	 */
	void setPersistence(String value);

	/**
	 * Returns the value of the '<em><b>Process Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Process Name</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Process Name</em>' attribute.
	 * @see #setProcessName(String)
	 * @see com.ibm.ccl.soa.deploy.mq.MqPackage#getMQQueue_ProcessName()
	 * @model dataType="org.eclipse.emf.ecore.xml.type.String"
	 *        extendedMetaData="kind='attribute' name='ProcessName'"
	 * @generated
	 */
	String getProcessName();

	/**
	 * Sets the value of the '{@link com.ibm.ccl.soa.deploy.mq.MQQueue#getProcessName <em>Process Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Process Name</em>' attribute.
	 * @see #getProcessName()
	 * @generated
	 */
	void setProcessName(String value);

	/**
	 * Returns the value of the '<em><b>Put Message</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Put Message</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Put Message</em>' attribute.
	 * @see #setPutMessage(String)
	 * @see com.ibm.ccl.soa.deploy.mq.MqPackage#getMQQueue_PutMessage()
	 * @model dataType="org.eclipse.emf.ecore.xml.type.String"
	 *        extendedMetaData="kind='attribute' name='PutMessage'"
	 * @generated
	 */
	String getPutMessage();

	/**
	 * Sets the value of the '{@link com.ibm.ccl.soa.deploy.mq.MQQueue#getPutMessage <em>Put Message</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Put Message</em>' attribute.
	 * @see #getPutMessage()
	 * @generated
	 */
	void setPutMessage(String value);

	/**
	 * Returns the value of the '<em><b>Put Messages</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Put Messages</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Put Messages</em>' attribute.
	 * @see #setPutMessages(String)
	 * @see com.ibm.ccl.soa.deploy.mq.MqPackage#getMQQueue_PutMessages()
	 * @model dataType="org.eclipse.emf.ecore.xml.type.String"
	 *        extendedMetaData="kind='attribute' name='PutMessages'"
	 * @generated
	 */
	String getPutMessages();

	/**
	 * Sets the value of the '{@link com.ibm.ccl.soa.deploy.mq.MQQueue#getPutMessages <em>Put Messages</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Put Messages</em>' attribute.
	 * @see #getPutMessages()
	 * @generated
	 */
	void setPutMessages(String value);

	/**
	 * Returns the value of the '<em><b>QSG Disposition</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>QSG Disposition</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>QSG Disposition</em>' attribute.
	 * @see #setQSGDisposition(String)
	 * @see com.ibm.ccl.soa.deploy.mq.MqPackage#getMQQueue_QSGDisposition()
	 * @model dataType="org.eclipse.emf.ecore.xml.type.String"
	 *        extendedMetaData="kind='attribute' name='QSGDisposition'"
	 * @generated
	 */
	String getQSGDisposition();

	/**
	 * Sets the value of the '{@link com.ibm.ccl.soa.deploy.mq.MQQueue#getQSGDisposition <em>QSG Disposition</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>QSG Disposition</em>' attribute.
	 * @see #getQSGDisposition()
	 * @generated
	 */
	void setQSGDisposition(String value);

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
	 * @see com.ibm.ccl.soa.deploy.mq.MqPackage#getMQQueue_QueueAccounting()
	 * @model dataType="org.eclipse.emf.ecore.xml.type.String"
	 *        extendedMetaData="kind='attribute' name='QueueAccounting'"
	 * @generated
	 */
	String getQueueAccounting();

	/**
	 * Sets the value of the '{@link com.ibm.ccl.soa.deploy.mq.MQQueue#getQueueAccounting <em>Queue Accounting</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Queue Accounting</em>' attribute.
	 * @see #getQueueAccounting()
	 * @generated
	 */
	void setQueueAccounting(String value);

	/**
	 * Returns the value of the '<em><b>Queue Depth High Events</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Queue Depth High Events</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Queue Depth High Events</em>' attribute.
	 * @see #setQueueDepthHighEvents(String)
	 * @see com.ibm.ccl.soa.deploy.mq.MqPackage#getMQQueue_QueueDepthHighEvents()
	 * @model dataType="org.eclipse.emf.ecore.xml.type.String"
	 *        extendedMetaData="kind='attribute' name='QueueDepthHighEvents'"
	 * @generated
	 */
	String getQueueDepthHighEvents();

	/**
	 * Sets the value of the '{@link com.ibm.ccl.soa.deploy.mq.MQQueue#getQueueDepthHighEvents <em>Queue Depth High Events</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Queue Depth High Events</em>' attribute.
	 * @see #getQueueDepthHighEvents()
	 * @generated
	 */
	void setQueueDepthHighEvents(String value);

	/**
	 * Returns the value of the '<em><b>Queue Depth High Limit</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Queue Depth High Limit</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Queue Depth High Limit</em>' attribute.
	 * @see #setQueueDepthHighLimit(String)
	 * @see com.ibm.ccl.soa.deploy.mq.MqPackage#getMQQueue_QueueDepthHighLimit()
	 * @model dataType="org.eclipse.emf.ecore.xml.type.String"
	 *        extendedMetaData="kind='attribute' name='QueueDepthHighLimit'"
	 * @generated
	 */
	String getQueueDepthHighLimit();

	/**
	 * Sets the value of the '{@link com.ibm.ccl.soa.deploy.mq.MQQueue#getQueueDepthHighLimit <em>Queue Depth High Limit</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Queue Depth High Limit</em>' attribute.
	 * @see #getQueueDepthHighLimit()
	 * @generated
	 */
	void setQueueDepthHighLimit(String value);

	/**
	 * Returns the value of the '<em><b>Queue Depth Low Events</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Queue Depth Low Events</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Queue Depth Low Events</em>' attribute.
	 * @see #setQueueDepthLowEvents(String)
	 * @see com.ibm.ccl.soa.deploy.mq.MqPackage#getMQQueue_QueueDepthLowEvents()
	 * @model dataType="org.eclipse.emf.ecore.xml.type.String"
	 *        extendedMetaData="kind='attribute' name='QueueDepthLowEvents'"
	 * @generated
	 */
	String getQueueDepthLowEvents();

	/**
	 * Sets the value of the '{@link com.ibm.ccl.soa.deploy.mq.MQQueue#getQueueDepthLowEvents <em>Queue Depth Low Events</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Queue Depth Low Events</em>' attribute.
	 * @see #getQueueDepthLowEvents()
	 * @generated
	 */
	void setQueueDepthLowEvents(String value);

	/**
	 * Returns the value of the '<em><b>Queue Depth Low Limit</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Queue Depth Low Limit</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Queue Depth Low Limit</em>' attribute.
	 * @see #setQueueDepthLowLimit(String)
	 * @see com.ibm.ccl.soa.deploy.mq.MqPackage#getMQQueue_QueueDepthLowLimit()
	 * @model dataType="org.eclipse.emf.ecore.xml.type.String"
	 *        extendedMetaData="kind='attribute' name='QueueDepthLowLimit'"
	 * @generated
	 */
	String getQueueDepthLowLimit();

	/**
	 * Sets the value of the '{@link com.ibm.ccl.soa.deploy.mq.MQQueue#getQueueDepthLowLimit <em>Queue Depth Low Limit</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Queue Depth Low Limit</em>' attribute.
	 * @see #getQueueDepthLowLimit()
	 * @generated
	 */
	void setQueueDepthLowLimit(String value);

	/**
	 * Returns the value of the '<em><b>Queue Depth Max Events</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Queue Depth Max Events</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Queue Depth Max Events</em>' attribute.
	 * @see #setQueueDepthMaxEvents(String)
	 * @see com.ibm.ccl.soa.deploy.mq.MqPackage#getMQQueue_QueueDepthMaxEvents()
	 * @model dataType="org.eclipse.emf.ecore.xml.type.String"
	 *        extendedMetaData="kind='attribute' name='QueueDepthMaxEvents'"
	 * @generated
	 */
	String getQueueDepthMaxEvents();

	/**
	 * Sets the value of the '{@link com.ibm.ccl.soa.deploy.mq.MQQueue#getQueueDepthMaxEvents <em>Queue Depth Max Events</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Queue Depth Max Events</em>' attribute.
	 * @see #getQueueDepthMaxEvents()
	 * @generated
	 */
	void setQueueDepthMaxEvents(String value);

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
	 * @see com.ibm.ccl.soa.deploy.mq.MqPackage#getMQQueue_QueueMonitoring()
	 * @model dataType="org.eclipse.emf.ecore.xml.type.String"
	 *        extendedMetaData="kind='attribute' name='QueueMonitoring'"
	 * @generated
	 */
	String getQueueMonitoring();

	/**
	 * Sets the value of the '{@link com.ibm.ccl.soa.deploy.mq.MQQueue#getQueueMonitoring <em>Queue Monitoring</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Queue Monitoring</em>' attribute.
	 * @see #getQueueMonitoring()
	 * @generated
	 */
	void setQueueMonitoring(String value);

	/**
	 * Returns the value of the '<em><b>Queue Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Queue Name</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Queue Name</em>' attribute.
	 * @see #setQueueName(String)
	 * @see com.ibm.ccl.soa.deploy.mq.MqPackage#getMQQueue_QueueName()
	 * @model dataType="org.eclipse.emf.ecore.xml.type.String"
	 *        extendedMetaData="kind='attribute' name='QueueName'"
	 * @generated
	 */
	String getQueueName();

	/**
	 * Sets the value of the '{@link com.ibm.ccl.soa.deploy.mq.MQQueue#getQueueName <em>Queue Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Queue Name</em>' attribute.
	 * @see #getQueueName()
	 * @generated
	 */
	void setQueueName(String value);

	/**
	 * Returns the value of the '<em><b>Queue Service Interval</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Queue Service Interval</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Queue Service Interval</em>' attribute.
	 * @see #setQueueServiceInterval(String)
	 * @see com.ibm.ccl.soa.deploy.mq.MqPackage#getMQQueue_QueueServiceInterval()
	 * @model dataType="org.eclipse.emf.ecore.xml.type.String"
	 *        extendedMetaData="kind='attribute' name='QueueServiceInterval'"
	 * @generated
	 */
	String getQueueServiceInterval();

	/**
	 * Sets the value of the '{@link com.ibm.ccl.soa.deploy.mq.MQQueue#getQueueServiceInterval <em>Queue Service Interval</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Queue Service Interval</em>' attribute.
	 * @see #getQueueServiceInterval()
	 * @generated
	 */
	void setQueueServiceInterval(String value);

	/**
	 * Returns the value of the '<em><b>Queue Service Interval Events</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Queue Service Interval Events</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Queue Service Interval Events</em>' attribute.
	 * @see #setQueueServiceIntervalEvents(String)
	 * @see com.ibm.ccl.soa.deploy.mq.MqPackage#getMQQueue_QueueServiceIntervalEvents()
	 * @model dataType="org.eclipse.emf.ecore.xml.type.String"
	 *        extendedMetaData="kind='attribute' name='QueueServiceIntervalEvents'"
	 * @generated
	 */
	String getQueueServiceIntervalEvents();

	/**
	 * Sets the value of the '{@link com.ibm.ccl.soa.deploy.mq.MQQueue#getQueueServiceIntervalEvents <em>Queue Service Interval Events</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Queue Service Interval Events</em>' attribute.
	 * @see #getQueueServiceIntervalEvents()
	 * @generated
	 */
	void setQueueServiceIntervalEvents(String value);

	/**
	 * Returns the value of the '<em><b>Queue Type</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Queue Type</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Queue Type</em>' attribute.
	 * @see #setQueueType(String)
	 * @see com.ibm.ccl.soa.deploy.mq.MqPackage#getMQQueue_QueueType()
	 * @model dataType="org.eclipse.emf.ecore.xml.type.String"
	 *        extendedMetaData="kind='attribute' name='QueueType'"
	 * @generated
	 */
	String getQueueType();

	/**
	 * Sets the value of the '{@link com.ibm.ccl.soa.deploy.mq.MQQueue#getQueueType <em>Queue Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Queue Type</em>' attribute.
	 * @see #getQueueType()
	 * @generated
	 */
	void setQueueType(String value);

	/**
	 * Returns the value of the '<em><b>Remote Queue</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Remote Queue</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Remote Queue</em>' attribute.
	 * @see #setRemoteQueue(String)
	 * @see com.ibm.ccl.soa.deploy.mq.MqPackage#getMQQueue_RemoteQueue()
	 * @model dataType="org.eclipse.emf.ecore.xml.type.String"
	 *        extendedMetaData="kind='attribute' name='RemoteQueue'"
	 * @generated
	 */
	String getRemoteQueue();

	/**
	 * Sets the value of the '{@link com.ibm.ccl.soa.deploy.mq.MQQueue#getRemoteQueue <em>Remote Queue</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Remote Queue</em>' attribute.
	 * @see #getRemoteQueue()
	 * @generated
	 */
	void setRemoteQueue(String value);

	/**
	 * Returns the value of the '<em><b>Remote Queue Manager</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Remote Queue Manager</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Remote Queue Manager</em>' attribute.
	 * @see #setRemoteQueueManager(String)
	 * @see com.ibm.ccl.soa.deploy.mq.MqPackage#getMQQueue_RemoteQueueManager()
	 * @model dataType="org.eclipse.emf.ecore.xml.type.String"
	 *        extendedMetaData="kind='attribute' name='RemoteQueueManager'"
	 * @generated
	 */
	String getRemoteQueueManager();

	/**
	 * Sets the value of the '{@link com.ibm.ccl.soa.deploy.mq.MQQueue#getRemoteQueueManager <em>Remote Queue Manager</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Remote Queue Manager</em>' attribute.
	 * @see #getRemoteQueueManager()
	 * @generated
	 */
	void setRemoteQueueManager(String value);

	/**
	 * Returns the value of the '<em><b>Retention Interval</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Retention Interval</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Retention Interval</em>' attribute.
	 * @see #setRetentionInterval(String)
	 * @see com.ibm.ccl.soa.deploy.mq.MqPackage#getMQQueue_RetentionInterval()
	 * @model dataType="org.eclipse.emf.ecore.xml.type.String"
	 *        extendedMetaData="kind='attribute' name='RetentionInterval'"
	 * @generated
	 */
	String getRetentionInterval();

	/**
	 * Sets the value of the '{@link com.ibm.ccl.soa.deploy.mq.MQQueue#getRetentionInterval <em>Retention Interval</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Retention Interval</em>' attribute.
	 * @see #getRetentionInterval()
	 * @generated
	 */
	void setRetentionInterval(String value);

	/**
	 * Returns the value of the '<em><b>Scope</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Scope</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Scope</em>' attribute.
	 * @see #setScope(String)
	 * @see com.ibm.ccl.soa.deploy.mq.MqPackage#getMQQueue_Scope()
	 * @model dataType="org.eclipse.emf.ecore.xml.type.String"
	 *        extendedMetaData="kind='attribute' name='Scope'"
	 * @generated
	 */
	String getScope();

	/**
	 * Sets the value of the '{@link com.ibm.ccl.soa.deploy.mq.MQQueue#getScope <em>Scope</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Scope</em>' attribute.
	 * @see #getScope()
	 * @generated
	 */
	void setScope(String value);

	/**
	 * Returns the value of the '<em><b>Shareability</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Shareability</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Shareability</em>' attribute.
	 * @see #setShareability(String)
	 * @see com.ibm.ccl.soa.deploy.mq.MqPackage#getMQQueue_Shareability()
	 * @model dataType="org.eclipse.emf.ecore.xml.type.String"
	 *        extendedMetaData="kind='attribute' name='Shareability'"
	 * @generated
	 */
	String getShareability();

	/**
	 * Sets the value of the '{@link com.ibm.ccl.soa.deploy.mq.MQQueue#getShareability <em>Shareability</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Shareability</em>' attribute.
	 * @see #getShareability()
	 * @generated
	 */
	void setShareability(String value);

	/**
	 * Returns the value of the '<em><b>Shared In AList Of Clusters</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Shared In AList Of Clusters</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Shared In AList Of Clusters</em>' attribute.
	 * @see #setSharedInAListOfClusters(String)
	 * @see com.ibm.ccl.soa.deploy.mq.MqPackage#getMQQueue_SharedInAListOfClusters()
	 * @model dataType="org.eclipse.emf.ecore.xml.type.String"
	 *        extendedMetaData="kind='attribute' name='SharedInAListOfClusters'"
	 * @generated
	 */
	String getSharedInAListOfClusters();

	/**
	 * Sets the value of the '{@link com.ibm.ccl.soa.deploy.mq.MQQueue#getSharedInAListOfClusters <em>Shared In AList Of Clusters</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Shared In AList Of Clusters</em>' attribute.
	 * @see #getSharedInAListOfClusters()
	 * @generated
	 */
	void setSharedInAListOfClusters(String value);

	/**
	 * Returns the value of the '<em><b>Shared In Cluster</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Shared In Cluster</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Shared In Cluster</em>' attribute.
	 * @see #setSharedInCluster(String)
	 * @see com.ibm.ccl.soa.deploy.mq.MqPackage#getMQQueue_SharedInCluster()
	 * @model dataType="org.eclipse.emf.ecore.xml.type.String"
	 *        extendedMetaData="kind='attribute' name='SharedInCluster'"
	 * @generated
	 */
	String getSharedInCluster();

	/**
	 * Sets the value of the '{@link com.ibm.ccl.soa.deploy.mq.MQQueue#getSharedInCluster <em>Shared In Cluster</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Shared In Cluster</em>' attribute.
	 * @see #getSharedInCluster()
	 * @generated
	 */
	void setSharedInCluster(String value);

	/**
	 * Returns the value of the '<em><b>Stat Alteration Date</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Stat Alteration Date</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Stat Alteration Date</em>' attribute.
	 * @see #setStatAlterationDate(String)
	 * @see com.ibm.ccl.soa.deploy.mq.MqPackage#getMQQueue_StatAlterationDate()
	 * @model dataType="org.eclipse.emf.ecore.xml.type.String"
	 *        extendedMetaData="kind='attribute' name='StatAlterationDate'"
	 * @generated
	 */
	String getStatAlterationDate();

	/**
	 * Sets the value of the '{@link com.ibm.ccl.soa.deploy.mq.MQQueue#getStatAlterationDate <em>Stat Alteration Date</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Stat Alteration Date</em>' attribute.
	 * @see #getStatAlterationDate()
	 * @generated
	 */
	void setStatAlterationDate(String value);

	/**
	 * Returns the value of the '<em><b>Stat Alteration Time</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Stat Alteration Time</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Stat Alteration Time</em>' attribute.
	 * @see #setStatAlterationTime(String)
	 * @see com.ibm.ccl.soa.deploy.mq.MqPackage#getMQQueue_StatAlterationTime()
	 * @model dataType="org.eclipse.emf.ecore.xml.type.String"
	 *        extendedMetaData="kind='attribute' name='StatAlterationTime'"
	 * @generated
	 */
	String getStatAlterationTime();

	/**
	 * Sets the value of the '{@link com.ibm.ccl.soa.deploy.mq.MQQueue#getStatAlterationTime <em>Stat Alteration Time</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Stat Alteration Time</em>' attribute.
	 * @see #getStatAlterationTime()
	 * @generated
	 */
	void setStatAlterationTime(String value);

	/**
	 * Returns the value of the '<em><b>Stat Creation Date</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Stat Creation Date</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Stat Creation Date</em>' attribute.
	 * @see #setStatCreationDate(String)
	 * @see com.ibm.ccl.soa.deploy.mq.MqPackage#getMQQueue_StatCreationDate()
	 * @model dataType="org.eclipse.emf.ecore.xml.type.String"
	 *        extendedMetaData="kind='attribute' name='StatCreationDate'"
	 * @generated
	 */
	String getStatCreationDate();

	/**
	 * Sets the value of the '{@link com.ibm.ccl.soa.deploy.mq.MQQueue#getStatCreationDate <em>Stat Creation Date</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Stat Creation Date</em>' attribute.
	 * @see #getStatCreationDate()
	 * @generated
	 */
	void setStatCreationDate(String value);

	/**
	 * Returns the value of the '<em><b>Stat Creation Time</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Stat Creation Time</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Stat Creation Time</em>' attribute.
	 * @see #setStatCreationTime(String)
	 * @see com.ibm.ccl.soa.deploy.mq.MqPackage#getMQQueue_StatCreationTime()
	 * @model dataType="org.eclipse.emf.ecore.xml.type.String"
	 *        extendedMetaData="kind='attribute' name='StatCreationTime'"
	 * @generated
	 */
	String getStatCreationTime();

	/**
	 * Sets the value of the '{@link com.ibm.ccl.soa.deploy.mq.MQQueue#getStatCreationTime <em>Stat Creation Time</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Stat Creation Time</em>' attribute.
	 * @see #getStatCreationTime()
	 * @generated
	 */
	void setStatCreationTime(String value);

	/**
	 * Returns the value of the '<em><b>Stat Current Queue Depth</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Stat Current Queue Depth</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Stat Current Queue Depth</em>' attribute.
	 * @see #setStatCurrentQueueDepth(String)
	 * @see com.ibm.ccl.soa.deploy.mq.MqPackage#getMQQueue_StatCurrentQueueDepth()
	 * @model dataType="org.eclipse.emf.ecore.xml.type.String"
	 *        extendedMetaData="kind='attribute' name='StatCurrentQueueDepth'"
	 * @generated
	 */
	String getStatCurrentQueueDepth();

	/**
	 * Sets the value of the '{@link com.ibm.ccl.soa.deploy.mq.MQQueue#getStatCurrentQueueDepth <em>Stat Current Queue Depth</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Stat Current Queue Depth</em>' attribute.
	 * @see #getStatCurrentQueueDepth()
	 * @generated
	 */
	void setStatCurrentQueueDepth(String value);

	/**
	 * Returns the value of the '<em><b>Stat Open Input Count</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Stat Open Input Count</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Stat Open Input Count</em>' attribute.
	 * @see #setStatOpenInputCount(String)
	 * @see com.ibm.ccl.soa.deploy.mq.MqPackage#getMQQueue_StatOpenInputCount()
	 * @model dataType="org.eclipse.emf.ecore.xml.type.String"
	 *        extendedMetaData="kind='attribute' name='StatOpenInputCount'"
	 * @generated
	 */
	String getStatOpenInputCount();

	/**
	 * Sets the value of the '{@link com.ibm.ccl.soa.deploy.mq.MQQueue#getStatOpenInputCount <em>Stat Open Input Count</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Stat Open Input Count</em>' attribute.
	 * @see #getStatOpenInputCount()
	 * @generated
	 */
	void setStatOpenInputCount(String value);

	/**
	 * Returns the value of the '<em><b>Stat Open Output Count</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Stat Open Output Count</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Stat Open Output Count</em>' attribute.
	 * @see #setStatOpenOutputCount(String)
	 * @see com.ibm.ccl.soa.deploy.mq.MqPackage#getMQQueue_StatOpenOutputCount()
	 * @model dataType="org.eclipse.emf.ecore.xml.type.String"
	 *        extendedMetaData="kind='attribute' name='StatOpenOutputCount'"
	 * @generated
	 */
	String getStatOpenOutputCount();

	/**
	 * Sets the value of the '{@link com.ibm.ccl.soa.deploy.mq.MQQueue#getStatOpenOutputCount <em>Stat Open Output Count</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Stat Open Output Count</em>' attribute.
	 * @see #getStatOpenOutputCount()
	 * @generated
	 */
	void setStatOpenOutputCount(String value);

	/**
	 * Returns the value of the '<em><b>Stat Queue Monitoring</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Stat Queue Monitoring</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Stat Queue Monitoring</em>' attribute.
	 * @see #setStatQueueMonitoring(String)
	 * @see com.ibm.ccl.soa.deploy.mq.MqPackage#getMQQueue_StatQueueMonitoring()
	 * @model dataType="org.eclipse.emf.ecore.xml.type.String"
	 *        extendedMetaData="kind='attribute' name='StatQueueMonitoring'"
	 * @generated
	 */
	String getStatQueueMonitoring();

	/**
	 * Sets the value of the '{@link com.ibm.ccl.soa.deploy.mq.MQQueue#getStatQueueMonitoring <em>Stat Queue Monitoring</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Stat Queue Monitoring</em>' attribute.
	 * @see #getStatQueueMonitoring()
	 * @generated
	 */
	void setStatQueueMonitoring(String value);

	/**
	 * Returns the value of the '<em><b>Stat Queue Statistics</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Stat Queue Statistics</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Stat Queue Statistics</em>' attribute.
	 * @see #setStatQueueStatistics(String)
	 * @see com.ibm.ccl.soa.deploy.mq.MqPackage#getMQQueue_StatQueueStatistics()
	 * @model dataType="org.eclipse.emf.ecore.xml.type.String"
	 *        extendedMetaData="kind='attribute' name='StatQueueStatistics'"
	 * @generated
	 */
	String getStatQueueStatistics();

	/**
	 * Sets the value of the '{@link com.ibm.ccl.soa.deploy.mq.MQQueue#getStatQueueStatistics <em>Stat Queue Statistics</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Stat Queue Statistics</em>' attribute.
	 * @see #getStatQueueStatistics()
	 * @generated
	 */
	void setStatQueueStatistics(String value);

	/**
	 * Returns the value of the '<em><b>Storage Class Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Storage Class Name</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Storage Class Name</em>' attribute.
	 * @see #setStorageClassName(String)
	 * @see com.ibm.ccl.soa.deploy.mq.MqPackage#getMQQueue_StorageClassName()
	 * @model dataType="org.eclipse.emf.ecore.xml.type.String"
	 *        extendedMetaData="kind='attribute' name='StorageClassName'"
	 * @generated
	 */
	String getStorageClassName();

	/**
	 * Sets the value of the '{@link com.ibm.ccl.soa.deploy.mq.MQQueue#getStorageClassName <em>Storage Class Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Storage Class Name</em>' attribute.
	 * @see #getStorageClassName()
	 * @generated
	 */
	void setStorageClassName(String value);

	/**
	 * Returns the value of the '<em><b>Transmission Queue</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Transmission Queue</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Transmission Queue</em>' attribute.
	 * @see #setTransmissionQueue(String)
	 * @see com.ibm.ccl.soa.deploy.mq.MqPackage#getMQQueue_TransmissionQueue()
	 * @model dataType="org.eclipse.emf.ecore.xml.type.String"
	 *        extendedMetaData="kind='attribute' name='TransmissionQueue'"
	 * @generated
	 */
	String getTransmissionQueue();

	/**
	 * Sets the value of the '{@link com.ibm.ccl.soa.deploy.mq.MQQueue#getTransmissionQueue <em>Transmission Queue</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Transmission Queue</em>' attribute.
	 * @see #getTransmissionQueue()
	 * @generated
	 */
	void setTransmissionQueue(String value);

	/**
	 * Returns the value of the '<em><b>Trigger Control</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Trigger Control</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Trigger Control</em>' attribute.
	 * @see #setTriggerControl(String)
	 * @see com.ibm.ccl.soa.deploy.mq.MqPackage#getMQQueue_TriggerControl()
	 * @model dataType="org.eclipse.emf.ecore.xml.type.String"
	 *        extendedMetaData="kind='attribute' name='TriggerControl'"
	 * @generated
	 */
	String getTriggerControl();

	/**
	 * Sets the value of the '{@link com.ibm.ccl.soa.deploy.mq.MQQueue#getTriggerControl <em>Trigger Control</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Trigger Control</em>' attribute.
	 * @see #getTriggerControl()
	 * @generated
	 */
	void setTriggerControl(String value);

	/**
	 * Returns the value of the '<em><b>Trigger Data</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Trigger Data</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Trigger Data</em>' attribute.
	 * @see #setTriggerData(String)
	 * @see com.ibm.ccl.soa.deploy.mq.MqPackage#getMQQueue_TriggerData()
	 * @model dataType="org.eclipse.emf.ecore.xml.type.String"
	 *        extendedMetaData="kind='attribute' name='TriggerData'"
	 * @generated
	 */
	String getTriggerData();

	/**
	 * Sets the value of the '{@link com.ibm.ccl.soa.deploy.mq.MQQueue#getTriggerData <em>Trigger Data</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Trigger Data</em>' attribute.
	 * @see #getTriggerData()
	 * @generated
	 */
	void setTriggerData(String value);

	/**
	 * Returns the value of the '<em><b>Trigger Depth</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Trigger Depth</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Trigger Depth</em>' attribute.
	 * @see #setTriggerDepth(String)
	 * @see com.ibm.ccl.soa.deploy.mq.MqPackage#getMQQueue_TriggerDepth()
	 * @model dataType="org.eclipse.emf.ecore.xml.type.String"
	 *        extendedMetaData="kind='attribute' name='TriggerDepth'"
	 * @generated
	 */
	String getTriggerDepth();

	/**
	 * Sets the value of the '{@link com.ibm.ccl.soa.deploy.mq.MQQueue#getTriggerDepth <em>Trigger Depth</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Trigger Depth</em>' attribute.
	 * @see #getTriggerDepth()
	 * @generated
	 */
	void setTriggerDepth(String value);

	/**
	 * Returns the value of the '<em><b>Trigger Message Priority</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Trigger Message Priority</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Trigger Message Priority</em>' attribute.
	 * @see #setTriggerMessagePriority(String)
	 * @see com.ibm.ccl.soa.deploy.mq.MqPackage#getMQQueue_TriggerMessagePriority()
	 * @model dataType="org.eclipse.emf.ecore.xml.type.String"
	 *        extendedMetaData="kind='attribute' name='TriggerMessagePriority'"
	 * @generated
	 */
	String getTriggerMessagePriority();

	/**
	 * Sets the value of the '{@link com.ibm.ccl.soa.deploy.mq.MQQueue#getTriggerMessagePriority <em>Trigger Message Priority</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Trigger Message Priority</em>' attribute.
	 * @see #getTriggerMessagePriority()
	 * @generated
	 */
	void setTriggerMessagePriority(String value);

	/**
	 * Returns the value of the '<em><b>Trigger Type</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Trigger Type</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Trigger Type</em>' attribute.
	 * @see #setTriggerType(String)
	 * @see com.ibm.ccl.soa.deploy.mq.MqPackage#getMQQueue_TriggerType()
	 * @model dataType="org.eclipse.emf.ecore.xml.type.String"
	 *        extendedMetaData="kind='attribute' name='TriggerType'"
	 * @generated
	 */
	String getTriggerType();

	/**
	 * Sets the value of the '{@link com.ibm.ccl.soa.deploy.mq.MQQueue#getTriggerType <em>Trigger Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Trigger Type</em>' attribute.
	 * @see #getTriggerType()
	 * @generated
	 */
	void setTriggerType(String value);

	/**
	 * Returns the value of the '<em><b>Usage</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Usage</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Usage</em>' attribute.
	 * @see #setUsage(String)
	 * @see com.ibm.ccl.soa.deploy.mq.MqPackage#getMQQueue_Usage()
	 * @model dataType="org.eclipse.emf.ecore.xml.type.String"
	 *        extendedMetaData="kind='attribute' name='usage'"
	 * @generated
	 */
	String getUsage();

	/**
	 * Sets the value of the '{@link com.ibm.ccl.soa.deploy.mq.MQQueue#getUsage <em>Usage</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Usage</em>' attribute.
	 * @see #getUsage()
	 * @generated
	 */
	void setUsage(String value);

	/**
	 * Returns the value of the '<em><b>Usage1</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Usage1</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Usage1</em>' attribute.
	 * @see #setUsage1(String)
	 * @see com.ibm.ccl.soa.deploy.mq.MqPackage#getMQQueue_Usage1()
	 * @model dataType="org.eclipse.emf.ecore.xml.type.String"
	 *        extendedMetaData="kind='attribute' name='Usage'"
	 * @generated
	 */
	String getUsage1();

	/**
	 * Sets the value of the '{@link com.ibm.ccl.soa.deploy.mq.MQQueue#getUsage1 <em>Usage1</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Usage1</em>' attribute.
	 * @see #getUsage1()
	 * @generated
	 */
	void setUsage1(String value);

} // MQQueue
