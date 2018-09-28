/*******************************************************************************
 * Copyright (c) 2003, 2007 IBM Corporation Licensed Material - Property of IBM. All rights reserved.
 *  
 * US Government Users Restricted Rights - Use, duplication or disclosure v1.0 restricted by GSA ADP
 * Schedule Contract with IBM Corp.
 * 
 * Contributors: IBM Corporation - initial API and implementation
 *******************************************************************************/

package com.ibm.ccl.soa.deploy.core.test.validator.constraints;

import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.NullProgressMonitor;

import com.ibm.ccl.soa.deploy.core.Capability;
import com.ibm.ccl.soa.deploy.core.CapabilityLinkTypes;
import com.ibm.ccl.soa.deploy.core.Constraint;
import com.ibm.ccl.soa.deploy.core.CorePackage;
import com.ibm.ccl.soa.deploy.core.Requirement;
import com.ibm.ccl.soa.deploy.core.RequirementExpression;
import com.ibm.ccl.soa.deploy.core.RequirementLinkTypes;
import com.ibm.ccl.soa.deploy.core.Topology;
import com.ibm.ccl.soa.deploy.core.Unit;
import com.ibm.ccl.soa.deploy.core.test.TopologyTestCase;
import com.ibm.ccl.soa.deploy.core.validator.ConstraintService;
import com.ibm.ccl.soa.deploy.core.validator.expression.Equals;

/**
 * Tests constraints on attributes.
 */
public class AttributeConstraintTest extends TopologyTestCase {

	public AttributeConstraintTest() {
		super(AttributeConstraintTest.class.getSimpleName());
	}

	/**
	 * Tests that requirements are not contained as
	 * {@link DeployModelObject#getConstraints()} constraints, but are returned
	 * from {@link Unit#getRequirements()}, and that requirement expressions
	 * are child constraints.
	 * 
	 * @throws Exception
	 */
	public void testRequirementCompatibility() throws Exception {
		Topology top = createTopology("testRequirementCompatibility");
		Unit u1 = addUnit(top, "u1");
		assertSetEquals(u1.getRequirements(), null);
		assertSetEquals(u1.getConstraints(), null);

		Requirement r1 = addRequirement(u1, "r1",
				RequirementLinkTypes.HOSTING_LITERAL);
		r1.setDmoEType(CorePackage.Literals.CAPABILITY);

		assertFalse(r1 instanceof Constraint);
		assertEquals(u1, r1.getParent());
		assertSetEquals(u1.getRequirements(), new Object[] { r1 });
		assertSetEquals(u1.getConstraints(), null);
		assertSetEquals(r1.getExpressions(), null);
		assertSetEquals(r1.getConstraints(), null);

		validate(top);
		assertHasErrorStatus(top);

		String descr = "special description";
		RequirementExpression re1 = Equals.createExpression(
				CorePackage.Literals.DEPLOY_MODEL_OBJECT__DESCRIPTION, descr);
		r1.getExpressions().add(re1);
		assertTrue(re1 instanceof Constraint);
		assertEquals(r1, re1.getParent());
		assertSetEquals(u1.getRequirements(), new Object[] { r1 });
		assertSetEquals(u1.getConstraints(), null);
		assertSetEquals(r1.getExpressions(), new Object[] { re1 });
		assertSetEquals(r1.getConstraints(), new Object[] { re1 });
		assertSetEquals(re1.getConstraints(), null);
	}

	/**
	 * Tests the use of a {@link Equals} requirement expression as a constraint
	 * on a {@link Capability} attribute.
	 * 
	 * @throws Exception
	 */
	public void testCapabilityRequirementExpressionEqualsConstraint()
			throws Exception {
		final IProgressMonitor monitor = new NullProgressMonitor();
		//
		// Create simple topology with a unit containing a capability
		//
		Topology top = createTopology("testCapabilityRequirementExpressionEqualsConstraint");
		Unit u1 = addUnit(top, "u1");
		Capability c1 = addCapability(u1, "c1", CapabilityLinkTypes.ANY_LITERAL);
		validate(top);
		assertHasNoErrorStatus(top);

		String descr = "special description";
		Constraint e1 = Equals.createExpression(
				CorePackage.Literals.DEPLOY_MODEL_OBJECT__DESCRIPTION, descr);
		c1.getConstraints().add(e1);

		//
		// Unsatisfied constraint check
		//

		assertEquals(IStatus.ERROR, ConstraintService.INSTANCE.validate(e1, c1, monitor).getSeverity());
		validate(top);
		assertHasErrorStatus(top);

		//
		// Satisfied constraint check
		//
		c1.setDescription(descr);
		assertEquals(IStatus.OK, ConstraintService.INSTANCE.validate(e1, c1, monitor).getSeverity());
		validate(top);
		assertHasNoErrorStatus(top);
	}

	/**
	 * Tests the use of a {@link Equals} requirement expression as a constraint
	 * on a {@link Unit} attribute.
	 * 
	 * @throws Exception
	 */
	public void testUnitRequirementExpressionEqualsConstraint()
			throws Exception {
		final IProgressMonitor monitor = new NullProgressMonitor();
		//
		// Create simple topology with a unit containing a capability
		//
		Topology top = createTopology("testUnitRequirementExpressionEqualsConstraint");
		Unit u1 = addUnit(top, "u1");
		Capability c1 = addCapability(u1, "c1", CapabilityLinkTypes.ANY_LITERAL);
		validate(top);
		assertHasNoErrorStatus(top);

		String descr = "special description";
		Constraint e1 = Equals.createExpression(
				CorePackage.Literals.DEPLOY_MODEL_OBJECT__DESCRIPTION, descr);
		u1.getConstraints().add(e1);

		//
		// Unsatisfied constraint check
		//

		assertEquals(IStatus.ERROR, ConstraintService.INSTANCE.validate(e1, u1, monitor).getSeverity());
		validate(top);
		assertHasErrorStatus(top);

		//
		// Satisfied constraint check
		//
		u1.setDescription(descr);
		assertEquals(IStatus.OK, ConstraintService.INSTANCE.validate(e1, u1, monitor).getSeverity());
		validate(top);
		assertHasNoErrorStatus(top);
	}
}
