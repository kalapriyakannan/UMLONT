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
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.gef.EditPart;
import org.eclipse.gef.commands.CompoundCommand;
import org.eclipse.gef.editparts.AbstractGraphicalEditPart;
import org.eclipse.gmf.runtime.common.core.command.CompositeCommand;
import org.eclipse.gmf.runtime.diagram.core.util.ViewUtil;
import org.eclipse.gmf.runtime.diagram.ui.commands.ICommandProxy;
import org.eclipse.gmf.runtime.diagram.ui.editparts.ConnectionEditPart;
import org.eclipse.gmf.runtime.diagram.ui.editparts.IGraphicalEditPart;
import org.eclipse.gmf.runtime.diagram.ui.editparts.ResizableCompartmentEditPart;
import org.eclipse.gmf.runtime.diagram.ui.editpolicies.CanonicalConnectionEditPolicy;
import org.eclipse.gmf.runtime.diagram.ui.editpolicies.CanonicalEditPolicy;
import org.eclipse.gmf.runtime.diagram.ui.editpolicies.EditPolicyRoles;
import org.eclipse.gmf.runtime.diagram.ui.figures.ResizableCompartmentFigure;
import org.eclipse.gmf.runtime.notation.Diagram;
import org.eclipse.gmf.runtime.notation.NotationPackage;
import org.eclipse.gmf.runtime.notation.View;

import com.ibm.ccl.soa.deploy.core.ConstraintLink;
import com.ibm.ccl.soa.deploy.core.DependencyLink;
import com.ibm.ccl.soa.deploy.core.DeployModelObject;
import com.ibm.ccl.soa.deploy.core.HostingLink;
import com.ibm.ccl.soa.deploy.core.IRelationshipChecker;
import com.ibm.ccl.soa.deploy.core.InstanceConfiguration;
import com.ibm.ccl.soa.deploy.core.MemberLink;
import com.ibm.ccl.soa.deploy.core.RealizationLink;
import com.ibm.ccl.soa.deploy.core.Topology;
import com.ibm.ccl.soa.deploy.core.Unit;
import com.ibm.ccl.soa.deploy.core.ui.Messages;
import com.ibm.ccl.soa.deploy.core.ui.editor.DeployCoreEditor;
import com.ibm.ccl.soa.deploy.core.ui.editparts.DeployConnectionNodeEditPart;
import com.ibm.ccl.soa.deploy.core.ui.editparts.DeployDiagramEditPart;
import com.ibm.ccl.soa.deploy.core.ui.editparts.DeployListCompartmentEditPart;
import com.ibm.ccl.soa.deploy.core.ui.editparts.DeployShapeNodeEditPart;
import com.ibm.ccl.soa.deploy.core.ui.editparts.ImportShapesCompartmentEditPart;
import com.ibm.ccl.soa.deploy.core.ui.editpolicies.DeployCanonicalEditPolicy;
import com.ibm.ccl.soa.deploy.core.ui.editpolicies.DeployDiagramCanonicalEditPolicy;
import com.ibm.ccl.soa.deploy.core.ui.editpolicies.DeployEditPolicyRoles;
import com.ibm.ccl.soa.deploy.core.ui.figures.DeployListCompartmentFigure;
import com.ibm.ccl.soa.deploy.core.ui.internal.commands.CollapseCommand;
import com.ibm.ccl.soa.deploy.core.ui.notation.DeployNotationPackage;
import com.ibm.ccl.soa.deploy.core.ui.notation.DeployStyle;
import com.ibm.ccl.soa.deploy.core.ui.properties.PropertyUtils;
import com.ibm.xtools.diagram.ui.common.utils.DiagramUtils;

/**
 * @author jswanke
 * 
 */
public class CanonicalUtils {
	/**
	 * maintain semantic model data in cache
	 * 
	 * @since 7.0
	 * 
	 */
	public class SemanticCacheData {
		private boolean isRefreshPaused = false;
		private boolean isDifferedRefresh = false;
		private final Map<Unit, UnitLinkData> linkCacheMap = new HashMap<Unit, UnitLinkData>();
		private final Map<InstanceConfiguration, List<Unit>> importCacheMap = new HashMap<InstanceConfiguration, List<Unit>>();
		private final Map<InstanceConfiguration, List<Unit>> listFilteredImportCacheMap = new HashMap<InstanceConfiguration, List<Unit>>();
		private final Map<InstanceConfiguration, List<Unit>> shapesFilteredImportCacheMap = new HashMap<InstanceConfiguration, List<Unit>>();

		public boolean isRefreshPaused() {
			return isRefreshPaused;
		}

		public void setRefreshPaused(boolean isRefreshPaused) {
			this.isRefreshPaused = isRefreshPaused;
		}

		public Map<Unit, UnitLinkData> getLinkCacheMap() {
			return linkCacheMap;
		}

		public boolean isDifferedRefresh() {
			return isDifferedRefresh;
		}

		public void setDifferedRefresh(boolean isDifferedRefresh) {
			this.isDifferedRefresh = isDifferedRefresh;
		}

		public Map<InstanceConfiguration, List<Unit>> getImportCacheMap() {
			return importCacheMap;
		}
	}

	/**
	 * maintain link data on each unit in a topology
	 * 
	 * @since 7.0
	 * 
	 */
	public class UnitLinkData {
		List<HostingLink> hostingLinks = null;
		List<HostingLink> allHostingLinks = null; // includes deferred
		List<DependencyLink> dependencyLinks = null;
		List<ConstraintLink> constraintLinks = null;
		List<RealizationLink> realizationLinks = null;

		public List<HostingLink> getHostingLinks() {
			if (hostingLinks == null) {
				hostingLinks = new ArrayList<HostingLink>();
			}
			return hostingLinks;
		}

		public List<HostingLink> getAllHostingLinks() {
			if (allHostingLinks == null) {
				allHostingLinks = new ArrayList<HostingLink>();
			}
			return allHostingLinks;
		}

		public List<DependencyLink> getDependencyLinks() {
			if (dependencyLinks == null) {
				dependencyLinks = new ArrayList<DependencyLink>();
			}
			return dependencyLinks;
		}

		public List<ConstraintLink> getConstraintLinks() {
			if (constraintLinks == null) {
				constraintLinks = new ArrayList<ConstraintLink>();
			}
			return constraintLinks;
		}

