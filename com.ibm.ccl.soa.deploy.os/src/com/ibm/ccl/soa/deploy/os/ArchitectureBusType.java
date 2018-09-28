/*******************************************************************************
 * Copyright (c) 2003, 2007 IBM Corporation Licensed Material - Property of IBM. All rights reserved.
 *  
 * US Government Users Restricted Rights - Use, duplication or disclosure v1.0 restricted by GSA ADP
 * Schedule Contract with IBM Corp.
 * 
 * Contributors: IBM Corporation - initial API and implementation
 *******************************************************************************/
package com.ibm.ccl.soa.deploy.os;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.eclipse.emf.common.util.AbstractEnumerator;

/**
 * <!-- begin-user-doc --> A representation of the literals of the enumeration '<em><b>Architecture Bus Type</b></em>',
 * and utility methods for working with them. <!-- end-user-doc -->
 * @see com.ibm.ccl.soa.deploy.os.OsPackage#getArchitectureBusType()
 * @model extendedMetaData="name='ArchitectureBusType'"
 * @generated
 */
public final class ArchitectureBusType extends AbstractEnumerator {
	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public static final String copyright = "Copyright (c) 2005, 2006 IBM Corporation. Licensed Material - Property of IBM. All rights reserved."; //$NON-NLS-1$

	/**
	 * The '<em><b>32 Bit</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>32 Bit</b></em>' literal object isn't clear, there really
	 * should be more of a description here...
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
	 * If the meaning of '<em><b>64 Bit</b></em>' literal object isn't clear, there really
	 * should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #_64_BIT_LITERAL
	 * @model name="_64Bit" literal="64-bit"
	 * @generated
	 * @ordered
	 */
	public static final int _64_BIT = 1;

	/**
	 * The '<em><b>32 Bit</b></em>' literal object. <!-- begin-user-doc --> <!-- end-user-doc
	 * -->
	 * 
	 * @see #_32_BIT
	 * @generated
	 * @ordered
	 */
	public static final ArchitectureBusType _32_BIT_LITERAL = new ArchitectureBusType(_32_BIT,
			"_32Bit", "32-bit"); //$NON-NLS-1$ //$NON-NLS-2$

	/**
	 * The '<em><b>64 Bit</b></em>' literal object. <!-- begin-user-doc --> <!-- end-user-doc
	 * -->
	 * 
	 * @see #_64_BIT
	 * @generated
	 * @ordered
	 */
	public static final ArchitectureBusType _64_BIT_LITERAL = new ArchitectureBusType(_64_BIT,
			"_64Bit", "64-bit"); //$NON-NLS-1$ //$NON-NLS-2$

	/**
	 * An array of all the '<em><b>Architecture Bus Type</b></em>' enumerators. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	private static final ArchitectureBusType[] VALUES_ARRAY = new ArchitectureBusType[] {
			_32_BIT_LITERAL, _64_BIT_LITERAL, };

	/**
	 * A public read-only list of all the '<em><b>Architecture Bus Type</b></em>' enumerators.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public static final List VALUES = Collections.unmodifiableList(Arrays.asList(VALUES_ARRAY));

	/**
	 * Returns the '<em><b>Architecture Bus Type</b></em>' literal with the specified literal value.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public static ArchitectureBusType get(String literal) {
		for (int i = 0; i < VALUES_ARRAY.length; ++i) {
			ArchitectureBusType result = VALUES_ARRAY[i];
			if (result.toString().equals(literal)) {
				return result;
			}
		}
		return null;
	}

	/**
	 * Returns the '<em><b>Architecture Bus Type</b></em>' literal with the specified name. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public static ArchitectureBusType getByName(String name) {
		for (int i = 0; i < VALUES_ARRAY.length; ++i) {
			ArchitectureBusType result = VALUES_ARRAY[i];
			if (result.getName().equals(name)) {
				return result;
			}
		}
		return null;
	}

	/**
	 * Returns the '<em><b>Architecture Bus Type</b></em>' literal with the specified integer value.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public static ArchitectureBusType get(int value) {
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
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	private ArchitectureBusType(int value, String name, String literal) {
		super(value, name, literal);
	}

} //ArchitectureBusType
