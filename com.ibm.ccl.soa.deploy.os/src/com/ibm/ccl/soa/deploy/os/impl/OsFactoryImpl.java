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

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EDataType;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.impl.EFactoryImpl;
import org.eclipse.emf.ecore.plugin.EcorePlugin;

import com.ibm.ccl.soa.deploy.core.CoreFactory;
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
 * <!-- begin-user-doc --> An implementation of the model <b>Factory</b>. <!-- end-user-doc -->
 * @generated
 */
public class OsFactoryImpl extends EFactoryImpl implements OsFactory {
	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public static final String copyright = "Copyright (c) 2005, 2006 IBM Corporation. Licensed Material - Property of IBM. All rights reserved."; //$NON-NLS-1$

	/**
	 * Creates the default factory implementation.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public static OsFactory init() {
		try {
			OsFactory theOsFactory = (OsFactory) EPackage.Registry.INSTANCE
					.getEFactory("http://www.ibm.com/ccl/soa/deploy/os/1.0.0/"); //$NON-NLS-1$ 
			if (theOsFactory != null) {
				return theOsFactory;
			}
		} catch (Exception exception) {
			EcorePlugin.INSTANCE.log(exception);
		}
		return new OsFactoryImpl();
	}

	/**
	 * Creates an instance of the factory.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public OsFactoryImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EObject create(EClass eClass) {
		switch (eClass.getClassifierID())
		{
		case OsPackage.AIX_LOCAL_GROUP:
			return createAIXLocalGroup();
		case OsPackage.AIX_LOCAL_GROUP_UNIT:
			return createAIXLocalGroupUnit();
		case OsPackage.AIX_LOCAL_SERVICE:
			return createAIXLocalService();
		case OsPackage.AIX_LOCAL_SERVICE_UNIT:
			return createAIXLocalServiceUnit();
		case OsPackage.AIX_LOCAL_USER:
			return createAIXLocalUser();
		case OsPackage.AIX_LOCAL_USER_UNIT:
			return createAIXLocalUserUnit();
		case OsPackage.AIX_OPERATING_SYSTEM:
			return createAIXOperatingSystem();
		case OsPackage.AIX_OPERATING_SYSTEM_UNIT:
			return createAIXOperatingSystemUnit();
		case OsPackage.DATA_FILE:
			return createDataFile();
		case OsPackage.DATA_FILE_UNIT:
			return createDataFileUnit();
		case OsPackage.DIRECTORY:
			return createDirectory();
		case OsPackage.DIRECTORY_UNIT:
			return createDirectoryUnit();
		case OsPackage.FILE_SYSTEM:
			return createFileSystem();
		case OsPackage.FILE_SYSTEM_CONTENT:
			return createFileSystemContent();
		case OsPackage.FILE_SYSTEM_CONTENT_UNIT:
			return createFileSystemContentUnit();
		case OsPackage.FILE_SYSTEM_UNIT:
			return createFileSystemUnit();
		case OsPackage.LINUX_LOCAL_GROUP:
			return createLinuxLocalGroup();
		case OsPackage.LINUX_LOCAL_GROUP_UNIT:
			return createLinuxLocalGroupUnit();
		case OsPackage.LINUX_LOCAL_SERVICE:
			return createLinuxLocalService();
		case OsPackage.LINUX_LOCAL_SERVICE_UNIT:
			return createLinuxLocalServiceUnit();
		case OsPackage.LINUX_LOCAL_USER:
			return createLinuxLocalUser();
		case OsPackage.LINUX_LOCAL_USER_UNIT:
			return createLinuxLocalUserUnit();
		case OsPackage.LINUX_OPERATING_SYSTEM:
			return createLinuxOperatingSystem();
		case OsPackage.LINUX_OPERATING_SYSTEM_UNIT:
			return createLinuxOperatingSystemUnit();
		case OsPackage.LOCAL_FILE_SYSTEM:
			return createLocalFileSystem();
		case OsPackage.LOCAL_FILE_SYSTEM_UNIT:
			return createLocalFileSystemUnit();
		case OsPackage.NFS_FILE_SYSTEM:
			return createNFSFileSystem();
		case OsPackage.NFS_FILE_SYSTEM_UNIT:
			return createNFSFileSystemUnit();
		case OsPackage.OPEN_VMS_FILE_SYSTEM:
			return createOpenVmsFileSystem();
		case OsPackage.OPEN_VMS_FILE_SYSTEM_UNIT:
			return createOpenVmsFileSystemUnit();
		case OsPackage.OPERATING_SYSTEM:
			return createOperatingSystem();
		case OsPackage.OPERATING_SYSTEM_ROOT:
			return (EObject) createOperatingSystemRoot();
		case OsPackage.OPERATING_SYSTEM_UNIT:
			return createOperatingSystemUnit();
		case OsPackage.PORT:
			return createPort();
		case OsPackage.PORT_CONFIG_UNIT:
			return createPortConfigUnit();
		case OsPackage.PORT_CONSUMER:
			return createPortConsumer();
		case OsPackage.REDHAT_LINUX_LOCAL_GROUP:
			return createRedhatLinuxLocalGroup();
		case OsPackage.REDHAT_LINUX_LOCAL_SERVICE:
			return createRedhatLinuxLocalService();
		case OsPackage.REDHAT_LINUX_LOCAL_USER:
			return createRedhatLinuxLocalUser();
		case OsPackage.REDHAT_LINUX_OPERATING_SYSTEM:
			return createRedhatLinuxOperatingSystem();
		case OsPackage.REMOTE_FILE_SYSTEM:
			return createRemoteFileSystem();
		case OsPackage.REMOTE_FILE_SYSTEM_UNIT:
			return createRemoteFileSystemUnit();
		case OsPackage.SMB_FILE_SYSTEM:
			return createSMBFileSystem();
		case OsPackage.SMB_FILE_SYSTEM_UNIT:
			return createSMBFileSystemUnit();
		case OsPackage.SOLARIS_FILE_SYSTEM:
			return createSolarisFileSystem();
		case OsPackage.SOLARIS_FILE_SYSTEM_UNIT:
			return createSolarisFileSystemUnit();
		case OsPackage.SUSE_LINUX_LOCAL_GROUP:
			return createSUSELinuxLocalGroup();
		case OsPackage.SUSE_LINUX_LOCAL_SERVICE:
			return createSUSELinuxLocalService();
		case OsPackage.SUSE_LINUX_LOCAL_USER:
			return createSUSELinuxLocalUser();
		case OsPackage.SUSE_LINUX_OPERATING_SYSTEM:
			return createSUSELinuxOperatingSystem();
		case OsPackage.UNIX_DIRECTORY:
			return createUnixDirectory();
		case OsPackage.UNIX_FILE_SYSTEM:
			return createUnixFileSystem();
		case OsPackage.UNIX_FILE_SYSTEM_UNIT:
			return createUnixFileSystemUnit();
		case OsPackage.USER:
			return createUser();
		case OsPackage.USER_GROUP:
			return createUserGroup();
		case OsPackage.USER_GROUP_UNIT:
			return createUserGroupUnit();
		case OsPackage.USER_UNIT:
			return createUserUnit();
		case OsPackage.WINDOWS_DIRECTORY:
			return createWindowsDirectory();
		case OsPackage.WINDOWS_FILE_SYSTEM:
			return createWindowsFileSystem();
		case OsPackage.WINDOWS_FILE_SYSTEM_UNIT:
			return createWindowsFileSystemUnit();
		case OsPackage.WINDOWS_LOCAL_GROUP:
			return createWindowsLocalGroup();
		case OsPackage.WINDOWS_LOCAL_GROUP_UNIT:
			return createWindowsLocalGroupUnit();
		case OsPackage.WINDOWS_LOCAL_SERVICE:
			return createWindowsLocalService();
		case OsPackage.WINDOWS_LOCAL_SERVICE_UNIT:
			return createWindowsLocalServiceUnit();
		case OsPackage.WINDOWS_LOCAL_USER:
			return createWindowsLocalUser();
		case OsPackage.WINDOWS_LOCAL_USER_UNIT:
			return createWindowsLocalUserUnit();
		case OsPackage.WINDOWS_OPERATING_SYSTEM:
			return createWindowsOperatingSystem();
		case OsPackage.WINDOWS_OPERATING_SYSTEM_UNIT:
			return createWindowsOperatingSystemUnit();
		default:
			throw new IllegalArgumentException(
					"The class '" + eClass.getName() + "' is not a valid classifier"); //$NON-NLS-1$ //$NON-NLS-2$
		}
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public Object createFromString(EDataType eDataType, String initialValue) {
		switch (eDataType.getClassifierID())
		{
		case OsPackage.AIX_AUTH_METHOD_TYPE:
			return createAIXAuthMethodTypeFromString(eDataType, initialValue);
		case OsPackage.AIX_DESKTOP_TYPE:
			return createAIXDesktopTypeFromString(eDataType, initialValue);
		case OsPackage.AIX_USER_REGISTERING_METHOD_TYPE:
			return createAIXUserRegisteringMethodTypeFromString(eDataType, initialValue);
		case OsPackage.ARCHITECTURE_BUS_TYPE:
			return createArchitectureBusTypeFromString(eDataType, initialValue);
		case OsPackage.DEFAULT_WINDOWS_USER_GROUPS:
			return createDefaultWindowsUserGroupsFromString(eDataType, initialValue);
		case OsPackage.ENCRYPTION_LEVEL_TYPE:
			return createEncryptionLevelTypeFromString(eDataType, initialValue);
		case OsPackage.KERNEL_WIDTH_TYPE:
			return createKernelWidthTypeFromString(eDataType, initialValue);
		case OsPackage.LINUX_SERVICE_STARTUP_TYPE_TYPE:
			return createLinuxServiceStartupTypeTypeFromString(eDataType, initialValue);
		case OsPackage.LINUX_SERVICE_STATUS_TYPE:
			return createLinuxServiceStatusTypeFromString(eDataType, initialValue);
		case OsPackage.OPERATING_SYSTEM_TYPE:
			return createOperatingSystemTypeFromString(eDataType, initialValue);
		case OsPackage.REDHAT_DESKTOP_TYPE:
			return createRedhatDesktopTypeFromString(eDataType, initialValue);
		case OsPackage.REDHAT_LINUX_BOOT_LOADER_TYPE:
			return createRedhatLinuxBootLoaderTypeFromString(eDataType, initialValue);
		case OsPackage.REDHAT_LINUX_PRODUCT_TYPE_TYPE:
			return createRedhatLinuxProductTypeTypeFromString(eDataType, initialValue);
		case OsPackage.REDHAT_LINUX_SERVICE_STARTUP_TYPE_TYPE:
			return createRedhatLinuxServiceStartupTypeTypeFromString(eDataType, initialValue);
		case OsPackage.REDHAT_LINUX_SERVICE_STATUS_TYPE:
			return createRedhatLinuxServiceStatusTypeFromString(eDataType, initialValue);
		case OsPackage.SE_LINUX_STATE_TYPE:
			return createSELinuxStateTypeFromString(eDataType, initialValue);
		case OsPackage.SUSE_DESKTOP_TYPE:
			return createSUSEDesktopTypeFromString(eDataType, initialValue);
		case OsPackage.SUSE_LINUX_BOOT_LOADER_TYPE:
			return createSUSELinuxBootLoaderTypeFromString(eDataType, initialValue);
		case OsPackage.SUSE_LINUX_SERVICE_STARTUP_TYPE_TYPE:
			return createSUSELinuxServiceStartupTypeTypeFromString(eDataType, initialValue);
		case OsPackage.SUSE_LINUX_SERVICE_STATUS_TYPE:
			return createSUSELinuxServiceStatusTypeFromString(eDataType, initialValue);
		case OsPackage.TRANSPORT_LAYER_PROTOCOL_TYPE:
			return createTransportLayerProtocolTypeFromString(eDataType, initialValue);
		case OsPackage.WINDOWS_DIRECTORY_TYPE:
			return createWindowsDirectoryTypeFromString(eDataType, initialValue);
		case OsPackage.WINDOWS_PRODUCT_TYPE_TYPE:
			return createWindowsProductTypeTypeFromString(eDataType, initialValue);
		case OsPackage.WINDOWS_SERVICE_ERROR_CONTROL_TYPE:
			return createWindowsServiceErrorControlTypeFromString(eDataType, initialValue);
		case OsPackage.WINDOWS_SERVICE_STARTUP_TYPE:
			return createWindowsServiceStartupTypeFromString(eDataType, initialValue);
		case OsPackage.WINDOWS_SERVICE_STATUS_TYPE:
			return createWindowsServiceStatusTypeFromString(eDataType, initialValue);
		case OsPackage.AIX_AUTH_METHOD_TYPE_OBJECT:
			return createAIXAuthMethodTypeObjectFromString(eDataType, initialValue);
		case OsPackage.AIX_DESKTOP_TYPE_OBJECT:
			return createAIXDesktopTypeObjectFromString(eDataType, initialValue);
		case OsPackage.AIX_USER_REGISTERING_METHOD_TYPE_OBJECT:
			return createAIXUserRegisteringMethodTypeObjectFromString(eDataType, initialValue);
		case OsPackage.ARCHITECTURE_BUS_TYPE_OBJECT:
			return createArchitectureBusTypeObjectFromString(eDataType, initialValue);
		case OsPackage.DEFAULT_WINDOWS_USER_GROUPS_OBJECT:
			return createDefaultWindowsUserGroupsObjectFromString(eDataType, initialValue);
		case OsPackage.ENCRYPTION_LEVEL_TYPE_OBJECT:
			return createEncryptionLevelTypeObjectFromString(eDataType, initialValue);
		case OsPackage.KERNEL_WIDTH_TYPE_OBJECT:
			return createKernelWidthTypeObjectFromString(eDataType, initialValue);
		case OsPackage.LINUX_SERVICE_STARTUP_TYPE_TYPE_OBJECT:
			return createLinuxServiceStartupTypeTypeObjectFromString(eDataType, initialValue);
		case OsPackage.LINUX_SERVICE_STATUS_TYPE_OBJECT:
			return createLinuxServiceStatusTypeObjectFromString(eDataType, initialValue);
		case OsPackage.OPERATING_SYSTEM_TYPE_OBJECT:
			return createOperatingSystemTypeObjectFromString(eDataType, initialValue);
		case OsPackage.REDHAT_DESKTOP_TYPE_OBJECT:
			return createRedhatDesktopTypeObjectFromString(eDataType, initialValue);
		case OsPackage.REDHAT_LINUX_BOOT_LOADER_TYPE_OBJECT:
			return createRedhatLinuxBootLoaderTypeObjectFromString(eDataType, initialValue);
		case OsPackage.REDHAT_LINUX_PRODUCT_TYPE_TYPE_OBJECT:
			return createRedhatLinuxProductTypeTypeObjectFromString(eDataType, initialValue);
		case OsPackage.REDHAT_LINUX_SERVICE_STARTUP_TYPE_TYPE_OBJECT:
			return createRedhatLinuxServiceStartupTypeTypeObjectFromString(eDataType, initialValue);
		case OsPackage.REDHAT_LINUX_SERVICE_STATUS_TYPE_OBJECT:
			return createRedhatLinuxServiceStatusTypeObjectFromString(eDataType, initialValue);
		case OsPackage.SE_LINUX_STATE_TYPE_OBJECT:
			return createSELinuxStateTypeObjectFromString(eDataType, initialValue);
		case OsPackage.SUSE_DESKTOP_TYPE_OBJECT:
			return createSUSEDesktopTypeObjectFromString(eDataType, initialValue);
		case OsPackage.SUSE_LINUX_BOOT_LOADER_TYPE_OBJECT:
			return createSUSELinuxBootLoaderTypeObjectFromString(eDataType, initialValue);
		case OsPackage.SUSE_LINUX_SERVICE_STARTUP_TYPE_TYPE_OBJECT:
			return createSUSELinuxServiceStartupTypeTypeObjectFromString(eDataType, initialValue);
		case OsPackage.SUSE_LINUX_SERVICE_STATUS_TYPE_OBJECT:
			return createSUSELinuxServiceStatusTypeObjectFromString(eDataType, initialValue);
		case OsPackage.TCP_PORT_TYPE:
			return createTCPPortTypeFromString(eDataType, initialValue);
		case OsPackage.TRANSPORT_LAYER_PROTOCOL_TYPE_OBJECT:
			return createTransportLayerProtocolTypeObjectFromString(eDataType, initialValue);
		case OsPackage.UDP_PORT_TYPE:
			return createUDPPortTypeFromString(eDataType, initialValue);
		case OsPackage.WINDOWS_DIRECTORY_TYPE_OBJECT:
			return createWindowsDirectoryTypeObjectFromString(eDataType, initialValue);
		case OsPackage.WINDOWS_PRODUCT_TYPE_TYPE_OBJECT:
			return createWindowsProductTypeTypeObjectFromString(eDataType, initialValue);
		case OsPackage.WINDOWS_SERVICE_ERROR_CONTROL_TYPE_OBJECT:
			return createWindowsServiceErrorControlTypeObjectFromString(eDataType, initialValue);
		case OsPackage.WINDOWS_SERVICE_STARTUP_TYPE_OBJECT:
			return createWindowsServiceStartupTypeObjectFromString(eDataType, initialValue);
		case OsPackage.WINDOWS_SERVICE_STATUS_TYPE_OBJECT:
			return createWindowsServiceStatusTypeObjectFromString(eDataType, initialValue);
		default:
			throw new IllegalArgumentException(
					"The datatype '" + eDataType.getName() + "' is not a valid classifier"); //$NON-NLS-1$ //$NON-NLS-2$
		}
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public String convertToString(EDataType eDataType, Object instanceValue) {
		switch (eDataType.getClassifierID())
		{
		case OsPackage.AIX_AUTH_METHOD_TYPE:
			return convertAIXAuthMethodTypeToString(eDataType, instanceValue);
		case OsPackage.AIX_DESKTOP_TYPE:
			return convertAIXDesktopTypeToString(eDataType, instanceValue);
		case OsPackage.AIX_USER_REGISTERING_METHOD_TYPE:
			return convertAIXUserRegisteringMethodTypeToString(eDataType, instanceValue);
		case OsPackage.ARCHITECTURE_BUS_TYPE:
			return convertArchitectureBusTypeToString(eDataType, instanceValue);
		case OsPackage.DEFAULT_WINDOWS_USER_GROUPS:
			return convertDefaultWindowsUserGroupsToString(eDataType, instanceValue);
		case OsPackage.ENCRYPTION_LEVEL_TYPE:
			return convertEncryptionLevelTypeToString(eDataType, instanceValue);
		case OsPackage.KERNEL_WIDTH_TYPE:
			return convertKernelWidthTypeToString(eDataType, instanceValue);
		case OsPackage.LINUX_SERVICE_STARTUP_TYPE_TYPE:
			return convertLinuxServiceStartupTypeTypeToString(eDataType, instanceValue);
		case OsPackage.LINUX_SERVICE_STATUS_TYPE:
			return convertLinuxServiceStatusTypeToString(eDataType, instanceValue);
		case OsPackage.OPERATING_SYSTEM_TYPE:
			return convertOperatingSystemTypeToString(eDataType, instanceValue);
		case OsPackage.REDHAT_DESKTOP_TYPE:
			return convertRedhatDesktopTypeToString(eDataType, instanceValue);
		case OsPackage.REDHAT_LINUX_BOOT_LOADER_TYPE:
			return convertRedhatLinuxBootLoaderTypeToString(eDataType, instanceValue);
		case OsPackage.REDHAT_LINUX_PRODUCT_TYPE_TYPE:
			return convertRedhatLinuxProductTypeTypeToString(eDataType, instanceValue);
		case OsPackage.REDHAT_LINUX_SERVICE_STARTUP_TYPE_TYPE:
			return convertRedhatLinuxServiceStartupTypeTypeToString(eDataType, instanceValue);
		case OsPackage.REDHAT_LINUX_SERVICE_STATUS_TYPE:
			return convertRedhatLinuxServiceStatusTypeToString(eDataType, instanceValue);
		case OsPackage.SE_LINUX_STATE_TYPE:
			return convertSELinuxStateTypeToString(eDataType, instanceValue);
		case OsPackage.SUSE_DESKTOP_TYPE:
			return convertSUSEDesktopTypeToString(eDataType, instanceValue);
		case OsPackage.SUSE_LINUX_BOOT_LOADER_TYPE:
			return convertSUSELinuxBootLoaderTypeToString(eDataType, instanceValue);
		case OsPackage.SUSE_LINUX_SERVICE_STARTUP_TYPE_TYPE:
			return convertSUSELinuxServiceStartupTypeTypeToString(eDataType, instanceValue);
		case OsPackage.SUSE_LINUX_SERVICE_STATUS_TYPE:
			return convertSUSELinuxServiceStatusTypeToString(eDataType, instanceValue);
		case OsPackage.TRANSPORT_LAYER_PROTOCOL_TYPE:
			return convertTransportLayerProtocolTypeToString(eDataType, instanceValue);
		case OsPackage.WINDOWS_DIRECTORY_TYPE:
			return convertWindowsDirectoryTypeToString(eDataType, instanceValue);
		case OsPackage.WINDOWS_PRODUCT_TYPE_TYPE:
			return convertWindowsProductTypeTypeToString(eDataType, instanceValue);
		case OsPackage.WINDOWS_SERVICE_ERROR_CONTROL_TYPE:
			return convertWindowsServiceErrorControlTypeToString(eDataType, instanceValue);
		case OsPackage.WINDOWS_SERVICE_STARTUP_TYPE:
			return convertWindowsServiceStartupTypeToString(eDataType, instanceValue);
		case OsPackage.WINDOWS_SERVICE_STATUS_TYPE:
			return convertWindowsServiceStatusTypeToString(eDataType, instanceValue);
		case OsPackage.AIX_AUTH_METHOD_TYPE_OBJECT:
			return convertAIXAuthMethodTypeObjectToString(eDataType, instanceValue);
		case OsPackage.AIX_DESKTOP_TYPE_OBJECT:
			return convertAIXDesktopTypeObjectToString(eDataType, instanceValue);
		case OsPackage.AIX_USER_REGISTERING_METHOD_TYPE_OBJECT:
			return convertAIXUserRegisteringMethodTypeObjectToString(eDataType, instanceValue);
		case OsPackage.ARCHITECTURE_BUS_TYPE_OBJECT:
			return convertArchitectureBusTypeObjectToString(eDataType, instanceValue);
		case OsPackage.DEFAULT_WINDOWS_USER_GROUPS_OBJECT:
			return convertDefaultWindowsUserGroupsObjectToString(eDataType, instanceValue);
		case OsPackage.ENCRYPTION_LEVEL_TYPE_OBJECT:
			return convertEncryptionLevelTypeObjectToString(eDataType, instanceValue);
		case OsPackage.KERNEL_WIDTH_TYPE_OBJECT:
			return convertKernelWidthTypeObjectToString(eDataType, instanceValue);
		case OsPackage.LINUX_SERVICE_STARTUP_TYPE_TYPE_OBJECT:
			return convertLinuxServiceStartupTypeTypeObjectToString(eDataType, instanceValue);
		case OsPackage.LINUX_SERVICE_STATUS_TYPE_OBJECT:
			return convertLinuxServiceStatusTypeObjectToString(eDataType, instanceValue);
		case OsPackage.OPERATING_SYSTEM_TYPE_OBJECT:
			return convertOperatingSystemTypeObjectToString(eDataType, instanceValue);
		case OsPackage.REDHAT_DESKTOP_TYPE_OBJECT:
			return convertRedhatDesktopTypeObjectToString(eDataType, instanceValue);
		case OsPackage.REDHAT_LINUX_BOOT_LOADER_TYPE_OBJECT:
			return convertRedhatLinuxBootLoaderTypeObjectToString(eDataType, instanceValue);
		case OsPackage.REDHAT_LINUX_PRODUCT_TYPE_TYPE_OBJECT:
			return convertRedhatLinuxProductTypeTypeObjectToString(eDataType, instanceValue);
		case OsPackage.REDHAT_LINUX_SERVICE_STARTUP_TYPE_TYPE_OBJECT:
			return convertRedhatLinuxServiceStartupTypeTypeObjectToString(eDataType, instanceValue);
		case OsPackage.REDHAT_LINUX_SERVICE_STATUS_TYPE_OBJECT:
			return convertRedhatLinuxServiceStatusTypeObjectToString(eDataType, instanceValue);
		case OsPackage.SE_LINUX_STATE_TYPE_OBJECT:
			return convertSELinuxStateTypeObjectToString(eDataType, instanceValue);
		case OsPackage.SUSE_DESKTOP_TYPE_OBJECT:
			return convertSUSEDesktopTypeObjectToString(eDataType, instanceValue);
		case OsPackage.SUSE_LINUX_BOOT_LOADER_TYPE_OBJECT:
			return convertSUSELinuxBootLoaderTypeObjectToString(eDataType, instanceValue);
		case OsPackage.SUSE_LINUX_SERVICE_STARTUP_TYPE_TYPE_OBJECT:
			return convertSUSELinuxServiceStartupTypeTypeObjectToString(eDataType, instanceValue);
		case OsPackage.SUSE_LINUX_SERVICE_STATUS_TYPE_OBJECT:
			return convertSUSELinuxServiceStatusTypeObjectToString(eDataType, instanceValue);
		case OsPackage.TCP_PORT_TYPE:
			return convertTCPPortTypeToString(eDataType, instanceValue);
		case OsPackage.TRANSPORT_LAYER_PROTOCOL_TYPE_OBJECT:
			return convertTransportLayerProtocolTypeObjectToString(eDataType, instanceValue);
		case OsPackage.UDP_PORT_TYPE:
			return convertUDPPortTypeToString(eDataType, instanceValue);
		case OsPackage.WINDOWS_DIRECTORY_TYPE_OBJECT:
			return convertWindowsDirectoryTypeObjectToString(eDataType, instanceValue);
		case OsPackage.WINDOWS_PRODUCT_TYPE_TYPE_OBJECT:
			return convertWindowsProductTypeTypeObjectToString(eDataType, instanceValue);
		case OsPackage.WINDOWS_SERVICE_ERROR_CONTROL_TYPE_OBJECT:
			return convertWindowsServiceErrorControlTypeObjectToString(eDataType, instanceValue);
		case OsPackage.WINDOWS_SERVICE_STARTUP_TYPE_OBJECT:
			return convertWindowsServiceStartupTypeObjectToString(eDataType, instanceValue);
		case OsPackage.WINDOWS_SERVICE_STATUS_TYPE_OBJECT:
			return convertWindowsServiceStatusTypeObjectToString(eDataType, instanceValue);
		default:
			throw new IllegalArgumentException(
					"The datatype '" + eDataType.getName() + "' is not a valid classifier"); //$NON-NLS-1$ //$NON-NLS-2$
		}
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public AIXLocalGroup createAIXLocalGroup() {
		AIXLocalGroupImpl aixLocalGroup = new AIXLocalGroupImpl();
		return aixLocalGroup;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public AIXLocalGroupUnit createAIXLocalGroupUnit() {
		AIXLocalGroupUnitImpl aixLocalGroupUnit = new AIXLocalGroupUnitImpl();
		return aixLocalGroupUnit;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public AIXLocalService createAIXLocalService() {
		AIXLocalServiceImpl aixLocalService = new AIXLocalServiceImpl();
		return aixLocalService;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public AIXLocalServiceUnit createAIXLocalServiceUnit() {
		AIXLocalServiceUnitImpl aixLocalServiceUnit = new AIXLocalServiceUnitImpl();
		return aixLocalServiceUnit;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public AIXLocalUser createAIXLocalUser() {
		AIXLocalUserImpl aixLocalUser = new AIXLocalUserImpl();
		return aixLocalUser;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public AIXLocalUserUnit createAIXLocalUserUnit() {
		AIXLocalUserUnitImpl aixLocalUserUnit = new AIXLocalUserUnitImpl();
		return aixLocalUserUnit;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public AIXOperatingSystem createAIXOperatingSystem() {
		AIXOperatingSystemImpl aixOperatingSystem = new AIXOperatingSystemImpl();
		return aixOperatingSystem;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public AIXOperatingSystemUnit createAIXOperatingSystemUnit() {
		AIXOperatingSystemUnitImpl aixOperatingSystemUnit = new AIXOperatingSystemUnitImpl();
		return aixOperatingSystemUnit;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public DataFile createDataFile() {
		DataFileImpl dataFile = new DataFileImpl();
		return dataFile;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public DataFileUnit createDataFileUnit() {
		DataFileUnitImpl dataFileUnit = new DataFileUnitImpl();
		return dataFileUnit;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public Directory createDirectory() {
		DirectoryImpl directory = new DirectoryImpl();
		return directory;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public DirectoryUnit createDirectoryUnit() {
		DirectoryUnitImpl directoryUnit = new DirectoryUnitImpl();
		return directoryUnit;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public FileSystem createFileSystem() {
		FileSystemImpl fileSystem = new FileSystemImpl();
		return fileSystem;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public FileSystemContent createFileSystemContent() {
		FileSystemContentImpl fileSystemContent = new FileSystemContentImpl();
		return fileSystemContent;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public FileSystemContentUnit createFileSystemContentUnit() {
		FileSystemContentUnitImpl fileSystemContentUnit = new FileSystemContentUnitImpl();
		return fileSystemContentUnit;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public FileSystemUnit createFileSystemUnit() {
		FileSystemUnitImpl fileSystemUnit = new FileSystemUnitImpl();
		return fileSystemUnit;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public LinuxLocalGroup createLinuxLocalGroup() {
		LinuxLocalGroupImpl linuxLocalGroup = new LinuxLocalGroupImpl();
		return linuxLocalGroup;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public LinuxLocalGroupUnit createLinuxLocalGroupUnit() {
		LinuxLocalGroupUnitImpl linuxLocalGroupUnit = new LinuxLocalGroupUnitImpl();
		return linuxLocalGroupUnit;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public LinuxLocalService createLinuxLocalService() {
		LinuxLocalServiceImpl linuxLocalService = new LinuxLocalServiceImpl();
		return linuxLocalService;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public LinuxLocalServiceUnit createLinuxLocalServiceUnit() {
		LinuxLocalServiceUnitImpl linuxLocalServiceUnit = new LinuxLocalServiceUnitImpl();
		return linuxLocalServiceUnit;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public LinuxLocalUser createLinuxLocalUser() {
		LinuxLocalUserImpl linuxLocalUser = new LinuxLocalUserImpl();
		return linuxLocalUser;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public LinuxLocalUserUnit createLinuxLocalUserUnit() {
		LinuxLocalUserUnitImpl linuxLocalUserUnit = new LinuxLocalUserUnitImpl();
		return linuxLocalUserUnit;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public LinuxOperatingSystem createLinuxOperatingSystem() {
		LinuxOperatingSystemImpl linuxOperatingSystem = new LinuxOperatingSystemImpl();
		return linuxOperatingSystem;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public LinuxOperatingSystemUnit createLinuxOperatingSystemUnit() {
		LinuxOperatingSystemUnitImpl linuxOperatingSystemUnit = new LinuxOperatingSystemUnitImpl();
		return linuxOperatingSystemUnit;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public LocalFileSystem createLocalFileSystem() {
		LocalFileSystemImpl localFileSystem = new LocalFileSystemImpl();
		return localFileSystem;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public LocalFileSystemUnit createLocalFileSystemUnit() {
		LocalFileSystemUnitImpl localFileSystemUnit = new LocalFileSystemUnitImpl();
		return localFileSystemUnit;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NFSFileSystem createNFSFileSystem() {
		NFSFileSystemImpl nfsFileSystem = new NFSFileSystemImpl();
		return nfsFileSystem;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NFSFileSystemUnit createNFSFileSystemUnit() {
		NFSFileSystemUnitImpl nfsFileSystemUnit = new NFSFileSystemUnitImpl();
		return nfsFileSystemUnit;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public OpenVmsFileSystem createOpenVmsFileSystem() {
		OpenVmsFileSystemImpl openVmsFileSystem = new OpenVmsFileSystemImpl();
		return openVmsFileSystem;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public OpenVmsFileSystemUnit createOpenVmsFileSystemUnit() {
		OpenVmsFileSystemUnitImpl openVmsFileSystemUnit = new OpenVmsFileSystemUnitImpl();
		return openVmsFileSystemUnit;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public OperatingSystem createOperatingSystem() {
		OperatingSystemImpl operatingSystem = new OperatingSystemImpl();
		return operatingSystem;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public OperatingSystemRoot createOperatingSystemRoot() {
		OperatingSystemRootImpl operatingSystemRoot = new OperatingSystemRootImpl();
		return operatingSystemRoot;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public OperatingSystemUnit createOperatingSystemUnit() {
		OperatingSystemUnitImpl operatingSystemUnit = new OperatingSystemUnitImpl();
		return operatingSystemUnit;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public Port createPort() {
		PortImpl port = new PortImpl();
		return port;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public PortConfigUnit createPortConfigUnit() {
		PortConfigUnitImpl portConfigUnit = new PortConfigUnitImpl();
		return portConfigUnit;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public PortConsumer createPortConsumer() {
		PortConsumerImpl portConsumer = new PortConsumerImpl();
		return portConsumer;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public RedhatLinuxLocalGroup createRedhatLinuxLocalGroup() {
		RedhatLinuxLocalGroupImpl redhatLinuxLocalGroup = new RedhatLinuxLocalGroupImpl();
		return redhatLinuxLocalGroup;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public RedhatLinuxLocalService createRedhatLinuxLocalService() {
		RedhatLinuxLocalServiceImpl redhatLinuxLocalService = new RedhatLinuxLocalServiceImpl();
		return redhatLinuxLocalService;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public RedhatLinuxLocalUser createRedhatLinuxLocalUser() {
		RedhatLinuxLocalUserImpl redhatLinuxLocalUser = new RedhatLinuxLocalUserImpl();
		return redhatLinuxLocalUser;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public RedhatLinuxOperatingSystem createRedhatLinuxOperatingSystem() {
		RedhatLinuxOperatingSystemImpl redhatLinuxOperatingSystem = new RedhatLinuxOperatingSystemImpl();
		return redhatLinuxOperatingSystem;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public RemoteFileSystem createRemoteFileSystem() {
		RemoteFileSystemImpl remoteFileSystem = new RemoteFileSystemImpl();
		return remoteFileSystem;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public RemoteFileSystemUnit createRemoteFileSystemUnit() {
		RemoteFileSystemUnitImpl remoteFileSystemUnit = new RemoteFileSystemUnitImpl();
		return remoteFileSystemUnit;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SMBFileSystem createSMBFileSystem() {
		SMBFileSystemImpl smbFileSystem = new SMBFileSystemImpl();
		return smbFileSystem;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SMBFileSystemUnit createSMBFileSystemUnit() {
		SMBFileSystemUnitImpl smbFileSystemUnit = new SMBFileSystemUnitImpl();
		return smbFileSystemUnit;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SolarisFileSystem createSolarisFileSystem() {
		SolarisFileSystemImpl solarisFileSystem = new SolarisFileSystemImpl();
		return solarisFileSystem;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SolarisFileSystemUnit createSolarisFileSystemUnit() {
		SolarisFileSystemUnitImpl solarisFileSystemUnit = new SolarisFileSystemUnitImpl();
		return solarisFileSystemUnit;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public SUSELinuxLocalGroup createSUSELinuxLocalGroup() {
		SUSELinuxLocalGroupImpl suseLinuxLocalGroup = new SUSELinuxLocalGroupImpl();
		return suseLinuxLocalGroup;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public SUSELinuxLocalService createSUSELinuxLocalService() {
		SUSELinuxLocalServiceImpl suseLinuxLocalService = new SUSELinuxLocalServiceImpl();
		return suseLinuxLocalService;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public SUSELinuxLocalUser createSUSELinuxLocalUser() {
		SUSELinuxLocalUserImpl suseLinuxLocalUser = new SUSELinuxLocalUserImpl();
		return suseLinuxLocalUser;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public SUSELinuxOperatingSystem createSUSELinuxOperatingSystem() {
		SUSELinuxOperatingSystemImpl suseLinuxOperatingSystem = new SUSELinuxOperatingSystemImpl();
		return suseLinuxOperatingSystem;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public UnixDirectory createUnixDirectory() {
		UnixDirectoryImpl unixDirectory = new UnixDirectoryImpl();
		return unixDirectory;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public UnixFileSystem createUnixFileSystem() {
		UnixFileSystemImpl unixFileSystem = new UnixFileSystemImpl();
		return unixFileSystem;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public UnixFileSystemUnit createUnixFileSystemUnit() {
		UnixFileSystemUnitImpl unixFileSystemUnit = new UnixFileSystemUnitImpl();
		return unixFileSystemUnit;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public User createUser() {
		UserImpl user = new UserImpl();
		return user;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public UserGroup createUserGroup() {
		UserGroupImpl userGroup = new UserGroupImpl();
		return userGroup;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public UserGroupUnit createUserGroupUnit() {
		UserGroupUnitImpl userGroupUnit = new UserGroupUnitImpl();
		return userGroupUnit;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public UserUnit createUserUnit() {
		UserUnitImpl userUnit = new UserUnitImpl();
		return userUnit;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public WindowsDirectory createWindowsDirectory() {
		WindowsDirectoryImpl windowsDirectory = new WindowsDirectoryImpl();
		return windowsDirectory;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public WindowsFileSystem createWindowsFileSystem() {
		WindowsFileSystemImpl windowsFileSystem = new WindowsFileSystemImpl();
		return windowsFileSystem;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public WindowsFileSystemUnit createWindowsFileSystemUnit() {
		WindowsFileSystemUnitImpl windowsFileSystemUnit = new WindowsFileSystemUnitImpl();
		return windowsFileSystemUnit;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public WindowsLocalGroup createWindowsLocalGroup() {
		WindowsLocalGroupImpl windowsLocalGroup = new WindowsLocalGroupImpl();
		return windowsLocalGroup;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public WindowsLocalGroupUnit createWindowsLocalGroupUnit() {
		WindowsLocalGroupUnitImpl windowsLocalGroupUnit = new WindowsLocalGroupUnitImpl();
		return windowsLocalGroupUnit;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public WindowsLocalService createWindowsLocalService() {
		WindowsLocalServiceImpl windowsLocalService = new WindowsLocalServiceImpl();
		return windowsLocalService;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public WindowsLocalServiceUnit createWindowsLocalServiceUnit() {
		WindowsLocalServiceUnitImpl windowsLocalServiceUnit = new WindowsLocalServiceUnitImpl();
		return windowsLocalServiceUnit;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public WindowsLocalUser createWindowsLocalUser() {
		WindowsLocalUserImpl windowsLocalUser = new WindowsLocalUserImpl();
		return windowsLocalUser;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public WindowsLocalUserUnit createWindowsLocalUserUnit() {
		WindowsLocalUserUnitImpl windowsLocalUserUnit = new WindowsLocalUserUnitImpl();
		return windowsLocalUserUnit;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public WindowsOperatingSystem createWindowsOperatingSystem() {
		WindowsOperatingSystemImpl windowsOperatingSystem = new WindowsOperatingSystemImpl();
		return windowsOperatingSystem;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public WindowsOperatingSystemUnit createWindowsOperatingSystemUnit() {
		WindowsOperatingSystemUnitImpl windowsOperatingSystemUnit = new WindowsOperatingSystemUnitImpl();
		return windowsOperatingSystemUnit;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public AIXAuthMethodType createAIXAuthMethodTypeFromString(EDataType eDataType,
			String initialValue) {
		AIXAuthMethodType result = AIXAuthMethodType.get(initialValue);
		if (result == null)
			throw new IllegalArgumentException(
					"The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'"); //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
		return result;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public String convertAIXAuthMethodTypeToString(EDataType eDataType, Object instanceValue) {
		return instanceValue == null ? null : instanceValue.toString();
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public AIXDesktopType createAIXDesktopTypeFromString(EDataType eDataType, String initialValue) {
		AIXDesktopType result = AIXDesktopType.get(initialValue);
		if (result == null)
			throw new IllegalArgumentException(
					"The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'"); //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
		return result;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public String convertAIXDesktopTypeToString(EDataType eDataType, Object instanceValue) {
		return instanceValue == null ? null : instanceValue.toString();
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public AIXUserRegisteringMethodType createAIXUserRegisteringMethodTypeFromString(
			EDataType eDataType, String initialValue) {
		AIXUserRegisteringMethodType result = AIXUserRegisteringMethodType.get(initialValue);
		if (result == null)
			throw new IllegalArgumentException(
					"The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'"); //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
		return result;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public String convertAIXUserRegisteringMethodTypeToString(EDataType eDataType,
			Object instanceValue) {
		return instanceValue == null ? null : instanceValue.toString();
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public ArchitectureBusType createArchitectureBusTypeFromString(EDataType eDataType,
			String initialValue) {
		ArchitectureBusType result = ArchitectureBusType.get(initialValue);
		if (result == null)
			throw new IllegalArgumentException(
					"The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'"); //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
		return result;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public String convertArchitectureBusTypeToString(EDataType eDataType, Object instanceValue) {
		return instanceValue == null ? null : instanceValue.toString();
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public DefaultWindowsUserGroups createDefaultWindowsUserGroupsFromString(EDataType eDataType,
			String initialValue) {
		DefaultWindowsUserGroups result = DefaultWindowsUserGroups.get(initialValue);
		if (result == null)
			throw new IllegalArgumentException(
					"The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'"); //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
		return result;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public String convertDefaultWindowsUserGroupsToString(EDataType eDataType, Object instanceValue) {
		return instanceValue == null ? null : instanceValue.toString();
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EncryptionLevelType createEncryptionLevelTypeFromString(EDataType eDataType,
			String initialValue) {
		EncryptionLevelType result = EncryptionLevelType.get(initialValue);
		if (result == null)
			throw new IllegalArgumentException(
					"The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'"); //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
		return result;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public String convertEncryptionLevelTypeToString(EDataType eDataType, Object instanceValue) {
		return instanceValue == null ? null : instanceValue.toString();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public KernelWidthType createKernelWidthTypeFromString(EDataType eDataType, String initialValue) {
		KernelWidthType result = KernelWidthType.get(initialValue);
		if (result == null)
			throw new IllegalArgumentException(
					"The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'"); //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertKernelWidthTypeToString(EDataType eDataType, Object instanceValue) {
		return instanceValue == null ? null : instanceValue.toString();
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public LinuxServiceStartupTypeType createLinuxServiceStartupTypeTypeFromString(
			EDataType eDataType, String initialValue) {
		LinuxServiceStartupTypeType result = LinuxServiceStartupTypeType.get(initialValue);
		if (result == null)
			throw new IllegalArgumentException(
					"The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'"); //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
		return result;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public String convertLinuxServiceStartupTypeTypeToString(EDataType eDataType,
			Object instanceValue) {
		return instanceValue == null ? null : instanceValue.toString();
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public LinuxServiceStatusType createLinuxServiceStatusTypeFromString(EDataType eDataType,
			String initialValue) {
		LinuxServiceStatusType result = LinuxServiceStatusType.get(initialValue);
		if (result == null)
			throw new IllegalArgumentException(
					"The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'"); //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
		return result;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public String convertLinuxServiceStatusTypeToString(EDataType eDataType, Object instanceValue) {
		return instanceValue == null ? null : instanceValue.toString();
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public OperatingSystemType createOperatingSystemTypeFromString(EDataType eDataType,
			String initialValue) {
		OperatingSystemType result = OperatingSystemType.get(initialValue);
		if (result == null)
			throw new IllegalArgumentException(
					"The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'"); //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
		return result;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public String convertOperatingSystemTypeToString(EDataType eDataType, Object instanceValue) {
		return instanceValue == null ? null : instanceValue.toString();
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public RedhatDesktopType createRedhatDesktopTypeFromString(EDataType eDataType,
			String initialValue) {
		RedhatDesktopType result = RedhatDesktopType.get(initialValue);
		if (result == null)
			throw new IllegalArgumentException(
					"The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'"); //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
		return result;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public String convertRedhatDesktopTypeToString(EDataType eDataType, Object instanceValue) {
		return instanceValue == null ? null : instanceValue.toString();
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public RedhatLinuxBootLoaderType createRedhatLinuxBootLoaderTypeFromString(EDataType eDataType,
			String initialValue) {
		RedhatLinuxBootLoaderType result = RedhatLinuxBootLoaderType.get(initialValue);
		if (result == null)
			throw new IllegalArgumentException(
					"The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'"); //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
		return result;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public String convertRedhatLinuxBootLoaderTypeToString(EDataType eDataType, Object instanceValue) {
		return instanceValue == null ? null : instanceValue.toString();
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public RedhatLinuxProductTypeType createRedhatLinuxProductTypeTypeFromString(
			EDataType eDataType, String initialValue) {
		RedhatLinuxProductTypeType result = RedhatLinuxProductTypeType.get(initialValue);
		if (result == null)
			throw new IllegalArgumentException(
					"The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'"); //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
		return result;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public String convertRedhatLinuxProductTypeTypeToString(EDataType eDataType, Object instanceValue) {
		return instanceValue == null ? null : instanceValue.toString();
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public RedhatLinuxServiceStartupTypeType createRedhatLinuxServiceStartupTypeTypeFromString(
			EDataType eDataType, String initialValue) {
		RedhatLinuxServiceStartupTypeType result = RedhatLinuxServiceStartupTypeType
				.get(initialValue);
		if (result == null)
			throw new IllegalArgumentException(
					"The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'"); //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
		return result;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public String convertRedhatLinuxServiceStartupTypeTypeToString(EDataType eDataType,
			Object instanceValue) {
		return instanceValue == null ? null : instanceValue.toString();
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public RedhatLinuxServiceStatusType createRedhatLinuxServiceStatusTypeFromString(
			EDataType eDataType, String initialValue) {
		RedhatLinuxServiceStatusType result = RedhatLinuxServiceStatusType.get(initialValue);
		if (result == null)
			throw new IllegalArgumentException(
					"The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'"); //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
		return result;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public String convertRedhatLinuxServiceStatusTypeToString(EDataType eDataType,
			Object instanceValue) {
		return instanceValue == null ? null : instanceValue.toString();
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public SELinuxStateType createSELinuxStateTypeFromString(EDataType eDataType, String initialValue) {
		SELinuxStateType result = SELinuxStateType.get(initialValue);
		if (result == null)
			throw new IllegalArgumentException(
					"The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'"); //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
		return result;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public String convertSELinuxStateTypeToString(EDataType eDataType, Object instanceValue) {
		return instanceValue == null ? null : instanceValue.toString();
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public SUSEDesktopType createSUSEDesktopTypeFromString(EDataType eDataType, String initialValue) {
		SUSEDesktopType result = SUSEDesktopType.get(initialValue);
		if (result == null)
			throw new IllegalArgumentException(
					"The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'"); //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
		return result;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public String convertSUSEDesktopTypeToString(EDataType eDataType, Object instanceValue) {
		return instanceValue == null ? null : instanceValue.toString();
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public SUSELinuxBootLoaderType createSUSELinuxBootLoaderTypeFromString(EDataType eDataType,
			String initialValue) {
		SUSELinuxBootLoaderType result = SUSELinuxBootLoaderType.get(initialValue);
		if (result == null)
			throw new IllegalArgumentException(
					"The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'"); //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
		return result;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public String convertSUSELinuxBootLoaderTypeToString(EDataType eDataType, Object instanceValue) {
		return instanceValue == null ? null : instanceValue.toString();
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public SUSELinuxServiceStartupTypeType createSUSELinuxServiceStartupTypeTypeFromString(
			EDataType eDataType, String initialValue) {
		SUSELinuxServiceStartupTypeType result = SUSELinuxServiceStartupTypeType.get(initialValue);
		if (result == null)
			throw new IllegalArgumentException(
					"The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'"); //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
		return result;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public String convertSUSELinuxServiceStartupTypeTypeToString(EDataType eDataType,
			Object instanceValue) {
		return instanceValue == null ? null : instanceValue.toString();
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public SUSELinuxServiceStatusType createSUSELinuxServiceStatusTypeFromString(
			EDataType eDataType, String initialValue) {
		SUSELinuxServiceStatusType result = SUSELinuxServiceStatusType.get(initialValue);
		if (result == null)
			throw new IllegalArgumentException(
					"The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'"); //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
		return result;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public String convertSUSELinuxServiceStatusTypeToString(EDataType eDataType, Object instanceValue) {
		return instanceValue == null ? null : instanceValue.toString();
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public TransportLayerProtocolType createTransportLayerProtocolTypeFromString(
			EDataType eDataType, String initialValue) {
		TransportLayerProtocolType result = TransportLayerProtocolType.get(initialValue);
		if (result == null)
			throw new IllegalArgumentException(
					"The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'"); //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
		return result;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public String convertTransportLayerProtocolTypeToString(EDataType eDataType, Object instanceValue) {
		return instanceValue == null ? null : instanceValue.toString();
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public WindowsDirectoryType createWindowsDirectoryTypeFromString(EDataType eDataType,
			String initialValue) {
		WindowsDirectoryType result = WindowsDirectoryType.get(initialValue);
		if (result == null)
			throw new IllegalArgumentException(
					"The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'"); //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
		return result;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public String convertWindowsDirectoryTypeToString(EDataType eDataType, Object instanceValue) {
		return instanceValue == null ? null : instanceValue.toString();
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public WindowsProductTypeType createWindowsProductTypeTypeFromString(EDataType eDataType,
			String initialValue) {
		WindowsProductTypeType result = WindowsProductTypeType.get(initialValue);
		if (result == null)
			throw new IllegalArgumentException(
					"The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'"); //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
		return result;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public String convertWindowsProductTypeTypeToString(EDataType eDataType, Object instanceValue) {
		return instanceValue == null ? null : instanceValue.toString();
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public WindowsServiceErrorControlType createWindowsServiceErrorControlTypeFromString(
			EDataType eDataType, String initialValue) {
		WindowsServiceErrorControlType result = WindowsServiceErrorControlType.get(initialValue);
		if (result == null)
			throw new IllegalArgumentException(
					"The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'"); //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
		return result;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public String convertWindowsServiceErrorControlTypeToString(EDataType eDataType,
			Object instanceValue) {
		return instanceValue == null ? null : instanceValue.toString();
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public WindowsServiceStartupType createWindowsServiceStartupTypeFromString(EDataType eDataType,
			String initialValue) {
		WindowsServiceStartupType result = WindowsServiceStartupType.get(initialValue);
		if (result == null)
			throw new IllegalArgumentException(
					"The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'"); //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
		return result;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public String convertWindowsServiceStartupTypeToString(EDataType eDataType, Object instanceValue) {
		return instanceValue == null ? null : instanceValue.toString();
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public WindowsServiceStatusType createWindowsServiceStatusTypeFromString(EDataType eDataType,
			String initialValue) {
		WindowsServiceStatusType result = WindowsServiceStatusType.get(initialValue);
		if (result == null)
			throw new IllegalArgumentException(
					"The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'"); //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
		return result;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public String convertWindowsServiceStatusTypeToString(EDataType eDataType, Object instanceValue) {
		return instanceValue == null ? null : instanceValue.toString();
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public AIXAuthMethodType createAIXAuthMethodTypeObjectFromString(EDataType eDataType,
			String initialValue) {
		return createAIXAuthMethodTypeFromString(OsPackage.Literals.AIX_AUTH_METHOD_TYPE,
				initialValue);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public String convertAIXAuthMethodTypeObjectToString(EDataType eDataType, Object instanceValue) {
		return convertAIXAuthMethodTypeToString(OsPackage.Literals.AIX_AUTH_METHOD_TYPE,
				instanceValue);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public AIXDesktopType createAIXDesktopTypeObjectFromString(EDataType eDataType,
			String initialValue) {
		return createAIXDesktopTypeFromString(OsPackage.Literals.AIX_DESKTOP_TYPE, initialValue);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public String convertAIXDesktopTypeObjectToString(EDataType eDataType, Object instanceValue) {
		return convertAIXDesktopTypeToString(OsPackage.Literals.AIX_DESKTOP_TYPE, instanceValue);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public AIXUserRegisteringMethodType createAIXUserRegisteringMethodTypeObjectFromString(
			EDataType eDataType, String initialValue) {
		return createAIXUserRegisteringMethodTypeFromString(
				OsPackage.Literals.AIX_USER_REGISTERING_METHOD_TYPE, initialValue);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public String convertAIXUserRegisteringMethodTypeObjectToString(EDataType eDataType,
			Object instanceValue) {
		return convertAIXUserRegisteringMethodTypeToString(
				OsPackage.Literals.AIX_USER_REGISTERING_METHOD_TYPE, instanceValue);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public ArchitectureBusType createArchitectureBusTypeObjectFromString(EDataType eDataType,
			String initialValue) {
		return createArchitectureBusTypeFromString(OsPackage.Literals.ARCHITECTURE_BUS_TYPE,
				initialValue);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public String convertArchitectureBusTypeObjectToString(EDataType eDataType, Object instanceValue) {
		return convertArchitectureBusTypeToString(OsPackage.Literals.ARCHITECTURE_BUS_TYPE,
				instanceValue);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public DefaultWindowsUserGroups createDefaultWindowsUserGroupsObjectFromString(
			EDataType eDataType, String initialValue) {
		return createDefaultWindowsUserGroupsFromString(
				OsPackage.Literals.DEFAULT_WINDOWS_USER_GROUPS, initialValue);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public String convertDefaultWindowsUserGroupsObjectToString(EDataType eDataType,
			Object instanceValue) {
		return convertDefaultWindowsUserGroupsToString(
				OsPackage.Literals.DEFAULT_WINDOWS_USER_GROUPS, instanceValue);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EncryptionLevelType createEncryptionLevelTypeObjectFromString(EDataType eDataType,
			String initialValue) {
		return createEncryptionLevelTypeFromString(OsPackage.Literals.ENCRYPTION_LEVEL_TYPE,
				initialValue);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public String convertEncryptionLevelTypeObjectToString(EDataType eDataType, Object instanceValue) {
		return convertEncryptionLevelTypeToString(OsPackage.Literals.ENCRYPTION_LEVEL_TYPE,
				instanceValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public KernelWidthType createKernelWidthTypeObjectFromString(EDataType eDataType,
			String initialValue) {
		return createKernelWidthTypeFromString(OsPackage.Literals.KERNEL_WIDTH_TYPE, initialValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertKernelWidthTypeObjectToString(EDataType eDataType, Object instanceValue) {
		return convertKernelWidthTypeToString(OsPackage.Literals.KERNEL_WIDTH_TYPE, instanceValue);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public LinuxServiceStartupTypeType createLinuxServiceStartupTypeTypeObjectFromString(
			EDataType eDataType, String initialValue) {
		return createLinuxServiceStartupTypeTypeFromString(
				OsPackage.Literals.LINUX_SERVICE_STARTUP_TYPE_TYPE, initialValue);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public String convertLinuxServiceStartupTypeTypeObjectToString(EDataType eDataType,
			Object instanceValue) {
		return convertLinuxServiceStartupTypeTypeToString(
				OsPackage.Literals.LINUX_SERVICE_STARTUP_TYPE_TYPE, instanceValue);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public LinuxServiceStatusType createLinuxServiceStatusTypeObjectFromString(EDataType eDataType,
			String initialValue) {
		return createLinuxServiceStatusTypeFromString(OsPackage.Literals.LINUX_SERVICE_STATUS_TYPE,
				initialValue);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public String convertLinuxServiceStatusTypeObjectToString(EDataType eDataType,
			Object instanceValue) {
		return convertLinuxServiceStatusTypeToString(OsPackage.Literals.LINUX_SERVICE_STATUS_TYPE,
				instanceValue);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public OperatingSystemType createOperatingSystemTypeObjectFromString(EDataType eDataType,
			String initialValue) {
		return createOperatingSystemTypeFromString(OsPackage.Literals.OPERATING_SYSTEM_TYPE,
				initialValue);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public String convertOperatingSystemTypeObjectToString(EDataType eDataType, Object instanceValue) {
		return convertOperatingSystemTypeToString(OsPackage.Literals.OPERATING_SYSTEM_TYPE,
				instanceValue);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public RedhatDesktopType createRedhatDesktopTypeObjectFromString(EDataType eDataType,
			String initialValue) {
		return createRedhatDesktopTypeFromString(OsPackage.Literals.REDHAT_DESKTOP_TYPE, initialValue);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public String convertRedhatDesktopTypeObjectToString(EDataType eDataType, Object instanceValue) {
		return convertRedhatDesktopTypeToString(OsPackage.Literals.REDHAT_DESKTOP_TYPE, instanceValue);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public RedhatLinuxBootLoaderType createRedhatLinuxBootLoaderTypeObjectFromString(
			EDataType eDataType, String initialValue) {
		return createRedhatLinuxBootLoaderTypeFromString(
				OsPackage.Literals.REDHAT_LINUX_BOOT_LOADER_TYPE, initialValue);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public String convertRedhatLinuxBootLoaderTypeObjectToString(EDataType eDataType,
			Object instanceValue) {
		return convertRedhatLinuxBootLoaderTypeToString(
				OsPackage.Literals.REDHAT_LINUX_BOOT_LOADER_TYPE, instanceValue);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public RedhatLinuxProductTypeType createRedhatLinuxProductTypeTypeObjectFromString(
			EDataType eDataType, String initialValue) {
		return createRedhatLinuxProductTypeTypeFromString(
				OsPackage.Literals.REDHAT_LINUX_PRODUCT_TYPE_TYPE, initialValue);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public String convertRedhatLinuxProductTypeTypeObjectToString(EDataType eDataType,
			Object instanceValue) {
		return convertRedhatLinuxProductTypeTypeToString(
				OsPackage.Literals.REDHAT_LINUX_PRODUCT_TYPE_TYPE, instanceValue);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public RedhatLinuxServiceStartupTypeType createRedhatLinuxServiceStartupTypeTypeObjectFromString(
			EDataType eDataType, String initialValue) {
		return createRedhatLinuxServiceStartupTypeTypeFromString(
				OsPackage.Literals.REDHAT_LINUX_SERVICE_STARTUP_TYPE_TYPE, initialValue);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public String convertRedhatLinuxServiceStartupTypeTypeObjectToString(EDataType eDataType,
			Object instanceValue) {
		return convertRedhatLinuxServiceStartupTypeTypeToString(
				OsPackage.Literals.REDHAT_LINUX_SERVICE_STARTUP_TYPE_TYPE, instanceValue);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public RedhatLinuxServiceStatusType createRedhatLinuxServiceStatusTypeObjectFromString(
			EDataType eDataType, String initialValue) {
		return createRedhatLinuxServiceStatusTypeFromString(
				OsPackage.Literals.REDHAT_LINUX_SERVICE_STATUS_TYPE, initialValue);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public String convertRedhatLinuxServiceStatusTypeObjectToString(EDataType eDataType,
			Object instanceValue) {
		return convertRedhatLinuxServiceStatusTypeToString(
				OsPackage.Literals.REDHAT_LINUX_SERVICE_STATUS_TYPE, instanceValue);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public SELinuxStateType createSELinuxStateTypeObjectFromString(EDataType eDataType,
			String initialValue) {
		return createSELinuxStateTypeFromString(OsPackage.Literals.SE_LINUX_STATE_TYPE, initialValue);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public String convertSELinuxStateTypeObjectToString(EDataType eDataType, Object instanceValue) {
		return convertSELinuxStateTypeToString(OsPackage.Literals.SE_LINUX_STATE_TYPE, instanceValue);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public SUSEDesktopType createSUSEDesktopTypeObjectFromString(EDataType eDataType,
			String initialValue) {
		return createSUSEDesktopTypeFromString(OsPackage.Literals.SUSE_DESKTOP_TYPE, initialValue);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public String convertSUSEDesktopTypeObjectToString(EDataType eDataType, Object instanceValue) {
		return convertSUSEDesktopTypeToString(OsPackage.Literals.SUSE_DESKTOP_TYPE, instanceValue);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public SUSELinuxBootLoaderType createSUSELinuxBootLoaderTypeObjectFromString(
			EDataType eDataType, String initialValue) {
		return createSUSELinuxBootLoaderTypeFromString(
				OsPackage.Literals.SUSE_LINUX_BOOT_LOADER_TYPE, initialValue);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public String convertSUSELinuxBootLoaderTypeObjectToString(EDataType eDataType,
			Object instanceValue) {
		return convertSUSELinuxBootLoaderTypeToString(OsPackage.Literals.SUSE_LINUX_BOOT_LOADER_TYPE,
				instanceValue);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public SUSELinuxServiceStartupTypeType createSUSELinuxServiceStartupTypeTypeObjectFromString(
			EDataType eDataType, String initialValue) {
		return createSUSELinuxServiceStartupTypeTypeFromString(
				OsPackage.Literals.SUSE_LINUX_SERVICE_STARTUP_TYPE_TYPE, initialValue);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public String convertSUSELinuxServiceStartupTypeTypeObjectToString(EDataType eDataType,
			Object instanceValue) {
		return convertSUSELinuxServiceStartupTypeTypeToString(
				OsPackage.Literals.SUSE_LINUX_SERVICE_STARTUP_TYPE_TYPE, instanceValue);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public SUSELinuxServiceStatusType createSUSELinuxServiceStatusTypeObjectFromString(
			EDataType eDataType, String initialValue) {
		return createSUSELinuxServiceStatusTypeFromString(
				OsPackage.Literals.SUSE_LINUX_SERVICE_STATUS_TYPE, initialValue);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public String convertSUSELinuxServiceStatusTypeObjectToString(EDataType eDataType,
			Object instanceValue) {
		return convertSUSELinuxServiceStatusTypeToString(
				OsPackage.Literals.SUSE_LINUX_SERVICE_STATUS_TYPE, instanceValue);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public BigInteger createTCPPortTypeFromString(EDataType eDataType, String initialValue) {
		return (BigInteger) CoreFactory.eINSTANCE.createFromString(CorePackage.Literals.PORT_TYPE,
				initialValue);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public String convertTCPPortTypeToString(EDataType eDataType, Object instanceValue) {
		return CoreFactory.eINSTANCE.convertToString(CorePackage.Literals.PORT_TYPE, instanceValue);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public TransportLayerProtocolType createTransportLayerProtocolTypeObjectFromString(
			EDataType eDataType, String initialValue) {
		return createTransportLayerProtocolTypeFromString(
				OsPackage.Literals.TRANSPORT_LAYER_PROTOCOL_TYPE, initialValue);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public String convertTransportLayerProtocolTypeObjectToString(EDataType eDataType,
			Object instanceValue) {
		return convertTransportLayerProtocolTypeToString(
				OsPackage.Literals.TRANSPORT_LAYER_PROTOCOL_TYPE, instanceValue);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public BigInteger createUDPPortTypeFromString(EDataType eDataType, String initialValue) {
		return (BigInteger) CoreFactory.eINSTANCE.createFromString(CorePackage.Literals.PORT_TYPE,
				initialValue);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public String convertUDPPortTypeToString(EDataType eDataType, Object instanceValue) {
		return CoreFactory.eINSTANCE.convertToString(CorePackage.Literals.PORT_TYPE, instanceValue);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public WindowsDirectoryType createWindowsDirectoryTypeObjectFromString(EDataType eDataType,
			String initialValue) {
		return createWindowsDirectoryTypeFromString(OsPackage.Literals.WINDOWS_DIRECTORY_TYPE,
				initialValue);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public String convertWindowsDirectoryTypeObjectToString(EDataType eDataType, Object instanceValue) {
		return convertWindowsDirectoryTypeToString(OsPackage.Literals.WINDOWS_DIRECTORY_TYPE,
				instanceValue);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public WindowsProductTypeType createWindowsProductTypeTypeObjectFromString(EDataType eDataType,
			String initialValue) {
		return createWindowsProductTypeTypeFromString(OsPackage.Literals.WINDOWS_PRODUCT_TYPE_TYPE,
				initialValue);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public String convertWindowsProductTypeTypeObjectToString(EDataType eDataType,
			Object instanceValue) {
		return convertWindowsProductTypeTypeToString(OsPackage.Literals.WINDOWS_PRODUCT_TYPE_TYPE,
				instanceValue);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public WindowsServiceErrorControlType createWindowsServiceErrorControlTypeObjectFromString(
			EDataType eDataType, String initialValue) {
		return createWindowsServiceErrorControlTypeFromString(
				OsPackage.Literals.WINDOWS_SERVICE_ERROR_CONTROL_TYPE, initialValue);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public String convertWindowsServiceErrorControlTypeObjectToString(EDataType eDataType,
			Object instanceValue) {
		return convertWindowsServiceErrorControlTypeToString(
				OsPackage.Literals.WINDOWS_SERVICE_ERROR_CONTROL_TYPE, instanceValue);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public WindowsServiceStartupType createWindowsServiceStartupTypeObjectFromString(
			EDataType eDataType, String initialValue) {
		return createWindowsServiceStartupTypeFromString(
				OsPackage.Literals.WINDOWS_SERVICE_STARTUP_TYPE, initialValue);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public String convertWindowsServiceStartupTypeObjectToString(EDataType eDataType,
			Object instanceValue) {
		return convertWindowsServiceStartupTypeToString(
				OsPackage.Literals.WINDOWS_SERVICE_STARTUP_TYPE, instanceValue);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public WindowsServiceStatusType createWindowsServiceStatusTypeObjectFromString(
			EDataType eDataType, String initialValue) {
		return createWindowsServiceStatusTypeFromString(
				OsPackage.Literals.WINDOWS_SERVICE_STATUS_TYPE, initialValue);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public String convertWindowsServiceStatusTypeObjectToString(EDataType eDataType,
			Object instanceValue) {
		return convertWindowsServiceStatusTypeToString(
				OsPackage.Literals.WINDOWS_SERVICE_STATUS_TYPE, instanceValue);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public OsPackage getOsPackage() {
		return (OsPackage) getEPackage();
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @deprecated
	 * @generated
	 */
	public static OsPackage getPackage() {
		return OsPackage.eINSTANCE;
	}

} //OsFactoryImpl
