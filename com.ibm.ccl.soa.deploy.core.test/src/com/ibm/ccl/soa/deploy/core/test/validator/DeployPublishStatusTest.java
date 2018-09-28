/*******************************************************************************
 * Copyright (c) 2003, 2006 IBM Corporation Licensed Material - Property of IBM. All rights reserved.
 *  
 * US Government Users Restricted Rights - Use, duplication or disclosure v1.0 restricted by GSA ADP
 * Schedule Contract with IBM Corp.
 * 
 * Contributors: IBM Corporation - initial API and implementation
 *******************************************************************************/
package com.ibm.ccl.soa.deploy.core.test.validator;

import org.eclipse.core.runtime.IStatus;

import com.ibm.ccl.soa.deploy.core.CoreFactory;
import com.ibm.ccl.soa.deploy.core.Topology;
import com.ibm.ccl.soa.deploy.core.Unit;
import com.ibm.ccl.soa.deploy.core.test.TopologyTestCase;
import com.ibm.ccl.soa.deploy.core.validator.DeployValidatorService;
import com.ibm.ccl.soa.deploy.core.validator.ValidatorUtils;
import com.ibm.ccl.soa.deploy.core.validator.status.DeployCoreStatusFactory;
import com.ibm.ccl.soa.deploy.core.validator.status.IDeployPublishStatus;

/**
 * Test {@link IDeployPublishStatus}
 */
public class DeployPublishStatusTest extends TopologyTestCase {

	public DeployPublishStatusTest() {
		super("DeployPublishStatusTest");
	}

	public void testPublisherStatus() throws Exception {
		Topology top = createTopology("testPublisherStatus", true);

		Unit unit = CoreFactory.eINSTANCE.createUnit();
		unit.setName("unit");
		top.getUnits().add(unit);

		assert unit.getStatus().isOK();

		String publisher = "test publisher";
		Exception exception = new Exception("publish exception");
		IDeployPublishStatus status = DeployCoreStatusFactory.INSTANCE
				.createPublisherStatus(IStatus.ERROR, publisher,
						"test problem", "Unit {0} publish problem",
						new String[] { unit.getName() }, exception, unit);
		unit.addStatus(status);
		assert !status.isPersistent();
		assert status.getPublisher().equals(publisher);
		assert unit.getStatus() == status;
		assert !unit.getStatus().isOK();

		// Test interaction with validation service (make sure that
		// the validator does not clear our status).
		DeployValidatorService validator = new DeployValidatorService();
		validator.validate(top);
		assert !unit.getStatus().isOK();
		super.assertHasDeployStatus(status.getDeployObject(), status
				.getProblemType(), status.getSeverity());

		ValidatorUtils.clearPublishStatus(top);
		assert !(unit.getStatus() instanceof IDeployPublishStatus);
		if (unit.getStatus().isMultiStatus()) {
			IStatus[] children = unit.getStatus().getChildren();
			for (int i = 0; i < children.length; i++) {
				assert !(children[i] instanceof IDeployPublishStatus);
			}
		}
	}
}
