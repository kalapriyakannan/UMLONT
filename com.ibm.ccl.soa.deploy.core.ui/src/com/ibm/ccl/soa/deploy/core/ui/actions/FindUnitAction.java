/*******************************************************************************
 * Copyright (c) 2003, 2007 IBM Corporation Licensed Material - Property of IBM. All rights reserved.
 *  
 * US Government Users Restricted Rights - Use, duplication or disclosure v1.0 restricted by GSA ADP
 * Schedule Contract with IBM Corp.
 * 
 * Contributors: IBM Corporation - initial API and implementation
 *******************************************************************************/
package com.ibm.ccl.soa.deploy.core.ui.actions;

import org.eclipse.jface.action.Action;
import org.eclipse.jface.window.Window;
import org.eclipse.ui.IWorkbenchPage;

import com.ibm.ccl.soa.deploy.core.Topology;
import com.ibm.ccl.soa.deploy.core.Unit;
import com.ibm.ccl.soa.deploy.core.ui.Messages;
import com.ibm.ccl.soa.deploy.core.ui.dialogs.FindUnitDialog;
import com.ibm.ccl.soa.deploy.core.ui.editor.DeployCoreEditor;
import com.ibm.ccl.soa.deploy.core.ui.properties.PropertyUtils;
import com.ibm.ccl.soa.deploy.core.ui.util.ResourceUtils;

/**
 * Implements a 'find' dialog for topologies.
 * 
 * @author Ed Snible
 * @see FindUnitDialog
 * @see com.ibm.ccl.soa.deploy.core.ui.providers.DiagramActionBarContributor
 * @see QuickOutlineDialogHandler
 */
public class FindUnitAction extends Action {

	private final IWorkbenchPage wbPage;

	/**
	 * @param page
	 */
	public FindUnitAction(IWorkbenchPage page) {
		wbPage = page;
	}

	public void run() {
		Topology top = null;

		Object part = ResourceUtils.getActiveEditorPart();
		if (part instanceof DeployCoreEditor) {
			DeployCoreEditor dce = (DeployCoreEditor) part;
			if (dce.getDiagram().getElement() instanceof Topology) {
				top = (Topology) dce.getDiagram().getElement();
			}
		}

		if (top != null) {
			FindUnitDialog fud = new FindUnitDialog(
					wbPage.getWorkbenchWindow().getShell() /* , new FindUnitRenderer() */,
					Messages.FIND_UNIT);
			fud.setElements(PropertyUtils.getUnitsInTopologyForSemantic(top).toArray());
			if (fud.open() == Window.OK) {
				Object unit = fud.getFirstResult();
				if (unit instanceof Unit) {
					reveal((Unit) unit);
				}
			}
		}
	}

	/** Reveal and select the unit */
	private void reveal(Unit unit) {
		PropertyUtils.revealNext(unit, wbPage.getActivePart());
	}

} // end class FindUnitAction
