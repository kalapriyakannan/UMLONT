/*******************************************************************************
 * Copyright (c) 2003, 2007 IBM Corporation Licensed Material - Property of IBM. All rights reserved.
 *  
 * US Government Users Restricted Rights - Use, duplication or disclosure v1.0 restricted by GSA ADP
 * Schedule Contract with IBM Corp.
 * 
 * Contributors: IBM Corporation - initial API and implementation
 *******************************************************************************/
package com.ibm.ccl.soa.deploy.core.test.validator;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

import junit.framework.TestSuite;

import org.eclipse.core.runtime.IStatus;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.util.EcoreUtil;

import com.ibm.ccl.soa.deploy.core.AttributeMetaData;
import com.ibm.ccl.soa.deploy.core.Capability;
import com.ibm.ccl.soa.deploy.core.CapabilityLinkTypes;
import com.ibm.ccl.soa.deploy.core.ConfigurationContract;
import com.ibm.ccl.soa.deploy.core.CoreFactory;
import com.ibm.ccl.soa.deploy.core.CorePackage;
import com.ibm.ccl.soa.deploy.core.ExtendedAttribute;
import com.ibm.ccl.soa.deploy.core.IDecoratorSemanticConstants;
import com.ibm.ccl.soa.deploy.core.RealizationLink;
import com.ibm.ccl.soa.deploy.core.Requirement;
import com.ibm.ccl.soa.deploy.core.Topology;
import com.ibm.ccl.soa.deploy.core.Unit;
import com.ibm.ccl.soa.deploy.core.test.TopologyTestCase;
import com.ibm.ccl.soa.deploy.core.test.validator.utils.ValidatorTestUtils;
import com.ibm.ccl.soa.deploy.core.validator.DeployValidatorService;
import com.ibm.ccl.soa.deploy.core.validator.matcher.LinkDescriptor;
import com.ibm.ccl.soa.deploy.core.validator.matcher.LinkFactory;
import com.ibm.ccl.soa.deploy.core.validator.matcher.LinkType;
import com.ibm.ccl.soa.deploy.core.validator.resolution.ResolutionUtils;
import com.ibm.ccl.soa.deploy.core.validator.status.ICoreProblemType;
import com.ibm.ccl.soa.deploy.internal.core.validator.matcher.RealizationLinkMatcher;

/**
 *
 */
public class RealizationValidationTest extends TopologyTestCase {

	private static final String PROJECT_NAME = "RealizationValidationTest";

	private static final EClass CAPABILITY = CorePackage.Literals.CAPABILITY;

	RealizationLinkMatcher rlm = new RealizationLinkMatcher();
	DeployValidatorService dvs = DeployValidatorService.getDefaultValidatorService();

	public RealizationValidationTest() {
		super(PROJECT_NAME);
	}

	public RealizationValidationTest(String name) {
		super(name);
	}
	
	public static TestSuite suite() {
		TestSuite suite = new TestSuite();
		//suite.addTest(new RealizationValidationTest("testMultipleRealizations"));
		suite.addTestSuite(RealizationValidationTest.class);
		return suite;
	}

	/*
	 * @see junit.framework.TestCase#setUp()
	 */
	protected void setUp() throws Exception {
		super.setUp();
	}

