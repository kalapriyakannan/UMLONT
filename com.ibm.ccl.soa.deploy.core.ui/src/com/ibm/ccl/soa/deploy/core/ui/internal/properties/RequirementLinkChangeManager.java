/***************************************************************************************************
 * Copyright (c) 2003, 2007 IBM Corporation Licensed Material - Property of IBM. All rights
 * reserved.
 * 
 * US Government Users Restricted Rights - Use, duplication or disclosure v1.0 restricted by GSA ADP
 * Schedule Contract with IBM Corp.
 * 
 * Contributors: IBM Corporation - initial API and implementation
 **************************************************************************************************/

package com.ibm.ccl.soa.deploy.core.ui.internal.properties;

import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.jobs.Job;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.impl.AdapterImpl;
import org.eclipse.ui.progress.UIJob;

import com.ibm.ccl.soa.deploy.core.CorePackage;
import com.ibm.ccl.soa.deploy.core.Topology;
import com.ibm.ccl.soa.deploy.core.ui.internal.popup.Messages;

/**
 * This class is to be used by clients to handle the addition and removal of HostingLinks or
 * DependencyLinks anywhere within a {@link Topology}.
 * 
 * @since 7.0
 * 
 */
public class RequirementLinkChangeManager extends AdapterImpl {

	/**
	 * An interface used by clients of the {@link RequirementLinkChangeManager} to handle additions
	 * and removals of hosting/dependency links.
	 * 
	 * @since 7.0
	 */
	public static interface RequirementLinkChangeHandler {
		/**
		 * A hosting/dependency link has been added or deleted. The notifcation element provides more
		 * information. This method is guaranteed to run in the UI thread.
		 * 
		 * @param notification
		 *           The {@link Notification} element for the event.
		 * @return An {@link IStatus} for the result of handling the event.
		 */
		IStatus handleRequirementLinkChange(Notification notification);
	}

	private Job topologyListenerJob;
	private final Topology topology;
	private final RequirementLinkChangeHandler handler;
	private Notification handledNotification;

	/**
	 * Construct a new RequirementLinkChangeManager. The parameters may not be null. Be sure to call
	 * {@link #dispose()} when finished listening for hosting link changes.
	 * 
	 * @param aTopology
	 *           The {@link Topology} which is being edited.
	 * @param aHandler
	 *           A {@link RequirementLinkChangeHandler} that will handle the hosting link changes.
	 * 
	 * @see #dispose()
	 */
	public RequirementLinkChangeManager(Topology aTopology, RequirementLinkChangeHandler aHandler) {
		assert aTopology != null;
		assert aHandler != null;
		handler = aHandler;
		topology = aTopology;
		registerTopologyListener();
	}

	private void registerTopologyListener() {
		topology.addTopologyListener(this, CorePackage.Literals.DEPLOY_CORE_ROOT__LINK_HOSTING);
		topology.addTopologyListener(this, CorePackage.Literals.REQUIREMENT__LINK);
		topology.addTopologyListener(this, CorePackage.Literals.DEPLOY_CORE_ROOT__LINK_DEPENDENCY);
	}

	/**
	 * This method must be called by clients when they are finished listening for changes. This
	 * {@link RequirementLinkChangeManager} may no longer be used after this method is called.
	 */
	public void dispose() {
		if (topology != null) {
			topology.removeTopologyListener(this, CorePackage.Literals.DEPLOY_CORE_ROOT__LINK_HOSTING);
			topology.removeTopologyListener(this, CorePackage.Literals.REQUIREMENT__LINK);
			topology.removeTopologyListener(this,
					CorePackage.Literals.DEPLOY_CORE_ROOT__LINK_DEPENDENCY);
		}
	}

	@Override
	public void notifyChanged(Notification msg) {
		if (msg.getEventType() != Notification.REMOVING_ADAPTER) {
			handledNotification = msg;
			getTopologyListenerJob().schedule(500);
		}
	}

	private Job getTopologyListenerJob() {
		if (topologyListenerJob == null) {
			topologyListenerJob = new UIJob(
					Messages.HostingLinkChangeListener_Updating_UI_for_hosting_link_modifi_) {
				@Override
				public IStatus runInUIThread(IProgressMonitor monitor) {
					return handler.handleRequirementLinkChange(handledNotification);
				}
			};
			topologyListenerJob.setSystem(true);
		}
		return topologyListenerJob;
	}
}
