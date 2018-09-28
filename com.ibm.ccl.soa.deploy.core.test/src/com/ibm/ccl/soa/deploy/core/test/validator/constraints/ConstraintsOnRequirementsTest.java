/*******************************************************************************
 * Copyright (c) 2003, 2007 IBM Corporation Licensed Material - Property of IBM. All rights reserved.
 *  
 * US Government Users Restricted Rights - Use, duplication or disclosure v1.0 restricted by GSA ADP
 * Schedule Contract with IBM Corp.
 * 
 * Contributors: IBM Corporation - initial API and implementation
 *******************************************************************************/

package com.ibm.ccl.soa.deploy.core.test.validator.constraints;

import java.io.IOException;
import java.math.BigInteger;
import java.util.HashSet;
import java.util.Set;

import org.eclipse.core.runtime.IStatus;

import com.ibm.ccl.soa.deploy.core.Capability;
import com.ibm.ccl.soa.deploy.core.CapabilityLinkTypes;
import com.ibm.ccl.soa.deploy.core.CommunicationCapability;
import com.ibm.ccl.soa.deploy.core.CorePackage;
import com.ibm.ccl.soa.deploy.core.DependencyLink;
import com.ibm.ccl.soa.deploy.core.Requirement;
import com.ibm.ccl.soa.deploy.core.RequirementLinkTypes;
import com.ibm.ccl.soa.deploy.core.Topology;
import com.ibm.ccl.soa.deploy.core.Unit;
import com.ibm.ccl.soa.deploy.core.constraint.CollocationConstraint;
import com.ibm.ccl.soa.deploy.core.constraint.ConstraintFactory;
import com.ibm.ccl.soa.deploy.core.constraint.OrConstraint;
import com.ibm.ccl.soa.deploy.core.constraint.RangeConstraint;
import com.ibm.ccl.soa.deploy.core.constraint.TypeConstraint;
import com.ibm.ccl.soa.deploy.core.test.TopologyTestCase;
import com.ibm.ccl.soa.deploy.core.test.validator.utils.ValidatorTestUtils;
import com.ibm.ccl.soa.deploy.core.validator.constraints.TypeConstraintValidator;
import com.ibm.ccl.soa.deploy.core.validator.status.ICoreProblemType;

/**
 * Tests {@link CollocationConstraint}.
 */
public class ConstraintsOnRequirementsTest extends TopologyTestCase {

	public ConstraintsOnRequirementsTest() {
		super(ConstraintsOnRequirementsTest.class.getSimpleName());
		this.setDeleteProjectOnTearDown(false);
	}

