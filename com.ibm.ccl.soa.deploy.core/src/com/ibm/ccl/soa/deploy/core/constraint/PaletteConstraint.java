/**
 * Copyright (c) 2005, 2006 IBM Corporation. Licensed Material - Property of IBM. All rights reserved.
 *
 * $Id: PaletteConstraint.java,v 1.2 2008/04/23 19:20:00 chadh Exp $
 */
package com.ibm.ccl.soa.deploy.core.constraint;

import com.ibm.ccl.soa.deploy.core.Constraint;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Palette Constraint</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * A constraint that denotes this topology is a dynamic palette entry.
 * <!-- end-model-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link com.ibm.ccl.soa.deploy.core.constraint.PaletteConstraint#getResourceTypeId <em>Resource Type Id</em>}</li>
 * </ul>
 * </p>
 *
 * @see com.ibm.ccl.soa.deploy.core.constraint.ConstraintPackage#getPaletteConstraint()
 * @model extendedMetaData="name='PaletteConstraint' kind='elementOnly'"
 * @generated
 */
public interface PaletteConstraint extends Constraint {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String copyright = "Copyright (c) 2005, 2006 IBM Corporation. Licensed Material - Property of IBM. All rights reserved."; //$NON-NLS-1$

	/**
	 * Returns the value of the '<em><b>Resource Type Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * Resource type id of the palette entry.  Used to locate palette information in the dynamic types registry.
	 *         				
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Resource Type Id</em>' attribute.
	 * @see #setResourceTypeId(String)
	 * @see com.ibm.ccl.soa.deploy.core.constraint.ConstraintPackage#getPaletteConstraint_ResourceTypeId()
	 * @model dataType="org.eclipse.emf.ecore.xml.type.String" required="true"
	 *        extendedMetaData="kind='attribute' name='resourceTypeId'"
	 * @generated
	 */
	String getResourceTypeId();

	/**
	 * Sets the value of the '{@link com.ibm.ccl.soa.deploy.core.constraint.PaletteConstraint#getResourceTypeId <em>Resource Type Id</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Resource Type Id</em>' attribute.
	 * @see #getResourceTypeId()
	 * @generated
	 */
	void setResourceTypeId(String value);

} // PaletteConstraint
