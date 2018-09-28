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
 * A representation of the model object '<em><b>MQ Queue Connection Factory</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link com.ibm.ccl.soa.deploy.mq.MQQueueConnectionFactory#getCategory <em>Category</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.mq.MQQueueConnectionFactory#getCCSID <em>CCSID</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.mq.MQQueueConnectionFactory#getChannel <em>Channel</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.mq.MQQueueConnectionFactory#getClientId <em>Client Id</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.mq.MQQueueConnectionFactory#getComponentManagedAuthenticationAlias <em>Component Managed Authentication Alias</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.mq.MQQueueConnectionFactory#getContainerManagedAuthenticationAlias <em>Container Managed Authentication Alias</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.mq.MQQueueConnectionFactory#getDescription1 <em>Description1</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.mq.MQQueueConnectionFactory#getEnableConnectionPoling <em>Enable Connection Poling</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.mq.MQQueueConnectionFactory#getEnableMessageRetention <em>Enable Message Retention</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.mq.MQQueueConnectionFactory#getEnableReturnMethodDuringShutdown <em>Enable Return Method During Shutdown</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.mq.MQQueueConnectionFactory#getFactoryName <em>Factory Name</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.mq.MQQueueConnectionFactory#getHost <em>Host</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.mq.MQQueueConnectionFactory#getJndiName <em>Jndi Name</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.mq.MQQueueConnectionFactory#getLocalServerAddress <em>Local Server Address</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.mq.MQQueueConnectionFactory#getMappingconfigurationAlias <em>Mappingconfiguration Alias</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.mq.MQQueueConnectionFactory#getMaxConnections <em>Max Connections</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.mq.MQQueueConnectionFactory#getMaxSessions <em>Max Sessions</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.mq.MQQueueConnectionFactory#getMinConnections <em>Min Connections</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.mq.MQQueueConnectionFactory#getMinSessions <em>Min Sessions</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.mq.MQQueueConnectionFactory#getModelQueueDefinition <em>Model Queue Definition</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.mq.MQQueueConnectionFactory#getPollingInterval <em>Polling Interval</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.mq.MQQueueConnectionFactory#getPort <em>Port</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.mq.MQQueueConnectionFactory#getQueuemanager <em>Queuemanager</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.mq.MQQueueConnectionFactory#getRescanInterval <em>Rescan Interval</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.mq.MQQueueConnectionFactory#getSSLCipherSuit <em>SSL Cipher Suit</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.mq.MQQueueConnectionFactory#getSSLCRL <em>SSLCRL</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.mq.MQQueueConnectionFactory#getSSLPeerName <em>SSL Peer Name</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.mq.MQQueueConnectionFactory#getTemporaryQueuePrefix <em>Temporary Queue Prefix</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.mq.MQQueueConnectionFactory#getTransportType <em>Transport Type</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.mq.MQQueueConnectionFactory#getXAEnabled <em>XA Enabled</em>}</li>
 * </ul>
 * </p>
 *
 * @see com.ibm.ccl.soa.deploy.mq.MqPackage#getMQQueueConnectionFactory()
 * @model extendedMetaData="name='MQQueueConnectionFactory' kind='elementOnly'"
 * @generated
 */
public interface MQQueueConnectionFactory extends Capability {
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
	 * @see com.ibm.ccl.soa.deploy.mq.MqPackage#getMQQueueConnectionFactory_Category()
	 * @model dataType="org.eclipse.emf.ecore.xml.type.String"
	 *        extendedMetaData="kind='attribute' name='Category'"
	 * @generated
	 */
	String getCategory();

	/**
	 * Sets the value of the '{@link com.ibm.ccl.soa.deploy.mq.MQQueueConnectionFactory#getCategory <em>Category</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Category</em>' attribute.
	 * @see #getCategory()
	 * @generated
	 */
	void setCategory(String value);

	/**
	 * Returns the value of the '<em><b>CCSID</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>CCSID</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>CCSID</em>' attribute.
	 * @see #setCCSID(String)
	 * @see com.ibm.ccl.soa.deploy.mq.MqPackage#getMQQueueConnectionFactory_CCSID()
	 * @model dataType="org.eclipse.emf.ecore.xml.type.String"
	 *        extendedMetaData="kind='attribute' name='CCSID'"
	 * @generated
	 */
	String getCCSID();

