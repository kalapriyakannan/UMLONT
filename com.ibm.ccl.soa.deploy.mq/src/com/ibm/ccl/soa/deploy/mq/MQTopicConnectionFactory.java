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
 * A representation of the model object '<em><b>MQ Topic Connection Factory</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link com.ibm.ccl.soa.deploy.mq.MQTopicConnectionFactory#getBrokerCCSubscriptionQueue <em>Broker CC Subscription Queue</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.mq.MQTopicConnectionFactory#getBrokerControlQueue <em>Broker Control Queue</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.mq.MQTopicConnectionFactory#getBrokerMessageSelection <em>Broker Message Selection</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.mq.MQTopicConnectionFactory#getBrokerPublicationQueue <em>Broker Publication Queue</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.mq.MQTopicConnectionFactory#getBrokerQueueManager <em>Broker Queue Manager</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.mq.MQTopicConnectionFactory#getBrokerSubscriptionQueue <em>Broker Subscription Queue</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.mq.MQTopicConnectionFactory#getBrokerVersion <em>Broker Version</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.mq.MQTopicConnectionFactory#getCategory <em>Category</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.mq.MQTopicConnectionFactory#getCCSIDId <em>CCSID Id</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.mq.MQTopicConnectionFactory#getChannel <em>Channel</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.mq.MQTopicConnectionFactory#getClientId <em>Client Id</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.mq.MQTopicConnectionFactory#getComponentManagedAuthenticationAlias <em>Component Managed Authentication Alias</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.mq.MQTopicConnectionFactory#getContainerManagedAuthenticationAlias <em>Container Managed Authentication Alias</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.mq.MQTopicConnectionFactory#getDescription1 <em>Description1</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.mq.MQTopicConnectionFactory#getDirectBrokerAuthorization <em>Direct Broker Authorization</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.mq.MQTopicConnectionFactory#getEnableCloneSupport <em>Enable Clone Support</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.mq.MQTopicConnectionFactory#getEnableMQConnectionPooling <em>Enable MQ Connection Pooling</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.mq.MQTopicConnectionFactory#getEnableMulticastTransport <em>Enable Multicast Transport</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.mq.MQTopicConnectionFactory#getEnableReturnMethodsDuringShutdown <em>Enable Return Methods During Shutdown</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.mq.MQTopicConnectionFactory#getFactoryName <em>Factory Name</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.mq.MQTopicConnectionFactory#getHost <em>Host</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.mq.MQTopicConnectionFactory#getJndiName <em>Jndi Name</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.mq.MQTopicConnectionFactory#getLocalServerAddress <em>Local Server Address</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.mq.MQTopicConnectionFactory#getMappingConfigurationAlias <em>Mapping Configuration Alias</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.mq.MQTopicConnectionFactory#getModelQueueDefinition <em>Model Queue Definition</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.mq.MQTopicConnectionFactory#getPersistentSubscriptionStore <em>Persistent Subscription Store</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.mq.MQTopicConnectionFactory#getPollingInterval <em>Polling Interval</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.mq.MQTopicConnectionFactory#getPort <em>Port</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.mq.MQTopicConnectionFactory#getProxyHostName <em>Proxy Host Name</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.mq.MQTopicConnectionFactory#getProxyPort <em>Proxy Port</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.mq.MQTopicConnectionFactory#getPublishAndAcknowledgeLevel <em>Publish And Acknowledge Level</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.mq.MQTopicConnectionFactory#getPublishAndSubscribeCleanupInterval <em>Publish And Subscribe Cleanup Interval</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.mq.MQTopicConnectionFactory#getPublishAndSubscribeCleanupLevel <em>Publish And Subscribe Cleanup Level</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.mq.MQTopicConnectionFactory#getPublishAndSubscribeStatusInterval <em>Publish And Subscribe Status Interval</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.mq.MQTopicConnectionFactory#getQueueManager <em>Queue Manager</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.mq.MQTopicConnectionFactory#getRescanInterval <em>Rescan Interval</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.mq.MQTopicConnectionFactory#getSSLCipherSuite <em>SSL Cipher Suite</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.mq.MQTopicConnectionFactory#getSSLCRL <em>SSLCRL</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.mq.MQTopicConnectionFactory#getSSLPeerName <em>SSL Peer Name</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.mq.MQTopicConnectionFactory#getTransportType <em>Transport Type</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.mq.MQTopicConnectionFactory#getXAEnabled <em>XA Enabled</em>}</li>
 * </ul>
 * </p>
 *
 * @see com.ibm.ccl.soa.deploy.mq.MqPackage#getMQTopicConnectionFactory()
 * @model extendedMetaData="name='MQTopicConnectionFactory' kind='elementOnly'"
 * @generated
 */
public interface MQTopicConnectionFactory extends Capability {
	/**
	 * Returns the value of the '<em><b>Broker CC Subscription Queue</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Broker CC Subscription Queue</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Broker CC Subscription Queue</em>' attribute.
	 * @see #setBrokerCCSubscriptionQueue(String)
	 * @see com.ibm.ccl.soa.deploy.mq.MqPackage#getMQTopicConnectionFactory_BrokerCCSubscriptionQueue()
	 * @model dataType="org.eclipse.emf.ecore.xml.type.String"
	 *        extendedMetaData="kind='attribute' name='BrokerCCSubscriptionQueue'"
	 * @generated
	 */
	String getBrokerCCSubscriptionQueue();

