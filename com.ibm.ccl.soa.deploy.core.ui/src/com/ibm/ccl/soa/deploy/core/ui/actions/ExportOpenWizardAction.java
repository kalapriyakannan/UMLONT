/*******************************************************************************
 * Copyright (c) 2003, 2007 IBM Corporation Licensed Material - Property of IBM. All rights reserved.
 *  
 * US Government Users Restricted Rights - Use, duplication or disclosure v1.0 restricted by GSA ADP
 * Schedule Contract with IBM Corp.
 * 
 * Contributors: IBM Corporation - initial API and implementation
 *******************************************************************************/
package com.ibm.ccl.soa.deploy.core.ui.actions;

import org.eclipse.core.resources.IFile;
import org.eclipse.jface.action.Action;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.viewers.StructuredSelection;
import org.eclipse.jface.wizard.WizardDialog;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.ui.IWorkbench;
import org.eclipse.ui.PlatformUI;

import com.ibm.ccl.soa.deploy.core.ui.wizards.DeployTopologyExportWizard;

public class ExportOpenWizardAction extends Action {
	IFile topologyFile = null;

	public ExportOpenWizardAction(IFile topologyFile) {
		this.topologyFile = topologyFile;
	}

	@Override
	public void run() {
		IStructuredSelection selectionToPass = new StructuredSelection(topologyFile);
		DeployTopologyExportWizard wizard = new DeployTopologyExportWizard();
		IWorkbench workbench = PlatformUI.getWorkbench();
		wizard.init(workbench, selectionToPass);
		Shell parent = workbench.getActiveWorkbenchWindow().getShell();
		WizardDialog dialog = new WizardDialog(parent, wizard);
		dialog.create();
		dialog.open();
	}

	public IFile getTopologyFile() {
		return topologyFile;
	}

	public void setTopologyFile(IFile topologyFile) {
		this.topologyFile = topologyFile;
	}

}
