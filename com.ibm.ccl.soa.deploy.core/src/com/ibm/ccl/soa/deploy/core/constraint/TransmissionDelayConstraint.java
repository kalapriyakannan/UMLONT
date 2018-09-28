/**
 * Copyright (c) 2005, 2006 IBM Corporation. Licensed Material - Property of IBM. All rights
 * reserved.
 * 
 * $Id: TransmissionDelayConstraint.java,v 1.2 2007/12/21 22:53:19 kalantar Exp $
 */
package com.ibm.ccl.soa.deploy.core.constraint;

/**
 * <!-- begin-user-doc --> A representation of the model object '<em><b>Transmission Delay Constraint</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * 
 * 				Constrains the acceptable transmission delay for communications.
 * 			
 * <!-- end-model-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link com.ibm.ccl.soa.deploy.core.constraint.TransmissionDelayConstraint#getDelay <em>Delay</em>}</li>
 * </ul>
 * </p>
 *
 * @see com.ibm.ccl.soa.deploy.core.constraint.ConstraintPackage#getTransmissionDelayConstraint()
 * @model extendedMetaData="name='TransmissionDelayConstraint' kind='elementOnly'"
 * @generated
 */
public interface TransmissionDelayConstraint extends CommunicationChildConstraint {
	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	String copyright = "Copyright (c) 2005, 2006 IBM Corporation. Licensed Material - Property of IBM. All rights reserved."; //$NON-NLS-1$

	/**
	 * Returns the value of the '<em><b>Delay</b></em>' attribute. <!-- begin-user-doc --> <!--
	 * end-user-doc --> <!-- begin-model-doc -->
	 * 
	 * Acceptable delay in milliseconds.
	 * 
	 * <!-- end-model-doc -->
	 * 
	 * @return the value of the '<em>Delay</em>' attribute.
	 * @see #isSetDelay()
	 * @see #unsetDelay()
	 * @see #setDelay(int)
	 * @see com.ibm.ccl.soa.deploy.core.constraint.ConstraintPackage#getTransmissionDelayConstraint_Delay()
	 * @model unsettable="true" dataType="org.eclipse.emf.ecore.xml.type.Int" required="true"
	 *        extendedMetaData="kind='attribute' name='delay'"
	 * @generated
	 */
	int getDelay();

	/**
	 * Sets the value of the '{@link com.ibm.ccl.soa.deploy.core.constraint.TransmissionDelayConstraint#getDelay <em>Delay</em>}' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @param value the new value of the '<em>Delay</em>' attribute.
	 * @see #isSetDelay()
	 * @see #unsetDelay()
	 * @see #getDelay()
	 * @generated
	 */
	void setDelay(int value);

	/**
	 * Unsets the value of the '{@link com.ibm.ccl.soa.deploy.core.constraint.TransmissionDelayConstraint#getDelay <em>Delay</em>}' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see #isSetDelay()
	 * @see #getDelay()
	 * @see #setDelay(int)
	 * @generated
	 */
	void unsetDelay();

	/**
	 * Returns whether the value of the '{@link com.ibm.ccl.soa.deploy.core.constraint.TransmissionDelayConstraint#getDelay <em>Delay</em>}' attribute is set.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return whether the value of the '<em>Delay</em>' attribute is set.
	 * @see #unsetDelay()
	 * @see #getDelay()
	 * @see #setDelay(int)
	 * @generated
	 */
	boolean isSetDelay();

} // TransmissionDelayConstraint
