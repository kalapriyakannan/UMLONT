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
 * <!-- begin-user-doc --> A representation of the literals of the enumeration '<em><b>Message Reliability Enum</b></em>',
 * and utility methods for working with them. <!-- end-user-doc -->
 * @see com.ibm.ccl.soa.deploy.was.WasPackage#getMessageReliabilityEnum()
 * @model extendedMetaData="name='MessageReliabilityEnum'"
 * @generated
 */
public final class MessageReliabilityEnum extends AbstractEnumerator {
	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public static final String copyright = "Copyright (c) 2005, 2006 IBM Corporation. Licensed Material - Property of IBM. All rights reserved."; //$NON-NLS-1$

	/**
	 * The '<em><b>None</b></em>' literal value.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * 
	 *                 There is no message reliability for nonpersistent messages. If a nonpersistent message cannot be delivered, it is discarded.
	 * 			
	 * <!-- end-model-doc -->
	 * @see #NONE_LITERAL
	 * @model name="None"
	 * @generated
	 * @ordered
	 */
	public static final int NONE = 0;

	/**
	 * The '<em><b>Best Effort Nonpersistent</b></em>' literal value. <!-- begin-user-doc -->
	 * <!-- end-user-doc --> <!-- begin-model-doc -->
	 * 
	 * Messages are never written to disk, and are thrown away if memory cache overruns.
	 * 
	 * <!-- end-model-doc -->
	 * 
	 * @see #BEST_EFFORT_NONPERSISTENT_LITERAL
	 * @model name="BestEffortNonpersistent" literal="Best effort nonpersistent"
	 * @generated
	 * @ordered
	 */
	public static final int BEST_EFFORT_NONPERSISTENT = 1;

	/**
	 * The '<em><b>Express Nonpersistent</b></em>' literal value. <!-- begin-user-doc --> <!--
	 * end-user-doc --> <!-- begin-model-doc -->
	 * 
	 * Messages are written asynchronously to persistent storage if memory cache overruns, but are
	 * not kept over server restarts.
	 * 
	 * <!-- end-model-doc -->
	 * 
	 * @see #EXPRESS_NONPERSISTENT_LITERAL
	 * @model name="ExpressNonpersistent" literal="Express nonpersistent"
	 * @generated
	 * @ordered
	 */
	public static final int EXPRESS_NONPERSISTENT = 2;

	/**
	 * The '<em><b>Reliable Nonpersistent</b></em>' literal value. <!-- begin-user-doc --> <!--
	 * end-user-doc --> <!-- begin-model-doc -->
	 * 
	 * Messages can be lost if a messaging engine fails, and can be lost under normal operating
	 * conditions.
	 * 
	 * <!-- end-model-doc -->
	 * 
	 * @see #RELIABLE_NONPERSISTENT_LITERAL
	 * @model name="ReliableNonpersistent" literal="Reliable nonpersistent"
	 * @generated
	 * @ordered
	 */
	public static final int RELIABLE_NONPERSISTENT = 3;

	/**
	 * The '<em><b>Reliable Persistent</b></em>' literal value. <!-- begin-user-doc --> <!--
	 * end-user-doc --> <!-- begin-model-doc -->
	 * 
	 * Messages can be lost if a messaging engine fails, but are not lost under normal operating
	 * conditions.
	 * 
	 * <!-- end-model-doc -->
	 * 
	 * @see #RELIABLE_PERSISTENT_LITERAL
	 * @model name="ReliablePersistent" literal="Reliable persistent"
	 * @generated
	 * @ordered
	 */
	public static final int RELIABLE_PERSISTENT = 4;

	/**
	 * The '<em><b>Assured Persistent</b></em>' literal value. <!-- begin-user-doc --> <!--
	 * end-user-doc --> <!-- begin-model-doc -->
	 * 
	 * Highest degree of reliability where assured message delivery is supported.
	 * 
	 * <!-- end-model-doc -->
	 * 
	 * @see #ASSURED_PERSISTENT_LITERAL
	 * @model name="AssuredPersistent" literal="Assured persistent"
	 * @generated
	 * @ordered
	 */
	public static final int ASSURED_PERSISTENT = 5;

	/**
	 * The '<em><b>As Bus Destination</b></em>' literal value. <!-- begin-user-doc --> <!--
	 * end-user-doc --> <!-- begin-model-doc -->
	 * 
	 * Use the delivery option configured for the bus destination.
	 * 
	 * <!-- end-model-doc -->
	 * 
	 * @see #AS_BUS_DESTINATION_LITERAL
	 * @model name="AsBusDestination" literal="As Bus destination"
	 * @generated
	 * @ordered
	 */
	public static final int AS_BUS_DESTINATION = 6;

	/**
	 * The '<em><b>None</b></em>' literal object.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see #NONE
	 * @generated
	 * @ordered
	 */
	public static final MessageReliabilityEnum NONE_LITERAL = new MessageReliabilityEnum(NONE, "None", "None"); //$NON-NLS-1$ //$NON-NLS-2$

