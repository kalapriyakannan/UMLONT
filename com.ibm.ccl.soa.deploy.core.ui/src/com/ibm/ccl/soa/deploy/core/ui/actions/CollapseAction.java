/*******************************************************************************
 * Copyright (c) 2003, 2007 IBM Corporation Licensed Material - Property of IBM. All rights reserved.
 *  
 * US Government Users Restricted Rights - Use, duplication or disclosure v1.0 restricted by GSA ADP
 * Schedule Contract with IBM Corp.
 * 
 * Contributors: IBM Corporation - initial API and implementation
 *******************************************************************************/

package com.ibm.ccl.soa.deploy.core.ui.actions;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.emf.transaction.util.TransactionUtil;
import org.eclipse.gef.Request;
import org.eclipse.gmf.runtime.diagram.ui.actions.DiagramAction;
import org.eclipse.gmf.runtime.diagram.ui.commands.ICommandProxy;
import org.eclipse.ui.IWorkbenchPage;

import com.ibm.ccl.soa.deploy.core.ui.DeployCoreUIPlugin;
import com.ibm.ccl.soa.deploy.core.ui.ISharedImages;
import com.ibm.ccl.soa.deploy.core.ui.Messages;
import com.ibm.ccl.soa.deploy.core.ui.editparts.DeployDiagramEditPart;
import com.ibm.ccl.soa.deploy.core.ui.editparts.DeployShapeNodeEditPart;
import com.ibm.ccl.soa.deploy.core.ui.internal.commands.CollapseAllCommand;

/**
 * The Collapse Action: collapes a container editpart or a set of selected editparts
 * 
 * @author jswanke
 */
public class CollapseAction extends DiagramAction {

	private boolean selectionOnly;

	/**
	 * @param workbenchPage
	 */
	protected CollapseAction(IWorkbenchPage workbenchPage, boolean selectionOnly) {
		super(workbenchPage);
		this.selectionOnly = selectionOnly;
	}

	private boolean isCollapseAll() {
		return !selectionOnly;
	}

