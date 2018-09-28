/*******************************************************************************
 * Copyright (c) 2003, 2007 IBM Corporation Licensed Material - Property of IBM. All rights reserved.
 *  
 * US Government Users Restricted Rights - Use, duplication or disclosure v1.0 restricted by GSA ADP
 * Schedule Contract with IBM Corp.
 * 
 * Contributors: IBM Corporation - initial API and implementation
 *******************************************************************************/
package com.ibm.ccl.soa.deploy.core.test;

import java.io.IOException;

import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IFolder;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.resources.IWorkspace;
import org.eclipse.core.resources.IWorkspaceRunnable;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.core.runtime.Status;

import com.ibm.ccl.soa.deploy.core.Capability;
import com.ibm.ccl.soa.deploy.core.CapabilityLinkTypes;
import com.ibm.ccl.soa.deploy.core.ChangeScope;
import com.ibm.ccl.soa.deploy.core.CommunicationCapability;
import com.ibm.ccl.soa.deploy.core.CoreFactory;
import com.ibm.ccl.soa.deploy.core.CorePackage;
import com.ibm.ccl.soa.deploy.core.DeploymentTopologyDomain;
import com.ibm.ccl.soa.deploy.core.Requirement;
import com.ibm.ccl.soa.deploy.core.RequirementLinkTypes;
import com.ibm.ccl.soa.deploy.core.Topology;
import com.ibm.ccl.soa.deploy.core.Unit;
import com.ibm.ccl.soa.deploy.core.namespace.INamespaceFragment;
import com.ibm.ccl.soa.deploy.core.namespace.INamespaceFragmentRoot;
import com.ibm.ccl.soa.deploy.core.namespace.NamespaceCore;
import com.ibm.ccl.soa.infrastructure.emf.IEditModelScribbler;

/**
 * Provides a test environment setup.
 * 
 * Reuses functionality from the ProjectUnzipUtil.
 * 
 */
public class TestSetup<W extends TestWorkspace> {

	private final String projectName;
	private final String topologyNamespace;
	private IProject project;
	private INamespaceFragment fragment;
	private W workspace;

	public TestSetup(String theProjectName, String theTopologyNamespace)
			throws CoreException, IOException {
		projectName = theProjectName;
		topologyNamespace = theTopologyNamespace;

		init();
	}

	/**
	 * 
	 * @param theProjectName
	 * @param theTopologyNamespace
	 * @throws CoreException
	 */
	public TestSetup(String theProjectName, String theTopologyNamespace,
			W theWorkspace) throws CoreException, IOException {
		projectName = theProjectName;
		topologyNamespace = theTopologyNamespace;
		workspace = theWorkspace;

		init();
	}

	private void init() throws CoreException {

		project = ResourcesPlugin.getWorkspace().getRoot().getProject(projectName);
		ResourcesPlugin.getWorkspace().run(new IWorkspaceRunnable() {
			public void run(IProgressMonitor monitor) throws CoreException {
				if (!project.exists()) {
					project.create(monitor);
					project.open(monitor);
				}

				IFolder topologies = project.getFolder("topologies");

				if (!topologies.exists())
					topologies.create(true, true, monitor);

				INamespaceFragmentRoot root = NamespaceCore.createRoot(topologies,
						monitor);
				fragment = root.getNamespaceFragment(topologyNamespace);
				if (!fragment.exists())
					fragment.create(monitor);

				try {
					if (workspace != null)
						workspace.init();
				} catch(IOException ex ) {
					throw new CoreException( new Status( IStatus.ERROR, "com.ibm.ccl.soa.deploy.core.test", ex.getMessage(), ex ));
				}
			}
		}, project.getParent(), IWorkspace.AVOID_UPDATE | IResource.DEPTH_INFINITE | IResource.FORCE, new NullProgressMonitor()); 
	}

	public void dispose() throws CoreException {

		ResourcesPlugin.getWorkspace().run(new IWorkspaceRunnable() {
			
			public void run(IProgressMonitor monitor) throws CoreException {
				if (project.exists()) {
					project.delete(true, monitor);
				}
				if (workspace != null)
					workspace.dispose();
			}
		}, project.getParent(), IWorkspace.AVOID_UPDATE | IResource.DEPTH_INFINITE | IResource.FORCE, new NullProgressMonitor()); 
	}

	public IProject getProject() {
		return project;
	}

	public INamespaceFragment getFragment() {
		return fragment;
	}

	public DeploymentTopologyDomain createDomain(String topologyName) {
		return new DeploymentTopologyDomain(fragment.getTopology(topologyName));
	}

	/**
	 * 
	 * @param topologyName
	 * @param saveOptions
	 * @param setupTopologyChange
	 * 
	 * @return A {@link ChangeScope} which encompasses an open
	 *         {@link IEditModelScribbler} as well as the {@link Topology} that
	 *         was created.
	 * @throws ExecutionException
	 * 
	 * @see ChangeScope#OPTION_DO_NOT_SAVE
	 * @see ChangeScope#OPTION_FORCE_SAVE
	 * @see ChangeScope#OPTION_SAVE_IF_UNSHARED
	 */
	public SimpleChangeScope createTopologyScope(final String topologyName,
			int saveOptions, final ModelChange setupTopologyChange)
			throws ExecutionException {

		IProgressMonitor monitor = new NullProgressMonitor();
		IFile topologyFile = fragment.getTopology(topologyName);

		SimpleChangeScope scope = new SimpleChangeScope(topologyFile);

		scope.createTopology(getFragment().getQualifiedName(), topologyName,
				monitor);
		scope.execute(setupTopologyChange, saveOptions, monitor);

		return scope;
	}

	public W getWorkspace() {
		return workspace;
	}

	public static Requirement createHostingRequirement(Unit hostedUnit,
			String name) {
		Requirement hostingRequirement1 = CoreFactory.eINSTANCE
				.createRequirement();
		hostingRequirement1.setName(name);
		hostingRequirement1.setDmoEType(CorePackage.Literals.CAPABILITY);
		hostingRequirement1.setLinkType(RequirementLinkTypes.HOSTING_LITERAL);
		hostedUnit.getRequirements().add(hostingRequirement1);
		return hostingRequirement1;
	}

	public static Capability createHostingCapability(Unit hostedUnit,
			String name) {
		Capability hostingCapability1 = CoreFactory.eINSTANCE
				.createCapability();
		hostingCapability1.setName(name);
		hostingCapability1.setLinkType(CapabilityLinkTypes.HOSTING_LITERAL);
		hostedUnit.getCapabilities().add(hostingCapability1);
		return hostingCapability1;
	}

	public static Capability createCapability(Unit hostedUnit, String name) {
		Capability capability1 = CoreFactory.eINSTANCE.createCapability();
		capability1.setName(name);
		capability1.setLinkType(CapabilityLinkTypes.DEPENDENCY_LITERAL);
		hostedUnit.getCapabilities().add(capability1);
		return capability1;
	}

	public static CommunicationCapability createCommunicationCapability(
			Unit hostedUnit, String name) {
		CommunicationCapability capability1 = CoreFactory.eINSTANCE
				.createCommunicationCapability();
		capability1.setName(name);
		capability1.setLinkType(CapabilityLinkTypes.DEPENDENCY_LITERAL);
		hostedUnit.getCapabilities().add(capability1);
		return capability1;
	}

}
