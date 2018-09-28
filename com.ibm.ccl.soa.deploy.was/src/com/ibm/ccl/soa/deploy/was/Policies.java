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
 * <!-- begin-user-doc --> A representation of the literals of the enumeration '<em><b>Policies</b></em>',
 * and utility methods for working with them. <!-- end-user-doc -->
 * @see com.ibm.ccl.soa.deploy.was.WasPackage#getPolicies()
 * @model extendedMetaData="name='Policies'"
 * @generated
 */
public final class Policies extends AbstractEnumerator {
	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public static final String copyright = "Copyright (c) 2005, 2006 IBM Corporation. Licensed Material - Property of IBM. All rights reserved."; //$NON-NLS-1$

	/**
	 * The '<em><b>Entire Pool</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>Entire Pool</b></em>' literal object isn't clear, there really
	 * should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #ENTIRE_POOL_LITERAL
	 * @model name="EntirePool"
	 * @generated
	 * @ordered
	 */
	public static final int ENTIRE_POOL = 0;

	/**
	 * The '<em><b>Failing Connection Only</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>Failing Connection Only</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #FAILING_CONNECTION_ONLY_LITERAL
	 * @model name="FailingConnectionOnly"
	 * @generated
	 * @ordered
	 */
	public static final int FAILING_CONNECTION_ONLY = 1;

	/**
	 * The '<em><b>Entire Pool</b></em>' literal object.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @see #ENTIRE_POOL
	 * @generated
	 * @ordered
	 */
	public static final Policies ENTIRE_POOL_LITERAL = new Policies(ENTIRE_POOL, "EntirePool", "EntirePool"); //$NON-NLS-1$ //$NON-NLS-2$

	/**
	 * The '<em><b>Failing Connection Only</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #FAILING_CONNECTION_ONLY
	 * @generated
	 * @ordered
	 */
	public static final Policies FAILING_CONNECTION_ONLY_LITERAL = new Policies(FAILING_CONNECTION_ONLY, "FailingConnectionOnly", "FailingConnectionOnly"); //$NON-NLS-1$ //$NON-NLS-2$

	/**
	 * An array of all the '<em><b>Policies</b></em>' enumerators.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @generated
	 */
	private static final Policies[] VALUES_ARRAY = new Policies[] {
			ENTIRE_POOL_LITERAL,
			FAILING_CONNECTION_ONLY_LITERAL,
		};

	/**
	 * A public read-only list of all the '<em><b>Policies</b></em>' enumerators. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public static final List VALUES = Collections.unmodifiableList(Arrays.asList(VALUES_ARRAY));

	/**
	 * Returns the '<em><b>Policies</b></em>' literal with the specified literal value. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public static Policies get(String literal) {
		for (int i = 0; i < VALUES_ARRAY.length; ++i) {
			Policies result = VALUES_ARRAY[i];
			if (result.toString().equals(literal)) {
				return result;
			}
		}
		return null;
	}

	/**
	 * Returns the '<em><b>Policies</b></em>' literal with the specified name. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public static Policies getByName(String name) {
		for (int i = 0; i < VALUES_ARRAY.length; ++i) {
			Policies result = VALUES_ARRAY[i];
			if (result.getName().equals(name)) {
				return result;
			}
		}
		return null;
	}

	/**
	 * Returns the '<em><b>Policies</b></em>' literal with the specified integer value. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public static Policies get(int value) {
		switch (value) {
			case ENTIRE_POOL: return ENTIRE_POOL_LITERAL;
			case FAILING_CONNECTION_ONLY: return FAILING_CONNECTION_ONLY_LITERAL;
		}
		return null;
	}

	/**
	 * Only this class can construct instances.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	private Policies(int value, String name, String literal) {
		super(value, name, literal);
	}

} //Policies
