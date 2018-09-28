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
import java.util.List;

import org.eclipse.emf.ecore.EClass;

import com.ibm.ccl.soa.deploy.core.Capability;
import com.ibm.ccl.soa.deploy.core.CapabilityLinkTypes;
import com.ibm.ccl.soa.deploy.core.CoreFactory;
import com.ibm.ccl.soa.deploy.core.CorePackage;
import com.ibm.ccl.soa.deploy.core.HostingLink;
import com.ibm.ccl.soa.deploy.core.MemberLink;
import com.ibm.ccl.soa.deploy.core.Requirement;
import com.ibm.ccl.soa.deploy.core.RequirementExpression;
import com.ibm.ccl.soa.deploy.core.RequirementLinkTypes;
import com.ibm.ccl.soa.deploy.core.Topology;
import com.ibm.ccl.soa.deploy.core.Unit;
import com.ibm.ccl.soa.deploy.core.test.TopologyTestCase;
import com.ibm.ccl.soa.deploy.core.util.UnitUtil;
import com.ibm.ccl.soa.deploy.core.validator.DeployValidatorService;
import com.ibm.ccl.soa.deploy.core.validator.expression.InCardinality;
import com.ibm.ccl.soa.deploy.core.validator.expression.OutCardinality;
import com.ibm.ccl.soa.deploy.core.validator.pattern.UnitValidator;
import com.ibm.ccl.soa.deploy.core.validator.pattern.link.MultiplicityChecker;
import com.ibm.ccl.soa.deploy.core.validator.pattern.link.MultiplicityConstraint;
import com.ibm.ccl.soa.deploy.os.OsFactory;

/**
 * Test {@link UnitValidator}
 * 
 * TODO Test the other public methods (currently only checks
 * calculateSourceMultiplicity() and calculateTargetMultiplicity()).
 */
public class MultiplicityCheckerTest extends TopologyTestCase {

	/**
	 * Constructor
	 */
	public MultiplicityCheckerTest() {
		super("MultiplicityCheckerTest");
	}

	/**
	 * @throws IOException
	 */
	public void testBug1316() throws IOException {
		Topology top = createTopology("testBug1316", true);
		Unit a = createGenericUnit(top, "A"); //$NON-NLS-1$

		// Hand craft a constraint w/o RE
		Requirement req = CoreFactory.eINSTANCE.createRequirement();
		req.setName(UnitUtil.generateUniqueName(a, "rim")); //$NON-NLS-1$
		req.setDmoEType(CorePackage.eINSTANCE
				.getUnit());
		req.setLinkType(RequirementLinkTypes.MEMBER_LITERAL);
		a.getRequirements().add(req);

		// Add a fully-qualified constraint
		addMultiplicityOutboundConstraint(a, CorePackage.eINSTANCE
				.getUnit(), 1, -1);
		
		DeployValidatorService service = new DeployValidatorService();
		service.validate(top);
		
		// We MUST fail, because we our outbound constraint is not satisfied
		for (Requirement r : (List<Requirement>) a.getRequirements()) {
			if (r.getConstraints().size() > 0) {
				RequirementExpression re = (RequirementExpression) r.getConstraints().get(0);
				assert !re.getStatus().isOK();
			}
		}
	}
	
