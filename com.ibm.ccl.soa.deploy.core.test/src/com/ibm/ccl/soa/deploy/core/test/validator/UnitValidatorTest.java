/*******************************************************************************
 * Copyright (c) 2003, 2007 IBM Corporation Licensed Material - Property of IBM. All rights reserved.
 *  
 * US Government Users Restricted Rights - Use, duplication or disclosure v1.0 restricted by GSA ADP
 * Schedule Contract with IBM Corp.
 * 
 * Contributors: IBM Corporation - initial API and implementation
 *******************************************************************************/
package com.ibm.ccl.soa.deploy.core.test.validator;

import java.math.BigInteger;

import org.eclipse.core.runtime.IStatus;

import com.ibm.ccl.soa.deploy.core.Capability;
import com.ibm.ccl.soa.deploy.core.CapabilityLinkTypes;
import com.ibm.ccl.soa.deploy.core.CommunicationCapability;
import com.ibm.ccl.soa.deploy.core.CoreFactory;
import com.ibm.ccl.soa.deploy.core.CorePackage;
import com.ibm.ccl.soa.deploy.core.DependencyLink;
import com.ibm.ccl.soa.deploy.core.HostingLink;
import com.ibm.ccl.soa.deploy.core.Requirement;
import com.ibm.ccl.soa.deploy.core.RequirementExpression;
import com.ibm.ccl.soa.deploy.core.RequirementExpressionUsage;
import com.ibm.ccl.soa.deploy.core.RequirementLinkTypes;
import com.ibm.ccl.soa.deploy.core.Topology;
import com.ibm.ccl.soa.deploy.core.Unit;
import com.ibm.ccl.soa.deploy.core.test.TopologyTestCase;
import com.ibm.ccl.soa.deploy.core.test.validator.utils.ValidatorTestUtils;
import com.ibm.ccl.soa.deploy.core.validator.IDeployReporter;
import com.ibm.ccl.soa.deploy.core.validator.IDeployValidationContext;
import com.ibm.ccl.soa.deploy.core.validator.expression.Equals;
import com.ibm.ccl.soa.deploy.core.validator.matcher.LinkFactory;
import com.ibm.ccl.soa.deploy.core.validator.pattern.UnitValidator;
import com.ibm.ccl.soa.deploy.core.validator.status.ICoreProblemType;

/**
 * Test {@link UnitValidator}
 */
public class UnitValidatorTest extends TopologyTestCase {

	public UnitValidatorTest() {
		super("UnitValidatorTest");
	}

