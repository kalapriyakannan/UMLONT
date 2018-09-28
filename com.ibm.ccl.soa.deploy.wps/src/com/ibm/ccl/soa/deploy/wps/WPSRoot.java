/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package com.ibm.ccl.soa.deploy.wps;

import org.eclipse.emf.common.util.EMap;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.util.FeatureMap;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>WPS Root</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link com.ibm.ccl.soa.deploy.wps.WPSRoot#getMixed <em>Mixed</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.wps.WPSRoot#getXMLNSPrefixMap <em>XMLNS Prefix Map</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.wps.WPSRoot#getXSISchemaLocation <em>XSI Schema Location</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.wps.WPSRoot#getCapabilityApplicationSchedular <em>Capability Application Schedular</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.wps.WPSRoot#getCapabilityBPEContainer <em>Capability BPE Container</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.wps.WPSRoot#getCapabilityBusinessRulesManager <em>Capability Business Rules Manager</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.wps.WPSRoot#getCapabilityCommonEventInfrastructure <em>Capability Common Event Infrastructure</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.wps.WPSRoot#getCapabilityExtendedMessagingService <em>Capability Extended Messaging Service</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.wps.WPSRoot#getCapabilityManagingEventService <em>Capability Managing Event Service</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.wps.WPSRoot#getCapabilitySCARuntime <em>Capability SCA Runtime</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.wps.WPSRoot#getCapabilitySDORuntime <em>Capability SDO Runtime</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.wps.WPSRoot#getCapabilityTaskContainer <em>Capability Task Container</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.wps.WPSRoot#getCapabilityWebSphereBusinessIntegrationAdaptersService <em>Capability Web Sphere Business Integration Adapters Service</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.wps.WPSRoot#getCapabilityWpsBaseSystem <em>Capability Wps Base System</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.wps.WPSRoot#getCapabilityWPSESB <em>Capability WPSESB</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.wps.WPSRoot#getCapabilityWPSSIB <em>Capability WPSSIB</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.wps.WPSRoot#getUnitBPEContainerUnit <em>Unit BPE Container Unit</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.wps.WPSRoot#getUnitBusinessRulesManagerUnit <em>Unit Business Rules Manager Unit</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.wps.WPSRoot#getUnitTaskContainerUnit <em>Unit Task Container Unit</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.wps.WPSRoot#getUnitWpsBaseSystemUnit <em>Unit Wps Base System Unit</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.wps.WPSRoot#getUnitWPSCommonEventInfrastructureUnit <em>Unit WPS Common Event Infrastructure Unit</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.wps.WPSRoot#getUnitWPSESBUnit <em>Unit WPSESB Unit</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.wps.WPSRoot#getUnitWPSSIBUnit <em>Unit WPSSIB Unit</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.wps.WPSRoot#getUnitWpsSystemUnit <em>Unit Wps System Unit</em>}</li>
 * </ul>
 * </p>
 *
 * @see com.ibm.ccl.soa.deploy.wps.WpsPackage#getWPSRoot()
 * @model extendedMetaData="name='' kind='mixed'"
 * @generated
 */
public interface WPSRoot extends EObject {
	/**
	 * Returns the value of the '<em><b>Mixed</b></em>' attribute list.
	 * The list contents are of type {@link org.eclipse.emf.ecore.util.FeatureMap.Entry}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Mixed</em>' attribute list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Mixed</em>' attribute list.
	 * @see com.ibm.ccl.soa.deploy.wps.WpsPackage#getWPSRoot_Mixed()
	 * @model unique="false" dataType="org.eclipse.emf.ecore.EFeatureMapEntry" many="true"
	 *        extendedMetaData="kind='elementWildcard' name=':mixed'"
	 * @generated
	 */
	FeatureMap getMixed();

	/**
	 * Returns the value of the '<em><b>XMLNS Prefix Map</b></em>' map.
	 * The key is of type {@link java.lang.String},
	 * and the value is of type {@link java.lang.String},
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>XMLNS Prefix Map</em>' map isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>XMLNS Prefix Map</em>' map.
	 * @see com.ibm.ccl.soa.deploy.wps.WpsPackage#getWPSRoot_XMLNSPrefixMap()
	 * @model mapType="org.eclipse.emf.ecore.EStringToStringMapEntry" keyType="java.lang.String" valueType="java.lang.String" transient="true"
	 *        extendedMetaData="kind='attribute' name='xmlns:prefix'"
	 * @generated
	 */
	EMap getXMLNSPrefixMap();

