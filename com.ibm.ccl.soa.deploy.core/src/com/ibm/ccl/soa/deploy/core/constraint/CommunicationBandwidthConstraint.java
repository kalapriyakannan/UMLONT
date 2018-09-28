/**
 * Copyright (c) 2005, 2006 IBM Corporation. Licensed Material - Property of IBM. All rights
 * reserved.
 * 
 * $Id: CommunicationBandwidthConstraint.java,v 1.2 2007/12/21 22:53:19 kalantar Exp $
 */
package com.ibm.ccl.soa.deploy.core.constraint;

/**
 * <!-- begin-user-doc --> A representation of the model object '<em><b>Communication Bandwidth Constraint</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * 
 * 				Expresses a required bandwidth for communications.
 * 			
 * <!-- end-model-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link com.ibm.ccl.soa.deploy.core.constraint.CommunicationBandwidthConstraint#getBandwidth <em>Bandwidth</em>}</li>
 * </ul>
 * </p>
 *
 * @see com.ibm.ccl.soa.deploy.core.constraint.ConstraintPackage#getCommunicationBandwidthConstraint()
 * @model extendedMetaData="name='CommunicationBandwidthConstraint' kind='elementOnly'"
 * @generated
 */
public interface CommunicationBandwidthConstraint extends CommunicationChildConstraint {
	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	String copyright = "Copyright (c) 2005, 2006 IBM Corporation. Licensed Material - Property of IBM. All rights reserved."; //$NON-NLS-1$

	/**
	 * Returns the value of the '<em><b>Bandwidth</b></em>' attribute. <!-- begin-user-doc -->
	 * <!-- end-user-doc --> <!-- begin-model-doc -->
	 * 
	 * Required bandwidth in bits per second.
	 * 
	 * <!-- end-model-doc -->
	 * 
	 * @return the value of the '<em>Bandwidth</em>' attribute.
	 * @see #isSetBandwidth()
	 * @see #unsetBandwidth()
	 * @see #setBandwidth(int)
	 * @see com.ibm.ccl.soa.deploy.core.constraint.ConstraintPackage#getCommunicationBandwidthConstraint_Bandwidth()
	 * @model unsettable="true" dataType="org.eclipse.emf.ecore.xml.type.Int" required="true"
	 *        extendedMetaData="kind='attribute' name='bandwidth'"
	 * @generated
	 */
	int getBandwidth();

	/**
	 * Sets the value of the '{@link com.ibm.ccl.soa.deploy.core.constraint.CommunicationBandwidthConstraint#getBandwidth <em>Bandwidth</em>}' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @param value the new value of the '<em>Bandwidth</em>' attribute.
	 * @see #isSetBandwidth()
	 * @see #unsetBandwidth()
	 * @see #getBandwidth()
	 * @generated
	 */
	void setBandwidth(int value);

	/**
	 * Unsets the value of the '{@link com.ibm.ccl.soa.deploy.core.constraint.CommunicationBandwidthConstraint#getBandwidth <em>Bandwidth</em>}' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see #isSetBandwidth()
	 * @see #getBandwidth()
	 * @see #setBandwidth(int)
	 * @generated
	 */
	void unsetBandwidth();

	/**
	 * Returns whether the value of the '{@link com.ibm.ccl.soa.deploy.core.constraint.CommunicationBandwidthConstraint#getBandwidth <em>Bandwidth</em>}' attribute is set.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return whether the value of the '<em>Bandwidth</em>' attribute is set.
	 * @see #unsetBandwidth()
	 * @see #getBandwidth()
	 * @see #setBandwidth(int)
	 * @generated
	 */
	boolean isSetBandwidth();

} // CommunicationBandwidthConstraint
