/*******************************************************************************
 * Copyright (c) 2003, 2007 IBM Corporation Licensed Material - Property of IBM. All rights reserved.
 *  
 * US Government Users Restricted Rights - Use, duplication or disclosure v1.0 restricted by GSA ADP
 * Schedule Contract with IBM Corp.
 * 
 * Contributors: IBM Corporation - initial API and implementation
 *******************************************************************************/
package com.ibm.ccl.soa.deploy.ihs.util;

import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.common.notify.Notifier;
import org.eclipse.emf.common.notify.impl.AdapterFactoryImpl;
import org.eclipse.emf.ecore.EObject;

import com.ibm.ccl.soa.deploy.core.Capability;
import com.ibm.ccl.soa.deploy.core.DeployModelObject;
import com.ibm.ccl.soa.deploy.core.Unit;
import com.ibm.ccl.soa.deploy.http.HttpServer;
import com.ibm.ccl.soa.deploy.http.HttpServerUnit;
import com.ibm.ccl.soa.deploy.http.HttpUser;
import com.ibm.ccl.soa.deploy.http.HttpUserUnit;
import com.ibm.ccl.soa.deploy.ihs.IHSDeployRoot;
import com.ibm.ccl.soa.deploy.ihs.IhsModule;
import com.ibm.ccl.soa.deploy.ihs.IhsPackage;
import com.ibm.ccl.soa.deploy.ihs.IhsServer;
import com.ibm.ccl.soa.deploy.ihs.IhsServerUnit;
import com.ibm.ccl.soa.deploy.ihs.IhsSystem;
import com.ibm.ccl.soa.deploy.ihs.IhsSystemUnit;
import com.ibm.ccl.soa.deploy.ihs.IhsUser;
import com.ibm.ccl.soa.deploy.ihs.IhsUserRepository;
import com.ibm.ccl.soa.deploy.ihs.IhsUserUnit;
import com.ibm.ccl.soa.deploy.ihs.IhsWasAdminModule;
import com.ibm.ccl.soa.deploy.ihs.IhsWasAdminModuleUnit;
import com.ibm.ccl.soa.deploy.ihs.IhsWasModule;
import com.ibm.ccl.soa.deploy.ihs.IhsWasModuleUnit;
import com.ibm.ccl.soa.deploy.ihs.LinuxIhsSystem;
import com.ibm.ccl.soa.deploy.ihs.WindowsIhsSystem;

/**
 * <!-- begin-user-doc --> The <b>Adapter Factory</b> for the model. It provides an adapter
 * <code>createXXX</code> method for each class of the model. <!-- end-user-doc -->
 * @see com.ibm.ccl.soa.deploy.ihs.IhsPackage
 * @generated
 */
public class IhsAdapterFactory extends AdapterFactoryImpl {
	/**
	 * The cached model package.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	protected static IhsPackage modelPackage;

	/**
	 * Creates an instance of the adapter factory.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public IhsAdapterFactory() {
		if (modelPackage == null) {
			modelPackage = IhsPackage.eINSTANCE;
		}
	}

	/**
	 * Returns whether this factory is applicable for the type of the object.
	 * <!-- begin-user-doc -->
	 * This implementation returns <code>true</code> if the object is either the model's package or
	 * is an instance object of the model. <!-- end-user-doc -->
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
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @generated
	 */
	protected IhsSwitch modelSwitch = new IhsSwitch() {
			public Object caseIHSDeployRoot(IHSDeployRoot object) {
				return createIHSDeployRootAdapter();
			}
			public Object caseIhsModule(IhsModule object) {
				return createIhsModuleAdapter();
			}
			public Object caseIhsServer(IhsServer object) {
				return createIhsServerAdapter();
			}
			public Object caseIhsServerUnit(IhsServerUnit object) {
				return createIhsServerUnitAdapter();
			}
			public Object caseIhsSystem(IhsSystem object) {
				return createIhsSystemAdapter();
			}
			public Object caseIhsSystemUnit(IhsSystemUnit object) {
				return createIhsSystemUnitAdapter();
			}
			public Object caseIhsUser(IhsUser object) {
				return createIhsUserAdapter();
			}
			public Object caseIhsUserRepository(IhsUserRepository object) {
				return createIhsUserRepositoryAdapter();
			}
			public Object caseIhsUserUnit(IhsUserUnit object) {
				return createIhsUserUnitAdapter();
			}
			public Object caseIhsWasAdminModule(IhsWasAdminModule object) {
				return createIhsWasAdminModuleAdapter();
			}
			public Object caseIhsWasAdminModuleUnit(IhsWasAdminModuleUnit object) {
				return createIhsWasAdminModuleUnitAdapter();
			}
			public Object caseIhsWasModule(IhsWasModule object) {
				return createIhsWasModuleAdapter();
			}
			public Object caseIhsWasModuleUnit(IhsWasModuleUnit object) {
				return createIhsWasModuleUnitAdapter();
			}
			public Object caseLinuxIhsSystem(LinuxIhsSystem object) {
				return createLinuxIhsSystemAdapter();
			}
			public Object caseWindowsIhsSystem(WindowsIhsSystem object) {
				return createWindowsIhsSystemAdapter();
			}
			public Object caseDeployModelObject(DeployModelObject object) {
				return createDeployModelObjectAdapter();
			}
			public Object caseCapability(Capability object) {
				return createCapabilityAdapter();
			}
			public Object caseHttpServer(HttpServer object) {
				return createHttpServerAdapter();
			}
			public Object caseUnit(Unit object) {
				return createUnitAdapter();
			}
			public Object caseHttpServerUnit(HttpServerUnit object) {
				return createHttpServerUnitAdapter();
			}
			public Object caseHttpUser(HttpUser object) {
				return createHttpUserAdapter();
			}
			public Object caseHttpUserUnit(HttpUserUnit object) {
				return createHttpUserUnitAdapter();
			}
			public Object defaultCase(EObject object) {
				return createEObjectAdapter();
			}
		};

