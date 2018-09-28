/*******************************************************************************
 * Copyright (c) 2003, 2007 IBM Corporation Licensed Material - Property of IBM. All rights reserved.
 *  
 * US Government Users Restricted Rights - Use, duplication or disclosure v1.0 restricted by GSA ADP
 * Schedule Contract with IBM Corp.
 * 
 * Contributors: IBM Corporation - initial API and implementation
 *******************************************************************************/
package com.ibm.ccl.soa.deploy.j2ee;

import org.eclipse.emf.ecore.EFactory;

/**
 * <!-- begin-user-doc --> The <b>Factory</b> for the model. It provides a create method for each
 * non-abstract class of the model. <!-- end-user-doc -->
 * @see com.ibm.ccl.soa.deploy.j2ee.J2eePackage
 * @generated
 */
public interface J2eeFactory extends EFactory {
	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	String copyright = "Copyright (c) 2005, 2006 IBM Corporation. Licensed Material - Property of IBM. All rights reserved."; //$NON-NLS-1$

	/**
	 * The singleton instance of the factory.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	J2eeFactory eINSTANCE = com.ibm.ccl.soa.deploy.j2ee.impl.J2eeFactoryImpl.init();

	/**
	 * Returns a new object of class '<em>App Client</em>'.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @return a new object of class '<em>App Client</em>'.
	 * @generated
	 */
	AppClient createAppClient();

	/**
	 * Returns a new object of class '<em>App Client Module</em>'.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @return a new object of class '<em>App Client Module</em>'.
	 * @generated
	 */
	AppClientModule createAppClientModule();

	/**
	 * Returns a new object of class '<em>Ear Module</em>'.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @return a new object of class '<em>Ear Module</em>'.
	 * @generated
	 */
	EarModule createEarModule();

	/**
	 * Returns a new object of class '<em>EAR Module Capability</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>EAR Module Capability</em>'.
	 * @generated
	 */
	EARModuleCapability createEARModuleCapability();

	/**
	 * Returns a new object of class '<em>EJB</em>'. <!-- begin-user-doc --> <!-- end-user-doc
	 * -->
	 * 
	 * @return a new object of class '<em>EJB</em>'.
	 * @generated
	 */
	EJB createEJB();

	/**
	 * Returns a new object of class '<em>EJB Container</em>'.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @return a new object of class '<em>EJB Container</em>'.
	 * @generated
	 */
	EJBContainer createEJBContainer();

	/**
	 * Returns a new object of class '<em>Ejb Module</em>'.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @return a new object of class '<em>Ejb Module</em>'.
	 * @generated
	 */
	EjbModule createEjbModule();

	/**
	 * Returns a new object of class '<em>EJB Module Capability</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>EJB Module Capability</em>'.
	 * @generated
	 */
	EJBModuleCapability createEJBModuleCapability();

	/**
	 * Returns a new object of class '<em>Enterprise Bean Service</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Enterprise Bean Service</em>'.
	 * @generated
	 */
	EnterpriseBeanService createEnterpriseBeanService();

	/**
	 * Returns a new object of class '<em>Entity Service</em>'.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @return a new object of class '<em>Entity Service</em>'.
	 * @generated
	 */
	EntityService createEntityService();

	/**
	 * Returns a new object of class '<em>Generic J2ee Server</em>'.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @return a new object of class '<em>Generic J2ee Server</em>'.
	 * @generated
	 */
	GenericJ2eeServer createGenericJ2eeServer();

	/**
	 * Returns a new object of class '<em>Generic Web Server</em>'.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @return a new object of class '<em>Generic Web Server</em>'.
	 * @generated
	 */
	GenericWebServer createGenericWebServer();

	/**
	 * Returns a new object of class '<em>J2C Authentication Data Entry</em>'. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return a new object of class '<em>J2C Authentication Data Entry</em>'.
	 * @generated
	 */
	J2CAuthenticationDataEntry createJ2CAuthenticationDataEntry();

	/**
	 * Returns a new object of class '<em>J2EE Container</em>'.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @return a new object of class '<em>J2EE Container</em>'.
	 * @generated
	 */
	J2EEContainer createJ2EEContainer();

	/**
	 * Returns a new object of class '<em>J2EE Datasource</em>'.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @return a new object of class '<em>J2EE Datasource</em>'.
	 * @generated
	 */
	J2EEDatasource createJ2EEDatasource();

	/**
	 * Returns a new object of class '<em>J2EE Deploy Root</em>'.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @return a new object of class '<em>J2EE Deploy Root</em>'.
	 * @generated
	 */
	J2EEDeployRoot createJ2EEDeployRoot();

