/*******************************************************************************
 * Copyright (c) 2003, 2007 IBM Corporation Licensed Material - Property of IBM. All rights reserved.
 *  
 * US Government Users Restricted Rights - Use, duplication or disclosure v1.0 restricted by GSA ADP
 * Schedule Contract with IBM Corp.
 * 
 * Contributors: IBM Corporation - initial API and implementation
 *******************************************************************************/
package com.ibm.ccl.soa.deploy.core;

/**
 * <!-- begin-user-doc --> A representation of the model object '<em><b>Service</b></em>'. <!--
 * end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * 
 * 				A Service declares an interface that is supported by the
 * 				implementation that backs the {@link
 * 				ApplicationComponent}.
 * 			
 * <!-- end-model-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link com.ibm.ccl.soa.deploy.core.Service#getProtocol <em>Protocol</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.core.Service#getVersion <em>Version</em>}</li>
 * </ul>
 * </p>
 *
 * @see com.ibm.ccl.soa.deploy.core.CorePackage#getService()
 * @model features="interfaceGroup interface" 
 *        interfaceGroupDataType="org.eclipse.emf.ecore.EFeatureMapEntry" interfaceGroupRequired="true" interfaceGroupMany="false" interfaceGroupSuppressedGetVisibility="true" interfaceGroupSuppressedSetVisibility="true"
 *        interfaceGroupExtendedMetaData="kind='group' name='interface:group' namespace='##targetNamespace'"
 *        interfaceType="com.ibm.ccl.soa.deploy.core.Interface" interfaceContainment="true" interfaceRequired="true" interfaceTransient="true" interfaceVolatile="true" interfaceDerived="true" interfaceSuppressedGetVisibility="true" interfaceSuppressedSetVisibility="true"
 *        interfaceExtendedMetaData="kind='element' name='interface' namespace='##targetNamespace' group='interface:group'"
 *        extendedMetaData="name='Service' kind='elementOnly'"
 * @generated
 */
public interface Service extends Capability {
	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	String copyright = "Copyright (c) 2005, 2006 IBM Corporation. Licensed Material - Property of IBM. All rights reserved."; //$NON-NLS-1$

	/**
	 * Returns the value of the '<em><b>Interface</b></em>' containment reference. <!--
	 * begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Interface</em>' containment reference isn't clear, there really
	 * should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * 
	 * @return the value of the '<em>Interface</em>' containment reference.
	 * @see #setInterface(Interface)
	 * @see com.ibm.ccl.soa.deploy.core.CorePackage#getService_Interface()
	 * @model containment="true" required="true" transient="true" volatile="true" derived="true"
	 *        extendedMetaData="kind='element' name='interface' namespace='##targetNamespace'
	 *        group='interface:group'"
	 * 
	 */
	Interface getInterface();

	/**
	 * Sets the value of the '{@link com.ibm.ccl.soa.deploy.core.Service#getInterface <em>Interface</em>}'
	 * containment reference. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @param value
	 *           the new value of the '<em>Interface</em>' containment reference.
	 * @see #getInterface()
	 * 
	 */
	void setInterface(Interface value);

	/**
	 * Returns the value of the '<em><b>Protocol</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Protocol</em>' attribute isn't clear, there really should be
	 * more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Protocol</em>' attribute.
	 * @see #setProtocol(String)
	 * @see com.ibm.ccl.soa.deploy.core.CorePackage#getService_Protocol()
	 * @model dataType="org.eclipse.emf.ecore.xml.type.String"
	 *        extendedMetaData="kind='attribute' name='protocol'"
	 * @generated
	 */
	String getProtocol();

	/**
	 * Sets the value of the '{@link com.ibm.ccl.soa.deploy.core.Service#getProtocol <em>Protocol</em>}' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @param value the new value of the '<em>Protocol</em>' attribute.
	 * @see #getProtocol()
	 * @generated
	 */
	void setProtocol(String value);

	/**
	 * Returns the value of the '<em><b>Version</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Version</em>' attribute isn't clear, there really should be
	 * more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Version</em>' attribute.
	 * @see #setVersion(String)
	 * @see com.ibm.ccl.soa.deploy.core.CorePackage#getService_Version()
	 * @model dataType="com.ibm.ccl.soa.deploy.core.ServiceVersion"
	 *        extendedMetaData="kind='attribute' name='version'"
	 * @generated
	 */
	String getVersion();

	/**
	 * Sets the value of the '{@link com.ibm.ccl.soa.deploy.core.Service#getVersion <em>Version</em>}' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @param value the new value of the '<em>Version</em>' attribute.
	 * @see #getVersion()
	 * @generated
	 */
	void setVersion(String value);

} // Service
