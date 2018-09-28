/*******************************************************************************
 * Copyright (c) 2003, 2007 IBM Corporation Licensed Material - Property of IBM. All rights reserved.
 *  
 * US Government Users Restricted Rights - Use, duplication or disclosure v1.0 restricted by GSA ADP
 * Schedule Contract with IBM Corp.
 * 
 * Contributors: IBM Corporation - initial API and implementation
 *******************************************************************************/
package com.ibm.ccl.soa.deploy.os;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.eclipse.emf.common.util.AbstractEnumerator;

/**
 * <!-- begin-user-doc --> A representation of the literals of the enumeration '<em><b>Product Type Type</b></em>',
 * and utility methods for working with them. <!-- end-user-doc -->
 * 
 * @see com.ibm.ccl.soa.deploy.os.OsPackage#getProductTypeType()
 * @model
 * @generated
 */
public final class ProductTypeType extends AbstractEnumerator {
	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public static final String copyright = "Copyright (c) 2005, 2006 IBM Corporation. Licensed Material - Property of IBM. All rights reserved."; //$NON-NLS-1$

	/**
	 * The '<em><b>Work Station</b></em>' literal value. <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>Work Station</b></em>' literal object isn't clear, there really
	 * should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * 
	 * @see #WORK_STATION_LITERAL
	 * @model name="WorkStation" literal="Work Station"
	 * @generated
	 * @ordered
	 */
	public static final int WORK_STATION = 0;

	/**
	 * The '<em><b>Domain Controller</b></em>' literal value. <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>Domain Controller</b></em>' literal object isn't clear, there
	 * really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * 
	 * @see #DOMAIN_CONTROLLER_LITERAL
	 * @model name="DomainController" literal="Domain Controller"
	 * @generated
	 * @ordered
	 */
	public static final int DOMAIN_CONTROLLER = 1;

	/**
	 * The '<em><b>Server</b></em>' literal value. <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>Server</b></em>' literal object isn't clear, there really
	 * should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * 
	 * @see #SERVER_LITERAL
	 * @model name="Server"
	 * @generated
	 * @ordered
	 */
	public static final int SERVER = 2;

	/**
	 * The '<em><b>Work Station</b></em>' literal object. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @see #WORK_STATION
	 * @generated
	 * @ordered
	 */
	public static final ProductTypeType WORK_STATION_LITERAL = new ProductTypeType(WORK_STATION,
			"WorkStation", "Work Station"); //$NON-NLS-1$ //$NON-NLS-2$

	/**
	 * The '<em><b>Domain Controller</b></em>' literal object. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @see #DOMAIN_CONTROLLER
	 * @generated
	 * @ordered
	 */
	public static final ProductTypeType DOMAIN_CONTROLLER_LITERAL = new ProductTypeType(
			DOMAIN_CONTROLLER, "DomainController", "Domain Controller"); //$NON-NLS-1$ //$NON-NLS-2$

	/**
	 * The '<em><b>Server</b></em>' literal object. <!-- begin-user-doc --> <!-- end-user-doc
	 * -->
	 * 
	 * @see #SERVER
	 * @generated
	 * @ordered
	 */
	public static final ProductTypeType SERVER_LITERAL = new ProductTypeType(SERVER,
			"Server", "Server"); //$NON-NLS-1$ //$NON-NLS-2$

	/**
	 * An array of all the '<em><b>Product Type Type</b></em>' enumerators. <!-- begin-user-doc
	 * --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	private static final ProductTypeType[] VALUES_ARRAY = new ProductTypeType[] {
			WORK_STATION_LITERAL, DOMAIN_CONTROLLER_LITERAL, SERVER_LITERAL, };

	/**
	 * A public read-only list of all the '<em><b>Product Type Type</b></em>' enumerators. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public static final List VALUES = Collections.unmodifiableList(Arrays.asList(VALUES_ARRAY));

	/**
	 * Returns the '<em><b>Product Type Type</b></em>' literal with the specified literal value.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public static ProductTypeType get(String literal) {
		for (int i = 0; i < VALUES_ARRAY.length; ++i) {
			ProductTypeType result = VALUES_ARRAY[i];
			if (result.toString().equals(literal)) {
				return result;
			}
		}
		return null;
	}

	/**
	 * Returns the '<em><b>Product Type Type</b></em>' literal with the specified name. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public static ProductTypeType getByName(String name) {
		for (int i = 0; i < VALUES_ARRAY.length; ++i) {
			ProductTypeType result = VALUES_ARRAY[i];
			if (result.getName().equals(name)) {
				return result;
			}
		}
		return null;
	}

	/**
	 * Returns the '<em><b>Product Type Type</b></em>' literal with the specified integer value.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public static ProductTypeType get(int value) {
		switch (value)
		{
		case WORK_STATION:
			return WORK_STATION_LITERAL;
		case DOMAIN_CONTROLLER:
			return DOMAIN_CONTROLLER_LITERAL;
		case SERVER:
			return SERVER_LITERAL;
		}
		return null;
	}

	/**
	 * Only this class can construct instances. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	private ProductTypeType(int value, String name, String literal) {
		super(value, name, literal);
	}

} //ProductTypeType
