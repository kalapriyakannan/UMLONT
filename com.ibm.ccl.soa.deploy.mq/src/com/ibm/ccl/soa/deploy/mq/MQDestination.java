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
 * A representation of the model object '<em><b>MQ Destination</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link com.ibm.ccl.soa.deploy.mq.MQDestination#getBaseQueueManagerName <em>Base Queue Manager Name</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.mq.MQDestination#getBaseQueueName <em>Base Queue Name</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.mq.MQDestination#getCategory <em>Category</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.mq.MQDestination#getCCSID <em>CCSID</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.mq.MQDestination#getDecimalEncoding <em>Decimal Encoding</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.mq.MQDestination#getDescription1 <em>Description1</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.mq.MQDestination#getDestinationName <em>Destination Name</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.mq.MQDestination#getExpiry <em>Expiry</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.mq.MQDestination#getFloatingPointEncoding <em>Floating Point Encoding</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.mq.MQDestination#getIntegerEncoding <em>Integer Encoding</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.mq.MQDestination#getJndiName <em>Jndi Name</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.mq.MQDestination#getPassword <em>Password</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.mq.MQDestination#getPersitence <em>Persitence</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.mq.MQDestination#getPriority <em>Priority</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.mq.MQDestination#getQueueManagerHost <em>Queue Manager Host</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.mq.MQDestination#getQueueManagerPort <em>Queue Manager Port</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.mq.MQDestination#getServerConnectionChannelName <em>Server Connection Channel Name</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.mq.MQDestination#getSpecifiedExpiry <em>Specified Expiry</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.mq.MQDestination#getSpecifiedPriority <em>Specified Priority</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.mq.MQDestination#getTargetClient <em>Target Client</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.mq.MQDestination#getUseNativeEncoding <em>Use Native Encoding</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.mq.MQDestination#getUserID <em>User ID</em>}</li>
 * </ul>
 * </p>
 *
 * @see com.ibm.ccl.soa.deploy.mq.MqPackage#getMQDestination()
 * @model extendedMetaData="name='MQDestination' kind='elementOnly'"
 * @generated
 */
public interface MQDestination extends Capability {
	/**
	 * Returns the value of the '<em><b>Base Queue Manager Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Base Queue Manager Name</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Base Queue Manager Name</em>' attribute.
	 * @see #setBaseQueueManagerName(String)
	 * @see com.ibm.ccl.soa.deploy.mq.MqPackage#getMQDestination_BaseQueueManagerName()
	 * @model dataType="org.eclipse.emf.ecore.xml.type.String"
	 *        extendedMetaData="kind='attribute' name='BaseQueueManagerName'"
	 * @generated
	 */
	String getBaseQueueManagerName();

	/**
	 * Sets the value of the '{@link com.ibm.ccl.soa.deploy.mq.MQDestination#getBaseQueueManagerName <em>Base Queue Manager Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Base Queue Manager Name</em>' attribute.
	 * @see #getBaseQueueManagerName()
	 * @generated
	 */
	void setBaseQueueManagerName(String value);

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
	 * @see com.ibm.ccl.soa.deploy.mq.MqPackage#getMQDestination_BaseQueueName()
	 * @model dataType="org.eclipse.emf.ecore.xml.type.String"
	 *        extendedMetaData="kind='attribute' name='BaseQueueName'"
	 * @generated
	 */
	String getBaseQueueName();

	/**
	 * Sets the value of the '{@link com.ibm.ccl.soa.deploy.mq.MQDestination#getBaseQueueName <em>Base Queue Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Base Queue Name</em>' attribute.
	 * @see #getBaseQueueName()
	 * @generated
	 */
	void setBaseQueueName(String value);

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
	 * @see com.ibm.ccl.soa.deploy.mq.MqPackage#getMQDestination_Category()
	 * @model dataType="org.eclipse.emf.ecore.xml.type.String"
	 *        extendedMetaData="kind='attribute' name='Category'"
	 * @generated
	 */
	String getCategory();

	/**
	 * Sets the value of the '{@link com.ibm.ccl.soa.deploy.mq.MQDestination#getCategory <em>Category</em>}' attribute.
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
	 * @see com.ibm.ccl.soa.deploy.mq.MqPackage#getMQDestination_CCSID()
	 * @model dataType="org.eclipse.emf.ecore.xml.type.String"
	 *        extendedMetaData="kind='attribute' name='CCSID'"
	 * @generated
	 */
	String getCCSID();

	/**
	 * Sets the value of the '{@link com.ibm.ccl.soa.deploy.mq.MQDestination#getCCSID <em>CCSID</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>CCSID</em>' attribute.
	 * @see #getCCSID()
	 * @generated
	 */
	void setCCSID(String value);

