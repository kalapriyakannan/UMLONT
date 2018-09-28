/*******************************************************************************
 * Copyright (c) 2003, 2007 IBM Corporation Licensed Material - Property of IBM. All rights reserved.
 *  
 * US Government Users Restricted Rights - Use, duplication or disclosure v1.0 restricted by GSA ADP
 * Schedule Contract with IBM Corp.
 * 
 * Contributors: IBM Corporation - initial API and implementation
 *******************************************************************************/
package com.ibm.ccl.soa.deploy.tests.core.ui.marker.resolution;

import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.NullProgressMonitor;

import com.ibm.ccl.soa.deploy.core.Capability;
import com.ibm.ccl.soa.deploy.core.CoreFactory;
import com.ibm.ccl.soa.deploy.core.Topology;
import com.ibm.ccl.soa.deploy.core.Unit;
import com.ibm.ccl.soa.deploy.core.validator.DeployValidatorService;
import com.ibm.ccl.soa.deploy.core.validator.resolution.IDeployResolution;
import com.ibm.ccl.soa.deploy.core.validator.status.ICoreProblemType;
import com.ibm.ccl.soa.deploy.internal.core.validator.resolution.NameNotUniqueResolution;

/**
 * Tests {@link NameNotUniqueMarkerResolution}.
 */
public class NameNotUniqueMarkerResolutionTest extends ResolutionTestCase {
	public static final String PROJECT_NAME = "NameNotUniqueMarkerResolutionTest";

	public NameNotUniqueMarkerResolutionTest() {
		super(PROJECT_NAME);
	}

	public void testNameNotUnique() throws Exception {
		// Create model
		Topology top = createTopology("testNameNotUnique", true);
		Unit unit = CoreFactory.eINSTANCE.createUnit();
		unit.setName("unit");
		top.getUnits().add(unit);

		Capability s1 = CoreFactory.eINSTANCE.createCapability();
		s1.setName("service");
		unit.getOnlyDependencyCapabilities().add(s1);

		Capability s2 = CoreFactory.eINSTANCE.createCapability();
		s2.setName("service");
		unit.getOnlyDependencyCapabilities().add(s2);

		top.getEObject().eResource().save(null);

		DeployValidatorService service = DeployValidatorService.getDefaultValidatorService();
		service.validate(top);

		assertHasDeployStatus(s1, ICoreProblemType.OBJECT_ATTRIBUTE_NOT_UNIQUE,
				IStatus.ERROR);
		assertHasDeployStatus(s2, ICoreProblemType.OBJECT_ATTRIBUTE_NOT_UNIQUE,
				IStatus.ERROR);

		IDeployResolution[] resolutions = this.getDeployResolutions(s1
				.getStatus(), NameNotUniqueResolution.class);
		assert resolutions.length == 1 : resolutions.length;

		resolutions[0].resolve(new NullProgressMonitor());
		assert !s1.getName().equals(s2.getName());

		service.validate(top);

		assert s1.getStatus().getSeverity() == IStatus.OK;
		assert s2.getStatus().getSeverity() == IStatus.OK;
	}
}
