/*******************************************************************************
 * Copyright (c) 2003, 2007 IBM Corporation Licensed Material - Property of IBM. All rights reserved.
 *  
 * US Government Users Restricted Rights - Use, duplication or disclosure v1.0 restricted by GSA ADP
 * Schedule Contract with IBM Corp.
 * 
 * Contributors: IBM Corporation - initial API and implementation
 *******************************************************************************/
package com.ibm.ccl.soa.deploy.os;

import org.eclipse.emf.ecore.EFactory;

/**
 * <!-- begin-user-doc --> The <b>Factory</b> for the model. It provides a create method for each
 * non-abstract class of the model. <!-- end-user-doc -->
 * @see com.ibm.ccl.soa.deploy.os.OsPackage
 * @generated
 */
public interface OsFactory extends EFactory {
	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	String copyright = "Copyright (c) 2005, 2006 IBM Corporation. Licensed Material - Property of IBM. All rights reserved."; //$NON-NLS-1$

	/**
	 * The singleton instance of the factory.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	OsFactory eINSTANCE = com.ibm.ccl.soa.deploy.os.impl.OsFactoryImpl.init();

	/**
	 * Returns a new object of class '<em>AIX Local Group</em>'.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @return a new object of class '<em>AIX Local Group</em>'.
	 * @generated
	 */
	AIXLocalGroup createAIXLocalGroup();

	/**
	 * Returns a new object of class '<em>AIX Local Group Unit</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>AIX Local Group Unit</em>'.
	 * @generated
	 */
	AIXLocalGroupUnit createAIXLocalGroupUnit();

	/**
	 * Returns a new object of class '<em>AIX Local Service</em>'.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @return a new object of class '<em>AIX Local Service</em>'.
	 * @generated
	 */
	AIXLocalService createAIXLocalService();

	/**
	 * Returns a new object of class '<em>AIX Local Service Unit</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>AIX Local Service Unit</em>'.
	 * @generated
	 */
	AIXLocalServiceUnit createAIXLocalServiceUnit();

	/**
	 * Returns a new object of class '<em>AIX Local User</em>'.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @return a new object of class '<em>AIX Local User</em>'.
	 * @generated
	 */
	AIXLocalUser createAIXLocalUser();

	/**
	 * Returns a new object of class '<em>AIX Local User Unit</em>'.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @return a new object of class '<em>AIX Local User Unit</em>'.
	 * @generated
	 */
	AIXLocalUserUnit createAIXLocalUserUnit();

	/**
	 * Returns a new object of class '<em>AIX Operating System</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>AIX Operating System</em>'.
	 * @generated
	 */
	AIXOperatingSystem createAIXOperatingSystem();

	/**
	 * Returns a new object of class '<em>AIX Operating System Unit</em>'.
	 * <!-- begin-user-doc
	 * --> <!-- end-user-doc -->
	 * @return a new object of class '<em>AIX Operating System Unit</em>'.
	 * @generated
	 */
	AIXOperatingSystemUnit createAIXOperatingSystemUnit();

	/**
	 * Returns a new object of class '<em>Data File</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Data File</em>'.
	 * @generated
	 */
	DataFile createDataFile();

	/**
	 * Returns a new object of class '<em>Data File Unit</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Data File Unit</em>'.
	 * @generated
	 */
	DataFileUnit createDataFileUnit();

	/**
	 * Returns a new object of class '<em>Directory</em>'.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @return a new object of class '<em>Directory</em>'.
	 * @generated
	 */
	Directory createDirectory();

	/**
	 * Returns a new object of class '<em>Directory Unit</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Directory Unit</em>'.
	 * @generated
	 */
	DirectoryUnit createDirectoryUnit();

	/**
	 * Returns a new object of class '<em>File System</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>File System</em>'.
	 * @generated
	 */
	FileSystem createFileSystem();

	/**
	 * Returns a new object of class '<em>File System Content</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>File System Content</em>'.
	 * @generated
	 */
	FileSystemContent createFileSystemContent();