	public void testConceptualUnitRealized() throws Exception {
		Topology t = createTopology("testConceptualUnitRealized");
		
		assert t.getConfigurationContract() == null;

		Unit conceptualC = createConceptualUnit(t, "conceptualC");

		dvs.validate(t);
		assertHasErrorStatus(t, ICoreProblemType.CONCEPTUAL_UNIT_NOT_REALIZED);

		t.setDecoratorSemantic(IDecoratorSemanticConstants.BusinessApplicationDS_ID);
		dvs.validate(t);
		assertHasErrorStatus(t, ICoreProblemType.CONCEPTUAL_UNIT_NOT_REALIZED);

		t.setDecoratorSemantic(IDecoratorSemanticConstants.TemplateDesignDS_ID);
		dvs.validate(t);
		assertHasErrorStatus(t, ICoreProblemType.CONCEPTUAL_UNIT_NOT_REALIZED);

		t.setDecoratorSemantic(IDecoratorSemanticConstants.DeploymentDS_ID);
		dvs.validate(t);
		assertHasErrorStatus(t, ICoreProblemType.CONCEPTUAL_UNIT_NOT_REALIZED);

		t.setDecoratorSemantic(IDecoratorSemanticConstants.InfrastructureDS_ID);
		dvs.validate(t);
		assertHasErrorStatus(t, ICoreProblemType.CONCEPTUAL_UNIT_NOT_REALIZED);
		
		ConfigurationContract cc = CoreFactory.eINSTANCE.createExplicitContract();
		
		addExplicitContractDefaultPublic(t);
		
		t.setDecoratorSemantic(IDecoratorSemanticConstants.BusinessApplicationDS_ID);
		dvs.validate(t);
		assertHasStatus(t, ICoreProblemType.CONCEPTUAL_UNIT_NOT_REALIZED, IStatus.INFO);

		t.setDecoratorSemantic(IDecoratorSemanticConstants.TemplateDesignDS_ID);
		dvs.validate(t);
		assertHasStatus(t, ICoreProblemType.CONCEPTUAL_UNIT_NOT_REALIZED, IStatus.INFO);

		t.setDecoratorSemantic(IDecoratorSemanticConstants.DeploymentDS_ID);
		dvs.validate(t);
		assertHasStatus(t, ICoreProblemType.CONCEPTUAL_UNIT_NOT_REALIZED, IStatus.INFO);

		t.setDecoratorSemantic(IDecoratorSemanticConstants.InfrastructureDS_ID);
		dvs.validate(t);
		assertHasStatus(t, ICoreProblemType.CONCEPTUAL_UNIT_NOT_REALIZED, IStatus.INFO);
		dumpStatus(t);
	}

	public void testMultipleRealizations() throws Exception {
		Topology t = createTopology("testMultipleRealizations");

		Unit conceptualC = createConceptualUnit(t, "conceptualC");

		Unit physicalA = createPhysicalUnit(t, "physicalA");
		LinkFactory.createRealizationLink(conceptualC, physicalA);
		dvs.validate(t);
		assertNoValidationErrors(t);

		Unit physicalB = createPhysicalUnit(t, "physicalB");
		LinkFactory.createRealizationLink(conceptualC, physicalB);
		dvs.validate(t);
		assertHasNoErrorStatus(t,
				ICoreProblemType.CONCEPTUAL_UNIT_HAS_MULTIPLE_REALIZATION_LINKS);
	}

	public void testRealizationsNoConceptualUnits() throws Exception {
		Topology t = createTopology("testRealizationsNoConceptualUnits");

		Unit physicalA = createPhysicalUnit(t, "physicalA");
		Unit physicalB = createPhysicalUnit(t, "physicalB");
		LinkDescriptor d = new LinkDescriptor(LinkType.REALIZATION, physicalA,
				physicalB);
		d.create();

		dvs.validate(t);
		assertHasErrorStatus(t, ICoreProblemType.NON_CONCEPTUAL_UNIT_REALIZED);
	}

	public void testBadRealizationLinks() throws Exception {
		Topology t = createTopology("testBadRealizationLinks");

		Unit conceptualC = createConceptualUnit(t, "C");
		Unit physicalA = createPhysicalUnit(t, "A");
		RealizationLink link = LinkFactory.createRealizationLink(conceptualC,
				physicalA);
		dvs.validate(t);
		assertHasNoErrorStatus(t);

		t.getUnits().remove(physicalA);
		link.setTarget(null);
		dvs.validate(t);
		assertHasErrorStatus(t, ICoreProblemType.LINK_TARGET_UNDEFINED);
	}

