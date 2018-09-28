/*******************************************************************************
 * Copyright (c) 2003, 2007 IBM Corporation Licensed Material - Property of IBM. All rights reserved.
 *  
 * US Government Users Restricted Rights - Use, duplication or disclosure v1.0 restricted by GSA ADP
 * Schedule Contract with IBM Corp.
 * 
 * Contributors: IBM Corporation - initial API and implementation
 *******************************************************************************/
package com.ibm.ccl.soa.deploy.ide.tests.provider;

import java.net.URL;
import java.util.Collections;

import junit.framework.TestCase;

import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.FileLocator;
import org.eclipse.core.runtime.IPath;
import org.eclipse.core.runtime.Path;

import com.ibm.ccl.soa.deploy.core.Service;
import com.ibm.ccl.soa.deploy.ide.tests.Activator;
import com.ibm.ccl.soa.deploy.ide.tests.util.ProjectUnzipUtil;

public class CapabilityProviderTests extends TestCase {

	private static final IPath TEST_DATA = new Path(
			"testData/TestWeb_Servlet+WS.zip");

	private static final String TEST_WEB_PROJECT_NAME = "TestWeb";

	private static final String TEST_WEB_CLIENT_PROJECT_NAME = "TestWebClient";

	protected IProject testWebProject;
	protected IProject testWebClientProject;

	public CapabilityProviderTests(String name) {
		super(name);
	}

	protected void setUp() throws Exception {
		super.setUp();

		testWebProject = ResourcesPlugin.getWorkspace().getRoot().getProject(
				TEST_WEB_PROJECT_NAME);
		testWebClientProject = ResourcesPlugin.getWorkspace().getRoot()
				.getProject(TEST_WEB_CLIENT_PROJECT_NAME);

		if (testWebProject.exists())
			testWebProject.delete(true, null);
		if (testWebClientProject.exists())
			testWebClientProject.delete(true, null);

		URL url = FileLocator.find(Activator.getDefault().getBundle(),
				TEST_DATA, Collections.EMPTY_MAP);

		ProjectUnzipUtil util = new ProjectUnzipUtil(new Path(FileLocator
				.toFileURL(url).getPath()), new String[] { "TestWeb",
				"TestWebClient" });
		assertTrue(util.createProjects());

	}

	protected void tearDown() throws Exception {
		super.tearDown();

		testWebProject.delete(true, null);
		testWebClientProject.delete(true, null);

	}

	public void assertEquals(Service expected, Service actual) {
		assertEquals(expected.getName(), actual.getName());
		assertEquals(expected.getDisplayName(), actual.getDisplayName());
		assertEquals(expected.getDescription(), actual.getDescription());
		assertEquals(expected.getVersion(), actual.getVersion());
		assertEquals(expected.isMutable(), actual.isMutable());

	}

}
