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

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.Map;

import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.gef.EditPart;
import org.eclipse.gef.EditPartViewer;
import org.eclipse.gef.commands.Command;
import org.eclipse.gmf.runtime.diagram.core.util.ViewUtil;
import org.eclipse.gmf.runtime.diagram.ui.commands.SetViewMutabilityCommand;
import org.eclipse.gmf.runtime.diagram.ui.editparts.IGraphicalEditPart;
import org.eclipse.gmf.runtime.diagram.ui.editparts.INodeEditPart;
import org.eclipse.gmf.runtime.diagram.ui.editpolicies.CanonicalConnectionEditPolicy;
import org.eclipse.gmf.runtime.diagram.ui.parts.IDiagramGraphicalViewer;
import org.eclipse.gmf.runtime.diagram.ui.requests.CreateConnectionViewRequest;
import org.eclipse.gmf.runtime.diagram.ui.requests.CreateConnectionViewRequest.ConnectionViewDescriptor;
import org.eclipse.gmf.runtime.emf.core.util.EMFCoreUtil;
import org.eclipse.gmf.runtime.emf.core.util.EObjectAdapter;
import org.eclipse.gmf.runtime.notation.Edge;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.jface.preference.IPreferenceStore;
import org.eclipse.osgi.util.NLS;

import com.ibm.ccl.soa.deploy.core.ConstraintLink;
import com.ibm.ccl.soa.deploy.core.DependencyLink;
import com.ibm.ccl.soa.deploy.core.HostingLink;
import com.ibm.ccl.soa.deploy.core.RealizationLink;
import com.ibm.ccl.soa.deploy.core.Unit;
import com.ibm.ccl.soa.deploy.core.ui.DeployCoreUIPlugin;
import com.ibm.ccl.soa.deploy.core.ui.Messages;
import com.ibm.ccl.soa.deploy.core.ui.dialogs.DiagramUpdateData;
import com.ibm.ccl.soa.deploy.core.ui.editparts.DeployDiagramEditPart;
import com.ibm.ccl.soa.deploy.core.ui.editparts.DeployShapeNodeEditPart;
import com.ibm.ccl.soa.deploy.core.ui.notation.DeployNotationPackage;
import com.ibm.ccl.soa.deploy.core.ui.notation.DeployStyle;
import com.ibm.ccl.soa.deploy.core.ui.preferences.IDeployPreferences;
import com.ibm.ccl.soa.deploy.core.ui.util.DeployCoreConstants;
import com.ibm.ccl.soa.deploy.core.ui.util.FilterLinkData;
import com.ibm.ccl.soa.deploy.core.ui.util.FilteringUtils;
import com.ibm.ccl.soa.deploy.core.ui.util.GMFUtils;
import com.ibm.ccl.soa.deploy.core.ui.util.CanonicalUtils.UnitLinkData;

/**
 * @since 1.0
 * 
 */
public abstract class DeployLinkCanonicalConnectorEditPolicy extends CanonicalConnectionEditPolicy {

	private Unit hostUnit = null;
	private Map<Unit, UnitLinkData> linkCacheMap = null;
	private DeployDiagramEditPart _ddep = null;

	private DeployDiagramEditPart getDdep() {
		if (_ddep == null) {
			_ddep = GMFUtils.getDeployDiagramEditPart(getHost());
		}
		return _ddep;
	}

	protected Unit getHostUnit() {
		if (hostUnit == null) {
			// if host is not unit it doesn't have hosting/dependency links to it anyway
			EObject eo = host().resolveSemanticElement();
			if (eo instanceof Unit) {
				hostUnit = (Unit) eo;
			}
		}
		return hostUnit;
	}

	protected Map<Unit, UnitLinkData> getLinkCacheMap() {
		if (linkCacheMap == null) {
			DeployDiagramEditPart ddep = GMFUtils.getDeployDiagramEditPart(host());
			if (ddep != null) {
				linkCacheMap = ddep.getSemanticCacheData().getLinkCacheMap();
			}
		}
		return linkCacheMap;
	}