	public void testTypeMismatch() throws Exception {
		Topology t = createTopology("testTypeMismatch");

		Unit conceptualC = createConceptualUnit(t, "conceptualC");
		Unit physicalA = createConceptualUnit(t, "physicalA");
		Capability capA = addCapability(physicalA, "capA");
		Requirement reqA = addRequirement(physicalA, "reqA");

		RealizationLink l = (RealizationLink) (new LinkDescriptor(
				LinkType.REALIZATION, conceptualC, physicalA)).create();
		dvs.validate(t);
//		assertHasNoErrorStatus(t);
		assert ValidatorTestUtils.getTopologyStatusOfSeverityCount(t, IStatus.ERROR) == 1;
		assertHasErrorStatus(t, ICoreProblemType.CONCEPTUAL_UNIT_NOT_REALIZED);

		t.getRealizationLinks().remove(l);
		// create explicitly because LinkFactory won't allow it
		l = CoreFactory.eINSTANCE.createRealizationLink();
		l.setSource(conceptualC);
		l.setTarget(capA);
		l.setName(conceptualC.getName() + "RealizedBy" + capA.getName()); //$NON-NLS-1$
		t.getRealizationLinks().add(l);
		dvs.validate(t);
		assertHasErrorStatus(t,
				ICoreProblemType.REALIZATION_LINK_SOURCE_TARGET_TYPE_MISMATCH);

		t.getRealizationLinks().remove(l);
		// create explicitly because LinkFactory won't allow it
		l = CoreFactory.eINSTANCE.createRealizationLink();
		l.setSource(conceptualC);
		l.setTarget(reqA);
		l.setName(conceptualC.getName() + "RealizedBy" + reqA.getName()); //$NON-NLS-1$
		t.getRealizationLinks().add(l);
		dvs.validate(t);
		assertHasErrorStatus(t,
				ICoreProblemType.REALIZATION_LINK_SOURCE_TARGET_TYPE_MISMATCH);

		t.getRealizationLinks().remove(l);
		Unit cn = CoreFactory.eINSTANCE.createConceptualNode();
		cn.setName("conceptualNode");
		cn.setConceptual(true);
		t.getUnits().add(cn);
		LinkFactory.createRealizationLink(conceptualC, cn);
		dvs.validate(t);
		// assertHasErrorStatus (t,
		// ICoreProblemType.REALIZATION_LINK_SOURCE_TARGET_TYPE_MISMATCH);
	}

	public void testSelfLink() throws Exception {
		Topology t = createTopology("testSelfLink");

		Unit conceptualC = createConceptualUnit(t, "conceptualC");
		LinkFactory.createRealizationLink(conceptualC, conceptualC);
		dvs.validate(t);
		assertHasErrorStatus(t,
				ICoreProblemType.REALIZATION_LINK_SOURCE_TARGET_SAME);
	}

	public void testUnmatchedCapability() throws Exception {
		Topology t = createTopology("testUnmatchedCapability");

		Unit conceptualC = createConceptualUnit(t, "conceptualC");
		addCapability(conceptualC, "cap");
		Unit physicalU = createPhysicalUnit(t, "physicalU");
		LinkFactory.createRealizationLink(conceptualC, physicalU);
		dvs.validate(t);
// System.out.println("testUnmatchedCapability\n" +
// ValidatorTestUtils.getTopologyErrorDescription(t));
		assertHasErrorStatus(t, ICoreProblemType.REALIZATION_LINK_INVALID);
	}

	public void testUnmatchedRequirement() throws Exception {
		Topology t = createTopology("testUnmatchedRequirement");

		Unit conceptualC = createConceptualUnit(t, "conceptualC");
		addRequirement(conceptualC, "req");
		Unit physicalU = createPhysicalUnit(t, "physicalU");
		LinkFactory.createRealizationLink(conceptualC, physicalU);
		dvs.validate(t);
		assertHasErrorStatus(t,
				ICoreProblemType.REALIZATION_LINK_UNMATCHED_REQUIREMENT);
	}

	public void testRealizedCapOnNonConceptualUnit() throws Exception {
		Topology t = createTopology("testRealizedCapOnNonConceptualUnit");

		Unit physicalA = createUnit(t, "physicalA");
		Capability physicalACap = addCapability(physicalA, "physicalACap");

		Unit physicalB = createPhysicalUnit(t, "physicalB");
		Capability physicalBCap = addCapability(physicalB, "physicalBCap");

		physicalA.setConceptual(true);
		LinkFactory.createRealizationLink(physicalACap, physicalBCap);
		physicalA.setConceptual(false);
		dvs.validate(t);
// System.out.println("testRealizedCapOnNonConceptualUnit\n" +
// ValidatorTestUtils.getTopologyErrorDescription(t));
		assertHasErrorStatus(t,
				ICoreProblemType.CAPABILITY_ON_NON_CONCEPTUAL_UNIT_REALIZED);
	}

