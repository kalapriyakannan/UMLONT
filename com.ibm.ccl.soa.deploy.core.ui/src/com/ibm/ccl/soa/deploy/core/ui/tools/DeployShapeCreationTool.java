/***************************************************************************************************
 * Copyright (c) 2003, 2007 IBM Corporation Licensed Material - Property of IBM. All rights
 * reserved.
 * 
 * US Government Users Restricted Rights - Use, duplication or disclosure v1.0 restricted by GSA ADP
 * Schedule Contract with IBM Corp.
 * 
 * Contributors: IBM Corporation - initial API and implementation
 **************************************************************************************************/
package com.ibm.ccl.soa.deploy.core.ui.tools;

import java.util.List;

import org.eclipse.core.commands.operations.IOperationHistory;
import org.eclipse.core.commands.operations.IOperationHistoryListener;
import org.eclipse.core.commands.operations.OperationHistoryEvent;
import org.eclipse.core.commands.operations.OperationHistoryFactory;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.draw2d.geometry.Dimension;
import org.eclipse.draw2d.geometry.Point;
import org.eclipse.gef.EditPart;
import org.eclipse.gef.commands.Command;
import org.eclipse.gmf.runtime.diagram.core.util.ViewUtil;
import org.eclipse.gmf.runtime.diagram.ui.editparts.GraphicalEditPart;
import org.eclipse.gmf.runtime.diagram.ui.editparts.IGraphicalEditPart;
import org.eclipse.gmf.runtime.emf.type.core.IElementType;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.osgi.util.NLS;
import org.eclipse.swt.widgets.Display;

import com.ibm.ccl.soa.deploy.core.Unit;
import com.ibm.ccl.soa.deploy.core.ui.Messages;
import com.ibm.ccl.soa.deploy.core.ui.editparts.DeployDiagramEditPart;
import com.ibm.ccl.soa.deploy.core.ui.editparts.DeployShapeNodeEditPart;
import com.ibm.ccl.soa.deploy.core.ui.editparts.HybridListCompartmentEditPart;
import com.ibm.ccl.soa.deploy.core.ui.editparts.HybridShapesCompartmentEditPart;
import com.ibm.ccl.soa.deploy.core.ui.editparts.TopologyEditPart;
import com.ibm.ccl.soa.deploy.core.ui.figures.ErrorFeedbackFigure;
import com.ibm.ccl.soa.deploy.core.ui.figures.common.CreationFeedbackFigure;
import com.ibm.ccl.soa.deploy.core.ui.tools.common.CreationToolWithFeedback;
import com.ibm.ccl.soa.deploy.core.ui.util.DeployCoreConstants;
import com.ibm.ccl.soa.deploy.core.ui.util.GMFUtils;
import com.ibm.ccl.soa.deploy.core.validator.DeployValidatorService;
import com.ibm.ccl.soa.deploy.core.validator.matcher.LinkDescriptor;
import com.ibm.ccl.soa.deploy.core.validator.matcher.LinkType;

/**
 * 
 * @since 1.0
 * 
 */
public class DeployShapeCreationTool extends CreationToolWithFeedback {

	private boolean _isMultiRootObjects = false;
	private List<Unit> _rootObjects = null;

	static private Point createShapeAtPoint = new Point(DeployCoreConstants.SERVER_UNIT_DPWIDTH,
			DeployCoreConstants.SERVER_UNIT_DPHEIGHT);

	/*
	 * if creation error put up error feedback figure
	 */
	class DeployCreationToolListener implements IOperationHistoryListener {
		private final ErrorFeedbackFigure errorFigure = new ErrorFeedbackFigure(
				ErrorFeedbackFigure.TYPE_ERROR, Messages.CANT_HOST_MESSAGE);

		public void historyNotification(OperationHistoryEvent event) {
			if (event.getStatus() != null) {
				IStatus status = event.getStatus();
				Point pt = getLocation();
				if (isErrorStatus(status) && pt.x != 0 && pt.y != 0) {
					errorFigure.setText(status.getMessage());
					Dimension siz = errorFigure.calculatePreferredSize();
					org.eclipse.swt.graphics.Rectangle r = DeployShapeCreationTool.this
							.getCurrentViewer().getControl().getBounds();
					r.width -= 15;
					r.height -= 15;
					pt.translate(0, -siz.height);
					if (pt.x + siz.width > r.width) {
						pt.x = r.width - siz.width;
					}
					if (pt.y + siz.height > r.height) {
						pt.y = r.height - siz.height;
					}
					errorFigure.setLocation(pt);
					DeployShapeCreationTool.this.addFeedback(errorFigure);
					Display.getCurrent().timerExec(5000, new Runnable() {
						public void run() {
							DeployShapeCreationTool.this.removeFeedback(errorFigure);
						}
					});

				}
			}
		}
	}

	private boolean isErrorStatus(IStatus status) {
		if (!_isMultiRootObjects) {
			return status.getMessage().equals(Messages.CANT_HOST_MESSAGE)
					|| status.getMessage().equals(Messages.CANT_GROUP_MESSAGE);
		}
		return status.getMessage().equals(Messages.CANT_GROUP_MESSAGE);

	}

