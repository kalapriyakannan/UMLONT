/*******************************************************************************
 * Copyright (c) 2003, 2007 IBM Corporation Licensed Material - Property of IBM. All rights reserved.
 *  
 * US Government Users Restricted Rights - Use, duplication or disclosure v1.0 restricted by GSA ADP
 * Schedule Contract with IBM Corp.
 * 
 * Contributors: IBM Corporation - initial API and implementation
 *******************************************************************************/
package com.ibm.ccl.soa.deploy.tests.domains;

import java.util.Collections;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.jem.util.emf.workbench.WorkbenchResourceHelperBase;

import com.ibm.ccl.soa.deploy.core.CoreFactory;
import com.ibm.ccl.soa.deploy.core.DeployCoreRoot;
import com.ibm.ccl.soa.deploy.core.FileArtifact;
import com.ibm.ccl.soa.deploy.core.HostingLink;
import com.ibm.ccl.soa.deploy.core.Requirement;
import com.ibm.ccl.soa.deploy.core.RequirementLinkTypes;
import com.ibm.ccl.soa.deploy.core.Topology;
import com.ibm.ccl.soa.deploy.core.validator.expression.Equals;
import com.ibm.ccl.soa.deploy.j2ee.EarModule;
import com.ibm.ccl.soa.deploy.j2ee.J2eeFactory;
import com.ibm.ccl.soa.deploy.java.JDK;
import com.ibm.ccl.soa.deploy.java.JDKUnit;
import com.ibm.ccl.soa.deploy.java.JRE;
import com.ibm.ccl.soa.deploy.java.JREEdition;
import com.ibm.ccl.soa.deploy.java.JREUnit;
import com.ibm.ccl.soa.deploy.java.JREVersion;
import com.ibm.ccl.soa.deploy.java.JavaFactory;
import com.ibm.ccl.soa.deploy.java.JavaPackage;
import com.ibm.ccl.soa.deploy.java.JdbcProvider;
import com.ibm.ccl.soa.deploy.java.JdbcProviderUnit;
import com.ibm.ccl.soa.deploy.was.WasFactory;
import com.ibm.ccl.soa.deploy.was.WebsphereAppServerUnit;

/**
 * @since 1.0
 * 
 */
public class JavaDomainTest extends DomainTestCase {

	private static final String PROJECT_NAME = "JavaDomainTest";

	/**
	 * 
	 */
	public JavaDomainTest() {
		super(PROJECT_NAME);
	}