	/**
	 * Sets the value of the '{@link com.ibm.ccl.soa.deploy.mq.MQTopicConnectionFactory#getBrokerCCSubscriptionQueue <em>Broker CC Subscription Queue</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Broker CC Subscription Queue</em>' attribute.
	 * @see #getBrokerCCSubscriptionQueue()
	 * @generated
	 */
	void setBrokerCCSubscriptionQueue(String value);

	/**
	 * Returns the value of the '<em><b>Broker Control Queue</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Broker Control Queue</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Broker Control Queue</em>' attribute.
	 * @see #setBrokerControlQueue(String)
	 * @see com.ibm.ccl.soa.deploy.mq.MqPackage#getMQTopicConnectionFactory_BrokerControlQueue()
	 * @model dataType="org.eclipse.emf.ecore.xml.type.String"
	 *        extendedMetaData="kind='attribute' name='BrokerControlQueue'"
	 * @generated
	 */
	String getBrokerControlQueue();

	/**
	 * Sets the value of the '{@link com.ibm.ccl.soa.deploy.mq.MQTopicConnectionFactory#getBrokerControlQueue <em>Broker Control Queue</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Broker Control Queue</em>' attribute.
	 * @see #getBrokerControlQueue()
	 * @generated
	 */
	void setBrokerControlQueue(String value);

	/**
	 * Returns the value of the '<em><b>Broker Message Selection</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Broker Message Selection</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Broker Message Selection</em>' attribute.
	 * @see #setBrokerMessageSelection(String)
	 * @see com.ibm.ccl.soa.deploy.mq.MqPackage#getMQTopicConnectionFactory_BrokerMessageSelection()
	 * @model dataType="org.eclipse.emf.ecore.xml.type.String"
	 *        extendedMetaData="kind='attribute' name='BrokerMessageSelection'"
	 * @generated
	 */
	String getBrokerMessageSelection();

	/**
	 * Sets the value of the '{@link com.ibm.ccl.soa.deploy.mq.MQTopicConnectionFactory#getBrokerMessageSelection <em>Broker Message Selection</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Broker Message Selection</em>' attribute.
	 * @see #getBrokerMessageSelection()
	 * @generated
	 */
	void setBrokerMessageSelection(String value);

	/**
	 * Returns the value of the '<em><b>Broker Publication Queue</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Broker Publication Queue</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Broker Publication Queue</em>' attribute.
	 * @see #setBrokerPublicationQueue(String)
	 * @see com.ibm.ccl.soa.deploy.mq.MqPackage#getMQTopicConnectionFactory_BrokerPublicationQueue()
	 * @model dataType="org.eclipse.emf.ecore.xml.type.String"
	 *        extendedMetaData="kind='attribute' name='BrokerPublicationQueue'"
	 * @generated
	 */
	String getBrokerPublicationQueue();

	/**
	 * Sets the value of the '{@link com.ibm.ccl.soa.deploy.mq.MQTopicConnectionFactory#getBrokerPublicationQueue <em>Broker Publication Queue</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Broker Publication Queue</em>' attribute.
	 * @see #getBrokerPublicationQueue()
	 * @generated
	 */
	void setBrokerPublicationQueue(String value);

	/**
	 * Returns the value of the '<em><b>Broker Queue Manager</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Broker Queue Manager</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Broker Queue Manager</em>' attribute.
	 * @see #setBrokerQueueManager(String)
	 * @see com.ibm.ccl.soa.deploy.mq.MqPackage#getMQTopicConnectionFactory_BrokerQueueManager()
	 * @model dataType="org.eclipse.emf.ecore.xml.type.String"
	 *        extendedMetaData="kind='attribute' name='BrokerQueueManager'"
	 * @generated
	 */
	String getBrokerQueueManager();

	/**
	 * Sets the value of the '{@link com.ibm.ccl.soa.deploy.mq.MQTopicConnectionFactory#getBrokerQueueManager <em>Broker Queue Manager</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Broker Queue Manager</em>' attribute.
	 * @see #getBrokerQueueManager()
	 * @generated
	 */
	void setBrokerQueueManager(String value);

	/**
	 * Returns the value of the '<em><b>Broker Subscription Queue</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Broker Subscription Queue</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Broker Subscription Queue</em>' attribute.
	 * @see #setBrokerSubscriptionQueue(String)
	 * @see com.ibm.ccl.soa.deploy.mq.MqPackage#getMQTopicConnectionFactory_BrokerSubscriptionQueue()
	 * @model dataType="org.eclipse.emf.ecore.xml.type.String"
	 *        extendedMetaData="kind='attribute' name='BrokerSubscriptionQueue'"
	 * @generated
	 */
	String getBrokerSubscriptionQueue();

	/**
	 * Sets the value of the '{@link com.ibm.ccl.soa.deploy.mq.MQTopicConnectionFactory#getBrokerSubscriptionQueue <em>Broker Subscription Queue</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Broker Subscription Queue</em>' attribute.
	 * @see #getBrokerSubscriptionQueue()
	 * @generated
	 */
	void setBrokerSubscriptionQueue(String value);

