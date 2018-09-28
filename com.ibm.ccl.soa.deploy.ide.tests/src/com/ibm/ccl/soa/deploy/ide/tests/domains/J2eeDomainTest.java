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

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.jem.util.emf.workbench.WorkbenchResourceHelperBase;

import com.ibm.ccl.soa.deploy.core.CapabilityLinkTypes;
import com.ibm.ccl.soa.deploy.core.CoreFactory;
import com.ibm.ccl.soa.deploy.core.DependencyLink;
import com.ibm.ccl.soa.deploy.core.DeployCoreRoot;
import com.ibm.ccl.soa.deploy.core.HostingLink;
import com.ibm.ccl.soa.deploy.core.Requirement;
import com.ibm.ccl.soa.deploy.core.RequirementLinkTypes;
import com.ibm.ccl.soa.deploy.core.Topology;
import com.ibm.ccl.soa.deploy.core.constraint.ConstraintFactory;
import com.ibm.ccl.soa.deploy.core.constraint.EqualsConstraint;
import com.ibm.ccl.soa.deploy.j2ee.J2eeFactory;
import com.ibm.ccl.soa.deploy.j2ee.J2eePackage;
import com.ibm.ccl.soa.deploy.j2ee.JSPContainer;
import com.ibm.ccl.soa.deploy.j2ee.JSPContainerVersion;
import com.ibm.ccl.soa.deploy.j2ee.WebModule;
import com.ibm.ccl.soa.deploy.j2ee.WebModuleCapability;
import com.ibm.ccl.soa.deploy.j2ee.util.J2EECapabilityUtils;
import com.ibm.ccl.soa.deploy.java.JavaFactory;
import com.ibm.ccl.soa.deploy.java.JdbcProvider;
import com.ibm.ccl.soa.deploy.java.JdbcProviderUnit;
import com.ibm.ccl.soa.deploy.java.util.JavaCapabilityUtils;
import com.ibm.ccl.soa.deploy.tests.domains.DomainTestCase;
import com.ibm.ccl.soa.deploy.tests.workspaces.TomcatTestWorkspace;
import com.ibm.ccl.soa.deploy.tomcat.Tomcat50Datasource;
import com.ibm.ccl.soa.deploy.tomcat.TomcatDatasourceUnit;
import com.ibm.ccl.soa.deploy.tomcat.TomcatFactory;
import com.ibm.ccl.soa.deploy.tomcat.TomcatWebServerUnit;

/**
 * @since 1.0 This is a J2EE Domain Testcase. All J2EE domain additions should
 *        be tested in this.
 */
public class J2eeDomainTest extends DomainTestCase {

	private static final String PROJECT_NAME = "J2eeDomainTest";
	private final String CONTEXT_ROOT = "webContextRoot";
	private final String PROV_NAME = "test JDBC provider";
	private final String DS_NAME = "TomcatDatasource";
	private final String WEBMOD_MODNAME = "WebModule Module Name";

	/**
	 * 
	 */
	public J2eeDomainTest() {
		super(PROJECT_NAME);
	}

