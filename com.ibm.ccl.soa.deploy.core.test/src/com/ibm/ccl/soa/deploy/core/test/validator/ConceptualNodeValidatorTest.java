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
import java.util.ArrayList;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IMarker;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IStatus;

import com.ibm.ccl.soa.deploy.core.CapabilityLinkTypes;
import com.ibm.ccl.soa.deploy.core.CommunicationCapability;
import com.ibm.ccl.soa.deploy.core.CoreFactory;
import com.ibm.ccl.soa.deploy.core.CorePackage;
import com.ibm.ccl.soa.deploy.core.DependencyLink;
import com.ibm.ccl.soa.deploy.core.DeployModelObject;
import com.ibm.ccl.soa.deploy.core.HostingLink;
import com.ibm.ccl.soa.deploy.core.Requirement;
import com.ibm.ccl.soa.deploy.core.RequirementExpression;
import com.ibm.ccl.soa.deploy.core.RequirementExpressionUsage;
import com.ibm.ccl.soa.deploy.core.RequirementLinkTypes;
import com.ibm.ccl.soa.deploy.core.Topology;
import com.ibm.ccl.soa.deploy.core.Unit;
import com.ibm.ccl.soa.deploy.core.test.TopologyTestCase;
import com.ibm.ccl.soa.deploy.core.util.UnitUtil;
import com.ibm.ccl.soa.deploy.core.validator.DeployValidatorService;
import com.ibm.ccl.soa.deploy.core.validator.IDeployMarker;
import com.ibm.ccl.soa.deploy.core.validator.IDeployReporter;
import com.ibm.ccl.soa.deploy.core.validator.expression.Equals;
import com.ibm.ccl.soa.deploy.core.validator.matcher.LinkType;
import com.ibm.ccl.soa.deploy.internal.core.validator.CoreDomainValidator;
import com.ibm.ccl.soa.deploy.internal.core.validator.DeployValidationContext;
import com.ibm.ccl.soa.deploy.internal.core.validator.TopologyMarkerFactory;
import com.ibm.ccl.soa.infrastructure.emf.WorkbenchResourceHelper;

/**
 * Tests conceptual node communication paths against application nodes.
 */

// IN PROGRESS - need communication on service to finished - adding protocol
// test for now.
public class ConceptualNodeValidatorTest extends TopologyTestCase {

	private static final String PROJECT_NAME = "CoreDeployValidatorTest"; //$NON-NLS-1$

	private final static String PROTOCAL_TYPE_ATTR = "type"; //$NON-NLS-1$

	/** Shared validator instance. */
	private DeployValidatorService validator;

	public ConceptualNodeValidatorTest() {
		super(PROJECT_NAME);
		validator = new DeployValidatorService();
	}

