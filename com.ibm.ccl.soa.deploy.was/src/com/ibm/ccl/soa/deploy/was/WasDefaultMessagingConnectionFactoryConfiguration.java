/*******************************************************************************
 * Copyright (c) 2003, 2007 IBM Corporation Licensed Material - Property of IBM. All rights reserved.
 *  
 * US Government Users Restricted Rights - Use, duplication or disclosure v1.0 restricted by GSA ADP
 * Schedule Contract with IBM Corp.
 * 
 * Contributors: IBM Corporation - initial API and implementation
 *******************************************************************************/
package com.ibm.ccl.soa.deploy.was;

import com.ibm.ccl.soa.deploy.j2ee.jms.JMSConnectionFactory;

/**
 * <!-- begin-user-doc --> A representation of the model object '<em><b>Default Messaging Connection Factory Configuration</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link com.ibm.ccl.soa.deploy.was.WasDefaultMessagingConnectionFactoryConfiguration#getCategory <em>Category</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.was.WasDefaultMessagingConnectionFactoryConfiguration#getClientIdentifier <em>Client Identifier</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.was.WasDefaultMessagingConnectionFactoryConfiguration#getConnectionProximity <em>Connection Proximity</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.was.WasDefaultMessagingConnectionFactoryConfiguration#getDurableSubscriptionHome <em>Durable Subscription Home</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.was.WasDefaultMessagingConnectionFactoryConfiguration#getNonpersistentMessageReliability <em>Nonpersistent Message Reliability</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.was.WasDefaultMessagingConnectionFactoryConfiguration#getPersistentMessageReliability <em>Persistent Message Reliability</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.was.WasDefaultMessagingConnectionFactoryConfiguration#getProviderEndpoints <em>Provider Endpoints</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.was.WasDefaultMessagingConnectionFactoryConfiguration#getReadAhead <em>Read Ahead</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.was.WasDefaultMessagingConnectionFactoryConfiguration#getShareDurableSubscriptions <em>Share Durable Subscriptions</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.was.WasDefaultMessagingConnectionFactoryConfiguration#getTarget <em>Target</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.was.WasDefaultMessagingConnectionFactoryConfiguration#getTargetInboundTransportChain <em>Target Inbound Transport Chain</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.was.WasDefaultMessagingConnectionFactoryConfiguration#getTargetSignificance <em>Target Significance</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.was.WasDefaultMessagingConnectionFactoryConfiguration#getTargetType <em>Target Type</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.was.WasDefaultMessagingConnectionFactoryConfiguration#getTempQnamePrefix <em>Temp Qname Prefix</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.was.WasDefaultMessagingConnectionFactoryConfiguration#getTempTopicNamePrefix <em>Temp Topic Name Prefix</em>}</li>
 * </ul>
 * </p>
 *
 * @see com.ibm.ccl.soa.deploy.was.WasPackage#getWasDefaultMessagingConnectionFactoryConfiguration()
 * @model extendedMetaData="name='WasDefaultMessagingConnectionFactoryConfiguration' kind='elementOnly'"
 * @generated
 */
public interface WasDefaultMessagingConnectionFactoryConfiguration extends JMSConnectionFactory {
	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	String copyright = "Copyright (c) 2005, 2006 IBM Corporation. Licensed Material - Property of IBM. All rights reserved."; //$NON-NLS-1$

	/**
	 * Returns the value of the '<em><b>Category</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Category</em>' attribute isn't clear, there really should be
	 * more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Category</em>' attribute.
	 * @see #setCategory(String)
	 * @see com.ibm.ccl.soa.deploy.was.WasPackage#getWasDefaultMessagingConnectionFactoryConfiguration_Category()
	 * @model dataType="org.eclipse.emf.ecore.xml.type.String"
	 *        extendedMetaData="kind='attribute' name='category'"
	 * @generated
	 */
	String getCategory();

