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

import com.ibm.ccl.soa.deploy.core.Capability;
import com.ibm.ccl.soa.deploy.core.TopologyUnitStub;
import com.ibm.ccl.soa.deploy.core.UnitProvider;
import com.ibm.ccl.soa.deploy.core.extension.IUnitProviderService;
import com.ibm.ccl.soa.deploy.core.ui.DeployCoreUIPlugin;
import com.ibm.ccl.soa.deploy.j2ee.J2eeFactory;
import com.ibm.ccl.soa.deploy.j2ee.WebModule;
import com.ibm.ccl.soa.deploy.j2ee.WebService;
import com.ibm.ccl.soa.deploy.j2ee.internal.provider.J2EEModuleUnitProvider;

public class WebServiceCapabilityProviderTests extends CapabilityProviderTests {

	public WebServiceCapabilityProviderTests(String name) {
		super(name);
	}

	public static TestSuite suite() {
		TestSuite suite = new TestSuite();
		suite.addTest(new WebServiceCapabilityProviderTests(
				"testValidWebServices"));
		return suite;
	}

	public void testValidWebServices() {

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
		WebService[] expectedObjects = new WebService[3];
		boolean[] expectedObjectsFound = new boolean[] { false, false };

		/*
		 * com.ibm.ccl.soa.deploy.j2ee.impl.WebServiceImpl@468c468c
		 * (description: null, displayName: HelloWorldSOAP.wsdl, mutable:
		 * <unset>, name: HelloWorldSOAP.wsdl) (buildVersion: null, linkType:
		 * <unset>, origin: null) (version: null) (endpoint: null)
		 */
		expectedObjects[0] = J2eeFactory.eINSTANCE.createWebService();
		// expectedObjects[0].setDescription(); Not set by provider
		expectedObjects[0].setDisplayName("HelloWorldSOAP.wsdl");
		expectedObjects[0].setMutable(false);
		expectedObjects[0].setName("HelloWorldSOAP.wsdl");
		expectedObjects[0].setVersion("1.0.0");

		/*
		 * com.ibm.ccl.soa.deploy.j2ee.impl.WebServiceImpl@47184718
		 * (description: null, displayName: HelloWorld.wsdl, mutable: <unset>,
		 * name: HelloWorld.wsdl) (buildVersion: null, linkType: <unset>,
		 * origin: null) (version: null) (endpoint: null)
		 */
		expectedObjects[1] = J2eeFactory.eINSTANCE.createWebService();
		// expectedObjects[1].setDescription(null); Not set by provider
		expectedObjects[1].setDisplayName("HelloWorld.wsdl");
		expectedObjects[1].setMutable(false);
		expectedObjects[1].setName("HelloWorld.wsdl");
		expectedObjects[1].setVersion("1.0.0");

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
						if (capability instanceof WebService) {
							WebService actual = (WebService) capability;
							System.out.println(actual);
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

	public void assertEquals(WebService expected, WebService actual) {
		super.assertEquals(expected, actual);

	}

}