	public void testDependencyLinkBtwnConceptualNodes() throws IOException,
			CoreException {
		final Topology top = createTopology("empty topology", true); //$NON-NLS-1$

		// Setup Conceptual Units

		final Unit conceptualUnitA = CoreFactory.eINSTANCE.createUnit();
		conceptualUnitA.setName("ConceptualA"); //$NON-NLS-1$
		conceptualUnitA.setConceptual(true);
		top.getUnits().add(conceptualUnitA);

		final Unit conceptualUnitB = CoreFactory.eINSTANCE.createUnit();
		conceptualUnitB.setName("ConceptualB"); //$NON-NLS-1$
		conceptualUnitB.setConceptual(true);
		top.getUnits().add(conceptualUnitB);

		CommunicationCapability commCapability = CoreFactory.eINSTANCE
				.createCommunicationCapability();
		commCapability.setLinkType(CapabilityLinkTypes.DEPENDENCY_LITERAL);
		commCapability.setApplicationLayerProtocol("http"); //$NON-NLS-1$
		conceptualUnitB.getCapabilities().add(commCapability);

		Requirement requriement = CoreFactory.eINSTANCE.createRequirement();
		requriement.setName("requirement"); //$NON-NLS-1$
		requriement.setDmoEType(CorePackage.eINSTANCE
				.getCommunicationCapability());
		requriement.setLinkType(RequirementLinkTypes.DEPENDENCY_LITERAL);

		RequirementExpression reExpression = CoreFactory.eINSTANCE
				.createRequirementExpression();
		reExpression.setUse(RequirementExpressionUsage.REQUIRED_LITERAL);
		reExpression.setInterpreter(Equals.INTERPRETER_ID);
		reExpression
				.setName(UnitUtil.generateUniqueName(conceptualUnitA, "re")); //$NON-NLS-1$
		reExpression.setAttributeName(PROTOCAL_TYPE_ATTR);
		// communicaiton capability protocol type = http not https should create
		// error markers
		reExpression.setValue("https");
		requriement.getExpressions().add(reExpression);
		conceptualUnitA.getRequirements().add(requriement);

		DependencyLink link = CoreFactory.eINSTANCE.createDependencyLink();
		link.setName("dependencyLink"); //$NON-NLS-1$
		link.setTarget(commCapability);
		requriement.setLink(link);

		// Validator test
		CoreDomainValidator validator = new CoreDomainValidator();
		IDeployReporter reporter = createDeployReporter(true);
		ArrayList list = new ArrayList();
		list.add(conceptualUnitA);
		list.add(conceptualUnitB);

		DeployValidationContext dpc = new DeployValidationContext(top, null,
				null);
		validator.validate(dpc, reporter);

		// communicaiton capability protocol type = http not https should create
		// error markers
		IMarker[] markers = TopologyMarkerFactory.getMarkers(top);
		assertTrue("missing marker for endpoint match check", checkForMessage(
				markers, "Endpoints do not match (\"dependencyLink\")."));

		// changing requirement expression to http, there should not be any
		// markers
		clearMarkers(top);
		requriement = (Requirement) conceptualUnitA.getRequirements().get(0);
		RequirementExpression expr = (RequirementExpression) requriement
				.getExpressions().get(0);
		expr.setValue("http");

		validator.validate(dpc, reporter);
		markers = TopologyMarkerFactory.getMarkers(top);
		assertTrue("should not have any markers", markers.length == 0);

		// //////////////////handle multiple communication
		// links//////////////////////////:

		clearMarkers(top);

		CommunicationCapability commCapability2 = CoreFactory.eINSTANCE
				.createCommunicationCapability();
		commCapability2.setLinkType(CapabilityLinkTypes.DEPENDENCY_LITERAL);
		commCapability2.setApplicationLayerProtocol("rmi"); //$NON-NLS-1$
		conceptualUnitB.getCapabilities().add(commCapability2);

		Requirement requriement2 = CoreFactory.eINSTANCE.createRequirement();
		requriement2.setName("requirement"); //$NON-NLS-1$
		requriement2.setDmoEType(CorePackage.eINSTANCE
				.getCommunicationCapability());
		requriement2.setLinkType(RequirementLinkTypes.DEPENDENCY_LITERAL);

		RequirementExpression reExpression2 = CoreFactory.eINSTANCE
				.createRequirementExpression();
		reExpression2.setUse(RequirementExpressionUsage.REQUIRED_LITERAL);
		reExpression2.setInterpreter(Equals.INTERPRETER_ID);
		reExpression2.setName(UnitUtil
				.generateUniqueName(conceptualUnitA, "re")); //$NON-NLS-1$
		reExpression2.setAttributeName(PROTOCAL_TYPE_ATTR);
		// communicaiton capability protocol type = http not https should create
		// error markers
		reExpression2.setValue("rmi");
		requriement2.getExpressions().add(reExpression);
		conceptualUnitA.getRequirements().add(requriement2);

		DependencyLink link2 = CoreFactory.eINSTANCE.createDependencyLink();
		link2.setName("dependencyLink2"); //$NON-NLS-1$
		link2.setTarget(commCapability);
		requriement2.setLink(link2);

		validator.validate(dpc, reporter);
		markers = TopologyMarkerFactory.getMarkers(top);
		assertTrue("should not have any markers", markers.length == 0);

		// // remove a requirment from link
		clearMarkers(top);
		requriement.getLink().setTarget(null);
		validator.validate(dpc, reporter);
		markers = TopologyMarkerFactory.getMarkers(top);
		assertTrue(checkForMessage(markers,
				"Missing link target (\"dependencyLink\")."));

		// ////////// test a matcher btw conceptual to non conceptual/////used
		// in ui
		clearMarkers(top);
		requriement.getLink().setTarget(commCapability);

		DeployValidatorService service = DeployValidatorService.getDefaultValidatorService();

		IStatus status = service.canBeLinkSource(conceptualUnitA, null,
				new LinkType[] { LinkType.DEPENDENCY });
		assertTrue(status.isOK());

		conceptualUnitA.setConceptual(false);

		status = service.canBeLinkSource(conceptualUnitA, null,
				new LinkType[] { LinkType.DEPENDENCY });
		assertFalse(status.isOK());

		// test can be target
		status = service.canBeLinkTarget(conceptualUnitA, null,
				new LinkType[] { LinkType.DEPENDENCY });
		assertFalse(status.isOK());

		conceptualUnitA.setConceptual(true);

		status = service.canBeLinkTarget(conceptualUnitA, null,
				new LinkType[] { LinkType.DEPENDENCY });
		assertFalse(status.isOK());

		// test can be linked

		status = service.canCreateLink(conceptualUnitA, conceptualUnitB,
				new LinkType[] { LinkType.DEPENDENCY });
		assertTrue(status.isOK());

		status = service.canCreateLink(conceptualUnitB, conceptualUnitA,
				new LinkType[] { LinkType.DEPENDENCY });
		assertTrue(status.isOK());

		status = service.canCreateLink(conceptualUnitA, conceptualUnitA,
				new LinkType[] { LinkType.DEPENDENCY });
		assertTrue(status.isOK());

		conceptualUnitA.setConceptual(false);

		status = service.canCreateLink(conceptualUnitA, conceptualUnitB,
				new LinkType[] { LinkType.DEPENDENCY });
		assertFalse(status.isOK());

		status = service.canCreateLink(conceptualUnitB, conceptualUnitA,
				new LinkType[] { LinkType.DEPENDENCY });
		assertFalse(status.isOK());

		status = service.canCreateLink(conceptualUnitA, conceptualUnitA,
				new LinkType[] { LinkType.DEPENDENCY });
		assertFalse(status.isOK());

	}

