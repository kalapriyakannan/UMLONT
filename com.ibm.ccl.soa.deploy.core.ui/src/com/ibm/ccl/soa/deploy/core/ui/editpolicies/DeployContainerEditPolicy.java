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
import java.util.List;

import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.gef.commands.Command;
import org.eclipse.gmf.runtime.common.core.command.CommandResult;
import org.eclipse.gmf.runtime.diagram.ui.actions.ActionIds;
import org.eclipse.gmf.runtime.diagram.ui.commands.ICommandProxy;
import org.eclipse.gmf.runtime.diagram.ui.editparts.GraphicalEditPart;
import org.eclipse.gmf.runtime.diagram.ui.editparts.IGraphicalEditPart;
import org.eclipse.gmf.runtime.diagram.ui.editpolicies.ContainerEditPolicy;
import org.eclipse.gmf.runtime.diagram.ui.requests.ArrangeRequest;
import org.eclipse.gmf.runtime.diagram.ui.requests.PasteViewRequest;
import org.eclipse.gmf.runtime.diagram.ui.requests.RequestConstants;

import com.ibm.ccl.soa.deploy.core.ui.editparts.DeployDiagramEditPart;
import com.ibm.ccl.soa.deploy.core.ui.internal.commands.DeployDeferredLayoutCommand;
import com.ibm.ccl.soa.deploy.core.ui.internal.commands.DeployPasteCommand;
import com.ibm.ccl.soa.deploy.core.ui.internal.commands.DeployTransactionalCommand;
import com.ibm.ccl.soa.deploy.core.ui.util.ArrangeUtils;
import com.ibm.ccl.soa.deploy.core.ui.util.GMFUtils;
import com.ibm.ccl.soa.deploy.core.ui.util.SelectionUtils;

/**
 * @author jswanke
 * 
 */
public class DeployContainerEditPolicy extends ContainerEditPolicy {

	protected Command getArrangeCommand(ArrangeRequest request) {

		if (RequestConstants.REQ_ARRANGE_DEFERRED.equals(request.getType())) {
			TransactionalEditingDomain editingDomain = ((IGraphicalEditPart) getHost())
					.getEditingDomain();
			return new ICommandProxy(new DeployDeferredLayoutCommand(editingDomain, request
					.getViewAdaptersToArrange(), (IGraphicalEditPart) getHost(), null, null, false,
					false));
		}

		boolean isSelectionArrange = false;
		List<GraphicalEditPart> editparts = new ArrayList<GraphicalEditPart>();
		final DeployDiagramEditPart ddep = GMFUtils.getDeployDiagramEditPart(getHost());

		if (ActionIds.ACTION_ARRANGE_ALL.equals(request.getType())
				|| ActionIds.ACTION_TOOLBAR_ARRANGE_ALL.equals(request.getType())) {
			// only perfrom an arrange all on the diagram
			editparts = ddep.getChildren();
		}
		if (ActionIds.ACTION_ARRANGE_SELECTION.equals(request.getType())
				|| ActionIds.ACTION_TOOLBAR_ARRANGE_SELECTION.equals(request.getType())) {
			editparts = request.getPartsToArrange();
			isSelectionArrange = true;
		}

		if (editparts.isEmpty()) {
			return null;
		}

		final List<GraphicalEditPart> editpartz = editparts;
		final boolean isSelection = isSelectionArrange;
		return new ICommandProxy(new DeployTransactionalCommand((IGraphicalEditPart) getHost(),
				"", null, true) { //$NON-NLS-1$
					protected CommandResult doExecuteWithResult(IProgressMonitor progressMonitor,
							IAdaptable info) throws ExecutionException {
						// make sure canvas is unfaded
						SelectionUtils.unfadeFigures();
						ArrangeUtils.arrangeEditParts(editpartz, null, isSelection, false);
						return CommandResult.newOKCommandResult();
					}
				});
	}

	/**
	 * Returns a command to paste the views
	 * 
	 * @param request
	 *           The PasteViewRequest
	 * @return Command the command to execute
	 */
	protected Command getPasteCommand(PasteViewRequest request) {
		GraphicalEditPart ep = (GraphicalEditPart) getHost();
		DeployDiagramEditPart ddep = GMFUtils.getDeployDiagramEditPart(getHost());
		return new ICommandProxy(new DeployPasteCommand(ep.getEditingDomain(), ddep, ep
				.getNotationView()));
	}
}