	/**
	 * Returns the value of the '<em><b>Broker Version</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Broker Version</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Broker Version</em>' attribute.
	 * @see #setBrokerVersion(String)
	 * @see com.ibm.ccl.soa.deploy.mq.MqPackage#getMQTopicConnectionFactory_BrokerVersion()
	 * @model dataType="org.eclipse.emf.ecore.xml.type.String"
	 *        extendedMetaData="kind='attribute' name='BrokerVersion'"
	 * @generated
	 */
	String getBrokerVersion();

	/**
	 * Sets the value of the '{@link com.ibm.ccl.soa.deploy.mq.MQTopicConnectionFactory#getBrokerVersion <em>Broker Version</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Broker Version</em>' attribute.
	 * @see #getBrokerVersion()
	 * @generated
	 */
	void setBrokerVersion(String value);

	/**
	 * Returns the value of the '<em><b>Category</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Category</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Category</em>' attribute.
	 * @see #setCategory(String)
	 * @see com.ibm.ccl.soa.deploy.mq.MqPackage#getMQTopicConnectionFactory_Category()
	 * @model dataType="org.eclipse.emf.ecore.xml.type.String"
	 *        extendedMetaData="kind='attribute' name='Category'"
	 * @generated
	 */
	String getCategory();

	/**
	 * Sets the value of the '{@link com.ibm.ccl.soa.deploy.mq.MQTopicConnectionFactory#getCategory <em>Category</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Category</em>' attribute.
	 * @see #getCategory()
	 * @generated
	 */
	void setCategory(String value);

	/**
	 * Returns the value of the '<em><b>CCSID Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>CCSID Id</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>CCSID Id</em>' attribute.
	 * @see #setCCSIDId(String)
	 * @see com.ibm.ccl.soa.deploy.mq.MqPackage#getMQTopicConnectionFactory_CCSIDId()
	 * @model dataType="org.eclipse.emf.ecore.xml.type.String"
	 *        extendedMetaData="kind='attribute' name='CCSIDId'"
	 * @generated
	 */
	String getCCSIDId();

	/**
	 * Sets the value of the '{@link com.ibm.ccl.soa.deploy.mq.MQTopicConnectionFactory#getCCSIDId <em>CCSID Id</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>CCSID Id</em>' attribute.
	 * @see #getCCSIDId()
	 * @generated
	 */
	void setCCSIDId(String value);

	/**
	 * Returns the value of the '<em><b>Channel</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Channel</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Channel</em>' attribute.
	 * @see #setChannel(String)
	 * @see com.ibm.ccl.soa.deploy.mq.MqPackage#getMQTopicConnectionFactory_Channel()
	 * @model dataType="org.eclipse.emf.ecore.xml.type.String"
	 *        extendedMetaData="kind='attribute' name='Channel'"
	 * @generated
	 */
	String getChannel();

	/**
	 * Sets the value of the '{@link com.ibm.ccl.soa.deploy.mq.MQTopicConnectionFactory#getChannel <em>Channel</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Channel</em>' attribute.
	 * @see #getChannel()
	 * @generated
	 */
	void setChannel(String value);

	/**
	 * Returns the value of the '<em><b>Client Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Client Id</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Client Id</em>' attribute.
	 * @see #setClientId(String)
	 * @see com.ibm.ccl.soa.deploy.mq.MqPackage#getMQTopicConnectionFactory_ClientId()
	 * @model dataType="org.eclipse.emf.ecore.xml.type.String"
	 *        extendedMetaData="kind='attribute' name='ClientId'"
	 * @generated
	 */
	String getClientId();

	/**
	 * Sets the value of the '{@link com.ibm.ccl.soa.deploy.mq.MQTopicConnectionFactory#getClientId <em>Client Id</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Client Id</em>' attribute.
	 * @see #getClientId()
	 * @generated
	 */
	void setClientId(String value);

	/**
	 * Returns the value of the '<em><b>Component Managed Authentication Alias</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Component Managed Authentication Alias</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Component Managed Authentication Alias</em>' attribute.
	 * @see #setComponentManagedAuthenticationAlias(String)
	 * @see com.ibm.ccl.soa.deploy.mq.MqPackage#getMQTopicConnectionFactory_ComponentManagedAuthenticationAlias()
	 * @model dataType="org.eclipse.emf.ecore.xml.type.String"
	 *        extendedMetaData="kind='attribute' name='ComponentManagedAuthenticationAlias'"
	 * @generated
	 */
	String getComponentManagedAuthenticationAlias();

	/**
	 * Sets the value of the '{@link com.ibm.ccl.soa.deploy.mq.MQTopicConnectionFactory#getComponentManagedAuthenticationAlias <em>Component Managed Authentication Alias</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Component Managed Authentication Alias</em>' attribute.
	 * @see #getComponentManagedAuthenticationAlias()
	 * @generated
	 */
	void setComponentManagedAuthenticationAlias(String value);

