/*******************************************************************************
 * Copyright (c) 2003, 2007 IBM Corporation Licensed Material - Property of IBM. All rights reserved.
 *  
 * US Government Users Restricted Rights - Use, duplication or disclosure v1.0 restricted by GSA ADP
 * Schedule Contract with IBM Corp.
 * 
 * Contributors: IBM Corporation - initial API and implementation
 *******************************************************************************/
package com.ibm.ccl.soa.deploy.core.test.validator;

import java.io.IOException;
import java.util.Iterator;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.emf.ecore.resource.Resource;

import com.ibm.ccl.soa.deploy.core.Capability;
import com.ibm.ccl.soa.deploy.core.CapabilityLinkTypes;
import com.ibm.ccl.soa.deploy.core.CoreFactory;
import com.ibm.ccl.soa.deploy.core.DependencyLink;
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
import com.ibm.ccl.soa.deploy.core.validator.matcher.LinkFactory;

/**
 * JUnit test case for recursive links
 * 
 * @author Bill Arnold
 * @author Ed Snible (based on WormHostTest)
 */
public class WormholeFarmTest extends TopologyTestCase {

	// Use instance variables for now
	private Topology top;

	public WormholeFarmTest() {
		super("WormholeTest");
		this.setDeleteProjectOnTearDown(false);
	}

	/**
	 * 
	 */
	public void testWormholeFarm() throws Exception {

		top = createWormholeFarmTopology(3, "Wormhole");

		processTop(top);
		
		addAllToAllRealizationLinks(top);
		
		processTop(top);
	}

	private void processTop(Topology top2) throws IOException, CoreException {
		Resource res = top.getEObject().eResource();
		res.save(null);

		DeployValidatorService service = new DeployValidatorService();
		long prevTime = System.currentTimeMillis();
		service.validate(top);
		long time = System.currentTimeMillis();
		System.out.println(this.getName() + " : Elapsed milliseconds for validation = " + (time - prevTime));
		dumpMarkers(top);
		System.out.println(ValidatorTestUtils.getTopologyErrorDescription(top));
		// assertNoValidationErrors(top);

//		res.unload();
//
//		res.load(Collections.EMPTY_MAP);
//		DeployCoreRoot deployCoreRoot = (DeployCoreRoot) res.getContents().get(0);
//		Topology topology = deployCoreRoot.getTopology();
//		assertNotNull(topology);

		// assertNoValidationErrors(topology);
	}

	private Topology createWormholeFarmTopology(int unitCount, String topologyName) {
		Topology wormholefarm = createTopology(topologyName);

		Unit units[] = new Unit[unitCount];
		Requirement dReqs[] = new Requirement[unitCount];
		Requirement hReqs[] = new Requirement[unitCount];
		Capability caps[] = new Capability[unitCount];
		for (int i = 0; i < unitCount; ++i) {
			Unit u = CoreFactory.eINSTANCE.createUnit();
			units[i] = u;
			u.setConceptual(true);
			u.setName(UnitUtil.generateUniqueName(wormholefarm, "u"));
			Capability cap = CoreFactory.eINSTANCE.createCapability();
			cap.setName(UnitUtil.generateUniqueName(u, "cap"));
			cap.setLinkType(CapabilityLinkTypes.ANY_LITERAL);
			u.getCapabilities().add(cap);
			caps[i] = cap;
			Requirement reqD = CoreFactory.eINSTANCE.createRequirement();
			reqD.setName(UnitUtil.generateUniqueName(u, "req"));
			reqD.setLinkType(RequirementLinkTypes.DEPENDENCY_LITERAL);
			u.getRequirements().add(reqD);
			dReqs[i] = reqD;
			Requirement reqH = CoreFactory.eINSTANCE.createRequirement();
			reqH.setName(UnitUtil.generateUniqueName(u, "req"));
			reqH.setLinkType(RequirementLinkTypes.HOSTING_LITERAL);
			u.getRequirements().add(reqH);
			hReqs[i] = reqH;
			wormholefarm.getUnits().add(u);
		}

		for (int i = 0; i < unitCount; ++i) { // units[i] == source
			for (int j = 0; j < unitCount; ++j) { // units[j] == target
				RealizationLink rl = CoreFactory.eINSTANCE.createRealizationLink();
				rl.setSource(units[i]);
				rl.setTarget(units[j]);
				units[i].getRealizationLinks().add(rl);

				MemberLink ml = CoreFactory.eINSTANCE.createMemberLink();
				ml.setSource(units[i]);
				ml.setTarget(units[j]);
				ml.setName(UnitUtil.generateUniqueName(units[i], "ml"));
				units[i].getMemberLinks().add(ml);

				DependencyLink dl = CoreFactory.eINSTANCE.createDependencyLink();
				dl.setSource(dReqs[i]);
				dl.setTarget(caps[j]);
				dl.setName(UnitUtil.generateUniqueName(units[i], "dl"));
				dReqs[i].setLink(dl);

				HostingLink hl = CoreFactory.eINSTANCE.createHostingLink();
				hl.setSource(units[i]);
				hl.setTarget(units[j]);
				hl.setName(UnitUtil.generateUniqueName(units[i], "hl"));
				units[i].getHostingLinks().add(hl);
			}
		}

		return wormholefarm;
	}
	
	private void addAllToAllRealizationLinks(Topology wormholefarm) {
		for (Iterator<Unit> sourceUIter = top.findAllUnits(); sourceUIter.hasNext();) {
			Unit sourceU = sourceUIter.next();
			for (Iterator<Unit> targetUIter = top.findAllUnits(); targetUIter.hasNext();) {
				Unit targetU = targetUIter.next();
				LinkFactory.createRealizationLink(sourceU, targetU);
			}
		} 
		for (Iterator<Capability> sourceCIter = top.findAllCapabilities(); sourceCIter.hasNext();) {
			Capability sourceC = sourceCIter.next();
			for (Iterator<Capability> targetCIter = top.findAllCapabilities(); targetCIter.hasNext();) {
				Capability targetC = targetCIter.next();
				LinkFactory.createRealizationLink(sourceC, targetC);
			}
		}		
		for (Iterator<Requirement> sourceRIter = top.findAllRequirements(); sourceRIter.hasNext();) {
			Requirement sourceR = sourceRIter.next();
			for (Iterator<Requirement> targetRIter = top.findAllRequirements(); targetRIter.hasNext();) {
				Requirement targetR = targetRIter.next();
				LinkFactory.createRealizationLink(sourceR, targetR);
			}
		}		
	}
} // end JUnit test WormholeTest
