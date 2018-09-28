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

import junit.framework.TestSuite;

import org.eclipse.core.runtime.CoreException;

import com.ibm.ccl.soa.deploy.core.CapabilityLinkTypes;
import com.ibm.ccl.soa.deploy.core.CommunicationCapability;
import com.ibm.ccl.soa.deploy.core.CorePackage;
import com.ibm.ccl.soa.deploy.core.Requirement;
import com.ibm.ccl.soa.deploy.core.RequirementLinkTypes;
import com.ibm.ccl.soa.deploy.core.Topology;
import com.ibm.ccl.soa.deploy.core.Unit;
import com.ibm.ccl.soa.deploy.core.test.TopologyTestCase;
import com.ibm.ccl.soa.deploy.core.validator.IDeployReporter;
import com.ibm.ccl.soa.deploy.core.validator.matcher.LinkFactory;
import com.ibm.ccl.soa.deploy.core.validator.pattern.UnitValidator;
import com.ibm.ccl.soa.deploy.internal.core.validator.matcher.RealizationLinkMatcher;
import com.ibm.ccl.soa.deploy.core.constraint.ConstraintFactory;
import com.ibm.ccl.soa.deploy.core.constraint.EqualsConstraint;
import com.ibm.ccl.soa.deploy.core.constraint.OrConstraint;
import com.ibm.ccl.soa.deploy.core.constraint.TypeConstraint;

public class RealizationMatcherExtTest extends TopologyTestCase {

	private static final String PROJECT_NAME = "RealizationMatcherExtTest";

	RealizationLinkMatcher rlm = new RealizationLinkMatcher();

	UnitValidator validator = new UnitValidator(CorePackage.eINSTANCE.getUnit());

	IDeployReporter reporter = createDeployReporter();

	private Topology top;

	public RealizationMatcherExtTest() {
		super(PROJECT_NAME);
	}

	public RealizationMatcherExtTest(String name) {
		super(name);
	}

	public static TestSuite suite() {
		TestSuite suite = new TestSuite();
		suite.addTestSuite(RealizationMatcherExtTest.class);
		return suite;
	}

	/*
	 * @see junit.framework.TestCase#setUp()
	 */
	protected void setUp() throws Exception {
		super.setUp();
		setDeleteProjectOnTearDown(false);
	}

