/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package com.ibm.ccl.soa.deploy.wps.impl;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.impl.ENotificationImpl;

import com.ibm.ccl.soa.deploy.core.impl.CapabilityImpl;
import com.ibm.ccl.soa.deploy.wps.TaskContainer;
import com.ibm.ccl.soa.deploy.wps.WpsPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Task Container</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link com.ibm.ccl.soa.deploy.wps.impl.TaskContainerImpl#getAdministratorSecurityRoleMapping <em>Administrator Security Role Mapping</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.wps.impl.TaskContainerImpl#getClasspath <em>Classpath</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.wps.impl.TaskContainerImpl#getEnableAuditLog <em>Enable Audit Log</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.wps.impl.TaskContainerImpl#getEnableCEIlogging <em>Enable CE Ilogging</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.wps.impl.TaskContainerImpl#getEscalationpassword <em>Escalationpassword</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.wps.impl.TaskContainerImpl#getHoldQueue <em>Hold Queue</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.wps.impl.TaskContainerImpl#getJMSConnectionFactory <em>JMS Connection Factory</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.wps.impl.TaskContainerImpl#getJMSPassword <em>JMS Password</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.wps.impl.TaskContainerImpl#getJMSProvider <em>JMS Provider</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.wps.impl.TaskContainerImpl#getJMSResources <em>JMS Resources</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.wps.impl.TaskContainerImpl#getJMSUserID <em>JMS User ID</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.wps.impl.TaskContainerImpl#getMailSession <em>Mail Session</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.wps.impl.TaskContainerImpl#getQueueManager <em>Queue Manager</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.wps.impl.TaskContainerImpl#getSystemMonitorSecurityRoleMapping <em>System Monitor Security Role Mapping</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class TaskContainerImpl extends CapabilityImpl implements TaskContainer {
	/**
	 * The default value of the '{@link #getAdministratorSecurityRoleMapping() <em>Administrator Security Role Mapping</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getAdministratorSecurityRoleMapping()
	 * @generated
	 * @ordered
	 */
	protected static final Object ADMINISTRATOR_SECURITY_ROLE_MAPPING_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getAdministratorSecurityRoleMapping() <em>Administrator Security Role Mapping</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getAdministratorSecurityRoleMapping()
	 * @generated
	 * @ordered
	 */
	protected Object administratorSecurityRoleMapping = ADMINISTRATOR_SECURITY_ROLE_MAPPING_EDEFAULT;

	/**
	 * The default value of the '{@link #getClasspath() <em>Classpath</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getClasspath()
	 * @generated
	 * @ordered
	 */
	protected static final Object CLASSPATH_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getClasspath() <em>Classpath</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getClasspath()
	 * @generated
	 * @ordered
	 */
	protected Object classpath = CLASSPATH_EDEFAULT;

	/**
	 * The default value of the '{@link #getEnableAuditLog() <em>Enable Audit Log</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getEnableAuditLog()
	 * @generated
	 * @ordered
	 */
	protected static final Object ENABLE_AUDIT_LOG_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getEnableAuditLog() <em>Enable Audit Log</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getEnableAuditLog()
	 * @generated
	 * @ordered
	 */
	protected Object enableAuditLog = ENABLE_AUDIT_LOG_EDEFAULT;

	/**
	 * The default value of the '{@link #getEnableCEIlogging() <em>Enable CE Ilogging</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getEnableCEIlogging()
	 * @generated
	 * @ordered
	 */
	protected static final Object ENABLE_CE_ILOGGING_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getEnableCEIlogging() <em>Enable CE Ilogging</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getEnableCEIlogging()
	 * @generated
	 * @ordered
	 */
	protected Object enableCEIlogging = ENABLE_CE_ILOGGING_EDEFAULT;

	/**
	 * The default value of the '{@link #getEscalationpassword() <em>Escalationpassword</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getEscalationpassword()
	 * @generated
	 * @ordered
	 */
	protected static final Object ESCALATIONPASSWORD_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getEscalationpassword() <em>Escalationpassword</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getEscalationpassword()
	 * @generated
	 * @ordered
	 */
	protected Object escalationpassword = ESCALATIONPASSWORD_EDEFAULT;

	/**
	 * The default value of the '{@link #getHoldQueue() <em>Hold Queue</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getHoldQueue()
	 * @generated
	 * @ordered
	 */
	protected static final Object HOLD_QUEUE_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getHoldQueue() <em>Hold Queue</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getHoldQueue()
	 * @generated
	 * @ordered
	 */
	protected Object holdQueue = HOLD_QUEUE_EDEFAULT;

	/**
	 * The default value of the '{@link #getJMSConnectionFactory() <em>JMS Connection Factory</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getJMSConnectionFactory()
	 * @generated
	 * @ordered
	 */
	protected static final Object JMS_CONNECTION_FACTORY_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getJMSConnectionFactory() <em>JMS Connection Factory</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getJMSConnectionFactory()
	 * @generated
	 * @ordered
	 */
	protected Object jMSConnectionFactory = JMS_CONNECTION_FACTORY_EDEFAULT;

	/**
	 * The default value of the '{@link #getJMSPassword() <em>JMS Password</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getJMSPassword()
	 * @generated
	 * @ordered
	 */
	protected static final Object JMS_PASSWORD_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getJMSPassword() <em>JMS Password</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getJMSPassword()
	 * @generated
	 * @ordered
	 */
	protected Object jMSPassword = JMS_PASSWORD_EDEFAULT;

	/**
	 * The default value of the '{@link #getJMSProvider() <em>JMS Provider</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getJMSProvider()
	 * @generated
	 * @ordered
	 */
	protected static final Object JMS_PROVIDER_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getJMSProvider() <em>JMS Provider</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getJMSProvider()
	 * @generated
	 * @ordered
	 */
	protected Object jMSProvider = JMS_PROVIDER_EDEFAULT;

	/**
	 * The default value of the '{@link #getJMSResources() <em>JMS Resources</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getJMSResources()
	 * @generated
	 * @ordered
	 */
	protected static final Object JMS_RESOURCES_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getJMSResources() <em>JMS Resources</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getJMSResources()
	 * @generated
	 * @ordered
	 */
	protected Object jMSResources = JMS_RESOURCES_EDEFAULT;

	/**
	 * The default value of the '{@link #getJMSUserID() <em>JMS User ID</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getJMSUserID()
	 * @generated
	 * @ordered
	 */
	protected static final Object JMS_USER_ID_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getJMSUserID() <em>JMS User ID</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getJMSUserID()
	 * @generated
	 * @ordered
	 */
	protected Object jMSUserID = JMS_USER_ID_EDEFAULT;

	/**
	 * The default value of the '{@link #getMailSession() <em>Mail Session</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getMailSession()
	 * @generated
	 * @ordered
	 */
	protected static final Object MAIL_SESSION_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getMailSession() <em>Mail Session</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getMailSession()
	 * @generated
	 * @ordered
	 */
	protected Object mailSession = MAIL_SESSION_EDEFAULT;

	/**
	 * The default value of the '{@link #getQueueManager() <em>Queue Manager</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getQueueManager()
	 * @generated
	 * @ordered
	 */
	protected static final Object QUEUE_MANAGER_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getQueueManager() <em>Queue Manager</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getQueueManager()
	 * @generated
	 * @ordered
	 */
	protected Object queueManager = QUEUE_MANAGER_EDEFAULT;

	/**
	 * The default value of the '{@link #getSystemMonitorSecurityRoleMapping() <em>System Monitor Security Role Mapping</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSystemMonitorSecurityRoleMapping()
	 * @generated
	 * @ordered
	 */
	protected static final Object SYSTEM_MONITOR_SECURITY_ROLE_MAPPING_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getSystemMonitorSecurityRoleMapping() <em>System Monitor Security Role Mapping</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSystemMonitorSecurityRoleMapping()
	 * @generated
	 * @ordered
	 */
	protected Object systemMonitorSecurityRoleMapping = SYSTEM_MONITOR_SECURITY_ROLE_MAPPING_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected TaskContainerImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected EClass eStaticClass() {
		return WpsPackage.Literals.TASK_CONTAINER;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Object getAdministratorSecurityRoleMapping() {
		return administratorSecurityRoleMapping;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setAdministratorSecurityRoleMapping(Object newAdministratorSecurityRoleMapping) {
		Object oldAdministratorSecurityRoleMapping = administratorSecurityRoleMapping;
		administratorSecurityRoleMapping = newAdministratorSecurityRoleMapping;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, WpsPackage.TASK_CONTAINER__ADMINISTRATOR_SECURITY_ROLE_MAPPING, oldAdministratorSecurityRoleMapping, administratorSecurityRoleMapping));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Object getClasspath() {
		return classpath;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setClasspath(Object newClasspath) {
		Object oldClasspath = classpath;
		classpath = newClasspath;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, WpsPackage.TASK_CONTAINER__CLASSPATH, oldClasspath, classpath));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Object getEnableAuditLog() {
		return enableAuditLog;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setEnableAuditLog(Object newEnableAuditLog) {
		Object oldEnableAuditLog = enableAuditLog;
		enableAuditLog = newEnableAuditLog;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, WpsPackage.TASK_CONTAINER__ENABLE_AUDIT_LOG, oldEnableAuditLog, enableAuditLog));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Object getEnableCEIlogging() {
		return enableCEIlogging;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setEnableCEIlogging(Object newEnableCEIlogging) {
		Object oldEnableCEIlogging = enableCEIlogging;
		enableCEIlogging = newEnableCEIlogging;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, WpsPackage.TASK_CONTAINER__ENABLE_CE_ILOGGING, oldEnableCEIlogging, enableCEIlogging));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Object getEscalationpassword() {
		return escalationpassword;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setEscalationpassword(Object newEscalationpassword) {
		Object oldEscalationpassword = escalationpassword;
		escalationpassword = newEscalationpassword;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, WpsPackage.TASK_CONTAINER__ESCALATIONPASSWORD, oldEscalationpassword, escalationpassword));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Object getHoldQueue() {
		return holdQueue;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setHoldQueue(Object newHoldQueue) {
		Object oldHoldQueue = holdQueue;
		holdQueue = newHoldQueue;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, WpsPackage.TASK_CONTAINER__HOLD_QUEUE, oldHoldQueue, holdQueue));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Object getJMSConnectionFactory() {
		return jMSConnectionFactory;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setJMSConnectionFactory(Object newJMSConnectionFactory) {
		Object oldJMSConnectionFactory = jMSConnectionFactory;
		jMSConnectionFactory = newJMSConnectionFactory;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, WpsPackage.TASK_CONTAINER__JMS_CONNECTION_FACTORY, oldJMSConnectionFactory, jMSConnectionFactory));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Object getJMSPassword() {
		return jMSPassword;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setJMSPassword(Object newJMSPassword) {
		Object oldJMSPassword = jMSPassword;
		jMSPassword = newJMSPassword;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, WpsPackage.TASK_CONTAINER__JMS_PASSWORD, oldJMSPassword, jMSPassword));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Object getJMSProvider() {
		return jMSProvider;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setJMSProvider(Object newJMSProvider) {
		Object oldJMSProvider = jMSProvider;
		jMSProvider = newJMSProvider;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, WpsPackage.TASK_CONTAINER__JMS_PROVIDER, oldJMSProvider, jMSProvider));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Object getJMSResources() {
		return jMSResources;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setJMSResources(Object newJMSResources) {
		Object oldJMSResources = jMSResources;
		jMSResources = newJMSResources;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, WpsPackage.TASK_CONTAINER__JMS_RESOURCES, oldJMSResources, jMSResources));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Object getJMSUserID() {
		return jMSUserID;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setJMSUserID(Object newJMSUserID) {
		Object oldJMSUserID = jMSUserID;
		jMSUserID = newJMSUserID;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, WpsPackage.TASK_CONTAINER__JMS_USER_ID, oldJMSUserID, jMSUserID));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Object getMailSession() {
		return mailSession;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setMailSession(Object newMailSession) {
		Object oldMailSession = mailSession;
		mailSession = newMailSession;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, WpsPackage.TASK_CONTAINER__MAIL_SESSION, oldMailSession, mailSession));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Object getQueueManager() {
		return queueManager;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setQueueManager(Object newQueueManager) {
		Object oldQueueManager = queueManager;
		queueManager = newQueueManager;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, WpsPackage.TASK_CONTAINER__QUEUE_MANAGER, oldQueueManager, queueManager));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Object getSystemMonitorSecurityRoleMapping() {
		return systemMonitorSecurityRoleMapping;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setSystemMonitorSecurityRoleMapping(Object newSystemMonitorSecurityRoleMapping) {
		Object oldSystemMonitorSecurityRoleMapping = systemMonitorSecurityRoleMapping;
		systemMonitorSecurityRoleMapping = newSystemMonitorSecurityRoleMapping;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, WpsPackage.TASK_CONTAINER__SYSTEM_MONITOR_SECURITY_ROLE_MAPPING, oldSystemMonitorSecurityRoleMapping, systemMonitorSecurityRoleMapping));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case WpsPackage.TASK_CONTAINER__ADMINISTRATOR_SECURITY_ROLE_MAPPING:
				return getAdministratorSecurityRoleMapping();
			case WpsPackage.TASK_CONTAINER__CLASSPATH:
				return getClasspath();
			case WpsPackage.TASK_CONTAINER__ENABLE_AUDIT_LOG:
				return getEnableAuditLog();
			case WpsPackage.TASK_CONTAINER__ENABLE_CE_ILOGGING:
				return getEnableCEIlogging();
			case WpsPackage.TASK_CONTAINER__ESCALATIONPASSWORD:
				return getEscalationpassword();
			case WpsPackage.TASK_CONTAINER__HOLD_QUEUE:
				return getHoldQueue();
			case WpsPackage.TASK_CONTAINER__JMS_CONNECTION_FACTORY:
				return getJMSConnectionFactory();
			case WpsPackage.TASK_CONTAINER__JMS_PASSWORD:
				return getJMSPassword();
			case WpsPackage.TASK_CONTAINER__JMS_PROVIDER:
				return getJMSProvider();
			case WpsPackage.TASK_CONTAINER__JMS_RESOURCES:
				return getJMSResources();
			case WpsPackage.TASK_CONTAINER__JMS_USER_ID:
				return getJMSUserID();
			case WpsPackage.TASK_CONTAINER__MAIL_SESSION:
				return getMailSession();
			case WpsPackage.TASK_CONTAINER__QUEUE_MANAGER:
				return getQueueManager();
			case WpsPackage.TASK_CONTAINER__SYSTEM_MONITOR_SECURITY_ROLE_MAPPING:
				return getSystemMonitorSecurityRoleMapping();
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
			case WpsPackage.TASK_CONTAINER__ADMINISTRATOR_SECURITY_ROLE_MAPPING:
				setAdministratorSecurityRoleMapping(newValue);
				return;
			case WpsPackage.TASK_CONTAINER__CLASSPATH:
				setClasspath(newValue);
				return;
			case WpsPackage.TASK_CONTAINER__ENABLE_AUDIT_LOG:
				setEnableAuditLog(newValue);
				return;
			case WpsPackage.TASK_CONTAINER__ENABLE_CE_ILOGGING:
				setEnableCEIlogging(newValue);
				return;
			case WpsPackage.TASK_CONTAINER__ESCALATIONPASSWORD:
				setEscalationpassword(newValue);
				return;
			case WpsPackage.TASK_CONTAINER__HOLD_QUEUE:
				setHoldQueue(newValue);
				return;
			case WpsPackage.TASK_CONTAINER__JMS_CONNECTION_FACTORY:
				setJMSConnectionFactory(newValue);
				return;
			case WpsPackage.TASK_CONTAINER__JMS_PASSWORD:
				setJMSPassword(newValue);
				return;
			case WpsPackage.TASK_CONTAINER__JMS_PROVIDER:
				setJMSProvider(newValue);
				return;
			case WpsPackage.TASK_CONTAINER__JMS_RESOURCES:
				setJMSResources(newValue);
				return;
			case WpsPackage.TASK_CONTAINER__JMS_USER_ID:
				setJMSUserID(newValue);
				return;
			case WpsPackage.TASK_CONTAINER__MAIL_SESSION:
				setMailSession(newValue);
				return;
			case WpsPackage.TASK_CONTAINER__QUEUE_MANAGER:
				setQueueManager(newValue);
				return;
			case WpsPackage.TASK_CONTAINER__SYSTEM_MONITOR_SECURITY_ROLE_MAPPING:
				setSystemMonitorSecurityRoleMapping(newValue);
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
			case WpsPackage.TASK_CONTAINER__ADMINISTRATOR_SECURITY_ROLE_MAPPING:
				setAdministratorSecurityRoleMapping(ADMINISTRATOR_SECURITY_ROLE_MAPPING_EDEFAULT);
				return;
			case WpsPackage.TASK_CONTAINER__CLASSPATH:
				setClasspath(CLASSPATH_EDEFAULT);
				return;
			case WpsPackage.TASK_CONTAINER__ENABLE_AUDIT_LOG:
				setEnableAuditLog(ENABLE_AUDIT_LOG_EDEFAULT);
				return;
			case WpsPackage.TASK_CONTAINER__ENABLE_CE_ILOGGING:
				setEnableCEIlogging(ENABLE_CE_ILOGGING_EDEFAULT);
				return;
			case WpsPackage.TASK_CONTAINER__ESCALATIONPASSWORD:
				setEscalationpassword(ESCALATIONPASSWORD_EDEFAULT);
				return;
			case WpsPackage.TASK_CONTAINER__HOLD_QUEUE:
				setHoldQueue(HOLD_QUEUE_EDEFAULT);
				return;
			case WpsPackage.TASK_CONTAINER__JMS_CONNECTION_FACTORY:
				setJMSConnectionFactory(JMS_CONNECTION_FACTORY_EDEFAULT);
				return;
			case WpsPackage.TASK_CONTAINER__JMS_PASSWORD:
				setJMSPassword(JMS_PASSWORD_EDEFAULT);
				return;
			case WpsPackage.TASK_CONTAINER__JMS_PROVIDER:
				setJMSProvider(JMS_PROVIDER_EDEFAULT);
				return;
			case WpsPackage.TASK_CONTAINER__JMS_RESOURCES:
				setJMSResources(JMS_RESOURCES_EDEFAULT);
				return;
			case WpsPackage.TASK_CONTAINER__JMS_USER_ID:
				setJMSUserID(JMS_USER_ID_EDEFAULT);
				return;
			case WpsPackage.TASK_CONTAINER__MAIL_SESSION:
				setMailSession(MAIL_SESSION_EDEFAULT);
				return;
			case WpsPackage.TASK_CONTAINER__QUEUE_MANAGER:
				setQueueManager(QUEUE_MANAGER_EDEFAULT);
				return;
			case WpsPackage.TASK_CONTAINER__SYSTEM_MONITOR_SECURITY_ROLE_MAPPING:
				setSystemMonitorSecurityRoleMapping(SYSTEM_MONITOR_SECURITY_ROLE_MAPPING_EDEFAULT);
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
			case WpsPackage.TASK_CONTAINER__ADMINISTRATOR_SECURITY_ROLE_MAPPING:
				return ADMINISTRATOR_SECURITY_ROLE_MAPPING_EDEFAULT == null ? administratorSecurityRoleMapping != null : !ADMINISTRATOR_SECURITY_ROLE_MAPPING_EDEFAULT.equals(administratorSecurityRoleMapping);
			case WpsPackage.TASK_CONTAINER__CLASSPATH:
				return CLASSPATH_EDEFAULT == null ? classpath != null : !CLASSPATH_EDEFAULT.equals(classpath);
			case WpsPackage.TASK_CONTAINER__ENABLE_AUDIT_LOG:
				return ENABLE_AUDIT_LOG_EDEFAULT == null ? enableAuditLog != null : !ENABLE_AUDIT_LOG_EDEFAULT.equals(enableAuditLog);
			case WpsPackage.TASK_CONTAINER__ENABLE_CE_ILOGGING:
				return ENABLE_CE_ILOGGING_EDEFAULT == null ? enableCEIlogging != null : !ENABLE_CE_ILOGGING_EDEFAULT.equals(enableCEIlogging);
			case WpsPackage.TASK_CONTAINER__ESCALATIONPASSWORD:
				return ESCALATIONPASSWORD_EDEFAULT == null ? escalationpassword != null : !ESCALATIONPASSWORD_EDEFAULT.equals(escalationpassword);
			case WpsPackage.TASK_CONTAINER__HOLD_QUEUE:
				return HOLD_QUEUE_EDEFAULT == null ? holdQueue != null : !HOLD_QUEUE_EDEFAULT.equals(holdQueue);
			case WpsPackage.TASK_CONTAINER__JMS_CONNECTION_FACTORY:
				return JMS_CONNECTION_FACTORY_EDEFAULT == null ? jMSConnectionFactory != null : !JMS_CONNECTION_FACTORY_EDEFAULT.equals(jMSConnectionFactory);
			case WpsPackage.TASK_CONTAINER__JMS_PASSWORD:
				return JMS_PASSWORD_EDEFAULT == null ? jMSPassword != null : !JMS_PASSWORD_EDEFAULT.equals(jMSPassword);
			case WpsPackage.TASK_CONTAINER__JMS_PROVIDER:
				return JMS_PROVIDER_EDEFAULT == null ? jMSProvider != null : !JMS_PROVIDER_EDEFAULT.equals(jMSProvider);
			case WpsPackage.TASK_CONTAINER__JMS_RESOURCES:
				return JMS_RESOURCES_EDEFAULT == null ? jMSResources != null : !JMS_RESOURCES_EDEFAULT.equals(jMSResources);
			case WpsPackage.TASK_CONTAINER__JMS_USER_ID:
				return JMS_USER_ID_EDEFAULT == null ? jMSUserID != null : !JMS_USER_ID_EDEFAULT.equals(jMSUserID);
			case WpsPackage.TASK_CONTAINER__MAIL_SESSION:
				return MAIL_SESSION_EDEFAULT == null ? mailSession != null : !MAIL_SESSION_EDEFAULT.equals(mailSession);
			case WpsPackage.TASK_CONTAINER__QUEUE_MANAGER:
				return QUEUE_MANAGER_EDEFAULT == null ? queueManager != null : !QUEUE_MANAGER_EDEFAULT.equals(queueManager);
			case WpsPackage.TASK_CONTAINER__SYSTEM_MONITOR_SECURITY_ROLE_MAPPING:
				return SYSTEM_MONITOR_SECURITY_ROLE_MAPPING_EDEFAULT == null ? systemMonitorSecurityRoleMapping != null : !SYSTEM_MONITOR_SECURITY_ROLE_MAPPING_EDEFAULT.equals(systemMonitorSecurityRoleMapping);
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
		result.append(" (administratorSecurityRoleMapping: "); //$NON-NLS-1$
		result.append(administratorSecurityRoleMapping);
		result.append(", classpath: "); //$NON-NLS-1$
		result.append(classpath);
		result.append(", enableAuditLog: "); //$NON-NLS-1$
		result.append(enableAuditLog);
		result.append(", enableCEIlogging: "); //$NON-NLS-1$
		result.append(enableCEIlogging);
		result.append(", escalationpassword: "); //$NON-NLS-1$
		result.append(escalationpassword);
		result.append(", holdQueue: "); //$NON-NLS-1$
		result.append(holdQueue);
		result.append(", jMSConnectionFactory: "); //$NON-NLS-1$
		result.append(jMSConnectionFactory);
		result.append(", jMSPassword: "); //$NON-NLS-1$
		result.append(jMSPassword);
		result.append(", jMSProvider: "); //$NON-NLS-1$
		result.append(jMSProvider);
		result.append(", jMSResources: "); //$NON-NLS-1$
		result.append(jMSResources);
		result.append(", jMSUserID: "); //$NON-NLS-1$
		result.append(jMSUserID);
		result.append(", mailSession: "); //$NON-NLS-1$
		result.append(mailSession);
		result.append(", queueManager: "); //$NON-NLS-1$
		result.append(queueManager);
		result.append(", systemMonitorSecurityRoleMapping: "); //$NON-NLS-1$
		result.append(systemMonitorSecurityRoleMapping);
		result.append(')');
		return result.toString();
	}

} //TaskContainerImpl
