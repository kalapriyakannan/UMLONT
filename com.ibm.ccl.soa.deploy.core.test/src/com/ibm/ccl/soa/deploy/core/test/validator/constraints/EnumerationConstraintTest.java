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
import java.util.List;

import org.eclipse.core.runtime.NullProgressMonitor;

import com.ibm.ccl.soa.deploy.core.Capability;
import com.ibm.ccl.soa.deploy.core.CapabilityLinkTypes;
import com.ibm.ccl.soa.deploy.core.CommunicationCapability;
import com.ibm.ccl.soa.deploy.core.CoreFactory;
import com.ibm.ccl.soa.deploy.core.Unit;
import com.ibm.ccl.soa.deploy.core.constraint.ConstraintFactory;
import com.ibm.ccl.soa.deploy.core.constraint.EnumerationConstraint;
import com.ibm.ccl.soa.deploy.core.constraint.SingleValue;
import com.ibm.ccl.soa.deploy.core.test.TopologyTestCase;
import com.ibm.ccl.soa.deploy.core.validator.ConstraintService;

public class EnumerationConstraintTest extends TopologyTestCase {

	public EnumerationConstraintTest() {
		super("EnumerationConstraintTest");
	}

	public void testEnumerationConstraintValidation() {
		assertMatch("port", "10", new String[] {"10","20","30"});  
		assertMatch("port", "10", new String[] {"","","10"});
		assertMatch("port", "10", new String[] {"10","10"});
		assertFail("port", "10", new String[] {});
		assertFail("port", "10", new String[] {""});
		assertFail("port", "10", new String[] {"0"});
		assertFail("port", "10", new String[] {"11"});
		assertFail("port", "10", new String[] {"11","20","100"});

		assertMatch("applicationLayerProtocol", "http", new String[] {"hhh","kkk","http"});
		assertMatch("applicationLayerProtocol", "http", new String[] {"http","hhh","kkk"});
		assertMatch("applicationLayerProtocol", null, new String[] {""});
		assertMatch("applicationLayerProtocol", null, new String[] {"",""});
		assertMatch("applicationLayerProtocol", "", new String[] {""});
		assertMatch("applicationLayerProtocol", "", new String[] {"",""});
		assertMatch("applicationLayerProtocol", null, new String[] {"","http"});
		assertMatch("applicationLayerProtocol", null, new String[] {"http",""});
		assertMatch("applicationLayerProtocol", "", new String[] {"","http"});
		assertMatch("applicationLayerProtocol", "", new String[] {"http", ""});
		assertFail("applicationLayerProtocol", "http", new String[] {});
		assertFail("applicationLayerProtocol", "http", new String[] {""});
		assertFail("applicationLayerProtocol", null, new String[] {"rmi","http"});
		assertFail("applicationLayerProtocol", "", new String[] {"rmi","http"});
		assertFail("applicationLayerProtocol", "http", new String[] {"https","rmi","jdbc"});
	}

	public void testSerialization() {
		// create Capability
		Unit unit = CoreFactory.eINSTANCE.createUnit();
		unit.setName("u0");
		Capability cap = CoreFactory.eINSTANCE.createCapability();
		cap.setName("cap0");
		unit.getCapabilities().add(cap);

		// create Enumeration Constraint
		EnumerationConstraint ec = ConstraintFactory.eINSTANCE.createEnumerationConstraint();
		ec.setName("c0");
		ec.setAttributeName("linkType");		
		List values = ec.getValues();
		SingleValue v = ConstraintFactory.eINSTANCE.createSingleValue();
		values.add(v);
		cap.getConstraints().add(ec);

		// create values
		String dependency = "dependency";
		String hosting = "hosting";
		CapabilityLinkTypes dependencyLinkType = CapabilityLinkTypes.getByName(dependency);
		CapabilityLinkTypes hostingLinkType = CapabilityLinkTypes.getByName(hosting);

		boolean result = v.setValueObject(dependencyLinkType);
		assert result;
		assert v.getValueObject() == dependencyLinkType;
		assert v.getValue().equals(dependency);
		
		v.setValue(hosting);
		assert v.getValue().equals(hosting);
		assert v.getValueObject().equals(hostingLinkType);
		
		ec.setAttributeName("description");
		assert v.getValue().equals(hosting);
		Object o = v.getValueObject();
		assert o instanceof String;
		assert o.equals(hosting);
	}

	private void assertMatch(String attributeName, String attributeValue,
			String[] legalValues) {
		EnumerationConstraint constraint = createEnumerationConstraint(
				attributeName, legalValues);
		Capability context = null;
		if (attributeName.equals("port"))
			context = createCommunicationCapability(new BigInteger(
					attributeValue));
		else {
			context = createCommunicationCapability(attributeValue);
		}
		assert ConstraintService.INSTANCE.validate(
				constraint, context, new NullProgressMonitor()).isOK();
	}

	private void assertFail(String attributeName, String attributeValue,
			String[] legalValues) {
		EnumerationConstraint constraint = createEnumerationConstraint(
				attributeName, legalValues);
		Capability context = null;
		if (attributeName.equals("port"))
			context = createCommunicationCapability(new BigInteger(
					attributeValue));
		else {
			context = createCommunicationCapability(attributeValue);
		}
		assert !ConstraintService.INSTANCE.validate(
				constraint, context, new NullProgressMonitor()).isOK();
	}

	private static EnumerationConstraint createEnumerationConstraint(
			String attribute, String[] legalValues) {
		EnumerationConstraint constraint = ConstraintFactory.eINSTANCE
				.createEnumerationConstraint();
		constraint.setAttributeName(attribute);
		List values = constraint.getValues();
		for (int i=0; i<legalValues.length; i++) {
			SingleValue v = ConstraintFactory.eINSTANCE.createSingleValue();
			v.setValue(legalValues[i]);
			values.add(v);
		}
		Unit unit = CoreFactory.eINSTANCE.createUnit();
		unit.setName("uconstraint0");
		unit.getConstraints().add(constraint);
		return constraint;
	}

	private static CommunicationCapability createCommunicationCapability(
			BigInteger port) {
		// need to create a unit
		Unit unit = CoreFactory.eINSTANCE.createUnit();
		unit.setName("ucc0");
		CommunicationCapability cap = CoreFactory.eINSTANCE
				.createCommunicationCapability();
		cap.setPort(port);
		unit.getCapabilities().add(cap);
		return cap;
	}

	private static CommunicationCapability createCommunicationCapability(
			String protocol) {
		// need to create a unit
		Unit unit = CoreFactory.eINSTANCE.createUnit();
		unit.setName("ucc1");
		CommunicationCapability cap = CoreFactory.eINSTANCE
				.createCommunicationCapability();
		if (protocol != null) {
			cap.setApplicationLayerProtocol(protocol);
		}
		unit.getCapabilities().add(cap);
		return cap;
	}
}
