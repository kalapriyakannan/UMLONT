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
 * <!-- begin-user-doc --> A representation of the literals of the enumeration '<em><b>Application Map</b></em>',
 * and utility methods for working with them. <!-- end-user-doc --> <!-- begin-model-doc -->
 * 
 * 
 * <!-- end-model-doc -->
 * 
 * @see com.ibm.ccl.soa.deploy.was.WasPackage#getWasApplicationMap()
 * @model
 * @generated
 */
public final class WasApplicationMap extends AbstractEnumerator {
	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public static final String copyright = "Copyright (c) 2005, 2006 IBM Corporation. Licensed Material - Property of IBM. All rights reserved."; //$NON-NLS-1$

	/**
	 * The '<em><b>MAPNONE</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>MAPNONE</b></em>' literal object isn't clear, there really
	 * should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #MAPNONE_LITERAL
	 * @model literal="MAP_NONE"
	 * @generated
	 * @ordered
	 */
	public static final int MAPNONE = 0;

	/**
	 * The '<em><b>MAPDEFAULT</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>MAPDEFAULT</b></em>' literal object isn't clear, there really
	 * should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #MAPDEFAULT_LITERAL
	 * @model literal="MAP_DEFAULT"
	 * @generated
	 * @ordered
	 */
	public static final int MAPDEFAULT = 1;

	/**
	 * The '<em><b>MAPALL</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>MAPALL</b></em>' literal object isn't clear, there really
	 * should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #MAPALL_LITERAL
	 * @model literal="MAP_ALL"
	 * @generated
	 * @ordered
	 */
	public static final int MAPALL = 2;

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
	public static final int UNKNOWN = 3;

	/**
	 * The '<em><b>MAPNONE</b></em>' literal object. <!-- begin-user-doc --> <!-- end-user-doc
	 * -->
	 * 
	 * @see #MAPNONE
	 * @generated
	 * @ordered
	 */
	public static final WasApplicationMap MAPNONE_LITERAL = new WasApplicationMap(MAPNONE, "MAPNONE", "MAP_NONE"); //$NON-NLS-1$ //$NON-NLS-2$

	/**
	 * The '<em><b>MAPDEFAULT</b></em>' literal object.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @see #MAPDEFAULT
	 * @generated
	 * @ordered
	 */
	public static final WasApplicationMap MAPDEFAULT_LITERAL = new WasApplicationMap(MAPDEFAULT, "MAPDEFAULT", "MAP_DEFAULT"); //$NON-NLS-1$ //$NON-NLS-2$

	/**
	 * The '<em><b>MAPALL</b></em>' literal object. <!-- begin-user-doc --> <!-- end-user-doc
	 * -->
	 * 
	 * @see #MAPALL
	 * @generated
	 * @ordered
	 */
	public static final WasApplicationMap MAPALL_LITERAL = new WasApplicationMap(MAPALL, "MAPALL", "MAP_ALL"); //$NON-NLS-1$ //$NON-NLS-2$

	/**
	 * The '<em><b>UNKNOWN</b></em>' literal object. <!-- begin-user-doc --> <!-- end-user-doc
	 * -->
	 * 
	 * @see #UNKNOWN
	 * @generated
	 * @ordered
	 */
	public static final WasApplicationMap UNKNOWN_LITERAL = new WasApplicationMap(UNKNOWN, "UNKNOWN", "UNKNOWN"); //$NON-NLS-1$ //$NON-NLS-2$

	/**
	 * An array of all the '<em><b>Application Map</b></em>' enumerators.
	 * <!-- begin-user-doc
	 * --> <!-- end-user-doc -->
	 * @generated
	 */
	private static final WasApplicationMap[] VALUES_ARRAY = new WasApplicationMap[] {
			MAPNONE_LITERAL,
			MAPDEFAULT_LITERAL,
			MAPALL_LITERAL,
			UNKNOWN_LITERAL,
		};

	/**
	 * A public read-only list of all the '<em><b>Application Map</b></em>' enumerators. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public static final List VALUES = Collections.unmodifiableList(Arrays.asList(VALUES_ARRAY));

	/**
	 * Returns the '<em><b>Application Map</b></em>' literal with the specified literal value.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public static WasApplicationMap get(String literal) {
		for (int i = 0; i < VALUES_ARRAY.length; ++i) {
			WasApplicationMap result = VALUES_ARRAY[i];
			if (result.toString().equals(literal)) {
				return result;
			}
		}
		return null;
	}

	/**
	 * Returns the '<em><b>Application Map</b></em>' literal with the specified name. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public static WasApplicationMap getByName(String name) {
		for (int i = 0; i < VALUES_ARRAY.length; ++i) {
			WasApplicationMap result = VALUES_ARRAY[i];
			if (result.getName().equals(name)) {
				return result;
			}
		}
		return null;
	}

	/**
	 * Returns the '<em><b>Application Map</b></em>' literal with the specified integer value.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public static WasApplicationMap get(int value) {
		switch (value) {
			case MAPNONE: return MAPNONE_LITERAL;
			case MAPDEFAULT: return MAPDEFAULT_LITERAL;
			case MAPALL: return MAPALL_LITERAL;
			case UNKNOWN: return UNKNOWN_LITERAL;
		}
		return null;
	}

	/**
	 * Only this class can construct instances.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	private WasApplicationMap(int value, String name, String literal) {
		super(value, name, literal);
	}

} //WasApplicationMap