	/**
	 * Returns the value of the '<em><b>Decimal Encoding</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Decimal Encoding</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Decimal Encoding</em>' attribute.
	 * @see #setDecimalEncoding(String)
	 * @see com.ibm.ccl.soa.deploy.mq.MqPackage#getMQDestination_DecimalEncoding()
	 * @model dataType="org.eclipse.emf.ecore.xml.type.String"
	 *        extendedMetaData="kind='attribute' name='DecimalEncoding'"
	 * @generated
	 */
	String getDecimalEncoding();

	/**
	 * Sets the value of the '{@link com.ibm.ccl.soa.deploy.mq.MQDestination#getDecimalEncoding <em>Decimal Encoding</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Decimal Encoding</em>' attribute.
	 * @see #getDecimalEncoding()
	 * @generated
	 */
	void setDecimalEncoding(String value);

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
	 * @see com.ibm.ccl.soa.deploy.mq.MqPackage#getMQDestination_Description1()
	 * @model dataType="org.eclipse.emf.ecore.xml.type.String"
	 *        extendedMetaData="kind='attribute' name='Description'"
	 * @generated
	 */
	String getDescription1();

	/**
	 * Sets the value of the '{@link com.ibm.ccl.soa.deploy.mq.MQDestination#getDescription1 <em>Description1</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Description1</em>' attribute.
	 * @see #getDescription1()
	 * @generated
	 */
	void setDescription1(String value);

	/**
	 * Returns the value of the '<em><b>Destination Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Destination Name</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Destination Name</em>' attribute.
	 * @see #setDestinationName(String)
	 * @see com.ibm.ccl.soa.deploy.mq.MqPackage#getMQDestination_DestinationName()
	 * @model dataType="org.eclipse.emf.ecore.xml.type.String"
	 *        extendedMetaData="kind='attribute' name='destinationName'"
	 * @generated
	 */
	String getDestinationName();

	/**
	 * Sets the value of the '{@link com.ibm.ccl.soa.deploy.mq.MQDestination#getDestinationName <em>Destination Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Destination Name</em>' attribute.
	 * @see #getDestinationName()
	 * @generated
	 */
	void setDestinationName(String value);

	/**
	 * Returns the value of the '<em><b>Expiry</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Expiry</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Expiry</em>' attribute.
	 * @see #setExpiry(String)
	 * @see com.ibm.ccl.soa.deploy.mq.MqPackage#getMQDestination_Expiry()
	 * @model dataType="org.eclipse.emf.ecore.xml.type.String"
	 *        extendedMetaData="kind='attribute' name='Expiry'"
	 * @generated
	 */
	String getExpiry();

	/**
	 * Sets the value of the '{@link com.ibm.ccl.soa.deploy.mq.MQDestination#getExpiry <em>Expiry</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Expiry</em>' attribute.
	 * @see #getExpiry()
	 * @generated
	 */
	void setExpiry(String value);

	/**
	 * Returns the value of the '<em><b>Floating Point Encoding</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Floating Point Encoding</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Floating Point Encoding</em>' attribute.
	 * @see #setFloatingPointEncoding(String)
	 * @see com.ibm.ccl.soa.deploy.mq.MqPackage#getMQDestination_FloatingPointEncoding()
	 * @model dataType="org.eclipse.emf.ecore.xml.type.String"
	 *        extendedMetaData="kind='attribute' name='FloatingPointEncoding'"
	 * @generated
	 */
	String getFloatingPointEncoding();

	/**
	 * Sets the value of the '{@link com.ibm.ccl.soa.deploy.mq.MQDestination#getFloatingPointEncoding <em>Floating Point Encoding</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Floating Point Encoding</em>' attribute.
	 * @see #getFloatingPointEncoding()
	 * @generated
	 */
	void setFloatingPointEncoding(String value);

	/**
	 * Returns the value of the '<em><b>Integer Encoding</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Integer Encoding</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Integer Encoding</em>' attribute.
	 * @see #setIntegerEncoding(String)
	 * @see com.ibm.ccl.soa.deploy.mq.MqPackage#getMQDestination_IntegerEncoding()
	 * @model dataType="org.eclipse.emf.ecore.xml.type.String"
	 *        extendedMetaData="kind='attribute' name='IntegerEncoding'"
	 * @generated
	 */
	String getIntegerEncoding();

	/**
	 * Sets the value of the '{@link com.ibm.ccl.soa.deploy.mq.MQDestination#getIntegerEncoding <em>Integer Encoding</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Integer Encoding</em>' attribute.
	 * @see #getIntegerEncoding()
	 * @generated
	 */
	void setIntegerEncoding(String value);

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
	 * @see com.ibm.ccl.soa.deploy.mq.MqPackage#getMQDestination_JndiName()
	 * @model dataType="org.eclipse.emf.ecore.xml.type.String"
	 *        extendedMetaData="kind='attribute' name='jndiName'"
	 * @generated
	 */
	String getJndiName();

