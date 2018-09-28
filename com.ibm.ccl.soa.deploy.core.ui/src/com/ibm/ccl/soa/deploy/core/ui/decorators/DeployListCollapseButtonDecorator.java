/***************************************************************************************************
 * Copyright (c) 2003, 2007 IBM Corporation Licensed Material - Property of IBM. All rights
 * reserved.
 * 
 * US Government Users Restricted Rights - Use, duplication or disclosure v1.0 restricted by GSA ADP
 * Schedule Contract with IBM Corp.
 * 
 * Contributors: IBM Corporation - initial API and implementation
 **************************************************************************************************/
package com.ibm.ccl.soa.deploy.core.ui.decorators;

import java.util.List;

import org.eclipse.draw2d.IFigure;
import org.eclipse.draw2d.Locator;
import org.eclipse.draw2d.geometry.Dimension;
import org.eclipse.draw2d.geometry.Rectangle;
import org.eclipse.gmf.runtime.diagram.ui.editparts.GraphicalEditPart;
import org.eclipse.gmf.runtime.diagram.ui.services.decorator.IDecoratorTarget;

import com.ibm.ccl.soa.deploy.core.Unit;
import com.ibm.ccl.soa.deploy.core.ui.figures.DeployListItemFigure;
import com.ibm.ccl.soa.deploy.core.ui.figures.core.CompositeShapeFigure;
import com.ibm.ccl.soa.deploy.core.ui.properties.PropertyUtils;
import com.ibm.ccl.soa.deploy.core.ui.providers.DeployDecoratorProvider;
import com.ibm.ccl.soa.deploy.core.ui.util.ContainmentStateUtils;
import com.ibm.ccl.soa.deploy.core.ui.util.GEFUtils;
import com.ibm.ccl.soa.deploy.core.ui.util.GMFUtils;

/**
 * @see DeployDecoratorProvider
 */
abstract public class DeployListCollapseButtonDecorator extends CollapseButtonDecorator {
	protected boolean isInnerList = false;
	protected final GraphicalEditPart editpart;

	/**
	 * @param decoratorTarget
	 */
	public DeployListCollapseButtonDecorator(IDecoratorTarget decoratorTarget) {
		super(decoratorTarget);

		// determine if this is an inner hosting list
		editpart = (GraphicalEditPart) decoratorTarget.getAdapter(GraphicalEditPart.class);
		IFigure figure = editpart.getFigure();
		if (figure instanceof CompositeShapeFigure) {
			CompositeShapeFigure compositeFig = (CompositeShapeFigure) figure;
			IFigure fig = compositeFig.getInnerFigure();
			isInnerList = fig instanceof DeployListItemFigure;
		}
	}

	protected Locator getLocator(final GraphicalEditPart editpart) {
		return new Locator() {
			public void relocate(IFigure target) {
				IFigure parentFigure = editpart.getFigure();
				Rectangle r = parentFigure.getBounds().getCopy();
				parentFigure.translateToAbsolute(r);
				target.translateToRelative(r);
				if (!isInnerList) {
					int hdrHeight = GEFUtils.getListHeaderHeight(parentFigure);
					r.x += 11 * Q;
					r.y += hdrHeight - 6 * Q;
					// inside a list (+/- signs)
				} else {
					r.x += Q;
					int itemHeight = GEFUtils.getListItemHeight(parentFigure) / 2;
					r.y += itemHeight - 4 * Q;
				}
				Dimension size = collapseFigure.getPreferredSize();
				r.setSize(size);
				target.setBounds(r);
				collapseFigure.setSize(size);
			}
		};
	}

	// use +/- signs for expand buttons in inner lists, use regular triangle twitie button for outer list
	protected boolean useTreeEmulation() {
		return isInnerList;
	}

	protected boolean hasHostedItems(Unit host, List<?> filteredElements) {
		boolean isInImportTopologyEditPart = GMFUtils.isImportTreeTopology(editpart);
		boolean isInDiagramNodeEditPart = GMFUtils.isDiagramTreeNode(editpart);
		for (Unit hosted : GMFUtils.getAllHostees(host)) {
			if ((hosted != null && ContainmentStateUtils.isContainedUnit(editpart, hosted)
					|| isInImportTopologyEditPart || isInDiagramNodeEditPart)
					&& (!PropertyUtils.isProxy(hosted) || PropertyUtils.isProxy(host.getTopology()))
					&& (filteredElements == null || !filteredElements.contains(hosted))) {
				return true;
			}
		}
		return false;
	}
}
