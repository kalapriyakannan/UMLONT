/*******************************************************************************
 * Copyright (c) 2003, 2007 IBM Corporation Licensed Material - Property of IBM. All rights reserved.
 *  
 * US Government Users Restricted Rights - Use, duplication or disclosure v1.0 restricted by GSA ADP
 * Schedule Contract with IBM Corp.
 * 
 * Contributors: IBM Corporation - initial API and implementation
 *******************************************************************************/
package com.ibm.ccl.soa.deploy.j2ee.impl;

import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.common.util.EMap;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.EcorePackage;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.EObjectImpl;
import org.eclipse.emf.ecore.impl.EStringToStringMapEntryImpl;
import org.eclipse.emf.ecore.util.BasicFeatureMap;
import org.eclipse.emf.ecore.util.EcoreEMap;
import org.eclipse.emf.ecore.util.FeatureMap;
import org.eclipse.emf.ecore.util.InternalEList;

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
 * <!-- begin-user-doc --> An implementation of the model object '<em><b>J2EE Deploy Root</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link com.ibm.ccl.soa.deploy.j2ee.impl.J2EEDeployRootImpl#getMixed <em>Mixed</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.j2ee.impl.J2EEDeployRootImpl#getXMLNSPrefixMap <em>XMLNS Prefix Map</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.j2ee.impl.J2EEDeployRootImpl#getXSISchemaLocation <em>XSI Schema Location</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.j2ee.impl.J2EEDeployRootImpl#getCapabilityAppClientModule <em>Capability App Client Module</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.j2ee.impl.J2EEDeployRootImpl#getCapabilityEarModule <em>Capability Ear Module</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.j2ee.impl.J2EEDeployRootImpl#getCapabilityEjb <em>Capability Ejb</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.j2ee.impl.J2EEDeployRootImpl#getCapabilityEjbContainer <em>Capability Ejb Container</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.j2ee.impl.J2EEDeployRootImpl#getCapabilityEjbModule <em>Capability Ejb Module</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.j2ee.impl.J2EEDeployRootImpl#getCapabilityJ2eeContainer <em>Capability J2ee Container</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.j2ee.impl.J2EEDeployRootImpl#getCapabilityJ2eeDatasource <em>Capability J2ee Datasource</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.j2ee.impl.J2EEDeployRootImpl#getCapabilityJ2eeModule <em>Capability J2ee Module</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.j2ee.impl.J2EEDeployRootImpl#getCapabilityJ2eeResourceEnvironmentRequirement <em>Capability J2ee Resource Environment Requirement</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.j2ee.impl.J2EEDeployRootImpl#getCapabilityJ2eeResourceRequirement <em>Capability J2ee Resource Requirement</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.j2ee.impl.J2EEDeployRootImpl#getCapabilityJ2eeSecurityRole <em>Capability J2ee Security Role</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.j2ee.impl.J2EEDeployRootImpl#getCapabilityJ2eeServer <em>Capability J2ee Server</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.j2ee.impl.J2EEDeployRootImpl#getCapabilityJarModule <em>Capability Jar Module</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.j2ee.impl.J2EEDeployRootImpl#getCapabilityJcaContainer <em>Capability Jca Container</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.j2ee.impl.J2EEDeployRootImpl#getCapabilityJcaModule <em>Capability Jca Module</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.j2ee.impl.J2EEDeployRootImpl#getCapabilityJspContainer <em>Capability Jsp Container</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.j2ee.impl.J2EEDeployRootImpl#getCapabilityServletContainer <em>Capability Servlet Container</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.j2ee.impl.J2EEDeployRootImpl#getCapabilityWebModule <em>Capability Web Module</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.j2ee.impl.J2EEDeployRootImpl#getComponentEar <em>Component Ear</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.j2ee.impl.J2EEDeployRootImpl#getComponentEjb <em>Component Ejb</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.j2ee.impl.J2EEDeployRootImpl#getComponentJar <em>Component Jar</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.j2ee.impl.J2EEDeployRootImpl#getComponentWeb <em>Component Web</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.j2ee.impl.J2EEDeployRootImpl#getInterfaceJava <em>Interface Java</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.j2ee.impl.J2EEDeployRootImpl#getInterfaceUrl <em>Interface Url</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.j2ee.impl.J2EEDeployRootImpl#getInterfaceWsdl <em>Interface Wsdl</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.j2ee.impl.J2EEDeployRootImpl#getServiceEntity <em>Service Entity</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.j2ee.impl.J2EEDeployRootImpl#getServiceServlet <em>Service Servlet</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.j2ee.impl.J2EEDeployRootImpl#getServiceSession <em>Service Session</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.j2ee.impl.J2EEDeployRootImpl#getServiceWs <em>Service Ws</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.j2ee.impl.J2EEDeployRootImpl#getUnitAppClient <em>Unit App Client</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.j2ee.impl.J2EEDeployRootImpl#getUnitJ2eeServer <em>Unit J2ee Server</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.j2ee.impl.J2EEDeployRootImpl#getUnitJ2eeServerUnit <em>Unit J2ee Server Unit</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.j2ee.impl.J2EEDeployRootImpl#getUnitJcaModule <em>Unit Jca Module</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.j2ee.impl.J2EEDeployRootImpl#getUnitWebServer <em>Unit Web Server</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class J2EEDeployRootImpl extends EObjectImpl implements J2EEDeployRoot {
	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public static final String copyright = "Copyright (c) 2005, 2006 IBM Corporation. Licensed Material - Property of IBM. All rights reserved."; //$NON-NLS-1$

	/**
	 * The cached value of the '{@link #getMixed() <em>Mixed</em>}' attribute list. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see #getMixed()
	 * @generated
	 * @ordered
	 */
	protected FeatureMap mixed;

	/**
	 * The cached value of the '{@link #getXMLNSPrefixMap() <em>XMLNS Prefix Map</em>}' map. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see #getXMLNSPrefixMap()
	 * @generated
	 * @ordered
	 */
	protected EMap xMLNSPrefixMap;

	/**
	 * The cached value of the '{@link #getXSISchemaLocation() <em>XSI Schema Location</em>}' map.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see #getXSISchemaLocation()
	 * @generated
	 * @ordered
	 */
	protected EMap xSISchemaLocation;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	protected J2EEDeployRootImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	protected EClass eStaticClass() {
		return J2eePackage.Literals.J2EE_DEPLOY_ROOT;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public FeatureMap getMixed() {
		if (mixed == null) {
			mixed = new BasicFeatureMap(this, J2eePackage.J2EE_DEPLOY_ROOT__MIXED);
		}
		return mixed;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EMap getXMLNSPrefixMap() {
		if (xMLNSPrefixMap == null) {
			xMLNSPrefixMap = new EcoreEMap(EcorePackage.Literals.ESTRING_TO_STRING_MAP_ENTRY,
					EStringToStringMapEntryImpl.class, this,
					J2eePackage.J2EE_DEPLOY_ROOT__XMLNS_PREFIX_MAP);
		}
		return xMLNSPrefixMap;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EMap getXSISchemaLocation() {
		if (xSISchemaLocation == null) {
			xSISchemaLocation = new EcoreEMap(EcorePackage.Literals.ESTRING_TO_STRING_MAP_ENTRY,
					EStringToStringMapEntryImpl.class, this,
					J2eePackage.J2EE_DEPLOY_ROOT__XSI_SCHEMA_LOCATION);
		}
		return xSISchemaLocation;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public AppClientModule getCapabilityAppClientModule() {
		return (AppClientModule) getMixed().get(
				J2eePackage.Literals.J2EE_DEPLOY_ROOT__CAPABILITY_APP_CLIENT_MODULE, true);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetCapabilityAppClientModule(
			AppClientModule newCapabilityAppClientModule, NotificationChain msgs) {
		return ((FeatureMap.Internal) getMixed()).basicAdd(
				J2eePackage.Literals.J2EE_DEPLOY_ROOT__CAPABILITY_APP_CLIENT_MODULE,
				newCapabilityAppClientModule, msgs);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public void setCapabilityAppClientModule(AppClientModule newCapabilityAppClientModule) {
		((FeatureMap.Internal) getMixed()).set(
				J2eePackage.Literals.J2EE_DEPLOY_ROOT__CAPABILITY_APP_CLIENT_MODULE,
				newCapabilityAppClientModule);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EARModuleCapability getCapabilityEarModule() {
		return (EARModuleCapability) getMixed().get(
				J2eePackage.Literals.J2EE_DEPLOY_ROOT__CAPABILITY_EAR_MODULE, true);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetCapabilityEarModule(EARModuleCapability newCapabilityEarModule,
			NotificationChain msgs) {
		return ((FeatureMap.Internal) getMixed()).basicAdd(
				J2eePackage.Literals.J2EE_DEPLOY_ROOT__CAPABILITY_EAR_MODULE, newCapabilityEarModule,
				msgs);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public void setCapabilityEarModule(EARModuleCapability newCapabilityEarModule) {
		((FeatureMap.Internal) getMixed()).set(
				J2eePackage.Literals.J2EE_DEPLOY_ROOT__CAPABILITY_EAR_MODULE, newCapabilityEarModule);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EJB getCapabilityEjb() {
		return (EJB) getMixed().get(J2eePackage.Literals.J2EE_DEPLOY_ROOT__CAPABILITY_EJB, true);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetCapabilityEjb(EJB newCapabilityEjb, NotificationChain msgs) {
		return ((FeatureMap.Internal) getMixed()).basicAdd(
				J2eePackage.Literals.J2EE_DEPLOY_ROOT__CAPABILITY_EJB, newCapabilityEjb, msgs);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public void setCapabilityEjb(EJB newCapabilityEjb) {
		((FeatureMap.Internal) getMixed()).set(J2eePackage.Literals.J2EE_DEPLOY_ROOT__CAPABILITY_EJB,
				newCapabilityEjb);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EJBContainer getCapabilityEjbContainer() {
		return (EJBContainer) getMixed().get(
				J2eePackage.Literals.J2EE_DEPLOY_ROOT__CAPABILITY_EJB_CONTAINER, true);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetCapabilityEjbContainer(EJBContainer newCapabilityEjbContainer,
			NotificationChain msgs) {
		return ((FeatureMap.Internal) getMixed()).basicAdd(
				J2eePackage.Literals.J2EE_DEPLOY_ROOT__CAPABILITY_EJB_CONTAINER,
				newCapabilityEjbContainer, msgs);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public void setCapabilityEjbContainer(EJBContainer newCapabilityEjbContainer) {
		((FeatureMap.Internal) getMixed()).set(
				J2eePackage.Literals.J2EE_DEPLOY_ROOT__CAPABILITY_EJB_CONTAINER,
				newCapabilityEjbContainer);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EJBModuleCapability getCapabilityEjbModule() {
		return (EJBModuleCapability) getMixed().get(
				J2eePackage.Literals.J2EE_DEPLOY_ROOT__CAPABILITY_EJB_MODULE, true);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetCapabilityEjbModule(EJBModuleCapability newCapabilityEjbModule,
			NotificationChain msgs) {
		return ((FeatureMap.Internal) getMixed()).basicAdd(
				J2eePackage.Literals.J2EE_DEPLOY_ROOT__CAPABILITY_EJB_MODULE, newCapabilityEjbModule,
				msgs);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public void setCapabilityEjbModule(EJBModuleCapability newCapabilityEjbModule) {
		((FeatureMap.Internal) getMixed()).set(
				J2eePackage.Literals.J2EE_DEPLOY_ROOT__CAPABILITY_EJB_MODULE, newCapabilityEjbModule);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public J2EEContainer getCapabilityJ2eeContainer() {
		return (J2EEContainer) getMixed().get(
				J2eePackage.Literals.J2EE_DEPLOY_ROOT__CAPABILITY_J2EE_CONTAINER, true);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetCapabilityJ2eeContainer(
			J2EEContainer newCapabilityJ2eeContainer, NotificationChain msgs) {
		return ((FeatureMap.Internal) getMixed()).basicAdd(
				J2eePackage.Literals.J2EE_DEPLOY_ROOT__CAPABILITY_J2EE_CONTAINER,
				newCapabilityJ2eeContainer, msgs);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public void setCapabilityJ2eeContainer(J2EEContainer newCapabilityJ2eeContainer) {
		((FeatureMap.Internal) getMixed()).set(
				J2eePackage.Literals.J2EE_DEPLOY_ROOT__CAPABILITY_J2EE_CONTAINER,
				newCapabilityJ2eeContainer);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public J2EEDatasource getCapabilityJ2eeDatasource() {
		return (J2EEDatasource) getMixed().get(
				J2eePackage.Literals.J2EE_DEPLOY_ROOT__CAPABILITY_J2EE_DATASOURCE, true);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetCapabilityJ2eeDatasource(
			J2EEDatasource newCapabilityJ2eeDatasource, NotificationChain msgs) {
		return ((FeatureMap.Internal) getMixed()).basicAdd(
				J2eePackage.Literals.J2EE_DEPLOY_ROOT__CAPABILITY_J2EE_DATASOURCE,
				newCapabilityJ2eeDatasource, msgs);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public void setCapabilityJ2eeDatasource(J2EEDatasource newCapabilityJ2eeDatasource) {
		((FeatureMap.Internal) getMixed()).set(
				J2eePackage.Literals.J2EE_DEPLOY_ROOT__CAPABILITY_J2EE_DATASOURCE,
				newCapabilityJ2eeDatasource);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public J2EEModuleCapability getCapabilityJ2eeModule() {
		return (J2EEModuleCapability) getMixed().get(
				J2eePackage.Literals.J2EE_DEPLOY_ROOT__CAPABILITY_J2EE_MODULE, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetCapabilityJ2eeModule(
			J2EEModuleCapability newCapabilityJ2eeModule, NotificationChain msgs) {
		return ((FeatureMap.Internal) getMixed()).basicAdd(
				J2eePackage.Literals.J2EE_DEPLOY_ROOT__CAPABILITY_J2EE_MODULE, newCapabilityJ2eeModule,
				msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setCapabilityJ2eeModule(J2EEModuleCapability newCapabilityJ2eeModule) {
		((FeatureMap.Internal) getMixed()).set(
				J2eePackage.Literals.J2EE_DEPLOY_ROOT__CAPABILITY_J2EE_MODULE, newCapabilityJ2eeModule);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public J2EEResourceEnvironmentRequirement getCapabilityJ2eeResourceEnvironmentRequirement() {
		return (J2EEResourceEnvironmentRequirement) getMixed()
				.get(
						J2eePackage.Literals.J2EE_DEPLOY_ROOT__CAPABILITY_J2EE_RESOURCE_ENVIRONMENT_REQUIREMENT,
						true);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetCapabilityJ2eeResourceEnvironmentRequirement(
			J2EEResourceEnvironmentRequirement newCapabilityJ2eeResourceEnvironmentRequirement,
			NotificationChain msgs) {
		return ((FeatureMap.Internal) getMixed())
				.basicAdd(
						J2eePackage.Literals.J2EE_DEPLOY_ROOT__CAPABILITY_J2EE_RESOURCE_ENVIRONMENT_REQUIREMENT,
						newCapabilityJ2eeResourceEnvironmentRequirement, msgs);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public void setCapabilityJ2eeResourceEnvironmentRequirement(
			J2EEResourceEnvironmentRequirement newCapabilityJ2eeResourceEnvironmentRequirement) {
		((FeatureMap.Internal) getMixed())
				.set(
						J2eePackage.Literals.J2EE_DEPLOY_ROOT__CAPABILITY_J2EE_RESOURCE_ENVIRONMENT_REQUIREMENT,
						newCapabilityJ2eeResourceEnvironmentRequirement);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public J2EEResourceRequirement getCapabilityJ2eeResourceRequirement() {
		return (J2EEResourceRequirement) getMixed().get(
				J2eePackage.Literals.J2EE_DEPLOY_ROOT__CAPABILITY_J2EE_RESOURCE_REQUIREMENT, true);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetCapabilityJ2eeResourceRequirement(
			J2EEResourceRequirement newCapabilityJ2eeResourceRequirement, NotificationChain msgs) {
		return ((FeatureMap.Internal) getMixed()).basicAdd(
				J2eePackage.Literals.J2EE_DEPLOY_ROOT__CAPABILITY_J2EE_RESOURCE_REQUIREMENT,
				newCapabilityJ2eeResourceRequirement, msgs);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public void setCapabilityJ2eeResourceRequirement(
			J2EEResourceRequirement newCapabilityJ2eeResourceRequirement) {
		((FeatureMap.Internal) getMixed()).set(
				J2eePackage.Literals.J2EE_DEPLOY_ROOT__CAPABILITY_J2EE_RESOURCE_REQUIREMENT,
				newCapabilityJ2eeResourceRequirement);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public J2EESecurityRole getCapabilityJ2eeSecurityRole() {
		return (J2EESecurityRole) getMixed().get(
				J2eePackage.Literals.J2EE_DEPLOY_ROOT__CAPABILITY_J2EE_SECURITY_ROLE, true);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetCapabilityJ2eeSecurityRole(
			J2EESecurityRole newCapabilityJ2eeSecurityRole, NotificationChain msgs) {
		return ((FeatureMap.Internal) getMixed()).basicAdd(
				J2eePackage.Literals.J2EE_DEPLOY_ROOT__CAPABILITY_J2EE_SECURITY_ROLE,
				newCapabilityJ2eeSecurityRole, msgs);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public void setCapabilityJ2eeSecurityRole(J2EESecurityRole newCapabilityJ2eeSecurityRole) {
		((FeatureMap.Internal) getMixed()).set(
				J2eePackage.Literals.J2EE_DEPLOY_ROOT__CAPABILITY_J2EE_SECURITY_ROLE,
				newCapabilityJ2eeSecurityRole);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public J2EEServer getCapabilityJ2eeServer() {
		return (J2EEServer) getMixed().get(
				J2eePackage.Literals.J2EE_DEPLOY_ROOT__CAPABILITY_J2EE_SERVER, true);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetCapabilityJ2eeServer(J2EEServer newCapabilityJ2eeServer,
			NotificationChain msgs) {
		return ((FeatureMap.Internal) getMixed()).basicAdd(
				J2eePackage.Literals.J2EE_DEPLOY_ROOT__CAPABILITY_J2EE_SERVER, newCapabilityJ2eeServer,
				msgs);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public void setCapabilityJ2eeServer(J2EEServer newCapabilityJ2eeServer) {
		((FeatureMap.Internal) getMixed()).set(
				J2eePackage.Literals.J2EE_DEPLOY_ROOT__CAPABILITY_J2EE_SERVER, newCapabilityJ2eeServer);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public JarModuleCapability getCapabilityJarModule() {
		return (JarModuleCapability) getMixed().get(
				J2eePackage.Literals.J2EE_DEPLOY_ROOT__CAPABILITY_JAR_MODULE, true);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetCapabilityJarModule(JarModuleCapability newCapabilityJarModule,
			NotificationChain msgs) {
		return ((FeatureMap.Internal) getMixed()).basicAdd(
				J2eePackage.Literals.J2EE_DEPLOY_ROOT__CAPABILITY_JAR_MODULE, newCapabilityJarModule,
				msgs);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public void setCapabilityJarModule(JarModuleCapability newCapabilityJarModule) {
		((FeatureMap.Internal) getMixed()).set(
				J2eePackage.Literals.J2EE_DEPLOY_ROOT__CAPABILITY_JAR_MODULE, newCapabilityJarModule);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public JCAContainer getCapabilityJcaContainer() {
		return (JCAContainer) getMixed().get(
				J2eePackage.Literals.J2EE_DEPLOY_ROOT__CAPABILITY_JCA_CONTAINER, true);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetCapabilityJcaContainer(JCAContainer newCapabilityJcaContainer,
			NotificationChain msgs) {
		return ((FeatureMap.Internal) getMixed()).basicAdd(
				J2eePackage.Literals.J2EE_DEPLOY_ROOT__CAPABILITY_JCA_CONTAINER,
				newCapabilityJcaContainer, msgs);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public void setCapabilityJcaContainer(JCAContainer newCapabilityJcaContainer) {
		((FeatureMap.Internal) getMixed()).set(
				J2eePackage.Literals.J2EE_DEPLOY_ROOT__CAPABILITY_JCA_CONTAINER,
				newCapabilityJcaContainer);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public JCAModuleCapability getCapabilityJcaModule() {
		return (JCAModuleCapability) getMixed().get(
				J2eePackage.Literals.J2EE_DEPLOY_ROOT__CAPABILITY_JCA_MODULE, true);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetCapabilityJcaModule(JCAModuleCapability newCapabilityJcaModule,
			NotificationChain msgs) {
		return ((FeatureMap.Internal) getMixed()).basicAdd(
				J2eePackage.Literals.J2EE_DEPLOY_ROOT__CAPABILITY_JCA_MODULE, newCapabilityJcaModule,
				msgs);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public void setCapabilityJcaModule(JCAModuleCapability newCapabilityJcaModule) {
		((FeatureMap.Internal) getMixed()).set(
				J2eePackage.Literals.J2EE_DEPLOY_ROOT__CAPABILITY_JCA_MODULE, newCapabilityJcaModule);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public JSPContainer getCapabilityJspContainer() {
		return (JSPContainer) getMixed().get(
				J2eePackage.Literals.J2EE_DEPLOY_ROOT__CAPABILITY_JSP_CONTAINER, true);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetCapabilityJspContainer(JSPContainer newCapabilityJspContainer,
			NotificationChain msgs) {
		return ((FeatureMap.Internal) getMixed()).basicAdd(
				J2eePackage.Literals.J2EE_DEPLOY_ROOT__CAPABILITY_JSP_CONTAINER,
				newCapabilityJspContainer, msgs);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public void setCapabilityJspContainer(JSPContainer newCapabilityJspContainer) {
		((FeatureMap.Internal) getMixed()).set(
				J2eePackage.Literals.J2EE_DEPLOY_ROOT__CAPABILITY_JSP_CONTAINER,
				newCapabilityJspContainer);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public ServletContainer getCapabilityServletContainer() {
		return (ServletContainer) getMixed().get(
				J2eePackage.Literals.J2EE_DEPLOY_ROOT__CAPABILITY_SERVLET_CONTAINER, true);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetCapabilityServletContainer(
			ServletContainer newCapabilityServletContainer, NotificationChain msgs) {
		return ((FeatureMap.Internal) getMixed()).basicAdd(
				J2eePackage.Literals.J2EE_DEPLOY_ROOT__CAPABILITY_SERVLET_CONTAINER,
				newCapabilityServletContainer, msgs);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public void setCapabilityServletContainer(ServletContainer newCapabilityServletContainer) {
		((FeatureMap.Internal) getMixed()).set(
				J2eePackage.Literals.J2EE_DEPLOY_ROOT__CAPABILITY_SERVLET_CONTAINER,
				newCapabilityServletContainer);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public WebModuleCapability getCapabilityWebModule() {
		return (WebModuleCapability) getMixed().get(
				J2eePackage.Literals.J2EE_DEPLOY_ROOT__CAPABILITY_WEB_MODULE, true);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetCapabilityWebModule(WebModuleCapability newCapabilityWebModule,
			NotificationChain msgs) {
		return ((FeatureMap.Internal) getMixed()).basicAdd(
				J2eePackage.Literals.J2EE_DEPLOY_ROOT__CAPABILITY_WEB_MODULE, newCapabilityWebModule,
				msgs);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public void setCapabilityWebModule(WebModuleCapability newCapabilityWebModule) {
		((FeatureMap.Internal) getMixed()).set(
				J2eePackage.Literals.J2EE_DEPLOY_ROOT__CAPABILITY_WEB_MODULE, newCapabilityWebModule);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EarModule getComponentEar() {
		return (EarModule) getMixed().get(J2eePackage.Literals.J2EE_DEPLOY_ROOT__COMPONENT_EAR, true);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetComponentEar(EarModule newComponentEar, NotificationChain msgs) {
		return ((FeatureMap.Internal) getMixed()).basicAdd(
				J2eePackage.Literals.J2EE_DEPLOY_ROOT__COMPONENT_EAR, newComponentEar, msgs);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public void setComponentEar(EarModule newComponentEar) {
		((FeatureMap.Internal) getMixed()).set(J2eePackage.Literals.J2EE_DEPLOY_ROOT__COMPONENT_EAR,
				newComponentEar);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EjbModule getComponentEjb() {
		return (EjbModule) getMixed().get(J2eePackage.Literals.J2EE_DEPLOY_ROOT__COMPONENT_EJB, true);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetComponentEjb(EjbModule newComponentEjb, NotificationChain msgs) {
		return ((FeatureMap.Internal) getMixed()).basicAdd(
				J2eePackage.Literals.J2EE_DEPLOY_ROOT__COMPONENT_EJB, newComponentEjb, msgs);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public void setComponentEjb(EjbModule newComponentEjb) {
		((FeatureMap.Internal) getMixed()).set(J2eePackage.Literals.J2EE_DEPLOY_ROOT__COMPONENT_EJB,
				newComponentEjb);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public JarModule getComponentJar() {
		return (JarModule) getMixed().get(J2eePackage.Literals.J2EE_DEPLOY_ROOT__COMPONENT_JAR, true);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetComponentJar(JarModule newComponentJar, NotificationChain msgs) {
		return ((FeatureMap.Internal) getMixed()).basicAdd(
				J2eePackage.Literals.J2EE_DEPLOY_ROOT__COMPONENT_JAR, newComponentJar, msgs);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public void setComponentJar(JarModule newComponentJar) {
		((FeatureMap.Internal) getMixed()).set(J2eePackage.Literals.J2EE_DEPLOY_ROOT__COMPONENT_JAR,
				newComponentJar);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public WebModule getComponentWeb() {
		return (WebModule) getMixed().get(J2eePackage.Literals.J2EE_DEPLOY_ROOT__COMPONENT_WEB, true);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetComponentWeb(WebModule newComponentWeb, NotificationChain msgs) {
		return ((FeatureMap.Internal) getMixed()).basicAdd(
				J2eePackage.Literals.J2EE_DEPLOY_ROOT__COMPONENT_WEB, newComponentWeb, msgs);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public void setComponentWeb(WebModule newComponentWeb) {
		((FeatureMap.Internal) getMixed()).set(J2eePackage.Literals.J2EE_DEPLOY_ROOT__COMPONENT_WEB,
				newComponentWeb);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public JavaInterface getInterfaceJava() {
		return (JavaInterface) getMixed().get(J2eePackage.Literals.J2EE_DEPLOY_ROOT__INTERFACE_JAVA,
				true);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetInterfaceJava(JavaInterface newInterfaceJava,
			NotificationChain msgs) {
		return ((FeatureMap.Internal) getMixed()).basicAdd(
				J2eePackage.Literals.J2EE_DEPLOY_ROOT__INTERFACE_JAVA, newInterfaceJava, msgs);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public void setInterfaceJava(JavaInterface newInterfaceJava) {
		((FeatureMap.Internal) getMixed()).set(J2eePackage.Literals.J2EE_DEPLOY_ROOT__INTERFACE_JAVA,
				newInterfaceJava);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public URLInterface getInterfaceUrl() {
		return (URLInterface) getMixed().get(J2eePackage.Literals.J2EE_DEPLOY_ROOT__INTERFACE_URL,
				true);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetInterfaceUrl(URLInterface newInterfaceUrl,
			NotificationChain msgs) {
		return ((FeatureMap.Internal) getMixed()).basicAdd(
				J2eePackage.Literals.J2EE_DEPLOY_ROOT__INTERFACE_URL, newInterfaceUrl, msgs);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public void setInterfaceUrl(URLInterface newInterfaceUrl) {
		((FeatureMap.Internal) getMixed()).set(J2eePackage.Literals.J2EE_DEPLOY_ROOT__INTERFACE_URL,
				newInterfaceUrl);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public WSDLInterface getInterfaceWsdl() {
		return (WSDLInterface) getMixed().get(J2eePackage.Literals.J2EE_DEPLOY_ROOT__INTERFACE_WSDL,
				true);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetInterfaceWsdl(WSDLInterface newInterfaceWsdl,
			NotificationChain msgs) {
		return ((FeatureMap.Internal) getMixed()).basicAdd(
				J2eePackage.Literals.J2EE_DEPLOY_ROOT__INTERFACE_WSDL, newInterfaceWsdl, msgs);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public void setInterfaceWsdl(WSDLInterface newInterfaceWsdl) {
		((FeatureMap.Internal) getMixed()).set(J2eePackage.Literals.J2EE_DEPLOY_ROOT__INTERFACE_WSDL,
				newInterfaceWsdl);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EntityService getServiceEntity() {
		return (EntityService) getMixed().get(J2eePackage.Literals.J2EE_DEPLOY_ROOT__SERVICE_ENTITY,
				true);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetServiceEntity(EntityService newServiceEntity,
			NotificationChain msgs) {
		return ((FeatureMap.Internal) getMixed()).basicAdd(
				J2eePackage.Literals.J2EE_DEPLOY_ROOT__SERVICE_ENTITY, newServiceEntity, msgs);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public void setServiceEntity(EntityService newServiceEntity) {
		((FeatureMap.Internal) getMixed()).set(J2eePackage.Literals.J2EE_DEPLOY_ROOT__SERVICE_ENTITY,
				newServiceEntity);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public URLService getServiceServlet() {
		return (URLService) getMixed().get(J2eePackage.Literals.J2EE_DEPLOY_ROOT__SERVICE_SERVLET,
				true);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetServiceServlet(URLService newServiceServlet,
			NotificationChain msgs) {
		return ((FeatureMap.Internal) getMixed()).basicAdd(
				J2eePackage.Literals.J2EE_DEPLOY_ROOT__SERVICE_SERVLET, newServiceServlet, msgs);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public void setServiceServlet(URLService newServiceServlet) {
		((FeatureMap.Internal) getMixed()).set(
				J2eePackage.Literals.J2EE_DEPLOY_ROOT__SERVICE_SERVLET, newServiceServlet);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public SessionService getServiceSession() {
		return (SessionService) getMixed().get(
				J2eePackage.Literals.J2EE_DEPLOY_ROOT__SERVICE_SESSION, true);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetServiceSession(SessionService newServiceSession,
			NotificationChain msgs) {
		return ((FeatureMap.Internal) getMixed()).basicAdd(
				J2eePackage.Literals.J2EE_DEPLOY_ROOT__SERVICE_SESSION, newServiceSession, msgs);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public void setServiceSession(SessionService newServiceSession) {
		((FeatureMap.Internal) getMixed()).set(
				J2eePackage.Literals.J2EE_DEPLOY_ROOT__SERVICE_SESSION, newServiceSession);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public WebService getServiceWs() {
		return (WebService) getMixed().get(J2eePackage.Literals.J2EE_DEPLOY_ROOT__SERVICE_WS, true);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetServiceWs(WebService newServiceWs, NotificationChain msgs) {
		return ((FeatureMap.Internal) getMixed()).basicAdd(
				J2eePackage.Literals.J2EE_DEPLOY_ROOT__SERVICE_WS, newServiceWs, msgs);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public void setServiceWs(WebService newServiceWs) {
		((FeatureMap.Internal) getMixed()).set(J2eePackage.Literals.J2EE_DEPLOY_ROOT__SERVICE_WS,
				newServiceWs);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public AppClient getUnitAppClient() {
		return (AppClient) getMixed().get(J2eePackage.Literals.J2EE_DEPLOY_ROOT__UNIT_APP_CLIENT,
				true);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetUnitAppClient(AppClient newUnitAppClient, NotificationChain msgs) {
		return ((FeatureMap.Internal) getMixed()).basicAdd(
				J2eePackage.Literals.J2EE_DEPLOY_ROOT__UNIT_APP_CLIENT, newUnitAppClient, msgs);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public void setUnitAppClient(AppClient newUnitAppClient) {
		((FeatureMap.Internal) getMixed()).set(
				J2eePackage.Literals.J2EE_DEPLOY_ROOT__UNIT_APP_CLIENT, newUnitAppClient);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public GenericJ2eeServer getUnitJ2eeServer() {
		return (GenericJ2eeServer) getMixed().get(
				J2eePackage.Literals.J2EE_DEPLOY_ROOT__UNIT_J2EE_SERVER, true);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetUnitJ2eeServer(GenericJ2eeServer newUnitJ2eeServer,
			NotificationChain msgs) {
		return ((FeatureMap.Internal) getMixed()).basicAdd(
				J2eePackage.Literals.J2EE_DEPLOY_ROOT__UNIT_J2EE_SERVER, newUnitJ2eeServer, msgs);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public void setUnitJ2eeServer(GenericJ2eeServer newUnitJ2eeServer) {
		((FeatureMap.Internal) getMixed()).set(
				J2eePackage.Literals.J2EE_DEPLOY_ROOT__UNIT_J2EE_SERVER, newUnitJ2eeServer);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public J2EEServerUnit getUnitJ2eeServerUnit() {
		return (J2EEServerUnit) getMixed().get(
				J2eePackage.Literals.J2EE_DEPLOY_ROOT__UNIT_J2EE_SERVER_UNIT, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetUnitJ2eeServerUnit(J2EEServerUnit newUnitJ2eeServerUnit,
			NotificationChain msgs) {
		return ((FeatureMap.Internal) getMixed()).basicAdd(
				J2eePackage.Literals.J2EE_DEPLOY_ROOT__UNIT_J2EE_SERVER_UNIT, newUnitJ2eeServerUnit,
				msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setUnitJ2eeServerUnit(J2EEServerUnit newUnitJ2eeServerUnit) {
		((FeatureMap.Internal) getMixed()).set(
				J2eePackage.Literals.J2EE_DEPLOY_ROOT__UNIT_J2EE_SERVER_UNIT, newUnitJ2eeServerUnit);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public JCAModule getUnitJcaModule() {
		return (JCAModule) getMixed().get(J2eePackage.Literals.J2EE_DEPLOY_ROOT__UNIT_JCA_MODULE,
				true);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetUnitJcaModule(JCAModule newUnitJcaModule, NotificationChain msgs) {
		return ((FeatureMap.Internal) getMixed()).basicAdd(
				J2eePackage.Literals.J2EE_DEPLOY_ROOT__UNIT_JCA_MODULE, newUnitJcaModule, msgs);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public void setUnitJcaModule(JCAModule newUnitJcaModule) {
		((FeatureMap.Internal) getMixed()).set(
				J2eePackage.Literals.J2EE_DEPLOY_ROOT__UNIT_JCA_MODULE, newUnitJcaModule);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public GenericWebServer getUnitWebServer() {
		return (GenericWebServer) getMixed().get(
				J2eePackage.Literals.J2EE_DEPLOY_ROOT__UNIT_WEB_SERVER, true);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetUnitWebServer(GenericWebServer newUnitWebServer,
			NotificationChain msgs) {
		return ((FeatureMap.Internal) getMixed()).basicAdd(
				J2eePackage.Literals.J2EE_DEPLOY_ROOT__UNIT_WEB_SERVER, newUnitWebServer, msgs);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public void setUnitWebServer(GenericWebServer newUnitWebServer) {
		((FeatureMap.Internal) getMixed()).set(
				J2eePackage.Literals.J2EE_DEPLOY_ROOT__UNIT_WEB_SERVER, newUnitWebServer);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID,
			NotificationChain msgs) {
		switch (featureID)
		{
		case J2eePackage.J2EE_DEPLOY_ROOT__MIXED:
			return ((InternalEList) getMixed()).basicRemove(otherEnd, msgs);
		case J2eePackage.J2EE_DEPLOY_ROOT__XMLNS_PREFIX_MAP:
			return ((InternalEList) getXMLNSPrefixMap()).basicRemove(otherEnd, msgs);
		case J2eePackage.J2EE_DEPLOY_ROOT__XSI_SCHEMA_LOCATION:
			return ((InternalEList) getXSISchemaLocation()).basicRemove(otherEnd, msgs);
		case J2eePackage.J2EE_DEPLOY_ROOT__CAPABILITY_APP_CLIENT_MODULE:
			return basicSetCapabilityAppClientModule(null, msgs);
		case J2eePackage.J2EE_DEPLOY_ROOT__CAPABILITY_EAR_MODULE:
			return basicSetCapabilityEarModule(null, msgs);
		case J2eePackage.J2EE_DEPLOY_ROOT__CAPABILITY_EJB:
			return basicSetCapabilityEjb(null, msgs);
		case J2eePackage.J2EE_DEPLOY_ROOT__CAPABILITY_EJB_CONTAINER:
			return basicSetCapabilityEjbContainer(null, msgs);
		case J2eePackage.J2EE_DEPLOY_ROOT__CAPABILITY_EJB_MODULE:
			return basicSetCapabilityEjbModule(null, msgs);
		case J2eePackage.J2EE_DEPLOY_ROOT__CAPABILITY_J2EE_CONTAINER:
			return basicSetCapabilityJ2eeContainer(null, msgs);
		case J2eePackage.J2EE_DEPLOY_ROOT__CAPABILITY_J2EE_DATASOURCE:
			return basicSetCapabilityJ2eeDatasource(null, msgs);
		case J2eePackage.J2EE_DEPLOY_ROOT__CAPABILITY_J2EE_MODULE:
			return basicSetCapabilityJ2eeModule(null, msgs);
		case J2eePackage.J2EE_DEPLOY_ROOT__CAPABILITY_J2EE_RESOURCE_ENVIRONMENT_REQUIREMENT:
			return basicSetCapabilityJ2eeResourceEnvironmentRequirement(null, msgs);
		case J2eePackage.J2EE_DEPLOY_ROOT__CAPABILITY_J2EE_RESOURCE_REQUIREMENT:
			return basicSetCapabilityJ2eeResourceRequirement(null, msgs);
		case J2eePackage.J2EE_DEPLOY_ROOT__CAPABILITY_J2EE_SECURITY_ROLE:
			return basicSetCapabilityJ2eeSecurityRole(null, msgs);
		case J2eePackage.J2EE_DEPLOY_ROOT__CAPABILITY_J2EE_SERVER:
			return basicSetCapabilityJ2eeServer(null, msgs);
		case J2eePackage.J2EE_DEPLOY_ROOT__CAPABILITY_JAR_MODULE:
			return basicSetCapabilityJarModule(null, msgs);
		case J2eePackage.J2EE_DEPLOY_ROOT__CAPABILITY_JCA_CONTAINER:
			return basicSetCapabilityJcaContainer(null, msgs);
		case J2eePackage.J2EE_DEPLOY_ROOT__CAPABILITY_JCA_MODULE:
			return basicSetCapabilityJcaModule(null, msgs);
		case J2eePackage.J2EE_DEPLOY_ROOT__CAPABILITY_JSP_CONTAINER:
			return basicSetCapabilityJspContainer(null, msgs);
		case J2eePackage.J2EE_DEPLOY_ROOT__CAPABILITY_SERVLET_CONTAINER:
			return basicSetCapabilityServletContainer(null, msgs);
		case J2eePackage.J2EE_DEPLOY_ROOT__CAPABILITY_WEB_MODULE:
			return basicSetCapabilityWebModule(null, msgs);
		case J2eePackage.J2EE_DEPLOY_ROOT__COMPONENT_EAR:
			return basicSetComponentEar(null, msgs);
		case J2eePackage.J2EE_DEPLOY_ROOT__COMPONENT_EJB:
			return basicSetComponentEjb(null, msgs);
		case J2eePackage.J2EE_DEPLOY_ROOT__COMPONENT_JAR:
			return basicSetComponentJar(null, msgs);
		case J2eePackage.J2EE_DEPLOY_ROOT__COMPONENT_WEB:
			return basicSetComponentWeb(null, msgs);
		case J2eePackage.J2EE_DEPLOY_ROOT__INTERFACE_JAVA:
			return basicSetInterfaceJava(null, msgs);
		case J2eePackage.J2EE_DEPLOY_ROOT__INTERFACE_URL:
			return basicSetInterfaceUrl(null, msgs);
		case J2eePackage.J2EE_DEPLOY_ROOT__INTERFACE_WSDL:
			return basicSetInterfaceWsdl(null, msgs);
		case J2eePackage.J2EE_DEPLOY_ROOT__SERVICE_ENTITY:
			return basicSetServiceEntity(null, msgs);
		case J2eePackage.J2EE_DEPLOY_ROOT__SERVICE_SERVLET:
			return basicSetServiceServlet(null, msgs);
		case J2eePackage.J2EE_DEPLOY_ROOT__SERVICE_SESSION:
			return basicSetServiceSession(null, msgs);
		case J2eePackage.J2EE_DEPLOY_ROOT__SERVICE_WS:
			return basicSetServiceWs(null, msgs);
		case J2eePackage.J2EE_DEPLOY_ROOT__UNIT_APP_CLIENT:
			return basicSetUnitAppClient(null, msgs);
		case J2eePackage.J2EE_DEPLOY_ROOT__UNIT_J2EE_SERVER:
			return basicSetUnitJ2eeServer(null, msgs);
		case J2eePackage.J2EE_DEPLOY_ROOT__UNIT_J2EE_SERVER_UNIT:
			return basicSetUnitJ2eeServerUnit(null, msgs);
		case J2eePackage.J2EE_DEPLOY_ROOT__UNIT_JCA_MODULE:
			return basicSetUnitJcaModule(null, msgs);
		case J2eePackage.J2EE_DEPLOY_ROOT__UNIT_WEB_SERVER:
			return basicSetUnitWebServer(null, msgs);
		}
		return super.eInverseRemove(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID)
		{
		case J2eePackage.J2EE_DEPLOY_ROOT__MIXED:
			if (coreType)
				return getMixed();
			return ((FeatureMap.Internal) getMixed()).getWrapper();
		case J2eePackage.J2EE_DEPLOY_ROOT__XMLNS_PREFIX_MAP:
			if (coreType)
				return getXMLNSPrefixMap();
			else
				return getXMLNSPrefixMap().map();
		case J2eePackage.J2EE_DEPLOY_ROOT__XSI_SCHEMA_LOCATION:
			if (coreType)
				return getXSISchemaLocation();
			else
				return getXSISchemaLocation().map();
		case J2eePackage.J2EE_DEPLOY_ROOT__CAPABILITY_APP_CLIENT_MODULE:
			return getCapabilityAppClientModule();
		case J2eePackage.J2EE_DEPLOY_ROOT__CAPABILITY_EAR_MODULE:
			return getCapabilityEarModule();
		case J2eePackage.J2EE_DEPLOY_ROOT__CAPABILITY_EJB:
			return getCapabilityEjb();
		case J2eePackage.J2EE_DEPLOY_ROOT__CAPABILITY_EJB_CONTAINER:
			return getCapabilityEjbContainer();
		case J2eePackage.J2EE_DEPLOY_ROOT__CAPABILITY_EJB_MODULE:
			return getCapabilityEjbModule();
		case J2eePackage.J2EE_DEPLOY_ROOT__CAPABILITY_J2EE_CONTAINER:
			return getCapabilityJ2eeContainer();
		case J2eePackage.J2EE_DEPLOY_ROOT__CAPABILITY_J2EE_DATASOURCE:
			return getCapabilityJ2eeDatasource();
		case J2eePackage.J2EE_DEPLOY_ROOT__CAPABILITY_J2EE_MODULE:
			return getCapabilityJ2eeModule();
		case J2eePackage.J2EE_DEPLOY_ROOT__CAPABILITY_J2EE_RESOURCE_ENVIRONMENT_REQUIREMENT:
			return getCapabilityJ2eeResourceEnvironmentRequirement();
		case J2eePackage.J2EE_DEPLOY_ROOT__CAPABILITY_J2EE_RESOURCE_REQUIREMENT:
			return getCapabilityJ2eeResourceRequirement();
		case J2eePackage.J2EE_DEPLOY_ROOT__CAPABILITY_J2EE_SECURITY_ROLE:
			return getCapabilityJ2eeSecurityRole();
		case J2eePackage.J2EE_DEPLOY_ROOT__CAPABILITY_J2EE_SERVER:
			return getCapabilityJ2eeServer();
		case J2eePackage.J2EE_DEPLOY_ROOT__CAPABILITY_JAR_MODULE:
			return getCapabilityJarModule();
		case J2eePackage.J2EE_DEPLOY_ROOT__CAPABILITY_JCA_CONTAINER:
			return getCapabilityJcaContainer();
		case J2eePackage.J2EE_DEPLOY_ROOT__CAPABILITY_JCA_MODULE:
			return getCapabilityJcaModule();
		case J2eePackage.J2EE_DEPLOY_ROOT__CAPABILITY_JSP_CONTAINER:
			return getCapabilityJspContainer();
		case J2eePackage.J2EE_DEPLOY_ROOT__CAPABILITY_SERVLET_CONTAINER:
			return getCapabilityServletContainer();
		case J2eePackage.J2EE_DEPLOY_ROOT__CAPABILITY_WEB_MODULE:
			return getCapabilityWebModule();
		case J2eePackage.J2EE_DEPLOY_ROOT__COMPONENT_EAR:
			return getComponentEar();
		case J2eePackage.J2EE_DEPLOY_ROOT__COMPONENT_EJB:
			return getComponentEjb();
		case J2eePackage.J2EE_DEPLOY_ROOT__COMPONENT_JAR:
			return getComponentJar();
		case J2eePackage.J2EE_DEPLOY_ROOT__COMPONENT_WEB:
			return getComponentWeb();
		case J2eePackage.J2EE_DEPLOY_ROOT__INTERFACE_JAVA:
			return getInterfaceJava();
		case J2eePackage.J2EE_DEPLOY_ROOT__INTERFACE_URL:
			return getInterfaceUrl();
		case J2eePackage.J2EE_DEPLOY_ROOT__INTERFACE_WSDL:
			return getInterfaceWsdl();
		case J2eePackage.J2EE_DEPLOY_ROOT__SERVICE_ENTITY:
			return getServiceEntity();
		case J2eePackage.J2EE_DEPLOY_ROOT__SERVICE_SERVLET:
			return getServiceServlet();
		case J2eePackage.J2EE_DEPLOY_ROOT__SERVICE_SESSION:
			return getServiceSession();
		case J2eePackage.J2EE_DEPLOY_ROOT__SERVICE_WS:
			return getServiceWs();
		case J2eePackage.J2EE_DEPLOY_ROOT__UNIT_APP_CLIENT:
			return getUnitAppClient();
		case J2eePackage.J2EE_DEPLOY_ROOT__UNIT_J2EE_SERVER:
			return getUnitJ2eeServer();
		case J2eePackage.J2EE_DEPLOY_ROOT__UNIT_J2EE_SERVER_UNIT:
			return getUnitJ2eeServerUnit();
		case J2eePackage.J2EE_DEPLOY_ROOT__UNIT_JCA_MODULE:
			return getUnitJcaModule();
		case J2eePackage.J2EE_DEPLOY_ROOT__UNIT_WEB_SERVER:
			return getUnitWebServer();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public void eSet(int featureID, Object newValue) {
		switch (featureID)
		{
		case J2eePackage.J2EE_DEPLOY_ROOT__MIXED:
			((FeatureMap.Internal) getMixed()).set(newValue);
			return;
		case J2eePackage.J2EE_DEPLOY_ROOT__XMLNS_PREFIX_MAP:
			((EStructuralFeature.Setting) getXMLNSPrefixMap()).set(newValue);
			return;
		case J2eePackage.J2EE_DEPLOY_ROOT__XSI_SCHEMA_LOCATION:
			((EStructuralFeature.Setting) getXSISchemaLocation()).set(newValue);
			return;
		case J2eePackage.J2EE_DEPLOY_ROOT__CAPABILITY_APP_CLIENT_MODULE:
			setCapabilityAppClientModule((AppClientModule) newValue);
			return;
		case J2eePackage.J2EE_DEPLOY_ROOT__CAPABILITY_EAR_MODULE:
			setCapabilityEarModule((EARModuleCapability) newValue);
			return;
		case J2eePackage.J2EE_DEPLOY_ROOT__CAPABILITY_EJB:
			setCapabilityEjb((EJB) newValue);
			return;
		case J2eePackage.J2EE_DEPLOY_ROOT__CAPABILITY_EJB_CONTAINER:
			setCapabilityEjbContainer((EJBContainer) newValue);
			return;
		case J2eePackage.J2EE_DEPLOY_ROOT__CAPABILITY_EJB_MODULE:
			setCapabilityEjbModule((EJBModuleCapability) newValue);
			return;
		case J2eePackage.J2EE_DEPLOY_ROOT__CAPABILITY_J2EE_CONTAINER:
			setCapabilityJ2eeContainer((J2EEContainer) newValue);
			return;
		case J2eePackage.J2EE_DEPLOY_ROOT__CAPABILITY_J2EE_DATASOURCE:
			setCapabilityJ2eeDatasource((J2EEDatasource) newValue);
			return;
		case J2eePackage.J2EE_DEPLOY_ROOT__CAPABILITY_J2EE_MODULE:
			setCapabilityJ2eeModule((J2EEModuleCapability) newValue);
			return;
		case J2eePackage.J2EE_DEPLOY_ROOT__CAPABILITY_J2EE_RESOURCE_ENVIRONMENT_REQUIREMENT:
			setCapabilityJ2eeResourceEnvironmentRequirement((J2EEResourceEnvironmentRequirement) newValue);
			return;
		case J2eePackage.J2EE_DEPLOY_ROOT__CAPABILITY_J2EE_RESOURCE_REQUIREMENT:
			setCapabilityJ2eeResourceRequirement((J2EEResourceRequirement) newValue);
			return;
		case J2eePackage.J2EE_DEPLOY_ROOT__CAPABILITY_J2EE_SECURITY_ROLE:
			setCapabilityJ2eeSecurityRole((J2EESecurityRole) newValue);
			return;
		case J2eePackage.J2EE_DEPLOY_ROOT__CAPABILITY_J2EE_SERVER:
			setCapabilityJ2eeServer((J2EEServer) newValue);
			return;
		case J2eePackage.J2EE_DEPLOY_ROOT__CAPABILITY_JAR_MODULE:
			setCapabilityJarModule((JarModuleCapability) newValue);
			return;
		case J2eePackage.J2EE_DEPLOY_ROOT__CAPABILITY_JCA_CONTAINER:
			setCapabilityJcaContainer((JCAContainer) newValue);
			return;
		case J2eePackage.J2EE_DEPLOY_ROOT__CAPABILITY_JCA_MODULE:
			setCapabilityJcaModule((JCAModuleCapability) newValue);
			return;
		case J2eePackage.J2EE_DEPLOY_ROOT__CAPABILITY_JSP_CONTAINER:
			setCapabilityJspContainer((JSPContainer) newValue);
			return;
		case J2eePackage.J2EE_DEPLOY_ROOT__CAPABILITY_SERVLET_CONTAINER:
			setCapabilityServletContainer((ServletContainer) newValue);
			return;
		case J2eePackage.J2EE_DEPLOY_ROOT__CAPABILITY_WEB_MODULE:
			setCapabilityWebModule((WebModuleCapability) newValue);
			return;
		case J2eePackage.J2EE_DEPLOY_ROOT__COMPONENT_EAR:
			setComponentEar((EarModule) newValue);
			return;
		case J2eePackage.J2EE_DEPLOY_ROOT__COMPONENT_EJB:
			setComponentEjb((EjbModule) newValue);
			return;
		case J2eePackage.J2EE_DEPLOY_ROOT__COMPONENT_JAR:
			setComponentJar((JarModule) newValue);
			return;
		case J2eePackage.J2EE_DEPLOY_ROOT__COMPONENT_WEB:
			setComponentWeb((WebModule) newValue);
			return;
		case J2eePackage.J2EE_DEPLOY_ROOT__INTERFACE_JAVA:
			setInterfaceJava((JavaInterface) newValue);
			return;
		case J2eePackage.J2EE_DEPLOY_ROOT__INTERFACE_URL:
			setInterfaceUrl((URLInterface) newValue);
			return;
		case J2eePackage.J2EE_DEPLOY_ROOT__INTERFACE_WSDL:
			setInterfaceWsdl((WSDLInterface) newValue);
			return;
		case J2eePackage.J2EE_DEPLOY_ROOT__SERVICE_ENTITY:
			setServiceEntity((EntityService) newValue);
			return;
		case J2eePackage.J2EE_DEPLOY_ROOT__SERVICE_SERVLET:
			setServiceServlet((URLService) newValue);
			return;
		case J2eePackage.J2EE_DEPLOY_ROOT__SERVICE_SESSION:
			setServiceSession((SessionService) newValue);
			return;
		case J2eePackage.J2EE_DEPLOY_ROOT__SERVICE_WS:
			setServiceWs((WebService) newValue);
			return;
		case J2eePackage.J2EE_DEPLOY_ROOT__UNIT_APP_CLIENT:
			setUnitAppClient((AppClient) newValue);
			return;
		case J2eePackage.J2EE_DEPLOY_ROOT__UNIT_J2EE_SERVER:
			setUnitJ2eeServer((GenericJ2eeServer) newValue);
			return;
		case J2eePackage.J2EE_DEPLOY_ROOT__UNIT_J2EE_SERVER_UNIT:
			setUnitJ2eeServerUnit((J2EEServerUnit) newValue);
			return;
		case J2eePackage.J2EE_DEPLOY_ROOT__UNIT_JCA_MODULE:
			setUnitJcaModule((JCAModule) newValue);
			return;
		case J2eePackage.J2EE_DEPLOY_ROOT__UNIT_WEB_SERVER:
			setUnitWebServer((GenericWebServer) newValue);
			return;
		}
		super.eSet(featureID, newValue);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public void eUnset(int featureID) {
		switch (featureID)
		{
		case J2eePackage.J2EE_DEPLOY_ROOT__MIXED:
			getMixed().clear();
			return;
		case J2eePackage.J2EE_DEPLOY_ROOT__XMLNS_PREFIX_MAP:
			getXMLNSPrefixMap().clear();
			return;
		case J2eePackage.J2EE_DEPLOY_ROOT__XSI_SCHEMA_LOCATION:
			getXSISchemaLocation().clear();
			return;
		case J2eePackage.J2EE_DEPLOY_ROOT__CAPABILITY_APP_CLIENT_MODULE:
			setCapabilityAppClientModule((AppClientModule) null);
			return;
		case J2eePackage.J2EE_DEPLOY_ROOT__CAPABILITY_EAR_MODULE:
			setCapabilityEarModule((EARModuleCapability) null);
			return;
		case J2eePackage.J2EE_DEPLOY_ROOT__CAPABILITY_EJB:
			setCapabilityEjb((EJB) null);
			return;
		case J2eePackage.J2EE_DEPLOY_ROOT__CAPABILITY_EJB_CONTAINER:
			setCapabilityEjbContainer((EJBContainer) null);
			return;
		case J2eePackage.J2EE_DEPLOY_ROOT__CAPABILITY_EJB_MODULE:
			setCapabilityEjbModule((EJBModuleCapability) null);
			return;
		case J2eePackage.J2EE_DEPLOY_ROOT__CAPABILITY_J2EE_CONTAINER:
			setCapabilityJ2eeContainer((J2EEContainer) null);
			return;
		case J2eePackage.J2EE_DEPLOY_ROOT__CAPABILITY_J2EE_DATASOURCE:
			setCapabilityJ2eeDatasource((J2EEDatasource) null);
			return;
		case J2eePackage.J2EE_DEPLOY_ROOT__CAPABILITY_J2EE_MODULE:
			setCapabilityJ2eeModule((J2EEModuleCapability) null);
			return;
		case J2eePackage.J2EE_DEPLOY_ROOT__CAPABILITY_J2EE_RESOURCE_ENVIRONMENT_REQUIREMENT:
			setCapabilityJ2eeResourceEnvironmentRequirement((J2EEResourceEnvironmentRequirement) null);
			return;
		case J2eePackage.J2EE_DEPLOY_ROOT__CAPABILITY_J2EE_RESOURCE_REQUIREMENT:
			setCapabilityJ2eeResourceRequirement((J2EEResourceRequirement) null);
			return;
		case J2eePackage.J2EE_DEPLOY_ROOT__CAPABILITY_J2EE_SECURITY_ROLE:
			setCapabilityJ2eeSecurityRole((J2EESecurityRole) null);
			return;
		case J2eePackage.J2EE_DEPLOY_ROOT__CAPABILITY_J2EE_SERVER:
			setCapabilityJ2eeServer((J2EEServer) null);
			return;
		case J2eePackage.J2EE_DEPLOY_ROOT__CAPABILITY_JAR_MODULE:
			setCapabilityJarModule((JarModuleCapability) null);
			return;
		case J2eePackage.J2EE_DEPLOY_ROOT__CAPABILITY_JCA_CONTAINER:
			setCapabilityJcaContainer((JCAContainer) null);
			return;
		case J2eePackage.J2EE_DEPLOY_ROOT__CAPABILITY_JCA_MODULE:
			setCapabilityJcaModule((JCAModuleCapability) null);
			return;
		case J2eePackage.J2EE_DEPLOY_ROOT__CAPABILITY_JSP_CONTAINER:
			setCapabilityJspContainer((JSPContainer) null);
			return;
		case J2eePackage.J2EE_DEPLOY_ROOT__CAPABILITY_SERVLET_CONTAINER:
			setCapabilityServletContainer((ServletContainer) null);
			return;
		case J2eePackage.J2EE_DEPLOY_ROOT__CAPABILITY_WEB_MODULE:
			setCapabilityWebModule((WebModuleCapability) null);
			return;
		case J2eePackage.J2EE_DEPLOY_ROOT__COMPONENT_EAR:
			setComponentEar((EarModule) null);
			return;
		case J2eePackage.J2EE_DEPLOY_ROOT__COMPONENT_EJB:
			setComponentEjb((EjbModule) null);
			return;
		case J2eePackage.J2EE_DEPLOY_ROOT__COMPONENT_JAR:
			setComponentJar((JarModule) null);
			return;
		case J2eePackage.J2EE_DEPLOY_ROOT__COMPONENT_WEB:
			setComponentWeb((WebModule) null);
			return;
		case J2eePackage.J2EE_DEPLOY_ROOT__INTERFACE_JAVA:
			setInterfaceJava((JavaInterface) null);
			return;
		case J2eePackage.J2EE_DEPLOY_ROOT__INTERFACE_URL:
			setInterfaceUrl((URLInterface) null);
			return;
		case J2eePackage.J2EE_DEPLOY_ROOT__INTERFACE_WSDL:
			setInterfaceWsdl((WSDLInterface) null);
			return;
		case J2eePackage.J2EE_DEPLOY_ROOT__SERVICE_ENTITY:
			setServiceEntity((EntityService) null);
			return;
		case J2eePackage.J2EE_DEPLOY_ROOT__SERVICE_SERVLET:
			setServiceServlet((URLService) null);
			return;
		case J2eePackage.J2EE_DEPLOY_ROOT__SERVICE_SESSION:
			setServiceSession((SessionService) null);
			return;
		case J2eePackage.J2EE_DEPLOY_ROOT__SERVICE_WS:
			setServiceWs((WebService) null);
			return;
		case J2eePackage.J2EE_DEPLOY_ROOT__UNIT_APP_CLIENT:
			setUnitAppClient((AppClient) null);
			return;
		case J2eePackage.J2EE_DEPLOY_ROOT__UNIT_J2EE_SERVER:
			setUnitJ2eeServer((GenericJ2eeServer) null);
			return;
		case J2eePackage.J2EE_DEPLOY_ROOT__UNIT_J2EE_SERVER_UNIT:
			setUnitJ2eeServerUnit((J2EEServerUnit) null);
			return;
		case J2eePackage.J2EE_DEPLOY_ROOT__UNIT_JCA_MODULE:
			setUnitJcaModule((JCAModule) null);
			return;
		case J2eePackage.J2EE_DEPLOY_ROOT__UNIT_WEB_SERVER:
			setUnitWebServer((GenericWebServer) null);
			return;
		}
		super.eUnset(featureID);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public boolean eIsSet(int featureID) {
		switch (featureID)
		{
		case J2eePackage.J2EE_DEPLOY_ROOT__MIXED:
			return mixed != null && !mixed.isEmpty();
		case J2eePackage.J2EE_DEPLOY_ROOT__XMLNS_PREFIX_MAP:
			return xMLNSPrefixMap != null && !xMLNSPrefixMap.isEmpty();
		case J2eePackage.J2EE_DEPLOY_ROOT__XSI_SCHEMA_LOCATION:
			return xSISchemaLocation != null && !xSISchemaLocation.isEmpty();
		case J2eePackage.J2EE_DEPLOY_ROOT__CAPABILITY_APP_CLIENT_MODULE:
			return getCapabilityAppClientModule() != null;
		case J2eePackage.J2EE_DEPLOY_ROOT__CAPABILITY_EAR_MODULE:
			return getCapabilityEarModule() != null;
		case J2eePackage.J2EE_DEPLOY_ROOT__CAPABILITY_EJB:
			return getCapabilityEjb() != null;
		case J2eePackage.J2EE_DEPLOY_ROOT__CAPABILITY_EJB_CONTAINER:
			return getCapabilityEjbContainer() != null;
		case J2eePackage.J2EE_DEPLOY_ROOT__CAPABILITY_EJB_MODULE:
			return getCapabilityEjbModule() != null;
		case J2eePackage.J2EE_DEPLOY_ROOT__CAPABILITY_J2EE_CONTAINER:
			return getCapabilityJ2eeContainer() != null;
		case J2eePackage.J2EE_DEPLOY_ROOT__CAPABILITY_J2EE_DATASOURCE:
			return getCapabilityJ2eeDatasource() != null;
		case J2eePackage.J2EE_DEPLOY_ROOT__CAPABILITY_J2EE_MODULE:
			return getCapabilityJ2eeModule() != null;
		case J2eePackage.J2EE_DEPLOY_ROOT__CAPABILITY_J2EE_RESOURCE_ENVIRONMENT_REQUIREMENT:
			return getCapabilityJ2eeResourceEnvironmentRequirement() != null;
		case J2eePackage.J2EE_DEPLOY_ROOT__CAPABILITY_J2EE_RESOURCE_REQUIREMENT:
			return getCapabilityJ2eeResourceRequirement() != null;
		case J2eePackage.J2EE_DEPLOY_ROOT__CAPABILITY_J2EE_SECURITY_ROLE:
			return getCapabilityJ2eeSecurityRole() != null;
		case J2eePackage.J2EE_DEPLOY_ROOT__CAPABILITY_J2EE_SERVER:
			return getCapabilityJ2eeServer() != null;
		case J2eePackage.J2EE_DEPLOY_ROOT__CAPABILITY_JAR_MODULE:
			return getCapabilityJarModule() != null;
		case J2eePackage.J2EE_DEPLOY_ROOT__CAPABILITY_JCA_CONTAINER:
			return getCapabilityJcaContainer() != null;
		case J2eePackage.J2EE_DEPLOY_ROOT__CAPABILITY_JCA_MODULE:
			return getCapabilityJcaModule() != null;
		case J2eePackage.J2EE_DEPLOY_ROOT__CAPABILITY_JSP_CONTAINER:
			return getCapabilityJspContainer() != null;
		case J2eePackage.J2EE_DEPLOY_ROOT__CAPABILITY_SERVLET_CONTAINER:
			return getCapabilityServletContainer() != null;
		case J2eePackage.J2EE_DEPLOY_ROOT__CAPABILITY_WEB_MODULE:
			return getCapabilityWebModule() != null;
		case J2eePackage.J2EE_DEPLOY_ROOT__COMPONENT_EAR:
			return getComponentEar() != null;
		case J2eePackage.J2EE_DEPLOY_ROOT__COMPONENT_EJB:
			return getComponentEjb() != null;
		case J2eePackage.J2EE_DEPLOY_ROOT__COMPONENT_JAR:
			return getComponentJar() != null;
		case J2eePackage.J2EE_DEPLOY_ROOT__COMPONENT_WEB:
			return getComponentWeb() != null;
		case J2eePackage.J2EE_DEPLOY_ROOT__INTERFACE_JAVA:
			return getInterfaceJava() != null;
		case J2eePackage.J2EE_DEPLOY_ROOT__INTERFACE_URL:
			return getInterfaceUrl() != null;
		case J2eePackage.J2EE_DEPLOY_ROOT__INTERFACE_WSDL:
			return getInterfaceWsdl() != null;
		case J2eePackage.J2EE_DEPLOY_ROOT__SERVICE_ENTITY:
			return getServiceEntity() != null;
		case J2eePackage.J2EE_DEPLOY_ROOT__SERVICE_SERVLET:
			return getServiceServlet() != null;
		case J2eePackage.J2EE_DEPLOY_ROOT__SERVICE_SESSION:
			return getServiceSession() != null;
		case J2eePackage.J2EE_DEPLOY_ROOT__SERVICE_WS:
			return getServiceWs() != null;
		case J2eePackage.J2EE_DEPLOY_ROOT__UNIT_APP_CLIENT:
			return getUnitAppClient() != null;
		case J2eePackage.J2EE_DEPLOY_ROOT__UNIT_J2EE_SERVER:
			return getUnitJ2eeServer() != null;
		case J2eePackage.J2EE_DEPLOY_ROOT__UNIT_J2EE_SERVER_UNIT:
			return getUnitJ2eeServerUnit() != null;
		case J2eePackage.J2EE_DEPLOY_ROOT__UNIT_JCA_MODULE:
			return getUnitJcaModule() != null;
		case J2eePackage.J2EE_DEPLOY_ROOT__UNIT_WEB_SERVER:
			return getUnitWebServer() != null;
		}
		return super.eIsSet(featureID);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public String toString() {
		if (eIsProxy())
			return super.toString();

		StringBuffer result = new StringBuffer(super.toString());
		result.append(" (mixed: "); //$NON-NLS-1$
		result.append(mixed);
		result.append(')');
		return result.toString();
	}

} //J2EEDeployRootImpl
