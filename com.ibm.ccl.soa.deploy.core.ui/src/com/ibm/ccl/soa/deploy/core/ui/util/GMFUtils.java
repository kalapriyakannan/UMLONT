/***************************************************************************************************
 * Copyright (c) 2003, 2007 IBM Corporation Licensed Material - Property of IBM. All rights
 * reserved.
 * 
 * US Government Users Restricted Rights - Use, duplication or disclosure v1.0 restricted by GSA ADP
 * Schedule Contract with IBM Corp.
 * 
 * Contributors: IBM Corporation - initial API and implementation
 **************************************************************************************************/
package com.ibm.ccl.soa.deploy.core.ui.util;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.Map.Entry;

import org.eclipse.core.runtime.IStatus;
import org.eclipse.draw2d.IFigure;
import org.eclipse.draw2d.geometry.Rectangle;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.gef.EditPart;
import org.eclipse.gef.EditPartViewer;
import org.eclipse.gef.Request;
import org.eclipse.gef.RequestConstants;
import org.eclipse.gmf.runtime.diagram.core.util.ViewUtil;
import org.eclipse.gmf.runtime.diagram.ui.editparts.ConnectionNodeEditPart;
import org.eclipse.gmf.runtime.diagram.ui.editparts.GraphicalEditPart;
import org.eclipse.gmf.runtime.diagram.ui.editparts.IGraphicalEditPart;
import org.eclipse.gmf.runtime.diagram.ui.editparts.ListCompartmentEditPart;
import org.eclipse.gmf.runtime.diagram.ui.editparts.ResizableCompartmentEditPart;
import org.eclipse.gmf.runtime.diagram.ui.editparts.ShapeCompartmentEditPart;
import org.eclipse.gmf.runtime.diagram.ui.figures.ResizableCompartmentFigure;
import org.eclipse.gmf.runtime.diagram.ui.parts.DiagramGraphicalViewer;
import org.eclipse.gmf.runtime.diagram.ui.requests.EditCommandRequestWrapper;
import org.eclipse.gmf.runtime.emf.core.util.EMFCoreUtil;
import org.eclipse.gmf.runtime.emf.core.util.EObjectAdapter;
import org.eclipse.gmf.runtime.emf.type.core.requests.DestroyElementRequest;
import org.eclipse.gmf.runtime.emf.type.core.requests.IEditCommandRequest;
import org.eclipse.gmf.runtime.notation.Diagram;
import org.eclipse.gmf.runtime.notation.Edge;
import org.eclipse.gmf.runtime.notation.Node;
import org.eclipse.gmf.runtime.notation.NotationPackage;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.swt.custom.BusyIndicator;
import org.eclipse.swt.widgets.Display;

import com.ibm.ccl.soa.deploy.core.ConfigurationContract;
import com.ibm.ccl.soa.deploy.core.ConstraintLink;
import com.ibm.ccl.soa.deploy.core.CoreFactory;
import com.ibm.ccl.soa.deploy.core.DependencyLink;
import com.ibm.ccl.soa.deploy.core.DeployLink;
import com.ibm.ccl.soa.deploy.core.DeployModelObject;
import com.ibm.ccl.soa.deploy.core.HostingLink;
import com.ibm.ccl.soa.deploy.core.IRelationshipChecker;
import com.ibm.ccl.soa.deploy.core.Import;
import com.ibm.ccl.soa.deploy.core.InstanceConfiguration;
import com.ibm.ccl.soa.deploy.core.MemberLink;
import com.ibm.ccl.soa.deploy.core.RealizationLink;
import com.ibm.ccl.soa.deploy.core.Service;
import com.ibm.ccl.soa.deploy.core.Topology;
import com.ibm.ccl.soa.deploy.core.Unit;
import com.ibm.ccl.soa.deploy.core.UnitLink;
import com.ibm.ccl.soa.deploy.core.constraint.DeferredHostingConstraint;
import com.ibm.ccl.soa.deploy.core.ui.DeployCoreUIPlugin;
import com.ibm.ccl.soa.deploy.core.ui.Messages;
import com.ibm.ccl.soa.deploy.core.ui.editparts.BusinessComponentEditPart;
import com.ibm.ccl.soa.deploy.core.ui.editparts.ConsolidationLinkEditPart;
import com.ibm.ccl.soa.deploy.core.ui.editparts.DeployConnectionNodeEditPart;
import com.ibm.ccl.soa.deploy.core.ui.editparts.DeployDiagramEditPart;
import com.ibm.ccl.soa.deploy.core.ui.editparts.DeployListCompartmentEditPart;
import com.ibm.ccl.soa.deploy.core.ui.editparts.DeployShapeNodeEditPart;
import com.ibm.ccl.soa.deploy.core.ui.editparts.DiagramListCompartmentEditPart;
import com.ibm.ccl.soa.deploy.core.ui.editparts.DiagramNodeEditPart;
import com.ibm.ccl.soa.deploy.core.ui.editparts.ImportListCompartmentEditPart;
import com.ibm.ccl.soa.deploy.core.ui.editparts.ImportTopologyEditPart;
import com.ibm.ccl.soa.deploy.core.ui.figures.DeployCoreFigure;
import com.ibm.ccl.soa.deploy.core.ui.figures.DeployDiagramFigure;
import com.ibm.ccl.soa.deploy.core.ui.figures.DeployListCompartmentFigure;
import com.ibm.ccl.soa.deploy.core.ui.figures.DiagramListCompartmentFigure;
import com.ibm.ccl.soa.deploy.core.ui.figures.HybridListCompartmentFigure;
import com.ibm.ccl.soa.deploy.core.ui.figures.ImportListCompartmentFigure;
import com.ibm.ccl.soa.deploy.core.ui.figures.core.CompositeShapeFigure;
import com.ibm.ccl.soa.deploy.core.ui.figures.core.DeployShapeCompartmentFigure;
import com.ibm.ccl.soa.deploy.core.ui.properties.PropertyUtils;
import com.ibm.ccl.soa.deploy.core.validator.DeployValidatorService;
import com.ibm.ccl.soa.deploy.core.validator.matcher.LinkType;
import com.ibm.ccl.soa.deploy.core.validator.resolution.ResolutionUtils;

/**
 * @since 1.0
 * 
 */
public class GMFUtils {

	private static final IStatus HOSTING_LINK_CANNOT_BE_CREATED_BETWEEN_THE_UNITS = DeployCoreUIPlugin
			.createErrorStatus(0, Messages.HOSTING_LINK_CANNOT_BE_CREATED_BETWEEN_THE_UNITS, null);

	///////////////////////////////////////////////////////////////////////////////////////////////////////////////
	///////////////////////////  MISC COMPARTMENT METHODS       /////////////////////////////////////////
	//////////////////////////////////////////////////////////////////////////////////////////////////////////////

	/**
	 * @param part
	 * @return group area figure
	 */
	public static ResizableCompartmentFigure getShapesFigure(EditPart part) {
		IGraphicalEditPart shapesCompartmentEP = DeployShapeNodeEditPart.getShapesCompartment(part);
		if (shapesCompartmentEP != null && shapesCompartmentEP.getFigure() != null
				&& shapesCompartmentEP.getFigure() instanceof ResizableCompartmentFigure) {
			return (ResizableCompartmentFigure) shapesCompartmentEP.getFigure();
		}
		return null;
	}

