/*******************************************************************************
 * Copyright (c) 2003, 2007 IBM Corporation Licensed Material - Property of IBM. All rights reserved.
 *  
 * US Government Users Restricted Rights - Use, duplication or disclosure v1.0 restricted by GSA ADP
 * Schedule Contract with IBM Corp.
 * 
 * Contributors: IBM Corporation - initial API and implementation
 *******************************************************************************/
package com.ibm.ccl.soa.deploy.ide.tests.provider;

import java.util.Iterator;
import java.util.List;

import junit.framework.TestSuite;

import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.emf.common.util.EList;

import com.ibm.ccl.soa.deploy.core.Capability;
import com.ibm.ccl.soa.deploy.core.TopologyUnitStub;
import com.ibm.ccl.soa.deploy.core.UnitProvider;
import com.ibm.ccl.soa.deploy.core.extension.IUnitProviderService;
import com.ibm.ccl.soa.deploy.core.ui.DeployCoreUIPlugin;
import com.ibm.ccl.soa.deploy.j2ee.J2eeFactory;
import com.ibm.ccl.soa.deploy.j2ee.URLService;
import com.ibm.ccl.soa.deploy.j2ee.WebModule;
import com.ibm.ccl.soa.deploy.j2ee.internal.provider.J2EEModuleUnitProvider;

public class ServletCapabilityProviderTests extends CapabilityProviderTests {

	public ServletCapabilityProviderTests(String name) {
		super(name);
	}

	public static TestSuite suite() {
		TestSuite suite = new TestSuite();
		suite.addTest(new ServletCapabilityProviderTests("testValidServlets"));
		return suite;
	}

	public void testValidServlets() {

		IUnitProviderService unitProviderService = DeployCoreUIPlugin
				.getDefault().getUnitProviderService();

		UnitProvider[] providers = unitProviderService
				.findEnabledProvidersByInputOnly(testWebProject);

		J2EEModuleUnitProvider j2eeProvider = null;
		for (int i = 0; i < providers.length && (j2eeProvider == null); i++) {
			if (providers[i] instanceof J2EEModuleUnitProvider) {
				j2eeProvider = (J2EEModuleUnitProvider) providers[i];
			}
		}

		assertTrue(j2eeProvider != null);

		// construct an expected array with a boolean flag for found or not
		// found
		URLService[] expectedObjects = new URLService[3];
		boolean[] expectedObjectsFound = new boolean[] { false, false, false };

		expectedObjects[0] = J2eeFactory.eINSTANCE.createURLService();
		expectedObjects[0].setDescription("A simple HelloWorld Servlet");
		expectedObjects[0].setDisplayName("HelloWorld");
		expectedObjects[0].setMutable(false);
		expectedObjects[0].setName("HelloWorld");
		expectedObjects[0].setVersion("1.0.0");
		expectedObjects[0].getUrlPattern().add("/HelloWorld");

		expectedObjects[1] = J2eeFactory.eINSTANCE.createURLService();
		expectedObjects[1].setDescription(null);
		expectedObjects[1].setDisplayName("Apache-Axis Servlet");
		expectedObjects[1].setMutable(false);
		expectedObjects[1].setName("AxisServlet");
		expectedObjects[1].setVersion("1.0.0");
		expectedObjects[1].getUrlPattern().add("/servlet/AxisServlet");

		expectedObjects[2] = J2eeFactory.eINSTANCE.createURLService();
		expectedObjects[2].setDescription(null);
		expectedObjects[2].setDisplayName("Axis Admin Servlet");
		expectedObjects[2].setMutable(false);
		expectedObjects[2].setName("AdminServlet");
		expectedObjects[2].setVersion("1.0.0");
		expectedObjects[2].getUrlPattern().add("/servlet/AdminServlet");

		TopologyUnitStub[] stubs = j2eeProvider.resolveStubs(testWebProject);

		for (int i = 0; i < stubs.length; i++) {

			Object[] units = j2eeProvider.resolveUnit(stubs[i], false,
					new NullProgressMonitor());

			for (int j = 0; j < units.length; j++) {
				if (units[j] instanceof WebModule) {
					WebModule module = (WebModule) units[j];
					List capabilities = module.getCapabilities();
					for (Iterator iter = capabilities.iterator(); iter
							.hasNext();) {
						Capability capability = (Capability) iter.next();
						if (capability instanceof URLService) {
							URLService actual = (URLService) capability;
							for (int k = 0; k < expectedObjects.length; k++) {
								if (expectedObjects[k].getName().equals(
										actual.getName())) {
									assertEquals(expectedObjects[k], actual);
									expectedObjectsFound[k] = true;
									break; // exit expected objects for loop.
								}
							}
						}

					}
					break; // break unit for loop
				}
			}
		}

		for (int i = 0; i < expectedObjectsFound.length; i++) {
			assertTrue(expectedObjectsFound[i]);
		}

	}

	public void assertEquals(URLService expected, URLService actual) {
		super.assertEquals(expected, actual);

		EList expectedPatterns = expected.getUrlPattern();
		EList actualPatterns = actual.getUrlPattern();
		assertEquals(expectedPatterns.size(), actualPatterns.size());
		for (Iterator iter = expectedPatterns.iterator(); iter.hasNext();) {
			actualPatterns.contains(iter.next());
		}

// URLInterface expectedInterface = (URLInterface) expected.getInterface();
// URLInterface actualInterface = (URLInterface) actual.getInterface();
//		
// assertEquals(expectedInterface, actualInterface);
	}

}
