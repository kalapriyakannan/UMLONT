/*******************************************************************************
 * Copyright (c) 2003, 2007 IBM Corporation Licensed Material - Property of IBM. All rights reserved.
 *  
 * US Government Users Restricted Rights - Use, duplication or disclosure v1.0 restricted by GSA ADP
 * Schedule Contract with IBM Corp.
 * 
 * Contributors: IBM Corporation - initial API and implementation
 *******************************************************************************/
package com.ibm.ccl.soa.deploy.core.test;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import junit.framework.TestSuite;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.MultiStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.impl.AdapterImpl;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.EStructuralFeature.Setting;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.ecore.util.EContentAdapter;
import org.eclipse.emf.ecore.xmi.XMLResource;

import com.ibm.ccl.soa.deploy.core.Annotation;
import com.ibm.ccl.soa.deploy.core.Capability;
import com.ibm.ccl.soa.deploy.core.CapabilityLinkTypes;
import com.ibm.ccl.soa.deploy.core.ConstraintLink;
import com.ibm.ccl.soa.deploy.core.CoreFactory;
import com.ibm.ccl.soa.deploy.core.CorePackage;
import com.ibm.ccl.soa.deploy.core.DependencyLink;
import com.ibm.ccl.soa.deploy.core.DeployCorePlugin;
import com.ibm.ccl.soa.deploy.core.DeployCoreRoot;
import com.ibm.ccl.soa.deploy.core.FileArtifact;
import com.ibm.ccl.soa.deploy.core.HostingLink;
import com.ibm.ccl.soa.deploy.core.IConstants;
import com.ibm.ccl.soa.deploy.core.MemberLink;
import com.ibm.ccl.soa.deploy.core.Requirement;
import com.ibm.ccl.soa.deploy.core.RequirementLinkTypes;
import com.ibm.ccl.soa.deploy.core.Topology;
import com.ibm.ccl.soa.deploy.core.Unit;
import com.ibm.ccl.soa.deploy.core.impl.DeployLinkImpl;
import com.ibm.ccl.soa.deploy.core.util.CapabilityLinkTypeFilter;
import com.ibm.ccl.soa.deploy.core.validator.matcher.LinkFactory;

public class DeployCoreModelTest extends TopologyTestCase {

	private static final String PROJECT_NAME = "DeployCoreModelTest";

	public DeployCoreModelTest() {
		super(PROJECT_NAME);
	}

	public DeployCoreModelTest(String name) {
		super(name);
	}
	
	public static TestSuite suite() {
		
		TestSuite suite = new TestSuite();
		
		suite.addTestSuite(DeployCoreModelTest.class);
		//suite.addTest(new DeployCoreModelTest("testGetFullPathCache"));
		
		return suite;
		
	}
	
	/**
	 * Test the serialization and deserialization of a core model
	 * in a non-workbench file (not an IFile).
	 */
	public void testNonWorkbenchSerialization() throws Exception {
		File file = File.createTempFile(getClass().getName().replace('.', '_'), ".topology");
		try {
			// XML save & load options
			Map options = new HashMap();
			options.put(XMLResource.OPTION_EXTENDED_META_DATA, Boolean.TRUE);
			options.put(XMLResource.OPTION_SCHEMA_LOCATION, Boolean.TRUE);
			options.put(XMLResource.OPTION_USE_ENCODED_ATTRIBUTE_STYLE, Boolean.TRUE);
			options.put(XMLResource.OPTION_USE_LEXICAL_HANDLER, Boolean.TRUE);

			// Create an in-memory topology
			Topology top = CoreFactory.eINSTANCE.createTopology();
			top.setName("testTop");
			DeployCoreRoot root = CoreFactory.eINSTANCE.createDeployCoreRoot();
			root.setTopology(top);
			Unit u1 = addUnit(top, "u1");
			Requirement r1 = addRequirement(u1, "r1",
					RequirementLinkTypes.HOSTING_LITERAL);
			Unit u2 = addUnit(top, "u2");
			Capability c1 = super.addCapability(u2, "c1",
					CapabilityLinkTypes.HOSTING_LITERAL);
			HostingLink hl = LinkFactory.createHostingLink(u2, u1);

			// Create an in-memory resource to contain the deploy core root
			URI uri = URI.createFileURI(file.getAbsolutePath());
			ResourceSet rs = new ResourceSetImpl();
			Resource res = rs.createResource(uri);
			res.getContents().add(root);

			// Save & unload the resource
			res.save(options);
			res.unload();

			// Load the resource
			res.load(options);
			
			// Update references to the DMOs
			assertEquals(1, res.getContents().size());
			assertTrue(res.getContents().get(0) instanceof DeployCoreRoot);
			top = ((DeployCoreRoot) res.getContents().get(0)).getTopology();
			assertNotNull(top);
			assertEquals("testTop", top.getName());
			u1 = (Unit) top.resolve(u1.getFullPath());
			assertNotNull(u1);
			u2 = (Unit) top.resolve(u2.getFullPath());
			assertNotNull(u2);
			r1 = (Requirement) top.resolve(r1.getFullPath());
			assertNotNull(r1);
			c1 = (Capability) top.resolve(c1.getFullPath());
			assertNotNull(c1);
			hl = (HostingLink) top.resolve(hl.getFullPath());
			assertNotNull(hl);
			assertEquals(u1, hl.getHosted());
			assertEquals(u2, hl.getHost());
		} finally {
			file.delete();
		}
	}

	public void testDependencyLink() throws IOException {
		Topology top = createTopology("testDependencyLink");

		Unit unit1 = CoreFactory.eINSTANCE.createUnit();
		unit1.setName("unit1");
		assert unit1.getTopology() == null;
		top.getUnits().add(unit1);
		assert unit1.getTopology() == top;

		Requirement req = CoreFactory.eINSTANCE.createRequirement();
		req.setName("req");
		req.setLinkType(RequirementLinkTypes.DEPENDENCY_LITERAL);
		unit1.getRequirements().add(req);

		Unit unit2 = CoreFactory.eINSTANCE.createUnit();
		unit2.setName("unit2");
		top.getUnits().add(unit2);

		Capability cap = CoreFactory.eINSTANCE.createCapability();
		cap.setName("cap");
		cap.setLinkType(CapabilityLinkTypes.DEPENDENCY_LITERAL);
		unit2.getCapabilities().add(cap);

		DependencyLink link = CoreFactory.eINSTANCE.createDependencyLink();
		link.setName("dlink");
		link.setTarget(cap);
		link.setSource(req);
		assert req.equals(link.getSource());
		req.setLink(link);
		assertContains(top.findAllDeployModelObjects(), link);

		assert link.equals(req.getLink());
		assert req.equals(link.getSource());
		assert cap.equals(link.getTarget());
		assertSetEquals(top.findAllDependencyLinks(), new Object[] { link });

		validate(top);
		assertHasNoErrorStatus(top);

		// force error in link URI
		link.setTarget(null);
		((DeployLinkImpl) link).setTargetURI("/wrongURI");

		validate(top);
		assertHasErrorStatus(top);

		// fix error in link URI
		((DeployLinkImpl) link).setTargetURI(cap.getFullPath());
		validate(top);
		assertHasNoErrorStatus(top);

	}

	public void testHostingLink() throws IOException {
		Topology top = createTopology("testHostingLink");

		Unit unit1 = CoreFactory.eINSTANCE.createUnit();
		unit1.setName("unit1");
		assert unit1.getTopology() == null;
		top.getUnits().add(unit1);
		assert unit1.getTopology() == top;

		Unit unit2 = CoreFactory.eINSTANCE.createUnit();
		unit2.setName("unit2");
		top.getUnits().add(unit2);

		assert unit1.getHostingLinks().size() == 0;
		assert unit2.getHostingLinks().size() == 0;

		HostingLink hosting_link_u1_u2 = CoreFactory.eINSTANCE
				.createHostingLink();
		hosting_link_u1_u2.setName("hosting_link_u1_u2");
		hosting_link_u1_u2.setHosted(unit2);
		unit1.getHostingLinks().add(hosting_link_u1_u2);

		assert unit1.getHostingLinks().size() == 1;
		assert unit2.getHostingLinks().size() == 0;
		assert unit1.getHostingLinks().get(0).equals(hosting_link_u1_u2);
		assert unit1.getHostingLinks().indexOf(hosting_link_u1_u2) == 0;
		assert unit1.getContainedModelObjects().size() == 1;
		assert unit1.getContainedModelObjects().get(0).equals(
				hosting_link_u1_u2);
		assert top.findAllHostingLinks().next().equals(hosting_link_u1_u2);
		assert top.findHosts(unit1).length == 0;
		assert top.findHosts(unit2).length == 1;
		assert top.findHosts(unit2)[0] == unit1;

		//
		// Hosting link removal
		//

		unit1.getHostingLinks().remove(hosting_link_u1_u2);

		assert unit1.getHostingLinks().size() == 0;
		assert unit2.getHostingLinks().size() == 0;
		assert unit1.getContainedModelObjects().size() == 0;
		assert !top.findAllHostingLinks().hasNext();
		assert top.findHosts(unit1).length == 0;
		assert top.findHosts(unit2).length == 0;
	}