	/**
	 * @throws IOException
	 */
// public void testNewMemberLinkOK() throws Exception {
// Topology top = createTopology("testNewMemberLinkOK", true);
//
// MultiplicityChecker.newMemberLinkOK(source, target, respectMultiplicity);
// }
// public void testCanBeLinkSource() {
// Topology top = createTopology("testCanBeLinkSource", true);
//
// MultiplicityChecker.canBeLinkSource(unit);
// }
	public void testCalculateTargetMultiplicity() throws IOException {
		Topology top = createTopology("testCalculateTargetMultiplicity", true);

		int multiplicity;

		// No links
		Unit a = createGenericUnit(top, "A"); //$NON-NLS-1$
		Unit b = createGenericUnit(top, "B"); //$NON-NLS-1$
		assert 0 == (multiplicity = MultiplicityChecker
				.calculateTargetMultiplicity(a, CorePackage.eINSTANCE
						.getUnit(), null)) : multiplicity;

		// A hosting link but no member links
		hostedBy(a, b);
		assert 0 == (multiplicity = MultiplicityChecker
				.calculateTargetMultiplicity(b, CorePackage.eINSTANCE
						.getUnit(), null)) : multiplicity;
		assert 0 == (multiplicity = MultiplicityChecker
				.calculateTargetMultiplicity(a, CorePackage.eINSTANCE
						.getUnit(), null)) : multiplicity;

		// A member link
		addMultiplicityInboundConstraint(a, CorePackage.eINSTANCE
				.getUnit(), 0, -1);
// addMultiplicityInboundConstraint(a, CorePackage.eINSTANCE.getUnit(), 0, -1);
		makeMember(a, b);
		assert 1 == (multiplicity = MultiplicityChecker
				.calculateTargetMultiplicity(a, CorePackage.eINSTANCE
						.getUnit(), null)) : multiplicity;
		assert 0 == (multiplicity = MultiplicityChecker
				.calculateTargetMultiplicity(b, CorePackage.eINSTANCE
						.getUnit(), null)) : multiplicity;

		Unit c = createGenericUnit(top, "C"); //$NON-NLS-1$
		makeMember(a, c);
		assert 2 == (multiplicity = MultiplicityChecker
				.calculateTargetMultiplicity(a, CorePackage.eINSTANCE
						.getUnit(), null)) : multiplicity;
		assert 0 == (multiplicity = MultiplicityChecker
				.calculateTargetMultiplicity(b, CorePackage.eINSTANCE
						.getUnit(), null)) : multiplicity;
		assert 0 == (multiplicity = MultiplicityChecker
				.calculateTargetMultiplicity(c, CorePackage.eINSTANCE
						.getUnit(), null)) : multiplicity;

		// A member link to a non-Generic
		Unit d = createOsUnit(top, "D"); //$NON-NLS-1$
		makeMember(a, d);
		assert 2 == (multiplicity = MultiplicityChecker
				.calculateTargetMultiplicity(a, CorePackage.eINSTANCE
						.getUnit(), null)) : multiplicity;
		assert 0 == (multiplicity = MultiplicityChecker
				.calculateTargetMultiplicity(b, CorePackage.eINSTANCE
						.getUnit(), null)) : multiplicity;
		assert 0 == (multiplicity = MultiplicityChecker
				.calculateTargetMultiplicity(d, CorePackage.eINSTANCE
						.getUnit(), null)) : multiplicity;

		// Now try using base class
		// MK change: 2 --> 3 (a and b are generics and d is an OS)
		assert 3 == (multiplicity = MultiplicityChecker
				.calculateTargetMultiplicity(a, CorePackage.eINSTANCE.getUnit(), null)) : multiplicity;
		assert 0 == (multiplicity = MultiplicityChecker
				.calculateTargetMultiplicity(b, CorePackage.eINSTANCE.getUnit(), null)) : multiplicity;
		assert 0 == (multiplicity = MultiplicityChecker
				.calculateTargetMultiplicity(d, CorePackage.eINSTANCE.getUnit(), null)) : multiplicity;

		// Try with an under-specified inbound constraint
		a.getRequirements().clear();
		addMultiplicityInboundConstraint(a, CorePackage.eINSTANCE.getUnit(), 0,
				-1);
		// MK change: 1 --> 2 (b and c are generics)
		assert 2 == (multiplicity = MultiplicityChecker
				.calculateTargetMultiplicity(a, CorePackage.eINSTANCE
						.getUnit(), null)) : multiplicity;
		assert 0 == (multiplicity = MultiplicityChecker
				.calculateTargetMultiplicity(b, CorePackage.eINSTANCE
						.getUnit(), null)) : multiplicity;
		assert 2 == (multiplicity = MultiplicityChecker
				.calculateTargetMultiplicity(a, CorePackage.eINSTANCE
						.getUnit(), null)) : multiplicity;
		assert 0 == (multiplicity = MultiplicityChecker
				.calculateTargetMultiplicity(b, CorePackage.eINSTANCE
						.getUnit(), null)) : multiplicity;
		assert 0 == (multiplicity = MultiplicityChecker
				.calculateTargetMultiplicity(c, CorePackage.eINSTANCE
						.getUnit(), null)) : multiplicity;
		assert 2 == (multiplicity = MultiplicityChecker
				.calculateTargetMultiplicity(a, CorePackage.eINSTANCE
						.getUnit(), null)) : multiplicity;
		assert 0 == (multiplicity = MultiplicityChecker
				.calculateTargetMultiplicity(b, CorePackage.eINSTANCE
						.getUnit(), null)) : multiplicity;
		assert 0 == (multiplicity = MultiplicityChecker
				.calculateTargetMultiplicity(d, CorePackage.eINSTANCE
						.getUnit(), null)) : multiplicity;
		// MK change: 2 --> 3 (a and b are generics and d is an OS)
		assert 3 == (multiplicity = MultiplicityChecker
				.calculateTargetMultiplicity(a, CorePackage.eINSTANCE.getUnit(), null)) : multiplicity;
		assert 0 == (multiplicity = MultiplicityChecker
				.calculateTargetMultiplicity(b, CorePackage.eINSTANCE.getUnit(), null)) : multiplicity;
		assert 0 == (multiplicity = MultiplicityChecker
				.calculateTargetMultiplicity(d, CorePackage.eINSTANCE.getUnit(), null)) : multiplicity;

		// Try with no inbound constraint at all. (Per-Narinder, it should be
		// possible for a new
		// template to say that it contains a unit/template that doesn't know
		// about it. So if there
		// are no inbound REs, the multiplicity checker should still work.
		a.getRequirements().clear();
		// MK change: 1 --> 2 (b and c are generics)
		assert 2 == (multiplicity = MultiplicityChecker
				.calculateTargetMultiplicity(a, CorePackage.eINSTANCE
						.getUnit(), null)) : multiplicity;
		assert 0 == (multiplicity = MultiplicityChecker
				.calculateTargetMultiplicity(b, CorePackage.eINSTANCE
						.getUnit(), null)) : multiplicity;
		assert 2 == (multiplicity = MultiplicityChecker
				.calculateTargetMultiplicity(a, CorePackage.eINSTANCE
						.getUnit(), null)) : multiplicity;
		assert 0 == (multiplicity = MultiplicityChecker
				.calculateTargetMultiplicity(b, CorePackage.eINSTANCE
						.getUnit(), null)) : multiplicity;
		assert 0 == (multiplicity = MultiplicityChecker
				.calculateTargetMultiplicity(c, CorePackage.eINSTANCE
						.getUnit(), null)) : multiplicity;
		assert 2 == (multiplicity = MultiplicityChecker
				.calculateTargetMultiplicity(a, CorePackage.eINSTANCE
						.getUnit(), null)) : multiplicity;
		assert 0 == (multiplicity = MultiplicityChecker
				.calculateTargetMultiplicity(b, CorePackage.eINSTANCE
						.getUnit(), null)) : multiplicity;
		assert 0 == (multiplicity = MultiplicityChecker
				.calculateTargetMultiplicity(d, CorePackage.eINSTANCE
						.getUnit(), null)) : multiplicity;
		// MK change: 2 --> 3 (a and b are generics and d is an OS)
		assert 3 == (multiplicity = MultiplicityChecker
				.calculateTargetMultiplicity(a, CorePackage.eINSTANCE.getUnit(), null)) : multiplicity;
		assert 0 == (multiplicity = MultiplicityChecker
				.calculateTargetMultiplicity(b, CorePackage.eINSTANCE.getUnit(), null)) : multiplicity;
		assert 0 == (multiplicity = MultiplicityChecker
				.calculateTargetMultiplicity(d, CorePackage.eINSTANCE.getUnit(), null)) : multiplicity;

		// And even groups should be able to contain *groups* that don't know
		// they are contained
		a.getRequirements().clear();
		addMultiplicityOutboundConstraint(a, CorePackage.eINSTANCE
				.getUnit(), 0, -1);
		// MK change: 1 --> 2 (b and c are generics)
		assert 2 == (multiplicity = MultiplicityChecker
				.calculateTargetMultiplicity(a, CorePackage.eINSTANCE
						.getUnit(), null)) : multiplicity;
		assert 0 == (multiplicity = MultiplicityChecker
				.calculateTargetMultiplicity(b, CorePackage.eINSTANCE
						.getUnit(), null)) : multiplicity;
		assert 2 == (multiplicity = MultiplicityChecker
				.calculateTargetMultiplicity(a, CorePackage.eINSTANCE
						.getUnit(), null)) : multiplicity;
		assert 0 == (multiplicity = MultiplicityChecker
				.calculateTargetMultiplicity(b, CorePackage.eINSTANCE
						.getUnit(), null)) : multiplicity;
		assert 0 == (multiplicity = MultiplicityChecker
				.calculateTargetMultiplicity(c, CorePackage.eINSTANCE
						.getUnit(), null)) : multiplicity;
		assert 2 == (multiplicity = MultiplicityChecker
				.calculateTargetMultiplicity(a, CorePackage.eINSTANCE
						.getUnit(), null)) : multiplicity;
		assert 0 == (multiplicity = MultiplicityChecker
				.calculateTargetMultiplicity(b, CorePackage.eINSTANCE
						.getUnit(), null)) : multiplicity;
		assert 0 == (multiplicity = MultiplicityChecker
				.calculateTargetMultiplicity(d, CorePackage.eINSTANCE
						.getUnit(), null)) : multiplicity;
		// MK change: 2 --> 3 (a and b are generics and d is an OS)
		assert 3 == (multiplicity = MultiplicityChecker
				.calculateTargetMultiplicity(a, CorePackage.eINSTANCE.getUnit(), null)) : multiplicity;
		assert 0 == (multiplicity = MultiplicityChecker
				.calculateTargetMultiplicity(b, CorePackage.eINSTANCE.getUnit(), null)) : multiplicity;
		assert 0 == (multiplicity = MultiplicityChecker
				.calculateTargetMultiplicity(d, CorePackage.eINSTANCE.getUnit(), null)) : multiplicity;

		// Of course, a unit can both be contained and contain others
		a.getRequirements().clear();
		addMultiplicityOutboundConstraint(a, CorePackage.eINSTANCE
				.getUnit(), 0, -1);
		addMultiplicityInboundConstraint(a, CorePackage.eINSTANCE
				.getUnit(), 0, -1);
		// MK change: 1 --> 2 (b and c are generics)
		assert 2 == (multiplicity = MultiplicityChecker
				.calculateTargetMultiplicity(a, CorePackage.eINSTANCE
						.getUnit(), null)) : multiplicity;
		assert 0 == (multiplicity = MultiplicityChecker
				.calculateTargetMultiplicity(b, CorePackage.eINSTANCE
						.getUnit(), null)) : multiplicity;
		assert 2 == (multiplicity = MultiplicityChecker
				.calculateTargetMultiplicity(a, CorePackage.eINSTANCE
						.getUnit(), null)) : multiplicity;
		assert 0 == (multiplicity = MultiplicityChecker
				.calculateTargetMultiplicity(b, CorePackage.eINSTANCE
						.getUnit(), null)) : multiplicity;
		assert 0 == (multiplicity = MultiplicityChecker
				.calculateTargetMultiplicity(c, CorePackage.eINSTANCE
						.getUnit(), null)) : multiplicity;
		assert 2 == (multiplicity = MultiplicityChecker
				.calculateTargetMultiplicity(a, CorePackage.eINSTANCE
						.getUnit(), null)) : multiplicity;
		assert 0 == (multiplicity = MultiplicityChecker
				.calculateTargetMultiplicity(b, CorePackage.eINSTANCE
						.getUnit(), null)) : multiplicity;
		assert 0 == (multiplicity = MultiplicityChecker
				.calculateTargetMultiplicity(d, CorePackage.eINSTANCE
						.getUnit(), null)) : multiplicity;
		// MK change: 2 --> 3 (a and b are generics and d is an OS)
		assert 3 == (multiplicity = MultiplicityChecker
				.calculateTargetMultiplicity(a, CorePackage.eINSTANCE.getUnit(), null)) : multiplicity;
		assert 0 == (multiplicity = MultiplicityChecker
				.calculateTargetMultiplicity(b, CorePackage.eINSTANCE.getUnit(), null)) : multiplicity;
		assert 0 == (multiplicity = MultiplicityChecker
				.calculateTargetMultiplicity(d, CorePackage.eINSTANCE.getUnit(), null)) : multiplicity;
	}

