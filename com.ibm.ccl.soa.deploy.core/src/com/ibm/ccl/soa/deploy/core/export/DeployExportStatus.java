/*******************************************************************************
 * Copyright (c) 2003, 2007 IBM Corporation Licensed Material - Property of IBM. All rights reserved.
 *  
 * US Government Users Restricted Rights - Use, duplication or disclosure v1.0 restricted by GSA ADP
 * Schedule Contract with IBM Corp.
 * 
 * Contributors: IBM Corporation - initial API and implementation
 *******************************************************************************/

package com.ibm.ccl.soa.deploy.core.export;

import org.eclipse.core.runtime.Status;

import com.ibm.ccl.soa.deploy.core.DeployModelObject;

/**
 * @since 1.0
 * 
 */
public class DeployExportStatus extends Status {

	/**
	 * @param severity
	 * @param pluginId
	 * @param code
	 * @param message
	 * @param exception
	 */
	public DeployExportStatus(int severity, String pluginId, int code, String message,
			Throwable exception) {
		super(severity, pluginId, code, message, exception);
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param severity
	 * @param pluginId
	 * @param code
	 * @param message
	 * @param exception
	 * @param dmo
	 * 
	 */
	public DeployExportStatus(int severity, String pluginId, int code, String message,
			Throwable exception, DeployModelObject dmo) {
		super(severity, pluginId, code, message, exception);
		// TODO Auto-generated constructor stub
	}

}
