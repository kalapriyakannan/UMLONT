/**
 * Copyright (c) 2005, 2006 IBM Corporation. Licensed Material - Property of IBM. All rights reserved.
 *
 * $Id: SynchronousCommunicationConstraint.java,v 1.1 2007/12/21 15:46:14 kalantar Exp $
 */
package com.ibm.ccl.soa.deploy.core.constraint;

import com.ibm.ccl.soa.deploy.core.Constraint;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Synchronous Communication Constraint</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * 
 * 				Specifies whether or not the communication is synchronous.
 * 			
 * <!-- end-model-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link com.ibm.ccl.soa.deploy.core.constraint.SynchronousCommunicationConstraint#isSynchronous <em>Synchronous</em>}</li>
 * </ul>
 * </p>
 *
 * @see com.ibm.ccl.soa.deploy.core.constraint.ConstraintPackage#getSynchronousCommunicationConstraint()
 * @model extendedMetaData="name='SynchronousCommunicationConstraint' kind='elementOnly'"
 * @generated
 */
public interface SynchronousCommunicationConstraint extends Constraint {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String copyright = "Copyright (c) 2005, 2006 IBM Corporation. Licensed Material - Property of IBM. All rights reserved."; //$NON-NLS-1$

	/**
	 * Returns the value of the '<em><b>Synchronous</b></em>' attribute.
	 * The default value is <code>"true"</code>.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * 
	 * 							Flag indicating whether or not communication is synchronous.  Default is true.
	 * 						
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Synchronous</em>' attribute.
	 * @see #isSetSynchronous()
	 * @see #unsetSynchronous()
	 * @see #setSynchronous(boolean)
	 * @see com.ibm.ccl.soa.deploy.core.constraint.ConstraintPackage#getSynchronousCommunicationConstraint_Synchronous()
	 * @model default="true" unsettable="true" dataType="org.eclipse.emf.ecore.xml.type.Boolean"
	 *        extendedMetaData="kind='attribute' name='synchronous'"
	 * @generated
	 */
	boolean isSynchronous();

	/**
	 * Sets the value of the '{@link com.ibm.ccl.soa.deploy.core.constraint.SynchronousCommunicationConstraint#isSynchronous <em>Synchronous</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Synchronous</em>' attribute.
	 * @see #isSetSynchronous()
	 * @see #unsetSynchronous()
	 * @see #isSynchronous()
	 * @generated
	 */
	void setSynchronous(boolean value);

	/**
	 * Unsets the value of the '{@link com.ibm.ccl.soa.deploy.core.constraint.SynchronousCommunicationConstraint#isSynchronous <em>Synchronous</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetSynchronous()
	 * @see #isSynchronous()
	 * @see #setSynchronous(boolean)
	 * @generated
	 */
	void unsetSynchronous();

	/**
	 * Returns whether the value of the '{@link com.ibm.ccl.soa.deploy.core.constraint.SynchronousCommunicationConstraint#isSynchronous <em>Synchronous</em>}' attribute is set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return whether the value of the '<em>Synchronous</em>' attribute is set.
	 * @see #unsetSynchronous()
	 * @see #isSynchronous()
	 * @see #setSynchronous(boolean)
	 * @generated
	 */
	boolean isSetSynchronous();

} // SynchronousCommunicationConstraint
