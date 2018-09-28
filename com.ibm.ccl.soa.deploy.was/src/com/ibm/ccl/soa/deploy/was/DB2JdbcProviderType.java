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
 * <!-- begin-user-doc --> A representation of the literals of the enumeration '<em><b>DB2 Jdbc Provider Type</b></em>',
 * and utility methods for working with them. <!-- end-user-doc -->
 * @see com.ibm.ccl.soa.deploy.was.WasPackage#getDB2JdbcProviderType()
 * @model extendedMetaData="name='DB2JdbcProviderType'"
 * @generated
 */
public final class DB2JdbcProviderType extends AbstractEnumerator {
	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public static final String copyright = "Copyright (c) 2005, 2006 IBM Corporation. Licensed Material - Property of IBM. All rights reserved."; //$NON-NLS-1$

	/**
	 * The '<em><b>None</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>None</b></em>' literal object isn't clear, there really should
	 * be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #NONE_LITERAL
	 * @model name="none"
	 * @generated
	 * @ordered
	 */
	public static final int NONE = 0;

	/**
	 * The '<em><b>DB2 Universal JDBC Driver Provider</b></em>' literal value. <!--
	 * begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>DB2 Universal JDBC Driver Provider</b></em>' literal object
	 * isn't clear, there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * 
	 * @see #DB2_UNIVERSAL_JDBC_DRIVER_PROVIDER_LITERAL
	 * @model name="DB2UniversalJDBCDriverProvider" literal="DB2 Universal JDBC Driver Provider"
	 * @generated
	 * @ordered
	 */
	public static final int DB2_UNIVERSAL_JDBC_DRIVER_PROVIDER = 1;

	/**
	 * The '<em><b>DB2 Universal JDBC Driver Provider XA</b></em>' literal value. <!--
	 * begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>DB2 Universal JDBC Driver Provider XA</b></em>' literal object
	 * isn't clear, there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * 
	 * @see #DB2_UNIVERSAL_JDBC_DRIVER_PROVIDER_XA_LITERAL
	 * @model name="DB2UniversalJDBCDriverProviderXA" literal="DB2 Universal JDBC Driver Provider
	 *        (XA)"
	 * @generated
	 * @ordered
	 */
	public static final int DB2_UNIVERSAL_JDBC_DRIVER_PROVIDER_XA = 2;

	/**
	 * The '<em><b>DB2 Legacy CLI Based Type2 JDBC Driver</b></em>' literal value. <!--
	 * begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>DB2 Legacy CLI Based Type2 JDBC Driver</b></em>' literal object
	 * isn't clear, there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * 
	 * @see #DB2_LEGACY_CLI_BASED_TYPE2_JDBC_DRIVER_LITERAL
	 * @model name="DB2LegacyCLIBasedType2JDBCDriver" literal="DB2 Legacy CLI-based Type 2 JDBC
	 *        Driver"
	 * @generated
	 * @ordered
	 */
	public static final int DB2_LEGACY_CLI_BASED_TYPE2_JDBC_DRIVER = 3;

	/**
	 * The '<em><b>DB2 Legacy CLI Based Type2 JDBC Driver XA</b></em>' literal value. <!--
	 * begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>DB2 Legacy CLI Based Type2 JDBC Driver XA</b></em>' literal
	 * object isn't clear, there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * 
	 * @see #DB2_LEGACY_CLI_BASED_TYPE2_JDBC_DRIVER_XA_LITERAL
	 * @model name="DB2LegacyCLIBasedType2JDBCDriverXA" literal="DB2 Legacy CLI-based Type 2 JDBC
	 *        Driver (XA)"
	 * @generated
	 * @ordered
	 */
	public static final int DB2_LEGACY_CLI_BASED_TYPE2_JDBC_DRIVER_XA = 4;

	/**
	 * The '<em><b>DB2UDB For ISeries Native</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>DB2UDB For ISeries Native</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #DB2UDB_FOR_ISERIES_NATIVE_LITERAL
	 * @model name="DB2UDBForISeriesNative" literal="DB2 UDB for iSeries (Native)"
	 * @generated
	 * @ordered
	 */
	public static final int DB2UDB_FOR_ISERIES_NATIVE = 5;

