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

import org.eclipse.draw2d.IFigure;
import org.eclipse.draw2d.geometry.Point;
import org.eclipse.draw2d.geometry.Rectangle;
import org.eclipse.gef.GraphicalEditPart;
import org.eclipse.gef.Request;
import org.eclipse.gef.commands.Command;
import org.eclipse.gef.editpolicies.GraphicalEditPolicy;
import org.eclipse.gmf.runtime.diagram.ui.commands.ICommandProxy;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;

import com.ibm.ccl.soa.deploy.core.ui.internal.commands.NubEditPopUpCommand;
import com.ibm.ccl.soa.deploy.core.ui.requests.CreateNubEditPopupRequest;
import com.ibm.ccl.soa.deploy.core.ui.requests.RequestConstants;

/**
 * @since 1.0
 * 
 */
public class NubEditEditPolicy extends GraphicalEditPolicy {

	/**
	 * 
	 */
	public NubEditEditPolicy() {
		super();
	}

	public boolean understandsRequest(Request req) {
		if (RequestConstants.REQ_SHOW_NUB_EDIT.equals(req.getType())) {
			return true;
		}
		return false;
	}

	public Command getCommand(Request req) {

		if (req instanceof CreateNubEditPopupRequest) {
			CreateNubEditPopupRequest request = (CreateNubEditPopupRequest) req;
			org.eclipse.gef.GraphicalEditPart part = (GraphicalEditPart) request.getEditPart();
			IFigure figure = part.getFigure();
			Rectangle rect = figure.getBounds().getCopy();
			Shell shell = part.getViewer().getControl().getShell();
			Point location = new Point(rect.getTopRight());
			figure.translateToAbsolute(location);
			org.eclipse.swt.graphics.Point loc = location.getSWTPoint();
			Control canvas = part.getViewer().getControl();
			loc = Display.getCurrent().map(canvas, null, loc);
			return new ICommandProxy(new NubEditPopUpCommand(shell, request.getDmo(), request
					.isInDecorator(), loc, part.getViewer().getEditDomain()));
		}
		return null;
	}

}
