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
import java.util.Set;

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
import com.ibm.ccl.soa.deploy.core.ui.util.DeployCoreImages;
import com.ibm.ccl.soa.deploy.core.ui.util.GMFUtils;
import com.ibm.ccl.soa.deploy.core.validator.DeployValidatorService;
import com.ibm.ccl.soa.deploy.core.validator.matcher.LinkType;

/**
 * @author <a href="mailto:sunyingl@cn.ibm.com">Neo Sun</a>
 * 
 * @see AddToNewGroupAction
 * @see AddCopyToDiagramAction
 * @see AddUnitToExistingGroupAction
 */
public class AddToGroupMenuManager extends ActionMenuManager {

	private final IWorkbenchPage workbenchPage;
	private final Set selectedUnits;

	/**
	 * @param workbenchPage
	 */
	public AddToGroupMenuManager(IWorkbenchPage workbenchPage) {
		super(DeployActionIds.MENU_ADD_TO_GROUP, new AddToGroupMenuAction(), true);

		this.workbenchPage = workbenchPage;
		selectedUnits = getSelectedUnits();

		populateMenu();
	}

	private void populateMenu() {
		// if any selections are a DiagramNodeEditPart, add nothing-- diagram nodes cannot be part of a group
		if (GMFUtils.isDiagramNodeSelected((IStructuredSelection) workbenchPage.getSelection())) {
			return;
		}

		// if on an Import tree, just add copy to canvas
		for (Iterator<?> it = ((IStructuredSelection) workbenchPage.getSelection()).iterator(); it
				.hasNext();) {
			IGraphicalEditPart ep = (IGraphicalEditPart) it.next();
			if (GMFUtils.getImportTopologyEP(ep) != null) {
				add(new AddCopyToDiagramAction(workbenchPage));
				return;
			}
		}
		add(new AddToNewGroupAction(workbenchPage));
		add(new AddCopyToDiagramAction(workbenchPage));
		add(new Separator());

		// look up all unit groups and create one menu item for each
		IDiagramWorkbenchPart diagramWBPart = (IDiagramWorkbenchPart) workbenchPage.getActivePart();
		DiagramEditPart diagramEP = diagramWBPart.getDiagramEditPart();
		Topology topology = (Topology) diagramEP.getNotationView().getElement();
		Iterator iterator = topology.findAllUnits();
		while (iterator.hasNext()) {
			Unit unit = (Unit) iterator.next();
			if (unit.isGroup() && validateUnitGroup(unit)) {
				add(new AddUnitToExistingGroupAction(workbenchPage, unit));
//				// get the corresponding edit part  
//				UnitGroupEditPart groupEP = getUnitGroupEditPart(unit);
//				if (groupEP != null) {
//					add(new AddUnitToExistingGroupAction(workbenchPage, groupEP));
//				}
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

//    private UnitGroupEditPart getUnitGroupEditPart(Unit unit) {
//		IDiagramWorkbenchPart diagramWBPart = (IDiagramWorkbenchPart)workbenchPage.getActivePart();
//		Map epReg = diagramWBPart.getDiagramGraphicalViewer().getEditPartRegistry();
//		
//		List epList = GMFUtils.getEditPartsForUnit(epReg, unit);
//		if (epList.size() > 0)
//			return (UnitGroupEditPart)epList.get(0);
//		
//		return null;
//    }

	private static class AddToGroupMenuAction extends Action {
		/**
		 * constructor which sets name and image for this menu
		 */
		public AddToGroupMenuAction() {
			setText(Messages.GROUP_MENU_ADD_TO);
			setImageDescriptor(DeployCoreImages.IMAGEDSC_ADD_TO_GRP);
		}
	}
}
