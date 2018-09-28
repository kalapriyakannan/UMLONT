/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package com.ibm.ccl.soa.deploy.mq;

import org.eclipse.emf.common.util.EMap;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.util.FeatureMap;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>MQ Root</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link com.ibm.ccl.soa.deploy.mq.MQRoot#getMixed <em>Mixed</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.mq.MQRoot#getXMLNSPrefixMap <em>XMLNS Prefix Map</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.mq.MQRoot#getXSISchemaLocation <em>XSI Schema Location</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.mq.MQRoot#getCapabilityMQActivationSpecification <em>Capability MQ Activation Specification</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.mq.MQRoot#getCapabilityMQBaseSystem <em>Capability MQ Base System</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.mq.MQRoot#getCapabilityMQConnectionFactories <em>Capability MQ Connection Factories</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.mq.MQRoot#getCapabilityMQDestination <em>Capability MQ Destination</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.mq.MQRoot#getCapabilityMQListener <em>Capability MQ Listener</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.mq.MQRoot#getCapabilityMQMessagingProvider <em>Capability MQ Messaging Provider</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.mq.MQRoot#getCapabilityMQMesseageListernerServicePort <em>Capability MQ Messeage Listerner Service Port</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.mq.MQRoot#getCapabilityMQQueue <em>Capability MQ Queue</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.mq.MQRoot#getCapabilityMQQueueChannel <em>Capability MQ Queue Channel</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.mq.MQRoot#getCapabilityMQQueueConnectionFactory <em>Capability MQ Queue Connection Factory</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.mq.MQRoot#getCapabilityMQQueueDestination <em>Capability MQ Queue Destination</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.mq.MQRoot#getCapabilityMQQueueManager <em>Capability MQ Queue Manager</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.mq.MQRoot#getCapabilityMQTopicConnectionFactory <em>Capability MQ Topic Connection Factory</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.mq.MQRoot#getCapabilityMQTopicDestination <em>Capability MQ Topic Destination</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.mq.MQRoot#getUnitMQActivationSpecificationUnit <em>Unit MQ Activation Specification Unit</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.mq.MQRoot#getUnitMQBaseSystemUnit <em>Unit MQ Base System Unit</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.mq.MQRoot#getUnitMQConnectionFactoriesUnit <em>Unit MQ Connection Factories Unit</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.mq.MQRoot#getUnitMQListenerUnit <em>Unit MQ Listener Unit</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.mq.MQRoot#getUnitMQMessageListnerServicePortUnit <em>Unit MQ Message Listner Service Port Unit</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.mq.MQRoot#getUnitMQMessagingProviderUnit <em>Unit MQ Messaging Provider Unit</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.mq.MQRoot#getUnitMQQueueChannelUnit <em>Unit MQ Queue Channel Unit</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.mq.MQRoot#getUnitMQQueueConnectionFactoryUnit <em>Unit MQ Queue Connection Factory Unit</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.mq.MQRoot#getUnitMQQueueDestinationUnit <em>Unit MQ Queue Destination Unit</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.mq.MQRoot#getUnitMQQueueManagerUnit <em>Unit MQ Queue Manager Unit</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.mq.MQRoot#getUnitMQQueueUnit <em>Unit MQ Queue Unit</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.mq.MQRoot#getUnitMQTopicConnectionFactoryUnit <em>Unit MQ Topic Connection Factory Unit</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.mq.MQRoot#getUnitMQTopicDestinationUnit <em>Unit MQ Topic Destination Unit</em>}</li>
 * </ul>
 * </p>
 *
 * @see com.ibm.ccl.soa.deploy.mq.MqPackage#getMQRoot()
 * @model extendedMetaData="name='' kind='mixed'"
 * @generated
 */
public interface MQRoot extends EObject {
	/**
	 * Returns the value of the '<em><b>Mixed</b></em>' attribute list.
	 * The list contents are of type {@link org.eclipse.emf.ecore.util.FeatureMap.Entry}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Mixed</em>' attribute list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Mixed</em>' attribute list.
	 * @see com.ibm.ccl.soa.deploy.mq.MqPackage#getMQRoot_Mixed()
	 * @model unique="false" dataType="org.eclipse.emf.ecore.EFeatureMapEntry" many="true"
	 *        extendedMetaData="kind='elementWildcard' name=':mixed'"
	 * @generated
	 */
	FeatureMap getMixed();

	/**
	 * Returns the value of the '<em><b>XMLNS Prefix Map</b></em>' map.
	 * The key is of type {@link java.lang.String},
	 * and the value is of type {@link java.lang.String},
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>XMLNS Prefix Map</em>' map isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>XMLNS Prefix Map</em>' map.
	 * @see com.ibm.ccl.soa.deploy.mq.MqPackage#getMQRoot_XMLNSPrefixMap()
	 * @model mapType="org.eclipse.emf.ecore.EStringToStringMapEntry" keyType="java.lang.String" valueType="java.lang.String" transient="true"
	 *        extendedMetaData="kind='attribute' name='xmlns:prefix'"
	 * @generated
	 */
	EMap getXMLNSPrefixMap();

