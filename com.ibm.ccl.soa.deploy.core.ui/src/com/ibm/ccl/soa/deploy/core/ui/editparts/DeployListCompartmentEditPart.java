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

import java.beans.PropertyChangeEvent;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.eclipse.draw2d.FigureCanvas;
import org.eclipse.draw2d.FigureListener;
import org.eclipse.draw2d.IFigure;
import org.eclipse.draw2d.Locator;
import org.eclipse.draw2d.RangeModel;
import org.eclipse.draw2d.geometry.Dimension;
import org.eclipse.draw2d.geometry.Insets;
import org.eclipse.draw2d.geometry.Point;
import org.eclipse.draw2d.geometry.Rectangle;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.gef.ConnectionEditPart;
import org.eclipse.gef.EditPart;
import org.eclipse.gef.EditPartListener;
import org.eclipse.gef.EditPolicy;
import org.eclipse.gmf.runtime.diagram.core.listener.NotificationUtil;
import org.eclipse.gmf.runtime.diagram.core.util.ViewUtil;
import org.eclipse.gmf.runtime.diagram.ui.editparts.DiagramEditPart;
import org.eclipse.gmf.runtime.diagram.ui.editparts.GraphicalEditPart;
import org.eclipse.gmf.runtime.diagram.ui.editparts.IBorderItemEditPart;
import org.eclipse.gmf.runtime.diagram.ui.editparts.IGraphicalEditPart;
import org.eclipse.gmf.runtime.diagram.ui.editparts.ListCompartmentEditPart;
import org.eclipse.gmf.runtime.diagram.ui.editpolicies.EditPolicyRoles;
import org.eclipse.gmf.runtime.diagram.ui.editpolicies.ResizableEditPolicyEx;
import org.eclipse.gmf.runtime.diagram.ui.internal.editparts.ISurfaceEditPart;
import org.eclipse.gmf.runtime.draw2d.ui.mapmode.MapModeUtil;
import org.eclipse.gmf.runtime.notation.Diagram;
import org.eclipse.gmf.runtime.notation.NotationPackage;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.swt.widgets.Display;

import com.ibm.ccl.soa.deploy.core.DeployModelObject;
import com.ibm.ccl.soa.deploy.core.Unit;
import com.ibm.ccl.soa.deploy.core.ui.editpolicies.DeployContainerEditPolicy;
import com.ibm.ccl.soa.deploy.core.ui.figures.DeployListCompartmentFigure;
import com.ibm.ccl.soa.deploy.core.ui.internal.commands.ArrangeSnappedViewsCommand;
import com.ibm.ccl.soa.deploy.core.ui.notation.DeployNotationPackage;
import com.ibm.ccl.soa.deploy.core.ui.notation.DeployStyle;
import com.ibm.ccl.soa.deploy.core.ui.properties.PropertyUtils;
import com.ibm.ccl.soa.deploy.core.ui.util.DeployCoreConstants;
import com.ibm.ccl.soa.deploy.core.ui.util.GEFUtils;
import com.ibm.ccl.soa.deploy.core.ui.util.GMFUtils;
import com.ibm.ccl.soa.deploy.core.ui.util.LayoutUtils;
import com.ibm.ccl.soa.deploy.core.ui.util.SnapUtils;

/**
 * Holds the Lists that a unit contains.
 */