	private final DeployCreationToolListener creationToolListener = new DeployCreationToolListener();

	/**
	 * @param arg0
	 * @param list --
	 *           does this template have multiple roots
	 */
	public DeployShapeCreationTool(IElementType arg0, List<Unit> list) {
		super(arg0);
		_rootObjects = list;
		_isMultiRootObjects = _rootObjects.size() > 1;
	}

	/**
	 */
	public DeployShapeCreationTool() {
		super();
		_isMultiRootObjects = false;
	}

	// if the user isn't hovering over a compartment, try to figure out what the target is
	protected void setTargetEditPart(EditPart editpart) {
		if (editpart instanceof TopologyEditPart) {
			IGraphicalEditPart gep = (IGraphicalEditPart) editpart;
			// hybrid list//
			if (DeployShapeNodeEditPart.isTreeMode(editpart)) {
				HybridListCompartmentEditPart complistEP = null;
				complistEP = (HybridListCompartmentEditPart) gep
						.getChildBySemanticHint(DeployCoreConstants.HYBRIDLIST_SEMANTICHINT);
				if (complistEP != null) {
					editpart = complistEP;
				}
			} else {
				// hybrid shapes//
				HybridShapesCompartmentEditPart groupareaEP = null;
				groupareaEP = (HybridShapesCompartmentEditPart) gep
						.getChildBySemanticHint(DeployCoreConstants.HYBRIDSHAPES_SEMANTICHINT);
				if (groupareaEP != null) {
					editpart = groupareaEP;
				}
			}
		}
		super.setTargetEditPart(editpart);
	}

	/*
	 * when user presses enter in quick palette we get here
	 * 
	 * @see org.eclipse.gmf.runtime.diagram.ui.tools.CreationTool#createShapeAt(org.eclipse.draw2d.geometry.Point)
	 */
	@Override
	protected void createShapeAt(Point point) {
		// if point is just -1,-1 override with some sort of grid
		if (point.x == -1 && point.y == -1) {
			point = createShapeAtPoint.getCopy();
			org.eclipse.swt.graphics.Rectangle rect = this.getCurrentViewer().getControl().getBounds();
			createShapeAtPoint.x += DeployCoreConstants.SERVER_UNIT_DPWIDTH * 3 / 2;
			if (createShapeAtPoint.x > rect.width - DeployCoreConstants.SERVER_UNIT_DPWIDTH * 2) {
				createShapeAtPoint.x = DeployCoreConstants.SERVER_UNIT_DPWIDTH;
				createShapeAtPoint.y += DeployCoreConstants.SERVER_UNIT_DPHEIGHT * 3 / 2;
				if (createShapeAtPoint.y > rect.height - DeployCoreConstants.SERVER_UNIT_DPHEIGHT * 2) {
					createShapeAtPoint.y = DeployCoreConstants.SERVER_UNIT_DPHEIGHT;
				}
			}
		}
		super.createShapeAt(point);
		handleFinished();
	}

	/*
	 * when mouse clicked, or if user presses enter in quick palette, createShapeAt() calls this to
	 * create unit
	 * 
	 * @see org.eclipse.gmf.runtime.diagram.ui.tools.CreationTool#performCreation(int)
	 */
	protected void performCreation(int button) {
		// be notified if we can't create a unit (notified in historyNotification() above))
		IOperationHistory history = OperationHistoryFactory.getOperationHistory();
		history.addOperationHistoryListener(creationToolListener);

		// create the unit
		super.performCreation(button);

		// turn off notifier
		history.removeOperationHistoryListener(creationToolListener);
	}

	@Override
	protected void executeCurrentCommand() {
		Command curCommand = getCurrentCommand();
		if (curCommand != null && curCommand.canExecute() && canExecuteCommand()) {
			executeCommand(curCommand);
		}
		setCurrentCommand(null);
	}

	private boolean canExecuteCommand() {
		if (getTargetEditPart() instanceof HybridListCompartmentEditPart
				|| getTargetEditPart() instanceof HybridShapesCompartmentEditPart) {
			Unit containerUnit = (Unit) ViewUtil.resolveSemanticElement((View) getTargetEditPart()
					.getModel());
			for (Unit unit : _rootObjects) {
				boolean isViable = false;
				DeployValidatorService dvs = DeployValidatorService.getDefaultValidatorService();
				if (dvs.canCreateLink(containerUnit, unit, LinkType.MEMBER_SET).isOK()) {
					LinkDescriptor[] hld = dvs
							.getPossibleLinks(containerUnit, unit, LinkType.MEMBER_SET);
					isViable = hld.length > 0;
				}
				if (dvs.canCreateLink(containerUnit, unit, LinkType.HOSTING_SET).isOK()) {
					LinkDescriptor[] hld = dvs.getPossibleLinks(containerUnit, unit,
							LinkType.HOSTING_SET);
					isViable = hld.length > 0;
				}
				if (!isViable) {
					return false;
				}
			}
		}
		return true;
	}