	public void testRealizedCapOnNonRealizedUnit() throws Exception {
		Topology t = createTopology("testRealizedCapOnNonRealizedUnit");

		Unit conceptualA = createUnit(t, "conceptualA");
		conceptualA.setConceptual(true);
		Capability conceptualACap = addCapability(conceptualA, "conceptualACap");

		Unit physicalB = createPhysicalUnit(t, "physicalB");
		Capability physicalBCap = addCapability(physicalB, "physicalBCap");

		LinkFactory.createRealizationLink(conceptualACap, physicalBCap);
		dvs.validate(t);
// System.out.println("testRealizedCapOnNonRealizedUnit\n" +
// ValidatorTestUtils.getTopologyErrorDescription(t));
		assertHasErrorStatus(t,
				ICoreProblemType.REALIZED_CAPABILITY_ON_NON_REALIZED_UNIT);
	}

	public void testCapAndUnitDifferentRealizationTargets() throws Exception {
		Topology t = createTopology("testCapAndUnitDifferentRealizationTargets");

		Unit conceptualA = createUnit(t, "conceptualA");
		conceptualA.setConceptual(true);
		Capability conceptualACap = addCapability(conceptualA, "conceptualACap");

		Unit physicalB = createPhysicalUnit(t, "physicalB");
		Capability physicalBCap = addCapability(physicalB, "physicalBCap");

		Unit physicalC = createPhysicalUnit(t, "physicalC");
		Capability physicalCCap = addCapability(physicalB, "physicalCCap");

		LinkFactory.createRealizationLink(conceptualACap, physicalBCap);
		LinkFactory.createRealizationLink(conceptualA, physicalC);
		dvs.validate(t);
// System.out.println("testCapAndUnitDifferentRealizationTargets\n" +
// ValidatorTestUtils.getTopologyErrorDescription(t));
		assertHasNoErrorStatus(t,
				ICoreProblemType.DMO_REALIZATION_TARGET_INCONSISTENT);
		assertHasErrorStatus(t,
				ICoreProblemType.CAPABILITY_REALIZATION_TARGET_INCONSISTENT);
	}

	public void testCapMultipleRealizationLinks() throws Exception {
		Topology t = createTopology("testCapMultipleRealizationLinks");

		Unit conceptualA = createUnit(t, "conceptualA");
		conceptualA.setConceptual(true);
		Capability conceptualACap = addCapability(conceptualA, "conceptualACap");

		Unit physicalB = createPhysicalUnit(t, "physicalB");
		Capability physicalBCap = addCapability(physicalB, "physicalBCap");

		LinkFactory.createRealizationLink(conceptualACap, physicalBCap);
		LinkFactory.createRealizationLink(conceptualACap, physicalBCap);
		dvs.validate(t);
// System.out.println("testCapMultipleRealizationLinks\n" +
// ValidatorTestUtils.getTopologyErrorDescription(t));
		assertHasErrorStatus(t,
				ICoreProblemType.CAPABILITY_HAS_MULTIPLE_REALIZATION_LINKS);
	}

	public void testRealizedReqOnNonConceptualUnit() throws Exception {
		Topology t = createTopology("testRealizedReqOnNonConceptualUnit");

		Unit conceptualA = createUnit(t, "conceptualA");
		Requirement conceptualAReq = addRequirement(conceptualA,
				"conceptualAReq");

		Unit physicalB = createPhysicalUnit(t, "physicalB");
		Requirement physicalBReq = addRequirement(physicalB, "physicalBReq");

		conceptualA.setConceptual(true);
		LinkFactory.createRealizationLink(conceptualAReq, physicalBReq);
		conceptualA.setConceptual(false);
		dvs.validate(t);
// System.out.println("testRealizedReqOnNonConceptualUnit\n" +
// ValidatorTestUtils.getTopologyErrorDescription(t));
		assertHasErrorStatus(t,
				ICoreProblemType.REQUIREMENT_ON_NON_CONCEPTUAL_UNIT_REALIZED);
	}