	public void testMemberLink() throws IOException {
		Topology top = createTopology("testMemberLink");

		Unit unit1 = CoreFactory.eINSTANCE.createUnit();
		unit1.setName("unit1");
		assert unit1.getTopology() == null;
		top.getUnits().add(unit1);
		assert unit1.getTopology() == top;

		Unit unit2 = CoreFactory.eINSTANCE.createUnit();
		unit2.setName("unit2");
		top.getUnits().add(unit2);

		assert unit1.getMemberLinks().size() == 0;
		assert unit2.getMemberLinks().size() == 0;

		MemberLink member_link_u1_u2 = CoreFactory.eINSTANCE.createMemberLink();
		member_link_u1_u2.setName("member_link_u1_u2");
		member_link_u1_u2.setSource(unit1);
		member_link_u1_u2.setTarget(unit2);
		unit1.getMemberLinks().add(member_link_u1_u2);

		assert unit1.getMemberLinks().size() == 1;
		assert unit2.getMemberLinks().size() == 0;
		assert unit1.getMemberLinks().get(0).equals(member_link_u1_u2);
		assert unit1.getMemberLinks().indexOf(member_link_u1_u2) == 0;
		assert unit1.getContainedModelObjects().size() == 1;
		assert unit1.getContainedModelObjects().get(0)
				.equals(member_link_u1_u2);
		// assert top.findAllHostingLinks().next().equals(hosting_link_u1_u2);
		assert top.findMemberOf(unit1).length == 0;
		assert top.findMemberOf(unit2).length == 1;
		assert top.findMemberOf(unit2)[0] == unit1;
		assert top.resolve(member_link_u1_u2.getFullPath()) == member_link_u1_u2 : member_link_u1_u2
				.getFullPath();

		//
		// test null name and resolution
		//
		member_link_u1_u2.setName(null);
		assert top.resolve(member_link_u1_u2.getFullPath()) == member_link_u1_u2 : member_link_u1_u2
				.getFullPath();
		member_link_u1_u2.setName("member_link_u1_u2");

		//
		// Member link removal
		//
		unit1.getMemberLinks().remove(member_link_u1_u2);

		assert unit1.getMemberLinks().size() == 0;
		assert unit2.getMemberLinks().size() == 0;
		assert unit1.getContainedModelObjects().size() == 0;
		assert !top.findAllHostingLinks().hasNext();
		assert top.findHosts(unit1).length == 0;
		assert top.findHosts(unit2).length == 0;
	}

	public void testHostingService() throws IOException {
		Topology top = createTopology("testHostingService");

		Unit unit1 = CoreFactory.eINSTANCE.createUnit();
		unit1.setName("unit1");
		assert unit1.getTopology() == null;
		top.getUnits().add(unit1);
		assert unit1.getTopology() == top;

		assert unit1.getRequirements().size() == 0;
		assert unit1.getOnlyDependencyRequirements().size() == 0;
		assert unit1.getHostingOrAnyCapabilities().size() == 0;
		assert unit1.getContainedModelObjects().size() == 0;

		Requirement u1_consumes_hosting = CoreFactory.eINSTANCE
				.createRequirement();
		u1_consumes_hosting.setName("u1_consumes_hosting");
		unit1.getOnlyHostingRequirements().add(u1_consumes_hosting);
		assert u1_consumes_hosting.getParent() == unit1;

		assert unit1.getRequirements().size() == 1;
		assert unit1.getOnlyDependencyRequirements().size() == 0;
		assert unit1.getOnlyHostingRequirements().size() == 1;
		assert unit1.getHostingOrAnyRequirements().size() == 1;
		assert unit1.getCapabilities().size() == 0;
		assert unit1.getContainedModelObjects().size() == 1 : unit1
				.getContainedModelObjects().size();
	}

