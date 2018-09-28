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
 * A representation of the model object '<em><b>MQ Topic Destination</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link com.ibm.ccl.soa.deploy.mq.MQTopicDestination#getBaseTopicName <em>Base Topic Name</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.mq.MQTopicDestination#getBrokerCCDurableSubscriptionQueue <em>Broker CC Durable Subscription Queue</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.mq.MQTopicDestination#getBrokerDurableSubscriptionQueue <em>Broker Durable Subscription Queue</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.mq.MQTopicDestination#getCategory <em>Category</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.mq.MQTopicDestination#getDecimalEncoding <em>Decimal Encoding</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.mq.MQTopicDestination#getDescription1 <em>Description1</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.mq.MQTopicDestination#getDestinationName <em>Destination Name</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.mq.MQTopicDestination#getEnableMulticastTransport <em>Enable Multicast Transport</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.mq.MQTopicDestination#getExpiry <em>Expiry</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.mq.MQTopicDestination#getFloatingPointEncoding <em>Floating Point Encoding</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.mq.MQTopicDestination#getIntegerEncoding <em>Integer Encoding</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.mq.MQTopicDestination#getJndiName <em>Jndi Name</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.mq.MQTopicDestination#getPersitence <em>Persitence</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.mq.MQTopicDestination#getPriority <em>Priority</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.mq.MQTopicDestination#getSpecifiedExpiry <em>Specified Expiry</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.mq.MQTopicDestination#getSpecifiedPriority <em>Specified Priority</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.mq.MQTopicDestination#getTargetClient <em>Target Client</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.mq.MQTopicDestination#getUseNativeEncoding <em>Use Native Encoding</em>}</li>
 * </ul>
 * </p>
 *
 * @see com.ibm.ccl.soa.deploy.mq.MqPackage#getMQTopicDestination()
 * @model extendedMetaData="name='MQTopicDestination' kind='elementOnly'"
 * @generated
 */
public interface MQTopicDestination extends Capability {

	/**
	 * Returns the value of the '<em><b>Base Topic Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Base Topic Name</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Base Topic Name</em>' attribute.
	 * @see #setBaseTopicName(String)
	 * @see com.ibm.ccl.soa.deploy.mq.MqPackage#getMQTopicDestination_BaseTopicName()
	 * @model dataType="org.eclipse.emf.ecore.xml.type.String"
	 *        extendedMetaData="kind='attribute' name='BaseTopicName'"
	 * @generated
	 */
	String getBaseTopicName();

	/**
	 * Sets the value of the '{@link com.ibm.ccl.soa.deploy.mq.MQTopicDestination#getBaseTopicName <em>Base Topic Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Base Topic Name</em>' attribute.
	 * @see #getBaseTopicName()
	 * @generated
	 */
	void setBaseTopicName(String value);

	/**
	 * Returns the value of the '<em><b>Broker CC Durable Subscription Queue</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Broker CC Durable Subscription Queue</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Broker CC Durable Subscription Queue</em>' attribute.
	 * @see #setBrokerCCDurableSubscriptionQueue(String)
	 * @see com.ibm.ccl.soa.deploy.mq.MqPackage#getMQTopicDestination_BrokerCCDurableSubscriptionQueue()
	 * @model dataType="org.eclipse.emf.ecore.xml.type.String"
	 *        extendedMetaData="kind='attribute' name='BrokerCCDurableSubscriptionQueue'"
	 * @generated
	 */
	String getBrokerCCDurableSubscriptionQueue();

	/**
	 * Sets the value of the '{@link com.ibm.ccl.soa.deploy.mq.MQTopicDestination#getBrokerCCDurableSubscriptionQueue <em>Broker CC Durable Subscription Queue</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Broker CC Durable Subscription Queue</em>' attribute.
	 * @see #getBrokerCCDurableSubscriptionQueue()
	 * @generated
	 */
	void setBrokerCCDurableSubscriptionQueue(String value);

	/**
	 * Returns the value of the '<em><b>Broker Durable Subscription Queue</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Broker Durable Subscription Queue</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Broker Durable Subscription Queue</em>' attribute.
	 * @see #setBrokerDurableSubscriptionQueue(String)
	 * @see com.ibm.ccl.soa.deploy.mq.MqPackage#getMQTopicDestination_BrokerDurableSubscriptionQueue()
	 * @model dataType="org.eclipse.emf.ecore.xml.type.String"
	 *        extendedMetaData="kind='attribute' name='BrokerDurableSubscriptionQueue'"
	 * @generated
	 */
	String getBrokerDurableSubscriptionQueue();

