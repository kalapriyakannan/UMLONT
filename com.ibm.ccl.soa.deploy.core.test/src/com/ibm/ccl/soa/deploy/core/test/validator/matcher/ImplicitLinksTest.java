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
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.emf.ecore.util.EcoreUtil;

import com.ibm.ccl.soa.deploy.core.AttributeMetaData;
import com.ibm.ccl.soa.deploy.core.Capability;
import com.ibm.ccl.soa.deploy.core.CapabilityLinkTypes;
import com.ibm.ccl.soa.deploy.core.CoreFactory;
import com.ibm.ccl.soa.deploy.core.CorePackage;
import com.ibm.ccl.soa.deploy.core.ExtendedAttribute;
import com.ibm.ccl.soa.deploy.core.HostingLink;
import com.ibm.ccl.soa.deploy.core.RealizationLink;
import com.ibm.ccl.soa.deploy.core.Requirement;
import com.ibm.ccl.soa.deploy.core.RequirementLinkTypes;
import com.ibm.ccl.soa.deploy.core.Topology;
import com.ibm.ccl.soa.deploy.core.Unit;
import com.ibm.ccl.soa.deploy.core.test.TopologyTestCase;
import com.ibm.ccl.soa.deploy.core.test.validator.matcher.implicitlinks.ILLinkDescriptorFactory;
import com.ibm.ccl.soa.deploy.core.test.validator.utils.ValidatorTestUtils;
import com.ibm.ccl.soa.deploy.core.validator.IDeployReporter;
import com.ibm.ccl.soa.deploy.core.validator.IDeployValidationContext;
import com.ibm.ccl.soa.deploy.core.validator.matcher.AbstractLinkDescriptorFactory;
import com.ibm.ccl.soa.deploy.core.validator.matcher.LinkFactory;
import com.ibm.ccl.soa.deploy.core.validator.pattern.UnitValidator;
import com.ibm.ccl.soa.deploy.core.validator.resolution.ResolutionUtils;

public class ImplicitLinksTest extends TopologyTestCase {

	private static final String PROJECT_NAME = "ImplicitLinksTest";

	private Topology top;

	public ImplicitLinksTest() {
		super(PROJECT_NAME);
	}

	public ImplicitLinksTest(String name) {
		super(name);
	}

	/*
	 * @see junit.framework.TestCase#setUp()
	 */
	protected void setUp() throws Exception {
		super.setUp();
		setDeleteProjectOnTearDown(false);
	}

	private static AbstractLinkDescriptorFactory ilDescriptorFactory = new ILLinkDescriptorFactory();

	public void testHosting() throws IOException, CoreException {

		top = createTopology("testHosting");
		// top.getEObject().eResource().save(null);

		// first test is that hosting a unit has a side effect of setting the
		// extended attribute
		
		Unit hostee = createPhysicalUnit(top, "hostee");
		Unit host = createPhysicalUnit(top, "host");
		HostingLink link = LinkFactory.createHostingLink(host, hostee, ilDescriptorFactory);
		ExtendedAttribute a = hostee.getExtendedAttribute("ImpliedHostingLinkValue");
		assert (null != a);
		assert (a.getValue().equals ("Created by Implicit Link"));
	}	

