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
 * Base Utility class to define DB2 Universal JDBC Provider Drivers.
 */
public abstract class WasDb2UniversalProviderBaseDefinition extends WasDB2JdbcProviderDefinition
		implements IWasJdbcProviderDefinition {

	private String DB2UNIVERSAL_JDBC_DRIVER_PATH = null;

	private String DB2UNIVERSAL_JDBC_DRIVER_PATH_VARIABLE = null;

	private static String DB2UNIVERSAL_JDBC_DRIVER_PATH_LITERAL = "DB2UNIVERSAL_JDBC_DRIVER_PATH"; //$NON-NLS-1$

	private String UNIVERSAL_JDBC_DRIVER_PATH = null;

	private String UNIVERSAL_JDBC_DRIVER_PATH_VARIABLE = null;

	private static String UNIVERSAL_JDBC_DRIVER_PATH_LITERAL = "UNIVERSAL_JDBC_DRIVER_PATH"; //$NON-NLS-1$

	private String DB2UNIVERSAL_JDBC_DRIVER_NATIVEPATH = ""; //$NON-NLS-1$

	private String DB2UNIVERSAL_JDBC_DRIVER_NATIVEPATH_VARIABLE = null;

	private static String DB2UNIVERSAL_JDBC_DRIVER_NATIVEPATH_LITERAL = "DB2UNIVERSAL_JDBC_DRIVER_NATIVEPATH"; //$NON-NLS-1$

	protected void defineProvider(JdbcProvider provider, WebsphereContext wasContext,
			DB2JdbcDriver driver) {
		provider.setDisplayName(getDefaultDisplayName());
		provider.setDescription(getDefaultDescription());
		provider.setImplementationClassName(getExpectedImplementationClass());

		provider.setClasspath(getExpectedClassPath(provider, wasContext, driver));

		provider.setNativepath(DB2UNIVERSAL_JDBC_DRIVER_NATIVEPATH);
		provider.setProviderType(getProviderTypeAsString());
		provider.setProviderName(getProviderTypeAsString());

		if (provider instanceof DB2JdbcProvider) {
			((DB2JdbcProvider) provider).setTemplate(getProviderType());
			((DB2JdbcProvider) provider).setJdbcType(JdbcTypeType._4_LITERAL);
		}
	}

	protected void setDriverPaths(WebsphereContext context, DB2JdbcDriver driver) {
		if (context != null) {
			DB2UNIVERSAL_JDBC_DRIVER_PATH_VARIABLE = (String) context
					.getSubstitutionVariableValue(DB2UNIVERSAL_JDBC_DRIVER_PATH_LITERAL);
			UNIVERSAL_JDBC_DRIVER_PATH_VARIABLE = (String) context
					.getSubstitutionVariableValue(UNIVERSAL_JDBC_DRIVER_PATH_LITERAL);
			DB2UNIVERSAL_JDBC_DRIVER_NATIVEPATH_VARIABLE = (String) context
					.getSubstitutionVariableValue(DB2UNIVERSAL_JDBC_DRIVER_NATIVEPATH_LITERAL);
		}

		String driverPath = getDriverPath(driver);

		if (null == driverPath || driverPath.equals(DB2UNIVERSAL_JDBC_DRIVER_PATH_VARIABLE)) {
			DB2UNIVERSAL_JDBC_DRIVER_PATH = "${" + DB2UNIVERSAL_JDBC_DRIVER_PATH_LITERAL + "}/"; //$NON-NLS-1$ //$NON-NLS-2$
		} else {
			DB2UNIVERSAL_JDBC_DRIVER_PATH = driverPath;
		}

		if (null == driverPath || driverPath.equals(UNIVERSAL_JDBC_DRIVER_PATH_VARIABLE)) {
			UNIVERSAL_JDBC_DRIVER_PATH = "${" + UNIVERSAL_JDBC_DRIVER_PATH_LITERAL + "}/"; //$NON-NLS-1$ //$NON-NLS-2$
		} else {
			UNIVERSAL_JDBC_DRIVER_PATH = driverPath;
		}
	}

	protected String getExpectedClassPath() {
		String classPath = DB2UNIVERSAL_JDBC_DRIVER_PATH + "db2jcc.jar"; //$NON-NLS-1$
		classPath += ";" + UNIVERSAL_JDBC_DRIVER_PATH + "db2jcc_license_cu.jar"; //$NON-NLS-1$//$NON-NLS-2$
		classPath += ";" + DB2UNIVERSAL_JDBC_DRIVER_PATH + "db2jcc_license_cisuz.jar"; //$NON-NLS-1$//$NON-NLS-2$
		return classPath;
	}

	public String getExpectedNativepath(JdbcProvider provider, WebsphereContext wasContext) {
		setDriverPaths(wasContext, null);
		String nativepath = DB2UNIVERSAL_JDBC_DRIVER_NATIVEPATH;
		if (null == nativepath) {
			DB2UNIVERSAL_JDBC_DRIVER_NATIVEPATH = "${" + DB2UNIVERSAL_JDBC_DRIVER_NATIVEPATH_LITERAL + "}"; //$NON-NLS-1$//$NON-NLS-2$
		}
		return nativepath;
	}

	public boolean supportsJdbcType(JdbcTypeType jdbcType) {
		return JdbcTypeType._2_LITERAL.equals(jdbcType) || JdbcTypeType._4_LITERAL.equals(jdbcType);
	}

	protected abstract DB2JdbcProviderType getProviderType();

}
