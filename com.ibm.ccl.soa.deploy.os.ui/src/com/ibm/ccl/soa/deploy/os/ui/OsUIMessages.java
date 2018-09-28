/***************************************************************************************************
 * Copyright (c) 2003, 2007 IBM Corporation Licensed Material - Property of IBM. All rights
 * reserved.
 * 
 * US Government Users Restricted Rights - Use, duplication or disclosure v1.0 restricted by GSA ADP
 * Schedule Contract with IBM Corp.
 * 
 * Contributors: IBM Corporation - initial API and implementation
 **************************************************************************************************/
package com.ibm.ccl.soa.deploy.os.ui;

import org.eclipse.osgi.util.NLS;

public class OsUIMessages extends NLS {
	private static final String BUNDLE_NAME = "com.ibm.ccl.soa.deploy.os.ui.Messages"; //$NON-NLS-1$

	public static String PortConfigUnitEditPart_0;

	public static String UserGroupUnitEditPart_LinuxUserGroup;

	public static String UserGroupUnitEditPart_AIXUserGroup;

	public static String UserGroupUnitEditPart_RedhatLinuxUserGroup;

	public static String UserGroupUnitEditPart_SUSELinuxUserGroup;

	public static String UserGroupUnitEditPart_UserGroup;

	public static String UserGroupUnitEditPart_WindowsUserGroup;

	public static String UserUnitEditPart_LinuxUser;

	public static String UserUnitEditPart_AIXUser;

	public static String UserUnitEditPart_RedhatLinuxUser;

	public static String UserUnitEditPart_SUSELinuxUser;

	public static String UserUnitEditPart_User;

	public static String UserUnitEditPart_WindowsUser;

	public static String FileSystemUnitEditPart_FileSystem;

	public static String FileSystemUnitEditPart_LocalFileSystem;

	public static String FileSystemUnitEditPart_NFSFileSystem;

	public static String FileSystemUnitEditPart_OpenVMSFileSystem;

	public static String FileSystemUnitEditPart_RemoteFileSystem;

	public static String FileSystemUnitEditPart_SMBFileSystem;

	public static String FileSystemUnitEditPart_SolarisFileSystem;

	public static String FileSystemUnitEditPart_UnixFileSystem;

	public static String DirectoryUnitEditPart_Directory;

	static {
		// initialize resource bundle
		NLS.initializeMessages(BUNDLE_NAME, OsUIMessages.class);
	}

	private OsUIMessages() {
	}
}
