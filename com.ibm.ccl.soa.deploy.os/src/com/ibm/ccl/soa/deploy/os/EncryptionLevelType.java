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
 * <!-- begin-user-doc --> A representation of the literals of the enumeration '<em><b>Encryption Level Type</b></em>',
 * and utility methods for working with them. <!-- end-user-doc -->
 * @see com.ibm.ccl.soa.deploy.os.OsPackage#getEncryptionLevelType()
 * @model extendedMetaData="name='EncryptionLevelType'"
 * @generated
 */
public final class EncryptionLevelType extends AbstractEnumerator {
	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public static final String copyright = "Copyright (c) 2005, 2006 IBM Corporation. Licensed Material - Property of IBM. All rights reserved."; //$NON-NLS-1$

	/**
	 * The '<em><b>40</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>40</b></em>' literal object isn't clear, there really should be
	 * more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #_40_LITERAL
	 * @model literal="40"
	 * @generated
	 * @ordered
	 */
	public static final int _40 = 0;

	/**
	 * The '<em><b>128</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>128</b></em>' literal object isn't clear, there really should
	 * be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #_128_LITERAL
	 * @model literal="128"
	 * @generated
	 * @ordered
	 */
	public static final int _128 = 1;

	/**
	 * The '<em><b>40</b></em>' literal object.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see #_40
	 * @generated
	 * @ordered
	 */
	public static final EncryptionLevelType _40_LITERAL = new EncryptionLevelType(_40, "_40", "40"); //$NON-NLS-1$ //$NON-NLS-2$

	/**
	 * The '<em><b>128</b></em>' literal object.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see #_128
	 * @generated
	 * @ordered
	 */
	public static final EncryptionLevelType _128_LITERAL = new EncryptionLevelType(_128,
			"_128", "128"); //$NON-NLS-1$ //$NON-NLS-2$

	/**
	 * An array of all the '<em><b>Encryption Level Type</b></em>' enumerators. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	private static final EncryptionLevelType[] VALUES_ARRAY = new EncryptionLevelType[] {
			_40_LITERAL, _128_LITERAL, };

	/**
	 * A public read-only list of all the '<em><b>Encryption Level Type</b></em>' enumerators.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public static final List VALUES = Collections.unmodifiableList(Arrays.asList(VALUES_ARRAY));

	/**
	 * Returns the '<em><b>Encryption Level Type</b></em>' literal with the specified literal value.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public static EncryptionLevelType get(String literal) {
		for (int i = 0; i < VALUES_ARRAY.length; ++i) {
			EncryptionLevelType result = VALUES_ARRAY[i];
			if (result.toString().equals(literal)) {
				return result;
			}
		}
		return null;
	}

	/**
	 * Returns the '<em><b>Encryption Level Type</b></em>' literal with the specified name. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public static EncryptionLevelType getByName(String name) {
		for (int i = 0; i < VALUES_ARRAY.length; ++i) {
			EncryptionLevelType result = VALUES_ARRAY[i];
			if (result.getName().equals(name)) {
				return result;
			}
		}
		return null;
	}

	/**
	 * Returns the '<em><b>Encryption Level Type</b></em>' literal with the specified integer value.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public static EncryptionLevelType get(int value) {
		switch (value)
		{
		case _40:
			return _40_LITERAL;
		case _128:
			return _128_LITERAL;
		}
		return null;
	}

	/**
	 * Only this class can construct instances.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	private EncryptionLevelType(int value, String name, String literal) {
		super(value, name, literal);
	}

} //EncryptionLevelType