	/**
	 * @param part
	 * @return import list figure
	 */
	public static ImportListCompartmentFigure getImportListFigure(EditPart part) {
		if (part instanceof ImportTopologyEditPart) {
			ImportTopologyEditPart importEP = (ImportTopologyEditPart) part;
			IGraphicalEditPart list = importEP
					.getChildBySemanticHint(DeployCoreConstants.IMPORTTOPOLOGYLIST_SEMANTICHINT);
			if (list != null && list.getFigure() != null
					&& list.getFigure() instanceof ImportListCompartmentFigure) {
				return (ImportListCompartmentFigure) list.getFigure();
			}
		} else if (part instanceof ImportListCompartmentEditPart) {
			ImportListCompartmentEditPart list = (ImportListCompartmentEditPart) part;
			if (list.getFigure() != null && list.getFigure() instanceof ImportListCompartmentFigure) {
				return (ImportListCompartmentFigure) list.getFigure();
			}
		}
		return null;
	}

	/**
	 * @param part
	 * @return diagram list figure
	 */
	public static DiagramListCompartmentFigure getDiagramListFigure(EditPart part) {
		if (part instanceof DiagramNodeEditPart) {
			DiagramNodeEditPart diagramEP = (DiagramNodeEditPart) part;
			IGraphicalEditPart list = diagramEP
					.getChildBySemanticHint(DeployCoreConstants.DIAGRAMNODELIST_SEMANTICHINT);
			if (list != null && list.getFigure() != null
					&& list.getFigure() instanceof DiagramListCompartmentFigure) {
				return (DiagramListCompartmentFigure) list.getFigure();
			}
		} else if (part instanceof DiagramListCompartmentEditPart) {
			DiagramListCompartmentEditPart list = (DiagramListCompartmentEditPart) part;
			if (list.getFigure() != null && list.getFigure() instanceof DiagramListCompartmentFigure) {
				return (DiagramListCompartmentFigure) list.getFigure();
			}
		}
		return null;
	}

	/**
	 * @param ep
	 * @return diagram if any
	 */
	public static Diagram getDiagram(EditPart ep) {
		ImportTopologyEditPart importEP = getImportTopologyEP(ep);
		if (importEP != null) {
			return importEP.getImportDiagram();
		}

		DiagramNodeEditPart diagramEP = getDiagramNodeEP(ep);
		if (diagramEP != null) {
			return (Diagram) diagramEP.resolveSemanticElement();
		}
		return null;
	}

	/**
	 * @param part
	 * @return if group is expanded
	 */
	public static boolean isShapesExpanded(EditPart part) {
		ResizableCompartmentFigure fig = getShapesFigure(part);
		if (fig != null) {
			return fig.isExpanded();
		}
		return false;
	}

	/**
	 * @param host
	 * @return top list
	 */
	public static DeployListCompartmentEditPart getTopList(GraphicalEditPart host) {
		GraphicalEditPart walker = host;
		while (walker != null) {
			if (walker instanceof DeployListCompartmentEditPart
					&& !((DeployListCompartmentEditPart) walker).isInnerHostingList()) {
				return (DeployListCompartmentEditPart) walker;
			} else if (!(walker.getParent() instanceof GraphicalEditPart)) {
				return null;
			}
			walker = (GraphicalEditPart) walker.getParent();
		}
		return null;
	}

	/**
	 * @param ep
	 * @return top component if this component is in a compartment, or just return the component
	 */
	public static BusinessComponentEditPart getTopComponentEP(EditPart ep) {
		EditPart walker = ep;
		BusinessComponentEditPart topEP = null;
		while (walker != null) {
			if (walker instanceof BusinessComponentEditPart) {
				topEP = (BusinessComponentEditPart) walker;
			} else if (walker instanceof DeployDiagramEditPart) {
				break;
			}
			walker = walker.getParent();
		}
		return topEP;
	}

	/**
	 * @param ep
	 * @return top edit part
	 */
	public static DeployShapeNodeEditPart getTopEditPart(DeployShapeNodeEditPart ep) {
		EditPart walker = ep;
		DeployShapeNodeEditPart topEP = null;
		while (walker != null) {
			if (walker instanceof DeployShapeNodeEditPart) {
				topEP = (DeployShapeNodeEditPart) walker;
			} else if (walker instanceof DeployDiagramEditPart) {
				break;
			}
			walker = walker.getParent();
		}
		return topEP;
	}

	/**
	 * @param ep
	 * @return the containing DeployShapeNodeEditPart or the diagram edit part
	 */
	public static EditPart getEditPartContainer(GraphicalEditPart ep) {
		EditPart walker = ep.getParent();
		while (walker != null) {
			if (walker instanceof DeployShapeNodeEditPart || walker instanceof DeployDiagramEditPart) {
				return walker;
			}
			walker = walker.getParent();
		}
		return ep;
	}

	/**
	 * @param ep
	 * @param container
	 * @return get top EditPart that lives in this container
	 */
	public static GraphicalEditPart getTopContainedEditPart(EditPart ep, EditPart container) {
		EditPart walker = ep;
		DeployShapeNodeEditPart topEP = null;
		while (walker != null) {
			boolean isContained = walker.equals(container);
			if (walker instanceof DeployShapeNodeEditPart) {
				if (!isContained || topEP == null) {
					topEP = (DeployShapeNodeEditPart) walker;
				}
			}
			if (isContained) {
				break;
			}
			walker = walker.getParent();
		}
		return topEP;
	}

	/**
	 * @param editPart
	 * @return does this EditPart live in a list
	 */
	public static boolean isInList(GraphicalEditPart editPart) {
		GraphicalEditPart walker = editPart;
		while (walker != null) {
			if (walker instanceof DeployListCompartmentEditPart) {
				return true;
			} else if (walker instanceof ResizableCompartmentEditPart
					|| walker instanceof DeployDiagramEditPart) {
				return false;
			}
			walker = (GraphicalEditPart) walker.getParent();
		}
		return false;
	}

	/**
	 * @param f
	 * @return if conceptual node area is expanded
	 */
	public static boolean isComponentExpanded(IFigure f) {
		if (f == null) {
			return false;
		}

		if (f instanceof HybridListCompartmentFigure) {
			HybridListCompartmentFigure fig = (HybridListCompartmentFigure) f;
			return fig.isExpanded();
		}
		Iterator it = f.getChildren().iterator();
		while (it.hasNext()) {
			if (isComponentExpanded((IFigure) it.next())) {
				return true;
			}
		}
		return false;
	}

	/**
	 * @param part
	 * @return if conceptual node area is expanded
	 */
	public static boolean isImportExpanded(GraphicalEditPart part) {
		ResizableCompartmentFigure fig = getImportListFigure(part);
		if (fig != null) {
			return fig.isExpanded();
		}
		return false;
	}

	/**
	 * @param f
	 * @return if ImportTopology area is expanded
	 */
	public static boolean isImportExpanded(IFigure f) {
		if (f == null) {
			return false;
		}

		if (f instanceof ImportListCompartmentFigure) {
			ImportListCompartmentFigure fig = (ImportListCompartmentFigure) f;
			return fig.isExpanded();
		}
		Iterator it = f.getChildren().iterator();
		while (it.hasNext()) {
			if (isImportExpanded((IFigure) it.next())) {
				return true;
			}
		}
		return false;
	}

