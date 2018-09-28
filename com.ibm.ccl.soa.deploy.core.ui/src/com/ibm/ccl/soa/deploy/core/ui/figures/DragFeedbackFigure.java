/***************************************************************************************************
 * Copyright (c) 2003, 2007 IBM Corporation Licensed Material - Property of IBM. All rights
 * reserved.
 * 
 * US Government Users Restricted Rights - Use, duplication or disclosure v1.0 restricted by GSA ADP
 * Schedule Contract with IBM Corp.
 * 
 * Contributors: IBM Corporation - initial API and implementation
 **************************************************************************************************/
package com.ibm.ccl.soa.deploy.core.ui.figures;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.draw2d.ColorConstants;
import org.eclipse.draw2d.FigureUtilities;
import org.eclipse.draw2d.Graphics;
import org.eclipse.draw2d.IFigure;
import org.eclipse.draw2d.Shape;
import org.eclipse.draw2d.geometry.Dimension;
import org.eclipse.draw2d.geometry.Point;
import org.eclipse.draw2d.geometry.PrecisionPoint;
import org.eclipse.draw2d.geometry.PrecisionRectangle;
import org.eclipse.draw2d.geometry.Rectangle;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.gef.EditPart;
import org.eclipse.gef.EditPartViewer;
import org.eclipse.gef.LayerConstants;
import org.eclipse.gef.commands.Command;
import org.eclipse.gef.editparts.LayerManager;
import org.eclipse.gmf.runtime.common.core.command.CommandResult;
import org.eclipse.gmf.runtime.common.core.command.ICommand;
import org.eclipse.gmf.runtime.common.ui.services.icon.IconOptions;
import org.eclipse.gmf.runtime.common.ui.services.icon.IconService;
import org.eclipse.gmf.runtime.diagram.core.util.ViewUtil;
import org.eclipse.gmf.runtime.diagram.ui.commands.ICommandProxy;
import org.eclipse.gmf.runtime.diagram.ui.editparts.GraphicalEditPart;
import org.eclipse.gmf.runtime.diagram.ui.editparts.IGraphicalEditPart;
import org.eclipse.gmf.runtime.diagram.ui.editparts.ResizableCompartmentEditPart;
import org.eclipse.gmf.runtime.diagram.ui.figures.ResizableCompartmentFigure;
import org.eclipse.gmf.runtime.diagram.ui.figures.ShapeCompartmentFigure;
import org.eclipse.gmf.runtime.draw2d.ui.mapmode.MapModeUtil;
import org.eclipse.gmf.runtime.emf.commands.core.command.AbstractTransactionalCommand;
import org.eclipse.gmf.runtime.emf.core.util.EObjectAdapter;
import org.eclipse.gmf.runtime.notation.Diagram;
import org.eclipse.gmf.runtime.notation.NotationPackage;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.osgi.util.NLS;
import org.eclipse.swt.graphics.Color;
import org.eclipse.swt.graphics.Font;
import org.eclipse.swt.graphics.Image;

import com.ibm.ccl.soa.deploy.core.DeployModelObject;
import com.ibm.ccl.soa.deploy.core.Import;
import com.ibm.ccl.soa.deploy.core.InstanceConfiguration;
import com.ibm.ccl.soa.deploy.core.Unit;
import com.ibm.ccl.soa.deploy.core.ui.DeployCoreUIPlugin;
import com.ibm.ccl.soa.deploy.core.ui.ISharedColors;
import com.ibm.ccl.soa.deploy.core.ui.ISharedFonts;
import com.ibm.ccl.soa.deploy.core.ui.Messages;
import com.ibm.ccl.soa.deploy.core.ui.commands.VisualizeFromNotationalCommand;
import com.ibm.ccl.soa.deploy.core.ui.commands.VisualizeFromSemanticCommand;
import com.ibm.ccl.soa.deploy.core.ui.editparts.DeployCoreCompartmentEditPart;
import com.ibm.ccl.soa.deploy.core.ui.editparts.DeployDiagramEditPart;
import com.ibm.ccl.soa.deploy.core.ui.editparts.DeployListCompartmentEditPart;
import com.ibm.ccl.soa.deploy.core.ui.editparts.DeployShapeNodeEditPart;
import com.ibm.ccl.soa.deploy.core.ui.editparts.DiagramListCompartmentEditPart;
import com.ibm.ccl.soa.deploy.core.ui.editparts.DiagramNodeEditPart;
import com.ibm.ccl.soa.deploy.core.ui.editparts.ImportListCompartmentEditPart;
import com.ibm.ccl.soa.deploy.core.ui.editparts.ImportTopologyEditPart;
import com.ibm.ccl.soa.deploy.core.ui.figures.core.CompositeShapeFigure;
import com.ibm.ccl.soa.deploy.core.ui.internal.commands.ArrangeSnappedViewsCommand;
import com.ibm.ccl.soa.deploy.core.ui.internal.commands.CopyViewCommand;
import com.ibm.ccl.soa.deploy.core.ui.internal.commands.MoveViewCommand;
import com.ibm.ccl.soa.deploy.core.ui.internal.commands.ShowOrNotShowUnitOnHostCommand;
import com.ibm.ccl.soa.deploy.core.ui.internal.commands.SnapViewCommand;
import com.ibm.ccl.soa.deploy.core.ui.notation.DeployNotationPackage;
import com.ibm.ccl.soa.deploy.core.ui.notation.DeployStyle;
import com.ibm.ccl.soa.deploy.core.ui.properties.PropertyUtils;
import com.ibm.ccl.soa.deploy.core.ui.util.CanonicalUtils;
import com.ibm.ccl.soa.deploy.core.ui.util.ContainmentStateUtils;
import com.ibm.ccl.soa.deploy.core.ui.util.DeployCoreConstants;
import com.ibm.ccl.soa.deploy.core.ui.util.GEFUtils;
import com.ibm.ccl.soa.deploy.core.ui.util.GMFUtils;
import com.ibm.ccl.soa.deploy.core.ui.util.CanonicalUtils.UnitLinkData;
import com.ibm.ccl.soa.deploy.core.validator.DeployValidatorService;
import com.ibm.ccl.soa.deploy.core.validator.matcher.LinkType;

/**
 * @author jswanke
 * 
 */
public class DragFeedbackFigure extends Shape {

	private Image image = null;
	private String name = null;
	private Dimension nameSize = null;
	private List<String> toolTips = null;
	private DragFeedbackTooltip _tooltip = null;
	private Rectangle feedbackRect = null;
	private static Color ghostFillColor;
	private static Color toolTipColor;
	private final Font memberFont;
	private final Point originalPt;
	private final Point zeroAdjustment = new Point(0, 0);

	private Point position = null;
	private Point positionD = null;
	private boolean isDuplicateView = false;

	// monitor keys
	private boolean isMoveGesture = false;
	private boolean isDetachGesture = false;

	private boolean toggleCopyCommand = false;
	private boolean isActualCopyCommand = false;
	private boolean isImportItemCopy = false;
	private boolean isDiagramNodeItemCopy = false;
	private boolean isListItemCopy = false;
	private boolean isInsideMoveCommand = false;
	private boolean isIllegalMoveCommand = false;
	private GraphicalEditPart movedPart = null;
	private EObject movedEO = null;
	private View movedView = null;
	private DeployShapeNodeEditPart fromContainerEP = null;
	private DeployShapeNodeEditPart toContainerEP = null;
	private DeployDiagramEditPart diagramEP = null;

