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
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.ListenerList;
import org.eclipse.core.runtime.SafeRunner;
import org.eclipse.core.runtime.Status;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.emf.transaction.util.TransactionUtil;
import org.eclipse.gef.EditPart;
import org.eclipse.gef.commands.Command;
import org.eclipse.gef.requests.CreateRequest;
import org.eclipse.gmf.runtime.common.core.command.CommandResult;
import org.eclipse.gmf.runtime.diagram.core.util.ViewUtil;
import org.eclipse.gmf.runtime.diagram.ui.commands.ICommandProxy;
import org.eclipse.gmf.runtime.diagram.ui.editparts.GraphicalEditPart;
import org.eclipse.gmf.runtime.diagram.ui.editparts.IGraphicalEditPart;
import org.eclipse.gmf.runtime.diagram.ui.editpolicies.CanonicalEditPolicy;
import org.eclipse.gmf.runtime.diagram.ui.requests.CreateViewRequest;
import org.eclipse.gmf.runtime.diagram.ui.requests.CreateViewRequest.ViewDescriptor;
import org.eclipse.gmf.runtime.emf.commands.core.command.AbstractTransactionalCommand;
import org.eclipse.gmf.runtime.notation.CanonicalStyle;
import org.eclipse.gmf.runtime.notation.Diagram;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.ui.progress.UIJob;

import com.ibm.ccl.soa.deploy.core.DeployModelObject;
import com.ibm.ccl.soa.deploy.core.HostingLink;
import com.ibm.ccl.soa.deploy.core.IRelationshipChecker;
import com.ibm.ccl.soa.deploy.core.Import;
import com.ibm.ccl.soa.deploy.core.MemberLink;
import com.ibm.ccl.soa.deploy.core.Unit;
import com.ibm.ccl.soa.deploy.core.ui.Messages;
import com.ibm.ccl.soa.deploy.core.ui.dialogs.DiagramUpdateData;
import com.ibm.ccl.soa.deploy.core.ui.editparts.DeployDiagramEditPart;
import com.ibm.ccl.soa.deploy.core.ui.editparts.DeployShapeNodeEditPart;
import com.ibm.ccl.soa.deploy.core.ui.editparts.DiagramNodeEditPart;
import com.ibm.ccl.soa.deploy.core.ui.editparts.ImportTopologyEditPart;
import com.ibm.ccl.soa.deploy.core.ui.internal.commands.SnapViewCommand;
import com.ibm.ccl.soa.deploy.core.ui.notation.DeployNotationPackage;
import com.ibm.ccl.soa.deploy.core.ui.notation.DeployStyle;
import com.ibm.ccl.soa.deploy.core.ui.properties.PropertyUtils;
import com.ibm.ccl.soa.deploy.core.ui.util.ContainmentStateUtils;
import com.ibm.ccl.soa.deploy.core.ui.util.DeployCoreConstants;
import com.ibm.ccl.soa.deploy.core.ui.util.GMFUtils;
import com.ibm.ccl.soa.deploy.internal.core.DeployCoreSafeRunnable;

/**
 * @author jswanke
 * 
 */
abstract public class DeployCanonicalEditPolicy extends CanonicalEditPolicy {

	private boolean isForceEnabledOn = false;
	private boolean isForceEnabledOff = false;
	private DeployDiagramEditPart _ddep = null;

	private long lastRefresh = -1;

	// scheduling delay 
	private static final int DELAY = 0;
	private static final long THRESHOLD = 200 * 1000;

	private static class UIQueueJob extends UIJob {

		/** Create a job for enqueueing task of displaying the correct status icon */
		public UIQueueJob() {
			super("Update figures with available resolutions.."); //$NON-NLS-1$
		}

		private final ListenerList queue = new ListenerList() {
			public synchronized Object[] getListeners() {
				Object[] data = null;
				data = super.getListeners();
				clear();
				return data;
			}
		};

		/**
		 * Enqueue a decorator to perform the work of displaying the results of the icon calculation
		 * 
		 * @param policy
		 *           The decorator for the relevant amount of work.
		 */
		public void enqueue(DeployCanonicalEditPolicy policy) {
			queue.add(policy);
		}

