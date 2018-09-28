/***************************************************************************************************
 * Copyright (c) 2003, 2007 IBM Corporation Licensed Material - Property of IBM. All rights
 * reserved.
 * 
 * US Government Users Restricted Rights - Use, duplication or disclosure v1.0 restricted by GSA ADP
 * Schedule Contract with IBM Corp.
 * 
 * Contributors: IBM Corporation - initial API and implementation
 **************************************************************************************************/
package com.ibm.ccl.soa.deploy.internal.core.validator;

import org.eclipse.core.runtime.CoreException;

import com.ibm.ccl.soa.deploy.core.DeployModelObject;
import com.ibm.ccl.soa.deploy.core.validator.IDeployReporter;
import com.ibm.ccl.soa.deploy.core.validator.status.IDeployStatus;

/**
 * Default implementation of the deploy reporter.
 * 
 * @deprecated
 */
public class DeployReporter implements IDeployReporter {

	protected boolean createMarkers = true;

	/**
	 * Create a deploy reporter which serializes errors as markers.
	 */
	public DeployReporter() {
	}

	/**
	 * Create a deploy reporter.
	 * 
	 * @param createMarkers
	 *           true if the markers should be created.
	 */
	public DeployReporter(boolean createMarkers) {
		this.createMarkers = createMarkers;
	}

	/*
	 * @see com.ibm.ccl.soa.deploy.core.validator.IDeployReporter#addStatus(com.ibm.ccl.soa.deploy.core.validator.status.IDeployStatus)
	 */
	public void addStatus(IDeployStatus message) {
		if (message.getMessage() == null) {
			System.err.println(message.getSeverity());
			new Exception(message.toString()).printStackTrace();
		}
		try {
			if (message.isPersistent() && createMarkers) {
				DeployModelObject object = message.getDeployObject();
				if (object == null || object.getTopology() == null) {
					// TODO log
					System.err.println("DeployReporter: panic: could not report: " + message); //$NON-NLS-1$
				} else {
					// TODO create status (not marker)
					message.createMarker();
				}
			}
			message.getDeployObject().addStatus(message);
		} catch (ClassCastException e) {
			// TODO log
			e.printStackTrace();
			throw new IllegalArgumentException(message.getClass().getName());
		} catch (CoreException e) {
			// TODO once markers are not created then this will not be thrown
			e.printStackTrace();
		}
	}
}
