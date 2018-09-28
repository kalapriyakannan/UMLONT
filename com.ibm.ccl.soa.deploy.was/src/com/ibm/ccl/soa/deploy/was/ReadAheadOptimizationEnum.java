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
 * <!-- begin-user-doc --> A representation of the literals of the enumeration '<em><b>Read Ahead Optimization Enum</b></em>',
 * and utility methods for working with them. <!-- end-user-doc -->
 * @see com.ibm.ccl.soa.deploy.was.WasPackage#getReadAheadOptimizationEnum()
 * @model extendedMetaData="name='ReadAheadOptimizationEnum'"
 * @generated
 */
public final class ReadAheadOptimizationEnum extends AbstractEnumerator {
	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public static final String copyright = "Copyright (c) 2005, 2006 IBM Corporation. Licensed Material - Property of IBM. All rights reserved."; //$NON-NLS-1$

	/**
	 * The '<em><b>Default</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>Default</b></em>' literal object isn't clear, there really
	 * should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #DEFAULT_LITERAL
	 * @model name="Default"
	 * @generated
	 * @ordered
	 */
	public static final int DEFAULT = 0;

	/**
	 * The '<em><b>Always On</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>Always On</b></em>' literal object isn't clear, there really
	 * should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #ALWAYS_ON_LITERAL
	 * @model name="AlwaysOn"
	 * @generated
	 * @ordered
	 */
	public static final int ALWAYS_ON = 1;

	/**
	 * The '<em><b>Always Off</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>Always Off</b></em>' literal object isn't clear, there really
	 * should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #ALWAYS_OFF_LITERAL
	 * @model name="AlwaysOff"
	 * @generated
	 * @ordered
	 */
	public static final int ALWAYS_OFF = 2;

	/**
	 * The '<em><b>Default</b></em>' literal object. <!-- begin-user-doc --> <!-- end-user-doc
	 * -->
	 * 
	 * @see #DEFAULT
	 * @generated
	 * @ordered
	 */
	public static final ReadAheadOptimizationEnum DEFAULT_LITERAL = new ReadAheadOptimizationEnum(DEFAULT, "Default", "Default"); //$NON-NLS-1$ //$NON-NLS-2$

	/**
	 * The '<em><b>Always On</b></em>' literal object. <!-- begin-user-doc --> <!-- end-user-doc
	 * -->
	 * 
	 * @see #ALWAYS_ON
	 * @generated
	 * @ordered
	 */
	public static final ReadAheadOptimizationEnum ALWAYS_ON_LITERAL = new ReadAheadOptimizationEnum(ALWAYS_ON, "AlwaysOn", "AlwaysOn"); //$NON-NLS-1$ //$NON-NLS-2$

	/**
	 * The '<em><b>Always Off</b></em>' literal object.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @see #ALWAYS_OFF
	 * @generated
	 * @ordered
	 */
	public static final ReadAheadOptimizationEnum ALWAYS_OFF_LITERAL = new ReadAheadOptimizationEnum(ALWAYS_OFF, "AlwaysOff", "AlwaysOff"); //$NON-NLS-1$ //$NON-NLS-2$

	/**
	 * An array of all the '<em><b>Read Ahead Optimization Enum</b></em>' enumerators. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	private static final ReadAheadOptimizationEnum[] VALUES_ARRAY = new ReadAheadOptimizationEnum[] {
			DEFAULT_LITERAL,
			ALWAYS_ON_LITERAL,
			ALWAYS_OFF_LITERAL,
		};

	/**
	 * A public read-only list of all the '<em><b>Read Ahead Optimization Enum</b></em>' enumerators.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public static final List VALUES = Collections.unmodifiableList(Arrays.asList(VALUES_ARRAY));

	/**
	 * Returns the '<em><b>Read Ahead Optimization Enum</b></em>' literal with the specified literal value.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public static ReadAheadOptimizationEnum get(String literal) {
		for (int i = 0; i < VALUES_ARRAY.length; ++i) {
			ReadAheadOptimizationEnum result = VALUES_ARRAY[i];
			if (result.toString().equals(literal)) {
				return result;
			}
		}
		return null;
	}

	/**
	 * Returns the '<em><b>Read Ahead Optimization Enum</b></em>' literal with the specified name.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public static ReadAheadOptimizationEnum getByName(String name) {
		for (int i = 0; i < VALUES_ARRAY.length; ++i) {
			ReadAheadOptimizationEnum result = VALUES_ARRAY[i];
			if (result.getName().equals(name)) {
				return result;
			}
		}
		return null;
	}

	/**
	 * Returns the '<em><b>Read Ahead Optimization Enum</b></em>' literal with the specified integer value.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public static ReadAheadOptimizationEnum get(int value) {
		switch (value) {
			case DEFAULT: return DEFAULT_LITERAL;
			case ALWAYS_ON: return ALWAYS_ON_LITERAL;
			case ALWAYS_OFF: return ALWAYS_OFF_LITERAL;
		}
		return null;
	}

	/**
	 * Only this class can construct instances.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	private ReadAheadOptimizationEnum(int value, String name, String literal) {
		super(value, name, literal);
	}

} //ReadAheadOptimizationEnum