		public List<RealizationLink> getRealizationLinks() {
			if (realizationLinks == null) {
				realizationLinks = new ArrayList<RealizationLink>();
			}
			return realizationLinks;
		}

		public boolean hasHostingLinks() {
			return hostingLinks != null;
		}

		public boolean hasDependencyLinks() {
			return dependencyLinks != null;
		}

		public boolean hasConstraintLinks() {
			return constraintLinks != null;
		}

		public boolean hasRealizationLinks() {
			return realizationLinks != null;
		}

		public void reset() {
			if (hostingLinks != null) {
				hostingLinks.clear();
			}
			if (dependencyLinks != null) {
				dependencyLinks.clear();
			}
			if (constraintLinks != null) {
				constraintLinks.clear();
			}
			if (realizationLinks != null) {
				realizationLinks.clear();
			}
		}
	}

	///////////////////////////////////////////////////////////////////////////////////////////////////////////////
	///////////////////////////   MAKE SURE GMF VIEWS MATCH SEMATIC MODEL        /////////////////////////////////////////
	//////////////////////////////////////////////////////////////////////////////////////////////////////////////

	/**
	 * call refresh on all canonical edit policies in diagram to make the view model match the
	 * semantic model-- but restrict the creation of the views in the canvas to units in the
	 * creationList
	 * 
	 * @param diagramEP
	 * @param creationList
	 * @param refreshCollapsedCompartmentViews
	 */
	public static void refreshViews(DeployDiagramEditPart diagramEP,
			List<DeployModelObject> creationList, boolean refreshCollapsedCompartmentViews) {
		// refresh views in diagram
		diagramEP.setCreationList(new ArrayList<DeployModelObject>(creationList));
		diagramEP.setIgnoreRestrictions(creationList == null);
		diagramEP.refresh();
		DeployDiagramCanonicalEditPolicy unitPolicy = (DeployDiagramCanonicalEditPolicy) diagramEP
				.getEditPolicy(DeployEditPolicyRoles.DIAGRAM_CANONICAL_ROLE);
		if (unitPolicy != null) {
			unitPolicy.refreshWithRestrictions(creationList);
		}

		// refresh unit views in all compartments
		Set<DeployShapeNodeEditPart> epList = new HashSet<DeployShapeNodeEditPart>();
		refreshCompartmentViews(diagramEP.getChildren(), epList);

		// should we expand all collapsed compartments and refresh their views too?
		if (refreshCollapsedCompartmentViews) {
			refreshCollapsedCompartmentViews(diagramEP);
		}

		// refresh link views between all those unit views
		refreshEdges(epList);

		// ensure compartments are sized/collapsed correctly
		//fixupCompartmentViews(diagramEP);

		// make sure consolidated links are created
		for (Iterator<DeployShapeNodeEditPart> it = epList.iterator(); it.hasNext();) {
			it.next().refresh();
		}
		diagramEP.setCreationList(null);
		diagramEP.setIgnoreRestrictions(false);
	}

	/**
	 * call refresh on all canonical edit policies in diagram to make the view model match the
	 * semantic model-- but restrict the creation of the views in the canvas to units in the
	 * creationList
	 * 
	 * @param creationList
	 * @param refreshCollapsedCompartmentViews
	 */
	public static void refreshViews(List<DeployModelObject> creationList,
			boolean refreshCollapsedCompartmentViews) {
		DeployCoreEditor editor = ResourceUtils.getActiveDeployEditDomain();
		if (editor != null) {
			refreshViews((DeployDiagramEditPart) editor.getDiagramEditPart(), creationList,
					refreshCollapsedCompartmentViews);
		}
	}

	/**
	 * refresh views given a list of editparts
	 * 
	 * @param refreshList
	 * @param refreshCollapsedCompartmentViews
	 */
	public static List<DeployModelObject> getUnitList(List refreshList) {
		// extract units from editparts
		List<DeployModelObject> newList = new ArrayList<DeployModelObject>();
		for (Iterator<?> it = refreshList.iterator(); it.hasNext();) {
			Object o = it.next();
			if (o instanceof DeployShapeNodeEditPart) {
				newList.add((Unit) ((DeployShapeNodeEditPart) o).resolveSemanticElement());
			}
		}
		return newList;
	}

	/**
	 * call refresh on all link canonical edit policies
	 * 
	 * @param diagramEP
	 */
	public static void refreshLinks(DeployDiagramEditPart diagramEP) {
		// get all DeployShapeNodeEditParts
		Set<DeployShapeNodeEditPart> epList = new HashSet<DeployShapeNodeEditPart>();
		Set<DeployConnectionNodeEditPart> linkList = new HashSet<DeployConnectionNodeEditPart>();
		for (Iterator<?> it = diagramEP.getViewer().getEditPartRegistry().values().iterator(); it
				.hasNext();) {
			Object o = it.next();
			if (o instanceof AbstractGraphicalEditPart) {
				if (((AbstractGraphicalEditPart) o).isActive()) {
					if (o instanceof DeployShapeNodeEditPart) {
						epList.add((DeployShapeNodeEditPart) o);
					} else if (o instanceof DeployConnectionNodeEditPart) {
						linkList.add((DeployConnectionNodeEditPart) o);
					}
				}
			}
		}
		for (Iterator<DeployConnectionNodeEditPart> it = linkList.iterator(); it.hasNext();) {
			it.next().refresh();
		}

		refreshLinks(epList);
	}

	/**
	 * @param epList
	 */
	public static void refreshLinks(Set<DeployShapeNodeEditPart> epList) {
		// refresh link views between all those unit views
		refreshEdges(epList);

		// make sure consolidated links are created
		for (Iterator<DeployShapeNodeEditPart> it = epList.iterator(); it.hasNext();) {
			DeployShapeNodeEditPart ep = it.next();
			if (ep.isActive()) {
				ep.refresh();
			}
		}
		for (Iterator<DeployShapeNodeEditPart> it = epList.iterator(); it.hasNext();) {
			DeployShapeNodeEditPart ep = it.next();
			if (ep.isActive()) {
				for (Iterator<?> it2 = ep.getSourceConnections().iterator(); it2.hasNext();) {
					((ConnectionEditPart) it2.next()).refresh();
				}
				for (Iterator<?> it2 = ep.getTargetConnections().iterator(); it2.hasNext();) {
					((ConnectionEditPart) it2.next()).refresh();
				}
			}
		}
	}

