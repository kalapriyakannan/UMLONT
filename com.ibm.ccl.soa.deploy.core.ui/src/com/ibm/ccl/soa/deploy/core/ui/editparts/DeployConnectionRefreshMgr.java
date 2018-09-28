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
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.eclipse.draw2d.Connection;
import org.eclipse.draw2d.ConnectionAnchor;
import org.eclipse.draw2d.IFigure;
import org.eclipse.draw2d.geometry.Rectangle;
import org.eclipse.gef.EditPart;
import org.eclipse.gef.editparts.AbstractGraphicalEditPart;
import org.eclipse.gmf.runtime.diagram.ui.editparts.ConnectionNodeEditPart;
import org.eclipse.gmf.runtime.diagram.ui.editparts.IGraphicalEditPart;
import org.eclipse.gmf.runtime.diagram.ui.editparts.ResizableCompartmentEditPart;
import org.eclipse.gmf.runtime.diagram.ui.editparts.ShapeNodeEditPart;
import org.eclipse.gmf.runtime.diagram.ui.editparts.ShapeCompartmentEditPart.ConnectionRefreshMgr;
import org.eclipse.gmf.runtime.diagram.ui.figures.ResizableCompartmentFigure;
import org.eclipse.gmf.runtime.gef.ui.figures.SlidableAnchor;
import org.eclipse.gmf.runtime.notation.Diagram;
import org.eclipse.gmf.runtime.notation.Edge;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.swt.widgets.Display;

import com.ibm.ccl.soa.deploy.core.ui.figures.DeployDiagramFigure;
import com.ibm.ccl.soa.deploy.core.ui.figures.DeployLinkConnection;
import com.ibm.ccl.soa.deploy.core.ui.figures.DeployListItemFigure;
import com.ibm.ccl.soa.deploy.core.ui.figures.core.CompositeShapeFigure;
import com.ibm.ccl.soa.deploy.core.ui.util.ConsolidationLinkUtils;
import com.ibm.ccl.soa.deploy.core.ui.util.GEFUtils;

/**
 * @since 7.0 used to create anchors on collapsed compartments for links to inner editparts
 * 
 */
public class DeployConnectionRefreshMgr extends ConnectionRefreshMgr {
	// each map contains a map of a group/list to a map of connections to anchors
	private final Map<ResizableCompartmentEditPart, Map<Connection, ConnectionAnchor>> collapsedSourceAnchorMap = new HashMap<ResizableCompartmentEditPart, Map<Connection, ConnectionAnchor>>();
	private final Map<ResizableCompartmentEditPart, Map<Connection, ConnectionAnchor>> collapsedTargetAnchorMap = new HashMap<ResizableCompartmentEditPart, Map<Connection, ConnectionAnchor>>();
	private final Map<Connection, ConnectionAnchor> expandedSourceAnchorMap = new HashMap<Connection, ConnectionAnchor>();
	private final Map<Connection, ConnectionAnchor> expandedTargetAnchorMap = new HashMap<Connection, ConnectionAnchor>();
	private static boolean refreshingConsolidatedLinks = false;

	/**
	 */
	public DeployConnectionRefreshMgr() {
	}