	public void testRealizationLinkMatchingExtSingleUnit() throws IOException, CoreException {

		top = createTopology("testRealizationLinkMatchingExtSingleUnit");
		save(top);
		RealizationLinkMatcher rlm = new RealizationLinkMatcher();

		Unit cu1 = addUnit(top, "cu1");
		cu1.setConceptual(true);

		Unit ru1 = addUnit(top, "ru1");
		CommunicationCapability cu1ccap1 = (CommunicationCapability) addCapability(cu1, "cu1ccap1", CorePackage.eINSTANCE.getCommunicationCapability(),
				CapabilityLinkTypes.ANY_LITERAL);
		CommunicationCapability ru1ccap1 = (CommunicationCapability) addCapability(ru1, "ru1ccap1", CorePackage.eINSTANCE.getCommunicationCapability(),
				CapabilityLinkTypes.ANY_LITERAL);

		// Test strict attribute matching mode (used only by auto-realization wizard)
		{
			cu1ccap1.setApplicationLayerProtocol("http");
			ru1ccap1.setApplicationLayerProtocol("https");
			save(top);

			assert rlm.canCreateLink(cu1, ru1, false, false).isOK();
			assert !rlm.canCreateLink(cu1, ru1, true, false).isOK();
			assert rlm.canCreateLink(cu1, ru1, false, true).isOK();
			assert !rlm.canCreateLink(cu1, ru1, true, true).isOK();

			ru1.setMutable(false);
			save(top);

			assert !rlm.canCreateLink(cu1, ru1, false, false).isOK();
			assert !rlm.canCreateLink(cu1, ru1, true, false).isOK();
			assert !rlm.canCreateLink(cu1, ru1, false, true).isOK();
			assert !rlm.canCreateLink(cu1, ru1, true, true).isOK();

			ru1ccap1.setApplicationLayerProtocol("http");
			save(top);
		}

		// Constraint (equals) on capability on conceptual unit (applicationlayerprotocol)
		{
			ru1.setMutable(true);
			ru1ccap1.setApplicationLayerProtocol("https");
			cu1ccap1.eUnset(CorePackage.eINSTANCE.getCommunicationCapability_ApplicationLayerProtocol());
			save(top);

			assert rlm.canCreateLink(cu1, ru1, false, false).isOK();
			assert rlm.canCreateLink(cu1, ru1, true, false).isOK();
			assert rlm.canCreateLink(cu1, ru1, false, true).isOK();
			assert rlm.canCreateLink(cu1, ru1, true, true).isOK();

			EqualsConstraint ec = createEqualsConstraint(CorePackage.eINSTANCE.getCommunicationCapability_ApplicationLayerProtocol().getName(), "http");
			cu1ccap1.getConstraints().add(ec);
			save(top);
			assert rlm.canCreateLink(cu1, ru1, false, false).isOK();
			assert rlm.canCreateLink(cu1, ru1, true, false).isOK();
			assert !rlm.canCreateLink(cu1, ru1, false, true).isOK();
			assert !rlm.canCreateLink(cu1, ru1, true, true).isOK();
		}

		// Constraint (equals) on conceptual unit (displayname)
		{
			cu1ccap1.setApplicationLayerProtocol("http");
			ru1ccap1.setApplicationLayerProtocol("http");
			cu1ccap1.getConstraints().clear();
			save(top);

			assert rlm.canCreateLink(cu1, ru1, false, false).isOK();
			assert rlm.canCreateLink(cu1, ru1, true, false).isOK();
			assert rlm.canCreateLink(cu1, ru1, false, true).isOK();
			assert rlm.canCreateLink(cu1, ru1, true, true).isOK();

			EqualsConstraint ec = createEqualsConstraint(CorePackage.eINSTANCE.getDeployModelObject_DisplayName().getName(), "FOO");
			cu1.getConstraints().add(ec);
			save(top);
			assert rlm.canCreateLink(cu1, ru1, false, false).isOK();
			assert rlm.canCreateLink(cu1, ru1, true, false).isOK();
			assert !rlm.canCreateLink(cu1, ru1, false, true).isOK();
			assert !rlm.canCreateLink(cu1, ru1, true, true).isOK();
			ru1.setDisplayName("FOO");
			save(top);
			assert rlm.canCreateLink(cu1, ru1, false, false).isOK();
			assert rlm.canCreateLink(cu1, ru1, true, false).isOK();
			assert rlm.canCreateLink(cu1, ru1, false, true).isOK();
			assert rlm.canCreateLink(cu1, ru1, true, true).isOK();

		}

	}

