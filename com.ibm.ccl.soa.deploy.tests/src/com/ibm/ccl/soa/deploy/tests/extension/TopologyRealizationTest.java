/*******************************************************************************
 * Copyright (c) 2003, 2007 IBM Corporation Licensed Material - Property of IBM. All rights reserved.
 *  
 * US Government Users Restricted Rights - Use, duplication or disclosure v1.0 restricted by GSA ADP
 * Schedule Contract with IBM Corp.
 * 
 * Contributors: IBM Corporation - initial API and implementation
 *******************************************************************************/
package com.ibm.ccl.soa.deploy.tests.extension;

import java.io.IOException;

import org.eclipse.core.runtime.CoreException;

import com.ibm.ccl.soa.deploy.core.CoreFactory;
import com.ibm.ccl.soa.deploy.core.HostingLink;
import com.ibm.ccl.soa.deploy.core.RealizationLink;
import com.ibm.ccl.soa.deploy.core.Topology;
import com.ibm.ccl.soa.deploy.core.Unit;
import com.ibm.ccl.soa.deploy.core.test.TopologyTestCase;
import com.ibm.ccl.soa.deploy.core.validator.DeployValidatorService;
import com.ibm.ccl.soa.deploy.core.validator.resolution.ResolutionUtils;
import com.ibm.ccl.soa.deploy.internal.core.RealizedTopology;
import com.ibm.ccl.soa.deploy.was.IWasTemplateConstants;
import com.ibm.ccl.soa.deploy.was.WebsphereAppServerUnit;

public class TopologyRealizationTest extends TopologyTestCase {

	private static final String PROJECT_NAME = "CoreDeployValidatorTest"; //$NON-NLS-1$

	private static final String EXPECTED_TEST_NAME = "IDE Topology Publisher";

	private DeployValidatorService validator;

	public TopologyRealizationTest() {
		super(PROJECT_NAME);
		validator = new DeployValidatorService();
		setDeleteProjectOnTearDown(true);
	}

	public void testMultipleUnitsHostedToConceptualNode() throws IOException,
			CoreException {

		Topology top = createTopology("empty topology", true); //$NON-NLS-1$

		Unit componentA = CoreFactory.eINSTANCE.createSoftwareComponent();
		componentA.setName("Component1"); //$NON-NLS-1$
		top.getUnits().add(componentA);

		Unit componentB = CoreFactory.eINSTANCE.createSoftwareComponent();
		componentB.setName("Component2"); //$NON-NLS-1$
		top.getUnits().add(componentB);

		Unit conceptualUnitA = CoreFactory.eINSTANCE.createUnit();
		conceptualUnitA.setName("ConceptualA"); //$NON-NLS-1$
		conceptualUnitA.setConceptual(true);
		top.getUnits().add(conceptualUnitA);

		HostingLink hLink1 = CoreFactory.eINSTANCE.createHostingLink();
		hLink1.setSource(conceptualUnitA);
		hLink1.setTarget(componentA);
		conceptualUnitA.getHostingLinks().add(hLink1);

		HostingLink hLink2 = CoreFactory.eINSTANCE.createHostingLink();
		hLink2.setSource(conceptualUnitA);
		hLink2.setTarget(componentB);
		conceptualUnitA.getHostingLinks().add(hLink2);

		// WebsphereAppServerUnit
		WebsphereAppServerUnit was6ServerUnit = (WebsphereAppServerUnit) ResolutionUtils
				.addFromTemplate(IWasTemplateConstants.WAS_6_APPLICATION_SERVER_UNIT, top); //$NON-NLS-1$
		top.getUnits().add(was6ServerUnit);

		// Realization Link
		RealizationLink rLink = CoreFactory.eINSTANCE.createRealizationLink();

		rLink.setSource(conceptualUnitA);
		rLink.setTarget(was6ServerUnit);
		top.getRealizationLinks().add(rLink);

		RealizedTopology rt = new RealizedTopology(top);

		assertTrue(rt.getRealizedUnits().size() == 4);

		assertTrue(rt.getLeafHosts().get(0) == was6ServerUnit);

		assertTrue(rt.getHostees(was6ServerUnit, false).size() == 3);

	}

