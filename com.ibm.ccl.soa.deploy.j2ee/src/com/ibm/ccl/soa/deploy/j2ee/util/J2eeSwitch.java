/***************************************************************************************************
 * Copyright (c) 2003, 2007 IBM Corporation Licensed Material - Property of IBM. All rights
 * reserved.
 * 
 * US Government Users Restricted Rights - Use, duplication or disclosure v1.0 restricted by GSA ADP
 * Schedule Contract with IBM Corp.
 * 
 * Contributors: IBM Corporation - initial API and implementation
 **************************************************************************************************/
package com.ibm.ccl.soa.deploy.j2ee.util;

import java.util.List;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;

import com.ibm.ccl.soa.deploy.core.BaseComponentUnit;
import com.ibm.ccl.soa.deploy.core.BundleCapability;
import com.ibm.ccl.soa.deploy.core.Capability;
import com.ibm.ccl.soa.deploy.core.DeployModelObject;
import com.ibm.ccl.soa.deploy.core.Interface;
import com.ibm.ccl.soa.deploy.core.Service;
import com.ibm.ccl.soa.deploy.core.SoftwareComponent;
import com.ibm.ccl.soa.deploy.core.Unit;
import com.ibm.ccl.soa.deploy.j2ee.AppClient;
import com.ibm.ccl.soa.deploy.j2ee.AppClientModule;
import com.ibm.ccl.soa.deploy.j2ee.EARModuleCapability;
import com.ibm.ccl.soa.deploy.j2ee.EJB;
import com.ibm.ccl.soa.deploy.j2ee.EJBContainer;
import com.ibm.ccl.soa.deploy.j2ee.EJBModuleCapability;
import com.ibm.ccl.soa.deploy.j2ee.EarModule;
import com.ibm.ccl.soa.deploy.j2ee.EjbModule;
import com.ibm.ccl.soa.deploy.j2ee.EnterpriseBeanService;
import com.ibm.ccl.soa.deploy.j2ee.EntityService;
import com.ibm.ccl.soa.deploy.j2ee.GenericJ2eeServer;
import com.ibm.ccl.soa.deploy.j2ee.GenericWebServer;
import com.ibm.ccl.soa.deploy.j2ee.J2CAuthenticationDataEntry;
import com.ibm.ccl.soa.deploy.j2ee.J2CAuthenticationUnit;
import com.ibm.ccl.soa.deploy.j2ee.J2EEContainer;
import com.ibm.ccl.soa.deploy.j2ee.J2EEDatasource;
import com.ibm.ccl.soa.deploy.j2ee.J2EEDeployRoot;
import com.ibm.ccl.soa.deploy.j2ee.J2EEModuleCapability;
import com.ibm.ccl.soa.deploy.j2ee.J2EEResourceEnvironmentRequirement;
import com.ibm.ccl.soa.deploy.j2ee.J2EEResourceRequirement;
import com.ibm.ccl.soa.deploy.j2ee.J2EESecurityRole;
import com.ibm.ccl.soa.deploy.j2ee.J2EEServer;
import com.ibm.ccl.soa.deploy.j2ee.J2EEServerUnit;
import com.ibm.ccl.soa.deploy.j2ee.J2eePackage;
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
 * <!-- begin-user-doc --> The <b>Switch</b> for the model's inheritance hierarchy. It supports the
 * call {@link #doSwitch(EObject) doSwitch(object)} to invoke the <code>caseXXX</code> method for
 * each class of the model, starting with the actual class of the object and proceeding up the
 * inheritance hierarchy until a non-null result is returned, which is the result of the switch.
 * <!-- end-user-doc -->
 * @see com.ibm.ccl.soa.deploy.j2ee.J2eePackage
 * @generated
 */
public class J2eeSwitch {
	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public static final String copyright = "Copyright (c) 2005, 2006 IBM Corporation. Licensed Material - Property of IBM. All rights reserved."; //$NON-NLS-1$

	/**
	 * The cached model package
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	protected static J2eePackage modelPackage;

	/**
	 * Creates an instance of the switch.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public J2eeSwitch() {
		if (modelPackage == null) {
			modelPackage = J2eePackage.eINSTANCE;
		}
	}

	/**
	 * Calls <code>caseXXX</code> for each class of the model until one returns a non null result; it yields that result.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return the first non-null result returned by a <code>caseXXX</code> call.
	 * @generated
	 */
	public Object doSwitch(EObject theEObject) {
		return doSwitch(theEObject.eClass(), theEObject);
	}

	/**
	 * Calls <code>caseXXX</code> for each class of the model until one returns a non null result; it yields that result.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return the first non-null result returned by a <code>caseXXX</code> call.
	 * @generated
	 */
	protected Object doSwitch(EClass theEClass, EObject theEObject) {
		if (theEClass.eContainer() == modelPackage) {
			return doSwitch(theEClass.getClassifierID(), theEObject);
		} else {
			List eSuperTypes = theEClass.getESuperTypes();
			return eSuperTypes.isEmpty() ? defaultCase(theEObject) : doSwitch((EClass) eSuperTypes
					.get(0), theEObject);
		}
	}

	/**
	 * Calls <code>caseXXX</code> for each class of the model until one returns a non null result; it yields that result.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return the first non-null result returned by a <code>caseXXX</code> call.
	 * @generated
	 */
	protected Object doSwitch(int classifierID, EObject theEObject) {
		switch (classifierID)
		{
		case J2eePackage.APP_CLIENT: {
			AppClient appClient = (AppClient) theEObject;
			Object result = caseAppClient(appClient);
			if (result == null)
				result = caseUnit(appClient);
			if (result == null)
				result = caseDeployModelObject(appClient);
			if (result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case J2eePackage.APP_CLIENT_MODULE: {
			AppClientModule appClientModule = (AppClientModule) theEObject;
			Object result = caseAppClientModule(appClientModule);
			if (result == null)
				result = caseJ2EEModuleCapability(appClientModule);
			if (result == null)
				result = caseBundleCapability(appClientModule);
			if (result == null)
				result = caseCapability(appClientModule);
			if (result == null)
				result = caseDeployModelObject(appClientModule);
			if (result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case J2eePackage.EAR_MODULE: {
			EarModule earModule = (EarModule) theEObject;
			Object result = caseEarModule(earModule);
			if (result == null)
				result = caseSoftwareComponent(earModule);
			if (result == null)
				result = caseBaseComponentUnit(earModule);
			if (result == null)
				result = caseUnit(earModule);
			if (result == null)
				result = caseDeployModelObject(earModule);
			if (result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case J2eePackage.EAR_MODULE_CAPABILITY: {
			EARModuleCapability earModuleCapability = (EARModuleCapability) theEObject;
			Object result = caseEARModuleCapability(earModuleCapability);
			if (result == null)
				result = caseJ2EEModuleCapability(earModuleCapability);
			if (result == null)
				result = caseBundleCapability(earModuleCapability);
			if (result == null)
				result = caseCapability(earModuleCapability);
			if (result == null)
				result = caseDeployModelObject(earModuleCapability);
			if (result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case J2eePackage.EJB: {
			EJB ejb = (EJB) theEObject;
			Object result = caseEJB(ejb);
			if (result == null)
				result = caseCapability(ejb);
			if (result == null)
				result = caseDeployModelObject(ejb);
			if (result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case J2eePackage.EJB_CONTAINER: {
			EJBContainer ejbContainer = (EJBContainer) theEObject;
			Object result = caseEJBContainer(ejbContainer);
			if (result == null)
				result = caseCapability(ejbContainer);
			if (result == null)
				result = caseDeployModelObject(ejbContainer);
			if (result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case J2eePackage.EJB_MODULE: {
			EjbModule ejbModule = (EjbModule) theEObject;
			Object result = caseEjbModule(ejbModule);
			if (result == null)
				result = caseSoftwareComponent(ejbModule);
			if (result == null)
				result = caseBaseComponentUnit(ejbModule);
			if (result == null)
				result = caseUnit(ejbModule);
			if (result == null)
				result = caseDeployModelObject(ejbModule);
			if (result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case J2eePackage.EJB_MODULE_CAPABILITY: {
			EJBModuleCapability ejbModuleCapability = (EJBModuleCapability) theEObject;
			Object result = caseEJBModuleCapability(ejbModuleCapability);
			if (result == null)
				result = caseJ2EEModuleCapability(ejbModuleCapability);
			if (result == null)
				result = caseBundleCapability(ejbModuleCapability);
			if (result == null)
				result = caseCapability(ejbModuleCapability);
			if (result == null)
				result = caseDeployModelObject(ejbModuleCapability);
			if (result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case J2eePackage.ENTERPRISE_BEAN_SERVICE: {
			EnterpriseBeanService enterpriseBeanService = (EnterpriseBeanService) theEObject;
			Object result = caseEnterpriseBeanService(enterpriseBeanService);
			if (result == null)
				result = caseService(enterpriseBeanService);
			if (result == null)
				result = caseCapability(enterpriseBeanService);
			if (result == null)
				result = caseDeployModelObject(enterpriseBeanService);
			if (result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case J2eePackage.ENTITY_SERVICE: {
			EntityService entityService = (EntityService) theEObject;
			Object result = caseEntityService(entityService);
			if (result == null)
				result = caseEnterpriseBeanService(entityService);
			if (result == null)
				result = caseService(entityService);
			if (result == null)
				result = caseCapability(entityService);
			if (result == null)
				result = caseDeployModelObject(entityService);
			if (result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case J2eePackage.GENERIC_J2EE_SERVER: {
			GenericJ2eeServer genericJ2eeServer = (GenericJ2eeServer) theEObject;
			Object result = caseGenericJ2eeServer(genericJ2eeServer);
			if (result == null)
				result = caseGenericWebServer(genericJ2eeServer);
			if (result == null)
				result = caseUnit(genericJ2eeServer);
			if (result == null)
				result = caseDeployModelObject(genericJ2eeServer);
			if (result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case J2eePackage.GENERIC_WEB_SERVER: {
			GenericWebServer genericWebServer = (GenericWebServer) theEObject;
			Object result = caseGenericWebServer(genericWebServer);
			if (result == null)
				result = caseUnit(genericWebServer);
			if (result == null)
				result = caseDeployModelObject(genericWebServer);
			if (result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case J2eePackage.J2C_AUTHENTICATION_DATA_ENTRY: {
			J2CAuthenticationDataEntry j2CAuthenticationDataEntry = (J2CAuthenticationDataEntry) theEObject;
			Object result = caseJ2CAuthenticationDataEntry(j2CAuthenticationDataEntry);
			if (result == null)
				result = caseCapability(j2CAuthenticationDataEntry);
			if (result == null)
				result = caseDeployModelObject(j2CAuthenticationDataEntry);
			if (result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case J2eePackage.J2C_AUTHENTICATION_UNIT: {
			J2CAuthenticationUnit j2CAuthenticationUnit = (J2CAuthenticationUnit) theEObject;
			Object result = caseJ2CAuthenticationUnit(j2CAuthenticationUnit);
			if (result == null)
				result = caseUnit(j2CAuthenticationUnit);
			if (result == null)
				result = caseDeployModelObject(j2CAuthenticationUnit);
			if (result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case J2eePackage.J2EE_CONTAINER: {
			J2EEContainer j2EEContainer = (J2EEContainer) theEObject;
			Object result = caseJ2EEContainer(j2EEContainer);
			if (result == null)
				result = caseCapability(j2EEContainer);
			if (result == null)
				result = caseDeployModelObject(j2EEContainer);
			if (result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case J2eePackage.J2EE_DATASOURCE: {
			J2EEDatasource j2EEDatasource = (J2EEDatasource) theEObject;
			Object result = caseJ2EEDatasource(j2EEDatasource);
			if (result == null)
				result = caseCapability(j2EEDatasource);
			if (result == null)
				result = caseDeployModelObject(j2EEDatasource);
			if (result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case J2eePackage.J2EE_DEPLOY_ROOT: {
			J2EEDeployRoot j2EEDeployRoot = (J2EEDeployRoot) theEObject;
			Object result = caseJ2EEDeployRoot(j2EEDeployRoot);
			if (result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case J2eePackage.J2EE_MODULE_CAPABILITY: {
			J2EEModuleCapability j2EEModuleCapability = (J2EEModuleCapability) theEObject;
			Object result = caseJ2EEModuleCapability(j2EEModuleCapability);
			if (result == null)
				result = caseBundleCapability(j2EEModuleCapability);
			if (result == null)
				result = caseCapability(j2EEModuleCapability);
			if (result == null)
				result = caseDeployModelObject(j2EEModuleCapability);
			if (result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case J2eePackage.J2EE_RESOURCE_ENVIRONMENT_REQUIREMENT: {
			J2EEResourceEnvironmentRequirement j2EEResourceEnvironmentRequirement = (J2EEResourceEnvironmentRequirement) theEObject;
			Object result = caseJ2EEResourceEnvironmentRequirement(j2EEResourceEnvironmentRequirement);
			if (result == null)
				result = caseCapability(j2EEResourceEnvironmentRequirement);
			if (result == null)
				result = caseDeployModelObject(j2EEResourceEnvironmentRequirement);
			if (result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case J2eePackage.J2EE_RESOURCE_REQUIREMENT: {
			J2EEResourceRequirement j2EEResourceRequirement = (J2EEResourceRequirement) theEObject;
			Object result = caseJ2EEResourceRequirement(j2EEResourceRequirement);
			if (result == null)
				result = caseCapability(j2EEResourceRequirement);
			if (result == null)
				result = caseDeployModelObject(j2EEResourceRequirement);
			if (result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case J2eePackage.J2EE_SECURITY_ROLE: {
			J2EESecurityRole j2EESecurityRole = (J2EESecurityRole) theEObject;
			Object result = caseJ2EESecurityRole(j2EESecurityRole);
			if (result == null)
				result = caseCapability(j2EESecurityRole);
			if (result == null)
				result = caseDeployModelObject(j2EESecurityRole);
			if (result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case J2eePackage.J2EE_SERVER: {
			J2EEServer j2EEServer = (J2EEServer) theEObject;
			Object result = caseJ2EEServer(j2EEServer);
			if (result == null)
				result = caseCapability(j2EEServer);
			if (result == null)
				result = caseDeployModelObject(j2EEServer);
			if (result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case J2eePackage.J2EE_SERVER_UNIT: {
			J2EEServerUnit j2EEServerUnit = (J2EEServerUnit) theEObject;
			Object result = caseJ2EEServerUnit(j2EEServerUnit);
			if (result == null)
				result = caseUnit(j2EEServerUnit);
			if (result == null)
				result = caseDeployModelObject(j2EEServerUnit);
			if (result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case J2eePackage.JAR_MODULE: {
			JarModule jarModule = (JarModule) theEObject;
			Object result = caseJarModule(jarModule);
			if (result == null)
				result = caseSoftwareComponent(jarModule);
			if (result == null)
				result = caseBaseComponentUnit(jarModule);
			if (result == null)
				result = caseUnit(jarModule);
			if (result == null)
				result = caseDeployModelObject(jarModule);
			if (result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case J2eePackage.JAR_MODULE_CAPABILITY: {
			JarModuleCapability jarModuleCapability = (JarModuleCapability) theEObject;
			Object result = caseJarModuleCapability(jarModuleCapability);
			if (result == null)
				result = caseJ2EEModuleCapability(jarModuleCapability);
			if (result == null)
				result = caseBundleCapability(jarModuleCapability);
			if (result == null)
				result = caseCapability(jarModuleCapability);
			if (result == null)
				result = caseDeployModelObject(jarModuleCapability);
			if (result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case J2eePackage.JAVA_INTERFACE: {
			JavaInterface javaInterface = (JavaInterface) theEObject;
			Object result = caseJavaInterface(javaInterface);
			if (result == null)
				result = caseInterface(javaInterface);
			if (result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case J2eePackage.JCA_CONTAINER: {
			JCAContainer jcaContainer = (JCAContainer) theEObject;
			Object result = caseJCAContainer(jcaContainer);
			if (result == null)
				result = caseCapability(jcaContainer);
			if (result == null)
				result = caseDeployModelObject(jcaContainer);
			if (result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case J2eePackage.JCA_MODULE: {
			JCAModule jcaModule = (JCAModule) theEObject;
			Object result = caseJCAModule(jcaModule);
			if (result == null)
				result = caseUnit(jcaModule);
			if (result == null)
				result = caseDeployModelObject(jcaModule);
			if (result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case J2eePackage.JCA_MODULE_CAPABILITY: {
			JCAModuleCapability jcaModuleCapability = (JCAModuleCapability) theEObject;
			Object result = caseJCAModuleCapability(jcaModuleCapability);
			if (result == null)
				result = caseJ2EEModuleCapability(jcaModuleCapability);
			if (result == null)
				result = caseBundleCapability(jcaModuleCapability);
			if (result == null)
				result = caseCapability(jcaModuleCapability);
			if (result == null)
				result = caseDeployModelObject(jcaModuleCapability);
			if (result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case J2eePackage.JSP_CONTAINER: {
			JSPContainer jspContainer = (JSPContainer) theEObject;
			Object result = caseJSPContainer(jspContainer);
			if (result == null)
				result = caseCapability(jspContainer);
			if (result == null)
				result = caseDeployModelObject(jspContainer);
			if (result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case J2eePackage.SERVLET_CONTAINER: {
			ServletContainer servletContainer = (ServletContainer) theEObject;
			Object result = caseServletContainer(servletContainer);
			if (result == null)
				result = caseCapability(servletContainer);
			if (result == null)
				result = caseDeployModelObject(servletContainer);
			if (result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case J2eePackage.SESSION_SERVICE: {
			SessionService sessionService = (SessionService) theEObject;
			Object result = caseSessionService(sessionService);
			if (result == null)
				result = caseEnterpriseBeanService(sessionService);
			if (result == null)
				result = caseService(sessionService);
			if (result == null)
				result = caseCapability(sessionService);
			if (result == null)
				result = caseDeployModelObject(sessionService);
			if (result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case J2eePackage.URL_INTERFACE: {
			URLInterface urlInterface = (URLInterface) theEObject;
			Object result = caseURLInterface(urlInterface);
			if (result == null)
				result = caseInterface(urlInterface);
			if (result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case J2eePackage.URL_SERVICE: {
			URLService urlService = (URLService) theEObject;
			Object result = caseURLService(urlService);
			if (result == null)
				result = caseService(urlService);
			if (result == null)
				result = caseCapability(urlService);
			if (result == null)
				result = caseDeployModelObject(urlService);
			if (result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case J2eePackage.WEB_MODULE: {
			WebModule webModule = (WebModule) theEObject;
			Object result = caseWebModule(webModule);
			if (result == null)
				result = caseSoftwareComponent(webModule);
			if (result == null)
				result = caseBaseComponentUnit(webModule);
			if (result == null)
				result = caseUnit(webModule);
			if (result == null)
				result = caseDeployModelObject(webModule);
			if (result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case J2eePackage.WEB_MODULE_CAPABILITY: {
			WebModuleCapability webModuleCapability = (WebModuleCapability) theEObject;
			Object result = caseWebModuleCapability(webModuleCapability);
			if (result == null)
				result = caseJ2EEModuleCapability(webModuleCapability);
			if (result == null)
				result = caseBundleCapability(webModuleCapability);
			if (result == null)
				result = caseCapability(webModuleCapability);
			if (result == null)
				result = caseDeployModelObject(webModuleCapability);
			if (result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case J2eePackage.WEB_SERVICE: {
			WebService webService = (WebService) theEObject;
			Object result = caseWebService(webService);
			if (result == null)
				result = caseService(webService);
			if (result == null)
				result = caseCapability(webService);
			if (result == null)
				result = caseDeployModelObject(webService);
			if (result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case J2eePackage.WSDL_INTERFACE: {
			WSDLInterface wsdlInterface = (WSDLInterface) theEObject;
			Object result = caseWSDLInterface(wsdlInterface);
			if (result == null)
				result = caseInterface(wsdlInterface);
			if (result == null)
				result = defaultCase(theEObject);
			return result;
		}
		default:
			return defaultCase(theEObject);
		}
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>App Client</em>'.
	 * <!-- begin-user-doc --> This implementation returns null; returning a non-null result will
	 * terminate the switch. <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>App Client</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public Object caseAppClient(AppClient object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>App Client Module</em>'.
	 * <!-- begin-user-doc --> This implementation returns null; returning a non-null result will
	 * terminate the switch. <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>App Client Module</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public Object caseAppClientModule(AppClientModule object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Ear Module</em>'.
	 * <!-- begin-user-doc --> This implementation returns null; returning a non-null result will
	 * terminate the switch. <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Ear Module</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public Object caseEarModule(EarModule object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>EAR Module Capability</em>'.
	 * <!-- begin-user-doc --> This implementation returns null; returning a non-null result will
	 * terminate the switch. <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>EAR Module Capability</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public Object caseEARModuleCapability(EARModuleCapability object) {
		return null;
	}

	/**
	 * Returns the result of interpretting the object as an instance of '<em>EJB</em>'. <!--
	 * begin-user-doc --> This implementation returns null; returning a non-null result will
	 * terminate the switch. <!-- end-user-doc -->
	 * 
	 * @param object
	 *           the target of the switch.
	 * @return the result of interpretting the object as an instance of '<em>EJB</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public Object caseEJB(EJB object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>EJB Container</em>'.
	 * <!-- begin-user-doc --> This implementation returns null; returning a non-null result will
	 * terminate the switch. <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>EJB Container</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public Object caseEJBContainer(EJBContainer object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Ejb Module</em>'.
	 * <!-- begin-user-doc --> This implementation returns null; returning a non-null result will
	 * terminate the switch. <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Ejb Module</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public Object caseEjbModule(EjbModule object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>EJB Module Capability</em>'.
	 * <!-- begin-user-doc --> This implementation returns null; returning a non-null result will
	 * terminate the switch. <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>EJB Module Capability</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public Object caseEJBModuleCapability(EJBModuleCapability object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Enterprise Bean Service</em>'.
	 * <!-- begin-user-doc --> This implementation returns null; returning a non-null result will
	 * terminate the switch. <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Enterprise Bean Service</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public Object caseEnterpriseBeanService(EnterpriseBeanService object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Entity Service</em>'.
	 * <!-- begin-user-doc --> This implementation returns null; returning a non-null result will
	 * terminate the switch. <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Entity Service</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public Object caseEntityService(EntityService object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Generic J2ee Server</em>'.
	 * <!-- begin-user-doc --> This implementation returns null; returning a non-null result will
	 * terminate the switch. <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Generic J2ee Server</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public Object caseGenericJ2eeServer(GenericJ2eeServer object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Generic Web Server</em>'.
	 * <!-- begin-user-doc --> This implementation returns null; returning a non-null result will
	 * terminate the switch. <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Generic Web Server</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public Object caseGenericWebServer(GenericWebServer object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>J2C Authentication Data Entry</em>'.
	 * <!-- begin-user-doc --> This implementation returns null; returning a non-null result will
	 * terminate the switch. <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>J2C Authentication Data Entry</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public Object caseJ2CAuthenticationDataEntry(J2CAuthenticationDataEntry object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>J2C Authentication Unit</em>'.
	 * <!-- begin-user-doc --> This implementation returns null; returning a non-null result will
	 * terminate the switch. <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>J2C Authentication Unit</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public Object caseJ2CAuthenticationUnit(J2CAuthenticationUnit object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>J2EE Container</em>'.
	 * <!-- begin-user-doc --> This implementation returns null; returning a non-null result will
	 * terminate the switch. <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>J2EE Container</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public Object caseJ2EEContainer(J2EEContainer object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>J2EE Datasource</em>'.
	 * <!-- begin-user-doc --> This implementation returns null; returning a non-null result will
	 * terminate the switch. <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>J2EE Datasource</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public Object caseJ2EEDatasource(J2EEDatasource object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>J2EE Deploy Root</em>'.
	 * <!-- begin-user-doc --> This implementation returns null; returning a non-null result will
	 * terminate the switch. <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>J2EE Deploy Root</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public Object caseJ2EEDeployRoot(J2EEDeployRoot object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>J2EE Module Capability</em>'.
	 * <!-- begin-user-doc --> This implementation returns null; returning a non-null result will
	 * terminate the switch. <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>J2EE Module Capability</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public Object caseJ2EEModuleCapability(J2EEModuleCapability object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>J2EE Resource Environment Requirement</em>'.
	 * <!-- begin-user-doc --> This implementation returns null; returning a non-null result will
	 * terminate the switch. <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>J2EE Resource Environment Requirement</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public Object caseJ2EEResourceEnvironmentRequirement(J2EEResourceEnvironmentRequirement object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>J2EE Resource Requirement</em>'.
	 * <!-- begin-user-doc --> This implementation returns null; returning a non-null result will
	 * terminate the switch. <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>J2EE Resource Requirement</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public Object caseJ2EEResourceRequirement(J2EEResourceRequirement object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>J2EE Security Role</em>'.
	 * <!-- begin-user-doc --> This implementation returns null; returning a non-null result will
	 * terminate the switch. <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>J2EE Security Role</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public Object caseJ2EESecurityRole(J2EESecurityRole object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>J2EE Server</em>'.
	 * <!-- begin-user-doc --> This implementation returns null; returning a non-null result will
	 * terminate the switch. <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>J2EE Server</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public Object caseJ2EEServer(J2EEServer object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>J2EE Server Unit</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>J2EE Server Unit</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public Object caseJ2EEServerUnit(J2EEServerUnit object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Jar Module</em>'.
	 * <!-- begin-user-doc --> This implementation returns null; returning a non-null result will
	 * terminate the switch. <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Jar Module</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public Object caseJarModule(JarModule object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Jar Module Capability</em>'.
	 * <!-- begin-user-doc --> This implementation returns null; returning a non-null result will
	 * terminate the switch. <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Jar Module Capability</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public Object caseJarModuleCapability(JarModuleCapability object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Java Interface</em>'.
	 * <!-- begin-user-doc --> This implementation returns null; returning a non-null result will
	 * terminate the switch. <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Java Interface</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public Object caseJavaInterface(JavaInterface object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>JCA Container</em>'.
	 * <!-- begin-user-doc --> This implementation returns null; returning a non-null result will
	 * terminate the switch. <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>JCA Container</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public Object caseJCAContainer(JCAContainer object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>JCA Module</em>'.
	 * <!-- begin-user-doc --> This implementation returns null; returning a non-null result will
	 * terminate the switch. <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>JCA Module</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public Object caseJCAModule(JCAModule object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>JCA Module Capability</em>'.
	 * <!-- begin-user-doc --> This implementation returns null; returning a non-null result will
	 * terminate the switch. <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>JCA Module Capability</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public Object caseJCAModuleCapability(JCAModuleCapability object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>JSP Container</em>'.
	 * <!-- begin-user-doc --> This implementation returns null; returning a non-null result will
	 * terminate the switch. <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>JSP Container</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public Object caseJSPContainer(JSPContainer object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Servlet Container</em>'.
	 * <!-- begin-user-doc --> This implementation returns null; returning a non-null result will
	 * terminate the switch. <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Servlet Container</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public Object caseServletContainer(ServletContainer object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Session Service</em>'.
	 * <!-- begin-user-doc --> This implementation returns null; returning a non-null result will
	 * terminate the switch. <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Session Service</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public Object caseSessionService(SessionService object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>URL Interface</em>'.
	 * <!-- begin-user-doc --> This implementation returns null; returning a non-null result will
	 * terminate the switch. <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>URL Interface</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public Object caseURLInterface(URLInterface object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>URL Service</em>'.
	 * <!-- begin-user-doc --> This implementation returns null; returning a non-null result will
	 * terminate the switch. <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>URL Service</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public Object caseURLService(URLService object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Web Module</em>'.
	 * <!-- begin-user-doc --> This implementation returns null; returning a non-null result will
	 * terminate the switch. <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Web Module</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public Object caseWebModule(WebModule object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Web Module Capability</em>'.
	 * <!-- begin-user-doc --> This implementation returns null; returning a non-null result will
	 * terminate the switch. <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Web Module Capability</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public Object caseWebModuleCapability(WebModuleCapability object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Web Service</em>'.
	 * <!-- begin-user-doc --> This implementation returns null; returning a non-null result will
	 * terminate the switch. <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Web Service</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public Object caseWebService(WebService object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>WSDL Interface</em>'.
	 * <!-- begin-user-doc --> This implementation returns null; returning a non-null result will
	 * terminate the switch. <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>WSDL Interface</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public Object caseWSDLInterface(WSDLInterface object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Deploy Model Object</em>'.
	 * <!-- begin-user-doc --> This implementation returns null; returning a non-null result will
	 * terminate the switch. <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Deploy Model Object</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public Object caseDeployModelObject(DeployModelObject object) {
		return null;
	}

	/**
	 * Returns the result of interpretting the object as an instance of '<em>Unit</em>'. <!--
	 * begin-user-doc --> This implementation returns null; returning a non-null result will
	 * terminate the switch. <!-- end-user-doc -->
	 * 
	 * @param object
	 *           the target of the switch.
	 * @return the result of interpretting the object as an instance of '<em>Unit</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public Object caseUnit(Unit object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Capability</em>'.
	 * <!-- begin-user-doc --> This implementation returns null; returning a non-null result will
	 * terminate the switch. <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Capability</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public Object caseCapability(Capability object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Bundle Capability</em>'.
	 * <!-- begin-user-doc --> This implementation returns null; returning a non-null result will
	 * terminate the switch. <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Bundle Capability</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public Object caseBundleCapability(BundleCapability object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Base Component Unit</em>'.
	 * <!-- begin-user-doc --> This implementation returns null; returning a non-null result will
	 * terminate the switch. <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Base Component Unit</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public Object caseBaseComponentUnit(BaseComponentUnit object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Interface</em>'. <!--
	 * begin-user-doc --> This implementation returns null; returning a non-null result will
	 * terminate the switch. <!-- end-user-doc -->
	 * 
	 * @param object
	 *           the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Interface</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public Object caseInterface(Interface object) {
		return null;
	}

	/**
	 * Returns the result of interpretting the object as an instance of '<em>Service</em>'. <!--
	 * begin-user-doc --> This implementation returns null; returning a non-null result will
	 * terminate the switch. <!-- end-user-doc -->
	 * 
	 * @param object
	 *           the target of the switch.
	 * @return the result of interpretting the object as an instance of '<em>Service</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public Object caseService(Service object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Software Component</em>'.
	 * <!-- begin-user-doc --> This implementation returns null; returning a non-null result will
	 * terminate the switch. <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Software Component</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public Object caseSoftwareComponent(SoftwareComponent object) {
		return null;
	}

	/**
	 * Returns the result of interpretting the object as an instance of '<em>EObject</em>'. <!--
	 * begin-user-doc --> This implementation returns null; returning a non-null result will
	 * terminate the switch, but this is the last case anyway. <!-- end-user-doc -->
	 * 
	 * @param object
	 *           the target of the switch.
	 * @return the result of interpretting the object as an instance of '<em>EObject</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject)
	 * @generated
	 */
	public Object defaultCase(EObject object) {
		return null;
	}

} //J2eeSwitch
