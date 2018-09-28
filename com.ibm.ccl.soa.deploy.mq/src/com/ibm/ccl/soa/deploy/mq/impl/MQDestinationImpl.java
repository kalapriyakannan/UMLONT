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
import com.ibm.ccl.soa.deploy.mq.MQDestination;
import com.ibm.ccl.soa.deploy.mq.MqPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>MQ Destination</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link com.ibm.ccl.soa.deploy.mq.impl.MQDestinationImpl#getBaseQueueManagerName <em>Base Queue Manager Name</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.mq.impl.MQDestinationImpl#getBaseQueueName <em>Base Queue Name</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.mq.impl.MQDestinationImpl#getCategory <em>Category</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.mq.impl.MQDestinationImpl#getCCSID <em>CCSID</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.mq.impl.MQDestinationImpl#getDecimalEncoding <em>Decimal Encoding</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.mq.impl.MQDestinationImpl#getDescription1 <em>Description1</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.mq.impl.MQDestinationImpl#getDestinationName <em>Destination Name</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.mq.impl.MQDestinationImpl#getExpiry <em>Expiry</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.mq.impl.MQDestinationImpl#getFloatingPointEncoding <em>Floating Point Encoding</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.mq.impl.MQDestinationImpl#getIntegerEncoding <em>Integer Encoding</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.mq.impl.MQDestinationImpl#getJndiName <em>Jndi Name</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.mq.impl.MQDestinationImpl#getPassword <em>Password</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.mq.impl.MQDestinationImpl#getPersitence <em>Persitence</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.mq.impl.MQDestinationImpl#getPriority <em>Priority</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.mq.impl.MQDestinationImpl#getQueueManagerHost <em>Queue Manager Host</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.mq.impl.MQDestinationImpl#getQueueManagerPort <em>Queue Manager Port</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.mq.impl.MQDestinationImpl#getServerConnectionChannelName <em>Server Connection Channel Name</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.mq.impl.MQDestinationImpl#getSpecifiedExpiry <em>Specified Expiry</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.mq.impl.MQDestinationImpl#getSpecifiedPriority <em>Specified Priority</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.mq.impl.MQDestinationImpl#getTargetClient <em>Target Client</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.mq.impl.MQDestinationImpl#getUseNativeEncoding <em>Use Native Encoding</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.mq.impl.MQDestinationImpl#getUserID <em>User ID</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class MQDestinationImpl extends CapabilityImpl implements MQDestination {
	/**
	 * The default value of the '{@link #getBaseQueueManagerName() <em>Base Queue Manager Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getBaseQueueManagerName()
	 * @generated
	 * @ordered
	 */
	protected static final String BASE_QUEUE_MANAGER_NAME_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getBaseQueueManagerName() <em>Base Queue Manager Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getBaseQueueManagerName()
	 * @generated
	 * @ordered
	 */
	protected String baseQueueManagerName = BASE_QUEUE_MANAGER_NAME_EDEFAULT;

	/**
	 * The default value of the '{@link #getBaseQueueName() <em>Base Queue Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getBaseQueueName()
	 * @generated
	 * @ordered
	 */
	protected static final String BASE_QUEUE_NAME_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getBaseQueueName() <em>Base Queue Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getBaseQueueName()
	 * @generated
	 * @ordered
	 */
	protected String baseQueueName = BASE_QUEUE_NAME_EDEFAULT;

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
	 * The default value of the '{@link #getPassword() <em>Password</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getPassword()
	 * @generated
	 * @ordered
	 */
	protected static final String PASSWORD_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getPassword() <em>Password</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getPassword()
	 * @generated
	 * @ordered
	 */
	protected String password = PASSWORD_EDEFAULT;

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
	 * The default value of the '{@link #getQueueManagerHost() <em>Queue Manager Host</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getQueueManagerHost()
	 * @generated
	 * @ordered
	 */
	protected static final String QUEUE_MANAGER_HOST_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getQueueManagerHost() <em>Queue Manager Host</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getQueueManagerHost()
	 * @generated
	 * @ordered
	 */
	protected String queueManagerHost = QUEUE_MANAGER_HOST_EDEFAULT;

	/**
	 * The default value of the '{@link #getQueueManagerPort() <em>Queue Manager Port</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getQueueManagerPort()
	 * @generated
	 * @ordered
	 */
	protected static final String QUEUE_MANAGER_PORT_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getQueueManagerPort() <em>Queue Manager Port</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getQueueManagerPort()
	 * @generated
	 * @ordered
	 */
	protected String queueManagerPort = QUEUE_MANAGER_PORT_EDEFAULT;

	/**
	 * The default value of the '{@link #getServerConnectionChannelName() <em>Server Connection Channel Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getServerConnectionChannelName()
	 * @generated
	 * @ordered
	 */
	protected static final String SERVER_CONNECTION_CHANNEL_NAME_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getServerConnectionChannelName() <em>Server Connection Channel Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getServerConnectionChannelName()
	 * @generated
	 * @ordered
	 */
	protected String serverConnectionChannelName = SERVER_CONNECTION_CHANNEL_NAME_EDEFAULT;

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
	 * The default value of the '{@link #getUserID() <em>User ID</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getUserID()
	 * @generated
	 * @ordered
	 */
	protected static final String USER_ID_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getUserID() <em>User ID</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getUserID()
	 * @generated
	 * @ordered
	 */
	protected String userID = USER_ID_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected MQDestinationImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected EClass eStaticClass() {
		return MqPackage.Literals.MQ_DESTINATION;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getBaseQueueManagerName() {
		return baseQueueManagerName;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setBaseQueueManagerName(String newBaseQueueManagerName) {
		String oldBaseQueueManagerName = baseQueueManagerName;
		baseQueueManagerName = newBaseQueueManagerName;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, MqPackage.MQ_DESTINATION__BASE_QUEUE_MANAGER_NAME, oldBaseQueueManagerName, baseQueueManagerName));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getBaseQueueName() {
		return baseQueueName;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setBaseQueueName(String newBaseQueueName) {
		String oldBaseQueueName = baseQueueName;
		baseQueueName = newBaseQueueName;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, MqPackage.MQ_DESTINATION__BASE_QUEUE_NAME, oldBaseQueueName, baseQueueName));
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
			eNotify(new ENotificationImpl(this, Notification.SET, MqPackage.MQ_DESTINATION__CATEGORY, oldCategory, category));
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
			eNotify(new ENotificationImpl(this, Notification.SET, MqPackage.MQ_DESTINATION__CCSID, oldCCSID, cCSID));
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
			eNotify(new ENotificationImpl(this, Notification.SET, MqPackage.MQ_DESTINATION__DECIMAL_ENCODING, oldDecimalEncoding, decimalEncoding));
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
			eNotify(new ENotificationImpl(this, Notification.SET, MqPackage.MQ_DESTINATION__DESCRIPTION1, oldDescription1, description1));
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
			eNotify(new ENotificationImpl(this, Notification.SET, MqPackage.MQ_DESTINATION__DESTINATION_NAME, oldDestinationName, destinationName));
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
			eNotify(new ENotificationImpl(this, Notification.SET, MqPackage.MQ_DESTINATION__EXPIRY, oldExpiry, expiry));
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
			eNotify(new ENotificationImpl(this, Notification.SET, MqPackage.MQ_DESTINATION__FLOATING_POINT_ENCODING, oldFloatingPointEncoding, floatingPointEncoding));
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
			eNotify(new ENotificationImpl(this, Notification.SET, MqPackage.MQ_DESTINATION__INTEGER_ENCODING, oldIntegerEncoding, integerEncoding));
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
			eNotify(new ENotificationImpl(this, Notification.SET, MqPackage.MQ_DESTINATION__JNDI_NAME, oldJndiName, jndiName));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getPassword() {
		return password;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setPassword(String newPassword) {
		String oldPassword = password;
		password = newPassword;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, MqPackage.MQ_DESTINATION__PASSWORD, oldPassword, password));
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
			eNotify(new ENotificationImpl(this, Notification.SET, MqPackage.MQ_DESTINATION__PERSITENCE, oldPersitence, persitence));
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
			eNotify(new ENotificationImpl(this, Notification.SET, MqPackage.MQ_DESTINATION__PRIORITY, oldPriority, priority));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getQueueManagerHost() {
		return queueManagerHost;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setQueueManagerHost(String newQueueManagerHost) {
		String oldQueueManagerHost = queueManagerHost;
		queueManagerHost = newQueueManagerHost;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, MqPackage.MQ_DESTINATION__QUEUE_MANAGER_HOST, oldQueueManagerHost, queueManagerHost));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getQueueManagerPort() {
		return queueManagerPort;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setQueueManagerPort(String newQueueManagerPort) {
		String oldQueueManagerPort = queueManagerPort;
		queueManagerPort = newQueueManagerPort;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, MqPackage.MQ_DESTINATION__QUEUE_MANAGER_PORT, oldQueueManagerPort, queueManagerPort));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getServerConnectionChannelName() {
		return serverConnectionChannelName;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setServerConnectionChannelName(String newServerConnectionChannelName) {
		String oldServerConnectionChannelName = serverConnectionChannelName;
		serverConnectionChannelName = newServerConnectionChannelName;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, MqPackage.MQ_DESTINATION__SERVER_CONNECTION_CHANNEL_NAME, oldServerConnectionChannelName, serverConnectionChannelName));
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
			eNotify(new ENotificationImpl(this, Notification.SET, MqPackage.MQ_DESTINATION__SPECIFIED_EXPIRY, oldSpecifiedExpiry, specifiedExpiry));
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
			eNotify(new ENotificationImpl(this, Notification.SET, MqPackage.MQ_DESTINATION__SPECIFIED_PRIORITY, oldSpecifiedPriority, specifiedPriority));
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
			eNotify(new ENotificationImpl(this, Notification.SET, MqPackage.MQ_DESTINATION__TARGET_CLIENT, oldTargetClient, targetClient));
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
			eNotify(new ENotificationImpl(this, Notification.SET, MqPackage.MQ_DESTINATION__USE_NATIVE_ENCODING, oldUseNativeEncoding, useNativeEncoding));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getUserID() {
		return userID;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setUserID(String newUserID) {
		String oldUserID = userID;
		userID = newUserID;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, MqPackage.MQ_DESTINATION__USER_ID, oldUserID, userID));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case MqPackage.MQ_DESTINATION__BASE_QUEUE_MANAGER_NAME:
				return getBaseQueueManagerName();
			case MqPackage.MQ_DESTINATION__BASE_QUEUE_NAME:
				return getBaseQueueName();
			case MqPackage.MQ_DESTINATION__CATEGORY:
				return getCategory();
			case MqPackage.MQ_DESTINATION__CCSID:
				return getCCSID();
			case MqPackage.MQ_DESTINATION__DECIMAL_ENCODING:
				return getDecimalEncoding();
			case MqPackage.MQ_DESTINATION__DESCRIPTION1:
				return getDescription1();
			case MqPackage.MQ_DESTINATION__DESTINATION_NAME:
				return getDestinationName();
			case MqPackage.MQ_DESTINATION__EXPIRY:
				return getExpiry();
			case MqPackage.MQ_DESTINATION__FLOATING_POINT_ENCODING:
				return getFloatingPointEncoding();
			case MqPackage.MQ_DESTINATION__INTEGER_ENCODING:
				return getIntegerEncoding();
			case MqPackage.MQ_DESTINATION__JNDI_NAME:
				return getJndiName();
			case MqPackage.MQ_DESTINATION__PASSWORD:
				return getPassword();
			case MqPackage.MQ_DESTINATION__PERSITENCE:
				return getPersitence();
			case MqPackage.MQ_DESTINATION__PRIORITY:
				return getPriority();
			case MqPackage.MQ_DESTINATION__QUEUE_MANAGER_HOST:
				return getQueueManagerHost();
			case MqPackage.MQ_DESTINATION__QUEUE_MANAGER_PORT:
				return getQueueManagerPort();
			case MqPackage.MQ_DESTINATION__SERVER_CONNECTION_CHANNEL_NAME:
				return getServerConnectionChannelName();
			case MqPackage.MQ_DESTINATION__SPECIFIED_EXPIRY:
				return getSpecifiedExpiry();
			case MqPackage.MQ_DESTINATION__SPECIFIED_PRIORITY:
				return getSpecifiedPriority();
			case MqPackage.MQ_DESTINATION__TARGET_CLIENT:
				return getTargetClient();
			case MqPackage.MQ_DESTINATION__USE_NATIVE_ENCODING:
				return getUseNativeEncoding();
			case MqPackage.MQ_DESTINATION__USER_ID:
				return getUserID();
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
			case MqPackage.MQ_DESTINATION__BASE_QUEUE_MANAGER_NAME:
				setBaseQueueManagerName((String)newValue);
				return;
			case MqPackage.MQ_DESTINATION__BASE_QUEUE_NAME:
				setBaseQueueName((String)newValue);
				return;
			case MqPackage.MQ_DESTINATION__CATEGORY:
				setCategory((String)newValue);
				return;
			case MqPackage.MQ_DESTINATION__CCSID:
				setCCSID((String)newValue);
				return;
			case MqPackage.MQ_DESTINATION__DECIMAL_ENCODING:
				setDecimalEncoding((String)newValue);
				return;
			case MqPackage.MQ_DESTINATION__DESCRIPTION1:
				setDescription1((String)newValue);
				return;
			case MqPackage.MQ_DESTINATION__DESTINATION_NAME:
				setDestinationName((String)newValue);
				return;
			case MqPackage.MQ_DESTINATION__EXPIRY:
				setExpiry((String)newValue);
				return;
			case MqPackage.MQ_DESTINATION__FLOATING_POINT_ENCODING:
				setFloatingPointEncoding((String)newValue);
				return;
			case MqPackage.MQ_DESTINATION__INTEGER_ENCODING:
				setIntegerEncoding((String)newValue);
				return;
			case MqPackage.MQ_DESTINATION__JNDI_NAME:
				setJndiName((String)newValue);
				return;
			case MqPackage.MQ_DESTINATION__PASSWORD:
				setPassword((String)newValue);
				return;
			case MqPackage.MQ_DESTINATION__PERSITENCE:
				setPersitence((String)newValue);
				return;
			case MqPackage.MQ_DESTINATION__PRIORITY:
				setPriority((String)newValue);
				return;
			case MqPackage.MQ_DESTINATION__QUEUE_MANAGER_HOST:
				setQueueManagerHost((String)newValue);
				return;
			case MqPackage.MQ_DESTINATION__QUEUE_MANAGER_PORT:
				setQueueManagerPort((String)newValue);
				return;
			case MqPackage.MQ_DESTINATION__SERVER_CONNECTION_CHANNEL_NAME:
				setServerConnectionChannelName((String)newValue);
				return;
			case MqPackage.MQ_DESTINATION__SPECIFIED_EXPIRY:
				setSpecifiedExpiry((String)newValue);
				return;
			case MqPackage.MQ_DESTINATION__SPECIFIED_PRIORITY:
				setSpecifiedPriority((String)newValue);
				return;
			case MqPackage.MQ_DESTINATION__TARGET_CLIENT:
				setTargetClient((String)newValue);
				return;
			case MqPackage.MQ_DESTINATION__USE_NATIVE_ENCODING:
				setUseNativeEncoding((String)newValue);
				return;
			case MqPackage.MQ_DESTINATION__USER_ID:
				setUserID((String)newValue);
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
			case MqPackage.MQ_DESTINATION__BASE_QUEUE_MANAGER_NAME:
				setBaseQueueManagerName(BASE_QUEUE_MANAGER_NAME_EDEFAULT);
				return;
			case MqPackage.MQ_DESTINATION__BASE_QUEUE_NAME:
				setBaseQueueName(BASE_QUEUE_NAME_EDEFAULT);
				return;
			case MqPackage.MQ_DESTINATION__CATEGORY:
				setCategory(CATEGORY_EDEFAULT);
				return;
			case MqPackage.MQ_DESTINATION__CCSID:
				setCCSID(CCSID_EDEFAULT);
				return;
			case MqPackage.MQ_DESTINATION__DECIMAL_ENCODING:
				setDecimalEncoding(DECIMAL_ENCODING_EDEFAULT);
				return;
			case MqPackage.MQ_DESTINATION__DESCRIPTION1:
				setDescription1(DESCRIPTION1_EDEFAULT);
				return;
			case MqPackage.MQ_DESTINATION__DESTINATION_NAME:
				setDestinationName(DESTINATION_NAME_EDEFAULT);
				return;
			case MqPackage.MQ_DESTINATION__EXPIRY:
				setExpiry(EXPIRY_EDEFAULT);
				return;
			case MqPackage.MQ_DESTINATION__FLOATING_POINT_ENCODING:
				setFloatingPointEncoding(FLOATING_POINT_ENCODING_EDEFAULT);
				return;
			case MqPackage.MQ_DESTINATION__INTEGER_ENCODING:
				setIntegerEncoding(INTEGER_ENCODING_EDEFAULT);
				return;
			case MqPackage.MQ_DESTINATION__JNDI_NAME:
				setJndiName(JNDI_NAME_EDEFAULT);
				return;
			case MqPackage.MQ_DESTINATION__PASSWORD:
				setPassword(PASSWORD_EDEFAULT);
				return;
			case MqPackage.MQ_DESTINATION__PERSITENCE:
				setPersitence(PERSITENCE_EDEFAULT);
				return;
			case MqPackage.MQ_DESTINATION__PRIORITY:
				setPriority(PRIORITY_EDEFAULT);
				return;
			case MqPackage.MQ_DESTINATION__QUEUE_MANAGER_HOST:
				setQueueManagerHost(QUEUE_MANAGER_HOST_EDEFAULT);
				return;
			case MqPackage.MQ_DESTINATION__QUEUE_MANAGER_PORT:
				setQueueManagerPort(QUEUE_MANAGER_PORT_EDEFAULT);
				return;
			case MqPackage.MQ_DESTINATION__SERVER_CONNECTION_CHANNEL_NAME:
				setServerConnectionChannelName(SERVER_CONNECTION_CHANNEL_NAME_EDEFAULT);
				return;
			case MqPackage.MQ_DESTINATION__SPECIFIED_EXPIRY:
				setSpecifiedExpiry(SPECIFIED_EXPIRY_EDEFAULT);
				return;
			case MqPackage.MQ_DESTINATION__SPECIFIED_PRIORITY:
				setSpecifiedPriority(SPECIFIED_PRIORITY_EDEFAULT);
				return;
			case MqPackage.MQ_DESTINATION__TARGET_CLIENT:
				setTargetClient(TARGET_CLIENT_EDEFAULT);
				return;
			case MqPackage.MQ_DESTINATION__USE_NATIVE_ENCODING:
				setUseNativeEncoding(USE_NATIVE_ENCODING_EDEFAULT);
				return;
			case MqPackage.MQ_DESTINATION__USER_ID:
				setUserID(USER_ID_EDEFAULT);
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
			case MqPackage.MQ_DESTINATION__BASE_QUEUE_MANAGER_NAME:
				return BASE_QUEUE_MANAGER_NAME_EDEFAULT == null ? baseQueueManagerName != null : !BASE_QUEUE_MANAGER_NAME_EDEFAULT.equals(baseQueueManagerName);
			case MqPackage.MQ_DESTINATION__BASE_QUEUE_NAME:
				return BASE_QUEUE_NAME_EDEFAULT == null ? baseQueueName != null : !BASE_QUEUE_NAME_EDEFAULT.equals(baseQueueName);
			case MqPackage.MQ_DESTINATION__CATEGORY:
				return CATEGORY_EDEFAULT == null ? category != null : !CATEGORY_EDEFAULT.equals(category);
			case MqPackage.MQ_DESTINATION__CCSID:
				return CCSID_EDEFAULT == null ? cCSID != null : !CCSID_EDEFAULT.equals(cCSID);
			case MqPackage.MQ_DESTINATION__DECIMAL_ENCODING:
				return DECIMAL_ENCODING_EDEFAULT == null ? decimalEncoding != null : !DECIMAL_ENCODING_EDEFAULT.equals(decimalEncoding);
			case MqPackage.MQ_DESTINATION__DESCRIPTION1:
				return DESCRIPTION1_EDEFAULT == null ? description1 != null : !DESCRIPTION1_EDEFAULT.equals(description1);
			case MqPackage.MQ_DESTINATION__DESTINATION_NAME:
				return DESTINATION_NAME_EDEFAULT == null ? destinationName != null : !DESTINATION_NAME_EDEFAULT.equals(destinationName);
			case MqPackage.MQ_DESTINATION__EXPIRY:
				return EXPIRY_EDEFAULT == null ? expiry != null : !EXPIRY_EDEFAULT.equals(expiry);
			case MqPackage.MQ_DESTINATION__FLOATING_POINT_ENCODING:
				return FLOATING_POINT_ENCODING_EDEFAULT == null ? floatingPointEncoding != null : !FLOATING_POINT_ENCODING_EDEFAULT.equals(floatingPointEncoding);
			case MqPackage.MQ_DESTINATION__INTEGER_ENCODING:
				return INTEGER_ENCODING_EDEFAULT == null ? integerEncoding != null : !INTEGER_ENCODING_EDEFAULT.equals(integerEncoding);
			case MqPackage.MQ_DESTINATION__JNDI_NAME:
				return JNDI_NAME_EDEFAULT == null ? jndiName != null : !JNDI_NAME_EDEFAULT.equals(jndiName);
			case MqPackage.MQ_DESTINATION__PASSWORD:
				return PASSWORD_EDEFAULT == null ? password != null : !PASSWORD_EDEFAULT.equals(password);
			case MqPackage.MQ_DESTINATION__PERSITENCE:
				return PERSITENCE_EDEFAULT == null ? persitence != null : !PERSITENCE_EDEFAULT.equals(persitence);
			case MqPackage.MQ_DESTINATION__PRIORITY:
				return PRIORITY_EDEFAULT == null ? priority != null : !PRIORITY_EDEFAULT.equals(priority);
			case MqPackage.MQ_DESTINATION__QUEUE_MANAGER_HOST:
				return QUEUE_MANAGER_HOST_EDEFAULT == null ? queueManagerHost != null : !QUEUE_MANAGER_HOST_EDEFAULT.equals(queueManagerHost);
			case MqPackage.MQ_DESTINATION__QUEUE_MANAGER_PORT:
				return QUEUE_MANAGER_PORT_EDEFAULT == null ? queueManagerPort != null : !QUEUE_MANAGER_PORT_EDEFAULT.equals(queueManagerPort);
			case MqPackage.MQ_DESTINATION__SERVER_CONNECTION_CHANNEL_NAME:
				return SERVER_CONNECTION_CHANNEL_NAME_EDEFAULT == null ? serverConnectionChannelName != null : !SERVER_CONNECTION_CHANNEL_NAME_EDEFAULT.equals(serverConnectionChannelName);
			case MqPackage.MQ_DESTINATION__SPECIFIED_EXPIRY:
				return SPECIFIED_EXPIRY_EDEFAULT == null ? specifiedExpiry != null : !SPECIFIED_EXPIRY_EDEFAULT.equals(specifiedExpiry);
			case MqPackage.MQ_DESTINATION__SPECIFIED_PRIORITY:
				return SPECIFIED_PRIORITY_EDEFAULT == null ? specifiedPriority != null : !SPECIFIED_PRIORITY_EDEFAULT.equals(specifiedPriority);
			case MqPackage.MQ_DESTINATION__TARGET_CLIENT:
				return TARGET_CLIENT_EDEFAULT == null ? targetClient != null : !TARGET_CLIENT_EDEFAULT.equals(targetClient);
			case MqPackage.MQ_DESTINATION__USE_NATIVE_ENCODING:
				return USE_NATIVE_ENCODING_EDEFAULT == null ? useNativeEncoding != null : !USE_NATIVE_ENCODING_EDEFAULT.equals(useNativeEncoding);
			case MqPackage.MQ_DESTINATION__USER_ID:
				return USER_ID_EDEFAULT == null ? userID != null : !USER_ID_EDEFAULT.equals(userID);
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
		result.append(" (baseQueueManagerName: "); //$NON-NLS-1$
		result.append(baseQueueManagerName);
		result.append(", baseQueueName: "); //$NON-NLS-1$
		result.append(baseQueueName);
		result.append(", category: "); //$NON-NLS-1$
		result.append(category);
		result.append(", cCSID: "); //$NON-NLS-1$
		result.append(cCSID);
		result.append(", decimalEncoding: "); //$NON-NLS-1$
		result.append(decimalEncoding);
		result.append(", description1: "); //$NON-NLS-1$
		result.append(description1);
		result.append(", destinationName: "); //$NON-NLS-1$
		result.append(destinationName);
		result.append(", expiry: "); //$NON-NLS-1$
		result.append(expiry);
		result.append(", floatingPointEncoding: "); //$NON-NLS-1$
		result.append(floatingPointEncoding);
		result.append(", integerEncoding: "); //$NON-NLS-1$
		result.append(integerEncoding);
		result.append(", jndiName: "); //$NON-NLS-1$
		result.append(jndiName);
		result.append(", password: "); //$NON-NLS-1$
		result.append(password);
		result.append(", persitence: "); //$NON-NLS-1$
		result.append(persitence);
		result.append(", priority: "); //$NON-NLS-1$
		result.append(priority);
		result.append(", queueManagerHost: "); //$NON-NLS-1$
		result.append(queueManagerHost);
		result.append(", queueManagerPort: "); //$NON-NLS-1$
		result.append(queueManagerPort);
		result.append(", serverConnectionChannelName: "); //$NON-NLS-1$
		result.append(serverConnectionChannelName);
		result.append(", specifiedExpiry: "); //$NON-NLS-1$
		result.append(specifiedExpiry);
		result.append(", specifiedPriority: "); //$NON-NLS-1$
		result.append(specifiedPriority);
		result.append(", targetClient: "); //$NON-NLS-1$
		result.append(targetClient);
		result.append(", useNativeEncoding: "); //$NON-NLS-1$
		result.append(useNativeEncoding);
		result.append(", userID: "); //$NON-NLS-1$
		result.append(userID);
		result.append(')');
		return result.toString();
	}

} //MQDestinationImpl