	/**
	 * Returns the value of the '<em><b>Container Managed Authentication Alias</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Container Managed Authentication Alias</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Container Managed Authentication Alias</em>' attribute.
	 * @see #setContainerManagedAuthenticationAlias(String)
	 * @see com.ibm.ccl.soa.deploy.mq.MqPackage#getMQTopicConnectionFactory_ContainerManagedAuthenticationAlias()
	 * @model dataType="org.eclipse.emf.ecore.xml.type.String"
	 *        extendedMetaData="kind='attribute' name='ContainerManagedAuthenticationAlias'"
	 * @generated
	 */
	String getContainerManagedAuthenticationAlias();

	/**
	 * Sets the value of the '{@link com.ibm.ccl.soa.deploy.mq.MQTopicConnectionFactory#getContainerManagedAuthenticationAlias <em>Container Managed Authentication Alias</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Container Managed Authentication Alias</em>' attribute.
	 * @see #getContainerManagedAuthenticationAlias()
	 * @generated
	 */
	void setContainerManagedAuthenticationAlias(String value);

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
	 * @see com.ibm.ccl.soa.deploy.mq.MqPackage#getMQTopicConnectionFactory_Description1()
	 * @model dataType="org.eclipse.emf.ecore.xml.type.String"
	 *        extendedMetaData="kind='attribute' name='Description'"
	 * @generated
	 */
	String getDescription1();

	/**
	 * Sets the value of the '{@link com.ibm.ccl.soa.deploy.mq.MQTopicConnectionFactory#getDescription1 <em>Description1</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Description1</em>' attribute.
	 * @see #getDescription1()
	 * @generated
	 */
	void setDescription1(String value);

	/**
	 * Returns the value of the '<em><b>Direct Broker Authorization</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Direct Broker Authorization</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Direct Broker Authorization</em>' attribute.
	 * @see #setDirectBrokerAuthorization(String)
	 * @see com.ibm.ccl.soa.deploy.mq.MqPackage#getMQTopicConnectionFactory_DirectBrokerAuthorization()
	 * @model dataType="org.eclipse.emf.ecore.xml.type.String"
	 *        extendedMetaData="kind='attribute' name='DirectBrokerAuthorization'"
	 * @generated
	 */
	String getDirectBrokerAuthorization();

	/**
	 * Sets the value of the '{@link com.ibm.ccl.soa.deploy.mq.MQTopicConnectionFactory#getDirectBrokerAuthorization <em>Direct Broker Authorization</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Direct Broker Authorization</em>' attribute.
	 * @see #getDirectBrokerAuthorization()
	 * @generated
	 */
	void setDirectBrokerAuthorization(String value);

	/**
	 * Returns the value of the '<em><b>Enable Clone Support</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Enable Clone Support</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Enable Clone Support</em>' attribute.
	 * @see #setEnableCloneSupport(String)
	 * @see com.ibm.ccl.soa.deploy.mq.MqPackage#getMQTopicConnectionFactory_EnableCloneSupport()
	 * @model dataType="org.eclipse.emf.ecore.xml.type.String"
	 *        extendedMetaData="kind='attribute' name='EnableCloneSupport'"
	 * @generated
	 */
	String getEnableCloneSupport();

	/**
	 * Sets the value of the '{@link com.ibm.ccl.soa.deploy.mq.MQTopicConnectionFactory#getEnableCloneSupport <em>Enable Clone Support</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Enable Clone Support</em>' attribute.
	 * @see #getEnableCloneSupport()
	 * @generated
	 */
	void setEnableCloneSupport(String value);

	/**
	 * Returns the value of the '<em><b>Enable MQ Connection Pooling</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Enable MQ Connection Pooling</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Enable MQ Connection Pooling</em>' attribute.
	 * @see #setEnableMQConnectionPooling(String)
	 * @see com.ibm.ccl.soa.deploy.mq.MqPackage#getMQTopicConnectionFactory_EnableMQConnectionPooling()
	 * @model dataType="org.eclipse.emf.ecore.xml.type.String"
	 *        extendedMetaData="kind='attribute' name='EnableMQConnectionPooling'"
	 * @generated
	 */
	String getEnableMQConnectionPooling();

	/**
	 * Sets the value of the '{@link com.ibm.ccl.soa.deploy.mq.MQTopicConnectionFactory#getEnableMQConnectionPooling <em>Enable MQ Connection Pooling</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Enable MQ Connection Pooling</em>' attribute.
	 * @see #getEnableMQConnectionPooling()
	 * @generated
	 */
	void setEnableMQConnectionPooling(String value);

	/**
	 * Returns the value of the '<em><b>Enable Multicast Transport</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Enable Multicast Transport</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Enable Multicast Transport</em>' attribute.
	 * @see #setEnableMulticastTransport(String)
	 * @see com.ibm.ccl.soa.deploy.mq.MqPackage#getMQTopicConnectionFactory_EnableMulticastTransport()
	 * @model dataType="org.eclipse.emf.ecore.xml.type.String"
	 *        extendedMetaData="kind='attribute' name='EnableMulticastTransport'"
	 * @generated
	 */
	String getEnableMulticastTransport();

	/**
	 * Sets the value of the '{@link com.ibm.ccl.soa.deploy.mq.MQTopicConnectionFactory#getEnableMulticastTransport <em>Enable Multicast Transport</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Enable Multicast Transport</em>' attribute.
	 * @see #getEnableMulticastTransport()
	 * @generated
	 */
	void setEnableMulticastTransport(String value);