	/**
	 * Sets the value of the '{@link com.ibm.ccl.soa.deploy.mq.MQQueueConnectionFactory#getCCSID <em>CCSID</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>CCSID</em>' attribute.
	 * @see #getCCSID()
	 * @generated
	 */
	void setCCSID(String value);

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
	 * @see com.ibm.ccl.soa.deploy.mq.MqPackage#getMQQueueConnectionFactory_Channel()
	 * @model dataType="org.eclipse.emf.ecore.xml.type.String"
	 *        extendedMetaData="kind='attribute' name='Channel'"
	 * @generated
	 */
	String getChannel();

	/**
	 * Sets the value of the '{@link com.ibm.ccl.soa.deploy.mq.MQQueueConnectionFactory#getChannel <em>Channel</em>}' attribute.
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
	 * @see com.ibm.ccl.soa.deploy.mq.MqPackage#getMQQueueConnectionFactory_ClientId()
	 * @model dataType="org.eclipse.emf.ecore.xml.type.String"
	 *        extendedMetaData="kind='attribute' name='ClientId'"
	 * @generated
	 */
	String getClientId();

	/**
	 * Sets the value of the '{@link com.ibm.ccl.soa.deploy.mq.MQQueueConnectionFactory#getClientId <em>Client Id</em>}' attribute.
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
	 * @see com.ibm.ccl.soa.deploy.mq.MqPackage#getMQQueueConnectionFactory_ComponentManagedAuthenticationAlias()
	 * @model dataType="org.eclipse.emf.ecore.xml.type.String"
	 *        extendedMetaData="kind='attribute' name='ComponentManagedAuthenticationAlias'"
	 * @generated
	 */
	String getComponentManagedAuthenticationAlias();

	/**
	 * Sets the value of the '{@link com.ibm.ccl.soa.deploy.mq.MQQueueConnectionFactory#getComponentManagedAuthenticationAlias <em>Component Managed Authentication Alias</em>}' attribute.
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
	 * @see com.ibm.ccl.soa.deploy.mq.MqPackage#getMQQueueConnectionFactory_ContainerManagedAuthenticationAlias()
	 * @model dataType="org.eclipse.emf.ecore.xml.type.String"
	 *        extendedMetaData="kind='attribute' name='ContainerManagedAuthenticationAlias'"
	 * @generated
	 */
	String getContainerManagedAuthenticationAlias();

	/**
	 * Sets the value of the '{@link com.ibm.ccl.soa.deploy.mq.MQQueueConnectionFactory#getContainerManagedAuthenticationAlias <em>Container Managed Authentication Alias</em>}' attribute.
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
	 * @see com.ibm.ccl.soa.deploy.mq.MqPackage#getMQQueueConnectionFactory_Description1()
	 * @model dataType="org.eclipse.emf.ecore.xml.type.String"
	 *        extendedMetaData="kind='attribute' name='Description'"
	 * @generated
	 */
	String getDescription1();

	/**
	 * Sets the value of the '{@link com.ibm.ccl.soa.deploy.mq.MQQueueConnectionFactory#getDescription1 <em>Description1</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Description1</em>' attribute.
	 * @see #getDescription1()
	 * @generated
	 */
	void setDescription1(String value);

	/**
	 * Returns the value of the '<em><b>Enable Connection Poling</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Enable Connection Poling</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Enable Connection Poling</em>' attribute.
	 * @see #setEnableConnectionPoling(String)
	 * @see com.ibm.ccl.soa.deploy.mq.MqPackage#getMQQueueConnectionFactory_EnableConnectionPoling()
	 * @model dataType="org.eclipse.emf.ecore.xml.type.String"
	 *        extendedMetaData="kind='attribute' name='EnableConnectionPoling'"
	 * @generated
	 */
	String getEnableConnectionPoling();

