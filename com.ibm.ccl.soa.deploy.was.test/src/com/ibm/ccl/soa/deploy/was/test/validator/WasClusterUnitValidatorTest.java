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
import com.ibm.ccl.soa.deploy.core.CoreFactory;
import com.ibm.ccl.soa.deploy.core.HostingLink;
import com.ibm.ccl.soa.deploy.core.MemberLink;
import com.ibm.ccl.soa.deploy.core.Requirement;
import com.ibm.ccl.soa.deploy.core.Topology;
import com.ibm.ccl.soa.deploy.core.test.TopologyTestCase;
import com.ibm.ccl.soa.deploy.core.test.validator.utils.ValidatorTestUtils;
import com.ibm.ccl.soa.deploy.core.validator.IDeployReporter;
import com.ibm.ccl.soa.deploy.core.validator.IDeployValidationContext;
import com.ibm.ccl.soa.deploy.core.validator.matcher.LinkFactory;
import com.ibm.ccl.soa.deploy.j2ee.EJBContainer;
import com.ibm.ccl.soa.deploy.j2ee.EJBContainerVersion;
import com.ibm.ccl.soa.deploy.j2ee.J2EEContainer;
import com.ibm.ccl.soa.deploy.j2ee.J2EEContainerVersion;
import com.ibm.ccl.soa.deploy.j2ee.J2eeFactory;
import com.ibm.ccl.soa.deploy.j2ee.JCAContainer;
import com.ibm.ccl.soa.deploy.j2ee.JSPContainer;
import com.ibm.ccl.soa.deploy.j2ee.JSPContainerVersion;
import com.ibm.ccl.soa.deploy.j2ee.ServletContainer;
import com.ibm.ccl.soa.deploy.j2ee.ServletContainerVersion;
import com.ibm.ccl.soa.deploy.was.WasCell;
import com.ibm.ccl.soa.deploy.was.WasCellUnit;
import com.ibm.ccl.soa.deploy.was.WasCluster;
import com.ibm.ccl.soa.deploy.was.WasClusterUnit;
import com.ibm.ccl.soa.deploy.was.WasConfigurationContainer;
import com.ibm.ccl.soa.deploy.was.WasFactory;
import com.ibm.ccl.soa.deploy.was.WasPackage;
import com.ibm.ccl.soa.deploy.was.WasSubstitutionVariable;
import com.ibm.ccl.soa.deploy.was.WebsphereAppServerUnit;
import com.ibm.ccl.soa.deploy.was.internal.validator.WasGenericClusterUnitValidator;

/**
 * Tests {@link WasGenericClusterUnitValidator}
 * 
 * @since 3.2
 * 
 */
public class WasClusterUnitValidatorTest extends TopologyTestCase {
	private static final String PROJECT_NAME = "WasClusterUnitValidatorTest"; //$NON-NLS-1$

	/**
	 * 
	 * 
	 */
	public WasClusterUnitValidatorTest() {
		super(PROJECT_NAME);
	}

	/*
	 * @see junit.framework.TestCase#tearDown() Uncomment to stop deletion of
	 *      plants topology after test run.
	 */
	protected void tearDown() throws Exception {
	}

