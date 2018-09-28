/*******************************************************************************
 * Copyright (c) 2003, 2007 IBM Corporation Licensed Material - Property of IBM. All rights reserved.
 *  
 * US Government Users Restricted Rights - Use, duplication or disclosure v1.0 restricted by GSA ADP
 * Schedule Contract with IBM Corp.
 * 
 * Contributors: IBM Corporation - initial API and implementation
 *******************************************************************************/
package com.ibm.ccl.soa.deploy.j2ee.jms;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.eclipse.emf.common.util.AbstractEnumerator;

/**
 * <!-- begin-user-doc --> A representation of the literals of the enumeration '<em><b>Acknowledge Mode Enum</b></em>',
 * and utility methods for working with them. <!-- end-user-doc -->
 * @see com.ibm.ccl.soa.deploy.j2ee.jms.JmsPackage#getAcknowledgeModeEnum()
 * @model extendedMetaData="name='AcknowledgeModeEnum'"
 * @generated
 */
public final class AcknowledgeModeEnum extends AbstractEnumerator {
	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public static final String copyright = "Copyright (c) 2005, 2006 IBM Corporation. Licensed Material - Property of IBM. All rights reserved."; //$NON-NLS-1$

	/**
	 * The '<em><b>Auto Acknowledge</b></em>' literal value. <!-- begin-user-doc --> <!--
	 * end-user-doc --> <!-- begin-model-doc -->
	 * 
	 * The session automatically acknowledges the delivery of a message
	 * 
	 * <!-- end-model-doc -->
	 * 
	 * @see #AUTO_ACKNOWLEDGE_LITERAL
	 * @model name="AutoAcknowledge" literal="Auto-acknowledge"
	 * @generated
	 * @ordered
	 */
	public static final int AUTO_ACKNOWLEDGE = 0;

	/**
	 * The '<em><b>Duplicates Ok Auto Acknowledge</b></em>' literal value.
	 * <!-- begin-user-doc
	 * -->
	 * <p>
	 * If the meaning of '<em><b>Duplicates Ok Auto Acknowledge</b></em>' literal object isn't
	 * clear, there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #DUPLICATES_OK_AUTO_ACKNOWLEDGE_LITERAL
	 * @model name="DuplicatesOkAutoAcknowledge" literal="Duplicates-ok auto-acknowledge"
	 * @generated
	 * @ordered
	 */
	public static final int DUPLICATES_OK_AUTO_ACKNOWLEDGE = 1;

	/**
	 * The '<em><b>Non Persistent</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>Non Persistent</b></em>' literal object isn't clear, there
	 * really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #NON_PERSISTENT_LITERAL
	 * @model name="NonPersistent"
	 * @generated
	 * @ordered
	 */
	public static final int NON_PERSISTENT = 2;

	/**
	 * The '<em><b>Auto Acknowledge</b></em>' literal object.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @see #AUTO_ACKNOWLEDGE
	 * @generated
	 * @ordered
	 */
	public static final AcknowledgeModeEnum AUTO_ACKNOWLEDGE_LITERAL = new AcknowledgeModeEnum(AUTO_ACKNOWLEDGE, "AutoAcknowledge", "Auto-acknowledge"); //$NON-NLS-1$ //$NON-NLS-2$

	/**
	 * The '<em><b>Duplicates Ok Auto Acknowledge</b></em>' literal object.
	 * <!-- begin-user-doc
	 * --> <!-- end-user-doc -->
	 * @see #DUPLICATES_OK_AUTO_ACKNOWLEDGE
	 * @generated
	 * @ordered
	 */
	public static final AcknowledgeModeEnum DUPLICATES_OK_AUTO_ACKNOWLEDGE_LITERAL = new AcknowledgeModeEnum(DUPLICATES_OK_AUTO_ACKNOWLEDGE, "DuplicatesOkAutoAcknowledge", "Duplicates-ok auto-acknowledge"); //$NON-NLS-1$ //$NON-NLS-2$

	/**
	 * The '<em><b>Non Persistent</b></em>' literal object.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @see #NON_PERSISTENT
	 * @generated
	 * @ordered
	 */
	public static final AcknowledgeModeEnum NON_PERSISTENT_LITERAL = new AcknowledgeModeEnum(NON_PERSISTENT, "NonPersistent", "NonPersistent"); //$NON-NLS-1$ //$NON-NLS-2$

	/**
	 * An array of all the '<em><b>Acknowledge Mode Enum</b></em>' enumerators. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	private static final AcknowledgeModeEnum[] VALUES_ARRAY = new AcknowledgeModeEnum[] {
			AUTO_ACKNOWLEDGE_LITERAL,
			DUPLICATES_OK_AUTO_ACKNOWLEDGE_LITERAL,
			NON_PERSISTENT_LITERAL,
		};

	/**
	 * A public read-only list of all the '<em><b>Acknowledge Mode Enum</b></em>' enumerators.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public static final List VALUES = Collections.unmodifiableList(Arrays.asList(VALUES_ARRAY));

	/**
	 * Returns the '<em><b>Acknowledge Mode Enum</b></em>' literal with the specified literal value.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public static AcknowledgeModeEnum get(String literal) {
		for (int i = 0; i < VALUES_ARRAY.length; ++i) {
			AcknowledgeModeEnum result = VALUES_ARRAY[i];
			if (result.toString().equals(literal)) {
				return result;
			}
		}
		return null;
	}

	/**
	 * Returns the '<em><b>Acknowledge Mode Enum</b></em>' literal with the specified name. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public static AcknowledgeModeEnum getByName(String name) {
		for (int i = 0; i < VALUES_ARRAY.length; ++i) {
			AcknowledgeModeEnum result = VALUES_ARRAY[i];
			if (result.getName().equals(name)) {
				return result;
			}
		}
		return null;
	}

	/**
	 * Returns the '<em><b>Acknowledge Mode Enum</b></em>' literal with the specified integer value.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public static AcknowledgeModeEnum get(int value) {
		switch (value) {
			case AUTO_ACKNOWLEDGE: return AUTO_ACKNOWLEDGE_LITERAL;
			case DUPLICATES_OK_AUTO_ACKNOWLEDGE: return DUPLICATES_OK_AUTO_ACKNOWLEDGE_LITERAL;
			case NON_PERSISTENT: return NON_PERSISTENT_LITERAL;
		}
		return null;
	}

	/**
	 * Only this class can construct instances.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	private AcknowledgeModeEnum(int value, String name, String literal) {
		super(value, name, literal);
	}

} //AcknowledgeModeEnum
