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

import java.util.List;

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
 * @author jswanke
 * 
 */
public class ImportListContainerViewFactory extends AbstractShapeViewFactory {

	/**
	 * @param semanticAdapter
	 * @param containerView
	 * @param semanticHint
	 * @param index
	 * @param persisted
	 */
	public View createView(IAdaptable semanticAdapter, View containerView, String semanticHint,
			int index, boolean persisted, final PreferencesHint preferencesHint) {
		// canonical policies make persistence false-- so we override to make true
		View view = super.createView(semanticAdapter, containerView, semanticHint, index, true,
				preferencesHint);
		return view;
	}

	protected List createStyles(View view) {
		List styles = super.createStyles(view);
		styles.add(DeployNotationFactory.eINSTANCE.createDeployStyle());
		styles.add(NotationFactory.eINSTANCE.createDiagramLinkStyle());
		return styles;
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

		// append a view that will allow the user to see/edit this Unit Collection's name
		getViewService().createNode(semanticAdapter, view, DeployCoreConstants.DEPLOY_NAME,
				ViewUtil.APPEND, persisted, getPreferencesHint());

		// append a view that will contain the group area
		getViewService().createNode(semanticAdapter, view,
				DeployCoreConstants.IMPORTTOPOLOGYLIST_SEMANTICHINT, ViewUtil.APPEND, persisted,
				getPreferencesHint());
	}

}
