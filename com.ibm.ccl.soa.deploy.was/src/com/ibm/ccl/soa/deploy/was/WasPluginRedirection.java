/*******************************************************************************
 * Copyright (c) 2003, 2007 IBM Corporation Licensed Material - Property of IBM. All rights reserved.
 *  
 * US Government Users Restricted Rights - Use, duplication or disclosure v1.0 restricted by GSA ADP
 * Schedule Contract with IBM Corp.
 * 
 * Contributors: IBM Corporation - initial API and implementation
 *******************************************************************************/
package com.ibm.ccl.soa.deploy.was;

import com.ibm.ccl.soa.deploy.core.Capability;

/**
 * <!-- begin-user-doc --> A representation of the model object '<em><b>Plugin Redirection</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * 
 * 			
 * <!-- end-model-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link com.ibm.ccl.soa.deploy.was.WasPluginRedirection#getWasPluginVersion <em>Was Plugin Version</em>}</li>
 * </ul>
 * </p>
 *
 * @see com.ibm.ccl.soa.deploy.was.WasPackage#getWasPluginRedirection()
 * @model extendedMetaData="name='WasPluginRedirection' kind='elementOnly'"
 * @generated
 */
public interface WasPluginRedirection extends Capability {
	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	String copyright = "Copyright (c) 2005, 2006 IBM Corporation. Licensed Material - Property of IBM. All rights reserved."; //$NON-NLS-1$

	/**
	 * Returns the value of the '<em><b>Was Plugin Version</b></em>' attribute. <!--
	 * begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Was Plugin Version</em>' attribute isn't clear, there really
	 * should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * 
	 * @return the value of the '<em>Was Plugin Version</em>' attribute.
	 * @see #setWasPluginVersion(String)
	 * @see com.ibm.ccl.soa.deploy.was.WasPackage#getWasPluginRedirection_WasPluginVersion()
	 * @model unique="false" dataType="com.ibm.ccl.soa.deploy.core.VersionString"
	 *        extendedMetaData="kind='attribute' name='wasPluginVersion'"
	 * @generated
	 */
	String getWasPluginVersion();

	/**
	 * Sets the value of the '{@link com.ibm.ccl.soa.deploy.was.WasPluginRedirection#getWasPluginVersion <em>Was Plugin Version</em>}' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @param value the new value of the '<em>Was Plugin Version</em>' attribute.
	 * @see #getWasPluginVersion()
	 * @generated
	 */
	void setWasPluginVersion(String value);

} // WasPluginRedirection
