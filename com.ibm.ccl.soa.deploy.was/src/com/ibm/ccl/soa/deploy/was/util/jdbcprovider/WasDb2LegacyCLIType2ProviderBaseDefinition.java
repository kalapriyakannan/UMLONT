/*******************************************************************************
 * Copyright (c) 2003, 2007 IBM Corporation Licensed Material - Property of IBM. All rights reserved.
 *  
 * US Government Users Restricted Rights - Use, duplication or disclosure v1.0 restricted by GSA ADP
 * Schedule Contract with IBM Corp.
 * 
 * Contributors: IBM Corporation - initial API and implementation
 *******************************************************************************/
package com.ibm.ccl.soa.deploy.was.util.jdbcprovider;

import com.ibm.ccl.soa.deploy.db2.DB2JdbcDriver;
import com.ibm.ccl.soa.deploy.java.JdbcProvider;
import com.ibm.ccl.soa.deploy.java.JdbcTypeType;
import com.ibm.ccl.soa.deploy.was.DB2JdbcProvider;
import com.ibm.ccl.soa.deploy.was.DB2JdbcProviderType;

/**
 * Base utility class to define DB2 Legacy CLI-based Type 2 JDBC Drivers.
 */
public abstract class WasDb2LegacyCLIType2ProviderBaseDefinition extends
		WasDB2JdbcProviderDefinition implements IWasJdbcProviderDefinition {

	private String DB2_JDBC_DRIVER_PATH = null;

	private String DB2_JDBC_DRIVER_PATH_VARIABLE = null;

	private static String DB2_JDBC_DRIVER_PATH_LITERAL = "DB2_JDBC_DRIVER_PATH"; //$NON-NLS-1$

	protected void defineProvider(JdbcProvider provider, WebsphereContext wasContext,
			DB2JdbcDriver driver) {
		provider.setDisplayName(getDefaultDisplayName());
		provider.setDescription(getDefaultDescription());
		provider.setImplementationClassName(getExpectedImplementationClass());

		provider.setClasspath(getExpectedClassPath(provider, wasContext, driver));

		provider.setNativepath(null);
		provider.setProviderType(getProviderTypeAsString());
		provider.setProviderName(getProviderTypeAsString());
		if (provider instanceof DB2JdbcProvider) {
			((DB2JdbcProvider) provider).setTemplate(getProviderType());
			((DB2JdbcProvider) provider).setJdbcType(JdbcTypeType._2_LITERAL);
		}
	}

	protected void setDriverPaths(WebsphereContext context, DB2JdbcDriver driver) {
		if (context != null) {
			DB2_JDBC_DRIVER_PATH_VARIABLE = (String) context
					.getSubstitutionVariableValue(DB2_JDBC_DRIVER_PATH_LITERAL);
		}

		String driverPath = getDriverPath(driver);

		if (null == driverPath || driverPath.equals(DB2_JDBC_DRIVER_PATH_VARIABLE)) {
			DB2_JDBC_DRIVER_PATH = "${" + DB2_JDBC_DRIVER_PATH_LITERAL + "}/"; //$NON-NLS-1$ //$NON-NLS-2$
		} else {
			DB2_JDBC_DRIVER_PATH = driverPath;
		}

	}

	protected String getExpectedClassPath() {
		String classPath = DB2_JDBC_DRIVER_PATH + "db2java.zip"; //$NON-NLS-1$
		return classPath;
	}

	public String getExpectedNativepath(JdbcProvider provider, WebsphereContext wasContext) {
		String nativepath = ""; //$NON-NLS-1$
		return nativepath;
	}

	public boolean supportsJdbcType(JdbcTypeType jdbcType) {
		return JdbcTypeType._2_LITERAL.equals(jdbcType);
	}

	protected abstract DB2JdbcProviderType getProviderType();

}
