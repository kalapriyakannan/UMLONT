/*******************************************************************************
 * Copyright (c) 2003, 2007 IBM Corporation Licensed Material - Property of IBM. All rights reserved.
 *  
 * US Government Users Restricted Rights - Use, duplication or disclosure v1.0 restricted by GSA ADP
 * Schedule Contract with IBM Corp.
 * 
 * Contributors: IBM Corporation - initial API and implementation
 *******************************************************************************/
package com.ibm.ccl.soa.deploy.core.ui.editpolicies;

import java.util.Iterator;

import org.eclipse.draw2d.geometry.Rectangle;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.gef.EditPart;
import org.eclipse.gef.commands.Command;
import org.eclipse.gef.requests.CreateRequest;
import org.eclipse.gmf.runtime.common.core.command.ICommand;
import org.eclipse.gmf.runtime.diagram.ui.commands.ICommandProxy;
import org.eclipse.gmf.runtime.diagram.ui.editparts.IGraphicalEditPart;
import org.eclipse.gmf.runtime.diagram.ui.editpolicies.XYLayoutEditPolicy;
import org.eclipse.gmf.runtime.diagram.ui.l10n.DiagramUIMessages;
import org.eclipse.gmf.runtime.diagram.ui.requests.CreateViewRequest;
import org.eclipse.gmf.runtime.emf.commands.core.command.CompositeTransactionalCommand;
import org.eclipse.gmf.runtime.emf.core.util.EObjectAdapter;
import org.eclipse.gmf.runtime.notation.View;

import com.ibm.ccl.soa.deploy.core.ui.internal.commands.DeploySetBoundsCommand;

/**
 * @author jswanke
 * 
 */
public class DeployXYLayoutEditPolicy extends XYLayoutEditPolicy {

	protected Command getCreateCommand(CreateRequest request) {
		CreateViewRequest req = (CreateViewRequest) request;
		TransactionalEditingDomain editingDomain = ((IGraphicalEditPart) getHost())
				.getEditingDomain();

		CompositeTransactionalCommand cc = new CompositeTransactionalCommand(editingDomain,
				DiagramUIMessages.AddCommand_Label);
		Iterator iter = req.getViewDescriptors().iterator();
		final Rectangle BOUNDS = (Rectangle) getConstraintFor(request);
		while (iter.hasNext()) {
			CreateViewRequest.ViewDescriptor viewDescriptor = (CreateViewRequest.ViewDescriptor) iter
					.next();
			Rectangle rect = getBoundsOffest(req, BOUNDS, viewDescriptor);
			cc.compose(new DeploySetBoundsCommand(editingDomain,
					DiagramUIMessages.SetLocationCommand_Label_Resize, viewDescriptor, rect));
		}
		if (cc.reduce() == null) {
			return null;
		}
		return chainGuideAttachmentCommands(request, new ICommandProxy(cc.reduce()));
	}

	protected Command createChangeConstraintCommand(EditPart child, Object constraint) {
		Rectangle newBounds = (Rectangle) constraint;
		View shapeView = (View) child.getModel();

		TransactionalEditingDomain editingDomain = ((IGraphicalEditPart) getHost())
				.getEditingDomain();

		ICommand boundsCommand = new DeploySetBoundsCommand(editingDomain,
				DiagramUIMessages.SetLocationCommand_Label_Resize, new EObjectAdapter(shapeView),
				newBounds);
		return new ICommandProxy(boundsCommand);
	}

	protected Command createAddCommand(EditPart child, Object constraint) {
		return null;
	}

}
