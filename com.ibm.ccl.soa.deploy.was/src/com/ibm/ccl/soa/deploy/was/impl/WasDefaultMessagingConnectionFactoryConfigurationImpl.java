/*******************************************************************************
 * Copyright (c) 2003, 2007 IBM Corporation Licensed Material - Property of IBM. All rights reserved.
 *  
 * US Government Users Restricted Rights - Use, duplication or disclosure v1.0 restricted by GSA ADP
 * Schedule Contract with IBM Corp.
 * 
 * Contributors: IBM Corporation - initial API and implementation
 *******************************************************************************/
package com.ibm.ccl.soa.deploy.was.impl;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.impl.ENotificationImpl;

import com.ibm.ccl.soa.deploy.j2ee.jms.impl.JMSConnectionFactoryImpl;
import com.ibm.ccl.soa.deploy.was.CFTargetSignificanceEnum;
import com.ibm.ccl.soa.deploy.was.ConnectionFactoryTargetTypeEnum;
import com.ibm.ccl.soa.deploy.was.ConnectionProximityEnum;
import com.ibm.ccl.soa.deploy.was.MessageReliabilityEnum;
import com.ibm.ccl.soa.deploy.was.ReadAheadOptimizationEnum;
import com.ibm.ccl.soa.deploy.was.ShareDurableSubscriptionsEnum;
import com.ibm.ccl.soa.deploy.was.WasDefaultMessagingConnectionFactoryConfiguration;
import com.ibm.ccl.soa.deploy.was.WasPackage;

