/*******************************************************************************
 * Copyright (c) 2003, 2007 IBM Corporation Licensed Material - Property of IBM. All rights reserved.
 *  
 * US Government Users Restricted Rights - Use, duplication or disclosure v1.0 restricted by GSA ADP
 * Schedule Contract with IBM Corp.
 * 
 * Contributors: IBM Corporation - initial API and implementation
 *******************************************************************************/

package com.ibm.ccl.soa.deploy.core.validator.pattern;

import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;

import com.ibm.ccl.soa.deploy.core.DeployCorePlugin;
import com.ibm.ccl.soa.deploy.internal.core.DeployCoreMessages;

/**
 * A pattern that can be found or constructed.
 * <p>
 * An active pattern is instantiated with one or more topology objects. The pattern implementation
 * navigates from these objects to check their interdependent configuration. The pattern may be
 * invoked in passive mode to check if it holds, or active where it attempts to correct
 * configuration errors.
 */
public interface IDeployValidationActivePattern {
	/**
	 * Status indicating that the pattern was not found, and no known fix is available.
	 */
	public static final IStatus FAIL_NO_FIX = new Status(IStatus.ERROR, DeployCorePlugin.PLUGIN_ID,
			0, DeployCoreMessages.Active_pattern_fail_no_fix, null);

	/**
	 * Status indicating that the pattern was not found, and a fix is available.
	 */
	public static final IStatus FAIL_HAS_FIX = new Status(IStatus.ERROR, DeployCorePlugin.PLUGIN_ID,
			0, DeployCoreMessages.Active_pattern_fail_has_fix, null);

	/**
	 * Applies the pattern, optionally fixing any errors found.
	 * 
	 * @param fix
	 *           true if errors should be fixed, false for read-only check.
	 * @param monitor
	 *           the validation or resolution progress and cancellation monitor.
	 * @return the status of the check and/or fix.
	 */
	public IStatus find(boolean fix, IProgressMonitor monitor);
}
