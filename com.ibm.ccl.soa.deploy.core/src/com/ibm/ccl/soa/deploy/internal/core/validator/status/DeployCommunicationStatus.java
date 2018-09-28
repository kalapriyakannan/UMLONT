/***************************************************************************************************
 * Copyright (c) 2003, 2007 IBM Corporation Licensed Material - Property of IBM. All rights
 * reserved.
 * 
 * US Government Users Restricted Rights - Use, duplication or disclosure v1.0 restricted by GSA ADP
 * Schedule Contract with IBM Corp.
 * 
 * Contributors: IBM Corporation - initial API and implementation
 **************************************************************************************************/
package com.ibm.ccl.soa.deploy.internal.core.validator.status;

import java.util.List;
import java.util.Map;

import org.eclipse.core.runtime.IStatus;

import com.ibm.ccl.soa.deploy.core.DeployModelObject;
import com.ibm.ccl.soa.deploy.core.Topology;
import com.ibm.ccl.soa.deploy.core.validator.IDeployMarker;
import com.ibm.ccl.soa.deploy.core.validator.ValidatorUtils;
import com.ibm.ccl.soa.deploy.core.validator.status.IDeployCommunicationStatus;
import com.ibm.ccl.soa.deploy.core.validator.status.IDeployStatus;

/**
 * Implementation of the {@link IDeployCommunicationStatus} interface.
 */
public class DeployCommunicationStatus extends DeployStatus implements IDeployCommunicationStatus {

	/**
	 * @see IDeployCommunicationStatus#getTargetDmo()
	 */
	protected DeployModelObject targetDmo;

	/**
	 * Creates a extended status with default persistence disabled.
	 */
	public DeployCommunicationStatus() {
		setPersistent(false);
	}

	/*
	 * @see com.ibm.ccl.soa.deploy.core.validator.status.IDeployCommunicationStatus#getTargetDmo()
	 */
	public DeployModelObject getTargetDmo() {
		return targetDmo;
	}

	/**
	 * Sets the target deploy model object.
	 * 
	 * @param dmo
	 *           the target object.
	 */
	public void setTargetDmo(DeployModelObject dmo) {
		targetDmo = dmo;
	}

	/*
	 * @see com.ibm.ccl.soa.deploy.internal.core.validator.status.DeployStatus#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object obj) {
		if (!(obj instanceof IDeployCommunicationStatus)) {
			return false;
		}
		IDeployCommunicationStatus as = (IDeployCommunicationStatus) obj;

		return super.equals(obj) && ValidatorUtils.equals(this.getTargetDmo(), as.getTargetDmo());
	}

	/*
	 * @see com.ibm.ccl.soa.deploy.internal.core.validator.status.DeployStatus#hashCode()
	 */
	@Override
	public int hashCode() {
		return super.hashCode() ^ ValidatorUtils.hashCode(getTargetDmo());
	}

	/*
	 * @see java.lang.Comparable#compareTo(java.lang.Object)
	 */
	@Override
	public int compareTo(IDeployStatus status) {
		int result;
		if ((result = super.compareTo(status)) != 0) {
			return result;
		}
		IDeployCommunicationStatus aStatus = (IDeployCommunicationStatus) status;
		if ((result = ValidatorUtils.compareObjectPaths(this.getTargetDmo(), aStatus.getTargetDmo())) != 0) {
			return result;
		}
		return 0;
	}

	/*
	 * @see com.ibm.ccl.soa.deploy.internal.core.validator.status.DeployStatus#serializeAttributes(java.util.Map)
	 */
	@Override
	protected void serializeAttributes(Map<String, Object> attributes) {
		super.serializeAttributes(attributes);
		if (targetDmo != null) {
			attributes.put(IDeployMarker.COMMUNICATION_TARGET_DMO, targetDmo.getFullPath());
		}
	}

	/*
	 * @see com.ibm.ccl.soa.deploy.internal.core.validator.status.DeployAttributeStatus#deserializeAttributes(java.util.Map,
	 *      com.ibm.ccl.soa.deploy.core.Topology, java.util.List)
	 */
	@Override
	protected void deserializeAttributes(Map<String, Object> attributes, Topology topology,
			List<IStatus> statusList) {
		super.deserializeAttributes(attributes, topology, statusList);
		String id = (String) attributes.get(IDeployMarker.COMMUNICATION_TARGET_DMO);
		if (id != null && topology != null) {
			targetDmo = topology.resolve(id);
		} else {
			targetDmo = null;
		}
	}
}
