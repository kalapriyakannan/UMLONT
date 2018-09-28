/**
 * Copyright (c) 2005, 2006 IBM Corporation. Licensed Material - Property of IBM. All rights reserved.
 *
 * $Id: BaseCommunicationConstraint.java,v 1.2 2008/04/20 23:12:17 kalantar Exp $
 */
package com.ibm.ccl.soa.deploy.core.constraint;

import com.ibm.ccl.soa.deploy.core.Constraint;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Base Communication Constraint</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * 
 * 				Idenitifies requirement for communication between elements. In general this is between units. 
 * 				However, it may be expressed on dependency link between a requirement and a capability.
 * 			
 * <!-- end-model-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link com.ibm.ccl.soa.deploy.core.constraint.BaseCommunicationConstraint#isRespectLinkDirection <em>Respect Link Direction</em>}</li>
 * </ul>
 * </p>
 *
 * @see com.ibm.ccl.soa.deploy.core.constraint.ConstraintPackage#getBaseCommunicationConstraint()
 * @model extendedMetaData="name='BaseCommunicationConstraint' kind='elementOnly'"
 * @generated
 */
public interface BaseCommunicationConstraint extends Constraint {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String copyright = "Copyright (c) 2005, 2006 IBM Corporation. Licensed Material - Property of IBM. All rights reserved."; //$NON-NLS-1$

	/**
	 * Returns the value of the '<em><b>Respect Link Direction</b></em>' attribute.
	 * The default value is <code>"true"</code>.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * 
	 * 							When true, the originator of the communication is the source of the link.
	 * 							Otherwise, the originator is the target of the link.
	 * 							By default, this should be true.
	 * 						
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Respect Link Direction</em>' attribute.
	 * @see #isSetRespectLinkDirection()
	 * @see #unsetRespectLinkDirection()
	 * @see #setRespectLinkDirection(boolean)
	 * @see com.ibm.ccl.soa.deploy.core.constraint.ConstraintPackage#getBaseCommunicationConstraint_RespectLinkDirection()
	 * @model default="true" unsettable="true" dataType="org.eclipse.emf.ecore.xml.type.Boolean"
	 *        extendedMetaData="kind='attribute' name='respectLinkDirection'"
	 * @generated
	 */
	boolean isRespectLinkDirection();

	/**
	 * Sets the value of the '{@link com.ibm.ccl.soa.deploy.core.constraint.BaseCommunicationConstraint#isRespectLinkDirection <em>Respect Link Direction</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Respect Link Direction</em>' attribute.
	 * @see #isSetRespectLinkDirection()
	 * @see #unsetRespectLinkDirection()
	 * @see #isRespectLinkDirection()
	 * @generated
	 */
	void setRespectLinkDirection(boolean value);

	/**
	 * Unsets the value of the '{@link com.ibm.ccl.soa.deploy.core.constraint.BaseCommunicationConstraint#isRespectLinkDirection <em>Respect Link Direction</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetRespectLinkDirection()
	 * @see #isRespectLinkDirection()
	 * @see #setRespectLinkDirection(boolean)
	 * @generated
	 */
	void unsetRespectLinkDirection();

	/**
	 * Returns whether the value of the '{@link com.ibm.ccl.soa.deploy.core.constraint.BaseCommunicationConstraint#isRespectLinkDirection <em>Respect Link Direction</em>}' attribute is set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return whether the value of the '<em>Respect Link Direction</em>' attribute is set.
	 * @see #unsetRespectLinkDirection()
	 * @see #isRespectLinkDirection()
	 * @see #setRespectLinkDirection(boolean)
	 * @generated
	 */
	boolean isSetRespectLinkDirection();

} // BaseCommunicationConstraint
