/*******************************************************************************
 * Copyright (c) 2003, 2007 IBM Corporation Licensed Material - Property of IBM. All rights reserved.
 *  
 * US Government Users Restricted Rights - Use, duplication or disclosure v1.0 restricted by GSA ADP
 * Schedule Contract with IBM Corp.
 * 
 * Contributors: IBM Corporation - initial API and implementation
 *******************************************************************************/
package com.ibm.ccl.soa.deploy.internal.core.validator;

import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;

/**
 * A generic deploy operation executing with a progress monitor.
 * <p>
 * This is a version of {@link Runnable} with an {@link IProgressMonitor}.
 * org.eclipse.jface.operation.IRunnableWithProgress cannot be used because it has UI dependencies.
 */
public interface IDeployOperation {

	/**
	 * @return a user friendly name for the operation.
	 */
	public String getDisplayName();

	/**
	 * Runs the operation with the progress monitor.
	 * 
	 * @param monitor
	 *           the progress monitor used to report progress and check for cancellation of the
	 *           operation.
	 * @return the status of the deploy operation ({@link IStatus#CANCEL} if cancelled).
	 */
	public IStatus run(IProgressMonitor monitor);
}
