/***************************************************************************************************
 * Copyright (c) 2007 IBM Corporation Licensed Material - Property of IBM. All rights reserved. US
 * Government Users Restricted Rights - Use, duplication or disclosure v1.0 restricted by GSA ADP
 * Schedule Contract with IBM Corp.
 * 
 * Contributors: IBM Corporation - initial API and implementation
 **************************************************************************************************/
package com.ibm.ccl.soa.deploy.core.ui.editparts;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

import org.eclipse.draw2d.Connection;
import org.eclipse.draw2d.IFigure;
import org.eclipse.draw2d.PolylineConnection;
import org.eclipse.draw2d.geometry.Point;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.gef.ConnectionEditPart;
import org.eclipse.gef.DragTracker;
import org.eclipse.gef.EditPart;
import org.eclipse.gef.EditPartViewer;
import org.eclipse.gef.EditPolicy;
import org.eclipse.gef.LayerConstants;
import org.eclipse.gef.Request;
import org.eclipse.gef.commands.Command;
import org.eclipse.gef.editparts.LayerManager;
import org.eclipse.gef.requests.SelectionRequest;
import org.eclipse.gmf.runtime.diagram.ui.editparts.ConnectionNodeEditPart;
import org.eclipse.gmf.runtime.diagram.ui.editpolicies.ConnectionBendpointEditPolicy;
import org.eclipse.gmf.runtime.diagram.ui.editpolicies.DecorationEditPolicy;
import org.eclipse.gmf.runtime.diagram.ui.editpolicies.EditPolicyRoles;
import org.eclipse.gmf.runtime.diagram.ui.editpolicies.OpenEditPolicy;
import org.eclipse.gmf.runtime.diagram.ui.services.decorator.AbstractDecorator;
import org.eclipse.gmf.runtime.diagram.ui.services.decorator.IDecoratorKeys;
import org.eclipse.gmf.runtime.diagram.ui.tools.DragEditPartsTrackerEx;
import org.eclipse.gmf.runtime.draw2d.ui.figures.PolylineConnectionEx;
import org.eclipse.gmf.runtime.notation.NotationPackage;
import org.eclipse.gmf.runtime.notation.RelativeBendpoints;
import org.eclipse.gmf.runtime.notation.RoutingStyle;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.jface.preference.IPreferenceStore;

import com.ibm.ccl.soa.deploy.core.DeployLink;
import com.ibm.ccl.soa.deploy.core.DeployModelObject;
import com.ibm.ccl.soa.deploy.core.Unit;
import com.ibm.ccl.soa.deploy.core.ui.DeployCoreUIPlugin;
import com.ibm.ccl.soa.deploy.core.ui.dialogs.LinkDetailPopupDialog;
import com.ibm.ccl.soa.deploy.core.ui.editpolicies.DeployConnectionEndpointEditPolicy;
import com.ibm.ccl.soa.deploy.core.ui.figures.ConsolidationLinkConnection;
import com.ibm.ccl.soa.deploy.core.ui.figures.DeployLinkConnection;
import com.ibm.ccl.soa.deploy.core.ui.preferences.IDeployPreferences;
import com.ibm.ccl.soa.deploy.core.ui.util.GEFUtils;
import com.ibm.ccl.soa.deploy.core.ui.util.GMFUtils;
import com.ibm.ccl.soa.deploy.core.ui.util.SelectionUtils;

/**
 * @author jswanke
 * 
 */
abstract public class DeployConnectionNodeEditPart extends ConnectionNodeEditPart {
	private EObject savedRef = null;

	/**
	 * @param view
	 */
	public DeployConnectionNodeEditPart(View view) {
		super(view);
	}

	@Override
	protected void deactivateFigure() {
		IFigure fig = getFigure();
		super.deactivateFigure();
		// remove any link labels
		if (fig != null && fig instanceof DeployLinkConnection) {
			((DeployLinkConnection) fig).removeConnectionLabels(false);
		}
	}