	protected boolean calculateEnabled() {
		if (isCollapseAll()) {
			return true;
		}
		for (Iterator it = getSelectedObjects().iterator(); it.hasNext();) {
			if (it.next() instanceof DeployShapeNodeEditPart) {
				return true;
			}
		}
		return false;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.gmf.runtime.common.ui.action.AbstractActionHandler#isSelectionListener()
	 */
	protected boolean isSelectionListener() {
		return true;
	}

	@Override
	protected Request createTargetRequest() {
		return null;
	}

	protected void doRun(IProgressMonitor progressMonitor) {
		DeployDiagramEditPart ddep = (DeployDiagramEditPart) getDiagramEditPart();
		List selectedObjs = null;
		if (isCollapseAll()) {
			selectedObjs = new ArrayList();
			selectedObjs.add(ddep);
		} else {
			selectedObjs = getSelectedObjects();
		}
		TransactionalEditingDomain domain = TransactionUtil.getEditingDomain(ddep
				.resolveSemanticElement());
		CollapseAllCommand collapseCmd = new CollapseAllCommand(domain,
				isCollapseAll() ? Messages.CollapseAction_Collapse_Al_
						: Messages.CollapseAction_Collapse_Selectio_, selectedObjs);
		execute(new ICommandProxy(collapseCmd), progressMonitor);
	}

	/**
	 * Creates the Collapse All action
	 * 
	 * @param workbenchPage
	 * @return CollapseAction
	 */
	public static CollapseAction createArrangeAllAction(IWorkbenchPage workbenchPage) {
		CollapseAction action = new CollapseAction(workbenchPage, false);
		action.setId(DeployActionIds.ACTION_COLLAPSE_ALL);
		action.setText(Messages.CollapseAction_Collapse_Al_);
		action.setToolTipText(Messages.CollapseAction_Collapse_Al_);
		ISharedImages sharedImages = DeployCoreUIPlugin.getDefault().getSharedImages();
		action.setImageDescriptor(sharedImages
				.getImageDescriptor(ISharedImages.IMG_TOOL_COLLAPSE_ALL));
		action.setDisabledImageDescriptor(sharedImages
				.getImageDescriptor(ISharedImages.IMG_TOOL_COLLAPSE_ALL_DISABLED));
		action.setHoverImageDescriptor(sharedImages
				.getImageDescriptor(ISharedImages.IMG_TOOL_COLLAPSE_ALL));
		return action;
	}

	/**
	 * Creates the Collapse All action for the toolbar menu
	 * 
	 * @param workbenchPage
	 * @return CollapseAction
	 */
	public static CollapseAction createToolbarArrangeAllAction(IWorkbenchPage workbenchPage) {
		CollapseAction action = new CollapseAction(workbenchPage, false);
		action.setId(DeployActionIds.ACTION_TOOLBAR_COLLAPSE_ALL);
		action.setText(Messages.CollapseAction_Collapse_Al_);
		action.setToolTipText(Messages.CollapseAction_Collapse_Al_);
		ISharedImages sharedImages = DeployCoreUIPlugin.getDefault().getSharedImages();
		action.setImageDescriptor(sharedImages
				.getImageDescriptor(ISharedImages.IMG_TOOL_COLLAPSE_ALL));
		action.setDisabledImageDescriptor(sharedImages
				.getImageDescriptor(ISharedImages.IMG_TOOL_COLLAPSE_ALL_DISABLED));
		action.setHoverImageDescriptor(sharedImages
				.getImageDescriptor(ISharedImages.IMG_TOOL_COLLAPSE_ALL));
		return action;
	}

	/**
	 * Creates the Collapse Selection Only action
	 * 
	 * @param workbenchPage
	 * @return CollapseAction
	 */
	public static CollapseAction createArrangeSelectionAction(IWorkbenchPage workbenchPage) {
		CollapseAction action = new CollapseAction(workbenchPage, true);
		action.setId(DeployActionIds.ACTION_COLLAPSE_SELECTION);
		action.setText(Messages.CollapseAction_Collapse_Selectio_);
		action.setToolTipText(Messages.CollapseAction_Collapse_Selectio_);
		ISharedImages sharedImages = DeployCoreUIPlugin.getDefault().getSharedImages();
		action.setImageDescriptor(sharedImages
				.getImageDescriptor(ISharedImages.IMG_TOOL_COLLAPSE_SELECTED));
		action.setDisabledImageDescriptor(sharedImages
				.getImageDescriptor(ISharedImages.IMG_TOOL_COLLAPSE_SELECTED_DISABLED));
		action.setHoverImageDescriptor(sharedImages
				.getImageDescriptor(ISharedImages.IMG_TOOL_COLLAPSE_SELECTED));
		return action;
	}

	/**
	 * Creates the Collapse Selection Only action for the toolbar menu
	 * 
	 * @param workbenchPage
	 * @return CollapseAction
	 */
	public static CollapseAction createToolbarArrangeSelectionAction(IWorkbenchPage workbenchPage) {
		CollapseAction action = new CollapseAction(workbenchPage, true);
		action.setId(DeployActionIds.ACTION_TOOLBAR_COLLAPSE_SELECTION);
		action.setText(Messages.CollapseAction_Collapse_Selectio_);
		action.setToolTipText(Messages.CollapseAction_Collapse_Selectio_);
		ISharedImages sharedImages = DeployCoreUIPlugin.getDefault().getSharedImages();
		action.setImageDescriptor(sharedImages
				.getImageDescriptor(ISharedImages.IMG_TOOL_COLLAPSE_SELECTED));
		action.setDisabledImageDescriptor(sharedImages
				.getImageDescriptor(ISharedImages.IMG_TOOL_COLLAPSE_SELECTED_DISABLED));
		action.setHoverImageDescriptor(sharedImages
				.getImageDescriptor(ISharedImages.IMG_TOOL_COLLAPSE_SELECTED));
		return action;
	}
}
