/*******************************************************************************
 * Copyright (c) 2003, 2007 IBM Corporation Licensed Material - Property of IBM. All rights reserved.
 *  
 * US Government Users Restricted Rights - Use, duplication or disclosure v1.0 restricted by GSA ADP
 * Schedule Contract with IBM Corp.
 * 
 * Contributors: IBM Corporation - initial API and implementation
 *******************************************************************************/
package com.ibm.ccl.soa.deploy.j2ee.provider;

import java.util.Iterator;
import java.util.List;

import org.eclipse.core.resources.IContainer;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.Path;
import org.eclipse.emf.common.EMFPlugin;
import org.eclipse.emf.common.util.ResourceLocator;
import org.eclipse.emf.ecore.provider.EcoreEditPlugin;

import com.ibm.ccl.soa.deploy.core.Annotation;
import com.ibm.ccl.soa.deploy.core.Artifact;
import com.ibm.ccl.soa.deploy.core.FileArtifact;
import com.ibm.ccl.soa.deploy.core.IAnnotationConstants;
import com.ibm.ccl.soa.deploy.core.Unit;
import com.ibm.ccl.soa.deploy.core.provider.DeployCoreEditPlugin;

/**
 * This is the central singleton for the J2ee edit plugin. <!-- begin-user-doc --> <!-- end-user-doc
 * -->
 * 
 * @generated
 */
public final class J2eeEditPlugin extends EMFPlugin {

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public static final String copyright = "Copyright (c) 2005, 2006 IBM Corporation. Licensed Material - Property of IBM. All rights reserved."; //$NON-NLS-1$

	/**
	 * Keep track of the singleton.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public static final J2eeEditPlugin INSTANCE = new J2eeEditPlugin();

	/**
	 * Keep track of the singleton.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	private static Implementation plugin;

	/**
	 * Create the instance.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public J2eeEditPlugin() {
		super(new ResourceLocator[] { DeployCoreEditPlugin.INSTANCE, EcoreEditPlugin.INSTANCE, });
	}

	/**
	 * Returns the singleton instance of the Eclipse plugin.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @return the singleton instance.
	 * @generated
	 */
	public ResourceLocator getPluginResourceLocator() {
		return plugin;
	}

	/**
	 * Returns the singleton instance of the Eclipse plugin.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @return the singleton instance.
	 * @generated
	 */
	public static Implementation getPlugin() {
		return plugin;
	}

	/**
	 * The actual implementation of the Eclipse <b>Plugin</b>.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @generated
	 */
	public static class Implementation extends EclipsePlugin {
		/**
		 * Creates an instance.
		 * <!-- begin-user-doc --> <!-- end-user-doc -->
		 * @generated
		 */
		public Implementation() {
			super();

			// Remember the static instance.
			//
			plugin = this;
		}
	}

	public static IProject findProject(Unit unit) {
		Annotation annotation = unit.findAnnotation(IAnnotationConstants.ENVIRONMENT_WTP);

		String projectName = null;
		if (annotation != null) {
			String annotationProjectName = (String) annotation.getDetails().get(
					IAnnotationConstants.PROJECT_NAME);
			if (annotationProjectName != null && annotationProjectName.length() > 0)
				projectName = annotationProjectName;
		}

		if (projectName == null) {
			List artifacts = unit.getArtifacts();
			for (Iterator<Artifact> iterator = artifacts.iterator(); iterator.hasNext()
					&& projectName == null;) {
				Artifact artifact = iterator.next();

				if (artifact instanceof FileArtifact) {
					FileArtifact fileArtifact = (FileArtifact) artifact;
					List files = fileArtifact.getFileURIs();
					for (Iterator<String> fileIter = files.iterator(); fileIter.hasNext()
							&& projectName == null;) {
						String location = fileIter.next();

						IContainer[] containers = ResourcesPlugin.getWorkspace().getRoot()
								.findContainersForLocation(new Path(location));
						if (containers.length > 0) {
							for (int i = 0; i < containers.length && projectName == null; i++) {
								if (containers[i] instanceof IProject) {
									projectName = containers[i].getName();
								}
							}
						}
					}
				}
			}
		}

		if (projectName == null) {
			projectName = J2eeEditPlugin.computeProjectName(unit.getDisplayName());

		}

		if (projectName != null
				&& ResourcesPlugin.getWorkspace().validateName(projectName, IResource.PROJECT).isOK())
			return ResourcesPlugin.getWorkspace().getRoot().getProject(projectName);
		return null;
	}

	public static String computeProjectName(String displayName) {
		StringBuffer buffer = new StringBuffer();
		if (!ResourcesPlugin.getWorkspace().validateName(displayName, IResource.PROJECT).isOK()) {
			char[] characters = displayName.toCharArray();
			for (int i = 0; i < characters.length; i++) {
				if (!isValid(characters[i])) {
					characters[i] = '_';
				}
			}
			buffer.append(characters);
		} else {
			buffer.append(displayName);
		}
		return buffer.toString();
	}

	public static boolean isValid(char c) {
		switch (c)
		{
		case '/':
		case '@':
		case '#':
		case '%':
		case '^':
		case '*':
		case '(':
		case ')':
			return false;
		default:
		}
		return true;
	}

}
