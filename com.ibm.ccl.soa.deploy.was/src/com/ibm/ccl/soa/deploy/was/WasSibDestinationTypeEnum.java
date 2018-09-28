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
 * <!-- begin-user-doc --> A representation of the literals of the enumeration '<em><b>Sib Destination Type Enum</b></em>',
 * and utility methods for working with them. <!-- end-user-doc -->
 * @see com.ibm.ccl.soa.deploy.was.WasPackage#getWasSibDestinationTypeEnum()
 * @model extendedMetaData="name='WasSibDestinationTypeEnum'"
 * @generated
 */
public final class WasSibDestinationTypeEnum extends AbstractEnumerator {
	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public static final String copyright = "Copyright (c) 2005, 2006 IBM Corporation. Licensed Material - Property of IBM. All rights reserved."; //$NON-NLS-1$

	/**
	 * The '<em><b>Web Service</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>Web Service</b></em>' literal object isn't clear, there really
	 * should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #WEB_SERVICE_LITERAL
	 * @model name="WebService"
	 * @generated
	 * @ordered
	 */
	public static final int WEB_SERVICE = 0;

	/**
	 * The '<em><b>Port</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>Port</b></em>' literal object isn't clear, there really should
	 * be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #PORT_LITERAL
	 * @model name="Port"
	 * @generated
	 * @ordered
	 */
	public static final int PORT = 1;

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
	public static final int QUEUE = 2;

	/**
	 * The '<em><b>Topic Space</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>Topic Space</b></em>' literal object isn't clear, there really
	 * should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #TOPIC_SPACE_LITERAL
	 * @model name="TopicSpace"
	 * @generated
	 * @ordered
	 */
	public static final int TOPIC_SPACE = 3;

	/**
	 * The '<em><b>Alias</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>Alias</b></em>' literal object isn't clear, there really should
	 * be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #ALIAS_LITERAL
	 * @model name="Alias"
	 * @generated
	 * @ordered
	 */
	public static final int ALIAS = 4;

	/**
	 * The '<em><b>Foreign</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>Foreign</b></em>' literal object isn't clear, there really
	 * should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #FOREIGN_LITERAL
	 * @model name="Foreign"
	 * @generated
	 * @ordered
	 */
	public static final int FOREIGN = 5;

	/**
	 * The '<em><b>Web Service</b></em>' literal object.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @see #WEB_SERVICE
	 * @generated
	 * @ordered
	 */
	public static final WasSibDestinationTypeEnum WEB_SERVICE_LITERAL = new WasSibDestinationTypeEnum(WEB_SERVICE, "WebService", "WebService"); //$NON-NLS-1$ //$NON-NLS-2$

	/**
	 * The '<em><b>Port</b></em>' literal object.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see #PORT
	 * @generated
	 * @ordered
	 */
	public static final WasSibDestinationTypeEnum PORT_LITERAL = new WasSibDestinationTypeEnum(PORT, "Port", "Port"); //$NON-NLS-1$ //$NON-NLS-2$

	/**
	 * The '<em><b>Queue</b></em>' literal object.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see #QUEUE
	 * @generated
	 * @ordered
	 */
	public static final WasSibDestinationTypeEnum QUEUE_LITERAL = new WasSibDestinationTypeEnum(QUEUE, "Queue", "Queue"); //$NON-NLS-1$ //$NON-NLS-2$

	/**
	 * The '<em><b>Topic Space</b></em>' literal object.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @see #TOPIC_SPACE
	 * @generated
	 * @ordered
	 */
	public static final WasSibDestinationTypeEnum TOPIC_SPACE_LITERAL = new WasSibDestinationTypeEnum(TOPIC_SPACE, "TopicSpace", "TopicSpace"); //$NON-NLS-1$ //$NON-NLS-2$

	/**
	 * The '<em><b>Alias</b></em>' literal object.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see #ALIAS
	 * @generated
	 * @ordered
	 */
	public static final WasSibDestinationTypeEnum ALIAS_LITERAL = new WasSibDestinationTypeEnum(ALIAS, "Alias", "Alias"); //$NON-NLS-1$ //$NON-NLS-2$

	/**
	 * The '<em><b>Foreign</b></em>' literal object. <!-- begin-user-doc --> <!-- end-user-doc
	 * -->
	 * 
	 * @see #FOREIGN
	 * @generated
	 * @ordered
	 */
	public static final WasSibDestinationTypeEnum FOREIGN_LITERAL = new WasSibDestinationTypeEnum(FOREIGN, "Foreign", "Foreign"); //$NON-NLS-1$ //$NON-NLS-2$

	/**
	 * An array of all the '<em><b>Sib Destination Type Enum</b></em>' enumerators. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	private static final WasSibDestinationTypeEnum[] VALUES_ARRAY = new WasSibDestinationTypeEnum[] {
			WEB_SERVICE_LITERAL,
			PORT_LITERAL,
			QUEUE_LITERAL,
			TOPIC_SPACE_LITERAL,
			ALIAS_LITERAL,
			FOREIGN_LITERAL,
		};

	/**
	 * A public read-only list of all the '<em><b>Sib Destination Type Enum</b></em>' enumerators.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public static final List VALUES = Collections.unmodifiableList(Arrays.asList(VALUES_ARRAY));

	/**
	 * Returns the '<em><b>Sib Destination Type Enum</b></em>' literal with the specified literal value.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public static WasSibDestinationTypeEnum get(String literal) {
		for (int i = 0; i < VALUES_ARRAY.length; ++i) {
			WasSibDestinationTypeEnum result = VALUES_ARRAY[i];
			if (result.toString().equals(literal)) {
				return result;
			}
		}
		return null;
	}

	/**
	 * Returns the '<em><b>Sib Destination Type Enum</b></em>' literal with the specified name.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public static WasSibDestinationTypeEnum getByName(String name) {
		for (int i = 0; i < VALUES_ARRAY.length; ++i) {
			WasSibDestinationTypeEnum result = VALUES_ARRAY[i];
			if (result.getName().equals(name)) {
				return result;
			}
		}
		return null;
	}

	/**
	 * Returns the '<em><b>Sib Destination Type Enum</b></em>' literal with the specified integer value.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public static WasSibDestinationTypeEnum get(int value) {
		switch (value) {
			case WEB_SERVICE: return WEB_SERVICE_LITERAL;
			case PORT: return PORT_LITERAL;
			case QUEUE: return QUEUE_LITERAL;
			case TOPIC_SPACE: return TOPIC_SPACE_LITERAL;
			case ALIAS: return ALIAS_LITERAL;
			case FOREIGN: return FOREIGN_LITERAL;
		}
		return null;
	}

	/**
	 * Only this class can construct instances.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	private WasSibDestinationTypeEnum(int value, String name, String literal) {
		super(value, name, literal);
	}

} //WasSibDestinationTypeEnum