	/**
	 * Returns the value of the '<em><b>XSI Schema Location</b></em>' map.
	 * The key is of type {@link java.lang.String},
	 * and the value is of type {@link java.lang.String},
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>XSI Schema Location</em>' map isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>XSI Schema Location</em>' map.
	 * @see com.ibm.ccl.soa.deploy.mq.MqPackage#getMQRoot_XSISchemaLocation()
	 * @model mapType="org.eclipse.emf.ecore.EStringToStringMapEntry" keyType="java.lang.String" valueType="java.lang.String" transient="true"
	 *        extendedMetaData="kind='attribute' name='xsi:schemaLocation'"
	 * @generated
	 */
	EMap getXSISchemaLocation();

	/**
	 * Returns the value of the '<em><b>Capability MQ Activation Specification</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Capability MQ Activation Specification</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Capability MQ Activation Specification</em>' containment reference.
	 * @see #setCapabilityMQActivationSpecification(MQActivationSpecification)
	 * @see com.ibm.ccl.soa.deploy.mq.MqPackage#getMQRoot_CapabilityMQActivationSpecification()
	 * @model containment="true" upper="-2" transient="true" volatile="true" derived="true"
	 *        extendedMetaData="kind='element' name='capability.MQActivationSpecification' namespace='##targetNamespace' affiliation='http://www.ibm.com/ccl/soa/deploy/core/1.0.0/#capability'"
	 * @generated
	 */
	MQActivationSpecification getCapabilityMQActivationSpecification();

	/**
	 * Sets the value of the '{@link com.ibm.ccl.soa.deploy.mq.MQRoot#getCapabilityMQActivationSpecification <em>Capability MQ Activation Specification</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Capability MQ Activation Specification</em>' containment reference.
	 * @see #getCapabilityMQActivationSpecification()
	 * @generated
	 */
	void setCapabilityMQActivationSpecification(MQActivationSpecification value);

	/**
	 * Returns the value of the '<em><b>Capability MQ Base System</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Capability MQ Base System</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Capability MQ Base System</em>' containment reference.
	 * @see #setCapabilityMQBaseSystem(MQBaseSystem)
	 * @see com.ibm.ccl.soa.deploy.mq.MqPackage#getMQRoot_CapabilityMQBaseSystem()
	 * @model containment="true" upper="-2" transient="true" volatile="true" derived="true"
	 *        extendedMetaData="kind='element' name='capability.MQBaseSystem' namespace='##targetNamespace' affiliation='http://www.ibm.com/ccl/soa/deploy/core/1.0.0/#capability'"
	 * @generated
	 */
	MQBaseSystem getCapabilityMQBaseSystem();

	/**
	 * Sets the value of the '{@link com.ibm.ccl.soa.deploy.mq.MQRoot#getCapabilityMQBaseSystem <em>Capability MQ Base System</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Capability MQ Base System</em>' containment reference.
	 * @see #getCapabilityMQBaseSystem()
	 * @generated
	 */
	void setCapabilityMQBaseSystem(MQBaseSystem value);

	/**
	 * Returns the value of the '<em><b>Capability MQ Connection Factories</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Capability MQ Connection Factories</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Capability MQ Connection Factories</em>' containment reference.
	 * @see #setCapabilityMQConnectionFactories(MQConnectionFactories)
	 * @see com.ibm.ccl.soa.deploy.mq.MqPackage#getMQRoot_CapabilityMQConnectionFactories()
	 * @model containment="true" upper="-2" transient="true" volatile="true" derived="true"
	 *        extendedMetaData="kind='element' name='capability.MQConnectionFactories' namespace='##targetNamespace' affiliation='http://www.ibm.com/ccl/soa/deploy/core/1.0.0/#capability'"
	 * @generated
	 */
	MQConnectionFactories getCapabilityMQConnectionFactories();

	/**
	 * Sets the value of the '{@link com.ibm.ccl.soa.deploy.mq.MQRoot#getCapabilityMQConnectionFactories <em>Capability MQ Connection Factories</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Capability MQ Connection Factories</em>' containment reference.
	 * @see #getCapabilityMQConnectionFactories()
	 * @generated
	 */
	void setCapabilityMQConnectionFactories(MQConnectionFactories value);

	/**
	 * Returns the value of the '<em><b>Capability MQ Destination</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Capability MQ Destination</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Capability MQ Destination</em>' containment reference.
	 * @see #setCapabilityMQDestination(MQDestination)
	 * @see com.ibm.ccl.soa.deploy.mq.MqPackage#getMQRoot_CapabilityMQDestination()
	 * @model containment="true" upper="-2" transient="true" volatile="true" derived="true"
	 *        extendedMetaData="kind='element' name='capability.MQDestination' namespace='##targetNamespace' affiliation='http://www.ibm.com/ccl/soa/deploy/core/1.0.0/#capability'"
	 * @generated
	 */
	MQDestination getCapabilityMQDestination();

