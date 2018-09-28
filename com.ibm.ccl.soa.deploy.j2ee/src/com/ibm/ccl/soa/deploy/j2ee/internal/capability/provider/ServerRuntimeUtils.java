/*******************************************************************************
 * Copyright (c) 2003, 2007 IBM Corporation Licensed Material - Property of IBM. All rights reserved.
 *  
 * US Government Users Restricted Rights - Use, duplication or disclosure v1.0 restricted by GSA ADP
 * Schedule Contract with IBM Corp.
 * 
 * Contributors: IBM Corporation - initial API and implementation
 *******************************************************************************/
package com.ibm.ccl.soa.deploy.j2ee.internal.capability.provider;

import java.util.Set;

import org.eclipse.core.resources.IProject;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.wst.common.project.facet.core.IFacetedProject;
import org.eclipse.wst.common.project.facet.core.ProjectFacetsManager;
import org.eclipse.wst.common.project.facet.core.runtime.IRuntime;
import org.eclipse.wst.server.core.ServerCore;

public class ServerRuntimeUtils {

	/**
	 * Return the runtime id string for the given IRuntime return null if not found
	 */
	public static String getRuntimeId(IRuntime runtime) {
		org.eclipse.wst.server.core.IRuntime iRuntime = ServerCore.findRuntime(runtime.getName());
		if (iRuntime != null)
			return iRuntime.getRuntimeType().getId();
		return null;
	}

	/**
	 * Return the version string for the given type of the specified IRuntime Returns null if not
	 * found
	 */
	public static String getVersionString(IRuntime runtime) {
		org.eclipse.wst.server.core.IRuntime iRuntime = ServerCore.findRuntime(runtime.getName());
		if (iRuntime != null)
			return iRuntime.getRuntimeType().getVersion();
		return null;
	}

	public static Set getTargetRuntimes(IProject project) {
		try {
			IFacetedProject facetedProject = ProjectFacetsManager.create(project);
			if (null != facetedProject) {
				return facetedProject.getTargetedRuntimes();
			}
		} catch (CoreException e) {
			// Not faceted project, or wrong type
		}
		return null;
	}

	public static IRuntime getPrimaryRuntime(IProject project) {
		try {
			IFacetedProject facetedProject = ProjectFacetsManager.create(project);
			if (null != facetedProject) {
				return facetedProject.getPrimaryRuntime();
			}
		} catch (CoreException e) {
			// Not faceted project, or wrong type
		}
		return null;
	}

	public static boolean containsRuntimeMatchingType(IRuntime runtime, String type) {
		String runtimeId = getRuntimeId(runtime);
		if ((runtimeId != null) && runtimeId.startsWith(type))
			return true;
		return false;
	}

}
