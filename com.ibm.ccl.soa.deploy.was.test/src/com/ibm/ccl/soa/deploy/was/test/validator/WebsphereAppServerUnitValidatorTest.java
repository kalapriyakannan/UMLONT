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
import com.ibm.ccl.soa.deploy.core.validator.matcher.LinkDescriptor;
import com.ibm.ccl.soa.deploy.core.validator.matcher.LinkType;
import com.ibm.ccl.soa.deploy.db2.DB2CatalogUnit;
import com.ibm.ccl.soa.deploy.j2ee.EJBContainer;
import com.ibm.ccl.soa.deploy.j2ee.EJBContainerVersion;
import com.ibm.ccl.soa.deploy.j2ee.J2EEContainer;
import com.ibm.ccl.soa.deploy.j2ee.J2EEContainerVersion;
import com.ibm.ccl.soa.deploy.j2ee.J2eeFactory;
import com.ibm.ccl.soa.deploy.j2ee.JSPContainer;
import com.ibm.ccl.soa.deploy.j2ee.JSPContainerVersion;
import com.ibm.ccl.soa.deploy.j2ee.ServletContainer;
import com.ibm.ccl.soa.deploy.j2ee.ServletContainerVersion;
import com.ibm.ccl.soa.deploy.os.OsFactory;
import com.ibm.ccl.soa.deploy.os.PortConsumer;
import com.ibm.ccl.soa.deploy.was.WasConfigurationContainer;
import com.ibm.ccl.soa.deploy.was.WasFactory;
import com.ibm.ccl.soa.deploy.was.WasNodeUnit;
import com.ibm.ccl.soa.deploy.was.WasPackage;
import com.ibm.ccl.soa.deploy.was.WasServer;
import com.ibm.ccl.soa.deploy.was.WasSharedLibContainer;
import com.ibm.ccl.soa.deploy.was.WasSubstitutionVariable;
import com.ibm.ccl.soa.deploy.was.WebsphereAppServerUnit;
import com.ibm.ccl.soa.deploy.was.internal.validator.WebsphereAppServerUnitValidator;

/**
 * Tests {@link DB2CatalogUnit}.
 * 
 * @author barnold
 */
public class WebsphereAppServerUnitValidatorTest extends TopologyTestCase {

	private static final String PROJECT_NAME = "WebsphereAppServerUnitValidatorTest"; //$NON-NLS-1$

