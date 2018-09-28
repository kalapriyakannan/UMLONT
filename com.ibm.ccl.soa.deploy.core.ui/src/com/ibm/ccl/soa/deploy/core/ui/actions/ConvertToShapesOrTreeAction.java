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

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.gef.EditPart;
import org.eclipse.gef.Request;
import org.eclipse.gef.editparts.AbstractGraphicalEditPart;
import org.eclipse.gmf.runtime.diagram.ui.actions.DiagramAction;
import org.eclipse.gmf.runtime.diagram.ui.commands.ICommandProxy;
import org.eclipse.gmf.runtime.diagram.ui.editparts.IGraphicalEditPart;
import org.eclipse.gmf.runtime.diagram.ui.parts.DiagramCommandStack;
import org.eclipse.gmf.runtime.notation.Diagram;
import org.eclipse.ui.IWorkbenchPage;

import com.ibm.ccl.soa.deploy.core.Import;
import com.ibm.ccl.soa.deploy.core.Unit;
import com.ibm.ccl.soa.deploy.core.ui.Messages;
import com.ibm.ccl.soa.deploy.core.ui.editparts.DeployDiagramEditPart;
import com.ibm.ccl.soa.deploy.core.ui.editparts.DeployShapeNodeEditPart;
import com.ibm.ccl.soa.deploy.core.ui.internal.commands.ConvertToShapesOrTreeCommand;

/**
 * 
 * @author jswanke
 */
public class ConvertToShapesOrTreeAction extends DiagramAction {
	private boolean _isShapesToTree = false;

	/**
	 * @param workbenchPage
	 */
	public ConvertToShapesOrTreeAction(IWorkbenchPage workbenchPage) {
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
		// Set the default menu text 
		setText(Messages.GroupShapesOrTreeAction_Convert_to_Tre_);
		for (Iterator<?> it = getSelectedObjects().iterator(); it.hasNext();) {
			IGraphicalEditPart selectedEP = (IGraphicalEditPart) it.next();
			EObject eo = selectedEP.resolveSemanticElement();
			if (!(eo instanceof Unit) && !(eo instanceof Diagram) && !(eo instanceof Import)) {
				return false;
			}
			EditPart parentEP = selectedEP.getParent();
			if (!(parentEP instanceof DeployDiagramEditPart)
					&& !DeployShapeNodeEditPart.isShapesMode(parentEP.getParent())) {
				return false;
			}
			if (DeployShapeNodeEditPart.isTreeMode(selectedEP)) {
				setText(Messages.GroupShapesOrTreeAction_Convert_to_Shape_Compartmen_);
				_isShapesToTree = false;
				return true;
			} else if (DeployShapeNodeEditPart.isShapesMode(selectedEP)) {
				setText(Messages.GroupShapesOrTreeAction_Convert_to_Tre_);
				_isShapesToTree = true;
				return true;
			}
		}
		return false;
	}

	protected void doRun(IProgressMonitor progressMonitor) {
		ConvertToShapesOrTreeCommand groupShapesOrTreeCmd = new ConvertToShapesOrTreeCommand(
				(DeployDiagramEditPart) getDiagramEditPart(), getFilteredSelectedObjects(),
				_isShapesToTree, getText());
		DiagramCommandStack cmdStack = getDiagramEditPart().getDiagramEditDomain()
				.getDiagramCommandStack();
		cmdStack.execute(new ICommandProxy(groupShapesOrTreeCmd));
	}

	private List<?> getFilteredSelectedObjects() {
		List<?> rawList = getSelectedObjects();
		List filteredList = new ArrayList();
		for (Iterator<?> it = rawList.iterator(); it.hasNext();) {
			Object obj = it.next();
			if (obj instanceof DeployDiagramEditPart || !(obj instanceof AbstractGraphicalEditPart)) {
				continue;
			}
			// pass thru all non deploy shapes and shapes that have no element
			else if (obj instanceof DeployShapeNodeEditPart) {
				DeployShapeNodeEditPart ep = (DeployShapeNodeEditPart) obj;
				EObject eo = ep.resolveSemanticElement();
				if (eo != null) {

					// filter out views whose parents are already selected
					if (isAnyParentSelected(ep, rawList)) {
						continue;
					}
				}

			}
			filteredList.add(obj);
		}
		return filteredList;
	}

	private boolean isAnyParentSelected(IGraphicalEditPart ep, List selectedObjs) {
		EditPart walker = ep;
		while (walker != null && !(walker instanceof DeployDiagramEditPart)) {
			walker = walker.getParent();
			if (selectedObjs.contains(walker)) {
				return true;
			}
		}
		return false;
	}

}
