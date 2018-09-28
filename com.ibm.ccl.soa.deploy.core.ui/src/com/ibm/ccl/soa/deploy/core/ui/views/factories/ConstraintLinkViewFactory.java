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
import org.eclipse.emf.ecore.EObject;
import org.eclipse.gmf.runtime.diagram.core.preferences.PreferencesHint;
import org.eclipse.gmf.runtime.diagram.core.util.ViewUtil;
import org.eclipse.gmf.runtime.diagram.ui.view.factories.ConnectionViewFactory;
import org.eclipse.gmf.runtime.notation.NotationPackage;
import org.eclipse.gmf.runtime.notation.Routing;
import org.eclipse.gmf.runtime.notation.View;

import com.ibm.ccl.soa.deploy.core.ui.util.GMFUtils;

/**
 * 
 * @since 1.0
 * 
 */
public class ConstraintLinkViewFactory extends ConnectionViewFactory {

	public View createView(IAdaptable semanticAdapter, View containerView, String semanticHint,
			int index, boolean persisted, final PreferencesHint preferencesHint) {
		// canonical policies make persistence false-- so we override to make true
		return super.createView(semanticAdapter, containerView, semanticHint, index, true,
				preferencesHint);

	}

	protected void decorateView(View containerView, View view, IAdaptable element,
			String semanticHint, int index, boolean persisted) {
		super.decorateView(containerView, view, element, semanticHint, index, persisted);
		EObject eo = (EObject) element.getAdapter(EObject.class);
		if (GMFUtils.isHostingLink(eo)) {
			ViewUtil.setStructuralFeatureValue(view, NotationPackage.eINSTANCE
					.getRoutingStyle_Routing(), Routing.RECTILINEAR_LITERAL);
		} else {
			ViewUtil.setStructuralFeatureValue(view, NotationPackage.eINSTANCE
					.getRoutingStyle_AvoidObstructions(), Boolean.TRUE);
		}

	}
}
