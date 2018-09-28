/***************************************************************************************************
 * Copyright (c) 2003, 2007 IBM Corporation Licensed Material - Property of IBM. All rights
 * reserved.
 * 
 * US Government Users Restricted Rights - Use, duplication or disclosure v1.0 restricted by GSA ADP
 * Schedule Contract with IBM Corp.
 * 
 * Contributors: IBM Corporation - initial API and implementation
 **************************************************************************************************/
package com.ibm.ccl.soa.deploy.core.ui.editpolicies;

import java.util.Iterator;

import org.eclipse.gef.EditPolicy;
import org.eclipse.gef.commands.Command;
import org.eclipse.gef.requests.ChangeBoundsRequest;
import org.eclipse.gmf.runtime.common.core.command.UnexecutableCommand;
import org.eclipse.gmf.runtime.diagram.ui.commands.ICommandProxy;
import org.eclipse.gmf.runtime.diagram.ui.editparts.IGraphicalEditPart;
import org.eclipse.gmf.runtime.diagram.ui.editpolicies.DiagramDragDropEditPolicy;
import org.eclipse.gmf.runtime.diagram.ui.requests.DropObjectsRequest;
import org.eclipse.swt.widgets.Display;

import com.ibm.ccl.soa.deploy.core.ui.internal.commands.AddToTopologyCommand;

/**
 * @since 1.0
 * 
 */
public class DeployDiagramDragDropEditPolicy extends DiagramDragDropEditPolicy implements
		EditPolicy {

	public Command getDropObjectsCommand(DropObjectsRequest dropRequest) {
		if (dropRequest.getObjects().size() > 0 && dropRequest.getObjects().get(0) instanceof String) {
			return getDropFileCommand(dropRequest);
		}
		return new ICommandProxy(new AddToTopologyCommand(dropRequest,
				(IGraphicalEditPart) getHost(), Display.getCurrent().getCursorLocation()));
	}

	protected Command getDropFileCommand(DropObjectsRequest dropRequest) {
		Iterator iter = dropRequest.getObjects().iterator();
		while (iter.hasNext()) {
			Object obj = iter.next();
			if (obj instanceof String) {
				//String filePath = (String)obj;
			}
		}

		return new ICommandProxy(UnexecutableCommand.INSTANCE);
	}

	/*
	 * 
	 * @see org.eclipse.gmf.runtime.diagram.ui.editpolicies.DiagramDragDropEditPolicy#getDropCommand(org.eclipse.gef.requests.ChangeBoundsRequest)
	 */
	protected Command getDropCommand(ChangeBoundsRequest request) {
		return null;
	}

}
