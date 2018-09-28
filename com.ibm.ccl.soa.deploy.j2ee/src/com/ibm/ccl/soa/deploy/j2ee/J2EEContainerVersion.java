/*******************************************************************************
 * Copyright (c) 2003, 2007 IBM Corporation Licensed Material - Property of IBM. All rights reserved.
 *  
 * US Government Users Restricted Rights - Use, duplication or disclosure v1.0 restricted by GSA ADP
 * Schedule Contract with IBM Corp.
 * 
 * Contributors: IBM Corporation - initial API and implementation
 *******************************************************************************/
package com.ibm.ccl.soa.deploy.j2ee;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.eclipse.emf.common.util.AbstractEnumerator;

/**
 * <!-- begin-user-doc --> A representation of the literals of the enumeration '<em><b>J2EE Container Version</b></em>',
 * and utility methods for working with them. <!-- end-user-doc -->
 * @see com.ibm.ccl.soa.deploy.j2ee.J2eePackage#getJ2EEContainerVersion()
 * @model extendedMetaData="name='J2EEContainerVersion'"
 * @generated
 */
public final class J2EEContainerVersion extends AbstractEnumerator {
	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public static final String copyright = "Copyright (c) 2005, 2006 IBM Corporation. Licensed Material - Property of IBM. All rights reserved."; //$NON-NLS-1$

	/**
	 * The '<em><b>12</b></em>' literal value. <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>12</b></em>' literal object isn't clear, there really should be
	 * more of a description here...
	 * </p>
	 * <!-- end-user-doc --> <!-- begin-model-doc --> J2EE 1.2 <!-- end-model-doc -->
	 * 
	 * @see #_12_LITERAL
	 * @model literal="1.2"
	 * @generated
	 * @ordered
	 */
	public static final int _12 = 0;

	/**
	 * The '<em><b>13</b></em>' literal value. <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>13</b></em>' literal object isn't clear, there really should be
	 * more of a description here...
	 * </p>
	 * <!-- end-user-doc --> <!-- begin-model-doc --> J2EE 1.3 <!-- end-model-doc -->
	 * 
	 * @see #_13_LITERAL
	 * @model literal="1.3"
	 * @generated
	 * @ordered
	 */
	public static final int _13 = 1;

	/**
	 * The '<em><b>14</b></em>' literal value. <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>14</b></em>' literal object isn't clear, there really should be
	 * more of a description here...
	 * </p>
	 * <!-- end-user-doc --> <!-- begin-model-doc --> J2EE 1.4 <!-- end-model-doc -->
	 * 
	 * @see #_14_LITERAL
	 * @model literal="1.4"
	 * @generated
	 * @ordered
	 */
	public static final int _14 = 2;

	/**
	 * The '<em><b>50</b></em>' literal value.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * Java EE 5.0
	 * <!-- end-model-doc -->
	 * @see #_50_LITERAL
	 * @model literal="5.0"
	 * @generated
	 * @ordered
	 */
	public static final int _50 = 3;

	/**
	 * The '<em><b>12</b></em>' literal object.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see #_12
	 * @generated
	 * @ordered
	 */
	public static final J2EEContainerVersion _12_LITERAL = new J2EEContainerVersion(_12,
			"_12", "1.2"); //$NON-NLS-1$ //$NON-NLS-2$

	/**
	 * The '<em><b>13</b></em>' literal object.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see #_13
	 * @generated
	 * @ordered
	 */
	public static final J2EEContainerVersion _13_LITERAL = new J2EEContainerVersion(_13,
			"_13", "1.3"); //$NON-NLS-1$ //$NON-NLS-2$

	/**
	 * The '<em><b>14</b></em>' literal object.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see #_14
	 * @generated
	 * @ordered
	 */
	public static final J2EEContainerVersion _14_LITERAL = new J2EEContainerVersion(_14,
			"_14", "1.4"); //$NON-NLS-1$ //$NON-NLS-2$

	/**
	 * The '<em><b>50</b></em>' literal object.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see #_50
	 * @generated
	 * @ordered
	 */
	public static final J2EEContainerVersion _50_LITERAL = new J2EEContainerVersion(_50,
			"_50", "5.0"); //$NON-NLS-1$ //$NON-NLS-2$

	/**
	 * An array of all the '<em><b>J2EE Container Version</b></em>' enumerators. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	private static final J2EEContainerVersion[] VALUES_ARRAY = new J2EEContainerVersion[] {
			_12_LITERAL, _13_LITERAL, _14_LITERAL, _50_LITERAL, };

	/**
	 * A public read-only list of all the '<em><b>J2EE Container Version</b></em>' enumerators.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public static final List VALUES = Collections.unmodifiableList(Arrays.asList(VALUES_ARRAY));

	/**
	 * Returns the '<em><b>J2EE Container Version</b></em>' literal with the specified literal value.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public static J2EEContainerVersion get(String literal) {
		for (int i = 0; i < VALUES_ARRAY.length; ++i) {
			J2EEContainerVersion result = VALUES_ARRAY[i];
			if (result.toString().equals(literal)) {
				return result;
			}
		}
		return null;
	}

	/**
	 * Returns the '<em><b>J2EE Container Version</b></em>' literal with the specified name.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public static J2EEContainerVersion getByName(String name) {
		for (int i = 0; i < VALUES_ARRAY.length; ++i) {
			J2EEContainerVersion result = VALUES_ARRAY[i];
			if (result.getName().equals(name)) {
				return result;
			}
		}
		return null;
	}

	/**
	 * Returns the '<em><b>J2EE Container Version</b></em>' literal with the specified integer value.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public static J2EEContainerVersion get(int value) {
		switch (value)
		{
		case _12:
			return _12_LITERAL;
		case _13:
			return _13_LITERAL;
		case _14:
			return _14_LITERAL;
		case _50:
			return _50_LITERAL;
		}
		return null;
	}

	/**
	 * Only this class can construct instances.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	private J2EEContainerVersion(int value, String name, String literal) {
		super(value, name, literal);
	}

} //J2EEContainerVersion
