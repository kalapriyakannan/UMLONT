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
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;

import junit.framework.TestSuite;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.emf.ecore.EDataType;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecore.xml.type.XMLTypePackage;

import com.ibm.ccl.soa.deploy.core.AttributeMetaData;
import com.ibm.ccl.soa.deploy.core.Capability;
import com.ibm.ccl.soa.deploy.core.CapabilityLinkTypes;
import com.ibm.ccl.soa.deploy.core.CommunicationCapability;
import com.ibm.ccl.soa.deploy.core.ConceptualNode;
import com.ibm.ccl.soa.deploy.core.ConfigurationContract;
import com.ibm.ccl.soa.deploy.core.CoreFactory;
import com.ibm.ccl.soa.deploy.core.CorePackage;
import com.ibm.ccl.soa.deploy.core.ExplicitContract;
import com.ibm.ccl.soa.deploy.core.ExtendedAttribute;
import com.ibm.ccl.soa.deploy.core.HostingLink;
import com.ibm.ccl.soa.deploy.core.IDecoratorSemanticConstants;
import com.ibm.ccl.soa.deploy.core.Import;
import com.ibm.ccl.soa.deploy.core.InstallState;
import com.ibm.ccl.soa.deploy.core.RealizationLink;
import com.ibm.ccl.soa.deploy.core.Requirement;
import com.ibm.ccl.soa.deploy.core.RequirementExpression;
import com.ibm.ccl.soa.deploy.core.RequirementExpressionUsage;
import com.ibm.ccl.soa.deploy.core.RequirementLinkTypes;
import com.ibm.ccl.soa.deploy.core.Stereotype;
import com.ibm.ccl.soa.deploy.core.Topology;
import com.ibm.ccl.soa.deploy.core.Unit;
import com.ibm.ccl.soa.deploy.core.Visibility;
import com.ibm.ccl.soa.deploy.core.test.TopologyTestCase;
import com.ibm.ccl.soa.deploy.core.test.validator.utils.ValidatorTestUtils;
import com.ibm.ccl.soa.deploy.core.util.TopologyUtil;
import com.ibm.ccl.soa.deploy.core.validator.IDeployReporter;
import com.ibm.ccl.soa.deploy.core.validator.IDeployValidationContext;
import com.ibm.ccl.soa.deploy.core.validator.ValidatorUtils;
import com.ibm.ccl.soa.deploy.core.validator.expression.Equals;
import com.ibm.ccl.soa.deploy.core.validator.expression.Version;
import com.ibm.ccl.soa.deploy.core.validator.matcher.DeployMatcherStatus;
import com.ibm.ccl.soa.deploy.core.validator.matcher.LinkFactory;
import com.ibm.ccl.soa.deploy.core.validator.pattern.UnitValidator;
import com.ibm.ccl.soa.deploy.core.validator.resolution.ResolutionUtils;
import com.ibm.ccl.soa.deploy.core.validator.status.IDeployCoreValidators;
import com.ibm.ccl.soa.deploy.internal.core.validator.matcher.RealizationLinkMatcher;

public class RealizationMatcherTest extends TopologyTestCase {

	private static final String PROJECT_NAME = "RealizationMatcherAndValidatorTest";

	RealizationLinkMatcher rlm = new RealizationLinkMatcher();
	UnitValidator validator = new UnitValidator(CorePackage.eINSTANCE.getUnit());
	IDeployReporter reporter = createDeployReporter();

	private Topology top;

	public RealizationMatcherTest() {
		super(PROJECT_NAME);
	}

	public RealizationMatcherTest(String name) {
		super(name);
	}
	


	public static TestSuite suite() {
		TestSuite suite = new TestSuite();
		//suite.addTest(new RealizationMatcherTest("testRealizationLinkMatchingWithLinks"));
		suite.addTestSuite(RealizationMatcherTest.class);
		return suite;
	}


	/*
	 * @see junit.framework.TestCase#setUp()
	 */
	protected void setUp() throws Exception {
		super.setUp();
		setDeleteProjectOnTearDown(false);
	}

