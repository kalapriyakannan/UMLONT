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

import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.NullProgressMonitor;

import com.ibm.ccl.soa.deploy.core.CapabilityLinkTypes;
import com.ibm.ccl.soa.deploy.core.ConstraintLink;
import com.ibm.ccl.soa.deploy.core.CoreFactory;
import com.ibm.ccl.soa.deploy.core.CorePackage;
import com.ibm.ccl.soa.deploy.core.DependencyLink;
import com.ibm.ccl.soa.deploy.core.HostingLink;
import com.ibm.ccl.soa.deploy.core.Reference;
import com.ibm.ccl.soa.deploy.core.RequirementLinkTypes;
import com.ibm.ccl.soa.deploy.core.Service;
import com.ibm.ccl.soa.deploy.core.Topology;
import com.ibm.ccl.soa.deploy.core.Unit;
import com.ibm.ccl.soa.deploy.core.constraint.ApplicationCommunicationConstraint;
import com.ibm.ccl.soa.deploy.core.constraint.ApplicationCommunicationProtocolConstraint;
import com.ibm.ccl.soa.deploy.core.constraint.ConstraintFactory;
import com.ibm.ccl.soa.deploy.core.test.TopologyTestCase;
import com.ibm.ccl.soa.deploy.core.validator.DeployValidatorService;
import com.ibm.ccl.soa.deploy.core.validator.constraints.communication.ApplicationCommunicationProtocolConstraintMappingService;
import com.ibm.ccl.soa.deploy.core.validator.constraints.communication.ApplicationCommunicationProtocolConstraintValidator;
import com.ibm.ccl.soa.deploy.core.validator.matcher.LinkFactory;

/**
 * Tests conceptual node communication paths against application nodes.
 */
public class CommunicationConstraintValidatorTest extends TopologyTestCase {

	private static final String PROJECT_NAME = "CommunicationConstraintValidatorTest"; //$NON-NLS-1$

	/** Shared validator instance. */
	private DeployValidatorService validator;

	public CommunicationConstraintValidatorTest() {
		super(PROJECT_NAME);
		validator = new DeployValidatorService();
	}

	public void testDependencyLinkWithoutTarget() throws IOException,
			CoreException {
		final Topology top = createTopology("empty topology", true); //$NON-NLS-1$

		// Setup Component Unit

		final Unit componentA = CoreFactory.eINSTANCE.createSoftwareComponent();
		componentA.setName("Component1"); //$NON-NLS-1$
		top.getUnits().add(componentA);

		final Unit componentB = CoreFactory.eINSTANCE.createSoftwareComponent();
		componentB.setName("Component2"); //$NON-NLS-1$
		top.getUnits().add(componentB);

		final Reference reference = CoreFactory.eINSTANCE.createReference();
		reference.setName("requirement"); //$NON-NLS-1$
		reference.setDmoEType(CorePackage.eINSTANCE.getCapability());
		reference.setLinkType(RequirementLinkTypes.DEPENDENCY_LITERAL);
		componentA.getRequirements().add(reference);

		final Service service = CoreFactory.eINSTANCE.createService();
		service.setName("service:"); //$NON-NLS-1$
		service.setLinkType(CapabilityLinkTypes.DEPENDENCY_LITERAL);
		service.setProtocol("http");
		componentB.getCapabilities().add(service);

		final DependencyLink link = CoreFactory.eINSTANCE
				.createDependencyLink();
		link.setName("dependencyLink"); //$NON-NLS-1$
		link.setTarget(service);
		reference.setLink(link);

		// Setup Conceptual Units

		final Unit conceptualUnitA = CoreFactory.eINSTANCE.createUnit();
		conceptualUnitA.setName("ConceptualA"); //$NON-NLS-1$
		conceptualUnitA.setConceptual(true);
		top.getUnits().add(conceptualUnitA);

		final Unit conceptualUnitB = CoreFactory.eINSTANCE.createUnit();
		conceptualUnitB.setName("ConceptualB"); //$NON-NLS-1$
		conceptualUnitB.setConceptual(true);
		top.getUnits().add(conceptualUnitB);

		//Create communication constraint
		//MK: 12/21/2007: CommunicationConstraint --> ApplicationCommunicationConstraint
//		CommunicationConstraint constraint = ConstraintFactory.eINSTANCE.createCommunicationConstraint();
//		constraint.setApplicationLayerProtocol("HTTP");
		ApplicationCommunicationConstraint acc = ConstraintFactory.eINSTANCE.createApplicationCommunicationConstraint();
		ApplicationCommunicationProtocolConstraint acpc = ConstraintFactory.eINSTANCE.createApplicationCommunicationProtocolConstraint();
		acpc.setApplicationLayerProtocol(ApplicationCommunicationProtocolConstraintMappingService.HTTP);
		acc.getConstraints().add(acpc);
		
		//Create ConstraintLink
		//MK: 12/21/2007: CommunicationConstraint --> ApplicationCommunicationConstraint
//		ConstraintLink clink = CoreFactory.eINSTANCE.createConstraintLink();
//		clink.getConstraints().add(constraint);
//		clink.setSource(conceptualUnitA);
//		clink.setTarget(conceptualUnitB);
//		conceptualUnitA.getConstraintLinks().add(clink);
		ConstraintLink clink = LinkFactory.createConstraintLink(conceptualUnitA, conceptualUnitB);
		clink.getConstraints().add(acc);

		// link conceptual and components
		HostingLink hLink1 = CoreFactory.eINSTANCE.createHostingLink();
		hLink1.setSource(conceptualUnitA);
		hLink1.setTarget(componentA);
		conceptualUnitA.getHostingLinks().add(hLink1);

		HostingLink hLink2 = CoreFactory.eINSTANCE.createHostingLink();
		hLink2.setSource(conceptualUnitB);
		hLink2.setTarget(componentB);
		conceptualUnitB.getHostingLinks().add(hLink2);

		// Validator test
		//MK: 12/21/2007: CommunicationConstraint --> ApplicationCommunicationConstraint
//		CommunicationConstraintValidator validator = new CommunicationConstraintValidator();
//		IStatus status = validator.validate(constraint, clink, new NullProgressMonitor());
		ApplicationCommunicationProtocolConstraintValidator validator = new ApplicationCommunicationProtocolConstraintValidator();
		IStatus status = validator.validate(acpc, clink, new NullProgressMonitor());
		
		assertTrue(status.isOK());

		// now fail by changing constraint
		//MK: 12/21/2007: CommunicationConstraint --> ApplicationCommunicationConstraint
//		constraint.setApplicationLayerProtocol("rmi");
//		status = validator.validate(constraint, clink, new NullProgressMonitor());
		acpc.setApplicationLayerProtocol("rmi");
		status = validator.validate(acpc, clink, new NullProgressMonitor());
		assertFalse(status.isOK());
		
		//Fix by changing service.
		service.setProtocol("rmi");
		//MK: 12/21/2007: CommunicationConstraint --> ApplicationCommunicationConstraint
//		status = validator.validate(constraint, clink, new NullProgressMonitor());
		status = validator.validate(acpc, clink, new NullProgressMonitor());
		assertTrue(status.isOK());
		
		//Fail by changing service again.
		//MK: 12/21/2007: CommunicationConstraint --> ApplicationCommunicationConstraint
		service.setProtocol("jdbc");
		//MK: 12/21/2007: CommunicationConstraint --> ApplicationCommunicationConstraint
//		status = validator.validate(constraint, clink, new NullProgressMonitor());
		status = validator.validate(acpc, clink, new NullProgressMonitor());
		assertFalse(status.isOK());
		
		
	}
	