	/**
	 * Returns the value of the '<em><b>XSI Schema Location</b></em>' map.
	 * The key is of type {@link java.lang.String},
	 * and the value is of type {@link java.lang.String},
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>XSI Schema Location</em>' map isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>XSI Schema Location</em>' map.
	 * @see com.ibm.ccl.soa.deploy.wps.WpsPackage#getWPSRoot_XSISchemaLocation()
	 * @model mapType="org.eclipse.emf.ecore.EStringToStringMapEntry" keyType="java.lang.String" valueType="java.lang.String" transient="true"
	 *        extendedMetaData="kind='attribute' name='xsi:schemaLocation'"
	 * @generated
	 */
	EMap getXSISchemaLocation();

	/**
	 * Returns the value of the '<em><b>Capability Application Schedular</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Capability Application Schedular</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Capability Application Schedular</em>' containment reference.
	 * @see #setCapabilityApplicationSchedular(ApplicationSchedular)
	 * @see com.ibm.ccl.soa.deploy.wps.WpsPackage#getWPSRoot_CapabilityApplicationSchedular()
	 * @model containment="true" upper="-2" transient="true" volatile="true" derived="true"
	 *        extendedMetaData="kind='element' name='capability.applicationSchedular' namespace='##targetNamespace' affiliation='http://www.ibm.com/ccl/soa/deploy/core/1.0.0/#capability'"
	 * @generated
	 */
	ApplicationSchedular getCapabilityApplicationSchedular();

	/**
	 * Sets the value of the '{@link com.ibm.ccl.soa.deploy.wps.WPSRoot#getCapabilityApplicationSchedular <em>Capability Application Schedular</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Capability Application Schedular</em>' containment reference.
	 * @see #getCapabilityApplicationSchedular()
	 * @generated
	 */
	void setCapabilityApplicationSchedular(ApplicationSchedular value);

	/**
	 * Returns the value of the '<em><b>Capability BPE Container</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Capability BPE Container</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Capability BPE Container</em>' containment reference.
	 * @see #setCapabilityBPEContainer(BPEContainer)
	 * @see com.ibm.ccl.soa.deploy.wps.WpsPackage#getWPSRoot_CapabilityBPEContainer()
	 * @model containment="true" upper="-2" transient="true" volatile="true" derived="true"
	 *        extendedMetaData="kind='element' name='capability.BPEContainer' namespace='##targetNamespace' affiliation='http://www.ibm.com/ccl/soa/deploy/core/1.0.0/#capability'"
	 * @generated
	 */
	BPEContainer getCapabilityBPEContainer();

	/**
	 * Sets the value of the '{@link com.ibm.ccl.soa.deploy.wps.WPSRoot#getCapabilityBPEContainer <em>Capability BPE Container</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Capability BPE Container</em>' containment reference.
	 * @see #getCapabilityBPEContainer()
	 * @generated
	 */
	void setCapabilityBPEContainer(BPEContainer value);

	/**
	 * Returns the value of the '<em><b>Capability Business Rules Manager</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Capability Business Rules Manager</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Capability Business Rules Manager</em>' containment reference.
	 * @see #setCapabilityBusinessRulesManager(BusinessRulesManager)
	 * @see com.ibm.ccl.soa.deploy.wps.WpsPackage#getWPSRoot_CapabilityBusinessRulesManager()
	 * @model containment="true" upper="-2" transient="true" volatile="true" derived="true"
	 *        extendedMetaData="kind='element' name='capability.BusinessRulesManager' namespace='##targetNamespace' affiliation='http://www.ibm.com/ccl/soa/deploy/core/1.0.0/#capability'"
	 * @generated
	 */
	BusinessRulesManager getCapabilityBusinessRulesManager();

	/**
	 * Sets the value of the '{@link com.ibm.ccl.soa.deploy.wps.WPSRoot#getCapabilityBusinessRulesManager <em>Capability Business Rules Manager</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Capability Business Rules Manager</em>' containment reference.
	 * @see #getCapabilityBusinessRulesManager()
	 * @generated
	 */
	void setCapabilityBusinessRulesManager(BusinessRulesManager value);

