/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package com.ibm.ccl.soa.deploy.wps.util;

import java.util.List;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;

import com.ibm.ccl.soa.deploy.core.Capability;
import com.ibm.ccl.soa.deploy.core.DeployModelObject;
import com.ibm.ccl.soa.deploy.core.Unit;
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
 * The <b>Switch</b> for the model's inheritance hierarchy.
 * It supports the call {@link #doSwitch(EObject) doSwitch(object)}
 * to invoke the <code>caseXXX</code> method for each class of the model,
 * starting with the actual class of the object
 * and proceeding up the inheritance hierarchy
 * until a non-null result is returned,
 * which is the result of the switch.
 * <!-- end-user-doc -->
 * @see com.ibm.ccl.soa.deploy.wps.WpsPackage
 * @generated
 */
public class WpsSwitch {
	/**
	 * The cached model package
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected static WpsPackage modelPackage;

	/**
	 * Creates an instance of the switch.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public WpsSwitch() {
		if (modelPackage == null) {
			modelPackage = WpsPackage.eINSTANCE;
		}
	}

	/**
	 * Calls <code>caseXXX</code> for each class of the model until one returns a non null result; it yields that result.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the first non-null result returned by a <code>caseXXX</code> call.
	 * @generated
	 */
	public Object doSwitch(EObject theEObject) {
		return doSwitch(theEObject.eClass(), theEObject);
	}

	/**
	 * Calls <code>caseXXX</code> for each class of the model until one returns a non null result; it yields that result.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the first non-null result returned by a <code>caseXXX</code> call.
	 * @generated
	 */
	protected Object doSwitch(EClass theEClass, EObject theEObject) {
		if (theEClass.eContainer() == modelPackage) {
			return doSwitch(theEClass.getClassifierID(), theEObject);
		}
		else {
			List eSuperTypes = theEClass.getESuperTypes();
			return
				eSuperTypes.isEmpty() ?
					defaultCase(theEObject) :
					doSwitch((EClass)eSuperTypes.get(0), theEObject);
		}
	}

	/**
	 * Calls <code>caseXXX</code> for each class of the model until one returns a non null result; it yields that result.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the first non-null result returned by a <code>caseXXX</code> call.
	 * @generated
	 */
	protected Object doSwitch(int classifierID, EObject theEObject) {
		switch (classifierID) {
			case WpsPackage.APPLICATION_SCHEDULAR: {
				ApplicationSchedular applicationSchedular = (ApplicationSchedular)theEObject;
				Object result = caseApplicationSchedular(applicationSchedular);
				if (result == null) result = caseCapability(applicationSchedular);
				if (result == null) result = caseDeployModelObject(applicationSchedular);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case WpsPackage.BPE_CONTAINER: {
				BPEContainer bpeContainer = (BPEContainer)theEObject;
				Object result = caseBPEContainer(bpeContainer);
				if (result == null) result = caseCapability(bpeContainer);
				if (result == null) result = caseDeployModelObject(bpeContainer);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case WpsPackage.BPE_CONTAINER_UNIT: {
				BPEContainerUnit bpeContainerUnit = (BPEContainerUnit)theEObject;
				Object result = caseBPEContainerUnit(bpeContainerUnit);
				if (result == null) result = caseUnit(bpeContainerUnit);
				if (result == null) result = caseDeployModelObject(bpeContainerUnit);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case WpsPackage.BUSINESS_RULES_MANAGER: {
				BusinessRulesManager businessRulesManager = (BusinessRulesManager)theEObject;
				Object result = caseBusinessRulesManager(businessRulesManager);
				if (result == null) result = caseCapability(businessRulesManager);
				if (result == null) result = caseDeployModelObject(businessRulesManager);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case WpsPackage.BUSINESS_RULES_MANAGER_UNIT: {
				BusinessRulesManagerUnit businessRulesManagerUnit = (BusinessRulesManagerUnit)theEObject;
				Object result = caseBusinessRulesManagerUnit(businessRulesManagerUnit);
				if (result == null) result = caseUnit(businessRulesManagerUnit);
				if (result == null) result = caseDeployModelObject(businessRulesManagerUnit);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case WpsPackage.COMMON_EVENT_INFRASTRUCTURE: {
				CommonEventInfrastructure commonEventInfrastructure = (CommonEventInfrastructure)theEObject;
				Object result = caseCommonEventInfrastructure(commonEventInfrastructure);
				if (result == null) result = caseCapability(commonEventInfrastructure);
				if (result == null) result = caseDeployModelObject(commonEventInfrastructure);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case WpsPackage.EXTENDED_MESSAGING_SERVICE: {
				ExtendedMessagingService extendedMessagingService = (ExtendedMessagingService)theEObject;
				Object result = caseExtendedMessagingService(extendedMessagingService);
				if (result == null) result = caseCapability(extendedMessagingService);
				if (result == null) result = caseDeployModelObject(extendedMessagingService);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case WpsPackage.MANAGING_EVENTSERVICE: {
				ManagingEventservice managingEventservice = (ManagingEventservice)theEObject;
				Object result = caseManagingEventservice(managingEventservice);
				if (result == null) result = caseCapability(managingEventservice);
				if (result == null) result = caseDeployModelObject(managingEventservice);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case WpsPackage.SCA_RUNTIME: {
				SCARuntime scaRuntime = (SCARuntime)theEObject;
				Object result = caseSCARuntime(scaRuntime);
				if (result == null) result = caseCapability(scaRuntime);
				if (result == null) result = caseDeployModelObject(scaRuntime);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case WpsPackage.SDO_RUNTIME: {
				SDORuntime sdoRuntime = (SDORuntime)theEObject;
				Object result = caseSDORuntime(sdoRuntime);
				if (result == null) result = caseCapability(sdoRuntime);
				if (result == null) result = caseDeployModelObject(sdoRuntime);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case WpsPackage.TASK_CONTAINER: {
				TaskContainer taskContainer = (TaskContainer)theEObject;
				Object result = caseTaskContainer(taskContainer);
				if (result == null) result = caseCapability(taskContainer);
				if (result == null) result = caseDeployModelObject(taskContainer);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case WpsPackage.TASK_CONTAINER_UNIT: {
				TaskContainerUnit taskContainerUnit = (TaskContainerUnit)theEObject;
				Object result = caseTaskContainerUnit(taskContainerUnit);
				if (result == null) result = caseUnit(taskContainerUnit);
				if (result == null) result = caseDeployModelObject(taskContainerUnit);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case WpsPackage.WEB_SPHERE_BUSINESS_INTEGRATION_ADAPTERS_SERVICE: {
				WebSphereBusinessIntegrationAdaptersService webSphereBusinessIntegrationAdaptersService = (WebSphereBusinessIntegrationAdaptersService)theEObject;
				Object result = caseWebSphereBusinessIntegrationAdaptersService(webSphereBusinessIntegrationAdaptersService);
				if (result == null) result = caseCapability(webSphereBusinessIntegrationAdaptersService);
				if (result == null) result = caseDeployModelObject(webSphereBusinessIntegrationAdaptersService);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case WpsPackage.WPS_BASE_SYSTEM: {
				WpsBaseSystem wpsBaseSystem = (WpsBaseSystem)theEObject;
				Object result = caseWpsBaseSystem(wpsBaseSystem);
				if (result == null) result = caseCapability(wpsBaseSystem);
				if (result == null) result = caseDeployModelObject(wpsBaseSystem);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case WpsPackage.WPS_BASE_SYSTEM_UNIT: {
				WpsBaseSystemUnit wpsBaseSystemUnit = (WpsBaseSystemUnit)theEObject;
				Object result = caseWpsBaseSystemUnit(wpsBaseSystemUnit);
				if (result == null) result = caseUnit(wpsBaseSystemUnit);
				if (result == null) result = caseDeployModelObject(wpsBaseSystemUnit);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case WpsPackage.WPS_COMMON_EVENT_INFRASTRUCTURE_UNIT: {
				WPSCommonEventInfrastructureUnit wpsCommonEventInfrastructureUnit = (WPSCommonEventInfrastructureUnit)theEObject;
				Object result = caseWPSCommonEventInfrastructureUnit(wpsCommonEventInfrastructureUnit);
				if (result == null) result = caseUnit(wpsCommonEventInfrastructureUnit);
				if (result == null) result = caseDeployModelObject(wpsCommonEventInfrastructureUnit);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case WpsPackage.WPSESB: {
				WPSESB wpsesb = (WPSESB)theEObject;
				Object result = caseWPSESB(wpsesb);
				if (result == null) result = caseCapability(wpsesb);
				if (result == null) result = caseDeployModelObject(wpsesb);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case WpsPackage.WPSESB_UNIT: {
				WPSESBUnit wpsesbUnit = (WPSESBUnit)theEObject;
				Object result = caseWPSESBUnit(wpsesbUnit);
				if (result == null) result = caseUnit(wpsesbUnit);
				if (result == null) result = caseDeployModelObject(wpsesbUnit);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case WpsPackage.WPS_ROOT: {
				WPSRoot wpsRoot = (WPSRoot)theEObject;
				Object result = caseWPSRoot(wpsRoot);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case WpsPackage.WPSSIB: {
				WPSSIB wpssib = (WPSSIB)theEObject;
				Object result = caseWPSSIB(wpssib);
				if (result == null) result = caseCapability(wpssib);
				if (result == null) result = caseDeployModelObject(wpssib);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case WpsPackage.WPSSIB_UNIT: {
				WPSSIBUnit wpssibUnit = (WPSSIBUnit)theEObject;
				Object result = caseWPSSIBUnit(wpssibUnit);
				if (result == null) result = caseUnit(wpssibUnit);
				if (result == null) result = caseDeployModelObject(wpssibUnit);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case WpsPackage.WPS_SYSTEM_UNIT: {
				WpsSystemUnit wpsSystemUnit = (WpsSystemUnit)theEObject;
				Object result = caseWpsSystemUnit(wpsSystemUnit);
				if (result == null) result = caseUnit(wpsSystemUnit);
				if (result == null) result = caseDeployModelObject(wpsSystemUnit);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			default: return defaultCase(theEObject);
		}
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Application Schedular</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Application Schedular</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public Object caseApplicationSchedular(ApplicationSchedular object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>BPE Container</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>BPE Container</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public Object caseBPEContainer(BPEContainer object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>BPE Container Unit</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>BPE Container Unit</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public Object caseBPEContainerUnit(BPEContainerUnit object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Business Rules Manager</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Business Rules Manager</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public Object caseBusinessRulesManager(BusinessRulesManager object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Business Rules Manager Unit</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Business Rules Manager Unit</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public Object caseBusinessRulesManagerUnit(BusinessRulesManagerUnit object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Common Event Infrastructure</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Common Event Infrastructure</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public Object caseCommonEventInfrastructure(CommonEventInfrastructure object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Extended Messaging Service</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Extended Messaging Service</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public Object caseExtendedMessagingService(ExtendedMessagingService object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Managing Eventservice</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Managing Eventservice</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public Object caseManagingEventservice(ManagingEventservice object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>SCA Runtime</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>SCA Runtime</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public Object caseSCARuntime(SCARuntime object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>SDO Runtime</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>SDO Runtime</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public Object caseSDORuntime(SDORuntime object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Task Container</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Task Container</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public Object caseTaskContainer(TaskContainer object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Task Container Unit</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Task Container Unit</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public Object caseTaskContainerUnit(TaskContainerUnit object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Web Sphere Business Integration Adapters Service</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Web Sphere Business Integration Adapters Service</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public Object caseWebSphereBusinessIntegrationAdaptersService(WebSphereBusinessIntegrationAdaptersService object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Base System</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Base System</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public Object caseWpsBaseSystem(WpsBaseSystem object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Base System Unit</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Base System Unit</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public Object caseWpsBaseSystemUnit(WpsBaseSystemUnit object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>WPS Common Event Infrastructure Unit</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>WPS Common Event Infrastructure Unit</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public Object caseWPSCommonEventInfrastructureUnit(WPSCommonEventInfrastructureUnit object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>WPSESB</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>WPSESB</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public Object caseWPSESB(WPSESB object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>WPSESB Unit</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>WPSESB Unit</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public Object caseWPSESBUnit(WPSESBUnit object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>WPS Root</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>WPS Root</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public Object caseWPSRoot(WPSRoot object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>WPSSIB</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>WPSSIB</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public Object caseWPSSIB(WPSSIB object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>WPSSIB Unit</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>WPSSIB Unit</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public Object caseWPSSIBUnit(WPSSIBUnit object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>System Unit</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>System Unit</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public Object caseWpsSystemUnit(WpsSystemUnit object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Deploy Model Object</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Deploy Model Object</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public Object caseDeployModelObject(DeployModelObject object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Capability</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Capability</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public Object caseCapability(Capability object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Unit</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Unit</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public Object caseUnit(Unit object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>EObject</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch, but this is the last case anyway.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>EObject</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject)
	 * @generated
	 */
	public Object defaultCase(EObject object) {
		return null;
	}

} //WpsSwitch
