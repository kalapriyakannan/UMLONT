/*******************************************************************************
 * Copyright (c) 2003, 2007 IBM Corporation Licensed Material - Property of IBM. All rights reserved.
 *  
 * US Government Users Restricted Rights - Use, duplication or disclosure v1.0 restricted by GSA ADP
 * Schedule Contract with IBM Corp.
 * 
 * Contributors: IBM Corporation - initial API and implementation
 *******************************************************************************/
package com.ibm.ccl.soa.deploy.derby.ui.editparts;

import java.util.Iterator;

import org.eclipse.draw2d.DelegatingLayout;
import org.eclipse.gmf.runtime.diagram.core.util.ViewUtil;
import org.eclipse.gmf.runtime.gef.ui.figures.NodeFigure;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.osgi.util.NLS;

import com.ibm.ccl.soa.deploy.core.Capability;
import com.ibm.ccl.soa.deploy.core.Unit;
import com.ibm.ccl.soa.deploy.core.ui.editparts.ModuleEditPart;
import com.ibm.ccl.soa.deploy.derby.ui.figures.DerbyFigureFactory;
import com.ibm.ccl.soa.deploy.internal.derby.DerbyDatabase;
import com.ibm.ccl.soa.deploy.internal.derby.DerbyInstance;
import com.ibm.ccl.soa.deploy.derby.ui.Messages;

/**
 * Holds a logiocal node, which is a container capable of holding deployable units.
 */
public class DerbyModuleEditPart extends ModuleEditPart {
	/**
	 * @param view
	 */
	public DerbyModuleEditPart(View view) {
		super(view);
		// determine figure category description
		Unit unit = (Unit) ViewUtil.resolveSemanticElement((View) getModel());
		Iterator it = unit.getCapabilities().iterator();
		while (it.hasNext()) {
			Capability capability = (Capability) it.next();
			if (capability instanceof DerbyDatabase) {
				DerbyDatabase db = (DerbyDatabase) capability;
				setCategory(NLS.bind(Messages.DerbyModuleEditPart_Derby_Database_0_, db
						.getDerbyVersion()));
				break;
			} else if (capability instanceof DerbyInstance) {
				setCategory(Messages.DerbyModuleEditPart_Derby_Instance);
				break;
			}
		}

	}

	protected NodeFigure createMainFigure() {
		NodeFigure f = DerbyFigureFactory.createNewDerbyUnitFigure();
		f.setLayoutManager(new DelegatingLayout());
		return f;
	}
}