	/**
	 * Sets the value of the '{@link com.ibm.ccl.soa.deploy.mq.MQTopicDestination#getBrokerDurableSubscriptionQueue <em>Broker Durable Subscription Queue</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Broker Durable Subscription Queue</em>' attribute.
	 * @see #getBrokerDurableSubscriptionQueue()
	 * @generated
	 */
	void setBrokerDurableSubscriptionQueue(String value);

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
	 * @see com.ibm.ccl.soa.deploy.mq.MqPackage#getMQTopicDestination_Category()
	 * @model dataType="org.eclipse.emf.ecore.xml.type.String"
	 *        extendedMetaData="kind='attribute' name='Category'"
	 * @generated
	 */
	String getCategory();

	/**
	 * Sets the value of the '{@link com.ibm.ccl.soa.deploy.mq.MQTopicDestination#getCategory <em>Category</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Category</em>' attribute.
	 * @see #getCategory()
	 * @generated
	 */
	void setCategory(String value);

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
	 * @see com.ibm.ccl.soa.deploy.mq.MqPackage#getMQTopicDestination_DecimalEncoding()
	 * @model dataType="org.eclipse.emf.ecore.xml.type.String"
	 *        extendedMetaData="kind='attribute' name='DecimalEncoding'"
	 * @generated
	 */
	String getDecimalEncoding();

	/**
	 * Sets the value of the '{@link com.ibm.ccl.soa.deploy.mq.MQTopicDestination#getDecimalEncoding <em>Decimal Encoding</em>}' attribute.
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
	 * @see com.ibm.ccl.soa.deploy.mq.MqPackage#getMQTopicDestination_Description1()
	 * @model dataType="org.eclipse.emf.ecore.xml.type.String"
	 *        extendedMetaData="kind='attribute' name='Description'"
	 * @generated
	 */
	String getDescription1();

	/**
	 * Sets the value of the '{@link com.ibm.ccl.soa.deploy.mq.MQTopicDestination#getDescription1 <em>Description1</em>}' attribute.
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
	 * @see com.ibm.ccl.soa.deploy.mq.MqPackage#getMQTopicDestination_DestinationName()
	 * @model dataType="org.eclipse.emf.ecore.xml.type.String"
	 *        extendedMetaData="kind='attribute' name='destinationName'"
	 * @generated
	 */
	String getDestinationName();

	/**
	 * Sets the value of the '{@link com.ibm.ccl.soa.deploy.mq.MQTopicDestination#getDestinationName <em>Destination Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Destination Name</em>' attribute.
	 * @see #getDestinationName()
	 * @generated
	 */
	void setDestinationName(String value);

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
	 * @see com.ibm.ccl.soa.deploy.mq.MqPackage#getMQTopicDestination_EnableMulticastTransport()
	 * @model dataType="org.eclipse.emf.ecore.xml.type.String"
	 *        extendedMetaData="kind='attribute' name='EnableMulticastTransport'"
	 * @generated
	 */
	String getEnableMulticastTransport();

	/**
	 * Sets the value of the '{@link com.ibm.ccl.soa.deploy.mq.MQTopicDestination#getEnableMulticastTransport <em>Enable Multicast Transport</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Enable Multicast Transport</em>' attribute.
	 * @see #getEnableMulticastTransport()
	 * @generated
	 */
	void setEnableMulticastTransport(String value);

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
	 * @see com.ibm.ccl.soa.deploy.mq.MqPackage#getMQTopicDestination_Expiry()
	 * @model dataType="org.eclipse.emf.ecore.xml.type.String"
	 *        extendedMetaData="kind='attribute' name='Expiry'"
	 * @generated
	 */
	String getExpiry();

	/**
	 * Sets the value of the '{@link com.ibm.ccl.soa.deploy.mq.MQTopicDestination#getExpiry <em>Expiry</em>}' attribute.
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
	 * @see com.ibm.ccl.soa.deploy.mq.MqPackage#getMQTopicDestination_FloatingPointEncoding()
	 * @model dataType="org.eclipse.emf.ecore.xml.type.String"
	 *        extendedMetaData="kind='attribute' name='FloatingPointEncoding'"
	 * @generated
	 */
	String getFloatingPointEncoding();

