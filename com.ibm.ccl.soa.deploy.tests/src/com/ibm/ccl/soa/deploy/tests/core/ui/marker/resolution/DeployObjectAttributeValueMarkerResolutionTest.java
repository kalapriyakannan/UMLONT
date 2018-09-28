/*******************************************************************************
 * Copyright (c) 2003, 2007 IBM Corporation Licensed Material - Property of IBM. All rights reserved.
 *  
 * US Government Users Restricted Rights - Use, duplication or disclosure v1.0 restricted by GSA ADP
 * Schedule Contract with IBM Corp.
 * 
 * Contributors: IBM Corporation - initial API and implementation
 *******************************************************************************/
package com.ibm.ccl.soa.deploy.tests.core.ui.marker.resolution;

import org.eclipse.core.resources.IMarker;
import org.eclipse.core.runtime.IStatus;

import com.ibm.ccl.soa.deploy.core.CoreFactory;
import com.ibm.ccl.soa.deploy.core.CorePackage;
import com.ibm.ccl.soa.deploy.core.Topology;
import com.ibm.ccl.soa.deploy.core.Unit;
import com.ibm.ccl.soa.deploy.core.test.TopologyTestCase;
import com.ibm.ccl.soa.deploy.core.validator.status.DeployCoreStatusFactory;
import com.ibm.ccl.soa.deploy.core.validator.status.ICoreProblemType;
import com.ibm.ccl.soa.deploy.core.validator.status.IDeployAttributeValueStatus;

/**
 * Tests {@link DeployObjectAttributeValueMarkerResolution}.
 */
public class DeployObjectAttributeValueMarkerResolutionTest extends
		TopologyTestCase {
	public static final String PROJECT_NAME = "DeployObjectAttributeValueMarkerResolutionTest";

	public DeployObjectAttributeValueMarkerResolutionTest() {
		super(PROJECT_NAME);
	}

	public void testExpectedValueResolution() throws Exception {
		// Create model
		Topology top = createTopology("testExpectedValueResolution", true);
		Unit unit = CoreFactory.eINSTANCE.createUnit();
		unit.setName("unit");
		top.getUnits().add(unit);
		top.getEObject().eResource().save(null);

		// Create message & marker
		IDeployAttributeValueStatus message = DeployCoreStatusFactory.INSTANCE
				.createAttributeValueStatus(IStatus.ERROR, "TEST",
						ICoreProblemType.OBJECT_ATTRIBUTE_INVALID, null, null,
						unit, CorePackage.eINSTANCE
								.getDeployModelObject_Description(), "1.0");
		IMarker marker = message.createMarker();

		// Resolve marker
		// TODO test
		// DeployObjectAttributeValueMarkerResolution resolution = new
		// DeployObjectAttributeValueMarkerResolution(maker);
		// assert unit.getVersion() == null;
		// resolution.run(marker, top, new NullProgressMonitor());
		// assert unit.getVersion() != null;
		// assert unit.getVersion().equals("1.0");
	}
}