	/**
	 * Returns a new object of class '<em>File System Content Unit</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>File System Content Unit</em>'.
	 * @generated
	 */
	FileSystemContentUnit createFileSystemContentUnit();

	/**
	 * Returns a new object of class '<em>File System Unit</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>File System Unit</em>'.
	 * @generated
	 */
	FileSystemUnit createFileSystemUnit();

	/**
	 * Returns a new object of class '<em>Linux Local Group</em>'.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @return a new object of class '<em>Linux Local Group</em>'.
	 * @generated
	 */
	LinuxLocalGroup createLinuxLocalGroup();

	/**
	 * Returns a new object of class '<em>Linux Local Group Unit</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Linux Local Group Unit</em>'.
	 * @generated
	 */
	LinuxLocalGroupUnit createLinuxLocalGroupUnit();

	/**
	 * Returns a new object of class '<em>Linux Local Service</em>'.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @return a new object of class '<em>Linux Local Service</em>'.
	 * @generated
	 */
	LinuxLocalService createLinuxLocalService();

	/**
	 * Returns a new object of class '<em>Linux Local Service Unit</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Linux Local Service Unit</em>'.
	 * @generated
	 */
	LinuxLocalServiceUnit createLinuxLocalServiceUnit();

	/**
	 * Returns a new object of class '<em>Linux Local User</em>'.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @return a new object of class '<em>Linux Local User</em>'.
	 * @generated
	 */
	LinuxLocalUser createLinuxLocalUser();

	/**
	 * Returns a new object of class '<em>Linux Local User Unit</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Linux Local User Unit</em>'.
	 * @generated
	 */
	LinuxLocalUserUnit createLinuxLocalUserUnit();

	/**
	 * Returns a new object of class '<em>Linux Operating System</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Linux Operating System</em>'.
	 * @generated
	 */
	LinuxOperatingSystem createLinuxOperatingSystem();

	/**
	 * Returns a new object of class '<em>Linux Operating System Unit</em>'.
	 * <!-- begin-user-doc
	 * --> <!-- end-user-doc -->
	 * @return a new object of class '<em>Linux Operating System Unit</em>'.
	 * @generated
	 */
	LinuxOperatingSystemUnit createLinuxOperatingSystemUnit();

	/**
	 * Returns a new object of class '<em>Local File System</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Local File System</em>'.
	 * @generated
	 */
	LocalFileSystem createLocalFileSystem();

	/**
	 * Returns a new object of class '<em>Local File System Unit</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Local File System Unit</em>'.
	 * @generated
	 */
	LocalFileSystemUnit createLocalFileSystemUnit();

	/**
	 * Returns a new object of class '<em>NFS File System</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>NFS File System</em>'.
	 * @generated
	 */
	NFSFileSystem createNFSFileSystem();

	/**
	 * Returns a new object of class '<em>NFS File System Unit</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>NFS File System Unit</em>'.
	 * @generated
	 */
	NFSFileSystemUnit createNFSFileSystemUnit();

	/**
	 * Returns a new object of class '<em>Open Vms File System</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Open Vms File System</em>'.
	 * @generated
	 */
	OpenVmsFileSystem createOpenVmsFileSystem();

	/**
	 * Returns a new object of class '<em>Open Vms File System Unit</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Open Vms File System Unit</em>'.
	 * @generated
	 */
	OpenVmsFileSystemUnit createOpenVmsFileSystemUnit();

	/**
	 * Returns a new object of class '<em>Operating System</em>'.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @return a new object of class '<em>Operating System</em>'.
	 * @generated
	 */
	OperatingSystem createOperatingSystem();

	/**
	 * Returns a new object of class '<em>Operating System Root</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Operating System Root</em>'.
	 * @generated
	 */
	OperatingSystemRoot createOperatingSystemRoot();

	/**
	 * Returns a new object of class '<em>Operating System Unit</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Operating System Unit</em>'.
	 * @generated
	 */
	OperatingSystemUnit createOperatingSystemUnit();

