/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package com.ibm.ccl.soa.deploy.wps.util;

import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.common.notify.Notifier;
import org.eclipse.emf.common.notify.impl.AdapterFactoryImpl;
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
 * The <b>Adapter Factory</b> for the model.
 * It provides an adapter <code>createXXX</code> method for each class of the model.
 * <!-- end-user-doc -->
 * @see com.ibm.ccl.soa.deploy.wps.WpsPackage
 * @generated
 */
public class WpsAdapterFactory extends AdapterFactoryImpl {
	/**
	 * The cached model package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected static WpsPackage modelPackage;

	/**
	 * Creates an instance of the adapter factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public WpsAdapterFactory() {
		if (modelPackage == null) {
			modelPackage = WpsPackage.eINSTANCE;
		}
	}

	/**
	 * Returns whether this factory is applicable for the type of the object.
	 * <!-- begin-user-doc -->
	 * This implementation returns <code>true</code> if the object is either the model's package or is an instance object of the model.
	 * <!-- end-user-doc -->
	 * @return whether this factory is applicable for the type of the object.
	 * @generated
	 */
	public boolean isFactoryForType(Object object) {
		if (object == modelPackage) {
			return true;
		}
		if (object instanceof EObject) {
			return ((EObject)object).eClass().getEPackage() == modelPackage;
		}
		return false;
	}

	/**
	 * The switch the delegates to the <code>createXXX</code> methods.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected WpsSwitch modelSwitch =
		new WpsSwitch() {
			public Object caseApplicationSchedular(ApplicationSchedular object) {
				return createApplicationSchedularAdapter();
			}
			public Object caseBPEContainer(BPEContainer object) {
				return createBPEContainerAdapter();
			}
			public Object caseBPEContainerUnit(BPEContainerUnit object) {
				return createBPEContainerUnitAdapter();
			}
			public Object caseBusinessRulesManager(BusinessRulesManager object) {
				return createBusinessRulesManagerAdapter();
			}
			public Object caseBusinessRulesManagerUnit(BusinessRulesManagerUnit object) {
				return createBusinessRulesManagerUnitAdapter();
			}
			public Object caseCommonEventInfrastructure(CommonEventInfrastructure object) {
				return createCommonEventInfrastructureAdapter();
			}
			public Object caseExtendedMessagingService(ExtendedMessagingService object) {
				return createExtendedMessagingServiceAdapter();
			}
			public Object caseManagingEventservice(ManagingEventservice object) {
				return createManagingEventserviceAdapter();
			}
			public Object caseSCARuntime(SCARuntime object) {
				return createSCARuntimeAdapter();
			}
			public Object caseSDORuntime(SDORuntime object) {
				return createSDORuntimeAdapter();
			}
			public Object caseTaskContainer(TaskContainer object) {
				return createTaskContainerAdapter();
			}
			public Object caseTaskContainerUnit(TaskContainerUnit object) {
				return createTaskContainerUnitAdapter();
			}
			public Object caseWebSphereBusinessIntegrationAdaptersService(WebSphereBusinessIntegrationAdaptersService object) {
				return createWebSphereBusinessIntegrationAdaptersServiceAdapter();
			}
			public Object caseWpsBaseSystem(WpsBaseSystem object) {
				return createWpsBaseSystemAdapter();
			}
			public Object caseWpsBaseSystemUnit(WpsBaseSystemUnit object) {
				return createWpsBaseSystemUnitAdapter();
			}
			public Object caseWPSCommonEventInfrastructureUnit(WPSCommonEventInfrastructureUnit object) {
				return createWPSCommonEventInfrastructureUnitAdapter();
			}
			public Object caseWPSESB(WPSESB object) {
				return createWPSESBAdapter();
			}
			public Object caseWPSESBUnit(WPSESBUnit object) {
				return createWPSESBUnitAdapter();
			}
			public Object caseWPSRoot(WPSRoot object) {
				return createWPSRootAdapter();
			}
			public Object caseWPSSIB(WPSSIB object) {
				return createWPSSIBAdapter();
			}
			public Object caseWPSSIBUnit(WPSSIBUnit object) {
				return createWPSSIBUnitAdapter();
			}
			public Object caseWpsSystemUnit(WpsSystemUnit object) {
				return createWpsSystemUnitAdapter();
			}
			public Object caseDeployModelObject(DeployModelObject object) {
				return createDeployModelObjectAdapter();
			}
			public Object caseCapability(Capability object) {
				return createCapabilityAdapter();
			}
			public Object caseUnit(Unit object) {
				return createUnitAdapter();
			}
			public Object defaultCase(EObject object) {
				return createEObjectAdapter();
			}
		};

	/**
	 * Creates an adapter for the <code>target</code>.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param target the object to adapt.
	 * @return the adapter for the <code>target</code>.
	 * @generated
	 */
	public Adapter createAdapter(Notifier target) {
		return (Adapter)modelSwitch.doSwitch((EObject)target);
	}