	/**
	 * Sets the value of the '{@link com.ibm.ccl.soa.deploy.was.WasDefaultMessagingConnectionFactoryConfiguration#getCategory <em>Category</em>}' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @param value the new value of the '<em>Category</em>' attribute.
	 * @see #getCategory()
	 * @generated
	 */
	void setCategory(String value);

	/**
	 * Returns the value of the '<em><b>Client Identifier</b></em>' attribute. <!--
	 * begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Client Identifier</em>' attribute isn't clear, there really
	 * should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * 
	 * @return the value of the '<em>Client Identifier</em>' attribute.
	 * @see #setClientIdentifier(String)
	 * @see com.ibm.ccl.soa.deploy.was.WasPackage#getWasDefaultMessagingConnectionFactoryConfiguration_ClientIdentifier()
	 * @model unique="false" dataType="org.eclipse.emf.ecore.xml.type.String"
	 *        extendedMetaData="kind='attribute' name='clientIdentifier'"
	 * @generated
	 */
	String getClientIdentifier();

	/**
	 * Sets the value of the '{@link com.ibm.ccl.soa.deploy.was.WasDefaultMessagingConnectionFactoryConfiguration#getClientIdentifier <em>Client Identifier</em>}' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @param value the new value of the '<em>Client Identifier</em>' attribute.
	 * @see #getClientIdentifier()
	 * @generated
	 */
	void setClientIdentifier(String value);

	/**
	 * Returns the value of the '<em><b>Connection Proximity</b></em>' attribute.
	 * The default value is <code>"Bus"</code>.
	 * The literals are from the enumeration {@link com.ibm.ccl.soa.deploy.was.ConnectionProximityEnum}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Connection Proximity</em>' attribute isn't clear, there really
	 * should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Connection Proximity</em>' attribute.
	 * @see com.ibm.ccl.soa.deploy.was.ConnectionProximityEnum
	 * @see #isSetConnectionProximity()
	 * @see #unsetConnectionProximity()
	 * @see #setConnectionProximity(ConnectionProximityEnum)
	 * @see com.ibm.ccl.soa.deploy.was.WasPackage#getWasDefaultMessagingConnectionFactoryConfiguration_ConnectionProximity()
	 * @model default="Bus" unsettable="true"
	 *        extendedMetaData="kind='attribute' name='connectionProximity'"
	 * @generated
	 */
	ConnectionProximityEnum getConnectionProximity();

	/**
	 * Sets the value of the '{@link com.ibm.ccl.soa.deploy.was.WasDefaultMessagingConnectionFactoryConfiguration#getConnectionProximity <em>Connection Proximity</em>}' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @param value the new value of the '<em>Connection Proximity</em>' attribute.
	 * @see com.ibm.ccl.soa.deploy.was.ConnectionProximityEnum
	 * @see #isSetConnectionProximity()
	 * @see #unsetConnectionProximity()
	 * @see #getConnectionProximity()
	 * @generated
	 */
	void setConnectionProximity(ConnectionProximityEnum value);

	/**
	 * Unsets the value of the '{@link com.ibm.ccl.soa.deploy.was.WasDefaultMessagingConnectionFactoryConfiguration#getConnectionProximity <em>Connection Proximity</em>}' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see #isSetConnectionProximity()
	 * @see #getConnectionProximity()
	 * @see #setConnectionProximity(ConnectionProximityEnum)
	 * @generated
	 */
	void unsetConnectionProximity();

	/**
	 * Returns whether the value of the '{@link com.ibm.ccl.soa.deploy.was.WasDefaultMessagingConnectionFactoryConfiguration#getConnectionProximity <em>Connection Proximity</em>}' attribute is set.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return whether the value of the '<em>Connection Proximity</em>' attribute is set.
	 * @see #unsetConnectionProximity()
	 * @see #getConnectionProximity()
	 * @see #setConnectionProximity(ConnectionProximityEnum)
	 * @generated
	 */
	boolean isSetConnectionProximity();