		@Override
		public IStatus runInUIThread(IProgressMonitor monitor) {

			Object[] policies = queue.getListeners();
			for (int i = 0; i < policies.length; i++) {
				final DeployCanonicalEditPolicy policy = (DeployCanonicalEditPolicy) policies[i];
				if (policy.isEnabled() && policy.isActive()) {
					SafeRunner.run(new DeployCoreSafeRunnable() {
						@Override
						public void run() throws Exception {
							policy.internalRefresh();
						}
					});
				}
			}

			return Status.OK_STATUS;
		}

	};

	private static final UIQueueJob refreshJob = new UIQueueJob();

	public DeployCanonicalEditPolicy() {
	}

	protected DeployDiagramEditPart getDdep() {
		if (_ddep == null) {
			_ddep = GMFUtils.getDeployDiagramEditPart(getHost());
		}
		return _ddep;
	}

	private void internalRefresh() {
		if (getDdep() != null && getDdep().getRoot() != null) {
			super.refreshSemantic();
		}
	}

	@Override
	protected void refreshSemantic() {
		// if a call to refresh is within a certain threshold, then execute the 
		// refresh in-thread; otherwise schedule it out to a Job. 
		// by executing schedule, we can batch up occurrences of many
		// calls to refresh on the same edit policy when there isn't 
		// really any significant change to the diagram or model
		long enter = System.nanoTime();
		if (enter - lastRefresh > THRESHOLD || lastRefresh < 0) {
			internalRefresh();
		} else {
			refreshJob.enqueue(this);
			refreshJob.schedule(DELAY);
		}
		lastRefresh = System.nanoTime();
	}

	/**
	 * @return number of semantic elements in list used to determine whether to refresh the views in
	 *         a collpased compartment
	 */
	public List getProtectedSemanticChildrenList() {
		return new ArrayList(getSemanticChildrenList());
	}

	/**
	 * @return number of semantic elements in list used to determine whether to refresh the views in
	 *         a collpased compartment
	 */
	public List getProtectedViewChildrenList() {
		return getViewChildren();
	}

	@Override
	protected List getSemanticChildrenList() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean isEnabled() {
		if (isForceEnabledOff) {
			return false;
		} else if (isForceEnabledOn) {
			if (TransactionUtil.getEditingDomain((EObject) getHost().getModel()) == null) {
				return false;
			}
			CanonicalStyle style = getCanonicalStyle();
			return style == null ? true : style.isCanonical();
		}
		return super.isEnabled();
	}

	/**
	 * @param isForceEnabledOn
	 */
	public void setForceEnabledOn(boolean isForceEnabledOn) {
		this.isForceEnabledOn = isForceEnabledOn;
	}

	/**
	 * @param isForceEnabledOff
	 */
	public void setisForceEnabledOff(boolean isForceEnabledOff) {
		this.isForceEnabledOff = isForceEnabledOff;
	}

	protected List getSemanticChildrenListHelper(Unit unit, Set<Unit> childUnitSet) {
		List list = new ArrayList();
		// add member link target units
		addMemberLinkTargets(unit, list);

		// add hosting link targets
		addHostingLinkTargets(unit, list, childUnitSet);

		return list;
	}

	private void addMemberLinkTargets(Unit unit, List list) {
		List<Unit>[] visibleImportList = new List[1];
		getVisibleImportList(visibleImportList);
		if (unit.getEditTopology() != null) {
			IRelationshipChecker relationships = unit.getEditTopology().getRelationships();
			for (Iterator it = relationships.getMembersLinks(unit).iterator(); it.hasNext();) {
				MemberLink link = (MemberLink) it.next();
				EObject member = link.getTarget();
				// if this unit is in an import, only include members that are visible
				if (PropertyUtils.isProxy((DeployModelObject) member) && visibleImportList[0] != null
						&& !visibleImportList[0].contains(member)) {
					continue;
				}
				list.add(member);
			}
		}
		// remove filter elements (Delete from Diagram in a container)
		removeFilteredElements(list);
	}

