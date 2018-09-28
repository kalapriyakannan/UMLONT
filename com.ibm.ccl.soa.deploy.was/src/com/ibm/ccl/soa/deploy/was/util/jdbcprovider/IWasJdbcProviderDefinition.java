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
import com.ibm.ccl.soa.deploy.java.JdbcProviderUnit;
import com.ibm.ccl.soa.deploy.java.JdbcTypeType;

/**
 * Utility methods to define JDBC providers for WebSphere.
 */
public interface IWasJdbcProviderDefinition {

	/**
	 * Set the variables on the {@link JdbcProvider} capability of a {@link JdbcProviderUnit} so that
	 * it represents a particular JDBC provider.
	 * 
	 * @param providerUnit
	 *           the provider unit to define
	 * @param driver
	 *           the JDBC driver to use if available (may be null)
	 */
	public void defineProvider(JdbcProviderUnit providerUnit, DB2JdbcDriver driver);

	/**
	 * Identify the expected class path for the driver.
	 * 
	 * @param provider
	 *           the provider capability to define
	 * @param wasContext
	 *           the WebSphere hosting context
	 * @param driver
	 *           the JDBC driver to use if available (may be null)
	 * @return the class path
	 */
	public String getExpectedClassPath(JdbcProvider provider, WebsphereContext wasContext,
			DB2JdbcDriver driver);

	/**
	 * Identify the expected navtive path for the driver.
	 * 
	 * @param provider
	 *           the provider capability to define
	 * @param wasContext
	 *           the WebSphere hosting context
	 * @return the class path
	 */
	public String getExpectedNativepath(JdbcProvider provider, WebsphereContext wasContext);

	/**
	 * Determine the expected implementation class name
	 * 
	 * @return the expected implementation class name
	 */
	public String getExpectedImplementationClass();

	/**
	 * Determine the provider type of the definition
	 * 
	 * @return the provider type as a String
	 */
	public String getProviderTypeAsString();

	/**
	 * Determine a template id for a given provider.
	 * 
	 * @return the provider template or null (if none is available)
	 */
	public String getTemplateId();

	/**
	 * Determine if a provider definition is for an XA compliant provider.
	 * 
	 * @return true if so
	 */
	public boolean supportsXA();

	/**
	 * Deteremine if the defined provider supports a given JDBC connection type.
	 * 
	 * @param jdbcType
	 *           the type
	 * @return true if the connection type is supported
	 */
	public boolean supportsJdbcType(JdbcTypeType jdbcType);

}
