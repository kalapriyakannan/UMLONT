/*******************************************************************************
 * Copyright (c) 2003, 2007 IBM Corporation Licensed Material - Property of IBM. All rights reserved.
 *  
 * US Government Users Restricted Rights - Use, duplication or disclosure v1.0 restricted by GSA ADP
 * Schedule Contract with IBM Corp.
 * 
 * Contributors: IBM Corporation - initial API and implementation
 *******************************************************************************/
package com.ibm.ccl.soa.deploy.core.test.extension;

import com.ibm.ccl.soa.deploy.core.CoreFactory;
import com.ibm.ccl.soa.deploy.core.CorePackage;
import com.ibm.ccl.soa.deploy.core.Topology;
import com.ibm.ccl.soa.deploy.core.Unit;
import com.ibm.ccl.soa.deploy.core.test.TopologyTestCase;
import com.ibm.ccl.soa.deploy.core.test.validator.resolution.RandomNameResolutionGenerator;
import com.ibm.ccl.soa.deploy.core.validator.resolution.IDeployResolutionGenerator;
import com.ibm.ccl.soa.deploy.core.validator.status.DeployCoreStatusFactory;
import com.ibm.ccl.soa.deploy.core.validator.status.IDeployAttributeStatus;
import com.ibm.ccl.soa.deploy.core.validator.status.IDeployStatus;
import com.ibm.ccl.soa.deploy.internal.core.extension.ResolutionGeneratorDescriptor;
import com.ibm.ccl.soa.deploy.internal.core.extension.ResolutionGeneratorManager;

public class ResolutionManagerTest extends TopologyTestCase {
	public ResolutionManagerTest() {
		super("ResolutionManagerTest");
	}

	public void testManager() {
		ResolutionGeneratorManager manager = ResolutionGeneratorManager
				.getInstance();
		ResolutionGeneratorDescriptor[] descriptors = manager
				.getResolutionGeneratorDescriptors();
		assert descriptors.length > 0;
		ResolutionGeneratorDescriptor randomNameDescriptor = manager
				.getResolutionDescriptor("com.ibm.ccl.soa.deploy.core.test.DeployModelObject.name.setRandom");
		assert randomNameDescriptor != null;
		IDeployResolutionGenerator generator = randomNameDescriptor
				.getResolutionGenerator();
		assert generator != null;

		Topology top = createTopology("testManager");
		Unit unit = CoreFactory.eINSTANCE.createUnit();
		unit.setName("name");
		top.getUnits().add(unit);

		IDeployStatus deployMessage = DeployCoreStatusFactory.INSTANCE
				.createDeployStatus("test", top);
		assert !randomNameDescriptor.isEnabled(deployMessage);

		IDeployAttributeStatus deployAttributeMessage = DeployCoreStatusFactory.INSTANCE
				.createAttributeStatus("test", unit, CorePackage.eINSTANCE
						.getDeployModelObject_Name());
		assert !randomNameDescriptor.isEnabled(deployAttributeMessage);

		unit.setName(RandomNameResolutionGenerator.MAGIC_BAD_NAME);
		assert randomNameDescriptor.isEnabled(deployAttributeMessage);
	}
}
