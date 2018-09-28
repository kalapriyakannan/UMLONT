/*******************************************************************************
 * Copyright (c) 2003, 2006 IBM Corporation Licensed Material - Property of IBM. All rights reserved.
 *  
 * US Government Users Restricted Rights - Use, duplication or disclosure v1.0 restricted by GSA ADP
 * Schedule Contract with IBM Corp.
 * 
 * Contributors: IBM Corporation - initial API and implementation
 *******************************************************************************/
package com.ibm.ccl.soa.deploy.core.test.validator.resolution;

import org.eclipse.core.runtime.IStatus;

import com.ibm.ccl.soa.deploy.core.CoreFactory;
import com.ibm.ccl.soa.deploy.core.Topology;
import com.ibm.ccl.soa.deploy.core.Unit;
import com.ibm.ccl.soa.deploy.core.test.TopologyTestCase;
import com.ibm.ccl.soa.deploy.core.validator.status.DeployCoreStatusFactory;
import com.ibm.ccl.soa.deploy.core.validator.status.IDeployStatus;
import com.ibm.ccl.soa.deploy.internal.core.extension.ResolutionGeneratorDescriptor;
import com.ibm.ccl.soa.deploy.internal.core.extension.ResolutionGeneratorManager;

/**
 * Tests {@link DeployStatusPropertyTester}.
 */
public class DeployStatusPropertyTesterTest extends TopologyTestCase {

	public DeployStatusPropertyTesterTest() {
		super("DeployAttributeTester");
	}

	public void testStatusMatch() throws Exception {
		Topology top = createTopology("testStatusAttribute");

		Unit unit = CoreFactory.eINSTANCE.createUnit();
		unit.setName("unit");
		top.getUnits().add(unit);

		IDeployStatus status = DeployCoreStatusFactory.INSTANCE
				.createDeployStatus(
						IStatus.ERROR,
						"test",
						"com.ibm.ccl.soa.deploy.core.test.validator.resolution.ProblemTypeFilterTest",
						"mymessage", null, unit);

		ResolutionGeneratorDescriptor[] descriptors = ResolutionGeneratorManager
				.getInstance().getResolutionGeneratorDescriptors(status);
		int count = 0;
		for (int i = 0; i < descriptors.length; i++) {
			if ("ProblemTypeFilterTest".equals(descriptors[i].getId())) {
				assert descriptors[i].isEnabled(status);
				count++;
			}
		}
		assert count == 1;
	}
}
