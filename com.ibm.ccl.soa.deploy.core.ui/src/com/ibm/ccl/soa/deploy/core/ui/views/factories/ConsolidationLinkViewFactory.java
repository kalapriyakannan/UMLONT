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
import org.eclipse.gmf.runtime.diagram.ui.view.factories.ConnectionViewFactory;
import org.eclipse.gmf.runtime.notation.NotationPackage;
import org.eclipse.gmf.runtime.notation.View;

import com.ibm.ccl.soa.deploy.core.ui.providers.DeployCoreViewProvider;

/**
 * ConsolidationLink view factory.
 * 
 * @author jswanke
 * @see DeployCoreViewProvider
 * @see ConnectionLinkConnection
 */
public class ConsolidationLinkViewFactory extends ConnectionViewFactory {

	public View createView(IAdaptable semanticAdapter, View containerView, String semanticHint,
			int index, boolean persisted, final PreferencesHint preferencesHint) {
		// we never want consolidated links to be persisted
		return super.createView(semanticAdapter, containerView, semanticHint, index, false,
				preferencesHint);
	}

	protected void decorateView(View containerView, View view, IAdaptable element,
			String semanticHint, int index, boolean persisted) {
		super.decorateView(containerView, view, element, semanticHint, index, persisted);
		ViewUtil.setStructuralFeatureValue(view, NotationPackage.eINSTANCE
				.getRoutingStyle_AvoidObstructions(), Boolean.TRUE);
	}
}
