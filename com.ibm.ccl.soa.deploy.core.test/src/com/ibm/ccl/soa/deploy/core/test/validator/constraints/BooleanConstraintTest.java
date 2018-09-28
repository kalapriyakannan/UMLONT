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
import com.ibm.ccl.soa.deploy.core.Topology;
import com.ibm.ccl.soa.deploy.core.Unit;
import com.ibm.ccl.soa.deploy.core.constraint.AndConstraint;
import com.ibm.ccl.soa.deploy.core.constraint.ConstraintFactory;
import com.ibm.ccl.soa.deploy.core.constraint.NotConstraint;
import com.ibm.ccl.soa.deploy.core.constraint.OrConstraint;
import com.ibm.ccl.soa.deploy.core.constraint.XorConstraint;
import com.ibm.ccl.soa.deploy.core.test.TopologyTestCase;
import com.ibm.ccl.soa.deploy.core.validator.ConstraintService;
import com.ibm.ccl.soa.deploy.core.validator.expression.Equals;

/**
 * Tests the boolean constraints.
 * 
 * @see NotConstraint
 * @see OrConstraint
 * @see AndConstraint
 * @see XorConstraint
 */
public class BooleanConstraintTest extends TopologyTestCase {

	public BooleanConstraintTest() {
		super(BooleanConstraintTest.class.getSimpleName());
	}

	/**
	 * Tests {@link NotConstraint}
	 * 
	 * @throws Exception
	 */
	public void testNotConstraint() throws Exception {
		final IProgressMonitor monitor = new NullProgressMonitor();
		//
		// Create simple topology with a unit containing a capability
		//
		Topology top = createTopology("testNotConstraint");
		Unit u1 = addUnit(top, "u1");
		Capability c1 = addCapability(u1, "c1", CapabilityLinkTypes.ANY_LITERAL);
		validate(top);
		assertHasNoErrorStatus(top);

		String descr = "special description";
		Constraint okConstraint = Equals.createExpression(
				CorePackage.Literals.DEPLOY_MODEL_OBJECT__DESCRIPTION, null);
		Constraint errorConstraint = Equals.createExpression(
				CorePackage.Literals.DEPLOY_MODEL_OBJECT__DESCRIPTION, descr);
		Capability c2 = addCapability(u1, "c2", CapabilityLinkTypes.ANY_LITERAL);
		c2.getConstraints().add(okConstraint);
		c2.getConstraints().add(errorConstraint);
		assertEquals(IStatus.OK, ConstraintService.INSTANCE.validate(okConstraint, c1, monitor)
				.getSeverity());
		assertEquals(IStatus.ERROR, ConstraintService.INSTANCE.validate(errorConstraint, c1, monitor)
				.getSeverity());
		u1.getCapabilities().remove(c2);

		//
		// Not
		//
		NotConstraint notConstraint = ConstraintFactory.eINSTANCE
				.createNotConstraint();
		notConstraint.setName("not");
		c1.getConstraints().add(notConstraint);
		// No arguments -- should be WARNING
		assertEquals(IStatus.WARNING, ConstraintService.INSTANCE.validate(notConstraint, c1, monitor)
				.getSeverity());

		// !OK = ERROR
		notConstraint.getConstraints().add(okConstraint);
		assertEquals(IStatus.ERROR, ConstraintService.INSTANCE.validate(notConstraint, c1, monitor)
				.getSeverity());

		// !ERROR = OK
		notConstraint.getConstraints().clear();
		notConstraint.getConstraints().add(errorConstraint);
		assertEquals(IStatus.OK, ConstraintService.INSTANCE.validate(notConstraint, c1, monitor)
				.getSeverity());

		// multiple parameters to unary operation
		notConstraint.getConstraints().add(okConstraint);
		assertEquals(IStatus.ERROR, ConstraintService.INSTANCE.validate(notConstraint, c1, monitor)
				.getSeverity());

		//
		// Test containment methods
		//
		assertSetEquals(top.findAllDeployModelObjects(), new Object[] { u1, c1,
				notConstraint, okConstraint, errorConstraint });
		assertSetEquals(u1.getContainedModelObjects(), new Object[] { c1 });
		assertSetEquals(c1.getContainedModelObjects(),
				new Object[] { notConstraint });
		assertSetEquals(notConstraint.getContainedModelObjects(), new Object[] {
				okConstraint, errorConstraint });
		// move constraint to unit
		u1.getConstraints().add(notConstraint);
		assertSetEquals(u1.getContainedModelObjects(), new Object[] { c1,
				notConstraint });
		assertSetEquals(notConstraint.getContainedModelObjects(), new Object[] {
				okConstraint, errorConstraint });
	}