	/**
	 * Returns the value of the '<em><b>Durable Subscription Home</b></em>' attribute. <!--
	 * begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Durable Subscription Home</em>' attribute isn't clear, there
	 * really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * 
	 * @return the value of the '<em>Durable Subscription Home</em>' attribute.
	 * @see #setDurableSubscriptionHome(String)
	 * @see com.ibm.ccl.soa.deploy.was.WasPackage#getWasDefaultMessagingConnectionFactoryConfiguration_DurableSubscriptionHome()
	 * @model unique="false" dataType="org.eclipse.emf.ecore.xml.type.String"
	 *        extendedMetaData="kind='attribute' name='durableSubscriptionHome'"
	 * @generated
	 */
	String getDurableSubscriptionHome();

	/**
	 * Sets the value of the '{@link com.ibm.ccl.soa.deploy.was.WasDefaultMessagingConnectionFactoryConfiguration#getDurableSubscriptionHome <em>Durable Subscription Home</em>}' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @param value the new value of the '<em>Durable Subscription Home</em>' attribute.
	 * @see #getDurableSubscriptionHome()
	 * @generated
	 */
	void setDurableSubscriptionHome(String value);

	/**
	 * Returns the value of the '<em><b>Nonpersistent Message Reliability</b></em>' attribute.
	 * The default value is <code>"None"</code>.
	 * The literals are from the enumeration {@link com.ibm.ccl.soa.deploy.was.MessageReliabilityEnum}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Nonpersistent Message Reliability</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Nonpersistent Message Reliability</em>' attribute.
	 * @see com.ibm.ccl.soa.deploy.was.MessageReliabilityEnum
	 * @see #isSetNonpersistentMessageReliability()
	 * @see #unsetNonpersistentMessageReliability()
	 * @see #setNonpersistentMessageReliability(MessageReliabilityEnum)
	 * @see com.ibm.ccl.soa.deploy.was.WasPackage#getWasDefaultMessagingConnectionFactoryConfiguration_NonpersistentMessageReliability()
	 * @model default="None" unsettable="true"
	 *        extendedMetaData="kind='attribute' name='nonpersistentMessageReliability'"
	 * @generated
	 */
	MessageReliabilityEnum getNonpersistentMessageReliability();

	/**
	 * Sets the value of the '{@link com.ibm.ccl.soa.deploy.was.WasDefaultMessagingConnectionFactoryConfiguration#getNonpersistentMessageReliability <em>Nonpersistent Message Reliability</em>}' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @param value the new value of the '<em>Nonpersistent Message Reliability</em>' attribute.
	 * @see com.ibm.ccl.soa.deploy.was.MessageReliabilityEnum
	 * @see #isSetNonpersistentMessageReliability()
	 * @see #unsetNonpersistentMessageReliability()
	 * @see #getNonpersistentMessageReliability()
	 * @generated
	 */
	void setNonpersistentMessageReliability(MessageReliabilityEnum value);

	/**
	 * Unsets the value of the '{@link com.ibm.ccl.soa.deploy.was.WasDefaultMessagingConnectionFactoryConfiguration#getNonpersistentMessageReliability <em>Nonpersistent Message Reliability</em>}' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see #isSetNonpersistentMessageReliability()
	 * @see #getNonpersistentMessageReliability()
	 * @see #setNonpersistentMessageReliability(MessageReliabilityEnum)
	 * @generated
	 */
	void unsetNonpersistentMessageReliability();

	/**
	 * Returns whether the value of the '{@link com.ibm.ccl.soa.deploy.was.WasDefaultMessagingConnectionFactoryConfiguration#getNonpersistentMessageReliability <em>Nonpersistent Message Reliability</em>}' attribute is set.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return whether the value of the '<em>Nonpersistent Message Reliability</em>' attribute is set.
	 * @see #unsetNonpersistentMessageReliability()
	 * @see #getNonpersistentMessageReliability()
	 * @see #setNonpersistentMessageReliability(MessageReliabilityEnum)
	 * @generated
	 */
	boolean isSetNonpersistentMessageReliability();

