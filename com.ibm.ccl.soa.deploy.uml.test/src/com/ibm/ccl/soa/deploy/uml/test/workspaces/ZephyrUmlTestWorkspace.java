/*******************************************************************************
 * Copyright (c) 2003, 2007 IBM Corporation Licensed Material - Property of IBM. All rights reserved.
 *  
 * US Government Users Restricted Rights - Use, duplication or disclosure v1.0 restricted by GSA ADP
 * Schedule Contract with IBM Corp.
 * 
 * Contributors: IBM Corporation - initial API and implementation
 *******************************************************************************/
package com.ibm.ccl.soa.deploy.uml.test.workspaces;

import java.io.IOException;
import java.net.URL;
import java.util.Collection;

import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IPath;
import org.eclipse.core.runtime.Path;
import org.eclipse.core.runtime.Platform;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.gmf.runtime.emf.core.util.ResourceUtil;
import org.eclipse.uml2.uml.Component;
import org.eclipse.uml2.uml.util.UMLUtil;

import com.ibm.ccl.soa.deploy.uml.test.workspaces.ProjectUnzipUtil;
import com.ibm.ccl.soa.deploy.uml.test.Activator;

public class ZephyrUmlTestWorkspace {

	public static final String UML_MODEL_URI_STRING="platform:/resource/TopologyProject/Blank Model.emx";

	public static final URI UML_MODEL_URI_=URI.createURI(UML_MODEL_URI_STRING);
	
	private static Path umlProjectZipLocation = new Path(
			"/testData/zephyrUmlIntegrationWorkspace.zip"); //$NON-NLS-1$
	
	public static String TOPOLOGY_PROJECT = "TopologyProject";
	public static String ANOTHER_TOPOLOGY_PROJECT = "AnotherTopologyProject";

	public static final String[] projectNames = new String[] { "TopologyProject", "AnotherTopologyProject" };

	private static Resource modelResource;
	
	public static void init() throws IOException {
		try {
			for (int i = 0; i < projectNames.length; i++) {
				String projectName = projectNames[i];
				if (!getProject(projectName).exists()) {
					createProject(projectName);
				}
				getProject(projectName).refreshLocal(IResource.DEPTH_INFINITE,
						null);
			}
			
			modelResource = ResourceUtil.getResourceSet().getResource(UML_MODEL_URI_, true);


		} catch (CoreException e) {
			e.printStackTrace();
		}
	}

	public static boolean createProject(String name) {
		return new ProjectUnzipUtil(getPath(umlProjectZipLocation),
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

	public static Resource getModelResource() {
		return modelResource;
	}
	
	


}
