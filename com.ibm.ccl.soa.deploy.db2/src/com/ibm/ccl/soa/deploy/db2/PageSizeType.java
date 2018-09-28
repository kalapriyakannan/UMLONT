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
 * <!-- begin-user-doc --> A representation of the literals of the enumeration '<em><b>Page Size Type</b></em>',
 * and utility methods for working with them. <!-- end-user-doc --> <!-- begin-model-doc -->
 * 
 * This type defines the page sizes allowed for DB2 database
 * 
 * <!-- end-model-doc -->
 * 
 * @see com.ibm.ccl.soa.deploy.db2.Db2Package#getPageSizeType()
 * @model
 * @generated
 */
public final class PageSizeType extends AbstractEnumerator {
	/**
	 * The '<em><b>4096</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>4096</b></em>' literal object isn't clear, there really should
	 * be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #_4096_LITERAL
	 * @model literal="4096"
	 * @generated
	 * @ordered
	 */
	public static final int _4096 = 0;

	/**
	 * The '<em><b>8192</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>8192</b></em>' literal object isn't clear, there really should
	 * be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #_8192_LITERAL
	 * @model literal="8192"
	 * @generated
	 * @ordered
	 */
	public static final int _8192 = 1;

	/**
	 * The '<em><b>16384</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>16384</b></em>' literal object isn't clear, there really should
	 * be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #_16384_LITERAL
	 * @model literal="16384"
	 * @generated
	 * @ordered
	 */
	public static final int _16384 = 2;

	/**
	 * The '<em><b>32768</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>32768</b></em>' literal object isn't clear, there really should
	 * be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #_32768_LITERAL
	 * @model literal="32768"
	 * @generated
	 * @ordered
	 */
	public static final int _32768 = 3;

	/**
	 * The '<em><b>4096</b></em>' literal object.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see #_4096
	 * @generated
	 * @ordered
	 */
	public static final PageSizeType _4096_LITERAL = new PageSizeType(_4096, "_4096", "4096"); //$NON-NLS-1$ //$NON-NLS-2$

	/**
	 * The '<em><b>8192</b></em>' literal object.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see #_8192
	 * @generated
	 * @ordered
	 */
	public static final PageSizeType _8192_LITERAL = new PageSizeType(_8192, "_8192", "8192"); //$NON-NLS-1$ //$NON-NLS-2$

	/**
	 * The '<em><b>16384</b></em>' literal object.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see #_16384
	 * @generated
	 * @ordered
	 */
	public static final PageSizeType _16384_LITERAL = new PageSizeType(_16384, "_16384", "16384"); //$NON-NLS-1$ //$NON-NLS-2$

	/**
	 * The '<em><b>32768</b></em>' literal object.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see #_32768
	 * @generated
	 * @ordered
	 */
	public static final PageSizeType _32768_LITERAL = new PageSizeType(_32768, "_32768", "32768"); //$NON-NLS-1$ //$NON-NLS-2$

	/**
	 * An array of all the '<em><b>Page Size Type</b></em>' enumerators.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private static final PageSizeType[] VALUES_ARRAY = new PageSizeType[] {
			_4096_LITERAL,
			_8192_LITERAL,
			_16384_LITERAL,
			_32768_LITERAL,
		};

	/**
	 * A public read-only list of all the '<em><b>Page Size Type</b></em>' enumerators. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public static final List VALUES = Collections.unmodifiableList(Arrays.asList(VALUES_ARRAY));

	/**
	 * Returns the '<em><b>Page Size Type</b></em>' literal with the specified literal value.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public static PageSizeType get(String literal) {
		for (int i = 0; i < VALUES_ARRAY.length; ++i) {
			PageSizeType result = VALUES_ARRAY[i];
			if (result.toString().equals(literal)) {
				return result;
			}
		}
		return null;
	}

	/**
	 * Returns the '<em><b>Page Size Type</b></em>' literal with the specified name. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public static PageSizeType getByName(String name) {
		for (int i = 0; i < VALUES_ARRAY.length; ++i) {
			PageSizeType result = VALUES_ARRAY[i];
			if (result.getName().equals(name)) {
				return result;
			}
		}
		return null;
	}

	/**
	 * Returns the '<em><b>Page Size Type</b></em>' literal with the specified integer value.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public static PageSizeType get(int value) {
		switch (value) {
			case _4096: return _4096_LITERAL;
			case _8192: return _8192_LITERAL;
			case _16384: return _16384_LITERAL;
			case _32768: return _32768_LITERAL;
		}
		return null;
	}

	/**
	 * Only this class can construct instances.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	private PageSizeType(int value, String name, String literal) {
		super(value, name, literal);
	}

} //PageSizeType
