/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package com.ibm.ccl.soa.deploy.wps;

import com.ibm.ccl.soa.deploy.core.Capability;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Task Container</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link com.ibm.ccl.soa.deploy.wps.TaskContainer#getAdministratorSecurityRoleMapping <em>Administrator Security Role Mapping</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.wps.TaskContainer#getClasspath <em>Classpath</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.wps.TaskContainer#getEnableAuditLog <em>Enable Audit Log</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.wps.TaskContainer#getEnableCEIlogging <em>Enable CE Ilogging</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.wps.TaskContainer#getEscalationpassword <em>Escalationpassword</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.wps.TaskContainer#getHoldQueue <em>Hold Queue</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.wps.TaskContainer#getJMSConnectionFactory <em>JMS Connection Factory</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.wps.TaskContainer#getJMSPassword <em>JMS Password</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.wps.TaskContainer#getJMSProvider <em>JMS Provider</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.wps.TaskContainer#getJMSResources <em>JMS Resources</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.wps.TaskContainer#getJMSUserID <em>JMS User ID</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.wps.TaskContainer#getMailSession <em>Mail Session</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.wps.TaskContainer#getQueueManager <em>Queue Manager</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.wps.TaskContainer#getSystemMonitorSecurityRoleMapping <em>System Monitor Security Role Mapping</em>}</li>
 * </ul>
 * </p>
 *
 * @see com.ibm.ccl.soa.deploy.wps.WpsPackage#getTaskContainer()
 * @model extendedMetaData="name='TaskContainer' kind='elementOnly'"
 * @generated
 */
public interface TaskContainer extends Capability {
	/**
	 * Returns the value of the '<em><b>Administrator Security Role Mapping</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Administrator Security Role Mapping</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Administrator Security Role Mapping</em>' attribute.
	 * @see #setAdministratorSecurityRoleMapping(Object)
	 * @see com.ibm.ccl.soa.deploy.wps.WpsPackage#getTaskContainer_AdministratorSecurityRoleMapping()
	 * @model dataType="org.eclipse.emf.ecore.xml.type.AnySimpleType"
	 *        extendedMetaData="kind='attribute' name='AdministratorSecurityRoleMapping'"
	 * @generated
	 */
	Object getAdministratorSecurityRoleMapping();

	/**
	 * Sets the value of the '{@link com.ibm.ccl.soa.deploy.wps.TaskContainer#getAdministratorSecurityRoleMapping <em>Administrator Security Role Mapping</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Administrator Security Role Mapping</em>' attribute.
	 * @see #getAdministratorSecurityRoleMapping()
	 * @generated
	 */
	void setAdministratorSecurityRoleMapping(Object value);

	/**
	 * Returns the value of the '<em><b>Classpath</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Classpath</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Classpath</em>' attribute.
	 * @see #setClasspath(Object)
	 * @see com.ibm.ccl.soa.deploy.wps.WpsPackage#getTaskContainer_Classpath()
	 * @model dataType="org.eclipse.emf.ecore.xml.type.AnySimpleType"
	 *        extendedMetaData="kind='attribute' name='Classpath'"
	 * @generated
	 */
	Object getClasspath();

	/**
	 * Sets the value of the '{@link com.ibm.ccl.soa.deploy.wps.TaskContainer#getClasspath <em>Classpath</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Classpath</em>' attribute.
	 * @see #getClasspath()
	 * @generated
	 */
	void setClasspath(Object value);

	/**
	 * Returns the value of the '<em><b>Enable Audit Log</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Enable Audit Log</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Enable Audit Log</em>' attribute.
	 * @see #setEnableAuditLog(Object)
	 * @see com.ibm.ccl.soa.deploy.wps.WpsPackage#getTaskContainer_EnableAuditLog()
	 * @model dataType="org.eclipse.emf.ecore.xml.type.AnySimpleType"
	 *        extendedMetaData="kind='attribute' name='EnableAuditLog'"
	 * @generated
	 */
	Object getEnableAuditLog();

	/**
	 * Sets the value of the '{@link com.ibm.ccl.soa.deploy.wps.TaskContainer#getEnableAuditLog <em>Enable Audit Log</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Enable Audit Log</em>' attribute.
	 * @see #getEnableAuditLog()
	 * @generated
	 */
	void setEnableAuditLog(Object value);

	/**
	 * Returns the value of the '<em><b>Enable CE Ilogging</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Enable CE Ilogging</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Enable CE Ilogging</em>' attribute.
	 * @see #setEnableCEIlogging(Object)
	 * @see com.ibm.ccl.soa.deploy.wps.WpsPackage#getTaskContainer_EnableCEIlogging()
	 * @model dataType="org.eclipse.emf.ecore.xml.type.AnySimpleType"
	 *        extendedMetaData="kind='attribute' name='EnableCEIlogging'"
	 * @generated
	 */
	Object getEnableCEIlogging();

