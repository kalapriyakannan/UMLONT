/***************************************************************************************************
 * Copyright (c) 2003, 2007 IBM Corporation Licensed Material - Property of IBM. All rights
 * reserved.
 * 
 * US Government Users Restricted Rights - Use, duplication or disclosure v1.0 restricted by GSA ADP
 * Schedule Contract with IBM Corp.
 * 
 * Contributors: IBM Corporation - initial API and implementation
 **************************************************************************************************/
package com.ibm.ccl.soa.deploy.core.ui.actions;

import java.util.Iterator;

import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.gef.EditPart;
import org.eclipse.gef.Request;
import org.eclipse.gmf.runtime.common.core.command.CommandResult;
import org.eclipse.gmf.runtime.diagram.core.util.ViewUtil;
import org.eclipse.gmf.runtime.diagram.ui.actions.DiagramAction;
import org.eclipse.gmf.runtime.diagram.ui.commands.ICommandProxy;
import org.eclipse.gmf.runtime.diagram.ui.editparts.IGraphicalEditPart;
import org.eclipse.gmf.runtime.diagram.ui.parts.DiagramCommandStack;
import org.eclipse.gmf.runtime.emf.commands.core.command.AbstractTransactionalCommand;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.ui.IWorkbenchPage;

import com.ibm.ccl.soa.deploy.core.InstallState;
import com.ibm.ccl.soa.deploy.core.Unit;
import com.ibm.ccl.soa.deploy.core.ui.DeployCoreUIPlugin;
import com.ibm.ccl.soa.deploy.core.ui.ISharedImages;
import com.ibm.ccl.soa.deploy.core.ui.Messages;
import com.ibm.ccl.soa.deploy.core.ui.util.GMFUtils;

public class SetInstallStateAction extends DiagramAction {
	private final InstallState init;
	private final InstallState goal;

	public SetInstallStateAction(IWorkbenchPage workbenchPage, InstallState init, InstallState goal) {
		super(workbenchPage);
		this.init = init;
		this.goal = goal;
		init();
	}