public class DeployListCompartmentEditPart extends ListCompartmentEditPart implements
		ISurfaceEditPart {
	protected static final int Q = MapModeUtil.getMapMode().DPtoLP(1);
	protected boolean isInnerHostingList = false;
	private boolean isSupportingViewActions = false;
	// anchor on collapsed tree listeners
	private DeployConnectionRefreshMgr _crMgr = null;
	private boolean _refreshConnections = false;
	private Rectangle _oldBounds = null;
	private final EditPartListener editpartListener = new EditPartListener.Stub() {

		private FigureListener childFigureListener = new FigureListener() {

			public void figureMoved(IFigure source) {
//				refreshConnections();
			}
		};

		public void childAdded(EditPart child, int index) {
			((GraphicalEditPart) child).getFigure().addFigureListener(childFigureListener);
		}

		public void removingChild(EditPart child, int index) {
			((GraphicalEditPart) child).getFigure().removeFigureListener(childFigureListener);

		}

	};

	/**
	 * @param view
	 */
	public DeployListCompartmentEditPart(View view) {
		super(view);
		EObject parent = view.eContainer();
		if (parent instanceof View) {
			View parentView = (View) parent;
			// if my grandparent is a hosting list then I'm an inner list
			// heirarchy is always based on Hosting Links, therefore
			// the parent will always be a HostingList View
			EObject grand = parentView.eContainer();
			if (grand instanceof View) {
				View grandView = (View) grand;
				if (!(grandView instanceof Diagram) && grandView.getType() != null) {
					isInnerHostingList = grandView.getType().equals(
							DeployCoreConstants.IMPORTTOPOLOGYLIST_SEMANTICHINT)
							|| grandView.getType()
									.equals(DeployCoreConstants.DIAGRAMNODELIST_SEMANTICHINT)
							|| grandView.getType().equals(DeployCoreConstants.HYBRIDLIST_SEMANTICHINT);
				}
			}
		}
	}

	public void setSelected(int value) {
	}

	protected void createDefaultEditPolicies() {
		super.createDefaultEditPolicies();

		//Remove pop up bar on the figures
		removeEditPolicy(EditPolicyRoles.POPUPBAR_ROLE);
		// kill those connector handles and add our own!!!
		removeEditPolicy(EditPolicyRoles.CONNECTION_HANDLES_ROLE);

		// override to provide support for arranging groups
		removeEditPolicy(EditPolicy.CONTAINER_ROLE);
		installEditPolicy(EditPolicy.CONTAINER_ROLE, new DeployContainerEditPolicy());

		installEditPolicy(EditPolicy.SELECTION_FEEDBACK_ROLE, new ResizableEditPolicyEx());
	}

	protected void refreshShowCompartmentTitle() {
	}

	protected List getModelChildren() {
		List<View> childrenList = new ArrayList(super.getModelChildren());
		Collections.sort(childrenList, new Comparator<View>() {
			public int compare(View v1, View v2) {

				EObject o1 = v1.getElement();
				EObject o2 = v2.getElement();

				// first put views w/o elements at bottom
				if (o1 != null && o2 == null) {
					return -1;
				} else if (o1 == null && o2 != null) {
					return 1;
				} else if (o1 == null && o2 == null) {
					return 0;
				}

				// then sort by config units
				if (o1 instanceof Unit && o2 instanceof Unit) {
					boolean b1 = !((Unit) o1).isConfigurationUnit()
							&& PropertyUtils.isProxy((DeployModelObject) o1);
					boolean b2 = !((Unit) o2).isConfigurationUnit()
							&& PropertyUtils.isProxy((DeployModelObject) o2);
					if (!b1 && b2) {
						return -1;
					} else if (b1 && !b2) {
						return 1;
					}
				}

				// then sort by type
				String t1 = o1.getClass().getSimpleName();
				String t2 = o2.getClass().getSimpleName();
				int x = t1.compareTo(t2);
				if (x != 0) {
					return x;
				}

				// then sort by name
				return GMFUtils.getDmoName(o1).compareToIgnoreCase(GMFUtils.getDmoName(o2));
			}
		});
		return childrenList;
	}

	/**
	 * if bounds change, change location of list
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
		// a new link was added to/deleted from within this compartment
		// fresh attached anchors to this and all the compartments above
		if (NotificationUtil.isElementAddedToSlot(notification)
				|| NotificationUtil.isElementRemovedFromSlot(notification)) {
			refreshConnectionsTree();
		}
	}

	/**
	 * when twistie is pressed, resize list compartment
	 */
	public void refreshBounds() {
		getFigure().getParent().setConstraint(getFigure(), new Locator() {
			public void relocate(IFigure target) {
				DeployListCompartmentFigure f = (DeployListCompartmentFigure) target;
				IFigure parent = target.getParent().getParent();
				Rectangle r = parent.getBounds().getCopy();
				parent.translateToAbsolute(r);
				target.translateToRelative(r);

				// if view sez this is an inner list, skip to bottom
				if (!isInnerHostingList) {
					/////////////////////////////////////////////////////////////
					/////  LIST IN OUTER FIGURE //////// 
					/////////////////////////////////////////////////////////////
					// offset list below header of unit figure
					int hdrHeight = GEFUtils.getListHeaderHeight(parent);
					r.y += hdrHeight;
					// if unit is expanded, retain whatever size the list compartment currently has
					if (f.isExpanded()) {
						r.height -= hdrHeight;
						r = r.crop(new Insets(DeployCoreConstants.SERVER_UNIT_MARGINS));
					} else {
						r.width = 0;
						r.height = 0;
					}
				} else {
					/////////////////////////////////////////////////////////////
					/////  INNER LIST  //////// 
					/////////////////////////////////////////////////////////////
					if (f.isExpanded()) {
						// we create a list of items below the top list item
						// offset inner list just under the +/- button to emulate a tree control effect

						r.x += DeployCoreConstants.LISTITEM_INDENT;
						r.y += GEFUtils.getListItemHeight(parent) + Q;
						r.width -= DeployCoreConstants.LISTITEM_INDENT
								- DeployCoreConstants.SERVER_UNIT_MARGINS / 2;
						r.height = f.getListHeight();
					} else {
						r.width = 0;
						r.height = 0;
					}

				}
				if (r.width < 0) {
					r.width = 0;
				}
				if (r.height < 0) {
					r.height = 0;
				}
				target.setVisible(r.width != 0 && r.height != 0);
				target.setBounds(r);
			}

		});
	}

	/*
	 * when twistie is pressed, resize unit figure
	 */
	private void setCollapsed(final boolean isCollapsed) {
		// if inner list figure, make sure we get the top list ep
		final DeployListCompartmentEditPart topListEP = GMFUtils.getTopList(this);

		// then get its parent which has a view we can resize
		final DeployShapeNodeEditPart unitEP = (DeployShapeNodeEditPart) topListEP.getParent();
		View view = (View) unitEP.getModel();
		int x = ((Integer) ViewUtil.getStructuralFeatureValue(view, NotationPackage.eINSTANCE
				.getLocation_X())).intValue();
		int y = ((Integer) ViewUtil.getStructuralFeatureValue(view, NotationPackage.eINSTANCE
				.getLocation_Y())).intValue();
		int width = ((Integer) ViewUtil.getStructuralFeatureValue(view, NotationPackage.eINSTANCE
				.getSize_Width())).intValue();
		int height = ((Integer) ViewUtil.getStructuralFeatureValue(view, NotationPackage.eINSTANCE
				.getSize_Height())).intValue();

		View topSnapView = null;
		EditPart topEP = GEFUtils.getTopEditPart(unitEP);
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
		if (isCollapsed && !isInnerHostingList) {
			size = style != null ? new Dimension(style.getCollapseWidth(), style.getCollapseHeight())
					: new Dimension(-1, -1);
		} else {
			size = style != null ? new Dimension(style.getExpandWidth(), style.getExpandHeight())
					: new Dimension(-1, -1);

			// if no saved expanded size, autosize
			if (isInnerHostingList || size.width == -1 || size.height == -1) {
				Dimension saveSize = size.getCopy();
				size = new Dimension(width, height);
				// get list size
				size = LayoutUtils.getListUnitSize(topListEP);
				if (size == null) {
					size = new Dimension(DeployCoreConstants.SERVER_UNIT_WIDTH,
							DeployCoreConstants.SERVER_UNIT_HEIGHT);
				}

				// if the width is not as wide as the unit figure width, make it wider
				int topWidth = unitEP.getFigure().getPreferredSize(-1, -1).width;
				if (topWidth > size.width) {
					size.width = topWidth;
				}
				// if there's a saved expand size and it's bigger then calculated size, use that
				if (isInnerHostingList) {
					if (saveSize.width > size.width) {
						size.width = saveSize.width;
					}
					if (saveSize.height > size.height) {
						size.height = saveSize.height;
					}
				}
				if (saveSize.width != -1) {
					size.width = saveSize.width;
				}
			}
		}

		// set this list's bounds and enlarge any containing group
		LayoutUtils.setViewBoundsAndLayout(unitEP, loc, size,
				(isInnerHostingList ? (IGraphicalEditPart) getParent() : null), isCollapsed);

		// if this view is part of an attachment, make sure all attachments are still aligned
		if (topSnapView != null) {
			ArrangeSnappedViewsCommand.arrangeSnappedViewsDelayed(getEditingDomain(), topSnapView,
					_oldBounds, SnapUtils.COMPARTMENT_CHANGE, unitEP.getViewer());
		}

		final EditPart selectedEP = getParent();
		Display.getDefault().asyncExec(new Runnable() {
			public void run() {
				// re-layout connectors
				GEFUtils.layoutConnectors();
				// if expanding, reveal all of tree
				if (!isCollapsed && selectedEP != null && selectedEP.getViewer() != null
						&& topListEP != null) {
					selectedEP.getViewer().reveal(topListEP.getParent());
				}
			}
		});
	}

	protected boolean hasModelChildrenChanged(Notification evt) {
		return false;
	}

	/**
	 * @return whether this list is the top list or an inner list
	 */
	public boolean isInnerHostingList() {
		return isInnerHostingList;
	}

	///////////////////////////////////////////////////////////////////////////////////////////
	///////////////////// ANCHOR ON COLLPASED LIST LISTENERS /////////////////////////////////////
	///////////////////////////////////////////////////////////////////////////////////////////
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
	 * Refresh the connections associated the the children of this shape compartment.
	 */
	protected void refreshConnectionsTree() {
		EditPart walker = this;
		while (walker != null && !(walker instanceof DeployDiagramEditPart)) {
			if (walker instanceof DeployListCompartmentEditPart) {
				((DeployListCompartmentEditPart) walker).refreshConnections();
			} else if (walker instanceof DeployCoreCompartmentEditPart) {
				((DeployCoreCompartmentEditPart) walker).refreshConnections();
			}
			walker = walker.getParent();
		}
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
			if (DeployListCompartmentEditPart.this.isActive()) {
				getConnectionManager().refreshConnections(DeployListCompartmentEditPart.this);
			}
		} finally {
			_refreshConnections = false;
		}

	}

	protected void refreshVisibility() {
		super.refreshVisibility();
		View view = getNotationView();
		if (view != null && !view.isVisible()) {
			forceRefreshConnections();
		} else {
			refreshConnections();
		}
	}

	protected void handlePropertyChangeEvent(PropertyChangeEvent event) {
		String pName = event.getPropertyName();
		if (RangeModel.PROPERTY_EXTENT.equals(pName) || RangeModel.PROPERTY_VALUE.equals(pName)) {
			refreshConnections();
		}
	}

	public void addNotify() {
		addEditPartListener(editpartListener);
		super.addNotify();
	}

	public void removeNotify() {
		removeEditPartListener(editpartListener);
		super.removeNotify();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.gmf.runtime.diagram.ui.internal.editparts.ISurfaceEditPart#getPrimaryEditParts()
	 */
	public List getPrimaryEditParts() {
		List connections = new ArrayList();

		Object diagramEditPart = getViewer().getEditPartRegistry().get(getDiagramView());

		List shapes = getChildren();
		Set connectableEditParts = new HashSet(shapes);
		Iterator iter = shapes.iterator();
		while (iter.hasNext()) {
			getBorderItemEditParts((EditPart) iter.next(), connectableEditParts);
		}

		if (diagramEditPart instanceof DiagramEditPart) {
			Iterator diagramConnections = ((DiagramEditPart) diagramEditPart).getConnections()
					.iterator();
			while (diagramConnections.hasNext()) {
				ConnectionEditPart connection = (ConnectionEditPart) diagramConnections.next();
				if (connectableEditParts.contains(connection.getSource())
						|| connectableEditParts.contains(connection.getTarget())) {
					connections.add(connection);
				}
			}
		}

		if (connections.size() > 0 || shapes.size() > 0) {
			List primaryEditParts = new ArrayList();
			primaryEditParts.addAll(shapes);
			primaryEditParts.addAll(connections);
			return primaryEditParts;
		}
		return Collections.EMPTY_LIST;
	}

	/**
	 * This method searches an edit part for a child that is a border item edit part
	 * 
	 * @param parent
	 *           part needed to search
	 * @param set
	 *           to be modified of border item edit parts that are direct children of the parent
	 */
	private void getBorderItemEditParts(EditPart parent, Set retval) {

		Iterator iter = parent.getChildren().iterator();
		while (iter.hasNext()) {
			EditPart child = (EditPart) iter.next();
			if (child instanceof IBorderItemEditPart) {
				retval.add(child);
				retval.addAll(child.getChildren());
			}
			getBorderItemEditParts(child, retval);
		}
	}

	public boolean isSupportingViewActions() {
		return isSupportingViewActions;
	}

	public void setIsSupportingViewActions(boolean supportsViewActions) {
		isSupportingViewActions = supportsViewActions;
	}

}