	/**
	 * Returns the value of the '<em><b>Enable Return Methods During Shutdown</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Enable Return Methods During Shutdown</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Enable Return Methods During Shutdown</em>' attribute.
	 * @see #setEnableReturnMethodsDuringShutdown(String)
	 * @see com.ibm.ccl.soa.deploy.mq.MqPackage#getMQTopicConnectionFactory_EnableReturnMethodsDuringShutdown()
	 * @model dataType="org.eclipse.emf.ecore.xml.type.String"
	 *        extendedMetaData="kind='attribute' name='EnableReturnMethodsDuringShutdown'"
	 * @generated
	 */
	String getEnableReturnMethodsDuringShutdown();

	/**
	 * Sets the value of the '{@link com.ibm.ccl.soa.deploy.mq.MQTopicConnectionFactory#getEnableReturnMethodsDuringShutdown <em>Enable Return Methods During Shutdown</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Enable Return Methods During Shutdown</em>' attribute.
	 * @see #getEnableReturnMethodsDuringShutdown()
	 * @generated
	 */
	void setEnableReturnMethodsDuringShutdown(String value);

	/**
	 * Returns the value of the '<em><b>Factory Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Factory Name</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Factory Name</em>' attribute.
	 * @see #setFactoryName(String)
	 * @see com.ibm.ccl.soa.deploy.mq.MqPackage#getMQTopicConnectionFactory_FactoryName()
	 * @model dataType="org.eclipse.emf.ecore.xml.type.String"
	 *        extendedMetaData="kind='attribute' name='factoryName'"
	 * @generated
	 */
	String getFactoryName();

	/**
	 * Sets the value of the '{@link com.ibm.ccl.soa.deploy.mq.MQTopicConnectionFactory#getFactoryName <em>Factory Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Factory Name</em>' attribute.
	 * @see #getFactoryName()
	 * @generated
	 */
	void setFactoryName(String value);

	/**
	 * Returns the value of the '<em><b>Host</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Host</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Host</em>' attribute.
	 * @see #setHost(String)
	 * @see com.ibm.ccl.soa.deploy.mq.MqPackage#getMQTopicConnectionFactory_Host()
	 * @model dataType="org.eclipse.emf.ecore.xml.type.String"
	 *        extendedMetaData="kind='attribute' name='Host'"
	 * @generated
	 */
	String getHost();

	/**
	 * Sets the value of the '{@link com.ibm.ccl.soa.deploy.mq.MQTopicConnectionFactory#getHost <em>Host</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Host</em>' attribute.
	 * @see #getHost()
	 * @generated
	 */
	void setHost(String value);

	/**
	 * Returns the value of the '<em><b>Jndi Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Jndi Name</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Jndi Name</em>' attribute.
	 * @see #setJndiName(String)
	 * @see com.ibm.ccl.soa.deploy.mq.MqPackage#getMQTopicConnectionFactory_JndiName()
	 * @model dataType="org.eclipse.emf.ecore.xml.type.String"
	 *        extendedMetaData="kind='attribute' name='jndiName'"
	 * @generated
	 */
	String getJndiName();

	/**
	 * Sets the value of the '{@link com.ibm.ccl.soa.deploy.mq.MQTopicConnectionFactory#getJndiName <em>Jndi Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Jndi Name</em>' attribute.
	 * @see #getJndiName()
	 * @generated
	 */
	void setJndiName(String value);

	/**
	 * Returns the value of the '<em><b>Local Server Address</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Local Server Address</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Local Server Address</em>' attribute.
	 * @see #setLocalServerAddress(String)
	 * @see com.ibm.ccl.soa.deploy.mq.MqPackage#getMQTopicConnectionFactory_LocalServerAddress()
	 * @model dataType="org.eclipse.emf.ecore.xml.type.String"
	 *        extendedMetaData="kind='attribute' name='LocalServerAddress'"
	 * @generated
	 */
	String getLocalServerAddress();

	/**
	 * Sets the value of the '{@link com.ibm.ccl.soa.deploy.mq.MQTopicConnectionFactory#getLocalServerAddress <em>Local Server Address</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Local Server Address</em>' attribute.
	 * @see #getLocalServerAddress()
	 * @generated
	 */
	void setLocalServerAddress(String value);

	/**
	 * Returns the value of the '<em><b>Mapping Configuration Alias</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Mapping Configuration Alias</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Mapping Configuration Alias</em>' attribute.
	 * @see #setMappingConfigurationAlias(String)
	 * @see com.ibm.ccl.soa.deploy.mq.MqPackage#getMQTopicConnectionFactory_MappingConfigurationAlias()
	 * @model dataType="org.eclipse.emf.ecore.xml.type.String"
	 *        extendedMetaData="kind='attribute' name='MappingConfigurationAlias'"
	 * @generated
	 */
	String getMappingConfigurationAlias();

	/**
	 * Sets the value of the '{@link com.ibm.ccl.soa.deploy.mq.MQTopicConnectionFactory#getMappingConfigurationAlias <em>Mapping Configuration Alias</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Mapping Configuration Alias</em>' attribute.
	 * @see #getMappingConfigurationAlias()
	 * @generated
	 */
	void setMappingConfigurationAlias(String value);