	public void testRealizationLinkMatching() throws IOException, CoreException {

		top = createTopology("testRealizationLinkMatching");
		save(top);

		// test from source requirement on source unit ...
		Unit unit1 = CoreFactory.eINSTANCE.createUnit();
		unit1.setName("unit1");
		unit1.setConceptual(true);

		Capability c1 = CoreFactory.eINSTANCE.createCapability();
		c1.setLinkType(CapabilityLinkTypes.ANY_LITERAL);
		c1.setName("c");
		unit1.getCapabilities().add(c1);

		ExtendedAttribute ea1 = CoreFactory.eINSTANCE.createExtendedAttribute();
		ea1.setName("foo");
		ea1.setValue(new Integer(7));
		ea1.setInstanceType(XMLTypePackage.Literals.INT);
		
		AttributeMetaData ea1md = CoreFactory.eINSTANCE.createAttributeMetaData();
		ea1md.setAttributeName(ea1.getName());
		ea1md.setMutable(false);

		ExtendedAttribute ea2 = CoreFactory.eINSTANCE.createExtendedAttribute();
		ea2.setName("foo");
		ea2.setValue(new Integer(7));
		ea2.setInstanceType(XMLTypePackage.Literals.INT);

		// test from source requirement on source unit to target capability on
		// target unit
		Requirement r1 = CoreFactory.eINSTANCE.createRequirement();
		r1.setName("r1");
		r1.setDmoEType(CorePackage.Literals.CAPABILITY);
		r1.setLinkType(RequirementLinkTypes.DEPENDENCY_LITERAL);
		unit1.getRequirements().add(r1);
		assert (unit1.getRequirements().size() > 0);

		Unit unitCopy1 = copyUnit(unit1, top);
		// MK: why do we just clear the topology?
		top.getUnits().clear();
		top.getUnits().add(unitCopy1);
		Unit unitCopy2 = copyUnit(unit1, top);
		// MK: why do we clear the topology?
		// top.getUnits().clear();
		top.getUnits().add(unitCopy2);
		assert (unitCopy1.getCapabilities().size() == unit1.getCapabilities()
				.size());
		assert (unitCopy1.getRequirements().size() == unit1.getRequirements()
				.size());
		assert (unitCopy1.getCapabilities().size() > 0);
		assert (unitCopy1.getRequirements().size() > 0);

		// Very basic match with self
		{
			assert (rlm.canBeLinkSource(unitCopy1).isOK());
			assert (rlm.canBeLinkTarget(unitCopy1).isOK());
			assert (rlm.canCreateLink(unitCopy1, unitCopy2).isOK());
		}

		// Conceptual unit with capability not on target unit;
		{
			unitCopy2.getCapabilities().clear();
			assert (rlm.canBeLinkSource(unitCopy1).isOK());
			assert (rlm.canBeLinkTarget(unitCopy1).isOK());
			assertMatchAndLinkInvalid(unitCopy1, unitCopy2);
		}

		CommunicationCapability cc1 = CoreFactory.eINSTANCE
				.createCommunicationCapability();
		cc1.setName("cc1");
		cc1.setPort(BigInteger.valueOf(11));
		cc1.setApplicationLayerProtocol("http");
		cc1.setLinkType(CapabilityLinkTypes.ANY_LITERAL);
		cc1.setMutable(false);

		CommunicationCapability cc2 = CoreFactory.eINSTANCE
				.createCommunicationCapability();
		cc2.setName("cc2");
		cc2.setPort(BigInteger.valueOf(12));
		cc2.setApplicationLayerProtocol("http");
		cc2.setLinkType(CapabilityLinkTypes.ANY_LITERAL);

		CommunicationCapability cc3 = CoreFactory.eINSTANCE
				.createCommunicationCapability();
		cc3.setName("cc3");
		cc3.setPort(BigInteger.valueOf(12));
		cc3.setApplicationLayerProtocol("http");
		cc3.setLinkType(CapabilityLinkTypes.ANY_LITERAL);

		Capability c2 = CoreFactory.eINSTANCE.createCapability();
		c2.setName("c2");
		c2.setLinkType(CapabilityLinkTypes.ANY_LITERAL);

		Capability c3 = CoreFactory.eINSTANCE.createCapability();
		c3.setName("c3");
		c3.setLinkType(CapabilityLinkTypes.ANY_LITERAL);

		Requirement r2 = CoreFactory.eINSTANCE.createRequirement();
		r2.setName("r2");
		r2.setDmoEType(CorePackage.Literals.CAPABILITY);
		r2.setLinkType(RequirementLinkTypes.DEPENDENCY_LITERAL);

		Requirement rcc1 = CoreFactory.eINSTANCE.createRequirement();
		rcc1.setName("rcc");
		rcc1.setDmoEType(CorePackage.Literals.COMMUNICATION_CAPABILITY);

		// No Capability on target that is subtype of a capability on conceptual
		// unit
		{
			top.getUnits().clear();
			unitCopy1 = copyUnit(unit1, top);
			top.getUnits().add(unitCopy1); // MK addition
			unitCopy2 = copyUnit(unit1, top);
			top.getUnits().add(unitCopy2); // MK addition
			unitCopy1.getCapabilities().add(cc1);
			unitCopy2.getCapabilities().add(c2);
			assertMatchAndLinkInvalid(unitCopy1, unitCopy2);
		}

		// Each Capability on target is subtype of a capability on conceptual
		// unit
		{
			top.getUnits().clear();
			unitCopy1 = copyUnit(unit1, top);
			top.getUnits().add(unitCopy1); // MK addition
			unitCopy2 = copyUnit(unit1, top);
			top.getUnits().add(unitCopy2); // MK addition
			unitCopy2.getCapabilities().add(cc1);
			unitCopy1.getCapabilities().add(c2);
			assert (rlm.canCreateLink(unitCopy1, unitCopy2).isOK());

			// Force 2 unmatched capabilities - 2 errors
			unitCopy1.getCapabilities().clear();
			unitCopy2.getCapabilities().clear();
			assertMatchAndLinkValid(unitCopy1, unitCopy2);
			addCapability(unitCopy1, "unitCopy1Cap",
					CorePackage.Literals.COMMUNICATION_CAPABILITY,
					CapabilityLinkTypes.HOSTING_LITERAL);
			addCapability(unitCopy1, "unitCopy2Cap", CorePackage.eINSTANCE
					.getCommunicationCapability(),
					CapabilityLinkTypes.HOSTING_LITERAL);
			assertMatchAndLinkInvalid(unitCopy1, unitCopy2, 2);
			HashSet<String> set = new HashSet<String>();
			set.add(IDeployCoreValidators.REALIZATION_LINK_005);
			assert (ValidatorTestUtils.getTopologyStatusOfSeverityCount(top,
					IStatus.ERROR) == 2);
			ValidatorTestUtils.topologyValidatorIDsInSet(top, set);
		}

		// Conceptual unit has requirements not on target unit
		{
			top.getUnits().clear();
			unitCopy1 = copyUnit(unit1, top);
			top.getUnits().add(unitCopy1); // MK addition
			unitCopy2 = copyUnit(unit1, top);
			top.getUnits().add(unitCopy2); // MK addition
			unitCopy2.getRequirements().clear();
			assertMatchAndLinkInvalid(unitCopy1, unitCopy2);
			unitCopy1.getRequirements().clear();
			assertMatchAndLinkValid(unitCopy1, unitCopy2);
			// Force 2 unmatched requirements - 2 errors
			addRequirement(unitCopy1, "unitCopy1Req1", CorePackage.eINSTANCE
					.getCommunicationCapability(),
					RequirementLinkTypes.HOSTING_LITERAL);
			addRequirement(unitCopy1, "unitCopy1Req2", CorePackage.eINSTANCE
					.getCommunicationCapability(),
					RequirementLinkTypes.HOSTING_LITERAL);
			assertMatchAndLinkInvalid(unitCopy1, unitCopy2, 2);
			HashSet<String> set = new HashSet<String>();
			set.add(IDeployCoreValidators.REALIZATION_LINK_006);
			assert (ValidatorTestUtils.getTopologyStatusOfSeverityCount(top,
					IStatus.ERROR) == 2);
			ValidatorTestUtils.topologyValidatorIDsInSet(top, set);
		}

		// Conceptual unit has requirement, target unit doesn't have a
		// corresponding requirement that is a subtype of it.
		{
			top.getUnits().clear();
			unitCopy1 = copyUnit(unit1, top);
			top.getUnits().add(unitCopy1); // MK addition
			unitCopy2 = copyUnit(unit1, top);
			top.getUnits().add(unitCopy2); // MK addition
			unitCopy1.getRequirements().clear();
			unitCopy1.getRequirements().add(rcc1); // communications req
			unitCopy2.getRequirements().add(r2); // basic cap req
			assertMatchAndLinkInvalid(unitCopy1, unitCopy2);
		}
		// Conceptual unit has capability, target unit has corresponding
		// capability but with a different attribute value.
		{
			top.getUnits().clear();
			unitCopy1 = copyUnit(unit1, top);
			unitCopy1.setMutable(false);
			top.getUnits().add(unitCopy1); // MK addition
			unitCopy2 = copyUnit(unit1, top);
			unitCopy2.setMutable(false);
			top.getUnits().add(unitCopy2); // MK addition
			unitCopy1.getCapabilities().clear();
			unitCopy2.getCapabilities().clear();
			unitCopy1.getCapabilities().add(cc1);
			unitCopy1.setMutable(false);
			unitCopy2.getCapabilities().add(cc2);
			// Different source attribute value
			assertMatchAndLinkInvalid(unitCopy1, unitCopy2, 2);
			BigInteger savedPortValue = cc2.getPort();
			// Same source attribute value
			cc2.setPort(cc1.getPort());
			assertMatchAndLinkValid(unitCopy1, unitCopy2);
			String savedApplicationLayerProtocol = cc1
					.getApplicationLayerProtocol();
			// Null source attribute value
			cc1.setApplicationLayerProtocol(null);
			assertMatchAndLinkValid(unitCopy1, unitCopy2);
			// Empty source attribute value
			cc1.setApplicationLayerProtocol("");
			assertMatchAndLinkValid(unitCopy1, unitCopy2);
			// Different source attribute value
			cc1
					.setApplicationLayerProtocol(savedApplicationLayerProtocol
							+ "x");
			assertMatchAndLinkInvalid(unitCopy1, unitCopy2, 2);
			
			// Attribute mismatched but mutable - match valid, error in validation
			unitCopy1.setMutable(true);
			unitCopy2.setMutable(true);
			boolean savedMutablecc1 = cc1.isMutable();
			cc1.setMutable(true);
			boolean savedMutablecc2 = cc2.isMutable();
			cc2.setMutable(true);
			assertMatch(unitCopy1, unitCopy2);
			this.assertLinkValidationErrorCount(unitCopy1, unitCopy2, 2);
			cc2.setMutable(false);
			assertNoMatch(unitCopy1, unitCopy2);
			
			cc1.setApplicationLayerProtocol(savedApplicationLayerProtocol);
			cc1.setMutable(savedMutablecc1);
			cc2.setMutable(savedMutablecc2);
			cc2.setPort(savedPortValue);
			
		}
		// Some tests for Extended Attributes on capabilities
		{
			top.getUnits().clear();
			unitCopy1 = copyUnit(unit1, top);
			unitCopy1.setMutable(false);
			top.getUnits().add(unitCopy1); // MK addition
			unitCopy2 = copyUnit(unit1, top);
			unitCopy2.setMutable(false);
			top.getUnits().add(unitCopy2); // MK addition

			((Capability) unitCopy1.getCapabilities().get(0))
			.getExtendedAttributes().add(ea1);
			// set attribute ea1 immutable (indirect test of mutability on source attribute)
			((Capability) unitCopy1.getCapabilities().get(0))
			.getAttributeMetaData().add(ea1md);
			assertMatchAndLinkInvalid(unitCopy1, unitCopy2, 2);
			((Capability) unitCopy2.getCapabilities().get(0))
					.getExtendedAttributes().add(ea2);

			eaTests(ea1, ea2, unitCopy1, unitCopy2, rlm);
		}
		// Some tests for Extended Attributes on units
		{
			top.getUnits().clear();
			unitCopy1 = copyUnit(unit1, top);
			unitCopy1.setMutable(false);
			top.getUnits().add(unitCopy1); // MK addition
			unitCopy2 = copyUnit(unit1, top);
			unitCopy2.setMutable(false);
			top.getUnits().add(unitCopy2); // MK addition

			unitCopy1.getExtendedAttributes().add(ea1);
			// set attribute ea1 immutable (indirect test of mutability on source attribute)
			unitCopy1.getAttributeMetaData().add(ea1md);
			assertMatchAndLinkInvalid(unitCopy1, unitCopy2);
			unitCopy2.getExtendedAttributes().add(ea2);
			eaTests(ea1, ea2, unitCopy1, unitCopy2, rlm);
		}

		// Capability pairs match
		{
			top.getUnits().clear();
			unitCopy1 = copyUnit(unit1, top);
			unitCopy1.setMutable(false);
			top.getUnits().add(unitCopy1); // MK addition
			unitCopy2 = copyUnit(unit1, top);
			top.getUnits().add(unitCopy2); // MK addition

			unitCopy1.getCapabilities().add(c2);
			unitCopy1.getCapabilities().add(cc1);
			unitCopy1.getCapabilities().add(cc2);

			unitCopy2.getCapabilities().add(copyCap(c2));
			unitCopy2.getCapabilities().add(copyCap(cc1));
			assertMatchAndLinkInvalid(unitCopy1, unitCopy2, 2);
			unitCopy2.getCapabilities().add(copyCap(cc2));

			assertMatchAndLinkValid(unitCopy1, unitCopy2);
			unitCopy1.getCapabilities().add(copyCap(cc2));
			assertMatchAndLinkInvalid(unitCopy1, unitCopy2);

		}

		// Pathological capability pairs match.
		{
			top.getUnits().clear();
			unitCopy1 = copyUnit(unit1, top);
			top.getUnits().add(unitCopy1); // MK addition
			unitCopy2 = copyUnit(unit1, top);
			top.getUnits().add(unitCopy2); // MK addition
			int numCaps = 20;

			unitCopy1.getCapabilities().clear();
			unitCopy2.getCapabilities().clear();

			CommunicationCapability cCaps1[] = new CommunicationCapability[numCaps];
			for (int i = 0; i < numCaps; ++i) {
				cCaps1[i] = CoreFactory.eINSTANCE
						.createCommunicationCapability();
				cCaps1[i].setName("CUCC" + new Integer(i));
				cCaps1[i].setApplicationLayerProtocol("http");
				cCaps1[i].setPort(BigInteger.valueOf(i + 1024));
				cCaps1[i].setLinkType(CapabilityLinkTypes.ANY_LITERAL);
				unitCopy1.getCapabilities().add(cCaps1[i]);
			}
			CommunicationCapability cCaps2[] = new CommunicationCapability[numCaps];
			for (int i = 0; i < numCaps; ++i) {
				cCaps2[i] = CoreFactory.eINSTANCE
						.createCommunicationCapability();
				cCaps2[i].setName("TUCC" + new Integer(i));
				cCaps2[i].setApplicationLayerProtocol("http");
				cCaps2[i].setPort(BigInteger.valueOf(i + 1024));
				cCaps2[i].setLinkType(CapabilityLinkTypes.ANY_LITERAL);
				unitCopy2.getCapabilities().add(cCaps2[i]);
			}
			assertMatchAndLinkValid(unitCopy1, unitCopy2);
			unitCopy1.getCapabilities().add(cc2);
			assertMatch(unitCopy1, unitCopy2);
			unitCopy1.setMutable(false);
			assertMatch(unitCopy1, unitCopy2);
			assertLinkValidationErrorCount(unitCopy1, unitCopy2, 2);
			unitCopy2.setMutable(false);
			assertMatchAndLinkInvalid(unitCopy1, unitCopy2, 2);
		}

		// Pathological capability pairs match - reverse order of capabilities.
		{
			top.getUnits().clear();
			unitCopy1 = copyUnit(unit1, top);
			top.getUnits().add(unitCopy1); // MK addition
			unitCopy2 = copyUnit(unit1, top);
			top.getUnits().add(unitCopy2); // MK addition
			int numCaps = 20;

			unitCopy1.getCapabilities().clear();
			unitCopy2.getCapabilities().clear();

			CommunicationCapability cCaps1[] = new CommunicationCapability[numCaps];
			for (int i = 0; i < numCaps; ++i) {
				cCaps1[i] = CoreFactory.eINSTANCE
						.createCommunicationCapability();
				cCaps1[i].setName("CUCC" + new Integer(i));
				cCaps1[i].setApplicationLayerProtocol("http");
				cCaps1[i].setPort(BigInteger.valueOf(i + 1024));
				cCaps1[i].setLinkType(CapabilityLinkTypes.ANY_LITERAL);
				unitCopy1.getCapabilities().add(cCaps1[i]);
			}
			CommunicationCapability cCaps2[] = new CommunicationCapability[numCaps];
			for (int i = numCaps - 1; i >= 0; --i) {
				cCaps2[i] = CoreFactory.eINSTANCE
						.createCommunicationCapability();
				cCaps2[i].setName("TUCC" + new Integer(i));
				cCaps2[i].setApplicationLayerProtocol("http");
				cCaps2[i].setPort(BigInteger.valueOf(i + 1024));
				cCaps2[i].setLinkType(CapabilityLinkTypes.ANY_LITERAL);
				unitCopy2.getCapabilities().add(cCaps2[i]);
			}
			assertMatchAndLinkValid(unitCopy1, unitCopy2);
			unitCopy1.getCapabilities().add(cc2);
			assertMatch(unitCopy1, unitCopy2);
			unitCopy1.setMutable(false);
			assertMatch(unitCopy1, unitCopy2);
			assertLinkValidationErrorCount(unitCopy1, unitCopy2, 2);
			unitCopy2.setMutable(false);
			assertMatchAndLinkInvalid(unitCopy1, unitCopy2, 2);
		}

		// Pathological requirement pairs match.
		{
			top.getUnits().clear();
			unitCopy1 = copyUnit(unit1, top);
			top.getUnits().add(unitCopy1); // MK addition
			unitCopy2 = copyUnit(unit1, top);
			top.getUnits().add(unitCopy2); // MK addition
			int numReqs = 20;

			unitCopy1.getRequirements().clear();
			unitCopy2.getRequirements().clear();

			Requirement Reqs1[] = new Requirement[numReqs];
			for (int i = 0; i < numReqs; ++i) {
				Reqs1[i] = CoreFactory.eINSTANCE.createRequirement();
				Reqs1[i].setName("CUR" + new Integer(i));
				Reqs1[i].setDmoEType(CorePackage.Literals.CAPABILITY);
				Reqs1[i].setLinkType(RequirementLinkTypes.HOSTING_LITERAL);
				unitCopy1.getRequirements().add(Reqs1[i]);
			}
			Requirement Reqs2[] = new Requirement[numReqs];
			for (int i = 0; i < numReqs; ++i) {
				Reqs2[i] = CoreFactory.eINSTANCE.createRequirement();
				Reqs2[i].setName("TUR" + new Integer(i));
				Reqs2[i].setDmoEType(CorePackage.Literals.CAPABILITY);
				Reqs2[i].setLinkType(RequirementLinkTypes.HOSTING_LITERAL);
				unitCopy2.getRequirements().add(Reqs2[i]);
			}
			assertMatchAndLinkValid(unitCopy1, unitCopy2);
			unitCopy1.getRequirements().add(rcc1);
			assertMatchAndLinkInvalid(unitCopy1, unitCopy2);
		}
		// LinkType on capability
		{
			top.getUnits().clear();
			unitCopy1 = copyUnit(unit1, top);
			top.getUnits().add(unitCopy1); // MK addition
			unitCopy2 = copyUnit(unit1, top);
			top.getUnits().add(unitCopy2); // MK addition

			unitCopy1.getCapabilities().clear();
			unitCopy2.getCapabilities().clear();
			unitCopy1.getCapabilities().add(c1);
			unitCopy2.getCapabilities().add(c2);
			assertMatchAndLinkValid(unitCopy1, unitCopy2);
			CapabilityLinkTypes saved_c1Lt = c1.getLinkType();
			CapabilityLinkTypes saved_c2Lt = c2.getLinkType();

			c1.setLinkType(CapabilityLinkTypes.DEPENDENCY_LITERAL);
			c2.setLinkType(CapabilityLinkTypes.DEPENDENCY_LITERAL);
			assertMatchAndLinkValid(unitCopy1, unitCopy2);
			c2.setLinkType(CapabilityLinkTypes.HOSTING_LITERAL);
			assertMatchAndLinkInvalid(unitCopy1, unitCopy2, 2);
			c2.setLinkType(CapabilityLinkTypes.ANY_LITERAL);
			assertMatchAndLinkInvalid(unitCopy1, unitCopy2, 2);

			c1.setLinkType(CapabilityLinkTypes.HOSTING_LITERAL);
			c2.setLinkType(CapabilityLinkTypes.HOSTING_LITERAL);
			assertMatchAndLinkValid(unitCopy1, unitCopy2);
			c2.setLinkType(CapabilityLinkTypes.DEPENDENCY_LITERAL);
			assertMatchAndLinkInvalid(unitCopy1, unitCopy2, 2);
			c2.setLinkType(CapabilityLinkTypes.ANY_LITERAL);
			assertMatchAndLinkInvalid(unitCopy1, unitCopy2, 2);

			c1.setLinkType(CapabilityLinkTypes.ANY_LITERAL);
			c2.setLinkType(CapabilityLinkTypes.ANY_LITERAL);
			assertMatchAndLinkValid(unitCopy1, unitCopy2);
			c2.setLinkType(CapabilityLinkTypes.DEPENDENCY_LITERAL);
			assertMatchAndLinkValid(unitCopy1, unitCopy2);
			c2.setLinkType(CapabilityLinkTypes.ANY_LITERAL);
			assertMatchAndLinkValid(unitCopy1, unitCopy2);

			c1.setLinkType(saved_c1Lt);
			c2.setLinkType(saved_c2Lt);

		}

		// LinkType on requirement
		{
			top.getUnits().clear();
			unitCopy1 = copyUnit(unit1, top);
			top.getUnits().add(unitCopy1); // MK addition
			unitCopy2 = copyUnit(unit1, top);
			top.getUnits().add(unitCopy2); // MK addition

			unitCopy1.getRequirements().clear();
			unitCopy2.getRequirements().clear();
			unitCopy1.getRequirements().add(r1);
			unitCopy2.getRequirements().add(r2);
			assert (r2.getLinkType().equals(r1.getLinkType()));
			assertMatchAndLinkValid(unitCopy1, unitCopy2);
			RequirementLinkTypes saved_r1Lt = r1.getLinkType();
			RequirementLinkTypes saved_r2Lt = r2.getLinkType();

			r2.setLinkType(RequirementLinkTypes.MEMBER_LITERAL);
			assert (!r2.getLinkType().equals(r1.getLinkType()));

			r1.setLinkType(saved_r1Lt);
			r2.setLinkType(saved_r2Lt);

		}

		// RequirementExpression on requirement
		{
			top.getUnits().clear();
			unit1.getRequirements().add(r1);
			assert (unit1.getRequirements().size() > 0);
			unitCopy1 = copyUnit(unit1, top);
			top.getUnits().add(unitCopy1); // MK addition
			unitCopy2 = copyUnit(unit1, top);
			top.getUnits().add(unitCopy2); // MK addition

			Requirement req1 = (Requirement) unitCopy1.getRequirements().get(0);
			Requirement req2 = (Requirement) unitCopy2.getRequirements().get(0);

			assert (req1 != null && req2 != null);
			RequirementExpression rexp1 = CoreFactory.eINSTANCE
					.createRequirementExpression();
			rexp1.setName("rexp1");
			rexp1.setAttributeName("foo");
			rexp1.setDisplayName("rexp1");
			rexp1.setInterpreter(Equals.INTERPRETER_ID);
			rexp1.setUse(RequirementExpressionUsage.REQUIRED_LITERAL);
			rexp1.setValue("xyz");
			req1.getExpressions().clear();
			req1.getExpressions().add(rexp1);

			RequirementExpression rexp2 = CoreFactory.eINSTANCE
					.createRequirementExpression();
			rexp2.setName("rexp2");
			rexp2.setAttributeName("foo");
			rexp2.setDisplayName("rexp2");
			rexp2.setInterpreter(Equals.INTERPRETER_ID);
			rexp2.setUse(RequirementExpressionUsage.REQUIRED_LITERAL);
			rexp2.setValue("xyz");
			req2.getExpressions().clear();
			req2.getExpressions().add(rexp2);

			String savedAttributeName = rexp2.getAttributeName();
			String savedInterpreter = rexp2.getInterpreter();
			String savedValue = rexp2.getValue();
			RequirementExpressionUsage savedUse = rexp2.getUse();
			assertMatchAndLinkValid(unitCopy1, unitCopy2);

			rexp2.setAttributeName(savedAttributeName + "x");
			assertMatchAndLinkInvalid(unitCopy1, unitCopy2);
			rexp2.setAttributeName(savedAttributeName);

			rexp2.setInterpreter(Version.INTERPRETER_ID);
			assertMatchAndLinkInvalid(unitCopy1, unitCopy2);
			rexp2.setInterpreter(savedInterpreter);

			rexp2.setUse(RequirementExpressionUsage.OPTIONAL_LITERAL);
			assert (!rexp2.getUse().equals(rexp1.getUse()));
			assertMatchAndLinkInvalid(unitCopy1, unitCopy2);
			rexp2.setUse(savedUse);

			rexp2.setValue(savedValue + "x");
			assertMatchAndLinkInvalid(unitCopy1, unitCopy2);
			rexp2.setValue(savedValue);
			assertMatchAndLinkValid(unitCopy1, unitCopy2);
		}
		// Realization cycles
		{
			top.getUnits().clear();
			unit1.getRequirements().add(r1);
			assert (unit1.getRequirements().size() > 0);
			unitCopy1 = copyUnit(unit1, top);
			top.getUnits().add(unitCopy1);
			unitCopy2 = copyUnit(unit1, top);
			top.getUnits().add(unitCopy2);
			assertMatchAndLinkInvalid(unitCopy1, unitCopy1); // Degenerate
																// cycle
			// Degenerate cycle
			assertMatchAndLinkInvalid(unitCopy1, unitCopy1);
			LinkFactory.createRealizationLink(unitCopy1, unitCopy2);
			// 2-unit cycle
			assertMatchAndLinkInvalid(unitCopy2, unitCopy1);
			Unit unitCopy3 = copyUnit(unit1, top);
			top.getUnits().add(unitCopy3);
			assertMatchAndLinkValid(unitCopy2, unitCopy3);
			LinkFactory.createRealizationLink(unitCopy2, unitCopy3);
			// 3-unit cycle
			assertMatchAndLinkInvalid(unitCopy3, unitCopy1);
		}

		// Unit attributes
		{
			top.getUnits().clear();
			unit1.getRequirements().add(r1);
			assert (unit1.getRequirements().size() > 0);
			unitCopy1 = copyUnit(unit1, top);
			top.getUnits().add(unitCopy1);
			unitCopy2 = copyUnit(unit1, top);
			top.getUnits().add(unitCopy2);

			// Bill Arnold 2007/04/06 consensus is that PublishIntent is
			// advisory,
			// and should not be checked for matching.
// assertMatchAndLinkValid(unitCopy1, unitCopy2);
// unitCopy1.setPublishIntent(PublishIntent.PUBLISH_LITERAL);
// unitCopy2.setPublishIntent(PublishIntent.PUBLISH_LITERAL);
// assertMatchAndLinkValid(unitCopy1, unitCopy2);
// unitCopy2.setPublishIntent(PublishIntent.DO_NOT_PUBLISH_LITERAL);
// assertMatchAndLinkInvalid(unitCopy1, unitCopy2);
// unitCopy2.setPublishIntent(PublishIntent.UNKNOWN_LITERAL);
// assertMatchAndLinkInvalid(unitCopy1, unitCopy2);
// unitCopy2.setPublishIntent(PublishIntent.PUBLISH_LITERAL);

			unitCopy1.setInitInstallState(InstallState.INSTALLED_LITERAL);
			unitCopy2.setInitInstallState(InstallState.INSTALLED_LITERAL);
			assertMatchAndLinkValid(unitCopy1, unitCopy2);
			unitCopy2.setInitInstallState(InstallState.NOT_INSTALLED_LITERAL);
			assertMatchAndLinkInvalid(unitCopy1, unitCopy2);
			unitCopy2.setInitInstallState(InstallState.UNKNOWN_LITERAL);
			assertMatchAndLinkInvalid(unitCopy1, unitCopy2);
			unitCopy2.setInitInstallState(InstallState.INSTALLED_LITERAL);

			unitCopy1.setConfigurationUnit(true);
			unitCopy2.setConfigurationUnit(true);
			assertMatchAndLinkValid(unitCopy1, unitCopy2);
			unitCopy1.setConfigurationUnit(false);
			unitCopy2.setConfigurationUnit(false);
			assertMatchAndLinkValid(unitCopy1, unitCopy2);
			unitCopy1.setConfigurationUnit(true);
			unitCopy2.setConfigurationUnit(false);
			assertMatchAndLinkInvalid(unitCopy1, unitCopy2);
			unitCopy2.setConfigurationUnit(true);

			assertMatchAndLinkValid(unitCopy1, unitCopy2);
		}
		{
			top.getUnits().clear();
			unit1.getRequirements().add(r1);
			assert (unit1.getRequirements().size() > 0);
			unitCopy1 = copyUnit(unit1, top);
			top.getUnits().add(unitCopy1);
			unitCopy2 = copyUnit(unit1, top);
			top.getUnits().add(unitCopy2);

			CommunicationCapability cc01 = CoreFactory.eINSTANCE
					.createCommunicationCapability();
			cc01.setName("cc01");
			cc01.setPort(BigInteger.valueOf(11));
			cc01.setApplicationLayerProtocol("http");
			cc01.setLinkType(CapabilityLinkTypes.ANY_LITERAL);

			CommunicationCapability cc02 = CoreFactory.eINSTANCE
					.createCommunicationCapability();
			cc02.setName("cc02");
			cc02.setPort(BigInteger.valueOf(11));
			cc02.setApplicationLayerProtocol("http");
			cc02.setLinkType(CapabilityLinkTypes.ANY_LITERAL);

			unitCopy1.getCapabilities().add(cc01);
			unitCopy2.getCapabilities().add(cc02);

			assertMatchAndLinkValid(unitCopy1, unitCopy2);
			AttributeMetaData cc01alpamd = CoreFactory.eINSTANCE
					.createAttributeMetaData();
			cc01alpamd
					.setAttributeName(CorePackage.Literals.COMMUNICATION_CAPABILITY__APPLICATION_LAYER_PROTOCOL
							.getName());
			cc01.getAttributeMetaData().add(cc01alpamd);

			AttributeMetaData cc02alpamd = CoreFactory.eINSTANCE
					.createAttributeMetaData();
			cc02alpamd
					.setAttributeName(CorePackage.Literals.COMMUNICATION_CAPABILITY__APPLICATION_LAYER_PROTOCOL
							.getName());
			cc02.getAttributeMetaData().add(cc02alpamd);

// “encrypted” matches according to the following rules:
// a.isEncrypted = true - a’.isEncrypted = true
// a.isEncrypted = false - a’.isEncrypted = anything
// a.isEncrypted = null - a’.isEncrypted = anything
			cc01alpamd.setEncrypted(false);
			cc02alpamd.setEncrypted(false);
			assertMatchAndLinkValid(unitCopy1, unitCopy2);

			cc01alpamd.setEncrypted(true);
			cc02alpamd.setEncrypted(false);
			assertMatchAndLinkInvalid(unitCopy1, unitCopy2, 2);
			cc01alpamd.setEncrypted(false);
			assertMatchAndLinkValid(unitCopy1, unitCopy2);

// “encryptionRequired” matches according to the following rules:
// a.isEncryptionRequired = true - a’.isEncryptionRequired = true
// a.isEncryptionRequired = false - a’.isEncryptionRequired = anything
// a.isEncryptionRequired = null - a’.isEncryptionRequired = anything

			cc01alpamd.setEncryptionRequired(true);
			cc02alpamd.setEncryptionRequired(true);
			assertMatchAndLinkValid(unitCopy1, unitCopy2);

			cc02alpamd.setEncryptionRequired(false);
			assertMatchAndLinkInvalid(unitCopy1, unitCopy2, 2);
			cc02alpamd.setEncryptionRequired(true);
			cc01alpamd.setEncryptionRequired(false);
			assertMatchAndLinkValid(unitCopy1, unitCopy2);
			cc01alpamd.setEncryptionRequired(true);
			assertMatchAndLinkValid(unitCopy1, unitCopy2);

// “optional” matches according to the following rules:
// a.isOptional = true - a’.isOptional = anything
// a.isOptional = false - a’.isOptional = false
// a.isOptional = null - a’.isOptional = anything

			cc01alpamd.setOptional(true);
			cc02alpamd.setOptional(true);
			assertMatchAndLinkValid(unitCopy1, unitCopy2);

			cc01alpamd.setOptional(true);
			cc02alpamd.setOptional(false);
			assertMatchAndLinkValid(unitCopy1, unitCopy2);

			cc01alpamd.setOptional(false);
			cc02alpamd.setOptional(false);
			assertMatchAndLinkValid(unitCopy1, unitCopy2);

			cc01alpamd.setOptional(false);
			cc02alpamd.setOptional(true);
			assertMatchAndLinkInvalid(unitCopy1, unitCopy2, 2);
		}

		// Conceptual node realization matching
		// Test for check for hosting requirements match
		{
			top.getUnits().clear();

			ConceptualNode conceptualNode = CoreFactory.eINSTANCE
					.createConceptualNode();
			conceptualNode.setName("conceptualNode");
			conceptualNode.setConceptual(true);
			top.getUnits().add(conceptualNode);

			Unit uHostedOnCN = addUnit(top, "uHostedOnCN");
			Requirement uHostedOnCNReq = addRequirement(uHostedOnCN,
					"uHostedOnCNReq");
			uHostedOnCNReq.setLinkType(RequirementLinkTypes.HOSTING_LITERAL);
			LinkFactory.createHostingLink(conceptualNode, uHostedOnCN);

			Unit realUnit = addUnit(top, "realUnit");
			Capability realUnitCap = addCapability(realUnit, "realUnitCap");
			assertMatchAndLinkInvalid(conceptualNode, realUnit, 2); // A.T.
																	// 4/11/07:
																	// there is
																	// also a
																	// hosting
																	// requirement
																	// error
			realUnitCap.setLinkType(CapabilityLinkTypes.HOSTING_LITERAL);
			assertMatchAndLinkValid(conceptualNode, realUnit);
		}

		//
		// Exercise code which recognizes existing cap->cap realization links
		// Is there a way to tell that the code is being hit?
		{
			top.getUnits().clear();
			top.getRealizationLinks().clear();
			unitCopy1 = copyUnit(unit1, top);
			top.getUnits().add(unitCopy1); // MK addition
			unitCopy2 = copyUnit(unit1, top);
			top.getUnits().add(unitCopy2); // MK addition
			Unit unitCopy3 = copyUnit(unit1, top);
			top.getUnits().add(unitCopy3); // MK addition
			unitCopy1.getCapabilities().add(c2);
			unitCopy2.getCapabilities().add(cc1);
			unitCopy3.getCapabilities().add(cc3);
			Capability extraCap1UnitCopy1 = addCapability(unitCopy1,
					"ExtraCap1UnitCopy1");
			Capability extraCap1UnitCopy2 = addCapability(unitCopy2,
					"ExtraCap1UnitCopy2");
			Capability extraCap1UnitCopy3 = addCapability(unitCopy3,
					"ExtraCap1UnitCopy3");
			assert (rlm.canCreateLink(unitCopy1, unitCopy2).isOK());
			RealizationLink unitLink = LinkFactory.createRealizationLink(
					unitCopy1, unitCopy2);
			RealizationLink capLink = LinkFactory.createRealizationLink(
					extraCap1UnitCopy1, extraCap1UnitCopy2);
			assertValidationErrorCount(unitCopy1, 0);
			assert (top.getRealizationLinks().remove(capLink) == true);
			capLink = LinkFactory.createRealizationLink(extraCap1UnitCopy1,
					extraCap1UnitCopy3);
			assertValidationErrorCount(unitCopy1, 1);
			HashSet<String> expectedVIDs = new HashSet<String>();
			expectedVIDs.add(IDeployCoreValidators.CAPABILITY_REALIZATION_002);
			ValidatorTestUtils.topologyValidatorIDsInSet(top, expectedVIDs);
		}
		// Attributes on imported topology - test public editable/public/private
		{
			top.getUnits().clear();
			top.getRealizationLinks().clear();
			top.getConstraints().clear();
			top.getArtifacts().clear();
			top.getDependencyLinks().clear();
			top.getUnitLinks().clear();
			
			unitCopy1 = copyUnit(unit1, top);
			top.getUnits().add(unitCopy1); 
			unitCopy2 = copyUnit(unit1, top);
			top.getUnits().add(unitCopy2);
			boolean cc1MutableOrg = cc1.isMutable();
			cc1.setMutable(true);
			unitCopy1.getCapabilities().clear();
			unitCopy1.getCapabilities().add(cc1);
			unitCopy2.getCapabilities().clear();
			unitCopy2.getCapabilities().add(cc2);
			
			ConfigurationContract ccOrg = top.getConfigurationContract();
			ExplicitContract ccTest = CoreFactory.eINSTANCE.createExplicitContract();
			ccTest.setDefaultConceptualPolicy(Visibility.PUBLIC_LITERAL);
			ccTest.setDefaultPolicy(Visibility.PUBLIC_LITERAL);
			top.setConfigurationContract(ccTest);
			save(top);
			
			Topology importingTop = createTopology("ImportingTop", true);
			importingTop.setDecoratorSemantic(IDecoratorSemanticConstants.DeploymentDS_ID);

			Import importTop = TopologyUtil.importTopology(top, importingTop);
			Topology resolvedImport = TopologyUtil.resolve(importTop);
			save(importingTop);
			assert(top.getUnits().size() == 2) : top.getUnits().size();
			assert(importingTop.getUnits().size() == 0) : importingTop.getUnits().size();
			
			List<Unit> proxiedUnits = new ArrayList();
			for (Iterator<Unit> unitIter = importingTop.findAllUnits(); unitIter.hasNext();) {
				proxiedUnits.add(unitIter.next());
			}
			assert proxiedUnits.size() == 2 : proxiedUnits.size();
			Unit pu1 = null;
			Unit pu2 = null;
			if (ValidatorUtils.getFirstCapability(proxiedUnits.get(0).getCapabilities(), CorePackage.eINSTANCE.getCommunicationCapability()) != null) {
				pu2 = proxiedUnits.get(0);
				pu1 = proxiedUnits.get(1);
			} 
			if (ValidatorUtils.getFirstCapability(proxiedUnits.get(1).getCapabilities(), CorePackage.eINSTANCE.getCommunicationCapability()) != null) { 
				pu2 = proxiedUnits.get(1);
				pu1 = proxiedUnits.get(0);
			}
			assert pu1 != null;
			assert pu2 != null;
			assert !((Capability)(pu1.getCapabilities().get(0))).isPublicEditable("port");
			assertNoMatch(pu1, pu2);
			ccTest.setDefaultPolicy(Visibility.PUBLIC_LITERAL);
			ccTest.setDefaultConceptualPolicy(Visibility.PUBLIC_LITERAL);
			ccTest.export(cc1, "port");
			save(top);
			assert(pu1.isPublic());
			assert pu1.getCapabilities().size() == 1;
			assert pu2.getCapabilities().size() == 1;
			assert ((Capability)(pu1.getCapabilities().get(0))).isPublicEditable("port");
			assert !((Capability)(pu2.getCapabilities().get(0))).isPublicEditable();
			assert !((Capability)(pu2.getCapabilities().get(0))).isPublicEditable("port");
			assert (pu1.isConceptual());
			assert (pu2.isConceptual());
			assertNoMatch(pu1, pu2);
			assertMatch(pu2, pu1);
			
			top.setConfigurationContract(ccOrg);
			cc1.setMutable(cc1MutableOrg);
		}
	}

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

