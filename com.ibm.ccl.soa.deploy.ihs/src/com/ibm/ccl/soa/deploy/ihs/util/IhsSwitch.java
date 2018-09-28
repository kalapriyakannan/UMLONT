/*******************************************************************************
 * Copyright (c) 2003, 2007 IBM Corporation Licensed Material - Property of IBM. All rights reserved.
 *  
 * US Government Users Restricted Rights - Use, duplication or disclosure v1.0 restricted by GSA ADP
 * Schedule Contract with IBM Corp.
 * 
 * Contributors: IBM Corporation - initial API and implementation
 *******************************************************************************/
package com.ibm.ccl.soa.deploy.ihs.util;

import java.util.List;

import org.eclipse.emf.ecore.EClass;
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
 * <!-- begin-user-doc --> The <b>Switch</b> for the model's inheritance hierarchy. It supports the
 * call {@link #doSwitch(EObject) doSwitch(object)} to invoke the <code>caseXXX</code> method for
 * each class of the model, starting with the actual class of the object and proceeding up the
 * inheritance hierarchy until a non-null result is returned, which is the result of the switch.
 * <!-- end-user-doc -->
 * @see com.ibm.ccl.soa.deploy.ihs.IhsPackage
 * @generated
 */
public class IhsSwitch {
	/**
	 * The cached model package
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	protected static IhsPackage modelPackage;

	/**
	 * Creates an instance of the switch.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public IhsSwitch() {
		if (modelPackage == null) {
			modelPackage = IhsPackage.eINSTANCE;
		}
	}

	/**
	 * Calls <code>caseXXX</code> for each class of the model until one returns a non null result; it yields that result.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return the first non-null result returned by a <code>caseXXX</code> call.
	 * @generated
	 */
	public Object doSwitch(EObject theEObject) {
		return doSwitch(theEObject.eClass(), theEObject);
	}

	/**
	 * Calls <code>caseXXX</code> for each class of the model until one returns a non null result; it yields that result.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
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
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return the first non-null result returned by a <code>caseXXX</code> call.
	 * @generated
	 */
	protected Object doSwitch(int classifierID, EObject theEObject) {
		switch (classifierID) {
			case IhsPackage.IHS_DEPLOY_ROOT: {
				IHSDeployRoot ihsDeployRoot = (IHSDeployRoot)theEObject;
				Object result = caseIHSDeployRoot(ihsDeployRoot);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case IhsPackage.IHS_MODULE: {
				IhsModule ihsModule = (IhsModule)theEObject;
				Object result = caseIhsModule(ihsModule);
				if (result == null) result = caseCapability(ihsModule);
				if (result == null) result = caseDeployModelObject(ihsModule);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case IhsPackage.IHS_SERVER: {
				IhsServer ihsServer = (IhsServer)theEObject;
				Object result = caseIhsServer(ihsServer);
				if (result == null) result = caseHttpServer(ihsServer);
				if (result == null) result = caseCapability(ihsServer);
				if (result == null) result = caseDeployModelObject(ihsServer);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case IhsPackage.IHS_SERVER_UNIT: {
				IhsServerUnit ihsServerUnit = (IhsServerUnit)theEObject;
				Object result = caseIhsServerUnit(ihsServerUnit);
				if (result == null) result = caseHttpServerUnit(ihsServerUnit);
				if (result == null) result = caseUnit(ihsServerUnit);
				if (result == null) result = caseDeployModelObject(ihsServerUnit);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case IhsPackage.IHS_SYSTEM: {
				IhsSystem ihsSystem = (IhsSystem)theEObject;
				Object result = caseIhsSystem(ihsSystem);
				if (result == null) result = caseCapability(ihsSystem);
				if (result == null) result = caseDeployModelObject(ihsSystem);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case IhsPackage.IHS_SYSTEM_UNIT: {
				IhsSystemUnit ihsSystemUnit = (IhsSystemUnit)theEObject;
				Object result = caseIhsSystemUnit(ihsSystemUnit);
				if (result == null) result = caseUnit(ihsSystemUnit);
				if (result == null) result = caseDeployModelObject(ihsSystemUnit);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case IhsPackage.IHS_USER: {
				IhsUser ihsUser = (IhsUser)theEObject;
				Object result = caseIhsUser(ihsUser);
				if (result == null) result = caseHttpUser(ihsUser);
				if (result == null) result = caseCapability(ihsUser);
				if (result == null) result = caseDeployModelObject(ihsUser);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case IhsPackage.IHS_USER_REPOSITORY: {
				IhsUserRepository ihsUserRepository = (IhsUserRepository)theEObject;
				Object result = caseIhsUserRepository(ihsUserRepository);
				if (result == null) result = caseCapability(ihsUserRepository);
				if (result == null) result = caseDeployModelObject(ihsUserRepository);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case IhsPackage.IHS_USER_UNIT: {
				IhsUserUnit ihsUserUnit = (IhsUserUnit)theEObject;
				Object result = caseIhsUserUnit(ihsUserUnit);
				if (result == null) result = caseHttpUserUnit(ihsUserUnit);
				if (result == null) result = caseUnit(ihsUserUnit);
				if (result == null) result = caseDeployModelObject(ihsUserUnit);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case IhsPackage.IHS_WAS_ADMIN_MODULE: {
				IhsWasAdminModule ihsWasAdminModule = (IhsWasAdminModule)theEObject;
				Object result = caseIhsWasAdminModule(ihsWasAdminModule);
				if (result == null) result = caseIhsModule(ihsWasAdminModule);
				if (result == null) result = caseCapability(ihsWasAdminModule);
				if (result == null) result = caseDeployModelObject(ihsWasAdminModule);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case IhsPackage.IHS_WAS_ADMIN_MODULE_UNIT: {
				IhsWasAdminModuleUnit ihsWasAdminModuleUnit = (IhsWasAdminModuleUnit)theEObject;
				Object result = caseIhsWasAdminModuleUnit(ihsWasAdminModuleUnit);
				if (result == null) result = caseUnit(ihsWasAdminModuleUnit);
				if (result == null) result = caseDeployModelObject(ihsWasAdminModuleUnit);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case IhsPackage.IHS_WAS_MODULE: {
				IhsWasModule ihsWasModule = (IhsWasModule)theEObject;
				Object result = caseIhsWasModule(ihsWasModule);
				if (result == null) result = caseIhsModule(ihsWasModule);
				if (result == null) result = caseCapability(ihsWasModule);
				if (result == null) result = caseDeployModelObject(ihsWasModule);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case IhsPackage.IHS_WAS_MODULE_UNIT: {
				IhsWasModuleUnit ihsWasModuleUnit = (IhsWasModuleUnit)theEObject;
				Object result = caseIhsWasModuleUnit(ihsWasModuleUnit);
				if (result == null) result = caseUnit(ihsWasModuleUnit);
				if (result == null) result = caseDeployModelObject(ihsWasModuleUnit);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case IhsPackage.LINUX_IHS_SYSTEM: {
				LinuxIhsSystem linuxIhsSystem = (LinuxIhsSystem)theEObject;
				Object result = caseLinuxIhsSystem(linuxIhsSystem);
				if (result == null) result = caseIhsSystem(linuxIhsSystem);
				if (result == null) result = caseCapability(linuxIhsSystem);
				if (result == null) result = caseDeployModelObject(linuxIhsSystem);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case IhsPackage.WINDOWS_IHS_SYSTEM: {
				WindowsIhsSystem windowsIhsSystem = (WindowsIhsSystem)theEObject;
				Object result = caseWindowsIhsSystem(windowsIhsSystem);
				if (result == null) result = caseIhsSystem(windowsIhsSystem);
				if (result == null) result = caseCapability(windowsIhsSystem);
				if (result == null) result = caseDeployModelObject(windowsIhsSystem);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			default: return defaultCase(theEObject);
		}
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>IHS Deploy Root</em>'.
	 * <!-- begin-user-doc --> This implementation returns null; returning a non-null result will
	 * terminate the switch. <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>IHS Deploy Root</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public Object caseIHSDeployRoot(IHSDeployRoot object) {
		return null;
	}

	/**
	 * Returns the result of interpretting the object as an instance of '<em>Module</em>'. <!--
	 * begin-user-doc --> This implementation returns null; returning a non-null result will
	 * terminate the switch. <!-- end-user-doc -->
	 * 
	 * @param object
	 *           the target of the switch.
	 * @return the result of interpretting the object as an instance of '<em>Module</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public Object caseIhsModule(IhsModule object) {
		return null;
	}

	/**
	 * Returns the result of interpretting the object as an instance of '<em>Server</em>'. <!--
	 * begin-user-doc --> This implementation returns null; returning a non-null result will
	 * terminate the switch. <!-- end-user-doc -->
	 * 
	 * @param object
	 *           the target of the switch.
	 * @return the result of interpretting the object as an instance of '<em>Server</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public Object caseIhsServer(IhsServer object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Server Unit</em>'.
	 * <!-- begin-user-doc --> This implementation returns null; returning a non-null result will
	 * terminate the switch. <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Server Unit</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public Object caseIhsServerUnit(IhsServerUnit object) {
		return null;
	}

	/**
	 * Returns the result of interpretting the object as an instance of '<em>System</em>'. <!--
	 * begin-user-doc --> This implementation returns null; returning a non-null result will
	 * terminate the switch. <!-- end-user-doc -->
	 * 
	 * @param object
	 *           the target of the switch.
	 * @return the result of interpretting the object as an instance of '<em>System</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public Object caseIhsSystem(IhsSystem object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>System Unit</em>'.
	 * <!-- begin-user-doc --> This implementation returns null; returning a non-null result will
	 * terminate the switch. <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>System Unit</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public Object caseIhsSystemUnit(IhsSystemUnit object) {
		return null;
	}

	/**
	 * Returns the result of interpretting the object as an instance of '<em>User</em>'. <!--
	 * begin-user-doc --> This implementation returns null; returning a non-null result will
	 * terminate the switch. <!-- end-user-doc -->
	 * 
	 * @param object
	 *           the target of the switch.
	 * @return the result of interpretting the object as an instance of '<em>User</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public Object caseIhsUser(IhsUser object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>User Repository</em>'.
	 * <!-- begin-user-doc --> This implementation returns null; returning a non-null result will
	 * terminate the switch. <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>User Repository</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public Object caseIhsUserRepository(IhsUserRepository object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>User Unit</em>'.
	 * <!-- begin-user-doc --> This implementation returns null; returning a non-null result will
	 * terminate the switch. <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>User Unit</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public Object caseIhsUserUnit(IhsUserUnit object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Was Admin Module</em>'.
	 * <!-- begin-user-doc --> This implementation returns null; returning a non-null result will
	 * terminate the switch. <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Was Admin Module</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public Object caseIhsWasAdminModule(IhsWasAdminModule object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Was Admin Module Unit</em>'.
	 * <!-- begin-user-doc --> This implementation returns null; returning a non-null result will
	 * terminate the switch. <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Was Admin Module Unit</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public Object caseIhsWasAdminModuleUnit(IhsWasAdminModuleUnit object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Was Module</em>'.
	 * <!-- begin-user-doc --> This implementation returns null; returning a non-null result will
	 * terminate the switch. <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Was Module</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public Object caseIhsWasModule(IhsWasModule object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Was Module Unit</em>'.
	 * <!-- begin-user-doc --> This implementation returns null; returning a non-null result will
	 * terminate the switch. <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Was Module Unit</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public Object caseIhsWasModuleUnit(IhsWasModuleUnit object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Linux Ihs System</em>'.
	 * <!-- begin-user-doc --> This implementation returns null; returning a non-null result will
	 * terminate the switch. <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Linux Ihs System</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public Object caseLinuxIhsSystem(LinuxIhsSystem object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Windows Ihs System</em>'.
	 * <!-- begin-user-doc --> This implementation returns null; returning a non-null result will
	 * terminate the switch. <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Windows Ihs System</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public Object caseWindowsIhsSystem(WindowsIhsSystem object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Deploy Model Object</em>'.
	 * <!-- begin-user-doc --> This implementation returns null; returning a non-null result will
	 * terminate the switch. <!-- end-user-doc -->
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
	 * <!-- begin-user-doc --> This implementation returns null; returning a non-null result will
	 * terminate the switch. <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Capability</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public Object caseCapability(Capability object) {
		return null;
	}

	/**
	 * Returns the result of interpretting the object as an instance of '<em>Server</em>'. <!--
	 * begin-user-doc --> This implementation returns null; returning a non-null result will
	 * terminate the switch. <!-- end-user-doc -->
	 * 
	 * @param object
	 *           the target of the switch.
	 * @return the result of interpretting the object as an instance of '<em>Server</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public Object caseHttpServer(HttpServer object) {
		return null;
	}

	/**
	 * Returns the result of interpretting the object as an instance of '<em>Unit</em>'. <!--
	 * begin-user-doc --> This implementation returns null; returning a non-null result will
	 * terminate the switch. <!-- end-user-doc -->
	 * 
	 * @param object
	 *           the target of the switch.
	 * @return the result of interpretting the object as an instance of '<em>Unit</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public Object caseUnit(Unit object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Server Unit</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Server Unit</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public Object caseHttpServerUnit(HttpServerUnit object) {
		return null;
	}

	/**
	 * Returns the result of interpretting the object as an instance of '<em>User</em>'. <!--
	 * begin-user-doc --> This implementation returns null; returning a non-null result will
	 * terminate the switch. <!-- end-user-doc -->
	 * 
	 * @param object
	 *           the target of the switch.
	 * @return the result of interpretting the object as an instance of '<em>User</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public Object caseHttpUser(HttpUser object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>User Unit</em>'.
	 * <!-- begin-user-doc --> This implementation returns null; returning a non-null result will
	 * terminate the switch. <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>User Unit</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public Object caseHttpUserUnit(HttpUserUnit object) {
		return null;
	}

	/**
	 * Returns the result of interpretting the object as an instance of '<em>EObject</em>'. <!--
	 * begin-user-doc --> This implementation returns null; returning a non-null result will
	 * terminate the switch, but this is the last case anyway. <!-- end-user-doc -->
	 * 
	 * @param object
	 *           the target of the switch.
	 * @return the result of interpretting the object as an instance of '<em>EObject</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject)
	 * @generated
	 */
	public Object defaultCase(EObject object) {
		return null;
	}

} //IhsSwitch
