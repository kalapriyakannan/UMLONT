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

import org.eclipse.jface.action.Action;
import org.eclipse.ui.IWorkbenchPage;

import com.ibm.ccl.soa.deploy.core.IConstants;
import com.ibm.ccl.soa.deploy.core.ui.dialogs.QuickPalettePopup;
import com.ibm.ccl.soa.deploy.core.ui.editor.DeployCoreEditor;
import com.ibm.ccl.soa.deploy.core.ui.DeployCoreUIPlugin;
import com.ibm.ccl.soa.deploy.core.ui.Messages;

/**
 * Context action: Quick Palette
 * 
 * @author snible@us.ibm.com
 */
public class QuickPaletteAction extends Action {
	private final IWorkbenchPage page;

	/**
	 * @param wbPage
	 */
	public QuickPaletteAction(IWorkbenchPage wbPage) {
		page = wbPage;
		setText(Messages.QuickPaletteAction_Quick_Palette_Control_);
		setId(DeployActionIds.QUICK_PALETTE);
		setActionDefinitionId(DeployCoreUIPlugin.PLUGIN_ID + IConstants.DOT_SEPARATOR
				+ DeployActionIds.QUICK_PALETTE);
	}

	public void run() {
		if (page.getActiveEditor() instanceof DeployCoreEditor) {
			DeployCoreEditor dce = (DeployCoreEditor) page.getActiveEditor();
			QuickPalettePopup outline = new QuickPalettePopup(page.getActivePart().getSite()
					.getShell(), dce.getDiagramEditPart(), page.getActivePart());
			outline.open();
		}

	}

} // end class QuickPaletteAction
