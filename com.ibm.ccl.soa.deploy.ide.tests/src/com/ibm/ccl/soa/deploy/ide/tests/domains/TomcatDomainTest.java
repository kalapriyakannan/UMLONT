/*******************************************************************************
 * Copyright (c) 2003, 2007 IBM Corporation Licensed Material - Property of IBM. All rights reserved.
 *  
 * US Government Users Restricted Rights - Use, duplication or disclosure v1.0 restricted by GSA ADP
 * Schedule Contract with IBM Corp.
 * 
 * Contributors: IBM Corporation - initial API and implementation
 *******************************************************************************/
package com.ibm.ccl.soa.deploy.ide.tests.domains;

import java.util.Collections;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.jem.util.emf.workbench.WorkbenchResourceHelperBase;

import com.ibm.ccl.soa.deploy.core.CoreFactory;
import com.ibm.ccl.soa.deploy.core.DependencyLink;
import com.ibm.ccl.soa.deploy.core.DeployCoreRoot;
import com.ibm.ccl.soa.deploy.core.IResourceTypeConstants;
import com.ibm.ccl.soa.deploy.core.Requirement;
import com.ibm.ccl.soa.deploy.core.RequirementLinkTypes;
import com.ibm.ccl.soa.deploy.core.Topology;
import com.ibm.ccl.soa.deploy.core.Unit;
import com.ibm.ccl.soa.deploy.core.constraint.ConstraintFactory;
import com.ibm.ccl.soa.deploy.core.constraint.EqualsConstraint;
import com.ibm.ccl.soa.deploy.core.extension.ExtensionsCore;
import com.ibm.ccl.soa.deploy.core.extension.IResourceTypeService;
import com.ibm.ccl.soa.deploy.core.test.validator.utils.ValidatorTestUtils;
import com.ibm.ccl.soa.deploy.core.util.CapabilityUtil;
import com.ibm.ccl.soa.deploy.internal.core.extension.ResourceTypeService;
import com.ibm.ccl.soa.deploy.j2ee.J2eeFactory;
import com.ibm.ccl.soa.deploy.j2ee.J2eePackage;
import com.ibm.ccl.soa.deploy.j2ee.JSPContainer;
import com.ibm.ccl.soa.deploy.j2ee.JSPContainerVersion;
import com.ibm.ccl.soa.deploy.j2ee.WebModule;
import com.ibm.ccl.soa.deploy.tests.domains.DomainTestCase;
import com.ibm.ccl.soa.deploy.tests.workspaces.TomcatTestWorkspace;
import com.ibm.ccl.soa.deploy.tomcat.Tomcat50Datasource;
import com.ibm.ccl.soa.deploy.tomcat.TomcatDatasourceUnit;
import com.ibm.ccl.soa.deploy.tomcat.TomcatFactory;
import com.ibm.ccl.soa.deploy.tomcat.TomcatPackage;
import com.ibm.ccl.soa.deploy.tomcat.TomcatServer;
import com.ibm.ccl.soa.deploy.tomcat.TomcatWebServerUnit;

/**
 * @since 1.0
 * 
 */
public class TomcatDomainTest extends DomainTestCase {

	private static final String PROJECT_NAME = "TomcatDomainTest";

	private static final String TOMCAT32_RESOURCE_ID = "tomcat.webserver.32";
	private static final String TOMCAT40_RESOURCE_ID = "tomcat.webserver.40";
	private static final String TOMCAT41_RESOURCE_ID = "tomcat.webserver.41";
	private static final String TOMCAT50_RESOURCE_ID = "tomcat.webserver.50";
	private static final String TOMCAT55_RESOURCE_ID = "tomcat.webserver.55";
	private static final String TOMCAT50_DS_RESOURCE_ID = "tomcat.datasource.50";

	private static final String TOMCAT55_WTP_RUNTIME_ID = "org.eclipse.jst.server.tomcat.runtime.55";
	private static final String TOMCAT50_WTP_RUNTIME_ID = "org.eclipse.jst.server.tomcat.runtime.50";
	private static final String TOMCAT41_WTP_RUNTIME_ID = "org.eclipse.jst.server.tomcat.runtime.41";
	private static final String TOMCAT40_WTP_RUNTIME_ID = "org.eclipse.jst.server.tomcat.runtime.40";
	private static final String TOMCAT32_WTP_RUNTIME_ID = "org.eclipse.jst.server.tomcat.runtime.32";

