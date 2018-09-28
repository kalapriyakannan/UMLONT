/*******************************************************************************
 * Copyright (c) 2003, 2007 IBM Corporation Licensed Material - Property of IBM. All rights reserved.
 *  
 * US Government Users Restricted Rights - Use, duplication or disclosure v1.0 restricted by GSA ADP
 * Schedule Contract with IBM Corp.
 * 
 * Contributors: IBM Corporation - initial API and implementation
 *******************************************************************************/
package com.ibm.ccl.soa.deploy.core.ui.views.factories;

import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.gmf.runtime.diagram.core.preferences.PreferencesHint;
import org.eclipse.gmf.runtime.diagram.ui.view.factories.ConnectionViewFactory;
import org.eclipse.gmf.runtime.notation.View;

import com.ibm.ccl.soa.deploy.core.ui.providers.DeployCoreViewProvider;

/**
 * View factory for filter surrogate link (edge).
 * 
 * @author Ed Snible snible@us.ibm.com
 * @see DeployCoreViewProvider
 * @deprecated
 */
public class FilterSurrogateLinkViewFactory extends ConnectionViewFactory {

	public View createView(IAdaptable semanticAdapter, View containerView, String semanticHint,
			int index, boolean persisted, final PreferencesHint preferencesHint) {
		persisted = true;
		return super.createView(semanticAdapter, containerView, semanticHint, index, persisted,
				preferencesHint);

	}

//	protected void decorateView(View containerView, View view, IAdaptable element, String semanticHint, int index, boolean persisted) {
//		super.decorateView(containerView, view, element, semanticHint, index, persisted);
//		
//	}
}