	/**
	 * @param part
	 * @return if conceptual node area is expanded
	 */
	public static boolean isDiagramExpanded(GraphicalEditPart part) {
		ResizableCompartmentFigure fig = getDiagramListFigure(part);
		if (fig != null) {
			return fig.isExpanded();
		}
		return false;
	}

	/**
	 * @param f
	 * @return if ImportTopology area is expanded
	 */
	public static boolean isDiagramExpanded(IFigure f) {
		if (f == null) {
			return false;
		}

		if (f instanceof DiagramListCompartmentFigure) {
			DiagramListCompartmentFigure fig = (DiagramListCompartmentFigure) f;
			return fig.isExpanded();
		}
		Iterator it = f.getChildren().iterator();
		while (it.hasNext()) {
			if (isDiagramExpanded((IFigure) it.next())) {
				return true;
			}
		}
		return false;
	}

	/**
	 * @param editpart
	 * @return return the deploy digram edit part
	 */
	public static DeployDiagramEditPart getDeployDiagramEditPart(EditPart editpart) {
		if (editpart == null) {
			return null;
		}
		EditPart ep = editpart;
		while (ep != null) {
			if (ep instanceof DeployDiagramEditPart) {
				return (DeployDiagramEditPart) ep;
			}
			ep = ep.getParent();
		}
		return getDeployDiagramEditPartHelper(editpart.getParent() != null ? editpart.getParent()
				.getChildren() : editpart.getChildren());
	}

	private static DeployDiagramEditPart getDeployDiagramEditPartHelper(List children) {
		for (Iterator it = children.iterator(); it.hasNext();) {
			EditPart ep = (EditPart) it.next();
			if (ep instanceof DeployDiagramEditPart) {
				return (DeployDiagramEditPart) ep;
			}
			DeployDiagramEditPart ddep = getDeployDiagramEditPartHelper(ep.getChildren());
			if (ddep != null) {
				return ddep;
			}
		}
		return null;
	}

	///////////////////////////////////////////////////////////////////////////////////////////////////////////////
	///////////////////////////   Duplicate View Utilities      /////////////////////////////////////////
	//////////////////////////////////////////////////////////////////////////////////////////////////////////////

	/**
	 * @param editpart
	 * @param dmo
	 * @param ignoreDiagramViews
	 * @return view list
	 */
	public static List<View> getAllDuplicateViewsFor(EditPart editpart, DeployModelObject dmo,
			boolean ignoreDiagramViews) {
		List<View> viewList = new ArrayList<View>();
		List<DeployShapeNodeEditPart> list = getEditPartsFor(editpart, dmo);
		if (list.size() > 0) {
			for (Iterator<DeployShapeNodeEditPart> it = list.iterator(); it.hasNext();) {
				DeployShapeNodeEditPart ep = it.next();
				EditPart topEP = GEFUtils.getTopEditPart(ep);
				boolean isProxy = PropertyUtils
						.isProxy((DeployModelObject) ep.resolveSemanticElement());
				if (!ignoreDiagramViews || !isProxy || !(topEP instanceof DiagramNodeEditPart)
						&& !(topEP instanceof ImportTopologyEditPart)) {
					viewList.add(ep.getNotationView());
				}
			}
		}
		return viewList;
	}

	/**
	 * @param editpart
	 * @param view
	 * @param ignoreDiagramViews
	 * @return view list
	 */
	public static List<View> getAllDuplicateViewsFor(EditPart editpart, View view,
			boolean ignoreDiagramViews) {
		List<View> viewList = getAllDuplicateViewsFor(editpart, (DeployModelObject) ViewUtil
				.resolveSemanticElement(view), ignoreDiagramViews);
		if (!viewList.contains(view)) {
			viewList.add(view);
		}
		return viewList;
	}

	/**
	 * Check if a view is a duplicate
	 * 
	 * @param view
	 * @return boolean
	 */
	public static boolean isDuplicateView(IGraphicalEditPart ep, View view) {
		return getEditPartsFor(ep, ViewUtil.resolveSemanticElement(view)).size() > 1;
	}

	/**
	 * Get all duplicate edit parts
	 * 
	 * @param ep
	 * @return list
	 */
	public static List getAllDuplicateEditParts(DeployShapeNodeEditPart ep) {
		return getEditPartsFor(ep, ep.resolveSemanticElement());
	}

	/**
	 * Get corresponding editparts for the given semantic element
	 * 
	 * @param editpart
	 * @param element
	 * @return ep list
	 */
	static public List<DeployShapeNodeEditPart> getEditPartsFor(EditPart editpart, EObject element) {
		if (element != null && editpart != null && !(element instanceof View)
				&& editpart.getRoot() != null) {
			return getEditPartsFor(editpart.getViewer(), element);
		}
		return Collections.emptyList();
	}

	/**
	 * @param viewer
	 * @param element
	 * @return ep list
	 */
	static public List<DeployShapeNodeEditPart> getEditPartsFor(EditPartViewer viewer,
			EObject element) {
		if (viewer instanceof DiagramGraphicalViewer) {
			List<DeployShapeNodeEditPart> filteredList = new ArrayList<DeployShapeNodeEditPart>();
			List list = GMFUtils.getDeployDiagramEditPart(viewer.getRootEditPart())
					.findEditPartsForElement(element, DeployShapeNodeEditPart.class);
			// filter out editparts whose view is unattached
			for (Iterator<DeployShapeNodeEditPart> it = list.iterator(); it.hasNext();) {
				DeployShapeNodeEditPart ep = it.next();
				if (ViewUtil.getContainerView(ep.getNotationView()) != null) {
					filteredList.add(ep);
				}
			}
			return filteredList;
		}
		return Collections.emptyList();
	}

	/**
	 * get all editparts for a unit, even if it doesn't have a view
	 * 
	 * @param viewer
	 * @param element
	 * @return editpart list
	 */
	public static List<DeployShapeNodeEditPart> getOrCreateEditPartsFor(EditPartViewer viewer,
			EObject element) {
		List<DeployShapeNodeEditPart> list = getEditPartsFor(viewer, element);
		// if list is empty and this is a proxy, refresh the import
		if (list.size() == 0 && element instanceof Unit && PropertyUtils.isProxy((Unit) element)) {
			Import imprt = GMFUtils.getImport((Unit) element);
			final List<DeployShapeNodeEditPart> importList = getEditPartsFor(viewer, imprt);
			if (importList.size() == 1) {
				BusyIndicator.showWhile(Display.getCurrent(), new Runnable() {
					public void run() {
						CanonicalUtils.refresh(importList.get(0), true);
					}
				});
				list = getEditPartsFor(viewer, element);
			}
		}
		return list;
	}

	/**
	 * get all editparts for a unit, even if it doesn't have a view
	 * 
	 * @param viewer
	 * @param element
	 * @return editpart list
	 */
	public static List<DeployShapeNodeEditPart> getOrRefreshEditPartsFor(EditPartViewer viewer,
			final EObject element) {
		List<DeployShapeNodeEditPart> list = getEditPartsFor(viewer, element);
		// if list is empty and this is a unit, refresh diagram to create a view for this unit
		if (list.size() == 0 && element instanceof Unit) {
			BusyIndicator.showWhile(Display.getCurrent(), new Runnable() {
				public void run() {
					List<DeployModelObject> creationList = new ArrayList<DeployModelObject>();
					creationList.add((Unit) element);
					CanonicalUtils.refreshViews(creationList, false);
				}
			});
			list = getEditPartsFor(viewer, element);
		}
		return list;
	}

