/*******************************************************************************
 * Copyright (c) 2003, 2007 IBM Corporation Licensed Material - Property of IBM. All rights reserved.
 *  
 * US Government Users Restricted Rights - Use, duplication or disclosure v1.0 restricted by GSA ADP
 * Schedule Contract with IBM Corp.
 * 
 * Contributors: IBM Corporation - initial API and implementation
 *******************************************************************************/

package com.ibm.ccl.soa.deploy.core.ui.requests;

import org.eclipse.gef.EditPart;
import org.eclipse.gef.Request;
import org.eclipse.swt.graphics.Point;

import com.ibm.ccl.soa.deploy.core.DeployModelObject;

/**
 * @since 1.0
 * 
 */
public class CreateNubEditPopupRequest extends Request {

	private final DeployModelObject dmo;
	private final EditPart editPart;
	private final boolean isInDecorator;
	private final Point point;

	/**
	 * @param dmo
	 * @param editPart
	 * @param isInDecorator
	 * @param point
	 */
	public CreateNubEditPopupRequest(DeployModelObject dmo, EditPart editPart,
			boolean isInDecorator, Point point) {
		super(RequestConstants.REQ_SHOW_NUB_EDIT);
		this.dmo = dmo;
		this.editPart = editPart;
		this.isInDecorator = isInDecorator;
		this.point = point;
	}

	/**
	 * @return point of mouse
	 */
	public Point getPoint() {
		return point;
	}

	/**
	 * @return dmo of component
	 */
	public DeployModelObject getDmo() {
		return dmo;
	}

	/**
	 * @return editpart of nub
	 */
	public EditPart getEditPart() {
		return editPart;
	}

	/**
	 * @return is in decorator
	 */
	public boolean isInDecorator() {
		return isInDecorator;
	}

}
