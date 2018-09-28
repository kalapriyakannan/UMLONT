/***************************************************************************************************
 * Copyright (c) 2006 IBM Corporation. Licensed Material - Property of IBM. All rights reserved. US
 * Government Users Restricted Rights - Use, duplication or disclosure restricted by GSA ADP
 * Schedule Contract with IBM Corp.
 * 
 * Contributors: IBM Corporation - initial API and implementation
 **************************************************************************************************/
package com.ibm.ccl.soa.deploy.core.ui.navigator.deploy;

import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.jface.viewers.AbstractTreeViewer;
import org.eclipse.ui.progress.UIJob;

import com.ibm.ccl.soa.deploy.core.ui.Messages;

/**
 * 
 * Removes the pending node from the viewer without flickering.
 * 
 */
public class ClearPlaceHolderJob extends UIJob {

	private final AbstractTreeViewer viewer;
	private final LoadingModelNode placeHolder;
	private final Object[] addedChildren;
	private final Object[] removedChildren;
	private final Object parent;

	public ClearPlaceHolderJob(AbstractTreeViewer viewer, LoadingModelNode placeHolder,
			Object parent, Object[] addedChildren, Object[] removedChildren) {
		super(Messages.ClearPlaceHolderJob_Updating_viewer_);
		this.viewer = viewer;
		this.placeHolder = placeHolder;
		this.parent = parent;
		this.addedChildren = addedChildren;
		this.removedChildren = removedChildren;
		setRule(new NonConflictingRule());
	}

	public IStatus runInUIThread(IProgressMonitor monitor) {
		try {
			viewer.getControl().setRedraw(false);
			viewer.remove(placeHolder);
			if (removedChildren.length > 0) {
				viewer.remove(removedChildren);
			}
			if (addedChildren.length > 0) {
				viewer.add(parent, addedChildren);
			}
		} finally {
			viewer.getControl().setRedraw(true);
		}
		return Status.OK_STATUS;
	}

}
