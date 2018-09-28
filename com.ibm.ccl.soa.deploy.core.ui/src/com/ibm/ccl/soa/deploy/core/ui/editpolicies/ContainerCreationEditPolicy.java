/***************************************************************************************************
 * Copyright (c) 2003, 2007 IBM Corporation Licensed Material - Property of IBM. All rights
 * reserved.
 * 
 * US Government Users Restricted Rights - Use, duplication or disclosure v1.0 restricted by GSA ADP
 * Schedule Contract with IBM Corp.
 * 
 * Contributors: IBM Corporation - initial API and implementation
 **************************************************************************************************/

package com.ibm.ccl.soa.deploy.core.ui.editpolicies;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.eclipse.gef.EditPart;
import org.eclipse.gef.commands.Command;
import org.eclipse.gmf.runtime.diagram.ui.editparts.DiagramEditPart;
import org.eclipse.gmf.runtime.diagram.ui.editparts.GraphicalEditPart;
import org.eclipse.gmf.runtime.diagram.ui.editparts.IGraphicalEditPart;
import org.eclipse.gmf.runtime.diagram.ui.editpolicies.CreationEditPolicy;
import org.eclipse.gmf.runtime.diagram.ui.requests.CreateViewAndElementRequest;

import com.ibm.ccl.soa.deploy.core.ui.util.DeployCoreConstants;

/**
 */
public class ContainerCreationEditPolicy extends CreationEditPolicy {

	protected Command getCreateElementAndViewCommand(CreateViewAndElementRequest req) {
		GraphicalEditPart host = (GraphicalEditPart) getHost();
		IGraphicalEditPart groupAreaEP = host
				.getChildBySemanticHint(DeployCoreConstants.HYBRIDSHAPES_SEMANTICHINT);
		IGraphicalEditPart hostListEP = host
				.getChildBySemanticHint(DeployCoreConstants.HYBRIDLIST_SEMANTICHINT);

		// trying to create configUnit in group
		String semanticHint = req.getViewAndElementDescriptor().getSemanticHint();
		if (semanticHint != null
				&& semanticHint.startsWith(DeployCoreConstants.CONFIGURATION_SEMANTICHINT_PREFIX)) {
			if (hostListEP != null) {
				Command createCmd = hostListEP.getCommand(req);
				if (createCmd != null) {
					return createCmd;
				}
			}
		}

		// trying to create member in group
		if (groupAreaEP != null) {
			Command createGroupCmd = groupAreaEP.getCommand(req);
			if (createGroupCmd != null) {
				return createGroupCmd;
			}
		}

		return super.getCreateElementAndViewCommand(req);
	}

	private Collection getDiagramEditPartList() {
		List list = new ArrayList();
		EditPart ep = getHost();
		while (!(ep instanceof DiagramEditPart)) {
			ep = ep.getParent();
			if (ep == null) {
				list.add(getHost());
				return list;
			}
		}
		list.add(ep);
		return list;
	}

}