	private void addMultiplicityInboundConstraint(Unit inside, EClass ec,
			int min, int max) {
		Requirement req = CoreFactory.eINSTANCE.createRequirement();
		req.setName(UnitUtil.generateUniqueName(inside, "rim")); //$NON-NLS-1$
		req.setDmoEType(ec);
		req.setLinkType(RequirementLinkTypes.MEMBER_LITERAL);
		RequirementExpression inMultiplicity = InCardinality.createExpression(
				min, max);
		req.getExpressions().add(inMultiplicity);
		inside.getRequirements().add(req);
	}

	private void makeMember(Unit inside, Unit container) {
		Requirement req = CoreFactory.eINSTANCE.createRequirement();
		req.setName(UnitUtil.generateUniqueName(container, "rm")); //$NON-NLS-1$
		req.setDmoEType(inside.eClass());
		req.setLinkType(RequirementLinkTypes.MEMBER_LITERAL);
		container.getRequirements().add(req);
		MemberLink ml = CoreFactory.eINSTANCE.createMemberLink();
		ml.setTarget(inside);
		ml.setName(UnitUtil.generateUniqueName(container, "ml")); //$NON-NLS-1$
		container.getMemberLinks().add(ml);
	}

	private void hostedBy(Unit a, Unit b) {
		Requirement req = CoreFactory.eINSTANCE.createRequirement();
		req.setName(UnitUtil.generateUniqueName(a, "r")); //$NON-NLS-1$
		Capability capB = (Capability) b.getCapabilities().get(0);
		req.setDmoEType(capB.eClass());
		req.setLinkType(RequirementLinkTypes.HOSTING_LITERAL);
		a.getRequirements().add(req);
		HostingLink hl = CoreFactory.eINSTANCE.createHostingLink();
		hl.setName(UnitUtil.generateUniqueName(b, "hl")); //$NON-NLS-1$
		hl.setTarget(a);
		b.getHostingLinks().add(hl);
	}

