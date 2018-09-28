/***************************************************************************************************
 * Copyright (c) 2003, 2008 IBM Corporation Licensed Material - Property of IBM. All rights
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
import org.eclipse.gmf.runtime.diagram.ui.view.factories.AbstractShapeViewFactory;
import org.eclipse.gmf.runtime.notation.View;

import com.ibm.ccl.soa.deploy.core.ui.notation.DeployNotationFactory;

/**
 * SnapViewFactory creates either a snap row or a snap group
 * 
 * @since 1.0
 * 
 */
public class SnapViewFactory extends AbstractShapeViewFactory {
	public View createView(IAdaptable semanticAdapter, View containerView, String semanticHint,
			int index, boolean persisted, PreferencesHint preferencesHint) {
		View view = super.createView(semanticAdapter, containerView, semanticHint, index, true,
				preferencesHint);
		view.getStyles().add(DeployNotationFactory.eINSTANCE.createDeployStyle());
		return view;
	}
}