	/*
	 * we modify this to allow the canonical editpolicies to create and maintain multiple link views
	 * to duplicate views -- otherwise it only allows one link view per semantic link element
	 * 
	 * @see org.eclipse.gmf.runtime.diagram.ui.editpolicies.CanonicalConnectionEditPolicy#refreshSemanticConnections()
	 */
	protected List refreshSemanticConnections() {

		// get all current link views
		Collection viewChildren = getConnectionViews();

		// get all current semantic links
		Collection semanticChildren = new HashSet();
		semanticChildren.addAll(getSemanticConnectionsList());

		// determine which current link views should be deleted which includes those that are no longer pointing to a valid
		// semantic link or those that are multiples of the same link view (from the same node
		// to the same node). Note: This does not include duplicate link views between different duplicate node views.
		List orphaned = cleanCanonicalSemanticChildrenAllowDuplicates(viewChildren, semanticChildren);
		deleteViews(orphaned.iterator());

		// create a view for each semantic link element.
		// duplicate link views between duplicate node views are created here in createConnectionViews().
		List viewDescriptors = new ArrayList();
		for (Iterator it = semanticChildren.iterator(); it.hasNext();) {
			EObject semanticChild = (EObject) it.next();
			List viewsList = createConnectionViews(semanticChild);
			for (Iterator it2 = viewsList.iterator(); it2.hasNext();) {
				Edge viewChild = (Edge) it2.next();
				if (viewChild != null) {
					viewDescriptors.add(new EObjectAdapter(viewChild));
				}
			}
		}
		makeViewsMutable(viewDescriptors);

		// now refresh all the connection containers to update the editparts
		HashSet editparts = new HashSet();
		ListIterator li = viewDescriptors.listIterator();
		while (li.hasNext()) {
			IAdaptable adaptable = (IAdaptable) li.next();
			Edge edge = (Edge) adaptable.getAdapter(Edge.class);
			EditPart sourceEP = getEditPartFor(edge.getSource(), edge);
			if (sourceEP != null) {
				editparts.add(sourceEP);
			}
			EditPart targetEP = getEditPartFor(edge.getTarget(), edge);
			if (targetEP != null) {
				editparts.add(targetEP);
			}
		}
		for (Iterator iter = editparts.iterator(); iter.hasNext();) {
			EditPart end = (EditPart) iter.next();
			end.refresh();
		}

		return viewDescriptors;
	}

	/**
	 * Taken from super class and modified to only find orphaned views-- all semantic children are
	 * returned.
	 * 
	 * Synchronizes the semanticChildren with the viewChildren: if a link view (aka edge) in the
	 * viewChildren list has no match in the semanticChildren list add it to the orphaned list so
	 * that it can be deleted on return. An edge is an orphan if it's element doesn't match any
	 * element in the semanticChildren list or if there are more then one edges using it in the
	 * viewChildren list.
	 * 
	 * @param viewChildren
	 *           <code>List</code> of <code>View</code> elements that already exist in the
	 *           container.
	 * @param semanticChildren
	 *           <code>List</code> of semantic elements that are candidates for synchronization
	 * @return <code>List</code> of orphans views that should be deleted from the container.
	 */
	protected List cleanCanonicalSemanticChildrenAllowDuplicates(Collection viewChildren,
			Collection semanticChildren) {
		// loop through the link views associated with this node 
		List orphaned = new ArrayList();
		Map dupEdgesToSemanticMap = new HashMap();
		for (Iterator it = viewChildren.iterator(); it.hasNext();) {
			Edge edgeChild = (Edge) it.next();

			// if the link in this view is not one of the semantic links requried by this node,
			//  set it as an orphan to be deleted
			EObject semanticChild = edgeChild.getElement();
			if (semanticChildren.contains(semanticChild)) {
				// get the edges for this link
				List dupEdges = (List) dupEdgesToSemanticMap.get(semanticChild);
				if (dupEdges == null) {
					dupEdges = new ArrayList();
					dupEdgesToSemanticMap.put(semanticChild, dupEdges);
					dupEdges.add(edgeChild);
				} else {
					// see if we already have a view that has the same soruce/target
					boolean isOrphan = false;
					for (Iterator it2 = dupEdges.iterator(); it2.hasNext() && !isOrphan;) {
						Edge edge = (Edge) it2.next();
						isOrphan = edge.getSource() == edgeChild.getSource()
								&& edge.getTarget() == edgeChild.getTarget();
					}
					// orphaned because we already have a view from source to target with this element
					if (isOrphan) {
						orphaned.add(edgeChild);
					} else {
						dupEdges.add(edgeChild);
					}
				}
			} else {
				// orphaned because this view's semantic link not used by this node 
				orphaned.add(edgeChild);
			}
		}
		return orphaned;
	}