	/**
	 * Returns a new object of class '<em>Port</em>'. <!-- begin-user-doc --> <!-- end-user-doc
	 * -->
	 * 
	 * @return a new object of class '<em>Port</em>'.
	 * @generated
	 */
	Port createPort();

	/**
	 * Returns a new object of class '<em>Port Config Unit</em>'.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @return a new object of class '<em>Port Config Unit</em>'.
	 * @generated
	 */
	PortConfigUnit createPortConfigUnit();

	/**
	 * Returns a new object of class '<em>Port Consumer</em>'.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @return a new object of class '<em>Port Consumer</em>'.
	 * @generated
	 */
	PortConsumer createPortConsumer();

	/**
	 * Returns a new object of class '<em>Redhat Linux Local Group</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Redhat Linux Local Group</em>'.
	 * @generated
	 */
	RedhatLinuxLocalGroup createRedhatLinuxLocalGroup();

	/**
	 * Returns a new object of class '<em>Redhat Linux Local Service</em>'.
	 * <!-- begin-user-doc
	 * --> <!-- end-user-doc -->
	 * @return a new object of class '<em>Redhat Linux Local Service</em>'.
	 * @generated
	 */
	RedhatLinuxLocalService createRedhatLinuxLocalService();

	/**
	 * Returns a new object of class '<em>Redhat Linux Local User</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Redhat Linux Local User</em>'.
	 * @generated
	 */
	RedhatLinuxLocalUser createRedhatLinuxLocalUser();

	/**
	 * Returns a new object of class '<em>Redhat Linux Operating System</em>'. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return a new object of class '<em>Redhat Linux Operating System</em>'.
	 * @generated
	 */
	RedhatLinuxOperatingSystem createRedhatLinuxOperatingSystem();

	/**
	 * Returns a new object of class '<em>Remote File System</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Remote File System</em>'.
	 * @generated
	 */
	RemoteFileSystem createRemoteFileSystem();

	/**
	 * Returns a new object of class '<em>Remote File System Unit</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Remote File System Unit</em>'.
	 * @generated
	 */
	RemoteFileSystemUnit createRemoteFileSystemUnit();

	/**
	 * Returns a new object of class '<em>SMB File System</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>SMB File System</em>'.
	 * @generated
	 */
	SMBFileSystem createSMBFileSystem();

	/**
	 * Returns a new object of class '<em>SMB File System Unit</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>SMB File System Unit</em>'.
	 * @generated
	 */
	SMBFileSystemUnit createSMBFileSystemUnit();

	/**
	 * Returns a new object of class '<em>Solaris File System</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Solaris File System</em>'.
	 * @generated
	 */
	SolarisFileSystem createSolarisFileSystem();

	/**
	 * Returns a new object of class '<em>Solaris File System Unit</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Solaris File System Unit</em>'.
	 * @generated
	 */
	SolarisFileSystemUnit createSolarisFileSystemUnit();

	/**
	 * Returns a new object of class '<em>SUSE Linux Local Group</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>SUSE Linux Local Group</em>'.
	 * @generated
	 */
	SUSELinuxLocalGroup createSUSELinuxLocalGroup();

	/**
	 * Returns a new object of class '<em>SUSE Linux Local Service</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>SUSE Linux Local Service</em>'.
	 * @generated
	 */
	SUSELinuxLocalService createSUSELinuxLocalService();

	/**
	 * Returns a new object of class '<em>SUSE Linux Local User</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>SUSE Linux Local User</em>'.
	 * @generated
	 */
	SUSELinuxLocalUser createSUSELinuxLocalUser();

	/**
	 * Returns a new object of class '<em>SUSE Linux Operating System</em>'.
	 * <!-- begin-user-doc
	 * --> <!-- end-user-doc -->
	 * @return a new object of class '<em>SUSE Linux Operating System</em>'.
	 * @generated
	 */
	SUSELinuxOperatingSystem createSUSELinuxOperatingSystem();

