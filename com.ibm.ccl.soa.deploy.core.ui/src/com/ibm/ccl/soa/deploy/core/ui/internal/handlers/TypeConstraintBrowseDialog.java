/*******************************************************************************
 * Copyright (c) 2008 IBM Corporation.
 * All rights reserved. 
 *
 * Contributors:
 *     IBM Corporation - initial API and implementation
 ******************************************************************************/

package com.ibm.ccl.soa.deploy.core.ui.internal.handlers;

import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.ui.PlatformUI;

import com.ibm.ccl.soa.deploy.core.ui.composites.IDeployHelpContextIds;
import com.ibm.ccl.soa.deploy.core.ui.internal.properties.DmoTypeSelectionDialog;

class TypeConstraintBrowseDialog extends DmoTypeSelectionDialog {

	public TypeConstraintBrowseDialog(Shell parent, String aTitle, boolean showCapabilities,
			boolean showUnits) {
		super(parent, aTitle, showCapabilities, showUnits);
	}

	protected Control createDialogArea(Composite parent) {
		PlatformUI.getWorkbench().getHelpSystem().setHelp(parent,
				IDeployHelpContextIds.TOPOLOGY_TYPE_CONSTRAINT_BROWSE);
		return super.createDialogArea(parent);
	}

}