	/**
	 * Sets the value of the '{@link com.ibm.ccl.soa.deploy.mq.MQTopicDestination#getFloatingPointEncoding <em>Floating Point Encoding</em>}' attribute.
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
	 * @see com.ibm.ccl.soa.deploy.mq.MqPackage#getMQTopicDestination_IntegerEncoding()
	 * @model dataType="org.eclipse.emf.ecore.xml.type.String"
	 *        extendedMetaData="kind='attribute' name='IntegerEncoding'"
	 * @generated
	 */
	String getIntegerEncoding();

	/**
	 * Sets the value of the '{@link com.ibm.ccl.soa.deploy.mq.MQTopicDestination#getIntegerEncoding <em>Integer Encoding</em>}' attribute.
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
	 * @see com.ibm.ccl.soa.deploy.mq.MqPackage#getMQTopicDestination_JndiName()
	 * @model dataType="org.eclipse.emf.ecore.xml.type.String"
	 *        extendedMetaData="kind='attribute' name='jndiName'"
	 * @generated
	 */
	String getJndiName();

	/**
	 * Sets the value of the '{@link com.ibm.ccl.soa.deploy.mq.MQTopicDestination#getJndiName <em>Jndi Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Jndi Name</em>' attribute.
	 * @see #getJndiName()
	 * @generated
	 */
	void setJndiName(String value);

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
	 * @see com.ibm.ccl.soa.deploy.mq.MqPackage#getMQTopicDestination_Persitence()
	 * @model dataType="org.eclipse.emf.ecore.xml.type.String"
	 *        extendedMetaData="kind='attribute' name='Persitence'"
	 * @generated
	 */
	String getPersitence();

	/**
	 * Sets the value of the '{@link com.ibm.ccl.soa.deploy.mq.MQTopicDestination#getPersitence <em>Persitence</em>}' attribute.
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
	 * @see com.ibm.ccl.soa.deploy.mq.MqPackage#getMQTopicDestination_Priority()
	 * @model dataType="org.eclipse.emf.ecore.xml.type.String"
	 *        extendedMetaData="kind='attribute' name='Priority'"
	 * @generated
	 */
	String getPriority();

	/**
	 * Sets the value of the '{@link com.ibm.ccl.soa.deploy.mq.MQTopicDestination#getPriority <em>Priority</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Priority</em>' attribute.
	 * @see #getPriority()
	 * @generated
	 */
	void setPriority(String value);

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
	 * @see com.ibm.ccl.soa.deploy.mq.MqPackage#getMQTopicDestination_SpecifiedExpiry()
	 * @model dataType="org.eclipse.emf.ecore.xml.type.String"
	 *        extendedMetaData="kind='attribute' name='SpecifiedExpiry'"
	 * @generated
	 */
	String getSpecifiedExpiry();

	/**
	 * Sets the value of the '{@link com.ibm.ccl.soa.deploy.mq.MQTopicDestination#getSpecifiedExpiry <em>Specified Expiry</em>}' attribute.
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
	 * @see com.ibm.ccl.soa.deploy.mq.MqPackage#getMQTopicDestination_SpecifiedPriority()
	 * @model dataType="org.eclipse.emf.ecore.xml.type.String"
	 *        extendedMetaData="kind='attribute' name='SpecifiedPriority'"
	 * @generated
	 */
	String getSpecifiedPriority();

	/**
	 * Sets the value of the '{@link com.ibm.ccl.soa.deploy.mq.MQTopicDestination#getSpecifiedPriority <em>Specified Priority</em>}' attribute.
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
	 * @see com.ibm.ccl.soa.deploy.mq.MqPackage#getMQTopicDestination_TargetClient()
	 * @model dataType="org.eclipse.emf.ecore.xml.type.String"
	 *        extendedMetaData="kind='attribute' name='TargetClient'"
	 * @generated
	 */
	String getTargetClient();

	/**
	 * Sets the value of the '{@link com.ibm.ccl.soa.deploy.mq.MQTopicDestination#getTargetClient <em>Target Client</em>}' attribute.
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
	 * @see com.ibm.ccl.soa.deploy.mq.MqPackage#getMQTopicDestination_UseNativeEncoding()
	 * @model dataType="org.eclipse.emf.ecore.xml.type.String"
	 *        extendedMetaData="kind='attribute' name='UseNativeEncoding'"
	 * @generated
	 */
	String getUseNativeEncoding();

	/**
	 * Sets the value of the '{@link com.ibm.ccl.soa.deploy.mq.MQTopicDestination#getUseNativeEncoding <em>Use Native Encoding</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Use Native Encoding</em>' attribute.
	 * @see #getUseNativeEncoding()
	 * @generated
	 */
	void setUseNativeEncoding(String value);
} // MQTopicDestination
