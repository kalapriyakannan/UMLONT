/*******************************************************************************
 * Copyright (c) 2003, 2007 IBM Corporation Licensed Material - Property of IBM. All rights reserved.
 *  
 * US Government Users Restricted Rights - Use, duplication or disclosure v1.0 restricted by GSA ADP
 * Schedule Contract with IBM Corp.
 * 
 * Contributors: IBM Corporation - initial API and implementation
 *******************************************************************************/
package com.ibm.ccl.soa.deploy.os.impl;

import java.math.BigInteger;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EDataType;
import org.eclipse.emf.ecore.EEnum;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EcorePackage;
import org.eclipse.emf.ecore.impl.EPackageImpl;
import org.eclipse.emf.ecore.xml.type.XMLTypePackage;

import com.ibm.ccl.soa.deploy.core.CorePackage;
import com.ibm.ccl.soa.deploy.os.AIXAuthMethodType;
import com.ibm.ccl.soa.deploy.os.AIXDesktopType;
import com.ibm.ccl.soa.deploy.os.AIXLocalGroup;
import com.ibm.ccl.soa.deploy.os.AIXLocalGroupUnit;
import com.ibm.ccl.soa.deploy.os.AIXLocalService;
import com.ibm.ccl.soa.deploy.os.AIXLocalServiceUnit;
import com.ibm.ccl.soa.deploy.os.AIXLocalUser;
import com.ibm.ccl.soa.deploy.os.AIXLocalUserUnit;
import com.ibm.ccl.soa.deploy.os.AIXOperatingSystem;
import com.ibm.ccl.soa.deploy.os.AIXOperatingSystemUnit;
import com.ibm.ccl.soa.deploy.os.AIXUserRegisteringMethodType;
import com.ibm.ccl.soa.deploy.os.ArchitectureBusType;
import com.ibm.ccl.soa.deploy.os.DataFile;
import com.ibm.ccl.soa.deploy.os.DataFileUnit;
import com.ibm.ccl.soa.deploy.os.DefaultWindowsUserGroups;
import com.ibm.ccl.soa.deploy.os.Directory;
import com.ibm.ccl.soa.deploy.os.DirectoryUnit;
import com.ibm.ccl.soa.deploy.os.EncryptionLevelType;
import com.ibm.ccl.soa.deploy.os.FileSystem;
import com.ibm.ccl.soa.deploy.os.FileSystemContent;
import com.ibm.ccl.soa.deploy.os.FileSystemContentUnit;
import com.ibm.ccl.soa.deploy.os.FileSystemUnit;
import com.ibm.ccl.soa.deploy.os.KernelWidthType;
import com.ibm.ccl.soa.deploy.os.LinuxLocalGroup;
import com.ibm.ccl.soa.deploy.os.LinuxLocalGroupUnit;
import com.ibm.ccl.soa.deploy.os.LinuxLocalService;
import com.ibm.ccl.soa.deploy.os.LinuxLocalServiceUnit;
import com.ibm.ccl.soa.deploy.os.LinuxLocalUser;
import com.ibm.ccl.soa.deploy.os.LinuxLocalUserUnit;
import com.ibm.ccl.soa.deploy.os.LinuxOperatingSystem;
import com.ibm.ccl.soa.deploy.os.LinuxOperatingSystemUnit;
import com.ibm.ccl.soa.deploy.os.LinuxServiceStartupTypeType;
import com.ibm.ccl.soa.deploy.os.LinuxServiceStatusType;
import com.ibm.ccl.soa.deploy.os.LocalFileSystem;
import com.ibm.ccl.soa.deploy.os.LocalFileSystemUnit;
import com.ibm.ccl.soa.deploy.os.NFSFileSystem;
import com.ibm.ccl.soa.deploy.os.NFSFileSystemUnit;
import com.ibm.ccl.soa.deploy.os.OpenVmsFileSystem;
import com.ibm.ccl.soa.deploy.os.OpenVmsFileSystemUnit;
import com.ibm.ccl.soa.deploy.os.OperatingSystem;
import com.ibm.ccl.soa.deploy.os.OperatingSystemRoot;
import com.ibm.ccl.soa.deploy.os.OperatingSystemType;
import com.ibm.ccl.soa.deploy.os.OperatingSystemUnit;
import com.ibm.ccl.soa.deploy.os.OsFactory;
import com.ibm.ccl.soa.deploy.os.OsPackage;
import com.ibm.ccl.soa.deploy.os.Port;
import com.ibm.ccl.soa.deploy.os.PortConfigUnit;
import com.ibm.ccl.soa.deploy.os.PortConsumer;
import com.ibm.ccl.soa.deploy.os.RedhatDesktopType;
import com.ibm.ccl.soa.deploy.os.RedhatLinuxBootLoaderType;
import com.ibm.ccl.soa.deploy.os.RedhatLinuxLocalGroup;
import com.ibm.ccl.soa.deploy.os.RedhatLinuxLocalService;
import com.ibm.ccl.soa.deploy.os.RedhatLinuxLocalUser;
import com.ibm.ccl.soa.deploy.os.RedhatLinuxOperatingSystem;
import com.ibm.ccl.soa.deploy.os.RedhatLinuxProductTypeType;
import com.ibm.ccl.soa.deploy.os.RedhatLinuxServiceStartupTypeType;
import com.ibm.ccl.soa.deploy.os.RedhatLinuxServiceStatusType;
import com.ibm.ccl.soa.deploy.os.RemoteFileSystem;
import com.ibm.ccl.soa.deploy.os.RemoteFileSystemUnit;
import com.ibm.ccl.soa.deploy.os.SELinuxStateType;
import com.ibm.ccl.soa.deploy.os.SMBFileSystem;
import com.ibm.ccl.soa.deploy.os.SMBFileSystemUnit;
import com.ibm.ccl.soa.deploy.os.SUSEDesktopType;
import com.ibm.ccl.soa.deploy.os.SUSELinuxBootLoaderType;
import com.ibm.ccl.soa.deploy.os.SUSELinuxLocalGroup;
import com.ibm.ccl.soa.deploy.os.SUSELinuxLocalService;
import com.ibm.ccl.soa.deploy.os.SUSELinuxLocalUser;
import com.ibm.ccl.soa.deploy.os.SUSELinuxOperatingSystem;
import com.ibm.ccl.soa.deploy.os.SUSELinuxServiceStartupTypeType;
import com.ibm.ccl.soa.deploy.os.SUSELinuxServiceStatusType;
import com.ibm.ccl.soa.deploy.os.SolarisFileSystem;
import com.ibm.ccl.soa.deploy.os.SolarisFileSystemUnit;
import com.ibm.ccl.soa.deploy.os.TransportLayerProtocolType;
import com.ibm.ccl.soa.deploy.os.UnixDirectory;
import com.ibm.ccl.soa.deploy.os.UnixFileSystem;
import com.ibm.ccl.soa.deploy.os.UnixFileSystemUnit;
import com.ibm.ccl.soa.deploy.os.User;
import com.ibm.ccl.soa.deploy.os.UserGroup;
import com.ibm.ccl.soa.deploy.os.UserGroupUnit;
import com.ibm.ccl.soa.deploy.os.UserUnit;
import com.ibm.ccl.soa.deploy.os.WindowsDirectory;
import com.ibm.ccl.soa.deploy.os.WindowsDirectoryType;
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
import com.ibm.ccl.soa.deploy.os.WindowsProductTypeType;
import com.ibm.ccl.soa.deploy.os.WindowsServiceErrorControlType;
import com.ibm.ccl.soa.deploy.os.WindowsServiceStartupType;
import com.ibm.ccl.soa.deploy.os.WindowsServiceStatusType;

/**
 * <!-- begin-user-doc --> An implementation of the model <b>Package</b>. <!-- end-user-doc -->
 * @generated
 */
public class OsPackageImpl extends EPackageImpl implements OsPackage {
	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public static final String copyright = "Copyright (c) 2005, 2006 IBM Corporation. Licensed Material - Property of IBM. All rights reserved."; //$NON-NLS-1$

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	private EClass aixLocalGroupEClass = null;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	private EClass aixLocalGroupUnitEClass = null;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	private EClass aixLocalServiceEClass = null;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	private EClass aixLocalServiceUnitEClass = null;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	private EClass aixLocalUserEClass = null;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	private EClass aixLocalUserUnitEClass = null;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	private EClass aixOperatingSystemEClass = null;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	private EClass aixOperatingSystemUnitEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass dataFileEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass dataFileUnitEClass = null;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	private EClass directoryEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass directoryUnitEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass fileSystemEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass fileSystemContentEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass fileSystemContentUnitEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass fileSystemUnitEClass = null;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	private EClass linuxLocalGroupEClass = null;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	private EClass linuxLocalGroupUnitEClass = null;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	private EClass linuxLocalServiceEClass = null;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	private EClass linuxLocalServiceUnitEClass = null;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	private EClass linuxLocalUserEClass = null;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	private EClass linuxLocalUserUnitEClass = null;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	private EClass linuxOperatingSystemEClass = null;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	private EClass linuxOperatingSystemUnitEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass localFileSystemEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass localFileSystemUnitEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass nfsFileSystemEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass nfsFileSystemUnitEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass openVmsFileSystemEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass openVmsFileSystemUnitEClass = null;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	private EClass operatingSystemEClass = null;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	private EClass operatingSystemRootEClass = null;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	private EClass operatingSystemUnitEClass = null;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	private EClass portEClass = null;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	private EClass portConfigUnitEClass = null;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	private EClass portConsumerEClass = null;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	private EClass redhatLinuxLocalGroupEClass = null;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	private EClass redhatLinuxLocalServiceEClass = null;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	private EClass redhatLinuxLocalUserEClass = null;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	private EClass redhatLinuxOperatingSystemEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass remoteFileSystemEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass remoteFileSystemUnitEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass smbFileSystemEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass smbFileSystemUnitEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass solarisFileSystemEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass solarisFileSystemUnitEClass = null;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	private EClass suseLinuxLocalGroupEClass = null;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	private EClass suseLinuxLocalServiceEClass = null;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	private EClass suseLinuxLocalUserEClass = null;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	private EClass suseLinuxOperatingSystemEClass = null;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	private EClass unixDirectoryEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass unixFileSystemEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass unixFileSystemUnitEClass = null;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	private EClass userEClass = null;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	private EClass userGroupEClass = null;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	private EClass userGroupUnitEClass = null;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	private EClass userUnitEClass = null;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	private EClass windowsDirectoryEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass windowsFileSystemEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass windowsFileSystemUnitEClass = null;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	private EClass windowsLocalGroupEClass = null;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	private EClass windowsLocalGroupUnitEClass = null;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	private EClass windowsLocalServiceEClass = null;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	private EClass windowsLocalServiceUnitEClass = null;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	private EClass windowsLocalUserEClass = null;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	private EClass windowsLocalUserUnitEClass = null;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	private EClass windowsOperatingSystemEClass = null;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	private EClass windowsOperatingSystemUnitEClass = null;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	private EEnum aixAuthMethodTypeEEnum = null;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	private EEnum aixDesktopTypeEEnum = null;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	private EEnum aixUserRegisteringMethodTypeEEnum = null;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	private EEnum architectureBusTypeEEnum = null;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	private EEnum defaultWindowsUserGroupsEEnum = null;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	private EEnum encryptionLevelTypeEEnum = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EEnum kernelWidthTypeEEnum = null;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	private EEnum linuxServiceStartupTypeTypeEEnum = null;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	private EEnum linuxServiceStatusTypeEEnum = null;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	private EEnum operatingSystemTypeEEnum = null;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	private EEnum redhatDesktopTypeEEnum = null;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	private EEnum redhatLinuxBootLoaderTypeEEnum = null;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	private EEnum redhatLinuxProductTypeTypeEEnum = null;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	private EEnum redhatLinuxServiceStartupTypeTypeEEnum = null;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	private EEnum redhatLinuxServiceStatusTypeEEnum = null;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	private EEnum seLinuxStateTypeEEnum = null;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	private EEnum suseDesktopTypeEEnum = null;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	private EEnum suseLinuxBootLoaderTypeEEnum = null;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	private EEnum suseLinuxServiceStartupTypeTypeEEnum = null;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	private EEnum suseLinuxServiceStatusTypeEEnum = null;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	private EEnum transportLayerProtocolTypeEEnum = null;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	private EEnum windowsDirectoryTypeEEnum = null;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	private EEnum windowsProductTypeTypeEEnum = null;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	private EEnum windowsServiceErrorControlTypeEEnum = null;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	private EEnum windowsServiceStartupTypeEEnum = null;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	private EEnum windowsServiceStatusTypeEEnum = null;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	private EDataType aixAuthMethodTypeObjectEDataType = null;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	private EDataType aixDesktopTypeObjectEDataType = null;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	private EDataType aixUserRegisteringMethodTypeObjectEDataType = null;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	private EDataType architectureBusTypeObjectEDataType = null;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	private EDataType defaultWindowsUserGroupsObjectEDataType = null;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	private EDataType encryptionLevelTypeObjectEDataType = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EDataType kernelWidthTypeObjectEDataType = null;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	private EDataType linuxServiceStartupTypeTypeObjectEDataType = null;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	private EDataType linuxServiceStatusTypeObjectEDataType = null;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	private EDataType operatingSystemTypeObjectEDataType = null;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	private EDataType redhatDesktopTypeObjectEDataType = null;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	private EDataType redhatLinuxBootLoaderTypeObjectEDataType = null;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	private EDataType redhatLinuxProductTypeTypeObjectEDataType = null;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	private EDataType redhatLinuxServiceStartupTypeTypeObjectEDataType = null;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	private EDataType redhatLinuxServiceStatusTypeObjectEDataType = null;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	private EDataType seLinuxStateTypeObjectEDataType = null;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	private EDataType suseDesktopTypeObjectEDataType = null;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	private EDataType suseLinuxBootLoaderTypeObjectEDataType = null;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	private EDataType suseLinuxServiceStartupTypeTypeObjectEDataType = null;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	private EDataType suseLinuxServiceStatusTypeObjectEDataType = null;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	private EDataType tcpPortTypeEDataType = null;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	private EDataType transportLayerProtocolTypeObjectEDataType = null;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	private EDataType udpPortTypeEDataType = null;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	private EDataType windowsDirectoryTypeObjectEDataType = null;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	private EDataType windowsProductTypeTypeObjectEDataType = null;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	private EDataType windowsServiceErrorControlTypeObjectEDataType = null;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	private EDataType windowsServiceStartupTypeObjectEDataType = null;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	private EDataType windowsServiceStatusTypeObjectEDataType = null;

