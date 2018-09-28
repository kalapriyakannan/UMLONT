/*******************************************************************************
 * Copyright (c) 2003, 2007 IBM Corporation Licensed Material - Property of IBM. All rights reserved.
 *  
 * US Government Users Restricted Rights - Use, duplication or disclosure v1.0 restricted by GSA ADP
 * Schedule Contract with IBM Corp.
 * 
 * Contributors: IBM Corporation - initial API and implementation
 *******************************************************************************/
package com.ibm.ccl.soa.deploy.core.ui.resources;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.resources.IResourceProxy;
import org.eclipse.core.resources.IResourceProxyVisitor;
import org.eclipse.core.runtime.CoreException;

import com.ibm.ccl.soa.infrastructure.emf.DefaultScribblerDomain;
import com.ibm.ccl.soa.infrastructure.emf.EclipseResourceDescriptor;
import com.ibm.ccl.soa.infrastructure.emf.EditModelException;
import com.ibm.ccl.soa.infrastructure.emf.IEditModelFactory;
import com.ibm.ccl.soa.infrastructure.emf.IEditModelScribbler;
import com.ibm.ccl.soa.infrastructure.emf.IResourceDescriptor;
import com.ibm.ccl.soa.infrastructure.emf.IScribblerDomain;

/**
 * @since 1.0 ProjectDeployDomain manages all the folders that contains the topology fil
 * 
 */
public class ProjectDeployDomain extends DefaultScribblerDomain implements IScribblerDomain,
		IResourceProxyVisitor {
	/**
	 * topology file extension
	 */
	public static final String TOPOLOGY_EXTENSION = ".topology"; //$NON-NLS-1$

	private IResourceDescriptor[] descriptors;

	List topologyRD = new ArrayList();

	private static final String DEPLOYMENT_TOPOLOGY_ID = "deploymentToplogyIndex"; //$NON-NLS-1$

	private IProject project;

	/**
	 * @param project
	 * @return Returns the instance of the ProjectDeployDomain
	 */
	public static ProjectDeployDomain createDomain(IProject project) {
		return new ProjectDeployDomain(project);
	}

	/**
	 * @param project
	 */
	public ProjectDeployDomain(IProject project) {
		this.project = project;
		try {
			project.accept(this, IResource.NONE);
		} catch (CoreException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.core.resources.IResourceProxyVisitor#visit(org.eclipse.core.resources.IResourceProxy)
	 */
	public boolean visit(IResourceProxy proxy) {
		String name = proxy.getName();
		if (name.endsWith(ProjectDeployDomain.TOPOLOGY_EXTENSION))
			addResource(proxy.requestResource());
		return true;
	}

	private void addResource(IResource resource) {
		if (resource.getType() == IResource.FILE)
			addModelFile((IFile) resource);
	}

	/**
	 * @param domain
	 * @return Returns the IEditModelScribbler
	 * @throws EditModelException
	 */
	public static IEditModelScribbler createScribbler(ProjectDeployDomain domain)
			throws EditModelException {
		return IEditModelFactory.eINSTANCE.createScribblerForWrite(domain.getProject(), domain);
	}

	/**
	 * @return Returns DEPLOYMENT_TOPOLOGY_ID
	 */
	protected String getDeploymentTopologyId() {
		return DEPLOYMENT_TOPOLOGY_ID;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.ibm.ccl.soa.infrastructure.emf.IScribblerDomain#getResourceDescriptors()
	 */
	public IResourceDescriptor[] getResourceDescriptors() {
		if (descriptors == null)
			descriptors = (IResourceDescriptor[]) topologyRD
					.toArray(new IResourceDescriptor[topologyRD.size()]);
		return descriptors;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.ibm.ccl.soa.infrastructure.emf.DefaultScribblerDomain#getLabel()
	 */
	public String getLabel() {
		return getDeploymentTopologyId();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.ibm.ccl.soa.infrastructure.emf.IScribblerDomain#getEditModelLabel()
	 */
	public String getEditModelLabel() {
		return getProject().getName() + "." + getDeploymentTopologyId();//$NON-NLS-1$
	}

	/**
	 * @return Returns IProject
	 */
	public IProject getProject() {
		return project;
	}

	/**
	 * @param file
	 * @return Returns the removed descriptor which matches the file
	 */
	public IResourceDescriptor removeModelFile(IFile file) {
		IResourceDescriptor descriptor = getResourceDescriptor(file);
		if (descriptor != null) {
			topologyRD.remove(descriptor);
			descriptors = null;
		}
		return descriptor;
	}

	/**
	 * @param file
	 * @return Adds a topology file to the list of the file
	 */
	public IResourceDescriptor addModelFile(IFile file) {

		IResourceDescriptor resourceDescriptor = new EclipseResourceDescriptor(file);
		topologyRD.add(resourceDescriptor);
		// reinitialize the descriptor to null for lazy initialization
		descriptors = null;
		return resourceDescriptor;
	}

	/**
	 * @param file
	 * @return Returns the IResourceDescriptor matching the file
	 */
	public IResourceDescriptor getResourceDescriptor(IFile file) {
		IResourceDescriptor descriptor = null;
		for (int x = 0; x < topologyRD.size(); ++x) {
			descriptor = (IResourceDescriptor) topologyRD.get(x);
			if (descriptor.matches(file)) {
				return descriptor;
			}
		}
		return null;
	}
}
