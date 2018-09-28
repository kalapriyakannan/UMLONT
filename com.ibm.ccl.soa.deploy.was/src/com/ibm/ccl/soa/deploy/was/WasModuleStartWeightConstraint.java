/*******************************************************************************
 * Copyright (c) 2003, 2007 IBM Corporation Licensed Material - Property of IBM. All rights reserved.
 *  
 * US Government Users Restricted Rights - Use, duplication or disclosure v1.0 restricted by GSA ADP
 * Schedule Contract with IBM Corp.
 * 
 * Contributors: IBM Corporation - initial API and implementation
 *******************************************************************************/
package com.ibm.ccl.soa.deploy.was;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Module Start Weight Constraint</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * 
 *         		Was module starting weight constraint.
 *         	
 * <!-- end-model-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link com.ibm.ccl.soa.deploy.was.WasModuleStartWeightConstraint#getStartingWeight <em>Starting Weight</em>}</li>
 * </ul>
 * </p>
 *
 * @see com.ibm.ccl.soa.deploy.was.WasPackage#getWasModuleStartWeightConstraint()
 * @model extendedMetaData="name='WasModuleStartWeightConstraint' kind='elementOnly'"
 * @generated
 */
public interface WasModuleStartWeightConstraint extends WasJ2EEConstraint {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String copyright = "Copyright (c) 2005, 2006 IBM Corporation. Licensed Material - Property of IBM. All rights reserved."; //$NON-NLS-1$

	/**
	 * Returns the value of the '<em><b>Starting Weight</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Starting Weight</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Starting Weight</em>' attribute.
	 * @see #isSetStartingWeight()
	 * @see #unsetStartingWeight()
	 * @see #setStartingWeight(int)
	 * @see com.ibm.ccl.soa.deploy.was.WasPackage#getWasModuleStartWeightConstraint_StartingWeight()
	 * @model unsettable="true" dataType="org.eclipse.emf.ecore.xml.type.Int"
	 *        extendedMetaData="kind='attribute' name='startingWeight'"
	 * @generated
	 */
	int getStartingWeight();

	/**
	 * Sets the value of the '{@link com.ibm.ccl.soa.deploy.was.WasModuleStartWeightConstraint#getStartingWeight <em>Starting Weight</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Starting Weight</em>' attribute.
	 * @see #isSetStartingWeight()
	 * @see #unsetStartingWeight()
	 * @see #getStartingWeight()
	 * @generated
	 */
	void setStartingWeight(int value);

	/**
	 * Unsets the value of the '{@link com.ibm.ccl.soa.deploy.was.WasModuleStartWeightConstraint#getStartingWeight <em>Starting Weight</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetStartingWeight()
	 * @see #getStartingWeight()
	 * @see #setStartingWeight(int)
	 * @generated
	 */
	void unsetStartingWeight();

	/**
	 * Returns whether the value of the '{@link com.ibm.ccl.soa.deploy.was.WasModuleStartWeightConstraint#getStartingWeight <em>Starting Weight</em>}' attribute is set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return whether the value of the '<em>Starting Weight</em>' attribute is set.
	 * @see #unsetStartingWeight()
	 * @see #getStartingWeight()
	 * @see #setStartingWeight(int)
	 * @generated
	 */
	boolean isSetStartingWeight();

} // WasModuleStartWeightConstraint
