/*******************************************************************************
 * Copyright (c) 2003, 2007 IBM Corporation Licensed Material - Property of IBM. All rights reserved.
 *  
 * US Government Users Restricted Rights - Use, duplication or disclosure v1.0 restricted by GSA ADP
 * Schedule Contract with IBM Corp.
 * 
 * Contributors: IBM Corporation - initial API and implementation
 *******************************************************************************/
package com.ibm.ccl.soa.deploy.os.impl;

import java.util.Map;

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

import com.ibm.ccl.soa.deploy.os.AIXLocalGroup;
import com.ibm.ccl.soa.deploy.os.AIXLocalGroupUnit;
import com.ibm.ccl.soa.deploy.os.AIXLocalService;
import com.ibm.ccl.soa.deploy.os.AIXLocalServiceUnit;
import com.ibm.ccl.soa.deploy.os.AIXLocalUser;
import com.ibm.ccl.soa.deploy.os.AIXLocalUserUnit;
import com.ibm.ccl.soa.deploy.os.AIXOperatingSystem;
import com.ibm.ccl.soa.deploy.os.AIXOperatingSystemUnit;
import com.ibm.ccl.soa.deploy.os.DataFile;
import com.ibm.ccl.soa.deploy.os.DataFileUnit;
import com.ibm.ccl.soa.deploy.os.Directory;
import com.ibm.ccl.soa.deploy.os.DirectoryUnit;
import com.ibm.ccl.soa.deploy.os.FileSystem;
import com.ibm.ccl.soa.deploy.os.FileSystemContent;
import com.ibm.ccl.soa.deploy.os.FileSystemContentUnit;
import com.ibm.ccl.soa.deploy.os.FileSystemUnit;
import com.ibm.ccl.soa.deploy.os.LinuxLocalGroup;
import com.ibm.ccl.soa.deploy.os.LinuxLocalGroupUnit;
import com.ibm.ccl.soa.deploy.os.LinuxLocalService;
import com.ibm.ccl.soa.deploy.os.LinuxLocalServiceUnit;
import com.ibm.ccl.soa.deploy.os.LinuxLocalUser;
import com.ibm.ccl.soa.deploy.os.LinuxLocalUserUnit;
import com.ibm.ccl.soa.deploy.os.LinuxOperatingSystem;
import com.ibm.ccl.soa.deploy.os.LinuxOperatingSystemUnit;
import com.ibm.ccl.soa.deploy.os.LocalFileSystem;
import com.ibm.ccl.soa.deploy.os.LocalFileSystemUnit;
import com.ibm.ccl.soa.deploy.os.NFSFileSystem;
import com.ibm.ccl.soa.deploy.os.NFSFileSystemUnit;
import com.ibm.ccl.soa.deploy.os.OpenVmsFileSystem;
import com.ibm.ccl.soa.deploy.os.OpenVmsFileSystemUnit;
import com.ibm.ccl.soa.deploy.os.OperatingSystem;
import com.ibm.ccl.soa.deploy.os.OperatingSystemRoot;
import com.ibm.ccl.soa.deploy.os.OperatingSystemUnit;
import com.ibm.ccl.soa.deploy.os.OsPackage;
import com.ibm.ccl.soa.deploy.os.Port;
import com.ibm.ccl.soa.deploy.os.PortConfigUnit;
import com.ibm.ccl.soa.deploy.os.PortConsumer;
import com.ibm.ccl.soa.deploy.os.RedhatLinuxLocalGroup;
import com.ibm.ccl.soa.deploy.os.RedhatLinuxLocalService;
import com.ibm.ccl.soa.deploy.os.RedhatLinuxLocalUser;
import com.ibm.ccl.soa.deploy.os.RedhatLinuxOperatingSystem;
import com.ibm.ccl.soa.deploy.os.RemoteFileSystem;
import com.ibm.ccl.soa.deploy.os.RemoteFileSystemUnit;
import com.ibm.ccl.soa.deploy.os.SMBFileSystem;
import com.ibm.ccl.soa.deploy.os.SMBFileSystemUnit;
import com.ibm.ccl.soa.deploy.os.SUSELinuxLocalGroup;
import com.ibm.ccl.soa.deploy.os.SUSELinuxLocalService;
import com.ibm.ccl.soa.deploy.os.SUSELinuxLocalUser;
import com.ibm.ccl.soa.deploy.os.SUSELinuxOperatingSystem;
import com.ibm.ccl.soa.deploy.os.SolarisFileSystem;
import com.ibm.ccl.soa.deploy.os.SolarisFileSystemUnit;
import com.ibm.ccl.soa.deploy.os.UnixDirectory;
import com.ibm.ccl.soa.deploy.os.UnixFileSystem;
import com.ibm.ccl.soa.deploy.os.UnixFileSystemUnit;
import com.ibm.ccl.soa.deploy.os.User;
import com.ibm.ccl.soa.deploy.os.UserGroup;
import com.ibm.ccl.soa.deploy.os.UserGroupUnit;
import com.ibm.ccl.soa.deploy.os.UserUnit;
import com.ibm.ccl.soa.deploy.os.WindowsDirectory;
import com.ibm.ccl.soa.deploy.os.WindowsFileSystem;
import com.ibm.ccl.soa.deploy.os.WindowsFileSystemUnit;
import com.ibm.ccl.soa.deploy.os.WindowsLocalGroup;
import com.ibm.ccl.soa.deploy.os.WindowsLocalGroupUnit;
import com.ibm.ccl.soa.deploy.os.WindowsLocalService;
import com.ibm.ccl.soa.deploy.os.WindowsLocalServiceUnit;
import com.ibm.ccl.soa.deploy.os.WindowsLocalUser;
import com.ibm.ccl.soa.deploy.os.WindowsLocalUserUnit;
import com.ibm.ccl.soa.deploy.os.WindowsOperatingSystem;
import com.ibm.ccl.soa.deploy.os.WindowsOperatingSystemUnit;

