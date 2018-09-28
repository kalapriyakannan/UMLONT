/***************************************************************************************************
 * Copyright (c) 2003, 2007 IBM Corporation Licensed Material - Property of IBM. All rights
 * reserved.
 * 
 * US Government Users Restricted Rights - Use, duplication or disclosure v1.0 restricted by GSA ADP
 * Schedule Contract with IBM Corp.
 * 
 * Contributors: IBM Corporation - initial API and implementation
 **************************************************************************************************/
package com.ibm.ccl.soa.deploy.core.ui.editparts;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.gmf.runtime.gef.ui.figures.NodeFigure;
import org.eclipse.gmf.runtime.notation.View;

import com.ibm.ccl.soa.deploy.core.SoftwareComponent;
import com.ibm.ccl.soa.deploy.core.Unit;
import com.ibm.ccl.soa.deploy.core.ui.figures.BusinessComponentFigure;

/**
 * Holds a business component.
 */
abstract public class BusinessComponentEditPart extends TopologyEditPart {

	/**
	 * @param view
	 */
	public BusinessComponentEditPart(View view) {
		super(view);
		setCategory("Business"); //$NON-NLS-1$
	}

	public void refreshValues() {
		super.refreshValues();
		NodeFigure figure = (NodeFigure) getMainFigure();
		EObject eo = resolveSemanticElement();
		if (eo instanceof SoftwareComponent && figure instanceof BusinessComponentFigure) {
			BusinessComponentFigure fig = (BusinessComponentFigure) figure;
			setImport(fig, (Unit) eo);
		}
	}

}