	/**
	 * Sets the value of the '{@link com.ibm.ccl.soa.deploy.wps.TaskContainer#getEnableCEIlogging <em>Enable CE Ilogging</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Enable CE Ilogging</em>' attribute.
	 * @see #getEnableCEIlogging()
	 * @generated
	 */
	void setEnableCEIlogging(Object value);

	/**
	 * Returns the value of the '<em><b>Escalationpassword</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Escalationpassword</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Escalationpassword</em>' attribute.
	 * @see #setEscalationpassword(Object)
	 * @see com.ibm.ccl.soa.deploy.wps.WpsPackage#getTaskContainer_Escalationpassword()
	 * @model dataType="org.eclipse.emf.ecore.xml.type.AnySimpleType"
	 *        extendedMetaData="kind='attribute' name='Escalationpassword'"
	 * @generated
	 */
	Object getEscalationpassword();

	/**
	 * Sets the value of the '{@link com.ibm.ccl.soa.deploy.wps.TaskContainer#getEscalationpassword <em>Escalationpassword</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Escalationpassword</em>' attribute.
	 * @see #getEscalationpassword()
	 * @generated
	 */
	void setEscalationpassword(Object value);

	/**
	 * Returns the value of the '<em><b>Hold Queue</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Hold Queue</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Hold Queue</em>' attribute.
	 * @see #setHoldQueue(Object)
	 * @see com.ibm.ccl.soa.deploy.wps.WpsPackage#getTaskContainer_HoldQueue()
	 * @model dataType="org.eclipse.emf.ecore.xml.type.AnySimpleType"
	 *        extendedMetaData="kind='attribute' name='HoldQueue'"
	 * @generated
	 */
	Object getHoldQueue();

	/**
	 * Sets the value of the '{@link com.ibm.ccl.soa.deploy.wps.TaskContainer#getHoldQueue <em>Hold Queue</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Hold Queue</em>' attribute.
	 * @see #getHoldQueue()
	 * @generated
	 */
	void setHoldQueue(Object value);

	/**
	 * Returns the value of the '<em><b>JMS Connection Factory</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>JMS Connection Factory</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>JMS Connection Factory</em>' attribute.
	 * @see #setJMSConnectionFactory(Object)
	 * @see com.ibm.ccl.soa.deploy.wps.WpsPackage#getTaskContainer_JMSConnectionFactory()
	 * @model dataType="org.eclipse.emf.ecore.xml.type.AnySimpleType"
	 *        extendedMetaData="kind='attribute' name='JMSConnectionFactory'"
	 * @generated
	 */
	Object getJMSConnectionFactory();

	/**
	 * Sets the value of the '{@link com.ibm.ccl.soa.deploy.wps.TaskContainer#getJMSConnectionFactory <em>JMS Connection Factory</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>JMS Connection Factory</em>' attribute.
	 * @see #getJMSConnectionFactory()
	 * @generated
	 */
	void setJMSConnectionFactory(Object value);

	/**
	 * Returns the value of the '<em><b>JMS Password</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>JMS Password</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>JMS Password</em>' attribute.
	 * @see #setJMSPassword(Object)
	 * @see com.ibm.ccl.soa.deploy.wps.WpsPackage#getTaskContainer_JMSPassword()
	 * @model dataType="org.eclipse.emf.ecore.xml.type.AnySimpleType"
	 *        extendedMetaData="kind='attribute' name='JMSPassword'"
	 * @generated
	 */
	Object getJMSPassword();

	/**
	 * Sets the value of the '{@link com.ibm.ccl.soa.deploy.wps.TaskContainer#getJMSPassword <em>JMS Password</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>JMS Password</em>' attribute.
	 * @see #getJMSPassword()
	 * @generated
	 */
	void setJMSPassword(Object value);

	/**
	 * Returns the value of the '<em><b>JMS Provider</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>JMS Provider</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>JMS Provider</em>' attribute.
	 * @see #setJMSProvider(Object)
	 * @see com.ibm.ccl.soa.deploy.wps.WpsPackage#getTaskContainer_JMSProvider()
	 * @model dataType="org.eclipse.emf.ecore.xml.type.AnySimpleType"
	 *        extendedMetaData="kind='attribute' name='JMSProvider'"
	 * @generated
	 */
	Object getJMSProvider();