	private static void eaTests(ExtendedAttribute ea1, ExtendedAttribute ea2,
			Unit u1, Unit u2, RealizationLinkMatcher rlm) {
		assert ((rlm.canCreateLink(u1, u2).isOK()));
		String ea1SavedName = ea1.getName();
		ea1.setName(ea1SavedName + "x");
		assert (!(rlm.canCreateLink(u1, u2).isOK()));
		ea1.setName(ea1SavedName);
		assert ((rlm.canCreateLink(u1, u2).isOK()));
		Object ea1SavedValue = ea1.getValue();
		ea1.setValue(new Integer(8));
		assert (!(rlm.canCreateLink(u1, u2).isOK()));
		ea1.setValue(ea1SavedValue);
		assert ((rlm.canCreateLink(u1, u2).isOK()));
		EDataType ea1SavedInstanceType = ea1.getInstanceType();
		ea1.setInstanceType(XMLTypePackage.Literals.BOOLEAN);
		assert (!(rlm.canCreateLink(u1, u2).isOK()));
		ea1.setInstanceType(ea1SavedInstanceType);
		assert ((rlm.canCreateLink(u1, u2).isOK()));
	}

	public void testRealizationLinkMatchingWithLinks() throws IOException,
			CoreException {
		// the following should probably be moved into hostTest1a(), and
		// hostTest 1b()
		// but until it breaks, I don't see a reason to do it.
		Topology top = createTopology("testRealizationLinkMatchingWithLinks");
		save(top);

		// Test source is hosted:
		// If unit C is hosted by unit D, then
		// FinalRealization(D) is not equal to FinalRealization(C); i.e., C is
		// not D; and
		// FinalRealization(C) is not in HostsR(D); i.e., D is not hosted on C;
		// and
		// HostsR(C) can contain at most one concrete unit; i.e., there is
		// at most one host.

		// successful case: Unit C hosted by physical D; try to realize C with
		// unhosted U
		Unit conceptualC0 = createConceptualUnit(top, "conceptualC0");
		Unit physicalD0 = createPhysicalUnit(top, "physicalD0");
		LinkFactory.createHostingLink(physicalD0, conceptualC0);
		Unit physicalU = createPhysicalUnit(top, "physicalU");
		assertMatchAndLinkValid(conceptualC0, physicalU);
		Unit conceptualU0 = createConceptualUnit(top, "conceptualU0");
		LinkFactory.createRealizationLink(conceptualU0, physicalU);// , top);
		assertMatchAndLinkValid(conceptualC0, conceptualU0);

		// successful case: Unit C hosted by conceptual D; try to realize C with
		// unhosted U
		Unit conceptualC1 = createConceptualUnit(top, "conceptualC1");
		Unit conceptualD1 = createConceptualUnit(top, "conceptualD1");
		LinkFactory.createHostingLink(conceptualD1, conceptualC1);
		assertMatchAndLinkValid(conceptualC1, physicalU);
		assertMatchAndLinkValid(conceptualC1, conceptualU0);

		// failure case: FinalRealization(D) is equal to FinalRealization(C)
		// (a) D is physical
		assertMatchAndLinkInvalid(conceptualC0, physicalD0);
		Unit conceptualD00 = createConceptualUnit(top, "conceptualD00");
		LinkFactory.createRealizationLink(conceptualD00, physicalD0);// ,
																		// top);
		assertMatchAndLinkInvalid(conceptualC0, conceptualD00);
		Unit conceptualDD00 = createConceptualUnit(top, "conceptualDD00");
		LinkFactory.createRealizationLink(conceptualDD00, conceptualD00);// ,
																			// top);
		assertMatchAndLinkInvalid(conceptualC0, conceptualDD00);
		// (b) D is conceptual
		assertMatchAndLinkInvalid(conceptualC1, conceptualD1);
		Unit conceptualD10 = createConceptualUnit(top, "conceptualD10");
		LinkFactory.createRealizationLink(conceptualD10, conceptualD1);// ,
																		// top);
		assertMatchAndLinkInvalid(conceptualC1, conceptualD10);
		Unit conceptualDD10 = createConceptualUnit(top, "conceptualDD10");
		LinkFactory.createRealizationLink(conceptualDD10, conceptualD10);// ,
																			// top);
		assertMatchAndLinkInvalid(conceptualC1, conceptualDD10);

		// failure case: FinalRealization(C) is not in HostsR(D); i.e., D is not
		// hosted on C
		// (a) D is physical
		HostingLink pUHostspD0 = LinkFactory.createHostingLink(physicalU,
				physicalD0);
		assertMatchAndLinkInvalid(conceptualC0, physicalU);
		HostingLink cU0HostspD0 = LinkFactory.createHostingLink(conceptualU0,
				physicalD0);
		LinkFactory.createRealizationLink(conceptualU0, physicalU);// , top);
		assertMatchAndLinkInvalid(conceptualC0, conceptualU0);
		// (b) D is conceptual
		LinkFactory.createHostingLink(physicalU, conceptualD1);
		assertMatchAndLinkInvalid(conceptualC1, physicalU);
		assertMatchAndLinkInvalid(conceptualC1, conceptualU0);
		// undo the problem we created
		physicalU.getHostingLinks().remove(pUHostspD0);
		conceptualU0.getHostingLinks().remove(cU0HostspD0);

		// failure case: HostsR(C) can contain at most one concrete unit;
		// i.e., there is at most one host.
		hostTest3a();
		hostTest3b();

		// failure case: FinalRealization(D) is not equal to
		// FinalRealization(C); i.e., C is not D
		hosteeTest1a();
		// failure case: FinalRealization(D) is not in HostsR(C); i.e., C is not
		// hosted on D
		hosteeTest2a();
		// failure case: HostsR(D) can contain at most one concrete unit;
		// i.e., C is hosted by at most 1 unit
		hosteeTest3a();

		targetTest1a();
		
		stereotypeUnitTest();
		stereotypeCapTest();
	}

