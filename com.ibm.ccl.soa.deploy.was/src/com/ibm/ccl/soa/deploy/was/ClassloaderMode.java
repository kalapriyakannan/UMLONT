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
 * <!-- begin-user-doc --> A representation of the literals of the enumeration '<em><b>Classloader Mode</b></em>',
 * and utility methods for working with them. <!-- end-user-doc --> <!-- begin-model-doc -->
 * 
 * Identifies the order in which a class loader attempts to load the classes it manages. A value of
 * "PARENT_FIRST" (default) means that the parent class loader is asked to attempt loading the class
 * first. A value of "PARENT_LAST" means that the class loader attempts to load the class before the
 * parent class loader.
 * 
 * <!-- end-model-doc -->
 * 
 * @see com.ibm.ccl.soa.deploy.was.WasPackage#getClassloaderMode()
 * @model
 * @generated
 */
public final class ClassloaderMode extends AbstractEnumerator {
	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public static final String copyright = "Copyright (c) 2005, 2006 IBM Corporation. Licensed Material - Property of IBM. All rights reserved."; //$NON-NLS-1$

	/**
	 * The '<em><b>PARENTFIRST</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>PARENTFIRST</b></em>' literal object isn't clear, there really
	 * should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #PARENTFIRST_LITERAL
	 * @model literal="PARENT_FIRST"
	 * @generated
	 * @ordered
	 */
	public static final int PARENTFIRST = 0;

	/**
	 * The '<em><b>PARENTLAST</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>PARENTLAST</b></em>' literal object isn't clear, there really
	 * should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #PARENTLAST_LITERAL
	 * @model literal="PARENT_LAST"
	 * @generated
	 * @ordered
	 */
	public static final int PARENTLAST = 1;

	/**
	 * The '<em><b>PARENTFIRST</b></em>' literal object.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @see #PARENTFIRST
	 * @generated
	 * @ordered
	 */
	public static final ClassloaderMode PARENTFIRST_LITERAL = new ClassloaderMode(PARENTFIRST, "PARENTFIRST", "PARENT_FIRST"); //$NON-NLS-1$ //$NON-NLS-2$

	/**
	 * The '<em><b>PARENTLAST</b></em>' literal object.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @see #PARENTLAST
	 * @generated
	 * @ordered
	 */
	public static final ClassloaderMode PARENTLAST_LITERAL = new ClassloaderMode(PARENTLAST, "PARENTLAST", "PARENT_LAST"); //$NON-NLS-1$ //$NON-NLS-2$

	/**
	 * An array of all the '<em><b>Classloader Mode</b></em>' enumerators.
	 * <!-- begin-user-doc
	 * --> <!-- end-user-doc -->
	 * @generated
	 */
	private static final ClassloaderMode[] VALUES_ARRAY = new ClassloaderMode[] {
			PARENTFIRST_LITERAL,
			PARENTLAST_LITERAL,
		};

	/**
	 * A public read-only list of all the '<em><b>Classloader Mode</b></em>' enumerators. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public static final List VALUES = Collections.unmodifiableList(Arrays.asList(VALUES_ARRAY));

	/**
	 * Returns the '<em><b>Classloader Mode</b></em>' literal with the specified literal value.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public static ClassloaderMode get(String literal) {
		for (int i = 0; i < VALUES_ARRAY.length; ++i) {
			ClassloaderMode result = VALUES_ARRAY[i];
			if (result.toString().equals(literal)) {
				return result;
			}
		}
		return null;
	}

	/**
	 * Returns the '<em><b>Classloader Mode</b></em>' literal with the specified name. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public static ClassloaderMode getByName(String name) {
		for (int i = 0; i < VALUES_ARRAY.length; ++i) {
			ClassloaderMode result = VALUES_ARRAY[i];
			if (result.getName().equals(name)) {
				return result;
			}
		}
		return null;
	}

	/**
	 * Returns the '<em><b>Classloader Mode</b></em>' literal with the specified integer value.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public static ClassloaderMode get(int value) {
		switch (value) {
			case PARENTFIRST: return PARENTFIRST_LITERAL;
			case PARENTLAST: return PARENTLAST_LITERAL;
		}
		return null;
	}

	/**
	 * Only this class can construct instances.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	private ClassloaderMode(int value, String name, String literal) {
		super(value, name, literal);
	}

} //ClassloaderMode
