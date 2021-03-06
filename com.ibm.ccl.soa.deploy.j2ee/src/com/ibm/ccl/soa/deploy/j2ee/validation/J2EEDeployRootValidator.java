/*******************************************************************************
 * Copyright (c) 2003, 2007 IBM Corporation Licensed Material - Property of IBM. All rights reserved.
 *  
 * US Government Users Restricted Rights - Use, duplication or disclosure v1.0 restricted by GSA ADP
 * Schedule Contract with IBM Corp.
 * 
 * Contributors: IBM Corporation - initial API and implementation
 *******************************************************************************/
package com.ibm.ccl.soa.deploy.j2ee.validation;

import org.eclipse.emf.common.util.EMap;
import org.eclipse.emf.ecore.util.FeatureMap;

import com.ibm.ccl.soa.deploy.j2ee.AppClient;
import com.ibm.ccl.soa.deploy.j2ee.AppClientModule;
import com.ibm.ccl.soa.deploy.j2ee.EARModuleCapability;
import com.ibm.ccl.soa.deploy.j2ee.EJB;
import com.ibm.ccl.soa.deploy.j2ee.EJBContainer;
import com.ibm.ccl.soa.deploy.j2ee.EJBModuleCapability;
import com.ibm.ccl.soa.deploy.j2ee.EarModule;
import com.ibm.ccl.soa.deploy.j2ee.EjbModule;
import com.ibm.ccl.soa.deploy.j2ee.EntityService;
import com.ibm.ccl.soa.deploy.j2ee.GenericJ2eeServer;
import com.ibm.ccl.soa.deploy.j2ee.GenericWebServer;
import com.ibm.ccl.soa.deploy.j2ee.J2EEContainer;
import com.ibm.ccl.soa.deploy.j2ee.J2EEDatasource;
import com.ibm.ccl.soa.deploy.j2ee.J2EEResourceEnvironmentRequirement;
import com.ibm.ccl.soa.deploy.j2ee.J2EEResourceRequirement;
import com.ibm.ccl.soa.deploy.j2ee.J2EESecurityRole;
import com.ibm.ccl.soa.deploy.j2ee.J2EEServer;
import com.ibm.ccl.soa.deploy.j2ee.JCAContainer;
import com.ibm.ccl.soa.deploy.j2ee.JCAModule;
import com.ibm.ccl.soa.deploy.j2ee.JCAModuleCapability;
import com.ibm.ccl.soa.deploy.j2ee.JSPContainer;
import com.ibm.ccl.soa.deploy.j2ee.JarModule;
import com.ibm.ccl.soa.deploy.j2ee.JarModuleCapability;
import com.ibm.ccl.soa.deploy.j2ee.JavaInterface;
import com.ibm.ccl.soa.deploy.j2ee.ServletContainer;
import com.ibm.ccl.soa.deploy.j2ee.SessionService;
import com.ibm.ccl.soa.deploy.j2ee.URLInterface;
import com.ibm.ccl.soa.deploy.j2ee.URLService;
import com.ibm.ccl.soa.deploy.j2ee.WSDLInterface;
import com.ibm.ccl.soa.deploy.j2ee.WebModule;
import com.ibm.ccl.soa.deploy.j2ee.WebModuleCapability;
import com.ibm.ccl.soa.deploy.j2ee.WebService;

/**
 * A sample validator interface for {@link com.ibm.ccl.soa.deploy.j2ee.J2EEDeployRoot}. This
 * doesn't really do anything, and it's not a real EMF artifact. It was generated by the
 * org.eclipse.emf.examples.generator.validator plug-in to illustrate how EMF's code generator can
 * be extended. This can be disabled with -vmargs
 * -Dorg.eclipse.emf.examples.generator.validator=false.
 */
public interface J2EEDeployRootValidator {
	boolean validate();

	boolean validateMixed(FeatureMap value);

	boolean validateXMLNSPrefixMap(EMap value);

	boolean validateXSISchemaLocation(EMap value);

	boolean validateCapabilityAppClientModule(AppClientModule value);

	boolean validateCapabilityEarModule(EARModuleCapability value);

	boolean validateCapabilityEjb(EJB value);

	boolean validateCapabilityEjbContainer(EJBContainer value);

	boolean validateCapabilityEjbModule(EJBModuleCapability value);

	boolean validateCapabilityJ2eeContainer(J2EEContainer value);

	boolean validateCapabilityJ2eeDatasource(J2EEDatasource value);

	boolean validateCapabilityJ2eeResourceEnvironmentRequirement(
			J2EEResourceEnvironmentRequirement value);

	boolean validateCapabilityJ2eeResourceRequirement(J2EEResourceRequirement value);

	boolean validateCapabilityJ2eeSecurityRole(J2EESecurityRole value);

	boolean validateCapabilityJ2eeServer(J2EEServer value);

	boolean validateCapabilityJarModule(JarModuleCapability value);

	boolean validateCapabilityJcaContainer(JCAContainer value);

	boolean validateCapabilityJcaModule(JCAModuleCapability value);

	boolean validateCapabilityJspContainer(JSPContainer value);

	boolean validateCapabilityServletContainer(ServletContainer value);

	boolean validateCapabilityWebModule(WebModuleCapability value);

	boolean validateComponentEar(EarModule value);

	boolean validateComponentEjb(EjbModule value);

	boolean validateComponentJar(JarModule value);

	boolean validateComponentWeb(WebModule value);

	boolean validateInterfaceJava(JavaInterface value);

	boolean validateInterfaceUrl(URLInterface value);

	boolean validateInterfaceWsdl(WSDLInterface value);

	boolean validateServiceEntity(EntityService value);

	boolean validateServiceServlet(URLService value);

	boolean validateServiceSession(SessionService value);

	boolean validateServiceWs(WebService value);

	boolean validateUnitAppClient(AppClient value);

	boolean validateUnitJ2eeServer(GenericJ2eeServer value);

	boolean validateUnitJcaModule(JCAModule value);

	boolean validateUnitWebServer(GenericWebServer value);
}
