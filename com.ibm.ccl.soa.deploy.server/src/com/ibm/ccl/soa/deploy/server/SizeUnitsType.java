/**
 * Copyright (c) 2005, 2006 IBM Corporation. Licensed Material - Property of IBM. All rights reserved.
 *
 * $Id: SizeUnitsType.java,v 1.1 2008/03/31 22:35:48 barnold Exp $
 */
package com.ibm.ccl.soa.deploy.server;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.eclipse.emf.common.util.AbstractEnumerator;

/**
 * <!-- begin-user-doc -->
 * A representation of the literals of the enumeration '<em><b>Size Units Type</b></em>',
 * and utility methods for working with them.
 * <!-- end-user-doc -->
 * @see com.ibm.ccl.soa.deploy.server.ServerPackage#getSizeUnitsType()
 * @model extendedMetaData="name='SizeUnitsType'"
 * @generated
 */
public final class SizeUnitsType extends AbstractEnumerator {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final String copyright = "Copyright (c) 2005, 2006 IBM Corporation. Licensed Material - Property of IBM. All rights reserved."; //$NON-NLS-1$

	/**
	 * The '<em><b>KB</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>KB</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #KB_LITERAL
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int KB = 0;

	/**
	 * The '<em><b>MB</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>MB</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #MB_LITERAL
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int MB = 1;

	/**
	 * The '<em><b>GB</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>GB</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #GB_LITERAL
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int GB = 2;

	/**
	 * The '<em><b>TB</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>TB</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #TB_LITERAL
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int TB = 3;

	/**
	 * The '<em><b>KB</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #KB
	 * @generated
	 * @ordered
	 */
	public static final SizeUnitsType KB_LITERAL = new SizeUnitsType(KB, "KB", "KB"); //$NON-NLS-1$ //$NON-NLS-2$

	/**
	 * The '<em><b>MB</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #MB
	 * @generated
	 * @ordered
	 */
	public static final SizeUnitsType MB_LITERAL = new SizeUnitsType(MB, "MB", "MB"); //$NON-NLS-1$ //$NON-NLS-2$

	/**
	 * The '<em><b>GB</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #GB
	 * @generated
	 * @ordered
	 */
	public static final SizeUnitsType GB_LITERAL = new SizeUnitsType(GB, "GB", "GB"); //$NON-NLS-1$ //$NON-NLS-2$

	/**
	 * The '<em><b>TB</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #TB
	 * @generated
	 * @ordered
	 */
	public static final SizeUnitsType TB_LITERAL = new SizeUnitsType(TB, "TB", "TB"); //$NON-NLS-1$ //$NON-NLS-2$

	/**
	 * An array of all the '<em><b>Size Units Type</b></em>' enumerators.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private static final SizeUnitsType[] VALUES_ARRAY = new SizeUnitsType[] { KB_LITERAL,
			MB_LITERAL, GB_LITERAL, TB_LITERAL, };

	/**
	 * A public read-only list of all the '<em><b>Size Units Type</b></em>' enumerators.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final List VALUES = Collections.unmodifiableList(Arrays.asList(VALUES_ARRAY));

	/**
	 * Returns the '<em><b>Size Units Type</b></em>' literal with the specified literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static SizeUnitsType get(String literal) {
		for (int i = 0; i < VALUES_ARRAY.length; ++i) {
			SizeUnitsType result = VALUES_ARRAY[i];
			if (result.toString().equals(literal)) {
				return result;
			}
		}
		return null;
	}

	/**
	 * Returns the '<em><b>Size Units Type</b></em>' literal with the specified name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static SizeUnitsType getByName(String name) {
		for (int i = 0; i < VALUES_ARRAY.length; ++i) {
			SizeUnitsType result = VALUES_ARRAY[i];
			if (result.getName().equals(name)) {
				return result;
			}
		}
		return null;
	}

	/**
	 * Returns the '<em><b>Size Units Type</b></em>' literal with the specified integer value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static SizeUnitsType get(int value) {
		switch (value)
		{
		case KB:
			return KB_LITERAL;
		case MB:
			return MB_LITERAL;
		case GB:
			return GB_LITERAL;
		case TB:
			return TB_LITERAL;
		}
		return null;
	}

	/**
	 * Only this class can construct instances.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private SizeUnitsType(int value, String name, String literal) {
		super(value, name, literal);
	}

} //SizeUnitsType
