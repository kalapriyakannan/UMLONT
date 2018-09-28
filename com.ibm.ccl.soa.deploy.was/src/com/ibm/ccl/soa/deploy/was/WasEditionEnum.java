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
 * <!-- begin-user-doc --> A representation of the literals of the enumeration '<em><b>Edition Enum</b></em>',
 * and utility methods for working with them. <!-- end-user-doc -->
 * @see com.ibm.ccl.soa.deploy.was.WasPackage#getWasEditionEnum()
 * @model extendedMetaData="name='WasEditionEnum'"
 * @generated
 */
public final class WasEditionEnum extends AbstractEnumerator {
	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public static final String copyright = "Copyright (c) 2005, 2006 IBM Corporation. Licensed Material - Property of IBM. All rights reserved."; //$NON-NLS-1$

	/**
	 * The '<em><b>Base</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>Base</b></em>' literal object isn't clear, there really should
	 * be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #BASE_LITERAL
	 * @model name="Base"
	 * @generated
	 * @ordered
	 */
	public static final int BASE = 0;

	/**
	 * The '<em><b>Express</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>Express</b></em>' literal object isn't clear, there really
	 * should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #EXPRESS_LITERAL
	 * @model name="Express"
	 * @generated
	 * @ordered
	 */
	public static final int EXPRESS = 1;

	/**
	 * The '<em><b>Network Deployment</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>Network Deployment</b></em>' literal object isn't clear, there
	 * really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #NETWORK_DEPLOYMENT_LITERAL
	 * @model name="NetworkDeployment" literal="Network Deployment"
	 * @generated
	 * @ordered
	 */
	public static final int NETWORK_DEPLOYMENT = 2;

	/**
	 * The '<em><b>Base</b></em>' literal object.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see #BASE
	 * @generated
	 * @ordered
	 */
	public static final WasEditionEnum BASE_LITERAL = new WasEditionEnum(BASE, "Base", "Base"); //$NON-NLS-1$ //$NON-NLS-2$

	/**
	 * The '<em><b>Express</b></em>' literal object. <!-- begin-user-doc --> <!-- end-user-doc
	 * -->
	 * 
	 * @see #EXPRESS
	 * @generated
	 * @ordered
	 */
	public static final WasEditionEnum EXPRESS_LITERAL = new WasEditionEnum(EXPRESS, "Express", "Express"); //$NON-NLS-1$ //$NON-NLS-2$

	/**
	 * The '<em><b>Network Deployment</b></em>' literal object.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @see #NETWORK_DEPLOYMENT
	 * @generated
	 * @ordered
	 */
	public static final WasEditionEnum NETWORK_DEPLOYMENT_LITERAL = new WasEditionEnum(NETWORK_DEPLOYMENT, "NetworkDeployment", "Network Deployment"); //$NON-NLS-1$ //$NON-NLS-2$

	/**
	 * An array of all the '<em><b>Edition Enum</b></em>' enumerators.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private static final WasEditionEnum[] VALUES_ARRAY = new WasEditionEnum[] {
			BASE_LITERAL,
			EXPRESS_LITERAL,
			NETWORK_DEPLOYMENT_LITERAL,
		};

	/**
	 * A public read-only list of all the '<em><b>Edition Enum</b></em>' enumerators. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public static final List VALUES = Collections.unmodifiableList(Arrays.asList(VALUES_ARRAY));

	/**
	 * Returns the '<em><b>Edition Enum</b></em>' literal with the specified literal value. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public static WasEditionEnum get(String literal) {
		for (int i = 0; i < VALUES_ARRAY.length; ++i) {
			WasEditionEnum result = VALUES_ARRAY[i];
			if (result.toString().equals(literal)) {
				return result;
			}
		}
		return null;
	}

	/**
	 * Returns the '<em><b>Edition Enum</b></em>' literal with the specified name. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public static WasEditionEnum getByName(String name) {
		for (int i = 0; i < VALUES_ARRAY.length; ++i) {
			WasEditionEnum result = VALUES_ARRAY[i];
			if (result.getName().equals(name)) {
				return result;
			}
		}
		return null;
	}

	/**
	 * Returns the '<em><b>Edition Enum</b></em>' literal with the specified integer value. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public static WasEditionEnum get(int value) {
		switch (value) {
			case BASE: return BASE_LITERAL;
			case EXPRESS: return EXPRESS_LITERAL;
			case NETWORK_DEPLOYMENT: return NETWORK_DEPLOYMENT_LITERAL;
		}
		return null;
	}

	/**
	 * Only this class can construct instances.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	private WasEditionEnum(int value, String name, String literal) {
		super(value, name, literal);
	}

} //WasEditionEnum
