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
 * <!-- begin-user-doc --> A representation of the literals of the enumeration '<em><b>Jdbc Implementation Type Type</b></em>',
 * and utility methods for working with them. <!-- end-user-doc -->
 * @see com.ibm.ccl.soa.deploy.was.WasPackage#getJdbcImplementationTypeType()
 * @model extendedMetaData="name='JdbcImplementationTypeType'"
 * @generated
 */
public final class JdbcImplementationTypeType extends AbstractEnumerator {
	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public static final String copyright = "Copyright (c) 2005, 2006 IBM Corporation. Licensed Material - Property of IBM. All rights reserved."; //$NON-NLS-1$

	/**
	 * The '<em><b>Connection Pool</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>Connection Pool</b></em>' literal object isn't clear, there
	 * really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #CONNECTION_POOL_LITERAL
	 * @model name="ConnectionPool"
	 * @generated
	 * @ordered
	 */
	public static final int CONNECTION_POOL = 0;

	/**
	 * The '<em><b>XA</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>XA</b></em>' literal object isn't clear, there really should be
	 * more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #XA_LITERAL
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int XA = 1;

	/**
	 * The '<em><b>Connection Pool</b></em>' literal object.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @see #CONNECTION_POOL
	 * @generated
	 * @ordered
	 */
	public static final JdbcImplementationTypeType CONNECTION_POOL_LITERAL = new JdbcImplementationTypeType(CONNECTION_POOL, "ConnectionPool", "ConnectionPool"); //$NON-NLS-1$ //$NON-NLS-2$

	/**
	 * The '<em><b>XA</b></em>' literal object.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see #XA
	 * @generated
	 * @ordered
	 */
	public static final JdbcImplementationTypeType XA_LITERAL = new JdbcImplementationTypeType(XA, "XA", "XA"); //$NON-NLS-1$ //$NON-NLS-2$

	/**
	 * An array of all the '<em><b>Jdbc Implementation Type Type</b></em>' enumerators. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	private static final JdbcImplementationTypeType[] VALUES_ARRAY = new JdbcImplementationTypeType[] {
			CONNECTION_POOL_LITERAL,
			XA_LITERAL,
		};

	/**
	 * A public read-only list of all the '<em><b>Jdbc Implementation Type Type</b></em>' enumerators.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public static final List VALUES = Collections.unmodifiableList(Arrays.asList(VALUES_ARRAY));

	/**
	 * Returns the '<em><b>Jdbc Implementation Type Type</b></em>' literal with the specified literal value.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public static JdbcImplementationTypeType get(String literal) {
		for (int i = 0; i < VALUES_ARRAY.length; ++i) {
			JdbcImplementationTypeType result = VALUES_ARRAY[i];
			if (result.toString().equals(literal)) {
				return result;
			}
		}
		return null;
	}

	/**
	 * Returns the '<em><b>Jdbc Implementation Type Type</b></em>' literal with the specified name.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public static JdbcImplementationTypeType getByName(String name) {
		for (int i = 0; i < VALUES_ARRAY.length; ++i) {
			JdbcImplementationTypeType result = VALUES_ARRAY[i];
			if (result.getName().equals(name)) {
				return result;
			}
		}
		return null;
	}

	/**
	 * Returns the '<em><b>Jdbc Implementation Type Type</b></em>' literal with the specified integer value.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public static JdbcImplementationTypeType get(int value) {
		switch (value) {
			case CONNECTION_POOL: return CONNECTION_POOL_LITERAL;
			case XA: return XA_LITERAL;
		}
		return null;
	}

	/**
	 * Only this class can construct instances.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	private JdbcImplementationTypeType(int value, String name, String literal) {
		super(value, name, literal);
	}

} //JdbcImplementationTypeType