	/**
	 * Tests {@link AndConstraint}
	 * 
	 * @throws Exception
	 */
	public void testAndConstraint() throws Exception {
		final IProgressMonitor monitor = new NullProgressMonitor();
		//
		// Create simple topology with a unit containing a capability
		//
		Topology top = createTopology("testAndConstraint");
		Unit u1 = addUnit(top, "u1");
		Capability c1 = addCapability(u1, "c1", CapabilityLinkTypes.ANY_LITERAL);
		validate(top);
		assertHasNoErrorStatus(top);

		String descr = "special description";
		Constraint okConstraint = Equals.createExpression(
				CorePackage.Literals.DEPLOY_MODEL_OBJECT__DESCRIPTION, null);
		Constraint errorConstraint = Equals.createExpression(
				CorePackage.Literals.DEPLOY_MODEL_OBJECT__DESCRIPTION, descr);
		Capability c2 = addCapability(u1, "c2", CapabilityLinkTypes.ANY_LITERAL);
		c2.getConstraints().add(okConstraint);
		c2.getConstraints().add(errorConstraint);
		assertEquals(IStatus.OK, ConstraintService.INSTANCE.validate(okConstraint, c1, monitor)
				.getSeverity());
		assertEquals(IStatus.ERROR, ConstraintService.INSTANCE.validate(errorConstraint, c1, monitor)
				.getSeverity());
		u1.getCapabilities().remove(c2);

		//
		// And
		//
		AndConstraint andConstraint = ConstraintFactory.eINSTANCE
				.createAndConstraint();
		andConstraint.setName("and");
		
		// need to have OR constraint as parent of AND, as AND can't have Capability as parent
		OrConstraint auxOrConstraint = ConstraintFactory.eINSTANCE.createOrConstraint();
		c1.getConstraints().add(auxOrConstraint);

		auxOrConstraint.getConstraints().add(andConstraint);
		// No arguments -- should be WARNING
		// alternative semantics: No arguments -- should be OK
		assertEquals(IStatus.OK, ConstraintService.INSTANCE.validate(andConstraint, c1, monitor)
				.getSeverity());

		//
		// One parameter
		//

		// OK = OK
		andConstraint.getConstraints().add(okConstraint);
		assertEquals(IStatus.OK, ConstraintService.INSTANCE.validate(andConstraint, c1, monitor)
				.getSeverity());

		// ERROR = ERROR
		andConstraint.getConstraints().clear();
		andConstraint.getConstraints().add(errorConstraint);
		assertEquals(IStatus.ERROR, ConstraintService.INSTANCE.validate(andConstraint, c1, monitor)
				.getSeverity());

		//
		// Two parameters
		//
		Constraint okConstraint2 = Equals.createExpression(
				CorePackage.Literals.DEPLOY_MODEL_OBJECT__DESCRIPTION, null);
		Constraint errorConstraint2 = Equals.createExpression(
				CorePackage.Literals.DEPLOY_MODEL_OBJECT__DESCRIPTION, descr);

		// ERROR and ERROR = ERROR
		andConstraint.getConstraints().clear();
		andConstraint.getConstraints().add(errorConstraint);
		andConstraint.getConstraints().add(errorConstraint2);
		assertEquals(IStatus.ERROR, ConstraintService.INSTANCE.validate(andConstraint, c1, monitor)
				.getSeverity());

		// ERROR and OK = ERROR
		andConstraint.getConstraints().clear();
		andConstraint.getConstraints().add(errorConstraint);
		andConstraint.getConstraints().add(okConstraint2);
		assertEquals(IStatus.ERROR, ConstraintService.INSTANCE.validate(andConstraint, c1, monitor)
				.getSeverity());

		// OK and ERROR = ERROR
		andConstraint.getConstraints().clear();
		andConstraint.getConstraints().add(okConstraint);
		andConstraint.getConstraints().add(errorConstraint2);
		assertEquals(IStatus.ERROR, ConstraintService.INSTANCE.validate(andConstraint, c1, monitor)
				.getSeverity());

		// ERROR and ERROR = ERROR
		andConstraint.getConstraints().clear();
		andConstraint.getConstraints().add(errorConstraint);
		andConstraint.getConstraints().add(errorConstraint2);
		assertEquals(IStatus.ERROR, ConstraintService.INSTANCE.validate(andConstraint, c1, monitor)
				.getSeverity());

		//
		// Three parameters
		//
		Constraint okConstraint3 = Equals.createExpression(
				CorePackage.Literals.DEPLOY_MODEL_OBJECT__DESCRIPTION, null);
		Constraint errorConstraint3 = Equals.createExpression(
				CorePackage.Literals.DEPLOY_MODEL_OBJECT__DESCRIPTION, descr);

		// OK and OK and OK = OK
		andConstraint.getConstraints().clear();
		andConstraint.getConstraints().add(okConstraint);
		andConstraint.getConstraints().add(okConstraint2);
		andConstraint.getConstraints().add(okConstraint3);
		assertEquals(IStatus.OK, ConstraintService.INSTANCE.validate(andConstraint, c1, monitor)
				.getSeverity());

		// OK and OK and ERROR = ERROR
		andConstraint.getConstraints().clear();
		andConstraint.getConstraints().add(okConstraint);
		andConstraint.getConstraints().add(okConstraint2);
		andConstraint.getConstraints().add(errorConstraint3);
		assertEquals(IStatus.ERROR, ConstraintService.INSTANCE.validate(andConstraint, c1, monitor)
				.getSeverity());

		// OK and ERROR and OK = ERROR
		andConstraint.getConstraints().clear();
		andConstraint.getConstraints().add(okConstraint);
		andConstraint.getConstraints().add(errorConstraint2);
		andConstraint.getConstraints().add(okConstraint3);
		assertEquals(IStatus.ERROR, ConstraintService.INSTANCE.validate(andConstraint, c1, monitor)
				.getSeverity());
	}

