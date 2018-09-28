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

import com.ibm.ccl.soa.deploy.core.validator.ValidatorUtils;
import com.ibm.ccl.soa.deploy.core.validator.status.IDeployPublishStatus;
import com.ibm.ccl.soa.deploy.core.validator.status.IDeployStatus;

/**
 * Implementation of the {@link IDeployPublishStatus} interface.
 */
public class DeployPublishStatus extends DeployStatus implements IDeployPublishStatus {

	protected String publisher;

	/**
	 * Creates a publisher status with default persistence disabled.
	 */
	public DeployPublishStatus() {
		setPersistent(false);
	}

	/*
	 * @see com.ibm.ccl.soa.deploy.core.validator.status.IDeployPublishStatus#getPublisher()
	 */
	public String getPublisher() {
		return publisher;
	}

	/**
	 * Set the publisher source of the status.
	 * 
	 * @param publisher
	 *           the publisher name.
	 */
	public void setPublisher(String publisher) {
		this.publisher = publisher;
	}

	/*
	 * @see com.ibm.ccl.soa.deploy.internal.core.validator.status.DeployStatus#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object obj) {
		if (!(obj instanceof IDeployPublishStatus)) {
			return false;
		}
		IDeployPublishStatus as = (IDeployPublishStatus) obj;

		return super.equals(obj) && ValidatorUtils.equals(this.getPublisher(), as.getPublisher());
	}

	/*
	 * @see com.ibm.ccl.soa.deploy.internal.core.validator.status.DeployStatus#hashCode()
	 */
	@Override
	public int hashCode() {
		return super.hashCode() ^ ValidatorUtils.hashCode(getPublisher());
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
		IDeployPublishStatus aStatus = (IDeployPublishStatus) status;
		if ((result = ValidatorUtils.compare(this.getPublisher(), aStatus.getPublisher())) != 0) {
			return result;
		}
		return 0;
	}
}
