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
import java.math.BigInteger;

import com.ibm.ccl.soa.deploy.core.AttributeMetaData;
import com.ibm.ccl.soa.deploy.core.Capability;
import com.ibm.ccl.soa.deploy.core.CapabilityLinkTypes;
import com.ibm.ccl.soa.deploy.core.CommunicationCapability;
import com.ibm.ccl.soa.deploy.core.CoreFactory;
import com.ibm.ccl.soa.deploy.core.CorePackage;
import com.ibm.ccl.soa.deploy.core.ExplicitContract;
import com.ibm.ccl.soa.deploy.core.IDecoratorSemanticConstants;
import com.ibm.ccl.soa.deploy.core.Requirement;
import com.ibm.ccl.soa.deploy.core.RequirementLinkTypes;
import com.ibm.ccl.soa.deploy.core.Topology;
import com.ibm.ccl.soa.deploy.core.Unit;
import com.ibm.ccl.soa.deploy.core.Visibility;
import com.ibm.ccl.soa.deploy.core.constraint.CollocationConstraint;
import com.ibm.ccl.soa.deploy.core.constraint.ConstraintFactory;
import com.ibm.ccl.soa.deploy.core.constraint.OrConstraint;
import com.ibm.ccl.soa.deploy.core.constraint.RangeConstraint;
import com.ibm.ccl.soa.deploy.core.constraint.TypeConstraint;
import com.ibm.ccl.soa.deploy.core.test.TopologyTestCase;
import com.ibm.ccl.soa.deploy.internal.core.validator.matcher.DependencyLinkMatcher;
import com.ibm.ccl.soa.deploy.internal.core.validator.matcher.HostingLinkMatcher;

/**
 * Tests {@link CollocationConstraint}.
 */
public class ConstraintsOnRequirementsMatcherTest extends TopologyTestCase {

	/**
	 * 
	 */
	public ConstraintsOnRequirementsMatcherTest() {
		super(ConstraintsOnRequirementsMatcherTest.class.getSimpleName());
		this.setDeleteProjectOnTearDown(false);
	}

	/**
	 * Tests validation for matching of top-level type constraints and attribute value constraints 
	 * on hosting requirements.
	 * 
	 * @throws Exception
	 */
	public void testTypeConstraintsOnHostingRequirementsMatch() throws Exception {
		Topology top = this.createTopology("testTypeConstraintsOnHostingRequirementsMatch");
		top.setDecoratorSemantic(IDecoratorSemanticConstants.DeploymentDS_ID);
		addNullContract(top);
		HostingLinkMatcher hlm = new HostingLinkMatcher();

		Unit hostUnit1 = addUnit(top, "HostUnit1");
		Unit hostedUnit1 = addUnit(top, "HostedUnit1");
		Requirement hostedUnit1HostingReq1 = addRequirement(hostedUnit1, "HostedUnit1HostingReq1",
				RequirementLinkTypes.HOSTING_LITERAL);
		addCapability(hostUnit1, "HostUnit1HostingCap1", CapabilityLinkTypes.HOSTING_LITERAL);
		TypeConstraint tc1 = ConstraintFactory.eINSTANCE.createTypeConstraint();
		tc1.setDmoEType(CorePackage.eINSTANCE.getCapability());
		tc1.setName("tc1");
		hostedUnit1HostingReq1.getConstraints().add(tc1);

		save(top);
		assert hlm.canCreateLink(hostUnit1, hostedUnit1).isOK();

		// HostedUnit1 with type constraint for CommunicationCapability, hosted
		// on HostUnit1 with
		// only a Capability
		TypeConstraint tc2 = ConstraintFactory.eINSTANCE.createTypeConstraint();
		tc2.setDmoEType(CorePackage.eINSTANCE.getCommunicationCapability());
		tc2.setName("tc2");
		hostedUnit1HostingReq1.getConstraints().add(tc2);
		save(top);
		assert !hlm.canCreateLink(hostUnit1, hostedUnit1).isOK();

		hostedUnit1HostingReq1.getConstraints().clear();
		save(top);
		assert hlm.canCreateLink(hostUnit1, hostedUnit1).isOK();

		CommunicationCapability hostUnit1HostingCommunicationCap1 = (CommunicationCapability)addCapability(hostUnit1, "HostUnit1HostingCommunicationCap1", CorePackage.eINSTANCE
				.getCommunicationCapability(), CapabilityLinkTypes.HOSTING_LITERAL);
		hostedUnit1HostingReq1.getConstraints().add(tc2);
		save(top);
		assert hlm.canCreateLink(hostUnit1, hostedUnit1).isOK();
		
		hostUnit1HostingCommunicationCap1.setPort(BigInteger.TEN);
		RangeConstraint rc1 = ConstraintFactory.eINSTANCE.createRangeConstraint();
		rc1.setName("rc1");
		rc1.setMinValue("11");
		rc1.setMaxValue("11");
		rc1.setAttributeName("port");
		tc2.getConstraints().add(rc1);

		save(top);
		// Matching does take into account attribute value constraints (AVC), 
		// but AVC validateForPotentialMatch returns OK if attribute does not match but is mutable 
		assert hlm.canCreateLink(hostUnit1, hostedUnit1).isOK();

		hostUnit1HostingCommunicationCap1.setMutable(false);
		save(top);
		// but if the capability is immutable, we can not create the link
		assert !hlm.canCreateLink(hostUnit1, hostedUnit1).isOK();
		
		hostUnit1HostingCommunicationCap1.setMutable(true);
		AttributeMetaData immutableAMD = CoreFactory.eINSTANCE.createAttributeMetaData();
		immutableAMD.setAttributeName("port");
		immutableAMD.setMutable(false);
		hostUnit1HostingCommunicationCap1.getAttributeMetaData().add(immutableAMD);
		save(top);
		// if the attribute is immutable, we can not create the link 
		assert !hlm.canCreateLink(hostUnit1, hostedUnit1).isOK();
		
		rc1.setMinValue("10");
		rc1.setMaxValue("10");
		save(top);
		assert hlm.canCreateLink(hostUnit1, hostedUnit1).isOK();
	}
	
