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

import java.util.Iterator;

import org.eclipse.gmf.runtime.diagram.ui.services.decorator.IDecoratorTarget;
import org.eclipse.gmf.runtime.notation.View;

import com.ibm.ccl.soa.deploy.core.ui.providers.DeployDecoratorProvider;
import com.ibm.ccl.soa.deploy.core.ui.util.DeployCoreConstants;

/**
 * @see DeployDecoratorProvider
 */
public class HybridShapesCollapseButtonDecorator extends ShapesCollapseButtonDecorator {

	/**
	 * @param decoratorTarget
	 */
	public HybridShapesCollapseButtonDecorator(IDecoratorTarget decoratorTarget) {
		super(decoratorTarget);
	}

	protected View getCompartmentView() {
		// look for the list compartment
		View view = (View) getDecoratorTarget().getAdapter(View.class);
		Iterator it = view.getPersistedChildren().iterator();
		while (it.hasNext()) {
			View child = (View) it.next();
			if (child.getType().equals(DeployCoreConstants.HYBRIDSHAPES_SEMANTICHINT)) {
				return child;
			}
		}
		return null;
	}
}
