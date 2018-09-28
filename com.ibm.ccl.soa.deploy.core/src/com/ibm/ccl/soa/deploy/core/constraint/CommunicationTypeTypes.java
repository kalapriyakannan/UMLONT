/**
 * Copyright (c) 2005, 2006 IBM Corporation. Licensed Material - Property of IBM. All rights reserved.
 *
 * $Id: CommunicationTypeTypes.java,v 1.1 2007/12/21 15:46:14 kalantar Exp $
 */
package com.ibm.ccl.soa.deploy.core.constraint;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.eclipse.emf.common.util.AbstractEnumerator;

/**
 * <!-- begin-user-doc -->
 * A representation of the literals of the enumeration '<em><b>Communication Type Types</b></em>',
 * and utility methods for working with them.
 * <!-- end-user-doc -->
 * <!-- begin-model-doc -->
 * 
 * 				The types of communication links: 'LAN', 'WAN', ...
 * 			
 * <!-- end-model-doc -->
 * @see com.ibm.ccl.soa.deploy.core.constraint.ConstraintPackage#getCommunicationTypeTypes()
 * @model extendedMetaData="name='CommunicationTypeTypes'"
 * @generated
 */
public final class CommunicationTypeTypes extends AbstractEnumerator {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final String copyright = "Copyright (c) 2005, 2006 IBM Corporation. Licensed Material - Property of IBM. All rights reserved."; //$NON-NLS-1$

	/**
	 * The '<em><b>LAN</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * 
	 * 				Represents a LAN connection.
	 * 			
	 * <!-- end-model-doc -->
	 * @see #LAN_LITERAL
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int LAN = 0;

	/**
	 * The '<em><b>WAN</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * 
	 * 				Represents a WAN connection.
	 * 			
	 * <!-- end-model-doc -->
	 * @see #WAN_LITERAL
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int WAN = 1;

	/**
	 * The '<em><b>LAN</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #LAN
	 * @generated
	 * @ordered
	 */
	public static final CommunicationTypeTypes LAN_LITERAL = new CommunicationTypeTypes(LAN, "LAN", "LAN"); //$NON-NLS-1$ //$NON-NLS-2$

	/**
	 * The '<em><b>WAN</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #WAN
	 * @generated
	 * @ordered
	 */
	public static final CommunicationTypeTypes WAN_LITERAL = new CommunicationTypeTypes(WAN, "WAN", "WAN"); //$NON-NLS-1$ //$NON-NLS-2$

	/**
	 * An array of all the '<em><b>Communication Type Types</b></em>' enumerators.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private static final CommunicationTypeTypes[] VALUES_ARRAY =
		new CommunicationTypeTypes[] {
			LAN_LITERAL,
			WAN_LITERAL,
		};

	/**
	 * A public read-only list of all the '<em><b>Communication Type Types</b></em>' enumerators.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final List VALUES = Collections.unmodifiableList(Arrays.asList(VALUES_ARRAY));

	/**
	 * Returns the '<em><b>Communication Type Types</b></em>' literal with the specified literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static CommunicationTypeTypes get(String literal) {
		for (int i = 0; i < VALUES_ARRAY.length; ++i) {
			CommunicationTypeTypes result = VALUES_ARRAY[i];
			if (result.toString().equals(literal)) {
				return result;
			}
		}
		return null;
	}

	/**
	 * Returns the '<em><b>Communication Type Types</b></em>' literal with the specified name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static CommunicationTypeTypes getByName(String name) {
		for (int i = 0; i < VALUES_ARRAY.length; ++i) {
			CommunicationTypeTypes result = VALUES_ARRAY[i];
			if (result.getName().equals(name)) {
				return result;
			}
		}
		return null;
	}

	/**
	 * Returns the '<em><b>Communication Type Types</b></em>' literal with the specified integer value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static CommunicationTypeTypes get(int value) {
		switch (value) {
			case LAN: return LAN_LITERAL;
			case WAN: return WAN_LITERAL;
		}
		return null;
	}

	/**
	 * Only this class can construct instances.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private CommunicationTypeTypes(int value, String name, String literal) {
		super(value, name, literal);
	}

} //CommunicationTypeTypes