	/**
	 * @throws Exception
	 */
	public void testJavaDomain() throws Exception {

		/**
		 * Setup
		 */
		URI uri = URI
				.createPlatformResourceURI(PROJECT_NAME + "/java.topology");
		Resource res = WorkbenchResourceHelperBase.createResource(uri);
		DeployCoreRoot root = CoreFactory.eINSTANCE.createDeployCoreRoot();
		res.getContents().add(root);
		Topology top = CoreFactory.eINSTANCE.createTopology();
		top.setName("Java Topology");

		root.setTopology(top);

		// Create test ear module
		EarModule earMod = J2eeFactory.eINSTANCE.createEarModule();
		earMod.setName("TestEAR");
		top.getUnits().add(earMod);

		top.getUnits().add(earMod);

		// Add a jar to the ear
		FileArtifact jarArt = CoreFactory.eINSTANCE.createFileArtifact();
		jarArt.setName("TestJar1");
		jarArt.setDisplayName("Test Jar");
		jarArt.getFileURIs().add("test.jar");

		earMod.getArtifacts().add(jarArt);

		// Require a JRE service on the ear
		Requirement requiredJREService = CoreFactory.eINSTANCE
				.createRequirement();
		requiredJREService.setName("consJreServ");
		requiredJREService.setDisplayName("required JRE Capability");
		requiredJREService.setDmoEType(JavaPackage.Literals.JRE);
		requiredJREService.setLinkType(RequirementLinkTypes.HOSTING_LITERAL);
		requiredJREService.getExpressions().add(
				Equals.createExpression(JavaPackage.Literals.JRE__JRE_VERSION,
						JREVersion._141_LITERAL));
		requiredJREService.getExpressions().add(
				Equals.createExpression(JavaPackage.Literals.JRE__JRE_EDITION,
						JREEdition.ENTERPRISE_LITERAL));

		earMod.getRequirements().add(requiredJREService);

		// Create JDK Unit
		JDKUnit jdkUnit = JavaFactory.eINSTANCE.createJDKUnit();
		jdkUnit.setName("JdkUnit1");
		jdkUnit.setDisplayName("TestJDKUnit");
		top.getUnits().add(jdkUnit);

		JDK jdkService = JavaFactory.eINSTANCE.createJDK();
		jdkService.setName("JDKServ1");
		jdkService.setDisplayName("JDK Capability");
		jdkService.setJdkVersion(JREVersion._141_LITERAL);
		jdkUnit.getHostingOrAnyCapabilities().add(jdkService);

		// Create JRE Unit
		JREUnit jreUnit = JavaFactory.eINSTANCE.createJREUnit();
		jreUnit.setName("JreUnit1");
		jreUnit.setDisplayName("TestJREUnit");
		top.getUnits().add(jreUnit);

		JRE providedJreService = JavaFactory.eINSTANCE.createJRE();
		providedJreService.setName("JREServ1");
		providedJreService.setDisplayName("JRE Capability");
		providedJreService.setJreVersion(JREVersion._141_LITERAL);
		providedJreService.setJreEdition(JREEdition.ENTERPRISE_LITERAL);
		jreUnit.getHostingOrAnyCapabilities().add(providedJreService);

		// Create JDBCProvider Unit
		JdbcProviderUnit jdbcProviderUnit = JavaFactory.eINSTANCE
				.createJdbcProviderUnit();
		jdbcProviderUnit.setName("JDBCProviderUnit1");
		jdbcProviderUnit.setDisplayName("TestJDBCProviderUnit");
		top.getUnits().add(jdbcProviderUnit);

		JdbcProvider jdbcProviderService = JavaFactory.eINSTANCE
				.createJdbcProvider();
		jdbcProviderService.setName("JDBCProv1");
		jdbcProviderService.setDisplayName("Test JDBC Provider Capability");
		jdbcProviderService.setProviderType("2");
		jdbcProviderService
				.setImplementationClassName("MyJDBCProviderImplementation");
		jdbcProviderService.setClasspath("My jdbc provider classpath");
		jdbcProviderService.setNativepath("My jdbc provider nativepath");
		jdbcProviderUnit.getOnlyDependencyCapabilities().add(
				jdbcProviderService);

		WebsphereAppServerUnit wasAppServer = WasFactory.eINSTANCE
				.createWebsphereAppServerUnit();
		wasAppServer.setDisplayName("MyWas51Server");
		wasAppServer.setName("was51_1");

		// Provide a JRE service on the was server
		JRE providededJREService = JavaFactory.eINSTANCE.createJRE();
		providededJREService.setName("provJreServ");
		providededJREService.setDisplayName("provided JRE Capability");
		providededJREService.setJreVersion(JREVersion._141_LITERAL);
		providededJREService.setJreEdition(JREEdition.ENTERPRISE_LITERAL);
		wasAppServer.getHostingOrAnyCapabilities().add(providededJREService);

		top.getUnits().add(wasAppServer);

		// hosting link connecting ear module to was51 server node
		HostingLink jreServLink = CoreFactory.eINSTANCE.createHostingLink();
		jreServLink.setName("jreHostLink1");
		jreServLink.setHosted(earMod);
		wasAppServer.getHostingLinks().add(jreServLink);

		res.save(null);

		// Load resource, check contents
		res.unload();

		res.load(Collections.EMPTY_MAP);
		DeployCoreRoot deployCoreRoot = (DeployCoreRoot) res.getContents().get(
				0);
		Topology topology = deployCoreRoot.getTopology();
		assertNotNull(topology);
		// Not a valid topology
// assertNoValidationErrors(topology);
	}

}
