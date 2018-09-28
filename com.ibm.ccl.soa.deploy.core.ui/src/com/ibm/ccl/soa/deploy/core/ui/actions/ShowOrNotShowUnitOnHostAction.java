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
import com.ibm.ccl.soa.deploy.core.ui.internal.commands.ShowOrNotShowUnitOnHostCommand;
import com.ibm.ccl.soa.deploy.core.ui.util.ContainmentStateUtils;
import com.ibm.ccl.soa.deploy.core.ui.util.GMFUtils;

/**
 * 
 * @author <a href="mailto:sunyingl@cn.ibm.com">Neo Sun</a>
 */
public class ShowOrNotShowUnitOnHostAction extends DiagramAction {

	/**
	 * @param workbenchPage
	 */
	public ShowOrNotShowUnitOnHostAction(IWorkbenchPage workbenchPage) {
		super(workbenchPage);
		init();
	}

	protected Request createTargetRequest() {
		return null;
	}

	protected boolean isSelectionListener() {
		return true;
	}

	protected boolean calculateEnabled() {
		/**
		 * 1. Only one unit is selected. 2. The selected unit has been hosted on another unit through
		 * a hosting link.
		 */
		if (getSelectedObjects().size() == 1) {
			IGraphicalEditPart selectedEP = (IGraphicalEditPart) getSelectedObjects().get(0);

			// if in diagram/import diagram don't allow a change--always keep the orginating diagram's setting
			// since copy to canvas copies directly from the source diagram-- ok with imports since their views only
			// exist in current topology
			if (GMFUtils.getDiagram(selectedEP) == null) {
				setText(Messages.DONOT_SHOW_UNIT_ON_HOST_ACTION_LABEL);
				EObject eo = selectedEP.getNotationView().getElement();
				if (eo instanceof Unit) {
					Unit selectedUnit = (Unit) eo;
					if (GMFUtils.getAllHosts(selectedUnit).size() > 0) {
						if (ContainmentStateUtils.isContainedUnit(selectedEP, selectedUnit)) {
							setText(Messages.DONOT_SHOW_UNIT_ON_HOST_ACTION_LABEL);
						} else {
							setText(Messages.SHOW_UNIT_ON_HOST_ACTION_LABEL);
						}
						return true;
					}
				}
			}
		}

		// Set the default menu text 
		setText(Messages.SHOW_UNIT_ON_HOST_ACTION_LABEL);
		return false;
	}

	protected void doRun(IProgressMonitor progressMonitor) {
		ShowOrNotShowUnitOnHostCommand showOrNotShowCmd = new ShowOrNotShowUnitOnHostCommand(
				(DeployShapeNodeEditPart) getSelectedObjects().get(0));
		DiagramCommandStack cmdStack = getDiagramEditPart().getDiagramEditDomain()
				.getDiagramCommandStack();
		cmdStack.execute(new ICommandProxy(showOrNotShowCmd));
	}
}
