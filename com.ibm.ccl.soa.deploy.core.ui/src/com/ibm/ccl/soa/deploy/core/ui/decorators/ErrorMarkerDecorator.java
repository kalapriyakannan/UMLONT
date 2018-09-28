/***************************************************************************************************
 * Copyright (c) 2003, 2007 IBM Corporation Licensed Material - Property of IBM. All rights
 * reserved.
 * 
 * US Government Users Restricted Rights - Use, duplication or disclosure v1.0 restricted by GSA ADP
 * Schedule Contract with IBM Corp.
 * 
 * Contributors: IBM Corporation - initial API and implementation
 **************************************************************************************************/
package com.ibm.ccl.soa.deploy.core.ui.decorators;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.WeakHashMap;

import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.ListenerList;
import org.eclipse.core.runtime.MultiStatus;
import org.eclipse.core.runtime.SafeRunner;
import org.eclipse.core.runtime.Status;
import org.eclipse.core.runtime.jobs.Job;
import org.eclipse.draw2d.Connection;
import org.eclipse.draw2d.ConnectionLocator;
import org.eclipse.draw2d.IFigure;
import org.eclipse.draw2d.Locator;
import org.eclipse.draw2d.MouseEvent;
import org.eclipse.draw2d.MouseListener;
import org.eclipse.draw2d.geometry.Dimension;
import org.eclipse.draw2d.geometry.PointList;
import org.eclipse.draw2d.geometry.Rectangle;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.util.EContentAdapter;
import org.eclipse.gef.EditPart;
import org.eclipse.gef.GraphicalEditPart;
import org.eclipse.gef.commands.Command;
import org.eclipse.gmf.runtime.diagram.core.util.ViewUtil;
import org.eclipse.gmf.runtime.diagram.ui.editparts.ConnectionNodeEditPart;
import org.eclipse.gmf.runtime.diagram.ui.editparts.IGraphicalEditPart;
import org.eclipse.gmf.runtime.diagram.ui.editpolicies.DecorationEditPolicy;
import org.eclipse.gmf.runtime.diagram.ui.editpolicies.EditPolicyRoles;
import org.eclipse.gmf.runtime.diagram.ui.services.decorator.IDecoration;
import org.eclipse.gmf.runtime.diagram.ui.services.decorator.IDecoratorTarget;
import org.eclipse.gmf.runtime.draw2d.ui.geometry.PointListUtilities;
import org.eclipse.gmf.runtime.notation.Diagram;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.jface.util.IPropertyChangeListener;
import org.eclipse.jface.util.PropertyChangeEvent;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.graphics.Point;
import org.eclipse.ui.progress.UIJob;

import sun.management.counter.Units;

import com.ibm.ccl.soa.deploy.core.Capability;
import com.ibm.ccl.soa.deploy.core.Constraint;
import com.ibm.ccl.soa.deploy.core.ConstraintLink;
import com.ibm.ccl.soa.deploy.core.CorePackage;
import com.ibm.ccl.soa.deploy.core.DependencyLink;
import com.ibm.ccl.soa.deploy.core.DeployCorePlugin;
import com.ibm.ccl.soa.deploy.core.DeployLink;
import com.ibm.ccl.soa.deploy.core.DeployModelObject;
import com.ibm.ccl.soa.deploy.core.HostingLink;
import com.ibm.ccl.soa.deploy.core.Import;
import com.ibm.ccl.soa.deploy.core.InstanceConfiguration;
import com.ibm.ccl.soa.deploy.core.RealizationLink;
import com.ibm.ccl.soa.deploy.core.Requirement;
import com.ibm.ccl.soa.deploy.core.Unit;
import com.ibm.ccl.soa.deploy.core.ui.DeployCoreUIPlugin;
import com.ibm.ccl.soa.deploy.core.ui.Messages;
import com.ibm.ccl.soa.deploy.core.ui.actions.FilterPreferenceAction;
import com.ibm.ccl.soa.deploy.core.ui.editor.DeployGraphicalViewer;
import com.ibm.ccl.soa.deploy.core.ui.editparts.ConsolidationLinkEditPart;
import com.ibm.ccl.soa.deploy.core.ui.editparts.DeployConnectionNodeEditPart;
import com.ibm.ccl.soa.deploy.core.ui.editparts.DeployDiagramEditPart;
import com.ibm.ccl.soa.deploy.core.ui.editparts.DeployShapeNodeEditPart;
import com.ibm.ccl.soa.deploy.core.ui.editparts.DiagramNodeEditPart;
import com.ibm.ccl.soa.deploy.core.ui.editparts.ImportTopologyEditPart;
import com.ibm.ccl.soa.deploy.core.ui.figures.DeployLinkConnection;
import com.ibm.ccl.soa.deploy.core.ui.figures.DeployListItemFigure;
import com.ibm.ccl.soa.deploy.core.ui.figures.ErrorMarkerFigure;
import com.ibm.ccl.soa.deploy.core.ui.figures.ErrorMarkerFigureFactory;
import com.ibm.ccl.soa.deploy.core.ui.figures.core.CompositeShapeFigure;
import com.ibm.ccl.soa.deploy.core.ui.preferences.IDeployPreferences;
import com.ibm.ccl.soa.deploy.core.ui.providers.DeployDecoratorProvider;
import com.ibm.ccl.soa.deploy.core.ui.requests.CreateQuickFixPopupRequest;
import com.ibm.ccl.soa.deploy.core.ui.util.ConsolidationLinkUtils;
import com.ibm.ccl.soa.deploy.core.ui.util.DeployCoreConstants;
import com.ibm.ccl.soa.deploy.core.ui.util.GEFUtils;
import com.ibm.ccl.soa.deploy.core.ui.util.GMFUtils;
import com.ibm.ccl.soa.deploy.core.ui.util.CanonicalUtils.UnitLinkData;
import com.ibm.ccl.soa.deploy.internal.core.DeployCoreMessages;
import com.ibm.ccl.soa.deploy.internal.core.DeployCoreSafeRunnable;

