/*******************************************************************************
 * Copyright (c) 2003, 2007 IBM Corporation Licensed Material - Property of IBM. All rights reserved.
 *  
 * US Government Users Restricted Rights - Use, duplication or disclosure v1.0 restricted by GSA ADP
 * Schedule Contract with IBM Corp.
 * 
 * Contributors: IBM Corporation - initial API and implementation
 *******************************************************************************/
package com.ibm.ccl.soa.deploy.os.util;

import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.common.notify.Notifier;
import org.eclipse.emf.common.notify.impl.AdapterFactoryImpl;
import org.eclipse.emf.ecore.EObject;

import com.ibm.ccl.soa.deploy.core.Capability;
import com.ibm.ccl.soa.deploy.core.DeployModelObject;
import com.ibm.ccl.soa.deploy.core.Unit;
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
 * <!-- begin-user-doc --> The <b>Adapter Factory</b> for the model. It provides an adapter
 * <code>createXXX</code> method for each class of the model. <!-- end-user-doc -->
 * @see com.ibm.ccl.soa.deploy.os.OsPackage
 * @generated
 */
public class OsAdapterFactory extends AdapterFactoryImpl {
	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public static final String copyright = "Copyright (c) 2005, 2006 IBM Corporation. Licensed Material - Property of IBM. All rights reserved."; //$NON-NLS-1$