	/**
	 * Returns the value of the '<em><b>Model Queue Definition</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Model Queue Definition</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Model Queue Definition</em>' attribute.
	 * @see #setModelQueueDefinition(String)
	 * @see com.ibm.ccl.soa.deploy.mq.MqPackage#getMQTopicConnectionFactory_ModelQueueDefinition()
	 * @model dataType="org.eclipse.emf.ecore.xml.type.String"
	 *        extendedMetaData="kind='attribute' name='ModelQueueDefinition'"
	 * @generated
	 */
	String getModelQueueDefinition();

	/**
	 * Sets the value of the '{@link com.ibm.ccl.soa.deploy.mq.MQTopicConnectionFactory#getModelQueueDefinition <em>Model Queue Definition</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Model Queue Definition</em>' attribute.
	 * @see #getModelQueueDefinition()
	 * @generated
	 */
	void setModelQueueDefinition(String value);

	/**
	 * Returns the value of the '<em><b>Persistent Subscription Store</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Persistent Subscription Store</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Persistent Subscription Store</em>' attribute.
	 * @see #setPersistentSubscriptionStore(String)
	 * @see com.ibm.ccl.soa.deploy.mq.MqPackage#getMQTopicConnectionFactory_PersistentSubscriptionStore()
	 * @model dataType="org.eclipse.emf.ecore.xml.type.String"
	 *        extendedMetaData="kind='attribute' name='PersistentSubscriptionStore'"
	 * @generated
	 */
	String getPersistentSubscriptionStore();

	/**
	 * Sets the value of the '{@link com.ibm.ccl.soa.deploy.mq.MQTopicConnectionFactory#getPersistentSubscriptionStore <em>Persistent Subscription Store</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Persistent Subscription Store</em>' attribute.
	 * @see #getPersistentSubscriptionStore()
	 * @generated
	 */
	void setPersistentSubscriptionStore(String value);

	/**
	 * Returns the value of the '<em><b>Polling Interval</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Polling Interval</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Polling Interval</em>' attribute.
	 * @see #setPollingInterval(String)
	 * @see com.ibm.ccl.soa.deploy.mq.MqPackage#getMQTopicConnectionFactory_PollingInterval()
	 * @model dataType="org.eclipse.emf.ecore.xml.type.String"
	 *        extendedMetaData="kind='attribute' name='PollingInterval'"
	 * @generated
	 */
	String getPollingInterval();

	/**
	 * Sets the value of the '{@link com.ibm.ccl.soa.deploy.mq.MQTopicConnectionFactory#getPollingInterval <em>Polling Interval</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Polling Interval</em>' attribute.
	 * @see #getPollingInterval()
	 * @generated
	 */
	void setPollingInterval(String value);

	/**
	 * Returns the value of the '<em><b>Port</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Port</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Port</em>' attribute.
	 * @see #setPort(String)
	 * @see com.ibm.ccl.soa.deploy.mq.MqPackage#getMQTopicConnectionFactory_Port()
	 * @model dataType="org.eclipse.emf.ecore.xml.type.String"
	 *        extendedMetaData="kind='attribute' name='Port'"
	 * @generated
	 */
	String getPort();

	/**
	 * Sets the value of the '{@link com.ibm.ccl.soa.deploy.mq.MQTopicConnectionFactory#getPort <em>Port</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Port</em>' attribute.
	 * @see #getPort()
	 * @generated
	 */
	void setPort(String value);

	/**
	 * Returns the value of the '<em><b>Proxy Host Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Proxy Host Name</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Proxy Host Name</em>' attribute.
	 * @see #setProxyHostName(String)
	 * @see com.ibm.ccl.soa.deploy.mq.MqPackage#getMQTopicConnectionFactory_ProxyHostName()
	 * @model dataType="org.eclipse.emf.ecore.xml.type.String"
	 *        extendedMetaData="kind='attribute' name='ProxyHostName'"
	 * @generated
	 */
	String getProxyHostName();

	/**
	 * Sets the value of the '{@link com.ibm.ccl.soa.deploy.mq.MQTopicConnectionFactory#getProxyHostName <em>Proxy Host Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Proxy Host Name</em>' attribute.
	 * @see #getProxyHostName()
	 * @generated
	 */
	void setProxyHostName(String value);

	/**
	 * Returns the value of the '<em><b>Proxy Port</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Proxy Port</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Proxy Port</em>' attribute.
	 * @see #setProxyPort(String)
	 * @see com.ibm.ccl.soa.deploy.mq.MqPackage#getMQTopicConnectionFactory_ProxyPort()
	 * @model dataType="org.eclipse.emf.ecore.xml.type.String"
	 *        extendedMetaData="kind='attribute' name='ProxyPort'"
	 * @generated
	 */
	String getProxyPort();

	/**
	 * Sets the value of the '{@link com.ibm.ccl.soa.deploy.mq.MQTopicConnectionFactory#getProxyPort <em>Proxy Port</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Proxy Port</em>' attribute.
	 * @see #getProxyPort()
	 * @generated
	 */
	void setProxyPort(String value);

