/**
 * Copyright (c) 2005, 2006 IBM Corporation. Licensed Material - Property of IBM. All rights
 * reserved.
 * 
 * $Id: CommunicationCostConstraint.java,v 1.2 2007/12/21 22:53:19 kalantar Exp $
 */
package com.ibm.ccl.soa.deploy.core.constraint;

/**
 * <!-- begin-user-doc --> A representation of the model object '<em><b>Communication Cost Constraint</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * 
 * 				Expresses a required maximum cost for communications.
 * 			
 * <!-- end-model-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link com.ibm.ccl.soa.deploy.core.constraint.CommunicationCostConstraint#getCost <em>Cost</em>}</li>
 * </ul>
 * </p>
 *
 * @see com.ibm.ccl.soa.deploy.core.constraint.ConstraintPackage#getCommunicationCostConstraint()
 * @model extendedMetaData="name='CommunicationCostConstraint' kind='elementOnly'"
 * @generated
 */
public interface CommunicationCostConstraint extends CommunicationChildConstraint {
	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	String copyright = "Copyright (c) 2005, 2006 IBM Corporation. Licensed Material - Property of IBM. All rights reserved."; //$NON-NLS-1$

	/**
	 * Returns the value of the '<em><b>Cost</b></em>' attribute. <!-- begin-user-doc --> <!--
	 * end-user-doc --> <!-- begin-model-doc -->
	 * 
	 * Maximum allowable cost in dollars.
	 * 
	 * <!-- end-model-doc -->
	 * 
	 * @return the value of the '<em>Cost</em>' attribute.
	 * @see #isSetCost()
	 * @see #unsetCost()
	 * @see #setCost(int)
	 * @see com.ibm.ccl.soa.deploy.core.constraint.ConstraintPackage#getCommunicationCostConstraint_Cost()
	 * @model unsettable="true" dataType="org.eclipse.emf.ecore.xml.type.Int" required="true"
	 *        extendedMetaData="kind='attribute' name='cost'"
	 * @generated
	 */
	int getCost();

	/**
	 * Sets the value of the '{@link com.ibm.ccl.soa.deploy.core.constraint.CommunicationCostConstraint#getCost <em>Cost</em>}' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @param value the new value of the '<em>Cost</em>' attribute.
	 * @see #isSetCost()
	 * @see #unsetCost()
	 * @see #getCost()
	 * @generated
	 */
	void setCost(int value);

	/**
	 * Unsets the value of the '{@link com.ibm.ccl.soa.deploy.core.constraint.CommunicationCostConstraint#getCost <em>Cost</em>}' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see #isSetCost()
	 * @see #getCost()
	 * @see #setCost(int)
	 * @generated
	 */
	void unsetCost();

	/**
	 * Returns whether the value of the '{@link com.ibm.ccl.soa.deploy.core.constraint.CommunicationCostConstraint#getCost <em>Cost</em>}' attribute is set.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return whether the value of the '<em>Cost</em>' attribute is set.
	 * @see #unsetCost()
	 * @see #getCost()
	 * @see #setCost(int)
	 * @generated
	 */
	boolean isSetCost();

} // CommunicationCostConstraint
