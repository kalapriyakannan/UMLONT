/*******************************************************************************
 * Copyright (c) 2003, 2007 IBM Corporation Licensed Material - Property of IBM. All rights reserved.
 *  
 * US Government Users Restricted Rights - Use, duplication or disclosure v1.0 restricted by GSA ADP
 * Schedule Contract with IBM Corp.
 * 
 * Contributors: IBM Corporation - initial API and implementation
 *******************************************************************************/
package com.ibm.ccl.soa.deploy.ldap;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.eclipse.emf.common.util.AbstractEnumerator;

/**
 * <!-- begin-user-doc --> A representation of the literals of the enumeration '<em><b>Schema Action</b></em>',
 * and utility methods for working with them. <!-- end-user-doc --> <!-- begin-model-doc -->
 * 
 * This type defines the actions that can be performed using a schema file artifact
 * 
 * <!-- end-model-doc -->
 * 
 * @see com.ibm.ccl.soa.deploy.ldap.LdapPackage#getSchemaAction()
 * @model
 * @generated
 */
public final class SchemaAction extends AbstractEnumerator {
	/**
	 * The '<em><b>Add</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>Add</b></em>' literal object isn't clear, there really should
	 * be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #ADD_LITERAL
	 * @model name="add"
	 * @generated
	 * @ordered
	 */
	public static final int ADD = 0;

	/**
	 * The '<em><b>Remove</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>Remove</b></em>' literal object isn't clear, there really
	 * should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #REMOVE_LITERAL
	 * @model name="remove"
	 * @generated
	 * @ordered
	 */
	public static final int REMOVE = 1;

	/**
	 * The '<em><b>Add</b></em>' literal object.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see #ADD
	 * @generated
	 * @ordered
	 */
	public static final SchemaAction ADD_LITERAL = new SchemaAction(ADD, "add", "add"); //$NON-NLS-1$ //$NON-NLS-2$

	/**
	 * The '<em><b>Remove</b></em>' literal object. <!-- begin-user-doc --> <!-- end-user-doc
	 * -->
	 * 
	 * @see #REMOVE
	 * @generated
	 * @ordered
	 */
	public static final SchemaAction REMOVE_LITERAL = new SchemaAction(REMOVE, "remove", "remove"); //$NON-NLS-1$ //$NON-NLS-2$

	/**
	 * An array of all the '<em><b>Schema Action</b></em>' enumerators.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private static final SchemaAction[] VALUES_ARRAY = new SchemaAction[] {
			ADD_LITERAL,
			REMOVE_LITERAL,
		};

	/**
	 * A public read-only list of all the '<em><b>Schema Action</b></em>' enumerators. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public static final List VALUES = Collections.unmodifiableList(Arrays.asList(VALUES_ARRAY));

	/**
	 * Returns the '<em><b>Schema Action</b></em>' literal with the specified literal value.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public static SchemaAction get(String literal) {
		for (int i = 0; i < VALUES_ARRAY.length; ++i) {
			SchemaAction result = VALUES_ARRAY[i];
			if (result.toString().equals(literal)) {
				return result;
			}
		}
		return null;
	}

	/**
	 * Returns the '<em><b>Schema Action</b></em>' literal with the specified name. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public static SchemaAction getByName(String name) {
		for (int i = 0; i < VALUES_ARRAY.length; ++i) {
			SchemaAction result = VALUES_ARRAY[i];
			if (result.getName().equals(name)) {
				return result;
			}
		}
		return null;
	}

	/**
	 * Returns the '<em><b>Schema Action</b></em>' literal with the specified integer value.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public static SchemaAction get(int value) {
		switch (value) {
			case ADD: return ADD_LITERAL;
			case REMOVE: return REMOVE_LITERAL;
		}
		return null;
	}

	/**
	 * Only this class can construct instances.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	private SchemaAction(int value, String name, String literal) {
		super(value, name, literal);
	}

} //SchemaAction
