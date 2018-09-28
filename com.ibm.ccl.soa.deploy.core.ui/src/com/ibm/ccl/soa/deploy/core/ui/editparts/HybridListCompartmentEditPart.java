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

import org.eclipse.draw2d.IFigure;
import org.eclipse.draw2d.ToolbarLayout;
import org.eclipse.gef.EditPart;
import org.eclipse.gef.Request;
import org.eclipse.gmf.runtime.diagram.ui.editpolicies.EditPolicyRoles;
import org.eclipse.gmf.runtime.diagram.ui.requests.CreateViewAndElementRequest;
import org.eclipse.gmf.runtime.draw2d.ui.figures.ConstrainedToolbarLayout;
import org.eclipse.gmf.runtime.notation.View;

import com.ibm.ccl.soa.deploy.core.ui.editpolicies.HybridListCompartmentCanonicalEditPolicy;
import com.ibm.ccl.soa.deploy.core.ui.editpolicies.HybridListCreationEditPolicy;
import com.ibm.ccl.soa.deploy.core.ui.figures.HybridListCompartmentFigure;

/**
 * supports a root list that contains both members and hostees
 */
public class HybridListCompartmentEditPart extends DeployListCompartmentEditPart {

	/**
	 * @param view
	 */
	public HybridListCompartmentEditPart(View view) {
		super(view);
	}

	protected void createDefaultEditPolicies() {
		super.createDefaultEditPolicies();

		// update views with all config units hosted by this hostee's server
		installEditPolicy(EditPolicyRoles.CANONICAL_ROLE,
				new HybridListCompartmentCanonicalEditPolicy());

		// allow units to be added to this unit
		removeEditPolicy(EditPolicyRoles.CREATION_ROLE);
		installEditPolicy(EditPolicyRoles.CREATION_ROLE, new HybridListCreationEditPolicy());
	}

	public IFigure createFigure() {
		HybridListCompartmentFigure importListFigure = new HybridListCompartmentFigure(
				isInnerHostingList, getCompartmentName(), getMapMode());
		ConstrainedToolbarLayout layout = new ConstrainedToolbarLayout();
		layout.setStretchMajorAxis(false);
		layout.setStretchMinorAxis(false);
		layout.setMinorAlignment(ToolbarLayout.ALIGN_TOPLEFT);
		importListFigure.getContentPane().setLayoutManager(layout);

		return importListFigure;
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
		if (request instanceof CreateViewAndElementRequest
				|| !(parent instanceof BusinessComponentEditPart)) {
			return super.getTargetEditPart(request);
		}
		BusinessComponentEditPart businessComponentEP = (BusinessComponentEditPart) parent;
		return businessComponentEP.getTargetEditPart(request);
	}

}
