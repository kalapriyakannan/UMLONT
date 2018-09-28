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

import java.util.Iterator;
import java.util.List;

import org.eclipse.draw2d.IFigure;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.impl.NotificationImpl;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.util.EContentAdapter;
import org.eclipse.gef.EditPart;
import org.eclipse.gef.EditPolicy;
import org.eclipse.gef.Request;
import org.eclipse.gef.commands.Command;
import org.eclipse.gmf.runtime.diagram.ui.editparts.IGraphicalEditPart;
import org.eclipse.gmf.runtime.gef.ui.internal.editpolicies.GraphicalEditPolicyEx;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.gmf.runtime.notation.impl.NodeImpl;
import org.eclipse.swt.widgets.Display;

import com.ibm.ccl.soa.deploy.core.MemberLink;
import com.ibm.ccl.soa.deploy.core.Unit;
import com.ibm.ccl.soa.deploy.core.ui.actions.FilterPreferenceAction;
import com.ibm.ccl.soa.deploy.core.ui.editparts.DeployShapeNodeEditPart;
import com.ibm.ccl.soa.deploy.core.ui.figures.DeployCoreFigure;
import com.ibm.ccl.soa.deploy.core.ui.figures.DeployListItemFigure;
import com.ibm.ccl.soa.deploy.core.ui.figures.core.CompositeShapeFigure;
import com.ibm.ccl.soa.deploy.core.ui.preferences.IDeployPreferences;
import com.ibm.ccl.soa.deploy.core.ui.util.DeployCoreConstants;
import com.ibm.ccl.soa.deploy.core.ui.util.GMFUtils;

/**
 * This edit policy is used to refresh the duplicate tag and index on the view.
 * 
 * @author <a href="mailto:sunyingl@cn.ibm.com">Neo Sun</a>
 */
public class DuplicateEditPolicy extends GraphicalEditPolicyEx {
	/**
	 * Notification event types for member link creation and remove
	 */
	private static int MEMBER_LINK_CREATE = 10000;
	private static int MEMBER_LINK_DESTROY = 20000;

	private Unit hostUnit;
	private View hostView;

	/**
	 * This listener is installed on the unit to get notification about member link creation and
	 * remove, and then refresh the duplicate tag and index.
	 */
	private final EContentAdapter refreshListener = new EContentAdapter() {
		public void notifyChanged(final Notification notification) {
			super.notifyChanged(notification);

			if (notification.getEventType() == MEMBER_LINK_CREATE
					|| notification.getEventType() == MEMBER_LINK_DESTROY) {
				// Refresh the duplicate tag and index
				refreshDuplicate();
			}
		}
	};

	/**
	 * This listener is used to forward the notification about member link creation and remove to the
	 * source unit of member link when a member link is created from unit to unit group. Whereafter,
	 * duplicate edit policies receiving the notification will refresh its duplicate tag and index.
	 */
	private final EContentAdapter forwardListener = new EContentAdapter() {
		public void notifyChanged(final Notification notification) {
			super.notifyChanged(notification);

			/**
			 * If this notification is from the member link creation, then create a new notification
			 * and notify the link target member.
			 */
			if (notification.getEventType() == Notification.SET
					&& notification.getNewValue() instanceof MemberLink) {
				MemberLink memberLink = (MemberLink) notification.getNewValue();
				final Unit targetMember = memberLink.getTarget();

				final Notification forwardNotification = new NotificationImpl(MEMBER_LINK_CREATE, null,
						memberLink);

				Display display = Display.getCurrent() != null ? Display.getCurrent() : Display
						.getDefault();
				display.asyncExec(new Runnable() {
					public void run() {
						targetMember.eNotify(forwardNotification);
					}
				});
			} else if (notification.getEventType() == Notification.SET
					&& notification.getOldValue() instanceof MemberLink) {
				MemberLink memberLink = (MemberLink) notification.getOldValue();
				final Unit targetMember = memberLink.getTarget();

				final Notification forwardNotification = new NotificationImpl(MEMBER_LINK_DESTROY,
						memberLink, null);

				Display display = Display.getCurrent() != null ? Display.getCurrent() : Display
						.getDefault();
				display.asyncExec(new Runnable() {
					public void run() {
						targetMember.eNotify(forwardNotification);
					}
				});
			}
		}
	};

