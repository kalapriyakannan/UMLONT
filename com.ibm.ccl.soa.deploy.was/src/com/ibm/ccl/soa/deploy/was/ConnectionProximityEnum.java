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
 * <!-- begin-user-doc --> A representation of the literals of the enumeration '<em><b>Connection Proximity Enum</b></em>',
 * and utility methods for working with them. <!-- end-user-doc -->
 * @see com.ibm.ccl.soa.deploy.was.WasPackage#getConnectionProximityEnum()
 * @model extendedMetaData="name='ConnectionProximityEnum'"
 * @generated
 */
public final class ConnectionProximityEnum extends AbstractEnumerator {
	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public static final String copyright = "Copyright (c) 2005, 2006 IBM Corporation. Licensed Material - Property of IBM. All rights reserved."; //$NON-NLS-1$

	/**
	 * The '<em><b>Bus</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>Bus</b></em>' literal object isn't clear, there really should
	 * be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #BUS_LITERAL
	 * @model name="Bus"
	 * @generated
	 * @ordered
	 */
	public static final int BUS = 0;

	/**
	 * The '<em><b>Host</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>Host</b></em>' literal object isn't clear, there really should
	 * be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #HOST_LITERAL
	 * @model name="Host"
	 * @generated
	 * @ordered
	 */
	public static final int HOST = 1;

	/**
	 * The '<em><b>Cluster</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>Cluster</b></em>' literal object isn't clear, there really
	 * should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #CLUSTER_LITERAL
	 * @model name="Cluster"
	 * @generated
	 * @ordered
	 */
	public static final int CLUSTER = 2;

	/**
	 * The '<em><b>Server</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>Server</b></em>' literal object isn't clear, there really
	 * should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #SERVER_LITERAL
	 * @model name="Server"
	 * @generated
	 * @ordered
	 */
	public static final int SERVER = 3;

	/**
	 * The '<em><b>Bus</b></em>' literal object.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see #BUS
	 * @generated
	 * @ordered
	 */
	public static final ConnectionProximityEnum BUS_LITERAL = new ConnectionProximityEnum(BUS, "Bus", "Bus"); //$NON-NLS-1$ //$NON-NLS-2$

	/**
	 * The '<em><b>Host</b></em>' literal object.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see #HOST
	 * @generated
	 * @ordered
	 */
	public static final ConnectionProximityEnum HOST_LITERAL = new ConnectionProximityEnum(HOST, "Host", "Host"); //$NON-NLS-1$ //$NON-NLS-2$

	/**
	 * The '<em><b>Cluster</b></em>' literal object. <!-- begin-user-doc --> <!-- end-user-doc
	 * -->
	 * 
	 * @see #CLUSTER
	 * @generated
	 * @ordered
	 */
	public static final ConnectionProximityEnum CLUSTER_LITERAL = new ConnectionProximityEnum(CLUSTER, "Cluster", "Cluster"); //$NON-NLS-1$ //$NON-NLS-2$

	/**
	 * The '<em><b>Server</b></em>' literal object. <!-- begin-user-doc --> <!-- end-user-doc
	 * -->
	 * 
	 * @see #SERVER
	 * @generated
	 * @ordered
	 */
	public static final ConnectionProximityEnum SERVER_LITERAL = new ConnectionProximityEnum(SERVER, "Server", "Server"); //$NON-NLS-1$ //$NON-NLS-2$

	/**
	 * An array of all the '<em><b>Connection Proximity Enum</b></em>' enumerators. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	private static final ConnectionProximityEnum[] VALUES_ARRAY = new ConnectionProximityEnum[] {
			BUS_LITERAL,
			HOST_LITERAL,
			CLUSTER_LITERAL,
			SERVER_LITERAL,
		};

	/**
	 * A public read-only list of all the '<em><b>Connection Proximity Enum</b></em>' enumerators.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public static final List VALUES = Collections.unmodifiableList(Arrays.asList(VALUES_ARRAY));

	/**
	 * Returns the '<em><b>Connection Proximity Enum</b></em>' literal with the specified literal value.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public static ConnectionProximityEnum get(String literal) {
		for (int i = 0; i < VALUES_ARRAY.length; ++i) {
			ConnectionProximityEnum result = VALUES_ARRAY[i];
			if (result.toString().equals(literal)) {
				return result;
			}
		}
		return null;
	}

	/**
	 * Returns the '<em><b>Connection Proximity Enum</b></em>' literal with the specified name.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public static ConnectionProximityEnum getByName(String name) {
		for (int i = 0; i < VALUES_ARRAY.length; ++i) {
			ConnectionProximityEnum result = VALUES_ARRAY[i];
			if (result.getName().equals(name)) {
				return result;
			}
		}
		return null;
	}

	/**
	 * Returns the '<em><b>Connection Proximity Enum</b></em>' literal with the specified integer value.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public static ConnectionProximityEnum get(int value) {
		switch (value) {
			case BUS: return BUS_LITERAL;
			case HOST: return HOST_LITERAL;
			case CLUSTER: return CLUSTER_LITERAL;
			case SERVER: return SERVER_LITERAL;
		}
		return null;
	}

	/**
	 * Only this class can construct instances.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	private ConnectionProximityEnum(int value, String name, String literal) {
		super(value, name, literal);
	}

} //ConnectionProximityEnum