	public void testRealizedReqOnNonRealizedUnit() throws Exception {
		Topology t = createTopology("testMultipleRealizations");

		Unit conceptualA = createUnit(t, "conceptualA");
		conceptualA.setConceptual(true);
		Requirement conceptualAReq = addRequirement(conceptualA,
				"conceptualAReq");

		Unit physicalB = createPhysicalUnit(t, "physicalB");
		Requirement physicalBReq = addRequirement(physicalB, "physicalBReq");

		LinkFactory.createRealizationLink(conceptualAReq, physicalBReq);
		dvs.validate(t);
// System.out.println("testRealizedReqOnNonRealizedUnit\n" +
// ValidatorTestUtils.getTopologyErrorDescription(t));
		assertHasErrorStatus(t,
				ICoreProblemType.REALIZED_REQUIREMENT_ON_NON_REALIZED_UNIT);
	}

	public void testReqAndUnitDifferentRealizationTargets() throws Exception {
		Topology t = createTopology("testReqAndUnitDifferentRealizationTargets");

		Unit conceptualA = createUnit(t, "conceptualA");
		conceptualA.setConceptual(true);
		Requirement conceptualAReq = addRequirement(conceptualA,
				"conceptualAReq");

		Unit physicalB = createPhysicalUnit(t, "physicalB");
		Requirement physicalBReq = addRequirement(physicalB, "physicalBReq");

		Unit physicalC = createPhysicalUnit(t, "physicalC");
		Requirement physicalCReq = addRequirement(physicalB, "physicalCReq");

		LinkFactory.createRealizationLink(conceptualAReq, physicalBReq);
		LinkFactory.createRealizationLink(conceptualA, physicalC);
		dvs.validate(t);
// System.out.println("testReqAndUnitDifferentRealizationTargets\n" +
// ValidatorTestUtils.getTopologyErrorDescription(t));
		assertHasNoErrorStatus(t,
				ICoreProblemType.DMO_REALIZATION_TARGET_INCONSISTENT);
		assertHasErrorStatus(t,
				ICoreProblemType.REQUIREMENT_REALIZATION_TARGET_INCONSISTENT);
	}

	public void testReqAndReqDifferentRealizationTargets() throws Exception {
		Topology t = createTopology("testReqAndReqDifferentRealizationTargets");

		Unit conceptualA = createUnit(t, "conceptualA");
		conceptualA.setConceptual(true);
		Requirement conceptualAReq1 = addRequirement(conceptualA,
				"conceptualAReq1");
		Requirement conceptualAReq2 = addRequirement(conceptualA,
				"conceptualAReq2");

		Unit physicalB = createPhysicalUnit(t, "physicalB");
		Requirement physicalBReq = addRequirement(physicalB, "physicalBReq");

		Unit physicalC = createPhysicalUnit(t, "physicalC");
		Requirement physicalCReq = addRequirement(physicalB, "physicalCReq");

		LinkFactory.createRealizationLink(conceptualAReq1, physicalBReq);
		LinkFactory.createRealizationLink(conceptualAReq2, physicalCReq);
		dvs.validate(t);
// System.out.println("testReqAndReqDifferentRealizationTargets\n" +
// ValidatorTestUtils.getTopologyErrorDescription(t));
		assertHasErrorStatus(t,
				ICoreProblemType.DMO_REALIZATION_TARGET_INCONSISTENT);
		assertHasNoErrorStatus(t,
				ICoreProblemType.REQUIREMENT_REALIZATION_TARGET_INCONSISTENT);
		assertHasErrorStatus(t,
				ICoreProblemType.REALIZED_REQUIREMENT_ON_NON_REALIZED_UNIT);
	}