	/**
	 * The cached model package.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	protected static OsPackage modelPackage;

	/**
	 * Creates an instance of the adapter factory.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public OsAdapterFactory() {
		if (modelPackage == null) {
			modelPackage = OsPackage.eINSTANCE;
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
			return ((EObject) object).eClass().getEPackage() == modelPackage;
		}
		return false;
	}

	/**
	 * The switch the delegates to the <code>createXXX</code> methods.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @generated
	 */
	protected OsSwitch modelSwitch = new OsSwitch() {
		public Object caseAIXLocalGroup(AIXLocalGroup object) {
			return createAIXLocalGroupAdapter();
		}

		public Object caseAIXLocalGroupUnit(AIXLocalGroupUnit object) {
			return createAIXLocalGroupUnitAdapter();
		}

		public Object caseAIXLocalService(AIXLocalService object) {
			return createAIXLocalServiceAdapter();
		}

		public Object caseAIXLocalServiceUnit(AIXLocalServiceUnit object) {
			return createAIXLocalServiceUnitAdapter();
		}

		public Object caseAIXLocalUser(AIXLocalUser object) {
			return createAIXLocalUserAdapter();
		}

		public Object caseAIXLocalUserUnit(AIXLocalUserUnit object) {
			return createAIXLocalUserUnitAdapter();
		}

		public Object caseAIXOperatingSystem(AIXOperatingSystem object) {
			return createAIXOperatingSystemAdapter();
		}

		public Object caseAIXOperatingSystemUnit(AIXOperatingSystemUnit object) {
			return createAIXOperatingSystemUnitAdapter();
		}

		public Object caseDataFile(DataFile object) {
			return createDataFileAdapter();
		}

		public Object caseDataFileUnit(DataFileUnit object) {
			return createDataFileUnitAdapter();
		}

		public Object caseDirectory(Directory object) {
			return createDirectoryAdapter();
		}

		public Object caseDirectoryUnit(DirectoryUnit object) {
			return createDirectoryUnitAdapter();
		}

		public Object caseFileSystem(FileSystem object) {
			return createFileSystemAdapter();
		}

		public Object caseFileSystemContent(FileSystemContent object) {
			return createFileSystemContentAdapter();
		}

		public Object caseFileSystemContentUnit(FileSystemContentUnit object) {
			return createFileSystemContentUnitAdapter();
		}

		public Object caseFileSystemUnit(FileSystemUnit object) {
			return createFileSystemUnitAdapter();
		}

		public Object caseLinuxLocalGroup(LinuxLocalGroup object) {
			return createLinuxLocalGroupAdapter();
		}

		public Object caseLinuxLocalGroupUnit(LinuxLocalGroupUnit object) {
			return createLinuxLocalGroupUnitAdapter();
		}

		public Object caseLinuxLocalService(LinuxLocalService object) {
			return createLinuxLocalServiceAdapter();
		}

		public Object caseLinuxLocalServiceUnit(LinuxLocalServiceUnit object) {
			return createLinuxLocalServiceUnitAdapter();
		}

		public Object caseLinuxLocalUser(LinuxLocalUser object) {
			return createLinuxLocalUserAdapter();
		}

		public Object caseLinuxLocalUserUnit(LinuxLocalUserUnit object) {
			return createLinuxLocalUserUnitAdapter();
		}

		public Object caseLinuxOperatingSystem(LinuxOperatingSystem object) {
			return createLinuxOperatingSystemAdapter();
		}

		public Object caseLinuxOperatingSystemUnit(LinuxOperatingSystemUnit object) {
			return createLinuxOperatingSystemUnitAdapter();
		}

		public Object caseLocalFileSystem(LocalFileSystem object) {
			return createLocalFileSystemAdapter();
		}

		public Object caseLocalFileSystemUnit(LocalFileSystemUnit object) {
			return createLocalFileSystemUnitAdapter();
		}

		public Object caseNFSFileSystem(NFSFileSystem object) {
			return createNFSFileSystemAdapter();
		}

		public Object caseNFSFileSystemUnit(NFSFileSystemUnit object) {
			return createNFSFileSystemUnitAdapter();
		}

		public Object caseOpenVmsFileSystem(OpenVmsFileSystem object) {
			return createOpenVmsFileSystemAdapter();
		}

		public Object caseOpenVmsFileSystemUnit(OpenVmsFileSystemUnit object) {
			return createOpenVmsFileSystemUnitAdapter();
		}

		public Object caseOperatingSystem(OperatingSystem object) {
			return createOperatingSystemAdapter();
		}

		public Object caseOperatingSystemRoot(OperatingSystemRoot object) {
			return createOperatingSystemRootAdapter();
		}

		public Object caseOperatingSystemUnit(OperatingSystemUnit object) {
			return createOperatingSystemUnitAdapter();
		}

		public Object casePort(Port object) {
			return createPortAdapter();
		}

		public Object casePortConfigUnit(PortConfigUnit object) {
			return createPortConfigUnitAdapter();
		}

		public Object casePortConsumer(PortConsumer object) {
			return createPortConsumerAdapter();
		}

		public Object caseRedhatLinuxLocalGroup(RedhatLinuxLocalGroup object) {
			return createRedhatLinuxLocalGroupAdapter();
		}

		public Object caseRedhatLinuxLocalService(RedhatLinuxLocalService object) {
			return createRedhatLinuxLocalServiceAdapter();
		}

		public Object caseRedhatLinuxLocalUser(RedhatLinuxLocalUser object) {
			return createRedhatLinuxLocalUserAdapter();
		}

		public Object caseRedhatLinuxOperatingSystem(RedhatLinuxOperatingSystem object) {
			return createRedhatLinuxOperatingSystemAdapter();
		}

		public Object caseRemoteFileSystem(RemoteFileSystem object) {
			return createRemoteFileSystemAdapter();
		}

		public Object caseRemoteFileSystemUnit(RemoteFileSystemUnit object) {
			return createRemoteFileSystemUnitAdapter();
		}

		public Object caseSMBFileSystem(SMBFileSystem object) {
			return createSMBFileSystemAdapter();
		}

		public Object caseSMBFileSystemUnit(SMBFileSystemUnit object) {
			return createSMBFileSystemUnitAdapter();
		}

		public Object caseSolarisFileSystem(SolarisFileSystem object) {
			return createSolarisFileSystemAdapter();
		}

		public Object caseSolarisFileSystemUnit(SolarisFileSystemUnit object) {
			return createSolarisFileSystemUnitAdapter();
		}

		public Object caseSUSELinuxLocalGroup(SUSELinuxLocalGroup object) {
			return createSUSELinuxLocalGroupAdapter();
		}

		public Object caseSUSELinuxLocalService(SUSELinuxLocalService object) {
			return createSUSELinuxLocalServiceAdapter();
		}

		public Object caseSUSELinuxLocalUser(SUSELinuxLocalUser object) {
			return createSUSELinuxLocalUserAdapter();
		}

		public Object caseSUSELinuxOperatingSystem(SUSELinuxOperatingSystem object) {
			return createSUSELinuxOperatingSystemAdapter();
		}

		public Object caseUnixDirectory(UnixDirectory object) {
			return createUnixDirectoryAdapter();
		}

		public Object caseUnixFileSystem(UnixFileSystem object) {
			return createUnixFileSystemAdapter();
		}

		public Object caseUnixFileSystemUnit(UnixFileSystemUnit object) {
			return createUnixFileSystemUnitAdapter();
		}

		public Object caseUser(User object) {
			return createUserAdapter();
		}

		public Object caseUserGroup(UserGroup object) {
			return createUserGroupAdapter();
		}

		public Object caseUserGroupUnit(UserGroupUnit object) {
			return createUserGroupUnitAdapter();
		}

		public Object caseUserUnit(UserUnit object) {
			return createUserUnitAdapter();
		}

		public Object caseWindowsDirectory(WindowsDirectory object) {
			return createWindowsDirectoryAdapter();
		}

		public Object caseWindowsFileSystem(WindowsFileSystem object) {
			return createWindowsFileSystemAdapter();
		}

		public Object caseWindowsFileSystemUnit(WindowsFileSystemUnit object) {
			return createWindowsFileSystemUnitAdapter();
		}

		public Object caseWindowsLocalGroup(WindowsLocalGroup object) {
			return createWindowsLocalGroupAdapter();
		}

		public Object caseWindowsLocalGroupUnit(WindowsLocalGroupUnit object) {
			return createWindowsLocalGroupUnitAdapter();
		}

		public Object caseWindowsLocalService(WindowsLocalService object) {
			return createWindowsLocalServiceAdapter();
		}

		public Object caseWindowsLocalServiceUnit(WindowsLocalServiceUnit object) {
			return createWindowsLocalServiceUnitAdapter();
		}

		public Object caseWindowsLocalUser(WindowsLocalUser object) {
			return createWindowsLocalUserAdapter();
		}

		public Object caseWindowsLocalUserUnit(WindowsLocalUserUnit object) {
			return createWindowsLocalUserUnitAdapter();
		}

		public Object caseWindowsOperatingSystem(WindowsOperatingSystem object) {
			return createWindowsOperatingSystemAdapter();
		}

		public Object caseWindowsOperatingSystemUnit(WindowsOperatingSystemUnit object) {
			return createWindowsOperatingSystemUnitAdapter();
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
	 * Creates an adapter for the <code>target</code>. <!-- begin-user-doc --> <!-- end-user-doc
	 * -->
	 * 
	 * @param target
	 *           the object to adapt.
	 * @return the adapter for the <code>target</code>.
	 * @generated
	 */
	public Adapter createAdapter(Notifier target) {
		return (Adapter) modelSwitch.doSwitch((EObject) target);
	}

	/**
	 * Creates a new adapter for an object of class '{@link com.ibm.ccl.soa.deploy.os.AIXLocalGroup <em>AIX Local Group</em>}'.
	 * <!-- begin-user-doc --> This default implementation returns null so that we can easily ignore
	 * cases; it's useful to ignore a case when inheritance will catch all the cases anyway. <!--
	 * end-user-doc -->
	 * @return the new adapter.
	 * @see com.ibm.ccl.soa.deploy.os.AIXLocalGroup
	 * @generated
	 */
	public Adapter createAIXLocalGroupAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link com.ibm.ccl.soa.deploy.os.AIXLocalGroupUnit <em>AIX Local Group Unit</em>}'.
	 * <!-- begin-user-doc --> This default implementation returns null so that we can easily ignore
	 * cases; it's useful to ignore a case when inheritance will catch all the cases anyway. <!--
	 * end-user-doc -->
	 * @return the new adapter.
	 * @see com.ibm.ccl.soa.deploy.os.AIXLocalGroupUnit
	 * @generated
	 */
	public Adapter createAIXLocalGroupUnitAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link com.ibm.ccl.soa.deploy.os.AIXLocalService <em>AIX Local Service</em>}'.
	 * <!-- begin-user-doc --> This default implementation returns null so that we can easily ignore
	 * cases; it's useful to ignore a case when inheritance will catch all the cases anyway. <!--
	 * end-user-doc -->
	 * @return the new adapter.
	 * @see com.ibm.ccl.soa.deploy.os.AIXLocalService
	 * @generated
	 */
	public Adapter createAIXLocalServiceAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link com.ibm.ccl.soa.deploy.os.AIXLocalServiceUnit <em>AIX Local Service Unit</em>}'.
	 * <!-- begin-user-doc --> This default implementation returns null so that we can easily ignore
	 * cases; it's useful to ignore a case when inheritance will catch all the cases anyway. <!--
	 * end-user-doc -->
	 * @return the new adapter.
	 * @see com.ibm.ccl.soa.deploy.os.AIXLocalServiceUnit
	 * @generated
	 */
	public Adapter createAIXLocalServiceUnitAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link com.ibm.ccl.soa.deploy.os.AIXLocalUser <em>AIX Local User</em>}'.
	 * <!-- begin-user-doc --> This default implementation returns null so that we can easily ignore
	 * cases; it's useful to ignore a case when inheritance will catch all the cases anyway. <!--
	 * end-user-doc -->
	 * @return the new adapter.
	 * @see com.ibm.ccl.soa.deploy.os.AIXLocalUser
	 * @generated
	 */
	public Adapter createAIXLocalUserAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link com.ibm.ccl.soa.deploy.os.AIXLocalUserUnit <em>AIX Local User Unit</em>}'.
	 * <!-- begin-user-doc --> This default implementation returns null so that we can easily ignore
	 * cases; it's useful to ignore a case when inheritance will catch all the cases anyway. <!--
	 * end-user-doc -->
	 * @return the new adapter.
	 * @see com.ibm.ccl.soa.deploy.os.AIXLocalUserUnit
	 * @generated
	 */
	public Adapter createAIXLocalUserUnitAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link com.ibm.ccl.soa.deploy.os.AIXOperatingSystem <em>AIX Operating System</em>}'.
	 * <!-- begin-user-doc --> This default implementation returns null so that we can easily ignore
	 * cases; it's useful to ignore a case when inheritance will catch all the cases anyway. <!--
	 * end-user-doc -->
	 * @return the new adapter.
	 * @see com.ibm.ccl.soa.deploy.os.AIXOperatingSystem
	 * @generated
	 */
	public Adapter createAIXOperatingSystemAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link com.ibm.ccl.soa.deploy.os.AIXOperatingSystemUnit <em>AIX Operating System Unit</em>}'.
	 * <!-- begin-user-doc --> This default implementation returns null so that we can easily ignore
	 * cases; it's useful to ignore a case when inheritance will catch all the cases anyway. <!--
	 * end-user-doc -->
	 * @return the new adapter.
	 * @see com.ibm.ccl.soa.deploy.os.AIXOperatingSystemUnit
	 * @generated
	 */
	public Adapter createAIXOperatingSystemUnitAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link com.ibm.ccl.soa.deploy.os.DataFile <em>Data File</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see com.ibm.ccl.soa.deploy.os.DataFile
	 * @generated
	 */
	public Adapter createDataFileAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link com.ibm.ccl.soa.deploy.os.DataFileUnit <em>Data File Unit</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see com.ibm.ccl.soa.deploy.os.DataFileUnit
	 * @generated
	 */
	public Adapter createDataFileUnitAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link com.ibm.ccl.soa.deploy.os.Directory <em>Directory</em>}'.
	 * <!-- begin-user-doc --> This default implementation returns null so that we can easily ignore
	 * cases; it's useful to ignore a case when inheritance will catch all the cases anyway. <!--
	 * end-user-doc -->
	 * @return the new adapter.
	 * @see com.ibm.ccl.soa.deploy.os.Directory
	 * @generated
	 */
	public Adapter createDirectoryAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link com.ibm.ccl.soa.deploy.os.DirectoryUnit <em>Directory Unit</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see com.ibm.ccl.soa.deploy.os.DirectoryUnit
	 * @generated
	 */
	public Adapter createDirectoryUnitAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link com.ibm.ccl.soa.deploy.os.FileSystem <em>File System</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see com.ibm.ccl.soa.deploy.os.FileSystem
	 * @generated
	 */
	public Adapter createFileSystemAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link com.ibm.ccl.soa.deploy.os.FileSystemContent <em>File System Content</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see com.ibm.ccl.soa.deploy.os.FileSystemContent
	 * @generated
	 */
	public Adapter createFileSystemContentAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link com.ibm.ccl.soa.deploy.os.FileSystemContentUnit <em>File System Content Unit</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see com.ibm.ccl.soa.deploy.os.FileSystemContentUnit
	 * @generated
	 */
	public Adapter createFileSystemContentUnitAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link com.ibm.ccl.soa.deploy.os.FileSystemUnit <em>File System Unit</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see com.ibm.ccl.soa.deploy.os.FileSystemUnit
	 * @generated
	 */
	public Adapter createFileSystemUnitAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link com.ibm.ccl.soa.deploy.os.LinuxLocalGroup <em>Linux Local Group</em>}'.
	 * <!-- begin-user-doc --> This default implementation returns null so that we can easily ignore
	 * cases; it's useful to ignore a case when inheritance will catch all the cases anyway. <!--
	 * end-user-doc -->
	 * @return the new adapter.
	 * @see com.ibm.ccl.soa.deploy.os.LinuxLocalGroup
	 * @generated
	 */
	public Adapter createLinuxLocalGroupAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link com.ibm.ccl.soa.deploy.os.LinuxLocalGroupUnit <em>Linux Local Group Unit</em>}'.
	 * <!-- begin-user-doc --> This default implementation returns null so that we can easily ignore
	 * cases; it's useful to ignore a case when inheritance will catch all the cases anyway. <!--
	 * end-user-doc -->
	 * @return the new adapter.
	 * @see com.ibm.ccl.soa.deploy.os.LinuxLocalGroupUnit
	 * @generated
	 */
	public Adapter createLinuxLocalGroupUnitAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link com.ibm.ccl.soa.deploy.os.LinuxLocalService <em>Linux Local Service</em>}'.
	 * <!-- begin-user-doc --> This default implementation returns null so that we can easily ignore
	 * cases; it's useful to ignore a case when inheritance will catch all the cases anyway. <!--
	 * end-user-doc -->
	 * @return the new adapter.
	 * @see com.ibm.ccl.soa.deploy.os.LinuxLocalService
	 * @generated
	 */
	public Adapter createLinuxLocalServiceAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link com.ibm.ccl.soa.deploy.os.LinuxLocalServiceUnit <em>Linux Local Service Unit</em>}'.
	 * <!-- begin-user-doc --> This default implementation returns null so that we can easily ignore
	 * cases; it's useful to ignore a case when inheritance will catch all the cases anyway. <!--
	 * end-user-doc -->
	 * @return the new adapter.
	 * @see com.ibm.ccl.soa.deploy.os.LinuxLocalServiceUnit
	 * @generated
	 */
	public Adapter createLinuxLocalServiceUnitAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link com.ibm.ccl.soa.deploy.os.LinuxLocalUser <em>Linux Local User</em>}'.
	 * <!-- begin-user-doc --> This default implementation returns null so that we can easily ignore
	 * cases; it's useful to ignore a case when inheritance will catch all the cases anyway. <!--
	 * end-user-doc -->
	 * @return the new adapter.
	 * @see com.ibm.ccl.soa.deploy.os.LinuxLocalUser
	 * @generated
	 */
	public Adapter createLinuxLocalUserAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link com.ibm.ccl.soa.deploy.os.LinuxLocalUserUnit <em>Linux Local User Unit</em>}'.
	 * <!-- begin-user-doc --> This default implementation returns null so that we can easily ignore
	 * cases; it's useful to ignore a case when inheritance will catch all the cases anyway. <!--
	 * end-user-doc -->
	 * @return the new adapter.
	 * @see com.ibm.ccl.soa.deploy.os.LinuxLocalUserUnit
	 * @generated
	 */
	public Adapter createLinuxLocalUserUnitAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link com.ibm.ccl.soa.deploy.os.LinuxOperatingSystem <em>Linux Operating System</em>}'.
	 * <!-- begin-user-doc --> This default implementation returns null so that we can easily ignore
	 * cases; it's useful to ignore a case when inheritance will catch all the cases anyway. <!--
	 * end-user-doc -->
	 * @return the new adapter.
	 * @see com.ibm.ccl.soa.deploy.os.LinuxOperatingSystem
	 * @generated
	 */
	public Adapter createLinuxOperatingSystemAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link com.ibm.ccl.soa.deploy.os.LinuxOperatingSystemUnit <em>Linux Operating System Unit</em>}'.
	 * <!-- begin-user-doc --> This default implementation returns null so that we can easily ignore
	 * cases; it's useful to ignore a case when inheritance will catch all the cases anyway. <!--
	 * end-user-doc -->
	 * @return the new adapter.
	 * @see com.ibm.ccl.soa.deploy.os.LinuxOperatingSystemUnit
	 * @generated
	 */
	public Adapter createLinuxOperatingSystemUnitAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link com.ibm.ccl.soa.deploy.os.LocalFileSystem <em>Local File System</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see com.ibm.ccl.soa.deploy.os.LocalFileSystem
	 * @generated
	 */
	public Adapter createLocalFileSystemAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link com.ibm.ccl.soa.deploy.os.LocalFileSystemUnit <em>Local File System Unit</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see com.ibm.ccl.soa.deploy.os.LocalFileSystemUnit
	 * @generated
	 */
	public Adapter createLocalFileSystemUnitAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link com.ibm.ccl.soa.deploy.os.NFSFileSystem <em>NFS File System</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see com.ibm.ccl.soa.deploy.os.NFSFileSystem
	 * @generated
	 */
	public Adapter createNFSFileSystemAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link com.ibm.ccl.soa.deploy.os.NFSFileSystemUnit <em>NFS File System Unit</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see com.ibm.ccl.soa.deploy.os.NFSFileSystemUnit
	 * @generated
	 */
	public Adapter createNFSFileSystemUnitAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link com.ibm.ccl.soa.deploy.os.OpenVmsFileSystem <em>Open Vms File System</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see com.ibm.ccl.soa.deploy.os.OpenVmsFileSystem
	 * @generated
	 */
	public Adapter createOpenVmsFileSystemAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link com.ibm.ccl.soa.deploy.os.OpenVmsFileSystemUnit <em>Open Vms File System Unit</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see com.ibm.ccl.soa.deploy.os.OpenVmsFileSystemUnit
	 * @generated
	 */
	public Adapter createOpenVmsFileSystemUnitAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link com.ibm.ccl.soa.deploy.os.OperatingSystem <em>Operating System</em>}'.
	 * <!-- begin-user-doc --> This default implementation returns null so that we can easily ignore
	 * cases; it's useful to ignore a case when inheritance will catch all the cases anyway. <!--
	 * end-user-doc -->
	 * @return the new adapter.
	 * @see com.ibm.ccl.soa.deploy.os.OperatingSystem
	 * @generated
	 */
	public Adapter createOperatingSystemAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link com.ibm.ccl.soa.deploy.os.OperatingSystemRoot <em>Operating System Root</em>}'.
	 * <!-- begin-user-doc --> This default implementation returns null so that we can easily ignore
	 * cases; it's useful to ignore a case when inheritance will catch all the cases anyway. <!--
	 * end-user-doc -->
	 * @return the new adapter.
	 * @see com.ibm.ccl.soa.deploy.os.OperatingSystemRoot
	 * @generated
	 */
	public Adapter createOperatingSystemRootAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link com.ibm.ccl.soa.deploy.os.OperatingSystemUnit <em>Operating System Unit</em>}'.
	 * <!-- begin-user-doc --> This default implementation returns null so that we can easily ignore
	 * cases; it's useful to ignore a case when inheritance will catch all the cases anyway. <!--
	 * end-user-doc -->
	 * @return the new adapter.
	 * @see com.ibm.ccl.soa.deploy.os.OperatingSystemUnit
	 * @generated
	 */
	public Adapter createOperatingSystemUnitAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link com.ibm.ccl.soa.deploy.os.Port <em>Port</em>}'.
	 * <!-- begin-user-doc --> This default implementation returns null so that we can easily ignore
	 * cases; it's useful to ignore a case when inheritance will catch all the cases anyway. <!--
	 * end-user-doc -->
	 * @return the new adapter.
	 * @see com.ibm.ccl.soa.deploy.os.Port
	 * @generated
	 */
	public Adapter createPortAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link com.ibm.ccl.soa.deploy.os.PortConfigUnit <em>Port Config Unit</em>}'.
	 * <!-- begin-user-doc --> This default implementation returns null so that we can easily ignore
	 * cases; it's useful to ignore a case when inheritance will catch all the cases anyway. <!--
	 * end-user-doc -->
	 * @return the new adapter.
	 * @see com.ibm.ccl.soa.deploy.os.PortConfigUnit
	 * @generated
	 */
	public Adapter createPortConfigUnitAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link com.ibm.ccl.soa.deploy.os.PortConsumer <em>Port Consumer</em>}'.
	 * <!-- begin-user-doc --> This default implementation returns null so that we can easily ignore
	 * cases; it's useful to ignore a case when inheritance will catch all the cases anyway. <!--
	 * end-user-doc -->
	 * @return the new adapter.
	 * @see com.ibm.ccl.soa.deploy.os.PortConsumer
	 * @generated
	 */
	public Adapter createPortConsumerAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link com.ibm.ccl.soa.deploy.os.RedhatLinuxLocalGroup <em>Redhat Linux Local Group</em>}'.
	 * <!-- begin-user-doc --> This default implementation returns null so that we can easily ignore
	 * cases; it's useful to ignore a case when inheritance will catch all the cases anyway. <!--
	 * end-user-doc -->
	 * @return the new adapter.
	 * @see com.ibm.ccl.soa.deploy.os.RedhatLinuxLocalGroup
	 * @generated
	 */
	public Adapter createRedhatLinuxLocalGroupAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link com.ibm.ccl.soa.deploy.os.RedhatLinuxLocalService <em>Redhat Linux Local Service</em>}'.
	 * <!-- begin-user-doc --> This default implementation returns null so that we can easily ignore
	 * cases; it's useful to ignore a case when inheritance will catch all the cases anyway. <!--
	 * end-user-doc -->
	 * @return the new adapter.
	 * @see com.ibm.ccl.soa.deploy.os.RedhatLinuxLocalService
	 * @generated
	 */
	public Adapter createRedhatLinuxLocalServiceAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link com.ibm.ccl.soa.deploy.os.RedhatLinuxLocalUser <em>Redhat Linux Local User</em>}'.
	 * <!-- begin-user-doc --> This default implementation returns null so that we can easily ignore
	 * cases; it's useful to ignore a case when inheritance will catch all the cases anyway. <!--
	 * end-user-doc -->
	 * @return the new adapter.
	 * @see com.ibm.ccl.soa.deploy.os.RedhatLinuxLocalUser
	 * @generated
	 */
	public Adapter createRedhatLinuxLocalUserAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link com.ibm.ccl.soa.deploy.os.RedhatLinuxOperatingSystem <em>Redhat Linux Operating System</em>}'.
	 * <!-- begin-user-doc --> This default implementation returns null so that we can easily ignore
	 * cases; it's useful to ignore a case when inheritance will catch all the cases anyway. <!--
	 * end-user-doc -->
	 * @return the new adapter.
	 * @see com.ibm.ccl.soa.deploy.os.RedhatLinuxOperatingSystem
	 * @generated
	 */
	public Adapter createRedhatLinuxOperatingSystemAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link com.ibm.ccl.soa.deploy.os.RemoteFileSystem <em>Remote File System</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see com.ibm.ccl.soa.deploy.os.RemoteFileSystem
	 * @generated
	 */
	public Adapter createRemoteFileSystemAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link com.ibm.ccl.soa.deploy.os.RemoteFileSystemUnit <em>Remote File System Unit</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see com.ibm.ccl.soa.deploy.os.RemoteFileSystemUnit
	 * @generated
	 */
	public Adapter createRemoteFileSystemUnitAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link com.ibm.ccl.soa.deploy.os.SMBFileSystem <em>SMB File System</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see com.ibm.ccl.soa.deploy.os.SMBFileSystem
	 * @generated
	 */
	public Adapter createSMBFileSystemAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link com.ibm.ccl.soa.deploy.os.SMBFileSystemUnit <em>SMB File System Unit</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see com.ibm.ccl.soa.deploy.os.SMBFileSystemUnit
	 * @generated
	 */
	public Adapter createSMBFileSystemUnitAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link com.ibm.ccl.soa.deploy.os.SolarisFileSystem <em>Solaris File System</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see com.ibm.ccl.soa.deploy.os.SolarisFileSystem
	 * @generated
	 */
	public Adapter createSolarisFileSystemAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link com.ibm.ccl.soa.deploy.os.SolarisFileSystemUnit <em>Solaris File System Unit</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see com.ibm.ccl.soa.deploy.os.SolarisFileSystemUnit
	 * @generated
	 */
	public Adapter createSolarisFileSystemUnitAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link com.ibm.ccl.soa.deploy.os.SUSELinuxLocalGroup <em>SUSE Linux Local Group</em>}'.
	 * <!-- begin-user-doc --> This default implementation returns null so that we can easily ignore
	 * cases; it's useful to ignore a case when inheritance will catch all the cases anyway. <!--
	 * end-user-doc -->
	 * @return the new adapter.
	 * @see com.ibm.ccl.soa.deploy.os.SUSELinuxLocalGroup
	 * @generated
	 */
	public Adapter createSUSELinuxLocalGroupAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link com.ibm.ccl.soa.deploy.os.SUSELinuxLocalService <em>SUSE Linux Local Service</em>}'.
	 * <!-- begin-user-doc --> This default implementation returns null so that we can easily ignore
	 * cases; it's useful to ignore a case when inheritance will catch all the cases anyway. <!--
	 * end-user-doc -->
	 * @return the new adapter.
	 * @see com.ibm.ccl.soa.deploy.os.SUSELinuxLocalService
	 * @generated
	 */
	public Adapter createSUSELinuxLocalServiceAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link com.ibm.ccl.soa.deploy.os.SUSELinuxLocalUser <em>SUSE Linux Local User</em>}'.
	 * <!-- begin-user-doc --> This default implementation returns null so that we can easily ignore
	 * cases; it's useful to ignore a case when inheritance will catch all the cases anyway. <!--
	 * end-user-doc -->
	 * @return the new adapter.
	 * @see com.ibm.ccl.soa.deploy.os.SUSELinuxLocalUser
	 * @generated
	 */
	public Adapter createSUSELinuxLocalUserAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link com.ibm.ccl.soa.deploy.os.SUSELinuxOperatingSystem <em>SUSE Linux Operating System</em>}'.
	 * <!-- begin-user-doc --> This default implementation returns null so that we can easily ignore
	 * cases; it's useful to ignore a case when inheritance will catch all the cases anyway. <!--
	 * end-user-doc -->
	 * @return the new adapter.
	 * @see com.ibm.ccl.soa.deploy.os.SUSELinuxOperatingSystem
	 * @generated
	 */
	public Adapter createSUSELinuxOperatingSystemAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link com.ibm.ccl.soa.deploy.os.UnixDirectory <em>Unix Directory</em>}'.
	 * <!-- begin-user-doc --> This default implementation returns null so that we can easily ignore
	 * cases; it's useful to ignore a case when inheritance will catch all the cases anyway. <!--
	 * end-user-doc -->
	 * @return the new adapter.
	 * @see com.ibm.ccl.soa.deploy.os.UnixDirectory
	 * @generated
	 */
	public Adapter createUnixDirectoryAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link com.ibm.ccl.soa.deploy.os.UnixFileSystem <em>Unix File System</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see com.ibm.ccl.soa.deploy.os.UnixFileSystem
	 * @generated
	 */
	public Adapter createUnixFileSystemAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link com.ibm.ccl.soa.deploy.os.UnixFileSystemUnit <em>Unix File System Unit</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see com.ibm.ccl.soa.deploy.os.UnixFileSystemUnit
	 * @generated
	 */
	public Adapter createUnixFileSystemUnitAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link com.ibm.ccl.soa.deploy.os.User <em>User</em>}'.
	 * <!-- begin-user-doc --> This default implementation returns null so that we can easily ignore
	 * cases; it's useful to ignore a case when inheritance will catch all the cases anyway. <!--
	 * end-user-doc -->
	 * @return the new adapter.
	 * @see com.ibm.ccl.soa.deploy.os.User
	 * @generated
	 */
	public Adapter createUserAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link com.ibm.ccl.soa.deploy.os.UserGroup <em>User Group</em>}'.
	 * <!-- begin-user-doc --> This default implementation returns null so that we can easily ignore
	 * cases; it's useful to ignore a case when inheritance will catch all the cases anyway. <!--
	 * end-user-doc -->
	 * @return the new adapter.
	 * @see com.ibm.ccl.soa.deploy.os.UserGroup
	 * @generated
	 */
	public Adapter createUserGroupAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link com.ibm.ccl.soa.deploy.os.UserGroupUnit <em>User Group Unit</em>}'.
	 * <!-- begin-user-doc --> This default implementation returns null so that we can easily ignore
	 * cases; it's useful to ignore a case when inheritance will catch all the cases anyway. <!--
	 * end-user-doc -->
	 * @return the new adapter.
	 * @see com.ibm.ccl.soa.deploy.os.UserGroupUnit
	 * @generated
	 */
	public Adapter createUserGroupUnitAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link com.ibm.ccl.soa.deploy.os.UserUnit <em>User Unit</em>}'.
	 * <!-- begin-user-doc --> This default implementation returns null so that we can easily ignore
	 * cases; it's useful to ignore a case when inheritance will catch all the cases anyway. <!--
	 * end-user-doc -->
	 * @return the new adapter.
	 * @see com.ibm.ccl.soa.deploy.os.UserUnit
	 * @generated
	 */
	public Adapter createUserUnitAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link com.ibm.ccl.soa.deploy.os.WindowsDirectory <em>Windows Directory</em>}'.
	 * <!-- begin-user-doc --> This default implementation returns null so that we can easily ignore
	 * cases; it's useful to ignore a case when inheritance will catch all the cases anyway. <!--
	 * end-user-doc -->
	 * @return the new adapter.
	 * @see com.ibm.ccl.soa.deploy.os.WindowsDirectory
	 * @generated
	 */
	public Adapter createWindowsDirectoryAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link com.ibm.ccl.soa.deploy.os.WindowsFileSystem <em>Windows File System</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see com.ibm.ccl.soa.deploy.os.WindowsFileSystem
	 * @generated
	 */
	public Adapter createWindowsFileSystemAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link com.ibm.ccl.soa.deploy.os.WindowsFileSystemUnit <em>Windows File System Unit</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see com.ibm.ccl.soa.deploy.os.WindowsFileSystemUnit
	 * @generated
	 */
	public Adapter createWindowsFileSystemUnitAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link com.ibm.ccl.soa.deploy.os.WindowsLocalGroup <em>Windows Local Group</em>}'.
	 * <!-- begin-user-doc --> This default implementation returns null so that we can easily ignore
	 * cases; it's useful to ignore a case when inheritance will catch all the cases anyway. <!--
	 * end-user-doc -->
	 * @return the new adapter.
	 * @see com.ibm.ccl.soa.deploy.os.WindowsLocalGroup
	 * @generated
	 */
	public Adapter createWindowsLocalGroupAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link com.ibm.ccl.soa.deploy.os.WindowsLocalGroupUnit <em>Windows Local Group Unit</em>}'.
	 * <!-- begin-user-doc --> This default implementation returns null so that we can easily ignore
	 * cases; it's useful to ignore a case when inheritance will catch all the cases anyway. <!--
	 * end-user-doc -->
	 * @return the new adapter.
	 * @see com.ibm.ccl.soa.deploy.os.WindowsLocalGroupUnit
	 * @generated
	 */
	public Adapter createWindowsLocalGroupUnitAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link com.ibm.ccl.soa.deploy.os.WindowsLocalService <em>Windows Local Service</em>}'.
	 * <!-- begin-user-doc --> This default implementation returns null so that we can easily ignore
	 * cases; it's useful to ignore a case when inheritance will catch all the cases anyway. <!--
	 * end-user-doc -->
	 * @return the new adapter.
	 * @see com.ibm.ccl.soa.deploy.os.WindowsLocalService
	 * @generated
	 */
	public Adapter createWindowsLocalServiceAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link com.ibm.ccl.soa.deploy.os.WindowsLocalServiceUnit <em>Windows Local Service Unit</em>}'.
	 * <!-- begin-user-doc --> This default implementation returns null so that we can easily ignore
	 * cases; it's useful to ignore a case when inheritance will catch all the cases anyway. <!--
	 * end-user-doc -->
	 * @return the new adapter.
	 * @see com.ibm.ccl.soa.deploy.os.WindowsLocalServiceUnit
	 * @generated
	 */
	public Adapter createWindowsLocalServiceUnitAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link com.ibm.ccl.soa.deploy.os.WindowsLocalUser <em>Windows Local User</em>}'.
	 * <!-- begin-user-doc --> This default implementation returns null so that we can easily ignore
	 * cases; it's useful to ignore a case when inheritance will catch all the cases anyway. <!--
	 * end-user-doc -->
	 * @return the new adapter.
	 * @see com.ibm.ccl.soa.deploy.os.WindowsLocalUser
	 * @generated
	 */
	public Adapter createWindowsLocalUserAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link com.ibm.ccl.soa.deploy.os.WindowsLocalUserUnit <em>Windows Local User Unit</em>}'.
	 * <!-- begin-user-doc --> This default implementation returns null so that we can easily ignore
	 * cases; it's useful to ignore a case when inheritance will catch all the cases anyway. <!--
	 * end-user-doc -->
	 * @return the new adapter.
	 * @see com.ibm.ccl.soa.deploy.os.WindowsLocalUserUnit
	 * @generated
	 */
	public Adapter createWindowsLocalUserUnitAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link com.ibm.ccl.soa.deploy.os.WindowsOperatingSystem <em>Windows Operating System</em>}'.
	 * <!-- begin-user-doc --> This default implementation returns null so that we can easily ignore
	 * cases; it's useful to ignore a case when inheritance will catch all the cases anyway. <!--
	 * end-user-doc -->
	 * @return the new adapter.
	 * @see com.ibm.ccl.soa.deploy.os.WindowsOperatingSystem
	 * @generated
	 */
	public Adapter createWindowsOperatingSystemAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link com.ibm.ccl.soa.deploy.os.WindowsOperatingSystemUnit <em>Windows Operating System Unit</em>}'.
	 * <!-- begin-user-doc --> This default implementation returns null so that we can easily ignore
	 * cases; it's useful to ignore a case when inheritance will catch all the cases anyway. <!--
	 * end-user-doc -->
	 * @return the new adapter.
	 * @see com.ibm.ccl.soa.deploy.os.WindowsOperatingSystemUnit
	 * @generated
	 */
	public Adapter createWindowsOperatingSystemUnitAdapter() {
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
	 * Creates a new adapter for the default case.
	 * <!-- begin-user-doc --> This default
	 * implementation returns null. <!-- end-user-doc -->
	 * @return the new adapter.
	 * @generated
	 */
	public Adapter createEObjectAdapter() {
		return null;
	}

} //OsAdapterFactory