	private void addHostingLinkTargets(Unit unit, List list, Set<Unit> childUnitSet) {
		List<Unit>[] visibleImportList = new List[1];
		getVisibleImportList(visibleImportList);
		boolean isInImportTree = GMFUtils.isImportTreeTopology(getHost());
		DiagramNodeEditPart dnep = GMFUtils.getDiagramNodeEP(getHost());
		if (!GMFUtils.isDiagramTreeNode(getHost())) {
			dnep = null;
		}
		for (Iterator it = GMFUtils.getAllHostedLinks(unit).iterator(); it.hasNext();) {
			HostingLink link = (HostingLink) it.next();
			Unit host = link.getHost();
			Unit hosted = link.getHosted();
			if (hosted == null) {
				continue;
			}

			boolean isContainedUnit = ContainmentStateUtils.isContainedUnit(getHost(), hosted);
			if (!PropertyUtils.isProxy(hosted)) {

				// add it because it's contained
				// or if this is a diagram node and the hosted appears in the canvas of the diagram
				if (isContainedUnit || dnep != null && dnep.getDiagramUnits().contains(hosted)) {
					list.add(hosted);
					// for consistency with an import tree, we also add non-contained units if its hosting link is
					// within the tree
				} else if (childUnitSet != null) {
					if (childUnitSet.contains(hosted) && !list.contains(hosted)) {
						list.add(hosted);
					}
				}
			} else if (visibleImportList[0] == null || visibleImportList[0].contains(hosted)) {
				// if in a import tree, remove if host is in same tree (all hosts are contained by default in import tree)
				if (isInImportTree) {
					// only filter is in same import topology-- links to outside of tree are not filtered
					if (PropertyUtils.isProxy(host.getTopology())) {
						list.add(hosted);
					}
					// if outside of a tree, filter out if user mark it to be contained
				} else if (isContainedUnit) {
					list.add(hosted);
				}
			}
		}
		// remove filter elements (Delete from Diagram in a container)
		removeFilteredElements(list);
	}

	// this filter is used by Delete from Diagram when used in a container to prevent
	//  canonical edit policy from just recreating the view
	private void removeFilteredElements(List list) {
		View parentView = ViewUtil
				.getContainerView(((GraphicalEditPart) getHost()).getNotationView());
		if (parentView != null) {
			DeployStyle style = (DeployStyle) parentView.getStyle(DeployNotationPackage.eINSTANCE
					.getDeployStyle());
			if (style != null && style.getFilteredSemanticElements().size() > 0) {
				list.removeAll(style.getFilteredSemanticElements());
			}
		}
	}

	/**
	 * Returns true if the semantic element appears more than twice in its visual containment. <p.
	 * Used to detect cycles caused by hosting and membership containment.
	 * 
	 * @param unit
	 *           a deployment unit.
	 * @param host
	 *           the edit part for the unit.
	 * @return true if the unit is the semantic element of a parent edit part.
	 */
	public static boolean hasEditPartCycle(Unit unit, EditPart host) {
		if (unit == null || host == null) {
			return false;
		}
		boolean leftMember = false;
		while (host != null) {
			if (host.getModel() instanceof View) {
				Object semantic = ViewUtil.resolveSemanticElement((View) host.getModel());
				if (semantic == unit) {
					if (leftMember) {
						return true;
					}
				} else {
					leftMember = true;
				}
			}
			host = host.getParent();
		}
		return false;
	}

	/**
	 * if an import, get all of its visible units from the cache
	 * 
	 * @param visibleImportList
	 * @return visible units
	 */
	protected void getVisibleImportList(List<Unit>[] visibleImportList) {
		// we only care if this is a proxy
		DeployModelObject dmo = (DeployModelObject) this.getSemanticHost();
		if (PropertyUtils.isProxy(dmo)) {
			// it's a proxy, so look for the view that's in an import
			List<DeployShapeNodeEditPart> list = GMFUtils
					.getEditPartsFor(getHost(), getSemanticHost());
			for (Iterator<DeployShapeNodeEditPart> it = list.iterator(); it.hasNext();) {
				// if this is the editpart in an import tree, get import
				ImportTopologyEditPart ep = GMFUtils.getImportTopologyEP(it.next());
				if (ep != null) {
					Import imprt = (Import) ep.resolveSemanticElement();
					// return the visible units 
					if (imprt != null) {
						visibleImportList[0] = GMFUtils.getDeployDiagramEditPart(getHost())
								.getSemanticCacheData().getImportCacheMap().get(
										imprt.getInstanceConfiguration());
					}
				}
			}
		}
	}

