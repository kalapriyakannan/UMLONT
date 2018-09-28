/***************************************************************************************************
 * Copyright (c) 2003, 2007 IBM Corporation Licensed Material - Property of IBM. All rights
 * reserved.
 * 
 * US Government Users Restricted Rights - Use, duplication or disclosure v1.0 restricted by GSA ADP
 * Schedule Contract with IBM Corp.
 * 
 * Contributors: IBM Corporation - initial API and implementation
 **************************************************************************************************/
package com.ibm.ccl.soa.deploy.os;

import com.ibm.ccl.soa.deploy.internal.core.extension.ResourceTypeService;

/**
 * Defines type IDs for the OS domain plugin. These IDs can be used with the
 * {@link ResourceTypeService}.
 */
public interface IOsTemplateConstants {

	// Windows
	public static final String OS_WINDOWS_2000_UNIT = "os.OperatingSystemUnit.W2K.infra"; //$NON-NLS-1$
	public static final String OS_WINDOWS_2000_UNIT_CONCEPTUAL = "os.OperatingSystemUnit.W2K.conceptual"; //$NON-NLS-1$
	public static final String OS_WINDOWS_XP_UNIT = "os.OperatingSystemUnit.WXP.infra"; //$NON-NLS-1$
	public static final String OS_WINDOWS_XP_UNIT_CONCEPTUAL = "os.OperatingSystemUnit.WXP.conceptual"; //$NON-NLS-1$
	public static final String OS_WINDOWS_2003_UNIT = "os.OperatingSystemUnit.WServer2003.infra"; //$NON-NLS-1$
	public static final String OS_WINDOWS_2003_UNIT_CONCEPTUAL = "os.OperatingSystemUnit.WServer2003.conceptual"; //$NON-NLS-1$

	// Linux
	public static final String OS_LINUX_UNIT_CONCEPTUAL = "os.OperatingSystemUnit.Linux.conceptual"; //$NON-NLS-1$
	public static final String OS_REDHAT_4_LINUX_UNIT = "os.OperatingSystemUnit.RedhatAS4Linux.infra"; //$NON-NLS-1$
	public static final String OS_REDHAT_4_LINUX_UNIT_CONCEPTUAL = "os.OperatingSystemUnit.RedhatAS4Linux.conceptual"; //$NON-NLS-1$

	public static final String OS_SUSE_9_UNIT = "os.OperatingSystemUnit.SUSEServer9Linux.infra"; //$NON-NLS-1$
	public static final String OS_SUSE_9_UNIT_CONCEPTUAL = "os.OperatingSystemUnit.SUSEServer9Linux.conceptual"; //$NON-NLS-1$

	// AIX
	public static final String OS_AIX_5L_UNIT = "os.OperatingSystemUnit.AIX5L.infra"; //$NON-NLS-1$	
	public static final String OS_AIX_5L_UNIT_CONCEPTUAL = "os.OperatingSystemUnit.AIX5L.conceptual"; //$NON-NLS-1$

	public static final String OS_WINDOWS_LOCAL_USER_UNIT = "os.WindowsLocalUserUnit.infra"; //$NON-NLS-1$
	public static final String OS_REDHAT_LOCAL_USER_UNIT = "os.RedhatLinuxLocalUserUnit.infra"; //$NON-NLS-1$
	public static final String OS_SUSE_LOCAL_USER_UNIT = "os.SUSELinuxLocalUserUnit.infra"; //$NON-NLS-1$
	public static final String OS_USER_UNIT = "os.UserUnit.infra"; //$NON-NLS-1$
	public static final String OS_AIX_LOCAL_USER_UNIT = "os.AIXLocalUserUnit.infra"; //$NON-NLS-1$

	public static final String OS_WINDOWS_LOCAL_GROUP_UNIT = "os.WindowsLocalGroupUnit.infra"; //$NON-NLS-1$
	public static final String OS_REDHAT_LOCAL_GROUP_UNIT = "os.RedhatLinuxLocalGroupUnit.infra"; //$NON-NLS-1$
	public static final String OS_SUSE_LOCAL_GROUP_UNIT = "os.SUSELinuxLocalGroupUnit.infra"; //$NON-NLS-1$
	public static final String OS_AIX_LOCAL_GROUP_UNIT = "os.AIXLocalGroupUnit.infra"; //$NON-NLS-1$

	public static final String OS_PORT_CONFIG_UNIT = "os.PortConfigUnit.infra"; //$NON-NLS-1$

	// Generic conceptual
	public static final String OS_UNIT_CONCEPTUAL = "os.OperatingSystemUnit.conceptual"; //$NON-NLS-1$
	public static final String OS_USER_CONCEPTUAL = "os.localUserUnit.conceptual"; //$NON-NLS-1$
	public static final String OS_USER_GROUP_UNIT_CONCEPTUAL = "os.UserGroupUnit.conceptual"; //$NON-NLS-1$

	// FileSystem and related
	public static final String OS_FILE_SYSTEM_UNIT = "os.FileSystemUnit.infra"; //$NON-NLS-1$
	public static final String OS_LOCAL_FILE_SYSTEM_UNIT = "os.LocalFileSystemUnit.infra"; //$NON-NLS-1$
	public static final String OS_REMOTE_FILE_SYSTEM_UNIT = "os.RemoteFileSystemUnit.infra"; //$NON-NLS-1$
	public static final String OS_SMB_FILE_SYSTEM_UNIT = "os.SMBFileSystemUnit.infra"; //$NON-NLS-1$
	public static final String OS_NFS_FILE_SYSTEM_UNIT = "os.NFSFileSystemUnit.infra"; //$NON-NLS-1$
	public static final String OS_UNIX_FILE_SYSTEM_UNIT = "os.UnixFileSystemUnit.infra"; //$NON-NLS-1$
	public static final String OS_OPEN_VMS_FILE_SYSTEM_UNIT = "os.OpenVmsFileSystemUnit.infra"; //$NON-NLS-1$
	public static final String OS_WINDOWS_FILE_SYSTEM_UNIT = "os.WindowsFileSystemUnit.infra"; //$NON-NLS-1$
	public static final String OS_SOLARIS_FILE_SYSTEM_UNIT = "os.SolarisFileSystemUnit.infra"; //$NON-NLS-1$
	public static final String OS_DIRECTORY_UNIT = "os.DirectoryUnit.infra"; //$NON-NLS-1$
	public static final String OS_DATA_FILE_UNIT = "os.DataFileUnit.infra"; //$NON-NLS-1$
}
