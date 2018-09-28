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
 * <!-- begin-user-doc --> A representation of the literals of the enumeration '<em><b>Derby Jdbc Provider Type Type</b></em>',
 * and utility methods for working with them. <!-- end-user-doc -->
 * @see com.ibm.ccl.soa.deploy.was.WasPackage#getDerbyJdbcProviderTypeType()
 * @model extendedMetaData="name='DerbyJdbcProviderTypeType'"
 * @generated
 */
public final class DerbyJdbcProviderTypeType extends AbstractEnumerator {
	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public static final String copyright = "Copyright (c) 2005, 2006 IBM Corporation. Licensed Material - Property of IBM. All rights reserved."; //$NON-NLS-1$

	/**
	 * The '<em><b>Cloudscape JDBC Provider</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>Cloudscape JDBC Provider</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #CLOUDSCAPE_JDBC_PROVIDER_LITERAL
	 * @model name="CloudscapeJDBCProvider" literal="Cloudscape JDBC Provider"
	 * @generated
	 * @ordered
	 */
	public static final int CLOUDSCAPE_JDBC_PROVIDER = 0;

	/**
	 * The '<em><b>Cloudscape JDBC Provider XA</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>Cloudscape JDBC Provider XA</b></em>' literal object isn't
	 * clear, there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #CLOUDSCAPE_JDBC_PROVIDER_XA_LITERAL
	 * @model name="CloudscapeJDBCProviderXA" literal="Cloudscape JDBC Provider (XA)"
	 * @generated
	 * @ordered
	 */
	public static final int CLOUDSCAPE_JDBC_PROVIDER_XA = 1;

	/**
	 * The '<em><b>Cloudscape Network Server Using Universal JDBC Driver</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>Cloudscape Network Server Using Universal JDBC Driver</b></em>'
	 * literal object isn't clear, there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #CLOUDSCAPE_NETWORK_SERVER_USING_UNIVERSAL_JDBC_DRIVER_LITERAL
	 * @model name="CloudscapeNetworkServerUsingUniversalJDBCDriver" literal="Cloudscape Network Server Using Universal JDBC Driver"
	 * @generated
	 * @ordered
	 */
	public static final int CLOUDSCAPE_NETWORK_SERVER_USING_UNIVERSAL_JDBC_DRIVER = 2;

	/**
	 * The '<em><b>Cloudscape JDBC Provider</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #CLOUDSCAPE_JDBC_PROVIDER
	 * @generated
	 * @ordered
	 */
	public static final DerbyJdbcProviderTypeType CLOUDSCAPE_JDBC_PROVIDER_LITERAL = new DerbyJdbcProviderTypeType(CLOUDSCAPE_JDBC_PROVIDER, "CloudscapeJDBCProvider", "Cloudscape JDBC Provider"); //$NON-NLS-1$ //$NON-NLS-2$

	/**
	 * The '<em><b>Cloudscape JDBC Provider XA</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #CLOUDSCAPE_JDBC_PROVIDER_XA
	 * @generated
	 * @ordered
	 */
	public static final DerbyJdbcProviderTypeType CLOUDSCAPE_JDBC_PROVIDER_XA_LITERAL = new DerbyJdbcProviderTypeType(CLOUDSCAPE_JDBC_PROVIDER_XA, "CloudscapeJDBCProviderXA", "Cloudscape JDBC Provider (XA)"); //$NON-NLS-1$ //$NON-NLS-2$

	/**
	 * The '<em><b>Cloudscape Network Server Using Universal JDBC Driver</b></em>' literal object.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see #CLOUDSCAPE_NETWORK_SERVER_USING_UNIVERSAL_JDBC_DRIVER
	 * @generated
	 * @ordered
	 */
	public static final DerbyJdbcProviderTypeType CLOUDSCAPE_NETWORK_SERVER_USING_UNIVERSAL_JDBC_DRIVER_LITERAL = new DerbyJdbcProviderTypeType(CLOUDSCAPE_NETWORK_SERVER_USING_UNIVERSAL_JDBC_DRIVER, "CloudscapeNetworkServerUsingUniversalJDBCDriver", "Cloudscape Network Server Using Universal JDBC Driver"); //$NON-NLS-1$ //$NON-NLS-2$

	/**
	 * An array of all the '<em><b>Derby Jdbc Provider Type Type</b></em>' enumerators. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	private static final DerbyJdbcProviderTypeType[] VALUES_ARRAY = new DerbyJdbcProviderTypeType[] {
			CLOUDSCAPE_JDBC_PROVIDER_LITERAL,
			CLOUDSCAPE_JDBC_PROVIDER_XA_LITERAL,
			CLOUDSCAPE_NETWORK_SERVER_USING_UNIVERSAL_JDBC_DRIVER_LITERAL,
		};

	/**
	 * A public read-only list of all the '<em><b>Derby Jdbc Provider Type Type</b></em>' enumerators.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public static final List VALUES = Collections.unmodifiableList(Arrays.asList(VALUES_ARRAY));

	/**
	 * Returns the '<em><b>Derby Jdbc Provider Type Type</b></em>' literal with the specified literal value.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public static DerbyJdbcProviderTypeType get(String literal) {
		for (int i = 0; i < VALUES_ARRAY.length; ++i) {
			DerbyJdbcProviderTypeType result = VALUES_ARRAY[i];
			if (result.toString().equals(literal)) {
				return result;
			}
		}
		return null;
	}

	/**
	 * Returns the '<em><b>Derby Jdbc Provider Type Type</b></em>' literal with the specified name.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public static DerbyJdbcProviderTypeType getByName(String name) {
		for (int i = 0; i < VALUES_ARRAY.length; ++i) {
			DerbyJdbcProviderTypeType result = VALUES_ARRAY[i];
			if (result.getName().equals(name)) {
				return result;
			}
		}
		return null;
	}

	/**
	 * Returns the '<em><b>Derby Jdbc Provider Type Type</b></em>' literal with the specified integer value.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public static DerbyJdbcProviderTypeType get(int value) {
		switch (value) {
			case CLOUDSCAPE_JDBC_PROVIDER: return CLOUDSCAPE_JDBC_PROVIDER_LITERAL;
			case CLOUDSCAPE_JDBC_PROVIDER_XA: return CLOUDSCAPE_JDBC_PROVIDER_XA_LITERAL;
			case CLOUDSCAPE_NETWORK_SERVER_USING_UNIVERSAL_JDBC_DRIVER: return CLOUDSCAPE_NETWORK_SERVER_USING_UNIVERSAL_JDBC_DRIVER_LITERAL;
		}
		return null;
	}

	/**
	 * Only this class can construct instances.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	private DerbyJdbcProviderTypeType(int value, String name, String literal) {
		super(value, name, literal);
	}

} //DerbyJdbcProviderTypeType