	/**
	 * Sets the value of the '{@link com.ibm.ccl.soa.deploy.mq.MQQueueConnectionFactory#getEnableConnectionPoling <em>Enable Connection Poling</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Enable Connection Poling</em>' attribute.
	 * @see #getEnableConnectionPoling()
	 * @generated
	 */
	void setEnableConnectionPoling(String value);

	/**
	 * Returns the value of the '<em><b>Enable Message Retention</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Enable Message Retention</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Enable Message Retention</em>' attribute.
	 * @see #setEnableMessageRetention(String)
	 * @see com.ibm.ccl.soa.deploy.mq.MqPackage#getMQQueueConnectionFactory_EnableMessageRetention()
	 * @model dataType="org.eclipse.emf.ecore.xml.type.String"
	 *        extendedMetaData="kind='attribute' name='EnableMessageRetention'"
	 * @generated
	 */
	String getEnableMessageRetention();

	/**
	 * Sets the value of the '{@link com.ibm.ccl.soa.deploy.mq.MQQueueConnectionFactory#getEnableMessageRetention <em>Enable Message Retention</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Enable Message Retention</em>' attribute.
	 * @see #getEnableMessageRetention()
	 * @generated
	 */
	void setEnableMessageRetention(String value);

	/**
	 * Returns the value of the '<em><b>Enable Return Method During Shutdown</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Enable Return Method During Shutdown</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Enable Return Method During Shutdown</em>' attribute.
	 * @see #setEnableReturnMethodDuringShutdown(String)
	 * @see com.ibm.ccl.soa.deploy.mq.MqPackage#getMQQueueConnectionFactory_EnableReturnMethodDuringShutdown()
	 * @model dataType="org.eclipse.emf.ecore.xml.type.String"
	 *        extendedMetaData="kind='attribute' name='EnableReturnMethodDuringShutdown'"
	 * @generated
	 */
	String getEnableReturnMethodDuringShutdown();

	/**
	 * Sets the value of the '{@link com.ibm.ccl.soa.deploy.mq.MQQueueConnectionFactory#getEnableReturnMethodDuringShutdown <em>Enable Return Method During Shutdown</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Enable Return Method During Shutdown</em>' attribute.
	 * @see #getEnableReturnMethodDuringShutdown()
	 * @generated
	 */
	void setEnableReturnMethodDuringShutdown(String value);

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
	 * @see com.ibm.ccl.soa.deploy.mq.MqPackage#getMQQueueConnectionFactory_FactoryName()
	 * @model dataType="org.eclipse.emf.ecore.xml.type.String"
	 *        extendedMetaData="kind='attribute' name='factoryName'"
	 * @generated
	 */
	String getFactoryName();

	/**
	 * Sets the value of the '{@link com.ibm.ccl.soa.deploy.mq.MQQueueConnectionFactory#getFactoryName <em>Factory Name</em>}' attribute.
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
	 * @see com.ibm.ccl.soa.deploy.mq.MqPackage#getMQQueueConnectionFactory_Host()
	 * @model dataType="org.eclipse.emf.ecore.xml.type.String"
	 *        extendedMetaData="kind='attribute' name='Host'"
	 * @generated
	 */
	String getHost();

	/**
	 * Sets the value of the '{@link com.ibm.ccl.soa.deploy.mq.MQQueueConnectionFactory#getHost <em>Host</em>}' attribute.
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
	 * @see com.ibm.ccl.soa.deploy.mq.MqPackage#getMQQueueConnectionFactory_JndiName()
	 * @model dataType="org.eclipse.emf.ecore.xml.type.String"
	 *        extendedMetaData="kind='attribute' name='jndiName'"
	 * @generated
	 */
	String getJndiName();

	/**
	 * Sets the value of the '{@link com.ibm.ccl.soa.deploy.mq.MQQueueConnectionFactory#getJndiName <em>Jndi Name</em>}' attribute.
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
	 * @see com.ibm.ccl.soa.deploy.mq.MqPackage#getMQQueueConnectionFactory_LocalServerAddress()
	 * @model dataType="org.eclipse.emf.ecore.xml.type.String"
	 *        extendedMetaData="kind='attribute' name='LocalServerAddress'"
	 * @generated
	 */
	String getLocalServerAddress();