	public void testCapAndCapDifferentRealizationTargets() throws Exception {
		Topology t = createTopology("testCapAndCapDifferentRealizationTargets");

		Unit conceptualA = createUnit(t, "conceptualA");
		conceptualA.setConceptual(true);
		Capability conceptualACap1 = addCapability(conceptualA,
				"conceptualACap1");
		Capability conceptualACap2 = addCapability(conceptualA,
				"conceptualACap2");

		Unit physicalB = createPhysicalUnit(t, "physicalB");
		Capability physicalBCap = addCapability(physicalB, "physicalBCap");

		Unit physicalC = createPhysicalUnit(t, "physicalC");
		Capability physicalCCap = addCapability(physicalB, "physicalCCap");

		LinkFactory.createRealizationLink(conceptualACap1, physicalBCap);
		LinkFactory.createRealizationLink(conceptualACap2, physicalCCap);
		dvs.validate(t);
// System.out.println("testCapAndCapDifferentRealizationTargets\n" +
// ValidatorTestUtils.getTopologyErrorDescription(t));
		assertHasErrorStatus(t,
				ICoreProblemType.DMO_REALIZATION_TARGET_INCONSISTENT);
		assertHasNoErrorStatus(t,
				ICoreProblemType.CAPABILITY_REALIZATION_TARGET_INCONSISTENT);
		assertHasErrorStatus(t,
				ICoreProblemType.REALIZED_CAPABILITY_ON_NON_REALIZED_UNIT);
	}

	public void testCapAndReqDifferentRealizationTargets() throws Exception {
		Topology t = createTopology("testCapAndReqDifferentRealizationTargets");

		Unit conceptualA = createUnit(t, "conceptualA");
		conceptualA.setConceptual(true);
		Capability conceptualACap = addCapability(conceptualA, "conceptualACap");
		Requirement conceptualAReq = addRequirement(conceptualA,
				"conceptualAReq");

		Unit physicalB = createPhysicalUnit(t, "physicalB");
		Capability physicalBCap = addCapability(physicalB, "physicalBCap");

		Unit physicalC = createPhysicalUnit(t, "physicalC");
		Requirement physicalCReq = addRequirement(physicalB, "physicalCReq");

		LinkFactory.createRealizationLink(conceptualACap, physicalBCap);
		LinkFactory.createRealizationLink(conceptualAReq, physicalCReq);
		dvs.validate(t);
// System.out.println("testCapAndReqDifferentRealizationTargets\n" +
// ValidatorTestUtils.getTopologyErrorDescription(t));
		assertHasErrorStatus(t,
				ICoreProblemType.DMO_REALIZATION_TARGET_INCONSISTENT);
		assertHasNoErrorStatus(t,
				ICoreProblemType.REQUIREMENT_REALIZATION_TARGET_INCONSISTENT);
		assertHasNoErrorStatus(t,
				ICoreProblemType.CAPABILITY_REALIZATION_TARGET_INCONSISTENT);
		assertHasErrorStatus(t,
				ICoreProblemType.REALIZED_CAPABILITY_ON_NON_REALIZED_UNIT);
	}

	public void testReqMultipleRealizationLinks() throws Exception {
		Topology t = createTopology("testReqMultipleRealizationLinks");

		Unit conceptualA = createUnit(t, "conceptualA");
		conceptualA.setConceptual(true);
		Requirement conceptualAReq = addRequirement(conceptualA,
				"conceptualAReq");

		Unit physicalB = createPhysicalUnit(t, "physicalB");
		Requirement physicalBReq = addRequirement(physicalB, "physicalBReq");

		LinkFactory.createRealizationLink(conceptualAReq, physicalBReq);
		LinkFactory.createRealizationLink(conceptualAReq, physicalBReq);
		dvs.validate(t);
// System.out.println("testReqMultipleRealizationLinks\n" +
// ValidatorTestUtils.getTopologyErrorDescription(t));
		assertHasErrorStatus(t,
				ICoreProblemType.REQUIREMENT_HAS_MULTIPLE_REALIZATION_LINKS);
	}

	public void testCaptoCapRealizationLinkTypeMismatch() throws Exception {
		Topology t = createTopology("testCaptoCapRealizationLinkTypeMismatch");

		Unit conceptualA = createUnit(t, "conceptualA");
		conceptualA.setConceptual(true);
		Capability conceptualACap = CoreFactory.eINSTANCE
				.createCommunicationCapability();
		conceptualACap.setName("conceptualACap");
		conceptualACap.setDisplayName("conceptualACap");
		conceptualACap.setLinkType(CapabilityLinkTypes.HOSTING_LITERAL);
		conceptualA.getCapabilities().add(conceptualACap);

		Unit physicalB = createPhysicalUnit(t, "physicalB");
		Capability physicalBCap = addCapability(physicalB, "physicalBCap");

		LinkFactory.createRealizationLink(conceptualACap, physicalBCap);
		dvs.validate(t);
// System.out.println("testCaptoCapRealizationLinkTypeMismatch\n" +
// ValidatorTestUtils.getTopologyErrorDescription(t));
		assertHasErrorStatus(t,
				ICoreProblemType.REALIZATION_LINK_SOURCE_TARGET_TYPE_MISMATCH);
	}

