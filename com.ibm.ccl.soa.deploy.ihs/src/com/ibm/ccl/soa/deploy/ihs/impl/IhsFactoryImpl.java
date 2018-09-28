/*******************************************************************************
 * Copyright (c) 2003, 2007 IBM Corporation Licensed Material - Property of IBM. All rights reserved.
 *  
 * US Government Users Restricted Rights - Use, duplication or disclosure v1.0 restricted by GSA ADP
 * Schedule Contract with IBM Corp.
 * 
 * Contributors: IBM Corporation - initial API and implementation
 *******************************************************************************/
package com.ibm.ccl.soa.deploy.ihs.impl;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EDataType;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.impl.EFactoryImpl;
import org.eclipse.emf.ecore.plugin.EcorePlugin;

import com.ibm.ccl.soa.deploy.ihs.IHSDeployRoot;
import com.ibm.ccl.soa.deploy.ihs.IHSServerPortNames;
import com.ibm.ccl.soa.deploy.ihs.IhsFactory;
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
 * <!-- begin-user-doc --> An implementation of the model <b>Factory</b>. <!-- end-user-doc -->
 * @generated
 */
public class IhsFactoryImpl extends EFactoryImpl implements IhsFactory {
	/**
	 * Creates the default factory implementation.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public static IhsFactory init() {
		try {
			IhsFactory theIhsFactory = (IhsFactory)EPackage.Registry.INSTANCE.getEFactory("http://www.ibm.com/ccl/soa/deploy/ihs/1.0.0/"); //$NON-NLS-1$ 
			if (theIhsFactory != null) {
				return theIhsFactory;
			}
		}
		catch (Exception exception) {
			EcorePlugin.INSTANCE.log(exception);
		}
		return new IhsFactoryImpl();
	}

	/**
	 * Creates an instance of the factory.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public IhsFactoryImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EObject create(EClass eClass) {
		switch (eClass.getClassifierID()) {
			case IhsPackage.IHS_DEPLOY_ROOT: return createIHSDeployRoot();
			case IhsPackage.IHS_MODULE: return createIhsModule();
			case IhsPackage.IHS_SERVER: return createIhsServer();
			case IhsPackage.IHS_SERVER_UNIT: return createIhsServerUnit();
			case IhsPackage.IHS_SYSTEM: return createIhsSystem();
			case IhsPackage.IHS_SYSTEM_UNIT: return createIhsSystemUnit();
			case IhsPackage.IHS_USER: return createIhsUser();
			case IhsPackage.IHS_USER_REPOSITORY: return createIhsUserRepository();
			case IhsPackage.IHS_USER_UNIT: return createIhsUserUnit();
			case IhsPackage.IHS_WAS_ADMIN_MODULE: return createIhsWasAdminModule();
			case IhsPackage.IHS_WAS_ADMIN_MODULE_UNIT: return createIhsWasAdminModuleUnit();
			case IhsPackage.IHS_WAS_MODULE: return createIhsWasModule();
			case IhsPackage.IHS_WAS_MODULE_UNIT: return createIhsWasModuleUnit();
			case IhsPackage.LINUX_IHS_SYSTEM: return createLinuxIhsSystem();
			case IhsPackage.WINDOWS_IHS_SYSTEM: return createWindowsIhsSystem();
			default:
				throw new IllegalArgumentException("The class '" + eClass.getName() + "' is not a valid classifier"); //$NON-NLS-1$ //$NON-NLS-2$
		}
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public Object createFromString(EDataType eDataType, String initialValue) {
		switch (eDataType.getClassifierID()) {
			case IhsPackage.IHS_SERVER_PORT_NAMES:
				return createIHSServerPortNamesFromString(eDataType, initialValue);
			case IhsPackage.IHS_SERVER_PORT_NAMES_OBJECT:
				return createIHSServerPortNamesObjectFromString(eDataType, initialValue);
			default:
				throw new IllegalArgumentException("The datatype '" + eDataType.getName() + "' is not a valid classifier"); //$NON-NLS-1$ //$NON-NLS-2$
		}
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public String convertToString(EDataType eDataType, Object instanceValue) {
		switch (eDataType.getClassifierID()) {
			case IhsPackage.IHS_SERVER_PORT_NAMES:
				return convertIHSServerPortNamesToString(eDataType, instanceValue);
			case IhsPackage.IHS_SERVER_PORT_NAMES_OBJECT:
				return convertIHSServerPortNamesObjectToString(eDataType, instanceValue);
			default:
				throw new IllegalArgumentException("The datatype '" + eDataType.getName() + "' is not a valid classifier"); //$NON-NLS-1$ //$NON-NLS-2$
		}
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public IHSDeployRoot createIHSDeployRoot() {
		IHSDeployRootImpl ihsDeployRoot = new IHSDeployRootImpl();
		return ihsDeployRoot;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public IhsModule createIhsModule() {
		IhsModuleImpl ihsModule = new IhsModuleImpl();
		return ihsModule;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public IhsServer createIhsServer() {
		IhsServerImpl ihsServer = new IhsServerImpl();
		return ihsServer;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public IhsServerUnit createIhsServerUnit() {
		IhsServerUnitImpl ihsServerUnit = new IhsServerUnitImpl();
		return ihsServerUnit;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public IhsSystem createIhsSystem() {
		IhsSystemImpl ihsSystem = new IhsSystemImpl();
		return ihsSystem;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public IhsSystemUnit createIhsSystemUnit() {
		IhsSystemUnitImpl ihsSystemUnit = new IhsSystemUnitImpl();
		return ihsSystemUnit;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public IhsUser createIhsUser() {
		IhsUserImpl ihsUser = new IhsUserImpl();
		return ihsUser;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public IhsUserRepository createIhsUserRepository() {
		IhsUserRepositoryImpl ihsUserRepository = new IhsUserRepositoryImpl();
		return ihsUserRepository;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public IhsUserUnit createIhsUserUnit() {
		IhsUserUnitImpl ihsUserUnit = new IhsUserUnitImpl();
		return ihsUserUnit;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public IhsWasAdminModule createIhsWasAdminModule() {
		IhsWasAdminModuleImpl ihsWasAdminModule = new IhsWasAdminModuleImpl();
		return ihsWasAdminModule;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public IhsWasAdminModuleUnit createIhsWasAdminModuleUnit() {
		IhsWasAdminModuleUnitImpl ihsWasAdminModuleUnit = new IhsWasAdminModuleUnitImpl();
		return ihsWasAdminModuleUnit;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public IhsWasModule createIhsWasModule() {
		IhsWasModuleImpl ihsWasModule = new IhsWasModuleImpl();
		return ihsWasModule;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public IhsWasModuleUnit createIhsWasModuleUnit() {
		IhsWasModuleUnitImpl ihsWasModuleUnit = new IhsWasModuleUnitImpl();
		return ihsWasModuleUnit;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public LinuxIhsSystem createLinuxIhsSystem() {
		LinuxIhsSystemImpl linuxIhsSystem = new LinuxIhsSystemImpl();
		return linuxIhsSystem;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public WindowsIhsSystem createWindowsIhsSystem() {
		WindowsIhsSystemImpl windowsIhsSystem = new WindowsIhsSystemImpl();
		return windowsIhsSystem;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public IHSServerPortNames createIHSServerPortNamesFromString(EDataType eDataType,
			String initialValue) {
		IHSServerPortNames result = IHSServerPortNames.get(initialValue);
		if (result == null) throw new IllegalArgumentException("The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'"); //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
		return result;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public String convertIHSServerPortNamesToString(EDataType eDataType, Object instanceValue) {
		return instanceValue == null ? null : instanceValue.toString();
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public IHSServerPortNames createIHSServerPortNamesObjectFromString(EDataType eDataType,
			String initialValue) {
		return createIHSServerPortNamesFromString(IhsPackage.Literals.IHS_SERVER_PORT_NAMES, initialValue);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public String convertIHSServerPortNamesObjectToString(EDataType eDataType, Object instanceValue) {
		return convertIHSServerPortNamesToString(IhsPackage.Literals.IHS_SERVER_PORT_NAMES, instanceValue);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public IhsPackage getIhsPackage() {
		return (IhsPackage)getEPackage();
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @deprecated
	 * @generated
	 */
	public static IhsPackage getPackage() {
		return IhsPackage.eINSTANCE;
	}

} //IhsFactoryImpl
