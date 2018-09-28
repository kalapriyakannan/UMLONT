/*******************************************************************************
 * Copyright (c) 2003, 2007 IBM Corporation Licensed Material - Property of IBM. All rights reserved.
 *  
 * US Government Users Restricted Rights - Use, duplication or disclosure v1.0 restricted by GSA ADP
 * Schedule Contract with IBM Corp.
 * 
 * Contributors: IBM Corporation - initial API and implementation
 *******************************************************************************/
package com.ibm.ccl.soa.deploy.core;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.eclipse.emf.common.util.AbstractEnumerator;

/**
 * <!-- begin-user-doc -->
 * A representation of the literals of the enumeration '<em><b>Visibility</b></em>',
 * and utility methods for working with them.
 * <!-- end-user-doc -->
 * <!-- begin-model-doc -->
 * 
 * 				Defines an enumeration of the possible contract visibility types (private, public, public-editable)
 * 			
 * <!-- end-model-doc -->
 * @see com.ibm.ccl.soa.deploy.core.CorePackage#getVisibility()
 * @model extendedMetaData="name='Visibility'"
 * @generated
 */
public final class Visibility extends AbstractEnumerator {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final String copyright = "Copyright (c) 2005, 2006 IBM Corporation. Licensed Material - Property of IBM. All rights reserved."; //$NON-NLS-1$

	/**
	 * The '<em><b>Private</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>Private</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #PRIVATE_LITERAL
	 * @model name="private"
	 * @generated
	 * @ordered
	 */
	public static final int PRIVATE = 0;

	/**
	 * The '<em><b>Public</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>Public</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #PUBLIC_LITERAL
	 * @model name="public"
	 * @generated
	 * @ordered
	 */
	public static final int PUBLIC = 1;

	/**
	 * The '<em><b>Public Editable</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>Public Editable</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #PUBLIC_EDITABLE_LITERAL
	 * @model name="publicEditable" literal="public_editable"
	 * @generated
	 * @ordered
	 */
	public static final int PUBLIC_EDITABLE = 2;

	/**
	 * The '<em><b>Private</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #PRIVATE
	 * @generated
	 * @ordered
	 */
	public static final Visibility PRIVATE_LITERAL = new Visibility(PRIVATE, "private", "private"); //$NON-NLS-1$ //$NON-NLS-2$

	/**
	 * The '<em><b>Public</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #PUBLIC
	 * @generated
	 * @ordered
	 */
	public static final Visibility PUBLIC_LITERAL = new Visibility(PUBLIC, "public", "public"); //$NON-NLS-1$ //$NON-NLS-2$

	/**
	 * The '<em><b>Public Editable</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #PUBLIC_EDITABLE
	 * @generated
	 * @ordered
	 */
	public static final Visibility PUBLIC_EDITABLE_LITERAL = new Visibility(PUBLIC_EDITABLE, "publicEditable", "public_editable"); //$NON-NLS-1$ //$NON-NLS-2$

	/**
	 * An array of all the '<em><b>Visibility</b></em>' enumerators.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private static final Visibility[] VALUES_ARRAY =
		new Visibility[] {
			PRIVATE_LITERAL,
			PUBLIC_LITERAL,
			PUBLIC_EDITABLE_LITERAL,
		};

	/**
	 * A public read-only list of all the '<em><b>Visibility</b></em>' enumerators.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final List VALUES = Collections.unmodifiableList(Arrays.asList(VALUES_ARRAY));

	/**
	 * Returns the '<em><b>Visibility</b></em>' literal with the specified literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static Visibility get(String literal) {
		for (int i = 0; i < VALUES_ARRAY.length; ++i) {
			Visibility result = VALUES_ARRAY[i];
			if (result.toString().equals(literal)) {
				return result;
			}
		}
		return null;
	}

	/**
	 * Returns the '<em><b>Visibility</b></em>' literal with the specified name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static Visibility getByName(String name) {
		for (int i = 0; i < VALUES_ARRAY.length; ++i) {
			Visibility result = VALUES_ARRAY[i];
			if (result.getName().equals(name)) {
				return result;
			}
		}
		return null;
	}

	/**
	 * Returns the '<em><b>Visibility</b></em>' literal with the specified integer value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static Visibility get(int value) {
		switch (value) {
			case PRIVATE: return PRIVATE_LITERAL;
			case PUBLIC: return PUBLIC_LITERAL;
			case PUBLIC_EDITABLE: return PUBLIC_EDITABLE_LITERAL;
		}
		return null;
	}

	/**
	 * Only this class can construct instances.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private Visibility(int value, String name, String literal) {
		super(value, name, literal);
	}

} //Visibility