	/**
	 * 
	 */
	public WebsphereAppServerUnitValidatorTest() {
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
	public void testWebsphereAppServerUnitValidator() throws IOException,
			CoreException {

		Topology top = createTopology(
				"WebsphereAppServerUnitValidatorTest", true); //$NON-NLS-1$

		IDeployValidationContext context = createValidationContext(top);
		IDeployReporter reporter = createDeployReporter();
		WebsphereAppServerUnitValidator validator = new WebsphereAppServerUnitValidator();

		//
		// WebsphereAppServer unit
		//
		WebsphereAppServerUnit websphereAppServerUnit = WasFactory.eINSTANCE
				.createWebsphereAppServerUnit();
		websphereAppServerUnit.setName("websphereAppServerUnit"); //$NON-NLS-1$
		websphereAppServerUnit.setDisplayName("websphereAppServerUnit"); //$NON-NLS-1$		
		top.getUnits().add(websphereAppServerUnit);

		// provide a wasServer capability
		WasServer wasServer = WasFactory.eINSTANCE.createWasServer();
		wasServer.setName("providedWASServer"); //$NON-NLS-1$
		wasServer.setDisplayName("providedWASServer"); //$NON-NLS-1$
		wasServer.setWasVersion("6.0.0.1"); //$NON-NLS-1$
		wasServer.setServerName("server1");
		wasServer.setLinkType(CapabilityLinkTypes.ANY_LITERAL);
		websphereAppServerUnit.getCapabilities().add(wasServer);

		// provide a j2eeContainer capability
		J2EEContainer j2eeContainer = J2eeFactory.eINSTANCE
				.createJ2EEContainer();
		j2eeContainer.setName("j2eeContainer");
		j2eeContainer.setDisplayName("j2eeContainer");
		j2eeContainer.setLinkType(CapabilityLinkTypes.ANY_LITERAL);
		j2eeContainer.setContainerVersion(J2EEContainerVersion._12_LITERAL);
		websphereAppServerUnit.getCapabilities().add(j2eeContainer);

		// provide a jspContainer capability
		JSPContainer jspContainer = J2eeFactory.eINSTANCE.createJSPContainer();
		jspContainer.setName("jspContainer");
		jspContainer.setDisplayName("jspContainer");
		jspContainer.setLinkType(CapabilityLinkTypes.ANY_LITERAL);
		jspContainer.setContainerVersion(JSPContainerVersion._11_LITERAL);
		websphereAppServerUnit.getCapabilities().add(jspContainer);

		// provide a servletContainer capability
		ServletContainer servletContainer = J2eeFactory.eINSTANCE
				.createServletContainer();
		servletContainer.setName("servletContainer");
		servletContainer.setDisplayName("servletContainer");
		servletContainer.setLinkType(CapabilityLinkTypes.ANY_LITERAL);
		servletContainer
				.setContainerVersion(ServletContainerVersion._22_LITERAL);
		websphereAppServerUnit.getCapabilities().add(servletContainer);

		// provide a ejbContainer capability
		EJBContainer ejbContainer = J2eeFactory.eINSTANCE.createEJBContainer();
		ejbContainer.setName("ejbContainer");
		ejbContainer.setDisplayName("ejbContainer");
		ejbContainer.setLinkType(CapabilityLinkTypes.ANY_LITERAL);
		ejbContainer.setContainerVersion(EJBContainerVersion._11_LITERAL);
		websphereAppServerUnit.getCapabilities().add(ejbContainer);

		// provide a wasConfigurationContainer capability
		WasConfigurationContainer wasConfigurationContainer = WasFactory.eINSTANCE
				.createWasConfigurationContainer();
		wasConfigurationContainer.setName("wasConfigurationContainer");
		wasConfigurationContainer.setDisplayName("wasConfigurationContainer");
		wasConfigurationContainer.setLinkType(CapabilityLinkTypes.ANY_LITERAL);
		websphereAppServerUnit.getCapabilities().add(wasConfigurationContainer);

		// provide a wasSharedLibContainer capability
		WasSharedLibContainer wasSharedLibContainer = WasFactory.eINSTANCE
				.createWasSharedLibContainer();
		wasSharedLibContainer.setName("wasSharedLibContainer");
		wasSharedLibContainer.setDisplayName("wasSharedLibContainer");
		wasSharedLibContainer.setLinkType(CapabilityLinkTypes.ANY_LITERAL);
		websphereAppServerUnit.getCapabilities().add(wasSharedLibContainer);

		// provide a portConsumer capability
		PortConsumer portConsumer = OsFactory.eINSTANCE.createPortConsumer();
		portConsumer.setName("portConsumer");
		portConsumer.setDisplayName("portConsumer");
		portConsumer.setLinkType(CapabilityLinkTypes.ANY_LITERAL);
		websphereAppServerUnit.getCapabilities().add(portConsumer);

		// provider a substitutionVaraible capbality
		WasSubstitutionVariable variableCap = WasFactory.eINSTANCE
				.createWasSubstitutionVariable();
		variableCap.setName("substitutionVariableCap");//$NON-NLS-1$
		variableCap.setDisplayName("substitutionVariable_Capability");//$NON-NLS-1$
		variableCap.setLinkType(CapabilityLinkTypes.ANY_LITERAL);
		websphereAppServerUnit.getCapabilities().add(variableCap);

		// MK 11/21/2006 changed membership to hosting
		// Requirement requiredWasNodeUnit =
		// ValidatorTestUtils.createMemberRequirement(WasPackage.Literals.WAS_NODE_UNIT,
		// "requiredWasNodeUnit");
		Requirement requiredWasNodeUnit = ValidatorTestUtils
				.createHostingRequirement(WasPackage.Literals.WAS_NODE,
						"requiredWasNodeUnit");
		websphereAppServerUnit.getRequirements().add(requiredWasNodeUnit);

		WasNodeUnit wasNodeUnit = WasFactory.eINSTANCE.createWasNodeUnit();
		wasNodeUnit.setName("wasNodeUnit");
		wasNodeUnit.setDisplayName("wasNodeUnit");
		top.getUnits().add(wasNodeUnit);

		// MK 11/21/2006 changed membership to hosting
		// member link between WASServer and WasNodeUnit
		// MemberLink serverNodeMemberLink =
		// CoreFactory.eINSTANCE.createMemberLink();
		// serverNodeMemberLink.setTarget(websphereAppServerUnit);
		// serverNodeMemberLink.setSource(wasNodeUnit);
		// ValidatorTestUtils.createLinkName(serverNodeMemberLink);
		// wasNodeUnit.getMemberLinks().add(serverNodeMemberLink);

		// hosting link between websphereAppServerUnit and wasNodeUnit
		LinkDescriptor ld = new LinkDescriptor(LinkType.HOSTING, wasNodeUnit,
				websphereAppServerUnit);
		ld.create();

		// /////////////////
		Resource res = top.getEObject().eResource();
		res.save(null);
		// /////////////////

		validator.validate(websphereAppServerUnit, context, reporter);
		System.out.println("In " + this.getClass()); //$NON-NLS-1$
		dumpMarkers(top);

		ValidatorTestUtils.assertValidationErrorCount(0, top,
				websphereAppServerUnit, context, reporter, validator);
		// assert instanceUnit.getStatus().getSeverity() != IStatus.OK;

		String savedWasVersion = wasServer.getWasVersion();
		wasServer.setWasVersion("t.7");
		ValidatorTestUtils.assertValidationErrorCount(1, top,
				websphereAppServerUnit, context, reporter, validator);
		wasServer.setWasVersion(savedWasVersion);
		ValidatorTestUtils.assertValidationErrorCount(0, top,
				websphereAppServerUnit, context, reporter, validator);

		j2eeContainer.setContainerVersion(J2EEContainerVersion._13_LITERAL);
		ValidatorTestUtils.assertValidationErrorCount(0, top,
				websphereAppServerUnit, context, reporter, validator);
		j2eeContainer.setContainerVersion(J2EEContainerVersion._14_LITERAL);
		ValidatorTestUtils.assertValidationErrorCount(0, top,
				websphereAppServerUnit, context, reporter, validator);

		// J2EE 1.4 tests
		{
			j2eeContainer.setContainerVersion(J2EEContainerVersion._14_LITERAL);

			JSPContainerVersion savedJspContainerVersion = jspContainer
					.getContainerVersion();
			jspContainer.setContainerVersion(JSPContainerVersion._21_LITERAL);
			ValidatorTestUtils.assertValidationErrorCount(1, top,
					websphereAppServerUnit, context, reporter, validator);
			jspContainer.setContainerVersion(savedJspContainerVersion);
			ValidatorTestUtils.assertValidationErrorCount(0, top,
					websphereAppServerUnit, context, reporter, validator);

			ServletContainerVersion savedServletContainerVersion = servletContainer
					.getContainerVersion();
			servletContainer
					.setContainerVersion(ServletContainerVersion._25_LITERAL);
			ValidatorTestUtils.assertValidationErrorCount(1, top,
					websphereAppServerUnit, context, reporter, validator);
			servletContainer.setContainerVersion(savedServletContainerVersion);
			ValidatorTestUtils.assertValidationErrorCount(0, top,
					websphereAppServerUnit, context, reporter, validator);

			EJBContainerVersion savedEJBContainerVersion = ejbContainer
					.getContainerVersion();
			ejbContainer.setContainerVersion(EJBContainerVersion._30_LITERAL);
			ValidatorTestUtils.assertValidationErrorCount(1, top,
					websphereAppServerUnit, context, reporter, validator);
			ejbContainer.setContainerVersion(savedEJBContainerVersion);
			ValidatorTestUtils.assertValidationErrorCount(0, top,
					websphereAppServerUnit, context, reporter, validator);
		}

		// J2EE 1.3 tests
		{
			wasServer.setWasVersion("5.1");
			j2eeContainer.setContainerVersion(J2EEContainerVersion._13_LITERAL);

			JSPContainerVersion savedJspContainerVersion = jspContainer
					.getContainerVersion();
			jspContainer.setContainerVersion(JSPContainerVersion._20_LITERAL);
			ValidatorTestUtils.assertValidationErrorCount(1, top,
					websphereAppServerUnit, context, reporter, validator);
			jspContainer.setContainerVersion(savedJspContainerVersion);
			ValidatorTestUtils.assertValidationErrorCount(0, top,
					websphereAppServerUnit, context, reporter, validator);

			ServletContainerVersion savedServletContainerVersion = servletContainer
					.getContainerVersion();
			servletContainer
					.setContainerVersion(ServletContainerVersion._24_LITERAL);
			ValidatorTestUtils.assertValidationErrorCount(1, top,
					websphereAppServerUnit, context, reporter, validator);
			servletContainer.setContainerVersion(savedServletContainerVersion);
			ValidatorTestUtils.assertValidationErrorCount(0, top,
					websphereAppServerUnit, context, reporter, validator);

			EJBContainerVersion savedEJBContainerVersion = ejbContainer
					.getContainerVersion();
			ejbContainer.setContainerVersion(EJBContainerVersion._21_LITERAL);
			ValidatorTestUtils.assertValidationErrorCount(1, top,
					websphereAppServerUnit, context, reporter, validator);
			ejbContainer.setContainerVersion(savedEJBContainerVersion);
			ValidatorTestUtils.assertValidationErrorCount(0, top,
					websphereAppServerUnit, context, reporter, validator);
		}

	}
}
