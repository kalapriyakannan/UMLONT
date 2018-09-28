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
import org.eclipse.gmf.runtime.notation.Diagram;

import com.ibm.ccl.soa.deploy.core.ui.notation.DeployNotationFactory;

/**
 * 
 * @since 1.0
 * 
 */
public class DiagramViewFactory extends
		org.eclipse.gmf.runtime.diagram.ui.view.factories.DiagramViewFactory {

	public Diagram createDiagram(IAdaptable semanticAdapter, String diagramKind,
			PreferencesHint thePreferencesHint) {
		Diagram diagram = super.createDiagram(semanticAdapter, diagramKind, thePreferencesHint);
		diagram.getStyles().add(DeployNotationFactory.eINSTANCE.createDeployStyle());
		return diagram;
	}

}
