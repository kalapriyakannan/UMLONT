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
 * <!-- begin-user-doc --> A representation of the literals of the enumeration '<em><b>Endpoint Listener Type</b></em>',
 * and utility methods for working with them. <!-- end-user-doc -->
 * @see com.ibm.ccl.soa.deploy.was.WasPackage#getWasEndpointListenerType()
 * @model extendedMetaData="name='WasEndpointListenerType'"
 * @generated
 */
public final class WasEndpointListenerType extends AbstractEnumerator {
	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public static final String copyright = "Copyright (c) 2005, 2006 IBM Corporation. Licensed Material - Property of IBM. All rights reserved."; //$NON-NLS-1$

	/**
	 * The '<em><b>SOAP Over Http</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>SOAP Over Http</b></em>' literal object isn't clear, there
	 * really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #SOAP_OVER_HTTP_LITERAL
	 * @model name="SOAPOverHttp"
	 * @generated
	 * @ordered
	 */
	public static final int SOAP_OVER_HTTP = 0;

	/**
	 * The '<em><b>SOAP Over Jms</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>SOAP Over Jms</b></em>' literal object isn't clear, there
	 * really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #SOAP_OVER_JMS_LITERAL
	 * @model name="SOAPOverJms"
	 * @generated
	 * @ordered
	 */
	public static final int SOAP_OVER_JMS = 1;

	/**
	 * The '<em><b>SOAP Over Http</b></em>' literal object.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @see #SOAP_OVER_HTTP
	 * @generated
	 * @ordered
	 */
	public static final WasEndpointListenerType SOAP_OVER_HTTP_LITERAL = new WasEndpointListenerType(SOAP_OVER_HTTP, "SOAPOverHttp", "SOAPOverHttp"); //$NON-NLS-1$ //$NON-NLS-2$

	/**
	 * The '<em><b>SOAP Over Jms</b></em>' literal object.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @see #SOAP_OVER_JMS
	 * @generated
	 * @ordered
	 */
	public static final WasEndpointListenerType SOAP_OVER_JMS_LITERAL = new WasEndpointListenerType(SOAP_OVER_JMS, "SOAPOverJms", "SOAPOverJms"); //$NON-NLS-1$ //$NON-NLS-2$

	/**
	 * An array of all the '<em><b>Endpoint Listener Type</b></em>' enumerators. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	private static final WasEndpointListenerType[] VALUES_ARRAY = new WasEndpointListenerType[] {
			SOAP_OVER_HTTP_LITERAL,
			SOAP_OVER_JMS_LITERAL,
		};

	/**
	 * A public read-only list of all the '<em><b>Endpoint Listener Type</b></em>' enumerators.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public static final List VALUES = Collections.unmodifiableList(Arrays.asList(VALUES_ARRAY));

	/**
	 * Returns the '<em><b>Endpoint Listener Type</b></em>' literal with the specified literal value.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public static WasEndpointListenerType get(String literal) {
		for (int i = 0; i < VALUES_ARRAY.length; ++i) {
			WasEndpointListenerType result = VALUES_ARRAY[i];
			if (result.toString().equals(literal)) {
				return result;
			}
		}
		return null;
	}

	/**
	 * Returns the '<em><b>Endpoint Listener Type</b></em>' literal with the specified name.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public static WasEndpointListenerType getByName(String name) {
		for (int i = 0; i < VALUES_ARRAY.length; ++i) {
			WasEndpointListenerType result = VALUES_ARRAY[i];
			if (result.getName().equals(name)) {
				return result;
			}
		}
		return null;
	}

	/**
	 * Returns the '<em><b>Endpoint Listener Type</b></em>' literal with the specified integer value.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public static WasEndpointListenerType get(int value) {
		switch (value) {
			case SOAP_OVER_HTTP: return SOAP_OVER_HTTP_LITERAL;
			case SOAP_OVER_JMS: return SOAP_OVER_JMS_LITERAL;
		}
		return null;
	}

	/**
	 * Only this class can construct instances.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	private WasEndpointListenerType(int value, String name, String literal) {
		super(value, name, literal);
	}

} //WasEndpointListenerType