	public void testMultipleHostsToConceptualNodes() throws IOException,
			CoreException {

		Topology top = createTopology("empty topology", true); //$NON-NLS-1$

		Unit componentA = CoreFactory.eINSTANCE.createSoftwareComponent();
		componentA.setName("Component1"); //$NON-NLS-1$
		top.getUnits().add(componentA);

		Unit componentB = CoreFactory.eINSTANCE.createSoftwareComponent();
		componentB.setName("Component2"); //$NON-NLS-1$
		top.getUnits().add(componentB);

		Unit conceptualUnitA = CoreFactory.eINSTANCE.createUnit();
		conceptualUnitA.setName("ConceptualA"); //$NON-NLS-1$
		conceptualUnitA.setConceptual(true);
		top.getUnits().add(conceptualUnitA);

		HostingLink hLink1 = CoreFactory.eINSTANCE.createHostingLink();
		hLink1.setSource(conceptualUnitA);
		hLink1.setTarget(componentA);
		conceptualUnitA.getHostingLinks().add(hLink1);

		HostingLink hLink2 = CoreFactory.eINSTANCE.createHostingLink();
		hLink2.setSource(conceptualUnitA);
		hLink2.setTarget(componentB);
		conceptualUnitA.getHostingLinks().add(hLink2);

		// WebsphereAppServerUnit
		WebsphereAppServerUnit was6ServerUnit = (WebsphereAppServerUnit) ResolutionUtils
				.addFromTemplate(IWasTemplateConstants.WAS_6_APPLICATION_SERVER_UNIT, top); //$NON-NLS-1$
		top.getUnits().add(was6ServerUnit);

		// Realization Link
		RealizationLink rLink = CoreFactory.eINSTANCE.createRealizationLink();

		rLink.setSource(conceptualUnitA);
		rLink.setTarget(was6ServerUnit);
		top.getRealizationLinks().add(rLink);

		// /////////////////////////////////Second
		// Tree\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\

		Unit componentA2 = CoreFactory.eINSTANCE.createSoftwareComponent();
		componentA2.setName("Component1"); //$NON-NLS-1$
		top.getUnits().add(componentA2);

		Unit componentB2 = CoreFactory.eINSTANCE.createSoftwareComponent();
		componentB2.setName("Component2"); //$NON-NLS-1$
		top.getUnits().add(componentB2);

		Unit conceptualUnitA2 = CoreFactory.eINSTANCE.createUnit();
		conceptualUnitA2.setName("ConceptualA"); //$NON-NLS-1$
		conceptualUnitA2.setConceptual(true);
		top.getUnits().add(conceptualUnitA2);

		HostingLink hLink12 = CoreFactory.eINSTANCE.createHostingLink();
		hLink12.setSource(conceptualUnitA2);
		hLink12.setTarget(componentA2);
		conceptualUnitA2.getHostingLinks().add(hLink12);

		HostingLink hLink22 = CoreFactory.eINSTANCE.createHostingLink();
		hLink22.setSource(conceptualUnitA2);
		hLink22.setTarget(componentB2);
		conceptualUnitA2.getHostingLinks().add(hLink22);

		// WebsphereAppServerUnit
		WebsphereAppServerUnit was6ServerUnit2 = (WebsphereAppServerUnit) ResolutionUtils
				.addFromTemplate("was.WebsphereAppServerUnit.6", top); //$NON-NLS-1$
		top.getUnits().add(was6ServerUnit2);

		// Realization Link
		RealizationLink rLink2 = CoreFactory.eINSTANCE.createRealizationLink();

		rLink2.setSource(conceptualUnitA2);
		rLink2.setTarget(was6ServerUnit2);
		top.getRealizationLinks().add(rLink2);

		RealizedTopology rt = new RealizedTopology(top);

		assertTrue(rt.getRealizedUnits().size() == 8);

		assertTrue(rt.getLeafHosts().size() == 2);

		assertTrue(rt.getHosts().size() == 2);

		assertTrue(rt.getHostees(was6ServerUnit, false).size() == 3);

	}

