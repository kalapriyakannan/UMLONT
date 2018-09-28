/*******************************************************************************
 * Copyright (c) 2003, 2007 IBM Corporation Licensed Material - Property of IBM. All rights reserved.
 *  
 * US Government Users Restricted Rights - Use, duplication or disclosure v1.0 restricted by GSA ADP
 * Schedule Contract with IBM Corp.
 * 
 * Contributors: IBM Corporation - initial API and implementation
 *******************************************************************************/

package com.ibm.ccl.soa.deploy.core.ui.actions;

import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.gef.Request;
import org.eclipse.gmf.runtime.diagram.ui.actions.DiagramAction;
import org.eclipse.gmf.runtime.diagram.ui.commands.ICommandProxy;
import org.eclipse.ui.IWorkbenchPage;

import com.ibm.ccl.soa.deploy.core.ui.Messages;
import com.ibm.ccl.soa.deploy.core.ui.internal.commands.AddToNewGroupCommand;
import com.ibm.ccl.soa.deploy.core.ui.util.DeployCoreImages;

/**
 * This Action is for the menu "Add to Group -> New Group".
 * 
 * @author <a href="mailto:sunyingl@cn.ibm.com">Neo Sun</a>
 * 
 * @see AddToGroupMenuManager
 */
public class AddToNewGroupAction extends DiagramAction {
	/**
	 * @param workbenchPage
	 */
	public AddToNewGroupAction(IWorkbenchPage workbenchPage) {
		super(workbenchPage);
		init();
		setText(Messages.GROUP_MENU_ADD_TO_NEW_GROUP);
		setImageDescriptor(DeployCoreImages.IMAGEDSC_ADD_TO_NEW_GRP);
	}

	protected void doRun(IProgressMonitor progressMonitor) {
		AddToNewGroupCommand add2NewGrpCmd = new AddToNewGroupCommand(getSelectedObjects(),
				getDiagramEditPart());
		getDiagramCommandStack().execute(new ICommandProxy(add2NewGrpCmd), progressMonitor);
	}

	protected Request createTargetRequest() {
		return null;
	}

	protected boolean isSelectionListener() {
		return true;
	}

	protected boolean calculateEnabled() {
		return true;
	}
}