	/**
	 * Returns the value of the '<em><b>Persistent Message Reliability</b></em>' attribute.
	 * The default value is <code>"None"</code>.
	 * The literals are from the enumeration {@link com.ibm.ccl.soa.deploy.was.MessageReliabilityEnum}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Persistent Message Reliability</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Persistent Message Reliability</em>' attribute.
	 * @see com.ibm.ccl.soa.deploy.was.MessageReliabilityEnum
	 * @see #isSetPersistentMessageReliability()
	 * @see #unsetPersistentMessageReliability()
	 * @see #setPersistentMessageReliability(MessageReliabilityEnum)
	 * @see com.ibm.ccl.soa.deploy.was.WasPackage#getWasDefaultMessagingConnectionFactoryConfiguration_PersistentMessageReliability()
	 * @model default="None" unsettable="true"
	 *        extendedMetaData="kind='attribute' name='persistentMessageReliability'"
	 * @generated
	 */
	MessageReliabilityEnum getPersistentMessageReliability();

	/**
	 * Sets the value of the '{@link com.ibm.ccl.soa.deploy.was.WasDefaultMessagingConnectionFactoryConfiguration#getPersistentMessageReliability <em>Persistent Message Reliability</em>}' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @param value the new value of the '<em>Persistent Message Reliability</em>' attribute.
	 * @see com.ibm.ccl.soa.deploy.was.MessageReliabilityEnum
	 * @see #isSetPersistentMessageReliability()
	 * @see #unsetPersistentMessageReliability()
	 * @see #getPersistentMessageReliability()
	 * @generated
	 */
	void setPersistentMessageReliability(MessageReliabilityEnum value);

	/**
	 * Unsets the value of the '{@link com.ibm.ccl.soa.deploy.was.WasDefaultMessagingConnectionFactoryConfiguration#getPersistentMessageReliability <em>Persistent Message Reliability</em>}' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see #isSetPersistentMessageReliability()
	 * @see #getPersistentMessageReliability()
	 * @see #setPersistentMessageReliability(MessageReliabilityEnum)
	 * @generated
	 */
	void unsetPersistentMessageReliability();

	/**
	 * Returns whether the value of the '{@link com.ibm.ccl.soa.deploy.was.WasDefaultMessagingConnectionFactoryConfiguration#getPersistentMessageReliability <em>Persistent Message Reliability</em>}' attribute is set.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return whether the value of the '<em>Persistent Message Reliability</em>' attribute is set.
	 * @see #unsetPersistentMessageReliability()
	 * @see #getPersistentMessageReliability()
	 * @see #setPersistentMessageReliability(MessageReliabilityEnum)
	 * @generated
	 */
	boolean isSetPersistentMessageReliability();

	/**
	 * Returns the value of the '<em><b>Provider Endpoints</b></em>' attribute. <!--
	 * begin-user-doc --> <!-- end-user-doc --> <!-- begin-model-doc --> comma <!-- end-model-doc -->
	 * 
	 * @return the value of the '<em>Provider Endpoints</em>' attribute.
	 * @see #setProviderEndpoints(String)
	 * @see com.ibm.ccl.soa.deploy.was.WasPackage#getWasDefaultMessagingConnectionFactoryConfiguration_ProviderEndpoints()
	 * @model unique="false" dataType="org.eclipse.emf.ecore.xml.type.String"
	 *        extendedMetaData="kind='attribute' name='providerEndpoints'"
	 * @generated
	 */
	String getProviderEndpoints();

	/**
	 * Sets the value of the '{@link com.ibm.ccl.soa.deploy.was.WasDefaultMessagingConnectionFactoryConfiguration#getProviderEndpoints <em>Provider Endpoints</em>}' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @param value the new value of the '<em>Provider Endpoints</em>' attribute.
	 * @see #getProviderEndpoints()
	 * @generated
	 */
	void setProviderEndpoints(String value);

