/*******************************************************************************
 * Copyright (c) 2003, 2007 IBM Corporation Licensed Material - Property of IBM. All rights reserved.
 *  
 * US Government Users Restricted Rights - Use, duplication or disclosure v1.0 restricted by GSA ADP
 * Schedule Contract with IBM Corp.
 * 
 * Contributors: IBM Corporation - initial API and implementation
 *******************************************************************************/
package com.ibm.ccl.soa.deploy.location;

import java.util.List;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc --> A representation of the model object '<em><b>Binding</b></em>'. <!--
 * end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * 
 * 			   A container for location binding definitions that are defined outside
 * 			   of a topology.
 * 			   Context can be 'absolute' or 'relative'. If the context is set as 'absolute' then the resolution of the
 * 			  location will return the result as is. If the context is set as 'relative' then the resolution of the location 
 * 			  will prepend the namespace root.
 * 			
 * <!-- end-model-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link com.ibm.ccl.soa.deploy.location.LocationBinding#getBindingEntry <em>Binding Entry</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.location.LocationBinding#getContext <em>Context</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.location.LocationBinding#getName <em>Name</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.location.LocationBinding#getTopology <em>Topology</em>}</li>
 * </ul>
 * </p>
 *
 * @see com.ibm.ccl.soa.deploy.location.LocationPackage#getLocationBinding()
 * @model extendedMetaData="name='LocationBinding' kind='elementOnly'"
 * @generated
 */
public interface LocationBinding extends EObject {
	/**
	 * Returns the value of the '<em><b>Binding Entry</b></em>' containment reference list. The
	 * list contents are of type {@link com.ibm.ccl.soa.deploy.location.BindingEntry}. <!--
	 * begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Binding Entry</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * 
	 * @return the value of the '<em>Binding Entry</em>' containment reference list.
	 * @see com.ibm.ccl.soa.deploy.location.LocationPackage#getLocationBinding_BindingEntry()
	 * @model type="com.ibm.ccl.soa.deploy.location.BindingEntry" containment="true"
	 *        extendedMetaData="kind='element' name='bindingEntry' namespace='##targetNamespace'"
	 * @generated
	 */
	List getBindingEntry();

	/**
	 * Returns the value of the '<em><b>Context</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Context</em>' attribute isn't clear, there really should be
	 * more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Context</em>' attribute.
	 * @see #setContext(String)
	 * @see com.ibm.ccl.soa.deploy.location.LocationPackage#getLocationBinding_Context()
	 * @model dataType="org.eclipse.emf.ecore.xml.type.String"
	 *        extendedMetaData="kind='attribute' name='context'"
	 * @generated
	 */
	String getContext();

	/**
	 * Sets the value of the '{@link com.ibm.ccl.soa.deploy.location.LocationBinding#getContext <em>Context</em>}' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @param value the new value of the '<em>Context</em>' attribute.
	 * @see #getContext()
	 * @generated
	 */
	void setContext(String value);

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
	 * @see com.ibm.ccl.soa.deploy.location.LocationPackage#getLocationBinding_Name()
	 * @model dataType="org.eclipse.emf.ecore.xml.type.String" required="true"
	 *        extendedMetaData="kind='attribute' name='name'"
	 * @generated
	 */
	String getName();

	/**
	 * Sets the value of the '{@link com.ibm.ccl.soa.deploy.location.LocationBinding#getName <em>Name</em>}' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @param value the new value of the '<em>Name</em>' attribute.
	 * @see #getName()
	 * @generated
	 */
	void setName(String value);

	/**
	 * Returns the value of the '<em><b>Topology</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Topology</em>' attribute isn't clear, there really should be
	 * more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Topology</em>' attribute.
	 * @see #setTopology(String)
	 * @see com.ibm.ccl.soa.deploy.location.LocationPackage#getLocationBinding_Topology()
	 * @model dataType="org.eclipse.emf.ecore.xml.type.String" required="true"
	 *        extendedMetaData="kind='attribute' name='topology'"
	 * @generated
	 */
	String getTopology();

	/**
	 * Sets the value of the '{@link com.ibm.ccl.soa.deploy.location.LocationBinding#getTopology <em>Topology</em>}' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @param value the new value of the '<em>Topology</em>' attribute.
	 * @see #getTopology()
	 * @generated
	 */
	void setTopology(String value);

} // LocationBinding
