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
import com.ibm.ccl.soa.deploy.core.CoreFactory;
import com.ibm.ccl.soa.deploy.core.Unit;
import com.ibm.ccl.soa.deploy.core.constraint.ConstraintFactory;
import com.ibm.ccl.soa.deploy.core.constraint.VersionConstraint;
import com.ibm.ccl.soa.deploy.core.test.TopologyTestCase;
import com.ibm.ccl.soa.deploy.core.validator.ConstraintService;

public class VersionConstraintTest extends TopologyTestCase {

	public VersionConstraintTest() {
		super("VersionConstraintTest");
	}

	public void testVersion() {
		assertFail(null, "1.0");
		assertFail("1.1+", null);

		assertMatch("1", "1");
		assertMatch("1.x", "1");
		assertFail("1.x", "2");
		assertMatch("1.x", "1.1");
		assertMatch("1.x", "1.1b");
		assertMatch("1.x", "1.9");
		assertMatch("1.x", "1.9.1");
		assertMatch("1.x", "1.1.0");
		assertMatch("1.1+", "1.1.0");
		assertMatch("1.1+", "1.2");
		assertFail("1.1+", "1.0");
		assertMatch("1.x", "1.0b");
		assertFail("1.1+", "1.0.12");
		assertMatch("1.1.2.x", "1.1.2");
		assertMatch("1.1.2.x", "1.1.2.1");
		assertMatch("1.100+", "1.101");
		assertFail("1.100+", "1.2");
		assertFail("1.100+", "1.2c");
		assertMatch("1.1+", "1.1");
		assertMatch("1.1+", "2.0");
		assertMatch("1.1+", "3.14b");
		assertFail("2.1+", "1");

		assertFail("2.1.3", "");
		assertFail("2.1.3", "2");
		assertFail("2.1.3", "2.1");
		assertFail("2.1.3", "2.1.");
		assertFail("2.1.", "2");
		assertMatch("2.1.", "2.1");
		assertMatch("2.1.", "2.1.");
		assertFail("2+", "");
		assertFail("2.1+", "2");
		assertFail("2.1+", "2.");
		assertMatch("6.0", "6.0.0.1");
	}

	private void assertMatch(String pattern, String version) {
		VersionConstraint constraint = createVersionConstraint("buildVersion",
				pattern);
		Capability context = createCapability(version);
		assert ConstraintService.INSTANCE.validate(constraint,
				context, new NullProgressMonitor()).isOK();
	}

	private void assertFail(String pattern, String version) {
		VersionConstraint constraint = createVersionConstraint("buildVersion",
				pattern);
		Capability context = createCapability(version);
		assert !ConstraintService.INSTANCE.validate(constraint,
				context, new NullProgressMonitor()).isOK();
	}

	public static VersionConstraint createVersionConstraint(String attribute,
			String value) {
		VersionConstraint constraint = ConstraintFactory.eINSTANCE
				.createVersionConstraint();
		constraint.setAttributeName(attribute);
		constraint.setValue(value);
		Unit unit = CoreFactory.eINSTANCE.createUnit();
		unit.setName("uconstraint0");
		unit.getConstraints().add(constraint);
		return constraint;
	}

	private static Capability createCapability(String buildVersion) {
		// need to create a unit
		Unit unit = CoreFactory.eINSTANCE.createUnit();
		Capability cap = CoreFactory.eINSTANCE.createCapability();
		cap.setBuildVersion(buildVersion);
		unit.getCapabilities().add(cap);
		return cap;
	}
}