	public void testImplicitHostingViaHosting() throws IOException, CoreException {

		top = createTopology("testImplicitHostingViaHosting");
		// top.getEObject().eResource().save(null);

		// first test is that hosting a unit has a side effect of setting the
		// extended attribute
		
		Unit hostee = createPhysicalUnit(top, "hostee");
		addRequirement(hostee, "hostingRequirement",RequirementLinkTypes.HOSTING_LITERAL);
		Unit conceptualHost = createConceptualUnit(top, "conceptualHost");
		Unit host = createPhysicalUnit(top, "host");
		addCapability(host, "hostingCap", CapabilityLinkTypes.HOSTING_LITERAL);
		LinkFactory.createRealizationLink(conceptualHost, host, ilDescriptorFactory);
		ExtendedAttribute a = hostee.getExtendedAttribute("ImpliedHostingLinkValue");
		assert (null == a);

		LinkFactory.createHostingLink(conceptualHost, hostee);
		a = hostee.getExtendedAttribute("ImpliedHostingLinkValue");
		assert (null != a);
		assert (a.getValue().equals ("Created by Implicit Link"));
	}	

//	public void testImplicitHostingViaRealization() throws IOException, CoreException {
//
//		top = createTopology("testImplicitHostingViaRealization");
//		// top.getEObject().eResource().save(null);
//
//		// first test is that hosting a unit has a side effect of setting the
//		// extended attribute
//		
//		Unit hostee = createPhysicalUnit(top, "hostee");
//		addRequirement(hostee, "hostingRequirement",RequirementLinkTypes.HOSTING_LITERAL);
//		Unit conceptualHost = createConceptualUnit(top, "conceptualHost");
//		Unit host = createPhysicalUnit(top, "host");
//		addCapability(host, "hostingCap", CapabilityLinkTypes.HOSTING_LITERAL);
//		LinkFactory.createHostingLink(conceptualHost, hostee, ilDescriptorFactory);
//		ExtendedAttribute a = hostee.getExtendedAttribute("ImpliedHostingLinkValue");
//		assert (null == a);
//		
//		LinkFactory.createRealizationLink(conceptualHost, host);
//		a = hostee.getExtendedAttribute("ImpliedHostingLinkValue");
//		assert (null != a);
//		assert (a.getValue().equals ("Created by Implicit Link"));
//	}	
//
//	public void testDependency() throws IOException, CoreException {
//		top = createTopology("testDependency");
//		// top.getEObject().eResource().save(null);
//
//		// first test that creating a dependency link has a side effect of setting the
//		// extended attribute
//		
//		Unit source = createPhysicalUnit(top, "source");
//		Requirement sourceRequirement = addRequirement(source, "dependencyRequirement",RequirementLinkTypes.DEPENDENCY_LITERAL);
//		Unit target = createPhysicalUnit(top, "target");
//		Capability targetCapability = addCapability(target, "dependencyCap", CapabilityLinkTypes.DEPENDENCY_LITERAL);
//		LinkFactory.createDependencyLink(sourceRequirement, targetCapability, ilDescriptorFactory);
//		
//		ExtendedAttribute a = target.getExtendedAttribute("ImpliedDependencyLinkValue");
//		assert (null != a);
//		assert (a.getValue().equals ("Created by Implicit Dependency Link"));
//	}	
//
	public void testImplicitDependencyViaDependency() throws IOException, CoreException {
		top = createTopology("testImplicitDependencyViaDependency");
		// top.getEObject().eResource().save(null);

		Unit conceptualSource = createConceptualUnit(top, "conceptualSource");
		Requirement conceptualSourceRequirement = addRequirement(conceptualSource, "conceptualDependencyRequirement",RequirementLinkTypes.DEPENDENCY_LITERAL);
		Unit source = createPhysicalUnit(top, "source");
		Requirement sourceRequirement = addRequirement(source, "dependencyRequirement",RequirementLinkTypes.DEPENDENCY_LITERAL);
		LinkFactory.createRealizationLink(conceptualSource, source);

		Unit target = createPhysicalUnit(top, "target");
		Capability targetCapability = addCapability(target, "dependencyCap", CapabilityLinkTypes.DEPENDENCY_LITERAL);
		LinkFactory.createDependencyLink(conceptualSourceRequirement, targetCapability, ilDescriptorFactory);
		
		ExtendedAttribute a = target.getExtendedAttribute("ImpliedDependencyLinkValue");
		assert (null != a);
		assert (a.getValue().equals ("Created by Implicit Dependency Link"));
	}	

//	public void testImplicitDependencyViaRealization() throws IOException, CoreException {
//		top = createTopology("testImplicitDependencyViaDependency");
//		// top.getEObject().eResource().save(null);
//
//		Unit conceptualSource = createConceptualUnit(top, "conceptualSource");
//		Requirement conceptualSourceRequirement = addRequirement(conceptualSource, "conceptualDependencyRequirement",RequirementLinkTypes.DEPENDENCY_LITERAL);
//
//		Unit target = createPhysicalUnit(top, "target");
//		Capability targetCapability = addCapability(target, "dependencyCap", CapabilityLinkTypes.DEPENDENCY_LITERAL);
//		LinkFactory.createDependencyLink(conceptualSourceRequirement, targetCapability, ilDescriptorFactory);
//
//		ExtendedAttribute a = target.getExtendedAttribute("ImpliedDependencyLinkValue");
//		assert (null == a);
//
//		Unit source = createPhysicalUnit(top, "source");
//		Requirement sourceRequirement = addRequirement(source, "dependencyRequirement",RequirementLinkTypes.DEPENDENCY_LITERAL);
//		LinkFactory.createRealizationLink(conceptualSource, source);
//
//		a = target.getExtendedAttribute("ImpliedDependencyLinkValue");
//		assert (null != a);
//		assert (a.getValue().equals ("Created by Implicit Dependency Link"));
//	}	
//
	public void testMember() throws IOException, CoreException {
		top = createTopology("testMember");
		// top.getEObject().eResource().save(null);

		// first test that creating a dependency link has a side effect of setting the
		// extended attribute
		
		Unit group = createPhysicalUnit(top, "group");
		addRequirement(group, "contains", CorePackage.Literals.UNIT, RequirementLinkTypes.MEMBER_LITERAL);
		Unit member = createPhysicalUnit(top, "member");
		LinkFactory.createMemberLink(group, member, ilDescriptorFactory);
		
		ExtendedAttribute a = member.getExtendedAttribute("ImpliedMemberLinkValue");
		assert (null != a);
		assert (a.getValue().equals ("Created by Implicit Member Link"));
	}	