	public void testRealizationLinkMatchingExtConstraintOnReq() throws IOException, CoreException {

		top = createTopology("testRealizationLinkMatchingExtConstraintOnReq");
		save(top);
		RealizationLinkMatcher rlm = new RealizationLinkMatcher();

		Unit cu1 = addUnit(top, "cu1");
		cu1.setConceptual(true);

		Unit ru1 = addUnit(top, "ru1");

		Unit rudt1 = addUnit(top, "rudt1");
		CommunicationCapability rudt1ccap1 = (CommunicationCapability) addCapability(rudt1, "rudt1ccap1", CorePackage.eINSTANCE.getCommunicationCapability(),
				CapabilityLinkTypes.ANY_LITERAL);

		Requirement cu1hreq = addRequirement(cu1, "cu1dreq", CorePackage.eINSTANCE.getCommunicationCapability(), RequirementLinkTypes.DEPENDENCY_LITERAL);
		Requirement ru1hreq = addRequirement(ru1, "ru1dreq", CorePackage.eINSTANCE.getCommunicationCapability(), RequirementLinkTypes.DEPENDENCY_LITERAL);

		LinkFactory.createDependencyLink(ru1hreq, rudt1ccap1);
		save(top);

		assert rlm.canCreateLink(cu1, ru1, false, false).isOK();
		assert rlm.canCreateLink(cu1, ru1, true, false).isOK();
		assert rlm.canCreateLink(cu1, ru1, false, true).isOK();
		assert rlm.canCreateLink(cu1, ru1, true, true).isOK();

		// ApplicationLayerPrototol
		EqualsConstraint ec = createEqualsConstraint(CorePackage.eINSTANCE.getCommunicationCapability_ApplicationLayerProtocol().getName(), "http");
		cu1hreq.getConstraints().add(ec);
		rudt1ccap1.setApplicationLayerProtocol("http");
		save(top);
		assert rlm.canCreateLink(cu1, ru1, false, false).isOK();
		assert rlm.canCreateLink(cu1, ru1, true, false).isOK();
		assert rlm.canCreateLink(cu1, ru1, false, true).isOK();
		assert rlm.canCreateLink(cu1, ru1, true, true).isOK();
		rudt1ccap1.setApplicationLayerProtocol("https");
		save(top);
		assert rlm.canCreateLink(cu1, ru1, false, false).isOK();
		assert rlm.canCreateLink(cu1, ru1, true, false).isOK();
		// broken?
//		assert !rlm.canCreateLink(cu1, ru1, false, true).isOK();
//		assert !rlm.canCreateLink(cu1, ru1, true, true).isOK();
		
		// broken?
//		ru1.setMutable(false);
//		rudt1.setMutable(false);
//		assert !rlm.canCreateLink(cu1, ru1, false, false).isOK();
//		assert !rlm.canCreateLink(cu1, ru1, true, false).isOK();
		
		

	}
	
	public void testRealizationLinkMatchingExtOredTypeConstraintOnReq() throws IOException, CoreException {

		top = createTopology("testRealizationLinkMatchingExtOredTypeConstraintOnReq");
		save(top);
		RealizationLinkMatcher rlm = new RealizationLinkMatcher();

		Unit cu1 = addUnit(top, "cu1");
		cu1.setConceptual(true);

		Unit ru1 = addUnit(top, "ru1");

		Requirement cu1hreq = addRequirement(cu1, "cu1hreq", CorePackage.eINSTANCE.getCommunicationCapability(), RequirementLinkTypes.HOSTING_LITERAL);
		Requirement ru1hreq = addRequirement(ru1, "ru1hreq", CorePackage.eINSTANCE.getCommunicationCapability(), RequirementLinkTypes.HOSTING_LITERAL);

		OrConstraint orConstraint = ConstraintFactory.eINSTANCE.createOrConstraint();
		orConstraint.setName("c0");
		
		cu1hreq.getConstraints().add(orConstraint);
		
		TypeConstraint tc1 = ConstraintFactory.eINSTANCE.createTypeConstraint();
		tc1.setName("c0");
		tc1.setDmoEType(CorePackage.eINSTANCE.getCapability());
		orConstraint.getConstraints().add(tc1);
		save(top);
		
		assert rlm.canCreateLink(cu1, ru1, false, false).isOK();
		assert rlm.canCreateLink(cu1, ru1, true, false).isOK();
		assert rlm.canCreateLink(cu1, ru1, false, true).isOK();
		assert rlm.canCreateLink(cu1, ru1, true, true).isOK();
	}	

	/**
	 * @param attribute
	 * @param value
	 * @return
	 */
	private EqualsConstraint createEqualsConstraint(String attribute, String value) {
		EqualsConstraint constraint = ConstraintFactory.eINSTANCE.createEqualsConstraint();
		constraint.setName("c0");
		constraint.setAttributeName(attribute);
		constraint.setValue(value);
		return constraint;
	}
}
