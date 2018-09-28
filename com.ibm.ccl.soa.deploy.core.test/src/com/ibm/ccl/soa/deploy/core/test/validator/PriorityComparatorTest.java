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
import java.util.ArrayList;
import java.util.Arrays;

import org.eclipse.core.runtime.IStatus;

import com.ibm.ccl.soa.deploy.core.CoreFactory;
import com.ibm.ccl.soa.deploy.core.Topology;
import com.ibm.ccl.soa.deploy.core.Unit;
import com.ibm.ccl.soa.deploy.core.comparator.DeployModelObjectStatusComparator;
import com.ibm.ccl.soa.deploy.core.test.TopologyTestCase;
import com.ibm.ccl.soa.deploy.core.validator.status.ICoreProblemType;
import com.ibm.ccl.soa.deploy.internal.core.validator.status.DeployActionStatus;
import com.ibm.ccl.soa.deploy.internal.core.validator.status.DeployAttributeStatus;
import com.ibm.ccl.soa.deploy.internal.core.validator.status.DeployStatus;

public class PriorityComparatorTest extends TopologyTestCase {

	private static final String PROJECT_NAME = "StatusTest";
	DeployModelObjectStatusComparator comparator = new DeployModelObjectStatusComparator();

	public PriorityComparatorTest() {
		super(PROJECT_NAME);
	}

	public PriorityComparatorTest(String name) {
		super(name);
	}

	public void testStatusSort() throws IOException {
		Topology top = createTopology("statusTestTopology");

		ArrayList list = new ArrayList();

		// Create a Unit
		Unit unit1 = CoreFactory.eINSTANCE.createUnit();
		unit1.setName("unit1");
		top.getUnits().add(unit1);

		DeployStatus deployStatus1 = new DeployStatus();
		deployStatus1.setProblemType(ICoreProblemType.UNIT_HOST_NOT_INSTALLED);
		deployStatus1.setSeverity(IStatus.ERROR);
		unit1.addStatus(deployStatus1);
		list.add(deployStatus1);

		DeployAttributeStatus deployStatus2 = new DeployAttributeStatus();
		deployStatus2.setProblemType(ICoreProblemType.ATTRIBUTE_CONSTRAINT_INVALID_ATTRIBUTE);
		deployStatus2.setSeverity(IStatus.ERROR);
		list.add(deployStatus2);

		DeployActionStatus deployStatus3 = new DeployActionStatus();
		deployStatus3.setProblemType(ICoreProblemType.UNIT_DEPENDENCY_REQUIREMENT_UNMATCHED);
		deployStatus3.setSeverity(IStatus.ERROR);
		list.add(deployStatus3);

		DeployStatus deployStatus4 = new DeployStatus();
		deployStatus4.setProblemType(ICoreProblemType.UNIT_HAS_NO_REQUIREMENTS_OR_CAPABILITIES);
		deployStatus4.setSeverity(IStatus.WARNING);
		list.add(deployStatus4);

		Object[] statusArray = list.toArray();
		Arrays.sort(statusArray, comparator);

		for (int i = 0; i < statusArray.length; i++) {
			switch (i) {
			case 0: {
				assertTrue(statusArray[i] == deployStatus1);
				break;
			}
			case 1: {
				assertTrue(statusArray[i] == deployStatus4);
				break;
			}
			case 2: {
				assertTrue(statusArray[i] == deployStatus3);
				break;
			}
			case 3: {
				assertTrue(statusArray[i] == deployStatus2);
				break;
			}

			default:
				break;
			}

		}

	}

}
