/*******************************************************************************
 * Copyright (c) 2003, 2006 IBM Corporation Licensed Material - Property of IBM. All rights reserved.
 *  
 * US Government Users Restricted Rights - Use, duplication or disclosure v1.0 restricted by GSA ADP
 * Schedule Contract with IBM Corp.
 * 
 * Contributors: IBM Corporation - initial API and implementation
 *******************************************************************************/
package com.ibm.ccl.soa.deploy.core.test.validator.pattern;

import java.io.IOException;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IStatus;

import com.ibm.ccl.soa.deploy.core.Capability;
import com.ibm.ccl.soa.deploy.core.CoreFactory;
import com.ibm.ccl.soa.deploy.core.CorePackage;
import com.ibm.ccl.soa.deploy.core.DependencyLink;
import com.ibm.ccl.soa.deploy.core.Requirement;
import com.ibm.ccl.soa.deploy.core.RequirementLinkTypes;
import com.ibm.ccl.soa.deploy.core.Topology;
import com.ibm.ccl.soa.deploy.core.Unit;
import com.ibm.ccl.soa.deploy.core.test.TopologyTestCase;
import com.ibm.ccl.soa.deploy.core.validator.IDeployReporter;
import com.ibm.ccl.soa.deploy.core.validator.IDeployValidationContext;
import com.ibm.ccl.soa.deploy.core.validator.pattern.attribute.CapabilityAttributeToAttributePropagationValidator;
import com.ibm.ccl.soa.deploy.core.validator.status.ICoreProblemType;
import com.ibm.ccl.soa.deploy.core.validator.status.IDeployAttributeValueSourceStatus;

public class ProvidedToProvidedAttributeValidatorTest extends TopologyTestCase {

	public static final String PROJECT_NAME = "ProvidedToProvidedAttributeValidatorTest";

	public ProvidedToProvidedAttributeValidatorTest() {
		super(PROJECT_NAME);
	}

	public void testProvidedToProvidedAttributePropagator() throws IOException,
			CoreException {
		Topology top = createTopology(
				"testProvidedToProvidedAttributePropagator", true);
		IDeployReporter reporter = createDeployReporter();
		IDeployValidationContext context = createValidationContext(top);

		// +--provides->targetCapability
		// |
		// TargetUnit
		// |
		// +--consumes-->targetRequirement
		Capability targetCapability = CoreFactory.eINSTANCE.createCapability();
		targetCapability.setName("targetCapability");

		Requirement targetRequirement = CoreFactory.eINSTANCE
				.createRequirement();
		targetRequirement.setName("targetRequirement");
		targetRequirement.setDmoEType(CorePackage.eINSTANCE.getCapability());
		targetRequirement.setLinkType(RequirementLinkTypes.DEPENDENCY_LITERAL);

		Unit targetUnit = CoreFactory.eINSTANCE.createUnit();
		targetUnit.setName("targetUnit");
		targetUnit.getOnlyDependencyCapabilities().add(targetCapability);
		targetUnit.getRequirements().add(targetRequirement);
		top.getUnits().add(targetUnit);

		// +--provides->sourceCapability
		// |
		// SourceUnit

		Capability sourceCapability = CoreFactory.eINSTANCE.createCapability();
		sourceCapability.setName("sourceCapability");
		sourceCapability.setDescription("1.2");

		Unit sourceUnit = CoreFactory.eINSTANCE.createUnit();
		sourceUnit.setName("sourceUnit");
		sourceUnit.getOnlyDependencyCapabilities().add(sourceCapability);
		top.getUnits().add(sourceUnit);

		DependencyLink link = CoreFactory.eINSTANCE.createDependencyLink();
		link.setName("link");
		link.setTarget(sourceCapability);
		targetRequirement.setLink(link);

		//
		// Test propagator
		//
		CapabilityAttributeToAttributePropagationValidator propagator = new CapabilityAttributeToAttributePropagationValidator(
				"ValidatorID", CorePackage.eINSTANCE.getCapability(),
				CorePackage.eINSTANCE.getDeployModelObject_Description(),
				CorePackage.eINSTANCE.getCapability(), CorePackage.eINSTANCE
						.getDeployModelObject_Description());

		propagator.validate(targetUnit, context, reporter);
		assertHasDeployStatus(targetCapability,
				ICoreProblemType.OBJECT_ATTRIBUTE_INVALID, IStatus.ERROR);
		IDeployAttributeValueSourceStatus status = (IDeployAttributeValueSourceStatus) targetCapability
				.getStatus();
		assert status.getAttributeExpectedValue().equals(
				sourceCapability.getDescription());
		assert status.getAttributeExpectedValueSourceObject(top).equals(
				sourceCapability);
		assert status.getAttributeExpectedValueSourceAttributeType(top).equals(
				CorePackage.eINSTANCE.getDeployModelObject_Description());

		targetCapability.clearStatus();
		targetCapability.setDescription(sourceCapability.getDescription());
		propagator.validate(targetUnit, context, reporter);
		assertHasNoErrorStatus(top);
	}
}
