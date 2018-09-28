/*******************************************************************************
 * Copyright (c) 2003, 2007 IBM Corporation Licensed Material - Property of IBM. All rights reserved.
 *  
 * US Government Users Restricted Rights - Use, duplication or disclosure v1.0 restricted by GSA ADP
 * Schedule Contract with IBM Corp.
 * 
 * Contributors: IBM Corporation - initial API and implementation
 *******************************************************************************/
package com.ibm.ccl.soa.deploy.internal.core.validator.resolution;

import java.util.Iterator;

import org.eclipse.core.runtime.IStatus;

import com.ibm.ccl.soa.deploy.core.DeployModelObject;
import com.ibm.ccl.soa.deploy.core.validator.resolution.DeployResolutionGenerator;
import com.ibm.ccl.soa.deploy.core.validator.resolution.IDeployResolution;
import com.ibm.ccl.soa.deploy.core.validator.resolution.IDeployResolutionContext;
import com.ibm.ccl.soa.deploy.core.validator.resolution.ResolutionUtils;
import com.ibm.ccl.soa.deploy.core.validator.status.DeployStatusIterator;
import com.ibm.ccl.soa.deploy.core.validator.status.IDeployAttributeValueStatus;
import com.ibm.ccl.soa.deploy.core.validator.status.IDeployStatus;

/**
 * For topologies with at least one {@link IDeployAttributeValueStatus} creates a
 * {@link SetAllAttributesInTopologyResolution}.
 */
public class SetAllAttributesResolutionGenerator extends DeployResolutionGenerator {

	/*
	 * @see com.ibm.ccl.soa.deploy.core.validator.resolution.IDeployResolutionGenerator#getResolutions(com.ibm.ccl.soa.deploy.core.validator.resolution.IDeployResolutionContext)
	 */
	public IDeployResolution[] getResolutions(IDeployResolutionContext context) {
		boolean foundUnitValue = false;
		for (Iterator iter = new DeployStatusIterator(context.getDeployStatus()); iter.hasNext();) {
			IDeployStatus status = (IDeployStatus) iter.next();
			if (status instanceof IDeployAttributeValueStatus) {
				IDeployAttributeValueStatus vStatus = (IDeployAttributeValueStatus) status;
				if (!(vStatus.getSeverity() == IStatus.INFO && vStatus.getAttributeExpectedValue() == null)) {
					if (ResolutionUtils.isSettable(vStatus)) {
						foundUnitValue = true;
						break;
					}
				}
			}
		}

		boolean foundTopologyValue = false;
		for (Iterator iter = context.getTopology().getEditTopology().findAllDeployModelObjects(); iter
				.hasNext();) {
			DeployModelObject dmo = (DeployModelObject) iter.next();
			if (dmo.getStatus().isOK()) {
				continue;
			}
			for (Iterator iter2 = new DeployStatusIterator(context.getDeployStatus()); iter2.hasNext();) {
				IDeployStatus status = (IDeployStatus) iter2.next();
				if (status instanceof IDeployAttributeValueStatus) {
					IDeployAttributeValueStatus vStatus = (IDeployAttributeValueStatus) status;
					if (!(vStatus.getSeverity() == IStatus.INFO && vStatus.getAttributeExpectedValue() == null)) {
						if (ResolutionUtils.isSettable(vStatus)) {
							foundTopologyValue = true;
							break;
						}
					}
				}
			}
		}

		if (!foundTopologyValue && !foundUnitValue) {
			return EMPTY_RESOLUTION_ARRAY;
		}
		if (!foundTopologyValue) {
			return new IDeployResolution[] { new SetAllAttributesInUnitResolution(context, this) };

		}

		if (!foundUnitValue) {
			return new IDeployResolution[] { new SetAllAttributesInTopologyResolution(context, this) };

		}
		return new IDeployResolution[] { new SetAllAttributesInUnitResolution(context, this),
				new SetAllAttributesInTopologyResolution(context, this) };
	}

	/*
	 * @see com.ibm.ccl.soa.deploy.core.validator.resolution.IDeployResolutionGenerator#hasResolutions(com.ibm.ccl.soa.deploy.core.validator.resolution.IDeployResolutionContext)
	 */
	public boolean hasResolutions(IDeployResolutionContext context) {
		return context.getDeployStatus() instanceof IDeployAttributeValueStatus;
	}
}
