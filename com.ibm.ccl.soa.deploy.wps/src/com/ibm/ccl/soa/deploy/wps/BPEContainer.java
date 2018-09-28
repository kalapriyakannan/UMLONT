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
 * A representation of the model object '<em><b>BPE Container</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link com.ibm.ccl.soa.deploy.wps.BPEContainer#getAdministratorSecurityRoleMapping <em>Administrator Security Role Mapping</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.wps.BPEContainer#getClasspath <em>Classpath</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.wps.BPEContainer#getDataSourcePassword <em>Data Source Password</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.wps.BPEContainer#getDataSourceUsername <em>Data Source Username</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.wps.BPEContainer#getEnableAuditLog <em>Enable Audit Log</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.wps.BPEContainer#getEnableCEIlogging <em>Enable CE Ilogging</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.wps.BPEContainer#getExternalRequestProcessingQueue <em>External Request Processing Queue</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.wps.BPEContainer#getHoldQueue <em>Hold Queue</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.wps.BPEContainer#getImplementationClassName <em>Implementation Class Name</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.wps.BPEContainer#getInstallBusinessProcessChoreographerExplorer <em>Install Business Process Choreographer Explorer</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.wps.BPEContainer#getInternalQueue <em>Internal Queue</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.wps.BPEContainer#getJDBCProvider <em>JDBC Provider</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.wps.BPEContainer#getJMSAPIPassword <em>JMSAPI Password</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.wps.BPEContainer#getJMSAPIUserID <em>JMSAPI User ID</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.wps.BPEContainer#getJMSConnectionFactory <em>JMS Connection Factory</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.wps.BPEContainer#getJMSPassword <em>JMS Password</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.wps.BPEContainer#getJMSProvider <em>JMS Provider</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.wps.BPEContainer#getJMSResources <em>JMS Resources</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.wps.BPEContainer#getJMSUserID <em>JMS User ID</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.wps.BPEContainer#getQueueManager <em>Queue Manager</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.wps.BPEContainer#getRetentionQueue <em>Retention Queue</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.wps.BPEContainer#getSystemMonitorSecurityRoleMapping <em>System Monitor Security Role Mapping</em>}</li>
 * </ul>
 * </p>
 *
 * @see com.ibm.ccl.soa.deploy.wps.WpsPackage#getBPEContainer()
 * @model extendedMetaData="name='BPEContainer' kind='elementOnly'"
 * @generated
 */
public interface BPEContainer extends Capability {
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
	 * @see com.ibm.ccl.soa.deploy.wps.WpsPackage#getBPEContainer_AdministratorSecurityRoleMapping()
	 * @model dataType="org.eclipse.emf.ecore.xml.type.AnySimpleType"
	 *        extendedMetaData="kind='attribute' name='AdministratorSecurityRoleMapping'"
	 * @generated
	 */
	Object getAdministratorSecurityRoleMapping();

	/**
	 * Sets the value of the '{@link com.ibm.ccl.soa.deploy.wps.BPEContainer#getAdministratorSecurityRoleMapping <em>Administrator Security Role Mapping</em>}' attribute.
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
	 * @see com.ibm.ccl.soa.deploy.wps.WpsPackage#getBPEContainer_Classpath()
	 * @model dataType="org.eclipse.emf.ecore.xml.type.AnySimpleType"
	 *        extendedMetaData="kind='attribute' name='Classpath'"
	 * @generated
	 */
	Object getClasspath();

	/**
	 * Sets the value of the '{@link com.ibm.ccl.soa.deploy.wps.BPEContainer#getClasspath <em>Classpath</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Classpath</em>' attribute.
	 * @see #getClasspath()
	 * @generated
	 */
	void setClasspath(Object value);

	/**
	 * Returns the value of the '<em><b>Data Source Password</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Data Source Password</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Data Source Password</em>' attribute.
	 * @see #setDataSourcePassword(Object)
	 * @see com.ibm.ccl.soa.deploy.wps.WpsPackage#getBPEContainer_DataSourcePassword()
	 * @model dataType="org.eclipse.emf.ecore.xml.type.AnySimpleType"
	 *        extendedMetaData="kind='attribute' name='DataSourcePassword'"
	 * @generated
	 */
	Object getDataSourcePassword();

	/**
	 * Sets the value of the '{@link com.ibm.ccl.soa.deploy.wps.BPEContainer#getDataSourcePassword <em>Data Source Password</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Data Source Password</em>' attribute.
	 * @see #getDataSourcePassword()
	 * @generated
	 */
	void setDataSourcePassword(Object value);