	public void testDeployModelObjectGetAllContained() throws IOException {
		/**
		 * Topology:
		 * 
		 * <ul>
		 * <li> unit1
		 * <ul>
		 * <li> u1_provides &lt;- u2_consumes1
		 * <li> u1_provides_hosting
		 * </ul>
		 * <li> unit2
		 * <ul>
		 * <li> u2_provides
		 * <li> u2_consumes1 -&gt; u1_provides
		 * <li> u2_consumes2 -&gt; null
		 * <li> u2_consumes_hosting -&gt; null
		 * <li> unit2_1
		 * <li> unit2_2
		 * </ul>
		 */
		Topology top = createTopology("GetAllContained");
		Resource res = top.getEObject().eResource();

		assert top.getTopology() == top;

		assertSetEquals(top.findAllDeployModelObjects(), null);
		assertSetEquals(top.findAllUnits(), null);
		assertSetEquals(top.findAllCapabilities(), null);
		assertSetEquals(top.findAllNonHostingCapabilities(), null);
		assertSetEquals(top.findAllHostingCapabilities(), null);
		assertSetEquals(top.findAllDependencyLinks(), null);
		assertSetEquals(top.findAllHostingLinks(), null);

		// /////////////////////////////////////////////////////////////////////////////
		//
		// Create units:
		//
		Unit unit1 = CoreFactory.eINSTANCE.createUnit();
		unit1.setName("unit1");
		assert unit1.getTopology() == null;
		top.getUnits().add(unit1);
		assert unit1.getTopology() == top;

		Unit unit2 = CoreFactory.eINSTANCE.createUnit();
		unit2.setName("unit2");
		top.getUnits().add(unit2);

		assertSetEquals(top.findAllDeployModelObjects(), new Object[] { unit1,
				unit2 });
		assertSetEquals(top.findAllUnits(), new Object[] { unit1, unit2, });
		assertSetEquals(top.findAllCapabilities(), null);
		assertSetEquals(top.findAllNonHostingCapabilities(), null);
		assertSetEquals(top.findAllHostingCapabilities(), null);
		assertSetEquals(top.findAllDependencyLinks(), null);
		assertSetEquals(top.findAllHostingLinks(), null);

		// /////////////////////////////////////////////////////////////////////////////
		//
		// Create services
		//

		Capability u1_provides = CoreFactory.eINSTANCE.createCapability();
		u1_provides.setName("u1_provides");
		assert u1_provides.getTopology() == null;
		unit2.getOnlyDependencyCapabilities().add(u1_provides);
		assert u1_provides.getTopology() == top;

		assertSetEquals(top.findAllDeployModelObjects(), new Object[] { unit1,
				unit2, u1_provides });
		assertSetEquals(top.findAllCapabilities(), new Object[] { u1_provides });
		assertSetEquals(top.findAllNonHostingCapabilities(),
				new Object[] { u1_provides });
		assertSetEquals(top.findAllHostingCapabilities(), null);
		assertSetEquals(top.findAllDependencyLinks(), null);
		assertSetEquals(top.findAllHostingLinks(), null);

		Capability u1_provides_hosting = CoreFactory.eINSTANCE
				.createCapability();
		u1_provides_hosting.setLinkType(CapabilityLinkTypes.ANY_LITERAL);
		u1_provides_hosting.setName("u1_provides_hosting");
		unit1.getHostingOrAnyCapabilities().add(u1_provides_hosting);
		assert unit1.getContainedModelObjects().size() == 1;
		assertSetEquals(unit1.getContainedModelObjects().iterator(),
				new Object[] { u1_provides_hosting });

		assertSetEquals(top.findAllDeployModelObjects(), new Object[] { unit1,
				unit2, u1_provides, u1_provides_hosting });
		assertSetEquals(top.findAllCapabilities(), new Object[] { u1_provides,
				u1_provides_hosting });
		assertSetEquals(top.findAllNonHostingCapabilities(),
				new Object[] { u1_provides });
		assertSetEquals(top.findAllHostingCapabilities(),
				new Object[] { u1_provides_hosting });
		assertSetEquals(top.findAllDependencyLinks(), null);
		assertSetEquals(top.findAllHostingLinks(), null);

		Capability u2_provides = CoreFactory.eINSTANCE.createCapability();
		u2_provides.setName("u2_provides");
		unit2.getOnlyDependencyCapabilities().add(u2_provides);

		assertSetEquals(top.findAllDeployModelObjects(), new Object[] { unit1,
				unit2, u1_provides, u1_provides_hosting, u2_provides });
		assertSetEquals(top.findAllCapabilities(), new Object[] { u1_provides,
				u1_provides_hosting, u2_provides });
		assertSetEquals(top.findAllNonHostingCapabilities(), new Object[] {
				u1_provides, u2_provides });
		assertSetEquals(top.findAllHostingCapabilities(),
				new Object[] { u1_provides_hosting });
		assertSetEquals(top.findAllDependencyLinks(), null);
		assertSetEquals(top.findAllHostingLinks(), null);

		Requirement u2_consumes1 = CoreFactory.eINSTANCE.createRequirement();
		u2_consumes1.setName("u2_consumes1");
		unit2.getOnlyDependencyRequirements().add(u2_consumes1);

		Requirement u2_consumes2 = CoreFactory.eINSTANCE.createRequirement();
		u2_consumes2.setName("u2_consumes2");
		unit2.getOnlyDependencyRequirements().add(u2_consumes2);

		assertSetEquals(top.findAllDeployModelObjects(), new Object[] { unit1,
				unit2, u1_provides, u1_provides_hosting, u2_provides,
				u2_consumes1, u2_consumes2 });
		assertSetEquals(top.findAllCapabilities(), new Object[] { u1_provides,
				u1_provides_hosting, u2_provides });
		assertSetEquals(top.findAllNonHostingCapabilities(), new Object[] {
				u1_provides, u2_provides });
		assertSetEquals(top.findAllHostingCapabilities(),
				new Object[] { u1_provides_hosting });
		assertSetEquals(top.findAllDependencyLinks(), null);
		assertSetEquals(top.findAllHostingLinks(), null);
		assert !top.findAllArtifacts().hasNext();

		Requirement u2_consumes_hosting = CoreFactory.eINSTANCE
				.createRequirement();
		u2_consumes_hosting.setLinkType(RequirementLinkTypes.ANY_LITERAL);
		u2_consumes_hosting.setDmoEType(CorePackage.eINSTANCE.getCapability());
		u2_consumes_hosting.setName("u2_consumes_hosting");
		unit2.getHostingOrAnyRequirements().add(u2_consumes_hosting);

		assertSetEquals(top.findAllDeployModelObjects(), new Object[] { unit1,
				unit2, u1_provides, u1_provides_hosting, u2_provides,
				u2_consumes1, u2_consumes2, u2_consumes_hosting });
		assertSetEquals(top.findAllCapabilities(), new Object[] { u1_provides,
				u1_provides_hosting, u2_provides });
		assertSetEquals(top.findAllNonHostingCapabilities(), new Object[] {
				u1_provides, u2_provides });
		assertSetEquals(top.findAllHostingCapabilities(),
				new Object[] { u1_provides_hosting });
		assertSetEquals(top.findAllDependencyLinks(), null);
		assertSetEquals(top.findAllHostingLinks(), null);
		assert !top.findAllArtifacts().hasNext();

		// /////////////////////////////////////////////////////////////////////////////
		//
		// Create service links
		//

		DependencyLink link_u2_consumes1_to_u1_provides = CoreFactory.eINSTANCE
				.createDependencyLink();
		assert link_u2_consumes1_to_u1_provides.getTopology() == null;
		link_u2_consumes1_to_u1_provides
				.setName("link_u2_consumes1_to_u1_provides");
		u2_consumes1.setLink(link_u2_consumes1_to_u1_provides);
		link_u2_consumes1_to_u1_provides.setTarget(u1_provides);
		assert link_u2_consumes1_to_u1_provides.getTopology() == top;

		assertSetEquals(top.findAllDeployModelObjects(), new Object[] { unit1,
				unit2, u1_provides, u1_provides_hosting, u2_provides,
				u2_consumes1, u2_consumes2, u2_consumes_hosting,
				link_u2_consumes1_to_u1_provides });
		assertSetEquals(top.findAllCapabilities(), new Object[] { u1_provides,
				u1_provides_hosting, u2_provides });
		assertSetEquals(top.findAllNonHostingCapabilities(), new Object[] {
				u1_provides, u2_provides });
		assertSetEquals(top.findAllHostingCapabilities(),
				new Object[] { u1_provides_hosting });
		assertSetEquals(top.findAllDependencyLinks(),
				new Object[] { link_u2_consumes1_to_u1_provides });
		assertSetEquals(top.findAllHostingLinks(), null);
		assert !top.findAllArtifacts().hasNext();

		//
		DependencyLink link_u2_consumes2_to_null = CoreFactory.eINSTANCE
				.createDependencyLink();
		link_u2_consumes2_to_null.setName("link_u2_consumes2_to_null");
		u2_consumes2.setLink(link_u2_consumes2_to_null);

		HostingLink hosting_link_u1_u2 = CoreFactory.eINSTANCE
				.createHostingLink();
		hosting_link_u1_u2.setName("hosting_link_u1_u2");
		hosting_link_u1_u2.setHosted(unit2);
		unit1.getHostingLinks().add(hosting_link_u1_u2);

		assertSetEquals(top.findAllDeployModelObjects(), new Object[] { unit1,
				unit2, u1_provides, u1_provides_hosting, u2_provides,
				u2_consumes1, u2_consumes2, u2_consumes_hosting,
				link_u2_consumes1_to_u1_provides, link_u2_consumes2_to_null,
				hosting_link_u1_u2 });
		assertSetEquals(top.findAllCapabilities(), new Object[] { u1_provides,
				u1_provides_hosting, u2_provides });
		assertSetEquals(top.findAllNonHostingCapabilities(), new Object[] {
				u1_provides, u2_provides });
		assertSetEquals(top.findAllHostingCapabilities(),
				new Object[] { u1_provides_hosting });
		assertSetEquals(top.findAllDependencyLinks(), new Object[] {
				link_u2_consumes1_to_u1_provides, link_u2_consumes2_to_null });
		assertSetEquals(top.findAllHostingLinks(),
				new Object[] { hosting_link_u1_u2 });
		assert !top.findAllArtifacts().hasNext();

		// Artifact
		FileArtifact artifact1 = CoreFactory.eINSTANCE.createFileArtifact();
		artifact1.setName("artifact1");
		unit1.getArtifacts().add(artifact1);
		assert top.resolve(artifact1.getFullPath()) == artifact1 : artifact1
				.getFullPath();
		artifact1.setName(null);
		assert top.resolve(artifact1.getFullPath()) == artifact1;
		artifact1.setName("artifact1");

		FileArtifact artifact2 = CoreFactory.eINSTANCE.createFileArtifact();
		artifact2.setName("artifact2");
		unit1.getArtifacts().add(artifact2);
		assert top.resolve(artifact1.getFullPath()) == artifact1;
		assert top.resolve(artifact2.getFullPath()) == artifact2;

		assertSetEquals(unit1.getContainedModelObjects().iterator(),
				new Object[] { u1_provides_hosting, hosting_link_u1_u2,
						artifact1, artifact2 });
		assertSetEquals(top.findAllDeployModelObjects(), new Object[] { unit1,
				unit2, u1_provides, u1_provides_hosting, u2_provides,
				u2_consumes1, u2_consumes2, u2_consumes_hosting,
				link_u2_consumes1_to_u1_provides, link_u2_consumes2_to_null,
				hosting_link_u1_u2, artifact1, artifact2 });
		assertSetEquals(top.findAllCapabilities(), new Object[] { u1_provides,
				u1_provides_hosting, u2_provides });
		assertSetEquals(top.findAllNonHostingCapabilities(), new Object[] {
				u1_provides, u2_provides });
		assertSetEquals(top.findAllHostingCapabilities(),
				new Object[] { u1_provides_hosting });
		assertSetEquals(top.findAllDependencyLinks(), new Object[] {
				link_u2_consumes1_to_u1_provides, link_u2_consumes2_to_null });
		assertSetEquals(top.findAllHostingLinks(),
				new Object[] { hosting_link_u1_u2 });
		assertSetEquals(top.findAllArtifacts(), new Object[] { artifact1,
				artifact2 });

		res.save(null);

		res.unload();

		// /////////////////////////////////////////////////////////////////////////////
		//
		// Test serialization
		//

		res.load(null);

		top = getTopology(res);

		// Verify getAllContainedModelObjects()
		assertTrue(top.getContainedModelObjects().size() == 2);

		unit1 = (Unit) top.resolve("unit1");
		assertNotNull(unit1);
		assertTrue(unit1.getContainedModelObjects().size() == 4);

		artifact1 = (FileArtifact) unit1.getArtifacts().get(0);
		assertNotNull(artifact1);
		assert artifact1.getName().equals("artifact1");

		artifact2 = (FileArtifact) unit1.getArtifacts().get(1);
		assertNotNull(artifact2);
		assert artifact2.getName().equals("artifact2");

		unit2 = (Unit) top.resolve("unit2");
		assertNotNull(unit2);
		assertTrue(unit2.getContainedModelObjects().size() == 5);

		u1_provides = (Capability) unit2.resolve("u1_provides");
		assertNotNull(u1_provides);
		assertTrue(u1_provides.getContainedModelObjects().size() == 0);

		u1_provides_hosting = (Capability) unit1.resolve("u1_provides_hosting");
		assertNotNull(u1_provides_hosting);
		assertTrue(u1_provides_hosting.getContainedModelObjects().size() == 0);

		u2_provides = (Capability) unit2.resolve("u2_provides");
		assertNotNull(u2_provides);
		assertTrue(u2_provides.getContainedModelObjects().size() == 0);

		u2_consumes1 = (Requirement) unit2.resolve("u2_consumes1");
		assertNotNull(u2_consumes1);
		assertTrue(u2_consumes1.getContainedModelObjects().size() == 1);

		assertNotNull(u2_consumes1.getLink());

		u2_consumes2 = (Requirement) unit2.resolve("u2_consumes2");
		assertNotNull(u2_consumes2);
		assertTrue(u2_consumes2.getContainedModelObjects().size() == 1);

		assertNotNull(u2_consumes2.getLink());

		u2_consumes_hosting = (Requirement) unit2
				.resolve("u2_consumes_hosting");
		assertNotNull(u2_consumes_hosting);
		assertTrue(u2_consumes_hosting.getContainedModelObjects().size() == 0);

		link_u2_consumes1_to_u1_provides = u2_consumes1.getLink();
		assertNotNull(link_u2_consumes1_to_u1_provides);
		assert link_u2_consumes1_to_u1_provides.getName().equals(
				"link_u2_consumes1_to_u1_provides");

		link_u2_consumes2_to_null = u2_consumes2.getLink();
		assertNotNull(link_u2_consumes2_to_null);
		assert link_u2_consumes2_to_null.getName().equals(
				"link_u2_consumes2_to_null");

		// TODO lookup by name
		hosting_link_u1_u2 = (HostingLink) unit1.getHostingLinks().get(0);
		assertNotNull(hosting_link_u1_u2);
		assert hosting_link_u1_u2.getName().equals("hosting_link_u1_u2");

		assertSetEquals(unit1.getContainedModelObjects().iterator(),
				new Object[] { u1_provides_hosting, hosting_link_u1_u2,
						artifact1, artifact2 });
		assertSetEquals(top.findAllDeployModelObjects(), new Object[] { unit1,
				unit2, u1_provides, u1_provides_hosting, u2_provides,
				u2_consumes1, u2_consumes2, u2_consumes_hosting,
				link_u2_consumes1_to_u1_provides, link_u2_consumes2_to_null,
				hosting_link_u1_u2, artifact1, artifact2 });
		assertSetEquals(top.findAllCapabilities(), new Object[] { u1_provides,
				u1_provides_hosting, u2_provides });
		assertSetEquals(top.findAllNonHostingCapabilities(), new Object[] {
				u1_provides, u2_provides });
		assertSetEquals(top.findAllHostingCapabilities(),
				new Object[] { u1_provides_hosting });
		assertSetEquals(top.findAllDependencyLinks(), new Object[] {
				link_u2_consumes1_to_u1_provides, link_u2_consumes2_to_null });
		assertSetEquals(top.findAllHostingLinks(),
				new Object[] { hosting_link_u1_u2 });
		assertSetEquals(top.findAllArtifacts(), new Object[] { artifact1,
				artifact2 });
	}