	public void testMultiDimensionalHostingStack() throws IOException,
			CoreException {

		Topology top = createTopology("empty topology", true); //$NON-NLS-1$

		Unit componentA = CoreFactory.eINSTANCE.createSoftwareComponent();
		componentA.setName("ComponentA"); //$NON-NLS-1$
		top.getUnits().add(componentA);

		Unit componentB = CoreFactory.eINSTANCE.createSoftwareComponent();
		componentB.setName("ComponentB"); //$NON-NLS-1$
		top.getUnits().add(componentB);

		Unit componentC = CoreFactory.eINSTANCE.createSoftwareComponent();
		componentC.setName("ComponentC"); //$NON-NLS-1$
		top.getUnits().add(componentC);

		Unit conceptualUnitA = CoreFactory.eINSTANCE.createUnit();
		conceptualUnitA.setName("ConceptualA"); //$NON-NLS-1$
		conceptualUnitA.setConceptual(true);
		top.getUnits().add(conceptualUnitA);

		HostingLink hLink1 = CoreFactory.eINSTANCE.createHostingLink();
		hLink1.setSource(conceptualUnitA);
		hLink1.setTarget(componentA);
		conceptualUnitA.getHostingLinks().add(hLink1);

		HostingLink hLink2 = CoreFactory.eINSTANCE.createHostingLink();
		hLink2.setSource(conceptualUnitA);
		hLink2.setTarget(componentB);
		conceptualUnitA.getHostingLinks().add(hLink2);

		HostingLink hLink3 = CoreFactory.eINSTANCE.createHostingLink();
		hLink3.setSource(componentB);
		hLink3.setTarget(componentC);
		componentB.getHostingLinks().add(hLink3);

		// WebsphereAppServerUnit
		WebsphereAppServerUnit was6ServerUnit = (WebsphereAppServerUnit) ResolutionUtils
				.addFromTemplate(IWasTemplateConstants.WAS_6_APPLICATION_SERVER_UNIT, top); //$NON-NLS-1$
		top.getUnits().add(was6ServerUnit);

		// Realization Link
		RealizationLink rLink = CoreFactory.eINSTANCE.createRealizationLink();

		rLink.setSource(conceptualUnitA);
		rLink.setTarget(was6ServerUnit);
		top.getRealizationLinks().add(rLink);

		RealizedTopology rt = new RealizedTopology(top);

		assertTrue(rt.getRealizedUnits().size() == 5);

		assertTrue(rt.getLeafHosts().size() == 1);

		assertTrue(rt.getHosts().size() == 2);

		assertTrue(rt.getHostees(was6ServerUnit, true).size() == 4);

		assertTrue(rt.getHostees(was6ServerUnit, false).size() == 3);

	}

	public void testIsolatedUnits() throws IOException, CoreException {

		Topology top = createTopology("empty topology", true); //$NON-NLS-1$

		Unit componentA = CoreFactory.eINSTANCE.createSoftwareComponent();
		componentA.setName("Component1"); //$NON-NLS-1$
		top.getUnits().add(componentA);

		Unit componentB = CoreFactory.eINSTANCE.createSoftwareComponent();
		componentB.setName("Component2"); //$NON-NLS-1$
		top.getUnits().add(componentB);

		// /Loner component not in hosted any
		Unit componentC = CoreFactory.eINSTANCE.createSoftwareComponent();
		componentC.setName("Component1"); //$NON-NLS-1$
		top.getUnits().add(componentC);

		Unit conceptualUnitA = CoreFactory.eINSTANCE.createUnit();
		conceptualUnitA.setName("ConceptualA"); //$NON-NLS-1$
		conceptualUnitA.setConceptual(true);
		top.getUnits().add(conceptualUnitA);

		HostingLink hLink1 = CoreFactory.eINSTANCE.createHostingLink();
		hLink1.setSource(conceptualUnitA);
		hLink1.setTarget(componentA);
		conceptualUnitA.getHostingLinks().add(hLink1);

		HostingLink hLink2 = CoreFactory.eINSTANCE.createHostingLink();
		hLink2.setSource(conceptualUnitA);
		hLink2.setTarget(componentB);
		conceptualUnitA.getHostingLinks().add(hLink2);

		// WebsphereAppServerUnit
		WebsphereAppServerUnit was6ServerUnit = (WebsphereAppServerUnit) ResolutionUtils
				.addFromTemplate(IWasTemplateConstants.WAS_6_APPLICATION_SERVER_UNIT, top); //$NON-NLS-1$
		top.getUnits().add(was6ServerUnit);

		// Realization Link
		RealizationLink rLink = CoreFactory.eINSTANCE.createRealizationLink();

		rLink.setSource(conceptualUnitA);
		rLink.setTarget(was6ServerUnit);
		top.getRealizationLinks().add(rLink);

		RealizedTopology rt = new RealizedTopology(top);

		assertTrue(rt.getRealizedUnits().size() == 5);

		assertTrue(rt.getLeafHosts().size() == 1);

		assertTrue(rt.getHosts().size() == 1);

		assertTrue(rt.getHostees(was6ServerUnit, true).size() == 3);

	}

