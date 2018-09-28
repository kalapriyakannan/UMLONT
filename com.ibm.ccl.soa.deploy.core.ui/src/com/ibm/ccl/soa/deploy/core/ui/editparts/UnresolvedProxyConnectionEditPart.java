/***************************************************************************************************
 * Copyright (c) 2003, 2007 IBM Corporation Licensed Material - Property of IBM. All rights
 * reserved.
 * 
 * US Government Users Restricted Rights - Use, duplication or disclosure v1.0 restricted by GSA ADP
 * Schedule Contract with IBM Corp.
 * 
 * Contributors: IBM Corporation - initial API and implementation
 **************************************************************************************************/
package com.ibm.ccl.soa.deploy.core.ui.editparts;

import org.eclipse.draw2d.ColorConstants;
import org.eclipse.draw2d.Connection;
import org.eclipse.draw2d.Graphics;
import org.eclipse.gef.EditPart;
import org.eclipse.gmf.runtime.diagram.ui.editparts.ConnectionNodeEditPart;
import org.eclipse.gmf.runtime.draw2d.ui.figures.PolylineConnectionEx;
import org.eclipse.gmf.runtime.notation.View;

import com.ibm.ccl.soa.deploy.core.ui.util.GMFUtils;

/**
 * An editpart to show an unresolved proxy connection view.
 * 
 * @author jswanke
 */
public class UnresolvedProxyConnectionEditPart extends ConnectionNodeEditPart {

	/**
	 * Constructs a new instance.
	 * 
	 * @param view
	 */
	public UnresolvedProxyConnectionEditPart(View view) {
		super(view);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.gmf.runtime.diagram.ui.editparts.ConnectionEditPart#createConnectionFigure()
	 */
	protected Connection createConnectionFigure() {

		PolylineConnectionEx conn = new PolylineConnectionEx() {

			public void paint(Graphics graphics) {
				setForegroundColor(ColorConstants.darkGray);
				super.paint(graphics);
			}

		};
		return conn;
	}

	@Override
	public void setSource(EditPart editPart) {
		super.setSource(editPart);
		filterConnections();
	}

	@Override
	public void setTarget(EditPart editPart) {
		super.setTarget(editPart);
		filterConnections();
	}

	private void filterConnections() {
		if (getSource() == null || getTarget() == null) {
			return;
		}
		getFigure().setVisible(
				!GMFUtils.isImportTopology(getSource()) && !GMFUtils.isImportTopology(getTarget()));
	}
}