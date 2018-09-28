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
 * <!-- begin-user-doc --> A representation of the literals of the enumeration '<em><b>Windows Service Error Control Type</b></em>',
 * and utility methods for working with them. <!-- end-user-doc -->
 * @see com.ibm.ccl.soa.deploy.os.OsPackage#getWindowsServiceErrorControlType()
 * @model extendedMetaData="name='WindowsServiceErrorControlType'"
 * @generated
 */
public final class WindowsServiceErrorControlType extends AbstractEnumerator {
	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public static final String copyright = "Copyright (c) 2005, 2006 IBM Corporation. Licensed Material - Property of IBM. All rights reserved."; //$NON-NLS-1$

	/**
	 * The '<em><b>Ignore</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>Ignore</b></em>' literal object isn't clear, there really
	 * should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #IGNORE_LITERAL
	 * @model name="Ignore"
	 * @generated
	 * @ordered
	 */
	public static final int IGNORE = 0;

	/**
	 * The '<em><b>Normal</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>Normal</b></em>' literal object isn't clear, there really
	 * should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #NORMAL_LITERAL
	 * @model name="Normal"
	 * @generated
	 * @ordered
	 */
	public static final int NORMAL = 1;

	/**
	 * The '<em><b>Severe</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>Severe</b></em>' literal object isn't clear, there really
	 * should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #SEVERE_LITERAL
	 * @model name="Severe"
	 * @generated
	 * @ordered
	 */
	public static final int SEVERE = 2;

	/**
	 * The '<em><b>Critical</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>Critical</b></em>' literal object isn't clear, there really
	 * should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #CRITICAL_LITERAL
	 * @model name="Critical"
	 * @generated
	 * @ordered
	 */
	public static final int CRITICAL = 3;

	/**
	 * The '<em><b>Unknown</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>Unknown</b></em>' literal object isn't clear, there really
	 * should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #UNKNOWN_LITERAL
	 * @model name="Unknown"
	 * @generated
	 * @ordered
	 */
	public static final int UNKNOWN = 4;

	/**
	 * The '<em><b>Ignore</b></em>' literal object. <!-- begin-user-doc --> <!-- end-user-doc
	 * -->
	 * 
	 * @see #IGNORE
	 * @generated
	 * @ordered
	 */
	public static final WindowsServiceErrorControlType IGNORE_LITERAL = new WindowsServiceErrorControlType(
			IGNORE, "Ignore", "Ignore"); //$NON-NLS-1$ //$NON-NLS-2$

	/**
	 * The '<em><b>Normal</b></em>' literal object. <!-- begin-user-doc --> <!-- end-user-doc
	 * -->
	 * 
	 * @see #NORMAL
	 * @generated
	 * @ordered
	 */
	public static final WindowsServiceErrorControlType NORMAL_LITERAL = new WindowsServiceErrorControlType(
			NORMAL, "Normal", "Normal"); //$NON-NLS-1$ //$NON-NLS-2$

	/**
	 * The '<em><b>Severe</b></em>' literal object. <!-- begin-user-doc --> <!-- end-user-doc
	 * -->
	 * 
	 * @see #SEVERE
	 * @generated
	 * @ordered
	 */
	public static final WindowsServiceErrorControlType SEVERE_LITERAL = new WindowsServiceErrorControlType(
			SEVERE, "Severe", "Severe"); //$NON-NLS-1$ //$NON-NLS-2$

	/**
	 * The '<em><b>Critical</b></em>' literal object. <!-- begin-user-doc --> <!-- end-user-doc
	 * -->
	 * 
	 * @see #CRITICAL
	 * @generated
	 * @ordered
	 */
	public static final WindowsServiceErrorControlType CRITICAL_LITERAL = new WindowsServiceErrorControlType(
			CRITICAL, "Critical", "Critical"); //$NON-NLS-1$ //$NON-NLS-2$

	/**
	 * The '<em><b>Unknown</b></em>' literal object. <!-- begin-user-doc --> <!-- end-user-doc
	 * -->
	 * 
	 * @see #UNKNOWN
	 * @generated
	 * @ordered
	 */
	public static final WindowsServiceErrorControlType UNKNOWN_LITERAL = new WindowsServiceErrorControlType(
			UNKNOWN, "Unknown", "Unknown"); //$NON-NLS-1$ //$NON-NLS-2$

	/**
	 * An array of all the '<em><b>Windows Service Error Control Type</b></em>' enumerators.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	private static final WindowsServiceErrorControlType[] VALUES_ARRAY = new WindowsServiceErrorControlType[] {
			IGNORE_LITERAL, NORMAL_LITERAL, SEVERE_LITERAL, CRITICAL_LITERAL, UNKNOWN_LITERAL, };

	/**
	 * A public read-only list of all the '<em><b>Windows Service Error Control Type</b></em>' enumerators.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public static final List VALUES = Collections.unmodifiableList(Arrays.asList(VALUES_ARRAY));

	/**
	 * Returns the '<em><b>Windows Service Error Control Type</b></em>' literal with the specified literal value.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public static WindowsServiceErrorControlType get(String literal) {
		for (int i = 0; i < VALUES_ARRAY.length; ++i) {
			WindowsServiceErrorControlType result = VALUES_ARRAY[i];
			if (result.toString().equals(literal)) {
				return result;
			}
		}
		return null;
	}

	/**
	 * Returns the '<em><b>Windows Service Error Control Type</b></em>' literal with the specified name.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public static WindowsServiceErrorControlType getByName(String name) {
		for (int i = 0; i < VALUES_ARRAY.length; ++i) {
			WindowsServiceErrorControlType result = VALUES_ARRAY[i];
			if (result.getName().equals(name)) {
				return result;
			}
		}
		return null;
	}

	/**
	 * Returns the '<em><b>Windows Service Error Control Type</b></em>' literal with the specified integer value.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public static WindowsServiceErrorControlType get(int value) {
		switch (value)
		{
		case IGNORE:
			return IGNORE_LITERAL;
		case NORMAL:
			return NORMAL_LITERAL;
		case SEVERE:
			return SEVERE_LITERAL;
		case CRITICAL:
			return CRITICAL_LITERAL;
		case UNKNOWN:
			return UNKNOWN_LITERAL;
		}
		return null;
	}

	/**
	 * Only this class can construct instances.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	private WindowsServiceErrorControlType(int value, String name, String literal) {
		super(value, name, literal);
	}

} //WindowsServiceErrorControlType