	/**
	 * The '<em><b>Best Effort Nonpersistent</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #BEST_EFFORT_NONPERSISTENT
	 * @generated
	 * @ordered
	 */
	public static final MessageReliabilityEnum BEST_EFFORT_NONPERSISTENT_LITERAL = new MessageReliabilityEnum(BEST_EFFORT_NONPERSISTENT, "BestEffortNonpersistent", "Best effort nonpersistent"); //$NON-NLS-1$ //$NON-NLS-2$

	/**
	 * The '<em><b>Express Nonpersistent</b></em>' literal object.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @see #EXPRESS_NONPERSISTENT
	 * @generated
	 * @ordered
	 */
	public static final MessageReliabilityEnum EXPRESS_NONPERSISTENT_LITERAL = new MessageReliabilityEnum(EXPRESS_NONPERSISTENT, "ExpressNonpersistent", "Express nonpersistent"); //$NON-NLS-1$ //$NON-NLS-2$

	/**
	 * The '<em><b>Reliable Nonpersistent</b></em>' literal object.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @see #RELIABLE_NONPERSISTENT
	 * @generated
	 * @ordered
	 */
	public static final MessageReliabilityEnum RELIABLE_NONPERSISTENT_LITERAL = new MessageReliabilityEnum(RELIABLE_NONPERSISTENT, "ReliableNonpersistent", "Reliable nonpersistent"); //$NON-NLS-1$ //$NON-NLS-2$

	/**
	 * The '<em><b>Reliable Persistent</b></em>' literal object.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @see #RELIABLE_PERSISTENT
	 * @generated
	 * @ordered
	 */
	public static final MessageReliabilityEnum RELIABLE_PERSISTENT_LITERAL = new MessageReliabilityEnum(RELIABLE_PERSISTENT, "ReliablePersistent", "Reliable persistent"); //$NON-NLS-1$ //$NON-NLS-2$

	/**
	 * The '<em><b>Assured Persistent</b></em>' literal object.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @see #ASSURED_PERSISTENT
	 * @generated
	 * @ordered
	 */
	public static final MessageReliabilityEnum ASSURED_PERSISTENT_LITERAL = new MessageReliabilityEnum(ASSURED_PERSISTENT, "AssuredPersistent", "Assured persistent"); //$NON-NLS-1$ //$NON-NLS-2$

	/**
	 * The '<em><b>As Bus Destination</b></em>' literal object.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @see #AS_BUS_DESTINATION
	 * @generated
	 * @ordered
	 */
	public static final MessageReliabilityEnum AS_BUS_DESTINATION_LITERAL = new MessageReliabilityEnum(AS_BUS_DESTINATION, "AsBusDestination", "As Bus destination"); //$NON-NLS-1$ //$NON-NLS-2$

	/**
	 * An array of all the '<em><b>Message Reliability Enum</b></em>' enumerators. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	private static final MessageReliabilityEnum[] VALUES_ARRAY = new MessageReliabilityEnum[] {
			NONE_LITERAL,
			BEST_EFFORT_NONPERSISTENT_LITERAL,
			EXPRESS_NONPERSISTENT_LITERAL,
			RELIABLE_NONPERSISTENT_LITERAL,
			RELIABLE_PERSISTENT_LITERAL,
			ASSURED_PERSISTENT_LITERAL,
			AS_BUS_DESTINATION_LITERAL,
		};

	/**
	 * A public read-only list of all the '<em><b>Message Reliability Enum</b></em>' enumerators.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public static final List VALUES = Collections.unmodifiableList(Arrays.asList(VALUES_ARRAY));

	/**
	 * Returns the '<em><b>Message Reliability Enum</b></em>' literal with the specified literal value.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public static MessageReliabilityEnum get(String literal) {
		for (int i = 0; i < VALUES_ARRAY.length; ++i) {
			MessageReliabilityEnum result = VALUES_ARRAY[i];
			if (result.toString().equals(literal)) {
				return result;
			}
		}
		return null;
	}

	/**
	 * Returns the '<em><b>Message Reliability Enum</b></em>' literal with the specified name.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public static MessageReliabilityEnum getByName(String name) {
		for (int i = 0; i < VALUES_ARRAY.length; ++i) {
			MessageReliabilityEnum result = VALUES_ARRAY[i];
			if (result.getName().equals(name)) {
				return result;
			}
		}
		return null;
	}

	/**
	 * Returns the '<em><b>Message Reliability Enum</b></em>' literal with the specified integer value.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public static MessageReliabilityEnum get(int value) {
		switch (value) {
			case NONE: return NONE_LITERAL;
			case BEST_EFFORT_NONPERSISTENT: return BEST_EFFORT_NONPERSISTENT_LITERAL;
			case EXPRESS_NONPERSISTENT: return EXPRESS_NONPERSISTENT_LITERAL;
			case RELIABLE_NONPERSISTENT: return RELIABLE_NONPERSISTENT_LITERAL;
			case RELIABLE_PERSISTENT: return RELIABLE_PERSISTENT_LITERAL;
			case ASSURED_PERSISTENT: return ASSURED_PERSISTENT_LITERAL;
			case AS_BUS_DESTINATION: return AS_BUS_DESTINATION_LITERAL;
		}
		return null;
	}

	/**
	 * Only this class can construct instances.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	private MessageReliabilityEnum(int value, String name, String literal) {
		super(value, name, literal);
	}

} //MessageReliabilityEnum
