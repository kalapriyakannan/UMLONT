/*******************************************************************************
 * Copyright (c) 2003, 2007 IBM Corporation Licensed Material - Property of IBM. All rights reserved.
 *  
 * US Government Users Restricted Rights - Use, duplication or disclosure v1.0 restricted by GSA ADP
 * Schedule Contract with IBM Corp.
 * 
 * Contributors: IBM Corporation - initial API and implementation
 *******************************************************************************/
package com.ibm.ccl.soa.deploy.core.test;

import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.resources.IFile;
import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.emf.workspace.AbstractEMFOperation;

import com.ibm.ccl.soa.deploy.core.ChangeScope;
import com.ibm.ccl.soa.deploy.core.DeploymentTopologyDomain;

public class SimpleChangeScope extends ChangeScope {

	public SimpleChangeScope(IFile theTopologyFile) {
		super(theTopologyFile, new DeploymentTopologyDomain(theTopologyFile),false);
	}

	/**
	 * Executes the given {@link ModelChange} passing it this ChangeScope.
	 * 
	 * @param op
	 * @param monitor
	 * @return
	 */
	public IStatus execute(final ModelChange change, IProgressMonitor monitor)
			throws ExecutionException {
		return execute(new AbstractEMFOperation(
				getTransactionalEditingDomain(), change.getLabel()) {
			protected IStatus doExecute(IProgressMonitor monitor,
					IAdaptable info) throws ExecutionException {
				return change.execute(monitor, SimpleChangeScope.this);
			}
		}, OPTION_DO_NOT_SAVE, monitor);
	}

	/**
	 * Executes the given {@link ModelChange} passing it this ChangeScope.
	 * 
	 * @param change
	 * @param saveOptions
	 *            One of the save options defined by this type.
	 * @param monitor
	 * @return The status from the operation
	 * @throws ExecutionException
	 * @see OPTION_DO_NOT_SAVE
	 * @see OPTION_SAVE_IF_UNSHARED
	 * @see OPTION_FORCE_SAVE
	 */
	public IStatus execute(final ModelChange change, int saveOptions,
			IProgressMonitor monitor) throws ExecutionException {
		return execute(new AbstractEMFOperation(
				getTransactionalEditingDomain(), change.getLabel()) {
			protected IStatus doExecute(IProgressMonitor monitor,
					IAdaptable info) throws ExecutionException {
				return change.execute(monitor, SimpleChangeScope.this);
			}
		}, saveOptions, monitor);
	}
}
