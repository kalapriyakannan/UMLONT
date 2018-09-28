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
import com.ibm.ccl.soa.deploy.wps.BPEContainer;
import com.ibm.ccl.soa.deploy.wps.WpsPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>BPE Container</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link com.ibm.ccl.soa.deploy.wps.impl.BPEContainerImpl#getAdministratorSecurityRoleMapping <em>Administrator Security Role Mapping</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.wps.impl.BPEContainerImpl#getClasspath <em>Classpath</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.wps.impl.BPEContainerImpl#getDataSourcePassword <em>Data Source Password</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.wps.impl.BPEContainerImpl#getDataSourceUsername <em>Data Source Username</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.wps.impl.BPEContainerImpl#getEnableAuditLog <em>Enable Audit Log</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.wps.impl.BPEContainerImpl#getEnableCEIlogging <em>Enable CE Ilogging</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.wps.impl.BPEContainerImpl#getExternalRequestProcessingQueue <em>External Request Processing Queue</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.wps.impl.BPEContainerImpl#getHoldQueue <em>Hold Queue</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.wps.impl.BPEContainerImpl#getImplementationClassName <em>Implementation Class Name</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.wps.impl.BPEContainerImpl#getInstallBusinessProcessChoreographerExplorer <em>Install Business Process Choreographer Explorer</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.wps.impl.BPEContainerImpl#getInternalQueue <em>Internal Queue</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.wps.impl.BPEContainerImpl#getJDBCProvider <em>JDBC Provider</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.wps.impl.BPEContainerImpl#getJMSAPIPassword <em>JMSAPI Password</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.wps.impl.BPEContainerImpl#getJMSAPIUserID <em>JMSAPI User ID</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.wps.impl.BPEContainerImpl#getJMSConnectionFactory <em>JMS Connection Factory</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.wps.impl.BPEContainerImpl#getJMSPassword <em>JMS Password</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.wps.impl.BPEContainerImpl#getJMSProvider <em>JMS Provider</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.wps.impl.BPEContainerImpl#getJMSResources <em>JMS Resources</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.wps.impl.BPEContainerImpl#getJMSUserID <em>JMS User ID</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.wps.impl.BPEContainerImpl#getQueueManager <em>Queue Manager</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.wps.impl.BPEContainerImpl#getRetentionQueue <em>Retention Queue</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.wps.impl.BPEContainerImpl#getSystemMonitorSecurityRoleMapping <em>System Monitor Security Role Mapping</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class BPEContainerImpl extends CapabilityImpl implements BPEContainer {
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
	 * The default value of the '{@link #getDataSourcePassword() <em>Data Source Password</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDataSourcePassword()
	 * @generated
	 * @ordered
	 */
	protected static final Object DATA_SOURCE_PASSWORD_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getDataSourcePassword() <em>Data Source Password</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDataSourcePassword()
	 * @generated
	 * @ordered
	 */
	protected Object dataSourcePassword = DATA_SOURCE_PASSWORD_EDEFAULT;

	/**
	 * The default value of the '{@link #getDataSourceUsername() <em>Data Source Username</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDataSourceUsername()
	 * @generated
	 * @ordered
	 */
	protected static final Object DATA_SOURCE_USERNAME_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getDataSourceUsername() <em>Data Source Username</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDataSourceUsername()
	 * @generated
	 * @ordered
	 */
	protected Object dataSourceUsername = DATA_SOURCE_USERNAME_EDEFAULT;

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
	 * The default value of the '{@link #getExternalRequestProcessingQueue() <em>External Request Processing Queue</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getExternalRequestProcessingQueue()
	 * @generated
	 * @ordered
	 */
	protected static final Object EXTERNAL_REQUEST_PROCESSING_QUEUE_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getExternalRequestProcessingQueue() <em>External Request Processing Queue</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getExternalRequestProcessingQueue()
	 * @generated
	 * @ordered
	 */
	protected Object externalRequestProcessingQueue = EXTERNAL_REQUEST_PROCESSING_QUEUE_EDEFAULT;

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
	 * The default value of the '{@link #getImplementationClassName() <em>Implementation Class Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getImplementationClassName()
	 * @generated
	 * @ordered
	 */
	protected static final Object IMPLEMENTATION_CLASS_NAME_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getImplementationClassName() <em>Implementation Class Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getImplementationClassName()
	 * @generated
	 * @ordered
	 */
	protected Object implementationClassName = IMPLEMENTATION_CLASS_NAME_EDEFAULT;

	/**
	 * The default value of the '{@link #getInstallBusinessProcessChoreographerExplorer() <em>Install Business Process Choreographer Explorer</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getInstallBusinessProcessChoreographerExplorer()
	 * @generated
	 * @ordered
	 */
	protected static final Object INSTALL_BUSINESS_PROCESS_CHOREOGRAPHER_EXPLORER_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getInstallBusinessProcessChoreographerExplorer() <em>Install Business Process Choreographer Explorer</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getInstallBusinessProcessChoreographerExplorer()
	 * @generated
	 * @ordered
	 */
	protected Object installBusinessProcessChoreographerExplorer = INSTALL_BUSINESS_PROCESS_CHOREOGRAPHER_EXPLORER_EDEFAULT;

	/**
	 * The default value of the '{@link #getInternalQueue() <em>Internal Queue</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getInternalQueue()
	 * @generated
	 * @ordered
	 */
	protected static final Object INTERNAL_QUEUE_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getInternalQueue() <em>Internal Queue</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getInternalQueue()
	 * @generated
	 * @ordered
	 */
	protected Object internalQueue = INTERNAL_QUEUE_EDEFAULT;

	/**
	 * The default value of the '{@link #getJDBCProvider() <em>JDBC Provider</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getJDBCProvider()
	 * @generated
	 * @ordered
	 */
	protected static final Object JDBC_PROVIDER_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getJDBCProvider() <em>JDBC Provider</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getJDBCProvider()
	 * @generated
	 * @ordered
	 */
	protected Object jDBCProvider = JDBC_PROVIDER_EDEFAULT;

	/**
	 * The default value of the '{@link #getJMSAPIPassword() <em>JMSAPI Password</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getJMSAPIPassword()
	 * @generated
	 * @ordered
	 */
	protected static final Object JMSAPI_PASSWORD_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getJMSAPIPassword() <em>JMSAPI Password</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getJMSAPIPassword()
	 * @generated
	 * @ordered
	 */
	protected Object jMSAPIPassword = JMSAPI_PASSWORD_EDEFAULT;

	/**
	 * The default value of the '{@link #getJMSAPIUserID() <em>JMSAPI User ID</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getJMSAPIUserID()
	 * @generated
	 * @ordered
	 */
	protected static final Object JMSAPI_USER_ID_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getJMSAPIUserID() <em>JMSAPI User ID</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getJMSAPIUserID()
	 * @generated
	 * @ordered
	 */
	protected Object jMSAPIUserID = JMSAPI_USER_ID_EDEFAULT;

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
	 * The default value of the '{@link #getRetentionQueue() <em>Retention Queue</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getRetentionQueue()
	 * @generated
	 * @ordered
	 */
	protected static final Object RETENTION_QUEUE_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getRetentionQueue() <em>Retention Queue</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getRetentionQueue()
	 * @generated
	 * @ordered
	 */
	protected Object retentionQueue = RETENTION_QUEUE_EDEFAULT;

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
	protected BPEContainerImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected EClass eStaticClass() {
		return WpsPackage.Literals.BPE_CONTAINER;
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
			eNotify(new ENotificationImpl(this, Notification.SET, WpsPackage.BPE_CONTAINER__ADMINISTRATOR_SECURITY_ROLE_MAPPING, oldAdministratorSecurityRoleMapping, administratorSecurityRoleMapping));
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
			eNotify(new ENotificationImpl(this, Notification.SET, WpsPackage.BPE_CONTAINER__CLASSPATH, oldClasspath, classpath));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Object getDataSourcePassword() {
		return dataSourcePassword;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setDataSourcePassword(Object newDataSourcePassword) {
		Object oldDataSourcePassword = dataSourcePassword;
		dataSourcePassword = newDataSourcePassword;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, WpsPackage.BPE_CONTAINER__DATA_SOURCE_PASSWORD, oldDataSourcePassword, dataSourcePassword));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Object getDataSourceUsername() {
		return dataSourceUsername;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setDataSourceUsername(Object newDataSourceUsername) {
		Object oldDataSourceUsername = dataSourceUsername;
		dataSourceUsername = newDataSourceUsername;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, WpsPackage.BPE_CONTAINER__DATA_SOURCE_USERNAME, oldDataSourceUsername, dataSourceUsername));
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
			eNotify(new ENotificationImpl(this, Notification.SET, WpsPackage.BPE_CONTAINER__ENABLE_AUDIT_LOG, oldEnableAuditLog, enableAuditLog));
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
			eNotify(new ENotificationImpl(this, Notification.SET, WpsPackage.BPE_CONTAINER__ENABLE_CE_ILOGGING, oldEnableCEIlogging, enableCEIlogging));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Object getExternalRequestProcessingQueue() {
		return externalRequestProcessingQueue;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setExternalRequestProcessingQueue(Object newExternalRequestProcessingQueue) {
		Object oldExternalRequestProcessingQueue = externalRequestProcessingQueue;
		externalRequestProcessingQueue = newExternalRequestProcessingQueue;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, WpsPackage.BPE_CONTAINER__EXTERNAL_REQUEST_PROCESSING_QUEUE, oldExternalRequestProcessingQueue, externalRequestProcessingQueue));
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
			eNotify(new ENotificationImpl(this, Notification.SET, WpsPackage.BPE_CONTAINER__HOLD_QUEUE, oldHoldQueue, holdQueue));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Object getImplementationClassName() {
		return implementationClassName;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setImplementationClassName(Object newImplementationClassName) {
		Object oldImplementationClassName = implementationClassName;
		implementationClassName = newImplementationClassName;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, WpsPackage.BPE_CONTAINER__IMPLEMENTATION_CLASS_NAME, oldImplementationClassName, implementationClassName));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Object getInstallBusinessProcessChoreographerExplorer() {
		return installBusinessProcessChoreographerExplorer;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setInstallBusinessProcessChoreographerExplorer(Object newInstallBusinessProcessChoreographerExplorer) {
		Object oldInstallBusinessProcessChoreographerExplorer = installBusinessProcessChoreographerExplorer;
		installBusinessProcessChoreographerExplorer = newInstallBusinessProcessChoreographerExplorer;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, WpsPackage.BPE_CONTAINER__INSTALL_BUSINESS_PROCESS_CHOREOGRAPHER_EXPLORER, oldInstallBusinessProcessChoreographerExplorer, installBusinessProcessChoreographerExplorer));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Object getInternalQueue() {
		return internalQueue;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setInternalQueue(Object newInternalQueue) {
		Object oldInternalQueue = internalQueue;
		internalQueue = newInternalQueue;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, WpsPackage.BPE_CONTAINER__INTERNAL_QUEUE, oldInternalQueue, internalQueue));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Object getJDBCProvider() {
		return jDBCProvider;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setJDBCProvider(Object newJDBCProvider) {
		Object oldJDBCProvider = jDBCProvider;
		jDBCProvider = newJDBCProvider;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, WpsPackage.BPE_CONTAINER__JDBC_PROVIDER, oldJDBCProvider, jDBCProvider));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Object getJMSAPIPassword() {
		return jMSAPIPassword;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setJMSAPIPassword(Object newJMSAPIPassword) {
		Object oldJMSAPIPassword = jMSAPIPassword;
		jMSAPIPassword = newJMSAPIPassword;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, WpsPackage.BPE_CONTAINER__JMSAPI_PASSWORD, oldJMSAPIPassword, jMSAPIPassword));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Object getJMSAPIUserID() {
		return jMSAPIUserID;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setJMSAPIUserID(Object newJMSAPIUserID) {
		Object oldJMSAPIUserID = jMSAPIUserID;
		jMSAPIUserID = newJMSAPIUserID;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, WpsPackage.BPE_CONTAINER__JMSAPI_USER_ID, oldJMSAPIUserID, jMSAPIUserID));
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
			eNotify(new ENotificationImpl(this, Notification.SET, WpsPackage.BPE_CONTAINER__JMS_CONNECTION_FACTORY, oldJMSConnectionFactory, jMSConnectionFactory));
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
			eNotify(new ENotificationImpl(this, Notification.SET, WpsPackage.BPE_CONTAINER__JMS_PASSWORD, oldJMSPassword, jMSPassword));
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
			eNotify(new ENotificationImpl(this, Notification.SET, WpsPackage.BPE_CONTAINER__JMS_PROVIDER, oldJMSProvider, jMSProvider));
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
			eNotify(new ENotificationImpl(this, Notification.SET, WpsPackage.BPE_CONTAINER__JMS_RESOURCES, oldJMSResources, jMSResources));
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
			eNotify(new ENotificationImpl(this, Notification.SET, WpsPackage.BPE_CONTAINER__JMS_USER_ID, oldJMSUserID, jMSUserID));
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
			eNotify(new ENotificationImpl(this, Notification.SET, WpsPackage.BPE_CONTAINER__QUEUE_MANAGER, oldQueueManager, queueManager));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Object getRetentionQueue() {
		return retentionQueue;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setRetentionQueue(Object newRetentionQueue) {
		Object oldRetentionQueue = retentionQueue;
		retentionQueue = newRetentionQueue;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, WpsPackage.BPE_CONTAINER__RETENTION_QUEUE, oldRetentionQueue, retentionQueue));
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
			eNotify(new ENotificationImpl(this, Notification.SET, WpsPackage.BPE_CONTAINER__SYSTEM_MONITOR_SECURITY_ROLE_MAPPING, oldSystemMonitorSecurityRoleMapping, systemMonitorSecurityRoleMapping));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case WpsPackage.BPE_CONTAINER__ADMINISTRATOR_SECURITY_ROLE_MAPPING:
				return getAdministratorSecurityRoleMapping();
			case WpsPackage.BPE_CONTAINER__CLASSPATH:
				return getClasspath();
			case WpsPackage.BPE_CONTAINER__DATA_SOURCE_PASSWORD:
				return getDataSourcePassword();
			case WpsPackage.BPE_CONTAINER__DATA_SOURCE_USERNAME:
				return getDataSourceUsername();
			case WpsPackage.BPE_CONTAINER__ENABLE_AUDIT_LOG:
				return getEnableAuditLog();
			case WpsPackage.BPE_CONTAINER__ENABLE_CE_ILOGGING:
				return getEnableCEIlogging();
			case WpsPackage.BPE_CONTAINER__EXTERNAL_REQUEST_PROCESSING_QUEUE:
				return getExternalRequestProcessingQueue();
			case WpsPackage.BPE_CONTAINER__HOLD_QUEUE:
				return getHoldQueue();
			case WpsPackage.BPE_CONTAINER__IMPLEMENTATION_CLASS_NAME:
				return getImplementationClassName();
			case WpsPackage.BPE_CONTAINER__INSTALL_BUSINESS_PROCESS_CHOREOGRAPHER_EXPLORER:
				return getInstallBusinessProcessChoreographerExplorer();
			case WpsPackage.BPE_CONTAINER__INTERNAL_QUEUE:
				return getInternalQueue();
			case WpsPackage.BPE_CONTAINER__JDBC_PROVIDER:
				return getJDBCProvider();
			case WpsPackage.BPE_CONTAINER__JMSAPI_PASSWORD:
				return getJMSAPIPassword();
			case WpsPackage.BPE_CONTAINER__JMSAPI_USER_ID:
				return getJMSAPIUserID();
			case WpsPackage.BPE_CONTAINER__JMS_CONNECTION_FACTORY:
				return getJMSConnectionFactory();
			case WpsPackage.BPE_CONTAINER__JMS_PASSWORD:
				return getJMSPassword();
			case WpsPackage.BPE_CONTAINER__JMS_PROVIDER:
				return getJMSProvider();
			case WpsPackage.BPE_CONTAINER__JMS_RESOURCES:
				return getJMSResources();
			case WpsPackage.BPE_CONTAINER__JMS_USER_ID:
				return getJMSUserID();
			case WpsPackage.BPE_CONTAINER__QUEUE_MANAGER:
				return getQueueManager();
			case WpsPackage.BPE_CONTAINER__RETENTION_QUEUE:
				return getRetentionQueue();
			case WpsPackage.BPE_CONTAINER__SYSTEM_MONITOR_SECURITY_ROLE_MAPPING:
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
			case WpsPackage.BPE_CONTAINER__ADMINISTRATOR_SECURITY_ROLE_MAPPING:
				setAdministratorSecurityRoleMapping(newValue);
				return;
			case WpsPackage.BPE_CONTAINER__CLASSPATH:
				setClasspath(newValue);
				return;
			case WpsPackage.BPE_CONTAINER__DATA_SOURCE_PASSWORD:
				setDataSourcePassword(newValue);
				return;
			case WpsPackage.BPE_CONTAINER__DATA_SOURCE_USERNAME:
				setDataSourceUsername(newValue);
				return;
			case WpsPackage.BPE_CONTAINER__ENABLE_AUDIT_LOG:
				setEnableAuditLog(newValue);
				return;
			case WpsPackage.BPE_CONTAINER__ENABLE_CE_ILOGGING:
				setEnableCEIlogging(newValue);
				return;
			case WpsPackage.BPE_CONTAINER__EXTERNAL_REQUEST_PROCESSING_QUEUE:
				setExternalRequestProcessingQueue(newValue);
				return;
			case WpsPackage.BPE_CONTAINER__HOLD_QUEUE:
				setHoldQueue(newValue);
				return;
			case WpsPackage.BPE_CONTAINER__IMPLEMENTATION_CLASS_NAME:
				setImplementationClassName(newValue);
				return;
			case WpsPackage.BPE_CONTAINER__INSTALL_BUSINESS_PROCESS_CHOREOGRAPHER_EXPLORER:
				setInstallBusinessProcessChoreographerExplorer(newValue);
				return;
			case WpsPackage.BPE_CONTAINER__INTERNAL_QUEUE:
				setInternalQueue(newValue);
				return;
			case WpsPackage.BPE_CONTAINER__JDBC_PROVIDER:
				setJDBCProvider(newValue);
				return;
			case WpsPackage.BPE_CONTAINER__JMSAPI_PASSWORD:
				setJMSAPIPassword(newValue);
				return;
			case WpsPackage.BPE_CONTAINER__JMSAPI_USER_ID:
				setJMSAPIUserID(newValue);
				return;
			case WpsPackage.BPE_CONTAINER__JMS_CONNECTION_FACTORY:
				setJMSConnectionFactory(newValue);
				return;
			case WpsPackage.BPE_CONTAINER__JMS_PASSWORD:
				setJMSPassword(newValue);
				return;
			case WpsPackage.BPE_CONTAINER__JMS_PROVIDER:
				setJMSProvider(newValue);
				return;
			case WpsPackage.BPE_CONTAINER__JMS_RESOURCES:
				setJMSResources(newValue);
				return;
			case WpsPackage.BPE_CONTAINER__JMS_USER_ID:
				setJMSUserID(newValue);
				return;
			case WpsPackage.BPE_CONTAINER__QUEUE_MANAGER:
				setQueueManager(newValue);
				return;
			case WpsPackage.BPE_CONTAINER__RETENTION_QUEUE:
				setRetentionQueue(newValue);
				return;
			case WpsPackage.BPE_CONTAINER__SYSTEM_MONITOR_SECURITY_ROLE_MAPPING:
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
			case WpsPackage.BPE_CONTAINER__ADMINISTRATOR_SECURITY_ROLE_MAPPING:
				setAdministratorSecurityRoleMapping(ADMINISTRATOR_SECURITY_ROLE_MAPPING_EDEFAULT);
				return;
			case WpsPackage.BPE_CONTAINER__CLASSPATH:
				setClasspath(CLASSPATH_EDEFAULT);
				return;
			case WpsPackage.BPE_CONTAINER__DATA_SOURCE_PASSWORD:
				setDataSourcePassword(DATA_SOURCE_PASSWORD_EDEFAULT);
				return;
			case WpsPackage.BPE_CONTAINER__DATA_SOURCE_USERNAME:
				setDataSourceUsername(DATA_SOURCE_USERNAME_EDEFAULT);
				return;
			case WpsPackage.BPE_CONTAINER__ENABLE_AUDIT_LOG:
				setEnableAuditLog(ENABLE_AUDIT_LOG_EDEFAULT);
				return;
			case WpsPackage.BPE_CONTAINER__ENABLE_CE_ILOGGING:
				setEnableCEIlogging(ENABLE_CE_ILOGGING_EDEFAULT);
				return;
			case WpsPackage.BPE_CONTAINER__EXTERNAL_REQUEST_PROCESSING_QUEUE:
				setExternalRequestProcessingQueue(EXTERNAL_REQUEST_PROCESSING_QUEUE_EDEFAULT);
				return;
			case WpsPackage.BPE_CONTAINER__HOLD_QUEUE:
				setHoldQueue(HOLD_QUEUE_EDEFAULT);
				return;
			case WpsPackage.BPE_CONTAINER__IMPLEMENTATION_CLASS_NAME:
				setImplementationClassName(IMPLEMENTATION_CLASS_NAME_EDEFAULT);
				return;
			case WpsPackage.BPE_CONTAINER__INSTALL_BUSINESS_PROCESS_CHOREOGRAPHER_EXPLORER:
				setInstallBusinessProcessChoreographerExplorer(INSTALL_BUSINESS_PROCESS_CHOREOGRAPHER_EXPLORER_EDEFAULT);
				return;
			case WpsPackage.BPE_CONTAINER__INTERNAL_QUEUE:
				setInternalQueue(INTERNAL_QUEUE_EDEFAULT);
				return;
			case WpsPackage.BPE_CONTAINER__JDBC_PROVIDER:
				setJDBCProvider(JDBC_PROVIDER_EDEFAULT);
				return;
			case WpsPackage.BPE_CONTAINER__JMSAPI_PASSWORD:
				setJMSAPIPassword(JMSAPI_PASSWORD_EDEFAULT);
				return;
			case WpsPackage.BPE_CONTAINER__JMSAPI_USER_ID:
				setJMSAPIUserID(JMSAPI_USER_ID_EDEFAULT);
				return;
			case WpsPackage.BPE_CONTAINER__JMS_CONNECTION_FACTORY:
				setJMSConnectionFactory(JMS_CONNECTION_FACTORY_EDEFAULT);
				return;
			case WpsPackage.BPE_CONTAINER__JMS_PASSWORD:
				setJMSPassword(JMS_PASSWORD_EDEFAULT);
				return;
			case WpsPackage.BPE_CONTAINER__JMS_PROVIDER:
				setJMSProvider(JMS_PROVIDER_EDEFAULT);
				return;
			case WpsPackage.BPE_CONTAINER__JMS_RESOURCES:
				setJMSResources(JMS_RESOURCES_EDEFAULT);
				return;
			case WpsPackage.BPE_CONTAINER__JMS_USER_ID:
				setJMSUserID(JMS_USER_ID_EDEFAULT);
				return;
			case WpsPackage.BPE_CONTAINER__QUEUE_MANAGER:
				setQueueManager(QUEUE_MANAGER_EDEFAULT);
				return;
			case WpsPackage.BPE_CONTAINER__RETENTION_QUEUE:
				setRetentionQueue(RETENTION_QUEUE_EDEFAULT);
				return;
			case WpsPackage.BPE_CONTAINER__SYSTEM_MONITOR_SECURITY_ROLE_MAPPING:
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
			case WpsPackage.BPE_CONTAINER__ADMINISTRATOR_SECURITY_ROLE_MAPPING:
				return ADMINISTRATOR_SECURITY_ROLE_MAPPING_EDEFAULT == null ? administratorSecurityRoleMapping != null : !ADMINISTRATOR_SECURITY_ROLE_MAPPING_EDEFAULT.equals(administratorSecurityRoleMapping);
			case WpsPackage.BPE_CONTAINER__CLASSPATH:
				return CLASSPATH_EDEFAULT == null ? classpath != null : !CLASSPATH_EDEFAULT.equals(classpath);
			case WpsPackage.BPE_CONTAINER__DATA_SOURCE_PASSWORD:
				return DATA_SOURCE_PASSWORD_EDEFAULT == null ? dataSourcePassword != null : !DATA_SOURCE_PASSWORD_EDEFAULT.equals(dataSourcePassword);
			case WpsPackage.BPE_CONTAINER__DATA_SOURCE_USERNAME:
				return DATA_SOURCE_USERNAME_EDEFAULT == null ? dataSourceUsername != null : !DATA_SOURCE_USERNAME_EDEFAULT.equals(dataSourceUsername);
			case WpsPackage.BPE_CONTAINER__ENABLE_AUDIT_LOG:
				return ENABLE_AUDIT_LOG_EDEFAULT == null ? enableAuditLog != null : !ENABLE_AUDIT_LOG_EDEFAULT.equals(enableAuditLog);
			case WpsPackage.BPE_CONTAINER__ENABLE_CE_ILOGGING:
				return ENABLE_CE_ILOGGING_EDEFAULT == null ? enableCEIlogging != null : !ENABLE_CE_ILOGGING_EDEFAULT.equals(enableCEIlogging);
			case WpsPackage.BPE_CONTAINER__EXTERNAL_REQUEST_PROCESSING_QUEUE:
				return EXTERNAL_REQUEST_PROCESSING_QUEUE_EDEFAULT == null ? externalRequestProcessingQueue != null : !EXTERNAL_REQUEST_PROCESSING_QUEUE_EDEFAULT.equals(externalRequestProcessingQueue);
			case WpsPackage.BPE_CONTAINER__HOLD_QUEUE:
				return HOLD_QUEUE_EDEFAULT == null ? holdQueue != null : !HOLD_QUEUE_EDEFAULT.equals(holdQueue);
			case WpsPackage.BPE_CONTAINER__IMPLEMENTATION_CLASS_NAME:
				return IMPLEMENTATION_CLASS_NAME_EDEFAULT == null ? implementationClassName != null : !IMPLEMENTATION_CLASS_NAME_EDEFAULT.equals(implementationClassName);
			case WpsPackage.BPE_CONTAINER__INSTALL_BUSINESS_PROCESS_CHOREOGRAPHER_EXPLORER:
				return INSTALL_BUSINESS_PROCESS_CHOREOGRAPHER_EXPLORER_EDEFAULT == null ? installBusinessProcessChoreographerExplorer != null : !INSTALL_BUSINESS_PROCESS_CHOREOGRAPHER_EXPLORER_EDEFAULT.equals(installBusinessProcessChoreographerExplorer);
			case WpsPackage.BPE_CONTAINER__INTERNAL_QUEUE:
				return INTERNAL_QUEUE_EDEFAULT == null ? internalQueue != null : !INTERNAL_QUEUE_EDEFAULT.equals(internalQueue);
			case WpsPackage.BPE_CONTAINER__JDBC_PROVIDER:
				return JDBC_PROVIDER_EDEFAULT == null ? jDBCProvider != null : !JDBC_PROVIDER_EDEFAULT.equals(jDBCProvider);
			case WpsPackage.BPE_CONTAINER__JMSAPI_PASSWORD:
				return JMSAPI_PASSWORD_EDEFAULT == null ? jMSAPIPassword != null : !JMSAPI_PASSWORD_EDEFAULT.equals(jMSAPIPassword);
			case WpsPackage.BPE_CONTAINER__JMSAPI_USER_ID:
				return JMSAPI_USER_ID_EDEFAULT == null ? jMSAPIUserID != null : !JMSAPI_USER_ID_EDEFAULT.equals(jMSAPIUserID);
			case WpsPackage.BPE_CONTAINER__JMS_CONNECTION_FACTORY:
				return JMS_CONNECTION_FACTORY_EDEFAULT == null ? jMSConnectionFactory != null : !JMS_CONNECTION_FACTORY_EDEFAULT.equals(jMSConnectionFactory);
			case WpsPackage.BPE_CONTAINER__JMS_PASSWORD:
				return JMS_PASSWORD_EDEFAULT == null ? jMSPassword != null : !JMS_PASSWORD_EDEFAULT.equals(jMSPassword);
			case WpsPackage.BPE_CONTAINER__JMS_PROVIDER:
				return JMS_PROVIDER_EDEFAULT == null ? jMSProvider != null : !JMS_PROVIDER_EDEFAULT.equals(jMSProvider);
			case WpsPackage.BPE_CONTAINER__JMS_RESOURCES:
				return JMS_RESOURCES_EDEFAULT == null ? jMSResources != null : !JMS_RESOURCES_EDEFAULT.equals(jMSResources);
			case WpsPackage.BPE_CONTAINER__JMS_USER_ID:
				return JMS_USER_ID_EDEFAULT == null ? jMSUserID != null : !JMS_USER_ID_EDEFAULT.equals(jMSUserID);
			case WpsPackage.BPE_CONTAINER__QUEUE_MANAGER:
				return QUEUE_MANAGER_EDEFAULT == null ? queueManager != null : !QUEUE_MANAGER_EDEFAULT.equals(queueManager);
			case WpsPackage.BPE_CONTAINER__RETENTION_QUEUE:
				return RETENTION_QUEUE_EDEFAULT == null ? retentionQueue != null : !RETENTION_QUEUE_EDEFAULT.equals(retentionQueue);
			case WpsPackage.BPE_CONTAINER__SYSTEM_MONITOR_SECURITY_ROLE_MAPPING:
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
		result.append(", dataSourcePassword: "); //$NON-NLS-1$
		result.append(dataSourcePassword);
		result.append(", dataSourceUsername: "); //$NON-NLS-1$
		result.append(dataSourceUsername);
		result.append(", enableAuditLog: "); //$NON-NLS-1$
		result.append(enableAuditLog);
		result.append(", enableCEIlogging: "); //$NON-NLS-1$
		result.append(enableCEIlogging);
		result.append(", externalRequestProcessingQueue: "); //$NON-NLS-1$
		result.append(externalRequestProcessingQueue);
		result.append(", holdQueue: "); //$NON-NLS-1$
		result.append(holdQueue);
		result.append(", implementationClassName: "); //$NON-NLS-1$
		result.append(implementationClassName);
		result.append(", installBusinessProcessChoreographerExplorer: "); //$NON-NLS-1$
		result.append(installBusinessProcessChoreographerExplorer);
		result.append(", internalQueue: "); //$NON-NLS-1$
		result.append(internalQueue);
		result.append(", jDBCProvider: "); //$NON-NLS-1$
		result.append(jDBCProvider);
		result.append(", jMSAPIPassword: "); //$NON-NLS-1$
		result.append(jMSAPIPassword);
		result.append(", jMSAPIUserID: "); //$NON-NLS-1$
		result.append(jMSAPIUserID);
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
		result.append(", queueManager: "); //$NON-NLS-1$
		result.append(queueManager);
		result.append(", retentionQueue: "); //$NON-NLS-1$
		result.append(retentionQueue);
		result.append(", systemMonitorSecurityRoleMapping: "); //$NON-NLS-1$
		result.append(systemMonitorSecurityRoleMapping);
		result.append(')');
		return result.toString();
	}

} //BPEContainerImpl
