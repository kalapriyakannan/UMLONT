/***************************************************************************************************
 * Copyright (c) 2003, 2007 IBM Corporation Licensed Material - Property of IBM. All rights
 * reserved.
 * 
 * US Government Users Restricted Rights - Use, duplication or disclosure v1.0 restricted by GSA ADP
 * Schedule Contract with IBM Corp.
 * 
 * Contributors: IBM Corporation - initial API and implementation
 **************************************************************************************************/
package com.ibm.ccl.soa.deploy.core.ui;

import java.util.HashSet;
import java.util.Set;

import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.ListenerList;
import org.eclipse.core.runtime.Status;
import org.eclipse.core.runtime.jobs.ISchedulingRule;
import org.eclipse.jface.viewers.AbstractTreeViewer;
import org.eclipse.ui.progress.UIJob;

import com.ibm.ccl.soa.deploy.core.DeployCorePlugin;

public class RefreshJob extends UIJob implements ISchedulingRule {

	private final ListenerList queue = new ListenerList() {

		public synchronized Object[] getListeners() {
			Object[] data = super.getListeners();
			clear();
			return data;

		}
	};

	private final AbstractTreeViewer viewer;
	private final long delay;

	/**
	 * Construct a job that can handle smart refreshes of viewers in the UI thread.
	 * 
	 * @param manager
	 *           TODO
	 * 
	 */
	public RefreshJob(AbstractTreeViewer managedViewer, long refreshDelay) {
		super(Messages.ModelFilesRefreshManager_Updating_model_rendering_in_vie_);
		viewer = managedViewer;
		delay = refreshDelay;
		setRule(this);
	}

	/**
	 * Enqueue the given resource for refresh in the viewer. Refreshes affect the given node and the
	 * children for the node.
	 * 
	 * @param refeshable
	 *           A non-null object to refresh in the viewer.
	 */
	public void enqueue(Object refeshable) {
		queue.add(refeshable);
		schedule(delay);
	}

	public IStatus runInUIThread(IProgressMonitor monitor) {

		// refresh the viewer for the given objects in the queue

		if (viewer.getControl().isDisposed()) {
			return Status.OK_STATUS;
		}

		Object[] refreshables = queue.getListeners();
		Set trackedRefreshedObjects = new HashSet();

		try {
			viewer.getControl().setRedraw(false);
			monitor.beginTask(Messages.ModelFilesRefreshManager_Updating_model_rendering_in_vie_,
					refreshables.length);
			for (int i = 0; i < refreshables.length && !monitor.isCanceled(); i++) {

				if (!trackedRefreshedObjects.contains(refreshables[i])) {
					try {
						viewer.refresh(refreshables[i], true);
					} catch (RuntimeException e) {
						DeployCorePlugin.log(IStatus.WARNING, 0, e.getMessage(), e);
					}
					trackedRefreshedObjects.add(refreshables[i]);
				}

				monitor.worked(1);
			}
		} finally {
			if (!viewer.getControl().isDisposed()) {
				viewer.getControl().setRedraw(true);
			}
			monitor.done();
		}
		return Status.OK_STATUS;
	}

	public boolean contains(ISchedulingRule rule) {
		return rule == this;
	}

	public boolean isConflicting(ISchedulingRule rule) {
		return rule == this;
	}
}
