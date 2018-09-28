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
import org.eclipse.gmf.runtime.notation.NotationPackage;
import org.eclipse.gmf.runtime.notation.View;

import com.ibm.ccl.soa.deploy.core.ui.notation.DeployNotationFactory;
import com.ibm.ccl.soa.deploy.core.ui.util.DeployCoreConstants;

/**
 * 
 * @since 1.0
 * 
 */
public class ListContainerViewFactory extends AbstractShapeViewFactory {
	public View createView(IAdaptable semanticAdapter, View containerView, String semanticHint,
			int index, boolean persisted, PreferencesHint preferencesHint) {
		//NOTE: We are overwriting thsis persisted flag to true because we always want to persist the unit views. Because
		//we have installed UnitCanonicalEditPolicy on the DeployDiagramEditPArt, sometimes after quick fixes, units get added
		//view this canonical editpolicy and is made transient. We do not want unit views to be transient.
		View view = super.createView(semanticAdapter, containerView, semanticHint, index, true,
				preferencesHint);
		view.getStyles().add(DeployNotationFactory.eINSTANCE.createDeployStyle());
		return view;
	}

	/*
	 * typically views are created for each semantic EObject, (the view provider determines which
	 * view to create) then an editpart is created for that view (the editpart provider determines
	 * which ep to create) then a figure is created by that editpart (the editpart creates the figure
	 * class) however to display internal EObjects of an EObject, you: 1) append views to the view of
	 * the parent EObject here in the decorateView method 2) have that view create an editpart that:
	 * a) if its the EObject's name, just sucks out the EObject's name else (see
	 * NameCompartmentEditPart) b) if its an EObject's children List, defines a Canonical editpolicy
	 * that sucks out a list of of those Eobjects which in turn will create views, editparts and
	 * figures as before
	 * 
	 * @see org.eclipse.gmf.runtime.diagram.ui.view.factories.BasicNodeViewFactory#decorateView(org.eclipse.gmf.runtime.notation.View,
	 *      org.eclipse.gmf.runtime.notation.View, org.eclipse.core.runtime.IAdaptable,
	 *      java.lang.String, int, boolean)
	 */
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

		// append a view that will create a list area
		getViewService().createNode(semanticAdapter, view,
				DeployCoreConstants.HYBRIDLIST_SEMANTICHINT, ViewUtil.APPEND, persisted,
				getPreferencesHint());
	}
}