	/**
	 * Sets the value of the '{@link com.ibm.ccl.soa.deploy.mq.MQRoot#getCapabilityMQDestination <em>Capability MQ Destination</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Capability MQ Destination</em>' containment reference.
	 * @see #getCapabilityMQDestination()
	 * @generated
	 */
	void setCapabilityMQDestination(MQDestination value);

	/**
	 * Returns the value of the '<em><b>Capability MQ Listener</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Capability MQ Listener</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Capability MQ Listener</em>' containment reference.
	 * @see #setCapabilityMQListener(MQListener)
	 * @see com.ibm.ccl.soa.deploy.mq.MqPackage#getMQRoot_CapabilityMQListener()
	 * @model containment="true" upper="-2" transient="true" volatile="true" derived="true"
	 *        extendedMetaData="kind='element' name='capability.MQListener' namespace='##targetNamespace' affiliation='http://www.ibm.com/ccl/soa/deploy/core/1.0.0/#capability'"
	 * @generated
	 */
	MQListener getCapabilityMQListener();

	/**
	 * Sets the value of the '{@link com.ibm.ccl.soa.deploy.mq.MQRoot#getCapabilityMQListener <em>Capability MQ Listener</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Capability MQ Listener</em>' containment reference.
	 * @see #getCapabilityMQListener()
	 * @generated
	 */
	void setCapabilityMQListener(MQListener value);

	/**
	 * Returns the value of the '<em><b>Capability MQ Messaging Provider</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Capability MQ Messaging Provider</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Capability MQ Messaging Provider</em>' containment reference.
	 * @see #setCapabilityMQMessagingProvider(MQMessagingProvider)
	 * @see com.ibm.ccl.soa.deploy.mq.MqPackage#getMQRoot_CapabilityMQMessagingProvider()
	 * @model containment="true" upper="-2" transient="true" volatile="true" derived="true"
	 *        extendedMetaData="kind='element' name='capability.MQMessagingProvider' namespace='##targetNamespace' affiliation='http://www.ibm.com/ccl/soa/deploy/core/1.0.0/#capability'"
	 * @generated
	 */
	MQMessagingProvider getCapabilityMQMessagingProvider();

	/**
	 * Sets the value of the '{@link com.ibm.ccl.soa.deploy.mq.MQRoot#getCapabilityMQMessagingProvider <em>Capability MQ Messaging Provider</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Capability MQ Messaging Provider</em>' containment reference.
	 * @see #getCapabilityMQMessagingProvider()
	 * @generated
	 */
	void setCapabilityMQMessagingProvider(MQMessagingProvider value);

	/**
	 * Returns the value of the '<em><b>Capability MQ Messeage Listerner Service Port</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Capability MQ Messeage Listerner Service Port</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Capability MQ Messeage Listerner Service Port</em>' containment reference.
	 * @see #setCapabilityMQMesseageListernerServicePort(MesseageListernerServicePort)
	 * @see com.ibm.ccl.soa.deploy.mq.MqPackage#getMQRoot_CapabilityMQMesseageListernerServicePort()
	 * @model containment="true" upper="-2" transient="true" volatile="true" derived="true"
	 *        extendedMetaData="kind='element' name='capability.MQMesseageListernerServicePort' namespace='##targetNamespace' affiliation='http://www.ibm.com/ccl/soa/deploy/core/1.0.0/#capability'"
	 * @generated
	 */
	MesseageListernerServicePort getCapabilityMQMesseageListernerServicePort();

	/**
	 * Sets the value of the '{@link com.ibm.ccl.soa.deploy.mq.MQRoot#getCapabilityMQMesseageListernerServicePort <em>Capability MQ Messeage Listerner Service Port</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Capability MQ Messeage Listerner Service Port</em>' containment reference.
	 * @see #getCapabilityMQMesseageListernerServicePort()
	 * @generated
	 */
	void setCapabilityMQMesseageListernerServicePort(MesseageListernerServicePort value);

	/**
	 * Returns the value of the '<em><b>Capability MQ Queue</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Capability MQ Queue</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Capability MQ Queue</em>' containment reference.
	 * @see #setCapabilityMQQueue(MQQueue)
	 * @see com.ibm.ccl.soa.deploy.mq.MqPackage#getMQRoot_CapabilityMQQueue()
	 * @model containment="true" upper="-2" transient="true" volatile="true" derived="true"
	 *        extendedMetaData="kind='element' name='capability.MQQueue' namespace='##targetNamespace' affiliation='http://www.ibm.com/ccl/soa/deploy/core/1.0.0/#capability'"
	 * @generated
	 */
	MQQueue getCapabilityMQQueue();

