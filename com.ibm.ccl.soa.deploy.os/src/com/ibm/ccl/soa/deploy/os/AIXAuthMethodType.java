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
 * <!-- begin-user-doc --> A representation of the literals of the enumeration '<em><b>AIX Auth Method Type</b></em>',
 * and utility methods for working with them. <!-- end-user-doc -->
 * @see com.ibm.ccl.soa.deploy.os.OsPackage#getAIXAuthMethodType()
 * @model extendedMetaData="name='AIXAuthMethodType'"
 * @generated
 */
public final class AIXAuthMethodType extends AbstractEnumerator {
	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public static final String copyright = "Copyright (c) 2005, 2006 IBM Corporation. Licensed Material - Property of IBM. All rights reserved."; //$NON-NLS-1$

	/**
	 * The '<em><b>SYSTEM</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>SYSTEM</b></em>' literal object isn't clear, there really
	 * should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #SYSTEM_LITERAL
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int SYSTEM = 0;

	/**
	 * The '<em><b>NONE</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>NONE</b></em>' literal object isn't clear, there really should
	 * be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #NONE_LITERAL
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int NONE = 1;

	/**
	 * The '<em><b>Token Username</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>Token Username</b></em>' literal object isn't clear, there
	 * really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #TOKEN_USERNAME_LITERAL
	 * @model name="tokenUsername" literal="token;username"
	 * @generated
	 * @ordered
	 */
	public static final int TOKEN_USERNAME = 2;

	/**
	 * The '<em><b>SYSTEM</b></em>' literal object. <!-- begin-user-doc --> <!-- end-user-doc
	 * -->
	 * 
	 * @see #SYSTEM
	 * @generated
	 * @ordered
	 */
	public static final AIXAuthMethodType SYSTEM_LITERAL = new AIXAuthMethodType(SYSTEM,
			"SYSTEM", "SYSTEM"); //$NON-NLS-1$ //$NON-NLS-2$

	/**
	 * The '<em><b>NONE</b></em>' literal object.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see #NONE
	 * @generated
	 * @ordered
	 */
	public static final AIXAuthMethodType NONE_LITERAL = new AIXAuthMethodType(NONE, "NONE", "NONE"); //$NON-NLS-1$ //$NON-NLS-2$

	/**
	 * The '<em><b>Token Username</b></em>' literal object.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @see #TOKEN_USERNAME
	 * @generated
	 * @ordered
	 */
	public static final AIXAuthMethodType TOKEN_USERNAME_LITERAL = new AIXAuthMethodType(
			TOKEN_USERNAME, "tokenUsername", "token;username"); //$NON-NLS-1$ //$NON-NLS-2$

	/**
	 * An array of all the '<em><b>AIX Auth Method Type</b></em>' enumerators. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	private static final AIXAuthMethodType[] VALUES_ARRAY = new AIXAuthMethodType[] {
			SYSTEM_LITERAL, NONE_LITERAL, TOKEN_USERNAME_LITERAL, };

	/**
	 * A public read-only list of all the '<em><b>AIX Auth Method Type</b></em>' enumerators.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public static final List VALUES = Collections.unmodifiableList(Arrays.asList(VALUES_ARRAY));

	/**
	 * Returns the '<em><b>AIX Auth Method Type</b></em>' literal with the specified literal value.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public static AIXAuthMethodType get(String literal) {
		for (int i = 0; i < VALUES_ARRAY.length; ++i) {
			AIXAuthMethodType result = VALUES_ARRAY[i];
			if (result.toString().equals(literal)) {
				return result;
			}
		}
		return null;
	}

	/**
	 * Returns the '<em><b>AIX Auth Method Type</b></em>' literal with the specified name. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public static AIXAuthMethodType getByName(String name) {
		for (int i = 0; i < VALUES_ARRAY.length; ++i) {
			AIXAuthMethodType result = VALUES_ARRAY[i];
			if (result.getName().equals(name)) {
				return result;
			}
		}
		return null;
	}

	/**
	 * Returns the '<em><b>AIX Auth Method Type</b></em>' literal with the specified integer value.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public static AIXAuthMethodType get(int value) {
		switch (value)
		{
		case SYSTEM:
			return SYSTEM_LITERAL;
		case NONE:
			return NONE_LITERAL;
		case TOKEN_USERNAME:
			return TOKEN_USERNAME_LITERAL;
		}
		return null;
	}

	/**
	 * Only this class can construct instances.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	private AIXAuthMethodType(int value, String name, String literal) {
		super(value, name, literal);
	}

} //AIXAuthMethodType
