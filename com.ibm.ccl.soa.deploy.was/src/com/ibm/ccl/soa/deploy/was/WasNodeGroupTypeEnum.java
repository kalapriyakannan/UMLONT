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
 * <!-- begin-user-doc --> A representation of the literals of the enumeration '<em><b>Node Group Type Enum</b></em>',
 * and utility methods for working with them. <!-- end-user-doc -->
 * @see com.ibm.ccl.soa.deploy.was.WasPackage#getWasNodeGroupTypeEnum()
 * @model extendedMetaData="name='WasNodeGroupTypeEnum'"
 * @generated
 */
public final class WasNodeGroupTypeEnum extends AbstractEnumerator {
	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public static final String copyright = "Copyright (c) 2005, 2006 IBM Corporation. Licensed Material - Property of IBM. All rights reserved."; //$NON-NLS-1$

	/**
	 * The '<em><b>Default</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>Default</b></em>' literal object isn't clear, there really
	 * should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #DEFAULT_LITERAL
	 * @model name="default"
	 * @generated
	 * @ordered
	 */
	public static final int DEFAULT = 0;

	/**
	 * The '<em><b>User</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>User</b></em>' literal object isn't clear, there really should
	 * be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #USER_LITERAL
	 * @model name="user"
	 * @generated
	 * @ordered
	 */
	public static final int USER = 1;

	/**
	 * The '<em><b>Default</b></em>' literal object. <!-- begin-user-doc --> <!-- end-user-doc
	 * -->
	 * 
	 * @see #DEFAULT
	 * @generated
	 * @ordered
	 */
	public static final WasNodeGroupTypeEnum DEFAULT_LITERAL = new WasNodeGroupTypeEnum(DEFAULT, "default", "default"); //$NON-NLS-1$ //$NON-NLS-2$

	/**
	 * The '<em><b>User</b></em>' literal object.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see #USER
	 * @generated
	 * @ordered
	 */
	public static final WasNodeGroupTypeEnum USER_LITERAL = new WasNodeGroupTypeEnum(USER, "user", "user"); //$NON-NLS-1$ //$NON-NLS-2$

	/**
	 * An array of all the '<em><b>Node Group Type Enum</b></em>' enumerators. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	private static final WasNodeGroupTypeEnum[] VALUES_ARRAY = new WasNodeGroupTypeEnum[] {
			DEFAULT_LITERAL,
			USER_LITERAL,
		};

	/**
	 * A public read-only list of all the '<em><b>Node Group Type Enum</b></em>' enumerators.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public static final List VALUES = Collections.unmodifiableList(Arrays.asList(VALUES_ARRAY));

	/**
	 * Returns the '<em><b>Node Group Type Enum</b></em>' literal with the specified literal value.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public static WasNodeGroupTypeEnum get(String literal) {
		for (int i = 0; i < VALUES_ARRAY.length; ++i) {
			WasNodeGroupTypeEnum result = VALUES_ARRAY[i];
			if (result.toString().equals(literal)) {
				return result;
			}
		}
		return null;
	}

	/**
	 * Returns the '<em><b>Node Group Type Enum</b></em>' literal with the specified name. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public static WasNodeGroupTypeEnum getByName(String name) {
		for (int i = 0; i < VALUES_ARRAY.length; ++i) {
			WasNodeGroupTypeEnum result = VALUES_ARRAY[i];
			if (result.getName().equals(name)) {
				return result;
			}
		}
		return null;
	}

	/**
	 * Returns the '<em><b>Node Group Type Enum</b></em>' literal with the specified integer value.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public static WasNodeGroupTypeEnum get(int value) {
		switch (value) {
			case DEFAULT: return DEFAULT_LITERAL;
			case USER: return USER_LITERAL;
		}
		return null;
	}

	/**
	 * Only this class can construct instances.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	private WasNodeGroupTypeEnum(int value, String name, String literal) {
		super(value, name, literal);
	}

} //WasNodeGroupTypeEnum
