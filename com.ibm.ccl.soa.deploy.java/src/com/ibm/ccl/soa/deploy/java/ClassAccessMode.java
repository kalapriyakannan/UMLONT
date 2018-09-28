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
 * <!-- begin-user-doc --> A representation of the literals of the enumeration '<em><b>Class Access Mode</b></em>',
 * and utility methods for working with them. <!-- end-user-doc -->
 * @see com.ibm.ccl.soa.deploy.java.JavaPackage#getClassAccessMode()
 * @model extendedMetaData="name='ClassAccessMode'"
 * @generated
 */
public final class ClassAccessMode extends AbstractEnumerator {
	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public static final String copyright = "Copyright (c) 2005, 2006 IBM Corporation. Licensed Material - Property of IBM. All rights reserved."; //$NON-NLS-1$

	/**
	 * The '<em><b>Allow</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>Allow</b></em>' literal object isn't clear, there really should
	 * be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #ALLOW_LITERAL
	 * @model name="Allow"
	 * @generated
	 * @ordered
	 */
	public static final int ALLOW = 0;

	/**
	 * The '<em><b>Restrict</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>Restrict</b></em>' literal object isn't clear, there really
	 * should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #RESTRICT_LITERAL
	 * @model name="Restrict"
	 * @generated
	 * @ordered
	 */
	public static final int RESTRICT = 1;

	/**
	 * The '<em><b>Allow</b></em>' literal object.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see #ALLOW
	 * @generated
	 * @ordered
	 */
	public static final ClassAccessMode ALLOW_LITERAL = new ClassAccessMode(ALLOW, "Allow", "Allow"); //$NON-NLS-1$ //$NON-NLS-2$

	/**
	 * The '<em><b>Restrict</b></em>' literal object. <!-- begin-user-doc --> <!-- end-user-doc
	 * -->
	 * 
	 * @see #RESTRICT
	 * @generated
	 * @ordered
	 */
	public static final ClassAccessMode RESTRICT_LITERAL = new ClassAccessMode(RESTRICT, "Restrict", "Restrict"); //$NON-NLS-1$ //$NON-NLS-2$

	/**
	 * An array of all the '<em><b>Class Access Mode</b></em>' enumerators.
	 * <!-- begin-user-doc
	 * --> <!-- end-user-doc -->
	 * @generated
	 */
	private static final ClassAccessMode[] VALUES_ARRAY = new ClassAccessMode[] {
			ALLOW_LITERAL,
			RESTRICT_LITERAL,
		};

	/**
	 * A public read-only list of all the '<em><b>Class Access Mode</b></em>' enumerators. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public static final List VALUES = Collections.unmodifiableList(Arrays.asList(VALUES_ARRAY));

	/**
	 * Returns the '<em><b>Class Access Mode</b></em>' literal with the specified literal value.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public static ClassAccessMode get(String literal) {
		for (int i = 0; i < VALUES_ARRAY.length; ++i) {
			ClassAccessMode result = VALUES_ARRAY[i];
			if (result.toString().equals(literal)) {
				return result;
			}
		}
		return null;
	}

	/**
	 * Returns the '<em><b>Class Access Mode</b></em>' literal with the specified name. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public static ClassAccessMode getByName(String name) {
		for (int i = 0; i < VALUES_ARRAY.length; ++i) {
			ClassAccessMode result = VALUES_ARRAY[i];
			if (result.getName().equals(name)) {
				return result;
			}
		}
		return null;
	}

	/**
	 * Returns the '<em><b>Class Access Mode</b></em>' literal with the specified integer value.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public static ClassAccessMode get(int value) {
		switch (value) {
			case ALLOW: return ALLOW_LITERAL;
			case RESTRICT: return RESTRICT_LITERAL;
		}
		return null;
	}

	/**
	 * Only this class can construct instances.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	private ClassAccessMode(int value, String name, String literal) {
		super(value, name, literal);
	}

} //ClassAccessMode
