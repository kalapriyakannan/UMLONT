/*******************************************************************************
 * Copyright (c) 2003, 2007 IBM Corporation Licensed Material - Property of IBM. All rights reserved.
 *  
 * US Government Users Restricted Rights - Use, duplication or disclosure v1.0 restricted by GSA ADP
 * Schedule Contract with IBM Corp.
 * 
 * Contributors: IBM Corporation - initial API and implementation
 *******************************************************************************/
package com.ibm.ccl.soa.deploy.was;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.eclipse.emf.common.util.AbstractEnumerator;

/**
 * <!-- begin-user-doc -->
 * A representation of the literals of the enumeration '<em><b>Default Security Subject Enum</b></em>',
 * and utility methods for working with them.
 * <!-- end-user-doc -->
 * @see com.ibm.ccl.soa.deploy.was.WasPackage#getWasDefaultSecuritySubjectEnum()
 * @model extendedMetaData="name='WasDefaultSecuritySubjectEnum'"
 * @generated
 */
public final class WasDefaultSecuritySubjectEnum extends AbstractEnumerator {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final String copyright = "Copyright (c) 2005, 2006 IBM Corporation. Licensed Material - Property of IBM. All rights reserved."; //$NON-NLS-1$

	/**
	 * The '<em><b>All Authenticated</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>All Authenticated</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #ALL_AUTHENTICATED_LITERAL
	 * @model name="AllAuthenticated"
	 * @generated
	 * @ordered
	 */
	public static final int ALL_AUTHENTICATED = 0;

	/**
	 * The '<em><b>Everyone</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>Everyone</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #EVERYONE_LITERAL
	 * @model name="Everyone"
	 * @generated
	 * @ordered
	 */
	public static final int EVERYONE = 1;

	/**
	 * The '<em><b>All Authenticated</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #ALL_AUTHENTICATED
	 * @generated
	 * @ordered
	 */
	public static final WasDefaultSecuritySubjectEnum ALL_AUTHENTICATED_LITERAL = new WasDefaultSecuritySubjectEnum(ALL_AUTHENTICATED, "AllAuthenticated", "AllAuthenticated"); //$NON-NLS-1$ //$NON-NLS-2$

	/**
	 * The '<em><b>Everyone</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #EVERYONE
	 * @generated
	 * @ordered
	 */
	public static final WasDefaultSecuritySubjectEnum EVERYONE_LITERAL = new WasDefaultSecuritySubjectEnum(EVERYONE, "Everyone", "Everyone"); //$NON-NLS-1$ //$NON-NLS-2$

	/**
	 * An array of all the '<em><b>Default Security Subject Enum</b></em>' enumerators.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private static final WasDefaultSecuritySubjectEnum[] VALUES_ARRAY =
		new WasDefaultSecuritySubjectEnum[] {
			ALL_AUTHENTICATED_LITERAL,
			EVERYONE_LITERAL,
		};

	/**
	 * A public read-only list of all the '<em><b>Default Security Subject Enum</b></em>' enumerators.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final List VALUES = Collections.unmodifiableList(Arrays.asList(VALUES_ARRAY));

	/**
	 * Returns the '<em><b>Default Security Subject Enum</b></em>' literal with the specified literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static WasDefaultSecuritySubjectEnum get(String literal) {
		for (int i = 0; i < VALUES_ARRAY.length; ++i) {
			WasDefaultSecuritySubjectEnum result = VALUES_ARRAY[i];
			if (result.toString().equals(literal)) {
				return result;
			}
		}
		return null;
	}

	/**
	 * Returns the '<em><b>Default Security Subject Enum</b></em>' literal with the specified name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static WasDefaultSecuritySubjectEnum getByName(String name) {
		for (int i = 0; i < VALUES_ARRAY.length; ++i) {
			WasDefaultSecuritySubjectEnum result = VALUES_ARRAY[i];
			if (result.getName().equals(name)) {
				return result;
			}
		}
		return null;
	}

	/**
	 * Returns the '<em><b>Default Security Subject Enum</b></em>' literal with the specified integer value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static WasDefaultSecuritySubjectEnum get(int value) {
		switch (value) {
			case ALL_AUTHENTICATED: return ALL_AUTHENTICATED_LITERAL;
			case EVERYONE: return EVERYONE_LITERAL;
		}
		return null;
	}

	/**
	 * Only this class can construct instances.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private WasDefaultSecuritySubjectEnum(int value, String name, String literal) {
		super(value, name, literal);
	}

} //WasDefaultSecuritySubjectEnum
