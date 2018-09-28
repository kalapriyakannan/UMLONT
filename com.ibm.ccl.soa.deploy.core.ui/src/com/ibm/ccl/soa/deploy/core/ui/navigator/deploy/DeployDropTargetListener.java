/***************************************************************************************************
 * Copyright (c) 2003, 2008 IBM Corporation Licensed Material - Property of IBM. All rights
 * reserved.
 * 
 * US Government Users Restricted Rights - Use, duplication or disclosure v1.0 restricted by GSA ADP
 * Schedule Contract with IBM Corp.
 * 
 * Contributors: IBM Corporation - initial API and implementation
 **************************************************************************************************/
package com.ibm.ccl.soa.deploy.core.ui.navigator.deploy;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.eclipse.core.resources.IFile;
import org.eclipse.draw2d.IFigure;
import org.eclipse.draw2d.geometry.Dimension;
import org.eclipse.draw2d.geometry.Point;
import org.eclipse.draw2d.geometry.Rectangle;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.gef.EditPart;
import org.eclipse.gef.EditPartViewer;
import org.eclipse.gef.LayerConstants;
import org.eclipse.gef.Request;
import org.eclipse.gef.editparts.LayerManager;
import org.eclipse.gmf.runtime.diagram.core.util.ViewUtil;
import org.eclipse.gmf.runtime.diagram.ui.editparts.GraphicalEditPart;
import org.eclipse.gmf.runtime.diagram.ui.editparts.IGraphicalEditPart;
import org.eclipse.gmf.runtime.diagram.ui.parts.DiagramDropTargetListener;
import org.eclipse.gmf.runtime.diagram.ui.requests.DropObjectsRequest;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.jface.util.LocalSelectionTransfer;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.osgi.util.NLS;
import org.eclipse.swt.SWTException;
import org.eclipse.swt.dnd.TransferData;
import org.eclipse.swt.graphics.Color;
import org.eclipse.swt.graphics.Image;

import com.ibm.ccl.soa.deploy.core.Unit;
import com.ibm.ccl.soa.deploy.core.ui.Messages;
import com.ibm.ccl.soa.deploy.core.ui.editparts.DeployDiagramEditPart;
import com.ibm.ccl.soa.deploy.core.ui.editparts.DeployShapeNodeEditPart;
import com.ibm.ccl.soa.deploy.core.ui.editparts.HybridListCompartmentEditPart;
import com.ibm.ccl.soa.deploy.core.ui.editparts.HybridShapesCompartmentEditPart;
import com.ibm.ccl.soa.deploy.core.ui.editparts.ImportListCompartmentEditPart;
import com.ibm.ccl.soa.deploy.core.ui.editparts.ImportTopologyEditPart;
import com.ibm.ccl.soa.deploy.core.ui.figures.common.CreationFeedbackFigure;
import com.ibm.ccl.soa.deploy.core.ui.internal.commands.AddToTopologyCommand;
import com.ibm.ccl.soa.deploy.core.ui.tools.DeployShapeCreationTool;
import com.ibm.ccl.soa.deploy.core.ui.util.DeployCoreConstants;
import com.ibm.ccl.soa.deploy.core.ui.util.GMFUtils;

/**
 * @since 7.0
 * 
 */
public class DeployDropTargetListener extends DiagramDropTargetListener {
	private static Color bg = new Color(null, 0, 0, 0);
	private static Color fg = new Color(null, 255, 255, 255);

	static private float XOFFSET = .50f;
	static private float YOFFSET = .50f;

	private CreationFeedbackFigure feedbackFigure = null;
	private Point lastPt = null;
	private org.eclipse.draw2d.geometry.Point feedbackPt = null;
	private IGraphicalEditPart _targetEP = null;
	private final boolean[] validTarget = new boolean[1];

	/**
	 * @param viewer
	 */
	public DeployDropTargetListener(EditPartViewer viewer) {
		super(viewer, LocalSelectionTransfer.getTransfer());
	}

