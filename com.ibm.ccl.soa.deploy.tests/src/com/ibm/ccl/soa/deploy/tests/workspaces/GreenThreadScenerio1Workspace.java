/*******************************************************************************
 * Copyright (c) 2003, 2007 IBM Corporation Licensed Material - Property of IBM. All rights reserved.
 *  
 * US Government Users Restricted Rights - Use, duplication or disclosure v1.0 restricted by GSA ADP
 * Schedule Contract with IBM Corp.
 * 
 * Contributors: IBM Corporation - initial API and implementation
 *******************************************************************************/
package com.ibm.ccl.soa.deploy.tests.workspaces;

import java.io.IOException;
import java.net.URL;

import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IPath;
import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.core.runtime.Path;
import org.eclipse.core.runtime.Platform;
import org.eclipse.wst.server.core.IRuntimeType;
import org.eclipse.wst.server.core.IRuntimeWorkingCopy;
import org.eclipse.wst.server.core.ServerCore;

import com.ibm.ccl.soa.deploy.tests.TopologyTestsPlugin;
import com.ibm.ccl.soa.deploy.tests.util.ProjectUnzipUtil;

public class GreenThreadScenerio1Workspace {

	public static final String USER_PROJECT_NAME = "UserWar"; //$NON-NLS-1$

	public static final String BANK_PROJECT_NAME = "BankWar"; //$NON-NLS-1$

	public static final String BANK_SQLS_PROJECT_NAME = "BankImportedDabaseSQLS"; //$NON-NLS-1$
	// Tomcat Server
	private static Path tomcatServerZipLocation = new Path(
			"/testData/tomcatServer.zip"); //$NON-NLS-1$

	// Tomcat Workspace
	private static Path testDeploymentProjectZipPath = new Path(
			"/testData/tomcatworkspace.zip"); //$NON-NLS-1$

	private static String tomcat50DirName = "/jakarta-tomcat-5.0.28"; //$NON-NLS-1$

	private static String testDirectory = "/testServers"; //$NON-NLS-1$

	public static String moduleType = "jst.web"; //$NON-NLS-1$

	private static IPath rootLocation = ResourcesPlugin.getWorkspace()
			.getRoot().getLocation();

	// /Tomcat runtime

	public static String tomcat50RuntimeType = "org.eclipse.jst.server.tomcat.runtime.50"; //$NON-NLS-1$

	public static String tomcat50RuntimeInstanceId = "Apache Tomcat v5.0"; //$NON-NLS-1$  //ties modules to server tooling via project facet

	public static final String[] projectNames = new String[] {
			USER_PROJECT_NAME, BANK_PROJECT_NAME, BANK_SQLS_PROJECT_NAME };

	// ///Derby information

	private static Path derbyServerZipLocation = new Path(
			"/testData/db-derby-10.1.2.1-bin.zip");//$NON-NLS-1$

	private static Path derby1012DirectoryName = new Path(
			"/db-derby-10.1.2.1-bin");//$NON-NLS-1$


	private static String derbyJarLocation = "/lib/derby.jar";

	public static String DERBY_PRODUCT_NAME = "Derby";

	public static String DERBY_VERSION = "10.1";

	public static String DERBY_ID = "Derby10.1";

	public static String DERBY_DATABASE_NAME = "TestDatabase";

	public static String DERBY_CONNECTION_NAME = "Derby Connection";

	public static String DERBY_USER_NAME = "Makin";

	public static String DERBY_PW_NAME = "narindered";

	public static String DERBY_CLASS_NAME = "org.apache.derby.jdbc.EmbeddedDriver";

	public static String DERBY_URL = "jdbc:derby:" + rootLocation.getDevice()
			+ "\\" + DERBY_DATABASE_NAME + ";create=true";

	public static String DERBY_JNDI_NAME = "jdbc/bank";

	// DDLS
	public static String ACCOUNT_DDL = "AccountSetup.ddl";

	public static String ACCOUNT_ALTER_DDL = "AlterAccountSetup.ddl";

	public static void init() {
		try {
			for (int i = 0; i < projectNames.length; i++) {
				String projectName = projectNames[i];
				if (!getProject(projectName).exists())
					createProject(projectName);
				getProject(projectName).refreshLocal(IResource.DEPTH_INFINITE,
						null);
			}
			installTomcat50();
			createRuntime();
			installDerby10_1();
			createDerby10_1Connection();
		} catch (CoreException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static Path getDefaultServerLocation() {
		String device = rootLocation.getDevice();
		return new Path(device + testDirectory);
	}

	public static Path getTomcat50Path() {
		return (Path) getDefaultServerLocation().append(tomcat50DirName);
	}

	public static Path getDerby10_1JarPath() {
		return (Path) getDefaultServerLocation().append(derby1012DirectoryName)
				.append(derbyJarLocation);
	}

	public static void installTomcat50() throws CoreException, IOException {

		if (!isTomcat50Installed(getDefaultServerLocation())) {
			ProjectUnzipUtil util = new ProjectUnzipUtil(
					getPath(testDeploymentProjectZipPath), new String[] {});
			util.setRootLocation(getDefaultServerLocation());
			util.expandZip(getPath(tomcatServerZipLocation));
		}

	}

	public static void installDerby10_1() throws CoreException, IOException {

		if (!isDerby10_1Installed(getDefaultServerLocation())) {
			ProjectUnzipUtil util = new ProjectUnzipUtil(
					getPath(testDeploymentProjectZipPath), new String[] {});
			util.setRootLocation(getDefaultServerLocation());
			util.expandZip(getPath(derbyServerZipLocation));
		}

	}

	public static boolean isTomcat50Installed(Path path) {
		IPath filePath = path.append(tomcat50DirName);
		return filePath.toFile().exists();
	}

	public static boolean isDerby10_1Installed(Path path) {
		IPath filePath = path.append(derby1012DirectoryName);
		return filePath.toFile().exists();
	}

	public static boolean createProject(String name) {
		return new ProjectUnzipUtil(getPath(testDeploymentProjectZipPath),
				new String[] { name }).createProjects();
	}

	public static IPath getPath(IPath path) {
		URL url = TopologyTestsPlugin.getDefault().find(path);
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

	public static void createDerby10_1Connection() throws IOException,
			CoreException {

	}

	public static void createRuntime() throws IOException, CoreException {
		NullProgressMonitor nullMonitor = new NullProgressMonitor();
		IRuntimeType[] runtimes = ServerCore.getRuntimeTypes();
		IRuntimeType tomcatRuntimeType = null;
		for (int i = 0; i < runtimes.length; i++) {
			IRuntimeType type = runtimes[i];
			if (type.getId().equals(tomcat50RuntimeType))
				tomcatRuntimeType = type;
		}
		if (tomcatRuntimeType == null)
			throw new IOException("runtime type not found"); //$NON-NLS-1$
		IRuntimeWorkingCopy copy = tomcatRuntimeType.createRuntime(
				tomcat50RuntimeInstanceId, nullMonitor);
		copy.setLocation(getTomcat50Path());
		copy.save(true, nullMonitor);
	}

}