	/**
	 * Sets the value of the '{@link com.ibm.ccl.soa.deploy.mq.MQQueueConnectionFactory#getLocalServerAddress <em>Local Server Address</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Local Server Address</em>' attribute.
	 * @see #getLocalServerAddress()
	 * @generated
	 */
	void setLocalServerAddress(String value);

	/**
	 * Returns the value of the '<em><b>Mappingconfiguration Alias</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Mappingconfiguration Alias</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Mappingconfiguration Alias</em>' attribute.
	 * @see #setMappingconfigurationAlias(String)
	 * @see com.ibm.ccl.soa.deploy.mq.MqPackage#getMQQueueConnectionFactory_MappingconfigurationAlias()
	 * @model dataType="org.eclipse.emf.ecore.xml.type.String"
	 *        extendedMetaData="kind='attribute' name='MappingconfigurationAlias'"
	 * @generated
	 */
	String getMappingconfigurationAlias();

	/**
	 * Sets the value of the '{@link com.ibm.ccl.soa.deploy.mq.MQQueueConnectionFactory#getMappingconfigurationAlias <em>Mappingconfiguration Alias</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Mappingconfiguration Alias</em>' attribute.
	 * @see #getMappingconfigurationAlias()
	 * @generated
	 */
	void setMappingconfigurationAlias(String value);

	/**
	 * Returns the value of the '<em><b>Max Connections</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Max Connections</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Max Connections</em>' attribute.
	 * @see #setMaxConnections(String)
	 * @see com.ibm.ccl.soa.deploy.mq.MqPackage#getMQQueueConnectionFactory_MaxConnections()
	 * @model dataType="org.eclipse.emf.ecore.xml.type.String"
	 *        extendedMetaData="kind='attribute' name='MaxConnections'"
	 * @generated
	 */
	String getMaxConnections();

	/**
	 * Sets the value of the '{@link com.ibm.ccl.soa.deploy.mq.MQQueueConnectionFactory#getMaxConnections <em>Max Connections</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Max Connections</em>' attribute.
	 * @see #getMaxConnections()
	 * @generated
	 */
	void setMaxConnections(String value);

	/**
	 * Returns the value of the '<em><b>Max Sessions</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Max Sessions</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Max Sessions</em>' attribute.
	 * @see #setMaxSessions(String)
	 * @see com.ibm.ccl.soa.deploy.mq.MqPackage#getMQQueueConnectionFactory_MaxSessions()
	 * @model dataType="org.eclipse.emf.ecore.xml.type.String"
	 *        extendedMetaData="kind='attribute' name='MaxSessions'"
	 * @generated
	 */
	String getMaxSessions();

	/**
	 * Sets the value of the '{@link com.ibm.ccl.soa.deploy.mq.MQQueueConnectionFactory#getMaxSessions <em>Max Sessions</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Max Sessions</em>' attribute.
	 * @see #getMaxSessions()
	 * @generated
	 */
	void setMaxSessions(String value);

	/**
	 * Returns the value of the '<em><b>Min Connections</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Min Connections</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Min Connections</em>' attribute.
	 * @see #setMinConnections(String)
	 * @see com.ibm.ccl.soa.deploy.mq.MqPackage#getMQQueueConnectionFactory_MinConnections()
	 * @model dataType="org.eclipse.emf.ecore.xml.type.String"
	 *        extendedMetaData="kind='attribute' name='MinConnections'"
	 * @generated
	 */
	String getMinConnections();

	/**
	 * Sets the value of the '{@link com.ibm.ccl.soa.deploy.mq.MQQueueConnectionFactory#getMinConnections <em>Min Connections</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Min Connections</em>' attribute.
	 * @see #getMinConnections()
	 * @generated
	 */
	void setMinConnections(String value);

	/**
	 * Returns the value of the '<em><b>Min Sessions</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Min Sessions</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Min Sessions</em>' attribute.
	 * @see #setMinSessions(String)
	 * @see com.ibm.ccl.soa.deploy.mq.MqPackage#getMQQueueConnectionFactory_MinSessions()
	 * @model dataType="org.eclipse.emf.ecore.xml.type.String"
	 *        extendedMetaData="kind='attribute' name='MinSessions'"
	 * @generated
	 */
	String getMinSessions();