	private IResourceTypeService rts = ExtensionsCore.createResourceTypeService();
	/**
	 * 
	 */
	public TomcatDomainTest() {
		super(PROJECT_NAME);
	}

	/**
	 * @throws Exception
	 */
	public void testTomcatDomain() throws Exception {

		/**
		 * Setup
		 */
		URI uri = URI.createPlatformResourceURI(PROJECT_NAME
				+ "/tomcat.topology");
		Resource res = WorkbenchResourceHelperBase.createResource(uri);
		DeployCoreRoot root = CoreFactory.eINSTANCE.createDeployCoreRoot();
		res.getContents().add(root);
		Topology top = CoreFactory.eINSTANCE.createTopology();
		top.setName("Tomcat Topology");

		root.setTopology(top);

		// // Create test web module
		WebModule webMod = J2eeFactory.eINSTANCE.createWebModule();
		webMod.setName("TestWebMod");
		top.getUnits().add(webMod);

		// Require a data source service on the web module
		Requirement requiredDS = CoreFactory.eINSTANCE.createRequirement();
		requiredDS.setName("requiredDS");
		requiredDS.setDmoEType(J2eePackage.Literals.J2EE_DATASOURCE);
		requiredDS.setLinkType(RequirementLinkTypes.DEPENDENCY_LITERAL);
		requiredDS.getConstraints().add(createEqualsConstraint(
				"j2ee_datasource_jndi_name",
		"derby_jndi_name"));
		webMod.getRequirements().add(requiredDS);

		// Require a JSP service on the web module
		Requirement requiredJSP = CoreFactory.eINSTANCE.createRequirement();
		requiredJSP.setName("requiredJSP");
		requiredJSP.setDisplayName("required JSP");
		requiredJSP.setLinkType(RequirementLinkTypes.HOSTING_LITERAL);
		requiredJSP.setDmoEType(J2eePackage.Literals.JSP_CONTAINER);
		requiredJSP.getConstraints().add(
				createEqualsConstraint(
						"jsp_container_container_version",
						"1.2"));
		webMod.getRequirements().add(requiredJSP);

		// // Create tomcat datasource unit
		TomcatDatasourceUnit tcDataSourceUnit = TomcatFactory.eINSTANCE
				.createTomcatDatasourceUnit();
		tcDataSourceUnit.setName("tcDataSourceUnit");
		top.getUnits().add(tcDataSourceUnit);

		// Require tomcat service on data source unit
		Requirement requiredServer = CoreFactory.eINSTANCE.createRequirement();
		requiredServer.setName("requiredTomcatServer");
		requiredServer.setDmoEType(TomcatPackage.Literals.TOMCAT_SERVER);
		requiredServer.setLinkType(RequirementLinkTypes.HOSTING_LITERAL);
		requiredServer.getConstraints().add(
				createEqualsConstraint(
						"tomcat_server_tomcat_version",
						"5.0"));
		tcDataSourceUnit.getRequirements().add(requiredServer);

		// Provide a tomcat 5 data source service on tomcat data source unit
		Tomcat50Datasource provTC5DSService = TomcatFactory.eINSTANCE
				.createTomcat50Datasource();
		provTC5DSService.setName("provDataSourceService");
		provTC5DSService.setDatasourceName("provDataSourceService");
		// TODO fix this now CHAD
		// provTC5DSService.setUrl(TomcatTestWorkspace.DERBY_URL);
		provTC5DSService.setJndiName(TomcatTestWorkspace.DERBY_JNDI_NAME);
		provTC5DSService.setUsername(TomcatTestWorkspace.DERBY_USER_NAME);
		provTC5DSService.setPassword(TomcatTestWorkspace.DERBY_PW_NAME);
		provTC5DSService
				.setDriverClassName(TomcatTestWorkspace.DERBY_CLASS_NAME);
		provTC5DSService.setClientJarLocation(TomcatTestWorkspace
				.getDerby10_1JarPath().toOSString());
		tcDataSourceUnit.getOnlyDependencyCapabilities().add(provTC5DSService);

		// // Create tomcat web server unit
		TomcatWebServerUnit tomcatServerUnit = TomcatFactory.eINSTANCE
				.createTomcatWebServerUnit();
		tomcatServerUnit.setName("tomcatServerUnit");
		top.getUnits().add(tomcatServerUnit);

		// Provide a JSP service on the tomcat server
		JSPContainer providededJSPService = J2eeFactory.eINSTANCE
				.createJSPContainer();
		providededJSPService.setName("provJspServ");
		providededJSPService.setDisplayName("provided JSP Capability");
		providededJSPService
				.setContainerVersion(JSPContainerVersion._12_LITERAL);
		tomcatServerUnit.getHostingOrAnyCapabilities()
				.add(providededJSPService);

		// provide tomcat server service on tomcat server
		TomcatServer tcService = TomcatFactory.eINSTANCE.createTomcatServer();
		tcService.setName("tomcatServerService");
		tcService.setTomcatVersion("5.0");
		tomcatServerUnit.getHostingOrAnyCapabilities().add(tcService);

		// Capability link between web module and data source
		DependencyLink servLink = CoreFactory.eINSTANCE.createDependencyLink();
		servLink.setName("dsServLink");
		servLink.setTarget(provTC5DSService);
		requiredDS.setLink(servLink);

		// host the web module on the tomcat server
		ValidatorTestUtils.hosts(tomcatServerUnit, webMod);

		// host the datasource unit on the tomcat server
		ValidatorTestUtils.hosts(tomcatServerUnit, tcDataSourceUnit);

		res.save(null);

		// Load resource, check contents
		res.unload();

		res.load(Collections.EMPTY_MAP);
		DeployCoreRoot deployCoreRoot = (DeployCoreRoot) res.getContents().get(
				0);
		Topology topology = deployCoreRoot.getTopology();
		assertNotNull(topology);

		// Load all templates. Loader tests for validity against schema
		doTemplateLoad(rts
				.getTemplateURI(TOMCAT32_RESOURCE_ID));
		doTemplateLoad(rts
				.getTemplateURI(TOMCAT40_RESOURCE_ID));
		doTemplateLoad(rts
				.getTemplateURI(TOMCAT41_RESOURCE_ID));
		doTemplateLoad(rts
				.getTemplateURI(TOMCAT50_RESOURCE_ID));
		doTemplateLoad(rts
				.getTemplateURI(TOMCAT55_RESOURCE_ID));
		doTemplateLoad(rts
				.getTemplateURI(TOMCAT50_DS_RESOURCE_ID));

		// Test WTP resource type bindings
		Unit unit = (Unit)rts.createUnitFromBindingId(
				TOMCAT55_WTP_RUNTIME_ID, IResourceTypeConstants.CONTEXT_WTP,
				topology);
		assert isCorrectTomcatUnit(unit, "5.5");

		unit = (Unit)rts.createUnitFromBindingId(
				TOMCAT50_WTP_RUNTIME_ID, IResourceTypeConstants.CONTEXT_WTP,
				topology);
		assert isCorrectTomcatUnit(unit, "5.0");

		unit = (Unit)rts.createUnitFromBindingId(
				TOMCAT41_WTP_RUNTIME_ID, IResourceTypeConstants.CONTEXT_WTP,
				topology);
		assert isCorrectTomcatUnit(unit, "4.1");

		unit = (Unit)rts.createUnitFromBindingId(
				TOMCAT40_WTP_RUNTIME_ID, IResourceTypeConstants.CONTEXT_WTP,
				topology);
		assert isCorrectTomcatUnit(unit, "4.0");

		unit = (Unit)rts.createUnitFromBindingId(
				TOMCAT32_WTP_RUNTIME_ID, IResourceTypeConstants.CONTEXT_WTP,
				topology);
		assert isCorrectTomcatUnit(unit, "3.2");

		res.unload();

	}

	private boolean isCorrectTomcatUnit(Unit unit, String version) {
		if (unit instanceof TomcatWebServerUnit) {
			TomcatServer cap = (TomcatServer) CapabilityUtil
					.findCapabilityOfType(unit, TomcatPackage.eINSTANCE
							.getTomcatServer());
			if (cap != null) {
				if (cap.getTomcatVersion().equals(version))
					return true;
			}
		}
		return false;
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