/**
 * @see DeployDecoratorProvider
 * @see ErrorMarkerFigure
 */
public class ErrorMarkerDecorator extends DeployDecorator implements IPropertyChangeListener {
	public static final int INFINITE_RES_DEPTH = -999;
	private ErrorMarkerFigure _figure = null;
	protected EContentAdapter _contentAdapter = null;
	private MouseListener _mouseListener;
	private final Object lock = new Object();
	private final List<IDecoration> decorationList = new ArrayList<IDecoration>();
	private boolean isConsolidationLink = false;
	private boolean isInnerHostingList = false;
	private boolean isActivated = false;
	private GraphicalEditPart ownerEP = null;
	private boolean isImportErrorMarker = false;
	private boolean isDiagramNodeErrorMarker = false;
	private final boolean refreshingStatus = false;
	private boolean filterErrors = false;
	private boolean filterWarnings = false;
	private boolean filterInfo = false;

	// 100 ms
	private static final int DELAY = 100;

	// use synchronized implementation of Map
	private final static Map<EObject, Boolean> statusResolutionsMap = Collections
			.synchronizedMap(new WeakHashMap<EObject, Boolean>());

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
		 * @param decorator
		 *           The decorator for the relevant amount of work.
		 */
		public void enqueue(ErrorMarkerDecorator decorator) {
			queue.add(decorator);
		}