	/**
	 * Returns the value of the '<em><b>Capability Common Event Infrastructure</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Capability Common Event Infrastructure</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Capability Common Event Infrastructure</em>' containment reference.
	 * @see #setCapabilityCommonEventInfrastructure(CommonEventInfrastructure)
	 * @see com.ibm.ccl.soa.deploy.wps.WpsPackage#getWPSRoot_CapabilityCommonEventInfrastructure()
	 * @model containment="true" upper="-2" transient="true" volatile="true" derived="true"
	 *        extendedMetaData="kind='element' name='capability.CommonEventInfrastructure' namespace='##targetNamespace' affiliation='http://www.ibm.com/ccl/soa/deploy/core/1.0.0/#capability'"
	 * @generated
	 */
	CommonEventInfrastructure getCapabilityCommonEventInfrastructure();

	/**
	 * Sets the value of the '{@link com.ibm.ccl.soa.deploy.wps.WPSRoot#getCapabilityCommonEventInfrastructure <em>Capability Common Event Infrastructure</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Capability Common Event Infrastructure</em>' containment reference.
	 * @see #getCapabilityCommonEventInfrastructure()
	 * @generated
	 */
	void setCapabilityCommonEventInfrastructure(CommonEventInfrastructure value);

	/**
	 * Returns the value of the '<em><b>Capability Extended Messaging Service</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Capability Extended Messaging Service</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Capability Extended Messaging Service</em>' containment reference.
	 * @see #setCapabilityExtendedMessagingService(ExtendedMessagingService)
	 * @see com.ibm.ccl.soa.deploy.wps.WpsPackage#getWPSRoot_CapabilityExtendedMessagingService()
	 * @model containment="true" upper="-2" transient="true" volatile="true" derived="true"
	 *        extendedMetaData="kind='element' name='capability.ExtendedMessagingService' namespace='##targetNamespace' affiliation='http://www.ibm.com/ccl/soa/deploy/core/1.0.0/#capability'"
	 * @generated
	 */
	ExtendedMessagingService getCapabilityExtendedMessagingService();

	/**
	 * Sets the value of the '{@link com.ibm.ccl.soa.deploy.wps.WPSRoot#getCapabilityExtendedMessagingService <em>Capability Extended Messaging Service</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Capability Extended Messaging Service</em>' containment reference.
	 * @see #getCapabilityExtendedMessagingService()
	 * @generated
	 */
	void setCapabilityExtendedMessagingService(ExtendedMessagingService value);

	/**
	 * Returns the value of the '<em><b>Capability Managing Event Service</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Capability Managing Event Service</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Capability Managing Event Service</em>' containment reference.
	 * @see #setCapabilityManagingEventService(ManagingEventservice)
	 * @see com.ibm.ccl.soa.deploy.wps.WpsPackage#getWPSRoot_CapabilityManagingEventService()
	 * @model containment="true" upper="-2" transient="true" volatile="true" derived="true"
	 *        extendedMetaData="kind='element' name='capability.ManagingEventService' namespace='##targetNamespace' affiliation='http://www.ibm.com/ccl/soa/deploy/core/1.0.0/#capability'"
	 * @generated
	 */
	ManagingEventservice getCapabilityManagingEventService();

	/**
	 * Sets the value of the '{@link com.ibm.ccl.soa.deploy.wps.WPSRoot#getCapabilityManagingEventService <em>Capability Managing Event Service</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Capability Managing Event Service</em>' containment reference.
	 * @see #getCapabilityManagingEventService()
	 * @generated
	 */
	void setCapabilityManagingEventService(ManagingEventservice value);

	/**
	 * Returns the value of the '<em><b>Capability SCA Runtime</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Capability SCA Runtime</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Capability SCA Runtime</em>' containment reference.
	 * @see #setCapabilitySCARuntime(SCARuntime)
	 * @see com.ibm.ccl.soa.deploy.wps.WpsPackage#getWPSRoot_CapabilitySCARuntime()
	 * @model containment="true" upper="-2" transient="true" volatile="true" derived="true"
	 *        extendedMetaData="kind='element' name='capability.SCARuntime' namespace='##targetNamespace' affiliation='http://www.ibm.com/ccl/soa/deploy/core/1.0.0/#capability'"
	 * @generated
	 */
	SCARuntime getCapabilitySCARuntime();