	/**
	 * Returns a new object of class '<em>J2EE Module Capability</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>J2EE Module Capability</em>'.
	 * @generated
	 */
	J2EEModuleCapability createJ2EEModuleCapability();

	/**
	 * Returns a new object of class '<em>J2EE Resource Environment Requirement</em>'. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return a new object of class '<em>J2EE Resource Environment Requirement</em>'.
	 * @generated
	 */
	J2EEResourceEnvironmentRequirement createJ2EEResourceEnvironmentRequirement();

	/**
	 * Returns a new object of class '<em>J2EE Resource Requirement</em>'.
	 * <!-- begin-user-doc
	 * --> <!-- end-user-doc -->
	 * @return a new object of class '<em>J2EE Resource Requirement</em>'.
	 * @generated
	 */
	J2EEResourceRequirement createJ2EEResourceRequirement();

	/**
	 * Returns a new object of class '<em>J2EE Security Role</em>'.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @return a new object of class '<em>J2EE Security Role</em>'.
	 * @generated
	 */
	J2EESecurityRole createJ2EESecurityRole();

	/**
	 * Returns a new object of class '<em>J2EE Server</em>'.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @return a new object of class '<em>J2EE Server</em>'.
	 * @generated
	 */
	J2EEServer createJ2EEServer();

	/**
	 * Returns a new object of class '<em>J2EE Server Unit</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>J2EE Server Unit</em>'.
	 * @generated
	 */
	J2EEServerUnit createJ2EEServerUnit();

	/**
	 * Returns a new object of class '<em>Jar Module</em>'.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @return a new object of class '<em>Jar Module</em>'.
	 * @generated
	 */
	JarModule createJarModule();

	/**
	 * Returns a new object of class '<em>Jar Module Capability</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Jar Module Capability</em>'.
	 * @generated
	 */
	JarModuleCapability createJarModuleCapability();

	/**
	 * Returns a new object of class '<em>Java Interface</em>'.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @return a new object of class '<em>Java Interface</em>'.
	 * @generated
	 */
	JavaInterface createJavaInterface();

	/**
	 * Returns a new object of class '<em>JCA Container</em>'.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @return a new object of class '<em>JCA Container</em>'.
	 * @generated
	 */
	JCAContainer createJCAContainer();

	/**
	 * Returns a new object of class '<em>JCA Module</em>'.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @return a new object of class '<em>JCA Module</em>'.
	 * @generated
	 */
	JCAModule createJCAModule();

	/**
	 * Returns a new object of class '<em>JCA Module Capability</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>JCA Module Capability</em>'.
	 * @generated
	 */
	JCAModuleCapability createJCAModuleCapability();

	/**
	 * Returns a new object of class '<em>JSP Container</em>'.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @return a new object of class '<em>JSP Container</em>'.
	 * @generated
	 */
	JSPContainer createJSPContainer();

	/**
	 * Returns a new object of class '<em>Servlet Container</em>'.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @return a new object of class '<em>Servlet Container</em>'.
	 * @generated
	 */
	ServletContainer createServletContainer();

	/**
	 * Returns a new object of class '<em>Session Service</em>'.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @return a new object of class '<em>Session Service</em>'.
	 * @generated
	 */
	SessionService createSessionService();

	/**
	 * Returns a new object of class '<em>URL Interface</em>'.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @return a new object of class '<em>URL Interface</em>'.
	 * @generated
	 */
	URLInterface createURLInterface();

	/**
	 * Returns a new object of class '<em>URL Service</em>'.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @return a new object of class '<em>URL Service</em>'.
	 * @generated
	 */
	URLService createURLService();

	/**
	 * Returns a new object of class '<em>Web Module</em>'.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @return a new object of class '<em>Web Module</em>'.
	 * @generated
	 */
	WebModule createWebModule();

	/**
	 * Returns a new object of class '<em>Web Module Capability</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Web Module Capability</em>'.
	 * @generated
	 */
	WebModuleCapability createWebModuleCapability();

	/**
	 * Returns a new object of class '<em>Web Service</em>'.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @return a new object of class '<em>Web Service</em>'.
	 * @generated
	 */
	WebService createWebService();

	/**
	 * Returns a new object of class '<em>WSDL Interface</em>'.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @return a new object of class '<em>WSDL Interface</em>'.
	 * @generated
	 */
	WSDLInterface createWSDLInterface();

	/**
	 * Returns the package supported by this factory.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return the package supported by this factory.
	 * @generated
	 */
	J2eePackage getJ2eePackage();

} //J2eeFactory