	/**
	 * Tests validation of top-level type constraints on hosting requirements
	 * 
	 * @throws Exception
	 */
	public void testTypeConstraintsOnHostingRequirements() throws Exception {
		Topology top = this.createTopology("testTypeConstraintsOnHostingRequirements");

		Unit hostUnit1 = addUnit(top, "HostUnit1");
		Unit hostedUnit1 = addUnit(top, "HostedUnit1");
		Requirement hostedUnit1HostingReq1 = addRequirement(hostedUnit1, "HostedUnit1HostingReq1",
				RequirementLinkTypes.HOSTING_LITERAL);
		addCapability(hostUnit1, "HostUnit1HostingCap1", CapabilityLinkTypes.HOSTING_LITERAL);
		TypeConstraint tc1 = ConstraintFactory.eINSTANCE.createTypeConstraint();
		tc1.setDmoEType(CorePackage.eINSTANCE.getCapability());
		tc1.setName("tc1");
		hostedUnit1HostingReq1.getConstraints().add(tc1);

		createHostingLink("HostUnit1HostsHostedUnit1", hostUnit1, hostedUnit1);
		saveAndValidate(top);
		assertHasNoErrorStatus(top);

		// HostedUnit1 with type constraint for CommunicationCapability, hosted
		// on HostUnit1 with
		// only a Capability
		TypeConstraint tc2 = ConstraintFactory.eINSTANCE.createTypeConstraint();
		tc2.setDmoEType(CorePackage.eINSTANCE.getCommunicationCapability());
		tc2.setName("tc2");
		hostedUnit1HostingReq1.getConstraints().add(tc2);
		saveAndValidate(top);
//		System.out.println("Topology errors: \n" + ValidatorTestUtils.getTopologyErrorDescription(top));
		this.assertHasErrorStatus(top, ICoreProblemType.HOSTING_LINK_TARGET_INVALID);
		Set expectedValidatorIDs = new HashSet();
		// This is a rotten validator ID!
		expectedValidatorIDs.add(TypeConstraintValidator.class.getName());
		ValidatorTestUtils.topologyValidatorIDsInSet(top, expectedValidatorIDs, IStatus.ERROR);

		hostedUnit1HostingReq1.getConstraints().clear();
		saveAndValidate(top);
		assertHasNoErrorStatus(top);

		CommunicationCapability hostUnit1HostingCommunicationCap1 = (CommunicationCapability)addCapability(hostUnit1, "HostUnit1HostingCommunicationCap1", CorePackage.eINSTANCE
				.getCommunicationCapability(), CapabilityLinkTypes.HOSTING_LITERAL);
		hostedUnit1HostingReq1.getConstraints().add(tc2);
		save(top);
		saveAndValidate(top);
		assertHasNoErrorStatus(top);
		
		hostUnit1HostingCommunicationCap1.setPort(BigInteger.TEN);
		RangeConstraint rc1 = ConstraintFactory.eINSTANCE.createRangeConstraint();
		rc1.setName("rc1");
		rc1.setMinValue("11");
		rc1.setMaxValue("11");
		rc1.setAttributeName("port");
		tc2.getConstraints().add(rc1);
		
		saveAndValidate(top);
		assertHasErrorStatus(top);
//		System.out.println("Topology errors: \n" + ValidatorTestUtils.getTopologyErrorDescription(top));
		
		rc1.setMinValue("10");
		rc1.setMaxValue("10");
		saveAndValidate(top);
		assertHasNoErrorStatus(top);
	}
	
	/**
	 * Tests validation of top-level type constraints on hosting requirements
	 * 
	 * @throws Exception
	 */
	public void testOredTypeConstraintsOnHostingRequirements() throws Exception {
		Topology top = this.createTopology("TestOredTypeConstraintsOnHostingRequirements");

		Unit hostUnit1 = addUnit(top, "HostUnit1");
		Unit hostedUnit1 = addUnit(top, "HostedUnit1");
		Requirement hostedUnit1HostingReq1 = addRequirement(hostedUnit1, "HostedUnit1HostingReq1",
				RequirementLinkTypes.HOSTING_LITERAL);
		CommunicationCapability hostUnit1HostingCommunicationCap1 = (CommunicationCapability)addCapability(hostUnit1, "HostUnit1HostingCommunicationCap1", CorePackage.eINSTANCE
				.getCommunicationCapability(), CapabilityLinkTypes.HOSTING_LITERAL);
		
		OrConstraint oc1 = ConstraintFactory.eINSTANCE.createOrConstraint();
		oc1.setName("oc1");
		hostedUnit1HostingReq1.getConstraints().add(oc1);
		
		TypeConstraint tc1 = ConstraintFactory.eINSTANCE.createTypeConstraint();
		tc1.setDmoEType(CorePackage.eINSTANCE.getCommunicationCapability());
		tc1.setName("tc1");
		oc1.getConstraints().add(tc1);
		
		TypeConstraint tc2 = ConstraintFactory.eINSTANCE.createTypeConstraint();
		tc2.setDmoEType(CorePackage.eINSTANCE.getCommunicationCapability());
		tc2.setName("tc2");
		oc1.getConstraints().add(tc2);
		
		hostUnit1HostingCommunicationCap1.setPort(BigInteger.TEN);

		RangeConstraint rc1 = ConstraintFactory.eINSTANCE.createRangeConstraint();
		rc1.setName("rc1");
		rc1.setMinValue("11");
		rc1.setMaxValue("11");
		rc1.setAttributeName("port");
		tc1.getConstraints().add(rc1);

		RangeConstraint rc2 = ConstraintFactory.eINSTANCE.createRangeConstraint();
		rc2.setName("rc2");
		rc2.setMinValue("10");
		rc2.setMaxValue("10");
		rc2.setAttributeName("port");
		tc2.getConstraints().add(rc2);

		createHostingLink("HostUnit1HostsHostedUnit1", hostUnit1, hostedUnit1);
		
		saveAndValidate(top);
		assertHasNoErrorStatus(top);
		
		rc2.setMinValue("8");
		rc2.setMaxValue("9");
		saveAndValidate(top);
		assertHasErrorStatus(top);
		Set expectedProblemTypes = new HashSet();
		expectedProblemTypes.add(ICoreProblemType.OBJECT_ATTRIBUTE_INVALID);
		ValidatorTestUtils.topologyProblemTypesInSet(top, expectedProblemTypes);
	}

