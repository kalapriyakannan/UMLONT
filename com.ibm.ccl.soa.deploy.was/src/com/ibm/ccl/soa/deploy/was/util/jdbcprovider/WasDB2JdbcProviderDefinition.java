/*******************************************************************************
 * Copyright (c) 2003, 2007 IBM Corporation Licensed Material - Property of IBM. All rights reserved.
 *  
 * US Government Users Restricted Rights - Use, duplication or disclosure v1.0 restricted by GSA ADP
 * Schedule Contract with IBM Corp.
 * 
 * Contributors: IBM Corporation - initial API and implementation
 *******************************************************************************/
package com.ibm.ccl.soa.deploy.was.util.jdbcprovider;

import com.ibm.ccl.soa.deploy.core.Unit;
import com.ibm.ccl.soa.deploy.core.validator.ValidatorUtils;
import com.ibm.ccl.soa.deploy.db2.DB2JdbcDriver;
import com.ibm.ccl.soa.deploy.java.JavaPackage;
import com.ibm.ccl.soa.deploy.java.JdbcProvider;
import com.ibm.ccl.soa.deploy.java.JdbcProviderUnit;
import com.ibm.ccl.soa.deploy.java.JdbcTypeType;

/**
 * Utility methods to define JDBC providers for WebSphere.
 */
public abstract class WasDB2JdbcProviderDefinition implements IWasJdbcProviderDefinition {

	public void defineProvider(JdbcProviderUnit providerUnit, DB2JdbcDriver driver) {

		JdbcProvider provider = (JdbcProvider) ValidatorUtils.getFirstCapability(providerUnit,
				JavaPackage.Literals.JDBC_PROVIDER);

		Unit wasHost = ValidatorUtils.getHost(providerUnit);

		WebsphereContext wasContext = null;
		if (wasHost != null) {
			wasContext = new WebsphereContext(wasHost);
		}

		defineProvider(provider, wasContext, driver);

	}

	/**
	 * Set the variables on the {@link JdbcProvider} capability so that it represents an XA provider.
	 * 
	 * @param provider
	 *           the provider capability to define
	 * @param wasContext
	 *           the WebSphere hosting context
	 * @param driver
	 *           the JDBC driver to use if available (may be null)
	 */
	protected abstract void defineProvider(JdbcProvider provider, WebsphereContext wasContext,
			DB2JdbcDriver driver);

	public String getExpectedClassPath(JdbcProvider provider, WebsphereContext wasContext,
			DB2JdbcDriver driver) {
		setDriverPaths(wasContext, driver);
		return getExpectedClassPath();
	}

	protected abstract void setDriverPaths(WebsphereContext wasContext, DB2JdbcDriver driver);

	protected abstract String getExpectedClassPath();

	/**
	 * Get a canonical form of a driver path from the {@link DB2JdbcDriver}. The canonical form uses
	 * "/" as separators and ends in a "/".
	 * 
	 * @param driver
	 *           the driver
	 * @return the driver path
	 */
	public String getDriverPath(DB2JdbcDriver driver) {
		if (driver == null)
			return null;

		String driverPath = getCanonicalDriverPath(driver.getDriverPath());
		// System.out.println ("driver path = " + driverPath); //$NON-NLS-1$
		return driverPath;
	}

	/**
	 * Get a canonical form of a driver path given a path. The canonical form uses "/" as separators
	 * and ends in a "/".
	 * 
	 * @param driverPath
	 *           the driver path
	 * @return the driver path
	 */
	public String getCanonicalDriverPath(String driverPath) {
		if (null == driverPath)
			return driverPath;
		driverPath = driverPath.trim();
		if (driverPath.length() == 0)
			return driverPath; // "/";
		driverPath = driverPath.replace('\\', '/');
		char lastCharacter = driverPath.charAt(driverPath.length() - 1);
		if (lastCharacter != '/') {
			driverPath += '/';
		}
		return driverPath;
	}

	public String getTemplateId() {
		// unless explicitly overridden, we return null
		return null;
	}

	public boolean supportsJdbcType(JdbcTypeType jdbcType) {
		// unless explicitly overridden we don't support any
		return false;
	}

	protected abstract String getDefaultDisplayName();

	protected abstract String getDefaultDescription();

}