	// snap support
	private boolean isAttachCommand = false;
	private boolean isDetachCommand = false;
	private boolean hasAttachments = false;
	private GraphicalEditPart touchingPart = null;
	private final PrecisionRectangle originalRect;
	final private boolean _isAttachmentSlaveFeedback;
	private final List<DragFeedbackFigure> _myAttachmentSlaveFeedbackList = new ArrayList<DragFeedbackFigure>();
	static private List<DragFeedbackFigure> _attachmentSlaveFeedbackList = new ArrayList<DragFeedbackFigure>();
	static private List<EditPart> _attachmentSlaveFeedbackEPList = new ArrayList<EditPart>();
	// GMF doesn't move contained ep's 
	private final Set<View> _containedViewSet = new HashSet<View>();
	private boolean _useShowOnHostCommand;
	private Rectangle feedbackRectL;

	static private boolean isUpdatingTooltips = false;

	/**
	 * @param part --
	 *           the EditPart that is being dragged
	 * @param isAttachmentSlaveFeedback --
	 *           is this an attachment drag
	 */
	public DragFeedbackFigure(GraphicalEditPart part, boolean isAttachmentSlaveFeedback) {
		this.setOpaque(false);
		diagramEP = GMFUtils.getDeployDiagramEditPart(part);

		// get the moved editpart's view, style, unit, etc. 
		movedPart = part;
		movedView = (View) movedPart.getModel();
		movedEO = ViewUtil.resolveSemanticElement(movedView);
		fromContainerEP = getFromContainer(movedPart);

		ghostFillColor = DeployCoreUIPlugin.getDefault().getSharedColors().getColor(
				ISharedColors.GHOST_FILL_COLOR);
		toolTipColor = DeployCoreUIPlugin.getDefault().getSharedColors().getColor(
				ISharedColors.TOOL_TIP_COLOR);

		ISharedFonts sharedFont = DeployCoreUIPlugin.getDefault().getSharedFonts();
		memberFont = sharedFont.getFont(ISharedFonts.FEEDBACK_FIG_NAME);

		boolean isDraggingDiagramNode = movedPart instanceof DiagramNodeEditPart;

		// get image and name to put on feedback figure
		image = IconService.getInstance().getIcon(new EObjectAdapter(movedEO),
				IconOptions.GET_STEREOTYPE_IMAGE_FOR_ELEMENT.intValue());
		name = isDraggingDiagramNode ? ((DiagramNodeEditPart) movedPart).getDiagramName() : GMFUtils
				.getDmoName(movedEO);
		nameSize = FigureUtilities.getTextExtents(name, memberFont);
		nameSize.width += 19;

		// get the original view's origin-- used if this is a copy, we need to reposition the moved
		// view back where it was because we created a new view at the destination
		int x = ((Integer) ViewUtil.getStructuralFeatureValue(movedView, NotationPackage.eINSTANCE
				.getLocation_X())).intValue();
		int y = ((Integer) ViewUtil.getStructuralFeatureValue(movedView, NotationPackage.eINSTANCE
				.getLocation_Y())).intValue();
		originalPt = new Point(x, y);

		IFigure f = movedPart.getFigure();
		originalRect = new PrecisionRectangle(f.getBounds());
		f.translateToAbsolute(originalRect);

		// determine the type of copy
		// --copying from an import tree, therefore only copy allowed and size of feedback figure is standard size
		boolean isDraggingImportEditPart = movedPart instanceof ImportTopologyEditPart;
		isImportItemCopy = !isDraggingImportEditPart
				&& GMFUtils.getImportTopologyEP(movedPart) != null
				&& PropertyUtils.isProxy((DeployModelObject) movedEO);

		// --copying from an import tree, therefore only copy allowed and size of feedback figure is standard size
		isDiagramNodeItemCopy = !isDraggingDiagramNode
				&& GMFUtils.getDiagramNodeEP(movedPart) != null;

		// -- copying from a component tree, therefore size of feedback figure is standard size
		isListItemCopy = movedPart.getParent() instanceof DeployListCompartmentEditPart;

		// force copy if ALT key pressed or copying out of an import/diagram tree
		isMoveGesture = diagramEP.isAltKey();
		toggleCopyCommand = !isMoveGesture || isImportItemCopy || isDiagramNodeItemCopy;

		// see if this is a duplicate view-- if so checks if view is already in a group or on canvas
		isDuplicateView = false;
		if (movedEO instanceof Unit) {
			int memberLinks = ((Unit) movedEO).getTopology().findMemberOf((Unit) movedEO).length;
			isDuplicateView = memberLinks > 1 || memberLinks > 0
					&& isInContainer(diagramEP, (Unit) movedEO);
		}

		// attach/detach if Ctrl key pressed
		_isAttachmentSlaveFeedback = isAttachmentSlaveFeedback;
		isDetachGesture = diagramEP.isControlKey();

		// capture any contained units (selected inner editpart)
		for (Iterator<?> it = diagramEP.getViewer().getSelectedEditParts().iterator(); it.hasNext();) {
			GraphicalEditPart ep = (GraphicalEditPart) it.next();
			if (movedPart != ep && GEFUtils.isChildOf(ep, movedPart)) {
				EObject eo = ep.resolveSemanticElement();
				if (eo instanceof Unit && eo != movedEO) {
					_containedViewSet.add(ep.getNotationView());
				}
			}
		}
	}

	/**
	 * was alt key pressed while dragging?
	 */
	public void altKeyPressed() {
		isMoveGesture = !isMoveGesture;
		toggleCopyCommand = !isMoveGesture || isImportItemCopy || isDiagramNodeItemCopy;
		setBounds(feedbackRect);

		// update other tooltips
		if (!isUpdatingTooltips) {
			isUpdatingTooltips = true;
			for (IFigure fig : diagramEP.getMoveFeedbackMap().values()) {
				if (fig instanceof DragFeedbackFigure && !fig.equals(this)) {
					((DragFeedbackFigure) fig).altKeyPressed();
				}
			}
			isUpdatingTooltips = false;
		}
	}

	/**
	 * was ctrl key pressed while dragging?
	 */
	public void ctrlKeyPressed() {
		if (!_isAttachmentSlaveFeedback) {
			isDetachGesture = !isDetachGesture;
			setBounds(feedbackRect);
		}

		// update other tooltips
		if (!isUpdatingTooltips) {
			isUpdatingTooltips = true;
			for (IFigure fig : diagramEP.getMoveFeedbackMap().values()) {
				if (fig instanceof DragFeedbackFigure && !fig.equals(this)) {
					((DragFeedbackFigure) fig).ctrlKeyPressed();
				}
			}
			isUpdatingTooltips = false;
		}
	}

	/**
	 * @return moved view
	 */
	public View getMovedView() {
		return movedView;
	}

	/**
	 * @return just moving within canvas or a container
	 */
	public boolean isInsideMoveCommand() {
		return isInsideMoveCommand;
	}