	protected void refreshConnections(ResizableCompartmentEditPart rcep) {
		for (Iterator<ConnectionNodeEditPart> it = getConnectionNodes(rcep).iterator(); it.hasNext();) {
			ConnectionNodeEditPart cep = it.next();
			// consolidation links 
			if (cep instanceof ConsolidationLinkEditPart) {
				continue;
			}

			Connection connection = (Connection) cep.getFigure();

			// if connection isn't visible, no need to collapse link
			if (connection instanceof DeployLinkConnection
					&& !((DeployLinkConnection) connection).isVisibleIgnoringConsolidation()) {
				continue;
			}

			IGraphicalEditPart source = (IGraphicalEditPart) getSourceEditPart(cep);
			IGraphicalEditPart target = (IGraphicalEditPart) getTargetEditPart(cep);
			ResizableCompartmentEditPart sCompartment = getOwningCompartment(source);
			ResizableCompartmentEditPart tCompartment = getOwningCompartment(target);

			// ignore if start and/or stop of link is not in different compartments
			if (sCompartment == null && tCompartment == null || sCompartment == tCompartment) {
				continue;
			}
			// ignore if link is from a compartment to its parent compartment
			if (isMyParent(source, target) || isMyParent(target, source)) {
				continue;
			}

			// for the case where the link goes from two editparts in the same import/import diagram/diagram
			EditPart commonTopEP = GEFUtils.getTopEditPart(source);
			if (commonTopEP != GEFUtils.getTopEditPart(target)) {
				commonTopEP = null;
			}

			// get current real connection anchor-- cached for performance
			ConnectionAnchor sourceAnchor = getSourceExpandedAnchor((IGraphicalEditPart) cep
					.getSource(), cep, connection);

			// if the source of a link is in a collapsed compartment, 
			//   create a new slidable anchor on the parent of the topmost collapsed compartment
			if (sCompartment != null && !isAnchorVisible(sourceAnchor)) {
				sourceAnchor = getCollapsedAnchor(sCompartment, connection, cep,
						collapsedSourceAnchorMap, sourceAnchor, commonTopEP, true);
			}

			// set new/old anchor into the connection
			connection.setSourceAnchor(sourceAnchor);

			// do the same if the target anchor is in this compartment
			ConnectionAnchor targetAnchor = getTargetExpandedAnchor((IGraphicalEditPart) cep
					.getTarget(), cep, connection);

			// if the target of a link is in a collapsed compartment, 
			//   create a new slidable anchor on the parent of the topmost collapsed compartment
			if (tCompartment != null && !isAnchorVisible(targetAnchor)) {
				targetAnchor = getCollapsedAnchor(tCompartment, connection, cep,
						collapsedTargetAnchorMap, targetAnchor, commonTopEP, false);
			}
			// set new/old anchor into the connection
			connection.setTargetAnchor(targetAnchor);

			// filter connection?
			if (cep instanceof DeployConnectionNodeEditPart) {
				((DeployConnectionNodeEditPart) cep).filterConnections();
			}
		}

		// now refresh consolidated links
		delayedRefreshConsolidatedLinks(rcep);
	}

	private ConnectionAnchor getSlidingAnchor(Connection connection, IGraphicalEditPart cep,
			Map<Connection, ConnectionAnchor> slidingAnchorMap) {
		ConnectionAnchor anchor = slidingAnchorMap.get(connection);
		if (anchor == null) {
			anchor = new SlidableAnchor(cep.getFigure());
			slidingAnchorMap.put(connection, anchor);
		}
		return anchor;
	}

	private void delayedRefreshConsolidatedLinks(final ResizableCompartmentEditPart rcep) {
		if (!refreshingConsolidatedLinks) {
			refreshingConsolidatedLinks = true;
			Display.getDefault().asyncExec(new Runnable() {
				public void run() {
					try {
						ConsolidationLinkUtils.refreshConsolidatedLinks(rcep);
					} finally {
						refreshingConsolidatedLinks = false;
					}
				}
			});
		}
	}

	/**
	 * Return the set of {@link ConnectionNodeEditPart}s contained in the supplied shape
	 * compartment.
	 * 
	 * @param rcep
	 *           a compartment.
	 * @return a {@link Set} of {@link ConnectionNodeEditPart}.
	 */