	public void testHostingLinks() throws IOException, CoreException {
		final Topology top = createTopology("empty topology", true); //$NON-NLS-1$

		clearMarkers(top);

		final Unit componentA = CoreFactory.eINSTANCE.createSoftwareComponent();
		componentA.setName("Component1"); //$NON-NLS-1$
		top.getUnits().add(componentA);

		final Unit conceptualUnitA = CoreFactory.eINSTANCE.createUnit();
		conceptualUnitA.setName("ConceptualA"); //$NON-NLS-1$
		conceptualUnitA.setConceptual(true);
		top.getUnits().add(conceptualUnitA);

		HostingLink hLink1 = CoreFactory.eINSTANCE.createHostingLink();
		hLink1.setSource(conceptualUnitA);
		hLink1.setTarget(componentA);
		conceptualUnitA.getHostingLinks().add(hLink1);

		CoreDomainValidator validator = new CoreDomainValidator();
		IDeployReporter reporter = createDeployReporter(true);

		DeployValidationContext dpc = new DeployValidationContext(top, null,
				null);
		validator.validate(dpc, reporter);

		IMarker[] markers = TopologyMarkerFactory.getMarkers(top);
		assertTrue("should not have any markers", markers.length == 0);

	}

	private void clearMarkers(final Topology top) throws CoreException {
		IResource resource = (IResource) getIFile(top);
		resource.deleteMarkers(IDeployMarker.MARKER_ID, true,
				IResource.DEPTH_INFINITE);
	}

	private boolean checkForMessage(IMarker[] markers, String string) {
		for (int i = 0; i < markers.length; i++) {
			IMarker marker = markers[i];
			try {
				if (markers[i].getAttribute("message").equals(string))
					return true;
			} catch (CoreException e) {
				return false;
			}

		}
		return false;
	}

	public IFile getIFile(DeployModelObject object) {
		return WorkbenchResourceHelper.getFile(object.getTopology()
				.getEObject());
	}
}