	/*
	 * create all links to all duplicate link views
	 * 
	 * starts by getting the following: source list --the editparts for the source of the semantic
	 * link target list -- the editparts for the target of the semantic link existing list --any link
	 * editparts currently displaying the semantic link
	 * 
	 * then cycles through all permutations of source to target list creating new link editparts
	 * unless they already appear in the existing list
	 * 
	 */
	protected List<Edge> createConnectionViews(EObject connection) {
		List<Edge> list = new ArrayList<Edge>();
		List<DeployShapeNodeEditPart> srcList = getSourceEditPartsFor(connection);
		List<DeployShapeNodeEditPart> tgtList = getTargetEditPartsFor(connection);
		List<Edge> viewList = GMFUtils.getLinkViewsFor(getHost(), connection);

		// loop through all the combinations collecting potential duplicate pairs for links
		List<FilterLinkData> potentialList = new ArrayList<FilterLinkData>();
		for (Iterator<DeployShapeNodeEditPart> srcIt = srcList.iterator(); srcIt.hasNext();) {
			DeployShapeNodeEditPart srcEP = srcIt.next();
			View srcView = (View) srcEP.getModel();
			for (Iterator<DeployShapeNodeEditPart> tgtIt = tgtList.iterator(); tgtIt.hasNext();) {
				DeployShapeNodeEditPart tgtEP = tgtIt.next();
				View tgtView = (View) tgtEP.getModel();

				// if an edge exists for this combination, remember it in filter data so that it can be 
				//  deleted or not created again based on what links are being filtered/added
				Edge existingEdge = null;
				for (Iterator<Edge> viewIt = viewList.iterator(); viewIt.hasNext();) {
					Edge edge = viewIt.next();
					if (edge.getSource() == srcView && edge.getTarget() == tgtView) {
						existingEdge = edge;
					}
				}

				// add new pair to list
				potentialList.add(new FilterLinkData(srcEP, tgtEP, existingEdge));
			}
		}

		// if there are duplicate links, filter out the secondary duplicate links
		if (potentialList.size() > 1) {
			IPreferenceStore store = DeployCoreUIPlugin.getDefault().getPreferenceStore();
			if (store.getBoolean(IDeployPreferences.DEPLOY_FILTER_SECONDARY_DUP_LINKS)) {
				FilteringUtils.filterDupLinks(potentialList, this);
			}
		}

		// create the link views (edges)
		for (Iterator<FilterLinkData> it = potentialList.iterator(); it.hasNext();) {
			FilterLinkData filterData = it.next();
			// create a new edge if it doesn't already exist
			if (!filterData.hasExistingEdge()) {
				Edge edge = createConnectionViewsHelper(filterData.getSource(), filterData.getTarget(),
						connection);
				if (edge != null) {
					list.add(edge);
				}
			}
		}
		return list;
	}

	protected Edge createConnectionViewsHelper(EditPart sep, EditPart tep, EObject connection) {
		if (!canCreateConnection(sep, tep, connection)) {
			return null;
		}
		View sView = (View) sep.getModel();
		View tView = (View) tep.getModel();
		Edge model = null;
		String factoryHint = getDefaultFactoryHint();
		IAdaptable elementAdapter = new CanonicalElementAdapter(connection, factoryHint);
		CreateConnectionViewRequest ccr = getCreateConnectionViewRequest(elementAdapter,
				getFactoryHint(elementAdapter, factoryHint), ViewUtil.APPEND);

		ccr.setType(org.eclipse.gef.RequestConstants.REQ_CONNECTION_START);
		ccr.setSourceEditPart(sep);
		getCreateViewCommand(ccr);
		ccr.setTargetEditPart(tep);
		ccr.setType(org.eclipse.gef.RequestConstants.REQ_CONNECTION_END);
		Command cmd = getCreateViewCommand(ccr);
		if (cmd != null && cmd.canExecute()) {
			List viewAdapters = new ArrayList();
			viewAdapters.add(new EObjectAdapter(((View) host().getModel()).getDiagram()));
			viewAdapters.add(new EObjectAdapter(sView));
			viewAdapters.add(new EObjectAdapter(tView));

			SetViewMutabilityCommand.makeMutable(viewAdapters).execute();

			executeCommand(cmd);
			IAdaptable adapter = (IAdaptable) ccr.getNewObject();
			SetViewMutabilityCommand.makeMutable(adapter).execute();
			model = (Edge) adapter.getAdapter(Edge.class);
			recordCreate(model);
		}
		return model;
	}

