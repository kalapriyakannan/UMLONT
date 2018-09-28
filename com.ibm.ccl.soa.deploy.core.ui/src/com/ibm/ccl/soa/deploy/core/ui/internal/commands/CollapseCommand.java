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

import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.gmf.runtime.common.core.command.CommandResult;
import org.eclipse.gmf.runtime.diagram.core.util.ViewUtil;
import org.eclipse.gmf.runtime.diagram.ui.editparts.IGraphicalEditPart;
import org.eclipse.gmf.runtime.notation.NotationPackage;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.jface.util.Assert;

import com.ibm.ccl.soa.deploy.core.ui.util.DeployCoreConstants;

/**
 * @since 1.0
 * 
 */
public class CollapseCommand extends DeployTransactionalCommand {
	private IAdaptable adapter;
	private IGraphicalEditPart editPart;
	private View view;
	private final boolean isCollapsed;

	/**
	 * @param editingDomain
	 * @param editpart
	 * @param isCollapsed
	 */
	public CollapseCommand(TransactionalEditingDomain editingDomain, IGraphicalEditPart editpart,
			boolean isCollapsed) {

		super(editingDomain, "Collapse Command", getWorkspaceFiles(editpart)); //$NON-NLS-1$

		Assert.isNotNull(editpart);

		view = (View) editpart.getModel();
		editPart = editpart;
		this.isCollapsed = isCollapsed;

		setResult(CommandResult.newOKCommandResult(null));
	}

	/**
	 * @param editingDomain
	 * @param adapter
	 * @param isCollapsed
	 */
	public CollapseCommand(TransactionalEditingDomain editingDomain, IAdaptable adapter,
			boolean isCollapsed) {

		super(editingDomain, "Collapse Command", null); //$NON-NLS-1$

		Assert.isNotNull(adapter);

		this.adapter = adapter;

		this.isCollapsed = isCollapsed;

		setResult(CommandResult.newOKCommandResult(null));
	}

	protected CommandResult doExecuteWithResult(IProgressMonitor monitor, IAdaptable info) {

		// get view from adapter?
		if (view == null && adapter != null) {
			View parentView = (View) adapter.getAdapter(View.class);
			if (parentView == null) {
				return CommandResult.newErrorCommandResult("Bad adapter"); //$NON-NLS-1$
			}
			View container = ViewUtil.getChildBySemanticHint(parentView,
					DeployCoreConstants.HYBRIDSHAPES_SEMANTICHINT);
			if (container == null) {
				container = ViewUtil.getChildBySemanticHint(parentView,
						DeployCoreConstants.HYBRIDLIST_SEMANTICHINT);
				if (container == null) {
					return CommandResult.newOKCommandResult();
				}
			}
			view = container;
		}

		ViewUtil.setStructuralFeatureValue(view,
				NotationPackage.eINSTANCE.getDrawerStyle_Collapsed(), new Boolean(isCollapsed));

		return CommandResult.newOKCommandResult();
	}

	public boolean canExecute() {
		return true;
	}

}