	/**
	 * @throws Exception
	 * @throws IOException
	 */
	public void testJ2eeDomain() throws Exception {

		/**
		 * Setup
		 */
		URI uri = URI
				.createPlatformResourceURI(PROJECT_NAME + "/j2ee.topology");
		Resource res = WorkbenchResourceHelperBase.createResource(uri);
		DeployCoreRoot root = CoreFactory.eINSTANCE.createDeployCoreRoot();
		res.getContents().add(root);
		Topology top = CoreFactory.eINSTANCE.createTopology();
		top.setName("J2ee Topology");

		root.setTopology(top);

		// // Create test web module
		WebModule webMod = J2eeFactory.eINSTANCE.createWebModule();
		webMod.setName("TestWebMod");
		top.getUnits().add(webMod);

		// Add a webModule capability to the web module
		WebModuleCapability webCap = J2eeFactory.eINSTANCE
				.createWebModuleCapability();
		webCap.setName("WebModule Capability");
		webCap.setModuleName(WEBMOD_MODNAME);
		webCap.setContextRoot(CONTEXT_ROOT);
		webMod.getCapabilities().add(webCap);

		// Consume a data source service on the web module
		Requirement requiredDSCapability = CoreFactory.eINSTANCE
				.createRequirement();
		requiredDSCapability.setName("requiredDSCapability");
		requiredDSCapability.setDmoEType(J2eePackage.Literals.J2EE_DATASOURCE);
		requiredDSCapability
				.setLinkType(RequirementLinkTypes.DEPENDENCY_LITERAL);
		requiredDSCapability.getConstraints().add(
				createEqualsConstraint(
						"jndiName",
						"derby_jndi_name"));
		webMod.getRequirements().add(requiredDSCapability);

		// Require a JSP capability on the web module
		Requirement requiredJSPCapability = CoreFactory.eINSTANCE
				.createRequirement();
		requiredJSPCapability.setName("reqJspServ");
		requiredJSPCapability.setDisplayName("required JSP Capability");
		requiredJSPCapability.setDmoEType(J2eePackage.Literals.JSP_CONTAINER);
		requiredJSPCapability.setLinkType(RequirementLinkTypes.HOSTING_LITERAL);
		requiredJSPCapability.getConstraints().add(
				createEqualsConstraint(
						"containerVersion",
						"1.2"));				
		webMod.getRequirements().add(requiredJSPCapability);

		// Require a JSP capability on the web module
		Requirement requiredJ2EECapability = CoreFactory.eINSTANCE
				.createRequirement();
		requiredJSPCapability.setName("reqJ2eeCont");
		requiredJSPCapability.setDisplayName("required J2ee Capability");
		requiredJSPCapability.setDmoEType(J2eePackage.Literals.J2EE_CONTAINER);
		requiredJSPCapability.setLinkType(RequirementLinkTypes.HOSTING_LITERAL);
		requiredJSPCapability.getConstraints().add(
				createEqualsConstraint(
						"containerVersion",
						"1.4"));
		webMod.getRequirements().add(requiredJ2EECapability);

		// Create tomcat 41 server
		TomcatWebServerUnit tc41unit = TomcatFactory.eINSTANCE
				.createTomcatWebServerUnit();
		tc41unit.setName("tc41server");
		top.getUnits().add(tc41unit);

		JSPContainer providedJSPService = J2eeFactory.eINSTANCE
				.createJSPContainer();
		providedJSPService.setName("provJspServ");
		providedJSPService.setDisplayName("prov JSP Capability");
		providedJSPService.setContainerVersion(JSPContainerVersion._12_LITERAL);
		providedJSPService.setLinkType(CapabilityLinkTypes.ANY_LITERAL);
		tc41unit.getCapabilities().add(providedJSPService);

		HostingLink hostLink1 = CoreFactory.eINSTANCE.createHostingLink();
		hostLink1.setHosted(webMod);
		hostLink1.setName("host link 1");
		tc41unit.getHostingLinks().add(hostLink1);

		// Create Datasource unit
		TomcatDatasourceUnit tomcatDSUnit = TomcatFactory.eINSTANCE
				.createTomcatDatasourceUnit();
		tomcatDSUnit.setName("TomcatDSUnit");
		top.getUnits().add(tomcatDSUnit);

		Tomcat50Datasource tomcat50DS = TomcatFactory.eINSTANCE
				.createTomcat50Datasource();
		tomcat50DS.setName("tomcat50DSServices");
		tomcat50DS.setJndiName(TomcatTestWorkspace.DERBY_JNDI_NAME);
		tomcat50DS.setDatasourceName(DS_NAME);
		tomcatDSUnit.getCapabilities().add(tomcat50DS);

		DependencyLink dslink = CoreFactory.eINSTANCE.createDependencyLink();
		dslink.setName("dslink");
		dslink.setTarget(tomcat50DS);
		requiredDSCapability.setLink(dslink);

		// Create provider unit (not really valid for tomcat, but ok for testing
		// APIs.)
		JdbcProviderUnit prov = JavaFactory.eINSTANCE.createJdbcProviderUnit();
		prov.setName("JDBCProvUnit");
		top.getUnits().add(prov);

		JdbcProvider provCap = JavaFactory.eINSTANCE.createJdbcProvider();
		provCap.setName("testprov");
		provCap.setProviderName(PROV_NAME);
		prov.getCapabilities().add(provCap);

		// Create unit - don't set name
		JdbcProviderUnit prov1 = JavaFactory.eINSTANCE.createJdbcProviderUnit();
		WebModule webMod1 = J2eeFactory.eINSTANCE.createWebModule();

		// Test J2EE utility APIs
		assert J2EECapabilityUtils.getContextRoot(webMod) == CONTEXT_ROOT;
		assert J2EECapabilityUtils.getDatasourceName(webMod) == null;
		assert J2EECapabilityUtils.getDatasourceName(tomcatDSUnit) == DS_NAME;
		assert JavaCapabilityUtils.getProviderName(prov) == PROV_NAME;
		assert JavaCapabilityUtils.getProviderName(prov1) == null;
		assert J2EECapabilityUtils.getContextRoot(webMod1) == null;
		assert J2EECapabilityUtils.getModuleName(webMod) == WEBMOD_MODNAME;
		assert J2EECapabilityUtils.getModuleName(webMod1) == null;

		res.save(null);

		// Load resource, check contents
		res.unload();

		res.load(Collections.EMPTY_MAP);
		DeployCoreRoot deployCoreRoot = (DeployCoreRoot) res.getContents().get(
				0);
		Topology topology = deployCoreRoot.getTopology();
		assertNotNull(topology);

		// Load all templates. Loader tests for validity against schema

		// assertNoValidationErrors(topology);
		res.unload();

	}
	private EqualsConstraint createEqualsConstraint(String attribute,
			String value) {
		EqualsConstraint constraint = ConstraintFactory.eINSTANCE
				.createEqualsConstraint();
		constraint.setAttributeName(attribute);
		constraint.setValue(value);
		return constraint;
	}
}
