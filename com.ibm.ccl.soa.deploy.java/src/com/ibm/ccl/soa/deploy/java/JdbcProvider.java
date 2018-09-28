/*******************************************************************************
 * Copyright (c) 2003, 2007 IBM Corporation Licensed Material - Property of IBM. All rights reserved.
 *  
 * US Government Users Restricted Rights - Use, duplication or disclosure v1.0 restricted by GSA ADP
 * Schedule Contract with IBM Corp.
 * 
 * Contributors: IBM Corporation - initial API and implementation
 *******************************************************************************/
package com.ibm.ccl.soa.deploy.java;

import com.ibm.ccl.soa.deploy.core.Capability;

/**
 * <!-- begin-user-doc --> A representation of the model object '<em><b>Jdbc Provider</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link com.ibm.ccl.soa.deploy.java.JdbcProvider#getClasspath <em>Classpath</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.java.JdbcProvider#getImplementationClassName <em>Implementation Class Name</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.java.JdbcProvider#getNativepath <em>Nativepath</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.java.JdbcProvider#getProviderName <em>Provider Name</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.java.JdbcProvider#getProviderType <em>Provider Type</em>}</li>
 * </ul>
 * </p>
 *
 * @see com.ibm.ccl.soa.deploy.java.JavaPackage#getJdbcProvider()
 * @model extendedMetaData="name='JdbcProvider' kind='elementOnly'"
 * @generated
 */
public interface JdbcProvider extends Capability {
	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	String copyright = "Copyright (c) 2005, 2006 IBM Corporation. Licensed Material - Property of IBM. All rights reserved."; //$NON-NLS-1$

	/**
	 * Returns the value of the '<em><b>Classpath</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Classpath</em>' attribute isn't clear, there really should be
	 * more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Classpath</em>' attribute.
	 * @see #setClasspath(String)
	 * @see com.ibm.ccl.soa.deploy.java.JavaPackage#getJdbcProvider_Classpath()
	 * @model dataType="org.eclipse.emf.ecore.xml.type.String"
	 *        extendedMetaData="kind='attribute' name='classpath'"
	 * @generated
	 */
	String getClasspath();

	/**
	 * Sets the value of the '{@link com.ibm.ccl.soa.deploy.java.JdbcProvider#getClasspath <em>Classpath</em>}' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @param value the new value of the '<em>Classpath</em>' attribute.
	 * @see #getClasspath()
	 * @generated
	 */
	void setClasspath(String value);

	/**
	 * Returns the value of the '<em><b>Implementation Class Name</b></em>' attribute. <!--
	 * begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Implementation Class Name</em>' attribute isn't clear, there
	 * really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * 
	 * @return the value of the '<em>Implementation Class Name</em>' attribute.
	 * @see #setImplementationClassName(String)
	 * @see com.ibm.ccl.soa.deploy.java.JavaPackage#getJdbcProvider_ImplementationClassName()
	 * @model unique="false" dataType="org.eclipse.emf.ecore.xml.type.String"
	 *        extendedMetaData="kind='attribute' name='implementationClassName'"
	 * @generated
	 */
	String getImplementationClassName();

	/**
	 * Sets the value of the '{@link com.ibm.ccl.soa.deploy.java.JdbcProvider#getImplementationClassName <em>Implementation Class Name</em>}' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @param value the new value of the '<em>Implementation Class Name</em>' attribute.
	 * @see #getImplementationClassName()
	 * @generated
	 */
	void setImplementationClassName(String value);

	/**
	 * Returns the value of the '<em><b>Nativepath</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Nativepath</em>' attribute isn't clear, there really should be
	 * more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Nativepath</em>' attribute.
	 * @see #setNativepath(String)
	 * @see com.ibm.ccl.soa.deploy.java.JavaPackage#getJdbcProvider_Nativepath()
	 * @model dataType="org.eclipse.emf.ecore.xml.type.String"
	 *        extendedMetaData="kind='attribute' name='nativepath'"
	 * @generated
	 */
	String getNativepath();

	/**
	 * Sets the value of the '{@link com.ibm.ccl.soa.deploy.java.JdbcProvider#getNativepath <em>Nativepath</em>}' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @param value the new value of the '<em>Nativepath</em>' attribute.
	 * @see #getNativepath()
	 * @generated
	 */
	void setNativepath(String value);

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
	 * @see com.ibm.ccl.soa.deploy.java.JavaPackage#getJdbcProvider_ProviderName()
	 * @model dataType="org.eclipse.emf.ecore.xml.type.String" required="true"
	 *        extendedMetaData="kind='attribute' name='providerName'"
	 * @generated
	 */
	String getProviderName();

	/**
	 * Sets the value of the '{@link com.ibm.ccl.soa.deploy.java.JdbcProvider#getProviderName <em>Provider Name</em>}' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @param value the new value of the '<em>Provider Name</em>' attribute.
	 * @see #getProviderName()
	 * @generated
	 */
	void setProviderName(String value);

	/**
	 * Returns the value of the '<em><b>Provider Type</b></em>' attribute.
	 * <!-- begin-user-doc
	 * -->
	 * <p>
	 * If the meaning of the '<em>Provider Type</em>' attribute isn't clear, there really should
	 * be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Provider Type</em>' attribute.
	 * @see #setProviderType(String)
	 * @see com.ibm.ccl.soa.deploy.java.JavaPackage#getJdbcProvider_ProviderType()
	 * @model dataType="org.eclipse.emf.ecore.xml.type.String"
	 *        extendedMetaData="kind='attribute' name='providerType'"
	 * @generated
	 */
	String getProviderType();

	/**
	 * Sets the value of the '{@link com.ibm.ccl.soa.deploy.java.JdbcProvider#getProviderType <em>Provider Type</em>}' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @param value the new value of the '<em>Provider Type</em>' attribute.
	 * @see #getProviderType()
	 * @generated
	 */
	void setProviderType(String value);

} // JdbcProvider
