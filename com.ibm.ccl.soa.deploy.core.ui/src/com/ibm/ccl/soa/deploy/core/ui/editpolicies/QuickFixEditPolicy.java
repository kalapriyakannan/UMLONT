/*******************************************************************************
 * Copyright (c) 2003, 2007 IBM Corporation Licensed Material - Property of IBM. All rights reserved.
 *  
 * US Government Users Restricted Rights - Use, duplication or disclosure v1.0 restricted by GSA ADP
 * Schedule Contract with IBM Corp.
 * 
 * Contributors: IBM Corporation - initial API and implementation
 *******************************************************************************/

package com.ibm.ccl.soa.deploy.core.ui.editpolicies;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.eclipse.core.resources.IMarker;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.gef.Request;
import org.eclipse.gef.commands.Command;
import org.eclipse.gef.editpolicies.GraphicalEditPolicy;
import org.eclipse.gmf.runtime.diagram.ui.commands.ICommandProxy;
import org.eclipse.gmf.runtime.diagram.ui.editparts.IGraphicalEditPart;
import org.eclipse.swt.graphics.Point;

import com.ibm.ccl.soa.deploy.core.ui.decorators.ErrorMarkerDecorator;
import com.ibm.ccl.soa.deploy.core.ui.internal.commands.QuickFixPopUpCommand;
import com.ibm.ccl.soa.deploy.core.ui.requests.CreateQuickFixPopupRequest;
import com.ibm.ccl.soa.deploy.core.ui.requests.RequestConstants;
import com.ibm.ccl.soa.deploy.core.util.FilterIterator;
import com.ibm.ccl.soa.deploy.core.validator.status.IDeployStatus;
import com.ibm.ccl.soa.deploy.core.validator.status.StatusIterator;

/**
 * @since 1.0
 * 
 */
public class QuickFixEditPolicy extends GraphicalEditPolicy {

	/**
	 * 
	 */
	public QuickFixEditPolicy() {
		super();

	}

	public boolean understandsRequest(Request req) {
		if (RequestConstants.REQ_SHOW_QUICK_FIX.equals(req.getType())) {
			return true;
		}
		return false;
	}

	public Command getCommand(Request request) {

		if (request instanceof CreateQuickFixPopupRequest) {
			IMarker[] markers = null;
			Point p = ((CreateQuickFixPopupRequest) request).getPoint();

			IStatus status = ((CreateQuickFixPopupRequest) request).getStatus();
			ErrorMarkerDecorator decorator = ((CreateQuickFixPopupRequest) request).getSource();
			List list = new ArrayList();
			for (Iterator iter = new FilterIterator(new StatusIterator(status),
					StatusIterator.DEPLOY_STATUS_FILTER); iter.hasNext();) {
				IDeployStatus deployStatus = (IDeployStatus) iter.next();
				if (deployStatus.getMarker() != null) {
					list.add(deployStatus.getMarker());
				}
			}
			markers = (IMarker[]) list.toArray(new IMarker[list.size()]);

			return new ICommandProxy(new QuickFixPopUpCommand((IGraphicalEditPart) getHost(), markers,
					status, p, decorator));
		}
		return null;
	}

}