	/**
	 * Tests validation for matching of OR constraints, type constraints, and attribute value constraints 
	 * on hosting requirements.
	 * 
	 * @throws Exception
	 */
	public void testOredTypeConstraintsOnHostingRequirementsMatch() throws Exception {
		Topology top = this.createTopology("TestOredTypeConstraintsOnHostingRequirementsMatch");
		top.setDecoratorSemantic(IDecoratorSemanticConstants.DeploymentDS_ID);
		addNullContract(top);
		
		HostingLinkMatcher hlm = new HostingLinkMatcher();

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
		// set immutable, to inforce full validation during matching
		hostUnit1HostingCommunicationCap1.setMutable(false);

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

		save(top);
		// will match, because one RC is satisfied
		assert hlm.canCreateLink(hostUnit1, hostedUnit1).isOK();
		
		rc2.setMinValue("8");
		rc2.setMaxValue("9");
		save(top);
		// will not match because neither RC is satisfied, and the capability 
		// is immutable, which forces full validation
		assert !hlm.canCreateLink(hostUnit1, hostedUnit1).isOK();
		
		// set mutable, to get relaxed validation of AVCs during matching
		hostUnit1HostingCommunicationCap1.setMutable(true);
		save(top);
		assert hlm.canCreateLink(hostUnit1, hostedUnit1).isOK();		
	}

