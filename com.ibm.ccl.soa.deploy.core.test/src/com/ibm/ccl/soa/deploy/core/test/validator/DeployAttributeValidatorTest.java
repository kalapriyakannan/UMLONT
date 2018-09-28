/*******************************************************************************
 * Copyright (c) 2003, 2006 IBM Corporation Licensed Material - Property of IBM. All rights reserved.
 *  
 * US Government Users Restricted Rights - Use, duplication or disclosure v1.0 restricted by GSA ADP
 * Schedule Contract with IBM Corp.
 * 
 * Contributors: IBM Corporation - initial API and implementation
 *******************************************************************************/
package com.ibm.ccl.soa.deploy.core.test.validator;

import org.eclipse.core.runtime.IStatus;

import com.ibm.ccl.soa.deploy.core.CoreFactory;
import com.ibm.ccl.soa.deploy.core.CorePackage;
import com.ibm.ccl.soa.deploy.core.DeployModelObject;
import com.ibm.ccl.soa.deploy.core.Requirement;
import com.ibm.ccl.soa.deploy.core.RequirementExpression;
import com.ibm.ccl.soa.deploy.core.Topology;
import com.ibm.ccl.soa.deploy.core.Unit;
import com.ibm.ccl.soa.deploy.core.test.TopologyTestCase;
import com.ibm.ccl.soa.deploy.core.validator.IDeployReporter;
import com.ibm.ccl.soa.deploy.core.validator.IDeployValidationContext;
import com.ibm.ccl.soa.deploy.core.validator.expression.Equals;
import com.ibm.ccl.soa.deploy.core.validator.pattern.attribute.DeployAttributeNotNullValidator;
import com.ibm.ccl.soa.deploy.core.validator.pattern.attribute.DeployAttributeValidator;
import com.ibm.ccl.soa.deploy.core.validator.pattern.attribute.DeployRequirementAttributeValidator;
import com.ibm.ccl.soa.deploy.core.validator.status.ICoreProblemType;

/**
 * Tests {@link DeployAttributeValidator}.
 */
public class DeployAttributeValidatorTest extends TopologyTestCase {

	public DeployAttributeValidatorTest() {
		super("DeployAttributeValidatorTest");
	}

	public void testAttributeDefinedValidator() throws Exception {
		Topology top = createTopology("testAttributeDefinedValidator", true);

		Unit unit = CoreFactory.eINSTANCE.createUnit();
		unit.setName("unit");
		top.getUnits().add(unit);

		IDeployValidationContext context = createValidationContext(top);
		IDeployReporter reporter = createDeployReporter(false);
		DeployAttributeNotNullValidator descValidator = new DeployAttributeNotNullValidator(
				this.getClass().getName(), CorePackage.eINSTANCE
						.getDeployModelObject_Description(), IStatus.ERROR);

		assert unit.getStatus().isOK();
		unit.clearStatus();
		descValidator.validate(unit, context, reporter);
		assertHasDeployStatus(unit,
				ICoreProblemType.OBJECT_ATTRIBUTE_UNDEFINED, IStatus.ERROR);

		unit.setDescription("IBM");
		unit.clearStatus();
		descValidator.validate(unit, context, reporter);
		assert unit.getStatus().isOK();
	}

	public void testAttributeValidator() throws Exception {
		Topology top = createTopology("testAttributeValidator");

		Unit unit = CoreFactory.eINSTANCE.createUnit();
		unit.setName("unit");

		IDeployValidationContext context = createValidationContext(top);
		IDeployReporter reporter = createDeployReporter(false);
		DeployAttributeValidator descValidator = new DeployAttributeValidator(
				this.getClass().getName(), CorePackage.eINSTANCE
						.getDeployModelObject_Description()) {
			public void validate(DeployModelObject object,
					IDeployValidationContext context, IDeployReporter reporter) {
				String desc = (String) getAttributeValue(object);
				if (desc == null) {
					super.reportAttributeUndefinedStatus(IStatus.ERROR, object,
							context, reporter);
				} else if (!desc.equals("IBM")) {
					super.reportAttributeInvalidStatus(IStatus.ERROR, object,
							desc, context, reporter);
				}

			}
		};

		assert unit.getStatus().isOK();
		descValidator.validate(unit, context, reporter);
		assertHasDeployStatus(unit,
				ICoreProblemType.OBJECT_ATTRIBUTE_UNDEFINED, IStatus.ERROR);

		unit.setDescription("ThirdParty");
		unit.clearStatus();
		descValidator.validate(unit, context, reporter);
		assertHasDeployStatus(unit, ICoreProblemType.OBJECT_ATTRIBUTE_INVALID,
				IStatus.ERROR);

		unit.setDescription("IBM");
		unit.clearStatus();
		descValidator.validate(unit, context, reporter);
		assert unit.getStatus().isOK();
	}