	/**
	 * Sets the value of the '{@link com.ibm.ccl.soa.deploy.wps.WPSRoot#getCapabilitySCARuntime <em>Capability SCA Runtime</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Capability SCA Runtime</em>' containment reference.
	 * @see #getCapabilitySCARuntime()
	 * @generated
	 */
	void setCapabilitySCARuntime(SCARuntime value);

	/**
	 * Returns the value of the '<em><b>Capability SDO Runtime</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Capability SDO Runtime</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Capability SDO Runtime</em>' containment reference.
	 * @see #setCapabilitySDORuntime(SDORuntime)
	 * @see com.ibm.ccl.soa.deploy.wps.WpsPackage#getWPSRoot_CapabilitySDORuntime()
	 * @model containment="true" upper="-2" transient="true" volatile="true" derived="true"
	 *        extendedMetaData="kind='element' name='capability.SDORuntime' namespace='##targetNamespace' affiliation='http://www.ibm.com/ccl/soa/deploy/core/1.0.0/#capability'"
	 * @generated
	 */
	SDORuntime getCapabilitySDORuntime();

	/**
	 * Sets the value of the '{@link com.ibm.ccl.soa.deploy.wps.WPSRoot#getCapabilitySDORuntime <em>Capability SDO Runtime</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Capability SDO Runtime</em>' containment reference.
	 * @see #getCapabilitySDORuntime()
	 * @generated
	 */
	void setCapabilitySDORuntime(SDORuntime value);

	/**
	 * Returns the value of the '<em><b>Capability Task Container</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Capability Task Container</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Capability Task Container</em>' containment reference.
	 * @see #setCapabilityTaskContainer(TaskContainer)
	 * @see com.ibm.ccl.soa.deploy.wps.WpsPackage#getWPSRoot_CapabilityTaskContainer()
	 * @model containment="true" upper="-2" transient="true" volatile="true" derived="true"
	 *        extendedMetaData="kind='element' name='capability.TaskContainer' namespace='##targetNamespace' affiliation='http://www.ibm.com/ccl/soa/deploy/core/1.0.0/#capability'"
	 * @generated
	 */
	TaskContainer getCapabilityTaskContainer();

	/**
	 * Sets the value of the '{@link com.ibm.ccl.soa.deploy.wps.WPSRoot#getCapabilityTaskContainer <em>Capability Task Container</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Capability Task Container</em>' containment reference.
	 * @see #getCapabilityTaskContainer()
	 * @generated
	 */
	void setCapabilityTaskContainer(TaskContainer value);

	/**
	 * Returns the value of the '<em><b>Capability Web Sphere Business Integration Adapters Service</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Capability Web Sphere Business Integration Adapters Service</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Capability Web Sphere Business Integration Adapters Service</em>' containment reference.
	 * @see #setCapabilityWebSphereBusinessIntegrationAdaptersService(WebSphereBusinessIntegrationAdaptersService)
	 * @see com.ibm.ccl.soa.deploy.wps.WpsPackage#getWPSRoot_CapabilityWebSphereBusinessIntegrationAdaptersService()
	 * @model containment="true" upper="-2" transient="true" volatile="true" derived="true"
	 *        extendedMetaData="kind='element' name='capability.WebSphereBusinessIntegrationAdaptersService' namespace='##targetNamespace' affiliation='http://www.ibm.com/ccl/soa/deploy/core/1.0.0/#capability'"
	 * @generated
	 */
	WebSphereBusinessIntegrationAdaptersService getCapabilityWebSphereBusinessIntegrationAdaptersService();

	/**
	 * Sets the value of the '{@link com.ibm.ccl.soa.deploy.wps.WPSRoot#getCapabilityWebSphereBusinessIntegrationAdaptersService <em>Capability Web Sphere Business Integration Adapters Service</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Capability Web Sphere Business Integration Adapters Service</em>' containment reference.
	 * @see #getCapabilityWebSphereBusinessIntegrationAdaptersService()
	 * @generated
	 */
	void setCapabilityWebSphereBusinessIntegrationAdaptersService(WebSphereBusinessIntegrationAdaptersService value);

