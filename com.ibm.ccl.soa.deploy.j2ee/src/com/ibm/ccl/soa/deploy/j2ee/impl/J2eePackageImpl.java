/*******************************************************************************
 * Copyright (c) 2003, 2007 IBM Corporation Licensed Material - Property of IBM. All rights reserved.
 *  
 * US Government Users Restricted Rights - Use, duplication or disclosure v1.0 restricted by GSA ADP
 * Schedule Contract with IBM Corp.
 * 
 * Contributors: IBM Corporation - initial API and implementation
 *******************************************************************************/
package com.ibm.ccl.soa.deploy.j2ee.impl;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EDataType;
import org.eclipse.emf.ecore.EEnum;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EcorePackage;
import org.eclipse.emf.ecore.impl.EPackageImpl;
import org.eclipse.emf.ecore.xml.type.XMLTypePackage;

import com.ibm.ccl.soa.deploy.core.CorePackage;
import com.ibm.ccl.soa.deploy.j2ee.AppClient;
import com.ibm.ccl.soa.deploy.j2ee.AppClientModule;
import com.ibm.ccl.soa.deploy.j2ee.EARModuleCapability;
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
import com.ibm.ccl.soa.deploy.j2ee.J2CAuthenticationUnit;
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
 * <!-- begin-user-doc --> An implementation of the model <b>Package</b>. <!-- end-user-doc -->
 * @generated
 */
public class J2eePackageImpl extends EPackageImpl implements J2eePackage {
	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public static final String copyright = "Copyright (c) 2005, 2006 IBM Corporation. Licensed Material - Property of IBM. All rights reserved."; //$NON-NLS-1$

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	private EClass appClientEClass = null;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	private EClass appClientModuleEClass = null;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	private EClass earModuleEClass = null;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	private EClass earModuleCapabilityEClass = null;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	private EClass ejbEClass = null;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	private EClass ejbContainerEClass = null;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	private EClass ejbModuleEClass = null;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	private EClass ejbModuleCapabilityEClass = null;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	private EClass enterpriseBeanServiceEClass = null;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	private EClass entityServiceEClass = null;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	private EClass genericJ2eeServerEClass = null;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	private EClass genericWebServerEClass = null;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	private EClass j2CAuthenticationDataEntryEClass = null;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	private EClass j2CAuthenticationUnitEClass = null;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	private EClass j2EEContainerEClass = null;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	private EClass j2EEDatasourceEClass = null;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	private EClass j2EEDeployRootEClass = null;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	private EClass j2EEModuleCapabilityEClass = null;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	private EClass j2EEResourceEnvironmentRequirementEClass = null;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	private EClass j2EEResourceRequirementEClass = null;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	private EClass j2EESecurityRoleEClass = null;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	private EClass j2EEServerEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass j2EEServerUnitEClass = null;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	private EClass jarModuleEClass = null;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	private EClass jarModuleCapabilityEClass = null;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	private EClass javaInterfaceEClass = null;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	private EClass jcaContainerEClass = null;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	private EClass jcaModuleEClass = null;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	private EClass jcaModuleCapabilityEClass = null;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	private EClass jspContainerEClass = null;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	private EClass servletContainerEClass = null;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	private EClass sessionServiceEClass = null;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	private EClass urlInterfaceEClass = null;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	private EClass urlServiceEClass = null;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	private EClass webModuleEClass = null;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	private EClass webModuleCapabilityEClass = null;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	private EClass webServiceEClass = null;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	private EClass wsdlInterfaceEClass = null;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	private EEnum ejbContainerVersionEEnum = null;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	private EEnum j2EEContainerVersionEEnum = null;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	private EEnum jcaContainerVersionEEnum = null;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	private EEnum jspContainerVersionEEnum = null;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	private EEnum servletContainerVersionEEnum = null;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	private EEnum vicinityEEnum = null;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	private EDataType ejbContainerVersionObjectEDataType = null;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	private EDataType j2EEContainerVersionObjectEDataType = null;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	private EDataType jcaContainerVersionObjectEDataType = null;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	private EDataType jspContainerVersionObjectEDataType = null;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	private EDataType servletContainerVersionObjectEDataType = null;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	private EDataType vicinityObjectEDataType = null;

