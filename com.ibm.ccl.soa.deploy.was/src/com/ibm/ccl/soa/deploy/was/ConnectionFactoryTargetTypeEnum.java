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
 * <!-- begin-user-doc --> A representation of the literals of the enumeration '<em><b>Connection Factory Target Type Enum</b></em>',
 * and utility methods for working with them. <!-- end-user-doc -->
 * @see com.ibm.ccl.soa.deploy.was.WasPackage#getConnectionFactoryTargetTypeEnum()
 * @model extendedMetaData="name='ConnectionFactoryTargetTypeEnum'"
 * @generated
 */
public final class ConnectionFactoryTargetTypeEnum extends AbstractEnumerator {
	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public static final String copyright = "Copyright (c) 2005, 2006 IBM Corporation. Licensed Material - Property of IBM. All rights reserved."; //$NON-NLS-1$

	/**
	 * The '<em><b>Bus Member</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>Bus Member</b></em>' literal object isn't clear, there really
	 * should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #BUS_MEMBER_LITERAL
	 * @model name="BusMember"
	 * @generated
	 * @ordered
	 */
	public static final int BUS_MEMBER = 0;

	/**
	 * The '<em><b>Custom</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>Custom</b></em>' literal object isn't clear, there really
	 * should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #CUSTOM_LITERAL
	 * @model name="Custom"
	 * @generated
	 * @ordered
	 */
	public static final int CUSTOM = 1;

	/**
	 * The '<em><b>ME</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>ME</b></em>' literal object isn't clear, there really should be
	 * more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #ME_LITERAL
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int ME = 2;

	/**
	 * The '<em><b>Bus Member</b></em>' literal object.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @see #BUS_MEMBER
	 * @generated
	 * @ordered
	 */
	public static final ConnectionFactoryTargetTypeEnum BUS_MEMBER_LITERAL = new ConnectionFactoryTargetTypeEnum(BUS_MEMBER, "BusMember", "BusMember"); //$NON-NLS-1$ //$NON-NLS-2$

	/**
	 * The '<em><b>Custom</b></em>' literal object. <!-- begin-user-doc --> <!-- end-user-doc
	 * -->
	 * 
	 * @see #CUSTOM
	 * @generated
	 * @ordered
	 */
	public static final ConnectionFactoryTargetTypeEnum CUSTOM_LITERAL = new ConnectionFactoryTargetTypeEnum(CUSTOM, "Custom", "Custom"); //$NON-NLS-1$ //$NON-NLS-2$

	/**
	 * The '<em><b>ME</b></em>' literal object.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see #ME
	 * @generated
	 * @ordered
	 */
	public static final ConnectionFactoryTargetTypeEnum ME_LITERAL = new ConnectionFactoryTargetTypeEnum(ME, "ME", "ME"); //$NON-NLS-1$ //$NON-NLS-2$

	/**
	 * An array of all the '<em><b>Connection Factory Target Type Enum</b></em>' enumerators.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	private static final ConnectionFactoryTargetTypeEnum[] VALUES_ARRAY = new ConnectionFactoryTargetTypeEnum[] {
			BUS_MEMBER_LITERAL,
			CUSTOM_LITERAL,
			ME_LITERAL,
		};

	/**
	 * A public read-only list of all the '<em><b>Connection Factory Target Type Enum</b></em>' enumerators.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public static final List VALUES = Collections.unmodifiableList(Arrays.asList(VALUES_ARRAY));

	/**
	 * Returns the '<em><b>Connection Factory Target Type Enum</b></em>' literal with the specified literal value.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public static ConnectionFactoryTargetTypeEnum get(String literal) {
		for (int i = 0; i < VALUES_ARRAY.length; ++i) {
			ConnectionFactoryTargetTypeEnum result = VALUES_ARRAY[i];
			if (result.toString().equals(literal)) {
				return result;
			}
		}
		return null;
	}

	/**
	 * Returns the '<em><b>Connection Factory Target Type Enum</b></em>' literal with the specified name.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public static ConnectionFactoryTargetTypeEnum getByName(String name) {
		for (int i = 0; i < VALUES_ARRAY.length; ++i) {
			ConnectionFactoryTargetTypeEnum result = VALUES_ARRAY[i];
			if (result.getName().equals(name)) {
				return result;
			}
		}
		return null;
	}

	/**
	 * Returns the '<em><b>Connection Factory Target Type Enum</b></em>' literal with the specified integer value.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public static ConnectionFactoryTargetTypeEnum get(int value) {
		switch (value) {
			case BUS_MEMBER: return BUS_MEMBER_LITERAL;
			case CUSTOM: return CUSTOM_LITERAL;
			case ME: return ME_LITERAL;
		}
		return null;
	}

	/**
	 * Only this class can construct instances.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	private ConnectionFactoryTargetTypeEnum(int value, String name, String literal) {
		super(value, name, literal);
	}

} //ConnectionFactoryTargetTypeEnum