	/**
	 * Returns the value of the '<em><b>Read Ahead</b></em>' attribute.
	 * The default value is <code>"Default"</code>.
	 * The literals are from the enumeration {@link com.ibm.ccl.soa.deploy.was.ReadAheadOptimizationEnum}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Read Ahead</em>' attribute isn't clear, there really should be
	 * more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Read Ahead</em>' attribute.
	 * @see com.ibm.ccl.soa.deploy.was.ReadAheadOptimizationEnum
	 * @see #isSetReadAhead()
	 * @see #unsetReadAhead()
	 * @see #setReadAhead(ReadAheadOptimizationEnum)
	 * @see com.ibm.ccl.soa.deploy.was.WasPackage#getWasDefaultMessagingConnectionFactoryConfiguration_ReadAhead()
	 * @model default="Default" unsettable="true"
	 *        extendedMetaData="kind='attribute' name='readAhead'"
	 * @generated
	 */
	ReadAheadOptimizationEnum getReadAhead();

	/**
	 * Sets the value of the '{@link com.ibm.ccl.soa.deploy.was.WasDefaultMessagingConnectionFactoryConfiguration#getReadAhead <em>Read Ahead</em>}' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @param value the new value of the '<em>Read Ahead</em>' attribute.
	 * @see com.ibm.ccl.soa.deploy.was.ReadAheadOptimizationEnum
	 * @see #isSetReadAhead()
	 * @see #unsetReadAhead()
	 * @see #getReadAhead()
	 * @generated
	 */
	void setReadAhead(ReadAheadOptimizationEnum value);

	/**
	 * Unsets the value of the '{@link com.ibm.ccl.soa.deploy.was.WasDefaultMessagingConnectionFactoryConfiguration#getReadAhead <em>Read Ahead</em>}' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see #isSetReadAhead()
	 * @see #getReadAhead()
	 * @see #setReadAhead(ReadAheadOptimizationEnum)
	 * @generated
	 */
	void unsetReadAhead();

	/**
	 * Returns whether the value of the '{@link com.ibm.ccl.soa.deploy.was.WasDefaultMessagingConnectionFactoryConfiguration#getReadAhead <em>Read Ahead</em>}' attribute is set.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return whether the value of the '<em>Read Ahead</em>' attribute is set.
	 * @see #unsetReadAhead()
	 * @see #getReadAhead()
	 * @see #setReadAhead(ReadAheadOptimizationEnum)
	 * @generated
	 */
	boolean isSetReadAhead();

	/**
	 * Returns the value of the '<em><b>Share Durable Subscriptions</b></em>' attribute.
	 * The default value is <code>"In cluster"</code>.
	 * The literals are from the enumeration {@link com.ibm.ccl.soa.deploy.was.ShareDurableSubscriptionsEnum}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Share Durable Subscriptions</em>' attribute isn't clear, there
	 * really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Share Durable Subscriptions</em>' attribute.
	 * @see com.ibm.ccl.soa.deploy.was.ShareDurableSubscriptionsEnum
	 * @see #isSetShareDurableSubscriptions()
	 * @see #unsetShareDurableSubscriptions()
	 * @see #setShareDurableSubscriptions(ShareDurableSubscriptionsEnum)
	 * @see com.ibm.ccl.soa.deploy.was.WasPackage#getWasDefaultMessagingConnectionFactoryConfiguration_ShareDurableSubscriptions()
	 * @model default="In cluster" unsettable="true"
	 *        extendedMetaData="kind='attribute' name='ShareDurableSubscriptions'"
	 * @generated
	 */
	ShareDurableSubscriptionsEnum getShareDurableSubscriptions();

