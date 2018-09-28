/***************************************************************************************************
 * Copyright (c) 2003, 2007 IBM Corporation Licensed Material - Property of IBM. All rights
 * reserved.
 * 
 * US Government Users Restricted Rights - Use, duplication or disclosure v1.0 restricted by GSA ADP
 * Schedule Contract with IBM Corp.
 * 
 * Contributors: IBM Corporation - initial API and implementation
 **************************************************************************************************/
package com.ibm.ccl.soa.deploy.core.ui.internal.commands;

import java.util.Iterator;
import java.util.List;

import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.gmf.runtime.common.core.command.CommandResult;
import org.eclipse.gmf.runtime.diagram.ui.editparts.IGraphicalEditPart;

import com.ibm.ccl.soa.deploy.core.ui.util.ZoomUtils;

/**
 * @since 1.0
 * 
 */
public class CollapseAllCommand extends DeployTransactionalCommand {
	private List<IGraphicalEditPart> editparts = null;

	/**
	 * @param editingDomain
	 * @param cmdName
	 * @param list
	 */
	public CollapseAllCommand(TransactionalEditingDomain editingDomain, String cmdName,
			List<IGraphicalEditPart> list) {
		super(editingDomain, cmdName,
				list != null && !list.isEmpty() ? getWorkspaceFiles(list.get(0)) : null);
		editparts = list;
		setResult(CommandResult.newOKCommandResult(null));
	}

	protected CommandResult doExecuteWithResult(IProgressMonitor monitor, IAdaptable info) {
		for (Iterator<IGraphicalEditPart> it = editparts.iterator(); it.hasNext();) {
			ZoomUtils.explode(it.next(), false);
		}

		return CommandResult.newOKCommandResult();
	}

	public boolean canExecute() {
		return true;
	}

}
