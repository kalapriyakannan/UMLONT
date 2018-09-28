/*******************************************************************************
 * Copyright (c) 2003, 2007 IBM Corporation Licensed Material - Property of IBM. All rights reserved.
 *  
 * US Government Users Restricted Rights - Use, duplication or disclosure v1.0 restricted by GSA ADP
 * Schedule Contract with IBM Corp.
 * 
 * Contributors: IBM Corporation - initial API and implementation
 *******************************************************************************/
package com.ibm.ccl.soa.deploy.internal.core.validator.resolution;

import java.util.Collections;
import java.util.List;

import org.eclipse.core.runtime.IStatus;

import com.ibm.ccl.soa.deploy.core.validator.resolution.IDeployResolutionStatus;

/**
 * Default implementation of the {@link IDeployResolutionStatus} interface.
 */
public class DeployResolutionStatus implements IDeployResolutionStatus {
	protected final IStatus status;

	protected List createdObjectList;

	protected List destroyedObjectList;

	public DeployResolutionStatus(IStatus status) {
		this(status, Collections.EMPTY_LIST, Collections.EMPTY_LIST);
	}

	public DeployResolutionStatus(IStatus status, List createdObjectList, List destroyedObjectList) {
		this.status = status;
		this.createdObjectList = Collections.unmodifiableList(createdObjectList);
		this.destroyedObjectList = Collections.unmodifiableList(destroyedObjectList);
	}

	public List getCreatedObjects() {
		return createdObjectList;
	}

	public List getDestroyedObjects() {
		return destroyedObjectList;
	}

	public IStatus[] getChildren() {
		return status.getChildren();
	}

	public int getCode() {
		return status.getCode();
	}

	public Throwable getException() {
		return status.getException();
	}

	public String getMessage() {
		return status.getMessage();
	}

	public String getPlugin() {
		return status.getPlugin();
	}

	public int getSeverity() {
		return status.getSeverity();
	}

	public boolean isMultiStatus() {
		return status.isMultiStatus();
	}

	public boolean isOK() {
		return status.isOK();
	}

	public boolean matches(int severityMask) {
		return status.matches(severityMask);
	}

	/*
	 * @see java.lang.Object#toString()
	 */
	public String toString() {
		return status.toString();
	}
}
