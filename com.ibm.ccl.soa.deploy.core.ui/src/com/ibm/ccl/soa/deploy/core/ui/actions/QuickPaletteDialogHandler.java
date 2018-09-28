/*******************************************************************************
 * Copyright (c) 2003, 2007 IBM Corporation Licensed Material - Property of IBM. All rights reserved.
 *  
 * US Government Users Restricted Rights - Use, duplication or disclosure v1.0 restricted by GSA ADP
 * Schedule Contract with IBM Corp.
 * 
 * Contributors: IBM Corporation - initial API and implementation
 *******************************************************************************/
package com.ibm.ccl.soa.deploy.core.ui.actions;

import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.gmf.runtime.diagram.ui.parts.DiagramEditor;
import org.eclipse.ui.IEditorPart;
import org.eclipse.ui.IWorkbenchPage;
import org.eclipse.ui.IWorkbenchWindow;
import org.eclipse.ui.PlatformUI;

import com.ibm.ccl.soa.deploy.core.Topology;
import com.ibm.ccl.soa.deploy.core.Unit;
import com.ibm.ccl.soa.deploy.core.ui.dialogs.QuickPalettePopup;

/**
 * Handler that displays a popup listing {@link Unit}s on the current {@link Topology}.
 * 
 * &lt;command&gt; on the <code>org.eclipse.ui.commands</code> extension point.
 * 
 * @author Ed Snible
 * @see QuickPalettePopup
 */
public class QuickPaletteDialogHandler extends AbstractHandler {

	public Object execute(ExecutionEvent arg0) /* throws ExecutionException */{

		//		Topology top = getActiveTopology();
		IEditorPart iep = getActiveEditor();
		if (iep instanceof DiagramEditor) {
			DiagramEditor de = (DiagramEditor) iep;
			IWorkbenchWindow window = PlatformUI.getWorkbench().getActiveWorkbenchWindow();
			QuickPalettePopup outline = new QuickPalettePopup(window.getShell(), de
					.getDiagramEditPart(), de);
			outline.open();
		}

		return null;
	}

	//	private Topology getActiveTopology() {
	//		IEditorPart iep = getActiveEditor();
	//		if (iep instanceof DeployCoreEditor) {
	//			DeployCoreEditor dce = (DeployCoreEditor) iep;
	//			if (dce.getDiagram().getElement() instanceof Topology) {
	//				return (Topology) dce.getDiagram().getElement();
	//			}
	//		}
	//
	//		return null;
	//	}

	private IEditorPart getActiveEditor() {
		IWorkbenchWindow window = PlatformUI.getWorkbench().getActiveWorkbenchWindow();
		if (window != null) {
			IWorkbenchPage page = window.getActivePage();
			if (page != null) {
				IEditorPart editor = page.getActiveEditor();
				return editor;
			}
		}

		return null;
	}

} // end class QuickOutlineDialogHandler