	public void testStatusEvents() throws IOException, CoreException {
		Topology top = createTopology("StatusEventTest");
		Resource res = top.getEObject().eResource();

		Unit unit = CoreFactory.eINSTANCE.createUnit();
		unit.setName("unit");
		top.getUnits().add(unit);

		res.save(null);

		final List notificationList = new ArrayList();
		top.getEObject().eAdapters().add(new EContentAdapter() {
			public void notifyChanged(Notification notification) {
				notificationList.add(notification);
				super.notifyChanged(notification);
			}
		});

		assert (notificationList.size() == 0);

		// Create status1 (info)
		Status status1 = new Status(IStatus.INFO, DeployCorePlugin.PLUGIN_ID,
				0, "info message 1", null);
		unit.addStatus(status1);
		assert (notificationList.size() == 1);
		Notification notification1 = ((Notification) notificationList.get(0));
		assert notification1.getEventType() == Notification.SET;
		assert notification1.getNotifier().equals(unit);
		assert notification1.getFeature() == CorePackage.Literals.DEPLOY_MODEL_OBJECT__STATUS;
		assert notification1.getOldValue() == Status.OK_STATUS : notification1
				.getOldValue();
		assert notification1.getNewValue() == status1;

		// Create status2 (info)
		Status status2 = new Status(IStatus.INFO, DeployCorePlugin.PLUGIN_ID,
				1, "info message 2", null);
		unit.addStatus(status2);
		assert (notificationList.size() == 2);
		Notification notification2 = ((Notification) notificationList.get(1));
		assert notification2.getEventType() == Notification.ADD;
		assert notification2.getNotifier().equals(unit);
		assert notification2.getFeature() == CorePackage.Literals.DEPLOY_MODEL_OBJECT__STATUS;
		assert notification2.getPosition() == 1;
		assert notification2.getOldValue() == status1;
		MultiStatus multiStatus2 = (MultiStatus) notification2.getNewValue();
		IStatus[] children2 = multiStatus2.getChildren();
		assert Arrays.equals(children2, new IStatus[] { status1, status2 });
		assert multiStatus2.getSeverity() == IStatus.INFO;

		// Create states3 (error)
		Status status3 = new Status(IStatus.ERROR, DeployCorePlugin.PLUGIN_ID,
				2, "error message 2", null);
		unit.addStatus(status3);
		assert (notificationList.size() == 3);
		Notification notification3 = ((Notification) notificationList.get(2));
		assert notification3.getEventType() == Notification.ADD;
		assert notification3.getNotifier().equals(unit);
		assert notification3.getFeature() == CorePackage.Literals.DEPLOY_MODEL_OBJECT__STATUS;
		assert notification3.getOldValue() == multiStatus2;
		assert notification3.getNewValue() == multiStatus2;
		assert notification3.getPosition() == 2;
		MultiStatus multiStatus3 = (MultiStatus) notification3.getNewValue();
		IStatus[] children3 = multiStatus3.getChildren();
		assert Arrays.equals(children3, new IStatus[] { status1, status2,
				status3 });
		assert multiStatus3.getSeverity() == IStatus.ERROR;

		// Clear status
		unit.clearStatus();
		assert (notificationList.size() == 4);
		Notification notification4 = ((Notification) notificationList.get(3));
		assert notification4.getEventType() == Notification.SET;
		assert notification4.getNotifier().equals(unit);
		assert notification4.getFeature() == CorePackage.Literals.DEPLOY_MODEL_OBJECT__STATUS;
		assert notification4.getOldValue() == multiStatus2;
		assert notification4.getNewValue() == Status.OK_STATUS;

		res.unload();
	}

