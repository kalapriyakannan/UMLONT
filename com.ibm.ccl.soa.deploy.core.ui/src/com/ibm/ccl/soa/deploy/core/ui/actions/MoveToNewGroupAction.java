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

import java.util.List;

import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.gef.Request;
import org.eclipse.gmf.runtime.diagram.ui.actions.DiagramAction;
import org.eclipse.gmf.runtime.diagram.ui.commands.ICommandProxy;
import org.eclipse.gmf.runtime.diagram.ui.editparts.IGraphicalEditPart;
import org.eclipse.gmf.runtime.notation.Node;
import org.eclipse.ui.IWorkbenchPage;

import com.ibm.ccl.soa.deploy.core.Unit;
import com.ibm.ccl.soa.deploy.core.ui.Messages;
import com.ibm.ccl.soa.deploy.core.ui.editparts.DeployShapeNodeEditPart;
import com.ibm.ccl.soa.deploy.core.ui.internal.commands.MoveToNewGroupCommand;
import com.ibm.ccl.soa.deploy.core.ui.util.DeployCoreImages;
import com.ibm.ccl.soa.deploy.core.ui.util.GMFUtils;

/**
 * Context action for "Move to -> New Group"
 * 
 * @author <a href="mailto:sunyingl@cn.ibm.com">Neo Sun</a>
 */
public class MoveToNewGroupAction extends DiagramAction {
	/**
	 * @param workbenchPage
	 */
	public MoveToNewGroupAction(IWorkbenchPage workbenchPage) {
		super(workbenchPage);
		init();
		setText(Messages.GROUP_MENU_MOVE_TO_NEW_GROUP);
		setImageDescriptor(DeployCoreImages.IMAGEDSC_ADD_TO_NEW_GRP);
	}

	protected void doRun(IProgressMonitor progressMonitor) {
		MoveToNewGroupCommand move2NewGrpCmd = new MoveToNewGroupCommand(getSelectedObjects(),
				getDiagramEditPart());
		getDiagramCommandStack().execute(new ICommandProxy(move2NewGrpCmd), progressMonitor);
	}

	protected Request createTargetRequest() {
		return null;
	}

	protected boolean isSelectionListener() {
		return true;
	}

	protected boolean calculateEnabled() {
		List selectedUnits = getSelectedObjects();
		for (int i = 0; i < selectedUnits.size(); i++) {
			Object selected = selectedUnits.get(i);
			//Enable for units only
			if (!isUnit(selected)) {
				return false;
			}

			IGraphicalEditPart selectedEP = (IGraphicalEditPart) selected;

			// if a non configuratble unit in an imported topology, can't change
			if (GMFUtils.isNonMutableImport(selectedEP)) {
				return false;
			}
		}
		return true;
	}

	private boolean isUnit(Object obj) {
		if (obj instanceof DeployShapeNodeEditPart) {
			DeployShapeNodeEditPart editPart = (DeployShapeNodeEditPart) obj;
			if (editPart.getModel() instanceof Node) {
				if (((Node) editPart.getModel()).getElement() instanceof Unit) {
					return true;
				}
			}
		}
		return false;
	}

}
