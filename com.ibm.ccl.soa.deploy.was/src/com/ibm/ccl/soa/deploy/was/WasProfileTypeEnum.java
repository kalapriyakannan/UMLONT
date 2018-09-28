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
 * <!-- begin-user-doc --> A representation of the literals of the enumeration '<em><b>Profile Type Enum</b></em>',
 * and utility methods for working with them. <!-- end-user-doc -->
 * @see com.ibm.ccl.soa.deploy.was.WasPackage#getWasProfileTypeEnum()
 * @model extendedMetaData="name='WasProfileTypeEnum'"
 * @generated
 */
public final class WasProfileTypeEnum extends AbstractEnumerator {
	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public static final String copyright = "Copyright (c) 2005, 2006 IBM Corporation. Licensed Material - Property of IBM. All rights reserved."; //$NON-NLS-1$

	/**
	 * The '<em><b>Dmgr</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>Dmgr</b></em>' literal object isn't clear, there really should
	 * be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #DMGR_LITERAL
	 * @model name="dmgr"
	 * @generated
	 * @ordered
	 */
	public static final int DMGR = 0;

	/**
	 * The '<em><b>Managed</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>Managed</b></em>' literal object isn't clear, there really
	 * should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #MANAGED_LITERAL
	 * @model name="managed"
	 * @generated
	 * @ordered
	 */
	public static final int MANAGED = 1;

	/**
	 * The '<em><b>Default</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>Default</b></em>' literal object isn't clear, there really
	 * should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #DEFAULT_LITERAL
	 * @model name="default"
	 * @generated
	 * @ordered
	 */
	public static final int DEFAULT = 2;

	/**
	 * The '<em><b>None</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>None</b></em>' literal object isn't clear, there really should
	 * be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #NONE_LITERAL
	 * @model name="none"
	 * @generated
	 * @ordered
	 */
	public static final int NONE = 3;

	/**
	 * The '<em><b>Dmgr</b></em>' literal object.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see #DMGR
	 * @generated
	 * @ordered
	 */
	public static final WasProfileTypeEnum DMGR_LITERAL = new WasProfileTypeEnum(DMGR, "dmgr", "dmgr"); //$NON-NLS-1$ //$NON-NLS-2$

	/**
	 * The '<em><b>Managed</b></em>' literal object. <!-- begin-user-doc --> <!-- end-user-doc
	 * -->
	 * 
	 * @see #MANAGED
	 * @generated
	 * @ordered
	 */
	public static final WasProfileTypeEnum MANAGED_LITERAL = new WasProfileTypeEnum(MANAGED, "managed", "managed"); //$NON-NLS-1$ //$NON-NLS-2$

	/**
	 * The '<em><b>Default</b></em>' literal object. <!-- begin-user-doc --> <!-- end-user-doc
	 * -->
	 * 
	 * @see #DEFAULT
	 * @generated
	 * @ordered
	 */
	public static final WasProfileTypeEnum DEFAULT_LITERAL = new WasProfileTypeEnum(DEFAULT, "default", "default"); //$NON-NLS-1$ //$NON-NLS-2$

	/**
	 * The '<em><b>None</b></em>' literal object.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see #NONE
	 * @generated
	 * @ordered
	 */
	public static final WasProfileTypeEnum NONE_LITERAL = new WasProfileTypeEnum(NONE, "none", "none"); //$NON-NLS-1$ //$NON-NLS-2$

	/**
	 * An array of all the '<em><b>Profile Type Enum</b></em>' enumerators.
	 * <!-- begin-user-doc
	 * --> <!-- end-user-doc -->
	 * @generated
	 */
	private static final WasProfileTypeEnum[] VALUES_ARRAY = new WasProfileTypeEnum[] {
			DMGR_LITERAL,
			MANAGED_LITERAL,
			DEFAULT_LITERAL,
			NONE_LITERAL,
		};

	/**
	 * A public read-only list of all the '<em><b>Profile Type Enum</b></em>' enumerators. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public static final List VALUES = Collections.unmodifiableList(Arrays.asList(VALUES_ARRAY));

	/**
	 * Returns the '<em><b>Profile Type Enum</b></em>' literal with the specified literal value.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public static WasProfileTypeEnum get(String literal) {
		for (int i = 0; i < VALUES_ARRAY.length; ++i) {
			WasProfileTypeEnum result = VALUES_ARRAY[i];
			if (result.toString().equals(literal)) {
				return result;
			}
		}
		return null;
	}

	/**
	 * Returns the '<em><b>Profile Type Enum</b></em>' literal with the specified name. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public static WasProfileTypeEnum getByName(String name) {
		for (int i = 0; i < VALUES_ARRAY.length; ++i) {
			WasProfileTypeEnum result = VALUES_ARRAY[i];
			if (result.getName().equals(name)) {
				return result;
			}
		}
		return null;
	}

	/**
	 * Returns the '<em><b>Profile Type Enum</b></em>' literal with the specified integer value.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public static WasProfileTypeEnum get(int value) {
		switch (value) {
			case DMGR: return DMGR_LITERAL;
			case MANAGED: return MANAGED_LITERAL;
			case DEFAULT: return DEFAULT_LITERAL;
			case NONE: return NONE_LITERAL;
		}
		return null;
	}

	/**
	 * Only this class can construct instances.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	private WasProfileTypeEnum(int value, String name, String literal) {
		super(value, name, literal);
	}

} //WasProfileTypeEnum