	/**
	 * Test
	 * {@link UnitValidator#addCapabilityTypeConstraint(org.eclipse.emf.ecore.EClass, CapabilityLinkTypes, int, int)}.
	 */
	public void testAddCapabilityTypeConstraint() throws Exception {
		Topology top = createTopology("testAddCapabilityTypeConstraint", true);

		IDeployValidationContext context = createValidationContext(top);
		IDeployReporter reporter = createDeployReporter(false);

		Unit unit = CoreFactory.eINSTANCE.createUnit();
		unit.setName("unit");
		top.getUnits().add(unit);

		assert unit.getStatus().getSeverity() == IStatus.OK;

		// Validate (no constraints on capabilities)
		UnitValidator v = new UnitValidator(CorePackage.eINSTANCE.getUnit());
		v.setAllowUnexpectedCapabilityTypes(false);
		v.setAllowUnexpectedRequirementTypes(false);
		v.validate(unit, context, reporter);

		assert unit.getStatus().getSeverity() != IStatus.ERROR;

		// Add constraint for providing one hosting capability
		v.addCapabilityTypeConstraint(CorePackage.eINSTANCE.getCapability(),
				CapabilityLinkTypes.ANY_LITERAL, 1, 1);

		// Revalidate (error for missing hosting capability)
		unit.clearStatus();
		v.validate(unit, context, reporter);

		assertHasDeployStatus(unit,
				ICoreProblemType.UNIT_CAPABILITY_TYPE_CARDINALITY_INVALID,
				IStatus.ERROR);

		// Add non-hosting capability (mismatch)
		Capability cap = CoreFactory.eINSTANCE.createCapability();
		cap.setName("cap");
		cap.setLinkType(CapabilityLinkTypes.DEPENDENCY_LITERAL);
		unit.getCapabilities().add(cap);
		assert unit.getCapabilities().size() == 1;

		// Revalidate (error: no hosting Capability found)
		unit.clearStatus();
		cap.clearStatus();
		v.validate(unit, context, reporter);

		assertHasDeployStatus(cap,
				ICoreProblemType.UNIT_CAPABILITY_TYPE_INVALID, IStatus.ERROR);
		assertHasDeployStatus(unit,
				ICoreProblemType.UNIT_CAPABILITY_TYPE_CARDINALITY_INVALID,
				IStatus.ERROR);

		// Make capability hosting
		cap.setLinkType(CapabilityLinkTypes.ANY_LITERAL);

		// Revalidate (no errors now)
		unit.clearStatus();
		cap.clearStatus();
		v.validate(unit, context, reporter);

		assert cap.getStatus().getSeverity() != IStatus.ERROR;
		assert unit.getStatus().getSeverity() != IStatus.ERROR;

		// Add second capability (count not exceeded because this one is
		// non-hosting, but we put an error on the new capability as not
		// expected).
		Capability cap2 = CoreFactory.eINSTANCE.createCapability();
		cap2.setName("cap2");
		cap2.setLinkType(CapabilityLinkTypes.DEPENDENCY_LITERAL);
		unit.getCapabilities().add(cap2);

		// Revalidate
		unit.clearStatus();
		cap.clearStatus();
		cap2.clearStatus();
		v.validate(unit, context, reporter);

		assert cap.getStatus().getSeverity() != IStatus.ERROR : getString(cap
				.getStatus());
		assertHasDeployStatus(cap2,
				ICoreProblemType.UNIT_CAPABILITY_TYPE_INVALID, IStatus.ERROR);
		assert unit.getStatus().getSeverity() != IStatus.ERROR;

		// Make second capability hosting (cardinality error on unit).
		cap2.setLinkType(CapabilityLinkTypes.ANY_LITERAL);

		// Revalidate
		unit.clearStatus();
		cap.clearStatus();
		cap2.clearStatus();
		v.validate(unit, context, reporter);

		assert cap.getStatus().getSeverity() != IStatus.ERROR : getString(cap
				.getStatus());
		assert cap2.getStatus().getSeverity() != IStatus.ERROR;
		assertHasDeployStatus(unit,
				ICoreProblemType.UNIT_CAPABILITY_TYPE_CARDINALITY_INVALID,
				IStatus.ERROR);
	}

