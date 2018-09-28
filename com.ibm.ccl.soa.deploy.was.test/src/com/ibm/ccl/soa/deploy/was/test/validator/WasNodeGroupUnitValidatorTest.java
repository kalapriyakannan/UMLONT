/*******************************************************************************
 * Copyright (c) 2003, 2007 IBM Corporation Licensed Material - Property of IBM. All rights reserved.
 *  
 * US Government Users Restricted Rights - Use, duplication or disclosure v1.0 restricted by GSA ADP
 * Schedule Contract with IBM Corp.
 * 
 * Contributors: IBM Corporation - initial API and implementation
 *******************************************************************************/
package com.ibm.ccl.soa.deploy.was.test.validator;

import java.io.IOException;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.emf.ecore.resource.Resource;

import com.ibm.ccl.soa.deploy.core.CapabilityLinkTypes;
import com.ibm.ccl.soa.deploy.core.CoreFactory;
import com.ibm.ccl.soa.deploy.core.MemberLink;
import com.ibm.ccl.soa.deploy.core.Requirement;
import com.ibm.ccl.soa.deploy.core.Topology;
import com.ibm.ccl.soa.deploy.core.test.TopologyTestCase;
import com.ibm.ccl.soa.deploy.core.test.validator.utils.ValidatorTestUtils;
import com.ibm.ccl.soa.deploy.core.validator.IDeployReporter;
import com.ibm.ccl.soa.deploy.core.validator.IDeployValidationContext;
import com.ibm.ccl.soa.deploy.core.validator.matcher.LinkFactory;
import com.ibm.ccl.soa.deploy.was.WasCell;
import com.ibm.ccl.soa.deploy.was.WasCellUnit;
import com.ibm.ccl.soa.deploy.was.WasFactory;
import com.ibm.ccl.soa.deploy.was.WasNode;
import com.ibm.ccl.soa.deploy.was.WasNodeGroup;
import com.ibm.ccl.soa.deploy.was.WasNodeGroupUnit;
import com.ibm.ccl.soa.deploy.was.WasNodeUnit;
import com.ibm.ccl.soa.deploy.was.WasPackage;
import com.ibm.ccl.soa.deploy.was.internal.validator.WasNodeGroupUnitValidator;

/**
 * Tests {@link WasNodeGroupUnitValidator}
 * 
 * @since 3.2
 * 
 */
public class WasNodeGroupUnitValidatorTest extends TopologyTestCase {
	private static final String PROJECT_NAME = "WasNodeGroupUnitValidatorTest"; //$NON-NLS-1$

	private final String STANDARD_6_WASVERSION = "6.0.0.1";//$NON-NLS-1$
	private final String STANDARD_5_WASVERSION = "5.1.0.1";//$NON-NLS-1$

	/**
	 * 
	 * 
	 */
	public WasNodeGroupUnitValidatorTest() {
		super(PROJECT_NAME);
	}

	/*
	 * @see junit.framework.TestCase#tearDown() Uncomment to stop deletion of
	 *      plants topology after test run.
	 */
	protected void tearDown() throws Exception {
	}

