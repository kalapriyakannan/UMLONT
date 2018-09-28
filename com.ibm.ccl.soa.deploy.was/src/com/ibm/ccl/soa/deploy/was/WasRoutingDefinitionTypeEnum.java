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
 * <!-- begin-user-doc --> A representation of the literals of the enumeration '<em><b>Routing Definition Type Enum</b></em>',
 * and utility methods for working with them. <!-- end-user-doc --> <!-- begin-model-doc -->
 * 
 * 
 * <!-- end-model-doc -->
 * 
 * @see com.ibm.ccl.soa.deploy.was.WasPackage#getWasRoutingDefinitionTypeEnum()
 * @model
 * @generated
 */
public final class WasRoutingDefinitionTypeEnum extends AbstractEnumerator {
	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public static final String copyright = "Copyright (c) 2005, 2006 IBM Corporation. Licensed Material - Property of IBM. All rights reserved."; //$NON-NLS-1$

	/**
	 * The '<em><b>Direct Service Integration Bus Link</b></em>' literal value. <!--
	 * begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>Direct Service Integration Bus Link</b></em>' literal object
	 * isn't clear, there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * 
	 * @see #DIRECT_SERVICE_INTEGRATION_BUS_LINK_LITERAL
	 * @model name="DirectServiceIntegrationBusLink" literal="Direct,Service Integration Bus link"
	 * @generated
	 * @ordered
	 */
	public static final int DIRECT_SERVICE_INTEGRATION_BUS_LINK = 0;

	/**
	 * The '<em><b>Direct Websphere MQ Link</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>Direct Websphere MQ Link</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #DIRECT_WEBSPHERE_MQ_LINK_LITERAL
	 * @model name="DirectWebsphereMQLink" literal="Direct,Websphere MQ link"
	 * @generated
	 * @ordered
	 */
	public static final int DIRECT_WEBSPHERE_MQ_LINK = 1;

	/**
	 * The '<em><b>Direct Service Integration Bus Link</b></em>' literal object. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see #DIRECT_SERVICE_INTEGRATION_BUS_LINK
	 * @generated
	 * @ordered
	 */
	public static final WasRoutingDefinitionTypeEnum DIRECT_SERVICE_INTEGRATION_BUS_LINK_LITERAL = new WasRoutingDefinitionTypeEnum(DIRECT_SERVICE_INTEGRATION_BUS_LINK, "DirectServiceIntegrationBusLink", "Direct,Service Integration Bus link"); //$NON-NLS-1$ //$NON-NLS-2$

	/**
	 * The '<em><b>Direct Websphere MQ Link</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #DIRECT_WEBSPHERE_MQ_LINK
	 * @generated
	 * @ordered
	 */
	public static final WasRoutingDefinitionTypeEnum DIRECT_WEBSPHERE_MQ_LINK_LITERAL = new WasRoutingDefinitionTypeEnum(DIRECT_WEBSPHERE_MQ_LINK, "DirectWebsphereMQLink", "Direct,Websphere MQ link"); //$NON-NLS-1$ //$NON-NLS-2$

	/**
	 * An array of all the '<em><b>Routing Definition Type Enum</b></em>' enumerators. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	private static final WasRoutingDefinitionTypeEnum[] VALUES_ARRAY = new WasRoutingDefinitionTypeEnum[] {
			DIRECT_SERVICE_INTEGRATION_BUS_LINK_LITERAL,
			DIRECT_WEBSPHERE_MQ_LINK_LITERAL,
		};

	/**
	 * A public read-only list of all the '<em><b>Routing Definition Type Enum</b></em>' enumerators.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public static final List VALUES = Collections.unmodifiableList(Arrays.asList(VALUES_ARRAY));

	/**
	 * Returns the '<em><b>Routing Definition Type Enum</b></em>' literal with the specified literal value.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public static WasRoutingDefinitionTypeEnum get(String literal) {
		for (int i = 0; i < VALUES_ARRAY.length; ++i) {
			WasRoutingDefinitionTypeEnum result = VALUES_ARRAY[i];
			if (result.toString().equals(literal)) {
				return result;
			}
		}
		return null;
	}

	/**
	 * Returns the '<em><b>Routing Definition Type Enum</b></em>' literal with the specified name.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public static WasRoutingDefinitionTypeEnum getByName(String name) {
		for (int i = 0; i < VALUES_ARRAY.length; ++i) {
			WasRoutingDefinitionTypeEnum result = VALUES_ARRAY[i];
			if (result.getName().equals(name)) {
				return result;
			}
		}
		return null;
	}

	/**
	 * Returns the '<em><b>Routing Definition Type Enum</b></em>' literal with the specified integer value.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public static WasRoutingDefinitionTypeEnum get(int value) {
		switch (value) {
			case DIRECT_SERVICE_INTEGRATION_BUS_LINK: return DIRECT_SERVICE_INTEGRATION_BUS_LINK_LITERAL;
			case DIRECT_WEBSPHERE_MQ_LINK: return DIRECT_WEBSPHERE_MQ_LINK_LITERAL;
		}
		return null;
	}

	/**
	 * Only this class can construct instances.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	private WasRoutingDefinitionTypeEnum(int value, String name, String literal) {
		super(value, name, literal);
	}

} //WasRoutingDefinitionTypeEnum
