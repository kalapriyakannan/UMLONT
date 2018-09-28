/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package com.ibm.ccl.soa.deploy.wps.impl;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.impl.EFactoryImpl;
import org.eclipse.emf.ecore.plugin.EcorePlugin;

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
import com.ibm.ccl.soa.deploy.wps.WPSESB;
import com.ibm.ccl.soa.deploy.wps.WPSESBUnit;
import com.ibm.ccl.soa.deploy.wps.WPSRoot;
import com.ibm.ccl.soa.deploy.wps.WPSSIB;
import com.ibm.ccl.soa.deploy.wps.WPSSIBUnit;
import com.ibm.ccl.soa.deploy.wps.WebSphereBusinessIntegrationAdaptersService;
import com.ibm.ccl.soa.deploy.wps.WpsBaseSystem;
import com.ibm.ccl.soa.deploy.wps.WpsBaseSystemUnit;
import com.ibm.ccl.soa.deploy.wps.WpsFactory;
import com.ibm.ccl.soa.deploy.wps.WpsPackage;
import com.ibm.ccl.soa.deploy.wps.WpsSystemUnit;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Factory</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class WpsFactoryImpl extends EFactoryImpl implements WpsFactory {
	/**
	 * Creates the default factory implementation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static WpsFactory init() {
		try {
			WpsFactory theWpsFactory = (WpsFactory)EPackage.Registry.INSTANCE.getEFactory("http://www.ibm.com/Zephyr/wps/1.0.0/"); //$NON-NLS-1$ 
			if (theWpsFactory != null) {
				return theWpsFactory;
			}
		}
		catch (Exception exception) {
			EcorePlugin.INSTANCE.log(exception);
		}
		return new WpsFactoryImpl();
	}

	/**
	 * Creates an instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public WpsFactoryImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EObject create(EClass eClass) {
		switch (eClass.getClassifierID()) {
			case WpsPackage.APPLICATION_SCHEDULAR: return createApplicationSchedular();
			case WpsPackage.BPE_CONTAINER: return createBPEContainer();
			case WpsPackage.BPE_CONTAINER_UNIT: return createBPEContainerUnit();
			case WpsPackage.BUSINESS_RULES_MANAGER: return createBusinessRulesManager();
			case WpsPackage.BUSINESS_RULES_MANAGER_UNIT: return createBusinessRulesManagerUnit();
			case WpsPackage.COMMON_EVENT_INFRASTRUCTURE: return createCommonEventInfrastructure();
			case WpsPackage.EXTENDED_MESSAGING_SERVICE: return createExtendedMessagingService();
			case WpsPackage.MANAGING_EVENTSERVICE: return createManagingEventservice();
			case WpsPackage.SCA_RUNTIME: return createSCARuntime();
			case WpsPackage.SDO_RUNTIME: return createSDORuntime();
			case WpsPackage.TASK_CONTAINER: return createTaskContainer();
			case WpsPackage.TASK_CONTAINER_UNIT: return createTaskContainerUnit();
			case WpsPackage.WEB_SPHERE_BUSINESS_INTEGRATION_ADAPTERS_SERVICE: return createWebSphereBusinessIntegrationAdaptersService();
			case WpsPackage.WPS_BASE_SYSTEM: return createWpsBaseSystem();
			case WpsPackage.WPS_BASE_SYSTEM_UNIT: return createWpsBaseSystemUnit();
			case WpsPackage.WPS_COMMON_EVENT_INFRASTRUCTURE_UNIT: return createWPSCommonEventInfrastructureUnit();
			case WpsPackage.WPSESB: return createWPSESB();
			case WpsPackage.WPSESB_UNIT: return createWPSESBUnit();
			case WpsPackage.WPS_ROOT: return createWPSRoot();
			case WpsPackage.WPSSIB: return createWPSSIB();
			case WpsPackage.WPSSIB_UNIT: return createWPSSIBUnit();
			case WpsPackage.WPS_SYSTEM_UNIT: return createWpsSystemUnit();
			default:
				throw new IllegalArgumentException("The class '" + eClass.getName() + "' is not a valid classifier"); //$NON-NLS-1$ //$NON-NLS-2$
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ApplicationSchedular createApplicationSchedular() {
		ApplicationSchedularImpl applicationSchedular = new ApplicationSchedularImpl();
		return applicationSchedular;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public BPEContainer createBPEContainer() {
		BPEContainerImpl bpeContainer = new BPEContainerImpl();
		return bpeContainer;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public BPEContainerUnit createBPEContainerUnit() {
		BPEContainerUnitImpl bpeContainerUnit = new BPEContainerUnitImpl();
		return bpeContainerUnit;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public BusinessRulesManager createBusinessRulesManager() {
		BusinessRulesManagerImpl businessRulesManager = new BusinessRulesManagerImpl();
		return businessRulesManager;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public BusinessRulesManagerUnit createBusinessRulesManagerUnit() {
		BusinessRulesManagerUnitImpl businessRulesManagerUnit = new BusinessRulesManagerUnitImpl();
		return businessRulesManagerUnit;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public CommonEventInfrastructure createCommonEventInfrastructure() {
		CommonEventInfrastructureImpl commonEventInfrastructure = new CommonEventInfrastructureImpl();
		return commonEventInfrastructure;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ExtendedMessagingService createExtendedMessagingService() {
		ExtendedMessagingServiceImpl extendedMessagingService = new ExtendedMessagingServiceImpl();
		return extendedMessagingService;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ManagingEventservice createManagingEventservice() {
		ManagingEventserviceImpl managingEventservice = new ManagingEventserviceImpl();
		return managingEventservice;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SCARuntime createSCARuntime() {
		SCARuntimeImpl scaRuntime = new SCARuntimeImpl();
		return scaRuntime;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SDORuntime createSDORuntime() {
		SDORuntimeImpl sdoRuntime = new SDORuntimeImpl();
		return sdoRuntime;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public TaskContainer createTaskContainer() {
		TaskContainerImpl taskContainer = new TaskContainerImpl();
		return taskContainer;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public TaskContainerUnit createTaskContainerUnit() {
		TaskContainerUnitImpl taskContainerUnit = new TaskContainerUnitImpl();
		return taskContainerUnit;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public WebSphereBusinessIntegrationAdaptersService createWebSphereBusinessIntegrationAdaptersService() {
		WebSphereBusinessIntegrationAdaptersServiceImpl webSphereBusinessIntegrationAdaptersService = new WebSphereBusinessIntegrationAdaptersServiceImpl();
		return webSphereBusinessIntegrationAdaptersService;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public WpsBaseSystem createWpsBaseSystem() {
		WpsBaseSystemImpl wpsBaseSystem = new WpsBaseSystemImpl();
		return wpsBaseSystem;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public WpsBaseSystemUnit createWpsBaseSystemUnit() {
		WpsBaseSystemUnitImpl wpsBaseSystemUnit = new WpsBaseSystemUnitImpl();
		return wpsBaseSystemUnit;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public WPSCommonEventInfrastructureUnit createWPSCommonEventInfrastructureUnit() {
		WPSCommonEventInfrastructureUnitImpl wpsCommonEventInfrastructureUnit = new WPSCommonEventInfrastructureUnitImpl();
		return wpsCommonEventInfrastructureUnit;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public WPSESB createWPSESB() {
		WPSESBImpl wpsesb = new WPSESBImpl();
		return wpsesb;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public WPSESBUnit createWPSESBUnit() {
		WPSESBUnitImpl wpsesbUnit = new WPSESBUnitImpl();
		return wpsesbUnit;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public WPSRoot createWPSRoot() {
		WPSRootImpl wpsRoot = new WPSRootImpl();
		return wpsRoot;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public WPSSIB createWPSSIB() {
		WPSSIBImpl wpssib = new WPSSIBImpl();
		return wpssib;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public WPSSIBUnit createWPSSIBUnit() {
		WPSSIBUnitImpl wpssibUnit = new WPSSIBUnitImpl();
		return wpssibUnit;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public WpsSystemUnit createWpsSystemUnit() {
		WpsSystemUnitImpl wpsSystemUnit = new WpsSystemUnitImpl();
		return wpsSystemUnit;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public WpsPackage getWpsPackage() {
		return (WpsPackage)getEPackage();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @deprecated
	 * @generated
	 */
	public static WpsPackage getPackage() {
		return WpsPackage.eINSTANCE;
	}

} //WpsFactoryImpl
