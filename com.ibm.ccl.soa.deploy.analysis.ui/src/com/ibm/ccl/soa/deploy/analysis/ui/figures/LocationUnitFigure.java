package com.ibm.ccl.soa.deploy.analysis.ui.figures;

import org.eclipse.draw2d.Graphics;

import com.ibm.ccl.soa.deploy.core.ui.figures.UnitGroupFigure;

public class LocationUnitFigure  extends UnitGroupFigure {

	/**
	 * Constructor for DeploymentUnitFigure.
	 */

	public LocationUnitFigure() {
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