	@Override
	protected void registerModel() {
		super.registerModel();
		EObject ref = ((View) getModel()).getElement();
		if (ref == null) {
			return;
		}
		savedRef = ref;
		GMFUtils.getDeployDiagramEditPart(getRoot()).registerEditPartForElement(ref, this);
	}

	///////////////////////////////// LINK FILTERING ///////////////////////////////////
	//	when shape eps are created, they get list of source model edges then target edges belonging to this ep's view
	//	and then creates or finds the current connection eps using the viewer editpart map, first source then target
	//	they set themselves as source or if doing targets, the target into this connection ep
	//	therefore this ep will can in the editpart map without a target/source set until the target ep or source ep is 
	//	created, finds this connection ep in the editpart map and sets the target/source
	//	therefore the only place to effectively know that an editpart is good to go is by monitoring the setSource/setTarget until
	//	neither one is null

	// once a deleted connection ep is removed from the editpart map, we can effectively check to see
	// if it had a duplicate and therefore need to rerun the filters

	@Override
	protected void unregisterModel() {
		super.unregisterModel();
		GMFUtils.getDeployDiagramEditPart(getRoot()).unregisterEditPartForElement(savedRef, this);

		// if this was a duplicate link, refresh the filters
		List<ConnectionNodeEditPart> list = GMFUtils.getLinkEditPartsFor(getViewer(), savedRef);
		if (list.size() > 0) {
			filterConnectionsHelper(getViewer(), savedRef);
		}
	}

	@Override
	public void refresh() {
		super.refresh();
		filterConnections();
		refreshCollapsedAnchor(getSource());
		refreshCollapsedAnchor(getTarget());
	}

	private void refreshCollapsedAnchor(EditPart ep) {
		if (ep != null) {
			if (ep.getParent() instanceof DeployListCompartmentEditPart) {
				((DeployListCompartmentEditPart) ep.getParent()).refreshCollapsedLinks();
			} else if (ep.getParent() instanceof DeployCoreCompartmentEditPart) {
				((DeployCoreCompartmentEditPart) ep.getParent()).refreshCollapsedLinks();
			}
		}
	}

	protected void refreshForegroundColor() {
	}

	@Override
	public void setSource(EditPart editPart) {
		super.setSource(editPart);
		filterConnections();
	}

	@Override
	public void setTarget(EditPart editPart) {
		super.setTarget(editPart);
		filterConnections();
	}

	/**
	 * hide this connection?
	 */
	public void filterConnections() {
		if (getSource() == null || getTarget() == null) {
			return;
		}
		filterConnectionsHelper(getViewer(), this.resolveSemanticElement());
	}

	private void filterConnectionsHelper(final EditPartViewer viewer, final EObject linkElement) {

		//System.out.println("\n filtering:" + getLinkName(this)); //$NON-NLS-1$

		//////////////////// SINGLE LINK FILTER /////////////////////////////////////
		List<ConnectionNodeEditPart> list = GMFUtils.getLinkEditPartsFor(viewer, linkElement);
		// see if since we were started, we were deleted
		if (list.size() == 0) {
			return;
		}
		getFigure().setVisible(isConnVisible(this));
	}