	protected Set<ConnectionNodeEditPart> getConnectionNodes(ResizableCompartmentEditPart rcep) {
		Set<ConnectionNodeEditPart> endPoints = new HashSet<ConnectionNodeEditPart>();
		Object modelObject = rcep.getModel();
		if (rcep.getViewer() == null || modelObject == null || !(modelObject instanceof View)) {
			return endPoints;
		}

		if (((View) modelObject).getDiagram() == null) {
			return endPoints;
		}

		Diagram diagram = ((View) modelObject).getDiagram();
		Map registry = rcep.getViewer().getEditPartRegistry();
		List edges = diagram.getEdges();
		Iterator edgesIterator = edges.iterator();

		while (edgesIterator.hasNext()) {
			Edge edge = (Edge) edgesIterator.next();
			EditPart endPoint = (EditPart) registry.get(edge.getSource());
			if (isChildOf(rcep, endPoint)) {
				Object cep = registry.get(edge);
				if (cep != null) {
					endPoints.add((ConnectionNodeEditPart) cep);
				}
				continue;
			}
			endPoint = (EditPart) registry.get(edge.getTarget());
			if (isChildOf(rcep, endPoint)) {
				Object cep = registry.get(edge);
				if (cep != null) {
					endPoints.add((ConnectionNodeEditPart) cep);
				}
			}
		}
		return endPoints;
	}

	/*
	 * walk up until we hit the compartment for this source/target editpart
	 */
	protected ResizableCompartmentEditPart getOwningCompartment(EditPart ep) {
		EditPart walker = ep;
		while (walker != null) {
			walker = walker.getParent();
			if (walker instanceof ResizableCompartmentEditPart) {
				break;
			}
		}
		return (ResizableCompartmentEditPart) walker;
	}

	/*
	 * determine if the given editpart is a child of the parent editpart
	 */
	protected boolean isMyParent(EditPart ep, EditPart parent) {
		EditPart walker = ep;
		while (walker != null) {
			walker = walker.getParent();
			if (walker == parent) {
				return true;
			}
		}
		return false;
	}

	/*
	 * gets source/target anchors for links; cache it for performance
	 */
	protected ConnectionAnchor getSourceExpandedAnchor(IGraphicalEditPart part,
			ConnectionNodeEditPart cep, Connection connection) {
		ConnectionAnchor anchor = expandedSourceAnchorMap.get(connection);
		if (anchor == null || !hasValidOwner(anchor.getOwner())) {
			if (part instanceof DeployShapeNodeEditPart) {
				anchor = ((DeployShapeNodeEditPart) part).getSourceConnectionAnchor(cep);
			} else {
				anchor = new SlidableAnchor(part.getFigure());
			}
			expandedSourceAnchorMap.put(connection, anchor);
		}
		return anchor;
	}

	protected ConnectionAnchor getTargetExpandedAnchor(IGraphicalEditPart part,
			ConnectionNodeEditPart cep, Connection connection) {
		ConnectionAnchor anchor = expandedTargetAnchorMap.get(connection);
		if (anchor == null || !hasValidOwner(anchor.getOwner())) {
			if (part instanceof DeployShapeNodeEditPart) {
				anchor = ((DeployShapeNodeEditPart) part).getTargetConnectionAnchor(cep);
			} else {
				anchor = new SlidableAnchor(part.getFigure());
			}
			expandedTargetAnchorMap.put(connection, anchor);
		}
		return anchor;
	}

	//make sure this achor's owner is still a valid figure with a parent on the diagram
	private boolean hasValidOwner(IFigure figure) {
		IFigure walker = figure;
		while (walker != null) {
			walker = walker.getParent();
			if (walker instanceof DeployDiagramFigure) {
				return true;
			}
		}
		return false;
	}

	/*
	 * determines if the anchor is visible to the user; if not the link is anchored to the group
	 */
	private boolean isAnchorVisible(ConnectionAnchor anchor) {
		return isFigureVisible(anchor.getOwner());
	}

	private boolean isFigureVisible(IFigure figure) {
		if (figure instanceof CompositeShapeFigure) {
			figure = ((CompositeShapeFigure) figure).getInnerFigure();
		}
		Rectangle refRect = figure.getBounds().getCopy();
		if (figure instanceof DeployListItemFigure) {
			refRect.height = GEFUtils.getListItemHeight(figure);
		} else {
			refRect.getExpanded(5, 5);
		}
		figure.translateToAbsolute(refRect);
		IFigure parentFigure = figure.getParent();
		while (parentFigure != null) {
			if (!parentFigure.isVisible()) {
				return false;
			}
			if (parentFigure instanceof ResizableCompartmentFigure) {
				Rectangle parentClientArea = parentFigure.getClientArea().getCopy();
				parentFigure.translateToAbsolute(parentClientArea);
				if (!parentClientArea.contains(refRect)) {
					return false;
				}
			}
			parentFigure = parentFigure.getParent();
		}
		return true;
	}

