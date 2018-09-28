/**
 * Copyright (c) 2005, 2006 IBM Corporation. Licensed Material - Property of IBM. All rights reserved.
 *
 * $Id: StereotypeConstraint.java,v 1.1 2008/06/19 22:33:08 danberg Exp $
 */
package com.ibm.ccl.soa.deploy.core.constraint;

import com.ibm.ccl.soa.deploy.core.Constraint;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Stereotype Constraint</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * A constraint that detects the existence and/or the non-existence of stereotype tags.
 * <!-- end-model-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link com.ibm.ccl.soa.deploy.core.constraint.StereotypeConstraint#getIncludes <em>Includes</em>}</li>
 * </ul>
 * </p>
 *
 * @see com.ibm.ccl.soa.deploy.core.constraint.ConstraintPackage#getStereotypeConstraint()
 * @model extendedMetaData="name='StereotypeConstraint' kind='elementOnly'"
 * @generated
 */
public interface StereotypeConstraint extends Constraint {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String copyright = "Copyright (c) 2005, 2006 IBM Corporation. Licensed Material - Property of IBM. All rights reserved."; //$NON-NLS-1$

	/**
	 * Returns the value of the '<em><b>Includes</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * A comma separated list of stereotype tags that will be tested for inclusion.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Includes</em>' attribute.
	 * @see #setIncludes(String)
	 * @see com.ibm.ccl.soa.deploy.core.constraint.ConstraintPackage#getStereotypeConstraint_Includes()
	 * @model dataType="org.eclipse.emf.ecore.xml.type.String" required="true"
	 *        extendedMetaData="kind='attribute' name='includes'"
	 * @generated
	 */
	String getIncludes();

	/**
	 * Sets the value of the '{@link com.ibm.ccl.soa.deploy.core.constraint.StereotypeConstraint#getIncludes <em>Includes</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Includes</em>' attribute.
	 * @see #getIncludes()
	 * @generated
	 */
	void setIncludes(String value);

} // StereotypeConstraint