	/**
	 * Returns the value of the '<em><b>Publish And Acknowledge Level</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Publish And Acknowledge Level</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Publish And Acknowledge Level</em>' attribute.
	 * @see #setPublishAndAcknowledgeLevel(String)
	 * @see com.ibm.ccl.soa.deploy.mq.MqPackage#getMQTopicConnectionFactory_PublishAndAcknowledgeLevel()
	 * @model dataType="org.eclipse.emf.ecore.xml.type.String"
	 *        extendedMetaData="kind='attribute' name='PublishAndAcknowledgeLevel'"
	 * @generated
	 */
	String getPublishAndAcknowledgeLevel();

	/**
	 * Sets the value of the '{@link com.ibm.ccl.soa.deploy.mq.MQTopicConnectionFactory#getPublishAndAcknowledgeLevel <em>Publish And Acknowledge Level</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Publish And Acknowledge Level</em>' attribute.
	 * @see #getPublishAndAcknowledgeLevel()
	 * @generated
	 */
	void setPublishAndAcknowledgeLevel(String value);

	/**
	 * Returns the value of the '<em><b>Publish And Subscribe Cleanup Interval</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Publish And Subscribe Cleanup Interval</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Publish And Subscribe Cleanup Interval</em>' attribute.
	 * @see #setPublishAndSubscribeCleanupInterval(String)
	 * @see com.ibm.ccl.soa.deploy.mq.MqPackage#getMQTopicConnectionFactory_PublishAndSubscribeCleanupInterval()
	 * @model dataType="org.eclipse.emf.ecore.xml.type.String"
	 *        extendedMetaData="kind='attribute' name='PublishAndSubscribeCleanupInterval'"
	 * @generated
	 */
	String getPublishAndSubscribeCleanupInterval();

	/**
	 * Sets the value of the '{@link com.ibm.ccl.soa.deploy.mq.MQTopicConnectionFactory#getPublishAndSubscribeCleanupInterval <em>Publish And Subscribe Cleanup Interval</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Publish And Subscribe Cleanup Interval</em>' attribute.
	 * @see #getPublishAndSubscribeCleanupInterval()
	 * @generated
	 */
	void setPublishAndSubscribeCleanupInterval(String value);

	/**
	 * Returns the value of the '<em><b>Publish And Subscribe Cleanup Level</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Publish And Subscribe Cleanup Level</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Publish And Subscribe Cleanup Level</em>' attribute.
	 * @see #setPublishAndSubscribeCleanupLevel(String)
	 * @see com.ibm.ccl.soa.deploy.mq.MqPackage#getMQTopicConnectionFactory_PublishAndSubscribeCleanupLevel()
	 * @model dataType="org.eclipse.emf.ecore.xml.type.String"
	 *        extendedMetaData="kind='attribute' name='PublishAndSubscribeCleanupLevel'"
	 * @generated
	 */
	String getPublishAndSubscribeCleanupLevel();

	/**
	 * Sets the value of the '{@link com.ibm.ccl.soa.deploy.mq.MQTopicConnectionFactory#getPublishAndSubscribeCleanupLevel <em>Publish And Subscribe Cleanup Level</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Publish And Subscribe Cleanup Level</em>' attribute.
	 * @see #getPublishAndSubscribeCleanupLevel()
	 * @generated
	 */
	void setPublishAndSubscribeCleanupLevel(String value);

	/**
	 * Returns the value of the '<em><b>Publish And Subscribe Status Interval</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Publish And Subscribe Status Interval</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Publish And Subscribe Status Interval</em>' attribute.
	 * @see #setPublishAndSubscribeStatusInterval(String)
	 * @see com.ibm.ccl.soa.deploy.mq.MqPackage#getMQTopicConnectionFactory_PublishAndSubscribeStatusInterval()
	 * @model dataType="org.eclipse.emf.ecore.xml.type.String"
	 *        extendedMetaData="kind='attribute' name='PublishAndSubscribeStatusInterval'"
	 * @generated
	 */
	String getPublishAndSubscribeStatusInterval();

	/**
	 * Sets the value of the '{@link com.ibm.ccl.soa.deploy.mq.MQTopicConnectionFactory#getPublishAndSubscribeStatusInterval <em>Publish And Subscribe Status Interval</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Publish And Subscribe Status Interval</em>' attribute.
	 * @see #getPublishAndSubscribeStatusInterval()
	 * @generated
	 */
	void setPublishAndSubscribeStatusInterval(String value);

	/**
	 * Returns the value of the '<em><b>Queue Manager</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Queue Manager</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Queue Manager</em>' attribute.
	 * @see #setQueueManager(String)
	 * @see com.ibm.ccl.soa.deploy.mq.MqPackage#getMQTopicConnectionFactory_QueueManager()
	 * @model dataType="org.eclipse.emf.ecore.xml.type.String"
	 *        extendedMetaData="kind='attribute' name='QueueManager'"
	 * @generated
	 */
	String getQueueManager();

	/**
	 * Sets the value of the '{@link com.ibm.ccl.soa.deploy.mq.MQTopicConnectionFactory#getQueueManager <em>Queue Manager</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Queue Manager</em>' attribute.
	 * @see #getQueueManager()
	 * @generated
	 */
	void setQueueManager(String value);

