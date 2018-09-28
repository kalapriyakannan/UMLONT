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
 * <!-- begin-user-doc --> A representation of the literals of the enumeration '<em><b>JCA Container Version</b></em>',
 * and utility methods for working with them. <!-- end-user-doc -->
 * @see com.ibm.ccl.soa.deploy.j2ee.J2eePackage#getJCAContainerVersion()
 * @model extendedMetaData="name='JCAContainerVersion'"
 * @generated
 */
public final class JCAContainerVersion extends AbstractEnumerator {
	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public static final String copyright = "Copyright (c) 2005, 2006 IBM Corporation. Licensed Material - Property of IBM. All rights reserved."; //$NON-NLS-1$

	/**
	 * The '<em><b>10</b></em>' literal value. <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>10</b></em>' literal object isn't clear, there really should be
	 * more of a description here...
	 * </p>
	 * <!-- end-user-doc --> <!-- begin-model-doc --> J2EE 1.3 <!-- end-model-doc -->
	 * 
	 * @see #_10_LITERAL
	 * @model literal="1.0"
	 * @generated
	 * @ordered
	 */
	public static final int _10 = 0;

	/**
	 * The '<em><b>15</b></em>' literal value.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * J2EE 1.4
	 * <!-- end-model-doc -->
	 * @see #_15_LITERAL
	 * @model literal="1.5"
	 * @generated
	 * @ordered
	 */
	public static final int _15 = 1;

	/**
	 * The '<em><b>10</b></em>' literal object.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see #_10
	 * @generated
	 * @ordered
	 */
	public static final JCAContainerVersion _10_LITERAL = new JCAContainerVersion(_10, "_10", "1.0"); //$NON-NLS-1$ //$NON-NLS-2$

	/**
	 * The '<em><b>15</b></em>' literal object.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see #_15
	 * @generated
	 * @ordered
	 */
	public static final JCAContainerVersion _15_LITERAL = new JCAContainerVersion(_15, "_15", "1.5"); //$NON-NLS-1$ //$NON-NLS-2$

	/**
	 * An array of all the '<em><b>JCA Container Version</b></em>' enumerators. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	private static final JCAContainerVersion[] VALUES_ARRAY = new JCAContainerVersion[] {
			_10_LITERAL, _15_LITERAL, };

	/**
	 * A public read-only list of all the '<em><b>JCA Container Version</b></em>' enumerators.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public static final List VALUES = Collections.unmodifiableList(Arrays.asList(VALUES_ARRAY));

	/**
	 * Returns the '<em><b>JCA Container Version</b></em>' literal with the specified literal value.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public static JCAContainerVersion get(String literal) {
		for (int i = 0; i < VALUES_ARRAY.length; ++i) {
			JCAContainerVersion result = VALUES_ARRAY[i];
			if (result.toString().equals(literal)) {
				return result;
			}
		}
		return null;
	}

	/**
	 * Returns the '<em><b>JCA Container Version</b></em>' literal with the specified name. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public static JCAContainerVersion getByName(String name) {
		for (int i = 0; i < VALUES_ARRAY.length; ++i) {
			JCAContainerVersion result = VALUES_ARRAY[i];
			if (result.getName().equals(name)) {
				return result;
			}
		}
		return null;
	}

	/**
	 * Returns the '<em><b>JCA Container Version</b></em>' literal with the specified integer value.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public static JCAContainerVersion get(int value) {
		switch (value)
		{
		case _10:
			return _10_LITERAL;
		case _15:
			return _15_LITERAL;
		}
		return null;
	}

	/**
	 * Only this class can construct instances.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	private JCAContainerVersion(int value, String name, String literal) {
		super(value, name, literal);
	}

} //JCAContainerVersion
