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
 * <!-- begin-user-doc --> A representation of the literals of the enumeration '<em><b>End Point Listener Name Enum</b></em>',
 * and utility methods for working with them. <!-- end-user-doc -->
 * @see com.ibm.ccl.soa.deploy.was.WasPackage#getEndPointListenerNameEnum()
 * @model extendedMetaData="name='EndPointListenerNameEnum'"
 * @generated
 */
public final class EndPointListenerNameEnum extends AbstractEnumerator {
	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public static final String copyright = "Copyright (c) 2005, 2006 IBM Corporation. Licensed Material - Property of IBM. All rights reserved."; //$NON-NLS-1$

	/**
	 * The '<em><b>SOAPHTTP Channel1</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>SOAPHTTP Channel1</b></em>' literal object isn't clear, there
	 * really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #SOAPHTTP_CHANNEL1_LITERAL
	 * @model name="SOAPHTTPChannel1"
	 * @generated
	 * @ordered
	 */
	public static final int SOAPHTTP_CHANNEL1 = 0;

	/**
	 * The '<em><b>SOAPHTTP Channel2</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>SOAPHTTP Channel2</b></em>' literal object isn't clear, there
	 * really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #SOAPHTTP_CHANNEL2_LITERAL
	 * @model name="SOAPHTTPChannel2"
	 * @generated
	 * @ordered
	 */
	public static final int SOAPHTTP_CHANNEL2 = 1;

	/**
	 * The '<em><b>SOAPJMS Channel1</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>SOAPJMS Channel1</b></em>' literal object isn't clear, there
	 * really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #SOAPJMS_CHANNEL1_LITERAL
	 * @model name="SOAPJMSChannel1"
	 * @generated
	 * @ordered
	 */
	public static final int SOAPJMS_CHANNEL1 = 2;

	/**
	 * The '<em><b>SOAPJMS Channel2</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>SOAPJMS Channel2</b></em>' literal object isn't clear, there
	 * really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #SOAPJMS_CHANNEL2_LITERAL
	 * @model name="SOAPJMSChannel2"
	 * @generated
	 * @ordered
	 */
	public static final int SOAPJMS_CHANNEL2 = 3;

	/**
	 * The '<em><b>SOAPHTTP Channel1</b></em>' literal object.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @see #SOAPHTTP_CHANNEL1
	 * @generated
	 * @ordered
	 */
	public static final EndPointListenerNameEnum SOAPHTTP_CHANNEL1_LITERAL = new EndPointListenerNameEnum(SOAPHTTP_CHANNEL1, "SOAPHTTPChannel1", "SOAPHTTPChannel1"); //$NON-NLS-1$ //$NON-NLS-2$

	/**
	 * The '<em><b>SOAPHTTP Channel2</b></em>' literal object.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @see #SOAPHTTP_CHANNEL2
	 * @generated
	 * @ordered
	 */
	public static final EndPointListenerNameEnum SOAPHTTP_CHANNEL2_LITERAL = new EndPointListenerNameEnum(SOAPHTTP_CHANNEL2, "SOAPHTTPChannel2", "SOAPHTTPChannel2"); //$NON-NLS-1$ //$NON-NLS-2$

	/**
	 * The '<em><b>SOAPJMS Channel1</b></em>' literal object.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @see #SOAPJMS_CHANNEL1
	 * @generated
	 * @ordered
	 */
	public static final EndPointListenerNameEnum SOAPJMS_CHANNEL1_LITERAL = new EndPointListenerNameEnum(SOAPJMS_CHANNEL1, "SOAPJMSChannel1", "SOAPJMSChannel1"); //$NON-NLS-1$ //$NON-NLS-2$

	/**
	 * The '<em><b>SOAPJMS Channel2</b></em>' literal object.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @see #SOAPJMS_CHANNEL2
	 * @generated
	 * @ordered
	 */
	public static final EndPointListenerNameEnum SOAPJMS_CHANNEL2_LITERAL = new EndPointListenerNameEnum(SOAPJMS_CHANNEL2, "SOAPJMSChannel2", "SOAPJMSChannel2"); //$NON-NLS-1$ //$NON-NLS-2$

	/**
	 * An array of all the '<em><b>End Point Listener Name Enum</b></em>' enumerators. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	private static final EndPointListenerNameEnum[] VALUES_ARRAY = new EndPointListenerNameEnum[] {
			SOAPHTTP_CHANNEL1_LITERAL,
			SOAPHTTP_CHANNEL2_LITERAL,
			SOAPJMS_CHANNEL1_LITERAL,
			SOAPJMS_CHANNEL2_LITERAL,
		};

	/**
	 * A public read-only list of all the '<em><b>End Point Listener Name Enum</b></em>' enumerators.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public static final List VALUES = Collections.unmodifiableList(Arrays.asList(VALUES_ARRAY));

	/**
	 * Returns the '<em><b>End Point Listener Name Enum</b></em>' literal with the specified literal value.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public static EndPointListenerNameEnum get(String literal) {
		for (int i = 0; i < VALUES_ARRAY.length; ++i) {
			EndPointListenerNameEnum result = VALUES_ARRAY[i];
			if (result.toString().equals(literal)) {
				return result;
			}
		}
		return null;
	}

	/**
	 * Returns the '<em><b>End Point Listener Name Enum</b></em>' literal with the specified name.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public static EndPointListenerNameEnum getByName(String name) {
		for (int i = 0; i < VALUES_ARRAY.length; ++i) {
			EndPointListenerNameEnum result = VALUES_ARRAY[i];
			if (result.getName().equals(name)) {
				return result;
			}
		}
		return null;
	}

	/**
	 * Returns the '<em><b>End Point Listener Name Enum</b></em>' literal with the specified integer value.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public static EndPointListenerNameEnum get(int value) {
		switch (value) {
			case SOAPHTTP_CHANNEL1: return SOAPHTTP_CHANNEL1_LITERAL;
			case SOAPHTTP_CHANNEL2: return SOAPHTTP_CHANNEL2_LITERAL;
			case SOAPJMS_CHANNEL1: return SOAPJMS_CHANNEL1_LITERAL;
			case SOAPJMS_CHANNEL2: return SOAPJMS_CHANNEL2_LITERAL;
		}
		return null;
	}

	/**
	 * Only this class can construct instances.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	private EndPointListenerNameEnum(int value, String name, String literal) {
		super(value, name, literal);
	}

} //EndPointListenerNameEnum
