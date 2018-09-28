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
 * <!-- begin-user-doc --> A representation of the literals of the enumeration '<em><b>Classloader Policy Type</b></em>',
 * and utility methods for working with them. <!-- end-user-doc --> <!-- begin-model-doc -->
 * 
 * Identifies the number of class loaders to be used: either one (SINGLE) or several (MULTIPLE).
 * Implication of the value depends on the scope of the class loader. If the class loader is an
 * application server class loader SINGLE means that all applications will share a single class
 * loader; MULTIPLE means there is a class loader for each application. For an application class
 * loader SINGLE means that all Web modules share the same class loader as for the Ejb modules and
 * Jar modules; MULTIPLE means that each Web module has its own class loader.
 * 
 * <!-- end-model-doc -->
 * 
 * @see com.ibm.ccl.soa.deploy.was.WasPackage#getClassloaderPolicyType()
 * @model
 * @generated
 */
public final class ClassloaderPolicyType extends AbstractEnumerator {
	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public static final String copyright = "Copyright (c) 2005, 2006 IBM Corporation. Licensed Material - Property of IBM. All rights reserved."; //$NON-NLS-1$

	/**
	 * The '<em><b>SINGLE</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>SINGLE</b></em>' literal object isn't clear, there really
	 * should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #SINGLE_LITERAL
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int SINGLE = 0;

	/**
	 * The '<em><b>MULTIPLE</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>MULTIPLE</b></em>' literal object isn't clear, there really
	 * should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #MULTIPLE_LITERAL
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int MULTIPLE = 1;

	/**
	 * The '<em><b>SINGLE</b></em>' literal object. <!-- begin-user-doc --> <!-- end-user-doc
	 * -->
	 * 
	 * @see #SINGLE
	 * @generated
	 * @ordered
	 */
	public static final ClassloaderPolicyType SINGLE_LITERAL = new ClassloaderPolicyType(SINGLE, "SINGLE", "SINGLE"); //$NON-NLS-1$ //$NON-NLS-2$

	/**
	 * The '<em><b>MULTIPLE</b></em>' literal object. <!-- begin-user-doc --> <!-- end-user-doc
	 * -->
	 * 
	 * @see #MULTIPLE
	 * @generated
	 * @ordered
	 */
	public static final ClassloaderPolicyType MULTIPLE_LITERAL = new ClassloaderPolicyType(MULTIPLE, "MULTIPLE", "MULTIPLE"); //$NON-NLS-1$ //$NON-NLS-2$

	/**
	 * An array of all the '<em><b>Classloader Policy Type</b></em>' enumerators. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	private static final ClassloaderPolicyType[] VALUES_ARRAY = new ClassloaderPolicyType[] {
			SINGLE_LITERAL,
			MULTIPLE_LITERAL,
		};

	/**
	 * A public read-only list of all the '<em><b>Classloader Policy Type</b></em>' enumerators.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public static final List VALUES = Collections.unmodifiableList(Arrays.asList(VALUES_ARRAY));

	/**
	 * Returns the '<em><b>Classloader Policy Type</b></em>' literal with the specified literal value.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public static ClassloaderPolicyType get(String literal) {
		for (int i = 0; i < VALUES_ARRAY.length; ++i) {
			ClassloaderPolicyType result = VALUES_ARRAY[i];
			if (result.toString().equals(literal)) {
				return result;
			}
		}
		return null;
	}

	/**
	 * Returns the '<em><b>Classloader Policy Type</b></em>' literal with the specified name.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public static ClassloaderPolicyType getByName(String name) {
		for (int i = 0; i < VALUES_ARRAY.length; ++i) {
			ClassloaderPolicyType result = VALUES_ARRAY[i];
			if (result.getName().equals(name)) {
				return result;
			}
		}
		return null;
	}

	/**
	 * Returns the '<em><b>Classloader Policy Type</b></em>' literal with the specified integer value.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public static ClassloaderPolicyType get(int value) {
		switch (value) {
			case SINGLE: return SINGLE_LITERAL;
			case MULTIPLE: return MULTIPLE_LITERAL;
		}
		return null;
	}

	/**
	 * Only this class can construct instances.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	private ClassloaderPolicyType(int value, String name, String literal) {
		super(value, name, literal);
	}

} //ClassloaderPolicyType
