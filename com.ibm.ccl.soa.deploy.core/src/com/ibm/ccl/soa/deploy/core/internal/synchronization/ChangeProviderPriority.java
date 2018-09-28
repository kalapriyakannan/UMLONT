package com.ibm.ccl.soa.deploy.core.internal.synchronization;

import org.eclipse.core.resources.IResource;
import org.eclipse.core.runtime.IPath;

import com.ibm.ccl.soa.deploy.core.DeployModelObject;

/**
 * a priority based on the given path. More specific paths have lower priorities, and will act last
 * in their attempt to modify resources or Units.
 * 
 */
public class ChangeProviderPriority implements Comparable<ChangeProviderPriority> {

	/**
	 * A priority that will place the change at the end of possible changes.
	 */
	public static final ChangeProviderPriority DEFAULT = new ChangeProviderPriority(null);

	private static final int LESS_THAN = -1;
	private static final int EQUALS = 0;
	private static final int GREATER_THAN = +1;

	private final IPath prio;

	/**
	 * Create a priority based on the given path. More specific paths have lower priorities, and will
	 * act last in their attempt to modify resources or Units.
	 * 
	 * @param path
	 *           The path of the affected object. This could be the
	 *           {@link DeployModelObject#getFullPath()} of a {@link DeployModelObject}, or the
	 *           {@link IResource#getFullPath()} of an {@link IResource}.
	 */
	public ChangeProviderPriority(IPath path) {
		prio = path;
	}

	/**
	 * Return the path of the affected object. This could be the
	 * {@link DeployModelObject#getFullPath()} of a {@link DeployModelObject}, or the
	 * {@link IResource#getFullPath()} of an {@link IResource}.
	 * 
	 * @return The path of the affected object. This could be the
	 *         {@link DeployModelObject#getFullPath()} of a {@link DeployModelObject}, or the
	 *         {@link IResource#getFullPath()} of an {@link IResource}.
	 */
	public IPath getPrio() {
		return prio;
	}

	public int compareTo(ChangeProviderPriority rvalue) {
		if (rvalue instanceof ChangeProviderPriority) {

			ChangeProviderPriority rprio = rvalue;

			if (prio == null) {
				if (rprio.getPrio() != null) {
					return GREATER_THAN;
				}
				return EQUALS;
			}

			// if the current prio is more specific 
			if (prio.segmentCount() > rprio.getPrio().segmentCount()) {
				return GREATER_THAN;
			} else if (prio.segmentCount() < rprio.getPrio().segmentCount()) {
				return LESS_THAN;
			}

			if (prio.equals(rprio.getPrio())) {
				return EQUALS;
			}
			return prio.toString().compareTo(rprio.getPrio().toString());

		}
		return LESS_THAN;
	}

}
