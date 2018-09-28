/*******************************************************************************
 * Copyright (c) 2003, 2007 IBM Corporation Licensed Material - Property of IBM. All rights reserved.
 *  
 * US Government Users Restricted Rights - Use, duplication or disclosure v1.0 restricted by GSA ADP
 * Schedule Contract with IBM Corp.
 * 
 * Contributors: IBM Corporation - initial API and implementation
 *******************************************************************************/
package com.ibm.ccl.soa.deploy.core.test.validator.constraints;

import org.eclipse.core.runtime.NullProgressMonitor;

import com.ibm.ccl.soa.deploy.core.Capability;
import com.ibm.ccl.soa.deploy.core.CapabilityLinkTypes;
import com.ibm.ccl.soa.deploy.core.CoreFactory;
import com.ibm.ccl.soa.deploy.core.Unit;
import com.ibm.ccl.soa.deploy.core.constraint.ConstraintFactory;
import com.ibm.ccl.soa.deploy.core.constraint.EqualsConstraint;
import com.ibm.ccl.soa.deploy.core.test.TopologyTestCase;
import com.ibm.ccl.soa.deploy.core.validator.ConstraintService;

public class EqualsConstraintTest extends TopologyTestCase {

	public EqualsConstraintTest() {
		super("EqualsConstraintTest");
	}

	public void testEquals() {
		assertFail(null, "aaa");
		assertFail("", "aaa");
		assertFail("aaa", "bbb");
		assertFail("aaa", "");
		assertFail("aaa", null);

		assertMatch("aaa", "aaa");
		assertMatch("", "");
		assertMatch(null, null);
		assertMatch("", null);
		assertMatch(null, "");
	}
	
	public void testSerialization() {
		// create Capability
		Capability context = createCapability("descr");

		// create Equals constraint
		EqualsConstraint ec = createEqualsConstraint("linkType", null);
		context.getConstraints().add(ec);
		
		String dependency = "dependency";
		String hosting = "hosting";
		CapabilityLinkTypes dependencyLinkType = CapabilityLinkTypes.getByName(dependency);
		CapabilityLinkTypes hostingLinkType = CapabilityLinkTypes.getByName(hosting);

		boolean result = ec.setValueObject(dependencyLinkType);
		assert result;
		assert ec.getValueObject() == dependencyLinkType;
		assert ec.getValue().equals(dependency);
		
		ec.setValue(hosting);
		assert ec.getValue().equals(hosting);
		assert ec.getValueObject().equals(hostingLinkType);
		
		ec.setAttributeName("description");
		assert ec.getValue().equals(hosting);
		Object o = ec.getValueObject();
		assert o instanceof String;
		assert o.equals(hosting);
	}
	

	private void assertMatch(String value, String description) {
		EqualsConstraint constraint = createEqualsConstraint("description",
				value);
		Capability context = createCapability(description);
		assert ConstraintService.INSTANCE.validate(constraint,
				context, new NullProgressMonitor()).isOK();
	}

	private void assertFail(String value, String description) {
		EqualsConstraint constraint = createEqualsConstraint("description",
				value);
		Capability context = createCapability(description);
		assert !ConstraintService.INSTANCE.validate(constraint,
				context, new NullProgressMonitor()).isOK();
	}

	public static EqualsConstraint createEqualsConstraint(String attribute,
			String value) {
		EqualsConstraint constraint = ConstraintFactory.eINSTANCE
				.createEqualsConstraint();
		constraint.setName("c0");
		constraint.setAttributeName(attribute);
		constraint.setValue(value);
		Unit unit = CoreFactory.eINSTANCE.createUnit();
		unit.setName("uconstraint0");
		unit.getConstraints().add(constraint);
		return constraint;
	}

	private static Capability createCapability(String description) {
		// need to create a unit
		Unit unit = CoreFactory.eINSTANCE.createUnit();
		unit.setName("u0");
		Capability cap = CoreFactory.eINSTANCE.createCapability();
		cap.setName("cap0");
		cap.setDescription(description);
		unit.getCapabilities().add(cap);
		return cap;
	}
}
