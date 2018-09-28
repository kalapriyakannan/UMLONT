/***************************************************************************************************
 * Copyright (c) 2003, 2007 IBM Corporation Licensed Material - Property of IBM. All rights
 * reserved.
 * 
 * US Government Users Restricted Rights - Use, duplication or disclosure v1.0 restricted by GSA ADP
 * Schedule Contract with IBM Corp.
 * 
 * Contributors: IBM Corporation - initial API and implementation
 **************************************************************************************************/
package com.ibm.ccl.soa.deploy.core.ui.views.factories;

import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.gmf.runtime.diagram.core.preferences.PreferencesHint;
import org.eclipse.gmf.runtime.diagram.core.util.ViewUtil;
import org.eclipse.gmf.runtime.diagram.ui.view.factories.AbstractShapeViewFactory;
import org.eclipse.gmf.runtime.notation.FontStyle;
import org.eclipse.gmf.runtime.notation.NotationFactory;
import org.eclipse.gmf.runtime.notation.NotationPackage;
import org.eclipse.gmf.runtime.notation.View;

import com.ibm.ccl.soa.deploy.core.ui.notation.DeployNotationFactory;
import com.ibm.ccl.soa.deploy.core.ui.util.DeployCoreConstants;

/**
 * DiagramViewFactory creates the diagram-- this creates a node in a diagram that represents another
 * diagram
 * 
 * @since 1.0
 * 
 */
public class DiagramShapesContainerViewFactory extends AbstractShapeViewFactory {
	public View createView(IAdaptable semanticAdapter, View containerView, String semanticHint,
			int index, boolean persisted, PreferencesHint preferencesHint) {
		View view = super.createView(semanticAdapter, containerView, semanticHint, index, true,
				preferencesHint);
		view.getStyles().add(NotationFactory.eINSTANCE.createRoutingStyle());
		view.getStyles().add(DeployNotationFactory.eINSTANCE.createDeployStyle());
		return view;
	}

	protected void decorateView(View containerView, View view, IAdaptable semanticAdapter,
			String semanticHint, int index, boolean persisted) {
		super.decorateView(containerView, view, semanticAdapter, semanticHint, index, persisted);

		// unset font preferences that were set in super class
		FontStyle fontStyle = (FontStyle) view.getStyle(NotationPackage.Literals.FONT_STYLE);
		if (fontStyle != null) {
			fontStyle.eUnset(NotationPackage.Literals.FONT_STYLE__FONT_NAME);
			fontStyle.eUnset(NotationPackage.Literals.FONT_STYLE__FONT_HEIGHT);
		}

		// append a view that will allow the user to see/edit this Unit's name
		getViewService().createNode(semanticAdapter, view, DeployCoreConstants.DEPLOY_NAME,
				ViewUtil.APPEND, persisted, getPreferencesHint());

		// append a view that will allow the user to see this Unit's contained hostees
		getViewService().createNode(semanticAdapter, view,
				DeployCoreConstants.DIAGRAMNODESHAPES_SEMANTICHINT, ViewUtil.APPEND, persisted,
				getPreferencesHint());
	}

}