	/**
	 * Sets the value of the '{@link com.ibm.ccl.soa.deploy.mq.MQRoot#getCapabilityMQQueue <em>Capability MQ Queue</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Capability MQ Queue</em>' containment reference.
	 * @see #getCapabilityMQQueue()
	 * @generated
	 */
	void setCapabilityMQQueue(MQQueue value);

	/**
	 * Returns the value of the '<em><b>Capability MQ Queue Channel</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Capability MQ Queue Channel</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Capability MQ Queue Channel</em>' containment reference.
	 * @see #setCapabilityMQQueueChannel(MQQueueChannel)
	 * @see com.ibm.ccl.soa.deploy.mq.MqPackage#getMQRoot_CapabilityMQQueueChannel()
	 * @model containment="true" upper="-2" transient="true" volatile="true" derived="true"
	 *        extendedMetaData="kind='element' name='capability.MQQueueChannel' namespace='##targetNamespace' affiliation='http://www.ibm.com/ccl/soa/deploy/core/1.0.0/#capability'"
	 * @generated
	 */
	MQQueueChannel getCapabilityMQQueueChannel();

	/**
	 * Sets the value of the '{@link com.ibm.ccl.soa.deploy.mq.MQRoot#getCapabilityMQQueueChannel <em>Capability MQ Queue Channel</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Capability MQ Queue Channel</em>' containment reference.
	 * @see #getCapabilityMQQueueChannel()
	 * @generated
	 */
	void setCapabilityMQQueueChannel(MQQueueChannel value);

	/**
	 * Returns the value of the '<em><b>Capability MQ Queue Connection Factory</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Capability MQ Queue Connection Factory</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Capability MQ Queue Connection Factory</em>' containment reference.
	 * @see #setCapabilityMQQueueConnectionFactory(MQQueueConnectionFactory)
	 * @see com.ibm.ccl.soa.deploy.mq.MqPackage#getMQRoot_CapabilityMQQueueConnectionFactory()
	 * @model containment="true" upper="-2" transient="true" volatile="true" derived="true"
	 *        extendedMetaData="kind='element' name='capability.MQQueueConnectionFactory' namespace='##targetNamespace' affiliation='http://www.ibm.com/ccl/soa/deploy/core/1.0.0/#capability'"
	 * @generated
	 */
	MQQueueConnectionFactory getCapabilityMQQueueConnectionFactory();

	/**
	 * Sets the value of the '{@link com.ibm.ccl.soa.deploy.mq.MQRoot#getCapabilityMQQueueConnectionFactory <em>Capability MQ Queue Connection Factory</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Capability MQ Queue Connection Factory</em>' containment reference.
	 * @see #getCapabilityMQQueueConnectionFactory()
	 * @generated
	 */
	void setCapabilityMQQueueConnectionFactory(MQQueueConnectionFactory value);

	/**
	 * Returns the value of the '<em><b>Capability MQ Queue Destination</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Capability MQ Queue Destination</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Capability MQ Queue Destination</em>' containment reference.
	 * @see #setCapabilityMQQueueDestination(MQQueueDestination)
	 * @see com.ibm.ccl.soa.deploy.mq.MqPackage#getMQRoot_CapabilityMQQueueDestination()
	 * @model containment="true" upper="-2" transient="true" volatile="true" derived="true"
	 *        extendedMetaData="kind='element' name='capability.MQQueueDestination' namespace='##targetNamespace' affiliation='http://www.ibm.com/ccl/soa/deploy/core/1.0.0/#capability'"
	 * @generated
	 */
	MQQueueDestination getCapabilityMQQueueDestination();

	/**
	 * Sets the value of the '{@link com.ibm.ccl.soa.deploy.mq.MQRoot#getCapabilityMQQueueDestination <em>Capability MQ Queue Destination</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Capability MQ Queue Destination</em>' containment reference.
	 * @see #getCapabilityMQQueueDestination()
	 * @generated
	 */
	void setCapabilityMQQueueDestination(MQQueueDestination value);

	/**
	 * Returns the value of the '<em><b>Capability MQ Queue Manager</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Capability MQ Queue Manager</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Capability MQ Queue Manager</em>' containment reference.
	 * @see #setCapabilityMQQueueManager(MQQueueManager)
	 * @see com.ibm.ccl.soa.deploy.mq.MqPackage#getMQRoot_CapabilityMQQueueManager()
	 * @model containment="true" upper="-2" transient="true" volatile="true" derived="true"
	 *        extendedMetaData="kind='element' name='capability.MQQueueManager' namespace='##targetNamespace' affiliation='http://www.ibm.com/ccl/soa/deploy/core/1.0.0/#capability'"
	 * @generated
	 */
	MQQueueManager getCapabilityMQQueueManager();