	/**
	 * Sets the value of the '{@link com.ibm.ccl.soa.deploy.mq.MQQueueConnectionFactory#getMinSessions <em>Min Sessions</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Min Sessions</em>' attribute.
	 * @see #getMinSessions()
	 * @generated
	 */
	void setMinSessions(String value);

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
	 * @see com.ibm.ccl.soa.deploy.mq.MqPackage#getMQQueueConnectionFactory_ModelQueueDefinition()
	 * @model dataType="org.eclipse.emf.ecore.xml.type.String"
	 *        extendedMetaData="kind='attribute' name='ModelQueueDefinition'"
	 * @generated
	 */
	String getModelQueueDefinition();

	/**
	 * Sets the value of the '{@link com.ibm.ccl.soa.deploy.mq.MQQueueConnectionFactory#getModelQueueDefinition <em>Model Queue Definition</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Model Queue Definition</em>' attribute.
	 * @see #getModelQueueDefinition()
	 * @generated
	 */
	void setModelQueueDefinition(String value);

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
	 * @see com.ibm.ccl.soa.deploy.mq.MqPackage#getMQQueueConnectionFactory_PollingInterval()
	 * @model dataType="org.eclipse.emf.ecore.xml.type.String"
	 *        extendedMetaData="kind='attribute' name='PollingInterval'"
	 * @generated
	 */
	String getPollingInterval();

	/**
	 * Sets the value of the '{@link com.ibm.ccl.soa.deploy.mq.MQQueueConnectionFactory#getPollingInterval <em>Polling Interval</em>}' attribute.
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
	 * @see com.ibm.ccl.soa.deploy.mq.MqPackage#getMQQueueConnectionFactory_Port()
	 * @model dataType="org.eclipse.emf.ecore.xml.type.String"
	 *        extendedMetaData="kind='attribute' name='Port'"
	 * @generated
	 */
	String getPort();

	/**
	 * Sets the value of the '{@link com.ibm.ccl.soa.deploy.mq.MQQueueConnectionFactory#getPort <em>Port</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Port</em>' attribute.
	 * @see #getPort()
	 * @generated
	 */
	void setPort(String value);

	/**
	 * Returns the value of the '<em><b>Queuemanager</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Queuemanager</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Queuemanager</em>' attribute.
	 * @see #setQueuemanager(String)
	 * @see com.ibm.ccl.soa.deploy.mq.MqPackage#getMQQueueConnectionFactory_Queuemanager()
	 * @model dataType="org.eclipse.emf.ecore.xml.type.String"
	 *        extendedMetaData="kind='attribute' name='Queuemanager'"
	 * @generated
	 */
	String getQueuemanager();

	/**
	 * Sets the value of the '{@link com.ibm.ccl.soa.deploy.mq.MQQueueConnectionFactory#getQueuemanager <em>Queuemanager</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Queuemanager</em>' attribute.
	 * @see #getQueuemanager()
	 * @generated
	 */
	void setQueuemanager(String value);

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
	 * @see com.ibm.ccl.soa.deploy.mq.MqPackage#getMQQueueConnectionFactory_RescanInterval()
	 * @model dataType="org.eclipse.emf.ecore.xml.type.String"
	 *        extendedMetaData="kind='attribute' name='RescanInterval'"
	 * @generated
	 */
	String getRescanInterval();

	/**
	 * Sets the value of the '{@link com.ibm.ccl.soa.deploy.mq.MQQueueConnectionFactory#getRescanInterval <em>Rescan Interval</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Rescan Interval</em>' attribute.
	 * @see #getRescanInterval()
	 * @generated
	 */
	void setRescanInterval(String value);