	/**
	 * Tests validation for maching of top-level type constraints and attribute value constraints 
	 * on dependency requirements.
	 * 
	 * @throws Exception
	 */
	public void testTypeConstraintsOnDependencyRequirementsMatch() throws Exception {
		Topology top = this.createTopology("testTypeConstraintsOnDependencyRequirementsMatch");
		top.setDecoratorSemantic(IDecoratorSemanticConstants.DeploymentDS_ID);
		addNullContract(top);
		
		DependencyLinkMatcher dlm = new DependencyLinkMatcher();

		Unit dependedOnUnit1 = addUnit(top, "dependedOnUnit1");
		Unit dependerUnit1 = addUnit(top, "dependerUnit1");
		Requirement dependerUnit1DependencyReq1 = addRequirement(dependerUnit1, "dependerUnit1DependencyReq1",
				RequirementLinkTypes.DEPENDENCY_LITERAL);
		Capability dependedOnUnit1DependencyCap1 = addCapability(dependedOnUnit1, "dependedOnUnit1DependencyCap1", CapabilityLinkTypes.DEPENDENCY_LITERAL);
		TypeConstraint tc1 = ConstraintFactory.eINSTANCE.createTypeConstraint();
		tc1.setDmoEType(CorePackage.eINSTANCE.getCapability());
		tc1.setName("tc1");
		dependerUnit1DependencyReq1.getConstraints().add(tc1);

		save(top);
		assert dlm.canCreateLink(dependerUnit1, dependerUnit1DependencyReq1, dependedOnUnit1, dependedOnUnit1DependencyCap1).isOK();

		// Dependency requirement with type constraint for CommunicationCapability, linked to
		// simple capability
		TypeConstraint tc2 = ConstraintFactory.eINSTANCE.createTypeConstraint();
		tc2.setDmoEType(CorePackage.eINSTANCE.getCommunicationCapability());
		tc2.setName("tc2");
		dependerUnit1DependencyReq1.getConstraints().add(tc2);
		
		save(top);
		assert !dlm.canCreateLink(dependerUnit1, dependerUnit1DependencyReq1, dependedOnUnit1, dependedOnUnit1DependencyCap1).isOK();

		
		dependerUnit1DependencyReq1.getConstraints().clear();
		save(top);
		assert dlm.canCreateLink(dependerUnit1, dependerUnit1DependencyReq1, dependedOnUnit1, dependedOnUnit1DependencyCap1).isOK();

		CommunicationCapability dependedOnUnit1DependencyCommunicationCap1 = (CommunicationCapability)addCapability(dependedOnUnit1, "dependedOnUnit1DependencyCommunicationCap1", CorePackage.eINSTANCE
				.getCommunicationCapability(), CapabilityLinkTypes.DEPENDENCY_LITERAL);
		dependerUnit1DependencyReq1.getConstraints().add(tc2);
		save(top);
		assert dlm.canCreateLink(dependerUnit1, dependerUnit1DependencyReq1, dependedOnUnit1, dependedOnUnit1DependencyCommunicationCap1).isOK();

		dependedOnUnit1DependencyCommunicationCap1.setPort(BigInteger.TEN);
		RangeConstraint rc1 = ConstraintFactory.eINSTANCE.createRangeConstraint();
		rc1.setName("rc1");
		rc1.setMinValue("11");
		rc1.setMaxValue("11");
		rc1.setAttributeName("port");
		tc2.getConstraints().add(rc1);

		// make the capability immutabe, to enforce full validation during matching
		dependedOnUnit1DependencyCommunicationCap1.setMutable(false);		
		save(top);

		// can not match because capability is immutable and Range Constraint is not satisfied
		assert !dlm.canCreateLink(dependerUnit1, dependerUnit1DependencyReq1, dependedOnUnit1, dependedOnUnit1DependencyCommunicationCap1).isOK();
		
		dependedOnUnit1DependencyCommunicationCap1.setMutable(true);		
		save(top);
		// can match because capability is mutable
		assert dlm.canCreateLink(dependerUnit1, dependerUnit1DependencyReq1, dependedOnUnit1, dependedOnUnit1DependencyCommunicationCap1).isOK();

		AttributeMetaData immutableAMD = CoreFactory.eINSTANCE.createAttributeMetaData();
		immutableAMD.setAttributeName("port");
		immutableAMD.setMutable(false);
		dependedOnUnit1DependencyCommunicationCap1.getAttributeMetaData().add(immutableAMD);
		save(top);
		// can not match because capability is mutable, but 'port' attribute is immutable
		assert !dlm.canCreateLink(dependerUnit1, dependerUnit1DependencyReq1, dependedOnUnit1, dependedOnUnit1DependencyCommunicationCap1).isOK();

		rc1.setMinValue("10");
		rc1.setMaxValue("10");
		save(top);
		
		// can match because Range Constraint is now satisfied
		assert dlm.canCreateLink(dependerUnit1, dependerUnit1DependencyReq1, dependedOnUnit1, dependedOnUnit1DependencyCommunicationCap1).isOK();

	}
	
	/**
	 * Tests validation for matching of OR constraints, type constraints, and attribute value constraints 
	 * on dependency requirements.
	 * 
	 * @throws Exception
	 */
	public void testOredTypeConstraintsOnDependencyRequirementsMatch() throws Exception {
		Topology top = this.createTopology("TestOredTypeConstraintsOnDependencyRequirementsMatch");
		top.setDecoratorSemantic(IDecoratorSemanticConstants.DeploymentDS_ID);
		addNullContract(top);
		
		DependencyLinkMatcher dlm = new DependencyLinkMatcher();

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
		// set immutable, to inforce full validation during matching
		dependedOnUnit1DependencyCommunicationCap1.setMutable(false);

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

		save(top);
		// will match because one Range C. is satisfied 
		assert dlm.canCreateLink(dependerUnit1, dependerUnit1DependencyReq1, dependedOnUnit1, dependedOnUnit1DependencyCommunicationCap1).isOK();
		
		rc2.setMinValue("8");
		rc2.setMaxValue("9");
		save(top);
		// will not match because neither RC is satisfied, and the capability is immutable, which forces full validation
		assert !dlm.canCreateLink(dependerUnit1, dependerUnit1DependencyReq1, dependedOnUnit1, dependedOnUnit1DependencyCommunicationCap1).isOK();
		
		// set mutable, to get relaxed validation of AVCs during matching
		dependedOnUnit1DependencyCommunicationCap1.setMutable(true);
		save(top);
		assert dlm.canCreateLink(dependerUnit1, dependerUnit1DependencyReq1, dependedOnUnit1, dependedOnUnit1DependencyCommunicationCap1).isOK();
	}

	
	private void saveAndValidate(Topology top) throws IOException {
		save(top);
		validate(top);
	}
	
	private void addNullContract(Topology top) {
		ExplicitContract nc = CoreFactory.eINSTANCE.createExplicitContract();
		nc.setName("Null0");
		nc.setDisplayName("Null contract");
		nc.setDefaultConceptualPolicy(Visibility.PRIVATE_LITERAL);
		nc.setDefaultPolicy(Visibility.PRIVATE_LITERAL);
		top.setConfigurationContract(nc);
	}

}