	/**
	 * Sets the value of the '{@link com.ibm.ccl.soa.deploy.was.WasDefaultMessagingConnectionFactoryConfiguration#getShareDurableSubscriptions <em>Share Durable Subscriptions</em>}' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @param value the new value of the '<em>Share Durable Subscriptions</em>' attribute.
	 * @see com.ibm.ccl.soa.deploy.was.ShareDurableSubscriptionsEnum
	 * @see #isSetShareDurableSubscriptions()
	 * @see #unsetShareDurableSubscriptions()
	 * @see #getShareDurableSubscriptions()
	 * @generated
	 */
	void setShareDurableSubscriptions(ShareDurableSubscriptionsEnum value);

	/**
	 * Unsets the value of the '{@link com.ibm.ccl.soa.deploy.was.WasDefaultMessagingConnectionFactoryConfiguration#getShareDurableSubscriptions <em>Share Durable Subscriptions</em>}' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see #isSetShareDurableSubscriptions()
	 * @see #getShareDurableSubscriptions()
	 * @see #setShareDurableSubscriptions(ShareDurableSubscriptionsEnum)
	 * @generated
	 */
	void unsetShareDurableSubscriptions();

	/**
	 * Returns whether the value of the '{@link com.ibm.ccl.soa.deploy.was.WasDefaultMessagingConnectionFactoryConfiguration#getShareDurableSubscriptions <em>Share Durable Subscriptions</em>}' attribute is set.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return whether the value of the '<em>Share Durable Subscriptions</em>' attribute is set.
	 * @see #unsetShareDurableSubscriptions()
	 * @see #getShareDurableSubscriptions()
	 * @see #setShareDurableSubscriptions(ShareDurableSubscriptionsEnum)
	 * @generated
	 */
	boolean isSetShareDurableSubscriptions();

	/**
	 * Returns the value of the '<em><b>Target</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Target</em>' attribute isn't clear, there really should be more
	 * of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Target</em>' attribute.
	 * @see #setTarget(String)
	 * @see com.ibm.ccl.soa.deploy.was.WasPackage#getWasDefaultMessagingConnectionFactoryConfiguration_Target()
	 * @model dataType="org.eclipse.emf.ecore.xml.type.String"
	 *        extendedMetaData="kind='attribute' name='target'"
	 * @generated
	 */
	String getTarget();

	/**
	 * Sets the value of the '{@link com.ibm.ccl.soa.deploy.was.WasDefaultMessagingConnectionFactoryConfiguration#getTarget <em>Target</em>}' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @param value the new value of the '<em>Target</em>' attribute.
	 * @see #getTarget()
	 * @generated
	 */
	void setTarget(String value);

	/**
	 * Returns the value of the '<em><b>Target Inbound Transport Chain</b></em>' attribute. <!--
	 * begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Target Inbound Transport Chain</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * 
	 * @return the value of the '<em>Target Inbound Transport Chain</em>' attribute.
	 * @see #setTargetInboundTransportChain(String)
	 * @see com.ibm.ccl.soa.deploy.was.WasPackage#getWasDefaultMessagingConnectionFactoryConfiguration_TargetInboundTransportChain()
	 * @model unique="false" dataType="org.eclipse.emf.ecore.xml.type.String"
	 *        extendedMetaData="kind='attribute' name='targetInboundTransportChain'"
	 * @generated
	 */
	String getTargetInboundTransportChain();

	/**
	 * Sets the value of the '{@link com.ibm.ccl.soa.deploy.was.WasDefaultMessagingConnectionFactoryConfiguration#getTargetInboundTransportChain <em>Target Inbound Transport Chain</em>}' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @param value the new value of the '<em>Target Inbound Transport Chain</em>' attribute.
	 * @see #getTargetInboundTransportChain()
	 * @generated
	 */
	void setTargetInboundTransportChain(String value);