	private Unit createGenericUnit(Topology top, String string) {
		Unit retVal = CoreFactory.eINSTANCE.createUnit();
		retVal.setDisplayName(string);
		retVal.setName(UnitUtil.generateUniqueName(top, string));

		Capability cap = CoreFactory.eINSTANCE.createCapability();
		cap.setName(UnitUtil.generateUniqueName(top, "cap")); //$NON-NLS-1$
		cap.setLinkType(CapabilityLinkTypes.HOSTING_LITERAL);
		retVal.getCapabilities().add(cap);

		top.getUnits().add(retVal);

		return retVal;
	}

	private Unit createOsUnit(Topology top, String string) {
		Unit retVal = OsFactory.eINSTANCE.createOperatingSystemUnit();
		retVal.setDisplayName(string);
		retVal.setName(UnitUtil.generateUniqueName(top, string));

		Capability cap = OsFactory.eINSTANCE.createOperatingSystem();
		cap.setName(UnitUtil.generateUniqueName(top, "cap")); //$NON-NLS-1$
		cap.setLinkType(CapabilityLinkTypes.HOSTING_LITERAL);
		retVal.getCapabilities().add(cap);

		top.getUnits().add(retVal);

		return retVal;
	}

	/**
	 * test calculateSourceMultiplicity()
	 * 
	 * @throws IOException
	 */
	public void testCalculateSourceMultiplicity() throws IOException {
		Topology top = createTopology("testCalculateSourceMultiplicity", true);

		int multiplicity;

		// No links
		Unit a = createGenericUnit(top, "A"); //$NON-NLS-1$
		Unit b = createGenericUnit(top, "B"); //$NON-NLS-1$
		assert 0 == (multiplicity = MultiplicityChecker
				.calculateSourceMultiplicity(a, CorePackage.eINSTANCE
						.getUnit(), null)) : multiplicity;
		assert 0 == (multiplicity = MultiplicityChecker
				.calculateSourceMultiplicity(b, CorePackage.eINSTANCE
						.getUnit(), null)) : multiplicity;

		// A hosting link but no member links
		hostedBy(a, b);
		assert 0 == (multiplicity = MultiplicityChecker
				.calculateSourceMultiplicity(b, CorePackage.eINSTANCE
						.getUnit(), null)) : multiplicity;
		assert 0 == (multiplicity = MultiplicityChecker
				.calculateSourceMultiplicity(a, CorePackage.eINSTANCE
						.getUnit(), null)) : multiplicity;

		// A member link
		addMultiplicityOutboundConstraint(b, CorePackage.eINSTANCE
				.getUnit(), 0, -1);
		makeMember(a, b);
		assert 0 == (multiplicity = MultiplicityChecker
				.calculateSourceMultiplicity(a, CorePackage.eINSTANCE
						.getUnit(), null)) : multiplicity;
		assert 1 == (multiplicity = MultiplicityChecker
				.calculateSourceMultiplicity(b, CorePackage.eINSTANCE
						.getUnit(), null)) : multiplicity;

		Unit c = createGenericUnit(top, "C"); //$NON-NLS-1$
		addMultiplicityOutboundConstraint(c, CorePackage.eINSTANCE
				.getUnit(), 0, -1);
		makeMember(a, c);
		assert 0 == (multiplicity = MultiplicityChecker
				.calculateSourceMultiplicity(a, CorePackage.eINSTANCE
						.getUnit(), null)) : multiplicity;
		assert 1 == (multiplicity = MultiplicityChecker
				.calculateSourceMultiplicity(b, CorePackage.eINSTANCE
						.getUnit(), null)) : multiplicity;
		assert 1 == (multiplicity = MultiplicityChecker
				.calculateSourceMultiplicity(c, CorePackage.eINSTANCE
						.getUnit(), null)) : multiplicity;

		// A member link to a non-Generic
		Unit d = createOsUnit(top, "D"); //$NON-NLS-1$
		addMultiplicityOutboundConstraint(d, CorePackage.eINSTANCE
				.getUnit(), 0, -1);
		makeMember(a, d);
		assert 0 == (multiplicity = MultiplicityChecker
				.calculateSourceMultiplicity(a, CorePackage.eINSTANCE
						.getUnit(), null)) : multiplicity;
		assert 1 == (multiplicity = MultiplicityChecker
				.calculateSourceMultiplicity(b, CorePackage.eINSTANCE
						.getUnit(), null)) : multiplicity;
		assert 1 == (multiplicity = MultiplicityChecker
				.calculateSourceMultiplicity(c, CorePackage.eINSTANCE
						.getUnit(), null)) : multiplicity;
		assert 1 == (multiplicity = MultiplicityChecker
				.calculateSourceMultiplicity(d, CorePackage.eINSTANCE
						.getUnit(), null)) : multiplicity;

		// Now try using base class
		assert 0 == (multiplicity = MultiplicityChecker
				.calculateSourceMultiplicity(a, CorePackage.eINSTANCE.getUnit(), null)) : multiplicity;
		assert 1 == (multiplicity = MultiplicityChecker
				.calculateSourceMultiplicity(b, CorePackage.eINSTANCE.getUnit(), null)) : multiplicity;
		assert 1 == (multiplicity = MultiplicityChecker
				.calculateSourceMultiplicity(c, CorePackage.eINSTANCE.getUnit(), null)) : multiplicity;
		assert 1 == (multiplicity = MultiplicityChecker
				.calculateSourceMultiplicity(d, CorePackage.eINSTANCE.getUnit(), null)) : multiplicity;

		// If there is no cardinality, treat as 0..*
		d.getRequirements().clear();
		addOutboundNatureNoCardinality(d, CorePackage.eINSTANCE
				.getUnit());
		assert 0 == (multiplicity = MultiplicityChecker
				.calculateSourceMultiplicity(a, CorePackage.eINSTANCE
						.getUnit(), null)) : multiplicity;
		assert 1 == (multiplicity = MultiplicityChecker
				.calculateSourceMultiplicity(b, CorePackage.eINSTANCE
						.getUnit(), null)) : multiplicity;
		assert 1 == (multiplicity = MultiplicityChecker
				.calculateSourceMultiplicity(c, CorePackage.eINSTANCE
						.getUnit(), null)) : multiplicity;
		assert 1 == (multiplicity = MultiplicityChecker
				.calculateSourceMultiplicity(d, CorePackage.eINSTANCE
						.getUnit(), null)) : multiplicity;

		// Membership can be 'under-specified'
		d.getRequirements().clear();
		addMultiplicityOutboundConstraint(d, CorePackage.eINSTANCE.getUnit(),
				0, -1);
		assert 0 == (multiplicity = MultiplicityChecker
				.calculateSourceMultiplicity(a, CorePackage.eINSTANCE
						.getUnit(), null)) : multiplicity;
		assert 1 == (multiplicity = MultiplicityChecker
				.calculateSourceMultiplicity(b, CorePackage.eINSTANCE
						.getUnit(), null)) : multiplicity;
		assert 1 == (multiplicity = MultiplicityChecker
				.calculateSourceMultiplicity(c, CorePackage.eINSTANCE
						.getUnit(), null)) : multiplicity;
		assert 1 == (multiplicity = MultiplicityChecker
				.calculateSourceMultiplicity(d, CorePackage.eINSTANCE
						.getUnit(), null)) : multiplicity;
	}