	private void hostTest3a() throws IOException, CoreException {
		Topology t = createTopology("hostTest3a");
		// conceptual C hosted on physical D
		// physical U hosted on physical H
		// realize C with U shouldn't(v8m5) fail (two physical hosts)
		Unit conceptualC = createConceptualUnit(t, "conceptualC");
		Unit physicalD = createPhysicalUnit(t, "physicalD");
		addCapability(physicalD, "physicalDCap",
				CapabilityLinkTypes.HOSTING_LITERAL);
		addRequirement(conceptualC, "conceptualCReq",
				RequirementLinkTypes.HOSTING_LITERAL);
		LinkFactory.createHostingLink(physicalD, conceptualC);
		Unit physicalU = createPhysicalUnit(t, "physicalU");
		Unit physicalH = createPhysicalUnit(t, "physicalH");
		addCapability(physicalH, "physicalHCap",
				CapabilityLinkTypes.HOSTING_LITERAL);
		addRequirement(physicalU, "physicalUReq",
				RequirementLinkTypes.HOSTING_LITERAL);
		LinkFactory.createHostingLink(physicalH, physicalU);
		assertMatchAndLinkValid(conceptualC, physicalU);

		// conceptual C hosted on physical D
		// physical U hosted on physical H
		// conceptual U realized by physical U
		// realize C with conceptual U shouldn't(v8m5) fail (two physical hosts)
		Unit conceptualU = createConceptualUnit(t, "conceptualU");
		addRequirement(conceptualU, "conceptualUReq",
				RequirementLinkTypes.HOSTING_LITERAL);
		LinkFactory.createRealizationLink(conceptualU, physicalU);// , t);
		assertMatchAndLinkValid(conceptualC, conceptualU);
	}

