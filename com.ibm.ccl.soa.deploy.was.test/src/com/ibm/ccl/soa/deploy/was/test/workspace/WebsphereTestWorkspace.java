/*******************************************************************************
 * Copyright (c) 2003, 2007 IBM Corporation Licensed Material - Property of IBM. All rights reserved.
 *  
 * US Government Users Restricted Rights - Use, duplication or disclosure v1.0 restricted by GSA ADP
 * Schedule Contract with IBM Corp.
 * 
 * Contributors: IBM Corporation - initial API and implementation
 *******************************************************************************/
package com.ibm.ccl.soa.deploy.was.test.workspace;

import java.io.IOException;
import java.net.URL;
import java.util.Map;

import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IPath;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.core.runtime.Path;
import org.eclipse.core.runtime.Platform;
import org.eclipse.jst.server.generic.core.internal.GenericServerRuntime;
import org.eclipse.ui.IWorkbench;
import org.eclipse.ui.IWorkbenchWindow;
import org.eclipse.ui.PlatformUI;
import org.eclipse.wst.server.core.IRuntime;
import org.eclipse.wst.server.core.IRuntimeType;
import org.eclipse.wst.server.core.IRuntimeWorkingCopy;
import org.eclipse.wst.server.core.ServerCore;
import org.eclipse.wst.validation.internal.operations.ValidatorManager;

public class WebsphereTestWorkspace {

	// ///////////////////////////////////////////////
	// CHANGE ME to your websphere installation ///
	// and JDK install. ///
	// /////////////////////////////////////////////

	private static Path websphereInstallDir = new Path(
			"D:/Rational60/runtimes/base_v6");

	// Plants by Websphere Project
	public static final String PLANTS_BY_WEBSPHERE_PROJECT_NAME = "PlantsByWebSphere"; //$NON-NLS-1$

	public static final String PLANTS_BY_WEBSPHERE_WEB_PROJECT_NAME = "PlantsByWebSphere_WEB"; //$NON-NLS-1$

	public static final String PLANTS_BY_WEBSPHERE_EJB_PROJECT_NAME = "PlantsByWebSphereEJB"; //$NON-NLS-1$

	public static final String PLANTS_BY_WEBSPHERE_CLIENT_PROJECT_NAME = "PlantsByWebSphereClient"; //$NON-NLS-1$

	public static final String PLANTS_BY_WEBSPHERE_DDL_PROJECT_NAME = "PlantsByWebsphereDDL"; //$NON-NLS-1$

	public static final String PLANTS_BY_WEBSPHERE_GALLERY_PROJECT_NAME = "PlantsGallery"; //$NON-NLS-1$

	// Supplier Project
	public static final String SUPPLIER_PROJECT_NAME = "Supplier"; //$NON-NLS-1$

	public static final String SUPPLIER_WEB_PROJECT_NAME = "Supplier_WEB"; //$NON-NLS-1$

	public static final String SUPPLIER_EJB_PROJECT_NAME = "SupplierEJB"; //$NON-NLS-1$

	// Plants by Websphere Workspace archive
	private static Path testDeploymentProjectZipPath = new Path(
			"/testData/PlantsByWebSphereWorkspace.zip"); //$NON-NLS-1$

	public static String websphere60RuntimeType = "org.eclipse.jst.server.generic.runtime.websphere.6"; //$NON-NLS-1$

	public static String websphere60RuntimeID = "IBM WebSphere v6.0"; //$NON-NLS-1$

	private static IPath rootLocation = ResourcesPlugin.getWorkspace()
			.getRoot().getLocation();

	public static final String[] projectNames = new String[] {
			PLANTS_BY_WEBSPHERE_PROJECT_NAME,
			PLANTS_BY_WEBSPHERE_WEB_PROJECT_NAME,
			PLANTS_BY_WEBSPHERE_EJB_PROJECT_NAME,
			PLANTS_BY_WEBSPHERE_CLIENT_PROJECT_NAME,
			PLANTS_BY_WEBSPHERE_GALLERY_PROJECT_NAME,
			PLANTS_BY_WEBSPHERE_DDL_PROJECT_NAME, SUPPLIER_PROJECT_NAME,
			SUPPLIER_WEB_PROJECT_NAME, SUPPLIER_EJB_PROJECT_NAME };

	private static final String DB2_VERSION = "V8.1";

	private static final String DB2_PRODUCT_NAME = "DB2 UDB";

	private static final String DB2_CONNECTION_NAME = "BergConnection";

	private static final String DB2_PW_NAME = "hulk";

	private static final String DB2_USER_NAME = "Berg";

	private static final String DB2_CLASS_NAME = "com.ibm.db2.jcc.DB2Driver";

	private static final String DB2_DATABASE_NAME = "PlantsDB";

	private static Path DB2DirectoryName = new Path("add path");

	private static final String DB2_URL = "dbc:db2://host:50000/database";

	// DB2 Connection
	
	// DDL
	public static String PLANTS_FOR_WEBSPEHRE_DDL = "plantsbywebsphere.ddl";

	public static void init() throws IOException {

		try {
			createRuntime();
			createDB210_1Connection();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (CoreException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		ValidatorManager.getManager().suspendAllValidation(true);
		createProjects(projectNames);

		openDeployPerspective();
	}

	private static void openDeployPerspective() {
		try {
			IWorkbench bench = PlatformUI.getWorkbench();
			IWorkbenchWindow window = bench.getActiveWorkbenchWindow();
			bench.showPerspective(
					"com.ibm.ccl.soa.deploy.core.ui.DeployCore.Perspective",
					window);
		} catch (Exception e) {
			// dont care
		}

	}

	public static boolean createProjects(String[] projectNames) {
		return new ProjectUnzipUtil(getPath(testDeploymentProjectZipPath),
				projectNames).createProjects();
	}

	public static IPath getPath(IPath path) {
		URL url = WasTestsPlugin.getDefault().find(path);
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

	public static void createDB210_1Connection() throws IOException,
			CoreException {

	}

}
