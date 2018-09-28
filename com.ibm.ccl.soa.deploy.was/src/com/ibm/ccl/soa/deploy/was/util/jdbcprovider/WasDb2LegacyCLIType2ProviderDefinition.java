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
 * Utility class to define a DB2 Legacy CLI-based Type 2 JDBC Driver.
 */
public class WasDb2LegacyCLIType2ProviderDefinition extends
		WasDb2LegacyCLIType2ProviderBaseDefinition implements IWasJdbcProviderDefinition {

	/**
	 * Template id for a template that can be used to create an instance of this provider.
	 */
	public static final String DB2_LEGACY_CLI_BASED_TYPE2_JDBC_DRIVER_TEMPLATE = IWasTemplateConstants.WAS_DB2_LEGACY_TYPE2_JDBC_PROVIDER_UNIT;

	private static final String DEFAULT_DISPLAY_NAME = "DB2 Legacy CLI-based Type 2 JDBC Driver"; //$NON-NLS-1$

	private static final String DEFAULT_DESCRIPTION = "DB2 JDBC2-compliant Provider"; //$NON-NLS-1$

	private static final String IMPLEMENTATION_CLASS_NAME = "COM.ibm.db2.jdbc.DB2ConnectionPoolDataSource"; //$NON-NLS-1$

	public String getExpectedImplementationClass() {
		return IMPLEMENTATION_CLASS_NAME;
	}

	protected DB2JdbcProviderType getProviderType() {
		return DB2JdbcProviderType.DB2_LEGACY_CLI_BASED_TYPE2_JDBC_DRIVER_LITERAL;
	}

	public String getProviderTypeAsString() {
		return DB2JdbcProviderType.DB2_LEGACY_CLI_BASED_TYPE2_JDBC_DRIVER_LITERAL.toString();
	}

	public String getTemplateId() {
		return DB2_LEGACY_CLI_BASED_TYPE2_JDBC_DRIVER_TEMPLATE;
	}

	public boolean supportsXA() {
		return false;
	}

	protected String getDefaultDisplayName() {
		return DEFAULT_DISPLAY_NAME;
	}

	protected String getDefaultDescription() {
		return DEFAULT_DESCRIPTION;
	}

}