	private void hostTest3b() throws IOException, CoreException {
		Topology t = createTopology("hostTest3b");
		// conceptual C hosted on conceptual D
		// physical U hosted on physical H
		// realize C with U should succeed (one physical hosts)
		Unit conceptualC = createConceptualUnit(t, "conceptualC");
		Unit conceptualD = createConceptualUnit(t, "conceptualD");
		LinkFactory.createHostingLink(conceptualD, conceptualC);
		Unit physicalU = createPhysicalUnit(t, "physicalU");
		Unit physicalH = createPhysicalUnit(t, "physicalH");
		LinkFactory.createHostingLink(physicalH, physicalU);
		assertMatchAndLinkValid(conceptualC, physicalU);

		// conceptual C hosted on conceptual D
		// physical U hosted on physical H
		// conceptual U realized by physical U
		// realize C with conceptual U should succeed (one physical hosts)
		Unit conceptualU = createConceptualUnit(t, "conceptualU");
		LinkFactory.createRealizationLink(conceptualU, physicalU);// , t);
		assertMatchAndLinkValid(conceptualC, conceptualU);

		// as above but add conceptual D hosted on physical D
		// realize C with conceptual (or physical U) should still succeed
		// even though there are 2 physical hosts. One is two levels away and
		// will only be caught when trying to realize conceptual D
		Unit physicalD = createPhysicalUnit(t, "physicalD");
		LinkFactory.createHostingLink(physicalD, conceptualD);
		assertMatchAndLinkValid(conceptualC, conceptualU);
		assertMatchAndLinkValid(conceptualC, physicalU);

		// as above but with conceptualD realized by physicalE
		// realize C with either U shouldn't (v8m5) fail (two physical hosts)
		Unit physicalE = createPhysicalUnit(t, "physicalE");
		LinkFactory.createRealizationLink(conceptualD, physicalE);// , t);
//		System.out.println ("Starting first failure case");
		assertMatchAndLinkValid(conceptualC, conceptualU);
//		System.out.println ("Starting second failure case");
		assertMatchAndLinkValid(conceptualC, physicalU);
//		System.out.println ("Ending second failure case");
	}

// For all units D such that C hosts unit D, then
// HostsR(D) can contain at most one concrete unit; i.e., C is hosted by
// at most 1 unit.