	/**
	 * Sets the value of the '{@link com.ibm.ccl.soa.deploy.mq.MQDestination#getJndiName <em>Jndi Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Jndi Name</em>' attribute.
	 * @see #getJndiName()
	 * @generated
	 */
	void setJndiName(String value);

	/**
	 * Returns the value of the '<em><b>Password</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Password</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Password</em>' attribute.
	 * @see #setPassword(String)
	 * @see com.ibm.ccl.soa.deploy.mq.MqPackage#getMQDestination_Password()
	 * @model dataType="org.eclipse.emf.ecore.xml.type.String"
	 *        extendedMetaData="kind='attribute' name='Password'"
	 * @generated
	 */
	String getPassword();

	/**
	 * Sets the value of the '{@link com.ibm.ccl.soa.deploy.mq.MQDestination#getPassword <em>Password</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Password</em>' attribute.
	 * @see #getPassword()
	 * @generated
	 */
	void setPassword(String value);

	/**
	 * Returns the value of the '<em><b>Persitence</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Persitence</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Persitence</em>' attribute.
	 * @see #setPersitence(String)
	 * @see com.ibm.ccl.soa.deploy.mq.MqPackage#getMQDestination_Persitence()
	 * @model dataType="org.eclipse.emf.ecore.xml.type.String"
	 *        extendedMetaData="kind='attribute' name='Persitence'"
	 * @generated
	 */
	String getPersitence();

	/**
	 * Sets the value of the '{@link com.ibm.ccl.soa.deploy.mq.MQDestination#getPersitence <em>Persitence</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Persitence</em>' attribute.
	 * @see #getPersitence()
	 * @generated
	 */
	void setPersitence(String value);

	/**
	 * Returns the value of the '<em><b>Priority</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Priority</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Priority</em>' attribute.
	 * @see #setPriority(String)
	 * @see com.ibm.ccl.soa.deploy.mq.MqPackage#getMQDestination_Priority()
	 * @model dataType="org.eclipse.emf.ecore.xml.type.String"
	 *        extendedMetaData="kind='attribute' name='Priority'"
	 * @generated
	 */
	String getPriority();

	/**
	 * Sets the value of the '{@link com.ibm.ccl.soa.deploy.mq.MQDestination#getPriority <em>Priority</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Priority</em>' attribute.
	 * @see #getPriority()
	 * @generated
	 */
	void setPriority(String value);

	/**
	 * Returns the value of the '<em><b>Queue Manager Host</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Queue Manager Host</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Queue Manager Host</em>' attribute.
	 * @see #setQueueManagerHost(String)
	 * @see com.ibm.ccl.soa.deploy.mq.MqPackage#getMQDestination_QueueManagerHost()
	 * @model dataType="org.eclipse.emf.ecore.xml.type.String"
	 *        extendedMetaData="kind='attribute' name='QueueManagerHost'"
	 * @generated
	 */
	String getQueueManagerHost();

	/**
	 * Sets the value of the '{@link com.ibm.ccl.soa.deploy.mq.MQDestination#getQueueManagerHost <em>Queue Manager Host</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Queue Manager Host</em>' attribute.
	 * @see #getQueueManagerHost()
	 * @generated
	 */
	void setQueueManagerHost(String value);

	/**
	 * Returns the value of the '<em><b>Queue Manager Port</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Queue Manager Port</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Queue Manager Port</em>' attribute.
	 * @see #setQueueManagerPort(String)
	 * @see com.ibm.ccl.soa.deploy.mq.MqPackage#getMQDestination_QueueManagerPort()
	 * @model dataType="org.eclipse.emf.ecore.xml.type.String"
	 *        extendedMetaData="kind='attribute' name='QueueManagerPort'"
	 * @generated
	 */
	String getQueueManagerPort();

	/**
	 * Sets the value of the '{@link com.ibm.ccl.soa.deploy.mq.MQDestination#getQueueManagerPort <em>Queue Manager Port</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Queue Manager Port</em>' attribute.
	 * @see #getQueueManagerPort()
	 * @generated
	 */
	void setQueueManagerPort(String value);

	/**
	 * Returns the value of the '<em><b>Server Connection Channel Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Server Connection Channel Name</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Server Connection Channel Name</em>' attribute.
	 * @see #setServerConnectionChannelName(String)
	 * @see com.ibm.ccl.soa.deploy.mq.MqPackage#getMQDestination_ServerConnectionChannelName()
	 * @model dataType="org.eclipse.emf.ecore.xml.type.String"
	 *        extendedMetaData="kind='attribute' name='ServerConnectionChannelName'"
	 * @generated
	 */
	String getServerConnectionChannelName();

