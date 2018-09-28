/***************************************************************************************************
 * Copyright (c) 2003, 2007 IBM Corporation Licensed Material - Property of IBM. All rights
 * reserved.
 * 
 * US Government Users Restricted Rights - Use, duplication or disclosure v1.0 restricted by GSA ADP
 * Schedule Contract with IBM Corp.
 * 
 * Contributors: IBM Corporation - initial API and implementation
 **************************************************************************************************/

package com.ibm.ccl.soa.deploy.core.ui.dialogs;

import org.eclipse.jface.viewers.ILabelProvider;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.dialogs.ElementListSelectionDialog;

import com.ibm.ccl.soa.deploy.core.ui.composites.IDeployHelpContextIds;

/**
 * Creation of Capability
 * 
 * @since 7.0
 * 
 */
public class NewCapabilityCreationDialog extends ElementListSelectionDialog {
	/**
	 * 
	 * @param parent
	 * @param renderer
	 */
	public NewCapabilityCreationDialog(Shell parent, ILabelProvider renderer) {
		super(parent, renderer);
	}

	protected Control createDialogArea(Composite parent) {
		PlatformUI.getWorkbench().getHelpSystem().setHelp(parent,
				IDeployHelpContextIds.TOPOLOGY_CAPABILITIES_FLYOUT_ADD_CAPABILITY);
		return super.createDialogArea(parent);
	}

}
