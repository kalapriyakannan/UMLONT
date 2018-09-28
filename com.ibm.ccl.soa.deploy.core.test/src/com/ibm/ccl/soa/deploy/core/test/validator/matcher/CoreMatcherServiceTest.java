/*******************************************************************************
 * Copyright (c) 2003, 2007 IBM Corporation Licensed Material - Property of IBM. All rights reserved.
 *  
 * US Government Users Restricted Rights - Use, duplication or disclosure v1.0 restricted by GSA ADP
 * Schedule Contract with IBM Corp.
 * 
 * Contributors: IBM Corporation - initial API and implementation
 *******************************************************************************/
package com.ibm.ccl.soa.deploy.core.test.validator.matcher;

import java.io.IOException;

import junit.framework.TestCase;

import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.jem.util.emf.workbench.WorkbenchResourceHelperBase;

import com.ibm.ccl.soa.deploy.core.Capability;
import com.ibm.ccl.soa.deploy.core.CapabilityLinkTypes;
import com.ibm.ccl.soa.deploy.core.CoreFactory;
import com.ibm.ccl.soa.deploy.core.CorePackage;
import com.ibm.ccl.soa.deploy.core.DependencyLink;
import com.ibm.ccl.soa.deploy.core.DeployCoreRoot;
import com.ibm.ccl.soa.deploy.core.HostingLink;
import com.ibm.ccl.soa.deploy.core.Requirement;
import com.ibm.ccl.soa.deploy.core.RequirementLinkTypes;
import com.ibm.ccl.soa.deploy.core.Topology;
import com.ibm.ccl.soa.deploy.core.Unit;
import com.ibm.ccl.soa.deploy.core.validator.DeployValidatorService;
import com.ibm.ccl.soa.deploy.core.validator.expression.RequirementUtil;
import com.ibm.ccl.soa.deploy.core.validator.matcher.LinkDescriptor;
import com.ibm.ccl.soa.deploy.core.validator.matcher.LinkType;

/**
 * Tests the {@link DeployValidatorService} class.
 * MK 6/7/2007 doubled expected number of errors to take ILDomainMatcher into account
 */
public class CoreMatcherServiceTest extends TestCase {

	private static final String PROJECT_NAME = "CoreMatcherServiceTest";

	/** Temporary project for storing unit-test IFiles */
	private IProject project;

	/** Shared validator instance. */
	private DeployValidatorService validatorService;

	public CoreMatcherServiceTest() {
		super();
	}

	public CoreMatcherServiceTest(String name) {
		super(name);
	}

	/*
	 * @see junit.framework.TestCase#setUp()
	 */
	protected void setUp() throws Exception {
		super.setUp();
		project = ResourcesPlugin.getWorkspace().getRoot().getProject(
				PROJECT_NAME);
		project.create(new NullProgressMonitor());
		project.open(new NullProgressMonitor());
		validatorService = new DeployValidatorService();
	}

	/*
	 * @see junit.framework.TestCase#tearDown()
	 */
	protected void tearDown() throws Exception {
		super.tearDown();
		project.delete(true, true, null);
	}

	/**
	 * Creates an empty topology associated with an Eclipse resource.
	 * 
	 * @param name
	 *            the name used for the topology and the resource URI.
	 * 
	 * @return the Topology object.
	 */
	protected Topology createTopology(String name) {
		URI uri = URI.createPlatformResourceURI(PROJECT_NAME + '/' + name
				+ ".topology");
		Resource res = WorkbenchResourceHelperBase.createResource(uri);
		DeployCoreRoot root = CoreFactory.eINSTANCE.createDeployCoreRoot();
		res.getContents().add(root);

		Topology top = CoreFactory.eINSTANCE.createTopology();
		top.setName("HostingLinkMatching");
		root.setTopology(top);

		return top;
	}

