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

import org.eclipse.draw2d.IFigure;
import org.eclipse.draw2d.geometry.Point;
import org.eclipse.draw2d.geometry.PrecisionRectangle;
import org.eclipse.gef.commands.Command;
import org.eclipse.gef.requests.ChangeBoundsRequest;
import org.eclipse.gmf.runtime.diagram.ui.editparts.GraphicalEditPart;
import org.eclipse.gmf.runtime.diagram.ui.requests.RequestConstants;

import com.ibm.ccl.soa.deploy.core.ui.editparts.DeployDiagramEditPart;
import com.ibm.ccl.soa.deploy.core.ui.figures.DragFeedbackFigure;
import com.ibm.ccl.soa.deploy.core.ui.util.GMFUtils;

/**
 * @since 1.0
 * 
 */
public class DeployDragEditPolicy extends DeployResizableEditPolicyEx {

	private IFigure feedback;

	public IFigure getFeedback() {
		return feedback;
	}

	/*
	 * draw a custom feedback figure when dragging the unit
	 */
	protected void showChangeBoundsFeedback(ChangeBoundsRequest request) {
		/*
		 * for resize
		 */
		if (!(RequestConstants.REQ_DROP.equals(request.getType()) || REQ_MOVE.equals(request
				.getType()))) {
			if (feedback == null) {
				feedback = createDragSourceFeedbackFigure();
			}
		} else {
			/*
			 * for moving
			 */
			if (feedback == null) {
				GraphicalEditPart host = (GraphicalEditPart) getHost();
				DeployDiagramEditPart ddep = GMFUtils.getDeployDiagramEditPart(getHost());
				feedback = new DragFeedbackFigure(host, false);
				addFeedback(feedback);
				ddep.getMoveFeedbackMap().put(getHost(), feedback);
				if (ddep.getPrimaryMoveFeedbackFigure() == null) {
					Point pt = request.getLocation().getCopy();
					pt.translate(request.getMoveDelta().getNegated());
					host.getFigure().translateToRelative(pt);
					if (host.getFigure().getBounds().contains(pt)) {
						ddep.setPrimaryMoveFeedbackFigure((DragFeedbackFigure) feedback);
					}
				}
			}
			if (feedback instanceof DragFeedbackFigure) {
				((DragFeedbackFigure) feedback).setPosition(request.getLocation());
			}

		}
		// for both
		PrecisionRectangle rect = new PrecisionRectangle(getInitialFeedbackBounds().getCopy());
		getHostFigure().translateToAbsolute(rect);
		rect.translate(request.getMoveDelta());
		rect.resize(request.getSizeDelta());
		feedback.translateToRelative(rect);
		feedback.setBounds(rect);

	}

	protected void eraseChangeBoundsFeedback(ChangeBoundsRequest request) {
		if (feedback != null) {
			deleteFeedback();
		}
	}

	public void deactivate() {
		if (feedback != null) {
			deleteFeedback();
		}
		super.deactivate();
	}

	private void deleteFeedback() {
		removeFeedback(feedback);
		feedback = null;
		DeployDiagramEditPart ddep = GMFUtils.getDeployDiagramEditPart(getHost());
		ddep.getMoveFeedbackMap().clear();
		ddep.setPrimaryMoveFeedbackFigure(null);
		ddep.setControlKey(false);
		ddep.setShiftKey(false);
		ddep.setAltKey(false);
	}

	/*
	 * if feedback figure determines we're moving from groups, add appropriate commands
	 * 
	 * @see org.eclipse.gef.editpolicies.NonResizableEditPolicy#getMoveCommand(org.eclipse.gef.requests.ChangeBoundsRequest)
	 */
	protected Command getMoveCommand(ChangeBoundsRequest request) {
		Command cmd = super.getMoveCommand(request);
		cmd = DragFeedbackFigure.addContainerCommands(cmd, getHost());
		return cmd;
	}

}
