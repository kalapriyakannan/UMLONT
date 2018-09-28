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
import com.ibm.ccl.soa.deploy.core.Requirement;
import com.ibm.ccl.soa.deploy.core.Topology;
import com.ibm.ccl.soa.deploy.core.test.TopologyTestCase;
import com.ibm.ccl.soa.deploy.core.test.validator.utils.ValidatorTestUtils;
import com.ibm.ccl.soa.deploy.core.validator.IDeployReporter;
import com.ibm.ccl.soa.deploy.core.validator.IDeployValidationContext;
import com.ibm.ccl.soa.deploy.os.OsFactory;
import com.ibm.ccl.soa.deploy.os.PortConsumer;
import com.ibm.ccl.soa.deploy.was.WasDeploymentManager;
import com.ibm.ccl.soa.deploy.was.WasDeploymentManagerUnit;
import com.ibm.ccl.soa.deploy.was.WasFactory;
import com.ibm.ccl.soa.deploy.was.WasNode;
import com.ibm.ccl.soa.deploy.was.WasNodeUnit;
import com.ibm.ccl.soa.deploy.was.WasPackage;
import com.ibm.ccl.soa.deploy.was.WasProfileTypeEnum;
import com.ibm.ccl.soa.deploy.was.internal.validator.WasDeploymentManagerUnitValidator;

/**
 * Tests {@link WasDeploymentManagerUnitValidator}
 * 
 * @since 3.2
 * 
 */
public class WasDeploymentManagerUnitValidatorTest extends TopologyTestCase {
	private static final String PROJECT_NAME = "WasDeploymentManagerUnitValidatorTest"; //$NON-NLS-1$

	/**
	 * 
	 * 
	 */
	public WasDeploymentManagerUnitValidatorTest() {
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
	 */
	public void testWasDeploymentManagerUnitValidator() throws IOException,
			CoreException {
		Topology top = createTopology(PROJECT_NAME, true);

		IDeployValidationContext context = createValidationContext(top);
		IDeployReporter reporter = createDeployReporter();
		WasDeploymentManagerUnitValidator validator = new WasDeploymentManagerUnitValidator();

		//
		// create WasDeploymentManagerUnit
		//
		WasDeploymentManagerUnit wasDMGRUnit = WasFactory.eINSTANCE
				.createWasDeploymentManagerUnit();
		wasDMGRUnit.setName("wasDMGRUnit"); //$NON-NLS-1$
		wasDMGRUnit.setDisplayName("wasDMGRUnit"); //$NON-NLS-1$		
		top.getUnits().add(wasDMGRUnit);

		//
		// create WasDeploymentManager service
		//
		WasDeploymentManager wasDmgrCap = WasFactory.eINSTANCE
				.createWasDeploymentManager();
		wasDmgrCap.setName("wasDmgr"); //$NON-NLS-1$
		wasDmgrCap.setDisplayName("wasDmgr"); //$NON-NLS-1$
		wasDmgrCap.setLinkType(CapabilityLinkTypes.ANY_LITERAL);
		wasDMGRUnit.getCapabilities().add(wasDmgrCap);

		//
		// Create portConsumer service
		//
		PortConsumer portConsumerCap = OsFactory.eINSTANCE.createPortConsumer();
		portConsumerCap.setName("portConsumer"); //$NON-NLS-1$
		portConsumerCap.setDisplayName("portConsumer"); //$NON-NLS-1$
		portConsumerCap.setLinkType(CapabilityLinkTypes.ANY_LITERAL);
		wasDMGRUnit.getCapabilities().add(portConsumerCap);

		// Require node unit
// Requirement requiredWasNodeUnit =
// ValidatorTestUtils.createMemberRequirement(WasPackage.Literals.WAS_NODE_UNIT,
// "requiredWasNodeUnit"); //$NON-NLS-1$
// wasDMGRUnit.getRequirements().add(requiredWasNodeUnit);

		Requirement requiredWasNode = ValidatorTestUtils
				.createHostingRequirement(WasPackage.Literals.WAS_NODE,
						"requiredWasNodeUnit"); //$NON-NLS-1$
		wasDMGRUnit.getRequirements().add(requiredWasNode);

		WasNodeUnit wasNodeUnit = WasFactory.eINSTANCE.createWasNodeUnit();
		wasNodeUnit.setName("wasNodeUnit");//$NON-NLS-1$
		wasNodeUnit.setDisplayName("wasNodeUnit");//$NON-NLS-1$
		top.getUnits().add(wasNodeUnit);

		//
		// create wasNode service
		//
		WasNode wasNodeCap = WasFactory.eINSTANCE.createWasNode();
		wasNodeCap.setName("wasNode");//$NON-NLS-1$
		wasNodeCap.setDisplayName("wasNode");//$NON-NLS-1$
		wasNodeCap.setProfileType(WasProfileTypeEnum.DMGR_LITERAL);
		wasNodeCap.setProfileLocation("C:\\Program Files\\IBM\\WebSphere_2\\");//$NON-NLS-1$
		wasNodeUnit.getCapabilities().add(wasNodeCap);

		ValidatorTestUtils.hosts(wasNodeUnit, wasDMGRUnit);
// // member link between WASServer and WasNodeUnit
// MemberLink serverNodeMemberLink = CoreFactory.eINSTANCE.createMemberLink();
// serverNodeMemberLink.setTarget(wasDMGRUnit);
// serverNodeMemberLink.setSource(wasNodeUnit);
// ValidatorTestUtils.createLinkName(serverNodeMemberLink);
// wasNodeUnit.getMemberLinks().add(serverNodeMemberLink);

		// /////////////////
		Resource res = top.getEObject().eResource();
		res.save(null);
		// /////////////////

		validator.validate(wasDMGRUnit, context, reporter);
		System.out.println("In " + this.getClass()); //$NON-NLS-1$
		dumpMarkers(top);

		ValidatorTestUtils.assertValidationErrorCount(0, top, wasDMGRUnit,
				context, reporter, validator);

		wasNodeCap.setProfileType(WasProfileTypeEnum.DEFAULT_LITERAL);
		ValidatorTestUtils.assertValidationErrorCount(0, top, wasDMGRUnit,
				context, reporter, validator);// marker to Node, not dmgr

	}
}
