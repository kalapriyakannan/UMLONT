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

import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.draw2d.IFigure;
import org.eclipse.draw2d.Locator;
import org.eclipse.draw2d.geometry.Dimension;
import org.eclipse.draw2d.geometry.Rectangle;
import org.eclipse.gef.GraphicalEditPart;
import org.eclipse.gmf.runtime.diagram.ui.services.decorator.IDecoratorTarget;

import com.ibm.ccl.soa.deploy.core.ui.DeployCoreUIPlugin;
import com.ibm.ccl.soa.deploy.core.ui.editparts.UnresolvedProxyConnectionEditPart;
import com.ibm.ccl.soa.deploy.core.ui.editparts.UnresolvedProxyEditPart;
import com.ibm.ccl.soa.deploy.core.ui.editparts.UnresolvedProxyEditPart.UnresolvedProxyFigure;
import com.ibm.ccl.soa.deploy.core.ui.figures.ErrorMarkerFigure;
import com.ibm.ccl.soa.deploy.core.ui.providers.DeployDecoratorProvider;
import com.ibm.ccl.soa.deploy.core.ui.util.GEFUtils;

/**
 * @see DeployDecoratorProvider
 * @see ErrorMarkerFigure
 */
public class UnresolvedReferenceDecorator extends DeployDecorator {

	private boolean isInnerHostingList = false;
	private boolean isActivated = false;
	private GraphicalEditPart ownerEP = null;

	private final IStatus unRefStatus = new Status(IStatus.ERROR, DeployCoreUIPlugin.PLUGIN_ID, 0,
			"Unresolved Reference", null); //$NON-NLS-1$

	/**
	 * Create an error decorator.
	 * 
	 * @param decoratorTarget
	 */
	public UnresolvedReferenceDecorator(IDecoratorTarget decoratorTarget) {
		super(decoratorTarget);

		// determine if this is an inner hosting list
		ownerEP = (GraphicalEditPart) decoratorTarget.getAdapter(GraphicalEditPart.class);
		IFigure figure = ownerEP.getFigure();
		isInnerHostingList = figure instanceof UnresolvedProxyFigure
				&& ((UnresolvedProxyFigure) figure).isInList();
	}

	/**
	 * ============== ACTIVATE ================================================================
	 */
	public void activate() {
		isActivated = true;
		refresh();
	}

	/**
	 * ============= DEACTIVATE=================================================================
	 */
	public void deactivate() {
		isActivated = false;
		super.deactivate();
	}

	/**
	 * ================ REFRESH STATUS IN DECORATION=============================================
	 */
	public void refresh() {
		if (!isActivated) {
			return;
		}
		removeDecoration();

		// add the error decorator to a figure or a link
		if (ownerEP instanceof UnresolvedProxyEditPart) {
			addShapeDecoration(unRefStatus);
		} else if (ownerEP instanceof UnresolvedProxyConnectionEditPart) {
			addEdgeDecoration(unRefStatus);
		}
	}

	// put an error marker on a figure with a listener that opens the resolution dialog
	private void addShapeDecoration(IStatus status) {
		ErrorMarkerFigure figure = new ErrorMarkerFigure(status, getDecoratorTarget());
		final Rectangle bounds = figure.getBounds();
		final GraphicalEditPart editpart = (GraphicalEditPart) getDecoratorTarget().getAdapter(
				GraphicalEditPart.class);
		Locator locator = new Locator() {
			public void relocate(IFigure target) {
				IFigure parentFigure = editpart.getFigure();
				Rectangle r = parentFigure.getBounds().getCopy();
				parentFigure.translateToAbsolute(r);
				target.translateToRelative(r);
				// if attribute is on a hosting list item we need to center it
				Dimension size = target.getSize();
				if (isInnerHostingList) {
					int itemHeight = GEFUtils.getListItemHeight(parentFigure) / 2;
					r.x += 11 * Q;
					r.y += itemHeight - size.height / 2;
				} else {
					r.x += 3 * Q;
					r.y += r.height - bounds.height;
				}
				r.setSize(size);
				target.setBounds(r);
			}
		};
		setDecoration(getDecoratorTarget().addDecoration(figure, locator, true));
	}

	// put an error marker on a link with a listener that opens the resolution dialog
	private void addEdgeDecoration(IStatus status) {
		IFigure figure = new ErrorMarkerFigure(status, getDecoratorTarget());
		setDecoration(getDecoratorTarget().addConnectionDecoration(figure, 50, true));
	}

}
