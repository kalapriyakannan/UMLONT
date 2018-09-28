/*******************************************************************************
 * Copyright (c) 2003, 2007 IBM Corporation Licensed Material - Property of IBM. All rights reserved.
 *  
 * US Government Users Restricted Rights - Use, duplication or disclosure v1.0 restricted by GSA ADP
 * Schedule Contract with IBM Corp.
 * 
 * Contributors: IBM Corporation - initial API and implementation
 *******************************************************************************/
package com.ibm.ccl.soa.deploy.core.test.validator.resolution;

import org.eclipse.core.runtime.IStatus;

import com.ibm.ccl.soa.deploy.core.CoreFactory;
import com.ibm.ccl.soa.deploy.core.CorePackage;
import com.ibm.ccl.soa.deploy.core.Topology;
import com.ibm.ccl.soa.deploy.core.Unit;
import com.ibm.ccl.soa.deploy.core.test.TopologyTestCase;
import com.ibm.ccl.soa.deploy.core.validator.status.DeployCoreStatusFactory;
import com.ibm.ccl.soa.deploy.core.validator.status.IDeployAttributeStatus;
import com.ibm.ccl.soa.deploy.internal.core.extension.ResolutionGeneratorDescriptor;
import com.ibm.ccl.soa.deploy.internal.core.extension.ResolutionGeneratorManager;
import com.ibm.ccl.soa.deploy.internal.core.validator.resolution.DeployObjectPropertyTester;

/**
 * Tests {@link DeployObjectPropertyTester}.
 */
public class DeployObjectPropertyTesterTest extends TopologyTestCase {

	public DeployObjectPropertyTesterTest() {
		super("DeployAttributeTester");
	}

	public void testStatusAttribute() throws Exception {
		Topology top = createTopology("testStatusAttribute");

		Unit unit = CoreFactory.eINSTANCE.createUnit();
		// magic name
		unit
				.setName("com.ibm.ccl.soa.deploy.core.test.validator.resolution.RandomNameResolutionGenerator");
		top.getUnits().add(unit);

		IDeployAttributeStatus status = DeployCoreStatusFactory.INSTANCE
				.createAttributeStatus(IStatus.ERROR, "test",
						DeployObjectPropertyTesterTest.class.getName(),
						"mymessage", null, unit, CorePackage.eINSTANCE
								.getDeployModelObject_Name());

		ResolutionGeneratorDescriptor[] descriptors = ResolutionGeneratorManager
				.getInstance().getResolutionGeneratorDescriptors(status);
		int count = 0;
		for (int i = 0; i < descriptors.length; i++) {
			if ("DeployModelObject.name.setRandom".equals(descriptors[i]
					.getId())) {
				assert descriptors[i].isEnabled(status);
				count++;
			}
		}
		assert count == 1;
	}
}
