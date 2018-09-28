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
 * <!-- begin-user-doc --> A representation of the literals of the enumeration '<em><b>Account Type Enum</b></em>',
 * and utility methods for working with them. <!-- end-user-doc -->
 * @see com.ibm.ccl.soa.deploy.was.WasPackage#getWasAccountTypeEnum()
 * @model extendedMetaData="name='WasAccountTypeEnum'"
 * @generated
 */
public final class WasAccountTypeEnum extends AbstractEnumerator {
	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public static final String copyright = "Copyright (c) 2005, 2006 IBM Corporation. Licensed Material - Property of IBM. All rights reserved."; //$NON-NLS-1$

	/**
	 * The '<em><b>Localsystem</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>Localsystem</b></em>' literal object isn't clear, there really
	 * should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #LOCALSYSTEM_LITERAL
	 * @model name="localsystem"
	 * @generated
	 * @ordered
	 */
	public static final int LOCALSYSTEM = 0;

	/**
	 * The '<em><b>Specifieduser</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>Specifieduser</b></em>' literal object isn't clear, there
	 * really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #SPECIFIEDUSER_LITERAL
	 * @model name="specifieduser"
	 * @generated
	 * @ordered
	 */
	public static final int SPECIFIEDUSER = 1;

	/**
	 * The '<em><b>Localsystem</b></em>' literal object.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @see #LOCALSYSTEM
	 * @generated
	 * @ordered
	 */
	public static final WasAccountTypeEnum LOCALSYSTEM_LITERAL = new WasAccountTypeEnum(LOCALSYSTEM, "localsystem", "localsystem"); //$NON-NLS-1$ //$NON-NLS-2$

	/**
	 * The '<em><b>Specifieduser</b></em>' literal object.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @see #SPECIFIEDUSER
	 * @generated
	 * @ordered
	 */
	public static final WasAccountTypeEnum SPECIFIEDUSER_LITERAL = new WasAccountTypeEnum(SPECIFIEDUSER, "specifieduser", "specifieduser"); //$NON-NLS-1$ //$NON-NLS-2$

	/**
	 * An array of all the '<em><b>Account Type Enum</b></em>' enumerators.
	 * <!-- begin-user-doc
	 * --> <!-- end-user-doc -->
	 * @generated
	 */
	private static final WasAccountTypeEnum[] VALUES_ARRAY = new WasAccountTypeEnum[] {
			LOCALSYSTEM_LITERAL,
			SPECIFIEDUSER_LITERAL,
		};

	/**
	 * A public read-only list of all the '<em><b>Account Type Enum</b></em>' enumerators. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public static final List VALUES = Collections.unmodifiableList(Arrays.asList(VALUES_ARRAY));

	/**
	 * Returns the '<em><b>Account Type Enum</b></em>' literal with the specified literal value.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public static WasAccountTypeEnum get(String literal) {
		for (int i = 0; i < VALUES_ARRAY.length; ++i) {
			WasAccountTypeEnum result = VALUES_ARRAY[i];
			if (result.toString().equals(literal)) {
				return result;
			}
		}
		return null;
	}

	/**
	 * Returns the '<em><b>Account Type Enum</b></em>' literal with the specified name. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public static WasAccountTypeEnum getByName(String name) {
		for (int i = 0; i < VALUES_ARRAY.length; ++i) {
			WasAccountTypeEnum result = VALUES_ARRAY[i];
			if (result.getName().equals(name)) {
				return result;
			}
		}
		return null;
	}

	/**
	 * Returns the '<em><b>Account Type Enum</b></em>' literal with the specified integer value.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public static WasAccountTypeEnum get(int value) {
		switch (value) {
			case LOCALSYSTEM: return LOCALSYSTEM_LITERAL;
			case SPECIFIEDUSER: return SPECIFIEDUSER_LITERAL;
		}
		return null;
	}

	/**
	 * Only this class can construct instances.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	private WasAccountTypeEnum(int value, String name, String literal) {
		super(value, name, literal);
	}

} //WasAccountTypeEnum
