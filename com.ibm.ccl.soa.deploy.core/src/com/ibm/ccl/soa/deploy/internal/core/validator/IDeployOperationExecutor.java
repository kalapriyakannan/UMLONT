/*******************************************************************************
 * Copyright (c) 2003, 2007 IBM Corporation Licensed Material - Property of IBM. All rights reserved.
 *  
 * US Government Users Restricted Rights - Use, duplication or disclosure v1.0 restricted by GSA ADP
 * Schedule Contract with IBM Corp.
 * 
 * Contributors: IBM Corporation - initial API and implementation
 *******************************************************************************/
package com.ibm.ccl.soa.deploy.internal.core.validator;

import org.eclipse.core.runtime.IStatus;

/**
 * Interface implemented by schedulers of deploy jobs.
 */
public interface IDeployOperationExecutor {
	/**
	 * Execute the deploy operation in a synchronous (blocking) manner.
	 * 
	 * @param operation
	 *           the operation to be executed.
	 * @return the status of execution.
	 */
	public IStatus syncExec(IDeployOperation operation);

	/**
	 * Execute the deploy operation in a asynchronous (non-blocking) manner.
	 * 
	 * @param operation
	 *           the operation to be executed.
	 * @return the status of scheduling the operation execution.
	 */
	public IStatus asyncExec(IDeployOperation operation);
}