	/**
	 * call refresh on all link canonical edit policies
	 */
	public static void refreshLinks() {
		DeployCoreEditor editor = ResourceUtils.getActiveDeployEditDomain();
		if (editor != null) {
			refreshLinks((DeployDiagramEditPart) editor.getDiagramEditPart());
		}
	}

	/**
	 * refresh all the views within an editpart
	 * 
	 * @param ep
	 * @param refreshCollapsedCompartmentViews
	 *           TODO
	 */
	public static void refresh(IGraphicalEditPart ep, boolean refreshCollapsedCompartmentViews) {
		// run canonicals on all compartments within this editpart
		DeployDiagramEditPart ddep = GMFUtils.getDeployDiagramEditPart(ep);
		ddep.setIgnoreRestrictions(true);
		List<EditPart> list = new ArrayList<EditPart>();
		list.add(ep);
		Set<DeployShapeNodeEditPart> epList = new HashSet<DeployShapeNodeEditPart>();
		refreshCompartmentViews(list, epList);

		// run canonicals on all collapsed compartments in ep
		if (refreshCollapsedCompartmentViews) {
			refreshCollapsedCompartmentViews(ep);
		}

		// refresh link views between all those unit views
		refreshEdges(epList);

		// ensure compartments are sized/collapsed correctly
		//fixupCompartmentViews(ep);
		ddep.setIgnoreRestrictions(false);
	}

	/**
	 * call the refresh policy on all canonical edit policy's for compartments; build up a list of
	 * units for running link canonical edit policies on next
	 */
	private static void refreshCompartmentViews(List<EditPart> children,
			Set<DeployShapeNodeEditPart> epList) {
		for (Iterator<EditPart> it = children.iterator(); it.hasNext();) {
			EditPart ep = it.next();
			if (ep instanceof DeployShapeNodeEditPart) {
				DeployShapeNodeEditPart dsep = (DeployShapeNodeEditPart) ep;
				epList.add(dsep);
				refreshCompartmentView(dsep, DeployCoreConstants.HYBRIDLIST_SEMANTICHINT, epList);
				refreshCompartmentView(dsep, DeployCoreConstants.HYBRIDSHAPES_SEMANTICHINT, epList);
				refreshCompartmentView(dsep, DeployCoreConstants.IMPORTTOPOLOGYLIST_SEMANTICHINT,
						epList);
				refreshCompartmentView(dsep, DeployCoreConstants.DIAGRAMNODELIST_SEMANTICHINT, epList);
				refreshCompartmentView(dsep, DeployCoreConstants.IMPORTTOPOLOGYSHAPES_SEMANTICHINT,
						epList);
				refreshCompartmentView(dsep, DeployCoreConstants.DIAGRAMNODESHAPES_SEMANTICHINT, epList);
			}
		}
	}

	private static void refreshCompartmentView(DeployShapeNodeEditPart editpart,
			String semantichint, Set<DeployShapeNodeEditPart> epList) {
		IGraphicalEditPart ep = editpart.getChildBySemanticHint(semantichint);
		if (ep != null) {
			CanonicalEditPolicy policy = (CanonicalEditPolicy) ep
					.getEditPolicy(EditPolicyRoles.CANONICAL_ROLE);
			if (policy instanceof DeployCanonicalEditPolicy) {
				DeployCanonicalEditPolicy deployPolicy = (DeployCanonicalEditPolicy) policy;
				deployPolicy.setForceEnabledOn(true);
				deployPolicy.refresh();
				deployPolicy.setForceEnabledOn(false);
				ep.refresh();
				refreshCompartmentViews(ep.getChildren(), epList);
			}
		}
	}

	/**
	 * call the refresh policy on all canonical edit policy's for links
	 */
	private static void refreshEdges(Set<DeployShapeNodeEditPart> epList) {
		for (Iterator<DeployShapeNodeEditPart> it = epList.iterator(); it.hasNext();) {
			DeployShapeNodeEditPart editpart = it.next();
			refreshEdge(editpart, DeployEditPolicyRoles.HOSTING_CANONICAL_ROLE);
			refreshEdge(editpart, DeployEditPolicyRoles.DEPENDENCY_CANONICAL_ROLE);
			refreshEdge(editpart, DeployEditPolicyRoles.LOGICAL_CANONICAL_ROLE);
			refreshEdge(editpart, DeployEditPolicyRoles.REALIZATION_CANONICAL_ROLE);
		}
	}

	private static void refreshEdge(DeployShapeNodeEditPart editpart, String canonical_role) {
		CanonicalConnectionEditPolicy policy = (CanonicalConnectionEditPolicy) editpart
				.getEditPolicy(canonical_role);
		policy.refresh();
	}

	///////////////////////////////////////////////////////////////////////////////////////////////////////////////
	///////////////////////////   Refresh views in collpased compartments /////////////////////////////////
	//////////////////////////////////////////////////////////////////////////////////////////////////////////////
	/**
	 * Refresh views in collpased compartments
	 * 
	 * @param ep
	 */
	static public void refreshCollapsedCompartmentViews(IGraphicalEditPart ep) {
		Map<DeployModelObject, Object> refreshedDmoMap = new HashMap<DeployModelObject, Object>();
		refreshCollapsedCompartmentViewsHelper(ep, refreshedDmoMap, 0);
	}

	static private void refreshCollapsedCompartmentViewsHelper(Object o,
			Map<DeployModelObject, Object> refreshedDmoMap, int level) {
		if (o instanceof DeployShapeNodeEditPart) {
			IGraphicalEditPart editpart = (IGraphicalEditPart) o;
			refreshCollapsedCompartmentView(editpart, DeployCoreConstants.HYBRIDLIST_SEMANTICHINT,
					refreshedDmoMap);
			refreshCollapsedCompartmentView(editpart, DeployCoreConstants.HYBRIDSHAPES_SEMANTICHINT,
					refreshedDmoMap);
			refreshCollapsedCompartmentView(editpart,
					DeployCoreConstants.IMPORTTOPOLOGYLIST_SEMANTICHINT, refreshedDmoMap);
			refreshCollapsedCompartmentView(editpart,
					DeployCoreConstants.DIAGRAMNODELIST_SEMANTICHINT, refreshedDmoMap);
			level++;
		}
		if (level <= 5) {
			EditPart ep = (EditPart) o;
			for (Iterator<Object> it = ep.getChildren().iterator(); it.hasNext();) {
				Object child = it.next();
				if (child instanceof DeployShapeNodeEditPart
						|| child instanceof ResizableCompartmentEditPart) {
					refreshCollapsedCompartmentViewsHelper(child, refreshedDmoMap, level);
				}
			}
		}
	}

