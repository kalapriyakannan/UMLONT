/*******************************************************************************
 * Copyright (c) 2003, 2006 IBM Corporation Licensed Material - Property of IBM. All rights reserved.
 *  
 * US Government Users Restricted Rights - Use, duplication or disclosure v1.0 restricted by GSA ADP
 * Schedule Contract with IBM Corp.
 * 
 * Contributors: IBM Corporation - initial API and implementation
 *******************************************************************************/

package com.ibm.ccl.soa.deploy.core.test;

import java.util.Iterator;

import com.ibm.ccl.soa.deploy.core.Capability;
import com.ibm.ccl.soa.deploy.core.CapabilityLinkTypes;
import com.ibm.ccl.soa.deploy.core.CoreFactory;
import com.ibm.ccl.soa.deploy.core.DependencyLink;
import com.ibm.ccl.soa.deploy.core.HostingLink;
import com.ibm.ccl.soa.deploy.core.Requirement;
import com.ibm.ccl.soa.deploy.core.RequirementExpression;
import com.ibm.ccl.soa.deploy.core.RequirementLinkTypes;
import com.ibm.ccl.soa.deploy.core.RequirementUsage;
import com.ibm.ccl.soa.deploy.core.Topology;
import com.ibm.ccl.soa.deploy.core.Unit;
import com.ibm.ccl.soa.deploy.core.validator.DeployValidatorService;
import com.ibm.ccl.soa.deploy.core.validator.ValidatorUtils;
import com.ibm.ccl.soa.deploy.core.validator.expression.Equals;
import com.ibm.ccl.soa.deploy.core.validator.status.IDeployStatus;

/**
 * Topology benchmark tests.
 */
public class TopologyBenchmark extends TopologyTestCase {

	public TopologyBenchmark() {
		super("TopologyBenchmark");
	}

	/**
	 * Tests the performance of the topology.
	 */
	public void testPerformance() throws Exception {
		benchmark(10);
		benchmark(100);
		benchmark(1000);
		benchmark(10000);
	}

	/**
	 * Creates a test unit.
	 * 
	 * Unit has a hosting and dependency capability, and requirements for a
	 * hosting and dependency capabilities with requirement expressions for
	 * specific names.
	 * 
	 * @return the created unit.
	 */
	protected Unit createTestUnit() {
		Unit unit = CoreFactory.eINSTANCE.createUnit();
		unit.setName("unit");

		Capability hosting = CoreFactory.eINSTANCE.createCapability();
		hosting.setName("hosting");
		hosting.setLinkType(CapabilityLinkTypes.HOSTING_LITERAL);
		unit.getCapabilities().add(hosting);

		Capability dependency = CoreFactory.eINSTANCE.createCapability();
		dependency.setName("dependency");
		dependency.setLinkType(CapabilityLinkTypes.DEPENDENCY_LITERAL);
		unit.getCapabilities().add(dependency);

		Requirement hostingReq = CoreFactory.eINSTANCE.createRequirement();
		hostingReq.setName("hostingReq");
		hostingReq.setLinkType(RequirementLinkTypes.HOSTING_LITERAL);
		hostingReq.setUse(RequirementUsage.REQUIRED_LITERAL);
		unit.getRequirements().add(hostingReq);

		RequirementExpression hostingReqExp = CoreFactory.eINSTANCE
				.createRequirementExpression();
		hostingReqExp.setName("hostingReqExp");
		hostingReqExp.setAttributeName("name");
		hostingReqExp.setInterpreter(Equals.INTERPRETER_ID);
		hostingReqExp.setValue(hosting.getName());
		hostingReq.getExpressions().add(hostingReqExp);

		Requirement dependencyReq = CoreFactory.eINSTANCE.createRequirement();
		dependencyReq.setName("dependencyReq");
		dependencyReq.setLinkType(RequirementLinkTypes.DEPENDENCY_LITERAL);
		dependencyReq.setUse(RequirementUsage.REQUIRED_LITERAL);
		unit.getRequirements().add(dependencyReq);

		RequirementExpression dependencyReqExp = CoreFactory.eINSTANCE
				.createRequirementExpression();
		dependencyReqExp.setName("dependencyReqExp");
		dependencyReqExp.setAttributeName("name");
		dependencyReqExp.setInterpreter(Equals.INTERPRETER_ID);
		dependencyReqExp.setValue(dependency.getName());
		dependencyReq.getExpressions().add(dependencyReqExp);

		return unit;
	}

	protected void benchmark(int count) throws Exception {
		Topology top = createTopology("testPerformance" + count);
		System.out.println("Benchmarking " + count + " synthetic units");

		//
		// Create topology
		//
		long start = System.currentTimeMillis();
		Unit last = createTestUnit();
		last.setName("unit0");
		top.getUnits().add(last);
		last.getRequirements().clear();

		for (int i = 1; i < count; i++) {
			Unit unit = createTestUnit();
			unit.setName("unit" + i);
			top.getUnits().add(unit);

			HostingLink hlink = CoreFactory.eINSTANCE.createHostingLink();
			hlink.setName("hosting link");
			hlink.setTarget(unit);
			last.getHostingLinks().add(hlink);

			DependencyLink dLink = CoreFactory.eINSTANCE.createDependencyLink();
			dLink.setName("dependency link");
			dLink.setTarget((Capability) last.getCapabilities().get(1));
			((Requirement) unit.getRequirements().get(1)).setLink(dLink);

			last = unit;
		}

		long duration = System.currentTimeMillis() - start;
		System.out.println("\tcreate-topology=" + duration);

		//
		// Find hosting links
		//
		start = System.currentTimeMillis();
		int hLinkCount = 0;
		for (Iterator iter = top.findAllHostingCapabilities(); iter.hasNext();) {
			iter.next();
			hLinkCount++;
		}
		duration = System.currentTimeMillis() - start;
		System.out.println("\tfind-all-hosting-links-and-iterate=" + duration);
		assert hLinkCount == count : hLinkCount;

		//
		// Find hosts
		//
		start = System.currentTimeMillis();
		Unit[] hosts = top.findHosts((Unit) top.getUnits().get(1));
		duration = System.currentTimeMillis() - start;
		System.out.println("\tfind-hosts=" + duration);
		assert hosts.length == 1;

		//
		// Find dependency links
		//
		start = System.currentTimeMillis();
		Requirement[] depSources = top
				.findDependentRequirements((Capability) ((Unit) top.getUnits()
						.get(1)).getCapabilities().get(1));
		duration = System.currentTimeMillis() - start;
		System.out.println("\tfind-dependency-requiremenst=" + duration);
		assert depSources.length == 1;

		//
		// Validate topology
		//
		DeployValidatorService service = getValidatorService();
		start = System.currentTimeMillis();
		service.validate(top);
		duration = System.currentTimeMillis() - start;
		System.out.println("\tvalidation=" + duration);

		//
		// Topology should not have any validation errors.
		//
		for (Iterator iter = ValidatorUtils.getDeployStatusRecursive(top, null)
				.iterator(); iter.hasNext();) {
			IDeployStatus status = (IDeployStatus) iter.next();
			assert false : getString(status);
		}

		//
		// Save topology
		//
		start = System.currentTimeMillis();
		top.eResource().save(null);
		duration = System.currentTimeMillis() - start;
		System.out.println("\tsave=" + duration);
	}
}
