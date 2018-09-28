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
import com.ibm.ccl.soa.deploy.core.ui.internal.commands.AddToGroupCommand;

/**
 * @author <a href="mailto:sunyingl@cn.ibm.com">Neo Sun</a>
 * 
 * @see AddToGroupMenuManager
 * @see AddToGroupCommand
 */
public class AddUnitToExistingGroupAction extends DiagramAction {
	//	private UnitGroupEditPart targetGroupEP; 
	private final Unit target;

	/**
	 * @param workbenchPage
	 * @param target
	 */
	public AddUnitToExistingGroupAction(IWorkbenchPage workbenchPage, Unit target) {
		super(workbenchPage);

		//		this.targetGroupEP = targetGroupEP;
		this.target = target;

		init();

		// Set the action label
		//		String name = ((Unit)targetGroupEP.getNotationView().getElement()).titleWithContext();
		String name = target.getCaptionProvider().titleWithContext(target);
		setText(name);

		// Set the action icon
		Image image = IconService.getInstance().getIcon(
		//				new EObjectAdapter(targetGroupEP.getNotationView().getElement()),
				new EObjectAdapter(target), IconOptions.GET_STEREOTYPE_IMAGE_FOR_ELEMENT.intValue());
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
		return true;
	}

	protected void doRun(IProgressMonitor progressMonitor) {
		//		AddToGroupCommand addToGroupCmd = new AddToGroupCommand(targetGroupEP, getSelectedObjects(), getDiagramEditPart());
		AddToGroupCommand addToGroupCmd = new AddToGroupCommand(target, getSelectedObjects(),
				getDiagramEditPart());
		DiagramCommandStack cmdStack = getDiagramEditPart().getDiagramEditDomain()
				.getDiagramCommandStack();
		cmdStack.execute(new ICommandProxy(addToGroupCmd));
	}
}
