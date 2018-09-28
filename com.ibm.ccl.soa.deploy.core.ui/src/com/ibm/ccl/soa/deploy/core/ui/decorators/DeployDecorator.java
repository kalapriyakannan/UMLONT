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

import java.util.Map;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.gef.GraphicalEditPart;
import org.eclipse.gmf.runtime.diagram.ui.services.decorator.AbstractDecorator;
import org.eclipse.gmf.runtime.diagram.ui.services.decorator.IDecoratorTarget;
import org.eclipse.gmf.runtime.draw2d.ui.mapmode.MapModeUtil;
import org.eclipse.gmf.runtime.notation.NotationPackage;
import org.eclipse.gmf.runtime.notation.View;

import com.ibm.ccl.soa.deploy.core.DeployModelObject;

/**
 * @since 7.0
 * 
 */
abstract public class DeployDecorator extends AbstractDecorator {

	Map visualPartMap = null;
	protected static final int Q = MapModeUtil.getMapMode().DPtoLP(1);

	/**
	 * @param decoratorTarget
	 */
	public DeployDecorator(IDecoratorTarget decoratorTarget) {
		super(decoratorTarget);
		GraphicalEditPart editpart = (GraphicalEditPart) decoratorTarget
				.getAdapter(GraphicalEditPart.class);
		visualPartMap = editpart.getViewer().getVisualPartMap();

	}

	@Override
	protected void removeDecoration() {
		// GMF does not remove decoration from visual map
		if (visualPartMap != null && getDecoration() != null) {
			visualPartMap.remove(this.getDecoration());
		}
		super.removeDecoration();
	}

	protected EObject getEObject(boolean resolve) {
		View view = (View) getDecoratorTarget().getAdapter(View.class);
		if (view == null) {
			return null;
		}
		return (EObject) view.eGet(NotationPackage.Literals.VIEW__ELEMENT, resolve);

	}

	/**
	 * =======================HELPER =======================================================
	 * 
	 * @param deployObject
	 */

	public DeployModelObject getDeployObject(boolean resolve) {
		EObject element = getEObject(resolve);
		if (!(element instanceof DeployModelObject)) {
			return null;
		}

		return (DeployModelObject) element;
	}

}
