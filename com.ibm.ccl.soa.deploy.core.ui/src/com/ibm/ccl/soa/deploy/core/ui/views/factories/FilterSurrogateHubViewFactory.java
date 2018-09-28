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
import org.eclipse.gmf.runtime.diagram.ui.view.factories.AbstractShapeViewFactory;
import org.eclipse.gmf.runtime.notation.View;

import com.ibm.ccl.soa.deploy.core.ui.util.DeployCoreConstants;

/**
 * View factory for filter surrogate hub (node).
 * 
 * @author Ed Snible snible@us.ibm.com
 * @deprecated
 */
public class FilterSurrogateHubViewFactory extends AbstractShapeViewFactory {
	/**
	 * @param semanticAdapter
	 * @param containerView
	 * @param semanticHint
	 * @param index
	 * @param persisted
	 */
	public View createView(IAdaptable semanticAdapter, View containerView, String semanticHint,
			int index, boolean persisted, final PreferencesHint preferencesHint) {
		persisted = true;
		View view = super.createView(semanticAdapter, containerView,
				DeployCoreConstants.FILTERSURROGATEHUB_SEMANTICHINT, index, persisted, preferencesHint);
		return view;
	}
}
