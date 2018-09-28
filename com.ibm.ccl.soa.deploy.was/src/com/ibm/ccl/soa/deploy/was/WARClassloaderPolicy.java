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
 * <!-- begin-user-doc --> A representation of the literals of the enumeration '<em><b>WAR Classloader Policy</b></em>',
 * and utility methods for working with them. <!-- end-user-doc -->
 * @see com.ibm.ccl.soa.deploy.was.WasPackage#getWARClassloaderPolicy()
 * @model extendedMetaData="name='WARClassloaderPolicy'"
 * @generated
 */
public final class WARClassloaderPolicy extends AbstractEnumerator {
	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public static final String copyright = "Copyright (c) 2005, 2006 IBM Corporation. Licensed Material - Property of IBM. All rights reserved."; //$NON-NLS-1$

	/**
	 * The '<em><b>MODULE</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>MODULE</b></em>' literal object isn't clear, there really
	 * should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #MODULE_LITERAL
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int MODULE = 0;

	/**
	 * The '<em><b>APPLICATION</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>APPLICATION</b></em>' literal object isn't clear, there really
	 * should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #APPLICATION_LITERAL
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int APPLICATION = 1;

	/**
	 * The '<em><b>MODULE</b></em>' literal object. <!-- begin-user-doc --> <!-- end-user-doc
	 * -->
	 * 
	 * @see #MODULE
	 * @generated
	 * @ordered
	 */
	public static final WARClassloaderPolicy MODULE_LITERAL = new WARClassloaderPolicy(MODULE, "MODULE", "MODULE"); //$NON-NLS-1$ //$NON-NLS-2$

	/**
	 * The '<em><b>APPLICATION</b></em>' literal object.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @see #APPLICATION
	 * @generated
	 * @ordered
	 */
	public static final WARClassloaderPolicy APPLICATION_LITERAL = new WARClassloaderPolicy(APPLICATION, "APPLICATION", "APPLICATION"); //$NON-NLS-1$ //$NON-NLS-2$

	/**
	 * An array of all the '<em><b>WAR Classloader Policy</b></em>' enumerators. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	private static final WARClassloaderPolicy[] VALUES_ARRAY = new WARClassloaderPolicy[] {
			MODULE_LITERAL,
			APPLICATION_LITERAL,
		};

	/**
	 * A public read-only list of all the '<em><b>WAR Classloader Policy</b></em>' enumerators.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public static final List VALUES = Collections.unmodifiableList(Arrays.asList(VALUES_ARRAY));

	/**
	 * Returns the '<em><b>WAR Classloader Policy</b></em>' literal with the specified literal value.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public static WARClassloaderPolicy get(String literal) {
		for (int i = 0; i < VALUES_ARRAY.length; ++i) {
			WARClassloaderPolicy result = VALUES_ARRAY[i];
			if (result.toString().equals(literal)) {
				return result;
			}
		}
		return null;
	}

	/**
	 * Returns the '<em><b>WAR Classloader Policy</b></em>' literal with the specified name.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public static WARClassloaderPolicy getByName(String name) {
		for (int i = 0; i < VALUES_ARRAY.length; ++i) {
			WARClassloaderPolicy result = VALUES_ARRAY[i];
			if (result.getName().equals(name)) {
				return result;
			}
		}
		return null;
	}

	/**
	 * Returns the '<em><b>WAR Classloader Policy</b></em>' literal with the specified integer value.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public static WARClassloaderPolicy get(int value) {
		switch (value) {
			case MODULE: return MODULE_LITERAL;
			case APPLICATION: return APPLICATION_LITERAL;
		}
		return null;
	}

	/**
	 * Only this class can construct instances.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	private WARClassloaderPolicy(int value, String name, String literal) {
		super(value, name, literal);
	}

} //WARClassloaderPolicy
