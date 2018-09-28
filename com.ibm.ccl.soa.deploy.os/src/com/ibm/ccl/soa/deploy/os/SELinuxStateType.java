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
 * <!-- begin-user-doc --> A representation of the literals of the enumeration '<em><b>SE Linux State Type</b></em>',
 * and utility methods for working with them. <!-- end-user-doc -->
 * @see com.ibm.ccl.soa.deploy.os.OsPackage#getSELinuxStateType()
 * @model extendedMetaData="name='SELinuxStateType'"
 * @generated
 */
public final class SELinuxStateType extends AbstractEnumerator {
	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public static final String copyright = "Copyright (c) 2005, 2006 IBM Corporation. Licensed Material - Property of IBM. All rights reserved."; //$NON-NLS-1$

	/**
	 * The '<em><b>Disabled</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>Disabled</b></em>' literal object isn't clear, there really
	 * should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #DISABLED_LITERAL
	 * @model name="disabled"
	 * @generated
	 * @ordered
	 */
	public static final int DISABLED = 0;

	/**
	 * The '<em><b>Permissive</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>Permissive</b></em>' literal object isn't clear, there really
	 * should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #PERMISSIVE_LITERAL
	 * @model name="permissive"
	 * @generated
	 * @ordered
	 */
	public static final int PERMISSIVE = 1;

	/**
	 * The '<em><b>Enforcing</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>Enforcing</b></em>' literal object isn't clear, there really
	 * should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #ENFORCING_LITERAL
	 * @model name="enforcing"
	 * @generated
	 * @ordered
	 */
	public static final int ENFORCING = 2;

	/**
	 * The '<em><b>Disabled</b></em>' literal object. <!-- begin-user-doc --> <!-- end-user-doc
	 * -->
	 * 
	 * @see #DISABLED
	 * @generated
	 * @ordered
	 */
	public static final SELinuxStateType DISABLED_LITERAL = new SELinuxStateType(DISABLED,
			"disabled", "disabled"); //$NON-NLS-1$ //$NON-NLS-2$

	/**
	 * The '<em><b>Permissive</b></em>' literal object.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @see #PERMISSIVE
	 * @generated
	 * @ordered
	 */
	public static final SELinuxStateType PERMISSIVE_LITERAL = new SELinuxStateType(PERMISSIVE,
			"permissive", "permissive"); //$NON-NLS-1$ //$NON-NLS-2$

	/**
	 * The '<em><b>Enforcing</b></em>' literal object. <!-- begin-user-doc --> <!-- end-user-doc
	 * -->
	 * 
	 * @see #ENFORCING
	 * @generated
	 * @ordered
	 */
	public static final SELinuxStateType ENFORCING_LITERAL = new SELinuxStateType(ENFORCING,
			"enforcing", "enforcing"); //$NON-NLS-1$ //$NON-NLS-2$

	/**
	 * An array of all the '<em><b>SE Linux State Type</b></em>' enumerators. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	private static final SELinuxStateType[] VALUES_ARRAY = new SELinuxStateType[] {
			DISABLED_LITERAL, PERMISSIVE_LITERAL, ENFORCING_LITERAL, };

	/**
	 * A public read-only list of all the '<em><b>SE Linux State Type</b></em>' enumerators.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public static final List VALUES = Collections.unmodifiableList(Arrays.asList(VALUES_ARRAY));

	/**
	 * Returns the '<em><b>SE Linux State Type</b></em>' literal with the specified literal value.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public static SELinuxStateType get(String literal) {
		for (int i = 0; i < VALUES_ARRAY.length; ++i) {
			SELinuxStateType result = VALUES_ARRAY[i];
			if (result.toString().equals(literal)) {
				return result;
			}
		}
		return null;
	}

	/**
	 * Returns the '<em><b>SE Linux State Type</b></em>' literal with the specified name. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public static SELinuxStateType getByName(String name) {
		for (int i = 0; i < VALUES_ARRAY.length; ++i) {
			SELinuxStateType result = VALUES_ARRAY[i];
			if (result.getName().equals(name)) {
				return result;
			}
		}
		return null;
	}

	/**
	 * Returns the '<em><b>SE Linux State Type</b></em>' literal with the specified integer value.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public static SELinuxStateType get(int value) {
		switch (value)
		{
		case DISABLED:
			return DISABLED_LITERAL;
		case PERMISSIVE:
			return PERMISSIVE_LITERAL;
		case ENFORCING:
			return ENFORCING_LITERAL;
		}
		return null;
	}

	/**
	 * Only this class can construct instances.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	private SELinuxStateType(int value, String name, String literal) {
		super(value, name, literal);
	}

} //SELinuxStateType