	/**
	 * Returns the value of the '<em><b>Data Source Username</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Data Source Username</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Data Source Username</em>' attribute.
	 * @see #setDataSourceUsername(Object)
	 * @see com.ibm.ccl.soa.deploy.wps.WpsPackage#getBPEContainer_DataSourceUsername()
	 * @model dataType="org.eclipse.emf.ecore.xml.type.AnySimpleType"
	 *        extendedMetaData="kind='attribute' name='DataSourceUsername'"
	 * @generated
	 */
	Object getDataSourceUsername();

	/**
	 * Sets the value of the '{@link com.ibm.ccl.soa.deploy.wps.BPEContainer#getDataSourceUsername <em>Data Source Username</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Data Source Username</em>' attribute.
	 * @see #getDataSourceUsername()
	 * @generated
	 */
	void setDataSourceUsername(Object value);

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
	 * @see com.ibm.ccl.soa.deploy.wps.WpsPackage#getBPEContainer_EnableAuditLog()
	 * @model dataType="org.eclipse.emf.ecore.xml.type.AnySimpleType"
	 *        extendedMetaData="kind='attribute' name='EnableAuditLog'"
	 * @generated
	 */
	Object getEnableAuditLog();

	/**
	 * Sets the value of the '{@link com.ibm.ccl.soa.deploy.wps.BPEContainer#getEnableAuditLog <em>Enable Audit Log</em>}' attribute.
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
	 * @see com.ibm.ccl.soa.deploy.wps.WpsPackage#getBPEContainer_EnableCEIlogging()
	 * @model dataType="org.eclipse.emf.ecore.xml.type.AnySimpleType"
	 *        extendedMetaData="kind='attribute' name='EnableCEIlogging'"
	 * @generated
	 */
	Object getEnableCEIlogging();

	/**
	 * Sets the value of the '{@link com.ibm.ccl.soa.deploy.wps.BPEContainer#getEnableCEIlogging <em>Enable CE Ilogging</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Enable CE Ilogging</em>' attribute.
	 * @see #getEnableCEIlogging()
	 * @generated
	 */
	void setEnableCEIlogging(Object value);

	/**
	 * Returns the value of the '<em><b>External Request Processing Queue</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>External Request Processing Queue</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>External Request Processing Queue</em>' attribute.
	 * @see #setExternalRequestProcessingQueue(Object)
	 * @see com.ibm.ccl.soa.deploy.wps.WpsPackage#getBPEContainer_ExternalRequestProcessingQueue()
	 * @model dataType="org.eclipse.emf.ecore.xml.type.AnySimpleType"
	 *        extendedMetaData="kind='attribute' name='ExternalRequestProcessingQueue'"
	 * @generated
	 */
	Object getExternalRequestProcessingQueue();

	/**
	 * Sets the value of the '{@link com.ibm.ccl.soa.deploy.wps.BPEContainer#getExternalRequestProcessingQueue <em>External Request Processing Queue</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>External Request Processing Queue</em>' attribute.
	 * @see #getExternalRequestProcessingQueue()
	 * @generated
	 */
	void setExternalRequestProcessingQueue(Object value);

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
	 * @see com.ibm.ccl.soa.deploy.wps.WpsPackage#getBPEContainer_HoldQueue()
	 * @model dataType="org.eclipse.emf.ecore.xml.type.AnySimpleType"
	 *        extendedMetaData="kind='attribute' name='HoldQueue'"
	 * @generated
	 */
	Object getHoldQueue();

	/**
	 * Sets the value of the '{@link com.ibm.ccl.soa.deploy.wps.BPEContainer#getHoldQueue <em>Hold Queue</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Hold Queue</em>' attribute.
	 * @see #getHoldQueue()
	 * @generated
	 */
	void setHoldQueue(Object value);

	/**
	 * Returns the value of the '<em><b>Implementation Class Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Implementation Class Name</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Implementation Class Name</em>' attribute.
	 * @see #setImplementationClassName(Object)
	 * @see com.ibm.ccl.soa.deploy.wps.WpsPackage#getBPEContainer_ImplementationClassName()
	 * @model dataType="org.eclipse.emf.ecore.xml.type.AnySimpleType"
	 *        extendedMetaData="kind='attribute' name='ImplementationClassName'"
	 * @generated
	 */
	Object getImplementationClassName();

	/**
	 * Sets the value of the '{@link com.ibm.ccl.soa.deploy.wps.BPEContainer#getImplementationClassName <em>Implementation Class Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Implementation Class Name</em>' attribute.
	 * @see #getImplementationClassName()
	 * @generated
	 */
	void setImplementationClassName(Object value);

