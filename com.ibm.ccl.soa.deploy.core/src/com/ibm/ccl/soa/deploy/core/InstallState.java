/*******************************************************************************
 * Copyright (c) 2003, 2007 IBM Corporation Licensed Material - Property of IBM. All rights reserved.
 *  
 * US Government Users Restricted Rights - Use, duplication or disclosure v1.0 restricted by GSA ADP
 * Schedule Contract with IBM Corp.
 * 
 * Contributors: IBM Corporation - initial API and implementation
 *******************************************************************************/
package com.ibm.ccl.soa.deploy.core;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.eclipse.emf.common.util.AbstractEnumerator;

/**
 * <!-- begin-user-doc --> A representation of the literals of the enumeration '<em><b>Install State</b></em>',
 * and utility methods for working with them. <!-- end-user-doc --> <!-- begin-model-doc -->
 * 
 * If a {@link Unit} represents a fully realized entity in the data center, it should have an
 * install state of 'installed'. If a Unit represents a deployment goal it should have an install
 * state of 'not_installed'.
 * 
 * <!-- end-model-doc -->
 * 
 * @see com.ibm.ccl.soa.deploy.core.CorePackage#getInstallState()
 * @model
 * @generated
 */
public final class InstallState extends AbstractEnumerator {

	/**
	 * 
	 */
	private static final long serialVersionUID = -8692173741147155894L;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public static final String copyright = "Copyright (c) 2005, 2006 IBM Corporation. Licensed Material - Property of IBM. All rights reserved."; //$NON-NLS-1$

	/**
	 * The '<em><b>Installed</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>Installed</b></em>' literal object isn't clear, there really
	 * should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #INSTALLED_LITERAL
	 * @model name="installed"
	 * @generated
	 * @ordered
	 */
	public static final int INSTALLED = 0;

	/**
	 * The '<em><b>Not Installed</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>Not Installed</b></em>' literal object isn't clear, there
	 * really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #NOT_INSTALLED_LITERAL
	 * @model name="notInstalled" literal="not_installed"
	 * @generated
	 * @ordered
	 */
	public static final int NOT_INSTALLED = 1;

	/**
	 * The '<em><b>Unknown</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>Unknown</b></em>' literal object isn't clear, there really
	 * should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #UNKNOWN_LITERAL
	 * @model name="unknown"
	 * @generated
	 * @ordered
	 */
	public static final int UNKNOWN = 2;

	/**
	 * The '<em><b>Installed</b></em>' literal object. <!-- begin-user-doc --> <!-- end-user-doc
	 * -->
	 * 
	 * @see #INSTALLED
	 * @generated
	 * @ordered
	 */
	public static final InstallState INSTALLED_LITERAL = new InstallState(INSTALLED, "installed", "installed"); //$NON-NLS-1$ //$NON-NLS-2$

	/**
	 * The '<em><b>Not Installed</b></em>' literal object.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @see #NOT_INSTALLED
	 * @generated
	 * @ordered
	 */
	public static final InstallState NOT_INSTALLED_LITERAL = new InstallState(NOT_INSTALLED, "notInstalled", "not_installed"); //$NON-NLS-1$ //$NON-NLS-2$

	/**
	 * The '<em><b>Unknown</b></em>' literal object. <!-- begin-user-doc --> <!-- end-user-doc
	 * -->
	 * 
	 * @see #UNKNOWN
	 * @generated
	 * @ordered
	 */
	public static final InstallState UNKNOWN_LITERAL = new InstallState(UNKNOWN, "unknown", "unknown"); //$NON-NLS-1$ //$NON-NLS-2$

	/**
	 * An array of all the '<em><b>Install State</b></em>' enumerators.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private static final InstallState[] VALUES_ARRAY = new InstallState[] {
			INSTALLED_LITERAL,
			NOT_INSTALLED_LITERAL,
			UNKNOWN_LITERAL,
		};

	/**
	 * A public read-only list of all the '<em><b>Install State</b></em>' enumerators. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public static final List VALUES = Collections.unmodifiableList(Arrays.asList(VALUES_ARRAY));

	/**
	 * Returns the '<em><b>Install State</b></em>' literal with the specified literal value.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public static InstallState get(String literal) {
		for (int i = 0; i < VALUES_ARRAY.length; ++i) {
			InstallState result = VALUES_ARRAY[i];
			if (result.toString().equals(literal)) {
				return result;
			}
		}
		return null;
	}

	/**
	 * Returns the '<em><b>Install State</b></em>' literal with the specified name. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public static InstallState getByName(String name) {
		for (int i = 0; i < VALUES_ARRAY.length; ++i) {
			InstallState result = VALUES_ARRAY[i];
			if (result.getName().equals(name)) {
				return result;
			}
		}
		return null;
	}

	/**
	 * Returns the '<em><b>Install State</b></em>' literal with the specified integer value.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public static InstallState get(int value) {
		switch (value) {
			case INSTALLED: return INSTALLED_LITERAL;
			case NOT_INSTALLED: return NOT_INSTALLED_LITERAL;
			case UNKNOWN: return UNKNOWN_LITERAL;
		}
		return null;
	}

	/**
	 * Only this class can construct instances.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	private InstallState(int value, String name, String literal) {
		super(value, name, literal);
	}

} //InstallState
