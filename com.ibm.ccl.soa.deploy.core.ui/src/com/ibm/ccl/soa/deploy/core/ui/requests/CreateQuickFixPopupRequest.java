/*******************************************************************************
 * Copyright (c) 2003, 2007 IBM Corporation Licensed Material - Property of IBM. All rights reserved.
 *  
 * US Government Users Restricted Rights - Use, duplication or disclosure v1.0 restricted by GSA ADP
 * Schedule Contract with IBM Corp.
 * 
 * Contributors: IBM Corporation - initial API and implementation
 *******************************************************************************/

package com.ibm.ccl.soa.deploy.core.ui.requests;

import org.eclipse.core.runtime.IStatus;
import org.eclipse.gef.Request;
import org.eclipse.swt.graphics.Point;

import com.ibm.ccl.soa.deploy.core.ui.decorators.ErrorMarkerDecorator;

/**
 * @since 1.0
 * 
 */
public class CreateQuickFixPopupRequest extends Request {

	private final IStatus status;
	private final Point point;
	private final ErrorMarkerDecorator source;

	/**
	 * @param status
	 * @param point
	 */
	public CreateQuickFixPopupRequest(IStatus status, Point point, ErrorMarkerDecorator source) {
		super(RequestConstants.REQ_SHOW_QUICK_FIX);
		this.status = status;
		this.point = point;
		this.source = source;
	}

	/**
	 * @return Returns the IStatus
	 */
	public IStatus getStatus() {
		return status;
	}

	public Point getPoint() {
		return point;
	}

	public ErrorMarkerDecorator getSource() {
		return source;
	}

}
