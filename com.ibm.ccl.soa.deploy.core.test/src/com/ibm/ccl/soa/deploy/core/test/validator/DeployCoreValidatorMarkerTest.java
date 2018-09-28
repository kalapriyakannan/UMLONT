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

import org.eclipse.core.resources.IMarker;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.emf.ecore.resource.Resource;

import com.ibm.ccl.soa.deploy.core.Capability;
import com.ibm.ccl.soa.deploy.core.CapabilityLinkTypes;
import com.ibm.ccl.soa.deploy.core.CoreFactory;
import com.ibm.ccl.soa.deploy.core.CorePackage;
import com.ibm.ccl.soa.deploy.core.DependencyLink;
import com.ibm.ccl.soa.deploy.core.Requirement;
import com.ibm.ccl.soa.deploy.core.Topology;
import com.ibm.ccl.soa.deploy.core.Unit;
import com.ibm.ccl.soa.deploy.core.test.TopologyTestCase;
import com.ibm.ccl.soa.deploy.core.validator.DeployValidatorService;
import com.ibm.ccl.soa.deploy.core.validator.DomainValidator;
import com.ibm.ccl.soa.deploy.core.validator.IDeployReporter;
import com.ibm.ccl.soa.deploy.core.validator.IDeployValidationContext;
import com.ibm.ccl.soa.deploy.internal.core.validator.CoreDomainValidator;
import com.ibm.ccl.soa.deploy.internal.core.validator.DeployMarker;
import com.ibm.ccl.soa.deploy.internal.core.validator.DeployValidationContext;
import com.ibm.ccl.soa.deploy.internal.core.validator.TopologyMarkerFactory;

/**
 * Tests the generation of markers for core validation errors.
 */
public class DeployCoreValidatorMarkerTest extends TopologyTestCase {

	private static final String PROJECT_NAME = "DeployCoreValidationMarkerTest";

	private CoreDomainValidator validator;

	public class MarkerCounter {
		protected int counter = 0;

		DomainValidator validator;

		IDeployValidationContext context;

		IDeployReporter reporter;

		public MarkerCounter(DomainValidator validator,
				IDeployValidationContext context, IDeployReporter reporter) {
			this.validator = validator;
			this.context = context;
			this.reporter = reporter;

		}

		public void inc() throws CoreException, IOException {
			add(1);
		}

		public void add(int count) throws CoreException, IOException {
			assert count >= 0;
			counter += count;
			context.getTopology().getEObject().eResource().save(null);
			DeployMarker.deleteInstances(context.getTopology());
			validator.validate(context, reporter);
			IMarker[] markers = DeployMarker
					.getInstances(context.getTopology());
			if (markers.length != counter) {
				throw new RuntimeException("Expected " + counter
						+ " markers, found " + markers.length + "\n"
						+ dumpMarkers(context.getTopology())
						+ "\n--- Status dump ---\n"
						+ dumpStatus(context.getTopology()));
			}
		}
	}

	public DeployCoreValidatorMarkerTest() {
		this(PROJECT_NAME);
	}
	
	public DeployCoreValidatorMarkerTest(String name) {
		super(name);
		validator = new CoreDomainValidator();
	} 
	
	/**
	 * Creates a topology with all validation markers.
	 */
	public void testAllCoreMarkers() throws IOException, CoreException {
		final Topology top = createTopology("testAllCoreMarkers", true);

		IDeployValidationContext context = createValidationContext(top);
		IDeployReporter reporter = createDeployReporter();
		MarkerCounter counter = new MarkerCounter(validator, context, reporter);

		//
		// Unit errors
		//

		// {@link DeployCoreMessages#Validator_unit_0_services_undefined}
		final Unit noServicesUnit = CoreFactory.eINSTANCE.createUnit();
		noServicesUnit.setName("no services unit");
		top.getUnits().add(noServicesUnit);
		counter.inc();

		//
		// Capability errors
		//
		// {@link
		// DeployCoreMessages#Validator_consumed_service_0_service_link_undefined}
		createConsumedRequirementWithNoLink(top);
		counter.inc();

		//
		// ServiceLinks
		//

		// {@link DeployCoreMessages#Validator_cannot_determine_service_type}
		// {@link
		// DeployCoreMessages#Validator_deploy_model_object_0_container_undefined}
		createLinkWithUncontainedTargetService(top);
		counter.inc();

		// {@link DeployCoreMessages#Validator_service_link_has_no_target}
		createLinkWithNoTarget(top);
		counter.inc();

		// {@link
		// DeployCoreMessages#Validator_source_S_of_link_L_is_not_a_supertype_of_target_T}
		// TODO core does not contain any subtypes of Capability: cannot test
		// service type mismatch error

		//
		// Check that validation does not dirty a resource.
		//
		Resource resource = top.getEObject().eResource();
		resource.save(null);
		assertFalse(resource.isModified());
		if (!resource.isTrackingModification())
			resource.setTrackingModification(true);
		validator.validate(new DeployValidationContext(top,
				new DeployValidatorService(), new NullProgressMonitor()),
				createDeployReporter());
		assertFalse(resource.isModified());
		TopologyMarkerFactory.deleteDeployMarkers(top);

		assertFalse(resource.isModified());
	}

	protected void createConsumedRequirementWithNoLink(Topology top) {
		final Unit unit = CoreFactory.eINSTANCE.createUnit();
		unit.setName("no link consumed service unit");
		top.getUnits().add(unit);

		final Requirement consumedService = CoreFactory.eINSTANCE
				.createRequirement();
		consumedService.setName("no link consumed service");
		consumedService.setDmoEType(CorePackage.eINSTANCE.getUnit());
		unit.getRequirements().add(consumedService);
	}

	protected void createLinkWithNoTarget(Topology top) {
		final Unit sourceUnit = CoreFactory.eINSTANCE.createUnit();
		sourceUnit.setName("no target unit");
		top.getUnits().add(sourceUnit);

		final Requirement req = CoreFactory.eINSTANCE.createRequirement();
		req.setName("no targetservice");
		sourceUnit.getRequirements().add(req);

		final DependencyLink link = CoreFactory.eINSTANCE
				.createDependencyLink();
		link.setName("no target link");
		req.setLink(link);
	}

	protected void createLinkWithUncontainedTargetService(Topology top) {
		final Unit sourceUnit = CoreFactory.eINSTANCE.createUnit();
		sourceUnit.setName("uncontained target unit");
		top.getUnits().add(sourceUnit);

		final Requirement req = CoreFactory.eINSTANCE.createRequirement();
		req.setName("uncontained target source service");
		req.setDmoEType(CorePackage.eINSTANCE.getCapability());
		sourceUnit.getRequirements().add(req);

		final Capability cap = CoreFactory.eINSTANCE.createCapability();
		cap.setLinkType(CapabilityLinkTypes.DEPENDENCY_LITERAL);
		cap.setName("target service");

		final DependencyLink link = CoreFactory.eINSTANCE
				.createDependencyLink();
		link.setName("uncontained target link");
		req.setLink(link);
		link.setTarget(cap);
	}
}