	public void testCaptoCapRealizationLinkInvalidSource() throws Exception {
		Topology t = createTopology("testCaptoCapRealizationLinkInvalidSource");

		Unit conceptualA = createUnit(t, "conceptualA");
		conceptualA.setConceptual(true);
		Capability conceptualACap = CoreFactory.eINSTANCE
				.createCommunicationCapability();
		conceptualACap.setName("conceptualACap");
		conceptualACap.setDisplayName("conceptualACap");
		conceptualACap.setLinkType(CapabilityLinkTypes.HOSTING_LITERAL);
		conceptualA.getCapabilities().add(conceptualACap);

		Unit physicalB = createPhysicalUnit(t, "physicalB");
		Capability physicalBCap = addCapability(physicalB, "physicalBCap");

		Unit conceptualC = createPhysicalUnit(t, "conceptualC");
		Capability conceptualCCap = addCapability(conceptualC, "conceptualCCap");

		RealizationLink rlink = LinkFactory.createRealizationLink(
				conceptualACap, physicalBCap);
		rlink.setSource(conceptualC);
		assert (t.getRealizationLinks().remove(rlink));
		conceptualA.getRealizationLinks().add(rlink);
		dvs.validate(t);
// System.out.println("testCaptoCapRealizationLinkInvalidSource\n" +
// ValidatorTestUtils.getTopologyErrorDescription(t));
// Test disabled 2007/04/17 because validation was disabled.
// assertHasErrorStatus(t, ICoreProblemType.REALIZATION_LINK_SOURCE_INVALID);
	}

	private Unit copyUnit(Unit u, Topology targetTop) {
		List<Unit> l = new ArrayList<Unit>();
		l.add(u);
		Collection c = ResolutionUtils.intelligentDeepCopy(l, targetTop, true);
		return (Unit) c.toArray()[0];
	}

	private Capability copyCap(Capability cap) {
		Capability capCopy = (Capability) EcoreUtil.copy(cap);
		for (Iterator eaIter = cap.getExtendedAttributes().iterator(); eaIter
				.hasNext();) {
			capCopy.getExtendedAttributes().add(
					EcoreUtil.copy((ExtendedAttribute) eaIter.next()));
		}
		for (Iterator metaDataIter = cap.getAttributeMetaData().iterator(); metaDataIter
				.hasNext();) {
			capCopy.getAttributeMetaData().add(
					EcoreUtil.copy((AttributeMetaData) metaDataIter.next()));
		}
		return capCopy;
	}

	private static Unit createConceptualUnit(Topology t, String name) {
		Unit u = createUnit(t, name);
		u.setConceptual(true);
		return u;
	}

	private static Unit createPhysicalUnit(Topology t, String name) {
		return createUnit(t, name);
	}

	private static Requirement addRequirement(Unit unit, String name) {
		Requirement req = CoreFactory.eINSTANCE.createRequirement();
		req.setName(unit.getName() + name);
		unit.getRequirements().add(req);
		return req;
	}

	private static Capability addCapability(Unit unit, String name) {
		Capability cap = CoreFactory.eINSTANCE.createCapability();
		cap.setName(unit.getName() + name);
		unit.getCapabilities().add(cap);
		return cap;
	}

	private static Unit createUnit(Topology t, String name) {
		Unit u = CoreFactory.eINSTANCE.createUnit();
		u.setName(name);
		t.getUnits().add(u);
		return u;
	}

	private void assertMatch(Unit u1, Unit u2) {
		assert ((rlm.canCreateLink(u1, u2).isOK())) : rlm.canCreateLink(u1, u2)
				.getMessage();
	}

	private void assertNoMatch(Unit u1, Unit u2) {
		assert (!(rlm.canCreateLink(u1, u2).isOK())) : rlm
				.canCreateLink(u1, u2).getMessage();
	}

}
