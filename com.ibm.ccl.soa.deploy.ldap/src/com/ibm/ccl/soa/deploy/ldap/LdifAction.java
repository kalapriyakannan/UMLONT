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
 * <!-- begin-user-doc --> A representation of the literals of the enumeration '<em><b>Ldif Action</b></em>',
 * and utility methods for working with them. <!-- end-user-doc --> <!-- begin-model-doc -->
 * 
 * This type defines the actions that can be performed using a ldif file artifact
 * 
 * <!-- end-model-doc -->
 * 
 * @see com.ibm.ccl.soa.deploy.ldap.LdapPackage#getLdifAction()
 * @model
 * @generated
 */
public final class LdifAction extends AbstractEnumerator {
	/**
	 * The '<em><b>Import</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>Import</b></em>' literal object isn't clear, there really
	 * should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #IMPORT_LITERAL
	 * @model name="import"
	 * @generated
	 * @ordered
	 */
	public static final int IMPORT = 0;

	/**
	 * The '<em><b>Export</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>Export</b></em>' literal object isn't clear, there really
	 * should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #EXPORT_LITERAL
	 * @model name="export"
	 * @generated
	 * @ordered
	 */
	public static final int EXPORT = 1;

	/**
	 * The '<em><b>Import</b></em>' literal object. <!-- begin-user-doc --> <!-- end-user-doc
	 * -->
	 * 
	 * @see #IMPORT
	 * @generated
	 * @ordered
	 */
	public static final LdifAction IMPORT_LITERAL = new LdifAction(IMPORT, "import", "import"); //$NON-NLS-1$ //$NON-NLS-2$

	/**
	 * The '<em><b>Export</b></em>' literal object. <!-- begin-user-doc --> <!-- end-user-doc
	 * -->
	 * 
	 * @see #EXPORT
	 * @generated
	 * @ordered
	 */
	public static final LdifAction EXPORT_LITERAL = new LdifAction(EXPORT, "export", "export"); //$NON-NLS-1$ //$NON-NLS-2$

	/**
	 * An array of all the '<em><b>Ldif Action</b></em>' enumerators.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private static final LdifAction[] VALUES_ARRAY = new LdifAction[] {
			IMPORT_LITERAL,
			EXPORT_LITERAL,
		};

	/**
	 * A public read-only list of all the '<em><b>Ldif Action</b></em>' enumerators. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public static final List VALUES = Collections.unmodifiableList(Arrays.asList(VALUES_ARRAY));

	/**
	 * Returns the '<em><b>Ldif Action</b></em>' literal with the specified literal value. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public static LdifAction get(String literal) {
		for (int i = 0; i < VALUES_ARRAY.length; ++i) {
			LdifAction result = VALUES_ARRAY[i];
			if (result.toString().equals(literal)) {
				return result;
			}
		}
		return null;
	}

	/**
	 * Returns the '<em><b>Ldif Action</b></em>' literal with the specified name. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public static LdifAction getByName(String name) {
		for (int i = 0; i < VALUES_ARRAY.length; ++i) {
			LdifAction result = VALUES_ARRAY[i];
			if (result.getName().equals(name)) {
				return result;
			}
		}
		return null;
	}

	/**
	 * Returns the '<em><b>Ldif Action</b></em>' literal with the specified integer value. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public static LdifAction get(int value) {
		switch (value) {
			case IMPORT: return IMPORT_LITERAL;
			case EXPORT: return EXPORT_LITERAL;
		}
		return null;
	}

	/**
	 * Only this class can construct instances.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	private LdifAction(int value, String name, String literal) {
		super(value, name, literal);
	}

} //LdifAction