	/*
	 * Test failure condition: FinalRealization(D) is not equal to
	 * FinalRealization(C); i.e., C is not D
	 */
	private void hosteeTest1a() throws IOException, CoreException {
		Topology t = createTopology("hosteeTest1a");
		// conceptual C hosts conceptual D
		// try to realize C with D --> error
		Unit conceptualC = createConceptualUnit(t, "conceptualC");
		Unit conceptualD = createConceptualUnit(t, "conceptualD");
		assertMatchAndLinkValid(conceptualC, conceptualD);
		addCapability(conceptualC, "conceptualCCap",
				CapabilityLinkTypes.HOSTING_LITERAL);
		addRequirement(conceptualD, "conceptualDReq",
				RequirementLinkTypes.HOSTING_LITERAL);
		addCapability(conceptualD, "conceptualDCap",
				CapabilityLinkTypes.HOSTING_LITERAL);
		LinkFactory.createHostingLink(conceptualC, conceptualD);
		assertMatchAndLinkInvalid(conceptualC, conceptualD);

		// let D by realized by physical U
		// try to realize C by D --> error because C is realized by its hostee
		Unit physicalU = createPhysicalUnit(t, "physicalU");
		addCapability(physicalU, "physicalUCap",
				CapabilityLinkTypes.HOSTING_LITERAL);
		LinkFactory.createRealizationLink(conceptualD, physicalU);// , t);
		assertMatchAndLinkInvalid(conceptualC, physicalU);

		Unit conceptualU = createConceptualUnit(t, "conceptualU");
		addCapability(conceptualU, "conceptualUCap",
				CapabilityLinkTypes.HOSTING_LITERAL);
		LinkFactory.createRealizationLink(conceptualU, physicalU);// , t);
		assertMatchAndLinkInvalid(conceptualC, conceptualU);
	}

