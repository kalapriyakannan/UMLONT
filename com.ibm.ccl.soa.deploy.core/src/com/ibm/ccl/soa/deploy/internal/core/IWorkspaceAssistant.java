package com.ibm.ccl.soa.deploy.internal.core;

import org.eclipse.core.resources.IWorkspaceRunnable;
import org.eclipse.core.runtime.jobs.ISchedulingRule;

/**
 * An assistant to handle the work of updating the workspace based on a model file change event.
 * 
 */
public interface IWorkspaceAssistant extends IWorkspaceRunnable {

	/**
	 * Return a scheduling rule appropriate for this IWorkspaceAssistant.
	 * 
	 * @return A scheduling rule appropriate for this IWorkspaceAssistant.
	 */
	public ISchedulingRule getSchedulingRule();
}
