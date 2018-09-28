package com.ibm.ccl.soa.deploy.core.ui;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

import org.eclipse.core.resources.IResource;
import org.eclipse.core.runtime.IPath;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.ListenerList;
import org.eclipse.core.runtime.Status;
import org.eclipse.core.runtime.jobs.ISchedulingRule;
import org.eclipse.jface.viewers.AbstractTreeViewer;
import org.eclipse.ui.progress.UIJob;

import com.ibm.ccl.soa.deploy.core.DeployCorePlugin;
import com.ibm.ccl.soa.deploy.core.namespace.INamespaceFragment;
import com.ibm.ccl.soa.deploy.core.namespace.INamespaceFragmentRoot;
import com.ibm.ccl.soa.deploy.core.namespace.NamespaceCore;
import com.ibm.ccl.soa.deploy.core.util.TopologyNamespaceUtil;

public class UpdateJob extends UIJob implements ISchedulingRule {

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
	public UpdateJob(AbstractTreeViewer managedViewer, long refreshDelay) {
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

		Object[] updateables = queue.getListeners();
		Set trackedUpdatedObjects = new HashSet();

		try {
			viewer.getControl().setRedraw(false);
			monitor.beginTask(Messages.ModelFilesRefreshManager_Updating_model_rendering_in_vie_,
					updateables.length);
			for (int i = 0; i < updateables.length && !monitor.isCanceled(); i++) {

				if (!trackedUpdatedObjects.contains(updateables[i])) {
					Set heirarchy = new HashSet();
					try {
						Object target = updateables[i];
						if (target instanceof IResource) {
							IResource resource = (IResource) target;
							if (resource.isAccessible()) {
								heirarchy.add(resource);
								while (null != resource) {
									resource = resource.getParent();
									if (null != resource && !heirarchy.contains(resource)
											&& resource.isAccessible()) {
										heirarchy.add(resource);
									}
								}
							}
						}
						convertToNamespaceElements(heirarchy);
						if (!heirarchy.isEmpty()) {
							viewer.update(heirarchy.toArray(new Object[heirarchy.size()]), null);
						}
					} catch (RuntimeException e) {
						DeployCorePlugin.log(IStatus.WARNING, 0, e.getMessage(), e);
					}
					trackedUpdatedObjects.addAll(heirarchy);
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

	private Set convertToNamespaceElements(Set targets) {

		Set replacements = new HashSet();
		for (Iterator iter = targets.iterator(); iter.hasNext();) {
			Object target = iter.next();
			if (target instanceof IResource) {
				IResource resource = (IResource) target;
				if (resource.getType() == IResource.FOLDER) {
					INamespaceFragmentRoot[] roots = NamespaceCore.locateRoots(resource.getProject(),
							null);
					for (int r = 0; r < roots.length; r++) {
						INamespaceFragmentRoot root = roots[r];
						if (root.getCorrespondingResource().getProjectRelativePath().isPrefixOf(
								resource.getProjectRelativePath())) {
							IPath path = resource.getProjectRelativePath().removeFirstSegments(
									root.getCorrespondingResource().getProjectRelativePath().segmentCount());
							INamespaceFragment namespace = root.getNamespaceFragment(TopologyNamespaceUtil
									.concatWith(path.segments(), TopologyNamespaceUtil.C_DOT));
							replacements.add(namespace);
							iter.remove();
						}
					}
				}
			}
		}

		targets.addAll(replacements);
		return targets;
	}
}
