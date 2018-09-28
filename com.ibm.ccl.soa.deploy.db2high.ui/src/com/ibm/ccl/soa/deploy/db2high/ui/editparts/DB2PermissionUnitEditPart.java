/***************************************************************************************************
 * Copyright (c) 2003, 2007 IBM Corporation Licensed Material - Property of IBM. All rights
 * reserved.
 * 
 * US Government Users Restricted Rights - Use, duplication or disclosure v1.0 restricted by GSA ADP
 * Schedule Contract with IBM Corp.
 * 
 * Contributors: IBM Corporation - initial API and implementation
 **************************************************************************************************/
package com.ibm.ccl.soa.deploy.db2high.ui.editparts;

import org.eclipse.draw2d.DelegatingLayout;
import org.eclipse.gmf.runtime.gef.ui.figures.NodeFigure;
import org.eclipse.gmf.runtime.notation.View;

import com.ibm.ccl.soa.deploy.core.ui.editparts.UnitEditPart;
import com.ibm.ccl.soa.deploy.db2high.ui.figures.Db2highFigureFactory;

/**
 * Holds a logical node, which is a container capable of holding deployable units.
 */
public class DB2PermissionUnitEditPart extends UnitEditPart {
	/**
	 * @param view
	 */
	public DB2PermissionUnitEditPart(View view) {
		super(view);
		// determine figure category description
		// TODO replace with translatable string
		setCategory("DB2Permission"); //$NON-NLS-1$ 
	}

	@Override
	protected NodeFigure createMainFigure() {
		NodeFigure f = Db2highFigureFactory.createNewDb2highUnitFigure();
		f.setLayoutManager(new DelegatingLayout());
		return f;
	}
}
