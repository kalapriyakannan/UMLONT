/*******************************************************************************
 * Copyright (c) 2003, 2007 IBM Corporation Licensed Material - Property of IBM. All rights reserved.
 *  
 * US Government Users Restricted Rights - Use, duplication or disclosure v1.0 restricted by GSA ADP
 * Schedule Contract with IBM Corp.
 * 
 * Contributors: IBM Corporation - initial API and implementation
 *******************************************************************************/
package com.ibm.ccl.soa.deploy.core.ui.navigator.deploy;

import org.eclipse.gef.GraphicalViewer;
import org.eclipse.gmf.runtime.diagram.ui.dnd.parts.DiagramViewerDropAdapter;
import org.eclipse.gmf.runtime.diagram.ui.parts.IDiagramWorkbenchPart;
import org.eclipse.jface.util.LocalSelectionTransfer;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.StructuredSelection;
import org.eclipse.swt.dnd.DropTargetEvent;
import org.eclipse.swt.dnd.Transfer;

public class DeployViewerDropAdapter extends DiagramViewerDropAdapter {

	private IDiagramWorkbenchPart part = null;
	private GraphicalViewer viewer = null;

	public DeployViewerDropAdapter(IDiagramWorkbenchPart workbenchPart) {
		super(workbenchPart);
		this.part = workbenchPart;
	}

	public GraphicalViewer getViewer() {
		return viewer;
	}

	public void setViewer(GraphicalViewer viewer) {
		this.viewer = viewer;
	}

	public void dragLeave(DropTargetEvent arg0) {
		FeedbackFigure.erase(part.getDiagramEditPart());
		super.dragLeave(arg0);
	}

	/*
	 * ========================================================================================
	 * DETERMINE FEEDBACK FIGURE
	 * =======================================================================================
	 */
	public void dragOver(DropTargetEvent event) {
		Transfer[] transfers = getTransfers();
		for (int i = 0; i < transfers.length; i++) {
			if (transfers[i] instanceof LocalSelectionTransfer) {
				LocalSelectionTransfer selectionTransfer = (LocalSelectionTransfer) transfers[i];
				ISelection s = selectionTransfer.getSelection();
				if (s instanceof StructuredSelection) {
					break;
				}
			}
		}
		super.dragOver(event);
	}

	/*
	 * ========================================================================================
	 * CREATE SHAPES
	 * =======================================================================================
	 */

	public void drop(DropTargetEvent event) {
		FeedbackFigure.erase(part.getDiagramEditPart());
		if (event.data instanceof StructuredSelection) {
			StructuredSelection selection = (StructuredSelection) event.data;
			if (selection.size() > 0) {
			}
		}

		super.drop(event);
	}
}
