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
 * <!-- begin-user-doc --> A representation of the literals of the enumeration '<em><b>Scope Enum</b></em>',
 * and utility methods for working with them. <!-- end-user-doc -->
 * 
 * @see com.ibm.ccl.soa.deploy.was.WasPackage#getWasScopeEnum()
 * @model
 * @generated
 */
public final class WasScopeEnum extends AbstractEnumerator {
	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public static final String copyright = "Copyright (c) 2005, 2006 IBM Corporation. Licensed Material - Property of IBM. All rights reserved."; //$NON-NLS-1$

	/**
	 * The '<em><b>Cell</b></em>' literal value. <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>Cell</b></em>' literal object isn't clear, there really should
	 * be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * 
	 * @see #CELL_LITERAL
	 * @model name="cell"
	 * @generated
	 * @ordered
	 */
	public static final int CELL = 0;

	/**
	 * The '<em><b>Node</b></em>' literal value. <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>Node</b></em>' literal object isn't clear, there really should
	 * be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * 
	 * @see #NODE_LITERAL
	 * @model name="node"
	 * @generated
	 * @ordered
	 */
	public static final int NODE = 1;

	/**
	 * The '<em><b>Server</b></em>' literal value. <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>Server</b></em>' literal object isn't clear, there really
	 * should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * 
	 * @see #SERVER_LITERAL
	 * @model name="server"
	 * @generated
	 * @ordered
	 */
	public static final int SERVER = 2;

	/**
	 * The '<em><b>Cluster</b></em>' literal value. <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>Cluster</b></em>' literal object isn't clear, there really
	 * should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * 
	 * @see #CLUSTER_LITERAL
	 * @model name="cluster"
	 * @generated
	 * @ordered
	 */
	public static final int CLUSTER = 3;

	/**
	 * The '<em><b>Cell</b></em>' literal object. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see #CELL
	 * @generated
	 * @ordered
	 */
	public static final WasScopeEnum CELL_LITERAL = new WasScopeEnum(CELL, "cell", "cell"); //$NON-NLS-1$ //$NON-NLS-2$

	/**
	 * The '<em><b>Node</b></em>' literal object. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see #NODE
	 * @generated
	 * @ordered
	 */
	public static final WasScopeEnum NODE_LITERAL = new WasScopeEnum(NODE, "node", "node"); //$NON-NLS-1$ //$NON-NLS-2$

	/**
	 * The '<em><b>Server</b></em>' literal object. <!-- begin-user-doc --> <!-- end-user-doc
	 * -->
	 * 
	 * @see #SERVER
	 * @generated
	 * @ordered
	 */
	public static final WasScopeEnum SERVER_LITERAL = new WasScopeEnum(SERVER, "server", "server"); //$NON-NLS-1$ //$NON-NLS-2$

	/**
	 * The '<em><b>Cluster</b></em>' literal object. <!-- begin-user-doc --> <!-- end-user-doc
	 * -->
	 * 
	 * @see #CLUSTER
	 * @generated
	 * @ordered
	 */
	public static final WasScopeEnum CLUSTER_LITERAL = new WasScopeEnum(CLUSTER,
			"cluster", "cluster"); //$NON-NLS-1$ //$NON-NLS-2$

	/**
	 * An array of all the '<em><b>Scope Enum</b></em>' enumerators. <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	private static final WasScopeEnum[] VALUES_ARRAY = new WasScopeEnum[] { CELL_LITERAL,
			NODE_LITERAL, SERVER_LITERAL, CLUSTER_LITERAL, };

	/**
	 * A public read-only list of all the '<em><b>Scope Enum</b></em>' enumerators. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public static final List VALUES = Collections.unmodifiableList(Arrays.asList(VALUES_ARRAY));

	/**
	 * Returns the '<em><b>Scope Enum</b></em>' literal with the specified literal value. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public static WasScopeEnum get(String literal) {
		for (int i = 0; i < VALUES_ARRAY.length; ++i) {
			WasScopeEnum result = VALUES_ARRAY[i];
			if (result.toString().equals(literal)) {
				return result;
			}
		}
		return null;
	}

	/**
	 * Returns the '<em><b>Scope Enum</b></em>' literal with the specified name. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public static WasScopeEnum getByName(String name) {
		for (int i = 0; i < VALUES_ARRAY.length; ++i) {
			WasScopeEnum result = VALUES_ARRAY[i];
			if (result.getName().equals(name)) {
				return result;
			}
		}
		return null;
	}

	/**
	 * Returns the '<em><b>Scope Enum</b></em>' literal with the specified integer value. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public static WasScopeEnum get(int value) {
		switch (value)
		{
		case CELL:
			return CELL_LITERAL;
		case NODE:
			return NODE_LITERAL;
		case SERVER:
			return SERVER_LITERAL;
		case CLUSTER:
			return CLUSTER_LITERAL;
		}
		return null;
	}

	/**
	 * Only this class can construct instances. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	private WasScopeEnum(int value, String name, String literal) {
		super(value, name, literal);
	}

} //WasScopeEnum