	/**
	 * Tests that the domain validation service returns the core domain
	 * validator.
	 */
	public void testCoreMatcherServiceTest() throws IOException, CoreException {
		final Topology top = createTopology("testCoreDomainValidatorMatchingFucntions");

		// host 1 provides a hosting service
		final Unit host1 = CoreFactory.eINSTANCE.createUnit();
		host1.setName("host1");
		top.getUnits().add(host1);

		final Capability provided = CoreFactory.eINSTANCE.createCapability();
		provided.setName("providesHostService1");
		provided.setLinkType(CapabilityLinkTypes.HOSTING_LITERAL);
		host1.getHostingOrAnyCapabilities().add(provided);

		// host 2 provides no hosting services
		final Unit host2 = CoreFactory.eINSTANCE.createUnit();
		host2.setName("host2");
		top.getUnits().add(host2);

		// hostee1 consumes a hosting service
		final Unit hostee1 = CoreFactory.eINSTANCE.createUnit();
		hostee1.setName("hostee1");
		top.getUnits().add(hostee1);

		final Requirement consumed1 = CoreFactory.eINSTANCE.createRequirement();
		consumed1.setName("consumesHostService1");
		consumed1.setDmoEType(CorePackage.Literals.CAPABILITY);
		consumed1.setLinkType(RequirementLinkTypes.HOSTING_LITERAL);
		hostee1.getHostingOrAnyRequirements().add(consumed1);

		// hostee2 consumes a hosting service
		final Unit hostee2 = CoreFactory.eINSTANCE.createUnit();
		hostee2.setName("hostee2");
		top.getUnits().add(hostee2);

		final Requirement consumed2 = CoreFactory.eINSTANCE.createRequirement();
		consumed2.setName("consumesHostService2");
		consumed2.setDmoEType(CorePackage.Literals.CAPABILITY);
		consumed2.setLinkType(RequirementLinkTypes.HOSTING_LITERAL);
		hostee2.getHostingOrAnyRequirements().add(consumed2);

		// hostee 3 consumes no hosting services
		final Unit hostee3 = CoreFactory.eINSTANCE.createUnit();
		hostee3.setName("hostee3");
		top.getUnits().add(hostee3);

		assert validatorService.canBeLinkEndpoint(host1, LinkType.HOSTING_SET)
				.isOK();
		assert !validatorService.canBeLinkEndpoint(host2, LinkType.HOSTING_SET)
				.isOK();
		assert validatorService
				.canBeLinkEndpoint(hostee1, LinkType.HOSTING_SET).isOK();
		assert validatorService
				.canBeLinkEndpoint(hostee2, LinkType.HOSTING_SET).isOK();
		assert !validatorService.canBeLinkEndpoint(hostee3,
				LinkType.HOSTING_SET).isOK();

		assert validatorService.canCreateLink(host1, hostee1,
				LinkType.HOSTING_SET).isOK();
		assert !validatorService.canCreateLink(hostee1, host1,
				LinkType.HOSTING_SET).isOK();
		assert !validatorService.canCreateLink(host2, hostee1,
				LinkType.HOSTING_SET).isOK();
		assert !validatorService.canCreateLink(hostee1, host2,
				LinkType.HOSTING_SET).isOK();
		assert !validatorService.canCreateLink(host2, hostee3,
				LinkType.HOSTING_SET).isOK();
		assert !validatorService.canCreateLink(hostee3, host2,
				LinkType.HOSTING_SET).isOK();

		assert validatorService.canCreateLink(host1, hostee1,
				LinkType.HOSTING_SET).isOK();
		assert !host1.isHosting(hostee1, false);
		assert validatorService.canCreateLink(host1, hostee2,
				LinkType.HOSTING_SET).isOK();
		assert !host1.isHosting(hostee2, false);

		LinkDescriptor[] hld = validatorService.getPossibleLinks(host1,
				hostee1, LinkType.HOSTING_SET);
		assert null != hld;
		assert 0 != hld.length;
		assert hld[0].getSourceUnit() == host1;
		assert hld[0].getTargetUnit() == hostee1;
		HostingLink hLink1 = (HostingLink) hld[0].create();

		assert host1.isHosting(hostee1, false);
		assert !validatorService.canCreateLink(host1, hostee1,
				LinkType.HOSTING_SET).isOK();
		assert validatorService.canBeLinkEndpoint(host1, LinkType.HOSTING_SET)
				.isOK();
		assert !validatorService.canBeLinkEndpoint(hostee1,
				LinkType.HOSTING_SET).isOK();
		assert !host1.isHosting(hostee2, false);
		assert validatorService.canCreateLink(host1, hostee2,
				LinkType.HOSTING_SET).isOK();

		hld = validatorService.getPossibleLinks(host1, hostee2,
				LinkType.HOSTING_SET);
		assert null != hld;
		assert 0 != hld.length;
		assert hld[0].getSourceUnit() == host1;
		assert hld[0].getTargetUnit() == hostee2;
		HostingLink hLink2 = (HostingLink) hld[0].create();

		assert host1.isHosting(hostee1, false);
		assert host1.isHosting(hostee2, false);
		assert !validatorService.canCreateLink(host1, hostee1,
				LinkType.HOSTING_SET).isOK();
		assert validatorService.canBeLinkEndpoint(host1, LinkType.HOSTING_SET)
				.isOK();
		assert !validatorService.canBeLinkEndpoint(hostee1,
				LinkType.HOSTING_SET).isOK();
		assert host1.isHosting(hostee2, false);
		assert !validatorService.canCreateLink(host1, hostee2,
				LinkType.HOSTING_SET).isOK();
		assert !validatorService.canBeLinkEndpoint(hostee2,
				LinkType.HOSTING_SET).isOK();

		assert !validatorService.canBeLinkEndpoint(host1,
				LinkType.DEPENDENCY_SET).isOK();
		assert !validatorService.canBeLinkEndpoint(host2,
				LinkType.DEPENDENCY_SET).isOK();
		assert !validatorService.canBeLinkEndpoint(hostee1,
				LinkType.DEPENDENCY_SET).isOK();
		assert !validatorService.canBeLinkEndpoint(hostee2,
				LinkType.DEPENDENCY_SET).isOK();
		assert !validatorService.canBeLinkEndpoint(hostee3,
				LinkType.DEPENDENCY_SET).isOK();

		hld = validatorService.getPossibleLinks(host1, hostee2,
				LinkType.HOSTING_SET);
		assert null != hld;
		assert 0 == hld.length;
		hld = validatorService.getPossibleLinks(host2, hostee2,
				LinkType.HOSTING_SET);
		assert null != hld;
		assert 0 == hld.length;
		hld = validatorService.getPossibleLinks(host2, hostee3,
				LinkType.HOSTING_SET);
		assert null != hld;
		assert 0 == hld.length;

		final Capability consumedService1x = CoreFactory.eINSTANCE
				.createCapability();
		final Requirement consumedService1 = RequirementUtil
				.createRequirement(consumedService1x);
		consumedService1.setName("consumesService1");
		hostee1.getOnlyDependencyRequirements().add(consumedService1);

		final Capability consumedService2x = CoreFactory.eINSTANCE
				.createCapability();
		final Requirement consumedService2 = RequirementUtil
				.createRequirement(consumedService2x);
		consumedService2.setName("consumesService2");
		hostee2.getOnlyDependencyRequirements().add(consumedService2);

		final Capability providedService1 = CoreFactory.eINSTANCE
				.createCapability();
		providedService1.setName("providesService1");
		host1.getOnlyDependencyCapabilities().add(providedService1);

		assert validatorService.canBeLinkEndpoint(host1,
				LinkType.DEPENDENCY_SET).isOK();
		assert !validatorService.canBeLinkEndpoint(host2,
				LinkType.DEPENDENCY_SET).isOK();
		assert validatorService.canBeLinkEndpoint(hostee1,
				LinkType.DEPENDENCY_SET).isOK();
		assert validatorService.canBeLinkEndpoint(hostee2,
				LinkType.DEPENDENCY_SET).isOK();
		assert !validatorService.canBeLinkEndpoint(hostee3,
				LinkType.DEPENDENCY_SET).isOK();

		assert validatorService.canCreateLink(hostee1, host1,
				LinkType.DEPENDENCY_SET).isOK();
		assert !validatorService.canCreateLink(host2, hostee1,
				LinkType.DEPENDENCY_SET).isOK();
		assert !validatorService.canCreateLink(hostee1, host2,
				LinkType.DEPENDENCY_SET).isOK();
		assert !validatorService.canCreateLink(host2, hostee3,
				LinkType.DEPENDENCY_SET).isOK();
		assert !validatorService.canCreateLink(hostee3, host2,
				LinkType.DEPENDENCY_SET).isOK();

		LinkDescriptor[] sld = validatorService.getPossibleLinks(host1,
				hostee1, LinkType.DEPENDENCY_SET);
		assert null != sld;
		sld = validatorService.getPossibleLinks(host1, hostee3,
				LinkType.DEPENDENCY_SET);
		assert 0 == sld.length;
		sld = validatorService.getPossibleLinks(host2, hostee2,
				LinkType.DEPENDENCY_SET);
		assert 0 == sld.length;

		final Capability consumedService3x = CoreFactory.eINSTANCE
				.createCapability();
		final Requirement consumedService3 = RequirementUtil
				.createRequirement(consumedService3x);
		consumedService3.setName("consumesService3");
		hostee1.getOnlyDependencyRequirements().add(consumedService3);

		assert validatorService.canBeLinkSource(hostee1,
				LinkType.DEPENDENCY_SET).isOK();
		assert validatorService.canBeLinkSource(hostee2,
				LinkType.DEPENDENCY_SET).isOK();
		assert !validatorService.canBeLinkSource(hostee3,
				LinkType.DEPENDENCY_SET).isOK();
		assert validatorService.canBeLinkSource(hostee1, consumedService1,
				LinkType.DEPENDENCY_SET).isOK();
		assert validatorService.canBeLinkSource(hostee1, consumedService3,
				LinkType.DEPENDENCY_SET).isOK();

		assert validatorService.canBeLinkTarget(host1, LinkType.DEPENDENCY_SET)
				.isOK();
		// can be hostee
		assert !validatorService
				.canBeLinkTarget(host2, LinkType.DEPENDENCY_SET).isOK();

		assert validatorService.canCreateLink(hostee1, host1,
				LinkType.DEPENDENCY_SET).isOK();
		assert validatorService.canCreateLink(hostee1, consumedService1, host1,
				null, LinkType.DEPENDENCY_SET).isOK();
		assert validatorService.canCreateLink(hostee1, consumedService1, host1,
				providedService1, LinkType.DEPENDENCY_SET).isOK();
		assert validatorService.canCreateLink(hostee1, consumedService3, host1,
				null, LinkType.DEPENDENCY_SET).isOK();
		assert validatorService.canCreateLink(hostee1, consumedService3, host1,
				providedService1, LinkType.DEPENDENCY_SET).isOK();

		sld = validatorService.getPossibleLinks(host1, hostee1,
				LinkType.DEPENDENCY_SET);
		assert 0 == sld.length : print(sld, "case 1");

		sld = validatorService.getPossibleLinks(hostee1, consumedService1,
				host1, null, LinkType.DEPENDENCY_SET);
		assert 2 == sld.length : print(sld, "case 2");

		sld = validatorService.getPossibleLinks(hostee1, consumedService1,
				host1, providedService1, LinkType.DEPENDENCY_SET);
		assert 2 == sld.length : print(sld, "case 3");

		sld = validatorService.getPossibleLinks(hostee1, consumedService3,
				host1, null, LinkType.DEPENDENCY_SET);
		assert 2 == sld.length : print(sld, "case 4");

		sld = validatorService.getPossibleLinks(hostee1, consumedService3,
				host1, providedService1, LinkType.DEPENDENCY_SET);
		assert 2 == sld.length : print(sld, "case 5");

		sld = validatorService.getPossibleLinks(hostee1, null, host1,
				providedService1, LinkType.DEPENDENCY_SET);
		assert 4 == sld.length : print(sld, "case 6");

		final Capability providedService3 = CoreFactory.eINSTANCE
				.createCapability();
		providedService3.setName("providesService3");
		host1.getOnlyDependencyCapabilities().add(providedService3);

		sld = validatorService.getPossibleLinks(hostee1, host1,
				LinkType.DEPENDENCY_SET);
		assert 8 == sld.length : print(sld, "case 7");

		sld = validatorService.getPossibleLinks(hostee1, consumedService3,
				host1, providedService1, LinkType.DEPENDENCY_SET);
		DependencyLink link = (DependencyLink) sld[0].create();
		System.out.println(link);

		// 2 possibilities are gone since a link was added
		sld = validatorService.getPossibleLinks(hostee1, host1,
				LinkType.ALL_LINK_TYPES);
		assert 4 == sld.length : print(sld, "case 8");

		// test hosting flag ANY for dependency links
		final Capability providedANY = CoreFactory.eINSTANCE.createCapability();
		providedANY.setName("providesAnyService1");
		providedANY.setLinkType(CapabilityLinkTypes.ANY_LITERAL);
		host1.getHostingOrAnyCapabilities().add(providedANY);

		sld = validatorService.getPossibleLinks(host1, hostee1,
				LinkType.DEPENDENCY_SET);
		assert 0 == sld.length : print(sld, "case 1");

		sld = validatorService.getPossibleLinks(hostee1, consumedService1,
				host1, null, LinkType.DEPENDENCY_SET);
		assert 6 == sld.length : print(sld, "case 2");

		sld = validatorService.getPossibleLinks(hostee1, consumedService1,
				host1, providedService1, LinkType.DEPENDENCY_SET);
		assert 2 == sld.length : print(sld, "case 3");

		sld = validatorService.getPossibleLinks(hostee1, consumedService3,
				host1, null, LinkType.DEPENDENCY_SET);
		assert 0 == sld.length : print(sld, "case 4");

		sld = validatorService.getPossibleLinks(hostee1, consumedService3,
				host1, providedService1, LinkType.DEPENDENCY_SET);
		assert 0 == sld.length : print(sld, "case 5");

		sld = validatorService.getPossibleLinks(hostee1, null, host1,
				providedService1, LinkType.DEPENDENCY_SET);
		assert 2 == sld.length : print(sld, "case 6");

		sld = validatorService.getPossibleLinks(hostee1, null, host1,
				providedANY, LinkType.DEPENDENCY_SET);
		assert 2 == sld.length : print(sld, "case 6.5");

		sld = validatorService.getPossibleLinks(hostee1, host1,
				LinkType.DEPENDENCY_SET);
		assert 6 == sld.length : print(sld, "case 7");

		// test hosting flag ANY for hosting links
		// remove existing hosting capability
		host1.getHostingLinks().remove(hLink1);
		host1.getHostingLinks().remove(hLink2);
		host1.getHostingOrAnyCapabilities().remove(provided);

		assert validatorService.canBeLinkEndpoint(host1, LinkType.HOSTING_SET)
				.isOK();

		assert validatorService.canCreateLink(host1, hostee1,
				LinkType.HOSTING_SET).isOK();
		assert !validatorService.canCreateLink(hostee1, host1,
				LinkType.HOSTING_SET).isOK();

		assert validatorService.canCreateLink(host1, hostee1,
				LinkType.HOSTING_SET).isOK();
		assert !host1.isHosting(hostee1, false);
		assert validatorService.canCreateLink(host1, hostee2,
				LinkType.HOSTING_SET).isOK();
		assert !host1.isHosting(hostee2, false);

		hld = validatorService.getPossibleLinks(host1, hostee1,
				LinkType.HOSTING_SET);
		assert null != hld;
		assert 0 != hld.length;
		assert hld[0].getSourceUnit() == host1;
		assert hld[0].getTargetUnit() == hostee1;
		hLink1 = (HostingLink) hld[0].create();

		assert host1.isHosting(hostee1, false);
		assert !validatorService.canCreateLink(host1, hostee1,
				LinkType.HOSTING_SET).isOK();
		assert validatorService.canBeLinkEndpoint(host1, LinkType.HOSTING_SET)
				.isOK();
		assert !validatorService.canBeLinkEndpoint(hostee1,
				LinkType.HOSTING_SET).isOK();
		assert !host1.isHosting(hostee2, false);
		assert validatorService.canCreateLink(host1, hostee2,
				LinkType.HOSTING_SET).isOK();

		hld = validatorService.getPossibleLinks(host1, hostee2,
				LinkType.HOSTING_SET);
		assert null != hld;
		assert 0 != hld.length;
		assert hld[0].getSourceUnit() == host1;
		assert hld[0].getTargetUnit() == hostee2;
		hLink2 = (HostingLink) hld[0].create();

		assert host1.isHosting(hostee1, false);
		assert host1.isHosting(hostee2, false);
		assert !validatorService.canCreateLink(host1, hostee1,
				LinkType.HOSTING_SET).isOK();
		assert validatorService.canBeLinkEndpoint(host1, LinkType.HOSTING_SET)
				.isOK();
		assert !validatorService.canBeLinkEndpoint(hostee1,
				LinkType.HOSTING_SET).isOK();
		assert host1.isHosting(hostee2, false);
		assert !validatorService.canCreateLink(host1, hostee2,
				LinkType.HOSTING_SET).isOK();
		assert !validatorService.canBeLinkEndpoint(hostee2,
				LinkType.HOSTING_SET).isOK();
	}

	private String print(LinkDescriptor[] slds, String prefix) {
		StringBuffer buffer = new StringBuffer();
		buffer.append(prefix);
		buffer.append('\n');
		for (int i = 0; i < slds.length; i++) {
			buffer.append((LinkDescriptor) slds[i]);
			buffer.append('\n');
		}
		System.out.println(buffer);
		return buffer.toString();
	}
}