	/*
	 * we need to override because base class uses CANONICAL as a test and diagram no longer has
	 * CANONICAL
	 * 
	 * @see org.eclipse.gmf.runtime.diagram.ui.editpolicies.CanonicalConnectionEditPolicy#canCreateConnection(org.eclipse.gef.EditPart,
	 *      org.eclipse.gef.EditPart, org.eclipse.emf.ecore.EObject)
	 */
	protected boolean canCreateConnection(EditPart sep, EditPart tep, EObject connection) {
		if (sep != null && sep.isActive() && tep != null && tep.isActive()) {

			View src = (View) sep.getAdapter(View.class);
			View tgt = (View) tep.getAdapter(View.class);
			if (src != null && tgt != null) {
				return true;
			}
		}
		return false;
	}

	/*
	 * get all the source editparts that this connection connects to (including dups)
	 * 
	 * @see org.eclipse.gmf.runtime.diagram.ui.editpolicies.CanonicalConnectionEditPolicy#getSourceEditPartFor(org.eclipse.emf.ecore.EObject)
	 */
	protected List<DeployShapeNodeEditPart> getSourceEditPartsFor(EObject connection) {
		EObject sel = getUnit(getSourceElement(connection));
		return GMFUtils.getEditPartsFor(getHost(), sel);
	}

	/*
	 * get all the target editparts that this connection connects to (including dups)
	 * 
	 * @see org.eclipse.gmf.runtime.diagram.ui.editpolicies.CanonicalConnectionEditPolicy#getSourceEditPartFor(org.eclipse.emf.ecore.EObject)
	 */
	protected List<DeployShapeNodeEditPart> getTargetEditPartsFor(EObject connection) {
		EObject tel = getUnit(getTargetElement(connection));
		return GMFUtils.getEditPartsFor(getHost(), tel);
	}

	protected Unit getUnit(EObject obj) {
		while (!(obj instanceof Unit) && obj != null) {
			obj = obj.eContainer();
		}
		if (obj instanceof Unit) {
			return (Unit) obj;
		}
		return null;
	}

	/*
	 * when edit policy gathers current edge views for this unit, it gets all the target and source
	 * edge views currently attached to this unit and determines if they're still targeting this
	 * unit's view (if not, this policy will not return them and they will be deleted) (once views
	 * are gathered, they're compared against the getSemanticConnectionsList() list returned above
	 * and any missing views are created)
	 * 
	 * @see org.eclipse.gmf.runtime.diagram.ui.editpolicies.CanonicalConnectionEditPolicy#shouldIncludeConnection(org.eclipse.gmf.runtime.notation.Edge,
	 *      java.util.Collection)
	 */
	protected boolean shouldIncludeConnection(Edge connection, Collection children) {
		return connection.getTarget() == getHost().getModel()
				|| connection.getSource() == getHost().getModel();
	}

	private CreateConnectionViewRequest getCreateConnectionViewRequest(IAdaptable elementAdapter,
			String hint, int index) {
		return new CreateConnectionViewRequest(getConnectionViewDescriptor(elementAdapter, hint,
				index));
	}

	private ConnectionViewDescriptor getConnectionViewDescriptor(IAdaptable elementAdapter,
			String hint, int index) {
		return new ConnectionViewDescriptor(elementAdapter, hint, index, false,
				((IGraphicalEditPart) getHost()).getDiagramPreferencesHint());
	}

