/*******************************************************************************
 * Copyright (c) 2003, 2007 IBM Corporation Licensed Material - Property of IBM. All rights reserved.
 *  
 * US Government Users Restricted Rights - Use, duplication or disclosure v1.0 restricted by GSA ADP
 * Schedule Contract with IBM Corp.
 * 
 * Contributors: IBM Corporation - initial API and implementation
 *******************************************************************************/

package com.ibm.ccl.soa.deploy.internal.core.validator;

import java.util.ArrayList;
import java.util.List;

import com.ibm.ccl.soa.deploy.core.validator.IDeployReporter;
import com.ibm.ccl.soa.deploy.core.validator.status.IDeployStatus;

/**
 * A deploy status reporter that collects statuses in a list.
 */
public class DeployStatusCollector implements IDeployReporter {

	protected final List statusList = new ArrayList();

	/*
	 * @see com.ibm.ccl.soa.deploy.core.validator.IDeployReporter#addStatus(com.ibm.ccl.soa.deploy.core.validator.status.IDeployStatus)
	 */
	public void addStatus(IDeployStatus status) {
		if (status != null) {
			statusList.add(status);
		}
	}

	/**
	 * @return the list of all status reported.return
	 */
	public List getStatusList() {
		return statusList;
	}
}
