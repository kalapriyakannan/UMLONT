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
import java.util.LinkedList;
import java.util.List;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.gmf.runtime.common.ui.action.ActionMenuManager;
import org.eclipse.gmf.runtime.diagram.ui.editparts.IGraphicalEditPart;
import org.eclipse.jface.action.Action;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.ui.IWorkbenchPage;

import com.ibm.ccl.soa.deploy.core.Topology;
import com.ibm.ccl.soa.deploy.core.Unit;
import com.ibm.ccl.soa.deploy.core.ui.Messages;
import com.ibm.ccl.soa.deploy.core.ui.util.DeployCoreImages;
import com.ibm.ccl.soa.deploy.core.ui.util.GMFUtils;

/**
 * Context popup menu: "Remove from Group"
 * 
 * @author <a href="mailto:sunyingl@cn.ibm.com">Neo Sun</a>
 * @see AddToGroupMenuManager
 */
public class RemoveFromGroupMenuManager extends ActionMenuManager {

	/**
	 * @param workbenchPage
	 */
	public RemoveFromGroupMenuManager(IWorkbenchPage workbenchPage) {
		super(DeployActionIds.MENU_REMOVE_FROM_GROUP, new RemoveFromGroupMenuAction(), true);

		populateMenu(workbenchPage);
	}

	private void populateMenu(IWorkbenchPage workbenchPage) {
		// if any selections are a DiagramNodeEditPart, add nothing-- diagram nodes cannot be part of a group
		if (GMFUtils.isDiagramNodeSelected((IStructuredSelection) workbenchPage.getSelection())) {
			return;
		}

		add(new RemoveFromAllGroupsAction(workbenchPage));

//		add(new RemoveFromCurrentGroupsAction(workbenchPage));

		// We only want to remove if a single Unit is selected.  If user did multiple
		// units, it is too confusing to allow any membership to be broken.
		List l = getSelectedUnits(workbenchPage);
		if (l.size() == 1) {
			EObject eo = (EObject) l.get(0);
			if (eo instanceof Unit) {
				Unit member = (Unit) eo;
				Topology top = member.getTopology();
				if (top != null) {
					Unit[] containers = top.findMemberOf(member);
					for (int i = 0; i < containers.length; i++) {
						add(new RemoveFromContainerAction(workbenchPage, member, containers[i]));
					}
				}
			}
		}

		add(new RemoveFromDiagramAction(workbenchPage));
	}

	private List getSelectedUnits(IWorkbenchPage workbenchPage) {
		IStructuredSelection selection = (IStructuredSelection) workbenchPage.getSelection();
		Iterator iterator = selection.iterator();

		List retVal = new LinkedList();
		while (iterator.hasNext()) {
			IGraphicalEditPart selectedEP = (IGraphicalEditPart) iterator.next();
			retVal.add(selectedEP.getNotationView().getElement());
		}

		return retVal;
	}

	private static class RemoveFromGroupMenuAction extends Action {
		/**
		 * constructor which sets name and image for this menu
		 */
		public RemoveFromGroupMenuAction() {
			setText(Messages.GROUP_MENU_REMOVE_FROM);
			setImageDescriptor(DeployCoreImages.IMAGEDSC_REMOVE_FROM_MENU);
		}
	}
}
