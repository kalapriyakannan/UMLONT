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
 * A representation of the model object '<em><b>MQ Messaging Provider</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link com.ibm.ccl.soa.deploy.mq.MQMessagingProvider#getClassPath <em>Class Path</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.mq.MQMessagingProvider#getDescription1 <em>Description1</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.mq.MQMessagingProvider#getName1 <em>Name1</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.mq.MQMessagingProvider#getNativePath <em>Native Path</em>}</li>
 * </ul>
 * </p>
 *
 * @see com.ibm.ccl.soa.deploy.mq.MqPackage#getMQMessagingProvider()
 * @model extendedMetaData="name='MQMessagingProvider' kind='elementOnly'"
 * @generated
 */
public interface MQMessagingProvider extends Capability {
	/**
	 * Returns the value of the '<em><b>Class Path</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Class Path</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Class Path</em>' attribute.
	 * @see #setClassPath(String)
	 * @see com.ibm.ccl.soa.deploy.mq.MqPackage#getMQMessagingProvider_ClassPath()
	 * @model dataType="org.eclipse.emf.ecore.xml.type.String"
	 *        extendedMetaData="kind='attribute' name='classPath'"
	 * @generated
	 */
	String getClassPath();

	/**
	 * Sets the value of the '{@link com.ibm.ccl.soa.deploy.mq.MQMessagingProvider#getClassPath <em>Class Path</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Class Path</em>' attribute.
	 * @see #getClassPath()
	 * @generated
	 */
	void setClassPath(String value);

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
	 * @see com.ibm.ccl.soa.deploy.mq.MqPackage#getMQMessagingProvider_Description1()
	 * @model dataType="org.eclipse.emf.ecore.xml.type.String"
	 *        extendedMetaData="kind='attribute' name='Description'"
	 * @generated
	 */
	String getDescription1();

	/**
	 * Sets the value of the '{@link com.ibm.ccl.soa.deploy.mq.MQMessagingProvider#getDescription1 <em>Description1</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Description1</em>' attribute.
	 * @see #getDescription1()
	 * @generated
	 */
	void setDescription1(String value);

	/**
	 * Returns the value of the '<em><b>Name1</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Name1</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Name1</em>' attribute.
	 * @see #setName1(String)
	 * @see com.ibm.ccl.soa.deploy.mq.MqPackage#getMQMessagingProvider_Name1()
	 * @model dataType="org.eclipse.emf.ecore.xml.type.String"
	 *        extendedMetaData="kind='attribute' name='Name'"
	 * @generated
	 */
	String getName1();

	/**
	 * Sets the value of the '{@link com.ibm.ccl.soa.deploy.mq.MQMessagingProvider#getName1 <em>Name1</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Name1</em>' attribute.
	 * @see #getName1()
	 * @generated
	 */
	void setName1(String value);

	/**
	 * Returns the value of the '<em><b>Native Path</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Native Path</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Native Path</em>' attribute.
	 * @see #setNativePath(String)
	 * @see com.ibm.ccl.soa.deploy.mq.MqPackage#getMQMessagingProvider_NativePath()
	 * @model dataType="org.eclipse.emf.ecore.xml.type.String"
	 *        extendedMetaData="kind='attribute' name='nativePath'"
	 * @generated
	 */
	String getNativePath();

	/**
	 * Sets the value of the '{@link com.ibm.ccl.soa.deploy.mq.MQMessagingProvider#getNativePath <em>Native Path</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Native Path</em>' attribute.
	 * @see #getNativePath()
	 * @generated
	 */
	void setNativePath(String value);

} // MQMessagingProvider
