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
 * <!-- begin-user-doc --> A representation of the literals of the enumeration '<em><b>Connection Delivery Mode Enum</b></em>',
 * and utility methods for working with them. <!-- end-user-doc -->
 * @see com.ibm.ccl.soa.deploy.was.WasPackage#getConnectionDeliveryModeEnum()
 * @model extendedMetaData="name='ConnectionDeliveryModeEnum'"
 * @generated
 */
public final class ConnectionDeliveryModeEnum extends AbstractEnumerator {
	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public static final String copyright = "Copyright (c) 2005, 2006 IBM Corporation. Licensed Material - Property of IBM. All rights reserved."; //$NON-NLS-1$

	/**
	 * The '<em><b>Application</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>Application</b></em>' literal object isn't clear, there really
	 * should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #APPLICATION_LITERAL
	 * @model name="Application"
	 * @generated
	 * @ordered
	 */
	public static final int APPLICATION = 0;

	/**
	 * The '<em><b>Persistent</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>Persistent</b></em>' literal object isn't clear, there really
	 * should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #PERSISTENT_LITERAL
	 * @model name="Persistent"
	 * @generated
	 * @ordered
	 */
	public static final int PERSISTENT = 1;

	/**
	 * The '<em><b>Non Persistent</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>Non Persistent</b></em>' literal object isn't clear, there
	 * really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #NON_PERSISTENT_LITERAL
	 * @model name="NonPersistent"
	 * @generated
	 * @ordered
	 */
	public static final int NON_PERSISTENT = 2;

	/**
	 * The '<em><b>Application</b></em>' literal object.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @see #APPLICATION
	 * @generated
	 * @ordered
	 */
	public static final ConnectionDeliveryModeEnum APPLICATION_LITERAL = new ConnectionDeliveryModeEnum(APPLICATION, "Application", "Application"); //$NON-NLS-1$ //$NON-NLS-2$

	/**
	 * The '<em><b>Persistent</b></em>' literal object.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @see #PERSISTENT
	 * @generated
	 * @ordered
	 */
	public static final ConnectionDeliveryModeEnum PERSISTENT_LITERAL = new ConnectionDeliveryModeEnum(PERSISTENT, "Persistent", "Persistent"); //$NON-NLS-1$ //$NON-NLS-2$

	/**
	 * The '<em><b>Non Persistent</b></em>' literal object.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @see #NON_PERSISTENT
	 * @generated
	 * @ordered
	 */
	public static final ConnectionDeliveryModeEnum NON_PERSISTENT_LITERAL = new ConnectionDeliveryModeEnum(NON_PERSISTENT, "NonPersistent", "NonPersistent"); //$NON-NLS-1$ //$NON-NLS-2$

	/**
	 * An array of all the '<em><b>Connection Delivery Mode Enum</b></em>' enumerators. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	private static final ConnectionDeliveryModeEnum[] VALUES_ARRAY = new ConnectionDeliveryModeEnum[] {
			APPLICATION_LITERAL,
			PERSISTENT_LITERAL,
			NON_PERSISTENT_LITERAL,
		};

	/**
	 * A public read-only list of all the '<em><b>Connection Delivery Mode Enum</b></em>' enumerators.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public static final List VALUES = Collections.unmodifiableList(Arrays.asList(VALUES_ARRAY));

	/**
	 * Returns the '<em><b>Connection Delivery Mode Enum</b></em>' literal with the specified literal value.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public static ConnectionDeliveryModeEnum get(String literal) {
		for (int i = 0; i < VALUES_ARRAY.length; ++i) {
			ConnectionDeliveryModeEnum result = VALUES_ARRAY[i];
			if (result.toString().equals(literal)) {
				return result;
			}
		}
		return null;
	}

	/**
	 * Returns the '<em><b>Connection Delivery Mode Enum</b></em>' literal with the specified name.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public static ConnectionDeliveryModeEnum getByName(String name) {
		for (int i = 0; i < VALUES_ARRAY.length; ++i) {
			ConnectionDeliveryModeEnum result = VALUES_ARRAY[i];
			if (result.getName().equals(name)) {
				return result;
			}
		}
		return null;
	}

	/**
	 * Returns the '<em><b>Connection Delivery Mode Enum</b></em>' literal with the specified integer value.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public static ConnectionDeliveryModeEnum get(int value) {
		switch (value) {
			case APPLICATION: return APPLICATION_LITERAL;
			case PERSISTENT: return PERSISTENT_LITERAL;
			case NON_PERSISTENT: return NON_PERSISTENT_LITERAL;
		}
		return null;
	}

	/**
	 * Only this class can construct instances.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	private ConnectionDeliveryModeEnum(int value, String name, String literal) {
		super(value, name, literal);
	}

} //ConnectionDeliveryModeEnum