	public void testMultiDimensionConceptualHost() throws IOException,
			CoreException {

		Topology top = createTopology("empty topology", true); //$NON-NLS-1$

		Unit componentA = CoreFactory.eINSTANCE.createSoftwareComponent();
		componentA.setName("Componenta"); //$NON-NLS-1$
		top.getUnits().add(componentA);

		Unit componentB = CoreFactory.eINSTANCE.createSoftwareComponent();
		componentB.setName("Componentb"); //$NON-NLS-1$
		top.getUnits().add(componentB);

		// /Loner component not in hosted any
		Unit componentC = CoreFactory.eINSTANCE.createSoftwareComponent();
		componentC.setName("Componentc"); //$NON-NLS-1$
		top.getUnits().add(componentC);

		Unit conceptualUnitA = CoreFactory.eINSTANCE.createUnit();
		conceptualUnitA.setName("ConceptualA"); //$NON-NLS-1$
		conceptualUnitA.setConceptual(true);
		top.getUnits().add(conceptualUnitA);

		Unit conceptualUnitB = CoreFactory.eINSTANCE.createUnit();
		conceptualUnitA.setName("ConceptualA"); //$NON-NLS-1$
		conceptualUnitA.setConceptual(true);
		top.getUnits().add(conceptualUnitB);

		HostingLink hLink1 = CoreFactory.eINSTANCE.createHostingLink();
		hLink1.setSource(conceptualUnitA);
		hLink1.setTarget(componentA);
		conceptualUnitA.getHostingLinks().add(hLink1);

		HostingLink hLink2 = CoreFactory.eINSTANCE.createHostingLink();
		hLink2.setSource(conceptualUnitA);
		hLink2.setTarget(componentB);
		conceptualUnitA.getHostingLinks().add(hLink2);

		HostingLink hLink3 = CoreFactory.eINSTANCE.createHostingLink();
		hLink2.setSource(conceptualUnitA);
		hLink2.setTarget(conceptualUnitB);

		// WebsphereAppServerUnit
		WebsphereAppServerUnit was6ServerUnit = (WebsphereAppServerUnit) ResolutionUtils
				.addFromTemplate(IWasTemplateConstants.WAS_5_APPLICATION_SERVER_UNIT, top); //$NON-NLS-1$
		top.getUnits().add(was6ServerUnit);

		// Realization Link
		RealizationLink rLink0 = CoreFactory.eINSTANCE.createRealizationLink();
		rLink0.setSource(conceptualUnitB);
		rLink0.setTarget(componentC);
		top.getRealizationLinks().add(rLink0);

		RealizationLink rLink = CoreFactory.eINSTANCE.createRealizationLink();
		rLink.setSource(conceptualUnitA);
		rLink.setTarget(was6ServerUnit);
		top.getRealizationLinks().add(rLink);

		RealizedTopology rt = new RealizedTopology(top);

		assertTrue(rt.getRealizedUnits().size() == 5);

		assertTrue(rt.getLeafHosts().size() == 1);

		assertTrue(rt.getHosts().size() == 1);

		assertTrue(rt.getHostees(was6ServerUnit, true).size() == 3);

	}
}
