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
import org.eclipse.jface.dialogs.InputDialog;
import org.eclipse.jface.window.Window;
import org.eclipse.swt.widgets.Shell;

import com.ibm.ccl.soa.deploy.core.extension.ExtensionsCore;
import com.ibm.ccl.soa.deploy.core.extension.IResourceTypeService;
import com.ibm.ccl.soa.deploy.core.ui.Messages;
import com.ibm.ccl.soa.deploy.internal.core.extension.ResourceTypeService;

/**
 * Context action: Remove Palette Entry, on Palette context menu
 * 
 * @author snible@us.ibm.com
 */
public class RenameDynamicPaletteEntryAction extends Action {
	private final String resourceId;
	private final String oldName;

	/**
	 * @param resId
	 * @param oldLabel
	 * 
	 * @see ResourceTypeService#renameResourceType(String, String)
	 */
	public RenameDynamicPaletteEntryAction(String resId, String oldLabel) {
		resourceId = resId;
		oldName = oldLabel;

		setText(Messages.RenameDynamicPaletteEntryAction_Rename_);
	}

	public void run() {
//		StackHelper stackHelper = new StackHelper();
		InputDialog id = new InputDialog(new Shell(),
				"Rename Palette Entry", "New Name:", oldName, null); //$NON-NLS-1$ //$NON-NLS-2$
		if (id.open() == Window.OK) {
			IResourceTypeService rts = ExtensionsCore.createResourceTypeService();
			rts.renameResourceType(resourceId, id.getValue());
		}
	}

} // end class RenameDynamicPaletteEntryAction