	/**
	 * @param editpart
	 * @param element
	 * @return ep list
	 */
	static public List<ConnectionNodeEditPart> getLinkEditPartsFor(EditPart editpart, EObject element) {
		if (element != null && !(element instanceof View)) {
			return getLinkEditPartsFor(editpart.getViewer(), element);
		}
		return Collections.emptyList();
	}

	/**
	 * @param viewer
	 * @param element
	 * @return ep list
	 */
	static public List<ConnectionNodeEditPart> getLinkEditPartsFor(EditPartViewer viewer,
			EObject element) {
		if (viewer instanceof DiagramGraphicalViewer) {
			List<ConnectionNodeEditPart> filteredList = new ArrayList<ConnectionNodeEditPart>();
			List list = GMFUtils.getDeployDiagramEditPart(viewer.getRootEditPart())
					.findEditPartsForElement(element, ConnectionNodeEditPart.class);
			// filter out editparts whose view is unattached
			for (Iterator<ConnectionNodeEditPart> it = list.iterator(); it.hasNext();) {
				ConnectionNodeEditPart ep = it.next();
				if (ViewUtil.getContainerView(ep.getNotationView()) != null) {
					filteredList.add(ep);
				}
			}
			return filteredList;
		}
		return Collections.emptyList();
	}

	/**
	 * @param editpart
	 * @param element
	 * @return edge list
	 */
	public static List<Edge> getLinkViewsFor(EditPart editpart, EObject element) {
		List<ConnectionNodeEditPart> list = getLinkEditPartsFor(editpart, element);
		if (list.size() > 0) {
			List<Edge> viewList = new ArrayList<Edge>();
			for (Iterator<ConnectionNodeEditPart> it = list.iterator(); it.hasNext();) {
				viewList.add((Edge) it.next().getNotationView());
			}
			return viewList;
		}
		return Collections.emptyList();
	}

	/**
	 * @param editpart
	 * @param element
	 * @return list
	 */
	static public List<DeployConnectionNodeEditPart> getOverlappingLinkEditPartsFor(
			DeployConnectionNodeEditPart editpart) {
		Set<DeployConnectionNodeEditPart> set = new HashSet<DeployConnectionNodeEditPart>();
		EditPartViewer viewer = editpart.getViewer();
		EditPart sourceEP = editpart.getSource();
		EditPart targetEP = editpart.getTarget();
		for (Iterator<Entry> entries = viewer.getEditPartRegistry().entrySet().iterator(); entries
				.hasNext();) {
			EditPart ep = (EditPart) entries.next().getValue();
			if (ep instanceof ConsolidationLinkEditPart) {
				ConsolidationLinkEditPart linkEP = (ConsolidationLinkEditPart) ep;
				if (linkEP.getSource() == sourceEP && linkEP.getTarget() == targetEP
						|| linkEP.getSource() == targetEP && linkEP.getTarget() == sourceEP) {
					set.addAll(linkEP.getConsolidatedLinkList());
				}
			} else if (ep instanceof DeployConnectionNodeEditPart) {
				DeployConnectionNodeEditPart linkEP = (DeployConnectionNodeEditPart) ep;
				if (linkEP.getSource() == sourceEP && linkEP.getTarget() == targetEP
						|| linkEP.getSource() == targetEP && linkEP.getTarget() == sourceEP) {
					set.add(linkEP);
				}
			}
		}
		return new ArrayList<DeployConnectionNodeEditPart>(set);
	}

	///////////////////////////////////////////////////////////////////////////////////////////////////////////////
	/////////////////////////// check elements to see if they have a cycle problem ///////////////////////////////////////////
	//////////////////////////////////////////////////////////////////////////////////////////////////////////////

	/**
	 * @param templateURIString --
	 *           uri of template
	 * @param isDynamic
	 * @return root elements of the template
	 */

	public static List<Unit> getRootElements(String templateURIString, boolean isDynamic) {
		List<Unit> rootElements = new ArrayList<Unit>();
		createElements(templateURIString, CoreFactory.eINSTANCE.createTopology(), rootElements, null,
				null, null, isDynamic);
		return rootElements;
	}

	/**
	 * create the given template in the topology
	 * 
	 * @param templateURIString
	 *           template URI
	 * @param topology --
	 *           topology to add created units to
	 * @param rootElements --
	 *           an array that is filled with the root elements of the template (those that appear on
	 *           the canvas)
	 * @param hostingLinks
	 *           hosting links in the template
	 * @param memberLinks
	 *           member links in the template
	 * @param diagramEP --
	 *           the diagram editpart-- must be provided if adding template to edit topology to
	 *           suspend caching (for performance)
	 * @param isDynamic
	 * @return created units (which were added to topology)
	 */
	static public Collection createElements(String templateURIString, Topology topology,
			Collection<Unit> rootElements, Collection<HostingLink> hostingLinks,
			Collection<MemberLink> memberLinks, DeployDiagramEditPart diagramEP, boolean isDynamic) {
		// get all objects with cache refresh off
		Collection newObjects = null;
		try {
			// pause canonical refreshes to diagram
			GEFUtils.toggleConnectionLayerValidateEnabled(false);
			if (diagramEP != null) {
				CanonicalUtils.pauseSemanticCacheRefresh(diagramEP);
			}
			newObjects = ResolutionUtils.doRealElementCreation(templateURIString, topology, isDynamic);
		} finally {
			GEFUtils.toggleConnectionLayerValidateEnabled(true);
			if (diagramEP != null) {
				CanonicalUtils.resumeSemanticCacheRefresh(diagramEP);
			}
		}

		if (rootElements != null) {
			// collect all links in new objects
			Collection<HostingLink> newHostingLinks = hostingLinks;
			if (newHostingLinks == null) {
				newHostingLinks = new ArrayList<HostingLink>();
			}
			Collection<MemberLink> newMemberLinks = memberLinks;
			if (newMemberLinks == null) {
				newMemberLinks = new ArrayList<MemberLink>();
			}
			for (Iterator<DeployModelObject> it = newObjects.iterator(); it.hasNext();) {
				DeployModelObject dmo = it.next();
				if (dmo instanceof Unit) {
					Unit unit = (Unit) dmo;
					newHostingLinks.addAll(unit.getEditTopology().getRelationships()
							.getHostedLinks(unit));
					newMemberLinks.addAll(unit.getMemberLinks());
				}
			}
			// determine what the root elements will be (the Units that will get canvas-level GMF Nodes)
			getRootElements(newObjects, newHostingLinks, newMemberLinks, rootElements);
		}
		return newObjects;
	}

	/**
	 * given a collection of new units, determine the root units based on the model
	 * 
	 * @param newObjects
	 * @return root units
	 */
	static public Collection<Unit> getRootElements(Collection newObjects) {
		// collect all links in new objects
		Collection<HostingLink> newHostingLinks = new ArrayList<HostingLink>();
		Collection<MemberLink> newMemberLinks = new ArrayList<MemberLink>();
		for (Iterator<DeployModelObject> it = newObjects.iterator(); it.hasNext();) {
			DeployModelObject dmo = it.next();
			if (dmo instanceof Unit) {
				Unit unit = (Unit) dmo;
				newHostingLinks.addAll(unit.getEditTopology().getRelationships().getHostedLinks(unit));
				newMemberLinks.addAll(unit.getMemberLinks());
			}
		}
		// determine what the root elements will be (the Units that will get canvas-level GMF Nodes)
		Collection<Unit> rootElements = new ArrayList<Unit>();
		getRootElements(newObjects, newHostingLinks, newMemberLinks, rootElements);
		return rootElements;
	}

