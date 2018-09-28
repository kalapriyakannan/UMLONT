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
import org.eclipse.gmf.runtime.notation.Node;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.ui.IWorkbenchPage;

import com.ibm.ccl.soa.deploy.core.ConceptualNode;
import com.ibm.ccl.soa.deploy.core.Unit;
import com.ibm.ccl.soa.deploy.core.ui.DeployCoreUIPlugin;
import com.ibm.ccl.soa.deploy.core.ui.ISharedImages;
import com.ibm.ccl.soa.deploy.core.ui.Messages;
import com.ibm.ccl.soa.deploy.core.ui.editparts.DeployShapeNodeEditPart;
import com.ibm.ccl.soa.deploy.core.ui.editparts.TopologyEditPart;
import com.ibm.ccl.soa.deploy.core.ui.util.GMFUtils;

/**
 * This action is used to toggle conceptual attribute on a unit.
 */
public class ToggleConceptualAction extends DiagramAction {
	private final boolean setConceptual;

	/**
	 * @param workbenchPage
	 */
	public ToggleConceptualAction(IWorkbenchPage workbenchPage, boolean setConceptual) {
		super(workbenchPage);
		this.setConceptual = setConceptual;

		init();
	}

	public void init() {
		super.init();

		setId(DeployActionIds.ACTION_TOGGLE_CONCEPTUAL);
		setToolTipText(Messages.CONCEPTUAL_TOOLTIP);
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
			if (!isNonConceptualNodeUnit(ep)) {
				return false;
			}
			EObject eo = ep.resolveSemanticElement();
			if (!(eo instanceof Unit)) {
				return false;
			}
		}
		return true;
	}

	private boolean isNonConceptualNodeUnit(Object element) {
		if (element instanceof DeployShapeNodeEditPart) {
			DeployShapeNodeEditPart editPart = (DeployShapeNodeEditPart) element;
			if (editPart.getModel() instanceof Node) {
				Node node = (Node) editPart.getModel();
				//disable action for conceptual nodes
				if (node.getElement() instanceof Unit && !(node.getElement() instanceof ConceptualNode)) {
					return true;
				}
			}
		}
		return false;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.gmf.runtime.common.ui.action.AbstractActionHandler#doRun(org.eclipse.core.runtime.IProgressMonitor)
	 */
	protected void doRun(IProgressMonitor progressMonitor) {
		AbstractTransactionalCommand toggleCmd = new AbstractTransactionalCommand(
				getDiagramEditPart().getEditingDomain(), getToolTipText(), null) {

			protected CommandResult doExecuteWithResult(IProgressMonitor monitor, IAdaptable info) {
				for (Iterator i = getSelectedObjects().iterator(); i.hasNext();) {
					EditPart ep = (EditPart) i.next();
					Unit unit = (Unit) ViewUtil.resolveSemanticElement((View) ep.getModel());
					unit.setConceptual(setConceptual);

					// update figure
					if (ep instanceof TopologyEditPart) {
						TopologyEditPart uep = (TopologyEditPart) ep;
						uep.refreshValues();
						uep.getFigure().invalidate();
						uep.getFigure().repaint();
					}
					// reselect unit
					ep.getViewer().deselect(ep);
					ep.getViewer().appendSelection(ep);
				}

				return CommandResult.newOKCommandResult();
			}
		};

		DiagramCommandStack cmdStack = getDiagramEditPart().getDiagramEditDomain()
				.getDiagramCommandStack();
		cmdStack.execute(new ICommandProxy(toggleCmd));
	}

	public static ToggleConceptualAction createSetAllConceptual(IWorkbenchPage workbenchPage) {
		ToggleConceptualAction action = new ToggleConceptualAction(workbenchPage, true);
		action.setText(Messages.ToggleConceptualAction_Conceptua_);
		action.setImageDescriptor(DeployCoreUIPlugin.getDefault().getSharedImages()
				.getImageDescriptor(ISharedImages.IMG_CONCEPTUAL));
		return action;
	}

	public static ToggleConceptualAction createSetAllNonConceptual(IWorkbenchPage workbenchPage) {
		ToggleConceptualAction action = new ToggleConceptualAction(workbenchPage, false);
		action.setText(Messages.ToggleConceptualAction_Non_Conceptua_);
		action.setImageDescriptor(DeployCoreUIPlugin.getDefault().getSharedImages()
				.getImageDescriptor(ISharedImages.IMG_NON_CONCEPTUAL));
		return action;
	}

	protected Request createTargetRequest() {
		return null;
	}

	protected boolean isSelectionListener() {
		return true;
	}
}
