/***************************************************************************************************
 * Copyright (c) 2003, 2007 IBM Corporation Licensed Material - Property of IBM. All rights
 * reserved.
 * 
 * US Government Users Restricted Rights - Use, duplication or disclosure v1.0 restricted by GSA ADP
 * Schedule Contract with IBM Corp.
 * 
 * Contributors: IBM Corporation - initial API and implementation
 **************************************************************************************************/
package com.ibm.ccl.soa.deploy.core.ui.properties;

import java.util.Collection;
import java.util.Collections;

import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.emf.common.command.Command;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.transaction.util.TransactionUtil;
import org.eclipse.gmf.runtime.common.core.command.CommandResult;

import com.ibm.ccl.soa.deploy.core.ui.DeployCoreUIPlugin;
import com.ibm.ccl.soa.deploy.core.ui.internal.commands.DeployTransactionalCommand;

/**
 * Transaction that wraps a runnable
 * 
 * @author Ed Snible
 */
public class TransactionCommandWrapper4 extends DeployTransactionalCommand implements Command {

	private final Runnable r;

	/**
	 * @param eObject
	 * @param label
	 * @param r
	 */
	public TransactionCommandWrapper4(EObject eObject, String label, Runnable r) {
		super(TransactionUtil.getEditingDomain(eObject), label, getAllWorkspaceFiles(eObject));
		this.r = r;
	}

	protected CommandResult doExecuteWithResult(IProgressMonitor monitor, IAdaptable info) {
		r.run();
		return CommandResult.newOKCommandResult();
	}

	public Command chain(Command command) {
		return null;
	}

	public void execute() {
		try {
			super.execute(new NullProgressMonitor(), null);
		} catch (ExecutionException e) {
			DeployCoreUIPlugin.createErrorStatus(0, e.getLocalizedMessage(), e);
		}

	}

	public Collection<?> getAffectedObjects() {
		return super.getAffectedFiles();
	}

	public String getDescription() {
		return super.getLabel();
	}

	public Collection<?> getResult() {
		return Collections.EMPTY_LIST;
	}

	public void redo() {
		try {
			super.redo(new NullProgressMonitor(), null);
		} catch (ExecutionException e) {
			DeployCoreUIPlugin.createErrorStatus(0, e.getLocalizedMessage(), e);
		}

	}

	public void undo() {
		try {
			super.undo(new NullProgressMonitor(), null);
		} catch (ExecutionException e) {
			DeployCoreUIPlugin.createErrorStatus(0, e.getLocalizedMessage(), e);
		}

	}

//	protected IStatus doExecute(IProgressMonitor monitor, IAdaptable info) {
//		r.run();
//		return Status.OK_STATUS;
//	}

}