	private static void refreshCollapsedCompartmentView(IGraphicalEditPart editpart, String hint,
			Map<DeployModelObject, Object> refreshedDmoMap) {
		final IGraphicalEditPart ep = editpart.getChildBySemanticHint(hint);
		if (ep != null) {
			EObject eo = editpart.resolveSemanticElement();
			if (eo instanceof DeployModelObject) {
				// if unit already processed by us, just return (prevents infinite loops in hosting lists)
				DeployModelObject dmo = (DeployModelObject) eo;
				if (refreshedDmoMap.containsKey(dmo)) {
					return;
				}
				refreshedDmoMap.put(dmo, null);

				DeployCanonicalEditPolicy policy = (DeployCanonicalEditPolicy) ep
						.getEditPolicy(EditPolicyRoles.CANONICAL_ROLE);
				if (policy != null) {

					// if the semantic model matches the view model, just return				
					List semanticList = policy.getProtectedSemanticChildrenList();
					List viewList = policy.getProtectedViewChildrenList();
					if (semanticList.size() == viewList.size()) {
						return;
					}

					// expand compartment and refresh its canonical edit policy
					DeployCanonicalEditPolicy deployPolicy = policy;
					deployPolicy.setForceEnabledOn(true);
					deployPolicy.refresh();
					deployPolicy.setForceEnabledOn(false);
				}
			}
		}
	}

	///////////////////////////////////////////////////////////////////////////////////////////////////////////////
	///////////////////////////   MAKE SURE COMPARTMENTS ARE EXPAND AND CORRECT SIZE ////////////////////////////////////
	//////////////////////////////////////////////////////////////////////////////////////////////////////////////
	static private void fixupCompartmentViews(IGraphicalEditPart ep) {
		if (ep != null) {
			final CompoundCommand cc = new CompoundCommand(Messages.CanonicalUtils_0);
			fixupCompartmentViewsHelper(ep.getChildren(), cc);
			if (!cc.isEmpty() && cc.canExecute()) {
				cc.execute();
			}
		}
	}

	static private void fixupCompartmentViewsHelper(List<IGraphicalEditPart> children,
			CompoundCommand cc) {
		for (Iterator<IGraphicalEditPart> it = children.iterator(); it.hasNext();) {
			EditPart childEP = it.next();
			if (childEP instanceof DeployShapeNodeEditPart) {
				DeployShapeNodeEditPart dsep = (DeployShapeNodeEditPart) childEP;

				fixupCompartmentViewsHelpersHelper(dsep, DeployCoreConstants.HYBRIDLIST_SEMANTICHINT,
						cc);
				fixupCompartmentViewsHelpersHelper(dsep, DeployCoreConstants.HYBRIDSHAPES_SEMANTICHINT,
						cc);
				fixupCompartmentViewsHelpersHelper(dsep,
						DeployCoreConstants.IMPORTTOPOLOGYLIST_SEMANTICHINT, cc);
				fixupCompartmentViewsHelpersHelper(dsep,
						DeployCoreConstants.DIAGRAMNODELIST_SEMANTICHINT, cc);
			}
		}
	}

	private static void fixupCompartmentViewsHelpersHelper(DeployShapeNodeEditPart editpart,
			String semantichint, CompoundCommand cc) {
		ResizableCompartmentEditPart compartmentEP = (ResizableCompartmentEditPart) editpart
				.getChildBySemanticHint(semantichint);
		if (compartmentEP != null) {
			// refresh link connections to compartment -- may need to re-attach to outer 
			//  compartment if inner compartment is collapsed
			compartmentEP.refresh();
			if (compartmentEP instanceof DeployListCompartmentEditPart) {
				DeployListCompartmentFigure listFig = (DeployListCompartmentFigure) compartmentEP
						.getFigure();
				if (listFig != null && listFig.isExpanded() && !listFig.isInnerList()) {
					View view = (View) editpart.getModel();
					int width = ((Integer) ViewUtil.getStructuralFeatureValue(view,
							NotationPackage.eINSTANCE.getSize_Width())).intValue();
					int height = ((Integer) ViewUtil.getStructuralFeatureValue(view,
							NotationPackage.eINSTANCE.getSize_Height())).intValue();
					if (width == -1 || height == -1) {
						CollapseCommand collapseCmd = new CollapseCommand(compartmentEP
								.getEditingDomain(), compartmentEP, true);
						CompositeCommand ccc = new CompositeCommand(cc.getLabel());
						ccc.compose(collapseCmd);
						cc.add(new ICommandProxy(ccc));
					}
				}
			} else if (compartmentEP instanceof DeployListCompartmentEditPart) {
				// if compartment is expanded but unit figure size is -1,-1, then collapse figure
				ResizableCompartmentFigure groupFig = (ResizableCompartmentFigure) compartmentEP
						.getFigure();
				if (groupFig != null && groupFig.isExpanded()) {
					View view = (View) editpart.getModel();
					int width = ((Integer) ViewUtil.getStructuralFeatureValue(view,
							NotationPackage.eINSTANCE.getSize_Width())).intValue();
					int height = ((Integer) ViewUtil.getStructuralFeatureValue(view,
							NotationPackage.eINSTANCE.getSize_Height())).intValue();
					if (width == -1 || height == -1) {
						CollapseCommand collapseCmd = new CollapseCommand(compartmentEP
								.getEditingDomain(), compartmentEP, true);
						CompositeCommand ccc = new CompositeCommand(cc.getLabel());
						ccc.compose(collapseCmd);
						cc.add(new ICommandProxy(ccc));
					}
				}

			}
			fixupCompartmentViewsHelper(compartmentEP.getChildren(), cc);
		}
	}

	///////////////////////////////////////////////////////////////////////////////////////////////////////////////
	///////////////////////////  CONTAINER FILTER ////////////////////////////////////
	//////////////////////////////////////////////////////////////////////////////////////////////////////////////

