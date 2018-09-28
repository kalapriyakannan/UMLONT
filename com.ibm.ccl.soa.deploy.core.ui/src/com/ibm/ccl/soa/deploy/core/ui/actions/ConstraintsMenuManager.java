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

import org.eclipse.gmf.runtime.common.ui.action.ActionMenuManager;
import org.eclipse.gmf.runtime.diagram.ui.editparts.IGraphicalEditPart;
import org.eclipse.jface.action.Action;
import org.eclipse.jface.action.Separator;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.ui.IWorkbenchPage;

import com.ibm.ccl.soa.deploy.core.Unit;
import com.ibm.ccl.soa.deploy.core.constraint.ShortConstraintDescriptor;
import com.ibm.ccl.soa.deploy.core.ui.Messages;
import com.ibm.ccl.soa.deploy.core.validator.ConstraintService;

/**
 * Constraint
 * 
 * @see AddToGroupMenuManager
 * @see ConstrainAction
 */
public class ConstraintsMenuManager extends ActionMenuManager {

	/**
	 * @param workbenchPage
	 */
	public ConstraintsMenuManager(IWorkbenchPage workbenchPage) {
		super(DeployActionIds.MENU_ADD_CONSTRAINTS, new ConstraintsMenuAction(), true);

		populateMenu(workbenchPage);
	}

	private void populateMenu(IWorkbenchPage workbenchPage) {

		// If there are exactly two selections, then there are possible constraints
		List<Unit> l = getSelectedUnits(workbenchPage);
		if (l.size() == 2) {

			Unit parent1 = l.get(0);
			Unit parent2 = l.get(1);

			if (parent1 != null && parent2 != null) {
				for (ShortConstraintDescriptor scd : ConstraintService.INSTANCE.applicableConstraints(
						parent1, parent2)) {
					add(new ConstrainAction(parent1, parent2, scd));
				}

			}
		}

		add(new Separator("oclconstraints")); //$NON-NLS-1$
	}

	private List<Unit> getSelectedUnits(IWorkbenchPage workbenchPage) {
		IStructuredSelection selection = (IStructuredSelection) workbenchPage.getSelection();
		Iterator<?> iterator = selection.iterator();

		List<Unit> retVal = new LinkedList<Unit>();
		while (iterator.hasNext()) {
			IGraphicalEditPart selectedEP = (IGraphicalEditPart) iterator.next();
			Object obj = selectedEP.getNotationView().getElement();
			if (obj instanceof Unit) {
				retVal.add((Unit) obj);
			}
		}

		return retVal;
	}

	private static class ConstraintsMenuAction extends Action {
		/**
		 * constructor which sets name and image for this menu
		 */
		public ConstraintsMenuAction() {
			setText(Messages.ConstraintsMenuManager_Add_Constrain_);
			//			setImageDescriptor(DeployCoreImages.IMAGEDSC_REMOVE_FROM_MENU);
		}
	}
}