	protected List getObjectsBeingDropped() {
		/* Get the selection from the transfer agent */
		TransferData[] data = getCurrentEvent().dataTypes;
		List list = new ArrayList();

		for (int i = 0; i < data.length; i++) {

			if (LocalSelectionTransfer.getTransfer().isSupportedType(data[i])) {
				// FileTransfers from the PE are supported, but an 
				// SWT exception is thrown when using nativeToJava call.
				try {
					Object selection = LocalSelectionTransfer.getTransfer().nativeToJava(data[i]);
					if (selection instanceof IStructuredSelection) {
						IStructuredSelection structuredSelection = (IStructuredSelection) selection;
						list.addAll(structuredSelection.toList());
						break;

					}
				} catch (SWTException e) {
					return null;
				}

			}
		}

		if (list.size() > 0) {
			return list;
		}

		return null;
	}

	@Override
	protected void handleDragOver() {
		DeployDiagramEditPart ddep = GMFUtils.getDeployDiagramEditPart(getViewer().getRootEditPart());
		if (ddep != null) {
			org.eclipse.swt.graphics.Point pt = getViewer().getControl().toControl(
					getCurrentEvent().x, getCurrentEvent().y);
			createFeedback(new Point(pt), getObjectsBeingDropped());
		}
		super.handleDragOver();
	}

	@Override
	protected void eraseTargetFeedback() {
		if (feedbackFigure != null) {
			removeFeedback(feedbackFigure);
			feedbackFigure = null;
			lastPt = null;
		}
		super.eraseTargetFeedback();
	}

	@Override
	protected void handleDrop() {
		List<?> objects = getObjectsBeingDropped();
		if ((objects.size() > 1 || !AddToTopologyCommand.containsAnyUnit(_targetEP, objects))
				&& validTarget[0]) {
			super.handleDrop();
		}
	}

	@Override
	protected Request getTargetRequest() {
		Request request = super.getTargetRequest();
		if (request instanceof DropObjectsRequest) {
			DropObjectsRequest req = (DropObjectsRequest) request;
			if (feedbackPt != null) {
				req.setLocation(feedbackPt);
				req.getExtendedData().put(AddToTopologyCommand.TARGETEP, _targetEP);
			}
		}
		return request;

	}

