/***************************************************************************************************
 * Copyright (c) 2003, 2007 IBM Corporation Licensed Material - Property of IBM. All rights
 * reserved.
 * 
 * US Government Users Restricted Rights - Use, duplication or disclosure v1.0 restricted by GSA ADP
 * Schedule Contract with IBM Corp.
 * 
 * Contributors: IBM Corporation - initial API and implementation
 **************************************************************************************************/
package com.ibm.ccl.soa.deploy.db2.ui.editparts;

import java.util.Iterator;

import org.eclipse.draw2d.DelegatingLayout;
import org.eclipse.gmf.runtime.diagram.core.util.ViewUtil;
import org.eclipse.gmf.runtime.gef.ui.figures.NodeFigure;
import org.eclipse.gmf.runtime.notation.View;

import com.ibm.ccl.soa.deploy.core.Capability;
import com.ibm.ccl.soa.deploy.core.Unit;
import com.ibm.ccl.soa.deploy.core.ui.editparts.ConfigurationEditPart;
import com.ibm.ccl.soa.deploy.db2.DB2CatalogedNode;
import com.ibm.ccl.soa.deploy.db2.ui.figures.DB2FigureFactory;

/**
 * Holds a logical node, which is a container capable of holding deployable units.
 */
public class DB2ConfigurationUnitEditPart extends ConfigurationEditPart {
	/**
	 * @param view
	 */
	public DB2ConfigurationUnitEditPart(View view) {
		super(view);
		setCategory(DB2EditPartMessages.DB2_Database_Catalog);
		Unit unit = (Unit) ViewUtil.resolveSemanticElement((View) getModel());
		if (unit == null) {
			return;
		}
		Iterator<Capability> it = unit.getCapabilities().iterator();
		while (it.hasNext()) {
			Capability capability = it.next();
			if (capability instanceof DB2CatalogedNode) {
				setCategory(DB2EditPartMessages.DB2_Node_Catalog);
				break;
			}
		}

	}

	@Override
	protected NodeFigure createMainFigure() {
		NodeFigure f = DB2FigureFactory.createNewDB2UnitFigure();
		f.setLayoutManager(new DelegatingLayout());
		return f;
	}
}
