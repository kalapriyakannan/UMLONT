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
 * <!-- begin-user-doc --> A representation of the literals of the enumeration '<em><b>Destination Type Enum</b></em>',
 * and utility methods for working with them. <!-- end-user-doc -->
 * @see com.ibm.ccl.soa.deploy.j2ee.jms.JmsPackage#getDestinationTypeEnum()
 * @model extendedMetaData="name='DestinationTypeEnum'"
 * @generated
 */
public final class DestinationTypeEnum extends AbstractEnumerator {
	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public static final String copyright = "Copyright (c) 2005, 2006 IBM Corporation. Licensed Material - Property of IBM. All rights reserved."; //$NON-NLS-1$

	/**
	 * The '<em><b>Javax Jms Queue</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>Javax Jms Queue</b></em>' literal object isn't clear, there
	 * really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #JAVAX_JMS_QUEUE_LITERAL
	 * @model name="javaxJmsQueue" literal="javax.jms.Queue"
	 * @generated
	 * @ordered
	 */
	public static final int JAVAX_JMS_QUEUE = 0;

	/**
	 * The '<em><b>Javax Jms Topic</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>Javax Jms Topic</b></em>' literal object isn't clear, there
	 * really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #JAVAX_JMS_TOPIC_LITERAL
	 * @model name="javaxJmsTopic" literal="javax.jms.Topic"
	 * @generated
	 * @ordered
	 */
	public static final int JAVAX_JMS_TOPIC = 1;

	/**
	 * The '<em><b>Javax Jms Queue</b></em>' literal object.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @see #JAVAX_JMS_QUEUE
	 * @generated
	 * @ordered
	 */
	public static final DestinationTypeEnum JAVAX_JMS_QUEUE_LITERAL = new DestinationTypeEnum(JAVAX_JMS_QUEUE, "javaxJmsQueue", "javax.jms.Queue"); //$NON-NLS-1$ //$NON-NLS-2$

	/**
	 * The '<em><b>Javax Jms Topic</b></em>' literal object.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @see #JAVAX_JMS_TOPIC
	 * @generated
	 * @ordered
	 */
	public static final DestinationTypeEnum JAVAX_JMS_TOPIC_LITERAL = new DestinationTypeEnum(JAVAX_JMS_TOPIC, "javaxJmsTopic", "javax.jms.Topic"); //$NON-NLS-1$ //$NON-NLS-2$

	/**
	 * An array of all the '<em><b>Destination Type Enum</b></em>' enumerators. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	private static final DestinationTypeEnum[] VALUES_ARRAY = new DestinationTypeEnum[] {
			JAVAX_JMS_QUEUE_LITERAL,
			JAVAX_JMS_TOPIC_LITERAL,
		};

	/**
	 * A public read-only list of all the '<em><b>Destination Type Enum</b></em>' enumerators.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public static final List VALUES = Collections.unmodifiableList(Arrays.asList(VALUES_ARRAY));

	/**
	 * Returns the '<em><b>Destination Type Enum</b></em>' literal with the specified literal value.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public static DestinationTypeEnum get(String literal) {
		for (int i = 0; i < VALUES_ARRAY.length; ++i) {
			DestinationTypeEnum result = VALUES_ARRAY[i];
			if (result.toString().equals(literal)) {
				return result;
			}
		}
		return null;
	}

	/**
	 * Returns the '<em><b>Destination Type Enum</b></em>' literal with the specified name. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public static DestinationTypeEnum getByName(String name) {
		for (int i = 0; i < VALUES_ARRAY.length; ++i) {
			DestinationTypeEnum result = VALUES_ARRAY[i];
			if (result.getName().equals(name)) {
				return result;
			}
		}
		return null;
	}

	/**
	 * Returns the '<em><b>Destination Type Enum</b></em>' literal with the specified integer value.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public static DestinationTypeEnum get(int value) {
		switch (value) {
			case JAVAX_JMS_QUEUE: return JAVAX_JMS_QUEUE_LITERAL;
			case JAVAX_JMS_TOPIC: return JAVAX_JMS_TOPIC_LITERAL;
		}
		return null;
	}

	/**
	 * Only this class can construct instances.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	private DestinationTypeEnum(int value, String name, String literal) {
		super(value, name, literal);
	}

} //DestinationTypeEnum