	private EditPart getEditPartFor(EObject element, EObject context) {
		if (element != null && !(element instanceof View)) {
			EditPartViewer viewer = getHost().getViewer();
			if (viewer instanceof IDiagramGraphicalViewer) {
				List parts = ((IDiagramGraphicalViewer) viewer).findEditPartsForElement(EMFCoreUtil
						.getProxyID(element), INodeEditPart.class);

				if (parts.isEmpty()) {
					// reach for the container's editpart instead and force it
					// to refresh
					EObject container = element.eContainer();
					EditPart containerEP = getEditPartFor(container, null);
					if (containerEP != null) {
						containerEP.refresh();
						parts = ((IDiagramGraphicalViewer) viewer).findEditPartsForElement(EMFCoreUtil
								.getProxyID(element), INodeEditPart.class);
					}
				}

				// Check if the part is contained with-in the host EditPart
				// since we are canonically updated the host.
				return findEditPartForElement(element, context, parts);
			}
		}

		return (EditPart) host().getViewer().getEditPartRegistry().get(element);
	}

	/**
	 * @param iterator --
	 *           delete duplicate edges
	 */
	public void deleteEdges(Iterator<Edge> iterator) {
		deleteViews(iterator);
	}

	/*
	 * prevent unresolved proxy views from being deleted
	 * 
	 * @see org.eclipse.gmf.runtime.diagram.ui.editpolicies.CanonicalEditPolicy#shouldDeleteView(org.eclipse.gmf.runtime.notation.View)
	 */
	protected boolean shouldDeleteView(View view) {
		String type = view.getType();
		if (type != null && type.equals(DeployCoreConstants.UNRESOLVEDPROXY_SEMANTICHINT)) {
			return false;
		}
		return true;
	}

//////////////////////////////////////////////////////////////////////////////////////////////
//////////////////RECORD CHANGES TO INFORM USER OF WHAT CHANGED ///////////////////////////
///////////////////////////////////////////////////////////////////////////////////////////
	protected Command getDeleteViewCommand(View view) {
		recordDelete(view);
		return super.getDeleteViewCommand(view);
	}

	private void recordDelete(View view) {
		if (getDdep() != null && getDdep().getInitialCanonicalChanges() != null) {
			String linkType = Messages.DeployLinkCanonicalConnectorEditPolicy_Lin_;
			EObject eo = view.getElement();
			if (eo instanceof HostingLink) {
				linkType = Messages.HOSTINGLINK_CATEGORY;
			} else if (eo instanceof DependencyLink) {
				linkType = Messages.DEPENDENCYLINK_CATEGORY;
			} else if (eo instanceof RealizationLink) {
				linkType = Messages.REALIZATIONLINK_CATEGORY;
			} else if (eo instanceof ConstraintLink) {
				linkType = Messages.CONSTRAINTLINK_CATEGORY;
			}
			String fromTo = ""; //$NON-NLS-1$
			if (view instanceof Edge && ((Edge) view).getSource() != null
					&& ((Edge) view).getTarget() != null) {
				String fromName = Messages.ImportTopologyCompartmentCanonicalEditPolicy_unknow_;
				String fromType = Messages.ImportTopologyCompartmentCanonicalEditPolicy_unknow_;
				String toName = Messages.ImportTopologyCompartmentCanonicalEditPolicy_unknow_;
				String toType = Messages.ImportTopologyCompartmentCanonicalEditPolicy_unknow_;
				Edge edge = (Edge) view;
				DeployStyle fstyle = (DeployStyle) edge.getSource().getStyle(
						DeployNotationPackage.eINSTANCE.getDeployStyle());
				if (fstyle != null) {
					fromName = fstyle.getElementName();
					fromType = fstyle.getElementCategory();
				}
				DeployStyle tstyle = (DeployStyle) edge.getTarget().getStyle(
						DeployNotationPackage.eINSTANCE.getDeployStyle());
				if (tstyle != null) {
					toName = tstyle.getElementName();
					toType = tstyle.getElementCategory();
				}
				fromTo = NLS.bind(Messages.DeployLinkCanonicalConnectorEditPolicy_0_1_, new Object[] {
						fromName, fromType, toName, toType });
			} else {
				fromTo = Messages.UNKNOWN_LABEL;
			}
			getDdep().getInitialCanonicalChanges().add(
					new DiagramUpdateData(null, view, null, fromTo, linkType, false,
							DiagramUpdateData.DELETED));
		}
	}

	protected void recordCreate(View view) {
		if (getDdep() != null && getDdep().getInitialCanonicalChanges() != null) {
			getDdep().getInitialCanonicalChanges().add(
					new DiagramUpdateData(ViewUtil.resolveSemanticElement(view), view, null, null, null,
							false, DiagramUpdateData.CREATED));
		}
	}
}