	private boolean isConnVisible(ConnectionNodeEditPart conn) {
		// failsafe: if the link no longer represents an element, always make it visible so it can be deleted
		if (conn.resolveSemanticElement() == null) {
			return true;
		}

		if (!(conn.getSource() instanceof DeployShapeNodeEditPart)
				|| !(conn.getTarget() instanceof DeployShapeNodeEditPart)) {
			return false;
		}
		DeployShapeNodeEditPart srcEP = (DeployShapeNodeEditPart) conn.getSource();
		DeployShapeNodeEditPart tgtEP = (DeployShapeNodeEditPart) conn.getTarget();

		// filter duplicate links?
		IPreferenceStore store = DeployCoreUIPlugin.getDefault().getPreferenceStore();
		boolean filterDupLinks = store != null
				&& store.getBoolean(IDeployPreferences.DEPLOY_FILTER_SECONDARY_DUP_LINKS);

		////////////////////////// FILTER OUT LINKS TO ITSELF //////////////////////////////
		PolylineConnection link = (PolylineConnection) getFigure();
		if (link.getSourceAnchor() != null && link.getTargetAnchor() != null
				&& link.getSourceAnchor().getOwner() == link.getTargetAnchor().getOwner()) {
			return false;
		}
		if (srcEP.equals(tgtEP)) {
			return !filterDupLinks;
		}

		////////////////////////// FILTER OUT DUP LINKS BETWEEN CONTAINERS //////////////////////////////

		// if there are multiple top editparts only allow links within the same top editpart
		EditPart src = GEFUtils.getTopEditPart(srcEP);
		EditPart tgt = GEFUtils.getTopEditPart(tgtEP);
		if (!(src instanceof DeployShapeNodeEditPart) || !(tgt instanceof DeployShapeNodeEditPart)) {
			return false;
		}
		DeployShapeNodeEditPart srcTopEP = (DeployShapeNodeEditPart) src;
		DeployShapeNodeEditPart tgtTopEP = (DeployShapeNodeEditPart) tgt;
		List<DeployShapeNodeEditPart> srcList = GMFUtils.getEditPartsFor(getViewer(), srcEP
				.resolveSemanticElement());
		List<DeployShapeNodeEditPart> tgtList = GMFUtils.getEditPartsFor(getViewer(), tgtEP
				.resolveSemanticElement());
		Set<EditPart> topSrcEPSet = new HashSet<EditPart>();
		for (DeployShapeNodeEditPart ep : srcList) {
			EditPart topEP = GEFUtils.getTopEditPart(ep);
			if (!topEP.equals(ep)) {
				topSrcEPSet.add(topEP);
			}
		}

		// then collect all top target editparts
		// if this top target is shared with a source's top target, add to sharedTopEPSet
		Set<EditPart> sharedTopEPs = new HashSet<EditPart>();
		Set<EditPart> topTgtEPSet = new HashSet<EditPart>();
		for (DeployShapeNodeEditPart ep : tgtList) {
			EditPart topEP = GEFUtils.getTopEditPart(ep);
			if (!topEP.equals(ep)) {
				topTgtEPSet.add(topEP);
				if (topSrcEPSet.contains(topEP)) {
					sharedTopEPs.add(topEP);
				}
			}
		}

		// keep links from crossing between containers if the source and target are in the same container
		// therefore if one or more src/tgts share the same top edit part filter out this link if its 
		// top source/target editparts don't match, but don't filter it out if going from a container
		// with a source but no target to a container with a target but no source
		if (topSrcEPSet.size() + topTgtEPSet.size() > 2 && sharedTopEPs.size() > 0) {
			if (!srcTopEP.equals(tgtTopEP)
					&& (sharedTopEPs.contains(srcTopEP) || sharedTopEPs.contains(tgtTopEP))) {
				return !filterDupLinks;
			}
		}

		////////////////////////// FILTER OUT DUP LINKS BETWEEN CONTAINERS --PART TWO//////////////////////////////
		// if a link is from a tree to outside of the tree, hide it if its source/target is in that tree
		if (isOtherEndInContainer(srcTopEP, tgtTopEP, tgtEP)
				|| isOtherEndInContainer(tgtTopEP, srcTopEP, srcEP)) {
			return !filterDupLinks;
		}

		////////////////////////// FILTER OUT INNER TREE LINKS //////////////////////////////
		// don't allow inner tree links
		DeployListCompartmentEditPart topSrcListEP = GMFUtils.getTopList(srcEP);
		DeployListCompartmentEditPart topTgtListEP = GMFUtils.getTopList(tgtEP);
		// if both source and target are in the same list, hide link
		if (topSrcListEP != null && topTgtListEP != null) {
			if (topSrcListEP.equals(topTgtListEP)) {
				return false;
			}
			// if src is in a list owned by target, hide link 
		} else if (topSrcListEP != null && topSrcListEP.getParent().equals(tgtEP)) {
			return false;
			// if target is in a list owned by source, hide link
		} else if (topTgtListEP != null && topTgtListEP.getParent().equals(srcEP)) {
			return false;
		}

		//////////////////////// FILTER OUT LINKS FROM INNER SHAPES TO THE PARENT CONTAINER /////////////////////////////////
		if (srcTopEP != null && srcTopEP == tgtTopEP
				&& DeployShapeNodeEditPart.isShapesMode(srcTopEP)
				&& (srcEP != srcTopEP && tgtEP == tgtTopEP || srcEP == srcTopEP && tgtEP != tgtTopEP)) {
			return !filterDupLinks;
		}

		/////////////////////////// FILTER OUT IMPORT LINKS TO CANVAS /////////////////////
		// if source and target are from same imported topology but one is in canvas and one is not
		//  links between on canvas units is allowed
		EObject srcEO = srcEP.resolveSemanticElement();
		EObject tgtEO = tgtEP.resolveSemanticElement();
		if (!(srcEO instanceof Unit && tgtEO instanceof Unit)) {
			return false;
		}
		Unit srcUnit = (Unit) srcEO;
		Unit tgtUnit = (Unit) tgtEO;
		if (srcUnit.getTopology() != srcUnit.getEditTopology()
				&& srcUnit.getTopology() == tgtUnit.getTopology()) {
			if (GMFUtils.isImportTopology(srcEP) != GMFUtils.isImportTopology(tgtEP)) {
				return false;
			}
		}
		return true;
	}