	/**
	 * Sets the value of the '{@link com.ibm.ccl.soa.deploy.mq.MQRoot#getCapabilityMQQueueManager <em>Capability MQ Queue Manager</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Capability MQ Queue Manager</em>' containment reference.
	 * @see #getCapabilityMQQueueManager()
	 * @generated
	 */
	void setCapabilityMQQueueManager(MQQueueManager value);

	/**
	 * Returns the value of the '<em><b>Capability MQ Topic Connection Factory</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Capability MQ Topic Connection Factory</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Capability MQ Topic Connection Factory</em>' containment reference.
	 * @see #setCapabilityMQTopicConnectionFactory(MQTopicConnectionFactory)
	 * @see com.ibm.ccl.soa.deploy.mq.MqPackage#getMQRoot_CapabilityMQTopicConnectionFactory()
	 * @model containment="true" upper="-2" transient="true" volatile="true" derived="true"
	 *        extendedMetaData="kind='element' name='capability.MQTopicConnectionFactory' namespace='##targetNamespace' affiliation='http://www.ibm.com/ccl/soa/deploy/core/1.0.0/#capability'"
	 * @generated
	 */
	MQTopicConnectionFactory getCapabilityMQTopicConnectionFactory();

	/**
	 * Sets the value of the '{@link com.ibm.ccl.soa.deploy.mq.MQRoot#getCapabilityMQTopicConnectionFactory <em>Capability MQ Topic Connection Factory</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Capability MQ Topic Connection Factory</em>' containment reference.
	 * @see #getCapabilityMQTopicConnectionFactory()
	 * @generated
	 */
	void setCapabilityMQTopicConnectionFactory(MQTopicConnectionFactory value);

	/**
	 * Returns the value of the '<em><b>Capability MQ Topic Destination</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Capability MQ Topic Destination</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Capability MQ Topic Destination</em>' containment reference.
	 * @see #setCapabilityMQTopicDestination(MQTopicDestination)
	 * @see com.ibm.ccl.soa.deploy.mq.MqPackage#getMQRoot_CapabilityMQTopicDestination()
	 * @model containment="true" upper="-2" transient="true" volatile="true" derived="true"
	 *        extendedMetaData="kind='element' name='capability.MQTopicDestination' namespace='##targetNamespace' affiliation='http://www.ibm.com/ccl/soa/deploy/core/1.0.0/#capability'"
	 * @generated
	 */
	MQTopicDestination getCapabilityMQTopicDestination();

	/**
	 * Sets the value of the '{@link com.ibm.ccl.soa.deploy.mq.MQRoot#getCapabilityMQTopicDestination <em>Capability MQ Topic Destination</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Capability MQ Topic Destination</em>' containment reference.
	 * @see #getCapabilityMQTopicDestination()
	 * @generated
	 */
	void setCapabilityMQTopicDestination(MQTopicDestination value);

	/**
	 * Returns the value of the '<em><b>Unit MQ Activation Specification Unit</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Unit MQ Activation Specification Unit</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Unit MQ Activation Specification Unit</em>' containment reference.
	 * @see #setUnitMQActivationSpecificationUnit(MQActivationSpecificationUnit)
	 * @see com.ibm.ccl.soa.deploy.mq.MqPackage#getMQRoot_UnitMQActivationSpecificationUnit()
	 * @model containment="true" upper="-2" transient="true" volatile="true" derived="true"
	 *        extendedMetaData="kind='element' name='unit.MQActivationSpecificationUnit' namespace='##targetNamespace' affiliation='http://www.ibm.com/ccl/soa/deploy/core/1.0.0/#unit'"
	 * @generated
	 */
	MQActivationSpecificationUnit getUnitMQActivationSpecificationUnit();

	/**
	 * Sets the value of the '{@link com.ibm.ccl.soa.deploy.mq.MQRoot#getUnitMQActivationSpecificationUnit <em>Unit MQ Activation Specification Unit</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Unit MQ Activation Specification Unit</em>' containment reference.
	 * @see #getUnitMQActivationSpecificationUnit()
	 * @generated
	 */
	void setUnitMQActivationSpecificationUnit(MQActivationSpecificationUnit value);

	/**
	 * Returns the value of the '<em><b>Unit MQ Base System Unit</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Unit MQ Base System Unit</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Unit MQ Base System Unit</em>' containment reference.
	 * @see #setUnitMQBaseSystemUnit(MQBaseSystemUnit)
	 * @see com.ibm.ccl.soa.deploy.mq.MqPackage#getMQRoot_UnitMQBaseSystemUnit()
	 * @model containment="true" upper="-2" transient="true" volatile="true" derived="true"
	 *        extendedMetaData="kind='element' name='unit.MQBaseSystemUnit' namespace='##targetNamespace' affiliation='http://www.ibm.com/ccl/soa/deploy/core/1.0.0/#unit'"
	 * @generated
	 */
	MQBaseSystemUnit getUnitMQBaseSystemUnit();