	/**
	 * filters units that are contained in lists, groups or nodes based on links
	 * 
	 * @param ddep
	 * @param units
	 *           to filter
	 * @param importUnits --
	 *           for link cycle algorithm-- if a config unit in the current topology is hosted on a
	 *           proxy in an imported topology, it has a path to the canvas thru that proxy and there
	 *           does not have a cycle problem
	 * @param diagramUnits --
	 *           when looking for linking cycle problems in a multi-diagram environment--if a
	 *           candidate for a top unit is not in this list, it isn't visible in this diagram and
	 *           therefore can't be considered visible to canvas-- therefore must be removed from
	 *           filter
	 * @param isExternalDiagram --
	 *           is this the editor's diagram or an external diagram represented in a compartment
	 *           (import or diagram node)
	 * @param creationList
	 * @return filtered list
	 */

	public static List filterOutContainedUnits2(DeployDiagramEditPart ddep, List units,
			List importUnits, List diagramUnits, boolean isExternalDiagram, EditPart externalEP,
			List<Unit> creationList) {

		List<DeployModelObject> clist = new ArrayList<DeployModelObject>();
		for (Unit unit : creationList) {
			clist.add(unit);
		}
		return filterOutContainedUnits(ddep, units, importUnits, diagramUnits, isExternalDiagram,
				externalEP, clist);
	}

	static public List filterOutContainedUnits(DeployDiagramEditPart ddep, List units,
			List importUnits, List diagramUnits, boolean isExternalDiagram, EditPart externalEP,
			List<DeployModelObject> creationList) {
		// ---- extract links from units----------
		DeployModelObject dmo = (DeployModelObject) ddep.resolveSemanticElement();
		Set<HostingLink> allHostingLinks = new HashSet<HostingLink>();
		Set<MemberLink> allMemberLinks = new HashSet<MemberLink>();

		IRelationshipChecker relationships = dmo.getEditTopology().getRelationships();

		// czcz tracing
//		System.out.println("\n\nabout to filter-------------------------------"); //$NON-NLS-1$
//		for (Iterator it = units.iterator(); it.hasNext();) {
//			System.out.println(GMFUtils.getDmoName((EObject) it.next()));
//		}
//		System.out.println(" "); //$NON-NLS-1$

		// ---- remove all units that live in a hosting list----------
		Set removeUnits = new HashSet();
		for (Iterator it = units.iterator(); it.hasNext();) {
			Unit hosted = (Unit) it.next();

			Collection<HostingLink> links = GMFUtils.getAllHostLinks(hosted);
			allHostingLinks.addAll(links);

			// if unit is hosted on something....
			//HostingLink link = getAnyHostingLink(hosted, links.iterator());
			//if (link != null) {
			if (links.size() > 0) {
				HostingLink link = links.iterator().next();
				Unit host = link.getHost();

				boolean isContainedUnit = ContainmentStateUtils.isContainedUnit(ddep, externalEP,
						hosted);
				if (!PropertyUtils.isProxy(hosted)) {
					// if hosted is not a proxy, we only remove it because it's a non externalize config unit
					if (isExternalDiagram || isContainedUnit) {
						removeUnits.add(hosted);

//						// czcz tracing
//						System.out
//								.println("->filtering " + GMFUtils.getDmoName(hosted) + " as non-proxy hostee "); //$NON-NLS-1$ //$NON-NLS-2$						
					}
				} else if (host.isPublic() && PropertyUtils.isProxy(host)) {
					// if in a import tree, remove if host is in same tree (all hosts are contained by default in an import tree
					if (isExternalDiagram) {
						// only filter is in same import topology-- links to outside of tree are not filtered
						if (hosted.getTopology().equals(host.getTopology())) {
							removeUnits.add(hosted);

//							// czcz tracing
//							System.out
//									.println("->filtering " + GMFUtils.getDmoName(hosted) + " as proxy hostee in an import/import diagram"); //$NON-NLS-1$ //$NON-NLS-2$
						}
						// if outside of a tree, filter out if user mark it to be contained
					} else if (isContainedUnit) {
						removeUnits.add(hosted);

//						// czcz tracing
//						System.out
//								.println("->filtering " + GMFUtils.getDmoName(hosted) + " as a contained proxy hostee"); //$NON-NLS-1$ //$NON-NLS-2$
					}
				}
			}
		}

		// ---- remove all units that live in a group ----------
		Map dupCanvasViewMap = getDuplicateCanvasViewMap(ddep);
		for (Iterator it = units.iterator(); it.hasNext();) {
			Unit unit = (Unit) it.next();
			// already filtered
			if (removeUnits.contains(unit)) {
				continue;
			}

			Collection<MemberLink> links = relationships.getContainerLinks(unit);
			allMemberLinks.addAll(links);

			// if filtering for the edit topology, remove all members unless:
			//		1) this is a duplicate view in the canvas (ignore dupCanvasViewMap if an external diagram (such an import topology)
			if (!links.isEmpty()
					&& (dupCanvasViewMap.get(unit) == null || isExternalDiagram || externalEP instanceof ImportShapesCompartmentEditPart)
					&& unit != null) {

				// if filtering for an import compartment, remove unit if:
				// 	1) the source is in in the same topology as the target
				if (PropertyUtils.isProxy(unit)) {
					Unit source = null;
					for (Iterator<MemberLink> linksIter = links.iterator(); linksIter.hasNext()
							&& !removeUnits.contains(unit);) {
						MemberLink link = linksIter.next();
						source = link.getSource();
						if (PropertyUtils.isProxy(source.getTopology()) || !source.isPublic()) {
							removeUnits.add(unit);

//							// czcz tracing
//							System.out
//									.println("->filtering " + GMFUtils.getDmoName(unit) + " as a contained proxy member"); //$NON-NLS-1$ //$NON-NLS-2$
						}
					}
				} else {
					removeUnits.add(unit);

//					// czcz tracing
//					System.out
//							.println("->filtering " + GMFUtils.getDmoName(unit) + " as a contained member"); //$NON-NLS-1$ //$NON-NLS-2$
				}
			}
		}

		// --- re-add units that have a linking cycle that cause them to live in each other----------
		Collection restoreUnits = checkLinkingCycles(removeUnits, allHostingLinks, allMemberLinks,
				importUnits, diagramUnits, isExternalDiagram, externalEP, ddep);
		removeUnits.removeAll(restoreUnits);

		// don't delete unless included in creationList
		if (creationList == null) {
			removeUnits.clear();
		} else {
			Set filteredRemoveList = new HashSet();
			for (Iterator<?> it = removeUnits.iterator(); it.hasNext();) {
				Object o = it.next();
				if (creationList.contains(o)) {
					filteredRemoveList.add(o);
				}
			}
			removeUnits = filteredRemoveList;
		}

		// czcz tracing
//		System.out.println("\n restoring these units"); //$NON-NLS-1$
//		for (Iterator it = restoreUnits.iterator(); it.hasNext();) {
//			System.out.println(GMFUtils.getDmoName((EObject) it.next()));
//		}

		// determine actual filtered units based on name
		List filteredUnits = new ArrayList();
		for (Iterator it = units.iterator(); it.hasNext();) {
			Unit unit = (Unit) it.next();
			boolean found = false;
			for (Iterator it2 = removeUnits.iterator(); it2.hasNext() && !found;) {
				Unit removeUnit = (Unit) it2.next();
				found = unit.getQualifiedName().equals(removeUnit.getQualifiedName());
			}
			if (!found) {
				filteredUnits.add(unit);
			}
		}

		// remember restored units for delete routines
		Map map = ddep.getLinkCycleDupMap();
		map.clear();
		for (Iterator it = restoreUnits.iterator(); it.hasNext();) {
			map.put(it.next(), null);
		}

		return filteredUnits;
	}

