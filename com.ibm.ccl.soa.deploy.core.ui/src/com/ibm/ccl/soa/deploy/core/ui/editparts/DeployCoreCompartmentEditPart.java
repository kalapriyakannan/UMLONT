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

import org.eclipse.draw2d.FigureCanvas;
import org.eclipse.draw2d.IFigure;
import org.eclipse.draw2d.Locator;
import org.eclipse.draw2d.geometry.Dimension;
import org.eclipse.draw2d.geometry.Insets;
import org.eclipse.draw2d.geometry.Point;
import org.eclipse.draw2d.geometry.Rectangle;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.gef.EditPart;
import org.eclipse.gef.EditPolicy;
import org.eclipse.gmf.runtime.diagram.core.util.ViewUtil;
import org.eclipse.gmf.runtime.diagram.ui.editparts.ShapeCompartmentEditPart;
import org.eclipse.gmf.runtime.diagram.ui.editpolicies.EditPolicyRoles;
import org.eclipse.gmf.runtime.diagram.ui.figures.ResizableCompartmentFigure;
import org.eclipse.gmf.runtime.notation.NotationPackage;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.swt.widgets.Display;

import com.ibm.ccl.soa.deploy.core.ui.editpolicies.DeployContainerEditPolicy;
import com.ibm.ccl.soa.deploy.core.ui.editpolicies.DeployResizableEditPolicyEx;
import com.ibm.ccl.soa.deploy.core.ui.editpolicies.DeployShapeCompartmentDropEditPolicy;
import com.ibm.ccl.soa.deploy.core.ui.editpolicies.DeployXYLayoutEditPolicy;
import com.ibm.ccl.soa.deploy.core.ui.figures.DeployCoreCompartmentFigure;
import com.ibm.ccl.soa.deploy.core.ui.internal.commands.ArrangeSnappedViewsCommand;
import com.ibm.ccl.soa.deploy.core.ui.notation.DeployNotationPackage;
import com.ibm.ccl.soa.deploy.core.ui.notation.DeployStyle;
import com.ibm.ccl.soa.deploy.core.ui.util.DeployCoreConstants;
import com.ibm.ccl.soa.deploy.core.ui.util.GEFUtils;
import com.ibm.ccl.soa.deploy.core.ui.util.GMFUtils;
import com.ibm.ccl.soa.deploy.core.ui.util.LayoutUtils;
import com.ibm.ccl.soa.deploy.core.ui.util.SnapUtils;

/**
 * Compartment within a shape that contains other shapes.
 */
public abstract class DeployCoreCompartmentEditPart extends ShapeCompartmentEditPart {
	private DeployConnectionRefreshMgr _crMgr = null;
	private boolean _refreshConnections = false;
	private Rectangle _oldBounds = null;

	/**
	 * @param view
	 */
	public DeployCoreCompartmentEditPart(View view) {
		super(view);
	}

	public IFigure createFigure() {
		DeployCoreCompartmentFigure scf = new DeployCoreCompartmentFigure(null, getMapMode());
		scf.getContentPane().setLayoutManager(getLayoutManager());
		return scf;
	}

	// if user tries to lasso select units in group but misses
	// don't select group compartment instead
	public void setSelected(int value) {
	}

	protected void createDefaultEditPolicies() {
		super.createDefaultEditPolicies();

		//Remove pop up bar on the figures
		removeEditPolicy(EditPolicyRoles.POPUPBAR_ROLE);
		// kill those connector handles and add our own!!!
		removeEditPolicy(EditPolicyRoles.CONNECTION_HANDLES_ROLE);

		// use our own DeploySetBoundsCommand
		removeEditPolicy(EditPolicy.LAYOUT_ROLE);
		installEditPolicy(EditPolicy.LAYOUT_ROLE, new DeployXYLayoutEditPolicy());

		// override to provide support for arranging groups
		removeEditPolicy(EditPolicy.CONTAINER_ROLE);
		installEditPolicy(EditPolicy.CONTAINER_ROLE, new DeployContainerEditPolicy());

		installEditPolicy(EditPolicy.SELECTION_FEEDBACK_ROLE, new DeployResizableEditPolicyEx());

		// force drop from navigator onto compartment to use AddToTopologyCommand
		installEditPolicy(EditPolicyRoles.DRAG_DROP_ROLE, new DeployShapeCompartmentDropEditPolicy());
	}