	public void testImplicitMemberViaMember() throws IOException, CoreException {
		top = createTopology("testImplicitMemberViaMember");
		// top.getEObject().eResource().save(null);

		Unit group = createPhysicalUnit(top, "group");
		addRequirement(group, "contains", CorePackage.Literals.UNIT, RequirementLinkTypes.MEMBER_LITERAL);
		Unit conceptualGroup = createConceptualUnit(top, "conceptualGroup");
		LinkFactory.createRealizationLink(conceptualGroup, group);
		Unit member = createPhysicalUnit(top, "member");
		LinkFactory.createMemberLink(conceptualGroup, member, ilDescriptorFactory);
		
		ExtendedAttribute a = member.getExtendedAttribute("ImpliedMemberLinkValue");
		assert (null != a);
		assert (a.getValue().equals ("Created by Implicit Member Link"));
	}	

//	public void testImplicitMemberViaRealization() throws IOException, CoreException {
//		top = createTopology("testImplicitMemberViaRealization");
//		// top.getEObject().eResource().save(null);
//
//		Unit conceptualGroup = createConceptualUnit(top, "conceptualGroup");
//		addRequirement(conceptualGroup, "conceptual contains", CorePackage.Literals.UNIT, RequirementLinkTypes.MEMBER_LITERAL);
//		Unit member = createPhysicalUnit(top, "member");
//		LinkFactory.createMemberLink(conceptualGroup, member, ilDescriptorFactory);
//		
//		ExtendedAttribute a = member.getExtendedAttribute("ImpliedMemberLinkValue");
//		assert (null == a);
//
//		Unit group = createPhysicalUnit(top, "group");
//		addRequirement(group, "contains", CorePackage.Literals.UNIT, RequirementLinkTypes.MEMBER_LITERAL);
//		LinkFactory.createRealizationLink(conceptualGroup, group);
//
//		a = member.getExtendedAttribute("ImpliedMemberLinkValue");
//		assert (null != a);
//		assert (a.getValue().equals ("Created by Implicit Member Link"));
//	}	
//
	private Unit copyUnit(Unit u, Topology targetTop) {
		ArrayList<Unit> l = new ArrayList<Unit>();
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

	private void assertValidationErrorCount(Unit u1,
			int expectedValidationErrorCount) throws IOException, CoreException {

		u1.getEditTopology().getEObject().eResource().save(null);
		IDeployValidationContext context = createValidationContext(u1
				.getEditTopology());
		IDeployReporter reporter = createDeployReporter();
		UnitValidator validator = new UnitValidator(CorePackage.eINSTANCE
				.getUnit());
		try {
			ValidatorTestUtils.assertValidationErrorCount(
					expectedValidationErrorCount, u1.getEditTopology(), u1,
					context, reporter, validator);
		} catch (CoreException e) {
			e.printStackTrace();
			throw e;
		}
		// System.out.println(ValidatorTestUtils.getTopologyErrorDescription(top));
	}

	private void assertLinkValidationErrorCount(Unit u1, Unit u2,
			int expectedValidationErrorCount) throws IOException, CoreException {
		RealizationLink rl = LinkFactory.createRealizationLink(u1, u2);
		u1.getEditTopology().getEObject().eResource().save(null);
		IDeployValidationContext context = createValidationContext(u1
				.getEditTopology());
		IDeployReporter reporter = createDeployReporter();
		UnitValidator validator = new UnitValidator(CorePackage.eINSTANCE
				.getUnit());
		try {
			ValidatorTestUtils.assertValidationErrorCount(
					expectedValidationErrorCount, u1.getEditTopology(), u1,
					context, reporter, validator);
		} catch (CoreException e) {
			e.printStackTrace();
			throw e;
		}
		// System.out.println(ValidatorTestUtils.getTopologyErrorDescription(top));
		u1.getEditTopology().getRealizationLinks().remove(rl);
	}

}
