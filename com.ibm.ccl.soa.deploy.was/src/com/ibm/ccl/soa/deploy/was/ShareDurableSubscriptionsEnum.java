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
 * <!-- begin-user-doc --> A representation of the literals of the enumeration '<em><b>Share Durable Subscriptions Enum</b></em>',
 * and utility methods for working with them. <!-- end-user-doc -->
 * @see com.ibm.ccl.soa.deploy.was.WasPackage#getShareDurableSubscriptionsEnum()
 * @model extendedMetaData="name='ShareDurableSubscriptionsEnum'"
 * @generated
 */
public final class ShareDurableSubscriptionsEnum extends AbstractEnumerator {
	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public static final String copyright = "Copyright (c) 2005, 2006 IBM Corporation. Licensed Material - Property of IBM. All rights reserved."; //$NON-NLS-1$

	/**
	 * The '<em><b>In Cluster</b></em>' literal value. <!-- begin-user-doc --> <!-- end-user-doc
	 * --> <!-- begin-model-doc -->
	 * 
	 * Allows sharing of durable subscriptions when connections are made from within a server
	 * cluster.
	 * 
	 * <!-- end-model-doc -->
	 * 
	 * @see #IN_CLUSTER_LITERAL
	 * @model name="InCluster" literal="In cluster"
	 * @generated
	 * @ordered
	 */
	public static final int IN_CLUSTER = 0;

	/**
	 * The '<em><b>Always Shared</b></em>' literal value. <!-- begin-user-doc --> <!--
	 * end-user-doc --> <!-- begin-model-doc -->
	 * 
	 * Durable subscriptions can be shared across connections.
	 * 
	 * <!-- end-model-doc -->
	 * 
	 * @see #ALWAYS_SHARED_LITERAL
	 * @model name="AlwaysShared" literal="Always shared"
	 * @generated
	 * @ordered
	 */
	public static final int ALWAYS_SHARED = 1;

	/**
	 * The '<em><b>Never Shared</b></em>' literal value. <!-- begin-user-doc --> <!--
	 * end-user-doc --> <!-- begin-model-doc -->
	 * 
	 * Durable subscriptions are never shared across connections.
	 * 
	 * <!-- end-model-doc -->
	 * 
	 * @see #NEVER_SHARED_LITERAL
	 * @model name="NeverShared" literal="Never shared"
	 * @generated
	 * @ordered
	 */
	public static final int NEVER_SHARED = 2;

	/**
	 * The '<em><b>In Cluster</b></em>' literal object.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @see #IN_CLUSTER
	 * @generated
	 * @ordered
	 */
	public static final ShareDurableSubscriptionsEnum IN_CLUSTER_LITERAL = new ShareDurableSubscriptionsEnum(IN_CLUSTER, "InCluster", "In cluster"); //$NON-NLS-1$ //$NON-NLS-2$

	/**
	 * The '<em><b>Always Shared</b></em>' literal object.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @see #ALWAYS_SHARED
	 * @generated
	 * @ordered
	 */
	public static final ShareDurableSubscriptionsEnum ALWAYS_SHARED_LITERAL = new ShareDurableSubscriptionsEnum(ALWAYS_SHARED, "AlwaysShared", "Always shared"); //$NON-NLS-1$ //$NON-NLS-2$

	/**
	 * The '<em><b>Never Shared</b></em>' literal object.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @see #NEVER_SHARED
	 * @generated
	 * @ordered
	 */
	public static final ShareDurableSubscriptionsEnum NEVER_SHARED_LITERAL = new ShareDurableSubscriptionsEnum(NEVER_SHARED, "NeverShared", "Never shared"); //$NON-NLS-1$ //$NON-NLS-2$

	/**
	 * An array of all the '<em><b>Share Durable Subscriptions Enum</b></em>' enumerators. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	private static final ShareDurableSubscriptionsEnum[] VALUES_ARRAY = new ShareDurableSubscriptionsEnum[] {
			IN_CLUSTER_LITERAL,
			ALWAYS_SHARED_LITERAL,
			NEVER_SHARED_LITERAL,
		};

	/**
	 * A public read-only list of all the '<em><b>Share Durable Subscriptions Enum</b></em>' enumerators.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public static final List VALUES = Collections.unmodifiableList(Arrays.asList(VALUES_ARRAY));

	/**
	 * Returns the '<em><b>Share Durable Subscriptions Enum</b></em>' literal with the specified literal value.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public static ShareDurableSubscriptionsEnum get(String literal) {
		for (int i = 0; i < VALUES_ARRAY.length; ++i) {
			ShareDurableSubscriptionsEnum result = VALUES_ARRAY[i];
			if (result.toString().equals(literal)) {
				return result;
			}
		}
		return null;
	}

	/**
	 * Returns the '<em><b>Share Durable Subscriptions Enum</b></em>' literal with the specified name.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public static ShareDurableSubscriptionsEnum getByName(String name) {
		for (int i = 0; i < VALUES_ARRAY.length; ++i) {
			ShareDurableSubscriptionsEnum result = VALUES_ARRAY[i];
			if (result.getName().equals(name)) {
				return result;
			}
		}
		return null;
	}

	/**
	 * Returns the '<em><b>Share Durable Subscriptions Enum</b></em>' literal with the specified integer value.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public static ShareDurableSubscriptionsEnum get(int value) {
		switch (value) {
			case IN_CLUSTER: return IN_CLUSTER_LITERAL;
			case ALWAYS_SHARED: return ALWAYS_SHARED_LITERAL;
			case NEVER_SHARED: return NEVER_SHARED_LITERAL;
		}
		return null;
	}

	/**
	 * Only this class can construct instances.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	private ShareDurableSubscriptionsEnum(int value, String name, String literal) {
		super(value, name, literal);
	}

} //ShareDurableSubscriptionsEnum
