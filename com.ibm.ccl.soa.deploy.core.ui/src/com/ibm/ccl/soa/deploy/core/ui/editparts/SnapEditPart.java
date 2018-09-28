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

import org.eclipse.draw2d.Graphics;
import org.eclipse.gmf.runtime.diagram.ui.editparts.ShapeNodeEditPart;
import org.eclipse.gmf.runtime.gef.ui.figures.NodeFigure;
import org.eclipse.gmf.runtime.notation.View;

/**
 * An editpart for snap groups and snap rows -- not shown, views are used to guide other views
 * 
 * @author jswanke
 */
public class SnapEditPart extends ShapeNodeEditPart {

	static class SnapFigure extends NodeFigure {

		public SnapFigure() {
		}

		protected void paintFigure(Graphics g) {
		}

	}

	/**
	 * Constructs a new instance.
	 * 
	 * @param view
	 */
	public SnapEditPart(View view) {
		super(view);
	}

	@Override
	protected NodeFigure createNodeFigure() {
		return new SnapFigure();
	}

	@Override
	public boolean isSelectable() {
		return false;
	}

}
