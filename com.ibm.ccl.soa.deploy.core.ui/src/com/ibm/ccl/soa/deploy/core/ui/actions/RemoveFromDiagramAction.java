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
import org.eclipse.gmf.runtime.diagram.ui.parts.DiagramCommandStack;
import org.eclipse.gmf.runtime.emf.commands.core.command.AbstractTransactionalCommand;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.ui.IWorkbenchPage;

import com.ibm.ccl.soa.deploy.core.Topology;
import com.ibm.ccl.soa.deploy.core.Unit;
import com.ibm.ccl.soa.deploy.core.ui.Messages;
import com.ibm.ccl.soa.deploy.core.ui.editparts.DeployDiagramEditPart;
import com.ibm.ccl.soa.deploy.core.ui.editparts.DeployShapeNodeEditPart;
import com.ibm.ccl.soa.deploy.core.ui.util.DeployCoreImages;

/**
 * 
 * @author <a href="mailto:sunyingl@cn.ibm.com">Neo Sun</a>
 */
public class RemoveFromDiagramAction extends DiagramAction {

	/**
	 * @param workbenchPage
	 */
	public RemoveFromDiagramAction(IWorkbenchPage workbenchPage) {
		super(workbenchPage);

		init();

		setText(Messages.GROUP_MENU_REMOVE_FROM_CANVAS);
		setImageDescriptor(DeployCoreImages.IMAGEDSC_REMOVE_FROM_CURRENT_GRP);
	}

	protected Request createTargetRequest() {
		return null;
	}

	protected boolean isSelectionListener() {
		return true;
	}

	protected boolean calculateEnabled() {
		/**
		 * Be enabled when: 1. All selected editparts are on the diagram 2. There are member links to
		 * groups
		 */
		for (Iterator i = getSelectedObjects().iterator(); i.hasNext();) {
			Object selected = i.next();
			if (!(selected instanceof DeployShapeNodeEditPart)) {
				return false;
			}

			EditPart ep = (EditPart) selected;
			if (!(ep.getParent() instanceof DeployDiagramEditPart)) {
				return false;
			}

			EObject eo = ((View) ep.getModel()).getElement();
			if (!(eo instanceof Unit)) {
				return false;
			}

			Unit unit = (Unit) eo;
			Topology topology = unit.getTopology();
			Unit[] groups = topology.findMemberOf(unit);
			if (groups.length < 1) {
				return false;
			}
		}

		return true;
	}

	protected void doRun(IProgressMonitor progressMonitor) {
		String cmdLabel = Messages.CMD_LABEL_REMOVE_FROM_DIAGRAM;

		AbstractTransactionalCommand removeCmd = new AbstractTransactionalCommand(
				getDiagramEditPart().getEditingDomain(), cmdLabel, null) {

			protected CommandResult doExecuteWithResult(IProgressMonitor monitor, IAdaptable info) {
				for (Iterator i = getSelectedObjects().iterator(); i.hasNext();) {
					EditPart ep = (EditPart) i.next();
					ViewUtil.destroy((View) ep.getModel());
				}

				return CommandResult.newOKCommandResult();
			}
		};

		DiagramCommandStack cmdStack = getDiagramEditPart().getDiagramEditDomain()
				.getDiagramCommandStack();
		cmdStack.execute(new ICommandProxy(removeCmd));
	}
}