	/**
	 * Test
	 * {@link UnitValidator#addRequirementTypeConstraint(org.eclipse.emf.ecore.EClass, com.ibm.ccl.soa.deploy.core.RequirementLinkTypes, int, int)}.
	 */
	public void testAddRequirementTypeConstraint() throws Exception {
		Topology top = createTopology("testAddRequirementTypeConstraint", true);

		IDeployValidationContext context = createValidationContext(top);
		IDeployReporter reporter = createDeployReporter(false);

		Unit unit = CoreFactory.eINSTANCE.createUnit();
		unit.setName("unit");
		top.getUnits().add(unit);

		assert unit.getStatus().getSeverity() == IStatus.OK;

		// Validate (no requirements)
		UnitValidator v = new UnitValidator(CorePackage.eINSTANCE.getUnit());
		v.setAllowUnexpectedCapabilityTypes(false);
		v.setAllowUnexpectedRequirementTypes(false);
		v.validate(unit, context, reporter);

		assert unit.getStatus().getSeverity() != IStatus.ERROR;

		// Add requirement constraint on one hosting capability
		v.addRequirementTypeConstraint(CorePackage.eINSTANCE.getCapability(),
				RequirementLinkTypes.HOSTING_LITERAL, 1, 1);

		// Revalidate with missing requirement
		unit.clearStatus();
		v.validate(unit, context, reporter);

		assertHasDeployStatus(unit,
				ICoreProblemType.UNIT_REQUIREMENT_CARDINALITY_INVALID,
				IStatus.ERROR);

		// Add non-hosting requirement (mismatch)
		Requirement req = CoreFactory.eINSTANCE.createRequirement();
		req.setName("req");
		req.setDmoEType(CorePackage.eINSTANCE.getCapability());
		req.setLinkType(RequirementLinkTypes.DEPENDENCY_LITERAL);
		unit.getRequirements().add(req);

		// Revalidate (has requirement but is non-hosting)
		unit.clearStatus();
		req.clearStatus();
		v.validate(unit, context, reporter);

		assertHasDeployStatus(req,
				ICoreProblemType.UNIT_REQUIREMENT_TYPE_INVALID, IStatus.ERROR);
		assertHasDeployStatus(unit,
				ICoreProblemType.UNIT_REQUIREMENT_CARDINALITY_INVALID,
				IStatus.ERROR);

		// Make requirement hosting
		req.setLinkType(RequirementLinkTypes.HOSTING_LITERAL);

		// Revalidate (should validate)
		unit.clearStatus();
		req.clearStatus();
		v.validate(unit, context, reporter);

		assert req.getStatus().getSeverity() != IStatus.ERROR;
		assertHasNoDeployStatus(unit,
				ICoreProblemType.UNIT_REQUIREMENT_CARDINALITY_INVALID,
				IStatus.ERROR);

		// Add second requirement (count not exceeded because this one is
		// non-hosting, but invalid requirement error on req2)
		Requirement req2 = CoreFactory.eINSTANCE.createRequirement();
		req2.setName("req2");
		req2.setDmoEType(CorePackage.eINSTANCE.getCapability());
		req2.setLinkType(RequirementLinkTypes.DEPENDENCY_LITERAL);
		unit.getRequirements().add(req2);

		// Revalidate (too many requirements)
		unit.clearStatus();
		req.clearStatus();
		req2.clearStatus();
		v.validate(unit, context, reporter);

		assert req.getStatus().getSeverity() != IStatus.ERROR : getString(req
				.getStatus());
		assertHasDeployStatus(req2,
				ICoreProblemType.UNIT_REQUIREMENT_TYPE_INVALID, IStatus.ERROR);
		assertHasNoDeployStatus(unit,
				ICoreProblemType.UNIT_REQUIREMENT_CARDINALITY_INVALID,
				IStatus.ERROR);

		// Make second capability hosting (cardinality error)
		req2.setLinkType(RequirementLinkTypes.HOSTING_LITERAL);

		// Revalidate
		unit.clearStatus();
		req.clearStatus();
		req2.clearStatus();
		v.validate(unit, context, reporter);

		assert req.getStatus().getSeverity() != IStatus.ERROR : getString(req
				.getStatus());
		assert req2.getStatus().getSeverity() != IStatus.ERROR;
		assertHasDeployStatus(unit,
				ICoreProblemType.UNIT_REQUIREMENT_CARDINALITY_INVALID,
				IStatus.ERROR);
	}

