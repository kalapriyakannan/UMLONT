/*******************************************************************************
 * Copyright (c) 2003, 2007 IBM Corporation Licensed Material - Property of IBM. All rights reserved.
 *  
 * US Government Users Restricted Rights - Use, duplication or disclosure v1.0 restricted by GSA ADP
 * Schedule Contract with IBM Corp.
 * 
 * Contributors: IBM Corporation - initial API and implementation
 *******************************************************************************/
package com.ibm.ccl.soa.deploy.ide.util;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IFolder;
import org.eclipse.core.resources.IWorkspaceRoot;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.IPath;

public class IdePublisherUtil {

	private IdePublisherUtil() {
		super();
	}

	public static IFolder getFolderOfPath(IPath fullLocalIPath) {
		final IWorkspaceRoot workspace = ResourcesPlugin.getWorkspace().getRoot();
		final IFolder folder = workspace.getFolder(fullLocalIPath);
		return folder;
	}

	public static IFile getFileOfPath(IPath fullLocalIPath) {
		final IWorkspaceRoot workspace = ResourcesPlugin.getWorkspace().getRoot();
		final IFile file = workspace.getFile(fullLocalIPath);
		return file;
	}

}
