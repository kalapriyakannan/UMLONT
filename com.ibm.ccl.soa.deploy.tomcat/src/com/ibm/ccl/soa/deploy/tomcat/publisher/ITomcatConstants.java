/*******************************************************************************
 * Copyright (c) 2003, 2007 IBM Corporation Licensed Material - Property of IBM. All rights reserved.
 *  
 * US Government Users Restricted Rights - Use, duplication or disclosure v1.0 restricted by GSA ADP
 * Schedule Contract with IBM Corp.
 * 
 * Contributors: IBM Corporation - initial API and implementation
 *******************************************************************************/
package com.ibm.ccl.soa.deploy.tomcat.publisher;

public interface ITomcatConstants {

	//Constants defined by WTP tomcat contributors

	public final static String TOMCAT_PORT_NAME = "HTTP Connector"; //$NON-NLS-1$

	public final static String APACHE_CONNECTOR = "Apache Connector"; //$NON-NLS-1$

	public final static String AJP_13 = "AJP/1.3"; //$NON-NLS-1$

	public final static String AJP_CONNECTOR_13 = "AJP/1.3 Connector"; //$NON-NLS-1$

	public final static String TOMCAT_ADMIN_PORT = "Tomcat admin port"; //$NON-NLS-1$

	public final static String TOMCAT_HTTP = "HTTP"; //$NON-NLS-1$

	public final static String TOMCAT_HTTP_CONNECTOR = "HTTP Connector"; //$NON-NLS-1$

	///Datasource configuration\\\

	public String CONFIG = "conf"; //$NON-NLS-1$

	public String SERVER = "server.xml"; //$NON-NLS-1$

	public String LIB_PATH = "lib"; //$NON-NLS-1$

	public String COMMON_PATH = "common"; //$NON-NLS-1$

	// needs to be defined on
	// the datasource.
	public String TYPE = "javax.sql.DataSource"; //$NON-NLS-1$

	public String AUTH = "Container"; //$NON-NLS-1$

	public String PARAM_USERNAME = "username"; //$NON-NLS-1$

	public String PARAM_PASSWORD = "password"; //$NON-NLS-1$

	public String PARAM_DRIVER_CLASS = "driverClassName"; //$NON-NLS-1$

	public String PARAM_URL = "url"; //$NON-NLS-1$

	public String GLOBAL_NAMEING_ELEMENT_NAME = "GlobalNamingResources"; //$NON-NLS-1$

	public String PARAM_FACTORY = "factory"; //$NON-NLS-1$

	public String TOMCAT50_DATASOURCE_FACTORY = "org.apache.commons.dbcp.BasicDataSourceFactory"; //$NON-NLS-1$

}