	/**
	 * Tests validation of dependency requirements and links.
	 * {@link UnitValidator#validateRequirement(Requirement, Unit, IDeployValidationContext, IDeployReporter)}.
	 */
	public void testValidateDependencyRequirement() throws Exception {
		Topology top = createTopology("testValidateDependencyRequirement", true);

		IDeployValidationContext context = createValidationContext(top);
		IDeployReporter reporter = createDeployReporter(false);
		UnitValidator v = new UnitValidator(CorePackage.eINSTANCE.getUnit());

		// ---- test 1 ------
		Unit unit1 = addUnit(top, "unit1");
		Requirement req_unit1 = addRequirement(unit1, "req_unit1",
				CorePackage.eINSTANCE.getCommunicationCapability(),
				RequirementLinkTypes.DEPENDENCY_LITERAL);
		RequirementExpression expr1 = CoreFactory.eINSTANCE
				.createRequirementExpression();
		expr1.setName("re0");
		expr1.setUse(RequirementExpressionUsage.REQUIRED_LITERAL);
		expr1.setInterpreter(Equals.INTERPRETER_ID);
		expr1.setAttributeName("port");
		expr1.setValue("100");
		req_unit1.getExpressions().add(expr1);

		Unit unit2 = addUnit(top, "unit2");
		Capability cap_unit2 = addCapability(unit2, "cap_unit2",
				CorePackage.eINSTANCE.getBundleCapability(),
				CapabilityLinkTypes.DEPENDENCY_LITERAL);

		DependencyLink depLink = LinkFactory.createDependencyLink(req_unit1,
				cap_unit2);

		validateUnit(top, v, unit1, context, reporter);
		// 2 errors: one for type mismatch, one for RE unsatisfied
		assert ValidatorTestUtils.getTopologyErrorCount(top) == 2;
		assertHasDeployStatus(req_unit1,
				ICoreProblemType.REQUIREMENT_TYPE_MISMATCH, IStatus.ERROR);

		// ---- test 2 ------
		unit2.setConceptual(true);
		validateUnit(top, v, unit1, context, reporter);
		assert ValidatorTestUtils.getTopologyErrorCount(top) == 2;
		assertHasDeployStatus(req_unit1,
				ICoreProblemType.REQUIREMENT_TYPE_MISMATCH, IStatus.ERROR);

		// ---- test 3 ------
		unit1.setConceptual(true);
		Unit unit3 = addUnit(top, "unit3");
		Requirement req_unit3 = addRequirement(unit3, "req_unit3",
				CorePackage.eINSTANCE.getCommunicationCapability(),
				RequirementLinkTypes.DEPENDENCY_LITERAL);
		RequirementExpression expr2 = CoreFactory.eINSTANCE
				.createRequirementExpression();
		expr2.setName("re1");
		expr2.setUse(RequirementExpressionUsage.REQUIRED_LITERAL);
		expr2.setInterpreter(Equals.INTERPRETER_ID);
		expr2.setAttributeName("port");
		expr2.setValue("100");
		req_unit3.getExpressions().add(expr2);
		LinkFactory.createRealizationLink(unit1, unit3);
		validateUnit(top, v, unit3, context, reporter);
		assert ValidatorTestUtils.getTopologyErrorCount(top) == 1;
		assertHasDeployStatus(req_unit3,
				ICoreProblemType.UNIT_DEPENDENCY_REQUIREMENT_UNMATCHED,
				IStatus.ERROR);

		// ---- test 4 ------
		unit2.setConceptual(false);
		req_unit1.setLink(null); // remove old link
		unit2.getCapabilities().clear(); // remove old capability
		cap_unit2 = addCapability(unit2, "cap_unit2", CorePackage.eINSTANCE
				.getCapability(), CapabilityLinkTypes.DEPENDENCY_LITERAL);
		depLink = LinkFactory.createDependencyLink(req_unit1, cap_unit2);
		validateUnit(top, v, unit1, context, reporter);
		assert ValidatorTestUtils.getTopologyErrorCount(top) == 2;
		assertHasDeployStatus(req_unit1,
				ICoreProblemType.REQUIREMENT_TYPE_MISMATCH, IStatus.ERROR);

		// ---- test 4 ------
		unit2.setConceptual(true);
		validateUnit(top, v, unit1, context, reporter);
		assert ValidatorTestUtils.getTopologyErrorCount(top) == 1;

		// ---- test 5 ------
		Unit unit4 = addUnit(top, "unit4");
		CommunicationCapability cap_unit4 = (CommunicationCapability) addCapability(
				unit4, "cap_unit4", CorePackage.eINSTANCE
						.getCommunicationCapability(),
				CapabilityLinkTypes.DEPENDENCY_LITERAL);
		cap_unit4.setPort(new BigInteger("80"));
		LinkFactory.createRealizationLink(unit2, unit4);
		validateUnit(top, v, unit1, context, reporter);
		assert ValidatorTestUtils.getTopologyErrorCount(top) == 2;
		assertHasDeployStatus(cap_unit4,
				ICoreProblemType.OBJECT_ATTRIBUTE_INVALID, IStatus.ERROR);

		// ---- test 6 ------
		cap_unit4.setPort(new BigInteger("100"));
		validateUnit(top, v, unit1, context, reporter);
		assert ValidatorTestUtils.getTopologyErrorCount(top) == 0;
	}