	/**
	 * @return the connection manager for this compartment
	 */
	public DeployConnectionRefreshMgr getConnectionManager() {
		if (_crMgr == null) {
			_crMgr = new DeployConnectionRefreshMgr();
		}
		return _crMgr;
	}

	/**
	 * when link refreshes itself, also refresh collapsed anchors
	 */
	public void refreshCollapsedLinks() {
		refreshConnections();
	}

	/**
	 * Refresh the connections associated the the children of this shape compartment.
	 */
	protected void refreshConnections() {
		if (!_refreshConnections) {
			_refreshConnections = true;
			Display.getDefault().asyncExec(new Runnable() {

				public void run() {
					forceRefreshConnections();
				}
			});
		}
	}

	/**
	 * Refresh the connections associated the the children of this shape compartment.
	 */
	protected void forceRefreshConnections() {
		try {
			//
			if (DeployCoreCompartmentEditPart.this.isActive()) {
				getConnectionManager().refreshConnections(DeployCoreCompartmentEditPart.this);
			}
		} finally {
			_refreshConnections = false;
		}

	}

	/*
	 * if size of parent changes, change location of compartment
	 * 
	 * @see org.eclipse.gmf.runtime.diagram.ui.editparts.GraphicalEditPart#refresh()
	 */
	public void refresh() {
		super.refresh();
		refreshBounds();
		refreshConnections();
	}

	protected void handleNotificationEvent(Notification notification) {
		Object feature = notification.getFeature();
		if (NotationPackage.eINSTANCE.getSize_Width().equals(feature)
				|| NotationPackage.eINSTANCE.getSize_Height().equals(feature)) {
			refreshBounds();
			refreshConnections();
		} else if (NotationPackage.eINSTANCE.getDrawerStyle_Collapsed().equals(feature)) {
			FigureCanvas fc = (FigureCanvas) getViewer().getControl();
			fc.setRedraw(false);
			super.handleNotificationEvent(notification);
			setCollapsed(notification.getNewBooleanValue());
			fc.setRedraw(true);
		} else {
			super.handleNotificationEvent(notification);
		}
	}

	/**
	 * when twistie is pressed, resize list compartment
	 */
	public void refreshBounds() {
		getFigure().getParent().setConstraint(getFigure(), new Locator() {
			public void relocate(IFigure target) {
				ResizableCompartmentFigure f = (ResizableCompartmentFigure) target;
				IFigure parent = target.getParent().getParent();
				Rectangle r = parent.getBounds().getCopy();
				parent.translateToAbsolute(r);
				target.translateToRelative(r);

				int hdrHeight = GEFUtils.getShapesHeaderHeight(parent);
				r.y += hdrHeight;
				// if unit is expanded, retain whatever size the list compartment currently has
				if (f.isExpanded()) {
					r.height -= hdrHeight + DeployCoreConstants.SHAPES_UNIT_INSET / 2;
					r.y += DeployCoreConstants.SHAPES_UNIT_INSET / 2;
					r = r.crop(new Insets(DeployCoreConstants.SHAPES_UNIT_INSET));
				} else {
					r.width = 0;
					r.height = 0;
				}
				target.setBounds(r);
			}
		});
	}

