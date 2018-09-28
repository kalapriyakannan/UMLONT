/*******************************************************************************
 * Copyright (c) 2003, 2007 IBM Corporation Licensed Material - Property of IBM. All rights reserved.
 *  
 * US Government Users Restricted Rights - Use, duplication or disclosure v1.0 restricted by GSA ADP
 * Schedule Contract with IBM Corp.
 * 
 * Contributors: IBM Corporation - initial API and implementation
 *******************************************************************************/

package com.ibm.ccl.soa.deploy.core.ui.actions;

import java.util.List;

import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.gef.Request;
import org.eclipse.gmf.runtime.diagram.ui.actions.DiagramAction;
import org.eclipse.gmf.runtime.diagram.ui.commands.ICommandProxy;
import org.eclipse.gmf.runtime.diagram.ui.editparts.IGraphicalEditPart;
import org.eclipse.gmf.runtime.diagram.ui.parts.DiagramCommandStack;
import org.eclipse.ui.IWorkbenchPage;

import com.ibm.ccl.soa.deploy.core.Topology;
import com.ibm.ccl.soa.deploy.core.Unit;
import com.ibm.ccl.soa.deploy.core.ui.Messages;
import com.ibm.ccl.soa.deploy.core.ui.editparts.DeployDiagramEditPart;
import com.ibm.ccl.soa.deploy.core.ui.editparts.DeployShapeNodeEditPart;
import com.ibm.ccl.soa.deploy.core.ui.internal.commands.RemoveFromGroupCommand;
import com.ibm.ccl.soa.deploy.core.ui.util.DeployCoreImages;
import com.ibm.ccl.soa.deploy.core.ui.util.GMFUtils;

/**
 * 
 * @author <a href="mailto:sunyingl@cn.ibm.com">Neo Sun</a>
 */
public class RemoveFromCurrentGroupsAction extends DiagramAction {

	/**
	 * @param workbenchPage
	 */
	public RemoveFromCurrentGroupsAction(IWorkbenchPage workbenchPage) {
		super(workbenchPage);

		init();

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
		 * judge conditions 1. Every selected unit is the member of some unit group 2. None of
		 * selected edit parts is the direct child of the diagram edit part.
		 */
		List selectedUnits = getSelectedObjects();

		if (selectedUnits.size() > 1) {
			setText(Messages.GROUP_MENU_REMOVE_FROM_CURRENT_GROUPS);
		} else {
			setText(Messages.GROUP_MENU_REMOVE_FROM_CURRENT_GROUP);
		}

		for (int i = 0; i < selectedUnits.size(); i++) {
			Object selected = selectedUnits.get(i);
			if (!(selected instanceof DeployShapeNodeEditPart))
				return false;

			IGraphicalEditPart selectedEP = (IGraphicalEditPart) selected;

			// if a non configuratble unit in an imported topology, can't change
			if (GMFUtils.isNonMutableImport(selectedEP))
				return false;

			if (selectedEP.getParent() instanceof DeployDiagramEditPart)
				return false;

			Unit unit = (Unit) selectedEP.getNotationView().getElement();
			Topology topology = (Topology) getDiagramEditPart().getNotationView().getElement();
			Unit[] containers = topology.findMemberOf(unit);
			if (containers.length <= 0)
				return false;
		}

		return true;
	}

	protected void doRun(IProgressMonitor progressMonitor) {
		RemoveFromGroupCommand removeFromGroupCmd = new RemoveFromGroupCommand(getSelectedObjects(),
				false, getDiagramEditPart());
		DiagramCommandStack cmdStack = getDiagramEditPart().getDiagramEditDomain()
				.getDiagramCommandStack();
		cmdStack.execute(new ICommandProxy(removeFromGroupCmd));
	}
}