	private void addOutboundNatureNoCardinality(Unit container, EClass ec) {
		Requirement req = CoreFactory.eINSTANCE.createRequirement();
		req.setName(UnitUtil.generateUniqueName(container, "rom")); //$NON-NLS-1$
		req.setDmoEType(ec);
		req.setLinkType(RequirementLinkTypes.MEMBER_LITERAL);
		container.getRequirements().add(req);
	}

	private void addMultiplicityOutboundConstraint(Unit container, EClass ec,
			int min, int max) {
		Requirement req = CoreFactory.eINSTANCE.createRequirement();
		req.setName(UnitUtil.generateUniqueName(container, "rom")); //$NON-NLS-1$
		req.setDmoEType(ec);
		req.setLinkType(RequirementLinkTypes.MEMBER_LITERAL);
		RequirementExpression outMultiplicity = OutCardinality
				.createExpression(min, max);
		req.getExpressions().add(outMultiplicity);
		container.getRequirements().add(req);
	}

	/**
	 * Test invalid OutCardinality
	 * 
	 * @throws IOException
	 */
	public void testNullRange() throws IOException {
		Topology top = createTopology("testNullRange", true);
		Unit a = createGenericUnit(top, "A"); //$NON-NLS-1$
		Requirement req = CoreFactory.eINSTANCE.createRequirement();
		req.setName(UnitUtil.generateUniqueName(a, "rm")); //$NON-NLS-1$
		req.setDmoEType(CorePackage.eINSTANCE.getUnit());
		req.setLinkType(RequirementLinkTypes.MEMBER_LITERAL);

		RequirementExpression re = CoreFactory.eINSTANCE
				.createRequirementExpression();
		re.setInterpreter(OutCardinality.INTERPRETER_ID);
		req.getExpressions().add(re);

		a.getRequirements().add(req);

		MultiplicityConstraint mc = MultiplicityChecker.getConstraint(a,
				CorePackage.eINSTANCE.getUnit());
		assert mc != null;
	}

