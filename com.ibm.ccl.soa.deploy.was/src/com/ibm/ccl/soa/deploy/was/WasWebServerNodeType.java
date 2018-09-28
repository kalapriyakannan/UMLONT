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
 * <!-- begin-user-doc --> A representation of the literals of the enumeration '<em><b>Web Server Node Type</b></em>',
 * and utility methods for working with them. <!-- end-user-doc --> <!-- begin-model-doc -->
 * 
 * 
 * <!-- end-model-doc -->
 * 
 * @see com.ibm.ccl.soa.deploy.was.WasPackage#getWasWebServerNodeType()
 * @model
 * @generated
 */
public final class WasWebServerNodeType extends AbstractEnumerator {
	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public static final String copyright = "Copyright (c) 2005, 2006 IBM Corporation. Licensed Material - Property of IBM. All rights reserved."; //$NON-NLS-1$

	/**
	 * The '<em><b>MANAGED</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>MANAGED</b></em>' literal object isn't clear, there really
	 * should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #MANAGED_LITERAL
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int MANAGED = 0;

	/**
	 * The '<em><b>UNMANAGED</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>UNMANAGED</b></em>' literal object isn't clear, there really
	 * should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #UNMANAGED_LITERAL
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int UNMANAGED = 1;

	/**
	 * The '<em><b>MANAGED</b></em>' literal object. <!-- begin-user-doc --> <!-- end-user-doc
	 * -->
	 * 
	 * @see #MANAGED
	 * @generated
	 * @ordered
	 */
	public static final WasWebServerNodeType MANAGED_LITERAL = new WasWebServerNodeType(MANAGED, "MANAGED", "MANAGED"); //$NON-NLS-1$ //$NON-NLS-2$

	/**
	 * The '<em><b>UNMANAGED</b></em>' literal object. <!-- begin-user-doc --> <!-- end-user-doc
	 * -->
	 * 
	 * @see #UNMANAGED
	 * @generated
	 * @ordered
	 */
	public static final WasWebServerNodeType UNMANAGED_LITERAL = new WasWebServerNodeType(UNMANAGED, "UNMANAGED", "UNMANAGED"); //$NON-NLS-1$ //$NON-NLS-2$

	/**
	 * An array of all the '<em><b>Web Server Node Type</b></em>' enumerators. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	private static final WasWebServerNodeType[] VALUES_ARRAY = new WasWebServerNodeType[] {
			MANAGED_LITERAL,
			UNMANAGED_LITERAL,
		};

	/**
	 * A public read-only list of all the '<em><b>Web Server Node Type</b></em>' enumerators.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public static final List VALUES = Collections.unmodifiableList(Arrays.asList(VALUES_ARRAY));

	/**
	 * Returns the '<em><b>Web Server Node Type</b></em>' literal with the specified literal value.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public static WasWebServerNodeType get(String literal) {
		for (int i = 0; i < VALUES_ARRAY.length; ++i) {
			WasWebServerNodeType result = VALUES_ARRAY[i];
			if (result.toString().equals(literal)) {
				return result;
			}
		}
		return null;
	}

	/**
	 * Returns the '<em><b>Web Server Node Type</b></em>' literal with the specified name. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public static WasWebServerNodeType getByName(String name) {
		for (int i = 0; i < VALUES_ARRAY.length; ++i) {
			WasWebServerNodeType result = VALUES_ARRAY[i];
			if (result.getName().equals(name)) {
				return result;
			}
		}
		return null;
	}

	/**
	 * Returns the '<em><b>Web Server Node Type</b></em>' literal with the specified integer value.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public static WasWebServerNodeType get(int value) {
		switch (value) {
			case MANAGED: return MANAGED_LITERAL;
			case UNMANAGED: return UNMANAGED_LITERAL;
		}
		return null;
	}

	/**
	 * Only this class can construct instances.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	private WasWebServerNodeType(int value, String name, String literal) {
		super(value, name, literal);
	}

} //WasWebServerNodeType
