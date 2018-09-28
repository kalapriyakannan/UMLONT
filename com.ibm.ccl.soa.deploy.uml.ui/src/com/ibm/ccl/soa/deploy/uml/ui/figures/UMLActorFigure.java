package com.ibm.ccl.soa.deploy.uml.ui.figures;

import org.eclipse.draw2d.Graphics;
import org.eclipse.draw2d.geometry.Dimension;
import org.eclipse.swt.graphics.Image;
import org.eclipse.ui.plugin.AbstractUIPlugin;

import com.ibm.ccl.soa.deploy.core.ui.figures.DeployCoreFigure;
import com.ibm.ccl.soa.deploy.uml.ui.Activator;

public class UMLActorFigure extends DeployCoreFigure {
	private static final Dimension SIZE = new Dimension(65 * Q, 50 * Q);
	public static final Image ACTOR_IMAGE = AbstractUIPlugin.imageDescriptorFromPlugin(
			Activator.PLUGIN_ID, "icons/images/actor.gif").createImage(); //$NON-NLS-1$

	public UMLActorFigure() {
	}

	protected Dimension getMinimalSize() {
		return SIZE;
	}

	protected void paintFigure(Graphics g) {
		paintDeployImage(g, ACTOR_IMAGE, DeployCoreFigure.CONSTRAINED | DeployCoreFigure.CENTERED);
	}

	protected int getExtraHeight() {
		return 0;
	}

}