	protected Command getCreateViewCommandRestricted(CreateRequest request) {
		// we only create contained views canonically if the CanonicalUtils.createViews()
		// method has been called to create this editpolicy's host unit
		if (getDdep().isIgnoreRestrictions() || GMFUtils.isImportTopology(getHost())
				|| GMFUtils.isDiagramNode(getHost())) {
			return super.getCreateViewCommand(request);
		}
		List<DeployModelObject> list = getDdep().getCreationList();
		if (list != null) {
			if (parentContains(list)) {
				return super.getCreateViewCommand(request);
			} else if (request instanceof CreateViewRequest) {
				CreateViewRequest cvr = (CreateViewRequest) request;
				List remove = new ArrayList();
				List descriptors = cvr.getViewDescriptors();
				for (Iterator it = descriptors.iterator(); it.hasNext();) {
					ViewDescriptor descriptor = (ViewDescriptor) it.next();
					if (!list.contains(descriptor.getElementAdapter().getAdapter(EObject.class))) {
						remove.add(descriptor);
					}
				}
				descriptors.removeAll(remove);
				if (descriptors.size() > 0) {
					return super.getCreateViewCommand(request);
				}
			}
		}
		return null;
	}

	private boolean parentContains(List<DeployModelObject> list) {
		EditPart walker = this.getHost();
		while (walker != null) {
			if (walker instanceof DeployShapeNodeEditPart) {
				DeployShapeNodeEditPart ep = (DeployShapeNodeEditPart) walker;
				if (list.contains(ep.resolveSemanticElement())) {
					return true;
				}
			}
			walker = walker.getParent();
		}
		return false;
	}

	/*
	 * 
	 * @see org.eclipse.gmf.runtime.diagram.ui.editpolicies.CanonicalEditPolicy#shouldDeleteView(org.eclipse.gmf.runtime.notation.View)
	 */
	protected boolean shouldDeleteView(View view) {
		String type = view.getType();
		if (type != null) {
			// don't delete unresolved proxy views
			if (type.equals(DeployCoreConstants.UNRESOLVEDPROXY_SEMANTICHINT)) {
				return false;
			}
			// don't delete snap groups
			if (type.equals(DeployCoreConstants.SNAPGROUP_SEMANTICHINT)) {
				if (SnapViewCommand.getMemberSize(view) > 1) {
					return false;
				}
			}
		}
		return true;
	}

//////////////////////////////////////////////////////////////////////////////////////////////
////////////////// RECORD CHANGES TO INFORM USER OF WHAT CHANGED ///////////////////////////
///////////////////////////////////////////////////////////////////////////////////////////
	/**
	 * record newly created views if diagram is first openning
	 */
	protected void postProcessRefreshSemantic(List viewDescriptors) {
		super.postProcessRefreshSemantic(viewDescriptors);

		for (int i = 0; i < viewDescriptors.size(); i++) {
			recordCreate((View) ((IAdaptable) viewDescriptors.get(i)).getAdapter(View.class));
		}
	}

	protected Command getDeleteViewCommand(View view) {
		// for formally contained views (whose containing link has been deleted) we move the view to the canvas
		if (!(view.eContainer() instanceof Diagram) && isValidElement(view)) {
			recordUncontained(view);
			return getUncontainViewCommand(view);
		}
		// else we delete everything else
		recordDelete(view);
		return super.getDeleteViewCommand(view);
	}

