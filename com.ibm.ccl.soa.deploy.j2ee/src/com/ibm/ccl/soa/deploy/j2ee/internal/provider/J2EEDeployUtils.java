/***************************************************************************************************
 * Copyright (c) 2003, 2007 IBM Corporation Licensed Material - Property of IBM. All rights
 * reserved.
 * 
 * US Government Users Restricted Rights - Use, duplication or disclosure v1.0 restricted by GSA ADP
 * Schedule Contract with IBM Corp.
 * 
 * Contributors: IBM Corporation - initial API and implementation
 **************************************************************************************************/
package com.ibm.ccl.soa.deploy.j2ee.internal.provider;

import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.wst.common.componentcore.internal.util.IModuleConstants;
import org.eclipse.wst.common.project.facet.core.IFacetedProject;
import org.eclipse.wst.common.project.facet.core.IProjectFacet;
import org.eclipse.wst.common.project.facet.core.IProjectFacetVersion;
import org.eclipse.wst.common.project.facet.core.ProjectFacetsManager;

public class J2EEDeployUtils implements J2EEVersionConstants {

	public static final String WEB_FACET_ID = IModuleConstants.JST_WEB_MODULE;

	public static final String EAR_FACET_ID = IModuleConstants.JST_EAR_MODULE;

	public static final String EJB_FACET_ID = IModuleConstants.JST_EJB_MODULE;

	public static final String JCA_FACET_ID = IModuleConstants.JST_CONNECTOR_MODULE;

	public static final String APPCLIENT_FACET_ID = IModuleConstants.JST_APPCLIENT_MODULE;

	public static final String JAVA_FACET_ID = IModuleConstants.JST_JAVA;

	public static final String EJB_CONTAINER_SERVICE_NAME_11 = "ejbService_11"; //$NON-NLS-1$ 
	public static final String EJB_CONTAINER_SERVICE_NAME_20 = "ejbService_20"; //$NON-NLS-1$ 
	public static final String EJB_CONTAINER_SERVICE_NAME_21 = "ejbService_21"; //$NON-NLS-1$ 

	public static final String SERVLET_CONTAINER_SERVICE_NAME_22 = "servletService_22"; //$NON-NLS-1$ 
	public static final String SERVLET_CONTAINER_SERVICE_NAME_23 = "servletService_23"; //$NON-NLS-1$
	public static final String SERVLET_CONTAINER_SERVICE_NAME_24 = "servletService_24"; //$NON-NLS-1$

	public static final String JSP_CONTAINER_SERVICE_NAME_11 = "jspService_11"; //$NON-NLS-1$
	public static final String JSP_CONTAINER_SERVICE_NAME_12 = "jspService_12"; //$NON-NLS-1$
	public static final String JSP_CONTAINER_SERVICE_NAME_20 = "jspService_20"; //$NON-NLS-1$

	public static final String J2EE_CONTAINER_SERVICE_NAME_12 = "j2eeService_12"; //$NON-NLS-1$
	public static final String J2EE_CONTAINER_SERVICE_NAME_13 = "j2eeService_13"; //$NON-NLS-1$
	public static final String J2EE_CONTAINER_SERVICE_NAME_14 = "j2eeService_14"; //$NON-NLS-1$

	public static final String JCA_CONTAINER_SERVICE_NAME_10 = "jcaService_10"; //$NON-NLS-1$ 
	public static final String JCA_CONTAINER_SERVICE_NAME_15 = "jcaService_15"; //$NON-NLS-1$ 

	public static IProject getProject(IAdaptable adaptable) {
		IProject project = (IProject) adaptable.getAdapter(IProject.class);
		if (project == null) {
			IResource resource = (IResource) adaptable.getAdapter(IResource.class);
			project = resource.getProject();
		}
		return project;
	}

	public static boolean hasFacet(IProject project, String facetID) {
		return null != J2EEDeployUtils.getFacet(project, facetID);
	}

	public static IProjectFacetVersion getFacet(IProject project, String facetID) {
		try {
			IFacetedProject facetedProject = ProjectFacetsManager.create(project);
			if (null != facetedProject) {
				IProjectFacet facet = ProjectFacetsManager.getProjectFacet(facetID);
				return facetedProject.getInstalledVersion(facet);
			}
		} catch (CoreException e) {
			// Not faceted project, or wrong type
		}
		return null;
	}

}
