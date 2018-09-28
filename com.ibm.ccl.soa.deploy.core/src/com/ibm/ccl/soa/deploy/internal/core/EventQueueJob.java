package com.ibm.ccl.soa.deploy.internal.core;

import org.eclipse.core.resources.IWorkspaceRunnable;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.ListenerList;
import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.core.runtime.Status;
import org.eclipse.core.runtime.SubProgressMonitor;
import org.eclipse.core.runtime.jobs.ISchedulingRule;
import org.eclipse.core.runtime.jobs.Job;

import com.ibm.ccl.soa.deploy.core.DeployCorePlugin;

/**
 * Describes a generic event mechanism to process Workspace Runnables using a simple queueing job.
 * 
 */
public class EventQueueJob extends Job {

	/**
	 * Create a Job with the given name.
	 * 
	 * @param name
	 *           The display name of the Job
	 */
	public EventQueueJob(String name) {
		super(name);
	}

	/**
	 * Create a Job with the given name.
	 * 
	 * @param name
	 *           The display name of the Job
	 * @param rule
	 *           The scheduling rule to use when scheduling the Job.
	 */
	public EventQueueJob(String name, ISchedulingRule rule) {
		super(name);
		setRule(rule);
	}

	private final ListenerList queue = new ListenerList() {
		public synchronized Object[] getListeners() {
			Object[] data = super.getListeners();
			clear();
			return data;
		}
	};

	/**
	 * Enqueue the given runnable to be processed the next time the Job runs.
	 * 
	 * @param runnable
	 *           The runnable will be executed using its proposed rule the next time the Job runs.
	 */
	public void enqueue(IWorkspaceAssistant runnable) {
		queue.add(runnable);
	}

	protected IStatus run(IProgressMonitor monitor) {
		if (monitor == null) {
			monitor = new NullProgressMonitor();
		}

		final Object[] runnables = queue.getListeners();
		try {
			monitor.beginTask("", runnables.length); //$NON-NLS-1$

			for (int i = 0; i < runnables.length; i++) {

				ResourcesPlugin.getWorkspace().run(
						(IWorkspaceRunnable) runnables[i],
						new SubProgressMonitor(monitor, 1,
								SubProgressMonitor.PREPEND_MAIN_LABEL_TO_SUBTASK));
			}
		} catch (CoreException e) {
			DeployCorePlugin.logError(0, e.getMessage(), e);
		} finally {
			monitor.done();
		}
		return Status.OK_STATUS;
	}
}