	/**
	 * Test failure condition: FinalRealization(D) is not in HostsR(C); i.e., C
	 * is not hosted on D
	 * 
	 * @throws IOException
	 * @throws CoreException
	 */
	private void hosteeTest2a() throws IOException, CoreException {
		Topology t = createTopology("hosteeTest2a");
		Unit conceptualC = createConceptualUnit(t, "conceptualC");
		Unit conceptualD = createConceptualUnit(t, "conceptualD");
		addCapability(conceptualC, "conceptualCCap",
				CapabilityLinkTypes.HOSTING_LITERAL);
		addRequirement(conceptualD, "conceptualDReq",
				RequirementLinkTypes.HOSTING_LITERAL);
		LinkFactory.createHostingLink(conceptualC, conceptualD);
		Unit conceptualH = createConceptualUnit(t, "conceptualH");
		addCapability(conceptualH, "conceptualHCap",
				CapabilityLinkTypes.HOSTING_LITERAL);
		addRequirement(conceptualC, "conceptualCReq",
				RequirementLinkTypes.HOSTING_LITERAL);
		LinkFactory.createHostingLink(conceptualH, conceptualC);
		Unit physicalU = createPhysicalUnit(t, "physicalU");
		addCapability(physicalU, "physicalUCap",
				CapabilityLinkTypes.HOSTING_LITERAL);
		addRequirement(physicalU, "physicalUReq",
				RequirementLinkTypes.HOSTING_LITERAL);

		RealizationLink r = LinkFactory.createRealizationLink(conceptualD,
				conceptualH);// , t);
		assertMatchAndLinkInvalid(conceptualC, physicalU);

		Unit physicalH = createPhysicalUnit(t, "physicalH");
		LinkFactory.createHostingLink(physicalH, physicalU);

		t.getRealizationLinks().remove(r);
		LinkFactory.createRealizationLink(conceptualD, physicalH);// , t);
		assertMatchAndLinkInvalid(conceptualC, physicalU);
	}

