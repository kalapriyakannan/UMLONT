/*******************************************************************************
 * Copyright (c) 2003, 2007 IBM Corporation Licensed Material - Property of IBM. All rights reserved.
 *  
 * US Government Users Restricted Rights - Use, duplication or disclosure v1.0 restricted by GSA ADP
 * Schedule Contract with IBM Corp.
 * 
 * Contributors: IBM Corporation - initial API and implementation
 *******************************************************************************/
package com.ibm.ccl.soa.deploy.java;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.eclipse.emf.common.util.AbstractEnumerator;

/**
 * <!-- begin-user-doc --> A representation of the literals of the enumeration '<em><b>Jdbc Type Type</b></em>',
 * and utility methods for working with them. <!-- end-user-doc --> <!-- begin-model-doc -->
 * 
 * Jdbc types
 * 
 * <!-- end-model-doc -->
 * 
 * @see com.ibm.ccl.soa.deploy.java.JavaPackage#getJdbcTypeType()
 * @model
 * @generated
 */
public final class JdbcTypeType extends AbstractEnumerator {
	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public static final String copyright = "Copyright (c) 2005, 2006 IBM Corporation. Licensed Material - Property of IBM. All rights reserved."; //$NON-NLS-1$

	/**
	 * The '<em><b>1</b></em>' literal value. <!-- begin-user-doc --> <!-- end-user-doc --> <!--
	 * begin-model-doc --> JDBC Type 1 <!-- end-model-doc -->
	 * 
	 * @see #_1_LITERAL
	 * @model literal="1"
	 * @generated
	 * @ordered
	 */
	public static final int _1 = 0;

	/**
	 * The '<em><b>2</b></em>' literal value. <!-- begin-user-doc --> <!-- end-user-doc --> <!--
	 * begin-model-doc --> JDBC Type 2 <!-- end-model-doc -->
	 * 
	 * @see #_2_LITERAL
	 * @model literal="2"
	 * @generated
	 * @ordered
	 */
	public static final int _2 = 1;

	/**
	 * The '<em><b>3</b></em>' literal value. <!-- begin-user-doc --> <!-- end-user-doc --> <!--
	 * begin-model-doc --> JDBC Type 3 <!-- end-model-doc -->
	 * 
	 * @see #_3_LITERAL
	 * @model literal="3"
	 * @generated
	 * @ordered
	 */
	public static final int _3 = 2;

	/**
	 * The '<em><b>4</b></em>' literal value. <!-- begin-user-doc --> <!-- end-user-doc --> <!--
	 * begin-model-doc --> JDBC Type 4 <!-- end-model-doc -->
	 * 
	 * @see #_4_LITERAL
	 * @model literal="4"
	 * @generated
	 * @ordered
	 */
	public static final int _4 = 3;

	/**
	 * The '<em><b>1</b></em>' literal object.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see #_1
	 * @generated
	 * @ordered
	 */
	public static final JdbcTypeType _1_LITERAL = new JdbcTypeType(_1, "_1", "1"); //$NON-NLS-1$ //$NON-NLS-2$

	/**
	 * The '<em><b>2</b></em>' literal object.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see #_2
	 * @generated
	 * @ordered
	 */
	public static final JdbcTypeType _2_LITERAL = new JdbcTypeType(_2, "_2", "2"); //$NON-NLS-1$ //$NON-NLS-2$

	/**
	 * The '<em><b>3</b></em>' literal object.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see #_3
	 * @generated
	 * @ordered
	 */
	public static final JdbcTypeType _3_LITERAL = new JdbcTypeType(_3, "_3", "3"); //$NON-NLS-1$ //$NON-NLS-2$

	/**
	 * The '<em><b>4</b></em>' literal object.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see #_4
	 * @generated
	 * @ordered
	 */
	public static final JdbcTypeType _4_LITERAL = new JdbcTypeType(_4, "_4", "4"); //$NON-NLS-1$ //$NON-NLS-2$

	/**
	 * An array of all the '<em><b>Jdbc Type Type</b></em>' enumerators.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private static final JdbcTypeType[] VALUES_ARRAY = new JdbcTypeType[] {
			_1_LITERAL,
			_2_LITERAL,
			_3_LITERAL,
			_4_LITERAL,
		};

	/**
	 * A public read-only list of all the '<em><b>Jdbc Type Type</b></em>' enumerators. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public static final List VALUES = Collections.unmodifiableList(Arrays.asList(VALUES_ARRAY));

	/**
	 * Returns the '<em><b>Jdbc Type Type</b></em>' literal with the specified literal value.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public static JdbcTypeType get(String literal) {
		for (int i = 0; i < VALUES_ARRAY.length; ++i) {
			JdbcTypeType result = VALUES_ARRAY[i];
			if (result.toString().equals(literal)) {
				return result;
			}
		}
		return null;
	}

	/**
	 * Returns the '<em><b>Jdbc Type Type</b></em>' literal with the specified name. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public static JdbcTypeType getByName(String name) {
		for (int i = 0; i < VALUES_ARRAY.length; ++i) {
			JdbcTypeType result = VALUES_ARRAY[i];
			if (result.getName().equals(name)) {
				return result;
			}
		}
		return null;
	}

	/**
	 * Returns the '<em><b>Jdbc Type Type</b></em>' literal with the specified integer value.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public static JdbcTypeType get(int value) {
		switch (value) {
			case _1: return _1_LITERAL;
			case _2: return _2_LITERAL;
			case _3: return _3_LITERAL;
			case _4: return _4_LITERAL;
		}
		return null;
	}

	/**
	 * Only this class can construct instances.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	private JdbcTypeType(int value, String name, String literal) {
		super(value, name, literal);
	}

} //JdbcTypeType