	/**
	 * Tests {@link OrConstraint}
	 * 
	 * @throws Exception
	 */
	public void testOrConstraint() throws Exception {
		final IProgressMonitor monitor = new NullProgressMonitor();
		//
		// Create simple topology with a unit containing a capability
		//
		Topology top = createTopology("testOrConstraint");
		Unit u1 = addUnit(top, "u1");
		Capability c1 = addCapability(u1, "c1", CapabilityLinkTypes.ANY_LITERAL);
		validate(top);
		assertHasNoErrorStatus(top);

		String descr = "special description";
		Constraint okConstraint = Equals.createExpression(
				CorePackage.Literals.DEPLOY_MODEL_OBJECT__DESCRIPTION, null);
		Constraint errorConstraint = Equals.createExpression(
				CorePackage.Literals.DEPLOY_MODEL_OBJECT__DESCRIPTION, descr);
		Capability c2 = addCapability(u1, "c2", CapabilityLinkTypes.ANY_LITERAL);
		c2.getConstraints().add(okConstraint);
		c2.getConstraints().add(errorConstraint);
		assertEquals(IStatus.OK, ConstraintService.INSTANCE.validate(okConstraint, c1, monitor)
				.getSeverity());
		assertEquals(IStatus.ERROR, ConstraintService.INSTANCE.validate(errorConstraint, c1, monitor)
				.getSeverity());
		u1.getCapabilities().remove(c2);

		//
		// Or
		//
		OrConstraint orConstraint = ConstraintFactory.eINSTANCE
				.createOrConstraint();
		orConstraint.setName("or");
		c1.getConstraints().add(orConstraint);
		// No arguments -- should be WARNING
		// alternative semantics: No arguments -- should be OK
		assertEquals(IStatus.OK, ConstraintService.INSTANCE.validate(orConstraint, c1, monitor)
				.getSeverity());

		//
		// One parameter
		//

		// OK = OK
		orConstraint.getConstraints().add(okConstraint);
		assertEquals(IStatus.OK, ConstraintService.INSTANCE.validate(orConstraint, c1, monitor)
				.getSeverity());

		// ERROR = ERROR
		orConstraint.getConstraints().clear();
		orConstraint.getConstraints().add(errorConstraint);
		assertEquals(IStatus.ERROR, ConstraintService.INSTANCE.validate(orConstraint, c1, monitor)
				.getSeverity());

		//
		// Two parameters
		//
		Constraint okConstraint2 = Equals.createExpression(
				CorePackage.Literals.DEPLOY_MODEL_OBJECT__DESCRIPTION, null);
		Constraint errorConstraint2 = Equals.createExpression(
				CorePackage.Literals.DEPLOY_MODEL_OBJECT__DESCRIPTION, descr);

		// OK or OK = OK
		orConstraint.getConstraints().clear();
		orConstraint.getConstraints().add(okConstraint);
		orConstraint.getConstraints().add(okConstraint2);
		assertEquals(IStatus.OK, ConstraintService.INSTANCE.validate(orConstraint, c1, monitor)
				.getSeverity());

		// ERROR or OK = OK
		orConstraint.getConstraints().clear();
		orConstraint.getConstraints().add(errorConstraint);
		orConstraint.getConstraints().add(okConstraint2);
		assertEquals(IStatus.OK, ConstraintService.INSTANCE.validate(orConstraint, c1, monitor)
				.getSeverity());

		// OK or ERROR = OK
		orConstraint.getConstraints().clear();
		orConstraint.getConstraints().add(okConstraint);
		orConstraint.getConstraints().add(errorConstraint2);
		assertEquals(IStatus.OK, ConstraintService.INSTANCE.validate(orConstraint, c1, monitor)
				.getSeverity());

		// ERROR or ERROR = ERROR
		orConstraint.getConstraints().clear();
		orConstraint.getConstraints().add(errorConstraint);
		orConstraint.getConstraints().add(errorConstraint2);
		assertEquals(IStatus.ERROR, ConstraintService.INSTANCE.validate(orConstraint, c1, monitor)
				.getSeverity());

		//
		// Three parameters
		//
		Constraint okConstraint3 = Equals.createExpression(
				CorePackage.Literals.DEPLOY_MODEL_OBJECT__DESCRIPTION, null);
		Constraint errorConstraint3 = Equals.createExpression(
				CorePackage.Literals.DEPLOY_MODEL_OBJECT__DESCRIPTION, descr);

		// OK or OK or OK = OK
		orConstraint.getConstraints().clear();
		orConstraint.getConstraints().add(okConstraint);
		orConstraint.getConstraints().add(okConstraint2);
		orConstraint.getConstraints().add(okConstraint3);
		assertEquals(IStatus.OK, ConstraintService.INSTANCE.validate(orConstraint, c1, monitor)
				.getSeverity());

		// OK or OK or ERROR = OK
		orConstraint.getConstraints().clear();
		orConstraint.getConstraints().add(okConstraint);
		orConstraint.getConstraints().add(okConstraint2);
		orConstraint.getConstraints().add(errorConstraint3);
		assertEquals(IStatus.OK, ConstraintService.INSTANCE.validate(orConstraint, c1, monitor)
				.getSeverity());

		// OK or ERROR or OK = OK
		orConstraint.getConstraints().clear();
		orConstraint.getConstraints().add(okConstraint);
		orConstraint.getConstraints().add(errorConstraint2);
		orConstraint.getConstraints().add(okConstraint3);
		assertEquals(IStatus.OK, ConstraintService.INSTANCE.validate(orConstraint, c1, monitor)
				.getSeverity());

		// ERROR or OK or OK = OK
		orConstraint.getConstraints().clear();
		orConstraint.getConstraints().add(okConstraint);
		orConstraint.getConstraints().add(errorConstraint2);
		orConstraint.getConstraints().add(okConstraint3);
		assertEquals(IStatus.OK, ConstraintService.INSTANCE.validate(orConstraint, c1, monitor)
				.getSeverity());

		// ERROR or ERROR or ERROR = ERROR
		orConstraint.getConstraints().clear();
		orConstraint.getConstraints().add(errorConstraint);
		orConstraint.getConstraints().add(errorConstraint2);
		orConstraint.getConstraints().add(errorConstraint3);
		assertEquals(IStatus.ERROR, ConstraintService.INSTANCE.validate(orConstraint, c1, monitor)
				.getSeverity());
	}

