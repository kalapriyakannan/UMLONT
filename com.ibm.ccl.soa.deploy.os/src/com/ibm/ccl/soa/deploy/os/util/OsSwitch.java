/*******************************************************************************
 * Copyright (c) 2003, 2007 IBM Corporation Licensed Material - Property of IBM. All rights reserved.
 *  
 * US Government Users Restricted Rights - Use, duplication or disclosure v1.0 restricted by GSA ADP
 * Schedule Contract with IBM Corp.
 * 
 * Contributors: IBM Corporation - initial API and implementation
 *******************************************************************************/
package com.ibm.ccl.soa.deploy.os.util;

import java.util.List;

import org.eclipse.emf.ecore.EClass;
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
 * <!-- begin-user-doc --> The <b>Switch</b> for the model's inheritance hierarchy. It supports the
 * call {@link #doSwitch(EObject) doSwitch(object)} to invoke the <code>caseXXX</code> method for
 * each class of the model, starting with the actual class of the object and proceeding up the
 * inheritance hierarchy until a non-null result is returned, which is the result of the switch.
 * <!-- end-user-doc -->
 * @see com.ibm.ccl.soa.deploy.os.OsPackage
 * @generated
 */
public class OsSwitch {
	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public static final String copyright = "Copyright (c) 2005, 2006 IBM Corporation. Licensed Material - Property of IBM. All rights reserved."; //$NON-NLS-1$

	/**
	 * The cached model package
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	protected static OsPackage modelPackage;

	/**
	 * Creates an instance of the switch.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public OsSwitch() {
		if (modelPackage == null) {
			modelPackage = OsPackage.eINSTANCE;
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
		} else {
			List eSuperTypes = theEClass.getESuperTypes();
			return eSuperTypes.isEmpty() ? defaultCase(theEObject) : doSwitch((EClass) eSuperTypes
					.get(0), theEObject);
		}
	}

	/**
	 * Calls <code>caseXXX</code> for each class of the model until one returns a non null result; it yields that result.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return the first non-null result returned by a <code>caseXXX</code> call.
	 * @generated
	 */
	protected Object doSwitch(int classifierID, EObject theEObject) {
		switch (classifierID)
		{
		case OsPackage.AIX_LOCAL_GROUP: {
			AIXLocalGroup aixLocalGroup = (AIXLocalGroup) theEObject;
			Object result = caseAIXLocalGroup(aixLocalGroup);
			if (result == null)
				result = caseUserGroup(aixLocalGroup);
			if (result == null)
				result = caseCapability(aixLocalGroup);
			if (result == null)
				result = caseDeployModelObject(aixLocalGroup);
			if (result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case OsPackage.AIX_LOCAL_GROUP_UNIT: {
			AIXLocalGroupUnit aixLocalGroupUnit = (AIXLocalGroupUnit) theEObject;
			Object result = caseAIXLocalGroupUnit(aixLocalGroupUnit);
			if (result == null)
				result = caseUserGroupUnit(aixLocalGroupUnit);
			if (result == null)
				result = caseUnit(aixLocalGroupUnit);
			if (result == null)
				result = caseDeployModelObject(aixLocalGroupUnit);
			if (result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case OsPackage.AIX_LOCAL_SERVICE: {
			AIXLocalService aixLocalService = (AIXLocalService) theEObject;
			Object result = caseAIXLocalService(aixLocalService);
			if (result == null)
				result = caseCapability(aixLocalService);
			if (result == null)
				result = caseDeployModelObject(aixLocalService);
			if (result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case OsPackage.AIX_LOCAL_SERVICE_UNIT: {
			AIXLocalServiceUnit aixLocalServiceUnit = (AIXLocalServiceUnit) theEObject;
			Object result = caseAIXLocalServiceUnit(aixLocalServiceUnit);
			if (result == null)
				result = caseUnit(aixLocalServiceUnit);
			if (result == null)
				result = caseDeployModelObject(aixLocalServiceUnit);
			if (result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case OsPackage.AIX_LOCAL_USER: {
			AIXLocalUser aixLocalUser = (AIXLocalUser) theEObject;
			Object result = caseAIXLocalUser(aixLocalUser);
			if (result == null)
				result = caseUser(aixLocalUser);
			if (result == null)
				result = caseCapability(aixLocalUser);
			if (result == null)
				result = caseDeployModelObject(aixLocalUser);
			if (result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case OsPackage.AIX_LOCAL_USER_UNIT: {
			AIXLocalUserUnit aixLocalUserUnit = (AIXLocalUserUnit) theEObject;
			Object result = caseAIXLocalUserUnit(aixLocalUserUnit);
			if (result == null)
				result = caseUserUnit(aixLocalUserUnit);
			if (result == null)
				result = caseUnit(aixLocalUserUnit);
			if (result == null)
				result = caseDeployModelObject(aixLocalUserUnit);
			if (result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case OsPackage.AIX_OPERATING_SYSTEM: {
			AIXOperatingSystem aixOperatingSystem = (AIXOperatingSystem) theEObject;
			Object result = caseAIXOperatingSystem(aixOperatingSystem);
			if (result == null)
				result = caseOperatingSystem(aixOperatingSystem);
			if (result == null)
				result = caseCapability(aixOperatingSystem);
			if (result == null)
				result = caseDeployModelObject(aixOperatingSystem);
			if (result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case OsPackage.AIX_OPERATING_SYSTEM_UNIT: {
			AIXOperatingSystemUnit aixOperatingSystemUnit = (AIXOperatingSystemUnit) theEObject;
			Object result = caseAIXOperatingSystemUnit(aixOperatingSystemUnit);
			if (result == null)
				result = caseOperatingSystemUnit(aixOperatingSystemUnit);
			if (result == null)
				result = caseUnit(aixOperatingSystemUnit);
			if (result == null)
				result = caseDeployModelObject(aixOperatingSystemUnit);
			if (result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case OsPackage.DATA_FILE: {
			DataFile dataFile = (DataFile) theEObject;
			Object result = caseDataFile(dataFile);
			if (result == null)
				result = caseFileSystemContent(dataFile);
			if (result == null)
				result = caseCapability(dataFile);
			if (result == null)
				result = caseDeployModelObject(dataFile);
			if (result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case OsPackage.DATA_FILE_UNIT: {
			DataFileUnit dataFileUnit = (DataFileUnit) theEObject;
			Object result = caseDataFileUnit(dataFileUnit);
			if (result == null)
				result = caseFileSystemContentUnit(dataFileUnit);
			if (result == null)
				result = caseUnit(dataFileUnit);
			if (result == null)
				result = caseDeployModelObject(dataFileUnit);
			if (result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case OsPackage.DIRECTORY: {
			Directory directory = (Directory) theEObject;
			Object result = caseDirectory(directory);
			if (result == null)
				result = caseFileSystemContent(directory);
			if (result == null)
				result = caseCapability(directory);
			if (result == null)
				result = caseDeployModelObject(directory);
			if (result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case OsPackage.DIRECTORY_UNIT: {
			DirectoryUnit directoryUnit = (DirectoryUnit) theEObject;
			Object result = caseDirectoryUnit(directoryUnit);
			if (result == null)
				result = caseFileSystemContentUnit(directoryUnit);
			if (result == null)
				result = caseUnit(directoryUnit);
			if (result == null)
				result = caseDeployModelObject(directoryUnit);
			if (result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case OsPackage.FILE_SYSTEM: {
			FileSystem fileSystem = (FileSystem) theEObject;
			Object result = caseFileSystem(fileSystem);
			if (result == null)
				result = caseCapability(fileSystem);
			if (result == null)
				result = caseDeployModelObject(fileSystem);
			if (result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case OsPackage.FILE_SYSTEM_CONTENT: {
			FileSystemContent fileSystemContent = (FileSystemContent) theEObject;
			Object result = caseFileSystemContent(fileSystemContent);
			if (result == null)
				result = caseCapability(fileSystemContent);
			if (result == null)
				result = caseDeployModelObject(fileSystemContent);
			if (result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case OsPackage.FILE_SYSTEM_CONTENT_UNIT: {
			FileSystemContentUnit fileSystemContentUnit = (FileSystemContentUnit) theEObject;
			Object result = caseFileSystemContentUnit(fileSystemContentUnit);
			if (result == null)
				result = caseUnit(fileSystemContentUnit);
			if (result == null)
				result = caseDeployModelObject(fileSystemContentUnit);
			if (result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case OsPackage.FILE_SYSTEM_UNIT: {
			FileSystemUnit fileSystemUnit = (FileSystemUnit) theEObject;
			Object result = caseFileSystemUnit(fileSystemUnit);
			if (result == null)
				result = caseUnit(fileSystemUnit);
			if (result == null)
				result = caseDeployModelObject(fileSystemUnit);
			if (result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case OsPackage.LINUX_LOCAL_GROUP: {
			LinuxLocalGroup linuxLocalGroup = (LinuxLocalGroup) theEObject;
			Object result = caseLinuxLocalGroup(linuxLocalGroup);
			if (result == null)
				result = caseUserGroup(linuxLocalGroup);
			if (result == null)
				result = caseCapability(linuxLocalGroup);
			if (result == null)
				result = caseDeployModelObject(linuxLocalGroup);
			if (result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case OsPackage.LINUX_LOCAL_GROUP_UNIT: {
			LinuxLocalGroupUnit linuxLocalGroupUnit = (LinuxLocalGroupUnit) theEObject;
			Object result = caseLinuxLocalGroupUnit(linuxLocalGroupUnit);
			if (result == null)
				result = caseUserGroupUnit(linuxLocalGroupUnit);
			if (result == null)
				result = caseUnit(linuxLocalGroupUnit);
			if (result == null)
				result = caseDeployModelObject(linuxLocalGroupUnit);
			if (result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case OsPackage.LINUX_LOCAL_SERVICE: {
			LinuxLocalService linuxLocalService = (LinuxLocalService) theEObject;
			Object result = caseLinuxLocalService(linuxLocalService);
			if (result == null)
				result = caseCapability(linuxLocalService);
			if (result == null)
				result = caseDeployModelObject(linuxLocalService);
			if (result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case OsPackage.LINUX_LOCAL_SERVICE_UNIT: {
			LinuxLocalServiceUnit linuxLocalServiceUnit = (LinuxLocalServiceUnit) theEObject;
			Object result = caseLinuxLocalServiceUnit(linuxLocalServiceUnit);
			if (result == null)
				result = caseUnit(linuxLocalServiceUnit);
			if (result == null)
				result = caseDeployModelObject(linuxLocalServiceUnit);
			if (result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case OsPackage.LINUX_LOCAL_USER: {
			LinuxLocalUser linuxLocalUser = (LinuxLocalUser) theEObject;
			Object result = caseLinuxLocalUser(linuxLocalUser);
			if (result == null)
				result = caseUser(linuxLocalUser);
			if (result == null)
				result = caseCapability(linuxLocalUser);
			if (result == null)
				result = caseDeployModelObject(linuxLocalUser);
			if (result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case OsPackage.LINUX_LOCAL_USER_UNIT: {
			LinuxLocalUserUnit linuxLocalUserUnit = (LinuxLocalUserUnit) theEObject;
			Object result = caseLinuxLocalUserUnit(linuxLocalUserUnit);
			if (result == null)
				result = caseUserUnit(linuxLocalUserUnit);
			if (result == null)
				result = caseUnit(linuxLocalUserUnit);
			if (result == null)
				result = caseDeployModelObject(linuxLocalUserUnit);
			if (result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case OsPackage.LINUX_OPERATING_SYSTEM: {
			LinuxOperatingSystem linuxOperatingSystem = (LinuxOperatingSystem) theEObject;
			Object result = caseLinuxOperatingSystem(linuxOperatingSystem);
			if (result == null)
				result = caseOperatingSystem(linuxOperatingSystem);
			if (result == null)
				result = caseCapability(linuxOperatingSystem);
			if (result == null)
				result = caseDeployModelObject(linuxOperatingSystem);
			if (result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case OsPackage.LINUX_OPERATING_SYSTEM_UNIT: {
			LinuxOperatingSystemUnit linuxOperatingSystemUnit = (LinuxOperatingSystemUnit) theEObject;
			Object result = caseLinuxOperatingSystemUnit(linuxOperatingSystemUnit);
			if (result == null)
				result = caseOperatingSystemUnit(linuxOperatingSystemUnit);
			if (result == null)
				result = caseUnit(linuxOperatingSystemUnit);
			if (result == null)
				result = caseDeployModelObject(linuxOperatingSystemUnit);
			if (result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case OsPackage.LOCAL_FILE_SYSTEM: {
			LocalFileSystem localFileSystem = (LocalFileSystem) theEObject;
			Object result = caseLocalFileSystem(localFileSystem);
			if (result == null)
				result = caseFileSystem(localFileSystem);
			if (result == null)
				result = caseCapability(localFileSystem);
			if (result == null)
				result = caseDeployModelObject(localFileSystem);
			if (result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case OsPackage.LOCAL_FILE_SYSTEM_UNIT: {
			LocalFileSystemUnit localFileSystemUnit = (LocalFileSystemUnit) theEObject;
			Object result = caseLocalFileSystemUnit(localFileSystemUnit);
			if (result == null)
				result = caseFileSystemUnit(localFileSystemUnit);
			if (result == null)
				result = caseUnit(localFileSystemUnit);
			if (result == null)
				result = caseDeployModelObject(localFileSystemUnit);
			if (result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case OsPackage.NFS_FILE_SYSTEM: {
			NFSFileSystem nfsFileSystem = (NFSFileSystem) theEObject;
			Object result = caseNFSFileSystem(nfsFileSystem);
			if (result == null)
				result = caseRemoteFileSystem(nfsFileSystem);
			if (result == null)
				result = caseFileSystem(nfsFileSystem);
			if (result == null)
				result = caseCapability(nfsFileSystem);
			if (result == null)
				result = caseDeployModelObject(nfsFileSystem);
			if (result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case OsPackage.NFS_FILE_SYSTEM_UNIT: {
			NFSFileSystemUnit nfsFileSystemUnit = (NFSFileSystemUnit) theEObject;
			Object result = caseNFSFileSystemUnit(nfsFileSystemUnit);
			if (result == null)
				result = caseRemoteFileSystemUnit(nfsFileSystemUnit);
			if (result == null)
				result = caseFileSystemUnit(nfsFileSystemUnit);
			if (result == null)
				result = caseUnit(nfsFileSystemUnit);
			if (result == null)
				result = caseDeployModelObject(nfsFileSystemUnit);
			if (result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case OsPackage.OPEN_VMS_FILE_SYSTEM: {
			OpenVmsFileSystem openVmsFileSystem = (OpenVmsFileSystem) theEObject;
			Object result = caseOpenVmsFileSystem(openVmsFileSystem);
			if (result == null)
				result = caseLocalFileSystem(openVmsFileSystem);
			if (result == null)
				result = caseFileSystem(openVmsFileSystem);
			if (result == null)
				result = caseCapability(openVmsFileSystem);
			if (result == null)
				result = caseDeployModelObject(openVmsFileSystem);
			if (result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case OsPackage.OPEN_VMS_FILE_SYSTEM_UNIT: {
			OpenVmsFileSystemUnit openVmsFileSystemUnit = (OpenVmsFileSystemUnit) theEObject;
			Object result = caseOpenVmsFileSystemUnit(openVmsFileSystemUnit);
			if (result == null)
				result = caseLocalFileSystemUnit(openVmsFileSystemUnit);
			if (result == null)
				result = caseFileSystemUnit(openVmsFileSystemUnit);
			if (result == null)
				result = caseUnit(openVmsFileSystemUnit);
			if (result == null)
				result = caseDeployModelObject(openVmsFileSystemUnit);
			if (result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case OsPackage.OPERATING_SYSTEM: {
			OperatingSystem operatingSystem = (OperatingSystem) theEObject;
			Object result = caseOperatingSystem(operatingSystem);
			if (result == null)
				result = caseCapability(operatingSystem);
			if (result == null)
				result = caseDeployModelObject(operatingSystem);
			if (result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case OsPackage.OPERATING_SYSTEM_ROOT: {
			OperatingSystemRoot operatingSystemRoot = (OperatingSystemRoot) theEObject;
			Object result = caseOperatingSystemRoot(operatingSystemRoot);
			if (result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case OsPackage.OPERATING_SYSTEM_UNIT: {
			OperatingSystemUnit operatingSystemUnit = (OperatingSystemUnit) theEObject;
			Object result = caseOperatingSystemUnit(operatingSystemUnit);
			if (result == null)
				result = caseUnit(operatingSystemUnit);
			if (result == null)
				result = caseDeployModelObject(operatingSystemUnit);
			if (result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case OsPackage.PORT: {
			Port port = (Port) theEObject;
			Object result = casePort(port);
			if (result == null)
				result = caseCapability(port);
			if (result == null)
				result = caseDeployModelObject(port);
			if (result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case OsPackage.PORT_CONFIG_UNIT: {
			PortConfigUnit portConfigUnit = (PortConfigUnit) theEObject;
			Object result = casePortConfigUnit(portConfigUnit);
			if (result == null)
				result = caseUnit(portConfigUnit);
			if (result == null)
				result = caseDeployModelObject(portConfigUnit);
			if (result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case OsPackage.PORT_CONSUMER: {
			PortConsumer portConsumer = (PortConsumer) theEObject;
			Object result = casePortConsumer(portConsumer);
			if (result == null)
				result = caseCapability(portConsumer);
			if (result == null)
				result = caseDeployModelObject(portConsumer);
			if (result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case OsPackage.REDHAT_LINUX_LOCAL_GROUP: {
			RedhatLinuxLocalGroup redhatLinuxLocalGroup = (RedhatLinuxLocalGroup) theEObject;
			Object result = caseRedhatLinuxLocalGroup(redhatLinuxLocalGroup);
			if (result == null)
				result = caseLinuxLocalGroup(redhatLinuxLocalGroup);
			if (result == null)
				result = caseUserGroup(redhatLinuxLocalGroup);
			if (result == null)
				result = caseCapability(redhatLinuxLocalGroup);
			if (result == null)
				result = caseDeployModelObject(redhatLinuxLocalGroup);
			if (result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case OsPackage.REDHAT_LINUX_LOCAL_SERVICE: {
			RedhatLinuxLocalService redhatLinuxLocalService = (RedhatLinuxLocalService) theEObject;
			Object result = caseRedhatLinuxLocalService(redhatLinuxLocalService);
			if (result == null)
				result = caseLinuxLocalService(redhatLinuxLocalService);
			if (result == null)
				result = caseCapability(redhatLinuxLocalService);
			if (result == null)
				result = caseDeployModelObject(redhatLinuxLocalService);
			if (result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case OsPackage.REDHAT_LINUX_LOCAL_USER: {
			RedhatLinuxLocalUser redhatLinuxLocalUser = (RedhatLinuxLocalUser) theEObject;
			Object result = caseRedhatLinuxLocalUser(redhatLinuxLocalUser);
			if (result == null)
				result = caseLinuxLocalUser(redhatLinuxLocalUser);
			if (result == null)
				result = caseUser(redhatLinuxLocalUser);
			if (result == null)
				result = caseCapability(redhatLinuxLocalUser);
			if (result == null)
				result = caseDeployModelObject(redhatLinuxLocalUser);
			if (result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case OsPackage.REDHAT_LINUX_OPERATING_SYSTEM: {
			RedhatLinuxOperatingSystem redhatLinuxOperatingSystem = (RedhatLinuxOperatingSystem) theEObject;
			Object result = caseRedhatLinuxOperatingSystem(redhatLinuxOperatingSystem);
			if (result == null)
				result = caseLinuxOperatingSystem(redhatLinuxOperatingSystem);
			if (result == null)
				result = caseOperatingSystem(redhatLinuxOperatingSystem);
			if (result == null)
				result = caseCapability(redhatLinuxOperatingSystem);
			if (result == null)
				result = caseDeployModelObject(redhatLinuxOperatingSystem);
			if (result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case OsPackage.REMOTE_FILE_SYSTEM: {
			RemoteFileSystem remoteFileSystem = (RemoteFileSystem) theEObject;
			Object result = caseRemoteFileSystem(remoteFileSystem);
			if (result == null)
				result = caseFileSystem(remoteFileSystem);
			if (result == null)
				result = caseCapability(remoteFileSystem);
			if (result == null)
				result = caseDeployModelObject(remoteFileSystem);
			if (result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case OsPackage.REMOTE_FILE_SYSTEM_UNIT: {
			RemoteFileSystemUnit remoteFileSystemUnit = (RemoteFileSystemUnit) theEObject;
			Object result = caseRemoteFileSystemUnit(remoteFileSystemUnit);
			if (result == null)
				result = caseFileSystemUnit(remoteFileSystemUnit);
			if (result == null)
				result = caseUnit(remoteFileSystemUnit);
			if (result == null)
				result = caseDeployModelObject(remoteFileSystemUnit);
			if (result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case OsPackage.SMB_FILE_SYSTEM: {
			SMBFileSystem smbFileSystem = (SMBFileSystem) theEObject;
			Object result = caseSMBFileSystem(smbFileSystem);
			if (result == null)
				result = caseRemoteFileSystem(smbFileSystem);
			if (result == null)
				result = caseFileSystem(smbFileSystem);
			if (result == null)
				result = caseCapability(smbFileSystem);
			if (result == null)
				result = caseDeployModelObject(smbFileSystem);
			if (result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case OsPackage.SMB_FILE_SYSTEM_UNIT: {
			SMBFileSystemUnit smbFileSystemUnit = (SMBFileSystemUnit) theEObject;
			Object result = caseSMBFileSystemUnit(smbFileSystemUnit);
			if (result == null)
				result = caseRemoteFileSystemUnit(smbFileSystemUnit);
			if (result == null)
				result = caseFileSystemUnit(smbFileSystemUnit);
			if (result == null)
				result = caseUnit(smbFileSystemUnit);
			if (result == null)
				result = caseDeployModelObject(smbFileSystemUnit);
			if (result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case OsPackage.SOLARIS_FILE_SYSTEM: {
			SolarisFileSystem solarisFileSystem = (SolarisFileSystem) theEObject;
			Object result = caseSolarisFileSystem(solarisFileSystem);
			if (result == null)
				result = caseUnixFileSystem(solarisFileSystem);
			if (result == null)
				result = caseLocalFileSystem(solarisFileSystem);
			if (result == null)
				result = caseFileSystem(solarisFileSystem);
			if (result == null)
				result = caseCapability(solarisFileSystem);
			if (result == null)
				result = caseDeployModelObject(solarisFileSystem);
			if (result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case OsPackage.SOLARIS_FILE_SYSTEM_UNIT: {
			SolarisFileSystemUnit solarisFileSystemUnit = (SolarisFileSystemUnit) theEObject;
			Object result = caseSolarisFileSystemUnit(solarisFileSystemUnit);
			if (result == null)
				result = caseUnixFileSystemUnit(solarisFileSystemUnit);
			if (result == null)
				result = caseLocalFileSystemUnit(solarisFileSystemUnit);
			if (result == null)
				result = caseFileSystemUnit(solarisFileSystemUnit);
			if (result == null)
				result = caseUnit(solarisFileSystemUnit);
			if (result == null)
				result = caseDeployModelObject(solarisFileSystemUnit);
			if (result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case OsPackage.SUSE_LINUX_LOCAL_GROUP: {
			SUSELinuxLocalGroup suseLinuxLocalGroup = (SUSELinuxLocalGroup) theEObject;
			Object result = caseSUSELinuxLocalGroup(suseLinuxLocalGroup);
			if (result == null)
				result = caseLinuxLocalGroup(suseLinuxLocalGroup);
			if (result == null)
				result = caseUserGroup(suseLinuxLocalGroup);
			if (result == null)
				result = caseCapability(suseLinuxLocalGroup);
			if (result == null)
				result = caseDeployModelObject(suseLinuxLocalGroup);
			if (result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case OsPackage.SUSE_LINUX_LOCAL_SERVICE: {
			SUSELinuxLocalService suseLinuxLocalService = (SUSELinuxLocalService) theEObject;
			Object result = caseSUSELinuxLocalService(suseLinuxLocalService);
			if (result == null)
				result = caseLinuxLocalService(suseLinuxLocalService);
			if (result == null)
				result = caseCapability(suseLinuxLocalService);
			if (result == null)
				result = caseDeployModelObject(suseLinuxLocalService);
			if (result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case OsPackage.SUSE_LINUX_LOCAL_USER: {
			SUSELinuxLocalUser suseLinuxLocalUser = (SUSELinuxLocalUser) theEObject;
			Object result = caseSUSELinuxLocalUser(suseLinuxLocalUser);
			if (result == null)
				result = caseLinuxLocalUser(suseLinuxLocalUser);
			if (result == null)
				result = caseUser(suseLinuxLocalUser);
			if (result == null)
				result = caseCapability(suseLinuxLocalUser);
			if (result == null)
				result = caseDeployModelObject(suseLinuxLocalUser);
			if (result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case OsPackage.SUSE_LINUX_OPERATING_SYSTEM: {
			SUSELinuxOperatingSystem suseLinuxOperatingSystem = (SUSELinuxOperatingSystem) theEObject;
			Object result = caseSUSELinuxOperatingSystem(suseLinuxOperatingSystem);
			if (result == null)
				result = caseLinuxOperatingSystem(suseLinuxOperatingSystem);
			if (result == null)
				result = caseOperatingSystem(suseLinuxOperatingSystem);
			if (result == null)
				result = caseCapability(suseLinuxOperatingSystem);
			if (result == null)
				result = caseDeployModelObject(suseLinuxOperatingSystem);
			if (result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case OsPackage.UNIX_DIRECTORY: {
			UnixDirectory unixDirectory = (UnixDirectory) theEObject;
			Object result = caseUnixDirectory(unixDirectory);
			if (result == null)
				result = caseDirectory(unixDirectory);
			if (result == null)
				result = caseFileSystemContent(unixDirectory);
			if (result == null)
				result = caseCapability(unixDirectory);
			if (result == null)
				result = caseDeployModelObject(unixDirectory);
			if (result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case OsPackage.UNIX_FILE_SYSTEM: {
			UnixFileSystem unixFileSystem = (UnixFileSystem) theEObject;
			Object result = caseUnixFileSystem(unixFileSystem);
			if (result == null)
				result = caseLocalFileSystem(unixFileSystem);
			if (result == null)
				result = caseFileSystem(unixFileSystem);
			if (result == null)
				result = caseCapability(unixFileSystem);
			if (result == null)
				result = caseDeployModelObject(unixFileSystem);
			if (result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case OsPackage.UNIX_FILE_SYSTEM_UNIT: {
			UnixFileSystemUnit unixFileSystemUnit = (UnixFileSystemUnit) theEObject;
			Object result = caseUnixFileSystemUnit(unixFileSystemUnit);
			if (result == null)
				result = caseLocalFileSystemUnit(unixFileSystemUnit);
			if (result == null)
				result = caseFileSystemUnit(unixFileSystemUnit);
			if (result == null)
				result = caseUnit(unixFileSystemUnit);
			if (result == null)
				result = caseDeployModelObject(unixFileSystemUnit);
			if (result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case OsPackage.USER: {
			User user = (User) theEObject;
			Object result = caseUser(user);
			if (result == null)
				result = caseCapability(user);
			if (result == null)
				result = caseDeployModelObject(user);
			if (result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case OsPackage.USER_GROUP: {
			UserGroup userGroup = (UserGroup) theEObject;
			Object result = caseUserGroup(userGroup);
			if (result == null)
				result = caseCapability(userGroup);
			if (result == null)
				result = caseDeployModelObject(userGroup);
			if (result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case OsPackage.USER_GROUP_UNIT: {
			UserGroupUnit userGroupUnit = (UserGroupUnit) theEObject;
			Object result = caseUserGroupUnit(userGroupUnit);
			if (result == null)
				result = caseUnit(userGroupUnit);
			if (result == null)
				result = caseDeployModelObject(userGroupUnit);
			if (result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case OsPackage.USER_UNIT: {
			UserUnit userUnit = (UserUnit) theEObject;
			Object result = caseUserUnit(userUnit);
			if (result == null)
				result = caseUnit(userUnit);
			if (result == null)
				result = caseDeployModelObject(userUnit);
			if (result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case OsPackage.WINDOWS_DIRECTORY: {
			WindowsDirectory windowsDirectory = (WindowsDirectory) theEObject;
			Object result = caseWindowsDirectory(windowsDirectory);
			if (result == null)
				result = caseDirectory(windowsDirectory);
			if (result == null)
				result = caseFileSystemContent(windowsDirectory);
			if (result == null)
				result = caseCapability(windowsDirectory);
			if (result == null)
				result = caseDeployModelObject(windowsDirectory);
			if (result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case OsPackage.WINDOWS_FILE_SYSTEM: {
			WindowsFileSystem windowsFileSystem = (WindowsFileSystem) theEObject;
			Object result = caseWindowsFileSystem(windowsFileSystem);
			if (result == null)
				result = caseLocalFileSystem(windowsFileSystem);
			if (result == null)
				result = caseFileSystem(windowsFileSystem);
			if (result == null)
				result = caseCapability(windowsFileSystem);
			if (result == null)
				result = caseDeployModelObject(windowsFileSystem);
			if (result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case OsPackage.WINDOWS_FILE_SYSTEM_UNIT: {
			WindowsFileSystemUnit windowsFileSystemUnit = (WindowsFileSystemUnit) theEObject;
			Object result = caseWindowsFileSystemUnit(windowsFileSystemUnit);
			if (result == null)
				result = caseLocalFileSystemUnit(windowsFileSystemUnit);
			if (result == null)
				result = caseFileSystemUnit(windowsFileSystemUnit);
			if (result == null)
				result = caseUnit(windowsFileSystemUnit);
			if (result == null)
				result = caseDeployModelObject(windowsFileSystemUnit);
			if (result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case OsPackage.WINDOWS_LOCAL_GROUP: {
			WindowsLocalGroup windowsLocalGroup = (WindowsLocalGroup) theEObject;
			Object result = caseWindowsLocalGroup(windowsLocalGroup);
			if (result == null)
				result = caseUserGroup(windowsLocalGroup);
			if (result == null)
				result = caseCapability(windowsLocalGroup);
			if (result == null)
				result = caseDeployModelObject(windowsLocalGroup);
			if (result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case OsPackage.WINDOWS_LOCAL_GROUP_UNIT: {
			WindowsLocalGroupUnit windowsLocalGroupUnit = (WindowsLocalGroupUnit) theEObject;
			Object result = caseWindowsLocalGroupUnit(windowsLocalGroupUnit);
			if (result == null)
				result = caseUserGroupUnit(windowsLocalGroupUnit);
			if (result == null)
				result = caseUnit(windowsLocalGroupUnit);
			if (result == null)
				result = caseDeployModelObject(windowsLocalGroupUnit);
			if (result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case OsPackage.WINDOWS_LOCAL_SERVICE: {
			WindowsLocalService windowsLocalService = (WindowsLocalService) theEObject;
			Object result = caseWindowsLocalService(windowsLocalService);
			if (result == null)
				result = caseCapability(windowsLocalService);
			if (result == null)
				result = caseDeployModelObject(windowsLocalService);
			if (result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case OsPackage.WINDOWS_LOCAL_SERVICE_UNIT: {
			WindowsLocalServiceUnit windowsLocalServiceUnit = (WindowsLocalServiceUnit) theEObject;
			Object result = caseWindowsLocalServiceUnit(windowsLocalServiceUnit);
			if (result == null)
				result = caseUnit(windowsLocalServiceUnit);
			if (result == null)
				result = caseDeployModelObject(windowsLocalServiceUnit);
			if (result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case OsPackage.WINDOWS_LOCAL_USER: {
			WindowsLocalUser windowsLocalUser = (WindowsLocalUser) theEObject;
			Object result = caseWindowsLocalUser(windowsLocalUser);
			if (result == null)
				result = caseUser(windowsLocalUser);
			if (result == null)
				result = caseCapability(windowsLocalUser);
			if (result == null)
				result = caseDeployModelObject(windowsLocalUser);
			if (result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case OsPackage.WINDOWS_LOCAL_USER_UNIT: {
			WindowsLocalUserUnit windowsLocalUserUnit = (WindowsLocalUserUnit) theEObject;
			Object result = caseWindowsLocalUserUnit(windowsLocalUserUnit);
			if (result == null)
				result = caseUserUnit(windowsLocalUserUnit);
			if (result == null)
				result = caseUnit(windowsLocalUserUnit);
			if (result == null)
				result = caseDeployModelObject(windowsLocalUserUnit);
			if (result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case OsPackage.WINDOWS_OPERATING_SYSTEM: {
			WindowsOperatingSystem windowsOperatingSystem = (WindowsOperatingSystem) theEObject;
			Object result = caseWindowsOperatingSystem(windowsOperatingSystem);
			if (result == null)
				result = caseOperatingSystem(windowsOperatingSystem);
			if (result == null)
				result = caseCapability(windowsOperatingSystem);
			if (result == null)
				result = caseDeployModelObject(windowsOperatingSystem);
			if (result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case OsPackage.WINDOWS_OPERATING_SYSTEM_UNIT: {
			WindowsOperatingSystemUnit windowsOperatingSystemUnit = (WindowsOperatingSystemUnit) theEObject;
			Object result = caseWindowsOperatingSystemUnit(windowsOperatingSystemUnit);
			if (result == null)
				result = caseOperatingSystemUnit(windowsOperatingSystemUnit);
			if (result == null)
				result = caseUnit(windowsOperatingSystemUnit);
			if (result == null)
				result = caseDeployModelObject(windowsOperatingSystemUnit);
			if (result == null)
				result = defaultCase(theEObject);
			return result;
		}
		default:
			return defaultCase(theEObject);
		}
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>AIX Local Group</em>'.
	 * <!-- begin-user-doc --> This implementation returns null; returning a non-null result will
	 * terminate the switch. <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>AIX Local Group</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public Object caseAIXLocalGroup(AIXLocalGroup object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>AIX Local Group Unit</em>'.
	 * <!-- begin-user-doc --> This implementation returns null; returning a non-null result will
	 * terminate the switch. <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>AIX Local Group Unit</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public Object caseAIXLocalGroupUnit(AIXLocalGroupUnit object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>AIX Local Service</em>'.
	 * <!-- begin-user-doc --> This implementation returns null; returning a non-null result will
	 * terminate the switch. <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>AIX Local Service</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public Object caseAIXLocalService(AIXLocalService object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>AIX Local Service Unit</em>'.
	 * <!-- begin-user-doc --> This implementation returns null; returning a non-null result will
	 * terminate the switch. <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>AIX Local Service Unit</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public Object caseAIXLocalServiceUnit(AIXLocalServiceUnit object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>AIX Local User</em>'.
	 * <!-- begin-user-doc --> This implementation returns null; returning a non-null result will
	 * terminate the switch. <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>AIX Local User</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public Object caseAIXLocalUser(AIXLocalUser object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>AIX Local User Unit</em>'.
	 * <!-- begin-user-doc --> This implementation returns null; returning a non-null result will
	 * terminate the switch. <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>AIX Local User Unit</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public Object caseAIXLocalUserUnit(AIXLocalUserUnit object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>AIX Operating System</em>'.
	 * <!-- begin-user-doc --> This implementation returns null; returning a non-null result will
	 * terminate the switch. <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>AIX Operating System</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public Object caseAIXOperatingSystem(AIXOperatingSystem object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>AIX Operating System Unit</em>'.
	 * <!-- begin-user-doc --> This implementation returns null; returning a non-null result will
	 * terminate the switch. <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>AIX Operating System Unit</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public Object caseAIXOperatingSystemUnit(AIXOperatingSystemUnit object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Data File</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Data File</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public Object caseDataFile(DataFile object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Data File Unit</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Data File Unit</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public Object caseDataFileUnit(DataFileUnit object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Directory</em>'.
	 * <!-- begin-user-doc --> This implementation returns null; returning a non-null result will
	 * terminate the switch. <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Directory</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public Object caseDirectory(Directory object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Directory Unit</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Directory Unit</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public Object caseDirectoryUnit(DirectoryUnit object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>File System</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>File System</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public Object caseFileSystem(FileSystem object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>File System Content</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>File System Content</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public Object caseFileSystemContent(FileSystemContent object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>File System Content Unit</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>File System Content Unit</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public Object caseFileSystemContentUnit(FileSystemContentUnit object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>File System Unit</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>File System Unit</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public Object caseFileSystemUnit(FileSystemUnit object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Linux Local Group</em>'.
	 * <!-- begin-user-doc --> This implementation returns null; returning a non-null result will
	 * terminate the switch. <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Linux Local Group</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public Object caseLinuxLocalGroup(LinuxLocalGroup object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Linux Local Group Unit</em>'.
	 * <!-- begin-user-doc --> This implementation returns null; returning a non-null result will
	 * terminate the switch. <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Linux Local Group Unit</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public Object caseLinuxLocalGroupUnit(LinuxLocalGroupUnit object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Linux Local Service</em>'.
	 * <!-- begin-user-doc --> This implementation returns null; returning a non-null result will
	 * terminate the switch. <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Linux Local Service</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public Object caseLinuxLocalService(LinuxLocalService object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Linux Local Service Unit</em>'.
	 * <!-- begin-user-doc --> This implementation returns null; returning a non-null result will
	 * terminate the switch. <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Linux Local Service Unit</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public Object caseLinuxLocalServiceUnit(LinuxLocalServiceUnit object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Linux Local User</em>'.
	 * <!-- begin-user-doc --> This implementation returns null; returning a non-null result will
	 * terminate the switch. <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Linux Local User</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public Object caseLinuxLocalUser(LinuxLocalUser object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Linux Local User Unit</em>'.
	 * <!-- begin-user-doc --> This implementation returns null; returning a non-null result will
	 * terminate the switch. <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Linux Local User Unit</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public Object caseLinuxLocalUserUnit(LinuxLocalUserUnit object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Linux Operating System</em>'.
	 * <!-- begin-user-doc --> This implementation returns null; returning a non-null result will
	 * terminate the switch. <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Linux Operating System</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public Object caseLinuxOperatingSystem(LinuxOperatingSystem object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Linux Operating System Unit</em>'.
	 * <!-- begin-user-doc --> This implementation returns null; returning a non-null result will
	 * terminate the switch. <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Linux Operating System Unit</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public Object caseLinuxOperatingSystemUnit(LinuxOperatingSystemUnit object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Local File System</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Local File System</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public Object caseLocalFileSystem(LocalFileSystem object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Local File System Unit</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Local File System Unit</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public Object caseLocalFileSystemUnit(LocalFileSystemUnit object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>NFS File System</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>NFS File System</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public Object caseNFSFileSystem(NFSFileSystem object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>NFS File System Unit</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>NFS File System Unit</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public Object caseNFSFileSystemUnit(NFSFileSystemUnit object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Open Vms File System</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Open Vms File System</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public Object caseOpenVmsFileSystem(OpenVmsFileSystem object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Open Vms File System Unit</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Open Vms File System Unit</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public Object caseOpenVmsFileSystemUnit(OpenVmsFileSystemUnit object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Operating System</em>'.
	 * <!-- begin-user-doc --> This implementation returns null; returning a non-null result will
	 * terminate the switch. <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Operating System</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public Object caseOperatingSystem(OperatingSystem object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Operating System Root</em>'.
	 * <!-- begin-user-doc --> This implementation returns null; returning a non-null result will
	 * terminate the switch. <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Operating System Root</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public Object caseOperatingSystemRoot(OperatingSystemRoot object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Operating System Unit</em>'.
	 * <!-- begin-user-doc --> This implementation returns null; returning a non-null result will
	 * terminate the switch. <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Operating System Unit</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public Object caseOperatingSystemUnit(OperatingSystemUnit object) {
		return null;
	}

	/**
	 * Returns the result of interpretting the object as an instance of '<em>Port</em>'. <!--
	 * begin-user-doc --> This implementation returns null; returning a non-null result will
	 * terminate the switch. <!-- end-user-doc -->
	 * 
	 * @param object
	 *           the target of the switch.
	 * @return the result of interpretting the object as an instance of '<em>Port</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public Object casePort(Port object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Port Config Unit</em>'.
	 * <!-- begin-user-doc --> This implementation returns null; returning a non-null result will
	 * terminate the switch. <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Port Config Unit</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public Object casePortConfigUnit(PortConfigUnit object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Port Consumer</em>'.
	 * <!-- begin-user-doc --> This implementation returns null; returning a non-null result will
	 * terminate the switch. <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Port Consumer</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public Object casePortConsumer(PortConsumer object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Redhat Linux Local Group</em>'.
	 * <!-- begin-user-doc --> This implementation returns null; returning a non-null result will
	 * terminate the switch. <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Redhat Linux Local Group</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public Object caseRedhatLinuxLocalGroup(RedhatLinuxLocalGroup object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Redhat Linux Local Service</em>'.
	 * <!-- begin-user-doc --> This implementation returns null; returning a non-null result will
	 * terminate the switch. <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Redhat Linux Local Service</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public Object caseRedhatLinuxLocalService(RedhatLinuxLocalService object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Redhat Linux Local User</em>'.
	 * <!-- begin-user-doc --> This implementation returns null; returning a non-null result will
	 * terminate the switch. <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Redhat Linux Local User</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public Object caseRedhatLinuxLocalUser(RedhatLinuxLocalUser object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Redhat Linux Operating System</em>'.
	 * <!-- begin-user-doc --> This implementation returns null; returning a non-null result will
	 * terminate the switch. <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Redhat Linux Operating System</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public Object caseRedhatLinuxOperatingSystem(RedhatLinuxOperatingSystem object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Remote File System</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Remote File System</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public Object caseRemoteFileSystem(RemoteFileSystem object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Remote File System Unit</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Remote File System Unit</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public Object caseRemoteFileSystemUnit(RemoteFileSystemUnit object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>SMB File System</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>SMB File System</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public Object caseSMBFileSystem(SMBFileSystem object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>SMB File System Unit</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>SMB File System Unit</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public Object caseSMBFileSystemUnit(SMBFileSystemUnit object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Solaris File System</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Solaris File System</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public Object caseSolarisFileSystem(SolarisFileSystem object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Solaris File System Unit</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Solaris File System Unit</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public Object caseSolarisFileSystemUnit(SolarisFileSystemUnit object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>SUSE Linux Local Group</em>'.
	 * <!-- begin-user-doc --> This implementation returns null; returning a non-null result will
	 * terminate the switch. <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>SUSE Linux Local Group</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public Object caseSUSELinuxLocalGroup(SUSELinuxLocalGroup object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>SUSE Linux Local Service</em>'.
	 * <!-- begin-user-doc --> This implementation returns null; returning a non-null result will
	 * terminate the switch. <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>SUSE Linux Local Service</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public Object caseSUSELinuxLocalService(SUSELinuxLocalService object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>SUSE Linux Local User</em>'.
	 * <!-- begin-user-doc --> This implementation returns null; returning a non-null result will
	 * terminate the switch. <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>SUSE Linux Local User</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public Object caseSUSELinuxLocalUser(SUSELinuxLocalUser object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>SUSE Linux Operating System</em>'.
	 * <!-- begin-user-doc --> This implementation returns null; returning a non-null result will
	 * terminate the switch. <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>SUSE Linux Operating System</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public Object caseSUSELinuxOperatingSystem(SUSELinuxOperatingSystem object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Unix Directory</em>'.
	 * <!-- begin-user-doc --> This implementation returns null; returning a non-null result will
	 * terminate the switch. <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Unix Directory</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public Object caseUnixDirectory(UnixDirectory object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Unix File System</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Unix File System</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public Object caseUnixFileSystem(UnixFileSystem object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Unix File System Unit</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Unix File System Unit</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public Object caseUnixFileSystemUnit(UnixFileSystemUnit object) {
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
	public Object caseUser(User object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>User Group</em>'.
	 * <!-- begin-user-doc --> This implementation returns null; returning a non-null result will
	 * terminate the switch. <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>User Group</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public Object caseUserGroup(UserGroup object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>User Group Unit</em>'.
	 * <!-- begin-user-doc --> This implementation returns null; returning a non-null result will
	 * terminate the switch. <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>User Group Unit</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public Object caseUserGroupUnit(UserGroupUnit object) {
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
	public Object caseUserUnit(UserUnit object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Windows Directory</em>'.
	 * <!-- begin-user-doc --> This implementation returns null; returning a non-null result will
	 * terminate the switch. <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Windows Directory</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public Object caseWindowsDirectory(WindowsDirectory object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Windows File System</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Windows File System</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public Object caseWindowsFileSystem(WindowsFileSystem object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Windows File System Unit</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Windows File System Unit</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public Object caseWindowsFileSystemUnit(WindowsFileSystemUnit object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Windows Local Group</em>'.
	 * <!-- begin-user-doc --> This implementation returns null; returning a non-null result will
	 * terminate the switch. <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Windows Local Group</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public Object caseWindowsLocalGroup(WindowsLocalGroup object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Windows Local Group Unit</em>'.
	 * <!-- begin-user-doc --> This implementation returns null; returning a non-null result will
	 * terminate the switch. <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Windows Local Group Unit</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public Object caseWindowsLocalGroupUnit(WindowsLocalGroupUnit object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Windows Local Service</em>'.
	 * <!-- begin-user-doc --> This implementation returns null; returning a non-null result will
	 * terminate the switch. <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Windows Local Service</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public Object caseWindowsLocalService(WindowsLocalService object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Windows Local Service Unit</em>'.
	 * <!-- begin-user-doc --> This implementation returns null; returning a non-null result will
	 * terminate the switch. <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Windows Local Service Unit</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public Object caseWindowsLocalServiceUnit(WindowsLocalServiceUnit object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Windows Local User</em>'.
	 * <!-- begin-user-doc --> This implementation returns null; returning a non-null result will
	 * terminate the switch. <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Windows Local User</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public Object caseWindowsLocalUser(WindowsLocalUser object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Windows Local User Unit</em>'.
	 * <!-- begin-user-doc --> This implementation returns null; returning a non-null result will
	 * terminate the switch. <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Windows Local User Unit</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public Object caseWindowsLocalUserUnit(WindowsLocalUserUnit object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Windows Operating System</em>'.
	 * <!-- begin-user-doc --> This implementation returns null; returning a non-null result will
	 * terminate the switch. <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Windows Operating System</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public Object caseWindowsOperatingSystem(WindowsOperatingSystem object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Windows Operating System Unit</em>'.
	 * <!-- begin-user-doc --> This implementation returns null; returning a non-null result will
	 * terminate the switch. <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Windows Operating System Unit</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public Object caseWindowsOperatingSystemUnit(WindowsOperatingSystemUnit object) {
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

} //OsSwitch
