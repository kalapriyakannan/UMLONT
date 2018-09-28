/*******************************************************************************
 * Copyright (c) 2003, 2007 IBM Corporation Licensed Material - Property of IBM. All rights reserved.
 *  
 * US Government Users Restricted Rights - Use, duplication or disclosure v1.0 restricted by GSA ADP
 * Schedule Contract with IBM Corp.
 * 
 * Contributors: IBM Corporation - initial API and implementation
 *******************************************************************************/

package com.ibm.ccl.soa.deploy.core.export;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.eclipse.core.runtime.IStatus;

/**
 * @since 1.0
 * 
 */
public class DeployExportLogger {
	private List statuses;

	/**
	 * 
	 */
	public DeployExportLogger() {

	}

	/**
	 * @param statuses
	 *           The statuses to set.
	 */
	public void setStatuses(List statuses) {
		this.statuses = statuses;
	}

	/**
	 * @return Returns the statuses.
	 */
	public List getStatuses() {
		if (statuses == null) {
			statuses = new ArrayList();
		}
		return statuses;
	}

	/**
	 * Add a list of statuses to the log
	 * 
	 * @param statuses
	 */
	public void addStatus(List statuses) {
		getStatuses().addAll(statuses);
	}

	/**
	 * Add a status to the log
	 * 
	 * @param status
	 */
	public void addStatus(IStatus status) {
		getStatuses().add(status);
	}

	/**
	 * print the statuses to the console output
	 */
	public void logToConsole() {
		List statuses = getStatuses();
		for (Iterator iter = statuses.iterator(); iter.hasNext();) {
			IStatus status = (IStatus) iter.next();
			StringBuffer message = new StringBuffer(status.getSeverity());
			message.append(status.getMessage());
			message.append(status.getException());
			System.out.print(message.toString());
		}
	}

}
