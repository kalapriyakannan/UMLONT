/*******************************************************************************
 * Copyright (c) 2003, 2007 IBM Corporation Licensed Material - Property of IBM. All rights reserved.
 *  
 * US Government Users Restricted Rights - Use, duplication or disclosure v1.0 restricted by GSA ADP
 * Schedule Contract with IBM Corp.
 * 
 * Contributors: IBM Corporation - initial API and implementation
 *******************************************************************************/
package com.ibm.ccl.soa.deploy.core.ui.editparts.core;

import org.eclipse.draw2d.DelegatingLayout;
import org.eclipse.draw2d.IFigure;
import org.eclipse.gef.EditPart;
import org.eclipse.gef.GraphicalEditPart;
import org.eclipse.gmf.runtime.diagram.ui.editparts.IGraphicalEditPart;
import org.eclipse.gmf.runtime.diagram.ui.editparts.ShapeNodeEditPart;
import org.eclipse.gmf.runtime.gef.ui.figures.NodeFigure;
import org.eclipse.gmf.runtime.notation.View;

import com.ibm.ccl.soa.deploy.core.ui.editparts.DeployListCompartmentEditPart;
import com.ibm.ccl.soa.deploy.core.ui.figures.DeployListItemFigure;
import com.ibm.ccl.soa.deploy.core.ui.figures.core.CompartmentFigure;
import com.ibm.ccl.soa.deploy.core.ui.figures.core.CompositeShapeFigure;

/**
 * 
 * @since 1.0
 * 
 */
public abstract class CompositeShapeEditPart extends ShapeNodeEditPart {
	private boolean isInList = false;

	/**
	 * Create an instance.
	 * 
	 * @param view
	 *           editpart's model
	 */
	public CompositeShapeEditPart(View view) {
		super(view);
	}

	/**
	 * derived classes must create their figures in the createMainFigure() method instead of the
	 * usual createNodeFigure method because we need to wrap the whole thing in our own composite
	 * figure with their inner figure and our outer figure
	 */
	protected final NodeFigure createNodeFigure() {
		NodeFigure mainFigure = null;
		if (getParent() instanceof DeployListCompartmentEditPart) {
			mainFigure = new DeployListItemFigure((DeployListCompartmentEditPart) getParent());
			mainFigure.setLayoutManager(new DelegatingLayout());
			isInList = true;
		} else {
			mainFigure = createMainFigure();
		}
		return new CompositeShapeFigure(mainFigure);
	}

	/**
	 * Creates this editpart's main figure.
	 * 
	 * @return the created <code>NodeFigure</code>
	 */
	protected abstract NodeFigure createMainFigure();

	/**
	 * called by IGraphicalEditPart when a new figure is being added to the diagram; first we get the
	 * editpart's figure and if it's a compartment figure, we add it to the outside figure,
	 * otherwise, by default we add it to the user's inner (main) figure
	 */
	protected void addChildVisual(EditPart childEditPart, int index) {
		IFigure childFigure = ((GraphicalEditPart) childEditPart).getFigure();

		// if this is a List compartment, position it in the center below the name
		if (childEditPart instanceof DeployListCompartmentEditPart) {
			CompartmentFigure compartmentFigure = (CompartmentFigure) getOuterFigure();
			compartmentFigure.addCompartment((NodeFigure) childFigure, null);
			// else this is the name, just add it to the figure as it
		} else {
			IFigure fig = getMainFigure();
			fig.add(childFigure);
		}
	}

	/**
	 * Remove the supplied child editpart's figure from this editpart's figure.
	 */
	protected void removeChildVisual(EditPart child) {
		IFigure childFigure = ((GraphicalEditPart) child).getFigure();
		IFigure parentFigure = getContentPaneFor((IGraphicalEditPart) child);
		if (parentFigure == childFigure.getParent()) {
			parentFigure.remove(childFigure);
		}
	}

	/**
	 * Returns the user defined inner node figure.
	 * 
	 * @return <code>IFigure</code>
	 */
	public final IFigure getMainFigure() {
		return getCompositeFigure().getInnerFigure();
	}

	/**
	 * Returns the outer figure with compartments.
	 * 
	 * @return <code>IFigure</code>
	 */
	protected final IFigure getOuterFigure() {
		return getCompositeFigure().getOuterFigure();
	}

	/**
	 * Returns the figure with both inner and outer figure.
	 * 
	 * @return <code>IFigure</code>
	 */
	protected final CompositeShapeFigure getCompositeFigure() {
		return (CompositeShapeFigure) getFigure();
	}

	/**
	 * Sets the supplied constraint on the <tt>childFigure</tt>.
	 * 
	 * @see org.eclipse.gef.GraphicalEditPart#setLayoutConstraint(EditPart, IFigure, Object)
	 */
	public void setLayoutConstraint(EditPart child, IFigure childFigure, Object constraint) {
		//	getContentPaneFor((IGraphicalEditPart) child).setConstraint(childFigure, constraint);
	}

	protected IFigure getContentPaneFor(IGraphicalEditPart editPart) {
		return getMainFigure();
	}

	/**
	 * @return in list
	 */
	public boolean isInList() {
		return isInList;
	}

}
