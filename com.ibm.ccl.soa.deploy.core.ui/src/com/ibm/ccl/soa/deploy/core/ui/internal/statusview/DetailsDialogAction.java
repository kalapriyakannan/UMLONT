/*******************************************************************************
 * Copyright (c) 2003, 2007 IBM Corporation Licensed Material - Property of IBM. All rights reserved.
 *  
 * US Government Users Restricted Rights - Use, duplication or disclosure v1.0 restricted by GSA ADP
 * Schedule Contract with IBM Corp.
 * 
 * Contributors: IBM Corporation - initial API and implementation
 *******************************************************************************/

package com.ibm.ccl.soa.deploy.core.ui.internal.statusview;

import org.eclipse.jface.viewers.ISelectionProvider;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.ui.actions.SelectionProviderAction;

import com.ibm.ccl.soa.deploy.core.ui.util.DeployCoreImages;

/**
 * 
 * @author Feng Lin
 * 
 */

public class DetailsDialogAction extends SelectionProviderAction {
	private Shell shell;
	private IStatusField[] extendFields;

	protected DetailsDialogAction(Shell shell, ISelectionProvider provider,
			IStatusField[] extendField) {
		super(provider, Messages.Views_Action_StatusDetails_Text);
		this.shell = shell;
		this.extendFields = extendField;
		this.setImageDescriptor(DeployCoreImages.IMAGE_SHOW_DETAILS);
		this.setDisabledImageDescriptor(DeployCoreImages.IMAGE_SHOW_DETAILS_D);

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.jface.action.Action#run()
	 */
	public void run() {
		Object element = getStructuredSelection().getFirstElement();
		if (element instanceof StatusNode) {
			StatusNode node = (StatusNode) element;
			DetailsDialog dialog = new DetailsDialog(shell, node, extendFields);
			dialog.open();
		}

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.ui.actions.SelectionProviderAction#selectionChanged(org.eclipse.jface.viewers.IStructuredSelection)
	 */
	public void selectionChanged(IStructuredSelection selection) {
		setEnabled(selection.getFirstElement() instanceof StatusNode);
	}

}