	/**
	 * The '<em><b>DB2UDB For ISeries Native XA</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>DB2UDB For ISeries Native XA</b></em>' literal object isn't
	 * clear, there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #DB2UDB_FOR_ISERIES_NATIVE_XA_LITERAL
	 * @model name="DB2UDBForISeriesNativeXA" literal="DB2 UDB for iSeries (Native XA)"
	 * @generated
	 * @ordered
	 */
	public static final int DB2UDB_FOR_ISERIES_NATIVE_XA = 6;

	/**
	 * The '<em><b>DB2UDB For ISeries Toolbox</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>DB2UDB For ISeries Toolbox</b></em>' literal object isn't
	 * clear, there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #DB2UDB_FOR_ISERIES_TOOLBOX_LITERAL
	 * @model name="DB2UDBForISeriesToolbox" literal="DB2 UDB for iSeries (Toolbox)"
	 * @generated
	 * @ordered
	 */
	public static final int DB2UDB_FOR_ISERIES_TOOLBOX = 7;

	/**
	 * The '<em><b>DB2UDB For ISeries Toolbox XA</b></em>' literal value.
	 * <!-- begin-user-doc
	 * -->
	 * <p>
	 * If the meaning of '<em><b>DB2UDB For ISeries Toolbox XA</b></em>' literal object isn't
	 * clear, there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #DB2UDB_FOR_ISERIES_TOOLBOX_XA_LITERAL
	 * @model name="DB2UDBForISeriesToolboxXA" literal="DB2 UDB for iSeries (Toolbox XA)"
	 * @generated
	 * @ordered
	 */
	public static final int DB2UDB_FOR_ISERIES_TOOLBOX_XA = 8;

	/**
	 * The '<em><b>DB2 For ZOS Local JDBC Provider RRS</b></em>' literal value. <!--
	 * begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>DB2 For ZOS Local JDBC Provider RRS</b></em>' literal object
	 * isn't clear, there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * 
	 * @see #DB2_FOR_ZOS_LOCAL_JDBC_PROVIDER_RRS_LITERAL
	 * @model name="DB2ForZOSLocalJDBCProviderRRS" literal="DB2 for zOS Local JDBC Provider (RRS)"
	 * @generated
	 * @ordered
	 */
	public static final int DB2_FOR_ZOS_LOCAL_JDBC_PROVIDER_RRS = 9;

	/**
	 * The '<em><b>None</b></em>' literal object.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see #NONE
	 * @generated
	 * @ordered
	 */
	public static final DB2JdbcProviderType NONE_LITERAL = new DB2JdbcProviderType(NONE, "none", "none"); //$NON-NLS-1$ //$NON-NLS-2$

	/**
	 * The '<em><b>DB2 Universal JDBC Driver Provider</b></em>' literal object. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see #DB2_UNIVERSAL_JDBC_DRIVER_PROVIDER
	 * @generated
	 * @ordered
	 */
	public static final DB2JdbcProviderType DB2_UNIVERSAL_JDBC_DRIVER_PROVIDER_LITERAL = new DB2JdbcProviderType(DB2_UNIVERSAL_JDBC_DRIVER_PROVIDER, "DB2UniversalJDBCDriverProvider", "DB2 Universal JDBC Driver Provider"); //$NON-NLS-1$ //$NON-NLS-2$

	/**
	 * The '<em><b>DB2 Universal JDBC Driver Provider XA</b></em>' literal object. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see #DB2_UNIVERSAL_JDBC_DRIVER_PROVIDER_XA
	 * @generated
	 * @ordered
	 */
	public static final DB2JdbcProviderType DB2_UNIVERSAL_JDBC_DRIVER_PROVIDER_XA_LITERAL = new DB2JdbcProviderType(DB2_UNIVERSAL_JDBC_DRIVER_PROVIDER_XA, "DB2UniversalJDBCDriverProviderXA", "DB2 Universal JDBC Driver Provider (XA)"); //$NON-NLS-1$ //$NON-NLS-2$