	/**
	 * a cycle problem occurs when hosting and member links cause a unit never to appear in the
	 * canvas; as an example if A is hosted on B and B is a member of A then both A and B will not
	 * appear in the canvas; this is solved by adding A or B back to the canvas to create a duplicate
	 * view, the first in the hosting list, the second on the canvas
	 * 
	 * @param candidates
	 * @param hostList
	 * @param memberList
	 * @param importUnits --
	 *           for link cycle algorithm-- if a config unit in the current topology is hosted on a
	 *           proxy in an imported topology, it has a path to the canvas thru that proxy and there
	 *           does not have a cycle problem
	 * @param diagramUnits --
	 *           when looking for linking cycle problems in a multi-diagram environment--if a
	 *           candidate for a top unit is not in this list, it isn't visible in this diagram and
	 *           therefore can't be considered visible to canvas-- therefore must be removed from
	 *           filter
	 * @param diagramEP
	 *           TODO
	 * @param isImportCompartment
	 * @return list of units that have a cycle problem (and should have duplicate views)
	 */

	static public Collection checkLinkingCycles(Collection candidates, Collection hostList,
			Collection memberList, Collection importUnits, List<DeployModelObject> diagramUnits,
			boolean isExternalDiagram, EditPart externalEP, DeployDiagramEditPart diagramEP) {
		if (diagramEP == null) {
			DeployCoreEditor editor = ResourceUtils.getActiveDeployEditDomain();
			if (editor != null) {
				diagramEP = (DeployDiagramEditPart) editor.getDiagramEditPart();
				if (diagramEP == null) {
					return Collections.EMPTY_LIST;
				}
			}
		}
//		// czcz tracing
//		System.out.println("\nabout to check for link cycle problems"); //$NON-NLS-1$

		Set recoverSet = new HashSet();
		for (Iterator it = candidates.iterator(); it.hasNext();) {
			// these candidate units have been filtered from the canvas/import tree;
			// for each candidate unit, make sure it has a path to the canvas either because
			// it's hosted on a unit that sits on the canvas or it's in a group that sits in the canvas
			Unit unit = (Unit) it.next();

//			// czcz tracing
//			System.out.println("\n		checking " + GMFUtils.getDmoName(unit)); //$NON-NLS-1$

			// we can ignore this candidate unit if it has already been recovered;
			// this can happen because a candidate unit from a previous iteration 
			//  needed to recover this unit in order to get a path to the canvas
			if (recoverSet.contains(unit)) {
//				// czcz tracing
//				System.out.println("		already recovered"); //$NON-NLS-1$
				continue;
			}

			//we give each candidate ten tries to get up to the canvas
			List<Unit> dupViewCandidates = new ArrayList<Unit>();
			dupViewCandidates.add(unit);
			Set prevUnitSet = new HashSet();
			prevUnitSet.add(unit);
			Collection list = null;
			List unitList = new ArrayList();
			unitList.add(unit);
			for (int tries = 0; tries < 10; tries++) { // infinity loop insurance
				// for each candidate unit get a list of all the units that are a host or a group of this candidate unit
				list = checkLinkingCyclesHelper(unitList, hostList, memberList, candidates,
						diagramUnits, dupViewCandidates, isExternalDiagram, externalEP, diagramEP);

//				// czcz tracing
//				System.out.println("		on try " + tries + " found these containing units "); //$NON-NLS-1$//$NON-NLS-2$
//				if (list == null) {
//					System.out.println("		none-- unit has a path to canvas "); //$NON-NLS-1$					
//				} else {
//					for (Iterator itx = list.iterator(); itx.hasNext();) {
//						System.out.println("		->" + GMFUtils.getDmoName((EObject) itx.next())); //$NON-NLS-1$
//					}
//				}

				// -- on the first pass, this will be a list of all hosts and groups of the candidate
				// -- on ensuing passes, this will be a list of the hosts/groups of all of the previous pass's hosts and groups
				// -- if during one of these ensuing passes, there's at least one host/group with nothing above it 
				//			( checkLinkingCyclesHelper returns null) we know that the candidate unit has a path to the canvas
				//        and therefore does not have to be recovered from the remove list and we can skip to the next candidate
				if (list == null) {
					break;
				}

				// before we find the hosts/groups for this list of hosts and groups, filter out
				//  any hosts/groups we have already encountered in a previous iteration (IOW, we've already
				//  been down that path once before
				//  --prevUnitMap: maintains a list of the previous hosts/groups we have encountered
				//  --unitList: receives the groups/hosts that can be processed on the next iteration of this loop
				//  --isRecovered: is set if one of these hosts/groups has already been recovered, in which case
				//			we can skip to the next candidate unit
				//  -- externalUnits: in the case of a native topology config unit hosted on an external host, since the
				//			external host always appears, we have a path and so on to the next candidate unit
				unitList.clear();
				boolean isRecovered = false;
				for (Iterator it2 = list.iterator(); it2.hasNext();) {
					Unit u = (Unit) it2.next();
					// if an import unit, it's listed in import
					if (importUnits != null && importUnits.contains(u)) {
						list = null;
						break;
					}
					if ((isRecovered = recoverSet.contains(u)) == true) {
						break;
					}
					if (!prevUnitSet.contains(u)) {
						unitList.add(u);
						prevUnitSet.add(u);
					}
				}
				if (isRecovered) {
					list = null;
					break;
				}

				// if after we filter out all previous hosts/groups from unitList and there's nothing left then
				//  we've been over all these hosts/groups before, and therefore we have a cycle problem and
				//  need to recover the candidate unit we picked in checkLinkingCyclesHelper and saved in hostUnit
				if (unitList.isEmpty()) {
					break;
				}
			}
			// if list is not null then we couldn't find a clear path for the candidate unit and need to recover 
			// the unit we picked in checkLinkingCyclesHelper and saved in hostUnit
			if (list != null) {

				// we now have a list of possible units to make a dup view on the canvas
				// pick the first non-group unit that exists in the canvas
				Unit recoveredUnit = unit;
				if (dupViewCandidates.size() > 0) {
					if (diagramUnits == null || diagramUnits.size() == 0
							|| diagramUnits.contains(dupViewCandidates.get(0))) {
						recoveredUnit = dupViewCandidates.get(0);
					}
					for (Iterator<Unit> __it = dupViewCandidates.iterator(); __it.hasNext();) {
						Unit __unit = __it.next();
						if (!__unit.isGroup()
								&& (diagramUnits == null || diagramUnits.size() == 0 || diagramUnits
										.contains(__unit))) {
							recoveredUnit = __unit;
							break;
						}
					}
				}

//				// czcz tracing
//				System.out.println("		cycle problem for this unit " + GMFUtils.getDmoName(unit) + //$NON-NLS-1$
//						" retoring this unit to filter " + GMFUtils.getDmoName(recoveredUnit)); //$NON-NLS-1$

				recoverSet.add(recoveredUnit);
			}
		}
		return recoverSet;
	}