	/**
	 * Creates an adapter for the <code>target</code>. <!-- begin-user-doc --> <!-- end-user-doc
	 * -->
	 * 
	 * @param target
	 *           the object to adapt.
	 * @return the adapter for the <code>target</code>.
	 * @generated
	 */
	public Adapter createAdapter(Notifier target) {
		return (Adapter)modelSwitch.doSwitch((EObject)target);
	}

	/**
	 * Creates a new adapter for an object of class '{@link com.ibm.ccl.soa.deploy.ihs.IHSDeployRoot <em>IHS Deploy Root</em>}'.
	 * <!-- begin-user-doc --> This default implementation returns null so that we can easily ignore
	 * cases; it's useful to ignore a case when inheritance will catch all the cases anyway. <!--
	 * end-user-doc -->
	 * @return the new adapter.
	 * @see com.ibm.ccl.soa.deploy.ihs.IHSDeployRoot
	 * @generated
	 */
	public Adapter createIHSDeployRootAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link com.ibm.ccl.soa.deploy.ihs.IhsModule <em>Module</em>}'.
	 * <!-- begin-user-doc --> This default implementation returns null so that we can easily ignore
	 * cases; it's useful to ignore a case when inheritance will catch all the cases anyway. <!--
	 * end-user-doc -->
	 * @return the new adapter.
	 * @see com.ibm.ccl.soa.deploy.ihs.IhsModule
	 * @generated
	 */
	public Adapter createIhsModuleAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link com.ibm.ccl.soa.deploy.ihs.IhsServer <em>Server</em>}'.
	 * <!-- begin-user-doc --> This default implementation returns null so that we can easily ignore
	 * cases; it's useful to ignore a case when inheritance will catch all the cases anyway. <!--
	 * end-user-doc -->
	 * @return the new adapter.
	 * @see com.ibm.ccl.soa.deploy.ihs.IhsServer
	 * @generated
	 */
	public Adapter createIhsServerAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link com.ibm.ccl.soa.deploy.ihs.IhsServerUnit <em>Server Unit</em>}'.
	 * <!-- begin-user-doc --> This default implementation returns null so that we can easily ignore
	 * cases; it's useful to ignore a case when inheritance will catch all the cases anyway. <!--
	 * end-user-doc -->
	 * @return the new adapter.
	 * @see com.ibm.ccl.soa.deploy.ihs.IhsServerUnit
	 * @generated
	 */
	public Adapter createIhsServerUnitAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link com.ibm.ccl.soa.deploy.ihs.IhsSystem <em>System</em>}'.
	 * <!-- begin-user-doc --> This default implementation returns null so that we can easily ignore
	 * cases; it's useful to ignore a case when inheritance will catch all the cases anyway. <!--
	 * end-user-doc -->
	 * @return the new adapter.
	 * @see com.ibm.ccl.soa.deploy.ihs.IhsSystem
	 * @generated
	 */
	public Adapter createIhsSystemAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link com.ibm.ccl.soa.deploy.ihs.IhsSystemUnit <em>System Unit</em>}'.
	 * <!-- begin-user-doc --> This default implementation returns null so that we can easily ignore
	 * cases; it's useful to ignore a case when inheritance will catch all the cases anyway. <!--
	 * end-user-doc -->
	 * @return the new adapter.
	 * @see com.ibm.ccl.soa.deploy.ihs.IhsSystemUnit
	 * @generated
	 */
	public Adapter createIhsSystemUnitAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link com.ibm.ccl.soa.deploy.ihs.IhsUser <em>User</em>}'.
	 * <!-- begin-user-doc --> This default implementation returns null so that we can easily ignore
	 * cases; it's useful to ignore a case when inheritance will catch all the cases anyway. <!--
	 * end-user-doc -->
	 * @return the new adapter.
	 * @see com.ibm.ccl.soa.deploy.ihs.IhsUser
	 * @generated
	 */
	public Adapter createIhsUserAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link com.ibm.ccl.soa.deploy.ihs.IhsUserRepository <em>User Repository</em>}'.
	 * <!-- begin-user-doc --> This default implementation returns null so that we can easily ignore
	 * cases; it's useful to ignore a case when inheritance will catch all the cases anyway. <!--
	 * end-user-doc -->
	 * @return the new adapter.
	 * @see com.ibm.ccl.soa.deploy.ihs.IhsUserRepository
	 * @generated
	 */
	public Adapter createIhsUserRepositoryAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link com.ibm.ccl.soa.deploy.ihs.IhsUserUnit <em>User Unit</em>}'.
	 * <!-- begin-user-doc --> This default implementation returns null so that we can easily ignore
	 * cases; it's useful to ignore a case when inheritance will catch all the cases anyway. <!--
	 * end-user-doc -->
	 * @return the new adapter.
	 * @see com.ibm.ccl.soa.deploy.ihs.IhsUserUnit
	 * @generated
	 */
	public Adapter createIhsUserUnitAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link com.ibm.ccl.soa.deploy.ihs.IhsWasAdminModule <em>Was Admin Module</em>}'.
	 * <!-- begin-user-doc --> This default implementation returns null so that we can easily ignore
	 * cases; it's useful to ignore a case when inheritance will catch all the cases anyway. <!--
	 * end-user-doc -->
	 * @return the new adapter.
	 * @see com.ibm.ccl.soa.deploy.ihs.IhsWasAdminModule
	 * @generated
	 */
	public Adapter createIhsWasAdminModuleAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link com.ibm.ccl.soa.deploy.ihs.IhsWasAdminModuleUnit <em>Was Admin Module Unit</em>}'.
	 * <!-- begin-user-doc --> This default implementation returns null so that we can easily ignore
	 * cases; it's useful to ignore a case when inheritance will catch all the cases anyway. <!--
	 * end-user-doc -->
	 * @return the new adapter.
	 * @see com.ibm.ccl.soa.deploy.ihs.IhsWasAdminModuleUnit
	 * @generated
	 */
	public Adapter createIhsWasAdminModuleUnitAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link com.ibm.ccl.soa.deploy.ihs.IhsWasModule <em>Was Module</em>}'.
	 * <!-- begin-user-doc --> This default implementation returns null so that we can easily ignore
	 * cases; it's useful to ignore a case when inheritance will catch all the cases anyway. <!--
	 * end-user-doc -->
	 * @return the new adapter.
	 * @see com.ibm.ccl.soa.deploy.ihs.IhsWasModule
	 * @generated
	 */
	public Adapter createIhsWasModuleAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link com.ibm.ccl.soa.deploy.ihs.IhsWasModuleUnit <em>Was Module Unit</em>}'.
	 * <!-- begin-user-doc --> This default implementation returns null so that we can easily ignore
	 * cases; it's useful to ignore a case when inheritance will catch all the cases anyway. <!--
	 * end-user-doc -->
	 * @return the new adapter.
	 * @see com.ibm.ccl.soa.deploy.ihs.IhsWasModuleUnit
	 * @generated
	 */
	public Adapter createIhsWasModuleUnitAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link com.ibm.ccl.soa.deploy.ihs.LinuxIhsSystem <em>Linux Ihs System</em>}'.
	 * <!-- begin-user-doc --> This default implementation returns null so that we can easily ignore
	 * cases; it's useful to ignore a case when inheritance will catch all the cases anyway. <!--
	 * end-user-doc -->
	 * @return the new adapter.
	 * @see com.ibm.ccl.soa.deploy.ihs.LinuxIhsSystem
	 * @generated
	 */
	public Adapter createLinuxIhsSystemAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link com.ibm.ccl.soa.deploy.ihs.WindowsIhsSystem <em>Windows Ihs System</em>}'.
	 * <!-- begin-user-doc --> This default implementation returns null so that we can easily ignore
	 * cases; it's useful to ignore a case when inheritance will catch all the cases anyway. <!--
	 * end-user-doc -->
	 * @return the new adapter.
	 * @see com.ibm.ccl.soa.deploy.ihs.WindowsIhsSystem
	 * @generated
	 */
	public Adapter createWindowsIhsSystemAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link com.ibm.ccl.soa.deploy.core.DeployModelObject <em>Deploy Model Object</em>}'.
	 * <!-- begin-user-doc --> This default implementation returns null so that we can easily ignore
	 * cases; it's useful to ignore a case when inheritance will catch all the cases anyway. <!--
	 * end-user-doc -->
	 * @return the new adapter.
	 * @see com.ibm.ccl.soa.deploy.core.DeployModelObject
	 * @generated
	 */
	public Adapter createDeployModelObjectAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link com.ibm.ccl.soa.deploy.core.Capability <em>Capability</em>}'.
	 * <!-- begin-user-doc --> This default implementation returns null so that we can easily ignore
	 * cases; it's useful to ignore a case when inheritance will catch all the cases anyway. <!--
	 * end-user-doc -->
	 * @return the new adapter.
	 * @see com.ibm.ccl.soa.deploy.core.Capability
	 * @generated
	 */
	public Adapter createCapabilityAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link com.ibm.ccl.soa.deploy.http.HttpServer <em>Server</em>}'.
	 * <!-- begin-user-doc --> This default implementation returns null so that we can easily ignore
	 * cases; it's useful to ignore a case when inheritance will catch all the cases anyway. <!--
	 * end-user-doc -->
	 * @return the new adapter.
	 * @see com.ibm.ccl.soa.deploy.http.HttpServer
	 * @generated
	 */
	public Adapter createHttpServerAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link com.ibm.ccl.soa.deploy.core.Unit <em>Unit</em>}'.
	 * <!-- begin-user-doc --> This default implementation returns null so that we can easily ignore
	 * cases; it's useful to ignore a case when inheritance will catch all the cases anyway. <!--
	 * end-user-doc -->
	 * @return the new adapter.
	 * @see com.ibm.ccl.soa.deploy.core.Unit
	 * @generated
	 */
	public Adapter createUnitAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link com.ibm.ccl.soa.deploy.http.HttpServerUnit <em>Server Unit</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see com.ibm.ccl.soa.deploy.http.HttpServerUnit
	 * @generated
	 */
	public Adapter createHttpServerUnitAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link com.ibm.ccl.soa.deploy.http.HttpUser <em>User</em>}'.
	 * <!-- begin-user-doc --> This default implementation returns null so that we can easily ignore
	 * cases; it's useful to ignore a case when inheritance will catch all the cases anyway. <!--
	 * end-user-doc -->
	 * @return the new adapter.
	 * @see com.ibm.ccl.soa.deploy.http.HttpUser
	 * @generated
	 */
	public Adapter createHttpUserAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link com.ibm.ccl.soa.deploy.http.HttpUserUnit <em>User Unit</em>}'.
	 * <!-- begin-user-doc --> This default implementation returns null so that we can easily ignore
	 * cases; it's useful to ignore a case when inheritance will catch all the cases anyway. <!--
	 * end-user-doc -->
	 * @return the new adapter.
	 * @see com.ibm.ccl.soa.deploy.http.HttpUserUnit
	 * @generated
	 */
	public Adapter createHttpUserUnitAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for the default case.
	 * <!-- begin-user-doc --> This default
	 * implementation returns null. <!-- end-user-doc -->
	 * @return the new adapter.
	 * @generated
	 */
	public Adapter createEObjectAdapter() {
		return null;
	}

} //IhsAdapterFactory
