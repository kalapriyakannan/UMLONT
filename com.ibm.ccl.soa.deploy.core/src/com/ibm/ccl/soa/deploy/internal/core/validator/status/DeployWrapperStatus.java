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

import com.ibm.ccl.soa.deploy.core.validator.IDeployMarker;
import com.ibm.ccl.soa.deploy.core.validator.ValidatorUtils;
import com.ibm.ccl.soa.deploy.core.validator.status.IDeployStatus;
import com.ibm.ccl.soa.deploy.core.validator.status.IDeployWrapperStatus;

/**
 * Default implementation of {@link IDeployWrapperStatus}.
 */
public class DeployWrapperStatus extends DeployStatus implements IDeployWrapperStatus {

	/**
	 * Cached wrappedStatus.
	 */
	protected IDeployStatus wrappedStatus = null;

	/**
	 * Construct a wrapper status.
	 */
	public DeployWrapperStatus() {
		setMarkerType(IDeployMarker.MARKER_ID);
	}

	/*
	 * @see com.ibm.ccl.soa.deploy.core.validator.status.IDeployWrapperStatus#getWrappedStatus()
	 */
	public IDeployStatus getWrappedStatus() {
		return wrappedStatus;
	}

	/*
	 * @see com.ibm.ccl.soa.deploy.core.validator.status.IDeployWrapperStatus#setWrappedStatus(com.ibm.ccl.soa.deploy.core.validator.status.IDeployStatus)
	 */
	public void setWrappedStatus(IDeployStatus status) {
		wrappedStatus = status;
	}

	/*
	 * @see com.ibm.ccl.soa.deploy.internal.core.validator.status.DeployStatus#equals(java.lang.Object)
	 */
	public boolean equals(Object object) {
		if (!(object instanceof DeployWrapperStatus)) {
			return false;
		}
		DeployWrapperStatus other = (DeployWrapperStatus) object;
		return super.equals(object)
				&& ValidatorUtils.equals(this.getWrappedStatus(), other.getWrappedStatus());
	}

	/*
	 * @see com.ibm.ccl.soa.deploy.internal.core.validator.status.DeployStatus#hashCode()
	 */
	@Override
	public int hashCode() {
		return super.hashCode() ^ ValidatorUtils.hashCode(getWrappedStatus());
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
		IDeployWrapperStatus aStatus = (IDeployWrapperStatus) status;
		if ((result = ValidatorUtils.compare(this.getWrappedStatus(), aStatus.getWrappedStatus())) != 0) {
			return result;
		}
		return 0;
	}
	// TODO support serialization
}
