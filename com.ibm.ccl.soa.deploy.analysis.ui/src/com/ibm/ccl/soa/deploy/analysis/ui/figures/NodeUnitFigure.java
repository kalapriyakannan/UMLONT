package com.ibm.ccl.soa.deploy.analysis.ui.figures;

import org.eclipse.draw2d.Graphics;

import com.ibm.ccl.soa.deploy.analysis.ui.internal.AnalysisUIMessages;
import com.ibm.ccl.soa.deploy.core.ui.figures.ConceptualNodeFigure;

public class NodeUnitFigure  extends ConceptualNodeFigure {
		/**
	 * Constructor for DeploymentUnitFigure.
	 */

	public NodeUnitFigure() {
		setCategory(AnalysisUIMessages.NodeUnitEditPart_Nod_);
		setConceptual(true);
	}

	/**
	 * Draw the state object.
	 * 
	 * @see org.eclipse.draw2d.Figure#paintBorder(org.eclipse.draw2d.Graphics)
	 */
	protected void paintFigure(Graphics g) {
		super.paintFigure(g);
	}
}