	/**
	 * Returns the value of the '<em><b>Capability Wps Base System</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Capability Wps Base System</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Capability Wps Base System</em>' containment reference.
	 * @see #setCapabilityWpsBaseSystem(WpsBaseSystem)
	 * @see com.ibm.ccl.soa.deploy.wps.WpsPackage#getWPSRoot_CapabilityWpsBaseSystem()
	 * @model containment="true" upper="-2" transient="true" volatile="true" derived="true"
	 *        extendedMetaData="kind='element' name='capability.wpsBaseSystem' namespace='##targetNamespace' affiliation='http://www.ibm.com/ccl/soa/deploy/core/1.0.0/#capability'"
	 * @generated
	 */
	WpsBaseSystem getCapabilityWpsBaseSystem();

	/**
	 * Sets the value of the '{@link com.ibm.ccl.soa.deploy.wps.WPSRoot#getCapabilityWpsBaseSystem <em>Capability Wps Base System</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Capability Wps Base System</em>' containment reference.
	 * @see #getCapabilityWpsBaseSystem()
	 * @generated
	 */
	void setCapabilityWpsBaseSystem(WpsBaseSystem value);

	/**
	 * Returns the value of the '<em><b>Capability WPSESB</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Capability WPSESB</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Capability WPSESB</em>' containment reference.
	 * @see #setCapabilityWPSESB(WPSESB)
	 * @see com.ibm.ccl.soa.deploy.wps.WpsPackage#getWPSRoot_CapabilityWPSESB()
	 * @model containment="true" upper="-2" transient="true" volatile="true" derived="true"
	 *        extendedMetaData="kind='element' name='capability.WPSESB' namespace='##targetNamespace' affiliation='http://www.ibm.com/ccl/soa/deploy/core/1.0.0/#capability'"
	 * @generated
	 */
	WPSESB getCapabilityWPSESB();

	/**
	 * Sets the value of the '{@link com.ibm.ccl.soa.deploy.wps.WPSRoot#getCapabilityWPSESB <em>Capability WPSESB</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Capability WPSESB</em>' containment reference.
	 * @see #getCapabilityWPSESB()
	 * @generated
	 */
	void setCapabilityWPSESB(WPSESB value);

	/**
	 * Returns the value of the '<em><b>Capability WPSSIB</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Capability WPSSIB</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Capability WPSSIB</em>' containment reference.
	 * @see #setCapabilityWPSSIB(WPSSIB)
	 * @see com.ibm.ccl.soa.deploy.wps.WpsPackage#getWPSRoot_CapabilityWPSSIB()
	 * @model containment="true" upper="-2" transient="true" volatile="true" derived="true"
	 *        extendedMetaData="kind='element' name='capability.WPSSIB' namespace='##targetNamespace' affiliation='http://www.ibm.com/ccl/soa/deploy/core/1.0.0/#capability'"
	 * @generated
	 */
	WPSSIB getCapabilityWPSSIB();

	/**
	 * Sets the value of the '{@link com.ibm.ccl.soa.deploy.wps.WPSRoot#getCapabilityWPSSIB <em>Capability WPSSIB</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Capability WPSSIB</em>' containment reference.
	 * @see #getCapabilityWPSSIB()
	 * @generated
	 */
	void setCapabilityWPSSIB(WPSSIB value);

	/**
	 * Returns the value of the '<em><b>Unit BPE Container Unit</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Unit BPE Container Unit</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Unit BPE Container Unit</em>' containment reference.
	 * @see #setUnitBPEContainerUnit(BPEContainerUnit)
	 * @see com.ibm.ccl.soa.deploy.wps.WpsPackage#getWPSRoot_UnitBPEContainerUnit()
	 * @model containment="true" upper="-2" transient="true" volatile="true" derived="true"
	 *        extendedMetaData="kind='element' name='unit.BPEContainerUnit' namespace='##targetNamespace' affiliation='http://www.ibm.com/ccl/soa/deploy/core/1.0.0/#unit'"
	 * @generated
	 */
	BPEContainerUnit getUnitBPEContainerUnit();

	/**
	 * Sets the value of the '{@link com.ibm.ccl.soa.deploy.wps.WPSRoot#getUnitBPEContainerUnit <em>Unit BPE Container Unit</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Unit BPE Container Unit</em>' containment reference.
	 * @see #getUnitBPEContainerUnit()
	 * @generated
	 */
	void setUnitBPEContainerUnit(BPEContainerUnit value);

