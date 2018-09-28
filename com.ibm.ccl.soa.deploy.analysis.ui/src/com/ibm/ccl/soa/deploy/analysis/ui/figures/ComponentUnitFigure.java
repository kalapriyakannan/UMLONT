package com.ibm.ccl.soa.deploy.analysis.ui.figures;

import org.eclipse.draw2d.Graphics;

import com.ibm.ccl.soa.deploy.core.ui.figures.UnitGroupFigure;

public class ComponentUnitFigure  extends UnitGroupFigure {

	/**
	 * Constructor for ComponentUnitFigure.
	 */

	public ComponentUnitFigure() {
	}

	/**
	 * Draw the state object.
	 * 
	 * @see org.eclipse.draw2d.Figure#paintBorder(org.eclipse.draw2d.Graphics)
	 */
	protected void paintFigure(Graphics g) {
		//TODO NM ???
		paintDeployApplication(g);
	}
}
