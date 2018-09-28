/**
 * Copyright (c) 2005, 2006 IBM Corporation. Licensed Material - Property of IBM. All rights
 * reserved.
 * 
 * $Id: CommunicationRedundancyConstraint.java,v 1.2 2007/12/21 22:53:19 kalantar Exp $
 */
package com.ibm.ccl.soa.deploy.core.constraint;

/**
 * <!-- begin-user-doc --> A representation of the model object '<em><b>Communication Redundancy Constraint</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * 
 * 				Expresses a required mimimum redundancy for communication.
 * 			
 * <!-- end-model-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link com.ibm.ccl.soa.deploy.core.constraint.CommunicationRedundancyConstraint#getRedundancy <em>Redundancy</em>}</li>
 * </ul>
 * </p>
 *
 * @see com.ibm.ccl.soa.deploy.core.constraint.ConstraintPackage#getCommunicationRedundancyConstraint()
 * @model extendedMetaData="name='CommunicationRedundancyConstraint' kind='elementOnly'"
 * @generated
 */
public interface CommunicationRedundancyConstraint extends CommunicationChildConstraint {
	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	String copyright = "Copyright (c) 2005, 2006 IBM Corporation. Licensed Material - Property of IBM. All rights reserved."; //$NON-NLS-1$

	/**
	 * Returns the value of the '<em><b>Redundancy</b></em>' attribute. The default value is
	 * <code>"1"</code>. <!-- begin-user-doc --> <!-- end-user-doc --> <!-- begin-model-doc -->
	 * 
	 * Minimum allowable communication path redundancy.
	 * 
	 * <!-- end-model-doc -->
	 * 
	 * @return the value of the '<em>Redundancy</em>' attribute.
	 * @see #isSetRedundancy()
	 * @see #unsetRedundancy()
	 * @see #setRedundancy(int)
	 * @see com.ibm.ccl.soa.deploy.core.constraint.ConstraintPackage#getCommunicationRedundancyConstraint_Redundancy()
	 * @model default="1" unsettable="true" dataType="org.eclipse.emf.ecore.xml.type.Int"
	 *        extendedMetaData="kind='attribute' name='redundancy'"
	 * @generated
	 */
	int getRedundancy();

	/**
	 * Sets the value of the '{@link com.ibm.ccl.soa.deploy.core.constraint.CommunicationRedundancyConstraint#getRedundancy <em>Redundancy</em>}' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @param value the new value of the '<em>Redundancy</em>' attribute.
	 * @see #isSetRedundancy()
	 * @see #unsetRedundancy()
	 * @see #getRedundancy()
	 * @generated
	 */
	void setRedundancy(int value);

	/**
	 * Unsets the value of the '{@link com.ibm.ccl.soa.deploy.core.constraint.CommunicationRedundancyConstraint#getRedundancy <em>Redundancy</em>}' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see #isSetRedundancy()
	 * @see #getRedundancy()
	 * @see #setRedundancy(int)
	 * @generated
	 */
	void unsetRedundancy();

	/**
	 * Returns whether the value of the '{@link com.ibm.ccl.soa.deploy.core.constraint.CommunicationRedundancyConstraint#getRedundancy <em>Redundancy</em>}' attribute is set.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return whether the value of the '<em>Redundancy</em>' attribute is set.
	 * @see #unsetRedundancy()
	 * @see #getRedundancy()
	 * @see #setRedundancy(int)
	 * @generated
	 */
	boolean isSetRedundancy();

} // CommunicationRedundancyConstraint