	/*
	 * based on links determine what the root elements will be.
	 */
	static private Collection<Unit> getRootElements(Collection newObjects,
			Collection<HostingLink> newHostingLinks, Collection<MemberLink> newMemberLinks,
			Collection<Unit> rootElements) {
		rootElements.addAll(newObjects);

		// removeElements is those elements that are targets of member links or have their
		// config bit set and are targets of hosting links.
		Collection<Unit> removeElements = new ArrayList<Unit>();
		for (Iterator<Unit> it = newObjects.iterator(); it.hasNext();) {
			EObject object = it.next();
			if (!(object instanceof Unit)) {
				continue;
			}
			Unit unit = (Unit) object;

			// if this unit is a hosted config unit, it won't be in the root
			if (unit.isConfigurationUnit()) {
				boolean isHostedConfigUnit = false;
				for (Iterator<HostingLink> itHosting = newHostingLinks.iterator(); itHosting.hasNext()
						&& !isHostedConfigUnit;) {
					HostingLink link = itHosting.next();
					isHostedConfigUnit = link.getHosted() == unit;
					if (isHostedConfigUnit) {
						removeElements.add(unit);
					}
				}
			}

			// if this unit is a member, it won't be in the root
			boolean isMember = false;
			for (Iterator<MemberLink> itMember = newMemberLinks.iterator(); itMember.hasNext()
					&& !isMember;) {
				MemberLink link = itMember.next();
				isMember = link.getTarget() == unit;
				if (isMember) {
					removeElements.add(unit);
				}
			}
		}

		rootElements.removeAll(removeElements);

		// make sure a hostinglink and member link don't cancel each other
		// (can't have each other be a member/listed in the other-- solution is a duplicate view in diagram)		
		Collection<Unit> restoreUnits = CanonicalUtils.checkLinkingCycles(removeElements,
				newHostingLinks, newMemberLinks, null, null, false, null, null);
		rootElements.addAll(restoreUnits);
		return rootElements;
	}

	/**
	 * create a view in the diagram to resolve a link cycle problem
	 * 
	 * @param editingDomain
	 * @param diagramEP
	 * @param serverUnit
	 */
	public static void createDupViewForLinkCycleProblem(TransactionalEditingDomain editingDomain,
			DeployDiagramEditPart diagramEP, Unit serverUnit) {

		// see if server will be visible after configUnit view is deleted
		List<HostingLink> hostingLinks = new ArrayList<HostingLink>();
		for (Iterator<HostingLink> it = serverUnit.getEditTopology().findAllHostingLinks(); it
				.hasNext();) {
			hostingLinks.add(it.next());
		}
		List<MemberLink> memberLinks = new ArrayList<MemberLink>();
		for (Iterator<MemberLink> it = serverUnit.getEditTopology().findAllMemberLinks(); it
				.hasNext();) {
			memberLinks.add(it.next());
		}
		List<Unit> removeUnits = new ArrayList<Unit>();
		removeUnits.add(serverUnit);
		Collection restoreUnits = CanonicalUtils.checkLinkingCycles(removeUnits, hostingLinks,
				memberLinks, null, null, false, null, diagramEP);

		// no-- server disappears-- therefore create new copy of server view in canvas
		if (restoreUnits.size() > 0) {
			Unit dupUnit = (Unit) restoreUnits.iterator().next();
			// if server unit was already having a cycle problem, it's already got
			// a view so we don't need to create a new one
			if (!dupUnit.equals(serverUnit)) {
				Node newView = com.ibm.ccl.soa.deploy.core.ui.util.ViewUtil.createNode(
						new EObjectAdapter(dupUnit), (View) diagramEP.getModel(), "", -1, //$NON-NLS-1$
						diagramEP.getDiagramPreferencesHint());
				List epList = getEditPartsFor(diagramEP, dupUnit);
				if (epList.size() > 0) {
					GraphicalEditPart dupEP = (GraphicalEditPart) epList.get(0);
					Rectangle bounds = dupEP.getFigure().getBounds();
					dupEP.getFigure().translateToAbsolute(bounds);
					diagramEP.getFigure().translateToRelative(bounds);
					// position new view where server view used to be
					ViewUtil.setStructuralFeatureValue(newView, NotationPackage.eINSTANCE
							.getLocation_X(), new Integer(bounds.getTopLeft().x));
					ViewUtil.setStructuralFeatureValue(newView, NotationPackage.eINSTANCE
							.getLocation_Y(), new Integer(bounds.getTopLeft().y));
					// if it's a tree, expand it
					View hostingList = ViewUtil.getChildBySemanticHint(newView,
							DeployCoreConstants.HYBRIDLIST_SEMANTICHINT);
					if (hostingList != null) {
						ViewUtil.setStructuralFeatureValue(hostingList, NotationPackage.eINSTANCE
								.getDrawerStyle_Collapsed(), new Boolean(false));
					}
				}
			}
		}
	}

	///////////////////////////////////////////////////////////////////////////////////////////////////////////////
	///////////////////// Import utilities  ///////////////////////////////////////////
	//////////////////////////////////////////////////////////////////////////////////////////////////////////////
	/**
	 * is Editpart a non mutable imported unit?
	 * 
	 * @param ep
	 * @return Import object of parent
	 */
	static public boolean isNonMutableImport(EditPart ep) {
		if (!(ep instanceof IGraphicalEditPart)) {
			return false;
		}

		// see if it's an import element
		EObject eo = ((IGraphicalEditPart) ep).resolveSemanticElement();
		if (eo == null || !(eo instanceof DeployModelObject)) {
			return false;
		}
		DeployModelObject dmo = (DeployModelObject) eo;
		if (dmo.getTopology() == dmo.getEditTopology()) {
			return false;
		}

		Import imprt = null;
		// look for import from parent import topology ep
		ImportTopologyEditPart iep = getImportTopologyEP(ep);
		if (iep != null) {
			imprt = (Import) iep.resolveSemanticElement();
		} else {
			// else if this is a duplicate view, get import from figure
			IFigure ifig = ((IGraphicalEditPart) ep).getFigure();
			if (ifig instanceof CompositeShapeFigure) {
				CompositeShapeFigure fig = (CompositeShapeFigure) ((IGraphicalEditPart) ep).getFigure();
				if (fig.getInnerFigure() instanceof DeployCoreFigure) {
					imprt = ((DeployCoreFigure) fig.getInnerFigure()).getImportObj();
				}
			}
		}
		if (imprt == null) {
			return false;
		}

		return !imprt.getInstanceConfiguration().isPublicEditable(dmo);
	}

