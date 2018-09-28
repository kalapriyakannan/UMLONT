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

import com.ibm.ccl.soa.deploy.core.extension.ExtensionsCore;
import com.ibm.ccl.soa.deploy.core.extension.IResourceTypeService;
import com.ibm.ccl.soa.deploy.core.ui.Messages;
import com.ibm.ccl.soa.deploy.internal.core.extension.ResourceTypeService;

/**
 * Context action: Remove Palette Entry, on Palette context menu
 * 
 * @author snible@us.ibm.com
 */
public class RemoveDynamicPaletteEntryAction extends Action {
	private final String resourceId;

	/**
	 * @param resId
	 * 
	 * @see ResourceTypeService#removeDynamicResourceType(String)
	 */
	public RemoveDynamicPaletteEntryAction(String resId) {
		resourceId = resId;

		setText(Messages.RemoveDynamicPaletteEntryAction_Remove_Palette_Entr_);
	}

	public void run() {
		IResourceTypeService rts = ExtensionsCore.createResourceTypeService();
		rts.removeDynamicResourceType(resourceId);
	}

} // end class RemoveDynamicPaletteEntryAction
