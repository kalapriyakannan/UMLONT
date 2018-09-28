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
 * <!-- begin-user-doc --> A representation of the literals of the enumeration '<em><b>JMS Destination Type Enum</b></em>',
 * and utility methods for working with them. <!-- end-user-doc -->
 * @see com.ibm.ccl.soa.deploy.was.WasPackage#getJMSDestinationTypeEnum()
 * @model extendedMetaData="name='JMSDestinationTypeEnum'"
 * @generated
 */
public final class JMSDestinationTypeEnum extends AbstractEnumerator {
	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public static final String copyright = "Copyright (c) 2005, 2006 IBM Corporation. Licensed Material - Property of IBM. All rights reserved."; //$NON-NLS-1$

	/**
	 * The '<em><b>Queue</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>Queue</b></em>' literal object isn't clear, there really should
	 * be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #QUEUE_LITERAL
	 * @model name="Queue"
	 * @generated
	 * @ordered
	 */
	public static final int QUEUE = 0;

	/**
	 * The '<em><b>Topic</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>Topic</b></em>' literal object isn't clear, there really should
	 * be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #TOPIC_LITERAL
	 * @model name="Topic"
	 * @generated
	 * @ordered
	 */
	public static final int TOPIC = 1;

	/**
	 * The '<em><b>Queue</b></em>' literal object.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see #QUEUE
	 * @generated
	 * @ordered
	 */
	public static final JMSDestinationTypeEnum QUEUE_LITERAL = new JMSDestinationTypeEnum(QUEUE, "Queue", "Queue"); //$NON-NLS-1$ //$NON-NLS-2$

	/**
	 * The '<em><b>Topic</b></em>' literal object.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see #TOPIC
	 * @generated
	 * @ordered
	 */
	public static final JMSDestinationTypeEnum TOPIC_LITERAL = new JMSDestinationTypeEnum(TOPIC, "Topic", "Topic"); //$NON-NLS-1$ //$NON-NLS-2$

	/**
	 * An array of all the '<em><b>JMS Destination Type Enum</b></em>' enumerators. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	private static final JMSDestinationTypeEnum[] VALUES_ARRAY = new JMSDestinationTypeEnum[] {
			QUEUE_LITERAL,
			TOPIC_LITERAL,
		};

	/**
	 * A public read-only list of all the '<em><b>JMS Destination Type Enum</b></em>' enumerators.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public static final List VALUES = Collections.unmodifiableList(Arrays.asList(VALUES_ARRAY));

	/**
	 * Returns the '<em><b>JMS Destination Type Enum</b></em>' literal with the specified literal value.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public static JMSDestinationTypeEnum get(String literal) {
		for (int i = 0; i < VALUES_ARRAY.length; ++i) {
			JMSDestinationTypeEnum result = VALUES_ARRAY[i];
			if (result.toString().equals(literal)) {
				return result;
			}
		}
		return null;
	}

	/**
	 * Returns the '<em><b>JMS Destination Type Enum</b></em>' literal with the specified name.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public static JMSDestinationTypeEnum getByName(String name) {
		for (int i = 0; i < VALUES_ARRAY.length; ++i) {
			JMSDestinationTypeEnum result = VALUES_ARRAY[i];
			if (result.getName().equals(name)) {
				return result;
			}
		}
		return null;
	}

	/**
	 * Returns the '<em><b>JMS Destination Type Enum</b></em>' literal with the specified integer value.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public static JMSDestinationTypeEnum get(int value) {
		switch (value) {
			case QUEUE: return QUEUE_LITERAL;
			case TOPIC: return TOPIC_LITERAL;
		}
		return null;
	}

	/**
	 * Only this class can construct instances.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	private JMSDestinationTypeEnum(int value, String name, String literal) {
		super(value, name, literal);
	}

} //JMSDestinationTypeEnum
