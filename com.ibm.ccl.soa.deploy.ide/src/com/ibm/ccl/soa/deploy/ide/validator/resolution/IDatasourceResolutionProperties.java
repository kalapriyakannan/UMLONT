/*******************************************************************************
 * Copyright (c) 2003, 2007 IBM Corporation Licensed Material - Property of IBM. All rights reserved.
 *  
 * US Government Users Restricted Rights - Use, duplication or disclosure v1.0 restricted by GSA ADP
 * Schedule Contract with IBM Corp.
 * 
 * Contributors: IBM Corporation - initial API and implementation
 *******************************************************************************/
package com.ibm.ccl.soa.deploy.ide.validator.resolution;

import org.eclipse.wst.common.frameworks.datamodel.IDataModelProperties;

/**
 * Properties to resolve a was datasource
 * 
 */
public interface IDatasourceResolutionProperties extends IDataModelProperties {

	String SOURCE_UNIT = "IDatasourceResolutionProperties.SOURCE_UNIT"; //$NON-NLS-1$;
	String HOST_UNIT = "IDatasourceResolutionProperties.HOST_UNIT"; //$NON-NLS-1$;

	String DATABASE_CONNECTION = "IDatasourceResolutionProperties.DATABASE_CONNECTION"; //$NON-NLS-1$;
	String DATABASE_UNITS = "IDatasourceResolutionProperties.DATABASE_UNIT"; //$NON-NLS-1$;
	String DATASOURCE_REQUIREMENT = "IDatasourceResolutionProperties.DATASOURCE_REQUIREMENT"; //$NON-NLS-1$;

	String DATABASE_NAME = "IDatasourceResolutionProperties.DATABASE_NAME"; //$NON-NLS-1$;
	String DATABASE_USERNAME = "IDatasourceResolutionProperties.DATABASE_USERNAME"; //$NON-NLS-1$;
	String DATABASE_PASSWORD = "IDatasourceResolutionProperties.DATABASE_PASSWORD"; //$NON-NLS-1$;
	String DATABASE_VERSION = "IDatasourceResolutionProperties.DATABASE_VERSION"; //$NON-NLS-1$;
	String DATABASE_DRIVER_CLASSPATH = "IDatasourceResolutionProperties.DATABASE_DRIVER_CLASSPATH"; //$NON-NLS-1$;
	String DATABASE_DRIVER_CLASSNAME = "IDatasourceResolutionProperties.DATABASE_DRIVER_CLASSNAME"; //$NON-NLS-1$;
	String DATABASE_URL = "IDatasourceResolutionProperties.DATABASE_URL"; //$NON-NLS-1$;
	String EMPTY_STRING = ""; //$NON-NLS-1$
	String RECONNECT = "IDatasourceResolutionProperties.RECONNECT"; //$NON-NLS-1$;
	//String NEW_DATASOURCE_MODE = "IDatasourceResolutionProperties.NEW_DATASOURCE_MODE"; //$NON-NLS-1$;
	//String EXISTING_DATASOURCE_MODE = "IDatasourceResolutionProperties.EXISTING_DATASOURCE_MODE"; //$NON-NLS-1$;
	//String EXISTING_DATASOURCE = "IDatasourceResolutionProperties.EXISTING_DATASOURCE"; //$NON-NLS-1$;

}
