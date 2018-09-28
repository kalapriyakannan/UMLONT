/*******************************************************************************
 * Copyright (c) 2003, 2007 IBM Corporation Licensed Material - Property of IBM. All rights reserved.
 *  
 * US Government Users Restricted Rights - Use, duplication or disclosure v1.0 restricted by GSA ADP
 * Schedule Contract with IBM Corp.
 * 
 * Contributors: IBM Corporation - initial API and implementation
 *******************************************************************************/
package com.ibm.ccl.soa.deploy.db2;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.eclipse.emf.common.util.AbstractEnumerator;

/**
 * <!-- begin-user-doc --> A representation of the literals of the enumeration '<em><b>Word Width Type</b></em>',
 * and utility methods for working with them. <!-- end-user-doc --> <!-- begin-model-doc -->
 * 
 * This type defines the word widths available for a unix db2 install.
 * 
 * <!-- end-model-doc -->
 * 
 * @see com.ibm.ccl.soa.deploy.db2.Db2Package#getWordWidthType()
 * @model
 * @generated
 */
public final class WordWidthType extends AbstractEnumerator {
	/**
	 * The '<em><b>31</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>31</b></em>' literal object isn't clear, there really should be
	 * more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #_31_LITERAL
	 * @model literal="31"
	 * @generated
	 * @ordered
	 */
	public static final int _31 = 0;

	/**
	 * The '<em><b>32</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>32</b></em>' literal object isn't clear, there really should be
	 * more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #_32_LITERAL
	 * @model literal="32"
	 * @generated
	 * @ordered
	 */
	public static final int _32 = 1;

	/**
	 * The '<em><b>64</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>64</b></em>' literal object isn't clear, there really should be
	 * more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #_64_LITERAL
	 * @model literal="64"
	 * @generated
	 * @ordered
	 */
	public static final int _64 = 2;

	/**
	 * The '<em><b>31</b></em>' literal object.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see #_31
	 * @generated
	 * @ordered
	 */
	public static final WordWidthType _31_LITERAL = new WordWidthType(_31, "_31", "31"); //$NON-NLS-1$ //$NON-NLS-2$

	/**
	 * The '<em><b>32</b></em>' literal object.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see #_32
	 * @generated
	 * @ordered
	 */
	public static final WordWidthType _32_LITERAL = new WordWidthType(_32, "_32", "32"); //$NON-NLS-1$ //$NON-NLS-2$

	/**
	 * The '<em><b>64</b></em>' literal object.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see #_64
	 * @generated
	 * @ordered
	 */
	public static final WordWidthType _64_LITERAL = new WordWidthType(_64, "_64", "64"); //$NON-NLS-1$ //$NON-NLS-2$

	/**
	 * An array of all the '<em><b>Word Width Type</b></em>' enumerators.
	 * <!-- begin-user-doc
	 * --> <!-- end-user-doc -->
	 * @generated
	 */
	private static final WordWidthType[] VALUES_ARRAY = new WordWidthType[] {
			_31_LITERAL,
			_32_LITERAL,
			_64_LITERAL,
		};

	/**
	 * A public read-only list of all the '<em><b>Word Width Type</b></em>' enumerators. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public static final List VALUES = Collections.unmodifiableList(Arrays.asList(VALUES_ARRAY));

	/**
	 * Returns the '<em><b>Word Width Type</b></em>' literal with the specified literal value.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public static WordWidthType get(String literal) {
		for (int i = 0; i < VALUES_ARRAY.length; ++i) {
			WordWidthType result = VALUES_ARRAY[i];
			if (result.toString().equals(literal)) {
				return result;
			}
		}
		return null;
	}

	/**
	 * Returns the '<em><b>Word Width Type</b></em>' literal with the specified name. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public static WordWidthType getByName(String name) {
		for (int i = 0; i < VALUES_ARRAY.length; ++i) {
			WordWidthType result = VALUES_ARRAY[i];
			if (result.getName().equals(name)) {
				return result;
			}
		}
		return null;
	}

	/**
	 * Returns the '<em><b>Word Width Type</b></em>' literal with the specified integer value.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public static WordWidthType get(int value) {
		switch (value) {
			case _31: return _31_LITERAL;
			case _32: return _32_LITERAL;
			case _64: return _64_LITERAL;
		}
		return null;
	}

	/**
	 * Only this class can construct instances.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	private WordWidthType(int value, String name, String literal) {
		super(value, name, literal);
	}

} //WordWidthType