	public void testCommLinkWithNullServiceTarget() throws IOException,
	CoreException {
		final Topology top = createTopology("empty topology", true); //$NON-NLS-1$

		// Setup Component Unit

		final Unit componentA = CoreFactory.eINSTANCE.createSoftwareComponent();
		componentA.setName("Component1"); //$NON-NLS-1$
		top.getUnits().add(componentA);

		final Unit componentB = CoreFactory.eINSTANCE.createSoftwareComponent();
		componentB.setName("Component2"); //$NON-NLS-1$
		top.getUnits().add(componentB);

		final Reference reference = CoreFactory.eINSTANCE.createReference();
		reference.setName("requirement"); //$NON-NLS-1$
		reference.setDmoEType(CorePackage.eINSTANCE.getCapability());
		reference.setLinkType(RequirementLinkTypes.DEPENDENCY_LITERAL);
		componentA.getRequirements().add(reference);

		final Service service = CoreFactory.eINSTANCE.createService();
		service.setName("service:"); //$NON-NLS-1$
		service.setLinkType(CapabilityLinkTypes.DEPENDENCY_LITERAL);
		componentB.getCapabilities().add(service);

		final DependencyLink link = CoreFactory.eINSTANCE.createDependencyLink();
		link.setName("dependencyLink"); //$NON-NLS-1$
		link.setTarget(service);
		reference.setLink(link);


		// Create communication constraint
//		CommunicationConstraint constraint = ConstraintFactory.eINSTANCE.createCommunicationConstraint();
//		constraint.setApplicationLayerProtocol("HTTP");
		//MK: 12/21/2007 CommunicationConstraint --> ApplicationCommunicationConstraint
		ApplicationCommunicationConstraint acc = ConstraintFactory.eINSTANCE.createApplicationCommunicationConstraint();
		ApplicationCommunicationProtocolConstraint acpc = ConstraintFactory.eINSTANCE.createApplicationCommunicationProtocolConstraint();
		acpc.setApplicationLayerProtocol(ApplicationCommunicationProtocolConstraintMappingService.HTTP);
		acc.getConstraints().add(acpc);
		
		// Create ConstraintLink
//		ConstraintLink clink = CoreFactory.eINSTANCE.createConstraintLink();
//		clink.getConstraints().add(constraint);
//		clink.setSource(componentA);
//		clink.setTarget(componentB);
//		componentA.getConstraintLinks().add(clink);
		ConstraintLink clink = LinkFactory.createConstraintLink(componentA, componentB);
		clink.getConstraints().add(acc);

		// Validator test
//		CommunicationConstraintValidator validator = new CommunicationConstraintValidator();
//		IStatus status = validator.validate(constraint, clink, new NullProgressMonitor());
		ApplicationCommunicationProtocolConstraintValidator validator = new ApplicationCommunicationProtocolConstraintValidator();
		IStatus status = validator.validate(acpc, clink, new NullProgressMonitor());

		assertFalse(status.isOK());


		// Change constraint and service protocols
		service.setProtocol("http");
//		constraint.setApplicationLayerProtocol(null);
//		status = validator.validate(constraint, clink, new NullProgressMonitor());
		acpc.setApplicationLayerProtocol(null);
		status = validator.validate(acpc, clink, new NullProgressMonitor());
		assertTrue(status.isOK());

		// Change constraint
//		constraint.setApplicationLayerProtocol("SOAP/HTTP");
//		status = validator.validate(constraint, clink, new NullProgressMonitor());
		acpc.setApplicationLayerProtocol("SOAP/HTTP");
		status = validator.validate(acpc, clink, new NullProgressMonitor());
		assertTrue(status.isOK());

	}
}