	public void setBounds(Rectangle rect) {
		/*
		 * see if over a group/ hybrid list --if moving multiple objects, the to container is the same
		 * as the from
		 */
		feedbackRect = rect.getCopy(); // "feedbackRect" used in getToContainer()
		toContainerEP = getToContainer(movedPart, position);
		String toContainerName = toContainerEP != null ? GMFUtils.getDmoName(toContainerEP
				.resolveSemanticElement()) : ""; //$NON-NLS-1$

		feedbackRectL = rect.getCopy();
		translateToAbsolute(feedbackRectL);
		diagramEP.getFigure().translateToRelative(feedbackRectL);

		// if dragging multiple figures, make sure primary figure has left its container before we considering leaving ours
		DragFeedbackFigure primaryDragFigure = diagramEP.getPrimaryMoveFeedbackFigure();
		if (primaryDragFigure == null || primaryDragFigure != this
				&& primaryDragFigure.isInsideMoveCommand) {
			toContainerEP = fromContainerEP;
		}

		/*
		 * see if shape should change based on what the to container is
		 */
		// if over hybrid list, do item size
		if (toContainerEP != null
				&& toContainerEP.getChildBySemanticHint(DeployCoreConstants.HYBRIDLIST_SEMANTICHINT) != null
				&& !_isAttachmentSlaveFeedback) {
			// if this is the feedback figure under the cursor, make sure the new sized rect is also under the cursor
			if (diagramEP.getMoveFeedbackMap().size() == 1) {
				int y = positionD.y - DeployCoreConstants.HOSTINGLISTITEM_DPHEIGHT / 2;
				rect.y = y;
				((PrecisionRectangle) rect).preciseY = y;
			}
			rect.height = DeployCoreConstants.HOSTINGLISTITEM_DPHEIGHT;
			((PrecisionRectangle) rect).preciseHeight = DeployCoreConstants.HOSTINGLISTITEM_DPHEIGHT;

			// if tree drag, reshape boundaries from item to shape
		} else if (isListItemCopy) {
			rect.height = DeployCoreConstants.SERVER_UNIT_DPHEIGHT;
			((PrecisionRectangle) rect).preciseHeight = DeployCoreConstants.SERVER_UNIT_DPHEIGHT;
		}
		feedbackRect = rect.getCopy();

		/*
		 * initialize
		 */
		toolTips = new ArrayList<String>();
		touchingPart = null;
		boolean wasAttachCommand = isAttachCommand;
		String attachTip = null;
		isIllegalMoveCommand = isAttachCommand = isDetachCommand = false;

		// don't allow moving into an import or import diagram compartment unless unit doesn't belong
		if (toContainerEP != fromContainerEP) {
			ImportTopologyEditPart itep = GMFUtils.getImportTopologyEP(toContainerEP);
			if (itep != null && movedEO instanceof Unit) {
				EObject toEO = toContainerEP.resolveSemanticElement();
				if (!(toEO instanceof Unit)
						|| ((Unit) toEO).getTopology() == ((Unit) movedEO).getTopology()) {
					toolTips.add(Messages.DeployDropTargetListener_0);
					isIllegalMoveCommand = true;
				}
			}
			// don't allow moving into a diagram node compartment
			if (toContainerEP != fromContainerEP && GMFUtils.isDiagramNode(toContainerEP)) {
				toolTips.add(Messages.DeployDropTargetListener_0);
				isIllegalMoveCommand = true;
			}
		}

		// are we just moving it within canvas or a container
		isInsideMoveCommand = toContainerEP == fromContainerEP;

		// trying to host/make member of itself
		if (toContainerEP != null && toContainerEP.resolveSemanticElement().equals(movedEO)) {
			toolTips.add(Messages.DragFeedbackFigure_Cannot_contain_on_itsel_);
			isIllegalMoveCommand = true;
		}

		// see if this is an attach gesture
		//if (!_isAttachmentSlaveFeedback && _myAttachmentSlaveFeedbackList.isEmpty()
		//		&& isSingleSelection()) {
		if (!isIllegalMoveCommand && (toContainerEP == null || toContainerEP == fromContainerEP)
				&& !_isAttachmentSlaveFeedback && isSingleSelection()) {
			List touchChildren = null;
			if (toContainerEP == null) {
				touchChildren = diagramEP.getChildren();
			} else {
				IGraphicalEditPart ep = toContainerEP
						.getChildBySemanticHint(DeployCoreConstants.HYBRIDSHAPES_SEMANTICHINT);
				if (ep != null) {
					touchChildren = ep.getChildren();
				}
			}

			if (touchChildren != null) {
				touchingPart = getTouchingEditPart(movedPart, rect, touchChildren);
				if (touchingPart != null && !(touchingPart instanceof ImportTopologyEditPart)
						&& !(touchingPart instanceof DiagramNodeEditPart)) {
					String touchingName = touchingPart != null ? GMFUtils.getDmoName(touchingPart
							.resolveSemanticElement()) : ""; //$NON-NLS-1$
					if (isDetachGesture) {
						isAttachCommand = true;
						toolTips.add(NLS.bind(Messages.ATTACH_TO_VIEW, touchingName));
					} else {
						attachTip = NLS.bind(Messages.PRESS_CTRL_KEY_TO_ATTACH, touchingName);
					}
				} else if (wasAttachCommand) {
					isDetachGesture = false;
				}
			}
		}

		// see if this is a detach action
		if (!_isAttachmentSlaveFeedback && hasAttachments && attachTip == null && !isAttachCommand) {
			// show slaves only if ctrl key not pressed and the target is the canvas
			boolean withinSameContainer = toContainerEP == fromContainerEP;
			setSlaveFeedbackVisible(!isDetachGesture && withinSameContainer);

			// detach command if user uses ctrl key to another spot on canvas --or-- if user is doing move to a container
			if (isDetachGesture && withinSameContainer || isMoveGesture && !withinSameContainer) {
				isDetachCommand = true;
				toolTips.add(NLS.bind(Messages.DETACH_FROM_VIEW, name));
				toolTips.add(Messages.DragFeedbackFigure_Cancel_detach_message);
			} else if (withinSameContainer) {
				// don't allow detach if copying into a container (too confusing)
				attachTip = NLS.bind(Messages.PRESS_CTRL_KEY_TO_DETACH, name);
			}
		}

		// if this unit can't live in this container as member or hostee, ignore
		Unit toContainerUnit = null;
		boolean isAddMemberLink = false;
		boolean isUseHostingLink = false;
		boolean isAddHostingLink = false;
		if (!isIllegalMoveCommand && !isAttachCommand && !isDetachCommand && toContainerEP != null) {
			EObject toContainerDmo = toContainerEP.resolveSemanticElement();
			if (toContainerDmo instanceof Unit) {
				toContainerUnit = (Unit) toContainerDmo;
				if (toContainerEP != fromContainerEP) {
					// is this unit already here but just deleted from diagram (filtered)
					if (GMFUtils.isHosteeOf(movedEO, (Unit) toContainerDmo)) {
						isAddHostingLink = true;
					} else if (GMFUtils.isMemberOf(movedEO, (Unit) toContainerDmo)) {
						isAddMemberLink = true;
					} else if (movedEO instanceof Unit) {
						// if moving to a group
						DeployValidatorService dvs = DeployValidatorService.getDefaultValidatorService();
						// if hosting link already exists, no need to add membership link
						isUseHostingLink = GMFUtils.isHosteeOf(movedEO, toContainerUnit);
						// else try adding member link
						isAddMemberLink = !isUseHostingLink
								&& dvs.canCreateLink(toContainerUnit, (Unit) movedEO, LinkType.MEMBER_SET)
										.isOK();
						// else try adding hosting link
						if (!isAddMemberLink) {
							if (isUseHostingLink) {
								isAddHostingLink = true;
							} else {
								isAddHostingLink = !isAddMemberLink
										&& dvs.canCreateLink(toContainerUnit, (Unit) movedEO,
												LinkType.HOSTING_SET).isOK();
							}
						}
						// can't add member or hosting link-- illegal move
						if (!isAddMemberLink && !isAddHostingLink) {
							toolTips.add(NLS.bind(Messages.CANNOT_ADD_TO_CONTAINER, toContainerName));
							isIllegalMoveCommand = true;
						}
					}
				}
			}

		}

		// determine if this a copy or a move
		isActualCopyCommand = toContainerEP == null || fromContainerEP == null ? !toggleCopyCommand
				: toggleCopyCommand;
		isActualCopyCommand |= isImportItemCopy || isDiagramNodeItemCopy;

		// determine if this is a hostee containment action
		boolean isContainmentAction = false;
		if (!isIllegalMoveCommand && (fromContainerEP == null || toContainerEP == null)) {
			if (!GMFUtils.isImportTopology(fromContainerEP)
					&& !GMFUtils.isDiagramNode(fromContainerEP)) {
				boolean isHostedOnFromContainer = fromContainerEP != null
						&& GMFUtils.isHosteeOf(movedPart, fromContainerEP);
				// creating a hostee-- containment action if from canvas or from a container it wasn't hosted on
				if (isAddHostingLink) {
					if (fromContainerEP == null || !isHostedOnFromContainer) {
						isContainmentAction = true;
					}
					// not creating a hosting link (moving to canvas or a group)--containment action if it was hosted on from container
				} else {
					if (isHostedOnFromContainer) {
						isContainmentAction = true;
					}
				}
			}
		}

		// if already in diagram/group/concept node, ignore, unless containment action
		_useShowOnHostCommand = false;
		if (!isIllegalMoveCommand) {
			if (toContainerEP != null) {
				if (!(movedEO instanceof Unit)) {
					toolTips.add(NLS.bind(Messages.CANNOT_ADD_TO_CONTAINER, toContainerName));
					isIllegalMoveCommand = true;
				} else if (fromContainerEP == null || toContainerEP != fromContainerEP) {
					if (isInContainer(toContainerEP, (Unit) movedEO)) {
						toolTips.add(NLS.bind(Messages.ALREADY_IN_CONTAINER, toContainerName));
						isIllegalMoveCommand = true;
					}
				}
			} else if (fromContainerEP != null) {
				if (isInContainer(diagramEP, (Unit) movedEO)) {
					if (isContainmentAction && !isActualCopyCommand) {
						_useShowOnHostCommand = true;
					} else {
						toolTips.add(Messages.ALREADY_IN_DIAGRAM);
						isIllegalMoveCommand = true;
					}
				}
			}
		}

		// if feedback is over a shapes container
		boolean isShowUnitOnHost = false;
		if (!isIllegalMoveCommand) {
			if (toContainerEP != null) {
				// if feedback came from diagram or another container (double hosted)
				if (fromContainerEP == null || toContainerEP != fromContainerEP) {
					if (isAddHostingLink) {
						// is this a contaiment action (not yet contained)
						if (isContainmentAction) {
							if (GMFUtils.isHosteeOf(movedPart, toContainerEP)) {
								if (isActualCopyCommand) {
									toolTips
											.add(Messages.DragFeedbackFigure_Show_Unit_On_Host_and_leave_copy_in_);
								} else {
									toolTips.add(Messages.SHOW_UNIT_ON_HOST_ACTION_LABEL);
								}
								isShowUnitOnHost = true;
							} else {
								toolTips.add(NLS.bind(Messages.ADD_AS_HOSTED, toContainerName));
							}
						} else {
							// gets here if hosted on from container and we're hosting on to container
							// we can make a new copy in to container or delete from from container and remove its hosting link
							toolTips.add(NLS.bind(isActualCopyCommand ? Messages.ADD_AS_HOSTED_COPY
									: Messages.ADD_AS_HOSTED, toContainerName));
						}
						// member links
					} else {
						if (isActualCopyCommand) {
							toolTips.add(NLS.bind(Messages.ADD_AS_MEMBER_COPY, toContainerName));
						} else {
							toolTips.add(NLS.bind(Messages.ADD_AS_MEMBER, toContainerName));
						}
					}
					if (_containedViewSet.size() > 0) {
						toolTips.add(NLS.bind(
								Messages.DragFeedbackFigure_Warning_Inner_selected_units_will_,
								toContainerName));

					}
				}
				// else if feedback came from a container (onto diagram)
			} else if (fromContainerEP != null) {
				// say "Removing from ..."
				if (isContainmentAction) {
					if (isActualCopyCommand) {
						toolTips.add(Messages.CREATE_COPY_IN_DIAGRAM);
					} else {
						toolTips.add(Messages.DONOT_SHOW_UNIT_ON_HOST_ACTION_LABEL);
					}
				} else {
					// if this is a contained unit (thru host) it can't be moved to the canvas except as a containment action
					if (isActualCopyCommand) {
						toolTips.add(Messages.CREATE_COPY_IN_DIAGRAM);
					} else {
						toolTips.add(Messages.ADD_TO_DIAGRAM);
					}
				}
			}
			if (!isActualCopyCommand && !isContainmentAction && fromContainerEP != null) {
				DeployModelObject fromContainerDmo = (DeployModelObject) fromContainerEP
						.resolveSemanticElement();
				String fromContainerName = GMFUtils.getDmoName(fromContainerDmo);
				if (GMFUtils.isHosteeOf(movedEO, (Unit) fromContainerDmo)) {
					toolTips.add(NLS.bind(
							Messages.DragFeedbackFigure_And_delete_hosting_link_to_0_from_,
							fromContainerName));
				} else if (GMFUtils.isMemberOf(movedEO, (Unit) fromContainerDmo)) {
					toolTips.add(NLS.bind(Messages.DragFeedbackFigure_And_delete_member_link_to_0_from_,
							fromContainerName));
				}
			}
			if (toolTips.size() > 0 && !isImportItemCopy && !isDiagramNodeItemCopy && !isAttachCommand
					&& !isDetachCommand) {
				if (isActualCopyCommand) {
					if (!isContainmentAction) {
						toolTips.add(Messages.PRESS_ALT_KEY_TO_MOVE);
					} else if (isShowUnitOnHost) {
						toolTips.add(Messages.DragFeedbackFigure_Press_Alt_key_to_Not_Show_Unit_on_H_);
					} else {
						toolTips.add(Messages.DragFeedbackFigure_Press_Alt_key_to_not_leave_a_cop_);
					}
				} else {
					if (!isContainmentAction) {
						toolTips.add(Messages.DragFeedbackFigure_Press_alt_key_to_move);
					} else if (isShowUnitOnHost) {
						toolTips.add(Messages.DragFeedbackFigure_Press_Alt_key_again_to_leave_copy_i_);
					} else {
						toolTips.add(Messages.DragFeedbackFigure_Press_alt_key_to_move);
					}
				}
			}
			if (attachTip != null && !isContainmentAction) {
				toolTips.add(attachTip);
			}
		}

		// if there's a toolTip, set its rect (drawn in outlineShape)
		if (toolTips != null && _tooltip != null && !_isAttachmentSlaveFeedback) {
			// NOE: must set position first or whole screen will refresh!
			_tooltip.setPosition(rect.getTopLeft().translate(0, -4));
			_tooltip.setTooltips(toolTips, isIllegalMoveCommand ? DragFeedbackTooltip.TYPE_ERROR
					: DragFeedbackTooltip.TYPE_SUCCESS);
		}

		// make sure a unit(s) being dragged into a container is not placed < 0,0 
		refreshZeroOffset();

		// if this drag feedback figure is part of an attachment, move all attachments too
		setAttachmentBounds(rect.getTopLeft());

		super.setBounds(rect);
	}

