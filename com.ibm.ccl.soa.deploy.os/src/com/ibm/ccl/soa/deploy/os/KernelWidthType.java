/**
 * Copyright (c) 2005, 2006 IBM Corporation. Licensed Material - Property of IBM. All rights reserved.
 *
 * $Id: KernelWidthType.java,v 1.1 2008/02/02 05:54:51 barnold Exp $
 */
package com.ibm.ccl.soa.deploy.os;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.eclipse.emf.common.util.AbstractEnumerator;

/**
 * <!-- begin-user-doc -->
 * A representation of the literals of the enumeration '<em><b>Kernel Width Type</b></em>',
 * and utility methods for working with them.
 * <!-- end-user-doc -->
 * @see com.ibm.ccl.soa.deploy.os.OsPackage#getKernelWidthType()
 * @model extendedMetaData="name='KernelWidthType'"
 * @generated
 */
public final class KernelWidthType extends AbstractEnumerator {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final String copyright = "Copyright (c) 2005, 2006 IBM Corporation. Licensed Material - Property of IBM. All rights reserved."; //$NON-NLS-1$

	/**
	 * The '<em><b>32 Bit</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>32 Bit</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #_32_BIT_LITERAL
	 * @model name="_32Bit" literal="32-bit"
	 * @generated
	 * @ordered
	 */
	public static final int _32_BIT = 0;

	/**
	 * The '<em><b>64 Bit</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>64 Bit</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #_64_BIT_LITERAL
	 * @model name="_64Bit" literal="64-bit"
	 * @generated
	 * @ordered
	 */
	public static final int _64_BIT = 1;

	/**
	 * The '<em><b>32 Bit</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #_32_BIT
	 * @generated
	 * @ordered
	 */
	public static final KernelWidthType _32_BIT_LITERAL = new KernelWidthType(_32_BIT,
			"_32Bit", "32-bit"); //$NON-NLS-1$ //$NON-NLS-2$

	/**
	 * The '<em><b>64 Bit</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #_64_BIT
	 * @generated
	 * @ordered
	 */
	public static final KernelWidthType _64_BIT_LITERAL = new KernelWidthType(_64_BIT,
			"_64Bit", "64-bit"); //$NON-NLS-1$ //$NON-NLS-2$

	/**
	 * An array of all the '<em><b>Kernel Width Type</b></em>' enumerators.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private static final KernelWidthType[] VALUES_ARRAY = new KernelWidthType[] { _32_BIT_LITERAL,
			_64_BIT_LITERAL, };

	/**
	 * A public read-only list of all the '<em><b>Kernel Width Type</b></em>' enumerators.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final List VALUES = Collections.unmodifiableList(Arrays.asList(VALUES_ARRAY));

	/**
	 * Returns the '<em><b>Kernel Width Type</b></em>' literal with the specified literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static KernelWidthType get(String literal) {
		for (int i = 0; i < VALUES_ARRAY.length; ++i) {
			KernelWidthType result = VALUES_ARRAY[i];
			if (result.toString().equals(literal)) {
				return result;
			}
		}
		return null;
	}

	/**
	 * Returns the '<em><b>Kernel Width Type</b></em>' literal with the specified name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static KernelWidthType getByName(String name) {
		for (int i = 0; i < VALUES_ARRAY.length; ++i) {
			KernelWidthType result = VALUES_ARRAY[i];
			if (result.getName().equals(name)) {
				return result;
			}
		}
		return null;
	}

	/**
	 * Returns the '<em><b>Kernel Width Type</b></em>' literal with the specified integer value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static KernelWidthType get(int value) {
		switch (value)
		{
		case _32_BIT:
			return _32_BIT_LITERAL;
		case _64_BIT:
			return _64_BIT_LITERAL;
		}
		return null;
	}

	/**
	 * Only this class can construct instances.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private KernelWidthType(int value, String name, String literal) {
		super(value, name, literal);
	}

} //KernelWidthType
