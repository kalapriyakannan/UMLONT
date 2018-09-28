/*******************************************************************************
 * Copyright (c) 2003, 2007 IBM Corporation Licensed Material - Property of IBM. All rights reserved.
 *  
 * US Government Users Restricted Rights - Use, duplication or disclosure v1.0 restricted by GSA ADP
 * Schedule Contract with IBM Corp.
 * 
 * Contributors: IBM Corporation - initial API and implementation
 *******************************************************************************/
package com.ibm.ccl.soa.deploy.ihs.impl;

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
 * <!-- begin-user-doc --> An implementation of the model object '<em><b>IHS Deploy Root</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link com.ibm.ccl.soa.deploy.ihs.impl.IHSDeployRootImpl#getMixed <em>Mixed</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.ihs.impl.IHSDeployRootImpl#getXMLNSPrefixMap <em>XMLNS Prefix Map</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.ihs.impl.IHSDeployRootImpl#getXSISchemaLocation <em>XSI Schema Location</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.ihs.impl.IHSDeployRootImpl#getCapabilityIhsModule <em>Capability Ihs Module</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.ihs.impl.IHSDeployRootImpl#getCapabilityIhsServer <em>Capability Ihs Server</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.ihs.impl.IHSDeployRootImpl#getCapabilityIhsSystem <em>Capability Ihs System</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.ihs.impl.IHSDeployRootImpl#getCapabilityIhsUser <em>Capability Ihs User</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.ihs.impl.IHSDeployRootImpl#getCapabilityIhsUserRepository <em>Capability Ihs User Repository</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.ihs.impl.IHSDeployRootImpl#getCapabilityIhsWasAdminModule <em>Capability Ihs Was Admin Module</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.ihs.impl.IHSDeployRootImpl#getCapabilityIhsWasModule <em>Capability Ihs Was Module</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.ihs.impl.IHSDeployRootImpl#getCapabilityLinuxIhsSystem <em>Capability Linux Ihs System</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.ihs.impl.IHSDeployRootImpl#getCapabilityWindowsIhsSystem <em>Capability Windows Ihs System</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.ihs.impl.IHSDeployRootImpl#getUnitIhsServerUnit <em>Unit Ihs Server Unit</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.ihs.impl.IHSDeployRootImpl#getUnitIhsSystemUnit <em>Unit Ihs System Unit</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.ihs.impl.IHSDeployRootImpl#getUnitIhsUserUnit <em>Unit Ihs User Unit</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.ihs.impl.IHSDeployRootImpl#getUnitIhsWasAdminModuleUnit <em>Unit Ihs Was Admin Module Unit</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.ihs.impl.IHSDeployRootImpl#getUnitIhsWasModuleUnit <em>Unit Ihs Was Module Unit</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class IHSDeployRootImpl extends EObjectImpl implements IHSDeployRoot {
	/**
	 * The cached value of the '{@link #getMixed() <em>Mixed</em>}' attribute list. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see #getMixed()
	 * @generated
	 * @ordered
	 */
	protected FeatureMap mixed;

	/**
	 * The cached value of the '{@link #getXMLNSPrefixMap() <em>XMLNS Prefix Map</em>}' map. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see #getXMLNSPrefixMap()
	 * @generated
	 * @ordered
	 */
	protected EMap xMLNSPrefixMap;

	/**
	 * The cached value of the '{@link #getXSISchemaLocation() <em>XSI Schema Location</em>}' map.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see #getXSISchemaLocation()
	 * @generated
	 * @ordered
	 */
	protected EMap xSISchemaLocation;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	protected IHSDeployRootImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	protected EClass eStaticClass() {
		return IhsPackage.Literals.IHS_DEPLOY_ROOT;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public FeatureMap getMixed() {
		if (mixed == null) {
			mixed = new BasicFeatureMap(this, IhsPackage.IHS_DEPLOY_ROOT__MIXED);
		}
		return mixed;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EMap getXMLNSPrefixMap() {
		if (xMLNSPrefixMap == null) {
			xMLNSPrefixMap = new EcoreEMap(EcorePackage.Literals.ESTRING_TO_STRING_MAP_ENTRY, EStringToStringMapEntryImpl.class, this, IhsPackage.IHS_DEPLOY_ROOT__XMLNS_PREFIX_MAP);
		}
		return xMLNSPrefixMap;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EMap getXSISchemaLocation() {
		if (xSISchemaLocation == null) {
			xSISchemaLocation = new EcoreEMap(EcorePackage.Literals.ESTRING_TO_STRING_MAP_ENTRY, EStringToStringMapEntryImpl.class, this, IhsPackage.IHS_DEPLOY_ROOT__XSI_SCHEMA_LOCATION);
		}
		return xSISchemaLocation;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public IhsModule getCapabilityIhsModule() {
		return (IhsModule)getMixed().get(IhsPackage.Literals.IHS_DEPLOY_ROOT__CAPABILITY_IHS_MODULE, true);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetCapabilityIhsModule(IhsModule newCapabilityIhsModule,
			NotificationChain msgs) {
		return ((FeatureMap.Internal)getMixed()).basicAdd(IhsPackage.Literals.IHS_DEPLOY_ROOT__CAPABILITY_IHS_MODULE, newCapabilityIhsModule, msgs);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public void setCapabilityIhsModule(IhsModule newCapabilityIhsModule) {
		((FeatureMap.Internal)getMixed()).set(IhsPackage.Literals.IHS_DEPLOY_ROOT__CAPABILITY_IHS_MODULE, newCapabilityIhsModule);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public IhsServer getCapabilityIhsServer() {
		return (IhsServer)getMixed().get(IhsPackage.Literals.IHS_DEPLOY_ROOT__CAPABILITY_IHS_SERVER, true);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetCapabilityIhsServer(IhsServer newCapabilityIhsServer,
			NotificationChain msgs) {
		return ((FeatureMap.Internal)getMixed()).basicAdd(IhsPackage.Literals.IHS_DEPLOY_ROOT__CAPABILITY_IHS_SERVER, newCapabilityIhsServer, msgs);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public void setCapabilityIhsServer(IhsServer newCapabilityIhsServer) {
		((FeatureMap.Internal)getMixed()).set(IhsPackage.Literals.IHS_DEPLOY_ROOT__CAPABILITY_IHS_SERVER, newCapabilityIhsServer);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public IhsSystem getCapabilityIhsSystem() {
		return (IhsSystem)getMixed().get(IhsPackage.Literals.IHS_DEPLOY_ROOT__CAPABILITY_IHS_SYSTEM, true);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetCapabilityIhsSystem(IhsSystem newCapabilityIhsSystem,
			NotificationChain msgs) {
		return ((FeatureMap.Internal)getMixed()).basicAdd(IhsPackage.Literals.IHS_DEPLOY_ROOT__CAPABILITY_IHS_SYSTEM, newCapabilityIhsSystem, msgs);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public void setCapabilityIhsSystem(IhsSystem newCapabilityIhsSystem) {
		((FeatureMap.Internal)getMixed()).set(IhsPackage.Literals.IHS_DEPLOY_ROOT__CAPABILITY_IHS_SYSTEM, newCapabilityIhsSystem);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public IhsUser getCapabilityIhsUser() {
		return (IhsUser)getMixed().get(IhsPackage.Literals.IHS_DEPLOY_ROOT__CAPABILITY_IHS_USER, true);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetCapabilityIhsUser(IhsUser newCapabilityIhsUser,
			NotificationChain msgs) {
		return ((FeatureMap.Internal)getMixed()).basicAdd(IhsPackage.Literals.IHS_DEPLOY_ROOT__CAPABILITY_IHS_USER, newCapabilityIhsUser, msgs);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public void setCapabilityIhsUser(IhsUser newCapabilityIhsUser) {
		((FeatureMap.Internal)getMixed()).set(IhsPackage.Literals.IHS_DEPLOY_ROOT__CAPABILITY_IHS_USER, newCapabilityIhsUser);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public IhsUserRepository getCapabilityIhsUserRepository() {
		return (IhsUserRepository)getMixed().get(IhsPackage.Literals.IHS_DEPLOY_ROOT__CAPABILITY_IHS_USER_REPOSITORY, true);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetCapabilityIhsUserRepository(
			IhsUserRepository newCapabilityIhsUserRepository, NotificationChain msgs) {
		return ((FeatureMap.Internal)getMixed()).basicAdd(IhsPackage.Literals.IHS_DEPLOY_ROOT__CAPABILITY_IHS_USER_REPOSITORY, newCapabilityIhsUserRepository, msgs);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public void setCapabilityIhsUserRepository(IhsUserRepository newCapabilityIhsUserRepository) {
		((FeatureMap.Internal)getMixed()).set(IhsPackage.Literals.IHS_DEPLOY_ROOT__CAPABILITY_IHS_USER_REPOSITORY, newCapabilityIhsUserRepository);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public IhsWasAdminModule getCapabilityIhsWasAdminModule() {
		return (IhsWasAdminModule)getMixed().get(IhsPackage.Literals.IHS_DEPLOY_ROOT__CAPABILITY_IHS_WAS_ADMIN_MODULE, true);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetCapabilityIhsWasAdminModule(
			IhsWasAdminModule newCapabilityIhsWasAdminModule, NotificationChain msgs) {
		return ((FeatureMap.Internal)getMixed()).basicAdd(IhsPackage.Literals.IHS_DEPLOY_ROOT__CAPABILITY_IHS_WAS_ADMIN_MODULE, newCapabilityIhsWasAdminModule, msgs);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public void setCapabilityIhsWasAdminModule(IhsWasAdminModule newCapabilityIhsWasAdminModule) {
		((FeatureMap.Internal)getMixed()).set(IhsPackage.Literals.IHS_DEPLOY_ROOT__CAPABILITY_IHS_WAS_ADMIN_MODULE, newCapabilityIhsWasAdminModule);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public IhsWasModule getCapabilityIhsWasModule() {
		return (IhsWasModule)getMixed().get(IhsPackage.Literals.IHS_DEPLOY_ROOT__CAPABILITY_IHS_WAS_MODULE, true);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetCapabilityIhsWasModule(IhsWasModule newCapabilityIhsWasModule,
			NotificationChain msgs) {
		return ((FeatureMap.Internal)getMixed()).basicAdd(IhsPackage.Literals.IHS_DEPLOY_ROOT__CAPABILITY_IHS_WAS_MODULE, newCapabilityIhsWasModule, msgs);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public void setCapabilityIhsWasModule(IhsWasModule newCapabilityIhsWasModule) {
		((FeatureMap.Internal)getMixed()).set(IhsPackage.Literals.IHS_DEPLOY_ROOT__CAPABILITY_IHS_WAS_MODULE, newCapabilityIhsWasModule);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public LinuxIhsSystem getCapabilityLinuxIhsSystem() {
		return (LinuxIhsSystem)getMixed().get(IhsPackage.Literals.IHS_DEPLOY_ROOT__CAPABILITY_LINUX_IHS_SYSTEM, true);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetCapabilityLinuxIhsSystem(
			LinuxIhsSystem newCapabilityLinuxIhsSystem, NotificationChain msgs) {
		return ((FeatureMap.Internal)getMixed()).basicAdd(IhsPackage.Literals.IHS_DEPLOY_ROOT__CAPABILITY_LINUX_IHS_SYSTEM, newCapabilityLinuxIhsSystem, msgs);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public void setCapabilityLinuxIhsSystem(LinuxIhsSystem newCapabilityLinuxIhsSystem) {
		((FeatureMap.Internal)getMixed()).set(IhsPackage.Literals.IHS_DEPLOY_ROOT__CAPABILITY_LINUX_IHS_SYSTEM, newCapabilityLinuxIhsSystem);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public WindowsIhsSystem getCapabilityWindowsIhsSystem() {
		return (WindowsIhsSystem)getMixed().get(IhsPackage.Literals.IHS_DEPLOY_ROOT__CAPABILITY_WINDOWS_IHS_SYSTEM, true);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetCapabilityWindowsIhsSystem(
			WindowsIhsSystem newCapabilityWindowsIhsSystem, NotificationChain msgs) {
		return ((FeatureMap.Internal)getMixed()).basicAdd(IhsPackage.Literals.IHS_DEPLOY_ROOT__CAPABILITY_WINDOWS_IHS_SYSTEM, newCapabilityWindowsIhsSystem, msgs);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public void setCapabilityWindowsIhsSystem(WindowsIhsSystem newCapabilityWindowsIhsSystem) {
		((FeatureMap.Internal)getMixed()).set(IhsPackage.Literals.IHS_DEPLOY_ROOT__CAPABILITY_WINDOWS_IHS_SYSTEM, newCapabilityWindowsIhsSystem);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public IhsServerUnit getUnitIhsServerUnit() {
		return (IhsServerUnit)getMixed().get(IhsPackage.Literals.IHS_DEPLOY_ROOT__UNIT_IHS_SERVER_UNIT, true);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetUnitIhsServerUnit(IhsServerUnit newUnitIhsServerUnit,
			NotificationChain msgs) {
		return ((FeatureMap.Internal)getMixed()).basicAdd(IhsPackage.Literals.IHS_DEPLOY_ROOT__UNIT_IHS_SERVER_UNIT, newUnitIhsServerUnit, msgs);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public void setUnitIhsServerUnit(IhsServerUnit newUnitIhsServerUnit) {
		((FeatureMap.Internal)getMixed()).set(IhsPackage.Literals.IHS_DEPLOY_ROOT__UNIT_IHS_SERVER_UNIT, newUnitIhsServerUnit);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public IhsSystemUnit getUnitIhsSystemUnit() {
		return (IhsSystemUnit)getMixed().get(IhsPackage.Literals.IHS_DEPLOY_ROOT__UNIT_IHS_SYSTEM_UNIT, true);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetUnitIhsSystemUnit(IhsSystemUnit newUnitIhsSystemUnit,
			NotificationChain msgs) {
		return ((FeatureMap.Internal)getMixed()).basicAdd(IhsPackage.Literals.IHS_DEPLOY_ROOT__UNIT_IHS_SYSTEM_UNIT, newUnitIhsSystemUnit, msgs);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public void setUnitIhsSystemUnit(IhsSystemUnit newUnitIhsSystemUnit) {
		((FeatureMap.Internal)getMixed()).set(IhsPackage.Literals.IHS_DEPLOY_ROOT__UNIT_IHS_SYSTEM_UNIT, newUnitIhsSystemUnit);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public IhsUserUnit getUnitIhsUserUnit() {
		return (IhsUserUnit)getMixed().get(IhsPackage.Literals.IHS_DEPLOY_ROOT__UNIT_IHS_USER_UNIT, true);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetUnitIhsUserUnit(IhsUserUnit newUnitIhsUserUnit,
			NotificationChain msgs) {
		return ((FeatureMap.Internal)getMixed()).basicAdd(IhsPackage.Literals.IHS_DEPLOY_ROOT__UNIT_IHS_USER_UNIT, newUnitIhsUserUnit, msgs);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public void setUnitIhsUserUnit(IhsUserUnit newUnitIhsUserUnit) {
		((FeatureMap.Internal)getMixed()).set(IhsPackage.Literals.IHS_DEPLOY_ROOT__UNIT_IHS_USER_UNIT, newUnitIhsUserUnit);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public IhsWasAdminModuleUnit getUnitIhsWasAdminModuleUnit() {
		return (IhsWasAdminModuleUnit)getMixed().get(IhsPackage.Literals.IHS_DEPLOY_ROOT__UNIT_IHS_WAS_ADMIN_MODULE_UNIT, true);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetUnitIhsWasAdminModuleUnit(
			IhsWasAdminModuleUnit newUnitIhsWasAdminModuleUnit, NotificationChain msgs) {
		return ((FeatureMap.Internal)getMixed()).basicAdd(IhsPackage.Literals.IHS_DEPLOY_ROOT__UNIT_IHS_WAS_ADMIN_MODULE_UNIT, newUnitIhsWasAdminModuleUnit, msgs);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public void setUnitIhsWasAdminModuleUnit(IhsWasAdminModuleUnit newUnitIhsWasAdminModuleUnit) {
		((FeatureMap.Internal)getMixed()).set(IhsPackage.Literals.IHS_DEPLOY_ROOT__UNIT_IHS_WAS_ADMIN_MODULE_UNIT, newUnitIhsWasAdminModuleUnit);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public IhsWasModuleUnit getUnitIhsWasModuleUnit() {
		return (IhsWasModuleUnit)getMixed().get(IhsPackage.Literals.IHS_DEPLOY_ROOT__UNIT_IHS_WAS_MODULE_UNIT, true);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetUnitIhsWasModuleUnit(IhsWasModuleUnit newUnitIhsWasModuleUnit,
			NotificationChain msgs) {
		return ((FeatureMap.Internal)getMixed()).basicAdd(IhsPackage.Literals.IHS_DEPLOY_ROOT__UNIT_IHS_WAS_MODULE_UNIT, newUnitIhsWasModuleUnit, msgs);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public void setUnitIhsWasModuleUnit(IhsWasModuleUnit newUnitIhsWasModuleUnit) {
		((FeatureMap.Internal)getMixed()).set(IhsPackage.Literals.IHS_DEPLOY_ROOT__UNIT_IHS_WAS_MODULE_UNIT, newUnitIhsWasModuleUnit);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID,
			NotificationChain msgs) {
		switch (featureID) {
			case IhsPackage.IHS_DEPLOY_ROOT__MIXED:
				return ((InternalEList)getMixed()).basicRemove(otherEnd, msgs);
			case IhsPackage.IHS_DEPLOY_ROOT__XMLNS_PREFIX_MAP:
				return ((InternalEList)getXMLNSPrefixMap()).basicRemove(otherEnd, msgs);
			case IhsPackage.IHS_DEPLOY_ROOT__XSI_SCHEMA_LOCATION:
				return ((InternalEList)getXSISchemaLocation()).basicRemove(otherEnd, msgs);
			case IhsPackage.IHS_DEPLOY_ROOT__CAPABILITY_IHS_MODULE:
				return basicSetCapabilityIhsModule(null, msgs);
			case IhsPackage.IHS_DEPLOY_ROOT__CAPABILITY_IHS_SERVER:
				return basicSetCapabilityIhsServer(null, msgs);
			case IhsPackage.IHS_DEPLOY_ROOT__CAPABILITY_IHS_SYSTEM:
				return basicSetCapabilityIhsSystem(null, msgs);
			case IhsPackage.IHS_DEPLOY_ROOT__CAPABILITY_IHS_USER:
				return basicSetCapabilityIhsUser(null, msgs);
			case IhsPackage.IHS_DEPLOY_ROOT__CAPABILITY_IHS_USER_REPOSITORY:
				return basicSetCapabilityIhsUserRepository(null, msgs);
			case IhsPackage.IHS_DEPLOY_ROOT__CAPABILITY_IHS_WAS_ADMIN_MODULE:
				return basicSetCapabilityIhsWasAdminModule(null, msgs);
			case IhsPackage.IHS_DEPLOY_ROOT__CAPABILITY_IHS_WAS_MODULE:
				return basicSetCapabilityIhsWasModule(null, msgs);
			case IhsPackage.IHS_DEPLOY_ROOT__CAPABILITY_LINUX_IHS_SYSTEM:
				return basicSetCapabilityLinuxIhsSystem(null, msgs);
			case IhsPackage.IHS_DEPLOY_ROOT__CAPABILITY_WINDOWS_IHS_SYSTEM:
				return basicSetCapabilityWindowsIhsSystem(null, msgs);
			case IhsPackage.IHS_DEPLOY_ROOT__UNIT_IHS_SERVER_UNIT:
				return basicSetUnitIhsServerUnit(null, msgs);
			case IhsPackage.IHS_DEPLOY_ROOT__UNIT_IHS_SYSTEM_UNIT:
				return basicSetUnitIhsSystemUnit(null, msgs);
			case IhsPackage.IHS_DEPLOY_ROOT__UNIT_IHS_USER_UNIT:
				return basicSetUnitIhsUserUnit(null, msgs);
			case IhsPackage.IHS_DEPLOY_ROOT__UNIT_IHS_WAS_ADMIN_MODULE_UNIT:
				return basicSetUnitIhsWasAdminModuleUnit(null, msgs);
			case IhsPackage.IHS_DEPLOY_ROOT__UNIT_IHS_WAS_MODULE_UNIT:
				return basicSetUnitIhsWasModuleUnit(null, msgs);
		}
		return super.eInverseRemove(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case IhsPackage.IHS_DEPLOY_ROOT__MIXED:
				if (coreType) return getMixed();
				return ((FeatureMap.Internal)getMixed()).getWrapper();
			case IhsPackage.IHS_DEPLOY_ROOT__XMLNS_PREFIX_MAP:
				if (coreType) return getXMLNSPrefixMap();
				else return getXMLNSPrefixMap().map();
			case IhsPackage.IHS_DEPLOY_ROOT__XSI_SCHEMA_LOCATION:
				if (coreType) return getXSISchemaLocation();
				else return getXSISchemaLocation().map();
			case IhsPackage.IHS_DEPLOY_ROOT__CAPABILITY_IHS_MODULE:
				return getCapabilityIhsModule();
			case IhsPackage.IHS_DEPLOY_ROOT__CAPABILITY_IHS_SERVER:
				return getCapabilityIhsServer();
			case IhsPackage.IHS_DEPLOY_ROOT__CAPABILITY_IHS_SYSTEM:
				return getCapabilityIhsSystem();
			case IhsPackage.IHS_DEPLOY_ROOT__CAPABILITY_IHS_USER:
				return getCapabilityIhsUser();
			case IhsPackage.IHS_DEPLOY_ROOT__CAPABILITY_IHS_USER_REPOSITORY:
				return getCapabilityIhsUserRepository();
			case IhsPackage.IHS_DEPLOY_ROOT__CAPABILITY_IHS_WAS_ADMIN_MODULE:
				return getCapabilityIhsWasAdminModule();
			case IhsPackage.IHS_DEPLOY_ROOT__CAPABILITY_IHS_WAS_MODULE:
				return getCapabilityIhsWasModule();
			case IhsPackage.IHS_DEPLOY_ROOT__CAPABILITY_LINUX_IHS_SYSTEM:
				return getCapabilityLinuxIhsSystem();
			case IhsPackage.IHS_DEPLOY_ROOT__CAPABILITY_WINDOWS_IHS_SYSTEM:
				return getCapabilityWindowsIhsSystem();
			case IhsPackage.IHS_DEPLOY_ROOT__UNIT_IHS_SERVER_UNIT:
				return getUnitIhsServerUnit();
			case IhsPackage.IHS_DEPLOY_ROOT__UNIT_IHS_SYSTEM_UNIT:
				return getUnitIhsSystemUnit();
			case IhsPackage.IHS_DEPLOY_ROOT__UNIT_IHS_USER_UNIT:
				return getUnitIhsUserUnit();
			case IhsPackage.IHS_DEPLOY_ROOT__UNIT_IHS_WAS_ADMIN_MODULE_UNIT:
				return getUnitIhsWasAdminModuleUnit();
			case IhsPackage.IHS_DEPLOY_ROOT__UNIT_IHS_WAS_MODULE_UNIT:
				return getUnitIhsWasModuleUnit();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
			case IhsPackage.IHS_DEPLOY_ROOT__MIXED:
				((FeatureMap.Internal)getMixed()).set(newValue);
				return;
			case IhsPackage.IHS_DEPLOY_ROOT__XMLNS_PREFIX_MAP:
				((EStructuralFeature.Setting)getXMLNSPrefixMap()).set(newValue);
				return;
			case IhsPackage.IHS_DEPLOY_ROOT__XSI_SCHEMA_LOCATION:
				((EStructuralFeature.Setting)getXSISchemaLocation()).set(newValue);
				return;
			case IhsPackage.IHS_DEPLOY_ROOT__CAPABILITY_IHS_MODULE:
				setCapabilityIhsModule((IhsModule)newValue);
				return;
			case IhsPackage.IHS_DEPLOY_ROOT__CAPABILITY_IHS_SERVER:
				setCapabilityIhsServer((IhsServer)newValue);
				return;
			case IhsPackage.IHS_DEPLOY_ROOT__CAPABILITY_IHS_SYSTEM:
				setCapabilityIhsSystem((IhsSystem)newValue);
				return;
			case IhsPackage.IHS_DEPLOY_ROOT__CAPABILITY_IHS_USER:
				setCapabilityIhsUser((IhsUser)newValue);
				return;
			case IhsPackage.IHS_DEPLOY_ROOT__CAPABILITY_IHS_USER_REPOSITORY:
				setCapabilityIhsUserRepository((IhsUserRepository)newValue);
				return;
			case IhsPackage.IHS_DEPLOY_ROOT__CAPABILITY_IHS_WAS_ADMIN_MODULE:
				setCapabilityIhsWasAdminModule((IhsWasAdminModule)newValue);
				return;
			case IhsPackage.IHS_DEPLOY_ROOT__CAPABILITY_IHS_WAS_MODULE:
				setCapabilityIhsWasModule((IhsWasModule)newValue);
				return;
			case IhsPackage.IHS_DEPLOY_ROOT__CAPABILITY_LINUX_IHS_SYSTEM:
				setCapabilityLinuxIhsSystem((LinuxIhsSystem)newValue);
				return;
			case IhsPackage.IHS_DEPLOY_ROOT__CAPABILITY_WINDOWS_IHS_SYSTEM:
				setCapabilityWindowsIhsSystem((WindowsIhsSystem)newValue);
				return;
			case IhsPackage.IHS_DEPLOY_ROOT__UNIT_IHS_SERVER_UNIT:
				setUnitIhsServerUnit((IhsServerUnit)newValue);
				return;
			case IhsPackage.IHS_DEPLOY_ROOT__UNIT_IHS_SYSTEM_UNIT:
				setUnitIhsSystemUnit((IhsSystemUnit)newValue);
				return;
			case IhsPackage.IHS_DEPLOY_ROOT__UNIT_IHS_USER_UNIT:
				setUnitIhsUserUnit((IhsUserUnit)newValue);
				return;
			case IhsPackage.IHS_DEPLOY_ROOT__UNIT_IHS_WAS_ADMIN_MODULE_UNIT:
				setUnitIhsWasAdminModuleUnit((IhsWasAdminModuleUnit)newValue);
				return;
			case IhsPackage.IHS_DEPLOY_ROOT__UNIT_IHS_WAS_MODULE_UNIT:
				setUnitIhsWasModuleUnit((IhsWasModuleUnit)newValue);
				return;
		}
		super.eSet(featureID, newValue);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public void eUnset(int featureID) {
		switch (featureID) {
			case IhsPackage.IHS_DEPLOY_ROOT__MIXED:
				getMixed().clear();
				return;
			case IhsPackage.IHS_DEPLOY_ROOT__XMLNS_PREFIX_MAP:
				getXMLNSPrefixMap().clear();
				return;
			case IhsPackage.IHS_DEPLOY_ROOT__XSI_SCHEMA_LOCATION:
				getXSISchemaLocation().clear();
				return;
			case IhsPackage.IHS_DEPLOY_ROOT__CAPABILITY_IHS_MODULE:
				setCapabilityIhsModule((IhsModule)null);
				return;
			case IhsPackage.IHS_DEPLOY_ROOT__CAPABILITY_IHS_SERVER:
				setCapabilityIhsServer((IhsServer)null);
				return;
			case IhsPackage.IHS_DEPLOY_ROOT__CAPABILITY_IHS_SYSTEM:
				setCapabilityIhsSystem((IhsSystem)null);
				return;
			case IhsPackage.IHS_DEPLOY_ROOT__CAPABILITY_IHS_USER:
				setCapabilityIhsUser((IhsUser)null);
				return;
			case IhsPackage.IHS_DEPLOY_ROOT__CAPABILITY_IHS_USER_REPOSITORY:
				setCapabilityIhsUserRepository((IhsUserRepository)null);
				return;
			case IhsPackage.IHS_DEPLOY_ROOT__CAPABILITY_IHS_WAS_ADMIN_MODULE:
				setCapabilityIhsWasAdminModule((IhsWasAdminModule)null);
				return;
			case IhsPackage.IHS_DEPLOY_ROOT__CAPABILITY_IHS_WAS_MODULE:
				setCapabilityIhsWasModule((IhsWasModule)null);
				return;
			case IhsPackage.IHS_DEPLOY_ROOT__CAPABILITY_LINUX_IHS_SYSTEM:
				setCapabilityLinuxIhsSystem((LinuxIhsSystem)null);
				return;
			case IhsPackage.IHS_DEPLOY_ROOT__CAPABILITY_WINDOWS_IHS_SYSTEM:
				setCapabilityWindowsIhsSystem((WindowsIhsSystem)null);
				return;
			case IhsPackage.IHS_DEPLOY_ROOT__UNIT_IHS_SERVER_UNIT:
				setUnitIhsServerUnit((IhsServerUnit)null);
				return;
			case IhsPackage.IHS_DEPLOY_ROOT__UNIT_IHS_SYSTEM_UNIT:
				setUnitIhsSystemUnit((IhsSystemUnit)null);
				return;
			case IhsPackage.IHS_DEPLOY_ROOT__UNIT_IHS_USER_UNIT:
				setUnitIhsUserUnit((IhsUserUnit)null);
				return;
			case IhsPackage.IHS_DEPLOY_ROOT__UNIT_IHS_WAS_ADMIN_MODULE_UNIT:
				setUnitIhsWasAdminModuleUnit((IhsWasAdminModuleUnit)null);
				return;
			case IhsPackage.IHS_DEPLOY_ROOT__UNIT_IHS_WAS_MODULE_UNIT:
				setUnitIhsWasModuleUnit((IhsWasModuleUnit)null);
				return;
		}
		super.eUnset(featureID);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public boolean eIsSet(int featureID) {
		switch (featureID) {
			case IhsPackage.IHS_DEPLOY_ROOT__MIXED:
				return mixed != null && !mixed.isEmpty();
			case IhsPackage.IHS_DEPLOY_ROOT__XMLNS_PREFIX_MAP:
				return xMLNSPrefixMap != null && !xMLNSPrefixMap.isEmpty();
			case IhsPackage.IHS_DEPLOY_ROOT__XSI_SCHEMA_LOCATION:
				return xSISchemaLocation != null && !xSISchemaLocation.isEmpty();
			case IhsPackage.IHS_DEPLOY_ROOT__CAPABILITY_IHS_MODULE:
				return getCapabilityIhsModule() != null;
			case IhsPackage.IHS_DEPLOY_ROOT__CAPABILITY_IHS_SERVER:
				return getCapabilityIhsServer() != null;
			case IhsPackage.IHS_DEPLOY_ROOT__CAPABILITY_IHS_SYSTEM:
				return getCapabilityIhsSystem() != null;
			case IhsPackage.IHS_DEPLOY_ROOT__CAPABILITY_IHS_USER:
				return getCapabilityIhsUser() != null;
			case IhsPackage.IHS_DEPLOY_ROOT__CAPABILITY_IHS_USER_REPOSITORY:
				return getCapabilityIhsUserRepository() != null;
			case IhsPackage.IHS_DEPLOY_ROOT__CAPABILITY_IHS_WAS_ADMIN_MODULE:
				return getCapabilityIhsWasAdminModule() != null;
			case IhsPackage.IHS_DEPLOY_ROOT__CAPABILITY_IHS_WAS_MODULE:
				return getCapabilityIhsWasModule() != null;
			case IhsPackage.IHS_DEPLOY_ROOT__CAPABILITY_LINUX_IHS_SYSTEM:
				return getCapabilityLinuxIhsSystem() != null;
			case IhsPackage.IHS_DEPLOY_ROOT__CAPABILITY_WINDOWS_IHS_SYSTEM:
				return getCapabilityWindowsIhsSystem() != null;
			case IhsPackage.IHS_DEPLOY_ROOT__UNIT_IHS_SERVER_UNIT:
				return getUnitIhsServerUnit() != null;
			case IhsPackage.IHS_DEPLOY_ROOT__UNIT_IHS_SYSTEM_UNIT:
				return getUnitIhsSystemUnit() != null;
			case IhsPackage.IHS_DEPLOY_ROOT__UNIT_IHS_USER_UNIT:
				return getUnitIhsUserUnit() != null;
			case IhsPackage.IHS_DEPLOY_ROOT__UNIT_IHS_WAS_ADMIN_MODULE_UNIT:
				return getUnitIhsWasAdminModuleUnit() != null;
			case IhsPackage.IHS_DEPLOY_ROOT__UNIT_IHS_WAS_MODULE_UNIT:
				return getUnitIhsWasModuleUnit() != null;
		}
		return super.eIsSet(featureID);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
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

} //IHSDeployRootImpl