	private boolean isValidElement(View view) {
		// if in a diagramnode or import or import diagram, delete it
		EObject walker = view;
		Diagram diagram = null;
		while (walker != null) {
			if (walker instanceof Diagram) {
				diagram = (Diagram) walker;
				break;
			} else if (walker instanceof View) {
				View v = (View) walker;
				if (v.getType() != null) {
					String type = v.getType();
					if (type.equals(DeployCoreConstants.IMPORTTOPOLOGYLIST_SEMANTICHINT)
							|| type.equals(DeployCoreConstants.IMPORTTOPOLOGYSHAPES_SEMANTICHINT)
							|| type.equals(DeployCoreConstants.DIAGRAMNODELIST_SEMANTICHINT)
							|| type.equals(DeployCoreConstants.DIAGRAMNODESHAPES_SEMANTICHINT)) {
						return false;
					}
				}
			}
			walker = walker.eContainer();
		}

		// if element is missing from model, delete it
		EObject eo = ViewUtil.resolveSemanticElement(view);
		if (!(eo instanceof DeployModelObject)) {
			return false;
		}
		DeployModelObject dmo = (DeployModelObject) eo;
		if (dmo.getEditTopology() == null) {
			return false;
		}

		// don't stick in canvas if it already exists there
		for (Iterator<?> it = diagram.getPersistedChildren().iterator(); it.hasNext();) {
			Object o = it.next();
			if (o instanceof View) {
				if (eo.equals(ViewUtil.resolveSemanticElement((View) o))) {
					return false;
				}
			}
		}

		if (!PropertyUtils.isProxy(dmo) && dmo.getTopology().getUnits().contains(dmo)) {
			return true;
		}
		Import imprt = dmo.getTopology().getImport(dmo.getQualifiedName());
		return imprt != null;
	}

	/**
	 * This command will move a contained view to the canvas
	 */
	private Command getUncontainViewCommand(final View view) {
		final TransactionalEditingDomain editingDomain = ((IGraphicalEditPart) getHost())
				.getEditingDomain();
		return new ICommandProxy(new AbstractTransactionalCommand(editingDomain, "", null) {//$NON-NLS-1$
					protected CommandResult doExecuteWithResult(IProgressMonitor progressMonitor,
							IAdaptable info) {
						com.ibm.ccl.soa.deploy.core.ui.util.ViewUtil.insertViewNextToParent(view);
						return CommandResult.newOKCommandResult();
					}

					@Override
					protected IStatus doRedo(IProgressMonitor monitor, IAdaptable info)
							throws ExecutionException {
						return super.doRedo(monitor, info);
					}

					@Override
					protected IStatus doUndo(IProgressMonitor monitor, IAdaptable info)
							throws ExecutionException {
						return super.doUndo(monitor, info);
					}

				});
	}

	private void recordDelete(View view) {
		if (getDdep() != null && getDdep().getInitialCanonicalChanges() != null) {
			String name = DiagramUpdateData.getQualifiedName(view, true);
			String s = Messages.DeployDeleteAction_Uni_;
			if (view.getType() != null
					&& view.getType().equals(DeployCoreConstants.SNAPGROUP_SEMANTICHINT)) {
				s = Messages.DeployCanonicalEditPolicy_SnapGrou_;
			}
			getDdep().getInitialCanonicalChanges().add(
					new DiagramUpdateData(null, view, ViewUtil.resolveSemanticElement((View) view
							.eContainer()), name, s, true, DiagramUpdateData.DELETED));
		}
	}

	private void recordUncontained(View view) {
		if (getDdep() != null && getDdep().getInitialCanonicalChanges() != null) {
			String name = DiagramUpdateData.getQualifiedName(view, true);
			getDdep().getInitialCanonicalChanges().add(
					new DiagramUpdateData(null, view, ViewUtil.resolveSemanticElement((View) view
							.eContainer()), name, Messages.DeployDeleteAction_Uni_, true,
							DiagramUpdateData.UNCONTAINED));
		}
	}

	protected void recordCreate(View view) {
		if (getDdep() != null && getDdep().getInitialCanonicalChanges() != null) {
			getDdep().getInitialCanonicalChanges().add(
					new DiagramUpdateData(ViewUtil.resolveSemanticElement(view), view, ViewUtil
							.resolveSemanticElement((View) view.eContainer()), null,
							Messages.DeployDeleteAction_Uni_, true, DiagramUpdateData.CREATED));
		}
	}

}