	/**
	 * Test failure condition: HostsR(D) can contain at most one concrete
	 * unit; i.e., C is hosted by at most 1 unit.
	 * 
	 * @throws IOException
	 * @throws CoreException
	 */
	private void hosteeTest3a() throws IOException, CoreException {
		Topology t = createTopology("hosteeTest3a");

		// conceptual D hosted on conceptual C
		// can realize C with physical U
		Unit conceptualC = createConceptualUnit(t, "conceptualC");
		Unit conceptualD = createConceptualUnit(t, "conceptualD");
		addCapability(conceptualC, "conceptualCCap",
				CapabilityLinkTypes.HOSTING_LITERAL);
		addRequirement(conceptualD, "conceptualDReq",
				RequirementLinkTypes.HOSTING_LITERAL);
		LinkFactory.createHostingLink(conceptualC, conceptualD);
		Unit physicalU = createPhysicalUnit(t, "physicalU");
		addCapability(physicalU, "physicalUCap",
				CapabilityLinkTypes.HOSTING_LITERAL);
		assertMatchAndLinkValid(conceptualC, physicalU);

		// add conceptual U realized by physical U
		// can realize C with either U
		Unit conceptualU = createConceptualUnit(t, "conceptualU");
		addCapability(conceptualU, "conceptualUCap",
				CapabilityLinkTypes.HOSTING_LITERAL);
		LinkFactory.createRealizationLink(conceptualU, physicalU);// , t);
		assertMatchAndLinkValid(conceptualC, conceptualU);
		assertMatchAndLinkValid(conceptualC, physicalU);

		// realize D with conceptual E
		// still able to realize C with either U
		Unit conceptualE = createConceptualUnit(t, "conceptualE");
		addRequirement(conceptualE, "conceptualEReq",
				RequirementLinkTypes.HOSTING_LITERAL);
		LinkFactory.createRealizationLink(conceptualD, conceptualE);// , t);
		assertMatchAndLinkValid(conceptualC, conceptualU);
		assertMatchAndLinkValid(conceptualC, physicalU);

		// host E on conceptual U
		// still can realize C with either U
		LinkFactory.createHostingLink(conceptualU, conceptualE);
		assertMatchAndLinkValid(conceptualC, conceptualU);
		assertMatchAndLinkValid(conceptualC, physicalU);

		// realize E with F; host F on physical V
		// now physical U and physical V are both in HostsR(C) --> error
		Unit conceptualF = createConceptualUnit(t, "conceptualF");
		Unit physicalV = createPhysicalUnit(t, "physicalV");
		LinkFactory.createHostingLink(physicalV, conceptualF);
		LinkFactory.createRealizationLink(conceptualE, conceptualF);// , t);
		assertMatchAndLinkValid(conceptualC, conceptualU);
		assertMatchAndLinkValid(conceptualC, physicalU);
	}

	/**
	 * Test failure case: For every requirement r on C such that r.getLink() is
	 * not empty, then TargetsR(r) can contain at most one capability on a
	 * concrete unit
	 * 
	 * @throws IOException
	 * @throws CoreException
	 */
	private void targetTest1a()  throws IOException, CoreException {
		Topology t = createTopology("targetTest1a");

		// conceptual D hosted on conceptual C
		// can realize C with physical U
		Unit conceptualC = createConceptualUnit(t, "conceptualC");
		Requirement cr = addRequirement(conceptualC, "req");
		Unit conceptualD = createConceptualUnit(t, "conceptualD");
		Capability dc = addCapability(conceptualD, "cap");
		LinkFactory.createDependencyLink(conceptualC, cr, conceptualD, dc);
		Unit physicalU = createPhysicalUnit(t, "physicalU");
		// for C to realize U, U must also have a requirement
		Requirement ur = addRequirement(physicalU, "req");
		assertMatchAndLinkValid(conceptualC, physicalU);

		Unit conceptualE = createConceptualUnit(t, "conceptualE");
		Capability ec = addCapability(conceptualE, "cap");
		LinkFactory.createDependencyLink(physicalU, ur, conceptualE, ec);
		assertMatchAndLinkValid(conceptualC, physicalU);

		Unit physicalF = createPhysicalUnit(t, "physicalF");
		LinkFactory.createRealizationLink(conceptualD, physicalF);// , t);
		Requirement dr = addRequirement(conceptualD, "req");
		Requirement fr = addRequirement(physicalF, "req");
		LinkFactory.createRealizationLink(dr, fr);// , t);
		assertMatchAndLinkValid(conceptualC, physicalU);

	}
	
	private void stereotypeUnitTest() throws IOException, CoreException 
	{
		Topology t = createTopology("stereotypeUnitTest");
		// Unit a and Unit b have same stereotypes
		Unit unitA = createConceptualUnit(t, "unitA");
		Unit unitB = createConceptualUnit(t, "unitB");
		
		// Units have same stereotype keyword
		Stereotype st1 = CoreFactory.eINSTANCE.createStereotype();
		st1.setKeyword("foo");
		st1.setRequired(true);
		unitA.getStereotypes().add( st1 );
		
		Stereotype st2 = CoreFactory.eINSTANCE.createStereotype();
		st2.setKeyword("foo");
		st2.setRequired(true);
		unitB.getStereotypes().add( st2 );
		
		assertMatchAndLinkValid(unitA, unitB);
		
		// Units have different stereotype keyword
		Unit unitC = createConceptualUnit(t, "unitC");
		Unit unitD = createConceptualUnit(t, "unitD");
		Stereotype st3 = CoreFactory.eINSTANCE.createStereotype();
		st3.setKeyword("bob");
		st3.setRequired(true);
		unitC.getStereotypes().add( st3 );
		
		Stereotype st4 = CoreFactory.eINSTANCE.createStereotype();
		st4.setKeyword("dole");
		st4.setRequired(true);
		unitD.getStereotypes().add( st4 );
		
		assertLinkValidationErrorCount(unitC, unitD, 1);
		
		// Ensure non-required stereotypes are NOT validated
		Unit unitE = createConceptualUnit(t, "unitE");
		Unit unitF = createConceptualUnit(t, "unitF");		
		
		Stereotype st5 = CoreFactory.eINSTANCE.createStereotype();
		st5.setKeyword("bob");
		st5.setRequired(false);
		unitE.getStereotypes().add( st5 );
		
		Stereotype st6 = CoreFactory.eINSTANCE.createStereotype();
		st6.setKeyword("dole");
		st6.setRequired(false);
		unitF.getStereotypes().add( st6 );
		
		assertMatchAndLinkValid(unitE, unitF); 

	}
	
	private void stereotypeCapTest() throws IOException, CoreException 
	{
		Topology t = createTopology("stereotypeCapTest");
		Unit unitA = createConceptualUnit(t, "unitA");
		Unit unitB = createConceptualUnit(t, "unitB");
		Capability capA = addCapability(unitA, "CapA");
		Capability capB = addCapability(unitB, "CapB");
		
		// Caps have same stereotype keyword
		Stereotype st1 = CoreFactory.eINSTANCE.createStereotype();
		st1.setKeyword("foo");
		st1.setRequired(true);
		capA.getStereotypes().add(st1);
		
		Stereotype st2 = CoreFactory.eINSTANCE.createStereotype();
		st2.setKeyword("foo");
		st2.setRequired(true);
		capB.getStereotypes().add( st2 );
		
		assertMatchAndLinkValid(unitA, unitB);
		
		// Units with caps having different stereotypes
		Unit unitC = createConceptualUnit(t, "unitC");
		Unit unitD = createConceptualUnit(t, "unitD");
		Capability capC = addCapability(unitC, "CapC");
		Capability capD = addCapability(unitD, "CapD");
		
		// Caps have same stereotype keyword
		Stereotype st3 = CoreFactory.eINSTANCE.createStereotype();
		st3.setKeyword("bob");
		st3.setRequired(true);
		capC.getStereotypes().add(st3);
		
		Stereotype st4 = CoreFactory.eINSTANCE.createStereotype();
		st4.setKeyword("dole");
		st4.setRequired(true);
		capD.getStereotypes().add( st4 );

		// General cap-level mismatch error plus stereotype error = 2
		// REALIZATION_LINK_005 and REALIZATION_LINK_013
		assertLinkValidationErrorCount(unitC, unitD, 2);
		

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

	private void assertMatch(Unit u1, Unit u2) throws IOException {
		save(u1.getEditTopology());
		assert ((rlm.canCreateLink(u1, u2).isOK())) : rlm.canCreateLink(u1, u2)
				.getMessage();
	}

	private void assertValidationErrorCount(Unit u1,
			int expectedValidationErrorCount) throws IOException, CoreException {

		save(u1.getEditTopology());
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
		save(u1.getEditTopology());
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

	private void assertMatchAndLinkValid(Unit u1, Unit u2) throws IOException,
			CoreException {
		assertMatch(u1, u2);
		assertLinkValidationErrorCount(u1, u2, 0);
	}

	private void assertNoMatch(Unit u1, Unit u2) throws IOException {
		save(u1.getEditTopology());
		IStatus status = rlm.canCreateLink(u1, u2);
		assert (!(status.isOK())) : status.getMessage();
		assert (!status.equals(DeployMatcherStatus.MATCH_NOT_FOUND));
	}

	private void assertMatchAndLinkInvalid(Unit u1, Unit u2,
			int expectedValidationErrorCount) throws IOException, CoreException {
		assertNoMatch(u1, u2);
		assertLinkValidationErrorCount(u1, u2, expectedValidationErrorCount);
	}

	private void assertMatchAndLinkInvalid(Unit u1, Unit u2)
			throws IOException, CoreException {
		assertMatchAndLinkInvalid(u1, u2, 1);
	}

}
