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

import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;

import com.ibm.ccl.soa.deploy.core.CoreFactory;
import com.ibm.ccl.soa.deploy.core.CorePackage;
import com.ibm.ccl.soa.deploy.core.InstallState;
import com.ibm.ccl.soa.deploy.core.Topology;
import com.ibm.ccl.soa.deploy.core.Unit;
import com.ibm.ccl.soa.deploy.core.test.TopologyTestCase;
import com.ibm.ccl.soa.deploy.core.validator.status.DeployCoreStatusFactory;
import com.ibm.ccl.soa.deploy.core.validator.status.IDeployAttributeValueStatus;
import com.ibm.ccl.soa.deploy.core.validator.status.IDeployStatus;

/**
 * Test {@link IDeployStatus}.
 * 
 */
public class DeployStatusTest extends TopologyTestCase {

	public DeployStatusTest() {
		super("DeployStatusTest");
	}

	public void testAttributeValueSerialization() throws Exception {
		Topology top = createTopology("testAttributeValueSerialization");

		Unit unit = CoreFactory.eINSTANCE.createUnit();
		unit.setName("unit");

		top.getUnits().add(unit);

		IDeployAttributeValueStatus stringValueStatus = DeployCoreStatusFactory.INSTANCE
				.createAttributeValueStatus(IStatus.ERROR, "TEST", "TEST",
						"TEST", null, unit, CorePackage.eINSTANCE
								.getUnit_Origin(), "Test Origin");
		stringValueStatus.getAttributeExpectedValue().equals("Test Origin");

		IDeployAttributeValueStatus booleanValueStatus = DeployCoreStatusFactory.INSTANCE
				.createAttributeValueStatus(IStatus.ERROR, "TEST", "TEST",
						"TEST", null, unit, CorePackage.eINSTANCE
								.getUnit_ConfigurationUnit(), Boolean.FALSE);
		booleanValueStatus.getAttributeExpectedValue().equals(Boolean.FALSE);

		IDeployAttributeValueStatus enumValueStatus = DeployCoreStatusFactory.INSTANCE
				.createAttributeValueStatus(IStatus.ERROR, "TEST", "TEST",
						"TEST", null, unit, CorePackage.eINSTANCE
								.getUnit_InitInstallState(),
						InstallState.INSTALLED_LITERAL);
		enumValueStatus.getAttributeExpectedValue().equals(
				InstallState.INSTALLED_LITERAL);

	}

	public void testDmoStatus() throws IOException {
		Topology top = createTopology("testDmoStatus");
		Unit unit = addUnit(top, "unit");
		assertTrue(unit.getStatus().isOK());
		assertEquals(Status.OK_STATUS, unit.getStatus());
		IDeployAttributeValueStatus status = DeployCoreStatusFactory.INSTANCE
				.createAttributeValueStatus(IStatus.ERROR, "TEST", "TEST",
						"TEST", null, unit, CorePackage.eINSTANCE
								.getUnit_Origin(), "Test Origin");
		unit.addStatus(status);
		assertTrue(!unit.getStatus().isOK());
		assertEquals(status, unit.getStatus());
		assertHasErrorStatus(top);
		save(top);
		assertTrue(!unit.getStatus().isOK());
		assertEquals(status, unit.getStatus());
	}
}