	/**
	 * when this is called, we already know that this compartment is collapsed and hiding an anchor
	 * to one end of the given connection, so we start at this compartment and walk up to the diagram
	 * until we find a compartment that isn't collapsed and then create a new slidable anchor on that
	 * compartment; we cache the new anchor for performance: for each compartment above this one we
	 * save a map of the connection to anchor pairs
	 * 
	 * @param compartment
	 * @param connection
	 * @param cep
	 * @param collapsedAnchorMap
	 * @param expandedAnchor
	 *           TODO
	 * @param commonTopEP!
	 *           TODO
	 * @param isSource
	 *           TODO
	 * @return new/saved slidable anchor on the compartment
	 */
	/*
	 */
	public ConnectionAnchor getCollapsedAnchor(ResizableCompartmentEditPart compartment,
			Connection connection, ConnectionNodeEditPart cep,
			Map<ResizableCompartmentEditPart, Map<Connection, ConnectionAnchor>> collapsedAnchorMap,
			ConnectionAnchor expandedAnchor, EditPart commonTopEP, boolean isSource) {

		// find all compartments above this one
		List<ResizableCompartmentEditPart> list = new ArrayList<ResizableCompartmentEditPart>();
		EditPart walker = compartment;
		while (walker != null && !(walker instanceof DeployDiagramEditPart)) {
			if (walker instanceof ResizableCompartmentEditPart) {
				list.add(0, (ResizableCompartmentEditPart) walker);
			}
			walker = walker.getParent();
		}

		// now walk back down from diagram looking for the first, topmost invisible compartment:
		//  we use that invisible compartment's parent for our anchor
		ResizableCompartmentEditPart firstInvisibleCompartment = compartment;
		for (Iterator<ResizableCompartmentEditPart> it = list.iterator(); it.hasNext();) {
			ResizableCompartmentEditPart nextCompartment = it.next();

			IGraphicalEditPart parentEP = (IGraphicalEditPart) nextCompartment.getParent();
			if (!isFigureVisible(parentEP.getFigure())) {
				break;
			}
			firstInvisibleCompartment = nextCompartment;
		}

		// link source and target share the same top ep, and the anchor is about to be set to the
		// top editpart, uset the expanded anchor instead to avoid a link to the container--
		// the clipping action when the link is drawn will take care of the link
		if (commonTopEP != null && firstInvisibleCompartment.getParent() == commonTopEP) {
			return expandedAnchor;
		}

		// get the "connection to anchor" map from this compartment
		// create a new map if none yet exists
		Map<Connection, ConnectionAnchor> anchorMap = collapsedAnchorMap
				.get(firstInvisibleCompartment);
		if (anchorMap == null) {
			anchorMap = new HashMap<Connection, ConnectionAnchor>();
			collapsedAnchorMap.put(firstInvisibleCompartment, anchorMap);
		}

		// then get the anchor for this connection from the map
		// create a new slidable anchor if none yet exists
		ConnectionAnchor anchor = anchorMap.get(connection);
		if (anchor == null) {
			ShapeNodeEditPart ep = (ShapeNodeEditPart) firstInvisibleCompartment.getParent();
			if (ep instanceof DeployShapeNodeEditPart) {
				if (isSource) {
					anchor = ep.getSourceConnectionAnchor(cep);
				} else {
					anchor = ep.getTargetConnectionAnchor(cep);
				}
			} else {
				anchor = new SlidableAnchor(((AbstractGraphicalEditPart) firstInvisibleCompartment
						.getParent()).getFigure());
			}
			anchorMap.put(connection, anchor);
		}
		return anchor;
	}

}