	// swimming upstream: 
	//   -- with hosting links, find all the hosts of these units 
	//   -- with member links, find all the groups of these units 
	//	  -- units are the previous units returned by this method
	// 			which is initialized with a candidate unit  
	//   -- returns null if there's no unit above these units which means the candidate 
	//			unit has a path to the diagram/import tree
	static private Collection checkLinkingCyclesHelper(Collection unitList, Collection hostList,
			Collection memberList, Collection candidates, List<DeployModelObject> diagramUnits,
			List<Unit> dupViewCandidates, boolean isExternalDiagram, EditPart externalEP,
			DeployDiagramEditPart diagramEP) {

		Set allUnitSet = new HashSet();

//		// czcz tracing
//		System.out.println("			about to look for containing units"); //$NON-NLS-1$

		for (Iterator it = unitList.iterator(); it.hasNext();) {
			Unit unit = (Unit) it.next();
			Set oneUnitSet = new HashSet();
			// collect all hosts of this unit--but only if it's a config unit
			// (if non-config unit and hosted it sits on the canvas)
			// SPECIAL CASE: if recovering units for external container, non-config hosted units
			//  will be in remove list, therefore we don't need to recover those either
			boolean isContainedUnitHosted = false;
			boolean isContainedUnit = ContainmentStateUtils.isContainedUnit(diagramEP, externalEP,
					unit);
			if (isContainedUnit || isExternalDiagram) {
				for (Iterator it2 = hostList.iterator(); it2.hasNext();) {
					HostingLink hostingLink = (HostingLink) it2.next();
					if (unit.equals(hostingLink.getHosted())) {
						isContainedUnitHosted = true;
						if (hostingLink.getHost() != null) {

//							// czcz tracing
//							System.out.println("			this unit " + GMFUtils.getDmoName(unit) + //$NON-NLS-1$
//									" lives in this host " + GMFUtils.getDmoName(hostingLink.getHost())); //$NON-NLS-1$

							oneUnitSet.add(hostingLink.getHost());
							// in the event there's no path to the canvas for the candidate unit,
							//  we need to keep track of at least one host of the candidate unit that we can
							//  recover from the filter
							if (candidates.contains(hostingLink.getHost())) {

//								// czcz tracing
//								System.out
//										.println("			saving this replacement candidate " + GMFUtils.getDmoName(hostingLink.getHost())); //$NON-NLS-1$

								dupViewCandidates.add(0, hostingLink.getHost());
							} else {

//								// czcz tracing
//								System.out.println("			hostee's host lives in canvas"); //$NON-NLS-1$

								// if our host isn't a candidate for filtering it has a path to the canvas
								return null;
							}
						}
					}
				}
			}
			// collect all groups of this unit
			for (Iterator it2 = memberList.iterator(); it2.hasNext();) {
				MemberLink memberLink = (MemberLink) it2.next();
				if (memberLink.getTarget().equals(unit)) {
					if (memberLink.getSource() != null) {

//						// czcz tracing
//						System.out.println("			this unit " + GMFUtils.getDmoName(unit) + //$NON-NLS-1$
//								" lives in this group " + GMFUtils.getDmoName(memberLink.getSource())); //$NON-NLS-1$

						oneUnitSet.add(memberLink.getSource());
					}
				}
			}
			// if this unit has no host or group and it's view is contained in the diagram then we have a valid path to canvas
			//  NOTE: unit must also be a nonhosted config unit
			// NOTE: if you change diagramUnit check make three tests:
			//  1) drop a winodws OS onto canvas
			//  2) try dropping a contained unit from navigator onto canvas whose containe is not on the canvas
			//  3) try regening a diagram which has contained units (EAR's etc)
			if (oneUnitSet.isEmpty()
					&& (diagramUnits == null || diagramUnits.size() == 0 || diagramUnits.contains(unit))
					&& (!isContainedUnit || !isContainedUnitHosted)) {

//				// czcz tracing
//				System.out
//						.println("			this unit lived in no host or group " + GMFUtils.getDmoName(unit)); //$NON-NLS-1$

				return null;
			}
			allUnitSet.addAll(oneUnitSet);
		}
		// otherwise we return all hosts/groups of every unit in unitList
		return allUnitSet;
	}

