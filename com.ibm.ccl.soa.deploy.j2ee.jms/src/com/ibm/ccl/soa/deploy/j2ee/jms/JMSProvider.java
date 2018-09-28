/*******************************************************************************
 * Copyright (c) 2003, 2007 IBM Corporation Licensed Material - Property of IBM. All rights reserved.
 *  
 * US Government Users Restricted Rights - Use, duplication or disclosure v1.0 restricted by GSA ADP
 * Schedule Contract with IBM Corp.
 * 
 * Contributors: IBM Corporation - initial API and implementation
 *******************************************************************************/
package com.ibm.ccl.soa.deploy.j2ee.jms;

import java.util.List;

import com.ibm.ccl.soa.deploy.core.Capability;

/**
 * <!-- begin-user-doc --> A representation of the model object '<em><b>JMS Provider</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link com.ibm.ccl.soa.deploy.j2ee.jms.JMSProvider#getClassPath <em>Class Path</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.j2ee.jms.JMSProvider#getNativePath <em>Native Path</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.j2ee.jms.JMSProvider#getInitialContextFactory <em>Initial Context Factory</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.j2ee.jms.JMSProvider#getProviderName <em>Provider Name</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.j2ee.jms.JMSProvider#getProviderURL <em>Provider URL</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.j2ee.jms.JMSProvider#getProviderVersion <em>Provider Version</em>}</li>
 * </ul>
 * </p>
 *
 * @see com.ibm.ccl.soa.deploy.j2ee.jms.JmsPackage#getJMSProvider()
 * @model extendedMetaData="name='JMSProvider' kind='elementOnly'"
 * @generated
 */
public interface JMSProvider extends Capability {
	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	String copyright = "Copyright (c) 2005, 2006 IBM Corporation. Licensed Material - Property of IBM. All rights reserved."; //$NON-NLS-1$

	/**
	 * Returns the value of the '<em><b>Class Path</b></em>' attribute list.
	 * The list contents are of type {@link java.lang.String}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Class Path</em>' attribute isn't clear, there really should be
	 * more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Class Path</em>' attribute list.
	 * @see com.ibm.ccl.soa.deploy.j2ee.jms.JmsPackage#getJMSProvider_ClassPath()
	 * @model unique="false" dataType="org.eclipse.emf.ecore.xml.type.String"
	 *        extendedMetaData="kind='element' name='classPath' namespace='##targetNamespace'"
	 * @generated
	 */
	List getClassPath();

	/**
	 * Returns the value of the '<em><b>Initial Context Factory</b></em>' attribute. <!--
	 * begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Initial Context Factory</em>' attribute isn't clear, there
	 * really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * 
	 * @return the value of the '<em>Initial Context Factory</em>' attribute.
	 * @see #setInitialContextFactory(String)
	 * @see com.ibm.ccl.soa.deploy.j2ee.jms.JmsPackage#getJMSProvider_InitialContextFactory()
	 * @model unique="false" dataType="org.eclipse.emf.ecore.xml.type.String"
	 *        extendedMetaData="kind='attribute' name='initialContextFactory'"
	 * @generated
	 */
	String getInitialContextFactory();

	/**
	 * Sets the value of the '{@link com.ibm.ccl.soa.deploy.j2ee.jms.JMSProvider#getInitialContextFactory <em>Initial Context Factory</em>}' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @param value the new value of the '<em>Initial Context Factory</em>' attribute.
	 * @see #getInitialContextFactory()
	 * @generated
	 */
	void setInitialContextFactory(String value);

	/**
	 * Returns the value of the '<em><b>Native Path</b></em>' attribute list.
	 * The list contents are of type {@link java.lang.String}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Native Path</em>' attribute isn't clear, there really should be
	 * more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Native Path</em>' attribute list.
	 * @see com.ibm.ccl.soa.deploy.j2ee.jms.JmsPackage#getJMSProvider_NativePath()
	 * @model unique="false" dataType="org.eclipse.emf.ecore.xml.type.String"
	 *        extendedMetaData="kind='element' name='nativePath' namespace='##targetNamespace'"
	 * @generated
	 */
	List getNativePath();

	/**
	 * Returns the value of the '<em><b>Provider Name</b></em>' attribute.
	 * <!-- begin-user-doc
	 * -->
	 * <p>
	 * If the meaning of the '<em>Provider Name</em>' attribute isn't clear, there really should
	 * be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Provider Name</em>' attribute.
	 * @see #setProviderName(String)
	 * @see com.ibm.ccl.soa.deploy.j2ee.jms.JmsPackage#getJMSProvider_ProviderName()
	 * @model dataType="org.eclipse.emf.ecore.xml.type.String"
	 *        extendedMetaData="kind='attribute' name='providerName'"
	 * @generated
	 */
	String getProviderName();

	/**
	 * Sets the value of the '{@link com.ibm.ccl.soa.deploy.j2ee.jms.JMSProvider#getProviderName <em>Provider Name</em>}' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @param value the new value of the '<em>Provider Name</em>' attribute.
	 * @see #getProviderName()
	 * @generated
	 */
	void setProviderName(String value);

	/**
	 * Returns the value of the '<em><b>Provider URL</b></em>' attribute.
	 * <!-- begin-user-doc
	 * -->
	 * <p>
	 * If the meaning of the '<em>Provider URL</em>' attribute isn't clear, there really should
	 * be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Provider URL</em>' attribute.
	 * @see #setProviderURL(String)
	 * @see com.ibm.ccl.soa.deploy.j2ee.jms.JmsPackage#getJMSProvider_ProviderURL()
	 * @model dataType="org.eclipse.emf.ecore.xml.type.AnyURI"
	 *        extendedMetaData="kind='attribute' name='providerURL'"
	 * @generated
	 */
	String getProviderURL();

	/**
	 * Sets the value of the '{@link com.ibm.ccl.soa.deploy.j2ee.jms.JMSProvider#getProviderURL <em>Provider URL</em>}' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @param value the new value of the '<em>Provider URL</em>' attribute.
	 * @see #getProviderURL()
	 * @generated
	 */
	void setProviderURL(String value);

	/**
	 * Returns the value of the '<em><b>Provider Version</b></em>' attribute. <!--
	 * begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Provider Version</em>' attribute isn't clear, there really
	 * should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * 
	 * @return the value of the '<em>Provider Version</em>' attribute.
	 * @see #setProviderVersion(String)
	 * @see com.ibm.ccl.soa.deploy.j2ee.jms.JmsPackage#getJMSProvider_ProviderVersion()
	 * @model unique="false" dataType="com.ibm.ccl.soa.deploy.core.VersionString"
	 *        extendedMetaData="kind='attribute' name='providerVersion'"
	 * @generated
	 */
	String getProviderVersion();

	/**
	 * Sets the value of the '{@link com.ibm.ccl.soa.deploy.j2ee.jms.JMSProvider#getProviderVersion <em>Provider Version</em>}' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @param value the new value of the '<em>Provider Version</em>' attribute.
	 * @see #getProviderVersion()
	 * @generated
	 */
	void setProviderVersion(String value);

} // JMSProvider
