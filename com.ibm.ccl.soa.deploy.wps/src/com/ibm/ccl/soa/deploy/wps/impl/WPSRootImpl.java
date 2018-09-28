/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package com.ibm.ccl.soa.deploy.wps.impl;

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
import com.ibm.ccl.soa.deploy.wps.WpsPackage;
import com.ibm.ccl.soa.deploy.wps.WpsSystemUnit;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>WPS Root</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link com.ibm.ccl.soa.deploy.wps.impl.WPSRootImpl#getMixed <em>Mixed</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.wps.impl.WPSRootImpl#getXMLNSPrefixMap <em>XMLNS Prefix Map</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.wps.impl.WPSRootImpl#getXSISchemaLocation <em>XSI Schema Location</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.wps.impl.WPSRootImpl#getCapabilityApplicationSchedular <em>Capability Application Schedular</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.wps.impl.WPSRootImpl#getCapabilityBPEContainer <em>Capability BPE Container</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.wps.impl.WPSRootImpl#getCapabilityBusinessRulesManager <em>Capability Business Rules Manager</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.wps.impl.WPSRootImpl#getCapabilityCommonEventInfrastructure <em>Capability Common Event Infrastructure</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.wps.impl.WPSRootImpl#getCapabilityExtendedMessagingService <em>Capability Extended Messaging Service</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.wps.impl.WPSRootImpl#getCapabilityManagingEventService <em>Capability Managing Event Service</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.wps.impl.WPSRootImpl#getCapabilitySCARuntime <em>Capability SCA Runtime</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.wps.impl.WPSRootImpl#getCapabilitySDORuntime <em>Capability SDO Runtime</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.wps.impl.WPSRootImpl#getCapabilityTaskContainer <em>Capability Task Container</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.wps.impl.WPSRootImpl#getCapabilityWebSphereBusinessIntegrationAdaptersService <em>Capability Web Sphere Business Integration Adapters Service</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.wps.impl.WPSRootImpl#getCapabilityWpsBaseSystem <em>Capability Wps Base System</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.wps.impl.WPSRootImpl#getCapabilityWPSESB <em>Capability WPSESB</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.wps.impl.WPSRootImpl#getCapabilityWPSSIB <em>Capability WPSSIB</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.wps.impl.WPSRootImpl#getUnitBPEContainerUnit <em>Unit BPE Container Unit</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.wps.impl.WPSRootImpl#getUnitBusinessRulesManagerUnit <em>Unit Business Rules Manager Unit</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.wps.impl.WPSRootImpl#getUnitTaskContainerUnit <em>Unit Task Container Unit</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.wps.impl.WPSRootImpl#getUnitWpsBaseSystemUnit <em>Unit Wps Base System Unit</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.wps.impl.WPSRootImpl#getUnitWPSCommonEventInfrastructureUnit <em>Unit WPS Common Event Infrastructure Unit</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.wps.impl.WPSRootImpl#getUnitWPSESBUnit <em>Unit WPSESB Unit</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.wps.impl.WPSRootImpl#getUnitWPSSIBUnit <em>Unit WPSSIB Unit</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.wps.impl.WPSRootImpl#getUnitWpsSystemUnit <em>Unit Wps System Unit</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class WPSRootImpl extends EObjectImpl implements WPSRoot {
	/**
	 * The cached value of the '{@link #getMixed() <em>Mixed</em>}' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getMixed()
	 * @generated
	 * @ordered
	 */
	protected FeatureMap mixed;

	/**
	 * The cached value of the '{@link #getXMLNSPrefixMap() <em>XMLNS Prefix Map</em>}' map.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getXMLNSPrefixMap()
	 * @generated
	 * @ordered
	 */
	protected EMap xMLNSPrefixMap;

	/**
	 * The cached value of the '{@link #getXSISchemaLocation() <em>XSI Schema Location</em>}' map.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getXSISchemaLocation()
	 * @generated
	 * @ordered
	 */
	protected EMap xSISchemaLocation;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected WPSRootImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected EClass eStaticClass() {
		return WpsPackage.Literals.WPS_ROOT;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public FeatureMap getMixed() {
		if (mixed == null) {
			mixed = new BasicFeatureMap(this, WpsPackage.WPS_ROOT__MIXED);
		}
		return mixed;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EMap getXMLNSPrefixMap() {
		if (xMLNSPrefixMap == null) {
			xMLNSPrefixMap = new EcoreEMap(EcorePackage.Literals.ESTRING_TO_STRING_MAP_ENTRY, EStringToStringMapEntryImpl.class, this, WpsPackage.WPS_ROOT__XMLNS_PREFIX_MAP);
		}
		return xMLNSPrefixMap;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EMap getXSISchemaLocation() {
		if (xSISchemaLocation == null) {
			xSISchemaLocation = new EcoreEMap(EcorePackage.Literals.ESTRING_TO_STRING_MAP_ENTRY, EStringToStringMapEntryImpl.class, this, WpsPackage.WPS_ROOT__XSI_SCHEMA_LOCATION);
		}
		return xSISchemaLocation;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ApplicationSchedular getCapabilityApplicationSchedular() {
		return (ApplicationSchedular)getMixed().get(WpsPackage.Literals.WPS_ROOT__CAPABILITY_APPLICATION_SCHEDULAR, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetCapabilityApplicationSchedular(ApplicationSchedular newCapabilityApplicationSchedular, NotificationChain msgs) {
		return ((FeatureMap.Internal)getMixed()).basicAdd(WpsPackage.Literals.WPS_ROOT__CAPABILITY_APPLICATION_SCHEDULAR, newCapabilityApplicationSchedular, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setCapabilityApplicationSchedular(ApplicationSchedular newCapabilityApplicationSchedular) {
		((FeatureMap.Internal)getMixed()).set(WpsPackage.Literals.WPS_ROOT__CAPABILITY_APPLICATION_SCHEDULAR, newCapabilityApplicationSchedular);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public BPEContainer getCapabilityBPEContainer() {
		return (BPEContainer)getMixed().get(WpsPackage.Literals.WPS_ROOT__CAPABILITY_BPE_CONTAINER, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetCapabilityBPEContainer(BPEContainer newCapabilityBPEContainer, NotificationChain msgs) {
		return ((FeatureMap.Internal)getMixed()).basicAdd(WpsPackage.Literals.WPS_ROOT__CAPABILITY_BPE_CONTAINER, newCapabilityBPEContainer, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setCapabilityBPEContainer(BPEContainer newCapabilityBPEContainer) {
		((FeatureMap.Internal)getMixed()).set(WpsPackage.Literals.WPS_ROOT__CAPABILITY_BPE_CONTAINER, newCapabilityBPEContainer);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public BusinessRulesManager getCapabilityBusinessRulesManager() {
		return (BusinessRulesManager)getMixed().get(WpsPackage.Literals.WPS_ROOT__CAPABILITY_BUSINESS_RULES_MANAGER, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetCapabilityBusinessRulesManager(BusinessRulesManager newCapabilityBusinessRulesManager, NotificationChain msgs) {
		return ((FeatureMap.Internal)getMixed()).basicAdd(WpsPackage.Literals.WPS_ROOT__CAPABILITY_BUSINESS_RULES_MANAGER, newCapabilityBusinessRulesManager, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setCapabilityBusinessRulesManager(BusinessRulesManager newCapabilityBusinessRulesManager) {
		((FeatureMap.Internal)getMixed()).set(WpsPackage.Literals.WPS_ROOT__CAPABILITY_BUSINESS_RULES_MANAGER, newCapabilityBusinessRulesManager);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public CommonEventInfrastructure getCapabilityCommonEventInfrastructure() {
		return (CommonEventInfrastructure)getMixed().get(WpsPackage.Literals.WPS_ROOT__CAPABILITY_COMMON_EVENT_INFRASTRUCTURE, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetCapabilityCommonEventInfrastructure(CommonEventInfrastructure newCapabilityCommonEventInfrastructure, NotificationChain msgs) {
		return ((FeatureMap.Internal)getMixed()).basicAdd(WpsPackage.Literals.WPS_ROOT__CAPABILITY_COMMON_EVENT_INFRASTRUCTURE, newCapabilityCommonEventInfrastructure, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setCapabilityCommonEventInfrastructure(CommonEventInfrastructure newCapabilityCommonEventInfrastructure) {
		((FeatureMap.Internal)getMixed()).set(WpsPackage.Literals.WPS_ROOT__CAPABILITY_COMMON_EVENT_INFRASTRUCTURE, newCapabilityCommonEventInfrastructure);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ExtendedMessagingService getCapabilityExtendedMessagingService() {
		return (ExtendedMessagingService)getMixed().get(WpsPackage.Literals.WPS_ROOT__CAPABILITY_EXTENDED_MESSAGING_SERVICE, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetCapabilityExtendedMessagingService(ExtendedMessagingService newCapabilityExtendedMessagingService, NotificationChain msgs) {
		return ((FeatureMap.Internal)getMixed()).basicAdd(WpsPackage.Literals.WPS_ROOT__CAPABILITY_EXTENDED_MESSAGING_SERVICE, newCapabilityExtendedMessagingService, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setCapabilityExtendedMessagingService(ExtendedMessagingService newCapabilityExtendedMessagingService) {
		((FeatureMap.Internal)getMixed()).set(WpsPackage.Literals.WPS_ROOT__CAPABILITY_EXTENDED_MESSAGING_SERVICE, newCapabilityExtendedMessagingService);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ManagingEventservice getCapabilityManagingEventService() {
		return (ManagingEventservice)getMixed().get(WpsPackage.Literals.WPS_ROOT__CAPABILITY_MANAGING_EVENT_SERVICE, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetCapabilityManagingEventService(ManagingEventservice newCapabilityManagingEventService, NotificationChain msgs) {
		return ((FeatureMap.Internal)getMixed()).basicAdd(WpsPackage.Literals.WPS_ROOT__CAPABILITY_MANAGING_EVENT_SERVICE, newCapabilityManagingEventService, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setCapabilityManagingEventService(ManagingEventservice newCapabilityManagingEventService) {
		((FeatureMap.Internal)getMixed()).set(WpsPackage.Literals.WPS_ROOT__CAPABILITY_MANAGING_EVENT_SERVICE, newCapabilityManagingEventService);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SCARuntime getCapabilitySCARuntime() {
		return (SCARuntime)getMixed().get(WpsPackage.Literals.WPS_ROOT__CAPABILITY_SCA_RUNTIME, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetCapabilitySCARuntime(SCARuntime newCapabilitySCARuntime, NotificationChain msgs) {
		return ((FeatureMap.Internal)getMixed()).basicAdd(WpsPackage.Literals.WPS_ROOT__CAPABILITY_SCA_RUNTIME, newCapabilitySCARuntime, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setCapabilitySCARuntime(SCARuntime newCapabilitySCARuntime) {
		((FeatureMap.Internal)getMixed()).set(WpsPackage.Literals.WPS_ROOT__CAPABILITY_SCA_RUNTIME, newCapabilitySCARuntime);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SDORuntime getCapabilitySDORuntime() {
		return (SDORuntime)getMixed().get(WpsPackage.Literals.WPS_ROOT__CAPABILITY_SDO_RUNTIME, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetCapabilitySDORuntime(SDORuntime newCapabilitySDORuntime, NotificationChain msgs) {
		return ((FeatureMap.Internal)getMixed()).basicAdd(WpsPackage.Literals.WPS_ROOT__CAPABILITY_SDO_RUNTIME, newCapabilitySDORuntime, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setCapabilitySDORuntime(SDORuntime newCapabilitySDORuntime) {
		((FeatureMap.Internal)getMixed()).set(WpsPackage.Literals.WPS_ROOT__CAPABILITY_SDO_RUNTIME, newCapabilitySDORuntime);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public TaskContainer getCapabilityTaskContainer() {
		return (TaskContainer)getMixed().get(WpsPackage.Literals.WPS_ROOT__CAPABILITY_TASK_CONTAINER, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetCapabilityTaskContainer(TaskContainer newCapabilityTaskContainer, NotificationChain msgs) {
		return ((FeatureMap.Internal)getMixed()).basicAdd(WpsPackage.Literals.WPS_ROOT__CAPABILITY_TASK_CONTAINER, newCapabilityTaskContainer, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setCapabilityTaskContainer(TaskContainer newCapabilityTaskContainer) {
		((FeatureMap.Internal)getMixed()).set(WpsPackage.Literals.WPS_ROOT__CAPABILITY_TASK_CONTAINER, newCapabilityTaskContainer);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public WebSphereBusinessIntegrationAdaptersService getCapabilityWebSphereBusinessIntegrationAdaptersService() {
		return (WebSphereBusinessIntegrationAdaptersService)getMixed().get(WpsPackage.Literals.WPS_ROOT__CAPABILITY_WEB_SPHERE_BUSINESS_INTEGRATION_ADAPTERS_SERVICE, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetCapabilityWebSphereBusinessIntegrationAdaptersService(WebSphereBusinessIntegrationAdaptersService newCapabilityWebSphereBusinessIntegrationAdaptersService, NotificationChain msgs) {
		return ((FeatureMap.Internal)getMixed()).basicAdd(WpsPackage.Literals.WPS_ROOT__CAPABILITY_WEB_SPHERE_BUSINESS_INTEGRATION_ADAPTERS_SERVICE, newCapabilityWebSphereBusinessIntegrationAdaptersService, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setCapabilityWebSphereBusinessIntegrationAdaptersService(WebSphereBusinessIntegrationAdaptersService newCapabilityWebSphereBusinessIntegrationAdaptersService) {
		((FeatureMap.Internal)getMixed()).set(WpsPackage.Literals.WPS_ROOT__CAPABILITY_WEB_SPHERE_BUSINESS_INTEGRATION_ADAPTERS_SERVICE, newCapabilityWebSphereBusinessIntegrationAdaptersService);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public WpsBaseSystem getCapabilityWpsBaseSystem() {
		return (WpsBaseSystem)getMixed().get(WpsPackage.Literals.WPS_ROOT__CAPABILITY_WPS_BASE_SYSTEM, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetCapabilityWpsBaseSystem(WpsBaseSystem newCapabilityWpsBaseSystem, NotificationChain msgs) {
		return ((FeatureMap.Internal)getMixed()).basicAdd(WpsPackage.Literals.WPS_ROOT__CAPABILITY_WPS_BASE_SYSTEM, newCapabilityWpsBaseSystem, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setCapabilityWpsBaseSystem(WpsBaseSystem newCapabilityWpsBaseSystem) {
		((FeatureMap.Internal)getMixed()).set(WpsPackage.Literals.WPS_ROOT__CAPABILITY_WPS_BASE_SYSTEM, newCapabilityWpsBaseSystem);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public WPSESB getCapabilityWPSESB() {
		return (WPSESB)getMixed().get(WpsPackage.Literals.WPS_ROOT__CAPABILITY_WPSESB, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetCapabilityWPSESB(WPSESB newCapabilityWPSESB, NotificationChain msgs) {
		return ((FeatureMap.Internal)getMixed()).basicAdd(WpsPackage.Literals.WPS_ROOT__CAPABILITY_WPSESB, newCapabilityWPSESB, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setCapabilityWPSESB(WPSESB newCapabilityWPSESB) {
		((FeatureMap.Internal)getMixed()).set(WpsPackage.Literals.WPS_ROOT__CAPABILITY_WPSESB, newCapabilityWPSESB);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public WPSSIB getCapabilityWPSSIB() {
		return (WPSSIB)getMixed().get(WpsPackage.Literals.WPS_ROOT__CAPABILITY_WPSSIB, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetCapabilityWPSSIB(WPSSIB newCapabilityWPSSIB, NotificationChain msgs) {
		return ((FeatureMap.Internal)getMixed()).basicAdd(WpsPackage.Literals.WPS_ROOT__CAPABILITY_WPSSIB, newCapabilityWPSSIB, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setCapabilityWPSSIB(WPSSIB newCapabilityWPSSIB) {
		((FeatureMap.Internal)getMixed()).set(WpsPackage.Literals.WPS_ROOT__CAPABILITY_WPSSIB, newCapabilityWPSSIB);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public BPEContainerUnit getUnitBPEContainerUnit() {
		return (BPEContainerUnit)getMixed().get(WpsPackage.Literals.WPS_ROOT__UNIT_BPE_CONTAINER_UNIT, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetUnitBPEContainerUnit(BPEContainerUnit newUnitBPEContainerUnit, NotificationChain msgs) {
		return ((FeatureMap.Internal)getMixed()).basicAdd(WpsPackage.Literals.WPS_ROOT__UNIT_BPE_CONTAINER_UNIT, newUnitBPEContainerUnit, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setUnitBPEContainerUnit(BPEContainerUnit newUnitBPEContainerUnit) {
		((FeatureMap.Internal)getMixed()).set(WpsPackage.Literals.WPS_ROOT__UNIT_BPE_CONTAINER_UNIT, newUnitBPEContainerUnit);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public BusinessRulesManagerUnit getUnitBusinessRulesManagerUnit() {
		return (BusinessRulesManagerUnit)getMixed().get(WpsPackage.Literals.WPS_ROOT__UNIT_BUSINESS_RULES_MANAGER_UNIT, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetUnitBusinessRulesManagerUnit(BusinessRulesManagerUnit newUnitBusinessRulesManagerUnit, NotificationChain msgs) {
		return ((FeatureMap.Internal)getMixed()).basicAdd(WpsPackage.Literals.WPS_ROOT__UNIT_BUSINESS_RULES_MANAGER_UNIT, newUnitBusinessRulesManagerUnit, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setUnitBusinessRulesManagerUnit(BusinessRulesManagerUnit newUnitBusinessRulesManagerUnit) {
		((FeatureMap.Internal)getMixed()).set(WpsPackage.Literals.WPS_ROOT__UNIT_BUSINESS_RULES_MANAGER_UNIT, newUnitBusinessRulesManagerUnit);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public TaskContainerUnit getUnitTaskContainerUnit() {
		return (TaskContainerUnit)getMixed().get(WpsPackage.Literals.WPS_ROOT__UNIT_TASK_CONTAINER_UNIT, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetUnitTaskContainerUnit(TaskContainerUnit newUnitTaskContainerUnit, NotificationChain msgs) {
		return ((FeatureMap.Internal)getMixed()).basicAdd(WpsPackage.Literals.WPS_ROOT__UNIT_TASK_CONTAINER_UNIT, newUnitTaskContainerUnit, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setUnitTaskContainerUnit(TaskContainerUnit newUnitTaskContainerUnit) {
		((FeatureMap.Internal)getMixed()).set(WpsPackage.Literals.WPS_ROOT__UNIT_TASK_CONTAINER_UNIT, newUnitTaskContainerUnit);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public WpsBaseSystemUnit getUnitWpsBaseSystemUnit() {
		return (WpsBaseSystemUnit)getMixed().get(WpsPackage.Literals.WPS_ROOT__UNIT_WPS_BASE_SYSTEM_UNIT, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetUnitWpsBaseSystemUnit(WpsBaseSystemUnit newUnitWpsBaseSystemUnit, NotificationChain msgs) {
		return ((FeatureMap.Internal)getMixed()).basicAdd(WpsPackage.Literals.WPS_ROOT__UNIT_WPS_BASE_SYSTEM_UNIT, newUnitWpsBaseSystemUnit, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setUnitWpsBaseSystemUnit(WpsBaseSystemUnit newUnitWpsBaseSystemUnit) {
		((FeatureMap.Internal)getMixed()).set(WpsPackage.Literals.WPS_ROOT__UNIT_WPS_BASE_SYSTEM_UNIT, newUnitWpsBaseSystemUnit);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public WPSCommonEventInfrastructureUnit getUnitWPSCommonEventInfrastructureUnit() {
		return (WPSCommonEventInfrastructureUnit)getMixed().get(WpsPackage.Literals.WPS_ROOT__UNIT_WPS_COMMON_EVENT_INFRASTRUCTURE_UNIT, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetUnitWPSCommonEventInfrastructureUnit(WPSCommonEventInfrastructureUnit newUnitWPSCommonEventInfrastructureUnit, NotificationChain msgs) {
		return ((FeatureMap.Internal)getMixed()).basicAdd(WpsPackage.Literals.WPS_ROOT__UNIT_WPS_COMMON_EVENT_INFRASTRUCTURE_UNIT, newUnitWPSCommonEventInfrastructureUnit, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setUnitWPSCommonEventInfrastructureUnit(WPSCommonEventInfrastructureUnit newUnitWPSCommonEventInfrastructureUnit) {
		((FeatureMap.Internal)getMixed()).set(WpsPackage.Literals.WPS_ROOT__UNIT_WPS_COMMON_EVENT_INFRASTRUCTURE_UNIT, newUnitWPSCommonEventInfrastructureUnit);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public WPSESBUnit getUnitWPSESBUnit() {
		return (WPSESBUnit)getMixed().get(WpsPackage.Literals.WPS_ROOT__UNIT_WPSESB_UNIT, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetUnitWPSESBUnit(WPSESBUnit newUnitWPSESBUnit, NotificationChain msgs) {
		return ((FeatureMap.Internal)getMixed()).basicAdd(WpsPackage.Literals.WPS_ROOT__UNIT_WPSESB_UNIT, newUnitWPSESBUnit, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setUnitWPSESBUnit(WPSESBUnit newUnitWPSESBUnit) {
		((FeatureMap.Internal)getMixed()).set(WpsPackage.Literals.WPS_ROOT__UNIT_WPSESB_UNIT, newUnitWPSESBUnit);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public WPSSIBUnit getUnitWPSSIBUnit() {
		return (WPSSIBUnit)getMixed().get(WpsPackage.Literals.WPS_ROOT__UNIT_WPSSIB_UNIT, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetUnitWPSSIBUnit(WPSSIBUnit newUnitWPSSIBUnit, NotificationChain msgs) {
		return ((FeatureMap.Internal)getMixed()).basicAdd(WpsPackage.Literals.WPS_ROOT__UNIT_WPSSIB_UNIT, newUnitWPSSIBUnit, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setUnitWPSSIBUnit(WPSSIBUnit newUnitWPSSIBUnit) {
		((FeatureMap.Internal)getMixed()).set(WpsPackage.Literals.WPS_ROOT__UNIT_WPSSIB_UNIT, newUnitWPSSIBUnit);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public WpsSystemUnit getUnitWpsSystemUnit() {
		return (WpsSystemUnit)getMixed().get(WpsPackage.Literals.WPS_ROOT__UNIT_WPS_SYSTEM_UNIT, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetUnitWpsSystemUnit(WpsSystemUnit newUnitWpsSystemUnit, NotificationChain msgs) {
		return ((FeatureMap.Internal)getMixed()).basicAdd(WpsPackage.Literals.WPS_ROOT__UNIT_WPS_SYSTEM_UNIT, newUnitWpsSystemUnit, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setUnitWpsSystemUnit(WpsSystemUnit newUnitWpsSystemUnit) {
		((FeatureMap.Internal)getMixed()).set(WpsPackage.Literals.WPS_ROOT__UNIT_WPS_SYSTEM_UNIT, newUnitWpsSystemUnit);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case WpsPackage.WPS_ROOT__MIXED:
				return ((InternalEList)getMixed()).basicRemove(otherEnd, msgs);
			case WpsPackage.WPS_ROOT__XMLNS_PREFIX_MAP:
				return ((InternalEList)getXMLNSPrefixMap()).basicRemove(otherEnd, msgs);
			case WpsPackage.WPS_ROOT__XSI_SCHEMA_LOCATION:
				return ((InternalEList)getXSISchemaLocation()).basicRemove(otherEnd, msgs);
			case WpsPackage.WPS_ROOT__CAPABILITY_APPLICATION_SCHEDULAR:
				return basicSetCapabilityApplicationSchedular(null, msgs);
			case WpsPackage.WPS_ROOT__CAPABILITY_BPE_CONTAINER:
				return basicSetCapabilityBPEContainer(null, msgs);
			case WpsPackage.WPS_ROOT__CAPABILITY_BUSINESS_RULES_MANAGER:
				return basicSetCapabilityBusinessRulesManager(null, msgs);
			case WpsPackage.WPS_ROOT__CAPABILITY_COMMON_EVENT_INFRASTRUCTURE:
				return basicSetCapabilityCommonEventInfrastructure(null, msgs);
			case WpsPackage.WPS_ROOT__CAPABILITY_EXTENDED_MESSAGING_SERVICE:
				return basicSetCapabilityExtendedMessagingService(null, msgs);
			case WpsPackage.WPS_ROOT__CAPABILITY_MANAGING_EVENT_SERVICE:
				return basicSetCapabilityManagingEventService(null, msgs);
			case WpsPackage.WPS_ROOT__CAPABILITY_SCA_RUNTIME:
				return basicSetCapabilitySCARuntime(null, msgs);
			case WpsPackage.WPS_ROOT__CAPABILITY_SDO_RUNTIME:
				return basicSetCapabilitySDORuntime(null, msgs);
			case WpsPackage.WPS_ROOT__CAPABILITY_TASK_CONTAINER:
				return basicSetCapabilityTaskContainer(null, msgs);
			case WpsPackage.WPS_ROOT__CAPABILITY_WEB_SPHERE_BUSINESS_INTEGRATION_ADAPTERS_SERVICE:
				return basicSetCapabilityWebSphereBusinessIntegrationAdaptersService(null, msgs);
			case WpsPackage.WPS_ROOT__CAPABILITY_WPS_BASE_SYSTEM:
				return basicSetCapabilityWpsBaseSystem(null, msgs);
			case WpsPackage.WPS_ROOT__CAPABILITY_WPSESB:
				return basicSetCapabilityWPSESB(null, msgs);
			case WpsPackage.WPS_ROOT__CAPABILITY_WPSSIB:
				return basicSetCapabilityWPSSIB(null, msgs);
			case WpsPackage.WPS_ROOT__UNIT_BPE_CONTAINER_UNIT:
				return basicSetUnitBPEContainerUnit(null, msgs);
			case WpsPackage.WPS_ROOT__UNIT_BUSINESS_RULES_MANAGER_UNIT:
				return basicSetUnitBusinessRulesManagerUnit(null, msgs);
			case WpsPackage.WPS_ROOT__UNIT_TASK_CONTAINER_UNIT:
				return basicSetUnitTaskContainerUnit(null, msgs);
			case WpsPackage.WPS_ROOT__UNIT_WPS_BASE_SYSTEM_UNIT:
				return basicSetUnitWpsBaseSystemUnit(null, msgs);
			case WpsPackage.WPS_ROOT__UNIT_WPS_COMMON_EVENT_INFRASTRUCTURE_UNIT:
				return basicSetUnitWPSCommonEventInfrastructureUnit(null, msgs);
			case WpsPackage.WPS_ROOT__UNIT_WPSESB_UNIT:
				return basicSetUnitWPSESBUnit(null, msgs);
			case WpsPackage.WPS_ROOT__UNIT_WPSSIB_UNIT:
				return basicSetUnitWPSSIBUnit(null, msgs);
			case WpsPackage.WPS_ROOT__UNIT_WPS_SYSTEM_UNIT:
				return basicSetUnitWpsSystemUnit(null, msgs);
		}
		return super.eInverseRemove(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case WpsPackage.WPS_ROOT__MIXED:
				if (coreType) return getMixed();
				return ((FeatureMap.Internal)getMixed()).getWrapper();
			case WpsPackage.WPS_ROOT__XMLNS_PREFIX_MAP:
				if (coreType) return getXMLNSPrefixMap();
				else return getXMLNSPrefixMap().map();
			case WpsPackage.WPS_ROOT__XSI_SCHEMA_LOCATION:
				if (coreType) return getXSISchemaLocation();
				else return getXSISchemaLocation().map();
			case WpsPackage.WPS_ROOT__CAPABILITY_APPLICATION_SCHEDULAR:
				return getCapabilityApplicationSchedular();
			case WpsPackage.WPS_ROOT__CAPABILITY_BPE_CONTAINER:
				return getCapabilityBPEContainer();
			case WpsPackage.WPS_ROOT__CAPABILITY_BUSINESS_RULES_MANAGER:
				return getCapabilityBusinessRulesManager();
			case WpsPackage.WPS_ROOT__CAPABILITY_COMMON_EVENT_INFRASTRUCTURE:
				return getCapabilityCommonEventInfrastructure();
			case WpsPackage.WPS_ROOT__CAPABILITY_EXTENDED_MESSAGING_SERVICE:
				return getCapabilityExtendedMessagingService();
			case WpsPackage.WPS_ROOT__CAPABILITY_MANAGING_EVENT_SERVICE:
				return getCapabilityManagingEventService();
			case WpsPackage.WPS_ROOT__CAPABILITY_SCA_RUNTIME:
				return getCapabilitySCARuntime();
			case WpsPackage.WPS_ROOT__CAPABILITY_SDO_RUNTIME:
				return getCapabilitySDORuntime();
			case WpsPackage.WPS_ROOT__CAPABILITY_TASK_CONTAINER:
				return getCapabilityTaskContainer();
			case WpsPackage.WPS_ROOT__CAPABILITY_WEB_SPHERE_BUSINESS_INTEGRATION_ADAPTERS_SERVICE:
				return getCapabilityWebSphereBusinessIntegrationAdaptersService();
			case WpsPackage.WPS_ROOT__CAPABILITY_WPS_BASE_SYSTEM:
				return getCapabilityWpsBaseSystem();
			case WpsPackage.WPS_ROOT__CAPABILITY_WPSESB:
				return getCapabilityWPSESB();
			case WpsPackage.WPS_ROOT__CAPABILITY_WPSSIB:
				return getCapabilityWPSSIB();
			case WpsPackage.WPS_ROOT__UNIT_BPE_CONTAINER_UNIT:
				return getUnitBPEContainerUnit();
			case WpsPackage.WPS_ROOT__UNIT_BUSINESS_RULES_MANAGER_UNIT:
				return getUnitBusinessRulesManagerUnit();
			case WpsPackage.WPS_ROOT__UNIT_TASK_CONTAINER_UNIT:
				return getUnitTaskContainerUnit();
			case WpsPackage.WPS_ROOT__UNIT_WPS_BASE_SYSTEM_UNIT:
				return getUnitWpsBaseSystemUnit();
			case WpsPackage.WPS_ROOT__UNIT_WPS_COMMON_EVENT_INFRASTRUCTURE_UNIT:
				return getUnitWPSCommonEventInfrastructureUnit();
			case WpsPackage.WPS_ROOT__UNIT_WPSESB_UNIT:
				return getUnitWPSESBUnit();
			case WpsPackage.WPS_ROOT__UNIT_WPSSIB_UNIT:
				return getUnitWPSSIBUnit();
			case WpsPackage.WPS_ROOT__UNIT_WPS_SYSTEM_UNIT:
				return getUnitWpsSystemUnit();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
			case WpsPackage.WPS_ROOT__MIXED:
				((FeatureMap.Internal)getMixed()).set(newValue);
				return;
			case WpsPackage.WPS_ROOT__XMLNS_PREFIX_MAP:
				((EStructuralFeature.Setting)getXMLNSPrefixMap()).set(newValue);
				return;
			case WpsPackage.WPS_ROOT__XSI_SCHEMA_LOCATION:
				((EStructuralFeature.Setting)getXSISchemaLocation()).set(newValue);
				return;
			case WpsPackage.WPS_ROOT__CAPABILITY_APPLICATION_SCHEDULAR:
				setCapabilityApplicationSchedular((ApplicationSchedular)newValue);
				return;
			case WpsPackage.WPS_ROOT__CAPABILITY_BPE_CONTAINER:
				setCapabilityBPEContainer((BPEContainer)newValue);
				return;
			case WpsPackage.WPS_ROOT__CAPABILITY_BUSINESS_RULES_MANAGER:
				setCapabilityBusinessRulesManager((BusinessRulesManager)newValue);
				return;
			case WpsPackage.WPS_ROOT__CAPABILITY_COMMON_EVENT_INFRASTRUCTURE:
				setCapabilityCommonEventInfrastructure((CommonEventInfrastructure)newValue);
				return;
			case WpsPackage.WPS_ROOT__CAPABILITY_EXTENDED_MESSAGING_SERVICE:
				setCapabilityExtendedMessagingService((ExtendedMessagingService)newValue);
				return;
			case WpsPackage.WPS_ROOT__CAPABILITY_MANAGING_EVENT_SERVICE:
				setCapabilityManagingEventService((ManagingEventservice)newValue);
				return;
			case WpsPackage.WPS_ROOT__CAPABILITY_SCA_RUNTIME:
				setCapabilitySCARuntime((SCARuntime)newValue);
				return;
			case WpsPackage.WPS_ROOT__CAPABILITY_SDO_RUNTIME:
				setCapabilitySDORuntime((SDORuntime)newValue);
				return;
			case WpsPackage.WPS_ROOT__CAPABILITY_TASK_CONTAINER:
				setCapabilityTaskContainer((TaskContainer)newValue);
				return;
			case WpsPackage.WPS_ROOT__CAPABILITY_WEB_SPHERE_BUSINESS_INTEGRATION_ADAPTERS_SERVICE:
				setCapabilityWebSphereBusinessIntegrationAdaptersService((WebSphereBusinessIntegrationAdaptersService)newValue);
				return;
			case WpsPackage.WPS_ROOT__CAPABILITY_WPS_BASE_SYSTEM:
				setCapabilityWpsBaseSystem((WpsBaseSystem)newValue);
				return;
			case WpsPackage.WPS_ROOT__CAPABILITY_WPSESB:
				setCapabilityWPSESB((WPSESB)newValue);
				return;
			case WpsPackage.WPS_ROOT__CAPABILITY_WPSSIB:
				setCapabilityWPSSIB((WPSSIB)newValue);
				return;
			case WpsPackage.WPS_ROOT__UNIT_BPE_CONTAINER_UNIT:
				setUnitBPEContainerUnit((BPEContainerUnit)newValue);
				return;
			case WpsPackage.WPS_ROOT__UNIT_BUSINESS_RULES_MANAGER_UNIT:
				setUnitBusinessRulesManagerUnit((BusinessRulesManagerUnit)newValue);
				return;
			case WpsPackage.WPS_ROOT__UNIT_TASK_CONTAINER_UNIT:
				setUnitTaskContainerUnit((TaskContainerUnit)newValue);
				return;
			case WpsPackage.WPS_ROOT__UNIT_WPS_BASE_SYSTEM_UNIT:
				setUnitWpsBaseSystemUnit((WpsBaseSystemUnit)newValue);
				return;
			case WpsPackage.WPS_ROOT__UNIT_WPS_COMMON_EVENT_INFRASTRUCTURE_UNIT:
				setUnitWPSCommonEventInfrastructureUnit((WPSCommonEventInfrastructureUnit)newValue);
				return;
			case WpsPackage.WPS_ROOT__UNIT_WPSESB_UNIT:
				setUnitWPSESBUnit((WPSESBUnit)newValue);
				return;
			case WpsPackage.WPS_ROOT__UNIT_WPSSIB_UNIT:
				setUnitWPSSIBUnit((WPSSIBUnit)newValue);
				return;
			case WpsPackage.WPS_ROOT__UNIT_WPS_SYSTEM_UNIT:
				setUnitWpsSystemUnit((WpsSystemUnit)newValue);
				return;
		}
		super.eSet(featureID, newValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void eUnset(int featureID) {
		switch (featureID) {
			case WpsPackage.WPS_ROOT__MIXED:
				getMixed().clear();
				return;
			case WpsPackage.WPS_ROOT__XMLNS_PREFIX_MAP:
				getXMLNSPrefixMap().clear();
				return;
			case WpsPackage.WPS_ROOT__XSI_SCHEMA_LOCATION:
				getXSISchemaLocation().clear();
				return;
			case WpsPackage.WPS_ROOT__CAPABILITY_APPLICATION_SCHEDULAR:
				setCapabilityApplicationSchedular((ApplicationSchedular)null);
				return;
			case WpsPackage.WPS_ROOT__CAPABILITY_BPE_CONTAINER:
				setCapabilityBPEContainer((BPEContainer)null);
				return;
			case WpsPackage.WPS_ROOT__CAPABILITY_BUSINESS_RULES_MANAGER:
				setCapabilityBusinessRulesManager((BusinessRulesManager)null);
				return;
			case WpsPackage.WPS_ROOT__CAPABILITY_COMMON_EVENT_INFRASTRUCTURE:
				setCapabilityCommonEventInfrastructure((CommonEventInfrastructure)null);
				return;
			case WpsPackage.WPS_ROOT__CAPABILITY_EXTENDED_MESSAGING_SERVICE:
				setCapabilityExtendedMessagingService((ExtendedMessagingService)null);
				return;
			case WpsPackage.WPS_ROOT__CAPABILITY_MANAGING_EVENT_SERVICE:
				setCapabilityManagingEventService((ManagingEventservice)null);
				return;
			case WpsPackage.WPS_ROOT__CAPABILITY_SCA_RUNTIME:
				setCapabilitySCARuntime((SCARuntime)null);
				return;
			case WpsPackage.WPS_ROOT__CAPABILITY_SDO_RUNTIME:
				setCapabilitySDORuntime((SDORuntime)null);
				return;
			case WpsPackage.WPS_ROOT__CAPABILITY_TASK_CONTAINER:
				setCapabilityTaskContainer((TaskContainer)null);
				return;
			case WpsPackage.WPS_ROOT__CAPABILITY_WEB_SPHERE_BUSINESS_INTEGRATION_ADAPTERS_SERVICE:
				setCapabilityWebSphereBusinessIntegrationAdaptersService((WebSphereBusinessIntegrationAdaptersService)null);
				return;
			case WpsPackage.WPS_ROOT__CAPABILITY_WPS_BASE_SYSTEM:
				setCapabilityWpsBaseSystem((WpsBaseSystem)null);
				return;
			case WpsPackage.WPS_ROOT__CAPABILITY_WPSESB:
				setCapabilityWPSESB((WPSESB)null);
				return;
			case WpsPackage.WPS_ROOT__CAPABILITY_WPSSIB:
				setCapabilityWPSSIB((WPSSIB)null);
				return;
			case WpsPackage.WPS_ROOT__UNIT_BPE_CONTAINER_UNIT:
				setUnitBPEContainerUnit((BPEContainerUnit)null);
				return;
			case WpsPackage.WPS_ROOT__UNIT_BUSINESS_RULES_MANAGER_UNIT:
				setUnitBusinessRulesManagerUnit((BusinessRulesManagerUnit)null);
				return;
			case WpsPackage.WPS_ROOT__UNIT_TASK_CONTAINER_UNIT:
				setUnitTaskContainerUnit((TaskContainerUnit)null);
				return;
			case WpsPackage.WPS_ROOT__UNIT_WPS_BASE_SYSTEM_UNIT:
				setUnitWpsBaseSystemUnit((WpsBaseSystemUnit)null);
				return;
			case WpsPackage.WPS_ROOT__UNIT_WPS_COMMON_EVENT_INFRASTRUCTURE_UNIT:
				setUnitWPSCommonEventInfrastructureUnit((WPSCommonEventInfrastructureUnit)null);
				return;
			case WpsPackage.WPS_ROOT__UNIT_WPSESB_UNIT:
				setUnitWPSESBUnit((WPSESBUnit)null);
				return;
			case WpsPackage.WPS_ROOT__UNIT_WPSSIB_UNIT:
				setUnitWPSSIBUnit((WPSSIBUnit)null);
				return;
			case WpsPackage.WPS_ROOT__UNIT_WPS_SYSTEM_UNIT:
				setUnitWpsSystemUnit((WpsSystemUnit)null);
				return;
		}
		super.eUnset(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean eIsSet(int featureID) {
		switch (featureID) {
			case WpsPackage.WPS_ROOT__MIXED:
				return mixed != null && !mixed.isEmpty();
			case WpsPackage.WPS_ROOT__XMLNS_PREFIX_MAP:
				return xMLNSPrefixMap != null && !xMLNSPrefixMap.isEmpty();
			case WpsPackage.WPS_ROOT__XSI_SCHEMA_LOCATION:
				return xSISchemaLocation != null && !xSISchemaLocation.isEmpty();
			case WpsPackage.WPS_ROOT__CAPABILITY_APPLICATION_SCHEDULAR:
				return getCapabilityApplicationSchedular() != null;
			case WpsPackage.WPS_ROOT__CAPABILITY_BPE_CONTAINER:
				return getCapabilityBPEContainer() != null;
			case WpsPackage.WPS_ROOT__CAPABILITY_BUSINESS_RULES_MANAGER:
				return getCapabilityBusinessRulesManager() != null;
			case WpsPackage.WPS_ROOT__CAPABILITY_COMMON_EVENT_INFRASTRUCTURE:
				return getCapabilityCommonEventInfrastructure() != null;
			case WpsPackage.WPS_ROOT__CAPABILITY_EXTENDED_MESSAGING_SERVICE:
				return getCapabilityExtendedMessagingService() != null;
			case WpsPackage.WPS_ROOT__CAPABILITY_MANAGING_EVENT_SERVICE:
				return getCapabilityManagingEventService() != null;
			case WpsPackage.WPS_ROOT__CAPABILITY_SCA_RUNTIME:
				return getCapabilitySCARuntime() != null;
			case WpsPackage.WPS_ROOT__CAPABILITY_SDO_RUNTIME:
				return getCapabilitySDORuntime() != null;
			case WpsPackage.WPS_ROOT__CAPABILITY_TASK_CONTAINER:
				return getCapabilityTaskContainer() != null;
			case WpsPackage.WPS_ROOT__CAPABILITY_WEB_SPHERE_BUSINESS_INTEGRATION_ADAPTERS_SERVICE:
				return getCapabilityWebSphereBusinessIntegrationAdaptersService() != null;
			case WpsPackage.WPS_ROOT__CAPABILITY_WPS_BASE_SYSTEM:
				return getCapabilityWpsBaseSystem() != null;
			case WpsPackage.WPS_ROOT__CAPABILITY_WPSESB:
				return getCapabilityWPSESB() != null;
			case WpsPackage.WPS_ROOT__CAPABILITY_WPSSIB:
				return getCapabilityWPSSIB() != null;
			case WpsPackage.WPS_ROOT__UNIT_BPE_CONTAINER_UNIT:
				return getUnitBPEContainerUnit() != null;
			case WpsPackage.WPS_ROOT__UNIT_BUSINESS_RULES_MANAGER_UNIT:
				return getUnitBusinessRulesManagerUnit() != null;
			case WpsPackage.WPS_ROOT__UNIT_TASK_CONTAINER_UNIT:
				return getUnitTaskContainerUnit() != null;
			case WpsPackage.WPS_ROOT__UNIT_WPS_BASE_SYSTEM_UNIT:
				return getUnitWpsBaseSystemUnit() != null;
			case WpsPackage.WPS_ROOT__UNIT_WPS_COMMON_EVENT_INFRASTRUCTURE_UNIT:
				return getUnitWPSCommonEventInfrastructureUnit() != null;
			case WpsPackage.WPS_ROOT__UNIT_WPSESB_UNIT:
				return getUnitWPSESBUnit() != null;
			case WpsPackage.WPS_ROOT__UNIT_WPSSIB_UNIT:
				return getUnitWPSSIBUnit() != null;
			case WpsPackage.WPS_ROOT__UNIT_WPS_SYSTEM_UNIT:
				return getUnitWpsSystemUnit() != null;
		}
		return super.eIsSet(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String toString() {
		if (eIsProxy()) return super.toString();

		StringBuffer result = new StringBuffer(super.toString());
		result.append(" (mixed: "); //$NON-NLS-1$
		result.append(mixed);
		result.append(')');
		return result.toString();
	}

} //WPSRootImpl
