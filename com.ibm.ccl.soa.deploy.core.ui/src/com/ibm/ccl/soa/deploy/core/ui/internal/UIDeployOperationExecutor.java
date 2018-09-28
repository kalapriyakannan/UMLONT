/*******************************************************************************
 * Copyright (c) 2003, 2007 IBM Corporation Licensed Material - Property of IBM. All rights reserved.
 *  
 * US Government Users Restricted Rights - Use, duplication or disclosure v1.0 restricted by GSA ADP
 * Schedule Contract with IBM Corp.
 * 
 * Contributors: IBM Corporation - initial API and implementation
 *******************************************************************************/
/**
 * 
 */
package com.ibm.ccl.soa.deploy.core.ui.internal;

import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.core.runtime.jobs.Job;
import org.eclipse.ui.progress.UIJob;

import com.ibm.ccl.soa.deploy.core.ui.Messages;
import com.ibm.ccl.soa.deploy.internal.core.validator.IDeployOperation;
import com.ibm.ccl.soa.deploy.internal.core.validator.IDeployOperationExecutor;

/**
 * Executes the deploy operation as a UI job.
 */
public class UIDeployOperationExecutor implements IDeployOperationExecutor {

	/**
	 * Creates a UI job for executing the operation.
	 * <p>
	 * Note: does not invoke {@link Job#schedule()}.
	 * 
	 * @param operation
	 *           the deploy operation to be executed.
	 * @return the created job (has not been scheduled).
	 */
	protected UIJob createJob(final IDeployOperation operation) {
		UIJob job = new UIJob(Messages.VALIDATION_STATUS_UPDATE) {
			public IStatus runInUIThread(IProgressMonitor monitor) {
				return operation.run(monitor);
			}

		};
		return job;
	}

	/*
	 * @see com.ibm.ccl.soa.deploy.internal.core.validator.IDeployOperationExecutor#syncExec(com.ibm.ccl.soa.deploy.internal.core.validator.IDeployOperation)
	 */
	public IStatus syncExec(IDeployOperation operation) {
		UIJob job = createJob(operation);
		job.schedule();
		try {
			job.join();
			return job.getResult();
		} catch (InterruptedException e) {
			return Status.CANCEL_STATUS;
		}
	}

	/*
	 * @see com.ibm.ccl.soa.deploy.internal.core.validator.IDeployOperationExecutor#asyncExec(com.ibm.ccl.soa.deploy.internal.core.validator.IDeployOperation)
	 */
	public IStatus asyncExec(IDeployOperation operation) {
		createJob(operation).schedule();
		return Status.OK_STATUS;
	}
}
