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
import org.eclipse.gmf.runtime.diagram.core.util.ViewUtil;
import org.eclipse.gmf.runtime.gef.ui.figures.NodeFigure;
import org.eclipse.gmf.runtime.notation.View;

import com.ibm.ccl.soa.deploy.core.Capability;
import com.ibm.ccl.soa.deploy.core.CorePackage;
import com.ibm.ccl.soa.deploy.core.Unit;
import com.ibm.ccl.soa.deploy.core.ui.editparts.ModuleEditPart;
import com.ibm.ccl.soa.deploy.core.util.DeployModelObjectUtil;
import com.ibm.ccl.soa.deploy.core.validator.ValidatorUtils;
import com.ibm.ccl.soa.deploy.generic.ui.figures.GenericModuleFigure;

/**
 * EditPart linking GenericUnit with GenericModuleFigure.
 * 
 * @see GenericModuleFigure
 */
public class GenericModuleEditPart extends ModuleEditPart {

	/**
	 * @param view
	 */
	public GenericModuleEditPart(View view) {
		super(view);
		// determine figure category description
		setCategory("Unit"); //$NON-NLS-1$
		Unit unit = (Unit) ViewUtil.resolveSemanticElement((View) getModel());
		if (unit != null) {
			if (unit.isConfigurationUnit()) {
				setCategory("Configuration Unit"); //$NON-NLS-1$
			}
		} else {
			// TODO temporary 4883
			setCategory("Unit"); //$NON-NLS-1$
		}

		//TODO 4883

		Capability g = ValidatorUtils.getCapability(unit, CorePackage.eINSTANCE.getCapability());
		if (g != null) {
			Object value = DeployModelObjectUtil.getAttributeValue(g, "isA"); //$NON-NLS-1$ 
			if (value != null && value instanceof String) {
				setCategory((String) value);
			}
		}

	}

	protected NodeFigure createMainFigure() {
		NodeFigure f = new GenericModuleFigure();
		f.setLayoutManager(new DelegatingLayout());
		return f;
	}
}
