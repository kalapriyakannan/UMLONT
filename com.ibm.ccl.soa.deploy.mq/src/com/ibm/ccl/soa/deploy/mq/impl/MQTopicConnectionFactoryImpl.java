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
import com.ibm.ccl.soa.deploy.mq.MQTopicConnectionFactory;
import com.ibm.ccl.soa.deploy.mq.MqPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>MQ Topic Connection Factory</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link com.ibm.ccl.soa.deploy.mq.impl.MQTopicConnectionFactoryImpl#getBrokerCCSubscriptionQueue <em>Broker CC Subscription Queue</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.mq.impl.MQTopicConnectionFactoryImpl#getBrokerControlQueue <em>Broker Control Queue</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.mq.impl.MQTopicConnectionFactoryImpl#getBrokerMessageSelection <em>Broker Message Selection</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.mq.impl.MQTopicConnectionFactoryImpl#getBrokerPublicationQueue <em>Broker Publication Queue</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.mq.impl.MQTopicConnectionFactoryImpl#getBrokerQueueManager <em>Broker Queue Manager</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.mq.impl.MQTopicConnectionFactoryImpl#getBrokerSubscriptionQueue <em>Broker Subscription Queue</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.mq.impl.MQTopicConnectionFactoryImpl#getBrokerVersion <em>Broker Version</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.mq.impl.MQTopicConnectionFactoryImpl#getCategory <em>Category</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.mq.impl.MQTopicConnectionFactoryImpl#getCCSIDId <em>CCSID Id</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.mq.impl.MQTopicConnectionFactoryImpl#getChannel <em>Channel</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.mq.impl.MQTopicConnectionFactoryImpl#getClientId <em>Client Id</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.mq.impl.MQTopicConnectionFactoryImpl#getComponentManagedAuthenticationAlias <em>Component Managed Authentication Alias</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.mq.impl.MQTopicConnectionFactoryImpl#getContainerManagedAuthenticationAlias <em>Container Managed Authentication Alias</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.mq.impl.MQTopicConnectionFactoryImpl#getDescription1 <em>Description1</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.mq.impl.MQTopicConnectionFactoryImpl#getDirectBrokerAuthorization <em>Direct Broker Authorization</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.mq.impl.MQTopicConnectionFactoryImpl#getEnableCloneSupport <em>Enable Clone Support</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.mq.impl.MQTopicConnectionFactoryImpl#getEnableMQConnectionPooling <em>Enable MQ Connection Pooling</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.mq.impl.MQTopicConnectionFactoryImpl#getEnableMulticastTransport <em>Enable Multicast Transport</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.mq.impl.MQTopicConnectionFactoryImpl#getEnableReturnMethodsDuringShutdown <em>Enable Return Methods During Shutdown</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.mq.impl.MQTopicConnectionFactoryImpl#getFactoryName <em>Factory Name</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.mq.impl.MQTopicConnectionFactoryImpl#getHost <em>Host</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.mq.impl.MQTopicConnectionFactoryImpl#getJndiName <em>Jndi Name</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.mq.impl.MQTopicConnectionFactoryImpl#getLocalServerAddress <em>Local Server Address</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.mq.impl.MQTopicConnectionFactoryImpl#getMappingConfigurationAlias <em>Mapping Configuration Alias</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.mq.impl.MQTopicConnectionFactoryImpl#getModelQueueDefinition <em>Model Queue Definition</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.mq.impl.MQTopicConnectionFactoryImpl#getPersistentSubscriptionStore <em>Persistent Subscription Store</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.mq.impl.MQTopicConnectionFactoryImpl#getPollingInterval <em>Polling Interval</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.mq.impl.MQTopicConnectionFactoryImpl#getPort <em>Port</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.mq.impl.MQTopicConnectionFactoryImpl#getProxyHostName <em>Proxy Host Name</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.mq.impl.MQTopicConnectionFactoryImpl#getProxyPort <em>Proxy Port</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.mq.impl.MQTopicConnectionFactoryImpl#getPublishAndAcknowledgeLevel <em>Publish And Acknowledge Level</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.mq.impl.MQTopicConnectionFactoryImpl#getPublishAndSubscribeCleanupInterval <em>Publish And Subscribe Cleanup Interval</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.mq.impl.MQTopicConnectionFactoryImpl#getPublishAndSubscribeCleanupLevel <em>Publish And Subscribe Cleanup Level</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.mq.impl.MQTopicConnectionFactoryImpl#getPublishAndSubscribeStatusInterval <em>Publish And Subscribe Status Interval</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.mq.impl.MQTopicConnectionFactoryImpl#getQueueManager <em>Queue Manager</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.mq.impl.MQTopicConnectionFactoryImpl#getRescanInterval <em>Rescan Interval</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.mq.impl.MQTopicConnectionFactoryImpl#getSSLCipherSuite <em>SSL Cipher Suite</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.mq.impl.MQTopicConnectionFactoryImpl#getSSLCRL <em>SSLCRL</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.mq.impl.MQTopicConnectionFactoryImpl#getSSLPeerName <em>SSL Peer Name</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.mq.impl.MQTopicConnectionFactoryImpl#getTransportType <em>Transport Type</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.mq.impl.MQTopicConnectionFactoryImpl#getXAEnabled <em>XA Enabled</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class MQTopicConnectionFactoryImpl extends CapabilityImpl implements MQTopicConnectionFactory {
	/**
	 * The default value of the '{@link #getBrokerCCSubscriptionQueue() <em>Broker CC Subscription Queue</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getBrokerCCSubscriptionQueue()
	 * @generated
	 * @ordered
	 */
	protected static final String BROKER_CC_SUBSCRIPTION_QUEUE_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getBrokerCCSubscriptionQueue() <em>Broker CC Subscription Queue</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getBrokerCCSubscriptionQueue()
	 * @generated
	 * @ordered
	 */
	protected String brokerCCSubscriptionQueue = BROKER_CC_SUBSCRIPTION_QUEUE_EDEFAULT;

	/**
	 * The default value of the '{@link #getBrokerControlQueue() <em>Broker Control Queue</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getBrokerControlQueue()
	 * @generated
	 * @ordered
	 */
	protected static final String BROKER_CONTROL_QUEUE_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getBrokerControlQueue() <em>Broker Control Queue</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getBrokerControlQueue()
	 * @generated
	 * @ordered
	 */
	protected String brokerControlQueue = BROKER_CONTROL_QUEUE_EDEFAULT;

	/**
	 * The default value of the '{@link #getBrokerMessageSelection() <em>Broker Message Selection</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getBrokerMessageSelection()
	 * @generated
	 * @ordered
	 */
	protected static final String BROKER_MESSAGE_SELECTION_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getBrokerMessageSelection() <em>Broker Message Selection</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getBrokerMessageSelection()
	 * @generated
	 * @ordered
	 */
	protected String brokerMessageSelection = BROKER_MESSAGE_SELECTION_EDEFAULT;

	/**
	 * The default value of the '{@link #getBrokerPublicationQueue() <em>Broker Publication Queue</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getBrokerPublicationQueue()
	 * @generated
	 * @ordered
	 */
	protected static final String BROKER_PUBLICATION_QUEUE_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getBrokerPublicationQueue() <em>Broker Publication Queue</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getBrokerPublicationQueue()
	 * @generated
	 * @ordered
	 */
	protected String brokerPublicationQueue = BROKER_PUBLICATION_QUEUE_EDEFAULT;

	/**
	 * The default value of the '{@link #getBrokerQueueManager() <em>Broker Queue Manager</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getBrokerQueueManager()
	 * @generated
	 * @ordered
	 */
	protected static final String BROKER_QUEUE_MANAGER_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getBrokerQueueManager() <em>Broker Queue Manager</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getBrokerQueueManager()
	 * @generated
	 * @ordered
	 */
	protected String brokerQueueManager = BROKER_QUEUE_MANAGER_EDEFAULT;

	/**
	 * The default value of the '{@link #getBrokerSubscriptionQueue() <em>Broker Subscription Queue</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getBrokerSubscriptionQueue()
	 * @generated
	 * @ordered
	 */
	protected static final String BROKER_SUBSCRIPTION_QUEUE_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getBrokerSubscriptionQueue() <em>Broker Subscription Queue</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getBrokerSubscriptionQueue()
	 * @generated
	 * @ordered
	 */
	protected String brokerSubscriptionQueue = BROKER_SUBSCRIPTION_QUEUE_EDEFAULT;

	/**
	 * The default value of the '{@link #getBrokerVersion() <em>Broker Version</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getBrokerVersion()
	 * @generated
	 * @ordered
	 */
	protected static final String BROKER_VERSION_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getBrokerVersion() <em>Broker Version</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getBrokerVersion()
	 * @generated
	 * @ordered
	 */
	protected String brokerVersion = BROKER_VERSION_EDEFAULT;

	/**
	 * The default value of the '{@link #getCategory() <em>Category</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getCategory()
	 * @generated
	 * @ordered
	 */
	protected static final String CATEGORY_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getCategory() <em>Category</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getCategory()
	 * @generated
	 * @ordered
	 */
	protected String category = CATEGORY_EDEFAULT;

	/**
	 * The default value of the '{@link #getCCSIDId() <em>CCSID Id</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getCCSIDId()
	 * @generated
	 * @ordered
	 */
	protected static final String CCSID_ID_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getCCSIDId() <em>CCSID Id</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getCCSIDId()
	 * @generated
	 * @ordered
	 */
	protected String cCSIDId = CCSID_ID_EDEFAULT;

	/**
	 * The default value of the '{@link #getChannel() <em>Channel</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getChannel()
	 * @generated
	 * @ordered
	 */
	protected static final String CHANNEL_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getChannel() <em>Channel</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getChannel()
	 * @generated
	 * @ordered
	 */
	protected String channel = CHANNEL_EDEFAULT;

	/**
	 * The default value of the '{@link #getClientId() <em>Client Id</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getClientId()
	 * @generated
	 * @ordered
	 */
	protected static final String CLIENT_ID_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getClientId() <em>Client Id</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getClientId()
	 * @generated
	 * @ordered
	 */
	protected String clientId = CLIENT_ID_EDEFAULT;

	/**
	 * The default value of the '{@link #getComponentManagedAuthenticationAlias() <em>Component Managed Authentication Alias</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getComponentManagedAuthenticationAlias()
	 * @generated
	 * @ordered
	 */
	protected static final String COMPONENT_MANAGED_AUTHENTICATION_ALIAS_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getComponentManagedAuthenticationAlias() <em>Component Managed Authentication Alias</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getComponentManagedAuthenticationAlias()
	 * @generated
	 * @ordered
	 */
	protected String componentManagedAuthenticationAlias = COMPONENT_MANAGED_AUTHENTICATION_ALIAS_EDEFAULT;

	/**
	 * The default value of the '{@link #getContainerManagedAuthenticationAlias() <em>Container Managed Authentication Alias</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getContainerManagedAuthenticationAlias()
	 * @generated
	 * @ordered
	 */
	protected static final String CONTAINER_MANAGED_AUTHENTICATION_ALIAS_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getContainerManagedAuthenticationAlias() <em>Container Managed Authentication Alias</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getContainerManagedAuthenticationAlias()
	 * @generated
	 * @ordered
	 */
	protected String containerManagedAuthenticationAlias = CONTAINER_MANAGED_AUTHENTICATION_ALIAS_EDEFAULT;

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
	 * The default value of the '{@link #getDirectBrokerAuthorization() <em>Direct Broker Authorization</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDirectBrokerAuthorization()
	 * @generated
	 * @ordered
	 */
	protected static final String DIRECT_BROKER_AUTHORIZATION_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getDirectBrokerAuthorization() <em>Direct Broker Authorization</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDirectBrokerAuthorization()
	 * @generated
	 * @ordered
	 */
	protected String directBrokerAuthorization = DIRECT_BROKER_AUTHORIZATION_EDEFAULT;

	/**
	 * The default value of the '{@link #getEnableCloneSupport() <em>Enable Clone Support</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getEnableCloneSupport()
	 * @generated
	 * @ordered
	 */
	protected static final String ENABLE_CLONE_SUPPORT_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getEnableCloneSupport() <em>Enable Clone Support</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getEnableCloneSupport()
	 * @generated
	 * @ordered
	 */
	protected String enableCloneSupport = ENABLE_CLONE_SUPPORT_EDEFAULT;

	/**
	 * The default value of the '{@link #getEnableMQConnectionPooling() <em>Enable MQ Connection Pooling</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getEnableMQConnectionPooling()
	 * @generated
	 * @ordered
	 */
	protected static final String ENABLE_MQ_CONNECTION_POOLING_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getEnableMQConnectionPooling() <em>Enable MQ Connection Pooling</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getEnableMQConnectionPooling()
	 * @generated
	 * @ordered
	 */
	protected String enableMQConnectionPooling = ENABLE_MQ_CONNECTION_POOLING_EDEFAULT;

	/**
	 * The default value of the '{@link #getEnableMulticastTransport() <em>Enable Multicast Transport</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getEnableMulticastTransport()
	 * @generated
	 * @ordered
	 */
	protected static final String ENABLE_MULTICAST_TRANSPORT_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getEnableMulticastTransport() <em>Enable Multicast Transport</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getEnableMulticastTransport()
	 * @generated
	 * @ordered
	 */
	protected String enableMulticastTransport = ENABLE_MULTICAST_TRANSPORT_EDEFAULT;

	/**
	 * The default value of the '{@link #getEnableReturnMethodsDuringShutdown() <em>Enable Return Methods During Shutdown</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getEnableReturnMethodsDuringShutdown()
	 * @generated
	 * @ordered
	 */
	protected static final String ENABLE_RETURN_METHODS_DURING_SHUTDOWN_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getEnableReturnMethodsDuringShutdown() <em>Enable Return Methods During Shutdown</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getEnableReturnMethodsDuringShutdown()
	 * @generated
	 * @ordered
	 */
	protected String enableReturnMethodsDuringShutdown = ENABLE_RETURN_METHODS_DURING_SHUTDOWN_EDEFAULT;

	/**
	 * The default value of the '{@link #getFactoryName() <em>Factory Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getFactoryName()
	 * @generated
	 * @ordered
	 */
	protected static final String FACTORY_NAME_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getFactoryName() <em>Factory Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getFactoryName()
	 * @generated
	 * @ordered
	 */
	protected String factoryName = FACTORY_NAME_EDEFAULT;

	/**
	 * The default value of the '{@link #getHost() <em>Host</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getHost()
	 * @generated
	 * @ordered
	 */
	protected static final String HOST_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getHost() <em>Host</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getHost()
	 * @generated
	 * @ordered
	 */
	protected String host = HOST_EDEFAULT;

	/**
	 * The default value of the '{@link #getJndiName() <em>Jndi Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getJndiName()
	 * @generated
	 * @ordered
	 */
	protected static final String JNDI_NAME_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getJndiName() <em>Jndi Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getJndiName()
	 * @generated
	 * @ordered
	 */
	protected String jndiName = JNDI_NAME_EDEFAULT;

	/**
	 * The default value of the '{@link #getLocalServerAddress() <em>Local Server Address</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getLocalServerAddress()
	 * @generated
	 * @ordered
	 */
	protected static final String LOCAL_SERVER_ADDRESS_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getLocalServerAddress() <em>Local Server Address</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getLocalServerAddress()
	 * @generated
	 * @ordered
	 */
	protected String localServerAddress = LOCAL_SERVER_ADDRESS_EDEFAULT;

	/**
	 * The default value of the '{@link #getMappingConfigurationAlias() <em>Mapping Configuration Alias</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getMappingConfigurationAlias()
	 * @generated
	 * @ordered
	 */
	protected static final String MAPPING_CONFIGURATION_ALIAS_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getMappingConfigurationAlias() <em>Mapping Configuration Alias</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getMappingConfigurationAlias()
	 * @generated
	 * @ordered
	 */
	protected String mappingConfigurationAlias = MAPPING_CONFIGURATION_ALIAS_EDEFAULT;

	/**
	 * The default value of the '{@link #getModelQueueDefinition() <em>Model Queue Definition</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getModelQueueDefinition()
	 * @generated
	 * @ordered
	 */
	protected static final String MODEL_QUEUE_DEFINITION_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getModelQueueDefinition() <em>Model Queue Definition</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getModelQueueDefinition()
	 * @generated
	 * @ordered
	 */
	protected String modelQueueDefinition = MODEL_QUEUE_DEFINITION_EDEFAULT;

	/**
	 * The default value of the '{@link #getPersistentSubscriptionStore() <em>Persistent Subscription Store</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getPersistentSubscriptionStore()
	 * @generated
	 * @ordered
	 */
	protected static final String PERSISTENT_SUBSCRIPTION_STORE_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getPersistentSubscriptionStore() <em>Persistent Subscription Store</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getPersistentSubscriptionStore()
	 * @generated
	 * @ordered
	 */
	protected String persistentSubscriptionStore = PERSISTENT_SUBSCRIPTION_STORE_EDEFAULT;

	/**
	 * The default value of the '{@link #getPollingInterval() <em>Polling Interval</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getPollingInterval()
	 * @generated
	 * @ordered
	 */
	protected static final String POLLING_INTERVAL_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getPollingInterval() <em>Polling Interval</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getPollingInterval()
	 * @generated
	 * @ordered
	 */
	protected String pollingInterval = POLLING_INTERVAL_EDEFAULT;

	/**
	 * The default value of the '{@link #getPort() <em>Port</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getPort()
	 * @generated
	 * @ordered
	 */
	protected static final String PORT_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getPort() <em>Port</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getPort()
	 * @generated
	 * @ordered
	 */
	protected String port = PORT_EDEFAULT;

	/**
	 * The default value of the '{@link #getProxyHostName() <em>Proxy Host Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getProxyHostName()
	 * @generated
	 * @ordered
	 */
	protected static final String PROXY_HOST_NAME_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getProxyHostName() <em>Proxy Host Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getProxyHostName()
	 * @generated
	 * @ordered
	 */
	protected String proxyHostName = PROXY_HOST_NAME_EDEFAULT;

	/**
	 * The default value of the '{@link #getProxyPort() <em>Proxy Port</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getProxyPort()
	 * @generated
	 * @ordered
	 */
	protected static final String PROXY_PORT_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getProxyPort() <em>Proxy Port</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getProxyPort()
	 * @generated
	 * @ordered
	 */
	protected String proxyPort = PROXY_PORT_EDEFAULT;

	/**
	 * The default value of the '{@link #getPublishAndAcknowledgeLevel() <em>Publish And Acknowledge Level</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getPublishAndAcknowledgeLevel()
	 * @generated
	 * @ordered
	 */
	protected static final String PUBLISH_AND_ACKNOWLEDGE_LEVEL_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getPublishAndAcknowledgeLevel() <em>Publish And Acknowledge Level</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getPublishAndAcknowledgeLevel()
	 * @generated
	 * @ordered
	 */
	protected String publishAndAcknowledgeLevel = PUBLISH_AND_ACKNOWLEDGE_LEVEL_EDEFAULT;

	/**
	 * The default value of the '{@link #getPublishAndSubscribeCleanupInterval() <em>Publish And Subscribe Cleanup Interval</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getPublishAndSubscribeCleanupInterval()
	 * @generated
	 * @ordered
	 */
	protected static final String PUBLISH_AND_SUBSCRIBE_CLEANUP_INTERVAL_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getPublishAndSubscribeCleanupInterval() <em>Publish And Subscribe Cleanup Interval</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getPublishAndSubscribeCleanupInterval()
	 * @generated
	 * @ordered
	 */
	protected String publishAndSubscribeCleanupInterval = PUBLISH_AND_SUBSCRIBE_CLEANUP_INTERVAL_EDEFAULT;

	/**
	 * The default value of the '{@link #getPublishAndSubscribeCleanupLevel() <em>Publish And Subscribe Cleanup Level</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getPublishAndSubscribeCleanupLevel()
	 * @generated
	 * @ordered
	 */
	protected static final String PUBLISH_AND_SUBSCRIBE_CLEANUP_LEVEL_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getPublishAndSubscribeCleanupLevel() <em>Publish And Subscribe Cleanup Level</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getPublishAndSubscribeCleanupLevel()
	 * @generated
	 * @ordered
	 */
	protected String publishAndSubscribeCleanupLevel = PUBLISH_AND_SUBSCRIBE_CLEANUP_LEVEL_EDEFAULT;

	/**
	 * The default value of the '{@link #getPublishAndSubscribeStatusInterval() <em>Publish And Subscribe Status Interval</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getPublishAndSubscribeStatusInterval()
	 * @generated
	 * @ordered
	 */
	protected static final String PUBLISH_AND_SUBSCRIBE_STATUS_INTERVAL_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getPublishAndSubscribeStatusInterval() <em>Publish And Subscribe Status Interval</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getPublishAndSubscribeStatusInterval()
	 * @generated
	 * @ordered
	 */
	protected String publishAndSubscribeStatusInterval = PUBLISH_AND_SUBSCRIBE_STATUS_INTERVAL_EDEFAULT;

	/**
	 * The default value of the '{@link #getQueueManager() <em>Queue Manager</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getQueueManager()
	 * @generated
	 * @ordered
	 */
	protected static final String QUEUE_MANAGER_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getQueueManager() <em>Queue Manager</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getQueueManager()
	 * @generated
	 * @ordered
	 */
	protected String queueManager = QUEUE_MANAGER_EDEFAULT;

	/**
	 * The default value of the '{@link #getRescanInterval() <em>Rescan Interval</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getRescanInterval()
	 * @generated
	 * @ordered
	 */
	protected static final String RESCAN_INTERVAL_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getRescanInterval() <em>Rescan Interval</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getRescanInterval()
	 * @generated
	 * @ordered
	 */
	protected String rescanInterval = RESCAN_INTERVAL_EDEFAULT;

	/**
	 * The default value of the '{@link #getSSLCipherSuite() <em>SSL Cipher Suite</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSSLCipherSuite()
	 * @generated
	 * @ordered
	 */
	protected static final String SSL_CIPHER_SUITE_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getSSLCipherSuite() <em>SSL Cipher Suite</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSSLCipherSuite()
	 * @generated
	 * @ordered
	 */
	protected String sSLCipherSuite = SSL_CIPHER_SUITE_EDEFAULT;

	/**
	 * The default value of the '{@link #getSSLCRL() <em>SSLCRL</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSSLCRL()
	 * @generated
	 * @ordered
	 */
	protected static final String SSLCRL_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getSSLCRL() <em>SSLCRL</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSSLCRL()
	 * @generated
	 * @ordered
	 */
	protected String sSLCRL = SSLCRL_EDEFAULT;

	/**
	 * The default value of the '{@link #getSSLPeerName() <em>SSL Peer Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSSLPeerName()
	 * @generated
	 * @ordered
	 */
	protected static final String SSL_PEER_NAME_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getSSLPeerName() <em>SSL Peer Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSSLPeerName()
	 * @generated
	 * @ordered
	 */
	protected String sSLPeerName = SSL_PEER_NAME_EDEFAULT;

	/**
	 * The default value of the '{@link #getTransportType() <em>Transport Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTransportType()
	 * @generated
	 * @ordered
	 */
	protected static final String TRANSPORT_TYPE_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getTransportType() <em>Transport Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTransportType()
	 * @generated
	 * @ordered
	 */
	protected String transportType = TRANSPORT_TYPE_EDEFAULT;

	/**
	 * The default value of the '{@link #getXAEnabled() <em>XA Enabled</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getXAEnabled()
	 * @generated
	 * @ordered
	 */
	protected static final String XA_ENABLED_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getXAEnabled() <em>XA Enabled</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getXAEnabled()
	 * @generated
	 * @ordered
	 */
	protected String xAEnabled = XA_ENABLED_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected MQTopicConnectionFactoryImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected EClass eStaticClass() {
		return MqPackage.Literals.MQ_TOPIC_CONNECTION_FACTORY;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getBrokerCCSubscriptionQueue() {
		return brokerCCSubscriptionQueue;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setBrokerCCSubscriptionQueue(String newBrokerCCSubscriptionQueue) {
		String oldBrokerCCSubscriptionQueue = brokerCCSubscriptionQueue;
		brokerCCSubscriptionQueue = newBrokerCCSubscriptionQueue;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, MqPackage.MQ_TOPIC_CONNECTION_FACTORY__BROKER_CC_SUBSCRIPTION_QUEUE, oldBrokerCCSubscriptionQueue, brokerCCSubscriptionQueue));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getBrokerControlQueue() {
		return brokerControlQueue;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setBrokerControlQueue(String newBrokerControlQueue) {
		String oldBrokerControlQueue = brokerControlQueue;
		brokerControlQueue = newBrokerControlQueue;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, MqPackage.MQ_TOPIC_CONNECTION_FACTORY__BROKER_CONTROL_QUEUE, oldBrokerControlQueue, brokerControlQueue));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getBrokerMessageSelection() {
		return brokerMessageSelection;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setBrokerMessageSelection(String newBrokerMessageSelection) {
		String oldBrokerMessageSelection = brokerMessageSelection;
		brokerMessageSelection = newBrokerMessageSelection;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, MqPackage.MQ_TOPIC_CONNECTION_FACTORY__BROKER_MESSAGE_SELECTION, oldBrokerMessageSelection, brokerMessageSelection));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getBrokerPublicationQueue() {
		return brokerPublicationQueue;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setBrokerPublicationQueue(String newBrokerPublicationQueue) {
		String oldBrokerPublicationQueue = brokerPublicationQueue;
		brokerPublicationQueue = newBrokerPublicationQueue;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, MqPackage.MQ_TOPIC_CONNECTION_FACTORY__BROKER_PUBLICATION_QUEUE, oldBrokerPublicationQueue, brokerPublicationQueue));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getBrokerQueueManager() {
		return brokerQueueManager;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setBrokerQueueManager(String newBrokerQueueManager) {
		String oldBrokerQueueManager = brokerQueueManager;
		brokerQueueManager = newBrokerQueueManager;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, MqPackage.MQ_TOPIC_CONNECTION_FACTORY__BROKER_QUEUE_MANAGER, oldBrokerQueueManager, brokerQueueManager));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getBrokerSubscriptionQueue() {
		return brokerSubscriptionQueue;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setBrokerSubscriptionQueue(String newBrokerSubscriptionQueue) {
		String oldBrokerSubscriptionQueue = brokerSubscriptionQueue;
		brokerSubscriptionQueue = newBrokerSubscriptionQueue;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, MqPackage.MQ_TOPIC_CONNECTION_FACTORY__BROKER_SUBSCRIPTION_QUEUE, oldBrokerSubscriptionQueue, brokerSubscriptionQueue));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getBrokerVersion() {
		return brokerVersion;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setBrokerVersion(String newBrokerVersion) {
		String oldBrokerVersion = brokerVersion;
		brokerVersion = newBrokerVersion;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, MqPackage.MQ_TOPIC_CONNECTION_FACTORY__BROKER_VERSION, oldBrokerVersion, brokerVersion));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getCategory() {
		return category;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setCategory(String newCategory) {
		String oldCategory = category;
		category = newCategory;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, MqPackage.MQ_TOPIC_CONNECTION_FACTORY__CATEGORY, oldCategory, category));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getCCSIDId() {
		return cCSIDId;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setCCSIDId(String newCCSIDId) {
		String oldCCSIDId = cCSIDId;
		cCSIDId = newCCSIDId;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, MqPackage.MQ_TOPIC_CONNECTION_FACTORY__CCSID_ID, oldCCSIDId, cCSIDId));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getChannel() {
		return channel;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setChannel(String newChannel) {
		String oldChannel = channel;
		channel = newChannel;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, MqPackage.MQ_TOPIC_CONNECTION_FACTORY__CHANNEL, oldChannel, channel));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getClientId() {
		return clientId;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setClientId(String newClientId) {
		String oldClientId = clientId;
		clientId = newClientId;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, MqPackage.MQ_TOPIC_CONNECTION_FACTORY__CLIENT_ID, oldClientId, clientId));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getComponentManagedAuthenticationAlias() {
		return componentManagedAuthenticationAlias;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setComponentManagedAuthenticationAlias(String newComponentManagedAuthenticationAlias) {
		String oldComponentManagedAuthenticationAlias = componentManagedAuthenticationAlias;
		componentManagedAuthenticationAlias = newComponentManagedAuthenticationAlias;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, MqPackage.MQ_TOPIC_CONNECTION_FACTORY__COMPONENT_MANAGED_AUTHENTICATION_ALIAS, oldComponentManagedAuthenticationAlias, componentManagedAuthenticationAlias));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getContainerManagedAuthenticationAlias() {
		return containerManagedAuthenticationAlias;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setContainerManagedAuthenticationAlias(String newContainerManagedAuthenticationAlias) {
		String oldContainerManagedAuthenticationAlias = containerManagedAuthenticationAlias;
		containerManagedAuthenticationAlias = newContainerManagedAuthenticationAlias;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, MqPackage.MQ_TOPIC_CONNECTION_FACTORY__CONTAINER_MANAGED_AUTHENTICATION_ALIAS, oldContainerManagedAuthenticationAlias, containerManagedAuthenticationAlias));
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
			eNotify(new ENotificationImpl(this, Notification.SET, MqPackage.MQ_TOPIC_CONNECTION_FACTORY__DESCRIPTION1, oldDescription1, description1));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getDirectBrokerAuthorization() {
		return directBrokerAuthorization;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setDirectBrokerAuthorization(String newDirectBrokerAuthorization) {
		String oldDirectBrokerAuthorization = directBrokerAuthorization;
		directBrokerAuthorization = newDirectBrokerAuthorization;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, MqPackage.MQ_TOPIC_CONNECTION_FACTORY__DIRECT_BROKER_AUTHORIZATION, oldDirectBrokerAuthorization, directBrokerAuthorization));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getEnableCloneSupport() {
		return enableCloneSupport;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setEnableCloneSupport(String newEnableCloneSupport) {
		String oldEnableCloneSupport = enableCloneSupport;
		enableCloneSupport = newEnableCloneSupport;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, MqPackage.MQ_TOPIC_CONNECTION_FACTORY__ENABLE_CLONE_SUPPORT, oldEnableCloneSupport, enableCloneSupport));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getEnableMQConnectionPooling() {
		return enableMQConnectionPooling;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setEnableMQConnectionPooling(String newEnableMQConnectionPooling) {
		String oldEnableMQConnectionPooling = enableMQConnectionPooling;
		enableMQConnectionPooling = newEnableMQConnectionPooling;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, MqPackage.MQ_TOPIC_CONNECTION_FACTORY__ENABLE_MQ_CONNECTION_POOLING, oldEnableMQConnectionPooling, enableMQConnectionPooling));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getEnableMulticastTransport() {
		return enableMulticastTransport;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setEnableMulticastTransport(String newEnableMulticastTransport) {
		String oldEnableMulticastTransport = enableMulticastTransport;
		enableMulticastTransport = newEnableMulticastTransport;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, MqPackage.MQ_TOPIC_CONNECTION_FACTORY__ENABLE_MULTICAST_TRANSPORT, oldEnableMulticastTransport, enableMulticastTransport));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getEnableReturnMethodsDuringShutdown() {
		return enableReturnMethodsDuringShutdown;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setEnableReturnMethodsDuringShutdown(String newEnableReturnMethodsDuringShutdown) {
		String oldEnableReturnMethodsDuringShutdown = enableReturnMethodsDuringShutdown;
		enableReturnMethodsDuringShutdown = newEnableReturnMethodsDuringShutdown;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, MqPackage.MQ_TOPIC_CONNECTION_FACTORY__ENABLE_RETURN_METHODS_DURING_SHUTDOWN, oldEnableReturnMethodsDuringShutdown, enableReturnMethodsDuringShutdown));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getFactoryName() {
		return factoryName;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setFactoryName(String newFactoryName) {
		String oldFactoryName = factoryName;
		factoryName = newFactoryName;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, MqPackage.MQ_TOPIC_CONNECTION_FACTORY__FACTORY_NAME, oldFactoryName, factoryName));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getHost() {
		return host;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setHost(String newHost) {
		String oldHost = host;
		host = newHost;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, MqPackage.MQ_TOPIC_CONNECTION_FACTORY__HOST, oldHost, host));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getJndiName() {
		return jndiName;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setJndiName(String newJndiName) {
		String oldJndiName = jndiName;
		jndiName = newJndiName;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, MqPackage.MQ_TOPIC_CONNECTION_FACTORY__JNDI_NAME, oldJndiName, jndiName));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getLocalServerAddress() {
		return localServerAddress;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setLocalServerAddress(String newLocalServerAddress) {
		String oldLocalServerAddress = localServerAddress;
		localServerAddress = newLocalServerAddress;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, MqPackage.MQ_TOPIC_CONNECTION_FACTORY__LOCAL_SERVER_ADDRESS, oldLocalServerAddress, localServerAddress));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getMappingConfigurationAlias() {
		return mappingConfigurationAlias;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setMappingConfigurationAlias(String newMappingConfigurationAlias) {
		String oldMappingConfigurationAlias = mappingConfigurationAlias;
		mappingConfigurationAlias = newMappingConfigurationAlias;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, MqPackage.MQ_TOPIC_CONNECTION_FACTORY__MAPPING_CONFIGURATION_ALIAS, oldMappingConfigurationAlias, mappingConfigurationAlias));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getModelQueueDefinition() {
		return modelQueueDefinition;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setModelQueueDefinition(String newModelQueueDefinition) {
		String oldModelQueueDefinition = modelQueueDefinition;
		modelQueueDefinition = newModelQueueDefinition;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, MqPackage.MQ_TOPIC_CONNECTION_FACTORY__MODEL_QUEUE_DEFINITION, oldModelQueueDefinition, modelQueueDefinition));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getPersistentSubscriptionStore() {
		return persistentSubscriptionStore;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setPersistentSubscriptionStore(String newPersistentSubscriptionStore) {
		String oldPersistentSubscriptionStore = persistentSubscriptionStore;
		persistentSubscriptionStore = newPersistentSubscriptionStore;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, MqPackage.MQ_TOPIC_CONNECTION_FACTORY__PERSISTENT_SUBSCRIPTION_STORE, oldPersistentSubscriptionStore, persistentSubscriptionStore));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getPollingInterval() {
		return pollingInterval;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setPollingInterval(String newPollingInterval) {
		String oldPollingInterval = pollingInterval;
		pollingInterval = newPollingInterval;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, MqPackage.MQ_TOPIC_CONNECTION_FACTORY__POLLING_INTERVAL, oldPollingInterval, pollingInterval));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getPort() {
		return port;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setPort(String newPort) {
		String oldPort = port;
		port = newPort;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, MqPackage.MQ_TOPIC_CONNECTION_FACTORY__PORT, oldPort, port));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getProxyHostName() {
		return proxyHostName;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setProxyHostName(String newProxyHostName) {
		String oldProxyHostName = proxyHostName;
		proxyHostName = newProxyHostName;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, MqPackage.MQ_TOPIC_CONNECTION_FACTORY__PROXY_HOST_NAME, oldProxyHostName, proxyHostName));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getProxyPort() {
		return proxyPort;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setProxyPort(String newProxyPort) {
		String oldProxyPort = proxyPort;
		proxyPort = newProxyPort;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, MqPackage.MQ_TOPIC_CONNECTION_FACTORY__PROXY_PORT, oldProxyPort, proxyPort));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getPublishAndAcknowledgeLevel() {
		return publishAndAcknowledgeLevel;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setPublishAndAcknowledgeLevel(String newPublishAndAcknowledgeLevel) {
		String oldPublishAndAcknowledgeLevel = publishAndAcknowledgeLevel;
		publishAndAcknowledgeLevel = newPublishAndAcknowledgeLevel;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, MqPackage.MQ_TOPIC_CONNECTION_FACTORY__PUBLISH_AND_ACKNOWLEDGE_LEVEL, oldPublishAndAcknowledgeLevel, publishAndAcknowledgeLevel));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getPublishAndSubscribeCleanupInterval() {
		return publishAndSubscribeCleanupInterval;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setPublishAndSubscribeCleanupInterval(String newPublishAndSubscribeCleanupInterval) {
		String oldPublishAndSubscribeCleanupInterval = publishAndSubscribeCleanupInterval;
		publishAndSubscribeCleanupInterval = newPublishAndSubscribeCleanupInterval;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, MqPackage.MQ_TOPIC_CONNECTION_FACTORY__PUBLISH_AND_SUBSCRIBE_CLEANUP_INTERVAL, oldPublishAndSubscribeCleanupInterval, publishAndSubscribeCleanupInterval));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getPublishAndSubscribeCleanupLevel() {
		return publishAndSubscribeCleanupLevel;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setPublishAndSubscribeCleanupLevel(String newPublishAndSubscribeCleanupLevel) {
		String oldPublishAndSubscribeCleanupLevel = publishAndSubscribeCleanupLevel;
		publishAndSubscribeCleanupLevel = newPublishAndSubscribeCleanupLevel;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, MqPackage.MQ_TOPIC_CONNECTION_FACTORY__PUBLISH_AND_SUBSCRIBE_CLEANUP_LEVEL, oldPublishAndSubscribeCleanupLevel, publishAndSubscribeCleanupLevel));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getPublishAndSubscribeStatusInterval() {
		return publishAndSubscribeStatusInterval;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setPublishAndSubscribeStatusInterval(String newPublishAndSubscribeStatusInterval) {
		String oldPublishAndSubscribeStatusInterval = publishAndSubscribeStatusInterval;
		publishAndSubscribeStatusInterval = newPublishAndSubscribeStatusInterval;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, MqPackage.MQ_TOPIC_CONNECTION_FACTORY__PUBLISH_AND_SUBSCRIBE_STATUS_INTERVAL, oldPublishAndSubscribeStatusInterval, publishAndSubscribeStatusInterval));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getQueueManager() {
		return queueManager;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setQueueManager(String newQueueManager) {
		String oldQueueManager = queueManager;
		queueManager = newQueueManager;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, MqPackage.MQ_TOPIC_CONNECTION_FACTORY__QUEUE_MANAGER, oldQueueManager, queueManager));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getRescanInterval() {
		return rescanInterval;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setRescanInterval(String newRescanInterval) {
		String oldRescanInterval = rescanInterval;
		rescanInterval = newRescanInterval;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, MqPackage.MQ_TOPIC_CONNECTION_FACTORY__RESCAN_INTERVAL, oldRescanInterval, rescanInterval));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getSSLCipherSuite() {
		return sSLCipherSuite;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setSSLCipherSuite(String newSSLCipherSuite) {
		String oldSSLCipherSuite = sSLCipherSuite;
		sSLCipherSuite = newSSLCipherSuite;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, MqPackage.MQ_TOPIC_CONNECTION_FACTORY__SSL_CIPHER_SUITE, oldSSLCipherSuite, sSLCipherSuite));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getSSLCRL() {
		return sSLCRL;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setSSLCRL(String newSSLCRL) {
		String oldSSLCRL = sSLCRL;
		sSLCRL = newSSLCRL;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, MqPackage.MQ_TOPIC_CONNECTION_FACTORY__SSLCRL, oldSSLCRL, sSLCRL));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getSSLPeerName() {
		return sSLPeerName;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setSSLPeerName(String newSSLPeerName) {
		String oldSSLPeerName = sSLPeerName;
		sSLPeerName = newSSLPeerName;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, MqPackage.MQ_TOPIC_CONNECTION_FACTORY__SSL_PEER_NAME, oldSSLPeerName, sSLPeerName));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getTransportType() {
		return transportType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setTransportType(String newTransportType) {
		String oldTransportType = transportType;
		transportType = newTransportType;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, MqPackage.MQ_TOPIC_CONNECTION_FACTORY__TRANSPORT_TYPE, oldTransportType, transportType));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getXAEnabled() {
		return xAEnabled;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setXAEnabled(String newXAEnabled) {
		String oldXAEnabled = xAEnabled;
		xAEnabled = newXAEnabled;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, MqPackage.MQ_TOPIC_CONNECTION_FACTORY__XA_ENABLED, oldXAEnabled, xAEnabled));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case MqPackage.MQ_TOPIC_CONNECTION_FACTORY__BROKER_CC_SUBSCRIPTION_QUEUE:
				return getBrokerCCSubscriptionQueue();
			case MqPackage.MQ_TOPIC_CONNECTION_FACTORY__BROKER_CONTROL_QUEUE:
				return getBrokerControlQueue();
			case MqPackage.MQ_TOPIC_CONNECTION_FACTORY__BROKER_MESSAGE_SELECTION:
				return getBrokerMessageSelection();
			case MqPackage.MQ_TOPIC_CONNECTION_FACTORY__BROKER_PUBLICATION_QUEUE:
				return getBrokerPublicationQueue();
			case MqPackage.MQ_TOPIC_CONNECTION_FACTORY__BROKER_QUEUE_MANAGER:
				return getBrokerQueueManager();
			case MqPackage.MQ_TOPIC_CONNECTION_FACTORY__BROKER_SUBSCRIPTION_QUEUE:
				return getBrokerSubscriptionQueue();
			case MqPackage.MQ_TOPIC_CONNECTION_FACTORY__BROKER_VERSION:
				return getBrokerVersion();
			case MqPackage.MQ_TOPIC_CONNECTION_FACTORY__CATEGORY:
				return getCategory();
			case MqPackage.MQ_TOPIC_CONNECTION_FACTORY__CCSID_ID:
				return getCCSIDId();
			case MqPackage.MQ_TOPIC_CONNECTION_FACTORY__CHANNEL:
				return getChannel();
			case MqPackage.MQ_TOPIC_CONNECTION_FACTORY__CLIENT_ID:
				return getClientId();
			case MqPackage.MQ_TOPIC_CONNECTION_FACTORY__COMPONENT_MANAGED_AUTHENTICATION_ALIAS:
				return getComponentManagedAuthenticationAlias();
			case MqPackage.MQ_TOPIC_CONNECTION_FACTORY__CONTAINER_MANAGED_AUTHENTICATION_ALIAS:
				return getContainerManagedAuthenticationAlias();
			case MqPackage.MQ_TOPIC_CONNECTION_FACTORY__DESCRIPTION1:
				return getDescription1();
			case MqPackage.MQ_TOPIC_CONNECTION_FACTORY__DIRECT_BROKER_AUTHORIZATION:
				return getDirectBrokerAuthorization();
			case MqPackage.MQ_TOPIC_CONNECTION_FACTORY__ENABLE_CLONE_SUPPORT:
				return getEnableCloneSupport();
			case MqPackage.MQ_TOPIC_CONNECTION_FACTORY__ENABLE_MQ_CONNECTION_POOLING:
				return getEnableMQConnectionPooling();
			case MqPackage.MQ_TOPIC_CONNECTION_FACTORY__ENABLE_MULTICAST_TRANSPORT:
				return getEnableMulticastTransport();
			case MqPackage.MQ_TOPIC_CONNECTION_FACTORY__ENABLE_RETURN_METHODS_DURING_SHUTDOWN:
				return getEnableReturnMethodsDuringShutdown();
			case MqPackage.MQ_TOPIC_CONNECTION_FACTORY__FACTORY_NAME:
				return getFactoryName();
			case MqPackage.MQ_TOPIC_CONNECTION_FACTORY__HOST:
				return getHost();
			case MqPackage.MQ_TOPIC_CONNECTION_FACTORY__JNDI_NAME:
				return getJndiName();
			case MqPackage.MQ_TOPIC_CONNECTION_FACTORY__LOCAL_SERVER_ADDRESS:
				return getLocalServerAddress();
			case MqPackage.MQ_TOPIC_CONNECTION_FACTORY__MAPPING_CONFIGURATION_ALIAS:
				return getMappingConfigurationAlias();
			case MqPackage.MQ_TOPIC_CONNECTION_FACTORY__MODEL_QUEUE_DEFINITION:
				return getModelQueueDefinition();
			case MqPackage.MQ_TOPIC_CONNECTION_FACTORY__PERSISTENT_SUBSCRIPTION_STORE:
				return getPersistentSubscriptionStore();
			case MqPackage.MQ_TOPIC_CONNECTION_FACTORY__POLLING_INTERVAL:
				return getPollingInterval();
			case MqPackage.MQ_TOPIC_CONNECTION_FACTORY__PORT:
				return getPort();
			case MqPackage.MQ_TOPIC_CONNECTION_FACTORY__PROXY_HOST_NAME:
				return getProxyHostName();
			case MqPackage.MQ_TOPIC_CONNECTION_FACTORY__PROXY_PORT:
				return getProxyPort();
			case MqPackage.MQ_TOPIC_CONNECTION_FACTORY__PUBLISH_AND_ACKNOWLEDGE_LEVEL:
				return getPublishAndAcknowledgeLevel();
			case MqPackage.MQ_TOPIC_CONNECTION_FACTORY__PUBLISH_AND_SUBSCRIBE_CLEANUP_INTERVAL:
				return getPublishAndSubscribeCleanupInterval();
			case MqPackage.MQ_TOPIC_CONNECTION_FACTORY__PUBLISH_AND_SUBSCRIBE_CLEANUP_LEVEL:
				return getPublishAndSubscribeCleanupLevel();
			case MqPackage.MQ_TOPIC_CONNECTION_FACTORY__PUBLISH_AND_SUBSCRIBE_STATUS_INTERVAL:
				return getPublishAndSubscribeStatusInterval();
			case MqPackage.MQ_TOPIC_CONNECTION_FACTORY__QUEUE_MANAGER:
				return getQueueManager();
			case MqPackage.MQ_TOPIC_CONNECTION_FACTORY__RESCAN_INTERVAL:
				return getRescanInterval();
			case MqPackage.MQ_TOPIC_CONNECTION_FACTORY__SSL_CIPHER_SUITE:
				return getSSLCipherSuite();
			case MqPackage.MQ_TOPIC_CONNECTION_FACTORY__SSLCRL:
				return getSSLCRL();
			case MqPackage.MQ_TOPIC_CONNECTION_FACTORY__SSL_PEER_NAME:
				return getSSLPeerName();
			case MqPackage.MQ_TOPIC_CONNECTION_FACTORY__TRANSPORT_TYPE:
				return getTransportType();
			case MqPackage.MQ_TOPIC_CONNECTION_FACTORY__XA_ENABLED:
				return getXAEnabled();
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
			case MqPackage.MQ_TOPIC_CONNECTION_FACTORY__BROKER_CC_SUBSCRIPTION_QUEUE:
				setBrokerCCSubscriptionQueue((String)newValue);
				return;
			case MqPackage.MQ_TOPIC_CONNECTION_FACTORY__BROKER_CONTROL_QUEUE:
				setBrokerControlQueue((String)newValue);
				return;
			case MqPackage.MQ_TOPIC_CONNECTION_FACTORY__BROKER_MESSAGE_SELECTION:
				setBrokerMessageSelection((String)newValue);
				return;
			case MqPackage.MQ_TOPIC_CONNECTION_FACTORY__BROKER_PUBLICATION_QUEUE:
				setBrokerPublicationQueue((String)newValue);
				return;
			case MqPackage.MQ_TOPIC_CONNECTION_FACTORY__BROKER_QUEUE_MANAGER:
				setBrokerQueueManager((String)newValue);
				return;
			case MqPackage.MQ_TOPIC_CONNECTION_FACTORY__BROKER_SUBSCRIPTION_QUEUE:
				setBrokerSubscriptionQueue((String)newValue);
				return;
			case MqPackage.MQ_TOPIC_CONNECTION_FACTORY__BROKER_VERSION:
				setBrokerVersion((String)newValue);
				return;
			case MqPackage.MQ_TOPIC_CONNECTION_FACTORY__CATEGORY:
				setCategory((String)newValue);
				return;
			case MqPackage.MQ_TOPIC_CONNECTION_FACTORY__CCSID_ID:
				setCCSIDId((String)newValue);
				return;
			case MqPackage.MQ_TOPIC_CONNECTION_FACTORY__CHANNEL:
				setChannel((String)newValue);
				return;
			case MqPackage.MQ_TOPIC_CONNECTION_FACTORY__CLIENT_ID:
				setClientId((String)newValue);
				return;
			case MqPackage.MQ_TOPIC_CONNECTION_FACTORY__COMPONENT_MANAGED_AUTHENTICATION_ALIAS:
				setComponentManagedAuthenticationAlias((String)newValue);
				return;
			case MqPackage.MQ_TOPIC_CONNECTION_FACTORY__CONTAINER_MANAGED_AUTHENTICATION_ALIAS:
				setContainerManagedAuthenticationAlias((String)newValue);
				return;
			case MqPackage.MQ_TOPIC_CONNECTION_FACTORY__DESCRIPTION1:
				setDescription1((String)newValue);
				return;
			case MqPackage.MQ_TOPIC_CONNECTION_FACTORY__DIRECT_BROKER_AUTHORIZATION:
				setDirectBrokerAuthorization((String)newValue);
				return;
			case MqPackage.MQ_TOPIC_CONNECTION_FACTORY__ENABLE_CLONE_SUPPORT:
				setEnableCloneSupport((String)newValue);
				return;
			case MqPackage.MQ_TOPIC_CONNECTION_FACTORY__ENABLE_MQ_CONNECTION_POOLING:
				setEnableMQConnectionPooling((String)newValue);
				return;
			case MqPackage.MQ_TOPIC_CONNECTION_FACTORY__ENABLE_MULTICAST_TRANSPORT:
				setEnableMulticastTransport((String)newValue);
				return;
			case MqPackage.MQ_TOPIC_CONNECTION_FACTORY__ENABLE_RETURN_METHODS_DURING_SHUTDOWN:
				setEnableReturnMethodsDuringShutdown((String)newValue);
				return;
			case MqPackage.MQ_TOPIC_CONNECTION_FACTORY__FACTORY_NAME:
				setFactoryName((String)newValue);
				return;
			case MqPackage.MQ_TOPIC_CONNECTION_FACTORY__HOST:
				setHost((String)newValue);
				return;
			case MqPackage.MQ_TOPIC_CONNECTION_FACTORY__JNDI_NAME:
				setJndiName((String)newValue);
				return;
			case MqPackage.MQ_TOPIC_CONNECTION_FACTORY__LOCAL_SERVER_ADDRESS:
				setLocalServerAddress((String)newValue);
				return;
			case MqPackage.MQ_TOPIC_CONNECTION_FACTORY__MAPPING_CONFIGURATION_ALIAS:
				setMappingConfigurationAlias((String)newValue);
				return;
			case MqPackage.MQ_TOPIC_CONNECTION_FACTORY__MODEL_QUEUE_DEFINITION:
				setModelQueueDefinition((String)newValue);
				return;
			case MqPackage.MQ_TOPIC_CONNECTION_FACTORY__PERSISTENT_SUBSCRIPTION_STORE:
				setPersistentSubscriptionStore((String)newValue);
				return;
			case MqPackage.MQ_TOPIC_CONNECTION_FACTORY__POLLING_INTERVAL:
				setPollingInterval((String)newValue);
				return;
			case MqPackage.MQ_TOPIC_CONNECTION_FACTORY__PORT:
				setPort((String)newValue);
				return;
			case MqPackage.MQ_TOPIC_CONNECTION_FACTORY__PROXY_HOST_NAME:
				setProxyHostName((String)newValue);
				return;
			case MqPackage.MQ_TOPIC_CONNECTION_FACTORY__PROXY_PORT:
				setProxyPort((String)newValue);
				return;
			case MqPackage.MQ_TOPIC_CONNECTION_FACTORY__PUBLISH_AND_ACKNOWLEDGE_LEVEL:
				setPublishAndAcknowledgeLevel((String)newValue);
				return;
			case MqPackage.MQ_TOPIC_CONNECTION_FACTORY__PUBLISH_AND_SUBSCRIBE_CLEANUP_INTERVAL:
				setPublishAndSubscribeCleanupInterval((String)newValue);
				return;
			case MqPackage.MQ_TOPIC_CONNECTION_FACTORY__PUBLISH_AND_SUBSCRIBE_CLEANUP_LEVEL:
				setPublishAndSubscribeCleanupLevel((String)newValue);
				return;
			case MqPackage.MQ_TOPIC_CONNECTION_FACTORY__PUBLISH_AND_SUBSCRIBE_STATUS_INTERVAL:
				setPublishAndSubscribeStatusInterval((String)newValue);
				return;
			case MqPackage.MQ_TOPIC_CONNECTION_FACTORY__QUEUE_MANAGER:
				setQueueManager((String)newValue);
				return;
			case MqPackage.MQ_TOPIC_CONNECTION_FACTORY__RESCAN_INTERVAL:
				setRescanInterval((String)newValue);
				return;
			case MqPackage.MQ_TOPIC_CONNECTION_FACTORY__SSL_CIPHER_SUITE:
				setSSLCipherSuite((String)newValue);
				return;
			case MqPackage.MQ_TOPIC_CONNECTION_FACTORY__SSLCRL:
				setSSLCRL((String)newValue);
				return;
			case MqPackage.MQ_TOPIC_CONNECTION_FACTORY__SSL_PEER_NAME:
				setSSLPeerName((String)newValue);
				return;
			case MqPackage.MQ_TOPIC_CONNECTION_FACTORY__TRANSPORT_TYPE:
				setTransportType((String)newValue);
				return;
			case MqPackage.MQ_TOPIC_CONNECTION_FACTORY__XA_ENABLED:
				setXAEnabled((String)newValue);
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
			case MqPackage.MQ_TOPIC_CONNECTION_FACTORY__BROKER_CC_SUBSCRIPTION_QUEUE:
				setBrokerCCSubscriptionQueue(BROKER_CC_SUBSCRIPTION_QUEUE_EDEFAULT);
				return;
			case MqPackage.MQ_TOPIC_CONNECTION_FACTORY__BROKER_CONTROL_QUEUE:
				setBrokerControlQueue(BROKER_CONTROL_QUEUE_EDEFAULT);
				return;
			case MqPackage.MQ_TOPIC_CONNECTION_FACTORY__BROKER_MESSAGE_SELECTION:
				setBrokerMessageSelection(BROKER_MESSAGE_SELECTION_EDEFAULT);
				return;
			case MqPackage.MQ_TOPIC_CONNECTION_FACTORY__BROKER_PUBLICATION_QUEUE:
				setBrokerPublicationQueue(BROKER_PUBLICATION_QUEUE_EDEFAULT);
				return;
			case MqPackage.MQ_TOPIC_CONNECTION_FACTORY__BROKER_QUEUE_MANAGER:
				setBrokerQueueManager(BROKER_QUEUE_MANAGER_EDEFAULT);
				return;
			case MqPackage.MQ_TOPIC_CONNECTION_FACTORY__BROKER_SUBSCRIPTION_QUEUE:
				setBrokerSubscriptionQueue(BROKER_SUBSCRIPTION_QUEUE_EDEFAULT);
				return;
			case MqPackage.MQ_TOPIC_CONNECTION_FACTORY__BROKER_VERSION:
				setBrokerVersion(BROKER_VERSION_EDEFAULT);
				return;
			case MqPackage.MQ_TOPIC_CONNECTION_FACTORY__CATEGORY:
				setCategory(CATEGORY_EDEFAULT);
				return;
			case MqPackage.MQ_TOPIC_CONNECTION_FACTORY__CCSID_ID:
				setCCSIDId(CCSID_ID_EDEFAULT);
				return;
			case MqPackage.MQ_TOPIC_CONNECTION_FACTORY__CHANNEL:
				setChannel(CHANNEL_EDEFAULT);
				return;
			case MqPackage.MQ_TOPIC_CONNECTION_FACTORY__CLIENT_ID:
				setClientId(CLIENT_ID_EDEFAULT);
				return;
			case MqPackage.MQ_TOPIC_CONNECTION_FACTORY__COMPONENT_MANAGED_AUTHENTICATION_ALIAS:
				setComponentManagedAuthenticationAlias(COMPONENT_MANAGED_AUTHENTICATION_ALIAS_EDEFAULT);
				return;
			case MqPackage.MQ_TOPIC_CONNECTION_FACTORY__CONTAINER_MANAGED_AUTHENTICATION_ALIAS:
				setContainerManagedAuthenticationAlias(CONTAINER_MANAGED_AUTHENTICATION_ALIAS_EDEFAULT);
				return;
			case MqPackage.MQ_TOPIC_CONNECTION_FACTORY__DESCRIPTION1:
				setDescription1(DESCRIPTION1_EDEFAULT);
				return;
			case MqPackage.MQ_TOPIC_CONNECTION_FACTORY__DIRECT_BROKER_AUTHORIZATION:
				setDirectBrokerAuthorization(DIRECT_BROKER_AUTHORIZATION_EDEFAULT);
				return;
			case MqPackage.MQ_TOPIC_CONNECTION_FACTORY__ENABLE_CLONE_SUPPORT:
				setEnableCloneSupport(ENABLE_CLONE_SUPPORT_EDEFAULT);
				return;
			case MqPackage.MQ_TOPIC_CONNECTION_FACTORY__ENABLE_MQ_CONNECTION_POOLING:
				setEnableMQConnectionPooling(ENABLE_MQ_CONNECTION_POOLING_EDEFAULT);
				return;
			case MqPackage.MQ_TOPIC_CONNECTION_FACTORY__ENABLE_MULTICAST_TRANSPORT:
				setEnableMulticastTransport(ENABLE_MULTICAST_TRANSPORT_EDEFAULT);
				return;
			case MqPackage.MQ_TOPIC_CONNECTION_FACTORY__ENABLE_RETURN_METHODS_DURING_SHUTDOWN:
				setEnableReturnMethodsDuringShutdown(ENABLE_RETURN_METHODS_DURING_SHUTDOWN_EDEFAULT);
				return;
			case MqPackage.MQ_TOPIC_CONNECTION_FACTORY__FACTORY_NAME:
				setFactoryName(FACTORY_NAME_EDEFAULT);
				return;
			case MqPackage.MQ_TOPIC_CONNECTION_FACTORY__HOST:
				setHost(HOST_EDEFAULT);
				return;
			case MqPackage.MQ_TOPIC_CONNECTION_FACTORY__JNDI_NAME:
				setJndiName(JNDI_NAME_EDEFAULT);
				return;
			case MqPackage.MQ_TOPIC_CONNECTION_FACTORY__LOCAL_SERVER_ADDRESS:
				setLocalServerAddress(LOCAL_SERVER_ADDRESS_EDEFAULT);
				return;
			case MqPackage.MQ_TOPIC_CONNECTION_FACTORY__MAPPING_CONFIGURATION_ALIAS:
				setMappingConfigurationAlias(MAPPING_CONFIGURATION_ALIAS_EDEFAULT);
				return;
			case MqPackage.MQ_TOPIC_CONNECTION_FACTORY__MODEL_QUEUE_DEFINITION:
				setModelQueueDefinition(MODEL_QUEUE_DEFINITION_EDEFAULT);
				return;
			case MqPackage.MQ_TOPIC_CONNECTION_FACTORY__PERSISTENT_SUBSCRIPTION_STORE:
				setPersistentSubscriptionStore(PERSISTENT_SUBSCRIPTION_STORE_EDEFAULT);
				return;
			case MqPackage.MQ_TOPIC_CONNECTION_FACTORY__POLLING_INTERVAL:
				setPollingInterval(POLLING_INTERVAL_EDEFAULT);
				return;
			case MqPackage.MQ_TOPIC_CONNECTION_FACTORY__PORT:
				setPort(PORT_EDEFAULT);
				return;
			case MqPackage.MQ_TOPIC_CONNECTION_FACTORY__PROXY_HOST_NAME:
				setProxyHostName(PROXY_HOST_NAME_EDEFAULT);
				return;
			case MqPackage.MQ_TOPIC_CONNECTION_FACTORY__PROXY_PORT:
				setProxyPort(PROXY_PORT_EDEFAULT);
				return;
			case MqPackage.MQ_TOPIC_CONNECTION_FACTORY__PUBLISH_AND_ACKNOWLEDGE_LEVEL:
				setPublishAndAcknowledgeLevel(PUBLISH_AND_ACKNOWLEDGE_LEVEL_EDEFAULT);
				return;
			case MqPackage.MQ_TOPIC_CONNECTION_FACTORY__PUBLISH_AND_SUBSCRIBE_CLEANUP_INTERVAL:
				setPublishAndSubscribeCleanupInterval(PUBLISH_AND_SUBSCRIBE_CLEANUP_INTERVAL_EDEFAULT);
				return;
			case MqPackage.MQ_TOPIC_CONNECTION_FACTORY__PUBLISH_AND_SUBSCRIBE_CLEANUP_LEVEL:
				setPublishAndSubscribeCleanupLevel(PUBLISH_AND_SUBSCRIBE_CLEANUP_LEVEL_EDEFAULT);
				return;
			case MqPackage.MQ_TOPIC_CONNECTION_FACTORY__PUBLISH_AND_SUBSCRIBE_STATUS_INTERVAL:
				setPublishAndSubscribeStatusInterval(PUBLISH_AND_SUBSCRIBE_STATUS_INTERVAL_EDEFAULT);
				return;
			case MqPackage.MQ_TOPIC_CONNECTION_FACTORY__QUEUE_MANAGER:
				setQueueManager(QUEUE_MANAGER_EDEFAULT);
				return;
			case MqPackage.MQ_TOPIC_CONNECTION_FACTORY__RESCAN_INTERVAL:
				setRescanInterval(RESCAN_INTERVAL_EDEFAULT);
				return;
			case MqPackage.MQ_TOPIC_CONNECTION_FACTORY__SSL_CIPHER_SUITE:
				setSSLCipherSuite(SSL_CIPHER_SUITE_EDEFAULT);
				return;
			case MqPackage.MQ_TOPIC_CONNECTION_FACTORY__SSLCRL:
				setSSLCRL(SSLCRL_EDEFAULT);
				return;
			case MqPackage.MQ_TOPIC_CONNECTION_FACTORY__SSL_PEER_NAME:
				setSSLPeerName(SSL_PEER_NAME_EDEFAULT);
				return;
			case MqPackage.MQ_TOPIC_CONNECTION_FACTORY__TRANSPORT_TYPE:
				setTransportType(TRANSPORT_TYPE_EDEFAULT);
				return;
			case MqPackage.MQ_TOPIC_CONNECTION_FACTORY__XA_ENABLED:
				setXAEnabled(XA_ENABLED_EDEFAULT);
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
			case MqPackage.MQ_TOPIC_CONNECTION_FACTORY__BROKER_CC_SUBSCRIPTION_QUEUE:
				return BROKER_CC_SUBSCRIPTION_QUEUE_EDEFAULT == null ? brokerCCSubscriptionQueue != null : !BROKER_CC_SUBSCRIPTION_QUEUE_EDEFAULT.equals(brokerCCSubscriptionQueue);
			case MqPackage.MQ_TOPIC_CONNECTION_FACTORY__BROKER_CONTROL_QUEUE:
				return BROKER_CONTROL_QUEUE_EDEFAULT == null ? brokerControlQueue != null : !BROKER_CONTROL_QUEUE_EDEFAULT.equals(brokerControlQueue);
			case MqPackage.MQ_TOPIC_CONNECTION_FACTORY__BROKER_MESSAGE_SELECTION:
				return BROKER_MESSAGE_SELECTION_EDEFAULT == null ? brokerMessageSelection != null : !BROKER_MESSAGE_SELECTION_EDEFAULT.equals(brokerMessageSelection);
			case MqPackage.MQ_TOPIC_CONNECTION_FACTORY__BROKER_PUBLICATION_QUEUE:
				return BROKER_PUBLICATION_QUEUE_EDEFAULT == null ? brokerPublicationQueue != null : !BROKER_PUBLICATION_QUEUE_EDEFAULT.equals(brokerPublicationQueue);
			case MqPackage.MQ_TOPIC_CONNECTION_FACTORY__BROKER_QUEUE_MANAGER:
				return BROKER_QUEUE_MANAGER_EDEFAULT == null ? brokerQueueManager != null : !BROKER_QUEUE_MANAGER_EDEFAULT.equals(brokerQueueManager);
			case MqPackage.MQ_TOPIC_CONNECTION_FACTORY__BROKER_SUBSCRIPTION_QUEUE:
				return BROKER_SUBSCRIPTION_QUEUE_EDEFAULT == null ? brokerSubscriptionQueue != null : !BROKER_SUBSCRIPTION_QUEUE_EDEFAULT.equals(brokerSubscriptionQueue);
			case MqPackage.MQ_TOPIC_CONNECTION_FACTORY__BROKER_VERSION:
				return BROKER_VERSION_EDEFAULT == null ? brokerVersion != null : !BROKER_VERSION_EDEFAULT.equals(brokerVersion);
			case MqPackage.MQ_TOPIC_CONNECTION_FACTORY__CATEGORY:
				return CATEGORY_EDEFAULT == null ? category != null : !CATEGORY_EDEFAULT.equals(category);
			case MqPackage.MQ_TOPIC_CONNECTION_FACTORY__CCSID_ID:
				return CCSID_ID_EDEFAULT == null ? cCSIDId != null : !CCSID_ID_EDEFAULT.equals(cCSIDId);
			case MqPackage.MQ_TOPIC_CONNECTION_FACTORY__CHANNEL:
				return CHANNEL_EDEFAULT == null ? channel != null : !CHANNEL_EDEFAULT.equals(channel);
			case MqPackage.MQ_TOPIC_CONNECTION_FACTORY__CLIENT_ID:
				return CLIENT_ID_EDEFAULT == null ? clientId != null : !CLIENT_ID_EDEFAULT.equals(clientId);
			case MqPackage.MQ_TOPIC_CONNECTION_FACTORY__COMPONENT_MANAGED_AUTHENTICATION_ALIAS:
				return COMPONENT_MANAGED_AUTHENTICATION_ALIAS_EDEFAULT == null ? componentManagedAuthenticationAlias != null : !COMPONENT_MANAGED_AUTHENTICATION_ALIAS_EDEFAULT.equals(componentManagedAuthenticationAlias);
			case MqPackage.MQ_TOPIC_CONNECTION_FACTORY__CONTAINER_MANAGED_AUTHENTICATION_ALIAS:
				return CONTAINER_MANAGED_AUTHENTICATION_ALIAS_EDEFAULT == null ? containerManagedAuthenticationAlias != null : !CONTAINER_MANAGED_AUTHENTICATION_ALIAS_EDEFAULT.equals(containerManagedAuthenticationAlias);
			case MqPackage.MQ_TOPIC_CONNECTION_FACTORY__DESCRIPTION1:
				return DESCRIPTION1_EDEFAULT == null ? description1 != null : !DESCRIPTION1_EDEFAULT.equals(description1);
			case MqPackage.MQ_TOPIC_CONNECTION_FACTORY__DIRECT_BROKER_AUTHORIZATION:
				return DIRECT_BROKER_AUTHORIZATION_EDEFAULT == null ? directBrokerAuthorization != null : !DIRECT_BROKER_AUTHORIZATION_EDEFAULT.equals(directBrokerAuthorization);
			case MqPackage.MQ_TOPIC_CONNECTION_FACTORY__ENABLE_CLONE_SUPPORT:
				return ENABLE_CLONE_SUPPORT_EDEFAULT == null ? enableCloneSupport != null : !ENABLE_CLONE_SUPPORT_EDEFAULT.equals(enableCloneSupport);
			case MqPackage.MQ_TOPIC_CONNECTION_FACTORY__ENABLE_MQ_CONNECTION_POOLING:
				return ENABLE_MQ_CONNECTION_POOLING_EDEFAULT == null ? enableMQConnectionPooling != null : !ENABLE_MQ_CONNECTION_POOLING_EDEFAULT.equals(enableMQConnectionPooling);
			case MqPackage.MQ_TOPIC_CONNECTION_FACTORY__ENABLE_MULTICAST_TRANSPORT:
				return ENABLE_MULTICAST_TRANSPORT_EDEFAULT == null ? enableMulticastTransport != null : !ENABLE_MULTICAST_TRANSPORT_EDEFAULT.equals(enableMulticastTransport);
			case MqPackage.MQ_TOPIC_CONNECTION_FACTORY__ENABLE_RETURN_METHODS_DURING_SHUTDOWN:
				return ENABLE_RETURN_METHODS_DURING_SHUTDOWN_EDEFAULT == null ? enableReturnMethodsDuringShutdown != null : !ENABLE_RETURN_METHODS_DURING_SHUTDOWN_EDEFAULT.equals(enableReturnMethodsDuringShutdown);
			case MqPackage.MQ_TOPIC_CONNECTION_FACTORY__FACTORY_NAME:
				return FACTORY_NAME_EDEFAULT == null ? factoryName != null : !FACTORY_NAME_EDEFAULT.equals(factoryName);
			case MqPackage.MQ_TOPIC_CONNECTION_FACTORY__HOST:
				return HOST_EDEFAULT == null ? host != null : !HOST_EDEFAULT.equals(host);
			case MqPackage.MQ_TOPIC_CONNECTION_FACTORY__JNDI_NAME:
				return JNDI_NAME_EDEFAULT == null ? jndiName != null : !JNDI_NAME_EDEFAULT.equals(jndiName);
			case MqPackage.MQ_TOPIC_CONNECTION_FACTORY__LOCAL_SERVER_ADDRESS:
				return LOCAL_SERVER_ADDRESS_EDEFAULT == null ? localServerAddress != null : !LOCAL_SERVER_ADDRESS_EDEFAULT.equals(localServerAddress);
			case MqPackage.MQ_TOPIC_CONNECTION_FACTORY__MAPPING_CONFIGURATION_ALIAS:
				return MAPPING_CONFIGURATION_ALIAS_EDEFAULT == null ? mappingConfigurationAlias != null : !MAPPING_CONFIGURATION_ALIAS_EDEFAULT.equals(mappingConfigurationAlias);
			case MqPackage.MQ_TOPIC_CONNECTION_FACTORY__MODEL_QUEUE_DEFINITION:
				return MODEL_QUEUE_DEFINITION_EDEFAULT == null ? modelQueueDefinition != null : !MODEL_QUEUE_DEFINITION_EDEFAULT.equals(modelQueueDefinition);
			case MqPackage.MQ_TOPIC_CONNECTION_FACTORY__PERSISTENT_SUBSCRIPTION_STORE:
				return PERSISTENT_SUBSCRIPTION_STORE_EDEFAULT == null ? persistentSubscriptionStore != null : !PERSISTENT_SUBSCRIPTION_STORE_EDEFAULT.equals(persistentSubscriptionStore);
			case MqPackage.MQ_TOPIC_CONNECTION_FACTORY__POLLING_INTERVAL:
				return POLLING_INTERVAL_EDEFAULT == null ? pollingInterval != null : !POLLING_INTERVAL_EDEFAULT.equals(pollingInterval);
			case MqPackage.MQ_TOPIC_CONNECTION_FACTORY__PORT:
				return PORT_EDEFAULT == null ? port != null : !PORT_EDEFAULT.equals(port);
			case MqPackage.MQ_TOPIC_CONNECTION_FACTORY__PROXY_HOST_NAME:
				return PROXY_HOST_NAME_EDEFAULT == null ? proxyHostName != null : !PROXY_HOST_NAME_EDEFAULT.equals(proxyHostName);
			case MqPackage.MQ_TOPIC_CONNECTION_FACTORY__PROXY_PORT:
				return PROXY_PORT_EDEFAULT == null ? proxyPort != null : !PROXY_PORT_EDEFAULT.equals(proxyPort);
			case MqPackage.MQ_TOPIC_CONNECTION_FACTORY__PUBLISH_AND_ACKNOWLEDGE_LEVEL:
				return PUBLISH_AND_ACKNOWLEDGE_LEVEL_EDEFAULT == null ? publishAndAcknowledgeLevel != null : !PUBLISH_AND_ACKNOWLEDGE_LEVEL_EDEFAULT.equals(publishAndAcknowledgeLevel);
			case MqPackage.MQ_TOPIC_CONNECTION_FACTORY__PUBLISH_AND_SUBSCRIBE_CLEANUP_INTERVAL:
				return PUBLISH_AND_SUBSCRIBE_CLEANUP_INTERVAL_EDEFAULT == null ? publishAndSubscribeCleanupInterval != null : !PUBLISH_AND_SUBSCRIBE_CLEANUP_INTERVAL_EDEFAULT.equals(publishAndSubscribeCleanupInterval);
			case MqPackage.MQ_TOPIC_CONNECTION_FACTORY__PUBLISH_AND_SUBSCRIBE_CLEANUP_LEVEL:
				return PUBLISH_AND_SUBSCRIBE_CLEANUP_LEVEL_EDEFAULT == null ? publishAndSubscribeCleanupLevel != null : !PUBLISH_AND_SUBSCRIBE_CLEANUP_LEVEL_EDEFAULT.equals(publishAndSubscribeCleanupLevel);
			case MqPackage.MQ_TOPIC_CONNECTION_FACTORY__PUBLISH_AND_SUBSCRIBE_STATUS_INTERVAL:
				return PUBLISH_AND_SUBSCRIBE_STATUS_INTERVAL_EDEFAULT == null ? publishAndSubscribeStatusInterval != null : !PUBLISH_AND_SUBSCRIBE_STATUS_INTERVAL_EDEFAULT.equals(publishAndSubscribeStatusInterval);
			case MqPackage.MQ_TOPIC_CONNECTION_FACTORY__QUEUE_MANAGER:
				return QUEUE_MANAGER_EDEFAULT == null ? queueManager != null : !QUEUE_MANAGER_EDEFAULT.equals(queueManager);
			case MqPackage.MQ_TOPIC_CONNECTION_FACTORY__RESCAN_INTERVAL:
				return RESCAN_INTERVAL_EDEFAULT == null ? rescanInterval != null : !RESCAN_INTERVAL_EDEFAULT.equals(rescanInterval);
			case MqPackage.MQ_TOPIC_CONNECTION_FACTORY__SSL_CIPHER_SUITE:
				return SSL_CIPHER_SUITE_EDEFAULT == null ? sSLCipherSuite != null : !SSL_CIPHER_SUITE_EDEFAULT.equals(sSLCipherSuite);
			case MqPackage.MQ_TOPIC_CONNECTION_FACTORY__SSLCRL:
				return SSLCRL_EDEFAULT == null ? sSLCRL != null : !SSLCRL_EDEFAULT.equals(sSLCRL);
			case MqPackage.MQ_TOPIC_CONNECTION_FACTORY__SSL_PEER_NAME:
				return SSL_PEER_NAME_EDEFAULT == null ? sSLPeerName != null : !SSL_PEER_NAME_EDEFAULT.equals(sSLPeerName);
			case MqPackage.MQ_TOPIC_CONNECTION_FACTORY__TRANSPORT_TYPE:
				return TRANSPORT_TYPE_EDEFAULT == null ? transportType != null : !TRANSPORT_TYPE_EDEFAULT.equals(transportType);
			case MqPackage.MQ_TOPIC_CONNECTION_FACTORY__XA_ENABLED:
				return XA_ENABLED_EDEFAULT == null ? xAEnabled != null : !XA_ENABLED_EDEFAULT.equals(xAEnabled);
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
		result.append(" (brokerCCSubscriptionQueue: "); //$NON-NLS-1$
		result.append(brokerCCSubscriptionQueue);
		result.append(", brokerControlQueue: "); //$NON-NLS-1$
		result.append(brokerControlQueue);
		result.append(", brokerMessageSelection: "); //$NON-NLS-1$
		result.append(brokerMessageSelection);
		result.append(", brokerPublicationQueue: "); //$NON-NLS-1$
		result.append(brokerPublicationQueue);
		result.append(", brokerQueueManager: "); //$NON-NLS-1$
		result.append(brokerQueueManager);
		result.append(", brokerSubscriptionQueue: "); //$NON-NLS-1$
		result.append(brokerSubscriptionQueue);
		result.append(", brokerVersion: "); //$NON-NLS-1$
		result.append(brokerVersion);
		result.append(", category: "); //$NON-NLS-1$
		result.append(category);
		result.append(", cCSIDId: "); //$NON-NLS-1$
		result.append(cCSIDId);
		result.append(", channel: "); //$NON-NLS-1$
		result.append(channel);
		result.append(", clientId: "); //$NON-NLS-1$
		result.append(clientId);
		result.append(", componentManagedAuthenticationAlias: "); //$NON-NLS-1$
		result.append(componentManagedAuthenticationAlias);
		result.append(", containerManagedAuthenticationAlias: "); //$NON-NLS-1$
		result.append(containerManagedAuthenticationAlias);
		result.append(", description1: "); //$NON-NLS-1$
		result.append(description1);
		result.append(", directBrokerAuthorization: "); //$NON-NLS-1$
		result.append(directBrokerAuthorization);
		result.append(", enableCloneSupport: "); //$NON-NLS-1$
		result.append(enableCloneSupport);
		result.append(", enableMQConnectionPooling: "); //$NON-NLS-1$
		result.append(enableMQConnectionPooling);
		result.append(", enableMulticastTransport: "); //$NON-NLS-1$
		result.append(enableMulticastTransport);
		result.append(", enableReturnMethodsDuringShutdown: "); //$NON-NLS-1$
		result.append(enableReturnMethodsDuringShutdown);
		result.append(", factoryName: "); //$NON-NLS-1$
		result.append(factoryName);
		result.append(", host: "); //$NON-NLS-1$
		result.append(host);
		result.append(", jndiName: "); //$NON-NLS-1$
		result.append(jndiName);
		result.append(", localServerAddress: "); //$NON-NLS-1$
		result.append(localServerAddress);
		result.append(", mappingConfigurationAlias: "); //$NON-NLS-1$
		result.append(mappingConfigurationAlias);
		result.append(", modelQueueDefinition: "); //$NON-NLS-1$
		result.append(modelQueueDefinition);
		result.append(", persistentSubscriptionStore: "); //$NON-NLS-1$
		result.append(persistentSubscriptionStore);
		result.append(", pollingInterval: "); //$NON-NLS-1$
		result.append(pollingInterval);
		result.append(", port: "); //$NON-NLS-1$
		result.append(port);
		result.append(", proxyHostName: "); //$NON-NLS-1$
		result.append(proxyHostName);
		result.append(", proxyPort: "); //$NON-NLS-1$
		result.append(proxyPort);
		result.append(", publishAndAcknowledgeLevel: "); //$NON-NLS-1$
		result.append(publishAndAcknowledgeLevel);
		result.append(", publishAndSubscribeCleanupInterval: "); //$NON-NLS-1$
		result.append(publishAndSubscribeCleanupInterval);
		result.append(", publishAndSubscribeCleanupLevel: "); //$NON-NLS-1$
		result.append(publishAndSubscribeCleanupLevel);
		result.append(", publishAndSubscribeStatusInterval: "); //$NON-NLS-1$
		result.append(publishAndSubscribeStatusInterval);
		result.append(", queueManager: "); //$NON-NLS-1$
		result.append(queueManager);
		result.append(", rescanInterval: "); //$NON-NLS-1$
		result.append(rescanInterval);
		result.append(", sSLCipherSuite: "); //$NON-NLS-1$
		result.append(sSLCipherSuite);
		result.append(", sSLCRL: "); //$NON-NLS-1$
		result.append(sSLCRL);
		result.append(", sSLPeerName: "); //$NON-NLS-1$
		result.append(sSLPeerName);
		result.append(", transportType: "); //$NON-NLS-1$
		result.append(transportType);
		result.append(", xAEnabled: "); //$NON-NLS-1$
		result.append(xAEnabled);
		result.append(')');
		return result.toString();
	}

} //MQTopicConnectionFactoryImpl
