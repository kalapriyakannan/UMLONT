/*******************************************************************************
 * Copyright (c) 2003, 2007 IBM Corporation Licensed Material - Property of IBM. All rights reserved.
 *  
 * US Government Users Restricted Rights - Use, duplication or disclosure v1.0 restricted by GSA ADP
 * Schedule Contract with IBM Corp.
 * 
 * Contributors: IBM Corporation - initial API and implementation
 *******************************************************************************/
package com.ibm.ccl.soa.deploy.core.test.validator.resolution;

import org.eclipse.core.runtime.NullProgressMonitor;

import com.ibm.ccl.soa.deploy.core.CoreFactory;
import com.ibm.ccl.soa.deploy.core.CorePackage;
import com.ibm.ccl.soa.deploy.core.Topology;
import com.ibm.ccl.soa.deploy.core.Unit;
import com.ibm.ccl.soa.deploy.core.test.TopologyTestCase;
import com.ibm.ccl.soa.deploy.core.validator.resolution.IDeployResolutionContext;
import com.ibm.ccl.soa.deploy.core.validator.status.DeployCoreStatusFactory;
import com.ibm.ccl.soa.deploy.core.validator.status.IDeployStatus;
import com.ibm.ccl.soa.deploy.internal.core.validator.resolution.DeployResolutionContext;

public class RandomNameResolutionGeneratorTest extends TopologyTestCase {

	public RandomNameResolutionGeneratorTest() {
		super("RandomNameResolutionTest");
	}

	public void testResolution() throws Exception {
		Topology top = createTopology("testResolution");

		Unit unit = CoreFactory.eINSTANCE.createUnit();
		unit.setName("unit");
		top.getUnits().add(unit);

		IDeployStatus status = DeployCoreStatusFactory.INSTANCE
				.createAttributeStatus("test", unit, CorePackage.eINSTANCE
						.getDeployModelObject_Name());
		unit.addStatus(status);

		RandomNameResolutionGenerator generator = new RandomNameResolutionGenerator();
		IDeployResolutionContext context = new DeployResolutionContext(status,
				null, null);
		generator.getResolutions(context)[0].resolve(new NullProgressMonitor());
		assert !unit.getName().equals("unit");
	}
}
