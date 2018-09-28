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

import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.gef.Request;
import org.eclipse.gmf.runtime.common.ui.services.icon.IconOptions;
import org.eclipse.gmf.runtime.common.ui.services.icon.IconService;
import org.eclipse.gmf.runtime.diagram.ui.actions.DiagramAction;
import org.eclipse.gmf.runtime.diagram.ui.commands.ICommandProxy;
import org.eclipse.gmf.runtime.diagram.ui.editparts.IGraphicalEditPart;
import org.eclipse.gmf.runtime.diagram.ui.parts.DiagramCommandStack;
import org.eclipse.gmf.runtime.emf.core.util.EObjectAdapter;
import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.swt.graphics.Image;
import org.eclipse.ui.IWorkbenchPage;

import com.ibm.ccl.soa.deploy.core.Unit;
import com.ibm.ccl.soa.deploy.core.ui.editparts.DeployDiagramEditPart;
import com.ibm.ccl.soa.deploy.core.ui.editparts.DeployShapeNodeEditPart;
import com.ibm.ccl.soa.deploy.core.ui.editparts.HybridShapesCompartmentEditPart;
import com.ibm.ccl.soa.deploy.core.ui.internal.commands.MoveToGroupCommand;
import com.ibm.ccl.soa.deploy.core.ui.util.GMFUtils;

/**
 * Move units to existing group context action
 * 
 * @author <a href="mailto:sunyingl@cn.ibm.com">Neo Sun</a>
 */
public class MoveToExistingGroupAction extends DiagramAction {
	private final DeployShapeNodeEditPart _targetEP;

	/**
	 * @param workbenchPage
	 * @param targetEP
	 */
	public MoveToExistingGroupAction(IWorkbenchPage workbenchPage, DeployShapeNodeEditPart targetEP) {
		super(workbenchPage);

		_targetEP = targetEP;

		init();

		// Set the action label
		Unit u = (Unit) _targetEP.getNotationView().getElement();
		String name = u.getCaptionProvider().titleWithContext(u);
		setText(name);

		// Set the action icon
		Image image = IconService.getInstance().getIcon(
				new EObjectAdapter(_targetEP.getNotationView().getElement()),
				IconOptions.GET_STEREOTYPE_IMAGE_FOR_ELEMENT.intValue());
		if (image != null) {
			setImageDescriptor(ImageDescriptor.createFromImage(image));
		}
	}

	protected boolean calculateEnabled() {
		/**
		 * To be enabled when all selected editparts are group members, or on the diagram.
		 */
		for (Iterator i = getSelectedObjects().iterator(); i.hasNext();) {
			Object selected = i.next();
			if (!(selected instanceof DeployShapeNodeEditPart)) {
				return false;
			}

			IGraphicalEditPart ep = (IGraphicalEditPart) selected;

			// if a non configuratble unit in an imported topology, can't change
			if (GMFUtils.isNonMutableImport(ep)) {
				return false;
			}

			IGraphicalEditPart parentEP = (IGraphicalEditPart) ep.getParent();
			if (!(parentEP instanceof HybridShapesCompartmentEditPart)
					&& !(parentEP instanceof DeployDiagramEditPart)) {
				return false;
			}
		}

		return true;
	}

	protected void doRun(IProgressMonitor progressMonitor) {
		MoveToGroupCommand moveToGroupCmd = new MoveToGroupCommand(_targetEP, getSelectedObjects());
		DiagramCommandStack cmdStack = getDiagramEditPart().getDiagramEditDomain()
				.getDiagramCommandStack();
		cmdStack.execute(new ICommandProxy(moveToGroupCmd));
	}

	protected Request createTargetRequest() {
		return null;
	}

	protected boolean isSelectionListener() {
		return true;
	}
}