	/**
	 * 
	 * @throws IOException
	 * @throws CoreException
	 */
	public void testWasClusterUnitValidator() throws IOException, CoreException {
		Topology top = createTopology("WasClusterUnitValidatorTest", true); //$NON-NLS-1$
		IDeployValidationContext context = createValidationContext(top);
		IDeployReporter reporter = createDeployReporter();
		WasGenericClusterUnitValidator validator = new WasGenericClusterUnitValidator();

		//
		// add wasClusterUnit
		//
		WasClusterUnit wasClusterUnit = WasFactory.eINSTANCE
				.createWasClusterUnit();
		wasClusterUnit.setName("wasClusterUnit"); //$NON-NLS-1$
		wasClusterUnit.setDisplayName("wasClusterUnit"); //$NON-NLS-1$		
		top.getUnits().add(wasClusterUnit);

		// provide a wasCluster service
		WasCluster wasCluster = WasFactory.eINSTANCE.createWasCluster();
		wasCluster.setName("providedWASCluster"); //$NON-NLS-1$
		wasCluster.setDisplayName("providedWASCluster"); //$NON-NLS-1$
		wasCluster.setClusterName("cluster1");//$NON-NLS-1$
		wasCluster.setWasVersion("6.0.0.1");//$NON-NLS-1$
		wasCluster.setLinkType(CapabilityLinkTypes.ANY_LITERAL);
		wasClusterUnit.getCapabilities().add(wasCluster);

		J2EEContainer j2eeContainer = J2eeFactory.eINSTANCE
				.createJ2EEContainer();
		j2eeContainer.setName("j2eeContainer");//$NON-NLS-1$
		j2eeContainer.setDisplayName("j2eeContainer");//$NON-NLS-1$	
		j2eeContainer.setLinkType(CapabilityLinkTypes.ANY_LITERAL);
		j2eeContainer.setContainerVersion(J2EEContainerVersion._12_LITERAL);
		wasClusterUnit.getCapabilities().add(j2eeContainer);

		JSPContainer jspContainer = J2eeFactory.eINSTANCE.createJSPContainer();
		jspContainer.setName("jspContainer");//$NON-NLS-1$
		jspContainer.setDisplayName("jspContainer");//$NON-NLS-1$	
		jspContainer.setLinkType(CapabilityLinkTypes.ANY_LITERAL);
		jspContainer.setContainerVersion(JSPContainerVersion._11_LITERAL);
		wasClusterUnit.getCapabilities().add(jspContainer);

		ServletContainer servletContainer = J2eeFactory.eINSTANCE
				.createServletContainer();
		servletContainer.setName("servletContainer");//$NON-NLS-1$
		servletContainer.setDisplayName("servletContainer");//$NON-NLS-1$	
		servletContainer.setLinkType(CapabilityLinkTypes.ANY_LITERAL);
		servletContainer
				.setContainerVersion(ServletContainerVersion._22_LITERAL);
		wasClusterUnit.getCapabilities().add(servletContainer);

		EJBContainer ejbContainer = J2eeFactory.eINSTANCE.createEJBContainer();
		ejbContainer.setName("ejbContainer");//$NON-NLS-1$
		ejbContainer.setDisplayName("ejbContainer");//$NON-NLS-1$	
		ejbContainer.setLinkType(CapabilityLinkTypes.ANY_LITERAL);
		ejbContainer.setContainerVersion(EJBContainerVersion._11_LITERAL);
		wasClusterUnit.getCapabilities().add(ejbContainer);

		WasConfigurationContainer wasConfigurationContainer = WasFactory.eINSTANCE
				.createWasConfigurationContainer();
		wasConfigurationContainer.setName("wasConfigurationContainer");//$NON-NLS-1$
		wasConfigurationContainer.setDisplayName("wasConfigurationContainer"); //$NON-NLS-1$
		wasConfigurationContainer.setLinkType(CapabilityLinkTypes.ANY_LITERAL);
		wasClusterUnit.getCapabilities().add(wasConfigurationContainer);

		JCAContainer jcaContainer = J2eeFactory.eINSTANCE.createJCAContainer();
		jcaContainer.setName("jcaContainer");//$NON-NLS-1$
		jcaContainer.setDisplayName("jcaContainer");//$NON-NLS-1$
		jcaContainer.setLinkType(CapabilityLinkTypes.ANY_LITERAL);
		wasClusterUnit.getCapabilities().add(jcaContainer);

		WasSubstitutionVariable variableCap = WasFactory.eINSTANCE
				.createWasSubstitutionVariable();
		variableCap.setName("substitutionVariableCap");//$NON-NLS-1$
		variableCap.setDisplayName("substitutionVariable_Capability");//$NON-NLS-1$
		variableCap.setLinkType(CapabilityLinkTypes.ANY_LITERAL);
		wasClusterUnit.getCapabilities().add(variableCap);

		//
		// Require wasCellUint
		//
		// MK 4/8/2007 cluster now hosted on cell; not member
		// Requirement requiredWasCellUnit =
		// ValidatorTestUtils.createMemberRequirement(WasPackage.Literals.WAS_CELL_UNIT,
		// "requiredWasCellUnit");//$NON-NLS-1$
		Requirement requiredWasCellUnit = ValidatorTestUtils
				.createHostingRequirement(WasPackage.Literals.WAS_CELL,
						"hostsOnWasCell");
		// request expression will be checked by FVT
		wasClusterUnit.getRequirements().add(requiredWasCellUnit);

		WasCellUnit wasCellUnit = WasFactory.eINSTANCE.createWasCellUnit();
		wasCellUnit.setName("wasCellUnit");//$NON-NLS-1$
		wasCellUnit.setDisplayName("wasCellUnit");//$NON-NLS-1$
		top.getUnits().add(wasCellUnit);

		WasCell providedWasCell = WasFactory.eINSTANCE.createWasCell();
		providedWasCell.setName("providedWasCell");//$NON-NLS-1$
		providedWasCell.setDisplayName("providedWasCell");//$NON-NLS-1$
		providedWasCell.setCellName("standAloneCell");//$NON-NLS-1$
		providedWasCell.setIsDistributed(true);
		providedWasCell.setWasVersion("6.0.0.1");//$NON-NLS-1$
		wasCellUnit.getCapabilities().add(providedWasCell);

		// MK 4/8/2007 hosting link between wasClusterUnit and wasCellUnit
		HostingLink cell_ClusterHostingLink = LinkFactory.createHostingLink(
				wasCellUnit, wasClusterUnit);
// //member link between wasClusterUnit and wasCellUnit
// MemberLink cell_ClusterMemberLink = CoreFactory.eINSTANCE.createMemberLink();
// cell_ClusterMemberLink.setTarget(wasClusterUnit);
// cell_ClusterMemberLink.setSource(wasCellUnit);
// ValidatorTestUtils.createLinkName(cell_ClusterMemberLink);
// wasCellUnit.getMemberLinks().add(cell_ClusterMemberLink);

		//
		// Require WebsphereAppServerUnit as member
		//
		Requirement requiredWebSphereAppServerUnit = ValidatorTestUtils
				.createMemberRequirement(
						WasPackage.Literals.WEBSPHERE_APP_SERVER_UNIT,
						"requiredWebsphereAppServerUnit");//$NON-NLS-1$
		wasClusterUnit.getRequirements().add(requiredWebSphereAppServerUnit);

		WebsphereAppServerUnit webSphereAppServerUnit = WasFactory.eINSTANCE
				.createWebsphereAppServerUnit();
		webSphereAppServerUnit.setName("webSphereAppServerUnit");//$NON-NLS-1$
		webSphereAppServerUnit.setDisplayName("webSphereAppServerUnit");//$NON-NLS-1$
		top.getUnits().add(webSphereAppServerUnit);

		// member link between wasClusterUnit and webSphereAppServerUnit
		MemberLink serverClusterMemberLink = CoreFactory.eINSTANCE
				.createMemberLink();
		serverClusterMemberLink.setTarget(webSphereAppServerUnit);
		serverClusterMemberLink.setSource(wasClusterUnit);
		ValidatorTestUtils.createLinkName(serverClusterMemberLink);
		wasClusterUnit.getMemberLinks().add(serverClusterMemberLink);

		// /////////////////
		Resource res = top.getEObject().eResource();
		res.save(null);
		// /////////////////

		validator.validate(wasClusterUnit, context, reporter);
		System.out.println("In " + this.getClass()); //$NON-NLS-1$
		dumpMarkers(top);

		ValidatorTestUtils.assertValidationErrorCount(0, top, wasClusterUnit,
				context, reporter, validator);

		// clusterName not empty
		String savedClusterName = wasCluster.getClusterName();
		wasCluster.setClusterName("");//$NON-NLS-1$
		ValidatorTestUtils.assertValidationErrorCount(1, top, wasClusterUnit,
				context, reporter, validator);
		wasCluster.setClusterName(savedClusterName);
		ValidatorTestUtils.assertValidationErrorCount(0, top, wasClusterUnit,
				context, reporter, validator);
		// cell is distributed, cell version >= 6.0

	}
}
