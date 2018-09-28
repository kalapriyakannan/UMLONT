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
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.wizard.WizardDialog;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.ui.IWorkbenchPage;
import org.eclipse.ui.PlatformUI;

import com.ibm.ccl.soa.deploy.core.ui.Messages;
import com.ibm.ccl.soa.deploy.core.ui.wizards.DeployTopologyExportWizard;

/**
 */
public class TopologyExportAction extends Action {
	private final IWorkbenchPage page;

	/**
	 * Constructor
	 */
	public TopologyExportAction(IWorkbenchPage wbPage) {
		super(Messages.TOPOLOGY_EXPORT_ACTION_LABEL);
		page = wbPage;
	}

	public void run() {
		Shell parentShell = PlatformUI.getWorkbench().getActiveWorkbenchWindow().getShell();
		DeployTopologyExportWizard wizard = new DeployTopologyExportWizard();
		wizard.init(PlatformUI.getWorkbench(), (IStructuredSelection) page.getSelection());
		WizardDialog dialog = new WizardDialog(parentShell, wizard);
		dialog.create();
		dialog.open();
	}
}
