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
import com.ibm.ccl.soa.deploy.mq.MQTopicDestination;
import com.ibm.ccl.soa.deploy.mq.MqPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>MQ Topic Destination</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link com.ibm.ccl.soa.deploy.mq.impl.MQTopicDestinationImpl#getBaseTopicName <em>Base Topic Name</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.mq.impl.MQTopicDestinationImpl#getBrokerCCDurableSubscriptionQueue <em>Broker CC Durable Subscription Queue</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.mq.impl.MQTopicDestinationImpl#getBrokerDurableSubscriptionQueue <em>Broker Durable Subscription Queue</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.mq.impl.MQTopicDestinationImpl#getCategory <em>Category</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.mq.impl.MQTopicDestinationImpl#getDecimalEncoding <em>Decimal Encoding</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.mq.impl.MQTopicDestinationImpl#getDescription1 <em>Description1</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.mq.impl.MQTopicDestinationImpl#getDestinationName <em>Destination Name</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.mq.impl.MQTopicDestinationImpl#getEnableMulticastTransport <em>Enable Multicast Transport</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.mq.impl.MQTopicDestinationImpl#getExpiry <em>Expiry</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.mq.impl.MQTopicDestinationImpl#getFloatingPointEncoding <em>Floating Point Encoding</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.mq.impl.MQTopicDestinationImpl#getIntegerEncoding <em>Integer Encoding</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.mq.impl.MQTopicDestinationImpl#getJndiName <em>Jndi Name</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.mq.impl.MQTopicDestinationImpl#getPersitence <em>Persitence</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.mq.impl.MQTopicDestinationImpl#getPriority <em>Priority</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.mq.impl.MQTopicDestinationImpl#getSpecifiedExpiry <em>Specified Expiry</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.mq.impl.MQTopicDestinationImpl#getSpecifiedPriority <em>Specified Priority</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.mq.impl.MQTopicDestinationImpl#getTargetClient <em>Target Client</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.mq.impl.MQTopicDestinationImpl#getUseNativeEncoding <em>Use Native Encoding</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class MQTopicDestinationImpl extends CapabilityImpl implements MQTopicDestination {
	/**
	 * The default value of the '{@link #getBaseTopicName() <em>Base Topic Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getBaseTopicName()
	 * @generated
	 * @ordered
	 */
	protected static final String BASE_TOPIC_NAME_EDEFAULT = null;
	/**
	 * The cached value of the '{@link #getBaseTopicName() <em>Base Topic Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getBaseTopicName()
	 * @generated
	 * @ordered
	 */
	protected String baseTopicName = BASE_TOPIC_NAME_EDEFAULT;
	/**
	 * The default value of the '{@link #getBrokerCCDurableSubscriptionQueue() <em>Broker CC Durable Subscription Queue</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getBrokerCCDurableSubscriptionQueue()
	 * @generated
	 * @ordered
	 */
	protected static final String BROKER_CC_DURABLE_SUBSCRIPTION_QUEUE_EDEFAULT = null;
	/**
	 * The cached value of the '{@link #getBrokerCCDurableSubscriptionQueue() <em>Broker CC Durable Subscription Queue</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getBrokerCCDurableSubscriptionQueue()
	 * @generated
	 * @ordered
	 */
	protected String brokerCCDurableSubscriptionQueue = BROKER_CC_DURABLE_SUBSCRIPTION_QUEUE_EDEFAULT;
	/**
	 * The default value of the '{@link #getBrokerDurableSubscriptionQueue() <em>Broker Durable Subscription Queue</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getBrokerDurableSubscriptionQueue()
	 * @generated
	 * @ordered
	 */
	protected static final String BROKER_DURABLE_SUBSCRIPTION_QUEUE_EDEFAULT = null;
	/**
	 * The cached value of the '{@link #getBrokerDurableSubscriptionQueue() <em>Broker Durable Subscription Queue</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getBrokerDurableSubscriptionQueue()
	 * @generated
	 * @ordered
	 */
	protected String brokerDurableSubscriptionQueue = BROKER_DURABLE_SUBSCRIPTION_QUEUE_EDEFAULT;
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
	 * The default value of the '{@link #getDecimalEncoding() <em>Decimal Encoding</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDecimalEncoding()
	 * @generated
	 * @ordered
	 */
	protected static final String DECIMAL_ENCODING_EDEFAULT = null;
	/**
	 * The cached value of the '{@link #getDecimalEncoding() <em>Decimal Encoding</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDecimalEncoding()
	 * @generated
	 * @ordered
	 */
	protected String decimalEncoding = DECIMAL_ENCODING_EDEFAULT;
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
	 * The default value of the '{@link #getDestinationName() <em>Destination Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDestinationName()
	 * @generated
	 * @ordered
	 */
	protected static final String DESTINATION_NAME_EDEFAULT = null;
	/**
	 * The cached value of the '{@link #getDestinationName() <em>Destination Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDestinationName()
	 * @generated
	 * @ordered
	 */
	protected String destinationName = DESTINATION_NAME_EDEFAULT;
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
	 * The default value of the '{@link #getExpiry() <em>Expiry</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getExpiry()
	 * @generated
	 * @ordered
	 */
	protected static final String EXPIRY_EDEFAULT = null;
	/**
	 * The cached value of the '{@link #getExpiry() <em>Expiry</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getExpiry()
	 * @generated
	 * @ordered
	 */
	protected String expiry = EXPIRY_EDEFAULT;
	/**
	 * The default value of the '{@link #getFloatingPointEncoding() <em>Floating Point Encoding</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getFloatingPointEncoding()
	 * @generated
	 * @ordered
	 */
	protected static final String FLOATING_POINT_ENCODING_EDEFAULT = null;
	/**
	 * The cached value of the '{@link #getFloatingPointEncoding() <em>Floating Point Encoding</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getFloatingPointEncoding()
	 * @generated
	 * @ordered
	 */
	protected String floatingPointEncoding = FLOATING_POINT_ENCODING_EDEFAULT;
	/**
	 * The default value of the '{@link #getIntegerEncoding() <em>Integer Encoding</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getIntegerEncoding()
	 * @generated
	 * @ordered
	 */
	protected static final String INTEGER_ENCODING_EDEFAULT = null;
	/**
	 * The cached value of the '{@link #getIntegerEncoding() <em>Integer Encoding</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getIntegerEncoding()
	 * @generated
	 * @ordered
	 */
	protected String integerEncoding = INTEGER_ENCODING_EDEFAULT;
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
	 * The default value of the '{@link #getPersitence() <em>Persitence</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getPersitence()
	 * @generated
	 * @ordered
	 */
	protected static final String PERSITENCE_EDEFAULT = null;
	/**
	 * The cached value of the '{@link #getPersitence() <em>Persitence</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getPersitence()
	 * @generated
	 * @ordered
	 */
	protected String persitence = PERSITENCE_EDEFAULT;
	/**
	 * The default value of the '{@link #getPriority() <em>Priority</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getPriority()
	 * @generated
	 * @ordered
	 */
	protected static final String PRIORITY_EDEFAULT = null;
	/**
	 * The cached value of the '{@link #getPriority() <em>Priority</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getPriority()
	 * @generated
	 * @ordered
	 */
	protected String priority = PRIORITY_EDEFAULT;
	/**
	 * The default value of the '{@link #getSpecifiedExpiry() <em>Specified Expiry</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSpecifiedExpiry()
	 * @generated
	 * @ordered
	 */
	protected static final String SPECIFIED_EXPIRY_EDEFAULT = null;
	/**
	 * The cached value of the '{@link #getSpecifiedExpiry() <em>Specified Expiry</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSpecifiedExpiry()
	 * @generated
	 * @ordered
	 */
	protected String specifiedExpiry = SPECIFIED_EXPIRY_EDEFAULT;
	/**
	 * The default value of the '{@link #getSpecifiedPriority() <em>Specified Priority</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSpecifiedPriority()
	 * @generated
	 * @ordered
	 */
	protected static final String SPECIFIED_PRIORITY_EDEFAULT = null;
	/**
	 * The cached value of the '{@link #getSpecifiedPriority() <em>Specified Priority</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSpecifiedPriority()
	 * @generated
	 * @ordered
	 */
	protected String specifiedPriority = SPECIFIED_PRIORITY_EDEFAULT;
	/**
	 * The default value of the '{@link #getTargetClient() <em>Target Client</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTargetClient()
	 * @generated
	 * @ordered
	 */
	protected static final String TARGET_CLIENT_EDEFAULT = null;
	/**
	 * The cached value of the '{@link #getTargetClient() <em>Target Client</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTargetClient()
	 * @generated
	 * @ordered
	 */
	protected String targetClient = TARGET_CLIENT_EDEFAULT;
	/**
	 * The default value of the '{@link #getUseNativeEncoding() <em>Use Native Encoding</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getUseNativeEncoding()
	 * @generated
	 * @ordered
	 */
	protected static final String USE_NATIVE_ENCODING_EDEFAULT = null;
	/**
	 * The cached value of the '{@link #getUseNativeEncoding() <em>Use Native Encoding</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getUseNativeEncoding()
	 * @generated
	 * @ordered
	 */
	protected String useNativeEncoding = USE_NATIVE_ENCODING_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected MQTopicDestinationImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected EClass eStaticClass() {
		return MqPackage.Literals.MQ_TOPIC_DESTINATION;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getBaseTopicName() {
		return baseTopicName;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setBaseTopicName(String newBaseTopicName) {
		String oldBaseTopicName = baseTopicName;
		baseTopicName = newBaseTopicName;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, MqPackage.MQ_TOPIC_DESTINATION__BASE_TOPIC_NAME, oldBaseTopicName, baseTopicName));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getBrokerCCDurableSubscriptionQueue() {
		return brokerCCDurableSubscriptionQueue;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setBrokerCCDurableSubscriptionQueue(String newBrokerCCDurableSubscriptionQueue) {
		String oldBrokerCCDurableSubscriptionQueue = brokerCCDurableSubscriptionQueue;
		brokerCCDurableSubscriptionQueue = newBrokerCCDurableSubscriptionQueue;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, MqPackage.MQ_TOPIC_DESTINATION__BROKER_CC_DURABLE_SUBSCRIPTION_QUEUE, oldBrokerCCDurableSubscriptionQueue, brokerCCDurableSubscriptionQueue));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getBrokerDurableSubscriptionQueue() {
		return brokerDurableSubscriptionQueue;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setBrokerDurableSubscriptionQueue(String newBrokerDurableSubscriptionQueue) {
		String oldBrokerDurableSubscriptionQueue = brokerDurableSubscriptionQueue;
		brokerDurableSubscriptionQueue = newBrokerDurableSubscriptionQueue;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, MqPackage.MQ_TOPIC_DESTINATION__BROKER_DURABLE_SUBSCRIPTION_QUEUE, oldBrokerDurableSubscriptionQueue, brokerDurableSubscriptionQueue));
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
			eNotify(new ENotificationImpl(this, Notification.SET, MqPackage.MQ_TOPIC_DESTINATION__CATEGORY, oldCategory, category));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getDecimalEncoding() {
		return decimalEncoding;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setDecimalEncoding(String newDecimalEncoding) {
		String oldDecimalEncoding = decimalEncoding;
		decimalEncoding = newDecimalEncoding;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, MqPackage.MQ_TOPIC_DESTINATION__DECIMAL_ENCODING, oldDecimalEncoding, decimalEncoding));
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
			eNotify(new ENotificationImpl(this, Notification.SET, MqPackage.MQ_TOPIC_DESTINATION__DESCRIPTION1, oldDescription1, description1));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getDestinationName() {
		return destinationName;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setDestinationName(String newDestinationName) {
		String oldDestinationName = destinationName;
		destinationName = newDestinationName;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, MqPackage.MQ_TOPIC_DESTINATION__DESTINATION_NAME, oldDestinationName, destinationName));
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
			eNotify(new ENotificationImpl(this, Notification.SET, MqPackage.MQ_TOPIC_DESTINATION__ENABLE_MULTICAST_TRANSPORT, oldEnableMulticastTransport, enableMulticastTransport));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getExpiry() {
		return expiry;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setExpiry(String newExpiry) {
		String oldExpiry = expiry;
		expiry = newExpiry;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, MqPackage.MQ_TOPIC_DESTINATION__EXPIRY, oldExpiry, expiry));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getFloatingPointEncoding() {
		return floatingPointEncoding;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setFloatingPointEncoding(String newFloatingPointEncoding) {
		String oldFloatingPointEncoding = floatingPointEncoding;
		floatingPointEncoding = newFloatingPointEncoding;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, MqPackage.MQ_TOPIC_DESTINATION__FLOATING_POINT_ENCODING, oldFloatingPointEncoding, floatingPointEncoding));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getIntegerEncoding() {
		return integerEncoding;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setIntegerEncoding(String newIntegerEncoding) {
		String oldIntegerEncoding = integerEncoding;
		integerEncoding = newIntegerEncoding;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, MqPackage.MQ_TOPIC_DESTINATION__INTEGER_ENCODING, oldIntegerEncoding, integerEncoding));
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
			eNotify(new ENotificationImpl(this, Notification.SET, MqPackage.MQ_TOPIC_DESTINATION__JNDI_NAME, oldJndiName, jndiName));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getPersitence() {
		return persitence;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setPersitence(String newPersitence) {
		String oldPersitence = persitence;
		persitence = newPersitence;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, MqPackage.MQ_TOPIC_DESTINATION__PERSITENCE, oldPersitence, persitence));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getPriority() {
		return priority;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setPriority(String newPriority) {
		String oldPriority = priority;
		priority = newPriority;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, MqPackage.MQ_TOPIC_DESTINATION__PRIORITY, oldPriority, priority));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getSpecifiedExpiry() {
		return specifiedExpiry;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setSpecifiedExpiry(String newSpecifiedExpiry) {
		String oldSpecifiedExpiry = specifiedExpiry;
		specifiedExpiry = newSpecifiedExpiry;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, MqPackage.MQ_TOPIC_DESTINATION__SPECIFIED_EXPIRY, oldSpecifiedExpiry, specifiedExpiry));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getSpecifiedPriority() {
		return specifiedPriority;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setSpecifiedPriority(String newSpecifiedPriority) {
		String oldSpecifiedPriority = specifiedPriority;
		specifiedPriority = newSpecifiedPriority;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, MqPackage.MQ_TOPIC_DESTINATION__SPECIFIED_PRIORITY, oldSpecifiedPriority, specifiedPriority));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getTargetClient() {
		return targetClient;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setTargetClient(String newTargetClient) {
		String oldTargetClient = targetClient;
		targetClient = newTargetClient;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, MqPackage.MQ_TOPIC_DESTINATION__TARGET_CLIENT, oldTargetClient, targetClient));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getUseNativeEncoding() {
		return useNativeEncoding;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setUseNativeEncoding(String newUseNativeEncoding) {
		String oldUseNativeEncoding = useNativeEncoding;
		useNativeEncoding = newUseNativeEncoding;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, MqPackage.MQ_TOPIC_DESTINATION__USE_NATIVE_ENCODING, oldUseNativeEncoding, useNativeEncoding));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case MqPackage.MQ_TOPIC_DESTINATION__BASE_TOPIC_NAME:
				return getBaseTopicName();
			case MqPackage.MQ_TOPIC_DESTINATION__BROKER_CC_DURABLE_SUBSCRIPTION_QUEUE:
				return getBrokerCCDurableSubscriptionQueue();
			case MqPackage.MQ_TOPIC_DESTINATION__BROKER_DURABLE_SUBSCRIPTION_QUEUE:
				return getBrokerDurableSubscriptionQueue();
			case MqPackage.MQ_TOPIC_DESTINATION__CATEGORY:
				return getCategory();
			case MqPackage.MQ_TOPIC_DESTINATION__DECIMAL_ENCODING:
				return getDecimalEncoding();
			case MqPackage.MQ_TOPIC_DESTINATION__DESCRIPTION1:
				return getDescription1();
			case MqPackage.MQ_TOPIC_DESTINATION__DESTINATION_NAME:
				return getDestinationName();
			case MqPackage.MQ_TOPIC_DESTINATION__ENABLE_MULTICAST_TRANSPORT:
				return getEnableMulticastTransport();
			case MqPackage.MQ_TOPIC_DESTINATION__EXPIRY:
				return getExpiry();
			case MqPackage.MQ_TOPIC_DESTINATION__FLOATING_POINT_ENCODING:
				return getFloatingPointEncoding();
			case MqPackage.MQ_TOPIC_DESTINATION__INTEGER_ENCODING:
				return getIntegerEncoding();
			case MqPackage.MQ_TOPIC_DESTINATION__JNDI_NAME:
				return getJndiName();
			case MqPackage.MQ_TOPIC_DESTINATION__PERSITENCE:
				return getPersitence();
			case MqPackage.MQ_TOPIC_DESTINATION__PRIORITY:
				return getPriority();
			case MqPackage.MQ_TOPIC_DESTINATION__SPECIFIED_EXPIRY:
				return getSpecifiedExpiry();
			case MqPackage.MQ_TOPIC_DESTINATION__SPECIFIED_PRIORITY:
				return getSpecifiedPriority();
			case MqPackage.MQ_TOPIC_DESTINATION__TARGET_CLIENT:
				return getTargetClient();
			case MqPackage.MQ_TOPIC_DESTINATION__USE_NATIVE_ENCODING:
				return getUseNativeEncoding();
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
			case MqPackage.MQ_TOPIC_DESTINATION__BASE_TOPIC_NAME:
				setBaseTopicName((String)newValue);
				return;
			case MqPackage.MQ_TOPIC_DESTINATION__BROKER_CC_DURABLE_SUBSCRIPTION_QUEUE:
				setBrokerCCDurableSubscriptionQueue((String)newValue);
				return;
			case MqPackage.MQ_TOPIC_DESTINATION__BROKER_DURABLE_SUBSCRIPTION_QUEUE:
				setBrokerDurableSubscriptionQueue((String)newValue);
				return;
			case MqPackage.MQ_TOPIC_DESTINATION__CATEGORY:
				setCategory((String)newValue);
				return;
			case MqPackage.MQ_TOPIC_DESTINATION__DECIMAL_ENCODING:
				setDecimalEncoding((String)newValue);
				return;
			case MqPackage.MQ_TOPIC_DESTINATION__DESCRIPTION1:
				setDescription1((String)newValue);
				return;
			case MqPackage.MQ_TOPIC_DESTINATION__DESTINATION_NAME:
				setDestinationName((String)newValue);
				return;
			case MqPackage.MQ_TOPIC_DESTINATION__ENABLE_MULTICAST_TRANSPORT:
				setEnableMulticastTransport((String)newValue);
				return;
			case MqPackage.MQ_TOPIC_DESTINATION__EXPIRY:
				setExpiry((String)newValue);
				return;
			case MqPackage.MQ_TOPIC_DESTINATION__FLOATING_POINT_ENCODING:
				setFloatingPointEncoding((String)newValue);
				return;
			case MqPackage.MQ_TOPIC_DESTINATION__INTEGER_ENCODING:
				setIntegerEncoding((String)newValue);
				return;
			case MqPackage.MQ_TOPIC_DESTINATION__JNDI_NAME:
				setJndiName((String)newValue);
				return;
			case MqPackage.MQ_TOPIC_DESTINATION__PERSITENCE:
				setPersitence((String)newValue);
				return;
			case MqPackage.MQ_TOPIC_DESTINATION__PRIORITY:
				setPriority((String)newValue);
				return;
			case MqPackage.MQ_TOPIC_DESTINATION__SPECIFIED_EXPIRY:
				setSpecifiedExpiry((String)newValue);
				return;
			case MqPackage.MQ_TOPIC_DESTINATION__SPECIFIED_PRIORITY:
				setSpecifiedPriority((String)newValue);
				return;
			case MqPackage.MQ_TOPIC_DESTINATION__TARGET_CLIENT:
				setTargetClient((String)newValue);
				return;
			case MqPackage.MQ_TOPIC_DESTINATION__USE_NATIVE_ENCODING:
				setUseNativeEncoding((String)newValue);
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
			case MqPackage.MQ_TOPIC_DESTINATION__BASE_TOPIC_NAME:
				setBaseTopicName(BASE_TOPIC_NAME_EDEFAULT);
				return;
			case MqPackage.MQ_TOPIC_DESTINATION__BROKER_CC_DURABLE_SUBSCRIPTION_QUEUE:
				setBrokerCCDurableSubscriptionQueue(BROKER_CC_DURABLE_SUBSCRIPTION_QUEUE_EDEFAULT);
				return;
			case MqPackage.MQ_TOPIC_DESTINATION__BROKER_DURABLE_SUBSCRIPTION_QUEUE:
				setBrokerDurableSubscriptionQueue(BROKER_DURABLE_SUBSCRIPTION_QUEUE_EDEFAULT);
				return;
			case MqPackage.MQ_TOPIC_DESTINATION__CATEGORY:
				setCategory(CATEGORY_EDEFAULT);
				return;
			case MqPackage.MQ_TOPIC_DESTINATION__DECIMAL_ENCODING:
				setDecimalEncoding(DECIMAL_ENCODING_EDEFAULT);
				return;
			case MqPackage.MQ_TOPIC_DESTINATION__DESCRIPTION1:
				setDescription1(DESCRIPTION1_EDEFAULT);
				return;
			case MqPackage.MQ_TOPIC_DESTINATION__DESTINATION_NAME:
				setDestinationName(DESTINATION_NAME_EDEFAULT);
				return;
			case MqPackage.MQ_TOPIC_DESTINATION__ENABLE_MULTICAST_TRANSPORT:
				setEnableMulticastTransport(ENABLE_MULTICAST_TRANSPORT_EDEFAULT);
				return;
			case MqPackage.MQ_TOPIC_DESTINATION__EXPIRY:
				setExpiry(EXPIRY_EDEFAULT);
				return;
			case MqPackage.MQ_TOPIC_DESTINATION__FLOATING_POINT_ENCODING:
				setFloatingPointEncoding(FLOATING_POINT_ENCODING_EDEFAULT);
				return;
			case MqPackage.MQ_TOPIC_DESTINATION__INTEGER_ENCODING:
				setIntegerEncoding(INTEGER_ENCODING_EDEFAULT);
				return;
			case MqPackage.MQ_TOPIC_DESTINATION__JNDI_NAME:
				setJndiName(JNDI_NAME_EDEFAULT);
				return;
			case MqPackage.MQ_TOPIC_DESTINATION__PERSITENCE:
				setPersitence(PERSITENCE_EDEFAULT);
				return;
			case MqPackage.MQ_TOPIC_DESTINATION__PRIORITY:
				setPriority(PRIORITY_EDEFAULT);
				return;
			case MqPackage.MQ_TOPIC_DESTINATION__SPECIFIED_EXPIRY:
				setSpecifiedExpiry(SPECIFIED_EXPIRY_EDEFAULT);
				return;
			case MqPackage.MQ_TOPIC_DESTINATION__SPECIFIED_PRIORITY:
				setSpecifiedPriority(SPECIFIED_PRIORITY_EDEFAULT);
				return;
			case MqPackage.MQ_TOPIC_DESTINATION__TARGET_CLIENT:
				setTargetClient(TARGET_CLIENT_EDEFAULT);
				return;
			case MqPackage.MQ_TOPIC_DESTINATION__USE_NATIVE_ENCODING:
				setUseNativeEncoding(USE_NATIVE_ENCODING_EDEFAULT);
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
			case MqPackage.MQ_TOPIC_DESTINATION__BASE_TOPIC_NAME:
				return BASE_TOPIC_NAME_EDEFAULT == null ? baseTopicName != null : !BASE_TOPIC_NAME_EDEFAULT.equals(baseTopicName);
			case MqPackage.MQ_TOPIC_DESTINATION__BROKER_CC_DURABLE_SUBSCRIPTION_QUEUE:
				return BROKER_CC_DURABLE_SUBSCRIPTION_QUEUE_EDEFAULT == null ? brokerCCDurableSubscriptionQueue != null : !BROKER_CC_DURABLE_SUBSCRIPTION_QUEUE_EDEFAULT.equals(brokerCCDurableSubscriptionQueue);
			case MqPackage.MQ_TOPIC_DESTINATION__BROKER_DURABLE_SUBSCRIPTION_QUEUE:
				return BROKER_DURABLE_SUBSCRIPTION_QUEUE_EDEFAULT == null ? brokerDurableSubscriptionQueue != null : !BROKER_DURABLE_SUBSCRIPTION_QUEUE_EDEFAULT.equals(brokerDurableSubscriptionQueue);
			case MqPackage.MQ_TOPIC_DESTINATION__CATEGORY:
				return CATEGORY_EDEFAULT == null ? category != null : !CATEGORY_EDEFAULT.equals(category);
			case MqPackage.MQ_TOPIC_DESTINATION__DECIMAL_ENCODING:
				return DECIMAL_ENCODING_EDEFAULT == null ? decimalEncoding != null : !DECIMAL_ENCODING_EDEFAULT.equals(decimalEncoding);
			case MqPackage.MQ_TOPIC_DESTINATION__DESCRIPTION1:
				return DESCRIPTION1_EDEFAULT == null ? description1 != null : !DESCRIPTION1_EDEFAULT.equals(description1);
			case MqPackage.MQ_TOPIC_DESTINATION__DESTINATION_NAME:
				return DESTINATION_NAME_EDEFAULT == null ? destinationName != null : !DESTINATION_NAME_EDEFAULT.equals(destinationName);
			case MqPackage.MQ_TOPIC_DESTINATION__ENABLE_MULTICAST_TRANSPORT:
				return ENABLE_MULTICAST_TRANSPORT_EDEFAULT == null ? enableMulticastTransport != null : !ENABLE_MULTICAST_TRANSPORT_EDEFAULT.equals(enableMulticastTransport);
			case MqPackage.MQ_TOPIC_DESTINATION__EXPIRY:
				return EXPIRY_EDEFAULT == null ? expiry != null : !EXPIRY_EDEFAULT.equals(expiry);
			case MqPackage.MQ_TOPIC_DESTINATION__FLOATING_POINT_ENCODING:
				return FLOATING_POINT_ENCODING_EDEFAULT == null ? floatingPointEncoding != null : !FLOATING_POINT_ENCODING_EDEFAULT.equals(floatingPointEncoding);
			case MqPackage.MQ_TOPIC_DESTINATION__INTEGER_ENCODING:
				return INTEGER_ENCODING_EDEFAULT == null ? integerEncoding != null : !INTEGER_ENCODING_EDEFAULT.equals(integerEncoding);
			case MqPackage.MQ_TOPIC_DESTINATION__JNDI_NAME:
				return JNDI_NAME_EDEFAULT == null ? jndiName != null : !JNDI_NAME_EDEFAULT.equals(jndiName);
			case MqPackage.MQ_TOPIC_DESTINATION__PERSITENCE:
				return PERSITENCE_EDEFAULT == null ? persitence != null : !PERSITENCE_EDEFAULT.equals(persitence);
			case MqPackage.MQ_TOPIC_DESTINATION__PRIORITY:
				return PRIORITY_EDEFAULT == null ? priority != null : !PRIORITY_EDEFAULT.equals(priority);
			case MqPackage.MQ_TOPIC_DESTINATION__SPECIFIED_EXPIRY:
				return SPECIFIED_EXPIRY_EDEFAULT == null ? specifiedExpiry != null : !SPECIFIED_EXPIRY_EDEFAULT.equals(specifiedExpiry);
			case MqPackage.MQ_TOPIC_DESTINATION__SPECIFIED_PRIORITY:
				return SPECIFIED_PRIORITY_EDEFAULT == null ? specifiedPriority != null : !SPECIFIED_PRIORITY_EDEFAULT.equals(specifiedPriority);
			case MqPackage.MQ_TOPIC_DESTINATION__TARGET_CLIENT:
				return TARGET_CLIENT_EDEFAULT == null ? targetClient != null : !TARGET_CLIENT_EDEFAULT.equals(targetClient);
			case MqPackage.MQ_TOPIC_DESTINATION__USE_NATIVE_ENCODING:
				return USE_NATIVE_ENCODING_EDEFAULT == null ? useNativeEncoding != null : !USE_NATIVE_ENCODING_EDEFAULT.equals(useNativeEncoding);
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
		result.append(" (baseTopicName: "); //$NON-NLS-1$
		result.append(baseTopicName);
		result.append(", brokerCCDurableSubscriptionQueue: "); //$NON-NLS-1$
		result.append(brokerCCDurableSubscriptionQueue);
		result.append(", brokerDurableSubscriptionQueue: "); //$NON-NLS-1$
		result.append(brokerDurableSubscriptionQueue);
		result.append(", category: "); //$NON-NLS-1$
		result.append(category);
		result.append(", decimalEncoding: "); //$NON-NLS-1$
		result.append(decimalEncoding);
		result.append(", description1: "); //$NON-NLS-1$
		result.append(description1);
		result.append(", destinationName: "); //$NON-NLS-1$
		result.append(destinationName);
		result.append(", enableMulticastTransport: "); //$NON-NLS-1$
		result.append(enableMulticastTransport);
		result.append(", expiry: "); //$NON-NLS-1$
		result.append(expiry);
		result.append(", floatingPointEncoding: "); //$NON-NLS-1$
		result.append(floatingPointEncoding);
		result.append(", integerEncoding: "); //$NON-NLS-1$
		result.append(integerEncoding);
		result.append(", jndiName: "); //$NON-NLS-1$
		result.append(jndiName);
		result.append(", persitence: "); //$NON-NLS-1$
		result.append(persitence);
		result.append(", priority: "); //$NON-NLS-1$
		result.append(priority);
		result.append(", specifiedExpiry: "); //$NON-NLS-1$
		result.append(specifiedExpiry);
		result.append(", specifiedPriority: "); //$NON-NLS-1$
		result.append(specifiedPriority);
		result.append(", targetClient: "); //$NON-NLS-1$
		result.append(targetClient);
		result.append(", useNativeEncoding: "); //$NON-NLS-1$
		result.append(useNativeEncoding);
		result.append(')');
		return result.toString();
	}

} //MQTopicDestinationImpl
