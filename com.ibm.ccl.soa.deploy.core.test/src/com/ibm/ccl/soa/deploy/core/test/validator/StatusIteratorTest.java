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
import org.eclipse.core.runtime.Status;

import com.ibm.ccl.soa.deploy.core.CoreFactory;
import com.ibm.ccl.soa.deploy.core.DeployCorePlugin;
import com.ibm.ccl.soa.deploy.core.Unit;
import com.ibm.ccl.soa.deploy.core.test.TopologyTestCase;
import com.ibm.ccl.soa.deploy.core.validator.status.StatusIterator;

public class StatusIteratorTest extends TopologyTestCase {
	public StatusIteratorTest() {
		super("StatusFilterTest");
	}

	public void testStatusFilter() throws Exception {
		Unit unit = CoreFactory.eINSTANCE.createUnit();
		unit.setName("unit");
		assertSetEquals(new StatusIterator(unit),
				new Object[] { Status.OK_STATUS });

		IStatus errorStatus = new Status(IStatus.ERROR,
				DeployCorePlugin.PLUGIN_ID, 1, "test error1", null);
		unit.addStatus(errorStatus);
		assertSetEquals(new StatusIterator(unit), new Object[] { errorStatus });

		IStatus errorStatus2 = new Status(IStatus.ERROR,
				DeployCorePlugin.PLUGIN_ID, 2, "test error2", null);
		unit.addStatus(errorStatus2);
		assertSetEquals(new StatusIterator(unit), new Object[] {
				unit.getStatus(), errorStatus, errorStatus2 });

	}

}