	static private Map getDuplicateCanvasViewMap(DeployDiagramEditPart ddep) {
		Map map = new HashMap();
		Diagram diagram = (Diagram) ddep.getModel();
		Iterator it = DiagramUtils.getAllChildViewsIncludingGroup(diagram).iterator();
		while (it.hasNext()) {
			View view = (View) it.next();
			DeployStyle deployStyle = (DeployStyle) view.getStyle(DeployNotationPackage.eINSTANCE
					.getDeployStyle());
			if (deployStyle != null && deployStyle.isIsDuplicateCanvasView()) {
				map.put(view.getElement(), view);
			}
		}
		return map;
	}

	///////////////////////////////////////////////////////////////////////////////////////////////////////////////
	///////////////////////////  CACHE LINK DATA FOR CANONICALLINKPOLICIES ////////////////////////////////////
	//////////////////////////////////////////////////////////////////////////////////////////////////////////////

	// allow multiple object to be added/deleted from model without reacting for each addition/deletion
	/**
	 * @param topology
	 *           prevent changes to topology from causing diagram's canonical edit policy from
	 *           refreshing
	 */
	public static void pauseSemanticCacheRefresh(DeployDiagramEditPart ddep) {
		SemanticCacheData cacheData = ddep.getSemanticCacheData();
		cacheData.setRefreshPaused(true);
	}

	/**
	 * @param topology
	 *           allow changes to topology to cause diagram's canonical edit policy to refresh
	 */
	public static void resumeSemanticCacheRefresh(DeployDiagramEditPart ddep) {
		SemanticCacheData cacheData = ddep.getSemanticCacheData();
		cacheData.setRefreshPaused(false);
		if (cacheData.isDifferedRefresh()) {
			cacheData.setDifferedRefresh(false);
			refreshSemanticLinkCache(ddep);
		}
	}

	/**
	 * @param ddep --
	 *           the diagram edit part
	 * @param topology
	 */
	static public void refreshSemanticLinkCache(DeployDiagramEditPart ddep) {
		SemanticCacheData cacheData = ddep.getSemanticCacheData();
		// if cache is disabled while multiple objects are added to topology, just return
		if (cacheData.isRefreshPaused) {
			cacheData.setDifferedRefresh(true);
			return;
		}

		//////////////////////////////////
		// update link cache
		//////////////////////////////////
		Topology topology = (Topology) ddep.resolveSemanticElement();
		// in case it's corrupted
		if (topology == null) {
			return;
		}
		// load up cache with links
		Map<Unit, UnitLinkData> linkCacheMap = cacheData.getLinkCacheMap();
		linkCacheMap.clear();
		for (Iterator<HostingLink> it = topology.findAllHostingLinks(); it.hasNext();) {
			HostingLink link = it.next();
			getLinkData(linkCacheMap, link.getHost()).getHostingLinks().add(link);
			getLinkData(linkCacheMap, link.getHosted()).getHostingLinks().add(link);
			getLinkData(linkCacheMap, link.getHost()).getAllHostingLinks().add(link);
			getLinkData(linkCacheMap, link.getHosted()).getAllHostingLinks().add(link);
		}
		for (Iterator<ConstraintLink> it = topology.findAllConstraintLinks(); it.hasNext();) {
			ConstraintLink link = it.next();
			getLinkData(linkCacheMap, getUnit(link.getSource())).getConstraintLinks().add(link);
			getLinkData(linkCacheMap, getUnit(link.getTarget())).getConstraintLinks().add(link);
			if (GMFUtils.isHostingLink(link)) {
				HostingLink dlink = new DeferredHostingLinkImpl(link);
				getLinkData(linkCacheMap, getUnit(link.getSource())).getAllHostingLinks().add(dlink);
				getLinkData(linkCacheMap, getUnit(link.getTarget())).getAllHostingLinks().add(dlink);
			}
		}

		for (Iterator<DependencyLink> it = topology.findAllDependencyLinks(); it.hasNext();) {
			DependencyLink link = it.next();
			getLinkData(linkCacheMap, getUnit(link.getSource())).getDependencyLinks().add(link);
			getLinkData(linkCacheMap, getUnit(link.getTarget())).getDependencyLinks().add(link);
		}

		for (Iterator<RealizationLink> it = topology.findAllRealizationLinks(); it.hasNext();) {
			RealizationLink link = it.next();
			getLinkData(linkCacheMap, getUnit(link.getSource())).getRealizationLinks().add(link);
			getLinkData(linkCacheMap, getUnit(link.getTarget())).getRealizationLinks().add(link);
		}
	}

	private static UnitLinkData getLinkData(Map<Unit, UnitLinkData> linkCacheMap, Unit unit) {
		UnitLinkData linkData = linkCacheMap.get(unit);
		if (linkData == null) {
			linkData = new CanonicalUtils().new UnitLinkData();
			linkCacheMap.put(unit, linkData);
		}
		return linkData;
	}

	/**
	 * @param ddep --
	 *           the diagram edit part
	 * @param topology
	 */
	static public void refreshSemanticImportCache(DeployDiagramEditPart ddep,
			InstanceConfiguration instanceConfig) {
		SemanticCacheData cacheData = ddep.getSemanticCacheData();
		//////////////////////////////////
		// update import cache
		//////////////////////////////////
		if (instanceConfig != null) {
			List visibleUnits = instanceConfig.getVisibleUnits();
			cacheData.getImportCacheMap().put(instanceConfig, visibleUnits);
		}
	}

	static private Unit getUnit(EObject obj) {
		while (!(obj instanceof Unit) && obj != null) {
			obj = obj.eContainer();
		}
		if (obj instanceof Unit) {
			return (Unit) obj;
		}
		return null;
	}

	/**
	 * @param ep
	 * @param hostee
	 * @param host
	 * @return does hostee have a hostinglink to host
	 */
	static public boolean isHostedUnit(EditPart ep, Unit hostee, Unit host) {
		DeployDiagramEditPart ddep = GMFUtils.getDeployDiagramEditPart(ep);
		UnitLinkData linkData = ddep.getSemanticCacheData().getLinkCacheMap().get(host);
		if (linkData != null && linkData.hasHostingLinks()) {
			for (Iterator it = linkData.getAllHostingLinks().iterator(); it.hasNext();) {
				HostingLink link = (HostingLink) it.next();
				if (link != null && link.getHosted().equals(hostee)) {
					return true;
				}
			}
		}
		return false;
	}

}
