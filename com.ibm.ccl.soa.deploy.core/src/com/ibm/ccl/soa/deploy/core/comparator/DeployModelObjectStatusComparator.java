/***************************************************************************************************
 * Copyright (c) 2003, 2007 IBM Corporation Licensed Material - Property of IBM. All rights
 * reserved.
 * 
 * US Government Users Restricted Rights - Use, duplication or disclosure v1.0 restricted by GSA ADP
 * Schedule Contract with IBM Corp.
 * 
 * Contributors: IBM Corporation - initial API and implementation
 **************************************************************************************************/
package com.ibm.ccl.soa.deploy.core.comparator;

import org.eclipse.core.runtime.IStatus;

import com.ibm.ccl.soa.deploy.core.DeployModelObject;
import com.ibm.ccl.soa.deploy.core.util.DeployModelObjectUtil;
import com.ibm.ccl.soa.deploy.internal.core.validator.status.DeployStatus;

public class DeployModelObjectStatusComparator implements java.util.Comparator<Object> {
	static int GREATER_THAN = 1; // push to bottom stack
	static int LESS_THAN = -1; // push to top of stack
	static int EQUALS = 0; // default to top of stack

	public int compare(Object obj1, Object obj2) {
		if (obj1 instanceof DeployModelObject && obj2 instanceof DeployModelObject) {
			String name1 = DeployModelObjectUtil.getTitle((DeployModelObject) obj1);
			String name2 = DeployModelObjectUtil.getTitle((DeployModelObject) obj2);
			return name1.compareToIgnoreCase(name2);
		} else if (obj1 instanceof DeployModelObject) {
			return GREATER_THAN;
		} else if (obj2 instanceof DeployModelObject) {
			return LESS_THAN;
		}

		if (obj1 instanceof DeployStatus && obj2 instanceof DeployStatus) {
			return compareStatus((DeployStatus) obj1, (DeployStatus) obj2);
		}
		return EQUALS;
	}

	private int compareStatus(DeployStatus obj1, DeployStatus obj2) {
		return compareSeverities(obj1, obj2);
//		if (obj1.getPriority() > obj2.getPriority()) {
//			return LESS_THAN;
//		} else if (obj1.getPriority() < obj2.getPriority()) {
//			return GREATER_THAN;
//		}
//		if (obj1.getPriority() == obj2.getPriority()) {
//			return compareSeverities(obj1, obj2);
//		}
//		return EQUALS;
	}

	private int compareSeverities(DeployStatus status1, DeployStatus status2) {
		switch (status1.getSeverity())
		{
		case IStatus.ERROR:
			return status2.getSeverity() == IStatus.ERROR ? EQUALS : LESS_THAN;
		case IStatus.WARNING:
			if (status2.getSeverity() == IStatus.ERROR) {
				return GREATER_THAN;
			}
			return status2.getSeverity() == IStatus.WARNING ? EQUALS : LESS_THAN;
		case IStatus.INFO:
			return status2.getSeverity() == IStatus.INFO ? EQUALS : GREATER_THAN;
		}
		return EQUALS;
	}

	private int compareProblemType(DeployStatus obj1, DeployStatus obj2) {
		if (obj1.getProblemType().equals(obj2.getProblemType())) {
			return LESS_THAN;
		}

		// status message checking -> work around it
		return EQUALS;

	}
}
