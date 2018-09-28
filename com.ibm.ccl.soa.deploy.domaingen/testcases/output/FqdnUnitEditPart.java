/***************************************************************************************************
 * Copyright (c) 2003, 2007 IBM Corporation Licensed Material - Property of IBM. All rights
 * reserved.
 * 
 * US Government Users Restricted Rights - Use, duplication or disclosure v1.0 restricted by GSA ADP
 * Schedule Contract with IBM Corp.
 * 
 * Contributors: IBM Corporation - initial API and implementation
 **************************************************************************************************/
package com.ibm.ccl.soa.deploy.cdmnet.ui.editparts;

import org.eclipse.draw2d.DelegatingLayout;
import org.eclipse.gmf.runtime.gef.ui.figures.NodeFigure;
import org.eclipse.gmf.runtime.notation.View;

import com.ibm.ccl.soa.deploy.cdmbase.ui.editparts.LogicalElementUnitEditPart;
import com.ibm.ccl.soa.deploy.cdmnet.ui.figures.CdmnetFigureFactory;

/**
 * Holds a logical node, which is a container capable of holding deployable units.
 */
public class FqdnUnitEditPart extends LogicalElementUnitEditPart {
	/**
	 * @param view
	 * @generated
	 */
	public FqdnUnitEditPart(View view) {
		super(view);
		// determine figure category description
		// TODO replace with translatable string
		setCategory("Fqdn"); //$NON-NLS-1$ 
	}

	/**
	 * @generated
	 */
	@Override	
	protected NodeFigure createMainFigure() {
		NodeFigure f = CdmnetFigureFactory.createNewCdmnetUnitFigure();
		f.setLayoutManager(new DelegatingLayout());
		return f;
	}
	
	private void test() {
		
	}
}