	// see if the target of this link is actually within the source's container
	private boolean isOtherEndInContainer(DeployShapeNodeEditPart srcTopEP,
			DeployShapeNodeEditPart tgtTopEP, DeployShapeNodeEditPart tgtEP) {
		if (srcTopEP != tgtTopEP) {
			EObject tgtEO = tgtEP.getSemanticElementIfResolved();
			List<DeployModelObject> list = GMFUtils.getAllContainedUnits(srcTopEP);
			return list.contains(tgtEO);
		}
		return false;
	}

//	private String getLinkName(ConnectionNodeEditPart conn) {
//		DeployShapeNodeEditPart srcEPx = (DeployShapeNodeEditPart) conn.getSource();
//		DeployShapeNodeEditPart tgtEPx = (DeployShapeNodeEditPart) conn.getTarget();
//		String srcName = conn.getSource() != null ? GMFUtils.getDmoName(srcEPx
//				.resolveSemanticElement())
//				+ getDupIndex(srcEPx) : "source missing!!!"; //$NON-NLS-1$
//		String tgtName = conn.getTarget() != null ? GMFUtils.getDmoName(tgtEPx
//				.resolveSemanticElement())
//				+ getDupIndex(tgtEPx) : "target missing!!!"; //$NON-NLS-1$
//		return srcName + " to " + tgtName; //$NON-NLS-1$
//
//	}
//
//	private String getDupIndex(GraphicalEditPart ep) {
//		String dup = ""; //$NON-NLS-1$
//		if (ep instanceof DeployShapeNodeEditPart) {
//			DeployShapeNodeEditPart dep = (DeployShapeNodeEditPart) ep;
//			CompositeShapeFigure csf = (CompositeShapeFigure) dep.getFigure();
//			if (csf.getInnerFigure() instanceof DeployCoreFigure) {
//				dup = ((DeployCoreFigure) csf.getInnerFigure()).getDuplicateIndex();
//			} else if (csf.getInnerFigure() instanceof DeployListItemFigure) {
//				dup = ((DeployListItemFigure) csf.getInnerFigure()).getDuplicateIndex();
//			}
//			if (dup == null) {
//				dup = "";//$NON-NLS-1$
//			}
//		}
//		return dup;
//	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.gmf.runtime.diagram.ui.editparts.ConnectionEditPart#createDefaultEditPolicies()
	 */
	protected void createDefaultEditPolicies() {
		super.createDefaultEditPolicies();

		installNoBendpointEditPolicy();

		// since canonical editpolicies always delete null elements, no need for "x" marker
		removeEditPolicy(EditPolicyRoles.DECORATION_ROLE);
		installEditPolicy(EditPolicyRoles.DECORATION_ROLE, new DecorationEditPolicy() {

			@Override
			public void refresh() {
				super.refresh();
				AbstractDecorator decorator = (AbstractDecorator) getDecorators().get(
						IDecoratorKeys.UNRESOLVED_VIEW);
				if (decorator != null) {
					decorator.deactivate();
					getDecorators().remove(IDecoratorKeys.UNRESOLVED_VIEW);
				}
			}

		});

		// allow users to open flyout dialog by doble-click/ctrl key
		installEditPolicy(EditPolicyRoles.OPEN_ROLE, new OpenEditPolicy() {

			/**
			 * This method always returns null. The value is the side effect; asking for the command
			 * opens a dialog in the UI!
			 */
			protected Command getOpenCommand(Request request) {
				if (request instanceof SelectionRequest) {
					SelectionRequest sr = (SelectionRequest) request;
					popupLinksDetails(sr.getLocation());
				}

				//						View view = (View) getHost().getModel();
				//						EObject semanticObject = view.getElement();				
				//						if (semanticObject instanceof DeployModelObject) {
				//							if(request instanceof SelectionRequest){
				//								SelectionRequest sr = (SelectionRequest) request;
				//								List<DeployConnectionNodeEditPart> linkEPs = getLinksAt(sr.getLocation());
				//								
				//								DeployConnectionNodeEditPart linkEP = linkEPs.get(0);
				//								Unit unit = (Unit) ((GraphicalEditPart)linkEP.getSource()).resolveSemanticElement();
				//								NameCompartmentEditPart.
				//									popupGeneralPropertyFlyout(getFigure(),getViewer(),sr.getLocation(), unit);
				//							}
				//						}

				return null;
			}
		});
	}

