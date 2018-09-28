/***************************************************************************************************
 * Copyright (c) 2003, 2007 IBM Corporation Licensed Material - Property of IBM. All rights
 * reserved.
 * 
 * US Government Users Restricted Rights - Use, duplication or disclosure v1.0 restricted by GSA ADP
 * Schedule Contract with IBM Corp.
 * 
 * Contributors: IBM Corporation - initial API and implementation
 **************************************************************************************************/
package com.ibm.ccl.soa.deploy.was.util.jdbcprovider;

import com.ibm.ccl.soa.deploy.was.DB2JdbcProviderType;
import com.ibm.ccl.soa.deploy.was.IWasTemplateConstants;

/**
 * Utility class to define a DB2 Universal JDBC Provider Driver
 */
public class WasDb2UniversalProviderDefinition extends WasDb2UniversalProviderBaseDefinition
		implements IWasJdbcProviderDefinition {

	/**
	 * Template id for a template that can be used to create an instance of this provider.
	 */
	public static final String DB2_UNIVERSAL_JDBC_DRIVER_PROVIDER_TEMPLATE = IWasTemplateConstants.WAS_DB2_UNIVERSAL_JDBC_PROVIDER_UNIT;

	private static final String DEFAULT_DISPLAY_NAME = "DB2 Universal JDBC Provider Driver"; //$NON-NLS-1$

	private static final String DEFAULT_DESCRIPTION = "Non-XA DB2 Universal JDBC Driver-compliant provider"; //$NON-NLS-1$

	private static final String IMPLEMENTATION_CLASS_NAME = "com.ibm.db2.jcc.DB2ConnectionPoolDataSource"; //$NON-NLS-1$

	public String getExpectedImplementationClass() {
		return IMPLEMENTATION_CLASS_NAME;
	}

	public DB2JdbcProviderType getProviderType() {
		return DB2JdbcProviderType.DB2_UNIVERSAL_JDBC_DRIVER_PROVIDER_LITERAL;
	}

	public String getProviderTypeAsString() {
		return DB2JdbcProviderType.DB2_UNIVERSAL_JDBC_DRIVER_PROVIDER_LITERAL.toString();
	}

	public String getTemplateId() {
		return DB2_UNIVERSAL_JDBC_DRIVER_PROVIDER_TEMPLATE;
	}

	protected String getDefaultDisplayName() {
		return DEFAULT_DISPLAY_NAME;
	}

	protected String getDefaultDescription() {
		return DEFAULT_DESCRIPTION;
	}

	public boolean supportsXA() {
		return false;
	}
}
