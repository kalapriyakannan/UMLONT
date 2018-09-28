/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package com.ibm.ccl.soa.deploy.wps.impl;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EcorePackage;
import org.eclipse.emf.ecore.impl.EPackageImpl;
import org.eclipse.emf.ecore.xml.type.XMLTypePackage;

import com.ibm.ccl.soa.deploy.core.CorePackage;
import com.ibm.ccl.soa.deploy.wps.ApplicationSchedular;
import com.ibm.ccl.soa.deploy.wps.BPEContainer;
import com.ibm.ccl.soa.deploy.wps.BPEContainerUnit;
import com.ibm.ccl.soa.deploy.wps.BusinessRulesManager;
import com.ibm.ccl.soa.deploy.wps.BusinessRulesManagerUnit;
import com.ibm.ccl.soa.deploy.wps.CommonEventInfrastructure;
import com.ibm.ccl.soa.deploy.wps.ExtendedMessagingService;
import com.ibm.ccl.soa.deploy.wps.ManagingEventservice;
import com.ibm.ccl.soa.deploy.wps.SCARuntime;
import com.ibm.ccl.soa.deploy.wps.SDORuntime;
import com.ibm.ccl.soa.deploy.wps.TaskContainer;
import com.ibm.ccl.soa.deploy.wps.TaskContainerUnit;
import com.ibm.ccl.soa.deploy.wps.WPSCommonEventInfrastructureUnit;
import com.ibm.ccl.soa.deploy.wps.WPSESBUnit;
import com.ibm.ccl.soa.deploy.wps.WPSRoot;
import com.ibm.ccl.soa.deploy.wps.WPSSIBUnit;
import com.ibm.ccl.soa.deploy.wps.WebSphereBusinessIntegrationAdaptersService;
import com.ibm.ccl.soa.deploy.wps.WpsBaseSystem;
import com.ibm.ccl.soa.deploy.wps.WpsBaseSystemUnit;
import com.ibm.ccl.soa.deploy.wps.WpsFactory;
import com.ibm.ccl.soa.deploy.wps.WpsPackage;
import com.ibm.ccl.soa.deploy.wps.WpsSystemUnit;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Package</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class WpsPackageImpl extends EPackageImpl implements WpsPackage {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass applicationSchedularEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass bpeContainerEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass bpeContainerUnitEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass businessRulesManagerEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass businessRulesManagerUnitEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass commonEventInfrastructureEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass extendedMessagingServiceEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass managingEventserviceEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass scaRuntimeEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass sdoRuntimeEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass taskContainerEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass taskContainerUnitEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass webSphereBusinessIntegrationAdaptersServiceEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass wpsBaseSystemEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass wpsBaseSystemUnitEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass wpsCommonEventInfrastructureUnitEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass wpsesbEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass wpsesbUnitEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass wpsRootEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass wpssibEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass wpssibUnitEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass wpsSystemUnitEClass = null;

	/**
	 * Creates an instance of the model <b>Package</b>, registered with
	 * {@link org.eclipse.emf.ecore.EPackage.Registry EPackage.Registry} by the package
	 * package URI value.
	 * <p>Note: the correct way to create the package is via the static
	 * factory method {@link #init init()}, which also performs
	 * initialization of the package, or returns the registered package,
	 * if one already exists.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.emf.ecore.EPackage.Registry
	 * @see com.ibm.ccl.soa.deploy.wps.WpsPackage#eNS_URI
	 * @see #init()
	 * @generated
	 */
	private WpsPackageImpl() {
		super(eNS_URI, WpsFactory.eINSTANCE);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
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
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #eNS_URI
	 * @see #createPackageContents()
	 * @see #initializePackageContents()
	 * @generated
	 */
	public static WpsPackage init() {
		if (isInited) return (WpsPackage)EPackage.Registry.INSTANCE.getEPackage(WpsPackage.eNS_URI);

		// Obtain or create and register package
		WpsPackageImpl theWpsPackage = (WpsPackageImpl)(EPackage.Registry.INSTANCE.getEPackage(eNS_URI) instanceof WpsPackageImpl ? EPackage.Registry.INSTANCE.getEPackage(eNS_URI) : new WpsPackageImpl());

		isInited = true;

		// Initialize simple dependencies
		CorePackage.eINSTANCE.eClass();
		EcorePackage.eINSTANCE.eClass();
		XMLTypePackage.eINSTANCE.eClass();

		// Create package meta-data objects
		theWpsPackage.createPackageContents();

		// Initialize created meta-data
		theWpsPackage.initializePackageContents();

		// Mark meta-data to indicate it can't be changed
		theWpsPackage.freeze();

		return theWpsPackage;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getApplicationSchedular() {
		return applicationSchedularEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getApplicationSchedular_DataBaseName() {
		return (EAttribute)applicationSchedularEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getApplicationSchedular_ServerName() {
		return (EAttribute)applicationSchedularEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getBPEContainer() {
		return bpeContainerEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getBPEContainer_AdministratorSecurityRoleMapping() {
		return (EAttribute)bpeContainerEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getBPEContainer_Classpath() {
		return (EAttribute)bpeContainerEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getBPEContainer_DataSourcePassword() {
		return (EAttribute)bpeContainerEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getBPEContainer_DataSourceUsername() {
		return (EAttribute)bpeContainerEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getBPEContainer_EnableAuditLog() {
		return (EAttribute)bpeContainerEClass.getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getBPEContainer_EnableCEIlogging() {
		return (EAttribute)bpeContainerEClass.getEStructuralFeatures().get(5);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getBPEContainer_ExternalRequestProcessingQueue() {
		return (EAttribute)bpeContainerEClass.getEStructuralFeatures().get(6);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getBPEContainer_HoldQueue() {
		return (EAttribute)bpeContainerEClass.getEStructuralFeatures().get(7);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getBPEContainer_ImplementationClassName() {
		return (EAttribute)bpeContainerEClass.getEStructuralFeatures().get(8);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getBPEContainer_InstallBusinessProcessChoreographerExplorer() {
		return (EAttribute)bpeContainerEClass.getEStructuralFeatures().get(9);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getBPEContainer_InternalQueue() {
		return (EAttribute)bpeContainerEClass.getEStructuralFeatures().get(10);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getBPEContainer_JDBCProvider() {
		return (EAttribute)bpeContainerEClass.getEStructuralFeatures().get(11);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getBPEContainer_JMSAPIPassword() {
		return (EAttribute)bpeContainerEClass.getEStructuralFeatures().get(12);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getBPEContainer_JMSAPIUserID() {
		return (EAttribute)bpeContainerEClass.getEStructuralFeatures().get(13);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getBPEContainer_JMSConnectionFactory() {
		return (EAttribute)bpeContainerEClass.getEStructuralFeatures().get(14);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getBPEContainer_JMSPassword() {
		return (EAttribute)bpeContainerEClass.getEStructuralFeatures().get(15);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getBPEContainer_JMSProvider() {
		return (EAttribute)bpeContainerEClass.getEStructuralFeatures().get(16);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getBPEContainer_JMSResources() {
		return (EAttribute)bpeContainerEClass.getEStructuralFeatures().get(17);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getBPEContainer_JMSUserID() {
		return (EAttribute)bpeContainerEClass.getEStructuralFeatures().get(18);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getBPEContainer_QueueManager() {
		return (EAttribute)bpeContainerEClass.getEStructuralFeatures().get(19);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getBPEContainer_RetentionQueue() {
		return (EAttribute)bpeContainerEClass.getEStructuralFeatures().get(20);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getBPEContainer_SystemMonitorSecurityRoleMapping() {
		return (EAttribute)bpeContainerEClass.getEStructuralFeatures().get(21);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getBPEContainerUnit() {
		return bpeContainerUnitEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getBusinessRulesManager() {
		return businessRulesManagerEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getBusinessRulesManager_BusinessRulesManager() {
		return (EAttribute)businessRulesManagerEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getBusinessRulesManagerUnit() {
		return businessRulesManagerUnitEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getCommonEventInfrastructure() {
		return commonEventInfrastructureEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getCommonEventInfrastructure_Name1() {
		return (EAttribute)commonEventInfrastructureEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getExtendedMessagingService() {
		return extendedMessagingServiceEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getExtendedMessagingService_InputPort() {
		return (EAttribute)extendedMessagingServiceEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getExtendedMessagingService_OutputPort() {
		return (EAttribute)extendedMessagingServiceEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getManagingEventservice() {
		return managingEventserviceEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getManagingEventservice_EventsInfrastructureEmitterFactoryJNDIName() {
		return (EAttribute)managingEventserviceEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getSCARuntime() {
		return scaRuntimeEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getSCARuntime_InstallationPath() {
		return (EAttribute)scaRuntimeEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getSDORuntime() {
		return sdoRuntimeEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getSDORuntime_InstallationPath() {
		return (EAttribute)sdoRuntimeEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getTaskContainer() {
		return taskContainerEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getTaskContainer_AdministratorSecurityRoleMapping() {
		return (EAttribute)taskContainerEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getTaskContainer_Classpath() {
		return (EAttribute)taskContainerEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getTaskContainer_EnableAuditLog() {
		return (EAttribute)taskContainerEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getTaskContainer_EnableCEIlogging() {
		return (EAttribute)taskContainerEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getTaskContainer_Escalationpassword() {
		return (EAttribute)taskContainerEClass.getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getTaskContainer_HoldQueue() {
		return (EAttribute)taskContainerEClass.getEStructuralFeatures().get(5);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getTaskContainer_JMSConnectionFactory() {
		return (EAttribute)taskContainerEClass.getEStructuralFeatures().get(6);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getTaskContainer_JMSPassword() {
		return (EAttribute)taskContainerEClass.getEStructuralFeatures().get(7);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getTaskContainer_JMSProvider() {
		return (EAttribute)taskContainerEClass.getEStructuralFeatures().get(8);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getTaskContainer_JMSResources() {
		return (EAttribute)taskContainerEClass.getEStructuralFeatures().get(9);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getTaskContainer_JMSUserID() {
		return (EAttribute)taskContainerEClass.getEStructuralFeatures().get(10);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getTaskContainer_MailSession() {
		return (EAttribute)taskContainerEClass.getEStructuralFeatures().get(11);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getTaskContainer_QueueManager() {
		return (EAttribute)taskContainerEClass.getEStructuralFeatures().get(12);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getTaskContainer_SystemMonitorSecurityRoleMapping() {
		return (EAttribute)taskContainerEClass.getEStructuralFeatures().get(13);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getTaskContainerUnit() {
		return taskContainerUnitEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getWebSphereBusinessIntegrationAdaptersService() {
		return webSphereBusinessIntegrationAdaptersServiceEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getWebSphereBusinessIntegrationAdaptersService_InputQueueJNDIName() {
		return (EAttribute)webSphereBusinessIntegrationAdaptersServiceEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getWebSphereBusinessIntegrationAdaptersService_JNDIName() {
		return (EAttribute)webSphereBusinessIntegrationAdaptersServiceEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getWebSphereBusinessIntegrationAdaptersService_Name1() {
		return (EAttribute)webSphereBusinessIntegrationAdaptersServiceEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getWebSphereBusinessIntegrationAdaptersService_OutputQueueJNDIName() {
		return (EAttribute)webSphereBusinessIntegrationAdaptersServiceEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getWebSphereBusinessIntegrationAdaptersService_Timeout() {
		return (EAttribute)webSphereBusinessIntegrationAdaptersServiceEClass.getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getWpsBaseSystem() {
		return wpsBaseSystemEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getWpsBaseSystem_InstallLocation() {
		return (EAttribute)wpsBaseSystemEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getWpsBaseSystem_ProfileDir() {
		return (EAttribute)wpsBaseSystemEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getWpsBaseSystem_Version() {
		return (EAttribute)wpsBaseSystemEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getWpsBaseSystemUnit() {
		return wpsBaseSystemUnitEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getWPSCommonEventInfrastructureUnit() {
		return wpsCommonEventInfrastructureUnitEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getWPSESB() {
		return wpsesbEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getWPSESB_Name1() {
		return (EAttribute)wpsesbEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getWPSESBUnit() {
		return wpsesbUnitEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getWPSRoot() {
		return wpsRootEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getWPSRoot_Mixed() {
		return (EAttribute)wpsRootEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getWPSRoot_XMLNSPrefixMap() {
		return (EReference)wpsRootEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getWPSRoot_XSISchemaLocation() {
		return (EReference)wpsRootEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getWPSRoot_CapabilityApplicationSchedular() {
		return (EReference)wpsRootEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getWPSRoot_CapabilityBPEContainer() {
		return (EReference)wpsRootEClass.getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getWPSRoot_CapabilityBusinessRulesManager() {
		return (EReference)wpsRootEClass.getEStructuralFeatures().get(5);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getWPSRoot_CapabilityCommonEventInfrastructure() {
		return (EReference)wpsRootEClass.getEStructuralFeatures().get(6);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getWPSRoot_CapabilityExtendedMessagingService() {
		return (EReference)wpsRootEClass.getEStructuralFeatures().get(7);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getWPSRoot_CapabilityManagingEventService() {
		return (EReference)wpsRootEClass.getEStructuralFeatures().get(8);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getWPSRoot_CapabilitySCARuntime() {
		return (EReference)wpsRootEClass.getEStructuralFeatures().get(9);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getWPSRoot_CapabilitySDORuntime() {
		return (EReference)wpsRootEClass.getEStructuralFeatures().get(10);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getWPSRoot_CapabilityTaskContainer() {
		return (EReference)wpsRootEClass.getEStructuralFeatures().get(11);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getWPSRoot_CapabilityWebSphereBusinessIntegrationAdaptersService() {
		return (EReference)wpsRootEClass.getEStructuralFeatures().get(12);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getWPSRoot_CapabilityWpsBaseSystem() {
		return (EReference)wpsRootEClass.getEStructuralFeatures().get(13);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getWPSRoot_CapabilityWPSESB() {
		return (EReference)wpsRootEClass.getEStructuralFeatures().get(14);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getWPSRoot_CapabilityWPSSIB() {
		return (EReference)wpsRootEClass.getEStructuralFeatures().get(15);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getWPSRoot_UnitBPEContainerUnit() {
		return (EReference)wpsRootEClass.getEStructuralFeatures().get(16);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getWPSRoot_UnitBusinessRulesManagerUnit() {
		return (EReference)wpsRootEClass.getEStructuralFeatures().get(17);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getWPSRoot_UnitTaskContainerUnit() {
		return (EReference)wpsRootEClass.getEStructuralFeatures().get(18);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getWPSRoot_UnitWpsBaseSystemUnit() {
		return (EReference)wpsRootEClass.getEStructuralFeatures().get(19);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getWPSRoot_UnitWPSCommonEventInfrastructureUnit() {
		return (EReference)wpsRootEClass.getEStructuralFeatures().get(20);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getWPSRoot_UnitWPSESBUnit() {
		return (EReference)wpsRootEClass.getEStructuralFeatures().get(21);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getWPSRoot_UnitWPSSIBUnit() {
		return (EReference)wpsRootEClass.getEStructuralFeatures().get(22);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getWPSRoot_UnitWpsSystemUnit() {
		return (EReference)wpsRootEClass.getEStructuralFeatures().get(23);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getWPSSIB() {
		return wpssibEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getWPSSIB_Name1() {
		return (EAttribute)wpssibEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getWPSSIBUnit() {
		return wpssibUnitEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getWpsSystemUnit() {
		return wpsSystemUnitEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public WpsFactory getWpsFactory() {
		return (WpsFactory)getEFactoryInstance();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private boolean isCreated = false;

	/**
	 * Creates the meta-model objects for the package.  This method is
	 * guarded to have no affect on any invocation but its first.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void createPackageContents() {
		if (isCreated) return;
		isCreated = true;

		// Create classes and their features
		applicationSchedularEClass = createEClass(APPLICATION_SCHEDULAR);
		createEAttribute(applicationSchedularEClass, APPLICATION_SCHEDULAR__DATA_BASE_NAME);
		createEAttribute(applicationSchedularEClass, APPLICATION_SCHEDULAR__SERVER_NAME);

		bpeContainerEClass = createEClass(BPE_CONTAINER);
		createEAttribute(bpeContainerEClass, BPE_CONTAINER__ADMINISTRATOR_SECURITY_ROLE_MAPPING);
		createEAttribute(bpeContainerEClass, BPE_CONTAINER__CLASSPATH);
		createEAttribute(bpeContainerEClass, BPE_CONTAINER__DATA_SOURCE_PASSWORD);
		createEAttribute(bpeContainerEClass, BPE_CONTAINER__DATA_SOURCE_USERNAME);
		createEAttribute(bpeContainerEClass, BPE_CONTAINER__ENABLE_AUDIT_LOG);
		createEAttribute(bpeContainerEClass, BPE_CONTAINER__ENABLE_CE_ILOGGING);
		createEAttribute(bpeContainerEClass, BPE_CONTAINER__EXTERNAL_REQUEST_PROCESSING_QUEUE);
		createEAttribute(bpeContainerEClass, BPE_CONTAINER__HOLD_QUEUE);
		createEAttribute(bpeContainerEClass, BPE_CONTAINER__IMPLEMENTATION_CLASS_NAME);
		createEAttribute(bpeContainerEClass, BPE_CONTAINER__INSTALL_BUSINESS_PROCESS_CHOREOGRAPHER_EXPLORER);
		createEAttribute(bpeContainerEClass, BPE_CONTAINER__INTERNAL_QUEUE);
		createEAttribute(bpeContainerEClass, BPE_CONTAINER__JDBC_PROVIDER);
		createEAttribute(bpeContainerEClass, BPE_CONTAINER__JMSAPI_PASSWORD);
		createEAttribute(bpeContainerEClass, BPE_CONTAINER__JMSAPI_USER_ID);
		createEAttribute(bpeContainerEClass, BPE_CONTAINER__JMS_CONNECTION_FACTORY);
		createEAttribute(bpeContainerEClass, BPE_CONTAINER__JMS_PASSWORD);
		createEAttribute(bpeContainerEClass, BPE_CONTAINER__JMS_PROVIDER);
		createEAttribute(bpeContainerEClass, BPE_CONTAINER__JMS_RESOURCES);
		createEAttribute(bpeContainerEClass, BPE_CONTAINER__JMS_USER_ID);
		createEAttribute(bpeContainerEClass, BPE_CONTAINER__QUEUE_MANAGER);
		createEAttribute(bpeContainerEClass, BPE_CONTAINER__RETENTION_QUEUE);
		createEAttribute(bpeContainerEClass, BPE_CONTAINER__SYSTEM_MONITOR_SECURITY_ROLE_MAPPING);

		bpeContainerUnitEClass = createEClass(BPE_CONTAINER_UNIT);

		businessRulesManagerEClass = createEClass(BUSINESS_RULES_MANAGER);
		createEAttribute(businessRulesManagerEClass, BUSINESS_RULES_MANAGER__BUSINESS_RULES_MANAGER);

		businessRulesManagerUnitEClass = createEClass(BUSINESS_RULES_MANAGER_UNIT);

		commonEventInfrastructureEClass = createEClass(COMMON_EVENT_INFRASTRUCTURE);
		createEAttribute(commonEventInfrastructureEClass, COMMON_EVENT_INFRASTRUCTURE__NAME1);

		extendedMessagingServiceEClass = createEClass(EXTENDED_MESSAGING_SERVICE);
		createEAttribute(extendedMessagingServiceEClass, EXTENDED_MESSAGING_SERVICE__INPUT_PORT);
		createEAttribute(extendedMessagingServiceEClass, EXTENDED_MESSAGING_SERVICE__OUTPUT_PORT);

		managingEventserviceEClass = createEClass(MANAGING_EVENTSERVICE);
		createEAttribute(managingEventserviceEClass, MANAGING_EVENTSERVICE__EVENTS_INFRASTRUCTURE_EMITTER_FACTORY_JNDI_NAME);

		scaRuntimeEClass = createEClass(SCA_RUNTIME);
		createEAttribute(scaRuntimeEClass, SCA_RUNTIME__INSTALLATION_PATH);

		sdoRuntimeEClass = createEClass(SDO_RUNTIME);
		createEAttribute(sdoRuntimeEClass, SDO_RUNTIME__INSTALLATION_PATH);

		taskContainerEClass = createEClass(TASK_CONTAINER);
		createEAttribute(taskContainerEClass, TASK_CONTAINER__ADMINISTRATOR_SECURITY_ROLE_MAPPING);
		createEAttribute(taskContainerEClass, TASK_CONTAINER__CLASSPATH);
		createEAttribute(taskContainerEClass, TASK_CONTAINER__ENABLE_AUDIT_LOG);
		createEAttribute(taskContainerEClass, TASK_CONTAINER__ENABLE_CE_ILOGGING);
		createEAttribute(taskContainerEClass, TASK_CONTAINER__ESCALATIONPASSWORD);
		createEAttribute(taskContainerEClass, TASK_CONTAINER__HOLD_QUEUE);
		createEAttribute(taskContainerEClass, TASK_CONTAINER__JMS_CONNECTION_FACTORY);
		createEAttribute(taskContainerEClass, TASK_CONTAINER__JMS_PASSWORD);
		createEAttribute(taskContainerEClass, TASK_CONTAINER__JMS_PROVIDER);
		createEAttribute(taskContainerEClass, TASK_CONTAINER__JMS_RESOURCES);
		createEAttribute(taskContainerEClass, TASK_CONTAINER__JMS_USER_ID);
		createEAttribute(taskContainerEClass, TASK_CONTAINER__MAIL_SESSION);
		createEAttribute(taskContainerEClass, TASK_CONTAINER__QUEUE_MANAGER);
		createEAttribute(taskContainerEClass, TASK_CONTAINER__SYSTEM_MONITOR_SECURITY_ROLE_MAPPING);

		taskContainerUnitEClass = createEClass(TASK_CONTAINER_UNIT);

		webSphereBusinessIntegrationAdaptersServiceEClass = createEClass(WEB_SPHERE_BUSINESS_INTEGRATION_ADAPTERS_SERVICE);
		createEAttribute(webSphereBusinessIntegrationAdaptersServiceEClass, WEB_SPHERE_BUSINESS_INTEGRATION_ADAPTERS_SERVICE__INPUT_QUEUE_JNDI_NAME);
		createEAttribute(webSphereBusinessIntegrationAdaptersServiceEClass, WEB_SPHERE_BUSINESS_INTEGRATION_ADAPTERS_SERVICE__JNDI_NAME);
		createEAttribute(webSphereBusinessIntegrationAdaptersServiceEClass, WEB_SPHERE_BUSINESS_INTEGRATION_ADAPTERS_SERVICE__NAME1);
		createEAttribute(webSphereBusinessIntegrationAdaptersServiceEClass, WEB_SPHERE_BUSINESS_INTEGRATION_ADAPTERS_SERVICE__OUTPUT_QUEUE_JNDI_NAME);
		createEAttribute(webSphereBusinessIntegrationAdaptersServiceEClass, WEB_SPHERE_BUSINESS_INTEGRATION_ADAPTERS_SERVICE__TIMEOUT);

		wpsBaseSystemEClass = createEClass(WPS_BASE_SYSTEM);
		createEAttribute(wpsBaseSystemEClass, WPS_BASE_SYSTEM__INSTALL_LOCATION);
		createEAttribute(wpsBaseSystemEClass, WPS_BASE_SYSTEM__PROFILE_DIR);
		createEAttribute(wpsBaseSystemEClass, WPS_BASE_SYSTEM__VERSION);

		wpsBaseSystemUnitEClass = createEClass(WPS_BASE_SYSTEM_UNIT);

		wpsCommonEventInfrastructureUnitEClass = createEClass(WPS_COMMON_EVENT_INFRASTRUCTURE_UNIT);

		wpsesbEClass = createEClass(WPSESB);
		createEAttribute(wpsesbEClass, WPSESB__NAME1);

		wpsesbUnitEClass = createEClass(WPSESB_UNIT);

		wpsRootEClass = createEClass(WPS_ROOT);
		createEAttribute(wpsRootEClass, WPS_ROOT__MIXED);
		createEReference(wpsRootEClass, WPS_ROOT__XMLNS_PREFIX_MAP);
		createEReference(wpsRootEClass, WPS_ROOT__XSI_SCHEMA_LOCATION);
		createEReference(wpsRootEClass, WPS_ROOT__CAPABILITY_APPLICATION_SCHEDULAR);
		createEReference(wpsRootEClass, WPS_ROOT__CAPABILITY_BPE_CONTAINER);
		createEReference(wpsRootEClass, WPS_ROOT__CAPABILITY_BUSINESS_RULES_MANAGER);
		createEReference(wpsRootEClass, WPS_ROOT__CAPABILITY_COMMON_EVENT_INFRASTRUCTURE);
		createEReference(wpsRootEClass, WPS_ROOT__CAPABILITY_EXTENDED_MESSAGING_SERVICE);
		createEReference(wpsRootEClass, WPS_ROOT__CAPABILITY_MANAGING_EVENT_SERVICE);
		createEReference(wpsRootEClass, WPS_ROOT__CAPABILITY_SCA_RUNTIME);
		createEReference(wpsRootEClass, WPS_ROOT__CAPABILITY_SDO_RUNTIME);
		createEReference(wpsRootEClass, WPS_ROOT__CAPABILITY_TASK_CONTAINER);
		createEReference(wpsRootEClass, WPS_ROOT__CAPABILITY_WEB_SPHERE_BUSINESS_INTEGRATION_ADAPTERS_SERVICE);
		createEReference(wpsRootEClass, WPS_ROOT__CAPABILITY_WPS_BASE_SYSTEM);
		createEReference(wpsRootEClass, WPS_ROOT__CAPABILITY_WPSESB);
		createEReference(wpsRootEClass, WPS_ROOT__CAPABILITY_WPSSIB);
		createEReference(wpsRootEClass, WPS_ROOT__UNIT_BPE_CONTAINER_UNIT);
		createEReference(wpsRootEClass, WPS_ROOT__UNIT_BUSINESS_RULES_MANAGER_UNIT);
		createEReference(wpsRootEClass, WPS_ROOT__UNIT_TASK_CONTAINER_UNIT);
		createEReference(wpsRootEClass, WPS_ROOT__UNIT_WPS_BASE_SYSTEM_UNIT);
		createEReference(wpsRootEClass, WPS_ROOT__UNIT_WPS_COMMON_EVENT_INFRASTRUCTURE_UNIT);
		createEReference(wpsRootEClass, WPS_ROOT__UNIT_WPSESB_UNIT);
		createEReference(wpsRootEClass, WPS_ROOT__UNIT_WPSSIB_UNIT);
		createEReference(wpsRootEClass, WPS_ROOT__UNIT_WPS_SYSTEM_UNIT);

		wpssibEClass = createEClass(WPSSIB);
		createEAttribute(wpssibEClass, WPSSIB__NAME1);

		wpssibUnitEClass = createEClass(WPSSIB_UNIT);

		wpsSystemUnitEClass = createEClass(WPS_SYSTEM_UNIT);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private boolean isInitialized = false;

	/**
	 * Complete the initialization of the package and its meta-model.  This
	 * method is guarded to have no affect on any invocation but its first.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void initializePackageContents() {
		if (isInitialized) return;
		isInitialized = true;

		// Initialize package
		setName(eNAME);
		setNsPrefix(eNS_PREFIX);
		setNsURI(eNS_URI);

		// Obtain other dependent packages
		CorePackage theCorePackage = (CorePackage)EPackage.Registry.INSTANCE.getEPackage(CorePackage.eNS_URI);
		XMLTypePackage theXMLTypePackage = (XMLTypePackage)EPackage.Registry.INSTANCE.getEPackage(XMLTypePackage.eNS_URI);

		// Add supertypes to classes
		applicationSchedularEClass.getESuperTypes().add(theCorePackage.getCapability());
		bpeContainerEClass.getESuperTypes().add(theCorePackage.getCapability());
		bpeContainerUnitEClass.getESuperTypes().add(theCorePackage.getUnit());
		businessRulesManagerEClass.getESuperTypes().add(theCorePackage.getCapability());
		businessRulesManagerUnitEClass.getESuperTypes().add(theCorePackage.getUnit());
		commonEventInfrastructureEClass.getESuperTypes().add(theCorePackage.getCapability());
		extendedMessagingServiceEClass.getESuperTypes().add(theCorePackage.getCapability());
		managingEventserviceEClass.getESuperTypes().add(theCorePackage.getCapability());
		scaRuntimeEClass.getESuperTypes().add(theCorePackage.getCapability());
		sdoRuntimeEClass.getESuperTypes().add(theCorePackage.getCapability());
		taskContainerEClass.getESuperTypes().add(theCorePackage.getCapability());
		taskContainerUnitEClass.getESuperTypes().add(theCorePackage.getUnit());
		webSphereBusinessIntegrationAdaptersServiceEClass.getESuperTypes().add(theCorePackage.getCapability());
		wpsBaseSystemEClass.getESuperTypes().add(theCorePackage.getCapability());
		wpsBaseSystemUnitEClass.getESuperTypes().add(theCorePackage.getUnit());
		wpsCommonEventInfrastructureUnitEClass.getESuperTypes().add(theCorePackage.getUnit());
		wpsesbEClass.getESuperTypes().add(theCorePackage.getCapability());
		wpsesbUnitEClass.getESuperTypes().add(theCorePackage.getUnit());
		wpssibEClass.getESuperTypes().add(theCorePackage.getCapability());
		wpssibUnitEClass.getESuperTypes().add(theCorePackage.getUnit());
		wpsSystemUnitEClass.getESuperTypes().add(theCorePackage.getUnit());

		// Initialize classes and features; add operations and parameters
		initEClass(applicationSchedularEClass, ApplicationSchedular.class, "ApplicationSchedular", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$
		initEAttribute(getApplicationSchedular_DataBaseName(), theXMLTypePackage.getString(), "dataBaseName", null, 0, 1, ApplicationSchedular.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEAttribute(getApplicationSchedular_ServerName(), theXMLTypePackage.getString(), "serverName", null, 0, 1, ApplicationSchedular.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$

		initEClass(bpeContainerEClass, BPEContainer.class, "BPEContainer", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$
		initEAttribute(getBPEContainer_AdministratorSecurityRoleMapping(), theXMLTypePackage.getAnySimpleType(), "administratorSecurityRoleMapping", null, 0, 1, BPEContainer.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEAttribute(getBPEContainer_Classpath(), theXMLTypePackage.getAnySimpleType(), "classpath", null, 0, 1, BPEContainer.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEAttribute(getBPEContainer_DataSourcePassword(), theXMLTypePackage.getAnySimpleType(), "dataSourcePassword", null, 0, 1, BPEContainer.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEAttribute(getBPEContainer_DataSourceUsername(), theXMLTypePackage.getAnySimpleType(), "dataSourceUsername", null, 0, 1, BPEContainer.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEAttribute(getBPEContainer_EnableAuditLog(), theXMLTypePackage.getAnySimpleType(), "enableAuditLog", null, 0, 1, BPEContainer.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEAttribute(getBPEContainer_EnableCEIlogging(), theXMLTypePackage.getAnySimpleType(), "enableCEIlogging", null, 0, 1, BPEContainer.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEAttribute(getBPEContainer_ExternalRequestProcessingQueue(), theXMLTypePackage.getAnySimpleType(), "externalRequestProcessingQueue", null, 0, 1, BPEContainer.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEAttribute(getBPEContainer_HoldQueue(), theXMLTypePackage.getAnySimpleType(), "holdQueue", null, 0, 1, BPEContainer.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEAttribute(getBPEContainer_ImplementationClassName(), theXMLTypePackage.getAnySimpleType(), "implementationClassName", null, 0, 1, BPEContainer.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEAttribute(getBPEContainer_InstallBusinessProcessChoreographerExplorer(), theXMLTypePackage.getAnySimpleType(), "installBusinessProcessChoreographerExplorer", null, 0, 1, BPEContainer.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEAttribute(getBPEContainer_InternalQueue(), theXMLTypePackage.getAnySimpleType(), "internalQueue", null, 0, 1, BPEContainer.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEAttribute(getBPEContainer_JDBCProvider(), theXMLTypePackage.getAnySimpleType(), "jDBCProvider", null, 0, 1, BPEContainer.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEAttribute(getBPEContainer_JMSAPIPassword(), theXMLTypePackage.getAnySimpleType(), "jMSAPIPassword", null, 0, 1, BPEContainer.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEAttribute(getBPEContainer_JMSAPIUserID(), theXMLTypePackage.getAnySimpleType(), "jMSAPIUserID", null, 0, 1, BPEContainer.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEAttribute(getBPEContainer_JMSConnectionFactory(), theXMLTypePackage.getAnySimpleType(), "jMSConnectionFactory", null, 0, 1, BPEContainer.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEAttribute(getBPEContainer_JMSPassword(), theXMLTypePackage.getAnySimpleType(), "jMSPassword", null, 0, 1, BPEContainer.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEAttribute(getBPEContainer_JMSProvider(), theXMLTypePackage.getAnySimpleType(), "jMSProvider", null, 0, 1, BPEContainer.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEAttribute(getBPEContainer_JMSResources(), theXMLTypePackage.getAnySimpleType(), "jMSResources", null, 0, 1, BPEContainer.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEAttribute(getBPEContainer_JMSUserID(), theXMLTypePackage.getAnySimpleType(), "jMSUserID", null, 0, 1, BPEContainer.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEAttribute(getBPEContainer_QueueManager(), theXMLTypePackage.getAnySimpleType(), "queueManager", null, 0, 1, BPEContainer.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEAttribute(getBPEContainer_RetentionQueue(), theXMLTypePackage.getAnySimpleType(), "retentionQueue", null, 0, 1, BPEContainer.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEAttribute(getBPEContainer_SystemMonitorSecurityRoleMapping(), theXMLTypePackage.getAnySimpleType(), "systemMonitorSecurityRoleMapping", null, 0, 1, BPEContainer.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$

		initEClass(bpeContainerUnitEClass, BPEContainerUnit.class, "BPEContainerUnit", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$

		initEClass(businessRulesManagerEClass, BusinessRulesManager.class, "BusinessRulesManager", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$
		initEAttribute(getBusinessRulesManager_BusinessRulesManager(), theXMLTypePackage.getString(), "businessRulesManager", null, 0, 1, BusinessRulesManager.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$

		initEClass(businessRulesManagerUnitEClass, BusinessRulesManagerUnit.class, "BusinessRulesManagerUnit", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$

		initEClass(commonEventInfrastructureEClass, CommonEventInfrastructure.class, "CommonEventInfrastructure", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$
		initEAttribute(getCommonEventInfrastructure_Name1(), theXMLTypePackage.getAnySimpleType(), "name1", null, 0, 1, CommonEventInfrastructure.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$

		initEClass(extendedMessagingServiceEClass, ExtendedMessagingService.class, "ExtendedMessagingService", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$
		initEAttribute(getExtendedMessagingService_InputPort(), theXMLTypePackage.getString(), "inputPort", null, 0, 1, ExtendedMessagingService.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEAttribute(getExtendedMessagingService_OutputPort(), theXMLTypePackage.getString(), "outputPort", null, 0, 1, ExtendedMessagingService.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$

		initEClass(managingEventserviceEClass, ManagingEventservice.class, "ManagingEventservice", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$
		initEAttribute(getManagingEventservice_EventsInfrastructureEmitterFactoryJNDIName(), theXMLTypePackage.getString(), "eventsInfrastructureEmitterFactoryJNDIName", null, 0, 1, ManagingEventservice.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$

		initEClass(scaRuntimeEClass, SCARuntime.class, "SCARuntime", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$
		initEAttribute(getSCARuntime_InstallationPath(), theXMLTypePackage.getString(), "installationPath", null, 0, 1, SCARuntime.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$

		initEClass(sdoRuntimeEClass, SDORuntime.class, "SDORuntime", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$
		initEAttribute(getSDORuntime_InstallationPath(), theXMLTypePackage.getString(), "installationPath", null, 0, 1, SDORuntime.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$

		initEClass(taskContainerEClass, TaskContainer.class, "TaskContainer", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$
		initEAttribute(getTaskContainer_AdministratorSecurityRoleMapping(), theXMLTypePackage.getAnySimpleType(), "administratorSecurityRoleMapping", null, 0, 1, TaskContainer.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEAttribute(getTaskContainer_Classpath(), theXMLTypePackage.getAnySimpleType(), "classpath", null, 0, 1, TaskContainer.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEAttribute(getTaskContainer_EnableAuditLog(), theXMLTypePackage.getAnySimpleType(), "enableAuditLog", null, 0, 1, TaskContainer.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEAttribute(getTaskContainer_EnableCEIlogging(), theXMLTypePackage.getAnySimpleType(), "enableCEIlogging", null, 0, 1, TaskContainer.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEAttribute(getTaskContainer_Escalationpassword(), theXMLTypePackage.getAnySimpleType(), "escalationpassword", null, 0, 1, TaskContainer.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEAttribute(getTaskContainer_HoldQueue(), theXMLTypePackage.getAnySimpleType(), "holdQueue", null, 0, 1, TaskContainer.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEAttribute(getTaskContainer_JMSConnectionFactory(), theXMLTypePackage.getAnySimpleType(), "jMSConnectionFactory", null, 0, 1, TaskContainer.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEAttribute(getTaskContainer_JMSPassword(), theXMLTypePackage.getAnySimpleType(), "jMSPassword", null, 0, 1, TaskContainer.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEAttribute(getTaskContainer_JMSProvider(), theXMLTypePackage.getAnySimpleType(), "jMSProvider", null, 0, 1, TaskContainer.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEAttribute(getTaskContainer_JMSResources(), theXMLTypePackage.getAnySimpleType(), "jMSResources", null, 0, 1, TaskContainer.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEAttribute(getTaskContainer_JMSUserID(), theXMLTypePackage.getAnySimpleType(), "jMSUserID", null, 0, 1, TaskContainer.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEAttribute(getTaskContainer_MailSession(), theXMLTypePackage.getAnySimpleType(), "mailSession", null, 0, 1, TaskContainer.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEAttribute(getTaskContainer_QueueManager(), theXMLTypePackage.getAnySimpleType(), "queueManager", null, 0, 1, TaskContainer.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEAttribute(getTaskContainer_SystemMonitorSecurityRoleMapping(), theXMLTypePackage.getAnySimpleType(), "systemMonitorSecurityRoleMapping", null, 0, 1, TaskContainer.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$

		initEClass(taskContainerUnitEClass, TaskContainerUnit.class, "TaskContainerUnit", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$

		initEClass(webSphereBusinessIntegrationAdaptersServiceEClass, WebSphereBusinessIntegrationAdaptersService.class, "WebSphereBusinessIntegrationAdaptersService", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$
		initEAttribute(getWebSphereBusinessIntegrationAdaptersService_InputQueueJNDIName(), theXMLTypePackage.getString(), "inputQueueJNDIName", null, 0, 1, WebSphereBusinessIntegrationAdaptersService.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEAttribute(getWebSphereBusinessIntegrationAdaptersService_JNDIName(), theXMLTypePackage.getString(), "jNDIName", null, 0, 1, WebSphereBusinessIntegrationAdaptersService.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEAttribute(getWebSphereBusinessIntegrationAdaptersService_Name1(), theXMLTypePackage.getString(), "name1", null, 0, 1, WebSphereBusinessIntegrationAdaptersService.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEAttribute(getWebSphereBusinessIntegrationAdaptersService_OutputQueueJNDIName(), theXMLTypePackage.getString(), "outputQueueJNDIName", null, 0, 1, WebSphereBusinessIntegrationAdaptersService.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEAttribute(getWebSphereBusinessIntegrationAdaptersService_Timeout(), theXMLTypePackage.getString(), "timeout", null, 0, 1, WebSphereBusinessIntegrationAdaptersService.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$

		initEClass(wpsBaseSystemEClass, WpsBaseSystem.class, "WpsBaseSystem", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$
		initEAttribute(getWpsBaseSystem_InstallLocation(), theXMLTypePackage.getString(), "installLocation", null, 0, 1, WpsBaseSystem.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEAttribute(getWpsBaseSystem_ProfileDir(), theXMLTypePackage.getString(), "profileDir", null, 0, 1, WpsBaseSystem.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEAttribute(getWpsBaseSystem_Version(), theXMLTypePackage.getString(), "version", null, 0, 1, WpsBaseSystem.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$

		initEClass(wpsBaseSystemUnitEClass, WpsBaseSystemUnit.class, "WpsBaseSystemUnit", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$

		initEClass(wpsCommonEventInfrastructureUnitEClass, WPSCommonEventInfrastructureUnit.class, "WPSCommonEventInfrastructureUnit", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$

		initEClass(wpsesbEClass, com.ibm.ccl.soa.deploy.wps.WPSESB.class, "WPSESB", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$
		initEAttribute(getWPSESB_Name1(), theXMLTypePackage.getString(), "name1", null, 0, 1, com.ibm.ccl.soa.deploy.wps.WPSESB.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$

		initEClass(wpsesbUnitEClass, WPSESBUnit.class, "WPSESBUnit", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$

		initEClass(wpsRootEClass, WPSRoot.class, "WPSRoot", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$
		initEAttribute(getWPSRoot_Mixed(), ecorePackage.getEFeatureMapEntry(), "mixed", null, 0, -1, null, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEReference(getWPSRoot_XMLNSPrefixMap(), ecorePackage.getEStringToStringMapEntry(), null, "xMLNSPrefixMap", null, 0, -1, null, IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEReference(getWPSRoot_XSISchemaLocation(), ecorePackage.getEStringToStringMapEntry(), null, "xSISchemaLocation", null, 0, -1, null, IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEReference(getWPSRoot_CapabilityApplicationSchedular(), this.getApplicationSchedular(), null, "capabilityApplicationSchedular", null, 0, -2, null, IS_TRANSIENT, IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEReference(getWPSRoot_CapabilityBPEContainer(), this.getBPEContainer(), null, "capabilityBPEContainer", null, 0, -2, null, IS_TRANSIENT, IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEReference(getWPSRoot_CapabilityBusinessRulesManager(), this.getBusinessRulesManager(), null, "capabilityBusinessRulesManager", null, 0, -2, null, IS_TRANSIENT, IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEReference(getWPSRoot_CapabilityCommonEventInfrastructure(), this.getCommonEventInfrastructure(), null, "capabilityCommonEventInfrastructure", null, 0, -2, null, IS_TRANSIENT, IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEReference(getWPSRoot_CapabilityExtendedMessagingService(), this.getExtendedMessagingService(), null, "capabilityExtendedMessagingService", null, 0, -2, null, IS_TRANSIENT, IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEReference(getWPSRoot_CapabilityManagingEventService(), this.getManagingEventservice(), null, "capabilityManagingEventService", null, 0, -2, null, IS_TRANSIENT, IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEReference(getWPSRoot_CapabilitySCARuntime(), this.getSCARuntime(), null, "capabilitySCARuntime", null, 0, -2, null, IS_TRANSIENT, IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEReference(getWPSRoot_CapabilitySDORuntime(), this.getSDORuntime(), null, "capabilitySDORuntime", null, 0, -2, null, IS_TRANSIENT, IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEReference(getWPSRoot_CapabilityTaskContainer(), this.getTaskContainer(), null, "capabilityTaskContainer", null, 0, -2, null, IS_TRANSIENT, IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEReference(getWPSRoot_CapabilityWebSphereBusinessIntegrationAdaptersService(), this.getWebSphereBusinessIntegrationAdaptersService(), null, "capabilityWebSphereBusinessIntegrationAdaptersService", null, 0, -2, null, IS_TRANSIENT, IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEReference(getWPSRoot_CapabilityWpsBaseSystem(), this.getWpsBaseSystem(), null, "capabilityWpsBaseSystem", null, 0, -2, null, IS_TRANSIENT, IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEReference(getWPSRoot_CapabilityWPSESB(), this.getWPSESB(), null, "capabilityWPSESB", null, 0, -2, null, IS_TRANSIENT, IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEReference(getWPSRoot_CapabilityWPSSIB(), this.getWPSSIB(), null, "capabilityWPSSIB", null, 0, -2, null, IS_TRANSIENT, IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEReference(getWPSRoot_UnitBPEContainerUnit(), this.getBPEContainerUnit(), null, "unitBPEContainerUnit", null, 0, -2, null, IS_TRANSIENT, IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEReference(getWPSRoot_UnitBusinessRulesManagerUnit(), this.getBusinessRulesManagerUnit(), null, "unitBusinessRulesManagerUnit", null, 0, -2, null, IS_TRANSIENT, IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEReference(getWPSRoot_UnitTaskContainerUnit(), this.getTaskContainerUnit(), null, "unitTaskContainerUnit", null, 0, -2, null, IS_TRANSIENT, IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEReference(getWPSRoot_UnitWpsBaseSystemUnit(), this.getWpsBaseSystemUnit(), null, "unitWpsBaseSystemUnit", null, 0, -2, null, IS_TRANSIENT, IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEReference(getWPSRoot_UnitWPSCommonEventInfrastructureUnit(), this.getWPSCommonEventInfrastructureUnit(), null, "unitWPSCommonEventInfrastructureUnit", null, 0, -2, null, IS_TRANSIENT, IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEReference(getWPSRoot_UnitWPSESBUnit(), this.getWPSESBUnit(), null, "unitWPSESBUnit", null, 0, -2, null, IS_TRANSIENT, IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEReference(getWPSRoot_UnitWPSSIBUnit(), this.getWPSSIBUnit(), null, "unitWPSSIBUnit", null, 0, -2, null, IS_TRANSIENT, IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEReference(getWPSRoot_UnitWpsSystemUnit(), this.getWpsSystemUnit(), null, "unitWpsSystemUnit", null, 0, -2, null, IS_TRANSIENT, IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, IS_DERIVED, IS_ORDERED); //$NON-NLS-1$

		initEClass(wpssibEClass, com.ibm.ccl.soa.deploy.wps.WPSSIB.class, "WPSSIB", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$
		initEAttribute(getWPSSIB_Name1(), theXMLTypePackage.getString(), "name1", null, 0, 1, com.ibm.ccl.soa.deploy.wps.WPSSIB.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$

		initEClass(wpssibUnitEClass, WPSSIBUnit.class, "WPSSIBUnit", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$

		initEClass(wpsSystemUnitEClass, WpsSystemUnit.class, "WpsSystemUnit", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$

		// Create resource
		createResource(eNS_URI);

		// Create annotations
		// http:///org/eclipse/emf/ecore/util/ExtendedMetaData
		createExtendedMetaDataAnnotations();
	}

	/**
	 * Initializes the annotations for <b>http:///org/eclipse/emf/ecore/util/ExtendedMetaData</b>.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void createExtendedMetaDataAnnotations() {
		String source = "http:///org/eclipse/emf/ecore/util/ExtendedMetaData"; //$NON-NLS-1$			
		addAnnotation
		  (applicationSchedularEClass, 
		   source, 
		   new String[] {
			 "name", "ApplicationSchedular", //$NON-NLS-1$ //$NON-NLS-2$
			 "kind", "elementOnly" //$NON-NLS-1$ //$NON-NLS-2$
		   });		
		addAnnotation
		  (getApplicationSchedular_DataBaseName(), 
		   source, 
		   new String[] {
			 "kind", "attribute", //$NON-NLS-1$ //$NON-NLS-2$
			 "name", "DataBaseName" //$NON-NLS-1$ //$NON-NLS-2$
		   });		
		addAnnotation
		  (getApplicationSchedular_ServerName(), 
		   source, 
		   new String[] {
			 "kind", "attribute", //$NON-NLS-1$ //$NON-NLS-2$
			 "name", "ServerName" //$NON-NLS-1$ //$NON-NLS-2$
		   });		
		addAnnotation
		  (bpeContainerEClass, 
		   source, 
		   new String[] {
			 "name", "BPEContainer", //$NON-NLS-1$ //$NON-NLS-2$
			 "kind", "elementOnly" //$NON-NLS-1$ //$NON-NLS-2$
		   });		
		addAnnotation
		  (getBPEContainer_AdministratorSecurityRoleMapping(), 
		   source, 
		   new String[] {
			 "kind", "attribute", //$NON-NLS-1$ //$NON-NLS-2$
			 "name", "AdministratorSecurityRoleMapping" //$NON-NLS-1$ //$NON-NLS-2$
		   });		
		addAnnotation
		  (getBPEContainer_Classpath(), 
		   source, 
		   new String[] {
			 "kind", "attribute", //$NON-NLS-1$ //$NON-NLS-2$
			 "name", "Classpath" //$NON-NLS-1$ //$NON-NLS-2$
		   });		
		addAnnotation
		  (getBPEContainer_DataSourcePassword(), 
		   source, 
		   new String[] {
			 "kind", "attribute", //$NON-NLS-1$ //$NON-NLS-2$
			 "name", "DataSourcePassword" //$NON-NLS-1$ //$NON-NLS-2$
		   });		
		addAnnotation
		  (getBPEContainer_DataSourceUsername(), 
		   source, 
		   new String[] {
			 "kind", "attribute", //$NON-NLS-1$ //$NON-NLS-2$
			 "name", "DataSourceUsername" //$NON-NLS-1$ //$NON-NLS-2$
		   });		
		addAnnotation
		  (getBPEContainer_EnableAuditLog(), 
		   source, 
		   new String[] {
			 "kind", "attribute", //$NON-NLS-1$ //$NON-NLS-2$
			 "name", "EnableAuditLog" //$NON-NLS-1$ //$NON-NLS-2$
		   });		
		addAnnotation
		  (getBPEContainer_EnableCEIlogging(), 
		   source, 
		   new String[] {
			 "kind", "attribute", //$NON-NLS-1$ //$NON-NLS-2$
			 "name", "EnableCEIlogging" //$NON-NLS-1$ //$NON-NLS-2$
		   });		
		addAnnotation
		  (getBPEContainer_ExternalRequestProcessingQueue(), 
		   source, 
		   new String[] {
			 "kind", "attribute", //$NON-NLS-1$ //$NON-NLS-2$
			 "name", "ExternalRequestProcessingQueue" //$NON-NLS-1$ //$NON-NLS-2$
		   });		
		addAnnotation
		  (getBPEContainer_HoldQueue(), 
		   source, 
		   new String[] {
			 "kind", "attribute", //$NON-NLS-1$ //$NON-NLS-2$
			 "name", "HoldQueue" //$NON-NLS-1$ //$NON-NLS-2$
		   });		
		addAnnotation
		  (getBPEContainer_ImplementationClassName(), 
		   source, 
		   new String[] {
			 "kind", "attribute", //$NON-NLS-1$ //$NON-NLS-2$
			 "name", "ImplementationClassName" //$NON-NLS-1$ //$NON-NLS-2$
		   });		
		addAnnotation
		  (getBPEContainer_InstallBusinessProcessChoreographerExplorer(), 
		   source, 
		   new String[] {
			 "kind", "attribute", //$NON-NLS-1$ //$NON-NLS-2$
			 "name", "InstallBusinessProcessChoreographerExplorer" //$NON-NLS-1$ //$NON-NLS-2$
		   });		
		addAnnotation
		  (getBPEContainer_InternalQueue(), 
		   source, 
		   new String[] {
			 "kind", "attribute", //$NON-NLS-1$ //$NON-NLS-2$
			 "name", "InternalQueue" //$NON-NLS-1$ //$NON-NLS-2$
		   });		
		addAnnotation
		  (getBPEContainer_JDBCProvider(), 
		   source, 
		   new String[] {
			 "kind", "attribute", //$NON-NLS-1$ //$NON-NLS-2$
			 "name", "JDBCProvider" //$NON-NLS-1$ //$NON-NLS-2$
		   });		
		addAnnotation
		  (getBPEContainer_JMSAPIPassword(), 
		   source, 
		   new String[] {
			 "kind", "attribute", //$NON-NLS-1$ //$NON-NLS-2$
			 "name", "JMSAPIPassword" //$NON-NLS-1$ //$NON-NLS-2$
		   });		
		addAnnotation
		  (getBPEContainer_JMSAPIUserID(), 
		   source, 
		   new String[] {
			 "kind", "attribute", //$NON-NLS-1$ //$NON-NLS-2$
			 "name", "JMSAPIUserID" //$NON-NLS-1$ //$NON-NLS-2$
		   });		
		addAnnotation
		  (getBPEContainer_JMSConnectionFactory(), 
		   source, 
		   new String[] {
			 "kind", "attribute", //$NON-NLS-1$ //$NON-NLS-2$
			 "name", "JMSConnectionFactory" //$NON-NLS-1$ //$NON-NLS-2$
		   });		
		addAnnotation
		  (getBPEContainer_JMSPassword(), 
		   source, 
		   new String[] {
			 "kind", "attribute", //$NON-NLS-1$ //$NON-NLS-2$
			 "name", "JMSPassword" //$NON-NLS-1$ //$NON-NLS-2$
		   });		
		addAnnotation
		  (getBPEContainer_JMSProvider(), 
		   source, 
		   new String[] {
			 "kind", "attribute", //$NON-NLS-1$ //$NON-NLS-2$
			 "name", "JMSProvider" //$NON-NLS-1$ //$NON-NLS-2$
		   });		
		addAnnotation
		  (getBPEContainer_JMSResources(), 
		   source, 
		   new String[] {
			 "kind", "attribute", //$NON-NLS-1$ //$NON-NLS-2$
			 "name", "JMSResources" //$NON-NLS-1$ //$NON-NLS-2$
		   });		
		addAnnotation
		  (getBPEContainer_JMSUserID(), 
		   source, 
		   new String[] {
			 "kind", "attribute", //$NON-NLS-1$ //$NON-NLS-2$
			 "name", "JMSUserID" //$NON-NLS-1$ //$NON-NLS-2$
		   });		
		addAnnotation
		  (getBPEContainer_QueueManager(), 
		   source, 
		   new String[] {
			 "kind", "attribute", //$NON-NLS-1$ //$NON-NLS-2$
			 "name", "QueueManager" //$NON-NLS-1$ //$NON-NLS-2$
		   });		
		addAnnotation
		  (getBPEContainer_RetentionQueue(), 
		   source, 
		   new String[] {
			 "kind", "attribute", //$NON-NLS-1$ //$NON-NLS-2$
			 "name", "RetentionQueue" //$NON-NLS-1$ //$NON-NLS-2$
		   });		
		addAnnotation
		  (getBPEContainer_SystemMonitorSecurityRoleMapping(), 
		   source, 
		   new String[] {
			 "kind", "attribute", //$NON-NLS-1$ //$NON-NLS-2$
			 "name", "SystemMonitorSecurityRoleMapping" //$NON-NLS-1$ //$NON-NLS-2$
		   });		
		addAnnotation
		  (bpeContainerUnitEClass, 
		   source, 
		   new String[] {
			 "name", "BPEContainerUnit", //$NON-NLS-1$ //$NON-NLS-2$
			 "kind", "elementOnly" //$NON-NLS-1$ //$NON-NLS-2$
		   });		
		addAnnotation
		  (businessRulesManagerEClass, 
		   source, 
		   new String[] {
			 "name", "BusinessRulesManager", //$NON-NLS-1$ //$NON-NLS-2$
			 "kind", "elementOnly" //$NON-NLS-1$ //$NON-NLS-2$
		   });		
		addAnnotation
		  (getBusinessRulesManager_BusinessRulesManager(), 
		   source, 
		   new String[] {
			 "kind", "attribute", //$NON-NLS-1$ //$NON-NLS-2$
			 "name", "BusinessRulesManager" //$NON-NLS-1$ //$NON-NLS-2$
		   });		
		addAnnotation
		  (businessRulesManagerUnitEClass, 
		   source, 
		   new String[] {
			 "name", "BusinessRulesManagerUnit", //$NON-NLS-1$ //$NON-NLS-2$
			 "kind", "elementOnly" //$NON-NLS-1$ //$NON-NLS-2$
		   });		
		addAnnotation
		  (commonEventInfrastructureEClass, 
		   source, 
		   new String[] {
			 "name", "CommonEventInfrastructure", //$NON-NLS-1$ //$NON-NLS-2$
			 "kind", "elementOnly" //$NON-NLS-1$ //$NON-NLS-2$
		   });		
		addAnnotation
		  (getCommonEventInfrastructure_Name1(), 
		   source, 
		   new String[] {
			 "kind", "attribute", //$NON-NLS-1$ //$NON-NLS-2$
			 "name", "Name" //$NON-NLS-1$ //$NON-NLS-2$
		   });		
		addAnnotation
		  (extendedMessagingServiceEClass, 
		   source, 
		   new String[] {
			 "name", "ExtendedMessagingService", //$NON-NLS-1$ //$NON-NLS-2$
			 "kind", "elementOnly" //$NON-NLS-1$ //$NON-NLS-2$
		   });		
		addAnnotation
		  (getExtendedMessagingService_InputPort(), 
		   source, 
		   new String[] {
			 "kind", "attribute", //$NON-NLS-1$ //$NON-NLS-2$
			 "name", "InputPort" //$NON-NLS-1$ //$NON-NLS-2$
		   });		
		addAnnotation
		  (getExtendedMessagingService_OutputPort(), 
		   source, 
		   new String[] {
			 "kind", "attribute", //$NON-NLS-1$ //$NON-NLS-2$
			 "name", "OutputPort" //$NON-NLS-1$ //$NON-NLS-2$
		   });		
		addAnnotation
		  (managingEventserviceEClass, 
		   source, 
		   new String[] {
			 "name", "ManagingEventservice", //$NON-NLS-1$ //$NON-NLS-2$
			 "kind", "elementOnly" //$NON-NLS-1$ //$NON-NLS-2$
		   });		
		addAnnotation
		  (getManagingEventservice_EventsInfrastructureEmitterFactoryJNDIName(), 
		   source, 
		   new String[] {
			 "kind", "attribute", //$NON-NLS-1$ //$NON-NLS-2$
			 "name", "EventsInfrastructureEmitterFactoryJNDIName" //$NON-NLS-1$ //$NON-NLS-2$
		   });		
		addAnnotation
		  (scaRuntimeEClass, 
		   source, 
		   new String[] {
			 "name", "SCARuntime", //$NON-NLS-1$ //$NON-NLS-2$
			 "kind", "elementOnly" //$NON-NLS-1$ //$NON-NLS-2$
		   });		
		addAnnotation
		  (getSCARuntime_InstallationPath(), 
		   source, 
		   new String[] {
			 "kind", "attribute", //$NON-NLS-1$ //$NON-NLS-2$
			 "name", "InstallationPath" //$NON-NLS-1$ //$NON-NLS-2$
		   });		
		addAnnotation
		  (sdoRuntimeEClass, 
		   source, 
		   new String[] {
			 "name", "SDORuntime", //$NON-NLS-1$ //$NON-NLS-2$
			 "kind", "elementOnly" //$NON-NLS-1$ //$NON-NLS-2$
		   });		
		addAnnotation
		  (getSDORuntime_InstallationPath(), 
		   source, 
		   new String[] {
			 "kind", "attribute", //$NON-NLS-1$ //$NON-NLS-2$
			 "name", "InstallationPath" //$NON-NLS-1$ //$NON-NLS-2$
		   });		
		addAnnotation
		  (taskContainerEClass, 
		   source, 
		   new String[] {
			 "name", "TaskContainer", //$NON-NLS-1$ //$NON-NLS-2$
			 "kind", "elementOnly" //$NON-NLS-1$ //$NON-NLS-2$
		   });		
		addAnnotation
		  (getTaskContainer_AdministratorSecurityRoleMapping(), 
		   source, 
		   new String[] {
			 "kind", "attribute", //$NON-NLS-1$ //$NON-NLS-2$
			 "name", "AdministratorSecurityRoleMapping" //$NON-NLS-1$ //$NON-NLS-2$
		   });		
		addAnnotation
		  (getTaskContainer_Classpath(), 
		   source, 
		   new String[] {
			 "kind", "attribute", //$NON-NLS-1$ //$NON-NLS-2$
			 "name", "Classpath" //$NON-NLS-1$ //$NON-NLS-2$
		   });		
		addAnnotation
		  (getTaskContainer_EnableAuditLog(), 
		   source, 
		   new String[] {
			 "kind", "attribute", //$NON-NLS-1$ //$NON-NLS-2$
			 "name", "EnableAuditLog" //$NON-NLS-1$ //$NON-NLS-2$
		   });		
		addAnnotation
		  (getTaskContainer_EnableCEIlogging(), 
		   source, 
		   new String[] {
			 "kind", "attribute", //$NON-NLS-1$ //$NON-NLS-2$
			 "name", "EnableCEIlogging" //$NON-NLS-1$ //$NON-NLS-2$
		   });		
		addAnnotation
		  (getTaskContainer_Escalationpassword(), 
		   source, 
		   new String[] {
			 "kind", "attribute", //$NON-NLS-1$ //$NON-NLS-2$
			 "name", "Escalationpassword" //$NON-NLS-1$ //$NON-NLS-2$
		   });		
		addAnnotation
		  (getTaskContainer_HoldQueue(), 
		   source, 
		   new String[] {
			 "kind", "attribute", //$NON-NLS-1$ //$NON-NLS-2$
			 "name", "HoldQueue" //$NON-NLS-1$ //$NON-NLS-2$
		   });		
		addAnnotation
		  (getTaskContainer_JMSConnectionFactory(), 
		   source, 
		   new String[] {
			 "kind", "attribute", //$NON-NLS-1$ //$NON-NLS-2$
			 "name", "JMSConnectionFactory" //$NON-NLS-1$ //$NON-NLS-2$
		   });		
		addAnnotation
		  (getTaskContainer_JMSPassword(), 
		   source, 
		   new String[] {
			 "kind", "attribute", //$NON-NLS-1$ //$NON-NLS-2$
			 "name", "JMSPassword" //$NON-NLS-1$ //$NON-NLS-2$
		   });		
		addAnnotation
		  (getTaskContainer_JMSProvider(), 
		   source, 
		   new String[] {
			 "kind", "attribute", //$NON-NLS-1$ //$NON-NLS-2$
			 "name", "JMSProvider" //$NON-NLS-1$ //$NON-NLS-2$
		   });		
		addAnnotation
		  (getTaskContainer_JMSResources(), 
		   source, 
		   new String[] {
			 "kind", "attribute", //$NON-NLS-1$ //$NON-NLS-2$
			 "name", "JMSResources" //$NON-NLS-1$ //$NON-NLS-2$
		   });		
		addAnnotation
		  (getTaskContainer_JMSUserID(), 
		   source, 
		   new String[] {
			 "kind", "attribute", //$NON-NLS-1$ //$NON-NLS-2$
			 "name", "JMSUserID" //$NON-NLS-1$ //$NON-NLS-2$
		   });		
		addAnnotation
		  (getTaskContainer_MailSession(), 
		   source, 
		   new String[] {
			 "kind", "attribute", //$NON-NLS-1$ //$NON-NLS-2$
			 "name", "MailSession" //$NON-NLS-1$ //$NON-NLS-2$
		   });		
		addAnnotation
		  (getTaskContainer_QueueManager(), 
		   source, 
		   new String[] {
			 "kind", "attribute", //$NON-NLS-1$ //$NON-NLS-2$
			 "name", "QueueManager" //$NON-NLS-1$ //$NON-NLS-2$
		   });		
		addAnnotation
		  (getTaskContainer_SystemMonitorSecurityRoleMapping(), 
		   source, 
		   new String[] {
			 "kind", "attribute", //$NON-NLS-1$ //$NON-NLS-2$
			 "name", "SystemMonitorSecurityRoleMapping" //$NON-NLS-1$ //$NON-NLS-2$
		   });		
		addAnnotation
		  (taskContainerUnitEClass, 
		   source, 
		   new String[] {
			 "name", "TaskContainerUnit", //$NON-NLS-1$ //$NON-NLS-2$
			 "kind", "elementOnly" //$NON-NLS-1$ //$NON-NLS-2$
		   });		
		addAnnotation
		  (webSphereBusinessIntegrationAdaptersServiceEClass, 
		   source, 
		   new String[] {
			 "name", "WebSphereBusinessIntegrationAdaptersService", //$NON-NLS-1$ //$NON-NLS-2$
			 "kind", "elementOnly" //$NON-NLS-1$ //$NON-NLS-2$
		   });		
		addAnnotation
		  (getWebSphereBusinessIntegrationAdaptersService_InputQueueJNDIName(), 
		   source, 
		   new String[] {
			 "kind", "attribute", //$NON-NLS-1$ //$NON-NLS-2$
			 "name", "InputQueueJNDIName" //$NON-NLS-1$ //$NON-NLS-2$
		   });		
		addAnnotation
		  (getWebSphereBusinessIntegrationAdaptersService_JNDIName(), 
		   source, 
		   new String[] {
			 "kind", "attribute", //$NON-NLS-1$ //$NON-NLS-2$
			 "name", "JNDIName" //$NON-NLS-1$ //$NON-NLS-2$
		   });		
		addAnnotation
		  (getWebSphereBusinessIntegrationAdaptersService_Name1(), 
		   source, 
		   new String[] {
			 "kind", "attribute", //$NON-NLS-1$ //$NON-NLS-2$
			 "name", "Name" //$NON-NLS-1$ //$NON-NLS-2$
		   });		
		addAnnotation
		  (getWebSphereBusinessIntegrationAdaptersService_OutputQueueJNDIName(), 
		   source, 
		   new String[] {
			 "kind", "attribute", //$NON-NLS-1$ //$NON-NLS-2$
			 "name", "OutputQueueJNDIName" //$NON-NLS-1$ //$NON-NLS-2$
		   });		
		addAnnotation
		  (getWebSphereBusinessIntegrationAdaptersService_Timeout(), 
		   source, 
		   new String[] {
			 "kind", "attribute", //$NON-NLS-1$ //$NON-NLS-2$
			 "name", "Timeout" //$NON-NLS-1$ //$NON-NLS-2$
		   });		
		addAnnotation
		  (wpsBaseSystemEClass, 
		   source, 
		   new String[] {
			 "name", "WpsBaseSystem", //$NON-NLS-1$ //$NON-NLS-2$
			 "kind", "elementOnly" //$NON-NLS-1$ //$NON-NLS-2$
		   });			
		addAnnotation
		  (getWpsBaseSystem_InstallLocation(), 
		   source, 
		   new String[] {
			 "kind", "attribute", //$NON-NLS-1$ //$NON-NLS-2$
			 "name", "installLocation" //$NON-NLS-1$ //$NON-NLS-2$
		   });		
		addAnnotation
		  (getWpsBaseSystem_ProfileDir(), 
		   source, 
		   new String[] {
			 "kind", "attribute", //$NON-NLS-1$ //$NON-NLS-2$
			 "name", "ProfileDir" //$NON-NLS-1$ //$NON-NLS-2$
		   });		
		addAnnotation
		  (getWpsBaseSystem_Version(), 
		   source, 
		   new String[] {
			 "kind", "attribute", //$NON-NLS-1$ //$NON-NLS-2$
			 "name", "version" //$NON-NLS-1$ //$NON-NLS-2$
		   });			
		addAnnotation
		  (wpsBaseSystemUnitEClass, 
		   source, 
		   new String[] {
			 "name", "WpsBaseSystemUnit", //$NON-NLS-1$ //$NON-NLS-2$
			 "kind", "elementOnly" //$NON-NLS-1$ //$NON-NLS-2$
		   });		
		addAnnotation
		  (wpsCommonEventInfrastructureUnitEClass, 
		   source, 
		   new String[] {
			 "name", "WPSCommonEventInfrastructureUnit", //$NON-NLS-1$ //$NON-NLS-2$
			 "kind", "elementOnly" //$NON-NLS-1$ //$NON-NLS-2$
		   });		
		addAnnotation
		  (wpsesbEClass, 
		   source, 
		   new String[] {
			 "name", "WPSESB", //$NON-NLS-1$ //$NON-NLS-2$
			 "kind", "elementOnly" //$NON-NLS-1$ //$NON-NLS-2$
		   });		
		addAnnotation
		  (getWPSESB_Name1(), 
		   source, 
		   new String[] {
			 "kind", "attribute", //$NON-NLS-1$ //$NON-NLS-2$
			 "name", "Name" //$NON-NLS-1$ //$NON-NLS-2$
		   });		
		addAnnotation
		  (wpsesbUnitEClass, 
		   source, 
		   new String[] {
			 "name", "WPSESBUnit", //$NON-NLS-1$ //$NON-NLS-2$
			 "kind", "elementOnly" //$NON-NLS-1$ //$NON-NLS-2$
		   });		
		addAnnotation
		  (wpsRootEClass, 
		   source, 
		   new String[] {
			 "name", "", //$NON-NLS-1$ //$NON-NLS-2$
			 "kind", "mixed" //$NON-NLS-1$ //$NON-NLS-2$
		   });		
		addAnnotation
		  (getWPSRoot_Mixed(), 
		   source, 
		   new String[] {
			 "kind", "elementWildcard", //$NON-NLS-1$ //$NON-NLS-2$
			 "name", ":mixed" //$NON-NLS-1$ //$NON-NLS-2$
		   });		
		addAnnotation
		  (getWPSRoot_XMLNSPrefixMap(), 
		   source, 
		   new String[] {
			 "kind", "attribute", //$NON-NLS-1$ //$NON-NLS-2$
			 "name", "xmlns:prefix" //$NON-NLS-1$ //$NON-NLS-2$
		   });		
		addAnnotation
		  (getWPSRoot_XSISchemaLocation(), 
		   source, 
		   new String[] {
			 "kind", "attribute", //$NON-NLS-1$ //$NON-NLS-2$
			 "name", "xsi:schemaLocation" //$NON-NLS-1$ //$NON-NLS-2$
		   });		
		addAnnotation
		  (getWPSRoot_CapabilityApplicationSchedular(), 
		   source, 
		   new String[] {
			 "kind", "element", //$NON-NLS-1$ //$NON-NLS-2$
			 "name", "capability.applicationSchedular", //$NON-NLS-1$ //$NON-NLS-2$
			 "namespace", "##targetNamespace", //$NON-NLS-1$ //$NON-NLS-2$
			 "affiliation", "http://www.ibm.com/ccl/soa/deploy/core/1.0.0/#capability" //$NON-NLS-1$ //$NON-NLS-2$
		   });		
		addAnnotation
		  (getWPSRoot_CapabilityBPEContainer(), 
		   source, 
		   new String[] {
			 "kind", "element", //$NON-NLS-1$ //$NON-NLS-2$
			 "name", "capability.BPEContainer", //$NON-NLS-1$ //$NON-NLS-2$
			 "namespace", "##targetNamespace", //$NON-NLS-1$ //$NON-NLS-2$
			 "affiliation", "http://www.ibm.com/ccl/soa/deploy/core/1.0.0/#capability" //$NON-NLS-1$ //$NON-NLS-2$
		   });		
		addAnnotation
		  (getWPSRoot_CapabilityBusinessRulesManager(), 
		   source, 
		   new String[] {
			 "kind", "element", //$NON-NLS-1$ //$NON-NLS-2$
			 "name", "capability.BusinessRulesManager", //$NON-NLS-1$ //$NON-NLS-2$
			 "namespace", "##targetNamespace", //$NON-NLS-1$ //$NON-NLS-2$
			 "affiliation", "http://www.ibm.com/ccl/soa/deploy/core/1.0.0/#capability" //$NON-NLS-1$ //$NON-NLS-2$
		   });		
		addAnnotation
		  (getWPSRoot_CapabilityCommonEventInfrastructure(), 
		   source, 
		   new String[] {
			 "kind", "element", //$NON-NLS-1$ //$NON-NLS-2$
			 "name", "capability.CommonEventInfrastructure", //$NON-NLS-1$ //$NON-NLS-2$
			 "namespace", "##targetNamespace", //$NON-NLS-1$ //$NON-NLS-2$
			 "affiliation", "http://www.ibm.com/ccl/soa/deploy/core/1.0.0/#capability" //$NON-NLS-1$ //$NON-NLS-2$
		   });		
		addAnnotation
		  (getWPSRoot_CapabilityExtendedMessagingService(), 
		   source, 
		   new String[] {
			 "kind", "element", //$NON-NLS-1$ //$NON-NLS-2$
			 "name", "capability.ExtendedMessagingService", //$NON-NLS-1$ //$NON-NLS-2$
			 "namespace", "##targetNamespace", //$NON-NLS-1$ //$NON-NLS-2$
			 "affiliation", "http://www.ibm.com/ccl/soa/deploy/core/1.0.0/#capability" //$NON-NLS-1$ //$NON-NLS-2$
		   });		
		addAnnotation
		  (getWPSRoot_CapabilityManagingEventService(), 
		   source, 
		   new String[] {
			 "kind", "element", //$NON-NLS-1$ //$NON-NLS-2$
			 "name", "capability.ManagingEventService", //$NON-NLS-1$ //$NON-NLS-2$
			 "namespace", "##targetNamespace", //$NON-NLS-1$ //$NON-NLS-2$
			 "affiliation", "http://www.ibm.com/ccl/soa/deploy/core/1.0.0/#capability" //$NON-NLS-1$ //$NON-NLS-2$
		   });		
		addAnnotation
		  (getWPSRoot_CapabilitySCARuntime(), 
		   source, 
		   new String[] {
			 "kind", "element", //$NON-NLS-1$ //$NON-NLS-2$
			 "name", "capability.SCARuntime", //$NON-NLS-1$ //$NON-NLS-2$
			 "namespace", "##targetNamespace", //$NON-NLS-1$ //$NON-NLS-2$
			 "affiliation", "http://www.ibm.com/ccl/soa/deploy/core/1.0.0/#capability" //$NON-NLS-1$ //$NON-NLS-2$
		   });		
		addAnnotation
		  (getWPSRoot_CapabilitySDORuntime(), 
		   source, 
		   new String[] {
			 "kind", "element", //$NON-NLS-1$ //$NON-NLS-2$
			 "name", "capability.SDORuntime", //$NON-NLS-1$ //$NON-NLS-2$
			 "namespace", "##targetNamespace", //$NON-NLS-1$ //$NON-NLS-2$
			 "affiliation", "http://www.ibm.com/ccl/soa/deploy/core/1.0.0/#capability" //$NON-NLS-1$ //$NON-NLS-2$
		   });		
		addAnnotation
		  (getWPSRoot_CapabilityTaskContainer(), 
		   source, 
		   new String[] {
			 "kind", "element", //$NON-NLS-1$ //$NON-NLS-2$
			 "name", "capability.TaskContainer", //$NON-NLS-1$ //$NON-NLS-2$
			 "namespace", "##targetNamespace", //$NON-NLS-1$ //$NON-NLS-2$
			 "affiliation", "http://www.ibm.com/ccl/soa/deploy/core/1.0.0/#capability" //$NON-NLS-1$ //$NON-NLS-2$
		   });		
		addAnnotation
		  (getWPSRoot_CapabilityWebSphereBusinessIntegrationAdaptersService(), 
		   source, 
		   new String[] {
			 "kind", "element", //$NON-NLS-1$ //$NON-NLS-2$
			 "name", "capability.WebSphereBusinessIntegrationAdaptersService", //$NON-NLS-1$ //$NON-NLS-2$
			 "namespace", "##targetNamespace", //$NON-NLS-1$ //$NON-NLS-2$
			 "affiliation", "http://www.ibm.com/ccl/soa/deploy/core/1.0.0/#capability" //$NON-NLS-1$ //$NON-NLS-2$
		   });		
		addAnnotation
		  (getWPSRoot_CapabilityWpsBaseSystem(), 
		   source, 
		   new String[] {
			 "kind", "element", //$NON-NLS-1$ //$NON-NLS-2$
			 "name", "capability.wpsBaseSystem", //$NON-NLS-1$ //$NON-NLS-2$
			 "namespace", "##targetNamespace", //$NON-NLS-1$ //$NON-NLS-2$
			 "affiliation", "http://www.ibm.com/ccl/soa/deploy/core/1.0.0/#capability" //$NON-NLS-1$ //$NON-NLS-2$
		   });		
		addAnnotation
		  (getWPSRoot_CapabilityWPSESB(), 
		   source, 
		   new String[] {
			 "kind", "element", //$NON-NLS-1$ //$NON-NLS-2$
			 "name", "capability.WPSESB", //$NON-NLS-1$ //$NON-NLS-2$
			 "namespace", "##targetNamespace", //$NON-NLS-1$ //$NON-NLS-2$
			 "affiliation", "http://www.ibm.com/ccl/soa/deploy/core/1.0.0/#capability" //$NON-NLS-1$ //$NON-NLS-2$
		   });		
		addAnnotation
		  (getWPSRoot_CapabilityWPSSIB(), 
		   source, 
		   new String[] {
			 "kind", "element", //$NON-NLS-1$ //$NON-NLS-2$
			 "name", "capability.WPSSIB", //$NON-NLS-1$ //$NON-NLS-2$
			 "namespace", "##targetNamespace", //$NON-NLS-1$ //$NON-NLS-2$
			 "affiliation", "http://www.ibm.com/ccl/soa/deploy/core/1.0.0/#capability" //$NON-NLS-1$ //$NON-NLS-2$
		   });		
		addAnnotation
		  (getWPSRoot_UnitBPEContainerUnit(), 
		   source, 
		   new String[] {
			 "kind", "element", //$NON-NLS-1$ //$NON-NLS-2$
			 "name", "unit.BPEContainerUnit", //$NON-NLS-1$ //$NON-NLS-2$
			 "namespace", "##targetNamespace", //$NON-NLS-1$ //$NON-NLS-2$
			 "affiliation", "http://www.ibm.com/ccl/soa/deploy/core/1.0.0/#unit" //$NON-NLS-1$ //$NON-NLS-2$
		   });		
		addAnnotation
		  (getWPSRoot_UnitBusinessRulesManagerUnit(), 
		   source, 
		   new String[] {
			 "kind", "element", //$NON-NLS-1$ //$NON-NLS-2$
			 "name", "unit.BusinessRulesManagerUnit", //$NON-NLS-1$ //$NON-NLS-2$
			 "namespace", "##targetNamespace", //$NON-NLS-1$ //$NON-NLS-2$
			 "affiliation", "http://www.ibm.com/ccl/soa/deploy/core/1.0.0/#unit" //$NON-NLS-1$ //$NON-NLS-2$
		   });		
		addAnnotation
		  (getWPSRoot_UnitTaskContainerUnit(), 
		   source, 
		   new String[] {
			 "kind", "element", //$NON-NLS-1$ //$NON-NLS-2$
			 "name", "unit.TaskContainerUnit", //$NON-NLS-1$ //$NON-NLS-2$
			 "namespace", "##targetNamespace", //$NON-NLS-1$ //$NON-NLS-2$
			 "affiliation", "http://www.ibm.com/ccl/soa/deploy/core/1.0.0/#unit" //$NON-NLS-1$ //$NON-NLS-2$
		   });		
		addAnnotation
		  (getWPSRoot_UnitWpsBaseSystemUnit(), 
		   source, 
		   new String[] {
			 "kind", "element", //$NON-NLS-1$ //$NON-NLS-2$
			 "name", "unit.wpsBaseSystemUnit", //$NON-NLS-1$ //$NON-NLS-2$
			 "namespace", "##targetNamespace", //$NON-NLS-1$ //$NON-NLS-2$
			 "affiliation", "http://www.ibm.com/ccl/soa/deploy/core/1.0.0/#unit" //$NON-NLS-1$ //$NON-NLS-2$
		   });		
		addAnnotation
		  (getWPSRoot_UnitWPSCommonEventInfrastructureUnit(), 
		   source, 
		   new String[] {
			 "kind", "element", //$NON-NLS-1$ //$NON-NLS-2$
			 "name", "unit.WPSCommonEventInfrastructureUnit", //$NON-NLS-1$ //$NON-NLS-2$
			 "namespace", "##targetNamespace", //$NON-NLS-1$ //$NON-NLS-2$
			 "affiliation", "http://www.ibm.com/ccl/soa/deploy/core/1.0.0/#unit" //$NON-NLS-1$ //$NON-NLS-2$
		   });		
		addAnnotation
		  (getWPSRoot_UnitWPSESBUnit(), 
		   source, 
		   new String[] {
			 "kind", "element", //$NON-NLS-1$ //$NON-NLS-2$
			 "name", "unit.WPSESBUnit", //$NON-NLS-1$ //$NON-NLS-2$
			 "namespace", "##targetNamespace", //$NON-NLS-1$ //$NON-NLS-2$
			 "affiliation", "http://www.ibm.com/ccl/soa/deploy/core/1.0.0/#unit" //$NON-NLS-1$ //$NON-NLS-2$
		   });		
		addAnnotation
		  (getWPSRoot_UnitWPSSIBUnit(), 
		   source, 
		   new String[] {
			 "kind", "element", //$NON-NLS-1$ //$NON-NLS-2$
			 "name", "unit.WPSSIBUnit", //$NON-NLS-1$ //$NON-NLS-2$
			 "namespace", "##targetNamespace", //$NON-NLS-1$ //$NON-NLS-2$
			 "affiliation", "http://www.ibm.com/ccl/soa/deploy/core/1.0.0/#unit" //$NON-NLS-1$ //$NON-NLS-2$
		   });		
		addAnnotation
		  (getWPSRoot_UnitWpsSystemUnit(), 
		   source, 
		   new String[] {
			 "kind", "element", //$NON-NLS-1$ //$NON-NLS-2$
			 "name", "unit.wpsSystemUnit", //$NON-NLS-1$ //$NON-NLS-2$
			 "namespace", "##targetNamespace", //$NON-NLS-1$ //$NON-NLS-2$
			 "affiliation", "http://www.ibm.com/ccl/soa/deploy/core/1.0.0/#unit" //$NON-NLS-1$ //$NON-NLS-2$
		   });		
		addAnnotation
		  (wpssibEClass, 
		   source, 
		   new String[] {
			 "name", "WPSSIB", //$NON-NLS-1$ //$NON-NLS-2$
			 "kind", "elementOnly" //$NON-NLS-1$ //$NON-NLS-2$
		   });		
		addAnnotation
		  (getWPSSIB_Name1(), 
		   source, 
		   new String[] {
			 "kind", "attribute", //$NON-NLS-1$ //$NON-NLS-2$
			 "name", "Name" //$NON-NLS-1$ //$NON-NLS-2$
		   });		
		addAnnotation
		  (wpssibUnitEClass, 
		   source, 
		   new String[] {
			 "name", "WPSSIBUnit", //$NON-NLS-1$ //$NON-NLS-2$
			 "kind", "elementOnly" //$NON-NLS-1$ //$NON-NLS-2$
		   });		
		addAnnotation
		  (wpsSystemUnitEClass, 
		   source, 
		   new String[] {
			 "name", "WpsSystemUnit", //$NON-NLS-1$ //$NON-NLS-2$
			 "kind", "elementOnly" //$NON-NLS-1$ //$NON-NLS-2$
		   });
	}

} //WpsPackageImpl
