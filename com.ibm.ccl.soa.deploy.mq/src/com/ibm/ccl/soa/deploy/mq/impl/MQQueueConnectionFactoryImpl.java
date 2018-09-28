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
import com.ibm.ccl.soa.deploy.mq.MQQueueConnectionFactory;
import com.ibm.ccl.soa.deploy.mq.MqPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>MQ Queue Connection Factory</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link com.ibm.ccl.soa.deploy.mq.impl.MQQueueConnectionFactoryImpl#getCategory <em>Category</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.mq.impl.MQQueueConnectionFactoryImpl#getCCSID <em>CCSID</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.mq.impl.MQQueueConnectionFactoryImpl#getChannel <em>Channel</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.mq.impl.MQQueueConnectionFactoryImpl#getClientId <em>Client Id</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.mq.impl.MQQueueConnectionFactoryImpl#getComponentManagedAuthenticationAlias <em>Component Managed Authentication Alias</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.mq.impl.MQQueueConnectionFactoryImpl#getContainerManagedAuthenticationAlias <em>Container Managed Authentication Alias</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.mq.impl.MQQueueConnectionFactoryImpl#getDescription1 <em>Description1</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.mq.impl.MQQueueConnectionFactoryImpl#getEnableConnectionPoling <em>Enable Connection Poling</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.mq.impl.MQQueueConnectionFactoryImpl#getEnableMessageRetention <em>Enable Message Retention</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.mq.impl.MQQueueConnectionFactoryImpl#getEnableReturnMethodDuringShutdown <em>Enable Return Method During Shutdown</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.mq.impl.MQQueueConnectionFactoryImpl#getFactoryName <em>Factory Name</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.mq.impl.MQQueueConnectionFactoryImpl#getHost <em>Host</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.mq.impl.MQQueueConnectionFactoryImpl#getJndiName <em>Jndi Name</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.mq.impl.MQQueueConnectionFactoryImpl#getLocalServerAddress <em>Local Server Address</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.mq.impl.MQQueueConnectionFactoryImpl#getMappingconfigurationAlias <em>Mappingconfiguration Alias</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.mq.impl.MQQueueConnectionFactoryImpl#getMaxConnections <em>Max Connections</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.mq.impl.MQQueueConnectionFactoryImpl#getMaxSessions <em>Max Sessions</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.mq.impl.MQQueueConnectionFactoryImpl#getMinConnections <em>Min Connections</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.mq.impl.MQQueueConnectionFactoryImpl#getMinSessions <em>Min Sessions</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.mq.impl.MQQueueConnectionFactoryImpl#getModelQueueDefinition <em>Model Queue Definition</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.mq.impl.MQQueueConnectionFactoryImpl#getPollingInterval <em>Polling Interval</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.mq.impl.MQQueueConnectionFactoryImpl#getPort <em>Port</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.mq.impl.MQQueueConnectionFactoryImpl#getQueuemanager <em>Queuemanager</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.mq.impl.MQQueueConnectionFactoryImpl#getRescanInterval <em>Rescan Interval</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.mq.impl.MQQueueConnectionFactoryImpl#getSSLCipherSuit <em>SSL Cipher Suit</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.mq.impl.MQQueueConnectionFactoryImpl#getSSLCRL <em>SSLCRL</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.mq.impl.MQQueueConnectionFactoryImpl#getSSLPeerName <em>SSL Peer Name</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.mq.impl.MQQueueConnectionFactoryImpl#getTemporaryQueuePrefix <em>Temporary Queue Prefix</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.mq.impl.MQQueueConnectionFactoryImpl#getTransportType <em>Transport Type</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.mq.impl.MQQueueConnectionFactoryImpl#getXAEnabled <em>XA Enabled</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class MQQueueConnectionFactoryImpl extends CapabilityImpl implements MQQueueConnectionFactory {
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
	 * The default value of the '{@link #getCCSID() <em>CCSID</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getCCSID()
	 * @generated
	 * @ordered
	 */
	protected static final String CCSID_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getCCSID() <em>CCSID</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getCCSID()
	 * @generated
	 * @ordered
	 */
	protected String cCSID = CCSID_EDEFAULT;

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
	 * The default value of the '{@link #getEnableConnectionPoling() <em>Enable Connection Poling</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getEnableConnectionPoling()
	 * @generated
	 * @ordered
	 */
	protected static final String ENABLE_CONNECTION_POLING_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getEnableConnectionPoling() <em>Enable Connection Poling</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getEnableConnectionPoling()
	 * @generated
	 * @ordered
	 */
	protected String enableConnectionPoling = ENABLE_CONNECTION_POLING_EDEFAULT;

	/**
	 * The default value of the '{@link #getEnableMessageRetention() <em>Enable Message Retention</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getEnableMessageRetention()
	 * @generated
	 * @ordered
	 */
	protected static final String ENABLE_MESSAGE_RETENTION_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getEnableMessageRetention() <em>Enable Message Retention</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getEnableMessageRetention()
	 * @generated
	 * @ordered
	 */
	protected String enableMessageRetention = ENABLE_MESSAGE_RETENTION_EDEFAULT;

	/**
	 * The default value of the '{@link #getEnableReturnMethodDuringShutdown() <em>Enable Return Method During Shutdown</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getEnableReturnMethodDuringShutdown()
	 * @generated
	 * @ordered
	 */
	protected static final String ENABLE_RETURN_METHOD_DURING_SHUTDOWN_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getEnableReturnMethodDuringShutdown() <em>Enable Return Method During Shutdown</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getEnableReturnMethodDuringShutdown()
	 * @generated
	 * @ordered
	 */
	protected String enableReturnMethodDuringShutdown = ENABLE_RETURN_METHOD_DURING_SHUTDOWN_EDEFAULT;

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
	 * The default value of the '{@link #getMappingconfigurationAlias() <em>Mappingconfiguration Alias</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getMappingconfigurationAlias()
	 * @generated
	 * @ordered
	 */
	protected static final String MAPPINGCONFIGURATION_ALIAS_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getMappingconfigurationAlias() <em>Mappingconfiguration Alias</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getMappingconfigurationAlias()
	 * @generated
	 * @ordered
	 */
	protected String mappingconfigurationAlias = MAPPINGCONFIGURATION_ALIAS_EDEFAULT;

	/**
	 * The default value of the '{@link #getMaxConnections() <em>Max Connections</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getMaxConnections()
	 * @generated
	 * @ordered
	 */
	protected static final String MAX_CONNECTIONS_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getMaxConnections() <em>Max Connections</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getMaxConnections()
	 * @generated
	 * @ordered
	 */
	protected String maxConnections = MAX_CONNECTIONS_EDEFAULT;

	/**
	 * The default value of the '{@link #getMaxSessions() <em>Max Sessions</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getMaxSessions()
	 * @generated
	 * @ordered
	 */
	protected static final String MAX_SESSIONS_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getMaxSessions() <em>Max Sessions</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getMaxSessions()
	 * @generated
	 * @ordered
	 */
	protected String maxSessions = MAX_SESSIONS_EDEFAULT;

	/**
	 * The default value of the '{@link #getMinConnections() <em>Min Connections</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getMinConnections()
	 * @generated
	 * @ordered
	 */
	protected static final String MIN_CONNECTIONS_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getMinConnections() <em>Min Connections</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getMinConnections()
	 * @generated
	 * @ordered
	 */
	protected String minConnections = MIN_CONNECTIONS_EDEFAULT;

	/**
	 * The default value of the '{@link #getMinSessions() <em>Min Sessions</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getMinSessions()
	 * @generated
	 * @ordered
	 */
	protected static final String MIN_SESSIONS_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getMinSessions() <em>Min Sessions</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getMinSessions()
	 * @generated
	 * @ordered
	 */
	protected String minSessions = MIN_SESSIONS_EDEFAULT;

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
	 * The default value of the '{@link #getQueuemanager() <em>Queuemanager</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getQueuemanager()
	 * @generated
	 * @ordered
	 */
	protected static final String QUEUEMANAGER_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getQueuemanager() <em>Queuemanager</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getQueuemanager()
	 * @generated
	 * @ordered
	 */
	protected String queuemanager = QUEUEMANAGER_EDEFAULT;

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
	 * The default value of the '{@link #getSSLCipherSuit() <em>SSL Cipher Suit</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSSLCipherSuit()
	 * @generated
	 * @ordered
	 */
	protected static final String SSL_CIPHER_SUIT_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getSSLCipherSuit() <em>SSL Cipher Suit</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSSLCipherSuit()
	 * @generated
	 * @ordered
	 */
	protected String sSLCipherSuit = SSL_CIPHER_SUIT_EDEFAULT;

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
	 * The default value of the '{@link #getTemporaryQueuePrefix() <em>Temporary Queue Prefix</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTemporaryQueuePrefix()
	 * @generated
	 * @ordered
	 */
	protected static final String TEMPORARY_QUEUE_PREFIX_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getTemporaryQueuePrefix() <em>Temporary Queue Prefix</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTemporaryQueuePrefix()
	 * @generated
	 * @ordered
	 */
	protected String temporaryQueuePrefix = TEMPORARY_QUEUE_PREFIX_EDEFAULT;

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
	protected MQQueueConnectionFactoryImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected EClass eStaticClass() {
		return MqPackage.Literals.MQ_QUEUE_CONNECTION_FACTORY;
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
			eNotify(new ENotificationImpl(this, Notification.SET, MqPackage.MQ_QUEUE_CONNECTION_FACTORY__CATEGORY, oldCategory, category));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getCCSID() {
		return cCSID;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setCCSID(String newCCSID) {
		String oldCCSID = cCSID;
		cCSID = newCCSID;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, MqPackage.MQ_QUEUE_CONNECTION_FACTORY__CCSID, oldCCSID, cCSID));
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
			eNotify(new ENotificationImpl(this, Notification.SET, MqPackage.MQ_QUEUE_CONNECTION_FACTORY__CHANNEL, oldChannel, channel));
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
			eNotify(new ENotificationImpl(this, Notification.SET, MqPackage.MQ_QUEUE_CONNECTION_FACTORY__CLIENT_ID, oldClientId, clientId));
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
			eNotify(new ENotificationImpl(this, Notification.SET, MqPackage.MQ_QUEUE_CONNECTION_FACTORY__COMPONENT_MANAGED_AUTHENTICATION_ALIAS, oldComponentManagedAuthenticationAlias, componentManagedAuthenticationAlias));
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
			eNotify(new ENotificationImpl(this, Notification.SET, MqPackage.MQ_QUEUE_CONNECTION_FACTORY__CONTAINER_MANAGED_AUTHENTICATION_ALIAS, oldContainerManagedAuthenticationAlias, containerManagedAuthenticationAlias));
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
			eNotify(new ENotificationImpl(this, Notification.SET, MqPackage.MQ_QUEUE_CONNECTION_FACTORY__DESCRIPTION1, oldDescription1, description1));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getEnableConnectionPoling() {
		return enableConnectionPoling;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setEnableConnectionPoling(String newEnableConnectionPoling) {
		String oldEnableConnectionPoling = enableConnectionPoling;
		enableConnectionPoling = newEnableConnectionPoling;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, MqPackage.MQ_QUEUE_CONNECTION_FACTORY__ENABLE_CONNECTION_POLING, oldEnableConnectionPoling, enableConnectionPoling));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getEnableMessageRetention() {
		return enableMessageRetention;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setEnableMessageRetention(String newEnableMessageRetention) {
		String oldEnableMessageRetention = enableMessageRetention;
		enableMessageRetention = newEnableMessageRetention;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, MqPackage.MQ_QUEUE_CONNECTION_FACTORY__ENABLE_MESSAGE_RETENTION, oldEnableMessageRetention, enableMessageRetention));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getEnableReturnMethodDuringShutdown() {
		return enableReturnMethodDuringShutdown;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setEnableReturnMethodDuringShutdown(String newEnableReturnMethodDuringShutdown) {
		String oldEnableReturnMethodDuringShutdown = enableReturnMethodDuringShutdown;
		enableReturnMethodDuringShutdown = newEnableReturnMethodDuringShutdown;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, MqPackage.MQ_QUEUE_CONNECTION_FACTORY__ENABLE_RETURN_METHOD_DURING_SHUTDOWN, oldEnableReturnMethodDuringShutdown, enableReturnMethodDuringShutdown));
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
			eNotify(new ENotificationImpl(this, Notification.SET, MqPackage.MQ_QUEUE_CONNECTION_FACTORY__FACTORY_NAME, oldFactoryName, factoryName));
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
			eNotify(new ENotificationImpl(this, Notification.SET, MqPackage.MQ_QUEUE_CONNECTION_FACTORY__HOST, oldHost, host));
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
			eNotify(new ENotificationImpl(this, Notification.SET, MqPackage.MQ_QUEUE_CONNECTION_FACTORY__JNDI_NAME, oldJndiName, jndiName));
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
			eNotify(new ENotificationImpl(this, Notification.SET, MqPackage.MQ_QUEUE_CONNECTION_FACTORY__LOCAL_SERVER_ADDRESS, oldLocalServerAddress, localServerAddress));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getMappingconfigurationAlias() {
		return mappingconfigurationAlias;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setMappingconfigurationAlias(String newMappingconfigurationAlias) {
		String oldMappingconfigurationAlias = mappingconfigurationAlias;
		mappingconfigurationAlias = newMappingconfigurationAlias;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, MqPackage.MQ_QUEUE_CONNECTION_FACTORY__MAPPINGCONFIGURATION_ALIAS, oldMappingconfigurationAlias, mappingconfigurationAlias));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getMaxConnections() {
		return maxConnections;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setMaxConnections(String newMaxConnections) {
		String oldMaxConnections = maxConnections;
		maxConnections = newMaxConnections;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, MqPackage.MQ_QUEUE_CONNECTION_FACTORY__MAX_CONNECTIONS, oldMaxConnections, maxConnections));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getMaxSessions() {
		return maxSessions;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setMaxSessions(String newMaxSessions) {
		String oldMaxSessions = maxSessions;
		maxSessions = newMaxSessions;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, MqPackage.MQ_QUEUE_CONNECTION_FACTORY__MAX_SESSIONS, oldMaxSessions, maxSessions));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getMinConnections() {
		return minConnections;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setMinConnections(String newMinConnections) {
		String oldMinConnections = minConnections;
		minConnections = newMinConnections;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, MqPackage.MQ_QUEUE_CONNECTION_FACTORY__MIN_CONNECTIONS, oldMinConnections, minConnections));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getMinSessions() {
		return minSessions;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setMinSessions(String newMinSessions) {
		String oldMinSessions = minSessions;
		minSessions = newMinSessions;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, MqPackage.MQ_QUEUE_CONNECTION_FACTORY__MIN_SESSIONS, oldMinSessions, minSessions));
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
			eNotify(new ENotificationImpl(this, Notification.SET, MqPackage.MQ_QUEUE_CONNECTION_FACTORY__MODEL_QUEUE_DEFINITION, oldModelQueueDefinition, modelQueueDefinition));
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
			eNotify(new ENotificationImpl(this, Notification.SET, MqPackage.MQ_QUEUE_CONNECTION_FACTORY__POLLING_INTERVAL, oldPollingInterval, pollingInterval));
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
			eNotify(new ENotificationImpl(this, Notification.SET, MqPackage.MQ_QUEUE_CONNECTION_FACTORY__PORT, oldPort, port));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getQueuemanager() {
		return queuemanager;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setQueuemanager(String newQueuemanager) {
		String oldQueuemanager = queuemanager;
		queuemanager = newQueuemanager;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, MqPackage.MQ_QUEUE_CONNECTION_FACTORY__QUEUEMANAGER, oldQueuemanager, queuemanager));
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
			eNotify(new ENotificationImpl(this, Notification.SET, MqPackage.MQ_QUEUE_CONNECTION_FACTORY__RESCAN_INTERVAL, oldRescanInterval, rescanInterval));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getSSLCipherSuit() {
		return sSLCipherSuit;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setSSLCipherSuit(String newSSLCipherSuit) {
		String oldSSLCipherSuit = sSLCipherSuit;
		sSLCipherSuit = newSSLCipherSuit;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, MqPackage.MQ_QUEUE_CONNECTION_FACTORY__SSL_CIPHER_SUIT, oldSSLCipherSuit, sSLCipherSuit));
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
			eNotify(new ENotificationImpl(this, Notification.SET, MqPackage.MQ_QUEUE_CONNECTION_FACTORY__SSLCRL, oldSSLCRL, sSLCRL));
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
			eNotify(new ENotificationImpl(this, Notification.SET, MqPackage.MQ_QUEUE_CONNECTION_FACTORY__SSL_PEER_NAME, oldSSLPeerName, sSLPeerName));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getTemporaryQueuePrefix() {
		return temporaryQueuePrefix;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setTemporaryQueuePrefix(String newTemporaryQueuePrefix) {
		String oldTemporaryQueuePrefix = temporaryQueuePrefix;
		temporaryQueuePrefix = newTemporaryQueuePrefix;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, MqPackage.MQ_QUEUE_CONNECTION_FACTORY__TEMPORARY_QUEUE_PREFIX, oldTemporaryQueuePrefix, temporaryQueuePrefix));
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
			eNotify(new ENotificationImpl(this, Notification.SET, MqPackage.MQ_QUEUE_CONNECTION_FACTORY__TRANSPORT_TYPE, oldTransportType, transportType));
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
			eNotify(new ENotificationImpl(this, Notification.SET, MqPackage.MQ_QUEUE_CONNECTION_FACTORY__XA_ENABLED, oldXAEnabled, xAEnabled));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case MqPackage.MQ_QUEUE_CONNECTION_FACTORY__CATEGORY:
				return getCategory();
			case MqPackage.MQ_QUEUE_CONNECTION_FACTORY__CCSID:
				return getCCSID();
			case MqPackage.MQ_QUEUE_CONNECTION_FACTORY__CHANNEL:
				return getChannel();
			case MqPackage.MQ_QUEUE_CONNECTION_FACTORY__CLIENT_ID:
				return getClientId();
			case MqPackage.MQ_QUEUE_CONNECTION_FACTORY__COMPONENT_MANAGED_AUTHENTICATION_ALIAS:
				return getComponentManagedAuthenticationAlias();
			case MqPackage.MQ_QUEUE_CONNECTION_FACTORY__CONTAINER_MANAGED_AUTHENTICATION_ALIAS:
				return getContainerManagedAuthenticationAlias();
			case MqPackage.MQ_QUEUE_CONNECTION_FACTORY__DESCRIPTION1:
				return getDescription1();
			case MqPackage.MQ_QUEUE_CONNECTION_FACTORY__ENABLE_CONNECTION_POLING:
				return getEnableConnectionPoling();
			case MqPackage.MQ_QUEUE_CONNECTION_FACTORY__ENABLE_MESSAGE_RETENTION:
				return getEnableMessageRetention();
			case MqPackage.MQ_QUEUE_CONNECTION_FACTORY__ENABLE_RETURN_METHOD_DURING_SHUTDOWN:
				return getEnableReturnMethodDuringShutdown();
			case MqPackage.MQ_QUEUE_CONNECTION_FACTORY__FACTORY_NAME:
				return getFactoryName();
			case MqPackage.MQ_QUEUE_CONNECTION_FACTORY__HOST:
				return getHost();
			case MqPackage.MQ_QUEUE_CONNECTION_FACTORY__JNDI_NAME:
				return getJndiName();
			case MqPackage.MQ_QUEUE_CONNECTION_FACTORY__LOCAL_SERVER_ADDRESS:
				return getLocalServerAddress();
			case MqPackage.MQ_QUEUE_CONNECTION_FACTORY__MAPPINGCONFIGURATION_ALIAS:
				return getMappingconfigurationAlias();
			case MqPackage.MQ_QUEUE_CONNECTION_FACTORY__MAX_CONNECTIONS:
				return getMaxConnections();
			case MqPackage.MQ_QUEUE_CONNECTION_FACTORY__MAX_SESSIONS:
				return getMaxSessions();
			case MqPackage.MQ_QUEUE_CONNECTION_FACTORY__MIN_CONNECTIONS:
				return getMinConnections();
			case MqPackage.MQ_QUEUE_CONNECTION_FACTORY__MIN_SESSIONS:
				return getMinSessions();
			case MqPackage.MQ_QUEUE_CONNECTION_FACTORY__MODEL_QUEUE_DEFINITION:
				return getModelQueueDefinition();
			case MqPackage.MQ_QUEUE_CONNECTION_FACTORY__POLLING_INTERVAL:
				return getPollingInterval();
			case MqPackage.MQ_QUEUE_CONNECTION_FACTORY__PORT:
				return getPort();
			case MqPackage.MQ_QUEUE_CONNECTION_FACTORY__QUEUEMANAGER:
				return getQueuemanager();
			case MqPackage.MQ_QUEUE_CONNECTION_FACTORY__RESCAN_INTERVAL:
				return getRescanInterval();
			case MqPackage.MQ_QUEUE_CONNECTION_FACTORY__SSL_CIPHER_SUIT:
				return getSSLCipherSuit();
			case MqPackage.MQ_QUEUE_CONNECTION_FACTORY__SSLCRL:
				return getSSLCRL();
			case MqPackage.MQ_QUEUE_CONNECTION_FACTORY__SSL_PEER_NAME:
				return getSSLPeerName();
			case MqPackage.MQ_QUEUE_CONNECTION_FACTORY__TEMPORARY_QUEUE_PREFIX:
				return getTemporaryQueuePrefix();
			case MqPackage.MQ_QUEUE_CONNECTION_FACTORY__TRANSPORT_TYPE:
				return getTransportType();
			case MqPackage.MQ_QUEUE_CONNECTION_FACTORY__XA_ENABLED:
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
			case MqPackage.MQ_QUEUE_CONNECTION_FACTORY__CATEGORY:
				setCategory((String)newValue);
				return;
			case MqPackage.MQ_QUEUE_CONNECTION_FACTORY__CCSID:
				setCCSID((String)newValue);
				return;
			case MqPackage.MQ_QUEUE_CONNECTION_FACTORY__CHANNEL:
				setChannel((String)newValue);
				return;
			case MqPackage.MQ_QUEUE_CONNECTION_FACTORY__CLIENT_ID:
				setClientId((String)newValue);
				return;
			case MqPackage.MQ_QUEUE_CONNECTION_FACTORY__COMPONENT_MANAGED_AUTHENTICATION_ALIAS:
				setComponentManagedAuthenticationAlias((String)newValue);
				return;
			case MqPackage.MQ_QUEUE_CONNECTION_FACTORY__CONTAINER_MANAGED_AUTHENTICATION_ALIAS:
				setContainerManagedAuthenticationAlias((String)newValue);
				return;
			case MqPackage.MQ_QUEUE_CONNECTION_FACTORY__DESCRIPTION1:
				setDescription1((String)newValue);
				return;
			case MqPackage.MQ_QUEUE_CONNECTION_FACTORY__ENABLE_CONNECTION_POLING:
				setEnableConnectionPoling((String)newValue);
				return;
			case MqPackage.MQ_QUEUE_CONNECTION_FACTORY__ENABLE_MESSAGE_RETENTION:
				setEnableMessageRetention((String)newValue);
				return;
			case MqPackage.MQ_QUEUE_CONNECTION_FACTORY__ENABLE_RETURN_METHOD_DURING_SHUTDOWN:
				setEnableReturnMethodDuringShutdown((String)newValue);
				return;
			case MqPackage.MQ_QUEUE_CONNECTION_FACTORY__FACTORY_NAME:
				setFactoryName((String)newValue);
				return;
			case MqPackage.MQ_QUEUE_CONNECTION_FACTORY__HOST:
				setHost((String)newValue);
				return;
			case MqPackage.MQ_QUEUE_CONNECTION_FACTORY__JNDI_NAME:
				setJndiName((String)newValue);
				return;
			case MqPackage.MQ_QUEUE_CONNECTION_FACTORY__LOCAL_SERVER_ADDRESS:
				setLocalServerAddress((String)newValue);
				return;
			case MqPackage.MQ_QUEUE_CONNECTION_FACTORY__MAPPINGCONFIGURATION_ALIAS:
				setMappingconfigurationAlias((String)newValue);
				return;
			case MqPackage.MQ_QUEUE_CONNECTION_FACTORY__MAX_CONNECTIONS:
				setMaxConnections((String)newValue);
				return;
			case MqPackage.MQ_QUEUE_CONNECTION_FACTORY__MAX_SESSIONS:
				setMaxSessions((String)newValue);
				return;
			case MqPackage.MQ_QUEUE_CONNECTION_FACTORY__MIN_CONNECTIONS:
				setMinConnections((String)newValue);
				return;
			case MqPackage.MQ_QUEUE_CONNECTION_FACTORY__MIN_SESSIONS:
				setMinSessions((String)newValue);
				return;
			case MqPackage.MQ_QUEUE_CONNECTION_FACTORY__MODEL_QUEUE_DEFINITION:
				setModelQueueDefinition((String)newValue);
				return;
			case MqPackage.MQ_QUEUE_CONNECTION_FACTORY__POLLING_INTERVAL:
				setPollingInterval((String)newValue);
				return;
			case MqPackage.MQ_QUEUE_CONNECTION_FACTORY__PORT:
				setPort((String)newValue);
				return;
			case MqPackage.MQ_QUEUE_CONNECTION_FACTORY__QUEUEMANAGER:
				setQueuemanager((String)newValue);
				return;
			case MqPackage.MQ_QUEUE_CONNECTION_FACTORY__RESCAN_INTERVAL:
				setRescanInterval((String)newValue);
				return;
			case MqPackage.MQ_QUEUE_CONNECTION_FACTORY__SSL_CIPHER_SUIT:
				setSSLCipherSuit((String)newValue);
				return;
			case MqPackage.MQ_QUEUE_CONNECTION_FACTORY__SSLCRL:
				setSSLCRL((String)newValue);
				return;
			case MqPackage.MQ_QUEUE_CONNECTION_FACTORY__SSL_PEER_NAME:
				setSSLPeerName((String)newValue);
				return;
			case MqPackage.MQ_QUEUE_CONNECTION_FACTORY__TEMPORARY_QUEUE_PREFIX:
				setTemporaryQueuePrefix((String)newValue);
				return;
			case MqPackage.MQ_QUEUE_CONNECTION_FACTORY__TRANSPORT_TYPE:
				setTransportType((String)newValue);
				return;
			case MqPackage.MQ_QUEUE_CONNECTION_FACTORY__XA_ENABLED:
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
			case MqPackage.MQ_QUEUE_CONNECTION_FACTORY__CATEGORY:
				setCategory(CATEGORY_EDEFAULT);
				return;
			case MqPackage.MQ_QUEUE_CONNECTION_FACTORY__CCSID:
				setCCSID(CCSID_EDEFAULT);
				return;
			case MqPackage.MQ_QUEUE_CONNECTION_FACTORY__CHANNEL:
				setChannel(CHANNEL_EDEFAULT);
				return;
			case MqPackage.MQ_QUEUE_CONNECTION_FACTORY__CLIENT_ID:
				setClientId(CLIENT_ID_EDEFAULT);
				return;
			case MqPackage.MQ_QUEUE_CONNECTION_FACTORY__COMPONENT_MANAGED_AUTHENTICATION_ALIAS:
				setComponentManagedAuthenticationAlias(COMPONENT_MANAGED_AUTHENTICATION_ALIAS_EDEFAULT);
				return;
			case MqPackage.MQ_QUEUE_CONNECTION_FACTORY__CONTAINER_MANAGED_AUTHENTICATION_ALIAS:
				setContainerManagedAuthenticationAlias(CONTAINER_MANAGED_AUTHENTICATION_ALIAS_EDEFAULT);
				return;
			case MqPackage.MQ_QUEUE_CONNECTION_FACTORY__DESCRIPTION1:
				setDescription1(DESCRIPTION1_EDEFAULT);
				return;
			case MqPackage.MQ_QUEUE_CONNECTION_FACTORY__ENABLE_CONNECTION_POLING:
				setEnableConnectionPoling(ENABLE_CONNECTION_POLING_EDEFAULT);
				return;
			case MqPackage.MQ_QUEUE_CONNECTION_FACTORY__ENABLE_MESSAGE_RETENTION:
				setEnableMessageRetention(ENABLE_MESSAGE_RETENTION_EDEFAULT);
				return;
			case MqPackage.MQ_QUEUE_CONNECTION_FACTORY__ENABLE_RETURN_METHOD_DURING_SHUTDOWN:
				setEnableReturnMethodDuringShutdown(ENABLE_RETURN_METHOD_DURING_SHUTDOWN_EDEFAULT);
				return;
			case MqPackage.MQ_QUEUE_CONNECTION_FACTORY__FACTORY_NAME:
				setFactoryName(FACTORY_NAME_EDEFAULT);
				return;
			case MqPackage.MQ_QUEUE_CONNECTION_FACTORY__HOST:
				setHost(HOST_EDEFAULT);
				return;
			case MqPackage.MQ_QUEUE_CONNECTION_FACTORY__JNDI_NAME:
				setJndiName(JNDI_NAME_EDEFAULT);
				return;
			case MqPackage.MQ_QUEUE_CONNECTION_FACTORY__LOCAL_SERVER_ADDRESS:
				setLocalServerAddress(LOCAL_SERVER_ADDRESS_EDEFAULT);
				return;
			case MqPackage.MQ_QUEUE_CONNECTION_FACTORY__MAPPINGCONFIGURATION_ALIAS:
				setMappingconfigurationAlias(MAPPINGCONFIGURATION_ALIAS_EDEFAULT);
				return;
			case MqPackage.MQ_QUEUE_CONNECTION_FACTORY__MAX_CONNECTIONS:
				setMaxConnections(MAX_CONNECTIONS_EDEFAULT);
				return;
			case MqPackage.MQ_QUEUE_CONNECTION_FACTORY__MAX_SESSIONS:
				setMaxSessions(MAX_SESSIONS_EDEFAULT);
				return;
			case MqPackage.MQ_QUEUE_CONNECTION_FACTORY__MIN_CONNECTIONS:
				setMinConnections(MIN_CONNECTIONS_EDEFAULT);
				return;
			case MqPackage.MQ_QUEUE_CONNECTION_FACTORY__MIN_SESSIONS:
				setMinSessions(MIN_SESSIONS_EDEFAULT);
				return;
			case MqPackage.MQ_QUEUE_CONNECTION_FACTORY__MODEL_QUEUE_DEFINITION:
				setModelQueueDefinition(MODEL_QUEUE_DEFINITION_EDEFAULT);
				return;
			case MqPackage.MQ_QUEUE_CONNECTION_FACTORY__POLLING_INTERVAL:
				setPollingInterval(POLLING_INTERVAL_EDEFAULT);
				return;
			case MqPackage.MQ_QUEUE_CONNECTION_FACTORY__PORT:
				setPort(PORT_EDEFAULT);
				return;
			case MqPackage.MQ_QUEUE_CONNECTION_FACTORY__QUEUEMANAGER:
				setQueuemanager(QUEUEMANAGER_EDEFAULT);
				return;
			case MqPackage.MQ_QUEUE_CONNECTION_FACTORY__RESCAN_INTERVAL:
				setRescanInterval(RESCAN_INTERVAL_EDEFAULT);
				return;
			case MqPackage.MQ_QUEUE_CONNECTION_FACTORY__SSL_CIPHER_SUIT:
				setSSLCipherSuit(SSL_CIPHER_SUIT_EDEFAULT);
				return;
			case MqPackage.MQ_QUEUE_CONNECTION_FACTORY__SSLCRL:
				setSSLCRL(SSLCRL_EDEFAULT);
				return;
			case MqPackage.MQ_QUEUE_CONNECTION_FACTORY__SSL_PEER_NAME:
				setSSLPeerName(SSL_PEER_NAME_EDEFAULT);
				return;
			case MqPackage.MQ_QUEUE_CONNECTION_FACTORY__TEMPORARY_QUEUE_PREFIX:
				setTemporaryQueuePrefix(TEMPORARY_QUEUE_PREFIX_EDEFAULT);
				return;
			case MqPackage.MQ_QUEUE_CONNECTION_FACTORY__TRANSPORT_TYPE:
				setTransportType(TRANSPORT_TYPE_EDEFAULT);
				return;
			case MqPackage.MQ_QUEUE_CONNECTION_FACTORY__XA_ENABLED:
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
			case MqPackage.MQ_QUEUE_CONNECTION_FACTORY__CATEGORY:
				return CATEGORY_EDEFAULT == null ? category != null : !CATEGORY_EDEFAULT.equals(category);
			case MqPackage.MQ_QUEUE_CONNECTION_FACTORY__CCSID:
				return CCSID_EDEFAULT == null ? cCSID != null : !CCSID_EDEFAULT.equals(cCSID);
			case MqPackage.MQ_QUEUE_CONNECTION_FACTORY__CHANNEL:
				return CHANNEL_EDEFAULT == null ? channel != null : !CHANNEL_EDEFAULT.equals(channel);
			case MqPackage.MQ_QUEUE_CONNECTION_FACTORY__CLIENT_ID:
				return CLIENT_ID_EDEFAULT == null ? clientId != null : !CLIENT_ID_EDEFAULT.equals(clientId);
			case MqPackage.MQ_QUEUE_CONNECTION_FACTORY__COMPONENT_MANAGED_AUTHENTICATION_ALIAS:
				return COMPONENT_MANAGED_AUTHENTICATION_ALIAS_EDEFAULT == null ? componentManagedAuthenticationAlias != null : !COMPONENT_MANAGED_AUTHENTICATION_ALIAS_EDEFAULT.equals(componentManagedAuthenticationAlias);
			case MqPackage.MQ_QUEUE_CONNECTION_FACTORY__CONTAINER_MANAGED_AUTHENTICATION_ALIAS:
				return CONTAINER_MANAGED_AUTHENTICATION_ALIAS_EDEFAULT == null ? containerManagedAuthenticationAlias != null : !CONTAINER_MANAGED_AUTHENTICATION_ALIAS_EDEFAULT.equals(containerManagedAuthenticationAlias);
			case MqPackage.MQ_QUEUE_CONNECTION_FACTORY__DESCRIPTION1:
				return DESCRIPTION1_EDEFAULT == null ? description1 != null : !DESCRIPTION1_EDEFAULT.equals(description1);
			case MqPackage.MQ_QUEUE_CONNECTION_FACTORY__ENABLE_CONNECTION_POLING:
				return ENABLE_CONNECTION_POLING_EDEFAULT == null ? enableConnectionPoling != null : !ENABLE_CONNECTION_POLING_EDEFAULT.equals(enableConnectionPoling);
			case MqPackage.MQ_QUEUE_CONNECTION_FACTORY__ENABLE_MESSAGE_RETENTION:
				return ENABLE_MESSAGE_RETENTION_EDEFAULT == null ? enableMessageRetention != null : !ENABLE_MESSAGE_RETENTION_EDEFAULT.equals(enableMessageRetention);
			case MqPackage.MQ_QUEUE_CONNECTION_FACTORY__ENABLE_RETURN_METHOD_DURING_SHUTDOWN:
				return ENABLE_RETURN_METHOD_DURING_SHUTDOWN_EDEFAULT == null ? enableReturnMethodDuringShutdown != null : !ENABLE_RETURN_METHOD_DURING_SHUTDOWN_EDEFAULT.equals(enableReturnMethodDuringShutdown);
			case MqPackage.MQ_QUEUE_CONNECTION_FACTORY__FACTORY_NAME:
				return FACTORY_NAME_EDEFAULT == null ? factoryName != null : !FACTORY_NAME_EDEFAULT.equals(factoryName);
			case MqPackage.MQ_QUEUE_CONNECTION_FACTORY__HOST:
				return HOST_EDEFAULT == null ? host != null : !HOST_EDEFAULT.equals(host);
			case MqPackage.MQ_QUEUE_CONNECTION_FACTORY__JNDI_NAME:
				return JNDI_NAME_EDEFAULT == null ? jndiName != null : !JNDI_NAME_EDEFAULT.equals(jndiName);
			case MqPackage.MQ_QUEUE_CONNECTION_FACTORY__LOCAL_SERVER_ADDRESS:
				return LOCAL_SERVER_ADDRESS_EDEFAULT == null ? localServerAddress != null : !LOCAL_SERVER_ADDRESS_EDEFAULT.equals(localServerAddress);
			case MqPackage.MQ_QUEUE_CONNECTION_FACTORY__MAPPINGCONFIGURATION_ALIAS:
				return MAPPINGCONFIGURATION_ALIAS_EDEFAULT == null ? mappingconfigurationAlias != null : !MAPPINGCONFIGURATION_ALIAS_EDEFAULT.equals(mappingconfigurationAlias);
			case MqPackage.MQ_QUEUE_CONNECTION_FACTORY__MAX_CONNECTIONS:
				return MAX_CONNECTIONS_EDEFAULT == null ? maxConnections != null : !MAX_CONNECTIONS_EDEFAULT.equals(maxConnections);
			case MqPackage.MQ_QUEUE_CONNECTION_FACTORY__MAX_SESSIONS:
				return MAX_SESSIONS_EDEFAULT == null ? maxSessions != null : !MAX_SESSIONS_EDEFAULT.equals(maxSessions);
			case MqPackage.MQ_QUEUE_CONNECTION_FACTORY__MIN_CONNECTIONS:
				return MIN_CONNECTIONS_EDEFAULT == null ? minConnections != null : !MIN_CONNECTIONS_EDEFAULT.equals(minConnections);
			case MqPackage.MQ_QUEUE_CONNECTION_FACTORY__MIN_SESSIONS:
				return MIN_SESSIONS_EDEFAULT == null ? minSessions != null : !MIN_SESSIONS_EDEFAULT.equals(minSessions);
			case MqPackage.MQ_QUEUE_CONNECTION_FACTORY__MODEL_QUEUE_DEFINITION:
				return MODEL_QUEUE_DEFINITION_EDEFAULT == null ? modelQueueDefinition != null : !MODEL_QUEUE_DEFINITION_EDEFAULT.equals(modelQueueDefinition);
			case MqPackage.MQ_QUEUE_CONNECTION_FACTORY__POLLING_INTERVAL:
				return POLLING_INTERVAL_EDEFAULT == null ? pollingInterval != null : !POLLING_INTERVAL_EDEFAULT.equals(pollingInterval);
			case MqPackage.MQ_QUEUE_CONNECTION_FACTORY__PORT:
				return PORT_EDEFAULT == null ? port != null : !PORT_EDEFAULT.equals(port);
			case MqPackage.MQ_QUEUE_CONNECTION_FACTORY__QUEUEMANAGER:
				return QUEUEMANAGER_EDEFAULT == null ? queuemanager != null : !QUEUEMANAGER_EDEFAULT.equals(queuemanager);
			case MqPackage.MQ_QUEUE_CONNECTION_FACTORY__RESCAN_INTERVAL:
				return RESCAN_INTERVAL_EDEFAULT == null ? rescanInterval != null : !RESCAN_INTERVAL_EDEFAULT.equals(rescanInterval);
			case MqPackage.MQ_QUEUE_CONNECTION_FACTORY__SSL_CIPHER_SUIT:
				return SSL_CIPHER_SUIT_EDEFAULT == null ? sSLCipherSuit != null : !SSL_CIPHER_SUIT_EDEFAULT.equals(sSLCipherSuit);
			case MqPackage.MQ_QUEUE_CONNECTION_FACTORY__SSLCRL:
				return SSLCRL_EDEFAULT == null ? sSLCRL != null : !SSLCRL_EDEFAULT.equals(sSLCRL);
			case MqPackage.MQ_QUEUE_CONNECTION_FACTORY__SSL_PEER_NAME:
				return SSL_PEER_NAME_EDEFAULT == null ? sSLPeerName != null : !SSL_PEER_NAME_EDEFAULT.equals(sSLPeerName);
			case MqPackage.MQ_QUEUE_CONNECTION_FACTORY__TEMPORARY_QUEUE_PREFIX:
				return TEMPORARY_QUEUE_PREFIX_EDEFAULT == null ? temporaryQueuePrefix != null : !TEMPORARY_QUEUE_PREFIX_EDEFAULT.equals(temporaryQueuePrefix);
			case MqPackage.MQ_QUEUE_CONNECTION_FACTORY__TRANSPORT_TYPE:
				return TRANSPORT_TYPE_EDEFAULT == null ? transportType != null : !TRANSPORT_TYPE_EDEFAULT.equals(transportType);
			case MqPackage.MQ_QUEUE_CONNECTION_FACTORY__XA_ENABLED:
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
		result.append(" (category: "); //$NON-NLS-1$
		result.append(category);
		result.append(", cCSID: "); //$NON-NLS-1$
		result.append(cCSID);
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
		result.append(", enableConnectionPoling: "); //$NON-NLS-1$
		result.append(enableConnectionPoling);
		result.append(", enableMessageRetention: "); //$NON-NLS-1$
		result.append(enableMessageRetention);
		result.append(", enableReturnMethodDuringShutdown: "); //$NON-NLS-1$
		result.append(enableReturnMethodDuringShutdown);
		result.append(", factoryName: "); //$NON-NLS-1$
		result.append(factoryName);
		result.append(", host: "); //$NON-NLS-1$
		result.append(host);
		result.append(", jndiName: "); //$NON-NLS-1$
		result.append(jndiName);
		result.append(", localServerAddress: "); //$NON-NLS-1$
		result.append(localServerAddress);
		result.append(", mappingconfigurationAlias: "); //$NON-NLS-1$
		result.append(mappingconfigurationAlias);
		result.append(", maxConnections: "); //$NON-NLS-1$
		result.append(maxConnections);
		result.append(", maxSessions: "); //$NON-NLS-1$
		result.append(maxSessions);
		result.append(", minConnections: "); //$NON-NLS-1$
		result.append(minConnections);
		result.append(", minSessions: "); //$NON-NLS-1$
		result.append(minSessions);
		result.append(", modelQueueDefinition: "); //$NON-NLS-1$
		result.append(modelQueueDefinition);
		result.append(", pollingInterval: "); //$NON-NLS-1$
		result.append(pollingInterval);
		result.append(", port: "); //$NON-NLS-1$
		result.append(port);
		result.append(", queuemanager: "); //$NON-NLS-1$
		result.append(queuemanager);
		result.append(", rescanInterval: "); //$NON-NLS-1$
		result.append(rescanInterval);
		result.append(", sSLCipherSuit: "); //$NON-NLS-1$
		result.append(sSLCipherSuit);
		result.append(", sSLCRL: "); //$NON-NLS-1$
		result.append(sSLCRL);
		result.append(", sSLPeerName: "); //$NON-NLS-1$
		result.append(sSLPeerName);
		result.append(", temporaryQueuePrefix: "); //$NON-NLS-1$
		result.append(temporaryQueuePrefix);
		result.append(", transportType: "); //$NON-NLS-1$
		result.append(transportType);
		result.append(", xAEnabled: "); //$NON-NLS-1$
		result.append(xAEnabled);
		result.append(')');
		return result.toString();
	}

} //MQQueueConnectionFactoryImpl