	/**
	 * Returns the value of the '<em><b>Unit Business Rules Manager Unit</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Unit Business Rules Manager Unit</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Unit Business Rules Manager Unit</em>' containment reference.
	 * @see #setUnitBusinessRulesManagerUnit(BusinessRulesManagerUnit)
	 * @see com.ibm.ccl.soa.deploy.wps.WpsPackage#getWPSRoot_UnitBusinessRulesManagerUnit()
	 * @model containment="true" upper="-2" transient="true" volatile="true" derived="true"
	 *        extendedMetaData="kind='element' name='unit.BusinessRulesManagerUnit' namespace='##targetNamespace' affiliation='http://www.ibm.com/ccl/soa/deploy/core/1.0.0/#unit'"
	 * @generated
	 */
	BusinessRulesManagerUnit getUnitBusinessRulesManagerUnit();

	/**
	 * Sets the value of the '{@link com.ibm.ccl.soa.deploy.wps.WPSRoot#getUnitBusinessRulesManagerUnit <em>Unit Business Rules Manager Unit</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Unit Business Rules Manager Unit</em>' containment reference.
	 * @see #getUnitBusinessRulesManagerUnit()
	 * @generated
	 */
	void setUnitBusinessRulesManagerUnit(BusinessRulesManagerUnit value);

	/**
	 * Returns the value of the '<em><b>Unit Task Container Unit</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Unit Task Container Unit</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Unit Task Container Unit</em>' containment reference.
	 * @see #setUnitTaskContainerUnit(TaskContainerUnit)
	 * @see com.ibm.ccl.soa.deploy.wps.WpsPackage#getWPSRoot_UnitTaskContainerUnit()
	 * @model containment="true" upper="-2" transient="true" volatile="true" derived="true"
	 *        extendedMetaData="kind='element' name='unit.TaskContainerUnit' namespace='##targetNamespace' affiliation='http://www.ibm.com/ccl/soa/deploy/core/1.0.0/#unit'"
	 * @generated
	 */
	TaskContainerUnit getUnitTaskContainerUnit();

	/**
	 * Sets the value of the '{@link com.ibm.ccl.soa.deploy.wps.WPSRoot#getUnitTaskContainerUnit <em>Unit Task Container Unit</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Unit Task Container Unit</em>' containment reference.
	 * @see #getUnitTaskContainerUnit()
	 * @generated
	 */
	void setUnitTaskContainerUnit(TaskContainerUnit value);

	/**
	 * Returns the value of the '<em><b>Unit Wps Base System Unit</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Unit Wps Base System Unit</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Unit Wps Base System Unit</em>' containment reference.
	 * @see #setUnitWpsBaseSystemUnit(WpsBaseSystemUnit)
	 * @see com.ibm.ccl.soa.deploy.wps.WpsPackage#getWPSRoot_UnitWpsBaseSystemUnit()
	 * @model containment="true" upper="-2" transient="true" volatile="true" derived="true"
	 *        extendedMetaData="kind='element' name='unit.wpsBaseSystemUnit' namespace='##targetNamespace' affiliation='http://www.ibm.com/ccl/soa/deploy/core/1.0.0/#unit'"
	 * @generated
	 */
	WpsBaseSystemUnit getUnitWpsBaseSystemUnit();

	/**
	 * Sets the value of the '{@link com.ibm.ccl.soa.deploy.wps.WPSRoot#getUnitWpsBaseSystemUnit <em>Unit Wps Base System Unit</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Unit Wps Base System Unit</em>' containment reference.
	 * @see #getUnitWpsBaseSystemUnit()
	 * @generated
	 */
	void setUnitWpsBaseSystemUnit(WpsBaseSystemUnit value);

	/**
	 * Returns the value of the '<em><b>Unit WPS Common Event Infrastructure Unit</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Unit WPS Common Event Infrastructure Unit</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Unit WPS Common Event Infrastructure Unit</em>' containment reference.
	 * @see #setUnitWPSCommonEventInfrastructureUnit(WPSCommonEventInfrastructureUnit)
	 * @see com.ibm.ccl.soa.deploy.wps.WpsPackage#getWPSRoot_UnitWPSCommonEventInfrastructureUnit()
	 * @model containment="true" upper="-2" transient="true" volatile="true" derived="true"
	 *        extendedMetaData="kind='element' name='unit.WPSCommonEventInfrastructureUnit' namespace='##targetNamespace' affiliation='http://www.ibm.com/ccl/soa/deploy/core/1.0.0/#unit'"
	 * @generated
	 */
	WPSCommonEventInfrastructureUnit getUnitWPSCommonEventInfrastructureUnit();

