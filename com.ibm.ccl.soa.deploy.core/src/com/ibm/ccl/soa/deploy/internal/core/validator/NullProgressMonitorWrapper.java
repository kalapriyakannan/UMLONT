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

/**
 * A progress monitor which wraps another for cancellation.
 */
public class NullProgressMonitorWrapper implements IProgressMonitor {

	private final IProgressMonitor monitor;

	/**
	 * Construct a null progress monitor wrapped on another monitor for cancel requests.
	 * 
	 * @param monitor
	 *           the wrapped monitor.
	 */
	public NullProgressMonitorWrapper(IProgressMonitor monitor) {
		assert monitor != null;
		this.monitor = monitor;
	}

	/*
	 * @see org.eclipse.core.runtime.IProgressMonitor#beginTask(java.lang.String, int)
	 */
	public void beginTask(String name, int totalWork) {
		// ignore
	}

	/*
	 * @see org.eclipse.core.runtime.IProgressMonitor#done()
	 */
	public void done() {
		// ignore
	}

	/*
	 * @see org.eclipse.core.runtime.IProgressMonitor#internalWorked(double)
	 */
	public void internalWorked(double work) {
		// ignore
	}

	/*
	 * @see org.eclipse.core.runtime.IProgressMonitor#isCanceled()
	 */
	public boolean isCanceled() {
		return monitor.isCanceled();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.core.runtime.IProgressMonitor#setCanceled(boolean)
	 */
	public void setCanceled(boolean value) {
		monitor.setCanceled(value);
	}

	/*
	 * @see org.eclipse.core.runtime.IProgressMonitor#setTaskName(java.lang.String)
	 */
	public void setTaskName(String name) {
		// ignore
	}

	/*
	 * @see org.eclipse.core.runtime.IProgressMonitor#subTask(java.lang.String)
	 */
	public void subTask(String name) {
		// ignore
	}

	/*
	 * @see org.eclipse.core.runtime.IProgressMonitor#worked(int)
	 */
	public void worked(int work) {
		// ignor
	}
}
