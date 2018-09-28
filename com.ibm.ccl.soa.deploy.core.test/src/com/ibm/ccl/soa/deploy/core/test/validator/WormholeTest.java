/*******************************************************************************
 * Copyright (c) 2003, 2007 IBM Corporation Licensed Material - Property of IBM. All rights reserved.
 *  
 * US Government Users Restricted Rights - Use, duplication or disclosure v1.0 restricted by GSA ADP
 * Schedule Contract with IBM Corp.
 * 
 * Contributors: IBM Corporation - initial API and implementation
 *******************************************************************************/
package com.ibm.ccl.soa.deploy.core.test.validator;

import java.util.Collections;

import org.eclipse.emf.ecore.resource.Resource;

import com.ibm.ccl.soa.deploy.core.Capability;
import com.ibm.ccl.soa.deploy.core.CapabilityLinkTypes;
import com.ibm.ccl.soa.deploy.core.CoreFactory;
import com.ibm.ccl.soa.deploy.core.DependencyLink;
import com.ibm.ccl.soa.deploy.core.DeployCoreRoot;
import com.ibm.ccl.soa.deploy.core.HostingLink;
import com.ibm.ccl.soa.deploy.core.MemberLink;
import com.ibm.ccl.soa.deploy.core.RealizationLink;
import com.ibm.ccl.soa.deploy.core.Requirement;
import com.ibm.ccl.soa.deploy.core.RequirementLinkTypes;
import com.ibm.ccl.soa.deploy.core.Topology;
import com.ibm.ccl.soa.deploy.core.Unit;
import com.ibm.ccl.soa.deploy.core.test.TopologyTestCase;
import com.ibm.ccl.soa.deploy.core.test.validator.utils.ValidatorTestUtils;
import com.ibm.ccl.soa.deploy.core.util.UnitUtil;
import com.ibm.ccl.soa.deploy.core.validator.DeployValidatorService;

/**
 * JUnit test case for recursive links
 * 
 * <p>
 * As part of working this test case produces a file, Wormhole.topology, which is useful
 * for GUI tests. Unfortunately, this test deletes the file -- the only way to
 * capture it is to interrupt this test after it has produced the file.
 * 
 * @author Ed Snible (updates)
 */
public class WormholeTest extends TopologyTestCase {

	// Use instance variables for now
	private Topology top;

	public WormholeTest() {
		super("WormholeTest");
	}

	/*
	 * @see junit.framework.TestCase#tearDown() Uncomment to stop deletion of
	 *      plants topology after test run.
	 */
	protected void tearDown() throws Exception {
	}

	/**
	 * 
	 */
	public void testWormhole() throws Exception {

		top = createWormholeTopology();
		
		

		Resource res = top.getEObject().eResource();
		res.save(null);

		DeployValidatorService service = new DeployValidatorService();
		long prevTime = System.currentTimeMillis();
		service.validate(top);
		long time = System.currentTimeMillis();
		System.out.println(this.getName()
				+ " : Elapsed milliseconds for validation = "
				+ (time - prevTime));
		dumpMarkers(top);
		System.out.println(ValidatorTestUtils.getTopologyErrorDescription(top));
//		assertNoValidationErrors(top);

		res.unload();

		res.load(Collections.EMPTY_MAP);
		DeployCoreRoot deployCoreRoot = (DeployCoreRoot) res.getContents().get(
				0);
		Topology topology = deployCoreRoot.getTopology();
		assertNotNull(topology);

//		assertNoValidationErrors(topology);
	}

	private Topology createWormholeTopology() {
		Topology wormhole = createTopology("Wormhole");
		
		Unit u = CoreFactory.eINSTANCE.createUnit();
		u.setName(UnitUtil.generateUniqueName(wormhole, "u"));
		Capability cap = CoreFactory.eINSTANCE.createCapability();
		cap.setName(UnitUtil.generateUniqueName(u, "cap"));
		cap.setLinkType(CapabilityLinkTypes.ANY_LITERAL);
		u.getCapabilities().add(cap);
		Requirement reqD = CoreFactory.eINSTANCE.createRequirement();
		reqD.setName(UnitUtil.generateUniqueName(u, "req"));
		reqD.setLinkType(RequirementLinkTypes.DEPENDENCY_LITERAL);
		u.getRequirements().add(reqD);
		Requirement reqH = CoreFactory.eINSTANCE.createRequirement();
		reqH.setName(UnitUtil.generateUniqueName(u, "req"));
		reqH.setLinkType(RequirementLinkTypes.HOSTING_LITERAL);
		u.getRequirements().add(reqH);
		wormhole.getUnits().add(u);
		
		RealizationLink rl = CoreFactory.eINSTANCE.createRealizationLink();
		rl.setSource(u);
		rl.setTarget(u);
		u.getRealizationLinks().add(rl);
		
		MemberLink ml = CoreFactory.eINSTANCE.createMemberLink();
		ml.setSource(u);
		ml.setTarget(u);
		ml.setName(UnitUtil.generateUniqueName(u, "ml"));
		u.getMemberLinks().add(ml);
		
		DependencyLink dl = CoreFactory.eINSTANCE.createDependencyLink();
		dl.setSource(reqD);
		dl.setTarget(cap);
		dl.setName(UnitUtil.generateUniqueName(u, "dl"));
		reqD.setLink(dl);
		
		HostingLink hl = CoreFactory.eINSTANCE.createHostingLink();
		hl.setSource(u);
		hl.setTarget(u);
		hl.setName(UnitUtil.generateUniqueName(u, "hl"));
		u.getHostingLinks().add(hl);

		return wormhole;
	}

} // end JUnit test WormholeTest