	/**
	 * Tests validation of top-level type constraints on hosting requirements
	 * 
	 * @throws Exception
	 */
	public void testTypeConstraintsOnDependencyRequirements() throws Exception {
		Topology top = this.createTopology("testTypeConstraintsOnDependencyRequirements");

		Unit dependedOnUnit1 = addUnit(top, "dependedOnUnit1");
		Unit dependerUnit1 = addUnit(top, "dependerUnit1");
		Requirement dependerUnit1DependencyReq1 = addRequirement(dependerUnit1, "dependerUnit1DependencyReq1",
				RequirementLinkTypes.DEPENDENCY_LITERAL);
		Capability dependedOnUnit1DependencyCap1 = addCapability(dependedOnUnit1, "dependedOnUnit1DependencyCap1", CapabilityLinkTypes.DEPENDENCY_LITERAL);
		TypeConstraint tc1 = ConstraintFactory.eINSTANCE.createTypeConstraint();
		tc1.setDmoEType(CorePackage.eINSTANCE.getCapability());
		tc1.setName("tc1");
		dependerUnit1DependencyReq1.getConstraints().add(tc1);

		DependencyLink dLink1 = createDependencyLink("dependedOnUnit1DependsOndependerUnit1", dependerUnit1DependencyReq1, dependedOnUnit1DependencyCap1);
		saveAndValidate(top);
		assertHasNoErrorStatus(top);

		// Dependency requirement with type constraint for CommunicationCapability, linked to
		// simple capability
		TypeConstraint tc2 = ConstraintFactory.eINSTANCE.createTypeConstraint();
		tc2.setDmoEType(CorePackage.eINSTANCE.getCommunicationCapability());
		tc2.setName("tc2");
		dependerUnit1DependencyReq1.getConstraints().add(tc2);
		saveAndValidate(top);
		this.assertHasErrorStatus(top, ICoreProblemType.CONSTRAINT_UNSATISFIED);
		Set expectedValidatorIDs = new HashSet();
		// This is a rotten validator ID!
		expectedValidatorIDs.add(TypeConstraintValidator.class.getName());
		ValidatorTestUtils.topologyValidatorIDsInSet(top, expectedValidatorIDs, IStatus.ERROR);
		
		dependerUnit1DependencyReq1.getConstraints().clear();
		saveAndValidate(top);
		assertHasNoErrorStatus(top);

		CommunicationCapability dependedOnUnit1DependencyCommunicationCap1 = (CommunicationCapability)addCapability(dependedOnUnit1, "dependedOnUnit1DependencyCommunicationCap1", CorePackage.eINSTANCE
				.getCommunicationCapability(), CapabilityLinkTypes.DEPENDENCY_LITERAL);
		dependerUnit1DependencyReq1.getConstraints().add(tc2);
		dLink1.setTarget(dependedOnUnit1DependencyCommunicationCap1);
		save(top);
		saveAndValidate(top);
		assertHasNoErrorStatus(top);
		
		dependedOnUnit1DependencyCommunicationCap1.setPort(BigInteger.TEN);
		RangeConstraint rc1 = ConstraintFactory.eINSTANCE.createRangeConstraint();
		rc1.setName("rc1");
		rc1.setMinValue("11");
		rc1.setMaxValue("11");
		rc1.setAttributeName("port");
		tc2.getConstraints().add(rc1);
		
		saveAndValidate(top);
		assertHasErrorStatus(top);
//		System.out.println("Topology errors: \n" + ValidatorTestUtils.getTopologyErrorDescription(top));
		
		rc1.setMinValue("10");
		rc1.setMaxValue("10");
		saveAndValidate(top);
		assertHasNoErrorStatus(top);
	}
	
