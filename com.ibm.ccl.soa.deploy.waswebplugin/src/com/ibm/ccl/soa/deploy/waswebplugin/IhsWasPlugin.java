/*******************************************************************************
 * Copyright (c) 2003, 2007 IBM Corporation Licensed Material - Property of IBM. All rights reserved.
 *  
 * US Government Users Restricted Rights - Use, duplication or disclosure v1.0 restricted by GSA ADP
 * Schedule Contract with IBM Corp.
 * 
 * Contributors: IBM Corporation - initial API and implementation
 *******************************************************************************/
package com.ibm.ccl.soa.deploy.waswebplugin;

import com.ibm.ccl.soa.deploy.core.Capability;

/**
 * <!-- begin-user-doc --> A representation of the model object '<em><b>Ihs Was Plugin</b></em>'.
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
 *   <li>{@link com.ibm.ccl.soa.deploy.waswebplugin.IhsWasPlugin#getInstallLocation <em>Install Location</em>}</li>
 * </ul>
 * </p>
 *
 * @see com.ibm.ccl.soa.deploy.waswebplugin.WaswebpluginPackage#getIhsWasPlugin()
 * @model extendedMetaData="name='IhsWasPlugin' kind='elementOnly'"
 * @generated
 */
public interface IhsWasPlugin extends Capability {
	/**
	 * Returns the value of the '<em><b>Install Location</b></em>' attribute. <!--
	 * begin-user-doc --> <!-- end-user-doc --> <!-- begin-model-doc -->
	 * 
	 * 
	 * <!-- end-model-doc -->
	 * 
	 * @return the value of the '<em>Install Location</em>' attribute.
	 * @see #setInstallLocation(String)
	 * @see com.ibm.ccl.soa.deploy.waswebplugin.WaswebpluginPackage#getIhsWasPlugin_InstallLocation()
	 * @model unique="false" dataType="org.eclipse.emf.ecore.xml.type.String"
	 *        extendedMetaData="kind='attribute' name='installLocation'"
	 * @generated
	 */
	String getInstallLocation();

	/**
	 * Sets the value of the '{@link com.ibm.ccl.soa.deploy.waswebplugin.IhsWasPlugin#getInstallLocation <em>Install Location</em>}' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @param value the new value of the '<em>Install Location</em>' attribute.
	 * @see #getInstallLocation()
	 * @generated
	 */
	void setInstallLocation(String value);

} // IhsWasPlugin
