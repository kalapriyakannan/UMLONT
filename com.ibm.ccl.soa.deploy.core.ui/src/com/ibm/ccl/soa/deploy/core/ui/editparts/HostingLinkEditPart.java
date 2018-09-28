/*******************************************************************************
 * Copyright (c) 2003, 2007 IBM Corporation Licensed Material - Property of IBM. All rights reserved.
 *  
 * US Government Users Restricted Rights - Use, duplication or disclosure v1.0 restricted by GSA ADP
 * Schedule Contract with IBM Corp.
 * 
 * Contributors: IBM Corporation - initial API and implementation
 *******************************************************************************/
package com.ibm.ccl.soa.deploy.core.ui.editparts;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

import org.eclipse.draw2d.Connection;
import org.eclipse.gef.EditPolicy;
import org.eclipse.gmf.runtime.diagram.ui.editparts.ITreeBranchEditPart;
import org.eclipse.gmf.runtime.emf.core.util.PackageUtil;
import org.eclipse.gmf.runtime.notation.NotationPackage;
import org.eclipse.gmf.runtime.notation.View;

import com.ibm.ccl.soa.deploy.core.ui.editpolicies.DeployConnectionEndpointEditPolicy;
import com.ibm.ccl.soa.deploy.core.ui.editpolicies.DeployConnectionEditPolicy;
import com.ibm.ccl.soa.deploy.core.ui.editpolicies.DeployEditPolicyRoles;
import com.ibm.ccl.soa.deploy.core.ui.editpolicies.QuickFixEditPolicy;
import com.ibm.ccl.soa.deploy.core.ui.figures.DeployCoreFigureFactory;
import com.ibm.ccl.soa.deploy.core.ui.util.DeployColorConstants;
import com.ibm.ccl.soa.deploy.core.ui.util.DeployCoreConstants;

/**
 * Implements a Connection Editpart to represnt a Wire like connection.
 * 
 */
/*
 * @canBeSeenBy com.ibm.xtools.diagram.ui.examples.logic.*
 */
public class HostingLinkEditPart extends DeployConnectionNodeEditPart implements
		PropertyChangeListener, ITreeBranchEditPart {

	/**
	 * 
	 * @param view
	 */
	public HostingLinkEditPart(View view) {
		super(view);
	}

	public void activateFigure() {
		super.activateFigure();
		/*
		 * Once the figure has been added to the ConnectionLayer, start listening for its router to
		 * change.
		 */
		getFigure().addPropertyChangeListener(Connection.PROPERTY_CONNECTION_ROUTER, this);

	}

	/**
	 * Method createConnectionFigure.
	 * 
	 * @return Connection
	 */
	protected Connection createConnectionFigure() {
		return DeployCoreFigureFactory.createNewHostingLink(this);
	}

	/**
	 * @see com.ibm.xtools.diagram.ui.editparts.ConnectionEditPart#handlePropertyChangeEvent(java.beans.PropertyChangeEvent)
	 */
	protected void handlePropertyChangeEvent(PropertyChangeEvent event) {
		super.handlePropertyChangeEvent(event);

		Object element = PackageUtil.getElement(event.getPropertyName());
		if (element != null && element.equals(NotationPackage.eINSTANCE.getIdentityAnchor_Id())) {
			anchorChange();
		}
	}

	/**
	 * Refreshes the visual aspects of this, based upon the model (Wire). It changes the wire color
	 * depending on the state of Wire.
	 * 
	 */
	protected void refreshVisuals() {
		super.refreshVisuals();

		getFigure().setForegroundColor(DeployColorConstants.hostingLinkColor);

	}

	protected void createDefaultEditPolicies() {
		super.createDefaultEditPolicies();
		installEditPolicy(EditPolicy.CONNECTION_ROLE, new DeployConnectionEditPolicy());
		installEditPolicy(EditPolicy.CONNECTION_ENDPOINTS_ROLE,
				new DeployConnectionEndpointEditPolicy());
		installEditPolicy(DeployEditPolicyRoles.QUICK_FIX_ROLE, new QuickFixEditPolicy());

	}

	public Object getAdapter(Class adapter) {
		if (adapter == String.class) {
			return DeployCoreConstants.DEPLOY_TYPE;
		}
		return super.getAdapter(adapter);
	}

} // end class HostingLinkEditPart
