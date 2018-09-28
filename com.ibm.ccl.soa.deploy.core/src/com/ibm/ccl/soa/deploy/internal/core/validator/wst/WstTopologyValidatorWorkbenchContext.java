/*******************************************************************************
 * Copyright (c) 2003, 2007 IBM Corporation Licensed Material - Property of IBM. All rights reserved.
 *  
 * US Government Users Restricted Rights - Use, duplication or disclosure v1.0 restricted by GSA ADP
 * Schedule Contract with IBM Corp.
 * 
 * Contributors: IBM Corporation - initial API and implementation
 *******************************************************************************/
package com.ibm.ccl.soa.deploy.internal.core.validator.wst;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IResource;
import org.eclipse.wst.validation.internal.operations.IWorkbenchContext;
import org.eclipse.wst.validation.internal.operations.WorkbenchReporter;

import com.ibm.ccl.soa.deploy.core.DeployModelObject;
import com.ibm.ccl.soa.deploy.core.validator.DeployValidatorService;
import com.ibm.ccl.soa.deploy.internal.core.validator.TopologyMarkerFactory;

/**
 * Provides access to the workbench for the deploy topology WST validation interface.
 * <p>
 * Used in the org.eclipse.wst.validation.validator extension point declaration in plugin.xml.
 * Maintains
 */
@SuppressWarnings("restriction")
public class WstTopologyValidatorWorkbenchContext implements IWorkbenchContext {

	/**
	 * Last project for which the validation context was set {@link #setProject(IProject)}.
	 */
	protected IProject project;

	/**
	 * Cached SOA deploy validator service.
	 */
	protected DeployValidatorService validator;

	/**
	 * List of resources that where add
	 */
	protected List resourceList = new ArrayList();

	/**
	 * Returns the deploy validator service instance associated with this context.
	 * 
	 * @return the deploy validator service.
	 */
	public DeployValidatorService getDeployValidatorService() {
		if (validator == null) {
			validator = new DeployValidatorService();
		}
		return validator;
	}

	public void cleanup(WorkbenchReporter reporter) {
		resourceList.clear();
		validator = null;
	}

	public void closing() {
		resourceList.clear();
	}

	public void deleting() {
		resourceList.clear();
	}

	public IFile getFile(Object object) {
		IResource resource = getResource(object);
		if (resource instanceof IFile) {
			return (IFile) resource;
		}
		return null;
	}

	public IResource getResource(Object object) {
		if (object instanceof DeployModelObject) {
			return TopologyMarkerFactory.getIFile((DeployModelObject) object);
		} else if (object instanceof IResource) {
			return (IResource) object;
		}
		return null;
	}

	public String getLocation(Object object) {
		return null;
	}

	public String getPortableName(IResource resource) {
		return resource.getFullPath().toPortableString();
	}

	public IProject getProject() {
		return project;
	}

	public String getTargetObjectName(Object object) {
		if (object instanceof DeployModelObject) {
			return ((DeployModelObject) object).getFullPath();
		}
		return null;
	}

	public void registerResource(IResource resource) {
		resourceList.add(resource);
	}

	public void setProject(IProject project) {
		this.project = project;
		// TODO is this the correct behavior?
		resourceList.clear();
	}

	public void shutdown() {
		// TODO Auto-generated method stub

	}

	public Object loadModel(String symbolicName) {
		return null;
	}

	public Object loadModel(String symbolicName, Object[] parms) {
		return null;
	}

	public String[] getURIs() {
		String[] uris = new String[resourceList.size()];
		for (int i = 0; i < uris.length; i++) {
			uris[i] = ((IResource) resourceList.get(i)).getFullPath().toString();
		}
		return uris;
	}

	/**
	 * Returns the resources that have been added in the current project.
	 * 
	 * @return an array of resources (never null).
	 */
	public IResource[] getResources() {
		return (IResource[]) resourceList.toArray(new IResource[resourceList.size()]);
	}
}
