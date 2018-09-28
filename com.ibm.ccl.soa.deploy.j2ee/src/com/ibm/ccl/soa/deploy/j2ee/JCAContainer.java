/*******************************************************************************
 * Copyright (c) 2003, 2007 IBM Corporation Licensed Material - Property of IBM. All rights reserved.
 *  
 * US Government Users Restricted Rights - Use, duplication or disclosure v1.0 restricted by GSA ADP
 * Schedule Contract with IBM Corp.
 * 
 * Contributors: IBM Corporation - initial API and implementation
 *******************************************************************************/
package com.ibm.ccl.soa.deploy.j2ee;

import com.ibm.ccl.soa.deploy.core.Capability;

/**
 * <!-- begin-user-doc --> A representation of the model object '<em><b>JCA Container</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link com.ibm.ccl.soa.deploy.j2ee.JCAContainer#getContainerVersion <em>Container Version</em>}</li>
 * </ul>
 * </p>
 *
 * @see com.ibm.ccl.soa.deploy.j2ee.J2eePackage#getJCAContainer()
 * @model extendedMetaData="name='JCAContainer' kind='elementOnly'"
 * @generated
 */
public interface JCAContainer extends Capability {
	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	String copyright = "Copyright (c) 2005, 2006 IBM Corporation. Licensed Material - Property of IBM. All rights reserved."; //$NON-NLS-1$

	/**
	 * Returns the value of the '<em><b>Container Version</b></em>' attribute.
	 * The default value is <code>"1.0"</code>.
	 * The literals are from the enumeration {@link com.ibm.ccl.soa.deploy.j2ee.JCAContainerVersion}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Container Version</em>' attribute isn't clear, there really
	 * should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Container Version</em>' attribute.
	 * @see com.ibm.ccl.soa.deploy.j2ee.JCAContainerVersion
	 * @see #isSetContainerVersion()
	 * @see #unsetContainerVersion()
	 * @see #setContainerVersion(JCAContainerVersion)
	 * @see com.ibm.ccl.soa.deploy.j2ee.J2eePackage#getJCAContainer_ContainerVersion()
	 * @model default="1.0" unsettable="true" required="true"
	 *        extendedMetaData="kind='attribute' name='containerVersion'"
	 * @generated
	 */
	JCAContainerVersion getContainerVersion();

	/**
	 * Sets the value of the '{@link com.ibm.ccl.soa.deploy.j2ee.JCAContainer#getContainerVersion <em>Container Version</em>}' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @param value the new value of the '<em>Container Version</em>' attribute.
	 * @see com.ibm.ccl.soa.deploy.j2ee.JCAContainerVersion
	 * @see #isSetContainerVersion()
	 * @see #unsetContainerVersion()
	 * @see #getContainerVersion()
	 * @generated
	 */
	void setContainerVersion(JCAContainerVersion value);

	/**
	 * Unsets the value of the '{@link com.ibm.ccl.soa.deploy.j2ee.JCAContainer#getContainerVersion <em>Container Version</em>}' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see #isSetContainerVersion()
	 * @see #getContainerVersion()
	 * @see #setContainerVersion(JCAContainerVersion)
	 * @generated
	 */
	void unsetContainerVersion();

	/**
	 * Returns whether the value of the '{@link com.ibm.ccl.soa.deploy.j2ee.JCAContainer#getContainerVersion <em>Container Version</em>}' attribute is set.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return whether the value of the '<em>Container Version</em>' attribute is set.
	 * @see #unsetContainerVersion()
	 * @see #getContainerVersion()
	 * @see #setContainerVersion(JCAContainerVersion)
	 * @generated
	 */
	boolean isSetContainerVersion();

} // JCAContainer
