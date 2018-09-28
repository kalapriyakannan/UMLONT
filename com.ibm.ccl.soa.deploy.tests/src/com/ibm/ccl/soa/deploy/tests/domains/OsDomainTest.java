/*******************************************************************************
 * Copyright (c) 2003, 2007 IBM Corporation Licensed Material - Property of IBM. All rights reserved.
 *  
 * US Government Users Restricted Rights - Use, duplication or disclosure v1.0 restricted by GSA ADP
 * Schedule Contract with IBM Corp.
 * 
 * Contributors: IBM Corporation - initial API and implementation
 *******************************************************************************/
package com.ibm.ccl.soa.deploy.tests.domains;

import java.io.IOException;
import java.util.Collections;

import junit.framework.TestCase;

import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.jem.util.emf.workbench.WorkbenchResourceHelperBase;
import org.eclipse.jem.util.plugin.JEMUtilPlugin;

import com.ibm.ccl.soa.deploy.core.CoreFactory;
import com.ibm.ccl.soa.deploy.core.DeployCoreRoot;
import com.ibm.ccl.soa.deploy.core.HostingLink;
import com.ibm.ccl.soa.deploy.core.Topology;
import com.ibm.ccl.soa.deploy.core.Unit;
import com.ibm.ccl.soa.deploy.os.OperatingSystem;
import com.ibm.ccl.soa.deploy.os.OperatingSystemUnit;
import com.ibm.ccl.soa.deploy.os.OsFactory;
import com.ibm.ccl.soa.deploy.os.User;
import com.ibm.ccl.soa.deploy.os.UserGroup;
import com.ibm.ccl.soa.deploy.os.UserGroupUnit;
import com.ibm.ccl.soa.deploy.os.UserUnit;

/**
 * @since 1.0 The primary tests for the OS domain are done in
 *        com.ibm.ccl.soa.deploy.os.test
 */
public class OsDomainTest extends TestCase {

	private static final String PROJECT_NAME = "OsDomainTest";

	private IProject project;

	protected void setUp() throws Exception {
		super.setUp();
		project = ResourcesPlugin.getWorkspace().getRoot().getProject(
				PROJECT_NAME);
		project.create(new NullProgressMonitor());
		project.open(new NullProgressMonitor());
	}

	/**
	 * @throws IOException
	 */
	public void testOsDomain() throws IOException {

		/**
		 * Setup
		 */
		URI uri = URI.createPlatformResourceURI(PROJECT_NAME + "/os.topology");
		Resource res = WorkbenchResourceHelperBase.createResource(uri);
		DeployCoreRoot root = CoreFactory.eINSTANCE.createDeployCoreRoot();
		res.getContents().add(root);
		Topology top = CoreFactory.eINSTANCE.createTopology();
		top.setName("Os Topology");

		root.setTopology(top);

		OperatingSystem operatingSystem = OsFactory.eINSTANCE
				.createOperatingSystem();
		operatingSystem.setName("operatingSystem");

		OperatingSystemUnit operatingSystemUnit = OsFactory.eINSTANCE
				.createOperatingSystemUnit();
		operatingSystemUnit.setName("operatingSystemUnit");
		operatingSystemUnit.getOnlyDependencyCapabilities()
				.add(operatingSystem);
		top.getUnits().add(operatingSystemUnit);

		User user = OsFactory.eINSTANCE.createUser();
		user.setName("user");

		UserUnit userUnit = OsFactory.eINSTANCE.createUserUnit();
		userUnit.setName("userUnit");
		userUnit.getOnlyDependencyCapabilities().add(user);
		top.getUnits().add(userUnit);

		UserGroup userGroup = OsFactory.eINSTANCE.createUserGroup();
		userGroup.setName("userGroup");

		UserGroupUnit userGroupUnit = OsFactory.eINSTANCE.createUserGroupUnit();
		userGroupUnit.setName("userGroupUnit");
		userGroupUnit.getOnlyDependencyCapabilities().add(userGroup);
		top.getUnits().add(userGroupUnit);

		res.save(null);

		// Load resource, check contents
		res.unload();

		res.load(Collections.EMPTY_MAP);
		DeployCoreRoot deployCoreRoot = (DeployCoreRoot) res.getContents().get(
				0);
		Topology topology = deployCoreRoot.getTopology();
		assertNotNull(topology);

		res.unload();

		doTemplateLoad("platform:/plugin/com.ibm.ccl.soa.deploy.os/templates/Windows2000.template");
		doTemplateLoad("platform:/plugin/com.ibm.ccl.soa.deploy.os/templates/WindowsUser.template");
		doTemplateLoad("platform:/plugin/com.ibm.ccl.soa.deploy.os/templates/WindowsUserGroup.template");
		doTemplateLoad("platform:/plugin/com.ibm.ccl.soa.deploy.os/templates/PortConfig.template");
		doTemplateLoad("platform:/plugin/com.ibm.ccl.soa.deploy.os/templates/WindowsXP.template");
		doTemplateLoad("platform:/plugin/com.ibm.ccl.soa.deploy.os/templates/WindowsServer2003.template");
	}

	/**
	 * @param templateURIString
	 * @throws IOException
	 */
	private void doTemplateLoad(String templateURIString) throws IOException {
		URI templateURI = URI.createURI(templateURIString);
		Resource resource = JEMUtilPlugin.getPluginResourceSet().getResource(
				templateURI, true);

		resource.load(Collections.EMPTY_MAP);
		DeployCoreRoot deployCoreRoot = (DeployCoreRoot) resource.getContents()
				.get(0);
		Topology topology = deployCoreRoot.getTopology();
		assertNotNull(topology);
		resource.unload();
	}

	/**
	 * @param link
	 */
	public static void createLinkName(HostingLink link) {
		String name;
		name = "hosted" + link.getHost().getName() + "In"
				+ link.getHosted().getName();
		link.setName(name);
	}

	/**
	 * @param hoster
	 * @param hostee
	 * @return hosting link linking hoster and hostee
	 */
	protected static HostingLink hosts(Unit hoster, Unit hostee) {
		assert hoster != null;
		assert hostee != null;
		assert hoster != hostee;

		HostingLink hl = CoreFactory.eINSTANCE.createHostingLink();
		hl.setHosted(hostee);
		hoster.getHostingLinks().add(hl);
		createLinkName(hl);
		return hl;
	}
}
