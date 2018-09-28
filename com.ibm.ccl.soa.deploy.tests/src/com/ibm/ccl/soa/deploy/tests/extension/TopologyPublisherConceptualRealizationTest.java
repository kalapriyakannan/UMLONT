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
import org.eclipse.core.runtime.NullProgressMonitor;

import com.ibm.ccl.soa.deploy.core.CoreFactory;
import com.ibm.ccl.soa.deploy.core.HostingLink;
import com.ibm.ccl.soa.deploy.core.IDeployPublishContext;
import com.ibm.ccl.soa.deploy.core.RealizationLink;
import com.ibm.ccl.soa.deploy.core.Topology;
import com.ibm.ccl.soa.deploy.core.Unit;
import com.ibm.ccl.soa.deploy.core.test.TopologyTestCase;
import com.ibm.ccl.soa.deploy.core.validator.DeployValidatorService;
import com.ibm.ccl.soa.deploy.core.validator.resolution.ResolutionUtils;
import com.ibm.ccl.soa.deploy.internal.core.DeployPublishContext;
import com.ibm.ccl.soa.deploy.internal.core.extension.TopologyManager;
import com.ibm.ccl.soa.deploy.internal.core.extension.TopologyPublisherDescriptor;
import com.ibm.ccl.soa.deploy.internal.core.validator.DeployTransactionReporter;
import com.ibm.ccl.soa.deploy.was.IWasTemplateConstants;
import com.ibm.ccl.soa.deploy.was.WebsphereAppServerUnit;

public class TopologyPublisherConceptualRealizationTest extends
		TopologyTestCase {

	private static final String PROJECT_NAME = "CoreDeployValidatorTest"; //$NON-NLS-1$
	private static final String EXPECTED_TEST_NAME = "IDE Topology Publisher";

	private DeployValidatorService validator;

	public TopologyPublisherConceptualRealizationTest() {
		super(PROJECT_NAME);
		validator = new DeployValidatorService();
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

		TopologyPublisherDescriptor[] publishers = TopologyManager
				.getInstance().findAvailablePublishers(top);
		TopologyPublisherDescriptor testPublisherDesc = null;

		assertTrue("There should be at least one test extension",
				publishers.length > 0);

		for (int i = 0; i < publishers.length; i++) {
			TopologyPublisherDescriptor descriptor = publishers[i];
			if (descriptor.getName().equals(EXPECTED_TEST_NAME))
				testPublisherDesc = descriptor;

		}
		assertNotNull(testPublisherDesc);

		assertEquals(EXPECTED_TEST_NAME, testPublisherDesc.getName());

		TestTopologyPublisher publisher = (TestTopologyPublisher) testPublisherDesc
				.createTopologyPublisher();

		IDeployPublishContext context = new DeployPublishContext(top, true,
				new DeployTransactionReporter(), new NullProgressMonitor());
		publisher.publish(context);
	}
}
