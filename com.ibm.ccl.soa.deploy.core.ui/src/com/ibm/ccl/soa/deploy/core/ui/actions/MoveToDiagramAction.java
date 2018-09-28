/*******************************************************************************
 * Copyright (c) 2003, 2007 IBM Corporation Licensed Material - Property of IBM. All rights reserved.
 *  
 * US Government Users Restricted Rights - Use, duplication or disclosure v1.0 restricted by GSA ADP
 * Schedule Contract with IBM Corp.
 * 
 * Contributors: IBM Corporation - initial API and implementation
 *******************************************************************************/

package com.ibm.ccl.soa.deploy.core.ui.actions;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.gef.EditPart;
import org.eclipse.gef.Request;
import org.eclipse.gmf.runtime.diagram.ui.actions.DiagramAction;
import org.eclipse.gmf.runtime.diagram.ui.commands.ICommandProxy;
import org.eclipse.gmf.runtime.diagram.ui.editparts.DiagramEditPart;
import org.eclipse.gmf.runtime.diagram.ui.parts.DiagramCommandStack;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.ui.IWorkbenchPage;

import com.ibm.ccl.soa.deploy.core.ui.Messages;
import com.ibm.ccl.soa.deploy.core.ui.editparts.DeployListCompartmentEditPart;
import com.ibm.ccl.soa.deploy.core.ui.editparts.DeployShapeNodeEditPart;
import com.ibm.ccl.soa.deploy.core.ui.editparts.HybridShapesCompartmentEditPart;
import com.ibm.ccl.soa.deploy.core.ui.internal.commands.MoveToDiagramCommand;
import com.ibm.ccl.soa.deploy.core.ui.util.DeployCoreImages;
import com.ibm.ccl.soa.deploy.core.ui.util.GMFUtils;

/**
 * 
 * @author <a href="mailto:sunyingl@cn.ibm.com">Neo Sun</a>
 */
public class MoveToDiagramAction extends DiagramAction {

	/**
	 * @param workbenchPage
	 */
	public MoveToDiagramAction(IWorkbenchPage workbenchPage) {
		super(workbenchPage);

		init();

		setText(Messages.GROUP_MENU_MOVE_TO_CANVAS);
		setImageDescriptor(DeployCoreImages.IMAGEDSC_ADD_TO_NEW_GRP);
	}

	protected Request createTargetRequest() {
		return null;
	}

	protected boolean isSelectionListener() {
		return true;
	}

	protected boolean calculateEnabled() {
		/**
		 * Be enabled when all selected editparts are group members, and there are no views on the
		 * diagram yet.
		 */
		List unitsOnDiagram = getUnitsOnDiagram();
		for (Iterator i = getSelectedObjects().iterator(); i.hasNext();) {
			Object selected = i.next();

			if (!(selected instanceof DeployShapeNodeEditPart)) {
				return false;
			}

			EditPart ep = (EditPart) selected;

			// if a non configuratble unit in an imported topology, can't change
			if (GMFUtils.isNonMutableImport(ep)) {
				return false;
			}

			if (!(ep.getParent() instanceof HybridShapesCompartmentEditPart || ep.getParent() instanceof DeployListCompartmentEditPart)) {
				return false;
			}

			EObject unit = ((View) ep.getModel()).getElement();
			if (unitsOnDiagram.contains(unit)) {
				return false;
			}
		}

		return true;
	}

	protected void doRun(IProgressMonitor progressMonitor) {
		MoveToDiagramCommand addToGroupCmd = new MoveToDiagramCommand(getDiagramEditPart(),
				getSelectedObjects());
		DiagramCommandStack cmdStack = getDiagramEditPart().getDiagramEditDomain()
				.getDiagramCommandStack();
		cmdStack.execute(new ICommandProxy(addToGroupCmd));
	}

	/**
	 * @return the list of units which have views on the diagram
	 */
	private List getUnitsOnDiagram() {
		DiagramEditPart diagramEP = getDiagramEditPart();
		List unitsOnDiagram = new ArrayList();
		if (diagramEP == null) {
			return unitsOnDiagram;
		}

		for (Iterator i = diagramEP.getChildren().iterator(); i.hasNext();) {
			View view = (View) ((EditPart) i.next()).getModel();
			EObject element = view.getElement();
			if (element != null) {
				unitsOnDiagram.add(element);
			}
		}

		return unitsOnDiagram;
	}
}