	public void testAnnotations() throws IOException {
		Topology top = createTopology("TestAnnotations");

		Unit unit = CoreFactory.eINSTANCE.createUnit();
		unit.setName("TestUnit");

		top.getUnits().add(unit);

		Annotation a1 = CoreFactory.eINSTANCE.createAnnotation();
		a1.setContext("a1");
		a1.getDetails().put("t1", "Foo");
		a1.getDetails().put("t2", "Bar");

		unit.getAnnotations().add(a1);

		Annotation a2 = CoreFactory.eINSTANCE.createAnnotation();
		a2.setContext("a2");

		unit.getAnnotations().add(a2);

		Annotation a3 = CoreFactory.eINSTANCE.createAnnotation();
		unit.getAnnotations().add(a3);

		Resource res = top.eResource();
		res.save(null);

		res.unload();

		res.load(null);

		top = getTopology(res);

		unit = (Unit) top.getUnits().get(0);

		assertTrue(unit.getAnnotations().size() == 3);

		a1 = unit.findAnnotation("a1");
		assertNotNull(a1);
		assertEquals("Foo", a1.getDetails().get("t1"));
		assertEquals("Bar", a1.getDetails().get("t2"));
		assertNull(a1.getDetails().get("t3"));

		a2 = unit.findAnnotation("a2");
		assertNotNull(a2);

		// Missing annotation test.
		a3 = unit.findAnnotation("a3");
		assertNull(a3);
	}

	public void testHosting() throws Exception {
		Topology top = createTopology("testHosting");

		Unit u1 = CoreFactory.eINSTANCE.createUnit();
		u1.setName("u1");
		top.getUnits().add(u1);

		//

		Capability providedHosting = CoreFactory.eINSTANCE.createCapability();
		providedHosting.setName("providedHosting");
		u1.getHostingOrAnyCapabilities().add(providedHosting);

		assertSetEquals(u1.getCapabilities(), new Object[] { providedHosting });
		assertSetEquals(u1.getHostingOrAnyCapabilities(),
				new Object[] { providedHosting });
		assert u1.getOnlyDependencyCapabilities().isEmpty();
		assert u1.getRequirements().isEmpty();
		assert u1.getHostingOrAnyRequirements().isEmpty();
		assert u1.getOnlyDependencyRequirements().isEmpty();

		//
		Requirement consumedHosting = CoreFactory.eINSTANCE.createRequirement();
		consumedHosting.setName("consumedHosting");
		consumedHosting.setDmoEType(CorePackage.eINSTANCE.getCapability());
		consumedHosting.setLinkType(RequirementLinkTypes.HOSTING_LITERAL);
		u1.getRequirements().add(consumedHosting);

		assertSetEquals(u1.getCapabilities(), new Object[] { providedHosting });
		assertSetEquals(u1.getHostingOrAnyCapabilities(),
				new Object[] { providedHosting });
		assert u1.getOnlyDependencyCapabilities().isEmpty();
		assertSetEquals(u1.getRequirements(), new Object[] { consumedHosting });
		assertSetEquals(u1.getOnlyHostingRequirements(),
				new Object[] { consumedHosting });
		assertSetEquals(u1.getHostingOrAnyRequirements(),
				new Object[] { consumedHosting });
		assert u1.getOnlyDependencyRequirements().isEmpty();

		//

		Requirement consumedHostingAsNonHosting = CoreFactory.eINSTANCE
				.createRequirement();
		consumedHostingAsNonHosting
				.setLinkType(RequirementLinkTypes.HOSTING_LITERAL);
		consumedHostingAsNonHosting.setDmoEType(CorePackage.eINSTANCE
				.getCapability());
		consumedHostingAsNonHosting.setName("consumedHostingAsNonHosting");
		u1.getOnlyDependencyRequirements().add(consumedHostingAsNonHosting);
		assert consumedHostingAsNonHosting.getLinkType() == RequirementLinkTypes.DEPENDENCY_LITERAL;

		assertSetEquals(u1.getCapabilities(), new Object[] { providedHosting });
		assertSetEquals(u1.getHostingOrAnyCapabilities(),
				new Object[] { providedHosting });
		assertSetEquals(u1.getRequirements(), new Object[] { consumedHosting,
				consumedHostingAsNonHosting });
		assertSetEquals(u1.getOnlyHostingRequirements(),
				new Object[] { consumedHosting });
		assertSetEquals(u1.getHostingOrAnyRequirements(),
				new Object[] { consumedHosting });
		assertSetEquals(u1.getOnlyDependencyRequirements(),
				new Object[] { consumedHostingAsNonHosting });

		//

		Capability provided = CoreFactory.eINSTANCE.createCapability();
		provided.setName("provided");
		u1.getOnlyDependencyCapabilities().add(provided);
		assert provided.getLinkType() == CapabilityLinkTypes.DEPENDENCY_LITERAL;

		assertSetEquals(u1.getCapabilities(), new Object[] { providedHosting,
				provided });
		assertSetEquals(u1.getHostingOrAnyCapabilities(),
				new Object[] { providedHosting });
		assertSetEquals(u1.getOnlyDependencyCapabilities(),
				new Object[] { provided });

		//

		Requirement consumed = CoreFactory.eINSTANCE.createRequirement();
		consumed.setName("consumed");
		consumed.setLinkType(RequirementLinkTypes.DEPENDENCY_LITERAL);
		u1.getOnlyDependencyRequirements().add(consumed);

		assertSetEquals(u1.getCapabilities(), new Object[] { providedHosting,
				provided });
		assertSetEquals(u1.getHostingOrAnyCapabilities(),
				new Object[] { providedHosting });
		assertSetEquals(u1.getOnlyDependencyCapabilities(),
				new Object[] { provided });
		assertSetEquals(u1.getRequirements(), new Object[] { consumedHosting,
				consumedHostingAsNonHosting, consumed });
		assertSetEquals(u1.getOnlyHostingRequirements(),
				new Object[] { consumedHosting });
		assertSetEquals(u1.getDependencyOrAnyRequirements(), new Object[] {
				consumedHostingAsNonHosting, consumed });

		//

		Unit u2 = CoreFactory.eINSTANCE.createUnit();
		u2.setName("u2");
		top.getUnits().add(u2);

		Capability providedHosting2 = CoreFactory.eINSTANCE.createCapability();
		providedHosting2.setLinkType(CapabilityLinkTypes.ANY_LITERAL);
		providedHosting2.setName("providedHosting2");
		u2.getHostingOrAnyCapabilities().add(providedHosting2);

		HostingLink hostingLink = CoreFactory.eINSTANCE.createHostingLink();
		hostingLink.setName("hostingLink");
		hostingLink.setHosted(u1);
		u2.getHostingLinks().add(hostingLink);
		assert u2.equals(hostingLink.getSource());
		assert u1.equals(hostingLink.getTarget());
		assert u1.equals(hostingLink.getHosted());
		assert u1.equals(hostingLink.getTarget());

		assertSetEquals(top.findHosts(u1), new Object[] { u2 });
		assertSetEquals(u2.getUnitLinks(), new Object[] { hostingLink });
		assertSetEquals(u2.getHostingLinks(), new Object[] { hostingLink });
		assert u1.getUnitLinks().isEmpty();
		assert u1.getHostingLinks().isEmpty();

		//

		Unit u3 = CoreFactory.eINSTANCE.createUnit();
		u2.setName("u3");
		top.getUnits().add(u3);

		Capability provided2 = CoreFactory.eINSTANCE.createCapability();
		provided2.setName("provided2");
		u3.getOnlyDependencyCapabilities().add(provided2);

		DependencyLink link1 = CoreFactory.eINSTANCE.createDependencyLink();
		link1.setName("link1");
		link1.setTarget(provided2);
		consumed.setLink(link1);

		assert link1.getTarget().equals(provided2);
		assert link1.getSource().equals(consumed);
		assert link1.getParent().equals(consumed);
		assert consumed.getLink().equals(link1);

		//

		Capability providedHosting3 = CoreFactory.eINSTANCE.createCapability();
		providedHosting.setLinkType(CapabilityLinkTypes.ANY_LITERAL);
		providedHosting3.setName("providedHosting3");
		u3.getHostingOrAnyCapabilities().add(providedHosting3);

		DependencyLink link2 = CoreFactory.eINSTANCE.createDependencyLink();
		link2.setName("link2");
		link2.setTarget(providedHosting3);
		consumedHostingAsNonHosting.setLink(link2);

		assert link2.getTarget().equals(providedHosting3);
		assert link2.getSource().equals(consumedHostingAsNonHosting);
		assert link2.getParent().equals(consumedHostingAsNonHosting);
		assert consumedHostingAsNonHosting.getLink().equals(link2);
	}