	/**
	 * Creates a new adapter for an object of class '{@link com.ibm.ccl.soa.deploy.wps.ApplicationSchedular <em>Application Schedular</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see com.ibm.ccl.soa.deploy.wps.ApplicationSchedular
	 * @generated
	 */
	public Adapter createApplicationSchedularAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link com.ibm.ccl.soa.deploy.wps.BPEContainer <em>BPE Container</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see com.ibm.ccl.soa.deploy.wps.BPEContainer
	 * @generated
	 */
	public Adapter createBPEContainerAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link com.ibm.ccl.soa.deploy.wps.BPEContainerUnit <em>BPE Container Unit</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see com.ibm.ccl.soa.deploy.wps.BPEContainerUnit
	 * @generated
	 */
	public Adapter createBPEContainerUnitAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link com.ibm.ccl.soa.deploy.wps.BusinessRulesManager <em>Business Rules Manager</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see com.ibm.ccl.soa.deploy.wps.BusinessRulesManager
	 * @generated
	 */
	public Adapter createBusinessRulesManagerAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link com.ibm.ccl.soa.deploy.wps.BusinessRulesManagerUnit <em>Business Rules Manager Unit</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see com.ibm.ccl.soa.deploy.wps.BusinessRulesManagerUnit
	 * @generated
	 */
	public Adapter createBusinessRulesManagerUnitAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link com.ibm.ccl.soa.deploy.wps.CommonEventInfrastructure <em>Common Event Infrastructure</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see com.ibm.ccl.soa.deploy.wps.CommonEventInfrastructure
	 * @generated
	 */
	public Adapter createCommonEventInfrastructureAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link com.ibm.ccl.soa.deploy.wps.ExtendedMessagingService <em>Extended Messaging Service</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see com.ibm.ccl.soa.deploy.wps.ExtendedMessagingService
	 * @generated
	 */
	public Adapter createExtendedMessagingServiceAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link com.ibm.ccl.soa.deploy.wps.ManagingEventservice <em>Managing Eventservice</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see com.ibm.ccl.soa.deploy.wps.ManagingEventservice
	 * @generated
	 */
	public Adapter createManagingEventserviceAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link com.ibm.ccl.soa.deploy.wps.SCARuntime <em>SCA Runtime</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see com.ibm.ccl.soa.deploy.wps.SCARuntime
	 * @generated
	 */
	public Adapter createSCARuntimeAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link com.ibm.ccl.soa.deploy.wps.SDORuntime <em>SDO Runtime</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see com.ibm.ccl.soa.deploy.wps.SDORuntime
	 * @generated
	 */
	public Adapter createSDORuntimeAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link com.ibm.ccl.soa.deploy.wps.TaskContainer <em>Task Container</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see com.ibm.ccl.soa.deploy.wps.TaskContainer
	 * @generated
	 */
	public Adapter createTaskContainerAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link com.ibm.ccl.soa.deploy.wps.TaskContainerUnit <em>Task Container Unit</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see com.ibm.ccl.soa.deploy.wps.TaskContainerUnit
	 * @generated
	 */
	public Adapter createTaskContainerUnitAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link com.ibm.ccl.soa.deploy.wps.WebSphereBusinessIntegrationAdaptersService <em>Web Sphere Business Integration Adapters Service</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see com.ibm.ccl.soa.deploy.wps.WebSphereBusinessIntegrationAdaptersService
	 * @generated
	 */
	public Adapter createWebSphereBusinessIntegrationAdaptersServiceAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link com.ibm.ccl.soa.deploy.wps.WpsBaseSystem <em>Base System</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see com.ibm.ccl.soa.deploy.wps.WpsBaseSystem
	 * @generated
	 */
	public Adapter createWpsBaseSystemAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link com.ibm.ccl.soa.deploy.wps.WpsBaseSystemUnit <em>Base System Unit</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see com.ibm.ccl.soa.deploy.wps.WpsBaseSystemUnit
	 * @generated
	 */
	public Adapter createWpsBaseSystemUnitAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link com.ibm.ccl.soa.deploy.wps.WPSCommonEventInfrastructureUnit <em>WPS Common Event Infrastructure Unit</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see com.ibm.ccl.soa.deploy.wps.WPSCommonEventInfrastructureUnit
	 * @generated
	 */
	public Adapter createWPSCommonEventInfrastructureUnitAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link com.ibm.ccl.soa.deploy.wps.WPSESB <em>WPSESB</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see com.ibm.ccl.soa.deploy.wps.WPSESB
	 * @generated
	 */
	public Adapter createWPSESBAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link com.ibm.ccl.soa.deploy.wps.WPSESBUnit <em>WPSESB Unit</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see com.ibm.ccl.soa.deploy.wps.WPSESBUnit
	 * @generated
	 */
	public Adapter createWPSESBUnitAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link com.ibm.ccl.soa.deploy.wps.WPSRoot <em>WPS Root</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see com.ibm.ccl.soa.deploy.wps.WPSRoot
	 * @generated
	 */
	public Adapter createWPSRootAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link com.ibm.ccl.soa.deploy.wps.WPSSIB <em>WPSSIB</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see com.ibm.ccl.soa.deploy.wps.WPSSIB
	 * @generated
	 */
	public Adapter createWPSSIBAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link com.ibm.ccl.soa.deploy.wps.WPSSIBUnit <em>WPSSIB Unit</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see com.ibm.ccl.soa.deploy.wps.WPSSIBUnit
	 * @generated
	 */
	public Adapter createWPSSIBUnitAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link com.ibm.ccl.soa.deploy.wps.WpsSystemUnit <em>System Unit</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see com.ibm.ccl.soa.deploy.wps.WpsSystemUnit
	 * @generated
	 */
	public Adapter createWpsSystemUnitAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link com.ibm.ccl.soa.deploy.core.DeployModelObject <em>Deploy Model Object</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see com.ibm.ccl.soa.deploy.core.DeployModelObject
	 * @generated
	 */
	public Adapter createDeployModelObjectAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link com.ibm.ccl.soa.deploy.core.Capability <em>Capability</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see com.ibm.ccl.soa.deploy.core.Capability
	 * @generated
	 */
	public Adapter createCapabilityAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link com.ibm.ccl.soa.deploy.core.Unit <em>Unit</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see com.ibm.ccl.soa.deploy.core.Unit
	 * @generated
	 */
	public Adapter createUnitAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for the default case.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @generated
	 */
	public Adapter createEObjectAdapter() {
		return null;
	}

} //WpsAdapterFactory
