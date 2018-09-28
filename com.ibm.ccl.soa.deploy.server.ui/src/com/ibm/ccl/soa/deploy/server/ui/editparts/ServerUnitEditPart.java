/*******************************************************************************
 * Copyright (c) 2003, 2007 IBM Corporation Licensed Material - Property of IBM. All rights reserved.
 *  
 * US Government Users Restricted Rights - Use, duplication or disclosure v1.0 restricted by GSA ADP
 * Schedule Contract with IBM Corp.
 * 
 * Contributors: IBM Corporation - initial API and implementation
 *******************************************************************************/
package com.ibm.ccl.soa.deploy.server.ui.editparts;

import org.eclipse.draw2d.DelegatingLayout;
import org.eclipse.gmf.runtime.diagram.core.util.ViewUtil;
import org.eclipse.gmf.runtime.gef.ui.figures.NodeFigure;
import org.eclipse.gmf.runtime.notation.View;

import com.ibm.ccl.soa.deploy.core.Unit;
import com.ibm.ccl.soa.deploy.core.ui.editparts.UnitEditPart;
import com.ibm.ccl.soa.deploy.core.validator.ValidatorUtils;
import com.ibm.ccl.soa.deploy.server.Server;
import com.ibm.ccl.soa.deploy.server.ServerPackage;
import com.ibm.ccl.soa.deploy.server.ServerUnit;
import com.ibm.ccl.soa.deploy.server.ui.Messages;
import com.ibm.ccl.soa.deploy.server.ui.figures.ServerFigureFactory;

/**
 * Holds a logical node, which is a container capable of holding deployable units.
 */
public class ServerUnitEditPart extends UnitEditPart {
	/**
	 * @param view
	 */
	public ServerUnitEditPart(View view) {
		super(view);
		// determine figure category description
		String _category = Messages.ServerUnitEditPart_Server;
		Unit unit = (Unit) ViewUtil.resolveSemanticElement((View) getModel());
		if (unit instanceof ServerUnit) {
			Server server = (Server) ValidatorUtils.getFirstCapability(unit, ServerPackage.eINSTANCE
					.getServer());
			if (server != null) {
				String cpuArchitecture = server.getCpuArchitecture();
				if (cpuArchitecture != null) {
					if (cpuArchitecture.equalsIgnoreCase("intel")) { //$NON-NLS-1$
						_category = Messages.ServerUnitEditPart_x86_Server;
					} else if (cpuArchitecture.equalsIgnoreCase("powerpc")) { //$NON-NLS-1$
						_category = Messages.ServerUnitEditPart_POWER_Server;
					}
				}
			}
		}
		setCategory(_category);
	}

	protected NodeFigure createMainFigure() {
		NodeFigure f = ServerFigureFactory.createNewServerUnitFigure();
		f.setLayoutManager(new DelegatingLayout());
		return f;
	}
}