	protected void refreshRouterChange() {
		refreshBendpoints();
		installNoBendpointEditPolicy();
	}

	protected void refreshRoutingStyles() {
		Connection connection = getConnectionFigure();
		if (!(connection instanceof PolylineConnectionEx)) {
			return;
		}
		PolylineConnectionEx poly = (PolylineConnectionEx) connection;
		RoutingStyle style = (RoutingStyle) ((View) getModel())
				.getStyle(NotationPackage.Literals.ROUTING_STYLE);
		if (style != null) {

			boolean closestDistance = style.isClosestDistance();
			boolean avoidObstruction = style.isAvoidObstructions();

			poly.setRoutingStyles(closestDistance, avoidObstruction);

			if (avoidObstruction) {
				installEditPolicy(EditPolicy.CONNECTION_BENDPOINTS_ROLE, null);
			} else {
				installNoBendpointEditPolicy();
			}
		}
	}

	private void installNoBendpointEditPolicy() {
		// don't show selection handles
		installEditPolicy(EditPolicy.CONNECTION_BENDPOINTS_ROLE, new ConnectionBendpointEditPolicy() {
			@Override
			protected void addSelectionHandles() {
			}
		});
	}

	private void popupLinksDetails(Point location) {
//		org.eclipse.swt.graphics.Point initialLocation = location.getSWTPoint();
		// Translate 0,0 to display, giving us the relative
		org.eclipse.swt.graphics.Point initialLocation = getViewer().getControl().toDisplay(
				new org.eclipse.swt.graphics.Point(location.x, location.y));
		LinkDetailPopupDialog dlg = new LinkDetailPopupDialog(getSource().getViewer().getControl()
				.getShell(), initialLocation);
		dlg.create();
		dlg.setInput(getModelLinksAt(location));
		dlg.open();
	}

	private List<DeployLink> getModelLinksAt(Point location) {
		List<DeployLink> retVal = new LinkedList<DeployLink>();

		for (Iterator<DeployConnectionNodeEditPart> it = getLinksAt(location).iterator(); it
				.hasNext();) {
			DeployConnectionNodeEditPart dcnep = it.next();
			if (dcnep.getModel() instanceof View) {
				View view = (View) dcnep.getModel();
				if (view.getElement() instanceof DeployLink) {
					retVal.add((DeployLink) view.getElement());
				}
			}
		}
		return retVal;
	}