	/**
	 * is Editpart a non hostable imported unit?
	 * 
	 * @param ep
	 * @return Import object of parent
	 */
	static public boolean isImportThatCannotHost(EditPart ep) {
		if (!(ep instanceof IGraphicalEditPart)) {
			return false;
		}

		// see if it's an import element
		EObject eo = ((IGraphicalEditPart) ep).resolveSemanticElement();
		if (eo == null || !(eo instanceof DeployModelObject)) {
			return false;
		}
		DeployModelObject dmo = (DeployModelObject) eo;
		if (dmo.getTopology() == dmo.getEditTopology()) {
			return false;
		}

		Import imprt = null;
		// look for import from parent import topology ep
		ImportTopologyEditPart iep = getImportTopologyEP(ep);
		if (iep != null) {
			imprt = (Import) iep.resolveSemanticElement();
		} else {
			// else if this is a duplicate view, get import from figure
			IFigure ifig = ((IGraphicalEditPart) ep).getFigure();
			if (ifig instanceof CompositeShapeFigure) {
				CompositeShapeFigure fig = (CompositeShapeFigure) ((IGraphicalEditPart) ep).getFigure();
				if (fig.getInnerFigure() instanceof DeployCoreFigure) {
					imprt = ((DeployCoreFigure) fig.getInnerFigure()).getImportObj();
				}
			}
		}
		if (imprt == null) {
			return false;
		}

		// else return configuration state of original ep's unit
		if (imprt.getInstanceConfiguration().isPublicEditable(dmo)) {
			return false;
		} else if (imprt.getInstanceConfiguration().isPublic(dmo)) {
			return false;
		} else {
			return true;
		}

	}

	/**
	 * @param ep
	 * @return an ImportTopologyEditPart
	 */
	public static ImportTopologyEditPart getImportTopologyEP(EditPart ep) {
		EditPart walker = ep;
		while (walker != null) {
			if (walker instanceof ImportTopologyEditPart) {
				return (ImportTopologyEditPart) walker;
			} else if (walker instanceof DeployDiagramEditPart) {
				return null;
			}
			walker = walker.getParent();
		}
		return null;
	}

	/**
	 * @param ep
	 * @return an DiagramNodeEditPart
	 */
	public static DiagramNodeEditPart getDiagramNodeEP(EditPart ep) {
		EditPart walker = ep;
		while (walker != null) {
			if (walker instanceof DiagramNodeEditPart) {
				return (DiagramNodeEditPart) walker;
			} else if (walker instanceof DeployDiagramEditPart) {
				return null;
			}
			walker = walker.getParent();
		}
		return null;
	}

	/**
	 * @param ep
	 * @return ture if ep part is in an import topology figure
	 */
	public static boolean isImportTopology(EditPart ep) {
		return getImportTopologyEP(ep) != null;
	}

	/**
	 * @param host
	 * @return is import topology that's in shapes mode
	 */
	public static boolean isImportTreeTopology(EditPart host) {
		ImportTopologyEditPart ep = getImportTopologyEP(host);
		if (ep != null && DeployShapeNodeEditPart.isTreeMode(ep)) {
			return true;
		}
		return false;
	}

	/**
	 * @param ep
	 * @return ture if ep part is in an diagram node figure
	 */
	public static boolean isDiagramNode(EditPart ep) {
		return getDiagramNodeEP(ep) != null;
	}

	/**
	 * @param ep
	 * @return ture if ep part is in an diagram node figure
	 */
	public static boolean isDiagramTreeNode(EditPart host) {
		DiagramNodeEditPart ep = getDiagramNodeEP(host);
		if (ep != null && DeployShapeNodeEditPart.isTreeMode(ep)) {
			return true;
		}
		return false;
	}

	/**
	 * @param unit
	 * @return import it belongs to
	 */
	public static Import getImport(Unit unit) {
		if (unit != null) {
			Topology editTopology = unit.getEditTopology();
			if (editTopology != null) {
				for (Iterator<Import> it = editTopology.getImports().iterator(); it.hasNext();) {
					Import imprt = it.next();
					InstanceConfiguration instanceConfig = imprt.getInstanceConfiguration();
					if (instanceConfig != null) {
						if (instanceConfig.getPublicUnits().contains(unit)) {
							return imprt;
						}
					}
				}
			}
		}
		return null;
	}

	/**
	 * @param link
	 * @return is this a link inside of an import topology
	 */
	public static boolean isInnerImportLink(DeployLink link) {
		// if this link doesn't belong to this topology and not a logical link
		if (link != null && !(link instanceof ConstraintLink)
				&& link.getTopology() != link.getEditTopology()) {
			DeployModelObject source = null;
			DeployModelObject target = null;
			if (link instanceof UnitLink) {
				source = ((UnitLink) link).getSource();
				target = ((UnitLink) link).getTarget();
			} else if (link instanceof DependencyLink) {
				source = ((DependencyLink) link).getSource();
				target = ((DependencyLink) link).getTarget();
			} else if (link instanceof RealizationLink) {
				source = ((RealizationLink) link).getSource();
				target = ((RealizationLink) link).getTarget();
			}
			if (source != null && target != null) {
				Topology sourceTop = source.getTopology();
				if (sourceTop != target.getEditTopology() && sourceTop == target.getTopology()) {
					return true;
				}
			}
		}
		return false;
	}

	/**
	 * is this dmo a mutable imported ?
	 * 
	 * @param dmo
	 * @return if not an import or if its configurable
	 */
	public static boolean isNonMutableImport(Unit unit) {
		if (PropertyUtils.isProxy(unit)) {
			ConfigurationContract contract = unit.getTopology().getConfigurationContract();
			return !contract.isPublicEditable(unit);
		}
		return false;
	}

	///////////////////////////////////////////////////////////////////////////////////////////////////////////////
	///////////////////// Misc  ///////////////////////////////////////////
	//////////////////////////////////////////////////////////////////////////////////////////////////////////////

	/**
	 * get displayable name from an object
	 * 
	 * @param object
	 * @return name
	 */
	static public String getDmoName(EObject object) {
		// use all naming strategies
		String name = null;
		if (object instanceof Unit) {
			name = ((Unit) object).getCaptionProvider().title((Unit) object);
		} else if (object instanceof Service) {
			name = ((Service) object).getDisplayName();
		}
		if ((name == null || name.length() == 0) && object != null) {
			name = EMFCoreUtil.getName(object);
		}
		if (name == null || name.length() == 0) {
			name = Messages.NAME;
		}
		return name;
	}

	/**
	 * @param view
	 * @return is view visible
	 */
	static public boolean isViewVisible(View view) {
		EObject walker = view.eContainer();
		while (walker != null && walker instanceof View && !(walker instanceof Diagram)) {
			// if parent is collapsed, return false
			if (((Boolean) ViewUtil.getStructuralFeatureValue((View) walker, NotationPackage.eINSTANCE
					.getDrawerStyle_Collapsed())).booleanValue()) {
				return false;
			}
			walker = ((View) walker).eContainer();
		}
		return true;
	}

	/**
	 * create a rect that only is as big as the figure rect that's visible from within its containers
	 * 
	 * @param figure
	 * @return rect
	 */
	static public Rectangle getClipRectangle(IFigure figure) {
		Rectangle rect = figure.getBounds().getCopy();
		figure.translateToAbsolute(rect);
		IFigure parentFigure = figure.getParent();

		while (parentFigure != null) {
			if (parentFigure instanceof DeployDiagramFigure) {
				break;
			} else if (parentFigure instanceof ResizableCompartmentFigure) {
				Rectangle parentClientArea = parentFigure.getClientArea().getCopy();
				parentFigure.translateToAbsolute(parentClientArea);
				rect = rect.intersect(parentClientArea);
			}
			parentFigure = parentFigure.getParent();
		}
		GEFUtils.translateToScrolled(rect);
		return rect;
	}