	/**
	 * Returns the value of the '<em><b>Install Business Process Choreographer Explorer</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Install Business Process Choreographer Explorer</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Install Business Process Choreographer Explorer</em>' attribute.
	 * @see #setInstallBusinessProcessChoreographerExplorer(Object)
	 * @see com.ibm.ccl.soa.deploy.wps.WpsPackage#getBPEContainer_InstallBusinessProcessChoreographerExplorer()
	 * @model dataType="org.eclipse.emf.ecore.xml.type.AnySimpleType"
	 *        extendedMetaData="kind='attribute' name='InstallBusinessProcessChoreographerExplorer'"
	 * @generated
	 */
	Object getInstallBusinessProcessChoreographerExplorer();

	/**
	 * Sets the value of the '{@link com.ibm.ccl.soa.deploy.wps.BPEContainer#getInstallBusinessProcessChoreographerExplorer <em>Install Business Process Choreographer Explorer</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Install Business Process Choreographer Explorer</em>' attribute.
	 * @see #getInstallBusinessProcessChoreographerExplorer()
	 * @generated
	 */
	void setInstallBusinessProcessChoreographerExplorer(Object value);

	/**
	 * Returns the value of the '<em><b>Internal Queue</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Internal Queue</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Internal Queue</em>' attribute.
	 * @see #setInternalQueue(Object)
	 * @see com.ibm.ccl.soa.deploy.wps.WpsPackage#getBPEContainer_InternalQueue()
	 * @model dataType="org.eclipse.emf.ecore.xml.type.AnySimpleType"
	 *        extendedMetaData="kind='attribute' name='InternalQueue'"
	 * @generated
	 */
	Object getInternalQueue();

	/**
	 * Sets the value of the '{@link com.ibm.ccl.soa.deploy.wps.BPEContainer#getInternalQueue <em>Internal Queue</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Internal Queue</em>' attribute.
	 * @see #getInternalQueue()
	 * @generated
	 */
	void setInternalQueue(Object value);

	/**
	 * Returns the value of the '<em><b>JDBC Provider</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>JDBC Provider</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>JDBC Provider</em>' attribute.
	 * @see #setJDBCProvider(Object)
	 * @see com.ibm.ccl.soa.deploy.wps.WpsPackage#getBPEContainer_JDBCProvider()
	 * @model dataType="org.eclipse.emf.ecore.xml.type.AnySimpleType"
	 *        extendedMetaData="kind='attribute' name='JDBCProvider'"
	 * @generated
	 */
	Object getJDBCProvider();

	/**
	 * Sets the value of the '{@link com.ibm.ccl.soa.deploy.wps.BPEContainer#getJDBCProvider <em>JDBC Provider</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>JDBC Provider</em>' attribute.
	 * @see #getJDBCProvider()
	 * @generated
	 */
	void setJDBCProvider(Object value);

	/**
	 * Returns the value of the '<em><b>JMSAPI Password</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>JMSAPI Password</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>JMSAPI Password</em>' attribute.
	 * @see #setJMSAPIPassword(Object)
	 * @see com.ibm.ccl.soa.deploy.wps.WpsPackage#getBPEContainer_JMSAPIPassword()
	 * @model dataType="org.eclipse.emf.ecore.xml.type.AnySimpleType"
	 *        extendedMetaData="kind='attribute' name='JMSAPIPassword'"
	 * @generated
	 */
	Object getJMSAPIPassword();

	/**
	 * Sets the value of the '{@link com.ibm.ccl.soa.deploy.wps.BPEContainer#getJMSAPIPassword <em>JMSAPI Password</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>JMSAPI Password</em>' attribute.
	 * @see #getJMSAPIPassword()
	 * @generated
	 */
	void setJMSAPIPassword(Object value);

	/**
	 * Returns the value of the '<em><b>JMSAPI User ID</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>JMSAPI User ID</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>JMSAPI User ID</em>' attribute.
	 * @see #setJMSAPIUserID(Object)
	 * @see com.ibm.ccl.soa.deploy.wps.WpsPackage#getBPEContainer_JMSAPIUserID()
	 * @model dataType="org.eclipse.emf.ecore.xml.type.AnySimpleType"
	 *        extendedMetaData="kind='attribute' name='JMSAPIUserID'"
	 * @generated
	 */
	Object getJMSAPIUserID();

	/**
	 * Sets the value of the '{@link com.ibm.ccl.soa.deploy.wps.BPEContainer#getJMSAPIUserID <em>JMSAPI User ID</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>JMSAPI User ID</em>' attribute.
	 * @see #getJMSAPIUserID()
	 * @generated
	 */
	void setJMSAPIUserID(Object value);

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
	 * @see com.ibm.ccl.soa.deploy.wps.WpsPackage#getBPEContainer_JMSConnectionFactory()
	 * @model dataType="org.eclipse.emf.ecore.xml.type.AnySimpleType"
	 *        extendedMetaData="kind='attribute' name='JMSConnectionFactory'"
	 * @generated
	 */
	Object getJMSConnectionFactory();

