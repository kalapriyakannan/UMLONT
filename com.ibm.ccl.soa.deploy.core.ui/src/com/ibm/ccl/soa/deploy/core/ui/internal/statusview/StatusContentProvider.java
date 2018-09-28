/*******************************************************************************
 * Copyright (c) 2003, 2007 IBM Corporation Licensed Material - Property of IBM. All rights reserved.
 *  
 * US Government Users Restricted Rights - Use, duplication or disclosure v1.0 restricted by GSA ADP
 * Schedule Contract with IBM Corp.
 * 
 * Contributors: IBM Corporation - initial API and implementation
 *******************************************************************************/
package com.ibm.ccl.soa.deploy.core.ui.internal.statusview;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

import org.eclipse.core.runtime.IStatus;
import org.eclipse.jface.viewers.ITreeContentProvider;
import org.eclipse.jface.viewers.Viewer;

import com.ibm.ccl.soa.deploy.core.ui.internal.statusview.filter.FilterConfig;

/**
 * Export View Content Provider
 * 
 * @author lynn
 * 
 */
public class StatusContentProvider implements ITreeContentProvider {
	/**
	 * Other Group name
	 */
	public static final String OTHERS = "Others"; //$NON-NLS-1$
	private StatusNode[] nodes = new StatusNode[0];
	protected IStatusViewConfig config = null;

	public Object[] getChildren(Object parentElement) {
		if (parentElement instanceof StatusGroup) {
			return ((StatusGroup) parentElement).getChildren();
		}

		return null;
	}

	public Object getParent(Object element) {
		if (element instanceof StatusNode) {
			return ((StatusNode) element).getParent();
		}
		return null;
	}

	public boolean hasChildren(Object element) {
		if (element instanceof ITreeNode) {
			return ((ITreeNode) element).hasChildren();
		}
		return false;
	}

	protected Object[] groupElements(List nodeList) {
		if (config.getSelectedGroup() == null) {
			return nodeList.toArray();
		}
		HashMap groupedResult = new HashMap();
		for (Iterator index = nodeList.iterator(); index.hasNext();) {
			StatusNode node = (StatusNode) index.next();
			String groupName = getGroupName(node);
			StatusGroup group = (StatusGroup) groupedResult.get(groupName);
			if (group == null) {
				group = new StatusGroup(groupName);
				groupedResult.put(groupName, group);
			}
			node.setParent(group);
		}
		if (groupedResult.entrySet() != null) {
			Object[] result = groupedResult.values().toArray();
			return result;
		}
		return new Object[0];
	}

	public Object[] getElements(Object inputElement) {
		if (config == null) {
			return nodes;
		}
		List filterResult = new ArrayList();
		//Filter
		FilterConfig fs = config.getSelectedFilter();
		for (int i = 0; i < nodes.length; i++) {
			if (fs.accept(nodes[i])) {
				filterResult.add(nodes[i]);
			}
		}
		return groupElements(filterResult);

	}

	public void dispose() {
		// TODO Auto-generated method stub

	}

	public void inputChanged(Viewer viewer, Object oldInput, Object newInput) {
		if (newInput instanceof IStatus[]) {
			IStatus[] contents = (IStatus[]) newInput;
			nodes = new StatusNode[contents.length];
			for (int i = 0; i < contents.length; i++) {
				nodes[i] = new StatusNode(contents[i]);
			}

		} else if (newInput instanceof IStatusViewConfig) {
			config = (IStatusViewConfig) newInput;
		}

	}

	private String getGroupName(StatusNode status) {
		String groupName;
		try {
			groupName = config.getSelectedGroup().getValue(status);
		} catch (NotSupportedTargetException e) {
			return OTHERS;
		}
		if (groupName == Messages.NULL_MESSAGE || groupName == null || groupName.equals("")) { //$NON-NLS-1$
			return OTHERS;
		}
		return groupName;
	}

}
