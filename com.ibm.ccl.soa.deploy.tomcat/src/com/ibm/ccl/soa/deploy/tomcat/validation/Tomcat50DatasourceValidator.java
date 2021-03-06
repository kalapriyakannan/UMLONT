/*******************************************************************************
 * Copyright (c) 2003, 2007 IBM Corporation Licensed Material - Property of IBM. All rights reserved.
 *  
 * US Government Users Restricted Rights - Use, duplication or disclosure v1.0 restricted by GSA ADP
 * Schedule Contract with IBM Corp.
 * 
 * Contributors: IBM Corporation - initial API and implementation
 *******************************************************************************/
package com.ibm.ccl.soa.deploy.tomcat.validation;

/**
 * A sample validator interface for {@link com.ibm.ccl.soa.deploy.tomcat.Tomcat50Datasource}. This
 * doesn't really do anything, and it's not a real EMF artifact. It was generated by the
 * org.eclipse.emf.examples.generator.validator plug-in to illustrate how EMF's code generator can
 * be extended. This can be disabled with -vmargs
 * -Dorg.eclipse.emf.examples.generator.validator=false.
 */
public interface Tomcat50DatasourceValidator {
	boolean validate();

	boolean validateClientJarLocation(String value);

	boolean validateDriverClassName(String value);

	boolean validateFactory(String value);

	boolean validateUrl(String value);
}
