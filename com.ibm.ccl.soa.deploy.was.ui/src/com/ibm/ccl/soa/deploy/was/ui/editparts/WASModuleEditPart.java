/***************************************************************************************************
 * Copyright (c) 2003, 2007 IBM Corporation Licensed Material - Property of IBM. All rights
 * reserved.
 * 
 * US Government Users Restricted Rights - Use, duplication or disclosure v1.0 restricted by GSA ADP
 * Schedule Contract with IBM Corp.
 * 
 * Contributors: IBM Corporation - initial API and implementation
 **************************************************************************************************/
package com.ibm.ccl.soa.deploy.was.ui.editparts;

import java.util.List;

import org.eclipse.draw2d.DelegatingLayout;
import org.eclipse.gmf.runtime.diagram.core.util.ViewUtil;
import org.eclipse.gmf.runtime.gef.ui.figures.NodeFigure;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.osgi.util.NLS;

import com.ibm.ccl.soa.deploy.core.Capability;
import com.ibm.ccl.soa.deploy.core.Unit;
import com.ibm.ccl.soa.deploy.core.ui.editparts.ModuleEditPart;
import com.ibm.ccl.soa.deploy.was.WasDeploymentManager;
import com.ibm.ccl.soa.deploy.was.WasEditionEnum;
import com.ibm.ccl.soa.deploy.was.WasNode;
import com.ibm.ccl.soa.deploy.was.WasProfileTypeEnum;
import com.ibm.ccl.soa.deploy.was.WasServer;
import com.ibm.ccl.soa.deploy.was.WasSystem;
import com.ibm.ccl.soa.deploy.was.WasWebServer;
import com.ibm.ccl.soa.deploy.was.ui.figures.WASFigureFactory;

/**
 * Holds a logiocal node, which is a container capable of holding deployable units.
 */
public class WASModuleEditPart extends ModuleEditPart {
	/**
	 * @param view
	 */
	public WASModuleEditPart(View view) {
		super(view);
		// determine figure category description
		Unit unit = (Unit) ViewUtil.resolveSemanticElement((View) getModel());
		if (unit == null) {
			return;
		}
		List capabilities = unit.getCapabilities();
		for (int i = 0; i < capabilities.size(); i++) {
			Capability capability = (Capability) capabilities.get(i);
			if (capability instanceof WasServer) {
				WasServer server = (WasServer) capability;
				String wasVersion = server.getWasVersion();
				if (wasVersion == null) {
					wasVersion = ""; //$NON-NLS-1$
				}
				setCategory(NLS.bind(WASEditPartMessages.Was_0_AppServer, new Object[] { wasVersion }));
				break;
			} else if (capability instanceof WasSystem) {
				WasSystem system = (WasSystem) capability;
				String wasVersion = system.getWasVersion();
				if (wasVersion == null) {
					wasVersion = ""; //$NON-NLS-1$
				}
				WasEditionEnum wasEdition = system.getWasEdition();
				setCategory(NLS.bind(WASEditPartMessages.Was_0_1_System, new Object[] { wasVersion,
						wasEdition }));
				break;
			} else if (capability instanceof WasDeploymentManager) {
				WasDeploymentManager dmgr = (WasDeploymentManager) capability;
				setCategory(dmgr.getDisplayName() != null ? dmgr.getDisplayName()
						: WASEditPartMessages.Was_Deployment_Manager);

				break;
			} else if (capability instanceof WasNode) {
				WasNode wasNode = (WasNode) capability;
				String type = WASEditPartMessages.Node_Type;
				if (wasNode.getProfileType() == WasProfileTypeEnum.DEFAULT_LITERAL) {
				} else if (wasNode.getProfileType() == WasProfileTypeEnum.NONE_LITERAL) {
					type = WASEditPartMessages.Web_Type;
				} else {
					type = wasNode.getProfileType().getName() + ' ' + type;
				}
				String wasVersion = wasNode.getWasVersion();
				if (wasVersion == null) {
					wasVersion = ""; //$NON-NLS-1$
				}
				setCategory(NLS.bind(WASEditPartMessages.Was_0_1_Node,
						new Object[] { wasVersion, type }));
				break;
			} else if (capability instanceof WasWebServer) {
				setCategory(WASEditPartMessages.Was_Web_Server);
				break;
			} else {
				setCategory(WASEditPartMessages.Was_Unrecognized_Unit);
			}
		}

	}

	protected NodeFigure createMainFigure() {
		NodeFigure f = WASFigureFactory.createNewWASUnitFigure();
		f.setLayoutManager(new DelegatingLayout());
		return f;
	}
}