	/**
	 * Returns the value of the '<em><b>Target Significance</b></em>' attribute. The default
	 * value is <code>"Preferred"</code>. The literals are from the enumeration
	 * {@link com.ibm.ccl.soa.deploy.was.CFTargetSignificanceEnum}. <!-- begin-user-doc --> <!--
	 * end-user-doc --> <!-- begin-model-doc --> The priority of significance for the target
	 * specified <!-- end-model-doc -->
	 * 
	 * @return the value of the '<em>Target Significance</em>' attribute.
	 * @see com.ibm.ccl.soa.deploy.was.CFTargetSignificanceEnum
	 * @see #isSetTargetSignificance()
	 * @see #unsetTargetSignificance()
	 * @see #setTargetSignificance(CFTargetSignificanceEnum)
	 * @see com.ibm.ccl.soa.deploy.was.WasPackage#getWasDefaultMessagingConnectionFactoryConfiguration_TargetSignificance()
	 * @model default="Preferred" unique="false" unsettable="true" extendedMetaData="kind='attribute'
	 *        name='targetSignificance'"
	 * @generated
	 */
	CFTargetSignificanceEnum getTargetSignificance();

	/**
	 * Sets the value of the '{@link com.ibm.ccl.soa.deploy.was.WasDefaultMessagingConnectionFactoryConfiguration#getTargetSignificance <em>Target Significance</em>}' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @param value the new value of the '<em>Target Significance</em>' attribute.
	 * @see com.ibm.ccl.soa.deploy.was.CFTargetSignificanceEnum
	 * @see #isSetTargetSignificance()
	 * @see #unsetTargetSignificance()
	 * @see #getTargetSignificance()
	 * @generated
	 */
	void setTargetSignificance(CFTargetSignificanceEnum value);

	/**
	 * Unsets the value of the '{@link com.ibm.ccl.soa.deploy.was.WasDefaultMessagingConnectionFactoryConfiguration#getTargetSignificance <em>Target Significance</em>}' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see #isSetTargetSignificance()
	 * @see #getTargetSignificance()
	 * @see #setTargetSignificance(CFTargetSignificanceEnum)
	 * @generated
	 */
	void unsetTargetSignificance();

	/**
	 * Returns whether the value of the '{@link com.ibm.ccl.soa.deploy.was.WasDefaultMessagingConnectionFactoryConfiguration#getTargetSignificance <em>Target Significance</em>}' attribute is set.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return whether the value of the '<em>Target Significance</em>' attribute is set.
	 * @see #unsetTargetSignificance()
	 * @see #getTargetSignificance()
	 * @see #setTargetSignificance(CFTargetSignificanceEnum)
	 * @generated
	 */
	boolean isSetTargetSignificance();

	/**
	 * Returns the value of the '<em><b>Target Type</b></em>' attribute. The default value is
	 * <code>"BusMember"</code>. The literals are from the enumeration
	 * {@link com.ibm.ccl.soa.deploy.was.ConnectionFactoryTargetTypeEnum}. <!-- begin-user-doc -->
	 * <!-- end-user-doc --> <!-- begin-model-doc --> or enum <!-- end-model-doc -->
	 * 
	 * @return the value of the '<em>Target Type</em>' attribute.
	 * @see com.ibm.ccl.soa.deploy.was.ConnectionFactoryTargetTypeEnum
	 * @see #isSetTargetType()
	 * @see #unsetTargetType()
	 * @see #setTargetType(ConnectionFactoryTargetTypeEnum)
	 * @see com.ibm.ccl.soa.deploy.was.WasPackage#getWasDefaultMessagingConnectionFactoryConfiguration_TargetType()
	 * @model default="BusMember" unique="false" unsettable="true" extendedMetaData="kind='attribute'
	 *        name='targetType'"
	 * @generated
	 */
	ConnectionFactoryTargetTypeEnum getTargetType();

