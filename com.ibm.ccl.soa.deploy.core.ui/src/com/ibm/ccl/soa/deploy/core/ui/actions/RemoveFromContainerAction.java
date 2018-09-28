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
import org.eclipse.gmf.runtime.common.ui.services.icon.IconOptions;
import org.eclipse.gmf.runtime.common.ui.services.icon.IconService;
import org.eclipse.gmf.runtime.diagram.ui.actions.DiagramAction;
import org.eclipse.gmf.runtime.diagram.ui.commands.ICommandProxy;
import org.eclipse.gmf.runtime.diagram.ui.parts.DiagramCommandStack;
import org.eclipse.gmf.runtime.emf.core.util.EObjectAdapter;
import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.swt.graphics.Image;
import org.eclipse.ui.IWorkbenchPage;

import com.ibm.ccl.soa.deploy.core.Unit;
import com.ibm.ccl.soa.deploy.core.ui.internal.commands.RemoveFromContainerCommand;
import com.ibm.ccl.soa.deploy.core.ui.internal.commands.RemoveFromGroupCommand;
import com.ibm.ccl.soa.deploy.core.util.DeployModelObjectUtil;

/**
 * @author Ed Snible
 * @see RemoveFromGroupCommand
 * @see RemoveFromGroupMenuManager
 */
public class RemoveFromContainerAction extends DiagramAction {

	private final Unit member;
	private final Unit container;

	/**
	 * @param workbenchPage
	 * @param member
	 * @param container
	 */
	public RemoveFromContainerAction(IWorkbenchPage workbenchPage, Unit member, Unit container) {
		super(workbenchPage);

		this.member = member;
		this.container = container;
		init();

		String name = container.getCaptionProvider().titleWithContext(container);
		setText(name);

		// Set the action icon
		Image image = IconService.getInstance().getIcon(new EObjectAdapter(container),
				IconOptions.GET_STEREOTYPE_IMAGE_FOR_ELEMENT.intValue());
		if (image != null) {
			setImageDescriptor(ImageDescriptor.createFromImage(image));
		}
	}

	protected Request createTargetRequest() {
		return null;
	}

	protected boolean isSelectionListener() {
		return true;
	}

	protected boolean calculateEnabled() {
		return DeployModelObjectUtil.isMutable(container);
	}

	protected void doRun(IProgressMonitor progressMonitor) {
		RemoveFromContainerCommand cmd = new RemoveFromContainerCommand(getDiagramEditPart()
				.getEditingDomain(), member, container);
		DiagramCommandStack cmdStack = getDiagramEditPart().getDiagramEditDomain()
				.getDiagramCommandStack();
		cmdStack.execute(new ICommandProxy(cmd));
	}
}