	/**
	 * Sets the value of the '{@link com.ibm.ccl.soa.deploy.mq.MQRoot#getUnitMQBaseSystemUnit <em>Unit MQ Base System Unit</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Unit MQ Base System Unit</em>' containment reference.
	 * @see #getUnitMQBaseSystemUnit()
	 * @generated
	 */
	void setUnitMQBaseSystemUnit(MQBaseSystemUnit value);

	/**
	 * Returns the value of the '<em><b>Unit MQ Connection Factories Unit</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Unit MQ Connection Factories Unit</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Unit MQ Connection Factories Unit</em>' containment reference.
	 * @see #setUnitMQConnectionFactoriesUnit(MQConnectionFactoriesUnit)
	 * @see com.ibm.ccl.soa.deploy.mq.MqPackage#getMQRoot_UnitMQConnectionFactoriesUnit()
	 * @model containment="true" upper="-2" transient="true" volatile="true" derived="true"
	 *        extendedMetaData="kind='element' name='unit.MQConnectionFactoriesUnit' namespace='##targetNamespace' affiliation='http://www.ibm.com/ccl/soa/deploy/core/1.0.0/#unit'"
	 * @generated
	 */
	MQConnectionFactoriesUnit getUnitMQConnectionFactoriesUnit();

	/**
	 * Sets the value of the '{@link com.ibm.ccl.soa.deploy.mq.MQRoot#getUnitMQConnectionFactoriesUnit <em>Unit MQ Connection Factories Unit</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Unit MQ Connection Factories Unit</em>' containment reference.
	 * @see #getUnitMQConnectionFactoriesUnit()
	 * @generated
	 */
	void setUnitMQConnectionFactoriesUnit(MQConnectionFactoriesUnit value);

	/**
	 * Returns the value of the '<em><b>Unit MQ Listener Unit</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Unit MQ Listener Unit</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Unit MQ Listener Unit</em>' containment reference.
	 * @see #setUnitMQListenerUnit(MQListenerUnit)
	 * @see com.ibm.ccl.soa.deploy.mq.MqPackage#getMQRoot_UnitMQListenerUnit()
	 * @model containment="true" upper="-2" transient="true" volatile="true" derived="true"
	 *        extendedMetaData="kind='element' name='unit.MQListenerUnit' namespace='##targetNamespace' affiliation='http://www.ibm.com/ccl/soa/deploy/core/1.0.0/#unit'"
	 * @generated
	 */
	MQListenerUnit getUnitMQListenerUnit();

	/**
	 * Sets the value of the '{@link com.ibm.ccl.soa.deploy.mq.MQRoot#getUnitMQListenerUnit <em>Unit MQ Listener Unit</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Unit MQ Listener Unit</em>' containment reference.
	 * @see #getUnitMQListenerUnit()
	 * @generated
	 */
	void setUnitMQListenerUnit(MQListenerUnit value);

	/**
	 * Returns the value of the '<em><b>Unit MQ Message Listner Service Port Unit</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Unit MQ Message Listner Service Port Unit</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Unit MQ Message Listner Service Port Unit</em>' containment reference.
	 * @see #setUnitMQMessageListnerServicePortUnit(MQMessageListnerServicePortUnit)
	 * @see com.ibm.ccl.soa.deploy.mq.MqPackage#getMQRoot_UnitMQMessageListnerServicePortUnit()
	 * @model containment="true" upper="-2" transient="true" volatile="true" derived="true"
	 *        extendedMetaData="kind='element' name='unit.MQMessageListnerServicePortUnit' namespace='##targetNamespace' affiliation='http://www.ibm.com/ccl/soa/deploy/core/1.0.0/#unit'"
	 * @generated
	 */
	MQMessageListnerServicePortUnit getUnitMQMessageListnerServicePortUnit();

	/**
	 * Sets the value of the '{@link com.ibm.ccl.soa.deploy.mq.MQRoot#getUnitMQMessageListnerServicePortUnit <em>Unit MQ Message Listner Service Port Unit</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Unit MQ Message Listner Service Port Unit</em>' containment reference.
	 * @see #getUnitMQMessageListnerServicePortUnit()
	 * @generated
	 */
	void setUnitMQMessageListnerServicePortUnit(MQMessageListnerServicePortUnit value);

	/**
	 * Returns the value of the '<em><b>Unit MQ Messaging Provider Unit</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Unit MQ Messaging Provider Unit</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Unit MQ Messaging Provider Unit</em>' containment reference.
	 * @see #setUnitMQMessagingProviderUnit(MQMessagingProviderUnit)
	 * @see com.ibm.ccl.soa.deploy.mq.MqPackage#getMQRoot_UnitMQMessagingProviderUnit()
	 * @model containment="true" upper="-2" transient="true" volatile="true" derived="true"
	 *        extendedMetaData="kind='element' name='unit.MQMessagingProviderUnit' namespace='##targetNamespace' affiliation='http://www.ibm.com/ccl/soa/deploy/core/1.0.0/#unit'"
	 * @generated
	 */
	MQMessagingProviderUnit getUnitMQMessagingProviderUnit();