	/**
	 * Tests validation of hosting links.
	 * {@link UnitValidator#validateHostingLink(HostingLink, Unit, IDeployValidationContext, IDeployReporter)}.
	 */
	public void testValidateHostingLink() throws Exception {
		Topology top = createTopology("testValidateHostingLink", true);

		IDeployValidationContext context = createValidationContext(top);
		IDeployReporter reporter = createDeployReporter(false);
		UnitValidator v = new UnitValidator(CorePackage.eINSTANCE.getUnit());

		// ---- test 1 ------
		// create unit unit1
		Unit unit1 = addUnit(top, "unit1");
		Requirement req_unit1 = addRequirement(unit1, "req_unit1",
				CorePackage.eINSTANCE.getCommunicationCapability(),
				RequirementLinkTypes.HOSTING_LITERAL);

		// create unit unit2
		Unit unit2 = addUnit(top, "unit2");
		Capability cap_unit2 = addCapability(unit2, "cap_unit2",
				CorePackage.eINSTANCE.getBundleCapability(),
				CapabilityLinkTypes.HOSTING_LITERAL);

		// host unit 1 on unit2
		HostingLink hostLink = LinkFactory.createHostingLink(unit2, unit1);

		validateUnit(top, v, unit2, context, reporter);
		assert ValidatorTestUtils.getTopologyErrorCount(top) == 1;
		assertHasDeployStatus(hostLink,
				ICoreProblemType.HOSTING_LINK_TARGET_INVALID, IStatus.ERROR);

		// ---- test 2 ------
		unit2.setConceptual(true);
		validateUnit(top, v, unit2, context, reporter);
		// hostingLinkTargetInvalid, conceptualUnitNotRealized
		assert ValidatorTestUtils.getTopologyErrorCount(top) == 2;
		assertHasDeployStatus(hostLink,
				ICoreProblemType.HOSTING_LINK_TARGET_INVALID, IStatus.ERROR);

		// ---- test 3 ------
		unit2.setConceptual(false);
		unit2.getCapabilities().clear(); // get rid of BundleCapability
		cap_unit2 = addCapability(unit2, "cap_unit2", CorePackage.eINSTANCE
				.getCapability(), CapabilityLinkTypes.HOSTING_LITERAL);
		validateUnit(top, v, unit2, context, reporter);
		assert ValidatorTestUtils.getTopologyErrorCount(top) == 1;
		assertHasDeployStatus(hostLink,
				ICoreProblemType.HOSTING_LINK_TARGET_INVALID, IStatus.ERROR);

		// ---- test 4 ------
		unit2.setConceptual(true);
		validateUnit(top, v, unit2, context, reporter);
		assert ValidatorTestUtils.getTopologyErrorCount(top) == 1;
		assertHasDeployStatus(unit2,
				ICoreProblemType.CONCEPTUAL_UNIT_NOT_REALIZED, IStatus.ERROR);


		// ---- test 5 ------
		unit1.setConceptual(true);
		unit2.setConceptual(false);

		Unit unit3 = addUnit(top, "unit3");
		Requirement req1_unit3 = addRequirement(unit3, "req1_unit3",
				CorePackage.eINSTANCE.getCommunicationCapability(),
				RequirementLinkTypes.HOSTING_LITERAL);
		Requirement req2_unit3 = addRequirement(unit3, "req2_unit3",
				CorePackage.eINSTANCE.getBundleCapability(),
				RequirementLinkTypes.HOSTING_LITERAL);
		LinkFactory.createRealizationLink(unit1, unit3);

		validateUnit(top, v, unit2, context, reporter);
		assert ValidatorTestUtils.getTopologyErrorCount(top) == 2;
		assertHasDeployStatus(hostLink,
				ICoreProblemType.HOSTING_LINK_TARGET_INVALID, IStatus.ERROR);

		// ---- test 6 ------
		unit2.setConceptual(true);
		validateUnit(top, v, unit2, context, reporter);
		assert ValidatorTestUtils.getTopologyErrorCount(top) == 1;
		assertHasDeployStatus(unit2,
				ICoreProblemType.CONCEPTUAL_UNIT_NOT_REALIZED, IStatus.ERROR);


		// ---- test 7 ------
		// create unit unit4
		Unit unit4 = addUnit(top, "unit4");
		Capability cap_unit4 = addCapability(unit4, "cap_unit4",
				CorePackage.eINSTANCE.getCapability(),
				CapabilityLinkTypes.HOSTING_LITERAL);
		LinkFactory.createRealizationLink(unit2, unit4);

		validateUnit(top, v, unit2, context, reporter);
		assert ValidatorTestUtils.getTopologyErrorCount(top) == 2;
		assertHasDeployStatus(hostLink,
				ICoreProblemType.HOSTING_LINK_TARGET_INVALID, IStatus.ERROR);

		// ---- test 8 ------
		unit4.setConceptual(true);
		validateUnit(top, v, unit2, context, reporter);
		assert ValidatorTestUtils.getTopologyErrorCount(top) == 0;

		// ---- test 9 ------
		unit4.setConceptual(false);
		unit4.getCapabilities().clear(); // get rid of Capability
		CommunicationCapability cap1_unit4 = (CommunicationCapability) addCapability(
				unit4, "cap1_unit4", CorePackage.eINSTANCE
						.getCommunicationCapability(),
				CapabilityLinkTypes.HOSTING_LITERAL);
		cap1_unit4.setPort(new BigInteger("80"));
		validateUnit(top, v, unit2, context, reporter);
		assert ValidatorTestUtils.getTopologyErrorCount(top) == 1;
		assertHasDeployStatus(hostLink,
				ICoreProblemType.HOSTING_LINK_TARGET_INVALID, IStatus.ERROR);

		// ---- test 10 ------
		Capability cap2_unit4 = addCapability(unit4, "cap1_unit4",
				CorePackage.eINSTANCE.getBundleCapability(),
				CapabilityLinkTypes.HOSTING_LITERAL);
		validateUnit(top, v, unit2, context, reporter);
		assert ValidatorTestUtils.getTopologyErrorCount(top) == 0;

		// ---- test 11 ------
		RequirementExpression expr = CoreFactory.eINSTANCE
				.createRequirementExpression();
		expr.setName("re0");
		expr.setUse(RequirementExpressionUsage.REQUIRED_LITERAL);
		expr.setInterpreter(Equals.INTERPRETER_ID);
		expr.setAttributeName("port");
		expr.setValue("100");
		req1_unit3.getExpressions().add(expr);

		validateUnit(top, v, unit2, context, reporter);
		assert ValidatorTestUtils.getTopologyErrorCount(top) == 1;
		assertHasDeployStatus(hostLink,
				ICoreProblemType.HOSTING_LINK_TARGET_INVALID, IStatus.ERROR);

		// ---- test 12 ------
		expr.setValue("80");
		validateUnit(top, v, unit2, context, reporter);
		assert ValidatorTestUtils.getTopologyErrorCount(top) == 0;
	}
}
