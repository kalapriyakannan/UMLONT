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
 * <!-- begin-user-doc -->
 * A representation of the literals of the enumeration '<em><b>User Registry Types</b></em>',
 * and utility methods for working with them.
 * <!-- end-user-doc -->
 * @see com.ibm.ccl.soa.deploy.was.WasPackage#getWasUserRegistryTypes()
 * @model extendedMetaData="name='WasUserRegistryTypes'"
 * @generated
 */
public final class WasUserRegistryTypes extends AbstractEnumerator {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final String copyright = "Copyright (c) 2005, 2006 IBM Corporation. Licensed Material - Property of IBM. All rights reserved."; //$NON-NLS-1$

	/**
	 * The '<em><b>OS</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>OS</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #OS_LITERAL
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int OS = 0;

	/**
	 * The '<em><b>LDAP</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>LDAP</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #LDAP_LITERAL
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int LDAP = 1;

	/**
	 * The '<em><b>CUSTOM</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>CUSTOM</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #CUSTOM_LITERAL
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int CUSTOM = 2;

	/**
	 * The '<em><b>OS</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #OS
	 * @generated
	 * @ordered
	 */
	public static final WasUserRegistryTypes OS_LITERAL = new WasUserRegistryTypes(OS, "OS", "OS"); //$NON-NLS-1$ //$NON-NLS-2$

	/**
	 * The '<em><b>LDAP</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #LDAP
	 * @generated
	 * @ordered
	 */
	public static final WasUserRegistryTypes LDAP_LITERAL = new WasUserRegistryTypes(LDAP, "LDAP", "LDAP"); //$NON-NLS-1$ //$NON-NLS-2$

	/**
	 * The '<em><b>CUSTOM</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #CUSTOM
	 * @generated
	 * @ordered
	 */
	public static final WasUserRegistryTypes CUSTOM_LITERAL = new WasUserRegistryTypes(CUSTOM, "CUSTOM", "CUSTOM"); //$NON-NLS-1$ //$NON-NLS-2$

	/**
	 * An array of all the '<em><b>User Registry Types</b></em>' enumerators.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private static final WasUserRegistryTypes[] VALUES_ARRAY =
		new WasUserRegistryTypes[] {
			OS_LITERAL,
			LDAP_LITERAL,
			CUSTOM_LITERAL,
		};

	/**
	 * A public read-only list of all the '<em><b>User Registry Types</b></em>' enumerators.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final List VALUES = Collections.unmodifiableList(Arrays.asList(VALUES_ARRAY));

	/**
	 * Returns the '<em><b>User Registry Types</b></em>' literal with the specified literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static WasUserRegistryTypes get(String literal) {
		for (int i = 0; i < VALUES_ARRAY.length; ++i) {
			WasUserRegistryTypes result = VALUES_ARRAY[i];
			if (result.toString().equals(literal)) {
				return result;
			}
		}
		return null;
	}

	/**
	 * Returns the '<em><b>User Registry Types</b></em>' literal with the specified name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static WasUserRegistryTypes getByName(String name) {
		for (int i = 0; i < VALUES_ARRAY.length; ++i) {
			WasUserRegistryTypes result = VALUES_ARRAY[i];
			if (result.getName().equals(name)) {
				return result;
			}
		}
		return null;
	}

	/**
	 * Returns the '<em><b>User Registry Types</b></em>' literal with the specified integer value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static WasUserRegistryTypes get(int value) {
		switch (value) {
			case OS: return OS_LITERAL;
			case LDAP: return LDAP_LITERAL;
			case CUSTOM: return CUSTOM_LITERAL;
		}
		return null;
	}

	/**
	 * Only this class can construct instances.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private WasUserRegistryTypes(int value, String name, String literal) {
		super(value, name, literal);
	}

} //WasUserRegistryTypes