	/**
	 * Sets the value of the '{@link com.ibm.ccl.soa.deploy.wps.BPEContainer#getJMSConnectionFactory <em>JMS Connection Factory</em>}' attribute.
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
	 * @see com.ibm.ccl.soa.deploy.wps.WpsPackage#getBPEContainer_JMSPassword()
	 * @model dataType="org.eclipse.emf.ecore.xml.type.AnySimpleType"
	 *        extendedMetaData="kind='attribute' name='JMSPassword'"
	 * @generated
	 */
	Object getJMSPassword();

	/**
	 * Sets the value of the '{@link com.ibm.ccl.soa.deploy.wps.BPEContainer#getJMSPassword <em>JMS Password</em>}' attribute.
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
	 * @see com.ibm.ccl.soa.deploy.wps.WpsPackage#getBPEContainer_JMSProvider()
	 * @model dataType="org.eclipse.emf.ecore.xml.type.AnySimpleType"
	 *        extendedMetaData="kind='attribute' name='JMSProvider'"
	 * @generated
	 */
	Object getJMSProvider();

	/**
	 * Sets the value of the '{@link com.ibm.ccl.soa.deploy.wps.BPEContainer#getJMSProvider <em>JMS Provider</em>}' attribute.
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
	 * @see com.ibm.ccl.soa.deploy.wps.WpsPackage#getBPEContainer_JMSResources()
	 * @model dataType="org.eclipse.emf.ecore.xml.type.AnySimpleType"
	 *        extendedMetaData="kind='attribute' name='JMSResources'"
	 * @generated
	 */
	Object getJMSResources();

	/**
	 * Sets the value of the '{@link com.ibm.ccl.soa.deploy.wps.BPEContainer#getJMSResources <em>JMS Resources</em>}' attribute.
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
	 * @see com.ibm.ccl.soa.deploy.wps.WpsPackage#getBPEContainer_JMSUserID()
	 * @model dataType="org.eclipse.emf.ecore.xml.type.AnySimpleType"
	 *        extendedMetaData="kind='attribute' name='JMSUserID'"
	 * @generated
	 */
	Object getJMSUserID();

	/**
	 * Sets the value of the '{@link com.ibm.ccl.soa.deploy.wps.BPEContainer#getJMSUserID <em>JMS User ID</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>JMS User ID</em>' attribute.
	 * @see #getJMSUserID()
	 * @generated
	 */
	void setJMSUserID(Object value);

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
	 * @see com.ibm.ccl.soa.deploy.wps.WpsPackage#getBPEContainer_QueueManager()
	 * @model dataType="org.eclipse.emf.ecore.xml.type.AnySimpleType"
	 *        extendedMetaData="kind='attribute' name='QueueManager'"
	 * @generated
	 */
	Object getQueueManager();

	/**
	 * Sets the value of the '{@link com.ibm.ccl.soa.deploy.wps.BPEContainer#getQueueManager <em>Queue Manager</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Queue Manager</em>' attribute.
	 * @see #getQueueManager()
	 * @generated
	 */
	void setQueueManager(Object value);

	/**
	 * Returns the value of the '<em><b>Retention Queue</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Retention Queue</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Retention Queue</em>' attribute.
	 * @see #setRetentionQueue(Object)
	 * @see com.ibm.ccl.soa.deploy.wps.WpsPackage#getBPEContainer_RetentionQueue()
	 * @model dataType="org.eclipse.emf.ecore.xml.type.AnySimpleType"
	 *        extendedMetaData="kind='attribute' name='RetentionQueue'"
	 * @generated
	 */
	Object getRetentionQueue();

	/**
	 * Sets the value of the '{@link com.ibm.ccl.soa.deploy.wps.BPEContainer#getRetentionQueue <em>Retention Queue</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Retention Queue</em>' attribute.
	 * @see #getRetentionQueue()
	 * @generated
	 */
	void setRetentionQueue(Object value);

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
	 * @see com.ibm.ccl.soa.deploy.wps.WpsPackage#getBPEContainer_SystemMonitorSecurityRoleMapping()
	 * @model dataType="org.eclipse.emf.ecore.xml.type.AnySimpleType"
	 *        extendedMetaData="kind='attribute' name='SystemMonitorSecurityRoleMapping'"
	 * @generated
	 */
	Object getSystemMonitorSecurityRoleMapping();

	/**
	 * Sets the value of the '{@link com.ibm.ccl.soa.deploy.wps.BPEContainer#getSystemMonitorSecurityRoleMapping <em>System Monitor Security Role Mapping</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>System Monitor Security Role Mapping</em>' attribute.
	 * @see #getSystemMonitorSecurityRoleMapping()
	 * @generated
	 */
	void setSystemMonitorSecurityRoleMapping(Object value);

} // BPEContainer