	public void testRequirementAttributeValidator() throws Exception {
		Topology top = createTopology("testRequirementAttributeValidator");

		Unit unit = CoreFactory.eINSTANCE.createUnit();
		unit.setName("unit");

		IDeployValidationContext context = createValidationContext(top);
		IDeployReporter reporter = createDeployReporter(false);
		DeployRequirementAttributeValidator descValidator = new DeployRequirementAttributeValidator(
				this.getClass().getName(), CorePackage.eINSTANCE
						.getDeployModelObject_Description()) {
			public void validate(DeployModelObject object,
					IDeployValidationContext context, IDeployReporter reporter) {
				String desc = (String) getAttributeValue(object);
				if (desc == null) {
					super.reportAttributeUndefinedStatus(IStatus.ERROR, object,
							context, reporter);
				} else if (!desc.equals("IBM")) {
					super.reportAttributeInvalidStatus(IStatus.ERROR, object,
							desc, context, reporter);
				}
			}
		};

		//
		// Test requirement
		//
		Requirement req = CoreFactory.eINSTANCE.createRequirement();
		req.setName("req");
		unit.getRequirements().add(req);

		req.clearStatus();
		descValidator.validate(req, context, reporter);
		assertHasDeployStatus(req, ICoreProblemType.OBJECT_ATTRIBUTE_UNDEFINED,
				IStatus.ERROR);

		RequirementExpression expr = CoreFactory.eINSTANCE
				.createRequirementExpression();
		expr.setName("expr");
		Equals.setAttribute(expr, CorePackage.eINSTANCE
				.getDeployModelObject_Description(), null);
		req.getExpressions().add(expr);

		req.clearStatus();
		descValidator.validate(req, context, reporter);
		assertHasDeployStatus(req, ICoreProblemType.OBJECT_ATTRIBUTE_UNDEFINED,
				IStatus.ERROR);

		Equals.setAttribute(expr, CorePackage.eINSTANCE
				.getDeployModelObject_Description(), "NonIBM");
		req.clearStatus();
		descValidator.validate(req, context, reporter);
		assertHasDeployStatus(req, ICoreProblemType.OBJECT_ATTRIBUTE_INVALID,
				IStatus.ERROR);

		Equals.setAttribute(expr, CorePackage.eINSTANCE
				.getDeployModelObject_Description(), "IBM");
		req.clearStatus();
		descValidator.validate(req, context, reporter);
		assert unit.getStatus().isOK();

		//
		// Test requirement expression
		//
		Equals.setAttribute(expr, CorePackage.eINSTANCE
				.getDeployModelObject_Description(), null);
		expr.clearStatus();
		descValidator.validate(expr, context, reporter);
		assertHasDeployStatus(expr,
				ICoreProblemType.OBJECT_ATTRIBUTE_UNDEFINED, IStatus.ERROR);

		Equals.setAttribute(expr, CorePackage.eINSTANCE
				.getDeployModelObject_Description(), "NonIBM");
		expr.clearStatus();
		descValidator.validate(expr, context, reporter);
		assertHasDeployStatus(expr, ICoreProblemType.OBJECT_ATTRIBUTE_INVALID,
				IStatus.ERROR);

		Equals.setAttribute(expr, CorePackage.eINSTANCE
				.getDeployModelObject_Description(), "IBM");
		expr.clearStatus();
		descValidator.validate(expr, context, reporter);
		assert expr.getStatus().isOK();
	}
}
