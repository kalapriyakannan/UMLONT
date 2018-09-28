/***************************************************************************************************
 * Copyright (c) 2003, 2007 IBM Corporation Licensed Material - Property of IBM. All rights
 * reserved.
 * 
 * US Government Users Restricted Rights - Use, duplication or disclosure v1.0 restricted by GSA ADP
 * Schedule Contract with IBM Corp.
 * 
 * Contributors: IBM Corporation - initial API and implementation
 **************************************************************************************************/
package com.ibm.ccl.soa.deploy.core.ui.editor;

import org.eclipse.draw2d.ToolTipHelper;
import org.eclipse.gef.EditDomain;
import org.eclipse.gef.EditPart;
import org.eclipse.gef.EditPartViewer;
import org.eclipse.gef.ui.parts.DomainEventDispatcher;
import org.eclipse.swt.events.MouseEvent;

import com.ibm.ccl.soa.deploy.core.ui.editparts.DeployDiagramEditPart;

/**
 * @author jswanke
 * 
 */
public class DeployDomainEventDispatcher extends DomainEventDispatcher {

	DeployToolTipHelper toolTipHelper = null;
	DeployDiagramEditPart _ddep = null;

	/**
	 * @param d
	 * @param v
	 */
	public DeployDomainEventDispatcher(EditDomain d, EditPartViewer v) {
		super(d, v);
	}

	protected ToolTipHelper getToolTipHelper() {
		if (toolTipHelper == null) {
			toolTipHelper = new DeployToolTipHelper(control);
		}
		return toolTipHelper;
	}

	@Override
	public void dispatchMousePressed(MouseEvent me) {
		if (getViewer() instanceof DeployGraphicalViewer) {
			DeployGraphicalViewer viewer = (DeployGraphicalViewer) getViewer();
			if (me.button == 1) {
				viewer.leftMousePressed();
			}
			EditPart ep = viewer.getContents();
			if (ep instanceof DeployDiagramEditPart) {
				((DeployDiagramEditPart) ep).setIsMousePressed(true);
			}
		}
		super.dispatchMousePressed(me);
	}

	@Override
	public void dispatchMouseReleased(MouseEvent me) {
		if (getViewer() instanceof DeployGraphicalViewer) {
			DeployGraphicalViewer viewer = (DeployGraphicalViewer) getViewer();
			viewer.leftMouseMouseReleased();
			EditPart ep = viewer.getContents();
			if (ep instanceof DeployDiagramEditPart) {
				((DeployDiagramEditPart) ep).setIsMousePressed(false);
			}
		}
		super.dispatchMouseReleased(me);
	}

}
