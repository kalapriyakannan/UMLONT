/*******************************************************************************
 * Copyright (c) 2003, 2007 IBM Corporation Licensed Material - Property of IBM. All rights reserved.
 *  
 * US Government Users Restricted Rights - Use, duplication or disclosure v1.0 restricted by GSA ADP
 * Schedule Contract with IBM Corp.
 * 
 * Contributors: IBM Corporation - initial API and implementation
 *******************************************************************************/
package com.ibm.ccl.soa.deploy.tomcat.ui.editparts;

import java.util.Iterator;

import org.eclipse.draw2d.DelegatingLayout;
import org.eclipse.gmf.runtime.diagram.core.util.ViewUtil;
import org.eclipse.gmf.runtime.gef.ui.figures.NodeFigure;
import org.eclipse.gmf.runtime.notation.View;

import com.ibm.ccl.soa.deploy.core.Capability;
import com.ibm.ccl.soa.deploy.core.Unit;
import com.ibm.ccl.soa.deploy.core.ui.editparts.ConfigurationEditPart;
import com.ibm.ccl.soa.deploy.tomcat.Tomcat50Datasource;
import com.ibm.ccl.soa.deploy.tomcat.ui.figures.TomcatFigureFactory;

/**
 * Holds a logiocal node, which is a container capable of holding deployable units.
 */
public class TomcatDatasourceUnitEditPart extends ConfigurationEditPart {
	/**
	 * @param view
	 */
	public TomcatDatasourceUnitEditPart(View view) {
		super(view);
		// determine figure category description
		Unit unit = (Unit) ViewUtil.resolveSemanticElement((View) getModel());
		if (unit == null) {
			return;
		}
		Iterator it = unit.getCapabilities().iterator();
		while (it.hasNext()) {
			Capability capability = (Capability) it.next();
			if (capability instanceof Tomcat50Datasource) {
				setCategory("Tomcat Datasource 5.0"); //$NON-NLS-1$
				break;
			}
		}

	}

	protected NodeFigure createMainFigure() {
		NodeFigure f = TomcatFigureFactory.createNewTomcatUnitFigure();
		f.setLayoutManager(new DelegatingLayout());
		return f;
	}
}