	/**
	 * Sets the value of the '{@link com.ibm.ccl.soa.deploy.was.WasDefaultMessagingConnectionFactoryConfiguration#getTargetType <em>Target Type</em>}' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @param value the new value of the '<em>Target Type</em>' attribute.
	 * @see com.ibm.ccl.soa.deploy.was.ConnectionFactoryTargetTypeEnum
	 * @see #isSetTargetType()
	 * @see #unsetTargetType()
	 * @see #getTargetType()
	 * @generated
	 */
	void setTargetType(ConnectionFactoryTargetTypeEnum value);

	/**
	 * Unsets the value of the '{@link com.ibm.ccl.soa.deploy.was.WasDefaultMessagingConnectionFactoryConfiguration#getTargetType <em>Target Type</em>}' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see #isSetTargetType()
	 * @see #getTargetType()
	 * @see #setTargetType(ConnectionFactoryTargetTypeEnum)
	 * @generated
	 */
	void unsetTargetType();

	/**
	 * Returns whether the value of the '{@link com.ibm.ccl.soa.deploy.was.WasDefaultMessagingConnectionFactoryConfiguration#getTargetType <em>Target Type</em>}' attribute is set.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return whether the value of the '<em>Target Type</em>' attribute is set.
	 * @see #unsetTargetType()
	 * @see #getTargetType()
	 * @see #setTargetType(ConnectionFactoryTargetTypeEnum)
	 * @generated
	 */
	boolean isSetTargetType();

	/**
	 * Returns the value of the '<em><b>Temp Qname Prefix</b></em>' attribute. <!--
	 * begin-user-doc --> <!-- end-user-doc --> <!-- begin-model-doc --> length less than 12 <!--
	 * end-model-doc -->
	 * 
	 * @return the value of the '<em>Temp Qname Prefix</em>' attribute.
	 * @see #setTempQnamePrefix(String)
	 * @see com.ibm.ccl.soa.deploy.was.WasPackage#getWasDefaultMessagingConnectionFactoryConfiguration_TempQnamePrefix()
	 * @model unique="false" dataType="org.eclipse.emf.ecore.xml.type.String"
	 *        extendedMetaData="kind='attribute' name='tempQnamePrefix'"
	 * @generated
	 */
	String getTempQnamePrefix();

	/**
	 * Sets the value of the '{@link com.ibm.ccl.soa.deploy.was.WasDefaultMessagingConnectionFactoryConfiguration#getTempQnamePrefix <em>Temp Qname Prefix</em>}' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @param value the new value of the '<em>Temp Qname Prefix</em>' attribute.
	 * @see #getTempQnamePrefix()
	 * @generated
	 */
	void setTempQnamePrefix(String value);

	/**
	 * Returns the value of the '<em><b>Temp Topic Name Prefix</b></em>' attribute. <!--
	 * begin-user-doc --> <!-- end-user-doc --> <!-- begin-model-doc --> length less than 12 <!--
	 * end-model-doc -->
	 * 
	 * @return the value of the '<em>Temp Topic Name Prefix</em>' attribute.
	 * @see #setTempTopicNamePrefix(String)
	 * @see com.ibm.ccl.soa.deploy.was.WasPackage#getWasDefaultMessagingConnectionFactoryConfiguration_TempTopicNamePrefix()
	 * @model unique="false" dataType="org.eclipse.emf.ecore.xml.type.String"
	 *        extendedMetaData="kind='attribute' name='tempTopicNamePrefix'"
	 * @generated
	 */
	String getTempTopicNamePrefix();

	/**
	 * Sets the value of the '{@link com.ibm.ccl.soa.deploy.was.WasDefaultMessagingConnectionFactoryConfiguration#getTempTopicNamePrefix <em>Temp Topic Name Prefix</em>}' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @param value the new value of the '<em>Temp Topic Name Prefix</em>' attribute.
	 * @see #getTempTopicNamePrefix()
	 * @generated
	 */
	void setTempTopicNamePrefix(String value);

} // WasDefaultMessagingConnectionFactoryConfiguration