	/**
	 * Returns the value of the '<em><b>SSL Cipher Suit</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>SSL Cipher Suit</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>SSL Cipher Suit</em>' attribute.
	 * @see #setSSLCipherSuit(String)
	 * @see com.ibm.ccl.soa.deploy.mq.MqPackage#getMQQueueConnectionFactory_SSLCipherSuit()
	 * @model dataType="org.eclipse.emf.ecore.xml.type.String"
	 *        extendedMetaData="kind='attribute' name='SSLCipherSuit'"
	 * @generated
	 */
	String getSSLCipherSuit();

	/**
	 * Sets the value of the '{@link com.ibm.ccl.soa.deploy.mq.MQQueueConnectionFactory#getSSLCipherSuit <em>SSL Cipher Suit</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>SSL Cipher Suit</em>' attribute.
	 * @see #getSSLCipherSuit()
	 * @generated
	 */
	void setSSLCipherSuit(String value);

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
	 * @see com.ibm.ccl.soa.deploy.mq.MqPackage#getMQQueueConnectionFactory_SSLCRL()
	 * @model dataType="org.eclipse.emf.ecore.xml.type.String"
	 *        extendedMetaData="kind='attribute' name='SSLCRL'"
	 * @generated
	 */
	String getSSLCRL();

	/**
	 * Sets the value of the '{@link com.ibm.ccl.soa.deploy.mq.MQQueueConnectionFactory#getSSLCRL <em>SSLCRL</em>}' attribute.
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
	 * @see com.ibm.ccl.soa.deploy.mq.MqPackage#getMQQueueConnectionFactory_SSLPeerName()
	 * @model dataType="org.eclipse.emf.ecore.xml.type.String"
	 *        extendedMetaData="kind='attribute' name='SSLPeerName'"
	 * @generated
	 */
	String getSSLPeerName();

	/**
	 * Sets the value of the '{@link com.ibm.ccl.soa.deploy.mq.MQQueueConnectionFactory#getSSLPeerName <em>SSL Peer Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>SSL Peer Name</em>' attribute.
	 * @see #getSSLPeerName()
	 * @generated
	 */
	void setSSLPeerName(String value);

	/**
	 * Returns the value of the '<em><b>Temporary Queue Prefix</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Temporary Queue Prefix</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Temporary Queue Prefix</em>' attribute.
	 * @see #setTemporaryQueuePrefix(String)
	 * @see com.ibm.ccl.soa.deploy.mq.MqPackage#getMQQueueConnectionFactory_TemporaryQueuePrefix()
	 * @model dataType="org.eclipse.emf.ecore.xml.type.String"
	 *        extendedMetaData="kind='attribute' name='TemporaryQueuePrefix'"
	 * @generated
	 */
	String getTemporaryQueuePrefix();

	/**
	 * Sets the value of the '{@link com.ibm.ccl.soa.deploy.mq.MQQueueConnectionFactory#getTemporaryQueuePrefix <em>Temporary Queue Prefix</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Temporary Queue Prefix</em>' attribute.
	 * @see #getTemporaryQueuePrefix()
	 * @generated
	 */
	void setTemporaryQueuePrefix(String value);

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
	 * @see com.ibm.ccl.soa.deploy.mq.MqPackage#getMQQueueConnectionFactory_TransportType()
	 * @model dataType="org.eclipse.emf.ecore.xml.type.String"
	 *        extendedMetaData="kind='attribute' name='TransportType'"
	 * @generated
	 */
	String getTransportType();

	/**
	 * Sets the value of the '{@link com.ibm.ccl.soa.deploy.mq.MQQueueConnectionFactory#getTransportType <em>Transport Type</em>}' attribute.
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
	 * @see com.ibm.ccl.soa.deploy.mq.MqPackage#getMQQueueConnectionFactory_XAEnabled()
	 * @model dataType="org.eclipse.emf.ecore.xml.type.String"
	 *        extendedMetaData="kind='attribute' name='XAEnabled'"
	 * @generated
	 */
	String getXAEnabled();

	/**
	 * Sets the value of the '{@link com.ibm.ccl.soa.deploy.mq.MQQueueConnectionFactory#getXAEnabled <em>XA Enabled</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>XA Enabled</em>' attribute.
	 * @see #getXAEnabled()
	 * @generated
	 */
	void setXAEnabled(String value);

} // MQQueueConnectionFactory
