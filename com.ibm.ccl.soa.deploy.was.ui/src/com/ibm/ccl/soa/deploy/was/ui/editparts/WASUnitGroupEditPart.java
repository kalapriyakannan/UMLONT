/*******************************************************************************
 * Copyright (c) 2003, 2007 IBM Corporation Licensed Material - Property of IBM. All rights reserved.
 *  
 * US Government Users Restricted Rights - Use, duplication or disclosure v1.0 restricted by GSA ADP
 * Schedule Contract with IBM Corp.
 * 
 * Contributors: IBM Corporation - initial API and implementation
 *******************************************************************************/
package com.ibm.ccl.soa.deploy.was.ui.editparts;

import java.util.Iterator;

import org.eclipse.draw2d.DelegatingLayout;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.gmf.runtime.diagram.core.util.ViewUtil;
import org.eclipse.gmf.runtime.gef.ui.figures.NodeFigure;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.osgi.util.NLS;

import com.ibm.ccl.soa.deploy.core.Capability;
import com.ibm.ccl.soa.deploy.core.Unit;
import com.ibm.ccl.soa.deploy.core.ui.editparts.UnitGroupEditPart;
import com.ibm.ccl.soa.deploy.was.impl.WasCellImpl;
import com.ibm.ccl.soa.deploy.was.impl.WasClusterImpl;
import com.ibm.ccl.soa.deploy.was.impl.WasNodeGroupImpl;
import com.ibm.ccl.soa.deploy.was.impl.WasSIBusImpl;
import com.ibm.ccl.soa.deploy.was.ui.figures.WASFigureFactory;

public class WASUnitGroupEditPart extends UnitGroupEditPart {

	public WASUnitGroupEditPart(View shapeView) {
		super(shapeView);
		setCategory();
	}

	protected NodeFigure createMainFigure() {
		NodeFigure f = WASFigureFactory.createNewWASUnitGroupFigure();
		f.setLayoutManager(new DelegatingLayout());
		return f;
	}

	protected void handleNotificationEvent(Notification notification) {
		super.handleNotificationEvent(notification);
		setCategory();
		refreshFigure();
	}

	private void setCategory() {
		Unit unit = (Unit) ViewUtil.resolveSemanticElement((View) getModel());
		if (unit == null || unit.getCapabilities() == null) {
			return;
		}
		Iterator it = unit.getCapabilities().iterator();
		while (it.hasNext()) {
			Capability capability = (Capability) it.next();
			if (capability instanceof WasCellImpl) {
				WasCellImpl cell = (WasCellImpl) capability;
				String wasVersion = cell.getWasVersion();
				if (wasVersion == null) {
					wasVersion = ""; //$NON-NLS-1$
				}
				setCategory(NLS.bind(WASEditPartMessages.Was_0_1_Cell, new Object[] {
						wasVersion,
						(cell.isIsDistributed() ? WASEditPartMessages.Distributed
								: WASEditPartMessages.Standalone) }));
				break;
			} else if (capability instanceof WasNodeGroupImpl) {
				setCategory(WASEditPartMessages.Was_Node_Group);
				break;

			} else if (capability instanceof WasClusterImpl) {
				WasClusterImpl wasCluster = (WasClusterImpl) capability;
				String wasVersion = wasCluster.getWasVersion();
				if (wasVersion == null) {
					wasVersion = ""; //$NON-NLS-1$
				}
				setCategory(NLS.bind(WASEditPartMessages.Was_0_Cluster, new Object[] { wasVersion }));
				break;
			} else if (capability instanceof WasSIBusImpl) {
				setCategory(WASEditPartMessages.Was_SI_Bus);
				break;
			} else {
				setCategory(WASEditPartMessages.Was_Unrecognized_Unit);
			}
		}
	}

}
