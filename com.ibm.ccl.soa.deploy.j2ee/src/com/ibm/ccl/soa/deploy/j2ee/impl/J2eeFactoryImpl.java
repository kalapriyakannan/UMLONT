/***************************************************************************************************
 * Copyright (c) 2003, 2007 IBM Corporation Licensed Material - Property of IBM. All rights
 * reserved.
 * 
 * US Government Users Restricted Rights - Use, duplication or disclosure v1.0 restricted by GSA ADP
 * Schedule Contract with IBM Corp.
 * 
 * Contributors: IBM Corporation - initial API and implementation
 **************************************************************************************************/
package com.ibm.ccl.soa.deploy.j2ee.impl;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EDataType;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.impl.EFactoryImpl;
import org.eclipse.emf.ecore.plugin.EcorePlugin;

import com.ibm.ccl.soa.deploy.j2ee.AppClient;
import com.ibm.ccl.soa.deploy.j2ee.AppClientModule;
import com.ibm.ccl.soa.deploy.j2ee.EARModuleCapability;
import com.ibm.ccl.soa.deploy.j2ee.EJB;
import com.ibm.ccl.soa.deploy.j2ee.EJBContainer;
import com.ibm.ccl.soa.deploy.j2ee.EJBContainerVersion;
import com.ibm.ccl.soa.deploy.j2ee.EJBModuleCapability;
import com.ibm.ccl.soa.deploy.j2ee.EarModule;
import com.ibm.ccl.soa.deploy.j2ee.EjbModule;
import com.ibm.ccl.soa.deploy.j2ee.EnterpriseBeanService;
import com.ibm.ccl.soa.deploy.j2ee.EntityService;
import com.ibm.ccl.soa.deploy.j2ee.GenericJ2eeServer;
import com.ibm.ccl.soa.deploy.j2ee.GenericWebServer;
import com.ibm.ccl.soa.deploy.j2ee.J2CAuthenticationDataEntry;
import com.ibm.ccl.soa.deploy.j2ee.J2EEContainer;
import com.ibm.ccl.soa.deploy.j2ee.J2EEContainerVersion;
import com.ibm.ccl.soa.deploy.j2ee.J2EEDatasource;
import com.ibm.ccl.soa.deploy.j2ee.J2EEDeployRoot;
import com.ibm.ccl.soa.deploy.j2ee.J2EEModuleCapability;
import com.ibm.ccl.soa.deploy.j2ee.J2EEResourceEnvironmentRequirement;
import com.ibm.ccl.soa.deploy.j2ee.J2EEResourceRequirement;
import com.ibm.ccl.soa.deploy.j2ee.J2EESecurityRole;
import com.ibm.ccl.soa.deploy.j2ee.J2EEServer;
import com.ibm.ccl.soa.deploy.j2ee.J2EEServerUnit;
import com.ibm.ccl.soa.deploy.j2ee.J2eeFactory;
import com.ibm.ccl.soa.deploy.j2ee.J2eePackage;
import com.ibm.ccl.soa.deploy.j2ee.JCAContainer;
import com.ibm.ccl.soa.deploy.j2ee.JCAContainerVersion;
import com.ibm.ccl.soa.deploy.j2ee.JCAModule;
import com.ibm.ccl.soa.deploy.j2ee.JCAModuleCapability;
import com.ibm.ccl.soa.deploy.j2ee.JSPContainer;
import com.ibm.ccl.soa.deploy.j2ee.JSPContainerVersion;
import com.ibm.ccl.soa.deploy.j2ee.JarModule;
import com.ibm.ccl.soa.deploy.j2ee.JarModuleCapability;
import com.ibm.ccl.soa.deploy.j2ee.JavaInterface;
import com.ibm.ccl.soa.deploy.j2ee.ServletContainer;
import com.ibm.ccl.soa.deploy.j2ee.ServletContainerVersion;
import com.ibm.ccl.soa.deploy.j2ee.SessionService;
import com.ibm.ccl.soa.deploy.j2ee.URLInterface;
import com.ibm.ccl.soa.deploy.j2ee.URLService;
import com.ibm.ccl.soa.deploy.j2ee.Vicinity;
import com.ibm.ccl.soa.deploy.j2ee.WSDLInterface;
import com.ibm.ccl.soa.deploy.j2ee.WebModule;
import com.ibm.ccl.soa.deploy.j2ee.WebModuleCapability;
import com.ibm.ccl.soa.deploy.j2ee.WebService;