	/*
	 * when twistie is pressed, resize unit figure
	 */
	protected void setCollapsed(final boolean isCollapsed) {
		final DeployShapeNodeEditPart shapesEP = (DeployShapeNodeEditPart) getParent();
		View view = (View) shapesEP.getModel();
		int x = ((Integer) ViewUtil.getStructuralFeatureValue(view, NotationPackage.eINSTANCE
				.getLocation_X())).intValue();
		int y = ((Integer) ViewUtil.getStructuralFeatureValue(view, NotationPackage.eINSTANCE
				.getLocation_Y())).intValue();
		int width = ((Integer) ViewUtil.getStructuralFeatureValue(view, NotationPackage.eINSTANCE
				.getSize_Width())).intValue();
		int height = ((Integer) ViewUtil.getStructuralFeatureValue(view, NotationPackage.eINSTANCE
				.getSize_Height())).intValue();

		View topSnapView = null;
		EditPart topEP = GEFUtils.getTopEditPart(shapesEP);
		if (topEP instanceof DeployShapeNodeEditPart
				&& ((DeployShapeNodeEditPart) topEP).isInSnapGroup()) {
			topSnapView = (View) topEP.getModel();
			_oldBounds = LayoutUtils.getViewBounds(topSnapView);
			if (_oldBounds.width == -1 || _oldBounds.height == -1) {
				_oldBounds = SnapUtils.getEditPartBounds((DeployShapeNodeEditPart) topEP);
			}
		}

		Point loc = new Point(x, y);
		Dimension size = new Dimension(width, height);
		DeployStyle style = (DeployStyle) view.getStyle(DeployNotationPackage.eINSTANCE
				.getDeployStyle());
		// if collapsed, save current size and set size to -1,-1
		if (isCollapsed) {
			size = style != null ? new Dimension(style.getCollapseWidth(), style.getCollapseHeight())
					: new Dimension(-1, -1);
		} else {
			size = style != null ? new Dimension(style.getExpandWidth(), style.getExpandHeight())
					: new Dimension(-1, -1);

			// if no saved expanded size, autosize
			if (size.width == -1 || size.height == -1) {
				Dimension saveSize = size.getCopy();
				size = new Dimension(width, height);
				// if there are children, conform the size around the children
				int hdrHeight = GEFUtils.getShapesHeaderHeight(shapesEP.getFigure());
				if (getChildren().size() > 0) {
					refreshChildren();
					ResizableCompartmentFigure shapesFig = GMFUtils.getShapesFigure(shapesEP);
					size = shapesFig.getPreferredSize();
					size.width += DeployCoreConstants.SHAPES_UNIT_INSET * 6;
					size.height += hdrHeight + DeployCoreConstants.SHAPES_UNIT_INSET * 10;
				}
				if (size.height < DeployCoreConstants.UNIT_NEW_SHAPES_HEIGHT) {
					size.height = DeployCoreConstants.UNIT_NEW_SHAPES_HEIGHT;
				}
				if (size.width < DeployCoreConstants.UNIT_NEW_SHAPES_WIDTH) {
					size.width = DeployCoreConstants.UNIT_NEW_SHAPES_WIDTH;
				}

				// if the width is not as wide as the collapsed figure width with the unit name, make it that width now
				int topWidth = shapesEP.getFigure().getBounds().width;
				if (topWidth > size.width) {
					size.width = topWidth;
				}

				if (saveSize.width != -1) {
					size.width = saveSize.width;
				}
			}
		}

		// set this group's bounds and enlarge any containing group
		LayoutUtils.setViewBoundsAndLayout(shapesEP, loc, size, null, false);

		// if this view is part of an attachment, make sure all attachments are still aligned
		if (topSnapView != null) {
			ArrangeSnappedViewsCommand.arrangeSnappedViewsDelayed(getEditingDomain(), topSnapView,
					_oldBounds, SnapUtils.COMPARTMENT_CHANGE, shapesEP.getViewer());
		}

		final EditPart selectedEP = getParent();
		Display.getDefault().asyncExec(new Runnable() {
			public void run() {
				// re-layout connectors
				GEFUtils.layoutConnectors();
				// if expanding, reveal all of group
				if (!isCollapsed) {
					EditPart topEP = GEFUtils.getTopEditPart(selectedEP);
					if (topEP != null) {
						selectedEP.getViewer().reveal(topEP);
					}
				}
			}
		});
	}

	protected boolean hasModelChildrenChanged(Notification evt) {
		return false;
	}

}
