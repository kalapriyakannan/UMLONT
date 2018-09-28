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
 * <!-- begin-user-doc --> A representation of the model object '<em><b>Sib Destination</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link com.ibm.ccl.soa.deploy.was.WasSibDestination#getDestinationName <em>Destination Name</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.was.WasSibDestination#getType <em>Type</em>}</li>
 * </ul>
 * </p>
 *
 * @see com.ibm.ccl.soa.deploy.was.WasPackage#getWasSibDestination()
 * @model extendedMetaData="name='WasSibDestination' kind='elementOnly'"
 * @generated
 */
public interface WasSibDestination extends Capability {
	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	String copyright = "Copyright (c) 2005, 2006 IBM Corporation. Licensed Material - Property of IBM. All rights reserved."; //$NON-NLS-1$

	/**
	 * Returns the value of the '<em><b>Destination Name</b></em>' attribute. <!--
	 * begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Destination Name</em>' attribute isn't clear, there really
	 * should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * 
	 * @return the value of the '<em>Destination Name</em>' attribute.
	 * @see #setDestinationName(String)
	 * @see com.ibm.ccl.soa.deploy.was.WasPackage#getWasSibDestination_DestinationName()
	 * @model unique="false" dataType="org.eclipse.emf.ecore.xml.type.String"
	 *        extendedMetaData="kind='attribute' name='destinationName'"
	 * @generated
	 */
	String getDestinationName();

	/**
	 * Sets the value of the '{@link com.ibm.ccl.soa.deploy.was.WasSibDestination#getDestinationName <em>Destination Name</em>}' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @param value the new value of the '<em>Destination Name</em>' attribute.
	 * @see #getDestinationName()
	 * @generated
	 */
	void setDestinationName(String value);

	/**
	 * Returns the value of the '<em><b>Type</b></em>' attribute.
	 * The default value is <code>"WebService"</code>.
	 * The literals are from the enumeration {@link com.ibm.ccl.soa.deploy.was.WasSibDestinationTypeEnum}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Type</em>' attribute isn't clear, there really should be more
	 * of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Type</em>' attribute.
	 * @see com.ibm.ccl.soa.deploy.was.WasSibDestinationTypeEnum
	 * @see #isSetType()
	 * @see #unsetType()
	 * @see #setType(WasSibDestinationTypeEnum)
	 * @see com.ibm.ccl.soa.deploy.was.WasPackage#getWasSibDestination_Type()
	 * @model default="WebService" unsettable="true"
	 *        extendedMetaData="kind='attribute' name='type'"
	 * @generated
	 */
	WasSibDestinationTypeEnum getType();

	/**
	 * Sets the value of the '{@link com.ibm.ccl.soa.deploy.was.WasSibDestination#getType <em>Type</em>}' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @param value the new value of the '<em>Type</em>' attribute.
	 * @see com.ibm.ccl.soa.deploy.was.WasSibDestinationTypeEnum
	 * @see #isSetType()
	 * @see #unsetType()
	 * @see #getType()
	 * @generated
	 */
	void setType(WasSibDestinationTypeEnum value);

	/**
	 * Unsets the value of the '{@link com.ibm.ccl.soa.deploy.was.WasSibDestination#getType <em>Type</em>}' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see #isSetType()
	 * @see #getType()
	 * @see #setType(WasSibDestinationTypeEnum)
	 * @generated
	 */
	void unsetType();

	/**
	 * Returns whether the value of the '{@link com.ibm.ccl.soa.deploy.was.WasSibDestination#getType <em>Type</em>}' attribute is set.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return whether the value of the '<em>Type</em>' attribute is set.
	 * @see #unsetType()
	 * @see #getType()
	 * @see #setType(WasSibDestinationTypeEnum)
	 * @generated
	 */
	boolean isSetType();

} // WasSibDestination
