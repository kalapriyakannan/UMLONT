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

import org.eclipse.gef.commands.Command;
import org.eclipse.gmf.runtime.diagram.ui.commands.ICommandProxy;
import org.eclipse.gmf.runtime.diagram.ui.editparts.IGraphicalEditPart;
import org.eclipse.gmf.runtime.diagram.ui.editpolicies.ShapeCompartmentDropEditPolicy;
import org.eclipse.gmf.runtime.diagram.ui.requests.DropObjectsRequest;
import org.eclipse.swt.widgets.Display;

import com.ibm.ccl.soa.deploy.core.ui.internal.commands.AddToTopologyCommand;

/**
 * @since 7.0
 * 
 */
public class DeployShapeCompartmentDropEditPolicy extends ShapeCompartmentDropEditPolicy {
	public Command getDropObjectsCommand(DropObjectsRequest dropRequest) {
		return new ICommandProxy(new AddToTopologyCommand(dropRequest,
				(IGraphicalEditPart) getHost(), Display.getCurrent().getCursorLocation()));
	}
}