	public void activate() {
		hostView = (View) getHost().getModel();
		hostUnit = (Unit) ((View) getHost().getModel()).getElement();
		refreshAllDuplicates();
	}

	public void deactivate() {
		refreshAllDuplicates();
	}

	public void refresh() {
		if (hostUnit != null) {
			refreshDuplicate();
		}
	}

	/**
	 * Refresh the duplicate tag and index according to current status
	 */
	private void refreshDuplicate() {
		// turn off if user doesn't want it
		if (FilterPreferenceAction.isFiltered(IDeployPreferences.DEPLOY_FILTER_DUP_VIEW_INDICATORS,
				(IGraphicalEditPart) getHost())) {
			setDuplicateIndexStr(null);
			return;
		}

		if (hostView.getDiagram() == null) {
			return;
		}

		if (hostUnit.getTopology() == null) {
			return;
		}

		// Get the number of duplicates
		int duplicateNumber = getDuplicateNumber();

		// Refresh the duplicate tag and index
		if (duplicateNumber > 1) {
			// Refresh the duplicate index 
			StringBuffer sb = new StringBuffer();
			sb.append(' ').append(' ').append('(').append(duplicateNumber).append(')');
			setDuplicateIndexStr(sb.toString());
		} else {
			setDuplicateIndexStr(null);
		}
	}

	private void setDuplicateIndexStr(String indexStr) {
		CompositeShapeFigure compositeFigure = (CompositeShapeFigure) getHostFigure();
		IFigure innerFigure = compositeFigure.getInnerFigure();
		if (innerFigure instanceof DeployCoreFigure) {
			((DeployCoreFigure) innerFigure).setDuplicateIndex(indexStr);
		} else if (innerFigure instanceof DeployListItemFigure) {
			((DeployListItemFigure) innerFigure).setDuplicateIndex(indexStr);
		}
	}

	private int getDuplicateNumber() {
		List dupEPList = GMFUtils.getEditPartsFor(getHost().getViewer(), hostUnit);
		return dupEPList.size();
	}

	private void refreshAllDuplicates() {
		Display.getDefault().asyncExec(new Runnable() {
			public void run() {
				List epList = GMFUtils.getEditPartsFor(getHost().getViewer(), hostUnit);
				for (int i = 0; i < epList.size(); i++) {
					EditPart ep = (EditPart) epList.get(i);
					if (ep.getModel() instanceof NodeImpl) {
						// don't force the resolution
						EObject element = ((NodeImpl) ep.getModel()).basicGetElement();
						if (element == null || element.eIsProxy()) {
							continue;
						}
					}
					//5277: Check if active first.
					if (ep.isActive() && !ep.getViewer().getControl().isDisposed()) {
						ep.refresh();
					}
				}
			}
		});
	}

	public Command getCommand(Request request) {
		return null;
	}

	/**
	 * refresh the dup view count on all editparts
	 * 
	 * @param children
	 */
	public static void refreshDupIndicators(List<?> children) {
		for (Iterator<?> it = children.iterator(); it.hasNext();) {
			Object ep = it.next();
			if (ep instanceof DeployShapeNodeEditPart) {
				DeployShapeNodeEditPart dsep = (DeployShapeNodeEditPart) ep;
				EditPolicy policy = dsep.getEditPolicy(DeployEditPolicyRoles.DUPLICATE_ROLE);
				if (policy instanceof DuplicateEditPolicy) {
					((DuplicateEditPolicy) policy).refresh();
				}
				refreshCompartmentView(dsep, DeployCoreConstants.HYBRIDSHAPES_SEMANTICHINT);
				refreshCompartmentView(dsep, DeployCoreConstants.IMPORTTOPOLOGYLIST_SEMANTICHINT);
				refreshCompartmentView(dsep, DeployCoreConstants.DIAGRAMNODELIST_SEMANTICHINT);
				refreshCompartmentView(dsep, DeployCoreConstants.HYBRIDLIST_SEMANTICHINT);
			}
		}
	}

	private static void refreshCompartmentView(DeployShapeNodeEditPart editpart, String semantichint) {
		IGraphicalEditPart ep = editpart.getChildBySemanticHint(semantichint);
		if (ep != null) {
			refreshDupIndicators(ep.getChildren());
		}
	}

}