	/**
	 * Sets the value of the '{@link com.ibm.ccl.soa.deploy.wps.TaskContainer#getJMSProvider <em>JMS Provider</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>JMS Provider</em>' attribute.
	 * @see #getJMSProvider()
	 * @generated
	 */
	void setJMSProvider(Object value);

	/**
	 * Returns the value of the '<em><b>JMS Resources</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>JMS Resources</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>JMS Resources</em>' attribute.
	 * @see #setJMSResources(Object)
	 * @see com.ibm.ccl.soa.deploy.wps.WpsPackage#getTaskContainer_JMSResources()
	 * @model dataType="org.eclipse.emf.ecore.xml.type.AnySimpleType"
	 *        extendedMetaData="kind='attribute' name='JMSResources'"
	 * @generated
	 */
	Object getJMSResources();

	/**
	 * Sets the value of the '{@link com.ibm.ccl.soa.deploy.wps.TaskContainer#getJMSResources <em>JMS Resources</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>JMS Resources</em>' attribute.
	 * @see #getJMSResources()
	 * @generated
	 */
	void setJMSResources(Object value);

	/**
	 * Returns the value of the '<em><b>JMS User ID</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>JMS User ID</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>JMS User ID</em>' attribute.
	 * @see #setJMSUserID(Object)
	 * @see com.ibm.ccl.soa.deploy.wps.WpsPackage#getTaskContainer_JMSUserID()
	 * @model dataType="org.eclipse.emf.ecore.xml.type.AnySimpleType"
	 *        extendedMetaData="kind='attribute' name='JMSUserID'"
	 * @generated
	 */
	Object getJMSUserID();

	/**
	 * Sets the value of the '{@link com.ibm.ccl.soa.deploy.wps.TaskContainer#getJMSUserID <em>JMS User ID</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>JMS User ID</em>' attribute.
	 * @see #getJMSUserID()
	 * @generated
	 */
	void setJMSUserID(Object value);

	/**
	 * Returns the value of the '<em><b>Mail Session</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Mail Session</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Mail Session</em>' attribute.
	 * @see #setMailSession(Object)
	 * @see com.ibm.ccl.soa.deploy.wps.WpsPackage#getTaskContainer_MailSession()
	 * @model dataType="org.eclipse.emf.ecore.xml.type.AnySimpleType"
	 *        extendedMetaData="kind='attribute' name='MailSession'"
	 * @generated
	 */
	Object getMailSession();

	/**
	 * Sets the value of the '{@link com.ibm.ccl.soa.deploy.wps.TaskContainer#getMailSession <em>Mail Session</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Mail Session</em>' attribute.
	 * @see #getMailSession()
	 * @generated
	 */
	void setMailSession(Object value);

	/**
	 * Returns the value of the '<em><b>Queue Manager</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Queue Manager</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Queue Manager</em>' attribute.
	 * @see #setQueueManager(Object)
	 * @see com.ibm.ccl.soa.deploy.wps.WpsPackage#getTaskContainer_QueueManager()
	 * @model dataType="org.eclipse.emf.ecore.xml.type.AnySimpleType"
	 *        extendedMetaData="kind='attribute' name='QueueManager'"
	 * @generated
	 */
	Object getQueueManager();

	/**
	 * Sets the value of the '{@link com.ibm.ccl.soa.deploy.wps.TaskContainer#getQueueManager <em>Queue Manager</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Queue Manager</em>' attribute.
	 * @see #getQueueManager()
	 * @generated
	 */
	void setQueueManager(Object value);

	/**
	 * Returns the value of the '<em><b>System Monitor Security Role Mapping</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>System Monitor Security Role Mapping</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>System Monitor Security Role Mapping</em>' attribute.
	 * @see #setSystemMonitorSecurityRoleMapping(Object)
	 * @see com.ibm.ccl.soa.deploy.wps.WpsPackage#getTaskContainer_SystemMonitorSecurityRoleMapping()
	 * @model dataType="org.eclipse.emf.ecore.xml.type.AnySimpleType"
	 *        extendedMetaData="kind='attribute' name='SystemMonitorSecurityRoleMapping'"
	 * @generated
	 */
	Object getSystemMonitorSecurityRoleMapping();

	/**
	 * Sets the value of the '{@link com.ibm.ccl.soa.deploy.wps.TaskContainer#getSystemMonitorSecurityRoleMapping <em>System Monitor Security Role Mapping</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>System Monitor Security Role Mapping</em>' attribute.
	 * @see #getSystemMonitorSecurityRoleMapping()
	 * @generated
	 */
	void setSystemMonitorSecurityRoleMapping(Object value);

} // TaskContainer