	public void testRequirementLinkType() throws Exception {
		Topology top = createTopology("testRequirementLinkType");

		Unit unit1 = CoreFactory.eINSTANCE.createUnit();
		unit1.setName("unit1");
		top.getUnits().add(unit1);

		Requirement req1 = CoreFactory.eINSTANCE.createRequirement();
		req1.setName("req1");
		unit1.getRequirements().add(req1);

		assertSetEquals(unit1.getRequirements(), new Object[] { req1 });
		assertSetEquals(unit1.getOnlyDependencyRequirements(),
				new Object[] { req1 });
		assert unit1.getHostingOrAnyRequirements().size() == 0;
		assert req1.getLinkType() == RequirementLinkTypes.DEPENDENCY_LITERAL;

		Requirement req2 = CoreFactory.eINSTANCE.createRequirement();
		req2.setName("req2");
		unit1.getHostingOrAnyRequirements().add(req2);

		assertSetEquals(unit1.getRequirements(), new Object[] { req1, req2 });
		assertSetEquals(unit1.getOnlyDependencyRequirements(),
				new Object[] { req1 });
		assertSetEquals(unit1.getHostingOrAnyRequirements(),
				new Object[] { req2 });

		Requirement req3 = CoreFactory.eINSTANCE.createRequirement();
		req3.setName("req3");
		req3.setLinkType(RequirementLinkTypes.HOSTING_LITERAL);
		unit1.getHostingOrAnyRequirements().add(req3);
		assert req3.getLinkType() == RequirementLinkTypes.HOSTING_LITERAL;

		assertSetEquals(unit1.getRequirements(), new Object[] { req1, req2,
				req3 });
		assertSetEquals(unit1.getOnlyDependencyRequirements(),
				new Object[] { req1 });
		assertSetEquals(unit1.getHostingOrAnyRequirements(), new Object[] {
				req2, req3 });
	}

	public void testCapabilityLinkType() throws Exception {
		Topology top = createTopology("testCapabilityLinkType");

		Unit unit1 = CoreFactory.eINSTANCE.createUnit();
		unit1.setName("unit1");
		top.getUnits().add(unit1);

		Capability cap1 = CoreFactory.eINSTANCE.createCapability();
		cap1.setName("cap1");
		unit1.getCapabilities().add(cap1);

		assertSetEquals(unit1.getCapabilities(), new Object[] { cap1 });
		assertSetEquals(unit1.getOnlyDependencyCapabilities(),
				new Object[] { cap1 });
		assert unit1.getHostingOrAnyCapabilities().size() == 0;
		assert cap1.getLinkType() == CapabilityLinkTypes.DEPENDENCY_LITERAL;

		Capability cap2 = CoreFactory.eINSTANCE.createCapability();
		cap2.setName("cap2");
		unit1.getHostingOrAnyCapabilities().add(cap2);
		assert cap2.getLinkType() == CapabilityLinkTypes.ANY_LITERAL;

		assertSetEquals(unit1.getCapabilities(), new Object[] { cap1, cap2 });
		assertSetEquals(unit1.getOnlyDependencyCapabilities(),
				new Object[] { cap1 });
		assertSetEquals(unit1.getHostingOrAnyCapabilities(),
				new Object[] { cap2 });

		Capability cap3 = CoreFactory.eINSTANCE.createCapability();
		cap3.setName("cap3");
		cap3.setLinkType(CapabilityLinkTypes.HOSTING_LITERAL);
		unit1.getHostingOrAnyCapabilities().add(cap3);
		assert cap3.getLinkType() == CapabilityLinkTypes.HOSTING_LITERAL;

		assertSetEquals(unit1.getCapabilities(), new Object[] { cap1, cap2,
				cap3 });
		assertSetEquals(unit1.getOnlyDependencyCapabilities(),
				new Object[] { cap1 });
		assertSetEquals(unit1.getHostingOrAnyCapabilities(), new Object[] {
				cap2, cap3 });
	}

	public void testLogicalLink() throws IOException {
		Topology top = createTopology("testLogicalLink");

		Unit unit1 = CoreFactory.eINSTANCE.createUnit();
		unit1.setName("unit1");
		top.getUnits().add(unit1);

		Requirement req1 = CoreFactory.eINSTANCE.createRequirement();
		req1.setName("req1");
		unit1.getRequirements().add(req1);

		Unit unit2 = CoreFactory.eINSTANCE.createUnit();
		unit2.setName("unit2");
		top.getUnits().add(unit2);

		Capability cap2 = CoreFactory.eINSTANCE.createCapability();
		cap2.setName("cap2");
		unit2.getCapabilities().add(cap2);

		assert unit1.getConstraintLinks().size() == 0;
		assert unit2.getConstraintLinks().size() == 0;

		ConstraintLink ll_u1_u2 = CoreFactory.eINSTANCE.createConstraintLink();
		ll_u1_u2.setName("ll_u1_u2");
		ll_u1_u2.setSource(unit1);
		ll_u1_u2.setTarget(unit2);
		unit1.getConstraintLinks().add(ll_u1_u2);
		assert !ll_u1_u2.getFullPath().equals(unit1.getFullPath()) : ll_u1_u2
				.getFullPath();
		assert top.resolve(ll_u1_u2.getFullPath()) == ll_u1_u2;
		ll_u1_u2.setName(null);
		assert top.resolve(ll_u1_u2.getFullPath()) == ll_u1_u2 : ll_u1_u2
				.getFullPath();
		ll_u1_u2.setName("ll_u1_u2");

		assert unit1.getConstraintLinks().size() == 1;
		assert unit2.getConstraintLinks().size() == 0;
		assert unit1.getConstraintLinks().get(0).equals(ll_u1_u2);
		assert unit1.getConstraintLinks().indexOf(ll_u1_u2) == 0;
		// assert unit1.getContainedModelObjects().size() == 1;
		// assert unit1.getContainedModelObjects().get(0).equals(
		// ll_u1_u2);

		ConstraintLink ll_r1_c1 = CoreFactory.eINSTANCE.createConstraintLink();
		ll_r1_c1.setName("ll_r1_c1");
		ll_r1_c1.setSource(req1);
		ll_r1_c1.setTarget(cap2);
		unit1.getConstraintLinks().add(ll_r1_c1);

		assert unit1.getConstraintLinks().size() == 2;
		assert unit2.getConstraintLinks().size() == 0;
		assert unit1.getConstraintLinks().get(1).equals(ll_r1_c1);
		assert unit1.getConstraintLinks().indexOf(ll_r1_c1) == 1;
		// assert unit1.getContainedModelObjects().size() == 2;
		// assert unit1.getContainedModelObjects().get(1).equals(
		// ll_r1_c1);

		//
		// Logical link removal
		//

		unit1.getConstraintLinks().remove(ll_u1_u2);

		assert unit1.getConstraintLinks().size() == 1;
		assert unit2.getConstraintLinks().size() == 0;
		assert unit1.getConstraintLinks().get(0).equals(ll_r1_c1);
		assert unit1.getConstraintLinks().indexOf(ll_r1_c1) == 0;
		// assert unit1.getContainedModelObjects().size() == 1;
		// assert unit1.getContainedModelObjects().get(0).equals(
		// ll_r1_c1);

		unit1.getConstraintLinks().remove(ll_r1_c1);

		assert unit1.getConstraintLinks().size() == 0;
		assert unit2.getConstraintLinks().size() == 0;
		// assert unit1.getContainedModelObjects().size() == 0;
	}

