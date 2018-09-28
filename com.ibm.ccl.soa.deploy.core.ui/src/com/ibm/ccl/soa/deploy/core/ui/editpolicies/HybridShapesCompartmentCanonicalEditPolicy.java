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

import java.util.Collections;
import java.util.List;

import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.gef.commands.Command;
import org.eclipse.gef.requests.CreateRequest;

import com.ibm.ccl.soa.deploy.core.Unit;
import com.ibm.ccl.soa.deploy.core.ui.util.ArrangeUtils;

/**
 * @since 1.0
 * 
 * This canonical edit policy is installed on the DiagramEditPart ensuring that all the Unit
 * contained by the Topology is visualized on the Diagram.
 * 
 * Note: Once we move to multiple diagram paradigm, we will have to remove else all diagrams will be
 * identical in terms of their contents.
 */
public class HybridShapesCompartmentCanonicalEditPolicy extends DeployCanonicalEditPolicy {
	/**
	 * 
	 */
	public HybridShapesCompartmentCanonicalEditPolicy() {
		super();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.gmf.runtime.diagram.ui.editpolicies.CanonicalEditPolicy#getSemanticChildrenList()
	 */
	protected List getSemanticChildrenList() {
		EObject eObject = resolveSemanticElement();
		if (eObject instanceof Unit) {
			Unit unit = (Unit) eObject;

			// Check for cycle: don't show children in that case
			if (hasEditPartCycle(unit, host())) {
				return Collections.EMPTY_LIST;
			}

			return getSemanticChildrenListHelper(unit, null);
		}

		return Collections.EMPTY_LIST;
	}

	protected Command getCreateViewCommand(CreateRequest request) {
		Command cmd = getCreateViewCommandRestricted(request);
		return cmd == null ? cmd : ArrangeUtils.gridLayout(cmd, request, getHost());
	}

	protected String getFactoryHint(IAdaptable elementAdapter, String defaultHint) {
		return null;
	}
}