	/**
	 * Tests {@link XorConstraint}
	 * 
	 * @throws Exception
	 */
	public void testXorConstraint() throws Exception {
		final IProgressMonitor monitor = new NullProgressMonitor();
		//
		// Create simple topology with a unit containing a capability
		//
		Topology top = createTopology("testXorConstraint");
		Unit u1 = addUnit(top, "u1");
		Capability c1 = addCapability(u1, "c1", CapabilityLinkTypes.ANY_LITERAL);
		validate(top);
		assertHasNoErrorStatus(top);

		String descr = "special description";
		Constraint okConstraint = Equals.createExpression(
				CorePackage.Literals.DEPLOY_MODEL_OBJECT__DESCRIPTION, null);
		Constraint errorConstraint = Equals.createExpression(
				CorePackage.Literals.DEPLOY_MODEL_OBJECT__DESCRIPTION, descr);
		Capability c2 = addCapability(u1, "c2", CapabilityLinkTypes.ANY_LITERAL);
		c2.getConstraints().add(okConstraint);
		c2.getConstraints().add(errorConstraint);
		assertEquals(IStatus.OK, ConstraintService.INSTANCE.validate(okConstraint, c1, monitor)
				.getSeverity());
		assertEquals(IStatus.ERROR, ConstraintService.INSTANCE.validate(errorConstraint, c1, monitor)
				.getSeverity());
		u1.getCapabilities().remove(c2);

		//
		// Or
		//
		XorConstraint xorConstraint = ConstraintFactory.eINSTANCE
				.createXorConstraint();
		xorConstraint.setName("xor");
		c1.getConstraints().add(xorConstraint);
		// No arguments -- should be WARNING
		assertEquals(IStatus.WARNING, ConstraintService.INSTANCE.validate(xorConstraint, c1, monitor)
				.getSeverity());

		//
		// One parameter
		//

		// OK = OK
		xorConstraint.getConstraints().add(okConstraint);
		assertEquals(IStatus.OK, ConstraintService.INSTANCE.validate(xorConstraint, c1, monitor)
				.getSeverity());

		// ERROR = ERROR
		xorConstraint.getConstraints().clear();
		xorConstraint.getConstraints().add(errorConstraint);
		assertEquals(IStatus.ERROR, ConstraintService.INSTANCE.validate(xorConstraint, c1, monitor)
				.getSeverity());

		//
		// Two parameters
		//
		Constraint okConstraint2 = Equals.createExpression(
				CorePackage.Literals.DEPLOY_MODEL_OBJECT__DESCRIPTION, null);
		Constraint errorConstraint2 = Equals.createExpression(
				CorePackage.Literals.DEPLOY_MODEL_OBJECT__DESCRIPTION, descr);

		// ERROR xor OK = OK
		xorConstraint.getConstraints().clear();
		xorConstraint.getConstraints().add(errorConstraint);
		xorConstraint.getConstraints().add(okConstraint);
		assertEquals(IStatus.OK, ConstraintService.INSTANCE.validate(xorConstraint, c1, monitor)
				.getSeverity());

		// OK xor ERROR = OK
		xorConstraint.getConstraints().clear();
		xorConstraint.getConstraints().add(okConstraint);
		xorConstraint.getConstraints().add(errorConstraint);
		assertEquals(IStatus.OK, ConstraintService.INSTANCE.validate(xorConstraint, c1, monitor)
				.getSeverity());

		// OK xor OK = ERROR
		xorConstraint.getConstraints().clear();
		xorConstraint.getConstraints().add(okConstraint);
		xorConstraint.getConstraints().add(okConstraint2);
		assertEquals(IStatus.ERROR, ConstraintService.INSTANCE.validate(xorConstraint, c1, monitor)
				.getSeverity());

		// ERROR xor ERROR = ERROR
		xorConstraint.getConstraints().clear();
		xorConstraint.getConstraints().add(errorConstraint);
		xorConstraint.getConstraints().add(errorConstraint2);
		assertEquals(IStatus.ERROR, ConstraintService.INSTANCE.validate(xorConstraint, c1, monitor)
				.getSeverity());

		//
		// Three parameters
		//
		Constraint okConstraint3 = Equals.createExpression(
				CorePackage.Literals.DEPLOY_MODEL_OBJECT__DESCRIPTION, null);
		Constraint errorConstraint3 = Equals.createExpression(
				CorePackage.Literals.DEPLOY_MODEL_OBJECT__DESCRIPTION, descr);

		// OK or OK or OK = ERROR
		xorConstraint.getConstraints().clear();
		xorConstraint.getConstraints().add(okConstraint);
		xorConstraint.getConstraints().add(okConstraint2);
		xorConstraint.getConstraints().add(okConstraint3);
		assertEquals(IStatus.ERROR, ConstraintService.INSTANCE.validate(xorConstraint, c1, monitor)
				.getSeverity());

		// OK or OK or ERROR = ERROR
		xorConstraint.getConstraints().clear();
		xorConstraint.getConstraints().add(okConstraint);
		xorConstraint.getConstraints().add(okConstraint2);
		xorConstraint.getConstraints().add(errorConstraint3);
		assertEquals(IStatus.ERROR, ConstraintService.INSTANCE.validate(xorConstraint, c1, monitor)
				.getSeverity());

		// OK or ERROR or OK = ERROR
		xorConstraint.getConstraints().clear();
		xorConstraint.getConstraints().add(okConstraint);
		xorConstraint.getConstraints().add(errorConstraint2);
		xorConstraint.getConstraints().add(okConstraint3);
		assertEquals(IStatus.ERROR, ConstraintService.INSTANCE.validate(xorConstraint, c1, monitor)
				.getSeverity());

		// ERROR or OK or OK = ERROR
		xorConstraint.getConstraints().clear();
		xorConstraint.getConstraints().add(errorConstraint);
		xorConstraint.getConstraints().add(okConstraint2);
		xorConstraint.getConstraints().add(okConstraint3);
		assertEquals(IStatus.ERROR, ConstraintService.INSTANCE.validate(xorConstraint, c1, monitor)
				.getSeverity());

		// ERROR or OK or ERROR = OK
		xorConstraint.getConstraints().clear();
		xorConstraint.getConstraints().add(errorConstraint);
		xorConstraint.getConstraints().add(okConstraint2);
		xorConstraint.getConstraints().add(errorConstraint3);
		assertEquals(IStatus.OK, ConstraintService.INSTANCE.validate(xorConstraint, c1, monitor)
				.getSeverity());

		// ERROR or ERROR or ERROR = ERROR
		xorConstraint.getConstraints().clear();
		xorConstraint.getConstraints().add(errorConstraint);
		xorConstraint.getConstraints().add(errorConstraint2);
		xorConstraint.getConstraints().add(errorConstraint3);
		assertEquals(IStatus.ERROR, ConstraintService.INSTANCE.validate(xorConstraint, c1, monitor)
				.getSeverity());
	}
}
