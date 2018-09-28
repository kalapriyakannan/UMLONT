/*******************************************************************************
 * Copyright (c) 2003, 2007 IBM Corporation Licensed Material - Property of IBM. All rights reserved.
 *  
 * US Government Users Restricted Rights - Use, duplication or disclosure v1.0 restricted by GSA ADP
 * Schedule Contract with IBM Corp.
 * 
 * Contributors: IBM Corporation - initial API and implementation
 *******************************************************************************/
package com.ibm.ccl.soa.deploy.location;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc --> A representation of the model object '<em><b>Binding Entry</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * 
 * 				The specification of the location for a specific deployModelObject.
 * 			
 * <!-- end-model-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link com.ibm.ccl.soa.deploy.location.BindingEntry#getDmoPath <em>Dmo Path</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.location.BindingEntry#getLocation <em>Location</em>}</li>
 * </ul>
 * </p>
 *
 * @see com.ibm.ccl.soa.deploy.location.LocationPackage#getBindingEntry()
 * @model extendedMetaData="name='BindingEntry' kind='empty'"
 * @generated
 */
public interface BindingEntry extends EObject {
	/**
	 * Returns the value of the '<em><b>Dmo Path</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Dmo Path</em>' attribute isn't clear, there really should be
	 * more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Dmo Path</em>' attribute.
	 * @see #setDmoPath(String)
	 * @see com.ibm.ccl.soa.deploy.location.LocationPackage#getBindingEntry_DmoPath()
	 * @model dataType="org.eclipse.emf.ecore.xml.type.String" required="true"
	 *        extendedMetaData="kind='attribute' name='dmoPath'"
	 * @generated
	 */
	String getDmoPath();

	/**
	 * Sets the value of the '{@link com.ibm.ccl.soa.deploy.location.BindingEntry#getDmoPath <em>Dmo Path</em>}' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @param value the new value of the '<em>Dmo Path</em>' attribute.
	 * @see #getDmoPath()
	 * @generated
	 */
	void setDmoPath(String value);

	/**
	 * Returns the value of the '<em><b>Location</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Location</em>' attribute isn't clear, there really should be
	 * more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Location</em>' attribute.
	 * @see #setLocation(String)
	 * @see com.ibm.ccl.soa.deploy.location.LocationPackage#getBindingEntry_Location()
	 * @model dataType="org.eclipse.emf.ecore.xml.type.String" required="true"
	 *        extendedMetaData="kind='attribute' name='location'"
	 * @generated
	 */
	String getLocation();

	/**
	 * Sets the value of the '{@link com.ibm.ccl.soa.deploy.location.BindingEntry#getLocation <em>Location</em>}' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @param value the new value of the '<em>Location</em>' attribute.
	 * @see #getLocation()
	 * @generated
	 */
	void setLocation(String value);

} // BindingEntry