	/**
	 * Test {@link Capability#getLinkType()} and
	 * {@link Unit#getOnlyDependencyCapabilities()}
	 * 
	 * @see RequirementTest#testRequirementLinkTypes()
	 */
	public void testCapabilityLinkTypes() throws Exception {
		Topology top = createTopology("testCapabilityLinkTypes");

		Unit unit = CoreFactory.eINSTANCE.createUnit();
		unit.setName("unit");
		top.getUnits().add(unit);

		Capability cap = CoreFactory.eINSTANCE.createCapability();
		cap.setName("cap");
		unit.getCapabilities().add(cap);

		cap.setLinkType(CapabilityLinkTypes.DEPENDENCY_LITERAL);
		assertSetEquals(unit.getCapabilities(), new Object[] { cap });
		assertSetEquals(unit.getOnlyAnyCapabilities(), null);
		assertSetEquals(unit.getOnlyHostingCapabilities(), null);
		assertSetEquals(unit.getHostingOrAnyCapabilities(), null);
		assertSetEquals(unit.getOnlyDependencyCapabilities(),
				new Object[] { cap });
		assertSetEquals(unit.getDependencyOrAnyCapabilities(),
				new Object[] { cap });
		assertSetEquals(unit.getCapabilities(
				CapabilityLinkTypeFilter.ANY_OR_DEPENDENCY_FILTER, null),
				new Object[] { cap });

		cap.setLinkType(CapabilityLinkTypes.ANY_LITERAL);
		assertSetEquals(unit.getCapabilities(), new Object[] { cap });
		assertSetEquals(unit.getOnlyAnyCapabilities(), new Object[] { cap });
		assertSetEquals(unit.getOnlyHostingCapabilities(), null);
		assertSetEquals(unit.getHostingOrAnyCapabilities(),
				new Object[] { cap });
		assertSetEquals(unit.getOnlyDependencyCapabilities(), null);
		assertSetEquals(unit.getDependencyOrAnyCapabilities(),
				new Object[] { cap });

		cap.setLinkType(CapabilityLinkTypes.HOSTING_LITERAL);
		assertSetEquals(unit.getCapabilities(), new Object[] { cap });
		assertSetEquals(unit.getOnlyAnyCapabilities(), null);
		assertSetEquals(unit.getOnlyHostingCapabilities(), new Object[] { cap });
		assertSetEquals(unit.getHostingOrAnyCapabilities(),
				new Object[] { cap });
		assertSetEquals(unit.getOnlyDependencyCapabilities(), null);
		assertSetEquals(unit.getDependencyOrAnyCapabilities(), null);

		// Check adaptation of capability

		unit.getCapabilities().remove(cap);
		cap.setLinkType(CapabilityLinkTypes.DEPENDENCY_LITERAL);
		unit.getOnlyAnyCapabilities().add(cap);
		assert cap.getLinkType() == CapabilityLinkTypes.ANY_LITERAL;

		unit.getCapabilities().remove(cap);
		cap.setLinkType(CapabilityLinkTypes.DEPENDENCY_LITERAL);
		unit.getOnlyHostingCapabilities().add(cap);
		assert cap.getLinkType() == CapabilityLinkTypes.HOSTING_LITERAL;

		unit.getCapabilities().remove(cap);
		cap.setLinkType(CapabilityLinkTypes.HOSTING_LITERAL);
		unit.getOnlyDependencyCapabilities().add(cap);
		assert cap.getLinkType() == CapabilityLinkTypes.DEPENDENCY_LITERAL;

		unit.getCapabilities().remove(cap);
		cap.setLinkType(CapabilityLinkTypes.HOSTING_LITERAL);
		unit.getDependencyOrAnyCapabilities().add(cap);
		assert cap.getLinkType() == CapabilityLinkTypes.ANY_LITERAL;

		unit.getCapabilities().remove(cap);
		cap.setLinkType(CapabilityLinkTypes.DEPENDENCY_LITERAL);
		unit.getHostingOrAnyCapabilities().add(cap);
		assert cap.getLinkType() == CapabilityLinkTypes.ANY_LITERAL;
	}

	/**
	 * ignore this from JUnits. This is bound to fail.
	 * 
	 * @throws Exception
	 */
	public void XtestContainmentFeature() throws Exception {
		Topology top = createTopology("testContainmentFeature");

		Unit u1 = CoreFactory.eINSTANCE.createUnit();
		u1.setName("u1");
		top.getUnits().add(u1);

		assert u1.eContainer() == top;
		EStructuralFeature feature = u1.eContainingFeature();
		assert feature != null;
		Setting setting = ((InternalEObject) top).eSetting(feature);
		assert setting != null;
		assert setting.getEObject() == top : setting.getEObject();

		EStructuralFeature feature2 = u1.eContainmentFeature();
		assert feature2 != null;
		Setting setting2 = ((InternalEObject) top).eSetting(feature2);
		assert setting2 != null;
		assert setting2.getEObject() == top : setting.getEObject();
	}
	
	public void testGetFullPathCache() throws Exception {
		
		
		Topology topology = createTopology("testGetFullPathCache");
		
		Unit u1 = CoreFactory.eINSTANCE.createUnit();
		u1.setName("U1");
		topology.getUnits().add(u1);
		
		assertEquals(IConstants.PATH_SEPARATOR + u1.getName(), u1.getFullPath());
		
		Capability u1c1 = CoreFactory.eINSTANCE.createCapability();
		u1c1.setName("U1C1");
		u1.getCapabilities().add(u1c1);
		
		assertEquals(IConstants.PATH_SEPARATOR + u1.getName() + IConstants.PATH_SEPARATOR + u1c1.getName(), u1c1.getFullPath());
		
		Capability u1c2 = CoreFactory.eINSTANCE.createCapability();
		u1c2.setName("U1C2");
		u1.getCapabilities().add(u1c2);
		
		assertEquals(IConstants.PATH_SEPARATOR + u1.getName() + IConstants.PATH_SEPARATOR +  u1c1.getName(), u1c1.getFullPath());
		assertEquals(IConstants.PATH_SEPARATOR + u1.getName() + IConstants.PATH_SEPARATOR +  u1c2.getName(), u1c2.getFullPath());
		 
		u1c2.setName("U1C1");

		assertEquals(IConstants.PATH_SEPARATOR + u1.getName() + IConstants.PATH_SEPARATOR + "@0", u1c1.getFullPath());
		assertEquals(IConstants.PATH_SEPARATOR + u1.getName() + IConstants.PATH_SEPARATOR + "@1", u1c2.getFullPath());
		 
		Unit u2 = CoreFactory.eINSTANCE.createUnit();
		u2.setName("U2");
		topology.getUnits().add(u2);

		assertEquals(IConstants.PATH_SEPARATOR + u1.getName(), u1.getFullPath());
		assertEquals(IConstants.PATH_SEPARATOR + u2.getName(), u2.getFullPath());
		
		u1.setName("U2");

		assertEquals(IConstants.PATH_SEPARATOR + "@0", u1.getFullPath());
		assertEquals(IConstants.PATH_SEPARATOR + "@1", u2.getFullPath());
		
		u1c2.setName("U1C2");
		
		assertEquals(IConstants.PATH_SEPARATOR + "@0" + IConstants.PATH_SEPARATOR +   u1c1.getName(), u1c1.getFullPath());
		assertEquals(IConstants.PATH_SEPARATOR + "@0" + IConstants.PATH_SEPARATOR +  u1c2.getName(), u1c2.getFullPath());
		
		u1.setName("U1"); 

		assertEquals(IConstants.PATH_SEPARATOR + u1.getName(), u1.getFullPath());
		assertEquals(IConstants.PATH_SEPARATOR + u2.getName(), u2.getFullPath());
		
		assertEquals(IConstants.PATH_SEPARATOR + u1.getName() + IConstants.PATH_SEPARATOR +   u1c1.getName(), u1c1.getFullPath());
		assertEquals(IConstants.PATH_SEPARATOR + u1.getName() + IConstants.PATH_SEPARATOR +  u1c2.getName(), u1c2.getFullPath());

	}
	
	public void testHostingLinkTopologyListener() throws IOException {
		Topology top = createTopology("testHostingLinkTopologyListener");
		top.eResource().setTrackingModification(true);
		//First slot is any notification and second slot is the proper
		//unit links.
		final boolean[] notificationHits = new boolean[2];
		Adapter listener = new AdapterImpl() {
			@Override
			public void notifyChanged(Notification msg) {
				notificationHits[0] = true;
				if (CorePackage.Literals.DEPLOY_CORE_ROOT__LINK_HOSTING == msg.getFeature()) {
					notificationHits[1] = true;
				}
			}
		};
		
		top.addTopologyListener(listener, CorePackage.Literals.DEPLOY_CORE_ROOT__LINK_HOSTING);
		
		notificationHits[0] = false;
		Unit unit1 = CoreFactory.eINSTANCE.createUnit();
		unit1.setName("unit1");
		assertNull(unit1.getTopology());
		top.getUnits().add(unit1);
		assertEquals(unit1.getTopology(), top);
		assertFalse("We should not have recieved a notification.", notificationHits[0]);
		
		Unit unit2 = CoreFactory.eINSTANCE.createUnit();
		unit2.setName("unit2");
		top.getUnits().add(unit2);
		
		assertFalse("We should not have recieved a notification.", notificationHits[0]);

		assertTrue(unit1.getHostingLinks().size() == 0);
		assertTrue(unit2.getHostingLinks().size() == 0);

		HostingLink hosting_link_u1_u2 = CoreFactory.eINSTANCE
				.createHostingLink();
		hosting_link_u1_u2.setName("hosting_link_u1_u2");
		hosting_link_u1_u2.setHosted(unit2);
		unit1.getHostingLinks().add(hosting_link_u1_u2);
		
		assertTrue("We should have recieved a notification.", notificationHits[0]);
		assertTrue("We should have recieved a UNIT__UNIT_LINKS notification.", notificationHits[1]);

		//
		// Hosting link removal
		//

		notificationHits[0] = false;
		notificationHits[1] = false;
		unit1.getHostingLinks().remove(hosting_link_u1_u2);

		assertTrue(unit1.getHostingLinks().size() == 0);
		assertTrue(unit2.getHostingLinks().size() == 0);
		
		assertTrue("We should have recieved a notification.", notificationHits[0]);
		assertTrue("We should have recieved a UNIT__UNIT_LINKS notification.", notificationHits[1]);
		
	}
	