/**
 * <!-- begin-user-doc --> An implementation of the model <b>Factory</b>. <!-- end-user-doc -->
 * @generated
 */
public class J2eeFactoryImpl extends EFactoryImpl implements J2eeFactory {
	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public static final String copyright = "Copyright (c) 2005, 2006 IBM Corporation. Licensed Material - Property of IBM. All rights reserved."; //$NON-NLS-1$

	/**
	 * Creates the default factory implementation.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public static J2eeFactory init() {
		try {
			J2eeFactory theJ2eeFactory = (J2eeFactory) EPackage.Registry.INSTANCE
					.getEFactory("http://www.ibm.com/ccl/soa/deploy/j2ee/1.0.0/"); //$NON-NLS-1$ 
			if (theJ2eeFactory != null) {
				return theJ2eeFactory;
			}
		} catch (Exception exception) {
			EcorePlugin.INSTANCE.log(exception);
		}
		return new J2eeFactoryImpl();
	}

	/**
	 * Creates an instance of the factory.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public J2eeFactoryImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EObject create(EClass eClass) {
		switch (eClass.getClassifierID())
		{
		case J2eePackage.APP_CLIENT:
			return createAppClient();
		case J2eePackage.APP_CLIENT_MODULE:
			return createAppClientModule();
		case J2eePackage.EAR_MODULE:
			return createEarModule();
		case J2eePackage.EAR_MODULE_CAPABILITY:
			return createEARModuleCapability();
		case J2eePackage.EJB:
			return createEJB();
		case J2eePackage.EJB_CONTAINER:
			return createEJBContainer();
		case J2eePackage.EJB_MODULE:
			return createEjbModule();
		case J2eePackage.EJB_MODULE_CAPABILITY:
			return createEJBModuleCapability();
		case J2eePackage.ENTERPRISE_BEAN_SERVICE:
			return createEnterpriseBeanService();
		case J2eePackage.ENTITY_SERVICE:
			return createEntityService();
		case J2eePackage.GENERIC_J2EE_SERVER:
			return createGenericJ2eeServer();
		case J2eePackage.GENERIC_WEB_SERVER:
			return createGenericWebServer();
		case J2eePackage.J2C_AUTHENTICATION_DATA_ENTRY:
			return createJ2CAuthenticationDataEntry();
		case J2eePackage.J2EE_CONTAINER:
			return createJ2EEContainer();
		case J2eePackage.J2EE_DATASOURCE:
			return createJ2EEDatasource();
		case J2eePackage.J2EE_DEPLOY_ROOT:
			return (EObject) createJ2EEDeployRoot();
		case J2eePackage.J2EE_MODULE_CAPABILITY:
			return createJ2EEModuleCapability();
		case J2eePackage.J2EE_RESOURCE_ENVIRONMENT_REQUIREMENT:
			return createJ2EEResourceEnvironmentRequirement();
		case J2eePackage.J2EE_RESOURCE_REQUIREMENT:
			return createJ2EEResourceRequirement();
		case J2eePackage.J2EE_SECURITY_ROLE:
			return createJ2EESecurityRole();
		case J2eePackage.J2EE_SERVER:
			return createJ2EEServer();
		case J2eePackage.J2EE_SERVER_UNIT:
			return createJ2EEServerUnit();
		case J2eePackage.JAR_MODULE:
			return createJarModule();
		case J2eePackage.JAR_MODULE_CAPABILITY:
			return createJarModuleCapability();
		case J2eePackage.JAVA_INTERFACE:
			return createJavaInterface();
		case J2eePackage.JCA_CONTAINER:
			return createJCAContainer();
		case J2eePackage.JCA_MODULE:
			return createJCAModule();
		case J2eePackage.JCA_MODULE_CAPABILITY:
			return createJCAModuleCapability();
		case J2eePackage.JSP_CONTAINER:
			return createJSPContainer();
		case J2eePackage.SERVLET_CONTAINER:
			return createServletContainer();
		case J2eePackage.SESSION_SERVICE:
			return createSessionService();
		case J2eePackage.URL_INTERFACE:
			return createURLInterface();
		case J2eePackage.URL_SERVICE:
			return createURLService();
		case J2eePackage.WEB_MODULE:
			return createWebModule();
		case J2eePackage.WEB_MODULE_CAPABILITY:
			return createWebModuleCapability();
		case J2eePackage.WEB_SERVICE:
			return createWebService();
		case J2eePackage.WSDL_INTERFACE:
			return createWSDLInterface();
		default:
			throw new IllegalArgumentException(
					"The class '" + eClass.getName() + "' is not a valid classifier"); //$NON-NLS-1$ //$NON-NLS-2$
		}
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public Object createFromString(EDataType eDataType, String initialValue) {
		switch (eDataType.getClassifierID())
		{
		case J2eePackage.EJB_CONTAINER_VERSION:
			return createEJBContainerVersionFromString(eDataType, initialValue);
		case J2eePackage.J2EE_CONTAINER_VERSION:
			return createJ2EEContainerVersionFromString(eDataType, initialValue);
		case J2eePackage.JCA_CONTAINER_VERSION:
			return createJCAContainerVersionFromString(eDataType, initialValue);
		case J2eePackage.JSP_CONTAINER_VERSION:
			return createJSPContainerVersionFromString(eDataType, initialValue);
		case J2eePackage.SERVLET_CONTAINER_VERSION:
			return createServletContainerVersionFromString(eDataType, initialValue);
		case J2eePackage.VICINITY:
			return createVicinityFromString(eDataType, initialValue);
		case J2eePackage.EJB_CONTAINER_VERSION_OBJECT:
			return createEJBContainerVersionObjectFromString(eDataType, initialValue);
		case J2eePackage.J2EE_CONTAINER_VERSION_OBJECT:
			return createJ2EEContainerVersionObjectFromString(eDataType, initialValue);
		case J2eePackage.JCA_CONTAINER_VERSION_OBJECT:
			return createJCAContainerVersionObjectFromString(eDataType, initialValue);
		case J2eePackage.JSP_CONTAINER_VERSION_OBJECT:
			return createJSPContainerVersionObjectFromString(eDataType, initialValue);
		case J2eePackage.SERVLET_CONTAINER_VERSION_OBJECT:
			return createServletContainerVersionObjectFromString(eDataType, initialValue);
		case J2eePackage.VICINITY_OBJECT:
			return createVicinityObjectFromString(eDataType, initialValue);
		default:
			throw new IllegalArgumentException(
					"The datatype '" + eDataType.getName() + "' is not a valid classifier"); //$NON-NLS-1$ //$NON-NLS-2$
		}
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public String convertToString(EDataType eDataType, Object instanceValue) {
		switch (eDataType.getClassifierID())
		{
		case J2eePackage.EJB_CONTAINER_VERSION:
			return convertEJBContainerVersionToString(eDataType, instanceValue);
		case J2eePackage.J2EE_CONTAINER_VERSION:
			return convertJ2EEContainerVersionToString(eDataType, instanceValue);
		case J2eePackage.JCA_CONTAINER_VERSION:
			return convertJCAContainerVersionToString(eDataType, instanceValue);
		case J2eePackage.JSP_CONTAINER_VERSION:
			return convertJSPContainerVersionToString(eDataType, instanceValue);
		case J2eePackage.SERVLET_CONTAINER_VERSION:
			return convertServletContainerVersionToString(eDataType, instanceValue);
		case J2eePackage.VICINITY:
			return convertVicinityToString(eDataType, instanceValue);
		case J2eePackage.EJB_CONTAINER_VERSION_OBJECT:
			return convertEJBContainerVersionObjectToString(eDataType, instanceValue);
		case J2eePackage.J2EE_CONTAINER_VERSION_OBJECT:
			return convertJ2EEContainerVersionObjectToString(eDataType, instanceValue);
		case J2eePackage.JCA_CONTAINER_VERSION_OBJECT:
			return convertJCAContainerVersionObjectToString(eDataType, instanceValue);
		case J2eePackage.JSP_CONTAINER_VERSION_OBJECT:
			return convertJSPContainerVersionObjectToString(eDataType, instanceValue);
		case J2eePackage.SERVLET_CONTAINER_VERSION_OBJECT:
			return convertServletContainerVersionObjectToString(eDataType, instanceValue);
		case J2eePackage.VICINITY_OBJECT:
			return convertVicinityObjectToString(eDataType, instanceValue);
		default:
			throw new IllegalArgumentException(
					"The datatype '" + eDataType.getName() + "' is not a valid classifier"); //$NON-NLS-1$ //$NON-NLS-2$
		}
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public AppClient createAppClient() {
		AppClientImpl appClient = new AppClientImpl();
		return appClient;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public AppClientModule createAppClientModule() {
		AppClientModuleImpl appClientModule = new AppClientModuleImpl();
		return appClientModule;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EarModule createEarModule() {
		EarModuleImpl earModule = new EarModuleImpl();
		return earModule;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EARModuleCapability createEARModuleCapability() {
		EARModuleCapabilityImpl earModuleCapability = new EARModuleCapabilityImpl();
		return earModuleCapability;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EJB createEJB() {
		EJBImpl ejb = new EJBImpl();
		return ejb;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EJBContainer createEJBContainer() {
		EJBContainerImpl ejbContainer = new EJBContainerImpl();
		return ejbContainer;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EjbModule createEjbModule() {
		EjbModuleImpl ejbModule = new EjbModuleImpl();
		return ejbModule;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EJBModuleCapability createEJBModuleCapability() {
		EJBModuleCapabilityImpl ejbModuleCapability = new EJBModuleCapabilityImpl();
		return ejbModuleCapability;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EnterpriseBeanService createEnterpriseBeanService() {
		EnterpriseBeanServiceImpl enterpriseBeanService = new EnterpriseBeanServiceImpl();
		return enterpriseBeanService;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EntityService createEntityService() {
		EntityServiceImpl entityService = new EntityServiceImpl();
		return entityService;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public GenericJ2eeServer createGenericJ2eeServer() {
		GenericJ2eeServerImpl genericJ2eeServer = new GenericJ2eeServerImpl();
		return genericJ2eeServer;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public GenericWebServer createGenericWebServer() {
		GenericWebServerImpl genericWebServer = new GenericWebServerImpl();
		return genericWebServer;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public J2CAuthenticationDataEntry createJ2CAuthenticationDataEntry() {
		J2CAuthenticationDataEntryImpl j2CAuthenticationDataEntry = new J2CAuthenticationDataEntryImpl();
		return j2CAuthenticationDataEntry;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public J2EEContainer createJ2EEContainer() {
		J2EEContainerImpl j2EEContainer = new J2EEContainerImpl();
		return j2EEContainer;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public J2EEDatasource createJ2EEDatasource() {
		J2EEDatasourceImpl j2EEDatasource = new J2EEDatasourceImpl();
		return j2EEDatasource;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public J2EEDeployRoot createJ2EEDeployRoot() {
		J2EEDeployRootImpl j2EEDeployRoot = new J2EEDeployRootImpl();
		return j2EEDeployRoot;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public J2EEModuleCapability createJ2EEModuleCapability() {
		J2EEModuleCapabilityImpl j2EEModuleCapability = new J2EEModuleCapabilityImpl();
		return j2EEModuleCapability;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public J2EEResourceEnvironmentRequirement createJ2EEResourceEnvironmentRequirement() {
		J2EEResourceEnvironmentRequirementImpl j2EEResourceEnvironmentRequirement = new J2EEResourceEnvironmentRequirementImpl();
		return j2EEResourceEnvironmentRequirement;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public J2EEResourceRequirement createJ2EEResourceRequirement() {
		J2EEResourceRequirementImpl j2EEResourceRequirement = new J2EEResourceRequirementImpl();
		return j2EEResourceRequirement;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public J2EESecurityRole createJ2EESecurityRole() {
		J2EESecurityRoleImpl j2EESecurityRole = new J2EESecurityRoleImpl();
		return j2EESecurityRole;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public J2EEServer createJ2EEServer() {
		J2EEServerImpl j2EEServer = new J2EEServerImpl();
		return j2EEServer;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public J2EEServerUnit createJ2EEServerUnit() {
		J2EEServerUnitImpl j2EEServerUnit = new J2EEServerUnitImpl();
		return j2EEServerUnit;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public JarModule createJarModule() {
		JarModuleImpl jarModule = new JarModuleImpl();
		return jarModule;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public JarModuleCapability createJarModuleCapability() {
		JarModuleCapabilityImpl jarModuleCapability = new JarModuleCapabilityImpl();
		return jarModuleCapability;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public JavaInterface createJavaInterface() {
		JavaInterfaceImpl javaInterface = new JavaInterfaceImpl();
		return javaInterface;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public JCAContainer createJCAContainer() {
		JCAContainerImpl jcaContainer = new JCAContainerImpl();
		return jcaContainer;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public JCAModule createJCAModule() {
		JCAModuleImpl jcaModule = new JCAModuleImpl();
		return jcaModule;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public JCAModuleCapability createJCAModuleCapability() {
		JCAModuleCapabilityImpl jcaModuleCapability = new JCAModuleCapabilityImpl();
		return jcaModuleCapability;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public JSPContainer createJSPContainer() {
		JSPContainerImpl jspContainer = new JSPContainerImpl();
		return jspContainer;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public ServletContainer createServletContainer() {
		ServletContainerImpl servletContainer = new ServletContainerImpl();
		return servletContainer;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public SessionService createSessionService() {
		SessionServiceImpl sessionService = new SessionServiceImpl();
		return sessionService;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public URLInterface createURLInterface() {
		URLInterfaceImpl urlInterface = new URLInterfaceImpl();
		return urlInterface;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public URLService createURLService() {
		URLServiceImpl urlService = new URLServiceImpl();
		return urlService;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public WebModule createWebModule() {
		WebModuleImpl webModule = new WebModuleImpl();
		return webModule;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public WebModuleCapability createWebModuleCapability() {
		WebModuleCapabilityImpl webModuleCapability = new WebModuleCapabilityImpl();
		return webModuleCapability;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public WebService createWebService() {
		WebServiceImpl webService = new WebServiceImpl();
		return webService;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public WSDLInterface createWSDLInterface() {
		WSDLInterfaceImpl wsdlInterface = new WSDLInterfaceImpl();
		return wsdlInterface;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EJBContainerVersion createEJBContainerVersionFromString(EDataType eDataType,
			String initialValue) {
		EJBContainerVersion result = EJBContainerVersion.get(initialValue);
		if (result == null)
			throw new IllegalArgumentException(
					"The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'"); //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
		return result;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public String convertEJBContainerVersionToString(EDataType eDataType, Object instanceValue) {
		return instanceValue == null ? null : instanceValue.toString();
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public J2EEContainerVersion createJ2EEContainerVersionFromString(EDataType eDataType,
			String initialValue) {
		J2EEContainerVersion result = J2EEContainerVersion.get(initialValue);
		if (result == null)
			throw new IllegalArgumentException(
					"The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'"); //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
		return result;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public String convertJ2EEContainerVersionToString(EDataType eDataType, Object instanceValue) {
		return instanceValue == null ? null : instanceValue.toString();
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public JCAContainerVersion createJCAContainerVersionFromString(EDataType eDataType,
			String initialValue) {
		JCAContainerVersion result = JCAContainerVersion.get(initialValue);
		if (result == null)
			throw new IllegalArgumentException(
					"The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'"); //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
		return result;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public String convertJCAContainerVersionToString(EDataType eDataType, Object instanceValue) {
		return instanceValue == null ? null : instanceValue.toString();
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public JSPContainerVersion createJSPContainerVersionFromString(EDataType eDataType,
			String initialValue) {
		JSPContainerVersion result = JSPContainerVersion.get(initialValue);
		if (result == null)
			throw new IllegalArgumentException(
					"The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'"); //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
		return result;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public String convertJSPContainerVersionToString(EDataType eDataType, Object instanceValue) {
		return instanceValue == null ? null : instanceValue.toString();
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public ServletContainerVersion createServletContainerVersionFromString(EDataType eDataType,
			String initialValue) {
		ServletContainerVersion result = ServletContainerVersion.get(initialValue);
		if (result == null)
			throw new IllegalArgumentException(
					"The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'"); //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
		return result;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public String convertServletContainerVersionToString(EDataType eDataType, Object instanceValue) {
		return instanceValue == null ? null : instanceValue.toString();
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public Vicinity createVicinityFromString(EDataType eDataType, String initialValue) {
		Vicinity result = Vicinity.get(initialValue);
		if (result == null)
			throw new IllegalArgumentException(
					"The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'"); //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
		return result;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public String convertVicinityToString(EDataType eDataType, Object instanceValue) {
		return instanceValue == null ? null : instanceValue.toString();
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EJBContainerVersion createEJBContainerVersionObjectFromString(EDataType eDataType,
			String initialValue) {
		return createEJBContainerVersionFromString(J2eePackage.Literals.EJB_CONTAINER_VERSION,
				initialValue);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public String convertEJBContainerVersionObjectToString(EDataType eDataType, Object instanceValue) {
		return convertEJBContainerVersionToString(J2eePackage.Literals.EJB_CONTAINER_VERSION,
				instanceValue);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public J2EEContainerVersion createJ2EEContainerVersionObjectFromString(EDataType eDataType,
			String initialValue) {
		return createJ2EEContainerVersionFromString(J2eePackage.Literals.J2EE_CONTAINER_VERSION,
				initialValue);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public String convertJ2EEContainerVersionObjectToString(EDataType eDataType, Object instanceValue) {
		return convertJ2EEContainerVersionToString(J2eePackage.Literals.J2EE_CONTAINER_VERSION,
				instanceValue);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public JCAContainerVersion createJCAContainerVersionObjectFromString(EDataType eDataType,
			String initialValue) {
		return createJCAContainerVersionFromString(J2eePackage.Literals.JCA_CONTAINER_VERSION,
				initialValue);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public String convertJCAContainerVersionObjectToString(EDataType eDataType, Object instanceValue) {
		return convertJCAContainerVersionToString(J2eePackage.Literals.JCA_CONTAINER_VERSION,
				instanceValue);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public JSPContainerVersion createJSPContainerVersionObjectFromString(EDataType eDataType,
			String initialValue) {
		return createJSPContainerVersionFromString(J2eePackage.Literals.JSP_CONTAINER_VERSION,
				initialValue);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public String convertJSPContainerVersionObjectToString(EDataType eDataType, Object instanceValue) {
		return convertJSPContainerVersionToString(J2eePackage.Literals.JSP_CONTAINER_VERSION,
				instanceValue);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public ServletContainerVersion createServletContainerVersionObjectFromString(
			EDataType eDataType, String initialValue) {
		return createServletContainerVersionFromString(
				J2eePackage.Literals.SERVLET_CONTAINER_VERSION, initialValue);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public String convertServletContainerVersionObjectToString(EDataType eDataType,
			Object instanceValue) {
		return convertServletContainerVersionToString(J2eePackage.Literals.SERVLET_CONTAINER_VERSION,
				instanceValue);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public Vicinity createVicinityObjectFromString(EDataType eDataType, String initialValue) {
		return createVicinityFromString(J2eePackage.Literals.VICINITY, initialValue);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public String convertVicinityObjectToString(EDataType eDataType, Object instanceValue) {
		return convertVicinityToString(J2eePackage.Literals.VICINITY, instanceValue);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public J2eePackage getJ2eePackage() {
		return (J2eePackage) getEPackage();
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @deprecated
	 * @generated
	 */
	public static J2eePackage getPackage() {
		return J2eePackage.eINSTANCE;
	}

} //J2eeFactoryImpl