	/**
	 * Sets the value of the '{@link com.ibm.ccl.soa.deploy.mq.MQRoot#getUnitMQMessagingProviderUnit <em>Unit MQ Messaging Provider Unit</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Unit MQ Messaging Provider Unit</em>' containment reference.
	 * @see #getUnitMQMessagingProviderUnit()
	 * @generated
	 */
	void setUnitMQMessagingProviderUnit(MQMessagingProviderUnit value);

	/**
	 * Returns the value of the '<em><b>Unit MQ Queue Channel Unit</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Unit MQ Queue Channel Unit</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Unit MQ Queue Channel Unit</em>' containment reference.
	 * @see #setUnitMQQueueChannelUnit(MQQueueChannelUnit)
	 * @see com.ibm.ccl.soa.deploy.mq.MqPackage#getMQRoot_UnitMQQueueChannelUnit()
	 * @model containment="true" upper="-2" transient="true" volatile="true" derived="true"
	 *        extendedMetaData="kind='element' name='unit.MQQueueChannelUnit' namespace='##targetNamespace' affiliation='http://www.ibm.com/ccl/soa/deploy/core/1.0.0/#unit'"
	 * @generated
	 */
	MQQueueChannelUnit getUnitMQQueueChannelUnit();

	/**
	 * Sets the value of the '{@link com.ibm.ccl.soa.deploy.mq.MQRoot#getUnitMQQueueChannelUnit <em>Unit MQ Queue Channel Unit</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Unit MQ Queue Channel Unit</em>' containment reference.
	 * @see #getUnitMQQueueChannelUnit()
	 * @generated
	 */
	void setUnitMQQueueChannelUnit(MQQueueChannelUnit value);

	/**
	 * Returns the value of the '<em><b>Unit MQ Queue Connection Factory Unit</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Unit MQ Queue Connection Factory Unit</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Unit MQ Queue Connection Factory Unit</em>' containment reference.
	 * @see #setUnitMQQueueConnectionFactoryUnit(MQQueueConnectionFactoryUnit)
	 * @see com.ibm.ccl.soa.deploy.mq.MqPackage#getMQRoot_UnitMQQueueConnectionFactoryUnit()
	 * @model containment="true" upper="-2" transient="true" volatile="true" derived="true"
	 *        extendedMetaData="kind='element' name='unit.MQQueueConnectionFactoryUnit' namespace='##targetNamespace' affiliation='http://www.ibm.com/ccl/soa/deploy/core/1.0.0/#unit'"
	 * @generated
	 */
	MQQueueConnectionFactoryUnit getUnitMQQueueConnectionFactoryUnit();

	/**
	 * Sets the value of the '{@link com.ibm.ccl.soa.deploy.mq.MQRoot#getUnitMQQueueConnectionFactoryUnit <em>Unit MQ Queue Connection Factory Unit</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Unit MQ Queue Connection Factory Unit</em>' containment reference.
	 * @see #getUnitMQQueueConnectionFactoryUnit()
	 * @generated
	 */
	void setUnitMQQueueConnectionFactoryUnit(MQQueueConnectionFactoryUnit value);

	/**
	 * Returns the value of the '<em><b>Unit MQ Queue Destination Unit</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Unit MQ Queue Destination Unit</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Unit MQ Queue Destination Unit</em>' containment reference.
	 * @see #setUnitMQQueueDestinationUnit(MQQueueDestinationUnit)
	 * @see com.ibm.ccl.soa.deploy.mq.MqPackage#getMQRoot_UnitMQQueueDestinationUnit()
	 * @model containment="true" upper="-2" transient="true" volatile="true" derived="true"
	 *        extendedMetaData="kind='element' name='unit.MQQueueDestinationUnit' namespace='##targetNamespace' affiliation='http://www.ibm.com/ccl/soa/deploy/core/1.0.0/#unit'"
	 * @generated
	 */
	MQQueueDestinationUnit getUnitMQQueueDestinationUnit();

	/**
	 * Sets the value of the '{@link com.ibm.ccl.soa.deploy.mq.MQRoot#getUnitMQQueueDestinationUnit <em>Unit MQ Queue Destination Unit</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Unit MQ Queue Destination Unit</em>' containment reference.
	 * @see #getUnitMQQueueDestinationUnit()
	 * @generated
	 */
	void setUnitMQQueueDestinationUnit(MQQueueDestinationUnit value);

