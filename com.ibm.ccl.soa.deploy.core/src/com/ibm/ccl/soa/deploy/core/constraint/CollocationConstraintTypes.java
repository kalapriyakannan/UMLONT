/*******************************************************************************
 * Copyright (c) 2003, 2007 IBM Corporation Licensed Material - Property of IBM. All rights reserved.
 *  
 * US Government Users Restricted Rights - Use, duplication or disclosure v1.0 restricted by GSA ADP
 * Schedule Contract with IBM Corp.
 * 
 * Contributors: IBM Corporation - initial API and implementation
 *******************************************************************************/
package com.ibm.ccl.soa.deploy.core.constraint;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.eclipse.emf.common.util.AbstractEnumerator;

/**
 * <!-- begin-user-doc --> A representation of the literals of the enumeration '<em><b>Collocation Constraint Types</b></em>',
 * and utility methods for working with them. <!-- end-user-doc --> <!-- begin-model-doc -->
 * 
 * The types of collocation: COLLOCATION and ANTI-COLLOCATION
 * 
 * <!-- end-model-doc -->
 * 
 * @see com.ibm.ccl.soa.deploy.core.constraint.ConstraintPackage#getCollocationConstraintTypes()
 * @model
 * @generated
 */
public final class CollocationConstraintTypes extends AbstractEnumerator {
	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public static final String copyright = "Copyright (c) 2005, 2006 IBM Corporation. Licensed Material - Property of IBM. All rights reserved."; //$NON-NLS-1$

	/**
	 * The '<em><b>Collocation</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>Collocation</b></em>' literal object isn't clear, there really
	 * should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * 
	 * 				Represents the collocation constraint.
	 * 			
	 * <!-- end-model-doc -->
	 * @see #COLLOCATION_LITERAL
	 * @model name="collocation"
	 * @generated
	 * @ordered
	 */
	public static final int COLLOCATION = 0;

	/**
	 * The '<em><b>Anticollocation</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>Anticollocation</b></em>' literal object isn't clear, there
	 * really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * 
	 * 				Represents the anti-collocation constraint.
	 * 			
	 * <!-- end-model-doc -->
	 * @see #ANTICOLLOCATION_LITERAL
	 * @model name="anticollocation"
	 * @generated
	 * @ordered
	 */
	public static final int ANTICOLLOCATION = 1;

	/**
	 * The '<em><b>Collocation</b></em>' literal object.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @see #COLLOCATION
	 * @generated
	 * @ordered
	 */
	public static final CollocationConstraintTypes COLLOCATION_LITERAL = new CollocationConstraintTypes(COLLOCATION, "collocation", "collocation"); //$NON-NLS-1$ //$NON-NLS-2$

	/**
	 * The '<em><b>Anticollocation</b></em>' literal object.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @see #ANTICOLLOCATION
	 * @generated
	 * @ordered
	 */
	public static final CollocationConstraintTypes ANTICOLLOCATION_LITERAL = new CollocationConstraintTypes(ANTICOLLOCATION, "anticollocation", "anticollocation"); //$NON-NLS-1$ //$NON-NLS-2$

	/**
	 * An array of all the '<em><b>Collocation Constraint Types</b></em>' enumerators. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	private static final CollocationConstraintTypes[] VALUES_ARRAY = new CollocationConstraintTypes[] {
			COLLOCATION_LITERAL,
			ANTICOLLOCATION_LITERAL,
		};

	/**
	 * A public read-only list of all the '<em><b>Collocation Constraint Types</b></em>' enumerators.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public static final List VALUES = Collections.unmodifiableList(Arrays.asList(VALUES_ARRAY));

	/**
	 * Returns the '<em><b>Collocation Constraint Types</b></em>' literal with the specified literal value.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public static CollocationConstraintTypes get(String literal) {
		for (int i = 0; i < VALUES_ARRAY.length; ++i) {
			CollocationConstraintTypes result = VALUES_ARRAY[i];
			if (result.toString().equals(literal)) {
				return result;
			}
		}
		return null;
	}

	/**
	 * Returns the '<em><b>Collocation Constraint Types</b></em>' literal with the specified name.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public static CollocationConstraintTypes getByName(String name) {
		for (int i = 0; i < VALUES_ARRAY.length; ++i) {
			CollocationConstraintTypes result = VALUES_ARRAY[i];
			if (result.getName().equals(name)) {
				return result;
			}
		}
		return null;
	}

	/**
	 * Returns the '<em><b>Collocation Constraint Types</b></em>' literal with the specified integer value.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public static CollocationConstraintTypes get(int value) {
		switch (value) {
			case COLLOCATION: return COLLOCATION_LITERAL;
			case ANTICOLLOCATION: return ANTICOLLOCATION_LITERAL;
		}
		return null;
	}

	/**
	 * Only this class can construct instances.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	private CollocationConstraintTypes(int value, String name, String literal) {
		super(value, name, literal);
	}

} //CollocationConstraintTypes