	public void init() {
		super.init();
		setId(DeployActionIds.ACTION_SET_INSTALL_STATE);
		setToolTipText(Messages.SetInstallStateAction_Set_Install_Stat_);
		setHoverImageDescriptor(getImageDescriptor());
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.gmf.runtime.diagram.ui.actions.DiagramAction#calculateEnabled()
	 */
	protected boolean calculateEnabled() {
		if (getSelectedObjects().isEmpty()) {
			return false;
		}

		for (Iterator i = getSelectedObjects().iterator(); i.hasNext();) {
			Object temp = i.next();
			if (!(temp instanceof IGraphicalEditPart)) {
				return false;
			}
			IGraphicalEditPart ep = (IGraphicalEditPart) temp;

			// if a non configuratble unit in an imported topology, can't change
			if (GMFUtils.isNonMutableImport(ep)) {
				return false;
			}

			EObject eo = ep.resolveSemanticElement();
			if (!(eo instanceof Unit)) {
				return false;
			}
		}
		return true;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.gmf.runtime.common.ui.action.AbstractActionHandler#doRun(org.eclipse.core.runtime.IProgressMonitor)
	 */
	protected void doRun(IProgressMonitor progressMonitor) {
		AbstractTransactionalCommand cmd = new AbstractTransactionalCommand(getDiagramEditPart()
				.getEditingDomain(), getToolTipText(), null) {

			protected CommandResult doExecuteWithResult(IProgressMonitor monitor, IAdaptable info) {
				for (Iterator i = getSelectedObjects().iterator(); i.hasNext();) {
					EditPart ep = (EditPart) i.next();
					Unit unit = (Unit) ViewUtil.resolveSemanticElement((View) ep.getModel());
					unit.setInitInstallState(init);
					unit.setGoalInstallState(goal);
				}
				return CommandResult.newOKCommandResult();
			}
		};

		DiagramCommandStack cmdStack = getDiagramEditPart().getDiagramEditDomain()
				.getDiagramCommandStack();
		cmdStack.execute(new ICommandProxy(cmd));
	}

	@Override
	protected Request createTargetRequest() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	protected boolean isSelectionListener() {
		// TODO Auto-generated method stub
		return false;
	}

	public static SetInstallStateAction createSetAllInstalledUninstalledAction(
			IWorkbenchPage workbenchPage) {
		SetInstallStateAction action = new SetInstallStateAction(workbenchPage,
				InstallState.INSTALLED_LITERAL, InstallState.NOT_INSTALLED_LITERAL);
		action
				.setText(com.ibm.ccl.soa.deploy.core.ui.properties.Messages.GeneralDmoSyncHelperModel_installed_uninstalled_);
		action.setImageDescriptor(DeployCoreUIPlugin.getDefault().getSharedImages()
				.getImageDescriptor(ISharedImages.IMG_INSTALL_UNINSTALL));
		return action;
	}

	public static SetInstallStateAction createSetAllInstalledUnknownAction(
			IWorkbenchPage workbenchPage) {
		SetInstallStateAction action = new SetInstallStateAction(workbenchPage,
				InstallState.INSTALLED_LITERAL, InstallState.UNKNOWN_LITERAL);
		action
				.setText(com.ibm.ccl.soa.deploy.core.ui.properties.Messages.GeneralDmoSyncHelperModel_installed_unknown_);
		action.setImageDescriptor(DeployCoreUIPlugin.getDefault().getSharedImages()
				.getImageDescriptor(ISharedImages.IMG_INSTALLED_UNKNOWN));
		return action;
	}

	public static SetInstallStateAction createSetAllUninstalledInstalledAction(
			IWorkbenchPage workbenchPage) {
		SetInstallStateAction action = new SetInstallStateAction(workbenchPage,
				InstallState.NOT_INSTALLED_LITERAL, InstallState.INSTALLED_LITERAL);
		action
				.setText(com.ibm.ccl.soa.deploy.core.ui.properties.Messages.GeneralDmoSyncHelperModel_uninstalled_installed_);
		action.setImageDescriptor(DeployCoreUIPlugin.getDefault().getSharedImages()
				.getImageDescriptor(ISharedImages.IMG_UNINSTALL_INSTALL));
		return action;
	}

	public static SetInstallStateAction createSetAllUninstalledUnknownAction(
			IWorkbenchPage workbenchPage) {
		SetInstallStateAction action = new SetInstallStateAction(workbenchPage,
				InstallState.NOT_INSTALLED_LITERAL, InstallState.UNKNOWN_LITERAL);
		action
				.setText(com.ibm.ccl.soa.deploy.core.ui.properties.Messages.GeneralDmoSyncHelperModel_uninstalled_unknown_);
		action.setImageDescriptor(DeployCoreUIPlugin.getDefault().getSharedImages()
				.getImageDescriptor(ISharedImages.IMG_UNINSTALLED_UNKNOWN));
		return action;
	}

	public static SetInstallStateAction createSetAllUnknownUninstalledAction(
			IWorkbenchPage workbenchPage) {
		SetInstallStateAction action = new SetInstallStateAction(workbenchPage,
				InstallState.UNKNOWN_LITERAL, InstallState.NOT_INSTALLED_LITERAL);
		action
				.setText(com.ibm.ccl.soa.deploy.core.ui.properties.Messages.GeneralDmoSyncHelperModel_unknown_uninstalled_);
		action.setImageDescriptor(DeployCoreUIPlugin.getDefault().getSharedImages()
				.getImageDescriptor(ISharedImages.IMG_UNKNOWN_UNINSTALL));
		return action;
	}

	public static SetInstallStateAction createSetAllUnknownInstalledAction(
			IWorkbenchPage workbenchPage) {
		SetInstallStateAction action = new SetInstallStateAction(workbenchPage,
				InstallState.UNKNOWN_LITERAL, InstallState.INSTALLED_LITERAL);
		action
				.setText(com.ibm.ccl.soa.deploy.core.ui.properties.Messages.GeneralDmoSyncHelperModel_unknown_installed_);
		action.setImageDescriptor(DeployCoreUIPlugin.getDefault().getSharedImages()
				.getImageDescriptor(ISharedImages.IMG_UNKNOWN_INSTALL));
		return action;
	}

	public static SetInstallStateAction createSetAllInstalledAction(IWorkbenchPage workbenchPage) {
		SetInstallStateAction action = new SetInstallStateAction(workbenchPage,
				InstallState.INSTALLED_LITERAL, InstallState.INSTALLED_LITERAL);
		action
				.setText(com.ibm.ccl.soa.deploy.core.ui.properties.Messages.GeneralDmoSyncHelperModel_installed_);
		action.setImageDescriptor(DeployCoreUIPlugin.getDefault().getSharedImages()
				.getImageDescriptor(ISharedImages.IMG_INSTALLED));
		return action;
	}

	public static SetInstallStateAction createSetAllUnistalledAction(IWorkbenchPage workbenchPage) {
		SetInstallStateAction action = new SetInstallStateAction(workbenchPage,
				InstallState.NOT_INSTALLED_LITERAL, InstallState.NOT_INSTALLED_LITERAL);
		action
				.setText(com.ibm.ccl.soa.deploy.core.ui.properties.Messages.GeneralDmoSyncHelperModel_uninstalled_);
		action.setImageDescriptor(DeployCoreUIPlugin.getDefault().getSharedImages()
				.getImageDescriptor(ISharedImages.IMG_UNINSTALLED));
		return action;
	}

	public static SetInstallStateAction createSetAllUnknownAction(IWorkbenchPage workbenchPage) {
		SetInstallStateAction action = new SetInstallStateAction(workbenchPage,
				InstallState.UNKNOWN_LITERAL, InstallState.UNKNOWN_LITERAL);
		action
				.setText(com.ibm.ccl.soa.deploy.core.ui.properties.Messages.GeneralDmoSyncHelperModel_unknown_);
		return action;
	}

}