		@Override
		public IStatus runInUIThread(IProgressMonitor monitor) {

			Object[] decorators = queue.getListeners();
			for (int i = 0; i < decorators.length; i++) {
				final ErrorMarkerDecorator decorator = (ErrorMarkerDecorator) decorators[i];
				if (decorator.isActivated) {
					SafeRunner.run(new DeployCoreSafeRunnable() {
						@Override
						public void run() throws Exception {
							decorator.refreshHelper();
						}
					});
				}
			}

			return Status.OK_STATUS;
		}

	};

	private static final UIQueueJob showResolutionsJob = new UIQueueJob();

	private static class QueueJob extends Job {

		/** Create a job for enqueueing work off of the UI thread to calculate the correct icon */
		public QueueJob() {
			super("Calculate possible validation resolutions.."); //$NON-NLS-1$
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
		 * Enqueue a decorator to perform the work of calculating whether resolutions are available.
		 * 
		 * @param decorator
		 *           The decorator for the relevant amount of work.
		 */
		public void enqueue(ErrorMarkerDecorator decorator) {
			if (decorator != null) {
				queue.add(decorator);
			}
		}

		@Override
		protected IStatus run(IProgressMonitor monitor) {
			final Object[] data = queue.getListeners();
			for (int i = 0; i < data.length; i++) {
				final ErrorMarkerDecorator decorator = (ErrorMarkerDecorator) data[i];
				if (decorator.isActivated) {

					SafeRunner.run(new DeployCoreSafeRunnable() {
						@Override
						public void run() throws Exception {

							EObject model = decorator.resolveElement();
							// ensure the element is valid and hasn't been removed or deleted since the work was queued.
							if (decorator.isConsolidationLink || model != null
									&& model.eContainer() != null) {
								IStatus status = decorator.collectStatuses(model, true);
								if (status != null && status.getSeverity() != IStatus.OK) {
									boolean hasResolution = ErrorMarkerFigureFactory.hasResolution(status);
									statusResolutionsMap.put(decorator.getResolutionMapKey(),
											hasResolution ? Boolean.TRUE : Boolean.FALSE);
								} else {
									statusResolutionsMap.put(decorator.getResolutionMapKey(), Boolean.FALSE);
								}

								showResolutionsJob.enqueue(decorator);
								showResolutionsJob.schedule(DELAY);
							}
						}
					});

				}
			}

			return Status.OK_STATUS;
		}

	};

	private static final QueueJob calculateResolutionsJob = new QueueJob();

	/**
	 * Create an error decorator.
	 * 
	 * @param decoratorTarget
	 */
	public ErrorMarkerDecorator(IDecoratorTarget decoratorTarget) {
		super(decoratorTarget);

		// determine if this is an inner hosting list
		ownerEP = (GraphicalEditPart) decoratorTarget.getAdapter(GraphicalEditPart.class);
		IFigure figure = ownerEP.getFigure();
		isInnerHostingList = figure instanceof CompositeShapeFigure
				&& ((CompositeShapeFigure) figure).getInnerFigure() instanceof DeployListItemFigure;
		isImportErrorMarker = ownerEP instanceof ImportTopologyEditPart;
		isDiagramNodeErrorMarker = ownerEP instanceof DiagramNodeEditPart;
		isConsolidationLink = ownerEP instanceof ConsolidationLinkEditPart;
	}

	/**
	 * 
	 */
	public ErrorMarkerDecorator() {
		super(null);
	}

	/**
	 * ============== ACTIVATE ================================================================
	 */
	public void activate() {
		// consolidation link doesn't have an object
		if (!isConsolidationLink && !isDiagramNodeErrorMarker) {
			DeployModelObject deployObject = getDeployObject(true);
			if (deployObject == null) {
				return;
			}
			addListener(deployObject);
		}
		isActivated = true;
		refresh();
		DeployCoreUIPlugin.getDefault().getPreferenceStore().addPropertyChangeListener(this);
	}

	/*
	 * listen to changes to the element that this errormarker represents and if theres a
	 * modification, call refresh()
	 */
	private void addListener(final DeployModelObject deployObject) {
		_contentAdapter = new EContentAdapter() {
			public void notifyChanged(final Notification notification) {
				super.notifyChanged(notification);
				if (notification.getEventType() == Notification.REMOVING_ADAPTER) {
					return;
				}
				Object feature = notification.getFeature();
				int type = notification.getEventType();
				if (isImportErrorMarker || feature == CorePackage.Literals.DEPLOY_MODEL_OBJECT__STATUS
						|| feature == CorePackage.Literals.UNIT__UNIT_LINKS_GROUP
						&& (type == Notification.ADD || type == Notification.REMOVE)) {
					refresh();
				}
			}
		};

		// if Import, we monitor its instance configuration
		EObject eo = deployObject;
		if (eo instanceof Import) {
			eo = ((Import) deployObject).getInstanceConfiguration();
		}
		eo.eAdapters().add(_contentAdapter);
	}

	/**
	 * ============= DEACTIVATE=================================================================
	 */
	public void deactivate() {
		calculateResolutionsJob.cancel();
		isActivated = false;
		// consolidation link doesn't have an object
		if (!isConsolidationLink && !isDiagramNodeErrorMarker) {
			DeployModelObject deployObject = getDeployObject(false);
			if (deployObject != null) {
				removeListener(deployObject);
				statusResolutionsMap.remove(getResolutionMapKey());
			}
		}

		DeployCoreUIPlugin.getDefault().getPreferenceStore().removePropertyChangeListener(this);
		super.deactivate();
	}

	private void removeListener(DeployModelObject deployObject) {
		if (_contentAdapter != null) {
			deployObject.eAdapters().remove(_contentAdapter);
		}
		_contentAdapter = null;
	}

	/**
	 * ============= PROPERTY
	 * LISTENER=================================================================
	 */

	public void propertyChange(PropertyChangeEvent event) {
		if (event.getProperty().equals(IDeployPreferences.DEPLOY_HIDE_ERROR_MARKERS)
				|| event.getProperty().equals(IDeployPreferences.DEPLOY_HIDE_WARNING_MARKERS)
				|| event.getProperty().equals(IDeployPreferences.DEPLOY_HIDE_INFO_MARKERS)) {
			refresh();
		}
	}

	/**
	 * ================ REFRESH STATUS IN DECORATION=============================================
	 */
	public void refresh() {
		if (isActivated) {
			calculateResolutionsJob.enqueue(this);
			calculateResolutionsJob.schedule(DELAY);
		}
	}

	private void refreshHelper() {
		if (!isActivated) {
			return;
		}
		EObject element = resolveElement();

		refreshStatus(element);

		// if error marker is on a unit in a UI compartment, refresh the "contained" status of the top figure
		if (ownerEP instanceof DeployShapeNodeEditPart) {
			EditPart topEP = GEFUtils.getTopEditPart(ownerEP);
			if (!topEP.equals(ownerEP) && topEP instanceof DeployShapeNodeEditPart) {
				DecorationEditPolicy policy = (DecorationEditPolicy) topEP
						.getEditPolicy(EditPolicyRoles.DECORATION_ROLE);
				if (policy != null) {
					policy.refresh();
				}
			}
			// if error marker is on a link that's been consolidated, refresh the consolidated link
		} else if (ownerEP instanceof DeployConnectionNodeEditPart) {
			DeployConnectionNodeEditPart linkEP = (DeployConnectionNodeEditPart) ownerEP;
			DeployLinkConnection linkFig = (DeployLinkConnection) linkEP.getFigure();
			if (linkFig.isConsolidated()) {
				ConsolidationLinkEditPart consolidationLinkEP = ConsolidationLinkUtils
						.getConsolidationLink(linkEP);
				if (consolidationLinkEP != null) {
					DecorationEditPolicy policy = (DecorationEditPolicy) consolidationLinkEP
							.getEditPolicy(EditPolicyRoles.DECORATION_ROLE);
					if (policy != null) {
						policy.refresh();
					}
				}
			}
		}
	}

	private EObject resolveElement() {
		View view = (View) getDecoratorTarget().getAdapter(View.class);
		if (view == null) {
			return null;
		}
		// consolidation link/diagram node don't have an object
		EObject element = view.getElement();
		if (!(element instanceof DeployModelObject) && !isConsolidationLink
				&& !isDiagramNodeErrorMarker) {
			return null;
		}
		return element;
	}

	// get a key to save resolution status against
	private EObject getResolutionMapKey() {
		// consolation link only has its view for a key
		if (isConsolidationLink) {
			return (EObject) getDecoratorTarget().getAdapter(View.class);
		}
		return getEObject(false);
	}

	private void refreshStatus(EObject eObject) {
		// remove any MarkerFigure in case this method isn't adding any 
		//removeDecoration();

		// calc filter flags
		IGraphicalEditPart editpart = (IGraphicalEditPart) getDecoratorTarget().getAdapter(
				GraphicalEditPart.class);
		filterErrors = FilterPreferenceAction.isFiltered(
				IDeployPreferences.DEPLOY_HIDE_ERROR_MARKERS, editpart);
		filterWarnings = FilterPreferenceAction.isFiltered(
				IDeployPreferences.DEPLOY_HIDE_WARNING_MARKERS, editpart);
		filterInfo = FilterPreferenceAction.isFiltered(IDeployPreferences.DEPLOY_HIDE_INFO_MARKERS,
				editpart);

		// collect all of the statuses for this unit/import/link
		IStatus status = collectStatuses(eObject, true);
		if (status == null || status.getSeverity() == IStatus.OK) {
			if (_figure != null) {
				_figure.setVisible(false);
			}
			return;
		}
		// add the error decorator to a figure or a link
		if (ownerEP instanceof DeployShapeNodeEditPart) {
			setShapeDecoration(status);
		} else if (ownerEP instanceof DeployConnectionNodeEditPart) {
			setEdgeDecoration(status);
		}
	}

	/**
	 * Recursively collects statuses from element that this errormarker represents into one status.
	 * 
	 * @param eObject
	 *           the object whose statuses will be collected.
	 * @param collectUICompartmentStatuses
	 *           true if status on <em>visually</em> contained objects should be shown.
	 * @return a status (may be original status or new multi status collection copy).
	 */
	public IStatus collectStatuses(EObject eObject, boolean collectUICompartmentStatuses) {
		// start a status list
		List<IStatus> statusList = new ArrayList<IStatus>();

		// consolidation link/diagram node don't have an object
		if (isConsolidationLink) {
			collectConsolidatedStatus(statusList);
		} else if (eObject instanceof Diagram) {
			addCompartmentStatus(eObject, statusList);
		} else {
			// collect contained statuses (links, capabilities, requirements)
			collectContainedStatuses((DeployModelObject) eObject, statusList);

			// collect hidden link statuses
			if (eObject instanceof Unit) {
				collectHiddenLinkStatues((Unit) eObject, statusList);
			}

			// add UI compartment status (ie. add "contained" error if any unit in tree/group has an error)
			if (collectUICompartmentStatuses) {
				addCompartmentStatus(eObject, statusList);
			}
		}

		// filter out statuses based on user preference
		List<IStatus> filteredStatusList = new ArrayList<IStatus>();
		for (IStatus status : statusList) {
			int severity = status.getSeverity();
			switch (severity)
			{
			case IStatus.ERROR:
				if (filterErrors) {
					continue;
				}
				break;
			case IStatus.WARNING:
				if (filterWarnings) {
					continue;
				}
				break;
			case IStatus.INFO:
				if (filterInfo) {
					continue;
				}
				break;
			}
			filteredStatusList.add(status);
		}

		if (filteredStatusList.size() == 0) {
			return Status.OK_STATUS;
		}

		if (filteredStatusList.size() == 1) {
			return filteredStatusList.get(0);
		}
		IStatus[] children = filteredStatusList.toArray(new IStatus[filteredStatusList.size()]);
		MultiStatus status = new MultiStatus(DeployCorePlugin.PLUGIN_ID, 0, children,
				DeployCoreMessages.Model_consistency_status_message, null);
		return status;
	}

	/**
	 * Recursively collects statuses from element that this errormarker represents into one status.
	 * 
	 * @param eObject
	 *           the object whose statuses will be collected.
	 * @param filterForPreferences
	 *           A boolean indicating if preference filtering should take place.
	 * @return a status (may be original status or new multi status collection copy).
	 */
	public IStatus collectImmediateStatuses(EObject eObject, boolean filterForPreferences) {
		// start a status list
		List<IStatus> statusList = new ArrayList<IStatus>();

		// consolidation link/diagram node don't have an object
		if (isConsolidationLink) {
			collectConsolidatedStatus(statusList);
		} else if (eObject != null) {
			// collect contained statuses (links, capabilities, requirements)
			collectContainedStatuses((DeployModelObject) eObject, statusList);

			// collect hidden link statuses
			if (eObject instanceof Unit) {
				collectHiddenLinkStatues((Unit) eObject, statusList);
			}
		}

		List<IStatus> filteredStatusList = statusList;

		// filter out statuses based on user preference
		if (filterForPreferences) {
			filteredStatusList = new ArrayList<IStatus>();
			for (IStatus status : statusList) {
				int severity = status.getSeverity();
				switch (severity)
				{
				case IStatus.ERROR:
					if (filterErrors) {
						continue;
					}
					break;
				case IStatus.WARNING:
					if (filterWarnings) {
						continue;
					}
					break;
				case IStatus.INFO:
					if (filterInfo) {
						continue;
					}
					break;
				}
				filteredStatusList.add(status);
			}
		}
		if (filteredStatusList.size() == 0) {
			return Status.OK_STATUS;
		}

		if (filteredStatusList.size() == 1) {
			return filteredStatusList.get(0);
		}

		IStatus[] children = filteredStatusList.toArray(new IStatus[filteredStatusList.size()]);
		MultiStatus status = new MultiStatus(DeployCorePlugin.PLUGIN_ID, 0, children,
				DeployCoreMessages.Model_consistency_status_message, null);
		return status;
	}

	// collect contained statuses (links, capabilities, requirements)
	private void collectContainedStatuses(DeployModelObject deployObject, List<IStatus> statusList) {
		// add all of the statuses for this object to the list
		addStatus(statusList, deployObject);

		addConstraintStatuses(statusList, deployObject);

		///// IF ERROR MARKER IS ON A UNIT ////
		///// IF ERROR MARKER IS ON AN IMPORT ////
		// collect statuses of contained requirements, capabilities, links and link constraints
		// add new status for any contained compartment errors
		if (deployObject instanceof Unit || deployObject instanceof Import) {
			// if this unit/import contains links, requirements, etc.
			List<DeployModelObject> containedDmos = deployObject.getContainedModelObjects();
			if (!containedDmos.isEmpty()) {
				for (Iterator<DeployModelObject> iter = containedDmos.iterator(); iter.hasNext();) {
					DeployModelObject dmo = iter.next();

					// if contained dmo is a hosting link, only add status if link is invisible (source/target == null)
					if (dmo instanceof HostingLink) {
						HostingLink link = (HostingLink) dmo;
						if (link.getSource() == null || link.getTarget() == null) {
							addStatus(statusList, dmo);
						}
						// if contained dmo is a constraint link, only add status if link is invisible (source/target == null)
					} else if (dmo instanceof ConstraintLink) {
						ConstraintLink link = (ConstraintLink) dmo;
						if (link.getSource() == null || link.getTarget() == null) {
							addStatus(statusList, dmo);
						}
						// else add the statuses of anything else
					} else {
						addStatus(statusList, dmo);
					}
					// if contained dmo is a requirement/capability, add all of the constraint statuses to the list too
					if (dmo instanceof Requirement) {
						Requirement req = (Requirement) dmo;
						addConstraintStatuses(statusList, dmo);

						// Contained dependency link which would not be visible
						if (req.getLink() != null
								&& (req.getLink().getSource() == null || req.getLink().getTarget() == null)) {
							addStatus(statusList, req.getLink());
						}
					} else if (dmo instanceof Capability) {
						addConstraintStatuses(statusList, dmo);
					} else if (dmo instanceof Constraint) {
						addConstraintStatuses(statusList, dmo);
					}
				}
			}
			///// IF ERROR MARKER IS ON A LINK ////
			// just collect constraints
		} else if (deployObject instanceof DeployLink) {
			addConstraintStatuses(statusList, deployObject);
		}
	}

	// add statues for links to this unit that don't have an editpart
	private void collectHiddenLinkStatues(DeployModelObject deployObject, List<IStatus> statusList) {
		DeployDiagramEditPart ddep = GMFUtils.getDeployDiagramEditPart(ownerEP);
		Map<Unit, UnitLinkData> linkCacheMap = ddep.getSemanticCacheData().getLinkCacheMap();
		UnitLinkData linkData = linkCacheMap.get(deployObject);
		if (linkData == null) {
			return;
		}
		/*
		 * Links may not always be hidden. They may be visible but still a part of the parent
		 * container. In this case we still want to return them since they are still considered innner
		 * figure statuses. We must do it in this method since the connection edit parts are not owned
		 * by the ownerEP or any descendant of it.
		 */
		for (Iterator<HostingLink> it = linkData.getHostingLinks().iterator(); it.hasNext();) {
			HostingLink link = it.next();
			Collection<ConnectionNodeEditPart> connectionEPs = GMFUtils
					.getLinkEditPartsFor(ddep, link);
			if (deployObject.equals(link.getTarget())
					&& (hasInvisibleConnections(connectionEPs) || hasConnectionForParent(connectionEPs,
							ownerEP))) {
				addStatus(statusList, link);
				addConstraintStatuses(statusList, link);
			}
		}
		for (Iterator<ConstraintLink> it = linkData.getConstraintLinks().iterator(); it.hasNext();) {
			ConstraintLink link = it.next();
			Collection<ConnectionNodeEditPart> connectionEPs = GMFUtils
					.getLinkEditPartsFor(ddep, link);
			if (deployObject.equals(GMFUtils.getUnit(link.getTarget()))
					&& (hasInvisibleConnections(connectionEPs) || hasConnectionForParent(connectionEPs,
							ownerEP))) {
				addStatus(statusList, link);
				addConstraintStatuses(statusList, link);
			}
		}
		for (Iterator<DependencyLink> it = linkData.getDependencyLinks().iterator(); it.hasNext();) {
			DependencyLink link = it.next();
			Collection<ConnectionNodeEditPart> connectionEPs = GMFUtils
					.getLinkEditPartsFor(ddep, link);
			if (deployObject.equals(GMFUtils.getUnit(link.getTarget()))
					&& (hasInvisibleConnections(connectionEPs) || hasConnectionForParent(connectionEPs,
							ownerEP))) {
				addStatus(statusList, link);
				addConstraintStatuses(statusList, link);
			}
		}
		for (Iterator<RealizationLink> it = linkData.getRealizationLinks().iterator(); it.hasNext();) {
			RealizationLink link = it.next();
			Collection<ConnectionNodeEditPart> connectionEPs = GMFUtils
					.getLinkEditPartsFor(ddep, link);
			if (deployObject.equals(link.getTarget()) && hasInvisibleConnections(connectionEPs)) {
				addStatus(statusList, link);
				addConstraintStatuses(statusList, link);
			}
		}
	}

	private boolean ownerIsTarget(Unit unit, GraphicalEditPart ownerEP2) {
		// TODO Auto-generated method stub
		return false;
	}

	private boolean hasInvisibleConnections(Collection<ConnectionNodeEditPart> connectionEPs) {
		for (ConnectionNodeEditPart linkEP : connectionEPs) {
			IFigure link = linkEP.getFigure();
			if (link.isVisible() || link instanceof DeployLinkConnection
					&& ((DeployLinkConnection) link).isConsolidated()) {
				return false;
			}
		}
		return true;
	}

	/*
	 * Check if any returned ConnectionNodeEditPart has source and target that are descendants of the
	 * parentEP.
	 */
	private boolean hasConnectionForParent(Collection<ConnectionNodeEditPart> connectionEPs,
			GraphicalEditPart parentEP) {
		for (Iterator<ConnectionNodeEditPart> it = connectionEPs.iterator(); it.hasNext();) {
			ConnectionNodeEditPart ep = it.next();
			EditPart targetEP = ep.getTarget();
			EditPart sourceEP = ep.getSource();
			if (isDescendant(targetEP, parentEP) && isDescendant(sourceEP, parentEP)) {
				return true;
			}
		}
		return false;
	}

	/*
	 * Is childEP a descendant of parentEP?
	 */
	private boolean isDescendant(EditPart childEP, GraphicalEditPart parentEP) {
		if (childEP != null) {
			EditPart ep = childEP.getParent();
			while (ep != null) {
				if (ep == parentEP) {
					return true;
				}
				ep = ep.getParent();
			}
		}
		return false;
	}

	/**
	 * Return a collection of {@link Units} that are visually contained within the visual
	 * representation of the passed deployObject.
	 * 
	 * @param deployObject
	 *           An {@link EObject} that can be a model object or a diagramatical object.
	 * @param editPart
	 *           The {@link IGraphicalEditPart} for the passed deployObject to be used for the
	 *           collecting.
	 * @param editPartMap
	 *           A {@link Map} used to cache child {@link IGraphicalEditPart}s so they may be
	 *           retrieved later.
	 * @param resolutionDepth
	 *           The depth to traverse children.
	 * 
	 * @return A {@link Collection} of {@link Units} without duplicates.
	 * 
	 * @see #INFINITE_RES_DEPTH
	 */
	public Collection<Unit> getCompartmentlizedUnits(EObject deployObject,
			IGraphicalEditPart editPart, Map<EObject, IGraphicalEditPart> editPartMap,
			int resolutionDepth) {
		Set<Unit> compartmentUnitSet = new HashSet<Unit>();
		if (deployObject instanceof Unit) {
			Unit unit = (Unit) deployObject;
			getCompartmentUnitList(unit, compartmentUnitSet, editPart, editPartMap, resolutionDepth);
		} else if (deployObject instanceof Diagram) {
			getCompartmentUnitList(null, compartmentUnitSet, editPart, editPartMap, resolutionDepth);
		} else if (deployObject instanceof Import) {
			Import imprt = (Import) deployObject;
			//If the editPartMap is not null we want to traverse the editParts.
			if (editPartMap != null) {
				//Traverse editParts
				getCompartmentUnitList(null, compartmentUnitSet, editPart, editPartMap, resolutionDepth);
			} else {
				InstanceConfiguration instanceConfig = imprt.getInstanceConfiguration();
				if (instanceConfig != null) {
					compartmentUnitSet.addAll(instanceConfig.getVisibleUnits());
				}
			}
		}
		return compartmentUnitSet;
	}

	// add UI compartment status (add "contained" error if any unit in tree/group has an error)
	private void addCompartmentStatus(EObject eObject, List<IStatus> statusList) {
		// collect all units in all contained UI compartments iterating downwards
		Collection<Unit> compartmentUnitSet = getCompartmentlizedUnits(eObject, null, null,
				INFINITE_RES_DEPTH);
		if (compartmentUnitSet.isEmpty()) {
			return;
		}

		// find the most serious error in these contained compartments
		int severity = IStatus.OK;
		for (Iterator<Unit> iter = compartmentUnitSet.iterator(); iter.hasNext();) {
			Unit compartmentUnit = iter.next();
			if (compartmentUnit == null) {
				continue;
			}
			IStatus curStatus = collectStatuses(compartmentUnit, false);
			if (curStatus.getSeverity() > severity) {
				severity = curStatus.getSeverity();
			}
		}

		// add a new "contained" status to the status list of the severity of 
		//  the most serious compartment status
		switch (severity)
		{
		case IStatus.ERROR:
			statusList.add(new Status(IStatus.ERROR, DeployCoreUIPlugin.PLUGIN_ID, 0,
					Messages.COMPARTMENT_CONTAINS_ERRORS, null));
			break;
		case IStatus.WARNING:
			statusList.add(new Status(IStatus.WARNING, DeployCoreUIPlugin.PLUGIN_ID, 0,
					Messages.ErrorMarkerDecorator_This_figure_contains_inner_figures_, null));
			break;
		case IStatus.INFO:
			statusList.add(new Status(IStatus.INFO, DeployCoreUIPlugin.PLUGIN_ID, 0,
					Messages.ErrorMarkerDecorator_This_figure_contains_inner_figures_, null));
			break;
		}
	}

	// add any constraint statues to status list
	private void addConstraintStatuses(List<IStatus> statusList, DeployModelObject dmo) {
		// MK 7/5/2007 replaced use of iterator with explicit loop after finding problem with 
		// call to hasNext() after DeployModelObject.getConstraints(); cf. Jazz Defect 2521
//		List<Constraint> constraints = dmo.getConstraints();
//		for (int i = 0; i < constraints.size(); i++) {
//			Constraint constraint = constraints.get(i);
//		for (Iterator it = dmo.getConstraints().iterator(); it.hasNext();) {
//			Constraint constraint = (Constraint) it.next();
//			addStatus(statusList, constraint);
//		}
		for (Constraint constraint : (List<Constraint>) dmo.getConstraints()) {
			addStatus(statusList, constraint);
			addConstraintStatuses(statusList, constraint);
		}
	}

	// helper method that adds all of the statuses from this dmo to a list
	private void addStatus(List<IStatus> statusList, DeployModelObject object) {
		IStatus status = object.getStatus();
		if (status == Status.OK_STATUS) {
			return;
		}
		if (!status.isMultiStatus()) {
			if (!statusList.contains(status)) {
				statusList.add(status);
			}
		} else {
			IStatus[] children = status.getChildren();
			for (int i = 0; i < children.length; i++) {
				// don't add if error already in list or if error is OK
				if (!statusList.contains(children[i]) && children[i].getSeverity() > 0) {
					statusList.add(children[i]);
				}
			}
		}
	}

	// collect status for every link contained by this consolidation link
	private void collectConsolidatedStatus(List<IStatus> statusList) {
		ConsolidationLinkEditPart consolidationLinkEP = (ConsolidationLinkEditPart) ownerEP;
		List<DeployConnectionNodeEditPart> consolidatedLinkList = consolidationLinkEP
				.getConsolidatedLinkList();
		// @jazz 6833 It's possible to get co-mod errors, so we copy the initial list to prevent modification		
		consolidatedLinkList = new ArrayList<DeployConnectionNodeEditPart>(consolidatedLinkList);
		for (Iterator<DeployConnectionNodeEditPart> it = consolidatedLinkList.iterator(); it
				.hasNext();) {
			DeployModelObject dmo = (DeployModelObject) it.next().resolveSemanticElement();
			if (dmo != null) {
				addStatus(statusList, dmo);
				addConstraintStatuses(statusList, dmo);
			}
		}
	}

	// put an error marker on a figure with a listener that opens the resolution dialog
	private void setShapeDecoration(IStatus status) {

//		System.out.println(getDeployObject().getDisplayName()
//				+ " has reso: " + statusResolutionsMap.get(getDeployObject())); //$NON-NLS-1$

		if (_figure == null) {
			_figure = new ErrorMarkerFigure(status, resolveMarkerImage(status), getDecoratorTarget());
			_figure.addMouseListener(getMouseListener());
			final GraphicalEditPart editpart = (GraphicalEditPart) getDecoratorTarget().getAdapter(
					GraphicalEditPart.class);
			Locator locator = new Locator() {
				public void relocate(IFigure target) {
					IFigure parentFigure = editpart.getFigure();
					Rectangle r = parentFigure.getBounds().getCopy();
					parentFigure.translateToAbsolute(r);
					target.translateToRelative(r);
					// if attribute is on a hosting list item we need to center it
					// Note: if decoration is missing, check Decoration.isVisible()
					Dimension size = _figure.getPreferredSize();
					if (isInnerHostingList) {
						int itemHeight = GEFUtils.getListItemHeight(parentFigure) / 2;
						r.x += 11 * Q;
						r.y += itemHeight - size.height / 2;
					} else {
						r.x += 4 * Q;
						r.y += r.height - size.height - Q;
					}
					r.setSize(size);
					target.setBounds(r);
					_figure.setSize(size);
				}
			};
			setDecoration(getDecoratorTarget().addDecoration(_figure, locator, true));
			_figure.validate();
		} else {
			_figure.setStatus(status, resolveMarkerImage(status));
		}
	}

	// put an error marker on a link with a listener that opens the resolution dialog
	private void setEdgeDecoration(IStatus status) {
		if (_figure == null) {
			_figure = new ErrorMarkerFigure(status, resolveMarkerImage(status), getDecoratorTarget());
			_figure.addMouseListener(getMouseListener());
			IFigure hostFigure = ((GraphicalEditPart) getDecoratorTarget().getAdapter(
					GraphicalEditPart.class)).getFigure();
			Locator locator = new ConnectionLocator((Connection) hostFigure) {
				protected org.eclipse.draw2d.geometry.Point getLocation(PointList points) {
					org.eclipse.draw2d.geometry.Point p = PointListUtilities
							.calculatePointRelativeToLine(PointListUtilities.copyPoints(points), 0, 50,
									true);
					return p;
				}

				public void relocate(IFigure target) {
					Dimension size = _figure.getPreferredSize();
					org.eclipse.draw2d.geometry.Point center = getReferencePoint();
					target.translateToRelative(center);
					target.setBounds(getNewBounds(size, center));
					_figure.setSize(size);
				}

			};
			setDecoration(getDecoratorTarget().addDecoration(_figure, locator, true));
		} else {
			_figure.setStatus(status, resolveMarkerImage(status));
		}
	}

	private Image resolveMarkerImage(IStatus status) {
		EObject element = resolveElement();
		if (element != null || isConsolidationLink) {
			Boolean hasResolutions = statusResolutionsMap.get(getResolutionMapKey());
			if (hasResolutions != null) {
				return ErrorMarkerFigureFactory.getRegularFigureImage(status.getSeverity(),
						hasResolutions.booleanValue(), false);
			}
		}
//		calculateResolutionsJob.enqueue(this, resolveElement());
//		calculateResolutionsJob.schedule(DELAY);
		return ErrorMarkerFigureFactory.getRegularFigureImage(status.getSeverity(), false, false);

	}

	// listen to decoration we add to edge or shape
	private MouseListener getMouseListener() {
		if (_mouseListener == null) {
			synchronized (lock) {
				if (_mouseListener == null) {
					_mouseListener = new MouseListener() {

						public void mousePressed(MouseEvent me) {
							if (isActivated) {
								onMousePressed(me);
							}
						}

						public void mouseReleased(MouseEvent me) {
						}

						public void mouseDoubleClicked(MouseEvent me) {
						}

					};
				}

			}
		}
		return _mouseListener;
	}

	// the command we execute when decoration is clicked
	protected void onMousePressed(MouseEvent me) {
		if (me.button == 1) {
			EditPart editPart = (EditPart) getDecoratorTarget().getAdapter(EditPart.class);

			DeployModelObject deployObject = getDeployObject(true);
			if (deployObject != null || isConsolidationLink || isDiagramNodeErrorMarker) {

				View view = (View) getDecoratorTarget().getAdapter(View.class);
				IStatus status = collectStatuses(view.getElement(), false);

				org.eclipse.draw2d.geometry.Point pt = new org.eclipse.draw2d.geometry.Point(me.x, me.y);
				Object source = me.getSource();
				ErrorMarkerFigure figure = null;
				if (source instanceof ErrorMarkerFigure) {
					figure = (ErrorMarkerFigure) source;
					pt = figure.getBounds().getBottomRight().getCopy();
					figure.translateToAbsolute(pt);
					org.eclipse.swt.graphics.Point p = new org.eclipse.swt.graphics.Point(0, 0);
					p = editPart.getViewer().getControl().toDisplay(p);
					pt.x += p.x;
					pt.y += p.y;
				}
				((DeployGraphicalViewer) editPart.getViewer()).closeToolTip();
				CreateQuickFixPopupRequest request = new CreateQuickFixPopupRequest(status, new Point(
						pt.x, pt.y), this);
				final Command cmd = editPart.getCommand(request);
				if (cmd != null && cmd.canExecute()) {
					new UIJob(Messages.ErrorMarkerDecorator_Calculating_quickfixes_) {
						public IStatus runInUIThread(IProgressMonitor monitor) {
							cmd.execute();
							return Status.OK_STATUS;
						}
					}.schedule();
				}
			}
		}
	}

	/**
	 * =======================HELPER =======================================================
	 * 
	 * @param editPart
	 * @param editPartMap
	 * 
	 * @param deployObject
	 * @param containedObjectList
	 */

	/*
	 * use updateContainedObjectListHelper() to get all eObjects contained by this unit in group or
	 * host lists or contained groups and host lists and then add to map and listeners
	 */
	private void getCompartmentUnitList(Unit unit, Set<Unit> compartmentUnitSet,
			IGraphicalEditPart editPart, Map<EObject, IGraphicalEditPart> editPartMap,
			int resolutionDepth) {
		// reentrantly get all units in contained UI compartments (tree lists within tree lists, groups within groups)
		IGraphicalEditPart targetEP = editPart;
		if (targetEP == null) {
			targetEP = (IGraphicalEditPart) getDecoratorTarget().getAdapter(IGraphicalEditPart.class);
		}
		updateContainedObjectListHelper(targetEP, compartmentUnitSet, editPartMap, resolutionDepth);
		// unit of the editpart we're sitting on has already been processed
		compartmentUnitSet.remove(unit);
	}

	private void updateContainedObjectListHelper(IGraphicalEditPart editpart,
			Set<Unit> compartmentUnitSet, Map<EObject, IGraphicalEditPart> editPartMap,
			int resolutionDepth) {
		if (editpart == null) {
			return;
		}
		// add the unit that belongs to this editpart to the list
		EObject eObj = ViewUtil.resolveSemanticElement((View) editpart.getModel());
		if (eObj instanceof Unit) {
			//Cache the editpart if the editPartMap is available.
			if (editPartMap != null) {
				editPartMap.put(eObj, editpart);
			}
			compartmentUnitSet.add((Unit) eObj);
		}
		//Short circuit based on resolutionDepth.
		if (!(resolutionDepth <= INFINITE_RES_DEPTH || resolutionDepth > 0)) {
			return;
		}
		// starting with the editpart that this error marker is sitting on:
		// if this editpart has a compartment, add all of its child editparts
		// only look for hosting lists, groups and business components compartments
		// (imports are loaded lazily and may not have editparts therefore we don't look for those)
		// then for each child editpart, see if it has a compartment and process its children editparts, etc.
		IGraphicalEditPart hybridEP = editpart
				.getChildBySemanticHint(DeployCoreConstants.HYBRIDSHAPES_SEMANTICHINT);
		if (hybridEP == null) {
			hybridEP = editpart.getChildBySemanticHint(DeployCoreConstants.HYBRIDLIST_SEMANTICHINT);
		}
		if (hybridEP != null) {
			Iterator it = hybridEP.getChildren().iterator();
			while (it.hasNext()) {
				// get object and add to list
				Object o = it.next();
				if (o instanceof IGraphicalEditPart) {
					updateContainedObjectListHelper((IGraphicalEditPart) o, compartmentUnitSet,
							editPartMap, resolutionDepth - 1);
				}
			}
		}

		IGraphicalEditPart diagramEP = editpart
				.getChildBySemanticHint(DeployCoreConstants.DIAGRAMNODELIST_SEMANTICHINT);
		if (diagramEP == null) {
			diagramEP = editpart
					.getChildBySemanticHint(DeployCoreConstants.DIAGRAMNODESHAPES_SEMANTICHINT);
		}
		if (diagramEP != null) {
			Iterator it = diagramEP.getChildren().iterator();
			while (it.hasNext()) {
				// get object and add to list
				Object o = it.next();
				if (o instanceof IGraphicalEditPart) {
					updateContainedObjectListHelper((IGraphicalEditPart) o, compartmentUnitSet,
							editPartMap, resolutionDepth - 1);
				}
			}
		}

		//Check for import list if editPartMap is not null.
		if (editPartMap != null) {
			IGraphicalEditPart importListEP = editpart
					.getChildBySemanticHint(DeployCoreConstants.IMPORTTOPOLOGYLIST_SEMANTICHINT);
			if (importListEP == null) {
				importListEP = editpart
						.getChildBySemanticHint(DeployCoreConstants.IMPORTTOPOLOGYSHAPES_SEMANTICHINT);
			}
			if (importListEP != null) {
				Iterator it = importListEP.getChildren().iterator();
				while (it.hasNext()) {
					// get object and add to list
					Object o = it.next();
					if (o instanceof IGraphicalEditPart) {
						updateContainedObjectListHelper((IGraphicalEditPart) o, compartmentUnitSet,
								editPartMap, resolutionDepth - 1);
					}
				}
			}
		}
	}

	// account for multiple decorations for this one decorator
	public void setDecoration(IDecoration decoration) {
		super.setDecoration(decoration);
		decorationList.add(decoration);
	}

	protected void removeDecoration() {
		if (getDecoration() != null) {
			decorationList.remove(getDecoration());
			super.removeDecoration();
			if (decorationList.size() == 0) {
				return;
			}
			for (Iterator<IDecoration> it = decorationList.iterator(); it.hasNext();) {
				getDecoratorTarget().removeDecoration(it.next());
			}
			decorationList.clear();
		}
	}

}
