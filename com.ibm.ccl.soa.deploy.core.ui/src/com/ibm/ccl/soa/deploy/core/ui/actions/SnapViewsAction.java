/***************************************************************************************************
 * Copyright (c) 2003, 2008 IBM Corporation Licensed Material - Property of IBM. All rights
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
import org.eclipse.gef.EditPart;
import org.eclipse.gef.Request;
import org.eclipse.gmf.runtime.diagram.ui.actions.DiagramAction;
import org.eclipse.gmf.runtime.diagram.ui.commands.ICommandProxy;
import org.eclipse.gmf.runtime.diagram.ui.editparts.GraphicalEditPart;
import org.eclipse.gmf.runtime.diagram.ui.parts.DiagramCommandStack;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.ui.IWorkbenchPage;

import com.ibm.ccl.soa.deploy.core.ui.Messages;
import com.ibm.ccl.soa.deploy.core.ui.editparts.DeployShapeNodeEditPart;
import com.ibm.ccl.soa.deploy.core.ui.internal.commands.SnapViewsCommand;
import com.ibm.ccl.soa.deploy.core.ui.notation.DeployNotationPackage;
import com.ibm.ccl.soa.deploy.core.ui.notation.DeployStyle;

/**
 * 
 * @author jswanke
 */
public class SnapViewsAction extends DiagramAction {

	private final List<GraphicalEditPart> _selectedList = new ArrayList<GraphicalEditPart>();
	private GraphicalEditPart _snapParent = null;
	private boolean _isUnsnap = false;

	/**
	 * @param workbenchPage
	 */
	public SnapViewsAction(IWorkbenchPage workbenchPage) {
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
		// must be at least two
		List<?> selectedObjs = getSelectedObjects();

		// Only DeployShapeNodeEditParts are selected with the same parent container
		_isUnsnap = false;
		setText(Messages.SnapViewsAction_0);
		_snapParent = null;
		_selectedList.clear();
		boolean isAllViewsSnapped = true;
		for (Iterator<?> it = selectedObjs.iterator(); it.hasNext();) {
			Object selectedObj = it.next();
			if (!(selectedObj instanceof DeployShapeNodeEditPart)) {
				return false;
			}

			DeployShapeNodeEditPart ep = (DeployShapeNodeEditPart) selectedObj;
			_selectedList.add(ep);
			EditPart thisParent = ep.getParent();
			if (_snapParent != null && !thisParent.equals(_snapParent)) {
				return false;
			}
			_snapParent = (GraphicalEditPart) thisParent;

			// if this an unsnap action?
			View view = ep.getNotationView();
			DeployStyle style = (DeployStyle) view.getStyle(DeployNotationPackage.eINSTANCE
					.getDeployStyle());
			isAllViewsSnapped = isAllViewsSnapped && style != null && style.getSnapParent() != null;
		}

		// if all views are snapped, this is a detach command
		if (isAllViewsSnapped) {
			_isUnsnap = true;
			setText(Messages.SnapViewsAction_1);
		}

		// multi required for snap, but only one required for unsnap
		if (!_isUnsnap && selectedObjs.size() < 2) {
			return false;
		}

		return true;
	}

	protected void doRun(IProgressMonitor progressMonitor) {
		SnapViewsCommand snapCmd = new SnapViewsCommand(_selectedList, _snapParent, _isUnsnap);
		DiagramCommandStack cmdStack = getDiagramEditPart().getDiagramEditDomain()
				.getDiagramCommandStack();
		cmdStack.execute(new ICommandProxy(snapCmd));
	}
}
