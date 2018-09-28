package com.ibm.ccl.soa.deploy.core.internal.synchronization;

import java.util.Collection;
import java.util.Map;
import java.util.TreeMap;

import org.eclipse.core.resources.IResource;
import org.eclipse.core.runtime.IPath;
import org.eclipse.core.runtime.Path;
import org.eclipse.ltk.core.refactoring.Change;
import org.eclipse.ltk.core.refactoring.CompositeChange;

import com.ibm.ccl.soa.deploy.core.DeployModelObject;

/**
 * Provides a wrapper that sorts added changes.
 * 
 */
public class SortedCompositeChange extends CompositeChange {

	public SortedCompositeChange(String name) {
		super(name);
	}

	/**
	 * Returns the children managed by this composite change.
	 * 
	 * @return the children of this change or an empty array if no children exist
	 */
	public Change[] getChildren() {
		Change[] children = super.getChildren();
		Map<ChangeProviderPriority, Change> sortedChildren = new TreeMap<ChangeProviderPriority, Change>();

		IPath path = null;
		ChangeProviderPriority prio = null;
		for (int i = 0; i < children.length; i++) {
			Object modifiedElement = children[i].getModifiedElement();

			if (modifiedElement instanceof IResource) {
				path = ((IResource) modifiedElement).getFullPath();
			} else if (modifiedElement instanceof DeployModelObject) {
				path = new Path(((DeployModelObject) modifiedElement).getFullPath());
			} else {
				path = null;
			}

			prio = new ChangeProviderPriority(path);
			sortedChildren.put(prio, children[i]);
		}
		Collection<Change> values = sortedChildren.values();
		return values.toArray(new Change[values.size()]);
	}

}
