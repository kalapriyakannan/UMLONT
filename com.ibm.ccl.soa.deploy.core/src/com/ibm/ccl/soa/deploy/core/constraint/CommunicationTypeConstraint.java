/**
 * Copyright (c) 2005, 2006 IBM Corporation. Licensed Material - Property of IBM. All rights
 * reserved.
 * 
 * $Id: CommunicationTypeConstraint.java,v 1.2 2008/04/20 23:12:17 kalantar Exp $
 */
package com.ibm.ccl.soa.deploy.core.constraint;

/**
 * <!-- begin-user-doc --> A representation of the model object '<em><b>Communication Type Constraint</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * 
 * 				Communication type required.
 * 			
 * <!-- end-model-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link com.ibm.ccl.soa.deploy.core.constraint.CommunicationTypeConstraint#getType <em>Type</em>}</li>
 * </ul>
 * </p>
 *
 * @see com.ibm.ccl.soa.deploy.core.constraint.ConstraintPackage#getCommunicationTypeConstraint()
 * @model extendedMetaData="name='CommunicationTypeConstraint' kind='elementOnly'"
 * @generated
 */
public interface CommunicationTypeConstraint extends CommunicationChildConstraint {
	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	String copyright = "Copyright (c) 2005, 2006 IBM Corporation. Licensed Material - Property of IBM. All rights reserved."; //$NON-NLS-1$

	/**
	 * Returns the value of the '<em><b>Type</b></em>' attribute. The default value is
	 * <code>"LAN"</code>. The literals are from the enumeration
	 * {@link com.ibm.ccl.soa.deploy.core.constraint.CommunicationTypeTypes}. <!-- begin-user-doc
	 * --> <!-- end-user-doc --> <!-- begin-model-doc -->
	 * 
	 * Communication type
	 * 
	 * <!-- end-model-doc -->
	 * 
	 * @return the value of the '<em>Type</em>' attribute.
	 * @see com.ibm.ccl.soa.deploy.core.constraint.CommunicationTypeTypes
	 * @see #isSetType()
	 * @see #unsetType()
	 * @see #setType(CommunicationTypeTypes)
	 * @see com.ibm.ccl.soa.deploy.core.constraint.ConstraintPackage#getCommunicationTypeConstraint_Type()
	 * @model default="LAN" unsettable="true" extendedMetaData="kind='attribute' name='type'"
	 * @generated
	 */
	CommunicationTypeTypes getType();

	/**
	 * Sets the value of the '{@link com.ibm.ccl.soa.deploy.core.constraint.CommunicationTypeConstraint#getType <em>Type</em>}' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @param value the new value of the '<em>Type</em>' attribute.
	 * @see com.ibm.ccl.soa.deploy.core.constraint.CommunicationTypeTypes
	 * @see #isSetType()
	 * @see #unsetType()
	 * @see #getType()
	 * @generated
	 */
	void setType(CommunicationTypeTypes value);

	/**
	 * Unsets the value of the '{@link com.ibm.ccl.soa.deploy.core.constraint.CommunicationTypeConstraint#getType <em>Type</em>}' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see #isSetType()
	 * @see #getType()
	 * @see #setType(CommunicationTypeTypes)
	 * @generated
	 */
	void unsetType();

	/**
	 * Returns whether the value of the '{@link com.ibm.ccl.soa.deploy.core.constraint.CommunicationTypeConstraint#getType <em>Type</em>}' attribute is set.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return whether the value of the '<em>Type</em>' attribute is set.
	 * @see #unsetType()
	 * @see #getType()
	 * @see #setType(CommunicationTypeTypes)
	 * @generated
	 */
	boolean isSetType();

} // CommunicationTypeConstraint
