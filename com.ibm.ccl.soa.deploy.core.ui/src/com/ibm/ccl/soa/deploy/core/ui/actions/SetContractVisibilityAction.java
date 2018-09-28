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

import java.lang.reflect.Proxy;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

import org.eclipse.core.commands.operations.IUndoableOperation;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.gef.EditPart;
import org.eclipse.gef.Request;
import org.eclipse.gmf.runtime.diagram.core.util.ViewUtil;
import org.eclipse.gmf.runtime.diagram.ui.actions.DiagramAction;
import org.eclipse.gmf.runtime.diagram.ui.editparts.IGraphicalEditPart;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.ui.IWorkbenchPage;

import com.ibm.ccl.soa.deploy.core.DeployModelObject;
import com.ibm.ccl.soa.deploy.core.Import;
import com.ibm.ccl.soa.deploy.core.Unit;
import com.ibm.ccl.soa.deploy.core.operation.UpdateContractOperation;
import com.ibm.ccl.soa.deploy.core.ui.DeployCoreUIPlugin;
import com.ibm.ccl.soa.deploy.core.ui.ISharedImages;
import com.ibm.ccl.soa.deploy.core.ui.Messages;
import com.ibm.ccl.soa.deploy.core.ui.properties.LightweightOperationFactory;
import com.ibm.ccl.soa.deploy.core.ui.util.GMFUtils;

public class SetContractVisibilityAction extends DiagramAction {
	private int contractFlag;

	protected SetContractVisibilityAction(IWorkbenchPage workbenchpage) {
		super(workbenchpage);

		init();
	}

	public void init() {
		super.init();
		setId(DeployActionIds.ACTION_SET_CONTRACT_STATE);
		setToolTipText(Messages.SetContractVisibilityAction_Set_Contract_Visibilit_);
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
			if (eo != null && Proxy.isProxyClass(eo.getClass())
					|| !(eo instanceof Unit || eo instanceof Import)) {
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
		DeployModelObject selected = null;
		List<DeployModelObject> units = new LinkedList<DeployModelObject>(); //Gather up all the units in a list
		for (Iterator i = getSelectedObjects().iterator(); i.hasNext();) {
			EditPart ep = (EditPart) i.next();
			selected = (DeployModelObject) ViewUtil.resolveSemanticElement((View) ep.getModel());
			units.add(selected);
		}

		//TODO need to implement undoable support
		IUndoableOperation op = UpdateContractOperation.createUpdateContractOperation(units,
				contractFlag, Messages.SetContractVisibilityAction_Update_Contrac_);
		LightweightOperationFactory.execute(units.get(0), op);
	}

	public static SetContractVisibilityAction createSetAllPublicEditableAction(
			IWorkbenchPage workbenchPage) {
		SetContractVisibilityAction action = new SetContractVisibilityAction(workbenchPage);
		action.setText(Messages.SetContractVisibilityAction_Public_Editabl_);
		action.contractFlag = UpdateContractOperation.PUBLIC_EDITABLE_FLAG;
		action.setImageDescriptor(DeployCoreUIPlugin.getDefault().getSharedImages()
				.getImageDescriptor(ISharedImages.IMG_CONTRACT_PUBLIC_EDITABLE));
		action
				.setToolTipText(com.ibm.ccl.soa.deploy.core.ui.properties.Messages.RequirementsPopupDialog_Set_Public_Editabl_);
		return action;
	}

	public static SetContractVisibilityAction createSetAllPublicAction(IWorkbenchPage workbenchPage) {
		SetContractVisibilityAction action = new SetContractVisibilityAction(workbenchPage);
		action.setText(Messages.SetContractVisibilityAction_Publi_);
		action.contractFlag = UpdateContractOperation.PUBLIC_FLAG;
		action.setImageDescriptor(DeployCoreUIPlugin.getDefault().getSharedImages()
				.getImageDescriptor(ISharedImages.IMG_CONTRACT_PUBLIC));
		action
				.setToolTipText(com.ibm.ccl.soa.deploy.core.ui.properties.Messages.RequirementsPopupDialog_Set_Publi_);
		return action;
	}

	public static SetContractVisibilityAction createSetAllPrivateAction(IWorkbenchPage workbenchPage) {
		SetContractVisibilityAction action = new SetContractVisibilityAction(workbenchPage);
		action.setText(Messages.SetContractVisibilityAction_Privat_);
		action.contractFlag = UpdateContractOperation.PRIVATE_FLAG;
		action.setImageDescriptor(DeployCoreUIPlugin.getDefault().getSharedImages()
				.getImageDescriptor(ISharedImages.IMG_CONTRACT_PRIVATE));
		action
				.setToolTipText(com.ibm.ccl.soa.deploy.core.ui.properties.Messages.RequirementsPopupDialog_Set_Privat_);
		return action;
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

}
