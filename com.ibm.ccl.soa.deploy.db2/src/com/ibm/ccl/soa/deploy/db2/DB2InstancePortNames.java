/***************************************************************************************************
 * Copyright (c) 2003, 2007 IBM Corporation Licensed Material - Property of IBM. All rights
 * reserved.
 * 
 * US Government Users Restricted Rights - Use, duplication or disclosure v1.0 restricted by GSA ADP
 * Schedule Contract with IBM Corp.
 * 
 * Contributors: IBM Corporation - initial API and implementation
 **************************************************************************************************/
package com.ibm.ccl.soa.deploy.db2;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.eclipse.emf.common.util.AbstractEnumerator;

/**
 * <!-- begin-user-doc --> A representation of the literals of the enumeration '<em><b>DB2 Instance Port Names</b></em>',
 * and utility methods for working with them. <!-- end-user-doc -->
 * @see com.ibm.ccl.soa.deploy.db2.Db2Package#getDB2InstancePortNames()
 * @model extendedMetaData="name='DB2InstancePortNames'"
 * @generated
 */
public final class DB2InstancePortNames extends AbstractEnumerator {
	/**
	 * The '<em><b>Instance Connection Port</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>Instance Connection Port</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #INSTANCE_CONNECTION_PORT_LITERAL
	 * @model name="instanceConnectionPort"
	 * @generated
	 * @ordered
	 */
	public static final int INSTANCE_CONNECTION_PORT = 0;

	/**
	 * The '<em><b>Instance Interrupt Port</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>Instance Interrupt Port</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #INSTANCE_INTERRUPT_PORT_LITERAL
	 * @model name="instanceInterruptPort"
	 * @generated
	 * @ordered
	 */
	public static final int INSTANCE_INTERRUPT_PORT = 1;

	/**
	 * The '<em><b>Instance FCM Port</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>Instance FCM Port</b></em>' literal object isn't clear, there
	 * really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #INSTANCE_FCM_PORT_LITERAL
	 * @model name="instanceFCMPort"
	 * @generated
	 * @ordered
	 */
	public static final int INSTANCE_FCM_PORT = 2;

	/**
	 * The '<em><b>Instance Connection Port</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #INSTANCE_CONNECTION_PORT
	 * @generated
	 * @ordered
	 */
	public static final DB2InstancePortNames INSTANCE_CONNECTION_PORT_LITERAL = new DB2InstancePortNames(INSTANCE_CONNECTION_PORT, "instanceConnectionPort", "instanceConnectionPort"); //$NON-NLS-1$ //$NON-NLS-2$

	/**
	 * The '<em><b>Instance Interrupt Port</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #INSTANCE_INTERRUPT_PORT
	 * @generated
	 * @ordered
	 */
	public static final DB2InstancePortNames INSTANCE_INTERRUPT_PORT_LITERAL = new DB2InstancePortNames(INSTANCE_INTERRUPT_PORT, "instanceInterruptPort", "instanceInterruptPort"); //$NON-NLS-1$ //$NON-NLS-2$

	/**
	 * The '<em><b>Instance FCM Port</b></em>' literal object.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @see #INSTANCE_FCM_PORT
	 * @generated
	 * @ordered
	 */
	public static final DB2InstancePortNames INSTANCE_FCM_PORT_LITERAL = new DB2InstancePortNames(INSTANCE_FCM_PORT, "instanceFCMPort", "instanceFCMPort"); //$NON-NLS-1$ //$NON-NLS-2$

	/**
	 * An array of all the '<em><b>DB2 Instance Port Names</b></em>' enumerators. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	private static final DB2InstancePortNames[] VALUES_ARRAY = new DB2InstancePortNames[] {
			INSTANCE_CONNECTION_PORT_LITERAL,
			INSTANCE_INTERRUPT_PORT_LITERAL,
			INSTANCE_FCM_PORT_LITERAL,
		};

	/**
	 * A public read-only list of all the '<em><b>DB2 Instance Port Names</b></em>' enumerators.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public static final List VALUES = Collections.unmodifiableList(Arrays.asList(VALUES_ARRAY));

	/**
	 * Returns the '<em><b>DB2 Instance Port Names</b></em>' literal with the specified literal value.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public static DB2InstancePortNames get(String literal) {
		for (int i = 0; i < VALUES_ARRAY.length; ++i) {
			DB2InstancePortNames result = VALUES_ARRAY[i];
			if (result.toString().equals(literal)) {
				return result;
			}
		}
		return null;
	}

	/**
	 * Returns the '<em><b>DB2 Instance Port Names</b></em>' literal with the specified name.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public static DB2InstancePortNames getByName(String name) {
		for (int i = 0; i < VALUES_ARRAY.length; ++i) {
			DB2InstancePortNames result = VALUES_ARRAY[i];
			if (result.getName().equals(name)) {
				return result;
			}
		}
		return null;
	}

	/**
	 * Returns the '<em><b>DB2 Instance Port Names</b></em>' literal with the specified integer value.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public static DB2InstancePortNames get(int value) {
		switch (value) {
			case INSTANCE_CONNECTION_PORT: return INSTANCE_CONNECTION_PORT_LITERAL;
			case INSTANCE_INTERRUPT_PORT: return INSTANCE_INTERRUPT_PORT_LITERAL;
			case INSTANCE_FCM_PORT: return INSTANCE_FCM_PORT_LITERAL;
		}
		return null;
	}

	/**
	 * Only this class can construct instances.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	private DB2InstancePortNames(int value, String name, String literal) {
		super(value, name, literal);
	}

} //DB2InstancePortNames
