/***************************************************************************************************
 * Copyright (c) 2003, 2007 IBM Corporation Licensed Material - Property of IBM. All rights
 * reserved.
 * 
 * US Government Users Restricted Rights - Use, duplication or disclosure v1.0 restricted by GSA ADP
 * Schedule Contract with IBM Corp.
 * 
 * Contributors: IBM Corporation - initial API and implementation
 **************************************************************************************************/
package com.ibm.ccl.soa.deploy.core.validator.status;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.MultiStatus;
import org.eclipse.core.runtime.Status;

import com.ibm.ccl.soa.deploy.core.Capability;
import com.ibm.ccl.soa.deploy.core.Constraint;
import com.ibm.ccl.soa.deploy.core.ConstraintLink;
import com.ibm.ccl.soa.deploy.core.DeployCorePlugin;
import com.ibm.ccl.soa.deploy.core.DeployLink;
import com.ibm.ccl.soa.deploy.core.DeployModelObject;
import com.ibm.ccl.soa.deploy.core.HostingLink;
import com.ibm.ccl.soa.deploy.core.MemberLink;
import com.ibm.ccl.soa.deploy.core.RealizationLink;
import com.ibm.ccl.soa.deploy.core.Requirement;
import com.ibm.ccl.soa.deploy.core.RequirementExpression;
import com.ibm.ccl.soa.deploy.core.Unit;
import com.ibm.ccl.soa.deploy.core.util.TopologyUtil;
import com.ibm.ccl.soa.deploy.internal.core.DeployCoreMessages;

public class StatusUtil {

	public StatusUtil() {
	}

	public static IStatus collectStatus(DeployModelObject deployObject, boolean containedObjects) {
		List statusList = new LinkedList();

		addStatus(statusList, deployObject);

		if (deployObject instanceof Unit) {
			Unit unit = (Unit) deployObject;

			for (Iterator iter = unit.getContainedModelObjects().iterator(); iter.hasNext();) {
				DeployModelObject dmo = (DeployModelObject) iter.next();
				if (dmo instanceof HostingLink || dmo instanceof ConstraintLink) {
					// ignore visible unit-contained links since they will be
					// shown directly
				} else {
					addStatus(statusList, dmo);
				}

				if (dmo instanceof Requirement) {
					Requirement req = (Requirement) dmo;
					for (Iterator iter2 = req.getExpressions().iterator(); iter2.hasNext();) {
						RequirementExpression expr = (RequirementExpression) iter2.next();
						addStatus(statusList, expr);
					}
					// Contained dependency link which would not be visible
					if (req.getLink() != null
							&& (req.getLink().getSource() == null || req.getLink().getTarget() == null)) {
						addStatus(statusList, req.getLink());
					}
				} else if (dmo instanceof Capability) {
					addConstraintStatuses(statusList, dmo);
				}
			}

			// Links contained by unit which would not be visible

			for (HostingLink link : TopologyUtil.getImmediateHostingLinksOut(unit)) {
				if (link.getSource() == null || link.getTarget() == null) {
					addStatus(statusList, link);
				}
			}
			for (MemberLink link : TopologyUtil.getImmediateMemberLinksOut(unit)) {
				if (link.getSource() == null || link.getTarget() == null) {
					addStatus(statusList, link);
				}
			}
			for (RealizationLink link : TopologyUtil.getImmediateRealizationLinksOut(unit)) {
				if (link.getSource() == null || link.getTarget() == null) {
					addStatus(statusList, link);
				}
			}
			for (ConstraintLink link : TopologyUtil.getImmediateConstraintLinksOut(unit)) {
				if (link.getSource() == null || link.getTarget() == null) {
					addStatus(statusList, link);
				}
			}

		} else if (deployObject instanceof DeployLink) {

			addConstraintStatuses(statusList, deployObject);
		}

		if (statusList.size() == 0) {
			return Status.OK_STATUS;
		}

		if (statusList.size() == 1) {
			return (IStatus) statusList.get(0);
		}
		IStatus[] children = (IStatus[]) statusList.toArray(new IStatus[statusList.size()]);
		MultiStatus status = new MultiStatus(DeployCorePlugin.PLUGIN_ID, 0, children,
				DeployCoreMessages.Model_consistency_status_message, null);
		return status;
	}

	private static void addStatus(List statusList, DeployModelObject object) {
		IStatus status = object.getStatus();
		if (status == Status.OK_STATUS) {
			return;
		}
		if (!status.isMultiStatus()) {
			if (!statusList.contains(status)) {
				statusList.add(status);
			}
		} else {
			IStatus[] children = status.getChildren();
			for (int i = 0; i < children.length; i++) {
				// don't add if error already in list or if error is OK
				if (!statusList.contains(children[i]) && children[i].getSeverity() > 0) {
					statusList.add(children[i]);
				}
			}
		}
	}

	private static void addConstraintStatuses(List statusList, DeployModelObject dmo) {
		for (Iterator it = dmo.getConstraints().iterator(); it.hasNext();) {
			Constraint constraint = (Constraint) it.next();
			addStatus(statusList, constraint);
		}
	}

}