/**
 * <!-- begin-user-doc --> An implementation of the model object '<em><b>Default Messaging Connection Factory Configuration</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link com.ibm.ccl.soa.deploy.was.impl.WasDefaultMessagingConnectionFactoryConfigurationImpl#getCategory <em>Category</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.was.impl.WasDefaultMessagingConnectionFactoryConfigurationImpl#getClientIdentifier <em>Client Identifier</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.was.impl.WasDefaultMessagingConnectionFactoryConfigurationImpl#getConnectionProximity <em>Connection Proximity</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.was.impl.WasDefaultMessagingConnectionFactoryConfigurationImpl#getDurableSubscriptionHome <em>Durable Subscription Home</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.was.impl.WasDefaultMessagingConnectionFactoryConfigurationImpl#getNonpersistentMessageReliability <em>Nonpersistent Message Reliability</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.was.impl.WasDefaultMessagingConnectionFactoryConfigurationImpl#getPersistentMessageReliability <em>Persistent Message Reliability</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.was.impl.WasDefaultMessagingConnectionFactoryConfigurationImpl#getProviderEndpoints <em>Provider Endpoints</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.was.impl.WasDefaultMessagingConnectionFactoryConfigurationImpl#getReadAhead <em>Read Ahead</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.was.impl.WasDefaultMessagingConnectionFactoryConfigurationImpl#getShareDurableSubscriptions <em>Share Durable Subscriptions</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.was.impl.WasDefaultMessagingConnectionFactoryConfigurationImpl#getTarget <em>Target</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.was.impl.WasDefaultMessagingConnectionFactoryConfigurationImpl#getTargetInboundTransportChain <em>Target Inbound Transport Chain</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.was.impl.WasDefaultMessagingConnectionFactoryConfigurationImpl#getTargetSignificance <em>Target Significance</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.was.impl.WasDefaultMessagingConnectionFactoryConfigurationImpl#getTargetType <em>Target Type</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.was.impl.WasDefaultMessagingConnectionFactoryConfigurationImpl#getTempQnamePrefix <em>Temp Qname Prefix</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.was.impl.WasDefaultMessagingConnectionFactoryConfigurationImpl#getTempTopicNamePrefix <em>Temp Topic Name Prefix</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class WasDefaultMessagingConnectionFactoryConfigurationImpl extends JMSConnectionFactoryImpl
		implements WasDefaultMessagingConnectionFactoryConfiguration {
	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public static final String copyright = "Copyright (c) 2005, 2006 IBM Corporation. Licensed Material - Property of IBM. All rights reserved."; //$NON-NLS-1$

	/**
	 * The default value of the '{@link #getCategory() <em>Category</em>}' attribute. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see #getCategory()
	 * @generated
	 * @ordered
	 */
	protected static final String CATEGORY_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getCategory() <em>Category</em>}' attribute. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see #getCategory()
	 * @generated
	 * @ordered
	 */
	protected String category = CATEGORY_EDEFAULT;

	/**
	 * The default value of the '{@link #getClientIdentifier() <em>Client Identifier</em>}' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see #getClientIdentifier()
	 * @generated
	 * @ordered
	 */
	protected static final String CLIENT_IDENTIFIER_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getClientIdentifier() <em>Client Identifier</em>}' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see #getClientIdentifier()
	 * @generated
	 * @ordered
	 */
	protected String clientIdentifier = CLIENT_IDENTIFIER_EDEFAULT;

	/**
	 * The default value of the '{@link #getConnectionProximity() <em>Connection Proximity</em>}' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see #getConnectionProximity()
	 * @generated
	 * @ordered
	 */
	protected static final ConnectionProximityEnum CONNECTION_PROXIMITY_EDEFAULT = ConnectionProximityEnum.BUS_LITERAL;

	/**
	 * The cached value of the '{@link #getConnectionProximity() <em>Connection Proximity</em>}' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see #getConnectionProximity()
	 * @generated
	 * @ordered
	 */
	protected ConnectionProximityEnum connectionProximity = CONNECTION_PROXIMITY_EDEFAULT;

	/**
	 * This is true if the Connection Proximity attribute has been set.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @generated
	 * @ordered
	 */
	protected boolean connectionProximityESet;

	/**
	 * The default value of the '{@link #getDurableSubscriptionHome() <em>Durable Subscription Home</em>}' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see #getDurableSubscriptionHome()
	 * @generated
	 * @ordered
	 */
	protected static final String DURABLE_SUBSCRIPTION_HOME_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getDurableSubscriptionHome() <em>Durable Subscription Home</em>}' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see #getDurableSubscriptionHome()
	 * @generated
	 * @ordered
	 */
	protected String durableSubscriptionHome = DURABLE_SUBSCRIPTION_HOME_EDEFAULT;

	/**
	 * The default value of the '{@link #getNonpersistentMessageReliability() <em>Nonpersistent Message Reliability</em>}' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see #getNonpersistentMessageReliability()
	 * @generated
	 * @ordered
	 */
	protected static final MessageReliabilityEnum NONPERSISTENT_MESSAGE_RELIABILITY_EDEFAULT = MessageReliabilityEnum.NONE_LITERAL;

	/**
	 * The cached value of the '{@link #getNonpersistentMessageReliability() <em>Nonpersistent Message Reliability</em>}' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see #getNonpersistentMessageReliability()
	 * @generated
	 * @ordered
	 */
	protected MessageReliabilityEnum nonpersistentMessageReliability = NONPERSISTENT_MESSAGE_RELIABILITY_EDEFAULT;

	/**
	 * This is true if the Nonpersistent Message Reliability attribute has been set. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	protected boolean nonpersistentMessageReliabilityESet;

	/**
	 * The default value of the '{@link #getPersistentMessageReliability() <em>Persistent Message Reliability</em>}' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see #getPersistentMessageReliability()
	 * @generated
	 * @ordered
	 */
	protected static final MessageReliabilityEnum PERSISTENT_MESSAGE_RELIABILITY_EDEFAULT = MessageReliabilityEnum.NONE_LITERAL;

	/**
	 * The cached value of the '{@link #getPersistentMessageReliability() <em>Persistent Message Reliability</em>}' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see #getPersistentMessageReliability()
	 * @generated
	 * @ordered
	 */
	protected MessageReliabilityEnum persistentMessageReliability = PERSISTENT_MESSAGE_RELIABILITY_EDEFAULT;

	/**
	 * This is true if the Persistent Message Reliability attribute has been set.
	 * <!-- begin-user-doc
	 * --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	protected boolean persistentMessageReliabilityESet;

	/**
	 * The default value of the '{@link #getProviderEndpoints() <em>Provider Endpoints</em>}' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see #getProviderEndpoints()
	 * @generated
	 * @ordered
	 */
	protected static final String PROVIDER_ENDPOINTS_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getProviderEndpoints() <em>Provider Endpoints</em>}' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see #getProviderEndpoints()
	 * @generated
	 * @ordered
	 */
	protected String providerEndpoints = PROVIDER_ENDPOINTS_EDEFAULT;

	/**
	 * The default value of the '{@link #getReadAhead() <em>Read Ahead</em>}' attribute. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see #getReadAhead()
	 * @generated
	 * @ordered
	 */
	protected static final ReadAheadOptimizationEnum READ_AHEAD_EDEFAULT = ReadAheadOptimizationEnum.DEFAULT_LITERAL;

	/**
	 * The cached value of the '{@link #getReadAhead() <em>Read Ahead</em>}' attribute. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see #getReadAhead()
	 * @generated
	 * @ordered
	 */
	protected ReadAheadOptimizationEnum readAhead = READ_AHEAD_EDEFAULT;

	/**
	 * This is true if the Read Ahead attribute has been set.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @generated
	 * @ordered
	 */
	protected boolean readAheadESet;

	/**
	 * The default value of the '{@link #getShareDurableSubscriptions() <em>Share Durable Subscriptions</em>}' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see #getShareDurableSubscriptions()
	 * @generated
	 * @ordered
	 */
	protected static final ShareDurableSubscriptionsEnum SHARE_DURABLE_SUBSCRIPTIONS_EDEFAULT = ShareDurableSubscriptionsEnum.IN_CLUSTER_LITERAL;

	/**
	 * The cached value of the '{@link #getShareDurableSubscriptions() <em>Share Durable Subscriptions</em>}' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see #getShareDurableSubscriptions()
	 * @generated
	 * @ordered
	 */
	protected ShareDurableSubscriptionsEnum shareDurableSubscriptions = SHARE_DURABLE_SUBSCRIPTIONS_EDEFAULT;

	/**
	 * This is true if the Share Durable Subscriptions attribute has been set.
	 * <!-- begin-user-doc
	 * --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	protected boolean shareDurableSubscriptionsESet;

	/**
	 * The default value of the '{@link #getTarget() <em>Target</em>}' attribute. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see #getTarget()
	 * @generated
	 * @ordered
	 */
	protected static final String TARGET_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getTarget() <em>Target</em>}' attribute. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see #getTarget()
	 * @generated
	 * @ordered
	 */
	protected String target = TARGET_EDEFAULT;

	/**
	 * The default value of the '{@link #getTargetInboundTransportChain() <em>Target Inbound Transport Chain</em>}' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see #getTargetInboundTransportChain()
	 * @generated
	 * @ordered
	 */
	protected static final String TARGET_INBOUND_TRANSPORT_CHAIN_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getTargetInboundTransportChain() <em>Target Inbound Transport Chain</em>}' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see #getTargetInboundTransportChain()
	 * @generated
	 * @ordered
	 */
	protected String targetInboundTransportChain = TARGET_INBOUND_TRANSPORT_CHAIN_EDEFAULT;

	/**
	 * The default value of the '{@link #getTargetSignificance() <em>Target Significance</em>}' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see #getTargetSignificance()
	 * @generated
	 * @ordered
	 */
	protected static final CFTargetSignificanceEnum TARGET_SIGNIFICANCE_EDEFAULT = CFTargetSignificanceEnum.PREFERRED_LITERAL;

	/**
	 * The cached value of the '{@link #getTargetSignificance() <em>Target Significance</em>}' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see #getTargetSignificance()
	 * @generated
	 * @ordered
	 */
	protected CFTargetSignificanceEnum targetSignificance = TARGET_SIGNIFICANCE_EDEFAULT;

	/**
	 * This is true if the Target Significance attribute has been set.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @generated
	 * @ordered
	 */
	protected boolean targetSignificanceESet;

	/**
	 * The default value of the '{@link #getTargetType() <em>Target Type</em>}' attribute. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see #getTargetType()
	 * @generated
	 * @ordered
	 */
	protected static final ConnectionFactoryTargetTypeEnum TARGET_TYPE_EDEFAULT = ConnectionFactoryTargetTypeEnum.BUS_MEMBER_LITERAL;

	/**
	 * The cached value of the '{@link #getTargetType() <em>Target Type</em>}' attribute. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see #getTargetType()
	 * @generated
	 * @ordered
	 */
	protected ConnectionFactoryTargetTypeEnum targetType = TARGET_TYPE_EDEFAULT;

	/**
	 * This is true if the Target Type attribute has been set.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @generated
	 * @ordered
	 */
	protected boolean targetTypeESet;

	/**
	 * The default value of the '{@link #getTempQnamePrefix() <em>Temp Qname Prefix</em>}' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see #getTempQnamePrefix()
	 * @generated
	 * @ordered
	 */
	protected static final String TEMP_QNAME_PREFIX_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getTempQnamePrefix() <em>Temp Qname Prefix</em>}' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see #getTempQnamePrefix()
	 * @generated
	 * @ordered
	 */
	protected String tempQnamePrefix = TEMP_QNAME_PREFIX_EDEFAULT;

	/**
	 * The default value of the '{@link #getTempTopicNamePrefix() <em>Temp Topic Name Prefix</em>}' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see #getTempTopicNamePrefix()
	 * @generated
	 * @ordered
	 */
	protected static final String TEMP_TOPIC_NAME_PREFIX_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getTempTopicNamePrefix() <em>Temp Topic Name Prefix</em>}' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see #getTempTopicNamePrefix()
	 * @generated
	 * @ordered
	 */
	protected String tempTopicNamePrefix = TEMP_TOPIC_NAME_PREFIX_EDEFAULT;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	protected WasDefaultMessagingConnectionFactoryConfigurationImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	protected EClass eStaticClass() {
		return WasPackage.Literals.WAS_DEFAULT_MESSAGING_CONNECTION_FACTORY_CONFIGURATION;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public String getCategory() {
		return category;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public void setCategory(String newCategory) {
		String oldCategory = category;
		category = newCategory;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, WasPackage.WAS_DEFAULT_MESSAGING_CONNECTION_FACTORY_CONFIGURATION__CATEGORY, oldCategory, category));
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public String getClientIdentifier() {
		return clientIdentifier;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public void setClientIdentifier(String newClientIdentifier) {
		String oldClientIdentifier = clientIdentifier;
		clientIdentifier = newClientIdentifier;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, WasPackage.WAS_DEFAULT_MESSAGING_CONNECTION_FACTORY_CONFIGURATION__CLIENT_IDENTIFIER, oldClientIdentifier, clientIdentifier));
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public ConnectionProximityEnum getConnectionProximity() {
		return connectionProximity;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public void setConnectionProximity(ConnectionProximityEnum newConnectionProximity) {
		ConnectionProximityEnum oldConnectionProximity = connectionProximity;
		connectionProximity = newConnectionProximity == null ? CONNECTION_PROXIMITY_EDEFAULT : newConnectionProximity;
		boolean oldConnectionProximityESet = connectionProximityESet;
		connectionProximityESet = true;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, WasPackage.WAS_DEFAULT_MESSAGING_CONNECTION_FACTORY_CONFIGURATION__CONNECTION_PROXIMITY, oldConnectionProximity, connectionProximity, !oldConnectionProximityESet));
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public void unsetConnectionProximity() {
		ConnectionProximityEnum oldConnectionProximity = connectionProximity;
		boolean oldConnectionProximityESet = connectionProximityESet;
		connectionProximity = CONNECTION_PROXIMITY_EDEFAULT;
		connectionProximityESet = false;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.UNSET, WasPackage.WAS_DEFAULT_MESSAGING_CONNECTION_FACTORY_CONFIGURATION__CONNECTION_PROXIMITY, oldConnectionProximity, CONNECTION_PROXIMITY_EDEFAULT, oldConnectionProximityESet));
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSetConnectionProximity() {
		return connectionProximityESet;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public String getDurableSubscriptionHome() {
		return durableSubscriptionHome;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public void setDurableSubscriptionHome(String newDurableSubscriptionHome) {
		String oldDurableSubscriptionHome = durableSubscriptionHome;
		durableSubscriptionHome = newDurableSubscriptionHome;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, WasPackage.WAS_DEFAULT_MESSAGING_CONNECTION_FACTORY_CONFIGURATION__DURABLE_SUBSCRIPTION_HOME, oldDurableSubscriptionHome, durableSubscriptionHome));
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public MessageReliabilityEnum getNonpersistentMessageReliability() {
		return nonpersistentMessageReliability;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public void setNonpersistentMessageReliability(
			MessageReliabilityEnum newNonpersistentMessageReliability) {
		MessageReliabilityEnum oldNonpersistentMessageReliability = nonpersistentMessageReliability;
		nonpersistentMessageReliability = newNonpersistentMessageReliability == null ? NONPERSISTENT_MESSAGE_RELIABILITY_EDEFAULT : newNonpersistentMessageReliability;
		boolean oldNonpersistentMessageReliabilityESet = nonpersistentMessageReliabilityESet;
		nonpersistentMessageReliabilityESet = true;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, WasPackage.WAS_DEFAULT_MESSAGING_CONNECTION_FACTORY_CONFIGURATION__NONPERSISTENT_MESSAGE_RELIABILITY, oldNonpersistentMessageReliability, nonpersistentMessageReliability, !oldNonpersistentMessageReliabilityESet));
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public void unsetNonpersistentMessageReliability() {
		MessageReliabilityEnum oldNonpersistentMessageReliability = nonpersistentMessageReliability;
		boolean oldNonpersistentMessageReliabilityESet = nonpersistentMessageReliabilityESet;
		nonpersistentMessageReliability = NONPERSISTENT_MESSAGE_RELIABILITY_EDEFAULT;
		nonpersistentMessageReliabilityESet = false;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.UNSET, WasPackage.WAS_DEFAULT_MESSAGING_CONNECTION_FACTORY_CONFIGURATION__NONPERSISTENT_MESSAGE_RELIABILITY, oldNonpersistentMessageReliability, NONPERSISTENT_MESSAGE_RELIABILITY_EDEFAULT, oldNonpersistentMessageReliabilityESet));
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSetNonpersistentMessageReliability() {
		return nonpersistentMessageReliabilityESet;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public MessageReliabilityEnum getPersistentMessageReliability() {
		return persistentMessageReliability;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public void setPersistentMessageReliability(
			MessageReliabilityEnum newPersistentMessageReliability) {
		MessageReliabilityEnum oldPersistentMessageReliability = persistentMessageReliability;
		persistentMessageReliability = newPersistentMessageReliability == null ? PERSISTENT_MESSAGE_RELIABILITY_EDEFAULT : newPersistentMessageReliability;
		boolean oldPersistentMessageReliabilityESet = persistentMessageReliabilityESet;
		persistentMessageReliabilityESet = true;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, WasPackage.WAS_DEFAULT_MESSAGING_CONNECTION_FACTORY_CONFIGURATION__PERSISTENT_MESSAGE_RELIABILITY, oldPersistentMessageReliability, persistentMessageReliability, !oldPersistentMessageReliabilityESet));
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public void unsetPersistentMessageReliability() {
		MessageReliabilityEnum oldPersistentMessageReliability = persistentMessageReliability;
		boolean oldPersistentMessageReliabilityESet = persistentMessageReliabilityESet;
		persistentMessageReliability = PERSISTENT_MESSAGE_RELIABILITY_EDEFAULT;
		persistentMessageReliabilityESet = false;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.UNSET, WasPackage.WAS_DEFAULT_MESSAGING_CONNECTION_FACTORY_CONFIGURATION__PERSISTENT_MESSAGE_RELIABILITY, oldPersistentMessageReliability, PERSISTENT_MESSAGE_RELIABILITY_EDEFAULT, oldPersistentMessageReliabilityESet));
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSetPersistentMessageReliability() {
		return persistentMessageReliabilityESet;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public String getProviderEndpoints() {
		return providerEndpoints;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public void setProviderEndpoints(String newProviderEndpoints) {
		String oldProviderEndpoints = providerEndpoints;
		providerEndpoints = newProviderEndpoints;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, WasPackage.WAS_DEFAULT_MESSAGING_CONNECTION_FACTORY_CONFIGURATION__PROVIDER_ENDPOINTS, oldProviderEndpoints, providerEndpoints));
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public ReadAheadOptimizationEnum getReadAhead() {
		return readAhead;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public void setReadAhead(ReadAheadOptimizationEnum newReadAhead) {
		ReadAheadOptimizationEnum oldReadAhead = readAhead;
		readAhead = newReadAhead == null ? READ_AHEAD_EDEFAULT : newReadAhead;
		boolean oldReadAheadESet = readAheadESet;
		readAheadESet = true;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, WasPackage.WAS_DEFAULT_MESSAGING_CONNECTION_FACTORY_CONFIGURATION__READ_AHEAD, oldReadAhead, readAhead, !oldReadAheadESet));
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public void unsetReadAhead() {
		ReadAheadOptimizationEnum oldReadAhead = readAhead;
		boolean oldReadAheadESet = readAheadESet;
		readAhead = READ_AHEAD_EDEFAULT;
		readAheadESet = false;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.UNSET, WasPackage.WAS_DEFAULT_MESSAGING_CONNECTION_FACTORY_CONFIGURATION__READ_AHEAD, oldReadAhead, READ_AHEAD_EDEFAULT, oldReadAheadESet));
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSetReadAhead() {
		return readAheadESet;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public ShareDurableSubscriptionsEnum getShareDurableSubscriptions() {
		return shareDurableSubscriptions;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public void setShareDurableSubscriptions(
			ShareDurableSubscriptionsEnum newShareDurableSubscriptions) {
		ShareDurableSubscriptionsEnum oldShareDurableSubscriptions = shareDurableSubscriptions;
		shareDurableSubscriptions = newShareDurableSubscriptions == null ? SHARE_DURABLE_SUBSCRIPTIONS_EDEFAULT : newShareDurableSubscriptions;
		boolean oldShareDurableSubscriptionsESet = shareDurableSubscriptionsESet;
		shareDurableSubscriptionsESet = true;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, WasPackage.WAS_DEFAULT_MESSAGING_CONNECTION_FACTORY_CONFIGURATION__SHARE_DURABLE_SUBSCRIPTIONS, oldShareDurableSubscriptions, shareDurableSubscriptions, !oldShareDurableSubscriptionsESet));
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public void unsetShareDurableSubscriptions() {
		ShareDurableSubscriptionsEnum oldShareDurableSubscriptions = shareDurableSubscriptions;
		boolean oldShareDurableSubscriptionsESet = shareDurableSubscriptionsESet;
		shareDurableSubscriptions = SHARE_DURABLE_SUBSCRIPTIONS_EDEFAULT;
		shareDurableSubscriptionsESet = false;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.UNSET, WasPackage.WAS_DEFAULT_MESSAGING_CONNECTION_FACTORY_CONFIGURATION__SHARE_DURABLE_SUBSCRIPTIONS, oldShareDurableSubscriptions, SHARE_DURABLE_SUBSCRIPTIONS_EDEFAULT, oldShareDurableSubscriptionsESet));
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSetShareDurableSubscriptions() {
		return shareDurableSubscriptionsESet;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public String getTarget() {
		return target;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public void setTarget(String newTarget) {
		String oldTarget = target;
		target = newTarget;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, WasPackage.WAS_DEFAULT_MESSAGING_CONNECTION_FACTORY_CONFIGURATION__TARGET, oldTarget, target));
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public String getTargetInboundTransportChain() {
		return targetInboundTransportChain;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public void setTargetInboundTransportChain(String newTargetInboundTransportChain) {
		String oldTargetInboundTransportChain = targetInboundTransportChain;
		targetInboundTransportChain = newTargetInboundTransportChain;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, WasPackage.WAS_DEFAULT_MESSAGING_CONNECTION_FACTORY_CONFIGURATION__TARGET_INBOUND_TRANSPORT_CHAIN, oldTargetInboundTransportChain, targetInboundTransportChain));
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public CFTargetSignificanceEnum getTargetSignificance() {
		return targetSignificance;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public void setTargetSignificance(CFTargetSignificanceEnum newTargetSignificance) {
		CFTargetSignificanceEnum oldTargetSignificance = targetSignificance;
		targetSignificance = newTargetSignificance == null ? TARGET_SIGNIFICANCE_EDEFAULT : newTargetSignificance;
		boolean oldTargetSignificanceESet = targetSignificanceESet;
		targetSignificanceESet = true;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, WasPackage.WAS_DEFAULT_MESSAGING_CONNECTION_FACTORY_CONFIGURATION__TARGET_SIGNIFICANCE, oldTargetSignificance, targetSignificance, !oldTargetSignificanceESet));
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public void unsetTargetSignificance() {
		CFTargetSignificanceEnum oldTargetSignificance = targetSignificance;
		boolean oldTargetSignificanceESet = targetSignificanceESet;
		targetSignificance = TARGET_SIGNIFICANCE_EDEFAULT;
		targetSignificanceESet = false;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.UNSET, WasPackage.WAS_DEFAULT_MESSAGING_CONNECTION_FACTORY_CONFIGURATION__TARGET_SIGNIFICANCE, oldTargetSignificance, TARGET_SIGNIFICANCE_EDEFAULT, oldTargetSignificanceESet));
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSetTargetSignificance() {
		return targetSignificanceESet;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public ConnectionFactoryTargetTypeEnum getTargetType() {
		return targetType;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public void setTargetType(ConnectionFactoryTargetTypeEnum newTargetType) {
		ConnectionFactoryTargetTypeEnum oldTargetType = targetType;
		targetType = newTargetType == null ? TARGET_TYPE_EDEFAULT : newTargetType;
		boolean oldTargetTypeESet = targetTypeESet;
		targetTypeESet = true;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, WasPackage.WAS_DEFAULT_MESSAGING_CONNECTION_FACTORY_CONFIGURATION__TARGET_TYPE, oldTargetType, targetType, !oldTargetTypeESet));
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public void unsetTargetType() {
		ConnectionFactoryTargetTypeEnum oldTargetType = targetType;
		boolean oldTargetTypeESet = targetTypeESet;
		targetType = TARGET_TYPE_EDEFAULT;
		targetTypeESet = false;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.UNSET, WasPackage.WAS_DEFAULT_MESSAGING_CONNECTION_FACTORY_CONFIGURATION__TARGET_TYPE, oldTargetType, TARGET_TYPE_EDEFAULT, oldTargetTypeESet));
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSetTargetType() {
		return targetTypeESet;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public String getTempQnamePrefix() {
		return tempQnamePrefix;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public void setTempQnamePrefix(String newTempQnamePrefix) {
		String oldTempQnamePrefix = tempQnamePrefix;
		tempQnamePrefix = newTempQnamePrefix;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, WasPackage.WAS_DEFAULT_MESSAGING_CONNECTION_FACTORY_CONFIGURATION__TEMP_QNAME_PREFIX, oldTempQnamePrefix, tempQnamePrefix));
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public String getTempTopicNamePrefix() {
		return tempTopicNamePrefix;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public void setTempTopicNamePrefix(String newTempTopicNamePrefix) {
		String oldTempTopicNamePrefix = tempTopicNamePrefix;
		tempTopicNamePrefix = newTempTopicNamePrefix;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, WasPackage.WAS_DEFAULT_MESSAGING_CONNECTION_FACTORY_CONFIGURATION__TEMP_TOPIC_NAME_PREFIX, oldTempTopicNamePrefix, tempTopicNamePrefix));
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case WasPackage.WAS_DEFAULT_MESSAGING_CONNECTION_FACTORY_CONFIGURATION__CATEGORY:
				return getCategory();
			case WasPackage.WAS_DEFAULT_MESSAGING_CONNECTION_FACTORY_CONFIGURATION__CLIENT_IDENTIFIER:
				return getClientIdentifier();
			case WasPackage.WAS_DEFAULT_MESSAGING_CONNECTION_FACTORY_CONFIGURATION__CONNECTION_PROXIMITY:
				return getConnectionProximity();
			case WasPackage.WAS_DEFAULT_MESSAGING_CONNECTION_FACTORY_CONFIGURATION__DURABLE_SUBSCRIPTION_HOME:
				return getDurableSubscriptionHome();
			case WasPackage.WAS_DEFAULT_MESSAGING_CONNECTION_FACTORY_CONFIGURATION__NONPERSISTENT_MESSAGE_RELIABILITY:
				return getNonpersistentMessageReliability();
			case WasPackage.WAS_DEFAULT_MESSAGING_CONNECTION_FACTORY_CONFIGURATION__PERSISTENT_MESSAGE_RELIABILITY:
				return getPersistentMessageReliability();
			case WasPackage.WAS_DEFAULT_MESSAGING_CONNECTION_FACTORY_CONFIGURATION__PROVIDER_ENDPOINTS:
				return getProviderEndpoints();
			case WasPackage.WAS_DEFAULT_MESSAGING_CONNECTION_FACTORY_CONFIGURATION__READ_AHEAD:
				return getReadAhead();
			case WasPackage.WAS_DEFAULT_MESSAGING_CONNECTION_FACTORY_CONFIGURATION__SHARE_DURABLE_SUBSCRIPTIONS:
				return getShareDurableSubscriptions();
			case WasPackage.WAS_DEFAULT_MESSAGING_CONNECTION_FACTORY_CONFIGURATION__TARGET:
				return getTarget();
			case WasPackage.WAS_DEFAULT_MESSAGING_CONNECTION_FACTORY_CONFIGURATION__TARGET_INBOUND_TRANSPORT_CHAIN:
				return getTargetInboundTransportChain();
			case WasPackage.WAS_DEFAULT_MESSAGING_CONNECTION_FACTORY_CONFIGURATION__TARGET_SIGNIFICANCE:
				return getTargetSignificance();
			case WasPackage.WAS_DEFAULT_MESSAGING_CONNECTION_FACTORY_CONFIGURATION__TARGET_TYPE:
				return getTargetType();
			case WasPackage.WAS_DEFAULT_MESSAGING_CONNECTION_FACTORY_CONFIGURATION__TEMP_QNAME_PREFIX:
				return getTempQnamePrefix();
			case WasPackage.WAS_DEFAULT_MESSAGING_CONNECTION_FACTORY_CONFIGURATION__TEMP_TOPIC_NAME_PREFIX:
				return getTempTopicNamePrefix();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
			case WasPackage.WAS_DEFAULT_MESSAGING_CONNECTION_FACTORY_CONFIGURATION__CATEGORY:
				setCategory((String)newValue);
				return;
			case WasPackage.WAS_DEFAULT_MESSAGING_CONNECTION_FACTORY_CONFIGURATION__CLIENT_IDENTIFIER:
				setClientIdentifier((String)newValue);
				return;
			case WasPackage.WAS_DEFAULT_MESSAGING_CONNECTION_FACTORY_CONFIGURATION__CONNECTION_PROXIMITY:
				setConnectionProximity((ConnectionProximityEnum)newValue);
				return;
			case WasPackage.WAS_DEFAULT_MESSAGING_CONNECTION_FACTORY_CONFIGURATION__DURABLE_SUBSCRIPTION_HOME:
				setDurableSubscriptionHome((String)newValue);
				return;
			case WasPackage.WAS_DEFAULT_MESSAGING_CONNECTION_FACTORY_CONFIGURATION__NONPERSISTENT_MESSAGE_RELIABILITY:
				setNonpersistentMessageReliability((MessageReliabilityEnum)newValue);
				return;
			case WasPackage.WAS_DEFAULT_MESSAGING_CONNECTION_FACTORY_CONFIGURATION__PERSISTENT_MESSAGE_RELIABILITY:
				setPersistentMessageReliability((MessageReliabilityEnum)newValue);
				return;
			case WasPackage.WAS_DEFAULT_MESSAGING_CONNECTION_FACTORY_CONFIGURATION__PROVIDER_ENDPOINTS:
				setProviderEndpoints((String)newValue);
				return;
			case WasPackage.WAS_DEFAULT_MESSAGING_CONNECTION_FACTORY_CONFIGURATION__READ_AHEAD:
				setReadAhead((ReadAheadOptimizationEnum)newValue);
				return;
			case WasPackage.WAS_DEFAULT_MESSAGING_CONNECTION_FACTORY_CONFIGURATION__SHARE_DURABLE_SUBSCRIPTIONS:
				setShareDurableSubscriptions((ShareDurableSubscriptionsEnum)newValue);
				return;
			case WasPackage.WAS_DEFAULT_MESSAGING_CONNECTION_FACTORY_CONFIGURATION__TARGET:
				setTarget((String)newValue);
				return;
			case WasPackage.WAS_DEFAULT_MESSAGING_CONNECTION_FACTORY_CONFIGURATION__TARGET_INBOUND_TRANSPORT_CHAIN:
				setTargetInboundTransportChain((String)newValue);
				return;
			case WasPackage.WAS_DEFAULT_MESSAGING_CONNECTION_FACTORY_CONFIGURATION__TARGET_SIGNIFICANCE:
				setTargetSignificance((CFTargetSignificanceEnum)newValue);
				return;
			case WasPackage.WAS_DEFAULT_MESSAGING_CONNECTION_FACTORY_CONFIGURATION__TARGET_TYPE:
				setTargetType((ConnectionFactoryTargetTypeEnum)newValue);
				return;
			case WasPackage.WAS_DEFAULT_MESSAGING_CONNECTION_FACTORY_CONFIGURATION__TEMP_QNAME_PREFIX:
				setTempQnamePrefix((String)newValue);
				return;
			case WasPackage.WAS_DEFAULT_MESSAGING_CONNECTION_FACTORY_CONFIGURATION__TEMP_TOPIC_NAME_PREFIX:
				setTempTopicNamePrefix((String)newValue);
				return;
		}
		super.eSet(featureID, newValue);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public void eUnset(int featureID) {
		switch (featureID) {
			case WasPackage.WAS_DEFAULT_MESSAGING_CONNECTION_FACTORY_CONFIGURATION__CATEGORY:
				setCategory(CATEGORY_EDEFAULT);
				return;
			case WasPackage.WAS_DEFAULT_MESSAGING_CONNECTION_FACTORY_CONFIGURATION__CLIENT_IDENTIFIER:
				setClientIdentifier(CLIENT_IDENTIFIER_EDEFAULT);
				return;
			case WasPackage.WAS_DEFAULT_MESSAGING_CONNECTION_FACTORY_CONFIGURATION__CONNECTION_PROXIMITY:
				unsetConnectionProximity();
				return;
			case WasPackage.WAS_DEFAULT_MESSAGING_CONNECTION_FACTORY_CONFIGURATION__DURABLE_SUBSCRIPTION_HOME:
				setDurableSubscriptionHome(DURABLE_SUBSCRIPTION_HOME_EDEFAULT);
				return;
			case WasPackage.WAS_DEFAULT_MESSAGING_CONNECTION_FACTORY_CONFIGURATION__NONPERSISTENT_MESSAGE_RELIABILITY:
				unsetNonpersistentMessageReliability();
				return;
			case WasPackage.WAS_DEFAULT_MESSAGING_CONNECTION_FACTORY_CONFIGURATION__PERSISTENT_MESSAGE_RELIABILITY:
				unsetPersistentMessageReliability();
				return;
			case WasPackage.WAS_DEFAULT_MESSAGING_CONNECTION_FACTORY_CONFIGURATION__PROVIDER_ENDPOINTS:
				setProviderEndpoints(PROVIDER_ENDPOINTS_EDEFAULT);
				return;
			case WasPackage.WAS_DEFAULT_MESSAGING_CONNECTION_FACTORY_CONFIGURATION__READ_AHEAD:
				unsetReadAhead();
				return;
			case WasPackage.WAS_DEFAULT_MESSAGING_CONNECTION_FACTORY_CONFIGURATION__SHARE_DURABLE_SUBSCRIPTIONS:
				unsetShareDurableSubscriptions();
				return;
			case WasPackage.WAS_DEFAULT_MESSAGING_CONNECTION_FACTORY_CONFIGURATION__TARGET:
				setTarget(TARGET_EDEFAULT);
				return;
			case WasPackage.WAS_DEFAULT_MESSAGING_CONNECTION_FACTORY_CONFIGURATION__TARGET_INBOUND_TRANSPORT_CHAIN:
				setTargetInboundTransportChain(TARGET_INBOUND_TRANSPORT_CHAIN_EDEFAULT);
				return;
			case WasPackage.WAS_DEFAULT_MESSAGING_CONNECTION_FACTORY_CONFIGURATION__TARGET_SIGNIFICANCE:
				unsetTargetSignificance();
				return;
			case WasPackage.WAS_DEFAULT_MESSAGING_CONNECTION_FACTORY_CONFIGURATION__TARGET_TYPE:
				unsetTargetType();
				return;
			case WasPackage.WAS_DEFAULT_MESSAGING_CONNECTION_FACTORY_CONFIGURATION__TEMP_QNAME_PREFIX:
				setTempQnamePrefix(TEMP_QNAME_PREFIX_EDEFAULT);
				return;
			case WasPackage.WAS_DEFAULT_MESSAGING_CONNECTION_FACTORY_CONFIGURATION__TEMP_TOPIC_NAME_PREFIX:
				setTempTopicNamePrefix(TEMP_TOPIC_NAME_PREFIX_EDEFAULT);
				return;
		}
		super.eUnset(featureID);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public boolean eIsSet(int featureID) {
		switch (featureID) {
			case WasPackage.WAS_DEFAULT_MESSAGING_CONNECTION_FACTORY_CONFIGURATION__CATEGORY:
				return CATEGORY_EDEFAULT == null ? category != null : !CATEGORY_EDEFAULT.equals(category);
			case WasPackage.WAS_DEFAULT_MESSAGING_CONNECTION_FACTORY_CONFIGURATION__CLIENT_IDENTIFIER:
				return CLIENT_IDENTIFIER_EDEFAULT == null ? clientIdentifier != null : !CLIENT_IDENTIFIER_EDEFAULT.equals(clientIdentifier);
			case WasPackage.WAS_DEFAULT_MESSAGING_CONNECTION_FACTORY_CONFIGURATION__CONNECTION_PROXIMITY:
				return isSetConnectionProximity();
			case WasPackage.WAS_DEFAULT_MESSAGING_CONNECTION_FACTORY_CONFIGURATION__DURABLE_SUBSCRIPTION_HOME:
				return DURABLE_SUBSCRIPTION_HOME_EDEFAULT == null ? durableSubscriptionHome != null : !DURABLE_SUBSCRIPTION_HOME_EDEFAULT.equals(durableSubscriptionHome);
			case WasPackage.WAS_DEFAULT_MESSAGING_CONNECTION_FACTORY_CONFIGURATION__NONPERSISTENT_MESSAGE_RELIABILITY:
				return isSetNonpersistentMessageReliability();
			case WasPackage.WAS_DEFAULT_MESSAGING_CONNECTION_FACTORY_CONFIGURATION__PERSISTENT_MESSAGE_RELIABILITY:
				return isSetPersistentMessageReliability();
			case WasPackage.WAS_DEFAULT_MESSAGING_CONNECTION_FACTORY_CONFIGURATION__PROVIDER_ENDPOINTS:
				return PROVIDER_ENDPOINTS_EDEFAULT == null ? providerEndpoints != null : !PROVIDER_ENDPOINTS_EDEFAULT.equals(providerEndpoints);
			case WasPackage.WAS_DEFAULT_MESSAGING_CONNECTION_FACTORY_CONFIGURATION__READ_AHEAD:
				return isSetReadAhead();
			case WasPackage.WAS_DEFAULT_MESSAGING_CONNECTION_FACTORY_CONFIGURATION__SHARE_DURABLE_SUBSCRIPTIONS:
				return isSetShareDurableSubscriptions();
			case WasPackage.WAS_DEFAULT_MESSAGING_CONNECTION_FACTORY_CONFIGURATION__TARGET:
				return TARGET_EDEFAULT == null ? target != null : !TARGET_EDEFAULT.equals(target);
			case WasPackage.WAS_DEFAULT_MESSAGING_CONNECTION_FACTORY_CONFIGURATION__TARGET_INBOUND_TRANSPORT_CHAIN:
				return TARGET_INBOUND_TRANSPORT_CHAIN_EDEFAULT == null ? targetInboundTransportChain != null : !TARGET_INBOUND_TRANSPORT_CHAIN_EDEFAULT.equals(targetInboundTransportChain);
			case WasPackage.WAS_DEFAULT_MESSAGING_CONNECTION_FACTORY_CONFIGURATION__TARGET_SIGNIFICANCE:
				return isSetTargetSignificance();
			case WasPackage.WAS_DEFAULT_MESSAGING_CONNECTION_FACTORY_CONFIGURATION__TARGET_TYPE:
				return isSetTargetType();
			case WasPackage.WAS_DEFAULT_MESSAGING_CONNECTION_FACTORY_CONFIGURATION__TEMP_QNAME_PREFIX:
				return TEMP_QNAME_PREFIX_EDEFAULT == null ? tempQnamePrefix != null : !TEMP_QNAME_PREFIX_EDEFAULT.equals(tempQnamePrefix);
			case WasPackage.WAS_DEFAULT_MESSAGING_CONNECTION_FACTORY_CONFIGURATION__TEMP_TOPIC_NAME_PREFIX:
				return TEMP_TOPIC_NAME_PREFIX_EDEFAULT == null ? tempTopicNamePrefix != null : !TEMP_TOPIC_NAME_PREFIX_EDEFAULT.equals(tempTopicNamePrefix);
		}
		return super.eIsSet(featureID);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public String toString() {
		if (eIsProxy()) return super.toString();

		StringBuffer result = new StringBuffer(super.toString());
		result.append(" (category: "); //$NON-NLS-1$
		result.append(category);
		result.append(", clientIdentifier: "); //$NON-NLS-1$
		result.append(clientIdentifier);
		result.append(", connectionProximity: "); //$NON-NLS-1$
		if (connectionProximityESet) result.append(connectionProximity); else result.append("<unset>"); //$NON-NLS-1$
		result.append(", durableSubscriptionHome: "); //$NON-NLS-1$
		result.append(durableSubscriptionHome);
		result.append(", nonpersistentMessageReliability: "); //$NON-NLS-1$
		if (nonpersistentMessageReliabilityESet) result.append(nonpersistentMessageReliability); else result.append("<unset>"); //$NON-NLS-1$
		result.append(", persistentMessageReliability: "); //$NON-NLS-1$
		if (persistentMessageReliabilityESet) result.append(persistentMessageReliability); else result.append("<unset>"); //$NON-NLS-1$
		result.append(", providerEndpoints: "); //$NON-NLS-1$
		result.append(providerEndpoints);
		result.append(", readAhead: "); //$NON-NLS-1$
		if (readAheadESet) result.append(readAhead); else result.append("<unset>"); //$NON-NLS-1$
		result.append(", shareDurableSubscriptions: "); //$NON-NLS-1$
		if (shareDurableSubscriptionsESet) result.append(shareDurableSubscriptions); else result.append("<unset>"); //$NON-NLS-1$
		result.append(", target: "); //$NON-NLS-1$
		result.append(target);
		result.append(", targetInboundTransportChain: "); //$NON-NLS-1$
		result.append(targetInboundTransportChain);
		result.append(", targetSignificance: "); //$NON-NLS-1$
		if (targetSignificanceESet) result.append(targetSignificance); else result.append("<unset>"); //$NON-NLS-1$
		result.append(", targetType: "); //$NON-NLS-1$
		if (targetTypeESet) result.append(targetType); else result.append("<unset>"); //$NON-NLS-1$
		result.append(", tempQnamePrefix: "); //$NON-NLS-1$
		result.append(tempQnamePrefix);
		result.append(", tempTopicNamePrefix: "); //$NON-NLS-1$
		result.append(tempTopicNamePrefix);
		result.append(')');
		return result.toString();
	}

} //WasDefaultMessagingConnectionFactoryConfigurationImpl