	/**
	 * Returns the value of the '<em><b>Rescan Interval</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Rescan Interval</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Rescan Interval</em>' attribute.
	 * @see #setRescanInterval(String)
	 * @see com.ibm.ccl.soa.deploy.mq.MqPackage#getMQTopicConnectionFactory_RescanInterval()
	 * @model dataType="org.eclipse.emf.ecore.xml.type.String"
	 *        extendedMetaData="kind='attribute' name='RescanInterval'"
	 * @generated
	 */
	String getRescanInterval();

	/**
	 * Sets the value of the '{@link com.ibm.ccl.soa.deploy.mq.MQTopicConnectionFactory#getRescanInterval <em>Rescan Interval</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Rescan Interval</em>' attribute.
	 * @see #getRescanInterval()
	 * @generated
	 */
	void setRescanInterval(String value);

	/**
	 * Returns the value of the '<em><b>SSL Cipher Suite</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>SSL Cipher Suite</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>SSL Cipher Suite</em>' attribute.
	 * @see #setSSLCipherSuite(String)
	 * @see com.ibm.ccl.soa.deploy.mq.MqPackage#getMQTopicConnectionFactory_SSLCipherSuite()
	 * @model dataType="org.eclipse.emf.ecore.xml.type.String"
	 *        extendedMetaData="kind='attribute' name='SSLCipherSuite'"
	 * @generated
	 */
	String getSSLCipherSuite();

	/**
	 * Sets the value of the '{@link com.ibm.ccl.soa.deploy.mq.MQTopicConnectionFactory#getSSLCipherSuite <em>SSL Cipher Suite</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>SSL Cipher Suite</em>' attribute.
	 * @see #getSSLCipherSuite()
	 * @generated
	 */
	void setSSLCipherSuite(String value);

	/**
	 * Returns the value of the '<em><b>SSLCRL</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>SSLCRL</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>SSLCRL</em>' attribute.
	 * @see #setSSLCRL(String)
	 * @see com.ibm.ccl.soa.deploy.mq.MqPackage#getMQTopicConnectionFactory_SSLCRL()
	 * @model dataType="org.eclipse.emf.ecore.xml.type.String"
	 *        extendedMetaData="kind='attribute' name='SSLCRL'"
	 * @generated
	 */
	String getSSLCRL();

	/**
	 * Sets the value of the '{@link com.ibm.ccl.soa.deploy.mq.MQTopicConnectionFactory#getSSLCRL <em>SSLCRL</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>SSLCRL</em>' attribute.
	 * @see #getSSLCRL()
	 * @generated
	 */
	void setSSLCRL(String value);

	/**
	 * Returns the value of the '<em><b>SSL Peer Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>SSL Peer Name</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>SSL Peer Name</em>' attribute.
	 * @see #setSSLPeerName(String)
	 * @see com.ibm.ccl.soa.deploy.mq.MqPackage#getMQTopicConnectionFactory_SSLPeerName()
	 * @model dataType="org.eclipse.emf.ecore.xml.type.String"
	 *        extendedMetaData="kind='attribute' name='SSLPeerName'"
	 * @generated
	 */
	String getSSLPeerName();

	/**
	 * Sets the value of the '{@link com.ibm.ccl.soa.deploy.mq.MQTopicConnectionFactory#getSSLPeerName <em>SSL Peer Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>SSL Peer Name</em>' attribute.
	 * @see #getSSLPeerName()
	 * @generated
	 */
	void setSSLPeerName(String value);

	/**
	 * Returns the value of the '<em><b>Transport Type</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Transport Type</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Transport Type</em>' attribute.
	 * @see #setTransportType(String)
	 * @see com.ibm.ccl.soa.deploy.mq.MqPackage#getMQTopicConnectionFactory_TransportType()
	 * @model dataType="org.eclipse.emf.ecore.xml.type.String"
	 *        extendedMetaData="kind='attribute' name='TransportType'"
	 * @generated
	 */
	String getTransportType();

	/**
	 * Sets the value of the '{@link com.ibm.ccl.soa.deploy.mq.MQTopicConnectionFactory#getTransportType <em>Transport Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Transport Type</em>' attribute.
	 * @see #getTransportType()
	 * @generated
	 */
	void setTransportType(String value);

	/**
	 * Returns the value of the '<em><b>XA Enabled</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>XA Enabled</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>XA Enabled</em>' attribute.
	 * @see #setXAEnabled(String)
	 * @see com.ibm.ccl.soa.deploy.mq.MqPackage#getMQTopicConnectionFactory_XAEnabled()
	 * @model dataType="org.eclipse.emf.ecore.xml.type.String"
	 *        extendedMetaData="kind='attribute' name='XAEnabled'"
	 * @generated
	 */
	String getXAEnabled();

	/**
	 * Sets the value of the '{@link com.ibm.ccl.soa.deploy.mq.MQTopicConnectionFactory#getXAEnabled <em>XA Enabled</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>XA Enabled</em>' attribute.
	 * @see #getXAEnabled()
	 * @generated
	 */
	void setXAEnabled(String value);

} // MQTopicConnectionFactory