	/**
	 * Sets the value of the '{@link com.ibm.ccl.soa.deploy.mq.MQDestination#getServerConnectionChannelName <em>Server Connection Channel Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Server Connection Channel Name</em>' attribute.
	 * @see #getServerConnectionChannelName()
	 * @generated
	 */
	void setServerConnectionChannelName(String value);

	/**
	 * Returns the value of the '<em><b>Specified Expiry</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Specified Expiry</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Specified Expiry</em>' attribute.
	 * @see #setSpecifiedExpiry(String)
	 * @see com.ibm.ccl.soa.deploy.mq.MqPackage#getMQDestination_SpecifiedExpiry()
	 * @model dataType="org.eclipse.emf.ecore.xml.type.String"
	 *        extendedMetaData="kind='attribute' name='SpecifiedExpiry'"
	 * @generated
	 */
	String getSpecifiedExpiry();

	/**
	 * Sets the value of the '{@link com.ibm.ccl.soa.deploy.mq.MQDestination#getSpecifiedExpiry <em>Specified Expiry</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Specified Expiry</em>' attribute.
	 * @see #getSpecifiedExpiry()
	 * @generated
	 */
	void setSpecifiedExpiry(String value);

	/**
	 * Returns the value of the '<em><b>Specified Priority</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Specified Priority</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Specified Priority</em>' attribute.
	 * @see #setSpecifiedPriority(String)
	 * @see com.ibm.ccl.soa.deploy.mq.MqPackage#getMQDestination_SpecifiedPriority()
	 * @model dataType="org.eclipse.emf.ecore.xml.type.String"
	 *        extendedMetaData="kind='attribute' name='SpecifiedPriority'"
	 * @generated
	 */
	String getSpecifiedPriority();

	/**
	 * Sets the value of the '{@link com.ibm.ccl.soa.deploy.mq.MQDestination#getSpecifiedPriority <em>Specified Priority</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Specified Priority</em>' attribute.
	 * @see #getSpecifiedPriority()
	 * @generated
	 */
	void setSpecifiedPriority(String value);

	/**
	 * Returns the value of the '<em><b>Target Client</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Target Client</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Target Client</em>' attribute.
	 * @see #setTargetClient(String)
	 * @see com.ibm.ccl.soa.deploy.mq.MqPackage#getMQDestination_TargetClient()
	 * @model dataType="org.eclipse.emf.ecore.xml.type.String"
	 *        extendedMetaData="kind='attribute' name='TargetClient'"
	 * @generated
	 */
	String getTargetClient();

	/**
	 * Sets the value of the '{@link com.ibm.ccl.soa.deploy.mq.MQDestination#getTargetClient <em>Target Client</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Target Client</em>' attribute.
	 * @see #getTargetClient()
	 * @generated
	 */
	void setTargetClient(String value);

	/**
	 * Returns the value of the '<em><b>Use Native Encoding</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Use Native Encoding</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Use Native Encoding</em>' attribute.
	 * @see #setUseNativeEncoding(String)
	 * @see com.ibm.ccl.soa.deploy.mq.MqPackage#getMQDestination_UseNativeEncoding()
	 * @model dataType="org.eclipse.emf.ecore.xml.type.String"
	 *        extendedMetaData="kind='attribute' name='UseNativeEncoding'"
	 * @generated
	 */
	String getUseNativeEncoding();

	/**
	 * Sets the value of the '{@link com.ibm.ccl.soa.deploy.mq.MQDestination#getUseNativeEncoding <em>Use Native Encoding</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Use Native Encoding</em>' attribute.
	 * @see #getUseNativeEncoding()
	 * @generated
	 */
	void setUseNativeEncoding(String value);

	/**
	 * Returns the value of the '<em><b>User ID</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>User ID</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>User ID</em>' attribute.
	 * @see #setUserID(String)
	 * @see com.ibm.ccl.soa.deploy.mq.MqPackage#getMQDestination_UserID()
	 * @model dataType="org.eclipse.emf.ecore.xml.type.String"
	 *        extendedMetaData="kind='attribute' name='UserID'"
	 * @generated
	 */
	String getUserID();

	/**
	 * Sets the value of the '{@link com.ibm.ccl.soa.deploy.mq.MQDestination#getUserID <em>User ID</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>User ID</em>' attribute.
	 * @see #getUserID()
	 * @generated
	 */
	void setUserID(String value);

} // MQDestination