	/**
	 * @param figure
	 * @return is figure visible
	 */
	static public boolean isFigureVisible(IFigure figure) {
		Rectangle refRect = figure.getBounds().getCopy();
		figure.translateToAbsolute(refRect);
		IFigure parentFigure = figure.getParent();

		while (parentFigure != null) {
			if (!parentFigure.isVisible()) {
				return false;
			}
			// if list, we just care that it's expanded
			if (parentFigure instanceof DeployListCompartmentFigure
					&& !((DeployListCompartmentFigure) parentFigure).isExpanded()) {
				return false;
				// else if it's a group, we also care if it's visible within the group 
			} else if (parentFigure instanceof DeployShapeCompartmentFigure) {

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
	 * sort entries by distance from upper left corner of diagram
	 * 
	 * @param viewSet
	 * @return sorted list of views
	 */
	public static List<Entry<Rectangle, View>> getViewsByRectangle(
			Set<Entry<Rectangle, View>> viewSet) {
		List<Entry<Rectangle, View>> list = new ArrayList<Entry<Rectangle, View>>(viewSet.size());
		list.addAll(viewSet);
		Collections.sort(list, new Comparator<Entry<Rectangle, View>>() {
			public int compare(Entry<Rectangle, View> e1, Entry<Rectangle, View> e2) {
				return compareRectangles(e1.getKey(), e2.getKey());
			}
		});
		return list;
	}

	/**
	 * @param r1
	 * @param r2
	 * @return 0== same, -1== r1 is higher, 1 r2 is higher
	 */
	public static int compareRectangles(Rectangle r1, Rectangle r2) {
		if (r1.getTopLeft().equals(r2.getTopLeft())) {
			return 0; // they are the same
		} else if (r1.y + r1.height < r2.y) {
			return -1; // r1 is higher
		} else if (r1.y > r2.y + r2.height) {
			return 1; // r2 is higher
		} else if (r1.intersects(r2)) {
			Rectangle r = r1.getCopy().intersect(r2);
			int pWidthOverlap = r.width * 100 / r1.width;
			int pHeightOverlap = r.height * 100 / r1.height;
			if (pHeightOverlap > pWidthOverlap) {
				if (r1.x < r2.x) {
					return -1;
				}
				return 1;
			}
			if (r1.y < r2.y) {
				return -1;
			}
			return 1;
		} else if (r1.x < r2.x) {
			return -1; // r1 if further to left
		} else {
			return 1; // r2 is further to the left
		}
	}

	/**
	 * @param hosteeEP
	 * @param hostEP
	 * @return is hostee a hostee on host
	 */
	public static boolean isHosteeOf(GraphicalEditPart hosteeEP, GraphicalEditPart hostEP) {
		Object o = hostEP.resolveSemanticElement();
		Object hostee = hosteeEP.resolveSemanticElement();
		if (o != null && o instanceof Unit) {
			Unit hostUnit = (Unit) o;
			return isHosteeOf(hostee, hostUnit);
		}
		return false;
	}

	/**
	 * @param hostee
	 * @param hostUnit
	 * @return is hostee a hostee on host
	 */
	public static boolean isHosteeOf(Object hostee, Unit hostUnit) {
		if (hostUnit != null) {
			Topology container = hostUnit.getEditTopology();
			if (container != null) {
				IRelationshipChecker relationships = container.getRelationships();
				// try regular hosting links
				for (Iterator<?> it = relationships.getHostedLinks(hostUnit).iterator(); it.hasNext();) {
					HostingLink link = (HostingLink) it.next();
					if (link.getHosted() == hostee) {
						return true;
					}
				}
				//try deferred hosts
				for (Iterator<?> it = relationships.getConstraintLinkSourcesLinks(hostUnit).iterator(); it
						.hasNext();) {
					Object o = it.next();
					if (o instanceof ConstraintLink) {
						ConstraintLink link = (ConstraintLink) o;
						if (GMFUtils.isHostingLink(link)) {
							return true;
						}
					}
				}
			}
		}
		return false;
	}

	/**
	 * @param hostee
	 * @return all host units of this unit
	 */
	static public List<Unit> getAllHosts(Unit hostee) {
		Topology container = hostee.getEditTopology();
		List<Unit> hosts = new ArrayList<Unit>();
		if (container != null) {
			IRelationshipChecker relationships = container.getRelationships();

			// regular hosts
			hosts.addAll(relationships.getHost(hostee));

			//deferred hosts
			for (ConstraintLink link : relationships.getConstraintLinkTargetsLinks(hostee)) {
				if (GMFUtils.isHostingLink(link)) {
					hosts.add(getUnit(link.getTarget()));
				}
			}
		}
		return hosts;
	}

	/**
	 * @param host
	 * @return all hostee units of this unit
	 */
	static public List<Unit> getAllHostees(Unit host) {
		List<Unit> hostees = new ArrayList<Unit>();
		Topology container = host.getEditTopology();
		if (container != null) {
			IRelationshipChecker relationships = container.getRelationships();
			// fetch all true hostees
			hostees.addAll(relationships.getHosted(host));

			// get deferred host links
			for (ConstraintLink link : relationships.getConstraintLinkSourcesLinks(host)) {
				if (GMFUtils.isHostingLink(link)) {
					hostees.add((Unit) link.getSource());
				}
			}
		}
		return hostees;
	}

	/**
	 * @param hosted
	 * @return all host links for the given hostee
	 */
	static public List<HostingLink> getAllHostLinks(Unit hosted) {
		if (hosted == null) {
			return Collections.emptyList();
		}
		Topology topology = hosted.getEditTopology();
		if (topology == null) {
			return Collections.emptyList();
		}
		List<HostingLink> list = new ArrayList<HostingLink>();
		IRelationshipChecker relationships = topology.getRelationships();

		// get regular host links
		list.addAll(relationships.getHostLinks(hosted));

		// get deferred host links
		for (ConstraintLink link : relationships.getConstraintLinkTargetsLinks(hosted)) {
			if (GMFUtils.isHostingLink(link)) {
				list.add(new DeferredHostingLinkImpl(link));
			}
		}
		return list;
	}

	/**
	 * @param host
	 * @return all hostee links for the given host
	 */
	static public List<HostingLink> getAllHostedLinks(Unit host) {
		List<HostingLink> list = new ArrayList<HostingLink>();
		if (host.getEditTopology() != null) {
			IRelationshipChecker relationships = host.getEditTopology().getRelationships();

			// get regular host links
			list.addAll(relationships.getHostedLinks(host));

			// get deferred host links
			for (ConstraintLink link : relationships.getConstraintLinkSourcesLinks(host)) {
				if (GMFUtils.isHostingLink(link)) {
					list.add(new DeferredHostingLinkImpl(link));
				}
			}
		}
		return list;
	}

	/**
	 * @param eo
	 * @return is this a hosting or deferred hosting link
	 */
	public static boolean isHostingLink(EObject eo) {
		if (eo instanceof HostingLink) {
			return true;
		} else if (eo instanceof ConstraintLink) {
			ConstraintLink clink = (ConstraintLink) eo;
			return clink.getConstraints().size() == 1
					&& clink.getConstraints().get(0) instanceof DeferredHostingConstraint;
		}
		return false;
	}

	/**
	 * @param memberEP
	 * @param groupEP
	 * @return is member a member of this group
	 */
	public static boolean isMemberOf(GraphicalEditPart memberEP, GraphicalEditPart groupEP) {
		Object o = groupEP.resolveSemanticElement();
		Object member = memberEP.resolveSemanticElement();
		if (o != null && o instanceof Unit) {
			return isMemberOf(member, (Unit) o);
		}
		return false;
	}

	/**
	 * @param memberEO
	 * @param groupUnit
	 * @return is member a member of this group
	 */
	public static boolean isMemberOf(Object memberEO, Unit groupUnit) {
		for (Iterator<?> it = groupUnit.getMemberLinks().iterator(); it.hasNext();) {
			MemberLink link = (MemberLink) it.next();
			if (link.getTarget() == memberEO) {
				return true;
			}
		}
		return false;
	}

	/**
	 * @param unit
	 * @param containerUnit
	 * @return is member or hostee of container
	 */
	public static boolean isHosteeOrMemberOf(Object unit, Unit containerUnit) {
		return isHosteeOf(unit, containerUnit) || isMemberOf(unit, containerUnit);
	}

	/**
	 * get list of editparts of duplicate views of the passed ep, including the passed ep -- also get
	 * all of the duplicate editparts for each duplicate editpart
	 * 
	 * @param ep
	 * @return a list of all contained duplicate editparts
	 */
	public static List getAllContainedDuplicateEditParts(GraphicalEditPart ep) {
		List<EditPart> list = new ArrayList<EditPart>();
		getAllContainedDuplicateEditPartsHelper(ep, list);
		return list;
	}

	private static void getAllContainedDuplicateEditPartsHelper(GraphicalEditPart ep,
			List<EditPart> list) {
		if (ep instanceof DeployShapeNodeEditPart) {
			View view = ep.getNotationView();
			if (view != null && isDuplicateView(ep, view)) {
				list.addAll(getEditPartsFor(ep, ep.resolveSemanticElement()));
			}
		}
		for (Iterator it = ep.getChildren().iterator(); it.hasNext();) {
			getAllContainedDuplicateEditPartsHelper((GraphicalEditPart) it.next(), list);
		}

	}

	/**
	 * @param ep
	 * @return all contained units of this ep
	 */
	public static List<DeployModelObject> getAllContainedUnits(DeployShapeNodeEditPart ep) {
		Set<DeployModelObject> set = new HashSet<DeployModelObject>();
		List list = new ArrayList();
		list.add(ep);
		getAllContainedUnitsHelper(list, set);
		return new ArrayList<DeployModelObject>(set);
	}

	private static void getAllContainedUnitsHelper(List<?> list, Set<DeployModelObject> set) {
		for (Iterator<?> it = list.iterator(); it.hasNext();) {
			EditPart e = (EditPart) it.next();
			if (e instanceof DeployShapeNodeEditPart) {
				DeployShapeNodeEditPart ep = (DeployShapeNodeEditPart) e;
				if (ep.isActive()) {
					EObject eo = ep.resolveSemanticElement();
					if (eo instanceof DeployModelObject) {
						set.add((DeployModelObject) eo);
					}
					EditPart compartment = DeployShapeNodeEditPart.getListCompartment(ep);
					if (compartment != null) {
						getAllContainedUnitsHelper(compartment.getChildren(), set);
					} else {
						compartment = DeployShapeNodeEditPart.getShapesCompartment(ep);
						if (compartment != null) {
							getAllContainedUnitsHelper(compartment.getChildren(), set);
						}
					}
				}
			}
		}
	}

	/**
	 * @param obj
	 * @return unit of the contained reference/capability
	 */
	static public Unit getUnit(EObject obj) {
		while (!(obj instanceof Unit) && obj != null) {
			obj = obj.eContainer();
		}
		if (obj instanceof Unit) {
			return (Unit) obj;
		}
		return null;
	}

	/**
	 * @param selection
	 * @return is any selection a DiagramNodeEditPart
	 */
	public static boolean isDiagramNodeSelected(IStructuredSelection selection) {
		for (Iterator it = selection.iterator(); it.hasNext();) {
			if (it.next() instanceof DiagramNodeEditPart) {
				return true;
			}
		}
		return false;
	}

	/**
	 * @param request
	 * @return is this a view or model delete?
	 */
	public static boolean isDeleteRequest(Request request) {
		// view delete request?
		if (RequestConstants.REQ_DELETE.equals(request.getType())) {
			return true;
		}
		// model delete request?
		if (request instanceof EditCommandRequestWrapper) {
			EditCommandRequestWrapper wrapper = (EditCommandRequestWrapper) request;
			IEditCommandRequest req = wrapper.getEditCommandRequest();
			if (req instanceof DestroyElementRequest) {
				return true;
			}
		}
		return false;

	}

	public static IStatus hasContainedMatchingOptions(Unit sourceUnit, DeployValidatorService dvs,
			List<GraphicalEditPart> children) {
		IStatus status = HOSTING_LINK_CANNOT_BE_CREATED_BETWEEN_THE_UNITS;
		for (Iterator<GraphicalEditPart> iterator = children.iterator(); iterator.hasNext()
				&& !status.isOK();) {
			GraphicalEditPart child = iterator.next();
			if (isNestableEditPart(child)) {
				status = hasContainedMatchingOptions(sourceUnit, dvs, child.getChildren());
			} else if (isModelEditPart(child)) {
				EObject semanticChildElement = child.resolveSemanticElement();
				if (semanticChildElement instanceof Unit) {
					status = dvs.canCreateLink((Unit) semanticChildElement, sourceUnit, new LinkType[] {
							LinkType.HOSTING, LinkType.CONSTRAINT },
							DeployValidatorService.MATCHER_DEPTH_ALL);
				}
			}
		}
		return status != null ? status : HOSTING_LINK_CANNOT_BE_CREATED_BETWEEN_THE_UNITS;
	}

	public static List<Unit> findContainedMatchingOptions(Unit sourceUnit,
			DeployValidatorService dvs, List<GraphicalEditPart> children) {
		List<Unit> accumulated = new ArrayList();
		internalFindContainedMatchingOptions(sourceUnit, dvs, children, accumulated);
		return accumulated;
	}

	private static void internalFindContainedMatchingOptions(Unit sourceUnit,
			DeployValidatorService dvs, List<GraphicalEditPart> children, List<Unit> accumulated) {
		for (Iterator<GraphicalEditPart> iterator = children.iterator(); iterator.hasNext();) {
			GraphicalEditPart child = iterator.next();
			if (isNestableEditPart(child)) {
				internalFindContainedMatchingOptions(sourceUnit, dvs, child.getChildren(), accumulated);
			} else if (isModelEditPart(child)) {
				EObject semanticChildElement = child.resolveSemanticElement();
				if (semanticChildElement instanceof Unit) {
					if (dvs.canCreateLink((Unit) semanticChildElement, sourceUnit,
							new LinkType[] { LinkType.HOSTING, LinkType.CONSTRAINT },
							DeployValidatorService.MATCHER_DEPTH_ALL).isOK()) {
						if (!accumulated.contains(semanticChildElement)) {
							accumulated.add((Unit) semanticChildElement);
						} else {
							// could we have cycled back on ourselves? 
							return;
						}
					}
				}
			}
		}
	}

	public static boolean isModelEditPart(GraphicalEditPart child) {
		return child instanceof DeployShapeNodeEditPart;
	}

	public static boolean isNestableEditPart(GraphicalEditPart child) {
		return child instanceof ShapeCompartmentEditPart || child instanceof ListCompartmentEditPart;
	}

}