	/*
	 * lasso only allowed if not creating multiple elements at once
	 * 
	 * @see com.ibm.xtools.diagram.ui.common.tools.CreationToolWithFeedback#isLassoAllowed()
	 */
	@Override
	protected boolean isLassoAllowed() {
		return !_isMultiRootObjects;
	}

	/*
	 * multiple element creation only allowed if not creating multiple elements at once
	 * 
	 * @see com.ibm.xtools.diagram.ui.common.tools.CreationToolWithFeedback#isLassoAllowed()
	 */
	@Override
	protected boolean isMultiElementCreationAllowed() {
		return !_isMultiRootObjects;
	}

	@Override
	protected void setFeedbackParameters(CreationFeedbackFigure feedbackFigure) {
		feedbackFigure.setPointerXOffset(.75f);
		feedbackFigure.setPointerYOffset(.75f);
		int width = DeployCoreConstants.SERVER_UNIT_DPWIDTH;
		int height = DeployCoreConstants.SERVER_UNIT_DPHEIGHT;
		Point nameOffset = new Point(6, 1);
		Dimension feedbackSize = new Dimension(width, 18);
		/*
		 * on a list -- could be a config unit or a member
		 */
		boolean[] validTarget = new boolean[] { true };
		if (getTargetEditPart() instanceof HybridListCompartmentEditPart) {
			String toolTip = getTooltipMessage((GraphicalEditPart) getTargetEditPart(), _rootObjects,
					validTarget);
			feedbackFigure.setFeedbackParameters(nameOffset, feedbackSize, toolTip, !validTarget[0]);
			/*
			 * on a shapes container -- grey server symbol
			 */
		} else if (getTargetEditPart() instanceof HybridShapesCompartmentEditPart) {
			String toolTip = getTooltipMessage((GraphicalEditPart) getTargetEditPart(), _rootObjects,
					validTarget);
			nameOffset.setLocation(25, 17);
			feedbackSize.width = width;
			feedbackSize.height = height;
			feedbackFigure.setFeedbackParameters(nameOffset, feedbackSize, toolTip, !validTarget[0]);

			/*
			 * on diagram -- normal server symbol
			 */
		} else if (getTargetEditPart() instanceof DeployDiagramEditPart) {
			nameOffset.setLocation(25, 17);
			feedbackSize.width = width;
			feedbackSize.height = height;
			feedbackFigure.setFeedbackParameters(nameOffset, feedbackSize, null, false);

			/*
			 * prohibited symbol
			 */
		} else {
			feedbackFigure.setFeedbackParameters(nameOffset, feedbackSize,
					Messages.DeployDropTargetListener_0, true);
		}
	}

	/**
	 * @param targetEP
	 * @param objects
	 * @param validTarget
	 * @return a message determining if object can be hosted on or added to containerUnit as a member
	 */
	static public String getTooltipMessage(GraphicalEditPart targetEP, List<?> objects,
			boolean[] validTarget) {
		if (validTarget != null) {
			validTarget[0] = true;
		}
		Unit containerUnit = (Unit) targetEP.resolveSemanticElement();
		if (GMFUtils.isDiagramNode(targetEP)) {
			return Messages.DeployDropTargetListener_0;
		}
		if (objects.get(0) instanceof Unit) {
			Unit unit1 = containerUnit;
			Unit unit2 = (Unit) objects.get(0);

			// if already in container but just filtered, allow it
			if (!GMFUtils.isHosteeOrMemberOf(unit2, unit1)) {
				DeployValidatorService dvs = DeployValidatorService.getDefaultValidatorService();
				if (dvs.canCreateLink(unit1, unit2, LinkType.MEMBER_SET).isOK()) {
					LinkDescriptor[] hld = dvs.getPossibleLinks(unit1, unit2, LinkType.MEMBER_SET);
					if (hld.length > 0) {
						return NLS.bind(Messages.ADD_AS_MEMBER, containerUnit.getCaptionProvider().title(
								containerUnit));
					}
				}
				// then try creating a hosting link
				if (dvs.canCreateLink(unit1, unit2, LinkType.HOSTING_SET).isOK()) {
					LinkDescriptor[] hld = dvs.getPossibleLinks(unit1, unit2, LinkType.HOSTING_SET);
					if (hld.length > 0) {
						return NLS.bind(Messages.ADD_AS_HOSTED, containerUnit.getCaptionProvider().title(
								containerUnit));
					}
				}
				if (validTarget != null) {
					validTarget[0] = false;
				}
				return NLS.bind(Messages.CANNOT_ADD_TO_CONTAINER, containerUnit.getCaptionProvider()
						.title(containerUnit));
			}
		}
		// if drop object has not been converted to unit yet, we can't run matcher on it yet
		return NLS.bind(Messages.ADD_NEW_UNIT_TO_CONTAINER, containerUnit.getCaptionProvider().title(
				containerUnit));
	}

}