	private List<DeployConnectionNodeEditPart> getLinksAt(Point location) {
		// find all figures at this spot in the connectionlayer
		IFigure connectionLayer = LayerManager.Helper.find(this).getLayer(
				LayerConstants.CONNECTION_LAYER);
		connectionLayer.translateToRelative(location);
		int x = location.x;
		int y = location.y;
		List<IFigure> figures = new ArrayList<IFigure>();
		IFigure fig;
		int safety = 0;
		List<DeployConnectionNodeEditPart> list = new ArrayList<DeployConnectionNodeEditPart>();
		// with abbreviated links, the exclude part of this call doesn't always work
		while ((fig = connectionLayer.findFigureAtExcluding(x, y, figures)) != null && safety < 5) {
			if (figures.contains(fig)) {
				safety++;
			} else {
				figures.add(fig);
				if (fig instanceof ConsolidationLinkConnection) {
					ConsolidationLinkConnection linkFig = (ConsolidationLinkConnection) fig;
					ConsolidationLinkEditPart linkEP = (ConsolidationLinkEditPart) linkFig
							.getConnectionEP();
					list.addAll(linkEP.getConsolidatedLinkList());
				} else if (fig instanceof DeployLinkConnection) {
					DeployLinkConnection linkFig = (DeployLinkConnection) fig;
					list.add((DeployConnectionNodeEditPart) linkFig.getConnectionEP());
				}
			}
		}
		return list;
	}

	@Override
	public DragTracker getDragTracker(Request request) {
		return new DragEditPartsTrackerEx(this) {
			private boolean primedForFading = false;

			@Override
			protected boolean handleButtonDown(int button) {
				if (!isActive()) {
					return false;
				}
				primedForFading = true;
				return super.handleButtonDown(button);
			}

			// don't fade if they're just dragging
			@Override
			protected boolean handleDragInProgress() {
				if (!isActive()) {
					return false;
				}
				primedForFading = false;
				SelectionUtils.unfadeFigures();
				return super.handleDragInProgress();
			}

			@Override
			protected boolean handleButtonUp(int button) {
				if (!isActive()) {
					return false;
				}
				if (primedForFading) {
					primedForFading = false;
					DeployConnectionEndpointEditPolicy policy = (DeployConnectionEndpointEditPolicy) DeployConnectionNodeEditPart.this
							.getEditPolicy(EditPolicy.CONNECTION_ENDPOINTS_ROLE);
					if (policy != null) {
						policy.showFadeFeedback();
					}
				}
				return super.handleButtonUp(button);
			}

		};
	}

	// NPE protection when edge is bogus
	protected void refreshBendpoints() {
		RelativeBendpoints bendpoints = (RelativeBendpoints) getEdge().getBendpoints();
		if (bendpoints != null) {
			super.refreshBendpoints();
		}
	}

	/**
	 * @param conn
	 * @return is either source or target in a snapped group
	 */
	public static boolean isInnerSnapLink(Connection conn) {
		if (conn instanceof DeployLinkConnection) {
			DeployLinkConnection link = (DeployLinkConnection) conn;
			return isInnerSnapLink(link.getConnectionEP());
		}
		return false;
	}

	/**
	 * @param linkEP
	 * @return is this link between two units of the same snap group
	 */
	public static boolean isInnerSnapLink(ConnectionEditPart linkEP) {
		if (linkEP.getSource() instanceof DeployShapeNodeEditPart
				&& linkEP.getTarget() instanceof DeployShapeNodeEditPart) {
			DeployShapeNodeEditPart srcEP = (DeployShapeNodeEditPart) linkEP.getSource();
			DeployShapeNodeEditPart tgtEP = (DeployShapeNodeEditPart) linkEP.getTarget();
			return srcEP.isInSnapGroup() && srcEP.getOwnerSnapGroup() == tgtEP.getOwnerSnapGroup();
		}
		return false;
	}

}
