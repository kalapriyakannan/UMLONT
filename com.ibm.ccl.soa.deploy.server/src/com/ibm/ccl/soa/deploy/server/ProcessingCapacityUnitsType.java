/**
 * Copyright (c) 2005, 2006 IBM Corporation. Licensed Material - Property of IBM. All rights reserved.
 *
 * $Id: ProcessingCapacityUnitsType.java,v 1.2 2008/03/31 22:35:48 barnold Exp $
 */
package com.ibm.ccl.soa.deploy.server;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.eclipse.emf.common.util.AbstractEnumerator;

/**
 * <!-- begin-user-doc -->
 * A representation of the literals of the enumeration '<em><b>Processing Capacity Units Type</b></em>',
 * and utility methods for working with them.
 * <!-- end-user-doc -->
 * @see com.ibm.ccl.soa.deploy.server.ServerPackage#getProcessingCapacityUnitsType()
 * @model extendedMetaData="name='ProcessingCapacityUnitsType'"
 * @generated
 */
public final class ProcessingCapacityUnitsType extends AbstractEnumerator {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final String copyright = "Copyright (c) 2005, 2006 IBM Corporation. Licensed Material - Property of IBM. All rights reserved."; //$NON-NLS-1$

	/**
	 * The '<em><b>Unknown</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>Unknown</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #UNKNOWN_LITERAL
	 * @model name="Unknown"
	 * @generated
	 * @ordered
	 */
	public static final int UNKNOWN = 0;

	/**
	 * The '<em><b>Other</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>Other</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #OTHER_LITERAL
	 * @model name="Other"
	 * @generated
	 * @ordered
	 */
	public static final int OTHER = 1;

	/**
	 * The '<em><b>SPEC Int</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>SPEC Int</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #SPEC_INT_LITERAL
	 * @model name="SPECInt"
	 * @generated
	 * @ordered
	 */
	public static final int SPEC_INT = 2;

	/**
	 * The '<em><b>MSU</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>MSU</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #MSU_LITERAL
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int MSU = 3;

	/**
	 * The '<em><b>Unknown</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #UNKNOWN
	 * @generated
	 * @ordered
	 */
	public static final ProcessingCapacityUnitsType UNKNOWN_LITERAL = new ProcessingCapacityUnitsType(
			UNKNOWN, "Unknown", "Unknown"); //$NON-NLS-1$ //$NON-NLS-2$

	/**
	 * The '<em><b>Other</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #OTHER
	 * @generated
	 * @ordered
	 */
	public static final ProcessingCapacityUnitsType OTHER_LITERAL = new ProcessingCapacityUnitsType(
			OTHER, "Other", "Other"); //$NON-NLS-1$ //$NON-NLS-2$

	/**
	 * The '<em><b>SPEC Int</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #SPEC_INT
	 * @generated
	 * @ordered
	 */
	public static final ProcessingCapacityUnitsType SPEC_INT_LITERAL = new ProcessingCapacityUnitsType(
			SPEC_INT, "SPECInt", "SPECInt"); //$NON-NLS-1$ //$NON-NLS-2$

	/**
	 * The '<em><b>MSU</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #MSU
	 * @generated
	 * @ordered
	 */
	public static final ProcessingCapacityUnitsType MSU_LITERAL = new ProcessingCapacityUnitsType(
			MSU, "MSU", "MSU"); //$NON-NLS-1$ //$NON-NLS-2$

	/**
	 * An array of all the '<em><b>Processing Capacity Units Type</b></em>' enumerators.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private static final ProcessingCapacityUnitsType[] VALUES_ARRAY = new ProcessingCapacityUnitsType[] {
			UNKNOWN_LITERAL, OTHER_LITERAL, SPEC_INT_LITERAL, MSU_LITERAL, };

	/**
	 * A public read-only list of all the '<em><b>Processing Capacity Units Type</b></em>' enumerators.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final List VALUES = Collections.unmodifiableList(Arrays.asList(VALUES_ARRAY));

	/**
	 * Returns the '<em><b>Processing Capacity Units Type</b></em>' literal with the specified literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static ProcessingCapacityUnitsType get(String literal) {
		for (int i = 0; i < VALUES_ARRAY.length; ++i) {
			ProcessingCapacityUnitsType result = VALUES_ARRAY[i];
			if (result.toString().equals(literal)) {
				return result;
			}
		}
		return null;
	}

	/**
	 * Returns the '<em><b>Processing Capacity Units Type</b></em>' literal with the specified name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static ProcessingCapacityUnitsType getByName(String name) {
		for (int i = 0; i < VALUES_ARRAY.length; ++i) {
			ProcessingCapacityUnitsType result = VALUES_ARRAY[i];
			if (result.getName().equals(name)) {
				return result;
			}
		}
		return null;
	}

	/**
	 * Returns the '<em><b>Processing Capacity Units Type</b></em>' literal with the specified integer value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static ProcessingCapacityUnitsType get(int value) {
		switch (value)
		{
		case UNKNOWN:
			return UNKNOWN_LITERAL;
		case OTHER:
			return OTHER_LITERAL;
		case SPEC_INT:
			return SPEC_INT_LITERAL;
		case MSU:
			return MSU_LITERAL;
		}
		return null;
	}

	/**
	 * Only this class can construct instances.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private ProcessingCapacityUnitsType(int value, String name, String literal) {
		super(value, name, literal);
	}

} //ProcessingCapacityUnitsType
