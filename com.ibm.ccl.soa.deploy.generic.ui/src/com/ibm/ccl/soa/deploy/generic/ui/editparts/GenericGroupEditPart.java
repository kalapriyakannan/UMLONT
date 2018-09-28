/***************************************************************************************************
 * Copyright (c) 2003, 2007 IBM Corporation Licensed Material - Property of IBM. All rights
 * reserved.
 * 
 * US Government Users Restricted Rights - Use, duplication or disclosure v1.0 restricted by GSA ADP
 * Schedule Contract with IBM Corp.
 * 
 * Contributors: IBM Corporation - initial API and implementation
 **************************************************************************************************/
package com.ibm.ccl.soa.deploy.generic.ui.editparts;

import org.eclipse.draw2d.DelegatingLayout;
import org.eclipse.gmf.runtime.gef.ui.figures.NodeFigure;
import org.eclipse.gmf.runtime.notation.View;

import com.ibm.ccl.soa.deploy.core.Capability;
import com.ibm.ccl.soa.deploy.core.CorePackage;
import com.ibm.ccl.soa.deploy.core.Unit;
import com.ibm.ccl.soa.deploy.core.ui.editparts.UnitGroupEditPart;
import com.ibm.ccl.soa.deploy.core.ui.figures.UnitGroupFigure;
import com.ibm.ccl.soa.deploy.core.util.DeployModelObjectUtil;
import com.ibm.ccl.soa.deploy.core.validator.ValidatorUtils;

/**
 * EditPart linking GenericUnit with UnitGroupFigure
 * 
 * @see GenericModuleEditPart
 * @see UnitGroupFigure
 */
public class GenericGroupEditPart extends UnitGroupEditPart {

	/**
	 * @param view
	 */
	public GenericGroupEditPart(View view) {
		super(view);
		// TODO 4883
		setCategory("Group"); //$NON-NLS-1$

		Unit unit = (Unit) org.eclipse.gmf.runtime.diagram.core.util.ViewUtil
				.resolveSemanticElement((View) getModel());
		Capability g = ValidatorUtils.getCapability(unit, CorePackage.eINSTANCE.getCapability());

		if (g != null) {
			Object value = DeployModelObjectUtil.getAttributeValue(g, "isA"); //$NON-NLS-1$ 
			if (value != null && value instanceof String) {
				setCategory((String) value);
			}
		}

	}

	protected NodeFigure createMainFigure() {
		UnitGroupFigure f = new UnitGroupFigure();
		f.setLayoutManager(new DelegatingLayout());
		return f;
	}
}
