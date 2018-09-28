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
 * <!-- begin-user-doc --> A representation of the literals of the enumeration '<em><b>Web Server Type</b></em>',
 * and utility methods for working with them. <!-- end-user-doc --> <!-- begin-model-doc -->
 * 
 * 
 * <!-- end-model-doc -->
 * 
 * @see com.ibm.ccl.soa.deploy.was.WasPackage#getWasWebServerType()
 * @model
 * @generated
 */
public final class WasWebServerType extends AbstractEnumerator {
	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public static final String copyright = "Copyright (c) 2005, 2006 IBM Corporation. Licensed Material - Property of IBM. All rights reserved."; //$NON-NLS-1$

	/**
	 * The '<em><b>IHS</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>IHS</b></em>' literal object isn't clear, there really should
	 * be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #IHS_LITERAL
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int IHS = 0;

	/**
	 * The '<em><b>APACHE</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>APACHE</b></em>' literal object isn't clear, there really
	 * should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #APACHE_LITERAL
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int APACHE = 1;

	/**
	 * The '<em><b>IIS</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>IIS</b></em>' literal object isn't clear, there really should
	 * be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #IIS_LITERAL
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int IIS = 2;

	/**
	 * The '<em><b>DOMINO</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>DOMINO</b></em>' literal object isn't clear, there really
	 * should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #DOMINO_LITERAL
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int DOMINO = 3;

	/**
	 * The '<em><b>SUNJAVASYSTEM</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>SUNJAVASYSTEM</b></em>' literal object isn't clear, there
	 * really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #SUNJAVASYSTEM_LITERAL
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int SUNJAVASYSTEM = 4;

	/**
	 * The '<em><b>UNKNOWN</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>UNKNOWN</b></em>' literal object isn't clear, there really
	 * should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #UNKNOWN_LITERAL
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int UNKNOWN = 5;

	/**
	 * The '<em><b>IHS</b></em>' literal object.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see #IHS
	 * @generated
	 * @ordered
	 */
	public static final WasWebServerType IHS_LITERAL = new WasWebServerType(IHS, "IHS", "IHS"); //$NON-NLS-1$ //$NON-NLS-2$

	/**
	 * The '<em><b>APACHE</b></em>' literal object. <!-- begin-user-doc --> <!-- end-user-doc
	 * -->
	 * 
	 * @see #APACHE
	 * @generated
	 * @ordered
	 */
	public static final WasWebServerType APACHE_LITERAL = new WasWebServerType(APACHE, "APACHE", "APACHE"); //$NON-NLS-1$ //$NON-NLS-2$

	/**
	 * The '<em><b>IIS</b></em>' literal object.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see #IIS
	 * @generated
	 * @ordered
	 */
	public static final WasWebServerType IIS_LITERAL = new WasWebServerType(IIS, "IIS", "IIS"); //$NON-NLS-1$ //$NON-NLS-2$

	/**
	 * The '<em><b>DOMINO</b></em>' literal object. <!-- begin-user-doc --> <!-- end-user-doc
	 * -->
	 * 
	 * @see #DOMINO
	 * @generated
	 * @ordered
	 */
	public static final WasWebServerType DOMINO_LITERAL = new WasWebServerType(DOMINO, "DOMINO", "DOMINO"); //$NON-NLS-1$ //$NON-NLS-2$

	/**
	 * The '<em><b>SUNJAVASYSTEM</b></em>' literal object.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @see #SUNJAVASYSTEM
	 * @generated
	 * @ordered
	 */
	public static final WasWebServerType SUNJAVASYSTEM_LITERAL = new WasWebServerType(SUNJAVASYSTEM, "SUNJAVASYSTEM", "SUNJAVASYSTEM"); //$NON-NLS-1$ //$NON-NLS-2$

	/**
	 * The '<em><b>UNKNOWN</b></em>' literal object. <!-- begin-user-doc --> <!-- end-user-doc
	 * -->
	 * 
	 * @see #UNKNOWN
	 * @generated
	 * @ordered
	 */
	public static final WasWebServerType UNKNOWN_LITERAL = new WasWebServerType(UNKNOWN, "UNKNOWN", "UNKNOWN"); //$NON-NLS-1$ //$NON-NLS-2$

	/**
	 * An array of all the '<em><b>Web Server Type</b></em>' enumerators.
	 * <!-- begin-user-doc
	 * --> <!-- end-user-doc -->
	 * @generated
	 */
	private static final WasWebServerType[] VALUES_ARRAY = new WasWebServerType[] {
			IHS_LITERAL,
			APACHE_LITERAL,
			IIS_LITERAL,
			DOMINO_LITERAL,
			SUNJAVASYSTEM_LITERAL,
			UNKNOWN_LITERAL,
		};

	/**
	 * A public read-only list of all the '<em><b>Web Server Type</b></em>' enumerators. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public static final List VALUES = Collections.unmodifiableList(Arrays.asList(VALUES_ARRAY));

	/**
	 * Returns the '<em><b>Web Server Type</b></em>' literal with the specified literal value.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public static WasWebServerType get(String literal) {
		for (int i = 0; i < VALUES_ARRAY.length; ++i) {
			WasWebServerType result = VALUES_ARRAY[i];
			if (result.toString().equals(literal)) {
				return result;
			}
		}
		return null;
	}

	/**
	 * Returns the '<em><b>Web Server Type</b></em>' literal with the specified name. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public static WasWebServerType getByName(String name) {
		for (int i = 0; i < VALUES_ARRAY.length; ++i) {
			WasWebServerType result = VALUES_ARRAY[i];
			if (result.getName().equals(name)) {
				return result;
			}
		}
		return null;
	}

	/**
	 * Returns the '<em><b>Web Server Type</b></em>' literal with the specified integer value.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public static WasWebServerType get(int value) {
		switch (value) {
			case IHS: return IHS_LITERAL;
			case APACHE: return APACHE_LITERAL;
			case IIS: return IIS_LITERAL;
			case DOMINO: return DOMINO_LITERAL;
			case SUNJAVASYSTEM: return SUNJAVASYSTEM_LITERAL;
			case UNKNOWN: return UNKNOWN_LITERAL;
		}
		return null;
	}

	/**
	 * Only this class can construct instances.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	private WasWebServerType(int value, String name, String literal) {
		super(value, name, literal);
	}

} //WasWebServerType
