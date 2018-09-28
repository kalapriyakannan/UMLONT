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
import org.eclipse.gef.Request;
import org.eclipse.gmf.runtime.diagram.ui.actions.DiagramAction;
import org.eclipse.gmf.runtime.diagram.ui.commands.ICommandProxy;
import org.eclipse.gmf.runtime.diagram.ui.editparts.GraphicalEditPart;
import org.eclipse.gmf.runtime.diagram.ui.parts.DiagramCommandStack;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.ui.IWorkbenchPage;

import com.ibm.ccl.soa.deploy.core.ui.Messages;
import com.ibm.ccl.soa.deploy.core.ui.editparts.DeployShapeNodeEditPart;
import com.ibm.ccl.soa.deploy.core.ui.internal.commands.SnapStyleCommand;
import com.ibm.ccl.soa.deploy.core.ui.notation.DeployNotationPackage;
import com.ibm.ccl.soa.deploy.core.ui.notation.DeployStyle;
import com.ibm.ccl.soa.deploy.core.ui.util.DeployCoreConstants;

public class SnapStyleAction extends DiagramAction {

	private final List<GraphicalEditPart> _selectedList = new ArrayList<GraphicalEditPart>();
	private int _snapStyle = 0;
	private String _text = ""; //$NON-NLS-1$

	/**
	 * @param workbenchPage
	 */
	public SnapStyleAction(IWorkbenchPage workbenchPage) {
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
		// return true if at least one selected view has a snap parent, 
		// and if all snap parents of selected views have the same snap style

		int currentSnapStyle = Integer.MAX_VALUE;
		List<?> selectedObjs = getSelectedObjects();

		// Only DeployShapeNodeEditParts are selected with the same parent container
		_text = Messages.SnapStyleAction_0;
		setText(_text);
		_snapStyle = DeployCoreConstants.SNAP_CENTERED;
		_selectedList.clear();

		for (Iterator<?> it = selectedObjs.iterator(); it.hasNext();) {
			Object selectedObj = it.next();

			if (!(selectedObj instanceof DeployShapeNodeEditPart)) {
				return false;
			}

			DeployShapeNodeEditPart ep = (DeployShapeNodeEditPart) selectedObj;
			_selectedList.add(ep);
			View view = ep.getNotationView();
			DeployStyle style = (DeployStyle) view.getStyle(DeployNotationPackage.eINSTANCE
					.getDeployStyle());
			if (style != null && style.getSnapParent() != null
					&& style.getSnapParent().eContainer() != null) {
				View snapGroupView = (View) style.getSnapParent().eContainer();
				DeployStyle groupStyle = (DeployStyle) snapGroupView
						.getStyle(DeployNotationPackage.eINSTANCE.getDeployStyle());
				if (currentSnapStyle == Integer.MAX_VALUE) {
					currentSnapStyle = groupStyle.getSnapStyle();
				} else {
					if (groupStyle.getSnapStyle() != currentSnapStyle) {
						return false;
					}
				}
			}

		}

		if (currentSnapStyle == Integer.MAX_VALUE) {
			return false;
		}

		// if current snap style is centered, set the snap style to rectangular
		if (currentSnapStyle == DeployCoreConstants.SNAP_CENTERED) {
			_snapStyle = DeployCoreConstants.SNAP_RECTANGULAR;
			_text = Messages.SnapStyleAction_1;
		}

		setText(_text);

		return true;
	}

	protected void doRun(IProgressMonitor progressMonitor) {
		SnapStyleCommand snapCmd = new SnapStyleCommand(_selectedList, _snapStyle, _text);
		DiagramCommandStack cmdStack = getDiagramEditPart().getDiagramEditDomain()
				.getDiagramCommandStack();
		cmdStack.execute(new ICommandProxy(snapCmd));
	}
}