	/**
	 * Sets the value of the '{@link com.ibm.ccl.soa.deploy.wps.WPSRoot#getUnitWPSCommonEventInfrastructureUnit <em>Unit WPS Common Event Infrastructure Unit</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Unit WPS Common Event Infrastructure Unit</em>' containment reference.
	 * @see #getUnitWPSCommonEventInfrastructureUnit()
	 * @generated
	 */
	void setUnitWPSCommonEventInfrastructureUnit(WPSCommonEventInfrastructureUnit value);

	/**
	 * Returns the value of the '<em><b>Unit WPSESB Unit</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Unit WPSESB Unit</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Unit WPSESB Unit</em>' containment reference.
	 * @see #setUnitWPSESBUnit(WPSESBUnit)
	 * @see com.ibm.ccl.soa.deploy.wps.WpsPackage#getWPSRoot_UnitWPSESBUnit()
	 * @model containment="true" upper="-2" transient="true" volatile="true" derived="true"
	 *        extendedMetaData="kind='element' name='unit.WPSESBUnit' namespace='##targetNamespace' affiliation='http://www.ibm.com/ccl/soa/deploy/core/1.0.0/#unit'"
	 * @generated
	 */
	WPSESBUnit getUnitWPSESBUnit();

	/**
	 * Sets the value of the '{@link com.ibm.ccl.soa.deploy.wps.WPSRoot#getUnitWPSESBUnit <em>Unit WPSESB Unit</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Unit WPSESB Unit</em>' containment reference.
	 * @see #getUnitWPSESBUnit()
	 * @generated
	 */
	void setUnitWPSESBUnit(WPSESBUnit value);

	/**
	 * Returns the value of the '<em><b>Unit WPSSIB Unit</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Unit WPSSIB Unit</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Unit WPSSIB Unit</em>' containment reference.
	 * @see #setUnitWPSSIBUnit(WPSSIBUnit)
	 * @see com.ibm.ccl.soa.deploy.wps.WpsPackage#getWPSRoot_UnitWPSSIBUnit()
	 * @model containment="true" upper="-2" transient="true" volatile="true" derived="true"
	 *        extendedMetaData="kind='element' name='unit.WPSSIBUnit' namespace='##targetNamespace' affiliation='http://www.ibm.com/ccl/soa/deploy/core/1.0.0/#unit'"
	 * @generated
	 */
	WPSSIBUnit getUnitWPSSIBUnit();

	/**
	 * Sets the value of the '{@link com.ibm.ccl.soa.deploy.wps.WPSRoot#getUnitWPSSIBUnit <em>Unit WPSSIB Unit</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Unit WPSSIB Unit</em>' containment reference.
	 * @see #getUnitWPSSIBUnit()
	 * @generated
	 */
	void setUnitWPSSIBUnit(WPSSIBUnit value);

	/**
	 * Returns the value of the '<em><b>Unit Wps System Unit</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Unit Wps System Unit</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Unit Wps System Unit</em>' containment reference.
	 * @see #setUnitWpsSystemUnit(WpsSystemUnit)
	 * @see com.ibm.ccl.soa.deploy.wps.WpsPackage#getWPSRoot_UnitWpsSystemUnit()
	 * @model containment="true" upper="-2" transient="true" volatile="true" derived="true"
	 *        extendedMetaData="kind='element' name='unit.wpsSystemUnit' namespace='##targetNamespace' affiliation='http://www.ibm.com/ccl/soa/deploy/core/1.0.0/#unit'"
	 * @generated
	 */
	WpsSystemUnit getUnitWpsSystemUnit();

	/**
	 * Sets the value of the '{@link com.ibm.ccl.soa.deploy.wps.WPSRoot#getUnitWpsSystemUnit <em>Unit Wps System Unit</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Unit Wps System Unit</em>' containment reference.
	 * @see #getUnitWpsSystemUnit()
	 * @generated
	 */
	void setUnitWpsSystemUnit(WpsSystemUnit value);

} // WPSRoot