	/**
	 * Test invalid OutCardinality
	 * 
	 * @throws IOException
	 */
	public void testGoatRange() throws IOException {
		Topology top = createTopology("testNullRange", true);
		Unit a = createGenericUnit(top, "A"); //$NON-NLS-1$
		Requirement req = CoreFactory.eINSTANCE.createRequirement();
		req.setName(UnitUtil.generateUniqueName(a, "rm")); //$NON-NLS-1$
		req.setDmoEType(CorePackage.eINSTANCE.getUnit());
		req.setLinkType(RequirementLinkTypes.MEMBER_LITERAL);

		RequirementExpression re = CoreFactory.eINSTANCE
				.createRequirementExpression();
		re.setInterpreter(OutCardinality.INTERPRETER_ID);
		re.setValue("goat"); // This isn't a legal range, it's not "integer |
								// integer..integer"
		req.getExpressions().add(re);

		a.getRequirements().add(req);

		MultiplicityConstraint mc = MultiplicityChecker.getConstraint(a,
				CorePackage.eINSTANCE.getUnit());
		assert mc != null;
	}

	/**
	 * Test invalid OutCardinality
	 * 
	 * @throws IOException
	 */
	public void testLemonRange() throws IOException {
		Topology top = createTopology("testNullRange", true);
		Unit a = createGenericUnit(top, "A"); //$NON-NLS-1$
		Requirement req = CoreFactory.eINSTANCE.createRequirement();
		req.setName(UnitUtil.generateUniqueName(a, "rm")); //$NON-NLS-1$
		req.setDmoEType(CorePackage.eINSTANCE.getUnit());
		req.setLinkType(RequirementLinkTypes.MEMBER_LITERAL);

		RequirementExpression re = CoreFactory.eINSTANCE
				.createRequirementExpression();
		re.setInterpreter(OutCardinality.INTERPRETER_ID);
		re.setValue("0..lemon"); // This isn't a legal range, it's not
									// "integer | integer..integer"
		req.getExpressions().add(re);

		a.getRequirements().add(req);

		MultiplicityConstraint mc = MultiplicityChecker.getConstraint(a,
				CorePackage.eINSTANCE.getUnit());
		assert mc != null;
	}

