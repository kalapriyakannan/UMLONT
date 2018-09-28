/*******************************************************************************
 * Copyright (c) 2003, 2007 IBM Corporation Licensed Material - Property of IBM. All rights reserved.
 *  
 * US Government Users Restricted Rights - Use, duplication or disclosure v1.0 restricted by GSA ADP
 * Schedule Contract with IBM Corp.
 * 
 * Contributors: IBM Corporation - initial API and implementation
 *******************************************************************************/
package com.ibm.ccl.soa.deploy.os;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.eclipse.emf.common.util.AbstractEnumerator;

/**
 * <!-- begin-user-doc --> A representation of the literals of the enumeration '<em><b>Transport Layer Protocol Type</b></em>',
 * and utility methods for working with them. <!-- end-user-doc -->
 * @see com.ibm.ccl.soa.deploy.os.OsPackage#getTransportLayerProtocolType()
 * @model extendedMetaData="name='TransportLayerProtocolType'"
 * @generated
 */
public final class TransportLayerProtocolType extends AbstractEnumerator {
	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public static final String copyright = "Copyright (c) 2005, 2006 IBM Corporation. Licensed Material - Property of IBM. All rights reserved."; //$NON-NLS-1$

	/**
	 * The '<em><b>TCP</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>TCP</b></em>' literal object isn't clear, there really should
	 * be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #TCP_LITERAL
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int TCP = 0;

	/**
	 * The '<em><b>UDP</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>UDP</b></em>' literal object isn't clear, there really should
	 * be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #UDP_LITERAL
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int UDP = 1;

	/**
	 * The '<em><b>DCCP</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>DCCP</b></em>' literal object isn't clear, there really should
	 * be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #DCCP_LITERAL
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int DCCP = 2;

	/**
	 * The '<em><b>SCTP</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>SCTP</b></em>' literal object isn't clear, there really should
	 * be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #SCTP_LITERAL
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int SCTP = 3;

	/**
	 * The '<em><b>IL</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>IL</b></em>' literal object isn't clear, there really should be
	 * more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #IL_LITERAL
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int IL = 4;

	/**
	 * The '<em><b>RUDP</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>RUDP</b></em>' literal object isn't clear, there really should
	 * be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #RUDP_LITERAL
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int RUDP = 5;

	/**
	 * The '<em><b>TCP</b></em>' literal object.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see #TCP
	 * @generated
	 * @ordered
	 */
	public static final TransportLayerProtocolType TCP_LITERAL = new TransportLayerProtocolType(TCP,
			"TCP", "TCP"); //$NON-NLS-1$ //$NON-NLS-2$

	/**
	 * The '<em><b>UDP</b></em>' literal object.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see #UDP
	 * @generated
	 * @ordered
	 */
	public static final TransportLayerProtocolType UDP_LITERAL = new TransportLayerProtocolType(UDP,
			"UDP", "UDP"); //$NON-NLS-1$ //$NON-NLS-2$

	/**
	 * The '<em><b>DCCP</b></em>' literal object.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see #DCCP
	 * @generated
	 * @ordered
	 */
	public static final TransportLayerProtocolType DCCP_LITERAL = new TransportLayerProtocolType(
			DCCP, "DCCP", "DCCP"); //$NON-NLS-1$ //$NON-NLS-2$

	/**
	 * The '<em><b>SCTP</b></em>' literal object.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see #SCTP
	 * @generated
	 * @ordered
	 */
	public static final TransportLayerProtocolType SCTP_LITERAL = new TransportLayerProtocolType(
			SCTP, "SCTP", "SCTP"); //$NON-NLS-1$ //$NON-NLS-2$

	/**
	 * The '<em><b>IL</b></em>' literal object.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see #IL
	 * @generated
	 * @ordered
	 */
	public static final TransportLayerProtocolType IL_LITERAL = new TransportLayerProtocolType(IL,
			"IL", "IL"); //$NON-NLS-1$ //$NON-NLS-2$

	/**
	 * The '<em><b>RUDP</b></em>' literal object.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see #RUDP
	 * @generated
	 * @ordered
	 */
	public static final TransportLayerProtocolType RUDP_LITERAL = new TransportLayerProtocolType(
			RUDP, "RUDP", "RUDP"); //$NON-NLS-1$ //$NON-NLS-2$

	/**
	 * An array of all the '<em><b>Transport Layer Protocol Type</b></em>' enumerators. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	private static final TransportLayerProtocolType[] VALUES_ARRAY = new TransportLayerProtocolType[] {
			TCP_LITERAL, UDP_LITERAL, DCCP_LITERAL, SCTP_LITERAL, IL_LITERAL, RUDP_LITERAL, };

	/**
	 * A public read-only list of all the '<em><b>Transport Layer Protocol Type</b></em>' enumerators.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public static final List VALUES = Collections.unmodifiableList(Arrays.asList(VALUES_ARRAY));

	/**
	 * Returns the '<em><b>Transport Layer Protocol Type</b></em>' literal with the specified literal value.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public static TransportLayerProtocolType get(String literal) {
		for (int i = 0; i < VALUES_ARRAY.length; ++i) {
			TransportLayerProtocolType result = VALUES_ARRAY[i];
			if (result.toString().equals(literal)) {
				return result;
			}
		}
		return null;
	}

	/**
	 * Returns the '<em><b>Transport Layer Protocol Type</b></em>' literal with the specified name.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public static TransportLayerProtocolType getByName(String name) {
		for (int i = 0; i < VALUES_ARRAY.length; ++i) {
			TransportLayerProtocolType result = VALUES_ARRAY[i];
			if (result.getName().equals(name)) {
				return result;
			}
		}
		return null;
	}

	/**
	 * Returns the '<em><b>Transport Layer Protocol Type</b></em>' literal with the specified integer value.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public static TransportLayerProtocolType get(int value) {
		switch (value)
		{
		case TCP:
			return TCP_LITERAL;
		case UDP:
			return UDP_LITERAL;
		case DCCP:
			return DCCP_LITERAL;
		case SCTP:
			return SCTP_LITERAL;
		case IL:
			return IL_LITERAL;
		case RUDP:
			return RUDP_LITERAL;
		}
		return null;
	}

	/**
	 * Only this class can construct instances.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	private TransportLayerProtocolType(int value, String name, String literal) {
		super(value, name, literal);
	}

} //TransportLayerProtocolType