	/**
	 * Creates an instance of the model <b>Package</b>, registered with
	 * {@link org.eclipse.emf.ecore.EPackage.Registry EPackage.Registry} by the package
	 * package URI value.
	 * <p>Note: the correct way to create the package is via the static
	 * factory method {@link #init init()}, which also performs
	 * initialization of the package, or returns the registered package,
	 * if one already exists.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see org.eclipse.emf.ecore.EPackage.Registry
	 * @see com.ibm.ccl.soa.deploy.os.OsPackage#eNS_URI
	 * @see #init()
	 * @generated
	 */
	private OsPackageImpl() {
		super(eNS_URI, OsFactory.eINSTANCE);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	private static boolean isInited = false;

	/**
	 * Creates, registers, and initializes the <b>Package</b> for this
	 * model, and for any others upon which it depends.  Simple
	 * dependencies are satisfied by calling this method on all
	 * dependent packages before doing anything else.  This method drives
	 * initialization for interdependent packages directly, in parallel
	 * with this package, itself.
	 * <p>Of this package and its interdependencies, all packages which
	 * have not yet been registered by their URI values are first created
	 * and registered.  The packages are then initialized in two steps:
	 * meta-model objects for all of the packages are created before any
	 * are initialized, since one package's meta-model objects may refer to
	 * those of another.
	 * <p>Invocation of this method will not affect any packages that have
	 * already been initialized.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see #eNS_URI
	 * @see #createPackageContents()
	 * @see #initializePackageContents()
	 * @generated
	 */
	public static OsPackage init() {
		if (isInited)
			return (OsPackage) EPackage.Registry.INSTANCE.getEPackage(OsPackage.eNS_URI);

		// Obtain or create and register package
		OsPackageImpl theOsPackage = (OsPackageImpl) (EPackage.Registry.INSTANCE.getEPackage(eNS_URI) instanceof OsPackageImpl ? EPackage.Registry.INSTANCE
				.getEPackage(eNS_URI)
				: new OsPackageImpl());

		isInited = true;

		// Initialize simple dependencies
		CorePackage.eINSTANCE.eClass();
		EcorePackage.eINSTANCE.eClass();
		XMLTypePackage.eINSTANCE.eClass();

		// Create package meta-data objects
		theOsPackage.createPackageContents();

		// Initialize created meta-data
		theOsPackage.initializePackageContents();

		// Mark meta-data to indicate it can't be changed
		theOsPackage.freeze();

		return theOsPackage;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getAIXLocalGroup() {
		return aixLocalGroupEClass;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getAIXLocalGroup_GroupDescription() {
		return (EAttribute) aixLocalGroupEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getAIXLocalGroup_GroupSid() {
		return (EAttribute) aixLocalGroupEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getAIXLocalGroupUnit() {
		return aixLocalGroupUnitEClass;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getAIXLocalService() {
		return aixLocalServiceEClass;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getAIXLocalService_ActionType() {
		return (EAttribute) aixLocalServiceEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getAIXLocalService_ExecutablePath() {
		return (EAttribute) aixLocalServiceEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getAIXLocalService_ServiceDescription() {
		return (EAttribute) aixLocalServiceEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getAIXLocalService_StartupRunLevelEight() {
		return (EAttribute) aixLocalServiceEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getAIXLocalService_StartupRunLevelFive() {
		return (EAttribute) aixLocalServiceEClass.getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getAIXLocalService_StartupRunLevelFour() {
		return (EAttribute) aixLocalServiceEClass.getEStructuralFeatures().get(5);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getAIXLocalService_StartupRunLevelNine() {
		return (EAttribute) aixLocalServiceEClass.getEStructuralFeatures().get(6);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getAIXLocalService_StartupRunLevelOne() {
		return (EAttribute) aixLocalServiceEClass.getEStructuralFeatures().get(7);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getAIXLocalService_StartupRunLevelSeven() {
		return (EAttribute) aixLocalServiceEClass.getEStructuralFeatures().get(8);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getAIXLocalService_StartupRunLevelSix() {
		return (EAttribute) aixLocalServiceEClass.getEStructuralFeatures().get(9);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getAIXLocalService_StartupRunLevelThree() {
		return (EAttribute) aixLocalServiceEClass.getEStructuralFeatures().get(10);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getAIXLocalService_StartupRunLevelTwo() {
		return (EAttribute) aixLocalServiceEClass.getEStructuralFeatures().get(11);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getAIXLocalService_StartupRunLevelZero() {
		return (EAttribute) aixLocalServiceEClass.getEStructuralFeatures().get(12);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getAIXLocalServiceUnit() {
		return aixLocalServiceUnitEClass;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getAIXLocalUser() {
		return aixLocalUserEClass;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getAIXLocalUser_AccountDescription() {
		return (EAttribute) aixLocalUserEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getAIXLocalUser_AccountDisabled() {
		return (EAttribute) aixLocalUserEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getAIXLocalUser_AccountExpirationTime() {
		return (EAttribute) aixLocalUserEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getAIXLocalUser_ChangePasswordNextLogon() {
		return (EAttribute) aixLocalUserEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getAIXLocalUser_FullName() {
		return (EAttribute) aixLocalUserEClass.getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getAIXLocalUser_HomeDir() {
		return (EAttribute) aixLocalUserEClass.getEStructuralFeatures().get(5);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getAIXLocalUser_IsAdmin() {
		return (EAttribute) aixLocalUserEClass.getEStructuralFeatures().get(6);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getAIXLocalUser_LoginPermitted() {
		return (EAttribute) aixLocalUserEClass.getEStructuralFeatures().get(7);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getAIXLocalUser_LoginRetries() {
		return (EAttribute) aixLocalUserEClass.getEStructuralFeatures().get(8);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getAIXLocalUser_LoginTimes() {
		return (EAttribute) aixLocalUserEClass.getEStructuralFeatures().get(9);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getAIXLocalUser_MaxCharRepeats() {
		return (EAttribute) aixLocalUserEClass.getEStructuralFeatures().get(10);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getAIXLocalUser_MaxPasswordAgeInWeeks() {
		return (EAttribute) aixLocalUserEClass.getEStructuralFeatures().get(11);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getAIXLocalUser_MaxPasswordValidWeeks() {
		return (EAttribute) aixLocalUserEClass.getEStructuralFeatures().get(12);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getAIXLocalUser_MinAlphaCharsInPassword() {
		return (EAttribute) aixLocalUserEClass.getEStructuralFeatures().get(13);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getAIXLocalUser_MinDiffChars() {
		return (EAttribute) aixLocalUserEClass.getEStructuralFeatures().get(14);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getAIXLocalUser_MinOtherCharsInPassword() {
		return (EAttribute) aixLocalUserEClass.getEStructuralFeatures().get(15);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getAIXLocalUser_MinPasswordAgeInWeeks() {
		return (EAttribute) aixLocalUserEClass.getEStructuralFeatures().get(16);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getAIXLocalUser_MinPasswordLength() {
		return (EAttribute) aixLocalUserEClass.getEStructuralFeatures().get(17);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getAIXLocalUser_NotReusableNumberOfPasswords() {
		return (EAttribute) aixLocalUserEClass.getEStructuralFeatures().get(18);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getAIXLocalUser_PassReuseNotAllowedInWeeks() {
		return (EAttribute) aixLocalUserEClass.getEStructuralFeatures().get(19);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getAIXLocalUser_PasswordChangeWarnTime() {
		return (EAttribute) aixLocalUserEClass.getEStructuralFeatures().get(20);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getAIXLocalUser_PasswordNeverExpires() {
		return (EAttribute) aixLocalUserEClass.getEStructuralFeatures().get(21);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getAIXLocalUser_PrimaryAuthMethod() {
		return (EAttribute) aixLocalUserEClass.getEStructuralFeatures().get(22);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getAIXLocalUser_RemoteLoginIsAllowed() {
		return (EAttribute) aixLocalUserEClass.getEStructuralFeatures().get(23);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getAIXLocalUser_SecondaryAuthMethod() {
		return (EAttribute) aixLocalUserEClass.getEStructuralFeatures().get(24);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getAIXLocalUser_Shell() {
		return (EAttribute) aixLocalUserEClass.getEStructuralFeatures().get(25);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getAIXLocalUser_SuGroupsAllowed() {
		return (EAttribute) aixLocalUserEClass.getEStructuralFeatures().get(26);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getAIXLocalUser_SuIsAllowed() {
		return (EAttribute) aixLocalUserEClass.getEStructuralFeatures().get(27);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getAIXLocalUser_TimeLastLogin() {
		return (EAttribute) aixLocalUserEClass.getEStructuralFeatures().get(28);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getAIXLocalUser_UserCannotChangePassword() {
		return (EAttribute) aixLocalUserEClass.getEStructuralFeatures().get(29);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getAIXLocalUser_UserName() {
		return (EAttribute) aixLocalUserEClass.getEStructuralFeatures().get(30);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getAIXLocalUser_UserRegisteringMethod() {
		return (EAttribute) aixLocalUserEClass.getEStructuralFeatures().get(31);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getAIXLocalUser_UserSid() {
		return (EAttribute) aixLocalUserEClass.getEStructuralFeatures().get(32);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getAIXLocalUser_UsuccessfulLoginCount() {
		return (EAttribute) aixLocalUserEClass.getEStructuralFeatures().get(33);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getAIXLocalUserUnit() {
		return aixLocalUserUnitEClass;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getAIXOperatingSystem() {
		return aixOperatingSystemEClass;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getAIXOperatingSystem_Desktop() {
		return (EAttribute) aixOperatingSystemEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getAIXOperatingSystem_InstallDate() {
		return (EAttribute) aixOperatingSystemEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getAIXOperatingSystem_Kernel() {
		return (EAttribute) aixOperatingSystemEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getAIXOperatingSystem_LastBootUpTime() {
		return (EAttribute) aixOperatingSystemEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getAIXOperatingSystem_Owner() {
		return (EAttribute) aixOperatingSystemEClass.getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getAIXOperatingSystem_TCB() {
		return (EAttribute) aixOperatingSystemEClass.getEStructuralFeatures().get(5);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getAIXOperatingSystemUnit() {
		return aixOperatingSystemUnitEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getDataFile() {
		return dataFileEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getDataFileUnit() {
		return dataFileUnitEClass;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getDirectory() {
		return directoryEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getDirectory_DirectoryPath() {
		return (EAttribute) directoryEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getDirectoryUnit() {
		return directoryUnitEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getFileSystem() {
		return fileSystemEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getFileSystem_AvailableSpace() {
		return (EAttribute) fileSystemEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getFileSystem_Capacity() {
		return (EAttribute) fileSystemEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getFileSystem_MountPoint() {
		return (EAttribute) fileSystemEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getFileSystem_Type() {
		return (EAttribute) fileSystemEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getFileSystemContent() {
		return fileSystemContentEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getFileSystemContent_FixedPath() {
		return (EAttribute) fileSystemContentEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getFileSystemContent_Group() {
		return (EAttribute) fileSystemContentEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getFileSystemContent_LastModified() {
		return (EAttribute) fileSystemContentEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getFileSystemContent_Owner() {
		return (EAttribute) fileSystemContentEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getFileSystemContent_Permissions() {
		return (EAttribute) fileSystemContentEClass.getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getFileSystemContent_RealFile() {
		return (EAttribute) fileSystemContentEClass.getEStructuralFeatures().get(5);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getFileSystemContent_Size() {
		return (EAttribute) fileSystemContentEClass.getEStructuralFeatures().get(6);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getFileSystemContent_URI() {
		return (EAttribute) fileSystemContentEClass.getEStructuralFeatures().get(7);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getFileSystemContentUnit() {
		return fileSystemContentUnitEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getFileSystemUnit() {
		return fileSystemUnitEClass;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getLinuxLocalGroup() {
		return linuxLocalGroupEClass;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getLinuxLocalGroup_GroupDescription() {
		return (EAttribute) linuxLocalGroupEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getLinuxLocalGroupUnit() {
		return linuxLocalGroupUnitEClass;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getLinuxLocalService() {
		return linuxLocalServiceEClass;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getLinuxLocalService_ExecutablePath() {
		return (EAttribute) linuxLocalServiceEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getLinuxLocalService_ServiceAccount() {
		return (EAttribute) linuxLocalServiceEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getLinuxLocalService_ServiceDescription() {
		return (EAttribute) linuxLocalServiceEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getLinuxLocalService_ServiceName() {
		return (EAttribute) linuxLocalServiceEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getLinuxLocalService_ServiceStatus() {
		return (EAttribute) linuxLocalServiceEClass.getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getLinuxLocalService_StartupRunLevelFive() {
		return (EAttribute) linuxLocalServiceEClass.getEStructuralFeatures().get(5);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getLinuxLocalService_StartupRunLevelFour() {
		return (EAttribute) linuxLocalServiceEClass.getEStructuralFeatures().get(6);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getLinuxLocalService_StartupRunLevelOne() {
		return (EAttribute) linuxLocalServiceEClass.getEStructuralFeatures().get(7);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getLinuxLocalService_StartupRunLevelSix() {
		return (EAttribute) linuxLocalServiceEClass.getEStructuralFeatures().get(8);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getLinuxLocalService_StartupRunLevelThree() {
		return (EAttribute) linuxLocalServiceEClass.getEStructuralFeatures().get(9);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getLinuxLocalService_StartupRunLevelTwo() {
		return (EAttribute) linuxLocalServiceEClass.getEStructuralFeatures().get(10);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getLinuxLocalService_StartupRunLevelZero() {
		return (EAttribute) linuxLocalServiceEClass.getEStructuralFeatures().get(11);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getLinuxLocalService_StartupType() {
		return (EAttribute) linuxLocalServiceEClass.getEStructuralFeatures().get(12);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getLinuxLocalServiceUnit() {
		return linuxLocalServiceUnitEClass;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getLinuxLocalUser() {
		return linuxLocalUserEClass;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getLinuxLocalUser_AccountDescription() {
		return (EAttribute) linuxLocalUserEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getLinuxLocalUser_AccountDisabled() {
		return (EAttribute) linuxLocalUserEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getLinuxLocalUser_ChangePasswordNextLogon() {
		return (EAttribute) linuxLocalUserEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getLinuxLocalUser_FullName() {
		return (EAttribute) linuxLocalUserEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getLinuxLocalUser_HomeDir() {
		return (EAttribute) linuxLocalUserEClass.getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getLinuxLocalUser_PasswordNeverExpires() {
		return (EAttribute) linuxLocalUserEClass.getEStructuralFeatures().get(5);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getLinuxLocalUser_Shell() {
		return (EAttribute) linuxLocalUserEClass.getEStructuralFeatures().get(6);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getLinuxLocalUser_UserCannotChangePassword() {
		return (EAttribute) linuxLocalUserEClass.getEStructuralFeatures().get(7);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getLinuxLocalUser_UserName() {
		return (EAttribute) linuxLocalUserEClass.getEStructuralFeatures().get(8);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getLinuxLocalUserUnit() {
		return linuxLocalUserUnitEClass;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getLinuxOperatingSystem() {
		return linuxOperatingSystemEClass;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getLinuxOperatingSystem_KernelRelease() {
		return (EAttribute) linuxOperatingSystemEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getLinuxOperatingSystemUnit() {
		return linuxOperatingSystemUnitEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getLocalFileSystem() {
		return localFileSystemEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getLocalFileSystemUnit() {
		return localFileSystemUnitEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getNFSFileSystem() {
		return nfsFileSystemEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getNFSFileSystemUnit() {
		return nfsFileSystemUnitEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getOpenVmsFileSystem() {
		return openVmsFileSystemEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getOpenVmsFileSystemUnit() {
		return openVmsFileSystemUnitEClass;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getOperatingSystem() {
		return operatingSystemEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getOperatingSystem_Fqdn() {
		return (EAttribute) operatingSystemEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getOperatingSystem_Hostname() {
		return (EAttribute) operatingSystemEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getOperatingSystem_KernelArchitecture() {
		return (EAttribute) operatingSystemEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getOperatingSystem_KernelVersion() {
		return (EAttribute) operatingSystemEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getOperatingSystem_KernelWidth() {
		return (EAttribute) operatingSystemEClass.getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getOperatingSystem_Locale() {
		return (EAttribute) operatingSystemEClass.getEStructuralFeatures().get(5);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getOperatingSystem_Manufacturer() {
		return (EAttribute) operatingSystemEClass.getEStructuralFeatures().get(6);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getOperatingSystem_OsDistribution() {
		return (EAttribute) operatingSystemEClass.getEStructuralFeatures().get(7);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getOperatingSystem_OsServicepack() {
		return (EAttribute) operatingSystemEClass.getEStructuralFeatures().get(8);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getOperatingSystem_OsType() {
		return (EAttribute) operatingSystemEClass.getEStructuralFeatures().get(9);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getOperatingSystem_OsVersion() {
		return (EAttribute) operatingSystemEClass.getEStructuralFeatures().get(10);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getOperatingSystem_TimeZone() {
		return (EAttribute) operatingSystemEClass.getEStructuralFeatures().get(11);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getOperatingSystemRoot() {
		return operatingSystemRootEClass;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getOperatingSystemRoot_Mixed() {
		return (EAttribute) operatingSystemRootEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getOperatingSystemRoot_XMLNSPrefixMap() {
		return (EReference) operatingSystemRootEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getOperatingSystemRoot_XSISchemaLocation() {
		return (EReference) operatingSystemRootEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getOperatingSystemRoot_CapabilityAixLocalGroup() {
		return (EReference) operatingSystemRootEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getOperatingSystemRoot_CapabilityAixLocalService() {
		return (EReference) operatingSystemRootEClass.getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getOperatingSystemRoot_CapabilityAixLocalUser() {
		return (EReference) operatingSystemRootEClass.getEStructuralFeatures().get(5);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getOperatingSystemRoot_CapabilityAixOperatingSystem() {
		return (EReference) operatingSystemRootEClass.getEStructuralFeatures().get(6);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getOperatingSystemRoot_CapabilityDataFile() {
		return (EReference) operatingSystemRootEClass.getEStructuralFeatures().get(7);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getOperatingSystemRoot_CapabilityDirectory() {
		return (EReference) operatingSystemRootEClass.getEStructuralFeatures().get(8);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getOperatingSystemRoot_CapabilityFileSystem() {
		return (EReference) operatingSystemRootEClass.getEStructuralFeatures().get(9);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getOperatingSystemRoot_CapabilityFileSystemContent() {
		return (EReference) operatingSystemRootEClass.getEStructuralFeatures().get(10);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getOperatingSystemRoot_CapabilityLinuxLocalGroup() {
		return (EReference) operatingSystemRootEClass.getEStructuralFeatures().get(11);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getOperatingSystemRoot_CapabilityLinuxLocalService() {
		return (EReference) operatingSystemRootEClass.getEStructuralFeatures().get(12);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getOperatingSystemRoot_CapabilityLinuxLocalUser() {
		return (EReference) operatingSystemRootEClass.getEStructuralFeatures().get(13);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getOperatingSystemRoot_CapabilityLinuxOperatingSystem() {
		return (EReference) operatingSystemRootEClass.getEStructuralFeatures().get(14);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getOperatingSystemRoot_CapabilityLocalFileSystem() {
		return (EReference) operatingSystemRootEClass.getEStructuralFeatures().get(15);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getOperatingSystemRoot_CapabilityNFSFileSystem() {
		return (EReference) operatingSystemRootEClass.getEStructuralFeatures().get(16);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getOperatingSystemRoot_CapabilityOpenVmsFileSystem() {
		return (EReference) operatingSystemRootEClass.getEStructuralFeatures().get(17);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getOperatingSystemRoot_CapabilityOperatingSystem() {
		return (EReference) operatingSystemRootEClass.getEStructuralFeatures().get(18);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getOperatingSystemRoot_CapabilityPort() {
		return (EReference) operatingSystemRootEClass.getEStructuralFeatures().get(19);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getOperatingSystemRoot_CapabilityPortConsumer() {
		return (EReference) operatingSystemRootEClass.getEStructuralFeatures().get(20);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getOperatingSystemRoot_CapabilityRedhatLinuxLocalGroup() {
		return (EReference) operatingSystemRootEClass.getEStructuralFeatures().get(21);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getOperatingSystemRoot_CapabilityRedhatLinuxLocalService() {
		return (EReference) operatingSystemRootEClass.getEStructuralFeatures().get(22);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getOperatingSystemRoot_CapabilityRedhatLinuxLocalUser() {
		return (EReference) operatingSystemRootEClass.getEStructuralFeatures().get(23);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getOperatingSystemRoot_CapabilityRedhatLinuxOperatingSystem() {
		return (EReference) operatingSystemRootEClass.getEStructuralFeatures().get(24);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getOperatingSystemRoot_CapabilityRemoteFileSystem() {
		return (EReference) operatingSystemRootEClass.getEStructuralFeatures().get(25);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getOperatingSystemRoot_CapabilitySMBFileSystem() {
		return (EReference) operatingSystemRootEClass.getEStructuralFeatures().get(26);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getOperatingSystemRoot_CapabilitySolarisFileSystem() {
		return (EReference) operatingSystemRootEClass.getEStructuralFeatures().get(27);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getOperatingSystemRoot_CapabilitySuseLinuxLocalGroup() {
		return (EReference) operatingSystemRootEClass.getEStructuralFeatures().get(28);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getOperatingSystemRoot_CapabilitySuseLinuxLocalService() {
		return (EReference) operatingSystemRootEClass.getEStructuralFeatures().get(29);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getOperatingSystemRoot_CapabilitySuseLinuxLocalUser() {
		return (EReference) operatingSystemRootEClass.getEStructuralFeatures().get(30);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getOperatingSystemRoot_CapabilitySuseLinuxOperatingSystem() {
		return (EReference) operatingSystemRootEClass.getEStructuralFeatures().get(31);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getOperatingSystemRoot_CapabilityUnixDirectory() {
		return (EReference) operatingSystemRootEClass.getEStructuralFeatures().get(32);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getOperatingSystemRoot_CapabilityUnixFileSystem() {
		return (EReference) operatingSystemRootEClass.getEStructuralFeatures().get(33);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getOperatingSystemRoot_CapabilityUser() {
		return (EReference) operatingSystemRootEClass.getEStructuralFeatures().get(34);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getOperatingSystemRoot_CapabilityUserGroup() {
		return (EReference) operatingSystemRootEClass.getEStructuralFeatures().get(35);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getOperatingSystemRoot_CapabilityWindowsDirectory() {
		return (EReference) operatingSystemRootEClass.getEStructuralFeatures().get(36);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getOperatingSystemRoot_CapabilityWindowsFileSystem() {
		return (EReference) operatingSystemRootEClass.getEStructuralFeatures().get(37);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getOperatingSystemRoot_CapabilityWindowsLocalGroup() {
		return (EReference) operatingSystemRootEClass.getEStructuralFeatures().get(38);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getOperatingSystemRoot_CapabilityWindowsLocalService() {
		return (EReference) operatingSystemRootEClass.getEStructuralFeatures().get(39);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getOperatingSystemRoot_CapabilityWindowsLocalUser() {
		return (EReference) operatingSystemRootEClass.getEStructuralFeatures().get(40);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getOperatingSystemRoot_CapabilityWindowsOperatingSystem() {
		return (EReference) operatingSystemRootEClass.getEStructuralFeatures().get(41);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getOperatingSystemRoot_UnitAixLocalGroup() {
		return (EReference) operatingSystemRootEClass.getEStructuralFeatures().get(42);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getOperatingSystemRoot_UnitAixLocalServiceUnit() {
		return (EReference) operatingSystemRootEClass.getEStructuralFeatures().get(43);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getOperatingSystemRoot_UnitAixLocalUser() {
		return (EReference) operatingSystemRootEClass.getEStructuralFeatures().get(44);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getOperatingSystemRoot_UnitAixOperatingSystemUnit() {
		return (EReference) operatingSystemRootEClass.getEStructuralFeatures().get(45);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getOperatingSystemRoot_UnitDataFileUnit() {
		return (EReference) operatingSystemRootEClass.getEStructuralFeatures().get(46);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getOperatingSystemRoot_UnitDirectoryUnit() {
		return (EReference) operatingSystemRootEClass.getEStructuralFeatures().get(47);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getOperatingSystemRoot_UnitFileSystemContentUnit() {
		return (EReference) operatingSystemRootEClass.getEStructuralFeatures().get(48);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getOperatingSystemRoot_UnitFileSystemUnit() {
		return (EReference) operatingSystemRootEClass.getEStructuralFeatures().get(49);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getOperatingSystemRoot_UnitLinuxLocalGroup() {
		return (EReference) operatingSystemRootEClass.getEStructuralFeatures().get(50);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getOperatingSystemRoot_UnitLinuxLocalServiceUnit() {
		return (EReference) operatingSystemRootEClass.getEStructuralFeatures().get(51);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getOperatingSystemRoot_UnitLinuxLocalUser() {
		return (EReference) operatingSystemRootEClass.getEStructuralFeatures().get(52);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getOperatingSystemRoot_UnitLinuxOperatingSystemUnit() {
		return (EReference) operatingSystemRootEClass.getEStructuralFeatures().get(53);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getOperatingSystemRoot_UnitLocalFileSystemUnit() {
		return (EReference) operatingSystemRootEClass.getEStructuralFeatures().get(54);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getOperatingSystemRoot_UnitNFSFileSystemUnit() {
		return (EReference) operatingSystemRootEClass.getEStructuralFeatures().get(55);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getOperatingSystemRoot_UnitOpenVmsFileSystemUnit() {
		return (EReference) operatingSystemRootEClass.getEStructuralFeatures().get(56);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getOperatingSystemRoot_UnitOperatingSystemUnit() {
		return (EReference) operatingSystemRootEClass.getEStructuralFeatures().get(57);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getOperatingSystemRoot_UnitPortConfigUnit() {
		return (EReference) operatingSystemRootEClass.getEStructuralFeatures().get(58);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getOperatingSystemRoot_UnitRemoteFileSystemUnit() {
		return (EReference) operatingSystemRootEClass.getEStructuralFeatures().get(59);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getOperatingSystemRoot_UnitSMBFileSystemUnit() {
		return (EReference) operatingSystemRootEClass.getEStructuralFeatures().get(60);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getOperatingSystemRoot_UnitSolarisFileSystemUnit() {
		return (EReference) operatingSystemRootEClass.getEStructuralFeatures().get(61);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getOperatingSystemRoot_UnitUnixFileSystemUnit() {
		return (EReference) operatingSystemRootEClass.getEStructuralFeatures().get(62);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getOperatingSystemRoot_UnitUser() {
		return (EReference) operatingSystemRootEClass.getEStructuralFeatures().get(63);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getOperatingSystemRoot_UnitUserGroup() {
		return (EReference) operatingSystemRootEClass.getEStructuralFeatures().get(64);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getOperatingSystemRoot_UnitWindowsFileSystemUnit() {
		return (EReference) operatingSystemRootEClass.getEStructuralFeatures().get(65);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getOperatingSystemRoot_UnitWindowsLocalGroup() {
		return (EReference) operatingSystemRootEClass.getEStructuralFeatures().get(66);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getOperatingSystemRoot_UnitWindowsLocalServiceUnit() {
		return (EReference) operatingSystemRootEClass.getEStructuralFeatures().get(67);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getOperatingSystemRoot_UnitWindowsLocalUser() {
		return (EReference) operatingSystemRootEClass.getEStructuralFeatures().get(68);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getOperatingSystemRoot_UnitWindowsOperatingSystemUnit() {
		return (EReference) operatingSystemRootEClass.getEStructuralFeatures().get(69);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getOperatingSystemUnit() {
		return operatingSystemUnitEClass;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getPort() {
		return portEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getPort_ApplicationLayerProtocol() {
		return (EAttribute) portEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getPort_IpAddressOrHostname() {
		return (EAttribute) portEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getPort_Port() {
		return (EAttribute) portEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getPort_PortName() {
		return (EAttribute) portEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getPort_TransportLayerProtocol() {
		return (EAttribute) portEClass.getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getPortConfigUnit() {
		return portConfigUnitEClass;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getPortConsumer() {
		return portConsumerEClass;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getRedhatLinuxLocalGroup() {
		return redhatLinuxLocalGroupEClass;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getRedhatLinuxLocalGroup_GroupSid() {
		return (EAttribute) redhatLinuxLocalGroupEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getRedhatLinuxLocalService() {
		return redhatLinuxLocalServiceEClass;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getRedhatLinuxLocalUser() {
		return redhatLinuxLocalUserEClass;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getRedhatLinuxLocalUser_AccountDisableAfterDays() {
		return (EAttribute) redhatLinuxLocalUserEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getRedhatLinuxLocalUser_AccountDisableDate() {
		return (EAttribute) redhatLinuxLocalUserEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getRedhatLinuxLocalUser_DaysBeforePasswordMayChange() {
		return (EAttribute) redhatLinuxLocalUserEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getRedhatLinuxLocalUser_LastPasswordChange() {
		return (EAttribute) redhatLinuxLocalUserEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getRedhatLinuxLocalUser_PasswordExpireAfterDays() {
		return (EAttribute) redhatLinuxLocalUserEClass.getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getRedhatLinuxLocalUser_PasswordExpireWarningDays() {
		return (EAttribute) redhatLinuxLocalUserEClass.getEStructuralFeatures().get(5);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getRedhatLinuxLocalUser_UserSid() {
		return (EAttribute) redhatLinuxLocalUserEClass.getEStructuralFeatures().get(6);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getRedhatLinuxOperatingSystem() {
		return redhatLinuxOperatingSystemEClass;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getRedhatLinuxOperatingSystem_BootLoader() {
		return (EAttribute) redhatLinuxOperatingSystemEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getRedhatLinuxOperatingSystem_Desktop() {
		return (EAttribute) redhatLinuxOperatingSystemEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getRedhatLinuxOperatingSystem_InstallDate() {
		return (EAttribute) redhatLinuxOperatingSystemEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getRedhatLinuxOperatingSystem_LastBootUpTime() {
		return (EAttribute) redhatLinuxOperatingSystemEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getRedhatLinuxOperatingSystem_Owner() {
		return (EAttribute) redhatLinuxOperatingSystemEClass.getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getRedhatLinuxOperatingSystem_ProductType() {
		return (EAttribute) redhatLinuxOperatingSystemEClass.getEStructuralFeatures().get(5);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getRedhatLinuxOperatingSystem_SELinuxState() {
		return (EAttribute) redhatLinuxOperatingSystemEClass.getEStructuralFeatures().get(6);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getRemoteFileSystem() {
		return remoteFileSystemEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getRemoteFileSystem_ExportName() {
		return (EAttribute) remoteFileSystemEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getRemoteFileSystem_ServerName() {
		return (EAttribute) remoteFileSystemEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getRemoteFileSystemUnit() {
		return remoteFileSystemUnitEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getSMBFileSystem() {
		return smbFileSystemEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getSMBFileSystemUnit() {
		return smbFileSystemUnitEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getSolarisFileSystem() {
		return solarisFileSystemEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getSolarisFileSystemUnit() {
		return solarisFileSystemUnitEClass;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getSUSELinuxLocalGroup() {
		return suseLinuxLocalGroupEClass;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getSUSELinuxLocalGroup_GroupId() {
		return (EAttribute) suseLinuxLocalGroupEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getSUSELinuxLocalService() {
		return suseLinuxLocalServiceEClass;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getSUSELinuxLocalUser() {
		return suseLinuxLocalUserEClass;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getSUSELinuxOperatingSystem() {
		return suseLinuxOperatingSystemEClass;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getSUSELinuxOperatingSystem_BootLoader() {
		return (EAttribute) suseLinuxOperatingSystemEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getSUSELinuxOperatingSystem_Desktop() {
		return (EAttribute) suseLinuxOperatingSystemEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getSUSELinuxOperatingSystem_LastBootUpDate() {
		return (EAttribute) suseLinuxOperatingSystemEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getUnixDirectory() {
		return unixDirectoryEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getUnixFileSystem() {
		return unixFileSystemEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getUnixFileSystemUnit() {
		return unixFileSystemUnitEClass;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getUser() {
		return userEClass;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getUser_UserId() {
		return (EAttribute) userEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getUser_UserPassword() {
		return (EAttribute) userEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getUserGroup() {
		return userGroupEClass;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getUserGroup_GroupName() {
		return (EAttribute) userGroupEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getUserGroupUnit() {
		return userGroupUnitEClass;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getUserUnit() {
		return userUnitEClass;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getWindowsDirectory() {
		return windowsDirectoryEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getWindowsFileSystem() {
		return windowsFileSystemEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getWindowsFileSystemUnit() {
		return windowsFileSystemUnitEClass;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getWindowsLocalGroup() {
		return windowsLocalGroupEClass;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getWindowsLocalGroup_Description1() {
		return (EAttribute) windowsLocalGroupEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getWindowsLocalGroup_GroupSid() {
		return (EAttribute) windowsLocalGroupEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getWindowsLocalGroupUnit() {
		return windowsLocalGroupUnitEClass;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getWindowsLocalService() {
		return windowsLocalServiceEClass;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getWindowsLocalService_DependantComponents() {
		return (EAttribute) windowsLocalServiceEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getWindowsLocalService_ErrorControl() {
		return (EAttribute) windowsLocalServiceEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getWindowsLocalService_ExecutablePath() {
		return (EAttribute) windowsLocalServiceEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getWindowsLocalService_LogOnAsSystem() {
		return (EAttribute) windowsLocalServiceEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getWindowsLocalService_RunProgram() {
		return (EAttribute) windowsLocalServiceEClass.getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getWindowsLocalService_ServiceAccount() {
		return (EAttribute) windowsLocalServiceEClass.getEStructuralFeatures().get(5);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getWindowsLocalService_ServiceAccountPassword() {
		return (EAttribute) windowsLocalServiceEClass.getEStructuralFeatures().get(6);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getWindowsLocalService_ServiceDependencies() {
		return (EAttribute) windowsLocalServiceEClass.getEStructuralFeatures().get(7);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getWindowsLocalService_ServiceDescription() {
		return (EAttribute) windowsLocalServiceEClass.getEStructuralFeatures().get(8);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getWindowsLocalService_ServiceDisplayName() {
		return (EAttribute) windowsLocalServiceEClass.getEStructuralFeatures().get(9);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getWindowsLocalService_ServiceName() {
		return (EAttribute) windowsLocalServiceEClass.getEStructuralFeatures().get(10);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getWindowsLocalService_ServiceStatus() {
		return (EAttribute) windowsLocalServiceEClass.getEStructuralFeatures().get(11);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getWindowsLocalService_StartParams() {
		return (EAttribute) windowsLocalServiceEClass.getEStructuralFeatures().get(12);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getWindowsLocalService_StartupType() {
		return (EAttribute) windowsLocalServiceEClass.getEStructuralFeatures().get(13);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getWindowsLocalServiceUnit() {
		return windowsLocalServiceUnitEClass;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getWindowsLocalUser() {
		return windowsLocalUserEClass;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getWindowsLocalUser_AccountDescription() {
		return (EAttribute) windowsLocalUserEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getWindowsLocalUser_AccountDisabled() {
		return (EAttribute) windowsLocalUserEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getWindowsLocalUser_AccountLocked() {
		return (EAttribute) windowsLocalUserEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getWindowsLocalUser_ChangePasswordNextLogon() {
		return (EAttribute) windowsLocalUserEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getWindowsLocalUser_EnableRemoteControl() {
		return (EAttribute) windowsLocalUserEClass.getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getWindowsLocalUser_FullName() {
		return (EAttribute) windowsLocalUserEClass.getEStructuralFeatures().get(5);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getWindowsLocalUser_HomeFolder() {
		return (EAttribute) windowsLocalUserEClass.getEStructuralFeatures().get(6);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getWindowsLocalUser_LogonScript() {
		return (EAttribute) windowsLocalUserEClass.getEStructuralFeatures().get(7);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getWindowsLocalUser_PasswordNeverExpires() {
		return (EAttribute) windowsLocalUserEClass.getEStructuralFeatures().get(8);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getWindowsLocalUser_ProfilePath() {
		return (EAttribute) windowsLocalUserEClass.getEStructuralFeatures().get(9);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getWindowsLocalUser_UserAccountType() {
		return (EAttribute) windowsLocalUserEClass.getEStructuralFeatures().get(10);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getWindowsLocalUser_UserCannotChangePassword() {
		return (EAttribute) windowsLocalUserEClass.getEStructuralFeatures().get(11);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getWindowsLocalUser_UserSid() {
		return (EAttribute) windowsLocalUserEClass.getEStructuralFeatures().get(12);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getWindowsLocalUser_UserSidType() {
		return (EAttribute) windowsLocalUserEClass.getEStructuralFeatures().get(13);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getWindowsLocalUserUnit() {
		return windowsLocalUserUnitEClass;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getWindowsOperatingSystem() {
		return windowsOperatingSystemEClass;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getWindowsOperatingSystem_Company() {
		return (EAttribute) windowsOperatingSystemEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getWindowsOperatingSystem_DomainAdmin() {
		return (EAttribute) windowsOperatingSystemEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getWindowsOperatingSystem_DomainName() {
		return (EAttribute) windowsOperatingSystemEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getWindowsOperatingSystem_DomainPassword() {
		return (EAttribute) windowsOperatingSystemEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getWindowsOperatingSystem_EncryptionLevel() {
		return (EAttribute) windowsOperatingSystemEClass.getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getWindowsOperatingSystem_InstallDate() {
		return (EAttribute) windowsOperatingSystemEClass.getEStructuralFeatures().get(5);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getWindowsOperatingSystem_Language() {
		return (EAttribute) windowsOperatingSystemEClass.getEStructuralFeatures().get(6);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getWindowsOperatingSystem_LanguageGroup() {
		return (EAttribute) windowsOperatingSystemEClass.getEStructuralFeatures().get(7);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getWindowsOperatingSystem_LastBootUpTime() {
		return (EAttribute) windowsOperatingSystemEClass.getEStructuralFeatures().get(8);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getWindowsOperatingSystem_MachineObjectOU() {
		return (EAttribute) windowsOperatingSystemEClass.getEStructuralFeatures().get(9);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getWindowsOperatingSystem_NumberOfLicensedUsers() {
		return (EAttribute) windowsOperatingSystemEClass.getEStructuralFeatures().get(10);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getWindowsOperatingSystem_Owner() {
		return (EAttribute) windowsOperatingSystemEClass.getEStructuralFeatures().get(11);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getWindowsOperatingSystem_ProductKey() {
		return (EAttribute) windowsOperatingSystemEClass.getEStructuralFeatures().get(12);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getWindowsOperatingSystem_ProductType() {
		return (EAttribute) windowsOperatingSystemEClass.getEStructuralFeatures().get(13);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getWindowsOperatingSystem_SystemDrive() {
		return (EAttribute) windowsOperatingSystemEClass.getEStructuralFeatures().get(14);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getWindowsOperatingSystem_WindowsDirectory() {
		return (EAttribute) windowsOperatingSystemEClass.getEStructuralFeatures().get(15);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getWindowsOperatingSystem_WorkgroupName() {
		return (EAttribute) windowsOperatingSystemEClass.getEStructuralFeatures().get(16);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getWindowsOperatingSystemUnit() {
		return windowsOperatingSystemUnitEClass;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EEnum getAIXAuthMethodType() {
		return aixAuthMethodTypeEEnum;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EEnum getAIXDesktopType() {
		return aixDesktopTypeEEnum;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EEnum getAIXUserRegisteringMethodType() {
		return aixUserRegisteringMethodTypeEEnum;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EEnum getArchitectureBusType() {
		return architectureBusTypeEEnum;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EEnum getDefaultWindowsUserGroups() {
		return defaultWindowsUserGroupsEEnum;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EEnum getEncryptionLevelType() {
		return encryptionLevelTypeEEnum;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EEnum getKernelWidthType() {
		return kernelWidthTypeEEnum;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EEnum getLinuxServiceStartupTypeType() {
		return linuxServiceStartupTypeTypeEEnum;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EEnum getLinuxServiceStatusType() {
		return linuxServiceStatusTypeEEnum;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EEnum getOperatingSystemType() {
		return operatingSystemTypeEEnum;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EEnum getRedhatDesktopType() {
		return redhatDesktopTypeEEnum;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EEnum getRedhatLinuxBootLoaderType() {
		return redhatLinuxBootLoaderTypeEEnum;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EEnum getRedhatLinuxProductTypeType() {
		return redhatLinuxProductTypeTypeEEnum;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EEnum getRedhatLinuxServiceStartupTypeType() {
		return redhatLinuxServiceStartupTypeTypeEEnum;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EEnum getRedhatLinuxServiceStatusType() {
		return redhatLinuxServiceStatusTypeEEnum;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EEnum getSELinuxStateType() {
		return seLinuxStateTypeEEnum;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EEnum getSUSEDesktopType() {
		return suseDesktopTypeEEnum;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EEnum getSUSELinuxBootLoaderType() {
		return suseLinuxBootLoaderTypeEEnum;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EEnum getSUSELinuxServiceStartupTypeType() {
		return suseLinuxServiceStartupTypeTypeEEnum;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EEnum getSUSELinuxServiceStatusType() {
		return suseLinuxServiceStatusTypeEEnum;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EEnum getTransportLayerProtocolType() {
		return transportLayerProtocolTypeEEnum;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EEnum getWindowsDirectoryType() {
		return windowsDirectoryTypeEEnum;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EEnum getWindowsProductTypeType() {
		return windowsProductTypeTypeEEnum;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EEnum getWindowsServiceErrorControlType() {
		return windowsServiceErrorControlTypeEEnum;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EEnum getWindowsServiceStartupType() {
		return windowsServiceStartupTypeEEnum;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EEnum getWindowsServiceStatusType() {
		return windowsServiceStatusTypeEEnum;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EDataType getAIXAuthMethodTypeObject() {
		return aixAuthMethodTypeObjectEDataType;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EDataType getAIXDesktopTypeObject() {
		return aixDesktopTypeObjectEDataType;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EDataType getAIXUserRegisteringMethodTypeObject() {
		return aixUserRegisteringMethodTypeObjectEDataType;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EDataType getArchitectureBusTypeObject() {
		return architectureBusTypeObjectEDataType;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EDataType getDefaultWindowsUserGroupsObject() {
		return defaultWindowsUserGroupsObjectEDataType;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EDataType getEncryptionLevelTypeObject() {
		return encryptionLevelTypeObjectEDataType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EDataType getKernelWidthTypeObject() {
		return kernelWidthTypeObjectEDataType;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EDataType getLinuxServiceStartupTypeTypeObject() {
		return linuxServiceStartupTypeTypeObjectEDataType;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EDataType getLinuxServiceStatusTypeObject() {
		return linuxServiceStatusTypeObjectEDataType;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EDataType getOperatingSystemTypeObject() {
		return operatingSystemTypeObjectEDataType;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EDataType getRedhatDesktopTypeObject() {
		return redhatDesktopTypeObjectEDataType;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EDataType getRedhatLinuxBootLoaderTypeObject() {
		return redhatLinuxBootLoaderTypeObjectEDataType;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EDataType getRedhatLinuxProductTypeTypeObject() {
		return redhatLinuxProductTypeTypeObjectEDataType;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EDataType getRedhatLinuxServiceStartupTypeTypeObject() {
		return redhatLinuxServiceStartupTypeTypeObjectEDataType;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EDataType getRedhatLinuxServiceStatusTypeObject() {
		return redhatLinuxServiceStatusTypeObjectEDataType;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EDataType getSELinuxStateTypeObject() {
		return seLinuxStateTypeObjectEDataType;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EDataType getSUSEDesktopTypeObject() {
		return suseDesktopTypeObjectEDataType;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EDataType getSUSELinuxBootLoaderTypeObject() {
		return suseLinuxBootLoaderTypeObjectEDataType;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EDataType getSUSELinuxServiceStartupTypeTypeObject() {
		return suseLinuxServiceStartupTypeTypeObjectEDataType;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EDataType getSUSELinuxServiceStatusTypeObject() {
		return suseLinuxServiceStatusTypeObjectEDataType;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EDataType getTCPPortType() {
		return tcpPortTypeEDataType;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EDataType getTransportLayerProtocolTypeObject() {
		return transportLayerProtocolTypeObjectEDataType;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EDataType getUDPPortType() {
		return udpPortTypeEDataType;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EDataType getWindowsDirectoryTypeObject() {
		return windowsDirectoryTypeObjectEDataType;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EDataType getWindowsProductTypeTypeObject() {
		return windowsProductTypeTypeObjectEDataType;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EDataType getWindowsServiceErrorControlTypeObject() {
		return windowsServiceErrorControlTypeObjectEDataType;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EDataType getWindowsServiceStartupTypeObject() {
		return windowsServiceStartupTypeObjectEDataType;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EDataType getWindowsServiceStatusTypeObject() {
		return windowsServiceStatusTypeObjectEDataType;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public OsFactory getOsFactory() {
		return (OsFactory) getEFactoryInstance();
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	private boolean isCreated = false;

	/**
	 * Creates the meta-model objects for the package.  This method is
	 * guarded to have no affect on any invocation but its first.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public void createPackageContents() {
		if (isCreated)
			return;
		isCreated = true;

		// Create classes and their features
		aixLocalGroupEClass = createEClass(AIX_LOCAL_GROUP);
		createEAttribute(aixLocalGroupEClass, AIX_LOCAL_GROUP__GROUP_DESCRIPTION);
		createEAttribute(aixLocalGroupEClass, AIX_LOCAL_GROUP__GROUP_SID);

		aixLocalGroupUnitEClass = createEClass(AIX_LOCAL_GROUP_UNIT);

		aixLocalServiceEClass = createEClass(AIX_LOCAL_SERVICE);
		createEAttribute(aixLocalServiceEClass, AIX_LOCAL_SERVICE__ACTION_TYPE);
		createEAttribute(aixLocalServiceEClass, AIX_LOCAL_SERVICE__EXECUTABLE_PATH);
		createEAttribute(aixLocalServiceEClass, AIX_LOCAL_SERVICE__SERVICE_DESCRIPTION);
		createEAttribute(aixLocalServiceEClass, AIX_LOCAL_SERVICE__STARTUP_RUN_LEVEL_EIGHT);
		createEAttribute(aixLocalServiceEClass, AIX_LOCAL_SERVICE__STARTUP_RUN_LEVEL_FIVE);
		createEAttribute(aixLocalServiceEClass, AIX_LOCAL_SERVICE__STARTUP_RUN_LEVEL_FOUR);
		createEAttribute(aixLocalServiceEClass, AIX_LOCAL_SERVICE__STARTUP_RUN_LEVEL_NINE);
		createEAttribute(aixLocalServiceEClass, AIX_LOCAL_SERVICE__STARTUP_RUN_LEVEL_ONE);
		createEAttribute(aixLocalServiceEClass, AIX_LOCAL_SERVICE__STARTUP_RUN_LEVEL_SEVEN);
		createEAttribute(aixLocalServiceEClass, AIX_LOCAL_SERVICE__STARTUP_RUN_LEVEL_SIX);
		createEAttribute(aixLocalServiceEClass, AIX_LOCAL_SERVICE__STARTUP_RUN_LEVEL_THREE);
		createEAttribute(aixLocalServiceEClass, AIX_LOCAL_SERVICE__STARTUP_RUN_LEVEL_TWO);
		createEAttribute(aixLocalServiceEClass, AIX_LOCAL_SERVICE__STARTUP_RUN_LEVEL_ZERO);

		aixLocalServiceUnitEClass = createEClass(AIX_LOCAL_SERVICE_UNIT);

		aixLocalUserEClass = createEClass(AIX_LOCAL_USER);
		createEAttribute(aixLocalUserEClass, AIX_LOCAL_USER__ACCOUNT_DESCRIPTION);
		createEAttribute(aixLocalUserEClass, AIX_LOCAL_USER__ACCOUNT_DISABLED);
		createEAttribute(aixLocalUserEClass, AIX_LOCAL_USER__ACCOUNT_EXPIRATION_TIME);
		createEAttribute(aixLocalUserEClass, AIX_LOCAL_USER__CHANGE_PASSWORD_NEXT_LOGON);
		createEAttribute(aixLocalUserEClass, AIX_LOCAL_USER__FULL_NAME);
		createEAttribute(aixLocalUserEClass, AIX_LOCAL_USER__HOME_DIR);
		createEAttribute(aixLocalUserEClass, AIX_LOCAL_USER__IS_ADMIN);
		createEAttribute(aixLocalUserEClass, AIX_LOCAL_USER__LOGIN_PERMITTED);
		createEAttribute(aixLocalUserEClass, AIX_LOCAL_USER__LOGIN_RETRIES);
		createEAttribute(aixLocalUserEClass, AIX_LOCAL_USER__LOGIN_TIMES);
		createEAttribute(aixLocalUserEClass, AIX_LOCAL_USER__MAX_CHAR_REPEATS);
		createEAttribute(aixLocalUserEClass, AIX_LOCAL_USER__MAX_PASSWORD_AGE_IN_WEEKS);
		createEAttribute(aixLocalUserEClass, AIX_LOCAL_USER__MAX_PASSWORD_VALID_WEEKS);
		createEAttribute(aixLocalUserEClass, AIX_LOCAL_USER__MIN_ALPHA_CHARS_IN_PASSWORD);
		createEAttribute(aixLocalUserEClass, AIX_LOCAL_USER__MIN_DIFF_CHARS);
		createEAttribute(aixLocalUserEClass, AIX_LOCAL_USER__MIN_OTHER_CHARS_IN_PASSWORD);
		createEAttribute(aixLocalUserEClass, AIX_LOCAL_USER__MIN_PASSWORD_AGE_IN_WEEKS);
		createEAttribute(aixLocalUserEClass, AIX_LOCAL_USER__MIN_PASSWORD_LENGTH);
		createEAttribute(aixLocalUserEClass, AIX_LOCAL_USER__NOT_REUSABLE_NUMBER_OF_PASSWORDS);
		createEAttribute(aixLocalUserEClass, AIX_LOCAL_USER__PASS_REUSE_NOT_ALLOWED_IN_WEEKS);
		createEAttribute(aixLocalUserEClass, AIX_LOCAL_USER__PASSWORD_CHANGE_WARN_TIME);
		createEAttribute(aixLocalUserEClass, AIX_LOCAL_USER__PASSWORD_NEVER_EXPIRES);
		createEAttribute(aixLocalUserEClass, AIX_LOCAL_USER__PRIMARY_AUTH_METHOD);
		createEAttribute(aixLocalUserEClass, AIX_LOCAL_USER__REMOTE_LOGIN_IS_ALLOWED);
		createEAttribute(aixLocalUserEClass, AIX_LOCAL_USER__SECONDARY_AUTH_METHOD);
		createEAttribute(aixLocalUserEClass, AIX_LOCAL_USER__SHELL);
		createEAttribute(aixLocalUserEClass, AIX_LOCAL_USER__SU_GROUPS_ALLOWED);
		createEAttribute(aixLocalUserEClass, AIX_LOCAL_USER__SU_IS_ALLOWED);
		createEAttribute(aixLocalUserEClass, AIX_LOCAL_USER__TIME_LAST_LOGIN);
		createEAttribute(aixLocalUserEClass, AIX_LOCAL_USER__USER_CANNOT_CHANGE_PASSWORD);
		createEAttribute(aixLocalUserEClass, AIX_LOCAL_USER__USER_NAME);
		createEAttribute(aixLocalUserEClass, AIX_LOCAL_USER__USER_REGISTERING_METHOD);
		createEAttribute(aixLocalUserEClass, AIX_LOCAL_USER__USER_SID);
		createEAttribute(aixLocalUserEClass, AIX_LOCAL_USER__USUCCESSFUL_LOGIN_COUNT);

		aixLocalUserUnitEClass = createEClass(AIX_LOCAL_USER_UNIT);

		aixOperatingSystemEClass = createEClass(AIX_OPERATING_SYSTEM);
		createEAttribute(aixOperatingSystemEClass, AIX_OPERATING_SYSTEM__DESKTOP);
		createEAttribute(aixOperatingSystemEClass, AIX_OPERATING_SYSTEM__INSTALL_DATE);
		createEAttribute(aixOperatingSystemEClass, AIX_OPERATING_SYSTEM__KERNEL);
		createEAttribute(aixOperatingSystemEClass, AIX_OPERATING_SYSTEM__LAST_BOOT_UP_TIME);
		createEAttribute(aixOperatingSystemEClass, AIX_OPERATING_SYSTEM__OWNER);
		createEAttribute(aixOperatingSystemEClass, AIX_OPERATING_SYSTEM__TCB);

		aixOperatingSystemUnitEClass = createEClass(AIX_OPERATING_SYSTEM_UNIT);

		dataFileEClass = createEClass(DATA_FILE);

		dataFileUnitEClass = createEClass(DATA_FILE_UNIT);

		directoryEClass = createEClass(DIRECTORY);
		createEAttribute(directoryEClass, DIRECTORY__DIRECTORY_PATH);

		directoryUnitEClass = createEClass(DIRECTORY_UNIT);

		fileSystemEClass = createEClass(FILE_SYSTEM);
		createEAttribute(fileSystemEClass, FILE_SYSTEM__AVAILABLE_SPACE);
		createEAttribute(fileSystemEClass, FILE_SYSTEM__CAPACITY);
		createEAttribute(fileSystemEClass, FILE_SYSTEM__MOUNT_POINT);
		createEAttribute(fileSystemEClass, FILE_SYSTEM__TYPE);

		fileSystemContentEClass = createEClass(FILE_SYSTEM_CONTENT);
		createEAttribute(fileSystemContentEClass, FILE_SYSTEM_CONTENT__FIXED_PATH);
		createEAttribute(fileSystemContentEClass, FILE_SYSTEM_CONTENT__GROUP);
		createEAttribute(fileSystemContentEClass, FILE_SYSTEM_CONTENT__LAST_MODIFIED);
		createEAttribute(fileSystemContentEClass, FILE_SYSTEM_CONTENT__OWNER);
		createEAttribute(fileSystemContentEClass, FILE_SYSTEM_CONTENT__PERMISSIONS);
		createEAttribute(fileSystemContentEClass, FILE_SYSTEM_CONTENT__REAL_FILE);
		createEAttribute(fileSystemContentEClass, FILE_SYSTEM_CONTENT__SIZE);
		createEAttribute(fileSystemContentEClass, FILE_SYSTEM_CONTENT__URI);

		fileSystemContentUnitEClass = createEClass(FILE_SYSTEM_CONTENT_UNIT);

		fileSystemUnitEClass = createEClass(FILE_SYSTEM_UNIT);

		linuxLocalGroupEClass = createEClass(LINUX_LOCAL_GROUP);
		createEAttribute(linuxLocalGroupEClass, LINUX_LOCAL_GROUP__GROUP_DESCRIPTION);

		linuxLocalGroupUnitEClass = createEClass(LINUX_LOCAL_GROUP_UNIT);

		linuxLocalServiceEClass = createEClass(LINUX_LOCAL_SERVICE);
		createEAttribute(linuxLocalServiceEClass, LINUX_LOCAL_SERVICE__EXECUTABLE_PATH);
		createEAttribute(linuxLocalServiceEClass, LINUX_LOCAL_SERVICE__SERVICE_ACCOUNT);
		createEAttribute(linuxLocalServiceEClass, LINUX_LOCAL_SERVICE__SERVICE_DESCRIPTION);
		createEAttribute(linuxLocalServiceEClass, LINUX_LOCAL_SERVICE__SERVICE_NAME);
		createEAttribute(linuxLocalServiceEClass, LINUX_LOCAL_SERVICE__SERVICE_STATUS);
		createEAttribute(linuxLocalServiceEClass, LINUX_LOCAL_SERVICE__STARTUP_RUN_LEVEL_FIVE);
		createEAttribute(linuxLocalServiceEClass, LINUX_LOCAL_SERVICE__STARTUP_RUN_LEVEL_FOUR);
		createEAttribute(linuxLocalServiceEClass, LINUX_LOCAL_SERVICE__STARTUP_RUN_LEVEL_ONE);
		createEAttribute(linuxLocalServiceEClass, LINUX_LOCAL_SERVICE__STARTUP_RUN_LEVEL_SIX);
		createEAttribute(linuxLocalServiceEClass, LINUX_LOCAL_SERVICE__STARTUP_RUN_LEVEL_THREE);
		createEAttribute(linuxLocalServiceEClass, LINUX_LOCAL_SERVICE__STARTUP_RUN_LEVEL_TWO);
		createEAttribute(linuxLocalServiceEClass, LINUX_LOCAL_SERVICE__STARTUP_RUN_LEVEL_ZERO);
		createEAttribute(linuxLocalServiceEClass, LINUX_LOCAL_SERVICE__STARTUP_TYPE);

		linuxLocalServiceUnitEClass = createEClass(LINUX_LOCAL_SERVICE_UNIT);

		linuxLocalUserEClass = createEClass(LINUX_LOCAL_USER);
		createEAttribute(linuxLocalUserEClass, LINUX_LOCAL_USER__ACCOUNT_DESCRIPTION);
		createEAttribute(linuxLocalUserEClass, LINUX_LOCAL_USER__ACCOUNT_DISABLED);
		createEAttribute(linuxLocalUserEClass, LINUX_LOCAL_USER__CHANGE_PASSWORD_NEXT_LOGON);
		createEAttribute(linuxLocalUserEClass, LINUX_LOCAL_USER__FULL_NAME);
		createEAttribute(linuxLocalUserEClass, LINUX_LOCAL_USER__HOME_DIR);
		createEAttribute(linuxLocalUserEClass, LINUX_LOCAL_USER__PASSWORD_NEVER_EXPIRES);
		createEAttribute(linuxLocalUserEClass, LINUX_LOCAL_USER__SHELL);
		createEAttribute(linuxLocalUserEClass, LINUX_LOCAL_USER__USER_CANNOT_CHANGE_PASSWORD);
		createEAttribute(linuxLocalUserEClass, LINUX_LOCAL_USER__USER_NAME);

		linuxLocalUserUnitEClass = createEClass(LINUX_LOCAL_USER_UNIT);

		linuxOperatingSystemEClass = createEClass(LINUX_OPERATING_SYSTEM);
		createEAttribute(linuxOperatingSystemEClass, LINUX_OPERATING_SYSTEM__KERNEL_RELEASE);

		linuxOperatingSystemUnitEClass = createEClass(LINUX_OPERATING_SYSTEM_UNIT);

		localFileSystemEClass = createEClass(LOCAL_FILE_SYSTEM);

		localFileSystemUnitEClass = createEClass(LOCAL_FILE_SYSTEM_UNIT);

		nfsFileSystemEClass = createEClass(NFS_FILE_SYSTEM);

		nfsFileSystemUnitEClass = createEClass(NFS_FILE_SYSTEM_UNIT);

		openVmsFileSystemEClass = createEClass(OPEN_VMS_FILE_SYSTEM);

		openVmsFileSystemUnitEClass = createEClass(OPEN_VMS_FILE_SYSTEM_UNIT);

		operatingSystemEClass = createEClass(OPERATING_SYSTEM);
		createEAttribute(operatingSystemEClass, OPERATING_SYSTEM__FQDN);
		createEAttribute(operatingSystemEClass, OPERATING_SYSTEM__HOSTNAME);
		createEAttribute(operatingSystemEClass, OPERATING_SYSTEM__KERNEL_ARCHITECTURE);
		createEAttribute(operatingSystemEClass, OPERATING_SYSTEM__KERNEL_VERSION);
		createEAttribute(operatingSystemEClass, OPERATING_SYSTEM__KERNEL_WIDTH);
		createEAttribute(operatingSystemEClass, OPERATING_SYSTEM__LOCALE);
		createEAttribute(operatingSystemEClass, OPERATING_SYSTEM__MANUFACTURER);
		createEAttribute(operatingSystemEClass, OPERATING_SYSTEM__OS_DISTRIBUTION);
		createEAttribute(operatingSystemEClass, OPERATING_SYSTEM__OS_SERVICEPACK);
		createEAttribute(operatingSystemEClass, OPERATING_SYSTEM__OS_TYPE);
		createEAttribute(operatingSystemEClass, OPERATING_SYSTEM__OS_VERSION);
		createEAttribute(operatingSystemEClass, OPERATING_SYSTEM__TIME_ZONE);

		operatingSystemRootEClass = createEClass(OPERATING_SYSTEM_ROOT);
		createEAttribute(operatingSystemRootEClass, OPERATING_SYSTEM_ROOT__MIXED);
		createEReference(operatingSystemRootEClass, OPERATING_SYSTEM_ROOT__XMLNS_PREFIX_MAP);
		createEReference(operatingSystemRootEClass, OPERATING_SYSTEM_ROOT__XSI_SCHEMA_LOCATION);
		createEReference(operatingSystemRootEClass, OPERATING_SYSTEM_ROOT__CAPABILITY_AIX_LOCAL_GROUP);
		createEReference(operatingSystemRootEClass,
				OPERATING_SYSTEM_ROOT__CAPABILITY_AIX_LOCAL_SERVICE);
		createEReference(operatingSystemRootEClass, OPERATING_SYSTEM_ROOT__CAPABILITY_AIX_LOCAL_USER);
		createEReference(operatingSystemRootEClass,
				OPERATING_SYSTEM_ROOT__CAPABILITY_AIX_OPERATING_SYSTEM);
		createEReference(operatingSystemRootEClass, OPERATING_SYSTEM_ROOT__CAPABILITY_DATA_FILE);
		createEReference(operatingSystemRootEClass, OPERATING_SYSTEM_ROOT__CAPABILITY_DIRECTORY);
		createEReference(operatingSystemRootEClass, OPERATING_SYSTEM_ROOT__CAPABILITY_FILE_SYSTEM);
		createEReference(operatingSystemRootEClass,
				OPERATING_SYSTEM_ROOT__CAPABILITY_FILE_SYSTEM_CONTENT);
		createEReference(operatingSystemRootEClass,
				OPERATING_SYSTEM_ROOT__CAPABILITY_LINUX_LOCAL_GROUP);
		createEReference(operatingSystemRootEClass,
				OPERATING_SYSTEM_ROOT__CAPABILITY_LINUX_LOCAL_SERVICE);
		createEReference(operatingSystemRootEClass,
				OPERATING_SYSTEM_ROOT__CAPABILITY_LINUX_LOCAL_USER);
		createEReference(operatingSystemRootEClass,
				OPERATING_SYSTEM_ROOT__CAPABILITY_LINUX_OPERATING_SYSTEM);
		createEReference(operatingSystemRootEClass,
				OPERATING_SYSTEM_ROOT__CAPABILITY_LOCAL_FILE_SYSTEM);
		createEReference(operatingSystemRootEClass, OPERATING_SYSTEM_ROOT__CAPABILITY_NFS_FILE_SYSTEM);
		createEReference(operatingSystemRootEClass,
				OPERATING_SYSTEM_ROOT__CAPABILITY_OPEN_VMS_FILE_SYSTEM);
		createEReference(operatingSystemRootEClass,
				OPERATING_SYSTEM_ROOT__CAPABILITY_OPERATING_SYSTEM);
		createEReference(operatingSystemRootEClass, OPERATING_SYSTEM_ROOT__CAPABILITY_PORT);
		createEReference(operatingSystemRootEClass, OPERATING_SYSTEM_ROOT__CAPABILITY_PORT_CONSUMER);
		createEReference(operatingSystemRootEClass,
				OPERATING_SYSTEM_ROOT__CAPABILITY_REDHAT_LINUX_LOCAL_GROUP);
		createEReference(operatingSystemRootEClass,
				OPERATING_SYSTEM_ROOT__CAPABILITY_REDHAT_LINUX_LOCAL_SERVICE);
		createEReference(operatingSystemRootEClass,
				OPERATING_SYSTEM_ROOT__CAPABILITY_REDHAT_LINUX_LOCAL_USER);
		createEReference(operatingSystemRootEClass,
				OPERATING_SYSTEM_ROOT__CAPABILITY_REDHAT_LINUX_OPERATING_SYSTEM);
		createEReference(operatingSystemRootEClass,
				OPERATING_SYSTEM_ROOT__CAPABILITY_REMOTE_FILE_SYSTEM);
		createEReference(operatingSystemRootEClass, OPERATING_SYSTEM_ROOT__CAPABILITY_SMB_FILE_SYSTEM);
		createEReference(operatingSystemRootEClass,
				OPERATING_SYSTEM_ROOT__CAPABILITY_SOLARIS_FILE_SYSTEM);
		createEReference(operatingSystemRootEClass,
				OPERATING_SYSTEM_ROOT__CAPABILITY_SUSE_LINUX_LOCAL_GROUP);
		createEReference(operatingSystemRootEClass,
				OPERATING_SYSTEM_ROOT__CAPABILITY_SUSE_LINUX_LOCAL_SERVICE);
		createEReference(operatingSystemRootEClass,
				OPERATING_SYSTEM_ROOT__CAPABILITY_SUSE_LINUX_LOCAL_USER);
		createEReference(operatingSystemRootEClass,
				OPERATING_SYSTEM_ROOT__CAPABILITY_SUSE_LINUX_OPERATING_SYSTEM);
		createEReference(operatingSystemRootEClass, OPERATING_SYSTEM_ROOT__CAPABILITY_UNIX_DIRECTORY);
		createEReference(operatingSystemRootEClass,
				OPERATING_SYSTEM_ROOT__CAPABILITY_UNIX_FILE_SYSTEM);
		createEReference(operatingSystemRootEClass, OPERATING_SYSTEM_ROOT__CAPABILITY_USER);
		createEReference(operatingSystemRootEClass, OPERATING_SYSTEM_ROOT__CAPABILITY_USER_GROUP);
		createEReference(operatingSystemRootEClass,
				OPERATING_SYSTEM_ROOT__CAPABILITY_WINDOWS_DIRECTORY);
		createEReference(operatingSystemRootEClass,
				OPERATING_SYSTEM_ROOT__CAPABILITY_WINDOWS_FILE_SYSTEM);
		createEReference(operatingSystemRootEClass,
				OPERATING_SYSTEM_ROOT__CAPABILITY_WINDOWS_LOCAL_GROUP);
		createEReference(operatingSystemRootEClass,
				OPERATING_SYSTEM_ROOT__CAPABILITY_WINDOWS_LOCAL_SERVICE);
		createEReference(operatingSystemRootEClass,
				OPERATING_SYSTEM_ROOT__CAPABILITY_WINDOWS_LOCAL_USER);
		createEReference(operatingSystemRootEClass,
				OPERATING_SYSTEM_ROOT__CAPABILITY_WINDOWS_OPERATING_SYSTEM);
		createEReference(operatingSystemRootEClass, OPERATING_SYSTEM_ROOT__UNIT_AIX_LOCAL_GROUP);
		createEReference(operatingSystemRootEClass,
				OPERATING_SYSTEM_ROOT__UNIT_AIX_LOCAL_SERVICE_UNIT);
		createEReference(operatingSystemRootEClass, OPERATING_SYSTEM_ROOT__UNIT_AIX_LOCAL_USER);
		createEReference(operatingSystemRootEClass,
				OPERATING_SYSTEM_ROOT__UNIT_AIX_OPERATING_SYSTEM_UNIT);
		createEReference(operatingSystemRootEClass, OPERATING_SYSTEM_ROOT__UNIT_DATA_FILE_UNIT);
		createEReference(operatingSystemRootEClass, OPERATING_SYSTEM_ROOT__UNIT_DIRECTORY_UNIT);
		createEReference(operatingSystemRootEClass,
				OPERATING_SYSTEM_ROOT__UNIT_FILE_SYSTEM_CONTENT_UNIT);
		createEReference(operatingSystemRootEClass, OPERATING_SYSTEM_ROOT__UNIT_FILE_SYSTEM_UNIT);
		createEReference(operatingSystemRootEClass, OPERATING_SYSTEM_ROOT__UNIT_LINUX_LOCAL_GROUP);
		createEReference(operatingSystemRootEClass,
				OPERATING_SYSTEM_ROOT__UNIT_LINUX_LOCAL_SERVICE_UNIT);
		createEReference(operatingSystemRootEClass, OPERATING_SYSTEM_ROOT__UNIT_LINUX_LOCAL_USER);
		createEReference(operatingSystemRootEClass,
				OPERATING_SYSTEM_ROOT__UNIT_LINUX_OPERATING_SYSTEM_UNIT);
		createEReference(operatingSystemRootEClass,
				OPERATING_SYSTEM_ROOT__UNIT_LOCAL_FILE_SYSTEM_UNIT);
		createEReference(operatingSystemRootEClass, OPERATING_SYSTEM_ROOT__UNIT_NFS_FILE_SYSTEM_UNIT);
		createEReference(operatingSystemRootEClass,
				OPERATING_SYSTEM_ROOT__UNIT_OPEN_VMS_FILE_SYSTEM_UNIT);
		createEReference(operatingSystemRootEClass, OPERATING_SYSTEM_ROOT__UNIT_OPERATING_SYSTEM_UNIT);
		createEReference(operatingSystemRootEClass, OPERATING_SYSTEM_ROOT__UNIT_PORT_CONFIG_UNIT);
		createEReference(operatingSystemRootEClass,
				OPERATING_SYSTEM_ROOT__UNIT_REMOTE_FILE_SYSTEM_UNIT);
		createEReference(operatingSystemRootEClass, OPERATING_SYSTEM_ROOT__UNIT_SMB_FILE_SYSTEM_UNIT);
		createEReference(operatingSystemRootEClass,
				OPERATING_SYSTEM_ROOT__UNIT_SOLARIS_FILE_SYSTEM_UNIT);
		createEReference(operatingSystemRootEClass, OPERATING_SYSTEM_ROOT__UNIT_UNIX_FILE_SYSTEM_UNIT);
		createEReference(operatingSystemRootEClass, OPERATING_SYSTEM_ROOT__UNIT_USER);
		createEReference(operatingSystemRootEClass, OPERATING_SYSTEM_ROOT__UNIT_USER_GROUP);
		createEReference(operatingSystemRootEClass,
				OPERATING_SYSTEM_ROOT__UNIT_WINDOWS_FILE_SYSTEM_UNIT);
		createEReference(operatingSystemRootEClass, OPERATING_SYSTEM_ROOT__UNIT_WINDOWS_LOCAL_GROUP);
		createEReference(operatingSystemRootEClass,
				OPERATING_SYSTEM_ROOT__UNIT_WINDOWS_LOCAL_SERVICE_UNIT);
		createEReference(operatingSystemRootEClass, OPERATING_SYSTEM_ROOT__UNIT_WINDOWS_LOCAL_USER);
		createEReference(operatingSystemRootEClass,
				OPERATING_SYSTEM_ROOT__UNIT_WINDOWS_OPERATING_SYSTEM_UNIT);

		operatingSystemUnitEClass = createEClass(OPERATING_SYSTEM_UNIT);

		portEClass = createEClass(PORT);
		createEAttribute(portEClass, PORT__APPLICATION_LAYER_PROTOCOL);
		createEAttribute(portEClass, PORT__IP_ADDRESS_OR_HOSTNAME);
		createEAttribute(portEClass, PORT__PORT);
		createEAttribute(portEClass, PORT__PORT_NAME);
		createEAttribute(portEClass, PORT__TRANSPORT_LAYER_PROTOCOL);

		portConfigUnitEClass = createEClass(PORT_CONFIG_UNIT);

		portConsumerEClass = createEClass(PORT_CONSUMER);

		redhatLinuxLocalGroupEClass = createEClass(REDHAT_LINUX_LOCAL_GROUP);
		createEAttribute(redhatLinuxLocalGroupEClass, REDHAT_LINUX_LOCAL_GROUP__GROUP_SID);

		redhatLinuxLocalServiceEClass = createEClass(REDHAT_LINUX_LOCAL_SERVICE);

		redhatLinuxLocalUserEClass = createEClass(REDHAT_LINUX_LOCAL_USER);
		createEAttribute(redhatLinuxLocalUserEClass,
				REDHAT_LINUX_LOCAL_USER__ACCOUNT_DISABLE_AFTER_DAYS);
		createEAttribute(redhatLinuxLocalUserEClass, REDHAT_LINUX_LOCAL_USER__ACCOUNT_DISABLE_DATE);
		createEAttribute(redhatLinuxLocalUserEClass,
				REDHAT_LINUX_LOCAL_USER__DAYS_BEFORE_PASSWORD_MAY_CHANGE);
		createEAttribute(redhatLinuxLocalUserEClass, REDHAT_LINUX_LOCAL_USER__LAST_PASSWORD_CHANGE);
		createEAttribute(redhatLinuxLocalUserEClass,
				REDHAT_LINUX_LOCAL_USER__PASSWORD_EXPIRE_AFTER_DAYS);
		createEAttribute(redhatLinuxLocalUserEClass,
				REDHAT_LINUX_LOCAL_USER__PASSWORD_EXPIRE_WARNING_DAYS);
		createEAttribute(redhatLinuxLocalUserEClass, REDHAT_LINUX_LOCAL_USER__USER_SID);

		redhatLinuxOperatingSystemEClass = createEClass(REDHAT_LINUX_OPERATING_SYSTEM);
		createEAttribute(redhatLinuxOperatingSystemEClass, REDHAT_LINUX_OPERATING_SYSTEM__BOOT_LOADER);
		createEAttribute(redhatLinuxOperatingSystemEClass, REDHAT_LINUX_OPERATING_SYSTEM__DESKTOP);
		createEAttribute(redhatLinuxOperatingSystemEClass,
				REDHAT_LINUX_OPERATING_SYSTEM__INSTALL_DATE);
		createEAttribute(redhatLinuxOperatingSystemEClass,
				REDHAT_LINUX_OPERATING_SYSTEM__LAST_BOOT_UP_TIME);
		createEAttribute(redhatLinuxOperatingSystemEClass, REDHAT_LINUX_OPERATING_SYSTEM__OWNER);
		createEAttribute(redhatLinuxOperatingSystemEClass,
				REDHAT_LINUX_OPERATING_SYSTEM__PRODUCT_TYPE);
		createEAttribute(redhatLinuxOperatingSystemEClass,
				REDHAT_LINUX_OPERATING_SYSTEM__SE_LINUX_STATE);

		remoteFileSystemEClass = createEClass(REMOTE_FILE_SYSTEM);
		createEAttribute(remoteFileSystemEClass, REMOTE_FILE_SYSTEM__EXPORT_NAME);
		createEAttribute(remoteFileSystemEClass, REMOTE_FILE_SYSTEM__SERVER_NAME);

		remoteFileSystemUnitEClass = createEClass(REMOTE_FILE_SYSTEM_UNIT);

		smbFileSystemEClass = createEClass(SMB_FILE_SYSTEM);

		smbFileSystemUnitEClass = createEClass(SMB_FILE_SYSTEM_UNIT);

		solarisFileSystemEClass = createEClass(SOLARIS_FILE_SYSTEM);

		solarisFileSystemUnitEClass = createEClass(SOLARIS_FILE_SYSTEM_UNIT);

		suseLinuxLocalGroupEClass = createEClass(SUSE_LINUX_LOCAL_GROUP);
		createEAttribute(suseLinuxLocalGroupEClass, SUSE_LINUX_LOCAL_GROUP__GROUP_ID);

		suseLinuxLocalServiceEClass = createEClass(SUSE_LINUX_LOCAL_SERVICE);

		suseLinuxLocalUserEClass = createEClass(SUSE_LINUX_LOCAL_USER);

		suseLinuxOperatingSystemEClass = createEClass(SUSE_LINUX_OPERATING_SYSTEM);
		createEAttribute(suseLinuxOperatingSystemEClass, SUSE_LINUX_OPERATING_SYSTEM__BOOT_LOADER);
		createEAttribute(suseLinuxOperatingSystemEClass, SUSE_LINUX_OPERATING_SYSTEM__DESKTOP);
		createEAttribute(suseLinuxOperatingSystemEClass,
				SUSE_LINUX_OPERATING_SYSTEM__LAST_BOOT_UP_DATE);

		unixDirectoryEClass = createEClass(UNIX_DIRECTORY);

		unixFileSystemEClass = createEClass(UNIX_FILE_SYSTEM);

		unixFileSystemUnitEClass = createEClass(UNIX_FILE_SYSTEM_UNIT);

		userEClass = createEClass(USER);
		createEAttribute(userEClass, USER__USER_ID);
		createEAttribute(userEClass, USER__USER_PASSWORD);

		userGroupEClass = createEClass(USER_GROUP);
		createEAttribute(userGroupEClass, USER_GROUP__GROUP_NAME);

		userGroupUnitEClass = createEClass(USER_GROUP_UNIT);

		userUnitEClass = createEClass(USER_UNIT);

		windowsDirectoryEClass = createEClass(WINDOWS_DIRECTORY);

		windowsFileSystemEClass = createEClass(WINDOWS_FILE_SYSTEM);

		windowsFileSystemUnitEClass = createEClass(WINDOWS_FILE_SYSTEM_UNIT);

		windowsLocalGroupEClass = createEClass(WINDOWS_LOCAL_GROUP);
		createEAttribute(windowsLocalGroupEClass, WINDOWS_LOCAL_GROUP__DESCRIPTION1);
		createEAttribute(windowsLocalGroupEClass, WINDOWS_LOCAL_GROUP__GROUP_SID);

		windowsLocalGroupUnitEClass = createEClass(WINDOWS_LOCAL_GROUP_UNIT);

		windowsLocalServiceEClass = createEClass(WINDOWS_LOCAL_SERVICE);
		createEAttribute(windowsLocalServiceEClass, WINDOWS_LOCAL_SERVICE__DEPENDANT_COMPONENTS);
		createEAttribute(windowsLocalServiceEClass, WINDOWS_LOCAL_SERVICE__ERROR_CONTROL);
		createEAttribute(windowsLocalServiceEClass, WINDOWS_LOCAL_SERVICE__EXECUTABLE_PATH);
		createEAttribute(windowsLocalServiceEClass, WINDOWS_LOCAL_SERVICE__LOG_ON_AS_SYSTEM);
		createEAttribute(windowsLocalServiceEClass, WINDOWS_LOCAL_SERVICE__RUN_PROGRAM);
		createEAttribute(windowsLocalServiceEClass, WINDOWS_LOCAL_SERVICE__SERVICE_ACCOUNT);
		createEAttribute(windowsLocalServiceEClass, WINDOWS_LOCAL_SERVICE__SERVICE_ACCOUNT_PASSWORD);
		createEAttribute(windowsLocalServiceEClass, WINDOWS_LOCAL_SERVICE__SERVICE_DEPENDENCIES);
		createEAttribute(windowsLocalServiceEClass, WINDOWS_LOCAL_SERVICE__SERVICE_DESCRIPTION);
		createEAttribute(windowsLocalServiceEClass, WINDOWS_LOCAL_SERVICE__SERVICE_DISPLAY_NAME);
		createEAttribute(windowsLocalServiceEClass, WINDOWS_LOCAL_SERVICE__SERVICE_NAME);
		createEAttribute(windowsLocalServiceEClass, WINDOWS_LOCAL_SERVICE__SERVICE_STATUS);
		createEAttribute(windowsLocalServiceEClass, WINDOWS_LOCAL_SERVICE__START_PARAMS);
		createEAttribute(windowsLocalServiceEClass, WINDOWS_LOCAL_SERVICE__STARTUP_TYPE);

		windowsLocalServiceUnitEClass = createEClass(WINDOWS_LOCAL_SERVICE_UNIT);

		windowsLocalUserEClass = createEClass(WINDOWS_LOCAL_USER);
		createEAttribute(windowsLocalUserEClass, WINDOWS_LOCAL_USER__ACCOUNT_DESCRIPTION);
		createEAttribute(windowsLocalUserEClass, WINDOWS_LOCAL_USER__ACCOUNT_DISABLED);
		createEAttribute(windowsLocalUserEClass, WINDOWS_LOCAL_USER__ACCOUNT_LOCKED);
		createEAttribute(windowsLocalUserEClass, WINDOWS_LOCAL_USER__CHANGE_PASSWORD_NEXT_LOGON);
		createEAttribute(windowsLocalUserEClass, WINDOWS_LOCAL_USER__ENABLE_REMOTE_CONTROL);
		createEAttribute(windowsLocalUserEClass, WINDOWS_LOCAL_USER__FULL_NAME);
		createEAttribute(windowsLocalUserEClass, WINDOWS_LOCAL_USER__HOME_FOLDER);
		createEAttribute(windowsLocalUserEClass, WINDOWS_LOCAL_USER__LOGON_SCRIPT);
		createEAttribute(windowsLocalUserEClass, WINDOWS_LOCAL_USER__PASSWORD_NEVER_EXPIRES);
		createEAttribute(windowsLocalUserEClass, WINDOWS_LOCAL_USER__PROFILE_PATH);
		createEAttribute(windowsLocalUserEClass, WINDOWS_LOCAL_USER__USER_ACCOUNT_TYPE);
		createEAttribute(windowsLocalUserEClass, WINDOWS_LOCAL_USER__USER_CANNOT_CHANGE_PASSWORD);
		createEAttribute(windowsLocalUserEClass, WINDOWS_LOCAL_USER__USER_SID);
		createEAttribute(windowsLocalUserEClass, WINDOWS_LOCAL_USER__USER_SID_TYPE);

		windowsLocalUserUnitEClass = createEClass(WINDOWS_LOCAL_USER_UNIT);

		windowsOperatingSystemEClass = createEClass(WINDOWS_OPERATING_SYSTEM);
		createEAttribute(windowsOperatingSystemEClass, WINDOWS_OPERATING_SYSTEM__COMPANY);
		createEAttribute(windowsOperatingSystemEClass, WINDOWS_OPERATING_SYSTEM__DOMAIN_ADMIN);
		createEAttribute(windowsOperatingSystemEClass, WINDOWS_OPERATING_SYSTEM__DOMAIN_NAME);
		createEAttribute(windowsOperatingSystemEClass, WINDOWS_OPERATING_SYSTEM__DOMAIN_PASSWORD);
		createEAttribute(windowsOperatingSystemEClass, WINDOWS_OPERATING_SYSTEM__ENCRYPTION_LEVEL);
		createEAttribute(windowsOperatingSystemEClass, WINDOWS_OPERATING_SYSTEM__INSTALL_DATE);
		createEAttribute(windowsOperatingSystemEClass, WINDOWS_OPERATING_SYSTEM__LANGUAGE);
		createEAttribute(windowsOperatingSystemEClass, WINDOWS_OPERATING_SYSTEM__LANGUAGE_GROUP);
		createEAttribute(windowsOperatingSystemEClass, WINDOWS_OPERATING_SYSTEM__LAST_BOOT_UP_TIME);
		createEAttribute(windowsOperatingSystemEClass, WINDOWS_OPERATING_SYSTEM__MACHINE_OBJECT_OU);
		createEAttribute(windowsOperatingSystemEClass,
				WINDOWS_OPERATING_SYSTEM__NUMBER_OF_LICENSED_USERS);
		createEAttribute(windowsOperatingSystemEClass, WINDOWS_OPERATING_SYSTEM__OWNER);
		createEAttribute(windowsOperatingSystemEClass, WINDOWS_OPERATING_SYSTEM__PRODUCT_KEY);
		createEAttribute(windowsOperatingSystemEClass, WINDOWS_OPERATING_SYSTEM__PRODUCT_TYPE);
		createEAttribute(windowsOperatingSystemEClass, WINDOWS_OPERATING_SYSTEM__SYSTEM_DRIVE);
		createEAttribute(windowsOperatingSystemEClass, WINDOWS_OPERATING_SYSTEM__WINDOWS_DIRECTORY);
		createEAttribute(windowsOperatingSystemEClass, WINDOWS_OPERATING_SYSTEM__WORKGROUP_NAME);

		windowsOperatingSystemUnitEClass = createEClass(WINDOWS_OPERATING_SYSTEM_UNIT);

		// Create enums
		aixAuthMethodTypeEEnum = createEEnum(AIX_AUTH_METHOD_TYPE);
		aixDesktopTypeEEnum = createEEnum(AIX_DESKTOP_TYPE);
		aixUserRegisteringMethodTypeEEnum = createEEnum(AIX_USER_REGISTERING_METHOD_TYPE);
		architectureBusTypeEEnum = createEEnum(ARCHITECTURE_BUS_TYPE);
		defaultWindowsUserGroupsEEnum = createEEnum(DEFAULT_WINDOWS_USER_GROUPS);
		encryptionLevelTypeEEnum = createEEnum(ENCRYPTION_LEVEL_TYPE);
		kernelWidthTypeEEnum = createEEnum(KERNEL_WIDTH_TYPE);
		linuxServiceStartupTypeTypeEEnum = createEEnum(LINUX_SERVICE_STARTUP_TYPE_TYPE);
		linuxServiceStatusTypeEEnum = createEEnum(LINUX_SERVICE_STATUS_TYPE);
		operatingSystemTypeEEnum = createEEnum(OPERATING_SYSTEM_TYPE);
		redhatDesktopTypeEEnum = createEEnum(REDHAT_DESKTOP_TYPE);
		redhatLinuxBootLoaderTypeEEnum = createEEnum(REDHAT_LINUX_BOOT_LOADER_TYPE);
		redhatLinuxProductTypeTypeEEnum = createEEnum(REDHAT_LINUX_PRODUCT_TYPE_TYPE);
		redhatLinuxServiceStartupTypeTypeEEnum = createEEnum(REDHAT_LINUX_SERVICE_STARTUP_TYPE_TYPE);
		redhatLinuxServiceStatusTypeEEnum = createEEnum(REDHAT_LINUX_SERVICE_STATUS_TYPE);
		seLinuxStateTypeEEnum = createEEnum(SE_LINUX_STATE_TYPE);
		suseDesktopTypeEEnum = createEEnum(SUSE_DESKTOP_TYPE);
		suseLinuxBootLoaderTypeEEnum = createEEnum(SUSE_LINUX_BOOT_LOADER_TYPE);
		suseLinuxServiceStartupTypeTypeEEnum = createEEnum(SUSE_LINUX_SERVICE_STARTUP_TYPE_TYPE);
		suseLinuxServiceStatusTypeEEnum = createEEnum(SUSE_LINUX_SERVICE_STATUS_TYPE);
		transportLayerProtocolTypeEEnum = createEEnum(TRANSPORT_LAYER_PROTOCOL_TYPE);
		windowsDirectoryTypeEEnum = createEEnum(WINDOWS_DIRECTORY_TYPE);
		windowsProductTypeTypeEEnum = createEEnum(WINDOWS_PRODUCT_TYPE_TYPE);
		windowsServiceErrorControlTypeEEnum = createEEnum(WINDOWS_SERVICE_ERROR_CONTROL_TYPE);
		windowsServiceStartupTypeEEnum = createEEnum(WINDOWS_SERVICE_STARTUP_TYPE);
		windowsServiceStatusTypeEEnum = createEEnum(WINDOWS_SERVICE_STATUS_TYPE);

		// Create data types
		aixAuthMethodTypeObjectEDataType = createEDataType(AIX_AUTH_METHOD_TYPE_OBJECT);
		aixDesktopTypeObjectEDataType = createEDataType(AIX_DESKTOP_TYPE_OBJECT);
		aixUserRegisteringMethodTypeObjectEDataType = createEDataType(AIX_USER_REGISTERING_METHOD_TYPE_OBJECT);
		architectureBusTypeObjectEDataType = createEDataType(ARCHITECTURE_BUS_TYPE_OBJECT);
		defaultWindowsUserGroupsObjectEDataType = createEDataType(DEFAULT_WINDOWS_USER_GROUPS_OBJECT);
		encryptionLevelTypeObjectEDataType = createEDataType(ENCRYPTION_LEVEL_TYPE_OBJECT);
		kernelWidthTypeObjectEDataType = createEDataType(KERNEL_WIDTH_TYPE_OBJECT);
		linuxServiceStartupTypeTypeObjectEDataType = createEDataType(LINUX_SERVICE_STARTUP_TYPE_TYPE_OBJECT);
		linuxServiceStatusTypeObjectEDataType = createEDataType(LINUX_SERVICE_STATUS_TYPE_OBJECT);
		operatingSystemTypeObjectEDataType = createEDataType(OPERATING_SYSTEM_TYPE_OBJECT);
		redhatDesktopTypeObjectEDataType = createEDataType(REDHAT_DESKTOP_TYPE_OBJECT);
		redhatLinuxBootLoaderTypeObjectEDataType = createEDataType(REDHAT_LINUX_BOOT_LOADER_TYPE_OBJECT);
		redhatLinuxProductTypeTypeObjectEDataType = createEDataType(REDHAT_LINUX_PRODUCT_TYPE_TYPE_OBJECT);
		redhatLinuxServiceStartupTypeTypeObjectEDataType = createEDataType(REDHAT_LINUX_SERVICE_STARTUP_TYPE_TYPE_OBJECT);
		redhatLinuxServiceStatusTypeObjectEDataType = createEDataType(REDHAT_LINUX_SERVICE_STATUS_TYPE_OBJECT);
		seLinuxStateTypeObjectEDataType = createEDataType(SE_LINUX_STATE_TYPE_OBJECT);
		suseDesktopTypeObjectEDataType = createEDataType(SUSE_DESKTOP_TYPE_OBJECT);
		suseLinuxBootLoaderTypeObjectEDataType = createEDataType(SUSE_LINUX_BOOT_LOADER_TYPE_OBJECT);
		suseLinuxServiceStartupTypeTypeObjectEDataType = createEDataType(SUSE_LINUX_SERVICE_STARTUP_TYPE_TYPE_OBJECT);
		suseLinuxServiceStatusTypeObjectEDataType = createEDataType(SUSE_LINUX_SERVICE_STATUS_TYPE_OBJECT);
		tcpPortTypeEDataType = createEDataType(TCP_PORT_TYPE);
		transportLayerProtocolTypeObjectEDataType = createEDataType(TRANSPORT_LAYER_PROTOCOL_TYPE_OBJECT);
		udpPortTypeEDataType = createEDataType(UDP_PORT_TYPE);
		windowsDirectoryTypeObjectEDataType = createEDataType(WINDOWS_DIRECTORY_TYPE_OBJECT);
		windowsProductTypeTypeObjectEDataType = createEDataType(WINDOWS_PRODUCT_TYPE_TYPE_OBJECT);
		windowsServiceErrorControlTypeObjectEDataType = createEDataType(WINDOWS_SERVICE_ERROR_CONTROL_TYPE_OBJECT);
		windowsServiceStartupTypeObjectEDataType = createEDataType(WINDOWS_SERVICE_STARTUP_TYPE_OBJECT);
		windowsServiceStatusTypeObjectEDataType = createEDataType(WINDOWS_SERVICE_STATUS_TYPE_OBJECT);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	private boolean isInitialized = false;

	/**
	 * Complete the initialization of the package and its meta-model.  This
	 * method is guarded to have no affect on any invocation but its first.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public void initializePackageContents() {
		if (isInitialized)
			return;
		isInitialized = true;

		// Initialize package
		setName(eNAME);
		setNsPrefix(eNS_PREFIX);
		setNsURI(eNS_URI);

		// Obtain other dependent packages
		XMLTypePackage theXMLTypePackage = (XMLTypePackage) EPackage.Registry.INSTANCE
				.getEPackage(XMLTypePackage.eNS_URI);
		CorePackage theCorePackage = (CorePackage) EPackage.Registry.INSTANCE
				.getEPackage(CorePackage.eNS_URI);

		// Add supertypes to classes
		aixLocalGroupEClass.getESuperTypes().add(this.getUserGroup());
		aixLocalGroupUnitEClass.getESuperTypes().add(this.getUserGroupUnit());
		aixLocalServiceEClass.getESuperTypes().add(theCorePackage.getCapability());
		aixLocalServiceUnitEClass.getESuperTypes().add(theCorePackage.getUnit());
		aixLocalUserEClass.getESuperTypes().add(this.getUser());
		aixLocalUserUnitEClass.getESuperTypes().add(this.getUserUnit());
		aixOperatingSystemEClass.getESuperTypes().add(this.getOperatingSystem());
		aixOperatingSystemUnitEClass.getESuperTypes().add(this.getOperatingSystemUnit());
		dataFileEClass.getESuperTypes().add(this.getFileSystemContent());
		dataFileUnitEClass.getESuperTypes().add(this.getFileSystemContentUnit());
		directoryEClass.getESuperTypes().add(this.getFileSystemContent());
		directoryUnitEClass.getESuperTypes().add(this.getFileSystemContentUnit());
		fileSystemEClass.getESuperTypes().add(theCorePackage.getCapability());
		fileSystemContentEClass.getESuperTypes().add(theCorePackage.getCapability());
		fileSystemContentUnitEClass.getESuperTypes().add(theCorePackage.getUnit());
		fileSystemUnitEClass.getESuperTypes().add(theCorePackage.getUnit());
		linuxLocalGroupEClass.getESuperTypes().add(this.getUserGroup());
		linuxLocalGroupUnitEClass.getESuperTypes().add(this.getUserGroupUnit());
		linuxLocalServiceEClass.getESuperTypes().add(theCorePackage.getCapability());
		linuxLocalServiceUnitEClass.getESuperTypes().add(theCorePackage.getUnit());
		linuxLocalUserEClass.getESuperTypes().add(this.getUser());
		linuxLocalUserUnitEClass.getESuperTypes().add(this.getUserUnit());
		linuxOperatingSystemEClass.getESuperTypes().add(this.getOperatingSystem());
		linuxOperatingSystemUnitEClass.getESuperTypes().add(this.getOperatingSystemUnit());
		localFileSystemEClass.getESuperTypes().add(this.getFileSystem());
		localFileSystemUnitEClass.getESuperTypes().add(this.getFileSystemUnit());
		nfsFileSystemEClass.getESuperTypes().add(this.getRemoteFileSystem());
		nfsFileSystemUnitEClass.getESuperTypes().add(this.getRemoteFileSystemUnit());
		openVmsFileSystemEClass.getESuperTypes().add(this.getLocalFileSystem());
		openVmsFileSystemUnitEClass.getESuperTypes().add(this.getLocalFileSystemUnit());
		operatingSystemEClass.getESuperTypes().add(theCorePackage.getCapability());
		operatingSystemUnitEClass.getESuperTypes().add(theCorePackage.getUnit());
		portEClass.getESuperTypes().add(theCorePackage.getCapability());
		portConfigUnitEClass.getESuperTypes().add(theCorePackage.getUnit());
		portConsumerEClass.getESuperTypes().add(theCorePackage.getCapability());
		redhatLinuxLocalGroupEClass.getESuperTypes().add(this.getLinuxLocalGroup());
		redhatLinuxLocalServiceEClass.getESuperTypes().add(this.getLinuxLocalService());
		redhatLinuxLocalUserEClass.getESuperTypes().add(this.getLinuxLocalUser());
		redhatLinuxOperatingSystemEClass.getESuperTypes().add(this.getLinuxOperatingSystem());
		remoteFileSystemEClass.getESuperTypes().add(this.getFileSystem());
		remoteFileSystemUnitEClass.getESuperTypes().add(this.getFileSystemUnit());
		smbFileSystemEClass.getESuperTypes().add(this.getRemoteFileSystem());
		smbFileSystemUnitEClass.getESuperTypes().add(this.getRemoteFileSystemUnit());
		solarisFileSystemEClass.getESuperTypes().add(this.getUnixFileSystem());
		solarisFileSystemUnitEClass.getESuperTypes().add(this.getUnixFileSystemUnit());
		suseLinuxLocalGroupEClass.getESuperTypes().add(this.getLinuxLocalGroup());
		suseLinuxLocalServiceEClass.getESuperTypes().add(this.getLinuxLocalService());
		suseLinuxLocalUserEClass.getESuperTypes().add(this.getLinuxLocalUser());
		suseLinuxOperatingSystemEClass.getESuperTypes().add(this.getLinuxOperatingSystem());
		unixDirectoryEClass.getESuperTypes().add(this.getDirectory());
		unixFileSystemEClass.getESuperTypes().add(this.getLocalFileSystem());
		unixFileSystemUnitEClass.getESuperTypes().add(this.getLocalFileSystemUnit());
		userEClass.getESuperTypes().add(theCorePackage.getCapability());
		userGroupEClass.getESuperTypes().add(theCorePackage.getCapability());
		userGroupUnitEClass.getESuperTypes().add(theCorePackage.getUnit());
		userUnitEClass.getESuperTypes().add(theCorePackage.getUnit());
		windowsDirectoryEClass.getESuperTypes().add(this.getDirectory());
		windowsFileSystemEClass.getESuperTypes().add(this.getLocalFileSystem());
		windowsFileSystemUnitEClass.getESuperTypes().add(this.getLocalFileSystemUnit());
		windowsLocalGroupEClass.getESuperTypes().add(this.getUserGroup());
		windowsLocalGroupUnitEClass.getESuperTypes().add(this.getUserGroupUnit());
		windowsLocalServiceEClass.getESuperTypes().add(theCorePackage.getCapability());
		windowsLocalServiceUnitEClass.getESuperTypes().add(theCorePackage.getUnit());
		windowsLocalUserEClass.getESuperTypes().add(this.getUser());
		windowsLocalUserUnitEClass.getESuperTypes().add(this.getUserUnit());
		windowsOperatingSystemEClass.getESuperTypes().add(this.getOperatingSystem());
		windowsOperatingSystemUnitEClass.getESuperTypes().add(this.getOperatingSystemUnit());

		// Initialize classes and features; add operations and parameters
		initEClass(aixLocalGroupEClass, AIXLocalGroup.class,
				"AIXLocalGroup", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$
		initEAttribute(
				getAIXLocalGroup_GroupDescription(),
				theXMLTypePackage.getString(),
				"groupDescription", null, 0, 1, AIXLocalGroup.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEAttribute(
				getAIXLocalGroup_GroupSid(),
				theXMLTypePackage.getString(),
				"groupSid", null, 0, 1, AIXLocalGroup.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$

		initEClass(aixLocalGroupUnitEClass, AIXLocalGroupUnit.class,
				"AIXLocalGroupUnit", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$

		initEClass(aixLocalServiceEClass, AIXLocalService.class,
				"AIXLocalService", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$
		initEAttribute(
				getAIXLocalService_ActionType(),
				theXMLTypePackage.getString(),
				"actionType", null, 0, 1, AIXLocalService.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEAttribute(
				getAIXLocalService_ExecutablePath(),
				theXMLTypePackage.getString(),
				"executablePath", null, 0, 1, AIXLocalService.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEAttribute(
				getAIXLocalService_ServiceDescription(),
				theXMLTypePackage.getString(),
				"serviceDescription", null, 0, 1, AIXLocalService.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEAttribute(
				getAIXLocalService_StartupRunLevelEight(),
				theXMLTypePackage.getBoolean(),
				"startupRunLevelEight", null, 0, 1, AIXLocalService.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEAttribute(
				getAIXLocalService_StartupRunLevelFive(),
				theXMLTypePackage.getBoolean(),
				"startupRunLevelFive", null, 0, 1, AIXLocalService.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEAttribute(
				getAIXLocalService_StartupRunLevelFour(),
				theXMLTypePackage.getBoolean(),
				"startupRunLevelFour", null, 0, 1, AIXLocalService.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEAttribute(
				getAIXLocalService_StartupRunLevelNine(),
				theXMLTypePackage.getBoolean(),
				"startupRunLevelNine", null, 0, 1, AIXLocalService.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEAttribute(
				getAIXLocalService_StartupRunLevelOne(),
				theXMLTypePackage.getBoolean(),
				"startupRunLevelOne", null, 0, 1, AIXLocalService.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEAttribute(
				getAIXLocalService_StartupRunLevelSeven(),
				theXMLTypePackage.getBoolean(),
				"startupRunLevelSeven", null, 0, 1, AIXLocalService.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEAttribute(
				getAIXLocalService_StartupRunLevelSix(),
				theXMLTypePackage.getBoolean(),
				"startupRunLevelSix", null, 0, 1, AIXLocalService.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEAttribute(
				getAIXLocalService_StartupRunLevelThree(),
				theXMLTypePackage.getBoolean(),
				"startupRunLevelThree", null, 0, 1, AIXLocalService.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEAttribute(
				getAIXLocalService_StartupRunLevelTwo(),
				theXMLTypePackage.getBoolean(),
				"startupRunLevelTwo", null, 0, 1, AIXLocalService.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEAttribute(
				getAIXLocalService_StartupRunLevelZero(),
				theXMLTypePackage.getBoolean(),
				"startupRunLevelZero", null, 0, 1, AIXLocalService.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$

		initEClass(aixLocalServiceUnitEClass, AIXLocalServiceUnit.class,
				"AIXLocalServiceUnit", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$

		initEClass(aixLocalUserEClass, AIXLocalUser.class,
				"AIXLocalUser", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$
		initEAttribute(
				getAIXLocalUser_AccountDescription(),
				theXMLTypePackage.getString(),
				"accountDescription", null, 0, 1, AIXLocalUser.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEAttribute(
				getAIXLocalUser_AccountDisabled(),
				theXMLTypePackage.getBoolean(),
				"accountDisabled", null, 0, 1, AIXLocalUser.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEAttribute(
				getAIXLocalUser_AccountExpirationTime(),
				theXMLTypePackage.getString(),
				"accountExpirationTime", null, 0, 1, AIXLocalUser.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEAttribute(
				getAIXLocalUser_ChangePasswordNextLogon(),
				theXMLTypePackage.getBoolean(),
				"changePasswordNextLogon", null, 0, 1, AIXLocalUser.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEAttribute(
				getAIXLocalUser_FullName(),
				theXMLTypePackage.getString(),
				"fullName", null, 0, 1, AIXLocalUser.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEAttribute(
				getAIXLocalUser_HomeDir(),
				theXMLTypePackage.getString(),
				"homeDir", null, 0, 1, AIXLocalUser.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEAttribute(
				getAIXLocalUser_IsAdmin(),
				theXMLTypePackage.getBoolean(),
				"isAdmin", null, 0, 1, AIXLocalUser.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEAttribute(
				getAIXLocalUser_LoginPermitted(),
				theXMLTypePackage.getBoolean(),
				"loginPermitted", null, 0, 1, AIXLocalUser.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEAttribute(
				getAIXLocalUser_LoginRetries(),
				theXMLTypePackage.getInteger(),
				"loginRetries", null, 0, 1, AIXLocalUser.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEAttribute(
				getAIXLocalUser_LoginTimes(),
				theXMLTypePackage.getInteger(),
				"loginTimes", null, 0, 1, AIXLocalUser.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEAttribute(
				getAIXLocalUser_MaxCharRepeats(),
				theXMLTypePackage.getInteger(),
				"maxCharRepeats", null, 0, 1, AIXLocalUser.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEAttribute(
				getAIXLocalUser_MaxPasswordAgeInWeeks(),
				theXMLTypePackage.getInteger(),
				"maxPasswordAgeInWeeks", null, 0, 1, AIXLocalUser.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEAttribute(
				getAIXLocalUser_MaxPasswordValidWeeks(),
				theXMLTypePackage.getInteger(),
				"maxPasswordValidWeeks", null, 0, 1, AIXLocalUser.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEAttribute(
				getAIXLocalUser_MinAlphaCharsInPassword(),
				theXMLTypePackage.getInteger(),
				"minAlphaCharsInPassword", null, 0, 1, AIXLocalUser.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEAttribute(
				getAIXLocalUser_MinDiffChars(),
				theXMLTypePackage.getInteger(),
				"minDiffChars", null, 0, 1, AIXLocalUser.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEAttribute(
				getAIXLocalUser_MinOtherCharsInPassword(),
				theXMLTypePackage.getInteger(),
				"minOtherCharsInPassword", null, 0, 1, AIXLocalUser.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEAttribute(
				getAIXLocalUser_MinPasswordAgeInWeeks(),
				theXMLTypePackage.getInteger(),
				"minPasswordAgeInWeeks", null, 0, 1, AIXLocalUser.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEAttribute(
				getAIXLocalUser_MinPasswordLength(),
				theXMLTypePackage.getInteger(),
				"minPasswordLength", null, 0, 1, AIXLocalUser.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEAttribute(
				getAIXLocalUser_NotReusableNumberOfPasswords(),
				theXMLTypePackage.getInteger(),
				"notReusableNumberOfPasswords", null, 0, 1, AIXLocalUser.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEAttribute(
				getAIXLocalUser_PassReuseNotAllowedInWeeks(),
				theXMLTypePackage.getInteger(),
				"passReuseNotAllowedInWeeks", null, 0, 1, AIXLocalUser.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEAttribute(
				getAIXLocalUser_PasswordChangeWarnTime(),
				theXMLTypePackage.getInteger(),
				"passwordChangeWarnTime", null, 0, 1, AIXLocalUser.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEAttribute(
				getAIXLocalUser_PasswordNeverExpires(),
				theXMLTypePackage.getBoolean(),
				"passwordNeverExpires", null, 0, 1, AIXLocalUser.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEAttribute(
				getAIXLocalUser_PrimaryAuthMethod(),
				this.getAIXAuthMethodType(),
				"primaryAuthMethod", "SYSTEM", 0, 1, AIXLocalUser.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$ //$NON-NLS-2$
		initEAttribute(
				getAIXLocalUser_RemoteLoginIsAllowed(),
				theXMLTypePackage.getBoolean(),
				"remoteLoginIsAllowed", null, 0, 1, AIXLocalUser.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEAttribute(
				getAIXLocalUser_SecondaryAuthMethod(),
				this.getAIXAuthMethodType(),
				"secondaryAuthMethod", "SYSTEM", 0, 1, AIXLocalUser.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$ //$NON-NLS-2$
		initEAttribute(
				getAIXLocalUser_Shell(),
				theXMLTypePackage.getString(),
				"shell", null, 0, 1, AIXLocalUser.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEAttribute(
				getAIXLocalUser_SuGroupsAllowed(),
				theXMLTypePackage.getString(),
				"suGroupsAllowed", null, 0, 1, AIXLocalUser.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEAttribute(
				getAIXLocalUser_SuIsAllowed(),
				theXMLTypePackage.getBoolean(),
				"suIsAllowed", null, 0, 1, AIXLocalUser.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEAttribute(
				getAIXLocalUser_TimeLastLogin(),
				theXMLTypePackage.getString(),
				"timeLastLogin", null, 0, 1, AIXLocalUser.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEAttribute(
				getAIXLocalUser_UserCannotChangePassword(),
				theXMLTypePackage.getBoolean(),
				"userCannotChangePassword", null, 0, 1, AIXLocalUser.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEAttribute(
				getAIXLocalUser_UserName(),
				theXMLTypePackage.getString(),
				"userName", null, 0, 1, AIXLocalUser.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEAttribute(
				getAIXLocalUser_UserRegisteringMethod(),
				this.getAIXUserRegisteringMethodType(),
				"userRegisteringMethod", "files", 0, 1, AIXLocalUser.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$ //$NON-NLS-2$
		initEAttribute(
				getAIXLocalUser_UserSid(),
				theXMLTypePackage.getString(),
				"userSid", null, 0, 1, AIXLocalUser.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEAttribute(
				getAIXLocalUser_UsuccessfulLoginCount(),
				theXMLTypePackage.getInteger(),
				"usuccessfulLoginCount", null, 0, 1, AIXLocalUser.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$

		initEClass(aixLocalUserUnitEClass, AIXLocalUserUnit.class,
				"AIXLocalUserUnit", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$

		initEClass(aixOperatingSystemEClass, AIXOperatingSystem.class,
				"AIXOperatingSystem", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$
		initEAttribute(
				getAIXOperatingSystem_Desktop(),
				this.getAIXDesktopType(),
				"desktop", "CDE", 0, 1, AIXOperatingSystem.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$ //$NON-NLS-2$
		initEAttribute(
				getAIXOperatingSystem_InstallDate(),
				theXMLTypePackage.getString(),
				"installDate", null, 0, 1, AIXOperatingSystem.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEAttribute(
				getAIXOperatingSystem_Kernel(),
				this.getKernelWidthType(),
				"kernel", "32-bit", 0, 1, AIXOperatingSystem.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$ //$NON-NLS-2$
		initEAttribute(
				getAIXOperatingSystem_LastBootUpTime(),
				theXMLTypePackage.getString(),
				"lastBootUpTime", null, 0, 1, AIXOperatingSystem.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEAttribute(
				getAIXOperatingSystem_Owner(),
				theXMLTypePackage.getString(),
				"owner", null, 0, 1, AIXOperatingSystem.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEAttribute(
				getAIXOperatingSystem_TCB(),
				theXMLTypePackage.getBoolean(),
				"tCB", null, 0, 1, AIXOperatingSystem.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$

		initEClass(aixOperatingSystemUnitEClass, AIXOperatingSystemUnit.class,
				"AIXOperatingSystemUnit", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$

		initEClass(dataFileEClass, DataFile.class,
				"DataFile", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$

		initEClass(dataFileUnitEClass, DataFileUnit.class,
				"DataFileUnit", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$

		initEClass(directoryEClass, Directory.class,
				"Directory", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$
		initEAttribute(
				getDirectory_DirectoryPath(),
				theXMLTypePackage.getString(),
				"directoryPath", null, 0, 1, Directory.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$

		initEClass(directoryUnitEClass, DirectoryUnit.class,
				"DirectoryUnit", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$

		initEClass(fileSystemEClass, FileSystem.class,
				"FileSystem", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$
		initEAttribute(
				getFileSystem_AvailableSpace(),
				theXMLTypePackage.getLong(),
				"availableSpace", null, 0, 1, FileSystem.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEAttribute(
				getFileSystem_Capacity(),
				theXMLTypePackage.getLong(),
				"capacity", null, 0, 1, FileSystem.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEAttribute(
				getFileSystem_MountPoint(),
				theXMLTypePackage.getString(),
				"mountPoint", null, 0, 1, FileSystem.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEAttribute(
				getFileSystem_Type(),
				theXMLTypePackage.getString(),
				"type", null, 0, 1, FileSystem.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$

		initEClass(fileSystemContentEClass, FileSystemContent.class,
				"FileSystemContent", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$
		initEAttribute(
				getFileSystemContent_FixedPath(),
				theXMLTypePackage.getString(),
				"fixedPath", null, 0, 1, FileSystemContent.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEAttribute(
				getFileSystemContent_Group(),
				theXMLTypePackage.getString(),
				"group", null, 0, 1, FileSystemContent.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEAttribute(
				getFileSystemContent_LastModified(),
				theXMLTypePackage.getLong(),
				"lastModified", null, 0, 1, FileSystemContent.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEAttribute(
				getFileSystemContent_Owner(),
				theXMLTypePackage.getString(),
				"owner", null, 0, 1, FileSystemContent.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEAttribute(
				getFileSystemContent_Permissions(),
				theXMLTypePackage.getString(),
				"permissions", null, 0, 1, FileSystemContent.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEAttribute(
				getFileSystemContent_RealFile(),
				theXMLTypePackage.getString(),
				"realFile", null, 0, 1, FileSystemContent.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEAttribute(
				getFileSystemContent_Size(),
				theXMLTypePackage.getLong(),
				"size", null, 0, 1, FileSystemContent.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEAttribute(
				getFileSystemContent_URI(),
				theXMLTypePackage.getString(),
				"uRI", null, 0, 1, FileSystemContent.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$

		initEClass(fileSystemContentUnitEClass, FileSystemContentUnit.class,
				"FileSystemContentUnit", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$

		initEClass(fileSystemUnitEClass, FileSystemUnit.class,
				"FileSystemUnit", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$

		initEClass(linuxLocalGroupEClass, LinuxLocalGroup.class,
				"LinuxLocalGroup", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$
		initEAttribute(
				getLinuxLocalGroup_GroupDescription(),
				theXMLTypePackage.getString(),
				"groupDescription", null, 0, 1, LinuxLocalGroup.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$

		initEClass(linuxLocalGroupUnitEClass, LinuxLocalGroupUnit.class,
				"LinuxLocalGroupUnit", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$

		initEClass(linuxLocalServiceEClass, LinuxLocalService.class,
				"LinuxLocalService", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$
		initEAttribute(
				getLinuxLocalService_ExecutablePath(),
				theXMLTypePackage.getString(),
				"executablePath", null, 0, 1, LinuxLocalService.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEAttribute(
				getLinuxLocalService_ServiceAccount(),
				theXMLTypePackage.getString(),
				"serviceAccount", null, 0, 1, LinuxLocalService.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEAttribute(
				getLinuxLocalService_ServiceDescription(),
				theXMLTypePackage.getString(),
				"serviceDescription", null, 0, 1, LinuxLocalService.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEAttribute(
				getLinuxLocalService_ServiceName(),
				theXMLTypePackage.getString(),
				"serviceName", null, 0, 1, LinuxLocalService.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEAttribute(
				getLinuxLocalService_ServiceStatus(),
				this.getLinuxServiceStatusType(),
				"serviceStatus", "Running", 0, 1, LinuxLocalService.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$ //$NON-NLS-2$
		initEAttribute(
				getLinuxLocalService_StartupRunLevelFive(),
				theXMLTypePackage.getBoolean(),
				"startupRunLevelFive", null, 0, 1, LinuxLocalService.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEAttribute(
				getLinuxLocalService_StartupRunLevelFour(),
				theXMLTypePackage.getBoolean(),
				"startupRunLevelFour", null, 0, 1, LinuxLocalService.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEAttribute(
				getLinuxLocalService_StartupRunLevelOne(),
				theXMLTypePackage.getBoolean(),
				"startupRunLevelOne", null, 0, 1, LinuxLocalService.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEAttribute(
				getLinuxLocalService_StartupRunLevelSix(),
				theXMLTypePackage.getBoolean(),
				"startupRunLevelSix", null, 0, 1, LinuxLocalService.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEAttribute(
				getLinuxLocalService_StartupRunLevelThree(),
				theXMLTypePackage.getBoolean(),
				"startupRunLevelThree", null, 0, 1, LinuxLocalService.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEAttribute(
				getLinuxLocalService_StartupRunLevelTwo(),
				theXMLTypePackage.getBoolean(),
				"startupRunLevelTwo", null, 0, 1, LinuxLocalService.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEAttribute(
				getLinuxLocalService_StartupRunLevelZero(),
				theXMLTypePackage.getBoolean(),
				"startupRunLevelZero", null, 0, 1, LinuxLocalService.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEAttribute(
				getLinuxLocalService_StartupType(),
				this.getLinuxServiceStartupTypeType(),
				"startupType", "Automatic", 0, 1, LinuxLocalService.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$ //$NON-NLS-2$

		initEClass(linuxLocalServiceUnitEClass, LinuxLocalServiceUnit.class,
				"LinuxLocalServiceUnit", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$

		initEClass(linuxLocalUserEClass, LinuxLocalUser.class,
				"LinuxLocalUser", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$
		initEAttribute(
				getLinuxLocalUser_AccountDescription(),
				theXMLTypePackage.getString(),
				"accountDescription", null, 0, 1, LinuxLocalUser.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEAttribute(
				getLinuxLocalUser_AccountDisabled(),
				theXMLTypePackage.getBoolean(),
				"accountDisabled", null, 0, 1, LinuxLocalUser.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEAttribute(
				getLinuxLocalUser_ChangePasswordNextLogon(),
				theXMLTypePackage.getBoolean(),
				"changePasswordNextLogon", null, 0, 1, LinuxLocalUser.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEAttribute(
				getLinuxLocalUser_FullName(),
				theXMLTypePackage.getString(),
				"fullName", null, 0, 1, LinuxLocalUser.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEAttribute(
				getLinuxLocalUser_HomeDir(),
				theXMLTypePackage.getString(),
				"homeDir", null, 0, 1, LinuxLocalUser.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEAttribute(
				getLinuxLocalUser_PasswordNeverExpires(),
				theXMLTypePackage.getBoolean(),
				"passwordNeverExpires", null, 0, 1, LinuxLocalUser.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEAttribute(
				getLinuxLocalUser_Shell(),
				theXMLTypePackage.getString(),
				"shell", null, 0, 1, LinuxLocalUser.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEAttribute(
				getLinuxLocalUser_UserCannotChangePassword(),
				theXMLTypePackage.getBoolean(),
				"userCannotChangePassword", null, 0, 1, LinuxLocalUser.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEAttribute(
				getLinuxLocalUser_UserName(),
				theXMLTypePackage.getString(),
				"userName", null, 0, 1, LinuxLocalUser.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$

		initEClass(linuxLocalUserUnitEClass, LinuxLocalUserUnit.class,
				"LinuxLocalUserUnit", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$

		initEClass(linuxOperatingSystemEClass, LinuxOperatingSystem.class,
				"LinuxOperatingSystem", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$
		initEAttribute(
				getLinuxOperatingSystem_KernelRelease(),
				theXMLTypePackage.getString(),
				"kernelRelease", null, 0, 1, LinuxOperatingSystem.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$

		initEClass(linuxOperatingSystemUnitEClass, LinuxOperatingSystemUnit.class,
				"LinuxOperatingSystemUnit", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$

		initEClass(localFileSystemEClass, LocalFileSystem.class,
				"LocalFileSystem", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$

		initEClass(localFileSystemUnitEClass, LocalFileSystemUnit.class,
				"LocalFileSystemUnit", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$

		initEClass(nfsFileSystemEClass, NFSFileSystem.class,
				"NFSFileSystem", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$

		initEClass(nfsFileSystemUnitEClass, NFSFileSystemUnit.class,
				"NFSFileSystemUnit", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$

		initEClass(openVmsFileSystemEClass, OpenVmsFileSystem.class,
				"OpenVmsFileSystem", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$

		initEClass(openVmsFileSystemUnitEClass, OpenVmsFileSystemUnit.class,
				"OpenVmsFileSystemUnit", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$

		initEClass(operatingSystemEClass, OperatingSystem.class,
				"OperatingSystem", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$
		initEAttribute(
				getOperatingSystem_Fqdn(),
				theXMLTypePackage.getString(),
				"fqdn", null, 0, 1, OperatingSystem.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEAttribute(
				getOperatingSystem_Hostname(),
				theXMLTypePackage.getString(),
				"hostname", null, 0, 1, OperatingSystem.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEAttribute(
				getOperatingSystem_KernelArchitecture(),
				theXMLTypePackage.getString(),
				"kernelArchitecture", null, 0, 1, OperatingSystem.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEAttribute(
				getOperatingSystem_KernelVersion(),
				theXMLTypePackage.getString(),
				"kernelVersion", null, 0, 1, OperatingSystem.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEAttribute(
				getOperatingSystem_KernelWidth(),
				this.getKernelWidthType(),
				"kernelWidth", "32-bit", 0, 1, OperatingSystem.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$ //$NON-NLS-2$
		initEAttribute(
				getOperatingSystem_Locale(),
				theXMLTypePackage.getString(),
				"locale", null, 0, 1, OperatingSystem.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEAttribute(
				getOperatingSystem_Manufacturer(),
				theXMLTypePackage.getString(),
				"manufacturer", null, 0, 1, OperatingSystem.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEAttribute(
				getOperatingSystem_OsDistribution(),
				theXMLTypePackage.getString(),
				"osDistribution", null, 0, 1, OperatingSystem.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEAttribute(
				getOperatingSystem_OsServicepack(),
				theXMLTypePackage.getString(),
				"osServicepack", null, 0, 1, OperatingSystem.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEAttribute(
				getOperatingSystem_OsType(),
				theXMLTypePackage.getString(),
				"osType", null, 0, 1, OperatingSystem.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEAttribute(
				getOperatingSystem_OsVersion(),
				theXMLTypePackage.getString(),
				"osVersion", null, 0, 1, OperatingSystem.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEAttribute(
				getOperatingSystem_TimeZone(),
				theXMLTypePackage.getString(),
				"timeZone", null, 0, 1, OperatingSystem.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$

		initEClass(operatingSystemRootEClass, OperatingSystemRoot.class,
				"OperatingSystemRoot", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$
		initEAttribute(
				getOperatingSystemRoot_Mixed(),
				ecorePackage.getEFeatureMapEntry(),
				"mixed", null, 0, -1, null, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEReference(
				getOperatingSystemRoot_XMLNSPrefixMap(),
				ecorePackage.getEStringToStringMapEntry(),
				null,
				"xMLNSPrefixMap", null, 0, -1, null, IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEReference(
				getOperatingSystemRoot_XSISchemaLocation(),
				ecorePackage.getEStringToStringMapEntry(),
				null,
				"xSISchemaLocation", null, 0, -1, null, IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEReference(
				getOperatingSystemRoot_CapabilityAixLocalGroup(),
				this.getAIXLocalGroup(),
				null,
				"capabilityAixLocalGroup", null, 0, -2, null, IS_TRANSIENT, IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEReference(
				getOperatingSystemRoot_CapabilityAixLocalService(),
				this.getAIXLocalService(),
				null,
				"capabilityAixLocalService", null, 0, -2, null, IS_TRANSIENT, IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEReference(
				getOperatingSystemRoot_CapabilityAixLocalUser(),
				this.getAIXLocalUser(),
				null,
				"capabilityAixLocalUser", null, 0, -2, null, IS_TRANSIENT, IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEReference(
				getOperatingSystemRoot_CapabilityAixOperatingSystem(),
				this.getAIXOperatingSystem(),
				null,
				"capabilityAixOperatingSystem", null, 0, -2, null, IS_TRANSIENT, IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEReference(
				getOperatingSystemRoot_CapabilityDataFile(),
				this.getDataFile(),
				null,
				"capabilityDataFile", null, 0, -2, null, IS_TRANSIENT, IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEReference(
				getOperatingSystemRoot_CapabilityDirectory(),
				this.getDirectory(),
				null,
				"capabilityDirectory", null, 0, -2, null, IS_TRANSIENT, IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEReference(
				getOperatingSystemRoot_CapabilityFileSystem(),
				this.getFileSystem(),
				null,
				"capabilityFileSystem", null, 0, -2, null, IS_TRANSIENT, IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEReference(
				getOperatingSystemRoot_CapabilityFileSystemContent(),
				this.getFileSystemContent(),
				null,
				"capabilityFileSystemContent", null, 0, -2, null, IS_TRANSIENT, IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEReference(
				getOperatingSystemRoot_CapabilityLinuxLocalGroup(),
				this.getLinuxLocalGroup(),
				null,
				"capabilityLinuxLocalGroup", null, 0, -2, null, IS_TRANSIENT, IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEReference(
				getOperatingSystemRoot_CapabilityLinuxLocalService(),
				this.getLinuxLocalService(),
				null,
				"capabilityLinuxLocalService", null, 0, -2, null, IS_TRANSIENT, IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEReference(
				getOperatingSystemRoot_CapabilityLinuxLocalUser(),
				this.getLinuxLocalUser(),
				null,
				"capabilityLinuxLocalUser", null, 0, -2, null, IS_TRANSIENT, IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEReference(
				getOperatingSystemRoot_CapabilityLinuxOperatingSystem(),
				this.getLinuxOperatingSystem(),
				null,
				"capabilityLinuxOperatingSystem", null, 0, -2, null, IS_TRANSIENT, IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEReference(
				getOperatingSystemRoot_CapabilityLocalFileSystem(),
				this.getLocalFileSystem(),
				null,
				"capabilityLocalFileSystem", null, 0, -2, null, IS_TRANSIENT, IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEReference(
				getOperatingSystemRoot_CapabilityNFSFileSystem(),
				this.getNFSFileSystem(),
				null,
				"capabilityNFSFileSystem", null, 0, -2, null, IS_TRANSIENT, IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEReference(
				getOperatingSystemRoot_CapabilityOpenVmsFileSystem(),
				this.getOpenVmsFileSystem(),
				null,
				"capabilityOpenVmsFileSystem", null, 0, -2, null, IS_TRANSIENT, IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEReference(
				getOperatingSystemRoot_CapabilityOperatingSystem(),
				this.getOperatingSystem(),
				null,
				"capabilityOperatingSystem", null, 0, -2, null, IS_TRANSIENT, IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEReference(
				getOperatingSystemRoot_CapabilityPort(),
				this.getPort(),
				null,
				"capabilityPort", null, 0, -2, null, IS_TRANSIENT, IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEReference(
				getOperatingSystemRoot_CapabilityPortConsumer(),
				this.getPortConsumer(),
				null,
				"capabilityPortConsumer", null, 0, -2, null, IS_TRANSIENT, IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEReference(
				getOperatingSystemRoot_CapabilityRedhatLinuxLocalGroup(),
				this.getRedhatLinuxLocalGroup(),
				null,
				"capabilityRedhatLinuxLocalGroup", null, 0, -2, null, IS_TRANSIENT, IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEReference(
				getOperatingSystemRoot_CapabilityRedhatLinuxLocalService(),
				this.getRedhatLinuxLocalService(),
				null,
				"capabilityRedhatLinuxLocalService", null, 0, -2, null, IS_TRANSIENT, IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEReference(
				getOperatingSystemRoot_CapabilityRedhatLinuxLocalUser(),
				this.getRedhatLinuxLocalUser(),
				null,
				"capabilityRedhatLinuxLocalUser", null, 0, -2, null, IS_TRANSIENT, IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEReference(
				getOperatingSystemRoot_CapabilityRedhatLinuxOperatingSystem(),
				this.getRedhatLinuxOperatingSystem(),
				null,
				"capabilityRedhatLinuxOperatingSystem", null, 0, -2, null, IS_TRANSIENT, IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEReference(
				getOperatingSystemRoot_CapabilityRemoteFileSystem(),
				this.getRemoteFileSystem(),
				null,
				"capabilityRemoteFileSystem", null, 0, -2, null, IS_TRANSIENT, IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEReference(
				getOperatingSystemRoot_CapabilitySMBFileSystem(),
				this.getSMBFileSystem(),
				null,
				"capabilitySMBFileSystem", null, 0, -2, null, IS_TRANSIENT, IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEReference(
				getOperatingSystemRoot_CapabilitySolarisFileSystem(),
				this.getSolarisFileSystem(),
				null,
				"capabilitySolarisFileSystem", null, 0, -2, null, IS_TRANSIENT, IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEReference(
				getOperatingSystemRoot_CapabilitySuseLinuxLocalGroup(),
				this.getSUSELinuxLocalGroup(),
				null,
				"capabilitySuseLinuxLocalGroup", null, 0, -2, null, IS_TRANSIENT, IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEReference(
				getOperatingSystemRoot_CapabilitySuseLinuxLocalService(),
				this.getSUSELinuxLocalService(),
				null,
				"capabilitySuseLinuxLocalService", null, 0, -2, null, IS_TRANSIENT, IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEReference(
				getOperatingSystemRoot_CapabilitySuseLinuxLocalUser(),
				this.getSUSELinuxLocalUser(),
				null,
				"capabilitySuseLinuxLocalUser", null, 0, -2, null, IS_TRANSIENT, IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEReference(
				getOperatingSystemRoot_CapabilitySuseLinuxOperatingSystem(),
				this.getSUSELinuxOperatingSystem(),
				null,
				"capabilitySuseLinuxOperatingSystem", null, 0, -2, null, IS_TRANSIENT, IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEReference(
				getOperatingSystemRoot_CapabilityUnixDirectory(),
				this.getUnixDirectory(),
				null,
				"capabilityUnixDirectory", null, 0, -2, null, IS_TRANSIENT, IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEReference(
				getOperatingSystemRoot_CapabilityUnixFileSystem(),
				this.getUnixFileSystem(),
				null,
				"capabilityUnixFileSystem", null, 0, -2, null, IS_TRANSIENT, IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEReference(
				getOperatingSystemRoot_CapabilityUser(),
				this.getUser(),
				null,
				"capabilityUser", null, 0, -2, null, IS_TRANSIENT, IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEReference(
				getOperatingSystemRoot_CapabilityUserGroup(),
				this.getUserGroup(),
				null,
				"capabilityUserGroup", null, 0, -2, null, IS_TRANSIENT, IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEReference(
				getOperatingSystemRoot_CapabilityWindowsDirectory(),
				this.getWindowsDirectory(),
				null,
				"capabilityWindowsDirectory", null, 0, -2, null, IS_TRANSIENT, IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEReference(
				getOperatingSystemRoot_CapabilityWindowsFileSystem(),
				this.getWindowsFileSystem(),
				null,
				"capabilityWindowsFileSystem", null, 0, -2, null, IS_TRANSIENT, IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEReference(
				getOperatingSystemRoot_CapabilityWindowsLocalGroup(),
				this.getWindowsLocalGroup(),
				null,
				"capabilityWindowsLocalGroup", null, 0, -2, null, IS_TRANSIENT, IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEReference(
				getOperatingSystemRoot_CapabilityWindowsLocalService(),
				this.getWindowsLocalService(),
				null,
				"capabilityWindowsLocalService", null, 0, -2, null, IS_TRANSIENT, IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEReference(
				getOperatingSystemRoot_CapabilityWindowsLocalUser(),
				this.getWindowsLocalUser(),
				null,
				"capabilityWindowsLocalUser", null, 0, -2, null, IS_TRANSIENT, IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEReference(
				getOperatingSystemRoot_CapabilityWindowsOperatingSystem(),
				this.getWindowsOperatingSystem(),
				null,
				"capabilityWindowsOperatingSystem", null, 0, -2, null, IS_TRANSIENT, IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEReference(
				getOperatingSystemRoot_UnitAixLocalGroup(),
				this.getAIXLocalGroupUnit(),
				null,
				"unitAixLocalGroup", null, 0, -2, null, IS_TRANSIENT, IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEReference(
				getOperatingSystemRoot_UnitAixLocalServiceUnit(),
				this.getAIXLocalServiceUnit(),
				null,
				"unitAixLocalServiceUnit", null, 0, -2, null, IS_TRANSIENT, IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEReference(
				getOperatingSystemRoot_UnitAixLocalUser(),
				this.getAIXLocalUserUnit(),
				null,
				"unitAixLocalUser", null, 0, -2, null, IS_TRANSIENT, IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEReference(
				getOperatingSystemRoot_UnitAixOperatingSystemUnit(),
				this.getAIXOperatingSystemUnit(),
				null,
				"unitAixOperatingSystemUnit", null, 0, -2, null, IS_TRANSIENT, IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEReference(
				getOperatingSystemRoot_UnitDataFileUnit(),
				this.getDataFileUnit(),
				null,
				"unitDataFileUnit", null, 0, -2, null, IS_TRANSIENT, IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEReference(
				getOperatingSystemRoot_UnitDirectoryUnit(),
				this.getDirectoryUnit(),
				null,
				"unitDirectoryUnit", null, 0, -2, null, IS_TRANSIENT, IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEReference(
				getOperatingSystemRoot_UnitFileSystemContentUnit(),
				this.getFileSystemContentUnit(),
				null,
				"unitFileSystemContentUnit", null, 0, -2, null, IS_TRANSIENT, IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEReference(
				getOperatingSystemRoot_UnitFileSystemUnit(),
				this.getFileSystemUnit(),
				null,
				"unitFileSystemUnit", null, 0, -2, null, IS_TRANSIENT, IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEReference(
				getOperatingSystemRoot_UnitLinuxLocalGroup(),
				this.getLinuxLocalGroupUnit(),
				null,
				"unitLinuxLocalGroup", null, 0, -2, null, IS_TRANSIENT, IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEReference(
				getOperatingSystemRoot_UnitLinuxLocalServiceUnit(),
				this.getLinuxLocalServiceUnit(),
				null,
				"unitLinuxLocalServiceUnit", null, 0, -2, null, IS_TRANSIENT, IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEReference(
				getOperatingSystemRoot_UnitLinuxLocalUser(),
				this.getLinuxLocalUserUnit(),
				null,
				"unitLinuxLocalUser", null, 0, -2, null, IS_TRANSIENT, IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEReference(
				getOperatingSystemRoot_UnitLinuxOperatingSystemUnit(),
				this.getLinuxOperatingSystemUnit(),
				null,
				"unitLinuxOperatingSystemUnit", null, 0, -2, null, IS_TRANSIENT, IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEReference(
				getOperatingSystemRoot_UnitLocalFileSystemUnit(),
				this.getLocalFileSystemUnit(),
				null,
				"unitLocalFileSystemUnit", null, 0, -2, null, IS_TRANSIENT, IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEReference(
				getOperatingSystemRoot_UnitNFSFileSystemUnit(),
				this.getNFSFileSystemUnit(),
				null,
				"unitNFSFileSystemUnit", null, 0, -2, null, IS_TRANSIENT, IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEReference(
				getOperatingSystemRoot_UnitOpenVmsFileSystemUnit(),
				this.getOpenVmsFileSystemUnit(),
				null,
				"unitOpenVmsFileSystemUnit", null, 0, -2, null, IS_TRANSIENT, IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEReference(
				getOperatingSystemRoot_UnitOperatingSystemUnit(),
				this.getOperatingSystemUnit(),
				null,
				"unitOperatingSystemUnit", null, 0, -2, null, IS_TRANSIENT, IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEReference(
				getOperatingSystemRoot_UnitPortConfigUnit(),
				this.getPortConfigUnit(),
				null,
				"unitPortConfigUnit", null, 0, -2, null, IS_TRANSIENT, IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEReference(
				getOperatingSystemRoot_UnitRemoteFileSystemUnit(),
				this.getRemoteFileSystemUnit(),
				null,
				"unitRemoteFileSystemUnit", null, 0, -2, null, IS_TRANSIENT, IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEReference(
				getOperatingSystemRoot_UnitSMBFileSystemUnit(),
				this.getSMBFileSystemUnit(),
				null,
				"unitSMBFileSystemUnit", null, 0, -2, null, IS_TRANSIENT, IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEReference(
				getOperatingSystemRoot_UnitSolarisFileSystemUnit(),
				this.getSolarisFileSystemUnit(),
				null,
				"unitSolarisFileSystemUnit", null, 0, -2, null, IS_TRANSIENT, IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEReference(
				getOperatingSystemRoot_UnitUnixFileSystemUnit(),
				this.getUnixFileSystemUnit(),
				null,
				"unitUnixFileSystemUnit", null, 0, -2, null, IS_TRANSIENT, IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEReference(
				getOperatingSystemRoot_UnitUser(),
				this.getUserUnit(),
				null,
				"unitUser", null, 0, -2, null, IS_TRANSIENT, IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEReference(
				getOperatingSystemRoot_UnitUserGroup(),
				this.getUserGroupUnit(),
				null,
				"unitUserGroup", null, 0, -2, null, IS_TRANSIENT, IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEReference(
				getOperatingSystemRoot_UnitWindowsFileSystemUnit(),
				this.getWindowsFileSystemUnit(),
				null,
				"unitWindowsFileSystemUnit", null, 0, -2, null, IS_TRANSIENT, IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEReference(
				getOperatingSystemRoot_UnitWindowsLocalGroup(),
				this.getWindowsLocalGroupUnit(),
				null,
				"unitWindowsLocalGroup", null, 0, -2, null, IS_TRANSIENT, IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEReference(
				getOperatingSystemRoot_UnitWindowsLocalServiceUnit(),
				this.getWindowsLocalServiceUnit(),
				null,
				"unitWindowsLocalServiceUnit", null, 0, -2, null, IS_TRANSIENT, IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEReference(
				getOperatingSystemRoot_UnitWindowsLocalUser(),
				this.getWindowsLocalUserUnit(),
				null,
				"unitWindowsLocalUser", null, 0, -2, null, IS_TRANSIENT, IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEReference(
				getOperatingSystemRoot_UnitWindowsOperatingSystemUnit(),
				this.getWindowsOperatingSystemUnit(),
				null,
				"unitWindowsOperatingSystemUnit", null, 0, -2, null, IS_TRANSIENT, IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, IS_DERIVED, IS_ORDERED); //$NON-NLS-1$

		initEClass(operatingSystemUnitEClass, OperatingSystemUnit.class,
				"OperatingSystemUnit", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$

		initEClass(portEClass, Port.class,
				"Port", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$
		initEAttribute(
				getPort_ApplicationLayerProtocol(),
				theXMLTypePackage.getString(),
				"applicationLayerProtocol", null, 0, 1, Port.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEAttribute(
				getPort_IpAddressOrHostname(),
				theXMLTypePackage.getString(),
				"ipAddressOrHostname", null, 0, 1, Port.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEAttribute(
				getPort_Port(),
				theCorePackage.getPortType(),
				"port", null, 1, 1, Port.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEAttribute(
				getPort_PortName(),
				theXMLTypePackage.getString(),
				"portName", null, 0, 1, Port.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEAttribute(
				getPort_TransportLayerProtocol(),
				this.getTransportLayerProtocolType(),
				"transportLayerProtocol", "TCP", 0, 1, Port.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$ //$NON-NLS-2$

		initEClass(portConfigUnitEClass, PortConfigUnit.class,
				"PortConfigUnit", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$

		initEClass(portConsumerEClass, PortConsumer.class,
				"PortConsumer", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$

		initEClass(redhatLinuxLocalGroupEClass, RedhatLinuxLocalGroup.class,
				"RedhatLinuxLocalGroup", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$
		initEAttribute(
				getRedhatLinuxLocalGroup_GroupSid(),
				theXMLTypePackage.getString(),
				"groupSid", null, 0, 1, RedhatLinuxLocalGroup.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$

		initEClass(redhatLinuxLocalServiceEClass, RedhatLinuxLocalService.class,
				"RedhatLinuxLocalService", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$

		initEClass(redhatLinuxLocalUserEClass, RedhatLinuxLocalUser.class,
				"RedhatLinuxLocalUser", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$
		initEAttribute(
				getRedhatLinuxLocalUser_AccountDisableAfterDays(),
				theXMLTypePackage.getString(),
				"accountDisableAfterDays", null, 0, 1, RedhatLinuxLocalUser.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEAttribute(
				getRedhatLinuxLocalUser_AccountDisableDate(),
				theXMLTypePackage.getString(),
				"accountDisableDate", null, 0, 1, RedhatLinuxLocalUser.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEAttribute(
				getRedhatLinuxLocalUser_DaysBeforePasswordMayChange(),
				theXMLTypePackage.getString(),
				"daysBeforePasswordMayChange", null, 0, 1, RedhatLinuxLocalUser.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEAttribute(
				getRedhatLinuxLocalUser_LastPasswordChange(),
				theXMLTypePackage.getString(),
				"lastPasswordChange", null, 0, 1, RedhatLinuxLocalUser.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEAttribute(
				getRedhatLinuxLocalUser_PasswordExpireAfterDays(),
				theXMLTypePackage.getString(),
				"passwordExpireAfterDays", null, 0, 1, RedhatLinuxLocalUser.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEAttribute(
				getRedhatLinuxLocalUser_PasswordExpireWarningDays(),
				theXMLTypePackage.getString(),
				"passwordExpireWarningDays", null, 0, 1, RedhatLinuxLocalUser.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEAttribute(
				getRedhatLinuxLocalUser_UserSid(),
				theXMLTypePackage.getString(),
				"userSid", null, 0, 1, RedhatLinuxLocalUser.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$

		initEClass(redhatLinuxOperatingSystemEClass, RedhatLinuxOperatingSystem.class,
				"RedhatLinuxOperatingSystem", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$
		initEAttribute(
				getRedhatLinuxOperatingSystem_BootLoader(),
				this.getRedhatLinuxBootLoaderType(),
				"bootLoader", "GRUB", 0, 1, RedhatLinuxOperatingSystem.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$ //$NON-NLS-2$
		initEAttribute(
				getRedhatLinuxOperatingSystem_Desktop(),
				this.getRedhatDesktopType(),
				"desktop", "GNOME", 0, 1, RedhatLinuxOperatingSystem.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$ //$NON-NLS-2$
		initEAttribute(
				getRedhatLinuxOperatingSystem_InstallDate(),
				theXMLTypePackage.getString(),
				"installDate", null, 0, 1, RedhatLinuxOperatingSystem.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEAttribute(
				getRedhatLinuxOperatingSystem_LastBootUpTime(),
				theXMLTypePackage.getString(),
				"lastBootUpTime", null, 0, 1, RedhatLinuxOperatingSystem.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEAttribute(
				getRedhatLinuxOperatingSystem_Owner(),
				theXMLTypePackage.getString(),
				"owner", null, 0, 1, RedhatLinuxOperatingSystem.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEAttribute(
				getRedhatLinuxOperatingSystem_ProductType(),
				this.getRedhatLinuxProductTypeType(),
				"productType", "Server", 0, 1, RedhatLinuxOperatingSystem.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$ //$NON-NLS-2$
		initEAttribute(
				getRedhatLinuxOperatingSystem_SELinuxState(),
				this.getSELinuxStateType(),
				"sELinuxState", "disabled", 0, 1, RedhatLinuxOperatingSystem.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$ //$NON-NLS-2$

		initEClass(remoteFileSystemEClass, RemoteFileSystem.class,
				"RemoteFileSystem", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$
		initEAttribute(
				getRemoteFileSystem_ExportName(),
				theXMLTypePackage.getString(),
				"exportName", null, 0, 1, RemoteFileSystem.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEAttribute(
				getRemoteFileSystem_ServerName(),
				theXMLTypePackage.getString(),
				"serverName", null, 0, 1, RemoteFileSystem.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$

		initEClass(remoteFileSystemUnitEClass, RemoteFileSystemUnit.class,
				"RemoteFileSystemUnit", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$

		initEClass(smbFileSystemEClass, SMBFileSystem.class,
				"SMBFileSystem", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$

		initEClass(smbFileSystemUnitEClass, SMBFileSystemUnit.class,
				"SMBFileSystemUnit", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$

		initEClass(solarisFileSystemEClass, SolarisFileSystem.class,
				"SolarisFileSystem", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$

		initEClass(solarisFileSystemUnitEClass, SolarisFileSystemUnit.class,
				"SolarisFileSystemUnit", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$

		initEClass(suseLinuxLocalGroupEClass, SUSELinuxLocalGroup.class,
				"SUSELinuxLocalGroup", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$
		initEAttribute(
				getSUSELinuxLocalGroup_GroupId(),
				theXMLTypePackage.getString(),
				"groupId", null, 0, 1, SUSELinuxLocalGroup.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$

		initEClass(suseLinuxLocalServiceEClass, SUSELinuxLocalService.class,
				"SUSELinuxLocalService", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$

		initEClass(suseLinuxLocalUserEClass, SUSELinuxLocalUser.class,
				"SUSELinuxLocalUser", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$

		initEClass(suseLinuxOperatingSystemEClass, SUSELinuxOperatingSystem.class,
				"SUSELinuxOperatingSystem", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$
		initEAttribute(
				getSUSELinuxOperatingSystem_BootLoader(),
				this.getSUSELinuxBootLoaderType(),
				"bootLoader", "GRUB", 0, 1, SUSELinuxOperatingSystem.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$ //$NON-NLS-2$
		initEAttribute(
				getSUSELinuxOperatingSystem_Desktop(),
				this.getSUSEDesktopType(),
				"desktop", "GNOME", 0, 1, SUSELinuxOperatingSystem.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$ //$NON-NLS-2$
		initEAttribute(
				getSUSELinuxOperatingSystem_LastBootUpDate(),
				theXMLTypePackage.getString(),
				"lastBootUpDate", null, 0, 1, SUSELinuxOperatingSystem.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$

		initEClass(unixDirectoryEClass, UnixDirectory.class,
				"UnixDirectory", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$

		initEClass(unixFileSystemEClass, UnixFileSystem.class,
				"UnixFileSystem", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$

		initEClass(unixFileSystemUnitEClass, UnixFileSystemUnit.class,
				"UnixFileSystemUnit", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$

		initEClass(userEClass, User.class,
				"User", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$
		initEAttribute(
				getUser_UserId(),
				theXMLTypePackage.getString(),
				"userId", null, 0, 1, User.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEAttribute(
				getUser_UserPassword(),
				theXMLTypePackage.getString(),
				"userPassword", null, 0, 1, User.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$

		initEClass(userGroupEClass, UserGroup.class,
				"UserGroup", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$
		initEAttribute(
				getUserGroup_GroupName(),
				theXMLTypePackage.getString(),
				"groupName", null, 0, 1, UserGroup.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$

		initEClass(userGroupUnitEClass, UserGroupUnit.class,
				"UserGroupUnit", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$

		initEClass(userUnitEClass, UserUnit.class,
				"UserUnit", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$

		initEClass(windowsDirectoryEClass, WindowsDirectory.class,
				"WindowsDirectory", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$

		initEClass(windowsFileSystemEClass, WindowsFileSystem.class,
				"WindowsFileSystem", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$

		initEClass(windowsFileSystemUnitEClass, WindowsFileSystemUnit.class,
				"WindowsFileSystemUnit", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$

		initEClass(windowsLocalGroupEClass, WindowsLocalGroup.class,
				"WindowsLocalGroup", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$
		initEAttribute(
				getWindowsLocalGroup_Description1(),
				theXMLTypePackage.getString(),
				"description1", null, 0, 1, WindowsLocalGroup.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEAttribute(
				getWindowsLocalGroup_GroupSid(),
				theXMLTypePackage.getString(),
				"groupSid", null, 0, 1, WindowsLocalGroup.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$

		initEClass(windowsLocalGroupUnitEClass, WindowsLocalGroupUnit.class,
				"WindowsLocalGroupUnit", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$

		initEClass(windowsLocalServiceEClass, WindowsLocalService.class,
				"WindowsLocalService", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$
		initEAttribute(
				getWindowsLocalService_DependantComponents(),
				theXMLTypePackage.getString(),
				"dependantComponents", null, 0, 1, WindowsLocalService.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEAttribute(
				getWindowsLocalService_ErrorControl(),
				this.getWindowsServiceErrorControlType(),
				"errorControl", "Ignore", 0, 1, WindowsLocalService.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$ //$NON-NLS-2$
		initEAttribute(
				getWindowsLocalService_ExecutablePath(),
				theXMLTypePackage.getString(),
				"executablePath", null, 0, 1, WindowsLocalService.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEAttribute(
				getWindowsLocalService_LogOnAsSystem(),
				theXMLTypePackage.getBoolean(),
				"logOnAsSystem", null, 0, 1, WindowsLocalService.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEAttribute(
				getWindowsLocalService_RunProgram(),
				theXMLTypePackage.getString(),
				"runProgram", null, 0, 1, WindowsLocalService.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEAttribute(
				getWindowsLocalService_ServiceAccount(),
				theXMLTypePackage.getString(),
				"serviceAccount", null, 0, 1, WindowsLocalService.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEAttribute(
				getWindowsLocalService_ServiceAccountPassword(),
				theXMLTypePackage.getString(),
				"serviceAccountPassword", null, 0, 1, WindowsLocalService.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEAttribute(
				getWindowsLocalService_ServiceDependencies(),
				theXMLTypePackage.getString(),
				"serviceDependencies", null, 0, 1, WindowsLocalService.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEAttribute(
				getWindowsLocalService_ServiceDescription(),
				theXMLTypePackage.getString(),
				"serviceDescription", null, 0, 1, WindowsLocalService.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEAttribute(
				getWindowsLocalService_ServiceDisplayName(),
				theXMLTypePackage.getString(),
				"serviceDisplayName", null, 0, 1, WindowsLocalService.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEAttribute(
				getWindowsLocalService_ServiceName(),
				theXMLTypePackage.getString(),
				"serviceName", null, 0, 1, WindowsLocalService.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEAttribute(
				getWindowsLocalService_ServiceStatus(),
				this.getWindowsServiceStatusType(),
				"serviceStatus", "Running", 0, 1, WindowsLocalService.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$ //$NON-NLS-2$
		initEAttribute(
				getWindowsLocalService_StartParams(),
				theXMLTypePackage.getString(),
				"startParams", null, 0, 1, WindowsLocalService.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEAttribute(
				getWindowsLocalService_StartupType(),
				this.getWindowsServiceStartupType(),
				"startupType", "Boot", 0, 1, WindowsLocalService.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$ //$NON-NLS-2$

		initEClass(windowsLocalServiceUnitEClass, WindowsLocalServiceUnit.class,
				"WindowsLocalServiceUnit", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$

		initEClass(windowsLocalUserEClass, WindowsLocalUser.class,
				"WindowsLocalUser", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$
		initEAttribute(
				getWindowsLocalUser_AccountDescription(),
				theXMLTypePackage.getString(),
				"accountDescription", null, 0, 1, WindowsLocalUser.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEAttribute(
				getWindowsLocalUser_AccountDisabled(),
				theXMLTypePackage.getBoolean(),
				"accountDisabled", null, 0, 1, WindowsLocalUser.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEAttribute(
				getWindowsLocalUser_AccountLocked(),
				theXMLTypePackage.getBoolean(),
				"accountLocked", null, 0, 1, WindowsLocalUser.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEAttribute(
				getWindowsLocalUser_ChangePasswordNextLogon(),
				theXMLTypePackage.getBoolean(),
				"changePasswordNextLogon", null, 0, 1, WindowsLocalUser.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEAttribute(
				getWindowsLocalUser_EnableRemoteControl(),
				theXMLTypePackage.getBoolean(),
				"enableRemoteControl", null, 0, 1, WindowsLocalUser.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEAttribute(
				getWindowsLocalUser_FullName(),
				theXMLTypePackage.getString(),
				"fullName", null, 0, 1, WindowsLocalUser.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEAttribute(
				getWindowsLocalUser_HomeFolder(),
				theXMLTypePackage.getString(),
				"homeFolder", null, 0, 1, WindowsLocalUser.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEAttribute(
				getWindowsLocalUser_LogonScript(),
				theXMLTypePackage.getString(),
				"logonScript", null, 0, 1, WindowsLocalUser.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEAttribute(
				getWindowsLocalUser_PasswordNeverExpires(),
				theXMLTypePackage.getBoolean(),
				"passwordNeverExpires", null, 0, 1, WindowsLocalUser.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEAttribute(
				getWindowsLocalUser_ProfilePath(),
				theXMLTypePackage.getString(),
				"profilePath", null, 0, 1, WindowsLocalUser.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEAttribute(
				getWindowsLocalUser_UserAccountType(),
				theXMLTypePackage.getString(),
				"userAccountType", null, 0, 1, WindowsLocalUser.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEAttribute(
				getWindowsLocalUser_UserCannotChangePassword(),
				theXMLTypePackage.getBoolean(),
				"userCannotChangePassword", null, 0, 1, WindowsLocalUser.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEAttribute(
				getWindowsLocalUser_UserSid(),
				theXMLTypePackage.getString(),
				"userSid", null, 0, 1, WindowsLocalUser.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEAttribute(
				getWindowsLocalUser_UserSidType(),
				theXMLTypePackage.getString(),
				"userSidType", null, 0, 1, WindowsLocalUser.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$

		initEClass(windowsLocalUserUnitEClass, WindowsLocalUserUnit.class,
				"WindowsLocalUserUnit", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$

		initEClass(windowsOperatingSystemEClass, WindowsOperatingSystem.class,
				"WindowsOperatingSystem", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$
		initEAttribute(
				getWindowsOperatingSystem_Company(),
				theXMLTypePackage.getString(),
				"company", null, 0, 1, WindowsOperatingSystem.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEAttribute(
				getWindowsOperatingSystem_DomainAdmin(),
				theXMLTypePackage.getString(),
				"domainAdmin", null, 0, 1, WindowsOperatingSystem.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEAttribute(
				getWindowsOperatingSystem_DomainName(),
				theXMLTypePackage.getString(),
				"domainName", null, 0, 1, WindowsOperatingSystem.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEAttribute(
				getWindowsOperatingSystem_DomainPassword(),
				theXMLTypePackage.getString(),
				"domainPassword", null, 0, 1, WindowsOperatingSystem.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEAttribute(
				getWindowsOperatingSystem_EncryptionLevel(),
				this.getEncryptionLevelType(),
				"encryptionLevel", "40", 0, 1, WindowsOperatingSystem.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$ //$NON-NLS-2$
		initEAttribute(
				getWindowsOperatingSystem_InstallDate(),
				theXMLTypePackage.getString(),
				"installDate", null, 0, 1, WindowsOperatingSystem.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEAttribute(
				getWindowsOperatingSystem_Language(),
				theXMLTypePackage.getString(),
				"language", null, 0, 1, WindowsOperatingSystem.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEAttribute(
				getWindowsOperatingSystem_LanguageGroup(),
				theXMLTypePackage.getString(),
				"languageGroup", null, 0, 1, WindowsOperatingSystem.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEAttribute(
				getWindowsOperatingSystem_LastBootUpTime(),
				theXMLTypePackage.getString(),
				"lastBootUpTime", null, 0, 1, WindowsOperatingSystem.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEAttribute(
				getWindowsOperatingSystem_MachineObjectOU(),
				theXMLTypePackage.getString(),
				"machineObjectOU", null, 0, 1, WindowsOperatingSystem.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEAttribute(
				getWindowsOperatingSystem_NumberOfLicensedUsers(),
				theXMLTypePackage.getString(),
				"numberOfLicensedUsers", null, 0, 1, WindowsOperatingSystem.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEAttribute(
				getWindowsOperatingSystem_Owner(),
				theXMLTypePackage.getString(),
				"owner", null, 0, 1, WindowsOperatingSystem.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEAttribute(
				getWindowsOperatingSystem_ProductKey(),
				theXMLTypePackage.getString(),
				"productKey", null, 0, 1, WindowsOperatingSystem.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEAttribute(
				getWindowsOperatingSystem_ProductType(),
				this.getWindowsProductTypeType(),
				"productType", "Work Station", 0, 1, WindowsOperatingSystem.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$ //$NON-NLS-2$
		initEAttribute(
				getWindowsOperatingSystem_SystemDrive(),
				theXMLTypePackage.getString(),
				"systemDrive", null, 0, 1, WindowsOperatingSystem.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEAttribute(
				getWindowsOperatingSystem_WindowsDirectory(),
				this.getWindowsDirectoryType(),
				"windowsDirectory", "WINDOWS", 0, 1, WindowsOperatingSystem.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$ //$NON-NLS-2$
		initEAttribute(
				getWindowsOperatingSystem_WorkgroupName(),
				theXMLTypePackage.getString(),
				"workgroupName", null, 0, 1, WindowsOperatingSystem.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$

		initEClass(windowsOperatingSystemUnitEClass, WindowsOperatingSystemUnit.class,
				"WindowsOperatingSystemUnit", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$

		// Initialize enums and add enum literals
		initEEnum(aixAuthMethodTypeEEnum, AIXAuthMethodType.class, "AIXAuthMethodType"); //$NON-NLS-1$
		addEEnumLiteral(aixAuthMethodTypeEEnum, AIXAuthMethodType.SYSTEM_LITERAL);
		addEEnumLiteral(aixAuthMethodTypeEEnum, AIXAuthMethodType.NONE_LITERAL);
		addEEnumLiteral(aixAuthMethodTypeEEnum, AIXAuthMethodType.TOKEN_USERNAME_LITERAL);

		initEEnum(aixDesktopTypeEEnum, AIXDesktopType.class, "AIXDesktopType"); //$NON-NLS-1$
		addEEnumLiteral(aixDesktopTypeEEnum, AIXDesktopType.CDE_LITERAL);
		addEEnumLiteral(aixDesktopTypeEEnum, AIXDesktopType.NONE_LITERAL);
		addEEnumLiteral(aixDesktopTypeEEnum, AIXDesktopType.KDE_LITERAL);
		addEEnumLiteral(aixDesktopTypeEEnum, AIXDesktopType.GNOME_LITERAL);

		initEEnum(aixUserRegisteringMethodTypeEEnum, AIXUserRegisteringMethodType.class,
				"AIXUserRegisteringMethodType"); //$NON-NLS-1$
		addEEnumLiteral(aixUserRegisteringMethodTypeEEnum, AIXUserRegisteringMethodType.FILES_LITERAL);
		addEEnumLiteral(aixUserRegisteringMethodTypeEEnum, AIXUserRegisteringMethodType.NIS_LITERAL);
		addEEnumLiteral(aixUserRegisteringMethodTypeEEnum, AIXUserRegisteringMethodType.DCE_LITERAL);

		initEEnum(architectureBusTypeEEnum, ArchitectureBusType.class, "ArchitectureBusType"); //$NON-NLS-1$
		addEEnumLiteral(architectureBusTypeEEnum, ArchitectureBusType._32_BIT_LITERAL);
		addEEnumLiteral(architectureBusTypeEEnum, ArchitectureBusType._64_BIT_LITERAL);

		initEEnum(defaultWindowsUserGroupsEEnum, DefaultWindowsUserGroups.class,
				"DefaultWindowsUserGroups"); //$NON-NLS-1$
		addEEnumLiteral(defaultWindowsUserGroupsEEnum,
				DefaultWindowsUserGroups.ADMINISTRATORS_LITERAL);
		addEEnumLiteral(defaultWindowsUserGroupsEEnum,
				DefaultWindowsUserGroups.BACKUP_OPERATORS_LITERAL);
		addEEnumLiteral(defaultWindowsUserGroupsEEnum,
				DefaultWindowsUserGroups.DISTRIBUTED_COM_USERS_LITERAL);
		addEEnumLiteral(defaultWindowsUserGroupsEEnum, DefaultWindowsUserGroups.GUESTS_LITERAL);
		addEEnumLiteral(defaultWindowsUserGroupsEEnum,
				DefaultWindowsUserGroups.NETWORK_CONFIGURATION_OPERATORS_LITERAL);
		addEEnumLiteral(defaultWindowsUserGroupsEEnum, DefaultWindowsUserGroups.POWER_USERS_LITERAL);
		addEEnumLiteral(defaultWindowsUserGroupsEEnum,
				DefaultWindowsUserGroups.PRINT_OPERATORS_LITERAL);
		addEEnumLiteral(defaultWindowsUserGroupsEEnum,
				DefaultWindowsUserGroups.REMOTE_DESKTOP_USERS_LITERAL);
		addEEnumLiteral(defaultWindowsUserGroupsEEnum, DefaultWindowsUserGroups.REPLICATOR_LITERAL);
		addEEnumLiteral(defaultWindowsUserGroupsEEnum, DefaultWindowsUserGroups.USERS_LITERAL);

		initEEnum(encryptionLevelTypeEEnum, EncryptionLevelType.class, "EncryptionLevelType"); //$NON-NLS-1$
		addEEnumLiteral(encryptionLevelTypeEEnum, EncryptionLevelType._40_LITERAL);
		addEEnumLiteral(encryptionLevelTypeEEnum, EncryptionLevelType._128_LITERAL);

		initEEnum(kernelWidthTypeEEnum, KernelWidthType.class, "KernelWidthType"); //$NON-NLS-1$
		addEEnumLiteral(kernelWidthTypeEEnum, KernelWidthType._32_BIT_LITERAL);
		addEEnumLiteral(kernelWidthTypeEEnum, KernelWidthType._64_BIT_LITERAL);

		initEEnum(linuxServiceStartupTypeTypeEEnum, LinuxServiceStartupTypeType.class,
				"LinuxServiceStartupTypeType"); //$NON-NLS-1$
		addEEnumLiteral(linuxServiceStartupTypeTypeEEnum,
				LinuxServiceStartupTypeType.AUTOMATIC_LITERAL);
		addEEnumLiteral(linuxServiceStartupTypeTypeEEnum, LinuxServiceStartupTypeType.BOOT_LITERAL);
		addEEnumLiteral(linuxServiceStartupTypeTypeEEnum, LinuxServiceStartupTypeType.SYSTEM_LITERAL);
		addEEnumLiteral(linuxServiceStartupTypeTypeEEnum, LinuxServiceStartupTypeType.MANUAL_LITERAL);
		addEEnumLiteral(linuxServiceStartupTypeTypeEEnum,
				LinuxServiceStartupTypeType.DISABLED_LITERAL);

		initEEnum(linuxServiceStatusTypeEEnum, LinuxServiceStatusType.class, "LinuxServiceStatusType"); //$NON-NLS-1$
		addEEnumLiteral(linuxServiceStatusTypeEEnum, LinuxServiceStatusType.RUNNING_LITERAL);
		addEEnumLiteral(linuxServiceStatusTypeEEnum, LinuxServiceStatusType.STOPPED_LITERAL);
		addEEnumLiteral(linuxServiceStatusTypeEEnum, LinuxServiceStatusType.UNKNOWN_LITERAL);

		initEEnum(operatingSystemTypeEEnum, OperatingSystemType.class, "OperatingSystemType"); //$NON-NLS-1$
		addEEnumLiteral(operatingSystemTypeEEnum, OperatingSystemType.AIX_LITERAL);
		addEEnumLiteral(operatingSystemTypeEEnum, OperatingSystemType.WINDOWS_CYGWIN_LITERAL);
		addEEnumLiteral(operatingSystemTypeEEnum, OperatingSystemType.HPUX_LITERAL);
		addEEnumLiteral(operatingSystemTypeEEnum, OperatingSystemType.LINUX_LITERAL);
		addEEnumLiteral(operatingSystemTypeEEnum, OperatingSystemType.SOLARIS_LITERAL);
		addEEnumLiteral(operatingSystemTypeEEnum, OperatingSystemType.WINDOWS_LITERAL);
		addEEnumLiteral(operatingSystemTypeEEnum, OperatingSystemType.OPEN_MVS_LITERAL);
		addEEnumLiteral(operatingSystemTypeEEnum, OperatingSystemType.I5_OPERATING_SYSTEM_LITERAL);
		addEEnumLiteral(operatingSystemTypeEEnum, OperatingSystemType.MAC_OS_LITERAL);
		addEEnumLiteral(operatingSystemTypeEEnum, OperatingSystemType.NET_WARE_LITERAL);
		addEEnumLiteral(operatingSystemTypeEEnum, OperatingSystemType.VMWARE_ESX_LITERAL);
		addEEnumLiteral(operatingSystemTypeEEnum, OperatingSystemType.DARWIN_LITERAL);
		addEEnumLiteral(operatingSystemTypeEEnum, OperatingSystemType.TRU64_LITERAL);
		addEEnumLiteral(operatingSystemTypeEEnum, OperatingSystemType.FREE_BSD_LITERAL);
		addEEnumLiteral(operatingSystemTypeEEnum, OperatingSystemType.IPSO_LITERAL);
		addEEnumLiteral(operatingSystemTypeEEnum, OperatingSystemType.ZOS_LITERAL);
		addEEnumLiteral(operatingSystemTypeEEnum, OperatingSystemType.ZVM_LITERAL);
		addEEnumLiteral(operatingSystemTypeEEnum, OperatingSystemType.ZLINUX_LITERAL);
		addEEnumLiteral(operatingSystemTypeEEnum, OperatingSystemType.__LITERAL);

		initEEnum(redhatDesktopTypeEEnum, RedhatDesktopType.class, "RedhatDesktopType"); //$NON-NLS-1$
		addEEnumLiteral(redhatDesktopTypeEEnum, RedhatDesktopType.GNOME_LITERAL);
		addEEnumLiteral(redhatDesktopTypeEEnum, RedhatDesktopType.KDE_LITERAL);
		addEEnumLiteral(redhatDesktopTypeEEnum, RedhatDesktopType.NONE_LITERAL);

		initEEnum(redhatLinuxBootLoaderTypeEEnum, RedhatLinuxBootLoaderType.class,
				"RedhatLinuxBootLoaderType"); //$NON-NLS-1$
		addEEnumLiteral(redhatLinuxBootLoaderTypeEEnum, RedhatLinuxBootLoaderType.GRUB_LITERAL);
		addEEnumLiteral(redhatLinuxBootLoaderTypeEEnum, RedhatLinuxBootLoaderType.LILO_LITERAL);
		addEEnumLiteral(redhatLinuxBootLoaderTypeEEnum, RedhatLinuxBootLoaderType.OTHER_LITERAL);

		initEEnum(redhatLinuxProductTypeTypeEEnum, RedhatLinuxProductTypeType.class,
				"RedhatLinuxProductTypeType"); //$NON-NLS-1$
		addEEnumLiteral(redhatLinuxProductTypeTypeEEnum, RedhatLinuxProductTypeType.SERVER_LITERAL);
		addEEnumLiteral(redhatLinuxProductTypeTypeEEnum,
				RedhatLinuxProductTypeType.PERSONAL_DESKTOP_LITERAL);
		addEEnumLiteral(redhatLinuxProductTypeTypeEEnum,
				RedhatLinuxProductTypeType.WORK_STATION_LITERAL);
		addEEnumLiteral(redhatLinuxProductTypeTypeEEnum, RedhatLinuxProductTypeType.OTHER_LITERAL);

		initEEnum(redhatLinuxServiceStartupTypeTypeEEnum, RedhatLinuxServiceStartupTypeType.class,
				"RedhatLinuxServiceStartupTypeType"); //$NON-NLS-1$
		addEEnumLiteral(redhatLinuxServiceStartupTypeTypeEEnum,
				RedhatLinuxServiceStartupTypeType.AUTOMATIC_LITERAL);
		addEEnumLiteral(redhatLinuxServiceStartupTypeTypeEEnum,
				RedhatLinuxServiceStartupTypeType.BOOT_LITERAL);
		addEEnumLiteral(redhatLinuxServiceStartupTypeTypeEEnum,
				RedhatLinuxServiceStartupTypeType.SYSTEM_LITERAL);
		addEEnumLiteral(redhatLinuxServiceStartupTypeTypeEEnum,
				RedhatLinuxServiceStartupTypeType.MANUAL_LITERAL);
		addEEnumLiteral(redhatLinuxServiceStartupTypeTypeEEnum,
				RedhatLinuxServiceStartupTypeType.DISABLED_LITERAL);

		initEEnum(redhatLinuxServiceStatusTypeEEnum, RedhatLinuxServiceStatusType.class,
				"RedhatLinuxServiceStatusType"); //$NON-NLS-1$
		addEEnumLiteral(redhatLinuxServiceStatusTypeEEnum,
				RedhatLinuxServiceStatusType.RUNNING_LITERAL);
		addEEnumLiteral(redhatLinuxServiceStatusTypeEEnum,
				RedhatLinuxServiceStatusType.STOPPED_LITERAL);
		addEEnumLiteral(redhatLinuxServiceStatusTypeEEnum,
				RedhatLinuxServiceStatusType.UNKNOWN_LITERAL);

		initEEnum(seLinuxStateTypeEEnum, SELinuxStateType.class, "SELinuxStateType"); //$NON-NLS-1$
		addEEnumLiteral(seLinuxStateTypeEEnum, SELinuxStateType.DISABLED_LITERAL);
		addEEnumLiteral(seLinuxStateTypeEEnum, SELinuxStateType.PERMISSIVE_LITERAL);
		addEEnumLiteral(seLinuxStateTypeEEnum, SELinuxStateType.ENFORCING_LITERAL);

		initEEnum(suseDesktopTypeEEnum, SUSEDesktopType.class, "SUSEDesktopType"); //$NON-NLS-1$
		addEEnumLiteral(suseDesktopTypeEEnum, SUSEDesktopType.GNOME_LITERAL);
		addEEnumLiteral(suseDesktopTypeEEnum, SUSEDesktopType.KDE_LITERAL);
		addEEnumLiteral(suseDesktopTypeEEnum, SUSEDesktopType.NONE_LITERAL);

		initEEnum(suseLinuxBootLoaderTypeEEnum, SUSELinuxBootLoaderType.class,
				"SUSELinuxBootLoaderType"); //$NON-NLS-1$
		addEEnumLiteral(suseLinuxBootLoaderTypeEEnum, SUSELinuxBootLoaderType.GRUB_LITERAL);
		addEEnumLiteral(suseLinuxBootLoaderTypeEEnum, SUSELinuxBootLoaderType.LILO_LITERAL);
		addEEnumLiteral(suseLinuxBootLoaderTypeEEnum, SUSELinuxBootLoaderType.OTHER_LITERAL);

		initEEnum(suseLinuxServiceStartupTypeTypeEEnum, SUSELinuxServiceStartupTypeType.class,
				"SUSELinuxServiceStartupTypeType"); //$NON-NLS-1$
		addEEnumLiteral(suseLinuxServiceStartupTypeTypeEEnum,
				SUSELinuxServiceStartupTypeType.AUTOMATIC_LITERAL);
		addEEnumLiteral(suseLinuxServiceStartupTypeTypeEEnum,
				SUSELinuxServiceStartupTypeType.BOOT_LITERAL);
		addEEnumLiteral(suseLinuxServiceStartupTypeTypeEEnum,
				SUSELinuxServiceStartupTypeType.SYSTEM_LITERAL);
		addEEnumLiteral(suseLinuxServiceStartupTypeTypeEEnum,
				SUSELinuxServiceStartupTypeType.MANUAL_LITERAL);
		addEEnumLiteral(suseLinuxServiceStartupTypeTypeEEnum,
				SUSELinuxServiceStartupTypeType.DISABLED_LITERAL);

		initEEnum(suseLinuxServiceStatusTypeEEnum, SUSELinuxServiceStatusType.class,
				"SUSELinuxServiceStatusType"); //$NON-NLS-1$
		addEEnumLiteral(suseLinuxServiceStatusTypeEEnum, SUSELinuxServiceStatusType.RUNNING_LITERAL);
		addEEnumLiteral(suseLinuxServiceStatusTypeEEnum, SUSELinuxServiceStatusType.STOPPED_LITERAL);
		addEEnumLiteral(suseLinuxServiceStatusTypeEEnum, SUSELinuxServiceStatusType.UNKNOWN_LITERAL);

		initEEnum(transportLayerProtocolTypeEEnum, TransportLayerProtocolType.class,
				"TransportLayerProtocolType"); //$NON-NLS-1$
		addEEnumLiteral(transportLayerProtocolTypeEEnum, TransportLayerProtocolType.TCP_LITERAL);
		addEEnumLiteral(transportLayerProtocolTypeEEnum, TransportLayerProtocolType.UDP_LITERAL);
		addEEnumLiteral(transportLayerProtocolTypeEEnum, TransportLayerProtocolType.DCCP_LITERAL);
		addEEnumLiteral(transportLayerProtocolTypeEEnum, TransportLayerProtocolType.SCTP_LITERAL);
		addEEnumLiteral(transportLayerProtocolTypeEEnum, TransportLayerProtocolType.IL_LITERAL);
		addEEnumLiteral(transportLayerProtocolTypeEEnum, TransportLayerProtocolType.RUDP_LITERAL);

		initEEnum(windowsDirectoryTypeEEnum, WindowsDirectoryType.class, "WindowsDirectoryType"); //$NON-NLS-1$
		addEEnumLiteral(windowsDirectoryTypeEEnum, WindowsDirectoryType.WINDOWS_LITERAL);
		addEEnumLiteral(windowsDirectoryTypeEEnum, WindowsDirectoryType.WINNT_LITERAL);

		initEEnum(windowsProductTypeTypeEEnum, WindowsProductTypeType.class, "WindowsProductTypeType"); //$NON-NLS-1$
		addEEnumLiteral(windowsProductTypeTypeEEnum, WindowsProductTypeType.WORK_STATION_LITERAL);
		addEEnumLiteral(windowsProductTypeTypeEEnum, WindowsProductTypeType.DOMAIN_CONTROLLER_LITERAL);
		addEEnumLiteral(windowsProductTypeTypeEEnum, WindowsProductTypeType.SERVER_LITERAL);
		addEEnumLiteral(windowsProductTypeTypeEEnum, WindowsProductTypeType.OTHER_LITERAL);

		initEEnum(windowsServiceErrorControlTypeEEnum, WindowsServiceErrorControlType.class,
				"WindowsServiceErrorControlType"); //$NON-NLS-1$
		addEEnumLiteral(windowsServiceErrorControlTypeEEnum,
				WindowsServiceErrorControlType.IGNORE_LITERAL);
		addEEnumLiteral(windowsServiceErrorControlTypeEEnum,
				WindowsServiceErrorControlType.NORMAL_LITERAL);
		addEEnumLiteral(windowsServiceErrorControlTypeEEnum,
				WindowsServiceErrorControlType.SEVERE_LITERAL);
		addEEnumLiteral(windowsServiceErrorControlTypeEEnum,
				WindowsServiceErrorControlType.CRITICAL_LITERAL);
		addEEnumLiteral(windowsServiceErrorControlTypeEEnum,
				WindowsServiceErrorControlType.UNKNOWN_LITERAL);

		initEEnum(windowsServiceStartupTypeEEnum, WindowsServiceStartupType.class,
				"WindowsServiceStartupType"); //$NON-NLS-1$
		addEEnumLiteral(windowsServiceStartupTypeEEnum, WindowsServiceStartupType.BOOT_LITERAL);
		addEEnumLiteral(windowsServiceStartupTypeEEnum, WindowsServiceStartupType.SYSTEM_LITERAL);
		addEEnumLiteral(windowsServiceStartupTypeEEnum, WindowsServiceStartupType.AUTOMATIC_LITERAL);
		addEEnumLiteral(windowsServiceStartupTypeEEnum, WindowsServiceStartupType.MANUAL_LITERAL);
		addEEnumLiteral(windowsServiceStartupTypeEEnum, WindowsServiceStartupType.DISABLED_LITERAL);

		initEEnum(windowsServiceStatusTypeEEnum, WindowsServiceStatusType.class,
				"WindowsServiceStatusType"); //$NON-NLS-1$
		addEEnumLiteral(windowsServiceStatusTypeEEnum, WindowsServiceStatusType.RUNNING_LITERAL);
		addEEnumLiteral(windowsServiceStatusTypeEEnum, WindowsServiceStatusType.STOPPED_LITERAL);
		addEEnumLiteral(windowsServiceStatusTypeEEnum, WindowsServiceStatusType.PAUSED_LITERAL);
		addEEnumLiteral(windowsServiceStatusTypeEEnum, WindowsServiceStatusType.UNKNOWN_LITERAL);

		// Initialize data types
		initEDataType(aixAuthMethodTypeObjectEDataType, AIXAuthMethodType.class,
				"AIXAuthMethodTypeObject", IS_SERIALIZABLE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$
		initEDataType(aixDesktopTypeObjectEDataType, AIXDesktopType.class,
				"AIXDesktopTypeObject", IS_SERIALIZABLE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$
		initEDataType(aixUserRegisteringMethodTypeObjectEDataType,
				AIXUserRegisteringMethodType.class,
				"AIXUserRegisteringMethodTypeObject", IS_SERIALIZABLE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$
		initEDataType(architectureBusTypeObjectEDataType, ArchitectureBusType.class,
				"ArchitectureBusTypeObject", IS_SERIALIZABLE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$
		initEDataType(defaultWindowsUserGroupsObjectEDataType, DefaultWindowsUserGroups.class,
				"DefaultWindowsUserGroupsObject", IS_SERIALIZABLE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$
		initEDataType(encryptionLevelTypeObjectEDataType, EncryptionLevelType.class,
				"EncryptionLevelTypeObject", IS_SERIALIZABLE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$
		initEDataType(kernelWidthTypeObjectEDataType, KernelWidthType.class,
				"KernelWidthTypeObject", IS_SERIALIZABLE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$
		initEDataType(linuxServiceStartupTypeTypeObjectEDataType, LinuxServiceStartupTypeType.class,
				"LinuxServiceStartupTypeTypeObject", IS_SERIALIZABLE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$
		initEDataType(linuxServiceStatusTypeObjectEDataType, LinuxServiceStatusType.class,
				"LinuxServiceStatusTypeObject", IS_SERIALIZABLE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$
		initEDataType(operatingSystemTypeObjectEDataType, OperatingSystemType.class,
				"OperatingSystemTypeObject", IS_SERIALIZABLE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$
		initEDataType(redhatDesktopTypeObjectEDataType, RedhatDesktopType.class,
				"RedhatDesktopTypeObject", IS_SERIALIZABLE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$
		initEDataType(redhatLinuxBootLoaderTypeObjectEDataType, RedhatLinuxBootLoaderType.class,
				"RedhatLinuxBootLoaderTypeObject", IS_SERIALIZABLE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$
		initEDataType(redhatLinuxProductTypeTypeObjectEDataType, RedhatLinuxProductTypeType.class,
				"RedhatLinuxProductTypeTypeObject", IS_SERIALIZABLE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$
		initEDataType(redhatLinuxServiceStartupTypeTypeObjectEDataType,
				RedhatLinuxServiceStartupTypeType.class,
				"RedhatLinuxServiceStartupTypeTypeObject", IS_SERIALIZABLE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$
		initEDataType(redhatLinuxServiceStatusTypeObjectEDataType,
				RedhatLinuxServiceStatusType.class,
				"RedhatLinuxServiceStatusTypeObject", IS_SERIALIZABLE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$
		initEDataType(seLinuxStateTypeObjectEDataType, SELinuxStateType.class,
				"SELinuxStateTypeObject", IS_SERIALIZABLE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$
		initEDataType(suseDesktopTypeObjectEDataType, SUSEDesktopType.class,
				"SUSEDesktopTypeObject", IS_SERIALIZABLE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$
		initEDataType(suseLinuxBootLoaderTypeObjectEDataType, SUSELinuxBootLoaderType.class,
				"SUSELinuxBootLoaderTypeObject", IS_SERIALIZABLE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$
		initEDataType(suseLinuxServiceStartupTypeTypeObjectEDataType,
				SUSELinuxServiceStartupTypeType.class,
				"SUSELinuxServiceStartupTypeTypeObject", IS_SERIALIZABLE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$
		initEDataType(suseLinuxServiceStatusTypeObjectEDataType, SUSELinuxServiceStatusType.class,
				"SUSELinuxServiceStatusTypeObject", IS_SERIALIZABLE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$
		initEDataType(tcpPortTypeEDataType, BigInteger.class,
				"TCPPortType", IS_SERIALIZABLE, !IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$
		initEDataType(transportLayerProtocolTypeObjectEDataType, TransportLayerProtocolType.class,
				"TransportLayerProtocolTypeObject", IS_SERIALIZABLE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$
		initEDataType(udpPortTypeEDataType, BigInteger.class,
				"UDPPortType", IS_SERIALIZABLE, !IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$
		initEDataType(windowsDirectoryTypeObjectEDataType, WindowsDirectoryType.class,
				"WindowsDirectoryTypeObject", IS_SERIALIZABLE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$
		initEDataType(windowsProductTypeTypeObjectEDataType, WindowsProductTypeType.class,
				"WindowsProductTypeTypeObject", IS_SERIALIZABLE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$
		initEDataType(windowsServiceErrorControlTypeObjectEDataType,
				WindowsServiceErrorControlType.class,
				"WindowsServiceErrorControlTypeObject", IS_SERIALIZABLE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$
		initEDataType(windowsServiceStartupTypeObjectEDataType, WindowsServiceStartupType.class,
				"WindowsServiceStartupTypeObject", IS_SERIALIZABLE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$
		initEDataType(windowsServiceStatusTypeObjectEDataType, WindowsServiceStatusType.class,
				"WindowsServiceStatusTypeObject", IS_SERIALIZABLE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$

		// Create resource
		createResource(eNS_URI);

		// Create annotations
		// http:///org/eclipse/emf/ecore/util/ExtendedMetaData
		createExtendedMetaDataAnnotations();
	}

	/**
	 * Initializes the annotations for <b>http:///org/eclipse/emf/ecore/util/ExtendedMetaData</b>.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	protected void createExtendedMetaDataAnnotations() {
		String source = "http:///org/eclipse/emf/ecore/util/ExtendedMetaData"; //$NON-NLS-1$			
		addAnnotation(aixAuthMethodTypeEEnum, source, new String[] { "name", "AIXAuthMethodType" //$NON-NLS-1$ //$NON-NLS-2$
		});
		addAnnotation(aixAuthMethodTypeObjectEDataType, source, new String[] {
				"name", "AIXAuthMethodType:Object", //$NON-NLS-1$ //$NON-NLS-2$
				"baseType", "AIXAuthMethodType" //$NON-NLS-1$ //$NON-NLS-2$
		});
		addAnnotation(aixDesktopTypeEEnum, source, new String[] { "name", "AIXDesktopType" //$NON-NLS-1$ //$NON-NLS-2$
		});
		addAnnotation(aixDesktopTypeObjectEDataType, source, new String[] {
				"name", "AIXDesktopType:Object", //$NON-NLS-1$ //$NON-NLS-2$
				"baseType", "AIXDesktopType" //$NON-NLS-1$ //$NON-NLS-2$
		});
		addAnnotation(aixLocalGroupEClass, source, new String[] { "name", "AIXLocalGroup", //$NON-NLS-1$ //$NON-NLS-2$
				"kind", "elementOnly" //$NON-NLS-1$ //$NON-NLS-2$
		});
		addAnnotation(getAIXLocalGroup_GroupDescription(), source, new String[] {
				"kind", "attribute", //$NON-NLS-1$ //$NON-NLS-2$
				"name", "GroupDescription" //$NON-NLS-1$ //$NON-NLS-2$
		});
		addAnnotation(getAIXLocalGroup_GroupSid(), source, new String[] { "kind", "attribute", //$NON-NLS-1$ //$NON-NLS-2$
				"name", "GroupSid" //$NON-NLS-1$ //$NON-NLS-2$
		});
		addAnnotation(aixLocalGroupUnitEClass, source, new String[] { "name", "AIXLocalGroupUnit", //$NON-NLS-1$ //$NON-NLS-2$
				"kind", "elementOnly" //$NON-NLS-1$ //$NON-NLS-2$
		});
		addAnnotation(aixLocalServiceEClass, source, new String[] { "name", "AIXLocalService", //$NON-NLS-1$ //$NON-NLS-2$
				"kind", "elementOnly" //$NON-NLS-1$ //$NON-NLS-2$
		});
		addAnnotation(getAIXLocalService_ActionType(), source, new String[] { "kind", "attribute", //$NON-NLS-1$ //$NON-NLS-2$
				"name", "ActionType" //$NON-NLS-1$ //$NON-NLS-2$
		});
		addAnnotation(getAIXLocalService_ExecutablePath(), source, new String[] {
				"kind", "attribute", //$NON-NLS-1$ //$NON-NLS-2$
				"name", "ExecutablePath" //$NON-NLS-1$ //$NON-NLS-2$
		});
		addAnnotation(getAIXLocalService_ServiceDescription(), source, new String[] {
				"kind", "attribute", //$NON-NLS-1$ //$NON-NLS-2$
				"name", "ServiceDescription" //$NON-NLS-1$ //$NON-NLS-2$
		});
		addAnnotation(getAIXLocalService_StartupRunLevelEight(), source, new String[] {
				"kind", "attribute", //$NON-NLS-1$ //$NON-NLS-2$
				"name", "StartupRunLevelEight" //$NON-NLS-1$ //$NON-NLS-2$
		});
		addAnnotation(getAIXLocalService_StartupRunLevelFive(), source, new String[] {
				"kind", "attribute", //$NON-NLS-1$ //$NON-NLS-2$
				"name", "StartupRunLevelFive" //$NON-NLS-1$ //$NON-NLS-2$
		});
		addAnnotation(getAIXLocalService_StartupRunLevelFour(), source, new String[] {
				"kind", "attribute", //$NON-NLS-1$ //$NON-NLS-2$
				"name", "StartupRunLevelFour" //$NON-NLS-1$ //$NON-NLS-2$
		});
		addAnnotation(getAIXLocalService_StartupRunLevelNine(), source, new String[] {
				"kind", "attribute", //$NON-NLS-1$ //$NON-NLS-2$
				"name", "StartupRunLevelNine" //$NON-NLS-1$ //$NON-NLS-2$
		});
		addAnnotation(getAIXLocalService_StartupRunLevelOne(), source, new String[] {
				"kind", "attribute", //$NON-NLS-1$ //$NON-NLS-2$
				"name", "StartupRunLevelOne" //$NON-NLS-1$ //$NON-NLS-2$
		});
		addAnnotation(getAIXLocalService_StartupRunLevelSeven(), source, new String[] {
				"kind", "attribute", //$NON-NLS-1$ //$NON-NLS-2$
				"name", "StartupRunLevelSeven" //$NON-NLS-1$ //$NON-NLS-2$
		});
		addAnnotation(getAIXLocalService_StartupRunLevelSix(), source, new String[] {
				"kind", "attribute", //$NON-NLS-1$ //$NON-NLS-2$
				"name", "StartupRunLevelSix" //$NON-NLS-1$ //$NON-NLS-2$
		});
		addAnnotation(getAIXLocalService_StartupRunLevelThree(), source, new String[] {
				"kind", "attribute", //$NON-NLS-1$ //$NON-NLS-2$
				"name", "StartupRunLevelThree" //$NON-NLS-1$ //$NON-NLS-2$
		});
		addAnnotation(getAIXLocalService_StartupRunLevelTwo(), source, new String[] {
				"kind", "attribute", //$NON-NLS-1$ //$NON-NLS-2$
				"name", "StartupRunLevelTwo" //$NON-NLS-1$ //$NON-NLS-2$
		});
		addAnnotation(getAIXLocalService_StartupRunLevelZero(), source, new String[] {
				"kind", "attribute", //$NON-NLS-1$ //$NON-NLS-2$
				"name", "StartupRunLevelZero" //$NON-NLS-1$ //$NON-NLS-2$
		});
		addAnnotation(aixLocalServiceUnitEClass, source, new String[] {
				"name", "AIXLocalServiceUnit", //$NON-NLS-1$ //$NON-NLS-2$
				"kind", "elementOnly" //$NON-NLS-1$ //$NON-NLS-2$
		});
		addAnnotation(aixLocalUserEClass, source, new String[] { "name", "AIXLocalUser", //$NON-NLS-1$ //$NON-NLS-2$
				"kind", "elementOnly" //$NON-NLS-1$ //$NON-NLS-2$
		});
		addAnnotation(getAIXLocalUser_AccountDescription(), source, new String[] {
				"kind", "attribute", //$NON-NLS-1$ //$NON-NLS-2$
				"name", "AccountDescription" //$NON-NLS-1$ //$NON-NLS-2$
		});
		addAnnotation(getAIXLocalUser_AccountDisabled(), source, new String[] { "kind", "attribute", //$NON-NLS-1$ //$NON-NLS-2$
				"name", "AccountDisabled" //$NON-NLS-1$ //$NON-NLS-2$
		});
		addAnnotation(getAIXLocalUser_AccountExpirationTime(), source, new String[] {
				"kind", "attribute", //$NON-NLS-1$ //$NON-NLS-2$
				"name", "AccountExpirationTime" //$NON-NLS-1$ //$NON-NLS-2$
		});
		addAnnotation(getAIXLocalUser_ChangePasswordNextLogon(), source, new String[] {
				"kind", "attribute", //$NON-NLS-1$ //$NON-NLS-2$
				"name", "ChangePasswordNextLogon" //$NON-NLS-1$ //$NON-NLS-2$
		});
		addAnnotation(getAIXLocalUser_FullName(), source, new String[] { "kind", "attribute", //$NON-NLS-1$ //$NON-NLS-2$
				"name", "FullName" //$NON-NLS-1$ //$NON-NLS-2$
		});
		addAnnotation(getAIXLocalUser_HomeDir(), source, new String[] { "kind", "attribute", //$NON-NLS-1$ //$NON-NLS-2$
				"name", "HomeDir" //$NON-NLS-1$ //$NON-NLS-2$
		});
		addAnnotation(getAIXLocalUser_IsAdmin(), source, new String[] { "kind", "attribute", //$NON-NLS-1$ //$NON-NLS-2$
				"name", "IsAdmin" //$NON-NLS-1$ //$NON-NLS-2$
		});
		addAnnotation(getAIXLocalUser_LoginPermitted(), source, new String[] { "kind", "attribute", //$NON-NLS-1$ //$NON-NLS-2$
				"name", "LoginPermitted" //$NON-NLS-1$ //$NON-NLS-2$
		});
		addAnnotation(getAIXLocalUser_LoginRetries(), source, new String[] { "kind", "attribute", //$NON-NLS-1$ //$NON-NLS-2$
				"name", "LoginRetries" //$NON-NLS-1$ //$NON-NLS-2$
		});
		addAnnotation(getAIXLocalUser_LoginTimes(), source, new String[] { "kind", "attribute", //$NON-NLS-1$ //$NON-NLS-2$
				"name", "LoginTimes" //$NON-NLS-1$ //$NON-NLS-2$
		});
		addAnnotation(getAIXLocalUser_MaxCharRepeats(), source, new String[] { "kind", "attribute", //$NON-NLS-1$ //$NON-NLS-2$
				"name", "MaxCharRepeats" //$NON-NLS-1$ //$NON-NLS-2$
		});
		addAnnotation(getAIXLocalUser_MaxPasswordAgeInWeeks(), source, new String[] {
				"kind", "attribute", //$NON-NLS-1$ //$NON-NLS-2$
				"name", "MaxPasswordAgeInWeeks" //$NON-NLS-1$ //$NON-NLS-2$
		});
		addAnnotation(getAIXLocalUser_MaxPasswordValidWeeks(), source, new String[] {
				"kind", "attribute", //$NON-NLS-1$ //$NON-NLS-2$
				"name", "MaxPasswordValidWeeks" //$NON-NLS-1$ //$NON-NLS-2$
		});
		addAnnotation(getAIXLocalUser_MinAlphaCharsInPassword(), source, new String[] {
				"kind", "attribute", //$NON-NLS-1$ //$NON-NLS-2$
				"name", "MinAlphaCharsInPassword" //$NON-NLS-1$ //$NON-NLS-2$
		});
		addAnnotation(getAIXLocalUser_MinDiffChars(), source, new String[] { "kind", "attribute", //$NON-NLS-1$ //$NON-NLS-2$
				"name", "MinDiffChars" //$NON-NLS-1$ //$NON-NLS-2$
		});
		addAnnotation(getAIXLocalUser_MinOtherCharsInPassword(), source, new String[] {
				"kind", "attribute", //$NON-NLS-1$ //$NON-NLS-2$
				"name", "MinOtherCharsInPassword" //$NON-NLS-1$ //$NON-NLS-2$
		});
		addAnnotation(getAIXLocalUser_MinPasswordAgeInWeeks(), source, new String[] {
				"kind", "attribute", //$NON-NLS-1$ //$NON-NLS-2$
				"name", "MinPasswordAgeInWeeks" //$NON-NLS-1$ //$NON-NLS-2$
		});
		addAnnotation(getAIXLocalUser_MinPasswordLength(), source, new String[] {
				"kind", "attribute", //$NON-NLS-1$ //$NON-NLS-2$
				"name", "MinPasswordLength" //$NON-NLS-1$ //$NON-NLS-2$
		});
		addAnnotation(getAIXLocalUser_NotReusableNumberOfPasswords(), source, new String[] {
				"kind", "attribute", //$NON-NLS-1$ //$NON-NLS-2$
				"name", "NotReusableNumberOfPasswords" //$NON-NLS-1$ //$NON-NLS-2$
		});
		addAnnotation(getAIXLocalUser_PassReuseNotAllowedInWeeks(), source, new String[] {
				"kind", "attribute", //$NON-NLS-1$ //$NON-NLS-2$
				"name", "PassReuseNotAllowedInWeeks" //$NON-NLS-1$ //$NON-NLS-2$
		});
		addAnnotation(getAIXLocalUser_PasswordChangeWarnTime(), source, new String[] {
				"kind", "attribute", //$NON-NLS-1$ //$NON-NLS-2$
				"name", "PasswordChangeWarnTime" //$NON-NLS-1$ //$NON-NLS-2$
		});
		addAnnotation(getAIXLocalUser_PasswordNeverExpires(), source, new String[] {
				"kind", "attribute", //$NON-NLS-1$ //$NON-NLS-2$
				"name", "PasswordNeverExpires" //$NON-NLS-1$ //$NON-NLS-2$
		});
		addAnnotation(getAIXLocalUser_PrimaryAuthMethod(), source, new String[] {
				"kind", "attribute", //$NON-NLS-1$ //$NON-NLS-2$
				"name", "PrimaryAuthMethod" //$NON-NLS-1$ //$NON-NLS-2$
		});
		addAnnotation(getAIXLocalUser_RemoteLoginIsAllowed(), source, new String[] {
				"kind", "attribute", //$NON-NLS-1$ //$NON-NLS-2$
				"name", "RemoteLoginIsAllowed" //$NON-NLS-1$ //$NON-NLS-2$
		});
		addAnnotation(getAIXLocalUser_SecondaryAuthMethod(), source, new String[] {
				"kind", "attribute", //$NON-NLS-1$ //$NON-NLS-2$
				"name", "SecondaryAuthMethod" //$NON-NLS-1$ //$NON-NLS-2$
		});
		addAnnotation(getAIXLocalUser_Shell(), source, new String[] { "kind", "attribute", //$NON-NLS-1$ //$NON-NLS-2$
				"name", "Shell" //$NON-NLS-1$ //$NON-NLS-2$
		});
		addAnnotation(getAIXLocalUser_SuGroupsAllowed(), source, new String[] { "kind", "attribute", //$NON-NLS-1$ //$NON-NLS-2$
				"name", "SuGroupsAllowed" //$NON-NLS-1$ //$NON-NLS-2$
		});
		addAnnotation(getAIXLocalUser_SuIsAllowed(), source, new String[] { "kind", "attribute", //$NON-NLS-1$ //$NON-NLS-2$
				"name", "SuIsAllowed" //$NON-NLS-1$ //$NON-NLS-2$
		});
		addAnnotation(getAIXLocalUser_TimeLastLogin(), source, new String[] { "kind", "attribute", //$NON-NLS-1$ //$NON-NLS-2$
				"name", "TimeLastLogin" //$NON-NLS-1$ //$NON-NLS-2$
		});
		addAnnotation(getAIXLocalUser_UserCannotChangePassword(), source, new String[] {
				"kind", "attribute", //$NON-NLS-1$ //$NON-NLS-2$
				"name", "UserCannotChangePassword" //$NON-NLS-1$ //$NON-NLS-2$
		});
		addAnnotation(getAIXLocalUser_UserName(), source, new String[] { "kind", "attribute", //$NON-NLS-1$ //$NON-NLS-2$
				"name", "UserName" //$NON-NLS-1$ //$NON-NLS-2$
		});
		addAnnotation(getAIXLocalUser_UserRegisteringMethod(), source, new String[] {
				"kind", "attribute", //$NON-NLS-1$ //$NON-NLS-2$
				"name", "UserRegisteringMethod" //$NON-NLS-1$ //$NON-NLS-2$
		});
		addAnnotation(getAIXLocalUser_UserSid(), source, new String[] { "kind", "attribute", //$NON-NLS-1$ //$NON-NLS-2$
				"name", "UserSid" //$NON-NLS-1$ //$NON-NLS-2$
		});
		addAnnotation(getAIXLocalUser_UsuccessfulLoginCount(), source, new String[] {
				"kind", "attribute", //$NON-NLS-1$ //$NON-NLS-2$
				"name", "UsuccessfulLoginCount" //$NON-NLS-1$ //$NON-NLS-2$
		});
		addAnnotation(aixLocalUserUnitEClass, source, new String[] { "name", "AIXLocalUserUnit", //$NON-NLS-1$ //$NON-NLS-2$
				"kind", "elementOnly" //$NON-NLS-1$ //$NON-NLS-2$
		});
		addAnnotation(aixOperatingSystemEClass, source, new String[] { "name", "AIXOperatingSystem", //$NON-NLS-1$ //$NON-NLS-2$
				"kind", "elementOnly" //$NON-NLS-1$ //$NON-NLS-2$
		});
		addAnnotation(getAIXOperatingSystem_Desktop(), source, new String[] { "kind", "attribute", //$NON-NLS-1$ //$NON-NLS-2$
				"name", "Desktop" //$NON-NLS-1$ //$NON-NLS-2$
		});
		addAnnotation(getAIXOperatingSystem_InstallDate(), source, new String[] {
				"kind", "attribute", //$NON-NLS-1$ //$NON-NLS-2$
				"name", "InstallDate" //$NON-NLS-1$ //$NON-NLS-2$
		});
		addAnnotation(getAIXOperatingSystem_Kernel(), source, new String[] { "kind", "attribute", //$NON-NLS-1$ //$NON-NLS-2$
				"name", "Kernel" //$NON-NLS-1$ //$NON-NLS-2$
		});
		addAnnotation(getAIXOperatingSystem_LastBootUpTime(), source, new String[] {
				"kind", "attribute", //$NON-NLS-1$ //$NON-NLS-2$
				"name", "LastBootUpTime" //$NON-NLS-1$ //$NON-NLS-2$
		});
		addAnnotation(getAIXOperatingSystem_Owner(), source, new String[] { "kind", "attribute", //$NON-NLS-1$ //$NON-NLS-2$
				"name", "Owner" //$NON-NLS-1$ //$NON-NLS-2$
		});
		addAnnotation(getAIXOperatingSystem_TCB(), source, new String[] { "kind", "attribute", //$NON-NLS-1$ //$NON-NLS-2$
				"name", "TCB" //$NON-NLS-1$ //$NON-NLS-2$
		});
		addAnnotation(aixOperatingSystemUnitEClass, source, new String[] {
				"name", "AIXOperatingSystemUnit", //$NON-NLS-1$ //$NON-NLS-2$
				"kind", "elementOnly" //$NON-NLS-1$ //$NON-NLS-2$
		});
		addAnnotation(aixUserRegisteringMethodTypeEEnum, source, new String[] {
				"name", "AIXUserRegisteringMethodType" //$NON-NLS-1$ //$NON-NLS-2$
		});
		addAnnotation(aixUserRegisteringMethodTypeObjectEDataType, source, new String[] {
				"name", "AIXUserRegisteringMethodType:Object", //$NON-NLS-1$ //$NON-NLS-2$
				"baseType", "AIXUserRegisteringMethodType" //$NON-NLS-1$ //$NON-NLS-2$
		});
		addAnnotation(architectureBusTypeEEnum, source, new String[] { "name", "ArchitectureBusType" //$NON-NLS-1$ //$NON-NLS-2$
		});
		addAnnotation(architectureBusTypeObjectEDataType, source, new String[] {
				"name", "ArchitectureBusType:Object", //$NON-NLS-1$ //$NON-NLS-2$
				"baseType", "ArchitectureBusType" //$NON-NLS-1$ //$NON-NLS-2$
		});
		addAnnotation(dataFileEClass, source, new String[] { "name", "DataFile", //$NON-NLS-1$ //$NON-NLS-2$
				"kind", "elementOnly" //$NON-NLS-1$ //$NON-NLS-2$
		});
		addAnnotation(dataFileUnitEClass, source, new String[] { "name", "DataFileUnit", //$NON-NLS-1$ //$NON-NLS-2$
				"kind", "elementOnly" //$NON-NLS-1$ //$NON-NLS-2$
		});
		addAnnotation(defaultWindowsUserGroupsEEnum, source, new String[] {
				"name", "DefaultWindowsUserGroups" //$NON-NLS-1$ //$NON-NLS-2$
		});
		addAnnotation(defaultWindowsUserGroupsObjectEDataType, source, new String[] {
				"name", "DefaultWindowsUserGroups:Object", //$NON-NLS-1$ //$NON-NLS-2$
				"baseType", "DefaultWindowsUserGroups" //$NON-NLS-1$ //$NON-NLS-2$
		});
		addAnnotation(directoryEClass, source, new String[] { "name", "Directory", //$NON-NLS-1$ //$NON-NLS-2$
				"kind", "elementOnly" //$NON-NLS-1$ //$NON-NLS-2$
		});
		addAnnotation(getDirectory_DirectoryPath(), source, new String[] { "kind", "attribute", //$NON-NLS-1$ //$NON-NLS-2$
				"name", "directoryPath" //$NON-NLS-1$ //$NON-NLS-2$
		});
		addAnnotation(directoryUnitEClass, source, new String[] { "name", "DirectoryUnit", //$NON-NLS-1$ //$NON-NLS-2$
				"kind", "elementOnly" //$NON-NLS-1$ //$NON-NLS-2$
		});
		addAnnotation(encryptionLevelTypeEEnum, source, new String[] { "name", "EncryptionLevelType" //$NON-NLS-1$ //$NON-NLS-2$
		});
		addAnnotation(encryptionLevelTypeObjectEDataType, source, new String[] {
				"name", "EncryptionLevelType:Object", //$NON-NLS-1$ //$NON-NLS-2$
				"baseType", "EncryptionLevelType" //$NON-NLS-1$ //$NON-NLS-2$
		});
		addAnnotation(fileSystemEClass, source, new String[] { "name", "FileSystem", //$NON-NLS-1$ //$NON-NLS-2$
				"kind", "elementOnly" //$NON-NLS-1$ //$NON-NLS-2$
		});
		addAnnotation(getFileSystem_AvailableSpace(), source, new String[] { "kind", "attribute", //$NON-NLS-1$ //$NON-NLS-2$
				"name", "AvailableSpace" //$NON-NLS-1$ //$NON-NLS-2$
		});
		addAnnotation(getFileSystem_Capacity(), source, new String[] { "kind", "attribute", //$NON-NLS-1$ //$NON-NLS-2$
				"name", "Capacity" //$NON-NLS-1$ //$NON-NLS-2$
		});
		addAnnotation(getFileSystem_MountPoint(), source, new String[] { "kind", "attribute", //$NON-NLS-1$ //$NON-NLS-2$
				"name", "MountPoint" //$NON-NLS-1$ //$NON-NLS-2$
		});
		addAnnotation(getFileSystem_Type(), source, new String[] { "kind", "attribute", //$NON-NLS-1$ //$NON-NLS-2$
				"name", "Type" //$NON-NLS-1$ //$NON-NLS-2$
		});
		addAnnotation(fileSystemContentEClass, source, new String[] { "name", "FileSystemContent", //$NON-NLS-1$ //$NON-NLS-2$
				"kind", "elementOnly" //$NON-NLS-1$ //$NON-NLS-2$
		});
		addAnnotation(getFileSystemContent_FixedPath(), source, new String[] { "kind", "attribute", //$NON-NLS-1$ //$NON-NLS-2$
				"name", "FixedPath" //$NON-NLS-1$ //$NON-NLS-2$
		});
		addAnnotation(getFileSystemContent_Group(), source, new String[] { "kind", "attribute", //$NON-NLS-1$ //$NON-NLS-2$
				"name", "Group" //$NON-NLS-1$ //$NON-NLS-2$
		});
		addAnnotation(getFileSystemContent_LastModified(), source, new String[] {
				"kind", "attribute", //$NON-NLS-1$ //$NON-NLS-2$
				"name", "LastModified" //$NON-NLS-1$ //$NON-NLS-2$
		});
		addAnnotation(getFileSystemContent_Owner(), source, new String[] { "kind", "attribute", //$NON-NLS-1$ //$NON-NLS-2$
				"name", "Owner" //$NON-NLS-1$ //$NON-NLS-2$
		});
		addAnnotation(getFileSystemContent_Permissions(), source, new String[] { "kind", "attribute", //$NON-NLS-1$ //$NON-NLS-2$
				"name", "Permissions" //$NON-NLS-1$ //$NON-NLS-2$
		});
		addAnnotation(getFileSystemContent_RealFile(), source, new String[] { "kind", "attribute", //$NON-NLS-1$ //$NON-NLS-2$
				"name", "RealFile" //$NON-NLS-1$ //$NON-NLS-2$
		});
		addAnnotation(getFileSystemContent_Size(), source, new String[] { "kind", "attribute", //$NON-NLS-1$ //$NON-NLS-2$
				"name", "Size" //$NON-NLS-1$ //$NON-NLS-2$
		});
		addAnnotation(getFileSystemContent_URI(), source, new String[] { "kind", "attribute", //$NON-NLS-1$ //$NON-NLS-2$
				"name", "URI" //$NON-NLS-1$ //$NON-NLS-2$
		});
		addAnnotation(fileSystemContentUnitEClass, source, new String[] {
				"name", "FileSystemContentUnit", //$NON-NLS-1$ //$NON-NLS-2$
				"kind", "elementOnly" //$NON-NLS-1$ //$NON-NLS-2$
		});
		addAnnotation(fileSystemUnitEClass, source, new String[] { "name", "FileSystemUnit", //$NON-NLS-1$ //$NON-NLS-2$
				"kind", "elementOnly" //$NON-NLS-1$ //$NON-NLS-2$
		});
		addAnnotation(kernelWidthTypeEEnum, source, new String[] { "name", "KernelWidthType" //$NON-NLS-1$ //$NON-NLS-2$
		});
		addAnnotation(kernelWidthTypeObjectEDataType, source, new String[] {
				"name", "KernelWidthType:Object", //$NON-NLS-1$ //$NON-NLS-2$
				"baseType", "KernelWidthType" //$NON-NLS-1$ //$NON-NLS-2$
		});
		addAnnotation(linuxLocalGroupEClass, source, new String[] { "name", "LinuxLocalGroup", //$NON-NLS-1$ //$NON-NLS-2$
				"kind", "elementOnly" //$NON-NLS-1$ //$NON-NLS-2$
		});
		addAnnotation(getLinuxLocalGroup_GroupDescription(), source, new String[] {
				"kind", "attribute", //$NON-NLS-1$ //$NON-NLS-2$
				"name", "GroupDescription" //$NON-NLS-1$ //$NON-NLS-2$
		});
		addAnnotation(linuxLocalGroupUnitEClass, source, new String[] {
				"name", "LinuxLocalGroupUnit", //$NON-NLS-1$ //$NON-NLS-2$
				"kind", "elementOnly" //$NON-NLS-1$ //$NON-NLS-2$
		});
		addAnnotation(linuxLocalServiceEClass, source, new String[] { "name", "LinuxLocalService", //$NON-NLS-1$ //$NON-NLS-2$
				"kind", "elementOnly" //$NON-NLS-1$ //$NON-NLS-2$
		});
		addAnnotation(getLinuxLocalService_ExecutablePath(), source, new String[] {
				"kind", "attribute", //$NON-NLS-1$ //$NON-NLS-2$
				"name", "ExecutablePath" //$NON-NLS-1$ //$NON-NLS-2$
		});
		addAnnotation(getLinuxLocalService_ServiceAccount(), source, new String[] {
				"kind", "attribute", //$NON-NLS-1$ //$NON-NLS-2$
				"name", "ServiceAccount" //$NON-NLS-1$ //$NON-NLS-2$
		});
		addAnnotation(getLinuxLocalService_ServiceDescription(), source, new String[] {
				"kind", "attribute", //$NON-NLS-1$ //$NON-NLS-2$
				"name", "ServiceDescription" //$NON-NLS-1$ //$NON-NLS-2$
		});
		addAnnotation(getLinuxLocalService_ServiceName(), source, new String[] { "kind", "attribute", //$NON-NLS-1$ //$NON-NLS-2$
				"name", "ServiceName" //$NON-NLS-1$ //$NON-NLS-2$
		});
		addAnnotation(getLinuxLocalService_ServiceStatus(), source, new String[] {
				"kind", "attribute", //$NON-NLS-1$ //$NON-NLS-2$
				"name", "ServiceStatus" //$NON-NLS-1$ //$NON-NLS-2$
		});
		addAnnotation(getLinuxLocalService_StartupRunLevelFive(), source, new String[] {
				"kind", "attribute", //$NON-NLS-1$ //$NON-NLS-2$
				"name", "StartupRunLevelFive" //$NON-NLS-1$ //$NON-NLS-2$
		});
		addAnnotation(getLinuxLocalService_StartupRunLevelFour(), source, new String[] {
				"kind", "attribute", //$NON-NLS-1$ //$NON-NLS-2$
				"name", "StartupRunLevelFour" //$NON-NLS-1$ //$NON-NLS-2$
		});
		addAnnotation(getLinuxLocalService_StartupRunLevelOne(), source, new String[] {
				"kind", "attribute", //$NON-NLS-1$ //$NON-NLS-2$
				"name", "StartupRunLevelOne" //$NON-NLS-1$ //$NON-NLS-2$
		});
		addAnnotation(getLinuxLocalService_StartupRunLevelSix(), source, new String[] {
				"kind", "attribute", //$NON-NLS-1$ //$NON-NLS-2$
				"name", "StartupRunLevelSix" //$NON-NLS-1$ //$NON-NLS-2$
		});
		addAnnotation(getLinuxLocalService_StartupRunLevelThree(), source, new String[] {
				"kind", "attribute", //$NON-NLS-1$ //$NON-NLS-2$
				"name", "StartupRunLevelThree" //$NON-NLS-1$ //$NON-NLS-2$
		});
		addAnnotation(getLinuxLocalService_StartupRunLevelTwo(), source, new String[] {
				"kind", "attribute", //$NON-NLS-1$ //$NON-NLS-2$
				"name", "StartupRunLevelTwo" //$NON-NLS-1$ //$NON-NLS-2$
		});
		addAnnotation(getLinuxLocalService_StartupRunLevelZero(), source, new String[] {
				"kind", "attribute", //$NON-NLS-1$ //$NON-NLS-2$
				"name", "StartupRunLevelZero" //$NON-NLS-1$ //$NON-NLS-2$
		});
		addAnnotation(getLinuxLocalService_StartupType(), source, new String[] { "kind", "attribute", //$NON-NLS-1$ //$NON-NLS-2$
				"name", "StartupType" //$NON-NLS-1$ //$NON-NLS-2$
		});
		addAnnotation(linuxLocalServiceUnitEClass, source, new String[] {
				"name", "LinuxLocalServiceUnit", //$NON-NLS-1$ //$NON-NLS-2$
				"kind", "elementOnly" //$NON-NLS-1$ //$NON-NLS-2$
		});
		addAnnotation(linuxLocalUserEClass, source, new String[] { "name", "LinuxLocalUser", //$NON-NLS-1$ //$NON-NLS-2$
				"kind", "elementOnly" //$NON-NLS-1$ //$NON-NLS-2$
		});
		addAnnotation(getLinuxLocalUser_AccountDescription(), source, new String[] {
				"kind", "attribute", //$NON-NLS-1$ //$NON-NLS-2$
				"name", "AccountDescription" //$NON-NLS-1$ //$NON-NLS-2$
		});
		addAnnotation(getLinuxLocalUser_AccountDisabled(), source, new String[] {
				"kind", "attribute", //$NON-NLS-1$ //$NON-NLS-2$
				"name", "AccountDisabled" //$NON-NLS-1$ //$NON-NLS-2$
		});
		addAnnotation(getLinuxLocalUser_ChangePasswordNextLogon(), source, new String[] {
				"kind", "attribute", //$NON-NLS-1$ //$NON-NLS-2$
				"name", "ChangePasswordNextLogon" //$NON-NLS-1$ //$NON-NLS-2$
		});
		addAnnotation(getLinuxLocalUser_FullName(), source, new String[] { "kind", "attribute", //$NON-NLS-1$ //$NON-NLS-2$
				"name", "FullName" //$NON-NLS-1$ //$NON-NLS-2$
		});
		addAnnotation(getLinuxLocalUser_HomeDir(), source, new String[] { "kind", "attribute", //$NON-NLS-1$ //$NON-NLS-2$
				"name", "HomeDir" //$NON-NLS-1$ //$NON-NLS-2$
		});
		addAnnotation(getLinuxLocalUser_PasswordNeverExpires(), source, new String[] {
				"kind", "attribute", //$NON-NLS-1$ //$NON-NLS-2$
				"name", "PasswordNeverExpires" //$NON-NLS-1$ //$NON-NLS-2$
		});
		addAnnotation(getLinuxLocalUser_Shell(), source, new String[] { "kind", "attribute", //$NON-NLS-1$ //$NON-NLS-2$
				"name", "Shell" //$NON-NLS-1$ //$NON-NLS-2$
		});
		addAnnotation(getLinuxLocalUser_UserCannotChangePassword(), source, new String[] {
				"kind", "attribute", //$NON-NLS-1$ //$NON-NLS-2$
				"name", "UserCannotChangePassword" //$NON-NLS-1$ //$NON-NLS-2$
		});
		addAnnotation(getLinuxLocalUser_UserName(), source, new String[] { "kind", "attribute", //$NON-NLS-1$ //$NON-NLS-2$
				"name", "UserName" //$NON-NLS-1$ //$NON-NLS-2$
		});
		addAnnotation(linuxLocalUserUnitEClass, source, new String[] { "name", "LinuxLocalUserUnit", //$NON-NLS-1$ //$NON-NLS-2$
				"kind", "elementOnly" //$NON-NLS-1$ //$NON-NLS-2$
		});
		addAnnotation(linuxOperatingSystemEClass, source, new String[] {
				"name", "LinuxOperatingSystem", //$NON-NLS-1$ //$NON-NLS-2$
				"kind", "elementOnly" //$NON-NLS-1$ //$NON-NLS-2$
		});
		addAnnotation(getLinuxOperatingSystem_KernelRelease(), source, new String[] {
				"kind", "attribute", //$NON-NLS-1$ //$NON-NLS-2$
				"name", "KernelRelease" //$NON-NLS-1$ //$NON-NLS-2$
		});
		addAnnotation(linuxOperatingSystemUnitEClass, source, new String[] {
				"name", "LinuxOperatingSystemUnit", //$NON-NLS-1$ //$NON-NLS-2$
				"kind", "elementOnly" //$NON-NLS-1$ //$NON-NLS-2$
		});
		addAnnotation(linuxServiceStartupTypeTypeEEnum, source, new String[] {
				"name", "LinuxServiceStartupTypeType" //$NON-NLS-1$ //$NON-NLS-2$
		});
		addAnnotation(linuxServiceStartupTypeTypeObjectEDataType, source, new String[] {
				"name", "LinuxServiceStartupTypeType:Object", //$NON-NLS-1$ //$NON-NLS-2$
				"baseType", "LinuxServiceStartupTypeType" //$NON-NLS-1$ //$NON-NLS-2$
		});
		addAnnotation(linuxServiceStatusTypeEEnum, source, new String[] {
				"name", "LinuxServiceStatusType" //$NON-NLS-1$ //$NON-NLS-2$
		});
		addAnnotation(linuxServiceStatusTypeObjectEDataType, source, new String[] {
				"name", "LinuxServiceStatusType:Object", //$NON-NLS-1$ //$NON-NLS-2$
				"baseType", "LinuxServiceStatusType" //$NON-NLS-1$ //$NON-NLS-2$
		});
		addAnnotation(localFileSystemEClass, source, new String[] { "name", "LocalFileSystem", //$NON-NLS-1$ //$NON-NLS-2$
				"kind", "elementOnly" //$NON-NLS-1$ //$NON-NLS-2$
		});
		addAnnotation(localFileSystemUnitEClass, source, new String[] {
				"name", "LocalFileSystemUnit", //$NON-NLS-1$ //$NON-NLS-2$
				"kind", "elementOnly" //$NON-NLS-1$ //$NON-NLS-2$
		});
		addAnnotation(nfsFileSystemEClass, source, new String[] { "name", "NFSFileSystem", //$NON-NLS-1$ //$NON-NLS-2$
				"kind", "elementOnly" //$NON-NLS-1$ //$NON-NLS-2$
		});
		addAnnotation(nfsFileSystemUnitEClass, source, new String[] { "name", "NFSFileSystemUnit", //$NON-NLS-1$ //$NON-NLS-2$
				"kind", "elementOnly" //$NON-NLS-1$ //$NON-NLS-2$
		});
		addAnnotation(openVmsFileSystemEClass, source, new String[] { "name", "OpenVmsFileSystem", //$NON-NLS-1$ //$NON-NLS-2$
				"kind", "elementOnly" //$NON-NLS-1$ //$NON-NLS-2$
		});
		addAnnotation(openVmsFileSystemUnitEClass, source, new String[] {
				"name", "OpenVmsFileSystemUnit", //$NON-NLS-1$ //$NON-NLS-2$
				"kind", "elementOnly" //$NON-NLS-1$ //$NON-NLS-2$
		});
		addAnnotation(operatingSystemEClass, source, new String[] { "name", "OperatingSystem", //$NON-NLS-1$ //$NON-NLS-2$
				"kind", "elementOnly" //$NON-NLS-1$ //$NON-NLS-2$
		});
		addAnnotation(getOperatingSystem_Fqdn(), source, new String[] { "kind", "attribute", //$NON-NLS-1$ //$NON-NLS-2$
				"name", "fqdn" //$NON-NLS-1$ //$NON-NLS-2$
		});
		addAnnotation(getOperatingSystem_Hostname(), source, new String[] { "kind", "attribute", //$NON-NLS-1$ //$NON-NLS-2$
				"name", "hostname" //$NON-NLS-1$ //$NON-NLS-2$
		});
		addAnnotation(getOperatingSystem_KernelArchitecture(), source, new String[] {
				"kind", "attribute", //$NON-NLS-1$ //$NON-NLS-2$
				"name", "kernelArchitecture" //$NON-NLS-1$ //$NON-NLS-2$
		});
		addAnnotation(getOperatingSystem_KernelVersion(), source, new String[] { "kind", "attribute", //$NON-NLS-1$ //$NON-NLS-2$
				"name", "kernelVersion" //$NON-NLS-1$ //$NON-NLS-2$
		});
		addAnnotation(getOperatingSystem_KernelWidth(), source, new String[] { "kind", "attribute", //$NON-NLS-1$ //$NON-NLS-2$
				"name", "kernelWidth" //$NON-NLS-1$ //$NON-NLS-2$
		});
		addAnnotation(getOperatingSystem_Locale(), source, new String[] { "kind", "attribute", //$NON-NLS-1$ //$NON-NLS-2$
				"name", "locale" //$NON-NLS-1$ //$NON-NLS-2$
		});
		addAnnotation(getOperatingSystem_Manufacturer(), source, new String[] { "kind", "attribute", //$NON-NLS-1$ //$NON-NLS-2$
				"name", "manufacturer" //$NON-NLS-1$ //$NON-NLS-2$
		});
		addAnnotation(getOperatingSystem_OsDistribution(), source, new String[] {
				"kind", "attribute", //$NON-NLS-1$ //$NON-NLS-2$
				"name", "os.distribution" //$NON-NLS-1$ //$NON-NLS-2$
		});
		addAnnotation(getOperatingSystem_OsServicepack(), source, new String[] { "kind", "attribute", //$NON-NLS-1$ //$NON-NLS-2$
				"name", "os.servicepack" //$NON-NLS-1$ //$NON-NLS-2$
		});
		addAnnotation(getOperatingSystem_OsType(), source, new String[] { "kind", "attribute", //$NON-NLS-1$ //$NON-NLS-2$
				"name", "os.type" //$NON-NLS-1$ //$NON-NLS-2$
		});
		addAnnotation(getOperatingSystem_OsVersion(), source, new String[] { "kind", "attribute", //$NON-NLS-1$ //$NON-NLS-2$
				"name", "os.version" //$NON-NLS-1$ //$NON-NLS-2$
		});
		addAnnotation(getOperatingSystem_TimeZone(), source, new String[] { "kind", "attribute", //$NON-NLS-1$ //$NON-NLS-2$
				"name", "TimeZone" //$NON-NLS-1$ //$NON-NLS-2$
		});
		addAnnotation(operatingSystemRootEClass, source, new String[] { "name", "", //$NON-NLS-1$ //$NON-NLS-2$
				"kind", "mixed" //$NON-NLS-1$ //$NON-NLS-2$
		});
		addAnnotation(getOperatingSystemRoot_Mixed(), source, new String[] {
				"kind", "elementWildcard", //$NON-NLS-1$ //$NON-NLS-2$
				"name", ":mixed" //$NON-NLS-1$ //$NON-NLS-2$
		});
		addAnnotation(getOperatingSystemRoot_XMLNSPrefixMap(), source, new String[] {
				"kind", "attribute", //$NON-NLS-1$ //$NON-NLS-2$
				"name", "xmlns:prefix" //$NON-NLS-1$ //$NON-NLS-2$
		});
		addAnnotation(getOperatingSystemRoot_XSISchemaLocation(), source, new String[] {
				"kind", "attribute", //$NON-NLS-1$ //$NON-NLS-2$
				"name", "xsi:schemaLocation" //$NON-NLS-1$ //$NON-NLS-2$
		});
		addAnnotation(getOperatingSystemRoot_CapabilityAixLocalGroup(), source, new String[] {
				"kind", "element", //$NON-NLS-1$ //$NON-NLS-2$
				"name", "capability.aixLocalGroup", //$NON-NLS-1$ //$NON-NLS-2$
				"namespace", "##targetNamespace", //$NON-NLS-1$ //$NON-NLS-2$
				"affiliation", "http://www.ibm.com/ccl/soa/deploy/core/1.0.0/#capability" //$NON-NLS-1$ //$NON-NLS-2$
		});
		addAnnotation(getOperatingSystemRoot_CapabilityAixLocalService(), source, new String[] {
				"kind", "element", //$NON-NLS-1$ //$NON-NLS-2$
				"name", "capability.aixLocalService", //$NON-NLS-1$ //$NON-NLS-2$
				"namespace", "##targetNamespace", //$NON-NLS-1$ //$NON-NLS-2$
				"affiliation", "http://www.ibm.com/ccl/soa/deploy/core/1.0.0/#capability" //$NON-NLS-1$ //$NON-NLS-2$
		});
		addAnnotation(getOperatingSystemRoot_CapabilityAixLocalUser(), source, new String[] {
				"kind", "element", //$NON-NLS-1$ //$NON-NLS-2$
				"name", "capability.aixLocalUser", //$NON-NLS-1$ //$NON-NLS-2$
				"namespace", "##targetNamespace", //$NON-NLS-1$ //$NON-NLS-2$
				"affiliation", "http://www.ibm.com/ccl/soa/deploy/core/1.0.0/#capability" //$NON-NLS-1$ //$NON-NLS-2$
		});
		addAnnotation(getOperatingSystemRoot_CapabilityAixOperatingSystem(), source, new String[] {
				"kind", "element", //$NON-NLS-1$ //$NON-NLS-2$
				"name", "capability.aixOperatingSystem", //$NON-NLS-1$ //$NON-NLS-2$
				"namespace", "##targetNamespace", //$NON-NLS-1$ //$NON-NLS-2$
				"affiliation", "http://www.ibm.com/ccl/soa/deploy/core/1.0.0/#capability" //$NON-NLS-1$ //$NON-NLS-2$
		});
		addAnnotation(getOperatingSystemRoot_CapabilityDataFile(), source, new String[] {
				"kind", "element", //$NON-NLS-1$ //$NON-NLS-2$
				"name", "capability.dataFile", //$NON-NLS-1$ //$NON-NLS-2$
				"namespace", "##targetNamespace", //$NON-NLS-1$ //$NON-NLS-2$
				"affiliation", "http://www.ibm.com/ccl/soa/deploy/core/1.0.0/#capability" //$NON-NLS-1$ //$NON-NLS-2$
		});
		addAnnotation(getOperatingSystemRoot_CapabilityDirectory(), source, new String[] {
				"kind", "element", //$NON-NLS-1$ //$NON-NLS-2$
				"name", "capability.directory", //$NON-NLS-1$ //$NON-NLS-2$
				"namespace", "##targetNamespace", //$NON-NLS-1$ //$NON-NLS-2$
				"affiliation", "http://www.ibm.com/ccl/soa/deploy/core/1.0.0/#capability" //$NON-NLS-1$ //$NON-NLS-2$
		});
		addAnnotation(getOperatingSystemRoot_CapabilityFileSystem(), source, new String[] {
				"kind", "element", //$NON-NLS-1$ //$NON-NLS-2$
				"name", "capability.fileSystem", //$NON-NLS-1$ //$NON-NLS-2$
				"namespace", "##targetNamespace", //$NON-NLS-1$ //$NON-NLS-2$
				"affiliation", "http://www.ibm.com/ccl/soa/deploy/core/1.0.0/#capability" //$NON-NLS-1$ //$NON-NLS-2$
		});
		addAnnotation(getOperatingSystemRoot_CapabilityFileSystemContent(), source, new String[] {
				"kind", "element", //$NON-NLS-1$ //$NON-NLS-2$
				"name", "capability.fileSystemContent", //$NON-NLS-1$ //$NON-NLS-2$
				"namespace", "##targetNamespace", //$NON-NLS-1$ //$NON-NLS-2$
				"affiliation", "http://www.ibm.com/ccl/soa/deploy/core/1.0.0/#capability" //$NON-NLS-1$ //$NON-NLS-2$
		});
		addAnnotation(getOperatingSystemRoot_CapabilityLinuxLocalGroup(), source, new String[] {
				"kind", "element", //$NON-NLS-1$ //$NON-NLS-2$
				"name", "capability.linuxLocalGroup", //$NON-NLS-1$ //$NON-NLS-2$
				"namespace", "##targetNamespace", //$NON-NLS-1$ //$NON-NLS-2$
				"affiliation", "http://www.ibm.com/ccl/soa/deploy/core/1.0.0/#capability" //$NON-NLS-1$ //$NON-NLS-2$
		});
		addAnnotation(getOperatingSystemRoot_CapabilityLinuxLocalService(), source, new String[] {
				"kind", "element", //$NON-NLS-1$ //$NON-NLS-2$
				"name", "capability.linuxLocalService", //$NON-NLS-1$ //$NON-NLS-2$
				"namespace", "##targetNamespace", //$NON-NLS-1$ //$NON-NLS-2$
				"affiliation", "http://www.ibm.com/ccl/soa/deploy/core/1.0.0/#capability" //$NON-NLS-1$ //$NON-NLS-2$
		});
		addAnnotation(getOperatingSystemRoot_CapabilityLinuxLocalUser(), source, new String[] {
				"kind", "element", //$NON-NLS-1$ //$NON-NLS-2$
				"name", "capability.linuxLocalUser", //$NON-NLS-1$ //$NON-NLS-2$
				"namespace", "##targetNamespace", //$NON-NLS-1$ //$NON-NLS-2$
				"affiliation", "http://www.ibm.com/ccl/soa/deploy/core/1.0.0/#capability" //$NON-NLS-1$ //$NON-NLS-2$
		});
		addAnnotation(getOperatingSystemRoot_CapabilityLinuxOperatingSystem(), source, new String[] {
				"kind", "element", //$NON-NLS-1$ //$NON-NLS-2$
				"name", "capability.linuxOperatingSystem", //$NON-NLS-1$ //$NON-NLS-2$
				"namespace", "##targetNamespace", //$NON-NLS-1$ //$NON-NLS-2$
				"affiliation", "http://www.ibm.com/ccl/soa/deploy/core/1.0.0/#capability" //$NON-NLS-1$ //$NON-NLS-2$
		});
		addAnnotation(getOperatingSystemRoot_CapabilityLocalFileSystem(), source, new String[] {
				"kind", "element", //$NON-NLS-1$ //$NON-NLS-2$
				"name", "capability.localFileSystem", //$NON-NLS-1$ //$NON-NLS-2$
				"namespace", "##targetNamespace", //$NON-NLS-1$ //$NON-NLS-2$
				"affiliation", "http://www.ibm.com/ccl/soa/deploy/core/1.0.0/#capability" //$NON-NLS-1$ //$NON-NLS-2$
		});
		addAnnotation(getOperatingSystemRoot_CapabilityNFSFileSystem(), source, new String[] {
				"kind", "element", //$NON-NLS-1$ //$NON-NLS-2$
				"name", "capability.nFSFileSystem", //$NON-NLS-1$ //$NON-NLS-2$
				"namespace", "##targetNamespace", //$NON-NLS-1$ //$NON-NLS-2$
				"affiliation", "http://www.ibm.com/ccl/soa/deploy/core/1.0.0/#capability" //$NON-NLS-1$ //$NON-NLS-2$
		});
		addAnnotation(getOperatingSystemRoot_CapabilityOpenVmsFileSystem(), source, new String[] {
				"kind", "element", //$NON-NLS-1$ //$NON-NLS-2$
				"name", "capability.openVmsFileSystem", //$NON-NLS-1$ //$NON-NLS-2$
				"namespace", "##targetNamespace", //$NON-NLS-1$ //$NON-NLS-2$
				"affiliation", "http://www.ibm.com/ccl/soa/deploy/core/1.0.0/#capability" //$NON-NLS-1$ //$NON-NLS-2$
		});
		addAnnotation(getOperatingSystemRoot_CapabilityOperatingSystem(), source, new String[] {
				"kind", "element", //$NON-NLS-1$ //$NON-NLS-2$
				"name", "capability.operatingSystem", //$NON-NLS-1$ //$NON-NLS-2$
				"namespace", "##targetNamespace", //$NON-NLS-1$ //$NON-NLS-2$
				"affiliation", "http://www.ibm.com/ccl/soa/deploy/core/1.0.0/#capability" //$NON-NLS-1$ //$NON-NLS-2$
		});
		addAnnotation(getOperatingSystemRoot_CapabilityPort(), source, new String[] {
				"kind", "element", //$NON-NLS-1$ //$NON-NLS-2$
				"name", "capability.port", //$NON-NLS-1$ //$NON-NLS-2$
				"namespace", "##targetNamespace", //$NON-NLS-1$ //$NON-NLS-2$
				"affiliation", "http://www.ibm.com/ccl/soa/deploy/core/1.0.0/#capability" //$NON-NLS-1$ //$NON-NLS-2$
		});
		addAnnotation(getOperatingSystemRoot_CapabilityPortConsumer(), source, new String[] {
				"kind", "element", //$NON-NLS-1$ //$NON-NLS-2$
				"name", "capability.portConsumer", //$NON-NLS-1$ //$NON-NLS-2$
				"namespace", "##targetNamespace", //$NON-NLS-1$ //$NON-NLS-2$
				"affiliation", "http://www.ibm.com/ccl/soa/deploy/core/1.0.0/#capability" //$NON-NLS-1$ //$NON-NLS-2$
		});
		addAnnotation(getOperatingSystemRoot_CapabilityRedhatLinuxLocalGroup(), source, new String[] {
				"kind", "element", //$NON-NLS-1$ //$NON-NLS-2$
				"name", "capability.redhatLinuxLocalGroup", //$NON-NLS-1$ //$NON-NLS-2$
				"namespace", "##targetNamespace", //$NON-NLS-1$ //$NON-NLS-2$
				"affiliation", "http://www.ibm.com/ccl/soa/deploy/core/1.0.0/#capability" //$NON-NLS-1$ //$NON-NLS-2$
		});
		addAnnotation(getOperatingSystemRoot_CapabilityRedhatLinuxLocalService(), source,
				new String[] { "kind", "element", //$NON-NLS-1$ //$NON-NLS-2$
						"name", "capability.redhatLinuxLocalService", //$NON-NLS-1$ //$NON-NLS-2$
						"namespace", "##targetNamespace", //$NON-NLS-1$ //$NON-NLS-2$
						"affiliation", "http://www.ibm.com/ccl/soa/deploy/core/1.0.0/#capability" //$NON-NLS-1$ //$NON-NLS-2$
				});
		addAnnotation(getOperatingSystemRoot_CapabilityRedhatLinuxLocalUser(), source, new String[] {
				"kind", "element", //$NON-NLS-1$ //$NON-NLS-2$
				"name", "capability.redhatLinuxLocalUser", //$NON-NLS-1$ //$NON-NLS-2$
				"namespace", "##targetNamespace", //$NON-NLS-1$ //$NON-NLS-2$
				"affiliation", "http://www.ibm.com/ccl/soa/deploy/core/1.0.0/#capability" //$NON-NLS-1$ //$NON-NLS-2$
		});
		addAnnotation(getOperatingSystemRoot_CapabilityRedhatLinuxOperatingSystem(), source,
				new String[] { "kind", "element", //$NON-NLS-1$ //$NON-NLS-2$
						"name", "capability.redhatLinuxOperatingSystem", //$NON-NLS-1$ //$NON-NLS-2$
						"namespace", "##targetNamespace", //$NON-NLS-1$ //$NON-NLS-2$
						"affiliation", "http://www.ibm.com/ccl/soa/deploy/core/1.0.0/#capability" //$NON-NLS-1$ //$NON-NLS-2$
				});
		addAnnotation(getOperatingSystemRoot_CapabilityRemoteFileSystem(), source, new String[] {
				"kind", "element", //$NON-NLS-1$ //$NON-NLS-2$
				"name", "capability.remoteFileSystem", //$NON-NLS-1$ //$NON-NLS-2$
				"namespace", "##targetNamespace", //$NON-NLS-1$ //$NON-NLS-2$
				"affiliation", "http://www.ibm.com/ccl/soa/deploy/core/1.0.0/#capability" //$NON-NLS-1$ //$NON-NLS-2$
		});
		addAnnotation(getOperatingSystemRoot_CapabilitySMBFileSystem(), source, new String[] {
				"kind", "element", //$NON-NLS-1$ //$NON-NLS-2$
				"name", "capability.sMBFileSystem", //$NON-NLS-1$ //$NON-NLS-2$
				"namespace", "##targetNamespace", //$NON-NLS-1$ //$NON-NLS-2$
				"affiliation", "http://www.ibm.com/ccl/soa/deploy/core/1.0.0/#capability" //$NON-NLS-1$ //$NON-NLS-2$
		});
		addAnnotation(getOperatingSystemRoot_CapabilitySolarisFileSystem(), source, new String[] {
				"kind", "element", //$NON-NLS-1$ //$NON-NLS-2$
				"name", "capability.solarisFileSystem", //$NON-NLS-1$ //$NON-NLS-2$
				"namespace", "##targetNamespace", //$NON-NLS-1$ //$NON-NLS-2$
				"affiliation", "http://www.ibm.com/ccl/soa/deploy/core/1.0.0/#capability" //$NON-NLS-1$ //$NON-NLS-2$
		});
		addAnnotation(getOperatingSystemRoot_CapabilitySuseLinuxLocalGroup(), source, new String[] {
				"kind", "element", //$NON-NLS-1$ //$NON-NLS-2$
				"name", "capability.suseLinuxLocalGroup", //$NON-NLS-1$ //$NON-NLS-2$
				"namespace", "##targetNamespace", //$NON-NLS-1$ //$NON-NLS-2$
				"affiliation", "http://www.ibm.com/ccl/soa/deploy/core/1.0.0/#capability" //$NON-NLS-1$ //$NON-NLS-2$
		});
		addAnnotation(getOperatingSystemRoot_CapabilitySuseLinuxLocalService(), source, new String[] {
				"kind", "element", //$NON-NLS-1$ //$NON-NLS-2$
				"name", "capability.suseLinuxLocalService", //$NON-NLS-1$ //$NON-NLS-2$
				"namespace", "##targetNamespace", //$NON-NLS-1$ //$NON-NLS-2$
				"affiliation", "http://www.ibm.com/ccl/soa/deploy/core/1.0.0/#capability" //$NON-NLS-1$ //$NON-NLS-2$
		});
		addAnnotation(getOperatingSystemRoot_CapabilitySuseLinuxLocalUser(), source, new String[] {
				"kind", "element", //$NON-NLS-1$ //$NON-NLS-2$
				"name", "capability.suseLinuxLocalUser", //$NON-NLS-1$ //$NON-NLS-2$
				"namespace", "##targetNamespace", //$NON-NLS-1$ //$NON-NLS-2$
				"affiliation", "http://www.ibm.com/ccl/soa/deploy/core/1.0.0/#capability" //$NON-NLS-1$ //$NON-NLS-2$
		});
		addAnnotation(getOperatingSystemRoot_CapabilitySuseLinuxOperatingSystem(), source,
				new String[] { "kind", "element", //$NON-NLS-1$ //$NON-NLS-2$
						"name", "capability.suseLinuxOperatingSystem", //$NON-NLS-1$ //$NON-NLS-2$
						"namespace", "##targetNamespace", //$NON-NLS-1$ //$NON-NLS-2$
						"affiliation", "http://www.ibm.com/ccl/soa/deploy/core/1.0.0/#capability" //$NON-NLS-1$ //$NON-NLS-2$
				});
		addAnnotation(getOperatingSystemRoot_CapabilityUnixDirectory(), source, new String[] {
				"kind", "element", //$NON-NLS-1$ //$NON-NLS-2$
				"name", "capability.unixDirectory", //$NON-NLS-1$ //$NON-NLS-2$
				"namespace", "##targetNamespace", //$NON-NLS-1$ //$NON-NLS-2$
				"affiliation", "http://www.ibm.com/ccl/soa/deploy/core/1.0.0/#capability" //$NON-NLS-1$ //$NON-NLS-2$
		});
		addAnnotation(getOperatingSystemRoot_CapabilityUnixFileSystem(), source, new String[] {
				"kind", "element", //$NON-NLS-1$ //$NON-NLS-2$
				"name", "capability.unixFileSystem", //$NON-NLS-1$ //$NON-NLS-2$
				"namespace", "##targetNamespace", //$NON-NLS-1$ //$NON-NLS-2$
				"affiliation", "http://www.ibm.com/ccl/soa/deploy/core/1.0.0/#capability" //$NON-NLS-1$ //$NON-NLS-2$
		});
		addAnnotation(getOperatingSystemRoot_CapabilityUser(), source, new String[] {
				"kind", "element", //$NON-NLS-1$ //$NON-NLS-2$
				"name", "capability.user", //$NON-NLS-1$ //$NON-NLS-2$
				"namespace", "##targetNamespace", //$NON-NLS-1$ //$NON-NLS-2$
				"affiliation", "http://www.ibm.com/ccl/soa/deploy/core/1.0.0/#capability" //$NON-NLS-1$ //$NON-NLS-2$
		});
		addAnnotation(getOperatingSystemRoot_CapabilityUserGroup(), source, new String[] {
				"kind", "element", //$NON-NLS-1$ //$NON-NLS-2$
				"name", "capability.userGroup", //$NON-NLS-1$ //$NON-NLS-2$
				"namespace", "##targetNamespace", //$NON-NLS-1$ //$NON-NLS-2$
				"affiliation", "http://www.ibm.com/ccl/soa/deploy/core/1.0.0/#capability" //$NON-NLS-1$ //$NON-NLS-2$
		});
		addAnnotation(getOperatingSystemRoot_CapabilityWindowsDirectory(), source, new String[] {
				"kind", "element", //$NON-NLS-1$ //$NON-NLS-2$
				"name", "capability.windowsDirectory", //$NON-NLS-1$ //$NON-NLS-2$
				"namespace", "##targetNamespace", //$NON-NLS-1$ //$NON-NLS-2$
				"affiliation", "http://www.ibm.com/ccl/soa/deploy/core/1.0.0/#capability" //$NON-NLS-1$ //$NON-NLS-2$
		});
		addAnnotation(getOperatingSystemRoot_CapabilityWindowsFileSystem(), source, new String[] {
				"kind", "element", //$NON-NLS-1$ //$NON-NLS-2$
				"name", "capability.windowsFileSystem", //$NON-NLS-1$ //$NON-NLS-2$
				"namespace", "##targetNamespace", //$NON-NLS-1$ //$NON-NLS-2$
				"affiliation", "http://www.ibm.com/ccl/soa/deploy/core/1.0.0/#capability" //$NON-NLS-1$ //$NON-NLS-2$
		});
		addAnnotation(getOperatingSystemRoot_CapabilityWindowsLocalGroup(), source, new String[] {
				"kind", "element", //$NON-NLS-1$ //$NON-NLS-2$
				"name", "capability.windowsLocalGroup", //$NON-NLS-1$ //$NON-NLS-2$
				"namespace", "##targetNamespace", //$NON-NLS-1$ //$NON-NLS-2$
				"affiliation", "http://www.ibm.com/ccl/soa/deploy/core/1.0.0/#capability" //$NON-NLS-1$ //$NON-NLS-2$
		});
		addAnnotation(getOperatingSystemRoot_CapabilityWindowsLocalService(), source, new String[] {
				"kind", "element", //$NON-NLS-1$ //$NON-NLS-2$
				"name", "capability.windowsLocalService", //$NON-NLS-1$ //$NON-NLS-2$
				"namespace", "##targetNamespace", //$NON-NLS-1$ //$NON-NLS-2$
				"affiliation", "http://www.ibm.com/ccl/soa/deploy/core/1.0.0/#capability" //$NON-NLS-1$ //$NON-NLS-2$
		});
		addAnnotation(getOperatingSystemRoot_CapabilityWindowsLocalUser(), source, new String[] {
				"kind", "element", //$NON-NLS-1$ //$NON-NLS-2$
				"name", "capability.windowsLocalUser", //$NON-NLS-1$ //$NON-NLS-2$
				"namespace", "##targetNamespace", //$NON-NLS-1$ //$NON-NLS-2$
				"affiliation", "http://www.ibm.com/ccl/soa/deploy/core/1.0.0/#capability" //$NON-NLS-1$ //$NON-NLS-2$
		});
		addAnnotation(getOperatingSystemRoot_CapabilityWindowsOperatingSystem(), source,
				new String[] { "kind", "element", //$NON-NLS-1$ //$NON-NLS-2$
						"name", "capability.windowsOperatingSystem", //$NON-NLS-1$ //$NON-NLS-2$
						"namespace", "##targetNamespace", //$NON-NLS-1$ //$NON-NLS-2$
						"affiliation", "http://www.ibm.com/ccl/soa/deploy/core/1.0.0/#capability" //$NON-NLS-1$ //$NON-NLS-2$
				});
		addAnnotation(getOperatingSystemRoot_UnitAixLocalGroup(), source, new String[] {
				"kind", "element", //$NON-NLS-1$ //$NON-NLS-2$
				"name", "unit.aixLocalGroup", //$NON-NLS-1$ //$NON-NLS-2$
				"namespace", "##targetNamespace", //$NON-NLS-1$ //$NON-NLS-2$
				"affiliation", "http://www.ibm.com/ccl/soa/deploy/core/1.0.0/#unit" //$NON-NLS-1$ //$NON-NLS-2$
		});
		addAnnotation(getOperatingSystemRoot_UnitAixLocalServiceUnit(), source, new String[] {
				"kind", "element", //$NON-NLS-1$ //$NON-NLS-2$
				"name", "unit.aixLocalServiceUnit", //$NON-NLS-1$ //$NON-NLS-2$
				"namespace", "##targetNamespace", //$NON-NLS-1$ //$NON-NLS-2$
				"affiliation", "http://www.ibm.com/ccl/soa/deploy/core/1.0.0/#unit" //$NON-NLS-1$ //$NON-NLS-2$
		});
		addAnnotation(getOperatingSystemRoot_UnitAixLocalUser(), source, new String[] {
				"kind", "element", //$NON-NLS-1$ //$NON-NLS-2$
				"name", "unit.aixLocalUser", //$NON-NLS-1$ //$NON-NLS-2$
				"namespace", "##targetNamespace", //$NON-NLS-1$ //$NON-NLS-2$
				"affiliation", "http://www.ibm.com/ccl/soa/deploy/core/1.0.0/#unit" //$NON-NLS-1$ //$NON-NLS-2$
		});
		addAnnotation(getOperatingSystemRoot_UnitAixOperatingSystemUnit(), source, new String[] {
				"kind", "element", //$NON-NLS-1$ //$NON-NLS-2$
				"name", "unit.aixOperatingSystemUnit", //$NON-NLS-1$ //$NON-NLS-2$
				"namespace", "##targetNamespace", //$NON-NLS-1$ //$NON-NLS-2$
				"affiliation", "http://www.ibm.com/ccl/soa/deploy/core/1.0.0/#unit" //$NON-NLS-1$ //$NON-NLS-2$
		});
		addAnnotation(getOperatingSystemRoot_UnitDataFileUnit(), source, new String[] {
				"kind", "element", //$NON-NLS-1$ //$NON-NLS-2$
				"name", "unit.dataFileUnit", //$NON-NLS-1$ //$NON-NLS-2$
				"namespace", "##targetNamespace", //$NON-NLS-1$ //$NON-NLS-2$
				"affiliation", "http://www.ibm.com/ccl/soa/deploy/core/1.0.0/#unit" //$NON-NLS-1$ //$NON-NLS-2$
		});
		addAnnotation(getOperatingSystemRoot_UnitDirectoryUnit(), source, new String[] {
				"kind", "element", //$NON-NLS-1$ //$NON-NLS-2$
				"name", "unit.directoryUnit", //$NON-NLS-1$ //$NON-NLS-2$
				"namespace", "##targetNamespace", //$NON-NLS-1$ //$NON-NLS-2$
				"affiliation", "http://www.ibm.com/ccl/soa/deploy/core/1.0.0/#unit" //$NON-NLS-1$ //$NON-NLS-2$
		});
		addAnnotation(getOperatingSystemRoot_UnitFileSystemContentUnit(), source, new String[] {
				"kind", "element", //$NON-NLS-1$ //$NON-NLS-2$
				"name", "unit.fileSystemContentUnit", //$NON-NLS-1$ //$NON-NLS-2$
				"namespace", "##targetNamespace", //$NON-NLS-1$ //$NON-NLS-2$
				"affiliation", "http://www.ibm.com/ccl/soa/deploy/core/1.0.0/#unit" //$NON-NLS-1$ //$NON-NLS-2$
		});
		addAnnotation(getOperatingSystemRoot_UnitFileSystemUnit(), source, new String[] {
				"kind", "element", //$NON-NLS-1$ //$NON-NLS-2$
				"name", "unit.fileSystemUnit", //$NON-NLS-1$ //$NON-NLS-2$
				"namespace", "##targetNamespace", //$NON-NLS-1$ //$NON-NLS-2$
				"affiliation", "http://www.ibm.com/ccl/soa/deploy/core/1.0.0/#unit" //$NON-NLS-1$ //$NON-NLS-2$
		});
		addAnnotation(getOperatingSystemRoot_UnitLinuxLocalGroup(), source, new String[] {
				"kind", "element", //$NON-NLS-1$ //$NON-NLS-2$
				"name", "unit.linuxLocalGroup", //$NON-NLS-1$ //$NON-NLS-2$
				"namespace", "##targetNamespace", //$NON-NLS-1$ //$NON-NLS-2$
				"affiliation", "http://www.ibm.com/ccl/soa/deploy/core/1.0.0/#unit" //$NON-NLS-1$ //$NON-NLS-2$
		});
		addAnnotation(getOperatingSystemRoot_UnitLinuxLocalServiceUnit(), source, new String[] {
				"kind", "element", //$NON-NLS-1$ //$NON-NLS-2$
				"name", "unit.linuxLocalServiceUnit", //$NON-NLS-1$ //$NON-NLS-2$
				"namespace", "##targetNamespace", //$NON-NLS-1$ //$NON-NLS-2$
				"affiliation", "http://www.ibm.com/ccl/soa/deploy/core/1.0.0/#unit" //$NON-NLS-1$ //$NON-NLS-2$
		});
		addAnnotation(getOperatingSystemRoot_UnitLinuxLocalUser(), source, new String[] {
				"kind", "element", //$NON-NLS-1$ //$NON-NLS-2$
				"name", "unit.linuxLocalUser", //$NON-NLS-1$ //$NON-NLS-2$
				"namespace", "##targetNamespace", //$NON-NLS-1$ //$NON-NLS-2$
				"affiliation", "http://www.ibm.com/ccl/soa/deploy/core/1.0.0/#unit" //$NON-NLS-1$ //$NON-NLS-2$
		});
		addAnnotation(getOperatingSystemRoot_UnitLinuxOperatingSystemUnit(), source, new String[] {
				"kind", "element", //$NON-NLS-1$ //$NON-NLS-2$
				"name", "unit.linuxOperatingSystemUnit", //$NON-NLS-1$ //$NON-NLS-2$
				"namespace", "##targetNamespace", //$NON-NLS-1$ //$NON-NLS-2$
				"affiliation", "http://www.ibm.com/ccl/soa/deploy/core/1.0.0/#unit" //$NON-NLS-1$ //$NON-NLS-2$
		});
		addAnnotation(getOperatingSystemRoot_UnitLocalFileSystemUnit(), source, new String[] {
				"kind", "element", //$NON-NLS-1$ //$NON-NLS-2$
				"name", "unit.localFileSystemUnit", //$NON-NLS-1$ //$NON-NLS-2$
				"namespace", "##targetNamespace", //$NON-NLS-1$ //$NON-NLS-2$
				"affiliation", "http://www.ibm.com/ccl/soa/deploy/core/1.0.0/#unit" //$NON-NLS-1$ //$NON-NLS-2$
		});
		addAnnotation(getOperatingSystemRoot_UnitNFSFileSystemUnit(), source, new String[] {
				"kind", "element", //$NON-NLS-1$ //$NON-NLS-2$
				"name", "unit.nFSFileSystemUnit", //$NON-NLS-1$ //$NON-NLS-2$
				"namespace", "##targetNamespace", //$NON-NLS-1$ //$NON-NLS-2$
				"affiliation", "http://www.ibm.com/ccl/soa/deploy/core/1.0.0/#unit" //$NON-NLS-1$ //$NON-NLS-2$
		});
		addAnnotation(getOperatingSystemRoot_UnitOpenVmsFileSystemUnit(), source, new String[] {
				"kind", "element", //$NON-NLS-1$ //$NON-NLS-2$
				"name", "unit.openVmsFileSystemUnit", //$NON-NLS-1$ //$NON-NLS-2$
				"namespace", "##targetNamespace", //$NON-NLS-1$ //$NON-NLS-2$
				"affiliation", "http://www.ibm.com/ccl/soa/deploy/core/1.0.0/#unit" //$NON-NLS-1$ //$NON-NLS-2$
		});
		addAnnotation(getOperatingSystemRoot_UnitOperatingSystemUnit(), source, new String[] {
				"kind", "element", //$NON-NLS-1$ //$NON-NLS-2$
				"name", "unit.operatingSystemUnit", //$NON-NLS-1$ //$NON-NLS-2$
				"namespace", "##targetNamespace", //$NON-NLS-1$ //$NON-NLS-2$
				"affiliation", "http://www.ibm.com/ccl/soa/deploy/core/1.0.0/#unit" //$NON-NLS-1$ //$NON-NLS-2$
		});
		addAnnotation(getOperatingSystemRoot_UnitPortConfigUnit(), source, new String[] {
				"kind", "element", //$NON-NLS-1$ //$NON-NLS-2$
				"name", "unit.portConfigUnit", //$NON-NLS-1$ //$NON-NLS-2$
				"namespace", "##targetNamespace", //$NON-NLS-1$ //$NON-NLS-2$
				"affiliation", "http://www.ibm.com/ccl/soa/deploy/core/1.0.0/#unit" //$NON-NLS-1$ //$NON-NLS-2$
		});
		addAnnotation(getOperatingSystemRoot_UnitRemoteFileSystemUnit(), source, new String[] {
				"kind", "element", //$NON-NLS-1$ //$NON-NLS-2$
				"name", "unit.remoteFileSystemUnit", //$NON-NLS-1$ //$NON-NLS-2$
				"namespace", "##targetNamespace", //$NON-NLS-1$ //$NON-NLS-2$
				"affiliation", "http://www.ibm.com/ccl/soa/deploy/core/1.0.0/#unit" //$NON-NLS-1$ //$NON-NLS-2$
		});
		addAnnotation(getOperatingSystemRoot_UnitSMBFileSystemUnit(), source, new String[] {
				"kind", "element", //$NON-NLS-1$ //$NON-NLS-2$
				"name", "unit.sMBFileSystemUnit", //$NON-NLS-1$ //$NON-NLS-2$
				"namespace", "##targetNamespace", //$NON-NLS-1$ //$NON-NLS-2$
				"affiliation", "http://www.ibm.com/ccl/soa/deploy/core/1.0.0/#unit" //$NON-NLS-1$ //$NON-NLS-2$
		});
		addAnnotation(getOperatingSystemRoot_UnitSolarisFileSystemUnit(), source, new String[] {
				"kind", "element", //$NON-NLS-1$ //$NON-NLS-2$
				"name", "unit.solarisFileSystemUnit", //$NON-NLS-1$ //$NON-NLS-2$
				"namespace", "##targetNamespace", //$NON-NLS-1$ //$NON-NLS-2$
				"affiliation", "http://www.ibm.com/ccl/soa/deploy/core/1.0.0/#unit" //$NON-NLS-1$ //$NON-NLS-2$
		});
		addAnnotation(getOperatingSystemRoot_UnitUnixFileSystemUnit(), source, new String[] {
				"kind", "element", //$NON-NLS-1$ //$NON-NLS-2$
				"name", "unit.unixFileSystemUnit", //$NON-NLS-1$ //$NON-NLS-2$
				"namespace", "##targetNamespace", //$NON-NLS-1$ //$NON-NLS-2$
				"affiliation", "http://www.ibm.com/ccl/soa/deploy/core/1.0.0/#unit" //$NON-NLS-1$ //$NON-NLS-2$
		});
		addAnnotation(getOperatingSystemRoot_UnitUser(), source, new String[] { "kind", "element", //$NON-NLS-1$ //$NON-NLS-2$
				"name", "unit.user", //$NON-NLS-1$ //$NON-NLS-2$
				"namespace", "##targetNamespace", //$NON-NLS-1$ //$NON-NLS-2$
				"affiliation", "http://www.ibm.com/ccl/soa/deploy/core/1.0.0/#unit" //$NON-NLS-1$ //$NON-NLS-2$
		});
		addAnnotation(getOperatingSystemRoot_UnitUserGroup(), source, new String[] {
				"kind", "element", //$NON-NLS-1$ //$NON-NLS-2$
				"name", "unit.userGroup", //$NON-NLS-1$ //$NON-NLS-2$
				"namespace", "##targetNamespace", //$NON-NLS-1$ //$NON-NLS-2$
				"affiliation", "http://www.ibm.com/ccl/soa/deploy/core/1.0.0/#unit" //$NON-NLS-1$ //$NON-NLS-2$
		});
		addAnnotation(getOperatingSystemRoot_UnitWindowsFileSystemUnit(), source, new String[] {
				"kind", "element", //$NON-NLS-1$ //$NON-NLS-2$
				"name", "unit.windowsFileSystemUnit", //$NON-NLS-1$ //$NON-NLS-2$
				"namespace", "##targetNamespace", //$NON-NLS-1$ //$NON-NLS-2$
				"affiliation", "http://www.ibm.com/ccl/soa/deploy/core/1.0.0/#unit" //$NON-NLS-1$ //$NON-NLS-2$
		});
		addAnnotation(getOperatingSystemRoot_UnitWindowsLocalGroup(), source, new String[] {
				"kind", "element", //$NON-NLS-1$ //$NON-NLS-2$
				"name", "unit.windowsLocalGroup", //$NON-NLS-1$ //$NON-NLS-2$
				"namespace", "##targetNamespace", //$NON-NLS-1$ //$NON-NLS-2$
				"affiliation", "http://www.ibm.com/ccl/soa/deploy/core/1.0.0/#unit" //$NON-NLS-1$ //$NON-NLS-2$
		});
		addAnnotation(getOperatingSystemRoot_UnitWindowsLocalServiceUnit(), source, new String[] {
				"kind", "element", //$NON-NLS-1$ //$NON-NLS-2$
				"name", "unit.windowsLocalServiceUnit", //$NON-NLS-1$ //$NON-NLS-2$
				"namespace", "##targetNamespace", //$NON-NLS-1$ //$NON-NLS-2$
				"affiliation", "http://www.ibm.com/ccl/soa/deploy/core/1.0.0/#unit" //$NON-NLS-1$ //$NON-NLS-2$
		});
		addAnnotation(getOperatingSystemRoot_UnitWindowsLocalUser(), source, new String[] {
				"kind", "element", //$NON-NLS-1$ //$NON-NLS-2$
				"name", "unit.windowsLocalUser", //$NON-NLS-1$ //$NON-NLS-2$
				"namespace", "##targetNamespace", //$NON-NLS-1$ //$NON-NLS-2$
				"affiliation", "http://www.ibm.com/ccl/soa/deploy/core/1.0.0/#unit" //$NON-NLS-1$ //$NON-NLS-2$
		});
		addAnnotation(getOperatingSystemRoot_UnitWindowsOperatingSystemUnit(), source, new String[] {
				"kind", "element", //$NON-NLS-1$ //$NON-NLS-2$
				"name", "unit.windowsOperatingSystemUnit", //$NON-NLS-1$ //$NON-NLS-2$
				"namespace", "##targetNamespace", //$NON-NLS-1$ //$NON-NLS-2$
				"affiliation", "http://www.ibm.com/ccl/soa/deploy/core/1.0.0/#unit" //$NON-NLS-1$ //$NON-NLS-2$
		});
		addAnnotation(operatingSystemTypeEEnum, source, new String[] { "name", "OperatingSystemType" //$NON-NLS-1$ //$NON-NLS-2$
		});
		addAnnotation(operatingSystemTypeObjectEDataType, source, new String[] {
				"name", "OperatingSystemType:Object", //$NON-NLS-1$ //$NON-NLS-2$
				"baseType", "OperatingSystemType" //$NON-NLS-1$ //$NON-NLS-2$
		});
		addAnnotation(operatingSystemUnitEClass, source, new String[] {
				"name", "OperatingSystemUnit", //$NON-NLS-1$ //$NON-NLS-2$
				"kind", "elementOnly" //$NON-NLS-1$ //$NON-NLS-2$
		});
		addAnnotation(portEClass, source, new String[] { "name", "Port", //$NON-NLS-1$ //$NON-NLS-2$
				"kind", "elementOnly" //$NON-NLS-1$ //$NON-NLS-2$
		});
		addAnnotation(getPort_ApplicationLayerProtocol(), source, new String[] { "kind", "attribute", //$NON-NLS-1$ //$NON-NLS-2$
				"name", "applicationLayerProtocol" //$NON-NLS-1$ //$NON-NLS-2$
		});
		addAnnotation(getPort_IpAddressOrHostname(), source, new String[] { "kind", "attribute", //$NON-NLS-1$ //$NON-NLS-2$
				"name", "ipAddressOrHostname" //$NON-NLS-1$ //$NON-NLS-2$
		});
		addAnnotation(getPort_Port(), source, new String[] { "kind", "attribute", //$NON-NLS-1$ //$NON-NLS-2$
				"name", "port" //$NON-NLS-1$ //$NON-NLS-2$
		});
		addAnnotation(getPort_PortName(), source, new String[] { "kind", "attribute", //$NON-NLS-1$ //$NON-NLS-2$
				"name", "portName" //$NON-NLS-1$ //$NON-NLS-2$
		});
		addAnnotation(getPort_TransportLayerProtocol(), source, new String[] { "kind", "attribute", //$NON-NLS-1$ //$NON-NLS-2$
				"name", "transportLayerProtocol" //$NON-NLS-1$ //$NON-NLS-2$
		});
		addAnnotation(portConfigUnitEClass, source, new String[] { "name", "PortConfigUnit", //$NON-NLS-1$ //$NON-NLS-2$
				"kind", "elementOnly" //$NON-NLS-1$ //$NON-NLS-2$
		});
		addAnnotation(portConsumerEClass, source, new String[] { "name", "PortConsumer", //$NON-NLS-1$ //$NON-NLS-2$
				"kind", "elementOnly" //$NON-NLS-1$ //$NON-NLS-2$
		});
		addAnnotation(redhatDesktopTypeEEnum, source, new String[] { "name", "RedhatDesktopType" //$NON-NLS-1$ //$NON-NLS-2$
		});
		addAnnotation(redhatDesktopTypeObjectEDataType, source, new String[] {
				"name", "RedhatDesktopType:Object", //$NON-NLS-1$ //$NON-NLS-2$
				"baseType", "RedhatDesktopType" //$NON-NLS-1$ //$NON-NLS-2$
		});
		addAnnotation(redhatLinuxBootLoaderTypeEEnum, source, new String[] {
				"name", "RedhatLinuxBootLoaderType" //$NON-NLS-1$ //$NON-NLS-2$
		});
		addAnnotation(redhatLinuxBootLoaderTypeObjectEDataType, source, new String[] {
				"name", "RedhatLinuxBootLoaderType:Object", //$NON-NLS-1$ //$NON-NLS-2$
				"baseType", "RedhatLinuxBootLoaderType" //$NON-NLS-1$ //$NON-NLS-2$
		});
		addAnnotation(redhatLinuxLocalGroupEClass, source, new String[] {
				"name", "RedhatLinuxLocalGroup", //$NON-NLS-1$ //$NON-NLS-2$
				"kind", "elementOnly" //$NON-NLS-1$ //$NON-NLS-2$
		});
		addAnnotation(getRedhatLinuxLocalGroup_GroupSid(), source, new String[] {
				"kind", "attribute", //$NON-NLS-1$ //$NON-NLS-2$
				"name", "GroupSid" //$NON-NLS-1$ //$NON-NLS-2$
		});
		addAnnotation(redhatLinuxLocalServiceEClass, source, new String[] {
				"name", "RedhatLinuxLocalService", //$NON-NLS-1$ //$NON-NLS-2$
				"kind", "elementOnly" //$NON-NLS-1$ //$NON-NLS-2$
		});
		addAnnotation(redhatLinuxLocalUserEClass, source, new String[] {
				"name", "RedhatLinuxLocalUser", //$NON-NLS-1$ //$NON-NLS-2$
				"kind", "elementOnly" //$NON-NLS-1$ //$NON-NLS-2$
		});
		addAnnotation(getRedhatLinuxLocalUser_AccountDisableAfterDays(), source, new String[] {
				"kind", "attribute", //$NON-NLS-1$ //$NON-NLS-2$
				"name", "AccountDisableAfterDays" //$NON-NLS-1$ //$NON-NLS-2$
		});
		addAnnotation(getRedhatLinuxLocalUser_AccountDisableDate(), source, new String[] {
				"kind", "attribute", //$NON-NLS-1$ //$NON-NLS-2$
				"name", "AccountDisableDate" //$NON-NLS-1$ //$NON-NLS-2$
		});
		addAnnotation(getRedhatLinuxLocalUser_DaysBeforePasswordMayChange(), source, new String[] {
				"kind", "attribute", //$NON-NLS-1$ //$NON-NLS-2$
				"name", "DaysBeforePasswordMayChange" //$NON-NLS-1$ //$NON-NLS-2$
		});
		addAnnotation(getRedhatLinuxLocalUser_LastPasswordChange(), source, new String[] {
				"kind", "attribute", //$NON-NLS-1$ //$NON-NLS-2$
				"name", "LastPasswordChange" //$NON-NLS-1$ //$NON-NLS-2$
		});
		addAnnotation(getRedhatLinuxLocalUser_PasswordExpireAfterDays(), source, new String[] {
				"kind", "attribute", //$NON-NLS-1$ //$NON-NLS-2$
				"name", "PasswordExpireAfterDays" //$NON-NLS-1$ //$NON-NLS-2$
		});
		addAnnotation(getRedhatLinuxLocalUser_PasswordExpireWarningDays(), source, new String[] {
				"kind", "attribute", //$NON-NLS-1$ //$NON-NLS-2$
				"name", "PasswordExpireWarningDays" //$NON-NLS-1$ //$NON-NLS-2$
		});
		addAnnotation(getRedhatLinuxLocalUser_UserSid(), source, new String[] { "kind", "attribute", //$NON-NLS-1$ //$NON-NLS-2$
				"name", "UserSid" //$NON-NLS-1$ //$NON-NLS-2$
		});
		addAnnotation(redhatLinuxOperatingSystemEClass, source, new String[] {
				"name", "RedhatLinuxOperatingSystem", //$NON-NLS-1$ //$NON-NLS-2$
				"kind", "elementOnly" //$NON-NLS-1$ //$NON-NLS-2$
		});
		addAnnotation(getRedhatLinuxOperatingSystem_BootLoader(), source, new String[] {
				"kind", "attribute", //$NON-NLS-1$ //$NON-NLS-2$
				"name", "BootLoader" //$NON-NLS-1$ //$NON-NLS-2$
		});
		addAnnotation(getRedhatLinuxOperatingSystem_Desktop(), source, new String[] {
				"kind", "attribute", //$NON-NLS-1$ //$NON-NLS-2$
				"name", "Desktop" //$NON-NLS-1$ //$NON-NLS-2$
		});
		addAnnotation(getRedhatLinuxOperatingSystem_InstallDate(), source, new String[] {
				"kind", "attribute", //$NON-NLS-1$ //$NON-NLS-2$
				"name", "InstallDate" //$NON-NLS-1$ //$NON-NLS-2$
		});
		addAnnotation(getRedhatLinuxOperatingSystem_LastBootUpTime(), source, new String[] {
				"kind", "attribute", //$NON-NLS-1$ //$NON-NLS-2$
				"name", "LastBootUpTime" //$NON-NLS-1$ //$NON-NLS-2$
		});
		addAnnotation(getRedhatLinuxOperatingSystem_Owner(), source, new String[] {
				"kind", "attribute", //$NON-NLS-1$ //$NON-NLS-2$
				"name", "Owner" //$NON-NLS-1$ //$NON-NLS-2$
		});
		addAnnotation(getRedhatLinuxOperatingSystem_ProductType(), source, new String[] {
				"kind", "attribute", //$NON-NLS-1$ //$NON-NLS-2$
				"name", "ProductType" //$NON-NLS-1$ //$NON-NLS-2$
		});
		addAnnotation(getRedhatLinuxOperatingSystem_SELinuxState(), source, new String[] {
				"kind", "attribute", //$NON-NLS-1$ //$NON-NLS-2$
				"name", "SELinuxState" //$NON-NLS-1$ //$NON-NLS-2$
		});
		addAnnotation(redhatLinuxProductTypeTypeEEnum, source, new String[] {
				"name", "RedhatLinuxProductTypeType" //$NON-NLS-1$ //$NON-NLS-2$
		});
		addAnnotation(redhatLinuxProductTypeTypeObjectEDataType, source, new String[] {
				"name", "RedhatLinuxProductTypeType:Object", //$NON-NLS-1$ //$NON-NLS-2$
				"baseType", "RedhatLinuxProductTypeType" //$NON-NLS-1$ //$NON-NLS-2$
		});
		addAnnotation(redhatLinuxServiceStartupTypeTypeEEnum, source, new String[] {
				"name", "RedhatLinuxServiceStartupTypeType" //$NON-NLS-1$ //$NON-NLS-2$
		});
		addAnnotation(redhatLinuxServiceStartupTypeTypeObjectEDataType, source, new String[] {
				"name", "RedhatLinuxServiceStartupTypeType:Object", //$NON-NLS-1$ //$NON-NLS-2$
				"baseType", "RedhatLinuxServiceStartupTypeType" //$NON-NLS-1$ //$NON-NLS-2$
		});
		addAnnotation(redhatLinuxServiceStatusTypeEEnum, source, new String[] {
				"name", "RedhatLinuxServiceStatusType" //$NON-NLS-1$ //$NON-NLS-2$
		});
		addAnnotation(redhatLinuxServiceStatusTypeObjectEDataType, source, new String[] {
				"name", "RedhatLinuxServiceStatusType:Object", //$NON-NLS-1$ //$NON-NLS-2$
				"baseType", "RedhatLinuxServiceStatusType" //$NON-NLS-1$ //$NON-NLS-2$
		});
		addAnnotation(remoteFileSystemEClass, source, new String[] { "name", "RemoteFileSystem", //$NON-NLS-1$ //$NON-NLS-2$
				"kind", "elementOnly" //$NON-NLS-1$ //$NON-NLS-2$
		});
		addAnnotation(getRemoteFileSystem_ExportName(), source, new String[] { "kind", "attribute", //$NON-NLS-1$ //$NON-NLS-2$
				"name", "ExportName" //$NON-NLS-1$ //$NON-NLS-2$
		});
		addAnnotation(getRemoteFileSystem_ServerName(), source, new String[] { "kind", "attribute", //$NON-NLS-1$ //$NON-NLS-2$
				"name", "ServerName" //$NON-NLS-1$ //$NON-NLS-2$
		});
		addAnnotation(remoteFileSystemUnitEClass, source, new String[] {
				"name", "RemoteFileSystemUnit", //$NON-NLS-1$ //$NON-NLS-2$
				"kind", "elementOnly" //$NON-NLS-1$ //$NON-NLS-2$
		});
		addAnnotation(seLinuxStateTypeEEnum, source, new String[] { "name", "SELinuxStateType" //$NON-NLS-1$ //$NON-NLS-2$
		});
		addAnnotation(seLinuxStateTypeObjectEDataType, source, new String[] {
				"name", "SELinuxStateType:Object", //$NON-NLS-1$ //$NON-NLS-2$
				"baseType", "SELinuxStateType" //$NON-NLS-1$ //$NON-NLS-2$
		});
		addAnnotation(smbFileSystemEClass, source, new String[] { "name", "SMBFileSystem", //$NON-NLS-1$ //$NON-NLS-2$
				"kind", "elementOnly" //$NON-NLS-1$ //$NON-NLS-2$
		});
		addAnnotation(smbFileSystemUnitEClass, source, new String[] { "name", "SMBFileSystemUnit", //$NON-NLS-1$ //$NON-NLS-2$
				"kind", "elementOnly" //$NON-NLS-1$ //$NON-NLS-2$
		});
		addAnnotation(solarisFileSystemEClass, source, new String[] { "name", "SolarisFileSystem", //$NON-NLS-1$ //$NON-NLS-2$
				"kind", "elementOnly" //$NON-NLS-1$ //$NON-NLS-2$
		});
		addAnnotation(solarisFileSystemUnitEClass, source, new String[] {
				"name", "SolarisFileSystemUnit", //$NON-NLS-1$ //$NON-NLS-2$
				"kind", "elementOnly" //$NON-NLS-1$ //$NON-NLS-2$
		});
		addAnnotation(suseDesktopTypeEEnum, source, new String[] { "name", "SUSEDesktopType" //$NON-NLS-1$ //$NON-NLS-2$
		});
		addAnnotation(suseDesktopTypeObjectEDataType, source, new String[] {
				"name", "SUSEDesktopType:Object", //$NON-NLS-1$ //$NON-NLS-2$
				"baseType", "SUSEDesktopType" //$NON-NLS-1$ //$NON-NLS-2$
		});
		addAnnotation(suseLinuxBootLoaderTypeEEnum, source, new String[] {
				"name", "SUSELinuxBootLoaderType" //$NON-NLS-1$ //$NON-NLS-2$
		});
		addAnnotation(suseLinuxBootLoaderTypeObjectEDataType, source, new String[] {
				"name", "SUSELinuxBootLoaderType:Object", //$NON-NLS-1$ //$NON-NLS-2$
				"baseType", "SUSELinuxBootLoaderType" //$NON-NLS-1$ //$NON-NLS-2$
		});
		addAnnotation(suseLinuxLocalGroupEClass, source, new String[] {
				"name", "SUSELinuxLocalGroup", //$NON-NLS-1$ //$NON-NLS-2$
				"kind", "elementOnly" //$NON-NLS-1$ //$NON-NLS-2$
		});
		addAnnotation(getSUSELinuxLocalGroup_GroupId(), source, new String[] { "kind", "attribute", //$NON-NLS-1$ //$NON-NLS-2$
				"name", "GroupId" //$NON-NLS-1$ //$NON-NLS-2$
		});
		addAnnotation(suseLinuxLocalServiceEClass, source, new String[] {
				"name", "SUSELinuxLocalService", //$NON-NLS-1$ //$NON-NLS-2$
				"kind", "elementOnly" //$NON-NLS-1$ //$NON-NLS-2$
		});
		addAnnotation(suseLinuxLocalUserEClass, source, new String[] { "name", "SUSELinuxLocalUser", //$NON-NLS-1$ //$NON-NLS-2$
				"kind", "elementOnly" //$NON-NLS-1$ //$NON-NLS-2$
		});
		addAnnotation(suseLinuxOperatingSystemEClass, source, new String[] {
				"name", "SUSELinuxOperatingSystem", //$NON-NLS-1$ //$NON-NLS-2$
				"kind", "elementOnly" //$NON-NLS-1$ //$NON-NLS-2$
		});
		addAnnotation(getSUSELinuxOperatingSystem_BootLoader(), source, new String[] {
				"kind", "attribute", //$NON-NLS-1$ //$NON-NLS-2$
				"name", "BootLoader" //$NON-NLS-1$ //$NON-NLS-2$
		});
		addAnnotation(getSUSELinuxOperatingSystem_Desktop(), source, new String[] {
				"kind", "attribute", //$NON-NLS-1$ //$NON-NLS-2$
				"name", "Desktop" //$NON-NLS-1$ //$NON-NLS-2$
		});
		addAnnotation(getSUSELinuxOperatingSystem_LastBootUpDate(), source, new String[] {
				"kind", "attribute", //$NON-NLS-1$ //$NON-NLS-2$
				"name", "LastBootUpDate" //$NON-NLS-1$ //$NON-NLS-2$
		});
		addAnnotation(suseLinuxServiceStartupTypeTypeEEnum, source, new String[] {
				"name", "SUSELinuxServiceStartupTypeType" //$NON-NLS-1$ //$NON-NLS-2$
		});
		addAnnotation(suseLinuxServiceStartupTypeTypeObjectEDataType, source, new String[] {
				"name", "SUSELinuxServiceStartupTypeType:Object", //$NON-NLS-1$ //$NON-NLS-2$
				"baseType", "SUSELinuxServiceStartupTypeType" //$NON-NLS-1$ //$NON-NLS-2$
		});
		addAnnotation(suseLinuxServiceStatusTypeEEnum, source, new String[] {
				"name", "SUSELinuxServiceStatusType" //$NON-NLS-1$ //$NON-NLS-2$
		});
		addAnnotation(suseLinuxServiceStatusTypeObjectEDataType, source, new String[] {
				"name", "SUSELinuxServiceStatusType:Object", //$NON-NLS-1$ //$NON-NLS-2$
				"baseType", "SUSELinuxServiceStatusType" //$NON-NLS-1$ //$NON-NLS-2$
		});
		addAnnotation(tcpPortTypeEDataType, source, new String[] { "name", "TCPPortType", //$NON-NLS-1$ //$NON-NLS-2$
				"baseType", "http://www.ibm.com/ccl/soa/deploy/core/1.0.0/#PortType" //$NON-NLS-1$ //$NON-NLS-2$
		});
		addAnnotation(transportLayerProtocolTypeEEnum, source, new String[] {
				"name", "TransportLayerProtocolType" //$NON-NLS-1$ //$NON-NLS-2$
		});
		addAnnotation(transportLayerProtocolTypeObjectEDataType, source, new String[] {
				"name", "TransportLayerProtocolType:Object", //$NON-NLS-1$ //$NON-NLS-2$
				"baseType", "TransportLayerProtocolType" //$NON-NLS-1$ //$NON-NLS-2$
		});
		addAnnotation(udpPortTypeEDataType, source, new String[] { "name", "UDPPortType", //$NON-NLS-1$ //$NON-NLS-2$
				"baseType", "http://www.ibm.com/ccl/soa/deploy/core/1.0.0/#PortType" //$NON-NLS-1$ //$NON-NLS-2$
		});
		addAnnotation(unixDirectoryEClass, source, new String[] { "name", "UnixDirectory", //$NON-NLS-1$ //$NON-NLS-2$
				"kind", "elementOnly" //$NON-NLS-1$ //$NON-NLS-2$
		});
		addAnnotation(unixFileSystemEClass, source, new String[] { "name", "UnixFileSystem", //$NON-NLS-1$ //$NON-NLS-2$
				"kind", "elementOnly" //$NON-NLS-1$ //$NON-NLS-2$
		});
		addAnnotation(unixFileSystemUnitEClass, source, new String[] { "name", "UnixFileSystemUnit", //$NON-NLS-1$ //$NON-NLS-2$
				"kind", "elementOnly" //$NON-NLS-1$ //$NON-NLS-2$
		});
		addAnnotation(userEClass, source, new String[] { "name", "User", //$NON-NLS-1$ //$NON-NLS-2$
				"kind", "elementOnly" //$NON-NLS-1$ //$NON-NLS-2$
		});
		addAnnotation(getUser_UserId(), source, new String[] { "kind", "attribute", //$NON-NLS-1$ //$NON-NLS-2$
				"name", "userId" //$NON-NLS-1$ //$NON-NLS-2$
		});
		addAnnotation(getUser_UserPassword(), source, new String[] { "kind", "attribute", //$NON-NLS-1$ //$NON-NLS-2$
				"name", "userPassword" //$NON-NLS-1$ //$NON-NLS-2$
		});
		addAnnotation(userGroupEClass, source, new String[] { "name", "UserGroup", //$NON-NLS-1$ //$NON-NLS-2$
				"kind", "elementOnly" //$NON-NLS-1$ //$NON-NLS-2$
		});
		addAnnotation(getUserGroup_GroupName(), source, new String[] { "kind", "attribute", //$NON-NLS-1$ //$NON-NLS-2$
				"name", "groupName" //$NON-NLS-1$ //$NON-NLS-2$
		});
		addAnnotation(userGroupUnitEClass, source, new String[] { "name", "UserGroupUnit", //$NON-NLS-1$ //$NON-NLS-2$
				"kind", "elementOnly" //$NON-NLS-1$ //$NON-NLS-2$
		});
		addAnnotation(userUnitEClass, source, new String[] { "name", "UserUnit", //$NON-NLS-1$ //$NON-NLS-2$
				"kind", "elementOnly" //$NON-NLS-1$ //$NON-NLS-2$
		});
		addAnnotation(windowsDirectoryEClass, source, new String[] { "name", "WindowsDirectory", //$NON-NLS-1$ //$NON-NLS-2$
				"kind", "elementOnly" //$NON-NLS-1$ //$NON-NLS-2$
		});
		addAnnotation(windowsDirectoryTypeEEnum, source, new String[] {
				"name", "WindowsDirectoryType" //$NON-NLS-1$ //$NON-NLS-2$
		});
		addAnnotation(windowsDirectoryTypeObjectEDataType, source, new String[] {
				"name", "WindowsDirectoryType:Object", //$NON-NLS-1$ //$NON-NLS-2$
				"baseType", "WindowsDirectoryType" //$NON-NLS-1$ //$NON-NLS-2$
		});
		addAnnotation(windowsFileSystemEClass, source, new String[] { "name", "WindowsFileSystem", //$NON-NLS-1$ //$NON-NLS-2$
				"kind", "elementOnly" //$NON-NLS-1$ //$NON-NLS-2$
		});
		addAnnotation(windowsFileSystemUnitEClass, source, new String[] {
				"name", "WindowsFileSystemUnit", //$NON-NLS-1$ //$NON-NLS-2$
				"kind", "elementOnly" //$NON-NLS-1$ //$NON-NLS-2$
		});
		addAnnotation(windowsLocalGroupEClass, source, new String[] { "name", "WindowsLocalGroup", //$NON-NLS-1$ //$NON-NLS-2$
				"kind", "elementOnly" //$NON-NLS-1$ //$NON-NLS-2$
		});
		addAnnotation(getWindowsLocalGroup_Description1(), source, new String[] {
				"kind", "attribute", //$NON-NLS-1$ //$NON-NLS-2$
				"name", "Description" //$NON-NLS-1$ //$NON-NLS-2$
		});
		addAnnotation(getWindowsLocalGroup_GroupSid(), source, new String[] { "kind", "attribute", //$NON-NLS-1$ //$NON-NLS-2$
				"name", "GroupSid" //$NON-NLS-1$ //$NON-NLS-2$
		});
		addAnnotation(windowsLocalGroupUnitEClass, source, new String[] {
				"name", "WindowsLocalGroupUnit", //$NON-NLS-1$ //$NON-NLS-2$
				"kind", "elementOnly" //$NON-NLS-1$ //$NON-NLS-2$
		});
		addAnnotation(windowsLocalServiceEClass, source, new String[] {
				"name", "WindowsLocalService", //$NON-NLS-1$ //$NON-NLS-2$
				"kind", "elementOnly" //$NON-NLS-1$ //$NON-NLS-2$
		});
		addAnnotation(getWindowsLocalService_DependantComponents(), source, new String[] {
				"kind", "attribute", //$NON-NLS-1$ //$NON-NLS-2$
				"name", "DependantComponents" //$NON-NLS-1$ //$NON-NLS-2$
		});
		addAnnotation(getWindowsLocalService_ErrorControl(), source, new String[] {
				"kind", "attribute", //$NON-NLS-1$ //$NON-NLS-2$
				"name", "ErrorControl" //$NON-NLS-1$ //$NON-NLS-2$
		});
		addAnnotation(getWindowsLocalService_ExecutablePath(), source, new String[] {
				"kind", "attribute", //$NON-NLS-1$ //$NON-NLS-2$
				"name", "ExecutablePath" //$NON-NLS-1$ //$NON-NLS-2$
		});
		addAnnotation(getWindowsLocalService_LogOnAsSystem(), source, new String[] {
				"kind", "attribute", //$NON-NLS-1$ //$NON-NLS-2$
				"name", "LogOnAsSystem" //$NON-NLS-1$ //$NON-NLS-2$
		});
		addAnnotation(getWindowsLocalService_RunProgram(), source, new String[] {
				"kind", "attribute", //$NON-NLS-1$ //$NON-NLS-2$
				"name", "RunProgram" //$NON-NLS-1$ //$NON-NLS-2$
		});
		addAnnotation(getWindowsLocalService_ServiceAccount(), source, new String[] {
				"kind", "attribute", //$NON-NLS-1$ //$NON-NLS-2$
				"name", "ServiceAccount" //$NON-NLS-1$ //$NON-NLS-2$
		});
		addAnnotation(getWindowsLocalService_ServiceAccountPassword(), source, new String[] {
				"kind", "attribute", //$NON-NLS-1$ //$NON-NLS-2$
				"name", "ServiceAccountPassword" //$NON-NLS-1$ //$NON-NLS-2$
		});
		addAnnotation(getWindowsLocalService_ServiceDependencies(), source, new String[] {
				"kind", "attribute", //$NON-NLS-1$ //$NON-NLS-2$
				"name", "ServiceDependencies" //$NON-NLS-1$ //$NON-NLS-2$
		});
		addAnnotation(getWindowsLocalService_ServiceDescription(), source, new String[] {
				"kind", "attribute", //$NON-NLS-1$ //$NON-NLS-2$
				"name", "ServiceDescription" //$NON-NLS-1$ //$NON-NLS-2$
		});
		addAnnotation(getWindowsLocalService_ServiceDisplayName(), source, new String[] {
				"kind", "attribute", //$NON-NLS-1$ //$NON-NLS-2$
				"name", "ServiceDisplayName" //$NON-NLS-1$ //$NON-NLS-2$
		});
		addAnnotation(getWindowsLocalService_ServiceName(), source, new String[] {
				"kind", "attribute", //$NON-NLS-1$ //$NON-NLS-2$
				"name", "ServiceName" //$NON-NLS-1$ //$NON-NLS-2$
		});
		addAnnotation(getWindowsLocalService_ServiceStatus(), source, new String[] {
				"kind", "attribute", //$NON-NLS-1$ //$NON-NLS-2$
				"name", "ServiceStatus" //$NON-NLS-1$ //$NON-NLS-2$
		});
		addAnnotation(getWindowsLocalService_StartParams(), source, new String[] {
				"kind", "attribute", //$NON-NLS-1$ //$NON-NLS-2$
				"name", "StartParams" //$NON-NLS-1$ //$NON-NLS-2$
		});
		addAnnotation(getWindowsLocalService_StartupType(), source, new String[] {
				"kind", "attribute", //$NON-NLS-1$ //$NON-NLS-2$
				"name", "StartupType" //$NON-NLS-1$ //$NON-NLS-2$
		});
		addAnnotation(windowsLocalServiceUnitEClass, source, new String[] {
				"name", "WindowsLocalServiceUnit", //$NON-NLS-1$ //$NON-NLS-2$
				"kind", "elementOnly" //$NON-NLS-1$ //$NON-NLS-2$
		});
		addAnnotation(windowsLocalUserEClass, source, new String[] { "name", "WindowsLocalUser", //$NON-NLS-1$ //$NON-NLS-2$
				"kind", "elementOnly" //$NON-NLS-1$ //$NON-NLS-2$
		});
		addAnnotation(getWindowsLocalUser_AccountDescription(), source, new String[] {
				"kind", "attribute", //$NON-NLS-1$ //$NON-NLS-2$
				"name", "AccountDescription" //$NON-NLS-1$ //$NON-NLS-2$
		});
		addAnnotation(getWindowsLocalUser_AccountDisabled(), source, new String[] {
				"kind", "attribute", //$NON-NLS-1$ //$NON-NLS-2$
				"name", "AccountDisabled" //$NON-NLS-1$ //$NON-NLS-2$
		});
		addAnnotation(getWindowsLocalUser_AccountLocked(), source, new String[] {
				"kind", "attribute", //$NON-NLS-1$ //$NON-NLS-2$
				"name", "AccountLocked" //$NON-NLS-1$ //$NON-NLS-2$
		});
		addAnnotation(getWindowsLocalUser_ChangePasswordNextLogon(), source, new String[] {
				"kind", "attribute", //$NON-NLS-1$ //$NON-NLS-2$
				"name", "ChangePasswordNextLogon" //$NON-NLS-1$ //$NON-NLS-2$
		});
		addAnnotation(getWindowsLocalUser_EnableRemoteControl(), source, new String[] {
				"kind", "attribute", //$NON-NLS-1$ //$NON-NLS-2$
				"name", "EnableRemoteControl" //$NON-NLS-1$ //$NON-NLS-2$
		});
		addAnnotation(getWindowsLocalUser_FullName(), source, new String[] { "kind", "attribute", //$NON-NLS-1$ //$NON-NLS-2$
				"name", "FullName" //$NON-NLS-1$ //$NON-NLS-2$
		});
		addAnnotation(getWindowsLocalUser_HomeFolder(), source, new String[] { "kind", "attribute", //$NON-NLS-1$ //$NON-NLS-2$
				"name", "HomeFolder" //$NON-NLS-1$ //$NON-NLS-2$
		});
		addAnnotation(getWindowsLocalUser_LogonScript(), source, new String[] { "kind", "attribute", //$NON-NLS-1$ //$NON-NLS-2$
				"name", "LogonScript" //$NON-NLS-1$ //$NON-NLS-2$
		});
		addAnnotation(getWindowsLocalUser_PasswordNeverExpires(), source, new String[] {
				"kind", "attribute", //$NON-NLS-1$ //$NON-NLS-2$
				"name", "PasswordNeverExpires" //$NON-NLS-1$ //$NON-NLS-2$
		});
		addAnnotation(getWindowsLocalUser_ProfilePath(), source, new String[] { "kind", "attribute", //$NON-NLS-1$ //$NON-NLS-2$
				"name", "ProfilePath" //$NON-NLS-1$ //$NON-NLS-2$
		});
		addAnnotation(getWindowsLocalUser_UserAccountType(), source, new String[] {
				"kind", "attribute", //$NON-NLS-1$ //$NON-NLS-2$
				"name", "UserAccountType" //$NON-NLS-1$ //$NON-NLS-2$
		});
		addAnnotation(getWindowsLocalUser_UserCannotChangePassword(), source, new String[] {
				"kind", "attribute", //$NON-NLS-1$ //$NON-NLS-2$
				"name", "UserCannotChangePassword" //$NON-NLS-1$ //$NON-NLS-2$
		});
		addAnnotation(getWindowsLocalUser_UserSid(), source, new String[] { "kind", "attribute", //$NON-NLS-1$ //$NON-NLS-2$
				"name", "UserSid" //$NON-NLS-1$ //$NON-NLS-2$
		});
		addAnnotation(getWindowsLocalUser_UserSidType(), source, new String[] { "kind", "attribute", //$NON-NLS-1$ //$NON-NLS-2$
				"name", "UserSidType" //$NON-NLS-1$ //$NON-NLS-2$
		});
		addAnnotation(windowsLocalUserUnitEClass, source, new String[] {
				"name", "WindowsLocalUserUnit", //$NON-NLS-1$ //$NON-NLS-2$
				"kind", "elementOnly" //$NON-NLS-1$ //$NON-NLS-2$
		});
		addAnnotation(windowsOperatingSystemEClass, source, new String[] {
				"name", "WindowsOperatingSystem", //$NON-NLS-1$ //$NON-NLS-2$
				"kind", "elementOnly" //$NON-NLS-1$ //$NON-NLS-2$
		});
		addAnnotation(getWindowsOperatingSystem_Company(), source, new String[] {
				"kind", "attribute", //$NON-NLS-1$ //$NON-NLS-2$
				"name", "Company" //$NON-NLS-1$ //$NON-NLS-2$
		});
		addAnnotation(getWindowsOperatingSystem_DomainAdmin(), source, new String[] {
				"kind", "attribute", //$NON-NLS-1$ //$NON-NLS-2$
				"name", "DomainAdmin" //$NON-NLS-1$ //$NON-NLS-2$
		});
		addAnnotation(getWindowsOperatingSystem_DomainName(), source, new String[] {
				"kind", "attribute", //$NON-NLS-1$ //$NON-NLS-2$
				"name", "DomainName" //$NON-NLS-1$ //$NON-NLS-2$
		});
		addAnnotation(getWindowsOperatingSystem_DomainPassword(), source, new String[] {
				"kind", "attribute", //$NON-NLS-1$ //$NON-NLS-2$
				"name", "DomainPassword" //$NON-NLS-1$ //$NON-NLS-2$
		});
		addAnnotation(getWindowsOperatingSystem_EncryptionLevel(), source, new String[] {
				"kind", "attribute", //$NON-NLS-1$ //$NON-NLS-2$
				"name", "EncryptionLevel" //$NON-NLS-1$ //$NON-NLS-2$
		});
		addAnnotation(getWindowsOperatingSystem_InstallDate(), source, new String[] {
				"kind", "attribute", //$NON-NLS-1$ //$NON-NLS-2$
				"name", "InstallDate" //$NON-NLS-1$ //$NON-NLS-2$
		});
		addAnnotation(getWindowsOperatingSystem_Language(), source, new String[] {
				"kind", "attribute", //$NON-NLS-1$ //$NON-NLS-2$
				"name", "Language" //$NON-NLS-1$ //$NON-NLS-2$
		});
		addAnnotation(getWindowsOperatingSystem_LanguageGroup(), source, new String[] {
				"kind", "attribute", //$NON-NLS-1$ //$NON-NLS-2$
				"name", "LanguageGroup" //$NON-NLS-1$ //$NON-NLS-2$
		});
		addAnnotation(getWindowsOperatingSystem_LastBootUpTime(), source, new String[] {
				"kind", "attribute", //$NON-NLS-1$ //$NON-NLS-2$
				"name", "LastBootUpTime" //$NON-NLS-1$ //$NON-NLS-2$
		});
		addAnnotation(getWindowsOperatingSystem_MachineObjectOU(), source, new String[] {
				"kind", "attribute", //$NON-NLS-1$ //$NON-NLS-2$
				"name", "MachineObjectOU" //$NON-NLS-1$ //$NON-NLS-2$
		});
		addAnnotation(getWindowsOperatingSystem_NumberOfLicensedUsers(), source, new String[] {
				"kind", "attribute", //$NON-NLS-1$ //$NON-NLS-2$
				"name", "NumberOfLicensedUsers" //$NON-NLS-1$ //$NON-NLS-2$
		});
		addAnnotation(getWindowsOperatingSystem_Owner(), source, new String[] { "kind", "attribute", //$NON-NLS-1$ //$NON-NLS-2$
				"name", "Owner" //$NON-NLS-1$ //$NON-NLS-2$
		});
		addAnnotation(getWindowsOperatingSystem_ProductKey(), source, new String[] {
				"kind", "attribute", //$NON-NLS-1$ //$NON-NLS-2$
				"name", "ProductKey" //$NON-NLS-1$ //$NON-NLS-2$
		});
		addAnnotation(getWindowsOperatingSystem_ProductType(), source, new String[] {
				"kind", "attribute", //$NON-NLS-1$ //$NON-NLS-2$
				"name", "ProductType" //$NON-NLS-1$ //$NON-NLS-2$
		});
		addAnnotation(getWindowsOperatingSystem_SystemDrive(), source, new String[] {
				"kind", "attribute", //$NON-NLS-1$ //$NON-NLS-2$
				"name", "SystemDrive" //$NON-NLS-1$ //$NON-NLS-2$
		});
		addAnnotation(getWindowsOperatingSystem_WindowsDirectory(), source, new String[] {
				"kind", "attribute", //$NON-NLS-1$ //$NON-NLS-2$
				"name", "WindowsDirectory" //$NON-NLS-1$ //$NON-NLS-2$
		});
		addAnnotation(getWindowsOperatingSystem_WorkgroupName(), source, new String[] {
				"kind", "attribute", //$NON-NLS-1$ //$NON-NLS-2$
				"name", "WorkgroupName" //$NON-NLS-1$ //$NON-NLS-2$
		});
		addAnnotation(windowsOperatingSystemUnitEClass, source, new String[] {
				"name", "WindowsOperatingSystemUnit", //$NON-NLS-1$ //$NON-NLS-2$
				"kind", "elementOnly" //$NON-NLS-1$ //$NON-NLS-2$
		});
		addAnnotation(windowsProductTypeTypeEEnum, source, new String[] {
				"name", "WindowsProductTypeType" //$NON-NLS-1$ //$NON-NLS-2$
		});
		addAnnotation(windowsProductTypeTypeObjectEDataType, source, new String[] {
				"name", "WindowsProductTypeType:Object", //$NON-NLS-1$ //$NON-NLS-2$
				"baseType", "WindowsProductTypeType" //$NON-NLS-1$ //$NON-NLS-2$
		});
		addAnnotation(windowsServiceErrorControlTypeEEnum, source, new String[] {
				"name", "WindowsServiceErrorControlType" //$NON-NLS-1$ //$NON-NLS-2$
		});
		addAnnotation(windowsServiceErrorControlTypeObjectEDataType, source, new String[] {
				"name", "WindowsServiceErrorControlType:Object", //$NON-NLS-1$ //$NON-NLS-2$
				"baseType", "WindowsServiceErrorControlType" //$NON-NLS-1$ //$NON-NLS-2$
		});
		addAnnotation(windowsServiceStartupTypeEEnum, source, new String[] {
				"name", "WindowsServiceStartupType" //$NON-NLS-1$ //$NON-NLS-2$
		});
		addAnnotation(windowsServiceStartupTypeObjectEDataType, source, new String[] {
				"name", "WindowsServiceStartupType:Object", //$NON-NLS-1$ //$NON-NLS-2$
				"baseType", "WindowsServiceStartupType" //$NON-NLS-1$ //$NON-NLS-2$
		});
		addAnnotation(windowsServiceStatusTypeEEnum, source, new String[] {
				"name", "WindowsServiceStatusType" //$NON-NLS-1$ //$NON-NLS-2$
		});
		addAnnotation(windowsServiceStatusTypeObjectEDataType, source, new String[] {
				"name", "WindowsServiceStatusType:Object", //$NON-NLS-1$ //$NON-NLS-2$
				"baseType", "WindowsServiceStatusType" //$NON-NLS-1$ //$NON-NLS-2$
		});
	}

} //OsPackageImpl
