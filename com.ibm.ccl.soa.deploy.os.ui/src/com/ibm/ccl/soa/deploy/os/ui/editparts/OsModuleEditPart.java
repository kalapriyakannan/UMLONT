/***************************************************************************************************
 * Copyright (c) 2003, 2007 IBM Corporation Licensed Material - Property of IBM. All rights
 * reserved.
 * 
 * US Government Users Restricted Rights - Use, duplication or disclosure v1.0 restricted by GSA ADP
 * Schedule Contract with IBM Corp.
 * 
 * Contributors: IBM Corporation - initial API and implementation
 **************************************************************************************************/
package com.ibm.ccl.soa.deploy.os.ui.editparts;

import java.util.Iterator;

import org.eclipse.draw2d.DelegatingLayout;
import org.eclipse.gmf.runtime.diagram.core.util.ViewUtil;
import org.eclipse.gmf.runtime.gef.ui.figures.NodeFigure;
import org.eclipse.gmf.runtime.notation.View;

import com.ibm.ccl.soa.deploy.core.Capability;
import com.ibm.ccl.soa.deploy.core.Unit;
import com.ibm.ccl.soa.deploy.core.ui.editparts.ModuleEditPart;
import com.ibm.ccl.soa.deploy.os.OperatingSystem;
import com.ibm.ccl.soa.deploy.os.ui.figures.OsFigureFactory;

/**
 * Holds a logical node, which is a container capable of holding deployable units.
 */
public class OsModuleEditPart extends ModuleEditPart {
	/**
	 * @param view
	 */
	public OsModuleEditPart(View view) {
		super(view);
		// determine figure category description
		Unit unit = (Unit) ViewUtil.resolveSemanticElement((View) getModel());
		if (unit == null) {
			return;
		}
		Iterator<Capability> it = unit.getCapabilities().iterator();
		OperatingSystem osCap = null;
		while (it.hasNext()) {
			Capability capability = it.next();
			if (capability instanceof OperatingSystem) {
				osCap = (OperatingSystem) capability;
				setCategory(osCap.getDisplayName());
				break;
			}
		}
	}

	@Override
	protected NodeFigure createMainFigure() {
		NodeFigure f = OsFigureFactory.createNewOsUnitFigure();
		f.setLayoutManager(new DelegatingLayout());
		return f;
	}
}
