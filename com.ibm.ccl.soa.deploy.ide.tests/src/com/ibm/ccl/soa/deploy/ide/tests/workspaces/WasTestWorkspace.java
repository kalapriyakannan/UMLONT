/*******************************************************************************
 * Copyright (c) 2003, 2007 IBM Corporation Licensed Material - Property of IBM. All rights reserved.
 *  
 * US Government Users Restricted Rights - Use, duplication or disclosure v1.0 restricted by GSA ADP
 * Schedule Contract with IBM Corp.
 * 
 * Contributors: IBM Corporation - initial API and implementation
 *******************************************************************************/
package com.ibm.ccl.soa.deploy.ide.tests.workspaces;

import java.io.IOException;
import java.net.URL;
import java.util.Map;

import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IPath;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.core.runtime.Path;
import org.eclipse.core.runtime.Platform;
import org.eclipse.jst.server.generic.core.internal.GenericServerRuntime;
import org.eclipse.wst.server.core.IRuntime;
import org.eclipse.wst.server.core.IRuntimeType;
import org.eclipse.wst.server.core.IRuntimeWorkingCopy;
import org.eclipse.wst.server.core.ServerCore;

import com.ibm.ccl.soa.deploy.ide.tests.Activator;
import com.ibm.ccl.soa.deploy.tests.util.ProjectUnzipUtil;

public class WasTestWorkspace {

	public static final String USER_PROJECT_NAME = "WasWebProject"; //$NON-NLS-1$

	private static Path wasServerZipLocation = new Path(
			"/testData/WasWebProjectWorkspace.zip"); //$NON-NLS-1$

	public static String websphere60RuntimeID = "IBM WebSphere v6.0"; //$NON-NLS-1$

	public static String moduleType = "jst.web"; //$NON-NLS-1$

	public static String websphere60RuntimeType = "org.eclipse.jst.server.generic.runtime.websphere.6"; //$NON-NLS-1$

	private static IPath rootLocation = ResourcesPlugin.getWorkspace()
			.getRoot().getLocation();

	// ///////////////////////////////////////////////
	// CHANGE ME to your websphere installation ///
	// and JDK install. ///
	// /////////////////////////////////////////////

	private static Path websphereInstallDir = new Path(
			"D:/IBM/WebSphere/AppServer");

	public static final String[] projectNames = new String[] { USER_PROJECT_NAME };

	public static void init() throws IOException {
		try {
			for (int i = 0; i < projectNames.length; i++) {
				String projectName = projectNames[i];
				if (!getProject(projectName).exists()) {
					createProject(projectName);
					createRuntime();
				}
				getProject(projectName).refreshLocal(IResource.DEPTH_INFINITE,
						null);
			}

		} catch (CoreException e) {
			e.printStackTrace();
		}
	}

	public static boolean createProject(String name) {
		return new ProjectUnzipUtil(getPath(wasServerZipLocation),
				new String[] { name }).createProjects();
	}

	public static IPath getPath(IPath path) {
		URL url = Activator.getDefault().find(path);
		try {
			url = Platform.asLocalURL(url);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return new Path(url.getPath());
	}

	public static IProject getProject(String name) {
		return ResourcesPlugin.getWorkspace().getRoot().getProject(name);
	}

	public static Path getWebsphere50ServerLocation() {
		return websphereInstallDir;
	}

	public static void createRuntime() throws IOException, CoreException {
		NullProgressMonitor nullMonitor = new NullProgressMonitor();
		IRuntimeType[] runtimes = ServerCore.getRuntimeTypes();
		IRuntimeType websphereRuntimeType = null;
		for (int i = 0; i < runtimes.length; i++) {
			IRuntimeType type = runtimes[i];
			if (type.getId().equals(websphere60RuntimeType))
				websphereRuntimeType = type;
		}
		if (websphereRuntimeType == null)
			throw new IOException("runtime type not found"); //$NON-NLS-1$
		IRuntimeWorkingCopy copy = websphereRuntimeType.createRuntime(
				websphere60RuntimeID, nullMonitor);
		copy.setLocation(getWebsphere50ServerLocation());
		GenericServerRuntime gRuntime = (GenericServerRuntime) copy
				.loadAdapter(GenericServerRuntime.class, null);
		Map propertyMap = gRuntime.getServerInstanceProperties();
		propertyMap.put("wasHome", getWebsphere50ServerLocation().toOSString());
		gRuntime.setServerInstanceProperties(propertyMap);
		IStatus status = copy.validate(null);
		if (status.isOK()) {
			IRuntime runtime = copy.save(true, nullMonitor);
		} else
			throw new IOException(status.getMessage());

	}

}
