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
 * <!-- begin-user-doc --> A representation of the literals of the enumeration '<em><b>IIOP Security Protocols</b></em>',
 * and utility methods for working with them. <!-- end-user-doc -->
 * @see com.ibm.ccl.soa.deploy.was.WasPackage#getIIOPSecurityProtocols()
 * @model extendedMetaData="name='IIOPSecurityProtocols'"
 * @generated
 */
public final class IIOPSecurityProtocols extends AbstractEnumerator {
	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public static final String copyright = "Copyright (c) 2005, 2006 IBM Corporation. Licensed Material - Property of IBM. All rights reserved."; //$NON-NLS-1$

	/**
	 * The '<em><b>IBM</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>IBM</b></em>' literal object isn't clear, there really should
	 * be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #IBM_LITERAL
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int IBM = 0;

	/**
	 * The '<em><b>CSI</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>CSI</b></em>' literal object isn't clear, there really should
	 * be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #CSI_LITERAL
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int CSI = 1;

	/**
	 * The '<em><b>BOTH</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>BOTH</b></em>' literal object isn't clear, there really should
	 * be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #BOTH_LITERAL
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int BOTH = 2;

	/**
	 * The '<em><b>Other</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>Other</b></em>' literal object isn't clear, there really should
	 * be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #OTHER_LITERAL
	 * @model name="other"
	 * @generated
	 * @ordered
	 */
	public static final int OTHER = 3;

	/**
	 * The '<em><b>IBM</b></em>' literal object.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see #IBM
	 * @generated
	 * @ordered
	 */
	public static final IIOPSecurityProtocols IBM_LITERAL = new IIOPSecurityProtocols(IBM, "IBM", "IBM"); //$NON-NLS-1$ //$NON-NLS-2$

	/**
	 * The '<em><b>CSI</b></em>' literal object.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see #CSI
	 * @generated
	 * @ordered
	 */
	public static final IIOPSecurityProtocols CSI_LITERAL = new IIOPSecurityProtocols(CSI, "CSI", "CSI"); //$NON-NLS-1$ //$NON-NLS-2$

	/**
	 * The '<em><b>BOTH</b></em>' literal object.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see #BOTH
	 * @generated
	 * @ordered
	 */
	public static final IIOPSecurityProtocols BOTH_LITERAL = new IIOPSecurityProtocols(BOTH, "BOTH", "BOTH"); //$NON-NLS-1$ //$NON-NLS-2$

	/**
	 * The '<em><b>Other</b></em>' literal object.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see #OTHER
	 * @generated
	 * @ordered
	 */
	public static final IIOPSecurityProtocols OTHER_LITERAL = new IIOPSecurityProtocols(OTHER, "other", "other"); //$NON-NLS-1$ //$NON-NLS-2$

	/**
	 * An array of all the '<em><b>IIOP Security Protocols</b></em>' enumerators. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	private static final IIOPSecurityProtocols[] VALUES_ARRAY = new IIOPSecurityProtocols[] {
			IBM_LITERAL,
			CSI_LITERAL,
			BOTH_LITERAL,
			OTHER_LITERAL,
		};

	/**
	 * A public read-only list of all the '<em><b>IIOP Security Protocols</b></em>' enumerators.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public static final List VALUES = Collections.unmodifiableList(Arrays.asList(VALUES_ARRAY));

	/**
	 * Returns the '<em><b>IIOP Security Protocols</b></em>' literal with the specified literal value.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public static IIOPSecurityProtocols get(String literal) {
		for (int i = 0; i < VALUES_ARRAY.length; ++i) {
			IIOPSecurityProtocols result = VALUES_ARRAY[i];
			if (result.toString().equals(literal)) {
				return result;
			}
		}
		return null;
	}

	/**
	 * Returns the '<em><b>IIOP Security Protocols</b></em>' literal with the specified name.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public static IIOPSecurityProtocols getByName(String name) {
		for (int i = 0; i < VALUES_ARRAY.length; ++i) {
			IIOPSecurityProtocols result = VALUES_ARRAY[i];
			if (result.getName().equals(name)) {
				return result;
			}
		}
		return null;
	}

	/**
	 * Returns the '<em><b>IIOP Security Protocols</b></em>' literal with the specified integer value.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public static IIOPSecurityProtocols get(int value) {
		switch (value) {
			case IBM: return IBM_LITERAL;
			case CSI: return CSI_LITERAL;
			case BOTH: return BOTH_LITERAL;
			case OTHER: return OTHER_LITERAL;
		}
		return null;
	}

	/**
	 * Only this class can construct instances.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	private IIOPSecurityProtocols(int value, String name, String literal) {
		super(value, name, literal);
	}

} //IIOPSecurityProtocols