	/**
	 * Returns a new object of class '<em>Unix Directory</em>'.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @return a new object of class '<em>Unix Directory</em>'.
	 * @generated
	 */
	UnixDirectory createUnixDirectory();

	/**
	 * Returns a new object of class '<em>Unix File System</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Unix File System</em>'.
	 * @generated
	 */
	UnixFileSystem createUnixFileSystem();

	/**
	 * Returns a new object of class '<em>Unix File System Unit</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Unix File System Unit</em>'.
	 * @generated
	 */
	UnixFileSystemUnit createUnixFileSystemUnit();

	/**
	 * Returns a new object of class '<em>User</em>'. <!-- begin-user-doc --> <!-- end-user-doc
	 * -->
	 * 
	 * @return a new object of class '<em>User</em>'.
	 * @generated
	 */
	User createUser();

	/**
	 * Returns a new object of class '<em>User Group</em>'.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @return a new object of class '<em>User Group</em>'.
	 * @generated
	 */
	UserGroup createUserGroup();

	/**
	 * Returns a new object of class '<em>User Group Unit</em>'.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @return a new object of class '<em>User Group Unit</em>'.
	 * @generated
	 */
	UserGroupUnit createUserGroupUnit();

	/**
	 * Returns a new object of class '<em>User Unit</em>'.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @return a new object of class '<em>User Unit</em>'.
	 * @generated
	 */
	UserUnit createUserUnit();

	/**
	 * Returns a new object of class '<em>Windows Directory</em>'.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @return a new object of class '<em>Windows Directory</em>'.
	 * @generated
	 */
	WindowsDirectory createWindowsDirectory();

	/**
	 * Returns a new object of class '<em>Windows File System</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Windows File System</em>'.
	 * @generated
	 */
	WindowsFileSystem createWindowsFileSystem();

	/**
	 * Returns a new object of class '<em>Windows File System Unit</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Windows File System Unit</em>'.
	 * @generated
	 */
	WindowsFileSystemUnit createWindowsFileSystemUnit();

	/**
	 * Returns a new object of class '<em>Windows Local Group</em>'.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @return a new object of class '<em>Windows Local Group</em>'.
	 * @generated
	 */
	WindowsLocalGroup createWindowsLocalGroup();

	/**
	 * Returns a new object of class '<em>Windows Local Group Unit</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Windows Local Group Unit</em>'.
	 * @generated
	 */
	WindowsLocalGroupUnit createWindowsLocalGroupUnit();

	/**
	 * Returns a new object of class '<em>Windows Local Service</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Windows Local Service</em>'.
	 * @generated
	 */
	WindowsLocalService createWindowsLocalService();

	/**
	 * Returns a new object of class '<em>Windows Local Service Unit</em>'.
	 * <!-- begin-user-doc
	 * --> <!-- end-user-doc -->
	 * @return a new object of class '<em>Windows Local Service Unit</em>'.
	 * @generated
	 */
	WindowsLocalServiceUnit createWindowsLocalServiceUnit();

	/**
	 * Returns a new object of class '<em>Windows Local User</em>'.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @return a new object of class '<em>Windows Local User</em>'.
	 * @generated
	 */
	WindowsLocalUser createWindowsLocalUser();

	/**
	 * Returns a new object of class '<em>Windows Local User Unit</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Windows Local User Unit</em>'.
	 * @generated
	 */
	WindowsLocalUserUnit createWindowsLocalUserUnit();

	/**
	 * Returns a new object of class '<em>Windows Operating System</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Windows Operating System</em>'.
	 * @generated
	 */
	WindowsOperatingSystem createWindowsOperatingSystem();

	/**
	 * Returns a new object of class '<em>Windows Operating System Unit</em>'. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return a new object of class '<em>Windows Operating System Unit</em>'.
	 * @generated
	 */
	WindowsOperatingSystemUnit createWindowsOperatingSystemUnit();

	/**
	 * Returns the package supported by this factory.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return the package supported by this factory.
	 * @generated
	 */
	OsPackage getOsPackage();

} //OsFactory
