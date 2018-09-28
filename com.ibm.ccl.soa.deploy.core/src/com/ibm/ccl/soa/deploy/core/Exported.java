/*******************************************************************************
 * Copyright (c) 2003, 2007 IBM Corporation Licensed Material - Property of IBM. All rights reserved.
 *  
 * US Government Users Restricted Rights - Use, duplication or disclosure v1.0 restricted by GSA ADP
 * Schedule Contract with IBM Corp.
 * 
 * Contributors: IBM Corporation - initial API and implementation
 *******************************************************************************/
package com.ibm.ccl.soa.deploy.core;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc --> A representation of the model object '<em><b>Exported</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link com.ibm.ccl.soa.deploy.core.Exported#isConfigurable <em>Configurable</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.core.Exported#isLinkable <em>Linkable</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.core.Exported#getName <em>Name</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.core.Exported#getPath <em>Path</em>}</li>
 * </ul>
 * </p>
 *
 * @see com.ibm.ccl.soa.deploy.core.CorePackage#getExported()
 * @model extendedMetaData="name='Exported' kind='empty'"
 * @generated
 */
public interface Exported extends EObject {
	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	String copyright = "Copyright (c) 2005, 2006 IBM Corporation. Licensed Material - Property of IBM. All rights reserved."; //$NON-NLS-1$

	/**
	 * Returns the value of the '<em><b>Configurable</b></em>' attribute.
	 * <!-- begin-user-doc
	 * -->
	 * <p>
	 * If the meaning of the '<em>Configurable</em>' attribute isn't clear, there really should
	 * be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Configurable</em>' attribute.
	 * @see #isSetConfigurable()
	 * @see #unsetConfigurable()
	 * @see #setConfigurable(boolean)
	 * @see com.ibm.ccl.soa.deploy.core.CorePackage#getExported_Configurable()
	 * @model unsettable="true" dataType="org.eclipse.emf.ecore.xml.type.Boolean"
	 *        extendedMetaData="kind='attribute' name='configurable'"
	 * @generated
	 */
	boolean isConfigurable();

	/**
	 * Sets the value of the '{@link com.ibm.ccl.soa.deploy.core.Exported#isConfigurable <em>Configurable</em>}' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @param value the new value of the '<em>Configurable</em>' attribute.
	 * @see #isSetConfigurable()
	 * @see #unsetConfigurable()
	 * @see #isConfigurable()
	 * @generated
	 */
	void setConfigurable(boolean value);

	/**
	 * Unsets the value of the '{@link com.ibm.ccl.soa.deploy.core.Exported#isConfigurable <em>Configurable</em>}' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see #isSetConfigurable()
	 * @see #isConfigurable()
	 * @see #setConfigurable(boolean)
	 * @generated
	 */
	void unsetConfigurable();

	/**
	 * Returns whether the value of the '{@link com.ibm.ccl.soa.deploy.core.Exported#isConfigurable <em>Configurable</em>}' attribute is set.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return whether the value of the '<em>Configurable</em>' attribute is set.
	 * @see #unsetConfigurable()
	 * @see #isConfigurable()
	 * @see #setConfigurable(boolean)
	 * @generated
	 */
	boolean isSetConfigurable();

	/**
	 * Returns the value of the '<em><b>Linkable</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Linkable</em>' attribute isn't clear, there really should be
	 * more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Linkable</em>' attribute.
	 * @see #isSetLinkable()
	 * @see #unsetLinkable()
	 * @see #setLinkable(boolean)
	 * @see com.ibm.ccl.soa.deploy.core.CorePackage#getExported_Linkable()
	 * @model unsettable="true" dataType="org.eclipse.emf.ecore.xml.type.Boolean"
	 *        extendedMetaData="kind='attribute' name='linkable'"
	 * @generated
	 */
	boolean isLinkable();

	/**
	 * Sets the value of the '{@link com.ibm.ccl.soa.deploy.core.Exported#isLinkable <em>Linkable</em>}' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @param value the new value of the '<em>Linkable</em>' attribute.
	 * @see #isSetLinkable()
	 * @see #unsetLinkable()
	 * @see #isLinkable()
	 * @generated
	 */
	void setLinkable(boolean value);

	/**
	 * Unsets the value of the '{@link com.ibm.ccl.soa.deploy.core.Exported#isLinkable <em>Linkable</em>}' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see #isSetLinkable()
	 * @see #isLinkable()
	 * @see #setLinkable(boolean)
	 * @generated
	 */
	void unsetLinkable();

	/**
	 * Returns whether the value of the '{@link com.ibm.ccl.soa.deploy.core.Exported#isLinkable <em>Linkable</em>}' attribute is set.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return whether the value of the '<em>Linkable</em>' attribute is set.
	 * @see #unsetLinkable()
	 * @see #isLinkable()
	 * @see #setLinkable(boolean)
	 * @generated
	 */
	boolean isSetLinkable();

	/**
	 * Returns the value of the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Name</em>' attribute isn't clear, there really should be more
	 * of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Name</em>' attribute.
	 * @see #setName(String)
	 * @see com.ibm.ccl.soa.deploy.core.CorePackage#getExported_Name()
	 * @model dataType="org.eclipse.emf.ecore.xml.type.String"
	 *        extendedMetaData="kind='attribute' name='name'"
	 * @generated
	 */
	String getName();

	/**
	 * Sets the value of the '{@link com.ibm.ccl.soa.deploy.core.Exported#getName <em>Name</em>}' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @param value the new value of the '<em>Name</em>' attribute.
	 * @see #getName()
	 * @generated
	 */
	void setName(String value);

	/**
	 * Returns the value of the '<em><b>Path</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Path</em>' attribute isn't clear, there really should be more
	 * of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Path</em>' attribute.
	 * @see #setPath(String)
	 * @see com.ibm.ccl.soa.deploy.core.CorePackage#getExported_Path()
	 * @model dataType="org.eclipse.emf.ecore.xml.type.String"
	 *        extendedMetaData="kind='attribute' name='path'"
	 * @generated
	 */
	String getPath();

	/**
	 * Sets the value of the '{@link com.ibm.ccl.soa.deploy.core.Exported#getPath <em>Path</em>}' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @param value the new value of the '<em>Path</em>' attribute.
	 * @see #getPath()
	 * @generated
	 */
	void setPath(String value);

} // Exported
