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

import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.eclipse.gef.EditPartViewer;
import org.eclipse.gmf.runtime.common.ui.action.ActionMenuManager;
import org.eclipse.gmf.runtime.diagram.ui.editparts.DiagramEditPart;
import org.eclipse.gmf.runtime.diagram.ui.editparts.IGraphicalEditPart;
import org.eclipse.gmf.runtime.diagram.ui.parts.IDiagramWorkbenchPart;
import org.eclipse.jface.action.Action;
import org.eclipse.jface.action.Separator;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.ui.IWorkbenchPage;

import com.ibm.ccl.soa.deploy.core.Topology;
import com.ibm.ccl.soa.deploy.core.Unit;
import com.ibm.ccl.soa.deploy.core.ui.Messages;
import com.ibm.ccl.soa.deploy.core.ui.editparts.DeployShapeNodeEditPart;
import com.ibm.ccl.soa.deploy.core.ui.util.DeployCoreImages;
import com.ibm.ccl.soa.deploy.core.ui.util.GMFUtils;
import com.ibm.ccl.soa.deploy.core.validator.DeployValidatorService;
import com.ibm.ccl.soa.deploy.core.validator.matcher.LinkType;

/**
 * Move to group content menu
 * 
 * @author <a href="mailto:sunyingl@cn.ibm.com">Neo Sun</a>
 */
public class MoveToGroupMenuManager extends ActionMenuManager {
	private final IWorkbenchPage workbenchPage;
	private final Set selectedUnits;

	/**
	 * @param workbenchPage
	 */
	public MoveToGroupMenuManager(IWorkbenchPage workbenchPage) {
		super(DeployActionIds.MENU_MOVE_TO_GROUP, new MoveToGroupMenuAction(), true);

		this.workbenchPage = workbenchPage;
		selectedUnits = getSelectedUnits();

		populateMenu();
	}

	private void populateMenu() {
		// if any selections are a DiagramNodeEditPart, add nothing-- diagram nodes cannot be part of a group
		if (GMFUtils.isDiagramNodeSelected((IStructuredSelection) workbenchPage.getSelection())) {
			return;
		}
		add(new MoveToNewGroupAction(workbenchPage));
		add(new MoveToDiagramAction(workbenchPage));
		add(new Separator());

		// look up all unit groups and create one menu item for each
		IDiagramWorkbenchPart diagramWBPart = (IDiagramWorkbenchPart) workbenchPage.getActivePart();
		DiagramEditPart diagramEP = diagramWBPart.getDiagramEditPart();
		Topology topology = (Topology) diagramEP.getNotationView().getElement();
		Iterator iterator = topology.findAllUnits();
		while (iterator.hasNext()) {
			Unit unit = (Unit) iterator.next();
			if (unit.isGroup() && validateUnitGroup(unit)) {
				// get the corresponding edit part  
				DeployShapeNodeEditPart ep = getEditPart(unit);
				if (ep != null) {
					add(new MoveToExistingGroupAction(workbenchPage, ep));
				}
			}
		}
	}

	private boolean validateUnitGroup(Unit unitGroup) {
		DeployValidatorService dvs = DeployValidatorService.getDefaultValidatorService();

		Iterator iterator = selectedUnits.iterator();
		while (iterator.hasNext()) {
			Unit unit = (Unit) iterator.next();
			if (!dvs.canCreateLink(unitGroup, unit, LinkType.MEMBER_SET).isOK()) {
				return false;
			}
		}

		return true;
	}

	/**
	 * @return selected units
	 */
	private Set<Unit> getSelectedUnits() {
		IStructuredSelection selection = (IStructuredSelection) workbenchPage.getSelection();
		Iterator iterator = selection.iterator();

		Set<Unit> set = new HashSet<Unit>();
		while (iterator.hasNext()) {
			IGraphicalEditPart selectedEP = (IGraphicalEditPart) iterator.next();
			if (selectedEP.getNotationView().getElement() instanceof Unit) {
				set.add((Unit) selectedEP.getNotationView().getElement());
			}
		}

		return set;
	}

	private DeployShapeNodeEditPart getEditPart(Unit unit) {
		IDiagramWorkbenchPart diagramWBPart = (IDiagramWorkbenchPart) workbenchPage.getActivePart();
		EditPartViewer viewer = diagramWBPart.getDiagramGraphicalViewer();
		List epList = GMFUtils.getEditPartsFor(viewer, unit);
		if (epList.size() > 0) {
			return (DeployShapeNodeEditPart) epList.get(0);
		}

		return null;
	}

	private static class MoveToGroupMenuAction extends Action {
		/**
		 * constructor which sets name and image for this menu
		 */
		public MoveToGroupMenuAction() {
			setText(Messages.GROUP_MENU_MOVE_TO);
			setImageDescriptor(DeployCoreImages.IMAGEDSC_MOVE_TO_MENU);
		}
	}

}
