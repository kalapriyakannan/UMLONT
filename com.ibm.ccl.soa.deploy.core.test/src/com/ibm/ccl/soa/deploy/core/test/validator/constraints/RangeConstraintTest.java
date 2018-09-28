/*******************************************************************************
 * Copyright (c) 2003, 2007 IBM Corporation Licensed Material - Property of IBM. All rights reserved.
 *  
 * US Government Users Restricted Rights - Use, duplication or disclosure v1.0 restricted by GSA ADP
 * Schedule Contract with IBM Corp.
 * 
 * Contributors: IBM Corporation - initial API and implementation
 *******************************************************************************/
package com.ibm.ccl.soa.deploy.core.test.validator.constraints;

import java.math.BigInteger;

import org.eclipse.core.runtime.NullProgressMonitor;

import com.ibm.ccl.soa.deploy.core.Capability;
import com.ibm.ccl.soa.deploy.core.CapabilityLinkTypes;
import com.ibm.ccl.soa.deploy.core.CommunicationCapability;
import com.ibm.ccl.soa.deploy.core.CoreFactory;
import com.ibm.ccl.soa.deploy.core.Unit;
import com.ibm.ccl.soa.deploy.core.constraint.ConstraintFactory;
import com.ibm.ccl.soa.deploy.core.constraint.RangeConstraint;
import com.ibm.ccl.soa.deploy.core.test.TopologyTestCase;
import com.ibm.ccl.soa.deploy.core.validator.ConstraintService;

public class RangeConstraintTest extends TopologyTestCase {
	
	private static final int PORT = 0;
	private static final int DESCRIPTION = 1;
	
	private static final String[] LITERALS = new String[] {"port", "description"};

	public RangeConstraintTest() {
		super("RangeConstraintTest");
	}
	
	public void testSerialization() {
		// create Capability
		Unit unit = CoreFactory.eINSTANCE.createUnit();
		unit.setName("u0");
		Capability cap = CoreFactory.eINSTANCE.createCapability();
		cap.setName("cap0");
		unit.getCapabilities().add(cap);

		// create Range constraint
		RangeConstraint rc = ConstraintFactory.eINSTANCE.createRangeConstraint();
		rc.setName("c0");
		rc.setAttributeName("linkType");
		cap.getConstraints().add(rc);
		
		String dependency = "dependency";
		String hosting = "hosting";
		CapabilityLinkTypes dependencyLinkType = CapabilityLinkTypes.getByName(dependency);
		CapabilityLinkTypes hostingLinkType = CapabilityLinkTypes.getByName(hosting);

		boolean result = rc.setMinValueObject(dependencyLinkType);
		assert result;
		assert rc.getMinValueObject() == dependencyLinkType;
		assert rc.getMinValue().equals(dependency);
		
		rc.setMinValue(hosting);
		assert rc.getMinValue().equals(hosting);
		assert rc.getMinValueObject().equals(hostingLinkType);
		
		rc.setAttributeName("description");
		assert rc.getMinValue().equals(hosting);
		Object o = rc.getMinValueObject();
		assert o instanceof String;
		assert o.equals(hosting);
	}

	public void testRangeConstraintValidation() {
		assertMatch("10", null, null, true, true, PORT);
		assertMatch("10", null, null, false, false, PORT);
		assertMatch("10", "5", null, false, false, PORT);
		assertMatch("10", null, "12", false, false, PORT);
		assertMatch("10", "5", "12", false, false, PORT);
		assertMatch("10", "10", "12", true, false, PORT);
		assertMatch("10", "8", "10", false, true, PORT);
		assertMatch("10", "10", "10", true, true, PORT);

		assertFail("10", "12", null, false, false, PORT);
		assertFail("10", "10", null, false, false, PORT);
		assertFail("10", null, "10", false, false, PORT);
		assertFail("10", "2", "10", false, false, PORT);
	}

	public void testRangeConstraintOnStringValidation() {
		assertMatch("12345", null, null, true, true, DESCRIPTION);
		assertMatch("12345", null, null, false, false, DESCRIPTION);
		assertMatch("12345", "3", null, false, false, DESCRIPTION);
		assertMatch("12345", null, "8", false, false, DESCRIPTION);
		assertMatch("12345", "3", "8", false, false, DESCRIPTION);
		assertMatch("12345", "5", "8", true, false, DESCRIPTION);
		assertMatch("12345", "3", "5", false, true, DESCRIPTION);
		assertMatch("12345", "5", "5", true, true, DESCRIPTION);

		assertFail("12345", "8", null, false, false, DESCRIPTION);
		assertFail("12345", "5", null, false, false, DESCRIPTION);
		assertFail("12345", null, "5", false, false, DESCRIPTION);
		assertFail("12345", "2", "5", false, false, DESCRIPTION);
	}

	private void assertMatch(String attributeValue, String minValue, 
			String maxValue, 
			boolean minValueInclusive, 
			boolean maxValueInclusive, int attribute) {
		RangeConstraint constraint = createRangeConstraint(minValue, maxValue, minValueInclusive, 
				maxValueInclusive, attribute);
		Capability context = createCommunicationCapability(attributeValue, attribute);
		assert ConstraintService.INSTANCE.validate(constraint,
				context, new NullProgressMonitor()).isOK();
	}

	private void assertFail(String attributeValue, String minValue, 
			String maxValue, 
			boolean minValueInclusive, 
			boolean maxValueInclusive, int attribute) {
		RangeConstraint constraint = createRangeConstraint(minValue, maxValue, minValueInclusive, 
				maxValueInclusive, attribute);
		Capability context = createCommunicationCapability(attributeValue, attribute);
		assert !ConstraintService.INSTANCE.validate(constraint,
				context, new NullProgressMonitor()).isOK();
	}

	private static RangeConstraint createRangeConstraint(String minValue, 
						String maxValue, 
						boolean minValueInclusive, 
						boolean maxValueInclusive, int attribute) {
		RangeConstraint constraint = ConstraintFactory.eINSTANCE.createRangeConstraint();
		constraint.setAttributeName(LITERALS[attribute]);
		constraint.setMinValue(minValue);
		constraint.setMaxValue(maxValue);
		constraint.setMinValueInclusive(minValueInclusive);
		constraint.setMaxValueInclusive(maxValueInclusive);
		Unit unit = CoreFactory.eINSTANCE.createUnit();
		unit.setName("uconstraint0");
		unit.getConstraints().add(constraint);
		return constraint;
	}

	private static CommunicationCapability createCommunicationCapability(
			String value, int attribute) {
		// need to create a unit
		Unit unit = CoreFactory.eINSTANCE.createUnit();
		CommunicationCapability cap = CoreFactory.eINSTANCE
				.createCommunicationCapability();
		switch (attribute) {
		case PORT:			
			cap.setPort(new BigInteger(value));
			break;
		case DESCRIPTION:			
			cap.setDescription(value);
			break;
		}
		unit.getCapabilities().add(cap);
		return cap;
	}
}