	private void createFeedback(Point location, List<?> objects) {
		if (feedbackFigure == null) {
			Image image = null;
			String name = ""; //$NON-NLS-1$
			Object object = objects.get(0);
			if (object instanceof IFile) {
				name = ((IFile) object).getName();
			} else if (object instanceof EObject) {
				name = GMFUtils.getDmoName((EObject) object);
			} else if (object instanceof TopologyDiagramNode) {
				name = ((TopologyDiagramNode) object).getText();
			} else {
				name = Messages.DeployDropTargetListener_UML_Model_Elemen_;
			}
			feedbackFigure = new CreationFeedbackFigure(getViewer().getContents(), XOFFSET, YOFFSET,
					image, new Dimension(16, 16), name, true, false, false);
			addFeedback(feedbackFigure);
		}
		if (location.equals(lastPt)) {
			return;
		}
		lastPt = location.getCopy();

		// preset transitory feedback figure parameters
		Rectangle feedbackBounds = new Rectangle(0, 0, 125, 18);
		feedbackBounds.setLocation(location);
		feedbackFigure.presetFeedbackParameters(feedbackBounds, fg, bg);

		// find the target EditPart
		_targetEP = getTargetEditPart(getViewer(), location);
		if (_targetEP instanceof DeployShapeNodeEditPart) {
			IGraphicalEditPart ep = _targetEP
					.getChildBySemanticHint(DeployCoreConstants.HYBRIDLIST_SEMANTICHINT);
			if (ep == null) {
				ep = _targetEP.getChildBySemanticHint(DeployCoreConstants.HYBRIDSHAPES_SEMANTICHINT);
			}
			_targetEP = ep;
		}

		validTarget[0] = true;
		int width = DeployCoreConstants.SERVER_UNIT_DPWIDTH;
		int height = DeployCoreConstants.SERVER_UNIT_DPHEIGHT;
		feedbackFigure.setPointerYOffset(YOFFSET);
		Point nameOffset = new Point(6, 1);
		Dimension feedbackSize = new Dimension(width, 22);

		// calculate tooltip
		String toolTip = null;
		if (_targetEP instanceof HybridListCompartmentEditPart
				|| _targetEP instanceof HybridShapesCompartmentEditPart) {
			Unit unit = (Unit) ViewUtil.resolveSemanticElement((View) _targetEP.getModel());
			if (!AddToTopologyCommand.containsAnyUnit(_targetEP, objects)) {
				toolTip = DeployShapeCreationTool.getTooltipMessage((GraphicalEditPart) _targetEP,
						objects, validTarget);
			} else {
				toolTip = NLS.bind(objects.size() > 1 ? Messages.SOME_ALREADY_IN_CONTAINER
						: Messages.ALREADY_IN_CONTAINER, unit.getName());
				validTarget[0] = false;
			}
		} else if (_targetEP instanceof DeployDiagramEditPart
				&& AddToTopologyCommand.containsAnyUnit(_targetEP, objects)) {
			toolTip = objects.size() > 1 ? Messages.SOME_ALREADY_IN_DIAGRAM
					: Messages.ALREADY_IN_DIAGRAM;
			validTarget[0] = false;
		}

		/*
		 * on a list -- could be a config unit or a member
		 */
		if (_targetEP instanceof HybridListCompartmentEditPart) {
			feedbackFigure.setPointerYOffset(.1f);
			feedbackFigure.setFeedbackParameters(nameOffset, feedbackSize, toolTip, !validTarget[0]);

			/*
			 * on a shapes container -- grey server symbol
			 */
		} else if (_targetEP instanceof HybridShapesCompartmentEditPart) {
			feedbackSize.width = width;
			feedbackSize.height = height;
			feedbackFigure.setFeedbackParameters(nameOffset, feedbackSize, toolTip, !validTarget[0]);

			/*
			 * on diagram -- normal server symbol
			 */
		} else if (_targetEP instanceof DeployDiagramEditPart) {
			nameOffset.setLocation(25, 17);
			feedbackSize.width = width;
			feedbackSize.height = height;
			feedbackFigure.setFeedbackParameters(nameOffset, feedbackSize, toolTip, !validTarget[0]);

			/*
			 * prohibited symbol
			 */
		} else {
			feedbackFigure.setFeedbackParameters(nameOffset, feedbackSize,
					Messages.DeployDropTargetListener_0, !validTarget[0]);
		}
		feedbackPt = feedbackFigure.getFeedbackPoint();
	}

	private IGraphicalEditPart getTargetEditPart(EditPartViewer viewer, Point pt) {
		return pt == null ? GMFUtils.getDeployDiagramEditPart(viewer.getRootEditPart())
				: (IGraphicalEditPart) viewer.findObjectAtExcluding(pt, Collections.EMPTY_LIST,
						new EditPartViewer.Conditional() {
							public boolean evaluate(EditPart editpart) {
								return DeployShapeNodeEditPart.isShapesMode(editpart)
										|| DeployShapeNodeEditPart.isTreeMode(editpart)
										|| editpart instanceof HybridShapesCompartmentEditPart
										|| editpart instanceof HybridListCompartmentEditPart
										|| editpart instanceof ImportListCompartmentEditPart
										|| editpart instanceof ImportTopologyEditPart;
							}
						});
	}

	private void addFeedback(IFigure figure) {
		LayerManager lm = (LayerManager) getViewer().getEditPartRegistry().get(LayerManager.ID);
		if (lm == null) {
			return;
		}
		lm.getLayer(LayerConstants.FEEDBACK_LAYER).add(figure);
	}

	private void removeFeedback(IFigure figure) {
		LayerManager lm = (LayerManager) getViewer().getEditPartRegistry().get(LayerManager.ID);
		if (lm == null) {
			return;
		}
		lm.getLayer(LayerConstants.FEEDBACK_LAYER).remove(figure);
	}

}
