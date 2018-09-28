/*******************************************************************************
 * Copyright (c) 2003, 2007 IBM Corporation Licensed Material - Property of IBM. All rights reserved.
 *  
 * US Government Users Restricted Rights - Use, duplication or disclosure v1.0 restricted by GSA ADP
 * Schedule Contract with IBM Corp.
 * 
 * Contributors: IBM Corporation - initial API and implementation
 *******************************************************************************/
package com.ibm.ccl.soa.deploy.j2ee;

/**
 * <!-- begin-user-doc --> A representation of the model object '<em><b>Web Module Capability</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link com.ibm.ccl.soa.deploy.j2ee.WebModuleCapability#getContextRoot <em>Context Root</em>}</li>
 * </ul>
 * </p>
 *
 * @see com.ibm.ccl.soa.deploy.j2ee.J2eePackage#getWebModuleCapability()
 * @model extendedMetaData="name='WebModuleCapability' kind='elementOnly'"
 * @generated
 */
public interface WebModuleCapability extends J2EEModuleCapability {
	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	String copyright = "Copyright (c) 2005, 2006 IBM Corporation. Licensed Material - Property of IBM. All rights reserved."; //$NON-NLS-1$

	/**
	 * Returns the value of the '<em><b>Context Root</b></em>' attribute.
	 * <!-- begin-user-doc
	 * -->
	 * <p>
	 * If the meaning of the '<em>Context Root</em>' attribute isn't clear, there really should
	 * be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Context Root</em>' attribute.
	 * @see #setContextRoot(String)
	 * @see com.ibm.ccl.soa.deploy.j2ee.J2eePackage#getWebModuleCapability_ContextRoot()
	 * @model dataType="org.eclipse.emf.ecore.xml.type.String" required="true"
	 *        extendedMetaData="kind='attribute' name='contextRoot'"
	 * @generated
	 */
	String getContextRoot();

	/**
	 * Sets the value of the '{@link com.ibm.ccl.soa.deploy.j2ee.WebModuleCapability#getContextRoot <em>Context Root</em>}' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @param value the new value of the '<em>Context Root</em>' attribute.
	 * @see #getContextRoot()
	 * @generated
	 */
	void setContextRoot(String value);

} // WebModuleCapability