	/**
	 * The '<em><b>DB2 Legacy CLI Based Type2 JDBC Driver</b></em>' literal object. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see #DB2_LEGACY_CLI_BASED_TYPE2_JDBC_DRIVER
	 * @generated
	 * @ordered
	 */
	public static final DB2JdbcProviderType DB2_LEGACY_CLI_BASED_TYPE2_JDBC_DRIVER_LITERAL = new DB2JdbcProviderType(DB2_LEGACY_CLI_BASED_TYPE2_JDBC_DRIVER, "DB2LegacyCLIBasedType2JDBCDriver", "DB2 Legacy CLI-based Type 2 JDBC Driver"); //$NON-NLS-1$ //$NON-NLS-2$

	/**
	 * The '<em><b>DB2 Legacy CLI Based Type2 JDBC Driver XA</b></em>' literal object. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see #DB2_LEGACY_CLI_BASED_TYPE2_JDBC_DRIVER_XA
	 * @generated
	 * @ordered
	 */
	public static final DB2JdbcProviderType DB2_LEGACY_CLI_BASED_TYPE2_JDBC_DRIVER_XA_LITERAL = new DB2JdbcProviderType(DB2_LEGACY_CLI_BASED_TYPE2_JDBC_DRIVER_XA, "DB2LegacyCLIBasedType2JDBCDriverXA", "DB2 Legacy CLI-based Type 2 JDBC Driver (XA)"); //$NON-NLS-1$ //$NON-NLS-2$

	/**
	 * The '<em><b>DB2UDB For ISeries Native</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #DB2UDB_FOR_ISERIES_NATIVE
	 * @generated
	 * @ordered
	 */
	public static final DB2JdbcProviderType DB2UDB_FOR_ISERIES_NATIVE_LITERAL = new DB2JdbcProviderType(DB2UDB_FOR_ISERIES_NATIVE, "DB2UDBForISeriesNative", "DB2 UDB for iSeries (Native)"); //$NON-NLS-1$ //$NON-NLS-2$

	/**
	 * The '<em><b>DB2UDB For ISeries Native XA</b></em>' literal object.
	 * <!-- begin-user-doc
	 * --> <!-- end-user-doc -->
	 * @see #DB2UDB_FOR_ISERIES_NATIVE_XA
	 * @generated
	 * @ordered
	 */
	public static final DB2JdbcProviderType DB2UDB_FOR_ISERIES_NATIVE_XA_LITERAL = new DB2JdbcProviderType(DB2UDB_FOR_ISERIES_NATIVE_XA, "DB2UDBForISeriesNativeXA", "DB2 UDB for iSeries (Native XA)"); //$NON-NLS-1$ //$NON-NLS-2$

	/**
	 * The '<em><b>DB2UDB For ISeries Toolbox</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #DB2UDB_FOR_ISERIES_TOOLBOX
	 * @generated
	 * @ordered
	 */
	public static final DB2JdbcProviderType DB2UDB_FOR_ISERIES_TOOLBOX_LITERAL = new DB2JdbcProviderType(DB2UDB_FOR_ISERIES_TOOLBOX, "DB2UDBForISeriesToolbox", "DB2 UDB for iSeries (Toolbox)"); //$NON-NLS-1$ //$NON-NLS-2$

	/**
	 * The '<em><b>DB2UDB For ISeries Toolbox XA</b></em>' literal object.
	 * <!-- begin-user-doc
	 * --> <!-- end-user-doc -->
	 * @see #DB2UDB_FOR_ISERIES_TOOLBOX_XA
	 * @generated
	 * @ordered
	 */
	public static final DB2JdbcProviderType DB2UDB_FOR_ISERIES_TOOLBOX_XA_LITERAL = new DB2JdbcProviderType(DB2UDB_FOR_ISERIES_TOOLBOX_XA, "DB2UDBForISeriesToolboxXA", "DB2 UDB for iSeries (Toolbox XA)"); //$NON-NLS-1$ //$NON-NLS-2$

	/**
	 * The '<em><b>DB2 For ZOS Local JDBC Provider RRS</b></em>' literal object. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see #DB2_FOR_ZOS_LOCAL_JDBC_PROVIDER_RRS
	 * @generated
	 * @ordered
	 */
	public static final DB2JdbcProviderType DB2_FOR_ZOS_LOCAL_JDBC_PROVIDER_RRS_LITERAL = new DB2JdbcProviderType(DB2_FOR_ZOS_LOCAL_JDBC_PROVIDER_RRS, "DB2ForZOSLocalJDBCProviderRRS", "DB2 for zOS Local JDBC Provider (RRS)"); //$NON-NLS-1$ //$NON-NLS-2$