	/**
	 * Creates an instance of the model <b>Package</b>, registered with
	 * {@link org.eclipse.emf.ecore.EPackage.Registry EPackage.Registry} by the package
	 * package URI value.
	 * <p>Note: the correct way to create the package is via the static
	 * factory method {@link #init init()}, which also performs
	 * initialization of the package, or returns the registered package,
	 * if one already exists.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see org.eclipse.emf.ecore.EPackage.Registry
	 * @see com.ibm.ccl.soa.deploy.j2ee.J2eePackage#eNS_URI
	 * @see #init()
	 * @generated
	 */
	private J2eePackageImpl() {
		super(eNS_URI, J2eeFactory.eINSTANCE);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	private static boolean isInited = false;

	/**
	 * Creates, registers, and initializes the <b>Package</b> for this
	 * model, and for any others upon which it depends.  Simple
	 * dependencies are satisfied by calling this method on all
	 * dependent packages before doing anything else.  This method drives
	 * initialization for interdependent packages directly, in parallel
	 * with this package, itself.
	 * <p>Of this package and its interdependencies, all packages which
	 * have not yet been registered by their URI values are first created
	 * and registered.  The packages are then initialized in two steps:
	 * meta-model objects for all of the packages are created before any
	 * are initialized, since one package's meta-model objects may refer to
	 * those of another.
	 * <p>Invocation of this method will not affect any packages that have
	 * already been initialized.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see #eNS_URI
	 * @see #createPackageContents()
	 * @see #initializePackageContents()
	 * @generated
	 */
	public static J2eePackage init() {
		if (isInited)
			return (J2eePackage) EPackage.Registry.INSTANCE.getEPackage(J2eePackage.eNS_URI);

		// Obtain or create and register package
		J2eePackageImpl theJ2eePackage = (J2eePackageImpl) (EPackage.Registry.INSTANCE
				.getEPackage(eNS_URI) instanceof J2eePackageImpl ? EPackage.Registry.INSTANCE
				.getEPackage(eNS_URI) : new J2eePackageImpl());

		isInited = true;

		// Initialize simple dependencies
		CorePackage.eINSTANCE.eClass();
		EcorePackage.eINSTANCE.eClass();
		XMLTypePackage.eINSTANCE.eClass();

		// Create package meta-data objects
		theJ2eePackage.createPackageContents();

		// Initialize created meta-data
		theJ2eePackage.initializePackageContents();

		// Mark meta-data to indicate it can't be changed
		theJ2eePackage.freeze();

		return theJ2eePackage;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getAppClient() {
		return appClientEClass;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getAppClientModule() {
		return appClientModuleEClass;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getEarModule() {
		return earModuleEClass;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getEARModuleCapability() {
		return earModuleCapabilityEClass;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getEJB() {
		return ejbEClass;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getEJB_Interface() {
		return (EAttribute) ejbEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getEJBContainer() {
		return ejbContainerEClass;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getEJBContainer_ContainerVersion() {
		return (EAttribute) ejbContainerEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getEjbModule() {
		return ejbModuleEClass;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getEJBModuleCapability() {
		return ejbModuleCapabilityEClass;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getEnterpriseBeanService() {
		return enterpriseBeanServiceEClass;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getEnterpriseBeanService_HomeInterface() {
		return (EReference) enterpriseBeanServiceEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getEnterpriseBeanService_EjbName() {
		return (EAttribute) enterpriseBeanServiceEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getEnterpriseBeanService_JndiName() {
		return (EAttribute) enterpriseBeanServiceEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getEnterpriseBeanService_Vicinity() {
		return (EAttribute) enterpriseBeanServiceEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getEntityService() {
		return entityServiceEClass;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getEntityService_Managed() {
		return (EAttribute) entityServiceEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getGenericJ2eeServer() {
		return genericJ2eeServerEClass;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getGenericWebServer() {
		return genericWebServerEClass;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getJ2CAuthenticationDataEntry() {
		return j2CAuthenticationDataEntryEClass;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getJ2CAuthenticationDataEntry_Alias() {
		return (EAttribute) j2CAuthenticationDataEntryEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getJ2CAuthenticationDataEntry_Password() {
		return (EAttribute) j2CAuthenticationDataEntryEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getJ2CAuthenticationDataEntry_UserId() {
		return (EAttribute) j2CAuthenticationDataEntryEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getJ2CAuthenticationUnit() {
		return j2CAuthenticationUnitEClass;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getJ2EEContainer() {
		return j2EEContainerEClass;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getJ2EEContainer_ContainerVersion() {
		return (EAttribute) j2EEContainerEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getJ2EEDatasource() {
		return j2EEDatasourceEClass;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getJ2EEDatasource_DatasourceName() {
		return (EAttribute) j2EEDatasourceEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getJ2EEDatasource_DbName() {
		return (EAttribute) j2EEDatasourceEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getJ2EEDatasource_Hostname() {
		return (EAttribute) j2EEDatasourceEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getJ2EEDatasource_JndiName() {
		return (EAttribute) j2EEDatasourceEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getJ2EEDatasource_Password() {
		return (EAttribute) j2EEDatasourceEClass.getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getJ2EEDatasource_Port() {
		return (EAttribute) j2EEDatasourceEClass.getEStructuralFeatures().get(5);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getJ2EEDatasource_UsedForCmp() {
		return (EAttribute) j2EEDatasourceEClass.getEStructuralFeatures().get(6);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getJ2EEDatasource_Username() {
		return (EAttribute) j2EEDatasourceEClass.getEStructuralFeatures().get(7);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getJ2EEDeployRoot() {
		return j2EEDeployRootEClass;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getJ2EEDeployRoot_Mixed() {
		return (EAttribute) j2EEDeployRootEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getJ2EEDeployRoot_XMLNSPrefixMap() {
		return (EReference) j2EEDeployRootEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getJ2EEDeployRoot_XSISchemaLocation() {
		return (EReference) j2EEDeployRootEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getJ2EEDeployRoot_CapabilityAppClientModule() {
		return (EReference) j2EEDeployRootEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getJ2EEDeployRoot_CapabilityEarModule() {
		return (EReference) j2EEDeployRootEClass.getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getJ2EEDeployRoot_CapabilityEjb() {
		return (EReference) j2EEDeployRootEClass.getEStructuralFeatures().get(5);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getJ2EEDeployRoot_CapabilityEjbContainer() {
		return (EReference) j2EEDeployRootEClass.getEStructuralFeatures().get(6);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getJ2EEDeployRoot_CapabilityEjbModule() {
		return (EReference) j2EEDeployRootEClass.getEStructuralFeatures().get(7);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getJ2EEDeployRoot_CapabilityJ2eeContainer() {
		return (EReference) j2EEDeployRootEClass.getEStructuralFeatures().get(8);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getJ2EEDeployRoot_CapabilityJ2eeDatasource() {
		return (EReference) j2EEDeployRootEClass.getEStructuralFeatures().get(9);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getJ2EEDeployRoot_CapabilityJ2eeModule() {
		return (EReference) j2EEDeployRootEClass.getEStructuralFeatures().get(10);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getJ2EEDeployRoot_CapabilityJ2eeResourceEnvironmentRequirement() {
		return (EReference) j2EEDeployRootEClass.getEStructuralFeatures().get(11);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getJ2EEDeployRoot_CapabilityJ2eeResourceRequirement() {
		return (EReference) j2EEDeployRootEClass.getEStructuralFeatures().get(12);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getJ2EEDeployRoot_CapabilityJ2eeSecurityRole() {
		return (EReference) j2EEDeployRootEClass.getEStructuralFeatures().get(13);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getJ2EEDeployRoot_CapabilityJ2eeServer() {
		return (EReference) j2EEDeployRootEClass.getEStructuralFeatures().get(14);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getJ2EEDeployRoot_CapabilityJarModule() {
		return (EReference) j2EEDeployRootEClass.getEStructuralFeatures().get(15);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getJ2EEDeployRoot_CapabilityJcaContainer() {
		return (EReference) j2EEDeployRootEClass.getEStructuralFeatures().get(16);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getJ2EEDeployRoot_CapabilityJcaModule() {
		return (EReference) j2EEDeployRootEClass.getEStructuralFeatures().get(17);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getJ2EEDeployRoot_CapabilityJspContainer() {
		return (EReference) j2EEDeployRootEClass.getEStructuralFeatures().get(18);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getJ2EEDeployRoot_CapabilityServletContainer() {
		return (EReference) j2EEDeployRootEClass.getEStructuralFeatures().get(19);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getJ2EEDeployRoot_CapabilityWebModule() {
		return (EReference) j2EEDeployRootEClass.getEStructuralFeatures().get(20);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getJ2EEDeployRoot_ComponentEar() {
		return (EReference) j2EEDeployRootEClass.getEStructuralFeatures().get(21);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getJ2EEDeployRoot_ComponentEjb() {
		return (EReference) j2EEDeployRootEClass.getEStructuralFeatures().get(22);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getJ2EEDeployRoot_ComponentJar() {
		return (EReference) j2EEDeployRootEClass.getEStructuralFeatures().get(23);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getJ2EEDeployRoot_ComponentWeb() {
		return (EReference) j2EEDeployRootEClass.getEStructuralFeatures().get(24);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getJ2EEDeployRoot_InterfaceJava() {
		return (EReference) j2EEDeployRootEClass.getEStructuralFeatures().get(25);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getJ2EEDeployRoot_InterfaceUrl() {
		return (EReference) j2EEDeployRootEClass.getEStructuralFeatures().get(26);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getJ2EEDeployRoot_InterfaceWsdl() {
		return (EReference) j2EEDeployRootEClass.getEStructuralFeatures().get(27);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getJ2EEDeployRoot_ServiceEntity() {
		return (EReference) j2EEDeployRootEClass.getEStructuralFeatures().get(28);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getJ2EEDeployRoot_ServiceServlet() {
		return (EReference) j2EEDeployRootEClass.getEStructuralFeatures().get(29);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getJ2EEDeployRoot_ServiceSession() {
		return (EReference) j2EEDeployRootEClass.getEStructuralFeatures().get(30);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getJ2EEDeployRoot_ServiceWs() {
		return (EReference) j2EEDeployRootEClass.getEStructuralFeatures().get(31);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getJ2EEDeployRoot_UnitAppClient() {
		return (EReference) j2EEDeployRootEClass.getEStructuralFeatures().get(32);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getJ2EEDeployRoot_UnitJ2eeServer() {
		return (EReference) j2EEDeployRootEClass.getEStructuralFeatures().get(33);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getJ2EEDeployRoot_UnitJ2eeServerUnit() {
		return (EReference) j2EEDeployRootEClass.getEStructuralFeatures().get(34);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getJ2EEDeployRoot_UnitJcaModule() {
		return (EReference) j2EEDeployRootEClass.getEStructuralFeatures().get(35);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getJ2EEDeployRoot_UnitWebServer() {
		return (EReference) j2EEDeployRootEClass.getEStructuralFeatures().get(36);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getJ2EEModuleCapability() {
		return j2EEModuleCapabilityEClass;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getJ2EEModuleCapability_ModuleName() {
		return (EAttribute) j2EEModuleCapabilityEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getJ2EEResourceEnvironmentRequirement() {
		return j2EEResourceEnvironmentRequirementEClass;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getJ2EEResourceEnvironmentRequirement_JndiName() {
		return (EAttribute) j2EEResourceEnvironmentRequirementEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getJ2EEResourceEnvironmentRequirement_Type() {
		return (EAttribute) j2EEResourceEnvironmentRequirementEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getJ2EEResourceRequirement() {
		return j2EEResourceRequirementEClass;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getJ2EEResourceRequirement_JndiName() {
		return (EAttribute) j2EEResourceRequirementEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getJ2EEResourceRequirement_Type() {
		return (EAttribute) j2EEResourceRequirementEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getJ2EESecurityRole() {
		return j2EESecurityRoleEClass;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getJ2EESecurityRole_Role() {
		return (EAttribute) j2EESecurityRoleEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getJ2EEServer() {
		return j2EEServerEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getJ2EEServerUnit() {
		return j2EEServerUnitEClass;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getJarModule() {
		return jarModuleEClass;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getJarModuleCapability() {
		return jarModuleCapabilityEClass;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getJavaInterface() {
		return javaInterfaceEClass;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getJavaInterface_Interface() {
		return (EAttribute) javaInterfaceEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getJCAContainer() {
		return jcaContainerEClass;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getJCAContainer_ContainerVersion() {
		return (EAttribute) jcaContainerEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getJCAModule() {
		return jcaModuleEClass;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getJCAModuleCapability() {
		return jcaModuleCapabilityEClass;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getJSPContainer() {
		return jspContainerEClass;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getJSPContainer_ContainerVersion() {
		return (EAttribute) jspContainerEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getServletContainer() {
		return servletContainerEClass;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getServletContainer_ContainerVersion() {
		return (EAttribute) servletContainerEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getSessionService() {
		return sessionServiceEClass;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getURLInterface() {
		return urlInterfaceEClass;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getURLInterface_ParamName() {
		return (EAttribute) urlInterfaceEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getURLService() {
		return urlServiceEClass;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getURLService_UrlPattern() {
		return (EAttribute) urlServiceEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getWebModule() {
		return webModuleEClass;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getWebModuleCapability() {
		return webModuleCapabilityEClass;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getWebModuleCapability_ContextRoot() {
		return (EAttribute) webModuleCapabilityEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getWebService() {
		return webServiceEClass;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getWebService_Endpoint() {
		return (EAttribute) webServiceEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getWSDLInterface() {
		return wsdlInterfaceEClass;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getWSDLInterface_TypeUri() {
		return (EAttribute) wsdlInterfaceEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EEnum getEJBContainerVersion() {
		return ejbContainerVersionEEnum;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EEnum getJ2EEContainerVersion() {
		return j2EEContainerVersionEEnum;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EEnum getJCAContainerVersion() {
		return jcaContainerVersionEEnum;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EEnum getJSPContainerVersion() {
		return jspContainerVersionEEnum;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EEnum getServletContainerVersion() {
		return servletContainerVersionEEnum;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EEnum getVicinity() {
		return vicinityEEnum;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EDataType getEJBContainerVersionObject() {
		return ejbContainerVersionObjectEDataType;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EDataType getJ2EEContainerVersionObject() {
		return j2EEContainerVersionObjectEDataType;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EDataType getJCAContainerVersionObject() {
		return jcaContainerVersionObjectEDataType;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EDataType getJSPContainerVersionObject() {
		return jspContainerVersionObjectEDataType;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EDataType getServletContainerVersionObject() {
		return servletContainerVersionObjectEDataType;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EDataType getVicinityObject() {
		return vicinityObjectEDataType;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public J2eeFactory getJ2eeFactory() {
		return (J2eeFactory) getEFactoryInstance();
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	private boolean isCreated = false;

	/**
	 * Creates the meta-model objects for the package.  This method is
	 * guarded to have no affect on any invocation but its first.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public void createPackageContents() {
		if (isCreated)
			return;
		isCreated = true;

		// Create classes and their features
		appClientEClass = createEClass(APP_CLIENT);

		appClientModuleEClass = createEClass(APP_CLIENT_MODULE);

		earModuleEClass = createEClass(EAR_MODULE);

		earModuleCapabilityEClass = createEClass(EAR_MODULE_CAPABILITY);

		ejbEClass = createEClass(EJB);
		createEAttribute(ejbEClass, EJB__INTERFACE);

		ejbContainerEClass = createEClass(EJB_CONTAINER);
		createEAttribute(ejbContainerEClass, EJB_CONTAINER__CONTAINER_VERSION);

		ejbModuleEClass = createEClass(EJB_MODULE);

		ejbModuleCapabilityEClass = createEClass(EJB_MODULE_CAPABILITY);

		enterpriseBeanServiceEClass = createEClass(ENTERPRISE_BEAN_SERVICE);
		createEReference(enterpriseBeanServiceEClass, ENTERPRISE_BEAN_SERVICE__HOME_INTERFACE);
		createEAttribute(enterpriseBeanServiceEClass, ENTERPRISE_BEAN_SERVICE__EJB_NAME);
		createEAttribute(enterpriseBeanServiceEClass, ENTERPRISE_BEAN_SERVICE__JNDI_NAME);
		createEAttribute(enterpriseBeanServiceEClass, ENTERPRISE_BEAN_SERVICE__VICINITY);

		entityServiceEClass = createEClass(ENTITY_SERVICE);
		createEAttribute(entityServiceEClass, ENTITY_SERVICE__MANAGED);

		genericJ2eeServerEClass = createEClass(GENERIC_J2EE_SERVER);

		genericWebServerEClass = createEClass(GENERIC_WEB_SERVER);

		j2CAuthenticationDataEntryEClass = createEClass(J2C_AUTHENTICATION_DATA_ENTRY);
		createEAttribute(j2CAuthenticationDataEntryEClass, J2C_AUTHENTICATION_DATA_ENTRY__ALIAS);
		createEAttribute(j2CAuthenticationDataEntryEClass, J2C_AUTHENTICATION_DATA_ENTRY__PASSWORD);
		createEAttribute(j2CAuthenticationDataEntryEClass, J2C_AUTHENTICATION_DATA_ENTRY__USER_ID);

		j2CAuthenticationUnitEClass = createEClass(J2C_AUTHENTICATION_UNIT);

		j2EEContainerEClass = createEClass(J2EE_CONTAINER);
		createEAttribute(j2EEContainerEClass, J2EE_CONTAINER__CONTAINER_VERSION);

		j2EEDatasourceEClass = createEClass(J2EE_DATASOURCE);
		createEAttribute(j2EEDatasourceEClass, J2EE_DATASOURCE__DATASOURCE_NAME);
		createEAttribute(j2EEDatasourceEClass, J2EE_DATASOURCE__DB_NAME);
		createEAttribute(j2EEDatasourceEClass, J2EE_DATASOURCE__HOSTNAME);
		createEAttribute(j2EEDatasourceEClass, J2EE_DATASOURCE__JNDI_NAME);
		createEAttribute(j2EEDatasourceEClass, J2EE_DATASOURCE__PASSWORD);
		createEAttribute(j2EEDatasourceEClass, J2EE_DATASOURCE__PORT);
		createEAttribute(j2EEDatasourceEClass, J2EE_DATASOURCE__USED_FOR_CMP);
		createEAttribute(j2EEDatasourceEClass, J2EE_DATASOURCE__USERNAME);

		j2EEDeployRootEClass = createEClass(J2EE_DEPLOY_ROOT);
		createEAttribute(j2EEDeployRootEClass, J2EE_DEPLOY_ROOT__MIXED);
		createEReference(j2EEDeployRootEClass, J2EE_DEPLOY_ROOT__XMLNS_PREFIX_MAP);
		createEReference(j2EEDeployRootEClass, J2EE_DEPLOY_ROOT__XSI_SCHEMA_LOCATION);
		createEReference(j2EEDeployRootEClass, J2EE_DEPLOY_ROOT__CAPABILITY_APP_CLIENT_MODULE);
		createEReference(j2EEDeployRootEClass, J2EE_DEPLOY_ROOT__CAPABILITY_EAR_MODULE);
		createEReference(j2EEDeployRootEClass, J2EE_DEPLOY_ROOT__CAPABILITY_EJB);
		createEReference(j2EEDeployRootEClass, J2EE_DEPLOY_ROOT__CAPABILITY_EJB_CONTAINER);
		createEReference(j2EEDeployRootEClass, J2EE_DEPLOY_ROOT__CAPABILITY_EJB_MODULE);
		createEReference(j2EEDeployRootEClass, J2EE_DEPLOY_ROOT__CAPABILITY_J2EE_CONTAINER);
		createEReference(j2EEDeployRootEClass, J2EE_DEPLOY_ROOT__CAPABILITY_J2EE_DATASOURCE);
		createEReference(j2EEDeployRootEClass, J2EE_DEPLOY_ROOT__CAPABILITY_J2EE_MODULE);
		createEReference(j2EEDeployRootEClass,
				J2EE_DEPLOY_ROOT__CAPABILITY_J2EE_RESOURCE_ENVIRONMENT_REQUIREMENT);
		createEReference(j2EEDeployRootEClass, J2EE_DEPLOY_ROOT__CAPABILITY_J2EE_RESOURCE_REQUIREMENT);
		createEReference(j2EEDeployRootEClass, J2EE_DEPLOY_ROOT__CAPABILITY_J2EE_SECURITY_ROLE);
		createEReference(j2EEDeployRootEClass, J2EE_DEPLOY_ROOT__CAPABILITY_J2EE_SERVER);
		createEReference(j2EEDeployRootEClass, J2EE_DEPLOY_ROOT__CAPABILITY_JAR_MODULE);
		createEReference(j2EEDeployRootEClass, J2EE_DEPLOY_ROOT__CAPABILITY_JCA_CONTAINER);
		createEReference(j2EEDeployRootEClass, J2EE_DEPLOY_ROOT__CAPABILITY_JCA_MODULE);
		createEReference(j2EEDeployRootEClass, J2EE_DEPLOY_ROOT__CAPABILITY_JSP_CONTAINER);
		createEReference(j2EEDeployRootEClass, J2EE_DEPLOY_ROOT__CAPABILITY_SERVLET_CONTAINER);
		createEReference(j2EEDeployRootEClass, J2EE_DEPLOY_ROOT__CAPABILITY_WEB_MODULE);
		createEReference(j2EEDeployRootEClass, J2EE_DEPLOY_ROOT__COMPONENT_EAR);
		createEReference(j2EEDeployRootEClass, J2EE_DEPLOY_ROOT__COMPONENT_EJB);
		createEReference(j2EEDeployRootEClass, J2EE_DEPLOY_ROOT__COMPONENT_JAR);
		createEReference(j2EEDeployRootEClass, J2EE_DEPLOY_ROOT__COMPONENT_WEB);
		createEReference(j2EEDeployRootEClass, J2EE_DEPLOY_ROOT__INTERFACE_JAVA);
		createEReference(j2EEDeployRootEClass, J2EE_DEPLOY_ROOT__INTERFACE_URL);
		createEReference(j2EEDeployRootEClass, J2EE_DEPLOY_ROOT__INTERFACE_WSDL);
		createEReference(j2EEDeployRootEClass, J2EE_DEPLOY_ROOT__SERVICE_ENTITY);
		createEReference(j2EEDeployRootEClass, J2EE_DEPLOY_ROOT__SERVICE_SERVLET);
		createEReference(j2EEDeployRootEClass, J2EE_DEPLOY_ROOT__SERVICE_SESSION);
		createEReference(j2EEDeployRootEClass, J2EE_DEPLOY_ROOT__SERVICE_WS);
		createEReference(j2EEDeployRootEClass, J2EE_DEPLOY_ROOT__UNIT_APP_CLIENT);
		createEReference(j2EEDeployRootEClass, J2EE_DEPLOY_ROOT__UNIT_J2EE_SERVER);
		createEReference(j2EEDeployRootEClass, J2EE_DEPLOY_ROOT__UNIT_J2EE_SERVER_UNIT);
		createEReference(j2EEDeployRootEClass, J2EE_DEPLOY_ROOT__UNIT_JCA_MODULE);
		createEReference(j2EEDeployRootEClass, J2EE_DEPLOY_ROOT__UNIT_WEB_SERVER);

		j2EEModuleCapabilityEClass = createEClass(J2EE_MODULE_CAPABILITY);
		createEAttribute(j2EEModuleCapabilityEClass, J2EE_MODULE_CAPABILITY__MODULE_NAME);

		j2EEResourceEnvironmentRequirementEClass = createEClass(J2EE_RESOURCE_ENVIRONMENT_REQUIREMENT);
		createEAttribute(j2EEResourceEnvironmentRequirementEClass,
				J2EE_RESOURCE_ENVIRONMENT_REQUIREMENT__JNDI_NAME);
		createEAttribute(j2EEResourceEnvironmentRequirementEClass,
				J2EE_RESOURCE_ENVIRONMENT_REQUIREMENT__TYPE);

		j2EEResourceRequirementEClass = createEClass(J2EE_RESOURCE_REQUIREMENT);
		createEAttribute(j2EEResourceRequirementEClass, J2EE_RESOURCE_REQUIREMENT__JNDI_NAME);
		createEAttribute(j2EEResourceRequirementEClass, J2EE_RESOURCE_REQUIREMENT__TYPE);

		j2EESecurityRoleEClass = createEClass(J2EE_SECURITY_ROLE);
		createEAttribute(j2EESecurityRoleEClass, J2EE_SECURITY_ROLE__ROLE);

		j2EEServerEClass = createEClass(J2EE_SERVER);

		j2EEServerUnitEClass = createEClass(J2EE_SERVER_UNIT);

		jarModuleEClass = createEClass(JAR_MODULE);

		jarModuleCapabilityEClass = createEClass(JAR_MODULE_CAPABILITY);

		javaInterfaceEClass = createEClass(JAVA_INTERFACE);
		createEAttribute(javaInterfaceEClass, JAVA_INTERFACE__INTERFACE);

		jcaContainerEClass = createEClass(JCA_CONTAINER);
		createEAttribute(jcaContainerEClass, JCA_CONTAINER__CONTAINER_VERSION);

		jcaModuleEClass = createEClass(JCA_MODULE);

		jcaModuleCapabilityEClass = createEClass(JCA_MODULE_CAPABILITY);

		jspContainerEClass = createEClass(JSP_CONTAINER);
		createEAttribute(jspContainerEClass, JSP_CONTAINER__CONTAINER_VERSION);

		servletContainerEClass = createEClass(SERVLET_CONTAINER);
		createEAttribute(servletContainerEClass, SERVLET_CONTAINER__CONTAINER_VERSION);

		sessionServiceEClass = createEClass(SESSION_SERVICE);

		urlInterfaceEClass = createEClass(URL_INTERFACE);
		createEAttribute(urlInterfaceEClass, URL_INTERFACE__PARAM_NAME);

		urlServiceEClass = createEClass(URL_SERVICE);
		createEAttribute(urlServiceEClass, URL_SERVICE__URL_PATTERN);

		webModuleEClass = createEClass(WEB_MODULE);

		webModuleCapabilityEClass = createEClass(WEB_MODULE_CAPABILITY);
		createEAttribute(webModuleCapabilityEClass, WEB_MODULE_CAPABILITY__CONTEXT_ROOT);

		webServiceEClass = createEClass(WEB_SERVICE);
		createEAttribute(webServiceEClass, WEB_SERVICE__ENDPOINT);

		wsdlInterfaceEClass = createEClass(WSDL_INTERFACE);
		createEAttribute(wsdlInterfaceEClass, WSDL_INTERFACE__TYPE_URI);

		// Create enums
		ejbContainerVersionEEnum = createEEnum(EJB_CONTAINER_VERSION);
		j2EEContainerVersionEEnum = createEEnum(J2EE_CONTAINER_VERSION);
		jcaContainerVersionEEnum = createEEnum(JCA_CONTAINER_VERSION);
		jspContainerVersionEEnum = createEEnum(JSP_CONTAINER_VERSION);
		servletContainerVersionEEnum = createEEnum(SERVLET_CONTAINER_VERSION);
		vicinityEEnum = createEEnum(VICINITY);

		// Create data types
		ejbContainerVersionObjectEDataType = createEDataType(EJB_CONTAINER_VERSION_OBJECT);
		j2EEContainerVersionObjectEDataType = createEDataType(J2EE_CONTAINER_VERSION_OBJECT);
		jcaContainerVersionObjectEDataType = createEDataType(JCA_CONTAINER_VERSION_OBJECT);
		jspContainerVersionObjectEDataType = createEDataType(JSP_CONTAINER_VERSION_OBJECT);
		servletContainerVersionObjectEDataType = createEDataType(SERVLET_CONTAINER_VERSION_OBJECT);
		vicinityObjectEDataType = createEDataType(VICINITY_OBJECT);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	private boolean isInitialized = false;

	/**
	 * Complete the initialization of the package and its meta-model.  This
	 * method is guarded to have no affect on any invocation but its first.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public void initializePackageContents() {
		if (isInitialized)
			return;
		isInitialized = true;

		// Initialize package
		setName(eNAME);
		setNsPrefix(eNS_PREFIX);
		setNsURI(eNS_URI);

		// Obtain other dependent packages
		CorePackage theCorePackage = (CorePackage) EPackage.Registry.INSTANCE
				.getEPackage(CorePackage.eNS_URI);
		XMLTypePackage theXMLTypePackage = (XMLTypePackage) EPackage.Registry.INSTANCE
				.getEPackage(XMLTypePackage.eNS_URI);

		// Add supertypes to classes
		appClientEClass.getESuperTypes().add(theCorePackage.getUnit());
		appClientModuleEClass.getESuperTypes().add(this.getJ2EEModuleCapability());
		earModuleEClass.getESuperTypes().add(theCorePackage.getSoftwareComponent());
		earModuleCapabilityEClass.getESuperTypes().add(this.getJ2EEModuleCapability());
		ejbEClass.getESuperTypes().add(theCorePackage.getCapability());
		ejbContainerEClass.getESuperTypes().add(theCorePackage.getCapability());
		ejbModuleEClass.getESuperTypes().add(theCorePackage.getSoftwareComponent());
		ejbModuleCapabilityEClass.getESuperTypes().add(this.getJ2EEModuleCapability());
		enterpriseBeanServiceEClass.getESuperTypes().add(theCorePackage.getService());
		entityServiceEClass.getESuperTypes().add(this.getEnterpriseBeanService());
		genericJ2eeServerEClass.getESuperTypes().add(this.getGenericWebServer());
		genericWebServerEClass.getESuperTypes().add(theCorePackage.getUnit());
		j2CAuthenticationDataEntryEClass.getESuperTypes().add(theCorePackage.getCapability());
		j2CAuthenticationUnitEClass.getESuperTypes().add(theCorePackage.getUnit());
		j2EEContainerEClass.getESuperTypes().add(theCorePackage.getCapability());
		j2EEDatasourceEClass.getESuperTypes().add(theCorePackage.getCapability());
		j2EEModuleCapabilityEClass.getESuperTypes().add(theCorePackage.getBundleCapability());
		j2EEResourceEnvironmentRequirementEClass.getESuperTypes().add(theCorePackage.getCapability());
		j2EEResourceRequirementEClass.getESuperTypes().add(theCorePackage.getCapability());
		j2EESecurityRoleEClass.getESuperTypes().add(theCorePackage.getCapability());
		j2EEServerEClass.getESuperTypes().add(theCorePackage.getCapability());
		j2EEServerUnitEClass.getESuperTypes().add(theCorePackage.getUnit());
		jarModuleEClass.getESuperTypes().add(theCorePackage.getSoftwareComponent());
		jarModuleCapabilityEClass.getESuperTypes().add(this.getJ2EEModuleCapability());
		javaInterfaceEClass.getESuperTypes().add(theCorePackage.getInterface());
		jcaContainerEClass.getESuperTypes().add(theCorePackage.getCapability());
		jcaModuleEClass.getESuperTypes().add(theCorePackage.getUnit());
		jcaModuleCapabilityEClass.getESuperTypes().add(this.getJ2EEModuleCapability());
		jspContainerEClass.getESuperTypes().add(theCorePackage.getCapability());
		servletContainerEClass.getESuperTypes().add(theCorePackage.getCapability());
		sessionServiceEClass.getESuperTypes().add(this.getEnterpriseBeanService());
		urlInterfaceEClass.getESuperTypes().add(theCorePackage.getInterface());
		urlServiceEClass.getESuperTypes().add(theCorePackage.getService());
		webModuleEClass.getESuperTypes().add(theCorePackage.getSoftwareComponent());
		webModuleCapabilityEClass.getESuperTypes().add(this.getJ2EEModuleCapability());
		webServiceEClass.getESuperTypes().add(theCorePackage.getService());
		wsdlInterfaceEClass.getESuperTypes().add(theCorePackage.getInterface());

		// Initialize classes and features; add operations and parameters
		initEClass(appClientEClass, AppClient.class,
				"AppClient", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$

		initEClass(appClientModuleEClass, AppClientModule.class,
				"AppClientModule", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$

		initEClass(earModuleEClass, EarModule.class,
				"EarModule", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$

		initEClass(earModuleCapabilityEClass, EARModuleCapability.class,
				"EARModuleCapability", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$

		initEClass(ejbEClass, com.ibm.ccl.soa.deploy.j2ee.EJB.class,
				"EJB", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$
		initEAttribute(
				getEJB_Interface(),
				theXMLTypePackage.getString(),
				"interface", null, 1, 1, com.ibm.ccl.soa.deploy.j2ee.EJB.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$

		initEClass(ejbContainerEClass, EJBContainer.class,
				"EJBContainer", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$
		initEAttribute(
				getEJBContainer_ContainerVersion(),
				this.getEJBContainerVersion(),
				"containerVersion", "1.1", 1, 1, EJBContainer.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$ //$NON-NLS-2$

		initEClass(ejbModuleEClass, EjbModule.class,
				"EjbModule", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$

		initEClass(ejbModuleCapabilityEClass, EJBModuleCapability.class,
				"EJBModuleCapability", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$

		initEClass(enterpriseBeanServiceEClass, EnterpriseBeanService.class,
				"EnterpriseBeanService", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$
		initEReference(
				getEnterpriseBeanService_HomeInterface(),
				this.getJavaInterface(),
				null,
				"homeInterface", null, 0, 1, EnterpriseBeanService.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEAttribute(
				getEnterpriseBeanService_EjbName(),
				theXMLTypePackage.getString(),
				"ejbName", null, 0, 1, EnterpriseBeanService.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEAttribute(
				getEnterpriseBeanService_JndiName(),
				theXMLTypePackage.getString(),
				"jndiName", null, 0, 1, EnterpriseBeanService.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEAttribute(
				getEnterpriseBeanService_Vicinity(),
				this.getVicinity(),
				"vicinity", "local", 0, 1, EnterpriseBeanService.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$ //$NON-NLS-2$

		initEClass(entityServiceEClass, EntityService.class,
				"EntityService", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$
		initEAttribute(
				getEntityService_Managed(),
				theXMLTypePackage.getBoolean(),
				"managed", null, 1, 1, EntityService.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$

		initEClass(genericJ2eeServerEClass, GenericJ2eeServer.class,
				"GenericJ2eeServer", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$

		initEClass(genericWebServerEClass, GenericWebServer.class,
				"GenericWebServer", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$

		initEClass(j2CAuthenticationDataEntryEClass, J2CAuthenticationDataEntry.class,
				"J2CAuthenticationDataEntry", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$
		initEAttribute(
				getJ2CAuthenticationDataEntry_Alias(),
				theXMLTypePackage.getString(),
				"alias", null, 1, 1, J2CAuthenticationDataEntry.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEAttribute(
				getJ2CAuthenticationDataEntry_Password(),
				theXMLTypePackage.getString(),
				"password", null, 0, 1, J2CAuthenticationDataEntry.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEAttribute(
				getJ2CAuthenticationDataEntry_UserId(),
				theXMLTypePackage.getString(),
				"userId", null, 0, 1, J2CAuthenticationDataEntry.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$

		initEClass(j2CAuthenticationUnitEClass, J2CAuthenticationUnit.class,
				"J2CAuthenticationUnit", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$

		initEClass(j2EEContainerEClass, J2EEContainer.class,
				"J2EEContainer", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$
		initEAttribute(
				getJ2EEContainer_ContainerVersion(),
				this.getJ2EEContainerVersion(),
				"containerVersion", "1.2", 0, 1, J2EEContainer.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$ //$NON-NLS-2$

		initEClass(j2EEDatasourceEClass, J2EEDatasource.class,
				"J2EEDatasource", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$
		initEAttribute(
				getJ2EEDatasource_DatasourceName(),
				theXMLTypePackage.getString(),
				"datasourceName", null, 1, 1, J2EEDatasource.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEAttribute(
				getJ2EEDatasource_DbName(),
				theXMLTypePackage.getString(),
				"dbName", null, 0, 1, J2EEDatasource.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEAttribute(
				getJ2EEDatasource_Hostname(),
				theXMLTypePackage.getString(),
				"hostname", null, 0, 1, J2EEDatasource.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEAttribute(
				getJ2EEDatasource_JndiName(),
				theXMLTypePackage.getString(),
				"jndiName", null, 1, 1, J2EEDatasource.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEAttribute(
				getJ2EEDatasource_Password(),
				theXMLTypePackage.getString(),
				"password", null, 0, 1, J2EEDatasource.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEAttribute(
				getJ2EEDatasource_Port(),
				theXMLTypePackage.getInteger(),
				"port", null, 0, 1, J2EEDatasource.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEAttribute(
				getJ2EEDatasource_UsedForCmp(),
				theXMLTypePackage.getBoolean(),
				"usedForCmp", null, 0, 1, J2EEDatasource.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEAttribute(
				getJ2EEDatasource_Username(),
				theXMLTypePackage.getString(),
				"username", null, 0, 1, J2EEDatasource.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$

		initEClass(j2EEDeployRootEClass, J2EEDeployRoot.class,
				"J2EEDeployRoot", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$
		initEAttribute(
				getJ2EEDeployRoot_Mixed(),
				ecorePackage.getEFeatureMapEntry(),
				"mixed", null, 0, -1, null, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEReference(
				getJ2EEDeployRoot_XMLNSPrefixMap(),
				ecorePackage.getEStringToStringMapEntry(),
				null,
				"xMLNSPrefixMap", null, 0, -1, null, IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEReference(
				getJ2EEDeployRoot_XSISchemaLocation(),
				ecorePackage.getEStringToStringMapEntry(),
				null,
				"xSISchemaLocation", null, 0, -1, null, IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEReference(
				getJ2EEDeployRoot_CapabilityAppClientModule(),
				this.getAppClientModule(),
				null,
				"capabilityAppClientModule", null, 0, -2, null, IS_TRANSIENT, IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEReference(
				getJ2EEDeployRoot_CapabilityEarModule(),
				this.getEARModuleCapability(),
				null,
				"capabilityEarModule", null, 0, -2, null, IS_TRANSIENT, IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEReference(
				getJ2EEDeployRoot_CapabilityEjb(),
				this.getEJB(),
				null,
				"capabilityEjb", null, 0, -2, null, IS_TRANSIENT, IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEReference(
				getJ2EEDeployRoot_CapabilityEjbContainer(),
				this.getEJBContainer(),
				null,
				"capabilityEjbContainer", null, 0, -2, null, IS_TRANSIENT, IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEReference(
				getJ2EEDeployRoot_CapabilityEjbModule(),
				this.getEJBModuleCapability(),
				null,
				"capabilityEjbModule", null, 0, -2, null, IS_TRANSIENT, IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEReference(
				getJ2EEDeployRoot_CapabilityJ2eeContainer(),
				this.getJ2EEContainer(),
				null,
				"capabilityJ2eeContainer", null, 0, -2, null, IS_TRANSIENT, IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEReference(
				getJ2EEDeployRoot_CapabilityJ2eeDatasource(),
				this.getJ2EEDatasource(),
				null,
				"capabilityJ2eeDatasource", null, 0, -2, null, IS_TRANSIENT, IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEReference(
				getJ2EEDeployRoot_CapabilityJ2eeModule(),
				this.getJ2EEModuleCapability(),
				null,
				"capabilityJ2eeModule", null, 0, -2, null, IS_TRANSIENT, IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEReference(
				getJ2EEDeployRoot_CapabilityJ2eeResourceEnvironmentRequirement(),
				this.getJ2EEResourceEnvironmentRequirement(),
				null,
				"capabilityJ2eeResourceEnvironmentRequirement", null, 0, -2, null, IS_TRANSIENT, IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEReference(
				getJ2EEDeployRoot_CapabilityJ2eeResourceRequirement(),
				this.getJ2EEResourceRequirement(),
				null,
				"capabilityJ2eeResourceRequirement", null, 0, -2, null, IS_TRANSIENT, IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEReference(
				getJ2EEDeployRoot_CapabilityJ2eeSecurityRole(),
				this.getJ2EESecurityRole(),
				null,
				"capabilityJ2eeSecurityRole", null, 0, -2, null, IS_TRANSIENT, IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEReference(
				getJ2EEDeployRoot_CapabilityJ2eeServer(),
				this.getJ2EEServer(),
				null,
				"capabilityJ2eeServer", null, 0, -2, null, IS_TRANSIENT, IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEReference(
				getJ2EEDeployRoot_CapabilityJarModule(),
				this.getJarModuleCapability(),
				null,
				"capabilityJarModule", null, 0, -2, null, IS_TRANSIENT, IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEReference(
				getJ2EEDeployRoot_CapabilityJcaContainer(),
				this.getJCAContainer(),
				null,
				"capabilityJcaContainer", null, 0, -2, null, IS_TRANSIENT, IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEReference(
				getJ2EEDeployRoot_CapabilityJcaModule(),
				this.getJCAModuleCapability(),
				null,
				"capabilityJcaModule", null, 0, -2, null, IS_TRANSIENT, IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEReference(
				getJ2EEDeployRoot_CapabilityJspContainer(),
				this.getJSPContainer(),
				null,
				"capabilityJspContainer", null, 0, -2, null, IS_TRANSIENT, IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEReference(
				getJ2EEDeployRoot_CapabilityServletContainer(),
				this.getServletContainer(),
				null,
				"capabilityServletContainer", null, 0, -2, null, IS_TRANSIENT, IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEReference(
				getJ2EEDeployRoot_CapabilityWebModule(),
				this.getWebModuleCapability(),
				null,
				"capabilityWebModule", null, 0, -2, null, IS_TRANSIENT, IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEReference(
				getJ2EEDeployRoot_ComponentEar(),
				this.getEarModule(),
				null,
				"componentEar", null, 0, -2, null, IS_TRANSIENT, IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEReference(
				getJ2EEDeployRoot_ComponentEjb(),
				this.getEjbModule(),
				null,
				"componentEjb", null, 0, -2, null, IS_TRANSIENT, IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEReference(
				getJ2EEDeployRoot_ComponentJar(),
				this.getJarModule(),
				null,
				"componentJar", null, 0, -2, null, IS_TRANSIENT, IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEReference(
				getJ2EEDeployRoot_ComponentWeb(),
				this.getWebModule(),
				null,
				"componentWeb", null, 0, -2, null, IS_TRANSIENT, IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEReference(
				getJ2EEDeployRoot_InterfaceJava(),
				this.getJavaInterface(),
				null,
				"interfaceJava", null, 0, -2, null, IS_TRANSIENT, IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEReference(
				getJ2EEDeployRoot_InterfaceUrl(),
				this.getURLInterface(),
				null,
				"interfaceUrl", null, 0, -2, null, IS_TRANSIENT, IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEReference(
				getJ2EEDeployRoot_InterfaceWsdl(),
				this.getWSDLInterface(),
				null,
				"interfaceWsdl", null, 0, -2, null, IS_TRANSIENT, IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEReference(
				getJ2EEDeployRoot_ServiceEntity(),
				this.getEntityService(),
				null,
				"serviceEntity", null, 0, -2, null, IS_TRANSIENT, IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEReference(
				getJ2EEDeployRoot_ServiceServlet(),
				this.getURLService(),
				null,
				"serviceServlet", null, 0, -2, null, IS_TRANSIENT, IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEReference(
				getJ2EEDeployRoot_ServiceSession(),
				this.getSessionService(),
				null,
				"serviceSession", null, 0, -2, null, IS_TRANSIENT, IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEReference(
				getJ2EEDeployRoot_ServiceWs(),
				this.getWebService(),
				null,
				"serviceWs", null, 0, -2, null, IS_TRANSIENT, IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEReference(
				getJ2EEDeployRoot_UnitAppClient(),
				this.getAppClient(),
				null,
				"unitAppClient", null, 0, -2, null, IS_TRANSIENT, IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEReference(
				getJ2EEDeployRoot_UnitJ2eeServer(),
				this.getGenericJ2eeServer(),
				null,
				"unitJ2eeServer", null, 0, -2, null, IS_TRANSIENT, IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEReference(
				getJ2EEDeployRoot_UnitJ2eeServerUnit(),
				this.getJ2EEServerUnit(),
				null,
				"unitJ2eeServerUnit", null, 0, -2, null, IS_TRANSIENT, IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEReference(
				getJ2EEDeployRoot_UnitJcaModule(),
				this.getJCAModule(),
				null,
				"unitJcaModule", null, 0, -2, null, IS_TRANSIENT, IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEReference(
				getJ2EEDeployRoot_UnitWebServer(),
				this.getGenericWebServer(),
				null,
				"unitWebServer", null, 0, -2, null, IS_TRANSIENT, IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, IS_DERIVED, IS_ORDERED); //$NON-NLS-1$

		initEClass(j2EEModuleCapabilityEClass, J2EEModuleCapability.class,
				"J2EEModuleCapability", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$
		initEAttribute(
				getJ2EEModuleCapability_ModuleName(),
				theXMLTypePackage.getString(),
				"moduleName", null, 1, 1, J2EEModuleCapability.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$

		initEClass(
				j2EEResourceEnvironmentRequirementEClass,
				J2EEResourceEnvironmentRequirement.class,
				"J2EEResourceEnvironmentRequirement", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$
		initEAttribute(
				getJ2EEResourceEnvironmentRequirement_JndiName(),
				theXMLTypePackage.getString(),
				"jndiName", null, 1, 1, J2EEResourceEnvironmentRequirement.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEAttribute(
				getJ2EEResourceEnvironmentRequirement_Type(),
				theXMLTypePackage.getString(),
				"type", null, 1, 1, J2EEResourceEnvironmentRequirement.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$

		initEClass(j2EEResourceRequirementEClass, J2EEResourceRequirement.class,
				"J2EEResourceRequirement", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$
		initEAttribute(
				getJ2EEResourceRequirement_JndiName(),
				theXMLTypePackage.getString(),
				"jndiName", null, 1, 1, J2EEResourceRequirement.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEAttribute(
				getJ2EEResourceRequirement_Type(),
				theXMLTypePackage.getString(),
				"type", null, 1, 1, J2EEResourceRequirement.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$

		initEClass(j2EESecurityRoleEClass, J2EESecurityRole.class,
				"J2EESecurityRole", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$
		initEAttribute(
				getJ2EESecurityRole_Role(),
				theXMLTypePackage.getString(),
				"role", null, 1, 1, J2EESecurityRole.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$

		initEClass(j2EEServerEClass, J2EEServer.class,
				"J2EEServer", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$

		initEClass(j2EEServerUnitEClass, J2EEServerUnit.class,
				"J2EEServerUnit", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$

		initEClass(jarModuleEClass, JarModule.class,
				"JarModule", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$

		initEClass(jarModuleCapabilityEClass, JarModuleCapability.class,
				"JarModuleCapability", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$

		initEClass(javaInterfaceEClass, JavaInterface.class,
				"JavaInterface", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$
		initEAttribute(
				getJavaInterface_Interface(),
				theXMLTypePackage.getString(),
				"interface", null, 0, 1, JavaInterface.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$

		initEClass(jcaContainerEClass, JCAContainer.class,
				"JCAContainer", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$
		initEAttribute(
				getJCAContainer_ContainerVersion(),
				this.getJCAContainerVersion(),
				"containerVersion", "1.0", 1, 1, JCAContainer.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$ //$NON-NLS-2$

		initEClass(jcaModuleEClass, JCAModule.class,
				"JCAModule", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$

		initEClass(jcaModuleCapabilityEClass, JCAModuleCapability.class,
				"JCAModuleCapability", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$

		initEClass(jspContainerEClass, JSPContainer.class,
				"JSPContainer", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$
		initEAttribute(
				getJSPContainer_ContainerVersion(),
				this.getJSPContainerVersion(),
				"containerVersion", "1.1", 1, 1, JSPContainer.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$ //$NON-NLS-2$

		initEClass(servletContainerEClass, ServletContainer.class,
				"ServletContainer", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$
		initEAttribute(
				getServletContainer_ContainerVersion(),
				this.getServletContainerVersion(),
				"containerVersion", "2.2", 1, 1, ServletContainer.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$ //$NON-NLS-2$

		initEClass(sessionServiceEClass, SessionService.class,
				"SessionService", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$

		initEClass(urlInterfaceEClass, URLInterface.class,
				"URLInterface", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$
		initEAttribute(
				getURLInterface_ParamName(),
				theXMLTypePackage.getString(),
				"paramName", null, 0, -1, URLInterface.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$

		initEClass(urlServiceEClass, URLService.class,
				"URLService", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$
		initEAttribute(
				getURLService_UrlPattern(),
				theXMLTypePackage.getString(),
				"urlPattern", null, 0, -1, URLService.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$

		initEClass(webModuleEClass, WebModule.class,
				"WebModule", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$

		initEClass(webModuleCapabilityEClass, WebModuleCapability.class,
				"WebModuleCapability", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$
		initEAttribute(
				getWebModuleCapability_ContextRoot(),
				theXMLTypePackage.getString(),
				"contextRoot", null, 1, 1, WebModuleCapability.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$

		initEClass(webServiceEClass, WebService.class,
				"WebService", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$
		initEAttribute(
				getWebService_Endpoint(),
				theXMLTypePackage.getAnyURI(),
				"endpoint", null, 0, 1, WebService.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$

		initEClass(wsdlInterfaceEClass, WSDLInterface.class,
				"WSDLInterface", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$
		initEAttribute(
				getWSDLInterface_TypeUri(),
				theXMLTypePackage.getAnyURI(),
				"typeUri", null, 0, 1, WSDLInterface.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$

		// Initialize enums and add enum literals
		initEEnum(ejbContainerVersionEEnum, EJBContainerVersion.class, "EJBContainerVersion"); //$NON-NLS-1$
		addEEnumLiteral(ejbContainerVersionEEnum, EJBContainerVersion._11_LITERAL);
		addEEnumLiteral(ejbContainerVersionEEnum, EJBContainerVersion._20_LITERAL);
		addEEnumLiteral(ejbContainerVersionEEnum, EJBContainerVersion._21_LITERAL);
		addEEnumLiteral(ejbContainerVersionEEnum, EJBContainerVersion._30_LITERAL);

		initEEnum(j2EEContainerVersionEEnum, J2EEContainerVersion.class, "J2EEContainerVersion"); //$NON-NLS-1$
		addEEnumLiteral(j2EEContainerVersionEEnum, J2EEContainerVersion._12_LITERAL);
		addEEnumLiteral(j2EEContainerVersionEEnum, J2EEContainerVersion._13_LITERAL);
		addEEnumLiteral(j2EEContainerVersionEEnum, J2EEContainerVersion._14_LITERAL);
		addEEnumLiteral(j2EEContainerVersionEEnum, J2EEContainerVersion._50_LITERAL);

		initEEnum(jcaContainerVersionEEnum, JCAContainerVersion.class, "JCAContainerVersion"); //$NON-NLS-1$
		addEEnumLiteral(jcaContainerVersionEEnum, JCAContainerVersion._10_LITERAL);
		addEEnumLiteral(jcaContainerVersionEEnum, JCAContainerVersion._15_LITERAL);

		initEEnum(jspContainerVersionEEnum, JSPContainerVersion.class, "JSPContainerVersion"); //$NON-NLS-1$
		addEEnumLiteral(jspContainerVersionEEnum, JSPContainerVersion._11_LITERAL);
		addEEnumLiteral(jspContainerVersionEEnum, JSPContainerVersion._12_LITERAL);
		addEEnumLiteral(jspContainerVersionEEnum, JSPContainerVersion._20_LITERAL);
		addEEnumLiteral(jspContainerVersionEEnum, JSPContainerVersion._21_LITERAL);

		initEEnum(servletContainerVersionEEnum, ServletContainerVersion.class,
				"ServletContainerVersion"); //$NON-NLS-1$
		addEEnumLiteral(servletContainerVersionEEnum, ServletContainerVersion._22_LITERAL);
		addEEnumLiteral(servletContainerVersionEEnum, ServletContainerVersion._23_LITERAL);
		addEEnumLiteral(servletContainerVersionEEnum, ServletContainerVersion._24_LITERAL);
		addEEnumLiteral(servletContainerVersionEEnum, ServletContainerVersion._25_LITERAL);

		initEEnum(vicinityEEnum, Vicinity.class, "Vicinity"); //$NON-NLS-1$
		addEEnumLiteral(vicinityEEnum, Vicinity.LOCAL_LITERAL);
		addEEnumLiteral(vicinityEEnum, Vicinity.REMOTE_LITERAL);

		// Initialize data types
		initEDataType(ejbContainerVersionObjectEDataType, EJBContainerVersion.class,
				"EJBContainerVersionObject", IS_SERIALIZABLE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$
		initEDataType(j2EEContainerVersionObjectEDataType, J2EEContainerVersion.class,
				"J2EEContainerVersionObject", IS_SERIALIZABLE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$
		initEDataType(jcaContainerVersionObjectEDataType, JCAContainerVersion.class,
				"JCAContainerVersionObject", IS_SERIALIZABLE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$
		initEDataType(jspContainerVersionObjectEDataType, JSPContainerVersion.class,
				"JSPContainerVersionObject", IS_SERIALIZABLE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$
		initEDataType(servletContainerVersionObjectEDataType, ServletContainerVersion.class,
				"ServletContainerVersionObject", IS_SERIALIZABLE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$
		initEDataType(vicinityObjectEDataType, Vicinity.class,
				"VicinityObject", IS_SERIALIZABLE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$

		// Create resource
		createResource(eNS_URI);

		// Create annotations
		// http:///org/eclipse/emf/ecore/util/ExtendedMetaData
		createExtendedMetaDataAnnotations();
	}

	/**
	 * Initializes the annotations for <b>http:///org/eclipse/emf/ecore/util/ExtendedMetaData</b>.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	protected void createExtendedMetaDataAnnotations() {
		String source = "http:///org/eclipse/emf/ecore/util/ExtendedMetaData"; //$NON-NLS-1$			
		addAnnotation(appClientEClass, source, new String[] { "name", "AppClient", //$NON-NLS-1$ //$NON-NLS-2$
				"kind", "elementOnly" //$NON-NLS-1$ //$NON-NLS-2$
		});
		addAnnotation(appClientModuleEClass, source, new String[] { "name", "AppClientModule", //$NON-NLS-1$ //$NON-NLS-2$
				"kind", "elementOnly" //$NON-NLS-1$ //$NON-NLS-2$
		});
		addAnnotation(earModuleEClass, source, new String[] { "name", "EarModule", //$NON-NLS-1$ //$NON-NLS-2$
				"kind", "elementOnly" //$NON-NLS-1$ //$NON-NLS-2$
		});
		addAnnotation(earModuleCapabilityEClass, source, new String[] {
				"name", "EARModuleCapability", //$NON-NLS-1$ //$NON-NLS-2$
				"kind", "elementOnly" //$NON-NLS-1$ //$NON-NLS-2$
		});
		addAnnotation(ejbEClass, source, new String[] { "name", "EJB", //$NON-NLS-1$ //$NON-NLS-2$
				"kind", "elementOnly" //$NON-NLS-1$ //$NON-NLS-2$
		});
		addAnnotation(getEJB_Interface(), source, new String[] { "kind", "attribute", //$NON-NLS-1$ //$NON-NLS-2$
				"name", "interface" //$NON-NLS-1$ //$NON-NLS-2$
		});
		addAnnotation(ejbContainerEClass, source, new String[] { "name", "EJBContainer", //$NON-NLS-1$ //$NON-NLS-2$
				"kind", "elementOnly" //$NON-NLS-1$ //$NON-NLS-2$
		});
		addAnnotation(getEJBContainer_ContainerVersion(), source, new String[] { "kind", "attribute", //$NON-NLS-1$ //$NON-NLS-2$
				"name", "containerVersion" //$NON-NLS-1$ //$NON-NLS-2$
		});
		addAnnotation(ejbContainerVersionEEnum, source, new String[] { "name", "EJBContainerVersion" //$NON-NLS-1$ //$NON-NLS-2$
		});
		addAnnotation(ejbContainerVersionObjectEDataType, source, new String[] {
				"name", "EJBContainerVersion:Object", //$NON-NLS-1$ //$NON-NLS-2$
				"baseType", "EJBContainerVersion" //$NON-NLS-1$ //$NON-NLS-2$
		});
		addAnnotation(ejbModuleEClass, source, new String[] { "name", "EjbModule", //$NON-NLS-1$ //$NON-NLS-2$
				"kind", "elementOnly" //$NON-NLS-1$ //$NON-NLS-2$
		});
		addAnnotation(ejbModuleCapabilityEClass, source, new String[] {
				"name", "EJBModuleCapability", //$NON-NLS-1$ //$NON-NLS-2$
				"kind", "elementOnly" //$NON-NLS-1$ //$NON-NLS-2$
		});
		addAnnotation(enterpriseBeanServiceEClass, source, new String[] {
				"name", "EnterpriseBeanService", //$NON-NLS-1$ //$NON-NLS-2$
				"kind", "elementOnly" //$NON-NLS-1$ //$NON-NLS-2$
		});
		addAnnotation(getEnterpriseBeanService_HomeInterface(), source, new String[] {
				"kind", "element", //$NON-NLS-1$ //$NON-NLS-2$
				"name", "homeInterface", //$NON-NLS-1$ //$NON-NLS-2$
				"namespace", "##targetNamespace" //$NON-NLS-1$ //$NON-NLS-2$
		});
		addAnnotation(getEnterpriseBeanService_EjbName(), source, new String[] { "kind", "attribute", //$NON-NLS-1$ //$NON-NLS-2$
				"name", "ejbName" //$NON-NLS-1$ //$NON-NLS-2$
		});
		addAnnotation(getEnterpriseBeanService_JndiName(), source, new String[] {
				"kind", "attribute", //$NON-NLS-1$ //$NON-NLS-2$
				"name", "jndiName" //$NON-NLS-1$ //$NON-NLS-2$
		});
		addAnnotation(getEnterpriseBeanService_Vicinity(), source, new String[] {
				"kind", "attribute", //$NON-NLS-1$ //$NON-NLS-2$
				"name", "vicinity" //$NON-NLS-1$ //$NON-NLS-2$
		});
		addAnnotation(entityServiceEClass, source, new String[] { "name", "EntityService", //$NON-NLS-1$ //$NON-NLS-2$
				"kind", "elementOnly" //$NON-NLS-1$ //$NON-NLS-2$
		});
		addAnnotation(getEntityService_Managed(), source, new String[] { "kind", "attribute", //$NON-NLS-1$ //$NON-NLS-2$
				"name", "managed" //$NON-NLS-1$ //$NON-NLS-2$
		});
		addAnnotation(genericJ2eeServerEClass, source, new String[] { "name", "GenericJ2eeServer", //$NON-NLS-1$ //$NON-NLS-2$
				"kind", "elementOnly" //$NON-NLS-1$ //$NON-NLS-2$
		});
		addAnnotation(genericWebServerEClass, source, new String[] { "name", "GenericWebServer", //$NON-NLS-1$ //$NON-NLS-2$
				"kind", "elementOnly" //$NON-NLS-1$ //$NON-NLS-2$
		});
		addAnnotation(j2CAuthenticationDataEntryEClass, source, new String[] {
				"name", "J2CAuthenticationDataEntry", //$NON-NLS-1$ //$NON-NLS-2$
				"kind", "elementOnly" //$NON-NLS-1$ //$NON-NLS-2$
		});
		addAnnotation(getJ2CAuthenticationDataEntry_Alias(), source, new String[] {
				"kind", "attribute", //$NON-NLS-1$ //$NON-NLS-2$
				"name", "alias" //$NON-NLS-1$ //$NON-NLS-2$
		});
		addAnnotation(getJ2CAuthenticationDataEntry_Password(), source, new String[] {
				"kind", "attribute", //$NON-NLS-1$ //$NON-NLS-2$
				"name", "password" //$NON-NLS-1$ //$NON-NLS-2$
		});
		addAnnotation(getJ2CAuthenticationDataEntry_UserId(), source, new String[] {
				"kind", "attribute", //$NON-NLS-1$ //$NON-NLS-2$
				"name", "userId" //$NON-NLS-1$ //$NON-NLS-2$
		});
		addAnnotation(j2CAuthenticationUnitEClass, source, new String[] {
				"name", "J2CAuthenticationUnit", //$NON-NLS-1$ //$NON-NLS-2$
				"kind", "elementOnly" //$NON-NLS-1$ //$NON-NLS-2$
		});
		addAnnotation(j2EEContainerEClass, source, new String[] { "name", "J2EEContainer", //$NON-NLS-1$ //$NON-NLS-2$
				"kind", "elementOnly" //$NON-NLS-1$ //$NON-NLS-2$
		});
		addAnnotation(getJ2EEContainer_ContainerVersion(), source, new String[] {
				"kind", "attribute", //$NON-NLS-1$ //$NON-NLS-2$
				"name", "containerVersion" //$NON-NLS-1$ //$NON-NLS-2$
		});
		addAnnotation(j2EEContainerVersionEEnum, source, new String[] {
				"name", "J2EEContainerVersion" //$NON-NLS-1$ //$NON-NLS-2$
		});
		addAnnotation(j2EEContainerVersionObjectEDataType, source, new String[] {
				"name", "J2EEContainerVersion:Object", //$NON-NLS-1$ //$NON-NLS-2$
				"baseType", "J2EEContainerVersion" //$NON-NLS-1$ //$NON-NLS-2$
		});
		addAnnotation(j2EEDatasourceEClass, source, new String[] { "name", "J2EEDatasource", //$NON-NLS-1$ //$NON-NLS-2$
				"kind", "elementOnly" //$NON-NLS-1$ //$NON-NLS-2$
		});
		addAnnotation(getJ2EEDatasource_DatasourceName(), source, new String[] { "kind", "attribute", //$NON-NLS-1$ //$NON-NLS-2$
				"name", "datasourceName" //$NON-NLS-1$ //$NON-NLS-2$
		});
		addAnnotation(getJ2EEDatasource_DbName(), source, new String[] { "kind", "attribute", //$NON-NLS-1$ //$NON-NLS-2$
				"name", "dbName" //$NON-NLS-1$ //$NON-NLS-2$
		});
		addAnnotation(getJ2EEDatasource_Hostname(), source, new String[] { "kind", "attribute", //$NON-NLS-1$ //$NON-NLS-2$
				"name", "hostname" //$NON-NLS-1$ //$NON-NLS-2$
		});
		addAnnotation(getJ2EEDatasource_JndiName(), source, new String[] { "kind", "attribute", //$NON-NLS-1$ //$NON-NLS-2$
				"name", "jndiName" //$NON-NLS-1$ //$NON-NLS-2$
		});
		addAnnotation(getJ2EEDatasource_Password(), source, new String[] { "kind", "attribute", //$NON-NLS-1$ //$NON-NLS-2$
				"name", "password" //$NON-NLS-1$ //$NON-NLS-2$
		});
		addAnnotation(getJ2EEDatasource_Port(), source, new String[] { "kind", "attribute", //$NON-NLS-1$ //$NON-NLS-2$
				"name", "port" //$NON-NLS-1$ //$NON-NLS-2$
		});
		addAnnotation(getJ2EEDatasource_UsedForCmp(), source, new String[] { "kind", "attribute", //$NON-NLS-1$ //$NON-NLS-2$
				"name", "usedForCmp" //$NON-NLS-1$ //$NON-NLS-2$
		});
		addAnnotation(getJ2EEDatasource_Username(), source, new String[] { "kind", "attribute", //$NON-NLS-1$ //$NON-NLS-2$
				"name", "username" //$NON-NLS-1$ //$NON-NLS-2$
		});
		addAnnotation(j2EEDeployRootEClass, source, new String[] { "name", "", //$NON-NLS-1$ //$NON-NLS-2$
				"kind", "mixed" //$NON-NLS-1$ //$NON-NLS-2$
		});
		addAnnotation(getJ2EEDeployRoot_Mixed(), source, new String[] { "kind", "elementWildcard", //$NON-NLS-1$ //$NON-NLS-2$
				"name", ":mixed" //$NON-NLS-1$ //$NON-NLS-2$
		});
		addAnnotation(getJ2EEDeployRoot_XMLNSPrefixMap(), source, new String[] { "kind", "attribute", //$NON-NLS-1$ //$NON-NLS-2$
				"name", "xmlns:prefix" //$NON-NLS-1$ //$NON-NLS-2$
		});
		addAnnotation(getJ2EEDeployRoot_XSISchemaLocation(), source, new String[] {
				"kind", "attribute", //$NON-NLS-1$ //$NON-NLS-2$
				"name", "xsi:schemaLocation" //$NON-NLS-1$ //$NON-NLS-2$
		});
		addAnnotation(getJ2EEDeployRoot_CapabilityAppClientModule(), source, new String[] {
				"kind", "element", //$NON-NLS-1$ //$NON-NLS-2$
				"name", "capability.appClientModule", //$NON-NLS-1$ //$NON-NLS-2$
				"namespace", "##targetNamespace", //$NON-NLS-1$ //$NON-NLS-2$
				"affiliation", "http://www.ibm.com/ccl/soa/deploy/core/1.0.0/#capability" //$NON-NLS-1$ //$NON-NLS-2$
		});
		addAnnotation(getJ2EEDeployRoot_CapabilityEarModule(), source, new String[] {
				"kind", "element", //$NON-NLS-1$ //$NON-NLS-2$
				"name", "capability.earModule", //$NON-NLS-1$ //$NON-NLS-2$
				"namespace", "##targetNamespace", //$NON-NLS-1$ //$NON-NLS-2$
				"affiliation", "http://www.ibm.com/ccl/soa/deploy/core/1.0.0/#capability" //$NON-NLS-1$ //$NON-NLS-2$
		});
		addAnnotation(getJ2EEDeployRoot_CapabilityEjb(), source, new String[] { "kind", "element", //$NON-NLS-1$ //$NON-NLS-2$
				"name", "capability.ejb", //$NON-NLS-1$ //$NON-NLS-2$
				"namespace", "##targetNamespace", //$NON-NLS-1$ //$NON-NLS-2$
				"affiliation", "http://www.ibm.com/ccl/soa/deploy/core/1.0.0/#capability" //$NON-NLS-1$ //$NON-NLS-2$
		});
		addAnnotation(getJ2EEDeployRoot_CapabilityEjbContainer(), source, new String[] {
				"kind", "element", //$NON-NLS-1$ //$NON-NLS-2$
				"name", "capability.ejbContainer", //$NON-NLS-1$ //$NON-NLS-2$
				"namespace", "##targetNamespace", //$NON-NLS-1$ //$NON-NLS-2$
				"affiliation", "http://www.ibm.com/ccl/soa/deploy/core/1.0.0/#capability" //$NON-NLS-1$ //$NON-NLS-2$
		});
		addAnnotation(getJ2EEDeployRoot_CapabilityEjbModule(), source, new String[] {
				"kind", "element", //$NON-NLS-1$ //$NON-NLS-2$
				"name", "capability.ejbModule", //$NON-NLS-1$ //$NON-NLS-2$
				"namespace", "##targetNamespace", //$NON-NLS-1$ //$NON-NLS-2$
				"affiliation", "http://www.ibm.com/ccl/soa/deploy/core/1.0.0/#capability" //$NON-NLS-1$ //$NON-NLS-2$
		});
		addAnnotation(getJ2EEDeployRoot_CapabilityJ2eeContainer(), source, new String[] {
				"kind", "element", //$NON-NLS-1$ //$NON-NLS-2$
				"name", "capability.j2eeContainer", //$NON-NLS-1$ //$NON-NLS-2$
				"namespace", "##targetNamespace", //$NON-NLS-1$ //$NON-NLS-2$
				"affiliation", "http://www.ibm.com/ccl/soa/deploy/core/1.0.0/#capability" //$NON-NLS-1$ //$NON-NLS-2$
		});
		addAnnotation(getJ2EEDeployRoot_CapabilityJ2eeDatasource(), source, new String[] {
				"kind", "element", //$NON-NLS-1$ //$NON-NLS-2$
				"name", "capability.j2eeDatasource", //$NON-NLS-1$ //$NON-NLS-2$
				"namespace", "##targetNamespace", //$NON-NLS-1$ //$NON-NLS-2$
				"affiliation", "http://www.ibm.com/ccl/soa/deploy/core/1.0.0/#capability" //$NON-NLS-1$ //$NON-NLS-2$
		});
		addAnnotation(getJ2EEDeployRoot_CapabilityJ2eeModule(), source, new String[] {
				"kind", "element", //$NON-NLS-1$ //$NON-NLS-2$
				"name", "capability.j2eeModule", //$NON-NLS-1$ //$NON-NLS-2$
				"namespace", "##targetNamespace", //$NON-NLS-1$ //$NON-NLS-2$
				"affiliation", "http://www.ibm.com/ccl/soa/deploy/core/1.0.0/#capability" //$NON-NLS-1$ //$NON-NLS-2$
		});
		addAnnotation(getJ2EEDeployRoot_CapabilityJ2eeResourceEnvironmentRequirement(), source,
				new String[] { "kind", "element", //$NON-NLS-1$ //$NON-NLS-2$
						"name", "capability.j2eeResourceEnvironmentRequirement", //$NON-NLS-1$ //$NON-NLS-2$
						"namespace", "##targetNamespace", //$NON-NLS-1$ //$NON-NLS-2$
						"affiliation", "http://www.ibm.com/ccl/soa/deploy/core/1.0.0/#capability" //$NON-NLS-1$ //$NON-NLS-2$
				});
		addAnnotation(getJ2EEDeployRoot_CapabilityJ2eeResourceRequirement(), source, new String[] {
				"kind", "element", //$NON-NLS-1$ //$NON-NLS-2$
				"name", "capability.j2eeResourceRequirement", //$NON-NLS-1$ //$NON-NLS-2$
				"namespace", "##targetNamespace", //$NON-NLS-1$ //$NON-NLS-2$
				"affiliation", "http://www.ibm.com/ccl/soa/deploy/core/1.0.0/#capability" //$NON-NLS-1$ //$NON-NLS-2$
		});
		addAnnotation(getJ2EEDeployRoot_CapabilityJ2eeSecurityRole(), source, new String[] {
				"kind", "element", //$NON-NLS-1$ //$NON-NLS-2$
				"name", "capability.j2eeSecurityRole", //$NON-NLS-1$ //$NON-NLS-2$
				"namespace", "##targetNamespace", //$NON-NLS-1$ //$NON-NLS-2$
				"affiliation", "http://www.ibm.com/ccl/soa/deploy/core/1.0.0/#capability" //$NON-NLS-1$ //$NON-NLS-2$
		});
		addAnnotation(getJ2EEDeployRoot_CapabilityJ2eeServer(), source, new String[] {
				"kind", "element", //$NON-NLS-1$ //$NON-NLS-2$
				"name", "capability.j2eeServer", //$NON-NLS-1$ //$NON-NLS-2$
				"namespace", "##targetNamespace", //$NON-NLS-1$ //$NON-NLS-2$
				"affiliation", "http://www.ibm.com/ccl/soa/deploy/core/1.0.0/#capability" //$NON-NLS-1$ //$NON-NLS-2$
		});
		addAnnotation(getJ2EEDeployRoot_CapabilityJarModule(), source, new String[] {
				"kind", "element", //$NON-NLS-1$ //$NON-NLS-2$
				"name", "capability.jarModule", //$NON-NLS-1$ //$NON-NLS-2$
				"namespace", "##targetNamespace", //$NON-NLS-1$ //$NON-NLS-2$
				"affiliation", "http://www.ibm.com/ccl/soa/deploy/core/1.0.0/#capability" //$NON-NLS-1$ //$NON-NLS-2$
		});
		addAnnotation(getJ2EEDeployRoot_CapabilityJcaContainer(), source, new String[] {
				"kind", "element", //$NON-NLS-1$ //$NON-NLS-2$
				"name", "capability.jcaContainer", //$NON-NLS-1$ //$NON-NLS-2$
				"namespace", "##targetNamespace", //$NON-NLS-1$ //$NON-NLS-2$
				"affiliation", "http://www.ibm.com/ccl/soa/deploy/core/1.0.0/#capability" //$NON-NLS-1$ //$NON-NLS-2$
		});
		addAnnotation(getJ2EEDeployRoot_CapabilityJcaModule(), source, new String[] {
				"kind", "element", //$NON-NLS-1$ //$NON-NLS-2$
				"name", "capability.jcaModule", //$NON-NLS-1$ //$NON-NLS-2$
				"namespace", "##targetNamespace", //$NON-NLS-1$ //$NON-NLS-2$
				"affiliation", "http://www.ibm.com/ccl/soa/deploy/core/1.0.0/#capability" //$NON-NLS-1$ //$NON-NLS-2$
		});
		addAnnotation(getJ2EEDeployRoot_CapabilityJspContainer(), source, new String[] {
				"kind", "element", //$NON-NLS-1$ //$NON-NLS-2$
				"name", "capability.jspContainer", //$NON-NLS-1$ //$NON-NLS-2$
				"namespace", "##targetNamespace", //$NON-NLS-1$ //$NON-NLS-2$
				"affiliation", "http://www.ibm.com/ccl/soa/deploy/core/1.0.0/#capability" //$NON-NLS-1$ //$NON-NLS-2$
		});
		addAnnotation(getJ2EEDeployRoot_CapabilityServletContainer(), source, new String[] {
				"kind", "element", //$NON-NLS-1$ //$NON-NLS-2$
				"name", "capability.servletContainer", //$NON-NLS-1$ //$NON-NLS-2$
				"namespace", "##targetNamespace", //$NON-NLS-1$ //$NON-NLS-2$
				"affiliation", "http://www.ibm.com/ccl/soa/deploy/core/1.0.0/#capability" //$NON-NLS-1$ //$NON-NLS-2$
		});
		addAnnotation(getJ2EEDeployRoot_CapabilityWebModule(), source, new String[] {
				"kind", "element", //$NON-NLS-1$ //$NON-NLS-2$
				"name", "capability.webModule", //$NON-NLS-1$ //$NON-NLS-2$
				"namespace", "##targetNamespace", //$NON-NLS-1$ //$NON-NLS-2$
				"affiliation", "http://www.ibm.com/ccl/soa/deploy/core/1.0.0/#capability" //$NON-NLS-1$ //$NON-NLS-2$
		});
		addAnnotation(getJ2EEDeployRoot_ComponentEar(), source, new String[] { "kind", "element", //$NON-NLS-1$ //$NON-NLS-2$
				"name", "component.ear", //$NON-NLS-1$ //$NON-NLS-2$
				"namespace", "##targetNamespace", //$NON-NLS-1$ //$NON-NLS-2$
				"affiliation", "http://www.ibm.com/ccl/soa/deploy/core/1.0.0/#unit" //$NON-NLS-1$ //$NON-NLS-2$
		});
		addAnnotation(getJ2EEDeployRoot_ComponentEjb(), source, new String[] { "kind", "element", //$NON-NLS-1$ //$NON-NLS-2$
				"name", "component.ejb", //$NON-NLS-1$ //$NON-NLS-2$
				"namespace", "##targetNamespace", //$NON-NLS-1$ //$NON-NLS-2$
				"affiliation", "http://www.ibm.com/ccl/soa/deploy/core/1.0.0/#unit" //$NON-NLS-1$ //$NON-NLS-2$
		});
		addAnnotation(getJ2EEDeployRoot_ComponentJar(), source, new String[] { "kind", "element", //$NON-NLS-1$ //$NON-NLS-2$
				"name", "component.jar", //$NON-NLS-1$ //$NON-NLS-2$
				"namespace", "##targetNamespace", //$NON-NLS-1$ //$NON-NLS-2$
				"affiliation", "http://www.ibm.com/ccl/soa/deploy/core/1.0.0/#unit" //$NON-NLS-1$ //$NON-NLS-2$
		});
		addAnnotation(getJ2EEDeployRoot_ComponentWeb(), source, new String[] { "kind", "element", //$NON-NLS-1$ //$NON-NLS-2$
				"name", "component.web", //$NON-NLS-1$ //$NON-NLS-2$
				"namespace", "##targetNamespace", //$NON-NLS-1$ //$NON-NLS-2$
				"affiliation", "http://www.ibm.com/ccl/soa/deploy/core/1.0.0/#unit" //$NON-NLS-1$ //$NON-NLS-2$
		});
		addAnnotation(getJ2EEDeployRoot_InterfaceJava(), source, new String[] { "kind", "element", //$NON-NLS-1$ //$NON-NLS-2$
				"name", "interface.java", //$NON-NLS-1$ //$NON-NLS-2$
				"namespace", "##targetNamespace", //$NON-NLS-1$ //$NON-NLS-2$
				"affiliation", "http://www.ibm.com/ccl/soa/deploy/core/1.0.0/#interface" //$NON-NLS-1$ //$NON-NLS-2$
		});
		addAnnotation(getJ2EEDeployRoot_InterfaceUrl(), source, new String[] { "kind", "element", //$NON-NLS-1$ //$NON-NLS-2$
				"name", "interface.url", //$NON-NLS-1$ //$NON-NLS-2$
				"namespace", "##targetNamespace", //$NON-NLS-1$ //$NON-NLS-2$
				"affiliation", "http://www.ibm.com/ccl/soa/deploy/core/1.0.0/#interface" //$NON-NLS-1$ //$NON-NLS-2$
		});
		addAnnotation(getJ2EEDeployRoot_InterfaceWsdl(), source, new String[] { "kind", "element", //$NON-NLS-1$ //$NON-NLS-2$
				"name", "interface.wsdl", //$NON-NLS-1$ //$NON-NLS-2$
				"namespace", "##targetNamespace", //$NON-NLS-1$ //$NON-NLS-2$
				"affiliation", "http://www.ibm.com/ccl/soa/deploy/core/1.0.0/#interface" //$NON-NLS-1$ //$NON-NLS-2$
		});
		addAnnotation(getJ2EEDeployRoot_ServiceEntity(), source, new String[] { "kind", "element", //$NON-NLS-1$ //$NON-NLS-2$
				"name", "service.entity", //$NON-NLS-1$ //$NON-NLS-2$
				"namespace", "##targetNamespace", //$NON-NLS-1$ //$NON-NLS-2$
				"affiliation", "http://www.ibm.com/ccl/soa/deploy/core/1.0.0/#capability" //$NON-NLS-1$ //$NON-NLS-2$
		});
		addAnnotation(getJ2EEDeployRoot_ServiceServlet(), source, new String[] { "kind", "element", //$NON-NLS-1$ //$NON-NLS-2$
				"name", "service.servlet", //$NON-NLS-1$ //$NON-NLS-2$
				"namespace", "##targetNamespace", //$NON-NLS-1$ //$NON-NLS-2$
				"affiliation", "http://www.ibm.com/ccl/soa/deploy/core/1.0.0/#capability" //$NON-NLS-1$ //$NON-NLS-2$
		});
		addAnnotation(getJ2EEDeployRoot_ServiceSession(), source, new String[] { "kind", "element", //$NON-NLS-1$ //$NON-NLS-2$
				"name", "service.session", //$NON-NLS-1$ //$NON-NLS-2$
				"namespace", "##targetNamespace", //$NON-NLS-1$ //$NON-NLS-2$
				"affiliation", "http://www.ibm.com/ccl/soa/deploy/core/1.0.0/#capability" //$NON-NLS-1$ //$NON-NLS-2$
		});
		addAnnotation(getJ2EEDeployRoot_ServiceWs(), source, new String[] { "kind", "element", //$NON-NLS-1$ //$NON-NLS-2$
				"name", "service.ws", //$NON-NLS-1$ //$NON-NLS-2$
				"namespace", "##targetNamespace", //$NON-NLS-1$ //$NON-NLS-2$
				"affiliation", "http://www.ibm.com/ccl/soa/deploy/core/1.0.0/#capability" //$NON-NLS-1$ //$NON-NLS-2$
		});
		addAnnotation(getJ2EEDeployRoot_UnitAppClient(), source, new String[] { "kind", "element", //$NON-NLS-1$ //$NON-NLS-2$
				"name", "unit.appClient", //$NON-NLS-1$ //$NON-NLS-2$
				"namespace", "##targetNamespace", //$NON-NLS-1$ //$NON-NLS-2$
				"affiliation", "http://www.ibm.com/ccl/soa/deploy/core/1.0.0/#unit" //$NON-NLS-1$ //$NON-NLS-2$
		});
		addAnnotation(getJ2EEDeployRoot_UnitJ2eeServer(), source, new String[] { "kind", "element", //$NON-NLS-1$ //$NON-NLS-2$
				"name", "unit.j2eeServer", //$NON-NLS-1$ //$NON-NLS-2$
				"namespace", "##targetNamespace", //$NON-NLS-1$ //$NON-NLS-2$
				"affiliation", "http://www.ibm.com/ccl/soa/deploy/core/1.0.0/#unit" //$NON-NLS-1$ //$NON-NLS-2$
		});
		addAnnotation(getJ2EEDeployRoot_UnitJ2eeServerUnit(), source, new String[] {
				"kind", "element", //$NON-NLS-1$ //$NON-NLS-2$
				"name", "unit.j2eeServerUnit", //$NON-NLS-1$ //$NON-NLS-2$
				"namespace", "##targetNamespace", //$NON-NLS-1$ //$NON-NLS-2$
				"affiliation", "http://www.ibm.com/ccl/soa/deploy/core/1.0.0/#unit" //$NON-NLS-1$ //$NON-NLS-2$
		});
		addAnnotation(getJ2EEDeployRoot_UnitJcaModule(), source, new String[] { "kind", "element", //$NON-NLS-1$ //$NON-NLS-2$
				"name", "unit.jcaModule", //$NON-NLS-1$ //$NON-NLS-2$
				"namespace", "##targetNamespace", //$NON-NLS-1$ //$NON-NLS-2$
				"affiliation", "http://www.ibm.com/ccl/soa/deploy/core/1.0.0/#unit" //$NON-NLS-1$ //$NON-NLS-2$
		});
		addAnnotation(getJ2EEDeployRoot_UnitWebServer(), source, new String[] { "kind", "element", //$NON-NLS-1$ //$NON-NLS-2$
				"name", "unit.webServer", //$NON-NLS-1$ //$NON-NLS-2$
				"namespace", "##targetNamespace", //$NON-NLS-1$ //$NON-NLS-2$
				"affiliation", "http://www.ibm.com/ccl/soa/deploy/core/1.0.0/#unit" //$NON-NLS-1$ //$NON-NLS-2$
		});
		addAnnotation(j2EEModuleCapabilityEClass, source, new String[] {
				"name", "J2EEModuleCapability", //$NON-NLS-1$ //$NON-NLS-2$
				"kind", "elementOnly" //$NON-NLS-1$ //$NON-NLS-2$
		});
		addAnnotation(getJ2EEModuleCapability_ModuleName(), source, new String[] {
				"kind", "attribute", //$NON-NLS-1$ //$NON-NLS-2$
				"name", "moduleName" //$NON-NLS-1$ //$NON-NLS-2$
		});
		addAnnotation(j2EEResourceEnvironmentRequirementEClass, source, new String[] {
				"name", "J2EEResourceEnvironmentRequirement", //$NON-NLS-1$ //$NON-NLS-2$
				"kind", "elementOnly" //$NON-NLS-1$ //$NON-NLS-2$
		});
		addAnnotation(getJ2EEResourceEnvironmentRequirement_JndiName(), source, new String[] {
				"kind", "attribute", //$NON-NLS-1$ //$NON-NLS-2$
				"name", "jndiName" //$NON-NLS-1$ //$NON-NLS-2$
		});
		addAnnotation(getJ2EEResourceEnvironmentRequirement_Type(), source, new String[] {
				"kind", "attribute", //$NON-NLS-1$ //$NON-NLS-2$
				"name", "type" //$NON-NLS-1$ //$NON-NLS-2$
		});
		addAnnotation(j2EEResourceRequirementEClass, source, new String[] {
				"name", "J2EEResourceRequirement", //$NON-NLS-1$ //$NON-NLS-2$
				"kind", "elementOnly" //$NON-NLS-1$ //$NON-NLS-2$
		});
		addAnnotation(getJ2EEResourceRequirement_JndiName(), source, new String[] {
				"kind", "attribute", //$NON-NLS-1$ //$NON-NLS-2$
				"name", "jndiName" //$NON-NLS-1$ //$NON-NLS-2$
		});
		addAnnotation(getJ2EEResourceRequirement_Type(), source, new String[] { "kind", "attribute", //$NON-NLS-1$ //$NON-NLS-2$
				"name", "type" //$NON-NLS-1$ //$NON-NLS-2$
		});
		addAnnotation(j2EESecurityRoleEClass, source, new String[] { "name", "J2EESecurityRole", //$NON-NLS-1$ //$NON-NLS-2$
				"kind", "elementOnly" //$NON-NLS-1$ //$NON-NLS-2$
		});
		addAnnotation(getJ2EESecurityRole_Role(), source, new String[] { "kind", "attribute", //$NON-NLS-1$ //$NON-NLS-2$
				"name", "role" //$NON-NLS-1$ //$NON-NLS-2$
		});
		addAnnotation(j2EEServerEClass, source, new String[] { "name", "J2EEServer", //$NON-NLS-1$ //$NON-NLS-2$
				"kind", "elementOnly" //$NON-NLS-1$ //$NON-NLS-2$
		});
		addAnnotation(j2EEServerUnitEClass, source, new String[] { "name", "J2EEServerUnit", //$NON-NLS-1$ //$NON-NLS-2$
				"kind", "elementOnly" //$NON-NLS-1$ //$NON-NLS-2$
		});
		addAnnotation(jarModuleEClass, source, new String[] { "name", "JarModule", //$NON-NLS-1$ //$NON-NLS-2$
				"kind", "elementOnly" //$NON-NLS-1$ //$NON-NLS-2$
		});
		addAnnotation(jarModuleCapabilityEClass, source, new String[] {
				"name", "JarModuleCapability", //$NON-NLS-1$ //$NON-NLS-2$
				"kind", "elementOnly" //$NON-NLS-1$ //$NON-NLS-2$
		});
		addAnnotation(javaInterfaceEClass, source, new String[] { "name", "JavaInterface", //$NON-NLS-1$ //$NON-NLS-2$
				"kind", "empty" //$NON-NLS-1$ //$NON-NLS-2$
		});
		addAnnotation(getJavaInterface_Interface(), source, new String[] { "kind", "attribute", //$NON-NLS-1$ //$NON-NLS-2$
				"name", "interface" //$NON-NLS-1$ //$NON-NLS-2$
		});
		addAnnotation(jcaContainerEClass, source, new String[] { "name", "JCAContainer", //$NON-NLS-1$ //$NON-NLS-2$
				"kind", "elementOnly" //$NON-NLS-1$ //$NON-NLS-2$
		});
		addAnnotation(getJCAContainer_ContainerVersion(), source, new String[] { "kind", "attribute", //$NON-NLS-1$ //$NON-NLS-2$
				"name", "containerVersion" //$NON-NLS-1$ //$NON-NLS-2$
		});
		addAnnotation(jcaContainerVersionEEnum, source, new String[] { "name", "JCAContainerVersion" //$NON-NLS-1$ //$NON-NLS-2$
		});
		addAnnotation(jcaContainerVersionObjectEDataType, source, new String[] {
				"name", "JCAContainerVersion:Object", //$NON-NLS-1$ //$NON-NLS-2$
				"baseType", "JCAContainerVersion" //$NON-NLS-1$ //$NON-NLS-2$
		});
		addAnnotation(jcaModuleEClass, source, new String[] { "name", "JCAModule", //$NON-NLS-1$ //$NON-NLS-2$
				"kind", "elementOnly" //$NON-NLS-1$ //$NON-NLS-2$
		});
		addAnnotation(jcaModuleCapabilityEClass, source, new String[] {
				"name", "JCAModuleCapability", //$NON-NLS-1$ //$NON-NLS-2$
				"kind", "elementOnly" //$NON-NLS-1$ //$NON-NLS-2$
		});
		addAnnotation(jspContainerEClass, source, new String[] { "name", "JSPContainer", //$NON-NLS-1$ //$NON-NLS-2$
				"kind", "elementOnly" //$NON-NLS-1$ //$NON-NLS-2$
		});
		addAnnotation(getJSPContainer_ContainerVersion(), source, new String[] { "kind", "attribute", //$NON-NLS-1$ //$NON-NLS-2$
				"name", "containerVersion" //$NON-NLS-1$ //$NON-NLS-2$
		});
		addAnnotation(jspContainerVersionEEnum, source, new String[] { "name", "JSPContainerVersion" //$NON-NLS-1$ //$NON-NLS-2$
		});
		addAnnotation(jspContainerVersionObjectEDataType, source, new String[] {
				"name", "JSPContainerVersion:Object", //$NON-NLS-1$ //$NON-NLS-2$
				"baseType", "JSPContainerVersion" //$NON-NLS-1$ //$NON-NLS-2$
		});
		addAnnotation(servletContainerEClass, source, new String[] { "name", "ServletContainer", //$NON-NLS-1$ //$NON-NLS-2$
				"kind", "elementOnly" //$NON-NLS-1$ //$NON-NLS-2$
		});
		addAnnotation(getServletContainer_ContainerVersion(), source, new String[] {
				"kind", "attribute", //$NON-NLS-1$ //$NON-NLS-2$
				"name", "containerVersion" //$NON-NLS-1$ //$NON-NLS-2$
		});
		addAnnotation(servletContainerVersionEEnum, source, new String[] {
				"name", "ServletContainerVersion" //$NON-NLS-1$ //$NON-NLS-2$
		});
		addAnnotation(servletContainerVersionObjectEDataType, source, new String[] {
				"name", "ServletContainerVersion:Object", //$NON-NLS-1$ //$NON-NLS-2$
				"baseType", "ServletContainerVersion" //$NON-NLS-1$ //$NON-NLS-2$
		});
		addAnnotation(sessionServiceEClass, source, new String[] { "name", "SessionService", //$NON-NLS-1$ //$NON-NLS-2$
				"kind", "elementOnly" //$NON-NLS-1$ //$NON-NLS-2$
		});
		addAnnotation(urlInterfaceEClass, source, new String[] { "name", "URLInterface", //$NON-NLS-1$ //$NON-NLS-2$
				"kind", "elementOnly" //$NON-NLS-1$ //$NON-NLS-2$
		});
		addAnnotation(getURLInterface_ParamName(), source, new String[] { "kind", "element", //$NON-NLS-1$ //$NON-NLS-2$
				"name", "paramName", //$NON-NLS-1$ //$NON-NLS-2$
				"namespace", "##targetNamespace" //$NON-NLS-1$ //$NON-NLS-2$
		});
		addAnnotation(urlServiceEClass, source, new String[] { "name", "URLService", //$NON-NLS-1$ //$NON-NLS-2$
				"kind", "elementOnly" //$NON-NLS-1$ //$NON-NLS-2$
		});
		addAnnotation(getURLService_UrlPattern(), source, new String[] { "kind", "element", //$NON-NLS-1$ //$NON-NLS-2$
				"name", "urlPattern", //$NON-NLS-1$ //$NON-NLS-2$
				"namespace", "##targetNamespace" //$NON-NLS-1$ //$NON-NLS-2$
		});
		addAnnotation(vicinityEEnum, source, new String[] { "name", "Vicinity" //$NON-NLS-1$ //$NON-NLS-2$
		});
		addAnnotation(vicinityObjectEDataType, source, new String[] { "name", "Vicinity:Object", //$NON-NLS-1$ //$NON-NLS-2$
				"baseType", "Vicinity" //$NON-NLS-1$ //$NON-NLS-2$
		});
		addAnnotation(webModuleEClass, source, new String[] { "name", "WebModule", //$NON-NLS-1$ //$NON-NLS-2$
				"kind", "elementOnly" //$NON-NLS-1$ //$NON-NLS-2$
		});
		addAnnotation(webModuleCapabilityEClass, source, new String[] {
				"name", "WebModuleCapability", //$NON-NLS-1$ //$NON-NLS-2$
				"kind", "elementOnly" //$NON-NLS-1$ //$NON-NLS-2$
		});
		addAnnotation(getWebModuleCapability_ContextRoot(), source, new String[] {
				"kind", "attribute", //$NON-NLS-1$ //$NON-NLS-2$
				"name", "contextRoot" //$NON-NLS-1$ //$NON-NLS-2$
		});
		addAnnotation(webServiceEClass, source, new String[] { "name", "WebService", //$NON-NLS-1$ //$NON-NLS-2$
				"kind", "elementOnly" //$NON-NLS-1$ //$NON-NLS-2$
		});
		addAnnotation(getWebService_Endpoint(), source, new String[] { "kind", "attribute", //$NON-NLS-1$ //$NON-NLS-2$
				"name", "endpoint" //$NON-NLS-1$ //$NON-NLS-2$
		});
		addAnnotation(wsdlInterfaceEClass, source, new String[] { "name", "WSDLInterface", //$NON-NLS-1$ //$NON-NLS-2$
				"kind", "empty" //$NON-NLS-1$ //$NON-NLS-2$
		});
		addAnnotation(getWSDLInterface_TypeUri(), source, new String[] { "kind", "attribute", //$NON-NLS-1$ //$NON-NLS-2$
				"name", "typeUri" //$NON-NLS-1$ //$NON-NLS-2$
		});
	}

} //J2eePackageImpl