/**
 * <!-- begin-user-doc --> An implementation of the model object '<em><b>Operating System Root</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link com.ibm.ccl.soa.deploy.os.impl.OperatingSystemRootImpl#getMixed <em>Mixed</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.os.impl.OperatingSystemRootImpl#getXMLNSPrefixMap <em>XMLNS Prefix Map</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.os.impl.OperatingSystemRootImpl#getXSISchemaLocation <em>XSI Schema Location</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.os.impl.OperatingSystemRootImpl#getCapabilityAixLocalGroup <em>Capability Aix Local Group</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.os.impl.OperatingSystemRootImpl#getCapabilityAixLocalService <em>Capability Aix Local Service</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.os.impl.OperatingSystemRootImpl#getCapabilityAixLocalUser <em>Capability Aix Local User</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.os.impl.OperatingSystemRootImpl#getCapabilityAixOperatingSystem <em>Capability Aix Operating System</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.os.impl.OperatingSystemRootImpl#getCapabilityDataFile <em>Capability Data File</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.os.impl.OperatingSystemRootImpl#getCapabilityDirectory <em>Capability Directory</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.os.impl.OperatingSystemRootImpl#getCapabilityFileSystem <em>Capability File System</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.os.impl.OperatingSystemRootImpl#getCapabilityFileSystemContent <em>Capability File System Content</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.os.impl.OperatingSystemRootImpl#getCapabilityLinuxLocalGroup <em>Capability Linux Local Group</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.os.impl.OperatingSystemRootImpl#getCapabilityLinuxLocalService <em>Capability Linux Local Service</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.os.impl.OperatingSystemRootImpl#getCapabilityLinuxLocalUser <em>Capability Linux Local User</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.os.impl.OperatingSystemRootImpl#getCapabilityLinuxOperatingSystem <em>Capability Linux Operating System</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.os.impl.OperatingSystemRootImpl#getCapabilityLocalFileSystem <em>Capability Local File System</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.os.impl.OperatingSystemRootImpl#getCapabilityNFSFileSystem <em>Capability NFS File System</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.os.impl.OperatingSystemRootImpl#getCapabilityOpenVmsFileSystem <em>Capability Open Vms File System</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.os.impl.OperatingSystemRootImpl#getCapabilityOperatingSystem <em>Capability Operating System</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.os.impl.OperatingSystemRootImpl#getCapabilityPort <em>Capability Port</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.os.impl.OperatingSystemRootImpl#getCapabilityPortConsumer <em>Capability Port Consumer</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.os.impl.OperatingSystemRootImpl#getCapabilityRedhatLinuxLocalGroup <em>Capability Redhat Linux Local Group</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.os.impl.OperatingSystemRootImpl#getCapabilityRedhatLinuxLocalService <em>Capability Redhat Linux Local Service</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.os.impl.OperatingSystemRootImpl#getCapabilityRedhatLinuxLocalUser <em>Capability Redhat Linux Local User</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.os.impl.OperatingSystemRootImpl#getCapabilityRedhatLinuxOperatingSystem <em>Capability Redhat Linux Operating System</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.os.impl.OperatingSystemRootImpl#getCapabilityRemoteFileSystem <em>Capability Remote File System</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.os.impl.OperatingSystemRootImpl#getCapabilitySMBFileSystem <em>Capability SMB File System</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.os.impl.OperatingSystemRootImpl#getCapabilitySolarisFileSystem <em>Capability Solaris File System</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.os.impl.OperatingSystemRootImpl#getCapabilitySuseLinuxLocalGroup <em>Capability Suse Linux Local Group</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.os.impl.OperatingSystemRootImpl#getCapabilitySuseLinuxLocalService <em>Capability Suse Linux Local Service</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.os.impl.OperatingSystemRootImpl#getCapabilitySuseLinuxLocalUser <em>Capability Suse Linux Local User</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.os.impl.OperatingSystemRootImpl#getCapabilitySuseLinuxOperatingSystem <em>Capability Suse Linux Operating System</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.os.impl.OperatingSystemRootImpl#getCapabilityUnixDirectory <em>Capability Unix Directory</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.os.impl.OperatingSystemRootImpl#getCapabilityUnixFileSystem <em>Capability Unix File System</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.os.impl.OperatingSystemRootImpl#getCapabilityUser <em>Capability User</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.os.impl.OperatingSystemRootImpl#getCapabilityUserGroup <em>Capability User Group</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.os.impl.OperatingSystemRootImpl#getCapabilityWindowsDirectory <em>Capability Windows Directory</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.os.impl.OperatingSystemRootImpl#getCapabilityWindowsFileSystem <em>Capability Windows File System</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.os.impl.OperatingSystemRootImpl#getCapabilityWindowsLocalGroup <em>Capability Windows Local Group</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.os.impl.OperatingSystemRootImpl#getCapabilityWindowsLocalService <em>Capability Windows Local Service</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.os.impl.OperatingSystemRootImpl#getCapabilityWindowsLocalUser <em>Capability Windows Local User</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.os.impl.OperatingSystemRootImpl#getCapabilityWindowsOperatingSystem <em>Capability Windows Operating System</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.os.impl.OperatingSystemRootImpl#getUnitAixLocalGroup <em>Unit Aix Local Group</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.os.impl.OperatingSystemRootImpl#getUnitAixLocalServiceUnit <em>Unit Aix Local Service Unit</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.os.impl.OperatingSystemRootImpl#getUnitAixLocalUser <em>Unit Aix Local User</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.os.impl.OperatingSystemRootImpl#getUnitAixOperatingSystemUnit <em>Unit Aix Operating System Unit</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.os.impl.OperatingSystemRootImpl#getUnitDataFileUnit <em>Unit Data File Unit</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.os.impl.OperatingSystemRootImpl#getUnitDirectoryUnit <em>Unit Directory Unit</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.os.impl.OperatingSystemRootImpl#getUnitFileSystemContentUnit <em>Unit File System Content Unit</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.os.impl.OperatingSystemRootImpl#getUnitFileSystemUnit <em>Unit File System Unit</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.os.impl.OperatingSystemRootImpl#getUnitLinuxLocalGroup <em>Unit Linux Local Group</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.os.impl.OperatingSystemRootImpl#getUnitLinuxLocalServiceUnit <em>Unit Linux Local Service Unit</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.os.impl.OperatingSystemRootImpl#getUnitLinuxLocalUser <em>Unit Linux Local User</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.os.impl.OperatingSystemRootImpl#getUnitLinuxOperatingSystemUnit <em>Unit Linux Operating System Unit</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.os.impl.OperatingSystemRootImpl#getUnitLocalFileSystemUnit <em>Unit Local File System Unit</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.os.impl.OperatingSystemRootImpl#getUnitNFSFileSystemUnit <em>Unit NFS File System Unit</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.os.impl.OperatingSystemRootImpl#getUnitOpenVmsFileSystemUnit <em>Unit Open Vms File System Unit</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.os.impl.OperatingSystemRootImpl#getUnitOperatingSystemUnit <em>Unit Operating System Unit</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.os.impl.OperatingSystemRootImpl#getUnitPortConfigUnit <em>Unit Port Config Unit</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.os.impl.OperatingSystemRootImpl#getUnitRemoteFileSystemUnit <em>Unit Remote File System Unit</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.os.impl.OperatingSystemRootImpl#getUnitSMBFileSystemUnit <em>Unit SMB File System Unit</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.os.impl.OperatingSystemRootImpl#getUnitSolarisFileSystemUnit <em>Unit Solaris File System Unit</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.os.impl.OperatingSystemRootImpl#getUnitUnixFileSystemUnit <em>Unit Unix File System Unit</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.os.impl.OperatingSystemRootImpl#getUnitUser <em>Unit User</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.os.impl.OperatingSystemRootImpl#getUnitUserGroup <em>Unit User Group</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.os.impl.OperatingSystemRootImpl#getUnitWindowsFileSystemUnit <em>Unit Windows File System Unit</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.os.impl.OperatingSystemRootImpl#getUnitWindowsLocalGroup <em>Unit Windows Local Group</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.os.impl.OperatingSystemRootImpl#getUnitWindowsLocalServiceUnit <em>Unit Windows Local Service Unit</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.os.impl.OperatingSystemRootImpl#getUnitWindowsLocalUser <em>Unit Windows Local User</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.os.impl.OperatingSystemRootImpl#getUnitWindowsOperatingSystemUnit <em>Unit Windows Operating System Unit</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class OperatingSystemRootImpl extends EObjectImpl implements OperatingSystemRoot {
	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public static final String copyright = "Copyright (c) 2005, 2006 IBM Corporation. Licensed Material - Property of IBM. All rights reserved."; //$NON-NLS-1$

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
	protected OperatingSystemRootImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	protected EClass eStaticClass() {
		return OsPackage.Literals.OPERATING_SYSTEM_ROOT;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public FeatureMap getMixed() {
		if (mixed == null) {
			mixed = new BasicFeatureMap(this, OsPackage.OPERATING_SYSTEM_ROOT__MIXED);
		}
		return mixed;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public Map getXMLNSPrefixMap() {
		if (xMLNSPrefixMap == null) {
			xMLNSPrefixMap = new EcoreEMap(EcorePackage.Literals.ESTRING_TO_STRING_MAP_ENTRY,
					EStringToStringMapEntryImpl.class, this,
					OsPackage.OPERATING_SYSTEM_ROOT__XMLNS_PREFIX_MAP);
		}
		return xMLNSPrefixMap.map();
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public Map getXSISchemaLocation() {
		if (xSISchemaLocation == null) {
			xSISchemaLocation = new EcoreEMap(EcorePackage.Literals.ESTRING_TO_STRING_MAP_ENTRY,
					EStringToStringMapEntryImpl.class, this,
					OsPackage.OPERATING_SYSTEM_ROOT__XSI_SCHEMA_LOCATION);
		}
		return xSISchemaLocation.map();
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public AIXLocalGroup getCapabilityAixLocalGroup() {
		return (AIXLocalGroup) getMixed().get(
				OsPackage.Literals.OPERATING_SYSTEM_ROOT__CAPABILITY_AIX_LOCAL_GROUP, true);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetCapabilityAixLocalGroup(
			AIXLocalGroup newCapabilityAixLocalGroup, NotificationChain msgs) {
		return ((FeatureMap.Internal) getMixed()).basicAdd(
				OsPackage.Literals.OPERATING_SYSTEM_ROOT__CAPABILITY_AIX_LOCAL_GROUP,
				newCapabilityAixLocalGroup, msgs);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public void setCapabilityAixLocalGroup(AIXLocalGroup newCapabilityAixLocalGroup) {
		((FeatureMap.Internal) getMixed()).set(
				OsPackage.Literals.OPERATING_SYSTEM_ROOT__CAPABILITY_AIX_LOCAL_GROUP,
				newCapabilityAixLocalGroup);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public AIXLocalService getCapabilityAixLocalService() {
		return (AIXLocalService) getMixed().get(
				OsPackage.Literals.OPERATING_SYSTEM_ROOT__CAPABILITY_AIX_LOCAL_SERVICE, true);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetCapabilityAixLocalService(
			AIXLocalService newCapabilityAixLocalService, NotificationChain msgs) {
		return ((FeatureMap.Internal) getMixed()).basicAdd(
				OsPackage.Literals.OPERATING_SYSTEM_ROOT__CAPABILITY_AIX_LOCAL_SERVICE,
				newCapabilityAixLocalService, msgs);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public void setCapabilityAixLocalService(AIXLocalService newCapabilityAixLocalService) {
		((FeatureMap.Internal) getMixed()).set(
				OsPackage.Literals.OPERATING_SYSTEM_ROOT__CAPABILITY_AIX_LOCAL_SERVICE,
				newCapabilityAixLocalService);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public AIXLocalUser getCapabilityAixLocalUser() {
		return (AIXLocalUser) getMixed().get(
				OsPackage.Literals.OPERATING_SYSTEM_ROOT__CAPABILITY_AIX_LOCAL_USER, true);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetCapabilityAixLocalUser(AIXLocalUser newCapabilityAixLocalUser,
			NotificationChain msgs) {
		return ((FeatureMap.Internal) getMixed()).basicAdd(
				OsPackage.Literals.OPERATING_SYSTEM_ROOT__CAPABILITY_AIX_LOCAL_USER,
				newCapabilityAixLocalUser, msgs);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public void setCapabilityAixLocalUser(AIXLocalUser newCapabilityAixLocalUser) {
		((FeatureMap.Internal) getMixed()).set(
				OsPackage.Literals.OPERATING_SYSTEM_ROOT__CAPABILITY_AIX_LOCAL_USER,
				newCapabilityAixLocalUser);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public AIXOperatingSystem getCapabilityAixOperatingSystem() {
		return (AIXOperatingSystem) getMixed().get(
				OsPackage.Literals.OPERATING_SYSTEM_ROOT__CAPABILITY_AIX_OPERATING_SYSTEM, true);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetCapabilityAixOperatingSystem(
			AIXOperatingSystem newCapabilityAixOperatingSystem, NotificationChain msgs) {
		return ((FeatureMap.Internal) getMixed()).basicAdd(
				OsPackage.Literals.OPERATING_SYSTEM_ROOT__CAPABILITY_AIX_OPERATING_SYSTEM,
				newCapabilityAixOperatingSystem, msgs);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public void setCapabilityAixOperatingSystem(AIXOperatingSystem newCapabilityAixOperatingSystem) {
		((FeatureMap.Internal) getMixed()).set(
				OsPackage.Literals.OPERATING_SYSTEM_ROOT__CAPABILITY_AIX_OPERATING_SYSTEM,
				newCapabilityAixOperatingSystem);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public DataFile getCapabilityDataFile() {
		return (DataFile) getMixed().get(
				OsPackage.Literals.OPERATING_SYSTEM_ROOT__CAPABILITY_DATA_FILE, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetCapabilityDataFile(DataFile newCapabilityDataFile,
			NotificationChain msgs) {
		return ((FeatureMap.Internal) getMixed()).basicAdd(
				OsPackage.Literals.OPERATING_SYSTEM_ROOT__CAPABILITY_DATA_FILE, newCapabilityDataFile,
				msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setCapabilityDataFile(DataFile newCapabilityDataFile) {
		((FeatureMap.Internal) getMixed()).set(
				OsPackage.Literals.OPERATING_SYSTEM_ROOT__CAPABILITY_DATA_FILE, newCapabilityDataFile);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public Directory getCapabilityDirectory() {
		return (Directory) getMixed().get(
				OsPackage.Literals.OPERATING_SYSTEM_ROOT__CAPABILITY_DIRECTORY, true);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetCapabilityDirectory(Directory newCapabilityDirectory,
			NotificationChain msgs) {
		return ((FeatureMap.Internal) getMixed()).basicAdd(
				OsPackage.Literals.OPERATING_SYSTEM_ROOT__CAPABILITY_DIRECTORY, newCapabilityDirectory,
				msgs);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public void setCapabilityDirectory(Directory newCapabilityDirectory) {
		((FeatureMap.Internal) getMixed()).set(
				OsPackage.Literals.OPERATING_SYSTEM_ROOT__CAPABILITY_DIRECTORY, newCapabilityDirectory);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public FileSystem getCapabilityFileSystem() {
		return (FileSystem) getMixed().get(
				OsPackage.Literals.OPERATING_SYSTEM_ROOT__CAPABILITY_FILE_SYSTEM, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetCapabilityFileSystem(FileSystem newCapabilityFileSystem,
			NotificationChain msgs) {
		return ((FeatureMap.Internal) getMixed()).basicAdd(
				OsPackage.Literals.OPERATING_SYSTEM_ROOT__CAPABILITY_FILE_SYSTEM,
				newCapabilityFileSystem, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setCapabilityFileSystem(FileSystem newCapabilityFileSystem) {
		((FeatureMap.Internal) getMixed()).set(
				OsPackage.Literals.OPERATING_SYSTEM_ROOT__CAPABILITY_FILE_SYSTEM,
				newCapabilityFileSystem);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public FileSystemContent getCapabilityFileSystemContent() {
		return (FileSystemContent) getMixed().get(
				OsPackage.Literals.OPERATING_SYSTEM_ROOT__CAPABILITY_FILE_SYSTEM_CONTENT, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetCapabilityFileSystemContent(
			FileSystemContent newCapabilityFileSystemContent, NotificationChain msgs) {
		return ((FeatureMap.Internal) getMixed()).basicAdd(
				OsPackage.Literals.OPERATING_SYSTEM_ROOT__CAPABILITY_FILE_SYSTEM_CONTENT,
				newCapabilityFileSystemContent, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setCapabilityFileSystemContent(FileSystemContent newCapabilityFileSystemContent) {
		((FeatureMap.Internal) getMixed()).set(
				OsPackage.Literals.OPERATING_SYSTEM_ROOT__CAPABILITY_FILE_SYSTEM_CONTENT,
				newCapabilityFileSystemContent);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public LinuxLocalGroup getCapabilityLinuxLocalGroup() {
		return (LinuxLocalGroup) getMixed().get(
				OsPackage.Literals.OPERATING_SYSTEM_ROOT__CAPABILITY_LINUX_LOCAL_GROUP, true);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetCapabilityLinuxLocalGroup(
			LinuxLocalGroup newCapabilityLinuxLocalGroup, NotificationChain msgs) {
		return ((FeatureMap.Internal) getMixed()).basicAdd(
				OsPackage.Literals.OPERATING_SYSTEM_ROOT__CAPABILITY_LINUX_LOCAL_GROUP,
				newCapabilityLinuxLocalGroup, msgs);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public void setCapabilityLinuxLocalGroup(LinuxLocalGroup newCapabilityLinuxLocalGroup) {
		((FeatureMap.Internal) getMixed()).set(
				OsPackage.Literals.OPERATING_SYSTEM_ROOT__CAPABILITY_LINUX_LOCAL_GROUP,
				newCapabilityLinuxLocalGroup);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public LinuxLocalService getCapabilityLinuxLocalService() {
		return (LinuxLocalService) getMixed().get(
				OsPackage.Literals.OPERATING_SYSTEM_ROOT__CAPABILITY_LINUX_LOCAL_SERVICE, true);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetCapabilityLinuxLocalService(
			LinuxLocalService newCapabilityLinuxLocalService, NotificationChain msgs) {
		return ((FeatureMap.Internal) getMixed()).basicAdd(
				OsPackage.Literals.OPERATING_SYSTEM_ROOT__CAPABILITY_LINUX_LOCAL_SERVICE,
				newCapabilityLinuxLocalService, msgs);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public void setCapabilityLinuxLocalService(LinuxLocalService newCapabilityLinuxLocalService) {
		((FeatureMap.Internal) getMixed()).set(
				OsPackage.Literals.OPERATING_SYSTEM_ROOT__CAPABILITY_LINUX_LOCAL_SERVICE,
				newCapabilityLinuxLocalService);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public LinuxLocalUser getCapabilityLinuxLocalUser() {
		return (LinuxLocalUser) getMixed().get(
				OsPackage.Literals.OPERATING_SYSTEM_ROOT__CAPABILITY_LINUX_LOCAL_USER, true);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetCapabilityLinuxLocalUser(
			LinuxLocalUser newCapabilityLinuxLocalUser, NotificationChain msgs) {
		return ((FeatureMap.Internal) getMixed()).basicAdd(
				OsPackage.Literals.OPERATING_SYSTEM_ROOT__CAPABILITY_LINUX_LOCAL_USER,
				newCapabilityLinuxLocalUser, msgs);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public void setCapabilityLinuxLocalUser(LinuxLocalUser newCapabilityLinuxLocalUser) {
		((FeatureMap.Internal) getMixed()).set(
				OsPackage.Literals.OPERATING_SYSTEM_ROOT__CAPABILITY_LINUX_LOCAL_USER,
				newCapabilityLinuxLocalUser);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public LinuxOperatingSystem getCapabilityLinuxOperatingSystem() {
		return (LinuxOperatingSystem) getMixed().get(
				OsPackage.Literals.OPERATING_SYSTEM_ROOT__CAPABILITY_LINUX_OPERATING_SYSTEM, true);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetCapabilityLinuxOperatingSystem(
			LinuxOperatingSystem newCapabilityLinuxOperatingSystem, NotificationChain msgs) {
		return ((FeatureMap.Internal) getMixed()).basicAdd(
				OsPackage.Literals.OPERATING_SYSTEM_ROOT__CAPABILITY_LINUX_OPERATING_SYSTEM,
				newCapabilityLinuxOperatingSystem, msgs);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public void setCapabilityLinuxOperatingSystem(
			LinuxOperatingSystem newCapabilityLinuxOperatingSystem) {
		((FeatureMap.Internal) getMixed()).set(
				OsPackage.Literals.OPERATING_SYSTEM_ROOT__CAPABILITY_LINUX_OPERATING_SYSTEM,
				newCapabilityLinuxOperatingSystem);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public LocalFileSystem getCapabilityLocalFileSystem() {
		return (LocalFileSystem) getMixed().get(
				OsPackage.Literals.OPERATING_SYSTEM_ROOT__CAPABILITY_LOCAL_FILE_SYSTEM, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetCapabilityLocalFileSystem(
			LocalFileSystem newCapabilityLocalFileSystem, NotificationChain msgs) {
		return ((FeatureMap.Internal) getMixed()).basicAdd(
				OsPackage.Literals.OPERATING_SYSTEM_ROOT__CAPABILITY_LOCAL_FILE_SYSTEM,
				newCapabilityLocalFileSystem, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setCapabilityLocalFileSystem(LocalFileSystem newCapabilityLocalFileSystem) {
		((FeatureMap.Internal) getMixed()).set(
				OsPackage.Literals.OPERATING_SYSTEM_ROOT__CAPABILITY_LOCAL_FILE_SYSTEM,
				newCapabilityLocalFileSystem);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NFSFileSystem getCapabilityNFSFileSystem() {
		return (NFSFileSystem) getMixed().get(
				OsPackage.Literals.OPERATING_SYSTEM_ROOT__CAPABILITY_NFS_FILE_SYSTEM, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetCapabilityNFSFileSystem(
			NFSFileSystem newCapabilityNFSFileSystem, NotificationChain msgs) {
		return ((FeatureMap.Internal) getMixed()).basicAdd(
				OsPackage.Literals.OPERATING_SYSTEM_ROOT__CAPABILITY_NFS_FILE_SYSTEM,
				newCapabilityNFSFileSystem, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setCapabilityNFSFileSystem(NFSFileSystem newCapabilityNFSFileSystem) {
		((FeatureMap.Internal) getMixed()).set(
				OsPackage.Literals.OPERATING_SYSTEM_ROOT__CAPABILITY_NFS_FILE_SYSTEM,
				newCapabilityNFSFileSystem);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public OpenVmsFileSystem getCapabilityOpenVmsFileSystem() {
		return (OpenVmsFileSystem) getMixed().get(
				OsPackage.Literals.OPERATING_SYSTEM_ROOT__CAPABILITY_OPEN_VMS_FILE_SYSTEM, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetCapabilityOpenVmsFileSystem(
			OpenVmsFileSystem newCapabilityOpenVmsFileSystem, NotificationChain msgs) {
		return ((FeatureMap.Internal) getMixed()).basicAdd(
				OsPackage.Literals.OPERATING_SYSTEM_ROOT__CAPABILITY_OPEN_VMS_FILE_SYSTEM,
				newCapabilityOpenVmsFileSystem, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setCapabilityOpenVmsFileSystem(OpenVmsFileSystem newCapabilityOpenVmsFileSystem) {
		((FeatureMap.Internal) getMixed()).set(
				OsPackage.Literals.OPERATING_SYSTEM_ROOT__CAPABILITY_OPEN_VMS_FILE_SYSTEM,
				newCapabilityOpenVmsFileSystem);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public OperatingSystem getCapabilityOperatingSystem() {
		return (OperatingSystem) getMixed().get(
				OsPackage.Literals.OPERATING_SYSTEM_ROOT__CAPABILITY_OPERATING_SYSTEM, true);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetCapabilityOperatingSystem(
			OperatingSystem newCapabilityOperatingSystem, NotificationChain msgs) {
		return ((FeatureMap.Internal) getMixed()).basicAdd(
				OsPackage.Literals.OPERATING_SYSTEM_ROOT__CAPABILITY_OPERATING_SYSTEM,
				newCapabilityOperatingSystem, msgs);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public void setCapabilityOperatingSystem(OperatingSystem newCapabilityOperatingSystem) {
		((FeatureMap.Internal) getMixed()).set(
				OsPackage.Literals.OPERATING_SYSTEM_ROOT__CAPABILITY_OPERATING_SYSTEM,
				newCapabilityOperatingSystem);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public Port getCapabilityPort() {
		return (Port) getMixed().get(OsPackage.Literals.OPERATING_SYSTEM_ROOT__CAPABILITY_PORT, true);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetCapabilityPort(Port newCapabilityPort, NotificationChain msgs) {
		return ((FeatureMap.Internal) getMixed()).basicAdd(
				OsPackage.Literals.OPERATING_SYSTEM_ROOT__CAPABILITY_PORT, newCapabilityPort, msgs);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public void setCapabilityPort(Port newCapabilityPort) {
		((FeatureMap.Internal) getMixed()).set(
				OsPackage.Literals.OPERATING_SYSTEM_ROOT__CAPABILITY_PORT, newCapabilityPort);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public PortConsumer getCapabilityPortConsumer() {
		return (PortConsumer) getMixed().get(
				OsPackage.Literals.OPERATING_SYSTEM_ROOT__CAPABILITY_PORT_CONSUMER, true);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetCapabilityPortConsumer(PortConsumer newCapabilityPortConsumer,
			NotificationChain msgs) {
		return ((FeatureMap.Internal) getMixed()).basicAdd(
				OsPackage.Literals.OPERATING_SYSTEM_ROOT__CAPABILITY_PORT_CONSUMER,
				newCapabilityPortConsumer, msgs);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public void setCapabilityPortConsumer(PortConsumer newCapabilityPortConsumer) {
		((FeatureMap.Internal) getMixed()).set(
				OsPackage.Literals.OPERATING_SYSTEM_ROOT__CAPABILITY_PORT_CONSUMER,
				newCapabilityPortConsumer);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public RedhatLinuxLocalGroup getCapabilityRedhatLinuxLocalGroup() {
		return (RedhatLinuxLocalGroup) getMixed().get(
				OsPackage.Literals.OPERATING_SYSTEM_ROOT__CAPABILITY_REDHAT_LINUX_LOCAL_GROUP, true);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetCapabilityRedhatLinuxLocalGroup(
			RedhatLinuxLocalGroup newCapabilityRedhatLinuxLocalGroup, NotificationChain msgs) {
		return ((FeatureMap.Internal) getMixed()).basicAdd(
				OsPackage.Literals.OPERATING_SYSTEM_ROOT__CAPABILITY_REDHAT_LINUX_LOCAL_GROUP,
				newCapabilityRedhatLinuxLocalGroup, msgs);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public void setCapabilityRedhatLinuxLocalGroup(
			RedhatLinuxLocalGroup newCapabilityRedhatLinuxLocalGroup) {
		((FeatureMap.Internal) getMixed()).set(
				OsPackage.Literals.OPERATING_SYSTEM_ROOT__CAPABILITY_REDHAT_LINUX_LOCAL_GROUP,
				newCapabilityRedhatLinuxLocalGroup);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public RedhatLinuxLocalService getCapabilityRedhatLinuxLocalService() {
		return (RedhatLinuxLocalService) getMixed().get(
				OsPackage.Literals.OPERATING_SYSTEM_ROOT__CAPABILITY_REDHAT_LINUX_LOCAL_SERVICE, true);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetCapabilityRedhatLinuxLocalService(
			RedhatLinuxLocalService newCapabilityRedhatLinuxLocalService, NotificationChain msgs) {
		return ((FeatureMap.Internal) getMixed()).basicAdd(
				OsPackage.Literals.OPERATING_SYSTEM_ROOT__CAPABILITY_REDHAT_LINUX_LOCAL_SERVICE,
				newCapabilityRedhatLinuxLocalService, msgs);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public void setCapabilityRedhatLinuxLocalService(
			RedhatLinuxLocalService newCapabilityRedhatLinuxLocalService) {
		((FeatureMap.Internal) getMixed()).set(
				OsPackage.Literals.OPERATING_SYSTEM_ROOT__CAPABILITY_REDHAT_LINUX_LOCAL_SERVICE,
				newCapabilityRedhatLinuxLocalService);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public RedhatLinuxLocalUser getCapabilityRedhatLinuxLocalUser() {
		return (RedhatLinuxLocalUser) getMixed().get(
				OsPackage.Literals.OPERATING_SYSTEM_ROOT__CAPABILITY_REDHAT_LINUX_LOCAL_USER, true);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetCapabilityRedhatLinuxLocalUser(
			RedhatLinuxLocalUser newCapabilityRedhatLinuxLocalUser, NotificationChain msgs) {
		return ((FeatureMap.Internal) getMixed()).basicAdd(
				OsPackage.Literals.OPERATING_SYSTEM_ROOT__CAPABILITY_REDHAT_LINUX_LOCAL_USER,
				newCapabilityRedhatLinuxLocalUser, msgs);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public void setCapabilityRedhatLinuxLocalUser(
			RedhatLinuxLocalUser newCapabilityRedhatLinuxLocalUser) {
		((FeatureMap.Internal) getMixed()).set(
				OsPackage.Literals.OPERATING_SYSTEM_ROOT__CAPABILITY_REDHAT_LINUX_LOCAL_USER,
				newCapabilityRedhatLinuxLocalUser);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public RedhatLinuxOperatingSystem getCapabilityRedhatLinuxOperatingSystem() {
		return (RedhatLinuxOperatingSystem) getMixed().get(
				OsPackage.Literals.OPERATING_SYSTEM_ROOT__CAPABILITY_REDHAT_LINUX_OPERATING_SYSTEM,
				true);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetCapabilityRedhatLinuxOperatingSystem(
			RedhatLinuxOperatingSystem newCapabilityRedhatLinuxOperatingSystem, NotificationChain msgs) {
		return ((FeatureMap.Internal) getMixed()).basicAdd(
				OsPackage.Literals.OPERATING_SYSTEM_ROOT__CAPABILITY_REDHAT_LINUX_OPERATING_SYSTEM,
				newCapabilityRedhatLinuxOperatingSystem, msgs);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public void setCapabilityRedhatLinuxOperatingSystem(
			RedhatLinuxOperatingSystem newCapabilityRedhatLinuxOperatingSystem) {
		((FeatureMap.Internal) getMixed()).set(
				OsPackage.Literals.OPERATING_SYSTEM_ROOT__CAPABILITY_REDHAT_LINUX_OPERATING_SYSTEM,
				newCapabilityRedhatLinuxOperatingSystem);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public RemoteFileSystem getCapabilityRemoteFileSystem() {
		return (RemoteFileSystem) getMixed().get(
				OsPackage.Literals.OPERATING_SYSTEM_ROOT__CAPABILITY_REMOTE_FILE_SYSTEM, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetCapabilityRemoteFileSystem(
			RemoteFileSystem newCapabilityRemoteFileSystem, NotificationChain msgs) {
		return ((FeatureMap.Internal) getMixed()).basicAdd(
				OsPackage.Literals.OPERATING_SYSTEM_ROOT__CAPABILITY_REMOTE_FILE_SYSTEM,
				newCapabilityRemoteFileSystem, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setCapabilityRemoteFileSystem(RemoteFileSystem newCapabilityRemoteFileSystem) {
		((FeatureMap.Internal) getMixed()).set(
				OsPackage.Literals.OPERATING_SYSTEM_ROOT__CAPABILITY_REMOTE_FILE_SYSTEM,
				newCapabilityRemoteFileSystem);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SMBFileSystem getCapabilitySMBFileSystem() {
		return (SMBFileSystem) getMixed().get(
				OsPackage.Literals.OPERATING_SYSTEM_ROOT__CAPABILITY_SMB_FILE_SYSTEM, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetCapabilitySMBFileSystem(
			SMBFileSystem newCapabilitySMBFileSystem, NotificationChain msgs) {
		return ((FeatureMap.Internal) getMixed()).basicAdd(
				OsPackage.Literals.OPERATING_SYSTEM_ROOT__CAPABILITY_SMB_FILE_SYSTEM,
				newCapabilitySMBFileSystem, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setCapabilitySMBFileSystem(SMBFileSystem newCapabilitySMBFileSystem) {
		((FeatureMap.Internal) getMixed()).set(
				OsPackage.Literals.OPERATING_SYSTEM_ROOT__CAPABILITY_SMB_FILE_SYSTEM,
				newCapabilitySMBFileSystem);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SolarisFileSystem getCapabilitySolarisFileSystem() {
		return (SolarisFileSystem) getMixed().get(
				OsPackage.Literals.OPERATING_SYSTEM_ROOT__CAPABILITY_SOLARIS_FILE_SYSTEM, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetCapabilitySolarisFileSystem(
			SolarisFileSystem newCapabilitySolarisFileSystem, NotificationChain msgs) {
		return ((FeatureMap.Internal) getMixed()).basicAdd(
				OsPackage.Literals.OPERATING_SYSTEM_ROOT__CAPABILITY_SOLARIS_FILE_SYSTEM,
				newCapabilitySolarisFileSystem, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setCapabilitySolarisFileSystem(SolarisFileSystem newCapabilitySolarisFileSystem) {
		((FeatureMap.Internal) getMixed()).set(
				OsPackage.Literals.OPERATING_SYSTEM_ROOT__CAPABILITY_SOLARIS_FILE_SYSTEM,
				newCapabilitySolarisFileSystem);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public SUSELinuxLocalGroup getCapabilitySuseLinuxLocalGroup() {
		return (SUSELinuxLocalGroup) getMixed().get(
				OsPackage.Literals.OPERATING_SYSTEM_ROOT__CAPABILITY_SUSE_LINUX_LOCAL_GROUP, true);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetCapabilitySuseLinuxLocalGroup(
			SUSELinuxLocalGroup newCapabilitySuseLinuxLocalGroup, NotificationChain msgs) {
		return ((FeatureMap.Internal) getMixed()).basicAdd(
				OsPackage.Literals.OPERATING_SYSTEM_ROOT__CAPABILITY_SUSE_LINUX_LOCAL_GROUP,
				newCapabilitySuseLinuxLocalGroup, msgs);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public void setCapabilitySuseLinuxLocalGroup(SUSELinuxLocalGroup newCapabilitySuseLinuxLocalGroup) {
		((FeatureMap.Internal) getMixed()).set(
				OsPackage.Literals.OPERATING_SYSTEM_ROOT__CAPABILITY_SUSE_LINUX_LOCAL_GROUP,
				newCapabilitySuseLinuxLocalGroup);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public SUSELinuxLocalService getCapabilitySuseLinuxLocalService() {
		return (SUSELinuxLocalService) getMixed().get(
				OsPackage.Literals.OPERATING_SYSTEM_ROOT__CAPABILITY_SUSE_LINUX_LOCAL_SERVICE, true);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetCapabilitySuseLinuxLocalService(
			SUSELinuxLocalService newCapabilitySuseLinuxLocalService, NotificationChain msgs) {
		return ((FeatureMap.Internal) getMixed()).basicAdd(
				OsPackage.Literals.OPERATING_SYSTEM_ROOT__CAPABILITY_SUSE_LINUX_LOCAL_SERVICE,
				newCapabilitySuseLinuxLocalService, msgs);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public void setCapabilitySuseLinuxLocalService(
			SUSELinuxLocalService newCapabilitySuseLinuxLocalService) {
		((FeatureMap.Internal) getMixed()).set(
				OsPackage.Literals.OPERATING_SYSTEM_ROOT__CAPABILITY_SUSE_LINUX_LOCAL_SERVICE,
				newCapabilitySuseLinuxLocalService);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public SUSELinuxLocalUser getCapabilitySuseLinuxLocalUser() {
		return (SUSELinuxLocalUser) getMixed().get(
				OsPackage.Literals.OPERATING_SYSTEM_ROOT__CAPABILITY_SUSE_LINUX_LOCAL_USER, true);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetCapabilitySuseLinuxLocalUser(
			SUSELinuxLocalUser newCapabilitySuseLinuxLocalUser, NotificationChain msgs) {
		return ((FeatureMap.Internal) getMixed()).basicAdd(
				OsPackage.Literals.OPERATING_SYSTEM_ROOT__CAPABILITY_SUSE_LINUX_LOCAL_USER,
				newCapabilitySuseLinuxLocalUser, msgs);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public void setCapabilitySuseLinuxLocalUser(SUSELinuxLocalUser newCapabilitySuseLinuxLocalUser) {
		((FeatureMap.Internal) getMixed()).set(
				OsPackage.Literals.OPERATING_SYSTEM_ROOT__CAPABILITY_SUSE_LINUX_LOCAL_USER,
				newCapabilitySuseLinuxLocalUser);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public SUSELinuxOperatingSystem getCapabilitySuseLinuxOperatingSystem() {
		return (SUSELinuxOperatingSystem) getMixed().get(
				OsPackage.Literals.OPERATING_SYSTEM_ROOT__CAPABILITY_SUSE_LINUX_OPERATING_SYSTEM, true);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetCapabilitySuseLinuxOperatingSystem(
			SUSELinuxOperatingSystem newCapabilitySuseLinuxOperatingSystem, NotificationChain msgs) {
		return ((FeatureMap.Internal) getMixed()).basicAdd(
				OsPackage.Literals.OPERATING_SYSTEM_ROOT__CAPABILITY_SUSE_LINUX_OPERATING_SYSTEM,
				newCapabilitySuseLinuxOperatingSystem, msgs);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public void setCapabilitySuseLinuxOperatingSystem(
			SUSELinuxOperatingSystem newCapabilitySuseLinuxOperatingSystem) {
		((FeatureMap.Internal) getMixed()).set(
				OsPackage.Literals.OPERATING_SYSTEM_ROOT__CAPABILITY_SUSE_LINUX_OPERATING_SYSTEM,
				newCapabilitySuseLinuxOperatingSystem);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public UnixDirectory getCapabilityUnixDirectory() {
		return (UnixDirectory) getMixed().get(
				OsPackage.Literals.OPERATING_SYSTEM_ROOT__CAPABILITY_UNIX_DIRECTORY, true);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetCapabilityUnixDirectory(
			UnixDirectory newCapabilityUnixDirectory, NotificationChain msgs) {
		return ((FeatureMap.Internal) getMixed()).basicAdd(
				OsPackage.Literals.OPERATING_SYSTEM_ROOT__CAPABILITY_UNIX_DIRECTORY,
				newCapabilityUnixDirectory, msgs);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public void setCapabilityUnixDirectory(UnixDirectory newCapabilityUnixDirectory) {
		((FeatureMap.Internal) getMixed()).set(
				OsPackage.Literals.OPERATING_SYSTEM_ROOT__CAPABILITY_UNIX_DIRECTORY,
				newCapabilityUnixDirectory);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public UnixFileSystem getCapabilityUnixFileSystem() {
		return (UnixFileSystem) getMixed().get(
				OsPackage.Literals.OPERATING_SYSTEM_ROOT__CAPABILITY_UNIX_FILE_SYSTEM, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetCapabilityUnixFileSystem(
			UnixFileSystem newCapabilityUnixFileSystem, NotificationChain msgs) {
		return ((FeatureMap.Internal) getMixed()).basicAdd(
				OsPackage.Literals.OPERATING_SYSTEM_ROOT__CAPABILITY_UNIX_FILE_SYSTEM,
				newCapabilityUnixFileSystem, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setCapabilityUnixFileSystem(UnixFileSystem newCapabilityUnixFileSystem) {
		((FeatureMap.Internal) getMixed()).set(
				OsPackage.Literals.OPERATING_SYSTEM_ROOT__CAPABILITY_UNIX_FILE_SYSTEM,
				newCapabilityUnixFileSystem);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public User getCapabilityUser() {
		return (User) getMixed().get(OsPackage.Literals.OPERATING_SYSTEM_ROOT__CAPABILITY_USER, true);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetCapabilityUser(User newCapabilityUser, NotificationChain msgs) {
		return ((FeatureMap.Internal) getMixed()).basicAdd(
				OsPackage.Literals.OPERATING_SYSTEM_ROOT__CAPABILITY_USER, newCapabilityUser, msgs);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public void setCapabilityUser(User newCapabilityUser) {
		((FeatureMap.Internal) getMixed()).set(
				OsPackage.Literals.OPERATING_SYSTEM_ROOT__CAPABILITY_USER, newCapabilityUser);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public UserGroup getCapabilityUserGroup() {
		return (UserGroup) getMixed().get(
				OsPackage.Literals.OPERATING_SYSTEM_ROOT__CAPABILITY_USER_GROUP, true);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetCapabilityUserGroup(UserGroup newCapabilityUserGroup,
			NotificationChain msgs) {
		return ((FeatureMap.Internal) getMixed()).basicAdd(
				OsPackage.Literals.OPERATING_SYSTEM_ROOT__CAPABILITY_USER_GROUP,
				newCapabilityUserGroup, msgs);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public void setCapabilityUserGroup(UserGroup newCapabilityUserGroup) {
		((FeatureMap.Internal) getMixed())
				.set(OsPackage.Literals.OPERATING_SYSTEM_ROOT__CAPABILITY_USER_GROUP,
						newCapabilityUserGroup);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public WindowsDirectory getCapabilityWindowsDirectory() {
		return (WindowsDirectory) getMixed().get(
				OsPackage.Literals.OPERATING_SYSTEM_ROOT__CAPABILITY_WINDOWS_DIRECTORY, true);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetCapabilityWindowsDirectory(
			WindowsDirectory newCapabilityWindowsDirectory, NotificationChain msgs) {
		return ((FeatureMap.Internal) getMixed()).basicAdd(
				OsPackage.Literals.OPERATING_SYSTEM_ROOT__CAPABILITY_WINDOWS_DIRECTORY,
				newCapabilityWindowsDirectory, msgs);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public void setCapabilityWindowsDirectory(WindowsDirectory newCapabilityWindowsDirectory) {
		((FeatureMap.Internal) getMixed()).set(
				OsPackage.Literals.OPERATING_SYSTEM_ROOT__CAPABILITY_WINDOWS_DIRECTORY,
				newCapabilityWindowsDirectory);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public WindowsFileSystem getCapabilityWindowsFileSystem() {
		return (WindowsFileSystem) getMixed().get(
				OsPackage.Literals.OPERATING_SYSTEM_ROOT__CAPABILITY_WINDOWS_FILE_SYSTEM, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetCapabilityWindowsFileSystem(
			WindowsFileSystem newCapabilityWindowsFileSystem, NotificationChain msgs) {
		return ((FeatureMap.Internal) getMixed()).basicAdd(
				OsPackage.Literals.OPERATING_SYSTEM_ROOT__CAPABILITY_WINDOWS_FILE_SYSTEM,
				newCapabilityWindowsFileSystem, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setCapabilityWindowsFileSystem(WindowsFileSystem newCapabilityWindowsFileSystem) {
		((FeatureMap.Internal) getMixed()).set(
				OsPackage.Literals.OPERATING_SYSTEM_ROOT__CAPABILITY_WINDOWS_FILE_SYSTEM,
				newCapabilityWindowsFileSystem);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public WindowsLocalGroup getCapabilityWindowsLocalGroup() {
		return (WindowsLocalGroup) getMixed().get(
				OsPackage.Literals.OPERATING_SYSTEM_ROOT__CAPABILITY_WINDOWS_LOCAL_GROUP, true);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetCapabilityWindowsLocalGroup(
			WindowsLocalGroup newCapabilityWindowsLocalGroup, NotificationChain msgs) {
		return ((FeatureMap.Internal) getMixed()).basicAdd(
				OsPackage.Literals.OPERATING_SYSTEM_ROOT__CAPABILITY_WINDOWS_LOCAL_GROUP,
				newCapabilityWindowsLocalGroup, msgs);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public void setCapabilityWindowsLocalGroup(WindowsLocalGroup newCapabilityWindowsLocalGroup) {
		((FeatureMap.Internal) getMixed()).set(
				OsPackage.Literals.OPERATING_SYSTEM_ROOT__CAPABILITY_WINDOWS_LOCAL_GROUP,
				newCapabilityWindowsLocalGroup);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public WindowsLocalService getCapabilityWindowsLocalService() {
		return (WindowsLocalService) getMixed().get(
				OsPackage.Literals.OPERATING_SYSTEM_ROOT__CAPABILITY_WINDOWS_LOCAL_SERVICE, true);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetCapabilityWindowsLocalService(
			WindowsLocalService newCapabilityWindowsLocalService, NotificationChain msgs) {
		return ((FeatureMap.Internal) getMixed()).basicAdd(
				OsPackage.Literals.OPERATING_SYSTEM_ROOT__CAPABILITY_WINDOWS_LOCAL_SERVICE,
				newCapabilityWindowsLocalService, msgs);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public void setCapabilityWindowsLocalService(WindowsLocalService newCapabilityWindowsLocalService) {
		((FeatureMap.Internal) getMixed()).set(
				OsPackage.Literals.OPERATING_SYSTEM_ROOT__CAPABILITY_WINDOWS_LOCAL_SERVICE,
				newCapabilityWindowsLocalService);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public WindowsLocalUser getCapabilityWindowsLocalUser() {
		return (WindowsLocalUser) getMixed().get(
				OsPackage.Literals.OPERATING_SYSTEM_ROOT__CAPABILITY_WINDOWS_LOCAL_USER, true);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetCapabilityWindowsLocalUser(
			WindowsLocalUser newCapabilityWindowsLocalUser, NotificationChain msgs) {
		return ((FeatureMap.Internal) getMixed()).basicAdd(
				OsPackage.Literals.OPERATING_SYSTEM_ROOT__CAPABILITY_WINDOWS_LOCAL_USER,
				newCapabilityWindowsLocalUser, msgs);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public void setCapabilityWindowsLocalUser(WindowsLocalUser newCapabilityWindowsLocalUser) {
		((FeatureMap.Internal) getMixed()).set(
				OsPackage.Literals.OPERATING_SYSTEM_ROOT__CAPABILITY_WINDOWS_LOCAL_USER,
				newCapabilityWindowsLocalUser);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public WindowsOperatingSystem getCapabilityWindowsOperatingSystem() {
		return (WindowsOperatingSystem) getMixed().get(
				OsPackage.Literals.OPERATING_SYSTEM_ROOT__CAPABILITY_WINDOWS_OPERATING_SYSTEM, true);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetCapabilityWindowsOperatingSystem(
			WindowsOperatingSystem newCapabilityWindowsOperatingSystem, NotificationChain msgs) {
		return ((FeatureMap.Internal) getMixed()).basicAdd(
				OsPackage.Literals.OPERATING_SYSTEM_ROOT__CAPABILITY_WINDOWS_OPERATING_SYSTEM,
				newCapabilityWindowsOperatingSystem, msgs);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public void setCapabilityWindowsOperatingSystem(
			WindowsOperatingSystem newCapabilityWindowsOperatingSystem) {
		((FeatureMap.Internal) getMixed()).set(
				OsPackage.Literals.OPERATING_SYSTEM_ROOT__CAPABILITY_WINDOWS_OPERATING_SYSTEM,
				newCapabilityWindowsOperatingSystem);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public AIXLocalGroupUnit getUnitAixLocalGroup() {
		return (AIXLocalGroupUnit) getMixed().get(
				OsPackage.Literals.OPERATING_SYSTEM_ROOT__UNIT_AIX_LOCAL_GROUP, true);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetUnitAixLocalGroup(AIXLocalGroupUnit newUnitAixLocalGroup,
			NotificationChain msgs) {
		return ((FeatureMap.Internal) getMixed()).basicAdd(
				OsPackage.Literals.OPERATING_SYSTEM_ROOT__UNIT_AIX_LOCAL_GROUP, newUnitAixLocalGroup,
				msgs);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public void setUnitAixLocalGroup(AIXLocalGroupUnit newUnitAixLocalGroup) {
		((FeatureMap.Internal) getMixed()).set(
				OsPackage.Literals.OPERATING_SYSTEM_ROOT__UNIT_AIX_LOCAL_GROUP, newUnitAixLocalGroup);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public AIXLocalServiceUnit getUnitAixLocalServiceUnit() {
		return (AIXLocalServiceUnit) getMixed().get(
				OsPackage.Literals.OPERATING_SYSTEM_ROOT__UNIT_AIX_LOCAL_SERVICE_UNIT, true);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetUnitAixLocalServiceUnit(
			AIXLocalServiceUnit newUnitAixLocalServiceUnit, NotificationChain msgs) {
		return ((FeatureMap.Internal) getMixed()).basicAdd(
				OsPackage.Literals.OPERATING_SYSTEM_ROOT__UNIT_AIX_LOCAL_SERVICE_UNIT,
				newUnitAixLocalServiceUnit, msgs);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public void setUnitAixLocalServiceUnit(AIXLocalServiceUnit newUnitAixLocalServiceUnit) {
		((FeatureMap.Internal) getMixed()).set(
				OsPackage.Literals.OPERATING_SYSTEM_ROOT__UNIT_AIX_LOCAL_SERVICE_UNIT,
				newUnitAixLocalServiceUnit);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public AIXLocalUserUnit getUnitAixLocalUser() {
		return (AIXLocalUserUnit) getMixed().get(
				OsPackage.Literals.OPERATING_SYSTEM_ROOT__UNIT_AIX_LOCAL_USER, true);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetUnitAixLocalUser(AIXLocalUserUnit newUnitAixLocalUser,
			NotificationChain msgs) {
		return ((FeatureMap.Internal) getMixed()).basicAdd(
				OsPackage.Literals.OPERATING_SYSTEM_ROOT__UNIT_AIX_LOCAL_USER, newUnitAixLocalUser,
				msgs);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public void setUnitAixLocalUser(AIXLocalUserUnit newUnitAixLocalUser) {
		((FeatureMap.Internal) getMixed()).set(
				OsPackage.Literals.OPERATING_SYSTEM_ROOT__UNIT_AIX_LOCAL_USER, newUnitAixLocalUser);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public AIXOperatingSystemUnit getUnitAixOperatingSystemUnit() {
		return (AIXOperatingSystemUnit) getMixed().get(
				OsPackage.Literals.OPERATING_SYSTEM_ROOT__UNIT_AIX_OPERATING_SYSTEM_UNIT, true);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetUnitAixOperatingSystemUnit(
			AIXOperatingSystemUnit newUnitAixOperatingSystemUnit, NotificationChain msgs) {
		return ((FeatureMap.Internal) getMixed()).basicAdd(
				OsPackage.Literals.OPERATING_SYSTEM_ROOT__UNIT_AIX_OPERATING_SYSTEM_UNIT,
				newUnitAixOperatingSystemUnit, msgs);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public void setUnitAixOperatingSystemUnit(AIXOperatingSystemUnit newUnitAixOperatingSystemUnit) {
		((FeatureMap.Internal) getMixed()).set(
				OsPackage.Literals.OPERATING_SYSTEM_ROOT__UNIT_AIX_OPERATING_SYSTEM_UNIT,
				newUnitAixOperatingSystemUnit);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public DataFileUnit getUnitDataFileUnit() {
		return (DataFileUnit) getMixed().get(
				OsPackage.Literals.OPERATING_SYSTEM_ROOT__UNIT_DATA_FILE_UNIT, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetUnitDataFileUnit(DataFileUnit newUnitDataFileUnit,
			NotificationChain msgs) {
		return ((FeatureMap.Internal) getMixed()).basicAdd(
				OsPackage.Literals.OPERATING_SYSTEM_ROOT__UNIT_DATA_FILE_UNIT, newUnitDataFileUnit,
				msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setUnitDataFileUnit(DataFileUnit newUnitDataFileUnit) {
		((FeatureMap.Internal) getMixed()).set(
				OsPackage.Literals.OPERATING_SYSTEM_ROOT__UNIT_DATA_FILE_UNIT, newUnitDataFileUnit);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public DirectoryUnit getUnitDirectoryUnit() {
		return (DirectoryUnit) getMixed().get(
				OsPackage.Literals.OPERATING_SYSTEM_ROOT__UNIT_DIRECTORY_UNIT, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetUnitDirectoryUnit(DirectoryUnit newUnitDirectoryUnit,
			NotificationChain msgs) {
		return ((FeatureMap.Internal) getMixed()).basicAdd(
				OsPackage.Literals.OPERATING_SYSTEM_ROOT__UNIT_DIRECTORY_UNIT, newUnitDirectoryUnit,
				msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setUnitDirectoryUnit(DirectoryUnit newUnitDirectoryUnit) {
		((FeatureMap.Internal) getMixed()).set(
				OsPackage.Literals.OPERATING_SYSTEM_ROOT__UNIT_DIRECTORY_UNIT, newUnitDirectoryUnit);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public FileSystemContentUnit getUnitFileSystemContentUnit() {
		return (FileSystemContentUnit) getMixed().get(
				OsPackage.Literals.OPERATING_SYSTEM_ROOT__UNIT_FILE_SYSTEM_CONTENT_UNIT, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetUnitFileSystemContentUnit(
			FileSystemContentUnit newUnitFileSystemContentUnit, NotificationChain msgs) {
		return ((FeatureMap.Internal) getMixed()).basicAdd(
				OsPackage.Literals.OPERATING_SYSTEM_ROOT__UNIT_FILE_SYSTEM_CONTENT_UNIT,
				newUnitFileSystemContentUnit, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setUnitFileSystemContentUnit(FileSystemContentUnit newUnitFileSystemContentUnit) {
		((FeatureMap.Internal) getMixed()).set(
				OsPackage.Literals.OPERATING_SYSTEM_ROOT__UNIT_FILE_SYSTEM_CONTENT_UNIT,
				newUnitFileSystemContentUnit);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public FileSystemUnit getUnitFileSystemUnit() {
		return (FileSystemUnit) getMixed().get(
				OsPackage.Literals.OPERATING_SYSTEM_ROOT__UNIT_FILE_SYSTEM_UNIT, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetUnitFileSystemUnit(FileSystemUnit newUnitFileSystemUnit,
			NotificationChain msgs) {
		return ((FeatureMap.Internal) getMixed()).basicAdd(
				OsPackage.Literals.OPERATING_SYSTEM_ROOT__UNIT_FILE_SYSTEM_UNIT, newUnitFileSystemUnit,
				msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setUnitFileSystemUnit(FileSystemUnit newUnitFileSystemUnit) {
		((FeatureMap.Internal) getMixed()).set(
				OsPackage.Literals.OPERATING_SYSTEM_ROOT__UNIT_FILE_SYSTEM_UNIT, newUnitFileSystemUnit);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public LinuxLocalGroupUnit getUnitLinuxLocalGroup() {
		return (LinuxLocalGroupUnit) getMixed().get(
				OsPackage.Literals.OPERATING_SYSTEM_ROOT__UNIT_LINUX_LOCAL_GROUP, true);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetUnitLinuxLocalGroup(LinuxLocalGroupUnit newUnitLinuxLocalGroup,
			NotificationChain msgs) {
		return ((FeatureMap.Internal) getMixed()).basicAdd(
				OsPackage.Literals.OPERATING_SYSTEM_ROOT__UNIT_LINUX_LOCAL_GROUP,
				newUnitLinuxLocalGroup, msgs);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public void setUnitLinuxLocalGroup(LinuxLocalGroupUnit newUnitLinuxLocalGroup) {
		((FeatureMap.Internal) getMixed()).set(
				OsPackage.Literals.OPERATING_SYSTEM_ROOT__UNIT_LINUX_LOCAL_GROUP,
				newUnitLinuxLocalGroup);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public LinuxLocalServiceUnit getUnitLinuxLocalServiceUnit() {
		return (LinuxLocalServiceUnit) getMixed().get(
				OsPackage.Literals.OPERATING_SYSTEM_ROOT__UNIT_LINUX_LOCAL_SERVICE_UNIT, true);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetUnitLinuxLocalServiceUnit(
			LinuxLocalServiceUnit newUnitLinuxLocalServiceUnit, NotificationChain msgs) {
		return ((FeatureMap.Internal) getMixed()).basicAdd(
				OsPackage.Literals.OPERATING_SYSTEM_ROOT__UNIT_LINUX_LOCAL_SERVICE_UNIT,
				newUnitLinuxLocalServiceUnit, msgs);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public void setUnitLinuxLocalServiceUnit(LinuxLocalServiceUnit newUnitLinuxLocalServiceUnit) {
		((FeatureMap.Internal) getMixed()).set(
				OsPackage.Literals.OPERATING_SYSTEM_ROOT__UNIT_LINUX_LOCAL_SERVICE_UNIT,
				newUnitLinuxLocalServiceUnit);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public LinuxLocalUserUnit getUnitLinuxLocalUser() {
		return (LinuxLocalUserUnit) getMixed().get(
				OsPackage.Literals.OPERATING_SYSTEM_ROOT__UNIT_LINUX_LOCAL_USER, true);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetUnitLinuxLocalUser(LinuxLocalUserUnit newUnitLinuxLocalUser,
			NotificationChain msgs) {
		return ((FeatureMap.Internal) getMixed()).basicAdd(
				OsPackage.Literals.OPERATING_SYSTEM_ROOT__UNIT_LINUX_LOCAL_USER, newUnitLinuxLocalUser,
				msgs);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public void setUnitLinuxLocalUser(LinuxLocalUserUnit newUnitLinuxLocalUser) {
		((FeatureMap.Internal) getMixed()).set(
				OsPackage.Literals.OPERATING_SYSTEM_ROOT__UNIT_LINUX_LOCAL_USER, newUnitLinuxLocalUser);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public LinuxOperatingSystemUnit getUnitLinuxOperatingSystemUnit() {
		return (LinuxOperatingSystemUnit) getMixed().get(
				OsPackage.Literals.OPERATING_SYSTEM_ROOT__UNIT_LINUX_OPERATING_SYSTEM_UNIT, true);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetUnitLinuxOperatingSystemUnit(
			LinuxOperatingSystemUnit newUnitLinuxOperatingSystemUnit, NotificationChain msgs) {
		return ((FeatureMap.Internal) getMixed()).basicAdd(
				OsPackage.Literals.OPERATING_SYSTEM_ROOT__UNIT_LINUX_OPERATING_SYSTEM_UNIT,
				newUnitLinuxOperatingSystemUnit, msgs);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public void setUnitLinuxOperatingSystemUnit(
			LinuxOperatingSystemUnit newUnitLinuxOperatingSystemUnit) {
		((FeatureMap.Internal) getMixed()).set(
				OsPackage.Literals.OPERATING_SYSTEM_ROOT__UNIT_LINUX_OPERATING_SYSTEM_UNIT,
				newUnitLinuxOperatingSystemUnit);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public LocalFileSystemUnit getUnitLocalFileSystemUnit() {
		return (LocalFileSystemUnit) getMixed().get(
				OsPackage.Literals.OPERATING_SYSTEM_ROOT__UNIT_LOCAL_FILE_SYSTEM_UNIT, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetUnitLocalFileSystemUnit(
			LocalFileSystemUnit newUnitLocalFileSystemUnit, NotificationChain msgs) {
		return ((FeatureMap.Internal) getMixed()).basicAdd(
				OsPackage.Literals.OPERATING_SYSTEM_ROOT__UNIT_LOCAL_FILE_SYSTEM_UNIT,
				newUnitLocalFileSystemUnit, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setUnitLocalFileSystemUnit(LocalFileSystemUnit newUnitLocalFileSystemUnit) {
		((FeatureMap.Internal) getMixed()).set(
				OsPackage.Literals.OPERATING_SYSTEM_ROOT__UNIT_LOCAL_FILE_SYSTEM_UNIT,
				newUnitLocalFileSystemUnit);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NFSFileSystemUnit getUnitNFSFileSystemUnit() {
		return (NFSFileSystemUnit) getMixed().get(
				OsPackage.Literals.OPERATING_SYSTEM_ROOT__UNIT_NFS_FILE_SYSTEM_UNIT, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetUnitNFSFileSystemUnit(
			NFSFileSystemUnit newUnitNFSFileSystemUnit, NotificationChain msgs) {
		return ((FeatureMap.Internal) getMixed()).basicAdd(
				OsPackage.Literals.OPERATING_SYSTEM_ROOT__UNIT_NFS_FILE_SYSTEM_UNIT,
				newUnitNFSFileSystemUnit, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setUnitNFSFileSystemUnit(NFSFileSystemUnit newUnitNFSFileSystemUnit) {
		((FeatureMap.Internal) getMixed()).set(
				OsPackage.Literals.OPERATING_SYSTEM_ROOT__UNIT_NFS_FILE_SYSTEM_UNIT,
				newUnitNFSFileSystemUnit);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public OpenVmsFileSystemUnit getUnitOpenVmsFileSystemUnit() {
		return (OpenVmsFileSystemUnit) getMixed().get(
				OsPackage.Literals.OPERATING_SYSTEM_ROOT__UNIT_OPEN_VMS_FILE_SYSTEM_UNIT, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetUnitOpenVmsFileSystemUnit(
			OpenVmsFileSystemUnit newUnitOpenVmsFileSystemUnit, NotificationChain msgs) {
		return ((FeatureMap.Internal) getMixed()).basicAdd(
				OsPackage.Literals.OPERATING_SYSTEM_ROOT__UNIT_OPEN_VMS_FILE_SYSTEM_UNIT,
				newUnitOpenVmsFileSystemUnit, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setUnitOpenVmsFileSystemUnit(OpenVmsFileSystemUnit newUnitOpenVmsFileSystemUnit) {
		((FeatureMap.Internal) getMixed()).set(
				OsPackage.Literals.OPERATING_SYSTEM_ROOT__UNIT_OPEN_VMS_FILE_SYSTEM_UNIT,
				newUnitOpenVmsFileSystemUnit);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public OperatingSystemUnit getUnitOperatingSystemUnit() {
		return (OperatingSystemUnit) getMixed().get(
				OsPackage.Literals.OPERATING_SYSTEM_ROOT__UNIT_OPERATING_SYSTEM_UNIT, true);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetUnitOperatingSystemUnit(
			OperatingSystemUnit newUnitOperatingSystemUnit, NotificationChain msgs) {
		return ((FeatureMap.Internal) getMixed()).basicAdd(
				OsPackage.Literals.OPERATING_SYSTEM_ROOT__UNIT_OPERATING_SYSTEM_UNIT,
				newUnitOperatingSystemUnit, msgs);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public void setUnitOperatingSystemUnit(OperatingSystemUnit newUnitOperatingSystemUnit) {
		((FeatureMap.Internal) getMixed()).set(
				OsPackage.Literals.OPERATING_SYSTEM_ROOT__UNIT_OPERATING_SYSTEM_UNIT,
				newUnitOperatingSystemUnit);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public PortConfigUnit getUnitPortConfigUnit() {
		return (PortConfigUnit) getMixed().get(
				OsPackage.Literals.OPERATING_SYSTEM_ROOT__UNIT_PORT_CONFIG_UNIT, true);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetUnitPortConfigUnit(PortConfigUnit newUnitPortConfigUnit,
			NotificationChain msgs) {
		return ((FeatureMap.Internal) getMixed()).basicAdd(
				OsPackage.Literals.OPERATING_SYSTEM_ROOT__UNIT_PORT_CONFIG_UNIT, newUnitPortConfigUnit,
				msgs);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public void setUnitPortConfigUnit(PortConfigUnit newUnitPortConfigUnit) {
		((FeatureMap.Internal) getMixed()).set(
				OsPackage.Literals.OPERATING_SYSTEM_ROOT__UNIT_PORT_CONFIG_UNIT, newUnitPortConfigUnit);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public RemoteFileSystemUnit getUnitRemoteFileSystemUnit() {
		return (RemoteFileSystemUnit) getMixed().get(
				OsPackage.Literals.OPERATING_SYSTEM_ROOT__UNIT_REMOTE_FILE_SYSTEM_UNIT, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetUnitRemoteFileSystemUnit(
			RemoteFileSystemUnit newUnitRemoteFileSystemUnit, NotificationChain msgs) {
		return ((FeatureMap.Internal) getMixed()).basicAdd(
				OsPackage.Literals.OPERATING_SYSTEM_ROOT__UNIT_REMOTE_FILE_SYSTEM_UNIT,
				newUnitRemoteFileSystemUnit, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setUnitRemoteFileSystemUnit(RemoteFileSystemUnit newUnitRemoteFileSystemUnit) {
		((FeatureMap.Internal) getMixed()).set(
				OsPackage.Literals.OPERATING_SYSTEM_ROOT__UNIT_REMOTE_FILE_SYSTEM_UNIT,
				newUnitRemoteFileSystemUnit);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SMBFileSystemUnit getUnitSMBFileSystemUnit() {
		return (SMBFileSystemUnit) getMixed().get(
				OsPackage.Literals.OPERATING_SYSTEM_ROOT__UNIT_SMB_FILE_SYSTEM_UNIT, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetUnitSMBFileSystemUnit(
			SMBFileSystemUnit newUnitSMBFileSystemUnit, NotificationChain msgs) {
		return ((FeatureMap.Internal) getMixed()).basicAdd(
				OsPackage.Literals.OPERATING_SYSTEM_ROOT__UNIT_SMB_FILE_SYSTEM_UNIT,
				newUnitSMBFileSystemUnit, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setUnitSMBFileSystemUnit(SMBFileSystemUnit newUnitSMBFileSystemUnit) {
		((FeatureMap.Internal) getMixed()).set(
				OsPackage.Literals.OPERATING_SYSTEM_ROOT__UNIT_SMB_FILE_SYSTEM_UNIT,
				newUnitSMBFileSystemUnit);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SolarisFileSystemUnit getUnitSolarisFileSystemUnit() {
		return (SolarisFileSystemUnit) getMixed().get(
				OsPackage.Literals.OPERATING_SYSTEM_ROOT__UNIT_SOLARIS_FILE_SYSTEM_UNIT, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetUnitSolarisFileSystemUnit(
			SolarisFileSystemUnit newUnitSolarisFileSystemUnit, NotificationChain msgs) {
		return ((FeatureMap.Internal) getMixed()).basicAdd(
				OsPackage.Literals.OPERATING_SYSTEM_ROOT__UNIT_SOLARIS_FILE_SYSTEM_UNIT,
				newUnitSolarisFileSystemUnit, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setUnitSolarisFileSystemUnit(SolarisFileSystemUnit newUnitSolarisFileSystemUnit) {
		((FeatureMap.Internal) getMixed()).set(
				OsPackage.Literals.OPERATING_SYSTEM_ROOT__UNIT_SOLARIS_FILE_SYSTEM_UNIT,
				newUnitSolarisFileSystemUnit);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public UnixFileSystemUnit getUnitUnixFileSystemUnit() {
		return (UnixFileSystemUnit) getMixed().get(
				OsPackage.Literals.OPERATING_SYSTEM_ROOT__UNIT_UNIX_FILE_SYSTEM_UNIT, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetUnitUnixFileSystemUnit(
			UnixFileSystemUnit newUnitUnixFileSystemUnit, NotificationChain msgs) {
		return ((FeatureMap.Internal) getMixed()).basicAdd(
				OsPackage.Literals.OPERATING_SYSTEM_ROOT__UNIT_UNIX_FILE_SYSTEM_UNIT,
				newUnitUnixFileSystemUnit, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setUnitUnixFileSystemUnit(UnixFileSystemUnit newUnitUnixFileSystemUnit) {
		((FeatureMap.Internal) getMixed()).set(
				OsPackage.Literals.OPERATING_SYSTEM_ROOT__UNIT_UNIX_FILE_SYSTEM_UNIT,
				newUnitUnixFileSystemUnit);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public UserUnit getUnitUser() {
		return (UserUnit) getMixed().get(OsPackage.Literals.OPERATING_SYSTEM_ROOT__UNIT_USER, true);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetUnitUser(UserUnit newUnitUser, NotificationChain msgs) {
		return ((FeatureMap.Internal) getMixed()).basicAdd(
				OsPackage.Literals.OPERATING_SYSTEM_ROOT__UNIT_USER, newUnitUser, msgs);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public void setUnitUser(UserUnit newUnitUser) {
		((FeatureMap.Internal) getMixed()).set(OsPackage.Literals.OPERATING_SYSTEM_ROOT__UNIT_USER,
				newUnitUser);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public UserGroupUnit getUnitUserGroup() {
		return (UserGroupUnit) getMixed().get(
				OsPackage.Literals.OPERATING_SYSTEM_ROOT__UNIT_USER_GROUP, true);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetUnitUserGroup(UserGroupUnit newUnitUserGroup,
			NotificationChain msgs) {
		return ((FeatureMap.Internal) getMixed()).basicAdd(
				OsPackage.Literals.OPERATING_SYSTEM_ROOT__UNIT_USER_GROUP, newUnitUserGroup, msgs);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public void setUnitUserGroup(UserGroupUnit newUnitUserGroup) {
		((FeatureMap.Internal) getMixed()).set(
				OsPackage.Literals.OPERATING_SYSTEM_ROOT__UNIT_USER_GROUP, newUnitUserGroup);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public WindowsFileSystemUnit getUnitWindowsFileSystemUnit() {
		return (WindowsFileSystemUnit) getMixed().get(
				OsPackage.Literals.OPERATING_SYSTEM_ROOT__UNIT_WINDOWS_FILE_SYSTEM_UNIT, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetUnitWindowsFileSystemUnit(
			WindowsFileSystemUnit newUnitWindowsFileSystemUnit, NotificationChain msgs) {
		return ((FeatureMap.Internal) getMixed()).basicAdd(
				OsPackage.Literals.OPERATING_SYSTEM_ROOT__UNIT_WINDOWS_FILE_SYSTEM_UNIT,
				newUnitWindowsFileSystemUnit, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setUnitWindowsFileSystemUnit(WindowsFileSystemUnit newUnitWindowsFileSystemUnit) {
		((FeatureMap.Internal) getMixed()).set(
				OsPackage.Literals.OPERATING_SYSTEM_ROOT__UNIT_WINDOWS_FILE_SYSTEM_UNIT,
				newUnitWindowsFileSystemUnit);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public WindowsLocalGroupUnit getUnitWindowsLocalGroup() {
		return (WindowsLocalGroupUnit) getMixed().get(
				OsPackage.Literals.OPERATING_SYSTEM_ROOT__UNIT_WINDOWS_LOCAL_GROUP, true);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetUnitWindowsLocalGroup(
			WindowsLocalGroupUnit newUnitWindowsLocalGroup, NotificationChain msgs) {
		return ((FeatureMap.Internal) getMixed()).basicAdd(
				OsPackage.Literals.OPERATING_SYSTEM_ROOT__UNIT_WINDOWS_LOCAL_GROUP,
				newUnitWindowsLocalGroup, msgs);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public void setUnitWindowsLocalGroup(WindowsLocalGroupUnit newUnitWindowsLocalGroup) {
		((FeatureMap.Internal) getMixed()).set(
				OsPackage.Literals.OPERATING_SYSTEM_ROOT__UNIT_WINDOWS_LOCAL_GROUP,
				newUnitWindowsLocalGroup);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public WindowsLocalServiceUnit getUnitWindowsLocalServiceUnit() {
		return (WindowsLocalServiceUnit) getMixed().get(
				OsPackage.Literals.OPERATING_SYSTEM_ROOT__UNIT_WINDOWS_LOCAL_SERVICE_UNIT, true);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetUnitWindowsLocalServiceUnit(
			WindowsLocalServiceUnit newUnitWindowsLocalServiceUnit, NotificationChain msgs) {
		return ((FeatureMap.Internal) getMixed()).basicAdd(
				OsPackage.Literals.OPERATING_SYSTEM_ROOT__UNIT_WINDOWS_LOCAL_SERVICE_UNIT,
				newUnitWindowsLocalServiceUnit, msgs);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public void setUnitWindowsLocalServiceUnit(WindowsLocalServiceUnit newUnitWindowsLocalServiceUnit) {
		((FeatureMap.Internal) getMixed()).set(
				OsPackage.Literals.OPERATING_SYSTEM_ROOT__UNIT_WINDOWS_LOCAL_SERVICE_UNIT,
				newUnitWindowsLocalServiceUnit);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public WindowsLocalUserUnit getUnitWindowsLocalUser() {
		return (WindowsLocalUserUnit) getMixed().get(
				OsPackage.Literals.OPERATING_SYSTEM_ROOT__UNIT_WINDOWS_LOCAL_USER, true);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetUnitWindowsLocalUser(
			WindowsLocalUserUnit newUnitWindowsLocalUser, NotificationChain msgs) {
		return ((FeatureMap.Internal) getMixed()).basicAdd(
				OsPackage.Literals.OPERATING_SYSTEM_ROOT__UNIT_WINDOWS_LOCAL_USER,
				newUnitWindowsLocalUser, msgs);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public void setUnitWindowsLocalUser(WindowsLocalUserUnit newUnitWindowsLocalUser) {
		((FeatureMap.Internal) getMixed()).set(
				OsPackage.Literals.OPERATING_SYSTEM_ROOT__UNIT_WINDOWS_LOCAL_USER,
				newUnitWindowsLocalUser);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public WindowsOperatingSystemUnit getUnitWindowsOperatingSystemUnit() {
		return (WindowsOperatingSystemUnit) getMixed().get(
				OsPackage.Literals.OPERATING_SYSTEM_ROOT__UNIT_WINDOWS_OPERATING_SYSTEM_UNIT, true);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetUnitWindowsOperatingSystemUnit(
			WindowsOperatingSystemUnit newUnitWindowsOperatingSystemUnit, NotificationChain msgs) {
		return ((FeatureMap.Internal) getMixed()).basicAdd(
				OsPackage.Literals.OPERATING_SYSTEM_ROOT__UNIT_WINDOWS_OPERATING_SYSTEM_UNIT,
				newUnitWindowsOperatingSystemUnit, msgs);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public void setUnitWindowsOperatingSystemUnit(
			WindowsOperatingSystemUnit newUnitWindowsOperatingSystemUnit) {
		((FeatureMap.Internal) getMixed()).set(
				OsPackage.Literals.OPERATING_SYSTEM_ROOT__UNIT_WINDOWS_OPERATING_SYSTEM_UNIT,
				newUnitWindowsOperatingSystemUnit);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID,
			NotificationChain msgs) {
		switch (featureID)
		{
		case OsPackage.OPERATING_SYSTEM_ROOT__MIXED:
			return ((InternalEList) getMixed()).basicRemove(otherEnd, msgs);
		case OsPackage.OPERATING_SYSTEM_ROOT__XMLNS_PREFIX_MAP:
			return ((InternalEList) ((EMap.InternalMapView) getXMLNSPrefixMap()).eMap()).basicRemove(
					otherEnd, msgs);
		case OsPackage.OPERATING_SYSTEM_ROOT__XSI_SCHEMA_LOCATION:
			return ((InternalEList) ((EMap.InternalMapView) getXSISchemaLocation()).eMap())
					.basicRemove(otherEnd, msgs);
		case OsPackage.OPERATING_SYSTEM_ROOT__CAPABILITY_AIX_LOCAL_GROUP:
			return basicSetCapabilityAixLocalGroup(null, msgs);
		case OsPackage.OPERATING_SYSTEM_ROOT__CAPABILITY_AIX_LOCAL_SERVICE:
			return basicSetCapabilityAixLocalService(null, msgs);
		case OsPackage.OPERATING_SYSTEM_ROOT__CAPABILITY_AIX_LOCAL_USER:
			return basicSetCapabilityAixLocalUser(null, msgs);
		case OsPackage.OPERATING_SYSTEM_ROOT__CAPABILITY_AIX_OPERATING_SYSTEM:
			return basicSetCapabilityAixOperatingSystem(null, msgs);
		case OsPackage.OPERATING_SYSTEM_ROOT__CAPABILITY_DATA_FILE:
			return basicSetCapabilityDataFile(null, msgs);
		case OsPackage.OPERATING_SYSTEM_ROOT__CAPABILITY_DIRECTORY:
			return basicSetCapabilityDirectory(null, msgs);
		case OsPackage.OPERATING_SYSTEM_ROOT__CAPABILITY_FILE_SYSTEM:
			return basicSetCapabilityFileSystem(null, msgs);
		case OsPackage.OPERATING_SYSTEM_ROOT__CAPABILITY_FILE_SYSTEM_CONTENT:
			return basicSetCapabilityFileSystemContent(null, msgs);
		case OsPackage.OPERATING_SYSTEM_ROOT__CAPABILITY_LINUX_LOCAL_GROUP:
			return basicSetCapabilityLinuxLocalGroup(null, msgs);
		case OsPackage.OPERATING_SYSTEM_ROOT__CAPABILITY_LINUX_LOCAL_SERVICE:
			return basicSetCapabilityLinuxLocalService(null, msgs);
		case OsPackage.OPERATING_SYSTEM_ROOT__CAPABILITY_LINUX_LOCAL_USER:
			return basicSetCapabilityLinuxLocalUser(null, msgs);
		case OsPackage.OPERATING_SYSTEM_ROOT__CAPABILITY_LINUX_OPERATING_SYSTEM:
			return basicSetCapabilityLinuxOperatingSystem(null, msgs);
		case OsPackage.OPERATING_SYSTEM_ROOT__CAPABILITY_LOCAL_FILE_SYSTEM:
			return basicSetCapabilityLocalFileSystem(null, msgs);
		case OsPackage.OPERATING_SYSTEM_ROOT__CAPABILITY_NFS_FILE_SYSTEM:
			return basicSetCapabilityNFSFileSystem(null, msgs);
		case OsPackage.OPERATING_SYSTEM_ROOT__CAPABILITY_OPEN_VMS_FILE_SYSTEM:
			return basicSetCapabilityOpenVmsFileSystem(null, msgs);
		case OsPackage.OPERATING_SYSTEM_ROOT__CAPABILITY_OPERATING_SYSTEM:
			return basicSetCapabilityOperatingSystem(null, msgs);
		case OsPackage.OPERATING_SYSTEM_ROOT__CAPABILITY_PORT:
			return basicSetCapabilityPort(null, msgs);
		case OsPackage.OPERATING_SYSTEM_ROOT__CAPABILITY_PORT_CONSUMER:
			return basicSetCapabilityPortConsumer(null, msgs);
		case OsPackage.OPERATING_SYSTEM_ROOT__CAPABILITY_REDHAT_LINUX_LOCAL_GROUP:
			return basicSetCapabilityRedhatLinuxLocalGroup(null, msgs);
		case OsPackage.OPERATING_SYSTEM_ROOT__CAPABILITY_REDHAT_LINUX_LOCAL_SERVICE:
			return basicSetCapabilityRedhatLinuxLocalService(null, msgs);
		case OsPackage.OPERATING_SYSTEM_ROOT__CAPABILITY_REDHAT_LINUX_LOCAL_USER:
			return basicSetCapabilityRedhatLinuxLocalUser(null, msgs);
		case OsPackage.OPERATING_SYSTEM_ROOT__CAPABILITY_REDHAT_LINUX_OPERATING_SYSTEM:
			return basicSetCapabilityRedhatLinuxOperatingSystem(null, msgs);
		case OsPackage.OPERATING_SYSTEM_ROOT__CAPABILITY_REMOTE_FILE_SYSTEM:
			return basicSetCapabilityRemoteFileSystem(null, msgs);
		case OsPackage.OPERATING_SYSTEM_ROOT__CAPABILITY_SMB_FILE_SYSTEM:
			return basicSetCapabilitySMBFileSystem(null, msgs);
		case OsPackage.OPERATING_SYSTEM_ROOT__CAPABILITY_SOLARIS_FILE_SYSTEM:
			return basicSetCapabilitySolarisFileSystem(null, msgs);
		case OsPackage.OPERATING_SYSTEM_ROOT__CAPABILITY_SUSE_LINUX_LOCAL_GROUP:
			return basicSetCapabilitySuseLinuxLocalGroup(null, msgs);
		case OsPackage.OPERATING_SYSTEM_ROOT__CAPABILITY_SUSE_LINUX_LOCAL_SERVICE:
			return basicSetCapabilitySuseLinuxLocalService(null, msgs);
		case OsPackage.OPERATING_SYSTEM_ROOT__CAPABILITY_SUSE_LINUX_LOCAL_USER:
			return basicSetCapabilitySuseLinuxLocalUser(null, msgs);
		case OsPackage.OPERATING_SYSTEM_ROOT__CAPABILITY_SUSE_LINUX_OPERATING_SYSTEM:
			return basicSetCapabilitySuseLinuxOperatingSystem(null, msgs);
		case OsPackage.OPERATING_SYSTEM_ROOT__CAPABILITY_UNIX_DIRECTORY:
			return basicSetCapabilityUnixDirectory(null, msgs);
		case OsPackage.OPERATING_SYSTEM_ROOT__CAPABILITY_UNIX_FILE_SYSTEM:
			return basicSetCapabilityUnixFileSystem(null, msgs);
		case OsPackage.OPERATING_SYSTEM_ROOT__CAPABILITY_USER:
			return basicSetCapabilityUser(null, msgs);
		case OsPackage.OPERATING_SYSTEM_ROOT__CAPABILITY_USER_GROUP:
			return basicSetCapabilityUserGroup(null, msgs);
		case OsPackage.OPERATING_SYSTEM_ROOT__CAPABILITY_WINDOWS_DIRECTORY:
			return basicSetCapabilityWindowsDirectory(null, msgs);
		case OsPackage.OPERATING_SYSTEM_ROOT__CAPABILITY_WINDOWS_FILE_SYSTEM:
			return basicSetCapabilityWindowsFileSystem(null, msgs);
		case OsPackage.OPERATING_SYSTEM_ROOT__CAPABILITY_WINDOWS_LOCAL_GROUP:
			return basicSetCapabilityWindowsLocalGroup(null, msgs);
		case OsPackage.OPERATING_SYSTEM_ROOT__CAPABILITY_WINDOWS_LOCAL_SERVICE:
			return basicSetCapabilityWindowsLocalService(null, msgs);
		case OsPackage.OPERATING_SYSTEM_ROOT__CAPABILITY_WINDOWS_LOCAL_USER:
			return basicSetCapabilityWindowsLocalUser(null, msgs);
		case OsPackage.OPERATING_SYSTEM_ROOT__CAPABILITY_WINDOWS_OPERATING_SYSTEM:
			return basicSetCapabilityWindowsOperatingSystem(null, msgs);
		case OsPackage.OPERATING_SYSTEM_ROOT__UNIT_AIX_LOCAL_GROUP:
			return basicSetUnitAixLocalGroup(null, msgs);
		case OsPackage.OPERATING_SYSTEM_ROOT__UNIT_AIX_LOCAL_SERVICE_UNIT:
			return basicSetUnitAixLocalServiceUnit(null, msgs);
		case OsPackage.OPERATING_SYSTEM_ROOT__UNIT_AIX_LOCAL_USER:
			return basicSetUnitAixLocalUser(null, msgs);
		case OsPackage.OPERATING_SYSTEM_ROOT__UNIT_AIX_OPERATING_SYSTEM_UNIT:
			return basicSetUnitAixOperatingSystemUnit(null, msgs);
		case OsPackage.OPERATING_SYSTEM_ROOT__UNIT_DATA_FILE_UNIT:
			return basicSetUnitDataFileUnit(null, msgs);
		case OsPackage.OPERATING_SYSTEM_ROOT__UNIT_DIRECTORY_UNIT:
			return basicSetUnitDirectoryUnit(null, msgs);
		case OsPackage.OPERATING_SYSTEM_ROOT__UNIT_FILE_SYSTEM_CONTENT_UNIT:
			return basicSetUnitFileSystemContentUnit(null, msgs);
		case OsPackage.OPERATING_SYSTEM_ROOT__UNIT_FILE_SYSTEM_UNIT:
			return basicSetUnitFileSystemUnit(null, msgs);
		case OsPackage.OPERATING_SYSTEM_ROOT__UNIT_LINUX_LOCAL_GROUP:
			return basicSetUnitLinuxLocalGroup(null, msgs);
		case OsPackage.OPERATING_SYSTEM_ROOT__UNIT_LINUX_LOCAL_SERVICE_UNIT:
			return basicSetUnitLinuxLocalServiceUnit(null, msgs);
		case OsPackage.OPERATING_SYSTEM_ROOT__UNIT_LINUX_LOCAL_USER:
			return basicSetUnitLinuxLocalUser(null, msgs);
		case OsPackage.OPERATING_SYSTEM_ROOT__UNIT_LINUX_OPERATING_SYSTEM_UNIT:
			return basicSetUnitLinuxOperatingSystemUnit(null, msgs);
		case OsPackage.OPERATING_SYSTEM_ROOT__UNIT_LOCAL_FILE_SYSTEM_UNIT:
			return basicSetUnitLocalFileSystemUnit(null, msgs);
		case OsPackage.OPERATING_SYSTEM_ROOT__UNIT_NFS_FILE_SYSTEM_UNIT:
			return basicSetUnitNFSFileSystemUnit(null, msgs);
		case OsPackage.OPERATING_SYSTEM_ROOT__UNIT_OPEN_VMS_FILE_SYSTEM_UNIT:
			return basicSetUnitOpenVmsFileSystemUnit(null, msgs);
		case OsPackage.OPERATING_SYSTEM_ROOT__UNIT_OPERATING_SYSTEM_UNIT:
			return basicSetUnitOperatingSystemUnit(null, msgs);
		case OsPackage.OPERATING_SYSTEM_ROOT__UNIT_PORT_CONFIG_UNIT:
			return basicSetUnitPortConfigUnit(null, msgs);
		case OsPackage.OPERATING_SYSTEM_ROOT__UNIT_REMOTE_FILE_SYSTEM_UNIT:
			return basicSetUnitRemoteFileSystemUnit(null, msgs);
		case OsPackage.OPERATING_SYSTEM_ROOT__UNIT_SMB_FILE_SYSTEM_UNIT:
			return basicSetUnitSMBFileSystemUnit(null, msgs);
		case OsPackage.OPERATING_SYSTEM_ROOT__UNIT_SOLARIS_FILE_SYSTEM_UNIT:
			return basicSetUnitSolarisFileSystemUnit(null, msgs);
		case OsPackage.OPERATING_SYSTEM_ROOT__UNIT_UNIX_FILE_SYSTEM_UNIT:
			return basicSetUnitUnixFileSystemUnit(null, msgs);
		case OsPackage.OPERATING_SYSTEM_ROOT__UNIT_USER:
			return basicSetUnitUser(null, msgs);
		case OsPackage.OPERATING_SYSTEM_ROOT__UNIT_USER_GROUP:
			return basicSetUnitUserGroup(null, msgs);
		case OsPackage.OPERATING_SYSTEM_ROOT__UNIT_WINDOWS_FILE_SYSTEM_UNIT:
			return basicSetUnitWindowsFileSystemUnit(null, msgs);
		case OsPackage.OPERATING_SYSTEM_ROOT__UNIT_WINDOWS_LOCAL_GROUP:
			return basicSetUnitWindowsLocalGroup(null, msgs);
		case OsPackage.OPERATING_SYSTEM_ROOT__UNIT_WINDOWS_LOCAL_SERVICE_UNIT:
			return basicSetUnitWindowsLocalServiceUnit(null, msgs);
		case OsPackage.OPERATING_SYSTEM_ROOT__UNIT_WINDOWS_LOCAL_USER:
			return basicSetUnitWindowsLocalUser(null, msgs);
		case OsPackage.OPERATING_SYSTEM_ROOT__UNIT_WINDOWS_OPERATING_SYSTEM_UNIT:
			return basicSetUnitWindowsOperatingSystemUnit(null, msgs);
		}
		return super.eInverseRemove(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID)
		{
		case OsPackage.OPERATING_SYSTEM_ROOT__MIXED:
			if (coreType)
				return getMixed();
			return ((FeatureMap.Internal) getMixed()).getWrapper();
		case OsPackage.OPERATING_SYSTEM_ROOT__XMLNS_PREFIX_MAP:
			if (coreType)
				return ((EMap.InternalMapView) getXMLNSPrefixMap()).eMap();
			else
				return getXMLNSPrefixMap();
		case OsPackage.OPERATING_SYSTEM_ROOT__XSI_SCHEMA_LOCATION:
			if (coreType)
				return ((EMap.InternalMapView) getXSISchemaLocation()).eMap();
			else
				return getXSISchemaLocation();
		case OsPackage.OPERATING_SYSTEM_ROOT__CAPABILITY_AIX_LOCAL_GROUP:
			return getCapabilityAixLocalGroup();
		case OsPackage.OPERATING_SYSTEM_ROOT__CAPABILITY_AIX_LOCAL_SERVICE:
			return getCapabilityAixLocalService();
		case OsPackage.OPERATING_SYSTEM_ROOT__CAPABILITY_AIX_LOCAL_USER:
			return getCapabilityAixLocalUser();
		case OsPackage.OPERATING_SYSTEM_ROOT__CAPABILITY_AIX_OPERATING_SYSTEM:
			return getCapabilityAixOperatingSystem();
		case OsPackage.OPERATING_SYSTEM_ROOT__CAPABILITY_DATA_FILE:
			return getCapabilityDataFile();
		case OsPackage.OPERATING_SYSTEM_ROOT__CAPABILITY_DIRECTORY:
			return getCapabilityDirectory();
		case OsPackage.OPERATING_SYSTEM_ROOT__CAPABILITY_FILE_SYSTEM:
			return getCapabilityFileSystem();
		case OsPackage.OPERATING_SYSTEM_ROOT__CAPABILITY_FILE_SYSTEM_CONTENT:
			return getCapabilityFileSystemContent();
		case OsPackage.OPERATING_SYSTEM_ROOT__CAPABILITY_LINUX_LOCAL_GROUP:
			return getCapabilityLinuxLocalGroup();
		case OsPackage.OPERATING_SYSTEM_ROOT__CAPABILITY_LINUX_LOCAL_SERVICE:
			return getCapabilityLinuxLocalService();
		case OsPackage.OPERATING_SYSTEM_ROOT__CAPABILITY_LINUX_LOCAL_USER:
			return getCapabilityLinuxLocalUser();
		case OsPackage.OPERATING_SYSTEM_ROOT__CAPABILITY_LINUX_OPERATING_SYSTEM:
			return getCapabilityLinuxOperatingSystem();
		case OsPackage.OPERATING_SYSTEM_ROOT__CAPABILITY_LOCAL_FILE_SYSTEM:
			return getCapabilityLocalFileSystem();
		case OsPackage.OPERATING_SYSTEM_ROOT__CAPABILITY_NFS_FILE_SYSTEM:
			return getCapabilityNFSFileSystem();
		case OsPackage.OPERATING_SYSTEM_ROOT__CAPABILITY_OPEN_VMS_FILE_SYSTEM:
			return getCapabilityOpenVmsFileSystem();
		case OsPackage.OPERATING_SYSTEM_ROOT__CAPABILITY_OPERATING_SYSTEM:
			return getCapabilityOperatingSystem();
		case OsPackage.OPERATING_SYSTEM_ROOT__CAPABILITY_PORT:
			return getCapabilityPort();
		case OsPackage.OPERATING_SYSTEM_ROOT__CAPABILITY_PORT_CONSUMER:
			return getCapabilityPortConsumer();
		case OsPackage.OPERATING_SYSTEM_ROOT__CAPABILITY_REDHAT_LINUX_LOCAL_GROUP:
			return getCapabilityRedhatLinuxLocalGroup();
		case OsPackage.OPERATING_SYSTEM_ROOT__CAPABILITY_REDHAT_LINUX_LOCAL_SERVICE:
			return getCapabilityRedhatLinuxLocalService();
		case OsPackage.OPERATING_SYSTEM_ROOT__CAPABILITY_REDHAT_LINUX_LOCAL_USER:
			return getCapabilityRedhatLinuxLocalUser();
		case OsPackage.OPERATING_SYSTEM_ROOT__CAPABILITY_REDHAT_LINUX_OPERATING_SYSTEM:
			return getCapabilityRedhatLinuxOperatingSystem();
		case OsPackage.OPERATING_SYSTEM_ROOT__CAPABILITY_REMOTE_FILE_SYSTEM:
			return getCapabilityRemoteFileSystem();
		case OsPackage.OPERATING_SYSTEM_ROOT__CAPABILITY_SMB_FILE_SYSTEM:
			return getCapabilitySMBFileSystem();
		case OsPackage.OPERATING_SYSTEM_ROOT__CAPABILITY_SOLARIS_FILE_SYSTEM:
			return getCapabilitySolarisFileSystem();
		case OsPackage.OPERATING_SYSTEM_ROOT__CAPABILITY_SUSE_LINUX_LOCAL_GROUP:
			return getCapabilitySuseLinuxLocalGroup();
		case OsPackage.OPERATING_SYSTEM_ROOT__CAPABILITY_SUSE_LINUX_LOCAL_SERVICE:
			return getCapabilitySuseLinuxLocalService();
		case OsPackage.OPERATING_SYSTEM_ROOT__CAPABILITY_SUSE_LINUX_LOCAL_USER:
			return getCapabilitySuseLinuxLocalUser();
		case OsPackage.OPERATING_SYSTEM_ROOT__CAPABILITY_SUSE_LINUX_OPERATING_SYSTEM:
			return getCapabilitySuseLinuxOperatingSystem();
		case OsPackage.OPERATING_SYSTEM_ROOT__CAPABILITY_UNIX_DIRECTORY:
			return getCapabilityUnixDirectory();
		case OsPackage.OPERATING_SYSTEM_ROOT__CAPABILITY_UNIX_FILE_SYSTEM:
			return getCapabilityUnixFileSystem();
		case OsPackage.OPERATING_SYSTEM_ROOT__CAPABILITY_USER:
			return getCapabilityUser();
		case OsPackage.OPERATING_SYSTEM_ROOT__CAPABILITY_USER_GROUP:
			return getCapabilityUserGroup();
		case OsPackage.OPERATING_SYSTEM_ROOT__CAPABILITY_WINDOWS_DIRECTORY:
			return getCapabilityWindowsDirectory();
		case OsPackage.OPERATING_SYSTEM_ROOT__CAPABILITY_WINDOWS_FILE_SYSTEM:
			return getCapabilityWindowsFileSystem();
		case OsPackage.OPERATING_SYSTEM_ROOT__CAPABILITY_WINDOWS_LOCAL_GROUP:
			return getCapabilityWindowsLocalGroup();
		case OsPackage.OPERATING_SYSTEM_ROOT__CAPABILITY_WINDOWS_LOCAL_SERVICE:
			return getCapabilityWindowsLocalService();
		case OsPackage.OPERATING_SYSTEM_ROOT__CAPABILITY_WINDOWS_LOCAL_USER:
			return getCapabilityWindowsLocalUser();
		case OsPackage.OPERATING_SYSTEM_ROOT__CAPABILITY_WINDOWS_OPERATING_SYSTEM:
			return getCapabilityWindowsOperatingSystem();
		case OsPackage.OPERATING_SYSTEM_ROOT__UNIT_AIX_LOCAL_GROUP:
			return getUnitAixLocalGroup();
		case OsPackage.OPERATING_SYSTEM_ROOT__UNIT_AIX_LOCAL_SERVICE_UNIT:
			return getUnitAixLocalServiceUnit();
		case OsPackage.OPERATING_SYSTEM_ROOT__UNIT_AIX_LOCAL_USER:
			return getUnitAixLocalUser();
		case OsPackage.OPERATING_SYSTEM_ROOT__UNIT_AIX_OPERATING_SYSTEM_UNIT:
			return getUnitAixOperatingSystemUnit();
		case OsPackage.OPERATING_SYSTEM_ROOT__UNIT_DATA_FILE_UNIT:
			return getUnitDataFileUnit();
		case OsPackage.OPERATING_SYSTEM_ROOT__UNIT_DIRECTORY_UNIT:
			return getUnitDirectoryUnit();
		case OsPackage.OPERATING_SYSTEM_ROOT__UNIT_FILE_SYSTEM_CONTENT_UNIT:
			return getUnitFileSystemContentUnit();
		case OsPackage.OPERATING_SYSTEM_ROOT__UNIT_FILE_SYSTEM_UNIT:
			return getUnitFileSystemUnit();
		case OsPackage.OPERATING_SYSTEM_ROOT__UNIT_LINUX_LOCAL_GROUP:
			return getUnitLinuxLocalGroup();
		case OsPackage.OPERATING_SYSTEM_ROOT__UNIT_LINUX_LOCAL_SERVICE_UNIT:
			return getUnitLinuxLocalServiceUnit();
		case OsPackage.OPERATING_SYSTEM_ROOT__UNIT_LINUX_LOCAL_USER:
			return getUnitLinuxLocalUser();
		case OsPackage.OPERATING_SYSTEM_ROOT__UNIT_LINUX_OPERATING_SYSTEM_UNIT:
			return getUnitLinuxOperatingSystemUnit();
		case OsPackage.OPERATING_SYSTEM_ROOT__UNIT_LOCAL_FILE_SYSTEM_UNIT:
			return getUnitLocalFileSystemUnit();
		case OsPackage.OPERATING_SYSTEM_ROOT__UNIT_NFS_FILE_SYSTEM_UNIT:
			return getUnitNFSFileSystemUnit();
		case OsPackage.OPERATING_SYSTEM_ROOT__UNIT_OPEN_VMS_FILE_SYSTEM_UNIT:
			return getUnitOpenVmsFileSystemUnit();
		case OsPackage.OPERATING_SYSTEM_ROOT__UNIT_OPERATING_SYSTEM_UNIT:
			return getUnitOperatingSystemUnit();
		case OsPackage.OPERATING_SYSTEM_ROOT__UNIT_PORT_CONFIG_UNIT:
			return getUnitPortConfigUnit();
		case OsPackage.OPERATING_SYSTEM_ROOT__UNIT_REMOTE_FILE_SYSTEM_UNIT:
			return getUnitRemoteFileSystemUnit();
		case OsPackage.OPERATING_SYSTEM_ROOT__UNIT_SMB_FILE_SYSTEM_UNIT:
			return getUnitSMBFileSystemUnit();
		case OsPackage.OPERATING_SYSTEM_ROOT__UNIT_SOLARIS_FILE_SYSTEM_UNIT:
			return getUnitSolarisFileSystemUnit();
		case OsPackage.OPERATING_SYSTEM_ROOT__UNIT_UNIX_FILE_SYSTEM_UNIT:
			return getUnitUnixFileSystemUnit();
		case OsPackage.OPERATING_SYSTEM_ROOT__UNIT_USER:
			return getUnitUser();
		case OsPackage.OPERATING_SYSTEM_ROOT__UNIT_USER_GROUP:
			return getUnitUserGroup();
		case OsPackage.OPERATING_SYSTEM_ROOT__UNIT_WINDOWS_FILE_SYSTEM_UNIT:
			return getUnitWindowsFileSystemUnit();
		case OsPackage.OPERATING_SYSTEM_ROOT__UNIT_WINDOWS_LOCAL_GROUP:
			return getUnitWindowsLocalGroup();
		case OsPackage.OPERATING_SYSTEM_ROOT__UNIT_WINDOWS_LOCAL_SERVICE_UNIT:
			return getUnitWindowsLocalServiceUnit();
		case OsPackage.OPERATING_SYSTEM_ROOT__UNIT_WINDOWS_LOCAL_USER:
			return getUnitWindowsLocalUser();
		case OsPackage.OPERATING_SYSTEM_ROOT__UNIT_WINDOWS_OPERATING_SYSTEM_UNIT:
			return getUnitWindowsOperatingSystemUnit();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public void eSet(int featureID, Object newValue) {
		switch (featureID)
		{
		case OsPackage.OPERATING_SYSTEM_ROOT__MIXED:
			((FeatureMap.Internal) getMixed()).set(newValue);
			return;
		case OsPackage.OPERATING_SYSTEM_ROOT__XMLNS_PREFIX_MAP:
			((EStructuralFeature.Setting) ((EMap.InternalMapView) getXMLNSPrefixMap()).eMap())
					.set(newValue);
			return;
		case OsPackage.OPERATING_SYSTEM_ROOT__XSI_SCHEMA_LOCATION:
			((EStructuralFeature.Setting) ((EMap.InternalMapView) getXSISchemaLocation()).eMap())
					.set(newValue);
			return;
		case OsPackage.OPERATING_SYSTEM_ROOT__CAPABILITY_AIX_LOCAL_GROUP:
			setCapabilityAixLocalGroup((AIXLocalGroup) newValue);
			return;
		case OsPackage.OPERATING_SYSTEM_ROOT__CAPABILITY_AIX_LOCAL_SERVICE:
			setCapabilityAixLocalService((AIXLocalService) newValue);
			return;
		case OsPackage.OPERATING_SYSTEM_ROOT__CAPABILITY_AIX_LOCAL_USER:
			setCapabilityAixLocalUser((AIXLocalUser) newValue);
			return;
		case OsPackage.OPERATING_SYSTEM_ROOT__CAPABILITY_AIX_OPERATING_SYSTEM:
			setCapabilityAixOperatingSystem((AIXOperatingSystem) newValue);
			return;
		case OsPackage.OPERATING_SYSTEM_ROOT__CAPABILITY_DATA_FILE:
			setCapabilityDataFile((DataFile) newValue);
			return;
		case OsPackage.OPERATING_SYSTEM_ROOT__CAPABILITY_DIRECTORY:
			setCapabilityDirectory((Directory) newValue);
			return;
		case OsPackage.OPERATING_SYSTEM_ROOT__CAPABILITY_FILE_SYSTEM:
			setCapabilityFileSystem((FileSystem) newValue);
			return;
		case OsPackage.OPERATING_SYSTEM_ROOT__CAPABILITY_FILE_SYSTEM_CONTENT:
			setCapabilityFileSystemContent((FileSystemContent) newValue);
			return;
		case OsPackage.OPERATING_SYSTEM_ROOT__CAPABILITY_LINUX_LOCAL_GROUP:
			setCapabilityLinuxLocalGroup((LinuxLocalGroup) newValue);
			return;
		case OsPackage.OPERATING_SYSTEM_ROOT__CAPABILITY_LINUX_LOCAL_SERVICE:
			setCapabilityLinuxLocalService((LinuxLocalService) newValue);
			return;
		case OsPackage.OPERATING_SYSTEM_ROOT__CAPABILITY_LINUX_LOCAL_USER:
			setCapabilityLinuxLocalUser((LinuxLocalUser) newValue);
			return;
		case OsPackage.OPERATING_SYSTEM_ROOT__CAPABILITY_LINUX_OPERATING_SYSTEM:
			setCapabilityLinuxOperatingSystem((LinuxOperatingSystem) newValue);
			return;
		case OsPackage.OPERATING_SYSTEM_ROOT__CAPABILITY_LOCAL_FILE_SYSTEM:
			setCapabilityLocalFileSystem((LocalFileSystem) newValue);
			return;
		case OsPackage.OPERATING_SYSTEM_ROOT__CAPABILITY_NFS_FILE_SYSTEM:
			setCapabilityNFSFileSystem((NFSFileSystem) newValue);
			return;
		case OsPackage.OPERATING_SYSTEM_ROOT__CAPABILITY_OPEN_VMS_FILE_SYSTEM:
			setCapabilityOpenVmsFileSystem((OpenVmsFileSystem) newValue);
			return;
		case OsPackage.OPERATING_SYSTEM_ROOT__CAPABILITY_OPERATING_SYSTEM:
			setCapabilityOperatingSystem((OperatingSystem) newValue);
			return;
		case OsPackage.OPERATING_SYSTEM_ROOT__CAPABILITY_PORT:
			setCapabilityPort((Port) newValue);
			return;
		case OsPackage.OPERATING_SYSTEM_ROOT__CAPABILITY_PORT_CONSUMER:
			setCapabilityPortConsumer((PortConsumer) newValue);
			return;
		case OsPackage.OPERATING_SYSTEM_ROOT__CAPABILITY_REDHAT_LINUX_LOCAL_GROUP:
			setCapabilityRedhatLinuxLocalGroup((RedhatLinuxLocalGroup) newValue);
			return;
		case OsPackage.OPERATING_SYSTEM_ROOT__CAPABILITY_REDHAT_LINUX_LOCAL_SERVICE:
			setCapabilityRedhatLinuxLocalService((RedhatLinuxLocalService) newValue);
			return;
		case OsPackage.OPERATING_SYSTEM_ROOT__CAPABILITY_REDHAT_LINUX_LOCAL_USER:
			setCapabilityRedhatLinuxLocalUser((RedhatLinuxLocalUser) newValue);
			return;
		case OsPackage.OPERATING_SYSTEM_ROOT__CAPABILITY_REDHAT_LINUX_OPERATING_SYSTEM:
			setCapabilityRedhatLinuxOperatingSystem((RedhatLinuxOperatingSystem) newValue);
			return;
		case OsPackage.OPERATING_SYSTEM_ROOT__CAPABILITY_REMOTE_FILE_SYSTEM:
			setCapabilityRemoteFileSystem((RemoteFileSystem) newValue);
			return;
		case OsPackage.OPERATING_SYSTEM_ROOT__CAPABILITY_SMB_FILE_SYSTEM:
			setCapabilitySMBFileSystem((SMBFileSystem) newValue);
			return;
		case OsPackage.OPERATING_SYSTEM_ROOT__CAPABILITY_SOLARIS_FILE_SYSTEM:
			setCapabilitySolarisFileSystem((SolarisFileSystem) newValue);
			return;
		case OsPackage.OPERATING_SYSTEM_ROOT__CAPABILITY_SUSE_LINUX_LOCAL_GROUP:
			setCapabilitySuseLinuxLocalGroup((SUSELinuxLocalGroup) newValue);
			return;
		case OsPackage.OPERATING_SYSTEM_ROOT__CAPABILITY_SUSE_LINUX_LOCAL_SERVICE:
			setCapabilitySuseLinuxLocalService((SUSELinuxLocalService) newValue);
			return;
		case OsPackage.OPERATING_SYSTEM_ROOT__CAPABILITY_SUSE_LINUX_LOCAL_USER:
			setCapabilitySuseLinuxLocalUser((SUSELinuxLocalUser) newValue);
			return;
		case OsPackage.OPERATING_SYSTEM_ROOT__CAPABILITY_SUSE_LINUX_OPERATING_SYSTEM:
			setCapabilitySuseLinuxOperatingSystem((SUSELinuxOperatingSystem) newValue);
			return;
		case OsPackage.OPERATING_SYSTEM_ROOT__CAPABILITY_UNIX_DIRECTORY:
			setCapabilityUnixDirectory((UnixDirectory) newValue);
			return;
		case OsPackage.OPERATING_SYSTEM_ROOT__CAPABILITY_UNIX_FILE_SYSTEM:
			setCapabilityUnixFileSystem((UnixFileSystem) newValue);
			return;
		case OsPackage.OPERATING_SYSTEM_ROOT__CAPABILITY_USER:
			setCapabilityUser((User) newValue);
			return;
		case OsPackage.OPERATING_SYSTEM_ROOT__CAPABILITY_USER_GROUP:
			setCapabilityUserGroup((UserGroup) newValue);
			return;
		case OsPackage.OPERATING_SYSTEM_ROOT__CAPABILITY_WINDOWS_DIRECTORY:
			setCapabilityWindowsDirectory((WindowsDirectory) newValue);
			return;
		case OsPackage.OPERATING_SYSTEM_ROOT__CAPABILITY_WINDOWS_FILE_SYSTEM:
			setCapabilityWindowsFileSystem((WindowsFileSystem) newValue);
			return;
		case OsPackage.OPERATING_SYSTEM_ROOT__CAPABILITY_WINDOWS_LOCAL_GROUP:
			setCapabilityWindowsLocalGroup((WindowsLocalGroup) newValue);
			return;
		case OsPackage.OPERATING_SYSTEM_ROOT__CAPABILITY_WINDOWS_LOCAL_SERVICE:
			setCapabilityWindowsLocalService((WindowsLocalService) newValue);
			return;
		case OsPackage.OPERATING_SYSTEM_ROOT__CAPABILITY_WINDOWS_LOCAL_USER:
			setCapabilityWindowsLocalUser((WindowsLocalUser) newValue);
			return;
		case OsPackage.OPERATING_SYSTEM_ROOT__CAPABILITY_WINDOWS_OPERATING_SYSTEM:
			setCapabilityWindowsOperatingSystem((WindowsOperatingSystem) newValue);
			return;
		case OsPackage.OPERATING_SYSTEM_ROOT__UNIT_AIX_LOCAL_GROUP:
			setUnitAixLocalGroup((AIXLocalGroupUnit) newValue);
			return;
		case OsPackage.OPERATING_SYSTEM_ROOT__UNIT_AIX_LOCAL_SERVICE_UNIT:
			setUnitAixLocalServiceUnit((AIXLocalServiceUnit) newValue);
			return;
		case OsPackage.OPERATING_SYSTEM_ROOT__UNIT_AIX_LOCAL_USER:
			setUnitAixLocalUser((AIXLocalUserUnit) newValue);
			return;
		case OsPackage.OPERATING_SYSTEM_ROOT__UNIT_AIX_OPERATING_SYSTEM_UNIT:
			setUnitAixOperatingSystemUnit((AIXOperatingSystemUnit) newValue);
			return;
		case OsPackage.OPERATING_SYSTEM_ROOT__UNIT_DATA_FILE_UNIT:
			setUnitDataFileUnit((DataFileUnit) newValue);
			return;
		case OsPackage.OPERATING_SYSTEM_ROOT__UNIT_DIRECTORY_UNIT:
			setUnitDirectoryUnit((DirectoryUnit) newValue);
			return;
		case OsPackage.OPERATING_SYSTEM_ROOT__UNIT_FILE_SYSTEM_CONTENT_UNIT:
			setUnitFileSystemContentUnit((FileSystemContentUnit) newValue);
			return;
		case OsPackage.OPERATING_SYSTEM_ROOT__UNIT_FILE_SYSTEM_UNIT:
			setUnitFileSystemUnit((FileSystemUnit) newValue);
			return;
		case OsPackage.OPERATING_SYSTEM_ROOT__UNIT_LINUX_LOCAL_GROUP:
			setUnitLinuxLocalGroup((LinuxLocalGroupUnit) newValue);
			return;
		case OsPackage.OPERATING_SYSTEM_ROOT__UNIT_LINUX_LOCAL_SERVICE_UNIT:
			setUnitLinuxLocalServiceUnit((LinuxLocalServiceUnit) newValue);
			return;
		case OsPackage.OPERATING_SYSTEM_ROOT__UNIT_LINUX_LOCAL_USER:
			setUnitLinuxLocalUser((LinuxLocalUserUnit) newValue);
			return;
		case OsPackage.OPERATING_SYSTEM_ROOT__UNIT_LINUX_OPERATING_SYSTEM_UNIT:
			setUnitLinuxOperatingSystemUnit((LinuxOperatingSystemUnit) newValue);
			return;
		case OsPackage.OPERATING_SYSTEM_ROOT__UNIT_LOCAL_FILE_SYSTEM_UNIT:
			setUnitLocalFileSystemUnit((LocalFileSystemUnit) newValue);
			return;
		case OsPackage.OPERATING_SYSTEM_ROOT__UNIT_NFS_FILE_SYSTEM_UNIT:
			setUnitNFSFileSystemUnit((NFSFileSystemUnit) newValue);
			return;
		case OsPackage.OPERATING_SYSTEM_ROOT__UNIT_OPEN_VMS_FILE_SYSTEM_UNIT:
			setUnitOpenVmsFileSystemUnit((OpenVmsFileSystemUnit) newValue);
			return;
		case OsPackage.OPERATING_SYSTEM_ROOT__UNIT_OPERATING_SYSTEM_UNIT:
			setUnitOperatingSystemUnit((OperatingSystemUnit) newValue);
			return;
		case OsPackage.OPERATING_SYSTEM_ROOT__UNIT_PORT_CONFIG_UNIT:
			setUnitPortConfigUnit((PortConfigUnit) newValue);
			return;
		case OsPackage.OPERATING_SYSTEM_ROOT__UNIT_REMOTE_FILE_SYSTEM_UNIT:
			setUnitRemoteFileSystemUnit((RemoteFileSystemUnit) newValue);
			return;
		case OsPackage.OPERATING_SYSTEM_ROOT__UNIT_SMB_FILE_SYSTEM_UNIT:
			setUnitSMBFileSystemUnit((SMBFileSystemUnit) newValue);
			return;
		case OsPackage.OPERATING_SYSTEM_ROOT__UNIT_SOLARIS_FILE_SYSTEM_UNIT:
			setUnitSolarisFileSystemUnit((SolarisFileSystemUnit) newValue);
			return;
		case OsPackage.OPERATING_SYSTEM_ROOT__UNIT_UNIX_FILE_SYSTEM_UNIT:
			setUnitUnixFileSystemUnit((UnixFileSystemUnit) newValue);
			return;
		case OsPackage.OPERATING_SYSTEM_ROOT__UNIT_USER:
			setUnitUser((UserUnit) newValue);
			return;
		case OsPackage.OPERATING_SYSTEM_ROOT__UNIT_USER_GROUP:
			setUnitUserGroup((UserGroupUnit) newValue);
			return;
		case OsPackage.OPERATING_SYSTEM_ROOT__UNIT_WINDOWS_FILE_SYSTEM_UNIT:
			setUnitWindowsFileSystemUnit((WindowsFileSystemUnit) newValue);
			return;
		case OsPackage.OPERATING_SYSTEM_ROOT__UNIT_WINDOWS_LOCAL_GROUP:
			setUnitWindowsLocalGroup((WindowsLocalGroupUnit) newValue);
			return;
		case OsPackage.OPERATING_SYSTEM_ROOT__UNIT_WINDOWS_LOCAL_SERVICE_UNIT:
			setUnitWindowsLocalServiceUnit((WindowsLocalServiceUnit) newValue);
			return;
		case OsPackage.OPERATING_SYSTEM_ROOT__UNIT_WINDOWS_LOCAL_USER:
			setUnitWindowsLocalUser((WindowsLocalUserUnit) newValue);
			return;
		case OsPackage.OPERATING_SYSTEM_ROOT__UNIT_WINDOWS_OPERATING_SYSTEM_UNIT:
			setUnitWindowsOperatingSystemUnit((WindowsOperatingSystemUnit) newValue);
			return;
		}
		super.eSet(featureID, newValue);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public void eUnset(int featureID) {
		switch (featureID)
		{
		case OsPackage.OPERATING_SYSTEM_ROOT__MIXED:
			getMixed().clear();
			return;
		case OsPackage.OPERATING_SYSTEM_ROOT__XMLNS_PREFIX_MAP:
			getXMLNSPrefixMap().clear();
			return;
		case OsPackage.OPERATING_SYSTEM_ROOT__XSI_SCHEMA_LOCATION:
			getXSISchemaLocation().clear();
			return;
		case OsPackage.OPERATING_SYSTEM_ROOT__CAPABILITY_AIX_LOCAL_GROUP:
			setCapabilityAixLocalGroup((AIXLocalGroup) null);
			return;
		case OsPackage.OPERATING_SYSTEM_ROOT__CAPABILITY_AIX_LOCAL_SERVICE:
			setCapabilityAixLocalService((AIXLocalService) null);
			return;
		case OsPackage.OPERATING_SYSTEM_ROOT__CAPABILITY_AIX_LOCAL_USER:
			setCapabilityAixLocalUser((AIXLocalUser) null);
			return;
		case OsPackage.OPERATING_SYSTEM_ROOT__CAPABILITY_AIX_OPERATING_SYSTEM:
			setCapabilityAixOperatingSystem((AIXOperatingSystem) null);
			return;
		case OsPackage.OPERATING_SYSTEM_ROOT__CAPABILITY_DATA_FILE:
			setCapabilityDataFile((DataFile) null);
			return;
		case OsPackage.OPERATING_SYSTEM_ROOT__CAPABILITY_DIRECTORY:
			setCapabilityDirectory((Directory) null);
			return;
		case OsPackage.OPERATING_SYSTEM_ROOT__CAPABILITY_FILE_SYSTEM:
			setCapabilityFileSystem((FileSystem) null);
			return;
		case OsPackage.OPERATING_SYSTEM_ROOT__CAPABILITY_FILE_SYSTEM_CONTENT:
			setCapabilityFileSystemContent((FileSystemContent) null);
			return;
		case OsPackage.OPERATING_SYSTEM_ROOT__CAPABILITY_LINUX_LOCAL_GROUP:
			setCapabilityLinuxLocalGroup((LinuxLocalGroup) null);
			return;
		case OsPackage.OPERATING_SYSTEM_ROOT__CAPABILITY_LINUX_LOCAL_SERVICE:
			setCapabilityLinuxLocalService((LinuxLocalService) null);
			return;
		case OsPackage.OPERATING_SYSTEM_ROOT__CAPABILITY_LINUX_LOCAL_USER:
			setCapabilityLinuxLocalUser((LinuxLocalUser) null);
			return;
		case OsPackage.OPERATING_SYSTEM_ROOT__CAPABILITY_LINUX_OPERATING_SYSTEM:
			setCapabilityLinuxOperatingSystem((LinuxOperatingSystem) null);
			return;
		case OsPackage.OPERATING_SYSTEM_ROOT__CAPABILITY_LOCAL_FILE_SYSTEM:
			setCapabilityLocalFileSystem((LocalFileSystem) null);
			return;
		case OsPackage.OPERATING_SYSTEM_ROOT__CAPABILITY_NFS_FILE_SYSTEM:
			setCapabilityNFSFileSystem((NFSFileSystem) null);
			return;
		case OsPackage.OPERATING_SYSTEM_ROOT__CAPABILITY_OPEN_VMS_FILE_SYSTEM:
			setCapabilityOpenVmsFileSystem((OpenVmsFileSystem) null);
			return;
		case OsPackage.OPERATING_SYSTEM_ROOT__CAPABILITY_OPERATING_SYSTEM:
			setCapabilityOperatingSystem((OperatingSystem) null);
			return;
		case OsPackage.OPERATING_SYSTEM_ROOT__CAPABILITY_PORT:
			setCapabilityPort((Port) null);
			return;
		case OsPackage.OPERATING_SYSTEM_ROOT__CAPABILITY_PORT_CONSUMER:
			setCapabilityPortConsumer((PortConsumer) null);
			return;
		case OsPackage.OPERATING_SYSTEM_ROOT__CAPABILITY_REDHAT_LINUX_LOCAL_GROUP:
			setCapabilityRedhatLinuxLocalGroup((RedhatLinuxLocalGroup) null);
			return;
		case OsPackage.OPERATING_SYSTEM_ROOT__CAPABILITY_REDHAT_LINUX_LOCAL_SERVICE:
			setCapabilityRedhatLinuxLocalService((RedhatLinuxLocalService) null);
			return;
		case OsPackage.OPERATING_SYSTEM_ROOT__CAPABILITY_REDHAT_LINUX_LOCAL_USER:
			setCapabilityRedhatLinuxLocalUser((RedhatLinuxLocalUser) null);
			return;
		case OsPackage.OPERATING_SYSTEM_ROOT__CAPABILITY_REDHAT_LINUX_OPERATING_SYSTEM:
			setCapabilityRedhatLinuxOperatingSystem((RedhatLinuxOperatingSystem) null);
			return;
		case OsPackage.OPERATING_SYSTEM_ROOT__CAPABILITY_REMOTE_FILE_SYSTEM:
			setCapabilityRemoteFileSystem((RemoteFileSystem) null);
			return;
		case OsPackage.OPERATING_SYSTEM_ROOT__CAPABILITY_SMB_FILE_SYSTEM:
			setCapabilitySMBFileSystem((SMBFileSystem) null);
			return;
		case OsPackage.OPERATING_SYSTEM_ROOT__CAPABILITY_SOLARIS_FILE_SYSTEM:
			setCapabilitySolarisFileSystem((SolarisFileSystem) null);
			return;
		case OsPackage.OPERATING_SYSTEM_ROOT__CAPABILITY_SUSE_LINUX_LOCAL_GROUP:
			setCapabilitySuseLinuxLocalGroup((SUSELinuxLocalGroup) null);
			return;
		case OsPackage.OPERATING_SYSTEM_ROOT__CAPABILITY_SUSE_LINUX_LOCAL_SERVICE:
			setCapabilitySuseLinuxLocalService((SUSELinuxLocalService) null);
			return;
		case OsPackage.OPERATING_SYSTEM_ROOT__CAPABILITY_SUSE_LINUX_LOCAL_USER:
			setCapabilitySuseLinuxLocalUser((SUSELinuxLocalUser) null);
			return;
		case OsPackage.OPERATING_SYSTEM_ROOT__CAPABILITY_SUSE_LINUX_OPERATING_SYSTEM:
			setCapabilitySuseLinuxOperatingSystem((SUSELinuxOperatingSystem) null);
			return;
		case OsPackage.OPERATING_SYSTEM_ROOT__CAPABILITY_UNIX_DIRECTORY:
			setCapabilityUnixDirectory((UnixDirectory) null);
			return;
		case OsPackage.OPERATING_SYSTEM_ROOT__CAPABILITY_UNIX_FILE_SYSTEM:
			setCapabilityUnixFileSystem((UnixFileSystem) null);
			return;
		case OsPackage.OPERATING_SYSTEM_ROOT__CAPABILITY_USER:
			setCapabilityUser((User) null);
			return;
		case OsPackage.OPERATING_SYSTEM_ROOT__CAPABILITY_USER_GROUP:
			setCapabilityUserGroup((UserGroup) null);
			return;
		case OsPackage.OPERATING_SYSTEM_ROOT__CAPABILITY_WINDOWS_DIRECTORY:
			setCapabilityWindowsDirectory((WindowsDirectory) null);
			return;
		case OsPackage.OPERATING_SYSTEM_ROOT__CAPABILITY_WINDOWS_FILE_SYSTEM:
			setCapabilityWindowsFileSystem((WindowsFileSystem) null);
			return;
		case OsPackage.OPERATING_SYSTEM_ROOT__CAPABILITY_WINDOWS_LOCAL_GROUP:
			setCapabilityWindowsLocalGroup((WindowsLocalGroup) null);
			return;
		case OsPackage.OPERATING_SYSTEM_ROOT__CAPABILITY_WINDOWS_LOCAL_SERVICE:
			setCapabilityWindowsLocalService((WindowsLocalService) null);
			return;
		case OsPackage.OPERATING_SYSTEM_ROOT__CAPABILITY_WINDOWS_LOCAL_USER:
			setCapabilityWindowsLocalUser((WindowsLocalUser) null);
			return;
		case OsPackage.OPERATING_SYSTEM_ROOT__CAPABILITY_WINDOWS_OPERATING_SYSTEM:
			setCapabilityWindowsOperatingSystem((WindowsOperatingSystem) null);
			return;
		case OsPackage.OPERATING_SYSTEM_ROOT__UNIT_AIX_LOCAL_GROUP:
			setUnitAixLocalGroup((AIXLocalGroupUnit) null);
			return;
		case OsPackage.OPERATING_SYSTEM_ROOT__UNIT_AIX_LOCAL_SERVICE_UNIT:
			setUnitAixLocalServiceUnit((AIXLocalServiceUnit) null);
			return;
		case OsPackage.OPERATING_SYSTEM_ROOT__UNIT_AIX_LOCAL_USER:
			setUnitAixLocalUser((AIXLocalUserUnit) null);
			return;
		case OsPackage.OPERATING_SYSTEM_ROOT__UNIT_AIX_OPERATING_SYSTEM_UNIT:
			setUnitAixOperatingSystemUnit((AIXOperatingSystemUnit) null);
			return;
		case OsPackage.OPERATING_SYSTEM_ROOT__UNIT_DATA_FILE_UNIT:
			setUnitDataFileUnit((DataFileUnit) null);
			return;
		case OsPackage.OPERATING_SYSTEM_ROOT__UNIT_DIRECTORY_UNIT:
			setUnitDirectoryUnit((DirectoryUnit) null);
			return;
		case OsPackage.OPERATING_SYSTEM_ROOT__UNIT_FILE_SYSTEM_CONTENT_UNIT:
			setUnitFileSystemContentUnit((FileSystemContentUnit) null);
			return;
		case OsPackage.OPERATING_SYSTEM_ROOT__UNIT_FILE_SYSTEM_UNIT:
			setUnitFileSystemUnit((FileSystemUnit) null);
			return;
		case OsPackage.OPERATING_SYSTEM_ROOT__UNIT_LINUX_LOCAL_GROUP:
			setUnitLinuxLocalGroup((LinuxLocalGroupUnit) null);
			return;
		case OsPackage.OPERATING_SYSTEM_ROOT__UNIT_LINUX_LOCAL_SERVICE_UNIT:
			setUnitLinuxLocalServiceUnit((LinuxLocalServiceUnit) null);
			return;
		case OsPackage.OPERATING_SYSTEM_ROOT__UNIT_LINUX_LOCAL_USER:
			setUnitLinuxLocalUser((LinuxLocalUserUnit) null);
			return;
		case OsPackage.OPERATING_SYSTEM_ROOT__UNIT_LINUX_OPERATING_SYSTEM_UNIT:
			setUnitLinuxOperatingSystemUnit((LinuxOperatingSystemUnit) null);
			return;
		case OsPackage.OPERATING_SYSTEM_ROOT__UNIT_LOCAL_FILE_SYSTEM_UNIT:
			setUnitLocalFileSystemUnit((LocalFileSystemUnit) null);
			return;
		case OsPackage.OPERATING_SYSTEM_ROOT__UNIT_NFS_FILE_SYSTEM_UNIT:
			setUnitNFSFileSystemUnit((NFSFileSystemUnit) null);
			return;
		case OsPackage.OPERATING_SYSTEM_ROOT__UNIT_OPEN_VMS_FILE_SYSTEM_UNIT:
			setUnitOpenVmsFileSystemUnit((OpenVmsFileSystemUnit) null);
			return;
		case OsPackage.OPERATING_SYSTEM_ROOT__UNIT_OPERATING_SYSTEM_UNIT:
			setUnitOperatingSystemUnit((OperatingSystemUnit) null);
			return;
		case OsPackage.OPERATING_SYSTEM_ROOT__UNIT_PORT_CONFIG_UNIT:
			setUnitPortConfigUnit((PortConfigUnit) null);
			return;
		case OsPackage.OPERATING_SYSTEM_ROOT__UNIT_REMOTE_FILE_SYSTEM_UNIT:
			setUnitRemoteFileSystemUnit((RemoteFileSystemUnit) null);
			return;
		case OsPackage.OPERATING_SYSTEM_ROOT__UNIT_SMB_FILE_SYSTEM_UNIT:
			setUnitSMBFileSystemUnit((SMBFileSystemUnit) null);
			return;
		case OsPackage.OPERATING_SYSTEM_ROOT__UNIT_SOLARIS_FILE_SYSTEM_UNIT:
			setUnitSolarisFileSystemUnit((SolarisFileSystemUnit) null);
			return;
		case OsPackage.OPERATING_SYSTEM_ROOT__UNIT_UNIX_FILE_SYSTEM_UNIT:
			setUnitUnixFileSystemUnit((UnixFileSystemUnit) null);
			return;
		case OsPackage.OPERATING_SYSTEM_ROOT__UNIT_USER:
			setUnitUser((UserUnit) null);
			return;
		case OsPackage.OPERATING_SYSTEM_ROOT__UNIT_USER_GROUP:
			setUnitUserGroup((UserGroupUnit) null);
			return;
		case OsPackage.OPERATING_SYSTEM_ROOT__UNIT_WINDOWS_FILE_SYSTEM_UNIT:
			setUnitWindowsFileSystemUnit((WindowsFileSystemUnit) null);
			return;
		case OsPackage.OPERATING_SYSTEM_ROOT__UNIT_WINDOWS_LOCAL_GROUP:
			setUnitWindowsLocalGroup((WindowsLocalGroupUnit) null);
			return;
		case OsPackage.OPERATING_SYSTEM_ROOT__UNIT_WINDOWS_LOCAL_SERVICE_UNIT:
			setUnitWindowsLocalServiceUnit((WindowsLocalServiceUnit) null);
			return;
		case OsPackage.OPERATING_SYSTEM_ROOT__UNIT_WINDOWS_LOCAL_USER:
			setUnitWindowsLocalUser((WindowsLocalUserUnit) null);
			return;
		case OsPackage.OPERATING_SYSTEM_ROOT__UNIT_WINDOWS_OPERATING_SYSTEM_UNIT:
			setUnitWindowsOperatingSystemUnit((WindowsOperatingSystemUnit) null);
			return;
		}
		super.eUnset(featureID);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public boolean eIsSet(int featureID) {
		switch (featureID)
		{
		case OsPackage.OPERATING_SYSTEM_ROOT__MIXED:
			return mixed != null && !mixed.isEmpty();
		case OsPackage.OPERATING_SYSTEM_ROOT__XMLNS_PREFIX_MAP:
			return xMLNSPrefixMap != null && !xMLNSPrefixMap.isEmpty();
		case OsPackage.OPERATING_SYSTEM_ROOT__XSI_SCHEMA_LOCATION:
			return xSISchemaLocation != null && !xSISchemaLocation.isEmpty();
		case OsPackage.OPERATING_SYSTEM_ROOT__CAPABILITY_AIX_LOCAL_GROUP:
			return getCapabilityAixLocalGroup() != null;
		case OsPackage.OPERATING_SYSTEM_ROOT__CAPABILITY_AIX_LOCAL_SERVICE:
			return getCapabilityAixLocalService() != null;
		case OsPackage.OPERATING_SYSTEM_ROOT__CAPABILITY_AIX_LOCAL_USER:
			return getCapabilityAixLocalUser() != null;
		case OsPackage.OPERATING_SYSTEM_ROOT__CAPABILITY_AIX_OPERATING_SYSTEM:
			return getCapabilityAixOperatingSystem() != null;
		case OsPackage.OPERATING_SYSTEM_ROOT__CAPABILITY_DATA_FILE:
			return getCapabilityDataFile() != null;
		case OsPackage.OPERATING_SYSTEM_ROOT__CAPABILITY_DIRECTORY:
			return getCapabilityDirectory() != null;
		case OsPackage.OPERATING_SYSTEM_ROOT__CAPABILITY_FILE_SYSTEM:
			return getCapabilityFileSystem() != null;
		case OsPackage.OPERATING_SYSTEM_ROOT__CAPABILITY_FILE_SYSTEM_CONTENT:
			return getCapabilityFileSystemContent() != null;
		case OsPackage.OPERATING_SYSTEM_ROOT__CAPABILITY_LINUX_LOCAL_GROUP:
			return getCapabilityLinuxLocalGroup() != null;
		case OsPackage.OPERATING_SYSTEM_ROOT__CAPABILITY_LINUX_LOCAL_SERVICE:
			return getCapabilityLinuxLocalService() != null;
		case OsPackage.OPERATING_SYSTEM_ROOT__CAPABILITY_LINUX_LOCAL_USER:
			return getCapabilityLinuxLocalUser() != null;
		case OsPackage.OPERATING_SYSTEM_ROOT__CAPABILITY_LINUX_OPERATING_SYSTEM:
			return getCapabilityLinuxOperatingSystem() != null;
		case OsPackage.OPERATING_SYSTEM_ROOT__CAPABILITY_LOCAL_FILE_SYSTEM:
			return getCapabilityLocalFileSystem() != null;
		case OsPackage.OPERATING_SYSTEM_ROOT__CAPABILITY_NFS_FILE_SYSTEM:
			return getCapabilityNFSFileSystem() != null;
		case OsPackage.OPERATING_SYSTEM_ROOT__CAPABILITY_OPEN_VMS_FILE_SYSTEM:
			return getCapabilityOpenVmsFileSystem() != null;
		case OsPackage.OPERATING_SYSTEM_ROOT__CAPABILITY_OPERATING_SYSTEM:
			return getCapabilityOperatingSystem() != null;
		case OsPackage.OPERATING_SYSTEM_ROOT__CAPABILITY_PORT:
			return getCapabilityPort() != null;
		case OsPackage.OPERATING_SYSTEM_ROOT__CAPABILITY_PORT_CONSUMER:
			return getCapabilityPortConsumer() != null;
		case OsPackage.OPERATING_SYSTEM_ROOT__CAPABILITY_REDHAT_LINUX_LOCAL_GROUP:
			return getCapabilityRedhatLinuxLocalGroup() != null;
		case OsPackage.OPERATING_SYSTEM_ROOT__CAPABILITY_REDHAT_LINUX_LOCAL_SERVICE:
			return getCapabilityRedhatLinuxLocalService() != null;
		case OsPackage.OPERATING_SYSTEM_ROOT__CAPABILITY_REDHAT_LINUX_LOCAL_USER:
			return getCapabilityRedhatLinuxLocalUser() != null;
		case OsPackage.OPERATING_SYSTEM_ROOT__CAPABILITY_REDHAT_LINUX_OPERATING_SYSTEM:
			return getCapabilityRedhatLinuxOperatingSystem() != null;
		case OsPackage.OPERATING_SYSTEM_ROOT__CAPABILITY_REMOTE_FILE_SYSTEM:
			return getCapabilityRemoteFileSystem() != null;
		case OsPackage.OPERATING_SYSTEM_ROOT__CAPABILITY_SMB_FILE_SYSTEM:
			return getCapabilitySMBFileSystem() != null;
		case OsPackage.OPERATING_SYSTEM_ROOT__CAPABILITY_SOLARIS_FILE_SYSTEM:
			return getCapabilitySolarisFileSystem() != null;
		case OsPackage.OPERATING_SYSTEM_ROOT__CAPABILITY_SUSE_LINUX_LOCAL_GROUP:
			return getCapabilitySuseLinuxLocalGroup() != null;
		case OsPackage.OPERATING_SYSTEM_ROOT__CAPABILITY_SUSE_LINUX_LOCAL_SERVICE:
			return getCapabilitySuseLinuxLocalService() != null;
		case OsPackage.OPERATING_SYSTEM_ROOT__CAPABILITY_SUSE_LINUX_LOCAL_USER:
			return getCapabilitySuseLinuxLocalUser() != null;
		case OsPackage.OPERATING_SYSTEM_ROOT__CAPABILITY_SUSE_LINUX_OPERATING_SYSTEM:
			return getCapabilitySuseLinuxOperatingSystem() != null;
		case OsPackage.OPERATING_SYSTEM_ROOT__CAPABILITY_UNIX_DIRECTORY:
			return getCapabilityUnixDirectory() != null;
		case OsPackage.OPERATING_SYSTEM_ROOT__CAPABILITY_UNIX_FILE_SYSTEM:
			return getCapabilityUnixFileSystem() != null;
		case OsPackage.OPERATING_SYSTEM_ROOT__CAPABILITY_USER:
			return getCapabilityUser() != null;
		case OsPackage.OPERATING_SYSTEM_ROOT__CAPABILITY_USER_GROUP:
			return getCapabilityUserGroup() != null;
		case OsPackage.OPERATING_SYSTEM_ROOT__CAPABILITY_WINDOWS_DIRECTORY:
			return getCapabilityWindowsDirectory() != null;
		case OsPackage.OPERATING_SYSTEM_ROOT__CAPABILITY_WINDOWS_FILE_SYSTEM:
			return getCapabilityWindowsFileSystem() != null;
		case OsPackage.OPERATING_SYSTEM_ROOT__CAPABILITY_WINDOWS_LOCAL_GROUP:
			return getCapabilityWindowsLocalGroup() != null;
		case OsPackage.OPERATING_SYSTEM_ROOT__CAPABILITY_WINDOWS_LOCAL_SERVICE:
			return getCapabilityWindowsLocalService() != null;
		case OsPackage.OPERATING_SYSTEM_ROOT__CAPABILITY_WINDOWS_LOCAL_USER:
			return getCapabilityWindowsLocalUser() != null;
		case OsPackage.OPERATING_SYSTEM_ROOT__CAPABILITY_WINDOWS_OPERATING_SYSTEM:
			return getCapabilityWindowsOperatingSystem() != null;
		case OsPackage.OPERATING_SYSTEM_ROOT__UNIT_AIX_LOCAL_GROUP:
			return getUnitAixLocalGroup() != null;
		case OsPackage.OPERATING_SYSTEM_ROOT__UNIT_AIX_LOCAL_SERVICE_UNIT:
			return getUnitAixLocalServiceUnit() != null;
		case OsPackage.OPERATING_SYSTEM_ROOT__UNIT_AIX_LOCAL_USER:
			return getUnitAixLocalUser() != null;
		case OsPackage.OPERATING_SYSTEM_ROOT__UNIT_AIX_OPERATING_SYSTEM_UNIT:
			return getUnitAixOperatingSystemUnit() != null;
		case OsPackage.OPERATING_SYSTEM_ROOT__UNIT_DATA_FILE_UNIT:
			return getUnitDataFileUnit() != null;
		case OsPackage.OPERATING_SYSTEM_ROOT__UNIT_DIRECTORY_UNIT:
			return getUnitDirectoryUnit() != null;
		case OsPackage.OPERATING_SYSTEM_ROOT__UNIT_FILE_SYSTEM_CONTENT_UNIT:
			return getUnitFileSystemContentUnit() != null;
		case OsPackage.OPERATING_SYSTEM_ROOT__UNIT_FILE_SYSTEM_UNIT:
			return getUnitFileSystemUnit() != null;
		case OsPackage.OPERATING_SYSTEM_ROOT__UNIT_LINUX_LOCAL_GROUP:
			return getUnitLinuxLocalGroup() != null;
		case OsPackage.OPERATING_SYSTEM_ROOT__UNIT_LINUX_LOCAL_SERVICE_UNIT:
			return getUnitLinuxLocalServiceUnit() != null;
		case OsPackage.OPERATING_SYSTEM_ROOT__UNIT_LINUX_LOCAL_USER:
			return getUnitLinuxLocalUser() != null;
		case OsPackage.OPERATING_SYSTEM_ROOT__UNIT_LINUX_OPERATING_SYSTEM_UNIT:
			return getUnitLinuxOperatingSystemUnit() != null;
		case OsPackage.OPERATING_SYSTEM_ROOT__UNIT_LOCAL_FILE_SYSTEM_UNIT:
			return getUnitLocalFileSystemUnit() != null;
		case OsPackage.OPERATING_SYSTEM_ROOT__UNIT_NFS_FILE_SYSTEM_UNIT:
			return getUnitNFSFileSystemUnit() != null;
		case OsPackage.OPERATING_SYSTEM_ROOT__UNIT_OPEN_VMS_FILE_SYSTEM_UNIT:
			return getUnitOpenVmsFileSystemUnit() != null;
		case OsPackage.OPERATING_SYSTEM_ROOT__UNIT_OPERATING_SYSTEM_UNIT:
			return getUnitOperatingSystemUnit() != null;
		case OsPackage.OPERATING_SYSTEM_ROOT__UNIT_PORT_CONFIG_UNIT:
			return getUnitPortConfigUnit() != null;
		case OsPackage.OPERATING_SYSTEM_ROOT__UNIT_REMOTE_FILE_SYSTEM_UNIT:
			return getUnitRemoteFileSystemUnit() != null;
		case OsPackage.OPERATING_SYSTEM_ROOT__UNIT_SMB_FILE_SYSTEM_UNIT:
			return getUnitSMBFileSystemUnit() != null;
		case OsPackage.OPERATING_SYSTEM_ROOT__UNIT_SOLARIS_FILE_SYSTEM_UNIT:
			return getUnitSolarisFileSystemUnit() != null;
		case OsPackage.OPERATING_SYSTEM_ROOT__UNIT_UNIX_FILE_SYSTEM_UNIT:
			return getUnitUnixFileSystemUnit() != null;
		case OsPackage.OPERATING_SYSTEM_ROOT__UNIT_USER:
			return getUnitUser() != null;
		case OsPackage.OPERATING_SYSTEM_ROOT__UNIT_USER_GROUP:
			return getUnitUserGroup() != null;
		case OsPackage.OPERATING_SYSTEM_ROOT__UNIT_WINDOWS_FILE_SYSTEM_UNIT:
			return getUnitWindowsFileSystemUnit() != null;
		case OsPackage.OPERATING_SYSTEM_ROOT__UNIT_WINDOWS_LOCAL_GROUP:
			return getUnitWindowsLocalGroup() != null;
		case OsPackage.OPERATING_SYSTEM_ROOT__UNIT_WINDOWS_LOCAL_SERVICE_UNIT:
			return getUnitWindowsLocalServiceUnit() != null;
		case OsPackage.OPERATING_SYSTEM_ROOT__UNIT_WINDOWS_LOCAL_USER:
			return getUnitWindowsLocalUser() != null;
		case OsPackage.OPERATING_SYSTEM_ROOT__UNIT_WINDOWS_OPERATING_SYSTEM_UNIT:
			return getUnitWindowsOperatingSystemUnit() != null;
		}
		return super.eIsSet(featureID);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public String toString() {
		if (eIsProxy())
			return super.toString();

		StringBuffer result = new StringBuffer(super.toString());
		result.append(" (mixed: "); //$NON-NLS-1$
		result.append(mixed);
		result.append(')');
		return result.toString();
	}

} //OperatingSystemRootImpl