	/**
	 * Returns the value of the '<em><b>Unit MQ Queue Manager Unit</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Unit MQ Queue Manager Unit</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Unit MQ Queue Manager Unit</em>' containment reference.
	 * @see #setUnitMQQueueManagerUnit(MQQueueManagerUnit)
	 * @see com.ibm.ccl.soa.deploy.mq.MqPackage#getMQRoot_UnitMQQueueManagerUnit()
	 * @model containment="true" upper="-2" transient="true" volatile="true" derived="true"
	 *        extendedMetaData="kind='element' name='unit.MQQueueManagerUnit' namespace='##targetNamespace' affiliation='http://www.ibm.com/ccl/soa/deploy/core/1.0.0/#unit'"
	 * @generated
	 */
	MQQueueManagerUnit getUnitMQQueueManagerUnit();

	/**
	 * Sets the value of the '{@link com.ibm.ccl.soa.deploy.mq.MQRoot#getUnitMQQueueManagerUnit <em>Unit MQ Queue Manager Unit</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Unit MQ Queue Manager Unit</em>' containment reference.
	 * @see #getUnitMQQueueManagerUnit()
	 * @generated
	 */
	void setUnitMQQueueManagerUnit(MQQueueManagerUnit value);

	/**
	 * Returns the value of the '<em><b>Unit MQ Queue Unit</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Unit MQ Queue Unit</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Unit MQ Queue Unit</em>' containment reference.
	 * @see #setUnitMQQueueUnit(MQQueueUnit)
	 * @see com.ibm.ccl.soa.deploy.mq.MqPackage#getMQRoot_UnitMQQueueUnit()
	 * @model containment="true" upper="-2" transient="true" volatile="true" derived="true"
	 *        extendedMetaData="kind='element' name='unit.MQQueueUnit' namespace='##targetNamespace' affiliation='http://www.ibm.com/ccl/soa/deploy/core/1.0.0/#unit'"
	 * @generated
	 */
	MQQueueUnit getUnitMQQueueUnit();

	/**
	 * Sets the value of the '{@link com.ibm.ccl.soa.deploy.mq.MQRoot#getUnitMQQueueUnit <em>Unit MQ Queue Unit</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Unit MQ Queue Unit</em>' containment reference.
	 * @see #getUnitMQQueueUnit()
	 * @generated
	 */
	void setUnitMQQueueUnit(MQQueueUnit value);

	/**
	 * Returns the value of the '<em><b>Unit MQ Topic Connection Factory Unit</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Unit MQ Topic Connection Factory Unit</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Unit MQ Topic Connection Factory Unit</em>' containment reference.
	 * @see #setUnitMQTopicConnectionFactoryUnit(MQTopicConnectionFactoryUnit)
	 * @see com.ibm.ccl.soa.deploy.mq.MqPackage#getMQRoot_UnitMQTopicConnectionFactoryUnit()
	 * @model containment="true" upper="-2" transient="true" volatile="true" derived="true"
	 *        extendedMetaData="kind='element' name='unit.MQTopicConnectionFactoryUnit' namespace='##targetNamespace' affiliation='http://www.ibm.com/ccl/soa/deploy/core/1.0.0/#unit'"
	 * @generated
	 */
	MQTopicConnectionFactoryUnit getUnitMQTopicConnectionFactoryUnit();

	/**
	 * Sets the value of the '{@link com.ibm.ccl.soa.deploy.mq.MQRoot#getUnitMQTopicConnectionFactoryUnit <em>Unit MQ Topic Connection Factory Unit</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Unit MQ Topic Connection Factory Unit</em>' containment reference.
	 * @see #getUnitMQTopicConnectionFactoryUnit()
	 * @generated
	 */
	void setUnitMQTopicConnectionFactoryUnit(MQTopicConnectionFactoryUnit value);

	/**
	 * Returns the value of the '<em><b>Unit MQ Topic Destination Unit</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Unit MQ Topic Destination Unit</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Unit MQ Topic Destination Unit</em>' containment reference.
	 * @see #setUnitMQTopicDestinationUnit(MQTopicDestinationUnit)
	 * @see com.ibm.ccl.soa.deploy.mq.MqPackage#getMQRoot_UnitMQTopicDestinationUnit()
	 * @model containment="true" upper="-2" transient="true" volatile="true" derived="true"
	 *        extendedMetaData="kind='element' name='unit.MQTopicDestinationUnit' namespace='##targetNamespace' affiliation='http://www.ibm.com/ccl/soa/deploy/core/1.0.0/#unit'"
	 * @generated
	 */
	MQTopicDestinationUnit getUnitMQTopicDestinationUnit();

	/**
	 * Sets the value of the '{@link com.ibm.ccl.soa.deploy.mq.MQRoot#getUnitMQTopicDestinationUnit <em>Unit MQ Topic Destination Unit</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Unit MQ Topic Destination Unit</em>' containment reference.
	 * @see #getUnitMQTopicDestinationUnit()
	 * @generated
	 */
	void setUnitMQTopicDestinationUnit(MQTopicDestinationUnit value);

} // MQRoot