	private boolean isSingleSelection() {
		int c = 0;
		for (Iterator it = diagramEP.getViewer().getSelectedEditParts().iterator(); it.hasNext();) {
			if (it.next() instanceof DeployShapeNodeEditPart) {
				c++;
			}
		}
		return c <= 1;
	}

	private void refreshZeroOffset() {
		zeroAdjustment.setLocation(0, 0);
		if (toContainerEP != null) {
			// get the to container's upper/left point
			// make sure this point is inside of container
			IFigure toContainerFig = toContainerEP.getFigure();
			Point toContainerPt = toContainerFig.getBounds().getTopLeft().getCopy();
			toContainerPt.translate(DeployCoreConstants.SHAPES_UNIT_INSET * 3, GEFUtils
					.getShapesHeaderHeight(toContainerFig)
					+ DeployCoreConstants.SHAPES_UNIT_INSET * 3);
			toContainerFig.translateToAbsolute(toContainerPt);

			// figure out the top/left most point of any feedback figure
			Point upperLeftPt = new Point(Integer.MAX_VALUE, Integer.MAX_VALUE);
			for (IFigure fig : diagramEP.getMoveFeedbackMap().values()) {
				if (fig instanceof DragFeedbackFigure) {
					DragFeedbackFigure f = (DragFeedbackFigure) fig;
					Point pt = f.feedbackRect.getTopLeft();
					upperLeftPt.x = pt.x < upperLeftPt.x ? pt.x : upperLeftPt.x;
					upperLeftPt.y = pt.y < upperLeftPt.y ? pt.y : upperLeftPt.y;
				}
			}
			// if the top/left feedback is < the to container's top/left, save the difference 
			// to be applied to the feedback position when the move/copy is done
			if (upperLeftPt.x < toContainerPt.x) {
				zeroAdjustment.x = toContainerPt.x - upperLeftPt.x;
			}
			if (upperLeftPt.y < toContainerPt.y) {
				zeroAdjustment.y = toContainerPt.y - upperLeftPt.y;
			}
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.draw2d.Shape#fillShape(org.eclipse.draw2d.Graphics)
	 */
	protected void fillShape(Graphics g) {
		Rectangle r = feedbackRect;

		boolean xor = g.getXORMode();
		g.setXORMode(true);
		g.setBackgroundColor(ghostFillColor);
		g.fillRectangle(r);
		g.setXORMode(xor);

		// draw image and name centered in feedback shape
		int x = r.x + (feedbackRect.width - nameSize.width) / 2;
		if (x < r.x) {
			x = r.x;
		}
		int y = r.y + (feedbackRect.height - 16) / 2;
		if (y < r.y) {
			y = r.y;
		}
		if (image != null) {
			org.eclipse.swt.graphics.Rectangle imgRect = image.getBounds();
			g.drawImage(image, 0, 0, imgRect.width, imgRect.height, x, y, 16, 16);
		}

		g.setFont(memberFont);
		g.drawText(name, x + 19, y);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.draw2d.Shape#outlineShape(org.eclipse.draw2d.Graphics)
	 */
	protected void outlineShape(Graphics g) {
		Rectangle r = feedbackRect.getCopy();
		r.shrink(1, 1);

		boolean xor = g.getXORMode();
		g.setXORMode(true);
		g.setForegroundColor(ColorConstants.white);
		g.setLineStyle(Graphics.LINE_DOT);
		g.drawRectangle(r);
		g.setXORMode(xor);
	}

	/**
	 * determine if this editpart is a member of a container
	 * 
	 * @param childEP
	 * @return container
	 */
	protected DeployShapeNodeEditPart getFromContainer(GraphicalEditPart childEP) {
		EditPart parent = childEP.getParent();
		if (parent instanceof DeployCoreCompartmentEditPart) {
			if (parent.getParent() instanceof DeployShapeNodeEditPart) {
				return (DeployShapeNodeEditPart) parent.getParent();
			}
		} else if (parent instanceof DeployListCompartmentEditPart) {
			if (parent.getParent() instanceof DeployShapeNodeEditPart) {
				return (DeployShapeNodeEditPart) parent.getParent();
			}
		}
		return null;
	}

	/**
	 * return the container that the rectangle is on top of
	 * 
	 * @param childEP
	 * @param pt
	 * @return container
	 */
	protected DeployShapeNodeEditPart getToContainer(GraphicalEditPart childEP, Point pt) {
		List<?> selectedEPs = childEP.getViewer().getSelectedEditParts();

		// see if feedback rect hasn't fully left a container
		// don't leave immediately because container may be within another container
		DeployShapeNodeEditPart fromContainerEP = null;
		Rectangle fromContainerRect = null;
		boolean intersects = false;
		if (childEP.getParent() instanceof DeployCoreCompartmentEditPart
				|| childEP.getParent() instanceof ImportListCompartmentEditPart
				|| childEP.getParent() instanceof DiagramListCompartmentEditPart
				|| childEP.getParent() instanceof HybridListCompartmentFigure) {
			ResizableCompartmentEditPart cntrCmpEP = (ResizableCompartmentEditPart) childEP
					.getParent();
			fromContainerEP = (DeployShapeNodeEditPart) cntrCmpEP.getParent();
			ResizableCompartmentFigure figure = (ResizableCompartmentFigure) cntrCmpEP.getFigure();
			fromContainerRect = figure.getBounds().getCopy();
			figure.translateToAbsolute(fromContainerRect);
			this.translateToRelative(fromContainerRect);
			intersects = fromContainerRect.intersects(feedbackRect);
		}

		// try finding to container at feedbackrect
		IFigure fig;
		int tries = 0;
		IFigure diagramFigure = diagramEP.getFigure();
		List list = new ArrayList();
		IFigure f = childEP.getFigure();
		if (f instanceof CompositeShapeFigure) {
			CompositeShapeFigure csf = (CompositeShapeFigure) f;
			list.add(csf.getInnerFigure());
		}
		boolean foundSomething = false;
		while ((fig = diagramFigure.findFigureAtExcluding(pt.x, pt.y, list)) != null && tries++ < 5) {
			if (!foundSomething) {
				foundSomething = !(fig instanceof DeployDiagramFigure);
			}
			// dropped on a units' compartment?
			if (fig.getParent() != null) {
				IFigure grandParent = fig.getParent().getParent();
				// Is on a shapes compartment?
				// if feedback figure is completely contained by a group area, return the group
				if (grandParent instanceof ShapeCompartmentFigure) {
					ShapeCompartmentFigure figure = (ShapeCompartmentFigure) grandParent;
					Rectangle toContainerRect = figure.getBounds().getCopy();
					figure.translateToAbsolute(toContainerRect);
					this.translateToRelative(toContainerRect);
					// if toGroup fully contains feedback rect
					if (toContainerRect.contains(feedbackRect)) {
						// one last check -- if feedbackrect hasn't left the fromGroup 
						// but the toGroupRect is contained by the fromGroupRect, then it's ok
						if (intersects && !fromContainerRect.contains(toContainerRect)) {
							break;
						}
						DeployCoreCompartmentEditPart cntrCmpEP = (DeployCoreCompartmentEditPart) childEP
								.getViewer().getVisualPartMap().get(figure);
						DeployShapeNodeEditPart toContainer = (DeployShapeNodeEditPart) cntrCmpEP
								.getParent();
						// no parent of this candidate can be selected
						if (!isAnyParentSelected(toContainer, selectedEPs)
								&& !_attachmentSlaveFeedbackEPList.contains(toContainer)) {
							// a selected ep is not valid
							return toContainer;
						}
					}
					// Else find a container inside a figure
				} else if (fig instanceof DeployListItemFigure || fig instanceof DeployCoreFigure) {
					IGraphicalEditPart targetEP = (IGraphicalEditPart) childEP.getViewer()
							.getVisualPartMap().get(fig.getParent());
					if (targetEP != null && targetEP != childEP) {
						// make sure it has a list or shapes compartment
						IGraphicalEditPart ep = targetEP
								.getChildBySemanticHint(DeployCoreConstants.HYBRIDLIST_SEMANTICHINT);
						if (ep == null) {
							ep = targetEP
									.getChildBySemanticHint(DeployCoreConstants.HYBRIDSHAPES_SEMANTICHINT);
						}
						// no parent of this candidate can be selected
						if (ep != null && !isAnyParentSelected(targetEP, selectedEPs)
								&& !_attachmentSlaveFeedbackEPList.contains(targetEP)) {
							return (DeployShapeNodeEditPart) targetEP;
						}
					}
				}
			}
			// one more figure to ignore
			list.add(fig);
		}

		// only options now are diagram or the fromGroup
		// if there was an intersect above, use fromGroup
		if (intersects) {
			return fromContainerEP;
		}

		// else use diagram
		return foundSomething ? this.fromContainerEP : null;
	}

	// a currently selected editpart is not a valid destination of a move/copy
	private boolean isAnyParentSelected(EditPart toContainer, List<?> selectedEPs) {
		EditPart walker = toContainer;
		while (walker != null) {
			if (walker instanceof DeployDiagramEditPart) {
				return false;
			} else if (selectedEPs.contains(walker)) {
				return true;
			}
			walker = walker.getParent();
		}
		return false;
	}

	/**
	 * @param pos
	 */
	public void setPosition(Point pos) {
		// determine the feedback point in logical units
		position = pos.getCopy();
		IFigure container = diagramEP.getContentPane();
		container.translateToRelative(position);
		container.translateFromParent(position);

		// determine the feedback point in device units
		positionD = pos.getCopy();
		PrecisionPoint d = new PrecisionPoint(0, 0);
		IFigure figure = LayerManager.Helper.find(diagramEP).getLayer(LayerConstants.SCALABLE_LAYERS);
		figure.translateToRelative(d);
		positionD.translate(d.x, d.y);

		// if this drag feedback figure is part of an attachment, move all attachments too
		setAttachmentPositions(pos);
	}

	/*
	 * see if this unit already exists in this container (diagram/group/contceptual node)
	 */
	private boolean isInContainer(IGraphicalEditPart containerEP, Unit unit) {
		if (DeployShapeNodeEditPart.isShapesMode(containerEP)) {
			containerEP = containerEP
					.getChildBySemanticHint(DeployCoreConstants.HYBRIDSHAPES_SEMANTICHINT);
			if (containerEP == null) {
				return false;
			}
		}
		if (DeployShapeNodeEditPart.isTreeMode(containerEP)) {
			containerEP = containerEP
					.getChildBySemanticHint(DeployCoreConstants.HYBRIDLIST_SEMANTICHINT);
			if (containerEP == null) {
				return false;
			}
		}
		Iterator it = containerEP.getChildren().iterator();
		while (it.hasNext()) {
			Object o = it.next();
			if (o instanceof IGraphicalEditPart) {
				IGraphicalEditPart ep = (IGraphicalEditPart) o;
				if (unit == ViewUtil.resolveSemanticElement((View) ep.getModel())) {
					return true;
				}
			}
		}
		return false;
	}

// =============================================================================================================================
// ================================ ATTACHMENT SUPPORT ================================================================================
// =============================================================================================================================

	// find a diagram child that intersects with this EditPart
	private GraphicalEditPart getTouchingEditPart(GraphicalEditPart ep, Rectangle rect,
			List<?> children) {

		// slaves are already touching
		List<EditPart> slaveEPList = new ArrayList<EditPart>();
		for (DragFeedbackFigure fig : _myAttachmentSlaveFeedbackList) {
			slaveEPList.add(fig.movedPart);
		}

		int max = 0;
		GraphicalEditPart maxEP = null;
		for (Iterator<?> it = children.iterator(); it.hasNext();) {
			Object o = it.next();
			if (!ep.equals(o) && !slaveEPList.contains(o) && o instanceof DeployShapeNodeEditPart) {
				DeployShapeNodeEditPart dep = (DeployShapeNodeEditPart) o;
				IFigure figure = dep.getFigure();
				Rectangle childRect = figure.getBounds().getCopy();
				figure.translateToAbsolute(childRect);
				childRect.expand(5, 5);
				translateToRelative(childRect);
				Rectangle r = childRect.getIntersection(feedbackRect);
				// they touch
				if (!r.isEmpty()) {
					if (r.width > max || r.height > max) {
						max = Math.max(r.width, r.height);
						maxEP = dep;
					}
				}
			}
		}
		return maxEP;
	}

	private void setAttachmentPositions(Point pos) {
		if (_myAttachmentSlaveFeedbackList.size() > 0) {
			for (DragFeedbackFigure fig : _myAttachmentSlaveFeedbackList) {
				Dimension delta = (Dimension) MapModeUtil.getMapMode().LPtoDP(
						fig.getOriginalPt().getDifference(originalPt));
				Point attachPos = pos.getCopy().translate(delta);
				fig.setPosition(attachPos);
			}
		}
	}

	private void setAttachmentBounds(Point newPt) {
		if (_myAttachmentSlaveFeedbackList.size() > 0) {
			for (DragFeedbackFigure fig : _myAttachmentSlaveFeedbackList) {
				Point delta = new Point(newPt.x - originalRect.x, newPt.y - originalRect.y);
				Rectangle rect = fig.getOriginalRect().getCopy().translate(delta);
				fig.setBounds(rect);
			}
		}
	}

	private void setSlaveFeedbackVisible(boolean b) {
		for (DragFeedbackFigure fig : _myAttachmentSlaveFeedbackList) {
			fig.setVisible(b);
		}
	}

	/**
	 * @return get the name on this feedback figure
	 */
	public String getName() {
		return name;
	}

	/**
	 * @return get the top/left point of this feedback figure
	 */
	public Point getOriginalPt() {
		return originalPt;
	}

	/**
	 * @return get original figure's bounds
	 */
	public PrecisionRectangle getOriginalRect() {
		return originalRect;
	}

	// if dragging a view with attachments, drag the other views too
	@Override
	public void addNotify() {
		// add tooltip figure
		IFigure feedbackLayer = getParent();
		if (_tooltip == null) {
			_tooltip = new DragFeedbackTooltip(diagramEP);
			feedbackLayer.add(_tooltip);
		}

		// if this isn't an attachment slave
		if (!_isAttachmentSlaveFeedback) {
			DeployStyle style = (DeployStyle) movedView.getStyle(DeployNotationPackage.eINSTANCE
					.getDeployStyle());
			if (style.getSnapParent() != null) {
				hasAttachments = true;
				EditPartViewer viewer = diagramEP.getViewer();
				Map<?, ?> v2eMap = viewer.getEditPartRegistry();
				List<?> selectedList = viewer.getSelectedEditParts();
				for (Iterator<?> it = com.ibm.ccl.soa.deploy.core.ui.util.ViewUtil
						.getAllSnapGroupViews(movedView).iterator(); it.hasNext();) {
					GraphicalEditPart ep = (GraphicalEditPart) v2eMap.get(it.next());

					// don't bother if already being dragged-- either because it's selected or
					// because another feedback figure has created this slave
					if (!selectedList.contains(ep) && !_attachmentSlaveFeedbackEPList.contains(ep)) {
						DragFeedbackFigure fig = new DragFeedbackFigure(ep, true);
						feedbackLayer.add(fig, 0);
						_attachmentSlaveFeedbackList.add(fig);
						_attachmentSlaveFeedbackEPList.add(ep);
						_myAttachmentSlaveFeedbackList.add(fig);
					}
				}
			}
		}
		super.addNotify();
	}

	// if dragging attachments, remove attached views from feedback layer
	@Override
	public void removeNotify() {
		// remove tooltip figure
		IFigure feedbackLayer = getParent();
		if (_tooltip != null) {
			feedbackLayer.remove(_tooltip);
			_tooltip = null;
		}

		if (!_isAttachmentSlaveFeedback && !_myAttachmentSlaveFeedbackList.isEmpty()) {
			for (DragFeedbackFigure fig : _myAttachmentSlaveFeedbackList) {
				feedbackLayer.remove(fig);
			}
			_attachmentSlaveFeedbackList.clear();
			_attachmentSlaveFeedbackEPList.clear();
		}
		super.removeNotify();
	}

	/**
	 * @return will an attach/detach be done by this feedback (the AttachViewCommand be used)
	 */
	public boolean isValidAttachmentCommand() {
		return isAttachCommand || isDetachCommand;
	}

	/**
	 * @return will this current feedback position cause its slave feedbacks to be moved? (should the
	 *         position of slaves be changed)
	 */
	public boolean isValidAttachmentMove() {
		// currently has slave feedbacks, and this is not an attach/detach gesture && not moving into a container 
		return _myAttachmentSlaveFeedbackList.size() > 0 && !isValidAttachmentCommand()
				&& (toContainerEP == null || toContainerEP == fromContainerEP);
	}

	/**
	 * @return command to attach or detach this view
	 */
	public Command getAttachCommand() {
		TransactionalEditingDomain editingDomain = ((IGraphicalEditPart) movedPart)
				.getEditingDomain();
		return new ICommandProxy(new SnapViewCommand(editingDomain, feedbackRectL, movedPart,
				touchingPart, toContainerEP, isAttachCommand));
	}

// =============================================================================================================================
// ================================ CREATE COMMANDS ================================================================================
// =============================================================================================================================

	/**
	 * no isMoveCommand-- the opposite of isCopyCommand
	 * 
	 * @return is copy command
	 */
	public boolean isCopyCommand() {
		return isActualCopyCommand;
	}

	/**
	 * @return is too many of this unit in this diagram or container
	 */
	public boolean isIllegalMoveCommand() {
		return isIllegalMoveCommand;
	}

	/**
	 * adds any container processing commands to a move or drop command for this host
	 * 
	 * @param cmd
	 * @param host
	 * @return COmmand
	 */
	public static Command addContainerCommands(Command cmd, EditPart host) {
		DeployDiagramEditPart ddep = GMFUtils.getDeployDiagramEditPart(host);
		Map map = ddep.getMoveFeedbackMap();
		final DragFeedbackFigure feedback = (DragFeedbackFigure) map.get(host);
		if (feedback != null) {
			if (feedback.isIllegalMoveCommand()) {
				cmd = new ICommandProxy(new AbstractTransactionalCommand(ddep.getEditingDomain(),
						"", null) {//$NON-NLS-1$
							protected CommandResult doExecuteWithResult(IProgressMonitor monitor,
									IAdaptable info) {
								return CommandResult
										.newErrorCommandResult(Messages.CANNOT_ADD_TO_CONTAINER);
							}
						});
			} else {
				// we don't create the actual commands until the user releases the mouse
				// otherwise we don't know whether the alt key is press or not (do a move or a copy)
				if (feedback.isValidMoveOrCopy() || feedback.isValidAttachmentCommand()) {
					Command c = new ICommandProxy(new AbstractTransactionalCommand(ddep
							.getEditingDomain(), "", null) {//$NON-NLS-1$

								@Override
								protected IStatus doRedo(IProgressMonitor monitor, IAdaptable info)
										throws ExecutionException {
									IStatus status = super.doRedo(monitor, info);
									CanonicalUtils.refreshLinks(feedback.diagramEP);
									return status;
								}

								@Override
								protected IStatus doUndo(IProgressMonitor monitor, IAdaptable info)
										throws ExecutionException {
									IStatus status = super.doUndo(monitor, info);
									CanonicalUtils.refreshLinks(feedback.diagramEP);
									return status;
								}

								protected CommandResult doExecuteWithResult(IProgressMonitor monitor,
										IAdaptable info) {
									feedback.adjustFeedbackRect();
									// add a command to attach/detach the view?
									if (feedback.isAttachCommand || feedback.isDetachCommand) {
										feedback.getAttachCommand().execute();
									}
									// if detach, still allow move/copy in same action
									if (!feedback.isAttachCommand) {
										Command c = null;
										if (feedback.isCopyCommand()) {
											c = feedback.getContainerCopyCommands();
										} else {
											c = feedback.getContainerMoveCommands();
										}
										if (c != null) {
											c.execute();
										}
									}
									return CommandResult.newOKCommandResult();
								}
							});
					if (cmd != null) {
						cmd = cmd.chain(c);
					} else {
						cmd = c;
					}
				}
				if (feedback.isValidAttachmentMove()) {
					Command c = new ICommandProxy(new AbstractTransactionalCommand(ddep
							.getEditingDomain(), "", null) {//$NON-NLS-1$
								protected CommandResult doExecuteWithResult(IProgressMonitor monitor,
										IAdaptable info) {

									// get offset that master view was moved
									int x = ((Integer) ViewUtil.getStructuralFeatureValue(
											feedback.movedView, NotationPackage.eINSTANCE.getLocation_X()))
											.intValue();
									int y = ((Integer) ViewUtil.getStructuralFeatureValue(
											feedback.movedView, NotationPackage.eINSTANCE.getLocation_Y()))
											.intValue();
									Point newPt = new Point(x, y);
									Dimension delta = newPt.getDifference(feedback.originalPt);

									// move each slave feedback figure 
									for (DragFeedbackFigure fig : feedback._myAttachmentSlaveFeedbackList) {
										Point loc = fig.originalPt.translate(delta);
										ViewUtil.setStructuralFeatureValue(fig.getMovedView(),
												NotationPackage.eINSTANCE.getLocation_X(), new Integer(loc.x));
										ViewUtil.setStructuralFeatureValue(fig.getMovedView(),
												NotationPackage.eINSTANCE.getLocation_Y(), new Integer(loc.y));

									}
									feedback._myAttachmentSlaveFeedbackList.clear();

									// make sure attached views are aligned
									ArrangeSnappedViewsCommand.arrangeSnappedViews(feedback.movedView,
											feedback.movedPart.getViewer(), 0, null);

									return CommandResult.newOKCommandResult();
								}
							});
					if (cmd != null) {
						cmd = cmd.chain(c);
					} else {
						cmd = c;
					}
				}
			}
		}
		return cmd;
	}

	/*
	 * make sure a unit(s) being dragged into a container is not placed < 0,0
	 */
	protected void adjustFeedbackRect() {
		feedbackRect.translate(zeroAdjustment);
	}

	/**
	 * @return will a move or copy command be created for the current feedback figure location
	 */
	public boolean isValidMoveOrCopy() {
		// if moving out of a container 
		boolean fromContainerRefresh = fromContainerEP != null && fromContainerEP != toContainerEP;
		// if moving into another container
		boolean toContainerRefresh = toContainerEP != null && fromContainerEP != toContainerEP;
		return !isIllegalMoveCommand && fromContainerRefresh || toContainerRefresh;
	}

	/**
	 * if feedback figure has determined that unit is moving to a container, add the necessary
	 * commands
	 * 
	 * @return command
	 */
	public Command getContainerMoveCommands() {
		TransactionalEditingDomain editingDomain = ((IGraphicalEditPart) movedPart)
				.getEditingDomain();
		/*
		 * create commands to do move
		 */
		if (isValidMoveOrCopy()) {
			if (_useShowOnHostCommand) {
				return new ICommandProxy(new ShowOrNotShowUnitOnHostCommand(
						(DeployShapeNodeEditPart) movedPart));
			} else {
				return new ICommandProxy(new MoveViewCommand(editingDomain, diagramEP, toContainerEP,
						fromContainerEP, movedPart, _containedViewSet, feedbackRectL, isDuplicateView,
						(View) movedView.eContainer()));
			}
		}
		return null;
	}

	/**
	 * if feedback figure has determined that unit is being copied to a container, add the necessary
	 * commands
	 * 
	 * @param cmd
	 * @param child
	 * @return container appended command
	 */
	public Command getContainerCopyCommands() {
		Command cmd = null;
		if (isValidMoveOrCopy()) {
			TransactionalEditingDomain editingDomain = ((IGraphicalEditPart) movedPart)
					.getEditingDomain();

			ICommand command = null;

			// if copying from an Import, Import Diagram or Diagram Node, we will do a visualize command
			// however for copy from import topology in shapes mode, since they share containmentstatemap with main
			// diagram, just do a copyviewcommand
			if (GMFUtils.isImportTreeTopology(movedPart) || GMFUtils.isDiagramTreeNode(movedPart)) {

				// collect all units below this unit in this branch
				Map<Unit, UnitLinkData> linkCacheMap = diagramEP.getSemanticCacheData()
						.getLinkCacheMap();
				// is import/diagram in shape mode?
				List<DeployModelObject> dmoList = getBranchUnits(linkCacheMap, movedPart);

				// if this is from an import, get the visible list
				List visibleUnits = null;
				if (GMFUtils.isImportTopology(movedPart)) {
					Import imprt = (Import) GMFUtils.getImportTopologyEP(movedPart)
							.resolveSemanticElement();
					InstanceConfiguration instanceConfig = imprt.getInstanceConfiguration();
					visibleUnits = diagramEP.getSemanticCacheData().getImportCacheMap().get(
							instanceConfig);
				}

				// if there's a source diagram we use VisualizeFromNotationalCommand
				Diagram sourceDiagram = GMFUtils.getDiagram(movedPart);
				IGraphicalEditPart targetEP = toContainerEP == null ? diagramEP : toContainerEP;
				Point loc = feedbackRectL.getTopLeft();
				if (!(targetEP instanceof DeployDiagramEditPart)) {
					IGraphicalEditPart ep = targetEP
							.getChildBySemanticHint(DeployCoreConstants.HYBRIDLIST_SEMANTICHINT);
					if (ep == null) {
						ep = targetEP
								.getChildBySemanticHint(DeployCoreConstants.HYBRIDSHAPES_SEMANTICHINT);
					}
					targetEP = ep;
				}

				if (sourceDiagram != null) {
					command = new VisualizeFromNotationalCommand(editingDomain, targetEP, dmoList,
							visibleUnits, sourceDiagram, loc, true, false, null, originalPt);
				} else {
					// else we use VisualizeFromSemanticCommand
					command = new VisualizeFromSemanticCommand(editingDomain, targetEP, dmoList, null,
							loc, null, originalPt);

				}
				// else we just do a copy view command
			} else {
				command = new CopyViewCommand(editingDomain, diagramEP, toContainerEP, fromContainerEP,
						movedPart, _containedViewSet, movedView, originalPt, feedbackRectL,
						(View) movedView.eContainer());
			}
			cmd = new ICommandProxy(command);

		}
		return cmd;
	}

	private List<DeployModelObject> getBranchUnits(Map<Unit, UnitLinkData> linkCacheMap,
			GraphicalEditPart ep) {
		List<DeployModelObject> dmoList = new ArrayList<DeployModelObject>();
		Unit host = (Unit) ep.resolveSemanticElement();
		dmoList.add(host);
		getBranchUnitsHelper(ep, host, dmoList, linkCacheMap, GMFUtils.isImportTopology(ep));
		return dmoList;
	}

	private void getBranchUnitsHelper(GraphicalEditPart ep, Unit host,
			List<DeployModelObject> dmoList, Map<Unit, UnitLinkData> linkCacheMap,
			boolean isImportTopologyEP) {
		for (Unit hosted : GMFUtils.getAllHostees(host)) {
			if (!isImportTopologyEP || PropertyUtils.isProxy(hosted)) {
				// add to external stack only if not contained
				if (!ContainmentStateUtils.isContainedUnit(ep, hosted)) {
					//' if a unit is already in the diagram, end visualization there
					if (toContainerEP == null && isAlreadyOnCanvas(hosted)) {
						continue;
					}
					dmoList.add(hosted);
				}
				// keep going up the stack
				getBranchUnitsHelper(ep, hosted, dmoList, linkCacheMap, isImportTopologyEP);
			}
		}

	}

	private boolean isAlreadyOnCanvas(Unit unit) {
		for (Iterator it = diagramEP.getChildren().iterator(); it.hasNext();) {
			EditPart ep = (EditPart) it.next();
			if (ep instanceof DeployShapeNodeEditPart) {
				if (((DeployShapeNodeEditPart) ep).resolveSemanticElement().equals(unit)) {
					return true;
				}
			}
		}
		return false;
	}
}
