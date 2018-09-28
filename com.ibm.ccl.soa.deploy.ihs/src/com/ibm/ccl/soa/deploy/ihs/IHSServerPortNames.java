/*******************************************************************************
 * Copyright (c) 2003, 2007 IBM Corporation Licensed Material - Property of IBM. All rights reserved.
 *  
 * US Government Users Restricted Rights - Use, duplication or disclosure v1.0 restricted by GSA ADP
 * Schedule Contract with IBM Corp.
 * 
 * Contributors: IBM Corporation - initial API and implementation
 *******************************************************************************/
package com.ibm.ccl.soa.deploy.ihs;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.eclipse.emf.common.util.AbstractEnumerator;

/**
 * <!-- begin-user-doc --> A representation of the literals of the enumeration '<em><b>IHS Server Port Names</b></em>',
 * and utility methods for working with them. <!-- end-user-doc --> <!-- begin-model-doc -->
 * 
 * 
 * <!-- end-model-doc -->
 * 
 * @see com.ibm.ccl.soa.deploy.ihs.IhsPackage#getIHSServerPortNames()
 * @model
 * @generated
 */
public final class IHSServerPortNames extends AbstractEnumerator {
	/**
	 * The '<em><b>Http Port</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>Http Port</b></em>' literal object isn't clear, there really
	 * should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #HTTP_PORT_LITERAL
	 * @model name="httpPort"
	 * @generated
	 * @ordered
	 */
	public static final int HTTP_PORT = 0;

	/**
	 * The '<em><b>Admin Port</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>Admin Port</b></em>' literal object isn't clear, there really
	 * should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #ADMIN_PORT_LITERAL
	 * @model name="adminPort"
	 * @generated
	 * @ordered
	 */
	public static final int ADMIN_PORT = 1;

	/**
	 * The '<em><b>Http Port</b></em>' literal object. <!-- begin-user-doc --> <!-- end-user-doc
	 * -->
	 * 
	 * @see #HTTP_PORT
	 * @generated
	 * @ordered
	 */
	public static final IHSServerPortNames HTTP_PORT_LITERAL = new IHSServerPortNames(HTTP_PORT, "httpPort", "httpPort"); //$NON-NLS-1$ //$NON-NLS-2$

	/**
	 * The '<em><b>Admin Port</b></em>' literal object.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @see #ADMIN_PORT
	 * @generated
	 * @ordered
	 */
	public static final IHSServerPortNames ADMIN_PORT_LITERAL = new IHSServerPortNames(ADMIN_PORT, "adminPort", "adminPort"); //$NON-NLS-1$ //$NON-NLS-2$

	/**
	 * An array of all the '<em><b>IHS Server Port Names</b></em>' enumerators. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	private static final IHSServerPortNames[] VALUES_ARRAY = new IHSServerPortNames[] {
			HTTP_PORT_LITERAL,
			ADMIN_PORT_LITERAL,
		};

	/**
	 * A public read-only list of all the '<em><b>IHS Server Port Names</b></em>' enumerators.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public static final List VALUES = Collections.unmodifiableList(Arrays.asList(VALUES_ARRAY));

	/**
	 * Returns the '<em><b>IHS Server Port Names</b></em>' literal with the specified literal value.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public static IHSServerPortNames get(String literal) {
		for (int i = 0; i < VALUES_ARRAY.length; ++i) {
			IHSServerPortNames result = VALUES_ARRAY[i];
			if (result.toString().equals(literal)) {
				return result;
			}
		}
		return null;
	}

	/**
	 * Returns the '<em><b>IHS Server Port Names</b></em>' literal with the specified name. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public static IHSServerPortNames getByName(String name) {
		for (int i = 0; i < VALUES_ARRAY.length; ++i) {
			IHSServerPortNames result = VALUES_ARRAY[i];
			if (result.getName().equals(name)) {
				return result;
			}
		}
		return null;
	}

	/**
	 * Returns the '<em><b>IHS Server Port Names</b></em>' literal with the specified integer value.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public static IHSServerPortNames get(int value) {
		switch (value) {
			case HTTP_PORT: return HTTP_PORT_LITERAL;
			case ADMIN_PORT: return ADMIN_PORT_LITERAL;
		}
		return null;
	}

	/**
	 * Only this class can construct instances.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	private IHSServerPortNames(int value, String name, String literal) {
		super(value, name, literal);
	}

} //IHSServerPortNames
