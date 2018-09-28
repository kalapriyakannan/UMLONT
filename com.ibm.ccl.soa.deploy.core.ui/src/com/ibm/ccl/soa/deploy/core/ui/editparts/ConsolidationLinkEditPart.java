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

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.eclipse.draw2d.Connection;
import org.eclipse.gef.EditPart;
import org.eclipse.gef.EditPolicy;
import org.eclipse.gef.Request;
import org.eclipse.gef.commands.Command;
import org.eclipse.gmf.runtime.notation.Edge;
import org.eclipse.gmf.runtime.notation.View;

import com.ibm.ccl.soa.deploy.core.ui.editpolicies.DeployConnectionEndpointEditPolicy;
import com.ibm.ccl.soa.deploy.core.ui.editpolicies.DeployEditPolicyRoles;
import com.ibm.ccl.soa.deploy.core.ui.editpolicies.QuickFixEditPolicy;
import com.ibm.ccl.soa.deploy.core.ui.figures.ConsolidationLinkConnection;
import com.ibm.ccl.soa.deploy.core.ui.figures.DeployCoreFigureFactory;
import com.ibm.ccl.soa.deploy.core.ui.figures.DeployLinkConnection;
import com.ibm.ccl.soa.deploy.core.ui.util.DeployColorConstants;
import com.ibm.ccl.soa.deploy.core.ui.util.DeployCoreConstants;
import com.ibm.ccl.soa.deploy.core.ui.util.GMFUtils;
import com.ibm.ccl.soa.deploy.core.ui.util.ConsolidationLinkUtils.ConsolidatedLinkData;

/**
 * Implements a ConnectionEditPart to represent a wire-like connection.
 * 
 * @author jswanke
 * @see ConsolidationLinkConnection
 */
public class ConsolidationLinkEditPart extends DeployConnectionNodeEditPart {

	/**
	 * should deleting this link also delete inner links
	 */
	public static final String IGNORE_INNER_LINKS = "ignoreInnerLinks"; //$NON-NLS-1$
	private final List<DeployConnectionNodeEditPart> _consolidatedLinkList = new ArrayList<DeployConnectionNodeEditPart>();

	/**
	 * 
	 * @param view
	 */
	public ConsolidationLinkEditPart(View view) {
		super(view);
	}

	@Override
	public void activate() {
		refreshLinks();
		super.activate();
	}

	@Override
	public void refresh() {
		refreshLinks();
		super.refresh();
	}

	@Override
	public void setSource(EditPart editPart) {
		// consolidated link endpoints are only set once
		if (getSource() != null) {
			getFigure().setVisible(false);
		}
		super.setSource(editPart);
	}

	@Override
	public void setTarget(EditPart editPart) {
		// consolidated link endpoints are only set once
		if (getTarget() != null) {
			getFigure().setVisible(false);
		}
		super.setTarget(editPart);
	}

	private void refreshLinks() {
		_consolidatedLinkList.clear();
		// determine the links this link consolidates
		DeployDiagramEditPart ddep = GMFUtils.getDeployDiagramEditPart(getViewer().getRootEditPart());
		Edge edge = (Edge) this.getNotationView();
		for (Iterator<ConsolidatedLinkData> it = ddep.getConsolidatedLinkDataList().iterator(); it
				.hasNext();) {
			ConsolidatedLinkData linkData = it.next();
			if (edge == linkData.getConsolidatedLink()) {
				for (Iterator<DeployLinkConnection> it2 = linkData.getLinks().iterator(); it2.hasNext();) {
					_consolidatedLinkList.add((DeployConnectionNodeEditPart) it2.next()
							.getConnectionEP());
				}
			}
		}
	}

	public Command getCommand(Request request) {
		if (GMFUtils.isDeleteRequest(request)) {
			// get the command
			Command cmd = super.getCommand(request);

			// add deletes for contained link eps
			if (!request.getExtendedData().containsKey(IGNORE_INNER_LINKS)) {
				for (Iterator<DeployConnectionNodeEditPart> it = _consolidatedLinkList.iterator(); it
						.hasNext();) {
					cmd = cmd.chain(it.next().getCommand(request));
				}
			}
			return cmd;
		}
		return super.getCommand(request);
	}

	/**
	 * Method createConnectionFigure.
	 * 
	 * @return Connection
	 */
	protected Connection createConnectionFigure() {
		return DeployCoreFigureFactory.createNewConsolidationLink(this);
	}

	/**
	 * Refreshes the visual aspects of this, based upon the model (Wire). It changes the wire color
	 * depending on the state of Wire.
	 * 
	 */
	protected void refreshVisuals() {
		super.refreshVisuals();
		getFigure().setForegroundColor(DeployColorConstants.consolidationLinkColor);
	}

	protected void createDefaultEditPolicies() {
		super.createDefaultEditPolicies();
		installEditPolicy(EditPolicy.CONNECTION_ENDPOINTS_ROLE,
				new DeployConnectionEndpointEditPolicy());
		installEditPolicy(DeployEditPolicyRoles.QUICK_FIX_ROLE, new QuickFixEditPolicy());

	}

	// never filter me
	@Override
	public void filterConnections() {
	}

	public Object getAdapter(Class adapter) {
		if (adapter == String.class) {
			return DeployCoreConstants.DEPLOY_TYPE;
		}
		return super.getAdapter(adapter);
	}

	/**
	 * @return the link edit parts this consolidation link consolidates
	 */
	public List<DeployConnectionNodeEditPart> getConsolidatedLinkList() {
		return _consolidatedLinkList;
	}
}
