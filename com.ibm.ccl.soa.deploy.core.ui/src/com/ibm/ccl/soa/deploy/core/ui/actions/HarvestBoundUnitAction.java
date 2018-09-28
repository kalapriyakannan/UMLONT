/***************************************************************************************************
 * Copyright (c) 2003, 2008 IBM Corporation Licensed Material - Property of IBM. All rights
 * reserved.
 * 
 * US Government Users Restricted Rights - Use, duplication or disclosure v1.0 restricted by GSA ADP
 * Schedule Contract with IBM Corp.
 * 
 * Contributors: IBM Corporation - initial API and implementation
 **************************************************************************************************/

package com.ibm.ccl.soa.deploy.core.ui.actions;

import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.gef.Request;
import org.eclipse.gmf.runtime.diagram.ui.actions.DiagramAction;
import org.eclipse.gmf.runtime.diagram.ui.commands.ICommandProxy;
import org.eclipse.gmf.runtime.diagram.ui.editparts.IGraphicalEditPart;
import org.eclipse.gmf.runtime.diagram.ui.parts.DiagramCommandStack;
import org.eclipse.ui.IWorkbenchPage;

import com.ibm.ccl.soa.deploy.core.Unit;
import com.ibm.ccl.soa.deploy.core.ui.Messages;
import com.ibm.ccl.soa.deploy.core.ui.editparts.DeployShapeNodeEditPart;
import com.ibm.ccl.soa.deploy.core.ui.internal.commands.HarvestBoundUnitCommand;

/**
 */
public class HarvestBoundUnitAction extends DiagramAction {

	/**
	 * @param workbenchPage
	 */
	public HarvestBoundUnitAction(IWorkbenchPage workbenchPage) {
		super(workbenchPage);
		init();
		setText(Messages.HarvestBoundUnitCommand_HarvestBoundUnit);
	}

	protected Request createTargetRequest() {
		return null;
	}

	protected boolean isSelectionListener() {
		return true;
	}

	protected boolean calculateEnabled() {
		// Chad-- just guessing here
		if (getSelectedObjects().size() == 1
				&& getSelectedObjects().get(0) instanceof IGraphicalEditPart) {
			IGraphicalEditPart selectedEP = (IGraphicalEditPart) getSelectedObjects().get(0);
			EObject eo = selectedEP.getNotationView().getElement();
			if (eo instanceof Unit) {
				Unit selectedUnit = (Unit) eo;
				if (selectedUnit.isBound()) {
					return true;
				}
			}
		}
		return false;
	}

	protected void doRun(IProgressMonitor progressMonitor) {
		HarvestBoundUnitCommand cmd = new HarvestBoundUnitCommand(
				(DeployShapeNodeEditPart) getSelectedObjects().get(0));
		DiagramCommandStack cmdStack = getDiagramEditPart().getDiagramEditDomain()
				.getDiagramCommandStack();
		cmdStack.execute(new ICommandProxy(cmd));
	}
}