	/**
	 * Test invalid OutCardinality
	 * 
	 * @throws IOException
	 */
	public void testSilverRange() throws IOException {
		Topology top = createTopology("testNullRange", true);
		Unit a = createGenericUnit(top, "A"); //$NON-NLS-1$
		Requirement req = CoreFactory.eINSTANCE.createRequirement();
		req.setName(UnitUtil.generateUniqueName(a, "rm")); //$NON-NLS-1$
		req.setDmoEType(CorePackage.eINSTANCE.getUnit());
		req.setLinkType(RequirementLinkTypes.MEMBER_LITERAL);

		RequirementExpression re = CoreFactory.eINSTANCE
				.createRequirementExpression();
		re.setInterpreter(OutCardinality.INTERPRETER_ID);
		re.setValue("silver..3"); // This isn't a legal range, it's not
									// "integer | integer..integer"
		req.getExpressions().add(re);

		a.getRequirements().add(req);

		MultiplicityConstraint mc = MultiplicityChecker.getConstraint(a,
				CorePackage.eINSTANCE.getUnit());
		assert mc != null;
	}

// public void testGetConstraint() {
// Topology top = createTopology("testGetConstraint", true);
//
// MultiplicityChecker.getConstraint(ecSource, target)
// }

// public void testGetConstraint() {
// Topology top = createTopology("testGetConstraint", true);
//
// MultiplicityChecker.getConstraint(unit, ecTarget);
// }

// public void testGetRequirementTypeFilter() {
// Topology top = createTopology("testGetRequirementTypeFilter", true);
//
// MultiplicityChecker.getRequirementTypeFilter(req);
// }

} // end junit MultiplicityCheckerTest