	/**
	 * Tests validation of top-level type constraints on hosting requirements
	 * 
	 * @throws Exception
	 */
	public void testOredTypeConstraintsOnDependencyRequirements() throws Exception {
		Topology top = this.createTopology("TestOredTypeConstraintsOnDependencyRequirements");

		Unit dependedOnUnit1 = addUnit(top, "dependedOnUnit1");
		Unit dependerUnit1 = addUnit(top, "dependerUnit1");
		Requirement dependerUnit1DependencyReq1 = addRequirement(dependerUnit1, "dependerUnit1DependencyReq1",
				RequirementLinkTypes.DEPENDENCY_LITERAL);
		CommunicationCapability dependedOnUnit1DependencyCommunicationCap1 = (CommunicationCapability)addCapability(dependedOnUnit1, "dependedOnUnit1DependencyCommunicationCap1", CorePackage.eINSTANCE
				.getCommunicationCapability(), CapabilityLinkTypes.DEPENDENCY_LITERAL);
		
		OrConstraint oc1 = ConstraintFactory.eINSTANCE.createOrConstraint();
		oc1.setName("oc1");
		dependerUnit1DependencyReq1.getConstraints().add(oc1);
		
		TypeConstraint tc1 = ConstraintFactory.eINSTANCE.createTypeConstraint();
		tc1.setDmoEType(CorePackage.eINSTANCE.getCommunicationCapability());
		tc1.setName("tc1");
		oc1.getConstraints().add(tc1);
		
		TypeConstraint tc2 = ConstraintFactory.eINSTANCE.createTypeConstraint();
		tc2.setDmoEType(CorePackage.eINSTANCE.getCommunicationCapability());
		tc2.setName("tc2");
		oc1.getConstraints().add(tc2);
		
		dependedOnUnit1DependencyCommunicationCap1.setPort(BigInteger.TEN);

		RangeConstraint rc1 = ConstraintFactory.eINSTANCE.createRangeConstraint();
		rc1.setName("rc1");
		rc1.setMinValue("11");
		rc1.setMaxValue("11");
		rc1.setAttributeName("port");
		tc1.getConstraints().add(rc1);

		RangeConstraint rc2 = ConstraintFactory.eINSTANCE.createRangeConstraint();
		rc2.setName("rc2");
		rc2.setMinValue("10");
		rc2.setMaxValue("10");
		rc2.setAttributeName("port");
		tc2.getConstraints().add(rc2);

		createDependencyLink("dependedOnUnit1DependsOndependerUnit1", dependerUnit1DependencyReq1, dependedOnUnit1DependencyCommunicationCap1);
		
		saveAndValidate(top);
		assertHasNoErrorStatus(top);
		
		rc2.setMinValue("8");
		rc2.setMaxValue("9");
		saveAndValidate(top);
		assertHasErrorStatus(top);
		Set expectedProblemTypes = new HashSet();
		expectedProblemTypes.add(ICoreProblemType.OBJECT_ATTRIBUTE_INVALID);
		ValidatorTestUtils.topologyProblemTypesInSet(top, expectedProblemTypes);
	}

	
	private void saveAndValidate(Topology top) throws IOException {
		save(top);
		validate(top);
	}

}
