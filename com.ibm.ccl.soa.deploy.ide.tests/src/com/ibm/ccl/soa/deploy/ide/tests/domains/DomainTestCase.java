/*******************************************************************************
 * Copyright (c) 2003, 2007 IBM Corporation Licensed Material - Property of IBM. All rights reserved.
 *  
 * US Government Users Restricted Rights - Use, duplication or disclosure v1.0 restricted by GSA ADP
 * Schedule Contract with IBM Corp.
 * 
 * Contributors: IBM Corporation - initial API and implementation
 *******************************************************************************/
package com.ibm.ccl.soa.deploy.ide.tests.domains;

import java.io.IOException;
import java.util.Collections;
import java.util.Iterator;
import java.util.Map;

import junit.framework.TestCase;

import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.resources.IWorkspace;
import org.eclipse.core.resources.IWorkspaceRunnable;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.jem.util.plugin.JEMUtilPlugin;

import com.ibm.ccl.soa.deploy.core.DeployCoreRoot;
import com.ibm.ccl.soa.deploy.core.DeployModelObject;
import com.ibm.ccl.soa.deploy.core.Topology;
import com.ibm.ccl.soa.deploy.core.Unit;
import com.ibm.ccl.soa.deploy.core.validator.DeployValidatorService;

public abstract class DomainTestCase extends TestCase {

	private IProject project;
	private String projectName;

	/**
	 * Construct a domain test case (setup creates project).
	 * 
	 * @param name
	 *            the name of the project.
	 */
	public DomainTestCase(String name) {
		super(name);
		projectName = name;

		try {
			assert false;
			System.err.println("Warning: " + getClass().getName()
					+ ": assertions are not enabled in Java VM");
		} catch (AssertionError e) {
			// ok
		}
	}

	@Override
	protected void setUp() throws Exception {
		super.setUp();
		project = ResourcesPlugin.getWorkspace().getRoot().getProject(projectName);
		ResourcesPlugin.getWorkspace().run(new IWorkspaceRunnable() {
			public void run(IProgressMonitor monitor) throws CoreException {
				project.delete(true, true, monitor);
				project.create(monitor);
				project.open(monitor);
			}
		}, project.getParent(), IWorkspace.AVOID_UPDATE | IResource.DEPTH_INFINITE | IResource.FORCE, new NullProgressMonitor()); 
	}
	
	

	@Override
	protected void tearDown() throws Exception {
		super.tearDown();
		ResourcesPlugin.getWorkspace().run(new IWorkspaceRunnable() {
			public void run(IProgressMonitor monitor) throws CoreException {
				if (project.exists()) {
					project.delete(true, new NullProgressMonitor());
				}
			}
		}, project.getParent(), IWorkspace.AVOID_UPDATE | IResource.DEPTH_INFINITE | IResource.FORCE, new NullProgressMonitor()); 
	}

	/**
	 * Loads the templates resource
	 * 
	 * @param templateURIString
	 * @throws IOException
	 */
	protected void doTemplateLoad(String templateURIString) throws IOException {
		URI templateURI = URI.createURI(templateURIString);
		Resource resource = JEMUtilPlugin.getPluginResourceSet().getResource(
				templateURI, true);
		DeployCoreRoot root = (DeployCoreRoot) resource.getContents().get(0);

		resource.load(Collections.EMPTY_MAP);
		DeployCoreRoot deployCoreRoot = (DeployCoreRoot) resource.getContents()
				.get(0);
		Topology topology = root.getTopology();
		assertNotNull(topology);
		resource.unload();
	}

	/**
	 * Loads the template and returns the unit
	 * 
	 * @param templateURIString
	 * @return
	 * @throws IOException
	 */
	protected Unit getTemplateUnit(String templateURIString) throws IOException {
		URI templateURI = URI.createURI(templateURIString);
		Resource resource = JEMUtilPlugin.getPluginResourceSet().getResource(
				templateURI, true);
		DeployCoreRoot root = (DeployCoreRoot) resource.getContents().get(0);

		resource.load(Collections.EMPTY_MAP);
		Topology topology = root.getTopology();
		assertNotNull(topology);
		Unit unit = (Unit) topology.getUnits().get(0);
		Unit unitcopy = (Unit) EcoreUtil.copy(unit);

		// TODO remove
		// Compatibility layer support (avoid duplicated requirements).
		// ServicesSetRequirementAdapter.cleanRequirements(unit);

		resource.unload();

		return unitcopy;
	}

	/**
	 * Loads a <em>single</em> unit from template topology and adds it to the
	 * topology.
	 * 
	 * @param templateURIString
	 *            URI to the template resource containing a
	 *            {@link DeployCoreRoot} whose element is a {@link Topology}.
	 * @param topology
	 *            the topology to which the units will be added.
	 * 
	 * @throws IOException
	 *             if an error occurs when reading the template.
	 * 
	 * @returns the unit that was added.
	 */
	protected Unit addTemplateUnit(String templateURIString, Topology topology)
			throws IOException {
		assert templateURIString != null;
		assert topology != null;
		DeployCoreRoot root = (DeployCoreRoot) topology.getEObject()
				.eContainer();
		assert root != null;

		URI templateURI = URI.createURI(templateURIString);
		Resource templateResource = JEMUtilPlugin.getPluginResourceSet()
				.getResource(templateURI, true);
		DeployCoreRoot templateRoot = (DeployCoreRoot) templateResource
				.getContents().get(0);

		templateResource.load(Collections.EMPTY_MAP);
		Topology templateTopology = templateRoot.getTopology();
		assertNotNull(templateTopology);
		Unit unit = (Unit) templateTopology.getUnits().get(0);
		Unit unitcopy = (Unit) EcoreUtil.copy(unit);
		topology.getUnits().add(unitcopy);

		for (Iterator iter = templateRoot.getXMLNSPrefixMap().entrySet()
				.iterator(); iter.hasNext();) {
			Map.Entry entry = (Map.Entry) iter.next();
			if (!root.getXMLNSPrefixMap().containsKey(entry.getKey())) {
				root.getXMLNSPrefixMap().put(entry.getKey(), entry.getValue());
			}
		}

		// TODO remove
		// Compatibility layer support (avoid duplicated requirements).
		// ServicesSetRequirementAdapter.cleanRequirements(unit);

		templateResource.unload();

		return unitcopy;
	}

	/**
	 * Asserts that the topology validates with no errors.
	 * 
	 * @param topology
	 *            a topology to be validated.
	 */
	protected void assertNoValidationErrors(Topology topology) throws Exception {
		DeployValidatorService service = new DeployValidatorService();
		service.validate(topology);
		StringBuffer buffer = new StringBuffer();
		for (Iterator iter = topology.findAllDeployModelObjects(); iter
				.hasNext();) {
			DeployModelObject object = (DeployModelObject) iter.next();
			if (object.getStatus().getSeverity() == IStatus.ERROR) {
				if (buffer.length() > 0) {
					buffer.append('\n');
				}
				buffer.append(object.getStatus());
			}
		}
		assert buffer.length() == 0 : buffer.toString();
	}

}
