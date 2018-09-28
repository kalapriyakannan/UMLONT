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

import org.eclipse.draw2d.IFigure;
import org.eclipse.draw2d.Locator;
import org.eclipse.draw2d.geometry.Dimension;
import org.eclipse.draw2d.geometry.Rectangle;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.gmf.runtime.diagram.ui.editparts.GraphicalEditPart;
import org.eclipse.gmf.runtime.diagram.ui.services.decorator.IDecoratorTarget;
import org.eclipse.gmf.runtime.notation.DrawerStyle;
import org.eclipse.gmf.runtime.notation.NotationPackage;
import org.eclipse.gmf.runtime.notation.View;

import com.ibm.ccl.soa.deploy.core.ui.providers.DeployDecoratorProvider;
import com.ibm.ccl.soa.deploy.core.ui.util.GEFUtils;

/**
 * @see DeployDecoratorProvider
 */
abstract public class ShapesCollapseButtonDecorator extends CollapseButtonDecorator {

	/**
	 * @param decoratorTarget
	 */
	public ShapesCollapseButtonDecorator(IDecoratorTarget decoratorTarget) {
		super(decoratorTarget);
	}

	protected void refreshStatus(View view, EObject object) {
		// look for the compartment
		DrawerStyle style = (DrawerStyle) view.getStyle(NotationPackage.eINSTANCE.getDrawerStyle());
		boolean isCollapsed = style != null ? style.isCollapsed() : true;
		addCollapsedDecoration(isCollapsed);
	}

	protected Locator getLocator(final GraphicalEditPart editpart) {
		return new Locator() {
			public void relocate(IFigure target) {
				IFigure parentFigure = editpart.getFigure();
				Rectangle r = parentFigure.getBounds().getCopy();
				parentFigure.translateToAbsolute(r);
				target.translateToRelative(r);
				int hdrHeight = GEFUtils.getShapesHeaderHeight(parentFigure);
				r.x += 11 * Q;
				r.y += hdrHeight - 6 * Q;
				Dimension size = collapseFigure.getPreferredSize();
				r.setSize(size);
				target.setBounds(r);
				collapseFigure.setSize(size);
			}
		};
	}
}
