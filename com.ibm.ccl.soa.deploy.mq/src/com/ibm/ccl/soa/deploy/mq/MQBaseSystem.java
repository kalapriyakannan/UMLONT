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
 * A representation of the model object '<em><b>MQ Base System</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link com.ibm.ccl.soa.deploy.mq.MQBaseSystem#getInitialContextFactory <em>Initial Context Factory</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.mq.MQBaseSystem#getProviderName <em>Provider Name</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.mq.MQBaseSystem#getProviderURL <em>Provider URL</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.mq.MQBaseSystem#getProviderVersion <em>Provider Version</em>}</li>
 * </ul>
 * </p>
 *
 * @see com.ibm.ccl.soa.deploy.mq.MqPackage#getMQBaseSystem()
 * @model extendedMetaData="name='MQBaseSystem' kind='elementOnly'"
 * @generated
 */
public interface MQBaseSystem extends Capability {
	/**
	 * Returns the value of the '<em><b>Initial Context Factory</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Initial Context Factory</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Initial Context Factory</em>' attribute.
	 * @see #setInitialContextFactory(String)
	 * @see com.ibm.ccl.soa.deploy.mq.MqPackage#getMQBaseSystem_InitialContextFactory()
	 * @model dataType="org.eclipse.emf.ecore.xml.type.String"
	 *        extendedMetaData="kind='attribute' name='initialContextFactory'"
	 * @generated
	 */
	String getInitialContextFactory();

	/**
	 * Sets the value of the '{@link com.ibm.ccl.soa.deploy.mq.MQBaseSystem#getInitialContextFactory <em>Initial Context Factory</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Initial Context Factory</em>' attribute.
	 * @see #getInitialContextFactory()
	 * @generated
	 */
	void setInitialContextFactory(String value);

	/**
	 * Returns the value of the '<em><b>Provider Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Provider Name</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Provider Name</em>' attribute.
	 * @see #setProviderName(String)
	 * @see com.ibm.ccl.soa.deploy.mq.MqPackage#getMQBaseSystem_ProviderName()
	 * @model dataType="org.eclipse.emf.ecore.xml.type.String"
	 *        extendedMetaData="kind='attribute' name='providerName'"
	 * @generated
	 */
	String getProviderName();

	/**
	 * Sets the value of the '{@link com.ibm.ccl.soa.deploy.mq.MQBaseSystem#getProviderName <em>Provider Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Provider Name</em>' attribute.
	 * @see #getProviderName()
	 * @generated
	 */
	void setProviderName(String value);

	/**
	 * Returns the value of the '<em><b>Provider URL</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Provider URL</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Provider URL</em>' attribute.
	 * @see #setProviderURL(String)
	 * @see com.ibm.ccl.soa.deploy.mq.MqPackage#getMQBaseSystem_ProviderURL()
	 * @model dataType="org.eclipse.emf.ecore.xml.type.AnyURI"
	 *        extendedMetaData="kind='attribute' name='providerURL'"
	 * @generated
	 */
	String getProviderURL();

	/**
	 * Sets the value of the '{@link com.ibm.ccl.soa.deploy.mq.MQBaseSystem#getProviderURL <em>Provider URL</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Provider URL</em>' attribute.
	 * @see #getProviderURL()
	 * @generated
	 */
	void setProviderURL(String value);

	/**
	 * Returns the value of the '<em><b>Provider Version</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Provider Version</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Provider Version</em>' attribute.
	 * @see #setProviderVersion(String)
	 * @see com.ibm.ccl.soa.deploy.mq.MqPackage#getMQBaseSystem_ProviderVersion()
	 * @model dataType="com.ibm.ccl.soa.deploy.core.VersionString"
	 *        extendedMetaData="kind='attribute' name='providerVersion'"
	 * @generated
	 */
	String getProviderVersion();

	/**
	 * Sets the value of the '{@link com.ibm.ccl.soa.deploy.mq.MQBaseSystem#getProviderVersion <em>Provider Version</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Provider Version</em>' attribute.
	 * @see #getProviderVersion()
	 * @generated
	 */
	void setProviderVersion(String value);

} // MQBaseSystem
