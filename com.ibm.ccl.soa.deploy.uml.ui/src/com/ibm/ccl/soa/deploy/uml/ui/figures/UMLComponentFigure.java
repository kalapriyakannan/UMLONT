package com.ibm.ccl.soa.deploy.uml.ui.figures;

import org.eclipse.draw2d.Graphics;

import com.ibm.ccl.soa.deploy.core.ui.figures.DeployCoreFigure;

public class UMLComponentFigure extends DeployCoreFigure {
	public UMLComponentFigure() {
	}

	protected void paintFigure(Graphics g) {
		paintDeployApplication(g);
	}
}
