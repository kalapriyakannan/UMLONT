/***************************************************************************************************
 * Copyright (c) 2003, 2007 IBM Corporation Licensed Material - Property of IBM. All rights
 * reserved.
 * 
 * US Government Users Restricted Rights - Use, duplication or disclosure v1.0 restricted by GSA ADP
 * Schedule Contract with IBM Corp.
 * 
 * Contributors: IBM Corporation - initial API and implementation
 **************************************************************************************************/
package com.ibm.ccl.soa.deploy.core.ui.editparts;

import org.eclipse.gef.EditPart;
import org.eclipse.gef.Request;
import org.eclipse.gmf.runtime.diagram.ui.editpolicies.EditPolicyRoles;
import org.eclipse.gmf.runtime.diagram.ui.requests.CreateViewAndElementRequest;
import org.eclipse.gmf.runtime.notation.View;

import com.ibm.ccl.soa.deploy.core.ui.editpolicies.HybridShapesCompartmentCanonicalEditPolicy;
import com.ibm.ccl.soa.deploy.core.ui.editpolicies.HybridShapesCreationEditPolicy;

/**
 * Holds the Groups that a unit contains.
 */
public class HybridShapesCompartmentEditPart extends DeployCoreCompartmentEditPart {
	/**
	 * @param view
	 */
	public HybridShapesCompartmentEditPart(View view) {
		super(view);
	}

	protected void createDefaultEditPolicies() {
		super.createDefaultEditPolicies();
		// update views with all config units hosted by this hostee's server
		installEditPolicy(EditPolicyRoles.CANONICAL_ROLE,
				new HybridShapesCompartmentCanonicalEditPolicy());

		// allow units to be added to this unit
		removeEditPolicy(EditPolicyRoles.CREATION_ROLE);
		installEditPolicy(EditPolicyRoles.CREATION_ROLE, new HybridShapesCreationEditPolicy());
	}

	/*
	 * if this is a create request, pass request to CollectionCreationEditPolicy which will add new
	 * unit to compartment else pass request onto parent where it might know how to handlke it
	 * (DeleteRequest, etc)
	 * 
	 * @see org.eclipse.gef.editparts.AbstractEditPart#getTargetEditPart(org.eclipse.gef.Request)
	 */
	public EditPart getTargetEditPart(Request request) {
		EditPart parent = this.getParent();
		if (request instanceof CreateViewAndElementRequest || !(parent instanceof TopologyEditPart)) {
			return super.getTargetEditPart(request);
		}
		TopologyEditPart unitEP = (TopologyEditPart) parent;
		return unitEP.getTargetEditPart(request);
	}

}