	public void testTopologyListenerAddAndRemove() throws IOException {
		Topology top = createTopology("testHostingLinkTopologyListener");
		top.eResource().setTrackingModification(true);
		//First slot is any notification and second slot is the proper
		//unit links.
		final boolean[] notificationHits = new boolean[2];
		Adapter listener = new AdapterImpl() {
			@Override
			public void notifyChanged(Notification msg) {
				notificationHits[0] = true;
				if (CorePackage.Literals.DEPLOY_CORE_ROOT__LINK_HOSTING == msg.getFeature()) {
					notificationHits[1] = true;
				}
			}
		};
		
		top.addTopologyListener(listener, CorePackage.Literals.DEPLOY_CORE_ROOT__LINK_HOSTING);
		
		notificationHits[0] = false;
		Unit unit1 = CoreFactory.eINSTANCE.createUnit();
		unit1.setName("unit1");
		assertNull(unit1.getTopology());
		top.getUnits().add(unit1);
		assertEquals(unit1.getTopology(), top);
		assertFalse("We should not have recieved a notification.", notificationHits[0]);
		
		Unit unit2 = CoreFactory.eINSTANCE.createUnit();
		unit2.setName("unit2");
		top.getUnits().add(unit2);
		
		assertFalse("We should not have recieved a notification.", notificationHits[0]);

		assertTrue(unit1.getHostingLinks().size() == 0);
		assertTrue(unit2.getHostingLinks().size() == 0);

		HostingLink hosting_link_u1_u2 = CoreFactory.eINSTANCE
				.createHostingLink();
		hosting_link_u1_u2.setName("hosting_link_u1_u2");
		hosting_link_u1_u2.setHosted(unit2);
		unit1.getHostingLinks().add(hosting_link_u1_u2);
		
		assertTrue("We should have recieved a notification.", notificationHits[0]);
		assertTrue("We should have recieved a UNIT__UNIT_LINKS notification.", notificationHits[1]);

		//
		// Hosting link removal
		//
		
		top.removeTopologyListener(listener, CorePackage.Literals.DEPLOY_CORE_ROOT__LINK_HOSTING);

		notificationHits[0] = false;
		unit1.getHostingLinks().remove(hosting_link_u1_u2);

		assertTrue(unit1.getHostingLinks().size() == 0);
		assertTrue(unit2.getHostingLinks().size() == 0);
		
		assertFalse("We should not have recieved a notification.", notificationHits[0]);
		
	}
	
	public void testWildcardTopologyListenerAddAndRemove() throws IOException {
		Topology top = createTopology("testWildcardTopologyListenerAddAndRemove");
		top.eResource().setTrackingModification(true);
		
		final int[] notificationHits = new int[] {0};
		Adapter listener = new AdapterImpl() {
			@Override
			public void notifyChanged(Notification msg) {
				notificationHits[0]++;
			}
		};
		
		int currentNotificationCount = 0;
		top.addTopologyListener(listener, Topology.WILDCARD_LISTENER);
		
		Unit unit1 = CoreFactory.eINSTANCE.createUnit();
		unit1.setName("unit1");
		assertNull(unit1.getTopology());
		top.getUnits().add(unit1);
		assertEquals(unit1.getTopology(), top);
		currentNotificationCount = notificationHits[0];
		assertTrue("We should have recieved a notification.", currentNotificationCount > 0);
		
		Unit unit2 = CoreFactory.eINSTANCE.createUnit();
		unit2.setName("unit2");
		top.getUnits().add(unit2);
		
		assertTrue("We should have recieved a notification.", notificationHits[0] > currentNotificationCount);
		
		currentNotificationCount = notificationHits[0];

		assertTrue(unit1.getHostingLinks().size() == 0);
		assertTrue(unit2.getHostingLinks().size() == 0);

		HostingLink hosting_link_u1_u2 = CoreFactory.eINSTANCE
				.createHostingLink();
		hosting_link_u1_u2.setName("hosting_link_u1_u2");
		hosting_link_u1_u2.setHosted(unit2);
		unit1.getHostingLinks().add(hosting_link_u1_u2);
		
		assertTrue("We should have recieved a notification.", notificationHits[0] > currentNotificationCount);

		//
		// Hosting link removal
		//
		
		top.removeTopologyListener(listener, Topology.WILDCARD_LISTENER);

		notificationHits[0] = 0;
		unit1.getHostingLinks().remove(hosting_link_u1_u2);

		assertTrue(unit1.getHostingLinks().size() == 0);
		assertTrue(unit2.getHostingLinks().size() == 0);
		
		assertTrue("We should not have recieved a notification.", notificationHits[0] == 0);
		
	}
	
	public void testBadTopologyListeners() throws IOException {
		Topology top = createTopology("testBadTopologyListeners");
		top.eResource().setTrackingModification(true);
		final boolean[] notificationHits1 = new boolean[1];
		Adapter listener1 = new AdapterImpl() {
			@Override
			public void notifyChanged(Notification msg) {
				notificationHits1[0] = true;
				throw new RuntimeException();
			}
		};
		
		top.addTopologyListener(listener1, CorePackage.Literals.DEPLOY_CORE_ROOT__LINK_HOSTING);
		final boolean[] notificationHits2 = new boolean[1];
		Adapter listener2 = new AdapterImpl() {
			@Override
			public void notifyChanged(Notification msg) {
				notificationHits2[0] = true;
			}
		};
		
		top.addTopologyListener(listener2, CorePackage.Literals.DEPLOY_CORE_ROOT__LINK_HOSTING);
		
		Unit unit1 = CoreFactory.eINSTANCE.createUnit();
		unit1.setName("unit1");
		assertNull(unit1.getTopology());
		top.getUnits().add(unit1);
		assertEquals(unit1.getTopology(), top);
		assertFalse("We should not have recieved a notification.", notificationHits1[0]);
		assertFalse("We should not have recieved a notification.", notificationHits2[0]);
		
		Unit unit2 = CoreFactory.eINSTANCE.createUnit();
		unit2.setName("unit2");
		top.getUnits().add(unit2);
		
		assertFalse("We should not have recieved a notification.", notificationHits1[0]);
		assertFalse("We should not have recieved a notification.", notificationHits2[0]);

		assertTrue(unit1.getHostingLinks().size() == 0);
		assertTrue(unit2.getHostingLinks().size() == 0);

		HostingLink hosting_link_u1_u2 = CoreFactory.eINSTANCE
				.createHostingLink();
		hosting_link_u1_u2.setName("hosting_link_u1_u2");
		hosting_link_u1_u2.setHosted(unit2);
		unit1.getHostingLinks().add(hosting_link_u1_u2);
		
		assertTrue("We should have recieved a notification.", notificationHits1[0]);
		assertTrue("We should have recieved a notification.", notificationHits2[0]);

		//
		// Hosting link removal
		//

		notificationHits1[0] = false;
		notificationHits2[0] = false;
		unit1.getHostingLinks().remove(hosting_link_u1_u2);

		assertTrue(unit1.getHostingLinks().size() == 0);
		assertTrue(unit2.getHostingLinks().size() == 0);
		
		assertFalse("We should not have recieved a notification.", notificationHits1[0]);		
		assertTrue("We should have recieved a notification.", notificationHits2[0]);
	}
}
