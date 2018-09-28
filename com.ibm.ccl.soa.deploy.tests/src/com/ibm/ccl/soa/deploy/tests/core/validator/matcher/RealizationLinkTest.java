/*******************************************************************************
 * Copyright (c) 2003, 2007 IBM Corporation Licensed Material - Property of IBM. All rights reserved.
 *  
 * US Government Users Restricted Rights - Use, duplication or disclosure v1.0 restricted by GSA ADP
 * Schedule Contract with IBM Corp.
 * 
 * Contributors: IBM Corporation - initial API and implementation
 *******************************************************************************/
package com.ibm.ccl.soa.deploy.tests.core.validator.matcher;

import com.ibm.ccl.soa.deploy.core.Capability;
import com.ibm.ccl.soa.deploy.core.CapabilityLinkTypes;
import com.ibm.ccl.soa.deploy.core.ConceptualNode;
import com.ibm.ccl.soa.deploy.core.CoreFactory;
import com.ibm.ccl.soa.deploy.core.Requirement;
import com.ibm.ccl.soa.deploy.core.RequirementLinkTypes;
import com.ibm.ccl.soa.deploy.core.RequirementUsage;
import com.ibm.ccl.soa.deploy.core.Topology;
import com.ibm.ccl.soa.deploy.core.Unit;
import com.ibm.ccl.soa.deploy.core.test.TopologyTestCase;
import com.ibm.ccl.soa.deploy.core.validator.DeployValidatorService;
import com.ibm.ccl.soa.deploy.core.validator.DomainValidator;
import com.ibm.ccl.soa.deploy.core.validator.matcher.LinkFactory;
import com.ibm.ccl.soa.deploy.core.validator.matcher.LinkType;
import com.ibm.ccl.soa.deploy.internal.core.validator.CoreDomainValidator;
import com.ibm.ccl.soa.deploy.was.WasPackage;

public class RealizationLinkTest extends TopologyTestCase {

	public static final String PROJECT_NAME = RealizationLinkTest.class
			.getName();

	private static final DeployValidatorService dvs = DeployValidatorService.getDefaultValidatorService();
	DomainValidator validator = new CoreDomainValidator();

	public RealizationLinkTest() {
		super(PROJECT_NAME);
	}

	public void testOptionalHostingRequirement() throws Exception {
		Topology top = createTopology("testOptionalHostingRequirement");

		// set up: create hostee with hosting requirement A and optional hosting
		// requirment B
		// create host with any capability A
		// create conceptual node

		Unit hostee = CoreFactory.eINSTANCE.createUnit();
		hostee.setName("hostee");
		top.getUnits().add(hostee);
		Requirement wasSystemReq = addRequirement(hostee, "wasSystem",
				WasPackage.Literals.WAS_SYSTEM,
				RequirementLinkTypes.HOSTING_LITERAL);
		Requirement wasNodeReq = addRequirement(hostee, "wasNode",
				WasPackage.Literals.WAS_NODE,
				RequirementLinkTypes.HOSTING_LITERAL);
		wasNodeReq.setUse(RequirementUsage.OPTIONAL_LITERAL);

		Unit host = CoreFactory.eINSTANCE.createUnit();
		host.setName("host");
		top.getUnits().add(host);
		Capability wasSystemCap = addCapability(host, "wasSystemCapability",
				WasPackage.Literals.WAS_SYSTEM, CapabilityLinkTypes.ANY_LITERAL);

		ConceptualNode node = CoreFactory.eINSTANCE.createConceptualNode();
		node.setName("node");
		node.setConceptual(true);
		top.getUnits().add(host);

		// test1: host hostee on host
		assert dvs.canCreateLink(host, hostee, LinkType.HOSTING_SET).isOK();

		// test2: host hostee on node, realize node with host
		assert dvs.canCreateLink(node, hostee, LinkType.HOSTING_SET).isOK();
		LinkFactory.createHostingLink(node, hostee);
		assert dvs.canCreateLink(node, host, LinkType.REALIZATION_SET).isOK();

// // test3: realize node with host, host hostee on node
// ResolutionUtils.unhost(hostee);
// assert dvs.canCreateLink(node, host, LinkType.REALIZATION_SET).isOK();
// LinkFactory.createRealizationLink(node, host);
// assert dvs.canCreateLink(node, hostee, LinkType.HOSTING_SET).isOK();

	}

}