	/**
	 * @throws IOException
	 * @throws CoreException
	 * 
	 * 
	 */
	public void testWasNodeGroupUnitValidator() throws IOException,
			CoreException {
		Topology top = createTopology(PROJECT_NAME, true);

		IDeployValidationContext context = createValidationContext(top);
		IDeployReporter reporter = createDeployReporter();
		WasNodeGroupUnitValidator validator = new WasNodeGroupUnitValidator();

		//
		// create wasNodeGroupUnit
		//
		WasNodeGroupUnit wasNodeGroupUnit = WasFactory.eINSTANCE
				.createWasNodeGroupUnit();
		wasNodeGroupUnit.setName("wasNodeGroupUnit"); //$NON-NLS-1$
		wasNodeGroupUnit.setDisplayName("wasNodeGroupUnit"); //$NON-NLS-1$		
		top.getUnits().add(wasNodeGroupUnit);

		//
		// create wasNodeGroup service
		//
		WasNodeGroup wasNodeGroup = WasFactory.eINSTANCE.createWasNodeGroup();
		wasNodeGroup.setName("wasNodeGroup"); //$NON-NLS-1$
		wasNodeGroup.setDisplayName("wasNodeGroup"); //$NON-NLS-1$
		wasNodeGroup.setNodeGroupName("wasNodeGroup"); //$NON-NLS-1$
		wasNodeGroup.setLinkType(CapabilityLinkTypes.ANY_LITERAL);
		wasNodeGroupUnit.getCapabilities().add(wasNodeGroup);

		//
		// Require wasCellUint
		//
		Requirement requiredWasCellUnit = ValidatorTestUtils
				.createMemberRequirement(WasPackage.Literals.WAS_CELL_UNIT,
						"requiredWasCellUnit");//$NON-NLS-1$
		// request expression will be checked by FVT
		wasNodeGroupUnit.getRequirements().add(requiredWasCellUnit);

		WasCellUnit wasCellUnit = WasFactory.eINSTANCE.createWasCellUnit();
		wasCellUnit.setName("wasCellUnit");//$NON-NLS-1$
		wasCellUnit.setDisplayName("wasCellUnit");//$NON-NLS-1$
		top.getUnits().add(wasCellUnit);

		WasCell providedWasCell = WasFactory.eINSTANCE.createWasCell();
		providedWasCell.setName("providedWasCell");//$NON-NLS-1$
		providedWasCell.setDisplayName("providedWasCell");//$NON-NLS-1$
		providedWasCell.setCellName("standAloneCell");//$NON-NLS-1$
		providedWasCell.setIsDistributed(false);
		providedWasCell.setWasVersion("6.0.0.1");//$NON-NLS-1$
		wasCellUnit.getCapabilities().add(providedWasCell);

		// member link between wasNodeUnit and wasCellUnit
		MemberLink cell_NodeMemberLink = CoreFactory.eINSTANCE
				.createMemberLink();
		cell_NodeMemberLink.setTarget(wasNodeGroupUnit);
		cell_NodeMemberLink.setSource(wasCellUnit);
		ValidatorTestUtils.createLinkName(cell_NodeMemberLink);
		wasCellUnit.getMemberLinks().add(cell_NodeMemberLink);

		//
		// Require wasNodeUnit as member
		//
		Requirement requiredWasNodeUnit = ValidatorTestUtils
				.createMemberRequirement(WasPackage.Literals.WAS_NODE_UNIT,
						"requiredWasNodeUnit");//$NON-NLS-1$
		wasNodeGroupUnit.getRequirements().add(requiredWasNodeUnit);
		// create wasNodeUnit
		WasNodeUnit wasNodeUnit = WasFactory.eINSTANCE.createWasNodeUnit();
		wasNodeUnit.setName("wasNodeUnit"); //$NON-NLS-1$
		wasNodeUnit.setDisplayName("wasNodeUnit"); //$NON-NLS-1$		
		top.getUnits().add(wasNodeUnit);
		// add wasNodeService
		WasNode provideWasNode = WasFactory.eINSTANCE.createWasNode();
		provideWasNode.setName("wasNode"); //$NON-NLS-1$
		provideWasNode.setDisplayName("wasNode"); //$NON-NLS-1$
		provideWasNode.setNodeName("Node1");//$NON-NLS-1$
		provideWasNode.setWasVersion(STANDARD_6_WASVERSION);
		provideWasNode.setLinkType(CapabilityLinkTypes.ANY_LITERAL);
		// member link between wasNodeUnit and webSphereAppServerUnit
		MemberLink nodeNGMemberLink = CoreFactory.eINSTANCE.createMemberLink();
		nodeNGMemberLink.setTarget(wasNodeUnit);
		nodeNGMemberLink.setSource(wasNodeGroupUnit);
		ValidatorTestUtils.createLinkName(nodeNGMemberLink);
		wasNodeGroupUnit.getMemberLinks().add(nodeNGMemberLink);

		// /////////////////
		Resource res = top.getEObject().eResource();
		res.save(null);
		// /////////////////

		validator.validate(wasNodeGroupUnit, context, reporter);
		System.out.println("In " + this.getClass()); //$NON-NLS-1$
		dumpMarkers(top);

		// MK 8/8/2007: changed expected error count.  Node is member of node 
		// group but not of cell; this is an error that should be caught by this
		// validator
		ValidatorTestUtils.assertValidationErrorCount(1, top, wasNodeGroupUnit,
				context, reporter, validator);
		// MK 8/8/2007 added check when node is added as a member to the cell
		LinkFactory.createMemberLink(wasCellUnit, wasNodeUnit);
		ValidatorTestUtils.assertValidationErrorCount(0, top, wasNodeGroupUnit,
				context, reporter, validator);
		
		// node group name not empty
		String savedNodeGroupName = wasNodeGroup.getNodeGroupName();
		wasNodeGroup.setNodeGroupName("");//$NON-NLS-1$
		ValidatorTestUtils.assertValidationErrorCount(1, top, wasNodeGroupUnit,
				context, reporter, validator);
		wasNodeGroup.setNodeGroupName(savedNodeGroupName);
		ValidatorTestUtils.assertValidationErrorCount(0, top, wasNodeGroupUnit,
				context, reporter, validator);

		// node members' cadinality determined by distributed will be covered by
		// FVT

		// node members' wasVersion >=6.0, mark to node, no need to check here

	}

}