	/**
	 * An array of all the '<em><b>DB2 Jdbc Provider Type</b></em>' enumerators. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	private static final DB2JdbcProviderType[] VALUES_ARRAY = new DB2JdbcProviderType[] {
			NONE_LITERAL,
			DB2_UNIVERSAL_JDBC_DRIVER_PROVIDER_LITERAL,
			DB2_UNIVERSAL_JDBC_DRIVER_PROVIDER_XA_LITERAL,
			DB2_LEGACY_CLI_BASED_TYPE2_JDBC_DRIVER_LITERAL,
			DB2_LEGACY_CLI_BASED_TYPE2_JDBC_DRIVER_XA_LITERAL,
			DB2UDB_FOR_ISERIES_NATIVE_LITERAL,
			DB2UDB_FOR_ISERIES_NATIVE_XA_LITERAL,
			DB2UDB_FOR_ISERIES_TOOLBOX_LITERAL,
			DB2UDB_FOR_ISERIES_TOOLBOX_XA_LITERAL,
			DB2_FOR_ZOS_LOCAL_JDBC_PROVIDER_RRS_LITERAL,
		};

	/**
	 * A public read-only list of all the '<em><b>DB2 Jdbc Provider Type</b></em>' enumerators.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public static final List VALUES = Collections.unmodifiableList(Arrays.asList(VALUES_ARRAY));

	/**
	 * Returns the '<em><b>DB2 Jdbc Provider Type</b></em>' literal with the specified literal value.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public static DB2JdbcProviderType get(String literal) {
		for (int i = 0; i < VALUES_ARRAY.length; ++i) {
			DB2JdbcProviderType result = VALUES_ARRAY[i];
			if (result.toString().equals(literal)) {
				return result;
			}
		}
		return null;
	}

	/**
	 * Returns the '<em><b>DB2 Jdbc Provider Type</b></em>' literal with the specified name.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public static DB2JdbcProviderType getByName(String name) {
		for (int i = 0; i < VALUES_ARRAY.length; ++i) {
			DB2JdbcProviderType result = VALUES_ARRAY[i];
			if (result.getName().equals(name)) {
				return result;
			}
		}
		return null;
	}

	/**
	 * Returns the '<em><b>DB2 Jdbc Provider Type</b></em>' literal with the specified integer value.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public static DB2JdbcProviderType get(int value) {
		switch (value) {
			case NONE: return NONE_LITERAL;
			case DB2_UNIVERSAL_JDBC_DRIVER_PROVIDER: return DB2_UNIVERSAL_JDBC_DRIVER_PROVIDER_LITERAL;
			case DB2_UNIVERSAL_JDBC_DRIVER_PROVIDER_XA: return DB2_UNIVERSAL_JDBC_DRIVER_PROVIDER_XA_LITERAL;
			case DB2_LEGACY_CLI_BASED_TYPE2_JDBC_DRIVER: return DB2_LEGACY_CLI_BASED_TYPE2_JDBC_DRIVER_LITERAL;
			case DB2_LEGACY_CLI_BASED_TYPE2_JDBC_DRIVER_XA: return DB2_LEGACY_CLI_BASED_TYPE2_JDBC_DRIVER_XA_LITERAL;
			case DB2UDB_FOR_ISERIES_NATIVE: return DB2UDB_FOR_ISERIES_NATIVE_LITERAL;
			case DB2UDB_FOR_ISERIES_NATIVE_XA: return DB2UDB_FOR_ISERIES_NATIVE_XA_LITERAL;
			case DB2UDB_FOR_ISERIES_TOOLBOX: return DB2UDB_FOR_ISERIES_TOOLBOX_LITERAL;
			case DB2UDB_FOR_ISERIES_TOOLBOX_XA: return DB2UDB_FOR_ISERIES_TOOLBOX_XA_LITERAL;
			case DB2_FOR_ZOS_LOCAL_JDBC_PROVIDER_RRS: return DB2_FOR_ZOS_LOCAL_JDBC_PROVIDER_RRS_LITERAL;
		}
		return null;
	}

	/**
	 * Only this class can construct instances.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	private DB2JdbcProviderType(int value, String name, String literal) {
		super(value, name, literal);
	}

} //DB2JdbcProviderType
