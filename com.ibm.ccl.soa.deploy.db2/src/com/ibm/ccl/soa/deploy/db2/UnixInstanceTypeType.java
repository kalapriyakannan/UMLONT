/*******************************************************************************
 * Copyright (c) 2003, 2007 IBM Corporation Licensed Material - Property of IBM. All rights reserved.
 *  
 * US Government Users Restricted Rights - Use, duplication or disclosure v1.0 restricted by GSA ADP
 * Schedule Contract with IBM Corp.
 * 
 * Contributors: IBM Corporation - initial API and implementation
 *******************************************************************************/
package com.ibm.ccl.soa.deploy.db2;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.eclipse.emf.common.util.AbstractEnumerator;

/**
 * <!-- begin-user-doc --> A representation of the literals of the enumeration '<em><b>Unix Instance Type Type</b></em>',
 * and utility methods for working with them. <!-- end-user-doc --> <!-- begin-model-doc -->
 * 
 * This type defines the instance types for a unix or windows db2 install.
 * 
 * <!-- end-model-doc -->
 * 
 * @see com.ibm.ccl.soa.deploy.db2.Db2Package#getUnixInstanceTypeType()
 * @model
 * @generated
 */
public final class UnixInstanceTypeType extends AbstractEnumerator {
	/**
	 * The '<em><b>Client</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>Client</b></em>' literal object isn't clear, there really
	 * should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #CLIENT_LITERAL
	 * @model name="Client"
	 * @generated
	 * @ordered
	 */
	public static final int CLIENT = 0;

	/**
	 * The '<em><b>ESE</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>ESE</b></em>' literal object isn't clear, there really should
	 * be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #ESE_LITERAL
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int ESE = 1;

	/**
	 * The '<em><b>WSE</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>WSE</b></em>' literal object isn't clear, there really should
	 * be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #WSE_LITERAL
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int WSE = 2;

	/**
	 * The '<em><b>Client</b></em>' literal object. <!-- begin-user-doc --> <!-- end-user-doc
	 * -->
	 * 
	 * @see #CLIENT
	 * @generated
	 * @ordered
	 */
	public static final UnixInstanceTypeType CLIENT_LITERAL = new UnixInstanceTypeType(CLIENT, "Client", "Client"); //$NON-NLS-1$ //$NON-NLS-2$

	/**
	 * The '<em><b>ESE</b></em>' literal object.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see #ESE
	 * @generated
	 * @ordered
	 */
	public static final UnixInstanceTypeType ESE_LITERAL = new UnixInstanceTypeType(ESE, "ESE", "ESE"); //$NON-NLS-1$ //$NON-NLS-2$

	/**
	 * The '<em><b>WSE</b></em>' literal object.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see #WSE
	 * @generated
	 * @ordered
	 */
	public static final UnixInstanceTypeType WSE_LITERAL = new UnixInstanceTypeType(WSE, "WSE", "WSE"); //$NON-NLS-1$ //$NON-NLS-2$

	/**
	 * An array of all the '<em><b>Unix Instance Type Type</b></em>' enumerators. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	private static final UnixInstanceTypeType[] VALUES_ARRAY = new UnixInstanceTypeType[] {
			CLIENT_LITERAL,
			ESE_LITERAL,
			WSE_LITERAL,
		};

	/**
	 * A public read-only list of all the '<em><b>Unix Instance Type Type</b></em>' enumerators.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public static final List VALUES = Collections.unmodifiableList(Arrays.asList(VALUES_ARRAY));

	/**
	 * Returns the '<em><b>Unix Instance Type Type</b></em>' literal with the specified literal
	 * value. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated NOT
	 */
	public static UnixInstanceTypeType get(String literal) {
		for (int i = 0; i < VALUES_ARRAY.length; ++i) {
			UnixInstanceTypeType result = VALUES_ARRAY[i];
			if (result.toString().equalsIgnoreCase(literal)) {
				return result;
			}
		}
		return null;
	}

	/**
	 * Returns the '<em><b>Unix Instance Type Type</b></em>' literal with the specified name.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated NOT
	 */
	public static UnixInstanceTypeType getByName(String name) {
		for (int i = 0; i < VALUES_ARRAY.length; ++i) {
			UnixInstanceTypeType result = VALUES_ARRAY[i];
			if (result.getName().equalsIgnoreCase(name)) {
				return result;
			}
		}
		return null;
	}

	/**
	 * Returns the '<em><b>Unix Instance Type Type</b></em>' literal with the specified integer value.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public static UnixInstanceTypeType get(int value) {
		switch (value) {
			case CLIENT: return CLIENT_LITERAL;
			case ESE: return ESE_LITERAL;
			case WSE: return WSE_LITERAL;
		}
		return null;
	}

	/**
	 * Only this class can construct instances.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	private UnixInstanceTypeType(int value, String name, String literal) {
		super(value, name, literal);
	}

} //UnixInstanceTypeType
